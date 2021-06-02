package exam.dimitard;

public class Song {
	private String name;
	private String writers;
	private int year;
	private boolean win_won;
	private int duration;
	
	public Song (String name, String writers, int year, boolean win_won, int duration) {
		this.name = name;
		this.writers = writers;
		this.year = year;
		this.win_won = win_won;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriters() {
		return writers;
	}

	public void setWriters(String writers) {
		this.writers = writers;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isWin_won() {
		return win_won;
	}

	public void setWin_won(boolean win_won) {
		this.win_won = win_won;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
