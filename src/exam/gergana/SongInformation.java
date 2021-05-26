package exam.gergana;

import java.util.HashMap;

public class SongInformation
{
	private String song;
	private String artist;
	private int year;
	private int playCount;
	
	public SongInformation(String song, String artist, int year, int playCount) {
		
		this.song = song;
		this.artist = artist;
		this.year = year;
		this.playCount = playCount;
	}
	
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
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
	
	public static boolean countLetters(String s1)
	{
		s1 = s1.toLowerCase();
	
		int counter = 0;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int s1Index = 0; s1Index < s1.length(); s1Index++)
		{
			char key = s1.charAt(s1Index);
			if(map.containsKey(key))
			{
				int newV = map.get(key) + 1;
				map.put(key, newV);
				
			}
			else 
				map.put(key, 1);
		}
		
		for(char k : map.keySet())
		{
			if (map.get(k) > 3 && k != ' ')
				return true;
		}
		
		return false;
	}
}
