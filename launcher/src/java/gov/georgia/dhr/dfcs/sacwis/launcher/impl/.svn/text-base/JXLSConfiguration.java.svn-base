package gov.georgia.dhr.dfcs.sacwis.launcher.impl;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** Used to store static configuration of the JXLS jobs. */
public class JXLSConfiguration {
  private static Log log = LogFactory.getLog(JXLSJob.class);

  private String logDir;
  private String maximumsFile;
  private String outputDir;
  private String templateDir;
  private String perUserSchemaSupport;
  
  /**
   * Get absolute values for all the set variable values
   */
  public void init() {
    // This is defined in an init method so paths relative to the working dir can be used, eventually.
    templateDir = getVerifiedDir(templateDir) + File.separator;
    log.info("Template dir  dir is: " + templateDir);

    // TODO: Create logic to deal with paths relative to the working dir.
    logDir = getVerifiedDir(logDir) + File.separator;
    log.info("Log dir is: " + logDir);

    outputDir = getVerifiedDir(outputDir) + File.separator;
    log.info("Output dir is: " + outputDir);

    maximumsFile = getVerifiedFile(maximumsFile);
    log.info("Maximums file is: " + maximumsFile);
  }
  
  public static Log getLog() {
    return log;
  }
  public static void setLog(Log log) {
    JXLSConfiguration.log = log;
  }
  public String getLogDir() {
    return logDir;
  }
  public void setLogDir(String logDir) {
    this.logDir = logDir;
  }
  public String getMaximumsFile() {
    return maximumsFile;
  }
  public void setMaximumsFile(String maximumsFile) {
    this.maximumsFile = maximumsFile;
  }
  public String getOutputDir() {
    return outputDir;
  }
  public void setOutputDir(String outputDir) {
    this.outputDir = outputDir;
  }
  public String getTemplateDir() {
    return templateDir;
  }
  public void setTemplateDir(String templateDir) {
    this.templateDir = templateDir;
  }
  public String getPerUserSchemaSupport() {
    return perUserSchemaSupport;
  }
  public void setPerUserSchemaSupport(String perUserSchemaSupport) {
    this.perUserSchemaSupport = perUserSchemaSupport;
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
