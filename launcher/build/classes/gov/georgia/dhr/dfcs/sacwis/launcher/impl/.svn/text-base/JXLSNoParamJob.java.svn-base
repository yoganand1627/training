package gov.georgia.dhr.dfcs.sacwis.launcher.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NullHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.ReportLauncher;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.LauncherDAO;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.RptLauncherDAO;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRBaseObject;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRConstants;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRObjectFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class JXLSNoParamJob implements ReportJob {

	private static Log log = LogFactory.getLog(JXLSNoParamJob.class);
	private static String JXLS_FILE_EXT = ".xls";
	private static final String UDR_REPORT = "U";
	private static final String BEAN_TYPE_HEADER = "headerBean";
	private static final String BEAN_TYPE_UDR_BEAN = "udrBean";
	private static final String BEAN_TYPE_ERROR = "errorBean";
	private static final String BEAN_TYPE_INFO = "infoBean";
	private static final String NO_RESULTS_RETURNED = "The input parameters used yielded no results!";
	private static final String OVER_65K_ROWS = "The result exceeded 65000 rows. No data is being displayed.";

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

	private RptLauncherDAO rptLauncherDAO;

	/** The static configuration. */
	private JXLSNoParamConfiguration jxlsNoParamConfiguration = new JXLSNoParamConfiguration();

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
	 * @param userName
	 *            the userName to set (schema)
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * The information loaded from JXLSConfiguration through the
	 * launcher-server-context.xml
	 * 
	 * @param jxslConfiguration
	 */

	public void setJxlsNoParamConfiguration(
			JXLSNoParamConfiguration jxlsNoParamConfiguration) {
		this.jxlsNoParamConfiguration = jxlsNoParamConfiguration;
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

	public void run() {
		File logFile = createLogFile();
		if (logFile == null) {
			// We failed to create the log file; just return;
			return;
		}
		String logFileName = logFile.getName();
		String basename = logFileName.substring(0, logFileName.length() - 4);
		//String errorPath = jxlsNoParamConfiguration.getLogDir() + basename + ERROR_FILE_EXT;
		String outputFileName = basename + JXLS_FILE_EXT;
		String outputFullPathFileName = jxlsNoParamConfiguration.getOutputDir()
				+ File.separator + outputFileName;
		String templateFileName = jxlsNoParamConfiguration.getTemplateDir()
				+ File.separator + reportName + JXLS_FILE_EXT;
		int returnCode = 1000; // single return code used for all sheets

		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			// Create header information bean, then add it to the data map
			DynaBean headerBean = createAndPopulateHeaderBean();
			dataMap.put("header", headerBean);
			
			UDRBaseObject udr = createUdrObject();
			Set<String> sqlNameList = udr.getSqlRefMapList().keySet();;

			if (sqlNameList != null && !sqlNameList.isEmpty()) {
				for (String each : sqlNameList) {
					int errorCode = 0;
					List<Object> jXLSData = new ArrayList<Object>();
					String[] sqlParama = null; // This report has no parameter
					String sql = createSQLString(sqlParama, each, udr);//createCountSQLString(sqlParama, each, udr);
					if (sql != null) {
						log.debug("Executing SQL: " + sql);
						log.info("Executing SQL: " + each);
						jXLSData = populateJXLSData(sql, sqlParama,
								outputFileName, errorCode);// pass errorCode = 0; it's overwritten if error
						log.info("" + each + " executed. \n");
						if (errorCode == UDRConstants.EXCEL_MAX_FILE_SIZE) {
							DynaBean errorBean = createAndPopulateErrorMessageBean(OVER_65K_ROWS);
							dataMap.put("error_" + each, errorBean);
							log
							.warn("This query returned more than 65000 Rows. Only 65000 rows will be displayed.");
						}
						/*if (!NullHelper.isEmptyOrNull(jXLSData)) {
							if (jXLSData.size() > UDRConstants.EXCEL_MAX_FILE_SIZE) {
								log
										.warn("Results from jXLS query returned more than 65000 Rows!\n"
												+ "Report "
												+ outputFileName
												+ " for user ID "
												+ idPerson
												+ " at "
												+ new Date()
												+ " will be empty.");
								// Get a Blank Row SQL and substitute the nulls
								// as blanks to the Excel spread to
								// not to display the variable names when
								// throwing 65 K Rows error
								Map<String, Object> blankRow = UDRConstants.DEFAULT_BLANK_ROW;
								jXLSData = populateBalnkJXLSData(blankRow);

								DynaBean errorBean = createAndPopulateErrorMessageBean(OVER_65K_ROWS);
								dataMap.put("error_" + each, errorBean);
							}
						}*/
					}

					// add the pojos to the map
					dataMap.put(each, jXLSData);
					log.info("Added jXLSData " + each + " to dataMap");
					// add sql string to the map
					DynaBean sqlStringBean = createAndPopulateSqlStringBean(each, sql);
					dataMap.put("sql_" + each, sqlStringBean);
					log.info("Added sql string " + each + " to dataMap");

					if (jXLSData.isEmpty()) {
						log.warn("Result from " + each + " query were empty!");
						DynaBean errorBean = createAndPopulateErrorMessageBean(NO_RESULTS_RETURNED);
						dataMap.put("error_" + each, errorBean);

					}
				} // end looping sqlList
			} // end if sqlList is not null
			
			if (dataMap.isEmpty()) {// it will not be null at this point
				log.warn("Results from all queries were empty!\n");
			}

			// perform transformation
			XLSTransformer transformer = new XLSTransformer();
			log.info("Transforming ...");
			transformer.transformXLS(templateFileName, dataMap,
					outputFullPathFileName);
			returnCode = 0;
		} catch (Throwable t) {
			log.error("Failed to generate report " + outputFileName + " on " + new Date());
			t.printStackTrace();
		}

		String status = returnCode == 0 ? ReportLauncher.REPORT_STATUS_DONE
				: ReportLauncher.REPORT_STATUS_ERR;
		int newReportId = 0;
		
		if (ReportLauncher.REPORT_STATUS_DONE.equals(status)) {
			HSSFWorkbook workbook = null;
			FileOutputStream fileOut = null;
			FileInputStream fileIn = null;

			try {
				fileIn = new FileInputStream(outputFullPathFileName);
				workbook = new HSSFWorkbook(fileIn);
				HSSFSheet summarySheet = workbook.getSheet("Summary");
				summarySheet.setForceFormulaRecalculation(true);
				summarySheet.setActive(true);
				
				fileOut = new FileOutputStream(outputFullPathFileName);
				workbook.write(fileOut);
				fileOut.close();
				fileIn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// It is ok if there was problem reading or writing to the page because the purpose of this block to just
				// force recalculate the Summary sheet. Excel would recalculate the book when dirty cells detected anyway.
				e.printStackTrace();   
			} 
		}
		Date retainageDate = DateHelper.MAX_JAVA_DATE;// set this so it won't be purged by purge batch schedule
		if (ReportLauncher.REPORT_STATUS_DONE.equals(status)) {
			newReportId = launcherDAO.insertReportListStatus(reportName, reportVersion, retainageDate, status, outputFileName, UDR_REPORT);
			if (newReportId > 0) {
			// remove current copy of this report when new one generated successfully and inserted to the list
			launcherDAO.deleteAllOthersReportList(newReportId, reportName);
			}
		}
	}

	private UDRBaseObject createUdrObject() {
		return UDRObjectFactory.createUDRObject(reportName);
	}

	private String createSQLString(String[] params, String sql,
			UDRBaseObject udr) {

		String sqlString = "";

		if (StringHelper.isNotEmptyOrNull(udr)
				&& StringHelper.isNotEmptyOrNull(sql)) {
			sqlString = udr.buildSQLQueryMultiple(params, sql);
		}

		return sqlString;
	}

	private String createCountSQLString(String[] params, String sql,
			UDRBaseObject udr) {

		String sqlString = "";

		if (StringHelper.isNotEmptyOrNull(udr)
				&& StringHelper.isNotEmptyOrNull(sql)) {
			sqlString = udr.queryForRowCountMultiple(params, sql);
		}

		return sqlString;
	}


	/**
	 * Creates a new dynamic bean class based on the data map passed in and uses
	 * className to reference the bean type
	 * 
	 * @param dataMap
	 * @param className
	 * @return
	 */
	private static Object createDynaBeanClass(Map<String, Object> dataMap,
			String className) {
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
	 * 
	 * @param dynaClass
	 * @return
	 */
	private static DynaBean createDynaBeanInstance(DynaClass dynaClass) {
		DynaBean dynaBean = null;
		try {
			dynaBean = dynaClass.newInstance();
		} catch (IllegalAccessException iae) {
			log.error("Error creating DynaBean instance " + dynaClass.getName()
					+ " -- IllegalAccessException");
			throw new ServiceException();
		} catch (InstantiationException ie) {
			log.error("Error creating DynaBean instance " + dynaClass.getName()
					+ " -- InstantiationException");
			throw new ServiceException();
		}
		return dynaBean;

	}

	/**
	 * Populates a bean with data
	 * 
	 * @param bean
	 * @param dataMap
	 * @param beanType
	 *            TODO
	 */
	private void populateDynaBean(DynaBean bean, Map<String, Object> dataMap,
			String beanType) {

		Set<String> keys = dataMap.keySet();
		DynaClass dynaClass = bean.getDynaClass();

		// validate that the bean object can
		// be used with the data map
		for (String key : keys) {
			DynaProperty p = dynaClass.getDynaProperty(key);
			if (p == null) {
				// log.error(key + " is not a property of this dynabean class.
				// Verify correct bean description is being sent with the
				// correct data map.");
				log
						.info(key
								+ " is not a property of this dynabean class. Verify correct bean description is being sent with the correct data map.");
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
	 * Create a DynaBean for displaying header information on the User Defined
	 * Report and then populate that bean with the current data.
	 * 
	 */
	private DynaBean createAndPopulateHeaderBean() {

		Map<String, Object> headerDataMap = new HashMap<String, Object>();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		headerDataMap.put("producedDate", df.format(new Date()));
		DynaClass headerClass = (DynaClass) createDynaBeanClass(headerDataMap,
				BEAN_TYPE_HEADER);
		DynaBean headerBean = createDynaBeanInstance(headerClass);
		populateDynaBean(headerBean, headerDataMap, BEAN_TYPE_HEADER);
		return headerBean;
	}

	/**
	 * Create a DynaBean for displaying error information on the User Defined
	 * Report.
	 * 
	 * @param params
	 * @return
	 */
	private DynaBean createAndPopulateErrorMessageBean(String message) {

		Map<String, Object> errorDataMap = new HashMap<String, Object>();
		errorDataMap.put("message", message);

		DynaClass errorClass = (DynaClass) createDynaBeanClass(errorDataMap,
				BEAN_TYPE_ERROR);
		DynaBean errorBean = createDynaBeanInstance(errorClass);
		populateDynaBean(errorBean, errorDataMap, null);

		return errorBean;
	}
	
	private DynaBean createAndPopulateSqlStringBean(String sqlName, String sqlString) {

		Map<String, Object> infoDataMap = new HashMap<String, Object>();
		infoDataMap.put("sqlName", sqlName);
		infoDataMap.put("sqlString", sqlString);

		DynaClass infoClass = (DynaClass) createDynaBeanClass(infoDataMap,
				BEAN_TYPE_INFO);
		DynaBean infoBean = createDynaBeanInstance(infoClass);
		populateDynaBean(infoBean, infoDataMap, null);

		return infoBean;
	}

	private List<Object> populateBalnkJXLSData(
			Map<String, Object> blankResultMap) {

		List<Object> jXLSData = new ArrayList<Object>();

		long startDynaBeanTime = Calendar.getInstance().getTimeInMillis();
		// Get the first result and use the map to create a dynamic bean
		// class
		// All of the maps in the result will have the same property names.
		Map<String, Object> propertiesMap = blankResultMap != null ? blankResultMap
				: new HashMap<String, Object>();

		DynaClass dynaClass = (DynaClass) createDynaBeanClass(propertiesMap,
				BEAN_TYPE_UDR_BEAN);

		// for each result, create an instance of the dynamic bean class
		// and populate that instance. Add to the jXLS Data list
		DynaBean bean = (DynaBean) createDynaBeanInstance(dynaClass);
		populateDynaBean(bean, blankResultMap, BEAN_TYPE_UDR_BEAN);
		jXLSData.add(bean);

		long endDynaBeanTime = Calendar.getInstance().getTimeInMillis();
		long totalDynaBeanTime = endDynaBeanTime - startDynaBeanTime;
		log.info("Data Bean population " + " time = " + totalDynaBeanTime + " ms");

		return jXLSData;
	}
	/**
	 * 
	 * @param sql
	 * @param sqlParamArray
	 * @param outputFileName
	 * @return empty list if no rows returned; list of rows otherwise
	 */

	private List<Object> populateJXLSData(String sql, String[] sqlParamArray,
			String outputFileName, int errCode) {
		List<Object> jXLSData = new ArrayList<Object>();

		// call out to LauncherDAO to get results
		long startQueryTime = Calendar.getInstance().getTimeInMillis();
		List<Map<String, Object>> result = rptLauncherDAO.performJXLSQuery(sql,
				null);
		// Quick modification - should recode
		if (!NullHelper.isEmptyOrNull(result) && result.size() >= UDRConstants.EXCEL_MAX_FILE_SIZE) {
			result.subList(UDRConstants.EXCEL_MAX_FILE_SIZE -100, result.size()).clear();
			errCode = UDRConstants.EXCEL_MAX_FILE_SIZE;
		}
		long endQueryTime = Calendar.getInstance().getTimeInMillis();
		long totalQueryTime = endQueryTime - startQueryTime;
		log.info("jXLS Query Time = " + totalQueryTime + " ms");
		// transform results to pojo
		long startDynaBeanTime = Calendar.getInstance().getTimeInMillis();
		if (!NullHelper.isEmptyOrNull(result) && result.size() < UDRConstants.EXCEL_MAX_FILE_SIZE) {
			// Get the first result and use the map to create a dynamic bean
			// class
			// All of the maps in the result will have the same property names.
			Map<String, Object> propertiesMap = result.get(0);

			DynaClass dynaClass = (DynaClass) createDynaBeanClass(
					propertiesMap, BEAN_TYPE_UDR_BEAN);

			// for each result, create an instance of the dynamic bean class
			// and populate that instance. Add to the jXLS Data list
			for (Map<String, Object> map : result) {
				DynaBean bean = (DynaBean) createDynaBeanInstance(dynaClass);
				populateDynaBean(bean, map, BEAN_TYPE_UDR_BEAN);
				jXLSData.add(bean);
			}
			long endDynaBeanTime = Calendar.getInstance().getTimeInMillis();
			long totalDynaBeanTime = endDynaBeanTime - startDynaBeanTime;
			log
					.info("Data Bean population time = " + totalDynaBeanTime
							+ " ms");
		} // else { return empty List }

		return jXLSData;
	}

	/**
	 * Creating a log file for logging the execution of the process
	 * 
	 * @return
	 */
	private File createLogFile() {
		File logFile = null;
		try {
			logFile = File.createTempFile(reportName, ".log", new File(
					jxlsNoParamConfiguration.getLogDir()));
		} catch (IOException e) {
			// log.warn("Failed to create temp file for " + this.toString() +
			// ".", e);
			log.info("Failed to create temp file for " + this.toString() + ".",
					e);
		}
		return logFile;
	}

}
