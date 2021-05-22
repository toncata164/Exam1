package exam.denis.streamapi.exercise;

public class PoliceKilling
{
	private String name;
	private int age;
	private Gender gender;
	private String deathType;
	private String raceEthnicity;
	private int month;
	private int day;
	private int year;
	private String city;
	private String state;
	
	public PoliceKilling()
	{
		
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	public String getRaceEthnicity()
	{
		return raceEthnicity;
	}

	public int getMonth()
	{
		return month;
	}

	public int getDay()
	{
		return day;
	}

	public int getYear()
	{
		return year;
	}

	public String getCity()
	{
		return city;
	}

	public String getState()
	{
		return state;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public void setRaceEthnicity(String raceEthnicity)
	{
		this.raceEthnicity = raceEthnicity;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Gender getGender()
	{
		return gender;
	}

	public String getDeathType()
	{
		return deathType;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	public void setDeathType(String deathType)
	{
		this.deathType = deathType;
	}

	public void setState(String state)
	{
		this.state = state;
	}
}
