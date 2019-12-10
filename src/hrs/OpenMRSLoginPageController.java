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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Al-purim
 */
public class OpenMRSLoginPageController extends AnchorPane implements Initializable {

    @FXML
    private MenuButton Location0;
    @FXML
    private MenuItem Location1;
    @FXML
    private MenuItem Location2;
    @FXML
    private MenuItem Location3;
    @FXML
    private MenuItem Location4;
    @FXML
    private MenuItem Location5;
    @FXML
    private MenuItem Location6;
    @FXML
    private Button Login;
    @FXML
    private Text TroubleLogin;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label error;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginButtonClicked(ActionEvent event) {
        // String user = "admin";
        // String pass = "Admin123";

        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if (username.equals("tuksa") && password.equals("Tuksa123")) {
            try {
                Parent homeParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
                Scene homeScene = new Scene(homeParent);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                
                stage.setScene(homeScene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(OpenMRSLoginPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
                } else {
                    error.setVisible(true);
        }
                

//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/openmrs?useTimezone=true&serverTimezone=UTC", "root", "Emmanuel4231");
//            String query = "SELECT username, password FROM USERS WHERE username = ? and password = ?";
//            PreparedStatement statement = conn.prepareStatement(query);
//            statement.setString(1, username);
//            statement.setString(2, password);
//
//            ResultSet result = statement.executeQuery();
//
//            while (result.next()) {
//                String user = result.getString("username");
//                String pass = result.getString("password");
//
//                if (username.equals("tuksa") && password.equals("Tuksa123")) {
//                    Parent homeParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
//                    Scene homeScene = new Scene(homeParent);
//                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//                    stage.setScene(homeScene);
//                    stage.show();
//                } else {
//                    error.setVisible(true);
//                    throw new SQLTransactionRollbackException("invalid login");
//                }
//            }
//
//        } catch (Exception e) {
//            System.out.println("invalid login");
//             error.setVisible(true);
//            e.printStackTrace();
//        }

    }

}
