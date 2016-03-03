package fxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

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
  
  
  
  
  public void loadViewMember(){
	  
	  Stage window = new Stage();
	  window.setTitle("All members");
	  
	  TableView<MemberList> table = new TableView<>();
	  
	  //First Name column
      TableColumn<MemberList, String> fnameColumn = new TableColumn<>("First Name");
      fnameColumn.setMinWidth(200);
      fnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

      //Last Name column
      TableColumn<MemberList, String> lnameColumn = new TableColumn<>("Last Name");
      lnameColumn.setMinWidth(100);
      lnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
      
      //Address
      TableColumn<MemberList, String> addressColumn = new TableColumn<>("Address");
      addressColumn.setMinWidth(300);
      addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

      table.setItems(getLibraryMember());
      table.getColumns().addAll(fnameColumn, lnameColumn, addressColumn);
      
      VBox vBox = new VBox();
      vBox.getChildren().addAll(table);

      Scene scene = new Scene(vBox);
      window.setScene(scene);
      window.show();
	  
		
  }
  
  public ObservableList<MemberList> getLibraryMember(){      
	  List<LibraryMember> members = OperationAssistant.getAllLibraryMembers();	  
	  ObservableList<MemberList> memberlist = FXCollections.observableArrayList();      
      for(LibraryMember ms: members){
    	  memberlist.add(new MemberList(ms));
      }  
      return memberlist;
  }
  
  
  
  public void loadViewBooks(){
	  
	  Stage window = new Stage();
	  window.setTitle("All Books");
	  
	  TableView<BookList> table = new TableView<>();
	  
	  //ISBN column
      TableColumn<BookList, String> isbnColumn = new TableColumn<>("ISBN");
      isbnColumn.setMinWidth(100);
      isbnColumn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));

      //Title column
      TableColumn<BookList, String> titleColumn = new TableColumn<>("Title");
      titleColumn.setMinWidth(100);
      titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
      
      //Authors
      TableColumn<BookList, String> authorsColumn = new TableColumn<>("Authors");
      authorsColumn.setMinWidth(200);
      authorsColumn.setCellValueFactory(new PropertyValueFactory<>("authors"));
      
      //Number of Copies
      TableColumn<BookList, String> numberColumn = new TableColumn<>("Number of Copies");
      numberColumn.setMinWidth(100);
      numberColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfCopies"));
      
      //Max length of borrowing book
      TableColumn<BookList, String> maxLengthColumn = new TableColumn<>("Max Length");
      maxLengthColumn.setMinWidth(100);
      maxLengthColumn.setCellValueFactory(new PropertyValueFactory<>("maxLength"));

      //Available borrowing book
      TableColumn<BookList, String> availableColumn = new TableColumn<>("Available");
      availableColumn.setMinWidth(100);
      availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));      
      
      table.setItems(getBookList());
      table.getColumns().addAll(isbnColumn, titleColumn, authorsColumn, numberColumn, maxLengthColumn, availableColumn);
      
      VBox vBox = new VBox();
      vBox.getChildren().addAll(table);

      Scene scene = new Scene(vBox);
      window.setScene(scene);
      window.show();
	  
		
  }
  
  
  public ObservableList<BookList> getBookList(){
	  
	  List<Book> books = OperationAssistant.getAllBooks();      
      ObservableList<BookList> booklist = FXCollections.observableArrayList();
      
      for(Book bk: books){
    	  booklist.add(new BookList(bk));
      }
            
      return booklist;
  }
  
  
  
  public void loadCheckout(){
		
	  try {			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Checkout.fxml"));			
			Stage stage1 = new Stage();
			Scene scene = new Scene(root, 350, 250);
			stage1.setScene(scene);
			stage1.initModality(Modality.APPLICATION_MODAL);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
  }
  
  
  
  
  
public void loadViewCheckout(LibraryMember member){
	  
	  Stage window = new Stage();
	  window.setTitle("Checkout records for" + member.getFirstName() + " " + member.getLastName());
	  
	  TableView<CheckoutRecordList> table = new TableView<>();
	  
	  //ISBN column
      TableColumn<CheckoutRecordList, String> isbnColumn = new TableColumn<>("Book ISBN");
      isbnColumn.setMinWidth(200);
      isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bookISBN"));

      //Title column
      TableColumn<CheckoutRecordList, String> titleColumn = new TableColumn<>("Title");
      titleColumn.setMinWidth(100);
      titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
      
      //checkoutDate column
      TableColumn<CheckoutRecordList, String> checkoutdateColumn = new TableColumn<>("CheckoutDate");
      checkoutdateColumn.setMinWidth(200);
      checkoutdateColumn.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
      
      //due date
      TableColumn<CheckoutRecordList, String> duedateColumn = new TableColumn<>("DueDate");
      duedateColumn.setMinWidth(300);
      duedateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

      table.setItems(getCheckoutList(member));
      table.getColumns().addAll(isbnColumn, titleColumn, checkoutdateColumn, duedateColumn);
      
      VBox vBox = new VBox();
      vBox.getChildren().addAll(table);

      Scene scene = new Scene(vBox);
      window.setScene(scene);
      window.show();
	  
		
  }
  
  
public ObservableList<CheckoutRecordList> getCheckoutList(LibraryMember member){
	  
	  List<CheckoutRecordEntry> entries = member.getCheckoutRecord().getCheckoutRecordEntries();
    ObservableList<CheckoutRecordList> list = FXCollections.observableArrayList();
    
    for(CheckoutRecordEntry en: entries){
    	list.add(new CheckoutRecordList(en));
    }
          
    return list;
}


  
  
}
