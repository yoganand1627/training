package gov.georgia.dhr.dfcs.sacwis.core.utility;

import gov.georgia.dhr.dfcs.sacwis.core.utility.Date;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateAndTimeException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The DateUtility Class is part of the Date Utility framework. It allows a user to compute reoccurring dates, compare
 * ranges of date objects, and calculate the age of an individual
 * 
 * @author Phillip T. Bernard
 */
/*
 * Change History: Date User Description -------- ---------------- --------------------------------------------------
 * 02/24/05 Todd Reser SIR 23274 - Needed to create a function to calculate the age on any given date instead of only
 * from the current date, so get Age was recoded to call the newly developed getAge (birthdate, fromdate)
 */
public class DateUtility {
  /**
   * Creates a vector containing all dates within a specified range, reoccurring at a specified interval. The method
   * takes as a parameters a beginning date, an ending date, a increment field, and an increment amount. The increment
   * field should be one of the corresponding increment field constants of the DateUtility Class. This parameter
   * identifies which attribute to increment. The increment amount parameter identifies the amount by which the field
   * should be incremented. <p/>
   * <P>
   * For Example, to obtain a vector containing all the Mondays in the month of June of 2002, the appropriate code would
   * be:<BR>
   * <CODE>Date begin = new Date( 1, 3, 2002 ); //The first monday in June<BR>
   * Date end = new Date( 30, 6, 2002 );<BR>
   * Vector range = DateUtility.getDatesInRange( begin, end, DateUtility.WEEK, 1 );</CODE>
   * </P>
   * <p/>
   * <P>
   * The following DateUtility class constants should be used to identify the field that is supposed to be incremented:<BR>
   * <CODE>
   * <UL>
   * <LI>DateUtility.DATE</LI>
   * <LI>DateUtility.WEEK</LI>
   * <LI>DateUtility.MONTH</LI>
   * <LI>DateUtility.YEAR</LI>
   * <LI>DateUtility.HOUR</LI>
   * <LI>DateUtility.MINUTE</LI>
   * <LI>DateUtility.SECOND</LI>
   * <LI>DateUtility.MILLISECOND</LI>
   * </UL>
   * </CODE>
   * </P>
   * 
   * @param rangeStart
   *          The beginning date in the range
   * @param rangeEnd
   *          The ending date in the range
   * @param incrementField
   *          Static variable of field
   * @param incrementAmount
   *          The amount to increment
   * @return Vector containing recurring dates within the range
   */
  public static List getDatesInRange(Date rangeStart, Date rangeEnd, int incrementField, int incrementAmount) {
    List rangeOfDates = new ArrayList();
    Date incrementDate = (Date) rangeStart.clone();

    switch (incrementField) {
    case DateUtility.DAY: {
      while (!incrementDate.after(rangeEnd)) {
        rangeOfDates.add(incrementDate);
        incrementDate.addDays(incrementAmount);
      }
      break;
    }
    case DateUtility.WEEK: {
      while (!incrementDate.after(rangeEnd)) {
        rangeOfDates.add(incrementDate);
        incrementDate.addWeeks(incrementAmount);
      }
      break;
    }
    case DateUtility.MONTH: {
      while (!incrementDate.after(rangeEnd)) {
        rangeOfDates.add(incrementDate);
        incrementDate.addMonths(incrementAmount);
      }
      break;
    }
    case DateUtility.YEAR: {
      while (!incrementDate.after(rangeEnd)) {
        rangeOfDates.add(incrementDate);
        incrementDate.addYears(incrementAmount);
      }
      break;
    }
    case DateUtility.HOUR: {
      while (!incrementDate.after(rangeEnd)) {
        rangeOfDates.add(incrementDate);
        incrementDate.addHours(incrementAmount);
      }
      break;
    }
    case DateUtility.MINUTE: {
      while (!incrementDate.after(rangeEnd)) {
        rangeOfDates.add(incrementDate);
        incrementDate.addMinutes(incrementAmount);
      }
      break;
    }
    case DateUtility.SECOND: {
      while (!incrementDate.after(rangeEnd)) {
        rangeOfDates.add(incrementDate);
        incrementDate.addSeconds(incrementAmount);
      }
      break;
    }
    case DateUtility.MILLISECOND: {
      while (!incrementDate.after(rangeEnd)) {
        rangeOfDates.add(incrementDate);
        incrementDate.addMilliseconds(incrementAmount);
      }
      break;
    }
    }
    return rangeOfDates;
  }

  /**
   * Determines if two date ranges are separated by exactly one day at the end points. This method determines if the
   * beginning and ending of two distinct ranges of dates occur exactly one day appart. The method also allows for the
   * comparison of a single date to a given range by allowing the same date to be entered as both the start date and end
   * date of the target range. In this instance,the method would determine if the target date is separated from either
   * the start or end of the other date range by exactly one day. <p/>
   * <P>
   * Example: January 1, 2002 - January 3, 2002 and January 4, 2002 - January 8, 2002 are discretely adjacent
   * </P>
   * 
   * @param rangeStart
   *          The beginning of the first range
   * @param rangeEnd
   *          The end of the first range
   * @param targetStart
   *          The beginning of the second range
   * @param targetEnd
   *          The end of the second range
   * @return True if the two ranges are discretely adjacent; false otherwise
   */
  public static boolean isDiscretelyAdjacent(Date rangeStart, Date rangeEnd, Date targetStart, Date targetEnd) {
    boolean adjacent = false;

    rangeEnd.addDays(1);
    targetEnd.addDays(1);

    if (targetStart.equals(rangeEnd) || rangeStart.equals(targetEnd)) {
      adjacent = true;
    }

    return adjacent;
  }

  /**
   * Determines if two specified date ranges share a common endpoint. This method determines if the beginning and ending
   * dates of two distinct ranges are equal. This method will return false if the two ranges overlap one another, only
   * the endpoints may be equal for the method to return true. The method may also be used to determine if a single date
   * is equal to the endpoints of a given range by entering the same date for both the start and end points of the
   * target range. <p/>
   * <P>
   * Example: January 1, 2002 - January 3, 2002 and January 3, 2002 - January 8, 2002 are continuously adjacent
   * </P>
   * 
   * @param rangeStart
   *          The beginning of the first range
   * @param rangeEnd
   *          The end of the first range
   * @param targetStart
   *          The beginning of the second range
   * @param targetEnd
   *          The end of the second range
   * @return True if the ranges are continuously adjacent; false otherwise
   */
  public static boolean isContinuouslyAdjacent(Date rangeStart, Date rangeEnd, Date targetStart, Date targetEnd) {
    boolean adjacent = false;

    if (targetEnd.equals(rangeStart) || targetStart.equals(rangeEnd)) {
      adjacent = true;
    }

    return adjacent;
  }

  /**
   * Determines if one specified range lies completely outside of another range. This method determines if two distinct
   * date ranges lie completely outside one another. The method can also be used to determine if a single date lies
   * completely outside a specified range, by entering the same date for both the start and end dates of the target
   * range. <p/>
   * <P>
   * Example: January 1, 2002 - January 3, 2002 is outside of January 6, 2002 - January 8, 2002
   * </P>
   * 
   * @param rangeStart
   *          The beginning of the first range
   * @param rangeEnd
   *          The end of the first range
   * @param targetStart
   *          The beginning of the second range
   * @param targetEnd
   *          The end of the second range
   * @return True if the second range is completely outside the first; false otherwise
   */
  public static boolean isOutside(Date rangeStart, Date rangeEnd, Date targetStart, Date targetEnd) {
    boolean outside = false;

    if ((targetStart.after(rangeEnd)) || (targetEnd.before(rangeStart))) {
      outside = true;
    }

    return outside;
  }

  /**
   * Determines if two specified date ranges overlap each other. This method determines if two distinct date ranges
   * overlap one another. The method will return true if the two ranges parially or completely overlap one another. The
   * method can also be used to determine if a single date overlaps a given range, by entering the same date object for
   * both the start and end points of the target date range. <p/>
   * <P>
   * Example: January 1, 2002 - January 7, 2002 overlaps January 6, 2002 - January 8, 2002
   * </P>
   * 
   * @param rangeStart
   *          The beginning of the first range
   * @param rangeEnd
   *          The end of the first range
   * @param targetStart
   *          The beginning of the second range
   * @param targetEnd
   *          The end of the second range
   * @return True if the two ranges overlap; false otherwise
   */
  public static boolean overlaps(Date rangeStart, Date rangeEnd, Date targetStart, Date targetEnd) {
    return !(DateUtility.isOutside(rangeStart, rangeEnd, targetStart, targetEnd));
  }

  /**
   * Determines if one specified date range lies completely within another range. This method determines if the target
   * date range is wholly contained within another date range. The method can also be used to determine if a specific
   * date is contained within a specified range, by entering the same date for both the start and end dates of the
   * target range. <p/>
   * <P>
   * Example: January 1, 2002 - January 12, 2002 contains January 6, 2002 - January 8, 2002
   * </P>
   * 
   * @param rangeStart
   *          The beginning of the first range
   * @param rangeEnd
   *          The end of the first range
   * @param targetStart
   *          The beginning of the second range
   * @param targetEnd
   *          The end of the second range
   * @return True if the second range is falls completely within the first; false otherwise
   */
  public static boolean contains(Date rangeStart, Date rangeEnd, Date targetStart, Date targetEnd) {
    boolean contained = false;

    if (!(targetStart.before(rangeStart)) && !(targetEnd.after(rangeEnd))) {
      contained = true;
    }

    return contained;
  }

  /**
   * Determins if a specific date is contained within the dates stored in a given ArrayList. The method takes an
   * ArrayList of dates and a target date to locate. If the target date is included within the ArrayList collection, the
   * method returns true.
   * 
   * @param range
   *          The ArrayList of date objects
   * @param target
   *          The specified date
   * @return True if the target date is contained among those in the ArrayList; false othewise
   * @throws DateAndTimeException
   */
  public static boolean contains(List range, Date target) throws DateAndTimeException {
    boolean contained = false;
    Iterator iterator = range.iterator();

    try {
      while (iterator.hasNext()) {
        if (target.equals((Date) iterator.next())) {
          contained = true;
          break;
        }
      }
    } catch (NoSuchElementException nsee) {
      throw new DateAndTimeException("Error iterating Date ArrayList", nsee);
    } catch (ClassCastException cce) {
      throw new DateAndTimeException("ArrayList does not contained specified objects", cce);
    }
    return contained;
  }

  /**
   * Determins if a specific time is contained within the times stored in a given ArrayList. The method takes an
   * ArrayList of times and a target time to locate. If the target time is included within the ArrayList collection, the
   * method returns true.
   * 
   * @param range
   *          The ArrayList of time objects
   * @param target
   *          The specified time
   * @return True if the target time is contained among those in the Array; false otherwise
   * @throws DateAndTimeException
   */
  public static boolean contains(List range, Time target) throws DateAndTimeException {
    boolean contained = false;
    Iterator iterator = range.iterator();

    try {
      while (iterator.hasNext()) {
        if (target.equals((Time) iterator.next())) {
          contained = true;
          break;
        }
      }
    } catch (NoSuchElementException nsee) {
      throw new DateAndTimeException("Error iterating Date ArrayList", nsee);
    } catch (ClassCastException cce) {
      throw new DateAndTimeException("ArrayList does not contained specified objects", cce);
    }
    return contained;
  }

  /**
   * Determines if a string representation of a date is a valid date object. The method attempts to create a date object
   * from the input string using the four pre-defined date class mask constants. If the date is not formatted according
   * to one of these four masks, the method throws an exception.
   * 
   * @param formattedDate
   *          The string representation of a date object
   * @throws DateAndTimeException
   * @return New date object equal to the string date
   */
  public static Date validateAsDate(String formattedDate) throws DateAndTimeException {
    Date validDate = null;

    while (true) {
      try {
        validDate = new Date(formattedDate, Date.LONG_NUMERIC_MASK);
        break;
      } catch (DateAndTimeException date) {
      }

      try {
        validDate = new Date(formattedDate, Date.SHORT_NUMERIC_MASK);
        break;
      } catch (DateAndTimeException date) {
      }

      try {
        validDate = new Date(formattedDate, Date.LONG_TEXT_MASK);
        break;
      } catch (DateAndTimeException date) {
      }

      try {
        validDate = new Date(formattedDate, Date.SHORT_TEXT_MASK);
        break;
      } catch (DateAndTimeException date) {
      }

      throw new DateAndTimeException("Invalid Date");
    }

    return validDate;
  }

  /**
   * Determines if a string representation of a time is a valid time object. The method attempts to create a time object
   * from the input string using the two pre-defined time class mask constants. If the time is not formatted according
   * to one of these two masks, the method throws an exception.
   * 
   * @param formattedTime
   *          The string representation of a time object
   * @return New time object equal to the string time
   * @throws DateAndTimeException
   */
  public static Time validateAsTime(String formattedTime) throws DateAndTimeException {
    Time validTime = null;

    while (true) {
      try {
        validTime = new Time(formattedTime, Time.LONG_NUMERIC_MASK);
        break;
      } catch (DateAndTimeException date) {
      }

      try {
        validTime = new Time(formattedTime, Time.SHORT_NUMERIC_MASK);
        break;
      } catch (DateAndTimeException de) {
      }

      throw new DateAndTimeException("Invalid Time");
    }

    return validTime;
  }

  // SIR 23274 - Needed to create a function to calculate the age on any given
  // date instead of only from the current date, so get Age was recoded to call
  // the newly developed getAge (birthdate, fromdate)

  /**
   * Calculates a person's age given their birthdate. Given a date object equal to the birthdate of an individual, the
   * method will return the person's age.
   * 
   * @param birthdate
   *          The person's birthdate
   * @return A person's age
   */
  public static int getAge(Date birthdate) {
    return getAge(birthdate, new Date());
  }

  // SIR 23274 - Needed to create a function to calculate the age on any given
  // date instead of only from the current date.

  /**
   * Calculates a person's age given their birthdate and the from date. Given a date object equal to the birthdate of an
   * individual, and the date in time you want the age calculated from the method will return the person's age.
   * 
   * @param birthdate
   *          The person's birthdate
   * @param fromDate
   *          The date you want the person's age calculated from
   * @return A person's age
   */
  public static int getAge(Date birthdate, Date fromDate) {
    int age = fromDate.getYear() - birthdate.getYear();

    // 19662, Matthew McClain, changed to bd.getDayOfMonth > fromDate.getDayOfMonth
    if ((birthdate.getMonth() > fromDate.getMonth()) || // birthday has already occured
        ((birthdate.getMonth() == fromDate.getMonth()) && // birthday occurrs in the current month
        ((birthdate.getDayOfMonth() > fromDate.getDayOfMonth())))) {
      age = age - 1;
    }

    return age;
  }

  public static int getAgeInMonths(java.util.Date fromDate, java.util.Date toDate) {
    if (fromDate == null) {
      return 0;
    }
    if (toDate == null) {
      toDate = new java.util.Date();
    }
    Date ourFromDate = new Date();
    ourFromDate.setTime(fromDate);

    Date ourToDate = new Date();
    ourToDate.setTime(toDate);

    return getAgeInMonths(ourFromDate, ourToDate);
  }

  public static int getAgeInMonths(Date fromDate, Date toDate) {
    if (fromDate == null) {
      return 0;
    }
    if (toDate == null) {
      toDate = new Date();
    }
    int ageYears = toDate.getYear() - fromDate.getYear();
    int ageMonths = toDate.getMonth() - fromDate.getMonth();
    int ageDays = toDate.getDayOfMonth() - fromDate.getDayOfMonth();
    if (ageMonths < 0) {
      ageYears--;
      ageMonths += 12;
    }
    if (ageDays < 0) {
      ageMonths--;
    }
    if (ageMonths < 0) {
      ageYears--;
      ageMonths += 12;
    }
    return (ageYears * 12) + ageMonths;
  }

  /**
   * Determines NonBusiness Hour from date
   * 
   *
   * 
   * @param date
   *          The beginning of the first range
   * @return True if NonBusinessHour; false otherwise
   */
  public static boolean isNonBusinessHour(java.util.Date date) {

    Calendar cal = new GregorianCalendar();
    cal.setTime(date);
    int day = cal.get(Calendar.DAY_OF_WEEK);
    int timeHour24 = cal.get(Calendar.HOUR_OF_DAY);
    day= day-1;
    // Check the day is Staurday or Sunday, if not check for time is between 5:00 and 8:00am
    if ((day != DateHelper.SUNDAY) && (day != DateHelper.SATURDAY)) {
      // start time is after 5pm or before 8am or end time is before
      // or exactly 8am or after 5pm.
      if ((timeHour24 >= 17) || (timeHour24 < 8)) {
        return true;
      }

    } else {
      // Day is saturday or sunday
      return true;
    }
    return false;
  }

  // -- Static Constants --
  public static final int DAY = 1;

  public static final int WEEK = 2;

  public static final int MONTH = 3;

  public static final int YEAR = 4;

  public static final int HOUR = 5;

  public static final int MINUTE = 6;

  public static final int SECOND = 7;

  public static final int MILLISECOND = 8;
}
