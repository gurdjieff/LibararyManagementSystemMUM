package LibrarySystem;

import java.io.Serializable;

public class Author extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	String Credential;
	public String getCredential() {
		return Credential;
	}

	public void setCredential(String credential) {
		Credential = credential;
	}

	String shortBio;
	
	public String getShortBio() {
		return shortBio;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}

	public Author(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		// TODO Auto-generated constructor stub
	}
	
}
