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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Al-purim
 */
public class RegisterPatientController extends AnchorPane implements Initializable {

    Alert alert;
    
    @FXML
    private Button Logout;
    @FXML
    private Button preview;
    @FXML
    private Button Cancel;
    @FXML
    private Button Home;
    @FXML
    private TextField NameField;
    @FXML
    private TextField AddressField;
    @FXML
    private TextField CityField;
    @FXML
    private TextField StateField;
    @FXML
    private TextField PhoneField;
    @FXML
    private TextField EmailField;
    @FXML
    private DatePicker BirthdateField;
    @FXML
    private TextField gender;
    @FXML
    private TextField maritalStatus;
    @FXML
    private Label nameReq;
    @FXML
    private Label addReq;
    @FXML
    private Label cityReq;
    @FXML
    private Label stateReq;
    @FXML
    private Label phoneReq;
    @FXML
    private Label emailReq;

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

    public void CancelClicked(ActionEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }

    public void PrevClicked(ActionEvent event) throws IOException {
        String name = NameField.getText();
        String address = AddressField.getText();
        String city = CityField.getText();
        String state = StateField.getText();
        String phone = PhoneField.getText();
        String email = EmailField.getText();

        if (NameField.getText().trim().isEmpty()) {
            nameReq.setVisible(true);
        }
        if (NameField.getText().trim().isEmpty()) {
            addReq.setVisible(true);
        }
        if (CityField.getText().trim().isEmpty()) {
            cityReq.setVisible(true);
        }
        if (StateField.getText().trim().isEmpty()) {
            stateReq.setVisible(true);
        }
        if (PhoneField.getText().trim().isEmpty()) {
            phoneReq.setVisible(true);
        }
        if (EmailField.getText().trim().isEmpty()) {
            emailReq.setVisible(true);
        } else {
            Connection conn = null;
            try {

                LocalDate localDate = BirthdateField.getValue();
             //   Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                Date d = Date.valueOf(localDate);

                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/openmrs?useTimezone=true&serverTimezone=UTC", "root", "Emmanuel4231");
                String query = "INSERT INTO REG_PATIENT (PATIENT_NAME, ADDRESS, CITY, _STATE, PHONE, EMAIL, BIRTHDATE, GENDER, MARITAL_STATUS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(query);
               // statement.setInt(1, 1);
                statement.setString(1, NameField.getText());
                statement.setString(2, AddressField.getText());
                statement.setString(3, CityField.getText());
                statement.setString(4, StateField.getText());
                statement.setString(5, PhoneField.getText());
                statement.setString(6, EmailField.getText());
                statement.setDate(7, (java.sql.Date)d);
                statement.setString(8, gender.getText());
                statement.setString(9, maritalStatus.getText()); 
                
                statement.execute();
            } catch (Exception e) {
                e.printStackTrace();;
            }

            FXMLLoader Loader = new FXMLLoader();
            Parent homeParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
            Scene homeScene = new Scene(homeParent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(homeScene);
            stage.show();
            alert = new Alert(Alert.AlertType.NONE, "Registration successfully.", ButtonType.OK);
            alert.show();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
