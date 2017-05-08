package gov.georgia.dhr.dfcs.sacwis.web.reports;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.spring.UsernameContextHolder;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.UDRObjectFactory;
import gov.georgia.dhr.dfcs.sacwis.service.reports.LaunchReportAsync;
import gov.georgia.dhr.dfcs.sacwis.service.reports.Reports;
import gov.georgia.dhr.dfcs.sacwis.service.reports.RetrieveReport;
import gov.georgia.dhr.dfcs.sacwis.service.reports.RetrieveReportParmlist;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveReportSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportPageSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportSO;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

@SuppressWarnings("serial")
public class ReportsConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "ReportsConversation";
  public static final String MSG_REPORT_GENERATING =
          "Your report is being generated. If you wish to see all available reports, check the Reports tab.";

  public static final String MSG_INCORRECT_INPUTS = "The inputs to the report were incorrect: ";
  public static final String REPORT_STATUS_ERR = LaunchReportAsync.REPORT_STATUS_ERR;
  public static final String MSG_SUCCESS_REFRESH = "Your report is being generated.  Click the 'Report Pick Up' page to view updated status.";

  public static final String REPORT_STATUS_DONE = LaunchReportAsync.REPORT_STATUS_DONE;
  public static final String REPORT_STATUS_PENDING = LaunchReportAsync.REPORT_STATUS_PENDING;
  public static final String REPORT_STATUS_RUNNING = LaunchReportAsync.REPORT_STATUS_RUNNING;
  public static final String IND_RPT_RTRV_TYP = "Y";

  public static final String REPORT_ERROR_MESSAGE = "reportErrorMessage";

  public static final String REPORT_PARAM_NM_PERSON_FULL = "szNmPersonFull";
  
  private static final int RESULTS_PER_PAGE = 20;
  protected static final String STAFF_LIST_PULLBACK_INFO = StaffSearchInput.PULL_BACK_KEY;
  public static final String URL_STAFF_LIST = StaffSearchInput.STAFF_SEARCH_URL;
  public static final String REPORT_STAFF_SEARCH_DB = "ReportStaffSearchDB";
  
  public static final String RELATIVE_RESOURCE_RPRT_SQR_NAME = "RelativeResourceList";
  public static final String NON_PLACEMENT_RELATIVE_RESOURCE_RPRT_SQR_NAME = "NonPlacementRelativeResourceList";
  public static final String FACILITY_LIST_RPRT_SQR_NAME = "FacilityList";
  public static final String PROVIDER_LIST_RPRT_SQR_NAME = "ProviderList";
  public static final String HOME_LIST_RPRT_SQR_NAME = "HomeFacilityList"; // Home/Facility List is split into Home List (used existing file) and Facility List (created new).
  // SMS #54117: Condition for Diversion Activity dropdown
  public static final String DIV_ACT_CASE_STAT_SQR_NAME = "DiversionActivity";
  public static final String CASE_WO_FTM_SQR_NAME = "CasesWithoutFamilyTeamMeeting";
  public static final String FTM_WO_PARENT_PARTICIPATION_RPT_SQR_NAME = "FTMWithoutParentalParticipation";
  public static final String EDUCATION_DETAIL_RPT_SQR_NAME = "EducationDetail";
  
  public static final Map<String, String> BATCH_REPORTS = new HashMap<String, String>(UDRObjectFactory.BATCH_REPORTS);

  /** String TRAINING_PASSWORD CHECK */
  public static final String TRNG_ENV =
          "true".equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                     "perUserSchemaSupport")) ? "true" : "false";
  private Reports reports;
  
  private RetrieveReport retrieveReport;

  public void setReports(Reports reports) {
    this.reports = reports;
  }
  
  public void setRetrieveReport(RetrieveReport retrieveReport){
	  this.retrieveReport = retrieveReport;
  }
  
  private RetrieveReportParmlist retrieveReportParmList;

  public void setRetrieveReportParmlist(RetrieveReportParmlist retrieveReportParmList) {
    this.retrieveReportParmList = retrieveReportParmList;
  }

  /**
   * This method will check the input parameters to the Report Generate service, to avoid errors down the line.
   *
   * @param parameterList String
   * @param sqrName       String
   * @param sqrVer        String
   */
  protected void checkParameterCount(String parameterList, String sqrName, String sqrVer)
          throws InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".checkParameterCount()");
    String rptName = sqrName + sqrVer;
    int actualCount;
    try {
      StringTokenizer strtok = new StringTokenizer(parameterList, "^");
      actualCount = strtok.countTokens();
    } catch (NullPointerException e) {
      actualCount = 0;
    }
    int idealCount;
    try {
      idealCount = ReportsLookup.getParameterCount(rptName);
    } catch (Exception e) {
      String s = "Report \'" + rptName + "\' does not exist in the reports lookup " + " table.";
      GrndsTrace.msg(TRACE_TAG + ".checkParameterCount()", 7, s);
      throw new InformationalPrsException(s, e, BasePrsException.CRITICAL_PRIORITY);
    }

    if (actualCount != idealCount) {
      String s = "Report '" + rptName + "' has the wrong number of parameters. It has " + actualCount +
                 " when it should have " + idealCount + ".";
      GrndsTrace.msg(TRACE_TAG + ".checkParameterCount()", 7, s);
      throw new InformationalPrsException(s, BasePrsException.CRITICAL_PRIORITY);
    }
    GrndsTrace.exitScope();
  }

  /**
   * This method will add the hidden parameters to the Report Generate service inputs.
   *
   * @param txtRptParmList String
   * @param context        The GrndsExchangeContext object.
   */
  private String addHiddenParameters(String txtRptParmList, GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".addHiddenParameter");
    String s = txtRptParmList;
    String hiddenReportParameters = ContextHelper.getStringSafe(context, ReportListTag.HIDDEN_PARAMETERS);

    if (!"".equals(hiddenReportParameters)) {
      StringTokenizer strtok = new StringTokenizer(hiddenReportParameters, ";");

      // go through the list of name,val;name,val sets, discarding the names
      // and appending the vals together
      while (strtok.hasMoreTokens()) {
        String innerToken = strtok.nextToken();
        StringTokenizer innerStrTok = new StringTokenizer(innerToken, ",");
        if (innerStrTok.hasMoreTokens()) {
          innerStrTok.nextToken(); //discard the name
        }
        if (innerStrTok.hasMoreTokens()) {
          String parmValue = innerStrTok.nextToken();
          s += parmValue + "^";
        } else {
          s += " ^";
        }
      }
      if ((s.lastIndexOf("^") != s.length() - 1) &&
          !"".equals(s)) {
        s += "^";
      }
    }
    GrndsTrace.msg(TRACE_TAG + ".addHiddenParamters()", 7, "hiddenParms = " + s);
    GrndsTrace.exitScope();
    return s;
  }
  
  public void displayReportParameterDetail_xa(GrndsExchangeContext context) {
	  
      BaseSessionStateManager state = getSessionStateManager(context);
      HttpServletRequest request = context.getRequest();
      ReportStaffSearchDB reportStaffSearchDb = (ReportStaffSearchDB) state.getAttribute(REPORT_STAFF_SEARCH_DB, request);
      boolean returningFromStaffSearchList = (reportStaffSearchDb != null);
      
      state.removeAllAttributes(request);
      
      String hdnNmRptSqrName;
      String hdnNmRptSqrVer;
      String nameOfReport;
      String szTxtNmRptType;
      hdnNmRptSqrName = ContextHelper.getStringSafe(context, "hdnNmRptSqrName");
      hdnNmRptSqrVer = ContextHelper.getStringSafe(context, "hdnNmRptSqrVer");
      nameOfReport = ContextHelper.getStringSafe(context, "hdnNmOfReport");
      szTxtNmRptType = ContextHelper.getStringSafe(context, "hdnNmRptType");
      
      List reportParametersList = null;
      
      //pull objects from state when returning from staff search list
      if(returningFromStaffSearchList){ 
          hdnNmRptSqrName = reportStaffSearchDb.getHdnNmRptSqrName();
    	  hdnNmRptSqrVer = reportStaffSearchDb.getHdnNmRptSqrVer();
    	  nameOfReport = reportStaffSearchDb.getNameOfReport();
          reportParametersList = reportStaffSearchDb.getParameterList();
          szTxtNmRptType = reportStaffSearchDb.getSzTxtNmRptType();
          populateStaff(request, reportStaffSearchDb);
      }
      
      if (reportParametersList == null){
	    reportParametersList = retrieveReportParmList.retrieveLaunchReportParameters(hdnNmRptSqrName, hdnNmRptSqrVer);
      } 
      
      state.setAttribute("PARAMETER_LIST",reportParametersList,request );  
      state.setAttribute("NAME_OF_REPORT",nameOfReport,request );
      state.setAttribute(ReportTag.REPORT_TYPE, szTxtNmRptType, request);
      
      //setting objects in state to be used by staff search query on return
      state.setAttribute("NAME_OF_REPORT_SQR_NM",hdnNmRptSqrName,request );
      state.setAttribute("NAME_OF_REPORT_SQR_VER",hdnNmRptSqrVer,request );
      state.setAttribute("hdnNmRptSqrName",hdnNmRptSqrName,request );
      state.setAttribute("hdnNmRptSqrVer",hdnNmRptSqrVer,request );
      setReportStaffSearchDB(request, reportStaffSearchDb);
  }

  
  /**
   * Populates staffId and staffFullName in ReportStaffSearchDB when EventSearch is returned to from StaffList
   *
   * @param request       HttpServletRequest
   * @param reportStaffSearchDB ReportStaffSearchDB
   */
  protected static void populateStaff(HttpServletRequest request, ReportStaffSearchDB reportStaffSearchDB) {
    ROWCCMN50DO_ARRAY rowccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (rowccmn50do_array == null) {
      return;
    }
    ROWCCMN50DO[] rows = rowccmn50do_array.getROWCCMN50DO();
    if (rows.length > 1) {
      throw new IllegalArgumentException("I got more than 1 row back");
    }
    if (rows.length != 1) {
      return;
    }
    // StaffSearch uses 2 different objects
    request.removeAttribute(STAFF_LIST_PULLBACK_INFO);
    request.removeAttribute(StaffSearchInput.STAFF_PULL_BACK);
    int staffId = rows[0].getUlIdPerson();
    String staffName = rows[0].getSzNmPersonFull();

    reportStaffSearchDB.setStaffId(staffId);
    reportStaffSearchDB.setStaffName(staffName);
  }
  /**
   * Retrieve ReportStaffSearchDB from state; create a new one if one isn't there
   *
   * @param request HttpServletRequest
   * @return reportStaffSearchDB
   */
  public static ReportStaffSearchDB getReportStaffSearchDB(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);
    ReportStaffSearchDB reportStaffSearchDB = (ReportStaffSearchDB) state.getAttribute(REPORT_STAFF_SEARCH_DB, request);

    if (reportStaffSearchDB != null) {
      return reportStaffSearchDB;
    }

    reportStaffSearchDB = newReportStaffSearchDB(request);
    setReportStaffSearchDB(request, reportStaffSearchDB);
    return reportStaffSearchDB;
  }

  /**
   * Set ReportStaffSearchDB into state
   *
   * @param request       HttpServletRequest
   * @param reportStaffSearchDB ReportStaffSearchDB
   */
  protected static void setReportStaffSearchDB(HttpServletRequest request, ReportStaffSearchDB reportStaffSearchDB) {
    BaseSessionStateManager state = getSessionStateManager(request);
    state.setAttribute(REPORT_STAFF_SEARCH_DB, reportStaffSearchDB, request);
    
  }

  /**
   * initializes ReportStaffSearchDB
   *
   * @param request HttpServletRequest
   * @return reportStaffSearchDB
   */
  protected static ReportStaffSearchDB newReportStaffSearchDB(HttpServletRequest request) {
    ReportStaffSearchDB reportStaffSearchDB = new ReportStaffSearchDB();
    //reportStaffSearchDB.setSearchEntireCase(GlobalData.getUlIdStage(request) == 0);
    return reportStaffSearchDB;
  }  
  /**
   * This method calls the report generate service after calling a helper method to populate the input object.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void generateReport(GrndsExchangeContext context)
          throws ServiceException, MarshalException, ValidationException, InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".generateReport");
    CARC07SI carc07si = populateCARC07SI_Generate(context);
    if (ReportsConversation.BATCH_REPORTS.containsKey(carc07si.getSzNmRptSqrName())) {
    	reports.launchBatchReportAsync(carc07si);
    } else {
        int idReportList = reports.saveReportList(carc07si);
        // Call to asynchronous service done separately to allow the saveReportList transaction
        // to complete.
        reports.launchReportAsync(idReportList, carc07si);
    }
    GrndsTrace.exitScope();
  }

  /**
   * This helper method is called by the generateReport method to populate the input object for the carc07s report
   * service.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CARC07SI populateCARC07SI_Generate(GrndsExchangeContext context) throws InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + "populateCARC07SI_Generate()");
    BaseSessionStateManager state = getSessionStateManager(context);  
    
    HttpServletRequest request = context.getRequest();
    CARC07SI carc07si = new CARC07SI();
    int ulIdPerson = ContextHelper.getUlIdPerson(context);
    String szNmPersonFull = ContextHelper.getStringSafe(request, REPORT_PARAM_NM_PERSON_FULL);
    boolean useHiddenParameters = ContextHelper.getBooleanSafe(context, ReportTag.USE_HIDDEN_PARAMETERS);

    String szNmRptSqrName = ContextHelper.getStringSafe(request, ReportTag.SQR_NAME);
    String szNmRptSqrVer = ContextHelper.getStringSafe(request, ReportTag.SQR_VERSION);
    String szTxtNmRptType = ContextHelper.getStringSafe(request, ReportTag.REPORT_TYPE);

    if(!StringHelper.isValid(szNmRptSqrName) || !StringHelper.isValid(szNmRptSqrVer)){
    	//StaffSearch may require values to be queried from state
    	szNmRptSqrName = (String)state.getAttribute("NAME_OF_REPORT_SQR_NM", request);
    	szNmRptSqrVer = (String)state.getAttribute("NAME_OF_REPORT_SQR_VER", request);
    }
    
    if (!StringHelper.isValid(szTxtNmRptType)) {
      szTxtNmRptType = (String) state.getAttribute(ReportTag.REPORT_TYPE, request);
    }
    
    String txtRptParmList = ContextHelper.getStringSafe(request, ReportTag.PARAMETER_LIST);
    if (useHiddenParameters) {
      txtRptParmList = addHiddenParameters(txtRptParmList, context);
    }
    String szTxtEmailMessage = ContextHelper.getStringSafe(request, ReportTag.EMAIL_MESSAGE);

    txtRptParmList = URLHelper.decode(txtRptParmList);
    szTxtEmailMessage = URLHelper.decode(szTxtEmailMessage);

    int ulRptLstCfpStamp = ContextHelper.getIntSafe(request, ReportListTag.CFP_STAMP);
    //SWR - Commented out since we have optional parameters for now.
    //@TODO Look into validating required and optional parameters
    //checkParameterCount(txtRptParmList, szNmRptSqrName, szNmRptSqrVer);

    carc07si.setSzNmRptSqrName(szNmRptSqrName);
    carc07si.setSzNmRptSqrVer(szNmRptSqrVer);
    carc07si.setUlIdPerson(ulIdPerson);
    carc07si.setSzNmPersonFull(szNmPersonFull);
    //STGAP00013472: Unauthorized access to Sensitive Cases through Reports should be denied
    //Set the Sensitive case access rights for the user
    carc07si.setSzIndCaseSensitive(getSensitiveAttribute(request));
    //SWR - Solaris version of SQR would process single quotes correctly.  Instead,
    //parameters cannot contain spaces and null values have defaults.
    //carc07si.setTxtRptParmList(singleQuoteParameters(txtRptParmList));
    carc07si.setTxtRptParmList(txtRptParmList);
    carc07si.setUlRptLstCfpStamp(ulRptLstCfpStamp);
    carc07si.setSzTxtEmailMessage(szTxtEmailMessage);
    carc07si.setSzTxtNmRptType(szTxtNmRptType);
    //Set the training username (schema) if it is a training environment
    boolean bTrngEnv = ArchitectureConstants.TRUE.equals(TRNG_ENV);
    if (bTrngEnv){
      String username = UsernameContextHolder.getUsername();
      carc07si.setSzUsername(username);
    }else{
      //Set a blank username if it is not a training environment 
      //since the userName will not be used for the non training environment
      carc07si.setSzUsername("");
    }
    GrndsTrace.exitScope();
    return carc07si;
  }

  /**
   * This puts single quotes around each parameter in the list. This is necessary because of time fields like 01:00 am
   * which would otherwise be treated as 2 parameters to SQR
   */
  public static String singleQuoteParameters(String list) {
    //IF YOU UPDATE THIS METHOD, RERUN singleQuoteParametersTest
    String outputParameterList = "";
    String previousToken = "^";

    StringTokenizer stringTokenizer = new StringTokenizer(list, "^", true);
    while (stringTokenizer.hasMoreTokens()) {
      String token = stringTokenizer.nextToken();

      if ("^".equals(previousToken) &&
          "^".equals(token)) {
        outputParameterList += "''^";
      }

      previousToken = token;
      if ("^".equals(token)) {
        continue;
      }

      if (token.startsWith("'") &&
          token.endsWith("'")) {
        outputParameterList += token + "^";
      } else {
        if (token.indexOf("'") != -1) {
          throw new IllegalStateException(
                  "reports don't handle having a parameter with single quotes embedded; bad parameter: " + token);
        }
        outputParameterList += "'" + token + "'^";
      }
    }
    return outputParameterList;
 }

  /**
   * This method calls the report listing service after calling a helper method to populate the input object.
   *
   * @param context The GrndsExchangeContext object.
   */
  public CARC06SO listReports(GrndsExchangeContext context)
          throws ServiceException, MarshalException, ValidationException, InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".listReports");
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(RESULTS_PER_PAGE);
    CARC06SI carc06si = populateCARC06SI_Retrieve(context, tuxPagination);
    CARC06SO carc06so = reports.retrieveReportList(carc06si);
    tuxPagination.setPaginationInformation(carc06so.getArchOutputStruct(),
                                           carc06so.getROWCARC06SOG_ARRAY().getROWCARC06SOGCount());
    storePaginationBeanToRequest(context, tuxPagination);
    HttpServletRequest request = context.getRequest();
    request.setAttribute("INPUT", carc06si);
    request.setAttribute("OUTPUT", carc06so);
    GrndsTrace.exitScope(carc06so.toString());
    return carc06so;
  }
  /**
   * This method calls the report launch listing service.
   *
   * @param context The GrndsExchangeContext object.
   */
  public List<RetrieveReportPageSO> listLaunchReports(GrndsExchangeContext context)
          throws ServiceException, MarshalException, ValidationException, InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".listReports");
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(RESULTS_PER_PAGE);
    
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    // STGAP00010625 - pass id user for service to get user's profile to set indAccessAllowed for report
    List<RetrieveReportPageSO> reportPageList = retrieveReport.retrieveAllReportPageReports(userProfile.getUserID());

    request.setAttribute("REPORT_PAGE_LIST", reportPageList); 
    return reportPageList;
  }
  /**
   * This helper method is called by the listReports method to populate the input object for the carc06s retrieve
   * service.
   *
   * @param context       The GrndsExchangeContext object.
   * @param tuxPagination TuxedoPaginationValueBean object.
   */
  private CARC06SI populateCARC06SI_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) {
    GrndsTrace.enterScope(TRACE_TAG + "populateCARC06SI_Retrieve()");
    HttpServletRequest request = context.getRequest();

    CARC06SI carc06si = new CARC06SI();

    int ulIdPerson = 0;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    if (userProfile != null) {
      ulIdPerson = userProfile.getUserID();
    }
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setSzUserId(user.getUserLogonID());
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
    archInputStruct.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    archInputStruct.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    carc06si.setArchInputStruct(archInputStruct);
    carc06si.setCSysIndRptRtrvType(IND_RPT_RTRV_TYP);
    carc06si.setUlIdPerson(ulIdPerson);
    return carc06si;
  }

  /**
   * This method calls the report retry service after calling a helper method to populate the input object.
   *
   * @param context The GrndsExchangeContext object.
   */
  public CARC21SO retryReport(GrndsExchangeContext context)
          throws ServiceException, MarshalException, ValidationException, InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".retryReport");
    CARC21SI carc21si = populateCARC21SI_Retry(context);
    CARC21SO carc21so = reports.retrieveReportParamList(carc21si);
    HttpServletRequest request = context.getRequest();
    request.setAttribute("INPUT21", carc21si);
    request.setAttribute("OUTPUT21", carc21so);
    GrndsTrace.exitScope();
    return carc21so;
  }

  /**
   * This helper method is called by the retryReport method to populate the input object for the carc21s retry service.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CARC21SI populateCARC21SI_Retry(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + "populateCARC21SI_Retry()");
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    CARC21SI carc21si = new CARC21SI();
    carc21si.setUlIdRptList(ContextHelper.getIntSafe(request, "ulIdRptList"));
    carc21si.setUlIdPerson(userProfile != null ? userProfile.getUserID() : 0);
    carc21si.setSzNmRptSqrName(ContextHelper.getStringSafe(request, "szNmRptSqrName"));
    carc21si.setSzNmRptSqrVer(ContextHelper.getStringSafe(request, "szNmRptSqrVer"));
    carc21si.setSzTxtEmailMessage(ContextHelper.getStringSafe(request, "szTxtEmailMessage"));
    carc21si.setSzTxtNmRptType(ContextHelper.getStringSafe(request,"szNmRptType"));
    return carc21si;
  }

  /**
   * This method calls the report delete service after calling a helper method to populate the input object.
   *
   * @param context The GrndsExchangeContext object.
   */
  public CARC19SO deleteReport(GrndsExchangeContext context)
          throws ServiceException, MarshalException, ValidationException, InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteReport");
    CARC19SI carc19si = populateCARC19SI_Delete(context);
    CARC19SO carc19so = reports.deleteReportList(carc19si);
    HttpServletRequest request = context.getRequest();
    request.setAttribute("INPUT19", carc19si);
    request.setAttribute("OUTPUT19", carc19so);
    GrndsTrace.exitScope(TRACE_TAG + ".deleteReport");
    return carc19so;
  }

  /**
   * This helper method is called by the deleteReport method to populate the input object for the carc19s retry
   * service.
   *
   * @param context The GrndsExchangeContext object.
   */
  private CARC19SI populateCARC19SI_Delete(GrndsExchangeContext context) throws InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + "populateCARC19SI_Delete()");
    CARC19SI carc19si = new CARC19SI();
    int ulIdRptList = ContextHelper.getInt(context, "ulIdRptList");
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    carc19si.setArchInputStruct(input);
    carc19si.setUlIdRptList(ulIdRptList);
    return carc19si;
  }

  /**
   * This method calls the helper method generate report and returns a message to the calling page.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void reportGenerate_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".reportGenerate_xa");
    HttpServletRequest request = context.getRequest();
    try {
      //CARC07SO carc07so =
      generateReport(context);
      String reportMessage = MSG_REPORT_GENERATING;
      request.setAttribute(REPORT_ERROR_MESSAGE, reportMessage);
      //SWR - This message should only be seen when launching reports from the Report Launch Page.
      setInformationalMessage(MSG_SUCCESS_REFRESH, request);
    } catch (InformationalPrsException ipe) {
      String reportMessage = MSG_INCORRECT_INPUTS + ipe.getMessage();
      request.setAttribute(REPORT_ERROR_MESSAGE, reportMessage);
    } catch (Exception e) {
      handleException(e, context, "reportGenerate_xa");
    }
    GrndsTrace.exitScope(TRACE_TAG + ".reportGenerate_xa");
  }

  /**
   * This _xa method calls the helper method listReports.  Initial display.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void reportList_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + "reportList_xa");
    // define state and request
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    // clear state at the beginning of the conversation
    state.removeAllAttributes(request);
    try {
      //CARC06SO carc06so =
      listReports(context);
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
        // Case MSG_NO_ROWS_RETURNED will be handled on the JSP, just by no
        //  carc06so object being in the request.  sir 16973
        case Messages.MSG_NO_ROWS_RETURNED:
          break;
        default:
          handleException(we, context, "reportList_xa.listReports");
          break;
      }
    } catch (Exception e) {
      handleException(e, context, "reportList_xa.listReports");
    }
    GrndsTrace.exitScope(TRACE_TAG + ".reportList_xa");
  }
  
  /**
   * This _xa method calls the helper method to listReports in the Reports Launch Screen.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void reportLaunchList_xa(GrndsExchangeContext context) {
	    GrndsTrace.enterScope(TRACE_TAG + "reportList_xa");
	    // define state and request
	    BaseSessionStateManager state = getSessionStateManager(context);
	    HttpServletRequest request = context.getRequest();
	    // clear state at the beginning of the conversation
	    state.removeAllAttributes(request);
	    try {
	      listLaunchReports(context);
	    } catch (ServiceException we) {
	      switch (we.getErrorCode()) {
	        // Case MSG_NO_ROWS_RETURNED will be handled on the JSP, just by no
	        case Messages.MSG_NO_ROWS_RETURNED:
	          break;
	        default:
	          handleException(we, context, "reportLaunchList_xa.listReports");
	          break;
	      }
	    } catch (Exception e) {
	      handleException(e, context, "reportLaunchList_xa.listReports");
	    }
	    GrndsTrace.exitScope(TRACE_TAG + ".reportLaunchList_xa");
	}

  /**
   * This method retrieves the report byte array and puts it in the request for use in the presentation.
   *
   * @param context
   */
  public void reportRetrieve_xa(GrndsExchangeContext context) {
    RetrieveReportSI retrieveReportSI = new RetrieveReportSI();
    HttpServletRequest request = context.getRequest();
    retrieveReportSI.setReportFilename(ContextHelper.getString(request, "FILENAME"));
    retrieveReportSI.setReportType(ContextHelper.getString(request, "RPTTYPE"));
    RetrieveReportSO retrieveReportSO = reports.retrieveReport(retrieveReportSI);
    request.setAttribute(ReportPresentation.REPORT_BYTES_KEY, retrieveReportSO.getReportBytes());
    request.setAttribute(ReportPresentation.REPORT_TYPE_KEY, retrieveReportSO.getReportType());
  }

  /**
   * This _xa method calls the helper methods deleteReport and listReports.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void reportDelete_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + "reportDelete_xa");
    try {
      //CARC19SO carc19so =
      deleteReport(context);
    } catch (Exception e) {
      handleException(e, context, "reportList_xa.deleteReports");
    }

    // removed try catch blocks for listReports; changed the .xconf file - sir 16973 lauramc
    GrndsTrace.exitScope(TRACE_TAG + ".reportList_xa");
  }

  /**
   * This _xa method calls the helper methods deleteReport and listReports. If retry is set to true then this method
   * will call the helper method retryReport.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void reportRetry_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + "reportRetry_xa");
    try {
      HttpServletRequest request = context.getRequest();
      int ulIdRptList = ContextHelper.getIntSafe(request, "ulIdRptList");
      String retry = ContextHelper.getStringSafe(request, "retry");

      if (ulIdRptList != 0) {
        if ("true".equals(retry)) {
          //CARC21SO carc21s0 =
          retryReport(context);
        }
        //CARC19SO carc19so =
        deleteReport(context);

      } //end if ulIdRptList is not 0
      //CARC06SO carc06so =
      listReports(context);
    } catch (Exception e) {
      handleException(e, context, "reportList_xa.listReports");
    }
    GrndsTrace.exitScope(TRACE_TAG + ".reportList_xa");
  }

  /**
   * This helper method handles all the Service Exceptions thrown by the generate, list, retry, and delete services.
   * Called by the following methods:  reportRetry_xa, reportGenerate_xa, reportList_xa, reportDelete_xa.
   *
   * @param e          ServiceException and context.
   * @param context    The GrndeExchangeContext object.
   * @param methodName Name of the method that threw the exception.
   */
  private void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    String stackTrace = BasePrsException.getStackTrace(e);

    // For Service exceptions, check for expected errors. Otherwise, use generic message.
    if (e instanceof ServiceException) {
      ServiceException se = (ServiceException) e;
      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "ServiceException " + se.getClass() + " " + se.getMessage());
      HttpServletRequest request = context.getRequest();
      int errorCode = se.getErrorCode();
      //08/01/2003, Matthew McClain, because that's how ReportGen.jsp shows an error
      String reportErrorMessage = MessageLookup.getMessageByNumber(errorCode);
      request.setAttribute(REPORT_ERROR_MESSAGE, reportErrorMessage);
      switch (errorCode) {
        case Messages.MSG_REPORT_LAUNCH_FAILED:
        case Messages.MSG_ARC_RPT_BAT_ERROR:
        case Messages.MSG_FILE_NOT_FOUND:
          setInformationalMessage(errorCode, request);
          break;
        case Messages.MSG_REPORT_PARM_INVALID:  
        case Messages.MSG_NO_ROWS_RETURNED:
        case Messages.MSG_CMN_SENSITIVE_CASE:          
          this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          setErrorMessage(errorCode, request);
          break;
        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
          processSevereException(context, se);
          break;
      }
    } else {
      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7,
                     "General Exception " + e.getClass() + " " + e.getMessage() + stackTrace);
      processSevereException(context, e);
    }
  }

  /** This is to test that singleQuoteParameters still works if you change it It throws an exception if a test fails */
  public static void singleQuoteParametersTest() {
    String[][] tests = new String[][] {
            new String[] {"a b^ ^c^^", "'a b'^' '^'c'^''^"},
            new String[] {"a b^ ^c^asdf^", "'a b'^' '^'c'^'asdf'^"},
            new String[] {"a b^  ^c^asdf^^^^", "'a b'^'  '^'c'^'asdf'^''^''^''^"},
            new String[] {"  b^  ^^  ", "'  b'^'  '^''^'  '^"},
            new String[] {"  ^  ^^  ", "'  '^'  '^''^'  '^"},
            new String[] {"'  '^'  '^''^'  '^", "'  '^'  '^''^'  '^"},
    };

    for (int i = 0; i < tests.length; i++) {
      String returned = singleQuoteParameters(tests[i][0]);
      if (returned.equals(tests[i][1]) == false) {
        throw new IllegalStateException("singleQuoteParameters test " + i + " failed: \n" +
                                        "\texpected = \"" + tests[i][1] + "\"\n" +
                                        "\treturned = \"" + returned + "\"\n");
      }
    }
  }
  /**
   * Initialize request to call StaffList Pullback (from EventSearch.jsp)
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayStaffList_xa(GrndsExchangeContext context) {
	BaseSessionStateManager state = getSessionStateManager(context);  
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayStaffList_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    try {
      // don't clear state
      // save key fields to be displayed when returning back to report page
      ReportStaffSearchDB reportStaffSearchDB = getReportStaffSearchDB(request);
      reportStaffSearchDB.setHdnNmRptSqrName((String)state.getAttribute("NAME_OF_REPORT_SQR_NM", request));
      reportStaffSearchDB.setHdnNmRptSqrVer((String)state.getAttribute("NAME_OF_REPORT_SQR_VER", request));
      reportStaffSearchDB.setNameOfReport((String)state.getAttribute("NAME_OF_REPORT", request));
      reportStaffSearchDB.setParameterList((List)state.getAttribute("PARAMETER_LIST", request));
      reportStaffSearchDB.setSzTxtNmRptType((String) state.getAttribute(ReportTag.REPORT_TYPE, request));
      
	  //Setting reportStaffSearchDB will hold current report info and results of staff search
      setReportStaffSearchDB(request, reportStaffSearchDB);

      PageMode.setPageMode(PageModeConstants.EDIT, request);

      StaffSearchInput staffSearchInput = new StaffSearchInput();
      staffSearchInput.setSourcePage(StaffSearchInput.EVENT_SEARCH);
      staffSearchInput.setDestinationUrl("/admin/Reports/displayReportParameterDetail");
      request.setAttribute(STAFF_LIST_PULLBACK_INFO, staffSearchInput);

      staffSearchInput.addStageId(0);

      forward(URL_STAFF_LIST, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }
  /** Invoke test case */
  public static void main(String[] args) {
    singleQuoteParametersTest();
  }
  
  /**
   * This method is called by the other methods to get whether the user has Rights to access
   * to see the Sensitive Cases.
   * 
   * @param request
   *                HTTP Servlet Request object.
   * @return String
   *                Return either N or Y.
   */
  private String getSensitiveAttribute(HttpServletRequest request) {
    String retValue = ArchitectureConstants.N;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile != null) {
      retValue = userProfile.hasRight(UserProfile.SEC_SENSITIVE_CASE_ACCESS) == true ? 
                                   ArchitectureConstants.Y : ArchitectureConstants.N ;
    }
    return retValue;
  }
}
