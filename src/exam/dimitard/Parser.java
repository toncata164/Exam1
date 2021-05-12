package exam.dimitard;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
				boolean isMan = lines[2].equals("Male");
				String race = lines[3];
				int day = Integer.parseInt(lines[5]);
				int year = Integer.parseInt(lines[6]);
				Date date = new Date(lines[4],day,year);
				String state = lines[9];
				String cause = lines[19];
				
				Profile person = new Profile (name,isMan,race,date,state,cause);
				profiles.add(person);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void whiteCar(List<Profile> profiles) {
		
		
	}
}
