package LibrarySystem;

import java.sql.Date;

public class CheckoutRecordEntry {
	private BookCopy bookCopy;
	private Date checkoutDate;
	private Date dueDate;
	
	public CheckoutRecordEntry(BookCopy bookCopy, Date checkoutDate, Date dueDate) {
		this.bookCopy = bookCopy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
}
