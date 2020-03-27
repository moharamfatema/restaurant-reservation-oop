package model;

import Data.Restaurant;
import Data.User;
import Data.Users;
import GUI.AlertBox;
import GUI.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collection;
import java.util.List;

import static javax.xml.bind.JAXBContext.newInstance;

public class Controller {

    public static Restaurant restaurant;
    public static User currentUser;
    public static void loadUser(String username, String password,Stage stage) throws JAXBException {
        //TODO: implement to search in users
        restaurant = Model.initializeXml();
        Collection<User> users= restaurant.getUsers().getUsers();
        for (User x : users){
            if (username.equals(x.getUsername())){
                currentUser = x;
                if (!password.equals(currentUser.getPassword())){
                    AlertBox.display("Wrong password","The password you entered is incorrect.");
                    return;
                }else
                    switch (currentUser.getRole()){
                        case "Manager":
                            //GUI.dashboard = ManagerWindow.display(currentUser);
                            break;
                        case "Cooker":

                            break;
                        case "Waiter":

                            break;
                        case "Client":
                            stage.setScene(ClientWindow.initial());
                    }
                    return;
            }
        }AlertBox.display("User not found","You entered a wrong username");
    }

}
