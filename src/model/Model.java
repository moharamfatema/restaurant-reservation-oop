package model;

import javafx.collections.ObservableList;
import model.Data.*;

import java.util.List;

public interface Model {

    /*Client methods*/
    Table findTable(Tables tables, int seats, boolean smoking) throws Exception;
    ObservableList<Dish> getDishesOrdered(Reservation reservation)throws Exception;
    Reservation addReservation(String name, double bill, Table table, List<Dish> orderedDishes) throws Exception;
    void save(Reservations reservations,String reservationsPath,Restaurant restaurant,String restaurantPath) throws Exception;

    /*Waiter methods*/

    /*Cook methods*/

    /*Employee methods*/
    public Reservations loadReservations(String path) throws Exception;

    ObservableList<Reservation> getReservationList(Reservations reservations) throws Exception;
    double getTotalMoneyEarned(Reservations reservations)throws Exception;


}
