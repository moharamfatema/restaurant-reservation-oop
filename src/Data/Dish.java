package Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "dish")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dish {
    @XmlElement(name="name")
    private String name;
    @XmlElement(name="price")
    private double price;
    @XmlElement(name="type")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        return String.format("%s   \tType: %s   \tPrice: %sL.E",name,type,String.valueOf(price));
    }
}
