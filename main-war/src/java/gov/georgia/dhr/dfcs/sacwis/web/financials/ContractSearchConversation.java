package gov.georgia.dhr.dfcs.sacwis.web.financials;

import javax.servlet.http.HttpServletRequest;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;
import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON01SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;

/**
 * Conmtract Search Conversation class <p/> This method is used when a user wants to search for Contract or add a new
 * contract
 * 
 * @author Eric Dickman
 * @version 1.0 <p/> Change History: Date User Description -------- -----------
 *          ---------------------------------------------- 05/09/05 NALLAVS SIR 23547 - Removed System.out.println
 *          statements.
 */

public class ContractSearchConversation extends BaseHiddenFieldStateConversation {

  private Financials financials;

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }

  /**
   * display Contract Search Activity Method <p/> This method is called by the GRNDS controller when the user requests
   * the initial display of the Contract Search jsp.
   * 
   * @param context
   *          Context for the request
   */

  public void displayContractSearch_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayContractSearch_xa()");
    performanceTrace.enterScope();

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * display Contract Search Activity Method <p/> This method is called by the GRNDS controller when the user requests
   * to search for an Contract on the Contract Search jsp. The results will display in the pagination section and a user
   * will click on the hyperlink to go to the Contract Header page.
   * 
   * @param context
   *          Context for the request
   */

  public void searchContractSearch_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".searchContractSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(RESULTS_PER_PAGE);

    // Allocate the structures

    try {
      CCON01SI ccon01si = populateCCON01SI_Search(context, tuxPagination);

      CCON01SO ccon01so = financials.retrieveContractList(ccon01si);

      request.setAttribute("CCON01SO", ccon01so);

      // Set pagination information
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(ccon01so.getBMoreDataInd());
      ccon01so.setArchOutputStruct(archOutputStruct);
      tuxPagination.setPaginationInformation(ccon01so.getArchOutputStruct(), ccon01so.getROWCCON01SOG00_ARRAY()
                                                                                     .getROWCCON01SOG00Count());
      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    
    // We need to store the pagination bean to the request here to keep the sortable column tag
    // from failing if we got a checked exception above.
    storePaginationBeanToRequest(context, tuxPagination);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
   // return;
  }

  /**
   * forward Contract Header Activity Method <p/> This method is called by the GRNDS controller when the user wants to
   * forward to the Contract Header jsp. The user can click on the hyperlink to enter the Contract Header page in modify
   * mode. If the user clicks on the Add push button the Contract Header page will open in new mode.
   * 
   * @param context
   *          Context for the request
   */

  public void forwardContractHeader_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".forwardContractHeader_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);

    HttpServletRequest request = context.getRequest();
    int contractID = ContextHelper.getIntSafe(context, "hdnContractID");
    boolean viewMode = ContextHelper.getBooleanSafe(context, "hdnViewMode");

    GlobalData.setUlIdContract(contractID, request);
    String appMode = PageModeConstants.EDIT;

    if (viewMode) {
      appMode = PageModeConstants.VIEW;
    }

    GlobalData.setAppMode(appMode, request);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    state.removeAllAttributes(request);

    try {
      forward("/financials/Contracts/displayContractHeader", request, context.getResponse());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * Getter method for search results.
   * 
   * @param context
   *          Context for the request
   * @param tuxPagination
   *          Value Bean for the pagination of the results
   * @return ccon01si
   */
  private CCON01SI populateCCON01SI_Search(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) {

    CCON01SI ccon01si = new CCON01SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    HttpServletRequest request = context.getRequest();

    input.setSzUserId(user.getUserLogonID());
    //input.setUlPageSizeNbr(RESULTS_PER_PAGE);
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    ccon01si.setArchInputStruct(input);

    // Sets Contract Id
    // if statement will search only contract id
    if ((ContextHelper.getIntSafe(context, "txtIdContract")) != 0) {
      ccon01si.setUlIdContract(ContextHelper.getIntSafe(context, "txtIdContract"));
    }
    // SIR 17039 remove this "else if", if contract ID has not been entered then all fields
    // will be considered on the page
    // if statement will search resource id, functional type, program type, region, from date, to date
    // and budget limit checkbox
    else {
      // SIR 17039 added resource id to this search, all fields will be searched on.
      ccon01si.setUlIdResource(ContextHelper.getIntSafe(context, "txtIdResource"));

      // Sets Functional Type
      ccon01si.setSzCdCntrctFuncType(ContextHelper.getStringSafe(context, "selCdCntrctRegion"));

      // Sets Program Type
      ccon01si.setSzCdCntrctProgramType(ContextHelper.getStringSafe(context, "CPS"));

      // Sets Region
      ccon01si.setSzCdCntrctRegion(ContextHelper.getStringSafe(context, "selCdCntrct"));

      // Sets County
      ccon01si.setSzCdCntrctCounty(ContextHelper.getStringSafe(context, "selCdCounty"));

      // Sets From Date and To Date
      org.exolab.castor.types.Date fromDate = (ContextHelper.getCastorDateSafe(context, "txtDtCnperStart"));
      org.exolab.castor.types.Date toDate = (ContextHelper.getCastorDateSafe(context, "txtDtCnperTerm"));

      // SIR 17039 GRIMSHAN -- Moved code from helpermethod into main method since it is only
      // needed once

      // if statement tests and sets the from and to dates
      if (toDate != null && fromDate == null) {
        ccon01si.setDtDtCnperTerm(ContextHelper.getCastorDateSafe(context, "txtDtCnperTerm"));
      } else if (toDate == null && fromDate != null) {
        ccon01si.setDtDtCnperStart(ContextHelper.getCastorDateSafe(context, "txtDtCnperStart"));
        ccon01si.setDtDtCnperTerm(DateHelper.MAX_CASTOR_DATE);
      } else if (toDate != null && fromDate != null) {
        ccon01si.setDtDtCnperStart(ContextHelper.getCastorDateSafe(context, "txtDtCnperStart"));
        ccon01si.setDtDtCnperTerm(ContextHelper.getCastorDateSafe(context, "txtDtCnperTerm"));
      }

      // Budget Limit Checkbox
      ccon01si.setCIndCntrctBudgLimit(CheckboxHelper.getCheckboxValue(request, "cbxIndCntrctBudgLimit"));
    }

    return ccon01si;
  }

  // static constants
  //Reset page display to 50 per defect 5892
  public static final String TRACE_TAG = "ContractSearchConversation";

  public static final int RESULTS_PER_PAGE = 50;

  public static final String COUNTY_CODES_TABLES = "CCOUNT";

  public static final String CCONFUNC_CODES_TABLES = "CCONFUNC";
}