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

	public void addAuthor(Author author) {
		authors.add(author);
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

	public Book(String ISBN, String title, int maxCheckoutLength, int numOfCopies, List<Author> authors) {
		this();
		this.ISBN = ISBN;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;

		for (int i = 0; i < numOfCopies; i++) {
			addCopy(new BookCopy(i, true, this));
		}
		authors.addAll(authors);
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}

	public void setMaxCheckoutLength(int maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}

}
