/**
 * Created on Jan 8, 2007 at 11:03:49 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.launcher.impl;

import java.io.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** Used to store static configuration of the SQR jobs. */
public class SQRConfiguration {

  private static Log log = LogFactory.getLog(SQRJob.class);

  private String sqrCommand;
  private String includeDir;
  private String logDir;
  private String maximumsFile;
  private String outputDir;
  private String printerName;
  private String reportDir;
  private String connectionString;
  private String perUserSchemaSupport;
  private File workingDirFile;
  private String password;
  private String sid;
  /**
   * Get the logs
   * 
   * @return
   */
  public static Log getLog() {
    return log;
  }

  /**
   * Set the logs
   * @param log
   */
  public static void setLog(Log log) {
    SQRConfiguration.log = log;
  }
  
  /**
   * Get the sqrCommand
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#createProcess(String, String)
   * 
   * @return
   */
  public String getSqrCommand() {
    return sqrCommand;
  }

  /**
   * Set the SQR Command
   * @param sqrCommand
   */
  public void setSqrCommand(String sqrCommand) {
    this.sqrCommand = sqrCommand;
  }

  /**
   * Get the included directories. This is used as a parameter for the SQR command
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#createProcess(String, String)
   * 
   * @return
   */
  public String getIncludeDir() {
    return includeDir;
  }

  /**
   * Set the included directories. This is used as a parameter for the SQR command 
   * 
   * @param includeDir
   */
  public void setIncludeDir(String includeDir) {
    this.includeDir = includeDir;
  }

  /**
   * Used by the SQR job to log
   * @return
   */
  public String getLogDir() {
    return logDir;
  }

  /**
   * Set up by the config file to set up the log directory
   * 
   * @param logDir
   */public void setLogDir(String logDir) {
    this.logDir = logDir;
  }

  /**
   * Get Maxims file that is used with the parameter -m in the creation of SQR Command
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#createProcess(String, String)
   * 
   * @return
   */
  public String getMaximumsFile() {
    return maximumsFile;
  }

  /**
   * Set Maxims file that is used with the parameter -m in the creation of SQR Command
   * @return
   * @param maximumsFile
   */
  public void setMaximumsFile(String maximumsFile) {
    this.maximumsFile = maximumsFile;
  }

  /**
   * Get Output Dir that is used with the parameter -f in the creation of SQR Command
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#createProcess(String, String)
   * 
   * @return
   */
  public String getOutputDir() {
    return outputDir;
  }
  
  /**
   * Set Output Dir that is used with the parameter -f in the creation of SQR Command
   * @param outputDir
   */
  public void setOutputDir(String outputDir) {
    this.outputDir = outputDir;
  }

  /**
   * Get Printer name that is used with the parameter -printer: in the creation of SQR Command
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#createProcess(String, String)
   * 
   * @return
   */
  public String getPrinterName() {
    return printerName;
  }
  
  /**
   * Set Printer name that is used with the parameter -printer: in the creation of SQR Command
   * @param printerName
   */
  public void setPrinterName(String printerName) {
    this.printerName = printerName;
  }

  /**
   * Get Report Dir that is used in as a parameter to place reports in the SQR Command
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#createProcess(String, String)
   * 
   * @return
   */
  public String getReportDir() {
    return reportDir;
  }

  /**
   * Set Report Dir that is used in as a parameter to place reports in the SQR Command
   * @param reportDir
   */
  public void setReportDir(String reportDir) {
    this.reportDir = reportDir;
  }
  /**
   * Get ConnectionString that is used in as a parameter in the SQR Command
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#createProcess(String, String)
   * 
   * @return
   */
  public String getConnectionString() {
    return connectionString;
  }
  /**
   * This method returns the connection string by passing the schema (userName)
   * that constructs the connection string based on the OS.
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#createProcess(String, String)
   * @param userName (schema)
   * @return connectionString
   */
  public String getConnectionString(String userName) {
    /* Get Training mode 
     * If (in Training mode){
     *   connectionString should be in one of the following format for the 
     *   different OS.
     * }
     */
    if(getPerUserSchemaSupport().equals("true")){
      String os = System.getProperty("os.name").toLowerCase();
      // Windows
      if ((os.indexOf("windows 9") > -1)
           ||(os.indexOf("nt") > -1)
           || (os.indexOf("windows 2000") > -1 )
           || (os.indexOf("windows xp") > -1) ) {
        // ${install.jdbc.sid}/${launcher.jdbc.username}/${launcher.jdbc.password}
        connectionString = getSid()+"/"+userName+"/"+getPassword();  
      }
      // Unix
      else{
        //${launcher.jdbc.username}/${launcher.jdbc.password}@${install.jdbc.sid}
        connectionString = userName+"/"+getPassword()+"@"+getSid();
      }
    }
    return connectionString;
  }

  /**
   * Set ConnectionString that is used in as a parameter in the SQR Command
   * @param connectionString
   */
  public void setConnectionString(String connectionString) {
    this.connectionString = connectionString;
  }

  /**
   * @return the perUserSchemaSupport
   */
  public String getPerUserSchemaSupport() {
    return perUserSchemaSupport;
  }

  /**
   * @param perUserSchemaSupport the perUserSchemaSupport to set
   */
  public void setPerUserSchemaSupport(String perUserSchemaSupport) {
    this.perUserSchemaSupport = perUserSchemaSupport;
  }

  /**
   * Get Working Directory File
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.launcher.impl.SQRJob#createProcess(String, String)
   * 
   * @return
   */
  public File getWorkingDirFile() {
    return workingDirFile;
  }

  /**
   * Set Working Directory File
   * @param workingDir
   */
  public void setWorkingDir(String workingDir) {
    File workingDirFile = new File(workingDir);
    if (!workingDirFile.isDirectory()) {
      throw new IllegalStateException("SQR Working directory does not exist or is not a directory: " +
                                      this.workingDirFile);
    }
    this.workingDirFile = workingDirFile;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the sid
   */
  public String getSid() {
    return sid;
  }

  /**
   * @param sid the sid to set
   */
  public void setSid(String sid) {
    this.sid = sid;
  }

  /**
   * Get absolute values for all the set variable values
   */
  public void init() {
    // This is defined in an init method so paths relative to the working dir can be used, eventually.
    log.info("Working dir is: " + workingDirFile);

    // TODO: Create logic to deal with paths relative to the working dir.
    logDir = getVerifiedDir(logDir) + File.separator;
    log.info("Log dir is: " + logDir);

    reportDir = getVerifiedDir(reportDir) + File.separator;
    log.info("Report dir is: " + reportDir);

    includeDir = getVerifiedDir(includeDir) + File.separator;
    log.info("Include dir is: " + includeDir);

    outputDir = getVerifiedDir(outputDir) + File.separator;
    log.info("Output dir is: " + outputDir);

    maximumsFile = getVerifiedFile(maximumsFile);
    log.info("Maximums file is: " + maximumsFile);

    sqrCommand = getVerifiedFile(sqrCommand);
    log.info("SQR command is: " + sqrCommand);

    log.info("Printer name is: " + printerName);
    
    if (log.isTraceEnabled()){
      log.info("Connection string is: " + connectionString);
    }
  }

  /**
   * 
   * @param path
   * @return
   */
  private String getVerifiedFile(String path) {
    return getVerifiedPath(path, true);
  }

  private String getVerifiedDir(String path) {
    return getVerifiedPath(path, false);
  }

  /**
   * Check if the path exists and return the absolute path.
   * 
   * @param path
   * @param isFile
   * @return
   */
  private String getVerifiedPath(String path, boolean isFile) {
    File file = new File(path);
    if (!file.exists()) {
      throw new IllegalStateException("The path does not exist: " + path);
    }
    if (isFile && !file.isFile()) {
      throw new IllegalStateException("The path is not a file: " + path);
    }
    if (!isFile && !file.isDirectory()) {
      throw new IllegalStateException("The path is not a directory: " + path);
    }
    return file.getAbsolutePath();
  }
}
