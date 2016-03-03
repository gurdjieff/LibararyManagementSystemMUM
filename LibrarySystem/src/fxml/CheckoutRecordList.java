package fxml;

import LibrarySystem.CheckoutRecordEntry;

public class CheckoutRecordList {

	
	private String bookISBN;
	private String title;
	private String checkoutDate;
	private String dueDate;
	
	public CheckoutRecordList(CheckoutRecordEntry entry){
		setBookISBN(entry.getBookCopy().getBook().getISBN());
		setTitle(entry.getBookCopy().getBook().getTitle());
		setCheckoutDate(entry.getCheckoutDate().toString());
		setDueDate(entry.getDueDate().toString());
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
