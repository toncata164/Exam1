package exam.alexandra;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParser 
{
	public static List<PoliceKillings> parse(String filePath)
	{
		List<PoliceKillings> policeKillings = new ArrayList<>();
		
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(filePath),
					StandardCharsets.UTF_8);
			
			
			lines.remove(0);
			for(String line : lines)
			{
				String[] args = line.split(",");
				
				String name = args[0];
				String age = args[1];
				String gender = args[2];
				String raceethnicity = args[3];
				String month = args[4];
				int day = Integer.parseInt(args[5]);
				int year = Integer.parseInt(args[6]);
				String streetaddress = args[7];
				String city = args[8];
				String state = args[9];
				String cause = args[19];
				
				PoliceKillings info = new PoliceKillings();
				info.setName(name);
				info.setAge(age);
				info.setGender(gender);
				info.setRaceethnicity(raceethnicity);
				info.setMonth(month);
				info.setDay(day);
				info.setYear(year);
				info.setStreetaddress(streetaddress);
				info.setCity(city);
				info.setState(state);
				info.setCause(cause);
				
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
