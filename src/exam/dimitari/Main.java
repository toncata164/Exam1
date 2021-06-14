package exam.dimitari;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<FightSongs> f = new ArrayList<FightSongs>();
		f.stream().filter(x ->
			!x.getSongName().startsWith("A") &&
			!x.getSongName().startsWith("O")
				).
		forEach(x -> System.out.println(x.getSongName() + x.getStudentWriter()));
		
		Comparator<FightSongs> c = new Comparator<>()
				{

					@Override
					public int compare(FightSongs o1, FightSongs o2) {
						if(o1.getSong_rah() > o2.getSong_rah())
							return 1;
						else if(o1.getSong_rah() < o2.getSong_rah())
							return -1;
						return 0;
					}
				
				};
		
		f.stream().filter(x->x.getYear() > 1950 && x.getYear() < 2000).
		sorted(c).
		forEach(x -> System.out.println(x));
		
		
	}

}
