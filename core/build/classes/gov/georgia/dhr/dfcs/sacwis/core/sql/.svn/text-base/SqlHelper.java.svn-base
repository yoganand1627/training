/**
 * Created on Apr 11, 2005 at 10:10:33 AM
 *
 * Created by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.sql;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;

public class SqlHelper {
  private static final GrndsLogger GLOBAL_EXCEPTION_LOGGER =
          GrndsLogger.getLogger(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                             "exception.globalLogger"));

  /**
   * Do not use this method; it can't properly deal with Oracle date fields; all time information is truncated.
   * 
   * @param preparedStatement
   * @param fromIdColumnName
   * @param toIdColumnName
   * @return
   * @throws SQLException
   */
  @SuppressWarnings({"deprecation"})
  @Deprecated
  public static Map<Long, Long> createIdMapFromQuery(PreparedStatement preparedStatement, String fromIdColumnName,
                                                     String toIdColumnName) throws SQLException {
    Map<Long, Long> idMap = new HashMap<Long, Long>();
    List<Map<String, Object>> list = createListFromQuery(preparedStatement);
    Iterator<Map<String, Object>> iterator = list.iterator();
    while (iterator.hasNext()) {
      Map<String, Object> map = iterator.next();
      long fromId = getLong(map, fromIdColumnName);
      long toId = getLong(map, toIdColumnName);
      idMap.put(fromId, toId);
    }
    return idMap;
  }

  /**
   * Do not use this method; it can't properly deal with Oracle date fields; all time information is truncated.
   *
   * @param preparedStatement
   * @return
   * @throws SQLException
   */
  @Deprecated
  public static List<Map<String, Object>> createListFromQuery(PreparedStatement preparedStatement) throws SQLException {
    ResultSet resultSet = null;
    try {
      List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
      resultSet = preparedStatement.executeQuery();

      ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
      int columnCount = resultSetMetaData.getColumnCount();
      String[] columnNames = new String[columnCount];
      for (int i = 0; i < columnCount; i++) {
        columnNames[i] = resultSetMetaData.getColumnName(i + 1);
      }
      while (resultSet.next()) {
        Map<String, Object> row = new HashMap<String, Object>();
        for (int i = 0; i < columnCount; i++) {
          // This is a terrible hack, but it does fix a general problem with optimistic locking:
          //   Oracle maps the "date" type to dates, instead of timestamps, through JDBC,
          //   even though dates can store time information; this breaks the optimistic
          //   locking, in particular, so use getTimestamp() to manually get around it.
          if (resultSetMetaData.getColumnType(i + 1) == Types.DATE && "DT_LAST_UPDATE".equals(columnNames[i])) {
            row.put(columnNames[i], resultSet.getTimestamp(i + 1));
          } else {
            row.put(columnNames[i], resultSet.getObject(i + 1));
          }
        }
        list.add(row);
      }
      return list;
    }
    finally {
      if (resultSet != null) {
        resultSet.close();
      }
    }
  }

  public static long[] selectLongArray(PreparedStatement preparedStatement) throws SQLException {
    ResultSet resultSet = null;
    try {
      resultSet = preparedStatement.executeQuery();
      List<Long> list = new ArrayList<Long>();
      while (resultSet.next()) {
        list.add(resultSet.getLong(1));
      }
      long[] array = new long[list.size()];
      for (int i = 0; i < array.length; i++) {
        array[i] = list.get(i);
      }
      return array;
    }
    finally {
      if (resultSet != null) {
        resultSet.close();
      }
    }
  }

  public static long selectLong(PreparedStatement preparedStatement) throws SQLException {
    Number number = (Number) selectObject(preparedStatement);
    if (number == null) {
      return 0L;
    }
    return number.longValue();
  }

  public static double selectDouble(PreparedStatement preparedStatement) throws SQLException {
    Number number = (Number) selectObject(preparedStatement);
    if (number == null) {
      return 0.0;
    }
    return number.doubleValue();
  }

  public static String selectString(PreparedStatement preparedStatement) throws SQLException {
    return (String) selectObject(preparedStatement);
  }

  /**
   * This is private because it does not work with dates!  Oracle dates can include time information, but the {@link
   * java.sql.Date} type truncates time information.
   *
   * @param preparedStatement
   * @return
   * @throws SQLException
   */
  private static Object selectObject(PreparedStatement preparedStatement) throws SQLException {
    ResultSet resultSet = null;
    try {
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        Object object = resultSet.getObject(1);
        if (resultSet.wasNull()) {
          return null;
        }
        return object;
      }
      return null;
    }
    finally {
      if (resultSet != null) {
        resultSet.close();
      }
    }
  }

  public static long getLong(Map map, Object key) {
    Number value = (Number) map.get(key);
    if (value == null) {
      return 0l;
    }
    return value.longValue();
  }

  public static String toSetString(Collection<? extends Object> collection) {
    return toSetString(collection.size());
  }

  public static String toSetString(long[] array) {
    return toSetString(array.length);
  }

  public static String toSetString(int count) {
    String output = "";
    for (int i = 0; i < count; i++) {
      if (i == 0) {
        output += "?";
      } else {
        output += ", ?";
      }
    }
    return output;
  }

  /** adds collection of non-null objects * */
  public static int setCollection(PreparedStatement preparedStatement, int index,
                                  Collection<? extends Object> collection)
          throws SQLException {
    Iterator iterator = collection.iterator();
    while (iterator.hasNext()) {
      Object object = iterator.next();
      preparedStatement.setObject(index++, object);
    }
    return index;
  }

  public static int setLongArray(PreparedStatement preparedStatement, int index, long[] array) throws SQLException {
    for (int i = 0; i < array.length; i++) {
      preparedStatement.setLong(index++, array[i]);
    }
    return index;
  }

  public static void cleanup(Statement statement) {
    if (statement != null) {
      try {
        statement.close();
      } catch (Exception e) {
        GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Exception while closing statement.", e);
      }
    }
  }
}
