package exam.anastasiqn;

import java.util.List;

public class Main
{

	public static void main(String[] args)
	{
		List<DeathInfo> temperatureInfos = FileParser.parseFile("src/exam/resources/police_killings.csv");
		System.out.println(temperatureInfos.size());
		//
	}

}
