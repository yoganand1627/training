package gov.georgia.dhr.dfcs.sacwis.web.financials;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.financials.AdoptionAsstncValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.financials.AdoptionAsstnc;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD40SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

/**
 * Conversation class Name:    Adoption Assistance Conversation This is the Conversation class used to maintain subsidy
 * details on the Adoption Assistance page.  This includes code shamelessly stolen by:
 * <pre>
 * Change History:
 * Date      User           Description
 * --------  -------------  ---------------------------------------------------
 * 06/06/03  GRIMSHAN       SIR 16979 - Call event search to get the page mode.
 * 06/24/03  Eric Dickman   SIR 18490 - Changed the logic on how the Third Party Checkbox gets saved.
 * 07/01/03  thompswa       SIR 18367 - Added Error List logic to the handleSaveError() method as part of error
 *                                      message corrections involving changes to cfad39s.c as well.
 * 12/11/03  RIOSJA         SIR 19994 - Adoption Assistance Enhancement.
 * 03/17/04  thompswa       SIR 22674 - Exempt Medcaid only Types from ALOC requirement.
 * 03/18/04  thompswa       SIR 22775 - MSG_ADOPTION_ASSTNC_BLOC_REQ removed from ADD displayAdoptionAsstnc_xa.
 * 07/10/04  thompswa       SIR 16039 - Edit between start date of assistance and placement accomplished by
 *                                      adding new method, getPlacementWithGreatestStartDate, called in
 * saveAdoptionAsstnc_xa.
 * 09/21/04  thompswa       SIR 23066 - Adoption Assistance amount will now be edited against the ALOC rather
 *                                      than BLOC. Basic and moderate LOC is measured from CATHPLOC rather than
 *                                      CBILPLOC codes table. Messages and * MSG names adjusted.
 * 09/30/04  thompswa       SIR 23131 - Edit between start date of assistance and placement enhanced by adding
 *                                      new parameter to getPlacementWithGreatestStartDate, Integer resourceId.
 * 10/25/04  thompswa       SIR 18832 - To display the end date to the event descriptor and use the labels
 *                                      'Start' and 'End', handleEvent() method changed.
 * 10/25/08 mchillman                   Refactored page for ADO module   
 *                
 * 10/27/08 mchillman       STGAP00010841 Removed constraints on only allowing ado workers to add agreement
 * 11/14/08 ssubram         STGAP00011192 Setting the stage close indicator to state in order to prevent the
 *                                      Form to be edited for closed stage.
 * 03/25/09 hjbaptiste      STGAP00012941 - In populateCFAD40SI_AU() method, moved the CodesTables values to the left side of the 
 *                                          equality conditional statements to prevent an NPE  
 * 04/03/09 hjbaptiste      STGAP00012933 - Added the subitApproval_xa() method to save the page when the Approval Status button
 *                                          is clicked     
 *                                           
 * 05/14/09 bgehlot         STGAP00013779 - Added the completeAdoptionAsstnc_xa() method and the code to change the status of the 
 *                                          page to COMP status when Complete button is clicked  
 * 05/27/09 bgehlot         STGAP00013932 - Moved message MSG_NON_RECURRING_LIMIT from customvalidation to here.    
 * 05/30/09 bgehlot         STGAP00013930: Complete should take to agreement page not pullback list page      
 * 06/09/09 bgehlot         STGAP00014178 : Specialized rate should always override BR if approved.
 * 06/11/09 bgehlot         STGAP00014186: Error message 'Special Service Agreement exists for the attached 
 *                                         Application' will display on the Save and Complete buttons when the user attempts 
 *                                         to add a subsequent Agreement to an Application that already has a COMP Agreement.
 * 06/11/09 bgehlot         STGAP00014203: For the conversion data for the agreement which does not have id_spec_needs the page 
 *                          displays code in the Type/Class Dropdown whether it should display decode            
 * 06/12/09  bgehlot         STGAP00014203: For conversion data "Child has never been in permanent custody of DFCS (Non-Incident)" is displaying when it should not display
 *
 * 06/16/09  bgehlot        STGAP00013507: No Validation in COMP status      
 * 08/28/09  bgehlot        STGAP00014599: Since payment method for basic and specialized rates  are disabled, 
 *                          the payment method is set to PAR            
 * 01/08/10  mxpatel        STGAP00015702: Added code to display error message if the amount requiring is more than the amount approved by the application
 * 03/07/11  htvo           SMS#97845 MR-074-2 AFCARS: replaced incident or non-incident attention message to match with those in AAApplication
 *                          Incident/Non-Incident Status to be consistent between application and agreement since both pages are now using the same logic.
 *                          Removed old code that used childHasBeenInSubStage logic                                            
 * </pre>
 *
 * @author Wes Thompson, January 21, 2003
 */
public class AdoptionAsstncConversation extends BaseHiddenFieldStateConversation {
  public static final String ADOPTION_ASSTNC_PAGE = "AdoptionAsstnc";
  public static final String TRACE_TAG = "AdoptionAsstncConversation";
  /* Adoption Assistance - Contract Medicaid transaction types */
  public static final String MEDICAID_TRANS_TYPE_ADD = "ADD";
  public static final String MEDICAID_TRANS_TYPE_DEN = "DEN";
  public static final String MEDICAID_TRANS_TYPE_TRA = "TRA";
  /* Adoption Assistance definitions */
  public static final String ADP = "ADP";
  public static final String EVENT_TYPE_ADOPTION_SUBSIDY = "ADS";
  public static final String POST_ADOPTION_STAGE = "PAD";
  public static final String ADOPTION_STAGE = "ADO";
  public static final String ADOPTION_TASK = "9115";
  public static final String POST_ADOPTION_TASK = "9105";
  public static final String APRV_ADOPTION_TASK = "9116";
  public static final String APRV_POST_ADOPTION_TASK = "9106";
  public static final String SAVE_SUBMIT_BUTTON = "btnSaveSubmit";
  public static final String ADD = "A";
  public static final String UPDATE = "U";
  public static final String DISPLAY_PAGE = "/financials/AdoptionAsstnc/displayAdoptionAsstnc";
  public static final String DISPLAY_LIST_PAGE = "/financials/AdoptionAsstnc/displayAdoptionAsstncAppList";
  public static final String BRANCH_EVENT_LIST = "EventList";
  public static final String ADO_ASSIST_APP_EVENT_ID = "adopAssistApp";
  public static final String ADO_ASSIST_PULLBACK = "hdnAdoAssistReqPullBack";
  public static final String ADO_ASSIST_APP_TASK_PULLBACK = "hdnAdoAssistTaskBack";
  public static final String ADO_ASSIST_APP_TASK = "8610"; 
  public static final String ADO_ASSIST_APP_TASK_PAD = "9100";
  public static final String PAD_DISPLAY_MESSAGE = "padDisplayMessage";
  // SMS#97845 MR-074-2 AFCARS: use new logic for incident/non-incident child message. Remove old code.
  public static final String PAD_DISPLAY_MESSAGE_INCIDENT_CHILD = "This is an Incident/DFCS child.";   
  public static final String PAD_DISPLAY_MESSAGE_NON_INCIDENT_CHILD = "This is a Non-Incident child."; 
  //STGAP00011192
  public static final String IND_STAGE_CLOSE = "IND_STAGE_CLOSE";
  
  //STGAP00013779
  public static final String TYPE_OPTIONS = "typeOptions";
  public static final String COMPLETE_BUTTON = "btnCompletionCheck";

  private AdoptionAsstnc adoptionAsstnc;
  
  private Financials financials;
  
  public void setFinancials(Financials financials) {
    this.financials = financials;
  }
  public void setAdoptionAsstnc(AdoptionAsstnc adoptionAsstnc) {
    this.adoptionAsstnc = adoptionAsstnc;
  }

  /**
   * This method calls a Tuxedo service to display subsidy details.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void displayAdoptionAsstnc_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAdoptionAsstnc_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletResponse response = context.getResponse();

    try {
      
      String pageMode = PageMode.getPageMode(request);
      
      //The user needs to select a adoption assistance application before they can create an
      //adoption assistance agreement if the child has been a SUB stage
      //so if the adopAssistApp is empty then take them to the 
      //to the event list where the adoption assistance application list to select if not null allow them to
      //create the adoption assistance agreement
      
      //STGAP00013779: The Agreement should always be attached to the APRV Application with status Approved or Deferred.
      //STGAP00013930: Complete should take to agreement page not pullback list page
      if (ArchitectureConstants.TRUE.equals(request.getAttribute("adoPullBack"))) {
        CaseUtility.Stage stage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
        if(stage != null && CodesTables.CSTAGES_PAD.equals(stage.getCdStage())) {
          state.setAttribute(ADO_ASSIST_APP_TASK_PULLBACK, ADO_ASSIST_APP_TASK_PAD, request); 
        } else {
          state.setAttribute(ADO_ASSIST_APP_TASK_PULLBACK, ADO_ASSIST_APP_TASK, request); 
        }
          forward(DISPLAY_LIST_PAGE, request, response);
      }

      CFAD39SI cfad39si = populateCFAD39SI_Retrieve(context);

      // Temporarily store the page mode gotten out of state.
      // SIR 16979 get the page mode from event search conversation
      pageMode = EventSearchConversation.getEventDetailPageMode(request);
      PageMode.setPageMode(pageMode, request);

      CFAD39SO cfad39so =  financials.retrieveAdoptionSubsidy( cfad39si);

      
      state.setAttribute("CFAD39SO", cfad39so, request);
       
      // SMS#97845 MR-074-2 AFCARS: retrieve incident/non-incident from the AA application associated with the agreement
      String indIncidentChild = cfad39so.getCFAD39SOG00() == null ? StringHelper.EMPTY_STRING : cfad39so.getCFAD39SOG00().getCIndIncidentChildInPad();
      
      //07/14/2003, Matthew McClain, sometimes when navigating from a todo
      //the wrong task code will be in global data, but the right stage code
      //will be in there
      // SMS#97845 MR-074-2 AFCARS: only set the attention message if incident status was set in the associated application with this agreement
      // This removed the fix by STGAP00014203 to use BIndHasIntakeStage to further determine if child is non-incident 
      if (POST_ADOPTION_STAGE.equals(GlobalData.getSzCdStage(request))) {
        GlobalData.setSzCdTask(POST_ADOPTION_TASK, request);
        if(ArchitectureConstants.Y.equals(indIncidentChild)) {
          setInformationalMessage(PAD_DISPLAY_MESSAGE_INCIDENT_CHILD, DISPLAY_PAGE, request); 
        } else if(ArchitectureConstants.N.equals(indIncidentChild)) { 
            setInformationalMessage(PAD_DISPLAY_MESSAGE_NON_INCIDENT_CHILD, DISPLAY_PAGE, request); 
        }
      } else {
        GlobalData.setSzCdTask(ADOPTION_TASK, request);
      }
      //STGAP00011192: Setting the stage close indicator to state in order to prevent the
      //Form to be edited for closed stage
      CaseUtility.Stage stage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
      if (ArchitectureConstants.Y.equals(stage.getIndStageClose())){
        state.setAttribute(IND_STAGE_CLOSE, ArchitectureConstants.Y, request); 
      }else{
        state.setAttribute(IND_STAGE_CLOSE, ArchitectureConstants.N, request);
      }
      
    } catch (ServiceException we) {
      handleDisplayError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  /**
   * The method will forward to the event display to so that the user can select a 
   * an Adoption Assistance Application to tie to the agreement
   */
  public void displayAdoptionAsstncAppList_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    state.setAttribute(ADO_ASSIST_PULLBACK, ArchitectureConstants.TRUE, request);
  }

  /**
   * This helper method is called by the displayAdoptionAsstnc method to handle any WtcExceptions by setting the branch,
   * looking up the error message and setting it.
   *
   * @param we      The WtcException object.
   * @param context The GrndsExchangeContext object.
   */
  private void handleDisplayError(ServiceException we, GrndsExchangeContext context) {
    try {
      HttpServletRequest request = context.getRequest();
      String errorMessage;
      int errorCode = we.getErrorCode();
      switch (errorCode) {
        case Messages.MSG_ASV_NO_ACT_CNRCT:
        case Messages.MSG_ASV_NO_ASV_CONTRACT:
        case Messages.MSG_ASV_NO_PLCMT:
        case Messages.MSG_ASV_NO_CONTRACT:
        case Messages.MSG_ASV_NO_RESOURCE:
        case Messages.MSG_ASV_PERS_NO_RSRC:
        case Messages.MSG_DATABASE_RETRIEVE_FAIL:
        case Messages.MSG_FAD_NO_PAYEE_ADDR:
        case Messages.MSG_FAD_NO_PAYEE_VID:
          int[] errors = new int[] {errorCode};
          ErrorList.setErrors(errors, request);
          setPresentationBranch(BRANCH_EVENT_LIST, context);
          return;
        default:
          errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
          setPresentationBranch(BRANCH_EVENT_LIST, context);
          break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
  }
  
  
  /**
   * This method is called when the user clicks the Complete button on the Adoption Assistance Agreement page.
   *  This method calls the save function .
   * 
   * @param context -
   *                the GrndsExchangeContext object
   * @return void
   */
  public void completeAdoptionAsstnc_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".completeAdoptionAsstnc_xa()");

    try {
      saveAdoptionAsstnc_xa(context);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();

  }
  
  /**
   * This method is the main call for saving.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveAdoptionAsstnc_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAdoptionAsstnc_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);
    CFAD40SI cfad40si = null;
    CFAD40SO cfad40so = null;
    
    try {
      // ----------
      // SIR 19994 - This method was changed significantly for the Adoption
      // Assistance Enhancement. It now uses an EJB for validating the adoption
      // assistance amount.
      // ----------
      CFAD39SO cfad39so = (CFAD39SO) state.getAttribute("CFAD39SO", request);
      int personId = cfad39so.getUlIdPerson();
      int resourceId = cfad39so.getCFAD39SOG00().getUlIdAdptSubPayee();
      int eventId = GlobalData.getUlIdEvent(request);
      org.exolab.castor.types.Date adoptionAsstncStartDate = ContextHelper.getCastorDateSafe(request,
                                                                                             "txtDtDtAdptSubEffective");
     
      String errorMessage = "";
      
      //STGAP00013507: No Validation in COMP status 
      if(!CodesTables.CEVTSTAT_COMP.equals(cfad39so.getROWCCMN01UIG00().getSzCdEventStatus())){
        // SIR 16039 The assistance start month must not precede the placement
        // start month.
        org.exolab.castor.types.Date placementWithGreatestStartDate =
          adoptionAsstnc.getPlacementWithGreatestStartDate(personId, resourceId); // SIR 23131
        if (DateHelper.isBefore(adoptionAsstncStartDate, placementWithGreatestStartDate)) {
          int placementStartMonth = placementWithGreatestStartDate.getMonth();
          int placementStartYear = placementWithGreatestStartDate.getYear();
          int adoptionAsstncStartMonth = adoptionAsstncStartDate.getMonth();
          int adoptionAsstncStartYear = adoptionAsstncStartDate.getYear();
          if ((adoptionAsstncStartYear < placementStartYear) ||
                          (adoptionAsstncStartMonth < placementStartMonth)) {
            errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_ADOPTION_ASSTNC_PRE_PLCMT);
          }
        } // SIR 16039 thompswa End.
      }
      
      //STGAP00013779: Non-Recurring <type> Adoption Assistance Agreement for <amount> currently exists.
      String nonRecErrorMessage = StringHelper.EMPTY_STRING;
      cfad40si = populateCFAD40SI_AU(context);
      cfad40so = financials.checkForActiveNonRecAdoSubsidy(cfad40si);

      if(ArchitectureConstants.Y.equals(cfad40so.getBIndActiveNonRecurrAdopLegalFeesExists())){
        String nonRecurringMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_AGMT_NON_RECURR_EXISTS),
                                                                       Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, CodesTables.CSUBTYPE_22));
        nonRecErrorMessage = MessageLookup.addMessageParameter(nonRecurringMessage, FormattingHelper.formatMoney(cfad40so.getDAmtActiveNonRecurrAdopLegalFees()));
      }else if(ArchitectureConstants.Y.equals(cfad40so.getBIndActiveNonRecurrTravelExists())){
        String nonRecurringMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_AGMT_NON_RECURR_EXISTS),
                                                                       Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, CodesTables.CSUBTYPE_23));
        nonRecErrorMessage = MessageLookup.addMessageParameter(nonRecurringMessage, FormattingHelper.formatMoney(cfad40so.getDAmtActiveNonRecurrTravel()));
      }else if(ArchitectureConstants.Y.equals(cfad40so.getBIndActiveNonRecurrLogMealsExists())){
        String nonRecurringMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_AGMT_NON_RECURR_EXISTS),
                                                                       Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, CodesTables.CSUBTYPE_24));
        nonRecErrorMessage = MessageLookup.addMessageParameter(nonRecurringMessage, FormattingHelper.formatMoney(cfad40so.getDAmtActiveNonRecurrLogMeals()));
      }else if(ArchitectureConstants.Y.equals(cfad40so.getBIndActiveNonRecurrPhyAdopParentExists())){
        String nonRecurringMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_AGMT_NON_RECURR_EXISTS),
                                                                       Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, CodesTables.CSUBTYPE_25));
        nonRecErrorMessage = MessageLookup.addMessageParameter(nonRecurringMessage, FormattingHelper.formatMoney(cfad40so.getDAmtActiveNonRecurrPhyAdopParent()));
      }
      
       if(StringHelper.isNotEmptyOrNull(nonRecErrorMessage)){
        setInformationalMessage(nonRecErrorMessage, DISPLAY_PAGE ,request);
       }
     
       // If errors were encountered, display the error message; otherwise,
       // proceed with the save.
       if (errorMessage != null && !"".equals(errorMessage)) {
         setErrorMessage(errorMessage, request);
         setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
         return;
       }else if(ArchitectureConstants.Y.equals(cfad40so.getBIndOverSpendingLimit()) || ArchitectureConstants.Y.equals(cfad40so.getBIndOverSpendingLimitPad())){
         setErrorMessage(MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_NON_RECURRING_LIMIT),
                                                                             FormattingHelper.formatDouble(cfad40so.getDAmtNonRecLimit() , 2)), request);  
         setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
         return;
       }else {
         cfad40si = populateCFAD40SI_AU(context);
         cfad40so = financials.saveAdoptionSubsidy(cfad40si);
         eventId = (eventId > 0) ? eventId : cfad40so.getUlIdEvent();
         GlobalData.setUlIdEvent(eventId, request);
       }
    } catch (ServiceException we) {
      handleSaveError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This helper method is called by the saveAdoptionAsstnc method to handle any WtcExceptions by setting the branch,
   * looking up the error message and setting it.
   *
   * @param we      The WtcException object.
   * @param context The GrndsExchangeContext object.
   */
  private void handleSaveError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_ADOPTION_ASSTNC_PRE_PLCMT:
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_SVC_AUTH_REQ:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, request);
        break;
      case Messages.MSG_DATABASE_SAVE_FAIL:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
        break;
      case Messages.MSG_AGMT_BASIC_SPCLD_RATE_EXISTS:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_AGMT_BASIC_SPCLD_RATE_EXISTS, request);
        break;
      case Messages.MSG_AGMT_CHILD_CARE_EXISTS:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_AGMT_CHILD_CARE_EXISTS, request);
        break;
      case Messages.MSG_AGMT_RESPITE_EXISTS:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_AGMT_RESPITE_EXISTS, request);
        break;
      case Messages.MSG_AGMT_MEDICAID_ONLY_GA_CHILD_EXISTS:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_AGMT_MEDICAID_ONLY_GA_CHILD_EXISTS, request);
        break;
      case Messages.MSG_AGMT_MEDICAID_ONLY_GA_CHILD_OVERLAP:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_AGMT_MEDICAID_ONLY_GA_CHILD_OVERLAP,request);
        break;
      case Messages.MSG_AGMT_IVE_EXISTS:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_AGMT_IVE_EXISTS, request);
        break;
      case Messages.MSG_AGMT_IVB_EXISTS:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_AGMT_IVB_EXISTS, request);
        break;
      case Messages.MSG_AGMT_SPCL_SERV_EXISTS:
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_AGMT_SPCL_SERV_EXISTS, request);
        break;
      default:
        processSevereException(context, we);
      break;
    }
  }

  /**
   * This helper method is called by the populateCFAD40SI_AU which is called by the saveAdoptionAsstnc method to handle
   * the event record group.
   *
   * @param context The GrndsExchangeContext object.
   * @return save service input object for events
   */
  private ROWCCMN01UIG00 handleEvent(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleTxtEventDescr()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    //STGAP00013779: Added Complete button
    boolean bComplete = ContextHelper.getString(request, (COMPLETE_BUTTON+ ".x")) != null;

    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    CFAD39SO cfad39so = (CFAD39SO) state.getAttribute("CFAD39SO", request);

    String tmpSzCdTask = cfad39so.getROWCCMN01UIG00().getSzCdTask();
    String tmpSzCdEventStatus = cfad39so.getROWCCMN01UIG00().getSzCdEventStatus();
    String tmpDtDtAdptSubEffective =
            FormattingHelper.formatDate(ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubEffective"));
    String tmpDtDtAdptSubEnd =
            FormattingHelper.formatDate(ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubEnd"));
    String tmpSzCdAdptSubDeterm = ContextHelper.getStringSafe(request, "selSzCdAdptSubDeterm");

    // SET DEFINITION FOR RECORD GROUP ROWCCMN01UIG00
    rowccmn01uig00.setSzCdTask(tmpSzCdTask);
    rowccmn01uig00.setSzCdEventType(ADP);
    rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));
    rowccmn01uig00.setUlIdPerson(userProfile.getUserID());
    
    /*
    ** If NEW, setSzCdEventStatus to "PROC",setTsLastUpdate to today,
    ** setDtDtEventOccurred to today, setUlIdEvent to zero
    */
    java.util.Date d1 = new Date();
    if (PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
      rowccmn01uig00.setSzCdTask(GlobalData.getSzCdTask(request));
      rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
      rowccmn01uig00.setTsLastUpdate(d1);
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      rowccmn01uig00.setUlIdEvent(0);
    }
    if(bComplete) {
      rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
      rowccmn01uig00.setTsLastUpdate(cfad39so.getROWCCMN01UIG00().getTsLastUpdate());
      rowccmn01uig00.setDtDtEventOccurred(cfad39so.getROWCCMN01UIG00().getDtDtEventOccurred() != null ? cfad39so.getROWCCMN01UIG00().getDtDtEventOccurred() : DateHelper.getTodayCastorDate());
      rowccmn01uig00.setUlIdEvent(GlobalData.getUlIdEvent(request));
    } else {
      rowccmn01uig00.setTsLastUpdate(cfad39so.getROWCCMN01UIG00().getTsLastUpdate());
      rowccmn01uig00.setDtDtEventOccurred(cfad39so.getROWCCMN01UIG00().getDtDtEventOccurred()!= null ? cfad39so.getROWCCMN01UIG00().getDtDtEventOccurred() : DateHelper.getTodayCastorDate());
      rowccmn01uig00.setUlIdEvent(GlobalData.getUlIdEvent(request));
    }

    
    //STGAP00013779: Creating the Event Descriptions
    StringBuffer tmpSzTxtEventDescr = new StringBuffer();
    if ((tmpSzCdEventStatus != null)&& tmpSzCdEventStatus.equals(CodesTables.CEVTSTAT_PROC)) {
      if("".equals(tmpSzCdAdptSubDeterm)) {
        tmpSzTxtEventDescr.append("Adoption ");
        tmpSzTxtEventDescr.append("Assistance has been created for child " + cfad39so.getUlIdPerson());
      }else if ((CodesTables.CSUBTYPE_22).equals(tmpSzCdAdptSubDeterm) ||
                      (CodesTables.CSUBTYPE_23).equals(tmpSzCdAdptSubDeterm) || 
                      (CodesTables.CSUBTYPE_24).equals(tmpSzCdAdptSubDeterm) ||
                      (CodesTables.CSUBTYPE_25).equals(tmpSzCdAdptSubDeterm)) {
        tmpSzTxtEventDescr.append(Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, tmpSzCdAdptSubDeterm));
        tmpSzTxtEventDescr.append(" Assistance has been created for child " + cfad39so.getUlIdPerson());
      } else {
        tmpSzTxtEventDescr.append(Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, tmpSzCdAdptSubDeterm));
        tmpSzTxtEventDescr.append(" Assistance Start ");
        tmpSzTxtEventDescr.append(tmpDtDtAdptSubEffective);
        tmpSzTxtEventDescr.append(" End ");
        tmpSzTxtEventDescr.append(tmpDtDtAdptSubEnd);
        tmpSzTxtEventDescr.append(" for child " + cfad39so.getUlIdPerson());
      }
    } else if((tmpSzCdEventStatus != null)&& tmpSzCdEventStatus.equals(CodesTables.CEVTSTAT_COMP)) {
      if ((CodesTables.CSUBTYPE_22).equals(tmpSzCdAdptSubDeterm) ||
                      (CodesTables.CSUBTYPE_23).equals(tmpSzCdAdptSubDeterm) || 
                      (CodesTables.CSUBTYPE_24).equals(tmpSzCdAdptSubDeterm) ||
                      (CodesTables.CSUBTYPE_25).equals(tmpSzCdAdptSubDeterm)) {
        tmpSzTxtEventDescr.append(Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, tmpSzCdAdptSubDeterm));
        tmpSzTxtEventDescr.append(" Assistance has been created for child " + cfad39so.getUlIdPerson());
        tmpSzTxtEventDescr.append(" is Complete.");
      } else {
        tmpSzTxtEventDescr.append(Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, tmpSzCdAdptSubDeterm));
        tmpSzTxtEventDescr.append(" Assistance Start ");
        tmpSzTxtEventDescr.append(tmpDtDtAdptSubEffective);
        tmpSzTxtEventDescr.append(" End ");
        tmpSzTxtEventDescr.append(tmpDtDtAdptSubEnd);
        tmpSzTxtEventDescr.append(" for child " + cfad39so.getUlIdPerson());
        tmpSzTxtEventDescr.append(" is Complete.");
      }
    }else if(tmpSzCdEventStatus == null){
      if("".equals(tmpSzCdAdptSubDeterm)) {
        tmpSzTxtEventDescr.append("Adoption ");
        tmpSzTxtEventDescr.append("Assistance has been created for child " + cfad39so.getUlIdPerson());
      }else if ((CodesTables.CSUBTYPE_22).equals(tmpSzCdAdptSubDeterm) ||
                      (CodesTables.CSUBTYPE_23).equals(tmpSzCdAdptSubDeterm) || 
                      (CodesTables.CSUBTYPE_24).equals(tmpSzCdAdptSubDeterm) ||
                      (CodesTables.CSUBTYPE_25).equals(tmpSzCdAdptSubDeterm)) {
        tmpSzTxtEventDescr.append(Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, tmpSzCdAdptSubDeterm));
        tmpSzTxtEventDescr.append(" Assistance has been created for child " + cfad39so.getUlIdPerson());
      } else {
        tmpSzTxtEventDescr.append(Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, tmpSzCdAdptSubDeterm));
        tmpSzTxtEventDescr.append(" Assistance Start ");
        tmpSzTxtEventDescr.append(tmpDtDtAdptSubEffective);
        tmpSzTxtEventDescr.append(" End ");
        tmpSzTxtEventDescr.append(tmpDtDtAdptSubEnd);
        tmpSzTxtEventDescr.append(" for child " + cfad39so.getUlIdPerson());
      }
    }

    String eventDescr = tmpSzTxtEventDescr.toString();
    rowccmn01uig00.setSzTxtEventDescr((eventDescr.length() > 100 ? eventDescr.substring(0, 100) : eventDescr));
    
    //STGAP00013779: If Complete Button is clicked change to COMP status
    if (bComplete) {
      tmpSzCdEventStatus = CodesTables.CEVTSTAT_COMP;
    } else{
      tmpSzCdEventStatus = CodesTables.CEVTSTAT_PROC;
    }
    
    ////STGAP00013779: If the page is saved with the COMP status the status should remain COMP not change to COMP
    if (CodesTables.CEVTSTAT_COMP.equals(cfad39so.getROWCCMN01UIG00().getSzCdEventStatus())) {
      tmpSzCdEventStatus = CodesTables.CEVTSTAT_COMP;
    }
     
    rowccmn01uig00.setSzCdEventStatus(tmpSzCdEventStatus);
    performanceTrace.exitScope();
    return rowccmn01uig00;
  }

  /**
   * Populating SI object cfad39si from the context. All population from the context (including request, session, and
   * state). The method should instantiate the input object, get values out of the context, and then return the SI
   * object.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   * @return display service input object
   */
  private CFAD39SI populateCFAD39SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD39SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CFAD39SI cfad39si = new CFAD39SI();

    cfad39si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    cfad39si.setUlIdStage(GlobalData.getUlIdStage(request));
    cfad39si.setUlIdCase(GlobalData.getUlIdCase(request));
    cfad39si.setUlIdPerson(getUserID(request));
    

    //get the event id from the adoption assistance application for new agreements
    if((ADO_ASSIST_APP_TASK.equals(state.getAttribute(ADO_ASSIST_APP_TASK_PULLBACK, request))) || (ADO_ASSIST_APP_TASK_PAD.equals(state.getAttribute(ADO_ASSIST_APP_TASK_PULLBACK, request)))) {
      int actionEventId = ContextHelper.getIntSafe(request, "actionEventId");
      cfad39si.setUlIdSpecialNeedsEvent(actionEventId);
      PageMode.setPageMode(PageModeConstants.NEW, request);
      state.removeAttribute(ADO_ASSIST_PULLBACK, request);
      state.removeAttribute(ADO_ASSIST_APP_TASK_PULLBACK, request);
    }else{
      CFAD39SO cfad39so = (CFAD39SO)state.getAttribute("CFAD39SO", request);
      if(cfad39so != null){
        cfad39si.setUlIdSpecialNeedsEvent(cfad39so.getCFAD39SOG00().getUlIdSpecialNeedsEvent());
      }
    }
    performanceTrace.exitScope();
    return cfad39si;
  }

  /**
   * Called by the saveAdoptionAsstnc_xa activity method to populate the input object for the Adoption Assistance AU
   * service.
   *
   * @param context The GrndeExchangeContext object.
   * @return save service input object
   */
  private CFAD40SI populateCFAD40SI_AU(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD40SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CFAD40SI cfad40si = new CFAD40SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());

    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    CFAD40SIG00 cfad40sig00 = new CFAD40SIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    CFAD39SO cfad39so = (CFAD39SO) state.getAttribute("CFAD39SO", request);

    // Set save object fields person (ulIdPerson), case (ulIdCase),
    // placement event (ulIdPlcmtEvent), stage name (szNmStage),
    // Medicaid update type (szCdMedUpdType), Med transfer type (szCdMedUpdTransTypE)
    // to the save object, CFAD40SI.
    // Populate the input object sub-structures from the request.
    if (GlobalData.getUlIdEvent(request) == 0) {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }

    cfad40si.setArchInputStruct(input);
    cfad40si.setROWCCMN01UIG00(rowccmn01uig00);
    cfad40si.setCFAD40SIG00(cfad40sig00);
    cfad40si.setUlIdPerson(cfad39so.getUlIdPerson());
    cfad40si.setUlIdCase(cfad39so.getUlIdCase());
    cfad40si.setUlIdPlcmtEvent(cfad39so.getUlIdPlcmtEvent());
    cfad40si.setSzNmStage(GlobalData.getSzNmStage(request));
    cfad40si.setBSysIndGeneric(cfad39so.getCFAD39SOG00().getBSysIndGeneric());

    // Set ToDo's to save request object
    // Pass the Dummy Event indicator to compensate for Dummy Event possibilities,
    // if the Event Status is NEW and the idEvent is not zero, then set the Page Mode
    // to NEW and set the indicator that this Record is associated with a ToDo.
    if (CodesTables.CEVTSTAT_NEW.equals(cfad39so.getROWCCMN01UIG00().getSzCdEventStatus()) &&
        GlobalData.getUlIdEvent(request) != 0) {
      PageMode.setPageMode(PageModeConstants.NEW, request);
      cfad40si.setBSysIndUserTodo(ArchitectureConstants.Y);
    }else{
      cfad40si.setBSysIndUserTodo(ArchitectureConstants.N);
    }

    /** @todo do we need to set all of these?
     * Has the subsidy agreement for <stage name> been received?           FAD040
     * Has the subsidy application for <stage name> been received?         FAD037
     * You must complete the subsidy details or close the subsidy.         FAD041
     * The adoption subsidy for {Stage name} must be closed.               FAD042
     * A new adoption subsidy period for {Stage Name} needs to be created. FAD038
     *  It creates FAD041 which may no longer be relevant; Karl?
     * **/

    //FAD037 - Has the subsidy application for <stage name> been received?
    cfad40si.setCSysIndAppSent(ArchitectureConstants.N);
    if ((cfad39so.getCFAD39SOG00().getDtDtAdptSubAppSent() != null)) {
      cfad40si.setCSysIndAppSent(ArchitectureConstants.Y);
    }
    //FAD040 - Has the subsidy agreement for <stage name> been received?
    cfad40si.setCSysIndAgreeSent(ArchitectureConstants.N);
    if (cfad39so.getCFAD39SOG00().getDtDtAdptSubAgreeSent() != null) {
      cfad40si.setCSysIndAgreeSent(ArchitectureConstants.Y);
    }
    //FAD041 - You must complete the subsidy details or close the subsidy.
    cfad40si.setCSysIndAgreeRtn(ArchitectureConstants.N);
    if (cfad39so.getCFAD39SOG00().getDtDtAdptSubAgreeRetn() != null) {
      cfad40si.setCSysIndAgreeRtn(ArchitectureConstants.Y);
    }

    //When this indicator is N, it creates todos for FAD042 and FAD038
    // 90 days before the assistance/subsidy end date
    //FAD042 - The adoption subsidy for {Stage name} must be closed.
    //FAD038 - A new adoption subsidy period for {Stage Name} needs to be created.
    cfad40si.setCSysIndSubEnd(ArchitectureConstants.N);
    if (cfad39so.getCFAD39SOG00().getDtDtAdptSubEnd() != null) {
      cfad40si.setCSysIndSubEnd(ArchitectureConstants.Y);
    }

    //  Medicaid Certification Processing.
    String predisplayType = cfad39so.getCFAD39SOG00().getSzCdAdptSubDeterm();
    if(predisplayType == null){
      predisplayType = "";
    }
    String dateEffective = FormattingHelper.formatDate(cfad39so.getCFAD39SOG00().getDtDtAdptSubEffective());
    String submitType = request.getParameter("selSzCdAdptSubDeterm");

    if ((CodesTables.CSUBTYPE_01.equals(submitType) ||
         CodesTables.CSUBTYPE_05.equals(submitType) ||
         CodesTables.CSUBTYPE_07.equals(submitType) ||
         CodesTables.CSUBTYPE_11.equals(submitType) ||
         CodesTables.CSUBTYPE_13.equals(submitType) ||
         CodesTables.CSUBTYPE_15.equals(submitType) ||
         CodesTables.CSUBTYPE_06.equals(submitType) ||
         CodesTables.CSUBTYPE_12.equals(submitType)) &&
                                                     ("".equals(dateEffective) &&
                                                      !("".equals(request.getParameter("txtDtDtAdptSubEffective"))))) {
      cfad40si.setSzCdMedUpdType(EVENT_TYPE_ADOPTION_SUBSIDY);
      cfad40si.setSzCdMedUpdTransTypE(MEDICAID_TRANS_TYPE_ADD);
    } /*END IF*/

    //        ** else subsidy change processing to check for a change of the
    //        ** adoption subsidy type. Use the original value of the Subsidy
    //        ** Type for comparison.

    else if ((submitType.equals(cfad39so.getCFAD39SOG00().getSzCdAdptSubDeterm()) &&
              (CodesTables.CSUBTYPE_01.equals(submitType) ||
               CodesTables.CSUBTYPE_05.equals(submitType) ||
               CodesTables.CSUBTYPE_07.equals(submitType) ||
               CodesTables.CSUBTYPE_11.equals(submitType) ||
               CodesTables.CSUBTYPE_13.equals(submitType) ||
               CodesTables.CSUBTYPE_15.equals(submitType) ||
               CodesTables.CSUBTYPE_06.equals(submitType) ||
               CodesTables.CSUBTYPE_12.equals(submitType)))
             ||
             ((CodesTables.CSUBTYPE_01.equals(predisplayType) ||
               CodesTables.CSUBTYPE_05.equals(predisplayType) ||
               CodesTables.CSUBTYPE_07.equals(predisplayType) ||
               CodesTables.CSUBTYPE_11.equals(predisplayType) ||
               CodesTables.CSUBTYPE_13.equals(predisplayType) ||
               CodesTables.CSUBTYPE_15.equals(predisplayType) ||
               CodesTables.CSUBTYPE_06.equals(predisplayType) ||
               CodesTables.CSUBTYPE_12.equals(predisplayType))

              && !StringHelper.isValid(request.getParameter("txtSzCdAdptSubCloseRsn")))) {
      cfad40si.setSzCdMedUpdType(EVENT_TYPE_ADOPTION_SUBSIDY);
      cfad40si.setSzCdMedUpdTransTypE(MEDICAID_TRANS_TYPE_TRA);
    }

    //
    //  else if perform medicaid eligiblity ends processing.
    //
    else if ((CodesTables.CSUBTYPE_01.equals(submitType) ||
              CodesTables.CSUBTYPE_05.equals(submitType) ||
              CodesTables.CSUBTYPE_07.equals(submitType) ||
              CodesTables.CSUBTYPE_11.equals(submitType) ||
              CodesTables.CSUBTYPE_13.equals(submitType) ||
              CodesTables.CSUBTYPE_15.equals(submitType) ||
              CodesTables.CSUBTYPE_06.equals(submitType) ||
              CodesTables.CSUBTYPE_12.equals(submitType))
             && (!"".equals(request.getParameter("txtSzCdAdptSubCloseRsn"))
                 && ("".equals(cfad39so.getCFAD39SOG00().getSzCdAdptSubCloseRsn())))) {
      cfad40si.setSzCdMedUpdType(EVENT_TYPE_ADOPTION_SUBSIDY);
      cfad40si.setSzCdMedUpdTransTypE(MEDICAID_TRANS_TYPE_DEN);
    }
    
    double amtAdptSub = ContextHelper.getMoneyAsDoubleSafe(request, "txtSAmtAdptSub");
    if((amtAdptSub == 0.0)){
      amtAdptSub = ContextHelper.getMoneyAsDoubleSafe(request, "txtSAmtAdptSub_Disabled");
    }
    //STGAP00013779 for basic rate
    if ((amtAdptSub == 0.0) && (CodesTables.CSUBTYPE_01.equals(submitType) ||
                    CodesTables.CSUBTYPE_03.equals(submitType) ||
                    CodesTables.CSUBTYPE_07.equals(submitType) ||
                    CodesTables.CSUBTYPE_09.equals(submitType)) && 
                    (ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBIndBasicRateReq())
                      && ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBIndSpcNeedsApproved()))) {
      amtAdptSub = ContextHelper.getMoneyAsDoubleSafe(request, "hdnBaseRate");
    }
    //STGAP00013779: For Specialized rate
    if ((amtAdptSub == 0.0) && (CodesTables.CSUBTYPE_01.equals(submitType) ||
                    CodesTables.CSUBTYPE_03.equals(submitType) ||
                    CodesTables.CSUBTYPE_07.equals(submitType) ||
                    CodesTables.CSUBTYPE_09.equals(submitType)) && 
                    (ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBIndSpecializedRateReq())
                      && ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBIndSpclRateAdoAppr()))) {
      amtAdptSub = cfad39so.getCFAD39SOG00().getSzSpcRtAprvAmt();
    }
    
    //STGAP00014178 : Specialized rate should always override BR if approved.  
    if ((CodesTables.CSUBTYPE_01.equals(submitType) ||
                    CodesTables.CSUBTYPE_03.equals(submitType) ||
                    CodesTables.CSUBTYPE_07.equals(submitType) ||
                    CodesTables.CSUBTYPE_09.equals(submitType)) && 
                    (ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBIndSpecializedRateReq())
                      && ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBIndSpclRateAdoAppr()))&& 
                      (ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBIndBasicRateReq())
                       && ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBIndSpcNeedsApproved()))) {
      amtAdptSub = cfad39so.getCFAD39SOG00().getSzSpcRtAprvAmt();
    }
    
    //STGAP00013779 for special services
    if ((amtAdptSub == 0.0) && (CodesTables.CSUBTYPE_10.equals(submitType) ||
                    CodesTables.CSUBTYPE_18.equals(submitType) ||
                    CodesTables.CSUBTYPE_21.equals(submitType) ||
                    CodesTables.CSUBTYPE_28.equals(submitType)||
                    CodesTables.CSUBTYPE_29.equals(submitType)||
                    CodesTables.CSUBTYPE_30.equals(submitType)) && 
                    (ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBIndSpclServiceReq())
                      && ArchitectureConstants.Y.equals(cfad39so.getCFAD39SOG00().getBIndSpclReqApproved()))) {
      amtAdptSub = cfad39so.getCFAD39SOG00().getSzSpcSvcAprvAmt();
    }

    // DEFINITION FOR RECORD.ROWCCMN01UIG00
    // - set result from handleEvent() to save request object
    cfad40si.setROWCCMN01UIG00(handleEvent(context));
    // DEFINITION FOR RECORD.ROWCCMN01UIG01 - POST EVENT PERSON
    rowccmn01uig01.setUlIdPerson(0);
    rowccmn01uig01.setSzCdScrDataAction("");
    java.util.Date d2 = new Date();
    rowccmn01uig01.setTsLastUpdate(d2);

    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    // DEFINITION FOR RECORD Group.CFAD39SOG00 - ADPT SUB HDR RTRV
    cfad40sig00.setDtDtAdptSubAgreeRetn(ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubAgreeRetn"));
    cfad40sig00.setUlIdAdptSub(cfad39so.getCFAD39SOG00().getUlIdAdptSub());
    cfad40sig00.setDtDtAdptSubLastInvc(cfad39so.getCFAD39SOG00().getDtDtAdptSubLastInvc());
    cfad40sig00.setUlIdAdptSubPayee(cfad39so.getCFAD39SOG00().getUlIdAdptSubPayee());
    cfad40sig00.setDtDtAdptSubAgreeSent(ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubAgreeSent"));
    cfad40sig00.setDtDtAdptSubAppReturned(ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubAppReturned"));
    cfad40sig00.setDtDtAdptSubAppSent(ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubAppSent"));
    cfad40sig00.setDtDtAdptSubApprvd(ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubApprvd"));
    cfad40sig00.setDtDtAdptSubEffective(ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubEffective"));
    cfad40sig00.setDtDtAdptSubEnd(ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubEnd"));
    cfad40sig00.setSAmtAdptSub(amtAdptSub);
    cfad40sig00.setSzTxtAdptSubRsn(ContextHelper.getStringSafe(request, "txtSzTxtAdptSubRsn"));
    cfad40sig00.setSzCdAdptSubCloseRsn(ContextHelper.getStringSafe(request, "txtSzCdAdptSubCloseRsn"));
    cfad40sig00.setDtDtRenwlEffBegin(ContextHelper.getCastorDateSafe(request, "txtDtDtRenwlEffBegin"));
    cfad40sig00.setDtDtRenwlEffEnd(ContextHelper.getCastorDateSafe(request, "txtDtDtRenwlEffEnd"));
    cfad40sig00.setSAmtSpclAsstReq(ContextHelper.getMoneyAsDoubleSafe(request, "txtSAmtSpclAsstReq"));
    cfad40sig00.setSzTxtSpclAsstSpecify(ContextHelper.getStringSafe(request, "txtSzTxtSpclAsstSpecify"));
    cfad40sig00.setSzCdSpclAsstType(ContextHelper.getStringSafe(request, "txtSzCdSpclAsstType"));
    cfad40sig00.setDtDtAdptSubTerm(ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubTerminated"));
    cfad40sig00.setCIndSchoolVerified(ContextHelper.getStringSafe(request, "cbxCIndAdptSchoolVerified"));
    cfad40sig00.setSzCdPlaymentMthd(ContextHelper.getStringSafe(request, "txtSzCdPaymentMethod"));
    // STGAP00014599: Since payment method for basic and specialized rates  are disabled, 
    // the payment method is set to PAR
    if((submitType.equals(CodesTables.CSUBTYPE_01) || submitType.equals(CodesTables.CSUBTYPE_03) ||
                    submitType.equals(CodesTables.CSUBTYPE_07) || submitType.equals(CodesTables.CSUBTYPE_09))){
      cfad40sig00.setSzCdPlaymentMthd(CodesTables.CPAYMTHD_PAR);
    }
    cfad40sig00.setSzCdAllNonIncidentSSA(ContextHelper.getStringSafe(request, "cIndNonSSA"));
    cfad40sig00.setUlIdSpecialNeedsEvent(ContextHelper.getIntSafe(request, "hdnSpecialNeedsEvent"));
    
    //SIR 18490-- Changed the logic on how the Third Party Checkbox gets saved.
    if ("Y".equals(ContextHelper.getStringSafe(request, "cbxCIndAdptSubThirdParty")))
    {
      cfad40sig00.setCIndAdptSubThirdParty(ArchitectureConstants.Y);
    } else {
      cfad40sig00.setCIndAdptSubThirdParty(ArchitectureConstants.N);
    }
    
    if ("Y".equals(ContextHelper.getStringSafe(request, "cIndSauConf")))
    {
      cfad40sig00.setCIndSauConf(ArchitectureConstants.Y);
    } else {
       cfad40sig00.setCIndSauConf(ArchitectureConstants.N);
    }
    
    if ("Y".equals(ContextHelper.getStringSafe(request, "cIndSpclAsstApprvl")))
    {
     cfad40sig00.setCIndSpclAsstApprvl(ArchitectureConstants.Y);
    } else {
      cfad40sig00.setCIndSpclAsstApprvl(ArchitectureConstants.N);
    }
    
    // Pass the Adoption Subsidy Process Indicator through from retrieve to Save.  When
    // creating a new event it will be set to N in the Save Service.
    cfad40sig00.setCIndAdptSubProcess(ContextHelper.getStringSafe(request, "cIndAdptSubProcess"));
    cfad40sig00.setSzCdAdptSubDeterm(ContextHelper.getStringSafe(request, "selSzCdAdptSubDeterm"));
    Date tsLastUpdted = cfad39so.getCFAD39SOG00().getTsLastUpdate();
    cfad40sig00.setTsLastUpdate(tsLastUpdted != null ? tsLastUpdted : new Date());
    performanceTrace.exitScope();
    return cfad40si;
  }
  
  private boolean hasChildBeenInSUBStage(GrndsExchangeContext context) {
    Integer count = financials.retrieveSubStageCount(populateCFAD39SI_Retrieve(context));
    return (count != null && count.intValue() > 0) ? true : false;
  }

}
