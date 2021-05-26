package exam.gergana;

import java.util.Comparator;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Test {

	public static void main(String[] args) 
	{
		List<SongInformation> infos = Parser.parse("C:\\Users\\2017_gerganadd\\git\\Exam1\\src\\exam\\resources\\classic-rock-song-list.csv");

		
		//print2(infos);
		//System.out.println("Songs: " + count3(infos));
		//print4(infos);
		//print5(infos);
		
	}
	
	public static void printNamesStartWithNoLetter(List<SongInformation> infos)
	{
		infos.stream()
		.map(x -> x.getSong())
		.filter(x -> x.startsWith(!(x >= 'A' && x <= 'Z'))
		.forEach(x -> System.out.println(x));
	}
	
	public static void print2(List<SongInformation> infos)
	{
		infos.stream()
		.filter(x -> x.getPlayCount() < 20)
		.map(x -> x.getArtist())
		.distinct()
		.forEach(x -> System.out.println(x));
	}
	
	public static int count3(List<SongInformation> infos)
	{
		int counter = 0;
		
		counter = (int)infos.stream()
		.filter(x -> (x.getYear() >= 1975 && x.getYear() <= 1980)).map(x -> x.getSong())
				.count();
		return counter;
	}
	
	public static void print4(List<SongInformation> infos)
	{
		Comparator<SongInformation> c = new Comparator()
		{
			@Override
			public int compare(Object arg0, Object arg1) 
			{
				SongInformation first = (SongInformation)arg0;
				SongInformation second = (SongInformation)arg0;
				
				if(first.getPlayCount() > second.getPlayCount())
				{
					return 1;
				}
				else if(first.getPlayCount() < second.getPlayCount())
				{
					return -1;
				}
				else
				{
					if(first.getSong().compareTo(second.getSong()) > 0)
						return 1;
					else if(first.getSong().compareTo(second.getSong()) < 0)
						return -1;
					
					
					return 0;
				}
				
			}
			
		};
		
		infos.stream()
		.filter(x -> (x.getPlayCount() > 100))
		.sorted(c)
		.forEach(x -> System.out.println(x.getArtist() + " , " + x.getSong()));
		
	}

	public static void print5(List<SongInformation> infos)
	{
		
		Comparator<SongInformation> c = new Comparator()
		{
			@Override
			public int compare(Object arg0, Object arg1) 
			{
				SongInformation first = (SongInformation)arg0;
				SongInformation second = (SongInformation)arg0;
				
				if(first.getPlayCount() > second.getPlayCount())
				{
					return 1;
				}
				else if(first.getPlayCount() < second.getPlayCount())
				{
					return -1;
				}
				return 0;
			}
			
		};
		
		
		infos.stream()
		.filter(x -> SongInformation.countLetters(x.getSong()))
		.sorted(c)
		.forEach(x -> System.out.println(x.getSong()));
	}
}
