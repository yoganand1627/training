package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RestrictedFundsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RestrictedFundsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RestrictedFundsSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

@SuppressWarnings("serial")
public class RestrictedFundsConversation extends BaseHiddenFieldStateConversation {
  public static final String FORM_NAME = "frmRestrictedFunds";
  public static final String CHILD_NAME_NAME = "dspChildName";
  public static final String CHECKING_BALANCE_NAME = "dspCheckingBalance";
  public static final String SAVINGS_BALANCE_NAME = "dspSavingsBalance";
  public static final String RESERVED_AMOUNT_NAME = "txtReservedAmount";
  public static final String RESERVED_REASON_NAME = "txtReservedReason";
  public static final String STATUS_NAME = "dspStatus";
  public static final String APPROVAL_STATUS_BUTTON_NAME = "btnApprovalStatus";
  public static final String SAVE_BUTTON_NAME = "btnSave";
  public static final String SAVE_SUBMIT_BUTTON_NAME = "btnSaveAndSubmit";
  public static final String RESTRICTED_FUNDS_SO = "RestrictedFundsSO";
  /*public static final Map<String, String> TASK_MAP = new HashMap<String, String>() {
    {
      put("SUB", "3450");
      put("FSU", "4430");
      put("FPR", "7030");
      put("ADO", "8920");
      put("PFC", "6510");
    }
  };*/
  public static final Map<String, String> APPROVAL_TASK_MAP = new HashMap<String, String>() {
    {
      put(CodesTables.CSTAGES_SUB, "3460");
      put(CodesTables.CSTAGES_FSU, "4440");
      put(CodesTables.CSTAGES_FPR, "7040");
      put(CodesTables.CSTAGES_ADO, "8930");
      put(CodesTables.CSTAGES_PFC, "6520");
    }
  };
  //-- do not remove! this is used by CaseTabs.java
  public static List<String> TASKS = new ArrayList<String>(){
    {
      add("3450");
      add("4430");
      add("7030");
      add("8920");
      add("6510");
    }
  };
  
  private static final String TRACE_TAG = "RestrictedFundsConversation";
  private static final int SAVE = 0;
  private static final int SUBMIT = 1;
  private Admin admin;
  private Common common;
  private Financials financials;
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }

  public void display_xa(GrndsExchangeContext context){
    PerformanceTrace pt = new PerformanceTrace(TRACE_TAG, ".display_xa()");
    pt.enterScope();
    
    RestrictedFundsSO so = financials.retrieveRestrictedFunds(populateRetrieveInput(context.getRequest()));
    so.setInvalidateApproval(determineInvalidateApproval(so, context.getRequest()));
    putInState(so, context, true);
    HttpServletRequest request = context.getRequest();
    
    //-- determine page mode
    String pageMode = PageModeConstants.VIEW;
    int idPerson = GlobalData.getUlIdPerson(request);
    if(idPerson > 0 && 
       ArchitectureConstants.Y.equals(getSessionStateManager(context).getContextParameter("_restrictedFunds"+idPerson, request)) &&
       GlobalData.hasStageAccess(request) &&
       APPROVAL_TASK_MAP.containsKey(GlobalData.getSzCdStage(request))){
      pageMode = PageModeConstants.MODIFY;
    }
    PageMode.setPageMode(pageMode, request);
    
    pt.getTotalTime();
    pt.exitScope();
  }
  
  public void taskDisplay_xa(GrndsExchangeContext context){
    PerformanceTrace pt = new PerformanceTrace(TRACE_TAG, ".taskDisplay_xa()");
    pt.enterScope();
    
    RestrictedFundsSO so = financials.retrieveRestrictedFunds(populateRetrieveInput(context.getRequest()));
    so.setInvalidateApproval(determineInvalidateApproval(so, context.getRequest()));
    putInState(so, context, true);
    
    //-- determine page mode
    HttpServletRequest request = context.getRequest();
    String pageMode = PageModeConstants.VIEW;
    if(GlobalData.isApprovalMode(request)){
      pageMode = PageModeConstants.MODIFY;
    }
    PageMode.setPageMode(pageMode, request);
    
    pt.getTotalTime();
    pt.exitScope();
  }
  
  public void save_xa(GrndsExchangeContext context){
    PerformanceTrace pt = new PerformanceTrace(TRACE_TAG, ".save_xa()");
    pt.enterScope();
    
    RestrictedFundsSO so = financials.saveRestrictedFunds(populateSaveInput(SAVE, context));
    putInState(so, context, false);
    setInformationalMessage(Messages.MSG_DATABASE_SAVE_SUCCESS, context.getRequest());
    
    pt.getTotalTime();
    pt.exitScope();
  }
  
  public void saveAndSubmit_xa(GrndsExchangeContext context){
    PerformanceTrace pt = new PerformanceTrace(TRACE_TAG, ".saveAndSubmit_xa()");
    pt.enterScope();
    
    RestrictedFundsSaveSI si = populateSaveInput(SUBMIT, context);
    RestrictedFundsSO so = financials.saveRestrictedFunds(si);
    //-- populate ToDoDetailDB object and put in state via ToDoHelper
    HttpServletRequest request = context.getRequest();
    int idEvent = so.getIdEvent();
    int idCase = GlobalData.getUlIdCase(request);
    int idStage = si.getIdStage();
    String taskCode = APPROVAL_TASK_MAP.get(GlobalData.getSzCdStage(request));
    ToDoDetailDB toDoDetailDB = new ToDoDetailDB(idEvent, idCase, idStage, taskCode);
    ToDoHelper.setToDoDetailDB(toDoDetailDB, request, getSessionStateManager(context));
    
    pt.getTotalTime();
    pt.exitScope();
  }
  
  private RestrictedFundsSaveSI populateSaveInput(int method, GrndsExchangeContext context){
    RestrictedFundsSaveSI si = new RestrictedFundsSaveSI();
    
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    RestrictedFundsSO oldData = (RestrictedFundsSO) state.getAttribute(RESTRICTED_FUNDS_SO, request);
    
    //-- check invalidateApproval
    if(oldData != null && oldData.invalidateApproval()){
      CCMN05UI ccmn05ui = new CCMN05UI();
      ArchInputStruct ais = new ArchInputStruct();
      ais.setUlSysNbrReserved1(ArchitectureConstants.N);
      ccmn05ui.setArchInputStruct(ais);
      ccmn05ui.setUlIdEvent(oldData.getIdEvent());
      try {
        admin.invalidateApproval(ccmn05ui);
      } catch(ServiceException se) {
        handleServiceException(se, context);
      }
    }
    
    si.setOldData(oldData);
    int idPerson = GlobalData.getUlIdPerson(request);
    if(idPerson == 0 && oldData != null){
      idPerson = oldData.getIdPerson();
    }
    si.setIdPerson(idPerson);
    si.setReservedAmount(ContextHelper.getMoneyAsDoubleSafe(request, RESERVED_AMOUNT_NAME));
    si.setReservedReason(ContextHelper.getStringSafe(request, RESERVED_REASON_NAME));
    si.setSubmitForApproval(method == SUBMIT);
    si.setIdStage(GlobalData.getUlIdStage(request));
    si.setTaskCode(GlobalData.getSzCdTask(request));
    si.setIdUser(UserProfileHelper.getGlobalDataUserId(request));
    
    return si;
  }
  
  private RestrictedFundsRetrieveSI populateRetrieveInput(HttpServletRequest request) {
    RestrictedFundsRetrieveSI si = new RestrictedFundsRetrieveSI();
    int idUser = UserProfileHelper.getGlobalDataUserId(request);
    int idPerson = GlobalData.getUlIdPerson(request);
    if(idPerson != idUser) {
      si.setIdPerson(idPerson);
    }
    si.setIdEvent(GlobalData.getUlIdEvent(request));
    return si;
  }
  
  private void putInState(RestrictedFundsSO so, GrndsExchangeContext context, boolean cleanFirst){
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    if(cleanFirst) {
      state.removeAllAttributes(request);
    }
    state.setAttribute(RESTRICTED_FUNDS_SO, so, request);
    if(so != null) {
      GlobalData.setUlIdEvent(so.getIdEvent(), request);
    }
  }
  
  private boolean determineInvalidateApproval(RestrictedFundsSO so, HttpServletRequest request){
    boolean invalidate = false;
    if(so != null && so.getIdEvent() > 0 && CodesTables.CEVTSTAT_PEND.equals(so.getStatus())) {
      //-- event has already been submitted for approval, check if user is approver
      ApproversRetrieveSO aso = common.retrieveApprovers(new ApproversRetrieveSI(ApproversRetrieveSI.SUBMITTED_EVENT, so.getIdEvent()));
      if(aso.hasCurrentActiveApprover()){
        int userId = UserProfileHelper.getGlobalDataUserId(request);
        if(userId != aso.getCurrentActiveApprover().getIdPerson()){
          //-- user is not approver
          setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
          invalidate = true;
        }
      }
    }
    return invalidate;
  }
  
  private void handleServiceException(ServiceException se, GrndsExchangeContext context) {
    int errorCode = se.getErrorCode();
    switch (errorCode) {
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      setErrorMessage(errorCode, context.getRequest());
      break;
    default:
      processSevereException(context, se);
      break;
    }
  }
}
