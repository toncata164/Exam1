package exam.boris;

import java.util.Comparator;
import java.util.List;

public class TestPoliceInfo {

	public static void main(String[] args) {
		List<PoliceInfo> policeInfos=CsvParser.parse("src/exam/resources/police_killings.csv");
	    System.out.println(policeInfos.size());
	    firstTenKilledAtMarch2015(policeInfos);
	    killedPeopleAtMay(policeInfos);
	    killedLatinoPeopleAndMonthsEqualGiven(policeInfos);

	}
	public static void firstTenKilledAtMarch2015(List<PoliceInfo> policeInfos) 
	{
		policeInfos.stream().
		filter(x -> x.getYear()==2015 && x.getMonth().equals("March")).
		map(x -> x.getName()).limit(10).
		forEach(x -> System.out.println(x));
		
	}
	public static void killedPeopleAtMay(List<PoliceInfo> policeInfos) 
	{
		System.out.println(policeInfos.stream().filter(x -> x.getMonth().equals("May")).count());
	}
	public static void killedLatinoPeopleAndMonthsEqualGiven(List<PoliceInfo> policeInfos) 
	{
		policeInfos.stream().sorted(Comparator.comparingInt(PoliceInfo::getAge).reversed()).
		filter(x -> x.getMonth().equals("August") || x.getMonth().equals("July") || x.getMonth().equals("June")
			&&  x.getRaceethnicity().endsWith("Latino")).
		map(x -> x.getName()).forEach(x -> System.out.println(x));
	}
	public static void killedBlackPeople() 
	{
		
	}

}
