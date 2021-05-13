package exam.dimitard;

public class Profile {
	private String name;
	private boolean isMan;
	private String race;
	private Date date;
	private String state;
	private String cause;
	private int age;
	
	public Profile (String name, boolean isMan, String race, Date date, String state, String cause, String age) {
		this.name = name;
		this.isMan = isMan;
		this.race = race;
		this.date = date;
		this.state = state;
		this.cause = cause;
		if(!age.equals("Unknown")) {
			this.setAge(Integer.parseInt(age));
		} 
		else {
			this.age=-1;
		}
	}
	
	public boolean getIsMan() {
		return isMan;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMan() {
		return isMan;
	}
	public void setMan(boolean isMan) {
		this.isMan = isMan;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
