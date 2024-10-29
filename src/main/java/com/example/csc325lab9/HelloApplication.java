package com.example.csc325lab9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage PrimaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 420);

        PrimaryStage = stage;
        stage.setTitle("Registration Form");
        stage.setScene(scene);
        stage.show();
    }

    //Called by the Add Button to switch from the input screen to the registration form screen
    public static void switchToForm(String firstName, String lastName, String Email, String DOB, String ZIP) throws IOException {
        System.out.println("So yeah");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("form.fxml"));
        FormController comptrol = new FormController();
        fxmlLoader.setController(comptrol);
        comptrol.setSomeData(firstName, lastName, Email, DOB, ZIP);
        Scene scene = new Scene(fxmlLoader.load(), 420, 300);
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}