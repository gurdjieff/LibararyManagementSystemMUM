package LibrarySystem;

import java.lang.reflect.Member;
import java.sql.Date;
import java.util.List;

import LibrarySystem.db.DBService;

public class OperationAssistant {
	public static User login(String ID, String password) {
		List<User> users = DBService.getAllUsers();

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.ID.equals(ID) && user.password.equals(password)) {
				return user;
			}
		}
		return null;
	}

	public static Book addBook(Book book) {
		DBService.addBook(book);
		return book;
	}

	public static BookCopy addCopy(Book book) {
		BookCopy bookCopy = new BookCopy(book.getBookCopies().size(), true, book);
		book.addCopy(bookCopy);
		DBService.updateBook(book);
		return bookCopy;
	}

	public static List<LibraryMember> getAllLibraryMembers() {
		return DBService.getAllLibraryMembers();
	}

	public static List<Book> getAllBooks() {
		return DBService.getAllBooks();
	}

	public static LibraryMember addMember(LibraryMember member) {
		DBService.addMember(member);
		return member;
	}

	public static Book searchBook(String ISBN) {
		return DBService.searchBook(ISBN);
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
		return DBService.searchLibraryMember(id);
	}

	public static CheckoutRecordEntry checkout(BookCopy bookCopy, LibraryMember member) {
		// LibraryMember member = searchMember(memberID);
		// BookCopy bookCopy = searchBookCopyWithISBN(ISBN);

		if (member != null && bookCopy != null) {
			bookCopy.setAvailable(false);
			// persisting

			// Date date=new Date();
			// DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// String time=format.format(date);
			Date nowTime = new Date(System.currentTimeMillis());
			Date dueTime = new Date(
					System.currentTimeMillis() + bookCopy.getBook().maxCheckoutLength * 24 * 60 * 60 * 1000);

			CheckoutRecordEntry checkoutRecordEntry = new CheckoutRecordEntry(bookCopy, nowTime, dueTime);
			// add specific date.
			member.getCheckoutRecord().addCheckoutEntry(checkoutRecordEntry);
			// persisting
			//
		}
		return null;
	}

	public static CheckoutRecordEntry checkout(String ISBN, String memberID) {
		LibraryMember member = searchMember(memberID);
		BookCopy bookCopy = searchBookCopyWithISBN(ISBN);

		if (member != null && bookCopy != null) {
			bookCopy.setAvailable(false);
			// persisting
			CheckoutRecordEntry checkoutRecordEntry = new CheckoutRecordEntry(bookCopy, new Date(0), new Date(0));
			// add specific date.
			member.getCheckoutRecord().addCheckoutEntry(checkoutRecordEntry);
			// persisting
			//
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
