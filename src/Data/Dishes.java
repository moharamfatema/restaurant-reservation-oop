package Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name= "dishes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dishes {
    @XmlElement(name= "dish")
    private ObservableList<Dish> dishes = FXCollections.observableArrayList();

    public ObservableList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(ObservableList<Dish> dishes) {
        this.dishes = dishes;
    }
}