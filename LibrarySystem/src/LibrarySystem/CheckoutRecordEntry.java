package LibrarySystem;

import java.io.Serializable;
import java.sql.Date;

public class CheckoutRecordEntry implements Serializable {

	private static final long serialVersionUID = 1L;
	private BookCopy bookCopy;
	private Date checkoutDate;
	private Date dueDate;

	public CheckoutRecordEntry(BookCopy bookCopy, Date checkoutDate, Date dueDate) {
		this.bookCopy = bookCopy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
