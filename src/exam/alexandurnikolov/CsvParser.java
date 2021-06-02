package exam.alexandurnikolov;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvParser 
{
	public static List<FightSongs> parse(String filePath)
	{
		List<FightSongs> info = new ArrayList<>();
		
		try 
		{
			
			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			lines.remove(0);
			FightSongs fight = new FightSongs();
			for(String line : lines)
			{
			
				String[] args = line.split(",");
				if(args.length == 23)
				{
					String songName = args[2];
					if(songName.contains(","))
					{
						songName.replaceAll(",", "");
					}
					String songAuthor = args[3];
					if(songAuthor.contains(","))
					{
						songAuthor.replaceAll(",", "");
					}
					String year = (args[4]);
					if(year.equals("Unknown"))
					{
						year = "0";
					}
					
					int newYear = Integer.parseInt(year);
					int secDuration = Integer.parseInt(args[9]);
					fight.setSongAuthor(songAuthor);
					fight.setSongTitle(songName);
					fight.setYear(newYear);
					fight.setSecDuration(secDuration);
					
					info.add(fight);
				}
				
				else
				{
					String songName = args[2];
					String authors = "";
					for(int i = 2;i < args.length; i++)
					{
						authors += args[i] + ",";
					}
					
					fight.setSongTitle(songName);
					fight.setSongAuthor(authors);
					info.add(fight);				}
			}
		
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		return info;
	}
}
