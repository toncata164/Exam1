package exam.yova;

public class PoliceKillingsInfo 
{
	private String name;
	private int age;
	private boolean male; //in case m and f are the only options; if not, create gender enum
	private String race;
	private int day;
	private String month;
	private int year;
	private String streetAddress;
	private String city;
	private String state;
	
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
	
	public boolean isMale() 
	{
		return male;
	}
	
	public void setMale(boolean male) 
	{
		this.male = male;
	}
	
	public String getRace() 
	{
		return race;
	}
	
	public void setRace(String race) 
	{
		this.race = race;
	}
	
	public int getDay() 
	{
		return day;
	}
	
	public void setDay(int day) 
	{
		this.day = day;
	}
	
	public String getMonth() 
	{
		return month;
	}
	
	public void setMonth(String month) 
	{
		this.month = month;
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
	
	public String getState() 
	{
		return state;
	}
	
	public void setState(String state) 
	{
		this.state = state;
	}
	
	public PoliceKillingsInfo(String name, int age, boolean male, String race, int day,
			String month, int year, String streetAddress, String city, String state)
	{
		this.setName(name);
		this.setAge(age);
		this.setMale(male);
		this.setRace(race);
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
		this.setStreetAddress(streetAddress);
		this.setCity(city);
		this.setState(state);
	}
	
	public PoliceKillingsInfo() //I don't know if I'll need it, but just in case
	{
		this(null, 0, true, null, 1, null, 1, null, null, null);
	}
	
}
