package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to search for Payment History.
 *
 * @author Jeff Chambers, Feburary 19, 2003
 *         <p/>
 *         Change History: Date        User      Description ----------  --------  --------------------------------------------------
 *         05/14/2004  gerryc    SIR 13891 - added ability to search with contract id
 */

@SuppressWarnings("serial")
public class PymntHistorySearchConversation extends BaseHiddenFieldStateConversation {
  private Financials financials;
  
  public void setFinancials(Financials financials){
    this.financials = financials;
  }

  /* displayPaymentHistory */
  public void displayPaymentHistory_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPaymentHistory_xa()");
    performanceTrace.enterScope();

    // Dummy method for display

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /* searchPaymentHistory */
  public void searchPaymentHistory_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".searchPaymentHistory_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // This variable determine which table to display on the PymntHistorySearch.jsp
    String clientFlag = "";

    state.removeAllAttributes(request);

    //Allocate the structures
    CFIN21SI cfin21si = new CFIN21SI();

    cfin21si.setUlScrFinPayhistId(ContextHelper.getIntSafe(context, "txtUlSrcFinPayhistId"));

    // if Client was selected use this criteria
    if ("client".equalsIgnoreCase(ContextHelper.getStringSafe(context, "rbUlScrFinPayhistId"))) {
      cfin21si.setSzScrFinPayhistSearch(CLIENT_SEARCH);
      clientFlag = "Y";
    }
    // if Resource was selected use this criteria
    else if ("resource".equalsIgnoreCase(ContextHelper.getStringSafe(context, "rbUlScrFinPayhistId"))) {
      cfin21si.setSzScrFinPayhistSearch(RESOURCE_SEARCH);
      clientFlag = "N";
    }
    // SIR 13891 - if contract was selected use this criteria
    else if ("contract".equalsIgnoreCase(ContextHelper.getStringSafe(context, "rbUlScrFinPayhistId"))) {
      cfin21si.setSzScrFinPayhistSearch(CONTRACT_SEARCH);
      clientFlag = "N";
    }

    // Create date objects
    org.exolab.castor.types.Date d1 = ContextHelper.getCastorDateSafe(context, "txtDtSrcNbrFinPayhistFrom");
    org.exolab.castor.types.Date d2 = ContextHelper.getCastorDateSafe(context, "txtDtSrcDtFinPayhistTo");

    cfin21si.setDtScrNbrFinPayhistFrom(d1);
    cfin21si.setDtScrDtFinPayhistTo(d2);
    cfin21si.setDAmtInvoValidAmount(0.0);
    cfin21si.setSzCdRegion(ContextHelper.getStringSafe(context, "selRegion"));
    cfin21si.setSzCdCounty(ContextHelper.getStringSafe(context, "selCounty"));

    // Set the ClientFlag so the display shows the correct table
    request.setAttribute("ClientFlag", clientFlag);
    request.setAttribute("rbUlScrFinPayhistId", ContextHelper.getStringSafe(context, "rbUlScrFinPayhistId"));
    
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(MAX_RESULTS_PER_PAGE);
    
    ArchInputStruct ais = new ArchInputStruct();
    ais.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    ais.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    cfin21si.setArchInputStruct(ais);
    
    try {
      //call the Tuxedo service using the WtcHelper object
      //String s = WtcHelper.callService("CFIN21S", cfin21si);
      //StringReader reader = new StringReader(s);
      //CFIN21SO cfin21so = CFIN21SO.unmarshal(reader);
      CFIN21SO cfin21so = financials.retrievePaymentHistoryList(cfin21si);
      request.setAttribute("CFIN21SO", cfin21so);
      state.setAttribute("ROWCFIN01SOG00_ARRAY", cfin21so.getROWCFIN21SOG00_ARRAY(), request);
      // pagination
      tuxPagination.setPaginationInformation(cfin21so.getArchOutputStruct(),
                                             cfin21so.getROWCFIN21SOG00_ARRAY().getUlRowQty());
      storePaginationBeanToRequest(context, tuxPagination);
    }
    catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
        case Messages.MSG_NO_ROWS_RETURNED:
        case Messages.MSG_FIN_INVALID_PRSN_ID:
        case Messages.MSG_FIN_INVALID_RSRC_ID:
        case Messages.MSG_FIN_INVLD_CNTRCT_ID:
          setErrorMessage(errorCode, SEARCH_URL, context.getRequest());
          break;
        default:
          processSevereException(context, we);
          break;
      }
    }
    catch (Exception e) {
      processSevereException(context, e);
    }
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /* displayInvoiceDetail */
  public void displayInvoiceDetail_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayInvoiceDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    int invoiceId = 0;

    // Get invoice Id from hidden field on InvoiceSearch.jsp
    invoiceId = ContextHelper.getIntSafe(context, "hdnTxtUlIdInvoInvoice");

    // Set invoice Id into Global Data for Invoice.jsp
    GlobalData.setUlIdInvoice(invoiceId, request);
    PageMode.setPageMode(PageModeConstants.MODIFY, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
  public static final String TRACE_TAG = "PymntHistorySearchConversation";
  public static final String CLIENT_SEARCH = "0";
  public static final String RESOURCE_SEARCH = "1";
  public static final String CONTRACT_SEARCH = "2"; //13891
  public static final int MAX_RESULTS_PER_PAGE = 30;
  public static final String SEARCH_URL = "/financials/PymntHistorySearch/searchPaymentHistory";
}
