package model;

import javafx.collections.ObservableList;
import model.Data.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Person implements Model{
    public Reservations loadReservations(String path) throws Exception {
        JAXBContext parser = JAXBContext.newInstance();
        Unmarshaller unmarshaller = parser.createUnmarshaller();
        Reservations reservations = (Reservations) unmarshaller.unmarshal(new File(path));
        return reservations;
    }

    @Override
    public int getTotalMoneyEarned(Reservations reservations) throws Exception {
        ErrorClass.accessError();
        return 0;
    }


    @Override
    public ObservableList<Reservation> getReservationList(Reservations reservations) throws Exception {
        ErrorClass.accessError();
        return null;
    }
    @Override
    public Table findTable(Tables tables, int seats, boolean smoking) throws Exception {
        ErrorClass.accessError();
        return null;
    }

    @Override
    public ObservableList<Dish> getDishesOrdered(Reservation reservation) throws Exception {
        ErrorClass.accessError();
        return null;
    }

    @Override
    public Reservation addReservation(String name, double bill, Table table, List<Dish> orderedDishes) throws Exception {
        ErrorClass.accessError();
        return null;
    }

    @Override
    public void save(Reservations reservations, String path) throws Exception {
        ErrorClass.accessError();
    }
}
