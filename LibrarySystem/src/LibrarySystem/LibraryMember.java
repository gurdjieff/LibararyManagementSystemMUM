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
	public LibraryMember(int ID) {
		this.checkoutRecord = new CheckoutRecord(this);
		this.ID = ID;
	}
}
