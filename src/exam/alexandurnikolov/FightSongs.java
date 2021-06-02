package exam.alexandurnikolov;

public class FightSongs 
{
	private String songTitle;
	private String songAuthor;
	private int year;
	private int secDuration;
	
	public int getSecDuration() {
		return secDuration;
	}
	public void setSecDuration(int secDuration) {
		this.secDuration = secDuration;
	}
	public String getSongTitle() 
	{
		return songTitle;
	}
	public void setSongTitle(String songTitle) 
	{
		if(songTitle.contains(", "))
		{
			songTitle.replaceAll(", ", " ");
			this.songTitle = songTitle;
		}
		//this.songTitle = songTitle;
	}
	public String getSongAuthor() 
	{
		return songAuthor;
	}
	public void setSongAuthor(String songAuthor) 
	{
		if(songAuthor.contains(","))
		{
			songAuthor.replaceAll(",", " ");
			this.songAuthor = songAuthor;
		}
	}
	public int getYear() 
	{
		return year;
	}
	public void setYear(int year) 
	{
		this.year = year;
	}
	
}
