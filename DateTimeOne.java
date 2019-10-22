import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.time.*;

public class DateTimeOne extends MesoDateTimeOneAbstract {
	// objects to use in class
	private LocalDate dateNow;
	private LocalTime timeNow;

	public DateTimeOne() {
		// initialized variables
		dateNow = LocalDate.now();
		timeNow = LocalTime.now();

	}

	@Override
	int getValueOfSecond() {
		int now = timeNow.getSecond();
		String out = "The value of Second now: " + now;

		System.out.println(out);
		return now;
	}

	@Override
	void dateTimeNow() {
		// taking string of date to change
		String date = dateNow.toString();
		String dateAdd = dateNow.toString();

		// substringing and changing for format
		date = date.substring(0, 4);
		dateAdd = dateAdd.substring(5, 10);

		// taking string of time to change
		String time = timeNow.toString();
		int hour = timeNow.getHour();
		int minute = timeNow.getMinute();

		String dayNight;
		// if to find am/pm
		if (hour > 12) {
			dayNight = "pm";
			hour-=12;
		} else {
			dayNight = "am";
		}

		// adding what is necessary
		dateAdd = dateAdd.replace("-", "/");
		String outDate = dateAdd + "/" + date;
		Integer outHour = hour;
		String outMin=time.substring(3,5);
		String outTime=outHour.toString()+":"+outMin;
	
		String out = "Current Date/Time: " + outDate + " " + outTime+" "+dayNight;

		System.out.println(out);

	}

	@Override
	void sleepForFiveSec() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	void dateTimeOfOtherCity() {
		// TODO Auto-generated method stub

	}

	@Override
	void dateTimeDifferentZone() {
		// TODO Auto-generated method stub

	}

	@Override
	void timeZoneHashMap() {
		// TODO Auto-generated method stub

	}

}