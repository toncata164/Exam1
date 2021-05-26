package exam.alexander;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

	public static List<ClassicRockSongList> parse(String filePath) {

		List<ClassicRockSongList> classicRockSongList = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			lines.remove(0);

			for (String line : lines) {
				try {
					String[] args = line.split(",");

					String nameOfTheSong = args[0];
					String nameOfTheArtist = args[1];
					String releaseYear = args[2];
					String combined = args[3];
					String first = args[4];
					int year = Integer.parseInt(args[5]);
					int playCount = Integer.parseInt(args[6]);
					int numberOfPlaysOfTheSongAcrossAllStations = Integer.parseInt(args[7]);

					ClassicRockSongList info = new ClassicRockSongList();
					info.setNameOfTheSong(nameOfTheSong);
					info.setNameOfTheArtist(nameOfTheArtist);
					if (releaseYear == "") 
					{
						info.setReleaseYear("-1");
					}
					else 
					{
						info.setReleaseYear(releaseYear);
					}
					info.setCombined(combined);
					info.setFirst(first);
					info.setYear(year);
					info.setPlayCount(playCount);
					info.setNumberOfPlaysOfTheSongAcrossAllStations(numberOfPlaysOfTheSongAcrossAllStations);
					
					classicRockSongList.add(info);
				} 
				catch (java.lang.NumberFormatException ex) {
					System.out.println();
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return classicRockSongList;

	}

}
