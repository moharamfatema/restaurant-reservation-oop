package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginWindow {
    public static void display()
    {
        Stage stage = new Stage();
        stage.setTitle("login");

        TextField uslabel = new TextField();
        TextField paslabel =new TextField();
        Button login = new Button();
        login.setText("login");
        login.setOnAction(event -> System.out.println());
        uslabel.setAlignment(Pos.BASELINE_CENTER);
        paslabel.setAlignment(Pos.BOTTOM_CENTER);
        login.setAlignment(Pos.BASELINE_RIGHT);
        var root = new HBox();
        root.getChildren().addAll(login,uslabel,paslabel);
        root.setPadding(new Insets(25));
        var scene = new Scene(root, 280, 200);

        stage.setScene(scene);
        stage.show();
    }
}
