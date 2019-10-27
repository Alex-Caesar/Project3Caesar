import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MesoEquivalent {

	private ArrayList<MesoStation> stationsAVG;
	private ArrayList<MesoStation> statsForToString;

	HashMap<String, Integer> asciiEquals;

	Integer asciiAverage;

	String LetterstID;
	private char c;
	private char[] charArray;
	private int letterAvg;
	private int[] asciiVals;
	private int[] asciiAV;
	private int length;
	private char asciiAvChar;

	public MesoEquivalent(String stID) throws IOException {
		this.stationsAVG = new ArrayList<MesoStation>(10);
		this.asciiEquals = new HashMap<String, Integer>();

		try {
			this.readIn("Mesonet.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.LetterstID = stID;
		this.length = 4;
		
		this.charArray = new char[length];
		this.asciiVals = new int[length];
		this.asciiAV = new int[length];
		
		this.createArray(LetterstID);
		this.asciiAverage = this.getletterAvgstID(asciiVals);
		this.numberOfStationWithLetterAvg();
	}

	public int[] createArray(String LetterstID) {
		charArray[0] = LetterstID.charAt(0);
		charArray[1] = LetterstID.charAt(1);
		charArray[2] = LetterstID.charAt(2);
		charArray[3] = LetterstID.charAt(3);

		asciiVals[0] = (int) charArray[0];
		asciiVals[1] = (int) charArray[1];
		asciiVals[2] = (int) charArray[2];
		asciiVals[3] = (int) charArray[3];
		
		return asciiVals;
	}

	public void readIn(String filename) throws IOException {
		// creating BufferReader
		BufferedReader mesonetRead = new BufferedReader(new FileReader(filename));

		// read in to get rid of first five line
		String tempRead = mesonetRead.readLine();
		tempRead = mesonetRead.readLine();
		tempRead = mesonetRead.readLine();
		tempRead = mesonetRead.readLine();
		tempRead = mesonetRead.readLine();

		// while loop for reading in and making players
		int i = 1;
		while (tempRead != null) {
			/*
			 * if(i>=stations.length) { stations=expandArray(stations); }
			 */
			tempRead = tempRead.trim();
			tempRead = tempRead.substring(0, 4);
			MesoStation MesoTemp = new MesoStation(tempRead);
			stationsAVG.add(i, MesoTemp);
			i++;

			tempRead = mesonetRead.readLine();

		}
	}

	public int getletterAvg(int[] asciiTempVals) {
		// vals to find
		double charAverage = 0;
		int asciiCeil = 0;
		int asciiFloor = 0;
		int asciiAvNum = 0;
		// loop for adding ascii
		for (int i = 0; i < length; i++) {
			charAverage += asciiTempVals[i];
		}
		// average computation
		charAverage /= 4;
		// Math function for vals
		asciiCeil = (int) Math.ceil(charAverage);
		asciiFloor = (int) Math.floor(charAverage);
		// determining average
		if (charAverage % 100 >= 0.5) {
			asciiAvNum = asciiCeil;
		} else {
			asciiAvNum = asciiFloor;
		}
		// finding average char
		char lastChar = ((char) asciiAvNum);
		// giving asciiAv data
		asciiAV[0] = asciiCeil;
		asciiAV[1] = asciiFloor;
		asciiAV[2] = lastChar;

		this.letterAvg = asciiAvNum;
		this.asciiAvChar = lastChar;
		

		return letterAvg;
	}
	
	public int getletterAvgstID(int[] asciiTempVals) {
		// vals to find
		double charAverage = 0;
		int asciiCeil = 0;
		int asciiFloor = 0;
		int asciiAvNum = 0;
		// loop for adding ascii
		for (int i = 0; i < length; i++) {
			charAverage += asciiTempVals[i];
		}
		// average computation
		charAverage /= 4;
		// Math function for vals
		asciiCeil = (int) Math.ceil(charAverage);
		asciiFloor = (int) Math.floor(charAverage);
		// determining average
		if (charAverage % 100 >= 0.5) {
			asciiAvNum = asciiCeil;
		} else {
			asciiAvNum = asciiFloor;
		}
		// finding average char
		char lastChar = ((char) asciiAvNum);
		// giving asciiAv data
		asciiAV[0] = asciiCeil;
		asciiAV[1] = asciiFloor;
		asciiAV[2] = lastChar;

		this.letterAvg = asciiAvNum;
		this.asciiAvChar = lastChar;
		this.asciiAverage = (Integer) asciiAvNum;

		return letterAvg;
	}

	public void numberOfStationWithLetterAvg() throws IOException {

		this.statsForToString = new ArrayList<MesoStation>(2);

		int size4loop = stationsAVG.size();

		for (int i = 0; i < size4loop; i++) {
			
			this.asciiAV = new int[length];
			int[] tempIntArray=this.createArray((stationsAVG.get(i)).getStID());
			Integer tempAsciiVal = this.getletterAvg(tempIntArray);
			
			Integer threshhold = asciiAverage;
			
			if (tempAsciiVal.equals(threshhold)) {

				MesoStation addIn = stationsAVG.get(i);
				this.statsForToString.add(addIn);
			}
		}
	
	}

	public HashMap<String, Integer> calAsciiEqual() {

		for (int i = 0; i < statsForToString.size(); ++i) {
			asciiEquals.put(statsForToString.get(i).getStID(), asciiAverage);
		}

		return asciiEquals;
	}

}
