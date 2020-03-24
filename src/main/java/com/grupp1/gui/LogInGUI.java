package com.grupp1.gui;


import com.grupp1.hibernate.HibernateUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 *  This Class is the GUI for the Login window
 */

public class LogInGUI {
    MainGUI mainGUI = new MainGUI();
    HibernateUtil hibernateUtil = new HibernateUtil();
    public LogInGUI() throws FileNotFoundException {
    }


    public void display() throws FileNotFoundException, SQLException {
        Stage stage = new Stage();

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
        });

        Label user = new Label("Username");
        Label passwordLabel = new Label("Password");

        TextField userField = new TextField();
        userField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("password");

        Button loginBtn = new Button("Login");
        loginBtn.setOnAction(e -> {
            HibernateUtil.user = userField.getText();
            HibernateUtil.pass = passwordField.getText();
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                mainGUI.display();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            stage.close();

        });

        //--GENERAL GUI SETTINGS--
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(logo);
        VBox vbox2 = new VBox();
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().addAll(loginBtn);
        vbox2.setPadding(new Insets(0, 0, 5, 0));
        VBox vBox = new VBox();
        vBox.getChildren().addAll(user, userField, passwordLabel, passwordField);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(vBox);
        borderPane.setBottom(vbox2);


        Scene scene = new Scene(borderPane, 410, 260);

        stage.setTitle("Lax Movie DataBase");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }// GENERAL GUI SETTINGS
}
