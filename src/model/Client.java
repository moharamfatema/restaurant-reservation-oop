package model;

import View.AlertBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Data.*;
import model.Data.Reservations;
import model.Data.Reservation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class Client extends Person {

    public Table findTable(Tables tables, int seats, boolean smoking)
    {
        Table foundTable = new Table();
        foundTable.setNumber(0);
        boolean found = false;
        for (Table table : tables.getTables()){
            if (table.getNumber_of_seats() == seats || table.getNumber_of_seats() == seats+1 || table.getNumber_of_seats() == seats+2){
                if (table.isSmoking() == smoking && table.isFree()){
                    found = true;
                    return table;
                }
            }
        }
        return foundTable;
    }

    public Reservation addReservation(String name, double bill, Table table, List<Dish> orderedDishes)
    {
        Reservation reservation = new Reservation();
        table.setFree(false);
        reservation.setName(name);
        reservation.setBill(bill);
        reservation.setTablenumber(table.getNumber());
        reservation.setDishes(orderedDishes);
        return reservation;
    }
    public void save(Reservations reservations,String reservationsPath,Restaurant restaurant,String restaurantPath) throws JAXBException {
        JAXBContext parser = JAXBContext.newInstance(Reservations.class);
        try {
            Marshaller marshaller = parser.createMarshaller();
            marshaller.marshal(reservations,new File(reservationsPath));
        }catch (JAXBException e){
            AlertBox.display("Error","Couldn't save reservation data");
        }
        JAXBContext restaurantParser = JAXBContext.newInstance(Restaurant.class);
        try {
            Marshaller restaurantParserMarshaller = restaurantParser.createMarshaller();
            restaurantParserMarshaller.marshal(restaurant,new File(restaurantPath));
        }catch (JAXBException e){
            AlertBox.display("Error","Couldn't save restaurant data");
        }

    }

    @Override
    public ObservableList<Dish> getDishesOrdered(Reservation reservation) throws Exception {
        ObservableList<Dish> observableList = FXCollections.observableArrayList();
        observableList.addAll(reservation.getDishes());
        return observableList;
    }
}
