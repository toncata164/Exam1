package exam.alexander;

import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) 
	{
		List<PoliceInfo> info = CsvParser.parse("src/exam/resources/police_killings.csv");
		killedPeopelMarch2015(info);
		System.out.println();
		namesOfLatinosKilledJuneAndAugust(info);
		System.out.println();
		countOfKilledDueMay(info);
		System.out.println();
		countOfKilledInCaliforniaTo40Years(info);
		System.out.println();
		killedBlack2015(info);
	}
	
	public static void killedPeopelMarch2015(List<PoliceInfo> info)
	{
		info.stream()
				.filter(x -> x.getMonth().equals("March"))
				.filter(x -> x.getYear() == 2015)
				.limit(10)
				.map(x -> x.getName())
				.forEach(x -> System.out.println(x));
	}
	
	public static void namesOfLatinosKilledJuneAndAugust(List<PoliceInfo> info)
	{
		info.stream()
			.filter(x -> x.getMonth().equals("March") || x.getMonth().equals("April") 
					|| x.getMonth().equals("May") || x.getMonth().equals("June") 
					|| x.getMonth().equals("July") || x.getMonth().equals("August"))
			.filter(x -> x.getRaceEthnicity().equals("Hispanic/Latino"))
			.map(x -> x.getName())
			.forEach(x -> System.out.println(x));
	}
	
	public static void countOfKilledDueMay(List<PoliceInfo> info)
	{
		System.out.println(info.stream()
				.filter(x -> x.getMonth().equals("May"))
				.count());
	}
	
	public static void countOfKilledInCaliforniaTo40Years(List<PoliceInfo> info) 
	{
		
		System.out.println(info.stream()
		.filter(x -> x.getState().equals("CA"))
		.filter(x -> x.getAge() < 40)
		.count());
	}
	
	public static void killedBlack2015(List<PoliceInfo> info)
	{
		info.stream()
				.filter(x -> x.getRaceEthnicity().equals("Black"))
				.filter(x -> x.getMonth().equals("January") 
						|| x.getMonth().equals("February") 
						|| x.getMonth().equals("March"))
				.filter(x -> x.getYear() == 2015)
				.forEach(x -> System.out.println());
	}

}
