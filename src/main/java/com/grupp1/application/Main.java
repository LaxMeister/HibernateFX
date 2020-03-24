package com.grupp1.application;

//import GUI.LogInGUI;

import com.grupp1.gui.LogInGUI;
import com.grupp1.gui.MainGUI;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

/**
 * Main class that initiate the GUI.
 */

public class Main extends Application {
    LogInGUI logInGUI = new LogInGUI();
    MainGUI mainGUI = new MainGUI();


    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        logInGUI.display();
//        mainGUI.display();
    }
}
