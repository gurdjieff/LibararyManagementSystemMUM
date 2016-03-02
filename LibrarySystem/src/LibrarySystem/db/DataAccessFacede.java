package LibrarySystem.db;
import java.util.ArrayList;
import java.util.List;

import LibrarySystem.Book;
import LibrarySystem.ConstTypes;
import LibrarySystem.LibraryMember;
import LibrarySystem.User;

public class DataAccessFacede {
	
	static public List<LibraryMember> getAllMembers () {
		Object obj = Tool.read(ConstTypes.LIBRARYMEMBERSTR);
		if (obj == null) {			
			return new ArrayList<LibraryMember>();
		}  
		return (List<LibraryMember>) obj;
	}
	
	static public void membersPersistence (List<LibraryMember> members) {
		Tool.save(ConstTypes.LIBRARYMEMBERSTR , members);
	}
	
	static public void booksPersistence (List<Book> books) {
		Tool.save(ConstTypes.BOOKSTR , books);
	}
	
	static public void usersPersistence (List<User> users) {
		Tool.save(ConstTypes.USERSTR , users);

		
	}
	
	static public LibraryMember getMemberWithId (int ID) {
		List<LibraryMember> members = getAllMembers();
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getID() == ID) {
				return members.get(i);
			}
		}
		return null;
	}
	
	static public LibraryMember addMember (LibraryMember member) {
		List<LibraryMember> members = getAllMembers();
		member.setID(members.size());
		members.add(member);
		membersPersistence(members);
//		save
		return member;
	}
	
	static public LibraryMember updateMember (LibraryMember member) {
		List<LibraryMember> members = getAllMembers();
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getID() == member.getID()) {
				members.set(i, member);
				membersPersistence(members);
				return member;
			}
		}
		return null;
	}
	
	static public List<Book> getAllBooks () {
		Object obj = Tool.read(ConstTypes.BOOKSTR);
		if (obj == null) {			
			return new ArrayList<Book>();
		}  
		return (List<Book>) obj;
	}
	
	static public Book getBook(String ISBN) {
		List<Book> books = getAllBooks();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getISBN().equals(ISBN)) {
				return books.get(i);
			}
			
		}
		return null;
	}
	
	static public Book updateBook (Book book) {
		List<Book> books = getAllBooks();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getISBN().equals(book.getISBN())) {
				books.set(i, book);
				booksPersistence(books);
//				save
				return book;
			}
		}		
		
		return book;
	}
	
	static public Book addBook (Book book) {
		List<Book> books = getAllBooks();	
		books.add(book);
		booksPersistence(books);
//		save
		
		return book;
	}
	
	static public List<User> getAllUsers () {
		Object obj = Tool.read(ConstTypes.USERSTR);
		if (obj == null) {			
			return new ArrayList<User>();
		}  
		return (List<User>) obj;
	}
	
	
	static public User getUser (String ID, String password) {
		List<User> users = getAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getID().equals(ID) && users.get(i).equals(password)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	static public User addUser (User user) {
		List<User> users = getAllUsers();
		users.add(user);
		usersPersistence(users);
		return user;
	}
}
