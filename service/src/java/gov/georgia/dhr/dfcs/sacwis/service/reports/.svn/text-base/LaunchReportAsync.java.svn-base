package gov.georgia.dhr.dfcs.sacwis.service.reports;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC07SO;
import gov.georgia.dhr.dfcs.sacwis.launcher.ReportLauncher;

public interface LaunchReportAsync {

  public static final String REPORT_STATUS_ERR = ReportLauncher.REPORT_STATUS_ERR;
  public static final String REPORT_STATUS_DONE = ReportLauncher.REPORT_STATUS_DONE;
  public static final String REPORT_STATUS_PENDING = ReportLauncher.REPORT_STATUS_PENDING;
  public static final String REPORT_STATUS_RUNNING = ReportLauncher.REPORT_STATUS_RUNNING;

  /**
   * This service is the ON-DEMAND RPT LAUNCH 
   *
   * @param carc07si {@link CARC07SI}
   * @return {@link CARC07SO}
   */
  public int saveReportList(CARC07SI carc07si);
  
  public void launchReportAsync (int idReportList, CARC07SI carc07si);
  
  public void launchBatchReportAsync (CARC07SI carc07si);

}
