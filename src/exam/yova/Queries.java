package exam.yova;

import java.util.Comparator;
import java.util.List;

public class Queries 
{

	public static void main(String[] args) 
	{
		
		List<SongInfo> songs = CSVFileParser.parse("C:\\Users\\2017_yovaim\\git\\Exam1\\src\\exam\\resources\\classic-rock-song-list.csv");

		System.out.println("Songs that begin with a vowel: ");
		printAllSongsBeginningWithVowel(songs);
		System.out.println("\nArtists that released a song in 1980: ");
		printArtists1980(songs);
		System.out.println("\nNumber of artists that released a song between 1975 and 1980: ");
		printNumberOfArtists19751980(songs);
		System.out.println("\nSongs with more than 70 plays sorted: ");
		printSongsMoreThan70PlaysSorted(songs);
		System.out.println("\nSongs with titles that contain an ': ");
		printSongsTitlesContainApostrophe(songs);

	}
	
	public static void printAllSongsBeginningWithVowel(List<SongInfo> songs)
	{
		songs.stream()
		.filter(x -> x.getName().startsWith("A") || x.getName().startsWith("O") || 
				x.getName().startsWith("U") || x.getName().startsWith("I") || x.getName().startsWith("E"))
		.distinct()
		.map(x -> x.getName())
		.forEach(System.out::println);
	}
	
	public static void printArtists1980(List<SongInfo> songs)
	{
		songs.stream()
		.filter(x -> x.getReleaseYear() == 1980)
		.map(x -> x.getArtist())
		.distinct()
		.forEach(System.out::println);
	}
	
	public static void printNumberOfArtists19751980(List<SongInfo> songs)
	{
		System.out.println(songs.stream()
		.filter(x -> x.getReleaseYear() >= 1975 && x.getReleaseYear() <= 1980)
		.map(x -> x.getArtist())
		.distinct()
		.count());
	}
	
	public static void printSongsMoreThan70PlaysSorted(List<SongInfo> songs)
	{
		Comparator<SongInfo> c = new Comparator<SongInfo>() {

			@Override
			public int compare(SongInfo o1, SongInfo o2) 
			{
				if(((SongInfo) o1).getPlayCount() > ((SongInfo) o2).getPlayCount())
				{
					return 1;
				}
				else if(((SongInfo) o1).getPlayCount() < ((SongInfo) o2).getPlayCount())
				{
					return -1;
				}
				else
				{
					if(((SongInfo) o1).getArtist().compareTo(((SongInfo) o2).getArtist()) == 1)
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
		
		songs.stream()
		.filter(x -> x.getPlayCount() > 70)
		.sorted(c)
		.map(x -> x.getSongAndArtist())
		.distinct()
		.forEach(System.out::println);	
	}
	
	public static void printSongsTitlesContainApostrophe(List<SongInfo> songs)
	{
		Comparator<SongInfo> c = new Comparator<SongInfo>() 
		{

			@Override
			public int compare(SongInfo o1, SongInfo o2) 
			{
				if(o1.getPlayCount() < o2.getPlayCount())
					return 1;
				else if(o1.getPlayCount() > o2.getPlayCount())
					return -1;
				else
					return 0;
			}
			
		};
		
		songs.stream()
		.filter(x -> x.getName().contains("\'"))
		.sorted(c)
		.map(x -> x.getName())
		.distinct()
		.forEach(System.out::println);
		
				
	}

}
