package LibrarySystem;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	String firstName;
	String lastName;
	Address address;
	
	Person (String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.address = address;
		this.lastName = lastName;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
