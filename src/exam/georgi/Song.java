package exam.georgi;

public class Song
{
	private String name;
	private String artist;
	private int releaseYear;
	private int playCount;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public void setArtist(String artist)
	{
		this.artist = artist;
	}
	
	public int getReleaseYear()
	{
		return releaseYear;
	}
	
	public void setReleaseYear(int releaseYear)
	{
		this.releaseYear = releaseYear;
	}
	
	public int getPlayCount()
	{
		return playCount;
	}
	
	public void setPlayCount(int playCount)
	{
		this.playCount = playCount;
	}
	
	public String toString()
	{
		return getName() + ", by " + getArtist();
	}
}
