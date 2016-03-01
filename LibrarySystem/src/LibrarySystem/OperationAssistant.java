package LibrarySystem;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;


public class OperationAssistant {
	static List<User> users = new LinkedList<User>(){
		{
			add(new User(UserType.LIBRARIAN, "111", "aaa"));
			add(new User(UserType.ADMINE, "222", "bbb"));
			add(new User(UserType.BOTH, "333", "ccc"));
			add(new User(UserType.BOTH, "444", "ddd"));
		}
	};


	static User login (String ID, String password) {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.ID.equals(ID) && user.password.equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	Book addBook (Book book) {
//		persisting book data;
		return book;
	}
	
	BookCopy addCopy (Book book) {
		BookCopy bookCopy = new BookCopy(book.getBookCopies().size(), true, book);
		book.addCopy(bookCopy);
//		persisting data;
		return bookCopy;
	}
	
	List<LibraryMember> getAllLibraryMembers () {
//		persisting member data;
		
		return null;
	}
	
	List<Book> getAllBooks () {
		return null;
	}

	
	LibraryMember addMember (LibraryMember member) {
//		persisting member data;
		
		return member;
	}
	
	
	
	Book searchBook (String ISBN) {
		return null;
	}
	
	BookCopy searchBookCopyWithISBN (String ISBN) {
		Book book = searchBook(ISBN);
		for (int i = 0; i < book.getBookCopies().size(); i++) {
			BookCopy bookCopy = book.getBookCopies().get(i);
			if (bookCopy.isAvailable() == true) {
				return bookCopy;
			}
		}
		
		
		return null;
	}
	
	LibraryMember searchMember (String ID) {
		return null;
	}
	
	
	CheckoutRecordEntry checkout(BookCopy bookCopy, LibraryMember member) {
//		LibraryMember member = searchMember(memberID);
//		BookCopy bookCopy = searchBookCopyWithISBN(ISBN);
		
		if (member != null && bookCopy != null) {
			bookCopy.setAvailable(false);
//			persisting
			
//			Date date=new Date();
//			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String time=format.format(date);
			  Date nowTime = new Date(System.currentTimeMillis());
			  Date dueTime = new Date(System.currentTimeMillis()+bookCopy.getBook().maxCheckoutLength*24*60*60*1000);


			CheckoutRecordEntry checkoutRecordEntry = 
					new CheckoutRecordEntry(bookCopy, nowTime, dueTime);
//			add specific date.
			member.getCheckoutRecord().addCheckoutEntry(checkoutRecordEntry);
//			persisting
//			
		}
		return null;
	}
	
	CheckoutRecordEntry checkout(String ISBN, String memberID) {
		LibraryMember member = searchMember(memberID);
		BookCopy bookCopy = searchBookCopyWithISBN(ISBN);
		
		if (member != null && bookCopy != null) {
			bookCopy.setAvailable(false);
//			persisting
			CheckoutRecordEntry checkoutRecordEntry = 
					new CheckoutRecordEntry(bookCopy, new Date(0), new Date(0));
//			add specific date.
			member.getCheckoutRecord().addCheckoutEntry(checkoutRecordEntry);
//			persisting
//			
		}
		
		
		return null;
	}
	
	

}
