package com.example.test;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
  // @FXML
   //private Button Passenger_Add_btn;


    //@FXML
   /* protected void onClick( ) {
   //if  (this.g== Passenger_Add_btn ){
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/Airport_DataBase";
            con = DriverManager.getConnection(conInfo, "postgres", "12345678");
            String qry = "INSERT INTO person (\"p_id\",\"nationality\") VALUES (?, ?)";
            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID_text.getText())); // Setting the first placeholder
            pstmt.setString(2, Name_text.getText());              // Setting the second placeholder
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
    }
*/
/*

    @FXML
    void add_Button (ActionEvent event) throws IOException {

        //if  (this.g== Passenger_Add_btn ){
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/Airport_DataBase";
            con = DriverManager.getConnection(conInfo, "postgres", "12345678");
            String qry = "INSERT INTO person (\"p_id\",\"nationality\") VALUES (?, ?)";
            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID_text.getText())); // Setting the first placeholder
            pstmt.setString(2, Name_text.getText());              // Setting the second placeholder
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



    }
*/








    @FXML
    protected void onClick1( ) {
        //if  (this.g== Passenger_Add_btn ){
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/Airport_DataBase";
            con = DriverManager.getConnection(conInfo, "postgres", "12345678");
            String qry = "INSERT INTO person (\"p_id\",\"nationality\") VALUES (?, ?)";
            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID_text.getText())); // Setting the first placeholder
            pstmt.setString(2, Name_text.getText());              // Setting the second placeholder
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
    }
     //   }

}
