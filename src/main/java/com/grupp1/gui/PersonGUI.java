package com.grupp1.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PersonGUI {

    private int categoryID;

    private int concertID;
    String artistName;

    public void displayPerson(String name, String age, String description) throws FileNotFoundException {
        Stage stage = new Stage();
        int random = (int)(5.0 * Math.random());
        File file = new File("Help.txt");
        FileInputStream input = new FileInputStream("./"+ random +".png");
        Image image = new Image(input);
        ImageView logo = new ImageView(image);
        TextField nameField = new TextField();
        nameField.setEditable(false);
        nameField.setText(name);
        TextField ageField = new TextField();
        ageField.setEditable(false);
        ageField.setText(age);
        TextArea descriptionArea = new TextArea();
        descriptionArea.setWrapText(true);
        descriptionArea.setEditable(false);
        descriptionArea.setText(description);
        Label nameLabel = new Label("Name:");
        Label ageLabel = new Label("Age:");
        Label aboutYou = new Label("About me:");

        Button CloseBtn = new Button("Close");
        CloseBtn.setOnAction(e->{
            stage.close();

        });


        HBox hBox = new HBox();
        hBox.getChildren().addAll(CloseBtn);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(nameLabel,nameField);
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(ageLabel,ageField);
        hBox3.setSpacing(21);
        hBox3.setAlignment(Pos.CENTER);

        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(logo);

        VBox vBox3 = new VBox();
        vBox3.setAlignment(Pos.CENTER);
        vBox3.getChildren().addAll(hBox2,hBox3, aboutYou , descriptionArea);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBox2);
        borderPane.setCenter(vBox3);
        borderPane.setBottom(hBox);
        Scene scene = new Scene(borderPane, 300, 300);
        stage.setTitle("ConcertBuddy: " + name);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }
}
