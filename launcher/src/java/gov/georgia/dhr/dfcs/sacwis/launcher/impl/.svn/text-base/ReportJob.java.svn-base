/**
 * Created on Dec 21, 2006 at 12:12:15 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.launcher.impl;

/**
 * This interface declares the methods available for creation of a ReportJob.
 * This Interface has currently one implementation in class SQRJob. These methods
 * will be called prior to the execution of the process to create a job which 
 * will then be executed
 * 
 * SACWIS PROJECT 2006-7, ATLANTA, GA
 */
public interface ReportJob extends Runnable {

  /**
   * Thread Method that retrieves the processing information, creates a process
   * and then executes the process of creation of a Report
   */
  void run();

  /**
   * Set up the report parameters. 
   */
  void setReportParams(String argString);

  /**
   * Set the idPerson
   */
  void setIdPerson(int idPerson);

  /**
   * Set the nmPerson
   */
  void setNmPerson(String nmPerson);
  
  /**
   * Set the idReport
   */
  void setIdReport(int idReport);

  /** 
   * Set the Report Name
   */
  void setReportName(String reportName);

  /**
   * Set the report version
   */
  void setReportVersion(String reportVersion);
  
  /**
   * Set the User Name (schema name used for Training environment)
   */
  void setUserName(String userName);
}
