package model;

import Data.Restaurant;
import Data.User;
import Data.Users;
import GUI.AlertBox;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collection;
import java.util.List;

import static javax.xml.bind.JAXBContext.newInstance;

public class Controller {

    public static Restaurant restaurant;
    public static User currentUser= new User();
    public static void loadUser(String username,String password) throws JAXBException {
        //TODO: implement to search in users
        restaurant = initializeXml();
        Collection<User> users= restaurant.getUsers().getUsers();
        for (User x : users){
            if (username.equals(x.getUsername())){
                currentUser = x;
                return;
            }
        }AlertBox.display("User not found","You entered a wrong username");
    }
    public static Restaurant initializeXml() throws JAXBException {
        JAXBContext jaxbcontext = newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        Restaurant restaurant = new Restaurant();
        try {
            restaurant = (Restaurant) unmarshaller.unmarshal(new File("input.xml"));
        }catch (Exception e){
            AlertBox.display("Error","File not found!");
        }
        return restaurant;
    }
}
