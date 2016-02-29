package LibrarySystem;


enum UserType {
    LIBRARIAN, ADMINE, BOTH
}


public class User {
    UserType userType;
    String ID;
    String password;
    
    public User(UserType userType, String ID, String password) {
    	this.ID = ID;
    	this.password = password;
    	this.userType = userType;
	}

}
	
