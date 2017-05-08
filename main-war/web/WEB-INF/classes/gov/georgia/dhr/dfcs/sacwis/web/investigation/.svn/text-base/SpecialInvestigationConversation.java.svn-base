package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.ToDo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.Investigation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpclInvestigationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvHmeWaiverChildHistBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationSaveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelperException;
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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * <p>Title: SpecialInvestigationConversation</p> <p>Description: This is the Conversation class used to add,
 * save and submit a Special Investigation for a particular case</p> 
 * <p>Copyright: Copyright (c) 2011</p> <p>Company: GADHS</p>
 * <p/>
 * <p/>
 * <pre>
 * Change History:
 * Date        User                  Description
 * ----------  ------------------    --------------------------------------------------------------------
 * 05/16/2011  hjbaptiste            Initial creation
 * 06/20/2011  hjbaptiste            SMS#112430: Setting the page mode to Modify when INV stage is closed and user
 *                                   has access or user is approver
 * 06/22/2011  hjbaptiste            SMS#112897: Added the logic in to set the event status to PEND when save and submit
 *                                   button is clicked                                  
 * 06/23/2011  hjbaptiste            SMS#112897: Setting the idEvent into Global Data in order to retrieve the correct approval
 *                                   status 
 * 06/23/2011  hjbaptiste            SMS#113090: Fixed unconditionally and incorrectly setting the event status to PROC upon saving
 *                                   as it was causing the Concurrence section not to be displayed when approver clicks save
 * 06/27/2011  hjbaptiste            SMS#112897: Fixed Approval Status button incorrectly displaying approval for 
 *                                   non-special investigation event
 * 06/29/2011  hjbaptiste            SMS#113421: Got rid of special character in alert and fixed whom alert goes out to
 *                                   SMS#113754: Removed the showSpclInvTab()
 * 06/29/2011  hjbaptiste            SMS#113784: Removed saving of event in saveDetail() when save and submit button is clicked
 *                                   When save and submit is clicked, passing the correct button indicator to the save method 
 * 06/29/2011  hjbaptiste            SMS#109631: Setting the page mode to INQUIRE when the event is in APRV status            
 * 10/31/2011  arege                 STGAP00016924: The task created for case manager should be deleted on Save and Submit of sp inv
 * </pre>
 *
 * @author Herve Jean-Baptiste, May 16, 2011
 */

@SuppressWarnings("serial")
public class SpecialInvestigationConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "SpecialInvestigationConversation";
  public static final String SAVE_SUBMIT_BUTTON = "btnSaveSubmit";
  public static final String SAVE_BUTTON = "btnSave";
  public static final String SUBMIT_APPROVAL_BUTTON = "btnApprovalStatusFinal";
  public static final String SPECIAL_INVESTIGATION_TASK = "2270";
  public static final String SPCL_INV_APPROVAL_TASK = "2265";
  public static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;
  private static final String ERROR_STRING = "error";
  public static final String SUPERVISOR = "Supervisor";
  public static final String COUNTY_DIRECTOR = "County Director";
  public static final String POLICY_UNIT = "Policy Unit";
  public static final String DEPUTY_DIRECTOR = "Deputy Director";
  public static final String SPECIAL_INVESTIGATION = "Special Investigation";
  public static final String WHICH_SPCL_INV_APPROVER = "whichSpclInvApprover";
  public static final int ONE = 1;
  public static final int TWO = 2;
  public static final int THREE = 3;
  public static final int FOUR = 4;
  public static String RESOURCE_DETAIL_CALLED = "/resource/ResourceDetail/displayResourceDetail";
  public static String PROVIDER_ALLGTN_HISTORY_CALLED = "/resource/ProviderAllgtnHistory/displayProviderAllgtnHistory";
  
  public static final String GENERALFAILURE = "General Failure:";
  
  private Admin admin;
  private Common common;
  private Investigation investigation;
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }
  
  public void setCommon(Common common) {
    this.common = common;
  }
  
  public void setInvestigation(Investigation investigation) {
    this.investigation = investigation;
  }
  
  /**
   * This method retrieves the data needed to display the Special Investigation page and calls handleError methods.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displaySpecialInvestigation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displaySpecialInvestigation_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    try {
      state.removeAllAttributes(request);
      int idStage = GlobalData.getUlIdStage(request);
      int idCase = GlobalData.getUlIdCase(request);
      int idApproval = GlobalData.getUlIdApproval(request);
      GlobalData.setSzCdTask(SPECIAL_INVESTIGATION_TASK, request);
      int idUser = user.getUserID();
      int idEvent = CaseUtility.getEvent(idStage, SPECIAL_INVESTIGATION_TASK).getIdEvent();
      // Set the idEvent into GlobalData so as to not get confused with some other event currently 
      // stored in there. This would happen for example if we're coming to the page from the CPS INV Conclusion 
      // page 
      GlobalData.setUlIdEvent(idEvent, request);
      
      String pageMode = EventSearchConversation.getEventDetailPageMode(request, idEvent, idStage, SPECIAL_INVESTIGATION_TASK);
      SpclInvestigationRetrieveSI spclInvestigationRetrieveSI = new SpclInvestigationRetrieveSI();
      spclInvestigationRetrieveSI.setIdEvent(idEvent);
      spclInvestigationRetrieveSI.setIdCase(idCase);
      spclInvestigationRetrieveSI.setIdStage(idStage);
      SpclInvestigationRetrieveSO spclInvestigationRetrieveSO = investigation.retrieveSpclInvestigation(spclInvestigationRetrieveSI);
      
      String whichApprover = StringHelper.EMPTY_STRING;
      if (idApproval > 0) {
        whichApprover = common.determineWhichApprover(idApproval, SPECIAL_INVESTIGATION);
      }
      spclInvestigationRetrieveSO.setWhichApprover(whichApprover);
      state.setAttribute("spclInvestigationRetrieveSO", spclInvestigationRetrieveSO, request);
      
      String cdEventStatus = spclInvestigationRetrieveSO.getCdEventStatus();
      if(!PageModeConstants.VIEW.equals(pageMode)){
        pageMode = PageModeConstants.MODIFY;
      }
      
      
      boolean stageClosed = false;
      String modifyIfStageClosed = ArchitectureConstants.N;
      CaseUtility.Stage stage = CaseUtility.getStage("" + idStage);
      if (stage.getDtClose() != null) {
        stageClosed = true;
      }
      if (stageClosed) {
        boolean hasStageAccess = CaseUtility.hasStageAccess(user.getUserID(), idStage);
        if (hasStageAccess || idApproval > 0) {
          pageMode = PageModeConstants.MODIFY;
          modifyIfStageClosed = ArchitectureConstants.Y;
        }
      }
      request.setAttribute("modifyIfStageClosed", modifyIfStageClosed);
      
      if (EVENT_STATUS_APPROVED.equals(cdEventStatus)) {
        PageMode.setPageMode(PageModeConstants.INQUIRE, request);
      }
      
      PageMode.setPageMode(pageMode, request);
      
      // If the Special Investigation event is pending approval and the user did not access the page 
      // in approval mode, warn them that the pending approval will be invalidated if they save any changes.
      if (spclInvestigationRetrieveSO != null) {
        if (CodesTables.CEVTSTAT_PEND.equals(spclInvestigationRetrieveSO.getCdEventStatus()) && !GlobalData.isApprovalMode(request)
            && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
          setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
        }
      }
    }
    catch (ServiceException we) {
      handleError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERALFAILURE + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  /**
   * This method is the main call for save and submitting.  It will call the saveDetail helper method and then populate
   * the ToDoDetailDB bean for display on the To Do Detail page.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveSubmit_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveSubmit_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      SpclInvestigationSaveSO spclInvestigationSaveSO = saveDetail(context, SAVE_SUBMIT_BUTTON);
      
      // Create the ToDoDetailDB object and place it in the request with the appropriate task code to forward
      // user to the ToDo Detail page
      String taskCode = SPCL_INV_APPROVAL_TASK;
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                                   GlobalData.getUlIdStage(request), taskCode);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
    }
    catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
  
  
  /**
   * This helper method is called by the Save and Save and Submit activity methods. It will save the Contact Standards.
   *
   * @param context GrndsExchangeContext
   * @return ContactStandardsSaveSO (used for save and submits)
   * @throws ServiceException
   * @throws CheckboxHelperException
   */
  private SpclInvestigationSaveSO saveDetail(GrndsExchangeContext context, String action) throws ServiceException, CheckboxHelperException {
   
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    // Invalidating approval should set event status to PROC. Get the event Status for Invalidate Approval
    SpclInvestigationRetrieveSO spclInvestigationRetrieveSO = (SpclInvestigationRetrieveSO) state.getAttribute("spclInvestigationRetrieveSO",request);
    SpclInvestigationSaveSO spclInvestigationSaveSO = new SpclInvestigationSaveSO();
    String eventStatus = spclInvestigationRetrieveSO.getCdEventStatus();
    boolean invalidatePendingApproval = false;
    try {
      //Set the invalidate boolean to true
      if (spclInvestigationRetrieveSO.getIdEvent() != 0 && CodesTables.CEVTSTAT_PEND.equals(eventStatus)
                      && !GlobalData.isApprovalMode(request) && hasStageAccessRights(context)) {
        invalidatePendingApproval = true;
      }
      populateSpclInvestigationRetrieveSO(context, spclInvestigationRetrieveSO);
      
      boolean isSaveAndSubmitButtonPressed = false;
      // If submitting, then set the event status to PEND.
      if (SAVE_SUBMIT_BUTTON.equals(action)) {
        spclInvestigationRetrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_PEND);
        isSaveAndSubmitButtonPressed = true;
        spclInvestigationRetrieveSO.setIsSaveAndSubmitButton(isSaveAndSubmitButtonPressed);
      }
      spclInvestigationSaveSO = investigation.saveSpclInvestigation(spclInvestigationRetrieveSO);
      
      // Invalidate the approval if the Event is in Pending status and the user is not the Approver
      if (invalidatePendingApproval) {
        CCMN05UI ccmn05ui = new CCMN05UI();
        ccmn05ui.setUlIdEvent(spclInvestigationSaveSO.getIdEvent());
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
      GlobalData.setUlIdEvent(spclInvestigationSaveSO.getIdEvent(), request);
      // Clear out the object from state
      state.removeAttribute("spclInvestigationRetrieveSO", request);      
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    return spclInvestigationSaveSO;
  }
  
  /**
   * This method is the main call for saving a Special Investigation. It will make a call to the private
   * helper method passing it the appropriate action of Save
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveSpecialInvestigation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveSpecialInvestigation_xa()");
    performanceTrace.enterScope();
    
    try {
      SpclInvestigationSaveSO spclInvestigationSaveSO = saveDetail(context, SAVE_BUTTON);
    }
    catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Approval Status button on the Special Investigation page in
   * approval mode. This method cals the save function, and then we are forwarded to the Approval Status page.
   * 
   * @param context -
   *                the GrndsExchangeContext object
   * @return void
   */
  public void submitApproval_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".submitApproval_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
        
    try {
      if(GlobalData.isApprovalMode(request)) {
        // If approver is approving the special investigation and clicks the Approval Status button, we want to make sure
        // that the validation that are done during save and submit takes place
        SpclInvestigationSaveSO spclInvestigationSaveSO = saveDetail(context, SUBMIT_APPROVAL_BUTTON);
        String whichSpclInvApprover = common.determineWhichApprover(GlobalData.getUlIdApproval(request), SPECIAL_INVESTIGATION);
        state.setAttribute("whichSpclInvApprover", whichSpclInvApprover, request);
      }else {
        saveDetail(context, SAVE_BUTTON);
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
   * <p/> This method automatically saves the Special Investigation page and displays the Allegation Detail page.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void displayAllgtnDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".displayAllgtnDetail_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String pageMode = PageMode.getPageMode(request);
    
    try {
      // Save Special Investigation before proceeding to the Allegation Detail page.
      if (!PageModeConstants.VIEW.equals(pageMode))
        saveDetail(context, SAVE_BUTTON);
      
      String forwardUrl = "/investigation/Allegation/displayAllgtnDetail";
      forward(forwardUrl, request, context.getResponse());
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
      return;
    }
  }
  
  /**
   * <p>This method displays the Resource Detail when Resource ID hyperlink is clicked.
   * 
   * @param context
   */
  public void displayResourceDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayResourceDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    String pageMode = PageMode.getPageMode(request);
    
    int ulIdResource = ContextHelper.getIntSafe(context, "idResource");

    // If ulIdCase has been received correctly, send to Resource Detail page
    if (ulIdResource != 0) {
      GlobalData.setUlIdResource(ulIdResource, request);
      try {
        // Save Special Investigation before proceeding to the Resource Detail page.
        if (!PageModeConstants.VIEW.equals(pageMode))
          saveDetail(context, SAVE_BUTTON);
        forward(RESOURCE_DETAIL_CALLED, request, context.getResponse());
      } catch (ServletException se) {
        processSevereException(context, se);
      } catch (Exception e) {
        processSevereException(context, e);
      }
    }
    // If not, some sort of error
    else {
      processSevereException(
                             context,
                             new Exception(
                                           "DEBUG:SpecialInvestigationConversation -- Can't send to Resource Deatil without Resource ID"));
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  
  /**
   * <p>This method displays the Provider Allegation History when the hyperlink is clicked.
   * 
   * @param context
   */
  public void displayProviderAllgtnHistory_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayProviderAllgtnHistory_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    String pageMode = PageMode.getPageMode(request);
    
    int ulIdResource = ContextHelper.getIntSafe(context, "idResource");

    // If ulIdCase has been received correctly, send to Provider Allegation History page
    if (ulIdResource != 0) {
      GlobalData.setUlIdResource(ulIdResource, request);
      try {
        // Save Special Investigation before proceeding to the Provider Allegation History page.
        if (!PageModeConstants.VIEW.equals(pageMode))
          saveDetail(context, SAVE_BUTTON);
        forward(PROVIDER_ALLGTN_HISTORY_CALLED, request, context.getResponse());
      } catch (ServletException se) {
        processSevereException(context, se);
      } catch (Exception e) {
        processSevereException(context, e);
      }
    }
    // If not, some sort of error
    else {
      processSevereException(
                             context,
                             new Exception(
                                           "DEBUG:SpecialInvestigationConversation -- Can't send to Provider Allegation History without Resource ID"));
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  
  /**
   * This helper method is called by the saveSpecialInvestigation to populate the output object that
   * was populated from the retrieve method for the Special Investigation Save service.
   * 
   * @param context GrndeExchangeContext
   * @param spclInvestigationRetrieveSO SpclInvestigationRetrieveSO 
   * @return void
   * @throws ParseException, ServiceException
   */
  private void populateSpclInvestigationRetrieveSO (GrndsExchangeContext context, SpclInvestigationRetrieveSO spclInvestigationRetrieveSO) throws ServiceException,
                                                                                      ParseException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateSpclInvestigationRetrieveSO()");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    spclInvestigationRetrieveSO.setIduser(user.getUserID());
    int idEvent = spclInvestigationRetrieveSO.getIdEvent();
    String cdTask = GlobalData.getSzCdTask(request);
    String cdEventStatus = spclInvestigationRetrieveSO.getCdEventStatus();
    // If this is the first time we're accessing the Contact Standards page, mark the the page 
    // for ADD else set it for UPDATE
    if (CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) {
      spclInvestigationRetrieveSO.setCdReqAction(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      spclInvestigationRetrieveSO.setCdReqAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    
    
    try {
      if (idEvent > 0) {
        // if approver modifies the page, page remains PEND
        if (GlobalData.isApprovalMode(request) && isCurrentActiveApprover(context)) {
          spclInvestigationRetrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_PEND);
        } else { // demote event
          spclInvestigationRetrieveSO.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
        }
      }
      
      if (CodesTables.CEVTSTAT_PEND.equals(spclInvestigationRetrieveSO.getCdEventStatus())) {
        spclInvestigationRetrieveSO.setDtSpclInvSent(ContextHelper.getJavaDateSafe(request, "dtSpclInvSent"));
        spclInvestigationRetrieveSO.setDtSpclInvApproved(ContextHelper.getJavaDateSafe(request, "dtSpclInvApproved"));
        spclInvestigationRetrieveSO.setIndConcurAssmntDisp(ContextHelper.getStringSafe(request, "rbStateOfficeConcurDisp"));
        spclInvestigationRetrieveSO.setIndConcurActionRecmnd(ContextHelper.getStringSafe(request, "rbStateOfficeConcurCountyRecAction"));
        // Policy/Practice Review Results selected on page
        List<String> newConcurrenceCodes = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxStateOfficeConcur_"));
        if (newConcurrenceCodes == null) {
          newConcurrenceCodes = new ArrayList<String>();
        }
        spclInvestigationRetrieveSO.setConcurrenceCodes(newConcurrenceCodes);
        spclInvestigationRetrieveSO.setTxtConcurComments(ContextHelper.getStringSafe(request, "txtStateOfficeConcurComments"));
      }
      spclInvestigationRetrieveSO.setCdTask(cdTask);
      spclInvestigationRetrieveSO.setIndRcmndPlcmntRsrcClosed(CheckboxHelper.getCheckboxValue(request, "cbxPlcmntRsrcClosed"));
      spclInvestigationRetrieveSO.setIndRcmndChldrnRemoved(CheckboxHelper.getCheckboxValue(request, "cbxChildrenRemoved"));
      spclInvestigationRetrieveSO.setIndRcmndActionPlanDvlpd(CheckboxHelper.getCheckboxValue(request, "cbxActionPlanDvlpd"));
      spclInvestigationRetrieveSO.setIndRcmndNoChangeStatus(CheckboxHelper.getCheckboxValue(request, "cbxNoChangeStatus"));
      spclInvestigationRetrieveSO.setIndRcmndWaiverAttached(CheckboxHelper.getCheckboxValue(request, "cbxWaiverAttached"));
      spclInvestigationRetrieveSO.setIndRcmndCpaCciNotUsed(CheckboxHelper.getCheckboxValue(request, "cbxCpaCpiNotUsed"));
      spclInvestigationRetrieveSO.setIndRcmndOther(CheckboxHelper.getCheckboxValue(request, "cbxRcmndOther"));
      spclInvestigationRetrieveSO.setTxtRcmndOtherComments(ContextHelper.getStringSafe(request, "txtCountyRecOtherComments"));
      spclInvestigationRetrieveSO.setIndRecordChkViewed(ContextHelper.getStringSafe(request, "rbRecChkReviewed"));
      spclInvestigationRetrieveSO.setTxtSynopsisRecReviewed(ContextHelper.getStringSafe(request, "txtSynopsisRecReviewed"));
      spclInvestigationRetrieveSO.setTxtResults48hrStaffing(ContextHelper.getStringSafe(request, "txtResultsCaseStaffing"));
      spclInvestigationRetrieveSO.setTxtNamesAgncyRepStaffing(ContextHelper.getStringSafe(request, "txtNamesAgenciesRepCaseStaffing"));
      spclInvestigationRetrieveSO.setTxtJustHmeRemainOpen(ContextHelper.getStringSafe(request, "txtJustHmeRemainOpen"));
      spclInvestigationRetrieveSO.setTxtStepsAssureSafety(ContextHelper.getStringSafe(request, "txtStepsToAssureSafetyOfChildren"));
      
      List<SpclInvHmeWaiverChildHistBean> waiverChildHistBeans = spclInvestigationRetrieveSO.getSpclInvHmeWaiverChildHistBeans();
      if (waiverChildHistBeans != null && !waiverChildHistBeans.isEmpty()) {
        for (int i = 0; i < waiverChildHistBeans.size(); i++) {
          SpclInvHmeWaiverChildHistBean waiverChildHist = waiverChildHistBeans.get(i);
          waiverChildHist.setIndRemainInHome(CheckboxHelper.getCheckboxValue(request, "cbxWaiverChildHist_" + i));
        }
      }
      
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
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
    
    if (Messages.MSG_CMN_TMSTAMP_MISMATCH == errorCode || Messages.MSG_SYS_EVENT_STS_MSMTCH == errorCode ||
                    Messages.MSG_SYS_STAGE_CLOSED == errorCode || Messages.MSG_DATABASE_SAVE_FAIL == errorCode){
      setErrorMessage(errorCode, context.getRequest());
    } else {
      processSevereException(context, we);
    }          
  }

}
