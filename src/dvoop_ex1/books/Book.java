package dvoop_ex1.books;

public class Book {
	private int id;
	
	private String title;
	private String author;
	
	private BookStatus status;
	
	public Book(String title, String author) {
		id = BookUtil.giveId();
		
		this.title = title;
		this.author = author;
		
		status = BookStatus.Stock;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void SetStatus(BookStatus status) {
		this.status = status;
	}
	
	public boolean isAvailable() {
		if (status == BookStatus.Stock)
			return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("%s by %s", title, author);
	}
}
