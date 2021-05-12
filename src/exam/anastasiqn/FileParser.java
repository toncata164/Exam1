package exam.anastasiqn;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class FileParser 
{
	public static List<DeathInfo>parseFile (String filePath) 
	{
		List<DeathInfo> deathList = new ArrayList<>();
		
		try
		{
			List<String> readLines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			readLines.remove(0);
		
			for(String line:readLines)
			{
				String[] args = line.split(",");
				
				String name = args[0];
				String raceethnicity = args[3];
				String month = args[4];
				int day = Integer.parseInt(args[5]);
				int year = Integer.parseInt(args[6]);
				String state = args[9];
				int age = 0;
				
				try
				{
					age = Integer.parseInt(args[1]);
				}
				catch (Exception e)
				{
					continue;
				}
				//
				DeathInfo info = new DeathInfo();
				info.setName(name);
				info.setAge(age);
				info.setRaceethnicity(raceethnicity);
				info.setMonth(month);
				info.setDay(day);
				info.setYear(year);
				info.setState(state);
				
				deathList.add(info);
			}
		}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return deathList;
		}
	}