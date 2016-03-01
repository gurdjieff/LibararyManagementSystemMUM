package LibrarySystem.db;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import LibrarySystem.Address;
import LibrarySystem.Book;
import LibrarySystem.Person;

public class Tool {

	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "\\LibrarySystem"
			+ "\\src\\LibrarySystem\\librarysample\\dataaccess\\storage";

	public static void init() {
		for (int i = 0; i < 10; i++) {
			save("book" + i, new Book(i + "", i + "", i));
		}

		for (int j = 0; j < 10; j++) {
			Person person = new Person();
			person.setFirstName("firstname" + j);
			person.setLastName("lastname" + j);
			Address address = new Address();
			address.setCity("IA" + j);
			person.setAddress(address);
			save("person" + j, person);
		}
	}

	public static void save(String name, Object member) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(member);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public static void save2(String name, Object member) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR + "\\" + member.getClass().getSimpleName(), name);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(member);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public static boolean ifExist(String name) {
		return read(name) == null ? false : true;
	}

	public static void update(String name, Object member) {
		save(name, member);
	}

	public static Object read(String name) {
		ObjectInputStream in = null;
		Object member = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
			in = new ObjectInputStream(Files.newInputStream(path));
			member = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return member;
	}

	public static Object read(String name, Object member) {
		ObjectInputStream in = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR + "\\" + member.getClass().getSimpleName(), name);
			in = new ObjectInputStream(Files.newInputStream(path));
			member = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return member;
	}

}
