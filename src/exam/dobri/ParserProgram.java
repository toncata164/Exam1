package exam.dobri;

import java.util.List;

public class ParserProgram {

	public static void main(String[] args) 
	{
		List<Person> people = 
				FileParser.Parse("src/exam/resources/police_killings.csv");
		String name = people.get(0).getName();
		System.out.println(name);
	}

}