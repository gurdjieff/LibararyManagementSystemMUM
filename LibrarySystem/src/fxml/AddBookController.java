/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import LibrarySystem.Address;
import LibrarySystem.Author;
import LibrarySystem.Book;
import LibrarySystem.LibraryMember;
import LibrarySystem.OperationAssistant;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
    @FXML private javafx.scene.control.Button addBookCop ;

    
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
        
        if (bookISBN.getText().length() == 0
        			|| bookTitle.getText().length() == 0
					|| author1Name.getText().length() == 0
					|| author1Last.getText().length() == 0
					|| author2Name.getText().length() == 0
					|| author2Last.getText().length() == 0
					|| maxLength.getText().length() == 0
					|| numberCopies.getText().length() == 0) {
            Alert errorMessage = new Alert(Alert.AlertType.ERROR, "Please complete all of the information!");
            errorMessage.showAndWait();
            return;
        	
		}
        
        int length = 0;
        int copies = 0;
        
        try {
        	length = Integer.parseInt(maxLength.getText());
        	copies = Integer.parseInt(numberCopies.getText());
		} catch (Exception e) {
			Alert errorMessage = new Alert(Alert.AlertType.ERROR, "MaxLength or number of copies is wrong!");
            errorMessage.showAndWait();
            return;
			// TODO: handle exception
		}
        
        List<Author> authors = new LinkedList<Author>(){
        	{
        		add(new Author(author1Name.getText(), author1Last.getText()));
        		add(new Author(author2Name.getText(), author2Last.getText()));

        	}
        };
        OperationAssistant.addBook(new Book(bookISBN.getText(), 
        		bookTitle.getText(), length, copies, authors));
   
       // closing itself
//		Stage stage = (Stage) addButton.getScene().getWindow();
//		stage.close();
        
        
        
    }
    
    
    
    
    
}
