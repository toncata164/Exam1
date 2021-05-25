package exam.alexandra;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser 
{
	public static List<PoliceKillings> parse(String filePath)
	{
		List<PoliceKillings> policeKillings = new ArrayList<>();
		
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			
			for(String line : lines)
			{
				String[] args = line.split(",");
				
				String name = args[0];
				
				PoliceKillings info = new PoliceKillings();
				info.setName(name);
				
				policeKillings.add(info);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return policeKillings;
	}
	

}
