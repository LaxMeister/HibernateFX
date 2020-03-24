package com.grupp1.gui;

import com.grupp1.hibernate.AddObjectsHib;
import com.grupp1.hibernate.CriteriaHib;
import com.grupp1.settings.Concert;
import com.grupp1.settings.Person;
import com.grupp1.settings.tableProperties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GoingGUI {
    CriteriaHib criteriaHib = new CriteriaHib();

    public void displayImGoing() throws FileNotFoundException {
        Stage stage = new Stage();

        File file = new File("Help.txt");
        FileInputStream input = new FileInputStream("./LogoChooseConcert.png");
        Image image = new Image(input);
        ImageView logo = new ImageView(image);
        ObservableList<Concert> obList = FXCollections.observableArrayList();
        ObservableList<Person> obListPer = FXCollections.observableArrayList();
        AddObjectsHib addObjectsHib = new AddObjectsHib();



        TableView<Concert> concertTable = new TableView<Concert>();
        concertTable.getColumns().addAll(tableProperties.columnArtistGoing("artist", concertTable),
                tableProperties.columnDateGoing("date", concertTable));
        tableProperties.tableSettingsGoingPersonConcert(concertTable);

        TableView<Person> personTable = new TableView<Person>();
        personTable.getColumns().addAll(tableProperties.columnPeopleGoing("name", personTable),
                tableProperties.columnAgeGoing("age", personTable));
        tableProperties.tableSettingsGoingPerson(personTable);
        personTable.setOnMouseClicked(e->{
            Person person = personTable.getSelectionModel().getSelectedItem();
            System.out.println(person.toString());
        });

        criteriaHib.getArtist(obList);
        concertTable.setItems(obList);
        criteriaHib.getPerson(obListPer);
        personTable.setItems(obListPer);




        Button CloseBtn = new Button("Close");
        CloseBtn.setOnAction(e->{
            stage.close();

        });

        Button addBtn = new Button("Going");
        addBtn.setOnAction(e -> {
            Concert concert = concertTable.getSelectionModel().getSelectedItem();
            Person person = personTable.getSelectionModel().getSelectedItem();
            int personId = person.getPerson_id();
            int concertId = concert.getConcert_id();
            addObjectsHib.Addgoing(personId,concertId);

        });
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(addBtn,CloseBtn);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(0,0,50,0));

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(logo);

        BorderPane borderPane2 = new BorderPane();
        borderPane2.setRight(personTable);
        borderPane2.setLeft(concertTable);

        GridPane gridPane = new GridPane();
        gridPane.getChildren().addAll(borderPane2);
        gridPane.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();

        borderPane.setTop(vBox);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 1000, 480);
        stage.setTitle("ConcertBuddy");
        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();//GENERAL GUI SETTINGS


    }

}
