package exam.dimitard;

public class Date {
	private int month;
	private int day;
	private int year;
	
	public Date(String month, int day, int year) {
		this.month = monthChange(month);
		this.day = day;
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(String month) {
		
		this.month = monthChange(month);
		
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
	
	public int monthChange(String month) {
		if(month.equals("January")) {
			return 1;
		}
		else if(month.equals("February")) {
			return 2;
		}
		else if(month.equals("March")) {
			return 3;
		}
		else if(month.equals("April")) {
			return 4;
		}
		else if(month.equals("May")) {
			return 5;
		}
		else {
			return 6;
		}
		
	}
}
