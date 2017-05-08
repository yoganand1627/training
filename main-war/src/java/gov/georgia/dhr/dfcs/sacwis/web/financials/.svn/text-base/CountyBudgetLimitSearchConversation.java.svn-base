package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CountyBudgetLimitRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CountyBudgetLimitSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CountyBudgetLimitRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

@SuppressWarnings("serial")
public class CountyBudgetLimitSearchConversation extends BaseHiddenFieldStateConversation {
  
  public static final String DISPLAY_DETAIL = "/financials/CountyBudgetLimit/displayCountyBudgetLimitDetail";
  public static final String SEARCH_RESULTS = "CountyBudgetLimitList";

  private Financials financials;

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }

  /**
   * Called when the user clicks the County Budget Limit tab
   * 
   * @param context
   */
  public void displayCountyBudgetLimitSearch_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCountyBudgetLimitSearch_xa()");
    performanceTrace.enterScope();
    
    getSessionStateManager(context).removeAllAttributes(context.getRequest());
    
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Called when the user clicks on the search button in CountyBudgetLimitSearchScreen
   * 
   * @param context
   */
  public void searchCountyBudgetLimit_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".searchCountyBudgetLimit_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    CountyBudgetLimitRetrieveSI budgetSI = populateCountyBudgetLimitRetrieveSI(context);

    List<CountyBudgetLimitRetrieveSO> result = financials.retrieveCountyBudgetLimitList(budgetSI);

    state.setAttribute(SEARCH_RESULTS, result, request);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  public void forwardCountyBudgetLimitDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".forwardCountyBudgetLimitDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    int countyBudgetLimitID = ContextHelper.getIntSafe(context, "hdnCountyBudgetLimitID");
    boolean viewMode = ContextHelper.getBooleanSafe(context, "hdnViewMode");

    request.setAttribute("hdnCountyBudgetLimitID", countyBudgetLimitID);
    
    String appMode = PageModeConstants.EDIT;
    if (viewMode) {
      appMode = PageModeConstants.VIEW;
    }
    GlobalData.setAppMode(appMode, request);
    try {
      forward("/financials/CountyBudgetLimit/displayCountyBudgetLimitDetail", request, context.getResponse());
    } catch (Exception e) {
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  public void displayCountyBudgetLimitDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".forwardCountyBudgetLimitDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CountyBudgetLimitRetrieveSI input = populateCountyBudgetLimitRetrieveSI(context);
    CountyBudgetLimitRetrieveSO output = financials.retrieveCountyBudgetLimitDetail(input);

    request.setAttribute("countyBudgetLimit", output);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  public void saveCountyBudgetLimitDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".forwardCountyBudgetLimitDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    int idReturned = 0;
    CountyBudgetLimitSaveSI input = populateCountyBudgetLimitSaveSI(request);
    idReturned = financials.isCountyBudgetLimitDetailValid(input.getCounty(), input.getProgram(), input.getFiscalYear());
    if (idReturned != 0 && idReturned != input.getIdCountyBudgetLimit()){
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_FIN_CNTY_BGT, DISPLAY_DETAIL, context.getRequest());
    } else {
      int idCountyBudgetLimit = financials.saveCountyBudgetLimitDetail(input);
      CountyBudgetLimitRetrieveSI retrieveSI = new CountyBudgetLimitRetrieveSI();
      retrieveSI.setIdCountyBudgetLimit(idCountyBudgetLimit);
      CountyBudgetLimitRetrieveSO output = financials.retrieveCountyBudgetLimitDetail(retrieveSI);
      request.setAttribute("countyBudgetLimit", output);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private CountyBudgetLimitSaveSI populateCountyBudgetLimitSaveSI(HttpServletRequest request) {
    CountyBudgetLimitSaveSI result = new CountyBudgetLimitSaveSI();
    
    result.setCounty(ContextHelper.getStringSafe(request, "selCdCounty"));
    result.setProgram(ContextHelper.getStringSafe(request, "selCdProgram"));
    result.setFiscalYear(ContextHelper.getIntSafe(request, "txtFiscalYear"));
    result.setIdCountyBudgetLimit(ContextHelper.getIntSafe(request, "hdnCountyBudgetLimitID"));
    result.setBudgetedAmount(ContextHelper.getMoneyAsDoubleSafe(request, "budgetLimit"));
    
    return result;
  }

  private CountyBudgetLimitRetrieveSI populateCountyBudgetLimitRetrieveSI(GrndsExchangeContext context) {
    CountyBudgetLimitRetrieveSI result = new CountyBudgetLimitRetrieveSI();
    result.setCounty(ContextHelper.getStringSafe(context, "selCdCounty"));
    result.setProgram(ContextHelper.getStringSafe(context, "selCdProgram"));
    result.setFiscalYear(ContextHelper.getIntSafe(context, "txtFiscalYear"));
    result.setIdCountyBudgetLimit(ContextHelper.getIntSafe(context, "hdnCountyBudgetLimitID"));
    return result;
  }

}
