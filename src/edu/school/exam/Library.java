package edu.school.exam;

public class Library {
	private int numberOfBooks;
	private Book[] books;
	private static Library library;

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	private Library() {
		numberOfBooks = 0;
		books = new Book[10];

	}

	public static Library getInstance() {

		if (library == null) {
			library = new Library();

		}
		return library;
	}

	public void addBook(Book newbook) {
		if (numberOfBooks < books.length) {
			books[numberOfBooks] = newbook;
			numberOfBooks += 1;
		} else {
			books = addBooksInLibrary();
			books[numberOfBooks] = newbook;
			numberOfBooks += 1;
		}
	}

	public void addBook(String title, String author, String publishers, String isbn) {
		Book newbook = new Book(title, author, publishers, isbn);
		addBook(newbook);
	}

	public Book[] addBooksInLibrary() {
		Book[] temp = new Book[books.length * 2];
		for (int i = 0; i < books.length; i++) {
			temp[i] = books[i];
		}
		return temp;
	}

	public void removeBook(String title, String author) {
		for (int i = 0; i < numberOfBooks; i++) {
			String currentBookTitle = books[i].getTitle();
			String currentBookAuthor = books[i].getAuthor();
			if (currentBookTitle.equals(title) && currentBookAuthor.equals(author)) {
				for (int j = i + 1; j < numberOfBooks; j++) {
					books[j] = books[j - 1];
					books[numberOfBooks - 1] = null;
					numberOfBooks--;
				}
				break;
			}
		}
	}
	
	public void removeBooks()
	{
		for(int i = 0; i < books.length; i++)
		{
			books[i] = null;
		}
		numberOfBooks = 0;
	}

	// Search for a book by title and author
	public boolean hasBook(String title, String author) {
		return getBook(title, author) != null;
	}
	
	
	
	// Returns all books by an author in the library
	public Book[] getAllBooksByAuthor(String author) {
		Book[] authorBook = new Book[books.length];
		int booksCount=0;
		
		for (int i = 0; i < numberOfBooks; i++) {
			if (author.equals(books[i].getAuthor())) {
				authorBook[booksCount] = books[i];
				booksCount++;
			}
		}
		Book[] authorBooksCopy = new Book[booksCount];
		for (int i = 0; i < authorBooksCopy.length; i++) {
			authorBooksCopy[i] = authorBook[i];
		}
		
		return authorBooksCopy;
		
	}
	//Sorts all books in a library by a given boolean(accending or not)
	public void sortBooksByTitle(boolean asc) {
		
		if (asc == true) {
			for (int i = 0; i < numberOfBooks; i++) {
				for (int j = 0; j < numberOfBooks; j++) {
										
					if (books[i].getTitle().compareTo(books[j].getTitle())>0) {
						Book temp = books[i];
						books[i] = books[j];
						books[j] = temp;
						
					}
				}
			}
		}
		
	}
	

	// If a book with this title and author exists, return it, else return null
	public Book getBook(String title, String author) {
		for (int i = 0; i < this.numberOfBooks; i++) {
			if (this.books[i].getTitle().equals(title) && this.books[i].getAuthor().equals(author)) {
				return books[i];
			}
		}

		return null;
	}

	// Return the first book with this tile, if it doesn't exists, return null
	public Book getBook(String title) {
		for (int i = 0; i < this.numberOfBooks; i++) {
			if (this.books[i].getTitle().equals(title)) {
				return books[i];
			}
		}

		return null;
	}

	int numberOfBooksWithTheSameTitle(String bookTitle) {
		int countBooksWithTheSameTitle = 0;
		for (int i = 0; i < numberOfBooks; i++) {
			String currentBookTitle = books[i].getTitle();
			if (currentBookTitle.equals(bookTitle)) {
				countBooksWithTheSameTitle++;
			}
		}
		return countBooksWithTheSameTitle;
	}

	public Book[] getAllBooksOfPublishers(String publishers)
	{
		int resultSize = 0;
		for (int i = 0; i < this.numberOfBooks; i++)
		{
			if (this.books[i].getPublisher().equals(publishers))
			{
				resultSize++;
			}
		}

		Book[] result = new Book[resultSize];

		int index = 0;

		for (int i = 0; i < this.numberOfBooks; i++)
		{
			if (this.books[i].getPublisher().equals(publishers))
			{
				result[index++] = books[i];
			}
		}

		return result;
	}
	
	public void sortByAuthor(boolean asc)
	{
		
		
		if(asc == true)
		{
			Book firstBook = books[0]; 
			for(int i = 0; i< numberOfBooks; i++)
			{
				for(int j = 0; j< numberOfBooks; j++)
				{
					if(books[i].getAuthor().compareTo(books[j].getAuthor())<0)
					{
						Book swapBooks = books[j];
						books[j] = books[i];
						books[i] = swapBooks;
					}
				}
			}
		}
		else
		{
			Book lastBook = books[0]; 
			for(int i = 0; i< numberOfBooks; i++)
			{
				for(int j = 0; j< numberOfBooks; j++)
				{
					if(books[i].getAuthor().compareTo(books[j].getAuthor())>0)
					{
						Book swapBooks = books[j];
						books[j] = books[i];
						books[i] = swapBooks;
					}
				}
			}
		}
	}
	
	Book getBookAtIndex(int index)
	{
		return books[index];
	}
	
	public String getAuthorByTitle(String title)
	{
		int countTitle=0;
        for(int i=0;i<numberOfBooks;i++) {
			if(books[i].getAuthor().equals(title)) {
				countTitle++;
			}
		}
        if(countTitle!=1) {
        	return null;
        }
		for(int i = 0; i< numberOfBooks; i++)
		{
		  if(books[i].getAuthor().equals(title)) {
			  return books[i].getAuthor();
			  
		  }
		}
		
		
		return null;
	}
	
	public void printBooks() {
		for(int i=0;i<numberOfBooks;i++) {
			System.out.println(books[i].toString());
		}
		
	}
	
	
}
