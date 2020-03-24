package com.grupp1.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;


/***
 *  This class is for the help Window and the about window.
 */

public class HelpGUI {

    public void display() throws FileNotFoundException {
        Stage stage = new Stage();

        File file = new File("Help.txt");
        FileInputStream input = new FileInputStream("./Logo.png");
        Image image = new Image(input);
        ImageView logo = new ImageView(image);

        Label label = new Label("How to use this program");
        label.setFont(Font.font(20));

        TextArea textArea = new TextArea();
        textArea.setEditable(true);
        textArea.setWrapText(true);

        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null)
                stringBuilder.append(line + "\n");
            br.close();
        }catch(IOException e) {
            e.printStackTrace();
        }

        textArea.setText(stringBuilder.toString());

        Button aboutBtn = new Button("About");
        aboutBtn.setOnAction(e->{
            try {
                about();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> {
            stage.close();
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(closeBtn,aboutBtn);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(logo,label);

        HBox hBox3 = new HBox();
        hBox3.setAlignment(Pos.CENTER);
        hBox3.getChildren().add(textArea);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBox2);
        borderPane.setCenter(hBox3);
        borderPane.setBottom(hBox);
        Scene scene = new Scene(borderPane, 500, 700);
        stage.setTitle("Problem Tracker " + "\t Help");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    public void about() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("./Logo.png");
        Image image = new Image(input);
        ImageView logo = new ImageView(image);

        String programName = "ConcertBuddy";
        String version = "1.0 alpha";
        Alert alertWindow = new Alert(Alert.AlertType.INFORMATION);
        alertWindow.setTitle("ConcertBuddy");
        alertWindow.setHeaderText(programName + " - Version " + version + "\n"
                + "\nA Concert database program to add and check out concert" +
                "\nThe program was made with Hibernate in the Database course at:\n" +
                "\nYrkesAkademin Sundsvall - HT2019");
        alertWindow.setContentText("The man behind the code: \n Fredrik Lax");
        alertWindow.setGraphic(logo);
        alertWindow.showAndWait();


    }

}
