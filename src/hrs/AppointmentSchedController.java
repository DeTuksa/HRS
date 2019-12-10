/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 *
 * @author Al-purim
 */
public class AppointmentSchedController extends AnchorPane implements Initializable
{
    @FXML
    private Button Logout;
    @FXML
    private Button Home;

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
    public void HomeButtonClicked(ActionEvent event) throws IOException
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        Scene homeScene = new Scene(homeParent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }
}
