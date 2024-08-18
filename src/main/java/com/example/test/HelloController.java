package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private TextField ID1_text;
    @FXML
    private TextField Name_text;

    @FXML
    protected void onClick() {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/store";
            con = DriverManager.getConnection(conInfo, "postgres", "12345678");

            String qry = "INSERT INTO region (\"New\") VALUES (?)";
            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID1_text.getText()));
          //  pstmt.setString(2, Name_text.getText());

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
}
