package exam.dobri;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileParser
{

	public static List<Person> Parse(String path)
	{
		List<Person> people = new ArrayList<>();
		List<String> fileLines = new ArrayList<>();
		try
		{
			fileLines = Files.readAllLines(Paths.get(path));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		fileLines.remove(0);
		for(String line : fileLines)
		{
			Person currentPerson = new Person();
			String[] args = line.split(",");
			currentPerson.setName(args[0]);
			currentPerson.setAge(args[1]);
			currentPerson.setGender(args[2]);
			currentPerson.setRaceethnicity(args[3]);
			currentPerson.setMonth(args[4]);
			currentPerson.setDay(Integer.parseInt(args[5]));
			currentPerson.setYear(Integer.parseInt(args[6]));
			currentPerson.setStreetAdress(args[7]);
			currentPerson.setCity(args[8]);
			currentPerson.setState(args[9]);
			currentPerson.setLattitude(args[10]);
			currentPerson.setLongitude(args[11]);
			people.add(currentPerson);
		}		
		return people;
}
}
