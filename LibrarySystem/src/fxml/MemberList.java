package fxml;

import LibrarySystem.Address;
import LibrarySystem.LibraryMember;

public class MemberList {

	private String firstName;
	private String lastName;
	private String address;
	
	public MemberList(LibraryMember libM){
		this.firstName = libM.getFirstName();
		this.lastName = libM.getLastName();
		setAddress(libM.getAddress());
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
	public String getAddress() {
		return address;
	}
	public void setAddress(Address A) {
		if (A != null) {
			this.address = (A.getStreet() + ", " + A.getCity() + ", " + A.getState() + ", " + A.getZip() + ", " + A.getPhoneNumber());
		}
	}
	
	
}
