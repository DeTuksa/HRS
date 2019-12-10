/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Al-purim
 */
public class RegVitalsController extends AnchorPane implements Initializable {

    Alert alert;

    @FXML
    private Button Logout;
    @FXML
    private Button Home;
    @FXML
    private Button Preview;
    @FXML
    private Button Cancel;
    @FXML
    private Label details;
    @FXML
    private Label error;
    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private TextField bmi;
    @FXML
    private TextField temp;
    @FXML
    private TextField pulse;
    @FXML
    private TextField resp_rate;
    @FXML
    private TextField blood_press1;
    @FXML
    private TextField blood_press2;
    @FXML
    private TextField blood_oxy_sat;

    @FXML
    public void CancelClicked(ActionEvent event) throws IOException {

        Parent homeParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
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
    public void PreviewClicked(ActionEvent event) throws IOException {

        Connection conn = null;
        try {
            String name = details.getText();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/openmrs?useTimezone=true&serverTimezone=UTC", "root", "Emmanuel4231");
            String query2 = "SELECT * FROM REG_PATIENT WHERE patient_name = ?";
            PreparedStatement statement2 = conn.prepareStatement(query2);
            statement2.setString(1, name);
            ResultSet resultSet = statement2.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString("patient_name");

            }

            String query = "INSERT INTO CAPTURE_VITALS (HEIGHT, WEIGHT, BMI, TEMP, PULSE, RESP_RATE, BLOOD_OXY_SAT, PATIENT_NAME, BLOOD_PRESSURE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            // statement.setInt(1, 1);
            statement.setString(1, height.getText());
            statement.setString(2, weight.getText());
            statement.setString(3, bmi.getText());
            statement.setString(4, temp.getText());
            statement.setString(5, pulse.getText());
            statement.setString(6, resp_rate.getText());

            statement.setString(7, blood_oxy_sat.getText());
            statement.setString(8, name);
            statement.setString(9, "" + blood_press1.getText() + " / " + blood_press2.getText() + "");

            statement.execute();
        } catch (Exception e) {
            error.setText("Record not found!");
            e.printStackTrace();
        }

        Parent homeParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
        alert = new Alert(AlertType.NONE, "Vitals captured successfully.", ButtonType.OK);
        alert.show();

    }

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
}
