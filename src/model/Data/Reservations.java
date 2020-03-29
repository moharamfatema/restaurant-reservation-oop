package model.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "reservations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservations {
    @XmlElement(name = "data")
    private List<Reservation> data;
    @XmlElement(name = "totalmoney")
    private double totalmoney;

    public List<Reservation> getData() {
        return data;
    }

    public void setData(List<Reservation> data) {
        this.data = data;
    }

    public void add(Reservation x){
        data.add(x);
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }
}