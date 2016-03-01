package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
//import fxml.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		// First we load the login window
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
