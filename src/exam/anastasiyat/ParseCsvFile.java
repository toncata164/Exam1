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
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			lines.remove(0);
			
			for(String line : lines)
			{
				String[] args = line.split(",");
				
				String name = args[0];
				int age = Integer.parseInt(args[1]);
				String gender = args[2];
				String raceethnicity = args[3];
				int month = Integer.parseInt(args[4]);
				int day = Integer.parseInt(args[5]);
				int year = Integer.parseInt(args[6]);
				String state = args[9];
				String cause = args[19];
				
				Information info = new Information();
				
				info.setName(name);
				info.setAge(age);
				info.setGender(gender);
				info.setRaceethnicity(raceethnicity);
				info.setMonth(month);
				info.setDay(day);
				info.setYear(year);
				info.setState(state);
				info.setCause(cause);
			}
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return information;
	}
}
