package EncryptionDecryption;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Data Encryption Tool");
        primaryStage.show();

        //Button button = new Button("CLICK");
        SplitPane splitPane = new SplitPane();

        VBox leftControl  = new VBox(new Label("Encryption"));
        VBox rightControl = new VBox(new Label("Decryption"));

        splitPane.getItems().addAll(leftControl, rightControl);

        Scene scene = new Scene(splitPane);

        primaryStage.setScene(scene);

        //layout.getChildren().add(button); // for ref.
    }


    public static void main(String[] args) {
        launch(args);
    }
}
