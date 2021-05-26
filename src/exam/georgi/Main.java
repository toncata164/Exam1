package exam.georgi;

import java.util.HashMap;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		List<Song> songs = CsvFileParser.parse("src/exam/resources/classic-rock-song-list.csv");
		
		System.out.println("Query #1\n");
		
		songs.stream()
			.filter(s -> lettersAndSpacesOnly(s.getName()))
			.forEach(s -> System.out.println(s.getName()));
	
		System.out.println("\nQuery #2\n");
		
		songs.stream()
			.filter(s -> s.getPlayCount() >= 20 && s.getPlayCount() <= 50)
			.map(s -> s.getArtist())
			.distinct()
			.forEach(System.out::println);
		
		
		System.out.println("\nQuery #3\n");
		
		songs.stream()
			.filter(s -> s.getReleaseYear() >= 1975 && s.getReleaseYear() <= 1980)
			.map(s -> s.getArtist())
			.distinct()
			.forEach(System.out::println);
		
		System.out.println("\nQuery #4\n");

		songs.stream()
			.filter(s -> s.getPlayCount() > 100)
			.sorted((a, b) -> 
			{
				if (b.getPlayCount() - a.getPlayCount() != 0)
				{
					return b.getPlayCount() - a.getPlayCount();
				}
				
				return a.getName().compareTo(b.getName());
			})
			.forEach(s -> System.out.println(s + " -> " + s.getPlayCount() + " plays"));
		
		System.out.println("\nQuery #5\n");
		
		songs.stream()
			.filter(s -> !containsMoreThan(3, s.getName()))
			.sorted((a, b) -> b.getPlayCount() - a.getPlayCount())
			.forEach(s -> System.out.println(s.getName()));
		
	}
	
	public static boolean lettersAndSpacesOnly(String input)
	{
		for (char symbol : input.toCharArray())
		{
			if (!Character.isLetter(symbol) && symbol != ' ')
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean containsMoreThan(int sameLettersCount, String input)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		
		input = input.toLowerCase();
		
		for (char symbol : input.toCharArray())
		{
			if (!map.containsKey(symbol))
			{
				map.put(symbol, 1);
			}
			else
			{
				map.put(symbol, map.get(symbol) + 1);
			}
		}
		
		return map.entrySet().stream().anyMatch(x -> x.getValue() > sameLettersCount);
	}
}
