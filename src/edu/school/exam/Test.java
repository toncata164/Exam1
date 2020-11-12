package edu.school.exam;

public class Test 
{
	public static void main(String[] args) 
	{
		Book emptyBook = new Book();
		
		Book harryPotter = new Book("Harry Potter", "J.K. Rowling", 
									"Bloomsbury Publishing", "9780545010221");
		
		ReaderProfile someProfile = new ReaderProfile("Ivan", "Ivanov", 10, 'A', "0888711312");
		
		ReaderProfile profileWithBooks = new ReaderProfile("Stefan", "Petrov", 9, 'G', "0878322077", 
				new Book[] { harryPotter, emptyBook});
		
		System.out.println(emptyBook);
		System.out.println();
		System.out.println(harryPotter);
		System.out.println();
		System.out.println(someProfile);
		System.out.println();
		System.out.println(profileWithBooks);
	}
}
