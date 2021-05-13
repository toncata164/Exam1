package exam.anastasiqn;


import java.util.List;

public class Main
{

	public static void main(String[] args)
	{
		List<DeathInfo> list = FileParser.parseFile("src/exam/resources/police_killings.csv");
		
//		Имената на първите 10 убити през март 2015 (1)
//		Имената на всички латиноси убити между юни и август включително сортирани намаляващо по възраст
//		Броят на убитите през май
//		Броят на всички убити в Калифорния(СА) ненавършили 40 години
//		Фамилията и годините на всички застреляни чернокожи през първото тримесечие на 2015 сортирани по датата на смъртта
		System.out.println("(1)");
		print1(list);
		
		System.out.println("(2)");
		print2(list);
		
		System.out.print("(3) -> ");
		System.out.println(print3(list));
		
		System.out.print("(4) -> ");
		System.out.println(print4(list));
		
		System.out.println("(5)");
		print5(list);
	}
	
	static void print1(List<DeathInfo> list)
	{
		list.stream()
			.filter(x -> x.getMonth().equals("March") && x.getYear() == 2015)
			.sorted((a, b) -> a.getDay() - b.getDay())
			.map(x -> x.getName())
			.forEach(x -> System.out.println(x));
	}
	
	static void print2(List<DeathInfo> list)
	{
		list.stream()
			.filter(x -> x.getRaceethnicity().equals("Hispanic/Latino"))
			.filter(x -> x.getMonth().equals("June") || x.getMonth().equals("July") || x.getMonth().equals("August"))
			.sorted((a, b) -> b.getAge() - a.getAge())
			.map(x -> x.getName())
			.forEach(x -> System.out.println(x));
	}
	
	static long print3(List<DeathInfo> list)
	{
		return list.stream()
				.filter(x -> x.getMonth().equals("May"))
				.count();
	}
	
	static long print4(List<DeathInfo> list)
	{
		return list.stream()
					.filter(x -> x.getAge() <= 40 && x.getState().equals("СА"))
					.count();
	}
	
	static void print5(List<DeathInfo> list)
	{
		list.stream().filter(x -> x.getRaceethnicity().equals("Black") && x.getYear() == 2015)
		.filter(x -> x.getMonth().equals("January") || x.getMonth().equals("February") || x.getMonth().equals("March"))
		.sorted((a, b) -> 
		{
			if (a.getYear() != b.getYear())
			{
				return a.getYear() - b.getYear();
			}
			
			if (!a.getMonth().equals(b.getMonth()))
			{
				return a.getMonth().compareTo(b.getMonth());
			}
			
			return a.getDay() - b.getDay();

		})
		.map(x -> x.getName())
		.forEach(x -> System.out.println(x));
		
	}
}
