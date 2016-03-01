package LibrarySystem;

import java.io.Serializable;

import LibrarySystem.ConstTypes.UserType;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	String firstName;
	UserType userType;
	String ID;
	String password;

	public User(UserType userType, String ID, String password) {
		this.ID = ID;
		this.password = password;
		this.userType = userType;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
