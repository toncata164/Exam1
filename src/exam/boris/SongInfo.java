package exam.boris;

public class SongInfo {
	private String name;
	private String writers;
	private int year;
	private boolean nonsense;
	private int writersCount;
	private int sec_duration;
	
	public SongInfo(String name, String writers, int year, boolean nonsense, int writersCount, int sec_duration) 
	{
		setName(name);
		setWriters(writers);
		setYear(year);
		setNonsense(nonsense);
		setWritersCount(writersCount);
		setSec_duration(sec_duration);
	}
	public SongInfo(String name, String writers, int writersCount) 
	{
		setName(name);
		setWriters(writers);
		setWritersCount(writersCount);
		setYear(-1);
		setNonsense(false);
		setSec_duration(-1);
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
	public boolean isNonsense() {
		return nonsense;
	}
	public void setNonsense(boolean nonsense) {
		this.nonsense = nonsense;
	}
	public int getWritersCount() {
		return writersCount;
	}
	public void setWritersCount(int writersCount) {
		this.writersCount = writersCount;
	}
	public int getSec_duration() {
		return sec_duration;
	}
	public void setSec_duration(int sec_duration) {
		this.sec_duration = sec_duration;
	}

}
