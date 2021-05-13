package exam.yova;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

public class APIQueries 
{

	public static void main(String[] args) 
	{
		File file = new File("C:\\Users\\2017_yovaim\\Downloads\\Exam1-master\\src\\exam\\resources\\police_killings.csv");
		Path filePath = file.toPath();
		ArrayList<PoliceKillingsInfo> info = APICSVFileParser.parse(filePath);
		
		System.out.println("First ten people killed in March 2015: ");
		printFirstTenKilledInMarch2015(info);
		
		System.out.println("\nLatinx people killed between January and March Sorted Descending: ");
		printNamesOfLatinxPeopleKilledBetweenJanuaryAndMarchSortedDescending(info);
		
		System.out.println("\nNumber of people killed in May: ");
		printNumberOfDeadInMay(info);
		
		System.out.println("\nNumber of people killed in California who were under 40 years old: ");
		printNumberOfKilledInCaliforniaUnder40Years(info);
		
		System.out.println("\nBlack people killed in the first trimester of 2015: ");
		printSurnameAndAgeOfBlackPeopleKilledInFirstTrimesterOf2015SortedByDateOfDeath(info);
		
		

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
	
	
	public static void printNamesOfLatinxPeopleKilledBetweenJanuaryAndMarchSortedDescending(ArrayList<PoliceKillingsInfo> info)
	{	
		Comparator<PoliceKillingsInfo> c = (val1, val2) -> val1.getAge() < val2.getAge() ? -1 : val1.getAge() > val2.getAge() ? 1 : 0;
		
		info.stream()
		.filter(x -> x.getRace().contains("Latino"))
		.filter(x -> x.monthToNumber() == 1 || x.monthToNumber() == 2 || x.monthToNumber() == 3)
		//.filter(x -> x.getMonth().equals("June") || x.getMonth().equals("July") || x.getMonth().equals("August"))
		.sorted(c)
		.map(x -> x.getName())
		.forEach(System.out::println);
		
	}
	
	public static void printNumberOfDeadInMay(ArrayList<PoliceKillingsInfo> info)
	{
		System.out.println(info.stream()
				.filter(x -> x.getMonth().equals("May"))
				.count());
	}
	
	public static void printNumberOfKilledInCaliforniaUnder40Years(ArrayList<PoliceKillingsInfo> info)
	{
		System.out.println(info.stream()
				.filter(x -> x.getState().equals("CA") && x.getAge() < 40)
				.count());
	}
	
	public static void printSurnameAndAgeOfBlackPeopleKilledInFirstTrimesterOf2015SortedByDateOfDeath(ArrayList<PoliceKillingsInfo> info)
	{
		/*Comparator<PoliceKillingsInfo> c = (val1, val2) -> val1.getYear() < val2.getYear() ? 1 : val1.getYear() 
				> val2.getYear() ? -1 : val1.getMonth() < val2.getMonth() ? 1 : val1.getMonth() > val2.getMonth() ? -1
						: val1.getDay() < val2.getDay() ? 1 : val1.getDay() > val2.getDay() ? -1 : 0;
						*/
		
		Comparator<PoliceKillingsInfo> c = (val1, val2) -> val1.monthToNumber() < val2.monthToNumber() ? 1 : 
			val1.monthToNumber() > val2.monthToNumber() ? -1 : val1.getDay() < val2.getDay() ? 1 
					: val1.getDay() > val2.getDay() ? -1 : 0; //doesn't include year because the year is 
					//filtered to be 2015
		
		info.stream()
		.filter(x -> x.getYear() == 2015)
		.filter(x -> x.getMonth().equals("January") || x.getMonth().equals("February") || x.getMonth().equals("March"))
		.filter(x -> x.getRace().contains("Black"))
		.sorted(c)
		.map(x -> x.getSurnameAndAge())
		.forEach(System.out::println);
	}

}
