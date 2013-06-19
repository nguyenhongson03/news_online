package son.app.parse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseTime {
	private String source;
	private boolean is12h = false;
	public ParseTime(String source) {
		// TODO Auto-generated constructor stub
		this.source = source;
	}
	
	public String getTime(){
		source = source.replace("(GMT+7)", "");
		source = source.replace("GMT", "");
		source = source.replace("+0700", "");
		
		int pm = source.indexOf("PM");
		int am = source.indexOf("AM");
		if ( pm != -1 || am != -1){
			int pos;
			if (pm != -1){
				is12h = true;
				pos = pm;
			} else
				pos = am;
			source = source.substring(0, pos - 1);
		}
		
		if (source.indexOf(',') != -1){
			source = source.substring(source.indexOf(',') + 2, source.length());
		}
		
		int start = source.indexOf(":");
		if (start != -1){
			int start_hour = source.lastIndexOf(" ", start);
			String hour = source.substring(start_hour + 1, source.length());
			String day = source.substring(0, start_hour);
			String str = getDay(day) + " " + getHour(hour, is12h);
			return getDateTime(str);
		} else {
			String str = source + " 00:00";
			return getDateTime(str);
		}
	}
	
	private String getHour(String src, boolean is12h){
		int start = src.indexOf(':');
		int end = src.lastIndexOf(':');
		
		if (is12h){
			String temp = src.substring(0, start);
			int hour = Integer.parseInt(temp) + 12;
			
			src = Integer.toString(hour) + src.substring(start + 1, src.length());
		}
		
		if (start == end)
			return src;
		else 
			return src.substring(0, end);
	}
	
	private String getDay(String src){
		int start = src.indexOf('/');
		if (start != -1)
			return src;
		else {
			String[] temp = src.split(" ");
			String year = temp[2];
			String day = temp[0];
			String month = temp[1];
			
			if (month.equals("Jan"))
				month = "01";
			else if (month.equals("Feb"))
				month = "02";
			else if (month.equals("Mar"))
				month = "03";
			else if (month.equals("Apr"))
				month = "04";
			else if (month.equals("May"))
				month = "05";
			else if (month.equals("Jun"))
				month = "06";
			else if (month.equals("July"))
				month = "07";
			else if (month.equals("Aug"))
				month = "08";
			else if (month.equals("Sep"))
				month = "09";
			else if (month.equals("Oct"))
				month = "10";
			else if (month.equals("Nov"))
				month = "11";
			else 
				month = "12";
			return month + "/" + day + "/" + year;
		}
	}
	
	private String getDateTime(String source){
		try {
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy kk:mm");
			Date date = format.parse(source);
			
			Date current = new Date();
			if (current.getYear() != date.getYear())
				return (current.getYear() - date.getYear()) + " năm trước";
			else if (current.getMonth() != date.getMonth())
				return (current.getMonth() - date.getMonth()) + " tháng trước";
			else if (current.getDay() != date.getDay())
				return (current.getDay() - date.getDay()) + " ngày trước";
			else if (current.getHours() != date.getHours())
				return (current.getHours() - date.getHours()) + " giờ trước";
			else
				return (current.getMinutes() - date.getMinutes()) + " phút trước";
		} catch (Exception e){
			return "";
		}
	}
}