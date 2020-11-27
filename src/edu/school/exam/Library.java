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
	
	public void removeBook(String title, String author) {
		for(int i = 0; i < numberOfBooks; i++) {
			String currentBookTitle = books[i].getTitle();
			String currentBookAuthor = books[i].getAuthor();
			if(currentBookTitle.equals(title) && currentBookAuthor.equals(author)) {
				for(int j = i + 1; j < numberOfBooks; j++) {
					books[j] = books[j - 1];
					books[numberOfBooks - 1] = null;
					numberOfBooks--;
				}
				break;
			}
		}
	}
	
	public boolean hasBook(String title, String author) {
		//postaveno e, za da ne dava greshki pri metod getBook v ReaderProfile
		//da se dovurshi
		return true;
	}
	
	public Book getBook(String title, String author) {
		//postaveno e, za da ne dava greshki pri metod getBook v ReaderProfile
		//da se dovurshi
		Book newBook = new Book();
		return newBook;
	}
	
	public Book getBook(String title)
	{
		//vrushta puravata sreshnata kniga s tova zaglavie
		Book newBook = new Book();
		return newBook;
	}
	
	 int numberOfBooksWithTheSameTitle(String bookTitle) {
		int countBooksWithTheSameTitle = 0;
		for(int i = 0; i < numberOfBooks; i++) {
			String currentBookTitle = books[i].getTitle();
			if(currentBookTitle.equals(bookTitle)) {
				countBooksWithTheSameTitle++;
			}
		}
		return countBooksWithTheSameTitle;
	}
}
