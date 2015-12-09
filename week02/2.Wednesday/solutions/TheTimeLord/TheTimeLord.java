package week2;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



class Time{
	LocalDateTime dateTime;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss dd.MM.YY");
	
	public Time(){
		this(now(),false);
	}
	
	public static Time now(){
		  return new Time(LocalDateTime .now());
	}
	
	public Time(int hour,int minute,int seconds,int day, int month , int year){
		dateTime = LocalDateTime.of(year,month,day,hour,minute,seconds);
	}
	
	public Time(LocalDateTime dateTime){
		this.dateTime = dateTime;
	}
	
	public Time(Time time,boolean makeOwncopy){
		if(makeOwncopy){
			try {
				this.dateTime = ((Time)time.clone()).dateTime;
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.dateTime = time.dateTime;
			}
		}
		else{
			this.dateTime = time.dateTime;
		}
	}
	
	//  yyyy-MM-dd HH:mm
	public Time(String date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss dd.MM.YY");
		dateTime = LocalDateTime.parse(date, formatter);
	}
	
	public void setFormatter(String format){
		formatter = DateTimeFormatter.ofPattern(format);
	}
	
	public String toSring(){
		return dateTime.format(formatter);
	}
}



public class TheTimeLord {

}
