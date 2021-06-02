package exam.boris;

import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<SongInfo> songInfos=Parser.parse("C:\\Users\\2017_borisbs\\git\\Exam1\\src\\exam\\resources\\fight-songs.csv");
		System.out.println(songInfos.size());
		songNamesThatStartsWithSpecificLetter(songInfos);
		System.out.println();
		songNamesCreatedBetween1900And1950(songInfos);
		System.out.println();
		countOfSongsThatHaveMoreThenOneWriter(songInfos);
		System.out.println();
		songAndWritersNamesSorteddByDuration(songInfos);
		System.out.println();
		songNamesSorteddBySize(songInfos);

	}
	
	public static void songNamesThatStartsWithSpecificLetter(List<SongInfo> songInfos) 
	{
		songInfos.stream().filter(x -> x.getName().startsWith("A") || x.getName().startsWith("O") 
				|| x.getName().startsWith("U") || x.getName().startsWith("E") || x.getName().startsWith("I") 
				).map(x -> x.getName()).forEach(x -> System.out.println(x));
	}
	public static void songNamesCreatedBetween1900And1950(List<SongInfo> songInfos) 
	{
		songInfos.stream().filter(x -> x.getYear()>= 1900 && x.getYear()<=1950)
		.map(x -> x.getName()).forEach(x -> System.out.println(x));
	}
	public static void countOfSongsThatHaveMoreThenOneWriter(List<SongInfo> songInfos) 
	{
		System.out.println(songInfos.stream().filter(x -> x.getWritersCount() !=1).count());
	}
	public static void songAndWritersNamesSorteddByDuration(List<SongInfo> songInfos) 
	{
		Comparator <SongInfo> c = new Comparator<SongInfo>() {

			@Override
			public int compare(SongInfo c1, SongInfo c2) {
				if(c1.getSec_duration()>c2.getSec_duration()) 
				{
					return -1;
				}else if(c1.getSec_duration()<c2.getSec_duration()) 
				{
					return 1;
				}else if(c1.getName().charAt(0) > c2.getName().charAt(0)) 
				{
					return 1;
				}
				else if(c1.getName().charAt(0) < c2.getName().charAt(0)) 
				{
					return -1;
				}
				return 0;
				
			}
			
		};
		
		songInfos.stream().filter(x -> x.isNonsense()==true && x.getSec_duration()>0).sorted(c).
		forEach(x -> System.out.println("SongName:"+x.getName()+" ,Writers: "+ x.getWriters()));
	}
	public static void songNamesSorteddBySize(List<SongInfo> songInfos) 
	{
		Comparator <SongInfo> c = new Comparator<SongInfo>() {

			@Override
			public int compare(SongInfo c1, SongInfo c2) {
				if(c1.getName().length() > c2.getName().length()) 
				{
					return -1;
				}else if(c1.getName().length() < c2.getName().length()) 
				{
					return 1;
				}else if(c1.getName().charAt(0) > c2.getName().charAt(0)) 
				{
					return -1;
				}
				else if(c1.getName().charAt(0) < c2.getName().charAt(0)) 
				{
					return 1;
				}
				return 0;
				
			}
			
		};
		
		songInfos.stream().filter(x -> x.getName().contains(" ")).sorted(c).map(x -> x.getName())
		.forEach(x -> System.out.println(x));
	}
	
	

}
