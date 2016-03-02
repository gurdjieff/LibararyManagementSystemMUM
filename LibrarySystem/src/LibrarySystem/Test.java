package LibrarySystem;

import java.util.ArrayList;
import java.util.List;

import LibrarySystem.db.Tool;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		DBService service = new DBService();
//		Tool.init();
//		System.out.println(service.searchBook("1"));
//		Person person = service.searchPerson("1");
//		System.out.println(person.getAddress().getCity());
//		Object o = new Person();
//		System.out.println(o.getClass().getSimpleName());
//		List<Person> list = new ArrayList<Person>();
//		list.add(person);
//		Tool.save("list1", list);
//		Object list2 = Tool.read("list1");
//
//		System.out.println(list2 == null);
//		System.out.println(((List<Person>) list2).get(0).getFirstName());
//
//		User login = OperationAssistant.login("l1", "1");
//		System.out.println(login.getID()+"===");
//		OperationAssistant.disPlayMembers();
		
		
		Book book = new Book();
		BookCopy bookCopy = new BookCopy(22, true, book);
		book.addCopy(bookCopy);
		
		
		
		System.out.println(bookCopy.getBook().getBookCopies().get(0).isAvailable());
		bookCopy.setAvailable(false);
		System.out.println(bookCopy.getBook().getBookCopies().get(0).isAvailable());

		
		
	}
}
