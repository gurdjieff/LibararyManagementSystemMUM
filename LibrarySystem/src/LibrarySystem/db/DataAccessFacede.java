package LibrarySystem.db;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import LibrarySystem.Author;
import LibrarySystem.Book;
import LibrarySystem.CheckoutRecord;
import LibrarySystem.CheckoutRecordEntry;
import LibrarySystem.ConstTypes;
import LibrarySystem.ConstTypes.UserType;
import LibrarySystem.LibraryMember;
import LibrarySystem.User;

public class DataAccessFacede {

	public static void init() {
		if (getAllBooks().size() == 0) {
			for (int i = 0; i < 6; i++) {
				List<Author> authors = new LinkedList<Author>();
				authors.add(new Author("1firstName1" + i, "1lastName" + i));
				authors.add(new Author("1firstName1" + i, "1lastName" + i));
				addBook(new Book("" + (i + 1), "book" + (i + 1), i + 1, i + 1, authors));
			}
		}

		if (getAllMembers().size() == 0) {
			addMember(new LibraryMember("firstname01", "lastName02", null));
			addMember(new LibraryMember("firstname01", "lastName02", null));
			addMember(new LibraryMember("firstname01", "lastName02", null));
			addMember(new LibraryMember("firstname01", "lastName02", null));
		}

		if (getAllUsers().size() == 0) {
			for (int i = 0; i < 4; i++) {
				addUser(new User(UserType.LIBRARIAN, "l" + i, "1"));
				addUser(new User(UserType.ADMINE, "a" + i, "1"));
				addUser(new User(UserType.BOTH, "b" + i, "1"));
			}
		}
	}

	public static void clear() {
		Tool.save(ConstTypes.LIBRARYMEMBERSTR, null);
		Tool.save(ConstTypes.BOOKSTR, null);
		Tool.save(ConstTypes.USERSTR, null);
	}

	public static void main(String[] args) {
		clear();
		init();
	}

	public static void getAllBook() {
		List<Book> books = getAllBooks();
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i).toString());
		}
	}

	@SuppressWarnings("unchecked")
	public static List<LibraryMember> getAllMembers() {
		Object obj = Tool.read(ConstTypes.LIBRARYMEMBERSTR);
		if (obj == null) {
			return new ArrayList<LibraryMember>();
		}
		return (List<LibraryMember>) obj;
	}

	public static void membersPersistence(List<LibraryMember> members) {
		Tool.save(ConstTypes.LIBRARYMEMBERSTR, members);
	}

	public static void booksPersistence(List<Book> books) {
		Tool.save(ConstTypes.BOOKSTR, books);
	}

	public static void usersPersistence(List<User> users) {
		Tool.save(ConstTypes.USERSTR, users);
	}

	public static LibraryMember getMemberWithId(int ID) {
		List<LibraryMember> members = getAllMembers();
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getID() == ID) {
				return members.get(i);
			}
		}
		return null;
	}

	public static LibraryMember addMember(LibraryMember member) {
		List<LibraryMember> members = getAllMembers();
		member.setID(members.size());
		members.add(member);
		membersPersistence(members);
		// save
		return member;
	}

	public static LibraryMember updateMember(LibraryMember member) {
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

	@SuppressWarnings("unchecked")
	public static List<Book> getAllBooks() {
		Object obj = Tool.read(ConstTypes.BOOKSTR);
		if (obj == null) {
			return new ArrayList<Book>();
		}
		return (List<Book>) obj;
	}

	public static Book getBook(String ISBN) {
		List<Book> books = getAllBooks();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getISBN().equals(ISBN)) {
				return books.get(i);
			}

		}
		return null;
	}

	public static Book updateBook(Book book) {
		List<Book> books = getAllBooks();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getISBN().equals(book.getISBN())) {
				books.set(i, book);
				booksPersistence(books);
				// save
				return book;
			}
		}

		return book;
	}

	public static Book addBook(Book book) {
		List<Book> books = getAllBooks();
		books.add(book);
		booksPersistence(books);
		return book;
	}

	@SuppressWarnings("unchecked")
	public static List<User> getAllUsers() {
		Object obj = Tool.read(ConstTypes.USERSTR);
		if (obj == null) {
			return new ArrayList<User>();
		}
		return (List<User>) obj;
	}

	public static User getUser(String ID, String password) {
		List<User> users = getAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getID().equals(ID) && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		return null;
	}

	public static User addUser(User user) {
		List<User> users = getAllUsers();
		users.add(user);
		usersPersistence(users);
		return user;
	}

	public static void printUserCheckoutRecords(int id) {
		LibraryMember member = getMemberWithId(id);
		String line = new String(new char[20]).replace("\0", "-");
		System.out.println(line);
		System.out.printf("--%s %s(%s) checkout record list--\r\n", member.getFirstName(), member.getLastName(),
				member.getID());
		System.out.printf("|%20s|", "Book");
		System.out.printf("%15s|", "CheckoutDate");
		System.out.printf("%15s|\n", "DueDate");
		System.out.println(line);

		CheckoutRecord checkoutRecord = member.getCheckoutRecord();

		List<CheckoutRecordEntry> entries = checkoutRecord.getCheckoutRecordEntries();

		entries.stream().forEach((entry) -> {
			System.out.printf("|%20s|", entry.getBookCopy().getBook().getTitle());
			System.out.printf("%15s|", entry.getCheckoutDate());
			System.out.printf("%15s|\n", entry.getDueDate());
			System.out.println(line);
		});
	}
}
