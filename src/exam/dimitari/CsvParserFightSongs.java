package exam.dimitari;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;;

public class CsvParserFightSongs {
	
	public static List<FightSongs> parseFile(String filePath){
		
		List<FightSongs> fightSongs = new ArrayList();
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			
			for(String line:lines) {
				String[] args = line.split(",");
				String schoolName = args[0];
				String conference = args[1];
				String songName = args[2];
				String wirters = args[3];
				int year = Integer.parseInt(args[4]);
				String studentWriter = args[5];
				String officialSong = args[6];
				String contest = args[7];
				int bpn = Integer.parseInt(args[8]);
				int sec_diration = Integer.parseInt(args[9]);
				String fight = args[10];
				int song_number_fight = Integer.parseInt(args[11]);
				String song_victory = args[12];
				String song_win_won = args[13];
				String song_rah = args[14];
				String song_nonsense = args[15];
				String song_colors = args[16];
				String song_men = args[17];
				String song_oponents = args[18];
				String song_spelling = args[19];
				int trope_count = Integer.parseInt(args[20]);
				String sptify_id = args[21];
			}
			
			//FightSongs fightSong = new FightSongs(schoolName,conference,songName,wirters,year
				//	,studentWriter,officialSong,contest,bpn,sec_diration,fight,song_number_fight
					//,song_victory,song_win_won,song_rah,song_nonsense,song_colors,song_men
					//,song_oponents,song_spelling,trope_count,sptify_id);
			
			
		}catch(IOException e) {
			
		}
		
		return fightSongs;
		
	}

}
