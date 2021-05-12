package exam.boris;

import java.util.List;

public class TestPoliceInfo {

	public static void main(String[] args) {
		List<PoliceInfo> policeInfos=CsvParser.parse("src/exam/resources/police_killings.csv");
	    System.out.println(policeInfos.size());

	}

}
