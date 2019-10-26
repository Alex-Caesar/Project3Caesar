
public class MesoAsciiCal extends MesoAsciiAbstract 
{

	public MesoAsciiCal(MesoStation mesoStation) {
		
		
	}
	
	public void getletterAvg() {
		// vals to find
		double charAverage = 0;
		int asciiCeil = 0;
		int asciiFloor = 0;
		int asciiAvNum = 0;
		// loop for adding ascii
		for (int i = 0; i < length; i++) {
			charAverage += asciiVals[i];
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
	}
   
}