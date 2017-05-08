package gov.georgia.dhr.dfcs.sacwis.core.lookup.tabledefs;

// java classes

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.ResultSetHelper;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public abstract class TableDefinitionAdapter implements TableDefinition {

  public static final String TRACE_TAG = "TableDefinitionAdapter";

  private String tableId;
  private String sqlStatement;
  private String tableName;
  private String keyCode;
  private Map tableDefinitionMap;

  protected TableDefinitionAdapter(String tableId, String tableName, String sqlStatement, String keyCode,
                                   Map tableDefinitionMap) {
    setTableId(tableId);
    setTableName(tableName);
    setSqlStatement(sqlStatement);
    setKeyCode(keyCode);
    setTableDefinitionMap(tableDefinitionMap);
  }

  protected TableDefinitionAdapter(String tableId, String tableName, String sqlStatement, String keyCode,
                                   String tableDefinitionString) {
    setTableId(tableId);
    setTableName(tableName);
    setSqlStatement(sqlStatement);
    setKeyCode(keyCode);
    setTableDefinitionMap(tableDefinitionString);
  }

  public String getTableId() {
    return this.tableId;
  }

  /**
   * Returns the date before which the values in this row are no longer used. The base version returns a minimum date,
   * so that this data is always available to the system. This should be overwritten by subclasses if there is a minimum
   * value stored in the table.
   *
   * @return a minimum date, so that this date is always available to the system
   */
  public Date getBeginDate(ResultSet row) {
    return new Date(0); // 1 day after the minimum date in ms
  }

  /**
   * Returns the date after which the values in this row are no longer used. The base version returns a maximum date, so
   * that this data is always available to the system. This should be overwritten by subclasses if there is a minimum
   * value stored in the table.
   *
   * @return a maximum date, so that this date is always available to the system
   */
  public Date getEndDate(ResultSet row) {
    return new Date(Long.MAX_VALUE);
  }

  public String getCodeValue(ResultSet row) throws SQLException {
    return ResultSetHelper.getString(row, getKeyCode());
  }

  public String getKeyCode() {
    return this.keyCode;
  }

  public String getTableName() {
    return this.tableName;
  }

  public Map getTableDefinitionMap() {
    return this.tableDefinitionMap;
  }

  public String getSqlStatement() {
    return this.sqlStatement;
  }

  public PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
    return connection.prepareStatement(this.getSqlStatement());
  }

  public void setKeyCode(String keyCode) {
    this.keyCode = keyCode;
  }

  public void setSqlStatement(String sqlStatement) {
    this.sqlStatement = sqlStatement;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public void setTableDefinitionMap(Map defMap) {
    this.tableDefinitionMap = defMap;
  }

  public void setTableDefinitionMap(String defMapString) {
    this.tableDefinitionMap = TableDefinitionAdapter.getTableDefinition(defMapString);
  }

  /**
   * The reference table definition is stored in a String, which has the following pattern. &lt;reference table column
   * name&gt;:&lt;code for corresponding column name in code table&gt;:&lt;code for reference table column data
   * type&gt;;&lt;&gt;:&lt;&gt;:&lt;&gt;; ... This method parses this String and the tokens are stored in fieldNames and
   * fieldTypes maps.
   *
   * @param tableDefinitionString String
   * @throws NoSuchElementException - if the String does not have the pattern in the right way.
   */
  static Map getTableDefinition(String tableDefinitionString) throws NoSuchElementException {
    GrndsTrace.enterScope(TRACE_TAG + ".getTableDefinition()");
    StringTokenizer tokenizer = new StringTokenizer(tableDefinitionString, ";");
    Map<String, String> tableDefinitionMap = new HashMap<String, String>();
    while (tokenizer.hasMoreTokens()) {
      StringTokenizer subTokenizer = new StringTokenizer(tokenizer.nextToken(), ":");
      // actual reference table column name
      String actualColumnName = subTokenizer.nextToken().trim();
      // mapped column name in 'Code' table
      String genericColumnName = subTokenizer.nextToken().trim();
      // column's data type
      String columnDataType = subTokenizer.nextToken().trim();

      String columnDefinition = actualColumnName + ":" + columnDataType;
      tableDefinitionMap.put(genericColumnName, columnDefinition);
    }
    GrndsTrace.msg(TRACE_TAG + "..gettableDefinition() ", 7,
                   ":: " + "tableDefinitionMap.toString() =" + tableDefinitionMap.toString());
    GrndsTrace.exitScope();
    return tableDefinitionMap;
  }
}

