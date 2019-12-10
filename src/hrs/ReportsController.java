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
import javafx.stage.Stage;

/**
 *
 * @author Al-purim
 */
public class ReportsController extends FindPatientRecController implements Initializable {

    @FXML
    private Button Logout;
    @FXML
    private Button Home;
    @FXML
    private Button startVisits;
    @FXML
    private Button visitNotes;
    @FXML
    private Button admitInpatient;
    @FXML
    private Button captureVitals;
    @FXML
    private Button addVisit;
    @FXML
    private Button searchChat;
    @FXML
    private Button markDeceased;
    @FXML
    private Button deletePatient;
    @FXML
    private Button Appointment;

    @FXML
    public Label detailsField;

    Alert alert;

    @FXML
    public void LogoutButtonClicked(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    public void AlertMessage1(ActionEvent event) throws IOException {
        alert = new Alert(Alert.AlertType.NONE, "Start visit to add note!", ButtonType.OK);
        alert.show();
    }

    @FXML
    public void AlertMessage2(ActionEvent event) throws IOException {
        alert = new Alert(Alert.AlertType.NONE, "Start visit to admit to Inpatient!", ButtonType.OK);
        alert.show();
    }

    @FXML
    public void HomeClicked(ActionEvent event) throws IOException
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    public void AlertMessage3(ActionEvent event) throws IOException
    {
        alert = new Alert(Alert.AlertType.NONE, "Start visit to capture vitals!", ButtonType.OK);
        alert.show();
    }

    @FXML
    public void AlertMessage4(ActionEvent event) throws IOException
    {
        alert = new Alert(Alert.AlertType.NONE, "Start visit to add past visit!", ButtonType.OK);
        alert.show();
    }

    @FXML
    public void AlertMessage5(ActionEvent event) throws IOException
    {
        alert = new Alert(Alert.AlertType.NONE, "Start visit to search chart!", ButtonType.OK);
        alert.show();
    }

    @FXML
    public void AlertMessage6(ActionEvent event) throws IOException
    {
        alert = new Alert(Alert.AlertType.NONE, "Start visit to schedule appointment!", ButtonType.OK);
        alert.show();
    }

    @FXML
    public void AlertMessage7(ActionEvent event) throws IOException
    {
        alert = new Alert(Alert.AlertType.NONE, "Start visit to mark as deceased!", ButtonType.OK);
        alert.show();
    }

    
    @FXML
    public void CaptureVitalsClicked(ActionEvent event) throws IOException
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("RegVitals.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    public void AppoinmentClicked(ActionEvent event) throws IOException
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("AppointmentSchedule.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    public void StartVisit(ActionEvent event) throws IOException
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("PatientVisitActivated.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }
    

    @Override
    @SuppressWarnings("empty-statement")
    public void initialize(URL url, ResourceBundle rb)
    {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/openmrs?useTimezone=true&serverTimezone=UTC", "root", "Emmanuel4231");
            String query = "SELECT * FROM SAVE_SEARCH";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("NAMES");
                detailsField.setText(name.toUpperCase());
            }
            // TODO
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}
