package com.crgt.innov2015.util;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {
	
	public static final String DefaultDateFormat = "yyyyMMdd";
	public static final String DateFormatWithMinsAndSecs = "yyyyMMdd HH:mm:ss.SSS a";
	public static final String MonthYearFormat = "MMyyyy";
    public static final String DefaultDateFormatWithSlash = "MM/dd/yyyy";
    
    private DateUtil() { }
    
	private static class Singleton {
		private static final DateUtil INSTANCE = new DateUtil();
	}
	
	public static DateUtil getInstance() {
		return Singleton.INSTANCE;
	}
	
	public static java.sql.Date getSqlDate(Date d) {
		java.sql.Date result = null;
		if (null != d) {
			result = new java.sql.Date(d.getTime());
		}
		return result;
	}
	
	/**
	 * Returns date in string format.
	 * @param dateFormat: mm/dd/yyyy
	 * @return
	 */
	public static String getCurrentDateInStr(String dateFormat){
		SimpleDateFormat sdf=null;
		if(null!=dateFormat){
			sdf = new SimpleDateFormat(dateFormat);
		}else{
			sdf = new SimpleDateFormat(DefaultDateFormat);
		}
		return sdf.format(new Date());
	}
	/**
	 * Add days to it to get exact date
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	public static Date getCurrentDate()	 
	{
		return getCurrentDate(DefaultDateFormat);
	}
	
	public static Date getCurrentDateWithTimeStamp(){
		return getCurrentDate(DateFormatWithMinsAndSecs);
	}
	
	public static Date getCurrentPlus30(){
		return DateUtil.addDays(DateUtil.getCurrentDate(), 30);
	}
	public static Date getCurrentPlus60(){
		return DateUtil.addDays(DateUtil.getCurrentDate(), 60);
	}
	
	public static Date getDateByChangingYears(int yearsToAdd){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.getCurrentDate());
		calendar.add(Calendar.YEAR, -yearsToAdd);
		return calendar.getTime();
	}
	/**
	 * Returns date in date format.
	 * @param format
	 * @return
	 */
	public static Date getCurrentDate(String format)	 
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dtStr = sdf.format(new Date());
		try {
			return stringToDate(dtStr,format);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static Date getDateLastMonth(Date dayte){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dayte);
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime(); 
	}
    
    public static String toString(Date dayte, String dFormat) {
        if (dayte == null || dFormat == null) {
            return null;
        }
        String res = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dFormat);
            res = sdf.format(dayte);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return (res);
    }
    
    public static String toString(Date dayte, String dFormat, boolean trim, boolean replaceNull) {
        if (dayte == null || dFormat == null) {
            return null;
        }
        String res = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dFormat);
            res = sdf.format(dayte);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        if (trim) {
        	res = StringUtil.trim(res);
        }
        if (replaceNull) {
        	res = StringUtil.replaceNull(res);
        }
        return (res);
    }

    public static Date stringToDate(String dateString, String format) throws ParseException {
        if (StringUtil.isEmpty(dateString) || null == format) {
            return null;
        }
        Date newDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            newDate = sdf.parse(dateString);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            throw new ParseException("Illegal argument", 0);
        }
        return newDate;
    }
    
    public static Timestamp stringToTimestamp(String dateString, String format)
            throws ParseException {
        if (dateString == null || format == null) {
            return null;
        }
        Timestamp retVal = null;

        Date newDate = getDate(dateString);
        if(newDate != null) {
            retVal = new Timestamp(newDate.getTime());
        }

        return retVal;
    }

    public static String timestampToFormattedString(Timestamp tstamp, String format) throws ParseException {
        return toString(tstamp, format);
    }

	/**
	 * Masks exceptions (assuming no TIME portion)
	 */
	public static Date getDateMaskException(String dateString, String format)
	{		
		Date result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
            result = sdf.parse(dateString);
		}
		catch (Exception e) { // just return null
			e.printStackTrace();
		}
		return result;
	}

	public static Date getDate(String dateString)
	{
		Date result = getDateMaskException(dateString, DefaultDateFormat);
		return result;
	}
	
	public static Date getDate(String dateString, String format)
	{
		Date result = getDateMaskException(dateString, format);
		return result;
	}
	
	/**
	 * compares dates ignoring time-Its the client's responsibility
	 * to not pass any null values for any of the two dates
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDatesIgnoringTime(Date date1,Date date2)
	{
		resetTimeFactorInDate(date1);
		resetTimeFactorInDate(date2);
		return date1.compareTo(date2);
	}	
	
	public static void resetTimeFactorInDate(Date date) {
		if( date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND,0);
			calendar.set(Calendar.MILLISECOND,0);
			date = calendar.getTime();
		}
	}
	
	public static int getNumberofDaysBetween(Date firstDate, Date lastDate)//returns no of days between date2 and date1 
	{
		long  mills_per_day = 1000 * 60 * 60 * 24; 
		long day_diff = ( lastDate.getTime() - firstDate.getTime() ) / mills_per_day;
		return (int)day_diff;
	}
	

	    
    public static int getDateField(Date date, int field) {
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date); // if date is null NullPointerException will be thrown
    	return cal.get(field);
    }
    
    public static String getEndDatePlusOne(String date) {
    	DateTimeFormatter formatter = DateTimeFormat.forPattern(DateUtil.DefaultDateFormatWithSlash);
    	DateTime dtOrg = formatter.parseDateTime(date);
		return dtOrg.plusDays(1).toString(formatter);
    }
    
    public static void main (String a[]){
    	System.out.println(DateUtil.getCurrentDateWithTimeStamp());
    	//System.out.println(DateUtil.getCurrentDate(DefaultDateFormatWithSlash));
    	//System.out.println(addDays(DateUtil.getCurrentDate(DefaultDateFormatWithSlash),30));
    	
   }
    
    public static Calendar DateToCalendar(Date date){ 
    	  Calendar cal = Calendar.getInstance();
    	  cal.setTime(date);
    	  return cal;
    	}
}
