package model.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "reservation")
public class Reservation {
    @XmlElement(name = "tablenumber")
    private int tablenumber;
    @XmlElement(name = "orderedDishes")
    private List<Dish> orderedDishes;
    @XmlElement(name = "bill")
    private double bill = 0;
    @XmlElement(name = "name")
    private String name;

    public List<Dish> getOrderedDishes() {
        return orderedDishes;
    }

    public double getBill() {
        return bill;
    }

    public int getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(int tablenumber) {
        this.tablenumber = tablenumber;
    }

    public void setOrderedDishes(List<Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
