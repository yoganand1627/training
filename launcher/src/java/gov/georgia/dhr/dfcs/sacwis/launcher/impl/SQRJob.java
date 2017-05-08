/**
 * Created on Dec 20, 2006 at 11:53:29 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.launcher.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.launcher.ReportLauncher;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.LauncherDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** This class is an SQR-specific implementation of ReportJob. */
public class SQRJob implements ReportJob {

  private static Log log = LogFactory.getLog(SQRJob.class);

  /** Use only for logging. */
  private final String timestamp = new Date().toString();

  // Report-specific settings
  private int idPerson;
  private String nmPerson;
  private String reportName;
  private String reportParams;
  private String reportVersion;
  private int idReport;
  private String userName;
  
  // Required DAO's
  private LauncherDAO launcherDAO;

  /** The static configuration. */
  private SQRConfiguration sqrConfiguration = new SQRConfiguration();

  /**
   * Set up the report parameters. 
   */
  public void setReportParams(String reportParams) {
    this.reportParams = reportParams;
  }
  
  /**
   * Set the idPerson
   */
  public void setIdPerson(int idPerson) {
    this.idPerson = idPerson;
  }

  public void setNmPerson(String nmPerson) {
    this.nmPerson = nmPerson;
  }
  
  /**
   * Set the idReport
   */
  public void setIdReport(int idReport) {
    this.idReport = idReport;
  }

  /** 
   * Set the Report Name
   */
  public void setReportName(String reportName) {
    this.reportName = reportName;
  }

  /**
   * Set the report version
   */
  public void setReportVersion(String reportVersion) {
    this.reportVersion = reportVersion;
  }

  /**
   * @param userName the userName to set (schema)
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Set the DAO to access the data and perform the updates
   * 
   * @param launcherDAO
   */
  public void setLauncherDAO(LauncherDAO launcherDAO) {
    this.launcherDAO = launcherDAO;
  }

  /**
   * The information loaded from SQRConfiguration through the launcher-server-context.xml
   * 
   * @param sqrConfiguration
   */
  public void setSqrConfiguration(SQRConfiguration sqrConfiguration) {
    this.sqrConfiguration = sqrConfiguration;
  }


  /**
   * Thread Method that retrieves the processing information, creates a process
   * and then executes the process of creation of a Report
   */
  public void run() {
    // Use the log file as the base for the error file.
    File logFile = createLogFile();
    if (logFile == null) {
      // We failed to create the log file; just return;
      return;
    }
    String logFileName = logFile.getName();
    String basename = logFileName.substring(0, logFileName.length() - 4);
    String errorPath = sqrConfiguration.getLogDir() + basename + ".err";
    String reportFilename = basename + ".pdf";
    if (!updateReportList(reportFilename)) {
      return;
    }
    ProcessBuilder processBuilder = createProcess(reportFilename, errorPath);
    executeProcess(processBuilder, logFile, reportFilename);
  }

  /**
   * Updates the status of a report in the REPORT_LIST table during the process
   * The this method is called by run() to update the status to Run before the 
   * ProcessBuilder is created and the process is executed.
   *
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.dao.impl.LauncherDAOImpl#updateReportListStatus(String, String, int)
   *   
   * @param reportFilename
   * @return
   */
  private boolean updateReportList(String reportFilename) {
    int rowsUpdated = 0;
    //Checking for training environment and passing the schema to be used
    if (sqrConfiguration.getPerUserSchemaSupport().equalsIgnoreCase("true")){
      //userName is the training schema name
      rowsUpdated = launcherDAO.updateReportListStatus(ReportLauncher.REPORT_STATUS_RUNNING, reportFilename, idReport, userName, null);
    }else{
      rowsUpdated = launcherDAO.updateReportListStatus(ReportLauncher.REPORT_STATUS_RUNNING, reportFilename, idReport, null);
    }
    if (0 == rowsUpdated) {
      //log.error("Failed to update report generation status in the DB via LauncherDAO for " + this.toString() +
      //"; aborted report generation.");
      log.info("Failed to update report generation status in the DB via LauncherDAO for " + this.toString() +
      "; aborted report generation.");      
      return false;
    }
    return true;
  }

  /**
   * Prepares the actual command that will be executed on the command line 
   * of the SQR application
   * 
   * @param reportFilename
   * @param errorPath
   * @return
   */
  private ProcessBuilder createProcess(String reportFilename, String errorPath) {
    // Replace "^" with " " and trim to create the arg list.
    String[] reportArgs = reportParams.split("\\^");
    List<String> command = new ArrayList<String>(8 + reportArgs.length);
    command.add(sqrConfiguration.getSqrCommand());
    command.add(sqrConfiguration.getReportDir() + reportName + reportVersion + ".sqr");
    if (sqrConfiguration.getPerUserSchemaSupport().equalsIgnoreCase("true")){
      command.add(sqrConfiguration.getConnectionString(userName));
    }else{
      command.add(sqrConfiguration.getConnectionString());
    }
    command.add("-i" + sqrConfiguration.getIncludeDir());
    command.add("-e" + errorPath);
    command.add("-f" + sqrConfiguration.getOutputDir() + reportFilename);
    command.add("-printer:" + sqrConfiguration.getPrinterName());
    command.add("-m" + sqrConfiguration.getMaximumsFile());
    command.add("-xi");
    for (int i = 0; i < reportArgs.length; i++) {
      command.add(reportArgs[i]);
    }
    if (log.isTraceEnabled()) {
      log.trace("Command String: " + command.toString());
    }
    // Use ProcessBuilder because it preserves the environment and allows setting of the working directory.
    ProcessBuilder processBuilder = new ProcessBuilder(command);
    // Put stdout and stderr in the same file.
    processBuilder.redirectErrorStream(true);
    processBuilder.directory(sqrConfiguration.getWorkingDirFile());
    return processBuilder;
  }

  /**
   * This method formats/prepares the command that is then executed.
   * While the process is executed, ProcessStreamReader reads the outputs of the 
   * program into the log file. Once the process is completed the REPORT_LIST
   * is updated with the status of Done
   * 
   * @param processBuilder
   * @param logFile
   * @param reportFilename
   */
  private void executeProcess(ProcessBuilder processBuilder, File logFile, String reportFilename) {
    final Process process;
    try {
      if (log.isTraceEnabled()) {
        StringBuilder commandLineSB = new StringBuilder(256); // probably won't be logner than that
        for (Iterator<String> it = processBuilder.command().iterator(); it.hasNext();) {
          String arg = it.next();
          commandLineSB.append(" ").append(arg);
        }
        log.trace("Command line is:" + commandLineSB.toString());
        log.trace("Working dir is: " + processBuilder.directory());
        Map<String, String> environment = processBuilder.environment();
        StringBuilder environmentSB = new StringBuilder(8192);
        for (Iterator<String> it = environment.keySet().iterator(); it.hasNext();) {
          String key = it.next();
          environmentSB.append(key).append("=").append(environment.get(key)).append("\n");
        }
        log.trace("Environment:\n" + environmentSB.toString());
        }

      process = processBuilder.start();

    } catch (IOException e) {
      //log.warn("Failed to start process for " + this.toString() + ".", e);
      log.info("Failed to start process for " + this.toString() + ".", e);
      return;
    }
    // Log the output of SQR to a file.
    new ProcessStreamReader(process.getInputStream(), logFile).start();
    try {
      int result = process.waitFor();
      String status = result == 0 ? ReportLauncher.REPORT_STATUS_DONE : ReportLauncher.REPORT_STATUS_ERR;
      int rowsUpdated = 0;
      //Checking for training environment and passing the schema to be used
      if (sqrConfiguration.getPerUserSchemaSupport().equalsIgnoreCase("true")){
        //userName is the training schema name        
        rowsUpdated = launcherDAO.updateReportListStatus(status, reportFilename, idReport, userName, null);
      }else{
        rowsUpdated = launcherDAO.updateReportListStatus(status, reportFilename, idReport, null);
      }
      if (0 == rowsUpdated) {
        //log.error("Failed to set status in the DB for " + this.toString() + ".");
        log.info("Failed to set status in the DB for " + this.toString() + ".");
        return;
      }
    } catch (InterruptedException e) {
      //log.warn("Report " + this.toString() + " was interrupted and will be terminated before completing.", e);
      log.info("Report " + this.toString() + " was interrupted and will be terminated before completing.", e);
      process.destroy();
    }
  }

  /**
   * Creating a log file for logging the execution of the process
   * @return
   */
  private File createLogFile() {
    File logFile = null;
    try {
      logFile = File.createTempFile(reportName, ".log", new File(sqrConfiguration.getLogDir()));
    } catch (IOException e) {
      //log.warn("Failed to create temp file for " + this.toString() + ".", e);
      log.info("Failed to create temp file for " + this.toString() + ".", e);
    }
    return logFile;
  }

  /**
   * Overridden method from java.lang
   */
  public String toString() {
    return reportName + " version " + reportVersion + " requested by " + idPerson + " at " + timestamp;
  }

  /**
   * Class reads the input from Process stream and writes it to the log file.
   */
  private static class ProcessStreamReader extends Thread {
    private final File logFile;
    private InputStream inputStream;

    public ProcessStreamReader(InputStream inputStream, File logFile) {
      this.inputStream = inputStream;
      this.logFile = logFile;
    }

    public void run() {
      BufferedInputStream bis = null;
      FileOutputStream os = null;
      try {
        bis = new BufferedInputStream(inputStream, 2048);
        os = new FileOutputStream(logFile);
        byte[] bytes = new byte[2048];
        int bytesRead;
        while ((bytesRead = bis.read(bytes)) > 0) {
          os.write(bytes, 0, bytesRead);
        }
      } catch (IOException e) {
        //log.warn("IO error while generating report " + this.toString() + ".", e);
        log.info("IO error while generating report " + this.toString() + ".", e);
      } finally {
        if (bis != null) {
          if (os != null) {
            try {
              os.close();
            } catch (IOException e) {
              //log.warn("Error closing log file when generating report " + this.toString() + ".", e);
              log.info("Error closing log file when generating report " + this.toString() + ".", e);
            }
          }
          try {
            bis.close();
          } catch (IOException e) {
            //log.warn("Error closing input stream when generating report " + this.toString() + ".", e);
            log.info("Error closing input stream when generating report " + this.toString() + ".", e);
          }
        }
      }
    }
  }
}
