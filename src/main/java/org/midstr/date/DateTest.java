package org.midstr.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String format = "yyyy-MM-dd HH:mm:ss SSS";
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		System.out.println(sdf.format(now.getTime()));
		
		System.out.println(now.get(Calendar.HOUR_OF_DAY));
		System.out.println(now.get(Calendar.MINUTE));
		System.out.println(now.get(Calendar.SECOND));
		System.out.println(now.get(Calendar.MILLISECOND));
		
		//now.clear(Calendar.HOUR_OF_DAY);
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.clear(Calendar.MINUTE);
		now.clear(Calendar.SECOND);
		now.clear(Calendar.MILLISECOND);
		
//		now.set(Calendar.HOUR_OF_DAY, 0);
//		now.set(Calendar.MINUTE, 0);
//		now.set(Calendar.SECOND, 0);
//		now.set(Calendar.MILLISECOND, 0);
		System.out.println(sdf.format(now.getTime()));
	}

}
