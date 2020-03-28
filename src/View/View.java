package View;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Data.Dish;

public class View {
    private Scene scene;
    private GridPane pane;

    private TextField input;
    private PasswordField passField;

    private Label label1;
    private Label label2;

    private Button next;
    private Button add;
    private Button delete;
    private Button back;

    private ChoiceBox<Dish> choiceBox;
    private CheckBox checkBox;

    private TableView selectedDishes;



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

        pane.getChildren().addAll(label1, input,label2,passField, next);

        return new Scene(pane, 350, 150);
    }

    public Scene menu(){
        //TODO:Implement
        pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setHgap(20);
        pane.setVgap(10);

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

        selectedDishes = new TableView<>();
        selectedDishes.setMinWidth(100);
        GridPane.setConstraints(selectedDishes,0,3);

        next = new Button("Order");
        GridPane.setConstraints(next,0,1);

        //Name column
        TableColumn<Dish,String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(20);
        //Type column
        TableColumn<Dish,String> type = new TableColumn<>("Type");
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        type.setMinWidth(20);
        //Price column
        TableColumn<Dish,Double> price = new TableColumn<>("Unit Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        price.setMinWidth(20);
        //Quantity column
        TableColumn<Dish,String> quantity = new TableColumn<>("Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantity.setMinWidth(20);

        pane.getChildren().addAll(selectedDishes,next,label1);

        return new Scene(pane,500,500);
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
        return new Scene(pane,275,150);
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

    public TableView getSelectedDishes() {
        return selectedDishes;
    }

    public void setSelectedDishes(TableView selectedDishes) {
        this.selectedDishes = selectedDishes;
    }

    public Button getBack() {
        return back;
    }

    public void setBack(Button back) {
        this.back = back;
    }
}

