package exam.dobri;

import java.util.Comparator;
import java.util.List;

public class StreamApi {

	public static void main(String[] args) 
	{
		List<RockSongInfo> rockSongs = CsvFileParser.parse("src\\exam\\resources\\classic-rock-song-list.csv");
		
		System.out.println(rockSongs.get(0).getArtistName());
		
	}
	
	private static void songNamesStartingWithALetter(List<RockSongInfo> rockSongs)
	{
		rockSongs.stream().filter(x -> !((int)x.getSongName().charAt(0) >= 65 && (int)x.getSongName().charAt(0) <=90
				|| (int)x.getSongName().charAt(0) >= 97 && (int)x.getSongName().charAt(0) <=122))
		.map(x -> x.getSongName()).forEach(System.out::println);
	}
	
	private static void songsWithLessThan20Plays(List<RockSongInfo> rockSongs)
	{
		rockSongs.stream().filter(x -> x.getFg() <=20)
		.map(x -> x.getSongName()).forEach(System.out::println);
	}
	
	private static void songsIn1975to1980(List<RockSongInfo> rockSongs)
	{
		long count = rockSongs.stream().filter(x -> x.getYear()>=1975 && x.getYear() <=1980)
		.distinct()
		.map(x -> x.getSongName()).count();
		System.out.println(count);
	}
	private static void songWithOver100Plays(List<RockSongInfo> rockSongs)
	{
		rockSongs.stream().filter(x -> x.getPlayCount() > 100)
		.sorted(RockSongInfo::compareByPlaysThenName)
		.map(x -> x.getSongName()).forEach(System.out::println);
	}
	
	private static void songsWith3Letters(List<RockSongInfo> rockSongs)
	{
		/*
		rockSongs.stream().filter(x -> x.getPlayCount() > 100)
		.sorted(RockSongInfo::compareByPlaysThenName)
		.map(x -> x.getSongName()).forEach(System.out::println);
		*/
	}
}
