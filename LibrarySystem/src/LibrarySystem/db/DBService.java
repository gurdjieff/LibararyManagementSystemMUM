package LibrarySystem.db;

import java.util.List;

import LibrarySystem.Book;
import LibrarySystem.LibraryMember;
import LibrarySystem.Person;
import LibrarySystem.User;

public class DBService {
	public boolean addMember(LibraryMember member) {
		return true;
	}

	@SuppressWarnings("unchecked")
	public static List<User> getAllUsers() {
		Object obj = Tool.read("users");
		if (obj == null) {
			return null;
		}
		return (List<User>) obj;
	}

	public Book searchBook(String ISBN) {
		Object book = Tool.read("book" + ISBN);
		if (book == null) {
			return null;
		}
		return (Book) book;
	}

	public Person searchPerson(String firstname) {
		Object person = Tool.read("person" + firstname);
		if (person == null) {
			return null;
		}
		return (Person) person;
	}

	public boolean addCopy(String ISBN) {
		return true;
	}

	public void addBook(Book book) {
		
	}

	public LibraryMember searchMember(int id) {
		Object member = Tool.read("member" + id);
		if (member == null) {
			return null;
		}
		return (LibraryMember) member;
	}

	public void checkout(LibraryMember member, Book book) {
	}

}
