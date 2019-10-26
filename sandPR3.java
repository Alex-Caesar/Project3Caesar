import java.io.IOException;
import java.util.HashMap;

public class sandPR3 {

	public static void main(String[] args)throws IOException {
		
	DateTimeOne DateTimeOneTest=new DateTimeOne();
	
	DateTimeOneTest.getValueOfSecond();
	
	//DateTimeOneTest.sleepForFiveSec();
	DateTimeOneTest.getValueOfSecond();
		
	DateTimeOneTest.dateTimeNow();
	
	DateTimeOneTest.dateTimeOfOtherCity();
	
	DateTimeOneTest.dateTimeDifferentZone();
	
	DateTimeOneTest.timeZoneHashMap();
	
	DateTimeTwo dateTimeTwoTest;

	dateTimeTwoTest = new DateTimeTwo();
	
	dateTimeTwoTest.daysOfCurrentMonth();
	
	dateTimeTwoTest.daysOfAnyMonth(10, 2019);
    dateTimeTwoTest.daysOfAnyMonth(11, 2019);
    
    dateTimeTwoTest.compareYear();
    
    dateTimeTwoTest.dateHashMap();
    System.out.println();
    dateTimeTwoTest.dateHashMapSorted();
    
    String stId = "OKCE";
	MesoAsciiCal asciiAverage = new MesoAsciiCal(new MesoStation(stId));
	int asciiAvg = asciiAverage.calAverage();		

	HashMap<String, Integer> asciiVal = new HashMap<String, Integer>();
	asciiVal.put(stId, asciiAvg);
	System.out.print("ASCII average: ");
	System.out.println(asciiAvg);
	
	}

}
