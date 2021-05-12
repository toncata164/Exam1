package exam.anastasiyat;

import java.util.List;

public class Main {

	public static void main(String[] args) 
	{
		List<Information> information = ParseCsvFile.parse("src/exam/resources/police_killings.csv");
	}

}
