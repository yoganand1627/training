package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.BudgetUpdateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContractCountiesSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.InvoiceLineItem;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN07SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN11SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN11SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN14SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFIN16SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContractCountiesSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to maintain Invoice Information in the system. <p/> October 8, 2002 Anna N.
 * Grimshaw
 * 
 * <pre>
 *   Change History:
 *    Date        User      Description
 *    ----------  --------  --------------------------------------------------
 *    05/13/03    GRIMSHAN  SIR #17295 In populate cfin02, made the method
 *                          check for the contract field, before checking
 *                          for the one in global data
 *    05/15/03    GRIMSHAN  SIR 17477 In populate cfin11, get cbx reversal
 *                          out as a checkbox value instead of a string
 *    05/16/03    GRIMSHAN  SIR 17512 make sure the user has modify region attribute
 *                          in display invoice
 *    05/18/03    GRIMSHAN  SIR 17528 In display invoice, when looping through
 *                          the cost reimbursement rows, display the message telling
 *                          the user to navigate to cost reimbursement based on
 *                          if the data action for the row returned is add.  If
 *                          it is add, this means the row has been genereated from
 *                          the delivered service table, and has not been saved
 *                          to the cost reimbursement table yet.  Thus the unit
 *                          rate has not been calculated.
 *    05/21/03    GRIMSHAN  SIR 17580 -- Added new using piece to display delivered
 *                          service.  Also, if the page is in modify mode, do not
 *                          re-validate on save, as nothing that was validated can
 *                          be changed.
 *    05/29/03    GRIMSHAN  SIR 17870 -- In populate cfin14 calculate unit rate
 *                          as long as quantity is not 0
 *    09/02/03    A.Corley  SIR 19684 -- Use page sets to disable the contract
 *                          ID input and validate pushbutton when we are new using.
 *    09/15/2003  Matthew McClain SIR 19696 - Finished instrumenting pagination preservation
 *    09/23/03    A.Corley  SIR 19795 remove rate calculation code from delivered save
 *                          save as 0.0 if they save delivered, and display the message
 *                          to save cost reimbursement in order to get the correct unit rate.
 *    09/30/03   CORLEYAN   SIR 19897 If the user is trying to validate a CRM
 *                          and has not saved the type as Delivered Service Both or Delivered
 *                          Service Cost reimbursement, display a message.
 *    12/30/03  RIOSJA      SIR 22520, RIOSJA - Updated &quot;populateCFIN03SI_AU&quot; so
 *                          that &quot;DtDtInvoEntryStarted&quot; and &quot;DtDtInvoEntryCompleted&quot;
 *                          are populated correctly. DT_INVO_ENTRY_STARTED and
 *                          DT_INVO_ENTRY_COMPLETED were null in the database when
 *                          they weren't supposed to be.
 *    01/24/04   CORLEYAN   SIR 22425 -- MSG_FIN_MORE_REV_THAN_ADJ will no longer be
 *                          returned from the service.
 *    04/26/05   MALPANS   SIR 23475 - Unit Rate invoices with multiple pages of Delivered Service line items, the
 *   Delivered Service Detail page in Add mode,
 *                         when opened from any but the first page of line items, is mis-aligned
 *                         and services in drop-down include ALL service codes, not just the services in the contract so
 *                         removed the condition if( tuxPagination.getResultDetails().getRequestedPage() == ONE) from
 *                         populateCFIN06S_Retrieve.
 *   05/15/08  vdevarak  STGAP00007737: Modified this file as part of enhancement
 *                       MR-012.
 *                       
 *   04/08/2009 bgehlot   STGAP00013273: Added the code to set the Provider Invoice Number
 *   04/29/2009 arege     STGAP00013397 MR-033 Added new code RCS- Relative Care Subsidy .
 *                        so that Delivered Service List is displayed when
 *                        RCS Invoice type is selected on the Invoice Header
 * </pre>
 */
@SuppressWarnings("serial")
public class InvoiceConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "InvoiceConversation";

  /** String SORT_NAME */
  public static final String SORT_NAME = "1";

  /** String SORT_RSRC_ID */
  public static final String SORT_RSRC_ID = "2";

  /** String REQ_FUNC_CD_DTLS_CDS */
  public static final String REQ_FUNC_CD_DTLS_CDS = "C";

  /** String REQ_FUNC_CD_FIRST_TIME */
  public static final String REQ_FUNC_CD_FIRST_TIME = "F";

  /** String FIN_SORT_TYPE_NM */
  public static final String FIN_SORT_TYPE_NM = "NM";

  /** String FIN_SORT_TYPE_MY */
  public static final String FIN_SORT_TYPE_MY = "MY";

  /** String FIN_SORT_TYPESVCCD */
  public static final String FIN_SORT_TYPESVCCD = "CD";

  /** String FIN_PHASE_PENDING */
  public static final String FIN_PHASE_PENDING = CodesTables.CINVPHSE_VLP;

  /** String FIN_PHASE_VWO */
  public static final String FIN_PHASE_VWO = CodesTables.CINVPHSE_VWO;

  /** String FIN_PHASE_VWI */
  public static final String FIN_PHASE_VWI = CodesTables.CINVPHSE_VWI;

  /** String FIN_CD_DAY */
  public static final String FIN_CD_DAY = "DA2";

  /** String ORIGINAL_LI */
  public static final String ORIGINAL_LI = CodesTables.CLNITMTP_O;

  /** String REVERSAL_LI */
  public static final String REVERSAL_LI = CodesTables.CLNITMTP_R;

  /** String ADJUSTMENT_LI */
  public static final String ADJUSTMENT_LI = CodesTables.CLNITMTP_A;

  /** String FIN_NO_SHOW_CODE */
  public static final String FIN_NO_SHOW_CODE = "NOS";

  /** String FIN_STAT_APPROVED */
  public static final String FIN_STAT_APPROVED = CodesTables.CINVOAPV_APV;

  /** String FIN_STAT_DISAPPROVED */
  public static final String FIN_STAT_DISAPPROVED = CodesTables.CINVOAPV_DPV;

  /** String FIN_PHASE_SUBMITTED */
  public static final String FIN_PHASE_SUBMITTED = CodesTables.CINVPHSE_SBT;

  /** String FIN_PHASE_NOT_SUBMIT */
  public static final String FIN_PHASE_NOT_SUBMIT = CodesTables.CINVPHSE_NSB;

  /** String FIN_PHASE_PAID */
  public static final String FIN_PHASE_PAID = CodesTables.CINVPHSE_PAD;

  /** String IND_ERROR */
  public static final String IND_ERROR = "indError";
  
  /** String IND_DAY_MISMATCH */
  public static final String IND_DAY_MISMATCH = "indDayMismatch";

  /** String IND_VALIDATE */
  public static final String IND_VALIDATE = "indValidate";

  /** String REQ_FUNC_CD */
  public static final String REQ_FUNC_CD = "cReqFuncCd";

  /** String PAGE_MODE */
  public static final String PAGE_MODE = "pageMode";

  /** String NO_SERVICE */
  public static final String NO_SERVICE = "noService";

  /** String DISPLAY_INVOICE */
  public static final String DISPLAY_INVOICE = "/financials/Invoice/displayInvoice";

  /** String DISPLAY_DELIVERED */
  public static final String DISPLAY_DELIVERED = "/financials/invoice/displayDeliveredDetail";

  /** String DISPLAY_FOSTER */
  public static final String DISPLAY_FOSTER = "/financials/invoice/displayFosterDetail";
  
  public static final String DISPLAY_ADMIN = "/financials/Invoice/displayAdminDetail";

  /* String EXCLUDE_VIEWS */
  //private static final String EXCLUDE_VIEWS = "excludeViews";
  
  public static final String SERVICE_CODE_OPTIONS = "liSvcCodeOptions";
  
  public static final String SERVICE_UNIT_TYPES = "mapServiceUnitTypes";
  
  public static final String COUNTY_SERVICE_MAP = "mapCountyServiceCodes";
  
  public static final String COUNTY_OPTIONS = "countyOptions";
  
  public static final String REGION_COUNTY_MAP = "mapRegionCounty";
  
  public static final String REGION_OPTIONS = "regionOptions";

  /** int ONE */
  public static final int ONE = 1;

  /** int ONE_HUNDRED */
  public static final int ONE_HUNDRED = 100;

  public static final int ADMIN_OR_FOSTER_CARE_MAX_RESULTS = 20;

  public static final int ADOPTION_OR_DELVD_SVC_MAX_RESULTS = 20;

  public static final String INVOICE_PAGINATION_DB = "InvoiceConversation.invoicePaginationDB";
  
  public static final String FOSTER_CARE = "F";
  
  public static final String DELIVERED_SERVICE = "D";

  private Financials financials = null;
  
  public void setFinancials(Financials fin) {
    financials = fin;
  }
  
  /**
   * displayInvoice <p/> This method is used to display an already created invoice. It first calls the CFIN02 Service to
   * display the Invoice header information. Then, depending on what Invoice type is being displayed it makes a call to
   * different services to display the list associated with the invoice.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayInvoice_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayInvoice_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    try {
      BaseSessionStateManager state = getSessionStateManager(context);

      InvoicePaginationDB invoicePaginationDB = (InvoicePaginationDB) state
                                                                           .getAttribute(INVOICE_PAGINATION_DB, request);

      // clear state since this is an entry point for this conversation
      state.removeAllAttributes(request);

      // Set Pagination data
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);

      // if user didn't click Next/Previous and we have an invoicePaginationDB for
      // this invoice, set the page number according to the invoicePaginationDB
      if ((ValueBeanHelper.hasRequestedPage(request) == false) && (invoicePaginationDB != null)
          && (invoicePaginationDB.getUlIdInvoice() == GlobalData.getUlIdInvoice(request))) {
        int page = invoicePaginationDB.getPageNumber();
        tuxPagination.getResultDetails().setRequestedPage(page);
      } else {
        invoicePaginationDB = new InvoicePaginationDB(GlobalData.getUlIdInvoice(request),
                                                      tuxPagination.getResultDetails().getRequestedPage());
      }

      // Set indError to "N" b/c there is no validation error at this point
      request.setAttribute(IND_ERROR, ArchitectureConstants.N);

      // Set indValidate to "Y" b/c if the page has been previously saved, it has already been validated
      request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);

      // Set the page mode equal to the app mode
      PageMode.setPageMode(GlobalData.getAppMode(request), request);

      // If the page mode is New, reset it to Modify for re-displaying the page.
      if (PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
      }
      buildRegionCountyMap(request, false);

      // Tell the popoulate method that we are coming from the display
      CFIN02SI cfin02si = populateCFIN02S_Retrieve(context, "DISPLAY");
      // String outputXml = WtcHelper.callService("CFIN02S", cfin02si);
      // CFIN02SO cfin02so = CFIN02SO.unmarshal(new StringReader(outputXml));

      CFIN02SO cfin02so = financials.findInvoiceHeaderInformation(cfin02si);

      PageMode.setPageMode(GlobalData.getAppMode(request), request);

      String invoPhase = cfin02so.getSzCdInvoPhase();
      if (PageMode.getPageMode(request).equals(PageModeConstants.MODIFY)) {
        if (FIN_STAT_APPROVED.equals(cfin02so.getSzCdInvoApproved())
            || FIN_STAT_DISAPPROVED.equals(cfin02so.getSzCdInvoApproved())) {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        } else if (FIN_PHASE_SUBMITTED.equals(invoPhase) || FIN_PHASE_NOT_SUBMIT.equals(invoPhase)
                   || FIN_PHASE_PAID.equals(invoPhase)) {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
      }

      // SIR 17512 GRIMSHAN
      // Need to determine if the user is assigned to the returned region, or
      // if he/she has security access to the returned region. If not, set
      // the page mode to browse
      String indContractRegion = validateRegionForContract(cfin02so.getSzCdCntrctRegion(), user, request);

      if (indContractRegion.equals(ArchitectureConstants.N)) {
        PageMode.setPageMode(PageModeConstants.VIEW, request);
        // cfin02so.setSzCdCounty_Array(new SzCdCounty_Array());
      }

      GlobalData.setUlIdInvoice(cfin02so.getUlIdInvoInvoice(), request);
      GlobalData.setUlIdContract(cfin02so.getUlIdContract(), request);
      GlobalData.setSzCdInvoPhase(invoPhase, request);
      GlobalData.setSzCdCounty(cfin02so.getSzCdCounty(), request);

      request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);
      state.setAttribute("CFIN02SO", cfin02so, request);

      // Setting a variable into the request that may be over written with an exception
      // below. If this happens it means that the appropriate list retreival has returned
      // an error that does not allow the users to add entries to the lists.
      request.setAttribute(NO_SERVICE, ArchitectureConstants.N);

      // Depending on what Invoice type was returned from the Service,
      // Use database calls to display the appropriate list.
      displayLineItemList(context, cfin02so, tuxPagination, 0);
      // only insert the new invoicePaginationDB if everything succeeded
      state.setAttribute(INVOICE_PAGINATION_DB, invoicePaginationDB, request);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_DATABASE_RETRIEVE_FAIL:
        // this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, DISPLAY_INVOICE, context.getRequest());
        break;

      case Messages.MSG_CON_NO_SVC_CODE:
      case Messages.MSG_CON_NO_CNTRCT_CODE:
        // this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);

        setErrorMessage(Messages.MSG_CON_NO_CNTRCT_CODE, DISPLAY_INVOICE, context.getRequest());

        request.setAttribute(NO_SERVICE, ArchitectureConstants.Y);
        break;

      case Messages.MSG_FIN_COST_REIM_NO_DS:
        // this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, DISPLAY_INVOICE, context.getRequest());
        request.setAttribute(NO_SERVICE, ArchitectureConstants.Y);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * addInvoice <p/> This method is used to display the Invoice page in new mode. If there is a Contract ID available in
   * Global Data, it calls the CFIN02S service to validate whether or not that is a good ID
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addInvoice_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addInvoice_xa()");
    performanceTrace.enterScope();
    //STGAP00006777 
    String cIndCopiedInv = (String) state.getAttribute("cIndCopiedInv", request);
    int ulIdInvoInvoiceCopied = (Integer) state.getAttribute("ulIdInvoInvoiceCopied", request) == null ? 0
                                                                                                      : (Integer) state
                                                                                                                       .getAttribute(
                                                                                                                                     "ulIdInvoInvoiceCopied",
                                                                                                                                     request);
    InvoicePaginationDB invoicePaginationDB = (InvoicePaginationDB) state.getAttribute(INVOICE_PAGINATION_DB, request);
    try {
      // remove all attributes from state since this is an access point for this conversation
      state.removeAllAttributes(request);
      UserProfile user = UserProfileHelper.getUserProfile(context);

      // Set a variable into the request as "N". This variable will be re-set to
      // "Y" if an error is returned from the service, in order to prevent the user
      // from saving.
      request.setAttribute(IND_ERROR, ArchitectureConstants.N);

      // Set page mode to new since we are adding a new invoice
      PageMode.setPageMode(PageModeConstants.NEW, request);

      // Only call display service if Contract Id or Invoice ID has been passed to the page
      if (GlobalData.getUlIdContract(request) != 0) {
        // Give the populate method the inforamtion that we are coming from the Add method
        CFIN02SI cfin02si = populateCFIN02S_Retrieve(context, "ADD");
        //STGAP00006777 - For copied invoices the copied invoice information should be retrieved.
        if (ArchitectureConstants.Y.equals(cIndCopiedInv)) {
          cfin02si.setCIndCopiedInv(ArchitectureConstants.Y);
          cfin02si.setUlIdInvoInvoiceCopied(ulIdInvoInvoiceCopied);
          setInformationalMessage(Messages.MSG_SAVE_COPIED_INVOICE, request);
        }
        CFIN02SO cfin02so = financials.findInvoiceHeaderInformation(cfin02si);
        ////STGAP00006777 - For the copied invoice the following field values should not be copied hence they are reset.
        if (ArchitectureConstants.Y.equals(cIndCopiedInv)) {
          cfin02so.setSzCdInvoPhase(FIN_PHASE_PENDING);
          cfin02so.setDtDtInvoSubmitDate(null);
          cfin02so.setDtDtInvoWarrantDate(null);
          cfin02so.setSzNbrInvoWarrant(null);
          cfin02so.setDAmtInvoValidAmount(0.00);
          cfin02so.setDAmtInvoWarrant(0.00);
        }
        // -- see if county value exists in GlobalData; if so, use it for new invoice
        String county = GlobalData.getSzCdCounty(request);
        if (county != null && !"".equals(county)) {
                    cfin02so.setSzCdCounty(county);
         }

        state.setAttribute("CFIN02SO", cfin02so, request);

        // If cfin02 is blank, display invalid Contract ID message
        if (cfin02so == null || "".equals(cfin02so)) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_FIN_INVLD_CNTRCT_ID), DISPLAY_INVOICE, request);
        } else {

          // Need to determine if the user is assigned to the returned region, or
          // if he/she has security access to the returned region. If not, display
          // an error message.
          String indContractRegion = validateRegionForContract(cfin02so.getSzCdCntrctRegion(), user, request);

          if (indContractRegion.equals(ArchitectureConstants.N)) {
            setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_FIN_INVLD_REGION), DISPLAY_INVOICE, request);
            }
        }

        request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);

        // If we are in "New Using" use a page set to disable contract ID and validate pushbutton
        Sets.setPageSet(Sets.A, request);
        request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);
        buildRegionCountyMap(request, true);
        //STGAP00006777 - for copied invoices the copied invoice information including the line item list is displayed
        if (ArchitectureConstants.Y.equals(cIndCopiedInv)) {
          // Set Pagination data
          state.setAttribute("cIndCopiedInv", ArchitectureConstants.Y, request);
          TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
          ValueBeanHelper.populateDefaultValues(context, tuxPagination);
          if ((ValueBeanHelper.hasRequestedPage(request) == false) && (invoicePaginationDB != null)
              && (invoicePaginationDB.getUlIdInvoice() == GlobalData.getUlIdInvoice(request))) {
            int page = invoicePaginationDB.getPageNumber();
            tuxPagination.getResultDetails().setRequestedPage(page);
          } else {
            invoicePaginationDB = new InvoicePaginationDB(GlobalData.getUlIdInvoice(request),
                                                          tuxPagination.getResultDetails().getRequestedPage());
          }

          buildRegionCountyMap(request, false);

          request.setAttribute(NO_SERVICE, ArchitectureConstants.N);
          displayLineItemList(context, cfin02so, tuxPagination, ulIdInvoInvoiceCopied);
          // only insert the new invoicePaginationDB if everything succeeded
          state.setAttribute(INVOICE_PAGINATION_DB, invoicePaginationDB, request);
        }
      }

      request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);
      buildRegionCountyMap(request, true);
    }catch (ServiceException we) {
        int errorCode = we.getErrorCode();
        switch (errorCode) {
        case Messages.MSG_DATABASE_RETRIEVE_FAIL:
          // this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          setErrorMessage(errorCode, DISPLAY_INVOICE, context.getRequest());
          break;

        case Messages.MSG_CON_NO_SVC_CODE:
        case Messages.MSG_CON_NO_CNTRCT_CODE:
          // this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);

          setErrorMessage(Messages.MSG_CON_NO_CNTRCT_CODE, DISPLAY_INVOICE, context.getRequest());

          request.setAttribute(NO_SERVICE, ArchitectureConstants.Y);
          break;

        case Messages.MSG_FIN_COST_REIM_NO_DS:
          // this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          setErrorMessage(errorCode, DISPLAY_INVOICE, context.getRequest());
          request.setAttribute(NO_SERVICE, ArchitectureConstants.Y);
          break;

        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
        }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * validateContract <p/> This method is called when the user clicks the Validate pushbutton on the Invoice page, it
   * calls CFIN02S to validate the Contract ID entered by the user. If a contract was returned, it checks to see if the
   * user's region is equal to the region returned. If not an informational message is displayed
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void validateContract_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateContract_xa()");
    performanceTrace.enterScope();
    try {
      UserProfile user = UserProfileHelper.getUserProfile(context);

      // Set a variable into the request as "N". This variable will be re-set to
      // "Y" if an error is returned from the service, in order to prevent the user
      // from saving.
      request.setAttribute(IND_ERROR, ArchitectureConstants.N);

      String cReqFuncCd = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");
      String pageMode = ContextHelper.getStringSafe(request, "hdnPageMode");
      request.setAttribute(REQ_FUNC_CD, cReqFuncCd);
      request.setAttribute(PAGE_MODE, pageMode);

      CFIN02SI cfin02si = populateCFIN02S_Retrieve(context, "VALIDATE");

      // String outputXml = WtcHelper.callService("CFIN02S", cfin02si);
      // CFIN02SO cfin02so = CFIN02SO.unmarshal(new StringReader(outputXml));
      CFIN02SO cfin02so = financials.findInvoiceHeaderInformation(cfin02si);
      
      request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);
      //state.setAttribute("CFIN02SO", cfin02so, request);

      // If cfin02 is blank, display invalid Contract ID message
      if (cfin02so.getUlIdContract() == 0) {
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_FIN_INVLD_CNTRCT_ID), DISPLAY_INVOICE, request);
        clearContractValidation(request, cfin02so);
      } else {
        // Need to determine if the user is assigned to the returned region, or
        // if he/she has security access to the returned region. If not, display
        // an error message.
        String indContractRegion = validateRegionForContract(cfin02so.getSzCdCntrctRegion(), user, request);
        
        if (indContractRegion.equals(ArchitectureConstants.N)) {
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_FIN_INVLD_REGION), DISPLAY_INVOICE, request);
          clearContractValidation(request, cfin02so);
        }
      }
      
      state.setAttribute("CFIN02SO", cfin02so, request);
      //request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * displayFosterDetail <p/> This method is used when the user clicks on a hyperlink in the Foster Care List It
   * retrieves the row clicked based on the index of the row selected. It then generates the array for the dropdown on
   * the foster page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayFosterDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayFosterDetail_xa()");
    performanceTrace.enterScope();

    int index = ContextHelper.getIntSafe(request, "hdnLoopCount");
    setRowIndexOnPagination(request, index);

    // Set indError to "N" b/c there is no validation error at this point
    request.setAttribute(IND_ERROR, ArchitectureConstants.N);

    // Set indValidate to "Y" b/c if the page has been previously saved, it has already been validated
    request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);

    CFIN10SO cfin10so = (CFIN10SO) state.getAttribute("CFIN10SO", request);
    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);
    request.setAttribute("ROWCFIN10SOG00", cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(index));

    //-- create service code options from the retrieved services and set into state
    setFosterCareServiceOptions(request, cfin10so.getROWCFIN10SOG01_ARRAY());

    //String globalPageMode = PageMode.getPageMode(request);
    CFIN02SI cfin02si = populateCFIN02S_Retrieve(context, "ADD");
    // String outputXml = WtcHelper.callService("CFIN02S", cfin02si);
    // CFIN02SO cfin02so = CFIN02SO.unmarshal(new StringReader(outputXml));
    CFIN02SO cfin02so = financials.findInvoiceHeaderInformation(cfin02si);
    
    String regionCode = cfin02so.getSzCdCntrctRegion();
    UserProfile userProfile = UserProfileHelper.getUserProfile( request );
    boolean userHasRegion = userProfile.hasAccessToRegion(regionCode);
    boolean userHasModifyInvoice = userProfile.hasRight(UserProfile.SEC_FIN_MODIFY_INVOICE);
    String pageMode = PageModeConstants.VIEW;
    if (userHasRegion && userHasModifyInvoice){
      pageMode = PageModeConstants.MODIFY;
    } else {
      pageMode = PageModeConstants.VIEW;
    }

    // Set pageMode from global data into the request, since on Add it is set into the request
    // With a different pageMode than the global page mode
    request.setAttribute(PAGE_MODE, pageMode);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * validateFoster <p/> This method is called when the user clicks validate on the Foster Care Detail page. It calls
   * CFIN08S for the validation, and sets a boolean into the request indicating that the information had been validated.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void validateFoster_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateFoster_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    try {
      // Set a variable into the request as "N". This variable will be re-set to
      // "Y" if an error is returned from the service, in order to prevent the user
      // from saving.
      request.setAttribute(IND_ERROR, ArchitectureConstants.N);

      String cReqFuncCd = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");
      String pageMode = ContextHelper.getStringSafe(request, "hdnPageMode");
      request.setAttribute(REQ_FUNC_CD, cReqFuncCd);
      request.setAttribute(PAGE_MODE, pageMode);

      CFIN08SI cfin08si = populateCFIN08SI_V(context);

      // String outputXml = WtcHelper.callService("CFIN08S", cfin08si);
      // CFIN08SO cfin08so = CFIN08SO.unmarshal(new StringReader(outputXml));
      CFIN08SO cfin08so = financials.retrieveFosterCareDetailValidation(cfin08si);
      request.setAttribute("CFIN08SO", cfin08so);
      request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);

    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.SSM_FIN_INVALID_PRSN_ID:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.SSM_FIN_INVALID_PRSN_ID, DISPLAY_FOSTER, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;
      case Messages.SSM_FIN_INVALID_RSRC_ID:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.SSM_FIN_INVALID_RSRC_ID, DISPLAY_FOSTER, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;
      case Messages.MSG_CLIENT_SMILE:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_CLIENT_SMILE, DISPLAY_FOSTER, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;   
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * validateDelivered <p/> This method is called when the user clicks validate on the Delivered Service Detail page. It
   * calls CFIN29S to validate the information entered.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void validateDelivered_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateDelivered_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {

      String szCdSvcDtlUnitType = ContextHelper.getStringSafe(request, "selSzCdSvcDtlUnitType");
      int noShowPercentInt = 0;
      float noShowPercent = 0;
      double noShowUnitRate = 0.0;

      String cReqFuncCd = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");
      String pageMode = ContextHelper.getStringSafe(request, "hdnPageMode");
      request.setAttribute(REQ_FUNC_CD, cReqFuncCd);
      request.setAttribute(PAGE_MODE, pageMode);

      CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);

      CFIN29SI cfin29si = populateCFIN29SI_V(context, cReqFuncCd, cfin02so);

      // String outputXml = WtcHelper.callService("CFIN29S", cfin29si);
      // CFIN29SO cfin29so = CFIN29SO.unmarshal(new StringReader(outputXml));
      CFIN29SO cfin29so = financials.retrieveDeliveredServiceValidation(cfin29si);

      // Set a variable into the request as "N". This variable will be re-set to
      // "Y" if an error is returned from the service, in order to prevent the user
      // from saving.
      request.setAttribute(IND_ERROR, ArchitectureConstants.N);

      // If the user has selectd "No Show" for unit type, do not overwrite this
      // selection with the unit type returned from the service.
      if (szCdSvcDtlUnitType.equals(FIN_NO_SHOW_CODE)) {
        cfin29so.setSzCdSvcDtlUnitType(FIN_NO_SHOW_CODE);

        // No Show Percentage comes back as an integer, if it is 0, reset
        // it for calculations to 100
        if (cfin29so.getUlNbrCnverNoShowPct() == 0) {
          noShowPercentInt = 100;
        } else {
          noShowPercentInt = cfin29so.getUlNbrCnverNoShowPct();
        }

        // If the unit type is "No Show" Calculate the Unit rate based
        // on the No Show Percentage returned.

        noShowPercent = noShowPercentInt * 0.01f;

        noShowUnitRate = cfin29so.getDAmtSvcDtlUnitRate() * noShowPercent;

        cfin29so.setDAmtSvcDtlUnitRate(noShowUnitRate);

      }

      // SIR 19897 If the payment type for the service is Cost Reimbursement, and the
      // Invoice header has not been marked as Delivered Service Both or Delivered Service
      // Cost Reimbursement, display a message and do not allow the user to save.
      if ("CRM".equals(cfin29so.getSzCdCnsvcPaymentType())
          && (!"DSB".equals(cfin02so.getSzCdInvoType()) && !"DCR".equals(cfin02so.getSzCdInvoType()))) {
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_NOT_COST, DISPLAY_DELIVERED, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        request.setAttribute(IND_VALIDATE, ArchitectureConstants.N);
      }
      request.setAttribute("CFIN29SO", cfin29so);
      request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);

    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_ARC_CONSTR_MONTH:
      case Messages.MSG_ARC_CONSTR_YEAR:
      case Messages.MSG_FIN_DSD_EXISTS:
      case Messages.MSG_CLIENT_SMILE:
      case Messages.SSM_FIN_NO_SVC_AUTH_DTL:
      case Messages.SSM_FIN_NO_UNIT_RATE:
      case Messages.SSM_FIN_INVALID_PRSN_ID:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, DISPLAY_DELIVERED, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * displayAdminDetail <p/> This method called when the user clicks on the Hyperlink in the Administrative List section
   * of the Invoice Header. It is used to display the Administrative detail page. It first retrieves the information for
   * the row clicked on based on the index of the row selected. It then generates the display for the service dropdown
   * in the page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayAdminDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAdminDetail_xa()");
    performanceTrace.enterScope();

    int index = ContextHelper.getIntSafe(request, "hdnLoopCount");
    setRowIndexOnPagination(request, index);

    CFIN15SO cfin15so = (CFIN15SO) state.getAttribute("CFIN15SO", request);
    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);
    request.setAttribute("ROWCFIN15SOG00", cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(index));

    CFIN02SI cfin02si = populateCFIN02S_Retrieve(context, "ADD");
    // String outputXml = WtcHelper.callService("CFIN02S", cfin02si);
    // CFIN02SO cfin02so = CFIN02SO.unmarshal(new StringReader(outputXml));
    CFIN02SO cfin02so = financials.findInvoiceHeaderInformation(cfin02si);
    
    String regionCode = cfin02so.getSzCdCntrctRegion();
    UserProfile userProfile = UserProfileHelper.getUserProfile( request );
    boolean userHasRegion = userProfile.hasAccessToRegion(regionCode);
    boolean userHasModifyInvoice = userProfile.hasRight(UserProfile.SEC_FIN_MODIFY_INVOICE);
    String pageMode = PageModeConstants.VIEW;
    if (userHasRegion && userHasModifyInvoice){
      pageMode = PageModeConstants.MODIFY;
    } else {
      pageMode = PageModeConstants.VIEW;
    }

    // Set pageMode from global data into the request, since on Add it is set into the request
    // With a different pageMode than the global page mode
    request.setAttribute(PAGE_MODE, pageMode);
    setCountyServiceMap(context);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * displayDeliveredDetail <p/> This method is called when the user clicks on a hyperlink in the Delivered Service
   * Section of an Invoice. It first retrieves the information for the row selected based on the index of the row. It
   * then generates an array for the service dropdown on the Delivered Service Detail Page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayDeliveredDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayDeliveredDetail_xa()");
    performanceTrace.enterScope();

    int index = ContextHelper.getIntSafe(request, "hdnLoopCount");
    setRowIndexOnPagination(request, index);

    CFIN06SO cfin06so = (CFIN06SO) state.getAttribute("CFIN06SO", request);
    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);
    
    ROWCFIN06SOG rowcfin06sog = null;

    // SIR 17580 if New Using has been selected, put the function code
    // to add.
    if (StringHelper.isValid(ContextHelper.getStringSafe(context, "btnNewUsing.x"))) {
      request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);
      index = ContextHelper.getIntSafe(request, "rbRowsIndex_CLEAN");
      
      //-- do not copy Person ID, Month, Year, Unit Type, or Rate
      ROWCFIN06SOG rowToCopy = cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(index);
      rowToCopy.setSzScrNmGenericFullName(null);
      rowToCopy.setUMoSvcDtlSvcMonth(0);
      rowToCopy.setUYrSvcDtlServiceYear(0);
      rowToCopy.setSzCdSvcDtlUnitType(null);
      rowToCopy.setDAmtSvcDtlUnitRate(0.0);
      rowToCopy.setUsNbrSvcDtlCsli(0);
      request.setAttribute("ROWCFIN06SOG", rowToCopy);
      rowcfin06sog = rowToCopy;
      
      request.setAttribute(IND_VALIDATE, ArchitectureConstants.N);
      request.setAttribute(PAGE_MODE, PageModeConstants.NEW);
      request.setAttribute(IND_ERROR, null);
    } else {
      rowcfin06sog = cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(index);
      request.setAttribute("ROWCFIN06SOG", rowcfin06sog);
      
      // Set indValidate to "Y" b/c if the page has been previously saved, it has already been validated
      request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);
      
      String globalPageMode = PageMode.getPageMode(request);
      String pageMode = "";

      if (globalPageMode.equals(PageModeConstants.MODIFY) || globalPageMode.equals(PageModeConstants.NEW)) {
        pageMode = PageModeConstants.MODIFY;
      } else if (globalPageMode.equals(PageModeConstants.VIEW)) {
        pageMode = PageModeConstants.VIEW;
      }

      // Set pageMode from global data into the request, since on Add it is set into the request
      // With a different pageMode than the global page mode
      request.setAttribute(PAGE_MODE, pageMode);
      // Set indError to "N" b/c there is no validation error at this point
      request.setAttribute(IND_ERROR, ArchitectureConstants.N);
    }
    
    //-- hyperlink or copy button clicked - retrieve valid county values
    //-- and associated service codes - set them into state for page display
    setCountyServiceMap(context);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * displayCostDetail <p/> This method is called when the user clicks on the hyperlink in the Cost Reimbursement List
   * on the Invoice Page. It retrieves the detail information for the row based on the index of the row selected.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayCostDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCostDetail_xa()");
    performanceTrace.enterScope();

    int index = ContextHelper.getIntSafe(request, "hdnLoopCount");
    // don't do setRowIndexOnPagination(request, index) here
    // cost detail doesn't paginate

    CFIN13SO cfin13so = (CFIN13SO) state.getAttribute("CFIN13SO", request);
    request.setAttribute(REQ_FUNC_CD, cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(index).getSzCdScrDataAction());
    request.setAttribute("ROWCFIN13SOG", cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(index));

    String globalPageMode = PageMode.getPageMode(request);
    String pageMode = "";

    if (globalPageMode.equals(PageModeConstants.MODIFY) || globalPageMode.equals(PageModeConstants.NEW)) {
      pageMode = PageModeConstants.MODIFY;
    } else if (globalPageMode.equals(PageModeConstants.VIEW)) {
      pageMode = PageModeConstants.VIEW;
    }

    // Set pageMode from global data into the request, since on Add it is set into the request
    // With a different pageMode than the global page mode
    request.setAttribute(PAGE_MODE, pageMode);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * displayRejection <p/> This method is used to display all of the rejection reasons for a row on the Invoice page. It
   * is accessed by a hyperlink from the list sections.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayRejection_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayRejection_xa()");
    performanceTrace.enterScope();
    try {
      // Cost Reimbursement shows up in more than 1 type and you don't want it
      // to affect the pagination focus
      String szCdRejRsnRejItemId = ContextHelper.getStringSafe(request, "hdnSzCdRejRsnRejItemId");
      if ("CRD".equals(szCdRejRsnRejItemId) == false) {
        int index = ContextHelper.getIntSafe(request, "hdnLoopCount");
        setRowIndexOnPagination(request, index);
      }

      CFIN09SI cfin09si = populateCFIN09S_Retrieve(context);
      // String outputXml = WtcHelper.callService("CFIN09S", cfin09si);
      // CFIN09SO cfin09so = CFIN09SO.unmarshal(new StringReader(outputXml));
      CFIN09SO cfin09so = financials.retrieveRejectionReason(cfin09si);
      request.setAttribute("CFIN09SO", cfin09so);
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.MSG_DATABASE_RETRIEVE_FAIL:
        //this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_DATABASE_RETRIEVE_FAIL, "/financials/invoice/displayRejection",
                        context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * saveInvoice <p/> This method is used to save the Invoice Header information entered on the Invoice page. It first
   * re-calls the validate service for this page to ensure that the information entered still validates, and then if
   * there are no errors on the page it calls CFIN03S for saving.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveInvoice_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    BaseSessionStateManager state = getSessionStateManager(context);
    String cIndCopiedInv =(String) state.getAttribute("cIndCopiedInv",request);
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveInvoice_xa()");
    performanceTrace.enterScope();
    try {
      // First re-call the validate service to make sure the information
      // entered still validates.

      CFIN02SI cfin02si = new CFIN02SI();
      // Set the values for the ArchInputStruct
      cfin02si.setUlIdContract(ContextHelper.getIntSafe(request, "txtUlIdContract"));

      // String outputXml = WtcHelper.callService("CFIN02S", cfin02si);
      // CFIN02SO cfin02so = CFIN02SO.unmarshal(new StringReader(outputXml));
      CFIN02SO cfin02so = financials.findInvoiceHeaderInformation(cfin02si);
      request.setAttribute("CFIN02SO", cfin02so);

      // Set these values so that if we are returned to the page b/c of an error
      // indValidate will allow the user to save w/o re-validating and indError
      // will indicate that there were no errors when the information was validated.
      // indError will be re-set to yes if this validation call returned an error below
      request.setAttribute(IND_ERROR, ArchitectureConstants.N);
      request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);

      // Need to determine if the user is assigned to the returned region, or
      // if he/she has security access to the returned region. If not, display
      // an error message.
      String indContractRegion = validateRegionForContract(cfin02so.getSzCdCntrctRegion(), user, request);

      if (indContractRegion.equals(ArchitectureConstants.N)) {
        setErrorMessage(Messages.SSM_FIN_INVLD_REGION, DISPLAY_INVOICE, request);
        //cfin02so.setSzCdCounty_Array(new SzCdCounty_Array());
      } else {
        CFIN03SI cfin03si = populateCFIN03SI_AU(context);
        // String outputXml2 = WtcHelper.callService("CFIN03S", cfin03si);
        // CFIN03SO cfin03so = CFIN03SO.unmarshal(new StringReader(outputXml2));
        CFIN03SO cfin03so = financials.saveInvoiceHeaderInformation(cfin03si);
        request.setAttribute("CFIN03SO", cfin03so);

        request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);
        GlobalData.setUlIdInvoice(cfin03so.getUlIdInvoInvoice(), request);
        
        request.setAttribute(GRNDS_QNAME_ATTRIBUTE, null);
        
        //-- if emergency payment marked as approved (and paid), update budgets
        if(cfin03si.getBIndEmergencyPayment() &&
           FIN_PHASE_PAID.equals(cfin03si.getSzCdInvoPhase()) &&
           FIN_STAT_APPROVED.equals(cfin03si.getSzCdInvoApproved())) {
          
          //-- !! THIS SERVICE SHOULD ONLY BE CALLED ONCE PER INVOICE !!
          BudgetUpdateSI budgetUpdateSI = populateBudgetUpdateSI(request, cfin03si);
          financials.updateBudgets(budgetUpdateSI);
          
        }
        //STGAP00006777 - Enhancing copy button functionality to display the lineitem list
        //begin
        if(ArchitectureConstants.Y.equals(cIndCopiedInv)){
          CFIN10SO cfin10so = (CFIN10SO) state.getAttribute( "CFIN10SO", request );
          CFIN15SO cfin15so = (CFIN15SO) state.getAttribute( "CFIN15SO", request );
          CFIN06SO cfin06so = (CFIN06SO) state.getAttribute( "CFIN06SO", request );
          String invoType = cfin03si.getSzCdInvoType();
          int idInvoice = cfin03so.getUlIdInvoInvoice();
          if (isFosterCareType(invoType)) {
            saveCopiedFosterCareList(context,cfin10so,cfin03si,idInvoice );
          } else if (isAdminType(invoType)) {
            saveCopiedAdminList(context,cfin15so,cfin03si,idInvoice );
          } else if (isDeliveredServiceOrAdoptionAssistanceType(invoType)) {
            saveCopiedDlvrdOrAdoptServices(context,cfin06so,cfin03si,idInvoice);
          }
        }
        //end
      }
      
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_DATABASE_SAVE_FAIL:
      case Messages.ARC_ERR_BAD_FUNC_CD:
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
      //STGAP00007737: Added the next four messages to catch the validation errors for
      //Person Id, Resource Id, To and From days and the per-diem services.
      case Messages.MSG_FIN_INV_DTL_PERSON:
      case Messages.MSG_FIN_INV_DTL_RESOURCE:
      case Messages.MSG_FIN_INV_DTL_DAYS:
      case Messages.MSG_FIN_INV_DTL_AMT:
        setErrorMessage(errorCode, DISPLAY_INVOICE, context.getRequest());
        break;
      case Messages.MSG_NO_ROWS_RETURNED:
        setErrorMessage(Messages.SSM_FIN_INVLD_CNTRCT_ID, DISPLAY_INVOICE, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;
      case Messages.MSG_DATABASE_RETRIEVE_FAIL:
        setErrorMessage(errorCode, DISPLAY_INVOICE, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * saveFoster <p/> This method is used to save the Foster Care Detail information entered by the user. It first calls
   * the Validate Service for this page to ensure the information entered still validates. It then calls the CFIN11S
   * service for saving the Foster Information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveFoster_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveFoster_xa()");
    performanceTrace.enterScope();
    try {
      // First re-call the validate service to make sure the information
      // entered still validates.
      CFIN08SI cfin08si = populateCFIN08SI_V(context);
      // WtcHelper.callService("CFIN08S", cfin08si);
      financials.retrieveFosterCareDetailValidation(cfin08si);

      // Set these values so that if we are returned to the page b/c of an error
      // indValidate will allow the user to save w/o re-validating and indError
      // will indicate that there were no errors when the information was validated.
      // indError will be re-set to yes if this validation call returned an error below
      request.setAttribute(IND_ERROR, ArchitectureConstants.N);
      request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);
      request.setAttribute(IND_DAY_MISMATCH, ArchitectureConstants.N);
      // Call the service for saving, but unmarshalling is not needed as the output
      // object is not used
      CFIN11SI cfin11si = populateCFIN11SI_AU(context);
      // WtcHelper.callService("CFIN11S", cfin11si);
      financials.saveFosterCareDetail(cfin11si);
      request.setAttribute(GRNDS_QNAME_ATTRIBUTE, null);

    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, DISPLAY_FOSTER, context.getRequest());
        break;
      case Messages.MSG_DUPLICATE_RECORD:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_DUPLICATE_RECORD, DISPLAY_FOSTER, context.getRequest());
        break;
      case Messages.SSM_FIN_INVALID_PRSN_ID:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.SSM_FIN_INVALID_PRSN_ID, DISPLAY_FOSTER, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;
      case Messages.MSG_CLIENT_SMILE:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_CLIENT_SMILE, DISPLAY_FOSTER, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;  
      case Messages.SSM_FIN_INVALID_RSRC_ID:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.SSM_FIN_INVALID_RSRC_ID, DISPLAY_FOSTER, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;
     //STGAP00007737: Added the next four messages to catch the validation errors for
     //Person Id, Resource Id, To and From days and the per-diem services.
      case Messages.MSG_FIN_INV_DTL_DAYS:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(we.getErrorCode(), DISPLAY_FOSTER, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        //IND_DAY_MISMATCH is set to indicate that the error is 
        //in the From and To day fields so that the save button will
        //be displayed.The user can correct the error and resave
        //without having to click the validate button
        request.setAttribute(IND_DAY_MISMATCH, ArchitectureConstants.Y);
        break;
      case Messages.MSG_FIN_INV_DTL_PERSON:
      case Messages.MSG_FIN_INV_DTL_RESOURCE:
      case Messages.MSG_FIN_INV_DTL_AMT:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(we.getErrorCode(), DISPLAY_FOSTER, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * saveAdmin <p/> This method is used to save the Administrative Information entered on the detail page. It calls
   * CFIN16S for saving
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveAdmin_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAdmin_xa()");
    performanceTrace.enterScope();
    try {
      // Call the service for saving, but unmarshalling is not needed as the output
      // object is not used
      CFIN16SI cfin16si = populateCFIN16SI_AU(context);
      // WtcHelper.callService("CFIN16S", cfin16si);
      financials.saveAdminDetail(cfin16si);
      request.setAttribute(GRNDS_QNAME_ATTRIBUTE, null);

    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, "/financials/invoice/displayAdminDetail",
                        context.getRequest());
        break;
      case Messages.MSG_DUPLICATE_RECORD:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_DUPLICATE_RECORD, "/financials/invoice/displayAdminDetail", context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * saveDelivered <p/> This method is used to save the Delivered Service Detail information entered. It first calls the
   * Delivered Service Validate Service to ensure that the information entered still validates. It then calls CFIN07S to
   * save the information.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveDelivered_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveDelivered_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      // First re-call the validate service to make sure the information
      // entered still validates.
      // SIR 17580 GRIMSHAN -- do not call the validate service again if
      // the page is in modify mode
      String cReqFuncCd = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");
      String pageMode = ContextHelper.getStringSafe(request, "hdnPageMode");
      if (!pageMode.equals(PageModeConstants.MODIFY)) {
        CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);
        CFIN29SI cfin29si = populateCFIN29SI_V(context, cReqFuncCd, cfin02so);
        // String outputXml = WtcHelper.callService("CFIN29S", cfin29si);
        // CFIN29SO cfin29so = CFIN29SO.unmarshal(new StringReader(outputXml));
        CFIN29SO cfin29so = financials.retrieveDeliveredServiceValidation(cfin29si);

        // SIR 19897 If the payment type for the service is Cost Reimbursement, and the
        // Invoice header has not been marked as Delivered Service Both or Delivered Service
        // Cost Reimbursement, display a message and do not allow the user to save.
        if ("CRM".equals(cfin29so.getSzCdCnsvcPaymentType())
            && (!"DSB".equals(cfin02so.getSzCdInvoType()) && !"DCR".equals(cfin02so.getSzCdInvoType()))) {
          this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          setErrorMessage(Messages.MSG_NOT_COST, DISPLAY_DELIVERED, context.getRequest());
          request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
          request.setAttribute(IND_VALIDATE, ArchitectureConstants.N);
        }

      }

      // Set these values so that if we are returned to the page b/c of an error
      // indValidate will allow the user to save w/o re-validating and indError
      // will indicate that there were no errors when the information was validated.
      // indError will be re-set to yes if this validation call returned an error below
      request.setAttribute(IND_ERROR, ArchitectureConstants.N);
      request.setAttribute(IND_VALIDATE, ArchitectureConstants.Y);

      // Call the service for saving, but unmarshalling is not needed as the output
      // object is not used
      CFIN07SI cfin07si = populateCFIN07SI_AU(context);
      // WtcHelper.callService("CFIN07S", cfin07si);
      financials.saveDelvrdSvcDtl(cfin07si);

      request.setAttribute(GRNDS_QNAME_ATTRIBUTE, null);

    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_ARC_CONSTR_MONTH:
      case Messages.MSG_ARC_CONSTR_YEAR:
      case Messages.MSG_FIN_DSD_EXISTS:
      case Messages.MSG_CLIENT_SMILE:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.SSM_FIN_NO_SVC_AUTH_DTL:
      case Messages.SSM_FIN_NO_UNIT_RATE:
      //STGAP00007737: Added the next message to catch the validation error for
      //Person Id.
      case Messages.MSG_FIN_INV_DTL_PERSON:
      case Messages.SSM_FIN_INVALID_PRSN_ID:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, DISPLAY_DELIVERED, context.getRequest());
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * saveCost <p/> This method is used to save the Cost Reimbursement information entered. It calls CFIN14S for saving.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveCost_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveCost_xa()");
    performanceTrace.enterScope();
    try {
      // Call the service for saving, but unmarshalling is not needed as the output
      // object is not used
      CFIN14SI cfin14si = populateCFIN14SI_AU(context);
      // WtcHelper.callService("CFIN14S", cfin14si);
      financials.saveCostReimbursementDetail(cfin14si);
      request.setAttribute(GRNDS_QNAME_ATTRIBUTE, null);

    } catch (ServiceException we) {

      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, "/financials/invoice/displayCostDetail",
                        context.getRequest());
        break;
      case Messages.MSG_DUPLICATE_RECORD:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_DUPLICATE_RECORD, "/financials/invoice/displayCostDetail", context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * addFosterDetail <p/> This method is called when the user clicks on the add pushbutton beneath the Foster Care List.
   * It retrieves the foster output object from state so it can generate the Services to be displayed in the Service
   * Dropdown on the Foster Care Detail page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addFosterDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addFosterDetail_xa()");
    performanceTrace.enterScope();

    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);

    CFIN10SO cfin10so = (CFIN10SO) state.getAttribute("CFIN10SO", request);

    // Exclude Views excludes things to display in the Service Drop down. It is initialized
    // to all items in the codes table.
    // The Remove loop removes items from the exclude views (thus they will be displayed)
    // If a code exists in the service return that is not in the codestable, display a message
    
    ROWCFIN10SOG01_ARRAY contractServiceCodes = cfin10so.getROWCFIN10SOG01_ARRAY();
    setFosterCareServiceOptions(request, contractServiceCodes);
    //STGAP00007737: Added the if block to check if there are any pre-existing
    //Foster care line items on the invoice and if there are then extract the 
    //person id and resource id  from one of them and set them in the request
     if(cfin10so!=null && cfin10so.getROWCFIN10SOG00_ARRAY()!=null){
      ROWCFIN10SOG00_ARRAY fosterArray = cfin10so.getROWCFIN10SOG00_ARRAY();
      Enumeration fosterEnumeration = fosterArray.enumerateROWCFIN10SOG00();
      if (fosterEnumeration.hasMoreElements()) {
        ROWCFIN10SOG00 rowcfin10sog00 = (ROWCFIN10SOG00) fosterEnumeration.nextElement();
        int idPerson = rowcfin10sog00.getUlIdPerson();
        int idResource = rowcfin10sog00.getUlIdResource();
        request.setAttribute("idPerson",idPerson);
        request.setAttribute("idResource", idResource);
      }
    }
    // Set pageMode so that the global data page mode will not have to be over written
    request.setAttribute(PAGE_MODE, PageModeConstants.NEW);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * addAdminDetail <p/> This method is called when the user clicks the add pushbutton beneath the administrative list
   * on the Invoice page. It sets a page mode for the Admin Detail page, and generates display for the Service Dropdown
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addAdminDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addAdminDetail_xa()");
    performanceTrace.enterScope();
    
    //-- the following method includes a service call to retrieveContractCounties
    //-- and returns false if exception was caught and handled by processSevereException
    if(!setCountyServiceMap(context)) {
      return;
    }

    HttpServletRequest request = context.getRequest();
    //BaseSessionStateManager state = getSessionStateManager(context);
    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);

    // Set pageMode so that the global data page mode will not have to be over written
    request.setAttribute(PAGE_MODE, PageModeConstants.NEW);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * addDeliveredDetail <p/> This method is called when the user clicks
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addDeliveredDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addDeliveredDetail_xa()");
    performanceTrace.enterScope();

    // -- the following method includes a service call to retrieveContractCounties
    // -- and returns false if exception was caught and handled by processSevereException
    if (!setCountyServiceMap(context)) {
      return;
    }
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);
    CFIN06SO cfin06so = (CFIN06SO) state.getAttribute("CFIN06SO", request);
    //STGAP00007737: Added the if block to check if there are any pre-existing
    //Delivered Service line items on the invoice and if there are then extract the 
    //person id from one of them and set it in the request
    if (cfin06so!=null && cfin06so.getROWCFIN06SOG_ARRAY() != null) {
      ROWCFIN06SOG_ARRAY delArray = cfin06so.getROWCFIN06SOG_ARRAY();
      Enumeration delEnumeration = delArray.enumerateROWCFIN06SOG();
      if (delEnumeration.hasMoreElements()) {
        int idPerson = ((ROWCFIN06SOG) delEnumeration.nextElement()).getUlIdPerson();
        request.setAttribute("idPerson", idPerson);
      }
    }
    // Set pageMode so that the global data page mode will not have to be over written
    request.setAttribute(PAGE_MODE, PageModeConstants.NEW);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }
  
  //STGAP00007737: Added this method to accomodate the deletion of line Items on an Invoice page.
  public void deleteLineItem_xa(GrndsExchangeContext context){
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addDeliveredDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String lineItemType = ContextHelper.getStringSafe(request, "hdnDeleteType");
    String invoType = ContextHelper.getStringSafe(request, "hdnInvoType");
    int idLineItem = 0;
    int index = ContextHelper.getIntSafe(request, "rbRowsIndex_CLEAN");
    if(FOSTER_CARE.equals(lineItemType)){
      CFIN10SO cfin10so = (CFIN10SO) state.getAttribute("CFIN10SO", request);
      ROWCFIN10SOG00_ARRAY fosterArray = cfin10so.getROWCFIN10SOG00_ARRAY();
      ROWCFIN10SOG00 fosterRow = fosterArray.getROWCFIN10SOG00(index);
      idLineItem = fosterRow.getUlIdSvcDtl();
     }else if(DELIVERED_SERVICE.equals(lineItemType)){
       CFIN06SO cfin06so = (CFIN06SO) state.getAttribute( "CFIN06SO", request );
       ROWCFIN06SOG_ARRAY delArray = cfin06so.getROWCFIN06SOG_ARRAY();
       ROWCFIN06SOG delRow = delArray.getROWCFIN06SOG(index);
       idLineItem = delRow.getUlIdSvcDtl();
     }
    if(idLineItem!=0){
      financials.deleteInvoiceLineItem(idLineItem,invoType);
    }
    //Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
 }
  private double calculateFosterCareTotal(ROWCFIN10SOG00[] array) {
    double total = 0.0;
    if(array == null || array.length < 1) {
      return total;
    }
    for(ROWCFIN10SOG00 row : array) {
      double rowTotal = calculateFosterCareLineItemTotal(row);
      total += rowTotal;
    }
    return total;
  }
  
  private double calculateAdminTotal(ROWCFIN15SOG00[] array) {
    double total = 0.0;
    if(array == null || array.length < 1) {
      return total;
    }
    for(ROWCFIN15SOG00 row : array) {
      double rowTotal = calculateAdminLineItemTotal(row);
      total += rowTotal;
    }
    return total;
  }
  
  private double calculateDeliveredServiceTotal(ROWCFIN06SOG[] array) {
    double total = 0.0;
    if(array == null || array.length < 1) {
      return total;
    }
    for(ROWCFIN06SOG row : array) {
      double rowTotal = calculateDelSvcAdoAsstLineItemTotal(row);
      total += rowTotal;
    }
    return total;
  }
  
  //-- had to fix FormattingHelper.convertRegionCode() to account for the values '3A' and '3B' so
  //-- as not to cause a NumberFormatException when calling Integer.parseInt()
  private String validateRegionForContract(String region, UserProfile user, HttpServletRequest request) throws DataFormatException{
    String indContractRegion = ArchitectureConstants.Y;
    if(region != null && region.length() > 0 && region.length() < 4) {
      if (!FormattingHelper.convertRegionCode(user.getUserRegion()).equals(region)) {
        request.setAttribute(IND_ERROR, ArchitectureConstants.Y);
        indContractRegion = ArchitectureConstants.N;
        List<String> userRegions = user.getUserMaintainedRegions();
        for (Iterator<String> it=userRegions.iterator(); it.hasNext();) {
          if (FormattingHelper.convertRegionCode(it.next()).equals(FormattingHelper.convertRegionCode(region))) {
            request.setAttribute(IND_ERROR, ArchitectureConstants.N);
            indContractRegion = ArchitectureConstants.Y;
            break;
          }
        }
      }
    }
    return indContractRegion;
  }

  /**
   * populateCFIN02S This method is used to populate the input objectfor Validating Invoice information as well as
   * retrieving Invoice header Information for displaying the invoice page. If the calling method was the display method
   * it retrieves the Invoice Header information If the calling method was any other method, it validates the contract
   * ID passed.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param callingMethod
   *          Tells the populate Method what information to populate
   * @return cfin02si
   */
  private CFIN02SI populateCFIN02S_Retrieve(GrndsExchangeContext context, String callingMethod) {
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    ArchInputStruct input = new ArchInputStruct();
    CFIN02SI cfin02si = new CFIN02SI();

    input.setSzUserId(user.getUserLogonID());

    // If the calling method is the display invoice method set the Invoice ID
    // otherwise (ADD or Validate) set the contract id into the input structure
    if ("DISPLAY".equals(callingMethod)) {
      cfin02si.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));
    } else {
      // SIR 17295 check the field first, and then if it is still null, check
      // global data
      // Get Contract from global data, if it is available, otherwise get it from
      // the field
      if (GlobalData.getUlIdContract(request) != 0) {
        cfin02si.setUlIdContract(GlobalData.getUlIdContract(request));

      } else {
        cfin02si.setUlIdContract(ContextHelper.getIntSafe(request, "txtUlIdContract"));
      }
    }
    cfin02si.setArchInputStruct(input);

    return cfin02si;
  }

  /**
   * populateCFIN10S <p/> This method is used to populate the CFIN10SI object for retrieving Foster Care information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param tuxPagination
   *          The pagination bean
   * @return cfin10si
   */
  private CFIN10SI populateCFIN10S_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) {
    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    CFIN10SI cfin10si = new CFIN10SI();
    //String sortOrder = SORT_NAME;

    tuxPagination.getResultDetails().setResultsPerPage(ADMIN_OR_FOSTER_CARE_MAX_RESULTS);
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(REQ_FUNC_CD_DTLS_CDS);

    cfin10si.setArchInputStruct(input);
    cfin10si.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));
    cfin10si.setUlIdContract(GlobalData.getUlIdContract(request));
    cfin10si.setSzCdCounty(GlobalData.getSzCdCounty(request));
    
    //-- get sorting params, set into input object, set into tuxPagination
    String orderBy = ContextHelper.getStringSafe(context, "orderBy");
    String sortDir = ContextHelper.getStringSafe(context, "orderByDirection");
    cfin10si.setSzOrderBy(orderBy);
    cfin10si.setSzSortDir(sortDir);
    tuxPagination.getResultDetails().setOrderBy(orderBy);
    tuxPagination.getResultDetails().setOrderByDirection(sortDir);

    return cfin10si;
  }

  /**
   * populateCFIN15S <p/> This method is used to populate the CFIN15SI object for retrieving Admin information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param tuxPagination
   *          The pagination bean
   * @return cfin15si
   */
  private CFIN15SI populateCFIN15S_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) {
    HttpServletRequest request = context.getRequest();

    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    CFIN15SI cfin15si = new CFIN15SI();

    tuxPagination.getResultDetails().setResultsPerPage(ADMIN_OR_FOSTER_CARE_MAX_RESULTS);
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    input.setCReqFuncCd(REQ_FUNC_CD_DTLS_CDS);
    input.setSzUserId(user.getUserLogonID());

    cfin15si.setArchInputStruct(input);
    cfin15si.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));
    cfin15si.setUlIdContract(GlobalData.getUlIdContract(request));
    cfin15si.setSzCdCounty(GlobalData.getSzCdCounty(request));

    return cfin15si;
  }

  /**
   * populateCFIN06S <p/> This method is used to populate the CFIN06SI object for retrieving Delivered Service
   * information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param tuxPagination
   *          The pagination bean
   * @return cfin06si
   */
  private CFIN06SI populateCFIN06S_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) {
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    //String sortOrder = "";

    ArchInputStruct input = new ArchInputStruct();
    CFIN06SI cfin06si = new CFIN06SI();

    // Set Pagination Info
    tuxPagination.getResultDetails().setResultsPerPage(ADOPTION_OR_DELVD_SVC_MAX_RESULTS);
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setSzUserId(user.getUserLogonID());

    // SIR 23475 - START
    input.setCReqFuncCd(REQ_FUNC_CD_FIRST_TIME);
    // SIR 23475 - END

    cfin06si.setArchInputStruct(input);
    cfin06si.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));
    cfin06si.setUlIdContract(GlobalData.getUlIdContract(request));
    cfin06si.setSzCdCounty(GlobalData.getSzCdCounty(request));
    
    //-- get sorting params, set into input object, set into tuxPagination
    String orderBy = ContextHelper.getStringSafe(context, "orderBy");
    String sortDir = ContextHelper.getStringSafe(context, "orderByDirection");
    cfin06si.setSzOrderBy(orderBy);
    cfin06si.setSzSortDir(sortDir);
    tuxPagination.getResultDetails().setOrderBy(orderBy);
    tuxPagination.getResultDetails().setOrderByDirection(sortDir);

    return cfin06si;
  }

  /**
   * populateCFIN09S <p/> This method is used to populate the CFIN09SI object for retrieving Rejection information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return cfin09si
   */
  private CFIN09SI populateCFIN09S_Retrieve(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();
    CFIN09SI cfin09si = new CFIN09SI();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    int rejectionID = ContextHelper.getIntSafe(request, "hdnRejectionID");
    String szCdRejRsnRejItemId = ContextHelper.getStringSafe(request, "hdnSzCdRejRsnRejItemId");

    input.setUlPageSizeNbr(100);
    input.setUsPageNbr(ONE);
    input.setSzUserId(user.getUserLogonID());
    cfin09si.setUlIdRejectedItemId(rejectionID);
    cfin09si.setSzCdRejRsnRejItemId(szCdRejRsnRejItemId);
    cfin09si.setArchInputStruct(input);

    return cfin09si;
  }

  /**
   * populateCFIN03S <p/> This method is used to populate the CFIN03SI object for saving Invoice information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return cfin03si
   */
  private CFIN03SI populateCFIN03SI_AU(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Allocate the structures
    CFIN03SI cfin03si = new CFIN03SI();
    ArchInputStruct input = new ArchInputStruct();
    Date date = new Date();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    // SIR 19137 user get checkbox value instead of string safe so N will be saved to the db
    //String cbxCIndInvoReadyForValid = CheckboxHelper.getCheckboxValue(request, "cbxCIndInvoReadyForValid");
    
    //-- this value should be either "Y" or "N"
    String cbxCIndInvoReadyForValid = ContextHelper.getStringSafe(request, "hdnReadyForValidation");
    //String cbxSzCdInvoAdjustmentRb = CheckboxHelper.getCheckboxValue(request, "cbxSzCdInvoAdjustmentRb");

    // Set the values for the ArchInputStruct
    String cReqFuncCd = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");
    input.setCReqFuncCd(cReqFuncCd);
    input.setSzUserId(user.getUserLogonID());
    //-- type used below
    String invoType = ContextHelper.getStringSafe(request, "selSzCdInvoType");
    //STGAP00007737: Added the if condition to check if the From day and To day values match
    //across all line items
    if (ArchitectureConstants.Y.equals(cbxCIndInvoReadyForValid) && isFosterCareType(invoType)) {
      CFIN10SO cfin10so = (CFIN10SO) state.getAttribute("CFIN10SO", request);
      if (cfin10so != null && cfin10so.getROWCFIN10SOG00_ARRAY() != null) {
        ROWCFIN10SOG00_ARRAY fosterArray = cfin10so.getROWCFIN10SOG00_ARRAY();
        Enumeration fosterEnumeration = fosterArray.enumerateROWCFIN10SOG00();
        ROWCFIN10SOG00 fosterRow = null;
        int toDay = -1;
        int fromDay = -1;
        while (fosterEnumeration.hasMoreElements()) {
          fosterRow = (ROWCFIN10SOG00) fosterEnumeration.nextElement();
          //STGAP00009501:Added the if check to see if the unit type is Day or Day 24 in which 
          //case the for day and today will be 0.
          if ((fosterRow.getSNbrSvcDtlFromDay() != 0 && fosterRow.getSNbrSvcDtlToDay() != 0)) {
            if ((toDay != -1 && fosterRow.getSNbrSvcDtlToDay() != toDay)
                || (fromDay != -1 && fosterRow.getSNbrSvcDtlFromDay() != fromDay)) {
              setErrorMessage(Messages.MSG_FIN_INV_DTL_DAYS, DISPLAY_INVOICE, request);
              break;
            }
            toDay = fosterRow.getSNbrSvcDtlToDay();
            fromDay = fosterRow.getSNbrSvcDtlFromDay();
          }
        }
      }
    }
    
    cfin03si.setSzCdInvoType(invoType);
    cfin03si.setSzCdInvoPhase(FIN_PHASE_PENDING);
    cfin03si.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));
    cfin03si.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate")));
    cfin03si.setDAmtInvoClaimedAmount(ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtInvoClaimedAmount"));
    cfin03si.setDtDtInvoReceivedDate(DateHelper.toCastorDateSafe(
      ContextHelper.getStringSafe(request,"txtDtDtInvoReceivedDate")));
    cfin03si.setUlIdContract(ContextHelper.getIntSafe(request, "txtUlIdContract"));
    cfin03si.setUMoInvoMonth(ContextHelper.getIntSafe(request, "txtUMoInvoMonth"));
    cfin03si.setUYrInvoYear(ContextHelper.getIntSafe(request, "txtUYrInvoYear"));
    cfin03si.setSzNbrInvoVid(ContextHelper.getStringSafe(request, "dspSzNbrInvoVid"));
    cfin03si.setCIndInvoReadyForValid(cbxCIndInvoReadyForValid);
    cfin03si.setSzCdCounty(ContextHelper.getStringSafe(request, "selCounty"));
    cfin03si.setSzCdRegion(ContextHelper.getStringSafe(request, "dspSzCdCntrctRegion"));
    cfin03si.setSzCdInvoAdjustmentRb(ContextHelper.getStringSafe(request, "cbxSzCdInvoAdjustmentRb"));
    
    //STGAP00013273: Set the provider invoice number
    cfin03si.setSzNbrInvProvider(ContextHelper.getStringSafe(request, "szNbrInvProvider"));

    //if (cbxSzCdInvoAdjustmentRb.equals(ArchitectureConstants.Y)) {
    //  cfin03si.setSzCdInvoAdjustmentRb("I");
    //} else {
    //  cfin03si.setSzCdInvoAdjustmentRb(ArchitectureConstants.N);
    //}

    // SIR 19137: Impact should not set the indicator to Y, this should always be done by user.
    // if( ( ContextHelper.getStringSafe( request, "hdnDtDtInvoEntryCompleted" ) != null ) &&
    // cbxCIndInvoReadyForValid.equals( ArchitectureConstants.N ) )
    // {
    // cfin03si.setCIndInvoReadyForValid( ArchitectureConstants.Y );
    // }

    // SIR 22520, RIOSJA - Added the line above the if statement to ensure that
    // DtDtInvoEntryCompleted is never null once it is populated the first time.
    cfin03si.setDtDtInvoEntryCompleted(ContextHelper.getCastorDateSafe(request, "hdnDtDtInvoEntryCompleted"));
    if ("".equals(ContextHelper.getStringSafe(request, "hdnDtDtInvoEntryCompleted"))
        && cbxCIndInvoReadyForValid.equals(ArchitectureConstants.Y)) {
      cfin03si.setDtDtInvoEntryCompleted(DateHelper.toCastorDate(date));
    }

    // SIR 22520, RIOSJA - Updated the first condition in this if statement to
    // key off of "hdnDtDtInvoEntryStarted" instead of "hdnDtDtInvoEntryCompleted".
    // Also added the line above the if statement to ensure that
    // DtDtInvoEntryStarted is always populated.
    cfin03si.setDtDtInvoEntryStarted(ContextHelper.getCastorDateSafe(request, "hdnDtDtInvoEntryStarted"));
    if ("".equals(ContextHelper.getStringSafe(request, "hdnDtDtInvoEntryStarted"))
        || PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
      cfin03si.setDtDtInvoEntryStarted(DateHelper.toCastorDate(date));
    }
    
    //-- determine if type is emergency payment
    boolean isEmergencyType = isEmergencyType(invoType);
    cfin03si.setBIndEmergencyPayment(isEmergencyType);
    if(isEmergencyType) {
      cfin03si.setDtDtInvoSubmitDate(ContextHelper.getCastorDateSafe(request, "dspDtDtInvoSubmitDate"));
      cfin03si.setDtDtInvoWarrantDate(ContextHelper.getCastorDateSafe(request, "dspDtDtInvoWarrantDate"));
      cfin03si.setSzNbrInvoWarrant(ContextHelper.getStringSafe(request, "dspSzNbrInvoWarrant"));
      cfin03si.setSzTxtInvoContact(ContextHelper.getStringSafe(request, "dspContact"));
      cfin03si.setDAmtInvoValidAmount(ContextHelper.getMoneyAsDoubleSafe(request, "dspDAmtInvoValidAmount"));
      cfin03si.setDAmtInvoWarrant(ContextHelper.getMoneyAsDoubleSafe(request, "dspDAmtInvoWarrant"));
      cfin03si.setUlIdPerson(user.getUserID());
      
      String cdApproved = ContextHelper.getStringSafe(request, "dspSzCdInvoApproved");
      if(FIN_STAT_APPROVED.equals(cdApproved)) {
        cfin03si.setSzCdInvoPhase(FIN_PHASE_PAID);
        cfin03si.setDtDtInvoApprovalDate(DateHelper.toCastorDate(date));
        cfin03si.setDtDtInvoEntryCompleted(DateHelper.toCastorDate(date));
      } else {
        cfin03si.setSzCdInvoPhase(CodesTables.CINVPHSE_PRB);
      }
      cfin03si.setSzCdInvoApproved(cdApproved);
    }

    cfin03si.setArchInputStruct(input);
    return cfin03si;
  }

  /**
   * populateCFIN11S <p/> This method is used to populate the CFIN11SI object for saving Foster Care information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return cfin11si
   */
  private CFIN11SI populateCFIN11SI_AU(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Allocate the structures
    CFIN11SI cfin11si = new CFIN11SI();
    ROWCFIN11SIG00_ARRAY rowcfin11sig00_array = new ROWCFIN11SIG00_ARRAY();
    ROWCFIN11SIG00 rowcfin11sig00 = new ROWCFIN11SIG00();
    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    // SIR 17477 GRIMSHAN -- get this value out using get checkbox value instead
    // of get String safe
    String indReversal = CheckboxHelper.getCheckboxValue(request, "cbxReversal");
    
    //-- get unit type first
    int fromDay = ContextHelper.getIntSafe(request, "txtSNbrSvcDtlFromDay");
    int toDay = ContextHelper.getIntSafe(request, "txtSNbrSvcDtlToDay");
    double unitQty = ContextHelper.getDoubleSafe(request, "hdnSNbrSvcDtlUnitQty");

    CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);

    input.setCReqFuncCd(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    input.setUlPageSizeNbr(ONE);
    input.setSzUserId(user.getUserLogonID());

    cfin11si.setUlIdContract(GlobalData.getUlIdContract(request));
    cfin11si.setTsSysTsLastUpdate2(cfin02so.getTsLastUpdate());
    cfin11si.setSzCdInvoPhase(cfin02so.getSzCdInvoPhase());
    cfin11si.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));

    rowcfin11sig00.setSzCdSvcDtlService(ContextHelper.getStringSafe(request, "selSzCdSvcDtlService"));
    
    //-- get unit type from selected service --------
    //rowcfin11sig00.setSzCdSvcDtlUnitType(FIN_CD_DAY);
    rowcfin11sig00.setSzCdSvcDtlUnitType(ContextHelper.getStringSafe(request, "hdnCdUnitType"));
    //-----------------------------------------------
    
    rowcfin11sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate")));
    rowcfin11sig00.setDAmtSvcDtlIncome(ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtSvcDtlIncome"));
    rowcfin11sig00.setDAmtSvcDtlUnitRate(ContextHelper.getDoubleSafe(request, "txtDAmtSvcDtlUnitRate"));
    rowcfin11sig00.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));
    rowcfin11sig00.setUlIdPerson(ContextHelper.getIntSafe(request, "txtUlIdPerson"));
    rowcfin11sig00.setUlIdResource(ContextHelper.getIntSafe(request, "txtUlIdResource"));
    rowcfin11sig00.setUlIdSvcDtl(ContextHelper.getIntSafe(request, "hdnUlIdSvcDtl"));
    rowcfin11sig00.setCIndSvcDtlRejItem(ContextHelper.getStringSafe(request, "hdnCIndSvcDtlRejItem"));
    rowcfin11sig00.setUMoSvcDtlSvcMonth(ContextHelper.getIntSafe(request, "txtUMoSvcDtlSvcMonth"));
    if(fromDay > 0) {
      rowcfin11sig00.setSNbrSvcDtlFromDay(fromDay);
    }
    if(toDay > 0) {
      rowcfin11sig00.setSNbrSvcDtlToDay(toDay);
    }
    rowcfin11sig00.setUYrSvcDtlServiceYear(ContextHelper.getIntSafe(request, "txtUYrSvcDtlServiceYear"));
    rowcfin11sig00.setSzCdScrDataAction(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    rowcfin11sig00.setLNbrRsrcFacilAcclaim(ContextHelper.getIntSafe(request, "dspLNbrRsrcFacilAcclaim"));

    /*-- this logic done via javascript on JSP
    if (toDay == 0 && fromDay == 0) {
      unitQty = 0;
    } else {
      unitQty = (toDay - fromDay) + 1;
    }
    */
    if (ArchitectureConstants.Y.equals(indReversal)) {
      unitQty *= -1;
    }

    rowcfin11sig00.setSNbrSvcDtlUnitQty(unitQty);

    if (CodesTables.CINVADJT_N.equals(cfin02so.getSzCdInvoAdjustmentRb())) {
      rowcfin11sig00.setSzCdSvcDtlLiType(ORIGINAL_LI);
    } else {
      if (ArchitectureConstants.N.equals(indReversal)) {
        rowcfin11sig00.setSzCdSvcDtlLiType(ADJUSTMENT_LI);
      } else {
        rowcfin11sig00.setSzCdSvcDtlLiType(REVERSAL_LI);
      }
    }

    cfin11si.setArchInputStruct(input);

    // Add the struct to the array
    rowcfin11sig00_array.addROWCFIN11SIG00(rowcfin11sig00);
    // Set the array into the parent struct
    cfin11si.setROWCFIN11SIG00_ARRAY(rowcfin11sig00_array);

    return cfin11si;

  }

  /**
   * populateCFIN07S <p/> This method is used to populate the CFIN07SI object for saving Administrative information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return cfin07si
   */
  private CFIN07SI populateCFIN07SI_AU(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Allocate the structures
    CFIN07SI cfin07si = new CFIN07SI();
    ROWCFIN07SIG_ARRAY rowcfin07sig_array = new ROWCFIN07SIG_ARRAY();
    ROWCFIN07SIG rowcfin07sig = new ROWCFIN07SIG();
    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    String reqFuncCd = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");

    double qty = ContextHelper.getDoubleSafe(request, "txtSNbrSvcDtlUnitQty");
    String szCdSvcDtlService = ContextHelper.getStringSafe(request, "selSzCdSvcDtlService");
    int ulIdSvcDtl = ContextHelper.getIntSafe(request, "hdnUlIdSvcDtl");

    // SIR 17580 GRIMSHAN -- If the reqfunccd is add, set ulIdSvcDtl to 0, so that if
    // we are doing a new using, the ID will not be sent to the service
    if (reqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
      ulIdSvcDtl = 0;
    }

    String szCdCnsvcPaymentType = ContextHelper.getStringSafe(request, "hdnSzCdCnsvcPaymentType");

    CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(reqFuncCd);
    input.setUlPageSizeNbr(ONE);
    input.setSzUserId(user.getUserLogonID());

    cfin07si.setUlIdContract(GlobalData.getUlIdContract(request));
    cfin07si.setTsSysTsLastUpdate2(cfin02so.getTsLastUpdate());
    cfin07si.setSzCdInvoPhase(cfin02so.getSzCdInvoPhase());
    cfin07si.setSzCdCnsvcPaymentType(ContextHelper.getStringSafe(request, "hdnSzCdCnsvcPaymentType"));
    cfin07si.setSzCdInvoType(cfin02so.getSzCdInvoType());
    rowcfin07sig.setSzCdSvcDtlCounty(ContextHelper.getStringSafe(request, "selSzCdSvcDtlCounty"));
    rowcfin07sig.setSzCdSvcDtlService(szCdSvcDtlService);
    rowcfin07sig.setSzCdSvcDtlUnitType(ContextHelper.getStringSafe(request, "selSzCdSvcDtlUnitType"));
    rowcfin07sig.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate")));
    rowcfin07sig.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));
    rowcfin07sig.setCIndSvcDtlRejItem(ContextHelper.getStringSafe(request, "hdnCIndSvcDtlRejItem"));
    rowcfin07sig.setDAmtSvcDtlFeePaid(ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtSvcDtlFeePaid"));
    rowcfin07sig.setUlIdPerson(ContextHelper.getIntSafe(request, "txtUlIdPerson"));
    rowcfin07sig.setUlIdSvcDtl(ulIdSvcDtl);
    rowcfin07sig.setUlIdSvcAuthDtl(ContextHelper.getIntSafe(request, "hdnUlIdSvcAuthDtl"));
    rowcfin07sig.setUMoSvcDtlSvcMonth(ContextHelper.getIntSafe(request, "txtUMoSvcDtlSvcMonth"));
    rowcfin07sig.setUYrSvcDtlServiceYear(ContextHelper.getIntSafe(request, "txtUYrSvcDtlServiceYear"));
    rowcfin07sig.setUsNbrSvcDtlCsli(ContextHelper.getIntSafe(request, "dspUsNbrSvcDtlCsli"));
    rowcfin07sig.setSNbrSvcDtlUnitQty(qty);
    rowcfin07sig.setSzCdSysDataActionOutcome(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));

    if (CodesTables.CINVADJT_N.equals(cfin02so.getSzCdInvoAdjustmentRb())) {
      rowcfin07sig.setSzCdSvcDtlLiType(ORIGINAL_LI);
    } else {
      if (qty < 0.0) {
        rowcfin07sig.setSzCdSvcDtlLiType(REVERSAL_LI);
      } else {
        rowcfin07sig.setSzCdSvcDtlLiType(ADJUSTMENT_LI);
      }
    }

    // SIR 19795 if the type is CRM set the unit rate to 0.0 when saving the page.
    if (szCdCnsvcPaymentType != null && "CRM".equals(szCdCnsvcPaymentType)) {
      rowcfin07sig.setDAmtSvcDtlUnitRate(0.00);
    } else {
      rowcfin07sig.setDAmtSvcDtlUnitRate(ContextHelper.getDoubleSafe(request, "txtDAmtSvcDtlUnitRate"));
    }

    cfin07si.setArchInputStruct(input);

    // Add the struct to the array
    rowcfin07sig_array.addROWCFIN07SIG(rowcfin07sig);
    // Set the array into the parent struct
    cfin07si.setROWCFIN07SIG_ARRAY(rowcfin07sig_array);

    return cfin07si;

  }

  /**
   * populateCFIN14S <p/> This method is used to populate the CFIN14SI object for saving Cost Reimbursement information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return cfin14si
   */
  private CFIN14SI populateCFIN14SI_AU(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Allocate the structures
    CFIN14SI cfin14si = new CFIN14SI();
    ROWCFIN14SIG_ARRAY rowcfin14sig_array = new ROWCFIN14SIG_ARRAY();
    ROWCFIN14SIG rowcfin14sig = new ROWCFIN14SIG();
    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    double unitRate = 0.0;

    CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    input.setUlPageSizeNbr(ONE);
    input.setSzUserId(user.getUserLogonID());

    cfin14si.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));
    cfin14si.setTsSysTsLastUpdate2(cfin02so.getTsLastUpdate());
    cfin14si.setSzCdInvoPhase(cfin02so.getSzCdInvoPhase());

    double salary = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimSalary");
    double frgBenft = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimFrgBenft");
    double travel = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimTravel");
    double supply = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimSupply");
    double equip = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimEquip");
    double other = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimDtlOther");
    double adminAll = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimAdminAll");
    double offset = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtCostReimOffItem");

    double qty = ContextHelper.getDoubleSafe(request, "dspUNbrCostReimUnitQty");

    rowcfin14sig.setSzCdCostReimService(ContextHelper.getStringSafe(request, "dspSzCdCostReimService"));
    rowcfin14sig.setSzCdCostReimLiType(ContextHelper.getStringSafe(request, "hdnSzCdCostReimLiType"));
    rowcfin14sig.setUsNbrCostReimCsli(ContextHelper.getIntSafe(request, "dspUsNbrCostReimCsli"));
    rowcfin14sig.setUNbrCostReimUnitQty(qty);
    rowcfin14sig.setDAmtCostReimSalary(salary);
    rowcfin14sig.setDAmtCostReimFrgBenft(frgBenft);
    rowcfin14sig.setDAmtCostReimTravel(travel);
    rowcfin14sig.setDAmtCostReimSupply(supply);
    rowcfin14sig.setDAmtCostReimEquip(equip);
    rowcfin14sig.setDAmtCostReimDtlOther(other);
    rowcfin14sig.setDAmtCostReimAdminAll(adminAll);
    rowcfin14sig.setDAmtCostReimOffItem(offset);
    rowcfin14sig.setUlIdCostReim(ContextHelper.getIntSafe(request, "hdnUlIdCostReim"));

    // SIR 17870 GRIMSHAN -- Calculate the unit rate if the quantity is not 0
    if (qty != 0) {
      unitRate = (salary + frgBenft + travel + supply + equip + other + adminAll + offset) / qty;
    } else {
      unitRate = 0.0;
    }

    rowcfin14sig.setDScrAmtCostReimCmpUrt(unitRate);
    rowcfin14sig.setSzCdScrDataAction(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    rowcfin14sig.setCIndCostReimRejItm(ContextHelper.getStringSafe(request, "hdnCIndCostReimRejItm"));
    rowcfin14sig.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate")));

    cfin14si.setArchInputStruct(input);

    // Add the struct to the array
    rowcfin14sig_array.addROWCFIN14SIG(rowcfin14sig);
    // Set the array into the parent struct
    cfin14si.setROWCFIN14SIG_ARRAY(rowcfin14sig_array);

    return cfin14si;

  }

  /**
   * populateCFIN16S <p/> This method is used to populate the CFIN16SI object for saving Administrative information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return cfin16si
   */
  private CFIN16SI populateCFIN16SI_AU(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    // Allocate the structures
    CFIN16SI cfin16si = new CFIN16SI();
    ROWCFIN16SIG00_ARRAY rowcfin16sig00_array = new ROWCFIN16SIG00_ARRAY();
    ROWCFIN16SIG00 rowcfin16sig00 = new ROWCFIN16SIG00();
    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);

    double dAmtAdminDtlSalaries = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlSalaries");
    double dAmtAdminDtlFrgBenft = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlFrgBenft");
    double dAmtAdminDtlTravel = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlTravel");
    double dAmtAdminDtlSupplies = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlSupplies");
    double dAmtAdminDtlEquipment = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlEquipment");
    double dAmtAdminDtlOther = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlOther");
    double dAmtAdminDtlAdminAlloc = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlAdminAlloc");
    double dAmtAdminDtlOffsetItem = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminDtlOffsetItem");

    double dAmtAdminDtlPromotional = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtAdminPromotional");
    String txtComments = ContextHelper.getStringSafe(request, "txtComments");
    String cdCounty = ContextHelper.getStringSafe(request, "selSzCdCounty");

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));
    input.setUlPageSizeNbr(ONE);
    input.setSzUserId(user.getUserLogonID());

    cfin16si.setUlIdContract(GlobalData.getUlIdContract(request));
    cfin16si.setTsSysTsLastUpdate2(cfin02so.getTsLastUpdate());
    cfin16si.setSzCdInvoPhase(cfin02so.getSzCdInvoPhase());
    cfin16si.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));

    rowcfin16sig00.setSzCdAdminDtlInvoDisptn(ContextHelper.getStringSafe(request, "hdnSzCdAdminDtlInvoDisptn"));
    rowcfin16sig00.setSzCdAdminDtlService(ContextHelper.getStringSafe(request, "selSzCdAdminDtlService"));
    rowcfin16sig00.setTsLastUpdate(DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate")));
    rowcfin16sig00.setUYrAdminDtlSvcYear(ContextHelper.getIntSafe(request, "txtUYrAdminDtlSvcYear"));
    rowcfin16sig00.setUsNbrAdminDtlCsli(ContextHelper.getIntSafe(request, "txtUsNbrAdminDtlCsli"));
    rowcfin16sig00.setUMoAdminDtlSvcMonth(ContextHelper.getIntSafe(request, "txtUMoAdminDtlSvcMonth"));
    rowcfin16sig00.setUlIdInvoInvoice(GlobalData.getUlIdInvoice(request));
    rowcfin16sig00.setUlIdAdminDtl(ContextHelper.getIntSafe(request, "hdnUlIdAdminDtl"));
    rowcfin16sig00.setDAmtAdminDtlSalaries(dAmtAdminDtlSalaries);
    rowcfin16sig00.setDAmtAdminDtlFrgBenft(dAmtAdminDtlFrgBenft);
    rowcfin16sig00.setDAmtAdminDtlTravel(dAmtAdminDtlTravel);
    rowcfin16sig00.setDAmtAdminDtlSupplies(dAmtAdminDtlSupplies);
    rowcfin16sig00.setDAmtAdminDtlEquipment(dAmtAdminDtlEquipment);
    rowcfin16sig00.setDAmtAdminDtlOther(dAmtAdminDtlOther);
    rowcfin16sig00.setDAmtAdminDtlAdminAlloc(dAmtAdminDtlAdminAlloc);
    rowcfin16sig00.setDAmtAdminDtlOffsetItem(dAmtAdminDtlOffsetItem);
    rowcfin16sig00.setCIndAdminDtlRejItm(ContextHelper.getStringSafe(request, "hdnCIndAdminDtlRejItm"));
    rowcfin16sig00.setSzCdScrDataAction(ContextHelper.getStringSafe(request, "hdnCReqFuncCd"));

    rowcfin16sig00.setDAmtAdminDtlPromotional(dAmtAdminDtlPromotional);
    rowcfin16sig00.setSzCdCounty(cdCounty);
    rowcfin16sig00.setSzAdmDtlComments(txtComments);

    if (CodesTables.CINVADJT_N.equals(cfin02so.getSzCdInvoAdjustmentRb())) {
      rowcfin16sig00.setSzCdAdminDtlLiType(ORIGINAL_LI);
    } else {
      if (dAmtAdminDtlSalaries < 0 || dAmtAdminDtlFrgBenft < 0 || dAmtAdminDtlTravel < 0 || dAmtAdminDtlSupplies < 0
          || dAmtAdminDtlEquipment < 0 || dAmtAdminDtlOther < 0 || dAmtAdminDtlAdminAlloc < 0
          || dAmtAdminDtlOffsetItem < 0) {
        rowcfin16sig00.setSzCdAdminDtlLiType(REVERSAL_LI);
      } else {
        rowcfin16sig00.setSzCdAdminDtlLiType(ADJUSTMENT_LI);
      }
    }

    cfin16si.setArchInputStruct(input);

    // Add the struct to the array
    rowcfin16sig00_array.addROWCFIN16SIG00(rowcfin16sig00);
    // Set the array into the parent struct
    cfin16si.setROWCFIN16SIG00_ARRAY(rowcfin16sig00_array);

    return cfin16si;

  }

  /**
   * populateCFIN08S <p/> This method is used to populate the CFIN08SI object for Validating Foster Care information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return cfin08si
   */
  private CFIN08SI populateCFIN08SI_V(GrndsExchangeContext context) {

    HttpServletRequest request = context.getRequest();
    CFIN08SI cfin08si = new CFIN08SI();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    ArchInputStruct input = new ArchInputStruct();

    input.setSzUserId(user.getUserLogonID());
    cfin08si.setArchInputStruct(input);

    cfin08si.setUlIdPerson(ContextHelper.getIntSafe(request, "txtUlIdPerson"));
    cfin08si.setUlIdResource(ContextHelper.getIntSafe(request, "txtUlIdResource"));
    cfin08si.setWcdIndPrsnChng(ArchitectureConstants.Y);

    return cfin08si;
  }

  /**
   * populateCFIN29S <p/> This method is used to populate the CFIN29SI object for Validating Delivered Service
   * information
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param cReqFuncCd
   *          The ReqFuncCd
   * @return cfin29si
   */
  private CFIN29SI populateCFIN29SI_V(GrndsExchangeContext context, String cReqFuncCd, CFIN02SO cfin02so) {

    // BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    CFIN29SI cfin29si = new CFIN29SI();
    ArchInputStruct input = new ArchInputStruct();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    input.setSzUserId(user.getUserLogonID());

    cfin29si.setSzCdSvcDtlCounty(ContextHelper.getStringSafe(request, "selSzCdSvcDtlCounty"));
    cfin29si.setSzCdSvcDtlService(ContextHelper.getStringSafe(request, "selSzCdSvcDtlService"));
    cfin29si.setSzCdInvoType(cfin02so.getSzCdInvoType());
    cfin29si.setUlIdPerson(ContextHelper.getIntSafe(request, "txtUlIdPerson"));
    cfin29si.setUlIdContract(GlobalData.getUlIdContract(request));
    
    int month = ContextHelper.getIntSafe(request, "txtUMoSvcDtlSvcMonth");
    if(month < 1 || month > 12) {
      //-- fail fast to avoid Oracle exception down the line
      throw new ServiceException(Messages.MSG_ARC_CONSTR_MONTH);
    }
    cfin29si.setUMoSvcDtlSvcMonth(month);
    
    int year = ContextHelper.getIntSafe(request, "txtUYrSvcDtlServiceYear");
    if(year < 1835 || year > 4712) {
      throw new ServiceException(Messages.MSG_ARC_CONSTR_YEAR);
    }
    cfin29si.setUYrSvcDtlServiceYear(year);

    if ("CPS".equals(cfin02so.getSzCdCntrctProgramType())) {
      cfin29si.setCIndSvcAuthComplete(ArchitectureConstants.Y);
    } else {
      cfin29si.setCIndSvcAuthComplete(ArchitectureConstants.N);
    }

    if ("A".equals(cReqFuncCd)) {
      cfin29si.setCIndRsrcTransport(ArchitectureConstants.N);
    } else {
      cfin29si.setCIndRsrcTransport(ArchitectureConstants.Y);
    }

    cfin29si.setArchInputStruct(input);
    return cfin29si;
  }
  
  private ContractCountiesSI populateContractCountiesSI(HttpServletRequest request) {
    ContractCountiesSI si = new ContractCountiesSI();
    si.setIdContract(GlobalData.getUlIdContract(request));
    return si;
  }
  
  private BudgetUpdateSI populateBudgetUpdateSI(HttpServletRequest request, CFIN03SI cfin03si) {
    BudgetUpdateSI si = new BudgetUpdateSI();
    
    si.setIdContract(cfin03si.getUlIdContract());
    si.setInvoiceCheckNumber(getIntSafe(cfin03si.getSzNbrInvoWarrant()));
    si.setInvoiceCounty(cfin03si.getSzCdCounty());
    si.setInvoiceDatePaid(DateHelper.toJavaDate(cfin03si.getDtDtInvoWarrantDate()));
    
    List<InvoiceLineItem> lineItems = new ArrayList<InvoiceLineItem>();
    
    //-- determine invoice type and populate lineItems from retrieved structs in state
    BaseSessionStateManager state = getSessionStateManager(request);
    boolean isAdmin = false;
    String invoiceType = cfin03si.getSzCdInvoType();
    if(isFosterCareType(invoiceType)) {
      CFIN10SO cfin10so = (CFIN10SO) state.getAttribute("CFIN10SO", request);
      if(cfin10so != null && cfin10so.getROWCFIN10SOG00_ARRAY() != null && cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00Count() > 0) {
        for(ROWCFIN10SOG00 row : cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00()) {
          InvoiceLineItem li = new InvoiceLineItem();
          li.setAdmin(isAdmin);
          li.setAmount(calculateFosterCareLineItemTotal(row));
          li.setId(row.getUlIdSvcDtl());
          li.setMonth(row.getUMoSvcDtlSvcMonth());
          li.setServiceCode(row.getSzCdSvcDtlService());
          li.setUnits(row.getSNbrSvcDtlUnitQty());
          li.setYear(row.getUYrSvcDtlServiceYear());
          lineItems.add(li);
        }
      }
    } else if(isAdminType(invoiceType)) {
      isAdmin = true;
      CFIN15SO cfin15so = (CFIN15SO) state.getAttribute("CFIN15SO", request);
      if(cfin15so != null && cfin15so.getROWCFIN15SOG00_ARRAY() != null && cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00Count() > 0) {
        for(ROWCFIN15SOG00 row : cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00()) {
          InvoiceLineItem li = new InvoiceLineItem();
          li.setAdmin(isAdmin);
          li.setAmount(calculateAdminLineItemTotal(row));
          li.setId(row.getUlIdAdminDtl());
          li.setMonth(row.getUMoAdminDtlSvcMonth());
          li.setServiceCode(row.getSzCdAdminDtlService());
          li.setYear(row.getUYrAdminDtlSvcYear());
          lineItems.add(li);
        }
      }
    } else if(isDeliveredServiceOrAdoptionAssistanceType(invoiceType)) {
      CFIN06SO cfin06so = (CFIN06SO) state.getAttribute("CFIN06SO", request);
      if(cfin06so != null && cfin06so.getROWCFIN06SOG_ARRAY() != null && cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOGCount() > 0) {
        for(ROWCFIN06SOG row : cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG()) {
          InvoiceLineItem li = new InvoiceLineItem();
          li.setAdmin(isAdmin);
          li.setAmount(calculateDelSvcAdoAsstLineItemTotal(row));
          li.setId(row.getUlIdSvcDtl());
          li.setIdSvcAuthDtl(row.getUlIdSvcAuthDtl());
          li.setMonth(row.getUMoSvcDtlSvcMonth());
          li.setServiceCode(row.getSzCdSvcDtlService());
          li.setUnits(row.getSNbrSvcDtlUnitQty());
          li.setYear(row.getUYrSvcDtlServiceYear());
          lineItems.add(li);
        }
      }
    }
    
    si.setLineItems(lineItems);
    
    return si;
  }
  
  private int getIntSafe(String s) {
    if(s == null) {
      return 0;
    }
    try {
      return Integer.parseInt(s);
    } catch(NumberFormatException nfe) {
      return 0;
    }
  }
  
  private void setFosterCareServiceOptions(HttpServletRequest request, ROWCFIN10SOG01_ARRAY contractServiceCodes) {
    if(contractServiceCodes == null) {
      return;
    }
    
    BaseSessionStateManager state = getSessionStateManager(request);
    boolean errorMessage = false;
    Set<CodeAttributes> serviceCodeSet = new HashSet<CodeAttributes>(); //-- set guarantees no duplicates    
    Map<String, String> serviceUnitTypes = new HashMap<String, String>();
    
    Enumeration<ROWCFIN10SOG01> csCodesEnum = contractServiceCodes.enumerateROWCFIN10SOG01();
    while (csCodesEnum.hasMoreElements()) {
      ROWCFIN10SOG01 rowcfin10sog01 = csCodesEnum.nextElement();
      String szCdCnsvcService = rowcfin10sog01.getSzCdCnsvcService();
      String szCdCnsvcUnitType = rowcfin10sog01.getSzCdCnsvcUnitType();
      CodeAttributes option = getServiceAsOption(szCdCnsvcService);
      if(option != null) {
        serviceUnitTypes.put(szCdCnsvcService, szCdCnsvcUnitType);
        serviceCodeSet.add(option);
      } else if(!errorMessage) {
        setInformationalMessage(Messages.MSG_NO_SVC_DECODE, DISPLAY_FOSTER, request);
        errorMessage = true;
      }
    }
    
    List<CodeAttributes> serviceCodeOptions = new ArrayList<CodeAttributes>(serviceCodeSet);
    Collections.sort(serviceCodeOptions, new Comparator<CodeAttributes>() {
      public int compare(CodeAttributes me, CodeAttributes you) {
        String myCode = me.getCode();
        String yourCode = you.getCode();
        if(myCode == null || yourCode == null) {
          return 0;
        }
        return myCode.compareTo(yourCode);
      }
    });
    
    state.setAttribute(SERVICE_UNIT_TYPES, serviceUnitTypes, request);
    state.setAttribute(SERVICE_CODE_OPTIONS, serviceCodeOptions, request);
  }
  
  private void setCountyOptions(HttpServletRequest request, Set<String> counties) {
    Set<CodeAttributes> countyOptions = buildOptions(CodesTables.CCOUNT, counties);
    BaseSessionStateManager state = getSessionStateManager(request);
    state.setAttribute(COUNTY_OPTIONS, countyOptions, request);
  }
  
  private static CodeAttributes getServiceAsOption(String serviceCode) {
    return getOption(CodesTables.CSVCCODE, serviceCode);
  }
  
  private static CodeAttributes getOption(String codeType, String code) {
    try {
      if(Lookup.isValidCode(codeType, code)) {
        return Lookup.decode(codeType, code);
      }
    } catch(LookupException le) {
      throw new IllegalStateException("Decoding "+code+" against "+codeType+ " failed!", le);
    }
    return null;
  }
  
  private void clearContractValidation(HttpServletRequest request, CFIN02SO cfin02so) {
    request.setAttribute(IND_VALIDATE, ArchitectureConstants.N);
    //cfin02so.setSzCdCounty_Array(new SzCdCounty_Array());
    cfin02so.setSzCdCounty(" ");
    cfin02so.setSzNmResource("");
    cfin02so.setUlIdResource(0);
    cfin02so.setSzNbrInvoVid("");
    cfin02so.setSzCdCntrctRegion("");
    request.setAttribute(ServerSideValidationUtility.REFRESH_WIDGETS_FROM_REQUEST, "false");
  }
  
  private ContractCountiesSO callRetrieveContractCounties(GrndsExchangeContext context) {
    ContractCountiesSI contractCountiesSI = populateContractCountiesSI(context.getRequest());
    ContractCountiesSO contractCountiesSO = null;
    try {
      contractCountiesSO = financials.retrieveContractCounties(contractCountiesSI);
    } catch(Exception e) {
      processSevereException(context, e);
    }
    return contractCountiesSO;
  }
  
  private Set<CodeAttributes> buildOptions(String codeType, Set<String> codes) {
    if(codes == null || codes.isEmpty()) {
      return null;
    }
    
    Set<CodeAttributes> options = new LinkedHashSet<CodeAttributes>();
    for(String code : codes) {
      CodeAttributes ca = getOption(codeType, code);
      if(ca != null) {
        options.add(ca);
      }
    }
    return options;
  }
  
  private void buildRegionCountyMap(HttpServletRequest request, boolean restrictUser) {
    List<CodeAttributes> codesTable = null;
    try {
      codesTable = Lookup.getCategoryCollection(CodesTables.CCNTYREG);
    } catch(LookupException le) {
      return;
    }
    
    List<String> userRegions = null;
    if(restrictUser) {
      userRegions = UserProfileHelper.getUserProfile(request).getUserMaintainedRegions();
    }
    
    ContractCountiesSO mapBuilder = new ContractCountiesSO();
    for(CodeAttributes ca : codesTable) {
      String region = ca.getDecode();
      if(restrictUser && !userRegions.contains(region)) {
        continue;
      }
      if(CodesTables.CREGIONS_99.equals(region)) {
        Collection<String> allCounties = null;
        try {
          allCounties = Lookup.getCategoryCodesCollection(CodesTables.CCOUNT);
        } catch(LookupException le) {}
        mapBuilder.addServiceCodes(region, allCounties);
        continue;
      }
      mapBuilder.addServiceCode(region, ca.getCode());
    }
    
    Map<String, Set<String>> regionCountyMap = mapBuilder.getCountyToServiceCodesMap();
    if(!regionCountyMap.isEmpty()) {
      BaseSessionStateManager state = getSessionStateManager(request);
      state.setAttribute(REGION_COUNTY_MAP, regionCountyMap, request);
      state.setAttribute(REGION_OPTIONS, buildOptions(CodesTables.CREGIONS, regionCountyMap.keySet()), request);
    }
  }
  
  private boolean setCountyServiceMap(GrndsExchangeContext context) {
    ContractCountiesSO contractCountiesSO = callRetrieveContractCounties(context);
    if(contractCountiesSO == null) {
      //-- any exceptions thrown in callRetrieveContractCounties were handled with processSevereException
      return false;
    }
    Map<String, Set<String>> countyToServiceCodesMap = contractCountiesSO.getCountyToServiceCodesMap();
    if(!countyToServiceCodesMap.isEmpty()) {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(request);
      state.setAttribute(COUNTY_SERVICE_MAP, countyToServiceCodesMap, request);
      setCountyOptions(request, countyToServiceCodesMap.keySet());
    }
    return true;
  }
  private void displayLineItemList(GrndsExchangeContext context,CFIN02SO cfin02so,TuxedoPaginationValueBean tuxPagination,int invoiceId){
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);
    String invoType = cfin02so.getSzCdInvoType();
    boolean isEmergencyType = isEmergencyType(invoType);
    double validAmount = cfin02so.getDAmtInvoValidAmount();
    if (isFosterCareType(invoType)) {
      CFIN10SI cfin10si = populateCFIN10S_Retrieve(context, tuxPagination);
      if(invoiceId!=0){
      cfin10si.setUlIdInvoInvoice(invoiceId);
      }
      CFIN10SO cfin10so = financials.retrieveFosterCareDetail(cfin10si);
      state.setAttribute("CFIN10SO", cfin10so, request);

      // set the information into the pagination bean and then store it to the request
      tuxPagination.setPaginationInformation(cfin10so.getArchOutputStruct(), cfin10so.getROWCFIN10SOG00_ARRAY()
                                                                                     .getUlRowQty());
      if(isEmergencyType) {
        validAmount = calculateFosterCareTotal(cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00());
      }
    } else if (isAdminType(invoType)) {
      CFIN15SI cfin15si = populateCFIN15S_Retrieve(context, tuxPagination);
      if(invoiceId!=0){
      cfin15si.setUlIdInvoInvoice(invoiceId);
      }
      CFIN15SO cfin15so = financials.retrieveAdminDetail(cfin15si);
      state.setAttribute("CFIN15SO", cfin15so, request);

      // set the information into the pagination bean and then store it to the request
      tuxPagination.setPaginationInformation(cfin15so.getArchOutputStruct(), cfin15so.getROWCFIN15SOG00_ARRAY()
                                                                                     .getUlRowQty());
      if(isEmergencyType) {
        validAmount = calculateAdminTotal(cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00());
      }
    } else if (isDeliveredServiceOrAdoptionAssistanceType(invoType)) {
      CFIN06SI cfin06si = populateCFIN06S_Retrieve(context, tuxPagination);
      if(invoiceId!=0){
      cfin06si.setUlIdInvoInvoice(invoiceId);
      }
      CFIN06SO cfin06so = financials.findDeliveredServiceDetail(cfin06si);
      state.setAttribute("CFIN06SO", cfin06so, request);

      // set the information into the pagination bean and then store it to the request
      tuxPagination.setPaginationInformation(cfin06so.getArchOutputStruct(), cfin06so.getROWCFIN06SOG_ARRAY().getUlRowQty());
      
      if(isEmergencyType) {
        validAmount = calculateDeliveredServiceTotal(cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG());
      }
    }
    storePaginationBeanToRequest(context, tuxPagination);
    request.setAttribute("calculatedTotalAmount", validAmount);
    if(isEmergencyType) {
      request.setAttribute("Legend2", "condRequired");
    }
    
  }
  private void saveCopiedDlvrdOrAdoptServices(GrndsExchangeContext context,CFIN06SO cfin06so, CFIN03SI cfin03si, int idInvoice) {
    ROWCFIN06SOG_ARRAY delArray = null;
    HttpServletRequest request = context.getRequest();
    if (cfin06so.getROWCFIN06SOG_ARRAY() != null) {
      delArray = cfin06so.getROWCFIN06SOG_ARRAY();
      Enumeration delEnumeration = delArray.enumerateROWCFIN06SOG();
      CFIN07SI cfin07si = new CFIN07SI();
      ROWCFIN07SIG_ARRAY rowcfin07sig_array = new ROWCFIN07SIG_ARRAY();
      UserProfile user = UserProfileHelper.getUserProfile(request);
      while (delEnumeration.hasMoreElements()) {
        ROWCFIN06SOG delRow = null;
        delRow = (ROWCFIN06SOG) delEnumeration.nextElement();
        // Allocate the structures
        ROWCFIN07SIG rowcfin07sig = new ROWCFIN07SIG();
        ArchInputStruct input = new ArchInputStruct();
        String reqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
        double qty = delRow.getSNbrSvcDtlUnitQty();
        String szCdSvcDtlService = delRow.getSzCdSvcDtlService();
        int ulIdSvcDtl = 0;
        String szCdCnsvcPaymentType = delRow.getSzCdCnsvcPaymentType();
        // Set the values for the ArchInputStruct
        input.setCReqFuncCd(reqFuncCd);
        input.setUlPageSizeNbr(ONE);
        input.setSzUserId(user.getUserLogonID());
        cfin07si.setUlIdContract(cfin03si.getUlIdContract());
        cfin07si.setTsSysTsLastUpdate2(cfin03si.getTsLastUpdate());
        cfin07si.setSzCdInvoPhase(cfin03si.getSzCdInvoPhase());
        cfin07si.setSzCdCnsvcPaymentType(szCdCnsvcPaymentType);
        cfin07si.setSzCdInvoType(cfin03si.getSzCdInvoType());
        rowcfin07sig.setSzCdSvcDtlCounty(delRow.getSzCdSvcDtlCounty());
        rowcfin07sig.setSzCdSvcDtlService(szCdSvcDtlService);
        rowcfin07sig.setSzCdSvcDtlUnitType(delRow.getSzCdSvcDtlUnitType());
        rowcfin07sig.setUlIdInvoInvoice(idInvoice);
        rowcfin07sig.setCIndSvcDtlRejItem(delRow.getCIndSvcDtlRejItem());
        rowcfin07sig.setDAmtSvcDtlFeePaid(delRow.getDAmtSvcDtlFeePaid());
        rowcfin07sig.setUlIdPerson(delRow.getUlIdPerson());
        rowcfin07sig.setUlIdSvcDtl(ulIdSvcDtl);
        rowcfin07sig.setUlIdSvcAuthDtl(delRow.getUlIdSvcAuthDtl());
        rowcfin07sig.setUMoSvcDtlSvcMonth(delRow.getUMoSvcDtlSvcMonth());
        rowcfin07sig.setUYrSvcDtlServiceYear(delRow.getUYrSvcDtlServiceYear());
        rowcfin07sig.setUsNbrSvcDtlCsli(delRow.getUsNbrSvcDtlCsli());
        rowcfin07sig.setSNbrSvcDtlUnitQty(qty);
        rowcfin07sig.setSzCdSysDataActionOutcome(reqFuncCd);
        if (CodesTables.CINVADJT_N.equals(cfin03si.getSzCdInvoAdjustmentRb())) {
          rowcfin07sig.setSzCdSvcDtlLiType(ORIGINAL_LI);
        } else {
          if (qty < 0.0) {
            rowcfin07sig.setSzCdSvcDtlLiType(REVERSAL_LI);
          } else {
            rowcfin07sig.setSzCdSvcDtlLiType(ADJUSTMENT_LI);
          }
        }
        // SIR 19795 if the type is CRM set the unit rate to 0.0 when saving the page.
        if (szCdCnsvcPaymentType != null && "CRM".equals(szCdCnsvcPaymentType)) {
          rowcfin07sig.setDAmtSvcDtlUnitRate(0.00);
        } else {
          rowcfin07sig.setDAmtSvcDtlUnitRate(delRow.getDAmtSvcDtlUnitRate());
        }
        cfin07si.setArchInputStruct(input);

        // Add the struct to the array
        rowcfin07sig_array.addROWCFIN07SIG(rowcfin07sig);

      }
      // Set the array into the parent struct
      cfin07si.setROWCFIN07SIG_ARRAY(rowcfin07sig_array);
      cfin07si.setCIndCopiedInv(ArchitectureConstants.Y);
      financials.saveDelvrdSvcDtl(cfin07si);
    }
  }
  private void saveCopiedFosterCareList(GrndsExchangeContext context, CFIN10SO cfin10so, CFIN03SI cfin03si,
                                        int idInvoice) {
    ROWCFIN10SOG00_ARRAY fosterArray = null;
    HttpServletRequest request = context.getRequest();
      if (cfin10so.getROWCFIN10SOG00_ARRAY() != null) {
        fosterArray = cfin10so.getROWCFIN10SOG00_ARRAY();
        Enumeration fosterEnumeration = fosterArray.enumerateROWCFIN10SOG00();
        CFIN11SI cfin11si = new CFIN11SI();
        ROWCFIN11SIG00_ARRAY rowcfin11sig00_array = new ROWCFIN11SIG00_ARRAY();
        ArchInputStruct input = new ArchInputStruct();
        UserProfile user = UserProfileHelper.getUserProfile(request);
        while (fosterEnumeration.hasMoreElements()) {
          ROWCFIN10SOG00 fosterRow = null;
          fosterRow = (ROWCFIN10SOG00) fosterEnumeration.nextElement();
          // Allocate the structures
          ROWCFIN11SIG00 rowcfin11sig00 = new ROWCFIN11SIG00();
          String reqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
          String indReversal = "";
          if ("R".equals(fosterRow.getSzCdSvcDtlLiType())) {
            indReversal = "Y";
          } else {
            indReversal = "N";
          }
          // -- get unit type first
          int fromDay = fosterRow.getSNbrSvcDtlFromDay();
          int toDay = fosterRow.getSNbrSvcDtlToDay();
          double unitQty = fosterRow.getSNbrSvcDtlUnitQty();
          input.setCReqFuncCd(reqFuncCd);
          input.setUlPageSizeNbr(ONE);
          input.setSzUserId(user.getUserLogonID());

          cfin11si.setUlIdContract(cfin03si.getUlIdContract());
          cfin11si.setTsSysTsLastUpdate2(cfin03si.getTsLastUpdate());
          cfin11si.setSzCdInvoPhase(cfin03si.getSzCdInvoPhase());
          cfin11si.setUlIdInvoInvoice(idInvoice);
          rowcfin11sig00.setSzCdSvcDtlService(fosterRow.getSzCdSvcDtlService());
          rowcfin11sig00.setSzCdSvcDtlUnitType(fosterRow.getSzCdSvcDtlUnitType());
          rowcfin11sig00.setDAmtSvcDtlIncome(fosterRow.getDAmtSvcDtlIncome());
          rowcfin11sig00.setDAmtSvcDtlUnitRate(fosterRow.getDAmtSvcDtlUnitRate());
          rowcfin11sig00.setUlIdInvoInvoice(idInvoice);
          rowcfin11sig00.setUlIdPerson(fosterRow.getUlIdPerson());
          rowcfin11sig00.setUlIdResource(fosterRow.getUlIdResource());
          rowcfin11sig00.setUlIdSvcDtl(0);
          rowcfin11sig00.setCIndSvcDtlRejItem(fosterRow.getCIndSvcDtlRejItem());
          rowcfin11sig00.setUMoSvcDtlSvcMonth(fosterRow.getUMoSvcDtlSvcMonth());
          if (fromDay > 0) {
            rowcfin11sig00.setSNbrSvcDtlFromDay(fromDay);
          }
          if (toDay > 0) {
            rowcfin11sig00.setSNbrSvcDtlToDay(toDay);
          }
          rowcfin11sig00.setUYrSvcDtlServiceYear(fosterRow.getUYrSvcDtlServiceYear());
          rowcfin11sig00.setSzCdScrDataAction(reqFuncCd);
          rowcfin11sig00.setLNbrRsrcFacilAcclaim(fosterRow.getLNbrRsrcFacilAcclaim());
          if (ArchitectureConstants.Y.equals(indReversal)) {
            unitQty *= -1;
          }
          rowcfin11sig00.setSNbrSvcDtlUnitQty(unitQty);
          if (CodesTables.CINVADJT_N.equals(cfin03si.getSzCdInvoAdjustmentRb())) {
            rowcfin11sig00.setSzCdSvcDtlLiType(ORIGINAL_LI);
          } else {
            if (ArchitectureConstants.N.equals(indReversal)) {
              rowcfin11sig00.setSzCdSvcDtlLiType(ADJUSTMENT_LI);
            } else {
              rowcfin11sig00.setSzCdSvcDtlLiType(REVERSAL_LI);
            }
          }
          cfin11si.setArchInputStruct(input);

          // Add the struct to the array
          rowcfin11sig00_array.addROWCFIN11SIG00(rowcfin11sig00);
        }
        // Set the array into the parent struct
        cfin11si.setROWCFIN11SIG00_ARRAY(rowcfin11sig00_array);
        cfin11si.setCIndCopiedInv(ArchitectureConstants.Y);
        financials.saveFosterCareDetail(cfin11si);
      }
  }
  private void saveCopiedAdminList(GrndsExchangeContext context, CFIN15SO cfin15so, CFIN03SI cfin03si,
                                        int idInvoice) {
    ROWCFIN15SOG00_ARRAY adminArray = null;
    HttpServletRequest request = context.getRequest();
      if (cfin15so.getROWCFIN15SOG00_ARRAY() != null) {
        adminArray = cfin15so.getROWCFIN15SOG00_ARRAY();
        Enumeration adminEnumeration = adminArray.enumerateROWCFIN15SOG00();
        CFIN16SI cfin16si = new CFIN16SI();
        ROWCFIN16SIG00_ARRAY rowcfin16sig00_array = new ROWCFIN16SIG00_ARRAY();
        ArchInputStruct input = new ArchInputStruct();
        UserProfile user = UserProfileHelper.getUserProfile(request);
        while (adminEnumeration.hasMoreElements()) {
          ROWCFIN15SOG00 adminRow = null;
          adminRow = (ROWCFIN15SOG00) adminEnumeration.nextElement();
          // Allocate the structures
          ROWCFIN16SIG00 rowcfin16sig00 = new ROWCFIN16SIG00();
          String reqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
          double dAmtAdminDtlSalaries = adminRow.getDAmtAdminDtlSalaries();
          double dAmtAdminDtlFrgBenft = adminRow.getDAmtAdminDtlFrgBenft();
          double dAmtAdminDtlTravel = adminRow.getDAmtAdminDtlTravel();
          double dAmtAdminDtlSupplies = adminRow.getDAmtAdminDtlSupplies();
          double dAmtAdminDtlEquipment = adminRow.getDAmtAdminDtlEquipment();
          double dAmtAdminDtlOther = adminRow.getDAmtAdminDtlOther();
          double dAmtAdminDtlAdminAlloc = adminRow.getDAmtAdminDtlAdminAlloc();
          double dAmtAdminDtlOffsetItem = adminRow.getDAmtAdminDtlOffsetItem();

          double dAmtAdminDtlPromotional = adminRow.getDAmtAdminDtlPromotional();
          String txtComments = adminRow.getSzTxtAdminDtlComments();
          String cdCounty = adminRow.getSzCdCounty();
          // Set the values for the ArchInputStruct
          input.setCReqFuncCd(reqFuncCd);
          input.setUlPageSizeNbr(ONE);
          input.setSzUserId(user.getUserLogonID());
          cfin16si.setUlIdContract(cfin03si.getUlIdContract());
          cfin16si.setTsSysTsLastUpdate2(cfin03si.getTsLastUpdate());
          cfin16si.setSzCdInvoPhase(cfin03si.getSzCdInvoPhase());
          cfin16si.setUlIdInvoInvoice(idInvoice);
          rowcfin16sig00.setSzCdAdminDtlInvoDisptn(adminRow.getSzCdAdminDtlInvoDisptn());
          rowcfin16sig00.setSzCdAdminDtlService(adminRow.getSzCdAdminDtlService());
          rowcfin16sig00.setUYrAdminDtlSvcYear(adminRow.getUYrAdminDtlSvcYear());
          rowcfin16sig00.setUsNbrAdminDtlCsli(adminRow.getUsNbrAdminDtlCsli());
          rowcfin16sig00.setUMoAdminDtlSvcMonth(adminRow.getUMoAdminDtlSvcMonth());
          rowcfin16sig00.setUlIdInvoInvoice(idInvoice);
          rowcfin16sig00.setUlIdAdminDtl(0);
          rowcfin16sig00.setDAmtAdminDtlSalaries(dAmtAdminDtlSalaries);
          rowcfin16sig00.setDAmtAdminDtlFrgBenft(dAmtAdminDtlFrgBenft);
          rowcfin16sig00.setDAmtAdminDtlTravel(dAmtAdminDtlTravel);
          rowcfin16sig00.setDAmtAdminDtlSupplies(dAmtAdminDtlSupplies);
          rowcfin16sig00.setDAmtAdminDtlEquipment(dAmtAdminDtlEquipment);
          rowcfin16sig00.setDAmtAdminDtlOther(dAmtAdminDtlOther);
          rowcfin16sig00.setDAmtAdminDtlAdminAlloc(dAmtAdminDtlAdminAlloc);
          rowcfin16sig00.setDAmtAdminDtlOffsetItem(dAmtAdminDtlOffsetItem);
          rowcfin16sig00.setCIndAdminDtlRejItm(adminRow.getCIndAdminDtlRejItm());
          rowcfin16sig00.setSzCdScrDataAction(reqFuncCd);

          rowcfin16sig00.setDAmtAdminDtlPromotional(dAmtAdminDtlPromotional);
          rowcfin16sig00.setSzCdCounty(cdCounty);
          rowcfin16sig00.setSzAdmDtlComments(txtComments);

          if (CodesTables.CINVADJT_N.equals(cfin03si.getSzCdInvoAdjustmentRb())) {
            rowcfin16sig00.setSzCdAdminDtlLiType(ORIGINAL_LI);
          } else {
            if (dAmtAdminDtlSalaries < 0 || dAmtAdminDtlFrgBenft < 0 || dAmtAdminDtlTravel < 0 || dAmtAdminDtlSupplies < 0
                || dAmtAdminDtlEquipment < 0 || dAmtAdminDtlOther < 0 || dAmtAdminDtlAdminAlloc < 0
                || dAmtAdminDtlOffsetItem < 0) {
              rowcfin16sig00.setSzCdAdminDtlLiType(REVERSAL_LI);
            } else {
              rowcfin16sig00.setSzCdAdminDtlLiType(ADJUSTMENT_LI);
            }
          }

          cfin16si.setArchInputStruct(input);

          // Add the struct to the array
          rowcfin16sig00_array.addROWCFIN16SIG00(rowcfin16sig00);
        }
          // Set the array into the parent struct
          cfin16si.setROWCFIN16SIG00_ARRAY(rowcfin16sig00_array);
          cfin16si.setCIndCopiedInv(ArchitectureConstants.Y);
          financials.saveAdminDetail(cfin16si);
      }
  }
  public static boolean optionsContainsCode(Collection<? extends Mapping> options, String code) {
    if(options == null || options.isEmpty()) {
      return false;
    }
    for(Mapping mapping : options) {
      if(mapping != null && mapping.getKey() != null && mapping.getKey().equals(code)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isEmergencyType(String invoType) {
    return StringHelper.isValid(invoType) && invoType.startsWith("E");
  }
  
  public static boolean isFosterCareType(String invoType) {
    return CodesTables.CINVTYPE_FSC.equals(invoType) || CodesTables.CINVTYPE_EFC.equals(invoType);
  }
  
  public static boolean isAdminType(String invoType) {
    return CodesTables.CINVTYPE_ADM.equals(invoType) || CodesTables.CINVTYPE_EAD.equals(invoType);
  }
  
  public static boolean isDeliveredServiceOrAdoptionAssistanceType(String invoType) {
    return CodesTables.CINVTYPE_ADS.equals(invoType) || CodesTables.CINVTYPE_DUR.equals(invoType) ||
           CodesTables.CINVTYPE_EDS.equals(invoType) || CodesTables.CINVTYPE_EAA.equals(invoType) ||
           CodesTables.CINVTYPE_RCS.equals(invoType); //MR-033 STGAP00013397 added new code RCS Relative Care Subsidy
  }
  
  //STGAP00007737: Added this method to check if the unit type is Day or Day 24 
  public static boolean isPerdiemLineItem(String unitType) {
    return CodesTables.CCONUNIT_DA2.equals(unitType) || CodesTables.CCONUNIT_DAY.equals(unitType);
  }
  
  public static double calculateFosterCareLineItemTotal(ROWCFIN10SOG00 row) {
    if(row == null) {
      return 0.0;
    }
    //-- if the income needs to be subtracted, just uncomment the end of the line
    return (row.getSNbrSvcDtlUnitQty() * row.getDAmtSvcDtlUnitRate()); // - row.getDAmtSvcDtlIncome();
  }
  
  public static double calculateAdminLineItemTotal(ROWCFIN15SOG00 row) {
    if(row == null) {
      return 0.0;
    }
    return row.getDAmtAdminDtlAdminAlloc() + row.getDAmtAdminDtlPromotional() + row.getDAmtAdminDtlOther();
  }
  
  public static double calculateDelSvcAdoAsstLineItemTotal(ROWCFIN06SOG row) {
    if(row == null) {
      return 0.0;
    }
    //-- if fee paid needs to be subtracted, just uncomment the end of this line
    return (row.getSNbrSvcDtlUnitQty() * row.getDAmtSvcDtlUnitRate()); // - row.getDAmtSvcDtlFeePaid();
  }
  
  //-- used on FosterCareDetail.jsp
  public static void writeJavascriptVars(JspWriter out, Map serviceUnitTypes, String arrayName) {
    if(serviceUnitTypes == null) {
      return;
    }
    
    StringBuilder sb = new StringBuilder();
    sb.append("var ").append(arrayName).append(" = new Array();");
    
    Set keys = serviceUnitTypes.keySet();
    int index = 0;
    for(Object o : keys) {
      String key = (String) o;
      sb.append("var k").append(key).append(" = ").append(index++).append(";");
      sb.append(arrayName).append("[k").append(key).append("] = \"");
      sb.append((String)serviceUnitTypes.get(key)).append("\";");
    }
    
    try {
      out.write(sb.toString());
    } catch(IOException e) {
      //-- handle?
    }
  }
  
  //-- used on Invoice.jsp and DeliveredServiceDetail.jsp
  public static void writeJavascriptArrays(JspWriter out, HttpServletRequest request,
                                           String attrName, String codesTable, String arraysPrefix) {
    BaseSessionStateManager state = getSessionStateManager(request);
    Object o = state.getAttribute(attrName, request);
    if(o != null) {
      Map countyServiceMap = (Map) o;
      StringBuilder sb = new StringBuilder();
      
      for(Object key : countyServiceMap.keySet()) {
        Set serviceCodes = (Set) countyServiceMap.get(key);
        String county = (String) key;
        sb.append("var ").append(arraysPrefix).append(county).append(" = new Array();");
        sb.append(arraysPrefix).append(county).append("[0] = \"|\";");
        
        if(serviceCodes != null && !serviceCodes.isEmpty()) {
          int i = 1;
          for(Object serviceCode : serviceCodes) {
            CodeAttributes service = getOption(codesTable, (String) serviceCode);
            if(service == null) {
              continue;
            }
            sb.append(arraysPrefix).append(county).append("[").append(i++).append("] = \"");
            sb.append(service.getCode()).append("|").append(service.getDecode()).append("\";");
          }
        }
      }
      
      try {
        out.write(sb.toString());
      } catch(IOException e) {}
    }
  }
  
  protected static void setRowIndexOnPagination(HttpServletRequest request, int index) {
    BaseSessionStateManager state = getSessionStateManager(request);

    InvoicePaginationDB invoicePaginationDB = (InvoicePaginationDB) state.getAttribute(INVOICE_PAGINATION_DB, request);

    if ((invoicePaginationDB != null) && (invoicePaginationDB.getUlIdInvoice() == GlobalData.getUlIdInvoice(request))) {
      invoicePaginationDB.setRowIndex(index);
      state.setAttribute(INVOICE_PAGINATION_DB, invoicePaginationDB, request);
    }
  }
  
}
