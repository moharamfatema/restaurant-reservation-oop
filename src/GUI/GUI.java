package GUI;
import model.Controller;
import Data.Restaurant;
import Data.User;
import Data.Users;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static javax.xml.bind.JAXBContext.newInstance;


public class GUI{
    //public static Stage ;
    public static void display(Stage primaryStage) throws  JAXBException{
        primaryStage.setOnCloseRequest(e->{
            e.consume();
            handleCancelButton(primaryStage);
        });
        primaryStage.setTitle("Welcome to our restaurant");
        primaryStage.setScene(LoginWindow.display(primaryStage));
        primaryStage.show();

    }
    static void handleCancelButton(Stage stage) {
        if (ConfirmBox.display("Cancel", "Are you sure you want to cancel?"))
            stage.close();
    }
}

