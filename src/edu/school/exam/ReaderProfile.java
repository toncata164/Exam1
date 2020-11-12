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
		}
		
	}
	
	public String toString() {
		return "Name: " + getName() + "\n" + "Surname: " + getSurname() + "\n" + "Grade: " + getGrade() + "\n" ;
			
	}
}
