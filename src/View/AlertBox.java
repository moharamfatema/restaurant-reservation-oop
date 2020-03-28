package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String title, String message)
    {
        Stage window = new Stage();
        window.setTitle(title);
        window.setMinWidth(300);window.setMinHeight(100);
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label(message);
        Button button = new Button("OK");
        button.setOnAction(e->window.close());

        VBox layout = new VBox();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,button);

        Scene scene = new Scene(layout,350,100);
        window.setScene(scene);
        window.showAndWait();
    }
}
