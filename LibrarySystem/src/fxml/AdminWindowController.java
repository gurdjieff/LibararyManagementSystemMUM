package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import LibrarySystem.BookCopy;
import LibrarySystem.CheckoutRecordEntry;
import LibrarySystem.LibraryMember;
import LibrarySystem.OperationAssistant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminWindowController  implements Initializable{
    /**
     * Initializes the controller class.
     */
    private Alert errorMessage = new Alert(Alert.AlertType.ERROR, "Wrong memberID, try again!");

	@FXML private Button logoutButton;
	@FXML private TextField memberIDText;
//	@FXML private Button addBookCopyButton;
	
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void logOut(){
    	MainController mainCont  = new MainController();
    	mainCont.loadLoginWindow();
    	
		Stage stage = (Stage) logoutButton.getScene().getWindow();
		stage.close();
    }
    
    public void showAddMemberWindow(){
    	System.out.println("show AddMember Window");
    	MainController mainCont  = new MainController();
    	mainCont.loadAddMember();  
    	

    }
    
    public void showAddBookWindow(){
    	System.out.println("show AddBook Window");
    	MainController mainCont  = new MainController();
    	mainCont.loadAddBook();
    	
    }
    
    public void showAddBookCopyWindow(){
    	System.out.println("show AddBookCopy Window");
    	MainController mainCont  = new MainController();
    	mainCont.loadAddCopyBook();
    	
    }
    
    public void showViewMembersWindow(){
    	System.out.println("show ViewMembers Window");
    	MainController mainCont  = new MainController();
    	mainCont.loadViewMember();
    }
    
    public void showViewBooksWindow(){
    	System.out.println("show ViewBooks Window");
    	MainController mainCont  = new MainController();
    	mainCont.loadViewBooks();
    }
    
    public void showCheckoutWindow(){

    	MainController mainC = new MainController();
    	mainC.loadCheckout();
    }
    

    
    public void showViewCheckoutRecordWindow(){
    	System.out.println("show Checkout Window");
    	if(memberIDText.getText() == null 
    			|| memberIDText.getText().length() == 0) {
    		errorMessage.showAndWait();
    		return;
    	}    	
    	LibraryMember member = OperationAssistant.searchMember(memberIDText.getText());
    	
    	if( member == null) {
    		errorMessage.showAndWait();
    		return;
    	}    	
    	
    	MainController mainC = new MainController();
    	mainC.loadViewCheckout(member);
    	
    }
    
}
