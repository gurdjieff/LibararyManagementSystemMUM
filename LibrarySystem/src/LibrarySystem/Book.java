package LibrarySystem;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	String ISBN;
	String title;
	int maxCheckoutLength;
	List<Author> authors;

	private List<BookCopy> bookCopies;

	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void addCopy(BookCopy bookCopy) {
		bookCopies.add(bookCopy);
	}

	public Book() {
		bookCopies = new LinkedList<BookCopy>();
		authors = new LinkedList<Author>();
	}

	public Book(String ISBN, String title, int maxCheckoutLength) {
		this();
		this.ISBN = ISBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
	}

}
