package exam.alexander;

import java.util.List;

public class Test {

	public static void main(String[] args) 
	{
		List<PoliceInfo> info = CsvParser.parse("src/exam/resources/police_killings.csv");
		System.out.println(info.size());
	}

}
