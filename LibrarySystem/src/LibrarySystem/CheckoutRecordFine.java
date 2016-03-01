package LibrarySystem;

import java.io.Serializable;
import java.sql.Date;

public class CheckoutRecordFine implements Serializable {

	private static final long serialVersionUID = 1L;
	BookCopy bookCopy;
	Date checkoutDate;
	Date dueDate;
	double fine;

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

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

}
