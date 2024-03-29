import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.zone.*;

public class DateTimeOne extends MesoDateTimeOneAbstract {

	// objects to use in class
	private LocalDate dateNow;
	private LocalTime timeNow;

	private LocalDateTime now;

	private SimpleDateFormat dateFormat;

	private HashMap<String, String> timeZoneHashMap;
	private final HashMap<String, String> timeZoneHashMap2;

	Object[] sorterKey;
	Object[] sorterValue;

	ArrayList<LocalDateTime> dateTimeAL = new ArrayList<>();

	private final LocalDateTime ASTval;
	private final LocalDateTime ZSTval;

	private final LocalDateTime GMTval;
	private final LocalDateTime BSTval;
	private final LocalDateTime CSTval;

	private final ZoneId GMT;
	private final ZoneId BST;
	private final ZoneId CST;

	public DateTimeOne() {
		// initialized variables
		DateTimeFormatter formatForHash = DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm a");

		this.dateNow = LocalDate.now();
		this.timeNow = LocalTime.now();
		this.now = LocalDateTime.now();

		this.sorterKey = new String[5];
		this.sorterValue = new String[5];

		// intialize hashMap
		this.timeZoneHashMap = new HashMap<String, String>();
		this.timeZoneHashMap2 = new HashMap<String, String>();

		// get hashmap values
		this.ASTval = LocalDateTime.of(2019, 4, 3, 5, 23, 55);
		this.ZSTval = LocalDateTime.of(2020, 7, 6, 2, 5, 23);

		// TODO not sure how to use this yet
		this.GMT = ZoneOffset.UTC;
		this.BST = ZoneId.of("Asia/Dhaka");
		this.CST = ZoneId.of("America/Chicago");

		// convert to Strings for input to Hash

		String ASTtoHash = ASTval.format(formatForHash);
		String ZSTtoHash = ZSTval.format(formatForHash);

		ZonedDateTime gmtZDT = ZonedDateTime.now(GMT);
		String GMTtoHash = gmtZDT.format(formatForHash);

		ZonedDateTime bstZDT = ZonedDateTime.now(BST);
		String BSTtoHash = bstZDT.format(formatForHash);

		String CSTtoHash = now.format(formatForHash);

		// putting into an arrayList
		dateTimeAL.add(ASTval);
		this.BSTval = bstZDT.toLocalDateTime();
		dateTimeAL.add(BSTval);
		this.CSTval = now;
		dateTimeAL.add(CSTval);
		this.GMTval = gmtZDT.toLocalDateTime();
		dateTimeAL.add(GMTval);
		dateTimeAL.add(ZSTval);

	}

	@Override
	int getValueOfSecond() {
		int outSec = CSTval.getSecond();
		String out = "The value of Second now: " + outSec;
		System.out.println(out);
		return outSec;
	}

	@Override
	void dateTimeNow() {
		DateTimeFormatter currentOut = DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm a");
		String outNow = CSTval.format(currentOut);
		System.out.println("Current Date/Time: " + outNow);
	}

	@Override
	void sleepForFiveSec() {
		// SLEEP

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	void dateTimeOfOtherCity() {

		String timeOnServer = CSTval.format(DateTimeFormatter.ofPattern("kk:mm"));
		System.out.println("Time on Server: " + timeOnServer);

		String gmtTime = GMTval.format(DateTimeFormatter.ofPattern("kk:mm"));
		System.out.println("GMT: " + gmtTime);

		String bstTime = BSTval.format(DateTimeFormatter.ofPattern("kk:mm"));
		System.out.println("BST (90E): " + bstTime);

		String cstTime = BSTval.format(DateTimeFormatter.ofPattern("kk:mm"));
		System.out.println("CST (90W): " + cstTime);
	}

	@Override
	void dateTimeDifferentZone() {

		String gmtTime = GMTval.format(DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm"));
		System.out.println("GMT: " + gmtTime);

		String bstTime = BSTval.format(DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm"));
		System.out.println("BST: " + bstTime);

		String cstTime = CSTval.format(DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm"));
		System.out.println("CST: " + cstTime);

	}

	@Override
	void timeZoneHashMap() {
		//TODO fix this
		DateTimeFormatter formatForHash = DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm a");
		

		String ASTtoHash = ASTval.format(formatForHash);
		String ZSTtoHash = ZSTval.format(formatForHash);

		ZonedDateTime gmtZDT = ZonedDateTime.now(GMT);
		String GMTtoHash = gmtZDT.format(formatForHash);

		ZonedDateTime bstZDT = ZonedDateTime.now(BST);
		String BSTtoHash = bstZDT.format(formatForHash);

		String CSTtoHash = now.format(formatForHash);

		// put into hashMap
		timeZoneHashMap.put("BST", BSTtoHash);
		timeZoneHashMap.put("AST", ASTtoHash);
		timeZoneHashMap.put("CST", CSTtoHash);
		timeZoneHashMap.put("ZST", ZSTtoHash);
		timeZoneHashMap.put("GMT", GMTtoHash);

		ArrayList<String> sorter = new ArrayList<String>(timeZoneHashMap.keySet());
		Collections.sort(sorter);

		for (int i = 0; i < sorter.size(); i++) {
			timeZoneHashMap2.put(sorter.get(i).toString(), timeZoneHashMap.get(sorter.get(i)));
		}

		/* I guess sort and work on hashmaps?? */

		// putting into arrays
		sorterKey = timeZoneHashMap.keySet().toArray();
		sorterValue = timeZoneHashMap.values().toArray();

		System.out.println("Print Style 1:");
		String cutAST = timeZoneHashMap.get("AST");
		cutAST = cutAST.substring(0, 16);
		System.out.println("AST " + cutAST);

		String cutBST = timeZoneHashMap.get("BST");
		cutBST = cutBST.substring(0, 16);
		System.out.println("BST " + cutBST);

		String cutCST = timeZoneHashMap.get("CST");
		cutCST = cutCST.substring(0, 16);
		System.out.println("CST " + cutCST);

		String cutGMT = timeZoneHashMap.get("GMT");
		cutGMT = cutGMT.substring(0, 16);
		System.out.println("GMT " + cutGMT);

		String cutZST = timeZoneHashMap.get("ZST");
		cutZST = cutZST.substring(0, 16);
		System.out.println("ZST " + cutZST);

		System.out.println("Print Style 3:");

		System.out.println(cutAST);
		System.out.println(cutCST);
		System.out.println(cutGMT);
		System.out.println(cutBST);
		System.out.println(cutZST);

		System.out.println("Print Style 5: Final sorted Array:");

		String T = "T";

		String astP5 = ASTval.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String astP5Add = ASTval.format(DateTimeFormatter.ofPattern("kk:mm"));
		astP5 = astP5.concat(T);
		astP5 = astP5.concat(astP5Add);
		System.out.println(astP5);

		String bstP5 = BSTval.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String bstP5Add = BSTval.format(DateTimeFormatter.ofPattern("kk:mm"));
		bstP5 = bstP5.concat(T);
		bstP5 = bstP5.concat(bstP5Add);
		System.out.println(bstP5);

		String gmtP5 = GMTval.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String gmtP5Add = GMTval.format(DateTimeFormatter.ofPattern("kk:mm"));
		gmtP5 = gmtP5.concat(T);
		gmtP5 = gmtP5.concat(gmtP5Add);
		System.out.println(gmtP5);

		String cstP5 = CSTval.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String cstP5Add = CSTval.format(DateTimeFormatter.ofPattern("kk:mm"));
		cstP5 = cstP5.concat(T);
		cstP5 = cstP5.concat(cstP5Add);
		System.out.println(cstP5);

		String zstP5 = ZSTval.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String zstP5Add = ZSTval.format(DateTimeFormatter.ofPattern("kk:mm"));
		zstP5 = zstP5.concat(T);
		zstP5 = zstP5.concat(zstP5Add);
		System.out.println(zstP5);
	}

	public LocalDate getDateNow() {
		return dateNow;
	}

	public LocalTime getTimeNow() {
		return timeNow;
	}

	public LocalDateTime getNow() {
		return now;
	}

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public HashMap<String, String> getDateTimeOne() {
		return timeZoneHashMap;
	}

	public HashMap<String, String> getDateTimeOneNotSorted() {
		return timeZoneHashMap;
	}

	public Object[] getSorterKey() {
		return sorterKey;
	}

	public Object[] getSorterValue() {
		return sorterValue;
	}

	public ArrayList<LocalDateTime> getDateTimeAL() {
		return dateTimeAL;
	}

	public LocalDateTime getASTval() {
		return ASTval;
	}

	public LocalDateTime getZSTval() {
		return ZSTval;
	}

	public LocalDateTime getGMTval() {
		return GMTval;
	}

	public LocalDateTime getBSTval() {
		return BSTval;
	}

	public LocalDateTime getCSTval() {
		return CSTval;
	}

	public ZoneId getGMT() {
		return GMT;
	}

	public ZoneId getBST() {
		return BST;
	}

	public ZoneId getCST() {
		return CST;
	}

}