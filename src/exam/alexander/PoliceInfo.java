package exam.alexander;

public class PoliceInfo 
{
	private String name;
	private int age;
	private String gender;
	private String raceEthnicity;
	private String month;
	private int day;
	private int year;
	private String streetAddress;
	private String city;
	
	public PoliceInfo(String name, int age, String gender, String raceEthnicity, String month, int day, int year, String city) 
	{
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.raceEthnicity = raceEthnicity;
		this.month = month;
		this.day = day;
		this.year = year;
		this.city = city;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public String getRaceEthnicity() 
	{
		return raceEthnicity;
	}
	public void setRaceEthnicity(String raceEthnicity) 
	{
		this.raceEthnicity = raceEthnicity;
	}
	
	public String getMonth() 
	{
		return month;
	}
	public void setMonth(String month) 
	{
		this.month = month;
	}
	public int getDay() 
	{
		return day;
	}
	public void setDay(int day) 
	{
		this.day = day;
	}
	public int getYear() 
	{
		return year;
	}
	public void setYear(int year) 
	{
		this.year = year;
	}
	public String getStreetAddress() 
	{
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) 
	{
		this.streetAddress = streetAddress;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	
}
