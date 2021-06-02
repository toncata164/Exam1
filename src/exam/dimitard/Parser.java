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
		Path path = Paths.get("./src/exam/resources/fight-songs.csv");
		
		List <Song> songs = new ArrayList<>();
		
		try {
			List <String> allLines = Files.readAllLines(path,StandardCharsets.UTF_8);
			allLines.remove(0);
			
			for(String line : allLines) {
				String[] lines = line.split(",");
				if(lines.length!=23) {
					for(int i = 0;i<lines.length-1;i++) {
						if(lines[i+1].charAt(0)==' ') {
							lines[i] = lines[i] + "," + lines[i+1];
							for(int j = i+1; j < lines.length-1;j++) {
								lines[j]=lines[j+1];
								
							}
							i--;
						}
					}
					String name = lines[2];
					String writers = lines[3];
					
					int year = 0;
					if(lines[4].equals("Unknown")) {
						year = -1;
					}
					else {
						year = Integer.parseInt(lines[4]);
					}
					boolean win_won = false;
					if(lines[13].equals("Yes")) {
						win_won = true;
					}
					int duration = Integer.parseInt(lines[9]);
					
					Song song = new Song (name,writers,year,win_won,duration);
					songs.add(song);
				}
				else {
					String name = lines[2];
					String writers = lines[3];
					
					int year = 0;
					if(lines[4].equals("Unknown")) {
						year = -1;
					}
					else {
						year = Integer.parseInt(lines[4]);
					}
					boolean win_won = false;
					if(lines[13].equals("Yes")) {
						win_won = true;
					}
					int duration = Integer.parseInt(lines[9]);
					
					Song song = new Song (name,writers,year,win_won,duration);
					songs.add(song);
				}
			}	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(songs.size());
		
		songsNameWithAOUEI(songs);
		
		System.out.println();
		
		yearBetween1935and1970(songs);
		
		System.out.println();
		
		moreThanOneWriter(songs);
		
		System.out.println();
		
		hasWin_Won(songs);
		
		System.out.println();
		
		checkNumberOfLetters(songs);
	}
	
	public static void songsNameWithAOUEI(List<Song> songs) {
		songs.stream().filter(x -> x.getName().charAt(0)=='A'||x.getName().charAt(0)=='O'||x.getName().charAt(0)=='U'
				||x.getName().charAt(0)=='E'||x.getName().charAt(0)=='I')
		.map(x -> x.getName())
		.forEach(x -> System.out.println(x));
	}
	
	public static void yearBetween1935and1970(List <Song> songs) {
		songs.stream().filter(x -> x.getYear()>=1935)
		.filter(x -> x.getYear() <=1970)
		.map(x -> x.getName())
		.forEach(x -> System.out.println(x));
	}
	
	public static void moreThanOneWriter(List <Song> songs) {
		System.out.println("Count: " + songs.stream().filter(x -> checkWriters(x.getWriters())).count());
	}
	
	public static boolean checkWriters(String writers) {
		if(writers.contains(",")||writers.contains(" and ")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void hasWin_Won(List<Song> songs) {
		Comparator <Song> c = new Comparator<Song>() {
			
			@Override
			public int compare(Song arg0, Song arg1) {
				// TODO Auto-generated method stub
				if(arg0.getDuration()>arg1.getDuration()) {
					return -1;
				}
				else if(arg0.getDuration()<arg1.getDuration()) {
					return 1;
				}
				else {
					if(arg0.getName().charAt(0)>arg1.getName().charAt(0)) {
						return 1;
					}
					else if(arg0.getName().charAt(0)<arg1.getName().charAt(0)) {
						return -1;
					}
					else {
						return 0;
					}
				}
			}
			
		};
		songs.stream().filter(x -> x.isWin_won()==true)
		.sorted(c)
		.forEach(x -> System.out.println(x.getName() + " by " + x.getWriters() ));
	}
	
	public static void checkNumberOfLetters(List<Song> songs) {
		Comparator <Song> c = new Comparator<Song>() {

			@Override
			public int compare(Song o1, Song o2) {
				if(getNumberOfLetters(o1.getName())>getNumberOfLetters(o2.getName())) {
					return 1;
				}
				else if(getNumberOfLetters(o1.getName())<getNumberOfLetters(o2.getName())) {
					return -1;
				}
				else {
					if(o1.getName().charAt(0)>o2.getName().charAt(0)) {
						return 1;
					}
					else if(o1.getName().charAt(0)<o2.getName().charAt(0)) {
						return -1;
					}
					else {
						return 0;
					}
				}
			}
			
		};
		songs.stream().filter(x -> getNumberOfLetters(x.getName())>=10)
		.sorted(c)
		.map(x -> x.getName())
		.forEach(x -> System.out.println(x));
	}
	
	public static int getNumberOfLetters(String name) {
		String temp[] = name.split(" "+"'"+"!"+"."+"("+")");
		String result = "";
		for(int i = 0; i < temp.length;i++) {
			result = result+temp[i];
		}
		return result.length();
	}
}
