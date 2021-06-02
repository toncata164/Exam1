package exam.alexandrasimeonova;

import java.util.Comparator;
import java.util.List;

public class Program {

	public static void main(String[] args) 
	{
		List<FightSongs> list = Parser.parse("./src/exam/resources/fight-songs.csv");
		System.out.println(list.size());

		namesWhichDoesntStartWithVowels(list);
		System.out.println();
		//namesOfAllSongsMadeAfterTheSecondHalfOF20thCentury(list);
		System.out.println();
		System.out.println(countOfSongsWhichHaveMoreThanOneAuthor(list));
	}
	
	public static void namesWhichDoesntStartWithVowels(List<FightSongs> fightSongs)
	{
		fightSongs.stream().
		filter(x -> !x.getSongName().startsWith("A")
				&& !x.getSongName().startsWith("O")
				&& !x.getSongName().startsWith("U")
				&& !x.getSongName().startsWith("E")
				&& !x.getSongName().startsWith("I")).
		map(x -> x.getSongName()).
		forEach(x -> System.out.println(x));
	}
	
	public static void namesOfAllSongsMadeAfterTheSecondHalfOF20thCentury(List<FightSongs> fightSongs)
	{
		fightSongs.stream().
		filter(x -> Integer.parseInt(x.getYear()) >= 1950).
		map(x -> x.getSongName()).
		forEach(x -> System.out.println(x));
	}
	
	public static long countOfSongsWhichHaveMoreThanOneAuthor(List<FightSongs> fightSongs)
	{
		long result = fightSongs.stream().
				filter(x -> x.getAuthorsCount() > 1).
				count();
		
		return result;
	}
	
	public static void songAndAuthorWhichContainFight(List<FightSongs> fightSongs)
	{
		Comparator c = new Comparator() 
		{

			@Override
			public int compare(Object o1, Object o2)
			{
				// TODO Auto-generated method stub
				int s1 = (int) o1;
				int s2 = (int) o1;
				
				return 0;
			}
			
		};
		fightSongs.stream().filter(x -> x.isFight() == "Yes").sorted(c).distinct();
	}

}
