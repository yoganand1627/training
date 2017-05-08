package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringTokenizer;

import javax.management.timer.Timer;
import javax.servlet.ServletContext;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.ResultSetHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceData;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.ReferenceDataLookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.tabledefs.MessageByNameTableDefinition;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.tabledefs.MessageByNumberTableDefinition;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.tabledefs.ReportsTableDefinition;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.tabledefs.TableDefinition;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;

/**
 * The reference tables are defined in 'Category' table. Their data is stored in 'Code' table in the form of Strings.
 * This class identifies all the reference tables defined in the Category table. Then retrieves the data for each
 * reference table from Code table, converts it into respective data types as defined in Category table and stores them
 * in a '4 Layered HashMap'. This HashMap is encapsulated in ReferenceData object. Finally it stores this object in
 * WebLogic's JNDI tree. This class is executed when WebLogic starts.
 * <p/>
 * The 4 layers of the HashMap are as follows in the form ||Map|| - ||key||:||value|| <ol> <li>Table</li> <li>Tables by
 * Name - Table Name : HashMap Dates by Code <li>HashMap of Dates By Code - Code : HashMap of Rows by Date <li>HashMap
 * of Rows by Date - Date : Hashmap of Rows <li>HashMap of Rows - Column Name : Column Value </ol>
 *
 * @author Prem Raghupathy, Febraury 28, 2002
 */
/*
 * Change History:
*  Date      User      Description
*  --------  --------  --------------------------------------------------
* 04/18/05   ACodrea   Sir NA - Setting the default fetch size in the
*                      statement. It is needed for Oracle 10g driver.
* <pre>
*/

public class ReferenceDataInitializer implements Initializable, Destroyable {

  private static final String TRACE_TAG = "ReferenceDataInitializer";

  private static final char INTEGER_TYPE = 'I';
  private static final char FLOAT_TYPE = 'F';
  private static final char DOUBLE_TYPE = 'O';
  private static final char BOOLEAN_TYPE = 'B';
  private static final char STRING_TYPE = 'S';
  private static final char DATE_TYPE = 'D';

  public void initialize(ServletContext servletContext) throws BasePrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".initialize");
    try {
      buildReferenceData();
    } catch (Exception e) {
      throw new ReferenceDataException("Failed to populate reference data.", e, BasePrsException.CRITICAL_PRIORITY);
    }

    // Add notification to TimerInit for ReferenceDataRefresh.
    ReferenceDataRefreshTask task = new ReferenceDataRefreshTask();

    Date date = new Date(System.currentTimeMillis());
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);

    // Pull hour and minute from constants
    cal.set(Calendar.HOUR_OF_DAY, LookupConstants.HOUR_OF_DAY);
    cal.set(Calendar.MINUTE, LookupConstants.MINUTE_OF_DAY);

    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    date = cal.getTime();

    boolean added = TimerInit.addTimerNotificationNoDupType(TimerInit.REFERENCE_REFRESH_NOTIF_TYPE,
                                                            "ReferenceData refresh called.", null, date,
                                                            Timer.ONE_DAY, 0l);
    if (added) {
      TimerInit.addTimerListener(task, null, null);
    }
    GrndsTrace.exitScope();
  }

  public void update() throws BasePrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".reinitialize");
    try {
      buildReferenceData();
      //GrndsTrace.msg(TRACE_TAG, 7, "JNDI_NAME=" + JNDI_NAME + " MAP=" + this.layer1Map);
      // Upload the object to the JNDI Tree
      //Object is bound in buildReferenceData() method.
      //      JndiHelper.bind(JNDI_NAME, new ReferenceData(this.layer1Map));
      GrndsTrace.msg(TRACE_TAG, 7, "RefenceData: Rebound Reference Data object to the JNDI tree.");
    } catch (Exception e) {
      throw new ReferenceDataException("Failed to bind reference data to JNDI Tree in Codes Table Lookup Startup",
                                       e, BasePrsException.CRITICAL_PRIORITY);
    }
    GrndsTrace.exitScope();
  }

  /**
   * This is a high level method that is responsible building the reference data structure and registering with
   * Weblogic's JNDI.
   *
   * @throws ReferenceDataInitializerException
   *          - if the startup method fails.
   */
  void buildReferenceData() throws ReferenceDataInitializerException {
    GrndsTrace.enterScope(TRACE_TAG + ".buildReferenceData()");
    GrndsTrace.msg(TRACE_TAG, 7, "Getting Connection");
    Connection connection = null;
    GrndsTrace.msg(TRACE_TAG, 7, "Got Connection");
    GrndsTrace.msg(TRACE_TAG + ".buildReferenceData() ", 7, " ::After getting Connection");
    try {
      connection = JdbcHelper.getConnection();
      Map<String, Map<String, Map<Date, Map<String, Object>>>> layer1Map =
              getLayer1Map(getTableDefinitionList(), connection);
      //GrndsTrace.msg( TRACE_TAG + ".initialize() ",7,":: this.layer1Map" +
      //                ".toString ==" + this.layer1Map.toString() );
      // Register the object with the JNDI Tree
      ReferenceDataLookup.setReferenceData(new ReferenceData(layer1Map));
      GrndsTrace.msg(TRACE_TAG + ".initialize() ", 7, "::Bound Reference data object to the JNDI tree.");
    } catch (SQLException sqlEx) {
      throw new ReferenceDataInitializerException("Failed to build Reference data Tables hash map. ",
                                                  sqlEx, BasePrsException.CRITICAL_PRIORITY);
    } finally {
      this.cleanup(connection);
    }
    GrndsTrace.exitScope();
  }

  /**
   * Returns a layer 1 HashMap.
   *
   * @param tablesDefinitionCollection - a collection containing all reference table definitions
   * @return layer 1 Map
   * @throws SQLException
   */
  Map<String, Map<String, Map<Date, Map<String, Object>>>> getLayer1Map(
          Collection<TableDefinition> tablesDefinitionCollection, Connection connection)
          throws SQLException {
    TableDefinition tableDef;
    Map<String, Map<String, Map<Date, Map<String, Object>>>> layer1Map =
            new HashMap<String, Map<String, Map<Date, Map<String, Object>>>>();
    GrndsTrace.enterScope(TRACE_TAG + ".getLayer1Map() ");
    //iterate through table definitions
    for (Iterator<TableDefinition> i = tablesDefinitionCollection.iterator(); i.hasNext();) {
      tableDef = i.next();
      try {
        // get layer 2 map for a given table Id
        Map<String, Map<Date, Map<String, Object>>> layer2Map = this.getLayer2Map(tableDef, connection);
        //GrndsTrace.msg( TRACE_TAG + "..getLayer1Map() ",7,":: " +
        //     "layer2Map.toString() = " +layer2Map.toString() );
        // add layer 2 map to layer 1 map
        layer1Map.put(tableDef.getTableId(), layer2Map);
      } catch (NoSuchElementException nseEx) {
        ReferenceDataInitializerException rdiEx =
                new ReferenceDataInitializerException(
                        tableDef.getTableId() + " table definition is not defined properly.",
                        BasePrsException.CRITICAL_PRIORITY);
        ExceptionHandler.handle(rdiEx);
        continue;
      }
    }
    GrndsTrace.exitScope();
    return layer1Map;
  }

  /**
   * Returns a layer 2 HashMap.
   *
   * @param tableDef - The map containing reference table definition
   * @return layer 2 Map
   * @throws SQLException
   */
  Map<String, Map<Date, Map<String, Object>>> getLayer2Map(TableDefinition tableDef, Connection connection)
          throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".buildLayer2Map()");
    // get all records for the given reference table
    ResultSet tableData = null;
    Map<String, Map<Date, Map<String, Object>>> layer2Map  = null;
    try {
    tableData = getTableData(tableDef, connection);
    // set the resultset prefetch size, as we will get a large amount of data
    tableData.setFetchSize(2000);

    layer2Map = new HashMap<String, Map<Date, Map<String, Object>>>();
    Map<Date, Map<String, Object>> layer3Map = new HashMap<Date, Map<String, Object>>();
    String layer2Key = null;
    String previousLayer2Key = null;
    while (tableData.next()) {
      Map<String, Object> layer4Map = getLayer4Map(tableData, tableDef);
      //GrndsTrace.msg( TRACE_TAG + "..getLayer2Map() ",7,":: " +
      //                "layer4Map.toString() = " +layer4Map.toString() );
      layer2Key = (String) layer4Map.get(ReferenceData.CODE);
      Date layer3Key = (Date) layer4Map.get(ReferenceData.BEGIN_DATE);
      if (previousLayer2Key != null && !previousLayer2Key.equals(layer2Key)) {
        // add layer3 map to layer2 map
        layer2Map.put(previousLayer2Key, layer3Map);
        //GrndsTrace.msg( TRACE_TAG + "..getLeve2Map() ",7,":: " +
        //                "layer3Map.toString() = " +layer3Map.toString() );
        layer3Map = new HashMap<Date, Map<String, Object>>();
      }
      // add layer4 map to layer3 map
      layer3Map.put(layer3Key, layer4Map);
      previousLayer2Key = layer2Key;
    }
    // if layer2Key is not null, then there is one more layer3 map
    if (layer2Key != null) {
      layer2Map.put(previousLayer2Key, layer3Map);
    }
    } finally {
      if (tableData != null) {
        PreparedStatement myStatement = null;
        try {
          myStatement = (PreparedStatement)tableData.getStatement();
        } catch (Exception e) {}
        try {   // close the result set
          tableData.close();
        } catch (Exception e) {}
        try {
          SqlHelper.cleanup(myStatement);  //close the statement
        } catch (Exception e) {}
      }
    }
    GrndsTrace.exitScope();
    return layer2Map;
  }

  /**
   * Queries the database and returns all the records of a reference table.
   *
   * @param tableDef - The table definition
   * @return resultSet
   * @throws SQLException
   */
  ResultSet getTableData(TableDefinition tableDef, Connection connection) throws SQLException {
    GrndsTrace.enterScope(TRACE_TAG + ".getTableData()");
    PreparedStatement statement = tableDef.getPreparedStatement(connection);
    //GrndsTrace.msg( TRACE_TAG , 7,  "tableId: " + tableDef.getTableId() );
    //GrndsTrace.msg( TRACE_TAG , 7,  "statement: " + statement);
    //ASC 04/18/2005 - for Oracle 10g driver.
    statement.setFetchSize(2000);
    ResultSet tableDataResultSet = statement.executeQuery();
    //GrndsTrace.msg( TRACE_TAG , 7,  "tableDataResultSet: " + tableDataResultSet);
    GrndsTrace.exitScope();
    return tableDataResultSet;
  }

  /**
   * Returns a layer 4 HashMap.
   *
   * @param tableData - The ResultSet
   * @param tableDef  - The table definition
   * @return layer4 Map
   * @throws SQLException
   */
  Map<String, Object> getLayer4Map(ResultSet tableData, TableDefinition tableDef) throws SQLException {
    //GrndsTrace.enterScope( TRACE_TAG + ".getL4map()" );
    Map<String, Object> layer4Map = new HashMap<String, Object>();
    try {
      layer4Map.put(ReferenceData.CODE, tableDef.getCodeValue(tableData));
      layer4Map.put(ReferenceData.BEGIN_DATE, tableDef.getBeginDate(tableData));
      layer4Map.put(ReferenceData.END_DATE, tableDef.getEndDate(tableData));
      Map tableDefinitionMap = tableDef.getTableDefinitionMap();
      Set columnNameSet = tableDefinitionMap.keySet();
      Iterator iterator = columnNameSet.iterator();
      //iterate through the table deinition map to retrieve the column names,
      // their data types and values
      while (iterator.hasNext()) {
        String genericColumnName = (String) iterator.next();
        //contains column name and its data type
        String columnDefinition = (String) tableDefinitionMap.get(genericColumnName);
        //map contains column name and its data type as key- value
        Map columnNameAndTypeMap = this.getColumnNameAndValueMap(columnDefinition);
        String columnValue = ResultSetHelper.getString(tableData, genericColumnName);
        String actualColumnName = (String) columnNameAndTypeMap.get(TableDefinition.COLUMN_NAME);
        String columnDataType = (String) columnNameAndTypeMap.get(TableDefinition.COLUMN_DATA_TYPE);
        //GrndsTrace.msg( TRACE_TAG + "..getL4Map() ",7,":: " +
        //                " genericColumnName =" +genericColumnName+
        //                " actualColumnName =" +actualColumnName+
        //                " columnValue =" +columnValue+
        //                " columnDataType =" +columnDataType );
        layer4Map = this.addToLayer4Map(actualColumnName, columnValue, columnDataType, layer4Map);
      }
      //GrndsTrace.exitScope();
    } catch (Exception e) {
      StackTraceElement[] stackTrace = e.getStackTrace();
      StringBuffer sb = new StringBuffer();
      sb.append(e.getMessage()).append(ArchitectureConstants.LINE_BREAK);
      for (int i = 0; i < stackTrace.length; i++) {
        StackTraceElement stackTraceElement = stackTrace[i];
        sb.append(stackTraceElement.toString()).append(ArchitectureConstants.LINE_BREAK);
      }
      GrndsTrace.msg(TRACE_TAG, 7, sb.toString());
    }
    return layer4Map;
  }

  /**
   * A helper method that convert a string containing column name and its data type to map
   *
   * @param columnDefinitionString
   * @return columnDefinitionMap
   */
  Map<String, String> getColumnNameAndValueMap(String columnDefinitionString) {
    //GrndsTrace.enterScope( TRACE_TAG + ".getColumnNameAndValueMap()" );
    StringTokenizer tokenizer = new StringTokenizer(columnDefinitionString, ":");
    Map<String, String> columnDefinitionMap = new HashMap<String, String>();
    String columnName = tokenizer.nextToken();
    String columnDataType = tokenizer.nextToken();
    columnDefinitionMap.put(TableDefinition.COLUMN_NAME, columnName);
    columnDefinitionMap.put(TableDefinition.COLUMN_DATA_TYPE, columnDataType);
    //GrndsTrace.exitScope();
    return columnDefinitionMap;
  }

  /**
   * Adds a key - value to layer4 map
   *
   * @param actualColumnName
   * @param columnValue
   * @param columnDataType
   * @return layer4 Map
   */
  Map<String, Object> addToLayer4Map(String actualColumnName, String columnValue, String columnDataType,
                                     Map<String, Object> layer4Map) {
    //GrndsTrace.enterScope( TRACE_TAG + ".addToLayer4Map()" );
    if (columnValue == null) {
      layer4Map.put(actualColumnName, columnValue);
    } else {
      try {
        //convert the column value to java object
        Object columnValueObject = this.stringToObject(columnValue, columnDataType);
        layer4Map.put(actualColumnName, columnValueObject);
      } catch (ReferenceDataInitializerException rdiEx) {
        ExceptionHandler.handle(rdiEx);
      }
    }
    //GrndsTrace.exitScope();
    return layer4Map;
  }

  /**
   * Converts a ResultSet column value, except dates, from String to the respective data type and store the column name
   * and value in the atomicMap.
   *
   * @param columnValue          - the reference table column value
   * @param columnDataTypeString - char that denote the data type of the column value
   * @throws ReferenceDataInitializerException
   *          - if there is a error converting a String to respective data type
   */
  Object stringToObject(String columnValue, String columnDataTypeString) throws ReferenceDataInitializerException {
    //GrndsTrace.enterScope( TRACE_TAG + ".stringToObject()" );
    char columnDataType = stringToChar(columnDataTypeString);
    Object columnValueObject = null;
    switch (columnDataType) {
      case ReferenceDataInitializer.INTEGER_TYPE:
        try {
          columnValueObject = new Integer(columnValue);
        } catch (NumberFormatException nfEx) {
          throw new ReferenceDataInitializerException(
                  "Error converting a String object to Integer in resultsetRecordToHashMap() in ReferenceDataLookup.",
                  nfEx, BasePrsException.WARNING_PRIORITY);
        }
        break;

      case ReferenceDataInitializer.FLOAT_TYPE:
        try {
          columnValueObject = new Float(columnValue);
        } catch (NumberFormatException nfEx) {
          throw new ReferenceDataInitializerException(
                  "Error converting a String object to Float in resultsetRecordToHashMap() in ReferenceDataLookup.",
                  nfEx, BasePrsException.WARNING_PRIORITY);
        }
        break;

      case ReferenceDataInitializer.DOUBLE_TYPE:
        try {
          columnValueObject = new Double(columnValue);
        } catch (NumberFormatException nfEx) {
          throw new ReferenceDataInitializerException(
                  "Error converting a String object to Double in resultsetRecordToHashMap() in ReferenceDataLookup.",
                  nfEx, BasePrsException.WARNING_PRIORITY);
        }
        break;

      case ReferenceDataInitializer.BOOLEAN_TYPE:
        columnValueObject = new Boolean(columnValue);
        break;

      case ReferenceDataInitializer.STRING_TYPE:
        columnValueObject = columnValue;
        break;

      case ReferenceDataInitializer.DATE_TYPE:
        columnValueObject = columnValue;
        break;

    }
    //GrndsTrace.exitScope();
    return columnValueObject;
  }

  protected List<TableDefinition> getTableDefinitionList() {
    GrndsTrace.enterScope(TRACE_TAG + ".getTableDefinitionList()");
    List<TableDefinition> tableDefList = new ArrayList<TableDefinition>();
    tableDefList.add(new MessageByNumberTableDefinition());
    tableDefList.add(new MessageByNameTableDefinition());
    tableDefList.add(new ReportsTableDefinition());
    GrndsTrace.exitScope();
    return tableDefList;
  }

  /**
   * A helper method that convert a string to a char
   *
   * @param columnDataType - A String
   * @return columnDataTypeCode
   */
  char stringToChar(String columnDataType) {
    return columnDataType.toUpperCase().charAt(0);
  }

  /** The connection cleanup method */
  void cleanup(Connection connection) {
    GrndsTrace.enterScope(TRACE_TAG + ".cleanup() ");
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
      GrndsTrace.msg(TRACE_TAG + ".cleanup() ", 7, " ::Connection closed.");
    } catch (SQLException sEx) {
      ExceptionHandler.handle(sEx);
    }
    GrndsTrace.exitScope();
  }

  public void destroy(ServletContext config) throws BasePrsException {
    ReferenceDataLookup.setReferenceData(null);
  }
}
