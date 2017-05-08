package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.grnds.facility.log.GrndsTrace;

public class TaskInit implements Initializable, Destroyable, Serializable {
  public static final String CD_TASK = "CD_TASK";
  public static final String DT_LAST_UPDATE = "DT_LAST_UPDATE";
  public static final String CD_TASK_EVENT_STATUS = "CD_TASK_EVENT_STATUS";
  public static final String CD_TASK_EVENT_TYPE = "CD_TASK_EVENT_TYPE";
  public static final String CD_TASK_LIST_WINDOW = "CD_TASK_LIST_WINDOW";
  public static final String CD_TASK_PRIOR = "CD_TASK_PRIOR";
  public static final String CD_TASK_STAGE = "CD_TASK_STAGE";
  public static final String CD_TASK_STAGE_PROGRAM = "CD_TASK_STAGE_PROGRAM";
  public static final String CD_TASK_TOP_WINDOW = "CD_TASK_TOP_WINDOW";
  public static final String IND_STAGE_CLOSURE = "IND_STAGE_CLOSURE";
  public static final String IND_TASK_DETAIL_ENABLE = "IND_TASK_DETAIL_ENABLE";
  public static final String IND_TASK_EVENT_CREATE = "IND_TASK_EVENT_CREATE";
  public static final String IND_TASK_EVENT_NAVIG = "IND_TASK_EVENT_NAVIG";
  public static final String IND_TASK_LIST_ENABLE = "IND_TASK_LIST_ENABLE";
  public static final String IND_TASK_MULTIPLE_INSTANCE = "IND_TASK_MULTIPLE_INSTANCE";
  public static final String IND_TASK_NEW_ENABLE = "IND_TASK_NEW_ENABLE";
  public static final String IND_TASK_NEW_USING = "IND_TASK_NEW_USING";
  public static final String IND_TASK_NU_ACROSS_CASE = "IND_TASK_NU_ACROSS_CASE";
  public static final String IND_TASK_RTRV_PRIOR_STAGE = "IND_TASK_RTRV_PRIOR_STAGE";
  public static final String IND_TASK_SHOW_IN_LIST = "IND_TASK_SHOW_IN_LIST";
  public static final String IND_TASK_TODO_ENABLE = "IND_TASK_TODO_ENABLE";
  public static final String IND_TASK_NEW_CASE_TODO_ENABLE = "IND_TASK_NEW_CASE_TODO_ENABLE"; // proposed column
  public static final String IND_TASK_FORCE_EVENT_LINK = "IND_TASK_FORCE_EVENT_LINK"; // proposed column
  public static final String TXT_TASK_DECODE = "TXT_TASK_DECODE";
  public static final String TXT_NAV_URL = "TXT_NAV_URL"; //proposed column
  public static final String TXT_1ST_TAB = "TXT_1ST_TAB"; //proposed column
  public static final String TXT_2ND_TAB = "TXT_2ND_TAB"; //proposed column
  public static final String TXT_3RD_TAB = "TXT_3RD_TAB"; //proposed column
  public static final String TXT_EVENT_DETAIL_URL = "TXT_EVENT_DETAIL_URL"; //proposed column

  public static final String CD_STAGE_PROGRAM_ALL = "ALL";
  public static final String APP_TASK_EVENT_TYPE = "APP";
  public static final String IND_TRUE = "1";
  public static final String IND_FALSE = "0";

  private static final String TRACE_TAG = "TaskInit";
  private static final String TASK_TABLE = "TASK";

  @SuppressWarnings({"FieldAccessedSynchronizedAndUnsynchronized"})
  private static Map<String, Map<String, Object>> tasks = null;

  @SuppressWarnings({"FieldAccessedSynchronizedAndUnsynchronized"})
  private static Map<String, Set<Option>> newCaseTodoTaskMap = new HashMap<String, Set<Option>>();

  public void initialize(ServletContext servletContext) throws BasePrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".initialize");
    try {
      Connection connection = null;
      try {
        GrndsTrace.enterScope(TRACE_TAG + ".loadTasks");
        connection = JdbcHelper.getConnection();
        // Task table has 329 rows, so allow some room for growth
        // This is a safe cast becasue the key value is always a string.
        //noinspection AssignmentToStaticFieldFromInstanceMethod
        tasks = createHashMapFromDatabaseTable(connection, TASK_TABLE, CD_TASK, 350);
      } finally {
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      }
    } catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
    }
  }

  public static String getTaskColumnString(String taskCode, String column) {
    return (String) getTaskColumnObject(taskCode, column);
  }

  public static Object getTaskColumnObject(String taskCode, String column) {
    Map hashMap = getTask(taskCode);
    if (hashMap == null) {
      throw new IllegalStateException("don't have information for taskCode: '" + taskCode + "'");
    }
    return hashMap.get(column);
  }

  public static Map<String, Object> getTask(String taskCode) {
    return tasks.get(taskCode);
  }

  /**
   * This method walks the task hashmap to find all the codes with the approval status task event type code.
   *
   * @param szCdStage        The stage code for the new todo
   * @param szCdStageProgram The program code for the new todo
   * @return A <code>java.util.Set<code> object containing strings of task codes.
   */
  public static Set<Option> getCaseTodoTasks(String szCdStage, String szCdStageProgram) {
    if (szCdStage == null || szCdStageProgram == null) {
      throw new IllegalArgumentException(
              "The stage and/or program code passed to TaskInit.getCaseTodoTasks() were/was null.");
    }
    // Create a key with both codes
    String mapKey = szCdStage + " " + szCdStageProgram;
    // This can happen at any time from multiple threads, so use the singleton strategy to initialize it.
    if (newCaseTodoTaskMap.get(mapKey) == null) {
      synchronized (TRACE_TAG) {
        if (newCaseTodoTaskMap.get(mapKey) == null) {
          Set<Option> newCaseTodoTaskSet = new HashSet<Option>();
          Iterator<String> it = tasks.keySet().iterator();
          while (it.hasNext()) {
            String taskCode = it.next();
            Map<String, Object> row = tasks.get(taskCode);
            String indTaskNewCaseTodoEnable = (String) row.get(IND_TASK_NEW_CASE_TODO_ENABLE);
            //String indTaskShowInList = row.get(IND_TASK_SHOW_IN_LIST);
            String tableStageCode = (String) row.get(CD_TASK_STAGE);
            String tableStageProgramCode = (String) row.get(CD_TASK_STAGE_PROGRAM);
            String tableTaskEventTypeCode = (String) row.get(CD_TASK_EVENT_TYPE);
            tableStageProgramCode =
                    tableStageProgramCode == null ? "" : tableStageProgramCode; // so we don't throw an NPE below
            // must be the same stage
            // cannot be an approval task
            // IND_TASK_NEW_CASE_TODO_ENABLE must be true
            // same program or "ALL" program
            if (szCdStage.equals(tableStageCode) &&
                !APP_TASK_EVENT_TYPE.equals(tableTaskEventTypeCode) &&
                IND_TRUE.equals(indTaskNewCaseTodoEnable) &&
                (szCdStageProgram.equals(tableStageProgramCode) ||
                 CD_STAGE_PROGRAM_ALL.equals(tableStageProgramCode))) {
              String taskDecode = (String) row.get(TXT_TASK_DECODE);
              newCaseTodoTaskSet.add(new Option(taskCode, taskDecode));
            }
          }
          newCaseTodoTaskMap.put(mapKey, newCaseTodoTaskSet);
        }
      }
    }
    // We need to return a new hashset to prevent the "master" copy from being modified
    return new HashSet<Option>(newCaseTodoTaskMap.get(mapKey));
  }

  /**
   * This code is duplicated in SqlHelper, basically (minus the hash part).  However, because we are incorrectly using
   * Oracle dates instead of Oracle timestamps for optimistic locking, it is not properly generic.
   */
  private static Map<String, Map<String, Object>> createHashMapFromDatabaseTable(Connection connection, String table,
                                                                                 String keyName, int fetchSize)
          throws SQLException {
    Map<String, Map<String, Object>> cachedTable = new HashMap<String, Map<String, Object>>();
    keyName = keyName.toUpperCase();

    Statement statement = null;
    ResultSet resultSet = null;

    try {
      statement = connection.createStatement();
      //ASC 04/18/2005 - for Oracle 10g driver.
      statement.setFetchSize(fetchSize);
      resultSet = statement.executeQuery("select * from " + table);
      resultSet.setFetchSize(fetchSize); // make this large enough to be useful
      ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
      int columnCount = resultSetMetaData.getColumnCount();
      String[] columnNames = new String[columnCount];
      int keyIndex = -1;
      for (int i = 0; i < columnCount; i++) {
        columnNames[i] = resultSetMetaData.getColumnName(i + 1);
        if (columnNames[i].equals(keyName)) {
          keyIndex = i;
        }
      }
      if (keyIndex == -1) {
        throw new IllegalStateException("can't find key columnName '" + keyName + "'");
      }
      while (resultSet.next()) {
        Map<String, Object> row = new HashMap<String, Object>();
        for (int i = 0; i < columnCount; i++) {
          // Note: This will fail if we are expecting timestamp values instead of dates because of how Oracle 9.2+ behaves.
          row.put(columnNames[i], resultSet.getObject(i + 1));
        }
        Object key = row.get(columnNames[keyIndex]);
        cachedTable.put(String.valueOf(key), row);
      }
      return cachedTable;
    } finally {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
    }
  }

  @SuppressWarnings({"AssignmentToStaticFieldFromInstanceMethod", "AssignmentToNull"})
  public void destroy(ServletContext config) throws BasePrsException {
    tasks = null;
    newCaseTodoTaskMap = null;
  }
}
