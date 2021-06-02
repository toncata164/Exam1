package exam.anastasiqn;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileParser 
{
	public static List<SongInfo> parser(String filePath)
	{
		List<SongInfo> returnList = new ArrayList();
		try
		{
			List<String> readLines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			readLines.remove(0);
			
			for(String line:readLines)
			{
				String[] args = line.split(",");
				
				String name = args[0];
				String artist = args[1];
				int year;
				
				try
				{
					year = Integer.parseInt(args[2]);
				}
				catch(NumberFormatException e)
				{
					continue;
				}
				
				int playCount = Integer.parseInt(args[6]);
				
				SongInfo helper = new SongInfo();
				helper.setName(name);
				helper.setArtist(artist);
				helper.setYear(year);
				helper.setPlayCount(playCount);
				
				returnList.add(helper);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return returnList;
	}
}
