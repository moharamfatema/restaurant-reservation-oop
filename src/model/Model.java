package model;

import Data.Reservations;
import Data.Restaurant;
import Data.User;
import GUI.AlertBox;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static javax.xml.bind.JAXBContext.newInstance;

public class Model {
    static Reservations reservations = new Reservations();
    public static Restaurant restaurant;
    public static User currentUser;

    static void saveReservations() throws JAXBException {
        JAXBContext parser = JAXBContext.newInstance(Reservations.class);
        Marshaller marshaller = parser.createMarshaller();
        try {
            marshaller.marshal(reservations,new File("Reservations.xml"));
        }catch (Exception e){
            AlertBox.display("Save","Couldn't save reservations");
        }
    }static void loadReservations() throws JAXBException {
        JAXBContext parser = JAXBContext.newInstance(Reservations.class);
        Unmarshaller unmarshaller = parser.createUnmarshaller();
        try {
            reservations = (Reservations)unmarshaller.unmarshal(new File("Reservations.xml"));
        }catch (Exception e){
            AlertBox.display("Error","couldn't load reservations.");
        }


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
