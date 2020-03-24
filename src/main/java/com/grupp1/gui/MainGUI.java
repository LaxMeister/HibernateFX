package com.grupp1.gui;



import com.grupp1.hibernate.CriteriaHib;
import com.grupp1.settings.Concert;
import com.grupp1.settings.Person;
import com.grupp1.settings.tableProperties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This is the class for the program where all the visual object are created and run.
 */


public class MainGUI {

    // -- VARIABLES --
    public static String info = "Click me";
    public static int categoryID;
    TableView<Person> goingTable = new TableView<Person>();
    TableView<Concert> concertTable = new TableView<Concert>();
    com.grupp1.settings.tableProperties tableProperties = new tableProperties();
    ObservableList<Concert> obListConcert = FXCollections.observableArrayList();
    ObservableList<Person> obListPerson = FXCollections.observableArrayList();
    CriteriaHib criteriaHib = new CriteriaHib();
    AddGUI addGUI = new AddGUI();
    GoingGUI goingGUI = new GoingGUI();
    PersonGUI personGUI = new PersonGUI();
    TextArea textArea = new TextArea();
    Concert concert = new Concert();


    // -- CONSTRUCTOR --

    public MainGUI() {
    }

    // -- MAIN METHOD --

    public void display() throws FileNotFoundException {
        Stage stage = new Stage();

        criteriaHib.getSearchResult(info,obListConcert);
        concertTable.setItems(obListConcert);

        // -- GENERAL OBJECT SETTINGS --

        goingTable.setPrefSize(260, 600);
        textArea.setPrefSize(700, 220);
        textArea.setWrapText(true);

        Label descriptionLabel = new Label("DESCRIPTION:");
        Label emptyLabelForDesignPurpose = new Label("              ");

        TextField searchBox = new TextField();

        searchBox.setPromptText("Search for Concert");
        searchBox.setPrefWidth(140);

        FileInputStream input = new FileInputStream("./Logo.png");
        Image image = new Image(input);
        ImageView logo = new ImageView(image);
        logo.setOnMouseClicked(e -> {
            HelpGUI helpGUI = new HelpGUI();
            try {
                helpGUI.display();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });//GENERAL OBJECT SETTINGS


        // -- TABLE VIEW ---
        concertTable.getColumns().addAll(tableProperties.columnArtist("artist", concertTable),
                tableProperties.columnDate("date",concertTable));
        tableProperties.tableSettingsConcert(concertTable);
        concertTable.setOnMouseClicked(e->{
            goingTable.getItems().removeAll(obListPerson);
            Concert description =  concertTable.getSelectionModel().getSelectedItem();
            String name = description.getArtist();
            int id = description.getConcert_id();
            criteriaHib.getDescription(name,textArea);
            criteriaHib.getPersonsGoing(id,obListPerson);
            goingTable.setItems(obListPerson);
        });

        goingTable.getColumns().addAll(tableProperties.columnPeople("name",goingTable),
                tableProperties.columnAge("age",goingTable));
        tableProperties.tableSettingsPerson(goingTable);
        goingTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                        try {
                            Person personInfo = goingTable.getSelectionModel().getSelectedItem();
                            String personName = personInfo.getName();
                            String personAge = personInfo.getAge();
                            String personDescription = personInfo.getDescription();
                            personGUI.displayPerson(personName,personAge,personDescription);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        // -- BUTTONS AND COMBOBOX---

        Button AddPersonBtn = new Button("Add Person");
        AddPersonBtn.setOnAction(e -> {
            try {
                addGUI.displayAddPerson();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        Button addConcertBtn = new Button("Add Concert");
        addConcertBtn.setOnAction(e -> {
            try {
                addGUI.displayAddConcert();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        Button addConcertPeopleBtn = new Button("I'm Going");
        addConcertPeopleBtn.setOnAction(e->{
            try {
                goingGUI.displayImGoing();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        Button searchBtn = new Button("Search");
        searchBtn.setOnAction(e -> {
            concertTable.getItems().removeAll(obListConcert);
            criteriaHib.getSearchResult(searchBox.getText(), obListConcert);
            concertTable.setItems(obListConcert);
            searchBox.clear();

        });

        ObservableList<String> options =
                FXCollections.observableArrayList("All Concerts", "Classical", "EDM", "Hip-hop", "Metal",
                        "Pop", "R&B", "Rock", "Soundtrack", "Soul/Blues");
        ComboBox comboBox = new ComboBox(options);
        comboBox.setPromptText("Genre");
        comboBox.setOnAction(e->{
            concertTable.getItems().removeAll(obListConcert);
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
            if (comboBox.getValue().toString().equals("All Concerts")){
                criteriaHib.getAllConcerts(obListConcert);
            }

            criteriaHib.getArtistFromGenre(categoryID, obListConcert,textArea);
            concertTable.setItems(obListConcert);
            System.out.println(categoryID);
        });
        // BUTTONS AND COMBOBOX

        // -- GENERAL GUI SETTINGS ---

        StackPane stackPane = new StackPane();
        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPosition(1, 1);
        splitPane.setPrefSize(1, 500);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(10, 7, 0, 0));

        HBox hboxx = new HBox();
        hboxx.getChildren().addAll(descriptionLabel);

        GridPane gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(20, 0, 20, 45));
        gridPane2.setAlignment(Pos.TOP_CENTER);
        gridPane2.add(descriptionLabel, 0, 0);
        gridPane2.add(emptyLabelForDesignPurpose, 1, 1);
        gridPane2.add(textArea, 0, 1);

        VBox hBox = new VBox();
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.setPrefHeight(100);
        hBox.setPadding(new Insets(10, 0, 10, 25));
        hBox.getChildren().addAll(logo);

        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.BOTTOM_RIGHT);
        hbox2.setPadding(new Insets(0, 0, 0, 0));
        hbox2.getChildren().addAll(searchBox, searchBtn);
        hbox2.setSpacing(10);

        HBox hbox3 = new HBox();
        hbox3.setAlignment(Pos.BOTTOM_RIGHT);
        hbox3.setPadding(new Insets(0, 0, 0, 0));
        hbox3.getChildren().addAll(comboBox, AddPersonBtn, addConcertBtn,addConcertPeopleBtn);
        hbox3.setSpacing(10);

        VBox vBox2 = new VBox();
        vBox2.setPadding(new Insets(40, 0, 20, 180));
        vBox2.setSpacing(20);
        vBox2.getChildren().addAll(hbox2, hbox3);

        GridPane gridPane3 = new GridPane();
        gridPane3.add(hBox, 0, 0);
        gridPane3.add(vBox2, 1, 0);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(goingTable);
        vBox.setPadding(new Insets(0,10,0,0));

        BorderPane borderPane = new BorderPane();
        BorderPane borderPane2 = new BorderPane();
        borderPane.setTop(gridPane3);
        borderPane.setCenter(splitPane);
        borderPane.setLeft(borderPane2);
        borderPane.setRight(vBox);
        borderPane2.setTop(concertTable);
        borderPane2.setCenter(gridPane);
        borderPane2.setBottom(gridPane2);
        stackPane.getChildren().add(borderPane);
        Scene scene = new Scene(stackPane, 1050, 720);
        stage.setTitle("ConcertBuddy");
        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();//GENERAL GUI SETTINGS
    }
}
