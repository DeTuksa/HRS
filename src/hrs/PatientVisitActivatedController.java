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
import java.util.ResourceBundle;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Al-purim
 */
public class PatientVisitActivatedController implements Initializable {

    @FXML
    private Button Home;
    @FXML
    private Button Logout;
    @FXML
    private TextArea Diagnoses;
    @FXML
    private TextArea Vitals;
    @FXML
    private TextArea Recent_Visit;
    @FXML
    private TextArea Conditions;
    @FXML
    private TextArea Allergies;
    @FXML
    private TextArea Family;
    @FXML
    private Button stopVisit;
    @FXML
    private Button visitNote;
    @FXML
    private Button inpatient;
    @FXML
    private Button captVitals;
    @FXML
    private Button attach;
    @FXML
    private Button addVisit;
    @FXML
    private Button searchChat;
    @FXML
    private Button appSchedule;
    @FXML
    private Button markDeceased;
    @FXML
    private Button delete;
    @FXML
    public Label details;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/openmrs?useTimezone=true&serverTimezone=UTC", "root", "Emmanuel4231");
            String query = "SELECT * FROM SAVE_SEARCH";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("NAMES");
                details.setText(name.toUpperCase());
            }
            // TODO
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }    

    @FXML
    public void HomeClicked(ActionEvent event) throws IOException
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    public void LogoutButtonClicked(ActionEvent event) throws IOException
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    public void StopVisitClicked(ActionEvent event)
    {
    }

    @FXML
    public void VisitNoteClicked(ActionEvent event)
    {
    }

    @FXML
    public void InpatientCLicked(ActionEvent event)
    {
    }

    @FXML
    public void VitalsClicked(ActionEvent event) throws IOException
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("New Capture Vitals.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    public void Attachment(ActionEvent event)
    {
    }

    @FXML
    public void AddVisitClicked(ActionEvent event)
    {
    }

    @FXML
    public void ChartClicked(ActionEvent event)
    {
    }

    @FXML
    public void Appointmentlicked(ActionEvent event) throws IOException
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("AppointmentSchedule.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }
    
    @FXML
    public void InpatientClicked(ActionEvent event) throws IOException
    {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/openmrs?useTimezone=true&serverTimezone=UTC", "root", "Emmanuel4231");
            String query = "INSERT INTO INPATIENT (PATIENT_NAME) VALUES(?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, details.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Patient added to Inpatient!", ButtonType.OK);
            alert.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void DeceasedClicked(ActionEvent event)
    {
    }

    @FXML
    public void DeleteClicked(ActionEvent event)
    {
    }
    
}
