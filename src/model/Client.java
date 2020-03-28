package model;

import model.Data.Dish;
import model.Data.Reservation;
import model.Data.Table;
import model.Data.Tables;

import java.util.List;

public class Client implements Model {
    public boolean findTable(Tables tables,int seats, boolean smoking)
    {
        boolean found = false;
        for (Table table : tables.getTables()){
            if (table.getNumber_of_seats() == seats){
                if (table.isSmoking() == smoking){
                    found = true;
                }
            }
        }
        return found;
    }
    public void order(List<Dish> dishList, List<Dish> allDishes)
    {
        allDishes.addAll(dishList);
    }
    public Reservation addReservation(String name,double bill,int tablenumber,List<Dish> orderedDishes)
    {
        Reservation reservation = new Reservation();
        reservation.setName(name);
        reservation.setBill(bill);
        reservation.setTablenumber(tablenumber);
        reservation.setOrderedDishes(orderedDishes);
        return reservation;
    }
}
