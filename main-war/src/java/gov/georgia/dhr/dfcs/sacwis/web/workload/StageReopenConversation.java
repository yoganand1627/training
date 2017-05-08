package gov.georgia.dhr.dfcs.sacwis.web.workload;

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
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageReopenRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageReopenSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageReopenRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageReopenSaveSO;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Enumeration;


import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This Conversation class handles the display, save, update of the
 * Stage Reopen page 
 * 
 * @author Bhavna Gehlot
 */

/**Change History:
  *
  *  Date        User              Description
  *  --------    ----------------  ----------------------------------------------
  * 09/17/2009   bgehlot           Retain Previous Closure info when coming back to reopen stage page from staff search page
  * 06/22/2011   schoi             SMS #112163 Updated the name of the message from MSG_MISSING_REC_CHECK_OVER_18 to MSG_MISSING_REC_CHECK_OVER_17
  *                                to be in sync with the message text and name change per policy change
*/

public class StageReopenConversation extends BaseHiddenFieldStateConversation {
  
  public static final String TRACE_TAG = "StageReopenConversation";
  public static final String SUB_TASK_CODE = "9944";
  public static final String FSU_TASK_CODE = "9943";
  public static final String ADO_TASK_CODE = "9941";
  public static final String PAD_TASK_CODE = "9945";
  public static final String FPR_TASK_CODE = "9942";
  public static final String DIV_TASK_CODE = "9947";
  public static final String PFC_TASK_CODE = "9946";
  public static final String SAVE = "save";
  public static final String DESTINATION_URL = "/workload/StageReopen/setStaff";

        
  private Admin admin;
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }


  /**
   * This method is called by the GRNDS controller when displaying the Safety Resource page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayStageReopen_xa(GrndsExchangeContext context) {
    
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStageReopen_xa()");
    performanceTrace.enterScope();
    
    try {
      
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      
      if(GlobalData.getUlIdEvent(request) != 0){
        if("".equals(GlobalData.getSzCdTask(request))){
          String taskCode = getTaskCode(GlobalData.getSzCdStage(request));
          CaseUtility.Event testEvent = CaseUtility.getEvent(GlobalData.getUlIdStage(request), taskCode);
          int testEventId = testEvent.getIdEvent();
          GlobalData.setUlIdEvent(testEventId, request);
        }
      }
      
      StageReopenRetrieveSI stageReopenRetrieveSI = populateStageReopenRetrieveSI(context);
      StageReopenRetrieveSO stageReopenRetrieveSO = admin.retrieveStageReopen(stageReopenRetrieveSI);
      state.setAttribute("stageReopenRetrieveSO", stageReopenRetrieveSO, request);
         
      
      // set page mode
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_SUB)) {

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         stageReopenRetrieveSO.getUlIdEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         SUB_TASK_CODE);
        PageMode.setPageMode(pageMode, request);
      }
      if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_FSU)) {
        

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         stageReopenRetrieveSO.getUlIdEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         FSU_TASK_CODE);
        PageMode.setPageMode(pageMode, request);
      }
      
     if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_ADO)) {
        

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         stageReopenRetrieveSO.getUlIdEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         ADO_TASK_CODE);
        PageMode.setPageMode(pageMode, request);
      }
      
      
      if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_PAD)) {
        

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         stageReopenRetrieveSO.getUlIdEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         PAD_TASK_CODE);
        PageMode.setPageMode(pageMode, request);
      }
      
  
      if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_FPR)) {
        

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         stageReopenRetrieveSO.getUlIdEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         FPR_TASK_CODE);
        PageMode.setPageMode(pageMode, request);
      }
      
      if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_DIV)) {
        

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         stageReopenRetrieveSO.getUlIdEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         DIV_TASK_CODE);
        PageMode.setPageMode(pageMode, request);
      }
      
      if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_PFC)) {

        String pageMode = EventSearchConversation.getEventDetailPageMode(request,
                                                                         stageReopenRetrieveSO.getUlIdEvent(),
                                                                         GlobalData.getUlIdStage(request),
                                                                         PFC_TASK_CODE);
        PageMode.setPageMode(pageMode, request);
      }
    }
    catch (ServiceException we) {
      handleException(we, context);
    }
    catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  
 /**
   * This method is called by the GRNDS controller when saving a Safety Resource.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveStageReopen_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveStageReopen_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    
    try {
      int eventId = saveStageReopen(context, SAVE);
      GlobalData.setUlIdEvent(eventId, request);
    } catch (ServiceException we) {
      handleException(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return; 
  
  }
  

  /**
   * This method is used when the safety Resource needs to be saved. 
   * @param context
   * @param assessment
   * @param method
   */
  private int saveStageReopen(GrndsExchangeContext context, String method) {    
    int idEvent = 0;
    
    try {

      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      UserProfile user = UserProfileHelper.getUserProfile(request);
      GlobalData.setUlIdPerson(user.getUserID(), request);

      StageReopenSaveSI stageReopenSaveSI = populateStageReopenSaveSI(context, user, state, method);  
      
      StageReopenSaveSO stageReopenSaveSaveSO = admin.saveStageReopen(stageReopenSaveSI);
      idEvent = stageReopenSaveSaveSO.getUlIdEvent();
      GlobalData.setUlIdEvent(idEvent, request);
      
    } catch (ServiceException se) {
      handleException(se, context);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    return idEvent;
  }
  
  /*
   * Temporarily saves the state of data on the Reopen Stage page then forwards to the Staff Search page. When the user returns
   * to the  Reopen Stage, all page data is still entered.
   */
  public void performStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performStaffSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    StageReopenRetrieveSO stageReopenRetrieveSO = new StageReopenRetrieveSO();

    int idEvent = ContextHelper.getIntSafe(request, "ulIdEvent");
    stageReopenRetrieveSO.setSzNmPerformedBy(ContextHelper.getStringSafe(request, "szNmPerformedBy"));
    stageReopenRetrieveSO.setDtStageReopened(ContextHelper.getJavaDateSafe(request, "txtDtDtStageReopen"));
    stageReopenRetrieveSO.setSzTxtStageReopenCmnts(ContextHelper.getStringSafe(request, "selSzTxtStageReopenCmnts"));
    stageReopenRetrieveSO.setCheckedCheckboxes(CheckboxHelper.getCheckedValues(request, "chkReopenReasons"));
    stageReopenRetrieveSO.setUlIdEvent(idEvent);
    stageReopenRetrieveSO.setUlIdStage(ContextHelper.getIntSafe(request, "idStage"));
    stageReopenRetrieveSO.setSzCdTask(ContextHelper.getStringSafe(request, "cdTask"));
    //Retain Previous Closure info when coming back to reopen stage page from staff search page
    stageReopenRetrieveSO.setDtStageClosure(DateHelper.toJavaDateSafe(request.getParameter("hdnDtStageClosure")));
    stageReopenRetrieveSO.setSzClosureReason(ContextHelper.getStringSafe(request, "hdnSzClosureReason"));
    stageReopenRetrieveSO.setTxtClosureComments(ContextHelper.getStringSafe(request, "hdnTxtClosureComments"));
    stageReopenRetrieveSO.setNmApprover(ContextHelper.getStringSafe(request, "hdnNmApprover"));
    stageReopenRetrieveSO.setDtApproval(ContextHelper.getJavaDateSafe(request, "hdnDtApproval"));
    stageReopenRetrieveSO.setTxtApproversComments(ContextHelper.getStringSafe(request, "hdnTxtApproversComments"));


    state.setAttribute("stageReopenRetrieveSO", stageReopenRetrieveSO, request);

    StaffSearchInput io = new StaffSearchInput();
    io.setSourcePage(StaffSearchInput.OTHER);
    io.setDestinationUrl(DESTINATION_URL);
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

    StageReopenRetrieveSO stageReopenRetrieveSO = (StageReopenRetrieveSO) state.getAttribute("stageReopenRetrieveSO", request);
    if (stageReopenRetrieveSO == null) {
      stageReopenRetrieveSO = new StageReopenRetrieveSO();
    }

    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

    if (ccmn50do_array == null) {
      ccmn50do_array = new ROWCCMN50DO_ARRAY();
    }

    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    if (e.hasMoreElements()) {
      ROWCCMN50DO staff = (ROWCCMN50DO) e.nextElement();
      stageReopenRetrieveSO.setSzNmRequestedBy(staff.getSzNmPersonFull());
      stageReopenRetrieveSO.setIdRequestedBy(staff.getUlIdPerson());
    }
    state.setAttribute("stageReopenRetrieveSO", stageReopenRetrieveSO, request);

    performanceTrace.exitScope();
  }
   
  /**
   * This method is called by the other methods when an exception is caught.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param e
   *          The Exception
   * @param methodName
   *          A String containing the method which threw the exception
   */
  private void handleException(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SYS_MULT_INST:
      setErrorMessage(we.getErrorCode(), request);
      break;
    //STGAP00014329: Added this message for the records check
    // SMS #112163 Updated the name of the message from MSG_MISSING_REC_CHECK_OVER_18 to MSG_MISSING_REC_CHECK_OVER_17 
    // to be in sync with the message text and name change per policy change   
    // NOTE: This message here is not used by any code outside of this, but updating the name of the message for possible re-use 
    case Messages.MSG_MISSING_REC_CHECK_OVER_17:
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      setErrorMessage(Messages.MSG_MISSING_REC_CHECK_OVER_17, request);
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
   * This method populates the StageReopenRetrieveSI object.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private StageReopenRetrieveSI populateStageReopenRetrieveSI(GrndsExchangeContext context) {
    
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    StageReopenRetrieveSI stageReopenRetrieveSI = new StageReopenRetrieveSI();
    
    int ulIdEvent = GlobalData.getUlIdEvent(request);
    int ulIdStage = GlobalData.getUlIdStage(request);
 
    stageReopenRetrieveSI.setUlIdEvent(ulIdEvent);
    stageReopenRetrieveSI.setUlIdStage(ulIdStage);
    stageReopenRetrieveSI.setUlIdUser(user.getUserID());
    
    return stageReopenRetrieveSI;
  }
  
  /**
   * This method populates the StageReopenSaveSI object.
   * 
   * @param context
   * @param user
   * @param state
   */
  private StageReopenSaveSI populateStageReopenSaveSI(GrndsExchangeContext context, 
        UserProfile user, BaseSessionStateManager state, String method) {
    
    HttpServletRequest request = context.getRequest();
    StageReopenSaveSI stageReopenSaveSI = new StageReopenSaveSI();
    
    StageReopenRetrieveSO stageReopenRetrieveSO = (StageReopenRetrieveSO) state.getAttribute("stageReopenRetrieveSO",request);
    
    int ulIdEvent = GlobalData.getUlIdEvent(request);
    int ulIdStage = GlobalData.getUlIdStage(request);
    int ulIdCase = GlobalData.getUlIdCase(request);
    String cdTask = GlobalData.getSzCdTask(request);
    
    //Set the task code depending on the current stage
    if (StringHelper.checkForEquality(GlobalData.getSzCdStage(request),CodesTables.CSTAGES_SUB)){
      stageReopenSaveSI.setCdTask(SUB_TASK_CODE);
    } else if(StringHelper.checkForEquality(GlobalData.getSzCdStage(request),CodesTables.CSTAGES_FSU)){
      stageReopenSaveSI.setCdTask(FSU_TASK_CODE);
    }else if(StringHelper.checkForEquality(GlobalData.getSzCdStage(request),CodesTables.CSTAGES_ADO)){
      stageReopenSaveSI.setCdTask(ADO_TASK_CODE);
    }else if(StringHelper.checkForEquality(GlobalData.getSzCdStage(request),CodesTables.CSTAGES_PAD)){
      stageReopenSaveSI.setCdTask(PAD_TASK_CODE);
    }else if(StringHelper.checkForEquality(GlobalData.getSzCdStage(request),CodesTables.CSTAGES_DIV)){
      stageReopenSaveSI.setCdTask(DIV_TASK_CODE);
    }else if(StringHelper.checkForEquality(GlobalData.getSzCdStage(request),CodesTables.CSTAGES_FPR)){
      stageReopenSaveSI.setCdTask(FPR_TASK_CODE);
    }else if(StringHelper.checkForEquality(GlobalData.getSzCdStage(request),CodesTables.CSTAGES_PFC)){
      stageReopenSaveSI.setCdTask(PFC_TASK_CODE);
    }

    stageReopenSaveSI.setSzEventStatus(CodesTables.CEVTSTAT_COMP);
    
    stageReopenSaveSI.setUlIdEvent(ulIdEvent);
    stageReopenSaveSI.setUlIdCase(ulIdCase);
    stageReopenSaveSI.setUlIdStage(ulIdStage);
    stageReopenSaveSI.setSzCdTask(cdTask);
                                  
    stageReopenSaveSI.setUlIdPerson(user.getUserID());
    
    stageReopenSaveSI.setIdPerformedBy(user.getUserID());
    stageReopenSaveSI.setIdRequestedBy(ContextHelper.getIntSafe(request, "idRequestedBy"));
    stageReopenSaveSI.setDtStageReopened(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    stageReopenSaveSI.setSzTxtStageReopenCmnts(ContextHelper.getStringSafe(request, "selSzTxtStageReopenCmnts"));
    stageReopenSaveSI.setCheckedCheckboxes(CheckboxHelper.getCheckedValues(request, "chkReopenReasons"));
    
    stageReopenSaveSI.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));

    return stageReopenSaveSI;
  }
  
  /**
   * This helper method takes in the Stage code to determines the Task Code and returns it. Called by
   * displayStageReopen_xa.
   * 
   * @param testCdStage
   *          String
   * @return taskCode
   */
  private String getTaskCode(String testCdStage) {
    String taskCode = StringHelper.EMPTY_STRING;
    //Set the task code depending on the current stage
    if (StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_SUB)){
      taskCode = SUB_TASK_CODE;
    } else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_FSU)){
      taskCode = FSU_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_ADO)){
      taskCode = ADO_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_PAD)){
      taskCode = PAD_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_DIV)){
      taskCode = DIV_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_FPR)){
      taskCode = FPR_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_PFC)){
      taskCode = PFC_TASK_CODE;
    }
    return taskCode;
  }
} 