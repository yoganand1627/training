package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecialNeedsDeterminationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecialNeedsDeterminationSaveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to display/add/modify the Adoption Assistance Application
 * page.
 * 
 * 
 * @author  Vishala Devarakonda, May 7, 2007
 * 
 * <PRE>
 * 
 * &lt;U&gt;Updated by:&lt;/U&gt; &lt;U&gt;Description:&lt;/U&gt; Update description
 * 10/1/2008         swroberts             STGAP00010455: Updated conversation for R3.0 release.
 * </PRE>
 */

/**
 * This is the Conversation class used to display add or modify Special Needs Determination information
 * 
 * @author Vishala Devarakonda, May 7, 2007
 * 
 * Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *   02/06/2009   mxpatel               STGAP00012049: commented out code to make sure an event is 
 *                                      not created and save when clicked ADD button.
 *                                      Also changed to update status to PROC status instead of NEW 
 *                                      when creating a new Adoption Assistance Application.
 *   05/22/2009   mchillman             STGAP00013901: Move code to invalidate approval to execute on save and submit as well as save
 *   07/01/2009   bgehlot               STGAP00014563: Added new fields to the Application Page,  Get the non recurring approved amount from the context
 *   10/02/2009   arege                 STGAP00015503: Invalidating an Adoption Assistance Application should set the event status to PROC.
 *   01/13/2010   arege                 SMS#43557: Removed references to Payment Method field on the Special Services section
 *   02/01/2010   bgehlot               SMS#44783: MR-60 Changes, Pre Post radio buttons added, Special Needs Type and Approval Type
 *                                      radio buttons changed to the drop down, new types added.
 *   03/04/2010   mxpatel               SMS #46736: Modified the code to catch MSG_SPECSVC_RESP_OVERLAP and MSG_SPECSVC_CHILD_CARE_OVERLAP exceptions  
 *   03/09/2011   htvo                  SMS#97845 MR-074-2 AFCARS: set new field value to saveSI 
 *   05/25/2011   htvo                  SMS#109403 MR-082: fixed invalidate approval; save user-select incident status only when approving;
 *                                      retrieve non-recurring request selection from hidden field.                           
 *   06/07/2011   htvo                  SMS#109403: correct SMS code from 10943 to 109403
 *   10/10/2011   hnguyen               STGAP00017011: MR-092 Throw service exception to require a validated AA Funding determination prior to adding AA App.                                                        
 *   10/17/2011   hnguyen               STGAP00017011: MR-092 Uncommented error handling to display new message.                                                        
 *   10/26/2011   hnguyen               STGAP00017423: MR-092 Update to use correct message thrown.                                                       
 *   11/10/2011   hnguyen               STGAP00017513: MR-092 Display AA Funding Type if not override during approval process. 
 *   02/07/2012	  vcollooru				STGAP00017878: (Break-fix defect for 5.1) Following are the changes done as part of the fix -
 *   											 i) Added the new radio buttons for Agreement Type Selection.
 *   											ii) Enabled the non-recurring request and approvals sections for new applications even though
 *   												one approved in prior application.
 */
@SuppressWarnings("serial")
public class SpecialNeedsDeterminationConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "SpecialNeedsDeterminationConversation";

  public static final String SAVE_SUBMIT_BUTTON = "btnSaveSubmit";

  public static final String SEC_REGIONAL_SS_STF = UserProfile.SEC_REGIONAL_SS_STF;

  public static final String APPROVAL_TASK_1 = "8351";

  public static final String APPROVAL_TASK_2 = "8352";

  public static final String AGREEMENT_TYPE_INITIAL = "I";

  public static final String AGREEMENT_TYPE_AMENDED = "A";

  private Financials financials = null;
  
  private Admin admin;
  
  private Common common;

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }
  
  public void setCommon(Common common) {
    this.common = common;
  }
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }


  /**
   * This method is called by the GRNDS controller when a user clicks on the Add Button or the Description hyperlink on
   * the Special Needs Determination Event List page
   * 
   * @param context
   *                -The GrndsExchangeContext object.
   * @return void
   */
  public void displaySpecialNeedsDetermination_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displaySpecialNeedsDetermination_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    int idStage = GlobalData.getUlIdStage(request);
    //MR-060 Special Needs changes
    String hdnBSpecialNeedsTypeChange = ContextHelper.getString(request, "hdnBSpecialNeedsTypeChange");
    if(ArchitectureConstants.TRUE.equals(hdnBSpecialNeedsTypeChange)){
      SpecialNeedsDeterminationRetrieveSO spNdsDetRetSO = (SpecialNeedsDeterminationRetrieveSO) state.getAttribute(
                                                                                                                   "specialNeedsDeterminationRetrieveSO",
                                                                                                                   request);

      String indReasonSpecialRequest = "";
      String indAprType = "";
      if(spNdsDetRetSO != null){
        SpecialNeedsDeterminationBean spNdsDetBean = spNdsDetRetSO.getSpNdsDetBean();
        if(spNdsDetBean != null){
          indReasonSpecialRequest = spNdsDetBean.getIndReasonSpecialRequest();
          indAprType = spNdsDetBean.getIndAprType();
        }
      }

      List<String> specialNeedsTypePreList = new ArrayList<String>();
      specialNeedsTypePreList.add(CodesTables.CSPCLTYP_R);
      specialNeedsTypePreList.add(CodesTables.CSPCLTYP_A);
      specialNeedsTypePreList.add(CodesTables.CSPCLTYP_S);
      specialNeedsTypePreList.add(CodesTables.CSPCLTYP_T);
      specialNeedsTypePreList.add(CodesTables.CSPCLTYP_M);

      List<String> specialNeedsTypePostList = new ArrayList<String>();
      specialNeedsTypePostList.add(CodesTables.CSPCLTYP_C);
      specialNeedsTypePostList.add(CodesTables.CSPCLTYP_U);
      specialNeedsTypePostList.add(CodesTables.CSPCLTYP_V);

      String rbCdSpcNeedsPrePost = ContextHelper.getString(request, "rbCdSpcNeedsPrePost");

      List<String> excludeSpecialNeedsTypeList = new ArrayList<String>();
      // If the Special Needs type Selected is Post March 1st, 2010 then do not display Pre March 1st 2010 values in the
      // drop down
      if (StringHelper.isValid(rbCdSpcNeedsPrePost) && (CodesTables.CPLCYCHG_POS.equals(rbCdSpcNeedsPrePost))) {
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_R);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_A);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_S);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_T);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_M);
        //If the Special Needs Type should only show the values depending on the corresponding radio button selected(Pre or Post)
        if(specialNeedsTypePostList.contains(ContextHelper.getString(request, "rbCIndRsnSpcNeedsReq"))){
          indReasonSpecialRequest = ContextHelper.getString(request, "rbCIndRsnSpcNeedsReq");
        }else{
          indReasonSpecialRequest = "";
        }
        request.setAttribute("excludeSpecialNeedsTypeList", excludeSpecialNeedsTypeList);
      } else
      // If the Special Needs type Selected is Pre March 1st, 2010 then do not display Post March 1st 2010 values in the
      // drop down
      if (StringHelper.isValid(rbCdSpcNeedsPrePost) && CodesTables.CPLCYCHG_PRE.equals(rbCdSpcNeedsPrePost)) {
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_C);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_U);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_V);
        //If the Special Needs Type should only show the values depending on the corresponding radio button selected(Pre or Post)
        if(specialNeedsTypePreList.contains(ContextHelper.getString(request, "rbCIndRsnSpcNeedsReq"))){
          indReasonSpecialRequest = ContextHelper.getString(request, "rbCIndRsnSpcNeedsReq");            
        }else{
          indReasonSpecialRequest = "";
        }
        request.setAttribute("excludeSpecialNeedsTypeList", excludeSpecialNeedsTypeList);
      } 

      String rbCdSpcNeedsPrePostAppr = ContextHelper.getString(request, "rbCdSpcNeedsPrePostAppr");

      List<String> excludeSpecialNeedsTypeApprList = new ArrayList<String>();
      // If the Approval type Selected is Post March 1st, 2010 then do not display Pre March 1st 2010 values in the
      // drop down
      if (StringHelper.isValid(rbCdSpcNeedsPrePostAppr) && (CodesTables.CPLCYCHG_POS.equals(rbCdSpcNeedsPrePostAppr))) {
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_R);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_A);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_S);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_T);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_M);
        //If the Approval Type should only show the values depending on the corresponding radio button selected(Pre or Post)
        if(specialNeedsTypePostList.contains(ContextHelper.getString(request, "rbApprovalType"))){
          indAprType = ContextHelper.getString(request, "rbApprovalType");            
        }else{
          indAprType = "";
        }
        request.setAttribute("excludeSpecialNeedsTypeApprList", excludeSpecialNeedsTypeApprList);
        request.setAttribute("anchor","#gohere");
      }else  
      // If the Approval type Selected is Pre March 1st, 2010 then do not display Post March 1st 2010 values in the
      // drop down
      if (StringHelper.isValid(rbCdSpcNeedsPrePostAppr) && CodesTables.CPLCYCHG_PRE.equals(rbCdSpcNeedsPrePostAppr)) {
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_C);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_U);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_V);
        //If the Approval Type should only show the values depending on the corresponding radio button selected(Pre or Post)
        if(specialNeedsTypePreList.contains(ContextHelper.getString(request, "rbApprovalType"))){
          indAprType = ContextHelper.getString(request, "rbApprovalType");            
        }else{
          indAprType = "";
        }
        request.setAttribute("excludeSpecialNeedsTypeApprList", excludeSpecialNeedsTypeApprList);
        request.setAttribute("anchor","#gohere");
      }

      if(spNdsDetRetSO != null){
        SpecialNeedsDeterminationBean spNdsDetBean = spNdsDetRetSO.getSpNdsDetBean();
        if(spNdsDetBean != null){          
          spNdsDetBean.setCdSpcNdsPrePosReq(ContextHelper.getString(request, "rbCdSpcNeedsPrePost"));
          // STGAP00017878: Added the new radio buttons for Agreement Type Selection
          spNdsDetBean.setIndAgrmtType(ContextHelper.getString(request, "rbAgrmtType"));
          spNdsDetBean.setCdSpcNdsPrePosApr(ContextHelper.getString(request, "rbCdSpcNeedsPrePostAppr"));
          spNdsDetBean.setIndReasonSpecialRequest(indReasonSpecialRequest);
          spNdsDetBean.setIndAprType(indAprType);
          spNdsDetBean.setIndSpcNeedsApproved(ContextHelper.getString(request, "rbSpNdDetReqApprv"));
          //STGAP00017513: MR-092 Display AA Funding Type if not override during approval process.
          if(StringHelper.isEmptyOrNull(ContextHelper.getString(request, "selSzCdFundingType"))){
            spNdsDetBean.setCdFundingType(spNdsDetBean.getCdFundingType());
          }else{
            spNdsDetBean.setCdFundingType(ContextHelper.getString(request, "selSzCdFundingType"));
          }
        }
      }

      return;
    }
    try {

      SpecialNeedsDeterminationRetrieveSI spNdsDetRetSI = new SpecialNeedsDeterminationRetrieveSI();
      spNdsDetRetSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
      spNdsDetRetSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
      spNdsDetRetSI.setUlIdCase(GlobalData.getUlIdCase(request));
      spNdsDetRetSI.setUlIdStage(idStage);
      spNdsDetRetSI.setUlIdPerson(GlobalData.getUlIdPerson(request));
      spNdsDetRetSI.setCdStage(GlobalData.getSzCdStage(request));
      spNdsDetRetSI.setUserId(user.getUserID());
      SpecialNeedsDeterminationRetrieveSO spNdsDetRetSO = financials.retrieveSpecialNeedsDetermination(spNdsDetRetSI);
      spNdsDetRetSO.setUserId(user.getUserID());
      spNdsDetRetSO.setAttrSocialServicesStaff(SEC_REGIONAL_SS_STF);
      state.setAttribute("specialNeedsDeterminationRetrieveSO", spNdsDetRetSO, request);
      GlobalData.setStageAccess(CaseUtility.hasStageAccess(user.getUserID(), idStage), request);
      
      // If the Special Needs Determination event is pending approval and the user
      // did not access the page in approval mode, warn them that the pending closure will be invalidated if they save any changes.
      if (spNdsDetRetSO != null) {
        if (CodesTables.CEVTSTAT_PEND.equals(spNdsDetRetSO.getCdEventStatus()) && !GlobalData.isApprovalMode(request)
            && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
        }
      }
      
    } catch (ServiceException se){
      handleError(se, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
        
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when a user clicks on the Save or Save and Submit Buttons on the
   * Special Needs Determination page
   * 
   * @param context -
   *                The GrndsExchangeContext object.
   * @return void
   */
  public void saveSpecialNeedsDetermination_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveSpecialNeedsDetermination_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    //STGAP00015503 : Invalidating approval should set event status to PROC
    // Get the event Status for Invalidate Approval
    SpecialNeedsDeterminationRetrieveSO spNdsDetRetSO = (SpecialNeedsDeterminationRetrieveSO) state
    .getAttribute(
                  "specialNeedsDeterminationRetrieveSO",
                  request);
    String eventStatus = StringHelper.EMPTY_STRING;
    
    if (spNdsDetRetSO != null) {
      eventStatus = spNdsDetRetSO.getCdEventStatus();
    }
    String saveSubmitButtonNameInRequest = SAVE_SUBMIT_BUTTON + ".x";
    boolean bSaveSubmit = ContextHelper.getString(request, saveSubmitButtonNameInRequest) != null;
    try {
      SpecialNeedsDeterminationSaveSI spcNdsDetSaveSI = populateSaveSI(context);
      if (GlobalData.isApprovalMode(request)) {
        spcNdsDetSaveSI.setIndModeApproval(ArchitectureConstants.Y);
        spcNdsDetSaveSI.setDtAprvDate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtDtDtAprvDate")));
        spcNdsDetSaveSI.setDtExpDate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtDtDtExpDate")));
      }
      
      SpecialNeedsDeterminationSaveSO spcNdsDetSaveSO = financials.saveSpecialNeedsDetermination(spcNdsDetSaveSI);
      GlobalData.setUlIdEvent(spcNdsDetSaveSO.getUlIdEvent(), request);
      request.setAttribute("SpecialNeedsDeterminationSaveSO", spcNdsDetSaveSO);
      
      //if save only and in pending mode and not an approver then invalidate the approval
      //STGAP00015503
      // SMS#109403: should invalidate all save when not in approval mode, which is accessing 
      // the page through Task link. 
      // Also, the old code conflicts with populateSaveSI code which relies on approval mode and
      // set the event back to PROC when it is saved when not in approval mode, regardless of 
      // user being approver.
      if (spcNdsDetSaveSO.getUlIdEvent() != 0 && CodesTables.CEVTSTAT_PEND.equals(eventStatus)
                      && !GlobalData.isApprovalMode(request)) {
      /*if (spcNdsDetSaveSO.getUlIdEvent() != 0 && CodesTables.CEVTSTAT_PEND.equals(eventStatus)
                      && !isCurrentActiveApprover(context) && hasStageAccessRights(context)) {*/
        CCMN05UI ccmn05ui = new CCMN05UI();
        ccmn05ui.setUlIdEvent(spcNdsDetSaveSO.getUlIdEvent());
        ArchInputStruct ais = new ArchInputStruct();
        ais.setUlSysNbrReserved1(ArchitectureConstants.N);
        ccmn05ui.setArchInputStruct(ais);
        try {
         admin.invalidateApproval(ccmn05ui);
        } catch (ServiceException se) {
          int errorCode = se.getErrorCode();
          switch (errorCode) {
          case Messages.SQL_NOT_FOUND:
            //if there is not an Approval to invalidate just keep on going
            break;
          default:
            GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
            processSevereException(context, se);
            break;
          }
        }
      }
      
      if (bSaveSubmit) {
        String taskCode = "";
        if (CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request))) {
          taskCode = APPROVAL_TASK_1;
        } else if (CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request))) {
          taskCode = APPROVAL_TASK_2;
        }
        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                                     GlobalData.getUlIdStage(request), taskCode);
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
        setPresentationBranch("submit", context);
      } 

    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Approval Status button on the SpecialNeedsDetermination page in
   * approval mode. This method The save function is called to edits, we are forwarded to the Approval Status page.
   * 
   * @param context -
   *                the GrndsExchangeContext object
   * @return void
   */
  public void submitApproval_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".submitApproval_xa()");

    try {
      saveSpecialNeedsDetermination_xa(context);

    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();

  }

  /**
   * This helper method is called by the saveSpecialNeedsDetermination_xa to populate the input object for the Special
   * Needs Determination Save service.
   * 
   * @param context
   *                GrndeExchangeContext
   * @return SpecialNeedsDeterminationSaveSI
   * @throws ParseException
   */
  private SpecialNeedsDeterminationSaveSI populateSaveSI(GrndsExchangeContext context) throws ServiceException,
                                                                                      ParseException {
    HttpServletRequest request = context.getRequest();
    SpecialNeedsDeterminationSaveSI saveSI = new SpecialNeedsDeterminationSaveSI();
    SpecialNeedsDeterminationBean spNdsDetBean = new SpecialNeedsDeterminationBean();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    SpecialNeedsDeterminationRetrieveSO spNdsDetRetSO = (SpecialNeedsDeterminationRetrieveSO) state
                                                                                                   .getAttribute(
                                                                                                                 "specialNeedsDeterminationRetrieveSO",
                                                                                                                 request);
    int idUser = user.getUserID();
    boolean btnSaveSubmit = ContextHelper.getIntSafe(request, "btnSaveSubmit.x") != 0;
    boolean btnSave = ContextHelper.getIntSafe(request, "btnSave.x") != 0;
    int idEvent = GlobalData.getUlIdEvent(request);
    Date dtLastUpdate = new Date();
    try {
      // Plan accessed through Hyperlink
      if (idEvent > 0) {
        saveSI.setCdEventStatus(spNdsDetRetSO.getCdEventStatus());
        if (spNdsDetRetSO.getSpNdsDetBean() != null) {
          dtLastUpdate = (Date) spNdsDetRetSO.getSpNdsDetBean().getDtLastUpdate();
        }
        saveSI.setDtEventLastUpdate(spNdsDetRetSO.getDtEventLastUpdate());
        saveSI.setDtEventOccurred(spNdsDetRetSO.getDtEventOccurred());
        saveSI.setCdtask(spNdsDetRetSO.getCdTask());
        saveSI.setTxtEventDesc(spNdsDetRetSO.getTxtEventDesc());
        //STGAP00015503 Set event status to PEND only if the btn pressed is Save and We are in Approval mode 
        //otherwise it should set to PROC
        if ((CodesTables.CEVTSTAT_PEND.equals(spNdsDetRetSO.getCdEventStatus()) && btnSave && GlobalData.isApprovalMode(request)) || btnSaveSubmit) {
          saveSI.setCdEventStatus(CodesTables.CEVTSTAT_PEND);
        } else if (btnSave) {
          saveSI.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
        }
      } else {
        saveSI.setCdEventStatus(CodesTables.CEVTSTAT_PROC);//mxpatel changed from NEW to PROC for defect #12049
        saveSI.setCdtask(GlobalData.getSzCdTask(request));
        saveSI.setDtEventOccurred(new Date());
        saveSI.setDtEventLastUpdate(new Date());
        saveSI.setIdPerson(GlobalData.getUlIdPerson(request));
      }

      spNdsDetBean.setIdEvent(idEvent);
      spNdsDetBean.setIndReasonSpecialRequest(ContextHelper.getStringSafe(request, "rbCIndRsnSpcNeedsReq"));
      spNdsDetBean.setTxtCmntsSpecialRequest(ContextHelper.getStringSafe(request, "szTxtRsnSpcNeedsReqCmnts"));
      spNdsDetBean.setIndChildMntRetarded(ContextHelper.getStringSafe(request, "rbMentRet"));
      spNdsDetBean.setTxtCmntsMntRetarded(ContextHelper.getStringSafe(request, "txtMentRetDiag"));
      spNdsDetBean.setIndChildVisHearingImpaired(ContextHelper.getStringSafe(request, "rbVHImpaired"));
      spNdsDetBean.setTxtCmntsVisHearingImpaired(ContextHelper.getStringSafe(request, "txtVHImpairedDiag"));
      spNdsDetBean.setIndChildPhysicallyDisabled(ContextHelper.getStringSafe(request, "rbPhyDisabled"));
      spNdsDetBean.setTxtCmntsPhysicallyDisabled(ContextHelper.getStringSafe(request, "txtPhyDisabledDiag"));
      spNdsDetBean.setIndChildEmotionallyDisabled(ContextHelper.getStringSafe(request, "rbEmDisturbed"));
      spNdsDetBean.setTxtCmntsEmotionallyDisabled(ContextHelper.getStringSafe(request, "txtEmDisturbedDiag"));
      spNdsDetBean.setIndChildOtherMedical(ContextHelper.getStringSafe(request, "rbOthMedCondition"));
      spNdsDetBean.setTxtCmntsOtherMedical(ContextHelper.getStringSafe(request, "txtOthMedCondition"));
      spNdsDetBean.setIndBasicRateReq(ContextHelper.getStringSafe(request, "rbBasicRateReq"));
      spNdsDetBean.setIndSpecializedRateReq(ContextHelper.getStringSafe(request, "rbSpecRateReq"));
      spNdsDetBean.setIndSFCorRBWO(ContextHelper.getStringSafe(request, "rbSFCorRBWO"));
      spNdsDetBean.setIndDocPsychological(ContextHelper.getStringSafe(request, "cbxPsychological"));
      spNdsDetBean.setIndDocDevelopmentalAssmt(ContextHelper.getStringSafe(request, "cbxDevAssmtEval"));
      spNdsDetBean.setIndDocTrtmntPrvdr(ContextHelper.getStringSafe(request, "cbxTrtmntPrvdr"));
      spNdsDetBean.setIndDocMentalAssmt(ContextHelper.getStringSafe(request, "cbxMedAssmnt"));
      spNdsDetBean.setIndDocSSI(ContextHelper.getStringSafe(request, "cbxSSI"));
      spNdsDetBean.setIndSpclServiceReq(ContextHelper.getStringSafe(request, "rbSpecServiceReq"));
      spNdsDetBean.setIndAllSpecialDocAttached(ContextHelper.getStringSafe(request, "rbIndDocAttached"));
      spNdsDetBean.setNbrReqAmt(ContextHelper.getMoneyAsDoubleSafe(request, "txtSzReqAmt"));
      spNdsDetBean.setCdSpclSerType(ContextHelper.getStringSafe(request, "selSzCdSpecServType"));
      spNdsDetBean.setTxtPleaseSpecify(ContextHelper.getStringSafe(request, "txtPlSpecify"));
      spNdsDetBean.setIndSpcNeedsApproved(ContextHelper.getStringSafe(request, "rbSpNdDetReqApprv"));
      //STGAP00017513: MR-092 Display AA Funding Type if not override during approval process.
      if(StringHelper.isEmptyOrNull(ContextHelper.getString(request, "selSzCdFundingType"))){
        spNdsDetBean.setCdFundingType(spNdsDetRetSO.getSpNdsDetBean() !=  null ? spNdsDetRetSO.getSpNdsDetBean().getCdFundingType() : "");
      }else{
        spNdsDetBean.setCdFundingType(ContextHelper.getStringSafe(request, "selSzCdFundingType"));
      }
      
      spNdsDetBean.setIndAprType(ContextHelper.getStringSafe(request, "rbApprovalType"));
      spNdsDetBean.setIndApprvMntRetarded(ContextHelper.getStringSafe(request, "cbxMentRetarded"));
      spNdsDetBean.setIndApprvHearingImpaired(ContextHelper.getStringSafe(request, "cbxVHImpaired"));
      spNdsDetBean.setIndApprvPhysicallyDisabled(ContextHelper.getStringSafe(request, "cbxPhysDisabled"));
      spNdsDetBean.setIndApprvEmotionalDist(ContextHelper.getStringSafe(request, "cbxEmDisturbed"));
      spNdsDetBean.setIndApprvOther(ContextHelper.getStringSafe(request, "cbxOthMedCond"));
      spNdsDetBean.setTxtApprvOtherCmt(ContextHelper.getStringSafe(request, "txtOthApprovalType"));
      spNdsDetBean.setIndSpclRateAdoAppr(ContextHelper.getStringSafe(request, "rbSpecRateAprv"));
      spNdsDetBean.setNbrTotalIveIvbAmt(ContextHelper.getMoneyAsDoubleSafe(request, "txtSzTotalAprvAmt"));
      spNdsDetBean.setNbrIveAmt(ContextHelper.getMoneyAsDoubleSafe(request, "txtSzAprvIveAmt"));
      spNdsDetBean.setNbrIvbAmt(ContextHelper.getMoneyAsDoubleSafe(request, "txtSzAprvIvbAmt"));
      spNdsDetBean.setIndSpclReqApproved(ContextHelper.getStringSafe(request, "rbSpecServReqAprv"));
      spNdsDetBean.setCdApprvSpclTypeFunding(ContextHelper.getStringSafe(request, "selSzCdSpServFundingType"));
      spNdsDetBean.setNbrApprvAmt(ContextHelper.getMoneyAsDoubleSafe(request, "txtSzAprvAmt"));
      spNdsDetBean.setDtApprvDate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtDtDtAprvDate")));
      spNdsDetBean
                  .setDtExpirationDate(DateHelper
                                                 .toJavaDateSafe(ContextHelper.getStringSafe(request, "txtDtDtExpDate")));
      spNdsDetBean.setTxtComments(ContextHelper.getStringSafe(request, "txtSzTxtSpcServAprvCmmts"));
      // SMS#109403: use hidden field to get value when field is disabled
      spNdsDetBean.setIndNonRecRequested(ContextHelper.getStringSafe(request, "hdnNonRecReq"));
      if("Y".equals(spNdsDetBean.getIndNonRecRequested())) {
        spNdsDetBean.setNbrNonRecAmt(new Double(Lookup.simpleDecodeSafe(CodesTables.CNONREC, CodesTables.CNONREC_LMT)));
      } else {
        spNdsDetBean.setNbrNonRecAmt(0.0);
      }
      
      spNdsDetBean.setIndNonRecApproved(ContextHelper.getStringSafe(request, "rbNonRecReqAprv"));
      
      //STGAP00014563: Get the non recurring approved amount from the context
      if("Y".equals(spNdsDetBean.getIndNonRecApproved())) {
        spNdsDetBean.setNbrNonRecAprvAmt(ContextHelper.getMoneyAsDoubleSafe(request, "txtSzNonRecReqTotalAprvAmt"));
      } else {
        spNdsDetBean.setNbrNonRecAprvAmt(0.0);
      }
      spNdsDetBean.setNbrSpNeedsChildrenRequest(ContextHelper.getIntSafe(request, "txtSzNumSPNChildReq"));
      spNdsDetBean.setIndNonRecOnly(ContextHelper.getStringSafe(request, "cbxNonRecOnly"));
      
      spNdsDetBean.setDtLastUpdate(dtLastUpdate);
      
      //STGAP00014563: Added new fields to the Application Page
      spNdsDetBean.setAddComments(ContextHelper.getStringSafe(request, "txtAdditionalComments"));
      spNdsDetBean.setDtSpecialNeedsApproved(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtDtSpecialNeedsApprvd")));
      
      //If there is no value entered in this field the date approved will be the date the application event was approved
      if(ContextHelper.getStringSafe(request, "txtDtSpecialNeedsApprvd") == null || "".equals(ContextHelper.getStringSafe(request, "txtDtSpecialNeedsApprvd"))){
        spNdsDetBean.setDtSpecialNeedsApproved(spNdsDetRetSO.getDtEventApproved());
      }
      spNdsDetBean.setCdBasicRateType(ContextHelper.getStringSafe(request, "cdBasicRateType"));
      spNdsDetBean.setNbrBasicAmt(ContextHelper.getMoneyAsDoubleSafe(request, "txtNbrCustomAmt"));
      spNdsDetBean.setNbrCountyAddonAmt(ContextHelper.getMoneyAsDoubleSafe(request, "txtNbrCountyAddonAmt"));
      
      //MR-60 Changes
      spNdsDetBean.setCdSpcNdsPrePosReq(ContextHelper.getStringSafe(request, "rbCdSpcNeedsPrePost"));
      spNdsDetBean.setCdSpcNdsPrePosApr(ContextHelper.getStringSafe(request, "rbCdSpcNeedsPrePostAppr"));

      // STGAP00017878: Added the new radio buttons for Agreement Type Selection
      spNdsDetBean.setIndAgrmtType(ContextHelper.getString(request, "rbAgrmtType"));
      
      saveSI.setSpNdsDetBean(spNdsDetBean);

      saveSI.setIdCase(GlobalData.getUlIdCase(request));
      saveSI.setIdStage(GlobalData.getUlIdStage(request));
      saveSI.setNmStage(GlobalData.getSzNmStage(request));
      saveSI.setIdUser(idUser);
      
      // SMS#97845 MR-074-2 AFCARS: new field btnApprovalStatusFinal
      // SMS#109403: do not save indIncidentChild unless SSAU is finalizing the approval. This field is 
      // mapped to Incident/Non-Incident Status page field and only visible in PAD under Approval mode. 
      boolean btnApprovalStatusFinal = ContextHelper.getIntSafe(request, "btnApprovalStatusFinal.x") != 0;
      if (btnApprovalStatusFinal) {
        saveSI.setIndIncidentChild(ContextHelper.getStringSafe(request, "rbIncNonIncStatus"));
      }      
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    return saveSI;
  }

  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }
  
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
  
  private void handleError(ServiceException we, GrndsExchangeContext context) {

    int errorCode = we.getErrorCode();
    HttpServletRequest request = context.getRequest();

    switch (errorCode) {
    case Messages.MSG_SPECSVC_RESP_OVERLAP:
    case Messages.MSG_SPECSVC_CHILD_CARE_OVERLAP:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_DATABASE_SAVE_FAIL:
    case Messages.SQL_NOT_FOUND: // SMS#97845 MR-074-2 AFCARRS
      this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      setErrorMessage(errorCode, request);
      break;
    case Messages.MSG_NO_IVE_ON_SAVE:
    case Messages.MSG_AA_FNDNG_SMMRY_NOT_EXISTS:
      this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      setErrorMessage(errorCode, request);
      break;
    default:
      processSevereException(context, we);
      break;
    }
  }
}