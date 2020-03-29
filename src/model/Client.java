package model;

import View.AlertBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Data.*;

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
                if (table.isSmoking() == smoking){
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
        reservation.setOrderedDishes(orderedDishes);
        return reservation;
    }
    public void save(Reservations reservations,String path) throws JAXBException {
        JAXBContext parser = JAXBContext.newInstance();
        try {
            Marshaller marshaller = parser.createMarshaller();
            marshaller.marshal(reservations,new File(path));
        }catch (JAXBException e){
            AlertBox.display("Error","Couldn't save reservation data");
        }

    }

    @Override
    public ObservableList<Dish> getDishesOrdered(Reservation reservation) throws Exception {
        ObservableList<Dish> observableList = FXCollections.observableArrayList();
        observableList.addAll(reservation.getOrderedDishes());
        return observableList;
    }
}
