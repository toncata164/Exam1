package exam.yova;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser 
{
	public static List<SongInfo> parse(String filePath)
	{
		List<SongInfo> result = new ArrayList<>();
		
		try 
		{
			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			lines.remove(0);
			for(String line : lines)
			{
				String[] items = line.split(",");
				for(int i = 0; i < items.length; i++)
				{
					if(items[i].startsWith("\"") && i < items.length - 1)
					{
						items[i] = items[i] + items[i + 1];
						int j = i + 1;
						for(; j < items.length - 1; j++)
						{
							items[j] = items[j + 1];
						}
					}
				}
				items[items.length - 1] = null;
				
					String name = items[0];
					String artist = items[1];
					int releaseYear;
					if(items[5].equals("1"))
					{
						if(items[2].equals("SONGFACTS.COM"))
							releaseYear = -1;
						else
							releaseYear = parseInt(items[2]);
					}
					else
					{
						releaseYear = -1;
					}
					int playCount = parseInt(items[6]);
					SongInfo temp = new SongInfo(name, artist, releaseYear, playCount);
					result.add(temp);
				
				
			}
		} 
		catch (IOException e) 
		{
			System.out.println("Problems with file parsing.");
			e.printStackTrace();
		}
		
		return result;
	}
	
	private static int parseInt(String text)
	{
		return Integer.parseInt(text.replaceAll("\"", ""));
	}
}
