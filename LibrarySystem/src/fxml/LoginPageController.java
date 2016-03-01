/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import LibrarySystem.*;
import LibrarySystem.ConstTypes.UserType;

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
    @FXML private Button loginbutton;
    
    private Alert errorMessage = new Alert(Alert.AlertType.ERROR, "Wrong username or login, try again");
    
    // login button click()
    public void loginClick(ActionEvent event){
            	
    	MainController mainCont  =new MainController();
    	
    	User currentUser = OperationAssistant.login(username.getText(), password.getText());
        // if username or password is found
        if(currentUser != null){
        	
        	if(currentUser.getUserType() == UserType.ADMINE){
        		
        		mainCont.createAdminWindow();
        		
        	}else if (currentUser.getUserType() == UserType.LIBRARIAN){
        		mainCont.createLibrarianWindow();
        		
        	}else if (currentUser.getUserType() == UserType.BOTH){
        		mainCont.createBothWindow();
        	}
        	
    		Stage stage = (Stage) loginbutton.getScene().getWindow();
    		stage.close();
        	
        }else{
        	errorMessage.showAndWait();
        }
    }
    
}
