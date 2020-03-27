package GUI;

import Data.User;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerWindow {
    public static Stage display(User user){
        Stage window = new Stage();
        window.setScene(initial());
        return window;
    }
    public static Scene initial(){
        //AlertBox.display("dashboard","This is the manager board.");
        //TODO: Implement
        Scene scene = new Scene(null);
        return scene;
    }
}
