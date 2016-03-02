package LibrarySystem;

import java.sql.Date;
import java.util.List;

import LibrarySystem.db.DBService;
import LibrarySystem.db.DataAccessFacede;

public class OperationAssistant {
	public static User login(String ID, String password) {
		return DataAccessFacede.getUser(ID, password);
	}

	public static Book addBook(Book book) {
		return DataAccessFacede.addBook(book);
	}

	public static BookCopy addCopy(Book book) {
		BookCopy bookCopy = new BookCopy(book.getBookCopies().size(), true, book);
		book.addCopy(bookCopy);
		DataAccessFacede.updateBook(book);
		return bookCopy;
	}

	public static List<LibraryMember> getAllLibraryMembers() {
		return DataAccessFacede.getAllMembers();
	}

	public static List<Book> getAllBooks() {
		return DataAccessFacede.getAllBooks();
	}

	public static LibraryMember addMember(LibraryMember member) {
		return DataAccessFacede.addMember(member);
	}

	public static Book searchBook(String ISBN) {
		return DataAccessFacede.getBook(ISBN);
	}

	public static BookCopy searchBookCopyWithISBN(String ISBN) {
		Book book = searchBook(ISBN);
		for (int i = 0; i < book.getBookCopies().size(); i++) {
			BookCopy bookCopy = book.getBookCopies().get(i);
			if (bookCopy.isAvailable() == true) {
				return bookCopy;
			}
		}

		return null;
	}

	public static LibraryMember searchMember(String id) {
		return DataAccessFacede.getMemberWithId(Integer.parseInt(id));
	}

	public static CheckoutRecordEntry checkout(BookCopy bookCopy, LibraryMember member) {
		// LibraryMember member = searchMember(memberID);
		// BookCopy bookCopy = searchBookCopyWithISBN(ISBN);

		if (member != null && bookCopy != null) {
			bookCopy.setAvailable(false);
			
			Date nowTime = new Date(System.currentTimeMillis());
			Date dueTime = new Date(
					System.currentTimeMillis() + bookCopy.getBook().maxCheckoutLength 
					* 24 * 60 * 60 * 1000);
			CheckoutRecordEntry checkoutRecordEntry = new CheckoutRecordEntry(bookCopy, nowTime, dueTime);
			member.getCheckoutRecord().addCheckoutEntry(checkoutRecordEntry);
			
			
			DataAccessFacede.updateBook(bookCopy.getBook());
			DataAccessFacede.updateMember(member);
		}
		return null;
	}

	public static CheckoutRecordEntry checkout(String ISBN, String memberID) {
		LibraryMember member = searchMember(memberID);
		BookCopy bookCopy = searchBookCopyWithISBN(ISBN);

		if (member != null && bookCopy != null) {
			bookCopy.setAvailable(false);
			CheckoutRecordEntry checkoutRecordEntry = new CheckoutRecordEntry(bookCopy, new Date(0), new Date(0));
			member.getCheckoutRecord().addCheckoutEntry(checkoutRecordEntry);
			
			DataAccessFacede.updateBook(bookCopy.getBook());
			DataAccessFacede.updateMember(member);
		}

		return null;
	}
	
	public static void disPlayMembers() {
		List<LibraryMember> list = getAllLibraryMembers();
		for (int i = 0; i < list.size(); i++) {
			LibraryMember member = list.get(i);
			System.out.println(i+1+" | "+member.firstName+" | "+member.lastName+member.address.toString());
			
		}
	}


}
