package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.Investigation;
import gov.georgia.dhr.dfcs.sacwis.service.resource.Resource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PolicyWaiverDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PolicyWaiverRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PolicyWaiverSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FadHomeRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PolicyWaiverRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to search for resources from the Resource Search page and refine a search,
 * conduct a new search, and display selected list from the Resource List page. <p/> Declare your conversation class and
 * have it extend BaseHiddenFieldStateConversation class. <p/> Note that the "<code>&lt;pre&gt;</code>" tag below is
 * necessary to prevent the change history from being reformatted by code formatting tools. <p/>
 * 
 * <pre>
 *    Change History:
 *    Date      User              Description
 *    --------  ----------------  --------------------------------------------------
 *    09/25/2008  alwilliams      STGAP00009727: Updated method retrieveResource_xa to
 *                                store the pullback object in to the state.
 *    11/11/2008  arege           STGAP00010758 The Todo was not being deleted when the 
 *                                currentActiveApprover was invalidating his own ToDo.
 *                                Modified displayPolicyWaiver_xa so that MSG_CMN_INVLD_APRVL
 *                                is not displayed for the Supervisor in approval mode.
 *    01/06/2009  hnguyen         STGAP00010699: Updated retrievePerson_xa  method to use
 *                                ContextHelper.getDoubleSafe() to return AmtWvr and
 *                                NbrWvrUnit from request to resolve NumberFormatException.
 *    12/11/2009  wjcochran       SMS #37323: Removed the line storing the pullback object
 *                                in the state (from STGAP00009727) due to problems it
 *                                created with the Resource Search. With the (empty) object
 *                                stored in the state, the resource search never populated
 *                                a search bean with data from the resource search form,
 *                                thereby listing all available resources no matter the
 *                                search parameters entered.               
 *    03/18/2011  hnguyen         SMS#97850: Added 30 Day Grace Period Waiver for event description.
 *    03/25/2011  hnguyen         SMS#97850: Added waiver type into RetrieveSI to allow validation on waiver type selection.
 *    03/31/2011  hnguyen         SMS#97850: Moved WGP date population from retrieve service.
 * </pre>        
 */
public class PolicyWaiverConversation extends BaseHiddenFieldStateConversation {

  /**
   * The CLASSNAME_TAG constant is used to mark log records in GRNDS tracing; most classes should have it. <p/> Other
   * static constants should be put just below this.
   */
  public static final String TRACE_TAG = "PolicyWaiverConversation";

  public static final String INVESTIGATION = "INV";

  public static final String POLICY_WAIVER_TASK_CODE = "2320";

  public static final String APPROVE_POLICY_WAIVER = "2321";
  
  public static final String ADOPTION  = "ADO";

  public static final String POLICY_WAIVER_TASK_CODE_ADO = "9870";
   
  public static final String FOSTER_CARE  = "SUB";

  public static final String POLICY_WAIVER_TASK_CODE_SUB = "3235";
  
  public static final String FOSTER_ADOPTIVE  = "FAD";

  public static final String POLICY_WAIVER_TASK_CODE_FAD = "8265";
     
  public static final String DIVERSION  = "DIV";

  public static final String POLICY_WAIVER_TASK_CODE_DIV = "2235";
  
  public static final String FOSTER_CARE_FAMILY  = "FSU";

  public static final String POLICY_WAIVER_TASK_CODE_FSU = "7310";

  public static final String ONGOING  = "FPR";

  public static final String POLICY_WAIVER_TASK_CODE_FPR = "7815";
  
  public static final String POST_FOSTER_CARE  = "PFC";

  public static final String POLICY_WAIVER_TASK_CODE_PFC = "7916";
  
  public static final String WVR_EVENT_TYPE = CodesTables.CEVNTTYP_WVR;

  public static final String CASE_TODO_PAGE = "/workload/ToDo/displayCaseToDo";

  public static final String STAFF_TODO_PAGE = "/workload/ToDo/displayStaffToDo";

  public static final String POLICY_WAIVER_TAB = "";

  public static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;

  public static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  public static final String EVENT_STATUS_PROC = CodesTables.CEVTSTAT_PROC;

  public static final String EVENT_STATUS_COMP = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_DESC_INV = "45  Day Investigation Waiver";

  public static final String EVERNT_DESC_CAS = "Contact Standards";

  public static final String SUBMIT = "submit";

  public static final String SAVE = "save";

  // public static final String PERSON_LIST = "/workload/EventSearch/displayPersonList";
  protected static final String PERSON_LIST_PULLBACK_INFO = PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME;

  protected static final String RESOURCE_PULLBACK_INFO = ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST;

  public static final String URL_PERSON_LIST = "/person/PersonList/displayPersonList";

  public static final String URL_RESOURCE_SEARCH_LIST = "/resource/ResourceSearch/displaySearch";

  private Investigation investigation;
  
  private InvalidateApproval invalidateApproval = null;
  
  private Common common;
  
  private CaseMgmt caseMgmt;

  private Resource resource;

  /** @param investigation */
  public void setInvestigation(Investigation investigation) {
    this.investigation = investigation;
  }
  
  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }
  
  public void setCommon(Common common) {
    this.common = common;
  }

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  /**
   * display method for the policy waiver page
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void displayPolicyWaiver_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPolicyWaiver_xa()");
    performanceTrace.enterScope();
    boolean globalEvtStatusIsApproval = false;

    try {
      HttpServletRequest request = context.getRequest();

      PolicyWaiverRetrieveSI policyWaiverRetrieveSI = populatePolicyWaiverRetrieveSI(context);

      PolicyWaiverRetrieveSO policyWaiverRetrieveSO = new PolicyWaiverRetrieveSO();
      policyWaiverRetrieveSO = investigation.retrievePolicyWaiver(policyWaiverRetrieveSI);

      request.setAttribute("PolicyWaiverRetrieveSO", policyWaiverRetrieveSO);
      BaseSessionStateManager state = getSessionStateManager(context);
      state.setAttribute("PolicyWaiverRetrieveSO", policyWaiverRetrieveSO, request);

      // set page mode
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      if (GlobalData.getSzCdStage(request).equals(INVESTIGATION)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(POLICY_WAIVER_TASK_CODE, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         policyWaiverRetrieveSO.getIdWvrEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         POLICY_WAIVER_TASK_CODE);
        PageMode.setPageMode(pageMode, request);
      }
      
      if (GlobalData.getSzCdStage(request).equals(FOSTER_ADOPTIVE)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(POLICY_WAIVER_TASK_CODE_FAD, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         policyWaiverRetrieveSO.getIdWvrEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         POLICY_WAIVER_TASK_CODE_FAD);
        PageMode.setPageMode(pageMode, request);
      }
      
      if (GlobalData.getSzCdStage(request).equals(FOSTER_CARE)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(POLICY_WAIVER_TASK_CODE_SUB, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         policyWaiverRetrieveSO.getIdWvrEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         POLICY_WAIVER_TASK_CODE_SUB);
        PageMode.setPageMode(pageMode, request);
      }
      
      
      if (GlobalData.getSzCdStage(request).equals(DIVERSION)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(POLICY_WAIVER_TASK_CODE_DIV, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         policyWaiverRetrieveSO.getIdWvrEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         POLICY_WAIVER_TASK_CODE_DIV);
        PageMode.setPageMode(pageMode, request);
      }
      
      if (GlobalData.getSzCdStage(request).equals(FOSTER_CARE_FAMILY)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(POLICY_WAIVER_TASK_CODE_FSU , request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         policyWaiverRetrieveSO.getIdWvrEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         POLICY_WAIVER_TASK_CODE_FSU);
        PageMode.setPageMode(pageMode, request);
      }
      
      if (GlobalData.getSzCdStage(request).equals(POST_FOSTER_CARE)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(POLICY_WAIVER_TASK_CODE_PFC , request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         policyWaiverRetrieveSO.getIdWvrEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         POLICY_WAIVER_TASK_CODE_PFC);
        PageMode.setPageMode(pageMode, request);
      }
      
      if (GlobalData.getSzCdStage(request).equals(ONGOING)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(POLICY_WAIVER_TASK_CODE_FPR, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         policyWaiverRetrieveSO.getIdWvrEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         POLICY_WAIVER_TASK_CODE_FPR);
        PageMode.setPageMode(pageMode, request);
      }
      
      if (GlobalData.getSzCdStage(request).equals(ADOPTION)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(POLICY_WAIVER_TASK_CODE_ADO, request);

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         policyWaiverRetrieveSO.getIdWvrEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         POLICY_WAIVER_TASK_CODE_ADO);
        PageMode.setPageMode(pageMode, request);
      }

      // If the policy waiver event is pending approval and the user
      // did not access the page in approval mode, warn them that the pending
      // closure will be invalidated if they save any changes.
      globalEvtStatusIsApproval = GlobalData.isApprovalMode(request);
      String eventStatus = policyWaiverRetrieveSO.getROWCCMN45DO().getSzCdEventStatus();
      String previousURL = ContextHelper.getPreviousUrl(context);
      if (eventStatus.equals(CodesTables.CEVTSTAT_PEND)
          && !(previousURL.equals(CASE_TODO_PAGE) || previousURL.equals(STAFF_TODO_PAGE))
          && !GlobalData.isApprovalMode(request) && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
        setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
        setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
      } 
      if (eventStatus.equals(EVENT_STATUS_APPROVED)) {
        PageMode.setPageMode(PageModeConstants.VIEW, request);
      }

    } catch (Exception e) {
      e.printStackTrace();
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + e.getMessage());
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * Save Policy Waiver
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void savePolicyWaiver_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePolicyWaiver_xa()");
    performanceTrace.enterScope();
    try {
      save(context, ServiceConstants.REQ_FUNC_CD_UPDATE, SAVE);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      //This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Save Policy Waiver Type
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void savePolicyWaiverType_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePolicyWaiver_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    try {
      int idWvrEvent = save(context, ServiceConstants.REQ_FUNC_CD_UPDATE, SAVE);
      GlobalData.setUlIdEvent(idWvrEvent, request);
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      
      displayPolicyWaiver_xa(context);
      PageMode.setPageMode(PageModeConstants.MODIFY, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      //This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Another blank example method. Used as a dummy method for the DetailTemplate.jsp
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void saveAndSubmitPolicyWaiver_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAndSubmitPolicyWaiver_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      int ulIdEvent = save(context, ServiceConstants.REQ_FUNC_CD_UPDATE, SUBMIT);
      int ulIdCase = GlobalData.getUlIdCase(request);
      int ulIdStage = GlobalData.getUlIdStage(request);
      String szCdTask = APPROVE_POLICY_WAIVER;
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ulIdEvent, ulIdCase, ulIdStage, szCdTask);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    } catch (ServiceException we) {
      handleError(we, context);
      try {
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    } catch (Exception e) {
      //This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  private int save(GrndsExchangeContext context, String cdReqFuncCd, String method) {
    PolicyWaiverSaveSI policyWaiverSaveSI = populatePolicyWaiverSaveSI(context, method);
    PolicyWaiverRetrieveSI policyWaiverRetrieveSI = populatePolicyWaiverRetrieveSI(context);
    policyWaiverSaveSI.setCdReqFuncCd(cdReqFuncCd);
    PolicyWaiverRetrieveSO policyWaiverRetrieveSO = new PolicyWaiverRetrieveSO();
    policyWaiverRetrieveSO = investigation.retrievePolicyWaiver(policyWaiverRetrieveSI);
    String eventStatus = StringHelper.EMPTY_STRING;
    ROWCCMN45DO row = policyWaiverRetrieveSO.getROWCCMN45DO();
    if (row != null) {
      eventStatus = row.getSzCdEventStatus();
    }
    int idWvrEvent = investigation.savePolicyWaiver(policyWaiverSaveSI);
    
    HttpServletRequest request = context.getRequest();
    boolean globalEvtStatusIsApproval = GlobalData.isApprovalMode(request);
    //STGAP00010758 The Todo was not being deleted when the currentActiveApprover was invalidating his own ToDo.
    if (idWvrEvent != 0 && EVENT_STATUS_PEND.equals(eventStatus)&& !globalEvtStatusIsApproval && hasStageAccessRights(context)) {      
      CCMN05UI ccmn05ui = new CCMN05UI();
      ccmn05ui.setUlIdEvent(idWvrEvent);
      ArchInputStruct ais = new ArchInputStruct();
      ais.setUlSysNbrReserved1(ArchitectureConstants.N);
      ccmn05ui.setArchInputStruct(ais);
      try {
        invalidateApproval.invalidateApproval(ccmn05ui);
      } catch (ServiceException se) {
        handleError(se, context);
      }
    }
    return idWvrEvent;
  }
  //STGAP00007567
  /*
   * determines whether the user has access rights to modify the stage
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

  /*
   * Determines whether user login in is a supervisor
   */
  private boolean isCurrentActiveApprover(GrndsExchangeContext context) {
    boolean result = false;

    HttpServletRequest request = context.getRequest();
    int eventId = GlobalData.getUlIdEvent(request);
    if (eventId != 0) {
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      int loggedInUserId = userProfile.getUserID();
      int approverId = -1;

      ApproversRetrieveSI si = new ApproversRetrieveSI(ApproversRetrieveSI.SUBMITTED_EVENT, eventId);
      ApproversRetrieveSO so = common.retrieveApprovers(si);
      if (so.hasCurrentActiveApprover()) {
        approverId = so.getCurrentActiveApprover().getIdPerson();
      } 
      // -- return true if user is approver
      if (loggedInUserId == approverId) {
        result = true;
      }
    }

    return result;
  }
//STGAP00007567

  private PolicyWaiverSaveSI populatePolicyWaiverSaveSI(GrndsExchangeContext context, String method) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populatePolicyWaiverSaveSI");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    String waiverType = ContextHelper.getStringSafe(request, "selCdWvrType");
    String waiverTypeDesc = null;
    if (waiverType.equals("WIV"))
      waiverTypeDesc = Lookup.simpleDecodeSafe(CodesTables.CWVRTYP, CodesTables.CWVRTYP_WIV);
    else if (waiverType.equals("WCS"))
      waiverTypeDesc = Lookup.simpleDecodeSafe(CodesTables.CWVRTYP, CodesTables.CWVRTYP_WCS);
    else if (waiverType.equals("WAS"))
      waiverTypeDesc = Lookup.simpleDecodeSafe(CodesTables.CWVRTYP, CodesTables.CWVRTYP_WAS);
    else if (waiverType.equals("WCL"))
      waiverTypeDesc = Lookup.simpleDecodeSafe(CodesTables.CWVRTYP, CodesTables.CWVRTYP_WCL);
    else if (waiverType.equals("WPW"))
      waiverTypeDesc = Lookup.simpleDecodeSafe(CodesTables.CWVRTYP, CodesTables.CWVRTYP_WPW);
    else if (waiverType.equals("WLC"))
      waiverTypeDesc = Lookup.simpleDecodeSafe(CodesTables.CWVRTYP, CodesTables.CWVRTYP_WLC);
    else if (waiverType.equals("WGP"))
      waiverTypeDesc = Lookup.simpleDecodeSafe(CodesTables.CWVRTYP, CodesTables.CWVRTYP_WGP);

    ROWCCMN01UIG00 policyWaiverEvent = new ROWCCMN01UIG00();
    PolicyWaiverSaveSI policyWaiverSaveSI = new PolicyWaiverSaveSI();
    if (SUBMIT.equals(method)) {
      policyWaiverEvent.setSzCdEventStatus(EVENT_STATUS_PEND);
      policyWaiverEvent.setSzCdEventType(WVR_EVENT_TYPE);
      policyWaiverEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      policyWaiverEvent.setUlIdStage(GlobalData.getUlIdStage(request));
      policyWaiverEvent.setUlIdPerson(user.getUserID());

      policyWaiverEvent.setSzTxtEventDescr(waiverTypeDesc);
      policyWaiverEvent.setSzCdTask(GlobalData.getSzCdTask(request));
      policyWaiverEvent.setUlIdEvent(GlobalData.getUlIdEvent(request));
      policyWaiverEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));
      // STGAP00002773
      policyWaiverSaveSI.setDtDtWvrRequest(new Date());
      policyWaiverSaveSI.setTmDtWvrRequest(FormattingHelper.formatTime(new Date()));
      // end STGAP00002773
    } else {
      if(!GlobalData.isApprovalMode(request)){
      policyWaiverEvent.setSzCdEventStatus(EVENT_STATUS_PROC);
      }else{
        policyWaiverEvent.setSzCdEventStatus(EVENT_STATUS_PEND);
        }
      policyWaiverEvent.setSzCdEventType(WVR_EVENT_TYPE);
      policyWaiverEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      policyWaiverEvent.setUlIdStage(GlobalData.getUlIdStage(request));
      policyWaiverEvent.setUlIdPerson(user.getUserID());
      policyWaiverEvent.setSzTxtEventDescr(waiverTypeDesc);
      policyWaiverEvent.setSzCdTask(GlobalData.getSzCdTask(request));
      policyWaiverEvent.setUlIdEvent(GlobalData.getUlIdEvent(request));
      policyWaiverEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));
    }
    policyWaiverSaveSI.setIdWvrEvent(GlobalData.getUlIdEvent(request));
    policyWaiverSaveSI.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "pwTsLastUpdate"));
    policyWaiverSaveSI.setIdStage(GlobalData.getUlIdStage(request));
    policyWaiverSaveSI.setCdStage(GlobalData.getSzCdStage(request));
    policyWaiverSaveSI.setIdWvrCaseManager(user.getUserID());
    policyWaiverSaveSI.setSzCdWvrType(ContextHelper.getStringSafe(request, "selCdWvrType"));
    policyWaiverSaveSI.setSzCdWvrReason(ContextHelper.getStringSafe(request, "selCdWvrReason"));
    policyWaiverSaveSI.setTxtWvrCapacity(ContextHelper.getString(request, "txtWvrCapacity"));
    policyWaiverSaveSI.setCdWvrJustification(ContextHelper.getStringSafe(request, "cdWvrJustification"));
    policyWaiverSaveSI.setMnthWvrCtct(ContextHelper.getStringSafe(request, "mnthWvrCtct"));
    policyWaiverSaveSI.setYrWvrCtct(ContextHelper.getStringSafe(request, "yrWvrCtct"));
    policyWaiverSaveSI.setTxtWvrOther(ContextHelper.getStringSafe(request, "txtWvrOther"));
    policyWaiverSaveSI.setTxtSlpArngmts(ContextHelper.getStringSafe(request, "txtSlpArngmts"));
    if(request.getParameter("amtAppPrdm") == null || request.getParameter("amtAppPrdm").trim().equals(""))
    {
      policyWaiverSaveSI.setAmtAppPrdm(null);
    }
    else
    {
      policyWaiverSaveSI.setAmtAppPrdm(ContextHelper.getDoubleSafe(request, "amtAppPrdm"));
    }
    policyWaiverSaveSI.setCdWvrAuthCounty(ContextHelper.getStringSafe(request, "cdWvrAuthCounty"));
    policyWaiverSaveSI.setCdWvrPmtCounty(ContextHelper.getStringSafe(request, "cdWvrPmtCounty"));
    policyWaiverSaveSI.setCdWvrEntCd(ContextHelper.getStringSafe(request, "cdWvrEntCd"));
    policyWaiverSaveSI.setCdWvrUasCd(ContextHelper.getStringSafe(request, "cdWvrUasCd"));
    policyWaiverSaveSI.setCdWvrSvcDesc(ContextHelper.getStringSafe(request, "cdWvrSvcDesc"));
    if (waiverType.equals(CodesTables.CWVRTYP_WGP)){
      populate30GracePeriodWaiverDates(request, policyWaiverSaveSI);
      
      FadHomeRetrieveSO faHomeRetSO = caseMgmt.retrieveFadHomeByIdStage(GlobalData.getUlIdStage(request));
      policyWaiverSaveSI.setCapsResource(Integer.toString(faHomeRetSO.getUlIdResource()));
    }else{
      policyWaiverSaveSI.setDtWvrBegin(ContextHelper.getJavaDateSafe(request, "dtWvrBegin"));
      policyWaiverSaveSI.setDtWvrEnd(ContextHelper.getJavaDateSafe(request, "dtWvrEnd"));
      policyWaiverSaveSI.setCapsResource(ContextHelper.getStringSafe(request, "capsResource"));
    }
    policyWaiverSaveSI.setAmtWvr(ContextHelper.getStringSafe(request, "amtWvr"));
    policyWaiverSaveSI.setNbrWvrUnit(ContextHelper.getStringSafe(request, "nbrWvrUnit"));
    if (!ContextHelper.getStringSafe(request, "personIdForPullback").trim().equals("")) {
      if (waiverType.equals("WCS"))
        policyWaiverSaveSI.setPersonByIdWvrPrnUnableCnct(ContextHelper.getStringSafe(request, "personIdForPullback"));
      else if (waiverType.equals("WAS"))
        policyWaiverSaveSI.setPersonByIdWvrPryCust(ContextHelper.getStringSafe(request, "personIdForPullback"));
    }
    if (!ContextHelper.getStringSafe(request, "resourceIdForPullback").trim().equals("")) {
      policyWaiverSaveSI.setCapsResource(ContextHelper.getStringSafe(request, "resourceIdForPullback"));
    }

    policyWaiverSaveSI
                      .setDtDtWvrExprtn(DateHelper
                                                  .toJavaDate(ContextHelper.getCastorDateSafe(request, "dtDtWvrExprtn")));

    policyWaiverSaveSI.setSzTxtWvrComments(ContextHelper.getStringSafe(request, "txtSzTxtWvrComments"));
    policyWaiverSaveSI.setROWCCMN01UIG00(policyWaiverEvent);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return policyWaiverSaveSI;
  }

  /**
   * Delete policy waiver
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void deletePolicyWaiver_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deletePolicyWaiver_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    PolicyWaiverDeleteSI policyWaiverDeleteSI = new PolicyWaiverDeleteSI();
    policyWaiverDeleteSI.setIdWvrEvent(GlobalData.getUlIdEvent(request));

    save(context, ServiceConstants.REQ_FUNC_CD_DELETE, SAVE);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Demonstrates the pattern for populating SI objects from the context. All population from the context (including
   * request, session, and state), should take place in private methods like this one. The method should instantiate the
   * input object, get values out of the context, and then return the SI object.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  private PolicyWaiverRetrieveSI populatePolicyWaiverRetrieveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateRetrievePolicyWaiverSI");
    performanceTrace.enterScope();

    // Get the state and request objects, if necessary.
    HttpServletRequest request = context.getRequest();

    // The input object.
    PolicyWaiverRetrieveSI policyWaiverRetrieveSI = new PolicyWaiverRetrieveSI();

    // Populate the input object sub-structures from the request, then populate the input object form the request.
    // Use GlobalData when practical.
    policyWaiverRetrieveSI.setIdWvrEvent(GlobalData.getUlIdEvent(request));
    policyWaiverRetrieveSI.setPageMode(PageMode.getPageMode(request));
    policyWaiverRetrieveSI.setIdStage(GlobalData.getUlIdStage(request));
    //MR-075 Need to get waiver type on click on Continue to calculate dates
    policyWaiverRetrieveSI.setCdWvrType(ContextHelper.getStringSafe(request, "selCdWvrType"));

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return policyWaiverRetrieveSI;
  }

  /**
   * Demonstrates an actual service call pattern. Populates CRES03SI, calls the service, and puts CRES03SO on the
   * request. Used as a retrieve method call for the DetailTemplate.jsp pattern of this method should be the general
   * pattern for all methods that call services. A good description would be as follows: <p/> This service calls the
   * RetrieveResourceDetail service to get details about a resource baseds on its id. It retrieves the id resource in
   * question from GlobalData.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void exampleServiceCall_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayResourceList_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    try {
      // Create the input object.
      // CRES03SI cres03si = populateCRES03SI_Retrieve(context);
      // Call the service method from the EJB interface.
      // CRES03SO cres03so = resource.retrieveResourceDetail(cres03si);
      // Put output object on the request and return to the controller
      // request.setAttribute("CRES03SO", cres03so);

    } catch (ServiceException se) {
      // switch the response based on the Service Returned Error Code
      switch (se.getErrorCode()) {
      case Messages.MSG_NO_DUP_LB_ROW:
        // Set a presentation branch to use a differnt JSP or header.
        setPresentationBranch("duplicateRecord", context);
        // Look up an error message.
        String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_NO_DUP_LB_ROW);
        // Set an error message.
        setErrorMessage(errorMessage, "/resource/ResourceSearch/results", request);
        break;
      default:
        // Handle unknown errors.
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
        processSevereException(context, se);
        break;
      }
    } catch (Exception e) {
      // This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SYS_MULT_INST:
      setErrorMessage(we.getErrorCode(), request);
      break;
    default:
      if (we.getErrorCode() != 0) {
        setErrorMessage(we.getErrorCode(), request);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
      break;
    }
  }

  /**
   * Initialize request to call PersonList Pullback (from PolicyWaiver.jsp)
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void retrievePerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "retrievePerson_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      PolicyWaiverRetrieveSO policyWaiverRetrieveSO = (PolicyWaiverRetrieveSO) state
                                                                                    .getAttribute(
                                                                                                  "PolicyWaiverRetrieveSO",
                                                                                                  request);
      if (policyWaiverRetrieveSO == null) {
        policyWaiverRetrieveSO = new PolicyWaiverRetrieveSO();
      }

      policyWaiverRetrieveSO.setSzCdWvrType(ContextHelper.getStringSafe(request, "selCdWvrType"));
      policyWaiverRetrieveSO.setSzCdWvrReason(ContextHelper.getStringSafe(request, "selCdWvrReason"));
      policyWaiverRetrieveSO.setDtDtWvrExprtn(DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request,
                                                                                                    "dtDtWvrExprtn")));
      policyWaiverRetrieveSO.setSzTxtWvrComments(ContextHelper.getStringSafe(request, "txtSzTxtWvrComments"));

      policyWaiverRetrieveSO.setMnthWvrCtct(ContextHelper.getStringSafe(request, "mnthWvrCtct"));
      policyWaiverRetrieveSO.setYrWvrCtct(ContextHelper.getStringSafe(request, "yrWvrCtct"));
      policyWaiverRetrieveSO.setPersonByIdWvrPrnUnableCnct(ContextHelper.getStringSafe(request,
                                                                                       "personByIdWvrPrnUnableCnct"));
      policyWaiverRetrieveSO.setTxtWvrOther(ContextHelper.getStringSafe(request, "txtWvrOther"));
      policyWaiverRetrieveSO.setCdWvrJustification(ContextHelper.getStringSafe(request, "cdWvrJustification"));
      policyWaiverRetrieveSO.setTxtWvrCapacity(ContextHelper.getString(request, "txtWvrCapacity"));
      policyWaiverRetrieveSO.setDtWvrBegin(ContextHelper.getJavaDateSafe(request, "dtWvrBegin"));
      policyWaiverRetrieveSO.setDtWvrEnd(ContextHelper.getJavaDateSafe(request, "dtWvrEnd"));
      policyWaiverRetrieveSO.setTxtSlpArngmts(ContextHelper.getStringSafe(request, "txtSlpArngmts"));
      policyWaiverRetrieveSO.setAmtAppPrdm(ContextHelper.getDoubleSafe(request, "amtAppPrdm"));
      policyWaiverRetrieveSO.setCdWvrAuthCounty(ContextHelper.getStringSafe(request, "cdWvrAuthCounty"));
      policyWaiverRetrieveSO.setCdWvrPmtCounty(ContextHelper.getStringSafe(request, "cdWvrAuthCounty"));
      policyWaiverRetrieveSO.setCdWvrUasCd(ContextHelper.getStringSafe(request, "cdWvrUasCd"));
      policyWaiverRetrieveSO.setCdWvrEntCd(ContextHelper.getStringSafe(request, "cdWvrEntCd"));
      policyWaiverRetrieveSO.setCdWvrSvcDesc(ContextHelper.getStringSafe(request, "cdWvrSvcDesc"));
      policyWaiverRetrieveSO.setPersonByIdWvrPryCust(ContextHelper.getStringSafe(request, "personByIdWvrPryCust"));
      policyWaiverRetrieveSO.setCapsResource(ContextHelper.getStringSafe(request, "capsResource"));
      policyWaiverRetrieveSO.setAmtWvr(ContextHelper.getDoubleSafe(request, "amtWvr"));
      policyWaiverRetrieveSO.setNbrWvrUnit(ContextHelper.getDoubleSafe(request, "nbrWvrUnit"));
      state.setAttribute("PolicyWaiverRetrieveSO", policyWaiverRetrieveSO, request);

      PersonListPullBackInfo personListPullBackInfo = new PersonListPullBackInfo();
      personListPullBackInfo.setDestinationUrl("/investigation/PolicyWaiver/setPerson");
      request.setAttribute(PERSON_LIST_PULLBACK_INFO, personListPullBackInfo);
      state.setAttribute("ACTUAL_PAGE_MODE", PageMode.getPageMode(request), request);
      PageMode.setPageMode("S", request);

      forward(URL_PERSON_LIST, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Final method in the pullback process.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void setPerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "setPerson_xa");
    HttpServletRequest request = context.getRequest();

    try {
      BaseSessionStateManager state = getSessionStateManager(request);
      PolicyWaiverRetrieveSO policyWaiverRetrieveSO = (PolicyWaiverRetrieveSO) state
                                                                                    .getAttribute(
                                                                                                  "PolicyWaiverRetrieveSO",
                                                                                                  request);

      populatePerson(request, policyWaiverRetrieveSO);
      PageMode.setPageMode((String) state.getAttribute("ACTUAL_PAGE_MODE", request), request);
      request.setAttribute("PolicyWaiverRetrieveSO", policyWaiverRetrieveSO);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  public void retrieveResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "retrievePerson_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      PolicyWaiverRetrieveSO policyWaiverRetrieveSO = (PolicyWaiverRetrieveSO) state
                                                                                    .getAttribute(
                                                                                                  "PolicyWaiverRetrieveSO",
                                                                                                  request);
      if (policyWaiverRetrieveSO == null) {
        policyWaiverRetrieveSO = new PolicyWaiverRetrieveSO();
      }

      policyWaiverRetrieveSO.setSzCdWvrType(ContextHelper.getStringSafe(request, "selCdWvrType"));
      policyWaiverRetrieveSO.setSzCdWvrReason(ContextHelper.getStringSafe(request, "selCdWvrReason"));
      policyWaiverRetrieveSO.setDtDtWvrExprtn(DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request,
                                                                                                    "dtDtWvrExprtn")));
      policyWaiverRetrieveSO.setSzTxtWvrComments(ContextHelper.getStringSafe(request, "txtSzTxtWvrComments"));
      policyWaiverRetrieveSO.setCdWvrJustification(ContextHelper.getStringSafe(request, "cdWvrJustification"));
      policyWaiverRetrieveSO.setTxtWvrCapacity(ContextHelper.getString(request, "txtWvrCapacity"));
      policyWaiverRetrieveSO.setMnthWvrCtct(ContextHelper.getStringSafe(request, "mnthWvrCtct"));
      policyWaiverRetrieveSO.setYrWvrCtct(ContextHelper.getStringSafe(request, "yrWvrCtct"));
      policyWaiverRetrieveSO.setPersonByIdWvrPrnUnableCnct(ContextHelper.getStringSafe(request,
                                                                                       "personByIdWvrPrnUnableCnct"));
      policyWaiverRetrieveSO.setTxtWvrOther(ContextHelper.getStringSafe(request, "txtWvrOther"));
      policyWaiverRetrieveSO.setTxtWvrCapacity(ContextHelper.getString(request, "txtWvrCapacity"));
      policyWaiverRetrieveSO.setDtWvrBegin(ContextHelper.getJavaDateSafe(request, "dtWvrBegin"));
      policyWaiverRetrieveSO.setDtWvrEnd(ContextHelper.getJavaDateSafe(request, "dtWvrEnd"));
      policyWaiverRetrieveSO.setTxtSlpArngmts(ContextHelper.getStringSafe(request, "txtSlpArngmts"));
      policyWaiverRetrieveSO.setAmtAppPrdm(ContextHelper.getDoubleSafe(request, "amtAppPrdm"));
      policyWaiverRetrieveSO.setCdWvrAuthCounty(ContextHelper.getStringSafe(request, "cdWvrAuthCounty"));
      policyWaiverRetrieveSO.setCdWvrPmtCounty(ContextHelper.getStringSafe(request, "cdWvrAuthCounty"));
      policyWaiverRetrieveSO.setCdWvrUasCd(ContextHelper.getStringSafe(request, "cdWvrUasCd"));
      policyWaiverRetrieveSO.setCdWvrEntCd(ContextHelper.getStringSafe(request, "cdWvrEntCd"));
      policyWaiverRetrieveSO.setCdWvrSvcDesc(ContextHelper.getStringSafe(request, "cdWvrSvcDesc"));
      policyWaiverRetrieveSO.setPersonByIdWvrPryCust(ContextHelper.getStringSafe(request, "personByIdWvrPryCust"));
      policyWaiverRetrieveSO.setCapsResource(ContextHelper.getStringSafe(request, "capsResource"));
      policyWaiverRetrieveSO.setAmtWvr(Double.parseDouble(ContextHelper.getStringSafe(request, "amtWvr")));
      policyWaiverRetrieveSO.setNbrWvrUnit(Double.parseDouble(ContextHelper.getStringSafe(request, "nbrWvrUnit")));
      policyWaiverRetrieveSO.setPersonIdForPullback(ContextHelper.getStringSafe(request, "personIdForPullback"));
      policyWaiverRetrieveSO.setResourceIdForPullback(ContextHelper.getStringSafe(request, "resourceIdForPullback"));

      state.setAttribute("PolicyWaiverRetrieveSO", policyWaiverRetrieveSO, request);

      ResourceSearchPullBackInfo resourceSearchPullBackInfo = new ResourceSearchPullBackInfo();
      resourceSearchPullBackInfo.setDestinationUrl("/investigation/PolicyWaiver/setResource");
      request.setAttribute(RESOURCE_PULLBACK_INFO, resourceSearchPullBackInfo);
      request.setAttribute("destinationUrl", resourceSearchPullBackInfo.getDestinationUrl());
      
      state.setAttribute("ACTUAL_PAGE_MODE", PageMode.getPageMode(request), request);
      PageMode.setPageMode("S", request);

      forward(URL_RESOURCE_SEARCH_LIST, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Final method in the pullback process.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void setResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "setResource_xa");
    HttpServletRequest request = context.getRequest();

    try {
      BaseSessionStateManager state = getSessionStateManager(request);
      PolicyWaiverRetrieveSO policyWaiverRetrieveSO = (PolicyWaiverRetrieveSO) state
                                                                                    .getAttribute(
                                                                                                  "PolicyWaiverRetrieveSO",
                                                                                                  request);

      populateResource(request, policyWaiverRetrieveSO);
      PageMode.setPageMode((String) state.getAttribute("ACTUAL_PAGE_MODE", request), request);
      request.setAttribute("PolicyWaiverRetrieveSO", policyWaiverRetrieveSO);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Populates personId and personFullName in PolicyWaiverRetrieveSO when PolicyWaiverDetail is returned to from
   * PersonList
   * 
   * @param request
   *          HttpServletRequest
   * @param policyWaiverRetrieveSO
   *          PolicyWaiverRetrieveSO
   */
  protected static void populatePerson(HttpServletRequest request, PolicyWaiverRetrieveSO policyWaiverRetrieveSO) {
    PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) request
                                                                                    .getAttribute(PERSON_LIST_PULLBACK_INFO);
    if (personListPullBackInfo == null) {
      return;
    }
    ROWCINV01SOG00 row = personListPullBackInfo.getPersonListRow();
    if (row == null) {
      return;
    }
    request.removeAttribute(PERSON_LIST_PULLBACK_INFO);

    policyWaiverRetrieveSO.setPersonIdForPullback(String.valueOf(row.getUlIdPerson()));

    String waiverType = policyWaiverRetrieveSO.getSzCdWvrType();
    if (waiverType.equals("WIV"))
      ;
    else if (waiverType.equals("WCS")) {
      policyWaiverRetrieveSO.setPersonByIdWvrPrnUnableCnct(row.getSzNmPersonFull());
    } else if (waiverType.equals("WAS")) {
      policyWaiverRetrieveSO.setPersonByIdWvrPryCust(row.getSzNmPersonFull());
    } else if (waiverType.equals("WCL"))
      ;
    else if (waiverType.equals("WPW"))
      ;
    else if (waiverType.equals("WLC"))
      ;
  }

  /**
   * Populates personId and personFullName in PolicyWaiverRetrieveSO when PolicyWaiverDetail is returned to from
   * PersonList
   * 
   * @param request
   *          HttpServletRequest
   * @param policyWaiverRetrieveSO
   *          PolicyWaiverRetrieveSO
   */
  protected static void populateResource(HttpServletRequest request, PolicyWaiverRetrieveSO policyWaiverRetrieveSO) {
    CRES03SO cres03so = (CRES03SO) request.getAttribute(RESOURCE_PULLBACK_INFO);
    if (cres03so == null) {
      return;
    }
    request.removeAttribute(RESOURCE_PULLBACK_INFO);

    policyWaiverRetrieveSO.setResourceIdForPullback(String.valueOf(cres03so.getUlIdResource()));
    policyWaiverRetrieveSO.setCapsResource(String.valueOf(cres03so.getSzNmResource()));
  }
  
  /**
   * Calculate and populate 30 Day Grace Period Waiver dates.
   * 
   * @param request
   * @param policyWaiverSaveSI
   */
  private void populate30GracePeriodWaiverDates(HttpServletRequest request, PolicyWaiverSaveSI policyWaiverSaveSI){
    List<String> cdCurrentHomeStatuses = new ArrayList<String>();
    cdCurrentHomeStatuses.add(CodesTables.CFAHMSTA_PUN);
    cdCurrentHomeStatuses.add(CodesTables.CFAHMSTA_AUN);
    
    List<String> cdLastApprovedHomeStatuses = new ArrayList<String>();
    cdLastApprovedHomeStatuses.add(CodesTables.CFAHMSTA_AFA);
    cdLastApprovedHomeStatuses.add(CodesTables.CFAHMSTA_ASA);
    cdLastApprovedHomeStatuses.add(CodesTables.CFAHMSTA_ATA);
    cdLastApprovedHomeStatuses.add(CodesTables.CFAHMSTA_CSD);

    List<String> cdGraceHomeStatuses = new ArrayList<String>();
    cdGraceHomeStatuses.add(CodesTables.CFAHMSTA_FLG);
    cdGraceHomeStatuses.add(CodesTables.CFAHMSTA_FSG);

    FadHomeRetrieveSO fadHomeRetrieveSO = caseMgmt.retrieveFadHomeByIdStage(GlobalData.getUlIdStage(request));
    
    if( fadHomeRetrieveSO != null){
      // current home is one of the following status
      if(cdCurrentHomeStatuses.contains(fadHomeRetrieveSO.getSzCdRsrcFaHomeStatus())){
        int idResource = fadHomeRetrieveSO.getUlIdResource();
        
        // get date last status approved
        Date dtLastApprovedStatus = resource.retrieveHomeStatusLastApproval(idResource, cdLastApprovedHomeStatuses);
        // get date last grace status
        Date dtLastGraceStatus = resource.retrieveHomeStatusLastApproval(idResource, cdGraceHomeStatuses);
        
        // last grace status is after last approved status,
        // then this is a valid scenario...calculate and set dates
        if(dtLastApprovedStatus != null 
                        && dtLastGraceStatus != null 
                        && dtLastGraceStatus.compareTo(dtLastApprovedStatus) >= 0){
          policyWaiverSaveSI.setDtWvrBegin(DateHelper.addToDate(dtLastGraceStatus, 0, 0, 61));
          policyWaiverSaveSI.setDtWvrEnd(DateHelper.addToDate(dtLastGraceStatus, 0, 0, 90));
        }else{
          // last approved status is later then last grace episode,
          // so no calculated dates ... waiver not needed.
          policyWaiverSaveSI.setDtWvrBegin(null);
          policyWaiverSaveSI.setDtWvrEnd(null);
        }
      }else{
        // current status is not Pending Unapproved or Unapproved status
        // then don't calculate dates...waiver not needed
        policyWaiverSaveSI.setDtWvrBegin(null);
        policyWaiverSaveSI.setDtWvrEnd(null);
      }
    }else{
      // this should never happen,
      // but just in case don't calculate dates
      policyWaiverSaveSI.setDtWvrBegin(null);
      policyWaiverSaveSI.setDtWvrEnd(null);
    }
  }
}