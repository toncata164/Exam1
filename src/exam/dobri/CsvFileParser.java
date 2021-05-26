package exam.dobri;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileParser
{
	public static List<RockSongInfo> parse(String path)
	{
		
		List<RockSongInfo> rockSongs = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			lines.remove(0);
			for(String line : lines)
			{
				RockSongInfo rockSong = new RockSongInfo();
				
				
				int comasCount = 0;
				for(int i = 0; i < line.length(); i++)
				{
					if(line.charAt(i) == ',')
						comasCount++;
				}
				if(comasCount == 7)
				{	
				String[] args = line.split(",");
				rockSong.setSongName(args[0]);
				rockSong.setArtistName(args[1]);
				rockSong.setReleaseYear(args[2]);
				rockSong.setCombined(args[3]);
				rockSong.setFirst(args[4]);
				rockSong.setYear(Integer.parseInt(args[5]));
				rockSong.setPlayCount(Integer.parseInt(args[6]));
				rockSong.setFg(Integer.parseInt(args[7]));
				rockSongs.add(rockSong);
				}
				else
				{
				line.replaceAll(", ", "{}");
				line.replaceAll(",,", ", ,");
				String[] args = line.split(",");
				rockSong.setSongName(args[0]);
				rockSong.setArtistName(args[1]);
				rockSong.setReleaseYear(args[2]);
				rockSong.setCombined(args[3]);
				rockSong.setFirst(args[4]);
				rockSong.setYear(Integer.parseInt(args[5]));
				rockSong.setPlayCount(Integer.parseInt(args[6]));
				rockSong.setFg(Integer.parseInt(args[7]));
				rockSongs.add(rockSong);
				}
			}
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return rockSongs;
	}
}
