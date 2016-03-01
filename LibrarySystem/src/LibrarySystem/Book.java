package LibrarySystem;

import java.util.LinkedList;
import java.util.List;

public class Book {
	String ISBN;
	String title;
	int maxCheckoutLength;
	List<Author> authors;
	
	
	private List<BookCopy> bookCopies;
	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}
	
	public void addAuthor(Author author) {
		authors.add(author);
	}
	
	public void addCopy (BookCopy bookCopy) {
		bookCopies.add(bookCopy);
	}
	
	public Book() {
		bookCopies = new LinkedList<BookCopy>();
		authors = new LinkedList<Author>();
		maxCheckoutLength = 1;
	}
	
	public Book(String ISBN, String title, int maxCheckoutLength) {
		this();
		this.ISBN = ISBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
	}
	
	
}
