/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
/**
 *
 * @author Tuksa
 */
public class HRS extends Application
{
    
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "Admin123";
    
    @Override
    public void start(Stage stage) throws Exception
    {
//        Connection conn = null;
//        try
//        {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/openmrs?useTimezone=true&serverTimezone=UTC", "root", "Emmanuel4231");
//            if(conn!=null)
//            {
//                System.out.println("Connection successful!");
//            }
//        } catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene = new Scene(root);
        
        stage.setTitle("Smartacare");
        stage.setResizable(true);
        stage.setScene(scene);      
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
