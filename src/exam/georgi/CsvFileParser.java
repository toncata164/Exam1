package exam.georgi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileParser
{
	public static List<Song> parse(String path)
	{
		List<Song> songs = new ArrayList<>();
		
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			lines.remove(0);
			
			for (String line : lines)
			{
				String[] args = line.split(",");
				
				try
				{
					Song song = new Song();
					song.setName(args[0]);
					song.setArtist(args[1]);
					song.setReleaseYear(Integer.parseInt(args[2]));
					song.setPlayCount(Integer.parseInt(args[6]));
					songs.add(song);
				}
				catch (NumberFormatException e)
				{
					continue;
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return songs;
	}
}
