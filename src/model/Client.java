package model;

import View.AlertBox;
import model.Data.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class Client implements Model {
    public boolean findTable(Tables tables,int seats, boolean smoking)
    {
        boolean found = false;
        for (Table table : tables.getTables()){
            if (table.getNumber_of_seats() == seats || table.getNumber_of_seats() == seats+1 || table.getNumber_of_seats() == seats+2){
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
    public void save(Reservations reservations,String path) throws JAXBException {
        JAXBContext parser = JAXBContext.newInstance();
        try {
            Marshaller marshaller = parser.createMarshaller();
            marshaller.marshal(reservations,new File(path));
        }catch (JAXBException e){
            AlertBox.display("Error","Couldn't save reservation data");
        }

    }
}
