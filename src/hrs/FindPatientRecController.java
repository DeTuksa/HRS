/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransactionRollbackException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.text.TabableView;

/**
 *
 * @author Al-purim
 */
public class FindPatientRecController implements Initializable {

    @FXML
    private Button Logout;
    @FXML
    private Button search;
    @FXML
    private TextField searchField;
    @FXML
    private Button home;
    @FXML
    public TextField nameField;
    @FXML
    public TableView<Search> table0;
    @FXML
    private TableColumn<Search, String> col_id;
    @FXML
    private TableColumn<Search, String> col_name;
    @FXML
    private TableColumn<Search, String> col_gender;
    @FXML
    private TableColumn<Search, String> col_phone;
    
    @FXML
    private Label patient;
    
    @FXML
    private TableColumn col_action;    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    ObservableList<Search> liist = FXCollections.observableArrayList();

    Alert alert;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    
    @FXML
    public void PopulateTable()
    {
        table0.getItems().clear();
         ResultSet rs;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/openmrs?useTimezone=true&serverTimezone=UTC", "root", "Emmanuel4231");
            String query = "SELECT * FROM REG_PATIENT WHERE PATIENT_NAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nameField.getText());
            rs = stmt.executeQuery();
            String query2 = "INSERT INTO SAVE_SEARCH(NAMES) VALUE(?)";
            PreparedStatement stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1, nameField.getText());
            stmt2.execute();
            while (rs.next()) {
                Search record = new Search();
                record.setId(rs.getString("patient_id"));
                record.setName(rs.getString("patient_name"));
                record.setGender(rs.getString("gender"));
                record.setPhone(rs.getString("phone"));
                liist.add(record);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FindPatientRecController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        table0.setItems(liist);
    }
    
    @FXML
    public void LogoutButtonClicked(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    public void HomeClicked(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    public void SearchRecord(ActionEvent event) throws IOException {
        
        PopulateTable();
        
    }
    //Visit Note Alert Message
    
    @FXML
    public void ViewClicked(ActionEvent event) throws IOException
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("New Patient Page.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }
}
