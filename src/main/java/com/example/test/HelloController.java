package com.example.test;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class HelloController {
    @FXML
    private TextField ID_text;
    @FXML
    private TextField Name_text;
    @FXML
    private TextField Secound_name;
    @FXML
    private TextField Last_Name;
    @FXML
    private TextField Nationality;
    @FXML
    private TextField Pan_Num;
    @FXML
    private TextField Phone1;
    @FXML
    private TextField phone2;
    @FXML
    private TextField Email;
    @FXML
    private TextField Street_Name;
    @FXML
    private TextField City;
    @FXML
    private TextField Country;
    @FXML
    private TextField Passport_Num;
    @FXML
    private TextField Promo_Code;
    @FXML
    private ChoiceBox Gender;
    @FXML
    private DatePicker Date_Birth;


    @FXML
    protected void onClick1() {
        //if  (this.g== Passenger_Add_btn ){
        Connection con = null;
        PreparedStatement pstmt = null;


        try {

            DriverManager.registerDriver(new org.postgresql.Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/Airport_DataBase";
            con = DriverManager.getConnection(conInfo, "postgres", "12345678");

            String qry = "INSERT INTO person ("
                    + "p_id, "
                    + "P_Name, "
                    + "DateOfBirth, "
                    + "Nationality, "
                    + "PAN_Acc, "
                    + "Gender, "
                    + "Address, "
                    + "Contact) "
                    + "VALUES (?, ROW(?, ?, ?), ?, ?, ?, ?, ROW(?, ?, ?), ROW(?, ?, ?))";

            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID_text.getText())); // P_ID
            pstmt.setString(2, Name_text.getText()); // P_Name.FirstName
            pstmt.setString(3, Secound_name.getText()); // P_Name.MiddleName
            pstmt.setString(4, Last_Name.getText()); // P_Name.LastName
            pstmt.setDate(5, java.sql.Date.valueOf(Date_Birth.getValue())); // DateOfBirth
            pstmt.setString(6, Nationality.getText()); // Nationality
            pstmt.setInt(7, Integer.parseInt(Pan_Num.getText())); // PAN_Acc

            // Gender as CHAR
            String gender = (String) Gender.getValue();
            pstmt.setString(8, (gender != null && !gender.isEmpty()) ? gender.substring(0, 1) : null);

            pstmt.setString(9, Street_Name.getText()); // Address.StreetName
            pstmt.setString(10, City.getText()); // Address.City
            pstmt.setString(11, Country.getText()); // Address.Country
            pstmt.setInt(12, Integer.parseInt(Phone1.getText())); // Contact.Phone1
            pstmt.setInt(13, Integer.parseInt(phone2.getText())); // Contact.Phone2
            pstmt.setString(14, Email.getText()); // Contact.Email

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data inserted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Insertion failed.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }


        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/Airport_DataBase";
            con = DriverManager.getConnection(conInfo, "postgres", "12345678");

            // Corrected SQL Query
            String qry = "INSERT INTO passenger ("
                    + "p_id, "
                    + "passport_num, "
                    + "promocode) "
                    + "VALUES (?, ?, ?)";

            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID_text.getText())); // p_id
            pstmt.setInt(2, Integer.parseInt(Passport_Num.getText())); // passport_num
            pstmt.setInt(3, Integer.parseInt(Promo_Code.getText())); // promocode

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data inserted successfully!");
                  ID_text.setText(null);
                  Name_text.setText(null);
                  Secound_name.setText(null);
                  Last_Name.setText(null);
                  Nationality.setText(null);
                  Pan_Num.setText(null);
                  Phone1.setText(null);
                  phone2.setText(null);

                  Email.setText(null);
                  Street_Name.setText(null);
                  City.setText(null);
                  Country.setText(null);
                  Passport_Num.setText(null);
                  Promo_Code.setText(null);
                  Gender.setValue(null);
                  Date_Birth.setValue(null);


            } else {
                JOptionPane.showMessageDialog(null, "Insertion failed.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }


    }




}