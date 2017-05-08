// class package
package gov.georgia.dhr.dfcs.sacwis.web.financials;

// input and output structures

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/********************************************************************************
 **  Payment Approval  conversation allows users to view rja, pap, dpv and apv
 *    invoices.  Users may go to the invoice page using a hyperlink.  The invoice
 *    page will be in View mode for apv and dpv type invoices and Modify mode for
 *    all others.    Users may reset apv and dpv to pap; and approve or disapprove
 *    non rja invoices.  Rja rows can not be approved, disapproved or reset.  The
 *    users may navigate to the invoice page and if in modify mode, make changes
 *    which will cause the invoice to become vlp.  It will no longer appear on the
 *    payment approval window and will be picked up by the nightly batch, cfin02b.
 * @author
 * Katy Laura,  Feb 26, 2003
 *
 *  Change History:
 *  Date        User      Description
 *  --------  -----------  --------------------------------------------------
 *  05/03/04  gerryc       SIR 15533 - added constants for the sorting, and added
 *                         sort by parameter
 *  01/20/05  Todd Reser   SIR 22915 Added Message NO_REGION_PROFILE_SELECTED
 *  05/22/08  vdevarak     STGAP00004617: MR-012 Added the search method to filter and 
 *                         retrieve Invoices as per the criteria entered on the 
 *                         Payment Approval page.
 * 04/08/2009 bgehlot          STGAP00013273 : Added new field Client Person ID to search on         
 * 05/27/2009 bgehlot          STGAP00013906: Month field can have empty string                 
 ********************************************************************************/

/**
 * ***************************************************************************** * Declare conversation class extending *
 * BaseHiddenFieldStateConversation class.
 * ******************************************************************************
 */

@SuppressWarnings("serial")
public class PaymentApprovalConversation extends BaseHiddenFieldStateConversation {
  // static constants
  public static final String TRACE_TAG = "PaymentApprovalConversation";

  public static final String REGION_SECURITY_VIOLATION = "regionSecurityViolation";

  public static final int PAGE_SIZE = 50;

  public static final int NUM_OF_REGIONS = 15;

  public static final String REGION_99 = "99";

  // SIR 15533 -- Sort Variables --
  public static final String SORT_BY_INITIAL = "2";

  public static final String SORT_BY_RESOURCE_NAME = "3";

  public static final String SORT_BY_CONTRACT_ID = "4";

  private Financials financials;

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }

  public static final int MAX_PAGE_RESULTS = 50;

  /**
   * *************************************************************************** Initial display of payment approval
   * list
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   *          ***************************************************************************
   */
  public void displayPaymentApproval_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPaymentApproval_xa()");
    performanceTrace.enterScope();

    // define state and request
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // STGAP00004617 - Removed code that used to retreive the Invoices for display. This is done in the
    // searchPaymentApprovals now.This method displays only the search criteria part of the page with 
    // the search button.
    
    //clear state at the beginning of the conversation
    state.removeAllAttributes(request);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  // STGAP00004617 - Added this method to enable the search functionality on the Payment Approval page.
  /**
   * searchPaymentApprovals <p/> This method is called when the user clicks the search button on the Payment Approval
   * page
   * 
   * @param context
   *          The Grnds Exchange Object
   */
  public void searchPaymentApprovals_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".searchPaymentApprovals_xa()");
    performanceTrace.enterScope();
   
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    state.removeAllAttributes(request);
    try {
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(MAX_PAGE_RESULTS);

      CFIN19SI cfin19si = populateCFIN19SI_RETRIEVE(context, tuxPagination);
      CFIN19SO cfin19so = financials.retrievePaymentApprovalList(cfin19si);
      
      //STGAP00013906: Month field can have empty string sets the attribute to true after search is done
      request.setAttribute("indSearch", "true");
      
      /* place the service object in the request; The service object contains the rows displayed on the list page; */
      state.setAttribute("CFIN19SO", cfin19so, request);
      state.setAttribute("ROWCFIN01SOG00_ARRAY", cfin19so.getROWCFIN19SOG_ARRAY(), request);
      tuxPagination.setPaginationInformation(cfin19so.getArchOutputStruct(), cfin19so.getROWCFIN19SOG_ARRAY()
                                                                                     .getUlRowQty());
      storePaginationBeanToRequest(context, tuxPagination);

      // Set SearchPerformed into the request so the JSP knows search has been performed. This will
      // display the result set
      request.setAttribute("SearchPerformed", request);

    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_SEARCH_NOT_FOUND:
        String noCriteriaMatch = MessageLookup.getMessageByNumber(Messages.MSG_CMN_SEARCH_NOT_FOUND);
        setErrorMessage(noCriteriaMatch, "/financials/PaymentApproval/searchPaymentApprovals", context.getRequest());
        break;
      case Messages.SQL_NOT_FOUND:
        setErrorMessage(we.getErrorCode(), "/financials/PaymentApproval/displayPaymentApproval", request);
        break;
      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * ************************************************************************************* Save rows as approved
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   *          **************************************************************************************
   */
  public void approve_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".approve_xa()");
    performanceTrace.enterScope();
    // define state and request
    HttpServletRequest request = context.getRequest();
    String btnPressed = "approve";
    // get an array of indices to be approved from the cfin19s array
    // these indices are from the checked boxes on payment approval list jsp
    String[] rowsSelected = CheckboxHelper.getCheckedValues(request, "ckName_CLEAN");
    // get the cfin19so object from state
    for (int i = 0; i < rowsSelected.length; i++) {
      int indexRowsSelected = Integer.parseInt(rowsSelected[i]);
      try {
        gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN20SI cfin20si = populateCFIN20SI_UPDATE(context,
                                                                                              indexRowsSelected,
                                                                                              btnPressed);
        // WtcHelper.callService("CFIN20S", cfin20si);
        financials.savePaymentApprovalList(cfin20si);
      } catch (ServiceException we) {
        handleError(we, context);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
        processSevereException(context, e);
      }
    } // end for loop

    // return to the initial display of the conversation
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * ************************************************************************************* Save rows as disapproved
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   *          **************************************************************************************
   */
  public void disapprove_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".disapprove_xa()");
    performanceTrace.enterScope();

    // define state and request
    HttpServletRequest request = context.getRequest();

    String btnPressed = "disapprove";
    // get an array of indices to be disapproved from the cfin19s array
    // these indices are from the checked boxes on payment approval list jsp
    String[] rowsSelected = CheckboxHelper.getCheckedValues(request, "ckName_CLEAN");
    // get the cfin19so object from state
    for (int i = 0; i < rowsSelected.length; i++) {
      int indexRowsSelected = Integer.parseInt(rowsSelected[i]);
      try {
        gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN20SI cfin20si = populateCFIN20SI_UPDATE(context,
                                                                                              indexRowsSelected,
                                                                                              btnPressed);
        // WtcHelper.callService("CFIN20S", cfin20si);
        financials.savePaymentApprovalList(cfin20si);
      } catch (ServiceException we) {
        handleError(we, context);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
        processSevereException(context, e);
      }
    } // end for loop
    // return to the initial display of the conversation
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * ************************************************************************************* Reset apv or dpv rows to pap
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   *          **************************************************************************************
   */
  public void reset_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".reset_xa()");
    performanceTrace.enterScope();

    // define state and request
    HttpServletRequest request = context.getRequest();
    String btnPressed = "reset";
    // get an array of indices to be reset from the cfin19s array
    // these indices are from the checked boxes on payment approval list jsp
    String[] rowsSelected = CheckboxHelper.getCheckedValues(request, "ckName_CLEAN");

    // get the cfin19so object from state
    for (int i = 0; i < rowsSelected.length; i++) {
      int indexRowsSelected = Integer.parseInt(rowsSelected[i]);
      try {
        gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN20SI cfin20si = populateCFIN20SI_UPDATE(context,
                                                                                              indexRowsSelected,
                                                                                              btnPressed);
        // WtcHelper.callService("CFIN20S", cfin20si);
        financials.savePaymentApprovalList(cfin20si);
      } catch (ServiceException we) {
        handleError(we, context);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
        processSevereException(context, e);
      }
    } // end for loop

    // return to the initial display of the conversation
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * ************************************************************************************* If the user uses the
   * hyperlink to go to INVOICE, pass the invoice a page mode, invoice id and the cd_invo_aproved value. If the
   * cd_invo_approved is APV or DPV invoices, the invoice page will change the page mode from modify to view. For RJA
   * and PAP the pageMode remains MODIFY.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   *          **************************************************************************************
   */
  public void setValuesForInvoice_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setValuesForInvoice_xa()");
    performanceTrace.enterScope();

    // define state and request
    HttpServletRequest request = context.getRequest();
    int ulIdInvoice = ContextHelper.getIntSafe(request, "hdnIdInvoice");
    GlobalData.setAppMode(PageModeConstants.MODIFY, request);
    GlobalData.setUlIdInvoice(ulIdInvoice, request); 

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * *********************************************************************************** This helper method populates
   * rows for a display of rows for paymentApproval jsp <p/> *
   * 
   * @param context
   *          The GrndsExchangeContext object
   *          ************************************************************************************
   */
  private CFIN19SI populateCFIN19SI_RETRIEVE(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination)
                                                                                                                   throws MarshalException,
                                                                                                                   ValidationException,
                                                                                                                   DataFormatException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCFIN19SI_RETRIEVE()");
    performanceTrace.enterScope();

    UserProfile user = UserProfileHelper.getUserProfile(context);
    // define a new service object
    CFIN19SI cfin19si = new CFIN19SI();

    ArchInputStruct input = new ArchInputStruct();

    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());

    cfin19si.setArchInputStruct(input);
    int idContract = ContextHelper.getIntSafe(context, "txtUlIdContract");
    cfin19si.setUlIdContract(idContract);
    if (idContract == 0) {
      cfin19si.setUlIdResource(ContextHelper.getIntSafe(context, "txtUlIdResource"));
    }
    cfin19si.setSzCdCntrctRegion(ContextHelper.getStringSafe(context, "selSzCdCntrctRegion"));
    // STGAP00009880 Adding the county to the helper method to be used in the SQL 
    cfin19si.setSzCdCounty(ContextHelper.getStringSafe(context, "selSzCdInvoCounty"));
    cfin19si.setSzCdInvoAprvStatus(ContextHelper.getStringSafe(context, "selSzCdInvoAprvStatus"));
    if (!"ALL".equalsIgnoreCase(ContextHelper.getStringSafe(context, "selSzCdInvoTypeSearch"))) {
      cfin19si.setSzCdInvoType(ContextHelper.getStringSafe(context, "selSzCdInvoTypeSearch"));
    }
    cfin19si.setUMoInvoMonth(ContextHelper.getIntSafe(context, "txtUMoInvoMonth"));
    cfin19si.setUYrInvoYear(ContextHelper.getIntSafe(context, "txtUYrInvoYear"));
    
    //STGAP00013273 : Added new field Client Person ID to search on
    int idClientPerson = ContextHelper.getIntSafe(context, "txtUlIdClientPerson");
    
    cfin19si.setUlIdClientPerson(idClientPerson);

    /*
     * SzCdCntrctRegion_ARRAY usersRegions = new SzCdCntrctRegion_ARRAY(); List<String> regionList =
     * user.getUserMaintainedRegions();
     * 
     * if(regionList.isEmpty()){ //-- throw exception to stop retrieval process throw new
     * ServiceException(Messages.MSG_NO_REGION_PROFILE_SELECTED); }
     * 
     * for(String rawRegion : regionList) { String region = FormattingHelper.convertRegionCode(rawRegion);
     * usersRegions.addSzCdCntrctRegion(region); // may be the only required line ktl }
     *  // set cfin19si values cfin19si.setSzCdCntrctRegion_ARRAY(usersRegions);
     */
    String winMode = "";
    if ((user.hasRight(UserProfile.SEC_FIN_MODIFY_CPS_PAY_APPVL))) {
      winMode = "C";
    }
    cfin19si.setSzSysCdWinMode(winMode);

    // -- These are hidden inputs dynamically created by the ending impact:pagination tag on JSP.
    // -- They are given values by Javascript called when clicking on the sort arrows generated via
    // -- the sortableColumnHeader tag.
    String orderBy = ContextHelper.getStringSafe(context, "orderBy");
    if ("".equals(orderBy)) {
      orderBy = SORT_BY_INITIAL;
    }
    String sortDir = ContextHelper.getStringSafe(context, "orderByDirection");
    if ("".equals(sortDir)) {
      sortDir = ServiceConstants.SORT_ASCENDING;
    }
    // -- Set into input object and also into tuxPagination so that logic for determining sortDir
    // -- in SortableColumnTag works.
    cfin19si.setBWcdCdSortBy(orderBy);
    cfin19si.setSzSortDir(sortDir);
    tuxPagination.getResultDetails().setOrderBy(orderBy);
    tuxPagination.getResultDetails().setOrderByDirection(sortDir);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cfin19si;

  } // end populateCFIN19SI_RETRIEVE

  /**
   * *********************************************************************************** This helper method populates
   * row for a update for the payment approval pag *
   * 
   * @param context
   *          The GrndsExchangeContext object
   *          ************************************************************************************
   */
  private CFIN20SI populateCFIN20SI_UPDATE(GrndsExchangeContext context, int indexRowsSelected, String btnPressed)
                                                                                                                  throws MarshalException,
                                                                                                                  ValidationException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCFIN20SI_UPDATE()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    // get the user id
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // get the cfin19 object from state
    CFIN19SO cfin19so = (CFIN19SO) state.getAttribute("CFIN19SO", request);

    if (cfin19so == null) {
      cfin19so = new CFIN19SO();
    }

    ROWCFIN19SOG_ARRAY listArray = new ROWCFIN19SOG_ARRAY();
    if (cfin19so.getROWCFIN19SOG_ARRAY() != null) {
      listArray = cfin19so.getROWCFIN19SOG_ARRAY();
    }
    ROWCFIN19SOG paymentApprovalRowIn = listArray.getROWCFIN19SOG(indexRowsSelected);
    // create new update object, array and row
    CFIN20SI cfin20si = new CFIN20SI();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG_ARRAY paymentApproval_array = new ROWCFIN20SIG_ARRAY();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN20SIG paymentApprovalRowOut = new ROWCFIN20SIG();
    ArchInputStruct input = new ArchInputStruct();

    // set service arch variables for the update
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlPageSizeNbr(1);
    input.setUsPageNbr(0);
    input.setSzUserId(String.valueOf(user.getUserID()));
    // set values for output rows
    paymentApprovalRowOut.setUlIdInvoInvoice(paymentApprovalRowIn.getUlIdInvoInvoice());
    paymentApprovalRowOut.setSzCdSysDataActionOutcome(ServiceConstants.REQ_FUNC_CD_UPDATE);
    paymentApprovalRowOut.setTsLastUpdate(paymentApprovalRowIn.getTsLastUpdate());
    if ("approve".equals(btnPressed)) {
      paymentApprovalRowOut.setSzCdInvoApproved("APV");
      paymentApprovalRowOut.setUlIdPerson(user.getUserID());
      paymentApprovalRowOut.setDtDtInvoApprovalDate(DateHelper.getTodayCastorDate());
    } else if ("disapprove".equals(btnPressed)) {
      paymentApprovalRowOut.setSzCdInvoApproved("DPV");
      paymentApprovalRowOut.setUlIdPerson(user.getUserID());
      paymentApprovalRowOut.setDtDtInvoApprovalDate(DateHelper.getTodayCastorDate());
    } else if ("reset".equals(btnPressed)) {
      paymentApprovalRowOut.setSzCdInvoApproved("PAP");
    }
    // Add the row to the array
    paymentApproval_array.addROWCFIN20SIG(paymentApprovalRowOut);
    // Set the array into the parent service
    cfin20si.setROWCFIN20SIG_ARRAY(paymentApproval_array);
    cfin20si.setArchInputStruct(input);

    // end performance trace
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    // return the ccfc27si object
    return cfin20si;
  }

  /**
   * ************************************************************************************* This helper method handles
   * all the WTC Exceptions thrown by this conversation
   * **************************************************************************************
   */
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    int errorCode = we.getErrorCode();
    switch (errorCode) {
    case Messages.MSG_DATABASE_RETRIEVE_FAIL:
      // String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      setErrorMessage(errorCode, "/financials/PaymentApproval/displayPaymentApproval", request);
      break;
    case Messages.MSG_DATABASE_SAVE_FAIL:
      // String errorMessage2 = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_SAVE_FAIL);
      setErrorMessage(errorCode, "/financials/PaymentApproval/displayPaymentApproval", request);
      break;
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      // String errorMessage3 = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      setErrorMessage(errorCode, "/financials/PaymentApproval/displayPaymentApproval", request);
      break;
    /* SIR 22915 Added Message NO_REGION_PROFILE_SELECTED */
    case Messages.MSG_NO_REGION_PROFILE_SELECTED:
      // String errorMessage4 = MessageLookup.getMessageByNumber(Messages.MSG_NO_REGION_PROFILE_SELECTED);
      request.setAttribute(REGION_SECURITY_VIOLATION, "X");
      setInformationalMessage(errorCode, "/financials/PaymentApproval/displayPaymentApproval", request);
      break;
    default:
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
      break;
    }
  }
}
