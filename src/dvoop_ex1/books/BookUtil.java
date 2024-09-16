package dvoop_ex1.books;

import java.util.ArrayList;
import java.util.List;

public class BookUtil {
	private static int lastId = 0;
	
	public static int giveId() {
		lastId++;
		return lastId;
	}
	
	public static List<Book> getAvailables(List<Book> books){
		List<Book> result = new ArrayList<Book>();
		
		for (Book book : books) {
			if (book.isAvailable())
				result.add(book);
		}
		
		return result;
	}
	
	public static List<Book> getAvailables(List<Book> books, String name){
		List<Book> result = new ArrayList<Book>();
		
		for (Book book : books) {
			if (book.isAvailable() == false)
				continue;
			
			if (book.getTitle().contains(name))
				result.add(book);
		}
		
		return result;
	}
}
