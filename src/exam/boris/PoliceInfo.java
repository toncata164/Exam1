package exam.boris;

public class PoliceInfo {
	private String name;
	private int age;
	private String gender;
	private String raceethnicity;
	private String month;
	private int day;
	private int year;
	private String city;
	
	public PoliceInfo(String name, int age,String gender, String raceethnicity, 
			String month,int day,int year, String city) 
	{
		setName(name);
		setAge(age);
		setGender(gender);
		setRaceethnicity(raceethnicity);
		setMonth(month);
		setDay(day);
		setYear(year);
		setCity(city);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRaceethnicity() {
		return raceethnicity;
	}
	public void setRaceethnicity(String raceethnicity) {
		this.raceethnicity = raceethnicity;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
