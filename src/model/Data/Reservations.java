package model.Data;

import javafx.collections.FXCollections;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "reservations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservations {
    @XmlElement(name = "reservation")
    private List<Reservation> reservations;
    @XmlElement(name = "totalmoney")
    private double totalmoney;

    public Reservations() {
        reservations = FXCollections.observableArrayList();
        totalmoney = 0;
    }

    public Reservations(List<Reservation> reservations, double totalmoney) {
        this.reservations = reservations;
        this.totalmoney = totalmoney;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void add(Reservation x,double bill){
        reservations.add(x);
        totalmoney+=bill;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }
}