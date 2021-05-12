package exam.resources;

import java.util.List;

public class Program {

	public static void main(String[] args) 
	{
		List<PoliceKillings> policeKillings = CSVParser.parse("src/exam/resources/police_killings.csv");

	}
	
	static void allWhitePeopleStuckByVehicleDateSorted(List<PoliceKillings> policeKillings)
	{
		System.out.println("All white people stuck by vehicle sorted by "
				+ "data of the accident:");
		
		policeKillings.stream().map(x -> x.getName() && x.getRaceethnicity() == "White");
		
	}

}
