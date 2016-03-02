package LibrarySystem;

import java.io.Serializable;

public class Author extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	String Credential;
	String shortBio;
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		// TODO Auto-generated constructor stub
	}
	
}
