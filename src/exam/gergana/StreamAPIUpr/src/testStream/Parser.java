package testStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser 
{
	static List<Information> parse(String path) 
	{
		List<Information> infos = new ArrayList();
		
		try 
		{
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			lines.remove(0);
			
			for(String line : lines)
			{
				String[] args = line.split(",");
			
				if(args[1].equals("Unknown")) 
					continue;
				
				int age = Integer.parseInt(args[1]);
				int day = Integer.parseInt(args[5]);
				int year = Integer.parseInt(args[6]);
				
				Information currentLineInfo = new Information(args[0], age, args[2], args[3], args[4], day, year, args[9]);
				infos.add(currentLineInfo);
			}
			
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		return infos;
	}
}
