package dvoop_ex1;

public class Librarian {
	private String dni;
	private String name;
	private String surname;
	
	public Librarian(String dni, String name, String surname) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", name, surname);
	}
}
