package EncryptionDecryption;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Data Encryption Tool");
        primaryStage.show();

        //Button button = new Button("CLICK");
        SplitPane splitPane = new SplitPane();

        VBox leftControl  = new VBox(new Label("Encryption"));
        VBox rightControl = new VBox(new Label("Decryption"));

        FileChooser fileChooser = new FileChooser();
        Button openButton = new Button("Choose a file");

        openButton.setOnAction(e ->
        {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                openFile(file);
            }
        });

        leftControl.getChildren().add(openButton);
        rightControl.getChildren().add(openButton);

        splitPane.getItems().addAll(leftControl, rightControl);

        Scene scene = new Scene(splitPane, 600, 300);

        primaryStage.setScene(scene);

        //layout.getChildren().add(button); // for ref.
    }

    /**
     * Open the given file.
     * @param file File object to be opened.
     */
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
