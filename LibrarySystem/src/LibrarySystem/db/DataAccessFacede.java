package LibrarySystem.db;
import java.util.ArrayList;
import java.util.List;

import LibrarySystem.Book;
import LibrarySystem.CheckoutRecord;
import LibrarySystem.CheckoutRecordEntry;
import LibrarySystem.ConstTypes;
import LibrarySystem.LibraryMember;
import LibrarySystem.User;
import LibrarySystem.ConstTypes.UserType;

public class DataAccessFacede {
	
	static public void init () {
		if (getAllBooks().size() == 0) {
			addBook(new Book("11111", "book1", 1));
			addBook(new Book("222", "book2", 2));
			addBook(new Book("333", "book3", 3));
			addBook(new Book("444", "book4", 4));
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
	
	static public void clear () {
		Tool.save(ConstTypes.LIBRARYMEMBERSTR , null);
		Tool.save(ConstTypes.BOOKSTR , null);
		Tool.save(ConstTypes.USERSTR , null);
	}
	public static void main(String[] args) {
		clear();
		init();
	}
	
	public static void getAllBook () {
		List<Book> books = getAllBooks();
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i).toString());
		}
	}
	
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
			if (users.get(i).getID().equals(ID) && users.get(i).getPassword().equals(password)) {
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
        
        public static void printUserCheckoutRecords(int id) {
            LibraryMember member = getMemberWithId(id);
            String line = new String(new char[20]).replace("\0", "-");
            System.out.println(line);
            System.out.printf("--%s %s(%s) checkout record list--\r\n",
                    member.getFirstName(),
                    member.getLastName(),
                    member.getID());
            System.out.printf("|%20s|", "Book");
            System.out.printf("%15s|", "CheckoutDate");
            System.out.printf("%15s|\n", "DueDate");
            System.out.println(line);

            CheckoutRecord checkoutRecord = member.getCheckoutRecord();

            List<CheckoutRecordEntry> entries = checkoutRecord.getCheckoutRecordEntries();

            entries.stream().forEach((entry)->{
                System.out.printf("|%20s|", entry.getBookCopy().getBook().getTitle());
                System.out.printf("%15s|", entry.getCheckoutDate());
                System.out.printf("%15s|\n", entry.getDueDate());
                System.out.println(line);
            });
    }
}
