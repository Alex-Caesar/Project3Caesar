import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MesoEquivalent {

	private ArrayList<MesoStation> stationsAVG;
	private ArrayList<MesoStation> statsForToString;
	String LetterstID;
	char c;
	char[] charArray;
	int letterAvg;
	int[] asciiVals;
	int[] asciiAV;
	int length;
	char asciiAvChar;

	public MesoEquivalent(String stID) throws IOException {
		this.stationsAVG = new ArrayList<MesoStation>(10);
		try {
			this.readIn("SortingDates.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.LetterstID = stID;
		this.length = 4;
		this.charArray = new char[length];
		this.asciiVals = new int[length];
		this.asciiAV = new int[length];
		this.createCharArray();
		this.createAsciiArray();
		this.getletterAvg();

	}
	

	public HashMap<String, Integer> calAsciiEqual() {
		
		
		
		
		return null;
	}

	public void readIn(String filename) throws IOException {
		// creating BufferReader
		BufferedReader mesonetRead = new BufferedReader(new FileReader(filename));

		// read in to get rid of first five line
		String tempRead = mesonetRead.readLine();
		tempRead = mesonetRead.readLine();
		tempRead = mesonetRead.readLine();
		tempRead = mesonetRead.readLine();

		// while loop for reading in and making players
		int i = 0;
		while (tempRead != null) {
			/*
			 * if(i>=stations.length) { stations=expandArray(stations); }
			 */

			tempRead = tempRead.substring(1, 5);
			MesoStation MesoTemp = new MesoStation(tempRead);
			stationsAVG.add(i, MesoTemp);
			i++;

			tempRead = mesonetRead.readLine();

		}
	}
}
