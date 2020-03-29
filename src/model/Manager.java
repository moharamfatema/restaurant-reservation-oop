package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Data.Dish;
import model.Data.Reservation;
import model.Data.Reservations;
import model.Data.Tables;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Manager extends Person{

    @Override
    public Reservations loadReservations(String path) throws Exception {
        JAXBContext parser = JAXBContext.newInstance();
        Unmarshaller unmarshaller = parser.createUnmarshaller();
        Reservations reservations = (Reservations) unmarshaller.unmarshal(new File(path));
        return reservations;
    }

    @Override
    public ObservableList<Reservation> getReservationList(Reservations reservations)  {
        ObservableList<Reservation> observableList = FXCollections.observableArrayList();
        observableList.addAll(reservations.getData());
        return observableList;
    }

    @Override
    public int getTotalMoneyEarned(Reservations reservations) throws Exception {
        return reservations.getTotalmoney();
    }

    @Override
    public ObservableList<Dish> getDishesOrdered(Reservation reservation) throws Exception {
        ObservableList<Dish> observableList = FXCollections.observableArrayList();
        observableList.addAll(reservation.getOrderedDishes());
        return observableList;
    }
}
