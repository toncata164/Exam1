package exam.anastasiyat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParseCsvFile 
{
	public static List<Information> parse(String path)
	{
		List<Information> information = new ArrayList<>();
		
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);;
			lines.remove(0);
			
			for(String line : lines)
			{
				String[] args = line.split(",");
				
				String song = args[0];
				String artist = args[1];
				int releaseYear;
			
				try
				{
					releaseYear = Integer.parseInt(args[2]);
				}
				catch(NumberFormatException e)
				{
					continue;
				}
				
				int playCount = Integer.parseInt(args[6]);
				
				Information info = new Information();
				
				info.setSong(song);
				info.setArtist(artist);
				info.setReleaseYear(releaseYear);
				info.setPlayCount(playCount);
				
				information.add(info);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return information;
	}
}
