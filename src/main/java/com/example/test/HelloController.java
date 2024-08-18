package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.TextField;


public class HelloController {


    @FXML
    protected void onClick() {

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String ConInfo = "jdbc:postgresql://localhost:5432/PostgreSQL 16";
            Connection con=DriverManager.getConnection(ConInfo,"PostgreSQL","12345678") ;
            String qry ="INSERT INTO region VALUES ("+this.ID1_text.getText()+", '"+this.Name_text.getText()+"')";

        } catch ( Exception e) {
            JOptionPane.showConfirmDialog(null,e.toString());
        //    throw new RuntimeException(e);
        }
;




    }
}