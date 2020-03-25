package GUI;

import Data.Restaurant;
import Data.User;
import Data.Users;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static javax.xml.bind.JAXBContext.newInstance;


public class GUI{
    Restaurant restaurant;
    public void display(Stage primaryStage) throws  JAXBException{
        initializeXml();
        loginWindow(primaryStage);
    }

    public void loginWindow(Stage stage) {
        TextField uslabel = new TextField();
        TextField paslabel =new TextField();
        Button login = new Button();
        login.setText("login");
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println();
            }});
        uslabel.setAlignment(Pos.BASELINE_CENTER);
        paslabel.setAlignment(Pos.BOTTOM_CENTER);
        login.setAlignment(Pos.BASELINE_RIGHT);
        var root = new HBox();
        root.getChildren().addAll(login,uslabel,paslabel);
        root.setPadding(new Insets(25));
        var scene = new Scene(root, 280, 200);

        stage.setTitle("login");
        stage.setScene(scene);
        stage.show();
    }

    public void login1(String usname, String password){
        Users us = restaurant.getUsers();
        for (User user : us.getUsers()) {
            if ((usname.compareToIgnoreCase(user.getName()) == 0) && password.compareToIgnoreCase(user.getPassword()) == 0) {
                String role = user.getRole();
                System.out.println(usname+password);
                switch (role.toLowerCase()) {
                    case "manager":
                        managerWindow();
                }
            }
        }
    }

    private void managerWindow() {
        System.out.println("hi");
    }

    public void initializeXml() throws JAXBException {
        JAXBContext jaxbcontext = newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        restaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\user\\IdeaProjects\\progproject2\\src\\pack\\input.xml"));
    }
}

