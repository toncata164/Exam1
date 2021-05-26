package exam.dimitari;

public class RockSongs {
	
	private String song;
	private String artist;
	private int releaseYear;
	private String combined;
	private int isItFirst;
	private int doesItHaveYear;
	private int count;
	private int F_G;
	
	
	public RockSongs(String song, String artist, int releaseYear, String combined, int isItFirst, int doesItHaveYear, int count, int F_G) {
		this.song = song;
		this.artist = artist;
		this.releaseYear = releaseYear;
		this.combined = combined;
		this.isItFirst = isItFirst;
		this.doesItHaveYear = doesItHaveYear;
		this.count = count;
		this.F_G = F_G;
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


	public int getReleaseYear() {
		return releaseYear;
	}


	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}


	public String getCombined() {
		return combined;
	}


	public void setCombined(String combined) {
		this.combined = combined;
	}


	public int getIsItFirst() {
		return isItFirst;
	}


	public void setIsItFirst(int isItFirst) {
		this.isItFirst = isItFirst;
	}


	public int getDoesItHaveYear() {
		return doesItHaveYear;
	}


	public void setDoesItHaveYear(int doesItHaveYear) {
		this.doesItHaveYear = doesItHaveYear;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getF_G() {
		return F_G;
	}


	public void setF_G(int f_G) {
		F_G = f_G;
	}

	
	
	
	
	
	

}
