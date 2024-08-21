package com.example.test;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.collections.transformation.FilteredList;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import com.example.test.Passenger_table;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


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
    private TextField ID_Passenger_delete;
    @FXML
    private TextField Name_Passenger_delete;
    @FXML
    private TextField Secound_name_Passenger_delete;
    @FXML
    private TextField Last_Name_Passenger_delete;



    @FXML
    private TextField ID_text_update;
    @FXML
    private TextField Name_text_update;
    @FXML
    private TextField Secound_name_update;
    @FXML
    private TextField Last_Name_update;
    @FXML
    private TextField Nationality_update;
    @FXML
    private TextField Pan_Num_update;
    @FXML
    private TextField Phone1_update;
    @FXML
    private TextField phone2_update;
    @FXML
    private TextField Email_update;
    @FXML
    private TextField Street_Name_update;
    @FXML
    private TextField City_update;
    @FXML
    private TextField Country_update;
    @FXML
    private TextField Passport_Num_update;
    @FXML
    private TextField Promo_Code_update;
    @FXML
    private ChoiceBox Gender_update;
    @FXML
    private DatePicker Date_Birth_update;


    @FXML
    private TableView<Passenger_table> Passenger_table;

    @FXML
    private TableColumn<Passenger_table, Integer> id_t;

    @FXML
    private TableColumn<Passenger_table, String> name_t;

    @FXML
    private TableColumn<Passenger_table, String> nationality_t;

    @FXML
    private TableColumn<Passenger_table, String> Gender_t;

    @FXML
    private TableColumn<Passenger_table, String> contact_t;

    @FXML
    private TableColumn<Passenger_table, String> Address_t;

    @FXML
    private TableColumn<Passenger_table, Integer> Promocpde_t;

    @FXML
    private TableColumn<Passenger_table, Integer> bank_T;

    @FXML
    private TableColumn<Passenger_table, Integer> Passport_t; // Updated to Integer

    @FXML
    private Button All_table;

    private ObservableList<Passenger_table> dataList = FXCollections.observableArrayList();


    @FXML
    private TextField Nationality_Filter;
    @FXML
    private Button Nationality_table;

    @FXML
    private TextField min;
    @FXML
    private TextField max;
    @FXML
    private Button promocode_table;

    @FXML
    private TextField age;
    @FXML
    private Button Age_table;



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


    @FXML
    protected void onClick2() {
        Connection con = null;
        PreparedStatement pstmt = null;



        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/Airport_DataBase";
            con = DriverManager.getConnection(conInfo, "postgres", "12345678");

            // Corrected SQL Query for Deletion

            String qry = "DELETE FROM passenger WHERE \"p_id\" = ?";

            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID_Passenger_delete.getText())); // P_ID

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Deletion failed.");
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
            // Corrected SQL Query for Deletion
            String qry = "DELETE FROM person WHERE \"p_id\" = ? AND \"p_name\" = ROW(?, ?, ?)";

            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID_Passenger_delete.getText())); // P_ID
            pstmt.setString(2, Name_Passenger_delete.getText()); // P_Name.FirstName
            pstmt.setString(3, Secound_name_Passenger_delete.getText()); // P_Name.MiddleName
            pstmt.setString(4, Last_Name_Passenger_delete.getText()); // P_Name.LastName


            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data deleted successfully!");
                ID_Passenger_delete.setText(null);
                Name_Passenger_delete.setText(null);
                Secound_name_Passenger_delete.setText(null);
                Last_Name_Passenger_delete.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Deletion failed.");
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

    @FXML
    protected void onSearchClick() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/Airport_DataBase";
            con = DriverManager.getConnection(conInfo, "postgres", "12345678");

            String qry = "SELECT p.p_id, p.P_Name, p.DateOfBirth, p.Nationality, p.PAN_Acc, p.Gender, "
                    + "p.Address, p.Contact, pas.passport_num, pas.promocode "
                    + "FROM person p JOIN passenger pas ON p.p_id = pas.p_id WHERE p.p_id = ?";

            pstmt = con.prepareStatement(qry);
            pstmt.setInt(1, Integer.parseInt(ID_text_update.getText()));

            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Removing parentheses from the composite attributes
                String[] nameParts = rs.getString("P_Name").replaceAll("[()]", "").split(",");
                Name_text_update.setText(nameParts[0].trim());
                Secound_name_update.setText(nameParts.length > 1 ? nameParts[1].trim() : "");
                Last_Name_update.setText(nameParts.length > 2 ? nameParts[2].trim() : "");

                Date_Birth_update.setValue(rs.getDate("DateOfBirth").toLocalDate());
                Nationality_update.setText(rs.getString("Nationality"));
                Pan_Num_update.setText(rs.getString("PAN_Acc"));
                Gender_update.setValue(rs.getString("Gender"));

                // Removing parentheses from Address
                String[] addressParts = rs.getString("Address").replaceAll("[()]", "").split(",");
                Street_Name_update.setText(addressParts[0].trim());
                City_update.setText(addressParts.length > 1 ? addressParts[1].trim() : "");
                Country_update.setText(addressParts.length > 2 ? addressParts[2].trim() : "");

                // Removing parentheses from Contact
                String[] contactParts = rs.getString("Contact").replaceAll("[()]", "").split(",");
                Phone1_update.setText(contactParts[0].trim());
                phone2_update.setText(contactParts.length > 1 ? contactParts[1].trim() : "");
                Email_update.setText(contactParts.length > 2 ? contactParts[2].trim() : "");

                Passport_Num_update.setText(rs.getString("passport_num"));
                Promo_Code_update.setText(rs.getString("promocode"));
            } else {
                JOptionPane.showMessageDialog(null, "No data found for the given ID.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }

    @FXML
    protected void onUpdateClick() {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            String conInfo = "jdbc:postgresql://localhost:5432/Airport_DataBase";
            con = DriverManager.getConnection(conInfo, "postgres", "12345678");

            // Update query for person table
            String updatePersonQry = "UPDATE person SET "
                    + "P_Name = ROW(?, ?, ?), "
                    + "DateOfBirth = ?, "
                    + "Nationality = ?, "
                    + "PAN_Acc = ?, "
                    + "Gender = ?, "
                    + "Address = ROW(?, ?, ?), "
                    + "Contact = ROW(?, ?, ?) "
                    + "WHERE p_id = ?";

            pstmt = con.prepareStatement(updatePersonQry);

            pstmt.setString(1, Name_text_update.getText()); // P_Name.FirstName
            pstmt.setString(2, Secound_name_update.getText()); // P_Name.MiddleName
            pstmt.setString(3, Last_Name_update.getText()); // P_Name.LastName
            pstmt.setDate(4, java.sql.Date.valueOf(Date_Birth_update.getValue())); // DateOfBirth
            pstmt.setString(5, Nationality_update.getText()); // Nationality
            pstmt.setInt(6, Integer.parseInt(Pan_Num_update.getText())); // PAN_Acc

            // Gender as CHAR
            String gender = (String) Gender_update.getValue();
            pstmt.setString(7, (gender != null && !gender.isEmpty()) ? gender.substring(0, 1) : null);

            pstmt.setString(8, Street_Name_update.getText()); // Address.StreetName
            pstmt.setString(9, City_update.getText()); // Address.City
            pstmt.setString(10, Country_update.getText()); // Address.Country
            pstmt.setInt(11, Integer.parseInt(Phone1_update.getText())); // Contact.Phone1
            pstmt.setInt(12, Integer.parseInt(phone2_update.getText())); // Contact.Phone2
            pstmt.setString(13, Email_update.getText()); // Contact.Email

            pstmt.setInt(14, Integer.parseInt(ID_text_update.getText())); // p_id

            int rowsAffectedPerson = pstmt.executeUpdate();

            if (rowsAffectedPerson > 0) {
                // Update query for passenger table
                String updatePassengerQry = "UPDATE passenger SET "
                        + "passport_num = ?, "
                        + "promocode = ? "
                        + "WHERE p_id = ?";

                pstmt = con.prepareStatement(updatePassengerQry);
                pstmt.setInt(1, Integer.parseInt(Passport_Num_update.getText())); // passport_num
                pstmt.setInt(2, Integer.parseInt(Promo_Code_update.getText())); // promocode
                pstmt.setInt(3, Integer.parseInt(ID_text_update.getText())); // p_id

                int rowsAffectedPassenger = pstmt.executeUpdate();

                if (rowsAffectedPassenger > 0) {
                    JOptionPane.showMessageDialog(null, "Data updated successfully!");
                    ID_text_update.setText(null);
                    Name_text_update.setText(null);
                    Secound_name_update.setText(null);
                    Last_Name_update.setText(null);
                    Nationality_update.setText(null);
                    Pan_Num_update.setText(null);
                    Phone1_update.setText(null);
                    phone2_update.setText(null);

                    Email_update.setText(null);
                    Street_Name_update.setText(null);
                    City_update.setText(null);
                    Country_update.setText(null);
                    Passport_Num_update.setText(null);
                    Promo_Code_update.setText(null);
                    Gender_update.setValue(null);
                    Date_Birth_update.setValue(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Update failed in passenger table.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Update failed in person table.");
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




    @FXML
    public void initialize() {
        // Set up the table columns
        id_t.setCellValueFactory(new PropertyValueFactory<>("id_t"));
        name_t.setCellValueFactory(new PropertyValueFactory<>("name_t"));
        nationality_t.setCellValueFactory(new PropertyValueFactory<>("nationality_t"));
        Gender_t.setCellValueFactory(new PropertyValueFactory<>("Gender_t"));
        contact_t.setCellValueFactory(new PropertyValueFactory<>("contact_t"));
        Address_t.setCellValueFactory(new PropertyValueFactory<>("Address_t"));
        Promocpde_t.setCellValueFactory(new PropertyValueFactory<>("Promocpde_t"));
        bank_T.setCellValueFactory(new PropertyValueFactory<>("bank_T"));
        Passport_t.setCellValueFactory(new PropertyValueFactory<>("Passport_t"));

        // Set button action
        All_table.setOnAction(event -> loadData());
    }

    private void loadData() {
        String url = "jdbc:postgresql://localhost:5432/Airport_DataBase";
        String user = "postgres";
        String password = "12345678";



        // SQL query
        String qry = "SELECT p.p_id, p.P_Name, p.Nationality, p.Gender, p.Contact, p.Address, "
                + "pas.promocode, p.PAN_Acc, pas.passport_num "
                + "FROM person p JOIN passenger pas ON p.p_id = pas.p_id";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(qry);
             ResultSet rs = pstmt.executeQuery()) {

            // Clear existing data
            dataList.clear();

            // Process result set
            while (rs.next()) {
                int id_t = rs.getInt("p_id");
                String name_t = rs.getString("P_Name");
                String nationality_t = rs.getString("Nationality");
                String Gender_t = rs.getString("Gender");
                String contact_t = rs.getString("Contact");
                String Address_t = rs.getString("Address");
                int Promocpde_t = rs.getInt("promocode");
                int bank_T = rs.getInt("PAN_Acc");
                int Passport_t = rs.getInt("passport_num");

                // Create Passenger_table object and add to list
                Passenger_table passenger = new Passenger_table(id_t, name_t, nationality_t, Gender_t,
                        contact_t, Address_t, Promocpde_t, bank_T, Passport_t);
                dataList.add(passenger);
            }

            // Set data to TableView
            Passenger_table.setItems(dataList);

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Unable to fetch data from database.", e.getMessage());
        }
    }

    @FXML
    public void initialize2() {
        // Set up the table columns
        id_t.setCellValueFactory(new PropertyValueFactory<>("id_t"));
        name_t.setCellValueFactory(new PropertyValueFactory<>("name_t"));
        nationality_t.setCellValueFactory(new PropertyValueFactory<>("nationality_t"));
        Gender_t.setCellValueFactory(new PropertyValueFactory<>("Gender_t"));
        contact_t.setCellValueFactory(new PropertyValueFactory<>("contact_t"));
        Address_t.setCellValueFactory(new PropertyValueFactory<>("Address_t"));
        Promocpde_t.setCellValueFactory(new PropertyValueFactory<>("Promocpde_t"));
        bank_T.setCellValueFactory(new PropertyValueFactory<>("bank_T"));
        Passport_t.setCellValueFactory(new PropertyValueFactory<>("Passport_t"));

        // Set button action
        Nationality_table.setOnAction(event -> NationalityeSearch());
    }

    private void NationalityeSearch() {
        String nationality = Nationality_Filter.getText().trim();
        if (nationality.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Input Error", "Please enter a nationality.");
            return;
        }

        String url = "jdbc:postgresql://localhost:5432/Airport_DataBase";
        String user = "postgres";
        String password = "12345678";

        String qry = "SELECT p.p_id, p.P_Name, p.Nationality, p.Gender, p.Contact, p.Address, pas.passport_num, pas.promocode, p.PAN_Acc "
                + "FROM person p "
                + "JOIN passenger pas ON p.p_id = pas.p_id "
                + "WHERE p.Nationality = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(qry)) {

            // Set the nationality parameter
            pstmt.setString(1, nationality);

            // Execute query
            ResultSet rs = pstmt.executeQuery();

            // Clear existing data
            dataList.clear();

            // Process result set
            while (rs.next()) {
                int id_t = rs.getInt("p_id");
                String name_t = rs.getString("P_Name");
                String nationality_t = rs.getString("Nationality");
                String Gender_t = rs.getString("Gender");
                String contact_t = rs.getString("Contact");
                String Address_t = rs.getString("Address");
                int Promocpde_t = rs.getInt("promocode");
                int bank_T = rs.getInt("PAN_Acc");
                int Passport_t = rs.getInt("passport_num");

                // Create Passenger_table object and add to list
                Passenger_table passenger = new Passenger_table(id_t, name_t, nationality_t, Gender_t,
                        contact_t, Address_t, Promocpde_t, bank_T, Passport_t);
                dataList.add(passenger);
            }

            // Set data to TableView
            Passenger_table.setItems(dataList);

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Unable to fetch data from database.", e.getMessage());
        }
    }

    @FXML
    public void initialize3() {
        // Set up the table columns
        id_t.setCellValueFactory(new PropertyValueFactory<>("id_t"));
        name_t.setCellValueFactory(new PropertyValueFactory<>("name_t"));
        nationality_t.setCellValueFactory(new PropertyValueFactory<>("nationality_t"));
        Gender_t.setCellValueFactory(new PropertyValueFactory<>("Gender_t"));
        contact_t.setCellValueFactory(new PropertyValueFactory<>("contact_t"));
        Address_t.setCellValueFactory(new PropertyValueFactory<>("Address_t"));
        Promocpde_t.setCellValueFactory(new PropertyValueFactory<>("Promocpde_t"));
        bank_T.setCellValueFactory(new PropertyValueFactory<>("bank_T"));
        Passport_t.setCellValueFactory(new PropertyValueFactory<>("Passport_t"));

        // Set button action
        promocode_table.setOnAction(event -> promoeSearch());
    }

    private void promoeSearch() {

        // Ensure both fields are filled before converting to int
        if (min.getText().isEmpty() || max.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Input Error", "Please enter both minimum and maximum promo code values.");
            return;
        }

        // Convert inputs to integers
        int minn = Integer.parseInt(min.getText());
        int maxx = Integer.parseInt(max.getText());

        String url = "jdbc:postgresql://localhost:5432/Airport_DataBase";
        String user = "postgres";
        String password = "12345678";

        String qry = "SELECT p.p_id, p.P_Name, p.Nationality, p.Gender, p.Contact, p.Address, pas.passport_num, pas.promocode, p.PAN_Acc "
                + "FROM person p "
                + "JOIN passenger pas ON p.p_id = pas.p_id "
                + "WHERE pas.promocode >= ? AND pas.promocode <= ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(qry)) {

            // Set the promo code range parameters
            pstmt.setInt(1, minn);
            pstmt.setInt(2, maxx);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Clear existing data
            dataList.clear();

            // Process the result set
            while (rs.next()) {
                int id_t = rs.getInt("p_id");
                String name_t = rs.getString("P_Name");
                String nationality_t = rs.getString("Nationality");
                String Gender_t = rs.getString("Gender");
                String contact_t = rs.getString("Contact");
                String Address_t = rs.getString("Address");
                int Promocpde_t = rs.getInt("promocode");
                int bank_T = rs.getInt("PAN_Acc");
                int Passport_t = rs.getInt("passport_num");

                // Create Passenger_table object and add it to the list
                Passenger_table passenger = new Passenger_table(id_t, name_t, nationality_t, Gender_t,
                        contact_t, Address_t, Promocpde_t, bank_T, Passport_t);
                dataList.add(passenger);
            }

            // Set data to TableView
            Passenger_table.setItems(dataList);

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Unable to fetch data from the database.", e.getMessage());
        }
    }

    public void initialize4() {
        // Set up the table columns
        id_t.setCellValueFactory(new PropertyValueFactory<>("id_t"));
        name_t.setCellValueFactory(new PropertyValueFactory<>("name_t"));
        nationality_t.setCellValueFactory(new PropertyValueFactory<>("nationality_t"));
        Gender_t.setCellValueFactory(new PropertyValueFactory<>("Gender_t"));
        contact_t.setCellValueFactory(new PropertyValueFactory<>("contact_t"));
        Address_t.setCellValueFactory(new PropertyValueFactory<>("Address_t"));
        Promocpde_t.setCellValueFactory(new PropertyValueFactory<>("Promocpde_t"));
        bank_T.setCellValueFactory(new PropertyValueFactory<>("bank_T"));
        Passport_t.setCellValueFactory(new PropertyValueFactory<>("Passport_t"));

        // Set button action
        Age_table.setOnAction(event -> AgeeSearch());
    }

    private void AgeeSearch() {
        // Ensure both fields are filled before converting to int
        if (age.getText().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Input Error", "Please enter both minimum and maximum promo code values.");
            return;
        }

        // Convert inputs to integers
        int agee = Integer.parseInt(age.getText());



        String url = "jdbc:postgresql://localhost:5432/Airport_DataBase";
        String user = "postgres";
        String password = "12345678";

        String qry = "SELECT p.p_id, p.P_Name, p.Nationality, p.Gender, p.Contact, p.Address, pas.passport_num, pas.promocode, p.PAN_Acc "
                + "FROM person p "
                + "JOIN passenger pas ON p.p_id = pas.p_id "
                + "WHERE EXTRACT(YEAR FROM AGE(CURRENT_DATE, p.dateofbirth)) =  ?";


        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(qry)) {

            // Set the nationality parameter
            pstmt.setInt(1, agee);

            // Execute query
            ResultSet rs = pstmt.executeQuery();

            // Clear existing data
            dataList.clear();

            // Process result set
            while (rs.next()) {
                int id_t = rs.getInt("p_id");
                String name_t = rs.getString("P_Name");
                String nationality_t = rs.getString("Nationality");
                String Gender_t = rs.getString("Gender");
                String contact_t = rs.getString("Contact");
                String Address_t = rs.getString("Address");
                int Promocpde_t = rs.getInt("promocode");
                int bank_T = rs.getInt("PAN_Acc");
                int Passport_t = rs.getInt("passport_num");

                // Create Passenger_table object and add to list
                Passenger_table passenger = new Passenger_table(id_t, name_t, nationality_t, Gender_t,
                        contact_t, Address_t, Promocpde_t, bank_T, Passport_t);
                dataList.add(passenger);
            }

            // Set data to TableView
            Passenger_table.setItems(dataList);

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Unable to fetch data from database.", e.getMessage());
        }
    }


    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}








