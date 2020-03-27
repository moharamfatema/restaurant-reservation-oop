package Data;

import GUI.AlertBox;
import model.Reservation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.Collection;
@XmlRootElement(name = "reservations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservations {
    @XmlElement(name = "data")
    Collection<Reservation> data;

    public Collection<Reservation> getData() {
        return data;
    }

    public void setData(Collection<Reservation> data) {
        this.data = data;
    }

    public void add(Reservation x){
        data.add(x);
    }
}
