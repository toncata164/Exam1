package exam.anastasiqn;

import java.util.List;

public class Test 
{	
	public static void main(String[] args) 
	{
		List<SongInfo> list = FileParser.parser("src/exam/resources/classic-rock-song-list.csv");
		//System.out.println(list.size());
		
		System.out.println("---------1------------");
		request1(list);
		
		
		System.out.println("---------2------------");
		request2(list);
		
		System.out.println("---------3------------");
		System.out.println(request3(list));
		
		System.out.println("---------4------------");
		request4(list);
		
		System.out.println("---------5------------");
		request5(list);
	}
	
	public static void request1(List<SongInfo> list)
	{
		//Имената на всички песни не започващи с буква
		list.stream()
			.filter(x -> x.getName().startsWith("1") 
									|| x.getName().startsWith("2") 
										|| x.getName().startsWith("3")
											|| x.getName().startsWith("4") 
												|| x.getName().startsWith("5")
													|| x.getName().startsWith("6") 
														|| x.getName().startsWith("7")
															|| x.getName().startsWith("8") 
																|| x.getName().startsWith("9"))
			.map(x -> x.getName())
			.forEach(x -> System.out.println(x));
		
	}

	public static void request2(List<SongInfo> list)
	{
		//Имената на всички групи/изпълнители издали песен с под 20 пускания по радиото.
		list.stream()
				.filter(X -> X.getPlayCount() < 20)
				.map(x -> x.getArtist())
				.distinct()
				.forEach(x -> System.out.println(x));
	}
	
	public static long request3(List<SongInfo> list)
	{
		//Броят на групите издали песен в периода 1975-1980
		return list.stream()
					.filter(x -> x.getYear() >= 1975 && x.getYear() <=1980)
					.count();
	}
	
	public static void request4(List<SongInfo> list)
	{
		//Песен и група чиито пускания по радиостанциите надвишават 100, 
		//сортирани по брой пускания низходящо, а ако броят на пусканията съвпада 
		//по име на песента възходящо.
		
		list.stream()
				.filter(x -> x.getPlayCount() > 100)				
				.sorted((a, b) -> a.getPlayCount() - b.getPlayCount())
				.forEach(x -> System.out.println(x.getName() +"--"+ x.getArtist()));;

	}
	
	public static void request5(List<SongInfo> list)
	{
		//Всички песни чиито имена съдържат повече от три еднакви букви 
		//(главните и малките букви се броят за една и съща буква),
		//сортирани низходящо по брой пускания по радиото.
		
		list.stream()
			.sorted((a, b) -> a.getPlayCount() - b.getPlayCount())
			.map(x -> x.getName().toLowerCase().toCharArray())
			.filter(x -> 
			{
				int count = 0;
			for (int i = 0; i < x.length; i++)
			{
				for (int k = 0; k < x.length; k++)
				{
					if(x[i] ==x[k])
					{
						count++;
					}
					
					if (count == 3)
					{
						return true;
					}
				}
			}
			return false;
			})	;

	}
	
	
}
