package gov.georgia.dhr.dfcs.sacwis.launcher.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.LauncherDAO;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

/**
 * Implementation of the Interface LauncherDAO which has methods modify the database
 * directly using the data source.

 * @author Kapil Aggarwal
 * SACWIS PROJECT 2007, ATLANTA, GA
 */
public class LauncherDAOImpl extends SimpleJdbcDaoSupport implements LauncherDAO {

  /**
   * The method updates the REPORT_LIST table during the execution of the
   * generateReport() and while the process executes through various steps
   * the following method is called to update the row maintaining the record
   * of the report by updating it's status: Run, Pend, Err and Done.<BR>
   * These statuses are then displayed accordingly on the Report List page
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#executeProcess(ProcessBuilder processBuilder, File logFile, String reportFilename)
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#updateReportList(String)
   *  
   * @param reportStatusRunning
   * @param reportFilename
   * @param idReport
   * @return Number of rows updated
   */
  public int updateReportListStatus(String txtRptLstStatus, String txtRptGenName, int idRptList, String type){
    int retValue = 0;
    String sql = "UPDATE REPORT_LIST R SET " + "R.TXT_RPT_LST_STATUS = ?, " + "R.TXT_RPT_GEN_NAME = ?, R.NM_RPT_TYPE  = ? WHERE "
               + "R.ID_RPT_LIST = ?";
    retValue = getSimpleJdbcTemplate().update(sql, new Object[] { txtRptLstStatus, txtRptGenName, type, idRptList,  });
    return retValue;
  }
  /**
   * The method updates the REPORT_LIST table during the execution of the
   * generateReport() for the training environment for the given schema
   * and while the process executes through various steps
   * the following method is called to alter the session to the logged 
   * in user first and update the row maintaining the record
   * of the report by updating it's status: Run, Pend, Err and Done.<BR>
   * These statuses are then displayed accordingly on the Report List page
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#executeProcess(ProcessBuilder processBuilder, File logFile, String reportFilename)
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#updateReportList(String)
   *  
   * @param reportStatusRunning
   * @param reportFilename
   * @param idReport
   * @param schema
   * @return Number of rows updated
   */
  public int updateReportListStatus(String txtRptLstStatus, String txtRptGenName, int idRptList, String schema,  String type){
    int retValue = 0;
    SingleConnectionDataSource scds = null;
    try {
      scds = new SingleConnectionDataSource(getConnection(),true);
      JdbcOperations jdbcOperations = new JdbcTemplate(scds);
      String alterSessionStatement = "ALTER SESSION SET CURRENT_SCHEMA= "+ schema;
      // Not sure why, but the schema cannot be set as a bound variable; it must be part of the SQL text.
      jdbcOperations.execute(alterSessionStatement);

      String sql = "UPDATE REPORT_LIST R SET " + "R.TXT_RPT_LST_STATUS = ?, " + "R.TXT_RPT_GEN_NAME   = ?, R.NM_RPT_TYPE  = ? WHERE "
                 + "R.ID_RPT_LIST = ?";
      retValue = jdbcOperations.update(sql, new Object[] { txtRptLstStatus, txtRptGenName, idRptList, type });
    } catch (CannotGetJdbcConnectionException e) {
      logger.error("In updateReportListStatus, cannot connect to RDBMS");
      throw new ServiceException();
    } catch (DataAccessException e) {
      logger.error("In updateReportStatus, error with data access");
      throw new ServiceException();
    } finally {
      scds.destroy();
    }
    return retValue;
  }
  
  /**
   * This method is created to use in UDR reports called by batch. It inserts a row in report_list table with 
   * status of Done or Error, after transform() finished. 
   */
  public int insertReportListStatus(String name, String version, Date retainageDate, String status, String genName, String type){
	    int retValue = 0;
	    int reportId = 0;
	    SimpleJdbcTemplate sJdbc = getSimpleJdbcTemplate();
	    reportId = sJdbc.queryForInt("select SEQ_REPORT_LIST.NEXTVAL from dual");
	    String sql = "Insert into REPORT_LIST (ID_RPT_LIST, NM_RPT_SQR_NAME, NM_RPT_SQR_VER, DT_RPT_LST_RETAINAGE, DT_RPT_LST_GENERATION, TXT_RPT_GEN_NAME, TXT_RPT_LST_STATUS, NM_RPT_TYPE) " +
	    		" values (?,?,?,?,?,?,?,?)" ;
	    if (reportId > 0) {
	    	retValue = sJdbc.update(sql, new Object[] { reportId, name, version, retainageDate, new Date(), genName, status, type });
	    }
	    return retValue > 0 ? reportId : retValue;
	  }
  
  public int deleteAllOthersReportList(int exlcludedId, String reportName) {
	  int retValue = 0;
	  SimpleJdbcTemplate sJdbc = getSimpleJdbcTemplate();
	  String sql = "Delete from REPORT_LIST where NM_RPT_SQR_NAME = ? and ID_RPT_LIST <> ?";
	  retValue = sJdbc.update(sql, new Object[] { reportName, exlcludedId });
	  return retValue;
  }

  /**
   * The method is called each time the launcher starts afresh. It retrieves the 
   * list of rows from the database with the status of "Pend". This list is then
   * used to re-process those reports.  
   *
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.ReportLauncherImpl#getPendingReportList() 
   *  
   * @return List of rows with Pend status
   */
  public List<Map<String, Object>> getPendingReportList() {
    String sql = "SELECT * FROM REPORT_LIST R WHERE R.TXT_RPT_LST_STATUS = ?";
    return getSimpleJdbcTemplate().queryForList(sql, "Pend");
  }
  /**
   * The method is called each time the launcher starts afresh for the training 
   * environment for the given schema. The method first alter the session to the logged 
   * in user first and it retrieves the list of rows from the database with the 
   * status of "Pend". This list is then used to re-process those reports.  
   *
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.ReportLauncherImpl#getPendingReportList() 
   * @param schema 
   * @return List of rows with Pend status
   */
  public List<Map<String, Object>> getPendingReportList(String schema) {
    SingleConnectionDataSource scds = null;
    List<?> queryList = null;
    try {
      scds = new SingleConnectionDataSource(getConnection(),true);
      JdbcOperations jdbcOperations = new JdbcTemplate(scds);
      String alterSessionStatement = "ALTER SESSION SET CURRENT_SCHEMA= "+ schema;
      // Not sure why, but the schema cannot be set as a bound variable; it must be part of the SQL text.
      jdbcOperations.execute(alterSessionStatement);
      String sql = "SELECT * FROM REPORT_LIST R WHERE R.TXT_RPT_LST_STATUS = ?";
      Object[] status = {"Pend"};
      queryList = (List<?>)jdbcOperations.queryForList(sql, status);
    } catch (CannotGetJdbcConnectionException e) {
      logger.error("In getPendingReportList, cannot connect to RDBMS");
      throw new ServiceException();
   } catch (DataAccessException e) {
      logger.error("In getPendingReportList, error with data access");
      throw new ServiceException();
    } finally {
      scds.destroy();
    }
    List<Map<String, Object>> retList = copyToNewList(queryList);
    return retList;
  }
  
  /**
   * The method is called by the jxls report job to retrieve the data for the job
   *
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.ReportLauncherImpl#getPendingReportList() 
   * @param sql - sql to be executed
   * @param params - the params for report tghe bind variables for the sql 
   * @return List of maps that is return by the query
   */
  public List<Map<String, Object>> performJXLSQuery(String sql, String[] params) {
    SingleConnectionDataSource scds = null;
    List<?> queryList = null;
    try {
      scds = new SingleConnectionDataSource(getConnection(),true);
      JdbcOperations jdbcOperations = new JdbcTemplate(scds);
      queryList = (List<?>)jdbcOperations.queryForList(sql, params);
    } catch (CannotGetJdbcConnectionException e) {
      logger.error("When trying to perform jXLS query, cannot connect to the RDBMS");
      throw new ServiceException();
   } catch (DataAccessException e) {
      logger.error("When trying to perform jXLS query, a data access error occured.");
      throw new ServiceException();
   } finally {
      scds.destroy();
    }
    List<Map<String, Object>> retList = copyToNewList(queryList);
    return retList;
  }

  public String performCodesTablesDecode(String tableName, String encodedValue) {
    SingleConnectionDataSource scds = null;
    String decodedValue = "";
    try {
      scds = new SingleConnectionDataSource(getConnection(),true);
      JdbcOperations jdbcOperations = new JdbcTemplate(scds);
      String sql = "SELECT C.DECODE from CODES_TABLES C WHERE C.CODE_TYPE ='" + tableName + "' AND C.CODE = ?";
      String sqlParam[] = new String[] { encodedValue };
      decodedValue = (String) jdbcOperations.queryForObject(sql, sqlParam, String.class);
    } catch (CannotGetJdbcConnectionException e) {
      logger.error("While performing codes tables lookup, error connecting to the RDBMS");
      throw new ServiceException();
    } catch (DataAccessException e) {
      logger.error("While performing codes tables lookup, error in accessing data");
      throw new ServiceException();
    } finally {
      scds.destroy();
    }
    
    return decodedValue;
  }
  /**
   * This method returns a properly casted List in the format List<Map<String, Object>>
   * @param oldList
   * @return newList
   */
  private List<Map<String, Object>> copyToNewList(List<?> oldList) {
    List<Map<String, Object>> newList = new LinkedList<Map<String, Object>>();
    for (Object each : oldList) {
      Map<?,?> oldMap = (Map<?,?>)each;
      Map<String, Object> newMap = copyToNewMap(oldMap);
      newList.add((Map<String, Object>) newMap);
    }
    return newList;
  }
  /**
   * This method returns a properly casted Map in the format Map<String, Object>
   * @param oldMap
   * @return newMap
   */
  private Map<String,Object> copyToNewMap(Map<?,?> oldMap) {
    Map<String, Object> newMap = new HashMap<String, Object>();
    for (Entry<?, ?> each : oldMap.entrySet()) {
    String key = (String) each.getKey();
    Object value = each.getValue();
    newMap.put(key, value);
    }
    return newMap;
  }
}

