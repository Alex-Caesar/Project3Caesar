import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.time.*;
public class DateTimeOne extends MesoDateTimeOneAbstract
{
	//objects to use in class
	private LocalDate dateNow;
	private LocalTime timeNow;
	
	public DateTimeOne(){
		//initialized variables
		dateNow= LocalDate.now();
		timeNow= LocalTime.now();
		
	}
	
	@Override
	int getValueOfSecond() {
		int now=timeNow.getSecond();
		String out="The value of Second now: "+now;
		
		System.out.println(out);
		return now;
	}

	@Override
	void dateTimeNow() {
		//taking string of date to change
		String date=dateNow.toString();
		String dateAdd=dateNow.toString();
		//substringing and changing for format
		date=date.substring(0, 4);
		dateAdd=dateAdd.substring(5, 8);
		
		String out="Current Date/Time: "+date+dateAdd;
		
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