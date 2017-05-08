package gov.georgia.dhr.dfcs.sacwis.core.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import org.exolab.castor.types.DateTimeBase;

/**
 * Title: DateHelper
 * </p>
 * <p>
 * Description: Abstract class providing many static functions to help in manipulating the date classes used in Impact.
 * This should be the main API that developers use to access all dates. There are two types of dates used in Impact, so
 * this class has two method definitions for most of its methods. The two date types are <p/> <b>java.util.Date: </b>
 * These dates (Java dates) store data down to the millisecond. They are used to store the timestamp values from CAPS.
 * All timestamp properties should begin with the prefix "ts", and most of them are actually named "tsLastUpdate." In
 * short use this date time for "tsLastUpdate" properties.
 * </p>
 * <p/> <b>org.exolab.castor.types.Date: </b> These dates (Castor dates) store data only to the day. These dates are
 * used for most dates that are input from widgets in IMPACT. These dates are used to populate properteis that begin
 * with the "dt" prefix.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Accenture
 * </p>
 * 
 * @author Dann Webster
 * 
 *  <pre>
 *    Change History:
 *    Date              User              Description
 *    --------      ----------------  --------------------------------------------------
 *    04/24/2009      bgehlot          STGAP00012833: Added a method getFirstDayOfTheMonth
 * </pre>        
 */

public abstract class DateHelper {
  public static final String TRACE_TAG = "DateHelper";

  public static final String SLASH_FORMAT_STRING = "MM/dd/yyyy";

  public static final SimpleDateFormat SLASH_FORMAT = new SimpleDateFormat(SLASH_FORMAT_STRING);

  // public static final String DASH_DATE_FORMAT_STRING = "MM-dd-yyyy";
  // public static final SimpleDateFormat DASH_FORMAT = new SimpleDateFormat(DASH_DATE_FORMAT_STRING);

  public static final String ISO_DATE_FORMAT_STRING = "yyyy-MM-dd";

  public static final SimpleDateFormat ISO_FORMAT = new SimpleDateFormat(ISO_DATE_FORMAT_STRING);

  public static final String FULL_ISO_DATE_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss.SSS";

  public static final SimpleDateFormat FULL_ISO_DATE_FORMAT = new SimpleDateFormat(FULL_ISO_DATE_FORMAT_STRING);

  public static final String TIMESTAMP_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss.S";

  public static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat(TIMESTAMP_FORMAT_STRING);

  public static final String JAVA_DATE_FORMAT_STRING = "EEE MMM dd HH:mm:ss zzz yyyy";

  public static final SimpleDateFormat JAVA_DATE_FORMAT = new SimpleDateFormat(JAVA_DATE_FORMAT_STRING);

  public static final String SQL_DATE_FORMAT_STRING = "MM/dd/yyyy HH:mm:ss";

  public static final SimpleDateFormat SQL_DATE_FORMAT = new SimpleDateFormat(SQL_DATE_FORMAT_STRING);

  public static final String DATE_TIME_FORMAT_STRING = "MM/dd/yyyy hh:mm a";

  public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME_FORMAT_STRING);

  public static final String DAY_OF_WEEK_DATE_FORMAT_STRING = "EEEE";

  public static final SimpleDateFormat DAY_OF_WEEK_DATE_FORMAT = new SimpleDateFormat(DAY_OF_WEEK_DATE_FORMAT_STRING);

  public static final String AM_PM_DATE_FORMAT_STRING = "a";

  public static final SimpleDateFormat AM_PM_DATE_FORMAT = new SimpleDateFormat(AM_PM_DATE_FORMAT_STRING);

  public static final String AM_PM_TIME_FORMAT_STRING = "hh:mm a";

  public static final SimpleDateFormat AM_PM_TIME_FORMAT = new SimpleDateFormat(AM_PM_TIME_FORMAT_STRING);

  private static final String MAX_JAVA_DATE_STRING = "12/31/4712";

  private static final String MIN_JAVA_DATE_STRING = "01/01/1850";

  public static final Date MAX_JAVA_DATE;

  public static final Date MIN_JAVA_DATE;

  public static final org.exolab.castor.types.Date MAX_CASTOR_DATE;

  public static final org.exolab.castor.types.Date MIN_CASTOR_DATE;

  static {
    JAVA_DATE_FORMAT.setLenient(false);
    FULL_ISO_DATE_FORMAT.setLenient(false);
    TIMESTAMP_FORMAT.setLenient(false);
    SLASH_FORMAT.setLenient(false);
    ISO_FORMAT.setLenient(false);
    SQL_DATE_FORMAT.setLenient(false);
    DATE_TIME_FORMAT.setLenient(false);
    DAY_OF_WEEK_DATE_FORMAT.setLenient(false);
    try {
      MAX_JAVA_DATE = SLASH_FORMAT.parse(MAX_JAVA_DATE_STRING);
      MIN_JAVA_DATE = SLASH_FORMAT.parse(MIN_JAVA_DATE_STRING);
      MAX_CASTOR_DATE = new org.exolab.castor.types.Date(MAX_JAVA_DATE);
      MIN_CASTOR_DATE = new org.exolab.castor.types.Date(MIN_JAVA_DATE);
    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }
  }

  // These are different than java.util.Calendar, unfortunately, so they cannot be removed.
  public static final int SUNDAY = 0;

  public static final int MONDAY = 1;

  public static final int TUESDAY = 2;

  public static final int WEDNESDAY = 3;

  public static final int THURSDAY = 4;

  public static final int FRIDAY = 5;

  public static final int SATURDAY = 6;

  public static boolean isNull(org.exolab.castor.types.Date date) {
    return ((date == null) || (MAX_CASTOR_DATE.equals(date)));
  }

  public static boolean isNull(java.util.Date date) {
    // mcclaim: use getTime() because I've noticed that dates created in different
    // time zones; even though they represent the same time, return false
    return ((date == null) || (MAX_JAVA_DATE.getTime() == date.getTime()));
  }

  /**
   * Adds years, months, and days to a given Java Date, returning a Java Date. Adds first years, then months, then days,
   * and accepts negative values to subtract days. The jdate that is input remains unchanged.
   * 
   * @param jdate
   *          the date to which you want the years months and days added
   * @param years
   *          number of years to add
   * @param months
   *          number of months to add
   * @param days
   *          number of days to add
   * @return the jdate input with the years, months, and days added
   */
  public static java.util.Date addToDate(java.util.Date jdate, int years, int months, int days) {
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date idate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();
    idate.setTime(jdate);
    idate.addYears(years);
    idate.addMonths(months);
    idate.addDays(days);
    return idate.getTime();
  }

  /**
   * Adds years, months, and days to a given Castor Date, returning a Castor Date. Adds first years, then months, then
   * days, and accepts negative values to subtract days. The cdate that is input remains unchanged.
   * 
   * @param cdate
   *          the date to which you want the years months and days added
   * @param years
   *          number of years to add
   * @param months
   *          number of months to add
   * @param days
   *          number of days to add
   * @return the cdate input with the years, months, and days added
   */
  public static org.exolab.castor.types.Date addToDate(org.exolab.castor.types.Date cdate, int years, int months,
                                                       int days) {
    java.util.Date jdate = DateHelper.toJavaDate(cdate);
    jdate = DateHelper.addToDate(jdate, years, months, days);
    return DateHelper.toCastorDate(jdate);
  }

  /**
   * Returns the number of minutes between castorDate1 and castorDate2 as a double. If the returned value is > 0,
   * castorDate1 is greater than castorDate2. if the returned value is < 0, castorDate1 is less than castorDate2.
   * Replaces ARC_UTLCompareDateAndTime.
   * 
   * @param castorDate1
   *          first date
   * @param castorDate2
   *          second date
   * @return the number of minutes difference between the two dates.
   */
  public static double minutesDifference(org.exolab.castor.types.Date castorDate1,
                                         org.exolab.castor.types.Date castorDate2) {
    java.util.Date jd1 = castorDate1.toCalendar().getTime();
    java.util.Date jd2 = castorDate2.toCalendar().getTime();
    return minutesDifference(jd1, jd2);
  }

  /**
   * Returns the number of minutes between javaDate1 and javaDate2 as a double. If the returned value is > 0, javaDate1
   * is greater than javaDate2. if the returned value is < 0, javaDate1 is less than javaDate2. Replaces
   * ARC_UTLCompareDateAndTime.
   * 
   * @param javaDate1
   *          first date
   * @param javaDate2
   *          second date
   * @return the number of minutes difference between the two dates.
   */
  public static double minutesDifference(java.util.Date javaDate1, java.util.Date javaDate2) {
    double milliDiff = javaDate1.getTime() - javaDate2.getTime();
    return milliDiff / (1000.0 * 60.0);
  }

  public static String toString(org.exolab.castor.types.Date castorDate, DateFormat dateFormat) {
    if (castorDate == null) {
      return "";
    }
    Date date = castorDate.toDate();
    return toString(date, dateFormat);
  }

  public static String toString(Date date, DateFormat dateFormat) {
    if (date == null) {
      return "";
    }
    return dateFormat.format(date);
  }

  public static org.exolab.castor.types.Date toCastorDate(String dateString) throws ParseException {
    Date jDate = toJavaDateFromInput(dateString);
    return DateHelper.toCastorDate(jDate);
  }

  /** If the dateString passed in is null, or "", or invalid, it returns the defaultDate */
  public static Date toJavaDateFromInputWithDefault(String dateString, Date defaultDate) {
    try {
      if ((dateString == null) || ("".equals(dateString.trim()))) {
        return defaultDate;
      }
      return toJavaDateFromInput(dateString);
    } catch (ParseException e) {
      return defaultDate;
    }
  }

  public static Date toJavaDateFromInput(String dateString) throws ParseException {
    // Try to get a date with format yyyy-MM-DD
    if (dateString.indexOf("-") > 0) {
      return ISO_FORMAT.parse(dateString);
    }
    // Try to get a date with format mm/dd/yyyy
    if (dateString.indexOf("/") > 0) {
      return SLASH_FORMAT.parse(dateString);
    }
    // If date has neither - or / try mmddyyyy.
    if (dateString.length() == 8) {
      // Add slashes to date and try to parse
      StringBuffer sb = new StringBuffer(dateString.substring(0, 2));
      sb.append("/");
      sb.append(dateString.substring(2, 4));
      sb.append("/");
      sb.append(dateString.substring(4, 8));
      dateString = sb.toString();
      return SLASH_FORMAT.parse(dateString);
    }
    // Date does not match any acceptable format.
    // Constraints should have prevented us from getting to this point.
    throw new ParseException("Date string: " + dateString + " is not a valid date format. ", 1);
  }

  public static org.exolab.castor.types.Date toCastorDateSafe(String dateString) {
    if (dateString == null) {
      return null;
    }
    try {
      return DateHelper.toCastorDate(dateString);
    } catch (ParseException pe) {
      return null;
    }
  }

  public static Date toJavaDate(String dateString, DateFormat dateFormat) throws ParseException {
    if ((dateString == null) || ("".equals(dateString))) {
      return null;
    }
    return dateFormat.parse(dateString);
  }

  public static Date toJavaDate(String dateString) throws ParseException {
    Date jdate;
    if (dateString.length() == 21) {
      jdate = TIMESTAMP_FORMAT.parse(dateString);
    } else if (dateString.indexOf("-") > 0) {
      jdate = FULL_ISO_DATE_FORMAT.parse(dateString);
    } else if (dateString.indexOf("/") > 0) {
      jdate = SLASH_FORMAT.parse(dateString);
    } else {
      jdate = JAVA_DATE_FORMAT.parse(dateString);
    }
    return jdate;
  }

  public static Date toJavaDateSafe(String dateString) {
    Date jdate = null;
    try {
      jdate = toJavaDate(dateString);
    } catch (ParseException pe) {
      GrndsTrace.msg(TRACE_TAG + ".toJavaDateSafe()", 7, "creating a default Date to "
                                                         + " deal with a ParseException for the dateString \""
                                                         + dateString + "\".");
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG + ".toJavaDateSafe()", 7,
                     "creating a default Date to deal with an Exception for the dateString \"" + dateString + "\".");
    }
    return jdate;
  }

  /**
   * This takes a castor date and a teme string and returns a Java date object representing both of these.
   * 
   * @param castorDate
   *          The calendar date.
   * @param timeString
   *          The time in the format returned from <tt>ContextHelper.getTimeSafe()</tt>
   * @return A java date combining the castor date and string time information.
   * @throws ParseException
   *           ifit fails to parse the date.
   */
  public static Date toJavaDate(org.exolab.castor.types.Date castorDate, String timeString) throws ParseException {
    String fullDateString = toString(castorDate, SLASH_FORMAT) + " " + timeString;
    return DATE_TIME_FORMAT.parse(fullDateString);
  }

  /**
   * This takes a castor date and a teme string and returns a Java date object representing both of these.
   * 
   * @param castorDate
   *          The calendar date.
   * @param timeString
   *          The time in the format returned from <tt>ContextHelper.getTimeSafe()</tt>
   * @return A java date combining the castor date and string time information.
   */
  public static Date toJavaDateSafe(org.exolab.castor.types.Date castorDate, String timeString) {
    try {
      return toJavaDate(castorDate, timeString);
    } catch (ParseException e) {
      // do nothing
    }
    return null;
  }

  /**
   * I know the naming of this method seems strange since you are starting with a Java date, but I found this
   * functionality to be needed in several areas, so I added it here. Basically, it combines a Java date and time string
   * into a full Java date. The format of the time string is expected to be "hh:mm am". If the parsing fails to combine
   * the date and time, then the returned date is the same date you started with.
   * 
   * @param date
   * @param time
   * @return
   */
  public static Date toJavaDateSafe(Date date, String time) {
    Date dateAndTime;
    String dateStr = DateHelper.SLASH_FORMAT.format(date);
    String dateAndTimeStr = dateStr + " " + time;
    try {
      dateAndTime = DateHelper.DATE_TIME_FORMAT.parse(dateAndTimeStr);
    } catch (ParseException pe) {
      dateAndTime = date;
    }
    return dateAndTime;
  }

  public static String toSqlString(Date jdate) {
    return SQL_DATE_FORMAT.format(jdate);
  }

  public static String toSqlString(org.exolab.castor.types.Date cdate) {
    Date jdate = DateHelper.toJavaDate(cdate);
    return DateHelper.toSqlString(jdate);
  }

  public static String toISOString(Date jdate) {
    if(jdate == null) {
      return null;
    }
    return FULL_ISO_DATE_FORMAT.format(jdate);
  }

  public static String toISOStringSafe(Date jdate) {
    String EMPTY_STRING = "";
    if (jdate == null) {
      return EMPTY_STRING;
    } else {
      return DateHelper.toISOString(jdate);
    }
  }

  public static Date toJavaDate(org.exolab.castor.types.Date cdate) {
    if (cdate == null) {
      return null;
    }
    return cdate.toDate();
  }

  public static org.exolab.castor.types.Date toCastorDate(Date jdate) {
    if (jdate == null) {
      return null;
    }
    return new org.exolab.castor.types.Date(jdate);
  }

  public static int getAge(Date jdate) {
    if (jdate == null) {
      return 0;
    } else {
      gov.georgia.dhr.dfcs.sacwis.core.utility.Date birthday = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();
      birthday.setTime(jdate);
      return DateUtility.getAge(birthday);
    }
  }

  public static int getAge(Date jdate, Date fromjdate) {
    if (jdate == null || fromjdate == null) {
      return 0;
    } else {
      gov.georgia.dhr.dfcs.sacwis.core.utility.Date birthday = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();
      birthday.setTime(jdate);
      gov.georgia.dhr.dfcs.sacwis.core.utility.Date fromdate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();
      fromdate.setTime(fromjdate);
      return DateUtility.getAge(birthday, fromdate);
    }
  }

  public static int getAge(org.exolab.castor.types.Date cdate) {
    if (cdate == null) {
      return 0;
    } else {
      return DateHelper.getAge(DateHelper.toJavaDate(cdate));
    }
  }

  public static int getAge(org.exolab.castor.types.Date cdate, org.exolab.castor.types.Date fromcdate) {
    if (cdate == null || fromcdate == null) {
      return 0;
    } else {
      return DateHelper.getAge(DateHelper.toJavaDate(cdate), DateHelper.toJavaDate(fromcdate));
    }
  }

  public static boolean isToday(org.exolab.castor.types.Date cdate) {
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new Date());
    return cdate.equals(today);
  }

  public static org.exolab.castor.types.Date getTodayCastorDate() {
    return DateHelper.toCastorDate(new Date());
  }

  public static boolean isBeforeToday(org.exolab.castor.types.Date cdate) {
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new Date());
    return DateHelper.isBefore(cdate, today);
  }

  public static boolean isAfterToday(org.exolab.castor.types.Date cdate) {
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new Date());
    return DateHelper.isAfter(cdate, today);
  }

  public static boolean isValidDate(String dateString) {
    boolean isValid;
    try {
      Date eighteenFifty = SLASH_FORMAT.parse("01/01/1850");
      Date validationDate = SLASH_FORMAT.parse(dateString);
      if (validationDate.before(eighteenFifty)) {
        isValid = false;
      } else {
        isValid = true;
      }
    } catch (Exception e) {
      isValid = false;
    }
    return isValid;
  }

  public static boolean isAfter(org.exolab.castor.types.Date cdate1, org.exolab.castor.types.Date cdate2) {
    return !(cdate1 == null || cdate2 == null) && cdate1.compareTo(cdate2) == DateTimeBase.GREATER_THAN;
  }

  public static boolean isBefore(org.exolab.castor.types.Date cdate1, org.exolab.castor.types.Date cdate2) {
    return !(cdate1 == null || cdate2 == null) && cdate1.compareTo(cdate2) == DateTimeBase.LESS_THAN;
  }

  public static boolean isAfter(Date jdate1, Date jdate2) {
    org.exolab.castor.types.Date cdate1 = DateHelper.toCastorDate(jdate1);
    org.exolab.castor.types.Date cdate2 = DateHelper.toCastorDate(jdate2);
    return DateHelper.isAfter(cdate1, cdate2);
  }

  public static boolean isBefore(Date jdate1, Date jdate2) {
    org.exolab.castor.types.Date cdate1 = DateHelper.toCastorDate(jdate1);
    org.exolab.castor.types.Date cdate2 = DateHelper.toCastorDate(jdate2);
    return DateHelper.isBefore(cdate1, cdate2);
  }

  public static boolean isToday(Date jdate) {
    org.exolab.castor.types.Date cdate = new org.exolab.castor.types.Date(jdate);
    return DateHelper.isToday(cdate);
  }

  public static boolean isBeforeToday(Date jdate) {
    org.exolab.castor.types.Date cdate = new org.exolab.castor.types.Date(jdate);
    return DateHelper.isBeforeToday(cdate);
  }

  public static boolean isAfterToday(Date jdate) {
    org.exolab.castor.types.Date cdate = new org.exolab.castor.types.Date(jdate);
    return DateHelper.isAfterToday(cdate);
  }

  public static int compareDateAndTime(org.exolab.castor.types.Date cdate1, String time1, Date jdate2) {
    try {
      Date jdate1 = toJavaDate(cdate1, time1);
      return jdate1.compareTo(jdate2);
    } catch (ParseException e) {
      // Just rethrow -- bad formats should cause immediate failure.
      throw new RuntimeWrappedException(e);
    }
  }

  public static int compareDateAndTime(Date jdate1, org.exolab.castor.types.Date cdate2, String time2) {
    try {
      Date jdate2 = toJavaDate(cdate2, time2);
      return jdate1.compareTo(jdate2);
    } catch (ParseException e) {
      // Just rethrow -- bad formats should cause immediate failure.
      throw new RuntimeWrappedException(e);
    }
  }

  public static int compareDateAndTime(org.exolab.castor.types.Date cdate1, String time1,
                                       org.exolab.castor.types.Date cdate2, String time2) {
    try {
      Date jdate1 = toJavaDate(cdate1, time1);
      Date jdate2 = toJavaDate(cdate2, time2);
      return jdate1.compareTo(jdate2);
    } catch (ParseException e) {
      // Just rethrow -- bad formats should cause immediate failure.
      throw new RuntimeWrappedException(e);
    }
  }

  public static Date getJavaDateFromAge(int age) {
    Date today = new Date();
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date todayDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();
    todayDate.setTime(today);

    int year = todayDate.getYear() - age;
    String bday = "01/01/" + year;
    Date approxBday = null;
    try {
      approxBday = SLASH_FORMAT.parse(bday);
    } catch (ParseException e) {
      // should not be any exceptions
    }
    return approxBday;
  }

  public static org.exolab.castor.types.Date getCastorDateFromAge(int age) {
    Date bday = getJavaDateFromAge(age);
    return new org.exolab.castor.types.Date(bday);
  }

  public static String getDayOfWeekAsString(org.exolab.castor.types.Date cdate) {
    Date jdate = DateHelper.toJavaDate(cdate);
    return getDayOfWeekAsString(jdate);
  }

  public static String getDayOfWeekAsString(Date jdate) {
    return DAY_OF_WEEK_DATE_FORMAT.format(jdate);
  }

  public static int getDayOfWeekAsInt(org.exolab.castor.types.Date cdate) {
    Date jdate = DateHelper.toJavaDate(cdate);
    return getDayOfWeekAsInt(jdate);
  }

  public static int getDayOfWeekAsInt(Date jdate) {
    int dayOfWeekAsInt = 0;
    String dayOfWeekAsString = DAY_OF_WEEK_DATE_FORMAT.format(jdate);
    if ("Sunday".equals(dayOfWeekAsString)) {
      dayOfWeekAsInt = 0;
    } else if ("Monday".equals(dayOfWeekAsString)) {
      dayOfWeekAsInt = 1;
    } else if ("Tuesday".equals(dayOfWeekAsString)) {
      dayOfWeekAsInt = 2;
    } else if ("Wednesday".equals(dayOfWeekAsString)) {
      dayOfWeekAsInt = 3;
    } else if ("Thursday".equals(dayOfWeekAsString)) {
      dayOfWeekAsInt = 4;
    } else if ("Friday".equals(dayOfWeekAsString)) {
      dayOfWeekAsInt = 5;
    } else if ("Saturday".equals(dayOfWeekAsString)) {
      dayOfWeekAsInt = 6;
    }
    return dayOfWeekAsInt;
  }

  public static String getAMPM(Date jdate) {
    return AM_PM_DATE_FORMAT.format(jdate);
  }

  public static Date getLastDayOfTheMonth(Date jdate) {
    java.util.GregorianCalendar tempCal = new java.util.GregorianCalendar();
    tempCal.setTime(jdate);
    int lastDayOfMonth = tempCal.getActualMaximum(java.util.GregorianCalendar.DATE);
    tempCal.set(java.util.GregorianCalendar.DATE, lastDayOfMonth);
    return tempCal.getTime();
  }

  public static org.exolab.castor.types.Date getLastDayOfTheMonth(org.exolab.castor.types.Date cdate) {
    Date jdate = DateHelper.toJavaDate(cdate);
    Date lastDateInMonth = getLastDayOfTheMonth(jdate);
    return DateHelper.toCastorDate(lastDateInMonth);
  }
  
  //STGAP00012833: Gets the first day of the month
  public static Date getFirstDayOfTheMonth(Date jdate) {
    java.util.GregorianCalendar tempCal = new java.util.GregorianCalendar();
    tempCal.setTime(jdate);
    int firstDayOfMonth = tempCal.getActualMinimum(java.util.GregorianCalendar.DATE);
    tempCal.set(java.util.GregorianCalendar.DATE, firstDayOfMonth);
    return tempCal.getTime();
  }

  public static int getYear(Date trainingDate) {
    Calendar rightNow = Calendar.getInstance();
    rightNow.setTime(trainingDate);
    return rightNow.get(Calendar.YEAR);

  }

  public static int getMonth(Date trainingDate) {
    Calendar rightNow = Calendar.getInstance();
    rightNow.setTime(trainingDate);
    return rightNow.get(Calendar.MONTH);

  }

  public static boolean isSameYear(Date trngDate, Date today) {
    int trngYear = getYear(trngDate);
    int currentYear = getYear(today);
    if (trngYear == currentYear) {
      return true;
    } else {
      return false;
    }

  }

  public static boolean isEqual(org.exolab.castor.types.Date cDate1, org.exolab.castor.types.Date cDate2) {
    // If they are the same reference (both null or both the same object),
    // or they are both non-null and have the same long value, they are equal.
    // noinspection ObjectEquality
    return (cDate1 == cDate2) || (cDate1 != null && cDate2 != null && cDate1.toLong() == cDate2.toLong());
  }

  public static boolean isEqual(Date jDate1, Date jDate2) {
    // If they are the same reference (both null or both the same object),
    // or they are both non-null and have the same long value, they are equal.
    // noinspection ObjectEquality
    return (jDate1 == jDate2) || (jDate1 != null && jDate1.equals(jDate2));
  }
  
  /**
   * This method checks to see if the passed-in date is valid
   * @param jDate - the java date to be validated
   * @return
   */
  public static boolean isValidDate(Date jDate){
    try{
      Date testDate = new Date();
      testDate.compareTo(jDate);
      return true;
    }catch(Exception e){
      return false;
    }
  }
  
  /**
   * This method checks to see if the passed-in date is valid
   * @param cDate - the castor date to be validated
   * @return
   */
  public static boolean isValidDate(org.exolab.castor.types.Date cDate){
    try{
      org.exolab.castor.types.Date testDate = new org.exolab.castor.types.Date();
      testDate.compareTo(cDate);
      return true;
    }catch(Exception e){
      return false;
    }
  }
}
