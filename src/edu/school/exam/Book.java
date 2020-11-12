package edu.school.exam;

public class Book 
{
	private static final String DEFAULT_FIELD_VALUE = "N/A";
	
	private String title;
	private String author;
	private String publisher;
	private String isbn;
	
	public Book()
	{
		this.title = DEFAULT_FIELD_VALUE;
		this.author = DEFAULT_FIELD_VALUE;
		this.publisher = DEFAULT_FIELD_VALUE;
		this.isbn = DEFAULT_FIELD_VALUE;
	}
	
	public Book(String title, String author, String publisher, String isbn)
	{
		this();
		
		boolean areParametersInvalid = Validator.isNullOrEmpty(title) ||
					Validator.isNullOrEmpty(author) ||
					Validator.isNullOrEmpty(publisher) ||
					Validator.isNullOrEmpty(isbn);
		
		if (!areParametersInvalid)
		{
			this.title = title;
			this.author = author;
			this.publisher = publisher;
			this.isbn = isbn;
		}
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	public String getPublisher()
	{
		return this.publisher;
	}
	
	public String getIsbn()
	{
		return this.isbn;
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
		
		return bookInfo.toString();
	}
}
