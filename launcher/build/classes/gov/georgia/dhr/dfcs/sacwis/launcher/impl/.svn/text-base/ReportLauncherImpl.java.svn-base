/**
 * Created on Dec 18, 2006 at 4:41:25 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.launcher.impl;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.ReportLauncher;
import gov.georgia.dhr.dfcs.sacwis.launcher.dao.LauncherDAO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.task.TaskExecutor;

/**
 * This Report Launcher class exists solely to accept report requests and
 * forward them to report jobs. It relies on a {@link TaskExecutor} to execute
 * the jobs. <p/> Currently, the only report type is SQR (and this is likely to
 * stay the same), but this class is designed to accept different report types
 * in the future.
 */
public abstract class ReportLauncherImpl implements ReportLauncher {

	private static final Log log = LogFactory.getLog(ReportLauncherImpl.class);

	private File outputDir;

	private File xlsOutputDir;

	private TaskExecutor taskExecutor;

	private LauncherDAO launcherDAO;

	private static final int MAX_FILE_SIZE_IN_MB = Integer.MAX_VALUE
			/ (1024 * 1024);

	private static final String UDR_REPORT = "U";

	/**
	 * @param launcherDAO
	 *            the launcherDAO to set
	 */
	public void setLauncherDAO(LauncherDAO launcherDAO) {
		this.launcherDAO = launcherDAO;
	}

	/**
	 * Set up the output directory. This is set up through the config file
	 * launcher-context.xml
	 * 
	 * @param outputDir
	 */
	public void setOutputDir(File outputDir) {
		if (!outputDir.isDirectory()) {
			throw new IllegalStateException(
					"Output dir does not exist or is not a directory: "
							+ outputDir.getAbsolutePath());
		}
		this.outputDir = outputDir;
	}

	/**
	 * Set up the xls output directory. This is set up through the config file
	 * launcher-context.xml
	 * 
	 * @param outputDir
	 */
	public void setXlsOutputDir(File xlsOutputDir) {
		if (!xlsOutputDir.isDirectory()) {
			throw new IllegalStateException(
					"xls output dir does not exist or is not a directory: "
							+ xlsOutputDir.getAbsolutePath());
		}
		this.xlsOutputDir = xlsOutputDir;
	}

	/**
	 * Set up the taskExecutor that asynchronously process/executes the
	 * ReportJobs. This is set up through the config file launcher-context.xml
	 * 
	 * @param taskExecutor
	 */
	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	/**
	 * This abstract method is automatically implemented by Spring with a method
	 * that finds the ReportJob bean. The wiring to the implementation is done
	 * through the property in launcher-server-context.xml <lookup-method
	 * name="createReportJob" bean="sqrJob"/>
	 * 
	 * @return
	 */
	protected abstract ReportJob createReportJob();

	/**
	 * This abstract method is automatically implemented by Spring with a method
	 * that finds the JXLSJob bean. The wiring to the implementation is done
	 * through the property in launcher-server-context.xml <lookup-method
	 * name="createJXLSJob" bean="jxlsJob"/>
	 * 
	 * @return
	 */
	protected abstract ReportJob createJXLSJob();

	protected abstract ReportJob createJXLSNoParamJob();

	/**
	 * This method is called by spring batch
	 * @param carc07si
	 */
	public void generateBatchReport(CARC07SI carc07si) {
		
		ReportJob job = createJXLSNoParamJob();
		
		job.setReportName(carc07si.getSzNmRptSqrName());
		job.setReportVersion(carc07si.getSzNmRptSqrVer());
		
		taskExecutor.execute(job);
	}

  /**
   * Implemented method of ReportLauncher to generate the report. This is the first method that the remote caller will
   * call to generate a report after it attains the instance of class of this type: ReportLauncher. Though it is usually
   * done asynchronously, there is no guarantee that it will be done that way.
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.service.reports.impl.LaunchReportAsyncImpl#launchReportAsync(int, CARC07SI)
   * 
   * @param idReportList
   * @param carc07si
   */
  public void generateReport(int idReportList, CARC07SI carc07si) {

    ReportJob job = null;

    if (UDR_REPORT.equals(carc07si.getSzTxtNmRptType())) {
      job = createJXLSJob();
    } else {
      job = createReportJob();
    }

    job.setReportName(carc07si.getSzNmRptSqrName());
    job.setReportVersion(carc07si.getSzNmRptSqrVer());
    job.setIdPerson(carc07si.getUlIdPerson());
    job.setNmPerson(carc07si.getSzNmPersonFull());
    job.setIdReport(idReportList);
    job.setReportParams(carc07si.getTxtRptParmList());
    // Used for training environment to switch between the schemas for the given user
    // Username field contains the schema name
    job.setUserName(carc07si.getSzUsername());
    taskExecutor.execute(job);
  }

	/**
	 * Implemented method of ReportLauncher to retrieve the report. This method
	 * is called by remote caller to retrieve the report after it attains the
	 * instance of class of this type: ReportLauncher.
	 * 
	 * @see gov.georgia.dhr.dfcs.sacwis.service.reports.impl.RetrieveReportImpl#retrieveReport(gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveReportSI)
	 * 
	 */
	public byte[] retreieveReport(String filename, String type) {
		File reportFile = UDR_REPORT.equals(type) ? new File(xlsOutputDir,
				filename) : new File(outputDir, filename);
		if (!reportFile.isFile()) {
			throw new RuntimeException(Messages.MSG_REPORT + "\" " + filename
					+ "\" " + Messages.MSG_RPT_NOT_EXIST);
		}
		long fileSize = reportFile.length();
		if (fileSize > Integer.MAX_VALUE) {
			throw new RuntimeException(Messages.MSG_REPORT + "\" " + filename
					+ "\" " + Messages.MSG_RPT_EXC_SIZE + MAX_FILE_SIZE_IN_MB
					+ Messages.MSG_RPT_MB);
		}
		FileInputStream is = null;
		try {
			is = new FileInputStream(reportFile);
			byte[] bytes = new byte[(int) fileSize];
			// noinspection ResultOfMethodCallIgnored
			is.read(bytes);
			return bytes;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(Messages.MSG_REPORT + " \"" + reportFile
					+ "\" " + Messages.MSG_RPT_NOT_EXIST, e);
		} catch (IOException e) {
			throw new RuntimeException(Messages.MSG_REPORT + " \"" + reportFile
					+ "\" " + Messages.MSG_RPT_NOT_READ, e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.warn("Failed to close input stream for report: "
							+ filename, e);
				}
			}
		}
	}

	/**
	 * Implemented method of ReportLauncher that runs/executes all the reports
	 * that are currently in the "Pend" status. This method internally retrieves
	 * the list of reports from the REPORT_LIST table.
	 * 
	 * gov.georgia.dhr.dfcs.sacwis.launcher.main.ReportLauncherMain
	 * 
	 */
	public void runPendingReports() {
		List<Map<String, Object>> list = getPendingReportList();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {

			Map map = (Map) iter.next();
			ReportJob job = null;
			if (UDR_REPORT.equals((String) map.get("NM_RPT_TYPE"))) {
				job = createJXLSJob();
			} else {
				job = createReportJob();
			}
			job.setReportName((String) map.get("NM_RPT_SQR_NAME"));
			job.setReportVersion((String) map.get("NM_RPT_SQR_VER"));
			BigDecimal idPerson = (BigDecimal) map.get("ID_PERSON");
			if (idPerson != null)
				job.setIdPerson(idPerson.intValueExact());
			BigDecimal idRptList = (BigDecimal) map.get("ID_RPT_LIST");
			if (idRptList != null)
				job.setIdReport(idRptList.intValueExact());
			job.setReportParams((String) map.get("TXT_RPT_LST_PARMLIST"));
			taskExecutor.execute(job);
		}
	}

	/**
	 * Queries the database with the help of LauncherDAO to find the SQRJobs
	 * that have a "Pend" status.
	 * 
	 * gov.georgia.dhr.dfcs.sacwis.launcher.main.ReportLauncherMain
	 * 
	 * @return
	 */
	private List<Map<String, Object>> getPendingReportList() {
		List<Map<String, Object>> pendingReportList;
		pendingReportList = launcherDAO.getPendingReportList();
		return pendingReportList;
	}

}
