package gov.georgia.dhr.dfcs.sacwis.web.servicedelivery;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterCareSecGoalsSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterCareSecGoalsRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import javax.servlet.http.HttpServletRequest;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * FosterCareSecGoalsConversation
 * 
 * @author Nandita Hegde , Feb 12,2006
 * @version 1.0
 * 
 * <pre>
 *                   Change History:
 *                   Date      User              Description
 *                   --------  ----------------  --------------------------------------------------
 * </pre>
 */

public class FosterCareSecGoalsConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "FosterCareSecGoalsConversation";

  public static final String SAVE = "save";

  private CaseMgmt casemgmt = null;

  public void setCaseMgmt(CaseMgmt casemgmt) {
    this.casemgmt = casemgmt;
  }

  /**
   * display method for the Foster Care Secondary Goals
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void displayFosterCareSecGoals_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayFosterCareSecGoals_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    String pageMode = PageMode.getPageMode(request);
    if ( pageMode != null ){
      PageMode.setPageMode(pageMode, request);      
    } else {
      PageMode.setPageMode(PageModeConstants.EDIT, request);      
    }
    try {
      FosterCareSecGoalsRetrieveSO fosterCareSecGoalsRetrieveSO = new FosterCareSecGoalsRetrieveSO();
      // clear state
      if (state.getAttribute("FosterCareSecGoalsRetrieveSO", request) == null) {
        state.removeAllAttributes(request);
      }
      FosterCareSecGoalsRetrieveSI fosterCareSecGoalsRetrieveSI = populateFosterCareSecGoalsRetrieveSI(context);
      fosterCareSecGoalsRetrieveSO = casemgmt.retrieveFosterCareSecGoals(fosterCareSecGoalsRetrieveSI);
      state.setAttribute("FosterCareSecGoalsRetrieveSO", fosterCareSecGoalsRetrieveSO, request);

    } catch (Exception e) {
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method will populate FosterCareSecGoalsRetrieveSI.
   * 
   * @param context
   */

  private FosterCareSecGoalsRetrieveSI populateFosterCareSecGoalsRetrieveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFosterCareSecGoalsRetrieveSI");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    int idFosterCareSecGoals = 0;
    FosterCareSecGoalsRetrieveSI fosterCareSecGoalsRetrieveSI = new FosterCareSecGoalsRetrieveSI();
    // get stage id
    fosterCareSecGoalsRetrieveSI.setCaseId(GlobalData.getUlIdCase(request));
    // get event id
    fosterCareSecGoalsRetrieveSI.setEventId(GlobalData.getUlIdEvent(request));
    // set secondary plan goal id
    idFosterCareSecGoals = ContextHelper.getIntSafe(request, "hdnIdFosterCareSecGoals");
    fosterCareSecGoalsRetrieveSI.setSecGoalsId(idFosterCareSecGoals);
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return fosterCareSecGoalsRetrieveSI;
  }

  /**
   * Add new Foster Care Secondary Goals details
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void addFosterCareSecGoals_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addFosterCareSecGoals_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    FosterCareSecGoalsRetrieveSI fosterCareSecGoals = new FosterCareSecGoalsRetrieveSI();
    FosterCareSecGoalsRetrieveSO fosterCareSecGoalsRetrieveSO = new FosterCareSecGoalsRetrieveSO();
    fosterCareSecGoalsRetrieveSO = casemgmt.retrieveFosterCareSecGoals(fosterCareSecGoals);
    request.setAttribute("FosterCareSecGoalsRetrieveSO", fosterCareSecGoalsRetrieveSO);
    PageMode.setPageMode(PageModeConstants.NEW, request);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method is called by the Grnds controller when the user clicks on the delete button on secondary goals page;
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void deleteFosterCareSecGoals_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteFosterCareSecGoals_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    FosterCareSecGoalsRetrieveSO fosterCareSecGoalsRetrieveSO = (FosterCareSecGoalsRetrieveSO) state
                                                                                                    .getAttribute(
                                                                                                                  "FosterCareSecGoalsRetrieveSO",
                                                                                                                  request);
    int idPlanSecGoals = 0;
    idPlanSecGoals = fosterCareSecGoalsRetrieveSO.getIdPlanSecGoals();

    FosterCareSecGoalsSaveSI fosterCareSecGoals = new FosterCareSecGoalsSaveSI();
    fosterCareSecGoals.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    fosterCareSecGoals.setIdPlanSecGoals(idPlanSecGoals);
    casemgmt.saveFosterCareSecGoals(fosterCareSecGoals);
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Save Foster Care Secondary Goals details
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void saveFosterCareSecGoals_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveFosterCareSecGoals_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    FosterCareSecGoalsSaveSI fosterCareSecGoals = new FosterCareSecGoalsSaveSI();
    fosterCareSecGoals = populateFosterCareSecGoalsSaveSI(context, fosterCareSecGoals, SAVE);
    PageMode.setPageMode(PageModeConstants.EDIT, request);
    casemgmt.saveFosterCareSecGoals(fosterCareSecGoals);
    request.setAttribute("FosterCareSecGoalsSaveSI", fosterCareSecGoals);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This helper method is called by the save to populate the input object for the foster Care Sec Goals save service.
   * 
   * @param context
   *          GrndeExchangeContext
   * @return
   * @throws
   * 
   */

  public FosterCareSecGoalsSaveSI populateFosterCareSecGoalsSaveSI(GrndsExchangeContext context,
                                                                   FosterCareSecGoalsSaveSI fosterCareSecGoals,
                                                                   String method) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFosterCareSecGoalsSaveSI");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    int idEvent = GlobalData.getUlIdEvent(request);
    int idCase = GlobalData.getUlIdCase(request);
    FosterCareSecGoalsRetrieveSO fosterCareSecGoalsRetrieveSO = (FosterCareSecGoalsRetrieveSO) state
                                                                                                    .getAttribute(
                                                                                                                  "FosterCareSecGoalsRetrieveSO",
                                                                                                                  request);
    try {
      fosterCareSecGoals.setCaseId(idCase);
      fosterCareSecGoals.setEventId(idEvent);
      fosterCareSecGoals.setTxtDesc(ContextHelper.getStringSafe(request, "txtDesc"));
      fosterCareSecGoals.setSelStatus(ContextHelper.getStringSafe(request, "selStatus"));
      fosterCareSecGoals.setIndParentApproval(CheckboxHelper.getCheckboxValue(request, "cbxParentApproval"));
      fosterCareSecGoals.setDtLastUpdateSecGoals(fosterCareSecGoalsRetrieveSO.getDtLastUpdateSecGoals());
      fosterCareSecGoals.setIdPlanSecGoals(fosterCareSecGoalsRetrieveSO.getIdPlanSecGoals());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return fosterCareSecGoals;
  }

  protected void handleError(ServiceException we, GrndsExchangeContext context) {
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
