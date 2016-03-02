package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminWindowController  implements Initializable{
    /**
     * Initializes the controller class.
     */
	
	@FXML private Button logoutButton;
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
    	System.out.println("addmemeber");
    	MainController mainCont  = new MainController();
    	mainCont.loadAddMember();  
    	

    }
    
    public void showAddBookWindow(){
    	System.out.println("addbook");
    	MainController mainCont  = new MainController();
    	mainCont.loadAddBook();
    	
    }
    
    public void showAddBookCopyWindow(){
    	System.out.println("addbookCopy");
    	MainController mainCont  = new MainController();
    	mainCont.loadAddCopyBook();
    	
    }
    
    
    
}
