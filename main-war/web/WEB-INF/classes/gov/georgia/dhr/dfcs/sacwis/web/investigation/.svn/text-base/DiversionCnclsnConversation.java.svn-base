package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Date;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveTaskList;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.Investigation;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfRecordsCheckCompletedSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiversionCnclsnRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiversionCnclsnSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveDiversionConclusionValidationSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiversionCnclsnRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to display, save and save and submit the Diversion Conclusion page.
 * 
 * @author ade.odutayo
 * 
 * <pre>
 *         Change History:
 *         Date      User      Description
 *         --------  --------  --------------------------------------------------
 *       08/18/2010  bgehlot SMS 66380 MR-072 Changes              
 *       09/08/2010  bgehlot SMS 69753 Pass the cdDisposition from the request.
 * </pre>
 */
public class DiversionCnclsnConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "DiversionCnclsnConversation";
  
  private static final String GENERAL_FAILURE_STRING = "General Failure:";

  public static final String DIVRSN_CONCL_TASK_CD = "2335";
  
  public static final String APP_DIVRSN_CONCL_TASK_CD = "2345";

  public static final String YES = ArchitectureConstants.Y;

  public static final String NO = ArchitectureConstants.N;
  
  private InvalidateApproval invalidateApproval = null;
  
  public static final String SAVE_SUBMIT = ServiceConstants.REQ_FUNC_CD_UPDATE;

  public static final String EVENT_STATUS_PENDING = CodesTables.CEVTSTAT_PEND;

  public static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_STATUS_IN_PROCESS = CodesTables.CEVTSTAT_PROC;
  
  public static final String DIVERSION = "DIV";

  private static final int METHOD_SAVE = 0;

  private static final int METHOD_SAVE_SUBMIT = 1;
  
  public static final int PAGE_SIZE = 50;
  
  public static final String DIVERSION_CNCLSN = "Diversion Conclusion";

  private Admin admin;

  private Common common;
  
  private Investigation investigation;
  
  private Person person;

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }
  
  public void setCommon(Common common) {
    this.common = common;
  }
  
  public void setInvestigation(Investigation investigation) {
    this.investigation = investigation;
  }
  
  public void setPerson(Person person) {
    this.person = person;
  }
  
  private RetrieveTaskList retrieveTaskList;

  public void setRetrieveTaskList(RetrieveTaskList retrieveTaskList) {
    this.retrieveTaskList = retrieveTaskList;
  }

  /**
   * Called by GRNDS Controller when user requests the diversion conclusion page by clicking on the tab
   */
  public void displayDiversionCnclsn_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayDiversionCnclsn_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      state.removeAllAttributes(request);
      int stageId = GlobalData.getUlIdStage(request);
      DiversionCnclsnRetrieveSI diversionCnclsnRetrieveSI = populateDiversoinCnclsnRetrieveSI(context);
      int diversionEventId = diversionCnclsnRetrieveSI.getIdEvent();
      GlobalData.setUlIdEvent(diversionEventId, request);
      
      // if coming from a non-INT stage, we are in VIEW mode
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      if (GlobalData.getSzCdStage(request).equals(DIVERSION)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(DIVRSN_CONCL_TASK_CD, request);
        String pageMode = EventSearchConversation.getEventDetailPageMode(request, diversionEventId, stageId,
                                                                         DIVRSN_CONCL_TASK_CD);
        PageMode.setPageMode(pageMode, request);
      }
      DiversionCnclsnRetrieveSO diversionCnclsnRetrieveSO = investigation.retrieveDiversionCnclsn(diversionCnclsnRetrieveSI);
      
      if (CodesTables.CEVTSTAT_PEND.equals(diversionCnclsnRetrieveSO.getROWCCMN45DO().getSzCdEventStatus())
                      && (!GlobalData.isApprovalMode(request) && !GlobalData.isStageClosureBeingApproved(request))) {
        setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
        setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);                    
      }
      
      state.setAttribute("DiversionCnclsnRetrieveSO", diversionCnclsnRetrieveSO, request);
      GlobalData.setUlIdCase(diversionCnclsnRetrieveSO.getIdCase(), request);
      GlobalData.setUlIdStage(diversionCnclsnRetrieveSO.getIdStage(), request);
      GlobalData.setUlIdEvent(diversionCnclsnRetrieveSO.getIdDiversionCnclsn(), request);
      // Get ROWCCMN45DO and do a null check so we can use Event Status in the Page Mode Logic.
      gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO row45 = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO();
      if (diversionCnclsnRetrieveSO.getROWCCMN45DO() != null) {
        row45 = diversionCnclsnRetrieveSO.getROWCCMN45DO();
      }
      String eventStatus = row45.getSzCdEventStatus();
      // eventStatus = EVENT_STATUS_APPROVED;
      if (eventStatus.equals(EVENT_STATUS_APPROVED)) {
        PageMode.setPageMode(PageModeConstants.INQUIRE, request);
      }
      
      //check to see if individual is current approver
      if(isCurrentActiveApprover(context))
        state.setAttribute("ISCURRENTAPPROVER", ArchitectureConstants.Y, request);
      else
        state.setAttribute("ISCURRENTAPPROVER", ArchitectureConstants.N, request);
      
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_DIV_NO_EXISTS:
      case Messages.MSG_NO_ROWS_RETURNED:
      case Messages.MSG_DIV_NOT_BEGUN:
        String errorMessage = MessageLookup.getMessageByNumber(we.getErrorCode());
        displayMessagePage(errorMessage, context);
        break;
      default:
        handleError(we, context);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Called by GRNDS Controller when user saves the diversion conclusion page
   */
  public void saveDiversionCnclsn_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveDiversionCnclsn_xa()");
    performanceTrace.enterScope();
    try {
      save(context, METHOD_SAVE);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Called by GRNDS Controller when user clicks on the save and submit button on the Diversion Conclusion page
   */
  public void saveSubmitDiversionCnclsn_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveSubmitDiversionCnclsn_xa()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      // Validate
      SaveDiversionConclusionValidationSI saveDiversionConclusionValidationSI = populateSaveDiversionConclusionValidationSI(context);
      List<Integer> nbrMessageCodes = investigation.saveDiversionConclusionValidation(saveDiversionConclusionValidationSI);
      
      //MR-072 Check to see if the records check are completed on all the persons added or related to the stage
      CheckIfRecordsCheckCompletedSI checkIfRecordsCheckCompletedSI = new CheckIfRecordsCheckCompletedSI();
      checkIfRecordsCheckCompletedSI.setIdStage(GlobalData.getUlIdStage(request));
      checkIfRecordsCheckCompletedSI.setPageName(DIVERSION_CNCLSN);
      
      //MR-072 get the disposition
      String cdDiversionDisposition = saveDiversionConclusionValidationSI.getCdStageReasonClosed();      
      checkIfRecordsCheckCompletedSI.setCdDIVDisposition(cdDiversionDisposition);
      
      String recordsCheckCompleted = person.checkIfRecordsCheckCompleted(checkIfRecordsCheckCompletedSI);
      
      
      
      //Check to see if the records check are completed for all the persons on DIV stage
      if((CodesTables.CDIVDSPN_NFI.equals(cdDiversionDisposition) || CodesTables.CDIVDSPN_RFS.equals(cdDiversionDisposition)
                      || CodesTables.CDIVDSPN_OIE.equals(cdDiversionDisposition)) && ArchitectureConstants.FALSE.equals(recordsCheckCompleted)){
        nbrMessageCodes.add(Messages.MSG_RECORDS_CHECK_REQ);
      }
      
      // If the validation service returns an error list, put the errors in the request and set the error branch
      if (nbrMessageCodes != null && nbrMessageCodes.size() != 0){
        int[] errorArray = getNbrMessageCode(nbrMessageCodes);
        ErrorList.setErrors(errorArray, request);
        this.setPresentationBranch("error", context);
        //MR-072
        request.setAttribute("warnRecordsCheckNotCompleted", ArchitectureConstants.N);
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
      } else {
        //MR-072
        if(CodesTables.CDIVDSPN_RFI.equals(cdDiversionDisposition) && 
            !ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnRecordsCheckCompletedConfirmed")) 
            && ArchitectureConstants.FALSE.equals(recordsCheckCompleted)){
          request.setAttribute("warnRecordsCheckNotCompleted", ArchitectureConstants.Y);
          ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
          setPresentationBranch("warn", context);
          return;
        }
        save(context, METHOD_SAVE_SUBMIT);
      
        // Set data for ToDo Detail page
        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                                     GlobalData.getUlIdStage(request), APP_DIVRSN_CONCL_TASK_CD);
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
      }
    } catch (ServiceException we) {
      handleError(we, context);
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  private void save(GrndsExchangeContext context, int method) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".save()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    DiversionCnclsnRetrieveSO retrieveSO  = (DiversionCnclsnRetrieveSO)state.getAttribute("DiversionCnclsnRetrieveSO", request);
    
    
    try{
         
      
      DiversionCnclsnRetrieveSI diversionCnclsnRetrieveSI = populateDiversoinCnclsnRetrieveSI(context);
      DiversionCnclsnRetrieveSO diversionCnclsnRetrieveSO = investigation.retrieveDiversionCnclsn(diversionCnclsnRetrieveSI);
      state.setAttribute("DiversionCnclsnRetrieveSO", diversionCnclsnRetrieveSO, request);
      
      DiversionCnclsnSaveSI diversionCnclsnSaveSI = populateDiversionCnclsnSaveSI(context);
      diversionCnclsnSaveSI.setDtLastUpdate(diversionCnclsnRetrieveSO.getDtLastUpdate());
      diversionCnclsnSaveSI.setROWCCMN45DO(copyROWCCMN45DO(diversionCnclsnRetrieveSO.getROWCCMN45DO()));
      
      //-- eventStatus represents the current status retrieved from the db
      String eventStatus = diversionCnclsnSaveSI.getROWCCMN45DO().getSzCdEventStatus();
      //-- Now reset the event status
      switch (method) {
      case METHOD_SAVE:
        diversionCnclsnSaveSI.getROWCCMN45DO().setSzCdEventStatus(EVENT_STATUS_IN_PROCESS);
        break;
      case METHOD_SAVE_SUBMIT:
        diversionCnclsnSaveSI.getROWCCMN45DO().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
        break;
      }
            
      if (retrieveSO != null && CodesTables.CEVTSTAT_PEND.equals(retrieveSO.getROWCCMN45DO().getSzCdEventStatus())
          && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
        CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(GlobalData.getUlIdEvent(request));
        invalidateApproval.invalidateApproval(ccmn05ui);
      }
      
      investigation.saveDiversionCnclsn(diversionCnclsnSaveSI);
    }catch(ServiceException se) {
      handleError(se, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    
    performanceTrace.exitScope();
  }
  
  private DiversionCnclsnSaveSI populateDiversionCnclsnSaveSI(GrndsExchangeContext context) throws ServiceException, MarshalException,  ValidationException{
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateDiversionCnclsnSaveSI()" + new Date());
    performanceTrace.enterScope(); 
    
    HttpServletRequest request = context.getRequest();
    DiversionCnclsnSaveSI diversionCnclsnSaveSI = new DiversionCnclsnSaveSI();
    ArchInputStruct inputStruct = new ArchInputStruct();
    inputStruct.setUsPageNbr(1);
    inputStruct.setBPerfInd(YES);
    inputStruct.setBDataAcsInd(YES);
    inputStruct.setUlPageSizeNbr(PAGE_SIZE);
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    inputStruct.setSzUserId(String.valueOf(userID));
    diversionCnclsnSaveSI.setArchInputStruct(inputStruct);
    
    diversionCnclsnSaveSI.setIdDiversionCnclsn(ContextHelper.getIntSafe(request, "hdnUlIdEvent"));
    diversionCnclsnSaveSI.setIdCase(ContextHelper.getIntSafe(request, "hdnUlIdCase"));
    diversionCnclsnSaveSI.setIdStage(ContextHelper.getIntSafe(request, "hdnUlIdStage"));
    diversionCnclsnSaveSI.setDtResponse(ContextHelper.getJavaDateSafe(request, "dtResponseDate"));
    diversionCnclsnSaveSI.setDtDiversionTaskCompleted(ContextHelper.getJavaDateSafe(request, "dtDiversionTasks"));
    diversionCnclsnSaveSI.setSzCdDisposition(ContextHelper.getStringSafe(request, "selSzCdDisposition"));
    
    performanceTrace.exitScope();
    return diversionCnclsnSaveSI;
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
  
  
  /**
   * This helper method is called by the displayCPSInvCnclsn_xa to populate the input object for the cinv14s retrieve
   * service.
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */
  private DiversionCnclsnRetrieveSI populateDiversoinCnclsnRetrieveSI(GrndsExchangeContext context)
                                                                                                   throws ServiceException,
                                                                                                   MarshalException,
                                                                                                   ValidationException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateDiversoinCnclsnRetrieveSI()" + new Date());
    performanceTrace.enterScope();

    DiversionCnclsnRetrieveSI diversionCnclsnRetrieveSI = new DiversionCnclsnRetrieveSI();
    ArchInputStruct inputStruct = new ArchInputStruct();
    inputStruct.setUsPageNbr(1);
    inputStruct.setBPerfInd(YES);
    inputStruct.setBDataAcsInd(YES);
    inputStruct.setUlPageSizeNbr(PAGE_SIZE);
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    inputStruct.setSzUserId(String.valueOf(userID));

    diversionCnclsnRetrieveSI.setArchInputStruct(inputStruct);
    int stageId = getDiversionStageId(context);
    diversionCnclsnRetrieveSI.setIdStage(stageId);

    int eventId = CaseUtility.getEvent(stageId, DIVRSN_CONCL_TASK_CD).getIdEvent();
    diversionCnclsnRetrieveSI.setIdEvent(eventId);

    performanceTrace.exitScope();
    return diversionCnclsnRetrieveSI;
  }

  private SaveDiversionConclusionValidationSI populateSaveDiversionConclusionValidationSI(GrndsExchangeContext context) {
    
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateSaveDiversionConclusionValidationSI()" + new Date());
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    SaveDiversionConclusionValidationSI saveDiversionConclusionValidationSI = new SaveDiversionConclusionValidationSI();
    saveDiversionConclusionValidationSI.setDtDiversionDtlBegun(ContextHelper.getJavaDateSafe(request, "dtResponseDate"));
    saveDiversionConclusionValidationSI.setCdTask(DIVRSN_CONCL_TASK_CD);
    int stageId = GlobalData.getUlIdStage(request);
    saveDiversionConclusionValidationSI.setIdStage(stageId);
    int eventId = CaseUtility.getEvent(stageId, DIVRSN_CONCL_TASK_CD).getIdEvent();
    saveDiversionConclusionValidationSI.setIdEvent(eventId);
    String overallDisposition = ContextHelper.getStringSafe(request, "selSzCdDisposition");
    saveDiversionConclusionValidationSI.setIdCase(GlobalData.getUlIdCase(request));
    saveDiversionConclusionValidationSI.setCdStageReasonClosed(overallDisposition);

    
    performanceTrace.exitScope();
    return saveDiversionConclusionValidationSI;
  }
  
  
  private int getDiversionStageId(GrndsExchangeContext context) throws ServiceException, MarshalException,
                                                            ValidationException {
    HttpServletRequest request = context.getRequest();
    if (DIVERSION.equalsIgnoreCase(GlobalData.getSzCdStage(request))) {
      return GlobalData.getUlIdStage(request);
    }
    return getPriorDiversionStageId(context);
  }

  /** Gets the id of the prior stage for a given stage (and ensures it's a DIVERSION stage) */
  public int getPriorDiversionStageId(GrndsExchangeContext context) throws ServiceException, MarshalException,
                                                                ValidationException {
    CCMN50SO ccmn50so = callCCMN50S(context);
    int priorStageId = ccmn50so.getUlIdPriorStage();

    CaseUtility.Stage stage = CaseUtility.getStage(priorStageId);
    if (DIVERSION.equalsIgnoreCase(stage.getCdStage())) {
      return priorStageId;
    }
    throw new ServiceException(Messages.MSG_DIV_NO_EXISTS);
  }

  /** Find prior Stage Id */
  private CCMN50SO callCCMN50S(GrndsExchangeContext context) throws ServiceException, MarshalException,
                                                            ValidationException

  {
    HttpServletRequest request = context.getRequest();

    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setSzUserId((UserProfileHelper.getUserProfile(request).getUserLogonID()));

    CCMN50SI ccmn50si = new CCMN50SI();

    int stageId = (GlobalData.getUlIdStage(request));
    ccmn50si.setUlIdStage(stageId);
    ccmn50si.setCIndTaskRtrvPriorStage("1");

    try {
      CCMN50SO ccmn50so = retrieveTaskList.findTaskListEvents(ccmn50si);

      return ccmn50so;
    } catch (ServiceException e) {
      int errorCode = e.getErrorCode();
      if ((errorCode == Messages.SQL_NOT_FOUND) || ((errorCode == 0) && (e.getErrorCode() == Messages.SQL_NOT_FOUND))) {

        throw new ServiceException(Messages.MSG_INV_NO_EXISTS);
      }
      throw e;
    }
  }
  /**
   * This helper method copies the ROWCCMN45DO output object of the retrieve service to the ROWCCMN45DO input object for
   * the save. Since the two objects have the same name, we are able to unmarshall the data from the output object INTO
   * the input object.
   * 
   * @param rowccmn45do
   *          ROWCCMN45DO inputstruct
   */
  private ROWCCMN45DO copyROWCCMN45DO(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO rowccmn45do) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "copyROWCCMN45DO()" + new Date());
    performanceTrace.enterScope();

    ROWCCMN45DO newRow = new ROWCCMN45DO();
    if (rowccmn45do == null) {
      return newRow;
    }

    if (rowccmn45do.hasUlIdEvent()) {
      newRow.setUlIdEvent(rowccmn45do.getUlIdEvent());
    }
    if (rowccmn45do.hasUlIdPerson()) {
      newRow.setUlIdPerson(rowccmn45do.getUlIdPerson());
    }
    if (rowccmn45do.hasUlIdStage()) {
      newRow.setUlIdStage(rowccmn45do.getUlIdStage());
    }
    newRow.setDtDtEventOccurred(rowccmn45do.getDtDtEventOccurred());
    String bMoreDataInd = rowccmn45do.getBMoreDataInd();
    if (bMoreDataInd != null && !"".equals(bMoreDataInd)) {
      newRow.setMoreDataAvailable(Boolean.parseBoolean(bMoreDataInd));
    }
    newRow.setSzCdEventStatus(rowccmn45do.getSzCdEventStatus());
    newRow.setSzCdEventType(rowccmn45do.getSzCdEventType());
    newRow.setSzCdTask(rowccmn45do.getSzCdTask());
    newRow.setSzTxtEventDescr(rowccmn45do.getSzTxtEventDescr());
    newRow.setTsLastUpdate(rowccmn45do.getTsLastUpdate());

    performanceTrace.exitScope();
    return newRow;
  }
  
  /**
   * This method is called when the user clicks the Approval Status button on the Diversion Conclusion page. We will call the save() helper
   * method and then submit for approval. If the Diversion  passes validation, we are forwarded to the Approval Status page.
   * 
   * @param context
   *          the GrndsExchangeContext object
   */
  public void submitApproval_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".submitApproval_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      save(context, METHOD_SAVE_SUBMIT);
      
    } catch (ServiceException we) {
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE_STRING + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
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

      //-- return true if user is approver
      if (loggedInUserId == approverId) {
        result = true;
      }
    }

    return result;
  }
  
  /**
   * Converts a list of Integers into a primitive int[]
   * 
   * @param nbrMessageCodeList
   * @return int[]
   */
  public int[] getNbrMessageCode(List nbrMessageCodeList)
  {
      int size = nbrMessageCodeList.size();
      int[] array = new int[size];
      for (int index = 0; index < size; index++){
          array[index] = ((java.lang.Integer)nbrMessageCodeList.get(index)).intValue();
      }
      
      return array;
  } 
  
  /**
   * This helper method handles all the Service Exceptions thrown by the Save services. Called by the following methods:
   * saveDiversionCnclsn_xa & saveSubmitDiversionCnclsn_xa
   * 
   * @param we
   * @param context
   *          The GrndsExchangeContext object.
   */
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
      processSevereException(context, we);
      break;
    }
  }
}
