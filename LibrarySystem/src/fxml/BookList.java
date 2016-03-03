package fxml;

import java.util.List;

import LibrarySystem.Author;
import LibrarySystem.Book;
import LibrarySystem.BookCopy;

public class BookList {
	
	private String ISBN;
	private String title;
	private String authors;
	private int numberOfCopies;
	private int maxLength;
	private String available;
	
	public BookList(Book book){
		setISBN(book.getISBN());
		setTitle(book.getTitle());
		setAuthors(book.getAuthors());
		setNumberOfCopies(book.getBookCopies());
		setMaxLength(book.getMaxCheckoutLength());
		setAvailable(book.getBookCopies());		
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

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> A) {
		String s = "";
		s += A.get(0).toString() + ", ";
		s += A.get(1).toString();
		this.authors = s;
	}

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(List<BookCopy> BC) {
		this.numberOfCopies = BC.size();
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(List<BookCopy> BC) {
		String s = "No";
		for(BookCopy bc: BC){
			if(bc.isAvailable()){
				s = "Yes";
				break;
			}
		}
		this.available = s;
	}
}
