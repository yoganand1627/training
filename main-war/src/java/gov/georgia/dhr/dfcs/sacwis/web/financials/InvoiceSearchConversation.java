package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- input and output classes --

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN01SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to search for Invoices.
 *
 * @author Jeff Chambers, Feburary 09, 2003
 *         <pre>
 *                 Change History:
 *                  Date      User              Description
 *                  --------  ----------------  --------------------------------------------------
 *                  04/22/03  GRIMSHAN          SIR # 17123 Changed Search Invoice Search method
 *                                              so that it only forwards to invoice header when
 *                                              an invoice id has been entered into the field and
 *                                              returns sucessfully.
 *                  05/08/03  GRIMSHAN          SIR # 17295 Clear Invoice ID and phase in display
 *                                              invoice search so that they don't get carried over
 *                                              from an old invoice that was selected
 *                  05/08/03  GRIMSHAN          SIR # 17402 Set App Mode to browse if the user
 *                                              has sec_browse_invoice security attribute
 *                  05/13/03  GRIMSHAN          SIR # 17452 Only set App Mode to browse if the user
 *                                              has sec_browse_invoice but not sec_modify_invoice
 *                  05/16/03  GRIMSHAN          SIR # 17519 Clear contract id on display of the
 *                                              search page so that it is not carried over with the
 *                                              add pushbutton
 *                  08/20/03  GRIMSHAN          SRI 19594 Chance name of selSzCdInvoType to
 *                                              selSzCdInvoTypeSearch
 *                  04/08/2009 bgehlot          STGAP00013273 : Added new field Client Person ID to search on
 *                  05/27/2009 bgehlot          STGAP00013906: Month field can have empty string 
 *         <p/>
 *                 </pre>
 */

@SuppressWarnings("serial")
public class InvoiceSearchConversation extends BaseHiddenFieldStateConversation {
  /**
   * displayInvoiceSearch
   * <p/>
   * This method is used to initally display the search portion of the page.
   *
   * @param context The GrndsExchange object
   */
  public void displayInvoiceSearch_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayInvoiceSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    // Set AppMode to EDIT
    GlobalData.setAppMode(PageModeConstants.MODIFY, request);

    // Set Page Mode
    PageMode.setPageMode(PageModeConstants.MODIFY, request);

    // SIR 17295 GRIMSHAN -- Clear Invoice ID and Invoice page so that if an
    // invoice has already been navigated to, and then the user clicks add
    // on the invoice search page, the old ID and phase will not appear in the
    // information section
    GlobalData.setUlIdInvoice(0, request);
    GlobalData.setSzCdInvoPhase("", request);
    // SIR 17519 GRIMSHAN -- Clear contract id so that it is not carried over on click
    // of the add pushbutton
    GlobalData.setUlIdContract(0, request);
    GlobalData.setSzCdCounty("", request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * searchInvoiceSearch
   * <p/>
   * This method is used to call CFIN01S for performing the Invoice Search
   *
   * @param context The Grnds Exchange Object
   */
  public void searchInvoiceSearch_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".searchInvoiceSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(MAX_PAGE_RESULTS);

      // SIR 17123 GRIMSHAN -- set a boolean if the Invoice ID field has been
      // entered on the page
      boolean forwardHeader = false;
      if (ContextHelper.getIntSafe(context, "txtUlIdInvoInvoice") != 0) {
        forwardHeader = true;
      }

      CFIN01SI cfin01si = populateCFIN01SI_Search(context, tuxPagination);
      //call the Tuxedo service using the WtcHelper object

      //String s = WtcHelper.callService("CFIN01S", cfin01si);
      //StringReader reader = new StringReader(s);
      //CFIN01SO cfin01so = CFIN01SO.unmarshal(reader);
      
      CFIN01SO cfin01so = financials.retrieveInvoiceList(cfin01si);
      
      //STGAP00013906: Month field can have empty string sets the attribute to true after search is done
      request.setAttribute("indSearch", "true");
      
      request.setAttribute("CFIN01SO", cfin01so);
      state.setAttribute("ROWCFIN01SOG00_ARRAY", cfin01so.getROWCFIN01SOG00_ARRAY(), request);

      
      // Set results into pagination
      // temporary fix..need to do pagination
      //cfin01so.getArchOutputStruct().setBMoreDataInd(ArchitectureConstants.N);
      tuxPagination.setPaginationInformation(cfin01so.getArchOutputStruct(),
                                             cfin01so.getROWCFIN01SOG00_ARRAY().getUlRowQty());
      storePaginationBeanToRequest(context, tuxPagination);

      // Set SearchPerformed into the request so the JSP knows search has been performed.  This will
      // display the result set
      request.setAttribute("SearchPerformed", request);

      String pageMode = "";

      pageMode = PageMode.getPageMode(request);

      PageMode.setPageMode(pageMode, request);

      // SIR 17123 GRIMSHAN -- If an Invoice ID was entered on the page, and the search was successful
      // forward to the invoice header page.
      if (forwardHeader == true && cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00Count() == 1) {
        UserProfile user = UserProfileHelper.getUserProfile(context);
        PageMode.setPageMode(pageMode, request);
        GlobalData.setUlIdInvoice(cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(0).getUlIdInvoInvoice(),
                                  request);
        //SIR 17402 GRIMSHAN if the user has browse invoice, set the app mode to view
        //SIR 17452 GRIMSHAN only set the app mode if the user does not have
        //modify invoice and does have brows invoice
        if (!user.hasRight(UserProfile.SEC_FIN_MODIFY_INVOICE) && user.hasRight(UserProfile.SEC_FIN_BROWSE_INVOICE)) {
          GlobalData.setAppMode(PageModeConstants.VIEW, request);
        }
        forward("/financials/Invoice/displayInvoice", request, context.getResponse());
      }

    }
    catch (ServiceException we) {
      switch (we.getErrorCode()) {
        case Messages.MSG_CMN_SEARCH_NOT_FOUND:
          String noCriteriaMatch = MessageLookup.getMessageByNumber(Messages.MSG_CMN_SEARCH_NOT_FOUND);
          setErrorMessage(noCriteriaMatch, "/financials/InvoiceSearch/searchInvoiceSearch", context.getRequest());
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

  /**
   * addInvoice
   * <p/>
   * This method is used to add an invoice to the system, it calls the invoice page in new mode
   *
   * @param context The Grnds Exchange Object
   */
  public void addInvoice_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addInvoice_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    String pageMode = "";

    pageMode = PageMode.getPageMode(request);

    PageMode.setPageMode(pageMode, request);

    try {
      forward("/financials/Invoice/addInvoice", request, context.getResponse());
    }
    catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * New Using
   * <p/>
   * This method is used to call a new using of an exisiting invoice.  It calls the Invoice detail page.
   *
   * @param context The Grnds Exchange Object
   */
  public void newUsing_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".newUsing_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    int index = 0;
    int contractId = 0;
    int invoiceId = 0;
    index = ContextHelper.getIntSafe(context, "rbRowsIndex");
    ROWCFIN01SOG00_ARRAY rowcfin01sog00_array = (ROWCFIN01SOG00_ARRAY) state.getAttribute("ROWCFIN01SOG00_ARRAY",
                                                                                          request);

    contractId = rowcfin01sog00_array.getROWCFIN01SOG00(index).getUlIdContract();
    String county = rowcfin01sog00_array.getROWCFIN01SOG00(index).getSzCdCounty();
    invoiceId = rowcfin01sog00_array.getROWCFIN01SOG00(index).getUlIdInvoInvoice();
    // Set the contract id into global data
    GlobalData.setUlIdContract(contractId, request);
    GlobalData.setSzCdCounty(county, request);
    state.setAttribute("cIndCopiedInv",ArchitectureConstants.Y,request);
    state.setAttribute("ulIdInvoInvoiceCopied", invoiceId, request);

    // Send the user to Invoice Header
    try {
      forward("/financials/Invoice/addInvoice", request, context.getResponse());
    }
    catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * displayInvoiceDetail
   * <p/>
   * This method is used to display an existing invoice
   *
   * @param context The Grnds Exchange Object
   */
  public void displayInvoiceDetail_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayInvoiceDetail_xa()");
    performanceTrace.enterScope();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    HttpServletRequest request = context.getRequest();

    int invoiceId = 0;

    // Get invoice Id from hidden field on InvoiceSearch.jsp
    invoiceId = ContextHelper.getIntSafe(context, "hdnTxtUlIdInvoInvoice");

    // Set invoice Id into Global Data for Invoice.jsp
    GlobalData.setUlIdInvoice(invoiceId, request);

    //SIR 17402 GRIMSHAN if the user has browse invoice, set the app mode to view
    //SIR 17452 GRIMSHAN only set the app mode if the user does not have
    //modify invoice and does have brows invoice
    if (!user.hasRight(UserProfile.SEC_FIN_MODIFY_INVOICE) && user.hasRight(UserProfile.SEC_FIN_BROWSE_INVOICE)) {
      GlobalData.setAppMode(PageModeConstants.VIEW, request);
    }

    try {
      forward("/financials/Invoice/displayInvoice", request, context.getResponse());
    }
    catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * This method is used to populate the call to the Invocie Search Service
   *
   * @param context       The Grnds Exchange Object
   * @param tuxPagination The pagination Information
   * @return cfin01s
   */
  private CFIN01SI populateCFIN01SI_Search(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) {
    // Pagination

    UserProfile user = UserProfileHelper.getUserProfile(context);

    //Allocate the structures
    CFIN01SI cfin01si = new CFIN01SI();
    ArchInputStruct input = new ArchInputStruct();

    //Set the values for the ArchInputStruct
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    input.setSzUserId(user.getUserLogonID());

    cfin01si.setArchInputStruct(input);

    // If Invoice Id is entered, it is the only criteria used for the search
    // If Contract Id is entered, Resource Id is ommited from the search
    // Else use any other criteria
    int idInvoice = ContextHelper.getIntSafe(context, "txtUlIdInvoInvoice");
    int idContract = ContextHelper.getIntSafe(context, "txtUlIdContract");
    
    //STGAP00013273 : Added new field Client Person ID to search on
    int idClientPerson = ContextHelper.getIntSafe(context, "txtUlIdClientPerson");
    
    if (idInvoice != 0) {
      cfin01si.setUlIdInvoInvoice(idInvoice);
    } else{
      cfin01si.setUlIdContract(idContract);
      if (idContract == 0){
        cfin01si.setUlIdResource(ContextHelper.getIntSafe(context, "txtUlIdResource"));
      }
      cfin01si.setSzCdCntrctRegion(ContextHelper.getStringSafe(context, "selSzCdCntrctRegion"));
      cfin01si.setSzCdCounty(ContextHelper.getStringSafe(context, "selCounty"));
      // If these are set to "ALL" don't pass them to the service
      if (!"ALL".equalsIgnoreCase(ContextHelper.getStringSafe(context, "selSzCdInvoPhase"))) {
        cfin01si.setSzCdInvoPhase(ContextHelper.getStringSafe(context, "selSzCdInvoPhase"));
      }
      if (!"ALL".equalsIgnoreCase(ContextHelper.getStringSafe(context, "selSzCdInvoTypeSearch"))) {
        cfin01si.setSzCdInvoType(ContextHelper.getStringSafe(context, "selSzCdInvoTypeSearch"));
      }
      cfin01si.setUMoInvoMonth(ContextHelper.getIntSafe(context, "txtUMoInvoMonth"));
      cfin01si.setUYrInvoYear(ContextHelper.getIntSafe(context, "txtUYrInvoYear"));
      cfin01si.setUlIdClientPerson(idClientPerson);
    }
    return cfin01si;
  }
  
  public void setFinancials(Financials fin){
    financials = fin;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
  public static final String TRACE_TAG = "FinancialAcctSearchConversation";
  public static final int MAX_PAGE_RESULTS = 75;
  
  private Financials financials = null;
  
}

