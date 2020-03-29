package model.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {
    @XmlElement(name="number")
    private int number;
    @XmlElement(name="number_of_seats")
    private int number_of_seats;
    @XmlElement(name="smoking")
    private boolean smoking;
    @XmlElement
    private boolean free;

    public Table() {
        this.number = 0;
        this.number_of_seats = 0;
        this.smoking = false;
        this.free = true;
    }

    public Table(int number, int number_of_seats, boolean smoking, boolean free) {
        this.number = number;
        this.number_of_seats = number_of_seats;
        this.smoking = smoking;
        this.free = free;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getNumber() {
        return number;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }
}