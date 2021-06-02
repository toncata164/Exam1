package exam.alexandurnikolov;

import java.util.List;

public class Test {

	public static void main(String[] args) 
	{
		List<FightSongs> fight = CsvParser.parse("./src/exam/resources/fight-songs.csv");
		fight.size();
		//nameStartsWith(fight);
	}
	
	public static void nameStartsWith(List<FightSongs> fight)
	{
		fight.stream()
		.filter(x -> x.getSongTitle().startsWith("A") ||
									x.getSongTitle().startsWith("O") ||
									x.getSongTitle().startsWith("U") ||
									x.getSongTitle().startsWith("E") ||
									x.getSongTitle().startsWith("I"))
		.forEach(x -> System.out.println(x));
	}
	
	public static void nameOfSongs20Century(List<FightSongs> fight)
	{
		fight.stream()
		.filter(x -> x.getYear() >= 1900 && x.getYear() <= 2000)
		.forEach(x -> System.out.println(x.getSongTitle()));
	}
	
	public static void countOfSongsWithMoreThanOneAuthor(List<FightSongs> fight)
	{
		System.out.println(fight.stream()
		.filter(x -> x.getSongAuthor().contains(",") 
				|| x.getSongAuthor().contains("and"))
		.count());
	}
	
	public static void songAndAuthorsWithStrangeNames(List<FightSongs> fight)
	{
		fight.stream().filter(x -> x.getSongAuthor().contains(",") 
				|| x.getSongAuthor().contains("and") || x.getSongTitle().contains(" ") 
				|| x.getSongTitle().contains(","))
		.sorted()
		.forEach(x -> System.out.println(x.getSongAuthor() + " " + x.getSongTitle()));
		
	}
	
	public static void songsWithMoreThan2Words(List<FightSongs> fight)
	{
		fight.stream().filter(x -> x.getSongTitle().contains(" ") 
				|| x.getSongTitle().contains(","))
		.sorted()
		.forEach(x -> System.out.println(x.getSongTitle()));
	}
}
