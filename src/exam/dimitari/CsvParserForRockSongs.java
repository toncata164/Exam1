package exam.dimitari;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import sun.nio.cs.StandardCharsets;

public class CsvParserForRockSongs {
	
	public static List<RockSongs> parse(String filePath){
		List<RockSongs> rockSongs = new ArrayList();
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath), java.nio.charset.StandardCharsets.UTF_8);
			lines.remove(0);
			for(String line:lines) {
				String[] args = line.split(",");
				String song = args[0];
				String artist = args[1];
				int year = Integer.parseInt(args[2]);
				String combined = args[3];
				int isItFirst = Integer.parseInt(args[4]);
				int doesItHaveYear = Integer.parseInt(args[5]);
				int count = Integer.parseInt(args[6]);
				int F_G = Integer.parseInt(args[7]);
				
				RockSongs songs = new RockSongs(song,artist,year,combined,isItFirst,doesItHaveYear,count,F_G);
				rockSongs.add(songs);
			}
		}
		catch(Exception e) {
			
		}
		return rockSongs;
		
	}

}
