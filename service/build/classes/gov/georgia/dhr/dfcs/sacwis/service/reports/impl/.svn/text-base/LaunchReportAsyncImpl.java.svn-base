package gov.georgia.dhr.dfcs.sacwis.service.reports.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ReportListDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ReportParameterDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ReportsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ReportList;
import gov.georgia.dhr.dfcs.sacwis.db.ReportParameter;
import gov.georgia.dhr.dfcs.sacwis.db.Reports;
import gov.georgia.dhr.dfcs.sacwis.db.ReportsId;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.launcher.ReportLauncher;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRObjectFactory;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.reports.LaunchReportAsync;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class LaunchReportAsyncImpl extends BaseServiceImpl implements LaunchReportAsync {

  public static final int ARC_UTL_NO_SERVER = 3;
  public static final int ARC_UTL_CREATE_FAIL = 4;
  public static final int ARC_UTL_WRITE_FAIL = 6;
  
  private CapsCaseDAO capsCaseDAO = null;
  private ReportParameterDAO reportParameterDAO = null;
  private ReportsDAO reportsDAO = null;
  private ReportListDAO reportListDAO = null;
  private StageDAO stageDAO = null;
  
  /** Special field used to launch the report asynchronously over RMI (usually -- see reports-context.xml). */
  private ReportLauncher reportLauncher = null;

  private static final String INTEGER_PARAM = "INTEGER";
  private static final String NUMBER_PARAM = "NUMBER";
  private static final String DATE_PARAM = "DATE";
  private static final String CASEID = "CASEID";
  private static final int CASEID_VAL = 1;
  private static final String STAGEID = "STAGEID";
  private static final int STAGEID_VAL = 2;
  private static final Pattern NUMBER_PATTERN = Pattern.compile("[\\d,. +\\-]*");
  
  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setReportParameterDAO(ReportParameterDAO reportParameterDAO) {
    this.reportParameterDAO = reportParameterDAO;
  }

  public void setReportsDAO(ReportsDAO reportsDAO) {
    this.reportsDAO = reportsDAO;
  }

  public void setReportListDAO(ReportListDAO reportListDAO) {
    this.reportListDAO = reportListDAO;
  }

  public void setReportLauncher(ReportLauncher reportLauncher) {
    this.reportLauncher = reportLauncher;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  /**
   * The saveReportList method saves a pending record to the REPORT_LIST table.
   * 
   * @param CARC07SI
   *          Input object which contains report name and parameters
   * @return int REPORT_LIST Primary Key
   */
  public int saveReportList(CARC07SI carc07si) throws ServiceException {

    String nmRptSqrName = carc07si.getSzNmRptSqrName();
    String nmRptSqrVer = carc07si.getSzNmRptSqrVer();
    String pszTxtRptParmList = carc07si.getTxtRptParmList();
    
    //STGAP00013472: Unauthorized access to Sensitive Cases through Reports should be denied
    String szIndCaseSensitiveForUser = carc07si.getSzIndCaseSensitive();
    ReportParameter reportParameter = null;
    /*List<Map<String, ReportParameter>> reportMap = new ArrayList<Map<String, ReportParameter>>();
    HashMap<String, ReportParameter> reportMap = new HashMap<String, ReportParameter>();
    Map<String, ReportParameter> rprtParm =  new HashMap<String, ReportParameter>();*/
    int rptParamFlag = 0;
    ReportParameter reportParameterCaseId = reportParameterDAO.findNbrRptParmSeq(nmRptSqrName, CASEID, nmRptSqrVer);
    if (reportParameterCaseId != null){
      rptParamFlag = CASEID_VAL;
      reportParameter = reportParameterCaseId;
    }
    ReportParameter reportParameterStageId = reportParameterDAO.findNbrRptParmSeq(nmRptSqrName, STAGEID, nmRptSqrVer);
    if (reportParameterStageId != null){
      rptParamFlag = STAGEID_VAL;
      reportParameter = reportParameterStageId;
    }
    if (reportParameter != null){
      //Get the Case ID sequence Number
      Integer caseIdSequenceNum = reportParameter.getNbrRptParmSeq();
      // Split the parameters on the ^ character; note that the string should always end with such a character,
      // but the split method will ignore the trailing empty string.
      String[] params = pszTxtRptParmList.split("\\^");
      //Locate the CASE ID in the txtRptParmList string. Used '--' as the values stored
      //in database Report Parameter table starts from 1 whereas the Java String Array
      //starts from 0.
      Integer caseOrStageIdFromParamList = 0;
      try{
        caseOrStageIdFromParamList = caseIdSequenceNum!=null?StringHelper.toInteger(params[--caseIdSequenceNum]):0;
      }catch (NumberFormatException nfe){
        throw new ServiceException(Messages.MSG_REPORT_PARM_INVALID);
      }
      //Check Caps Case Table whether the Case ID is sensitive.
      CapsCase capsCase = null;
      String indCaseSensitive = "";
      switch(rptParamFlag){
      case CASEID_VAL:
        capsCase = capsCaseDAO.findCapsCaseByIdCase(caseOrStageIdFromParamList);
        if (capsCase != null){
          indCaseSensitive = capsCase.getIndCaseSensitive();
        }
        break;
      case STAGEID_VAL:
        Stage stage = stageDAO.findStageAndCapsCase(caseOrStageIdFromParamList);
        if (stage != null){
          indCaseSensitive = stage.getCapsCase().getIndCaseSensitive();
        }
        break;
      }
      if ((ArchitectureConstants.Y.equalsIgnoreCase(indCaseSensitive) && 
                      !ArchitectureConstants.Y.equalsIgnoreCase(szIndCaseSensitiveForUser))){
        throw new ServiceException(Messages.MSG_CMN_SENSITIVE_CASE);
      }

    }
    // clss00d
    // SWR - commented out validation until we determine what to do with 
    // optional parameters
    //verifyReportParameters(nmRptSqrName, nmRptSqrVer, pszTxtRptParmList);

    // cses12d
    Reports report = reportsDAO.findReport(nmRptSqrName, nmRptSqrVer);
    if (report == null) {
      throw new ServiceException(Messages.MSG_NO_REPORT_INFO_FOUND);
    }
    
    int idReportList = saveReportList(carc07si,REPORT_STATUS_PENDING, report.getNbrRptRetainage());
    
    return idReportList;
  }

  /**
   * The saveReportList method saves a pending record to the REPORT_LIST table.
   * 
   * @param int REPORT_LIST Primary Key
   * @param CARC07SI
   *          Input object which contains report name and parameters
   * @return void
   */  
  public void launchReportAsync (int idReportList, CARC07SI carc07si) throws ServiceException {
    
	  reportLauncher.generateReport(idReportList, carc07si);
  }
  
  public void launchBatchReportAsync (CARC07SI carc07si) throws ServiceException {
	    
	    	reportLauncher.generateBatchReport(carc07si);
  }
  
  private void verifyReportParameters(String nmRptSqrName, String nmRptSqrVer, String pszTxtRptParmList)
          throws ServiceException {
    // Obtain and validate the report parameter info from DB against the parameters
    //   in the service input message parm list string.
    // clss00d
    List<ReportParameter> reportParameterList = reportParameterDAO.findReportParameter(nmRptSqrName, nmRptSqrVer);
    if (reportParameterList == null || reportParameterList.isEmpty()) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    // Split the parameters on the ^ character; note that the string should always end with such a character,
    //   but the split method will ignore the trailing empty string.
    String[] params = pszTxtRptParmList.split("\\^");
    // If we do not have the right number of parameters, throw an exception immediately
    if (params.length != reportParameterList.size()) {
      throw new ServiceException(Messages.MSG_REPORT_PARM_INVALID);
    }

    int i = 0;
    // Loop through each report parmeter in TxtRptParmList and verify against expected values from DB.
    for (Iterator<ReportParameter> it = reportParameterList.iterator(); it.hasNext();) {
      ReportParameter reportParameter = it.next();
      String param = params[i++];
      // Validate that the SQR parameter length is not greater than the maximum specified in DB.
      int paramSize = param.length();
      // If there are at least 2 characters, strip opitonal leading and trailing apostrophes.
      if (paramSize > 1 && '\'' == param.charAt(0) && '\'' == param.charAt(paramSize - 1)) {
        paramSize -= 2;
        param = param.substring(1, 1 + paramSize);
      }

      // Validate that the SQR parameter type is of correct type as specified in DB.
      //   Set bInvalidSqrParm boolean var appropriately.
      if (paramSize > reportParameter.getNbrRptParmLength()) {
        throw new ServiceException(Messages.MSG_REPORT_PARM_INVALID);
      }
      String paramType = reportParameter.getTxtRptParmType();
      if (INTEGER_PARAM.equals(paramType) || NUMBER_PARAM.equals(paramType)) {
        if (!NUMBER_PATTERN.matcher(param).find()) {
          throw new ServiceException(Messages.MSG_REPORT_PARM_INVALID);
        }
      } else if (DATE_PARAM.equals(paramType)) {
        // If the date string is empty, (2 single quotes, which were stripped above), the date string is valid.
        if (paramType.trim().length() > 0 && !DateHelper.isValidDate(param)) {
          throw new ServiceException(Messages.MSG_REPORT_PARM_INVALID);
        }
      }
    }
  }

  private int saveReportList(CARC07SI carc07si, String status, int retainageDays) {
    ReportList reportList = new ReportList();
    int ulRptLstCfpStamp = carc07si.getUlRptLstCfpStamp();
    if (ulRptLstCfpStamp != 0) {
      reportList.setNbrRptLstCfpStamp(ulRptLstCfpStamp);
    }
    reportList.setReports(getPersistentObject(Reports.class, new ReportsId(carc07si.getSzNmRptSqrName(),
                                                                           carc07si.getSzNmRptSqrVer())));
    reportList.setTxtRptLstParmlist(carc07si.getTxtRptParmList());
    reportList.setTxtRptLstRuntimeName(carc07si.getSzTxtEmailMessage());
    reportList.setTxtRptLstStatus(status);
    reportList.setPerson(getPersistentObject(Person.class, carc07si.getUlIdPerson()));
    // Set the generation date to now.
    Date now = new Date();
    reportList.setDtRptLstGeneration(now);
    // Use an empty string for the report name so we do not store null
    reportList.setTxtRptGenName("");
    Calendar retainageCal = Calendar.getInstance();
    retainageCal.add(Calendar.DAY_OF_MONTH, retainageDays);
    reportList.setDtRptLstRetainage(retainageCal.getTime());
    // cauda2d
    reportListDAO.saveReportList(reportList);
    return reportList.getIdRptList();
  }
}
