package LibrarySystem.db;

import java.util.List;

import LibrarySystem.Book;
import LibrarySystem.ConstTypes;
import LibrarySystem.LibraryMember;
import LibrarySystem.Person;
import LibrarySystem.User;

public class DBService {
	@SuppressWarnings("unchecked")
	public static List<User> getAllUsers() {
		Object obj = Tool.read(ConstTypes.USERSTR);
		if (obj == null) {
			return null;
		}
		return (List<User>) obj;
	}

	@SuppressWarnings("unchecked")
	public static List<Book> getAllBooks() {
		Object obj = Tool.read(ConstTypes.BOOKSTR);
		if (obj == null) {
			return null;
		}
		return (List<Book>) obj;
	}

	// for book and bookcopy
	public static void addBook(Book book) {
		Tool.save(ConstTypes.BOOKSTR + book.getISBN(), book);
		List<Book> allBooks = getAllBooks();
		for (Book b : allBooks) {
			if (b.getISBN().equals(book.getISBN())) {
				return;
			}
		}
		allBooks.add(book);
	}

	@SuppressWarnings("unchecked")
	public static List<LibraryMember> getAllLibraryMembers() {
		Object obj = Tool.read(ConstTypes.LIBRARYMEMBERSTR);
		if (obj == null) {
			return null;
		}
		return (List<LibraryMember>) obj;
	}

	public static void addMember(LibraryMember member) {
		// Tool.save(ConstTypes.LIBRARYMEMBERSTR + member.getID(), member);
		Tool.save(ConstTypes.LIBRARYMEMBERSTR + Tool.nextID(), member);

		List<LibraryMember> allLibraryMembers = getAllLibraryMembers();
		for (LibraryMember m : allLibraryMembers) {
			if (m.getID() == member.getID()) {
				return;
			}
		}
		allLibraryMembers.add(member);
	}

	public static LibraryMember searchLibraryMember(String id) {
		Object obj = Tool.read(ConstTypes.LIBRARYMEMBERSTR + id);
		if (obj == null) {
			return null;
		}
		return (LibraryMember) obj;
	}

	public static Book searchBook(String ISBN) {
		Object book = Tool.read(ConstTypes.BOOKSTR + ISBN);
		if (book == null) {
			return null;
		}
		return (Book) book;
	}

	public Person searchPerson(String firstname) {
		Object person = Tool.read(ConstTypes.PERSONSTR + firstname);
		if (person == null) {
			return null;
		}
		return (Person) person;
	}

	// for book and bookcopy
	public static void updateBook(Book book) {
		Tool.update(ConstTypes.BOOKSTR + book.getISBN(), book);
	}

	public LibraryMember searchMember(int id) {
		Object member = Tool.read(ConstTypes.LIBRARYMEMBERSTR + id);
		if (member == null) {
			return null;
		}
		return (LibraryMember) member;
	}

	public void checkout(LibraryMember member, Book book) {
	}

}
