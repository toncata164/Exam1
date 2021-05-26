package exam.alexander;

public class ClassicRockSongList 
{
	private String nameOfTheSong;
	private String nameOfTheArtist;
	private String releaseYear;
	private String combined;
	private String first;
	private int year;
	private int playCount;
	private int numberOfPlaysOfTheSongAcrossAllStations;
	
	public String getNameOfTheSong() {
		return nameOfTheSong;
	}
	public void setNameOfTheSong(String nameOfTheSong) {
		this.nameOfTheSong = nameOfTheSong;
	}
	public String getNameOfTheArtist() {
		return nameOfTheArtist;
	}
	public void setNameOfTheArtist(String nameOfTheArtist) {
		if(nameOfTheArtist.contains(","))
		{
			nameOfTheArtist.replaceAll(",", "");
			this.nameOfTheArtist = nameOfTheArtist;
		}
		this.nameOfTheArtist = nameOfTheArtist;
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
		if(combined.contains(","))
		{
			combined.replaceAll(",", "");
			this.combined = combined;
		}
		this.combined = combined;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first = "1";
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
	public int getNumberOfPlaysOfTheSongAcrossAllStations() {
		return numberOfPlaysOfTheSongAcrossAllStations;
	}
	public void setNumberOfPlaysOfTheSongAcrossAllStations(int numberOfPlaysOfTheSongAcrossAllStations) {
		this.numberOfPlaysOfTheSongAcrossAllStations = numberOfPlaysOfTheSongAcrossAllStations;
	}
	
	

}
