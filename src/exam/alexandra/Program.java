package exam.alexandra;

import java.util.Comparator;
import java.util.HashMap;
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
		
		Comparator c = new Comparator()
				{
					
					@Override
					public int compare(Object o1, Object o2) 
					{
						PoliceKillings p1 = (PoliceKillings) o1;
						PoliceKillings p2 = (PoliceKillings) o2;
						
						HashMap<String, Integer> months = new HashMap<>();
						months.put("January", 1);
						months.put("February", 2);
						months.put("March", 3);
						months.put("April", 4);
						months.put("May", 5);
						months.put("June", 6);
						months.put("July", 7);
						months.put("August", 8);
						months.put("September", 9);
						months.put("October", 10);
						months.put("November", 11);
						months.put("December", 12);
						months.containsKey(p1);
						months.containsKey(p2);
						
						if(p1.getYear() == p1.getYear())
						{
							if(p1.getMonth().compareTo(p2.getMonth()) == 0)
							{
								if(p1.getDay() == p2.getDay())
								{
									return 0;
								}
								else if(p1.getDay() > p2.getDay())
								{
									return 1;
								}
								else
								{
									return -1;
								}
							}
							else if(months.get(p1.getMonth()) > months.get(p2.getMonth()))
							{
								return 1;
							}
							else
							{
								return -1;
							}
						}
						else if(p1.getYear() > p2.getYear())
						{
							return 1;
						}
						else if(p1.getYear() < p2.getYear())
						{
							if(months.get(p1.getMonth()) < months.get(p2.getMonth()))
							{
								if(p1.getDay() < p2.getDay())
								{
									return -1;
								}
								else
								{
									return 1;
								}
							}
							else if(months.get(p1.getMonth()) > months.get(p2.getMonth()))
							{
								return 1;
							}
							else
							{
								return -1;
							}
						}
							
					}
			
				};
		
		policeKillings.stream().
		filter(x -> x.getRaceethnicity() == "White").
		map(x -> x.getName()).
		sorted();
		
	}

}
