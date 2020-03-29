package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Data.Dish;
import model.Data.Reservation;
import model.Data.Reservations;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Manager extends Person{


    @Override
    public ObservableList<Reservation> getReservationList(Reservations reservations)  {
        ObservableList<Reservation> observableList = FXCollections.observableArrayList();
        observableList.addAll(reservations.getData());
        return observableList;
    }

    @Override
    public double getTotalMoneyEarned(Reservations reservations) throws Exception {
        return reservations.getTotalmoney();
    }

    @Override
    public ObservableList<Dish> getDishesOrdered(Reservation reservation) throws Exception {
        ObservableList<Dish> observableList = FXCollections.observableArrayList();
        observableList.addAll(reservation.getOrderedDishes());
        return observableList;
    }
}