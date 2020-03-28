package model;

import model.Data.*;

import java.util.List;

public interface Model {

    /*Client methods*/
    boolean findTable(Tables tables,int seats,boolean smoking);
    void order(List<Dish> dishList,List<Dish> allDishes);
    Reservation addReservation(String name,double bill,int tablenumber,List<Dish> orderedDishes);

    /*Waiter methods*/

    /*Cook methods*/

    /*Manager methods*/


}
