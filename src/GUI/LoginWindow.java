package GUI;
import model.Controller;
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

import javax.xml.bind.JAXBException;

public class LoginWindow {
    private static Scene scene;
    private static GridPane pane = new GridPane();
    private static Label userLabel = new Label("Username: ");
    private static Label passLabel = new Label("Password: ");
    private static TextField userField = new TextField();
    private static PasswordField passField =new PasswordField();
    private static Button login = new Button();
    public static Scene display(Stage stage)
    {
        init();
        login.setOnAction(e -> {
            try {
                Controller.loadUser(userField.getText(),passField.getText(),stage);
            } catch (JAXBException ex) {
                ex.printStackTrace();
            }
        });
        return scene;
    }
    private static void init(){
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

        pane.getChildren().addAll(userLabel,userField,passLabel,passField,login);

        scene = new Scene(pane, 350, 150);
    }
}
