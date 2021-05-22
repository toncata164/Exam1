package exam.denis.streamapi.exercise;

import java.util.List;
import java.util.stream.Stream;

public class Program
{

	public static void main(String[] args)
	{
		List<PoliceKilling> policeKillings = FileParser.parseFile("src/exam/resources/police_killings.csv");
		System.out.println(policeKillings.size());

		printAllWhiteFemales(policeKillings);
		printAllBlackKilledInCaliforniaIn2015(policeKillings);
		allWhiteStruckByVehicleCount(policeKillings);
		allFemalesDuringTheFirstHalfOf2015Count(policeKillings);
	}
	
	private static void printAllWhiteFemales(List<PoliceKilling> policeKillings)
	{
		Stream<PoliceKilling> stream = policeKillings.stream();
		System.out.println("All White Females: ");
		stream.filter(x -> x.getRaceEthnicity().equals("White") && x.getGender().equals(Gender.Female))
		  		.forEach(x -> System.out.println(x.getName()));
	}
	
	private static void printAllBlackKilledInCaliforniaIn2015(List<PoliceKilling> policeKillings)
	{
		Stream<PoliceKilling> stream = policeKillings.stream();
		System.out.println("All Black Killed In California In The Second Half Of 2015: ");
		stream.filter(x -> x.getRaceEthnicity().equals("Black") 
							&& x.getState().toLowerCase().equals("ca")
							&& x.getMonth() > 6)
		  		.forEach(x -> System.out.println(x.getName()));
	}

	private static void allWhiteStruckByVehicleCount(List<PoliceKilling> policeKillings)
	{
		Stream<PoliceKilling> stream = policeKillings.stream();
		System.out.println("All White Struck By Vehicle Count: ");
		System.out.println(stream.filter(x -> x.getRaceEthnicity().equals("White") 
											  && x.getDeathType().equals("Struck by vehicle")).count());
	}
	
	private static void allFemalesDuringTheFirstHalfOf2015Count(List<PoliceKilling> policeKillings)
	{
		Stream<PoliceKilling> stream = policeKillings.stream();
		System.out.println("All White Struck By Vehicle Count: ");
		System.out.println(stream.filter(x -> x.getRaceEthnicity().equals("White") 
											  && x.getDeathType().equals("Struck by vehicle")).count());
	}
}
