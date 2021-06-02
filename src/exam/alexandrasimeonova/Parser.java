package exam.alexandrasimeonova;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser 
{
	public static List<FightSongs> parse(String filePath)
	{
		List<FightSongs> fightSongs = new ArrayList<>();
		
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(filePath),
					StandardCharsets.UTF_8);
			
			lines.remove(0);
			for(String line : lines)
			{
				String[] args = line.split(",");
				
				String school = args[0];
				String songName = args[2];
				String songAuthor = args[3];
				String year = args[4];
				String secDuration = args[9];
				String fight = args[10];
				
				FightSongs info = new FightSongs();
				info.setSchool(school);
				info.setSongName(songName);
				info.setSongAuthor(songAuthor);
				if(args[4].equals("Unknown"))
				{
					info.setYear("-1");
				}
				else
				{
					info.setYear(year);
				}
				info.setSecDuration(secDuration);
				info.setFight(fight);
				
				fightSongs.add(info);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return fightSongs;
	}

}
