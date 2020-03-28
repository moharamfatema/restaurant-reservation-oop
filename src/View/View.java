package View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Data.Dish;
import model.Data.Reservation;

import java.util.List;

public class View {
    private Scene scene;
    private GridPane pane;
    private HBox hBox;
    private VBox vBox;

    private TextField input;
    private PasswordField passField;

    private Label label1;
    private Label label2;
    private Label billLabel = new Label("Bill = 0 L.E");

    private Button next;
    private Button add;
    private Button delete;
    private Button back;
    private Button logout = new Button("Logout");

    private ChoiceBox<Dish> choiceBox;
    private CheckBox checkBox;

    private TableView tableView;

    public Scene login(){
        pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(10);
        pane.setHgap(20);

        input = new TextField();
        input.setPromptText("username");
        GridPane.setConstraints(input,1,0);

        label1 = new Label("Username: ");
        GridPane.setConstraints(label1,0,0);
        label2 = new Label("Password: ");
        GridPane.setConstraints(label2,0,1);

        passField = new PasswordField();
        GridPane.setConstraints(passField,1,1);

        next = new Button("Login");
        GridPane.setConstraints(next,1,2);

        back = new Button("Close");
        GridPane.setConstraints(back,1,3);

        pane.getChildren().addAll(label1, input,label2,passField, next);

        return new Scene(pane, 350, 175);
    }

    public Scene menu(){
        //TODO:Implement
        pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setHgap(20);
        pane.setVgap(10);

        vBox = new VBox();
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setSpacing(10);

        label1 = new Label("Add a dish: ");
        GridPane.setConstraints(label1,0,0);

        choiceBox = new ChoiceBox<>();
        choiceBox.setMinWidth(30);
        GridPane.setConstraints(choiceBox,1,0);

        label2 = new Label("Quantity");
        GridPane.setConstraints(label2,0,1);

        input = new TextField("1");
        input.setPromptText("How many?");
        GridPane.setConstraints(input,1,1);

        add = new Button("Add");
        GridPane.setConstraints(add,0,2);

        delete = new Button("Delete");
        GridPane.setConstraints(delete,1,2);

        next =new Button("Confirm Order");
        GridPane.setConstraints(next,2,2);

        tableView = new TableView<>();
        tableView.setMinWidth(100);

         TableColumn<Dish,String> column4;
         TableColumn<Dish,Double> doubleColumn3;
         TableColumn<Dish,String> column2;
         TableColumn<Dish,String> column1;

        //Name column
        column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column1.setMinWidth(100);

        //Type column
        column2 = new TableColumn<>("Type");
        column2.setCellValueFactory(new PropertyValueFactory<>("type"));
        column2.setMinWidth(20);

        //Price column
        doubleColumn3 = new TableColumn<>("Unit Price");
        doubleColumn3.setCellValueFactory(new PropertyValueFactory<>("price"));
        doubleColumn3.setMinWidth(20);

        //Quantity column
        column4 = new TableColumn<>("Quantity");
        column4.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        column4.setMinWidth(20);

        tableView.getColumns().addAll(column1, column2, doubleColumn3, column4);

        pane.getChildren().addAll(label1,choiceBox,label2,input,add,delete,next);
        vBox.getChildren().addAll(pane,tableView,billLabel);

        return new Scene(vBox,500,500);
    }

    public Scene findTable(){
        pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(10);
        pane.setHgap(20);

        label1 = new Label("Number of seats: ");
        GridPane.setConstraints(label1,0,0);

        input = new TextField();
        input.setPromptText("Enter a number between 4 and 12");
        GridPane.setConstraints(input,1,0);

        checkBox = new CheckBox("Smoking Area");
        GridPane.setConstraints(checkBox,0,1);

        next = new Button("Find me a table");
        GridPane.setConstraints(next,1,2);

        back = new Button("Go back");
        GridPane.setConstraints(back,1,3);

        pane.getChildren().addAll(label1,input,checkBox,next,back);
        return new Scene(pane,325,150);
    }

    public Scene showReservations(){
        vBox = new VBox();
        hBox = new HBox();

        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setSpacing(10);

        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(20);
        //hBox.setAlignment(Pos.BASELINE_CENTER);

        next = new Button("Close");

        TableColumn<Reservation,String> name = new TableColumn<>("Customer Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(100);

        TableColumn<Reservation,Double> bill = new TableColumn<>("Bill");
        bill.setCellValueFactory(new PropertyValueFactory<>("bill"));
        bill.setMinWidth(20);

        TableColumn<Reservation,Integer> tablenumber = new TableColumn<>("Table Number");
        tablenumber.setCellValueFactory(new PropertyValueFactory<>("tablenumber"));
        tablenumber.setMinWidth(20);

        TableColumn<Reservation, List<Dish>> dishes = new TableColumn<>("Ordered Dishes");
        dishes.setCellValueFactory(new PropertyValueFactory<>("ordereddishes"));
        dishes.setMinWidth(20);

        tableView = new TableView();
        tableView.getColumns().addAll(name,bill,tablenumber,dishes);

        hBox.getChildren().addAll(next,logout);
        vBox.getChildren().addAll(tableView,hBox);

        return new Scene(vBox,500,500);
    }

    public Button getLogout() {
        return logout;
    }

    public void setLogout(Button logout) {
        this.logout = logout;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public GridPane getPane() {
        return pane;
    }

    public void setPane(GridPane pane) {
        this.pane = pane;
    }

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label label1) {
        this.label1 = label1;
    }

    public Label getLabel2() {
        return label2;
    }

    public void setLabel2(Label label2) {
        this.label2 = label2;
    }

    public TextField getInput() {
        return input;
    }

    public void setInput(TextField input) {
        this.input = input;
    }

    public PasswordField getPassField() {
        return passField;
    }

    public void setPassField(PasswordField passField) {
        this.passField = passField;
    }

    public Button getNext() {
        return next;
    }

    public void setNext(Button next) {
        this.next = next;
    }

    public Button getAdd() {
        return add;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public ChoiceBox<Dish> getChoiceBox() {
        return choiceBox;
    }

    public void setChoiceBox(ChoiceBox<Dish> choiceBox) {
        this.choiceBox = choiceBox;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }

    public Button getBack() {
        return back;
    }

    public void setBack(Button back) {
        this.back = back;
    }

}

