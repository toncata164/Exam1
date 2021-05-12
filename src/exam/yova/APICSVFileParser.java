package exam.yova;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class APICSVFileParser 
{
	
	public static ArrayList<PoliceKillingsInfo> parse(Path filePath)
	{
		ArrayList<PoliceKillingsInfo> info = new ArrayList<>();
		try 
		{
			List<String> file = Files.readAllLines(filePath, StandardCharsets.UTF_8);
			file.remove(0);
			//String[] lines = (String[]) file.toArray();
			for(String line : file)
			{
				String[] infos = line.split(",");
				String name = infos[0];
				int age = parseInt(infos[1]);
				boolean male = infos[2].equals("Male") ? true : false;
				String race = infos[3];
				String month = infos[4];
				int day = infos[5].equals("Unkown") ? Integer.MIN_VALUE : Integer.parseInt(infos[5]);
				int year = infos[6].equals("Unkown") ? Integer.MIN_VALUE : Integer.parseInt(infos[6]);
				String streetAddress = infos[7];
				String city = infos[8];
				String state = infos[9];
				
				PoliceKillingsInfo temp = new PoliceKillingsInfo(name, age, male, race, day, month, year, 
						streetAddress, city, state);
				info.add(temp);
			}
			
		} 
		catch (IOException e) 
		{
			System.out.println("File parsing problems.");
		}
		
		return info;
	}
	
	private static int parseInt(String text)
	{
		if(text.equals("Unknown"))
		{
			return Integer.MIN_VALUE;
		}
		return Integer.parseInt(text);
	}
}
