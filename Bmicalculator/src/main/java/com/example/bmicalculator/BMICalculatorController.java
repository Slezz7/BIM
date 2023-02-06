package com.example.bmicalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BMICalculatorController {

    @FXML
    private TextField ageTxt;

    @FXML
    private Button calculateButton;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TextField heightTxt;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField weightTxt;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try {
            Double weightValue = Double.parseDouble(weightTxt.getText());
            Double heightValue = Double.parseDouble(heightTxt.getText());
            Double bmiValue = weightValue/((heightValue/100)*(heightValue/100));
            weightTxt.clear();
            heightTxt.clear();
            setResult(bmiValue);
        } catch (Exception e) {

        }

      }


    /*private void exit() {
        if (ageTxt <= 18) {
            exit();
        }*/

    //}

    private void setResult(Double bmiValue) {
        tf1.setText(bmiValue.toString());
        if (bmiValue <= 18.5) {
            tf2.setText("Du vejer for lidt");
        } else if (18.5 <= bmiValue && bmiValue <= 24.9) {
            tf2.setText("Din vægt er passende");
        } else if (25 <= bmiValue && bmiValue <= 29.9) {
            tf2.setText("Du er overvægtig");
        } else {
            tf2.setText("Du er svært overvægtig");
        }
    }

    @FXML
    void colorRadioButtonSelected(ActionEvent event) {

    }

    /*public class BMISaver {

        public void main(String[] args) {
            try {
                // Load the JDBC driver
                Class.forName("jdbc:sqlserver://localhost");

                // Connect to the database
                Connection con = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost/BMIcalculator", "sa", "dit_SuPeR_password");

                // Get user input for BMI
                double weight = Double.parseDouble(weightTxt.getText()); // get user input for weight
                double height = Double.parseDouble(heightTxt.getText()); // get user input for height
                double bmi = weight/((height/100)*(height/100)); // calculate BMI using weight and height

                // Insert user input into the database
                String insertQuery = "INSERT INTO measurement (bmi_result, date_taken) VALUES (?, ?)\";\n";
                PreparedStatement insertStatement = con.prepareStatement(insertQuery);
                insertStatement.setDouble(1, bmi);
                insertStatement.setDate(2, new java.sql.Date(System.currentTimeMillis()));

                insertStatement.executeUpdate();

                // Close the connection to the database
                con.close();
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }*/

}
