package testStream;

public class Information 
{
	String name;
	int age;
	String gender;
	String receethnicity;
	String month;
	int day;
	int year;
	String city;
	
	public Information(String name, int age, String gender, String receethnicity, 
			String month, int day, int year, String city) 
	{
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.receethnicity = receethnicity;
		this.month = month;
		this.day = day;
		this.year = year;
		this.city = city;
	}
	
	public String toString()
	{
		String toReturn = String.format("%s %d %s %s %s %d %d %s", name, age, gender, receethnicity, month, day, year, city); 
		return toReturn;
	}
}
