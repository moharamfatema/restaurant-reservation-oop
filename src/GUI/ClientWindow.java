package GUI;

import Data.Dish;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import model.Controller;
import model.Reservation;

import java.util.concurrent.atomic.AtomicBoolean;

public class ClientWindow {
    public static Stage window;
    public static Reservation reservation = new Reservation();
    static TableView selectedDishes;
    static AtomicBoolean showmenu = new AtomicBoolean(false);

    public static Scene initial(){
        //TODO:Implement
        //tables from 4 to 12

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(10);
        pane.setHgap(20);

        Label seatsLabel = new Label("Number of seats: ");
        GridPane.setConstraints(seatsLabel,0,0);

        TextField seatsField = new TextField();
        seatsField.setPromptText("Enter a number from 4 to 12");
        GridPane.setConstraints(seatsField,1,0);

        CheckBox smoking = new CheckBox("Smoking Area");
        GridPane.setConstraints(smoking,0,1);

        Button go = new Button("Find me a table");

        go.setOnAction(e-> showmenu.set(handleGoButton(seatsField, smoking.isSelected())));
        GridPane.setConstraints(go,1,2);

        pane.getChildren().addAll(seatsLabel,seatsField,smoking,go);

        return new Scene(pane,350,150);
    }

    private static boolean handleGoButton(TextField seatsField, boolean selected) {
        try {
            int seats = Integer.parseInt(seatsField.getText());
            if (seats>3 && seats<13){
                boolean found = reservation.findTable(seats,selected);
                if (!found)
                    AlertBox.display("Sorry","We could not find a table with the specified requirements.");
                else {
                    return true;
                }
            }else {
                AlertBox.display("Invalid Input","Please Enter a number of seats between 4 and 12");
            }
        }catch (NumberFormatException e){
            AlertBox.display("Invalid Input",seatsField.getText() + "is not a number");
        }
        return false;
    }
    public static Scene menu(){
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setHgap(20);
        pane.setVgap(10);

        Label addDish = new Label("Add a dish: ");
        GridPane.setConstraints(addDish,0,0);

        ChoiceBox<Dish> menu = new ChoiceBox<>();
        menu.getItems().addAll(getDishes());
        menu.setMinWidth(30);
        GridPane.setConstraints(menu,1,0);

        Label quantityLabel = new Label("Quantity");
        GridPane.setConstraints(quantityLabel,0,1);

        TextField quantity = new TextField("1");
        quantity.setPromptText("How many?");

        Button add = new Button("Add");
        GridPane.setConstraints(add,1,1);

        //Name column
        TableColumn<Dish,String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(20);

        TableColumn<Dish,String> type = new TableColumn<>("Type");
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        type.setMinWidth(20);

        TableColumn<Dish,Double> price = new TableColumn<>("Unit Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        price.setMinWidth(20);


        selectedDishes = new TableView<>();


        //TODO:Implement

        /*try {
            selectedDishes.getItems().addAll(getDishes());
        }catch (Exception e){
            AlertBox.display("Error","Couldn't load dishes.");
        }
        selectedDishes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        GridPane.setConstraints(selectedDishes,0,0);*/

        Button order = new Button("Order");
        GridPane.setConstraints(order,0,1);
        order.setOnAction(event -> handleOrderButton());

        Label bill = new Label("Bill = " + reservation.getBill()+" L.E");
        GridPane.setConstraints(bill,1,1);

        pane.getChildren().addAll(selectedDishes,order,bill);

        return new Scene(pane,500,500);
    }

    private static void handleOrderButton() {
        reservation.order(selectedDishes.getSelectionModel().getSelectedItems());
        AlertBox.display("SUCCESS","Table "+reservation.getTable().getNumber() +" successfully reserved\nBill = "+reservation.getBill());
    }

    private static ObservableList<Dish> getDishes(){
        ObservableList<Dish> dishes = Controller.restaurant.getDishes().getDishes();
        return dishes;
    }
}
