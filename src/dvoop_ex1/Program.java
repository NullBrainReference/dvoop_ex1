package dvoop_ex1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dvoop_ex1.books.Book;
import dvoop_ex1.books.BookLending;
import dvoop_ex1.books.BookUtil;

class Program {
	
	private static List<Book> books = createDummyBooks();
	private static List<Librarian> librarians = createDummyWorkers();
	private static List<BookLending> lendings = new ArrayList<BookLending>();
	
	public static void main(String[] args) {
		String[] options = new String[] {"Lend", "Return", "Add librarian", "Add book", "Exit"};
		
		while (true) {
			showStockpile();
			String option = (String) JOptionPane.showInputDialog(null, "Choose action", "Menu", 0, null, options, "Lend");
			
			switch (option) {
				case "Lend":
					lendBook();
					break;
				case "Return":
					returnBook();
					break;
				case "Add librarian":
					addLibrarian();
					break;
				case "Add book":
					addBook();
					break;
				case "Exit":
					return;
			}
		}
	}
	
	private static void lendBook() {
		String title = (String) JOptionPane.showInputDialog("Enter book title");
		List<Book> availables = BookUtil.getAvailables(books, title);
		
		if (availables.size() <= 0) {
			JOptionPane.showMessageDialog(null, "Out of stock");
			return;
		}
		
		String[] options = new String[librarians.size()];
		
		for (int i = 0; i < options.length; i++) {
			options[i] = librarians.get(i).toString();
		}
		
		String worker = (String) JOptionPane.showInputDialog(null, "Choose giver", "Lending", 0, null, options, "Lend");
		
		Librarian librarian = librarians.get(0);
		for (var w : librarians) {
			if (w.toString().equals(worker)) {
				librarian = w;
				break;
			}
		}
		
		String readerDNI = (String) JOptionPane.showInputDialog("Enter taker DNI");
		
		lendings.add(new BookLending(availables.get(0), librarian, readerDNI));
	}
	
	private static void returnBook() {
		String dni = (String) JOptionPane.showInputDialog("Enter DNI");
		String title = (String) JOptionPane.showInputDialog("Enter title");
		
		BookLending wasFound = null;
		
		for (var lending : lendings) {
			if (lending.getReader().equals(dni) == false)
				continue;
			if (lending.getBook().equals(title) == false)
				continue;
			
			lending.returnToStock();
			JOptionPane.showMessageDialog(null, "Book returned");
			wasFound = lending;
			break;
		}
		
		if (wasFound != null)
			lendings.remove(wasFound);
		else
			JOptionPane.showMessageDialog(null, "Not found");
	}
	
	private static void showStockpile() {
		var stocks = BookUtil.getAvailables(books);
		
		String output = "";
		
		for (Book book : stocks) {
			output += book.toString() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, output);
	}
	
	private static void addLibrarian() {
		String dni = (String) JOptionPane.showInputDialog("Enter DNI");
		String name = (String) JOptionPane.showInputDialog("Enter name");
		String surname = (String) JOptionPane.showInputDialog("Enter surname");
		
		Librarian worker = new Librarian(dni, name, surname);
		
		librarians.add(worker);
	}
	
	private static void addBook() {
		String title = (String) JOptionPane.showInputDialog("Enter title");
		String author = (String) JOptionPane.showInputDialog("Enter author");
		
		Book book = new Book(title, author);
		
		books.add(book);
	}
	
	private static List<Book> createDummyBooks(){
		List<Book> result = new ArrayList<Book>();
		
		result.add(new Book("Silly book", "Silly Dude"));
		result.add(new Book("Serious book", "Serious Dude"));
		result.add(new Book("Serious book", "Serious Dude"));
		result.add(new Book("Serious book", "Serious Dude"));
		result.add(new Book("How To?", "Houdy Doo"));
		result.add(new Book("How To?", "Houdy Doo"));
		result.add(new Book("Leviathan", "Thomas Gobs"));
		result.add(new Book("Leviathan", "Thomas Gobs"));
		
		return result;
	}
	
	private static List<Librarian> createDummyWorkers(){
		List<Librarian> result = new ArrayList<Librarian>();
		
		result.add(new Librarian("111" ,"Sam", "Washington"));
		result.add(new Librarian("122","Billy", "Jean"));
		
		return result;
	}

}
