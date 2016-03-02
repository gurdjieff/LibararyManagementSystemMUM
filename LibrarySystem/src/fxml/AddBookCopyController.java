/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import LibrarySystem.Book;
import LibrarySystem.BookCopy;
import LibrarySystem.OperationAssistant;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Nasriddin
 */
public class AddBookCopyController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
    @FXML private TextField bookISBN;
    private Alert confirmMessage = new Alert(Alert.AlertType.CONFIRMATION, "new copy added successfully!");
    
    
    
    // button Add click()
    public void addButtonClick(ActionEvent event){
        
       // saving method
    	
    	String isbn = bookISBN.getText();
    	
//    	Book book = OperationAssistant.searchBook(isbn);
//    	
//    	if(book != null){
//    		
//    	}else{
//    		
//    	}
    	
    	
    	
        
        
        System.out.println(isbn);
        confirmMessage.showAndWait();
        
        
    }
    
    
    
    
    
}
