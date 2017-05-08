package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NeedsAndOutcomesRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;

/**
 * NeedsAndOutcomesConversation
 * 
 * @author Nandita Hegde , Dec 06,2006
 * @version 1.0
 * 
 * <pre>
 *             Change History:
 *             Date      User              Description
 *             --------  ----------------  --------------------------------------------------
 *             06/15/08  mchillman          STGAP00009116: fields moved from form to page
 * </pre>
 */

public class NeedsAndOutcomesConversation extends BaseHiddenFieldStateConversation {

  private CaseMgmt casemgmt = null;

  public static final String TRACE_TAG = "NeedsAndOutcomesConversation";

  public static final String EVENT_STATUS_APPROVED = "APRV";

  public static final String EVENT_STATUS_PEND = "PEND";

  public static final String EVENT_STATUS_NEW = "NEW";

  public static final String EVENT_STATUS_PROC = "PROC";

  public static final String EVENT_STATUS_COMP = "COMP";

  public static final String EVENT_DESC_NO = "Needs and Outcomes";

  public static final String SUBMIT = "submit";

  public static final String SAVE = "save";

  public static final String NO_EVENT_TYPE = "NED";

  public static final String APPROVE_NEEDS_OUTCOMES = "2287";

  public static final String NEEDS_CONCL_TASK_CODE = "2340";

  protected static final String PERSON_LIST_PULLBACK_INFO = PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME;

  protected static final String RESOURCE_PULLBACK_INFO = ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST;

  public static final String URL_RESOURCE_SEARCH_LIST = "/resource/ResourceSearch/results";

  private Common common;

  private Admin admin;

  public void setCaseMgmt(CaseMgmt casemgmt) {
    this.casemgmt = casemgmt;
  }

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  /**
   * display method for the Needs And Outcomes
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void displayNeedsAndOutcomes_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayNeedsAndOutcomes_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO = new NeedsAndOutcomesRetrieveSO();
      // clear state
      if (state.getAttribute("NeedsAndOutcomesRetrieveSO", request) == null) {
        state.removeAllAttributes(request);
      }
      // get event id.
      NeedsAndOutcomesRetrieveSI needsAndOutcomesRetrieveSI = populateNeedsOutcomesRetrieveSI(context);
      int needsEventId = needsAndOutcomesRetrieveSI.getUlIdEvent();
      GlobalData.setUlIdEvent(needsEventId, request);
      int ulIdEvent = GlobalData.getUlIdEvent(request);
      Boolean rights = hasStageAccessRights(context);
      if (rights) {
        PageMode.setPageMode(PageModeConstants.EDIT, request);
      } else {
        PageMode.setPageMode(PageModeConstants.VIEW, request);
      }
      if (ulIdEvent == 0 && rights == true) {
        PageMode.setPageMode(PageModeConstants.NEW, request);
      }
      needsAndOutcomesRetrieveSI.setUlIdEvent(ulIdEvent);
      // get the page name
      String pageName = (ContextHelper.getStringSafe(request, "hdnPageName"));
      if (pageName.equals("NeedsOutcomes")) {
        needsAndOutcomesRetrieveSO = casemgmt.retrieveNeedsAndOutcomes(needsAndOutcomesRetrieveSI);
        state.setAttribute("NeedsAndOutcomesRetrieveSO", needsAndOutcomesRetrieveSO, request);
      } else {

        NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSOState = (NeedsAndOutcomesRetrieveSO) state
                                                                                                       .getAttribute(
                                                                                                                     "NeedsAndOutcomesRetrieveSO",
                                                                                                                     request);

        needsAndOutcomesRetrieveSO = casemgmt.retrieveNeedsAndOutcomesDetail(needsAndOutcomesRetrieveSI);
        // Retrieve data from state for needs outcomes
        if (needsAndOutcomesRetrieveSOState != null) {
          needsAndOutcomesRetrieveSO.setNMResource(needsAndOutcomesRetrieveSOState.getNMResource());
          needsAndOutcomesRetrieveSO
                                    .setDtAssessmentCompletion(needsAndOutcomesRetrieveSOState
                                                                                              .getDtAssessmentCompletion());
          needsAndOutcomesRetrieveSO.setTxtAssessorName(needsAndOutcomesRetrieveSOState.getTxtAssessorName());
          needsAndOutcomesRetrieveSO.setTxtAssessorTitle(needsAndOutcomesRetrieveSOState.getTxtAssessorTitle());
          needsAndOutcomesRetrieveSO.setIndCCFAAgency(needsAndOutcomesRetrieveSOState.getIndCCFAAgency());
          needsAndOutcomesRetrieveSO.setDtReferral(needsAndOutcomesRetrieveSOState.getDtReferral());
          needsAndOutcomesRetrieveSO.setTxtGeneralRec(needsAndOutcomesRetrieveSOState.getTxtGeneralRec());
          needsAndOutcomesRetrieveSO.setTxtPlacementRec(needsAndOutcomesRetrieveSOState.getTxtPlacementRec());
          needsAndOutcomesRetrieveSO.setTxtCCFARecNotUsed(needsAndOutcomesRetrieveSOState.getTxtCCFARecNotUsed());
          needsAndOutcomesRetrieveSO.setIndCCFAEduAssmt(needsAndOutcomesRetrieveSOState.getIndCCFAEduAssmt());
          needsAndOutcomesRetrieveSO.setTxtCCFAEduAssmt(needsAndOutcomesRetrieveSOState.getTxtCCFAEduAssmt());
          needsAndOutcomesRetrieveSO.setDtCCFAEduAssmt(needsAndOutcomesRetrieveSOState.getDtCCFAEduAssmt());
          //STGAP00009116: fields moved from form to page
          needsAndOutcomesRetrieveSO.setTxtUnder4NoDevSrcCmnt(needsAndOutcomesRetrieveSOState.getTxtUnder4NoDevSrcCmnt());
          needsAndOutcomesRetrieveSO.setTxtUndSchoolageNoDevAss(needsAndOutcomesRetrieveSOState.getTxtUndSchoolageNoDevAss());
        }
        int idResource = 0;
        String resourceId = needsAndOutcomesRetrieveSO.getResourceIdForPullback();
        if (resourceId != null && resourceId != "") {
          idResource = Integer.parseInt(needsAndOutcomesRetrieveSO.getResourceIdForPullback());
        }
        // set resource id in global data if not zero
        if (idResource != 0) {
          GlobalData.setUlIdResource(idResource, request);
        }
      }
      // If the Needs and Outcomes event is pending approval and the user
      // did not access the page in approval mode, warn them that the
      // pending
      // closure will be invalidated if they save any changes.
      boolean globalEvtStatusIsApproval = GlobalData.isApprovalMode(request);
      String eventStatus = null;
      if (needsAndOutcomesRetrieveSO.getROWCCMN45DO() != null) {
        eventStatus = needsAndOutcomesRetrieveSO.getROWCCMN45DO().getSzCdEventStatus();
        if (eventStatus.equals(CodesTables.CEVTSTAT_PEND) && !globalEvtStatusIsApproval
            && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
          // setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL,
          // request);
          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
        }
      }
      state.setAttribute("NeedsAndOutcomesRetrieveSO", needsAndOutcomesRetrieveSO, request);

    } catch (Exception e) {
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Save Needs And Outcomes
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void saveNeedsAndOutcomes_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveNeedsAndOutcomes_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    int eventId = save(context, SAVE);
    request = context.getRequest();
    GlobalData.setUlIdEvent(eventId, request);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Save and Submit Needs And Outcomes for approval
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void saveAndSubmitNeedsAndOutcomes_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveAndSubmitNeedsAndOutcomes_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      int eventId = save(context, SUBMIT);
      GlobalData.setUlIdEvent(eventId, request);
      int ulIdEvent = GlobalData.getUlIdEvent(request);
      int ulIdCase = GlobalData.getUlIdCase(request);
      int ulIdStage = GlobalData.getUlIdStage(request);
      String szCdTask = APPROVE_NEEDS_OUTCOMES;
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ulIdEvent, ulIdCase, ulIdStage, szCdTask);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
      PageMode.setPageMode(PageModeConstants.APPROVE, request);

    } catch (ServiceException we) {
      handleError(we, context);
      try {
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Display Needs And Outcomes Detail page for existing detail
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void displayNeedsAndOutcomesDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayNeedsAndOutcomesDetail()");
    performanceTrace.enterScope();
    NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO = (NeedsAndOutcomesRetrieveSO) state
                                                                                              .getAttribute(
                                                                                                            "NeedsAndOutcomesRetrieveSO",
                                                                                                            request);
    NeedsAndOutcomesRetrieveSI needsAndOutcomesRetrieveSI = new NeedsAndOutcomesRetrieveSI();
    int idNeedsOutcomes = 0;
    int uIdEvent = 0;
    int uIdStage = 0;
    // get IdNeedsOutComes,Event Id, Stage Id ,Person Name from request
    idNeedsOutcomes = ContextHelper.getIntSafe(request, "hdnIdNeedsOutcomes");
    needsAndOutcomesRetrieveSI.setIdNeedsAndOutcomes(idNeedsOutcomes);
    uIdEvent = ContextHelper.getIntSafe(request, "hdnUIdEvent");
    needsAndOutcomesRetrieveSI.setUlIdEvent(uIdEvent);
    uIdStage = ContextHelper.getIntSafe(request, "hdnUIdStage");
    needsAndOutcomesRetrieveSI.setUIdStage(uIdStage);
    String personNm = ContextHelper.getStringSafe(request, "hdnPersonNm");
    // set event id and stage id ,person name in global data
    GlobalData.setUlIdEvent(uIdEvent, request);
    GlobalData.setUlIdStage(uIdStage, request);
    GlobalData.setSzNmPersonFull(personNm, request);
    // check for user rights
    Boolean rights = hasStageAccessRights(context);
    if (rights) {
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    }
    needsAndOutcomesRetrieveSO = casemgmt.retrieveNeedsAndOutcomesDetail(needsAndOutcomesRetrieveSI);
    // get needs and outcomes value from request and put in state.
    populateNeedsOutcomes(request, needsAndOutcomesRetrieveSO);
    state.setAttribute("NeedsAndOutcomesRetrieveSO", needsAndOutcomesRetrieveSO, request);
    // set the id needs and outcomes ,event id and stage id in state
    state.setAttribute("IdNeedsOutcomes", idNeedsOutcomes, request);
    state.setAttribute("UIdEvent", uIdEvent, request);
    state.setAttribute("UIdStage", uIdStage, request);
    int idPerson = needsAndOutcomesRetrieveSO.getIdPerson();
    GlobalData.setUlIdPerson(idPerson, request);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Display Needs And Outcomes Detail page in new mode
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void addNeedsAndOutcomesDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addNeedsAndOutcomesDetail_xa()");
    performanceTrace.enterScope();
    Boolean rights = hasStageAccessRights(context);
    NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO = new NeedsAndOutcomesRetrieveSO();
    PageMode.setPageMode(PageModeConstants.NEW, request);
    NeedsAndOutcomesRetrieveSI needsAndOutcomesRetrieveSI = populateNeedsOutcomesRetrieveSI(context);
    int ulIdEvent = GlobalData.getUlIdEvent(request);
    needsAndOutcomesRetrieveSI.setUlIdEvent(ulIdEvent);
    // set page mode
    if (ulIdEvent == 0 && rights == true) {
      PageMode.setPageMode(PageModeConstants.NEW, request);
    }
    needsAndOutcomesRetrieveSO = casemgmt.retrieveNeedsAndOutcomesDetail(needsAndOutcomesRetrieveSI);
    populateNeedsOutcomes(request, needsAndOutcomesRetrieveSO);
    state.setAttribute("NeedsAndOutcomesRetrieveSO", needsAndOutcomesRetrieveSO, request);
    int idPerson = needsAndOutcomesRetrieveSO.getIdPerson();
    GlobalData.setUlIdPerson(idPerson, request);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Save Needs And Outcomes Detail page
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public int saveNeedsAndOutcomesDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveNeedsAndOutcomes_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    NeedsAndOutcomesSaveSI needsAndOutcomes = new NeedsAndOutcomesSaveSI();
    needsAndOutcomes = populateNeedsAndOutcomesDetailSaveSI(context, needsAndOutcomes, SAVE);
    int eventId = casemgmt.saveNeedsAndOutcomesDetail(needsAndOutcomes);
    request.setAttribute("NeedsAndOutcomesSaveSI", needsAndOutcomes);
    GlobalData.setUlIdEvent(eventId, request);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return eventId;
  }

  /**
   * execute the "save" action - saves Needs and Outcomes data in to the DB. <p/>
   * <p>
   * The following services are used: <blockquote>
   * <ul>
   * <li>saveNeedsOutcomes
   * <li>
   * </ul>
   * </blockquote>
   * </p>
   */

  public int save(GrndsExchangeContext context, String method) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "save");
    performanceTrace.enterScope();
    // Get the event Status for Invalidate Approval
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO = (NeedsAndOutcomesRetrieveSO) state
                                                                                              .getAttribute(
                                                                                                            "NeedsAndOutcomesRetrieveSO",
                                                                                                            request);
    ROWCCMN45DO row = needsAndOutcomesRetrieveSO.getROWCCMN45DO();
    String eventStatus = "";
    if (row != null) {
      eventStatus = row.getSzCdEventStatus();
    }
    NeedsAndOutcomesSaveSI needsAndOutcomes = new NeedsAndOutcomesSaveSI();
    needsAndOutcomes = populateNeedsOutcomesSaveSI(context, needsAndOutcomes, method);
    int eventId = casemgmt.saveNeedsOutcomes(needsAndOutcomes);
    request.setAttribute("NeedsAndOutcomesSaveSI", needsAndOutcomes);

    if (eventId != 0 && "SUB".equals(GlobalData.getSzCdStage(request)) && EVENT_STATUS_PEND.equals(eventStatus)
        && !isCurrentActiveApprover(context) && hasStageAccessRights(context)) {
      CCMN05UI ccmn05ui = new CCMN05UI();
      ccmn05ui.setUlIdEvent(eventId);
      ArchInputStruct ais = new ArchInputStruct();
      ais.setUlSysNbrReserved1(ArchitectureConstants.N);
      ccmn05ui.setArchInputStruct(ais);
      try {
        admin.invalidateApproval(ccmn05ui);
      } catch (ServiceException se) {
        handleError(se, context);
      }
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return eventId;
  }

  /**
   * This helper method is called by the save to populate the input object for the NeedsAndOutcomes save service.
   * 
   * @param context
   *          GrndeExchangeContext
   * @return
   * @throws ParseException
   * 
   */
  private NeedsAndOutcomesSaveSI populateNeedsOutcomesSaveSI(GrndsExchangeContext context,
                                                             NeedsAndOutcomesSaveSI needsAndOutcomes, String method) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateNeedsOutcomesSaveSI");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int idEvent = GlobalData.getUlIdEvent(request);
    NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO = (NeedsAndOutcomesRetrieveSO) state
                                                                                              .getAttribute(
                                                                                                            "NeedsAndOutcomesRetrieveSO",
                                                                                                            request);
    try {

      ROWCCMN01UIG00 needsOutcomesEvent = new ROWCCMN01UIG00();
      if (SUBMIT.equals(method)) {
        needsOutcomesEvent.setSzCdEventStatus(EVENT_STATUS_PEND);
        needsOutcomesEvent.setSzCdEventType(NO_EVENT_TYPE);
        needsOutcomesEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        needsOutcomesEvent.setUlIdStage(GlobalData.getUlIdStage(request));
        needsOutcomesEvent.setUlIdPerson(user.getUserID());
        needsOutcomesEvent.setSzTxtEventDescr(EVENT_DESC_NO);
        needsOutcomesEvent.setSzCdTask(NEEDS_CONCL_TASK_CODE);
        needsOutcomesEvent.setUlIdEvent(idEvent);
        needsOutcomesEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnTsLastUpdate"));
      } else {
        needsOutcomesEvent.setSzCdEventStatus(EVENT_STATUS_PROC);
        needsOutcomesEvent.setSzCdEventType(NO_EVENT_TYPE);
        needsOutcomesEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        needsOutcomesEvent.setUlIdStage(GlobalData.getUlIdStage(request));
        needsOutcomesEvent.setUlIdPerson(user.getUserID());
        needsOutcomesEvent.setSzTxtEventDescr(EVENT_DESC_NO);
        needsOutcomesEvent.setSzCdTask(NEEDS_CONCL_TASK_CODE);
        needsOutcomesEvent.setUlIdEvent(idEvent);
        needsOutcomesEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnTsLastUpdate"));
      }
      needsAndOutcomes.setROWCCMN01UIG00(needsOutcomesEvent);
      needsAndOutcomes.setTxtAssessorName(ContextHelper.getStringSafe(request, "txtAssessorName"));
      needsAndOutcomes.setTxtAssessorTitle(ContextHelper.getStringSafe(request, "txtAssessorTitle"));
      String dtReferral = ContextHelper.getStringSafe(request, "dtReferral");
      if ((!dtReferral.equals("")) && (!dtReferral.equals(null))) {
        needsAndOutcomes.setDtReferral(DateHelper.toJavaDate(dtReferral));
      }
      String dtassmtComp = ContextHelper.getStringSafe(request, "dtAssessmentCompletion");
      if ((!dtassmtComp.equals("")) && (!dtassmtComp.equals(null))) {
        needsAndOutcomes.setDtAssessmentCompletion(DateHelper.toJavaDate(dtassmtComp));
      }
      needsAndOutcomes.setTxtGeneralRec(ContextHelper.getStringSafe(request, "txtGeneralRec"));
      needsAndOutcomes.setTxtPlacementRec(ContextHelper.getStringSafe(request, "txtPlacementRec"));
      needsAndOutcomes.setTxtCCFARecNotUsed(ContextHelper.getStringSafe(request, "txtCCFARecUnused"));
      needsAndOutcomes.setIndCCFAAgency(CheckboxHelper.getCheckboxValue(request, "chkCCFAAgency"));
      needsAndOutcomes.setIndCCFAEduAssmt(ContextHelper.getStringSafe(request, "rbCCFAEdu"));
      needsAndOutcomes.setTxtCCFAEduAssmt(ContextHelper.getStringSafe(request, "txtCCFAEduAssmt"));
      //STGAP00009116: fields moved from form to page
      needsAndOutcomes.setTxtUnder4NoDevSrcCmnt(ContextHelper.getStringSafe(request, "txtUnderFour"));
      needsAndOutcomes.setTxtUndSchoolageNoDevAss(ContextHelper.getStringSafe(request, "txtBelowSchoolAge")); 
      
      String dtCCFAEduAssmt = ContextHelper.getStringSafe(request, "dtCCFAEduAssmt");
      if ((!dtCCFAEduAssmt.equals("")) && (!dtCCFAEduAssmt.equals(null))) {
        needsAndOutcomes.setDtCCFAEduAssmt(DateHelper.toJavaDate(dtCCFAEduAssmt));
      }
      needsAndOutcomes.setNMResource(ContextHelper.getStringSafe(request, "hdnResourceName"));
      String idResource = ContextHelper.getStringSafe(request, "hdnResourceIdForPullback");
      if (idResource.equals(null) || idResource.equals("")) {
        int resourceId = GlobalData.getUlIdResource(request);
        idResource = String.valueOf(resourceId);
      }
      int id = Integer.parseInt(idResource);
      if (id != 0) {
        GlobalData.setUlIdResource(id, request);
      }
      int resourceId = GlobalData.getUlIdResource(request);
      String resource = String.valueOf(resourceId);
      needsAndOutcomes.setResourceIdForPullback(resource);
      int idNeedsOutcomes = 0;
      needsAndOutcomes.setIdPerson(user.getUserID());
      needsAndOutcomes.setUlIdCase(GlobalData.getUlIdCase(request));
      needsAndOutcomes.setIdStage(GlobalData.getUlIdStage(request));
      needsAndOutcomes.setUlIdEvent(idEvent);
      needsAndOutcomes.setDtLastUpdate(needsAndOutcomesRetrieveSO.getDtLastUpdate());
      NeedsAndOutcomesSaveSI needsOutcomesSaveSI = new NeedsAndOutcomesSaveSI();
      needsOutcomesSaveSI.setUlIdCase(GlobalData.getUlIdCase(request));
      needsAndOutcomes.setIdNeedsAndOutcomes(idNeedsOutcomes);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
    return needsAndOutcomes;
  }

  /**
   * This helper method is called by the save to populate the input object for the NeedsAndOutcomesDetail save service.
   * 
   * @param context
   *          GrndeExchangeContext
   * @return
   * @throws
   * 
   */

  public NeedsAndOutcomesSaveSI populateNeedsAndOutcomesDetailSaveSI(GrndsExchangeContext context,
                                                                     NeedsAndOutcomesSaveSI needsAndOutcomes,
                                                                     String method) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateNeedsAndOutcomesDetailSaveSI");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int idEvent = GlobalData.getUlIdEvent(request);
    NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO = (NeedsAndOutcomesRetrieveSO) state
                                                                                              .getAttribute(
                                                                                                            "NeedsAndOutcomesRetrieveSO",
                                                                                                            request);
    try {
      ROWCCMN01UIG00 needsOutcomesEvent = new ROWCCMN01UIG00();
      needsOutcomesEvent.setSzCdEventStatus(EVENT_STATUS_PROC);
      needsOutcomesEvent.setSzCdEventType(NO_EVENT_TYPE);
      needsOutcomesEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      needsOutcomesEvent.setUlIdStage(GlobalData.getUlIdStage(request));
      needsOutcomesEvent.setUlIdPerson(user.getUserID());
      needsOutcomesEvent.setSzTxtEventDescr(EVENT_DESC_NO);
      needsOutcomesEvent.setSzCdTask(NEEDS_CONCL_TASK_CODE);
      needsOutcomesEvent.setUlIdEvent(idEvent);
      needsOutcomesEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnTsLastUpdate"));
      needsAndOutcomes.setROWCCMN01UIG00(needsOutcomesEvent);
      needsAndOutcomes.setTxtIdentifiedNeed(ContextHelper.getStringSafe(request, "txtIdentifiedNeed"));
      needsAndOutcomes.setTxtComments(ContextHelper.getStringSafe(request, "txtComments"));
      needsAndOutcomes.setTxtServiceRecommended(ContextHelper.getStringSafe(request, "txtServiceRecommended"));
      needsAndOutcomes.setTxtServRecdNotProvidedRsn(ContextHelper.getStringSafe(request, "txtServNotProvidedRsn"));
      needsAndOutcomes.setTxtNeedNotMetRsn(ContextHelper.getStringSafe(request, "txtNeedNotMetRsn"));
      needsAndOutcomes.setIndNeedMet(CheckboxHelper.getCheckboxValue(request, "chkNeedMet"));
      needsAndOutcomes.setIndCCFANeed(CheckboxHelper.getCheckboxValue(request, "chkCCFANeed"));
      needsAndOutcomes.setIndServiceProvided(CheckboxHelper.getCheckboxValue(request, "chkServiceProvided"));
      needsAndOutcomes.setIdNeedsAndOutcomes(needsAndOutcomesRetrieveSO.getIdNeedsAndOutcomes());
      needsAndOutcomes.setIdPerson(user.getUserID());
      needsAndOutcomes.setUlIdCase(GlobalData.getUlIdCase(request));
      needsAndOutcomes.setIdStage(GlobalData.getUlIdStage(request));
      needsAndOutcomes.setUlIdEvent(idEvent);
      needsAndOutcomes.setDtLastUpdateDetail(needsAndOutcomesRetrieveSO.getDtLastUpdateDetail());
      NeedsAndOutcomesSaveSI needsOutcomesSaveSI = new NeedsAndOutcomesSaveSI();
      needsOutcomesSaveSI.setUlIdCase(GlobalData.getUlIdCase(request));

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return needsAndOutcomes;
  }

  /**
   * This method is called by the Grnds controller when the user clicks on the delete button on needs and outcomes page;
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void deleteNeedsAndOutcomes_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteNeedsAndOutcomes_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO = (NeedsAndOutcomesRetrieveSO) state
                                                                                              .getAttribute(
                                                                                                            "NeedsAndOutcomesRetrieveSO",
                                                                                                            request);
    int idNeeds = 0;
    String pageName = (ContextHelper.getStringSafe(request, "hdnPageName"));
    if (pageName.equals("NeedsOutcomes")) {
      String rbNeedsIndex = ContextHelper.getStringSafe(request, "rbNeedsIndex");
      idNeeds = Integer.parseInt(rbNeedsIndex);
    } else {
      idNeeds = needsAndOutcomesRetrieveSO.getIdNeedsAndOutcomes();
    }
    NeedsAndOutcomesSaveSI needsOutcomes = new NeedsAndOutcomesSaveSI();
    needsOutcomes.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    needsOutcomes.setIdNeedsAndOutcomes(idNeeds);
    casemgmt.saveNeedsAndOutcomesDetail(needsOutcomes);
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
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

  /*
   * determines whether the user has access rights to modify the stage
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

  /**
   * This method will populate NeedsAndOutcomesRetrieveSI.
   * 
   * @param context
   */

  private NeedsAndOutcomesRetrieveSI populateNeedsOutcomesRetrieveSI(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateNeedsOutcomesRetrieveSI_Retrieve");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    NeedsAndOutcomesRetrieveSI needsAndOutcomesRetrieveSI = new NeedsAndOutcomesRetrieveSI();
    // get stage id
    needsAndOutcomesRetrieveSI.setUIdStage(GlobalData.getUlIdStage(request));
    int stageId = needsAndOutcomesRetrieveSI.getUIdStage();
    int eventId = CaseUtility.getEvent(stageId, NEEDS_CONCL_TASK_CODE).getIdEvent();
    needsAndOutcomesRetrieveSI.setUlIdEvent(eventId);
    // get stage id
    needsAndOutcomesRetrieveSI.setUIdStage(GlobalData.getUlIdStage(request));
    String name = GlobalData.getSzNmStage(request);
    GlobalData.setSzNmPersonFull(name, request);
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return needsAndOutcomesRetrieveSI;
  }

  /**
   * This method will populate NeedsAndOutcomesRetrieveSO.
   * 
   * @param context
   */
  protected static void populateNeedsOutcomes(HttpServletRequest request,
                                              NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO) {
    try {
      if (request.getParameter("txtAssessorName") != null && !"".equals(request.getParameter("txtAssessorName"))) {
        needsAndOutcomesRetrieveSO.setTxtAssessorName(ContextHelper.getStringSafe(request, "txtAssessorName"));
      }
      if (request.getParameter("txtAssessorTitle") != null && !"".equals(request.getParameter("txtAssessorTitle"))) {
        needsAndOutcomesRetrieveSO.setTxtAssessorTitle(ContextHelper.getStringSafe(request, "txtAssessorTitle"));
      }
      if (request.getParameter("dtReferral") != null && !"".equals(request.getParameter("dtReferral"))) {
        needsAndOutcomesRetrieveSO.setDtReferral(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                                   "dtReferral")));
      }
      if (request.getParameter("dtAssessmentCompletion") != null
          && !"".equals(request.getParameter("dtAssessmentCompletion"))) {
        needsAndOutcomesRetrieveSO
                                  .setDtAssessmentCompletion(DateHelper
                                                                       .toJavaDate(ContextHelper
                                                                                                .getStringSafe(request,
                                                                                                               "dtAssessmentCompletion")));
      }
      if (request.getParameter("txtGeneralRec") != null && !"".equals(request.getParameter("txtGeneralRec"))) {
        needsAndOutcomesRetrieveSO.setTxtGeneralRec(ContextHelper.getStringSafe(request, "txtGeneralRec"));
      }
      if (request.getParameter("txtPlacementRec") != null && !"".equals(request.getParameter("txtPlacementRec"))) {
        needsAndOutcomesRetrieveSO.setTxtPlacementRec(ContextHelper.getStringSafe(request, "txtPlacementRec"));
      }
      if (request.getParameter("txtCCFARecUnused") != null && !"".equals(request.getParameter("txtCCFARecUnused"))) {
        needsAndOutcomesRetrieveSO.setTxtCCFARecNotUsed(ContextHelper.getStringSafe(request, "txtCCFARecUnused"));
      }
      if (request.getParameter("chkCCFAAgency") != null && !"".equals(request.getParameter("chkCCFAAgency"))) {
        needsAndOutcomesRetrieveSO.setIndCCFAAgency(CheckboxHelper.getCheckboxValue(request, "chkCCFAAgency"));
      }

      if (request.getParameter("txtAgencyNm") != null && !"".equals(request.getParameter("txtAgencyNm"))) {
        needsAndOutcomesRetrieveSO.setNMResource(ContextHelper.getStringSafe(request, "txtAgencyNm"));
      }

      if (request.getParameter("rbCCFAEdu") != null && !"".equals(request.getParameter("rbCCFAEdu"))) {
        needsAndOutcomesRetrieveSO.setIndCCFAEduAssmt(ContextHelper.getStringSafe(request, "rbCCFAEdu"));
      }
      if (request.getParameter("txtCCFAEduAssmt") != null && !"".equals(request.getParameter("txtCCFAEduAssmt"))) {
        needsAndOutcomesRetrieveSO.setTxtCCFAEduAssmt(ContextHelper.getStringSafe(request, "txtCCFAEduAssmt"));
      }
      if (request.getParameter("dtCCFAEduAssmt") != null && !"".equals(request.getParameter("dtCCFAEduAssmt"))) {
        needsAndOutcomesRetrieveSO
                                  .setDtCCFAEduAssmt(DateHelper
                                                               .toJavaDate(ContextHelper
                                                                                        .getStringSafe(request,
                                                                                                       "dtCCFAEduAssmt")));
      }
      
      if (request.getParameter("txtUnderFour") != null && !"".equals(request.getParameter("txtUnderFour"))) {
        needsAndOutcomesRetrieveSO.setTxtUnder4NoDevSrcCmnt(ContextHelper.getStringSafe(request, "txtUnderFour"));
      }
      if (request.getParameter("txtBelowSchoolAge") != null && !"".equals(request.getParameter("txtBelowSchoolAge"))) {
        needsAndOutcomesRetrieveSO.setTxtUndSchoolageNoDevAss(ContextHelper.getStringSafe(request, "txtBelowSchoolAge"));
      }
      
      needsAndOutcomesRetrieveSO.setPersonIdForPullback(ContextHelper.getStringSafe(request, "hdnPersonIdForPullback"));
      needsAndOutcomesRetrieveSO.setResourceIdForPullback(ContextHelper.getStringSafe(request,
                                                                                      "hdnResourceIdForPullback"));
      request.setAttribute("NeedsAndOutcomesRetrieveSO", needsAndOutcomesRetrieveSO);
    } catch (Exception e) {
      e.getMessage();
    }

  }

  /**
   * This method is call by select resource to get values from resouce page
   * 
   * @param context
   */

  public void retrieveResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "retrieveResource_xa");
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO = (NeedsAndOutcomesRetrieveSO) state
                                                                                                .getAttribute(
                                                                                                              "NeedsAndOutcomesRetrieveSO",
                                                                                                              request);
      if (needsAndOutcomesRetrieveSO == null) {
        needsAndOutcomesRetrieveSO = new NeedsAndOutcomesRetrieveSO();
      }
      // get page data
      populateNeedsOutcomes(request, needsAndOutcomesRetrieveSO);
      state.setAttribute("NeedsAndOutcomesRetrieveSO", needsAndOutcomesRetrieveSO, request);
      state.setAttribute("ACTUAL_PAGE_MODE", PageMode.getPageMode(request), request);
      PageMode.setPageMode("S", request);
      request.setAttribute( "destinationUrl","/subcare/NeedsAndOutcomes/setResource");
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
      NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO = (NeedsAndOutcomesRetrieveSO) state
                                                                                                .getAttribute(
                                                                                                              "NeedsAndOutcomesRetrieveSO",
                                                                                                              request);
      populateResource(request, needsAndOutcomesRetrieveSO);
      PageMode.setPageMode((String) state.getAttribute("ACTUAL_PAGE_MODE", request), request);
      request.setAttribute("NeedsAndOutcomesRetrieveSO", needsAndOutcomesRetrieveSO);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Populates resourceId and resourceName in NeedsAndOutcomesRetrieveSO when Needs and Outcomes is returned to from
   * resource list
   * 
   * @param request
   *          HttpServletRequest
   * @param NeedsAndOutcomesRetrieveSO
   *          needsAndOutcomesRetrieveSO
   */
  protected static void populateResource(HttpServletRequest request,
                                         NeedsAndOutcomesRetrieveSO needsAndOutcomesRetrieveSO) {
    CRES03SO cres03so = (CRES03SO) request.getAttribute(RESOURCE_PULLBACK_INFO);
    if (cres03so == null) {
      return;
    }
    request.removeAttribute(RESOURCE_PULLBACK_INFO);
    needsAndOutcomesRetrieveSO.setResourceIdForPullback(String.valueOf(cres03so.getUlIdResource()));
    needsAndOutcomesRetrieveSO.setNMResource(String.valueOf(cres03so.getSzNmResource()));
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
}