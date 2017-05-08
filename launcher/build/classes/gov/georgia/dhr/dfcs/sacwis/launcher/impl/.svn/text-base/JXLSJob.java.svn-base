package gov.georgia.dhr.dfcs.sacwis.launcher.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.ReportLauncher;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.FaIndivTrainingLnchrDAO;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.LauncherDAO;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.ResourceHistoryLnchrDAO;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.RptLauncherDAO;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.StagePersonLinkLnchrDAO;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRBaseObject;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRObjectFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JXLSJob implements ReportJob {
  
  private static Log log = LogFactory.getLog(JXLSJob.class);
  private static String JXLS_FILE_EXT = ".xls";
  private static String ERROR_FILE_EXT = ".err";
  private static String SQL_APPEND = "_SQL";
  private static final String UDR_REPORT = "U";
  private static final String BEAN_TYPE_HEADER = "headerBean";
  private static final String BEAN_TYPE_UDR_BEAN = "udrBean";
  private static final String BEAN_TYPE_ERROR = "errorBean";
  private static final String PROP_TRNG_HRS_MET = "TRAINING_HRS_MET";
  private static final String ROWCOUNT = "ROWCOUNT";
  
  private static final String NO_RESULTS_RETURNED = "The input parameters used yielded no results!";
  
  private static final String OVER_65K_ROWS = "The selected parameters would return over 65000 rows.  Please narrow the report criteria.";
  
  //Report-specific settings
  private int idPerson;
  private String nmPerson;
  private String reportName;
  private String reportParams;
  private String reportVersion;
  private int idReport;
  private String userName;
    
  // Required DAO's
  private FaIndivTrainingLnchrDAO faIndivTrainingLnchrDAO;
  
  private LauncherDAO launcherDAO;
  
  private ResourceHistoryLnchrDAO resourceHistoryLnchrDAO;
  
  private RptLauncherDAO rptLauncherDAO;
  
  private StagePersonLinkLnchrDAO stagePersonLinkLnchrDAO;
  
  /** The static configuration. */
  private JXLSConfiguration jxlsConfiguration = new JXLSConfiguration();
  
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

  /**
   * Set the nmPerson
   */
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
   * The information loaded from JXLSConfiguration through the launcher-server-context.xml
   * 
   * @param jxslConfiguration
   */
  
  public void setJxlsConfiguration(JXLSConfiguration jxlsConfiguration) {
    this.jxlsConfiguration = jxlsConfiguration;
  }
  
  /**
   * Set the DAO to access the data and perform the updates
   * 
   * @param launcherDAO
   */
  public void setLauncherDAO(LauncherDAO launcherDAO) {
    this.launcherDAO = launcherDAO;
  }

  public void setRptLauncherDAO(RptLauncherDAO rptLauncherDAO) {
    this.rptLauncherDAO = rptLauncherDAO;
  }
  
  public void setFaIndivTrainingLnchrDAO(FaIndivTrainingLnchrDAO faIndivTrainingLnchrDAO) {
    this.faIndivTrainingLnchrDAO = faIndivTrainingLnchrDAO;
  }

  public void setResourceHistoryLnchrDAO(ResourceHistoryLnchrDAO resourceHistoryLnchrDAO) {
    this.resourceHistoryLnchrDAO = resourceHistoryLnchrDAO;
  }

  public void setStagePersonLinkLnchrDAO(StagePersonLinkLnchrDAO stagePersonLinkLnchrDAO) {
    this.stagePersonLinkLnchrDAO = stagePersonLinkLnchrDAO;
  }

  public void run() {
    File logFile = createLogFile();
    if (logFile == null) {
      // We failed to create the log file; just return;
      return;
    }
    String logFileName = logFile.getName();
    String basename = logFileName.substring(0, logFileName.length() - 4);
    String errorPath = jxlsConfiguration.getLogDir() + basename + ERROR_FILE_EXT;
    String outputFileName = basename + JXLS_FILE_EXT;
    if (!updateReportList(outputFileName)) {
      return;
    }
  
    String outputFullPathFileName = jxlsConfiguration.getOutputDir() + File.separator + outputFileName;
    String templateFileName = jxlsConfiguration.getTemplateDir() + File.separator + reportName + JXLS_FILE_EXT;
    int returnCode = 1000;
    boolean over65KRows = false;
    List<Object> jXLSData = new ArrayList<Object>();
    try {
      
      // This map will store the dynamic pojos
      Map<String, Object> dataMap = new HashMap<String,Object>();

      String[] sqlParama = reportParams.split("\\^");

      // Create header information bean, then add it to the data map
      DynaBean headerBean = createAndPopulateHeaderBean(sqlParama);
      dataMap.put("header", headerBean);
      //Get the total Number of Rows returned for the given parameter
      String countSQL = createCountSQLString(sqlParama);
      if (countSQL != null){
        log.debug("Count SQL: \n" + countSQL);
        jXLSData = populateJXLSData(countSQL, sqlParama, outputFileName);
        if (!jXLSData.isEmpty() && jXLSData.size() > 0){
          //As the result will contain only the row count. If the List is not empty and size is 
          //greater than 0, then it is safe to get the first object to get the row count.
          BasicDynaBean rowCountObj = (BasicDynaBean)jXLSData.get(0);
          BigDecimal rowCount = (BigDecimal)rowCountObj.get(ROWCOUNT);
          if (rowCount.intValue() > 65000){
            over65KRows = true;
            log.warn("Results from jXLS query returned more than 65000 Rows!\n" +
                     "Report "+ outputFileName + " for user ID " + idPerson + " at " + new Date() + " will be empty.");
           //Get a Blank Row SQL and substitute the nulls as blanks to the Excel spread to
           // not to display the variable names when throwing 65 K Rows error
           String blankRowSQL = createBlankRowSQLString();
           if (blankRowSQL != null){
             //Get Blank Row to hide the variables to display in the spreadsheet.
             jXLSData = populateJXLSData(blankRowSQL, sqlParama, outputFileName);
           }
           DynaBean errorBean = createAndPopulateErrorMessageBean(OVER_65K_ROWS);
           dataMap.put("error", errorBean);            
          }
        }
      }
      //Run the actual SQL only if the number of rows returned less than 65000 so as to fit the
      //Excel Spreadsheet.
      if (!over65KRows){
        String sql = createSQLString(sqlParama);
        log.debug("SQL to be executed: \n" + sql);
        jXLSData = populateJXLSData(sql, sqlParama, outputFileName);
      }
      // add the pojos to the map
      dataMap.put("udrbeans", jXLSData);
      if (jXLSData.isEmpty()) {
        log.warn("Results from jXLS query were empty!\n" +
                  "Report "+ outputFileName + " for user ID " + idPerson + " at " + new Date() + " will be empty.");
        
        DynaBean errorBean = createAndPopulateErrorMessageBean(NO_RESULTS_RETURNED);
        dataMap.put("error", errorBean);
          
      }

      //perform transformation
      XLSTransformer transformer = new XLSTransformer();
//      long startTransformTime = Calendar.getInstance().getTimeInMillis();
      transformer.transformXLS(templateFileName, dataMap, outputFullPathFileName);
//      long endTransformTime = Calendar.getInstance().getTimeInMillis();
//      long totalTransformTime = endTransformTime - startTransformTime;
//      log.info("Total transformation time = " + totalTransformTime + " ms");
//      long totalTime = totalQueryTime + totalDynaBeanTime + totalTransformTime;
//      log.info("Total Query, Bean Population, and Transformation time = " + totalTime + " ms");
      returnCode = 0;
    } catch (Throwable t){
      log.error("Failed to generate report "+ outputFileName + " for user ID " + idPerson + " at " + new Date());
      t.printStackTrace();
    }
    
    String status = returnCode == 0 ? ReportLauncher.REPORT_STATUS_DONE : ReportLauncher.REPORT_STATUS_ERR;
    int rowsUpdated = 0;
    //Checking for training environment and passing the schema to be used
    if (jxlsConfiguration.getPerUserSchemaSupport().equalsIgnoreCase("true")){
      //userName is the training schema name        
      rowsUpdated = launcherDAO.updateReportListStatus(status, outputFileName, idReport, userName, UDR_REPORT);
    }else{
      rowsUpdated = launcherDAO.updateReportListStatus(status, outputFileName, idReport, UDR_REPORT);
    }
    if (0 == rowsUpdated) {
      log.info("Failed to set status in the DB for " + this.toString() + ".");
      return;
    }    
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
    if (jxlsConfiguration.getPerUserSchemaSupport().equalsIgnoreCase("true")){
      //userName is the training schema name
      rowsUpdated = launcherDAO.updateReportListStatus(ReportLauncher.REPORT_STATUS_RUNNING, reportFilename, idReport, userName, UDR_REPORT);
    }else{
      rowsUpdated = launcherDAO.updateReportListStatus(ReportLauncher.REPORT_STATUS_RUNNING, reportFilename, idReport, UDR_REPORT);
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
   * Creates a SQL Query String based upon the parameters
   * passed in the array.
   * @param params - a String array of report parameters
   * @return String - a SQL Query
   */
  private String createSQLString(String[] params) {
    
    UDRBaseObject udr = UDRObjectFactory.createUDRObject(reportName);
    String sqlString = "";
    
    if (StringHelper.isNotEmptyOrNull(udr)) {
      sqlString = udr.buildSQLQuery(params);
    }

    return sqlString;
  }
  /**
   * Creates a SQL Query String based upon the parameters
   * passed in the array that will give the number of rows that will return for the given
   * set of parameters.
   * @param params - a String array of report parameters
   * @return String - a SQL Query
   */
  private String createCountSQLString(String[] params) {
    
    UDRBaseObject udr = UDRObjectFactory.createUDRObject(reportName);
    String sqlString = "";
    
    if (StringHelper.isNotEmptyOrNull(udr)) {
      sqlString = udr.queryForRowCount(params);
    }

    return sqlString;
  }
  
  /**
   * Creates a SQL Query String based upon the parameters
   * passed in the array that will give the number of rows that will return for the given
   * set of parameters.
   * @param params - a String array of report parameters
   * @return String - a SQL Query
   */
  private String createBlankRowSQLString() {
    
    UDRBaseObject udr = UDRObjectFactory.createUDRObject(reportName);
    String sqlString = "";
    
    if (StringHelper.isNotEmptyOrNull(udr)) {
      Map<String, Object> params = null;
      sqlString = udr.buildSQLQuery(params);
    }

    return sqlString;
  }
  /**
   * This will be used to create SQL Strings for specific reports
   * in the case that a UDR Report is a "complex" report with
   * multiple sheets, each sheet is created as a new UDR Type
   * and that sheet's UDR Report Name is passed in.
   * @param params
   * @param strRptName
   * @return
   */
  private String createSQLString(String[] params, String strRptName) {
    UDRBaseObject udr = UDRObjectFactory.createUDRObject(strRptName);
    String sqlString = "";
    
    if (StringHelper.isNotEmptyOrNull(udr)) {
      sqlString = udr.buildSQLQuery(params);
    }

    return sqlString;
          
  }
  
  /**
   * Creates a new dynamic bean class based on the data map
   * passed in and uses className to reference the bean type
   * @param dataMap
   * @param className
   * @return
   */
  private static Object createDynaBeanClass(Map<String, Object> dataMap, String className) {
    Set<String> keys = dataMap.keySet();
    DynaProperty properties[] = new DynaProperty[keys.size()];
    int index = 0;

    for (String key : keys) {
      Object tempObj = dataMap.get(key);
      if (tempObj != null) {
        properties[index] = new DynaProperty(key, tempObj.getClass());
      } else {
        properties[index] = new DynaProperty(key);
      }
        index++;
    }
    
    DynaClass dynaClass = new BasicDynaClass(className, null, properties);

    return dynaClass;
  }
  
  /**
   * Creates a new instance of a dynamic bean based on a class definition
   * object.
   * @param dynaClass
   * @return
   */
  private static DynaBean createDynaBeanInstance(DynaClass dynaClass) {
    DynaBean dynaBean = null;
    try {
      dynaBean = dynaClass.newInstance();
    } catch (IllegalAccessException iae) {
      log.error("Error creating DynaBean instance " + dynaClass.getName() + " -- IllegalAccessException");
      throw new ServiceException();
    } catch (InstantiationException ie) {
      log.error("Error creating DynaBean instance " + dynaClass.getName() + " -- InstantiationException");
      throw new ServiceException();
    }
    return dynaBean;
   
  }
  /**
   * Populates a bean with data
   * @param bean
   * @param dataMap
   * @param beanType TODO
   */
  private void populateDynaBean(DynaBean bean, Map<String, Object> dataMap, String beanType) {
    
    /* STGAP00014320 - For the Resource Development Report,
     * We need to manually retrieve the training hours met
     * as it was not included in the UDR Retrieval SQL
     */
    if (reportName.equals(UDRObjectFactory.UDR_RESOURCE_DEV_REPT) &&
        BEAN_TYPE_UDR_BEAN.equals(beanType)) {
      loadTrngHrsMetForRept(bean, dataMap, beanType);
    } 

    Set<String> keys = dataMap.keySet();
    DynaClass dynaClass = bean.getDynaClass();

    // validate that the bean object can
    // be used with the data map
    for (String key : keys) {
      DynaProperty p = dynaClass.getDynaProperty(key);
      if (p == null) {
        //log.error(key + " is not a property of this dynabean class. Verify correct bean description is being sent with the correct data map.");
        log.info(key + " is not a property of this dynabean class. Verify correct bean description is being sent with the correct data map.");
        throw new ServiceException();
      }
    }

    // if we've made it this far, then
    // set the data in the dynamic bean
    for (String key : keys) {
      bean.set(key, dataMap.get(key));
    }
    
  }
  
  /**
   * The Spring JDBC Call in the LauncherDAO requires the param
   * array passed in to have the correct number of binding variables
   * (i.e. - if a Query has 4 binding variables, but the params array
   * has 5 params, an error occurs)
   * @param params - the current parameter array
   * @return String[] - an updated String array
   */
  private Map<String, Object> updateSQLParamArray(String[] params) {
    UDRBaseObject udr = UDRObjectFactory.createUDRObject(reportName);
    String[] newParamArray = null; 
    Map<String, Object> newParamMap = null;
    if (StringHelper.isNotEmptyOrNull(udr)) {
      newParamMap = udr.buildParamMap(params);
    } else {
      newParamMap = new HashMap<String,Object>();
    }
    
    return newParamMap;
  }
  
  /**
   * Create a DynaBean for displaying header information on the
   * User Defined Report and then populate that bean with the
   * current data.
   * @param params
   * @return
   */
  private DynaBean createAndPopulateHeaderBean(String[] params) {
    
    String dtStart = "";
    String dtEnd = "";
    String cdRegion = "";
    String cdCounty = "";
    //Added for Case Watch Activity Report
    String idCM = "";
    String idUnit = "";
    String cdErrWarn = "";
    String cdOpnClsStgs = "";
    String cdErrWarnTyp = "";
    
    if (reportName.equals(UDRObjectFactory.UDR_RESOURCE_DEV_REPT)) {
      // Resource Development reports do not have a start date
      dtStart = " ";
      dtEnd = params[0];
      cdRegion = params[1];
      cdCounty = StringHelper.isZero(params[2]) ? "" : launcherDAO.performCodesTablesDecode(CodesTables.CCOUNT, params[2]);
    } else if(reportName.equals(UDRObjectFactory.UDR_CASE_WATCH_ACT_REPT)){
      //Case Watch Activity Report has different set of Header Bean
      cdRegion = StringHelper.isZero(params[0]) ? "" :params[0];
      cdCounty = StringHelper.isZero(params[1]) ? "" : launcherDAO.performCodesTablesDecode(CodesTables.CCOUNT, params[1]);
      idUnit = StringHelper.isZero(params[2]) ? "" :params[2];
      idCM = StringHelper.isZero(params[3]) ? "" :params[3];
      cdErrWarn = StringHelper.isEmptyOrNull(params[4])? "":launcherDAO.performCodesTablesDecode(CodesTables.CERRWARN,params[4]);
      cdOpnClsStgs = StringHelper.isEmptyOrNull(params[5])? "":launcherDAO.performCodesTablesDecode(CodesTables.COPCLSTG,params[5]);
      cdErrWarnTyp = StringHelper.isEmptyOrNull(params[6])? "":launcherDAO.performCodesTablesDecode(CodesTables.CERWRTYP,params[6]);
      dtStart = StringHelper.isZero(params[7]) ? "" :params[7];
      dtEnd = StringHelper.isZero(params[8]) ? "" :params[8];
    }else {
      dtStart = params[0];
      dtEnd = params[1];
      cdRegion = params[2];
      cdCounty = StringHelper.isZero(params[3]) ? "" : launcherDAO.performCodesTablesDecode(CodesTables.CCOUNT, params[3]);
    }

    Map<String, Object> headerDataMap = new HashMap<String, Object>();
    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    headerDataMap.put("producedDate", df.format(new Date()));
    headerDataMap.put("idUser", idPerson);
    headerDataMap.put("nmUser", nmPerson);
    headerDataMap.put("dtStart", dtStart);
    headerDataMap.put("dtEnd", dtEnd);
    headerDataMap.put("cdRegion", cdRegion);
    headerDataMap.put("cdCounty", cdCounty);
    //Add the Header Data Map for Case Watch Activity separately as it has more header information
    //to populate.
    if(reportName.equals(UDRObjectFactory.UDR_CASE_WATCH_ACT_REPT)){
      headerDataMap.put("idCM", idCM);
      headerDataMap.put("idUnit", idUnit);
      headerDataMap.put("cdErrWarn", cdErrWarn);
      headerDataMap.put("cdOpnClsStgs", cdOpnClsStgs);
      headerDataMap.put("cdErrWarnTyp", cdErrWarnTyp);
    }
    DynaClass headerClass = (DynaClass) createDynaBeanClass(headerDataMap,BEAN_TYPE_HEADER);
    DynaBean headerBean = createDynaBeanInstance(headerClass);
    populateDynaBean(headerBean,headerDataMap, BEAN_TYPE_HEADER);
    return headerBean;
  }
  
  /**
   * Create a DynaBean for displaying error information on the
   * User Defined Report.
   * @param params
   * @return
   */
  private DynaBean createAndPopulateErrorMessageBean(String message) {
    
    Map<String, Object> errorDataMap = new HashMap<String, Object>();
    errorDataMap.put("message", message);
    
    DynaClass errorClass = (DynaClass) createDynaBeanClass(errorDataMap, BEAN_TYPE_ERROR);
    DynaBean errorBean = createDynaBeanInstance(errorClass);
    populateDynaBean(errorBean,errorDataMap, null);
    
    return errorBean;
  }

  private List<Object> populateJXLSData(String sql, String[] sqlParamArray, String outputFileName){
      Map<String, Object> paramMap = updateSQLParamArray(sqlParamArray);
      List<Object> jXLSData = new ArrayList<Object>();
      
      //call out to LauncherDAO to get results
      long startQueryTime = Calendar.getInstance().getTimeInMillis();
      List<Map<String, Object>>  result = rptLauncherDAO.performJXLSQuery(sql, paramMap);
      long endQueryTime = Calendar.getInstance().getTimeInMillis();
      long totalQueryTime = endQueryTime - startQueryTime;
      log.info("jXLS Query Time = " + totalQueryTime + " ms");
      //transform results to pojo
      long startDynaBeanTime = Calendar.getInstance().getTimeInMillis();
      if (StringHelper.isNotEmptyOrNull(result)) {
        // Get the first result and use the map to create a dynamic bean class
        // All of the maps in the result will have the same property names.
        Map<String, Object> propertiesMap = result.get(0);
        
        /* STGAP00014320 - If this is a Resource Dev. Report, we must add a 
         * property to the properties map before the dynamic class & dynamic 
         * bean are created
         */
        if (reportName.equals(UDRObjectFactory.UDR_RESOURCE_DEV_REPT)) {
          propertiesMap.put(PROP_TRNG_HRS_MET, null);
        }
        
        DynaClass dynaClass = (DynaClass)createDynaBeanClass(propertiesMap, BEAN_TYPE_UDR_BEAN);

        // for each result, create an instance of the dynamic bean class
        // and populate that instance. Add to the jXLS Data list
        for (Map<String, Object> map : result) {
          DynaBean bean = (DynaBean) createDynaBeanInstance(dynaClass);
          populateDynaBean(bean, map, BEAN_TYPE_UDR_BEAN);
          jXLSData.add(bean);
        }
      long endDynaBeanTime = Calendar.getInstance().getTimeInMillis();
      long totalDynaBeanTime = endDynaBeanTime - startDynaBeanTime;
      log.info("Data Bean population time = " + totalDynaBeanTime + " ms");
      } //else { return empty List }
      
      return jXLSData;
  }
  /**
   * This method sets the attribute for 'TRAINING_HOURS_MET' for the
   * UDR Resource Development report.
   * @param bean
   * @param dataMap
   * @param beanType
   */
  private void loadTrngHrsMetForRept(DynaBean bean, Map<String, Object> dataMap, String beanType) {
    Set<String> keys = dataMap.keySet();

    Integer idStage = 0;
    Integer idResource = 0;
    Date dtApproved = null;
    String indTrainingHrsMet = "";
    
    for (String key : keys) {
      //log.info("*** " + key + " = " + dataMap.get(key));
      if (key.equals("ID_STAGE")) {
        BigDecimal bdIdStage = (BigDecimal) dataMap.get(key);
        idStage = bdIdStage.intValue();
      }
      if (key.equals("RESOURCE_ID")) {
        BigDecimal bdIdResource = (BigDecimal) dataMap.get(key);
        idResource = bdIdResource.intValue();
      }
    }
    
    dtApproved = resourceHistoryLnchrDAO.findFirstApprovedDateForResource(idResource);
    //log.error("- - - - idResource = " + idResource);
    indTrainingHrsMet = processTrainingHoursMet(idStage, dtApproved);
    dataMap.put(PROP_TRNG_HRS_MET, indTrainingHrsMet);
    
  }
  
  /**
   * This will return Y or N based on whether or not
   * training hours have been met by the Foster Parents
   * in Stage idStage
   * @param idStage
   * @param dtApproved
   * @return
   */
  private String processTrainingHoursMet(Integer idStage, Date dtApproved) {
    
    List<Integer> mapIdPersons = loadStageFosterHomeParents(idStage);
    double trainingHrsRemaining = 0.0;
    String indTrainingHrsComp = ArchitectureConstants.NO;

    for (Integer idPerson : mapIdPersons) {
      trainingHrsRemaining = processTrainingHoursCompleted(idPerson, dtApproved);
      //log.error("* * * * * trainingHrsRemaining = " + trainingHrsRemaining);
      if (trainingHrsRemaining > 0) {
        indTrainingHrsComp = ArchitectureConstants.NO;
        break;
      }
    }
    
    /* STGAP00014962 - if a (converted) home does not have a
     *          principal foster parent (i.e. mapIdPersons is empty)
     *          then this should not report training hours complete
     *          as YES when there are no training hours to complete
     */ 
    if (trainingHrsRemaining == 0 && mapIdPersons.size() > 0) {
      //log.error("* * * * * * trainingHrsRemaining = zero?");
      indTrainingHrsComp = ArchitectureConstants.YES;
    }
    
    return indTrainingHrsComp;
  }
  
  /**
   * This retrieves all the foster parents related to a
   * home in a particular stage.
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  private List<Integer> loadStageFosterHomeParents(Integer idStage) {
    
    // Load all of the parent types into a list
    List<String> cdStagePersTypes = new ArrayList<String>();
    cdStagePersTypes.add("PK");
    cdStagePersTypes.add("FA");
    cdStagePersTypes.add("FP");
    cdStagePersTypes.add("AF");
    List<Map> mapPersons = stagePersonLinkLnchrDAO
                                  .findPersonByIdStageIdPersonCdStagePersTypes(idStage, 
                                                                               cdStagePersTypes);
    List<Integer> mapIdPersons = new ArrayList<Integer>();
    for (Map m : mapPersons) {
      BigDecimal idPerson = (BigDecimal) m.get("idPerson");
      mapIdPersons.add(idPerson.intValue());
    }
    
    return mapIdPersons;
  }
  
  /**
   * This checks to see if a person has completed all required
   * training for the year. Much of this logic is the exact logic
   * from the RetrieveFAHomeMemberTraining service.
   * @param idPerson
   * @param dtApproved
   * @return
   */
  @SuppressWarnings({"unchecked"})
  private Double processTrainingHoursCompleted(Integer idPerson, Date dtApproved) {
    Date currentDate = new Date();
    int currentYear = DateHelper.getYear(currentDate);
    int lastYear = currentYear - 1;
    
    //log.error("- - - idPerson = " + idPerson);
    List<Map> faIndivTrainingList = faIndivTrainingLnchrDAO.findFaIndivTrainingByIdPerson(idPerson);

    int trngHrsCompletedInCurrentYr = 0;
    double trngHrsRemainInCurrentYr = 0;
    int trngHrsRequiredInCurrentYr = 0;
    int trngHrsCompletedInPreviousYr = 0;

    if (dtApproved != null && DateHelper.isSameYear(dtApproved, currentDate)) {
      trngHrsRequiredInCurrentYr = getRequiredTrngHrs(dtApproved);
    } else if (dtApproved != null) {
      // STGAP000010494 - Called the new method to get the required training hours
      trngHrsRequiredInCurrentYr = getRequiredTrngHrs(CodesTables.CFAYRTRN_NA);
    } else {
      trngHrsRequiredInCurrentYr = 0;
    }

    //log.error("* * * trngHrsRequiredInCurrentYr = " + trngHrsRequiredInCurrentYr);
    
    for (Map row : faIndivTrainingList) {
      String trngType = (String) row.get("cdIndivTrnType");
      // STGAP00010494 - Calculate training hours if FA Home is approved. If
      // FA Home is not approved then Training Hours Completed Current Year defaults
      // to 0 and Training Hours Remaining Current year defaults to 0.
      if (dtApproved != null) {

        // STGAP00010494 - Get year and month of FA Home Approval Date
        int faHomeApprovedYear = DateHelper.getYear(dtApproved);
        int faHomeApprovedMonth = DateHelper.getMonth(dtApproved);

        // added to calculate training hrs.

        Date trainingDate = (Date) row.get("dtIndivTrn");

        // STGAP00010495: Changed training hours to a double and used doubleValue to
        // to return the map entry as a double.
        double trainingHours = ((BigDecimal) row.get("nbrIndivTrnHrs")).doubleValue();

        // STGAP00004111: added codes here to make sure we don't add
        // Pre-Cert Pre-Service to total yearly hours
        if (DateHelper.isSameYear(trainingDate, currentDate) && !trngType.equals(CodesTables.CFATRAIN_PRSV)) {
          if (DateHelper.isAfter(trainingDate, dtApproved)) {
            trngHrsCompletedInCurrentYr += trainingHours;
          }
        }

        // STGAP00010494: Get training hours completed in November and December of the previous year
        // Pre-Cert and Pre-Service hours are not added to the total yearly hours
        if ((DateHelper.getYear(trainingDate) == lastYear && faHomeApprovedYear == lastYear)
            && !trngType.equals(CodesTables.CFATRAIN_PRSV)) {
          if (faHomeApprovedMonth == Calendar.NOVEMBER || faHomeApprovedMonth == Calendar.DECEMBER) {
            int trainingMonth = DateHelper.getMonth(trainingDate);
            if (trainingMonth == Calendar.NOVEMBER || trainingMonth == Calendar.DECEMBER) {
              if (DateHelper.isAfter(trainingDate, dtApproved)) {
                trngHrsCompletedInPreviousYr += trainingHours;
              }
            }
          }
        }
      } // End FA Home Approval Date check
      
    }
    //log.error("* trngHrsCompletedInCurrentYr = " + trngHrsCompletedInCurrentYr);
    //log.error("* trngHrsCompletedInPreviousYr = " + trngHrsCompletedInPreviousYr);
    double trngHrsCompleted = trngHrsCompletedInCurrentYr + trngHrsCompletedInPreviousYr;
    trngHrsRemainInCurrentYr = (double) trngHrsRequiredInCurrentYr - trngHrsCompleted;
    if (trngHrsRemainInCurrentYr < 0)
      trngHrsRemainInCurrentYr = 0;

    return trngHrsRemainInCurrentYr;
  }

  /**
   * This method gets the required training hours using the approved date
   * 
   * @param approvedDate
   * @return
   */
  private int getRequiredTrngHrs(Date approvedDate) {

    int approvedMonth;
    String szRequiredTrngHrsCode;
    int requiredTrngHrs = 0;

    if (StringHelper.isNotEmptyOrNull(approvedDate)) {
      // DateHelper uses Calendar.MONTH, which returns zero-based values (i.e. 0=January, 1=February, etc.)
      approvedMonth = DateHelper.getMonth(approvedDate) + 1;
      if (approvedMonth > 9) {
        szRequiredTrngHrsCode = String.valueOf(approvedMonth);
      } else {
        szRequiredTrngHrsCode = "0" + String.valueOf(approvedMonth);
      }

      requiredTrngHrs = getRequiredTrngHrs(szRequiredTrngHrsCode);
    } else {
      requiredTrngHrs = 0;
    }

    return requiredTrngHrs;
  }
  
  /**
   * This method getS the required training hours using the training hours code. The training hours codes are specified
   * in FA /Homes Required Training Hours category (CAYAYRTN) in the CODES_TABLES.
   * 
   * @param szTrngHrsCode
   * @return
   */
  private int getRequiredTrngHrs(String szTrngHrsCode) {

    //String szRequiredTrngHrs = Lookup.simpleDecodeSafe(CodesTables.CFAYRTRN, szTrngHrsCode);
    String szRequiredTrngHrs = launcherDAO.performCodesTablesDecode(CodesTables.CFAYRTRN, szTrngHrsCode);

    if (StringHelper.EMPTY_STRING.equals(szRequiredTrngHrs)) {
      szRequiredTrngHrs = "0";
    }

    return Integer.parseInt(szRequiredTrngHrs);
  }
  
  /**
   * Creating a log file for logging the execution of the process
   * @return
   */
  private File createLogFile() {
    File logFile = null;
    try {
      logFile = File.createTempFile(reportName, ".log", new File(jxlsConfiguration.getLogDir()));
    } catch (IOException e) {
      //log.warn("Failed to create temp file for " + this.toString() + ".", e);
      log.info("Failed to create temp file for " + this.toString() + ".", e);
    }
    return logFile;
  }
  
}
