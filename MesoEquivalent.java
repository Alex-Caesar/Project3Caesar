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
		this.asciiAverage = this.getletterAvgstID(LetterstID);
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
		int i = 0;
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

	public int getletterAvg(String LetterstID) {
		int out=0;
		int firstOut=0;
		int secondOut=0;
		double firstSecond=0;
		
		String NMRN="NMRN";
		
		double sumAscii = 0; 
		 
        for (int i = 0; i < NMRN.length(); i++) { 
            sumAscii += (int)NMRN.charAt(i); 
        } 
        
        sumAscii=sumAscii / NMRN.length();
        
       int asciiCeil = (int) Math.ceil(sumAscii);
       int asciiFloor = (int) Math.floor(sumAscii);
		// determining average
		if (sumAscii % 100 >= 0.25) {
			firstOut = asciiCeil;
		} else {
			firstOut = asciiFloor;
		}

        sumAscii = 0; 
 
        for (int i = 0; i < LetterstID.length(); i++) { 
            sumAscii += (int)LetterstID.charAt(i); 
        } 
        
        sumAscii=sumAscii / LetterstID.length();
        
       asciiCeil = (int) Math.ceil(sumAscii);
       asciiFloor = (int) Math.floor(sumAscii);
		// determining average
		if (sumAscii % 100 >= 0.25) {
			secondOut = asciiCeil;
		} else {
			secondOut = asciiFloor;
		}
		
		firstSecond=(firstOut+secondOut)/2;
		 out=(int)Math.ceil(firstSecond);
		
        // return
        return out; 

	}
	
	public int getletterAvgstID(String LetterstID) {
		int out=0;
		int firstOut=0;
		int secondOut=0;
		double firstSecond=0;
		
		String NMRN="NMRN";
		
		double sumAscii = 0; 
		 
        for (int i = 0; i < NMRN.length(); i++) { 
            sumAscii += (int)NMRN.charAt(i); 
        } 
        
        sumAscii=sumAscii / NMRN.length();
        
       int asciiCeil = (int) Math.ceil(sumAscii);
       int asciiFloor = (int) Math.floor(sumAscii);
		// determining average
		if (sumAscii % 100 >= 0.25) {
			firstOut = asciiCeil;
		} else {
			firstOut = asciiFloor;
		}

        sumAscii = 0; 
 
        for (int i = 0; i < LetterstID.length(); i++) { 
            sumAscii += (int)LetterstID.charAt(i); 
        } 
        
        sumAscii=sumAscii / LetterstID.length();
        
       asciiCeil = (int) Math.ceil(sumAscii);
       asciiFloor = (int) Math.floor(sumAscii);
		// determining average
		if (sumAscii % 100 >= 0.25) {
			secondOut = asciiCeil;
		} else {
			secondOut = asciiFloor;
		}
		
		firstSecond=(firstOut+secondOut)/2;
		 out=(int)Math.ceil(firstSecond);
		
        // return
        letterAvg=out;
        
        return out;

	}

	public void numberOfStationWithLetterAvg() throws IOException {

		this.statsForToString = new ArrayList<MesoStation>(2);

		int size4loop = stationsAVG.size();

		for (int i = 0; i < size4loop; i++) {
			
			this.asciiAV = new int[length];
			Integer tempAsciiVal = this.getletterAvg((stationsAVG.get(i)).getStID());
			
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
