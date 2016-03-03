package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import LibrarySystem.BookCopy;
import LibrarySystem.CheckoutRecordEntry;
import LibrarySystem.LibraryMember;
import LibrarySystem.OperationAssistant;
import LibrarySystem.db.DataAccessFacede;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CheckoutController implements Initializable{

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML private TextField memberIDText;
    @FXML private TextField isbnText;
    @FXML private Button checkoutButton;
    
    private Alert errorMessage = new Alert(Alert.AlertType.ERROR, "Wrong memberID or book ISBN, try again!");
    
    public void checkoutAction(){
    	
    	LibraryMember member = OperationAssistant.searchMember(memberIDText.getText());
    	BookCopy bookCopy = OperationAssistant.searchBookCopyWithISBN(isbnText.getText());
    	
    	if(member == null || bookCopy == null) {
    		errorMessage.showAndWait();
    		return;
    	}    	
    	CheckoutRecordEntry chk = OperationAssistant.checkout(bookCopy, member);
    	
    	MainController mainC = new MainController();
    	mainC.loadViewCheckout(member);
    	
    }
    
    public void checkoutAndPrintAction(){
    	
    	LibraryMember member = OperationAssistant.searchMember(memberIDText.getText());
    	BookCopy bookCopy = OperationAssistant.searchBookCopyWithISBN(isbnText.getText());
    	System.out.println("=============");
    	System.out.println(memberIDText.getText()+"::id");
    	System.out.println(isbnText.getText()+"::isbn");

    	
    	if(member == null || bookCopy == null) {
    		errorMessage.showAndWait();
    		return;
    	}
    	
    	CheckoutRecordEntry chk = OperationAssistant.checkout(bookCopy, member);
    	
    	MainController mainC = new MainController();
    	mainC.loadViewCheckout(member);
    	
    	DataAccessFacede.printUserCheckoutRecords(member.getID());
    	
    }
    
    
}
