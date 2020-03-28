/*
* Author 1: Fatema Moharam
* ID: 6655
*
* Author 2: Nourhan Waleed
* ID: 6609
* */


import javafx.application.Application;
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
    Reservations reservations = new Reservations();
    User currentUser;
    Stage stage;
    Model model;
    View view = new View();

    Files inputpath = Files.INPUT;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        initializeXML();
        stage.setScene(view.login());
        view.getNext().setOnAction(e->handleLoginButton(view.getInput().getText(),view.getPassField().getText()));
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
                }else
                    switch (currentUser.getRole()){
                        case "Manager":
                            //View.dashboard = ManagerWindow.display(currentUser);
                            break;
                        case "Cooker":

                            break;
                        case "Waiter":

                            break;
                        case "Client":
                            model = new Client();
                            view.getNext().setOnAction(e->{
                                stage.setScene(view.findTable());
                                findTable();
                            });
                    }
                return;
            }
        }AlertBox.display("User not found","You entered a wrong username");
    }
    void findTable(){
        view.getNext().setOnAction(e-> handleFindTable(view.getInput().getText(),view.getCheckBox().isSelected()));
        view.getBack().setOnAction(e->stage.setScene(view.login()));
    }
    void handleFindTable(String seatsInput,boolean smoking){
        int numofseats;
        try{
            numofseats = Integer.parseInt(seatsInput);
        }catch (NumberFormatException e){
            AlertBox.display("Invalid input",seatsInput + "is not a number");
            return;
        }
        if (numofseats <13 && numofseats>3){
            boolean found = model.findTable(restaurant.getTables(),numofseats,smoking);
            if (found){
                stage.setScene(view.menu());
                orderDishes();
            }
            else
                AlertBox.display("Sorry","We couldn't find a table with the specified requirements");
        }else {
            AlertBox.display("Invalid input","Please enter a number of seats between 4 and 12");
        }
    }

    private void orderDishes() {
        return;
    }

    void handleCancelButton(Stage stage) {
        if (ConfirmBox.display("Cancel", "Are you sure you want to cancel?"))
            stage.close();
    }

    public static void main(String[] args) throws JAXBException {launch(args);}
}
