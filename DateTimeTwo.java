import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.format.DateTimeFormatter;

public class DateTimeTwo extends DateTimeOne {

	private HashMap<LocalDate, Integer> dateHashMap;
	private HashMap<LocalDate, Integer> dateHashMapSorted;
	
	public DateTimeTwo() throws IOException {
		super();
		this.dateHashMap = new HashMap<LocalDate, Integer>();
		this.dateHashMapSorted = new HashMap<LocalDate, Integer>();
		this.readIn("Dates.txt");
	}

	public void daysOfCurrentMonth() {
		LocalDateTime docmFinder = super.getNow();

		int monthTen = docmFinder.getMonth().getValue();
		int yearTen = docmFinder.getYear();
		LocalDate ten = LocalDate.of(yearTen, monthTen, 10);
		String tenthDay = ten.getDayOfWeek().toString();

		LocalDate eighteen = LocalDate.of(yearTen, monthTen, 18);
		String eighteenthtDay = eighteen.getDayOfWeek().toString();

		System.out.println("The tenth day of this month is " + tenthDay + " and eighteenth is " + eighteenthtDay);

	}

	public void daysOfAnyMonth(int monthNum, int yearNum) {

		int month = monthNum;
		int year = yearNum;
		LocalDate temp15 = LocalDate.of(year, month, 15);
		String fifteenthDay = temp15.getDayOfWeek().toString();
		
		int days=temp15.lengthOfMonth();
		LocalDate tempLast = LocalDate.of(year, month, days);
		String lastDay = tempLast.getDayOfWeek().toString();
		
		System.out.println("For the year ("+year+") and month ("+month+"), the fifteenth day is "+fifteenthDay+" and the last day is "+lastDay);
	}

	public void readIn(String filename) throws IOException {
		// creating BufferReader
		BufferedReader datesRead = new BufferedReader(new FileReader(filename));

		// date formating
		DateTimeFormatter readInFormat = DateTimeFormatter.ofPattern("MM.dd.yyyy");
		// read in to get rid of first five line
		String tempRead = datesRead.readLine();

		// while loop for reading in and making players
		Integer i = 0;
		while (tempRead != null) {
			LocalDate tempLD = LocalDate.parse(tempRead, readInFormat);
			dateHashMap.put(tempLD, i);

			i++;
			tempRead = datesRead.readLine();
		}
		datesRead.close();
	}

	public void compareYear() {

		int yearToCheck = super.getNow().getYear();
		int monthToCheck = super.getNow().getMonthValue();
		int dayToCheck = super.getNow().getDayOfMonth();

		int years = 0;
		int months = 0;
		int days = 0;

		String maybeNot = "";

		for (Map.Entry<LocalDate, Integer> check : dateHashMap.entrySet()) {
			// checking for leapYear
			if (check.getKey().isLeapYear() == false) {
				maybeNot = "not";
			}
			// getting vals
			years = check.getKey().getYear();
			months = check.getKey().getMonthValue();
			days = check.getKey().getDayOfMonth();

			// getting diff
			// yearToCheck-=years;
			// monthToCheck-=months;
			// dayToCheck-=days

			Period p = Period.between(check.getKey(), super.getNow().toLocalDate());

			String out = String.format("%d  is %s a leap year, and Difference: %d years, %d months, and %d days.",
					years, maybeNot, p.getYears(), p.getMonths(), p.getDays());

			System.out.println(out);

			maybeNot = "";
		}

	}

	public void dateHashMap() {

		// printing loop
		for (Map.Entry<LocalDate, Integer> printer : dateHashMap.entrySet()) {

			System.out.println(printer.getKey().toString() + ":" + printer.getValue());

		}

	}

	public void dateHashMapSorted() {

		ArrayList<LocalDate> sorter = new ArrayList<LocalDate>(dateHashMap.keySet());
		
		Collections.sort(sorter);
		
		//Collections.reverse(sorter);
		for (int i=0;i<sorter.size();i++) {
			dateHashMapSorted.put(sorter.get(i),dateHashMap.get(sorter.get(i)));
		}
		
		for (int i=0;i<sorter.size();i++) {

			System.out.println(sorter.get(i).toString() + ":" + dateHashMap.get(sorter.get(i)));

		}

	}

}
