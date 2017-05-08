package gov.georgia.dhr.dfcs.sacwis.core.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;

/**
 * The architecture Date class is part of the Date Utility framework.  It allows for the creation and manipulation of
 * all C-IV date objects.
 *
 * @author Phillip T. Bernard
 */
public class Date extends GregorianCalendar {
  /** Date Constructor sets the date to be the current day and sets the time component to be the current time. */
  public Date() {
  }

  /**
   * Date Constructor sets the date according to the millisecond value input as a parameter.
   *
   * @param milliseconds The date, in milliseconds, to be set
   */
  public Date(long milliseconds) {
    super.setTimeInMillis(milliseconds);
  }

  /**
   * Date Constructor sets the date to be equal to a specific input date in string format.
   * <p/>
   * <P>The method also accepts an additional string parameter, the mask.  The mask defines the format of the input
   * date.  For example, if the input date is "01/01/2001", the mask input should be Date.LONG_NUMERIC_MASK, which is
   * the date class' pre-defined format for such an input. There are four pre-defined masks for the Date class.
   * Additional formats can be created using the SimpleDateFormat class located within the java.text package.</P>
   *
   * @param formattedDate The date in string form
   * @param mask          One of the four specific masks of the class
   * @throws DateAndTimeException
   */
  public Date(String formattedDate, String mask) throws DateAndTimeException {
    try {
      super.set(GregorianCalendar.HOUR_OF_DAY, 0);
      super.set(GregorianCalendar.MINUTE, 0);
      super.set(GregorianCalendar.SECOND, 0);
      super.set(GregorianCalendar.MILLISECOND, 0);

      SimpleDateFormat dateFormat = new SimpleDateFormat(mask);
      super.setTime(dateFormat.parse(formattedDate));
    }
    catch (ParseException pe) {
      throw new DateAndTimeException("The Date cannot be parsed", pe);
    }
  }

  public Date(org.exolab.castor.types.Date cDate) {
    setTime(cDate.toDate());
  }

  /**
   * Date Constructor sets the date to the specified day, month, and year.
   *
   * @param day   The day to be set
   * @param month The month to be set
   * @param year  The year to be set
   */
  public Date(int day, int month, int year) {
    super(year, month, day);
    this.setMonth(month);                             // C-IV Month != Java Month
    super.set(GregorianCalendar.HOUR_OF_DAY, 0);
    super.set(GregorianCalendar.MINUTE, 0);
    super.set(GregorianCalendar.SECOND, 0);
    super.set(GregorianCalendar.MILLISECOND, 0);
  }

  /**
   * Returns a primitive int representing the day of the week of the date object.
   * <p/>
   * <P>The day of the week conversion is as follows: <UL> <LI>Sunday = 1</LI> <LI>Monday = 2</LI> <LI>Tuesday = 3</LI>
   * <LI>Wednesday = 4</LI> <LI>Thursday = 5</LI> <LI>Friday = 6</LI> <LI>Saturday = 7</LI> </UL></P>
   *
   * @return int corresponding to current day of the week
   */
  public int getDayOfWeek() {
    return (super.get(GregorianCalendar.DAY_OF_WEEK));
  }

  /**
   * Sets the day of the week of the date object.  The input is a primitive int representing one of the days of the
   * week.  Because the days of the week are static constants inherited by the date class, the day of the week can be
   * specified using the notation Date.SUNDAY, Date.MONDAY, Date.TUESDAY, etc.
   * <p/>
   * <P>The following code sets the day of the week to be Monday.<BR> <CODE>myDateObject.setDayOfWeek( Date.MONDAY
   * );</CODE></P>
   *
   * @param dayOfWeek The day of the week to be set
   */
  public void setDayOfWeek(int dayOfWeek) {
    super.set(GregorianCalendar.DAY_OF_WEEK, (dayOfWeek));
  }

  /**
   * Returns a primitive int value corresponding to the day of the month for the date object. The value of the day of
   * the month will range from 1 to 31.
   *
   * @return int corresponding to current day of the month
   */
  public int getDayOfMonth() {
    return super.get(GregorianCalendar.DAY_OF_MONTH);
  }

  /**
   * Sets the day of the month according to the primitive int input.  The input can range from 1 to 31.
   *
   * @param dayOfMonth The day of the month to be set
   */
  public void setDayOfMonth(int dayOfMonth) {
    super.set(GregorianCalendar.DAY_OF_MONTH, dayOfMonth);
  }

  /**
   * Returns the week of the month for the date object. The first week of a month is defined as the earliest set of at
   * least one or more days occuring before the first sunday of the month.
   * <p/>
   * <P>For example, January 01, 2001 occurs on a Monday.  Therefore, the first week of January 2001 consists of Monday
   * the first through Saturday the sixth.  The second week of the month would begin the following day Sunday the
   * seventh, which is the first sunday of the month.</P>
   *
   * @return int corresponding to current week of the month
   */
  public int getWeekOfMonth() {
    return super.get(GregorianCalendar.WEEK_OF_MONTH);
  }

  /**
   * Sets the week of the month of the date object to a specific value.
   *
   * @param weekOfMonth The week of the month to be set
   */
  public void setWeekOfMonth(int weekOfMonth) {
    super.set(GregorianCalendar.WEEK_OF_MONTH, weekOfMonth);
  }

  /**
   * Returns a primitive int corresponding to the month of the date object.
   * <p/>
   * <P>The month conversion is as follows: <UL> <LI>January = 1</LI> <LI>February = 2</LI> <LI>March = 3</LI> <LI>April
   * = 4</LI> <LI>May = 5</LI> <LI>June = 6</LI> <LI>July = 7</LI> <LI>August = 8</LI> <LI>September = 9</LI>
   * <LI>October = 10</LI> <LI>November = 11</LI> <LI>December = 12</LI> </UL></P>
   *
   * @return int corresponding to current month
   */
  public int getMonth() {
    return (super.get(GregorianCalendar.MONTH) + 1);
  }

  /**
   * Sets the month of the date object.  The input parameter is a primitive int value corresponding to one of the static
   * constants of the class.  Therefore, the month can be defined by the notation Date.JANUARY, Date.FEBRUARY,
   * Date.MARCH, etc.
   * <p/>
   * <P>The following example sets the month to June:<BR> <CODE>myDateObject.setMonth( Date.JUNE );</CODE></P>
   *
   * @param month The month to be set
   */
  public void setMonth(int month) {
    super.set(GregorianCalendar.MONTH, (month - 1));
  }

  /**
   * Returns a primitive int representing the year of the current date object.  The year is represented using four
   * digits.  (i.e. 2002 is returned not 02)
   *
   * @return int corresponding to current year
   */
  public int getYear() {
    return super.get(GregorianCalendar.YEAR);
  }

  /**
   * Sets the year of the date object to equal a specific four digit value.  The year is represented using four digits,
   * therefore, 02 is not a valid input and 2002 is a valid input.
   *
   * @param year The year to be set
   */
  public void setYear(int year) {
    super.set(GregorianCalendar.YEAR, year);
  }

  /**
   * Returns a new time object constructed from the current date object.  This method converts a C-IV Date object into a
   * C-IV Time object.
   *
   * @return Time object set to current date object
   */
  public Time getTimeOfDay() {
    return new Time(this.asMilliseconds());
  }

  /**
   * Sets the current date object from a given time object.  This method allows the time component of a given date
   * object to be set independently of the date construction.
   *
   * @param time The time object used to set the date object's time component.
   */
  public void setTimeOfDay(Time time) {
    super.set(HOUR, time.getHours());
    super.set(MINUTE, time.getMinutes());
    super.set(SECOND, time.getSeconds());
    super.set(MILLISECOND, time.getMilliseconds());
    if (time.isPM()) {
      super.set(AM_PM, 1);
    }
  }


  /**
   * Determines if the date is a weekday.  A weekeday being any day of the week except Saturday and Sunday.
   *
   * @return True if this date is a weekday; false otherwise
   */
  public boolean isWeekday() {
    boolean weekday = true;

    if (this.getDayOfWeek() == Date.SUNDAY || this.getDayOfWeek() == Date.SATURDAY) {
      weekday = false;
    }

    return weekday;
  }

  /**
   * Adds a date object to the current date.  The date addition method adds the two dates' days of the month, month, and
   * year values together, and sets the current date object's day of the month, month, and year values to be the sum.
   *
   * @param date The date object to be added
   */
  public void addDate(Date date) {
    this.addDays(date.getDayOfMonth());
    this.addMonths(date.getMonth());
    this.addYears(date.getYear());
  }

  /**
   * Subtracts a date object from the current date.  The date subtraction method subtracts the input parameter date
   * object's day of the month, month, and year from the current date and sets the current date object's day of the
   * month, month, and year values to be the difference.
   *
   * @param date The date object to be subtracted
   */
  public void subtractDate(Date date) {
    this.addDays(-date.getDayOfMonth());
    this.addMonths(-date.getMonth());
    this.addYears(-date.getYear());
  }

  /**
   * Creates a duplicate clone of the current date object.  Overrides clone in the <code>Calendar</code> class.
   *
   * @return A clone of the current date object
   */
  public Date clone() {
    return (Date) super.clone();
  }

  /**
   * Determines if two dates are equal, ignores time components.  This method compares two date objects for equality,
   * ignoring the date objects time components.  Therefore, comparing January 1, 2001 12:00AM with January 1, 2001
   * 4:00PM will return true because the two dates are share the same day month and year.
   *
   * @param date The date to compare
   * @return True if the two date objects are the same day; false otherwise
   */
  public boolean isSameDay(Date date) {
    boolean sameDay = false;

    if (this.getDayOfMonth() == date.getDayOfMonth() &&
        this.getMonth() == date.getMonth() &&
        this.getYear() == date.getYear()) {
      sameDay = true;
    }
    return sameDay;
  }

  /**
   * Determines if the current date occurs before another date, ignores time components.  The method compares two date
   * objects to determine if the current date object occurs before the input date object, ignoring the date objects'
   * time components.  Therefore, if the current date is January 1, 2001 12:00AM, comparing it with January 1, 2002
   * 12:00AM will return true because 2001 occurs before 2002.
   *
   * @param date The date to compare against
   * @return True if the current date object occurs before another date; false otherwise
   */
  public boolean isDayBefore(Date date) {
    boolean isBefore = false;

    if (this.getYear() < date.getYear()) {
      isBefore = true;
    } else if (this.getYear() == date.getYear()) {
      if (this.getMonth() < date.getMonth()) {
        isBefore = true;
      } else if (this.getMonth() == date.getMonth()) {
        if (this.getDayOfMonth() < date.getDayOfMonth()) {
          isBefore = true;
        }
      }
    }

    return isBefore;
  }

  /**
   * Determines if the current date occurs after another date, ignores time components.  The method compares two date
   * objects to determine if the current date occurs after the input date, ignoring the date objects' time components.
   * Therefore, if the current date is January 1, 2001 12:00AM, comparing it with January 1, 2001 4:00PM will return
   * false because the dates' years, months, and days are equal and the time component is ignored.
   *
   * @param date The date to compare against
   * @return True if the current date object occurs after another date; false otherwise
   */
  public boolean isDayAfter(Date date) {
    boolean isAfter = false;

    if (!this.isDayBefore(date) && !this.isSameDay(date)) {
      isAfter = true;
    }

    return isAfter;
  }

  /**
   * Compares the current date against another date for sequential order, ignores the time components.  This method
   * functions similarly to the <code>compareTo</code> method, however, this method does not consider the time
   * components of the date objects.  The method returns a value of -1 if the current date occurs before the input date,
   * a value of 0 if the current date is equal to the input date, and a value of 1 if the current date occurs after the
   * input date.
   *
   * @param date The specified date to be compared
   * @return -1, 0, 1 if the current date is before, equal, or after the specified date
   */
  public int compareDayOnly(Date date) {
    int result = 0;

    if (this.isDayAfter(date)) {
      result = 1;
    }
    if (this.isDayBefore(date)) {
      result = -1;
    }

    return result;
  }

  /**
   * Formats this date object according to a specific format mask. This method returns the current date object as a
   * string.  The date will be written in a specific format defined by the input string parameter.
   * <p/>
   * <P>The mask defines the format of the output string.  For example, if the mask input is the Date.LONG_NUMERIC_MASK,
   * which is one of the date class's pre-defined formats, the output string will have the format "01/01/2001".  There
   * are four pre-defined masks for the Date class. Additional formats can be created using the SimpleDateFormat class
   * located within the java.text package.</P>
   *
   * @param mask One of the four class specified masks
   * @return String representation of the date object
   * @throws DateAndTimeException
   */
  public String format(String mask) throws DateAndTimeException {
    String formattedDate;

    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat(mask);
      formattedDate = dateFormat.format(super.getTime());
    }
    catch (IllegalArgumentException iae) {
      throw new DateAndTimeException("Invalid Mask Entered", iae);
    }

    return formattedDate;
  }

  /**
   * Adds a specified number of days to the current date object.
   *
   * @param days The number of days to be added
   */
  public void addDays(int days) {
    super.add(GregorianCalendar.DAY_OF_MONTH, days);
  }

  /**
   * Adds a specified number of weeks to the current date object
   *
   * @param weeks The number of weeks to be added
   */
  public void addWeeks(int weeks) {
    super.add(GregorianCalendar.WEEK_OF_YEAR, weeks);
  }

  /**
   * Adds a specified number of years to the current date object
   *
   * @param years The number of years to be added
   */
  public void addYears(int years) {
    super.add(GregorianCalendar.YEAR, years);
  }

  /**
   * Adds a specified number of months to the current date object
   *
   * @param months The number of months to be added
   */
  public void addMonths(int months) {
    super.add(GregorianCalendar.MONTH, months);
  }

  /**
   * Adds a specified number of hours to the current date object
   *
   * @param hours The number of hours to be added
   */
  public void addHours(int hours) {
    super.add(GregorianCalendar.HOUR, hours);
  }

  /**
   * Adds a specified number of minutes to the current date object
   *
   * @param minutes The number of minutes to be added
   */
  public void addMinutes(int minutes) {
    super.add(GregorianCalendar.MINUTE, minutes);
  }

  /**
   * Adds a specified number of seconds to the current date object
   *
   * @param seconds The number of seconds to be added
   */
  public void addSeconds(int seconds) {
    super.add(GregorianCalendar.SECOND, seconds);
  }

  /**
   * Adds a specified number of milliseconds to the current date object
   *
   * @param milliseconds The number of milliseconds to be added
   */
  public void addMilliseconds(int milliseconds) {
    super.add(GregorianCalendar.MILLISECOND, milliseconds);
  }

  /**
   * Converts the current date object into a primitive long value to convert C-IV date objects into java.sql.Date
   * objects.
   * <p/>
   * <P>The following code creates a java.sql.Date object equal to a given C-IV date object<BR> <CODE>java.sql.Date
   * sqlDate = new java.sql.Date( prsDate.asMilliseconds() );</CODE>
   *
   * @return long The date in milliseconds
   */
  public long asMilliseconds() {
    return super.getTimeInMillis();
  }

  /**
   * Determines if the current date occurs during a leap year
   *
   * @return True if the current year is a leap year; false otherwise
   */
  public boolean isLeapYear() {
    return super.isLeapYear(this.getYear());
  }

  /**
   * Determines the number of days in the month of the current date object. (i.e. If the month is December, the method
   * returns 31)
   *
   * @return int The number of days in the month
   */
  public int numberOfDaysInMonth() {
    return super.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
  }

  /**
   * Creates a string representation of the current date object.  The day, month, year, day of the week, hour, minute,
   * second, and millisecond values of the current date object are returned as a string.
   *
   * @return String Current date as a String
   */
  public String toString() {
    String dateToString = null;

    try {
      dateToString = this.format(toStringFormat);
    }
    catch (DateAndTimeException date) {
    }

    return dateToString;
  }

  /**
   * Creates a castor date from a string date format.  This converts a date string that is passed into a castor date
   * that is needed by input files for the tuxedo services.
   *
   * @return castor Date
   */
  public org.exolab.castor.types.Date convertDate(java.lang.String date) {
    org.exolab.castor.types.Date castorDate = new org.exolab.castor.types.Date();
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date utilDate;
    try {

      utilDate = gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility.validateAsDate(date);
      java.util.Date newdate = utilDate.getTime();
      castorDate = new org.exolab.castor.types.Date(newdate);

    }
    catch (DateAndTimeException e) {

    }
    return castorDate;

  }

  /**
   * Package level Constructor to create the minimun and maximum C-IV dates corresponding to the predefined Oracle
   * minimum and maximum dates.  These Dates will be constructed in the DateUtility Class and allow Users to compare
   * C-IV dates against the Oracle dates.
   *
   * @param day   The day to be set
   * @param month The month to be set
   * @param year  The year to be set
   * @param era   The era to be set
   */
  Date(int day, int month, int year, String era) {
    super(year, month, day);
    this.setMonth(month);
    if ("BC".equals(era)) {
      this.set(Date.ERA, Date.BC);
    }
  }

  //-- Instance Variables --
  private final String toStringFormat = "EEEE, MMMM d, yyyy h:mm:ss:SS a";

  //-- Static Constants --
  public static final int JANUARY = 1;
  public static final int FEBRURARY = 2;
  public static final int MARCH = 3;
  public static final int APRIL = 4;
  public static final int MAY = 5;
  public static final int JUNE = 6;
  public static final int JULY = 7;
  public static final int AUGUST = 8;
  public static final int SEPTEMBER = 9;
  public static final int OCTOBER = 10;
  public static final int NOVEMBER = 11;
  public static final int DECEMBER = 12;

  /** C-IV Date equivalent to Oracle minimum date (January 1, 4712 BC) */
  public static final Date MIN_DATE = new Date(1, 1, 4712, "BC");

  /** C-IV Date equivalent to Oracle maximum date (December 31, 9999 AD) */
  public static final Date MAX_DATE = new Date(31, 12, 9999, "AD");

  /** The LONG_NUMERIC_MASK represents the numerical representation of <I>Month/Day/Year</I>. <P>(i.e. 01/01/2001)</P> */
  public static final String LONG_NUMERIC_MASK = "MM/dd/yyyy";
  /** The SHORT_NUMERIC_MASK represents the numerical representation of <I>Month/Year</I>. <P>(i.e. 01/2001)</P> */
  public static final String SHORT_NUMERIC_MASK = "MM/yyyy";
  /**
   * The LONG_TEXT_MASK represents the alpha-numerical representation of <I>DayOfTheWeek, Month Day, Year</I>. <P>(i.e.
   * Monday, January 01, 2001)</P>
   */
  public static final String LONG_TEXT_MASK = "EEEE, MMMM dd, yyyy";
  /**
   * The SHORT_TEXT_MASK represents the alpha-numerical representation of <I>Month Day, Year</I>. <P>(i.e. January 01,
   * 2001)</P>
   */
  public static final String SHORT_TEXT_MASK = "MMMM dd, yyyy";
  /**
   * The LONG_ALPHANUMERIC_MASK represents the alpha-numerical representation of <I>Month Day, Year Hour:Minute
   * AM/PM</I>.  <P>(i.e. January 01, 2001 08:00 AM)</P>
   */
  public static final String LONG_ALPHANUMERIC_MASK = "MMMM dd, yyyy hh:mm aa";
}






