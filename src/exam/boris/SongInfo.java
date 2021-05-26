package exam.boris;

public class SongInfo {
	private String songClean;
	private String artistClean;
	private int releaseYear;
	private String combined;
	private int playCount;
	
	public SongInfo(String songClean, int releaseYear, String combined,
			int playCount) 
	{
		setSongClean(songClean);
		setReleaseYear(releaseYear);
		setCombined(combined);
		setPlayCount(playCount);
	}
	public SongInfo(String songClean, String artistClean, int releaseYear, String combined,
			int playCount) 
	{
		setSongClean(songClean);
		setArtistClean(artistClean);
		setReleaseYear(releaseYear);
		setCombined(combined);
		setPlayCount(playCount);
	}
	public String getSongClean() {
		return songClean;
	}
	public void setSongClean(String songClean) {
		this.songClean = songClean;
	}
	public String getArtistClean() {
		return artistClean;
	}
	public void setArtistClean(String artistClean) {
		this.artistClean = artistClean;
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
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	

}
