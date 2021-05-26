package exam.dobri;

public class RockSongInfo
{
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getCombined() {
		return combined;
	}
	public void setCombined(String combined) {
		this.combined = combined;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	public int getFg() {
		return fg;
	}
	public void setFg(int fg) {
		this.fg = fg;
	}
	
	public static int compareByPlaysThenName(RockSongInfo song1, RockSongInfo song2) {
	    if (song1.getFg() == song2.getFg()) 
		{
	        return song1.getSongName().compareTo(song2.getSongName());
	    } else 
	    {
	        return song1.getSongName().compareTo(song2.getSongName());
	    }
	}
	
	public static boolean contains3Letters(String name)
	{
		//for(int i = 0; i < =name.length();i++)
		
		return false;
	}
	private String songName;
	private String artistName;
	private String releaseYear;
	private String combined;
	private String first;
	private int year;
	private int playCount;
	private int fg;
	
}
