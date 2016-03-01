package LibrarySystem;

import java.io.Serializable;

public class BookCopy implements Serializable {

	private static final long serialVersionUID = 1L;
	private int copyID;

	public int getCopyID() {
		return copyID;
	}

	private boolean available;
	private Book book;

	public Book getBook() {
		return book;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public BookCopy(int copyID, boolean available, Book book) {
		this.copyID = copyID;
		this.available = available;
		this.book = book;
	}
}
