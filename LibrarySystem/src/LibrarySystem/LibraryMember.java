package LibrarySystem;


public class LibraryMember extends Person {
	private int ID;
	public int getID() {
		return ID;
	}
	private CheckoutRecord checkoutRecord;
	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}
	
	public LibraryMember(String firstName, String lastName, Address address) {
		super(firstName, lastName, address);
		this.checkoutRecord = new CheckoutRecord(this);
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}
	
	@Override
	public String toString(){
		return String.format("FName: %s, LName: %s, ID: %d", getFirstName(), getLastName(), getID());
	}
	
}
