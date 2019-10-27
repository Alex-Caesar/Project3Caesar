import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DateSortingUsingAlgorithm {
	
	private HashMap<Integer,LocalDate> datesSorted;

	public DateSortingUsingAlgorithm() throws IOException {
		
		this.readIn("SortingDates.txt");
		this.sortHashMap(datesSorted);
		this.dateHashMapSorted();
		this.dateHashMapSortedDescending();
		
		
		
	}
	
	public void sortHashMap(HashMap<Integer,LocalDate> datesSorted) {
		
		ArrayList<LocalDate> sorter = new ArrayList<LocalDate>(datesSorted.values());	
		Collections.sort(sorter);
		Collections.reverse(sorter);
		for (int i=0;i<sorter.size();i++) {
			datesSorted.put(i,sorter.get(i));
		}
		
		
	}

	public void dateHashMapSortedDescending() {
		for (Map.Entry<LocalDate, Integer> printer : datesSorted.entrySet()) {

			System.out.println(printer.getKey().toString() + ":" + printer.getValue());

		}
	}

	public void dateHashMapSorted() {
		// TODO Auto-generated method stub
		
	}
	public void readIn(String filename) throws IOException {
		// creating BufferReader
		BufferedReader datesRead = new BufferedReader(new FileReader(filename));

		// date formating
		DateTimeFormatter readInFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		
		// read in to get rid of first five line
		String tempRead = datesRead.readLine();

		// while loop for reading in and making players
		Integer i = 0;
		while (tempRead != null) {
			
			tempRead=tempRead.trim();
			tempRead=tempRead.replace(" ", "");
			LocalDate tempLD = LocalDate.parse(tempRead, readInFormat);
			datesSorted.put(i,tempLD);

			i++;
			tempRead = datesRead.readLine();
		}
		datesRead.close();
	}

}
