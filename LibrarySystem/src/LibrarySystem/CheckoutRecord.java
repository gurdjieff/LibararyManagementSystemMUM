package LibrarySystem;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class CheckoutRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	private LibraryMember member;

	public LibraryMember getMember() {
		return member;
	}

	private List<CheckoutRecordEntry> checkoutRecordEntries;

	public List<CheckoutRecordEntry> getCheckoutRecordEntries() {
		return checkoutRecordEntries;
	}

	private List<CheckoutRecordFine> checkoutRecordFines;

	public List<CheckoutRecordFine> getCheckoutRecordFines() {
		return checkoutRecordFines;
	}

	public CheckoutRecord() {
		checkoutRecordEntries = new LinkedList<CheckoutRecordEntry>();
		checkoutRecordFines = new LinkedList<CheckoutRecordFine>();
	}

	public CheckoutRecord(LibraryMember member) {
		this();
		this.member = member;
	}

	public void addCheckoutEntry(CheckoutRecordEntry entry) {
		checkoutRecordEntries.add(entry);
	}

	public void addCheckoutFine(CheckoutRecordFine fine) {
		checkoutRecordFines.add(fine);
	}
}
