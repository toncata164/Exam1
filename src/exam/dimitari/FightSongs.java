package exam.dimitari;

public class FightSongs {
	private String school;
	private String conference;
	private String songName;
	private String writers;
	private int year;
	private String studentWriter;
	private String officialSong;
	private String contest;
	private int bpn;
	private int sec_duration;
	private String fight;
	private int song_number_fights;
	private String song_victory;
	private String song_win_won;
	private String song_rah;
	private String song_nonsence;
	private String song_colors;
	private String song_men;
	private String song_oponents;
	private String song_spelling;
	private int tropeCount;
	private String spotify_id;
	public FightSongs(String school, String conference, String songName, String writers, int year, String studentWriter,
			String officialSong, String contest, int bpn, int sec_duration, String fight, int song_number_fights,
			String song_victory, String song_win_won, String song_rah, String song_nonsence, String song_colors,
			String song_men, String song_oponents, String song_spelling, int tropeCount, String spotify_id) {
		super();
		this.school = school;
		this.conference = conference;
		this.songName = songName;
		this.writers = writers;
		this.year = year;
		this.studentWriter = studentWriter;
		this.officialSong = officialSong;
		this.contest = contest;
		this.bpn = bpn;
		this.sec_duration = sec_duration;
		this.fight = fight;
		this.song_number_fights = song_number_fights;
		this.song_victory = song_victory;
		this.song_win_won = song_win_won;
		this.song_rah = song_rah;
		this.song_nonsence = song_nonsence;
		this.song_colors = song_colors;
		this.song_men = song_men;
		this.song_oponents = song_oponents;
		this.song_spelling = song_spelling;
		this.tropeCount = tropeCount;
		this.spotify_id = spotify_id;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getConference() {
		return conference;
	}
	public void setConference(String conference) {
		this.conference = conference;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		if(songName.contains(",")) {
			songName.replace(",", " ");
		}
		this.songName = songName;
	}
	public String getWriters() {
		return writers;
	}
	public void setWriters(String writers) {
		if(writers.contains(",")) {
			writers.replace(",", " ");
		}
		this.writers = writers;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getStudentWriter() {
		return studentWriter;
	}
	public void setStudentWriter(String studentWriter) {
		this.studentWriter = studentWriter;
	}
	public String getOfficialSong() {
		return officialSong;
	}
	public void setOfficialSong(String officialSong) {
		this.officialSong = officialSong;
	}
	public String getContest() {
		return contest;
	}
	public void setContest(String contest) {
		this.contest = contest;
	}
	public int getBpn() {
		return bpn;
	}
	public void setBpn(int bpn) {
		this.bpn = bpn;
	}
	public int getSec_duration() {
		return sec_duration;
	}
	public void setSec_duration(int sec_duration) {
		this.sec_duration = sec_duration;
	}
	public String getFight() {
		return fight;
	}
	public void setFight(String fight) {
		this.fight = fight;
	}
	public int getSong_number_fights() {
		return song_number_fights;
	}
	public void setSong_number_fights(int song_number_fights) {
		this.song_number_fights = song_number_fights;
	}
	public String getSong_victory() {
		return song_victory;
	}
	public void setSong_victory(String song_victory) {
		this.song_victory = song_victory;
	}
	public String getSong_win_won() {
		return song_win_won;
	}
	public void setSong_win_won(String song_win_won) {
		this.song_win_won = song_win_won;
	}
	public String getSong_rah() {
		return song_rah;
	}
	public void setSong_rah(String song_rah) {
		this.song_rah = song_rah;
	}
	public String getSong_nonsence() {
		return song_nonsence;
	}
	public void setSong_nonsence(String song_nonsence) {
		this.song_nonsence = song_nonsence;
	}
	public String getSong_colors() {
		return song_colors;
	}
	public void setSong_colors(String song_colors) {
		this.song_colors = song_colors;
	}
	public String getSong_men() {
		return song_men;
	}
	public void setSong_men(String song_men) {
		this.song_men = song_men;
	}
	public String getSong_oponents() {
		return song_oponents;
	}
	public void setSong_oponents(String song_oponents) {
		this.song_oponents = song_oponents;
	}
	public String getSong_spelling() {
		return song_spelling;
	}
	public void setSong_spelling(String song_spelling) {
		this.song_spelling = song_spelling;
	}
	public int getTropeCount() {
		return tropeCount;
	}
	public void setTropeCount(int tropeCount) {
		this.tropeCount = tropeCount;
	}
	public String getSpotify_id() {
		return spotify_id;
	}
	public void setSpotify_id(String spotify_id) {
		this.spotify_id = spotify_id;
	}
	
	
	
	
	
	
	
	
	

}
