package model;

import Data.Restaurant;
import Data.User;
import GUI.AlertBox;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static javax.xml.bind.JAXBContext.newInstance;

public class Controller {

    public static Restaurant restaurant;
    public static void loginAction(String username,String password) throws JAXBException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //TODO: implement to search in users
        restaurant = initializeXml();
        System.out.println("Done.");

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
