package LibrarySystem;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	String street;
	String city;
	String state;
	String zip;
	String phoneNumber;
	
	public Address(String street, String city, String state, String phoneNumber, String zip) {
		this.city = city;
		this.street = street;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
