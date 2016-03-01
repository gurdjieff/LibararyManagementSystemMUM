package fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import LibrarySystem.*;

public class MainController {

	
	
  public void loadLoginWindow(Stage primaryStage){
		
	  try {			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginWindow.fxml"));
			
			
			
			Scene scene = new Scene(root, 450, 300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
  }
    
	
	
	
}
