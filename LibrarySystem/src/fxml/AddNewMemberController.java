/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import LibrarySystem.Address;
import LibrarySystem.LibraryMember;
import LibrarySystem.OperationAssistant;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class AddNewMemberController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField streetField;
    @FXML private TextField cityField;
    @FXML private TextField stateField;
    @FXML private TextField zipField;
    @FXML private TextField telephoneField;
    @FXML private Button addButton;
    
    // button Add click()
    public void addButtonClick(ActionEvent event){
        
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String street = streetField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String zip = zipField.getText();
        String phoneNumber = telephoneField.getText();
        
        
        Address address = new Address(street, city, state, phoneNumber, zip);
        
        
        
    	 LibraryMember member = OperationAssistant.addMember(new LibraryMember(firstName, lastName, address));
		System.out.println(member);
//        
//        // saving method
//        OperationAssistant.addMember(new )
//        LibraryMember addMember(LibraryMemb)
        
        // closing itself
		Stage stage = (Stage) addButton.getScene().getWindow();
		stage.close();
//        
        
        
        
    }
    
    
    
    
    
}
