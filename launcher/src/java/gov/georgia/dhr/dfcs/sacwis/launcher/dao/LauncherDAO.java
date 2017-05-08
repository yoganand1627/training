/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.launcher.dao;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Interface to the new DAO that updates the database using the data source
 * as specified in the the configuration launcher-server-context.xml. This 
 * interface substitutes the DAO used previously accessed the databse through 
 * hibernate
 * 
 * @author Kapil Aggarwal 
 * SACWIS PROJECT 2007, ATLANTA, GA
 */
public interface LauncherDAO {

  /**
   * The method updates the REPORT_LIST table during the execution of the
   * generateReport() for the training environment for the given schema
   * and while the process executes through various steps
   * the following method is called to alter the session to the logged 
   * in user first and update the row maintaining the record
   * of the report by updating it's status: Run, Pend, Err and Done.<BR>
   * These statuses are then displayed accordingly on the Report List page
   *  
   *  @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#executeProcess(ProcessBuilder processBuilder, File logFile, String reportFilename)
   *  @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#updateReportList(String)
   *  
   * @param reportStatusRunning
   * @param reportFilename
   * @param idReport
   * @param type
   * @return Number of rows updated
   */
  public int updateReportListStatus(String reportStatusRunning,
                                    String reportFilename, int idReport, String type);
  /**
   * The method updates the REPORT_LIST table during the execution of the
   * generateReport() for the training environment for the given schema
   * and while the process executes through various steps
   * the following method is called to update the row maintaining the record
   * of the report by updating it's status: Run, Pend, Err and Done.<BR>
   * These statuses are then displayed accordingly on the Report List page
   *  
   *  @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#executeProcess(ProcessBuilder processBuilder, File logFile, String reportFilename)
   *  @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#updateReportList(String)
   *  
   * @param reportStatusRunning
   * @param reportFilename
   * @param idReport
   * @param schema
   * @param type
   * @return Number of rows updated
   */
  public int updateReportListStatus(String reportStatusRunning,
                                    String reportFilename, int idReport, String schema, String type);
  
  /**
   * insert new row to report list. This is called from job that executed by batch so id_person is not set
   * @param name
   * @param version
   * @param retainageDate
   * @param status
   * @param genName
   * @param type
   * @return
   */
  public int insertReportListStatus(String name, String version, Date retainageDate, String status, String genName, String type);
  
  /**
   * Delete all reports except the one just created defined by the excludedId
   * @param exlcludedId - this is id report list also primary key of report_list table
   * @param reportName - this is report sqr name also primary key of reports table
   * @return
   */
  public int deleteAllOthersReportList(int exlcludedId, String reportName);
  
  /**
   * The method is called each time the launcher starts afresh for the training 
   * environment for the given schema. The method first alter the session to the logged 
   * in user first and it retrieves the list of rows from the database with the 
   * status of "Pend". This list is then used to re-process those reports. 
   *  
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.ReportLauncherImpl#getPendingReportList() 
   * 
   * @return List of rows with Pend status
   */
  public List<Map<String, Object>> getPendingReportList();
  /**
   * The method is called each time the launcher starts afresh for the training 
   * environment for the given schema. It retrieves the 
   * list of rows from the database with the status of "Pend". This list is then
   * used to re-process those reports.  
   *  
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.ReportLauncherImpl#getPendingReportList() 
   * 
   * @param schema
   * @return List of rows with Pend status
   */
  public List<Map<String, Object>> getPendingReportList(String schema);
  
  /**
   * The method is called by the jxls report job to retrieve the data for the job
   *
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.ReportLauncherImpl#getPendingReportList() 
   * @param sql - sql to be executed
   * @param params - the params for report tghe bind variables for the sql 
   * @return List of maps that is return by the query
   */
  public List<Map<String, Object>> performJXLSQuery(String sql, String[] params);

  /**
   * Perform a codes tables lookup for tableName, searching for the encodedValue
   * @param tableName
   * @param encodedValue
   * @return
   */
  public String performCodesTablesDecode(String tableName, String encodedValue);

}
