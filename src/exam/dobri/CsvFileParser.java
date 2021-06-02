package exam.dobri;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileParser
{
	public static List<SongInfo> parseFile(String path)
	{
		List<SongInfo> songs = new ArrayList<>();
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			lines.remove(0);
			for(String line : lines)
			{
				
				line.replaceAll(", ", "{");
				
				String[] args = line.split(",");
				SongInfo song = new SongInfo();
				song.setSchoolName(args[0]);
				song.setConference(args[1]);
				song.setSongName(args[2]);
				song.setWriters(args[3]);
				song.setYear(args[4]);
				song.setStudentWriter(args[5]);
				song.setOfficialSong(args[6]);
				song.setContest(args[7]);
				song.setBpm(Integer.parseInt(args[8]));
				song.setSecDuration(Integer.parseInt(args[9]));
				song.setFight(args[10]);
				song.setNumberFights(Integer.parseInt(args[11]));
				song.setVictory(args[12]);
				song.setWinWon(args[13]);
				song.setVictoryWinWon(args[14]);
				song.setRah(args[15]);
				song.setNonsense(args[16]);
				song.setColors(args[17]);
				song.setMen(args[18]);
				song.setOpponents(args[19]);
				song.setSpelling(args[20]);
				song.setTropeCount(Integer.parseInt(args[21]));
				song.setSpotifyId(args[22]);
				songs.add(song);
			}
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return songs;
		
	}
}
