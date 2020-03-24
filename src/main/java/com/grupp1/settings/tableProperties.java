package com.grupp1.settings;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class have all the settings and Columns for the tableview.
 */


public class tableProperties {



    public tableProperties() {
    }

    public static TableColumn columnArtist(String string, TableView<Concert> movieTable) {
        TableColumn columnArtist = new TableColumn("Artist/Band");
        columnArtist.setResizable(false);
        columnArtist.setPrefWidth(400);
        columnArtist.setCellValueFactory(new PropertyValueFactory<String, Concert>(string));
        columnArtist.setEditable(true);
        columnArtist.setStyle("-fx-alignment: CENTER;");

        return columnArtist;
    }

    public static TableColumn columnDate(String string, TableView<Concert> movieTable) {
        TableColumn columnDate = new TableColumn("Date");
        columnDate.setResizable(false);
        columnDate.setPrefWidth(310);
        columnDate.setCellValueFactory(new PropertyValueFactory<String, Concert>(string));
        columnDate.setEditable(true);
        columnDate.setStyle("-fx-alignment: CENTER;");

        return columnDate;
    }

    public TableColumn columnPeople(String string, TableView<Person> movieTable) {
        TableColumn columnPeople = new TableColumn("People Going");
        columnPeople.setResizable(false);
        columnPeople.setPrefWidth(190);
        columnPeople.setCellValueFactory(new PropertyValueFactory<String, Person>(string));
        columnPeople.setStyle("-fx-alignment: CENTER;");


        return columnPeople;
    }

    public TableColumn columnAge(String string, TableView<Person> movieTable) {
        TableColumn columnAge = new TableColumn("Age");
        columnAge.setResizable(false);
        columnAge.setPrefWidth(63);
        columnAge.setCellValueFactory(new PropertyValueFactory<String, Person>(string));
        columnAge.setEditable(true);


        return columnAge;
    }

    public static TableColumn columnArtistGoing(String string, TableView<Concert> movieTable) {
        TableColumn columnArtist = new TableColumn("Artist/Band");
        columnArtist.setResizable(false);
        columnArtist.setPrefWidth(240);
        columnArtist.setCellValueFactory(new PropertyValueFactory<String, String>(string));
        columnArtist.setEditable(true);
        columnArtist.setStyle("-fx-alignment: CENTER;");

        return columnArtist;
    }


    public static TableColumn columnDateGoing(String string, TableView<Concert> movieTable) {
        TableColumn columnDate = new TableColumn("Date");
        columnDate.setResizable(false);
        columnDate.setPrefWidth(140);
        columnDate.setCellValueFactory(new PropertyValueFactory<String, String>(string));
        columnDate.setEditable(true);
        columnDate.setStyle("-fx-alignment: CENTER;");


        return columnDate;
    }

    public static TableColumn columnPeopleGoing(String string, TableView<Person> movieTable) {
        TableColumn columnPeopleGoing = new TableColumn("People");
        columnPeopleGoing.setResizable(false);
        columnPeopleGoing.setPrefWidth(190);
        columnPeopleGoing.setCellValueFactory(new PropertyValueFactory<String, Person>(string));
        columnPeopleGoing.setEditable(true);
        columnPeopleGoing.setStyle("-fx-alignment: CENTER;");


        return columnPeopleGoing;
    }

    public static TableColumn columnAgeGoing(String string, TableView<Person> movieTable) {
        TableColumn columnAge = new TableColumn("Age");
        columnAge.setResizable(false);
        columnAge.setPrefWidth(63);
        columnAge.setCellValueFactory(new PropertyValueFactory<String, Person>(string));
        columnAge.setEditable(true);


        return columnAge;
    }



    public static void tableSettingsConcert(TableView<Concert> movieTable) {
        movieTable.setEditable(false);
        movieTable.setPrefSize(400, 280);

    }
    public static void tableSettingsPerson(TableView<Person> movieTable) {
        movieTable.setEditable(false);
        movieTable.setPrefSize(300, 680);

    }

    public static void tableSettingsGoingPerson(TableView<Person> Table) {
        Table.setEditable(true);
        Table.setPrefSize(400, 280);

    }

    public static void tableSettingsGoingPersonConcert(TableView<Concert> Table) {
        Table.setEditable(true);
        Table.setPrefSize(400, 280);

    }



}



