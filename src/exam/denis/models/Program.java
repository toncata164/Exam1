package exam.denis.models;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Program
{

	public static void main(String[] args)
	{
		List<Song> songs = CsvParser.parse("Exam1-master/src/exam/resources/classic-rock-song-list.csv");
		System.out.println(songs.size());
		
		functionSeparator("printAllSongsWithNamesStartingWithVowel: ");
		printAllSongsWithNamesStartingWithVowel(songs);
		
		functionSeparator("printAllSongsNamesWithMoreThan100Plays: ");
		printAllSongsNamesWithMoreThan100Plays(songs);
		
		functionSeparator("songsBetween1975And1980Count: ");
		songsBetween1975And1980Count(songs);
		
		functionSeparator("printSongNamesAndArtistsWithMax20PlaysSorted: ");
		printSongNamesAndArtistsWithMax20PlaysSorted(songs);
		
		functionSeparator("printSongNamesWithMoreThan2WordsInTheNameSortedByPlays: ");
		printSongNamesWithMoreThan2WordsInTheNameSortedByPlays(songs);
	}
	
	private static void functionSeparator(String text)
	{
		System.out.println();
		System.out.println(text);
		System.out.println();
	}
	
	private static void printAllSongsWithNamesStartingWithVowel(List<Song> songs)
	{
		Stream<Song> stream = songs.stream();
		
		stream.filter(x -> 
		{
			switch(x.getName().charAt(0))
			{
			case('A'):
			case('O'):
			case('I'):
			case('E'):
			case('U'):
				return true;
			default:
				return false;
			}
		}).forEach(x ->
		{
			System.out.println(x.getName());
		});
	}
	
	private static void printAllSongsNamesWithMoreThan100Plays(List<Song> songs)
	{
		Stream<Song> stream = songs.stream();
		
		stream.filter(x ->
		{
			if(x.getPlaysCount() > 100)
			{
				return true;
			}
			return false;
		}).forEach(x ->
		{
			System.out.println(x.getName());
		});;
	}
	
	private static void songsBetween1975And1980Count(List<Song> songs)
	{
		Stream<Song> stream = songs.stream();
		
		System.out.println(stream.filter(x ->
		{
			if(x.getYear() >= 1975 && x.getYear() <= 1980)
			{
				return true;
			}
			return false;
		}).count());
	}
	
	private static void printSongNamesAndArtistsWithMax20PlaysSorted(List<Song> songs)
	{
		Stream<Song> stream = songs.stream();
		
		stream.filter(x ->
		{
			if(x.getPlaysCount() <= 20)
			{
				return true;
			}
			return false;
		}).sorted(new Comparator<Song>()
		{
			@Override
			public int compare(Song arg0, Song arg1)
			{
				if(arg0.getName().equals(arg1.getName()))
				{
					if(arg0.getPlaysCount() > arg1.getPlaysCount())
					{
						return 1;
					}
					else if(arg0.getPlaysCount() < arg1.getPlaysCount())
					{
						return -1;
					}
					return 0;
				}
				
				if(arg0.getPlaysCount() > arg1.getPlaysCount())
				{
					return -1;
				}
				else if(arg0.getPlaysCount() < arg1.getPlaysCount())
				{
					return 1;
				}
				
				return 0;
			}
	    }).forEach(x ->
		{
			System.out.println(x.getName() + x.getArtist());
		});
	}
	
	private static void printSongNamesWithMoreThan2WordsInTheNameSortedByPlays(List<Song> songs)
	{
		Stream<Song> stream = songs.stream();
		
		stream.filter(x ->
		{
			String[] nameSplited = x.getName().split(" ");
			
			if(nameSplited.length >= 2)
			{
				return true;
			}
			
			return false;
		}).sorted(new Comparator<Song>()
		{
			@Override
			public int compare(Song arg0, Song arg1)
			{				
				if(arg0.getPlaysCount() > arg1.getPlaysCount())
				{
					return 1;
				}
				else if(arg0.getPlaysCount() < arg1.getPlaysCount())
				{
					return -1;
				}
				
				return 0;
			}
	    }).forEach(x ->
		{
			System.out.println(x.getName() + x.getArtist());
		});
	}
}
