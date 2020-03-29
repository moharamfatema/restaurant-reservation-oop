package model.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation {
    @XmlElement(name = "tablenumber")
    private int tablenumber;
    @XmlElement(name = "dish")
    private List<Dish> dishes;
    @XmlElement(name = "bill")
    private double bill = 0;
    @XmlElement(name = "name")
    private String name;

    public List<Dish> getDishes() {
        return dishes;
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

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
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
