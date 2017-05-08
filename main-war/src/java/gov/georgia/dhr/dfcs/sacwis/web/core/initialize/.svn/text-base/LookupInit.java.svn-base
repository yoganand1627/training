package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeKey;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupData;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.management.timer.Timer;
import javax.servlet.ServletContext;

import org.grnds.facility.log.GrndsTrace;

/**
 * This file contains the LookupInit class which will execute when WebLogic starts. This class will access the database
 * and build the required objects for the Codes Table Lookup service.
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  ---------------------------------------------------------------------------------------------
 * 04/18/05   ACodrea   Sir NA - Setting the default fetch size in the statement. It is needed for Oracle 10g driver.
 * 02/15/07   AOdutayo  Added query to create mapping between general service codes and general service category; and
 *                      financial service codes and financial service categories.
 * 07/15/07   mchillman Reset the number of occurrences so that the refresh of the codes tables that place every day at
 *                      at midnight. Also added code to set maps to null to release references 
 * </pre>
 *
 * @author Daniel L. Boxwell, September 24, 2001
 */
public class LookupInit implements Initializable, Destroyable {
  // A stringpool
  private Map<String, String> stringPool = null;

  // Maps for current codes
  protected Map<String, SortedMap<CodeKey, CodeAttributes>> encodeData;
  protected Map<String, SortedMap<CodeKey, CodeAttributes>> decodeData;

  // Maps for expired codes
  protected Map<String, SortedMap<CodeKey, CodeAttributes>> expiredEncodeData;
  protected Map<String, SortedMap<CodeKey, CodeAttributes>> expiredDecodeData;

  //
  // Static Constants
  //
  private static final String TRACE_TAG = "LookupInit";
  private static final int NUMBER_CODE_TYPES = 500;

  /**
   * Startup method implementation required for implementing the T3StartupDef interface.
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException
   *          In the event that the startup method fails.
   */
  public void initialize(ServletContext servletContext) throws LookupException {
    GrndsTrace.enterScope(TRACE_TAG + ".startup");

    //Build hashmaps from DB and put in Lookup Class.
    buildData();

    // Add notification to TimerInit for LookupData refresh.
    LookupRefreshTask task = new LookupRefreshTask();

    Date date = new Date(System.currentTimeMillis());
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);

    // Pull hour and minute from constants
    cal.set(Calendar.HOUR_OF_DAY, LookupConstants.HOUR_OF_DAY);
    cal.set(Calendar.MINUTE, LookupConstants.MINUTE_OF_DAY);
    
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    date = cal.getTime();

    servletContext.log("LookupData set to refresh at: " + date.toString());
    GrndsTrace.msg(TRACE_TAG, 7, "LookupData set to refresh at: " + date.toString());

    //set the number of occurrences to zero to run once a day forever
    boolean added =
            TimerInit.addTimerNotificationNoDupType(TimerInit.LOOKUP_REFRESH_NOTIF_TYPE, "LookupData refresh called.",
                                                    null, date, Timer.ONE_DAY, 0);
    if (added) {
      TimerInit.addTimerListener(task, null, null);
      GrndsTrace.msg(TRACE_TAG, 7, "Added Timer Listener ");
    }
    GrndsTrace.exitScope();
  }

  protected void buildData() throws LookupException {
    GrndsTrace.enterScope(TRACE_TAG + ".buildData()");
    Lookup.setLookupData(buildLookupData());
    GrndsTrace.exitScope();
  }

  protected LookupData buildLookupData() throws LookupException {
    // Create Map's for current codes
    this.encodeData = new HashMap<String, SortedMap<CodeKey, CodeAttributes>>(NUMBER_CODE_TYPES);
    this.decodeData = new HashMap<String, SortedMap<CodeKey, CodeAttributes>>(NUMBER_CODE_TYPES);

    // Create Map's for expired codes
    this.expiredEncodeData = new HashMap<String, SortedMap<CodeKey, CodeAttributes>>(NUMBER_CODE_TYPES);
    this.expiredDecodeData = new HashMap<String, SortedMap<CodeKey, CodeAttributes>>(NUMBER_CODE_TYPES);

    // Create the string pool set
    stringPool = new HashMap<String, String>();

    try {
      buildCodeTrees();
      this.encodeData = makeUnmodifiableMap(encodeData);
      this.decodeData = makeUnmodifiableMap(decodeData);
      this.expiredEncodeData = makeUnmodifiableMap(expiredEncodeData);
      this.expiredDecodeData = makeUnmodifiableMap(expiredDecodeData);
    } catch (Exception e) {
      throw new LookupException("Failed to build code trees.", e, BasePrsException.CRITICAL_PRIORITY);
    }
    return new LookupData(encodeData, decodeData, expiredEncodeData, expiredDecodeData);
  }

  /**
   * This method takes a map and makes an unmodifiable version of it, first checking to see if either its keys or values
   * are maps or sortedmaps and calling itself on those.
   * <p/>
   * NOTE: Passing a self-referencing Map to this method will cause it to loop infinitely!
   *
   * @param map
   * @return An unmodifiable version of the map passed in.
   */
  @SuppressWarnings({"unchecked"})
  protected <K extends Object, V extends Object> Map<K, V> makeUnmodifiableMap(Map<K, V> map) {
    Map<K, V> newMap = new HashMap<K, V>();
    for (Iterator<K> iterator = map.keySet().iterator(); iterator.hasNext();) {
      Object key = iterator.next();
      if (key instanceof SortedMap) {
        key = makeUnmodifiableSortedMap((SortedMap) key);
      } else if (key instanceof Map) {
        key = makeUnmodifiableMap((Map) key);
      }
      //noinspection SuspiciousMethodCalls
      Object value = map.get(key);
      if (value instanceof SortedMap) {
        value = makeUnmodifiableSortedMap((SortedMap) value);
      } else if (value instanceof Map) {
        value = makeUnmodifiableMap((Map) value);
      }
      newMap.put((K) key, (V) value);
    }
    return Collections.unmodifiableMap(newMap);
  }

  /**
   * This method takes a sortemap and makes an unmodifiable version of it, first checking to see if either its keys or
   * values are maps or sortedmaps and calling itself on those.
   * <p/>
   * NOTE: Passing a self-referencing SorteMap to this method will cause it to loop infinitely!
   *
   * @param sortedMap
   * @return An unmodifiable version of the amp passed in.
   */
  @SuppressWarnings({"unchecked"})
  protected <K extends Object, V extends Object> SortedMap<K, V> makeUnmodifiableSortedMap(SortedMap<K, V> sortedMap) {
    SortedMap<K, V> newSortedMap = new TreeMap<K, V>();
    for (Iterator iterator = sortedMap.keySet().iterator(); iterator.hasNext();) {
      Object key = iterator.next();
      if (key instanceof SortedMap) {
        key = makeUnmodifiableSortedMap((SortedMap) key);
      } else if (key instanceof Map) {
        key = makeUnmodifiableMap((Map) key);
      }
      //noinspection SuspiciousMethodCalls
      Object value = sortedMap.get(key);
      if (value instanceof SortedMap) {
        value = makeUnmodifiableSortedMap((SortedMap) value);
      } else if (value instanceof Map) {
        value = makeUnmodifiableMap((Map) value);
      }
      newSortedMap.put((K) key, (V) value);
    }
    return Collections.unmodifiableSortedMap(newSortedMap);
  }

  /**
   * Queries the database and populates the Encode and Decode Trees.
   *
   * @throws LookupException In the event that the startup method fails.
   */
  void buildCodeTrees() throws LookupException {
    GrndsTrace.enterScope(TRACE_TAG + ".buildCodeTrees");

    Connection connection = null;
    PreparedStatement dateStatement = null;
    PreparedStatement statement = null;
    ResultSet dateResults = null;
    ResultSet results = null;
    try {
      GrndsTrace.msg(TRACE_TAG, 7, "Getting Connection");
      connection = JdbcHelper.getConnection();
      GrndsTrace.msg(TRACE_TAG, 7, "Got Connection");

      String dateSql = "SELECT " + SqlConstants.SYSDATE + " FROM DUAL";
      dateStatement = connection.prepareStatement(dateSql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      dateResults = dateStatement.executeQuery();
      if (!dateResults.next()) {
        //noinspection ThrowCaughtLocally
        throw new SQLException("SYSDATE not found.");
      }
      Date sysDate = dateResults.getDate(1);

      //  This SQL gets all codes, expired and valid.
      //  The first UNION clause builds extra "County - Region" code types.
      //  the second UNION clause builds extra "Service - Category" code types.
      String sql = "      SELECT CODE_TYPE, CODE, DECODE, DT_END " +
                   "        FROM CODES_TABLES " +
                   "UNION SELECT CT1.CODE_TYPE || CT2.DECODE CODE_TYPE, CT1.CODE, CT1.DECODE, CT1.DT_END " +
                   "        FROM CODES_TABLES CT1, CODES_TABLES CT2 " +
                   "       WHERE CT1.CODE_TYPE = 'CCOUNT' " +
                   "         AND CT2.CODE_TYPE = 'CCNTYREG' " +
                   "         AND CT1.CODE = CT2.CODE " +
                   "UNION SELECT CT1.CODE_TYPE || CT2.DECODE CODE_TYPE, CT1.CODE, CT1.DECODE, CT1.DT_END " +
                   "        FROM CODES_TABLES CT1, CODES_TABLES CT2 " +
                   "       WHERE CT1.CODE_TYPE = 'CSVCCODE' " +
                   "         AND CT2.CODE_TYPE = 'CFLSVLNK' " +
                   "         AND CT1.CODE = CT2.CODE " +
                   "UNION SELECT CT1.CODE_TYPE || CT2.DECODE CODE_TYPE, CT1.CODE, CT1.DECODE, CT1.DT_END " +
                   "        FROM CODES_TABLES CT1, CODES_TABLES CT2 " +
                   "       WHERE CT1.CODE_TYPE = 'CGLSVCCD' " +
                   "         AND CT2.CODE_TYPE = 'CGLSVLNK' " +
                   "         AND CT1.CODE = CT2.CODE " +
                   "UNION SELECT 'COFFLOC' CODE_TYPE, DECODE( LENGTH( TO_CHAR( O.ID_OFFICE ) ), " +
                   "             '1', '00'||TO_CHAR( O.ID_OFFICE ), '2', '0' ||TO_CHAR( O.ID_OFFICE )," +
                   "             TO_CHAR( O.ID_OFFICE )  ) CODE , O.NM_OFFICE_NAME DECODE, NULL DT_END" +
                   "       FROM OFFICE O " +
                   "    ORDER BY CODE_TYPE";
      statement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      //ASC 04/18/2005 - for Oracle 10g driver.
      statement.setFetchSize(2000);
      results = statement.executeQuery();
      GrndsTrace.msg(TRACE_TAG, 7, "Got ResultSet all");

      // Set te prefetch because we expect a lot of data
      results.setFetchSize(2000);

      while (results.next()) {
        String codeType = produceString(results.getString("CODE_TYPE"));
        String code = produceString(results.getString("CODE"));
        String decode = produceString(results.getString("DECODE"));
        Date dtEnd = results.getDate("DT_END");
        boolean expired = dtEnd != null && (sysDate.compareTo(dtEnd) >= 0);
        CodeAttributes codeAttributes = new CodeAttributes(codeType, code, decode);
        CodeKey codeKey = new CodeKey(code, null);
        // add the code to the appropriate hashmap, depending on whether it's expired or not
        addCode(expired ? expiredEncodeData : encodeData, codeType, codeKey, codeAttributes);
        CodeKey decodeKey = new CodeKey(decode, null);
        // add the decode to the appropriate hashmap, depending on whether it's expired or not
        addCode(expired ? expiredDecodeData : decodeData, codeType, decodeKey, codeAttributes);
      }

    } catch (SQLException sqle) {
      GrndsTrace.exitScope();
      throw new LookupException("Failed to build Codes Table Lookup Tree. ",
                                sqle, BasePrsException.CRITICAL_PRIORITY);
    } catch (Exception e) {
      GrndsTrace.exitScope();
      throw new LookupException("Failed to connect to database in Codes Table Lookup Startup",
                                e, BasePrsException.CRITICAL_PRIORITY);
    } finally {
      try {
        if (dateResults != null) {
          dateResults.close();
        }
        if (dateStatement != null) {
          dateStatement.close();
        }
        if (results != null) {
          results.close();
        }
        if (statement != null) {
          statement.close();
        }
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
        GrndsTrace.exitScope();
      } catch (SQLException sqle) {
        GrndsTrace.exitScope();
        //noinspection ThrowFromFinallyBlock
        throw new LookupException("Failed to close all connections. ", sqle, BasePrsException.CRITICAL_PRIORITY);
      }
    }
  }

  /**
   * Helper method for buildCodeTrees that does the insertion into the maps, always checking to ensure that the code
   * type always exists.
   *
   * @param codeTypeMap    The Map of code type to SortedMap used to insert the code
   * @param codeType       The type of the code to be inserted
   * @param codeKey        The CodeKey object to be inserted
   * @param codeAttributes The CodeAttributes object to be inserted
   */
  private static void addCode(Map<String, SortedMap<CodeKey, CodeAttributes>> codeTypeMap, String codeType,
                              CodeKey codeKey, CodeAttributes codeAttributes) {
    SortedMap<CodeKey, CodeAttributes> codeMap = codeTypeMap.get(codeType);
    if (codeMap == null) {
      codeMap = new TreeMap<CodeKey, CodeAttributes>();
      codeTypeMap.put(codeType, codeMap);
    }
    codeMap.put(codeKey, codeAttributes);
  }

  /**
   * This is a very primitive string factory method used to prevent storage of huge numbers of the same String objects.
   *
   * @param in The String object to be run through the factory method
   * @return The unique String object
   */
  private String produceString(String in) {
    String out = stringPool.get(in);
    if (out == null) {
      out = in;
      stringPool.put(out, out);
    }
    return out;
  }

  /** Helper method to update the internal lookup data. Called at initialization and during refresh. */
  public static void updateLookupData() {
    try {
      //set maps to null the lookup object to release the references 
      Lookup.setMapsToNull();
      Lookup.setLookupData(null);
      //refresh the maps and set them to the lookup object
      LookupInit lookupInit = new LookupInit();
      lookupInit.buildData();
      //release the references
      lookupInit.setMapsToNull();
      GrndsTrace.msg("Lookup", 7, "Lookup Data last updated on:" + LookupData.getLastUpdate());
    } catch (LookupException le) {
      String message = "Caught a lookup exception updating LookupData object.";
      GrndsTrace.msg("Lookup", 7, message);
      //noinspection ProhibitedExceptionThrown
      throw new RuntimeException(message, le);
    }
  }
  
  /**
   * Helper method to release the maps after the update
   */
  @SuppressWarnings({"AssignmentToNull"})
  public void setMapsToNull() {
    stringPool = null;
    encodeData = null;
    decodeData = null;
    expiredEncodeData = null;
    expiredDecodeData = null;
  }

  @SuppressWarnings({"AssignmentToNull"})
  public void destroy(ServletContext config) throws BasePrsException {
    stringPool = null;
    encodeData = null;
    decodeData = null;
    expiredEncodeData = null;
    expiredDecodeData = null;
    Lookup.setLookupData(null);
  }
}
