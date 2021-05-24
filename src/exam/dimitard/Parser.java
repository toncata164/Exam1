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
		Path path = Paths.get("src/exam/resources/police_killings.csv").toAbsolutePath();
		
		List<Profile> profiles = new ArrayList<>();
		
		try {
			List<String> allLines = Files.readAllLines(path,StandardCharsets.UTF_8);
			
			allLines.remove(0);
			
			for(String line: allLines) {
				String[] lines = line.split(",");
				String name = lines[0];
				String age = lines[1];
				boolean isMan = lines[2].equals("Male");
				String race = lines[3];
				int day = Integer.parseInt(lines[5]);
				int year = Integer.parseInt(lines[6]);
				Date date = new Date(lines[4],day,year);
				String state = lines[9];
				String cause = lines[19];
				
				Profile person = new Profile (name,isMan,race,date,state,cause,age);
				profiles.add(person);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(profiles.size());
		
		 
		
		whiteCar(profiles);
		
		System.out.println();
		
		blackKilled(profiles);
		
		System.out.println();
		
		womenKilled(profiles);
		
		System.out.println();
		
		countWhiteCar(profiles);
		
		System.out.println();
		
		notBlackWomen(profiles);
	}
	
	public static void whiteCar(List<Profile> profiles) {
		
		Comparator<Profile> c = new Comparator<Profile>()
		{

			@Override
			public int compare(Profile o1, Profile o2) {
				if(o1.getDate().getYear()>o2.getDate().getYear()) {
				return 1;
			}
				else if(o1.getDate().getYear()<o2.getDate().getYear()) {
					return -1;
				}
				else {
					if(o1.getDate().getMonth()>o2.getDate().getMonth()) {
						return 1;
					}
					else if(o1.getDate().getMonth()<o2.getDate().getMonth()) {
						return -1;
					}
					else {
						if(o1.getDate().getDay()>o2.getDate().getDay()) {
							return 1;
						}
						else if(o1.getDate().getDay()<o2.getDate().getDay()) {
							return -1;
						}
						else {
							return 0;
						}
					}
				}
		}
			
		};
		profiles.stream()
		.filter(x -> x.getRace().equals("White"))
		.filter(x -> x.getCause().equals("Struck by vehicle"))
		.sorted(c)
		.map(x -> x.getName())
		.forEach(x -> System.out.println(x));
				//x.getDate().getDay() +" "+ x.getDate().getMonth() + " " + x.getDate().getYear() + " " +
				
		
	}
	
	public static void blackKilled(List<Profile> profiles) {
		profiles.stream()
		.filter(x -> x.getRace().equals("Black"))
		.filter(x -> x.getDate().getYear()==2015)
		.filter(x -> x.getDate().getMonth()<=6)
		.filter(x -> x.getState().equals("CA"))
		.map(x -> x.getName())
		.forEach(x -> System.out.println(x));
			
		}
	
	public static void countWhiteCar(List<Profile> profiles) {
		System.out.println(profiles.stream()
				.filter(x -> x.getRace().equals("White"))
				.filter(x -> x.getCause().equals("Struck by vehicle"))
				.count());
	}

	
	public static void womenKilled(List<Profile> profiles) {
		System.out.println(profiles.stream()
		.filter(x -> x.getIsMan()==false)
		.filter(x ->x.getCause().equals("Struck by vehicle"))
		.filter(x -> x.getDate().getYear()==2015)
		.filter(x -> x.getDate().getMonth()<=6).count());
	}

	public static void notBlackWomen(List<Profile> profiles) {
		Comparator <Profile> c = new Comparator<>() {

			@Override
			public int compare(Profile arg0, Profile arg1) {
				if(arg0.getState().charAt(0)>arg1.getState().charAt(0)) {
					return 1;
				}
				else if(arg0.getState().charAt(0)<arg1.getState().charAt(0)) {
					return -1;
				}
				else {
					if(arg0.getState().charAt(1)>arg1.getState().charAt(1)) {
						return 1;
					}
					else if(arg0.getState().charAt(1)<arg1.getState().charAt(1)) {
						return -1;
					}
					else return 0;
				}
			}
			
		};
		Comparator <Profile> cd = new Comparator<>() {

			@Override
			public int compare(Profile o1, Profile o2) {
				if(o1.getDate().getYear()>o2.getDate().getYear()) {
				return 1;
			}
				else if(o1.getDate().getYear()<o2.getDate().getYear()) {
					return -1;
				}
				else {
					if(o1.getDate().getMonth()>o2.getDate().getMonth()) {
						return 1;
					}
					else if(o1.getDate().getMonth()<o2.getDate().getMonth()) {
						return -1;
					}
					else {
						if(o1.getDate().getDay()>o2.getDate().getDay()) {
							return 1;
						}
						else if(o1.getDate().getDay()<o2.getDate().getDay()) {
							return -1;
						}
						else {
							return 0;
						}
					}
				}
		}
			
		};
		profiles.stream()
		.filter(x -> !x.getRace().equals("Black"))
		.filter(x -> x.getIsMan()==false)
		.sorted(c)
		.sorted(cd)
		.forEach(x -> System.out.println(x.getName() + " " + x.getAge()));;
	}
}
