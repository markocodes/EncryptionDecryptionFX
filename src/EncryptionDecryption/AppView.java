package EncryptionDecryption;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppView extends Application {

    //private Desktop desktop = Desktop.getDesktop();
    private String encryptContent;
    private String decryptContent;
    private boolean eFileChosen;
    private boolean dFileChosen;

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Data Encryption and Decryption Tool");
        primaryStage.show();

        // Controller object that will serve as interface between GUI and back-end.
        Controller controller = new Controller();

        // Creating containers and visual elements.
        SplitPane splitPane = new SplitPane();

        Label eHeader = new Label("Encryption");
        Label dHeader = new Label("Decryption");

        eHeader.setFont(new Font("Calibri", 24));
        dHeader.setFont(new Font("Calibri", 24));

        VBox leftControl  = new VBox(eHeader);
        VBox rightControl = new VBox(dHeader);

        TextField eTextField = new TextField();
        TextField dTextField = new TextField();

        TextArea eTextArea = new TextArea();
        TextArea dTextArea = new TextArea();

        // File choosing button setup
        FileChooser fileChooser = new FileChooser();
        Button eOpenButton = new Button("Choose a file");
        Button dOpenButton = new Button("Choose a file");

        // Set action for file choosing button on encryption side.
        eOpenButton.setOnAction(e ->
        {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null && file.getName().contains(".txt")) {
                // Open the file and add message.
                encryptContent = openFile(file);
                eFileChosen = true;
                Label fileAddedLabel = new Label(file.getName() + " has been selected.");
                leftControl.getChildren().add(fileAddedLabel);
            }else{
                createDialogue("This file could not be opened. Please ensure the file exists, and that it is of type .txt");
            }
        });

        // Set action for file choosing button on decryption side.
        dOpenButton.setOnAction(e ->
        {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null && file.getName().contains(".txt")) {
                // Open the file and add message.
                decryptContent = openFile(file);
                dFileChosen = true;
                Label fileAddedLabel = new Label(file.getName() + " has been selected.");
                leftControl.getChildren().add(fileAddedLabel);
            }else{
                createDialogue("This file could not be opened. Please ensure the file exists, and that it is of type .txt");
            }
        });

        // Execution button set up
        Button eGoButton = new Button("Encrypt");
        Button dGoButton = new Button("Decrypt");

        // Set action for execution button on encryption side.
        eGoButton.setOnAction(e ->
        {
            if(eTextField.getText().isEmpty() && !eFileChosen){
                createDialogue("No data for encryption provided. Please either enter data in the text field or choose a file to be encrypted.");
            }
            if(!eTextField.getText().isEmpty()){
                encryptContent = eTextField.getText();
            }
            String encrypted = controller.executeOperation("E", encryptContent);
            eTextArea.setText(encrypted);
        });

        // Set action for execution button on decryption side.
        dGoButton.setOnAction(e ->
        {
            if(dTextField.getText().isEmpty() && !dFileChosen){
                createDialogue("No data for decryption provided. Please either enter data in the text field or choose a file to be decrypted.");
            }
            if(!dTextField.getText().isEmpty()){
                decryptContent = dTextField.getText();
            }
            String decrypted = controller.executeOperation("D", decryptContent);
            dTextArea.setText(decrypted);
        });

        // Separators for dividing sections.
        Separator separator1 = new Separator();
        separator1.setOrientation(Orientation.HORIZONTAL);

        Separator separator2 = new Separator();
        separator1.setOrientation(Orientation.HORIZONTAL);

        Separator separator3 = new Separator();
        separator1.setOrientation(Orientation.HORIZONTAL);

        Separator separator4 = new Separator();
        separator1.setOrientation(Orientation.HORIZONTAL);

        // Add elements to encryption and decryption sides.
        leftControl.getChildren().addAll(separator1, new Label("Enter Data:"), eTextField, new Label("or"), eOpenButton, separator2, eGoButton, eTextArea);
        rightControl.getChildren().addAll(separator3, new Label("Enter Data:"), dTextField, new Label("or"), dOpenButton, separator4, dGoButton, dTextArea);

        // Set spacing between elements stacked vertically on each side.
        leftControl.setSpacing(10);
        rightControl.setSpacing(10);

        splitPane.getItems().addAll(leftControl, rightControl); // Add encryption and decryption side to the split pane.

        Scene scene = new Scene(splitPane);
        primaryStage.setScene(scene);
    }

    /**
     * Create and display a warning dialogue box with the provided message.
     * @param message to be displayed.
     */
    public void createDialogue(String message){
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Warning");
        ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    /**
     * Open the given file.
     * @param file File object to be opened.
     */
    public String openFile(File file) {
        StringBuilder text = new StringBuilder();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                text.append(myReader.nextLine()).append("\n");
            }
            myReader.close();
        } catch (IOException ex) {
            Logger.getLogger(AppView.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO: make sure whichever method is taking in this string is also checking that it is not blank string before proceeding.
        System.out.println(text);
        return text.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
