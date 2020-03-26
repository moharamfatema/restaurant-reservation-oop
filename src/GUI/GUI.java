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
    public static void display(Stage primaryStage) throws  JAXBException{
        LoginWindow.display();
    }


    /*public static void login1(String usname, String password){
        Users us = restaurant.getUsers();
        for (User user : us.getUsers()) {
            if ((usname.compareToIgnoreCase(user.getName()) == 0) && password.compareToIgnoreCase(user.getPassword()) == 0) {
                String role = user.getRole();
                System.out.println(usname+password);
                switch (role.toLowerCase()) {
                    case "manager":
                        ManagerWindow.display();
                }
            }
        }
    }*/


}

