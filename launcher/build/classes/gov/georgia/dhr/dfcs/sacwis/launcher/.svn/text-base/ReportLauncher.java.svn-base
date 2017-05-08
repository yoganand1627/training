/**
 * Created on Dec 15, 2006 at 3:51:42 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.launcher;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI;

public interface ReportLauncher {
	

  // During the processing of a Report the process executes through
  // various steps and the status of the stage progressed is maintained
  // in the REPORT_LIST table and the following statuses are used
  public static final String REPORT_STATUS_ERR = "Err";
  public static final String REPORT_STATUS_DONE = "Done";
  public static final String REPORT_STATUS_PENDING = "Pend";
  public static final String REPORT_STATUS_RUNNING = "Run";

  /**
   * This method generates a report.  Though it is usually done asynchronously, 
   * there is no guarantee that it will be done that way. This method is currently
   * called by the application remotely after it attains the instance of class of
   * type ReportLauncher
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.service.reports.impl.LaunchReportAsyncImpl#launchReportAsync(int, CARC07SI)
   *
   * @param idReportList
   * @param carc07si
   */
  void generateReport(int idReportList, CARC07SI carc07si);
  
  /**
   * This method generates a report. This method is called by spring batch.
   * @param carc07si
   */
  void generateBatchReport(CARC07SI carc07si);

  /**
   * This method retrieves the report binary using the name of the file.
   *
   * @see gov.georgia.dhr.dfcs.sacwis.service.reports.impl.RetrieveReportImpl#retrieveReport(gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveReportSI)
   * 
   * @param filename
   */
  byte[] retreieveReport(String filename, String type);

  /**
   * This method is called by the ReportLauncherMain to process any jobs that
   * are in the Pend status in the REPORT_LIST table when the launcher starts.
   * 
   * gov.georgia.dhr.dfcs.sacwis.launcher.main.ReportLauncherMain
   */
  void runPendingReports();
}
