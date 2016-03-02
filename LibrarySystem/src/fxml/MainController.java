package fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import LibrarySystem.*;

public class MainController {

	
	public void createAdminWindow(){		
		try {	
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AdminWindow.fxml"));
		      Parent root1 = (Parent) fxmlLoader.load();
		      Stage stage1 = new Stage();
		      stage1.setScene(new Scene(root1));  
		      stage1.show();      
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void createLibrarianWindow(){		
		try {	
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/LibrarianWindow.fxml"));
		      Parent root1 = (Parent) fxmlLoader.load();
		      Stage stage1 = new Stage();
		      stage1.setScene(new Scene(root1));  
		      stage1.show();      
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public void createBothWindow(){		
		try {	
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/BothWindow.fxml"));
		      Parent root1 = (Parent) fxmlLoader.load();
		      Stage stage1 = new Stage();
		      stage1.setScene(new Scene(root1));  
		      stage1.show();      
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	
  public void loadLoginWindow(Stage primaryStage){
		
	  try {			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginWindow.fxml"));			
			
			Scene scene = new Scene(root, 450, 300);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
  }
    
  
  public void loadLoginWindow(){
		
	  try {			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginWindow.fxml"));			
			Stage stage1 = new Stage();
			Scene scene = new Scene(root, 450, 300);
			stage1.setScene(scene);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
  }
	
  
  public void loadAddMember(){
		
	  try {			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddNewMember.fxml"));			
			Stage stage1 = new Stage();
			Scene scene = new Scene(root, 450, 300);
			stage1.setScene(scene);
			stage1.initModality(Modality.APPLICATION_MODAL);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
  }
	
  
  public void loadAddBook(){
		
	  try {			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddBook.fxml"));			
			Stage stage1 = new Stage();
			Scene scene = new Scene(root, 450, 400);
			stage1.setScene(scene);
			
			stage1.initModality(Modality.APPLICATION_MODAL);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
  }
	
  public void loadAddCopyBook(){
		
	  try {			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddBookCopy.fxml"));			
			Stage stage1 = new Stage();
			Scene scene = new Scene(root, 300, 130);
			stage1.setScene(scene);
			
			stage1.initModality(Modality.APPLICATION_MODAL);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
  }
  
  
}
