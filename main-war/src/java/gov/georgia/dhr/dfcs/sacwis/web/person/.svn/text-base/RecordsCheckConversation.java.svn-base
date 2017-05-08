package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfPersonViewSearchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC32SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC32SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CheckIfPersonViewSearchSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentUtilityHelpers;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to view external records checks information and documents and the results of DPS
 * criminal history searches. Users may create request for new records checks, save a new request, view old requests,
 * view DPS results, add or modify comments on the request and delete old requests ( except for DPS criminal history,
 * CAPS History and Central Registry rows which can not be deleted). When viewing DPS criminal history results, users
 * may accept or reject a DPS criminal history report and record criminal history comments. This is the Conversation
 * class used to search for contacts and summaries of open or closed stages that relate to a particular case and display
 * the Detail Information.
 * </p>
 * 
 * <pre>
 *  Change History:
 *  Date      User              Description
 *  --------  ----------------  ----------------------------------------------
 *  08/29/03  Todd Reser        SIR 19550 - Added deleteRecordsCheckDetail_xa.
 *                              While I was in here I decided to update and fix
 *                              all the javadoc errors.
 *  10/13/04  CORLEYAN          SIR 23211 - If the user has the DFPS Records Check
 *                              Security attribute, put the dialog into modify mode
 *                              regardless of navigation.  But, if the user has the
 *                              right and navigation is from person search, set
 *                              a page set for Criminal History Detail so that
 *                              the page cannot be modified, but the narrative can be
 *                              displayed
 *  1/14/2005 gerryc            SIR 23242 - restructured navigation of page for the
 *                              addition of the EBC narratives.  If an EBC type
 *                              is saved, then state is repopulated, and the detail
 *                              page is redisplayed.  On an update, the updated row
 *                              is found by the records check id instead of the
 *                              index in the array.  This was done because the index
 *                              changes if you add a EBC type, but then the index
 *                              doesn't match what is in state, and then
 *                              you overwrite the row with that previous index.
 *                              Using the records check id bypasses this problem.
 *  08/16/2005 Nallavs          SIR 23379 -- Added displayRecordsCheckDetail_xa
 *                              method to check for narrative document exists in
 *                              data base and sets the narrative button checkmark.
 *  01/19/2010 wjcochran        SMS #37458 - Added check to see if fingerprint data 
 *                              has been received and recorded. This data will be 
 *                              used to determine whether or not a todo should be 
 *                              sent to the user.
 * 08/18/2010  bgehlot          SMS 66380 MR-072 Changes
 * 11/08/2010  arege            SMS#79230 Page mode should not be set to modify even if the user has Records Check Security Attribute.    
 * 02/24/2011  hnguyen          SMS#97850: MR-075 update FA Person Detail data 
 *                              after any records check add, update, or delete.
 * </pre>
 * 
 * @author Katy Laura, November 15, 2002
 */
public class RecordsCheckConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "RecordsCheckConversation";

  public static final String PERSON_PERSONSEARCH = "PERSON_PERSONSEARCH";

  public static final int ROWS_PER_PAGE = 10;

  public static final int INITIAL_PAGE = 1;

  public static final int PAGE_SIZE = 10;

  // SIR 23379 The Record Check Detail Narrative Checkmark indicator appears only if Narrative exists.
  private static final String RECORD_CHECK_NARR_DOC_TYPE = "EBC";

  public static final String DOCEXISTS = "docExists";
  
  private final String REC_CHECK_FINGERPRINT_CARD = "F";
  
  private final String REC_CHECK_LIVE_SCAN = "L";
  
  private static final String NOT_VIEW_SEARCHED = "Not View Searched";

  private Common common;

  private DocumentSave documentSave;

  private Person person;

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * METHOD - Initial display of Records Check List, the first screen of the conversation. Calling from - Person; Staff
   * Detail CAPS window - ccfc13w ; CAPS retrieval service - CCFC26S
   * 
   * @param context
   *          The GrndsExchangeContext object
   */
  public void displayRecordsCheckList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayRecordsCheckList_xa()");
    performanceTrace.enterScope();
    // define state and request
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    // clear state at the beginning of the conversation
    state.removeAllAttributes(request);
    // paginaate RecordsCheckList
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);
    // get the pageMode from the calling page; Records Checks are called by Staff Search and Person Detail
    String pageMode = GlobalData.getAppMode(request);

    // SIR 18736 - Find out if not Employee
    if ("N".equals(PersonHelper.getBIndActiveStatus(request))) {
      String indEmployee = "N";
      request.setAttribute("indEmployee", indEmployee);
    }
    // SIR 18652 if the user has the records check security attribute, put the page mode
    // into modify.
    // SIR 23211 - Allow modify access to Records Check at all times if the user has the
    // Rec Check attribute
    //Commented out for SMS#79230
    /*if (user.hasRight(UserProfile.SEC_EMPL_REC_CHECK)) {
      pageMode = PageModeConstants.MODIFY;
    }*/
    if (String.valueOf(request.getParameter("level2Tab")).equalsIgnoreCase(PERSON_PERSONSEARCH)){
      pageMode = PageModeConstants.VIEW; 
    }
    // set pageMode in state. Page Mode must be in state for use in the Search type hyperlink on the List page.
    state.setAttribute("pageMode", pageMode, request);

    try {
      CCFC26SI ccfc26si = populateCCFC26SI_RETRIEVE(context, tuxPagination);
      CCFC26SO ccfc26so = person.retrieveRecordsCheck(ccfc26si);

      /*
       * place the service object and the indicator for an incomplete DPS row in the request; the service object
       * contains the rows displayed on the list page;
       */
      state.setAttribute("CCFC26SO", ccfc26so, request);
      /*
       * Set values for recordsCheckDetail custom validation into state; the txtCIndRecCheckDpsIncomplete prevents a new
       * DPS records check being started if an open DPS row already exists. Subject Name, gender, ethnicity and dob may
       * not be null
       */

      /* create a string with a boolean value for dob. DPS rows may not be created for null dob. */

      // set the information into the pagination bean and then store it to the request
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();

      archOutputStruct.setBMoreDataInd(ccfc26so.getBMoreDataInd());

      ccfc26so.setArchOutputStruct(archOutputStruct);

      tuxPagination.setPaginationInformation(ccfc26so.getArchOutputStruct(), ccfc26so.getROWCCFC26SOG00_ARRAY()
                                                                                     .getROWCCFC26SOG00Count());
      storePaginationBeanToRequest(context, tuxPagination);
    } catch (ServiceException we) {
      handleRCError(we, context);
    } catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Exception:" + ve.getMessage());
      processSevereException(context, ve);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Process - A user on the Records Check List screen clicks the delete button METHOD - deleteRecordsCheckList_xa
   * causes the selected row to be deleted. from the data base and reloads the Records Check List screen with new data.
   * CAPS window - ccfc13w ; CAPS service - CCFC27S ; Destination page - Records Check List with WTC for revised data
   * 
   * @param context
   *          The GrndsExchangeContext object
   */
  public void deleteRecordsCheckList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteRecordsCheckList_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    // get an array of indices to be deleted from the ccfc26 array
    // these indices are from the checked boxes on records check list jsp
    String[] selectedRowsForDelete = CheckboxHelper.getCheckedValues(request, "ckName_CLEAN");
    // get the ccfc26 object from state
    for (int i = 0; i < selectedRowsForDelete.length; i++) {
      int indexRowToBeDeleted = Integer.parseInt(selectedRowsForDelete[i]);
      try {
        gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI ccfc27si = populateCCFC27SI_DELETE(context,
                                                                                              indexRowToBeDeleted);

        person.audRecordsCheck(ccfc27si);

        // SMS#97850: MR-075 update FA Person Detail data after any records 
        //            check add, update, or delete.
        common.syncFaPersonDetailRecordsCheck(ccfc27si.getUlIdRecCheckPerson());

        // return to the initial display of the conversation
        // displayRecordsCheckList_xa( context );
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (ServiceException we) {
        handleRCError(we, context);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
        processSevereException(context, e);
      }
    } // end for loop

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method uses the ccfc26 object in state to call ccfc27 to delete the record indicated by hdnIndex in the
   * request.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */

  public void deleteRecordsCheckDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteRecordsCheckList_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    int indexRowToBeDeleted = Integer.parseInt(request.getParameter("hdnIndex"));
    try {
      CCFC27SI ccfc27si = populateCCFC27SI_DELETE(context, indexRowToBeDeleted);
      person.audRecordsCheck(ccfc27si);

      // SMS#97850: MR-075 update FA Person Detail data after any records 
      //            check add, update, or delete.
      common.syncFaPersonDetailRecordsCheck(ccfc27si.getUlIdRecCheckPerson());

      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    } catch (ServiceException we) {
      handleRCError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Process - A user on the Records Check Detail screen clicks a Save button METHOD - saveRecordsCheckDetail_xa causes
   * the new or modified request to be added to the database. Calling pages - Records Check Detail CAPS window - ccfc13w ;
   * CAPS service - CCFC27S; Destination page - Records Check List with Updated values.
   * 
   * @param context
   *          The GrndsExchangeContext object
   */
  public void saveRecordsCheckDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveRecordsCheckDetail_xa()");
    performanceTrace.enterScope();
    // establish context - state and request
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      CCFC27SI ccfc27si = populateCCFC27SI_UPDATE(context);
      CCFC27SO ccfc27so = person.audRecordsCheck(ccfc27si);

      // SMS#97850: MR-075 update FA Person Detail data after any records 
      //            check add, update, or delete.
      common.syncFaPersonDetailRecordsCheck(ccfc27si.getUlIdRecCheckPerson());

      String pageMode = (String) state.getAttribute("pageMode", request);
      /*
       * if we are adding a row using the detail page, we reset the page mode to NEW. Return it to MODIFY before
       * returning to the conversation. NEW page mode is used to make processing choices on the Detail jsp, in the
       * Save/populate CCFC27SI_UPDATE method and in the Detail custom validation
       */
      boolean reloadPage = false;
      if (pageMode.equals(PageModeConstants.NEW)) {
        pageMode = PageModeConstants.MODIFY;
        state.setAttribute("pageMode", pageMode, request);
      }
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);

      // SIR 23242 - reload the page if the search type is an EBC type. The
      // narrative button will now display.
      String selCdSearchType = ContextHelper.getStringSafe(request, "selCdSearchType");
      if ((CodesTables.CCHKTYPE_15).equals(selCdSearchType) || (CodesTables.CCHKTYPE_25).equals(selCdSearchType)) {
        request.setAttribute("txtUlIdRecCheck", String.valueOf(ccfc27so.getUlIdRecCheck()));
        // use display method to repopulate state
        displayRecordsCheckList_xa(context);
        // will use the default presentation class of the Records Check Detail page
        // SIR 23379 populated detail display method,so that narrative checkmark sets correctly
        displayRecordsCheckDetail_xa(context);
      } else if ((selCdSearchType.equals(CodesTables.CCHKTYPE_GC) || selCdSearchType.equals(CodesTables.CCHKTYPE_NC))
                 && reloadPage) {
        request.setAttribute("txtUlIdRecCheck", String.valueOf(ccfc27so.getUlIdRecCheck()));
        displayRecordsCheckList_xa(context);
        displayRecordsCheckDetail_xa(context);
      } else {
        setPresentationBranch("RECORDS_CHECK_LIST", context);
      }
    } catch (ServiceException we) {
      handleRCError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Process - A user on the Records Check List screen clicks the Results hyper link METHOD - displayCriminalHistory_xa
   * causes the initial display of Criminal History Records Check Results, the last screen of the conversation. The
   * method captures the id of the records_check row from the request and loads the associated criminal_history rows on
   * the criminal history page. When the user saves, the Records Check List screen is relaoaded with new data. CAPS
   * window - ccfc13w ; CAPS service - CCFC31S ; Calling pages - Records Check List; Records Check Detail
   * 
   * @param context
   *          The GrndsExchangeContext object
   */
  public void displayCriminalHistory_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCriminalHistory_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    try {
      // get the crimal_history rows for the identified id_rec_check;
      // populate ccfc31si and call the service
      CCFC31SI ccfc31si = populateCCFC31SI_RETRIEVE(context, tuxPagination);
      CCFC31SO ccfc31so = common.retrieveCriminalHistory(ccfc31si);
      // CCFC31SO.unmarshal(new StringReader(WtcHelper.callService("CCFC31S", ccfc31si)));
      // make the service object availble to the jsp in the request
      state.setAttribute("CCFC31SO", ccfc31so, request);

      // SIR 23211 - If the navigation is from person search, and the user has the Rec Check attribute and
      // not the maintain person attribute, set a page set.
      if (String.valueOf(request.getParameter("level2Tab")).equalsIgnoreCase(PERSON_PERSONSEARCH)
          && user.hasRight(UserProfile.SEC_EMPL_REC_CHECK) && !user.hasRight(UserProfile.SEC_MNTN_PERSON)) {
        Sets.setPageSet(Sets.A, request);
      }

      // set the information into the pagination bean and then store it to the request
      tuxPagination.setPaginationInformation(ccfc31so.getArchOutputStruct(), ccfc31so.getROWCCFC31SOG00_ARRAY()
                                                                                     .getROWCCFC31SOG00Count());
      storePaginationBeanToRequest(context, tuxPagination);
    } // end try
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  } // end displayCriminalHistory

  /**
   * Process - A user on the Criminal History screen clicks the Save button METHOD - saveCriminalHistory_xa causes the
   * accept/reject status and the comments fields to be updated for the row.
   * 
   * @param context
   *          The GrndsExchangeContext object
   */
  public void saveCriminalHistory_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveCriminalHistory_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      CCFC32SI ccfc32si = populateCCFC32SI_UPDATE(context);
      CCFC32SO ccfc32so = person.saveCriminalHistory(ccfc32si);
      // return to the initial page of the conversation
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    } catch (ServiceException we) {
      handleCHError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * SIR 23379 -- Added displayRecordsCheckDetail_xa method to check for narrative document exists in data base and if
   * so,sets the narrative button checkmark.
   * 
   * @param context
   */

  public void displayRecordsCheckDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayRecordsCheckDetail_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    
    //MR-072 In INTAKE stage when Clicking on ADD button on the List page check to see if the person has been view searched.
    boolean btnAdd = ContextHelper.getIntSafe(request, "btnAdd.x") != 0;
    if(btnAdd){
      CheckIfPersonViewSearchSI checkIfPersonViewSearchSI = new CheckIfPersonViewSearchSI();
      checkIfPersonViewSearchSI.setIdPerson(GlobalData.getUlIdPerson(request));
      checkIfPersonViewSearchSI.setIdStage(GlobalData.getUlIdStage(request));
      
      //Call the service which checks to see if the Person is view searched.
      CheckIfPersonViewSearchSO checkIfPersonViewSearchSO = person.checkIfPersonViewSearch(checkIfPersonViewSearchSI);
      String isPersonViewSearched = checkIfPersonViewSearchSO.getIsPersonViewSearched();
      String nmPerson = checkIfPersonViewSearchSO.getNmPerson();
      
      //If the stage is INT and the person is not view searched then only display error message, 
      //if it's not INT stage or if the Records Check is not accessed in context of stage then
      //no error message displays
      if(NOT_VIEW_SEARCHED.equals(isPersonViewSearched)){
        this.setPresentationBranch("error", context);
        String errorMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_PREVENT_ADD_RECORDS_CHECK),
                                                                FormattingHelper.formatString(nmPerson));
        setErrorMessage(errorMessage, "/person/RecordsCheck/displayRecordsCheckList", request);
        return;
      }
    }
    
    int idRecCheck = ContextHelper.getIntSafe(request, "hdnUlIdRecCheck");
    try {
      Date date = DocumentUtilityHelpers.getRecordDocumentTsLastUpdate(documentSave, RECORD_CHECK_NARR_DOC_TYPE,
                                                                       idRecCheck);

      if (date != null) {
        request.setAttribute(DOCEXISTS, ArchitectureConstants.TRUE);
      } else {
        request.setAttribute(DOCEXISTS, ArchitectureConstants.FALSE);
      }
    } catch (Exception ex) {
      processSevereException(context, ex);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * Criminal History doc type and template ccf12o00. Service ccfc34s; Document is for display only.
   * 
   * @param context
   *          The GrndsExchangeContext object
   */
  public void displayDocument_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayDocument_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // identify document to be displayed to the jsp required for Narrative types
    String docType = "ccf12o00";
    state.setAttribute("docType", docType, request);

    String pCrimHist = ContextHelper.getStringSafe(request, "pCrimHist");
    // fill the required fields for the Narrative parameters - frmCriminalHistoryNarrative
    request.setAttribute("pCrimHist", pCrimHist);
    String pPerson = ContextHelper.getStringSafe(request, "pPerson");
    request.setAttribute("pPerson", pPerson);
    String pCase = ContextHelper.getStringSafe(request, "pCase");
    request.setAttribute("pCase", pCase);
    // required statement for frmCriminalHistoryNarrative
    request.setAttribute("grnds.request.qname", null);
    try {
      // required statement for frmCriminalHistoryNarrative
      state.setAttribute("displayDoc", "ccf12o00", request);
    }

    catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Exception:" + ve.getMessage());
      processSevereException(context, ve);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This helper method populates row for an update or an add to the records_check table
   * 
   * @param context
   *          The GrndsExchangeContext object
   * @return ccfc27si
   * @throws MarshalException
   * @throws ValidationException
   */
  private CCFC27SI populateCCFC27SI_UPDATE(GrndsExchangeContext context) throws MarshalException, ValidationException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC27SI_UPDATE()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    // get the original records check array
    CCFC26SO ccfc26so = (CCFC26SO) state.getAttribute("CCFC26SO", request);
    if (ccfc26so == null) {
      ccfc26so = new CCFC26SO();
    }
    ROWCCFC26SOG00_ARRAY listArray = new ROWCCFC26SOG00_ARRAY();
    if (ccfc26so.getROWCCFC26SOG00_ARRAY() != null) {
      listArray = ccfc26so.getROWCCFC26SOG00_ARRAY();
    }

    // create the new array
    CCFC27SI ccfc27si = new CCFC27SI();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00_ARRAY rowccfc27sig00_array = new ROWCCFC27SIG00_ARRAY();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00 rowccfc27sig00 = new ROWCCFC27SIG00();
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    /*
     * calledFromJavaScript will be true if the save_xa function is called from the jsp when a form or report is
     * launched. See Notes in the add method.
     */

    boolean calledFromJavascript = StringHelper
                                               .isValid(ContextHelper.getStringSafe(request, "hdnCalledFromJavascript"));
    String pageMode = (String) state.getAttribute("pageMode", request);
    // Set the values for the ArchInputStruct and values for add versus update
    if (pageMode.equals(PageModeConstants.NEW) || calledFromJavascript) {
      // set up a row to be inserted
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccfc27sig00.setSzCdScrDataAction("A");
      rowccfc27sig00.setUlIdRecCheckRequestor(user.getUserID());
      rowccfc27sig00.setUlIdStage(GlobalData.getUlIdStage(request));
      rowccfc27sig00.setSzCdRecCheckCheckType(ContextHelper.getString(request, "selCdSearchType"));
      rowccfc27sig00.setSzCdRecCheckStatus(null);
      rowccfc27sig00
                    .setDtDtRecCheckCompleted(DateHelper
                                                        .toCastorDateSafe(ContextHelper.getStringSafe(request,
                                                                                                      "selDtCompleted")));
      rowccfc27sig00.setDtDtRecCheckRequest(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request,
                                                                                                    "selDtRequest")));
      rowccfc27sig00.setSzTxtRecCheckComments(ContextHelper.getStringSafe(request, "selComments"));

      // inserts for FingerPrintCheckData.
      rowccfc27sig00
                    .setSelDtCriminalReleaseReceived(DateHelper
                                                               .toCastorDateSafe(ContextHelper
                                                                                              .getStringSafe(request,
                                                                                                             "selDtCriminalReleaseReceived")));
      rowccfc27sig00
                    .setSelDtFingerprintCardGiven(DateHelper
                                                            .toCastorDateSafe(ContextHelper
                                                                                           .getStringSafe(request,
                                                                                                          "selDtFingerprintCardGiven")));
      rowccfc27sig00
                    .setSelDtFingerprintCardReturn(DateHelper
                                                             .toCastorDateSafe(ContextHelper
                                                                                            .getStringSafe(request,
                                                                                                           "selDtFingerprintCardReturn")));
      rowccfc27sig00
                    .setSelDtLiveScanPerformed(DateHelper
                                                         .toCastorDateSafe(ContextHelper
                                                                                        .getStringSafe(request,
                                                                                                       "selDtLiveScanPerformed")));
      rowccfc27sig00
                    .setSelDtLiveScanResultReceived(DateHelper
                                                              .toCastorDateSafe(ContextHelper
                                                                                             .getStringSafe(request,
                                                                                                            "selDtLiveScanResultReceived")));
      rowccfc27sig00.setCbFingerprintCard(ContextHelper.getStringSafe(request, "cbFingerprintCard"));
      rowccfc27sig00.setCbLiveScan(ContextHelper.getStringSafe(request, "cbLiveScan"));
      rowccfc27sig00
                    .setRbRefuseSignInvestigationClearance(ContextHelper
                                                                        .getStringSafe(request,
                                                                                       "rbRefuseSignInvestigationClearance"));
      rowccfc27sig00.setRbFingerPrintCkResult(ContextHelper.getStringSafe(request, "rbFingerPrintCkResult"));
      rowccfc27sig00.setRbRecommendation(ContextHelper.getStringSafe(request, "rbRecommendation"));

      rowccfc27sig00.setCIndRecCheckHistory(ContextHelper.getString(request, "rbHistory"));
    } else {
      // set up the updated of an existing row

      // SIR 23242 - instead of using the index of the array, use the records
      // check id, and then loop through the array to get the correct record to
      // update.

      // int index = ContextHelper.getIntSafe( request, "hdnIndex" );

      int ulIdRecCheck = ContextHelper.getIntSafe(request, "txtUlIdRecCheck");
      ROWCCFC26SOG00 recordsCheckRow = new ROWCCFC26SOG00();

      for (Enumeration listArrayEnum = listArray.enumerateROWCCFC26SOG00(); listArrayEnum.hasMoreElements();) {
        ROWCCFC26SOG00 rowccfc26sog00 = (ROWCCFC26SOG00) listArrayEnum.nextElement();
        if (ulIdRecCheck == rowccfc26sog00.getUlIdRecCheck()) {
          recordsCheckRow = rowccfc26sog00;
          break;
        }
      }
      // end SIR 23242

      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      rowccfc27sig00.setSzCdScrDataAction("U");
      
      /*SMS #37458 - Check to see if fingerprint results have been received and recorded.
       * If so, then set the indicator to Y.
       */
      String indFingerprintInfoAdded = ArchitectureConstants.N;
      String indFingerprintDateToUse = "";
      String cdStage = GlobalData.getSzCdStage(request);
      org.exolab.castor.types.Date dtFingerprintCardReturnPrevVal = recordsCheckRow.getSelDtFingerprintCardReturn();
      org.exolab.castor.types.Date dtLiveScanResultRecvdPrevVal = recordsCheckRow.getSelDtLiveScanResultReceived();
      org.exolab.castor.types.Date dtFingerprintCardReturnNewVal = DateHelper.toCastorDateSafe(ContextHelper
                                                                                               .getStringSafe(request, 
                                                                                                              "selDtFingerprintCardReturn"));
      org.exolab.castor.types.Date dtLiveScanResultRecvdNewVal = DateHelper.toCastorDateSafe(ContextHelper
                                                                                             .getStringSafe(request,
                                                                                                            "selDtLiveScanResultReceived"));
      if ((dtFingerprintCardReturnPrevVal == null && dtFingerprintCardReturnNewVal != null)) {
        indFingerprintDateToUse = REC_CHECK_FINGERPRINT_CARD;
        indFingerprintInfoAdded = ArchitectureConstants.Y;
      } else if (dtLiveScanResultRecvdPrevVal == null && dtLiveScanResultRecvdNewVal != null) {
        indFingerprintDateToUse = REC_CHECK_LIVE_SCAN;
        indFingerprintInfoAdded = ArchitectureConstants.Y;
      }
      rowccfc27sig00.setCIndFingerPrintInfoAdded(indFingerprintInfoAdded);
      rowccfc27sig00.setCIndFingerPrintDateToUse(indFingerprintDateToUse);
      rowccfc27sig00.setSzCdStage(cdStage);
      
      rowccfc27sig00.setTsLastUpdate(recordsCheckRow.getTsLastUpdate());
      rowccfc27sig00.setUlIdRecCheck(recordsCheckRow.getUlIdRecCheck());
      rowccfc27sig00.setUlIdRecCheckRequestor(recordsCheckRow.getUlIdRecCheckRequestor());
      rowccfc27sig00.setUlIdStage(recordsCheckRow.getUlIdStage());
      rowccfc27sig00.setSzCdRecCheckCheckType(ContextHelper.getString(request, "selCdSearchType"));
      rowccfc27sig00.setSzCdRecCheckEmpType(recordsCheckRow.getSzCdRecCheckEmpType());
      rowccfc27sig00.setSzCdRecCheckStatus(recordsCheckRow.getSzCdRecCheckStatus());
      rowccfc27sig00
                    .setDtDtRecCheckCompleted(DateHelper
                                                        .toCastorDateSafe(ContextHelper.getStringSafe(request,
                                                                                                      "selDtCompleted")));
      rowccfc27sig00.setDtDtRecCheckRequest(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request,
                                                                                                    "selDtRequest")));
      rowccfc27sig00.setCIndRecCheckHistory(ContextHelper.getString(request, "rbHistory"));

      // updates for FingerPrintCheckData.
      rowccfc27sig00
                    .setSelDtCriminalReleaseReceived(DateHelper
                                                               .toCastorDateSafe(ContextHelper
                                                                                              .getStringSafe(request,
                                                                                                             "selDtCriminalReleaseReceived")));
      rowccfc27sig00
                    .setSelDtFingerprintCardGiven(DateHelper
                                                            .toCastorDateSafe(ContextHelper
                                                                                           .getStringSafe(request,
                                                                                                          "selDtFingerprintCardGiven")));
      rowccfc27sig00.setSelDtFingerprintCardReturn(dtFingerprintCardReturnNewVal);
      rowccfc27sig00
                    .setSelDtLiveScanPerformed(DateHelper
                                                         .toCastorDateSafe(ContextHelper
                                                                                        .getStringSafe(request,
                                                                                                       "selDtLiveScanPerformed")));
      rowccfc27sig00.setSelDtLiveScanResultReceived(dtLiveScanResultRecvdNewVal);
      rowccfc27sig00.setCbFingerprintCard(ContextHelper.getStringSafe(request, "cbFingerprintCard"));
      rowccfc27sig00.setCbLiveScan(ContextHelper.getStringSafe(request, "cbLiveScan"));
      rowccfc27sig00
                    .setRbRefuseSignInvestigationClearance(ContextHelper
                                                                        .getStringSafe(request,
                                                                                       "rbRefuseSignInvestigationClearance"));
      rowccfc27sig00.setRbFingerPrintCkResult(ContextHelper.getStringSafe(request, "rbFingerPrintCkResult"));
      rowccfc27sig00.setRbRecommendation(ContextHelper.getStringSafe(request, "rbRecommendation"));

      rowccfc27sig00.setSzTxtRecCheckComments(ContextHelper.getStringSafe(request, "selComments"));
    }
    input.setUlPageSizeNbr(1);
    rowccfc27sig00_array.addROWCCFC27SIG00(rowccfc27sig00);
    ccfc27si.setROWCCFC27SIG00_ARRAY(rowccfc27sig00_array);
    ccfc27si.setArchInputStruct(input);
    ccfc27si.setUlIdRecCheckPerson(GlobalData.getUlIdPerson(request));
    ccfc27si.setUlIdStageRelated(GlobalData.getUlIdStage(request));
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return ccfc27si;
  }

  /**
   * This helper method populates row for a DELETE from the records_check table
   * 
   * @param context
   *          The GrndsExchangeContext object
   * @param indexRowToBeDeleted
   *          the index number of the row to be deleted in the array
   * @return ccfc27si
   * @throws MarshalException
   * @throws ValidationException
   */
  private CCFC27SI populateCCFC27SI_DELETE(GrndsExchangeContext context, int indexRowToBeDeleted)
                                                                                                 throws MarshalException,
                                                                                                 ValidationException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC27SI_DELETE()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    CCFC26SO ccfc26so = (CCFC26SO) state.getAttribute("CCFC26SO", request);
    if (ccfc26so == null) {
      ccfc26so = new CCFC26SO();
    }
    ROWCCFC26SOG00_ARRAY listArray = new ROWCCFC26SOG00_ARRAY();
    if (ccfc26so.getROWCCFC26SOG00_ARRAY() != null) {
      listArray = ccfc26so.getROWCCFC26SOG00_ARRAY();
    }
    ROWCCFC26SOG00 recordsCheckDeleteRow = listArray.getROWCCFC26SOG00(indexRowToBeDeleted);
    // new update object, array and row
    CCFC27SI ccfc27si = new CCFC27SI();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00_ARRAY rowccfc27sig00_array = new ROWCCFC27SIG00_ARRAY();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00 rowccfc27sig00 = new ROWCCFC27SIG00();
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    rowccfc27sig00.setSzCdScrDataAction("D");
    input.setUlPageSizeNbr(1);
    // bulid the row to be deleted from the original row
    rowccfc27sig00.setUlIdRecCheck(recordsCheckDeleteRow.getUlIdRecCheck());
    rowccfc27sig00.setTsLastUpdate(recordsCheckDeleteRow.getTsLastUpdate());
    rowccfc27sig00.setUlIdRecCheckRequestor(recordsCheckDeleteRow.getUlIdRecCheckRequestor());
    rowccfc27sig00.setUlIdRecCheck(recordsCheckDeleteRow.getUlIdRecCheck());
    rowccfc27sig00.setUlIdStage(recordsCheckDeleteRow.getUlIdStage());
    rowccfc27sig00.setSzCdRecCheckEmpType(recordsCheckDeleteRow.getSzCdRecCheckEmpType());
    rowccfc27sig00.setSzCdRecCheckStatus(recordsCheckDeleteRow.getSzCdRecCheckStatus());
    rowccfc27sig00.setSzCdRecCheckCheckType(recordsCheckDeleteRow.getSzCdRecCheckCheckType());
    rowccfc27sig00.setSzTxtRecCheckComments(recordsCheckDeleteRow.getSzTxtRecCheckComments());
    rowccfc27sig00.setDtDtRecCheckCompleted(recordsCheckDeleteRow.getDtDtRecCheckCompleted());
    rowccfc27sig00.setDtDtRecCheckRequest(recordsCheckDeleteRow.getDtDtRecCheckRequest());
    rowccfc27sig00.setCIndRecCheckHistory(recordsCheckDeleteRow.getCIndRecCheckHistory());
    rowccfc27sig00_array.addROWCCFC27SIG00(rowccfc27sig00);

    ccfc27si.setROWCCFC27SIG00_ARRAY(rowccfc27sig00_array);
    ccfc27si.setArchInputStruct(input);
    ccfc27si.setUlIdRecCheckPerson(GlobalData.getUlIdPerson(request));

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return ccfc27si;
  }

  /**
   * This helper method populates row for an update to the criminal_history table
   * 
   * @param context
   *          The GrndsExchangeContext object
   * @return ccfc32si
   * @throws MarshalException
   * @throws ValidationException
   */
  private CCFC32SI populateCCFC32SI_UPDATE(GrndsExchangeContext context) throws MarshalException, ValidationException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC32SI_UPDATE()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // create a new object for the select service
    CCFC31SO ccfc31so = (CCFC31SO) state.getAttribute("CCFC31SO", request);
    if (ccfc31so == null) {
      ccfc31so = new CCFC31SO();
    }
    // create selected array, object
    ROWCCFC31SOG00_ARRAY listCHArray = new ROWCCFC31SOG00_ARRAY();
    if (ccfc31so.getROWCCFC31SOG00_ARRAY() != null) {
      listCHArray = ccfc31so.getROWCCFC31SOG00_ARRAY();
    }

    // create update service object and array
    CCFC32SI ccfc32si = new CCFC32SI();
    ROWCCFC32SIG00_ARRAY updatedCH_Array = new ROWCCFC32SIG00_ARRAY();
    if (ccfc32si.getROWCCFC32SIG00_ARRAY() != null) {
      updatedCH_Array = ccfc32si.getROWCCFC32SIG00_ARRAY();
    }
    // new input structure for ccfc32si - set values for update

    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setSzUserId(user.getUserLogonID());

    int crimHistArrayLength = listCHArray.getROWCCFC31SOG00Count();

    input.setUlPageSizeNbr(crimHistArrayLength);
    // recreate the radio button names and comments names from the criminal history jsp
    String rowRbName;
    String rowCommentsName;
    String rbValue;

    // loop through the criminal history rows creating updated versions of the rows
    for (int i = 0; i < crimHistArrayLength; i++) {
      ROWCCFC31SOG00 criminalHistoryRow = listCHArray.getROWCCFC31SOG00(i);

      if (!"REJ".equals(criminalHistoryRow.getSzCdCrimHistAction())) {
        /*
         * if the row was already rejected, we dont want to send it to the update, because the service will fail. When
         * it was rejected the first time, the service deleted an associated row from the crimina_history_narrative
         * table. Attempting to save it a second time will cause a 1403 error on the service
         */

        // recreate the name of the radio button and comments for this row
        rowRbName = "rbAcpRej" + String.valueOf(i);
        rowCommentsName = "rowComments" + String.valueOf(i);
        // create updated row from the previous values and the jsp values
        ROWCCFC32SIG00 updatedCriminalHistoryRow = new ROWCCFC32SIG00();
        // previous row values - criminalHistoryRow
        // int ulIdRecCheck = Integer.parseInt( ( String ) state.getAttribute( "ulIdRecCheck", request ) );
        int index = ContextHelper.getIntSafe(request, "hdnIndex");
        // recreate object, array and row for records_check from the request
        CCFC26SO ccfc26so = (CCFC26SO) state.getAttribute("CCFC26SO", request);
        if (ccfc26so == null) {
          ccfc26so = new CCFC26SO();
        }
        ROWCCFC26SOG00_ARRAY listArray = new ROWCCFC26SOG00_ARRAY();
        if (ccfc26so.getROWCCFC26SOG00_ARRAY() != null) {
          listArray = ccfc26so.getROWCCFC26SOG00_ARRAY();
        }
        ROWCCFC26SOG00 recordsCheckRow = listArray.getROWCCFC26SOG00(index);
        if (recordsCheckRow == null) {
          recordsCheckRow = new ROWCCFC26SOG00();
        }
        int ulIdRecCheck = recordsCheckRow.getUlIdRecCheck();
        updatedCriminalHistoryRow.setTsLastUpdate(criminalHistoryRow.getTsLastUpdate());
        updatedCriminalHistoryRow.setUlIdCrimHist(criminalHistoryRow.getUlIdCrimHist());
        updatedCriminalHistoryRow.setUlIdRecCheck(ulIdRecCheck);
        updatedCriminalHistoryRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
        rbValue = (ContextHelper.getStringSafe(request, rowRbName));
        updatedCriminalHistoryRow.setSzCdCrimHistAction(rbValue);
        updatedCriminalHistoryRow.setSzNmCrimHistReturned(criminalHistoryRow.getSzNmCrimHistReturned());
        updatedCriminalHistoryRow.setSzTxtCrimHistCmnts(ContextHelper.getStringSafe(request, rowCommentsName));
        // If the new action is reject, cause the narrative to be deleted from the criminal_history_narrative table.
        if ("REJ".equals(rbValue)) {
          updatedCriminalHistoryRow.setCIndDeleteNarr("Y");
        } else {
          updatedCriminalHistoryRow.setCIndDeleteNarr(StringHelper.EMPTY_STRING);
        } // end if

        // place the row in the update array
        updatedCH_Array.addROWCCFC32SIG00(updatedCriminalHistoryRow);
      }
    } // end delete loop
    // set the array into the parent service
    ccfc32si.setROWCCFC32SIG00_ARRAY(updatedCH_Array);
    input.setUlPageSizeNbr(updatedCH_Array.getROWCCFC32SIG00Count());

    ccfc32si.setArchInputStruct(input);
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return ccfc32si;
  } // end populateCCFC32SI_UPDATE

  /**
   * This helper method populates rows for a display of rows from the records_check table for the subject of external
   * records checks
   * 
   * @param context
   *          The GrndsExchangeContext object
   * @param tuxPagination
   *          TuxedoPaginationValueBean
   * @return ccfc26si
   * @throws MarshalException
   * @throws ValidationException
   */
  private CCFC26SI populateCCFC26SI_RETRIEVE(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination)
                                                                                                                   throws MarshalException,
                                                                                                                   ValidationException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC26SI_RETRIEVE()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // define a new service object
    CCFC26SI ccfc26si = new CCFC26SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(PAGE_SIZE);

    ccfc26si.setArchInputStruct(input);
    // set id_rec_check_person
    ccfc26si.setUlIdRecCheckPerson(GlobalData.getUlIdPerson(request));

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return ccfc26si;

  } // end populateCCFC26SI_RETRIEVE

  /**
   * This helper method populates rows for a display of rows from the criminal_history table for the (DPS) records_check
   * row selected
   * 
   * @param context
   *          The GrndsExchangeContext object
   * @param tuxPagination
   *          TuxedoPaginationValueBean
   * @return ccfc31si
   * @throws MarshalException
   * @throws ValidationException
   */
  private CCFC31SI populateCCFC31SI_RETRIEVE(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination)
                                                                                                                   throws MarshalException,
                                                                                                                   ValidationException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC31SI_RETRIEVE()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    int index = ContextHelper.getIntSafe(request, "hdnIndex");
    CCFC26SO ccfc26so = (CCFC26SO) state.getAttribute("CCFC26SO", request);
    if (ccfc26so == null) {
      ccfc26so = new CCFC26SO();
    }
    ROWCCFC26SOG00_ARRAY listArray = new ROWCCFC26SOG00_ARRAY();
    if (ccfc26so.getROWCCFC26SOG00_ARRAY() != null) {
      listArray = ccfc26so.getROWCCFC26SOG00_ARRAY();
    }
    ROWCCFC26SOG00 recordsCheckRow = listArray.getROWCCFC26SOG00(index);
    // define a new input structure and service object
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    CCFC31SI ccfc31si = new CCFC31SI();
    // fields required for the service
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(PAGE_SIZE);

    ccfc31si.setArchInputStruct(input);
    ccfc31si.setUlIdRecCheck(recordsCheckRow.getUlIdRecCheck());

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return ccfc31si;
  } // end populateCCFC31SI_RETRIEVE

  /**
   * This helper method handles all the WTC Exceptions thrown by this conversation for CriminalHistory.
   *
   * @param we      WtcException
   * @param context The GrndsExchangeContext object
   */
  private void handleCHError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
    case Messages.MSG_DUPLICATE_RECORD:
      this.setPresentationBranch("error", context);
      String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD);
      setErrorMessage(errorMessage1, "/person/RecordsCheck/displayCriminalHistory", request);
      break;
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      this.setPresentationBranch("error", context);
      String errorMessage2 = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      setErrorMessage(errorMessage2, "/person/RecordsCheck/displayCriminalHistory", request);
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
   * This helper method handles all the WTC Exceptions thrown by this conversation for Records Check.
   *
   * @param we      WtcException
   * @param context The GrndsExchangeContext object
   */
  private void handleRCError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
    case Messages.MSG_DUPLICATE_RECORD:
      this.setPresentationBranch("error", context);
      String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD);
      setErrorMessage(errorMessage1, "/person/RecordsCheck/displayRecordsCheckList", request);
      break;
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      this.setPresentationBranch("error", context);
      String errorMessage2 = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      setErrorMessage(errorMessage2, "/person/RecordsCheck/displayRecordsCheckList", request);
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
