package GUI;

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
    Restaurant restaurant;
    public void display(Stage primaryStage) throws  JAXBException{
        initializeXml();
        LoginWindow.display();
    }


    public void login1(String usname, String password){
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
    }

    public void initializeXml() throws JAXBException {
        JAXBContext jaxbcontext = newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        try {
            restaurant = (Restaurant) unmarshaller.unmarshal(new File("input.xml"));
        }catch (Exception e){
            AlertBox.display("Error","File not found!");
        }
    }
}

