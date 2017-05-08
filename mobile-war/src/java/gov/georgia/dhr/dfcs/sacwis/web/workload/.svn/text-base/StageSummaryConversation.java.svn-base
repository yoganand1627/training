package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.OrderedMap;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CFMgmntList;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.Investigation;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;


public class StageSummaryConversation extends BaseHiddenFieldStateConversation {

  public static final String SORT_BY_DATE = "9";
  public static final String TRACE_TAG = "CaseSummaryConversation";
  public static final String CASE_STATUS_OPEN = "Open";
  public static final String CASE_STATUS_CLOSED = "Closed";

  public static final String DISPLAY_URI = "/workload/CaseSummary/displayCaseSummary";
  public static final String ASSIGNED_WORKLOAD_URI = "/workload/AssignedWorkload/displayAssignedWorkload";
  public static final String ACTION_CODE_ADD = "A";
  public static final String ACTION_CODE_UPDATE = "U";
  public static final String ACTION_CODE_VALIDATE = "V";

  public static final String INDICATOR_YES = ArchitectureConstants.Y;
  public static final String INDICATOR_NO = ArchitectureConstants.N;

  public static final String ACTION_CODE_MERGE = "M";
  public static final String ACTION_CODE_SPLIT = "S";
  public static final String ACTION_CODE_VOID_MERGE = "V";
  public static final String ACTION_CODE_VOID_SPLIT = "Z";

  public static final String SINGLE_SPACE = " ";
  public static final String EMPTY_STRING = "";
  public static final String STRING_NULL = "null";

  public static final String CHECK = "1";
  public static final String NO_CHECK = "0";

  public static final String STAGE_INV = "INV";
  public static final String PROG_AFC = "AFC";
  public static final String ALLEGED_PERPS_ONLY = "Z";
  public static final String CAPS_WIN_MODE_PRINC_ONLY = "P";

  public static final String CASE_PROGRAM_AFC = "AFC";
  public static final String CASE_PROGRAM_APS = "APS";
  public static final String CASE_PROGRAM_CCL = "CCL";
  public static final String CASE_PROGRAM_RCL = "RCL";
  public static final String CASE_PROGRAM_LIC = "LIC";

  public static final String VALIDATE_BAD = INDICATOR_NO;
  public static final String VALIDATE_SUCCESS = INDICATOR_YES;

  public static final String FSU_STAGE = "FSU";
  public static final String SUB_STAGE = "SUB";
  public static final String FRE_STAGE = "FRE";
  public static final String PAD_STAGE = "PAD";
  //STGAP00014341
  public static final String ADO_STAGE = "ADO";
  public static final String FPR_STAGE = "FPR";
  public static final String DIV_STAGE = "DIV";
  public static final String PFC_STAGE = "PFC";

  public static final String INV_STAGE = "INV";
  public static final String ARI_STAGE = "ARI";
  public static final String FAD_STAGE = "FAD";
  public static final String ARF_STAGE = "ARF";

  public static final String PAGE_E = "pageE";
  public static final String PAGE_F = "pageF";
  public static final String PAGE_G = "pageG";
  public static final String PAGE_H = "pageH";

  public static final String HAS_REC_RET = "indHasRecordsRet";

  public static final String SUC_VAL = "SUC_VAL";

  //sir#14411
  public static final String MERGE_BY_INTAKE_DATE = "Merge_By_Intake_Date";
  public static final String SWITCH_CASES = "S";

  public static final int SEARCH_RESULTS_PER_PAGE = 50;
  public static final int LIST_RESULTS_MAX = 50;

  //SIR 23726
  public static final String INV_CONCL_TASK_CODE = "2120";
  public static final String SVC_CONCL_TASK_CODE = "6010";
  public static final String AOC_CONCL_TASK_CODE = "5090";

  public static final String SORT_ASCENDING = "ASC";
  
  public static final String PAD_PLC_TASK_CODE = "9080"; //9080
  public static final String SUB_PLC_TASK_CODE = "3080"; //3090
  public static final String ADO_PLC_TASK_CODE = "8590"; //8590
  public static final String PFC_PLC_TASK_CODE = "9085"; //9086
  
  private Admin admin;
  private CFMgmntList CFMgmntListEjb;
  private CaseMgmt caseMgmt;
  private Investigation investigation;
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void setCaseMgmt(CaseMgmt caseMgmt){
    this.caseMgmt = caseMgmt;
  }
  public void setCFMgmntListEjb(CFMgmntList CFMgmntListEjb) {
    this.CFMgmntListEjb = CFMgmntListEjb;
  }
  
  public void setInvestigation(Investigation investigation) {
	    this.investigation = investigation;
  }

  /**
   * This method is called by the GRNDS controller when a user searches for case summaries. Also displays Special
   * Handling, Case File Management, Case Merge/Split, and Records Retention.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayStageSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStageSummary_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    
    setStageInGlobalData(request);
    setIncomingStage(context);
    
    performanceTrace.exitScope();
  }
  
  public void displayStage_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStage_xa()");
    performanceTrace.enterScope();
    
    setIncomingStage(context);
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String pageNotAva = ContextHelper.getStringSafe(request, "hdnPageNotAva");
    if("true".equals(pageNotAva) || "false".equals(pageNotAva)) {
    	state.setAttribute("pageNotAva", pageNotAva, request);
    }
    
    OrderedMap navigationMap = loadNavigationMap(context);
    request.setAttribute("OMAP", navigationMap);
    state.setAttribute("OMAP", navigationMap, request);
    performanceTrace.exitScope();
  }

  private void setIncomingStage(GrndsExchangeContext context) {
	  HttpServletRequest request = context.getRequest();
	  BaseSessionStateManager state = getSessionStateManager(context);
	  request.setAttribute("INCOMING_DETAIL_ID", investigation.retrieveIncomingDetail(GlobalData.getUlIdStage(request)));
	  state.setAttribute("INCOMING_DETAIL_ID", investigation.retrieveIncomingDetail(GlobalData.getUlIdStage(request)), request);
	  
  }
 
  private void setStageInGlobalData(HttpServletRequest request) {
    GlobalData.setUlIdStage(ContextHelper.getIntSafe(request, "hdnUlIdStage"), request);
    GlobalData.setSzNmStage(ContextHelper.getStringSafe(request, "hdnSzNmStage"), request);
    GlobalData.setSzCdStage(ContextHelper.getStringSafe(request, "hdnSzCdStage"), request);
    GlobalData.setSzCdStageType(ContextHelper.getStringSafe(request, "hdnSzCdStageType"), request);
    GlobalData.setDtDtStageStart(ContextHelper.getCastorDateSafe(request, "hdnDtDtStageStart"), request);
    if (ContextHelper.getIntSafe(request, "hdnUlIdAdoCase") != 0) {
      GlobalData.setUlIdCase(ContextHelper.getIntSafe(request, "hdnUlIdAdoCase"), request);
    }
  }
  
  private OrderedMap loadNavigationMap(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    int intStage = ContextHelper.getIntSafe(request, "hdnUlIdStage");
    String strCdStage = ContextHelper.getStringSafe(request, "hdnSzCdStage");
    OrderedMap oMap = new OrderedMap();
    if ("INV".equals(strCdStage)) {
      oMap.put(INTAKE_REPORT_LABEL, INTAKE_REPORT_HREF);
      String strContactHref = CONTACT_HREF + intStage +  "\" );";
      oMap.put(CONTACT_LABEL, strContactHref);
    }
    return oMap;
  }
  
  private static final String INTAKE_REPORT_LABEL = "Intake Report";
  private static final String INTAKE_REPORT_HREF = "javascript:SubmitCallNarrForm();";
  private static final String CONTACT_LABEL = "Contacts";
  private static final String CONTACT_HREF= "javascript:contactHyperlink( \"";
}

