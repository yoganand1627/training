package gov.georgia.dhr.dfcs.sacwis.web.servicedelivery;

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
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.CompressionHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentServiceExecutor;
import gov.georgia.dhr.dfcs.sacwis.service.document.FCCPFamilyDetailForm;
import gov.georgia.dhr.dfcs.sacwis.structs.document.DocumentMetaData;
import gov.georgia.dhr.dfcs.sacwis.structs.document.Error;
import gov.georgia.dhr.dfcs.sacwis.structs.document.ErrorMessages;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DocumentTemplateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCCPFamilyDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCGSSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCarePartBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareParticipantSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.GoalsBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StepBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCGSRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareParticipantRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO.RowPlanPrincipal;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentBuilderHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentLookup;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentServiceHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentUtilityHelpers;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 * @author hong.van.t.vo, Mar 8, 2007
 * @version 1.0
 * 
 * <pre>
 *  Change History:
 *    Date        User              Description
 *    --------    ----------------  --------------------------------------------------
 *    06/12/2008  mchillman         STGAP00009156 changed behavior so that form
 *                                  prefill data is saved internally on save and submit
 *    07/23/2008  mchillman         STGAP00009648  new field created to hold hearing request comments
 *    07/29/2008  cwells            STGAP00007985  Changed the updatedPlan field to False when we are doing a copy. 
 *    11/25/2008  charden           STGAP00007565  - modified code in checkFormExists_xa to foreward control 
 *                                  to the saveAndSubmit method after successfully checking to see if the form exists
 *    08/04/2009  cwells            STGAP00014782 - Saving the Code value for the relationship type for participant in case 
 *                                  section when the participant type is person in case. 
 *    12/02/2009  bgehlot           SMS#41275 MR-057 - APPLA changes
 *    01/22/2010  hjbpatiste        SMS#44089 MR-057 - In displayPlacementInformation_xa(), calling saveFCCPFamily() to save the page prior to 
 *                                  forwarding to the Placement Information Page in case the data was modified
 *    01/25/2010  bgehlot           44337 MR-057 Concurrent Permanency Plan Type validation needs to allow court ordered selections
 *    08/03/2010  bgehlot           SMS# 65400 MR-068 Assigned Judge is now a Drop Down and would remain enabled and Save button displaying even after the FFCP Plan is APRV
 *    08/16/2010  bgehlot           SMS # 66028 If APRV do not change the event status. 
 * 
 * </pre>
 */

public class FCCPFamilyDetailConversation extends BaseHiddenFieldStateConversation {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public static final String INITIAL = "I";

  public static final String REVIEW = "R";

  public static final String TRACE_TAG = "FCCPFamilyDetailConversation";

  public static final String SAVE_FFCP_FAMILY_DETAIL = "SAVE_FFCP_FAMILY_DETAIL";

  public static final String SAVE_AND_SUBMIT_FFCP_FAMILY_DETAIL = "SAVE_AND_SUBMIT_FFCP_FAMILY_DETAIL";

  public static final String GO_TO_APPROVAL_STATUS = "GO_TO_APPROVAL_STATUS";

  public static final String EMPTY_STRING = "";

  public static final String CASE_PLAN_MODE = "CASE_PLAN_MODE";

  public static final String AFTER_CARE = CodesTables.CCTPLNTY_AFC;

  public static final String DEFAULT_STRING = "";

  public static final String SEC_REGIONAL_SS_STF = UserProfile.SEC_REGIONAL_SS_STF;
  
  public static final String STAFF = "DFCS";
  
  private CaseMgmt casemgmt;
  
  private Common common;

  private InvalidateApproval invalidateApproval = null;
  
  private DocumentSave documentSave = null;
  
  private DocumentServiceExecutor documentServiceExecutor = null;

  
  public void displayFCCPFamilyDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayFCCPFamilyDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    boolean btnEdit = ContextHelper.getIntSafe(request, "Edit.x") != 0;
    boolean btnNewUsing = ContextHelper.getIntSafe(request, "NewUsing.x") != 0;
    boolean btnAdd = ContextHelper.getIntSafe(request, "Add.x") != 0;
    String casePlanMode = null;

    //MR-057 APPLA changes
    String hdnBPlanTypeChange = ContextHelper.getString(request, "hdnBPlanTypeChange");
    if(ArchitectureConstants.TRUE.equals(hdnBPlanTypeChange)){
      FCCPFamilyDetailSO casePlanFamilySO = (FCCPFamilyDetailSO) state.getAttribute("CASE_PLAN_FAMILY", request);
      String selPPP = "";
      if(casePlanFamilySO != null){
        selPPP = casePlanFamilySO.getSelPPP();
      }
      
      String selCrtPlanType = ContextHelper.getString(request, "selCrtPlanType");
      List<String> excludePrimaryPlanList = new ArrayList<String>();
      // if case mode is REU then remove all the options other than Re-unification from drop down
      if (StringHelper.isValid(selCrtPlanType) && (CodesTables.CCTPLNTY_REU.equals(selCrtPlanType))) {
        excludePrimaryPlanList.add(CodesTables.CPERMPLN_LAE);
        excludePrimaryPlanList.add(CodesTables.CPERMPLN_FCO);
        excludePrimaryPlanList.add(CodesTables.CPERMPLN_ADA);
        excludePrimaryPlanList.add(CodesTables.CPERMPLN_GDS);
        excludePrimaryPlanList.add(CodesTables.CPERMPLN_LLR);
        request.setAttribute("excludePrimaryPlanList", excludePrimaryPlanList);
        if(CodesTables.CPERMPLN_RUI.equals((ContextHelper.getString(request, "selPPP")))){
          selPPP = ContextHelper.getString(request, "selPPP");
        }else{
          selPPP = "";
        }
      }  

      // if case mode is NRE then remove the Re-unification from drop down
      if (StringHelper.isValid(selCrtPlanType) && CodesTables.CCTPLNTY_NRE.equals(selCrtPlanType)) {
        excludePrimaryPlanList.add(CodesTables.CPERMPLN_RUI);
        request.setAttribute("excludePrimaryPlanList", excludePrimaryPlanList);
        //If the case plan mode is non reunification set the permanency plan to Reunification
        if(!CodesTables.CPERMPLN_RUI.equals((ContextHelper.getString(request, "selPPP")))){
          selPPP = ContextHelper.getString(request, "selPPP");
        }else{
          selPPP = "";
        }
      } 
      
      //If the case plan mode is concurrent set the permanency plan to Reunification
      if (StringHelper.isValid(selCrtPlanType) && CodesTables.CCTPLNTY_CON.equals(selCrtPlanType)) {
        if(!CodesTables.CPERMPLN_RUI.equals((ContextHelper.getString(request, "selPPP")))){
          selPPP = "RUI";
        }else{
          selPPP = ContextHelper.getString(request, "selPPP");
        }
      } 
     
      if(casePlanFamilySO != null){
        casePlanFamilySO.setSelCrtPlanType(ContextHelper.getString(request, "selCrtPlanType"));
        casePlanFamilySO.setSelPPP(selPPP);
        casePlanFamilySO.setSelSPP(ContextHelper.getString(request, "selSPP"));
      }
      return;
    }
    
    try {
      casePlanMode = (String) request.getParameter("hdnCasePlanMode");
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      boolean invalidateMessageIsAlreadyInRequest = (Object)state.getAttribute("INVALID_MSG_IN_RQST", request) == null ? false : (Boolean)state.getAttribute("INVALID_MSG_IN_RQST", request);

      if (btnEdit) {
        pageMode = PageModeConstants.EDIT;
      } else if (btnNewUsing) {
        pageMode = PageModeConstants.NEW_USING;
      } else if (btnAdd) {
        pageMode = PageModeConstants.NEW;
      } else { // reset page mode from NEW to MODIFY when page reloads
        if (PageModeConstants.NEW.equals(pageMode)
            && (Sets.isInSet(Sets.N, request) || CodesTables.CCTPLNTY_AFC.equals(casePlanMode))) {
          pageMode = PageModeConstants.MODIFY;
        }
      }
      // STGAP00004490: do not refresh data if display triggered from checkFormExists_xa
      if (!StringHelper.isValid((String) request.getAttribute("updateFromDB"))) {

        state.removeAllAttributes(request);
      }
      PageMode.setPageMode(pageMode, request);
      if (btnEdit) {
        Sets.setPageSet(Sets.E, request);
      } else if (PageModeConstants.NEW_USING.equals(pageMode)) {
        Sets.setPageSet(Sets.C, request); // Copy mode
      } else if (PageModeConstants.NEW.equals(pageMode)) {
        Sets.setPageSet(Sets.N, request);
      } else if (PageModeConstants.MODIFY.equals(pageMode)) {
        Sets.setPageSet(Sets.M, request);
      }

      FCCPFamilyDetailSO casePlanFamilySO = null;
      if (!StringHelper.isValid((String) request.getAttribute("updateFromDB"))) {
        FCCPFamilyDetailSI casePlanFamilySI = new FCCPFamilyDetailSI();
        casePlanFamilySI.setCaseId(GlobalData.getUlIdCase(request));
        casePlanFamilySI.setStageId(GlobalData.getUlIdStage(request));
        casePlanFamilySI.setEventId(GlobalData.getUlIdEvent(request));
        casePlanFamilySO = casemgmt.retrieveFCCPFamilyDetail(casePlanFamilySI);
      } else {
        // STGAP00004490: get SO from state if updateFromeDB set in checkFormExists_xa
        casePlanFamilySO = (FCCPFamilyDetailSO) state.getAttribute("CASE_PLAN_FAMILY", request);
      }

      List<RowPlanPrincipal> principalsForEventFromstate = casePlanFamilySO.getPrincipalsForEvent();

      if (StringHelper.isValid(casePlanFamilySO.getSelCrtPlanType())) {
        casePlanMode = casePlanFamilySO.getSelCrtPlanType();
      }
      // when updated plan accessed through hyperlink, and save and submit, checkFormExists will call display a second time
      // causing page set in request to lose value so reset it again here  
      if (casePlanFamilySO.isUpdatedPlan() && !Sets.isInSet(Sets.E, request)) {
        Sets.setPageSet(Sets.E, request);
      }
      casePlanFamilySO.setUserId(user.getUserID());
      casePlanFamilySO.setAttrSocialServicesStaff(SEC_REGIONAL_SS_STF);
      state.setAttribute("CASE_PLAN_MODE", casePlanMode, request);
      // if (CodesTables.CEVTSTAT_PEND.equals(casePlanFamilySO.getCdEventStatus())
      if (CodesTables.CEVTSTAT_PEND.equals(casePlanFamilySO.getCdOrigEventStatus())
          && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
        if (!invalidateMessageIsAlreadyInRequest) {
          setInformationalMessage(Messages.MSG_FP_INVLD_APRVL, request);
          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
          invalidateMessageIsAlreadyInRequest = true;
        }
      }
      // If the stage closure event is pending approval, and the user did not
      // access the page via an approval todo, notify them that the pending
      // approval will be invalidated if they save any changes.
      if (casePlanFamilySO.hasStageClosureEvent() && !GlobalData.isApprovalMode(request)) {
        setInformationalMessage(Messages.MSG_FP_STAGE_CLOSURE_INVLD_APRVL, request);
        if (!invalidateMessageIsAlreadyInRequest) {
          setInformationalMessage(Messages.MSG_FP_INVLD_APRVL, request);
          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
          invalidateMessageIsAlreadyInRequest = true;
        }
      }

      int oldIdEvent = GlobalData.getUlIdEvent(request);
      state.setAttribute("EXISTING_ID_PLAN", oldIdEvent, request);
      state.setAttribute("PRN_FOR_EVENT_FROM_STATE", principalsForEventFromstate, request);
      state.setAttribute("CASE_PLAN_FAMILY", casePlanFamilySO, request);
      state.setAttribute("BTN_COPY_CLICKED", btnNewUsing, request);
      state.setAttribute("BTN_UPDATE_CLICKED", btnEdit, request);
      state.setAttribute("INVALID_MSG_IN_RQST", invalidateMessageIsAlreadyInRequest, request);

      if (btnNewUsing) {
        setInformationalMessage(Messages.MSG_SAVE_BEFORE_NAV, request);
      }
      if(casePlanFamilySO.getIndHasADOStage()== true){//check to see if case has an open ado stage
    	  setInformationalMessage(Messages.MSG_CONFIRM_ADO_INFO_UPDATE,request);
      }      
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  public void displayAFCFamilyDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAFCFamilyDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    boolean btnEdit = ContextHelper.getIntSafe(request, "Edit.x") != 0;
    boolean btnNewUsing = ContextHelper.getIntSafe(request, "NewUsing.x") != 0;
    boolean btnAdd = ContextHelper.getIntSafe(request, "Add.x") != 0;

    try {

      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      if (btnEdit) {
        pageMode = PageModeConstants.EDIT;
      } else if (btnNewUsing) {
        pageMode = PageModeConstants.NEW_USING;
      } else if (btnAdd) {
        pageMode = PageModeConstants.NEW;
      } else {
        pageMode = PageModeConstants.MODIFY;
      }

      state.removeAllAttributes(request);
      PageMode.setPageMode(pageMode, request);
      if (btnEdit) {
        Sets.setPageSet(Sets.E, request);
      } else if (PageModeConstants.NEW_USING.equals(pageMode)) {
        Sets.setPageSet(Sets.C, request);
      } else if (PageModeConstants.NEW.equals(pageMode)) {
        Sets.setPageSet(Sets.N, request);
      } else if (PageModeConstants.MODIFY.equals(pageMode)) {
        Sets.setPageSet(Sets.M, request);
      }

      // Populate the data bean with default values from GlobalData.
      // ....

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  public void saveAndSubmitFCCPFamilyDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAndSubmitFCCPFamilyDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      saveFCCPFamily(context, SAVE_AND_SUBMIT_FFCP_FAMILY_DETAIL);
      //If error then return
      if(ArchitectureConstants.TRUE.equals(state.getAttribute("indLTFCQuesNotAnswered", request)) ||
                      ArchitectureConstants.TRUE.equals(state.getAttribute("indAdultConnQuesNotAnswered", request))){
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        return;
      }
      String approvalTaskCode = "4320";
      ToDoDetailDB toDoDetailDb = new ToDoDetailDB(GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                                   GlobalData.getUlIdStage(request), approvalTaskCode);

      ToDoHelper.setToDoDetailDB(toDoDetailDb, request, state);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Saves the family plan.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  @SuppressWarnings("unchecked")
  private void saveFCCPFamily(GrndsExchangeContext context, String action) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFCCPFamilyDetail");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    FCCPFamilyDetailSO fccpFamilyFromState = (FCCPFamilyDetailSO) state.getAttribute("CASE_PLAN_FAMILY", request);
    List<RowPlanPrincipal> principalsForEventfromState = (List<RowPlanPrincipal>) state
                                                                                       .getAttribute(
                                                                                                     "PRN_FOR_EVENT_FROM_STATE",
                                                                                                     request);
    // STGAP00005099
    FCGSRetrieveSO fcgsretsoFromState = null;
    FosterCareSecGoalsRetrieveSO fosterCareSecGoalsRetrieveSOFromState = null;
    FosterCareParticipantRetrieveSO fosterCareListFromState = null;
    boolean saveGoalsBean = false;
    boolean saveSecGoalsBean = false;
    boolean savePartListBean = false;
    boolean btnEdit = (Object)state.getAttribute("BTN_UPDATE_CLICKED", request) == null ? false : (Boolean)state.getAttribute("BTN_UPDATE_CLICKED", request);
    if (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request)) || btnEdit) {
      // set to save non/reuification goals
      fcgsretsoFromState = (FCGSRetrieveSO) state.getAttribute("FCGSRetrieveSO", request);
      if (fcgsretsoFromState != null) {
        List<GoalsBean> goalsBeanList = fcgsretsoFromState.getGoalBeanList();
        if (goalsBeanList != null && !goalsBeanList.isEmpty()) {
          saveGoalsBean = true;
        }
      }
      // set to save secondary goals
      fosterCareSecGoalsRetrieveSOFromState = (FosterCareSecGoalsRetrieveSO) state
                                                                                  .getAttribute(
                                                                                                "FosterCareSecGoalsRetrieveSO",
                                                                                                request);
      if (fosterCareSecGoalsRetrieveSOFromState != null) {
        List<FosterCareSecGoalsList> secGoalsList = fosterCareSecGoalsRetrieveSOFromState.getSecGoalsList();
        if (secGoalsList != null && !secGoalsList.isEmpty()) {
          saveSecGoalsBean = true;
        }
      }
      // set to save participant list
      fosterCareListFromState = (FosterCareParticipantRetrieveSO) state.getAttribute("fosterCareList", request);
      if (fosterCareListFromState != null) {
        List<FosterCarePartBean> fosterCarePartList = fosterCareListFromState.getFosterCarePartList();
        if (fosterCarePartList != null && !fosterCarePartList.isEmpty()) {
          savePartListBean = true;
        }
      }
    }
    // end STGAP00005099

    int idEvent;
    boolean invalidatePendingApproval = false;
    //boolean btnEdit = (Boolean) state.getAttribute("BTN_UPDATE_CLICKED", request);

    try {
      if (SAVE_AND_SUBMIT_FFCP_FAMILY_DETAIL.equals(action)) {
        fccpFamilyFromState.setSaveAndSubmit(true);
      }else if(SAVE_FFCP_FAMILY_DETAIL.equals(action)){
        fccpFamilyFromState.setSaveAndSubmit(false);
      }
      
      fccpFamilyFromState.setApprovalMode(GlobalData.isApprovalMode(request));
      fccpFamilyFromState.setApprovalModeForStageClosure(GlobalData.isStageClosureBeingApproved(request));

      if (btnEdit || Sets.isInSet(Sets.E, request)) {
        fccpFamilyFromState.setUpdatedPlan(true);
      } else {
        fccpFamilyFromState.setUpdatedPlan(false);
      }

      if (CodesTables.CEVTSTAT_PEND.equals(fccpFamilyFromState.getCdOrigEventStatus())
          && (!fccpFamilyFromState.isApprovalMode() || fccpFamilyFromState.isApprovalModeForStageClosure())) {
        invalidatePendingApproval = true;
      }
      FCCPFamilyDetailSO fccpFamilyDetail = populateFCCPFamilySO_Save(context, fccpFamilyFromState);

      //MR-057 APPLA Changes Changed the return Type of the save service
      FCCPFamilyDetailSaveSO fCCPFamilyDetailSaveSO = casemgmt.saveFCCPFamilyDetail(principalsForEventfromState, fccpFamilyDetail);
      
      if (SAVE_AND_SUBMIT_FFCP_FAMILY_DETAIL.equals(action)) {
        //List which will hold all the children for whom Placement questions are not answered
        List<Map<String,Object>> childrenList = new ArrayList<Map<String,Object>>();
               
        //If any of the Questions is unanswered for even one child then display error messages
        if(fCCPFamilyDetailSaveSO.getChildQuestionList() != null && !fCCPFamilyDetailSaveSO.getChildQuestionList().isEmpty()){
          Iterator<Map<String,Object>> iter1 = fCCPFamilyDetailSaveSO.getChildQuestionList().iterator();
          while (iter1.hasNext()) {
            Map<String,Object> childrenIdPerson = new HashMap<String,Object>();
            Map<String,Object> childQuesMap = (Map<String,Object>) iter1.next();
            if(ArchitectureConstants.N.equals(childQuesMap.get("indLTFCQuesAnswered")) ||
                            ArchitectureConstants.N.equals(childQuesMap.get("indAdultConnectionQuesAnswered"))){
              if(ArchitectureConstants.N.equals(childQuesMap.get("indLTFCQuesAnswered"))){
                state.setAttribute("indLTFCQuesNotAnswered", "true", request);
              }
              if(ArchitectureConstants.N.equals(childQuesMap.get("indAdultConnectionQuesAnswered"))){
                state.setAttribute("indAdultConnQuesNotAnswered", "true", request);
              }
              childrenIdPerson.put("idPerson", (Integer)childQuesMap.get("idPerson"));
              childrenIdPerson.put("idPlacementEvent", (Integer)childQuesMap.get("idPlacementEvent"));
              childrenIdPerson.put("nmPerson", (String)childQuesMap.get("nmPerson"));
              childrenList.add(childrenIdPerson);
            }
          }
        }
        
        //If error then return
        if(ArchitectureConstants.TRUE.equals(state.getAttribute("indLTFCQuesNotAnswered", request)) ||
                        ArchitectureConstants.TRUE.equals(state.getAttribute("indAdultConnQuesNotAnswered", request))){
          if(ArchitectureConstants.TRUE.equals(state.getAttribute("indLTFCQuesNotAnswered", request))){
            setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_FCCP_DT_AGREE_ON_PLCMNT_REQ), request);
          }
          if(ArchitectureConstants.TRUE.equals(state.getAttribute("indAdultConnQuesNotAnswered", request))){
            setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_FCCP_ADULT_CONN_ON_PLCMNT_REQ), request);
          }             
          fccpFamilyFromState.setchildrenList(childrenList);
          return;
        }
      }
      idEvent = fCCPFamilyDetailSaveSO.getIdEvent();

      // STGAP00005099
      // save non/reuification goals
      if (saveGoalsBean && idEvent > 0) {
        saveFCGSBean(fcgsretsoFromState, idEvent, context);
      }
      // save secondary goals
      if (saveSecGoalsBean && idEvent > 0) {
        saveFosterCareSecGoal(fosterCareSecGoalsRetrieveSOFromState, idEvent, context);
      }
      // save participant list
      if (savePartListBean && idEvent > 0) {
        saveFosterCareParticipant(fosterCareListFromState, idEvent, context);
      }
      // end STGAP00005099

      // invalidate pending approval here after save because sometimes failure to save did not make invalidate approval
      // process to roll back
      if (invalidatePendingApproval) {
        CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(fccpFamilyFromState, fccpFamilyFromState.getStageId(),
                                                                fccpFamilyFromState.getUserId());
        invalidateApproval.invalidateApproval(ccmn05ui);
        // STGAP00005099: if there is submodule data, save FCCP F will call submodule save service
        // Submodule save service has code to invalidate a FCCP F if plan is in PEND, set event status back to PROC
        // here so InvalidateApproval won't be called again and again while saving submodule data (and throwing SQL not
        // found
        // exception since it can't find the approval event)
        fccpFamilyFromState.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
        fccpFamilyFromState.setCdOrigEventStatus(CodesTables.CEVTSTAT_PROC);
        // end STGAP00005099
      }
      
      if (SAVE_AND_SUBMIT_FFCP_FAMILY_DETAIL.equals(action)) {
        saveFCCPForm(context, fccpFamilyDetail);
      }
      
      GlobalData.setUlIdEvent(idEvent, request);
      GlobalData.setUlIdStage(fccpFamilyDetail.getStageId(), request);
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Saves the foster case case plan for family. Then returns the user to the Foster Care Case Plan Family Detail page
   * where the newly saved family plan details will be displayed.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveFCCPFamilyDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFCCPFamilyDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String casePlanMode = request.getParameter("hdnCasePlanMode");
    String pageMode = PageMode.getPageMode(request);
    if (!PageModeConstants.NEW.equals(pageMode)) {
      saveFCCPFamily(context, SAVE_FFCP_FAMILY_DETAIL);
    } else {
      state.setAttribute("CASE_PLAN_MODE", casePlanMode, request);
    }
    performanceTrace.exitScope();
  }

  /**
   * Adding request info (containing Global Data and changes on page)to SO object (populated through Retrieve service)
   * and return it as SO_Save
   * 
   * @param context
   * @param fccpFamilyFromRequest
   * @return
   */
  private FCCPFamilyDetailSO populateFCCPFamilySO_Save(GrndsExchangeContext context,
                                                       FCCPFamilyDetailSO fccpFamilyFromRequest) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFCCPFamilySO_Save");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    // STGAP00005099 - checkFormExists calls display_xa again so retrieveing NEW USING mode from request return false
    // Edit and New Using mode were put in state in display_xa
    boolean btnEdit = (Object)state.getAttribute("BTN_UPDATE_CLICKED", request) == null ? false : (Boolean)state.getAttribute("BTN_UPDATE_CLICKED", request);
    boolean btnNewUsing = (Object)state.getAttribute("BTN_COPY_CLICKED", request) == null ? false : (Boolean)state.getAttribute("BTN_COPY_CLICKED", request);
    // end STGAP00005099
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
    int idUser = user.getUserID();
    String casePlanMode = request.getParameter("hdnCasePlanMode");

    // Event eventToSave;
    try {
      //MR-068 After FCCP Case Plan goes to APRV, saving should not change the event status.
      String cdEventStatus = "";
      if(fccpFamilyFromRequest.getCdEventStatus() != null){
        cdEventStatus = fccpFamilyFromRequest.getCdEventStatus();
      }
      
      // Plan accessed through Hyperlink
      //MR-068
      if (idEvent > 0 && !btnEdit && !btnNewUsing) { // this condition should now only be (idEvent > 0) due to change from STGAP00004863 above
        //SMS # 66028 If APRV do not change the event status.
        if(!CodesTables.CEVTSTAT_APRV.equals(cdEventStatus) ){
          // if approver modifies the page, page remains PEND
          if (GlobalData.isApprovalMode(request) || fccpFamilyFromRequest.isApprovalMode()
                          || fccpFamilyFromRequest.isSaveAndSubmit()) {
            fccpFamilyFromRequest.setCdEventStatus(CodesTables.CEVTSTAT_PEND);
          } else { // demote event
            fccpFamilyFromRequest.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
          }
        }
      } else {
        // Save and Submit a copy/update plan without saving first
        if (fccpFamilyFromRequest.isSaveAndSubmit()) {
          fccpFamilyFromRequest.setCdEventStatus(CodesTables.CEVTSTAT_PEND);
        } else {
          fccpFamilyFromRequest.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
        }
        fccpFamilyFromRequest.setCdTask(GlobalData.getSzCdTask(request));
        fccpFamilyFromRequest.setDtEventOccurred(new Date());
        fccpFamilyFromRequest.setDtEventLastUpdate(new Date());
        fccpFamilyFromRequest.setEventId(0);
      }
      
      // Create 'principalsForEvent'
      List<RowPlanPrincipal> principalsForEventVector = new ArrayList<RowPlanPrincipal>();
      String[] checkedPrincipals = CheckboxHelper.getCheckedValues(request, "cbxPrincipalsOnPlan");
      String[] checkedCaregivers = CheckboxHelper.getCheckedValues(request, "cbxCareGiversOnPlan");
      for (int i = 0; i < checkedPrincipals.length; i++) {
        RowPlanPrincipal prn = fccpFamilyFromRequest.new RowPlanPrincipal();
        int idPersonPrnForPlan = new Integer(checkedPrincipals[i]);
        prn.setIdPerson(idPersonPrnForPlan);
        if (checkedCaregivers.length <= 0) {
          prn.setIsCaregiver(ArchitectureConstants.N);
        } else {
          for (int j = 0; j < checkedCaregivers.length; j++) {
            if (StringHelper.isValid(checkedCaregivers[j])) {
              int idPersonCaregiver = new Integer(checkedCaregivers[j]);

              if (idPersonPrnForPlan == idPersonCaregiver) {
                prn.setIsCaregiver(ArchitectureConstants.Y);
                checkedCaregivers[j] = null;
                break;
              } else {
                prn.setIsCaregiver(ArchitectureConstants.N);
              }
            }
          }
        }
        principalsForEventVector.add(prn);

      }

      fccpFamilyFromRequest.setPrincipalsForEvent(principalsForEventVector);
      
      // getting field values that are specific to After Care case plan
      if (CodesTables.CCTPLNTY_AFC.equals(fccpFamilyFromRequest.getSelCrtPlanType())
          || CodesTables.CCTPLNTY_AFC.equals(casePlanMode)) {
        Date dtBegin = ContextHelper.getJavaDateSafe(request, "dtBeginAft");
        Date dtEnd = ContextHelper.getJavaDateSafe(request, "dtEndAft");
        fccpFamilyFromRequest.setSelCrtPlanType(CodesTables.CCTPLNTY_AFC);
        fccpFamilyFromRequest.setDtBeginAft(dtBegin);
        fccpFamilyFromRequest.setDtEndAft(dtEnd);
        fccpFamilyFromRequest.setTxtTsnDischg(ContextHelper.getString(request, "txtRsnDischg"));
      }
      // getting field values that are specific to Foster Care case plan
      else {
        fccpFamilyFromRequest.setSelCrtPlanType(ContextHelper.getString(request, "selCrtPlanType"));
        fccpFamilyFromRequest.setSelPPP(ContextHelper.getString(request, "selPPP"));
        fccpFamilyFromRequest.setSelRvwType(ContextHelper.getString(request, "selRvwType"));
        fccpFamilyFromRequest.setTxtAssnJudge(ContextHelper.getString(request, "txtAssnJudge"));
        fccpFamilyFromRequest.setRbDatesType(ContextHelper.getString(request, "rbDatesType"));
        fccpFamilyFromRequest.setDtInitDue(ContextHelper.getJavaDateSafe(request, "txtInitialDueDate"));
        fccpFamilyFromRequest.setDtOrigSub(ContextHelper.getJavaDateSafe(request, "hdnDtOrgSub"));
        // fccpFamilyFromRequest.setDtOrigSub(ContextHelper.getJavaDateSafe(request, "dtOrgSub"));
        fccpFamilyFromRequest.setDtPrevReview(ContextHelper.getJavaDateSafe(request, "dtPreReview"));
        fccpFamilyFromRequest.setDtCurReview(ContextHelper.getJavaDateSafe(request, "dtCurReview"));
        fccpFamilyFromRequest.setDtNextReview(ContextHelper.getJavaDateSafe(request, "hdnDtNextReview"));
        fccpFamilyFromRequest.setTxtPPPRsns(ContextHelper.getString(request, "txtPPPRsns"));
        fccpFamilyFromRequest.setSelSPP(ContextHelper.getString(request, "selSPP"));
        fccpFamilyFromRequest.setTxtSPPRsns(ContextHelper.getString(request, "txtSPPRsns"));
        fccpFamilyFromRequest.setTxtRsnsChildNotHome(ContextHelper.getString(request, "txtRsnsChildNotHome"));
        fccpFamilyFromRequest.setTxtHarmChildLeftInHome(ContextHelper.getString(request, "txtHarmChildLeftHome"));
        fccpFamilyFromRequest.setDtProjPerm(ContextHelper.getJavaDateSafe(request, "dtProjPerm"));
        fccpFamilyFromRequest.setCbxParentRefuseSign(ContextHelper.getString(request, "cbxParentRefuseSign"));
        fccpFamilyFromRequest.setRbParentPart(ContextHelper.getString(request, "rbParentPart"));
        fccpFamilyFromRequest.setTxtNoParentPart(ContextHelper.getString(request, "txtNoParentPart"));
        fccpFamilyFromRequest.setRbChildPart(ContextHelper.getString(request, "rbChildPart"));
        fccpFamilyFromRequest.setTxtNoChildPart(ContextHelper.getString(request, "txtNoChildPart"));
        fccpFamilyFromRequest.setRbHearReqAsst(ContextHelper.getString(request, "cbxHearReqAsst"));
        fccpFamilyFromRequest.setDtHearReq(ContextHelper.getJavaDateSafe(request, "dtHearReq"));
        fccpFamilyFromRequest.setRbHearReqSub(ContextHelper.getString(request, "rbHearReqSub"));

      }
      fccpFamilyFromRequest.setTxtHearingRequestComments(ContextHelper.getString(request, "txtHearingRequestComments"));
      fccpFamilyFromRequest.setCaseId(GlobalData.getUlIdCase(request));
      fccpFamilyFromRequest.setStageId(GlobalData.getUlIdStage(request));
      fccpFamilyFromRequest.setNmStage(GlobalData.getSzNmStage(request));
      fccpFamilyFromRequest.setUserId(idUser);
      // STGAP00007985 If the page is being copied then change the updated plan value to false
      if(btnNewUsing){
        fccpFamilyFromRequest.setUpdatedPlan(false);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
    return fccpFamilyFromRequest;
  }

  private CCMN05UI populateCCMN05UI_InvalidateApproval(FCCPFamilyDetailSO fCCPFamilyDetailToSave, int idStage,
                                                       int idUser) {

    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct input = new ArchInputStruct();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO rowccmn45do = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO();

    input.setSzUserId(String.valueOf(idUser));
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlSysNbrReserved1(ArchitectureConstants.N);

    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(fCCPFamilyDetailToSave.getDtEventOccurred()));
    rowccmn45do.setSzCdEventStatus(fCCPFamilyDetailToSave.getCdEventStatus());
    rowccmn45do.setSzCdEventType(CodesTables.CEVNTTYP_PLN);
    rowccmn45do.setSzCdTask(fCCPFamilyDetailToSave.getCdTask());
    rowccmn45do.setSzTxtEventDescr(fCCPFamilyDetailToSave.getTxtEventDesc());
    rowccmn45do.setTsLastUpdate(fCCPFamilyDetailToSave.getDtEventLastUpdate());
    rowccmn45do.setUlIdEvent(fCCPFamilyDetailToSave.getEventId());
    rowccmn45do.setUlIdPerson(idUser);
    rowccmn45do.setUlIdStage(idStage);

    ccmn05ui.setUlIdEvent(fCCPFamilyDetailToSave.getEventId());
    ccmn05ui.setArchInputStruct(input);

    return ccmn05ui;
  }

  /**
   * To ensure that all children on case have Child Detail conpleted, also if there is any child over 14 years of age a
   * WTLP needs to be created and approved for that child
   * 
   * @param context
   * @return
   */

  private void handleError(ServiceException we, GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    int errorCode = we.getErrorCode();
    switch (errorCode) {
    case Messages.MSG_CHILD_COMP_SUBMIT:
    case Messages.MSG_WTLP_APRV_SUBMIT:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_DATABASE_SAVE_FAIL:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SYS_MULT_INST:
    case Messages.MSG_ADO_INFO_COMP_SUBMIT:
      this.setPresentationBranch("error", context);
      setErrorMessage(errorCode, "/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail", request);
      break;

    default:
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
      break;
    }
    performanceTrace.exitScope();
  }

  public void checkFormExists_xa(GrndsExchangeContext context) {
    String formDocExists = "true";
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      FCCPFamilyDetailSO fccpFamilyFromState = (FCCPFamilyDetailSO) state.getAttribute("CASE_PLAN_FAMILY", request);

      populateFCCPFamilySO_Save(context, fccpFamilyFromState);
      state.setAttribute("CASE_PLAN_FAMILY", fccpFamilyFromState, request);

      FCCPFamilyDetailSI casePlanFamilySI = new FCCPFamilyDetailSI();
      casePlanFamilySI.setCaseId(GlobalData.getUlIdCase(request));
      casePlanFamilySI.setStageId(GlobalData.getUlIdStage(request));
      casePlanFamilySI.setEventId(GlobalData.getUlIdEvent(request));

          
      if (!StringHelper.isValid(formDocExists)) {
        setErrorMessage(Messages.MSG_FCCP_FORM_REQ_SAVE_SUBMIT,
                        "/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail", request);
      }
      
      request.setAttribute("formDocExists", formDocExists);
      request.setAttribute("updateFromDB", "true");// atttribute update from db false
      //STGAP00007565  - modified code  to foreward control to the saveAndSubmit method after checking to see if the form exists
      forward("/serviceDelivery/FCCPFamilyDetail/saveAndSubmitFCCPFamilyDetail", request, context.getResponse());
    } catch (Exception ex) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Exception: " + ex.getMessage());
      processSevereException(context, ex);
    }
  }
  
  /**
   * MR-057 This method forwards to the Placement Information page when user clicks on the hyperlink in the Current
   * Placement Section 
   * @param context
   */
  public void displayPlacementInformation_xa(GrndsExchangeContext context) { 
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPlacementInformation_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    // Save the page first in case there have been changes made
    saveFCCPFamily(context, SAVE_FFCP_FAMILY_DETAIL);
    
    String selectedIdPlacementEventStr = StringHelper.getSafeString(request.getParameter("hdnIdPlacementEvent"));
    int ulIdFCCPEvent = Integer.parseInt(StringHelper.getSafeString(request.getParameter("hdnIdFCCPEvent")));
    if (selectedIdPlacementEventStr != null) {
      try {
        int idPlacementEvent = Integer.parseInt(selectedIdPlacementEventStr);
        CaseUtility.Event excEvent = CaseUtility.getEvent(idPlacementEvent);
        CaseUtility.Stage excStage = CaseUtility.getStage(excEvent.getIdStage());
        state.setAttribute("ulIdFCCPEvent", ulIdFCCPEvent, request );   
        String paramString = StringHelper.EMPTY_STRING;
        
        if(CodesTables.CSTAGES_SUB.equals(excStage.getCdStage())){
          paramString = "actionEventId=" + idPlacementEvent + "&actionStageCode=" + excStage.getCdStage() + "&actionStageName=" + 
          excStage.getNmStage() + "&actionTaskCode=" + "3080" + "&actionCaseId=" + excStage.getIdCase() + "&actionStageId=" +excEvent.getIdStage(); 
        }
        
        String forwardUrl = "/workload/EventSearch/displayEventDetail?" + paramString;
        forward(forwardUrl, request, context.getResponse());
        
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
        processSevereException(context, e);
      }
    }
    performanceTrace.exitScope();
  }

  // STGAP00005099
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

  // STGAP00005099
  private FCGSSaveSI populateFCGSSaveSI_Save(GoalsBean goalsBean, int idEvent) {
    FCGSSaveSI fcgsSaveSI = new FCGSSaveSI();
    GoalsBean glBean = new GoalsBean();
    List<StepBean> stepBeanList = new ArrayList<StepBean>();

    stepBeanList = goalsBean.getStepBeanList();
    glBean = goalsBean;
    glBean.setIdGoal(0);
    glBean.setCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    for(int i=0;i<stepBeanList.size();i++){
      if(stepBeanList.get(i)!=null){
        stepBeanList.get(i).setCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
        stepBeanList.get(i).setIdStep(0);
      }
    }
    glBean.setStepBeanList(stepBeanList);

    fcgsSaveSI.setGlBean(glBean);
    fcgsSaveSI.setUlIdEvent(idEvent);
    return fcgsSaveSI;
  }

  private void saveFosterCareSecGoal(FosterCareSecGoalsRetrieveSO fosterCareSecGoalsRetrieveSOFromState, int idEvent,
                                     GrndsExchangeContext context) throws ServiceException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveFosterCareSecGoal");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    try {
      List<FosterCareSecGoalsList> secGoalsList = (List<FosterCareSecGoalsList>) fosterCareSecGoalsRetrieveSOFromState
                                                                                                                      .getSecGoalsList();
      Iterator<FosterCareSecGoalsList> secGoalsListItr = secGoalsList.iterator();
      while (secGoalsListItr.hasNext()) {
        FosterCareSecGoalsList goalsBean = secGoalsListItr.next();
        FosterCareSecGoalsSaveSI fosterCareSecGoalsSaveSI = new FosterCareSecGoalsSaveSI();
        fosterCareSecGoalsSaveSI.setCaseId(GlobalData.getUlIdCase(request));
        fosterCareSecGoalsSaveSI.setEventId(idEvent);
        fosterCareSecGoalsSaveSI.setIdPlanSecGoals(0);
        fosterCareSecGoalsSaveSI.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
        fosterCareSecGoalsSaveSI.setIndParentApproval(goalsBean.getIndParentApproval());
        fosterCareSecGoalsSaveSI.setSelStatus(goalsBean.getSelStatus());
        fosterCareSecGoalsSaveSI.setTxtDesc(goalsBean.getTxtDesc());
        casemgmt.saveFosterCareSecGoals(fosterCareSecGoalsSaveSI);
      }
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

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
        
        // STGAP00014782: When saving an updated Family Plan the coded value should be saved if the type is
        // Person in Case.  This prevents database errors and is a mirror of how we save the initial plan
        // on the FosterCareParticipantConversation. 
        if(CodesTables.CPARTYPE_PIC.equals(goalsBean.getSzCdPartType()))
        {
          String relDecode = goalsBean.getSzCdRelInt();
          String relIntCode = Lookup.simpleEncodeSafe(CodesTables.CRPTRINT, relDecode);
          fcpSave.setSzCdRelInt(relIntCode);
        }else if(goalsBean.getSzCdPartType().equals( CodesTables.CPARTYPE_STA )){
          fcpSave.setSzCdRelInt(STAFF);
        }else{
          fcpSave.setSzCdRelInt(goalsBean.getSzCdRelInt());
        }
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
  
  //STGAP00009156 changed behavior so that form prefill data is saved internally on save and submit
  private void saveFCCPForm(GrndsExchangeContext context, FCCPFamilyDetailSO fccpFamilyDetailSOFromDB) throws Exception, ServiceException, IOException {
    HttpServletRequest request = context.getRequest();
    
    //set the general attribute for the meta-data
    request.setAttribute("docType", FCCPFamilyDetailForm.FCM05O00);
    request.setAttribute("pCase", String.valueOf(GlobalData.getUlIdCase(request)));
    request.setAttribute("pStage", String.valueOf(GlobalData.getUlIdStage(request)));
    request.setAttribute("pEvent", String.valueOf(GlobalData.getUlIdEvent(request)));
    
    //walk through the Children
    List<RowPlanPrincipal> listPrimaryChildren = (List<RowPlanPrincipal>) fccpFamilyDetailSOFromDB.getPrincipalsForForm();
    if (listPrimaryChildren != null && !listPrimaryChildren.isEmpty()) {
      for (Iterator<RowPlanPrincipal> itVic = listPrimaryChildren.iterator(); itVic.hasNext();) {
        RowPlanPrincipal victimChild = itVic.next();
        request.setAttribute("pPerson", String.valueOf(victimChild.getIdPerson()));
        request.setAttribute("pStageOther", String.valueOf(victimChild.getIdStagePrincipal()));
        
        DocumentTemplateSI documentTemplateSI = new DocumentTemplateSI();
        documentTemplateSI.setDocument(FCCPFamilyDetailForm.FCM05O00_DOC_NAME);
        documentTemplateSI.setMajor(FCCPFamilyDetailForm.FCM05O00_MAJOR);
        documentTemplateSI.setMinor(FCCPFamilyDetailForm.FCM05O00_MINOR);
        documentTemplateSI.setRevision(FCCPFamilyDetailForm.FCM05O00_REVISION);
        
        Integer currentTemplate = common.retrieveDocumentTemplate(documentTemplateSI);
        if ("Y".equals(victimChild.getBIndBLOBExistsInDatabase())) {
          request.setAttribute("formDocExists", "true");
        } else {
          request.setAttribute("formDocExists", "");
          victimChild.setTemplateVersion(currentTemplate);
        }
        
        Integer templateVersion = victimChild.getTemplateVersion();
        
        // Get the specific document type requested and lookup in JNDI
        if (request.getAttribute("docType") != null) {
          String docType = (String) request.getAttribute("docType");
          String docMetaDataString = DocumentLookup.lookup(docType.toUpperCase());
          
          StringReader stringReader = new StringReader(docMetaDataString);
          DocumentMetaData documentMetaData = null;
          try {
            //Unmarshall the Xml String into the DocumentMetaData object
            documentMetaData = (DocumentMetaData) Unmarshaller.unmarshal(DocumentMetaData.class, stringReader);
            documentMetaData.setActualTemplateVersion(templateVersion.intValue());
          } catch (Exception e) {
            GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + e.getMessage());
            throw e;
          }
          
          // Fill in the rest of the documentMetaData from the request
          try {
            if (context.getRequest().getParameter("tableName") != null) {
              documentMetaData.getTableMetaData().setTableName(context.getRequest().getParameter("tableName"));
            }
            documentMetaData = DocumentUtilityHelpers.completeDocumentMetaData(documentSave, request, documentMetaData,
                                                                               false);
            documentMetaData.setRenderFormat(RenderType.HTML_WITHOUT_SHELL);
          } catch (Exception e) {
            GrndsTrace.msg(TRACE_TAG, 7, "Exception in completeDocumentMetaData:" + e.getMessage());
            throw e;
          }
          
          //populate the pre fill data
          String preFillData = null;
          try {
            GrndsTrace.msg(TRACE_TAG, 7, "Calling prefill service");
            preFillData = DocumentServiceHelper.returnPreFillData(documentServiceExecutor, request, documentMetaData);
          } catch (ServiceException we) {
            GrndsTrace.msg(TRACE_TAG, 7, "Exception calling Tuxedo:" + we.getMessage());
            String errorMessageString = null;

            // Get the errorMessages collection for the tux service
            ErrorMessages errorMessages = documentMetaData.getPreFillMetaData().getErrorMessages();

            // Loop thru the error messages until the constant is found.
            for (int x = 0; x < errorMessages.getErrorCount(); x++) {
              Error error = errorMessages.getError(x);
              GrndsTrace.msg(TRACE_TAG, 7, "Value of Error code:" + error.getErrorCode());
              // TODO: This used to only get displayed if error code and name were the same, which is very weird.
              errorMessageString = MessageLookup.getMessageByName(error.getDisplayMessage());
              if (errorMessageString.equals(we.getMessage())) {
                break;
              }
            }

            //  If the error code could not be found then perform the default behavior
            if (errorMessageString == null) {
              if (!"PROCESS_SEVERE_ERROR".equals(errorMessages.getDefault().getDisplayMessage())) {
                GrndsTrace.msg(TRACE_TAG, 7,
                               "Getting default error message:" + errorMessages.getDefault().getDisplayMessage());
                errorMessageString = MessageLookup.getMessageByName(errorMessages.getDefault().getDisplayMessage());
              } else {
                throw we;
              }
            }

            //If there was an error message show the exception page. 
            if (errorMessageString != null) {
              throw new Exception(errorMessageString);
            }
          }
          catch (Exception e) {
            GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception getting prefill data:" + e.getMessage());
            throw e;
          }
          
          StringWriter stringWriter = new StringWriter();
          try {
            Marshaller.marshal(documentMetaData, stringWriter);
          }
          catch (Exception e) {
            GrndsTrace.msg(TRACE_TAG, 7, "Exception in marshalling:" + e.getMessage());
            throw e;
          }

          docMetaDataString = stringWriter.toString();          
          
          try {
            //if an older version of the form where there are entry fields on the form
            //get the user entered data and then add the newer prefill values 
            if(templateVersion.intValue() < currentTemplate){
              preFillData = createPreFillDataForEarlierVersion(victimChild, GlobalData.getUlIdEvent(request), preFillData);
              documentSave.saveDocument(documentMetaData, (CompressionHelper.compressData(preFillData.getBytes())).toByteArray());
            } else {
              preFillData = DocumentBuilderHelper.TAG_DEF_START + DocumentBuilderHelper.TAG_DATA_OPEN + preFillData + DocumentBuilderHelper.TAG_DATA_CLOSE;
              documentSave.saveDocument(documentMetaData, (CompressionHelper.compressData(preFillData.getBytes())).toByteArray());
            }
          } catch (Exception e) {
              GrndsTrace.msg(TRACE_TAG, 7, "Unknown exception getting prefill data:" + e.getMessage());
              throw e;
          }
        }
      }
    }
  }
  
  private String createPreFillDataForEarlierVersion(RowPlanPrincipal victimChild, int eventId, String preFillData) throws Exception {
    String newNarrative = null;
    
    //get the existing narrative
    FCCPFamilyDetailSI fccpFamilyDetailSI = new FCCPFamilyDetailSI();
    fccpFamilyDetailSI.setStageId(victimChild.getIdStagePrincipal());
    fccpFamilyDetailSI.setEventId(eventId);
    
    byte[] narrativeba = casemgmt.retrieveFCCPForm(fccpFamilyDetailSI);
    
    //create the document from the narrative
    if(narrativeba != null) {
      ByteArrayOutputStream docData = CompressionHelper.decompressData(narrativeba);
      SAXBuilder parser = new SAXBuilder();
      ByteArrayInputStream baIS = new ByteArrayInputStream(docData.toByteArray());
      Document doc = parser.build(baIS);
      Element root = doc.getRootElement();
      
      //remove the old prefill
      root.removeChildren(DocumentBuilderHelper.FIELD_VALUE_PREFILL);
      
      //create the new prefill document from the new values
      ByteArrayInputStream baISPreFill = new ByteArrayInputStream(preFillData.getBytes());
      Document docPreFill = parser.build(baISPreFill);
      Element rootPreFill = docPreFill.getRootElement();
      List children = rootPreFill.cloneContent(); 
      
      //add in the new prefill values to the user entered data
      Element prefillElement = new Element(DocumentBuilderHelper.FIELD_VALUE_PREFILL);
      prefillElement.addContent(children);
      root.addContent(0, prefillElement);
      
      //setup the new xml for the narrative . 
      XMLOutputter serializer = new XMLOutputter();
      newNarrative = serializer.outputString(doc);    
    }
    return newNarrative;
  }

  public void setCasemgmt(CaseMgmt casemgmt) {
    this.casemgmt = casemgmt;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }
  
  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }

  public void setDocumentServiceExecutor(DocumentServiceExecutor documentServiceExecutor) {
    this.documentServiceExecutor = documentServiceExecutor;
  }
  
  public void setCommon(Common common) {
    this.common = common;
  }

}
