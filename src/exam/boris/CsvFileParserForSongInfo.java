package exam.boris;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileParserForSongInfo {
	
	public static List<SongInfo> parser(String filePath)
	{
		List<SongInfo> songInfos = new ArrayList();
		
		try 
		{
			List<String> lines = Files.readAllLines(Paths.get(filePath) ,  StandardCharsets.UTF_8);
			lines.remove(0);
			for(String line : lines) 
			{
				if(line.length()==8) {
					
				String[] args=line.split(",");
				String songClean=args[0];
				String artistClean=args[1];
				int releaseYear=args[2].isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(args[2]);
				String combined=args[3];
				int playCount=Integer.parseInt(args[6]);
				
				SongInfo info= new SongInfo(songClean,artistClean,releaseYear,combined,playCount);
				
				songInfos.add(info);
			}
				else 
				{
					String[] args=line.split(",");
					String songClean=args[0];
					int releaseYear=args[3].isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(args[2]);
					String combined=args[4];
					int playCount=Integer.parseInt(args[7]);
					
					SongInfo info= new SongInfo(songClean,releaseYear,combined,playCount);
					
					songInfos.add(info);
				}
			}
				
			
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		return songInfos;
		
	}

}
