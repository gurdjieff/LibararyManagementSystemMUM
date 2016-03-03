package LibrarySystem.db;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Tool {

	private static String OUTPUT_DIR = "";
	static {
		Properties props = System.getProperties();
		String osName = props.getProperty("os.name");
		File file = null;
		// for windows
		if (osName.indexOf("Windows") != -1) {
			try {
				OUTPUT_DIR = "c:\\LibrarySystemDB";
				file = new File(OUTPUT_DIR);
				file.mkdirs();
			} catch (Exception e) {
				OUTPUT_DIR = "d:\\LibrarySystemDB";
				file = new File(OUTPUT_DIR);
				file.mkdirs();
			}
		} else {
			// for mac or other
			try {
				OUTPUT_DIR = "/Users/LibrarySystemDB";
				file = new File(OUTPUT_DIR);
				file.mkdirs();
			} catch (Exception e) {
				OUTPUT_DIR = "/Users/tmp/LibrarySystemDB";
				file = new File(OUTPUT_DIR);
				file.mkdirs();
			}
		}
	}

	public static void main(String[] args) {
		Tool.read("");
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

	public static Object read(String name) {
		ObjectInputStream in = null;
		Object member = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
			in = new ObjectInputStream(Files.newInputStream(path));
			member = in.readObject();
		} catch (Exception e) {
			// e.printStackTrace();
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
