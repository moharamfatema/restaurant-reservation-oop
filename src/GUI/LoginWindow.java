package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginWindow {
    private static Stage stage = new Stage();
    private static GridPane pane = new GridPane();
    private static Label userLabel = new Label("Username: ");
    private static Label passLabel = new Label("Password: ");
    private static TextField userField = new TextField();
    private static PasswordField passField =new PasswordField();
    private static Button login = new Button();
    private static Button cancel = new Button("Cancel");
    public static void display()
    {
        init();
        login.setOnAction(event -> System.out.println());
        cancel.setOnAction(e->handleCancelButton());
        stage.show();
    }
    private static void init(){
        stage.setTitle("Login");
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(10);
        pane.setHgap(20);

        GridPane.setConstraints(userLabel,0,0);
        GridPane.setConstraints(passLabel,0,1);

        userField.setPromptText("username");
        GridPane.setConstraints(userField,1,0);

        GridPane.setConstraints(passField,1,1);

        login.setText("Login");
        GridPane.setConstraints(login,1,2);
        GridPane.setConstraints(cancel,1,3);

        pane.getChildren().addAll(userLabel,userField,passLabel,passField,cancel,login);

        Scene scene = new Scene(pane, 350, 150);
        stage.setScene(scene);

        stage.setOnCloseRequest(e->{
            e.consume();
            handleCancelButton();
        });
    }

    private static void handleCancelButton(){
        if(ConfirmBox.display("Cancel","Are you sure you want to cancel?"))
            stage.close();
    }
}
