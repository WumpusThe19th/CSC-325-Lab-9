package com.example.csc325lab9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.regex.*;

public class RegistrationController {
    String namePattern = "\\w{2,25}";
    String lectureEmailPattern = "[a-zA-Z0-9]{3,15}@[a-zAZ0-9]{3,15}[.][a-zA-Z]{2,5}";
    String emailPattern = "[a-zA-Z]{3,15}@farmingdale[.]edu";
    String dobPattern = "\\d{2}/\\d{2}/\\d{4}";
    String zipPattern = "\\d{5}";
    @FXML
    private Label welcomeText;

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField dobField;
    @FXML
    private TextField zipCodeField;

    @FXML
    private Label firstNameShout;

    @FXML
    private Label lastNameShout;

    @FXML
    private Label emailShout;

    @FXML
    private Label dobShout;

    @FXML
    private Label zipShout;
    @FXML
    private Button addButton;

    private boolean firstNameGood = false;
    private boolean lastNameGood = false;
    private boolean emailGood = false;
    private boolean dobGood = false;
    private boolean zipGood = false;

    @FXML
    public void initialize() {
        // Set up listeners in the initialize method
        firstNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            onFirstNameUpdated(newValue);
        });
        lastNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            onLastNameUpdated(newValue);
        });
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            onEmailUpdated(newValue);
        });
        dobField.textProperty().addListener((observable, oldValue, newValue) -> {
            onDOBUpdated(newValue);
        });
        zipCodeField.textProperty().addListener((observable, oldValue, newValue) -> {
            onZipUpdated(newValue);
        });
    }

    //Methods to listen for when the field is updated.
    public void onFirstNameUpdated(String newText) {
        Pattern p = Pattern.compile(namePattern);
        boolean tOne = newText.matches(namePattern);
        System.out.println(newText + " is valid:" + tOne);
        if (!tOne){
            firstNameShout.setOpacity(1.0);
            if (!this.addButton.isDisabled()){
                addButton.setDisable(true);
                firstNameGood = false;
            }
        }
        else{firstNameShout.setOpacity(0.0); firstNameGood = true; shouldEnable();}
    }

    public void onLastNameUpdated(String newText) {
        Pattern p  = Pattern.compile(namePattern);
        boolean tTwo = newText.matches(namePattern);
        System.out.println(lastNameField.getText() + " is valid:" + tTwo);
        if (!tTwo){
            lastNameShout.setOpacity(1.0);
            if (!this.addButton.isDisabled()){
                addButton.setDisable(true);
                lastNameGood = false;
            }
        }
        else{lastNameShout.setOpacity(0.0); lastNameGood = true; shouldEnable();}
    }

    public void onEmailUpdated(String newText) {
        Pattern p = Pattern.compile(emailPattern);
        boolean tThree = emailField.getText().matches(emailPattern);
        System.out.println(emailField.getText() + " is valid:" + tThree);
        if (!tThree){
            emailShout.setOpacity(1.0);
            if (!this.addButton.isDisabled()){
                addButton.setDisable(true);
                emailGood = false;
            }
        }
        else{emailShout.setOpacity(0.0); emailGood = true; shouldEnable();}
    }

    public void onDOBUpdated(String newText) {
        Pattern p = Pattern.compile(dobPattern);
        boolean tFour = dobField.getText().matches(dobPattern);
        System.out.println(dobField.getText() + " is valid:" + tFour);
        if (!tFour){
            dobShout.setOpacity(1.0);
            if (!this.addButton.isDisabled()){
                addButton.setDisable(true);
                dobGood = false;
            }
        }
        else{dobShout.setOpacity(0.0); dobGood = true; shouldEnable();}
    }

    public void onZipUpdated(String newText) {
        Pattern p = Pattern.compile(zipPattern);
        boolean tFive = zipCodeField.getText().matches(zipPattern);
        System.out.println(zipCodeField.getText() + " is valid:" + tFive);
        if (!tFive){
            zipShout.setOpacity(1.0);
            if (!this.addButton.isDisabled()){
                addButton.setDisable(true);
                zipGood = false;
            }
        }
        else{zipShout.setOpacity(0.0); zipGood = true; shouldEnable();}
    }

    //Checks if all the flags to allow the Add Button are true, then enables the button
    protected void shouldEnable(){
        if (firstNameGood && lastNameGood && emailGood && dobGood && zipGood) {
            addButton.setDisable(false);
        }
    }

    @FXML
    public void onAddButtonClick(ActionEvent e) throws IOException {
        HelloApplication.switchToForm(firstNameField.getText(), lastNameField.getText(), emailField.getText(), dobField.getText(), zipCodeField.getText());
    }
}