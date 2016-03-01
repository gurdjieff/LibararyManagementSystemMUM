/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import LibrarySystem.*;

/**
 * FXML Controller class
 *
 * @author Nasriddin
 */
public class LoginPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML private TextField username;
    @FXML private PasswordField password;
    private Alert errorMessage = new Alert(Alert.AlertType.ERROR, "Wrong username or login, try again");
    private Alert errorMessage2 = new Alert(Alert.AlertType.ERROR, "you're logged in!!!");
    
    // login button click()
    public void loginClick(ActionEvent event){
        
    	
    	
    	User currentUser = OperationAssistant.login(username.getText(), password.getText());
        // if username or password is found
        if(currentUser != null){
        	errorMessage2.showAndWait();        	
        }else{
        	errorMessage.showAndWait();
        }
    }
    
}
