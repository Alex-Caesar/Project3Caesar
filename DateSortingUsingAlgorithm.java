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
	
	private HashMap<Integer,LocalDate> dateHashMapSorted;
	private HashMap<Integer,LocalDate> dateHashMapSortedDescending;
	
	public DateSortingUsingAlgorithm() throws IOException {
		this.dateHashMapSorted=new HashMap<Integer, LocalDate>();
		this.dateHashMapSortedDescending=new HashMap<Integer, LocalDate>();
		this.readIn("SortingDates.txt");
		this.sortHashMap(dateHashMapSorted);
		
//		this.dateHashMapSorted();
//		this.dateHashMapSortedDescending();

		
		
	}
	
	public void sortHashMap(HashMap<Integer,LocalDate> datesSorted) {
		
		ArrayList<LocalDate> sorter = new ArrayList<LocalDate>(datesSorted.values());	
		Collections.sort(sorter);
		for (int i=0;i<sorter.size();i++) {
			this.dateHashMapSorted.put(i,sorter.get(i));
		}
		
		Collections.reverse(sorter);
		
		for (int i=0;i<sorter.size();i++) {
		this.dateHashMapSortedDescending.put(i,sorter.get(i));
		}
		
		
	}

	public void dateHashMapSortedDescending() {
		for (Map.Entry<Integer, LocalDate> printer : dateHashMapSortedDescending.entrySet()) {

			System.out.println(printer.getValue().toString());

		}
	}

	public void dateHashMapSorted() {
		for (Map.Entry<Integer, LocalDate> printer : dateHashMapSorted.entrySet()) {

			System.out.println(printer.getValue().toString());

		}
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
			dateHashMapSorted.put(i,tempLD);

			i++;
			tempRead = datesRead.readLine();
		}
		datesRead.close();
	}

}
