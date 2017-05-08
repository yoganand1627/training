package gov.georgia.dhr.dfcs.sacwis.core.utility;

//-- Java classes --

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateAndTimeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * The architecture Time class is part of the Date Utility framework.  It allows for the creation and manipulation of
 * all time objects.
 *
 * @author Phillip T. Bernard
 */

public class Time extends GregorianCalendar implements Comparable<Calendar> {
  /** Time Constructor creates a new time object set to the current time. */
  public Time() {
  }

  /**
   * Time Constructor creates a new time object set according to the millisecond value input parameter.
   *
   * @param milliseconds Specified time in milliseconds
   */
  public Time(long milliseconds) {
    super.setTimeInMillis(milliseconds);
  }

  /**
   * Time Constructor sets the time to be equal to a specific input time in string format.
   * <p/>
   * <P>The method also accepts an additional string parameter, the mask.  The mask defines the format of the input
   * time.  For example, if the input time is "4:30:00 PM", the mask input should be Time.LONG_NUMERIC_MASK, which is
   * the time class's pre-defined format for such an input. There are two pre-defined masks for the time class.
   * Additional formats can be created using the SimpleDateFormat class located within the java.text package.</P>
   *
   * @param formattedTime The string format of the time to be set
   * @param mask          One of the two specific masks of the class
   * @throws gov.georgia.dhr.dfcs.sacwis.core.utility.DateAndTimeException
   */
  public Time(String formattedTime, String mask) throws DateAndTimeException {
    try {
      SimpleDateFormat timeFormat = new SimpleDateFormat(mask);
      super.setTime(timeFormat.parse(formattedTime));
    }
    catch (ParseException pe) {
      throw new DateAndTimeException("The Time you entered cannot be parsed", pe);
    }
  }

  /**
   * Time Constructor sets the time to the specified hour, minute, second, millisecond and AM/PM value.
   *
   * @param hours        The hours to be set
   * @param minutes      The minutes to be set
   * @param seconds      The seconds to be set
   * @param milliseconds The milliseconds to be set
   * @param PM           True if time is in the PM; false otherwise
   */
  public Time(int hours, int minutes, int seconds, int milliseconds, boolean PM) {
    this.setHours(hours);
    this.setMinutes(minutes);
    this.setSeconds(seconds);
    this.setMilliseconds(milliseconds);
    this.setPM(PM);
  }

  /**
   * Time Constructor sets the time to be the specified hour, minute, second and millisecond value.  The hour input
   * parameter should be entered according to the 24 hour scale.  Therefore, passing in the hour 20, will set the time
   * to be 8pm.
   *
   * @param hours        The hours to be set
   * @param minutes      The minutes to be set
   * @param seconds      The seconds to be set
   * @param milliseconds The milliseconds to be set
   */
  public Time(int hours, int minutes, int seconds, int milliseconds) {
    this.setHours(hours);
    this.setMinutes(minutes);
    this.setSeconds(seconds);
    this.setMilliseconds(milliseconds);
  }

  /**
   * Returns the hour for the current time object.  The hour returned using the 12 Hour scale. Thus, 23:00:00 will
   * return 11 not 23.
   *
   * @return int The current hour
   */
  public int getHours() {
    return super.get(GregorianCalendar.HOUR);
  }

  /**
   * Sets the hour for the current time object.  The hour value is set using the 24 hour scale. Therefore, setting the
   * hour of 11 will set the value to be 11am, setting the hour to 23 will set the time to 11pm.
   *
   * @param hours The specified hour value
   */
  public void setHours(int hours) {
    super.set(GregorianCalendar.HOUR_OF_DAY, hours);
  }

  /**
   * Returns the minutes for the current time object. The value returned by this method can range from 0 to 59.
   *
   * @return int The current minutes
   */
  public int getMinutes() {
    return super.get(GregorianCalendar.MINUTE);
  }

  /**
   * Sets the minutes for the current time object.    If the minute value set is greater 59 the hour value is increase
   * as well as the minute value.  If the minute value set is less than 0, the minute value is decreased.  If the minute
   * value set is less than -59 the hour value is decreased along with the minute value..
   *
   * @param minutes The specified minute value
   */
  public void setMinutes(int minutes) {
    super.set(GregorianCalendar.MINUTE, minutes);
  }

  /**
   * Returns the seconds for the current time object. The value returned by this method can range from 0 to 59.
   *
   * @return int The current seconds
   */
  public int getSeconds() {
    return super.get(GregorianCalendar.SECOND);
  }

  /**
   * Sets the seconds for the current time object.  If the second value set is greater 59 the minute value is increase
   * as well as the second value.  If the second value set is less than 0 the second value is decreased.  If the second
   * value set is less than -59 the minute value is decreased along with the second value.
   *
   * @param seconds the specified seconds value
   */
  public void setSeconds(int seconds) {
    super.set(GregorianCalendar.SECOND, seconds);
  }

  /**
   * Returns the milliseconds for the current time object.  The value returne by this method can range between 0 and
   * 999.
   *
   * @return int The current milliseconds
   */
  public int getMilliseconds() {
    return super.get(GregorianCalendar.MILLISECOND);
  }

  /**
   * Sets the milliseconds for the current time object.  If the millisecond value set is greater 999 the second value is
   * increase as well as the millisecond value.  If the millisecond value set is less than 0 the millisecond value is
   * decreased.  If the millisecond value set is less than -999 the second value is decreased along with the millisecond
   * value.
   *
   * @param milliseconds the specifed millisecond value
   */
  public void setMilliseconds(int milliseconds) {
    super.set(GregorianCalendar.MILLISECOND, milliseconds);
  }

  /**
   * Determines if the current time is in the PM.  The method returns true if the current time is in the PM, and false
   * if the current time is in the AM.
   *
   * @return True if the current time is in the PM; false otherwise
   */
  public boolean isPM() {
    boolean pm = false;

    if (super.get(GregorianCalendar.AM_PM) == 1) {
      pm = true;
    }

    return pm;
  }

  /**
   * Sets the current time to be in the PM.  This method can be used to ensure that the current time is in AM or PM.  If
   * the time is currently 11AM, passing in a value of true will set the time to be 11PM.  Inversely, if the time is
   * currently 11PM passing in a value of false will set the time to be 11AM.
   *
   * @param pm Set to true if the time is in the PM
   */
  public void setPM(boolean pm) {
    if (this.isPM()) {
      if (!pm) {
        this.addHours(-12);
      }
    } else {
      if (pm) {
        this.addHours(12);
      }
    }
  }

  /**
   * Adds a time object to the current time.  The time addition method adds the two times' hour, minute, second, and
   * millisecond values together, and sets the current time object's hour, minute, second, and millisecond values to be
   * the sum.
   *
   * @param time The time object to be added
   */
  public void addTime(Time time) {
    this.addHours(time.getHours());
    this.addMinutes(time.getMinutes());
    this.addSeconds(time.getSeconds());
    this.addMilliseconds(time.getMilliseconds());
  }

  /**
   * Subtracts a time object from the current time.  The time subtraction method subtracts the input time object's hour,
   * minute, second and millisecond from the current time and sets the current time object's hour, minute, second, and
   * millisecond values to be the difference.
   *
   * @param time The time object to be subtracted
   */
  public void subtractTime(Time time) {
    this.addHours(-time.getHours());
    this.addMinutes(-time.getMinutes());
    this.addSeconds(-time.getSeconds());
    this.addMilliseconds(-time.getMilliseconds());
  }

  /**
   * Creates a duplicate clone of the current time object.  Overrides clone in the <code>Calendar</code> class.
   *
   * @return A clone of the current time object
   */
  public Time cloneTime() {
    return (Time) super.clone();
  }

  /**
   * Determines if two time objects are equal.  This method compares the hour, minute, second, millisecond, and AM/PM
   * values of two objects two determine equality.
   *
   * @param time The time object to equate
   * @return True if the two time objects are equal; false otherwise
   */
  public boolean equals(Time time) {
    boolean isEqual = false;
    if ((this.getHours() == time.getHours()) &&
        (this.getMinutes() == time.getMinutes()) &&
        (this.getSeconds() == time.getSeconds()) &&
        (this.getMilliseconds() == time.getMilliseconds()) &&
        (this.isPM() == time.isPM())) {
      isEqual = true;
    }

    return isEqual;
  }

  /**
   * Determines if the current time object occurs before another.  This method compares the current time object's AM/PM,
   * hour, minute, second, and millisecond values with the corresponding values of the input time.
   *
   * @param time The time to compare against
   */
  public boolean before(Time time) {
    boolean isBefore = false;

    if (!this.isPM() && time.isPM()) {
      isBefore = true;
    } else if (this.isPM() == time.isPM()) {
      if (this.getHours() < time.getHours()) {
        isBefore = true;
      } else if (this.getHours() == time.getHours()) {
        if (this.getMinutes() < time.getMinutes()) {
          isBefore = true;
        } else if (this.getMinutes() == time.getMinutes()) {
          if (this.getSeconds() < time.getSeconds()) {
            isBefore = true;
          } else if (this.getSeconds() == time.getSeconds()) {
            if (this.getMilliseconds() < time.getMilliseconds()) {
              isBefore = true;
            }
          }
        }
      }
    }

    return isBefore;
  }

  /**
   * Determines if the current time object occurs after another.  This method compares the current time object's AM/PM,
   * hour, minute, second, and millisecond values with the corresponding values of the input time.
   *
   * @param time The time to compare against
   */
  public boolean after(Time time) {
    boolean isAfter = false;

    if (!this.before(time) && !this.equals(time)) {
      isAfter = true;
    }

    return isAfter;
  }

  /**
   * Compares the current time against another time for sequential order. This method is the implementation of the
   * comparable interface, it compares two time objects to determine if the current time object is before, after, or
   * equal to the input parameter time object.  The method returns a primitive int value corresponding to the result of
   * the comparison. A -1 is returned if the current time is before the input time, 0 is returned if the current time is
   * equal to the input time, and 1 is return if the current time occurs after the input time.
   *
   * @param time The specified time to be compared
   * @return -1, 0, 1 if the current time occurs before, at, or after the specified time
   */
  public int compareTo(Calendar time) {
    int result = 0;

    if (this.after(time)) {
      result = 1;
    }
    if (this.before(time)) {
      result = -1;
    }
    return result;
  }

  /**
   * Formats this time object according to a specific format mask. This method returns the current time object as a
   * string.  The time will be written in a specific format defined by the input string parameter.
   * <p/>
   * <P>The mask defines the format of the output string.  For example, if the mask input is the Time.LONG_NUMERIC_MASK,
   * which is one of the time class's pre-defined formats, the output string will have the format "12:00:00 AM".  There
   * are two pre-defined masks for the time class. Additional formats can be created using the SimpleDateFormat class
   * located within the java.text package.</P>
   *
   * @param mask One of the two class specified masks
   * @return String representation of the time object in the mask format
   */
  public String format(String mask) throws DateAndTimeException {
    String formattedDate;

    try {
      SimpleDateFormat timeFormat = new SimpleDateFormat(mask);
      formattedDate = timeFormat.format(super.getTime());
    }
    catch (IllegalArgumentException iae) {
      throw new DateAndTimeException("Invalid Format Entered", iae);
    }

    return formattedDate;
  }

  /**
   * Adds the specified number of hours to the current time object.  If the input value is less than 0 the hours will
   * decrease by the input amount.
   *
   * @param hours The number of hours to be added
   */
  public void addHours(int hours) {
    super.add(GregorianCalendar.HOUR, hours);
  }

  /**
   * Adds the specified number of minutes to the current time object.  If the minute value added is greater 59 the hour
   * value will increase as well as the minute value.  If the minute value added is less than 0 the minute value is
   * decreased.  If the minute value added is less than -59 the hour value is decreased along with the minute value.
   *
   * @param minutes The number of minutes to be added
   */
  public void addMinutes(int minutes) {
    super.add(GregorianCalendar.MINUTE, minutes);
  }

  /**
   * Adds the specified number of seconds to the current time object.  If the second value added is greater 59 the
   * minute value will increase as well as the second value.  If the second value added is less than 0 the second value
   * is decreased.  If the second value added is less than -59 the minute value is decreased along with the second
   * value.
   *
   * @param seconds The number of seconds to be added
   */
  public void addSeconds(int seconds) {
    super.add(GregorianCalendar.SECOND, seconds);
  }

  /**
   * Adds the specified number of milliseconds to the current time object.  If the millisecond value added is greater
   * than 999 the second value will increase as well as the millisecond value.  If the millisecond value added is less
   * than 0 the millisecond value is decreased.  If the millisecond value added is less than -999 the second value is
   * decreased along with the millisecond value.
   *
   * @param milliseconds The number of milliseconds to be added
   */
  public void addMilliseconds(int milliseconds) {
    super.add(GregorianCalendar.MILLISECOND, milliseconds);
  }

  /**
   * Converts the current time object into a primitive long value to convert C-IV time objects into java.sql.Time
   * objects.
   * <p/>
   * <P>The following code creates a java.sql.Time object equal to a given C-IV time object<BR> <CODE>java.sql.Time
   * sqlTime = new java.sql.Time( prsTime.asMilliseconds() );</CODE>
   *
   * @return long Current time in milliseconds
   */
  public long asMilliseconds() {
    return super.getTimeInMillis();
  }

  /**
   * Creates a string representation of the current time object.  The hour, minute, second, millisecond, and AM/PM
   * values of the current time object are returned as a string.
   *
   * @return Time object as a String
   */
  public String toString() {
    String timeToString = null;
    try {
      timeToString = this.format(toStringFormat);
    }
    catch (DateAndTimeException date) {
    }
    return timeToString;
  }

  // -- Instance varaiables
  private final String toStringFormat = "hh:mm:ss:SS a";

  // -- Static Constants --
  /**
   * The LONG_NUMERIC_MASK represents the numerical representation of <I>Hour:minute:second AM/PM</I>. <P>(i.e. 12:35:06
   * AM)</P>
   */
  public static final String LONG_NUMERIC_MASK = "hh:mm:ss a";
  /** The SHORT_NUMERIC_MASK represents the numerical representation of <I>Hour:minute AM/PM</I>. <P>(i.e. 12:45 PM)</P> */
  public static final String SHORT_NUMERIC_MASK = "hh:mm a";
}







