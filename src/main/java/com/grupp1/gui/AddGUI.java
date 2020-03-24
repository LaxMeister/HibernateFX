package com.grupp1.gui;


import com.grupp1.hibernate.AddObjectsHib;
import com.grupp1.hibernate.CriteriaHib;
import com.grupp1.settings.Concert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddGUI {

    AddObjectsHib addObjectsHib = new AddObjectsHib();
    CriteriaHib criteriaHib = new CriteriaHib();
    Concert concert = new Concert();
    private int categoryID;
    private int concertID;
    String artistName;

    public void displayAddPerson() throws FileNotFoundException {
        Stage stage = new Stage();

        File file = new File("Help.txt");
        FileInputStream input = new FileInputStream("./LogoAddSmall.png");
        Image image = new Image(input);
        ImageView logo = new ImageView(image);
        TextField nameField = new TextField();
        TextField ageField = new TextField();
        Label nameLabel = new Label("Name:");
        Label ageLabel = new Label("Age:");
        TextArea textArea = new TextArea();
        textArea.setText("Add a description of you here");
        textArea.setPrefWidth(100);
        textArea.setWrapText(true);

        Button CloseBtn = new Button("Close");
        CloseBtn.setOnAction(e->{
            stage.close();

        });

        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> {
            addObjectsHib.AddPerson(nameField.getText(),ageField.getText(),textArea.getText());
            nameField.clear();
            ageField.clear();
            textArea.setText("");
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(addBtn,CloseBtn);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10,0,0,0));

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
        vBox3.getChildren().addAll(hBox2,hBox3,textArea);
        vBox3.setSpacing(15);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBox2);
        borderPane.setCenter(vBox3);
        borderPane.setBottom(hBox);
        Scene scene = new Scene(borderPane, 400, 350);
        stage.setTitle("ConcertBuddy " + "\t Add");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }

    public void displayAddConcert() throws FileNotFoundException {
        Stage stage = new Stage();



        FileInputStream input = new FileInputStream("./LogoAddConcertSmall.png");
        Image image = new Image(input);
        ImageView logo = new ImageView(image);
        TextField nameField = new TextField();
        TextField timeField = new TextField();
        DatePicker datePicker = new DatePicker();
        Label artistLabel = new Label("Artist:");
        Label dateLabel = new Label("Date:");
        Label timeLabel = new Label("time:");
        timeField.setPromptText("HH:MM:SS ex 23:00:00");
        nameField.setPromptText("Name of Artist/Band");
        TextArea textArea = new TextArea();
        textArea.setText("Add a description of the concert here");
        textArea.setPrefWidth(100);
        textArea.setWrapText(true);


        ObservableList<String> options =
                FXCollections.observableArrayList("All Concerts", "Classical", "EDM", "Hip-hop", "Metal",
                        "Pop", "R&B", "Rock", "Soundtrack", "Soul/Blues");
        ComboBox comboBox = new ComboBox(options);
        comboBox.setPromptText("Genre");
        comboBox.setOnAction(e->{
            if (comboBox.getValue().toString().equals("Classical")){
                categoryID = 1;
            }
            if (comboBox.getValue().toString().equals("EDM")){
                categoryID = 2;
            }
            if (comboBox.getValue().toString().equals("Hip-hop")){
                categoryID = 3;
            }
            if (comboBox.getValue().toString().equals("Metal")){
                categoryID = 4;
            }
            if (comboBox.getValue().toString().equals("Pop")){
                categoryID = 5;
            }
            if (comboBox.getValue().toString().equals("R&B")){
                categoryID = 6;
            }
            if (comboBox.getValue().toString().equals("Rock")){
                categoryID = 7;
            }
            if (comboBox.getValue().toString().equals("Soundtrack")){
                categoryID = 8;
            }
            if (comboBox.getValue().toString().equals("Soul/Blues")){
                categoryID = 9;
            }
            System.out.println(categoryID);
        });

        Button CloseBtn = new Button("Close");
        CloseBtn.setOnAction(e->{
            stage.close();

        });

        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> {
            artistName = nameField.getText();
            LocalDate i = datePicker.getValue();
            DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String date = i.format(sdf);
            String finalDateTime = date + " " + timeField.getText();
            try {
                addObjectsHib.AddConcert(nameField.getText(),finalDateTime,categoryID,textArea.getText());
                criteriaHib.getCriteriaID(artistName);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            concertID = CriteriaHib.concert.getConcert_id();
            nameField.clear();
            timeField.clear();
            textArea.setText("");
            System.out.println(concertID);
            try {
                addObjectsHib.AddCategory(categoryID,concertID);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println(finalDateTime);
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(addBtn,CloseBtn);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(0,0,40,0));

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(artistLabel,nameField);
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(dateLabel,datePicker);
        hBox3.setSpacing(10);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setPadding(new Insets(0,0,0,25));

        HBox hBox4 = new HBox();
        hBox4.getChildren().addAll(timeLabel,timeField);
        hBox4.setSpacing(10);
        hBox4.setAlignment(Pos.CENTER);

        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(logo);

        VBox vBox3 = new VBox();
        vBox3.setAlignment(Pos.CENTER);
        vBox3.getChildren().addAll(hBox2,hBox3,hBox4,comboBox,textArea);
        vBox3.setSpacing(10);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBox2);
        borderPane.setCenter(vBox3);
        borderPane.setBottom(hBox);
        Scene scene = new Scene(borderPane, 400, 320);
        stage.setTitle("ConcertBuddy " + "\t Add");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }


}
