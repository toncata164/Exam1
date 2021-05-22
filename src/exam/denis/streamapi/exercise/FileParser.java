package exam.denis.streamapi.exercise;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileParser
{
	public static List<PoliceKilling> parseFile(String filePath)
	{
		List<PoliceKilling> policeKillings = new ArrayList<>();
		
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			lines.remove(0);
			
			for(String line : lines)
			{
				String[] splited = line.split(",");
				
				PoliceKilling temp = new PoliceKilling();
				
				temp.setName(splited[0]);
				
				if(!splited[1].equals("Unknown"))
				{
					temp.setAge(Integer.parseInt(splited[1]));
				}
				
				temp.setGender(parseGender(splited[2]));
				temp.setRaceEthnicity(splited[3]);
				temp.setMonth(parseMonth(splited[4]));
				temp.setDay(Integer.parseInt(splited[5]));
				temp.setYear(Integer.parseInt(splited[6]));
				temp.setCity(splited[8]);
				temp.setState(splited[9]);
				temp.setDeathType(splited[19]);
				
				policeKillings.add(temp);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return policeKillings;
	}
	

	public static Gender parseGender(String input)
	{
		switch(input)
		{
			case ("Male"):
			{
				return Gender.Male;
			}
			case ("Female"):
			{
				return Gender.Female;
			}
			default:
				return Gender.Unknown;
		}
	}
	
	public static int parseMonth(String input)
	{
		switch(input)
		{
			case ("January"):
			{
				return 1;
			}
			case ("February"):
			{
				return 2;
			}
			case ("March"):
			{
				return 3;
			}
			case ("April"):
			{
				return 4;
			}
			case ("May"):
			{
				return 5;
			}
			case ("June"):
			{
				return 6;
			}
			case ("July"):
			{
				return 7;
			}
			case ("August"):
			{
				return 8;
			}
			case ("September"):
			{
				return 9;
			}
			case ("October"):
			{
				return 10;
			}
			case ("November"):
			{
				return 11;
			}
			case ("December"):
			{
				return 12;
			}
			default:
				return 0;
		}
	}
}