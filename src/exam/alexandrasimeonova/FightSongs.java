package exam.alexandrasimeonova;

public class FightSongs 
{
	private String school;
	private String songName;
	private String songAuthor;
	private String year;
	private String secDuration;
	private String fight;
	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongAuthor() {
		return songAuthor;
	}
	public void setSongAuthor(String songAuthor) {
		if(songAuthor.contains(",") || songAuthor.contains(", "))
		{
			songAuthor.replaceAll(",", ";");
			songAuthor.replaceAll(", ", ";");
			this.songAuthor = songAuthor;
		}
		this.songAuthor = songAuthor;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSecDuration() {
		return secDuration;
	}
	public void setSecDuration(String secDuration) {
		this.secDuration = secDuration;
	}
	public String isFight() {
		return fight;
	}
	public void setFight(String fight) {
		this.fight = fight;
	}
	
	public int getAuthorsCount()
	{
		int count = 1;
		if(this.songAuthor.contains(";"))
		{
			count++;
		}
		if(this.songAuthor.contains("and"))
		{
			count++;
		}
		return count;
	}
	
	
	

}
