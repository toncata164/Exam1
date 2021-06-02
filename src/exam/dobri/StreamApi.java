package exam.dobri;

import java.util.Comparator;
import java.util.List;

public class StreamApi {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<SongInfo> songs = CsvFileParser.parseFile
				("C:\\Users\\2017_dobriig\\git\\Exam\\src\\exam\\resources\\fight-songs.csv");
		
		
	}
	public static void songsWithFirstLetters(List<SongInfo> songs)
	{
		songs.stream().filter(x -> (int)x.getSongName().charAt(0) >=65
				&& (int)x.getSongName().charAt(0)<=75
				|| (int)x.getSongName().charAt(0) >=97
				&& (int)x.getSongName().charAt(0) <=107)
		.map(x -> x.getSongName()).forEach(System.out::println);
	}
	public static void song19Cent(List<SongInfo> songs)
	{
		songs.stream().filter(x -> x.getYear() != "Unknown" && Integer.parseInt(x.getYear())>=1800
				&& Integer.parseInt(x.getYear()) <= 1900).map(x -> x.getSongName())
		.forEach(System.out::println);
	}
	
	public static void songWithCoupleAutors(List<SongInfo> songs)
	{
		long count = songs.stream().filter(x -> x.getWriters().contains(", ")).count();
		System.out.println(count);
	}
	public static void songWithVictry(List<SongInfo> songs)
	{
		Comparator comp = new Comparator()
				{

					public int compare(SongInfo arg0, SongInfo arg1)
					{
						int result;
						result = Integer.compare(arg0.getSecDuration(), arg1.getSecDuration());
						if(result == 0)
						{
							result = arg0.getSongName().compareTo(arg1.getSongName());
						}
						return result;
					}

					@Override
					public int compare(Object o1, Object o2) {
						// TODO Auto-generated method stub
						return 0;
					}};
		songs.stream().filter(x -> x.getVictory() == "yes")
		.map(x -> x.getSongName()).sorted(comp).forEach(System.out::println);
	}
	
	public static void songWithCoupleWords(List<SongInfo> songs)
	{
		songs.stream().filter(x -> x.getSongName().contains(", ")).forEach(System.out::println);
		
	}
}
