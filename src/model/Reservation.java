package model;

import Data.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
@XmlRootElement(name = "reservation")
public class Reservation {
    Collection<Table> tables  = Controller.restaurant.getTables().getTables();
    @XmlElement(name = "table")
    Table table;
    @XmlElement(name = "orderedDishes")
    Collection<Dish> orderedDishes;
    @XmlElement(name = "bill")
    double bill = 0;
    public boolean findTable(int seats, boolean smoking){
        boolean found = false;
        for (Table x : tables){
            if (x.getNumber_of_seats() == seats){
                if (smoking == x.isSmoking()){
                    table = x;
                    found = true;
                    break;
                }
            }
        }return found;
    }
    public void order(Collection<Dish> dishes){
        orderedDishes.addAll(dishes);
        for (Dish x: dishes)
            bill += x.getPrice();
    }
    public void confirm(){
        Model.reservations.add(this);
    }

    public Collection<Table> getTables() {
        return tables;
    }

    public Table getTable() {
        return table;
    }

    public Collection<Dish> getOrderedDishes() {
        return orderedDishes;
    }

    public double getBill() {
        return bill;
    }
}
