package gov.georgia.dhr.dfcs.sacwis.core.lookup;

// java classes

import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Date;

/**
 * ReferenceDataInit class provides static methods to the user for Reference tables lookup functionality.
 *
 * @author Prem Raghupathy, March 6, 2002.
 */
public class ReferenceDataLookup {
  private static ReferenceData referenceData;

  private static final String TRACE_TAG = "ReferenceDataLookup";

  public static void setReferenceData(ReferenceData referenceData) {
    ReferenceDataLookup.referenceData = referenceData;
  }

  /**
   * Returns an Object from the cache for the specified reference table, code, table column and date.
   *
   * @param referenceTableName - The reference table name
   * @param code               - The code
   * @param tableColumnName    - The table column name
   * @param date               - A C-IV date for which the value is returned
   * @return A value Object
   * @throws ReferenceDataLookupException  - when the referenceDatalookup fails
   * @throws TableNotFoundException        - if the reference table is not found
   * @throws CodeNotFoundException         - if the code is not found in the reference table
   * @throws DataNotFoundException         - if a matching record is not found in the reference table
   * @throws DuplicateRecordFoundException - if more than one records are found
   */
  public static Object get(String referenceTableName, String code, String tableColumnName, Date date)
          throws CodeNotFoundException, DataNotFoundException, DuplicateRecordFoundException, TableNotFoundException,
                 ReferenceDataLookupException {
    GrndsTrace.enterScope(TRACE_TAG + ".get(1,2,3,4)");
    if (referenceTableName == null || code == null || tableColumnName == null || date == null) {
      throw new ReferenceDataLookupException("One or more input parameters is/are null. Null values are not allowed.",
                                             BasePrsException.CRITICAL_PRIORITY);
    }
    if (ReferenceDataLookup.referenceData == null) {
      throw new ReferenceDataLookupException("Reference Tables Lookup Data was not initialized properly.",
                                             BasePrsException.CRITICAL_PRIORITY);
    }
    Object value = ReferenceDataLookup.referenceData.get(referenceTableName, code, tableColumnName, date);
    GrndsTrace.exitScope();
    return value;
  }

  /**
   * Returns an Object from the cache for the specified reference table, code and table column.
   *
   * @param referenceTableName - The reference table name
   * @param code               - The code
   * @param tableColumnName    - The table column name
   * @return A value Object
   * @throws ReferenceDataLookupException  - when the referenceDatalookup fails
   * @throws TableNotFoundException        - if the reference table is not found
   * @throws CodeNotFoundException         - if the code is not found in the reference table
   * @throws DataNotFoundException         - if a matching record is not found in the reference table
   * @throws DuplicateRecordFoundException - if more than one records are found
   */
  public static Object get(String referenceTableName, String code, String tableColumnName)
          throws CodeNotFoundException, DataNotFoundException, DuplicateRecordFoundException, TableNotFoundException,
                 ReferenceDataLookupException {
    GrndsTrace.enterScope(TRACE_TAG + ".get(1,2,3)");
    Date date = ReferenceDataLookup.getDate();
    GrndsTrace.exitScope();
    return ReferenceDataLookup.get(referenceTableName, code, tableColumnName, date);
  }

  /**
   * Returns a list of reference table objects fot the given reference table.
   *
   * @param referenceTableName - The reference table name
   * @param date               - Date
   * @return The list of HashMaps containing the records of the given reference table
   * @throws ReferenceDataLookupException - when the referenceDatalookup fails
   * @throws TableNotFoundException       - if the reference table is not found
   * @throws DataNotFoundException        - if a matching record is not found in the reference table
   */
  public static List getList(String referenceTableName, Date date)
          throws DataNotFoundException, TableNotFoundException, ReferenceDataLookupException {
    GrndsTrace.enterScope(TRACE_TAG + ".getList(1,2)");
    if (referenceTableName == null || date == null) {
      throw new ReferenceDataLookupException("One or more than one input is/are null. Null value is not allowed.",
                                             BasePrsException.CRITICAL_PRIORITY);
    }
    if (ReferenceDataLookup.referenceData == null) {
      throw new ReferenceDataLookupException(
              "Reference Tables Lookup Data was not initialized properly.  Check log for details.",
              BasePrsException.CRITICAL_PRIORITY);
    }
    List referenceTableObjects = ReferenceDataLookup.referenceData.getList(referenceTableName, date);
    GrndsTrace.exitScope();
    return referenceTableObjects;
  }

  /**
   * Returns a list of reference table objects fot the given reference table.
   *
   * @param referenceTableName - The reference table name
   * @return The list of HashMaps containing the records of the given reference table
   * @throws ReferenceDataLookupException - when the referenceDatalookup fails
   * @throws TableNotFoundException       - if the reference table is not found
   * @throws DataNotFoundException        - if a matching record is not found in the reference table
   */
  public static List getList(String referenceTableName)
          throws DataNotFoundException, TableNotFoundException, ReferenceDataLookupException {
    GrndsTrace.enterScope(TRACE_TAG + ".getList(1)");
    Date date = ReferenceDataLookup.getDate();
    List referenceTableObjects = ReferenceDataLookup.getList(referenceTableName, date);
    GrndsTrace.exitScope();
    return referenceTableObjects;
  }

  /**
   * Helper method to create and return a date object for the current month and year, but the day set to beginning of
   * the month.
   *
   * @return date
   */
  private static Date getDate() {
    Date date = new Date();
    date.setDayOfMonth(1);
    return date;
  }
}
