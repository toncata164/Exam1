package exam.yova;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

public class APIQueries 
{

	public static void main(String[] args) 
	{
		//Path filePath = "..\\exam.resources\\police_killings.csv"; - this gives a mistake; probably
		//requires absolute path
		File file = new File("C:\\Users\\2017_yovaim\\Downloads\\Exam1-master\\src\\exam\\resources\\police_killings.csv");
		Path filePath = file.toPath();
		ArrayList<PoliceKillingsInfo> info = APICSVFileParser.parse(filePath);
		
		System.out.println("First ten people killed in March 2015: ");
		printFirstTenKilledInMarch2015(info);
		
		System.out.println("\nLatinx people killed between June and August Sorted Descending: ");
		printNamesOfLatinxPeopleKilledBetweenJuneAndAugustSortedDescending(info);
		
		

	}
	
	public static void printFirstTenKilledInMarch2015(ArrayList<PoliceKillingsInfo> info)
	{
		info.stream()
		.filter(x -> x.getYear() == 2015)
		.filter(x -> x.getMonth().equals("March"))
		.map(x -> x.getName())
		.distinct()
		.limit(10)
		.forEach(System.out::println);
	}
	
	public static void printNamesOfLatinxPeopleKilledBetweenJuneAndAugustSortedDescending(ArrayList<PoliceKillingsInfo> info)
	{
		//lmao this compares date of murder, not age
		/*Comparator<PoliceKillingsInfo> c = (val1, val2) -> val1.getYear() < val2.getYear() ? 1 : val1.getYear() 
				> val2.getYear() ? -1 : val1.getMonth() < val2.getMonth() ? 1 : val1.getMonth() > val2.getMonth() ? -1
						: val1.getDay() < val2.getDay() ? 1 : val1.getDay() > val2.getDay() ? -1 : 0;
						*/
		
		Comparator<PoliceKillingsInfo> c = (val1, val2) -> val1.getAge() < val2.getAge() ? 1 : val1.getAge() > val2.getAge() ? -1 : 0;
		
		info.stream()
		.filter(x -> x.getRace().contains("Latino"))
		.filter(x -> x.getMonth().equals("June") || x.getMonth().equals("July") || x.getMonth().equals("August"))
		.sorted(c)
		.map(x -> x.getName())
		.forEach(System.out::println);
		
	}

}
