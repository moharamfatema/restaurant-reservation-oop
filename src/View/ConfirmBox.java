package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    public static Boolean ans;
    public static Boolean display(String title, String message)
    {

        Stage window = new Stage();
        window.setTitle(title);
        window.setMinWidth(255);
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label(message);

        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e->{ans = true;window.close();});

        Button noButton = new Button("No");
        noButton.setOnAction(e->
        {
            ans = false;
            window.close();
        });

        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(label);

        VBox buttons = new VBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(yesButton,noButton);

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setTop(layout);
        pane.setCenter(buttons);

        Scene scene = new Scene(pane,300,100);
        window.setScene(scene);
        window.showAndWait();

        return ans;
    }
}
