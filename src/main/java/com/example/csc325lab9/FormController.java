package com.example.csc325lab9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FormController {

    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label email;
    @FXML
    private Label dateOfBirth;
    @FXML
    private Label zipCode;

    private String submittedFirstName;
    private String submittedLastName;
    private String submittedEmail;
    private String submittedDOB;
    private String submittedZipCode;

    //Sets each label with their form text.
    @FXML
    public void initialize(){
        firstName.setText("First Name: " + submittedFirstName);
        lastName.setText("Last Name: " + submittedLastName);
        email.setText("Email: " + submittedEmail);
        dateOfBirth.setText("Date Of Birth: " + submittedDOB);
        zipCode.setText("Zip Code: " + submittedZipCode);
    }

    //Sets the string values ahead of time so the info can be given to Initialize.
    public void setSomeData(String firstName, String lastName, String Email, String DOB, String ZIP){
        submittedFirstName = firstName;
        submittedLastName = lastName;
        submittedEmail = Email;
        submittedDOB = DOB;
        submittedZipCode = ZIP;
    }

}
