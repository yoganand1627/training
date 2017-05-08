package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveWTLP;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveWTLP;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCGSSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCarePartBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareParticipantSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GoalsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StepBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCGSRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareParticipantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PaymentOfCareRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.WTLPRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/*
 * Used to handle WTLP (Written Transitional Living Plan) functions and procedures
 * 
 * @author Steven Thrasher, December 19, 2006
 */

@SuppressWarnings("serial")
public class WTLPConversation extends BaseHiddenFieldStateConversation {

  public static final String ID_EVENT = "ulIdEvent";

  public static final String CD_TASK = "szCdTask";

  public static final String ID_STAGE = "ulIdStage";

  public static final String CASE_PLAN = "I";

  public static final String CASE_REVIEW = "R";

  public static final String TEMPORARY = "TEM";

  public static final String PERMANENT = "PER";

  public static final String VOLUNTARY = "VOL";

  public static final String WTLP_INFORMATION = "subcare/WTLP/WTLPConversation";

  public static final String PLAN_TYPE = "scrIndPlanType";

  public static final String SAVE_BUTTON_ON_WTLP_PAGE = "btnSave";

  public static final String SAVE_SUBMIT_ON_WTLP = "btnSaveAndSubmit";

  public static final String WTLP_EVENT_DESC = "Written Transitional Living Plan";

  public static final String TXT_COORD_NAME = "idYdpCoord";

  public static final String TXT_YDP_COORD = "txtYdpCoordInfo";

  private InvalidateApproval invalidateApproval = null;

  public static final String TXT_WTLP_DATE = "txtWTLPDate";

  public static final String TXT_WTLP_DURATION_FROM = "txtDurationFrom";

  public static final String TXT_WTLP_DURATION_TO = "txtDurationTo";

  public static final String IND_AUTH_PLACE = "scrIndAuthPlac";

  public static final String DESCR_VOL_WITH = "descrVolW";

  public static final String ARRAY_TYPES_OF_GOALS = "chkbxTypesOfGoals";

  public static final String TXT_STRENGTHS = "txtStrengths";

  public static final String TXT_NEEDS = "txtNeeds";

  public static final String RETRIEVESO = "RETRIEVE_WTLP_INFORMATION";

  private SaveWTLP saveWTLP;

  private RetrieveWTLP retrieveWTLP;

  private CaseMgmt casemgmt;

  private static final Map<String, String> APPROVAL_TASK_MAP = new HashMap<String, String>() {
    {
      // SUB
      put("9510", "9515");
      // STGAP00004435 - added approval task code for stage ADO and PFC
      put("9500", "9495");
      put("8580", "8575");
      // end STGAP00004435
    }
  };

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setSaveWTLP(SaveWTLP saveWTLP) {
    this.saveWTLP = saveWTLP;
  }

  public void setRetrieveWTLP(RetrieveWTLP retrieveWTLP) {
    this.retrieveWTLP = retrieveWTLP;
  }

  /*
   * The display method determines what data is sent to the JSP page and what the pagemode of the JSP should be.
   */
  public void displayWTLP_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayWTLP_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    boolean btnNewUsing = ContextHelper.getIntSafe(request, "NewUsing.x") != 0;
    String name = GlobalData.getSzNmStage(request);
    String task = GlobalData.getSzCdTask(request);
    String county = CaseUtility.getCounty(GlobalData.getUlIdCaseAsString(request));
    UserProfile user = UserProfileHelper.getUserProfile(request);
    // boolean invalidateMessageIsAlreadyInRequest = false;
    boolean invalidateMessageIsAlreadyInRequest = (Object) state.getAttribute("INVALID_MSG_IN_RQST", request) == null ? false
                                                                                                                     : (Boolean) state
                                                                                                                                      .getAttribute(
                                                                                                                                                    "INVALID_MSG_IN_RQST",
                                                                                                                                                    request);

    try {
      // Preserve the value of PageMode because Event List will send PageMode
      // NEW when the user clicks 'Add' on the Event List to create a new WTLP.
      // event list sets page mode
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      // state.removeAllAttributes(request);

      Boolean rights = hasStageAccessRights(context);

      // if there is no eventId the page is New
      if (GlobalData.getUlIdEvent(request) == 0 && rights == true) {
        pageMode = PageModeConstants.NEW;
        PageMode.setPageMode(pageMode, request);
      }

      if (GlobalData.getUlIdEvent(request) > 0) {
        WTLPRetrieveSI retrieveSI = this.populate_Retrieve(GlobalData.getUlIdEvent(request));
        WTLPRetrieveSO retrieveSO = new WTLPRetrieveSO();
        retrieveSO = retrieveWTLP.retrieveWTLPdetail(retrieveSI);
        retrieveSO.setSzNmStage(name);
        retrieveSO.setUserId(userID);
        if (user.getUserID() == retrieveSO.getIdYdpCoord()) {
          rights = true;
        }

        if (CodesTables.CEVTSTAT_PEND.equals(retrieveSO.getCdEventStatus())
            && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
          if (!invalidateMessageIsAlreadyInRequest) {
            setInformationalMessage(Messages.MSG_FP_INVLD_APRVL, request);
            setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
            invalidateMessageIsAlreadyInRequest = true;
          }
        }
        // set PageMode based on event status of WTLP selected or if Copy button was clicked
        if (PageModeConstants.NEW_USING.equals(pageMode)) {
          retrieveSO.setIdEvent(0);
        } else if (CodesTables.CEVTSTAT_APRV.equals(retrieveSO.getCdEventStatus())) {
          pageMode = PageModeConstants.VIEW;
        } else if (rights) {
          pageMode = PageModeConstants.EDIT;
        } else {
          pageMode = PageModeConstants.VIEW;
        }
        GlobalData.setUlIdEvent(retrieveSO.getIdEvent(), request);
        PageMode.setPageMode(pageMode, request);
        if ("fcgs".equals(request.getAttribute("FCGS"))) {
          PageMode.setPageMode(PageModeConstants.EDIT, request);
        }
        retrieveSO.setSzCdTask(task);
        state.setAttribute(RETRIEVESO, retrieveSO, request);

        GlobalData.setSzNmStage(name, request);
        GlobalData.setUlIdCase(retrieveSO.getCaseId(), request);
        GlobalData.setSzCdCounty(county, request);
      }
      if (btnNewUsing) {
        setInformationalMessage(Messages.MSG_SAVE_BEFORE_NAV, request);
      }
      state.setAttribute("WTLP_COPY_CLICKED", btnNewUsing, request);
      state.setAttribute("INVALID_MSG_IN_RQST", invalidateMessageIsAlreadyInRequest, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /*
   * The populateWTLP_Save method pulls the information from the JSP into a WTLPSaveSI object. This method is called by
   * the Save and SaveAndSubmit methods.
   */
  private WTLPSaveSI populateWTLP_Save(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateWTLP_Save()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    WTLPSaveSI wtlpSave = new WTLPSaveSI();
    int idEvent = ContextHelper.getIntSafe(request, "ulIdEvent");

    WTLPRetrieveSO wtlpFromState = (WTLPRetrieveSO) state.getAttribute(RETRIEVESO, request);

    // Determine for each field if data was entered and put that data into the object
    if (request.getParameter(PLAN_TYPE) != null && !"".equals(request.getParameter(PLAN_TYPE))) {
      wtlpSave.setSzPlanType(ContextHelper.getStringSafe(request, PLAN_TYPE));
    }

    if (request.getParameter(TXT_COORD_NAME) != null && !"".equals(request.getParameter(TXT_COORD_NAME))) {
      wtlpSave.setIdYdpCoord(ContextHelper.getIntSafe(request, TXT_COORD_NAME));
    }

    if (request.getParameter(TXT_YDP_COORD) != null && !"".equals(request.getParameter(TXT_YDP_COORD))) {
      wtlpSave.setYdpCoordInfo(ContextHelper.getStringSafe(request, TXT_YDP_COORD));
    }

    if (request.getParameter(TXT_WTLP_DATE) != null && !"".equals(request.getParameter(TXT_WTLP_DATE))) {
      wtlpSave.setWTLPDate(ContextHelper.getJavaDateSafe(request, TXT_WTLP_DATE));
    }

    if (request.getParameter(TXT_WTLP_DURATION_FROM) != null
        && !"".equals(request.getParameter(TXT_WTLP_DURATION_FROM))) {
      wtlpSave.setWTLPDateFrom(ContextHelper.getJavaDateSafe(request, TXT_WTLP_DURATION_FROM));
    }

    if (request.getParameter(TXT_WTLP_DURATION_TO) != null && !"".equals(request.getParameter(TXT_WTLP_DURATION_TO))) {
      wtlpSave.setWTLPDateTo(ContextHelper.getJavaDateSafe(request, TXT_WTLP_DURATION_TO));
    }

    if (request.getParameter(IND_AUTH_PLACE) != null && !"".equals(request.getParameter(IND_AUTH_PLACE))) {
      wtlpSave.setSzPlcmtAuth(ContextHelper.getStringSafe(request, IND_AUTH_PLACE));
    }

    if (request.getParameter(DESCR_VOL_WITH) != null && !"".equals(request.getParameter(DESCR_VOL_WITH))) {
      wtlpSave.setSzVoluntary(ContextHelper.getStringSafe(request, DESCR_VOL_WITH));
    }

    if (request.getParameter(TXT_STRENGTHS) != null && !"".equals(request.getParameter(TXT_STRENGTHS))) {
      wtlpSave.setSzStrengths(ContextHelper.getStringSafe(request, TXT_STRENGTHS));
    }

    if (request.getParameter(TXT_NEEDS) != null && !"".equals(request.getParameter(TXT_NEEDS))) {
      wtlpSave.setSzNeeds(ContextHelper.getStringSafe(request, TXT_NEEDS));
    }

    String[] goalArray = CheckboxHelper.getCheckedValues(request, ARRAY_TYPES_OF_GOALS);
    wtlpSave.setTypesOfGoals(goalArray);

    ROWCCMN01UIG00 rowccmn01uigoo = new ROWCCMN01UIG00();
    if (!GlobalData.isApprovalMode(request)) {
      rowccmn01uigoo.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
    } else {
      rowccmn01uigoo.setSzCdEventStatus(wtlpFromState.getCdEventStatus());
    }

    // Set the important page data that was not user entered data.
    wtlpSave.setIdPerson(user.getUserID());
    wtlpSave.setSzNmStage(ContextHelper.getIntSafe(request, "ulIdStage"));
    wtlpSave.setIdEvent(idEvent);
    wtlpSave.setSzCdTask(ContextHelper.getStringSafe(request, "szCdTask"));

    rowccmn01uigoo.setSzCdEventType(CodesTables.CEVNTTYP_WTL);

    String WTLP_TASK_CODE = GlobalData.getSzCdTask(request);
    rowccmn01uigoo.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    rowccmn01uigoo.setUlIdEvent(idEvent);
    rowccmn01uigoo.setSzCdTask(WTLP_TASK_CODE);
    rowccmn01uigoo.setUlIdPerson(user.getUserID());
    rowccmn01uigoo.setUlIdStage(ContextHelper.getIntSafe(request, "ulIdStage"));
    rowccmn01uigoo.setSzTxtEventDescr(WTLP_EVENT_DESC);

    wtlpSave.setRowccmn01uig00(rowccmn01uigoo);

    return wtlpSave;
  }

  /*
   * The saveAndSubmit method performs the same function as the Save method plus the saveAndSubmit method sets the event
   * status to PEND and sets the Todo
   */
  public void saveAndSubmitWTLP_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAndSubmitWTLP_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    WTLPRetrieveSO retrieveSO = (WTLPRetrieveSO) state.getAttribute(RETRIEVESO, request);
    // STGAP00004875 - use this instead of page mode value since it could be reset to NEW in display
    boolean isNewUsing = (Boolean) state.getAttribute("WTLP_COPY_CLICKED", request);

    FCGSRetrieveSO fcgsretsoFromState = null;
    FosterCareParticipantRetrieveSO fosterCareListFromState = null;
    boolean saveGoalsBean = false;
    boolean savePartListBean = false;

    if (isNewUsing) {
      // set to save non/reuification goals
      fcgsretsoFromState = (FCGSRetrieveSO) state.getAttribute("FCGSRetrieveSO", request);
      List<GoalsBean> goalsBeanList = fcgsretsoFromState.getGoalBeanList();
      if (goalsBeanList != null && !goalsBeanList.isEmpty()) {
        saveGoalsBean = true;
      }
      // set to save participant list
      fosterCareListFromState = (FosterCareParticipantRetrieveSO) state.getAttribute("fosterCareList", request);
      List<FosterCarePartBean> fosterCarePartList = fosterCareListFromState.getFosterCarePartList();
      if (fosterCarePartList != null && !fosterCarePartList.isEmpty()) {
        savePartListBean = true;
      }
    }
    // end STGAP00004875

    try {
      if (CodesTables.CEVTSTAT_PEND.equals(retrieveSO.getCdEventStatus())
          && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
        CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(GlobalData.getUlIdEvent(request));
        invalidateApproval.invalidateApproval(ccmn05ui);
        // STGAP00004875: if there is submodule data, save WTLP will call submodule save service
        // Submodule save service has code to invalidate a WTLP if plan is in PEND, set event status back to PROC
        // here so InvalidateApproval won't be called again and again while saving submodule data (and throwing SQL not
        // found exception since it can't find the approval event)
        retrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
      }
      WTLPSaveSI WTLPSave = this.populateWTLP_Save(context);
      WTLPSave.getRowccmn01uig00().setSzCdEventStatus("PEND");
      WTLPSaveSI WTLPRetrieve = saveWTLP.saveWtlp(WTLPSave);

      // STGAP00004875
      // save non/reuification goals
      int idEvent = WTLPRetrieve.getIdEvent();
      if (saveGoalsBean && idEvent > 0) {
        saveFCGSBean(fcgsretsoFromState, idEvent, context);
      }
      // save participant list
      if (savePartListBean && idEvent > 0) {
        saveFosterCareParticipant(fosterCareListFromState, idEvent, context);
      }
      // end STGAP00004875

      // Put the WTLP event id into GlobalData in case the WTLP was newly saved
      // to the database.
      GlobalData.setUlIdEvent(WTLPRetrieve.getIdEvent(), request);

      int ulIdEvent = WTLPSave.getIdEvent();
      int ulIdCase = GlobalData.getUlIdCase(request);
      int ulIdStage = WTLPSave.getSzNmStage();
      String szCdTask = APPROVAL_TASK_MAP.get(WTLPSave.getSzCdTask());
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ulIdEvent, ulIdCase, ulIdStage, szCdTask);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
    } catch (ServiceException wtc) {
      handleError(wtc, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /*
   * Populates the WTLPRetrieveSI object
   */
  private WTLPRetrieveSI populate_Retrieve(int eventId) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populate_Retrieve()");
    performanceTrace.enterScope();

    WTLPRetrieveSI wtlpRetrieve = new WTLPRetrieveSI();
    wtlpRetrieve.setIdEvent(eventId);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return wtlpRetrieve;
  }

  /*
   * The save method saves the information entered by the user and changes the event status from NEW to PROC.
   */
  public void saveWTLP_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveWTLP_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    WTLPRetrieveSO retrieveSO = (WTLPRetrieveSO) state.getAttribute(RETRIEVESO, request);
    // STGAP00004875 - use this instead of page mode value since it could be reset to NEW in display
    boolean isNewUsing = (Boolean) state.getAttribute("WTLP_COPY_CLICKED", request);

    FCGSRetrieveSO fcgsretsoFromState = null;
    FosterCareParticipantRetrieveSO fosterCareListFromState = null;
    boolean saveGoalsBean = false;
    boolean savePartListBean = false;

    if (isNewUsing) {
      // set to save non/reuification goals
      fcgsretsoFromState = (FCGSRetrieveSO) state.getAttribute("FCGSRetrieveSO", request);
      List<GoalsBean> goalsBeanList = fcgsretsoFromState.getGoalBeanList();
      if (goalsBeanList != null && !goalsBeanList.isEmpty()) {
        saveGoalsBean = true;
      }
      // set to save participant list
      fosterCareListFromState = (FosterCareParticipantRetrieveSO) state.getAttribute("fosterCareList", request);
      List<FosterCarePartBean> fosterCarePartList = fosterCareListFromState.getFosterCarePartList();
      if (fosterCarePartList != null && !fosterCarePartList.isEmpty()) {
        savePartListBean = true;
      }
    }
    // end STGAP00004875

    try {
      if (retrieveSO != null && CodesTables.CEVTSTAT_PEND.equals(retrieveSO.getCdEventStatus())
          && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
        CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(GlobalData.getUlIdEvent(request));
        invalidateApproval.invalidateApproval(ccmn05ui);
        // STGAP00004875: if there is submodule data, save WTLP will call submodule save service
        // Submodule save service has code to invalidate a WTLP if plan is in PEND, set event status back to PROC
        // here so InvalidateApproval won't be called again and again while saving submodule data (and throwing SQL not
        // found exception since it can't find the approval event)
        retrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
      }
      WTLPSaveSI WTLPSave = this.populateWTLP_Save(context);
      WTLPSaveSI WTLPRetrieve = saveWTLP.saveWtlp(WTLPSave);

      // Put the WTLP event id into GlobalData in case the WTLP was newly saved
      // to the database.
      GlobalData.setUlIdEvent(WTLPRetrieve.getIdEvent(), request);

      // Set the PageMode to MODIFY in case in was ADD before the save.
      PageMode.setPageMode(PageModeConstants.MODIFY, request);

      // STGAP00004875
      // save non/reuification goals
      int idEvent = WTLPRetrieve.getIdEvent();
      if (saveGoalsBean && idEvent > 0) {
        saveFCGSBean(fcgsretsoFromState, idEvent, context);
      }
      // save participant list
      if (savePartListBean && idEvent > 0) {
        saveFosterCareParticipant(fosterCareListFromState, idEvent, context);
      }
      // end STGAP00004875

    } catch (ServiceException wtc) {
      handleError(wtc, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private CCMN05UI populateCCMN05UI_InvalidateApproval(int idEvent) {

    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct input = new ArchInputStruct();

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlSysNbrReserved1(ArchitectureConstants.N);

    ccmn05ui.setUlIdEvent(idEvent);
    ccmn05ui.setArchInputStruct(input);

    return ccmn05ui;
  }

  /*
   * Temporarily saves the state of data on the WTLP page then forwards to the Staff Search page. When the user returns
   * to the WTLP all page data is still entered.
   */
  public void performStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performStaffSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    WTLPRetrieveSO retrieveSO = new WTLPRetrieveSO();

    int idEvent = ContextHelper.getIntSafe(request, ID_EVENT);
    retrieveSO.setSzPlanType(ContextHelper.getStringSafe(request, PLAN_TYPE));
    retrieveSO.setIdYdpCoord(ContextHelper.getIntSafe(request, TXT_COORD_NAME));
    retrieveSO.setWTLPDate(ContextHelper.getJavaDateSafe(request, TXT_WTLP_DATE));
    retrieveSO.setWTLPDateFrom(ContextHelper.getJavaDateSafe(request, TXT_WTLP_DURATION_FROM));
    retrieveSO.setWTLPDateTo(ContextHelper.getJavaDateSafe(request, TXT_WTLP_DURATION_TO));
    retrieveSO.setSzPlcmtAuth(ContextHelper.getStringSafe(request, IND_AUTH_PLACE));
    retrieveSO.setSzVoluntary(ContextHelper.getStringSafe(request, DESCR_VOL_WITH));
    retrieveSO.setSzStrengths(ContextHelper.getStringSafe(request, TXT_STRENGTHS));
    retrieveSO.setSzNeeds(ContextHelper.getStringSafe(request, TXT_NEEDS));
    retrieveSO.setTypesOfGoals(CheckboxHelper.getCheckedValues(request, ARRAY_TYPES_OF_GOALS));
    retrieveSO.setIdEvent(idEvent);
    retrieveSO.setIdStage(ContextHelper.getIntSafe(request, ID_STAGE));
    retrieveSO.setSzCdTask(ContextHelper.getStringSafe(request, CD_TASK));

    state.setAttribute(RETRIEVESO, retrieveSO, request);

    StaffSearchInput io = new StaffSearchInput();
    io.setSourcePage(StaffSearchInput.OTHER);
    io.setDestinationUrl("/subcare/WTLP/setStaff");
    request.setAttribute("StaffSearchInput", io);

    // context and forward the user.
    try {
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (Exception o) {
      processSevereException(context, o);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method will retrieve the row object that the staff search sent to us and put the new data into the retrieveSO
   * object for display on the WTLP page.
   * 
   * @param context
   *          GrndsExchangeContext
   */
  public void setStaff_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setStaff_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    WTLPRetrieveSO retrieveSO = (WTLPRetrieveSO) state.getAttribute(RETRIEVESO, request);
    if (retrieveSO == null) {
      retrieveSO = new WTLPRetrieveSO();
    }

    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (ccmn50do_array == null) {
      ccmn50do_array = new ROWCCMN50DO_ARRAY();
    }

    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    if (e.hasMoreElements()) {
      ROWCCMN50DO staff = (ROWCCMN50DO) e.nextElement();
      retrieveSO.setNmYdpCoord(staff.getSzNmPersonFull());
      retrieveSO.setIdYdpCoord(staff.getUlIdPerson());
    }
    state.setAttribute(RETRIEVESO, retrieveSO, request);

    performanceTrace.exitScope();
  }

  /*
   * Checks to see if the user has rights to be on this page in view mode.
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

  /*
   * Handles the different errors that can potentially be caught on WTLP.
   */
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    String errorMessage = null;
    switch (we.getErrorCode()) {
    case Messages.MSG_CMN_OVERLAP_ADD:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_OVERLAP_ADD);
      setErrorMessage(errorMessage, WTLP_INFORMATION, request);
      break;
    case Messages.MSG_CMN_ON_CALL_TOO_MANY:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_ON_CALL_TOO_MANY);
      setErrorMessage(errorMessage, WTLP_INFORMATION, request);
      break;
    case Messages.MSG_SYS_STAGE_CLOSED:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
      setErrorMessage(errorMessage, WTLP_INFORMATION, request);
      break;
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
      setErrorMessage(errorMessage, WTLP_INFORMATION, request);
      break;
    case Messages.MSG_DATABASE_SAVE_FAIL:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_SAVE_FAIL);
      setErrorMessage(errorMessage, WTLP_INFORMATION, request);
      break;
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      setErrorMessage(errorMessage, WTLP_INFORMATION, request);
      break;
    case Messages.MSG_SYS_MULT_INST:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
      setErrorMessage(errorMessage, WTLP_INFORMATION, request);
      break;
    case Messages.MSG_DATABASE_RETRIEVE_FAIL:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      setErrorMessage(errorMessage, WTLP_INFORMATION, request);
      break;
    default:
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
      break;
    }
  }

  // STGAP00004875
  private void saveFCGSBean(FCGSRetrieveSO fcgsretsoFromState, int idEvent, GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveFCGSBean");
    performanceTrace.enterScope();

    try {
      List<GoalsBean> goalsBeanList = fcgsretsoFromState.getGoalBeanList();
      Iterator<GoalsBean> goalsBeanItr = goalsBeanList.iterator();
      while (goalsBeanItr.hasNext()) {
        GoalsBean goalsBean = goalsBeanItr.next();
        FCGSSaveSI fcgsSaveSI = populateFCGSSaveSI_Save(goalsBean, idEvent);
        casemgmt.updateFCGSInformation(fcgsSaveSI);
      }
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  // STGAP00004875
  private FCGSSaveSI populateFCGSSaveSI_Save(GoalsBean goalsBean, int idEvent) {
    FCGSSaveSI fcgsSaveSI = new FCGSSaveSI();
    GoalsBean glBean = new GoalsBean();
    List<StepBean> stepBeanList = new ArrayList<StepBean>();

    stepBeanList = goalsBean.getStepBeanList();
    glBean = goalsBean;
    glBean.setIdGoal(0);
    glBean.setCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    //STGAP00007028: Initial step Ids to zeros and set the data action to add.
    //Begin
    for(int i=0;i<stepBeanList.size();i++){
      if(stepBeanList.get(i)!=null){
        stepBeanList.get(i).setCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
        stepBeanList.get(i).setIdStep(0);
      }
    }
    //end
    glBean.setStepBeanList(stepBeanList);

    fcgsSaveSI.setGlBean(glBean);
    fcgsSaveSI.setUlIdEvent(idEvent);
    return fcgsSaveSI;
  }

  // STGAP00004875
  private void saveFosterCareParticipant(FosterCareParticipantRetrieveSO fosterCareListFromState, int idEvent,
                                         GrndsExchangeContext context) throws ServiceException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveFosterCareSecGoal");
    performanceTrace.enterScope();

    try {
      List<FosterCarePartBean> fosterCarePartList = fosterCareListFromState.getFosterCarePartList();
      Iterator<FosterCarePartBean> fosterCarePartListItr = fosterCarePartList.iterator();
      while (fosterCarePartListItr.hasNext()) {
        FosterCarePartBean goalsBean = fosterCarePartListItr.next();
        FosterCareParticipantSaveSI fcpSave = new FosterCareParticipantSaveSI();
        fcpSave.setDtApprv(goalsBean.getDtApprv());
        fcpSave.setDtPart(goalsBean.getDtPart());
        fcpSave.setDtSigned(goalsBean.getDtSigned());
        fcpSave.setIdEvent(idEvent);
        fcpSave.setIdPerson(goalsBean.getIdPerson());
        fcpSave.setIdPlanPart(0);
        fcpSave.setIndApproval(goalsBean.getIndApproval());
        fcpSave.setSzCdPartType(goalsBean.getSzCdPartType());
        fcpSave.setSzCdRelInt(goalsBean.getSzCdRelInt());
        fcpSave.setSzNmPart(goalsBean.getSzNmPart());
        fcpSave.setTxtNoApprv(goalsBean.getTxtNoApprv());
        fcpSave.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
        casemgmt.saveFosterCareParticipant(fcpSave);
      }
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  public void setCasemgmt(CaseMgmt casemgmt) {
    this.casemgmt = casemgmt;
  }

}