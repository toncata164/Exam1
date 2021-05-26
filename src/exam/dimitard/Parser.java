package exam.dimitard;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get("src/exam/resources/classic-rock-song-list.csv");

		List<Song> songs = new ArrayList<>();

		try {
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			allLines.remove(0);
			for (String line : allLines) {

				String[] lines = line.split(",");

				/*
				 * String nameSong = "";lines[0]; String author = "";lines[1]; int releaseYear =
				 * 0; String allData = ""; lines[3]; int timesPlayed =
				 * 0;Integer.parseInt(lines[6]); if(lines[1].charAt(0)==' '){ nameSong =
				 * lines[0]+lines[1]; if(lines[2].charAt(0)==' ') {
				 * 
				 * } } else { nameSong = lines[0]; }
				 * 
				 */
				
				if(lines.length!=8)
				{
					continue;
				}
				 else {
					String nameSong = lines[0];
					String author = lines[1];
					int releaseYear = 0;
					if (lines[2].equals("SONGFACTS.COM")) {
						releaseYear=-1;
					}
					else {
					if(!lines[2].equals("")) {
							
					
						releaseYear = Integer.parseInt(lines[2]);
					}
					else releaseYear = -1;
					String allData = lines[3];
					int timesPlayed = Integer.parseInt(lines[6]);
					

				Song song = new Song(nameSong, author, releaseYear, allData, timesPlayed);
				songs.add(song);
				 }}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(songs.size());
		System.out.println();
		
		checkName(songs);
		
		System.out.println();
		
		timesPlayedBetween20and50(songs);
		
		System.out.println();
		
		releasedBetween1975and1980(songs);
		
		System.out.println();
		
		sortMoreThan100TimesPlayed(songs);
		
		System.out.println();
	}
	
	public static void checkName(List<Song> songs) {
		songs.stream().map(x -> x.getAuthor())
		.filter(x -> !x.contains("."))
		.filter(x -> !x.contains("-"))
		.filter(x -> !x.contains("/"))
		.filter(x -> !x.contains("0"))
		.filter(x -> !x.contains("1"))
		.filter(x -> !x.contains("2"))
		.filter(x -> !x.contains("3"))
		.filter(x -> !x.contains("4"))
		.filter(x -> !x.contains("5"))
		.filter(x -> !x.contains("6"))
		.filter(x -> !x.contains("7"))
		.filter(x -> !x.contains("8"))
		.filter(x -> !x.contains("9"))
		.filter(x -> !x.contains("II"))
		.filter(x -> !x.contains("&"))
		.filter(x -> !x.contains("'"))
		.distinct().forEach(x -> System.out.println(x));
	}
	
	public static void 	timesPlayedBetween20and50(List<Song> songs) {
		
		songs.stream()
		.filter(x -> x.getTimesPlayed()<=50)
		.filter(x -> x.getTimesPlayed()>=20)
		.map(x -> x.getAuthor())
		.distinct()
		.forEach(x -> System.out.println(x));
	}
	
	public static void releasedBetween1975and1980(List<Song> songs){
		System.out.println(songs.stream()
				.filter(x -> x.getReleaseYear()>=1975)
				.filter(x -> x.getReleaseYear()<=1980)
				.count());
	}
	
	public static void sortMoreThan100TimesPlayed(List<Song> songs) {
		Comparator<Song> c = new Comparator <Song> () {

			@Override
			public int compare(Song arg0, Song arg1) {
				if(arg0.getTimesPlayed()>arg1.getTimesPlayed())
				return -1;
				else if(arg0.getTimesPlayed()<arg1.getTimesPlayed()) {
					return 1;
				}
				else {
					if(arg0.getSongName().length()>arg1.getSongName().length()) {
						for(int i = 0; i < arg1.getSongName().length();i++) {
							
							 if(arg0.getSongName().charAt(i)>arg1.getSongName().charAt(i)) {
								return -1;
							}
							else if(arg0.getSongName().charAt(i)<arg1.getSongName().charAt(i)) {
								return 1;
							}
							
						}
							return 0;
				}
					else {
						for(int i = 0; i < arg0.getSongName().length();i++) {
							
							if(arg0.getSongName().charAt(i)<arg1.getSongName().charAt(i)) {
								return -1;
							}
							else if(arg0.getSongName().charAt(i)>arg1.getSongName().charAt(i)) {
								return 1;
							}
							
						}
							return 0;
					}
			}
				}
			
		};
		songs.stream().filter(x -> x.getTimesPlayed()>100).sorted(c).forEach(x -> System.out.println(x.getAllData() + " " + x.getTimesPlayed()));
	}
	
}
