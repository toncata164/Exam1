package exam.ekaterina;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	
	private String school;
	private String conference;
	private String song_name;
	private String writers;
	private int year;
	private String student_writer;
	private String official_song;
	private String contest;
	private String bpm;
	private String sec_duration;
	private String fight;
	private int number_fights;
	private String victory;
	private int win_won;
	private String victory_win_won;
	private String rah;
	private String nonsense;
	private String colors;
	private String men;
	private String opponents;
	private String spelling;
	private String trope_count;
	private String spotify_id;
	
	public static List<Song> parse(String filePath){
	
		List<Song> song = new ArrayList();
	{
	try
	{
		List<String> readLines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
		readLines.remove(0);
		
		for(String line:readLines)
		{
			try {
			String[] args = line.split(",");
			
			
			String school = args[0];
			String conference = args[1];
			String song_name = args[2];
			String writers = args[3];
			int year = Integer.parseInt(args[4]);
			String student_writer = args[5];
			String official_song = args[6];
			String contest = args[7];
			String bpm = args[8];
			String sec_duration = args[9];
			String fight = args[10];
			int number_fights = Integer.parseInt(args[11]);
			String victory = args[12];
			int win_won = Integer.parseInt(args[13]);
			String victory_win_won = args[14];
			String rah = args[15];
			String nonsense = args[16];
			String colors = args[17];
			String men = args[18];
			String opponents = args[19];
			String spelling = args[20];
			String trope_count = args[21];
			String spotify_id = args[22];
			
	
			
			Song info = new Song();
			info.setBpm(bpm);
			info.setColors(colors);
			info.setConference(conference);
			info.setContest(contest);
			info.getFight();
			info.setMen(men);
			info.setNonsense(nonsense);
			info.setNumber_fights(number_fights);
			info.setOfficial_song(official_song);
			info.setOpponents(opponents);
			info.setRah(rah);
			info.setSchool(school);
			info.setSec_duration(sec_duration);
			info.setSong_name(song_name);
			info.setSpelling(spelling);
			info.setSpotify_id(spotify_id);
			info.setStudent_writer(student_writer);
			info.setTrope_count(trope_count);
			info.setVictory(victory_win_won);
			info.setVictory_win_won(victory_win_won);
			info.setWin_won(win_won);
			info.setWriters(writers);
			info.setYear(year);
			
			
			}
		
		catch(IOException e)
		{
			e.printStackTrace();
			return song;
		}
	}
	
	}}}}
	
		




	
	


