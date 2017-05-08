package gov.georgia.dhr.dfcs.sacwis.core.utility;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;

/**
 * Helper class consisting of methods that aid in NYTD reporting process.
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   8/31/10   hnguyen   Added helper to aid NYTD processing
 *   9/14/10   hnguyen   Added additional survey status related check
 *   9/15/10   hnguyen   SMS#71396 MR-067 Updated getDtSurveyPeriodEndForRptPeriod
 *                       to handle scenario where survey period end date is after
 *                       reporting period end date
 *   9/17/10   hnguyen   SMS#66384 Corrected variable name and correct logic for survey completion
 *   9/20/10   hnguyen   SMS#66384 Included youth In DFCS Care status as part of getPopulationType method
 *   9/22/10   hnguyen   SMS#66384 Updated logic to account for reporting period starting and ending
 *                       in the middle of the month when determining reporting period begin and end dates.
 *                       Also updated logic for determining survey period.
 *   9/27/10   hnguyen   SMS#73402 Updated isSurveyComplete method to add additional conditions when determining
 *                       survey completion status. Updated isResponseValid to exclude N/A as a valid response.
 *   01/26/11  hnguyen   SMS#93411: Fixed issue with incorrect calculation of survey period end date when child
 *                       DOB is within last 45 days of the year.
 * </pre>
 * 
 * @author Hai Nguyen, 31 August 2010
 */
public abstract class NytdHelper {
  private static final GrndsLogger GLOBAL_EXCEPTION_LOGGER =
    GrndsLogger.getLogger(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                       "exception.globalLogger"));
  private static final String TRACE_TAG = "NytdHelper";

  public static final String BASELINE = "B";

  public static final String FOLLOWUP = "F";

  public static final String SERVED = "S";

  // TODO: this value may need to be fetch from a codes table
  public static final int SURVEY_PERIOD = 45;

  public static final int MILLIS_PER_DAY = (1000 * 60 * 60 * 24);

  public static List<Integer> ageList = Arrays.asList(17, 19, 21);

  private NytdHelper() {
    // Makes this class implicitly final.
  }

  /**
   * Determine reporting period begin date for specified date.
   * 
   * @param dt -
   *                the date to determine which reporting period it falls within
   * @return Date - the begin date of the reporting period of which passed in date falls within
   */
  public static Date getDtRptPeriodBegin(Date dt) {
    Calendar calRptPeriodBegin = Calendar.getInstance();

    calRptPeriodBegin.setTime(dt);

    int dtMonth = calRptPeriodBegin.get(Calendar.MONTH) + 1;
    int dtDay = calRptPeriodBegin.get(Calendar.DAY_OF_MONTH);
    int dtYear = calRptPeriodBegin.get(Calendar.YEAR);

    // Reset time to midnight
    setTimeToMidnight(calRptPeriodBegin);

    int AS_mth = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_AS).substring(0, 2));
    int AS_day = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_AS).substring(2, 4));
    int AE_mth = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_AE).substring(0, 2));
    int AE_day = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_AE).substring(2, 4));

    int BS_mth = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_BS).substring(0, 2));
    int BS_day = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_BS).substring(2, 4));
    int BE_mth = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_BE).substring(0, 2));
    int BE_day = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_BE).substring(2, 4));

    if ((dtMonth >= AS_mth && dtMonth >= AS_day) || (dtMonth <= AE_mth && dtDay <= AE_day)) {
      calRptPeriodBegin.set(Calendar.MONTH, AS_mth - 1);
      calRptPeriodBegin.set(Calendar.DAY_OF_MONTH, AS_day);
      if (dtMonth <= AE_mth && dtDay <= AE_day) {
        calRptPeriodBegin.set(Calendar.YEAR, dtYear - 1);
      } else {
        calRptPeriodBegin.set(Calendar.YEAR, dtYear);
      }
    } else if ((dtMonth >= BS_mth && dtDay >= BS_day) && (dtMonth <= BE_mth && dtDay <= BE_day)) {
      calRptPeriodBegin.set(Calendar.MONTH, BS_mth - 1);
      calRptPeriodBegin.set(Calendar.DAY_OF_MONTH, BS_day);
      calRptPeriodBegin.set(Calendar.YEAR, dtYear);
    }
    return calRptPeriodBegin.getTime();
  }

  /**
   * Determines reporting period end date that current date fall within
   * 
   * @return Date - the end date of the current reporting period
   */
  public static Date getDtRptPeriodEnd() {
    return getDtRptPeriodEnd(new Date());
  }

  /**
   * Determines the end date for the reporting period in which specified date falls within
   * 
   * @param dt -
   *                the date to determine end date of reporting period it falls within
   * @return Date - the end date of the reporting period of which passed in date falls within
   */
  public static Date getDtRptPeriodEnd(Date dt) {
    Calendar calRptPeriodEnd = Calendar.getInstance();

    calRptPeriodEnd.setTime(dt);

    int dtMonth = calRptPeriodEnd.get(Calendar.MONTH) + 1;
    int dtDay = calRptPeriodEnd.get(Calendar.DAY_OF_MONTH);
    int dtYear = calRptPeriodEnd.get(Calendar.YEAR);

    // Reset time to midnight
    setTimeToMidnight(calRptPeriodEnd);

    int AS_mth = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_AS).substring(0, 2));
    int AS_day = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_AS).substring(2, 4));
    int AE_mth = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_AE).substring(0, 2));
    int AE_day = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_AE).substring(2, 4));

    int BS_mth = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_BS).substring(0, 2));
    int BS_day = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_BS).substring(2, 4));
    int BE_mth = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_BE).substring(0, 2));
    int BE_day = Integer.parseInt(Lookup.simpleDecodeSafe(CodesTables.CFEDFY, CodesTables.CFEDFY_BE).substring(2, 4));

    if ((dtMonth >= AS_mth && dtDay >= AS_day) || (dtMonth <= AE_mth && dtDay <= AE_day)) { // between October thru March
      calRptPeriodEnd.set(Calendar.MONTH, AE_mth - 1); // -- March
      calRptPeriodEnd.set(Calendar.DAY_OF_MONTH, AE_day);
      if (dtMonth <= AE_mth && dtDay <= AE_day) { // before April then already in current year
        calRptPeriodEnd.set(Calendar.YEAR, dtYear);
      } else { // if October and later, then set rpt period end year to next year
        calRptPeriodEnd.set(Calendar.YEAR, dtYear + 1);
      }
    } else if ((dtMonth >= BS_mth && dtDay >= BS_day) && (dtMonth <= BE_mth && dtDay <= BE_day)) { // between April thru September
      calRptPeriodEnd.set(Calendar.MONTH, BE_mth - 1); // -- September
      calRptPeriodEnd.set(Calendar.DAY_OF_MONTH, BE_day);
      calRptPeriodEnd.set(Calendar.YEAR, dtYear);
    }
    return calRptPeriodEnd.getTime();
  }

  /**
   * Determines the if current date is within current survey period, if applicable
   * 
   * @param dob -
   *                youth date of birth to determine if survey period is applicable for current reporting period.
   * @return boolean - true if survey period is applicable and current date is within this survey period, false
   *         otherwise.
   */
  public static boolean isDuringSurveyPeriod(Date dob) {
    if( dob == null ){
      return false;
    }

    Calendar calSurveyStart = Calendar.getInstance();
    Calendar calSurveyEnd = Calendar.getInstance();
    Calendar calToday = Calendar.getInstance();

    // get current survey period end date , if applicable
    Date dtActualSurveyEnd = getCurrentSurveyPeriodEnd(dob);

    if (dtActualSurveyEnd == null) {
      return false;
    }

    calSurveyEnd.setTime(dtActualSurveyEnd);
    calSurveyStart.setTime(calSurveyEnd.getTime());

    setTimeToMidnight(calSurveyStart);
    setTimeToMidnight(calSurveyEnd);
    setTimeToMidnight(calToday);

    // survey start is 45 days prior to Survey end date
    // this handles scenario where year changes when going back
    // so many days
    calSurveyStart.add(Calendar.DAY_OF_MONTH, -SURVEY_PERIOD);

    if (calToday.compareTo(calSurveyStart) >= 0 && calToday.compareTo(calSurveyEnd) <= 0) {
      return true;
    }

    return false;
  }

  /**
   * Calculates the number of days from current date until the current survey period end, if applicable
   * 
   * @param dob -
   *                youth date of birth to determine if survey period is applicable for current reporting period and
   *                calculate the number of days until end of survey period.
   * @return int - number of days from current date until the current survey period end.
   */
  public static int getNumDaysLeft(Date dob) {
    if( dob == null){
      return 0;
    }

    int daysLeft = 0;

    Calendar calEndOfSurveyPeriod = Calendar.getInstance();
    Calendar today = Calendar.getInstance();

    // get current survey period date for current reporting period, if applicable
    Date dtCurrentSurveyEnd = getCurrentSurveyPeriodEnd(dob);
    if (dtCurrentSurveyEnd == null) {
      return 0;
    }

    calEndOfSurveyPeriod.setTime(dtCurrentSurveyEnd);
    setTimeToMidnight(calEndOfSurveyPeriod);
    setTimeToMidnight(today);

    // Difference in time in milliseconds divided by milliseconds per day
    daysLeft = (int) ((calEndOfSurveyPeriod.getTimeInMillis() - today.getTimeInMillis()) / MILLIS_PER_DAY);

    // return zero if survey period already ended
    if (daysLeft < 0) {
      return 0;
    }

    return daysLeft;
  }

  /**
   * Return current survey period end date if current date is within that period, null otherwise
   * 
   * @param dob - youth date of birth to determine if current date falls within any survey period.
   * @return Date - if current date is within a survey period return current survey period end date, null otherwise.
   */
  public static Date getCurrentSurveyPeriodEnd(Date dob) {
    if( dob == null){
      return null;
    }
    
    Calendar calSurveyStart = Calendar.getInstance();
    Calendar calSurveyEnd = Calendar.getInstance();
    Calendar calToday = Calendar.getInstance();

    calSurveyStart.setTime(dob);
    calSurveyEnd.setTime(dob);

    setTimeToMidnight(calSurveyStart);
    setTimeToMidnight(calSurveyEnd);
    setTimeToMidnight(calToday);

    calSurveyEnd.add(Calendar.DAY_OF_MONTH, SURVEY_PERIOD);
    int dobYear = calSurveyEnd.get(Calendar.YEAR);

    for (int i = 0; i < ageList.size(); i++) {
      calSurveyEnd.set(Calendar.YEAR, dobYear + ageList.get(i));

      // just in case, it rolls over the next year
      calSurveyStart.setTime(calSurveyEnd.getTime());
      calSurveyStart.add(Calendar.DAY_OF_MONTH, -SURVEY_PERIOD);

      // if current date is within a survey period
      if (calToday.compareTo(calSurveyStart) >= 0 && calToday.compareTo(calSurveyEnd) <= 0) {
        return calSurveyEnd.getTime();
      }
    }

    // current date is not within any survey period, return null
    return null;
  }

  /**
   * Return survey period end date of specified report period end date, if applicable
   * 
   * @param dob - youth date of birth to determine if survey period is applicable for specified reporting period.
   * @return Date - if survey period is applicable for specified reporting period then return survey period end date 
   *                based on youth DOB, null otherwise.
   */
  public static Date getDtSurveyPeriodEndForRptPeriod(Date dob, Date dtRptPeriodEnd) {
    if( dob == null || dtRptPeriodEnd == null){
      return null;
    }
    
    Calendar calSurveyStart = Calendar.getInstance();
    Calendar calSurveyEnd = Calendar.getInstance();
    Calendar calRptPeriodStart = Calendar.getInstance();
    Calendar calRptPeriodEnd = Calendar.getInstance();

    calSurveyStart.setTime(dob);
    calSurveyEnd.setTime(dob);
    calRptPeriodStart.setTime(getDtRptPeriodBegin(dtRptPeriodEnd));
    calRptPeriodEnd.setTime(getDtRptPeriodEnd(dtRptPeriodEnd));

    setTimeToMidnight(calSurveyStart);
    setTimeToMidnight(calSurveyEnd);
    setTimeToMidnight(calRptPeriodStart);
    setTimeToMidnight(calRptPeriodEnd);

    calSurveyEnd.add(Calendar.DAY_OF_MONTH, SURVEY_PERIOD);
    int dobYear = calSurveyEnd.get(Calendar.YEAR);

    for (int i = 0; i < ageList.size(); i++) {
      calSurveyEnd.set(Calendar.YEAR, dobYear + ageList.get(i));

      // just in case, it rolls over the next year
      calSurveyStart.setTime(calSurveyEnd.getTime());
      calSurveyStart.add(Calendar.DAY_OF_MONTH, -SURVEY_PERIOD);

      // if survey period is within specified reporting period then return survey end date
      if (calSurveyStart.compareTo(calRptPeriodStart) >= 0 && calSurveyEnd.compareTo(calRptPeriodEnd) <= 0) {
        return calSurveyEnd.getTime();
      } else if (calSurveyStart.compareTo(calRptPeriodStart) >= 0 
                      && calSurveyStart.compareTo(calRptPeriodEnd) <= 0 
                      && calSurveyEnd.compareTo(calRptPeriodEnd) >= 0) {
        //survey period started in reporting period but survey period ends after reporting period end
        return calSurveyEnd.getTime();
      }
    }

    // specified reporting period does not have a survey period based on child age, return null
    return null;
  }

  /**
   * Determines the if current date is within the passed in grace period days of specified dt
   * 
   * @param dt -
   *                reference date to start grace period.
   * @param days -
   *                number of days from reference date.
   * @return boolean - true if current date is within specified grace period, false otherwise.
   */
  public static boolean isInGracePeriod(Date dt, int days) {
    if( dt == null ){
      return false;
    }
    
    Calendar calGraceEnds = Calendar.getInstance();
    Calendar calToday = Calendar.getInstance();

    calGraceEnds.setTime(dt);
    calGraceEnds.add(Calendar.DAY_OF_MONTH, days);

    setTimeToMidnight(calGraceEnds);
    setTimeToMidnight(calToday);

    Date dtToday = calToday.getTime();

    if (dtToday.compareTo(dt) >= 0 && dtToday.compareTo(calGraceEnds.getTime()) <= 0) {
      return true;
    }

    return false;
  }

  /**
   * Helper methods to reset Calendar object time to midnight down to the millisecond (e.g. 00:00:00:000 )
   * 
   * @param date -
   *                Calendar object to reset time
   * 
   */
  public static void setTimeToMidnight(Calendar date) {
    date.set(Calendar.HOUR_OF_DAY, 0);
    date.set(Calendar.MINUTE, 0);
    date.set(Calendar.SECOND, 0);
    date.set(Calendar.MILLISECOND, 0);
  }

  /**
   * Helper methods to reset Calendar object time to one millisecond before midnight of the next day (e.g. 23:59:59:999 )
   * 
   * @param date -
   *                Calendar object to reset time
   * 
   */
  public static void setTimeToOneMilliSecondBeforeMidnight(Calendar date) {
    date.set(Calendar.HOUR_OF_DAY, 23);
    date.set(Calendar.MINUTE, 59);
    date.set(Calendar.SECOND, 59);
    date.set(Calendar.MILLISECOND, 999);
  }
  
  public static String getPopulationType(int idPerson, Date prsnDOB, Date dtRptPerEnd_In) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getPopulationType");
    performanceTrace.enterScope();

    if( DateHelper.isNull(prsnDOB) || DateHelper.isNull(dtRptPerEnd_In) || idPerson == 0 ){
      return StringHelper.EMPTY_STRING;
    }
    
    Calendar dtRptPeriodEnd = Calendar.getInstance();
    Calendar dtDOB = Calendar.getInstance();
    Calendar dtSurveyPeriodStart = Calendar.getInstance();
    
    int idNytdRandom = 0;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT ID_NYTD_RANDOM FROM NYTD_RANDOM WHERE ID_PERSON = ?";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, idPerson);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        idNytdRandom = resultSet.getInt(1);
      }
      
    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
      
    // Check if reporting period is Baseline or Follow-up reporting year, if not then served population
    if (checkBaselineYear(dtRptPerEnd_In) || checkFollowUp19Year(dtRptPerEnd_In) || checkFollowUp21Year(dtRptPerEnd_In)) {
      
      Date ythDOB = prsnDOB;
      Date surveyStart = null;
      Date surveyEnd = null;
      Date minEndDate = null;
      dtDOB.setTime(ythDOB);
      dtRptPeriodEnd.setTime(ythDOB);
      
      // Reset time to 00:00:00:000 AM midnight
      setTimeToMidnight(dtDOB);
      setTimeToMidnight(dtRptPeriodEnd);

      int dobYear = dtDOB.get(Calendar.YEAR);
      Date dtActualRptPerEnd = new Date();

      dtRptPeriodEnd.set(Calendar.YEAR, dobYear + 17);
      dtActualRptPerEnd = getDtRptPeriodEnd(dtRptPeriodEnd.getTime());
      surveyEnd = getDtSurveyPeriodEndForRptPeriod(ythDOB, dtActualRptPerEnd);
      if(surveyEnd != null ){
        minEndDate = surveyEnd;
        dtSurveyPeriodStart.setTime(surveyEnd);
        dtSurveyPeriodStart.add(Calendar.DAY_OF_MONTH, -SURVEY_PERIOD);
        surveyStart = dtSurveyPeriodStart.getTime();
        
        if( dtRptPerEnd_In.compareTo(surveyEnd) <= 0 ){
          minEndDate = dtRptPerEnd_In;
        }
      }
      if (DateHelper.isEqual(dtActualRptPerEnd, dtRptPerEnd_In) && checkBaselineYear(dtRptPerEnd_In) && isInDFCSCare(idPerson, surveyStart, minEndDate) ) {
        return BASELINE;
      }

      dtRptPeriodEnd.set(Calendar.YEAR, dobYear + 19);
      dtActualRptPerEnd = getDtRptPeriodEnd(dtRptPeriodEnd.getTime());
      if (DateHelper.isEqual(dtActualRptPerEnd, dtRptPerEnd_In) && checkFollowUp19Year(dtRptPerEnd_In) && idNytdRandom != 0) {
        return FOLLOWUP;
      }

      dtRptPeriodEnd.set(Calendar.YEAR, dobYear + 21);
      dtActualRptPerEnd = getDtRptPeriodEnd(dtRptPeriodEnd.getTime());
      if (DateHelper.isEqual(dtActualRptPerEnd, dtRptPerEnd_In) && checkFollowUp21Year(dtRptPerEnd_In) && idNytdRandom != 0) {
        return FOLLOWUP;
      }
    }

    performanceTrace.exitScope();
    return StringHelper.EMPTY_STRING;
  }
  
  public static boolean checkBaselineYear(Date date) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".checkBaselineYear");
    performanceTrace.enterScope();
    
    if( date == null){
      return false;
    }

    int dtYear = DateHelper.getYear(date);
    int retYear = 0;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT NYTD_BASELINE_YEAR FROM NYTD_BASE_FOLLOW_UP_LOOKUP WHERE NYTD_BASELINE_YEAR = ?";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, dtYear);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        retYear = resultSet.getInt(1);
      }
      
    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    performanceTrace.exitScope();

    if ( dtYear == retYear) {
      return true;
    }
    return false;
  }

  public static boolean checkFollowUp19Year(Date date) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".checkFollowUp19Year");
    performanceTrace.enterScope();

    if( date == null){
      return false;
    }

    int dtYear = DateHelper.getYear(date);
    int retYear = 0;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT NYTD_FOLLOWUP_19_YEAR FROM NYTD_BASE_FOLLOW_UP_LOOKUP WHERE NYTD_FOLLOWUP_19_YEAR = ?";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, dtYear);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        retYear = resultSet.getInt(1);
      }
      
    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    performanceTrace.exitScope();

    if ( dtYear == retYear) {
      return true;
    }
    return false;
  }

  public static boolean checkFollowUp21Year(Date date) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".checkFollowUp21Year");
    performanceTrace.enterScope();

    if( date == null){
      return false;
    }

    int dtYear = DateHelper.getYear(date);
    int retYear = 0;
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT NYTD_FOLLOWUP_21_YEAR FROM NYTD_BASE_FOLLOW_UP_LOOKUP WHERE NYTD_FOLLOWUP_21_YEAR = ?";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, dtYear);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        retYear = resultSet.getInt(1);
      }
      
    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    performanceTrace.exitScope();

    if ( dtYear == retYear) {
      return true;
    }
    return false;
  }

  public static boolean isServed(int idPerson, Date dtRptPeriodEnd) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".isServed");
    performanceTrace.enterScope();
    
    if( idPerson == 0 || dtRptPeriodEnd == null){
      return false;
    }

    java.sql.Date sqlDate = new java.sql.Date(dtRptPeriodEnd.getTime());

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    String dbIndAcadSupport = null;
    String dbIndPsEduSupport = null;
    String dbIndCareerPrep = null;
    String dbIndEmpProgVoc = null;
    String dbIndBdgtFinMgt = null;
    String dbIndHousingEdu = null;
    String dbIndHealthEdu = null;
    String dbIndFamMarrEdu = null;
    String dbIndMentoring = null;
    String dbIndSuperIl = null;
    String dbIndRoomBrdFin = null;
    String dbIndEduFinance = null;
    String dbIndOthFinance = null;
    String dbIndIlNeedsAsm = null;
    
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT IND_ACAD_SUPPORT, " +
                "IND_PS_EDU_SUPPORT, " +
                "IND_CAREER_PREP, " +
                "IND_EMP_PROG_VOC, " +
                "IND_BDGT_FIN_MGT, " +
                "IND_HOUSING_EDU, " +
                "IND_HEALTH_EDU, " +
                "IND_FAM_MARR_EDU, " +
                "IND_MENTORING, " +
                "IND_SUPER_IL, " +
                "IND_ROOM_BRD_FIN, " +
                "IND_EDU_FINANCE, " +
                "IND_OTH_FINANCE, " +
                "IND_IL_NEEDS_ASM " +
                "FROM YOUTH_REPORT_DTL " +
                "WHERE ID_PERSON = ? " +
                "AND DT_RPT_PERIOD_END = ?";
      
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, idPerson);
      preparedStatement.setDate(2, sqlDate);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        dbIndAcadSupport = resultSet.getString("IND_ACAD_SUPPORT");
        dbIndPsEduSupport = resultSet.getString("IND_PS_EDU_SUPPORT");
        dbIndCareerPrep = resultSet.getString("IND_CAREER_PREP");
        dbIndEmpProgVoc = resultSet.getString("IND_EMP_PROG_VOC");
        dbIndBdgtFinMgt = resultSet.getString("IND_BDGT_FIN_MGT");
        dbIndHousingEdu = resultSet.getString("IND_HOUSING_EDU");
        dbIndHealthEdu = resultSet.getString("IND_HEALTH_EDU");
        dbIndFamMarrEdu = resultSet.getString("IND_FAM_MARR_EDU");
        dbIndMentoring = resultSet.getString("IND_MENTORING");
        dbIndSuperIl = resultSet.getString("IND_SUPER_IL");
        dbIndRoomBrdFin = resultSet.getString("IND_ROOM_BRD_FIN");
        dbIndEduFinance = resultSet.getString("IND_EDU_FINANCE");
        dbIndOthFinance = resultSet.getString("IND_OTH_FINANCE");
        dbIndIlNeedsAsm = resultSet.getString("IND_IL_NEEDS_ASM");
      }
      
    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    boolean isServed = false;

    if (ArchitectureConstants.Y.equals(dbIndAcadSupport)
        || ArchitectureConstants.Y.equals(dbIndBdgtFinMgt)
        || ArchitectureConstants.Y.equals(dbIndCareerPrep)
        || ArchitectureConstants.Y.equals(dbIndEduFinance)
        || ArchitectureConstants.Y.equals(dbIndEmpProgVoc)
        || ArchitectureConstants.Y.equals(dbIndHealthEdu)
        || ArchitectureConstants.Y.equals(dbIndHousingEdu)
        || ArchitectureConstants.Y.equals(dbIndMentoring)
        || ArchitectureConstants.Y.equals(dbIndOthFinance)
        || ArchitectureConstants.Y.equals(dbIndPsEduSupport)
        || ArchitectureConstants.Y.equals(dbIndRoomBrdFin)
        || ArchitectureConstants.Y.equals(dbIndSuperIl)
        || ArchitectureConstants.Y.equals(dbIndFamMarrEdu)
        || ArchitectureConstants.Y.equals(dbIndIlNeedsAsm)) {
      isServed = true;
    }
    
    performanceTrace.exitScope();
    return isServed;
  }

  public static boolean isServed(int idYouthReportDtl) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".isServed");
    performanceTrace.enterScope();
    
    if( idYouthReportDtl == 0){
      return false;
    }

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    String dbIndAcadSupport = null;
    String dbIndPsEduSupport = null;
    String dbIndCareerPrep = null;
    String dbIndEmpProgVoc = null;
    String dbIndBdgtFinMgt = null;
    String dbIndHousingEdu = null;
    String dbIndHealthEdu = null;
    String dbIndFamMarrEdu = null;
    String dbIndMentoring = null;
    String dbIndSuperIl = null;
    String dbIndRoomBrdFin = null;
    String dbIndEduFinance = null;
    String dbIndOthFinance = null;
    String dbIndIlNeedsAsm = null;
    
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT IND_ACAD_SUPPORT, " +
                "IND_PS_EDU_SUPPORT, " +
                "IND_CAREER_PREP, " +
                "IND_EMP_PROG_VOC, " +
                "IND_BDGT_FIN_MGT, " +
                "IND_HOUSING_EDU, " +
                "IND_HEALTH_EDU, " +
                "IND_FAM_MARR_EDU, " +
                "IND_MENTORING, " +
                "IND_SUPER_IL, " +
                "IND_ROOM_BRD_FIN, " +
                "IND_EDU_FINANCE, " +
                "IND_OTH_FINANCE, " +
                "IND_IL_NEEDS_ASM " +
                "FROM YOUTH_REPORT_DTL " +
                "WHERE ID_YOUTH_REPORT_DTL = ? ";
      
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, idYouthReportDtl);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        dbIndAcadSupport = resultSet.getString("IND_ACAD_SUPPORT");
        dbIndPsEduSupport = resultSet.getString("IND_PS_EDU_SUPPORT");
        dbIndCareerPrep = resultSet.getString("IND_CAREER_PREP");
        dbIndEmpProgVoc = resultSet.getString("IND_EMP_PROG_VOC");
        dbIndBdgtFinMgt = resultSet.getString("IND_BDGT_FIN_MGT");
        dbIndHousingEdu = resultSet.getString("IND_HOUSING_EDU");
        dbIndHealthEdu = resultSet.getString("IND_HEALTH_EDU");
        dbIndFamMarrEdu = resultSet.getString("IND_FAM_MARR_EDU");
        dbIndMentoring = resultSet.getString("IND_MENTORING");
        dbIndSuperIl = resultSet.getString("IND_SUPER_IL");
        dbIndRoomBrdFin = resultSet.getString("IND_ROOM_BRD_FIN");
        dbIndEduFinance = resultSet.getString("IND_EDU_FINANCE");
        dbIndOthFinance = resultSet.getString("IND_OTH_FINANCE");
        dbIndIlNeedsAsm = resultSet.getString("IND_IL_NEEDS_ASM");
      }
      
    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    boolean isServed = false;

    if (ArchitectureConstants.Y.equals(dbIndAcadSupport)
        || ArchitectureConstants.Y.equals(dbIndBdgtFinMgt)
        || ArchitectureConstants.Y.equals(dbIndCareerPrep)
        || ArchitectureConstants.Y.equals(dbIndEduFinance)
        || ArchitectureConstants.Y.equals(dbIndEmpProgVoc)
        || ArchitectureConstants.Y.equals(dbIndHealthEdu)
        || ArchitectureConstants.Y.equals(dbIndHousingEdu)
        || ArchitectureConstants.Y.equals(dbIndMentoring)
        || ArchitectureConstants.Y.equals(dbIndOthFinance)
        || ArchitectureConstants.Y.equals(dbIndPsEduSupport)
        || ArchitectureConstants.Y.equals(dbIndRoomBrdFin)
        || ArchitectureConstants.Y.equals(dbIndSuperIl)
        || ArchitectureConstants.Y.equals(dbIndFamMarrEdu)
        || ArchitectureConstants.Y.equals(dbIndIlNeedsAsm)) {
      isServed = true;
    }
    
    performanceTrace.exitScope();
    return isServed;
  }

  public static boolean isSurveyComplete(int idPerson, Date dtRptPeriodEnd) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".isSurveyComplete");
    performanceTrace.enterScope();
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    java.sql.Date sqlDate = new java.sql.Date(dtRptPeriodEnd.getTime());

    String dbIndEnteredByYth = null;
    String dbCdPopulationType = null;
    String dbCdOutcomeRptStat = null;
    Date dbDtOutcomeDate = null;
    String dbIndFcStatOutcome = null;
    String dbCdCurrFtEmp = null;
    String dbCdCurrPtEmp = null;
    String dbCdEmpSkills = null;
    String dbCdSocialSec = null;
    String dbCdEducAid = null;
    String dbCdOthSupport = null;
    String dbCdHighEdu = null;
    String dbCdCurrAtdEnr = null;
    String dbCdConnAdult = null;
    String dbCdMedicaid = null;
    String dbCdOthHlthInsType = null;
    String dbCdHlthInsMedical = null;
    String dbCdHlthInsMental = null;
    String dbCdHlthInsRx = null;
    String dbCdHomeless = null;
    String dbCdSubAbuseRef = null;
    String dbCdIncarceration = null;
    String dbCdChildren = null;
    String dbCdMarrAtBirth = null;
    String dbCdTanf = null;
    String dbCdFoodStamps = null;
    String dbCdHousingAst = null;
    
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT CD_OUTCOME_RPT_STAT, " +
      		"DT_OUTCOME_DATE, " +
      		"IND_FC_STATUS, " +
      		"IND_CURR_FT_EMP, " +
      		"IND_CURR_PT_EMP, " +
      		"IND_EMP_SKILLS, " +
      		"IND_SOCIAL_SEC, " +
      		"IND_EDUC_AID, " +
      		"IND_OTH_SUPPORT, " +
      		"CD_HIGH_EDU, " +
      		"IND_CURR_ATD_ENR, " +
      		"IND_CONN_ADULT, " +
      		"IND_MEDICAID, " +
      		"CD_OTH_HLTH_INS_TYP, " +
      		"CD_HLTH_INS_MEDICAL, " +
      		"CD_HLTH_INS_MENTAL, " +
      		"CD_HLTH_INS_RX, " +
      		"IND_HOMELESS, " +
      		"IND_SUB_ABUSE_REF, " +
      		"IND_INCARCERATION, " +
      		"IND_CHILDREN, " +
      		"CD_MARR_AT_BIRTH, " +
                "CD_TANF, " +
                "CD_FOOD_STAMPS, " +
                "CD_HOUSING_AST, " +
                "CD_POPULATION_TYPE, " +
                "IND_ENTERED_BY_YTH " +
      		"FROM YOUTH_REPORT_DTL " +
      		"WHERE ID_PERSON = ? " +
      		"AND DT_RPT_PERIOD_END = ? ";
      
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, idPerson);
      preparedStatement.setDate(2, sqlDate);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        dbIndEnteredByYth =  resultSet.getString("IND_ENTERED_BY_YTH");
        dbCdOutcomeRptStat = resultSet.getString("CD_OUTCOME_RPT_STAT");
        dbDtOutcomeDate = resultSet.getDate("DT_OUTCOME_DATE");
        dbIndFcStatOutcome = resultSet.getString("IND_FC_STATUS");
        dbCdCurrFtEmp = resultSet.getString("IND_CURR_FT_EMP");
        dbCdCurrPtEmp = resultSet.getString("IND_CURR_PT_EMP");
        dbCdEmpSkills = resultSet.getString("IND_EMP_SKILLS");
        dbCdSocialSec = resultSet.getString("IND_SOCIAL_SEC");
        dbCdEducAid = resultSet.getString("IND_EDUC_AID");
        dbCdOthSupport = resultSet.getString("IND_OTH_SUPPORT");
        dbCdHighEdu = resultSet.getString("CD_HIGH_EDU");
        dbCdCurrAtdEnr = resultSet.getString("IND_CURR_ATD_ENR");
        dbCdConnAdult = resultSet.getString("IND_CONN_ADULT");
        dbCdMedicaid = resultSet.getString("IND_MEDICAID");
        dbCdOthHlthInsType = resultSet.getString("CD_OTH_HLTH_INS_TYP");
        dbCdHlthInsMedical = resultSet.getString("CD_HLTH_INS_MEDICAL");
        dbCdHlthInsMental = resultSet.getString("CD_HLTH_INS_MENTAL");
        dbCdHlthInsRx = resultSet.getString("CD_HLTH_INS_RX");
        dbCdHomeless = resultSet.getString("IND_HOMELESS");
        dbCdSubAbuseRef = resultSet.getString("IND_SUB_ABUSE_REF");
        dbCdIncarceration = resultSet.getString("IND_INCARCERATION");
        dbCdChildren = resultSet.getString("IND_CHILDREN");
        dbCdMarrAtBirth = resultSet.getString("CD_MARR_AT_BIRTH");
        dbCdTanf = resultSet.getString("CD_TANF");
        dbCdFoodStamps = resultSet.getString("CD_FOOD_STAMPS");
        dbCdHousingAst = resultSet.getString("CD_HOUSING_AST");
      }
      
    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    boolean isComp = true;

    // Not complete if one of the conditions are true
    // 1) No reporting status or outcome date
    // 2) Youth Participated and at least one applicable question unanswered (implicitly declined a question)
    // 3) Implicitly declined by Youth (not answering any questions)
    if ((StringHelper.isEmptyOrNull(dbCdOutcomeRptStat)
                        || dbDtOutcomeDate == null)
        || ((CodesTables.COUTSTAT_YP.equals(dbCdOutcomeRptStat)
                        || (CodesTables.COUTSTAT_YD.equals(dbCdOutcomeRptStat)
                                        && ArchitectureConstants.Y.equals(dbIndEnteredByYth)))
                        && (StringHelper.isEmptyOrNull(dbCdCurrFtEmp)
                              || StringHelper.isEmptyOrNull(dbCdCurrPtEmp)
                              || StringHelper.isEmptyOrNull(dbCdConnAdult)
                              || StringHelper.isEmptyOrNull(dbCdCurrAtdEnr)
                              || StringHelper.isEmptyOrNull(dbCdEducAid)
                              || StringHelper.isEmptyOrNull(dbCdEmpSkills)
                              || StringHelper.isEmptyOrNull(dbCdHighEdu)
                              || StringHelper.isEmptyOrNull(dbCdHomeless)
                              || StringHelper.isEmptyOrNull(dbCdIncarceration)
                              || StringHelper.isEmptyOrNull(dbCdMedicaid)
                              || StringHelper.isEmptyOrNull(dbCdOthSupport)
                              || StringHelper.isEmptyOrNull(dbCdSocialSec)
                              || StringHelper.isEmptyOrNull(dbCdSubAbuseRef)
                              || StringHelper.isEmptyOrNull(dbCdChildren)
                              || (ArchitectureConstants.Y.equals(StringHelper.getNonNullString(dbCdChildren)) 
                                              && (StringHelper.isEmptyOrNull(dbCdMarrAtBirth)
                                                              || CodesTables.CINVACAN_A.equals(dbCdMarrAtBirth)))
                              || StringHelper.isEmptyOrNull(dbCdOthHlthInsType)
                              || (ArchitectureConstants.Y.equals(StringHelper.getNonNullString(dbCdOthHlthInsType)) 
                                              && (StringHelper.isEmptyOrNull(dbCdHlthInsMedical)
                                                              || CodesTables.CINVACAN_A.equals(dbCdHlthInsMedical)))
                              || (ArchitectureConstants.Y.equals(StringHelper.getNonNullString(dbCdOthHlthInsType)) 
                                              && ArchitectureConstants.Y.equals(StringHelper.getNonNullString(dbCdHlthInsMedical)) 
                                              && (StringHelper.isEmptyOrNull(dbCdHlthInsMental) 
                                                              || CodesTables.CINVACAN_A.equals(dbCdHlthInsMental)
                                                              || StringHelper.isEmptyOrNull(dbCdHlthInsRx)
                                                              || CodesTables.CINVACAN_A.equals(dbCdHlthInsRx)))
                              // check followup not in care questions, if applicable
                              || ((FOLLOWUP.equals(dbCdPopulationType)
                                              && ArchitectureConstants.N.equals(StringHelper.getNonNullString(dbIndFcStatOutcome)))
                                              // at least one of the follow not in care question is empty or null, therefore not complete
                                              && (StringHelper.isEmptyOrNull(dbCdTanf)
                                                              || CodesTables.CINVACAN_A.equals(dbCdTanf)
                                                              || StringHelper.isEmptyOrNull(dbCdFoodStamps)
                                                              || CodesTables.CINVACAN_A.equals(dbCdFoodStamps)
                                                              || StringHelper.isEmptyOrNull(dbCdHousingAst)
                                                              || CodesTables.CINVACAN_A.equals(dbCdHousingAst)))))) {
      isComp = false;
    }
    
    performanceTrace.exitScope();
    return isComp;
  }

  public static boolean isSurveyComplete(int idYouthReportDtl) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".isSurveyComplete");
    performanceTrace.enterScope();
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    String dbCdPopulationType = null;
    String dbCdOutcomeRptStat = null;
    Date dbDtOutcomeDate = null;
    String dbIndFcStatOutcome = null;
    String dbCdCurrFtEmp = null;
    String dbCdCurrPtEmp = null;
    String dbCdEmpSkills = null;
    String dbCdSocialSec = null;
    String dbCdEducAid = null;
    String dbCdOthSupport = null;
    String dbCdHighEdu = null;
    String dbCdCurrAtdEnr = null;
    String dbCdConnAdult = null;
    String dbCdMedicaid = null;
    String dbCdOthHlthInsType = null;
    String dbCdHlthInsMedical = null;
    String dbCdHlthInsMental = null;
    String dbCdHlthInsRx = null;
    String dbCdHomeless = null;
    String dbCdSubAbuseRef = null;
    String dbCdIncarceration = null;
    String dbCdChildren = null;
    String dbCdMarrAtBirth = null;
    String dbCdTanf = null;
    String dbCdFoodStamps = null;
    String dbCdHousingAst = null;
    String dbIndEnteredByYth = null;
    
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT CD_OUTCOME_RPT_STAT, " +
                "DT_OUTCOME_DATE, " +
                "IND_FC_STATUS, " +
                "IND_CURR_FT_EMP, " +
                "IND_CURR_PT_EMP, " +
                "IND_EMP_SKILLS, " +
                "IND_SOCIAL_SEC, " +
                "IND_EDUC_AID, " +
                "IND_OTH_SUPPORT, " +
                "CD_HIGH_EDU, " +
                "IND_CURR_ATD_ENR, " +
                "IND_CONN_ADULT, " +
                "IND_MEDICAID, " +
                "CD_OTH_HLTH_INS_TYP, " +
                "CD_HLTH_INS_MEDICAL, " +
                "CD_HLTH_INS_MENTAL, " +
                "CD_HLTH_INS_RX, " +
                "IND_HOMELESS, " +
                "IND_SUB_ABUSE_REF, " +
                "IND_INCARCERATION, " +
                "IND_CHILDREN, " +
                "CD_MARR_AT_BIRTH, " +
                "CD_TANF, " +
                "CD_FOOD_STAMPS, " +
                "CD_HOUSING_AST, " +
                "CD_POPULATION_TYPE, " +
                "IND_ENTERED_BY_YTH " +
                "FROM YOUTH_REPORT_DTL " +
                "WHERE ID_YOUTH_REPORT_DTL = ? ";
      
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, idYouthReportDtl);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        dbIndEnteredByYth = resultSet.getString("IND_ENTERED_BY_YTH");
        dbCdOutcomeRptStat = resultSet.getString("CD_OUTCOME_RPT_STAT");
        dbDtOutcomeDate = resultSet.getDate("DT_OUTCOME_DATE");
        dbIndFcStatOutcome = resultSet.getString("IND_FC_STATUS");
        dbCdCurrFtEmp = resultSet.getString("IND_CURR_FT_EMP");
        dbCdCurrPtEmp = resultSet.getString("IND_CURR_PT_EMP");
        dbCdEmpSkills = resultSet.getString("IND_EMP_SKILLS");
        dbCdSocialSec = resultSet.getString("IND_SOCIAL_SEC");
        dbCdEducAid = resultSet.getString("IND_EDUC_AID");
        dbCdOthSupport = resultSet.getString("IND_OTH_SUPPORT");
        dbCdHighEdu = resultSet.getString("CD_HIGH_EDU");
        dbCdCurrAtdEnr = resultSet.getString("IND_CURR_ATD_ENR");
        dbCdConnAdult = resultSet.getString("IND_CONN_ADULT");
        dbCdMedicaid = resultSet.getString("IND_MEDICAID");
        dbCdOthHlthInsType = resultSet.getString("CD_OTH_HLTH_INS_TYP");
        dbCdHlthInsMedical = resultSet.getString("CD_HLTH_INS_MEDICAL");
        dbCdHlthInsMental = resultSet.getString("CD_HLTH_INS_MENTAL");
        dbCdHlthInsRx = resultSet.getString("CD_HLTH_INS_RX");
        dbCdHomeless = resultSet.getString("IND_HOMELESS");
        dbCdSubAbuseRef = resultSet.getString("IND_SUB_ABUSE_REF");
        dbCdIncarceration = resultSet.getString("IND_INCARCERATION");
        dbCdChildren = resultSet.getString("IND_CHILDREN");
        dbCdMarrAtBirth = resultSet.getString("CD_MARR_AT_BIRTH");
        dbCdTanf = resultSet.getString("CD_TANF");
        dbCdFoodStamps = resultSet.getString("CD_FOOD_STAMPS");
        dbCdHousingAst = resultSet.getString("CD_HOUSING_AST");
      }
      
    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    boolean isComp = true;

    // Not complete if one of the conditions are true
    // 1) No reporting status or outcome date
    // 2) Youth Participated and at least one applicable question unanswered (implicitly declined a question)
    // 3) Implicitly declined by Youth (not answering any questions)
    if ((StringHelper.isEmptyOrNull(dbCdOutcomeRptStat)
                        || dbDtOutcomeDate == null)
        || ((CodesTables.COUTSTAT_YP.equals(dbCdOutcomeRptStat)
                        || (CodesTables.COUTSTAT_YD.equals(dbCdOutcomeRptStat)
                                        && ArchitectureConstants.Y.equals(dbIndEnteredByYth)))
                        && (StringHelper.isEmptyOrNull(dbCdCurrFtEmp)
                              || StringHelper.isEmptyOrNull(dbCdCurrPtEmp)
                              || StringHelper.isEmptyOrNull(dbCdConnAdult)
                              || StringHelper.isEmptyOrNull(dbCdCurrAtdEnr)
                              || StringHelper.isEmptyOrNull(dbCdEducAid)
                              || StringHelper.isEmptyOrNull(dbCdEmpSkills)
                              || StringHelper.isEmptyOrNull(dbCdHighEdu)
                              || StringHelper.isEmptyOrNull(dbCdHomeless)
                              || StringHelper.isEmptyOrNull(dbCdIncarceration)
                              || StringHelper.isEmptyOrNull(dbCdMedicaid)
                              || StringHelper.isEmptyOrNull(dbCdOthSupport)
                              || StringHelper.isEmptyOrNull(dbCdSocialSec)
                              || StringHelper.isEmptyOrNull(dbCdSubAbuseRef)
                              || StringHelper.isEmptyOrNull(dbCdChildren)
                              || (ArchitectureConstants.Y.equals(StringHelper.getNonNullString(dbCdChildren)) 
                                              && (StringHelper.isEmptyOrNull(dbCdMarrAtBirth)
                                                              || CodesTables.CINVACAN_A.equals(dbCdMarrAtBirth)))
                              || StringHelper.isEmptyOrNull(dbCdOthHlthInsType)
                              || (ArchitectureConstants.Y.equals(StringHelper.getNonNullString(dbCdOthHlthInsType)) 
                                              && (StringHelper.isEmptyOrNull(dbCdHlthInsMedical)
                                                              || CodesTables.CINVACAN_A.equals(dbCdHlthInsMedical)))
                              || (ArchitectureConstants.Y.equals(StringHelper.getNonNullString(dbCdOthHlthInsType)) 
                                              && ArchitectureConstants.Y.equals(StringHelper.getNonNullString(dbCdHlthInsMedical)) 
                                              && (StringHelper.isEmptyOrNull(dbCdHlthInsMental) 
                                                              || CodesTables.CINVACAN_A.equals(dbCdHlthInsMental)
                                                              || StringHelper.isEmptyOrNull(dbCdHlthInsRx)
                                                              || CodesTables.CINVACAN_A.equals(dbCdHlthInsRx)))
                              // check followup not in care questions, if applicable
                              || ((FOLLOWUP.equals(dbCdPopulationType)
                                              && ArchitectureConstants.N.equals(StringHelper.getNonNullString(dbIndFcStatOutcome)))
                                              // at least one of the follow not in care question is empty or null, therefore not complete
                                              && (StringHelper.isEmptyOrNull(dbCdTanf)
                                                              || CodesTables.CINVACAN_A.equals(dbCdTanf)
                                                              || StringHelper.isEmptyOrNull(dbCdFoodStamps)
                                                              || CodesTables.CINVACAN_A.equals(dbCdFoodStamps)
                                                              || StringHelper.isEmptyOrNull(dbCdHousingAst)
                                                              || CodesTables.CINVACAN_A.equals(dbCdHousingAst)))))) {
      isComp = false;
    }
    
    performanceTrace.exitScope();
    return isComp;
  }

  // Determines if survey has at least one valid response, meaning one answer provided that is not a Declined response.
  public static boolean isSurveyValid(int idPerson, Date dtRptPeriodEnd) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".isSurveyValid");
    performanceTrace.enterScope();
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    java.sql.Date sqlDate = new java.sql.Date(dtRptPeriodEnd.getTime());

    String dbCdPopulationType = null;
    String dbCdOutcomeRptStat = null;
    Date dbDtOutcomeDate = null;
    String dbIndFcStatOutcome = null;
    String dbCdCurrFtEmp = null;
    String dbCdCurrPtEmp = null;
    String dbCdEmpSkills = null;
    String dbCdSocialSec = null;
    String dbCdEducAid = null;
    String dbCdOthSupport = null;
    String dbCdHighEdu = null;
    String dbCdCurrAtdEnr = null;
    String dbCdConnAdult = null;
    String dbCdMedicaid = null;
    String dbCdOthHlthInsType = null;
    String dbCdHlthInsMedical = null;
    String dbCdHlthInsMental = null;
    String dbCdHlthInsRx = null;
    String dbCdHomeless = null;
    String dbCdSubAbuseRef = null;
    String dbCdIncarceration = null;
    String dbCdChildren = null;
    String dbCdMarrAtBirth = null;
    String dbCdTanf = null;
    String dbCdFoodStamps = null;
    String dbCdHousingAst = null;
    
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT CD_OUTCOME_RPT_STAT, " +
                "DT_OUTCOME_DATE, " +
                "IND_FC_STATUS, " +
                "IND_CURR_FT_EMP, " +
                "IND_CURR_PT_EMP, " +
                "IND_EMP_SKILLS, " +
                "IND_SOCIAL_SEC, " +
                "IND_EDUC_AID, " +
                "IND_OTH_SUPPORT, " +
                "CD_HIGH_EDU, " +
                "IND_CURR_ATD_ENR, " +
                "IND_CONN_ADULT, " +
                "IND_MEDICAID, " +
                "CD_OTH_HLTH_INS_TYP, " +
                "CD_HLTH_INS_MEDICAL, " +
                "CD_HLTH_INS_MENTAL, " +
                "CD_HLTH_INS_RX, " +
                "IND_HOMELESS, " +
                "IND_SUB_ABUSE_REF, " +
                "IND_INCARCERATION, " +
                "IND_CHILDREN, " +
                "CD_MARR_AT_BIRTH, " +
                "CD_TANF, " +
                "CD_FOOD_STAMPS, " +
                "CD_HOUSING_AST, " +
                "CD_POPULATION_TYPE " +
                "FROM YOUTH_REPORT_DTL " +
                "WHERE ID_PERSON = ? " +
                "AND DT_RPT_PERIOD_END = ? ";
      
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, idPerson);
      preparedStatement.setDate(2, sqlDate);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        dbCdOutcomeRptStat = resultSet.getString("CD_OUTCOME_RPT_STAT");
        dbDtOutcomeDate = resultSet.getDate("DT_OUTCOME_DATE");
        dbIndFcStatOutcome = resultSet.getString("IND_FC_STATUS");
        dbCdCurrFtEmp = resultSet.getString("IND_CURR_FT_EMP");
        dbCdCurrPtEmp = resultSet.getString("IND_CURR_PT_EMP");
        dbCdEmpSkills = resultSet.getString("IND_EMP_SKILLS");
        dbCdSocialSec = resultSet.getString("IND_SOCIAL_SEC");
        dbCdEducAid = resultSet.getString("IND_EDUC_AID");
        dbCdOthSupport = resultSet.getString("IND_OTH_SUPPORT");
        dbCdHighEdu = resultSet.getString("CD_HIGH_EDU");
        dbCdCurrAtdEnr = resultSet.getString("IND_CURR_ATD_ENR");
        dbCdConnAdult = resultSet.getString("IND_CONN_ADULT");
        dbCdMedicaid = resultSet.getString("IND_MEDICAID");
        dbCdOthHlthInsType = resultSet.getString("CD_OTH_HLTH_INS_TYP");
        dbCdHlthInsMedical = resultSet.getString("CD_HLTH_INS_MEDICAL");
        dbCdHlthInsMental = resultSet.getString("CD_HLTH_INS_MENTAL");
        dbCdHlthInsRx = resultSet.getString("CD_HLTH_INS_RX");
        dbCdHomeless = resultSet.getString("IND_HOMELESS");
        dbCdSubAbuseRef = resultSet.getString("IND_SUB_ABUSE_REF");
        dbCdIncarceration = resultSet.getString("IND_INCARCERATION");
        dbCdChildren = resultSet.getString("IND_CHILDREN");
        dbCdMarrAtBirth = resultSet.getString("CD_MARR_AT_BIRTH");
        dbCdTanf = resultSet.getString("CD_TANF");
        dbCdFoodStamps = resultSet.getString("CD_FOOD_STAMPS");
        dbCdHousingAst = resultSet.getString("CD_HOUSING_AST");
      }
      
    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    boolean isValid = false;

    if (isResponseValid(dbCdCurrFtEmp) || isResponseValid(dbCdCurrPtEmp)
        || isResponseValid(dbCdConnAdult) || isResponseValid(dbCdCurrAtdEnr)
        || isResponseValid(dbCdEducAid) || isResponseValid(dbCdEmpSkills)
        || isResponseValid(dbCdHighEdu) || isResponseValid(dbCdHomeless)
        || isResponseValid(dbCdIncarceration) || isResponseValid(dbCdMedicaid)
        || isResponseValid(dbCdOthSupport) || isResponseValid(dbCdSocialSec)
        || isResponseValid(dbCdSubAbuseRef) || isResponseValid(dbCdChildren)
        || isResponseValid(dbCdMarrAtBirth) || isResponseValid(dbCdOthHlthInsType)
        || isResponseValid(dbCdHlthInsMedical) || isResponseValid(dbCdHlthInsMental)
        || isResponseValid(dbCdHlthInsRx)) {
      // at least one baseline question was answered
      isValid = true;
    }

    // if population is followup
    // check followup not in care questions
    if (FOLLOWUP.equals(dbCdPopulationType)
        && ArchitectureConstants.N.equals(StringHelper.getNonNullString(dbIndFcStatOutcome))) {
      if (isResponseValid(dbCdHousingAst) 
                      || isResponseValid(dbCdFoodStamps)
                      || isResponseValid(dbCdTanf)) {
        // at least one follow up not in care was answered
        isValid = true;
      }
    }
    performanceTrace.exitScope();
    return isValid;
  }

  // Determines if survey has at least one valid response, meaning one answer provided that is not a Declined response.
  public static boolean isSurveyValid(int idYouthReportDtl) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".isSurveyValid");
    performanceTrace.enterScope();
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    String dbCdPopulationType = null;
    String dbCdOutcomeRptStat = null;
    Date dbDtOutcomeDate = null;
    String dbIndFcStatOutcome = null;
    String dbCdCurrFtEmp = null;
    String dbCdCurrPtEmp = null;
    String dbCdEmpSkills = null;
    String dbCdSocialSec = null;
    String dbCdEducAid = null;
    String dbCdOthSupport = null;
    String dbCdHighEdu = null;
    String dbCdCurrAtdEnr = null;
    String dbCdConnAdult = null;
    String dbCdMedicaid = null;
    String dbCdOthHlthInsType = null;
    String dbCdHlthInsMedical = null;
    String dbCdHlthInsMental = null;
    String dbCdHlthInsRx = null;
    String dbCdHomeless = null;
    String dbCdSubAbuseRef = null;
    String dbCdIncarceration = null;
    String dbCdChildren = null;
    String dbCdMarrAtBirth = null;
    String dbCdTanf = null;
    String dbCdFoodStamps = null;
    String dbCdHousingAst = null;
    
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT CD_OUTCOME_RPT_STAT, " +
                "DT_OUTCOME_DATE, " +
                "IND_FC_STATUS, " +
                "IND_CURR_FT_EMP, " +
                "IND_CURR_PT_EMP, " +
                "IND_EMP_SKILLS, " +
                "IND_SOCIAL_SEC, " +
                "IND_EDUC_AID, " +
                "IND_OTH_SUPPORT, " +
                "CD_HIGH_EDU, " +
                "IND_CURR_ATD_ENR, " +
                "IND_CONN_ADULT, " +
                "IND_MEDICAID, " +
                "CD_OTH_HLTH_INS_TYP, " +
                "CD_HLTH_INS_MEDICAL, " +
                "CD_HLTH_INS_MENTAL, " +
                "CD_HLTH_INS_RX, " +
                "IND_HOMELESS, " +
                "IND_SUB_ABUSE_REF, " +
                "IND_INCARCERATION, " +
                "IND_CHILDREN, " +
                "CD_MARR_AT_BIRTH, " +
                "CD_TANF, " +
                "CD_FOOD_STAMPS, " +
                "CD_HOUSING_AST, " +
                "CD_POPULATION_TYPE " +
                "FROM YOUTH_REPORT_DTL " +
                "WHERE ID_YOUTH_REPORT_DTL = ? ";
      
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, idYouthReportDtl);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        dbCdOutcomeRptStat = resultSet.getString("CD_OUTCOME_RPT_STAT");
        dbDtOutcomeDate = resultSet.getDate("DT_OUTCOME_DATE");
        dbIndFcStatOutcome = resultSet.getString("IND_FC_STATUS");
        dbCdCurrFtEmp = resultSet.getString("IND_CURR_FT_EMP");
        dbCdCurrPtEmp = resultSet.getString("IND_CURR_PT_EMP");
        dbCdEmpSkills = resultSet.getString("IND_EMP_SKILLS");
        dbCdSocialSec = resultSet.getString("IND_SOCIAL_SEC");
        dbCdEducAid = resultSet.getString("IND_EDUC_AID");
        dbCdOthSupport = resultSet.getString("IND_OTH_SUPPORT");
        dbCdHighEdu = resultSet.getString("CD_HIGH_EDU");
        dbCdCurrAtdEnr = resultSet.getString("IND_CURR_ATD_ENR");
        dbCdConnAdult = resultSet.getString("IND_CONN_ADULT");
        dbCdMedicaid = resultSet.getString("IND_MEDICAID");
        dbCdOthHlthInsType = resultSet.getString("CD_OTH_HLTH_INS_TYP");
        dbCdHlthInsMedical = resultSet.getString("CD_HLTH_INS_MEDICAL");
        dbCdHlthInsMental = resultSet.getString("CD_HLTH_INS_MENTAL");
        dbCdHlthInsRx = resultSet.getString("CD_HLTH_INS_RX");
        dbCdHomeless = resultSet.getString("IND_HOMELESS");
        dbCdSubAbuseRef = resultSet.getString("IND_SUB_ABUSE_REF");
        dbCdIncarceration = resultSet.getString("IND_INCARCERATION");
        dbCdChildren = resultSet.getString("IND_CHILDREN");
        dbCdMarrAtBirth = resultSet.getString("CD_MARR_AT_BIRTH");
        dbCdTanf = resultSet.getString("CD_TANF");
        dbCdFoodStamps = resultSet.getString("CD_FOOD_STAMPS");
        dbCdHousingAst = resultSet.getString("CD_HOUSING_AST");
      }
      
    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    boolean isValid = false;

    if (isResponseValid(dbCdCurrFtEmp) || isResponseValid(dbCdCurrPtEmp)
        || isResponseValid(dbCdConnAdult) || isResponseValid(dbCdCurrAtdEnr)
        || isResponseValid(dbCdEducAid) || isResponseValid(dbCdEmpSkills)
        || isResponseValid(dbCdHighEdu) || isResponseValid(dbCdHomeless)
        || isResponseValid(dbCdIncarceration) || isResponseValid(dbCdMedicaid)
        || isResponseValid(dbCdOthSupport) || isResponseValid(dbCdSocialSec)
        || isResponseValid(dbCdSubAbuseRef) || isResponseValid(dbCdChildren)
        || isResponseValid(dbCdMarrAtBirth) || isResponseValid(dbCdOthHlthInsType)
        || isResponseValid(dbCdHlthInsMedical) || isResponseValid(dbCdHlthInsMental)
        || isResponseValid(dbCdHlthInsRx)) {
      // at least one baseline question was answered
      isValid = true;
    }

    // if population is followup
    // check followup not in care questions
    if (FOLLOWUP.equals(dbCdPopulationType)
        && ArchitectureConstants.N.equals(StringHelper.getNonNullString(dbIndFcStatOutcome))) {
      if (isResponseValid(dbCdHousingAst) 
                      || isResponseValid(dbCdFoodStamps)
                      || isResponseValid(dbCdTanf)) {
        // at least one follow up not in care was answered
        isValid = true;
      }
    }
    performanceTrace.exitScope();
    return isValid;
  }

  // Determines if response is valid, meaning an answer was provided and is not a Declined response
  private static boolean isResponseValid(String resp) {
    if (StringHelper.isNotEmptyOrNull(resp) 
                    && !CodesTables.CINVACAN_D.equals(resp)
                    && !CodesTables.CINVACAN_A.equals(resp)
                    && !CodesTables.CHIGHEDU_DC.equals(resp)) {
      return true;
    }

    return false;
  }
  
  /**
   * Check if youth is In DFCS Care during the specified period as defined for NYTD
   * 
   * @param idPerson - Child SHINES id person
   * @param dtStart - Date range start to determine youth's In DFCS care status
   * @param dtEnd - Date range end to determine youth's In DFCS care status
   * @return boolean - true if child is In DFCS Care during specified period, false otherwise
   */
  public static boolean isInDFCSCare(int idPerson, Date dtStart, Date dtEnd){
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".isInDFCSCare");
    performanceTrace.enterScope();

    if( idPerson == 0 || DateHelper.isNull(dtStart) || DateHelper.isNull(dtEnd) ){
      return false;
    }
        
    java.sql.Date sqlDtPeriodStart = new java.sql.Date(dtStart.getTime());
    java.sql.Date sqlDtPeriodEnd = new java.sql.Date(dtEnd.getTime());
    java.sql.Date sqlDtJavaMax = new java.sql.Date(DateHelper.MAX_JAVA_DATE.getTime());
    
    int plcmtCount = 0;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "select count(*) "
        + "  from placement p, event ev, stage s, stage_person_link spl, legal_status_view lsv "
        + "   where p.cd_plcmt_type in ( 'RFH','DFH','CFH','IFH','ADH','CCI','EMS','GRH','HOS','NRP','OTA','OTP','OTR','REP','REU','RNA','SFH'  ) "
        + "   AND p.cd_plcmt_act_planned = 'A' "
        + "   AND (p.cd_temp_type is null OR p.cd_temp_type NOT IN ('RED','REN','COR')) "
        + "   AND p.id_plcmt_child = ? " // id person
        + "   AND (p.dt_plcmt_end is null "
        + "     OR p.dt_plcmt_end >= ?) " // start date
        + "   AND p.dt_plcmt_start <= ? " // end date
        + "   AND p.id_plcmt_event = ev.id_event"
        + "   AND ev.cd_event_status = 'APRV' "
        + "   AND ev.id_event_stage = s.id_stage "
        + "   AND s.cd_stage IN ('SUB', 'ADO') "
        + "   AND s.id_stage = spl.id_stage "
        + "   AND spl.id_person = p.id_plcmt_child "
        + "   AND spl.cd_stage_pers_role = 'PC' "
        + "   AND lsv.id_person = p.id_plcmt_child "
        + "   and lsv.in_dfcs_custody = 'Y' "
        + "   AND (lsv.dt_legal_stat_end is null "
        + "     OR lsv.dt_legal_stat_end >= ?) " // start date
        + "   AND lsv.dt_legal_stat_status_dt <= ? " // end date
        + "   AND lsv.dt_legal_stat_status_dt <= LEAST(NVL(p.dt_plcmt_end, ?), ?) " // java max date, end date
        + "   AND NVL(lsv.dt_legal_stat_end, :maxDate) >= GREATEST(p.dt_plcmt_start, ?) "; // java max date, start date 

      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, idPerson);
      preparedStatement.setDate(2, sqlDtPeriodStart);
      preparedStatement.setDate(3, sqlDtPeriodEnd);
      preparedStatement.setDate(4, sqlDtPeriodStart);
      preparedStatement.setDate(5, sqlDtPeriodEnd);
      preparedStatement.setDate(6, sqlDtJavaMax);
      preparedStatement.setDate(7, sqlDtPeriodEnd);
      preparedStatement.setDate(8, sqlDtJavaMax);
      preparedStatement.setDate(9, sqlDtPeriodStart);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      
      while(resultSet.next()){
        plcmtCount = resultSet.getInt(1);
      }

    } catch (SQLException e) {
      performanceTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    
    performanceTrace.exitScope();
    return (plcmtCount > 0);
    
  }

  protected static void cleanup(Connection connection, Statement statement, ResultSet resultSet) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (Exception e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing result set.", e);
    }
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (Exception e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing statement.", e);
    }
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (Exception e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing connection.", e);
    }
  }
}