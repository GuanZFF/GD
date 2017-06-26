package pers.guanzf.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateUtil {

	public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	public final static String YYYY_MM_DD = "yyyy-MM-dd";
	
	public final static String HH_MM_SS = "HH:mm:ss";
	
	public final static String YYYY_MM_DD_HH_MM_SS_MS = "yyyy_MM_dd_HH_mm_ss_ms";
	
	public final static String YYYY = "yyyy";
	public final static String MM = "MM";
	public final static String DD = "dd";
	public final static String HH = "HH";
	public final static String mm = "mm";
	public final static String SS = "ss";
	
	public static String getDateString(Date date, String pattern) {
		if (isEmpty(date) || StringUtils.isEmpty(pattern)) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
	
	public static Date getDate(Date date, String pattern) {
		if (isEmpty(date) || StringUtils.isEmpty(pattern)) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(pattern);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static boolean isEmpty(Date date) {
		return date == null ? true :false;
	}
	
	public static boolean isNotEmpty(Date date) {
		return !isEmpty(date);
	}
	
	public static void main(String[] args) {
		System.out.println(getDateString(new Date(), DateUtil.YYYY_MM_DD_HH_MM_SS_MS));
	}
	
}
