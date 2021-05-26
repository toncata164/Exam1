package exam.dimitard;

public class Song {
	private String songName;
	private String author;
	private int releaseYear;
	private String allData;
	private int timesPlayed;
	
	public Song (String songName, String author, int releaseYear,
			String allData, int timesPlayed) {
		this.songName=songName;
		this.author=author;
		this.releaseYear=releaseYear;
		this.allData=allData;
		this.timesPlayed=timesPlayed;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getAllData() {
		return allData;
	}

	public void setAllData(String allData) {
		this.allData = allData;
	}

	public int getTimesPlayed() {
		return timesPlayed;
	}

	public void setTimesPlayed(int timesPlayed) {
		this.timesPlayed = timesPlayed;
	}
	
	
}
