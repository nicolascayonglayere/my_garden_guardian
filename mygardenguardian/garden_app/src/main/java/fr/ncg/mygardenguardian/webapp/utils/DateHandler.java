package fr.ncg.mygardenguardian.webapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateHandler {

	public static String conversionNumSemaineVersStringDate(Integer numSemaine) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		sdf.setTimeZone(TimeZone.getTimeZone("CET"));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, numSemaine);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return sdf.format(cal.getTime());
	}

	public static Date conversionNumSemaineVersDate(Integer numSemaine) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, numSemaine);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}

	public static Date conversionStringVersDate(String dateStr) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
	}

	public static String conversionDateVersString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(date);
	}
}
