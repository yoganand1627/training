package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCGSSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GoalsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StepBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildPlanDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCGSRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * 
 * This conversation class handles all FCC child plan activities and procedures
 * 
 * @author Jacob Vaidyan , January 8, 2007
 * 
 * 
 * <pre>
 *  Change History:
 *  Date      User              Description
 *  --------  ----------------  --------------------------------------------------
 *  09/08/08  alwilliams        STGAP00009864: Add the event person link array (ROWCCMN01UIG01_ARRAY) 
 *                              to the child plan detail event structure (ROWCCMN01UIG00)
 *  
 * </pre>
 *
 */

@SuppressWarnings("serial")
public class ChildPlanConversation extends BaseHiddenFieldStateConversation {
  // static constants
  public static final int INITIAL_PAGE = 1;

  public static final String PRS_STAFF = "FPS Staff";

  public static final String PARTICIPANT_DETAIL_PAGE_MODE = "participantDetailPageMode";

  public static final String SAVE_BUTTON_ON_CHILD_PLAN_PAGE = "btnSaveOnChildPlan";

  public static final String SAVE_AND_SUBMIT_BUTTON = "btnSaveAndSubmit"; /* RIOSJA, SIR 13418 */

  public static final String DISPLAY_CHILD_PLAN_URL = "/subcare/ChildPlan/displayFccpChild";

  public static final int SAVE_CHILD_PLAN = 1111;

  public static final int SAVE_AND_SUBMIT_CHILD_PLAN = 2222;

  public static final String DELETE_BUTTON_ON_PARTICIPANT_PAGE = "btnDeleteOnParticipant";

  public static final String CHECKED_ASFA_EXISTING_CONDS = "checkedASFAExstConds";

  public static final String CHECKED_PARENTAL_RIGHTS_TERMS = "checkedParentalRtsTerms";

  public static final String COMPLETE_CHILDPLAN_BUTTON = "btnCompleteQ";

  public static final String SAVE_CHILDPLAN_BUTTON = "btnSave";

  public static final String COMPLETE = "Complete";

  public static final String SAVE = "save";

  public static final String ADO_CHILD_PLAN_TASK_CODE = "8660";

  public static final String APPROVE_ADO_CHILD_PLAN_TASK_CODE = "8860";

  public static final String SUB_CHILD_PLAN_TASK_CODE = "3160";

  public static final String APPROVE_SUB_CHILD_PLAN_TASK_CODE = "3370";

  public static final int PARTICIPANTS_PER_PAGE = 50;

  public static final String DELETE_BUTTON_ON_CHILD_PLAN_PAGE = "btnDeleteOnChildPlan";

  public static final String SAVE_BUTTON_ON_PARTICIPANT_PAGE = "btnSaveOnParticipant";

  public static final String SEL_PARTICIPANT_TYPE = "selParticipantType";

  public static final String TXT_PARTICIPATION_DATE = "txtParticipationDate";

  public static final String TXT_NOTIFIED_DATE = "txtNotifiedDate";

  public static final String SEL_NOTIFICATION_TYPE = "selNotificationType";

  public static final String TXT_PARTICIPANT_NAME = "txtParticipantName";

  public static final String TXT_RELATIONSHIP_INTEREST = "txtRelationshipInterest";

  public static final String HDN_PERSON_ID = "hdnPersonId";

  public static final String HDN_PARTICIPANT_ID = "hdnParticipantId";

  public static final String HDN_PARTICIPANT_DATE_LAST_UPDATE = "hdnParticipantDateLastUpdate";

  public static final String TXT_COPY_GIVEN_DATE = "txtCopyGivenDate";

  public static final String EVENT_STATUS_PROC = "PROC";

  public static final String EVENT_STATUS_COMP = "COMP";

  public static final String EVENT_DESC_NO = "Child Plan";

  public static final String NO_EVENT_TYPE = "CSP";

  // private static final String TRUE = "true";

  public static final int FIFTY = 50;

  public static final int ONE = 1;

  private CaseMgmt childplan = null;

  private Common common;

  private Person person;

  private Admin admin;

  public void setCaseMgmt(CaseMgmt childplan) {
    this.childplan = childplan;
  }

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * Displays the child plan details.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */

  public void displayFccpChild_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayFccpChild_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      //STGAP00005609
      String indChildPlanChanged = (String) state.getAttribute("IND_CHILDPLAN_CHANGED", request);  
      //end STGAP00005609
      String pageModeFromEvent = EventSearchConversation.getEventDetailPageMode(request);
      String PageName = "";
      boolean btnNewUsing = ContextHelper.getIntSafe(request, "NewUsing.x") != 0;
      boolean IndEduDetail = false;
      ChildPlanDetailRetrieveSO childplanretrieveSO = new ChildPlanDetailRetrieveSO();
      ChildPlanDetailRetrieveSO childplanretrieveSOfromState = new ChildPlanDetailRetrieveSO();
      if (state.getAttribute("resultPageName", request) == null) {
        PageName = ContextHelper.getStringSafe(request, "resultPageName");

      } else {
        PageName = (String) state.getAttribute("resultPageName", request);
      }
      if (state.getAttribute("ChildPlanDetailRetrieveSO", request) == null) {
        state.removeAllAttributes(request);
      } else {
        // added 'indChildPlanChanged' : only use SO in state to display Child Detail when just comes back from Ed Hist detail
        if (PageName.equals("EducationDetail") && !ArchitectureConstants.TRUE.equals(indChildPlanChanged)) {
          childplanretrieveSOfromState = (ChildPlanDetailRetrieveSO) state.getAttribute("ChildPlanDetailRetrieveSO",
                                                                                        request);
          IndEduDetail = true;
        }
      }
      // List<ChildPlanDetailList> rowArray = null;
      int idStage = GlobalData.getUlIdStage(request);
      int idPerson = 0;

      if (idStage != 0) {
        idPerson = childplan.retrievePrimaryChildPersonId(idStage);
      }
      String name = GlobalData.getSzNmStage(request);
      GlobalData.setSzNmPersonFull(name, request);
      GlobalData.setUlIdPerson(idPerson, request);
      // PageMode.setPageMode(pageMode, request);
      int ulIdEvent = GlobalData.getUlIdEvent(request);
      Boolean rights = hasStageAccessRights(context); 
      if (rights) {
        PageMode.setPageMode(PageModeConstants.EDIT, request);

      } else {
        PageMode.setPageMode(PageModeConstants.VIEW, request);
      }
      if ("fcgs".equals(request.getAttribute("FCGS"))) {
        PageMode.setPageMode(PageModeConstants.EDIT, request);
      }
      if ("MODIFY".equals(PageModeConstants.MODIFY)) {

      } else {
        // STGAP00005609 - added 'indChildPlanChanged' clause to take care when child plan was saved second time ( or more ) after 
        // coming back from  Education History Detail to force page to call retrieveChildPlan to get current last update and changes
        if (!IndEduDetail || ArchitectureConstants.TRUE.equals(indChildPlanChanged)) {
        //  end STGAP00005609
          ChildPlanDetailRetrieveSI childplandetailRetrieveSI = populateChildPlanRetrieveSI_Retrieve(context);
          childplandetailRetrieveSI.setUlIdEvent(ulIdEvent);
          childplanretrieveSO = childplan.retrieveChildPlan(childplandetailRetrieveSI);
        }
      }
      // Changes for Copy Button from Event List
      if (pageModeFromEvent.equals(PageModeConstants.NEW_USING)) {
        ulIdEvent = 0;
        GlobalData.setUlIdEvent(ulIdEvent, request);
        PageMode.setPageMode(PageModeConstants.NEW_USING, request);
      }
      if (ulIdEvent == 0 && rights == true) {
        PageMode.setPageMode(PageModeConstants.NEW, request);
      }
      // STGAP00005609 - added 'indChildPlanChanged' : use ChildPlan from DB when Child Detail has been saved after coming back from Ed Hist
      if (!IndEduDetail || ArchitectureConstants.TRUE.equals(indChildPlanChanged)) {
        state.setAttribute("ChildPlanDetailRetrieveSO", childplanretrieveSO, request);
      } else {
        state.setAttribute("ChildPlanDetailRetrieveSO", childplanretrieveSOfromState, request);
      }
      if (btnNewUsing) {
        setInformationalMessage(Messages.MSG_SAVE_BEFORE_NAV, request);
      }
      displayEducationList(context);
      // STGAP00005098 - save_xa uses this instead of page mode value since it could be made NEW 
      // above when (ulIdEvent == 0 && rights == true)
      state.setAttribute("BTN_COPY_CLICKED", btnNewUsing, request);
      // STGAP00005609 - reset indicator to null so page only retrieves from DB when page data changed
      state.removeAttribute("IND_CHILDPLAN_CHANGED", request); 
      // end STGAP00005098
    } catch (Exception e) {
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Saves the child plan details and takes the user to the Event List.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveFccpChild_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFccpChild_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    ChildPlanDetailSaveSI chilplanSaveSI = new ChildPlanDetailSaveSI();

    // STGAP00005098 - use this instead of page mode value since it could be reset to NEW in display
    boolean isNewUsing = (Boolean) state.getAttribute("BTN_COPY_CLICKED", request);
    FCGSRetrieveSO fcgsretsoFromState = null;
    boolean saveGoalsBean = false;
    if (isNewUsing) {
      fcgsretsoFromState = (FCGSRetrieveSO) state.getAttribute("FCGSRetrieveSO", request);
      List<GoalsBean> goalsBeanList = fcgsretsoFromState.getGoalBeanList();
      if (goalsBeanList != null && !goalsBeanList.isEmpty()) {
        saveGoalsBean = true;
      }
    }
    // end STGAP00005098

    chilplanSaveSI = populateChildPlanSaveSI_AU(context, SAVE);
    int eventId = childplan.saveChildPlan(chilplanSaveSI);
    request.setAttribute("ChildPlanDetailSaveSI", chilplanSaveSI);
    // STGAP00005609
    state.setAttribute("IND_CHILDPLAN_CHANGED", ArchitectureConstants.TRUE, request);
    // end STGAP00005609
    request = context.getRequest();
    // int idStage = GlobalData.getUlIdStage(request);
    GlobalData.setUlIdEvent(eventId, request);

    // STGAP00005098
    if (saveGoalsBean && eventId > 0) {
      saveFCGSBean(fcgsretsoFromState, eventId, context);
    }
    // end STGAP00005098

    performanceTrace.exitScope();
    performanceTrace.getTotalTime();
    return;
  }

  /**
   * Completes the child plan details.(Status to COMP)
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void completeFccpChild_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".completeFccpChild_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    // STGAP00005098 - use this instead of page mode value since it could be reset to NEW in display
    BaseSessionStateManager state = getSessionStateManager(context);
    boolean isNewUsing = (Boolean) state.getAttribute("BTN_COPY_CLICKED", request);
    FCGSRetrieveSO fcgsretsoFromState = null;
    boolean saveGoalsBean = false;
    if (isNewUsing) {
      fcgsretsoFromState = (FCGSRetrieveSO) state.getAttribute("FCGSRetrieveSO", request);
      List<GoalsBean> goalsBeanList = fcgsretsoFromState.getGoalBeanList();
      if (goalsBeanList != null && !goalsBeanList.isEmpty()) {
        saveGoalsBean = true;
      }
    }
    // end STGAP00005098
    ChildPlanDetailSaveSI chilplanSaveSI = new ChildPlanDetailSaveSI();
    chilplanSaveSI = populateChildPlanSaveSI_AU(context, COMPLETE);
    int eventId = childplan.saveChildPlan(chilplanSaveSI);
    // STGAP00005609
    state.setAttribute("IND_CHILDPLAN_CHANGED", ArchitectureConstants.TRUE, request);
    // end STGAP00005609
    request.setAttribute("ChildPlanDetailSaveSI", chilplanSaveSI);
    request = context.getRequest();
    GlobalData.setUlIdEvent(eventId, request);
    // STGAP00005098
    if (saveGoalsBean && eventId > 0) {
      saveFCGSBean(fcgsretsoFromState, eventId, context);
    }
    // end STGAP00005098
    performanceTrace.exitScope();
    performanceTrace.getTotalTime();
    return;

  }

  /**
   * Retrieve the child plan details.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private ChildPlanDetailRetrieveSI populateChildPlanRetrieveSI_Retrieve(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateChildPlanRetrieveSI_Retrieve");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    ChildPlanDetailRetrieveSI childplandetailRetrieveSI = new ChildPlanDetailRetrieveSI();
    childplandetailRetrieveSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return childplandetailRetrieveSI;
  }

  protected void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();

    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_CMN_NO_PRIMARY_ROW:
        this.setPresentationBranch("error", context);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } else {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Populate the child plan details in SaveSI object.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param method
   *          The caller method name to see whether its save or Complete.
   */

  private ChildPlanDetailSaveSI populateChildPlanSaveSI_AU(GrndsExchangeContext context, String method) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateChildPlanSaveSI_AU");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    int idEvent = GlobalData.getUlIdEvent(request);
    // STGAP00004863
    // submodule needs to put old id event to GlobalData so idEvent needs to be reset to 0 here when plan is copied
    // currently, display overwrite page mode to NEW when it is copied and user has rights; otherwise page mode is
    // NEW_USING
    // when plan is copied
    if (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))
        || (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) && idEvent > 0) {
      idEvent = 0;
    }
    // end STGAP00004863
    int idFccpChild = 0;
    boolean isComplete = false;
    ChildPlanDetailList cpdBean = new ChildPlanDetailList();
    ChildPlanDetailRetrieveSO childplanRetrieveSO = (ChildPlanDetailRetrieveSO) state
                                                                                     .getAttribute(
                                                                                                   "ChildPlanDetailRetrieveSO",
                                                                                                   request);
    ChildPlanDetailSaveSI childplanSaveSI = new ChildPlanDetailSaveSI();
    try {
      ROWCCMN01UIG00 childplandetailEvent = new ROWCCMN01UIG00();
      
      // STGAP00009864: Create the event person link array (ROWCCMN01UIG01_ARRAY) and add to the  
      // child plan detail event structure (ROWCCMN01UIG00)
      ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
      ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
      rowccmn01uig01.setUlIdPerson(GlobalData.getUlIdPerson(request));
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));
      rowccmn01uig01_array.addROWCCMN01UIG01(0, rowccmn01uig01);
      childplandetailEvent.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array); 
      
      if (COMPLETE.equals(method)) {
        isComplete = true;
        childplanSaveSI.setComplete(isComplete);
        childplandetailEvent.setSzCdEventStatus(EVENT_STATUS_COMP);
        childplandetailEvent.setSzCdEventType(NO_EVENT_TYPE);
        childplandetailEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        childplandetailEvent.setUlIdStage(GlobalData.getUlIdStage(request));
        childplandetailEvent.setUlIdPerson(user.getUserID());
        childplandetailEvent.setSzTxtEventDescr(EVENT_DESC_NO);
        childplandetailEvent.setSzCdTask(GlobalData.getSzCdTask(request));
        childplandetailEvent.setUlIdEvent(idEvent);
        childplandetailEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));
      } else if (SAVE.equals(method)) {
        childplandetailEvent.setSzCdEventStatus(EVENT_STATUS_PROC);
        childplandetailEvent.setSzCdEventType(NO_EVENT_TYPE);
        childplandetailEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
        childplandetailEvent.setUlIdStage(GlobalData.getUlIdStage(request));
        childplandetailEvent.setUlIdPerson(user.getUserID());
        childplandetailEvent.setSzTxtEventDescr(EVENT_DESC_NO);
        childplandetailEvent.setSzCdTask(GlobalData.getSzCdTask(request));
        childplandetailEvent.setUlIdEvent(idEvent);
        childplandetailEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));
      }

      cpdBean.setRowCCMN01UIG00(childplandetailEvent);
      
      // Detail section
      cpdBean.setLdTxtSvcOffProvidedDesc(ContextHelper.getStringSafe(request, "szTxtSvcOffProvidedDesc"));
      if (!("".equals(ContextHelper.getStringSafe(request, "szDtCompDate")))) {
        cpdBean.setLdDtCompDate(DateHelper.toJavaDate(ContextHelper.getStringSafe(request, "szDtCompDate")));
      }
      cpdBean.setLdInddilSearchComp(ContextHelper.getStringSafe(request, "rbInddilSearchComp"));
      cpdBean.setLdIndChildAdjInCare(ContextHelper.getStringSafe(request, "rbIndChildAdjInCare"));
      cpdBean.setLdTxtExpChildAdjInCare(ContextHelper.getStringSafe(context, "szTxtExpChildAdjInCare"));
      // ASFA section
      String[] checkedASFAExstConds = CheckboxHelper.getCheckedValues(request, "chkAsfaExistingConditions");
      cpdBean.setasfaExistingConditions(checkedASFAExstConds);
      String[] checkedParentalRtsTerms = CheckboxHelper.getCheckedValues(request, "chkParentalRtsTerms");
      cpdBean.setparentalRtsTerm(checkedParentalRtsTerms);
      cpdBean.setLdTxtparentalRightsCmnts(ContextHelper.getStringSafe(request, "szTxtParentalRightsCmnts"));
      // NRU Section
      String[] checkedNonReunificConditions = CheckboxHelper.getCheckedValues(request, "chknonReunificConditions");
      cpdBean.setnonReunificConditions(checkedNonReunificConditions);
      cpdBean.setLdIndFilePetition(ContextHelper.getStringSafe(context, "rbIndFilePetition"));
      if (!("".equals(ContextHelper.getStringSafe(request, "szDtfilePetitionDate")))) {
        cpdBean.setLdDtfilePetitionDate(DateHelper.toJavaDate(ContextHelper.getStringSafe(request,
                                                                                          "szDtfilePetitionDate")));
      }
      cpdBean.setLdTxtfilePetitionCmnts(ContextHelper.getStringSafe(context, "szTxtfilePetitionCmnts"));
      cpdBean.setLdTxtfinalPermPlacementSteps(ContextHelper.getStringSafe(context, "szTxtfinalPermPlacementSteps"));
      cpdBean.setLdIndPermPlan(ContextHelper.getStringSafe(context, "chkIndPermPlan"));
      cpdBean.setLdTxtadditionalInfo(ContextHelper.getStringSafe(context, "szTxtadditionalInfo"));
      // Health Status
      cpdBean.setLdIndImmunization(ContextHelper.getStringSafe(context, "rbIndImmunization"));
      cpdBean.setLdTxtImmunizationCmnts(ContextHelper.getStringSafe(context, "szTxtImmunizationCmnts"));
      cpdBean.setLdIndImmunizationOnFile(ContextHelper.getStringSafe(context, "rbIndImmunizationOnFile"));
      cpdBean.setLdTxtImmunizationFileComments(ContextHelper.getStringSafe(context, "szTxtImmunizationFileComments"));
      cpdBean.setLdIndMedPsychProblems(ContextHelper.getStringSafe(context, "rbIndMedPsychProblems"));
      cpdBean.setLdTxtMedPsychProblemsCmnts(ContextHelper.getStringSafe(context, "szTxtMedPsychProblemsCmnts"));
      cpdBean.setLdIndMedRecFile(ContextHelper.getStringSafe(context, "rbIndMedRecFile"));
      cpdBean.setLdTxtMedRecFileCmnts(ContextHelper.getStringSafe(context, "szTxtMedRecFileCmnts"));
      cpdBean.setLdIndPsychRecFile(ContextHelper.getStringSafe(context, "rbIndPsychRecFile"));
      cpdBean.setLdTxtPsychRecFileCmnts(ContextHelper.getStringSafe(context, "szTxtPsychRecFileCmnts"));
      cpdBean.setLdIndMedPsychTrmnt(ContextHelper.getStringSafe(context, "rbIndMedPsychTrmnt"));
      cpdBean.setLdIndMedPsychDocRecord(ContextHelper.getStringSafe(context, "rbIndMedPsychDocRecord"));
      cpdBean.setLdTxtMedPsychDocRecordCmnts(ContextHelper.getStringSafe(context, "szTxtMedPsychDocRecordCmnts"));
      cpdBean.setLdTxtOtherMedPsychDocRecordCmnts(ContextHelper.getStringSafe(context,
                                                                              "szTxtOtherMedPsychDocRecordCmnts"));
      cpdBean.setIdFccpChild(idFccpChild);
      childplanSaveSI.setDtLastUpdate(childplanRetrieveSO.getDtLastUpdate());
      childplanSaveSI.setDtCbxAsfaLastUpdate(childplanRetrieveSO.getDtCbxAsfaLastUpdate());
      childplanSaveSI.setDtCbxParLastUpdate(childplanRetrieveSO.getDtCbxParLastUpdate());
      childplanSaveSI.setDtCbxNruLastUpdate(childplanRetrieveSO.getDtCbxNruLastUpdate());
      childplanSaveSI.setcpdList(cpdBean);
      childplanSaveSI.setUlIdEvent(idEvent);
      childplanSaveSI.setUlIdStage(GlobalData.getUlIdStage(request));
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
    return childplanSaveSI;
  }

  public void displayEducationList(GrndsExchangeContext context) throws MarshalException, ValidationException,
                                                                ServiceException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCFC17SI ccfc17si = populateCCFC17SI_Retrieve(context);
    CCFC17SO ccfc17so = person.retrieveEducationalHistory(ccfc17si);
    state.setAttribute("CCFC17SO", ccfc17so, request);
  }

  public CCFC17SI populateCCFC17SI_Retrieve(GrndsExchangeContext context) {
    CCFC17SI ccfc17si = new CCFC17SI();
    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();
    input.setUsPageNbr(ONE);
    input.setUlPageSizeNbr(FIFTY);
    ccfc17si.setArchInputStruct(input);
    ccfc17si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    return ccfc17si;
  }

  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

  // STGAP00005098
  private void saveFCGSBean(FCGSRetrieveSO fcgsretsoFromState, int idEvent, GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveFCGSBean");
    performanceTrace.enterScope();

    try {
      List<GoalsBean> goalsBeanList = fcgsretsoFromState.getGoalBeanList();
      Iterator<GoalsBean> goalsBeanItr = goalsBeanList.iterator();
      while (goalsBeanItr.hasNext()) {
        GoalsBean goalsBean = goalsBeanItr.next();
        FCGSSaveSI fcgsSaveSI = populateFCGSSaveSI_Save(goalsBean, idEvent);
        childplan.updateFCGSInformation(fcgsSaveSI);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
  }

  // STGAP00005098
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
    //End
    glBean.setStepBeanList(stepBeanList);

    fcgsSaveSI.setGlBean(glBean);
    fcgsSaveSI.setUlIdEvent(idEvent);
    return fcgsSaveSI;
  }
}
