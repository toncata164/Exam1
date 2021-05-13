package exam.dobri;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ParserProgram {

	public static void main(String[] args) 
	{
		List<Person> people = 
				FileParser.Parse("src/exam/resources/police_killings.csv");
		String name = people.get(0).getName();
		System.out.println(name);
		//firstKillenInMarch(people);
		//latinKillers(people);
		killedInMay(people);
	}
	public static void firstKillenInMarch(List<Person> people)
	{
		people.stream().
		filter(x -> x.getYear() == 2015 && x.getMonth().equals("March"))
		.map(x -> x.getName())
		.limit(10)
		.forEach(System.out::println);
	}
	public static void latinKillers(List<Person> people)
	{
	//	Comparator<Person> comp 
	 //     = Comparator.comparing(Person::getAge);
		people.stream().
		filter(x -> x.getRaceethnicity().equals("Latino")
				&& x.getMonth().equals("June") || x.getMonth().equals("July")
				|| x.getMonth().equals("August"))
		.map(x -> x.getName())
		//.sorted(comp)
		.forEach(System.out::println);
	}
	public static void killedInMay(List<Person> people)
	{
		int count = (int) people.stream().
		filter(x -> x.getMonth().equals("May"))
		.count();
		
		System.out.println(count);
	}
	
}
