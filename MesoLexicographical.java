import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MesoLexicographical {

	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		ArrayList<String> sorter = new ArrayList<String>(asciiVal.keySet());
		Collections.sort(sorter);

		// Collections.reverse(sorter);

		for (int i = 0; i < sorter.size(); i++) {

			System.out.println(sorter.get(i).toString() );

		}

	}

}