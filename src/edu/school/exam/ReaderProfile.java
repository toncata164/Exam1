package edu.school.exam;

public class ReaderProfile 
{
	private static final int MIN_GRADE = 1;
	private static final int MAX_GRADE = 12;
	private static final char MIN_MAJOR = 'a';
	private static final char MAX_MAJOR = 'i';
	private static final int DEFAULT_BOOKS_LENGTH = 0;
	
	private String name;
	private String surname;
	private int grade;
	private char major;
	private String phoneNumber;
	private Book[] books;

	
	public ReaderProfile(String name, String surname, int grade, char major, String phoneNumber) 
	{
		this(name, surname, grade, major, phoneNumber, new Book[DEFAULT_BOOKS_LENGTH]);
	}
	
	public ReaderProfile(String name, String surname, int grade, char major, String phoneNumber, 
			Book[] books)
	{
		this.setName(name);
		this.setSurname(surname);
		this.setGrade(grade);
		this.setMajor(major);
		this.setPhoneNumber(phoneNumber);
		this.setBooks(books);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	private void setName(String name)
	{
		if (!Validator.isNullOrEmpty(name))
		{
			this.name = name;
		}
	}
	
	public String getSurname()
	{
		return this.surname;
	}
	
	private void setSurname(String surname)
	{
		if (!Validator.isNullOrEmpty(surname))
		{
			this.surname = surname;
		}
	}
	
	public int getGrade()
	{
		return this.grade;
	}
	
	public void setGrade(int grade)
	{
		if (Validator.isInRange(grade, MIN_GRADE, MAX_GRADE))
		{
			this.grade = grade;			
		}
	}
	
	public char getMajor() 
	{
		return this.major;
	}
	
	public void setMajor(char major)
	{
		char lowercase = Character.toString(major).toLowerCase().charAt(0);
			
		if (Validator.isInRange(lowercase, MIN_MAJOR, MAX_MAJOR))
		{
			this.major = major;			
		}
	}
	
	public String getPhoneNumber() 
	{
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) 
	{	
		if (!Validator.isNullOrEmpty(phoneNumber))
		{
			this.phoneNumber = phoneNumber;
		}
		
		// TODO: Add REGEX validation
	}
	
	public Book[] getBooks() 
	{
		return this.books;
	}
	
	private void setBooks(Book[] books)
	{
		if (!Validator.isNull(books))
		{
			this.books = books;
		}
	}
	
	public String toString() 
	{ 
		StringBuilder profileInfo = new StringBuilder();
		
		String appendFormat = "%s: %s\n";
		
		profileInfo.append(String.format
				(appendFormat, "Name", this.getName()));
		
		profileInfo.append(String.format
				(appendFormat, "Surname", this.getSurname()));
		
		profileInfo.append(String.format
				(appendFormat, "Grade", this.getGrade()));
		
		profileInfo.append(String.format
				(appendFormat, "Major", this.getMajor()));
		
		profileInfo.append(String.format
				(appendFormat, "Phone number", this.getPhoneNumber()));
		
		profileInfo.append(String.format
				(appendFormat, "Books", this.getBooks().length));
		
		return profileInfo.toString().trim();
	}
}
