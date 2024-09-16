package dvoop_ex1.books;

import dvoop_ex1.Librarian;

public class BookLending {
	private Book book;
	
	private Librarian librarian;
	private String readerDNI;
	
	public BookLending(Book book ,Librarian librarian, String readerDNI) {
		this.book = book;
		this.librarian = librarian;
		this.readerDNI = readerDNI;
		
		book.SetStatus(BookStatus.Given);
	}
	
	public String getBook() {
		return book.getTitle();
	}
	public String getReader() {
		return readerDNI;
	}
	
	public void returnToStock() {
		book.SetStatus(BookStatus.Stock);
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", readerDNI, getBook());
	}
}
