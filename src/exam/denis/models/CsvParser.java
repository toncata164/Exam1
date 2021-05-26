package exam.denis.models;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvParser
{
	public static List<Song> parse(String pathFile)
	{
		List<Song> result = new ArrayList<Song>();
		
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(pathFile), StandardCharsets.UTF_8);
			
			lines.remove(0);
			
			for(String line : lines)
			{
				String[] splited = line.split(",|\\, ");
				
				if(splited.length != 8)
				{
					continue;
				}
				
				Song temp = new Song();
				
				temp.setName(splited[0]);
				temp.setArtist(splited[1]);
				if(splited[5].equals("1"))
				{
					
					try
					{
						temp.setYear(Integer.parseInt(splited[2]));
					}
					catch(NumberFormatException e)
					{
						continue;
					}
				}
				
				temp.setCombined(splited[3]);
				temp.setPlaysCount(Integer.parseInt(splited[6]));
				temp.setWorldwidePlaysCount(Integer.parseInt(splited[7]));
				
				result.add(temp);
			}
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}
