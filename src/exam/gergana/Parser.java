package exam.gergana;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	public static List<SongInformation> parse(String path)
	{
		List<SongInformation> infos = new ArrayList();
		
		try {
			List<String> lines =Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			lines.remove(0);
			lines.remove(10);
			
			for(String line : lines)
			{
				try
				{
				String[] args = line.split(",");
				
				if(line.contains("\""))
				{
					args[0] = args[0] + args[1];
				}
				
				//escape ,
				if(args[2].isEmpty())
					continue;
				
				int year = Integer.parseInt(args[2]);
				
				String newStr = args[6].replace(".", "");
				int playCount = Integer.parseInt(newStr);
				
				SongInformation newSong = new SongInformation(args[0], args[1], year, playCount);
				infos.add(newSong);
				} 
				catch(java.lang.NumberFormatException x)
				{
					System.out.println();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return infos;
	}
}
