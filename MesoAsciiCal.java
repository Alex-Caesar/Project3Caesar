
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	
//	private ArrayList<MesoStation> stationsAVG;
//	private ArrayList<MesoStation> statsForToString;
	String LetterstID;
	char c;
	char[] charArray;
	int letterAvg;
	int[] asciiVals;
	int[] asciiAV;
	int length;
	char asciiAvChar;

	public MesoAsciiCal(MesoStation mesoStation) {
//		this.stationsAVG = new ArrayList<MesoStation>(10);
//		try {
//			this.readIn("Mesonet.txt");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//this.LetterstID = stID;
		this.LetterstID=mesoStation.getStID();
		this.length = 4;
		this.charArray = new char[length];
		this.asciiVals = new int[length];
		this.asciiAV = new int[length];
		this.createCharArray();
		this.createAsciiArray();
		this.calAverage();
		
	}
	
	public void createCharArray() {
		charArray[0] = LetterstID.charAt(0);
		charArray[1] = LetterstID.charAt(1);
		charArray[2] = LetterstID.charAt(2);
		charArray[3] = LetterstID.charAt(3);
	}

	public void createAsciiArray() {
		asciiVals[0] = (int) charArray[0];
		asciiVals[1] = (int) charArray[1];
		asciiVals[2] = (int) charArray[2];
		asciiVals[3] = (int) charArray[3];
	}
	
	public int calAverage() {
		
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
   
}