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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void logOut(){
    	MainController mainCont  =new MainController();
    	mainCont.loadLoginWindow();
    	
		Stage stage = (Stage) logoutButton.getScene().getWindow();
		stage.close();
    }
}
