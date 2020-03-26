import Data.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import GUI.GUI;

import static javax.xml.bind.JAXBContext.newInstance;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new GUI().display(primaryStage);
        JAXBContext jaxbcontext= newInstance(Restaurant.class);
        Unmarshaller unmarshaller= jaxbcontext.createUnmarshaller();
        Restaurant restaurant= (Restaurant) unmarshaller.unmarshal(new File("input.xml"));
        for(User user: restaurant.getUsers().getUsers())
            System.out.println(user.getName()+" "+user.getRole()+" "+user.getUsername());
    }


    public static void main(String[] args) throws JAXBException {launch(args);}
}
