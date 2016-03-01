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
public class AddBookController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
    @FXML private TextField bookISBN;
    @FXML private TextField bookTitle;
    @FXML private TextField author1Name;
    @FXML private TextField author1Last;
    @FXML private TextField author2Name;
    @FXML private TextField author2Last;
    @FXML private TextField maxLength;
    @FXML private TextField numberCopies;
    
    
    // button Add click()
    public void addButtonClick(ActionEvent event){
        
       // saving method
        
        
        System.out.println(bookISBN.getText());
        System.out.println(bookTitle.getText());
        System.out.println(author1Name.getText());
        System.out.println(author1Last.getText());
        System.out.println(author2Name.getText());
        System.out.println(author2Last.getText());
        System.out.println(maxLength.getText());
        System.out.println(numberCopies.getText());
        
        
    }
    
    
    
    
    
}
