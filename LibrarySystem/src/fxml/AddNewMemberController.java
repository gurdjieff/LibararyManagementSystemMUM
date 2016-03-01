/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Nasriddin
 */
public class AddNewMemberController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML private TextField firstnamField;
    @FXML private TextField lastnameField;
    @FXML private TextField streetField;
    @FXML private TextField cityfiField;
    @FXML private TextField statefielField;
    @FXML private TextField zipfielField;
    @FXML private TextField telephoneField;  
    
    // button Add click()
    public void addButtonClick(ActionEvent event){
        
        String firstName = firstnamField.getText();
        String lastName = lastnameField.getText();
        String street = streetField.getText();
        String city = cityfiField.getText();
        String state = statefielField.getText();
        String zip = zipfielField.getText();
        String telepohone = telephoneField.getText();
        
        // saving method
        
        
        
        
        
    }
    
    
    
    
    
}
