package com.dongdong.spring.util;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期处理
 * 
 * @ClassName: DateUtils
 * @author: [SenWu]
 * @CreateDate: [2018年12月29日 上午10:43:31]
 * @UpdateUser: [SenWu]
 * @UpdateDate: [2018年12月29日 上午10:43:31]
 * @UpdateRemark: []
 * @Description: []
 * @version: [V1.0]
 */
@Slf4j
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/** 日期数组 */
	public static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH",
			"yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH", "yyyy/MM",
			"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH", "yyyy.MM", "yyyy年MM月dd日",
			"yyyy年MM月dd日 HH时mm分ss秒", "yyyy年MM月dd日 HH时mm分", "yyyy年MM月dd日 HH时", "yyyy年MM月", "yyyy" };

	/**
	 * 日期格式化 日期格式为：yyyy-MM-dd
	 * 
	 * @param date
	 *            日期
	 * @return 返回yyyy-MM-dd格式日期
	 */
	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}

	/**
	 * 日期格式化 日期格式为：yyyy-MM-dd
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式，如：DateUtils.DATE_TIME_PATTERN
	 * @return 返回yyyy-MM-dd格式日期
	 */
	public static String format(Date date, String pattern) {
		if (date != null) {
			return org.apache.commons.lang3.time.DateFormatUtils.format(date, pattern);
		}
		return null;
	}

	/**
	 * 格式化当前日期转换为指定格式字符串
	 * 
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static String formatCurrentDate(String format) {
		return formatDateTime(new Date(), format);
	}

	/**
	 * 格式化日期类型转换为字符串
	 * 
	 * @param date
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static String formatDateTime(Date date, String format) {
		return DateFormatUtils.format(date, format);
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String formatCurrentDateTime() {
		return format(new Date(), DATE_TIME_PATTERN);
	}

	/**
	 * 获取一天的起始时间
	 * 
	 * @return
	 */
	public static String formatDayStartTime(String dateTime) {
		String formatDate = dateTime;
		try {
			Date date = stringToDate(dateTime, DATE_TIME_PATTERN);
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd 00:00:00");
		} catch (Exception e) {
			log.error("[formatDayStartTime]——时间格式转换错误，时间:{},错误信息:", dateTime, e);
		}
		return formatDate;
	}

	/**
	 * 获取一天的结束时间
	 * 
	 * @return
	 */
	public static String formatDayEndTime(String dateTime) {
		String formatDate = dateTime;
		try {
			Date date = stringToDate(dateTime, DATE_TIME_PATTERN);
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd 23:59:59");
		} catch (Exception e) {
			log.error("[formatDayEndTime]——时间格式转换错误，时间:{},错误信息:", dateTime, e);
		}
		return formatDate;
	}

	public static Date getDayStartTime(Date date) {
		return org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
	}
	
	public static Date getDayEndTime(Date date) {
		Date ceiling = org.apache.commons.lang3.time.DateUtils.ceiling(date, Calendar.DAY_OF_MONTH);
		return org.apache.commons.lang3.time.DateUtils.addSeconds(ceiling, -1);
	}

	public static Date getMonthStartTime(Date date) {
		return org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.MONTH);
	}

	public static Date getMonthEndTime(Date date) {
		Date ceiling = org.apache.commons.lang3.time.DateUtils.ceiling(date, Calendar.MONTH);
		return org.apache.commons.lang3.time.DateUtils.addSeconds(ceiling, -1);
	}
	
	public static Date getYearStartTime(Date date) {
		return org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.YEAR);
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @param pattern
	 *            日期的格式，如：DateUtils.DATE_TIME_PATTERN
	 */
	public static Date stringToDate(String strDate, String pattern) {
		if (StringUtils.isBlank(strDate)) {
			return null;
		}
		try {
			return org.apache.commons.lang3.time.DateUtils.parseDate(strDate, pattern);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 日期型字符串转化为日期 格式 see to DateUtils#parsePatterns
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return org.apache.commons.lang3.time.DateUtils.parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 对日期的【秒】进行加/减
	 *
	 * @param date
	 *            日期
	 * @param seconds
	 *            秒数，负数为减
	 * @return 加/减几秒后的日期
	 */
	public static Date addDateSeconds(Date date, int seconds) {

		return org.apache.commons.lang3.time.DateUtils.addSeconds(date, seconds);
	}

	/**
	 * 对日期的【分钟】进行加/减
	 *
	 * @param date
	 *            日期
	 * @param minutes
	 *            分钟数，负数为减
	 * @return 加/减几分钟后的日期
	 */
	public static Date addDateMinutes(Date date, int minutes) {
		return org.apache.commons.lang3.time.DateUtils.addMinutes(date, minutes);
	}

	/**
	 * 对日期的【小时】进行加/减
	 *
	 * @param date
	 *            日期
	 * @param hours
	 *            小时数，负数为减
	 * @return 加/减几小时后的日期
	 */
	public static Date addDateHours(Date date, int hours) {
		return org.apache.commons.lang3.time.DateUtils.addHours(date, hours);
	}

	/**
	 * 对日期的【天】进行加/减
	 *
	 * @param date
	 *            日期
	 * @param days
	 *            天数，负数为减
	 * @return 加/减几天后的日期
	 */
	public static Date addDateDays(Date date, int days) {
		return org.apache.commons.lang3.time.DateUtils.addDays(date, days);
	}

	/**
	 * 对日期的【周】进行加/减
	 *
	 * @param date
	 *            日期
	 * @param weeks
	 *            周数，负数为减
	 * @return 加/减几周后的日期
	 */
	public static Date addDateWeeks(Date date, int weeks) {
		return org.apache.commons.lang3.time.DateUtils.addWeeks(date, weeks);
	}

	/**
	 * 对日期的【月】进行加/减
	 *
	 * @param date
	 *            日期
	 * @param months
	 *            月数，负数为减
	 * @return 加/减几月后的日期
	 */
	public static Date addDateMonths(Date date, int months) {
		return org.apache.commons.lang3.time.DateUtils.addMonths(date, months);
	}

	/**
	 * 对日期的【年】进行加/减
	 *
	 * @param date
	 *            日期
	 * @param years
	 *            年数，负数为减
	 * @return 加/减几年后的日期
	 */
	public static Date addDateYears(Date date, int years) {
		return org.apache.commons.lang3.time.DateUtils.addYears(date, years);
	}

	/**
	 * 将yyyymmdd格式时间转化为yyyy-MM-dd格式
	 *
	 *
	 */
	public static String getStringPatternDate(String time) {
		String str = "";
		SimpleDateFormat str1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat str2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			str = str2.format(str1.parse(time));
		} catch (Exception e) {
			log.error("时间格式转换错误，时间:{},错误信息:{}", time, e);
		}
		return str;
	}

	/**
	 * 校验字符串有效日期格式
	 * 
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static boolean vaildDateFormat(String time, String pattern) {
		if (StringUtils.isBlank(time)) {
			return false;
		}
		if (DATE_PATTERN.equals(pattern)) {
			String regex = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$";
			return time.matches(regex);
		}
		if (DATE_TIME_PATTERN.equals(pattern)) {
			String regex = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
			return time.matches(regex);
		}

		return false;
	}

	/**
	 * 日期比较（strDate1>strDate2 == true）
	 * 
	 * @param strDate1
	 * @param strDate2
	 * @param pattern
	 * @return
	 */
	public static boolean compareDate(String strDate1, String strDate2, String pattern) {
		Date date1 = stringToDate(strDate1, pattern);
		Date date2 = stringToDate(strDate2, pattern);
		if (date1.compareTo(date2) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 根据年月获得该月的开始时间
	 * 
	 * @param
	 *
	 */
	public static String getMonthOfStartTime(String yearAndMonthTime) {// pattern:2019-08
		List<Integer> list = getMonthAndYear(yearAndMonthTime);
		// 获取约份结束时间
		YearMonth yearMonth = YearMonth.of(list.get(0), list.get(1));
		java.time.LocalDate localDate = yearMonth.atDay(1);
		LocalDateTime startOfDay = localDate.atStartOfDay();
		ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));
		return new SimpleDateFormat(DATE_TIME_PATTERN).format(Date.from(zonedDateTime.toInstant()));
	}

	/**
	 * 根据年月获得该月的结束时间
	 * 
	 * @param
	 *
	 */
	public static String getMonthOfEndTime(String yearAndMonthTime) { // pattern:2019-08
		List<Integer> list = getMonthAndYear(yearAndMonthTime);
		// 获取约份结束时间
		YearMonth yearMonth = YearMonth.of(list.get(0), list.get(1));
		java.time.LocalDate endOfMonth = yearMonth.atEndOfMonth();
		LocalDateTime localDateTime = endOfMonth.atTime(23, 59, 59, 999);
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
		return new SimpleDateFormat(DATE_TIME_PATTERN).format(Date.from(zonedDateTime.toInstant()));
	}

	/**
	 * 年月分离
	 */
	public static List<Integer> getMonthAndYear(String yearAndMonthTime) {
		List<Integer> list = Lists.newArrayList();
		String[] time = yearAndMonthTime.split("-");
		Integer year = Integer.valueOf(time[0]);
		String monthTime = time[1];
		Integer month = null;
		if (monthTime.startsWith("0")) {
			month = Integer.valueOf(monthTime.substring(1));
		} else {
			month = Integer.valueOf(monthTime);
		}
		list.add(year);
		list.add(month);
		return list;
	}

	/**
	 *
	 * 将字符“yyyy-MM-dd” 转为Date 类型
	 *
	 */

	public static Date changeTimePattern(String time) {
		Date dateTime = null;
		try {
			dateTime = new SimpleDateFormat(DATE_PATTERN).parse(time);
		} catch (Exception e) {
			log.error("时间格式转换错误，时间:{},错误信息:{}", time, e);
		}
		return dateTime;
	}

	/**
	 * 判断月初首日
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isFirstDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断年初首日
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isFirstDayOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (calendar.get(Calendar.DAY_OF_YEAR) == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 时间自动填充：startTime(输入的时间至少到天)
	 *
	 */
	public static Date getStartTime(String date) {
		Date startTime = null;
		if (StringUtils.isBlank(date)) {
			return null;
		}
		try {
			Integer timeCount = date.split(":").length;
			if (timeCount == 1) {
				if (date.trim().length() < 11) {
					Date dateTime = stringToDate(date, DATE_PATTERN);
					startTime = stringToDate(DateFormatUtils.format(dateTime, "yyyy-MM-dd 00:00:00"),
							DATE_TIME_PATTERN);
				} else {
					Date dateTime = stringToDate(date, parsePatterns[3]);
					startTime = stringToDate(DateFormatUtils.format(dateTime, "yyyy-MM-dd HH:00:00"),
							DATE_TIME_PATTERN);
				}
			}
			if (timeCount == 2) {
				Date dateTime = stringToDate(date, parsePatterns[2]);
				startTime = stringToDate(DateFormatUtils.format(dateTime, "yyyy-MM-dd HH:mm:00"), DATE_TIME_PATTERN);
			}
			if (timeCount == 3) {
				Date dateTime = stringToDate(date, DATE_TIME_PATTERN);
				startTime = stringToDate(DateFormatUtils.format(dateTime, "yyyy-MM-dd HH:mm:ss"), DATE_TIME_PATTERN);
			}
		} catch (Exception e) {
			log.info("时间格式转换错误，时间:{},错误信息:{}", date, e);
		}
		return startTime;
	}

	/**
	 * 时间自动填充：endTime(输入的时间至少到天)
	 *
	 */
	public static Date getEndTime(String date) {
		Date endTime = null;
		if (StringUtils.isBlank(date)) {
			return null;
		}
		try {
			Integer timeCount = date.split(":").length;
			if (timeCount == 1) {
				if (date.trim().length() < 11) {
					Date dateTime = stringToDate(date, DATE_PATTERN);
					endTime = stringToDate(DateFormatUtils.format(dateTime, "yyyy-MM-dd 23:59:59"), DATE_TIME_PATTERN);
				} else {
					Date dateTime = stringToDate(date, parsePatterns[3]);
					endTime = stringToDate(DateFormatUtils.format(dateTime, "yyyy-MM-dd HH:59:59"), DATE_TIME_PATTERN);
				}
			}
			if (timeCount == 2) {
				Date dateTime = stringToDate(date, parsePatterns[2]);
				endTime = stringToDate(DateFormatUtils.format(dateTime, "yyyy-MM-dd HH:mm:59"), DATE_TIME_PATTERN);
			}
			if (timeCount == 3) {
				Date dateTime = stringToDate(date, DATE_TIME_PATTERN);
				endTime = stringToDate(DateFormatUtils.format(dateTime, "yyyy-MM-dd HH:mm:ss"), DATE_TIME_PATTERN);
			}
		} catch (Exception e) {
			log.info("时间格式转换错误，时间:{},错误信息:{}", date, e);
		}
		return endTime;
	}
}
