package LibrarySystem;

public class BookCopy {
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
