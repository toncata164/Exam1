package edu.school.exam;

public class Library {
	private int numberOfBooks;
	private  Book [] books;
	private static Library library;
	
	
	public int getNumberOfBooks () {
		return numberOfBooks;
	}
	
	private Library () {
		numberOfBooks=0;
		books = new Book [10];
		
		
	}
	
	public static Library getInstance() {
		
		
		if(library==null) {
			library= new Library ();
			
		}
		return library;
	}
	
	public void addBook(Book newbook) {
		if(numberOfBooks<books.length) {
		books[numberOfBooks] = newbook;
		numberOfBooks+=1;
		}
		else {
			books=addBooksInLibrary();
			books[numberOfBooks] = newbook;
			numberOfBooks+=1;
		}
	}
	public void addBook(String title, String author, String publishers, String isbn) {
		Book newbook = new Book (title,author,publishers,isbn);
		addBook(newbook);
		
	}
	public Book [] addBooksInLibrary () {
		Book [] temp = new Book [books.length*2];
		for(int i = 0; i < books.length;i++) {
			temp[i]=books[i];
		}
		return temp;
	}
}
