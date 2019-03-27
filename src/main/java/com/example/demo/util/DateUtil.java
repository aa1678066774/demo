package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>();
	/**
	 * 时间转字符窜
	 * @param format(时间格式)
	 * @param date(需要转为字符窜的时间)
	 * @return 格式化字符窜
	 */
	public static  String dateFormatString(String format,Date date) {
		SimpleDateFormat sdf = local.get();
		if (sdf == null) {
			sdf = new SimpleDateFormat(format, Locale.US);
			local.set(sdf);
		}
		String currentDate = sdf.format(date);
		return currentDate;
	}
	/**
	 * 日期字符窜转日期
	 * @param format
	 * @param dateStr
	 * @return
	 */
	public static  Date stringFormatDate(String format,String dateStr) {
		SimpleDateFormat sdf = local.get();
		if (sdf == null) {
			sdf = new SimpleDateFormat(format, Locale.US);
			local.set(sdf);
		}
		Date currentDate=null;
		try {
			currentDate = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentDate;
	}
	
	/**
	 * 日期加减天数
	 * @param inDate
	 * @param day
	 * @return
	 */
	public static Date addDay(Date inDate, int day) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(inDate);
	    calendar.add(Calendar.DATE, day);
	    return calendar.getTime();
	}
	
	/**
	 * 判断是否闰年
	 * @param year int年份
	 * @return
	 */
	public static boolean isLeapYear(int year) {
	    return ((year % 4 == 0) && (((year % 100 != 0) || (year % 400 == 0))));
	}
	
	/**
	 * 判断星座
	 * @param birth 生日字符窜（yyyy-MM-dd）
	 * @return 星座
	 */
	public static String getAstro(String birth) {
	    int month = Integer.parseInt(birth.substring(birth.indexOf("-") + 1,
	            birth.lastIndexOf("-")));
	    int day = Integer.parseInt(birth.substring(birth.lastIndexOf("-") + 1));
	    String s = "魔羯水瓶双鱼牡羊金牛双子巨蟹狮子处女天秤天蝎射手魔羯";
	    int[] arr = { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };
	    int start = month * 2 - ((day < arr[(month - 1)]) ? 2 : 0);
	    return s.substring(start, start + 2) + "座";
	}
	
	 /**
	  * 获得当前年份
	  * @return year(int)
	  */
	 public static int getDateYear(Date date) {
		  Calendar mCalendar = Calendar.getInstance();
		  mCalendar.setTime(date);
		  return mCalendar.get(Calendar.YEAR);
	 }
	 
	 /**
	  * 获得当前月份
	  * @return month(int) 1-12
	  */
	 public static int getDateMonth(Date date) {
		  Calendar mCalendar = Calendar.getInstance();
		  mCalendar.setTime(date);
		  return mCalendar.get(Calendar.MONTH) + 1;
	 }
	 
	 /**
	  * 获得当月几号
	  * @return day(int)
	  */
	 public static int getDateDay(Date date) {
		  Calendar mCalendar = Calendar.getInstance();
		  mCalendar.setTime(date);
		  return mCalendar.get(Calendar.DAY_OF_MONTH);
	 }
	 /**
	  * 时间a小于时间b
	  * if(a<b)
	  * @param a
	  * @param b
	  * @return
	  */
	 public static boolean aItb(Date a,Date b) {
		 return a.before(b);
	 }
	 
	 /**
	  * 时间a大于等于时间b
	  * if(a>=b)
	  * @param a
	  * @param b
	  * @return
	  */
	 public static boolean aGtAndEqb(Date a,Date b) {
		 return !aItb(a,b);
	 }
	 
	 /**
	  * 时间a大于时间b
	  * if(a>b)
	  * @param a
	  * @param b
	  * @return
	  */
	 public static boolean aGtb(Date a,Date b) {
		 return a.after(b);
	 }
	 
	 /**
	  * 时间a小于等于时间b
	  * if(a<=b)
	  * @param a
	  * @param b
	  * @return
	  */
	 public static boolean aItAndEqb(Date a,Date b) {
		 return !aGtb(a,b);
	 }
	
	public static void main(String[] args) {
		//System.out.println(dateFormatString("yyyy-MM-dd",addDay(new Date(),-1)));
		//System.out.println(isLeapYear(2000));
//		System.out.println(getAstro("1994-07-23"));
//		System.out.println(stringFormatDate("yyyy-MM-dd", "1994-07-23"));
//		System.out.println(getDateYear(new Date()));
		Date date =new Date();
		Date date1 = (Date) date.clone();
		System.out.println(date1==date);
		org.assertj.core.util.DateUtil.formatAsDatetime(date1);
	}
}
