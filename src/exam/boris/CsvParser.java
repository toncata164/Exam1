package exam.boris;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
	public static List<PoliceInfo> parse(String filePath)
	{
		List<PoliceInfo> policeInfos= new ArrayList();
		try 
		{
			List<String> lines=Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
			lines.remove(0);
			for(String line: lines) 
			{
				String[] args=line.split(",");
				String name=args[0];
				int age=Integer.parseInt(args[1]);
				String gender=args[2];
				String raceethnicity=args[3];
				String month=args[4];
				int day=Integer.parseInt(args[5]);
				int year=Integer.parseInt(args[6]);
				String city=args[8];
				
				PoliceInfo info = new PoliceInfo(name,age,gender,
						raceethnicity,month,day,year,city);
				policeInfos.add(info);
				
			}
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		return policeInfos;
		
	}

}
