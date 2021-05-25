package exam.alexandra;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

public class Program {

	public static void main(String[] args) 
	{
		List<PoliceKillings> policeKillings = CSVParser.parse("./src/exam/resources/police_killings.csv");
		
		allWhitePeopleStuckByVehicleDateSorted(policeKillings);

	}
	
	@SuppressWarnings("unchecked")
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
						else 
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
		filter(x -> x.getRaceethnicity().equals("White")).
		map(x -> x.getName()).
		sorted(c).
		distinct().
		forEach(x -> System.out.println(x));
		
	}
	
	static void allBlackPeopleKilledInCaliforniaAfterTheSecondHalfOf2015(List<PoliceKillings> policeKillings)
	{
		System.out.println("Äll black people killed in California(CA) after the second half of 2015: ");
		
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
		
		policeKillings.stream().
		filter(x -> x.getRaceethnicity().equals("Black") && x.getYear() == 2015 && x.getMonth() > 6).
		map(x -> x.getName()).
		forEach(x -> System.out.println(x));
	}

}
