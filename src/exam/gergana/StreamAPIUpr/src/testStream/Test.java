package testStream;

import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

public class Test {

	public static void main(String[] args) 
	{
		List<Information> info = Parser.parse("src/police_killings.csv");
		
		
		firstTenKiledInMay(info);
	}
	
	static void firstTenKiledInMay(List<Information> infos)
	{
		infos.stream()
		.filter(x -> x.month.equals("March") && x.year == 2015)
		.distinct()
		.limit(10)
		.forEach(x -> System.out.println(x));
	}
	
	static void latinoKiledFromJunyToAugust(List<Information> infos)
	{
		infos.stream()
		.filter(x -> x.gender.equals("Hispanic/Latino") && 
				(x.month.equals("June") || x.month.equals("July") || x.month.equals("August")));
	}

}
