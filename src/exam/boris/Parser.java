package exam.boris;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	public static List<SongInfo> parse(String filePath)
	{
		List<SongInfo> songInfos=new ArrayList();
		
		try
		{
			List<String> lines=Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8); 
			lines.remove(0);
			
			for(String line:lines) 
			{
				String[] args=line.split(",");
				if(args.length==23) 
				
				{
					String name=args[2];
					String writers=args[3];
					int writersCount=1;
					if(args[3].contains("and")) 
					{
						writersCount=2;
					}
					int year=0;
					if(!args[4].equals("Unknown")) 
					{
						year=Integer.parseInt(args[4]);
					}
					int duration=Integer.parseInt(args[9]);
					boolean nonsense=false;
					if(args[19].equals("Yes")) 
					{
						nonsense=true;
					}
					SongInfo info= new SongInfo(name,writers,year,nonsense,writersCount,duration);
					
					songInfos.add(info);
				}else 
				{
					String name=args[2];
					int writersCount=args.length-1;
					String writers="";
					for(int i=2;i<args.length;i++) 
					{
						writers+=args[i]+",";
					}
					if(writers.contains("and")) 
					{
						writersCount+=1;
					}
					SongInfo info=new SongInfo(name,writers,writersCount);
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
