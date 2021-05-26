package exam.boris;

import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<SongInfo> songInfos=CsvFileParserForSongInfo.parser("C:\\Users\\2017_borisbs\\git\\Exam1\\src\\exam\\resources\\classic-rock-song-list.csv");
		System.out.println(songInfos.size());
		printSongNamesBySpecificLetterAnTheStart(songInfos);
		printArtistsNamesByTheirSongsReleasedIn1980(songInfos);
		countOfArtistsByTheirSongsReleasedBetween1975And1980(songInfos);
		printSongsAndArtistNamesSortedByPlayCount(songInfos);
		printSongsWithSpecificSymbolSortedByPlayCount(songInfos);
		
	}
	public static void printSongNamesBySpecificLetterAnTheStart(List<SongInfo> songInfos) 
	{
		songInfos.stream().filter(x -> x.getSongClean().startsWith("A") || x.getSongClean().startsWith("O")
				|| x.getSongClean().startsWith("U") || x.getSongClean().startsWith("E") ||
				x.getSongClean().startsWith("I")).map(x -> x.getSongClean())
		.forEach(x -> System.out.println(x));
	} 
	public static void printArtistsNamesByTheirSongsReleasedIn1980(List<SongInfo> songInfos) 
	{
		songInfos.stream().filter(x -> x.getReleaseYear()==1980).map(x -> x.getArtistClean())
		.distinct().forEach(x-> System.out.println(x));
	}
	public static void countOfArtistsByTheirSongsReleasedBetween1975And1980(List<SongInfo> songInfos) 
	{
		System.out.println(songInfos.stream().filter(x -> x.getReleaseYear()>=1975 
				&& x.getReleaseYear()<=1980).map(x -> x.getArtistClean()).count());
	}
	public static void printSongsAndArtistNamesSortedByPlayCount(List<SongInfo> songInfos) 
	{
		songInfos.stream().sorted(Comparator.comparingInt(SongInfo::getPlayCount)
			).filter(x-> x.getPlayCount()>70).map(x -> x.getCombined())
		.forEach(x-> System.out.println(x));
	}
	public static void printSongsWithSpecificSymbolSortedByPlayCount(List<SongInfo> songInfos) 
	{
		songInfos.stream().sorted(Comparator.comparingInt(SongInfo::getPlayCount).reversed()
			).filter(x-> x.getSongClean().contains("‘")).map(x -> x.getSongClean())
		.forEach(x-> System.out.println(x));
	}

}
