/*
* Author 1: Fatema Moharam
* ID: 6655
*
* Author 2: Nourhan Waleed
* ID: 6609
*/


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.*;
import model.Data.*;
import View.*;

import javax.xml.bind.*;
import java.io.File;
import java.util.List;

import static javax.xml.bind.JAXBContext.newInstance;

/*This is the controller*/
public class Main extends Application {
    Restaurant restaurant;
    Reservations reservations;
    User currentUser;
    Stage stage;
    Person model;
    Table table;
    double bill;
    View view = new View();

    Files inputpath = Files.INPUT;
    Files reservationsPath = Files.RESERVATIONS;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        stage.setTitle("Welcome to our restaurant");
        initializeXML();
        view.getLogout().setOnAction(e->{
            login();
        });
        stage.setOnCloseRequest(e->{
            e.consume();
            handleCloseButton();
        });
        login();
        stage.show();
    }

    void initializeXML()throws JAXBException
    {
        JAXBContext jaxbcontext = newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        try {
            restaurant = (Restaurant) unmarshaller.unmarshal(new File(inputpath.getPath()));
        }catch (Exception e){
            AlertBox.display("Error","File not found!");
        }
    }
    void handleLoginButton(String username,String password)
    {
        for (User x : restaurant.getUsers().getUsers()){
            if (username.equals(x.getUsername())){
                currentUser = x;
                if (!password.equals(currentUser.getPassword())){
                    AlertBox.display("Wrong password","The password you entered is incorrect.");
                    return;
                }else {
                    switch (currentUser.getRole()) {
                        case "Employee":
                            model = new Employee();
                            loadData();
                            showReservations();
                            break;
                        case "Cooker":
                            model= new Employee();
                            showOrdersforCook();
                            break;
                        case "Waiter":
                             model= new Employee();
                            loadData();
                             showReservationsforWaiter();
                            break;
                        case "Client":
                            model = new Client();
                            loadData();
                            findTable();
                    }
                }
                return;
            }
        }AlertBox.display("User not found","You entered a wrong username");
    }
    void loadData(){
        try {
            reservations = model.loadReservations(reservationsPath.getPath());
        }catch (Exception e) {
            reservations = new Reservations();
            reservations.setTotalmoney(0);
        }
    }
    /*Client handling*/
    void findTable(){
        stage.setScene(view.findTable());
        view.getNext().setOnAction(e-> handleFindTable(view.getInput().getText(),view.getCheckBox().isSelected()));
        view.getBack().setOnAction(e->login());
    }
    void handleFindTable(String seatsInput,boolean smoking){
        int numofseats;
        try{
            numofseats = Integer.parseInt(seatsInput);
        }catch (NumberFormatException e){
            AlertBox.display("Invalid input",seatsInput + "is not a number");
            return;
        }
        if (numofseats <13 && numofseats>1){
            boolean found;
            try {
                table = model.findTable(restaurant.getTables(),numofseats,smoking);
                if (table.getNumber() == 0)
                    found = false;
                else
                    found = true;
            }catch (Exception e){found = false;}
            if (found){
                orderDishes();
            }
            else
                AlertBox.display("Sorry","We couldn't find a table with the specified requirements");
        }else {
            AlertBox.display("Invalid input","Please enter a number of seats between 4 and 12");
        }
    }

    private void orderDishes() {
        stage.setScene(view.menu());

        view.getChoiceBox().getItems().addAll(restaurant.getDishes().getDishes());
        view.getBillLabel().setText("Bill = "+bill+" L.E.");
        view.getDelete().setOnAction(e->handleDeleteDish());
        view.getAdd().setOnAction(e->handleAddDish(view.getTableView(),view.getChoiceBox().getValue(),view.getInput().getText()));

        view.getBack().setOnAction(e->findTable());
        view.getNext().setOnAction(e->handleConfirmOrder(view.getTableView().getItems(),bill));
    }

    private void handleConfirmOrder(ObservableList<Dish> dishes,double bill) {
        try {
            reservations.add(model.addReservation(currentUser.getName(),bill,table,dishes),bill);
            model.save(reservations,reservationsPath.getPath(),restaurant,inputpath.getPath());
            AlertBox.display("SUCCESS","Order placed successfully.");
            findTable();
        } catch (Exception e) {
            ErrorClass.accessError();
        }
    }

    private void handleAddDish(TableView<Dish> tableView,Dish value, String text) {
        Dish dish = new Dish();
        dish.setName(value.getName());
        dish.setType(value.getType());
        dish.setPrice(value.getPrice());
        try {
            int quantity = Integer.parseInt(text);
            dish.setQuantity(quantity);
            tableView.getItems().add(dish);
            updateBill(tableView);
        }catch (NumberFormatException e){
            ErrorClass.userInputError();
        }
    }
    private void handleDeleteDish()
    {
        try {
            view.getTableView().getItems().remove(view.getTableView().getSelectionModel().getSelectedItem());
            updateBill(view.getTableView());
        }catch (Exception ex){
            view.getTableView().getItems().removeAll();
            bill = 0;
            view.getBillLabel().setText("Bill = 0 L.E.");
        }
    }

    void updateBill(TableView<Dish> table){
        List<Dish> dishes = table.getItems();
        bill = 0;
        double unitPrice = 0;
        for (Dish x: dishes){
            switch (x.getType()){
                case "main_course":
                    unitPrice = 15*x.getPrice()/100 + x.getPrice();
                    break;
                case "appetizer":
                    unitPrice = 10*x.getPrice()/100 + x.getPrice();
                    break;
                case "desert":
                    unitPrice = 20*x.getPrice()/100 + x.getPrice();
                    break;
            }
            bill += unitPrice*x.getQuantity();
        }
        view.getBillLabel().setText("Bill = "+bill+" L.E.");
    }

    void login(){
        stage.setScene(view.login());
        view.getNext().setOnAction(e->handleLoginButton(view.getInput().getText(),view.getPassField().getText()));
        view.getBack().setOnAction(e->handleCloseButton());
    }

    void handleCloseButton() {
        if (ConfirmBox.display("Close", "Are you sure you want to close?"))
            stage.close();
    }

    /*Employee handling*/

    void showReservations(){
        stage.setScene(view.showReservations());
        view.getNext().setOnAction(e->handleCloseButton());

        try {
            view.getTableView().getItems().addAll(model.getReservationList(reservations));
            //TODO: quantity not showing + they look bad
            bill = model.getTotalMoneyEarned(reservations);
            view.getBillLabel().setText("Total money earned = "+ bill+" L.E.");
        } catch (Exception e) {
            ErrorClass.loadError();
        }}
//Waiter handling
        void showReservationsforWaiter(){
            stage.setScene(view.showReservationsforWaiter());

            try {
                view.getTableView().getItems().addAll(model.getReservationList(reservations));
            } catch (Exception e) {
                ErrorClass.loadError();
            }
        }
        void showOrdersforCook() {
            stage.setScene(view.showOrdersforCook());
            try {
                view.getTableView().getItems().addAll(model.getReservationList(reservations));
            } catch (Exception e) {
                ErrorClass.loadError();
            }

        }

    public static void main(String[] args) throws JAXBException {launch(args);}
}
