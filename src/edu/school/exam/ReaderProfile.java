package edu.school.exam;

public class ReaderProfile {
	private String name;
	private String surname;
	private int grade;
	private char major;
	private String number;
	private Book[] books;

	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public int getGrade() {
		return grade;
	}
	public char getMajor() {
		return major;
	}
	public String getNumber() {
		return number;
	}
	public Book[] getBooks() {
		return books;
	}
	
	public void setGrade(int grade) {
		if(grade >=1 && grade <=12) {
			this.grade = grade;
		}
	}
	public void setMajor(char major) {
		if(major >= 'a' && major <= 'i') {
			this.major = major;
		}
	}
	public void setNumber(String number) {
		if(! Validator.isNullOrEmpty(number)){
			this.number = number;
			
		}
	}
	
	public ReaderProfile(String name, String surname, int grade, char major, String number, Book[] books) {
		if(!Validator.isNullOrEmpty(name) && !Validator.isNullOrEmpty(surname) && grade >= 1 && grade <= 12
				&& major >= 'a' && major <= 'i' && ! Validator.isNullOrEmpty(number) && books != null) {
			this.name = name;
			this.surname = surname;
			this.grade = grade;
			this.major = major;
			this.number = number;
			this.books = books;
		}
		
	}
	public ReaderProfile(String name, String surname, int grade, char major, String number) {
		if(!Validator.isNullOrEmpty(name) && !Validator.isNullOrEmpty(surname) && grade >= 1 && grade <= 12
				&& major >= 'a' && major <= 'i' && ! Validator.isNullOrEmpty(number)) {
			this.name = name;
			this.surname = surname;
			this.grade = grade;
			this.major = major;
			this.number = number;
			books = new Book[30];
		}
		
	}
	
	public String toString() { // da se dovurshi
		String result = "Name: " + getName() + "\n" + "Surname: " + getSurname() + "\n" + "Grade: " + getGrade() + "\n" + "Major: " + getMajor() + "\n" + "Phone Number: " + getNumber() + "\n" + "Books: ";
		for(int i = 0; i < getBooks().length; i++) {
			result += this.books[i].toString() + "\n";
		}
		
		return result;	
	}
	
	public boolean getBook(String bookTitle, String bookAuthor) {
		Library schoolLibrary = Library.getInstance();
		if(schoolLibrary.hasBook(bookTitle, bookAuthor) == true) {
			for(int i = 0; i < books.length; i++) {
				if(books[i] == null) {
					books[i] = schoolLibrary.getBook(bookTitle, bookAuthor);
					schoolLibrary.removeBook(bookTitle, bookAuthor);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean getBook(String bookName) {
		Library schoolLibrary = Library.getInstance();
		int booksWithBookName = schoolLibrary.numberOfBooksWithTheSameTitle(bookName);
		if(booksWithBookName == 1) {
			for(int i = 0; i < books.length; i++) {
				if(books[i] == null) {
					//trqbva da se doopravi
					//books[i] = schoolLibrary.getBook(bookTitle, bookAuthor);
					//schoolLibrary.removeBook(bookTitle, bookAuthor);
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
}
