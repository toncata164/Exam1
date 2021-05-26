package exam.alexander;import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) 
	{
		List<ClassicRockSongList> classicRockSongList = Parser.parse("./src/exam/resources/classic-rock-song-list.csv"); 
		System.out.println(classicRockSongList.size());
		
		nameOfAllSongsWhichDontStartWithVowel(classicRockSongList);
		
		System.out.println();
		
		nameOfAllArtistsOfSingsWithMoreThan100Plays(classicRockSongList);
		
		System.out.println();
		
		numberOfAllBandsWithSongsReleasedBetween1975And1980(classicRockSongList);
		
	}
	
	public static void nameOfAllSongsWhichDontStartWithVowel(List<ClassicRockSongList> classicRockSongList)
	{
		classicRockSongList.stream().
		filter(x -> !x.getNameOfTheSong().startsWith("A") && 
				!x.getNameOfTheSong().startsWith("O") && 
				!x.getNameOfTheSong().startsWith("U") && 
				!x.getNameOfTheSong().startsWith("E") && 
				!x.getNameOfTheSong().startsWith("I")).
		map(x -> x.getNameOfTheSong()).
		forEach(x -> System.out.println(x));
	}
	
	public static void nameOfAllArtistsOfSingsWithMoreThan100Plays(List<ClassicRockSongList> classicRockSongList)
	{
		classicRockSongList.stream().
		filter(x -> x.getPlayCount() > 100).
		map(x -> x.getNameOfTheArtist()).
		forEach(x -> System.out.println(x));
	}
	
	public static void numberOfAllBandsWithSongsReleasedBetween1975And1980(List<ClassicRockSongList> classicRockSongList)
	{
		long temp = classicRockSongList.stream().
		filter(x -> x.getReleaseYear().equals("1975") ||
				x.getReleaseYear().equals("1976") ||
				x.getReleaseYear().equals("1977") ||
				x.getReleaseYear().equals("1978") ||
				x.getReleaseYear().equals("1979") ||
				x.getReleaseYear().equals("1980")).
		map(x -> x.getNameOfTheArtist()).
		count();
		
		System.out.println(temp);
	}

}
