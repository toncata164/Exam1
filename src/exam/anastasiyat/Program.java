package exam.anastasiyat;

import java.util.List;

public class Program {

	public static void main(String[] args) 
	{
		List<Information> info = ParseCsvFile.parse("./src/exam/resources/classic-rock-song-list.csv");
		System.out.println(info.size());
		
		System.out.println();
		groupsWithCountPlayOfASongBetween20And50(info);
		
		System.out.println();
		System.out.println(groupsWithSongsBetween1975And1980(info));
		
		System.out.println();
		songsAndGroupsWithPlayCountOver100(info);
	}
	
	public static void groupsWithCountPlayOfASongBetween20And50(List<Information> info)
	{
		info.stream()
			.filter(x -> x.getPlayCount() >= 20 && x.getPlayCount() <= 50)
			.map(x -> x.getArtist())
			.distinct()
			.forEach(System.out::println);
	}
	
	public static long groupsWithSongsBetween1975And1980(List<Information> info)
	{
		return info.stream()
			.filter(x -> x.getReleaseYear() >= 1975 && x.getReleaseYear() <= 1980)
			.map(x -> x.getArtist())
			.count();
	}
	
	public static void songsAndGroupsWithPlayCountOver100(List<Information> info)
	{
		info.stream()
			.filter(x -> x.getPlayCount() > 100)
			.sorted((a, b) -> a.getPlayCount() - b.getPlayCount())
			.forEach(x -> {
				System.out.println(x.getSong() + " - " + x.getArtist());
			});
	}

}
