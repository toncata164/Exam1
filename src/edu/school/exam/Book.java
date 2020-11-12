package edu.school.exam;

public class Book 
{
	private static final String NOT_AVAILABLE = "N/A";
	
	private String title;
	private String author;
	private String publisher;
	private String isbn;
	
	public Book()
	{
		this(NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE, NOT_AVAILABLE);
	}
	
	public Book(String title, String author, String publisher, String isbn)
	{
		this.setTitle(title);
		this.setAuthor(author);
		this.setPublisher(publisher);
		this.setIsbn(isbn);
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	private void setTitle(String title)
	{
		if (!Validator.isNullOrEmpty(title))
		{
			this.title = title;
		}
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	private void setAuthor(String author)
	{
		if (!Validator.isNullOrEmpty(author))
		{
			this.author = author;
		}
	}
	
	public String getPublisher()
	{
		return this.publisher;
	}
	
	private void setPublisher(String publisher)
	{
		if (!Validator.isNullOrEmpty(publisher))
		{
			this.publisher = publisher;
		}
	}
	
	public String getIsbn()
	{
		return this.isbn;
	}
	
	private void setIsbn(String isbn)
	{
		if (!Validator.isNullOrEmpty(isbn))
		{
			this.isbn = isbn;
		}
	}
	
	public String toString()
	{
		StringBuilder bookInfo = new StringBuilder();
		
		String appendFormat = "%s: %s\n";
		
		bookInfo.append(String.format
				(appendFormat, "Title", this.getTitle()));
		
		bookInfo.append(String.format
				(appendFormat, "Author", this.getAuthor()));
		
		bookInfo.append(String.format
				(appendFormat, "Publisher", this.getPublisher()));
		
		bookInfo.append(String.format
				(appendFormat, "ISBN", this.getIsbn()));
		
		return bookInfo.toString().trim();
	}
}
