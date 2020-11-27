package edu.school.exam;

import java.util.Formatter;

public class Test 
{
	//pozdravi ot katq
	public static void main(String[] args) 
	{
		Book book = new Book("Title", "Denis", "Kushtata na Denis", "AHSJ1DK2SLS");
		System.out.println(book);
		
		Library library = Library.getInstance();
		library.addBook(book);
		
		System.out.println(library.getAllBooksOfPublishers("Kushtata na Denis").length);
	}
}
