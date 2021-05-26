package exam.yova;

public class SongInfo 
{
	private String name;
	private String artist;
	private int releaseYear;
	private boolean foundYear;
	private int playCount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public boolean isFoundYear() {
		return foundYear;
	}
	public void setFoundYear(boolean foundYear) {
		this.foundYear = foundYear;
	}
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	
	public SongInfo(String name, String artist, int releaseYear, int playCount)
	{
		this.setName(name);
		this.setArtist(artist);
		this.setReleaseYear(releaseYear);
		this.setPlayCount(playCount);
	}
	
	public String getSongAndArtist()
	{
		String result = this.getName() + "by " + this.getArtist();
		return result;
	}
	
}
