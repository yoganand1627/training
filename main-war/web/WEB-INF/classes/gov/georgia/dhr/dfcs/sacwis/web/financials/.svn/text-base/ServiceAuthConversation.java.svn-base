package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON23SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON18SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON18SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to maintain Service Authorization Information in the system. <p/> February 17,
 * 2003 Anna N. Grimshaw <p/>
 * 
 * <pre>
 *               Change History:
 *                Date        User      Description
 *                ----------  --------  --------------------------------------------------
 *                04/30/03    GRIMSHAN  SIR #16988 Changed CCON23_AU populate method so that
 *                                      the Person Row retrieved from the array is based in the
 *                                      cbxValues[i] not just i
 *               &lt;p/&gt;
 *                05/01/03    GRIMSHAN  SIR #16978 In display Service Auth Header, added a check
 *                                      for if the Event is approval Status, and the stage is not
 *                                      closed, and the person has stage access, or the person has
 *                                      maintain service auth the page mode will be set to modify.
 *               &lt;p/&gt;
 *                05/05/03    GRIMSHAN  SIR #17170 In dispaly Serivce Auth Header, added a line
 *                                      to clear CCON20SO from state.  This was done so that after
 *                                      the page re-displays itself, when the user clicks save,
 *                                      the resource search object will not be available and the
 *                                      information will be set from ccon18so in populate ccon19si
 *               &lt;p/&gt;
 *                05/10/2003  KRD       SIR 17233 - Code changes applied to support
 *                                      &quot;Approver Mode&quot; providing supervisors the ability to
 *                                      modify data without invalidating the pending
 *                                      approval.  Required changes to populateCCON19SI_AU().
 *               &lt;p/&gt;
 *                05/12/03    GRIMSHAN  SIR 17414 - Changed the populate method for ccon25 so that
 *                                      a new row will be initialized in the for loop.
 *               &lt;p/&gt;
 *                05/29/03    GRIMSHAN  SIR 17832 - When the page is accessed, if the id event
 *                                      is not 0 and the event status is new, set the page mode to
 *                                      new
 *               &lt;p/&gt;
 *                06/05/03    GRIMSHAN  SIR 16979 When accessed from Event list, the page mode
 *                                      will be retrieved from an event list function.
 *               &lt;p/&gt;
 *                06/12/03    GRIMSHAN  SIR 18105 If the page is accessed from a task todo that
 *                                      has not generated an event, re-set page mode to add,
 *                                      and call add service auth header
 *               &lt;p/&gt;
 *                06/23/03    GRIMSHAN  SIR 18408 Added breaks after displaying message so that
 *                                      the message will not be displayed more than once.
 *               &lt;p/&gt;
 *                07/24/03    GRIMSHAN  SIR 18309 If the stage is closed, and the user has
 *                                      SEC_MNTN_SVC_AUTH, ignore the MSG_CON_NO_CLIENT_FACTOR message
 *                                      from the service.
 *               &lt;p/&gt;
 *                12/30/03    OCHUMD    SIR 19989 Added MSG_SVC_AUTH_NO_PLCMT to handle the no plcmt.
 *                                      for the service codes.
 *               &lt;p/&gt;
 *                05/04/04    CORLEYAN  SIR 19608 - Display Suffix with full name in Service Auth Header
 *               &lt;p/&gt;
 *                07/19/04    CORLEYAN  SIR 22573 - Added New Using functionality for Service Auth Detail
 *               &lt;p/&gt;
 *                02/01/05    CORLEYAN  SIR 23361 - Fixed Page mode for users with Maintain Service Auth
 *                                      security.
 *               &lt;p/&gt;
 *                04/20/05    CORLEYAN  SIR 23538 - Added logic for Donated Community Service Service
 *                                      Auth type. This new type will not have contracts associated
 *                                      with them, so there are a few changes to how the resource
 *                                      is pulled back as well as how it is saved.
 *               &lt;p/&gt;
 *                07/05/05    OCHUMD    SIR 23712 - APS Reform R2 - Added code to allow CRSR
 *                                      Service Authorizations for C-REG stage types to be added
 *                                      without a factor on the Outcome Matrix page.
 *               &lt;p/&gt;
 *                07/28/05    Ochumd    Sir23801 - C-GUA is now included as is C-REG in sir 23712.
 *               &lt;p/&gt;
 *                08/18/05    thompswa  SIR 23662 -  Prevent Detail save for Service CSVCCODE_96K
 *                                      if child legal status not '090', Adoption Consummated.
 *                                      placement living arrangement not &quot;GT&quot; or &quot;71&quot; and
 *                                      pageMode NEW.
 *               &lt;p/&gt;
 *               06/15/2008   mchillman STGAP00004726 - Added additional text for event message
 *               
 *               1/5/2009     cwells    STGAP00008763 - Displaying the MSG_CON_NO_ACTIVE_CONTRACT message on the Service Authorization
 *                                                      page instead of the displaying the error message page when there is no contract county
 *                                                      within the svc auth date.
 *               01/19/2009   mchillman STGAP00012078:or adoption service codes: 51257 and 51277 should follow the normal service code search 
 *                                      criteria and also look specifically for resources of type Home/Other Facility and facility type CPA 
 *               03/10/2009   cwells    STGAP00012441- Allowing the page to display correctly when a service code has been end dated.    
 *               03/17/2009   arege     STGAP00012907 - Caught ServiceException thrown in Retrieve Service to resolve a System Error.
 *               06/02/2009   bgehlot   STGAP00009780:  The event description: [UAS Code]  [Entitlement Code/Decode]; Resource: [name of resource]; 
 *                                                      for [name of person selected from detail page] or Multiple Persons [if more than one person 
 *                                                      is selected on Detail page].
 *               06/11/2009   mxpatel   STGAP00013508: populated the new hidden attribute- "hdnSzCdSvcAuthDtlAuthType" to the ccon23si object to 
 *                                                     pass it onto the service
 *               08/14/2009   arege     STGAP00013203   For Service Code of 512 , resources of type Provider (01) and 
 *                                                     Type Home/Other (06) with Facility type of CPA (CP) should be available.
 *               09/17/2008   cwells     STGAP00013384 Avoid throwing error if the code is not in the excludeViews HashSet 
 *                                                     only because it is expired(end dated).    
 *               12/30/2009   mchillman  Change to support performing full search from SerAuth page for Ado 510 - 512 service codes     
 *               12/30/2009   mchillman  Change to support bring up ado app list for Ado 510 - 512 service codes     
 *               01/07/2010   arege      STGAP00015696 MR-52 Validations for Service Auth  Detail Pages. 
 *               01/08/2010   mxpatel    STGAP00015702: Added code to display error message if the amount requiring is more than the amount approved by the application
 *               01/08/2010   arege      STGAP00015696: MR-52 Wrote method displayInformationalMessage() to eliminate repeated code   
 *               01/11/2010   arege      STGAP00015696: Added condition to call displayInformationalMessage() only for 512 service codes  
 *               01/11/2010   mchillman  STGAP00015696: MR52 restrict service code display for srvc auth associated to ado applications
 *               01/27/2010   mxpatel    SMS #44087: Added code to display error message if the amount requiring is more than the amount approved by the application
 *               02/10/2010   mxpatel    SMS #44084: Added validations to display an information message - Non-Recurring <type> Adoption Assistance for <amount> currently exists
 *               02/15/2010   mxpatel    SMS #45285: Modified the code so that when selecting the Select Resource button the Resource Type field defaults to the 'Home/Other Facility' 
 *                                       option regardless of UAS/Entitlement Code selected.
 *               02/18/2010   mxpatel    SMS #45426:  Modified the code to remove non required code.  
 *               02/21/2010   mxpatel    SMS #44052: added code so that 512 can only be added in ADO or PAD stage.                   
 *               03/02/2010   mxpatel    SMS #44084: Modified the code to populate correct amount value.    
 *               03/05/2010   mxpatel    SMS #46734: added code to catch exception MSG_CON_NO_ACTIVE_SERVICE
 *               03/18/2010   arege      SMS#48233 The Resource Type should default to home only for 510, 512 and 531 UAS/Entitlement codes and should default to 
 *                                       Provider for others
 *               03/19/2010   arege      SMS#48357 For 512 category and service codes of 57 and 77, the Select Resource button should lead to Search Results page with all Providers
 *               03/28/2010   arege      For category 531 the Select Resource button should lead to Search Results page with  providers.
 *               
 *                                 
 * </pre>
 */

@SuppressWarnings("serial")
public class ServiceAuthConversation extends BaseHiddenFieldStateConversation {

  public static final String APPROVAL_TASK = "3310";

  public static final String DIV_SERVICE_AUTH_TASK = "6000";

  public static final String PFC_SERVICE_AUTH_TASK = "2000";

  public static final String CCON18SO_S = "CCON18SO";

  public static final String DISPLAY_AUTH_DETAIL = "/financials/ServiceAuth/displayServiceAuthDetail";

  public static final String DISPLAY_AUTH_HEADER = "/financials/ServiceAuth/displayServiceAuthHeader";

  public static final String ERROR = "error";

  public static final String EVENT_STATUS_PENDING = "PEND";

  public static final String EVENT_STATUS_APPROVE = "APRV";

  public static final String EVENT_STATUS_PROCESS = "PROC";

  public static final String IND_POLICY_WAIVER = "true";

  public static final String RESOURCE_STATUS = "actv";

  public static final String RESOURCE_LOCATION = "lctn";

  public static final String RESOURCE_TYPE_PROVIDER = "01";
  
  public static final String RESOURCE_TYPE_HOME = "06";
  
  public static final String TERMINATE = "TRM";

  public static final String PRINCIPAL = "PRN";

  public static final String REQ_FUNC_CD = "cReqFuncCd";

  public static final String SAVE_SUBMIT_BUTTON = "btnSaveSubmit";

  public static final String TRACE_TAG = "ServiceAuthConversation";

  public static final String CREG = "C-REG";

  public static final String CGUA = "C-GUA";
  
  public static final String SELECT_RESOURCE = "/financials/ServiceAuth/selectResource";
  
  public static final String SELECT_ADO_RESOURCE = "/financials/ServiceAuth/selectAdoResource";
  
  public static final String SELECT_ADD = "/financials/ServiceAuth/addServiceAuthDetail";
  
  public static final String SELECT_ADO_ADD = "/financials/ServiceAuth/addAdoServiceAuthDetail";
  
  public static final String DISPLAY_SA_DETAILPAGE = "/financials/ServiceAuth/addServiceAuthDetail";
  
  public static final String SERV_AUTH_ADO_PULLBACK = "hdnServAuthAdoAssistReqPullBack";
  
  public static final String SERV_AUTH_ADO_OBJECT = "szCdSvcAuthServiceObject";  

  private Financials financials;

  public void setFinancials(Financials financials) {
    this.financials = financials;
  }
  
  private static final Set<String> ADO_SERVICE_57_77_CODES = new HashSet<String>() {
    {
      add("51257"); // Pre and Post Adoption and Support Services
      add("51277"); // Adoptive Placement Reimbursement Foster Parent Conversion
    } 
  };
  
  
  private static final Set<String> SERVICE_512_17_58_60_CODES = new HashSet<String>(){
    {
      add("51217"); //Child Care
      add("51258"); //Medical, Therapy /counselling, Dental/Orthodentics, Other
      add("51260"); //Respite Care
    }
  };

  /**
   * Access Service Auth <p/> This method is used to forward to the appropriate method based on page mode
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void accessServiceAuth_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".accessServiceAuth_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // If the app mode is approve, call the display service Auth Header directly,
    // else it is being called from event list, so go through separate processing

    if (GlobalData.isApprovalMode(request)) {
      displayServiceAuthHeader_xa(context);
    } else {
      // First retrieve page mode from state, then remove all attributes from state, and set
      // page mode back into state

      // SIR 16979 get the page mode from event search conversation
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      // This is an indicator which indicates if the user is coming back from
      // Policy Waiver List page.
      String reqPullBack = ContextHelper.getStringSafe(request, "hdnReqPullBack");
      // Added this condition because if the user is coming back from the Policy Waiver
      // list pull back we do not want to remove attributes from state.
      if (!IND_POLICY_WAIVER.equals(reqPullBack)) {
        state.removeAllAttributes(request);
      }
      else{
       pageMode = PageMode.getPageMode(request);
       CCON18SO ccon18so = (CCON18SO) state.getAttribute("CCON18SO", request);
       if(ccon18so != null){
       GlobalData.setUlIdEvent(ccon18so.getUlIdEvent(), request);
       }
       
       
      }
      PageMode.setPageMode(pageMode, request);

      // Since Event List can only call one xa method, this access method will call the
      // add or display method directly depending on what page mode has been passed
      // from event list

      // SIR 18105 GRIMSHAN -- Also navigate to add service auth if ulidevent
      // is 0 (no event has previously been generated).
      if (PageModeConstants.NEW.equals(PageMode.getPageMode(request)) || GlobalData.getUlIdEvent(request) == 0) {
        // SIR 18105 GRIMSHAN -- Re-set page mode to new, if the new service auth
        // has been navigated to from case to do
        PageMode.setPageMode(PageModeConstants.NEW, request);
        addServiceAuthHeader_xa(context);
      } else {
        displayServiceAuthHeader_xa(context);
      }
    }

    performanceTrace.exitScope();
  }

  /**
   * Display Service Auth Header <p/> This method is used to display an existing Service Auth Header, it performs a call
   * to ccon18s to retrieve the header information. Ccon18so returns a row group that the method uses to generate an
   * array for the client list drop down.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayServiceAuthHeader_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayServiceAuthHeader_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    try {
      BaseSessionStateManager state = getSessionStateManager(context);

      // If the AppMode is approve, set the page mode to modify, else do normal
      // processing
      if (GlobalData.isApprovalMode(request)) {
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
      }

      // If the page mode is currently new, that means we are re-displaying after save,
      // so reset the page mode to modify, otherwise the page mode passed from event list is
      // fine.
      if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
      }

      // SIR 17170 GRIMSHAN Remove the resource search SO object so that if the page has redisplayed
      // itself after save, when the user clicks save again, it will be null in state
      // this way the information will be populated in the SI object correctly.
      state.removeAttribute("CCON20SO", request);

      // First call the display for the Service Auth Header Detail information
      CCON18SI ccon18si = populateCCON18S_Retrieve(context);

      CCON18SO ccon18so = financials.retrieveServiceAuthorization(ccon18si);

      // SIR 16978, 23361 - If the (Event status is approved, the stage is not closed, and the user
      // has stage acesses) OR the user has SEC_MNTN_SVC_AUTH security attributes,
      // set the page Mode to modify.

      if ((EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus()) && CaseUtility
                                                                                                        .hasStageAccess(
                                                                                                                        UserProfileHelper
                                                                                                                                         .getUserProfile(
                                                                                                                                                         request)
                                                                                                                                         .getUserID(),
                                                                                                                        GlobalData
                                                                                                                                  .getUlIdStage(request)))
          || user.hasRight(UserProfile.SEC_MNTN_SVC_AUTH)) {
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
      }

      // SIR 18309 GRIMSHAN -- If the message MSG_CON_NO_CLIENT_FACTOR has been returned from the
      // service, if the stage is not closed and/or the user does not have security attribute, display
      // the message, otherwise just continue.

      if (Messages.MSG_CON_NO_CLIENT_FACTOR == ccon18so.getError_message()) {
        if (!(ArchitectureConstants.Y.equals(ccon18so.getBIndStageClose()) && user
                                                                                  .hasRight(UserProfile.SEC_MNTN_SVC_AUTH))) {
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CON_NO_CLIENT_FACTOR);
          displayMessagePage(errorMessage, context);
        }
      }
      // If the Investigation Conclusion Event Status is 'PEND', then set a
      // message in the request that will notify the user that the pending
      // approval will be invalidated if they save any changes.
      // If the appmode is approve, saving will not invalidate the pending approval
      // so don't display the message.
      // SIR 18571 - If stage closure event is pending (here, indicated by
      // ccon18so.getUlIdEvent being a valid id), warn user of invalidation
      if (!GlobalData.isApprovalMode(request) && ccon18so.getROWCCMN01UIG00().getSzCdEventStatus() != null && ccon18so
                                                                                                                       .getROWCCMN01UIG00()
                                                                                                                       .getSzCdEventStatus()
                                                                                                                       .equals(
                                                                                                                               EVENT_STATUS_PENDING))
          {
        setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, DISPLAY_AUTH_HEADER, request);

        setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
      }

      // If the code returned for the service is not in the codes table, display an informational message
      Set codesAvailable = new HashSet<String>(Lookup.getCategoryCodesCollection(CodesTables.CENTCODE));

      if (ccon18so.getSzCdSvcAuthService() != null && !codesAvailable.contains(ccon18so.getSzCdSvcAuthService())) {
        setInformationalMessage(Messages.MSG_NO_SVC_DECODE, DISPLAY_AUTH_HEADER, request);
      }

      List<Option> clientList = new ArrayList<Option>();
      ROWCCON18SOG00_ARRAY clientArray = ccon18so.getROWCCON18SOG00_ARRAY();
      Enumeration clientEnumeration = clientArray.enumerateROWCCON18SOG00();

      while (clientEnumeration.hasMoreElements()) {
        ROWCCON18SOG00 clientRow = (ROWCCON18SOG00) clientEnumeration.nextElement();
        // SIR 19608
        String clientName = clientRow.getSzNmPersonFull() + " "
                            + FormattingHelper.formatString(clientRow.getSzCdNameSuffix());
        clientList.add(new Option(String.valueOf(clientRow.getUlIdPerson()), clientName));
      }

      // Set these items into state so that they do not get lost during resource pullback
      state.setAttribute("clientList", clientList, request);
      state.setAttribute(CCON18SO_S, ccon18so, request);
      state.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE, request);
      // Set an indicator so that the custom validation will know if the resource search
      // has been peformed
      state.setAttribute("indRsrcSelected", ArchitectureConstants.Y, request);

      int ulIdSvcAuth = ccon18so.getUlIdSvcAuth();

      // Now call the display for the Service Auth List information
      CCON21SI ccon21si = populateCCON21S_Retrieve(context, ulIdSvcAuth);
      CCON21SO ccon21so = financials.retrieveServiceList(ccon21si);
      // Set this into state so that they do not get lost during resource pullback
      state.setAttribute("CCON21SO", ccon21so, request);
      // STGAP00008763 Displaying message "The Contract for this Resource is on Svc Hold or Pay/Svc Hold or is Pending" 
      // But allowing the detail to be terminated while in View Mode. 
      if(Messages.MSG_CON_NO_ACTIVE_CONTRACT == ccon18so.getError_message()){
        String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CON_NO_ACTIVE_CONTRACT);
        addErrorMessage(errorMessage, request);
     //   PageMode.setPageMode(PageModeConstants.VIEW, request);
      }
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CON_NO_CLIENT_FACTOR:
      case Messages.MSG_SYS_INVALID_TASK:
      case Messages.MSG_SVA_NOT_FROM_INVEST:
      case Messages.MSG_SVC_AUTH_NEW_STAGE:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_MULT_INST:

       String  errorMessage = MessageLookup.getMessageByNumber(errorCode);
       displayMessagePage(errorMessage, context);
       
        break;
        
        //STGAP00012907
      case Messages.MSG_CON_PRINCIPLE:
        String errorMessage1 = MessageLookup.getMessageByNumber(errorCode);
        displayMessagePage(errorMessage1, context);
        break;
        
        // catch error message from retrieve in case of bad data

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
   * Add Service Auth Header <p/> This method is used to display the Service Auth Header page for adding a new Service
   * Auth Header. It performs a call to ccon18s to retrieve display information. Ccon18so returns a row group that the
   * method uses to generate an array for the client list drop down. It also sets the reqFuncCode to Add.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addServiceAuthHeader_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addServiceAuthHeader_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    try {

      BaseSessionStateManager state = getSessionStateManager(context);
      
      // First call the display for the Service Auth Header Detail information
      CCON18SI ccon18si = populateCCON18S_Retrieve(context);
      CCON18SO ccon18so = financials.retrieveServiceAuthorization(ccon18si);

      // SIR 18571 - If there's a pending closure, warn user of invalidation.
      if (!GlobalData.isApprovalMode(request) && ccon18so.getUlIdEvent() > 0) {
        setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, DISPLAY_AUTH_HEADER, request);

        setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
      }

      String county = CaseUtility.getCounty(GlobalData.getUlIdCaseAsString(request));
      GlobalData.setSzCdCounty(county, request);

      // SIR 18309 GRIMSHAN -- If the message MSG_CON_NO_CLIENT_FACTOR has been returned from the
      // service, if the stage is not closed and/or the user does not have security attribute, display
      // the message, otherwise just continue.
      // SIR 23712 - APS Reform R2 if stage type is C-REG or C_CUA ignore
      // the MSG_CON_NO_CLIENT_FACTOR message from the service..
      if (ccon18so.getError_message() == Messages.MSG_CON_NO_CLIENT_FACTOR
          && (!CREG.equals(GlobalData.getSzCdStageType(request)))
          && (!CGUA.equals(GlobalData.getSzCdStageType(request)))) {
        if (!(ArchitectureConstants.Y.equals(ccon18so.getBIndStageClose()) && user
                                                                                  .hasRight(UserProfile.SEC_MNTN_SVC_AUTH))) {
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CON_NO_CLIENT_FACTOR);
          displayMessagePage(errorMessage, context);
        }
      }
      List<Option> clientList = new ArrayList<Option>();
      ROWCCON18SOG00_ARRAY clientArray = ccon18so.getROWCCON18SOG00_ARRAY();
      Enumeration serviceEnumeration = clientArray.enumerateROWCCON18SOG00();

      while (serviceEnumeration.hasMoreElements()) {
        ROWCCON18SOG00 clientRow = (ROWCCON18SOG00) serviceEnumeration.nextElement();
        // SIR 19608
        String clientName = clientRow.getSzNmPersonFull() + " "
                            + FormattingHelper.formatString(clientRow.getSzCdNameSuffix());
        clientList.add(new Option(String.valueOf(clientRow.getUlIdPerson()), clientName));

      }
      String reqPullBack = ContextHelper.getStringSafe(request, "hdnReqPullBack");
      if (!IND_POLICY_WAIVER.equals(reqPullBack)) {

        state.setAttribute("clientList", clientList, request);
        state.setAttribute(CCON18SO_S, ccon18so, request);
      }
      state.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD, request);
      // Set an indicator so that the custom validation will know if the resource search
      // has been peformed
      state.setAttribute("indRsrcSelected", ArchitectureConstants.N, request);

    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CON_NO_CLIENT_FACTOR:
      case Messages.MSG_SYS_INVALID_TASK:
      case Messages.MSG_SVA_NOT_FROM_INVEST:
      case Messages.MSG_SVC_AUTH_NEW_STAGE:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_MULT_INST:
        String errorMessage = MessageLookup.getMessageByNumber(errorCode);
        displayMessagePage(errorMessage, context);
        break;
      //STGAP00012907
      case Messages.MSG_CON_PRINCIPLE:
        String errorMessage1 = MessageLookup.getMessageByNumber(errorCode);
        displayMessagePage(errorMessage1, context);
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
  
  
  public void addAdoServiceAuthDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CaseUtility.Stage stage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
    if(stage != null && CodesTables.CSTAGES_PAD.equals(stage.getCdStage())) {
      state.setAttribute(AdoptionAsstncConversation.ADO_ASSIST_APP_TASK_PULLBACK, AdoptionAsstncConversation.ADO_ASSIST_APP_TASK_PAD, request); 
    } else {
      state.setAttribute(AdoptionAsstncConversation.ADO_ASSIST_APP_TASK_PULLBACK, AdoptionAsstncConversation.ADO_ASSIST_APP_TASK, request); 
    }
    state.setAttribute(AdoptionAsstncConversation.ADO_ASSIST_PULLBACK, ArchitectureConstants.TRUE, request);
    state.setAttribute(SERV_AUTH_ADO_PULLBACK, ArchitectureConstants.TRUE, request);
    state.setAttribute(SERV_AUTH_ADO_OBJECT, state.getAttribute(CCON18SO_S, request), request);
    
  }
  
  

  /**
   * Display Service Auth Detail <p/> This method is used to display an existing Service Auth Detail page. It calls
   * ccon24 to retrieve the detail information for the page. This service returns a row group that is used to generate
   * the information that will be displayed in the servcie drop down box. This service also returns a row group for
   * displaying the persons that can be selected for saving this detail. However, on update this will rarely be used (if
   * at all). It sets the reqFuncCd to Update. It also sets a variable named pageMode into the request so that
   * PageMode.getPageMode will not be changed for the parent page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayServiceAuthDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayServcieAuthDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);

      String szCdSvcAuthService = ContextHelper.getStringSafe(request, "selSzCdSvcAuthService");
      String szCdSvcAuthCategory = ContextHelper.getStringSafe(request, "szCdSvcAuthCategory");
      String headerService = szCdSvcAuthCategory + szCdSvcAuthService;
      String globalPageMode = PageMode.getPageMode(request);
      String pageMode = "";

      if (PageModeConstants.MODIFY.equals(globalPageMode) || PageModeConstants.NEW.equals(globalPageMode)) {
        pageMode = PageModeConstants.MODIFY;
      } else if (PageModeConstants.VIEW.equals(globalPageMode)) {
        pageMode = PageModeConstants.VIEW;
      }

      // Set pageMode from global data into the request, since on Add it is set into the request
      // With a different pageMode than the global page mode
      request.setAttribute("pageMode", pageMode);
      request.setAttribute("szCdSvcAuthService", szCdSvcAuthService);
      // SIR 22573 move the set of req_func_cd here, so that if it is
      // reset by new using in populateCCON22S_Retrieve that value will be held
      request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_UPDATE);

      // First call the display for the Service Auth Header Detail information
      CCON22SI ccon22si = populateCCON22S_Retrieve(context, pageMode);

      CCON22SO ccon22so = financials.retrieveServiceAuthorizationDetail(ccon22si);
      ROWCCON22SOG01 rowccon22sog01 = ccon22so.getROWCCON22SOG01();
      ROWCCON22SOG02_ARRAY codesArray = ccon22so.getROWCCON22SOG02_ARRAY();
      ROWCCON22SOG00_ARRAY personArray = ccon22so.getROWCCON22SOG00_ARRAY();
      setServiceAuthDetailPageSet(context);

      // Exclude Views excludes things to display in the Service Drop down. It is initialized
      // to all items in the codes table.
      // The Remove loop removes items from the exclude views (thus they will be displayed)
      // If a code exists in the service return that is not in the codestable, display a message
      try {
        Set<String> excludeViews = new HashSet<String>(Lookup.getCategoryCodesCollection(CodesTables.CSVCCODE));
        Enumeration excludeViewsEnum = codesArray.enumerateROWCCON22SOG02();
        String szCdSvcService = rowccon22sog01.getSzCdSvcAuthDtlSvc() != null ? (rowccon22sog01.getSzCdSvcAuthDtlSvc()): "";
        if(rowccon22sog01.getUlIdAdopAssistAppl() > 0 && (szCdSvcService.startsWith("512") == true)) {
          if (excludeViews.contains(szCdSvcService)) {
            excludeViews.remove(szCdSvcService);
          }
        } else {
          while (excludeViewsEnum.hasMoreElements()) {
            ROWCCON22SOG02 rowccon22sog02 = (ROWCCON22SOG02) excludeViewsEnum.nextElement();
            String szCdCnsvcService = rowccon22sog02.getSzCdCnsvcService();
            String tempSzCdCnsvcService = szCdCnsvcService.substring(0, 5);
            if (excludeViews.contains(szCdCnsvcService) && headerService.equals(tempSzCdCnsvcService)) {
              excludeViews.remove(szCdCnsvcService);
              // STGAP00013384 - avoid throwing error if the code is not in the excludeViews HashSet 
              // only because it is expired(end dated). 
            } else if (!excludeViews.contains(szCdCnsvcService)
                       && !Lookup.isValidExpiredCode(CodesTables.CSVCCODE, szCdCnsvcService)) {
              // SIR 18408
              setErrorMessage(Messages.MSG_NO_SVC_DECODE, DISPLAY_AUTH_DETAIL, request);
              break;
            }
          }
        }
        
        state.setAttribute("excludeViews", excludeViews, request);
        // MR-52
        if (ccon22so.getSzCdSplServType() != null) {
          displayInformationalMessage(context, ccon22so);
        }
      } catch (LookupException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
        processSevereException(context, e);
      }

      Enumeration personEnumeration = personArray.enumerateROWCCON22SOG00();
      personArray = new ROWCCON22SOG00_ARRAY();
      while (personEnumeration.hasMoreElements()) {
        ROWCCON22SOG00 personRow = (ROWCCON22SOG00) personEnumeration.nextElement();
        personArray.addROWCCON22SOG00(personRow);

      } // End while
      request.setAttribute("CCON22SO", ccon22so);
      request.setAttribute("ROWCCON22SOG01", rowccon22sog01);
      request.setAttribute("ROWCCON22SOG02_ARRAY", codesArray);
      state.setAttribute("ROWCCON22SOG00_ARRAY", personArray, request);
      state.setAttribute("CCON22SO", ccon22so, request);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_DETAIL_DELETED:
      case Messages.MSG_CON_CONTRACT_SVC:
      case Messages.MSG_CON_PRINCIPLE:
        String errorMessage = MessageLookup.getMessageByNumber(errorCode);
        displayMessagePage(errorMessage, context);
        break;
      case Messages.MSG_CON_NO_ACTIVE_CONTRACT:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CON_NO_ACTIVE_CONTRACT);
        addErrorMessage(errorMessage, request);
       break;
       
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Add Service Auth Detail <p/> This method is used to display a Service Auth Detail page for adding a new detail. It
   * calls ccon24 to retrieve the two row groups for displaying the page. The first row group is used to generate the
   * information that will be displayed in the servcie drop down box. This service also returns a row group for
   * displaying the persons that can be selected for saving this detail. If the case is an APS case only one person will
   * be displayed on the page (the VC CL or VP for the case) It sets the reqFuncCd to Add. It also sets a variable named
   * pageMode into the request so that PageMode.getPageMode will not be changed for the parent page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addServiceAuthDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addServiceAuthDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      
      String szCdSvcAuthService = ContextHelper.getStringSafe(request, "selSzCdSvcAuthService");
      String szCdSvcAuthCategory = ContextHelper.getStringSafe(request, "selSzCdSvcAuthCategory");
      int adoAppEventId = 0;
      
      if((AdoptionAsstncConversation.ADO_ASSIST_APP_TASK.equals(state.getAttribute(AdoptionAsstncConversation.ADO_ASSIST_APP_TASK_PULLBACK, request))) || (AdoptionAsstncConversation.ADO_ASSIST_APP_TASK_PAD.equals(state.getAttribute(AdoptionAsstncConversation.ADO_ASSIST_APP_TASK_PULLBACK, request)))) {
        adoAppEventId = ContextHelper.getIntSafe(request, "actionEventId");
        CCON18SO ccon18so = (CCON18SO) state.getAttribute(SERV_AUTH_ADO_OBJECT, request);
        state.setAttribute(CCON18SO_S, ccon18so, request);
        szCdSvcAuthCategory = ccon18so.getSzCdSvcAuthCategory();
        szCdSvcAuthService = ccon18so.getSzCdSvcAuthService();
        GlobalData.setUlIdEvent(ccon18so.getUlIdEvent(), request);
        state.removeAttribute(AdoptionAsstncConversation.ADO_ASSIST_APP_TASK_PULLBACK, request); 
        state.removeAttribute(SERV_AUTH_ADO_OBJECT, request); 
      }

      String headerService = szCdSvcAuthCategory + szCdSvcAuthService;
      String pageMode = PageModeConstants.NEW;

      // Set pageMode from global data into the request, since on Add it is set into the request
      // With a different pageMode than the global page mode
      request.setAttribute("pageMode", pageMode);

      request.setAttribute("szCdSvcAuthService", szCdSvcAuthService);
      request.setAttribute("szCdSvcAuthCategory", szCdSvcAuthCategory);

      // First call the display for the Service Auth Header Detail information
      CCON22SI ccon22si = populateCCON22S_Retrieve(context, pageMode);
      ccon22si.setUlIdAdopAssistAppl(adoAppEventId);

      /*
       * String outputXml = WtcHelper.callService("CCON22S", ccon22si); CCON22SO ccon22so = CCON22SO.unmarshal(new
       * StringReader(outputXml));
       */
      CCON22SO ccon22so = financials.retrieveServiceAuthorizationDetail(ccon22si);
      ROWCCON22SOG02_ARRAY codesArray = ccon22so.getROWCCON22SOG02_ARRAY();
      ROWCCON22SOG00_ARRAY personArray = ccon22so.getROWCCON22SOG00_ARRAY();
      
      if(adoAppEventId > 0) {
        ccon22so.getROWCCON22SOG01().setUlIdAdopAssistAppl(adoAppEventId);
      }
           
      // Exclude Views excludes things to display in the Service Drop down. It is initialized
      // to all items in the codes table.
      // The Remove loop removes items from the exclude views (thus they will be displayed)
      // If a code exists in the service return that is not in the codestable, display a message
      try {
        Set<String> excludeViews = new HashSet<String>(Lookup.getCategoryCodesCollection(CodesTables.CSVCCODE));
        Enumeration excludeViewsEnum = codesArray.enumerateROWCCON22SOG02();
        
        if(ccon22so.getROWCCON22SOG01() != null && (ccon22so.getROWCCON22SOG01().getUlIdAdopAssistAppl()) > 0 && (szCdSvcAuthCategory.equals("512") == true) ) {
          String szCdSvcService = ccon22so.getROWCCON22SOG01().getSzCdSvcAuthDtlSvc();
          if (excludeViews.contains(szCdSvcService)) {
            excludeViews.remove(szCdSvcService);
          }
        } else {

          while (excludeViewsEnum.hasMoreElements()) {
            ROWCCON22SOG02 rowccon22sog02 = (ROWCCON22SOG02) excludeViewsEnum.nextElement();
            String szCdCnsvcService = rowccon22sog02.getSzCdCnsvcService();
            String tempSzCdCnsvcService = szCdCnsvcService.substring(0, 5);
            if (excludeViews.contains(szCdCnsvcService) && headerService.equals(tempSzCdCnsvcService)) {
              excludeViews.remove(szCdCnsvcService);
            } 
           // STGAP00012441 Removing the error message from here to allow the page to 
           // Display correctly.  If the Svc has been endated then No matches were found for these search parameters.
           // Will display on the Resource Search Results page  
          }
        }
        
        state.setAttribute("excludeViews", excludeViews, request);
        // MR-52
        if (ccon22so.getSzCdSplServType() != null) {
          displayInformationalMessage(context, ccon22so);
        }    
      } catch (LookupException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
        processSevereException(context, e);
      }

      Enumeration personEnumeration = personArray.enumerateROWCCON22SOG00();
      personArray = new ROWCCON22SOG00_ARRAY();
      while (personEnumeration.hasMoreElements()) {
        ROWCCON22SOG00 personRow = (ROWCCON22SOG00) personEnumeration.nextElement();

        personArray.addROWCCON22SOG00(personRow);
      } // End while

      request.setAttribute("CCON22SO", ccon22so);
      state.setAttribute("CCON22SO", ccon22so, request);
      state.setAttribute("ROWCCON22SOG00_ARRAY", personArray, request);
      request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_DETAIL_DELETED:
      case Messages.MSG_CON_CONTRACT_SVC:
      case Messages.MSG_CON_PRINCIPLE:
        String errorMessage = MessageLookup.getMessageByNumber(errorCode);
        displayMessagePage(errorMessage, context);
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
   * Save Service Auth Header <p/> This method is used to Save the Header information entered. It calls ccon19s for
   * saving the main header information. After that, if the user has clicked save and submit, it forwards to the to do
   * conversation for submittal.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveServiceAuthHeader_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveServiceAuthHeader_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);

    String saveSubmitButtonNameInRequest = SAVE_SUBMIT_BUTTON + ".x";
    boolean bSaveSubmit = ContextHelper.getString(request, saveSubmitButtonNameInRequest) != null;
    try {

      CCON21SO ccon21so = new CCON21SO();
      ccon21so = (CCON21SO) state.getAttribute("CCON21SO", request);
      if (bSaveSubmit
          && (ccon21so.getROWCCON21SOG00_ARRAY() == null || ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00Count() == 0)) {
        throw new ServiceException(Messages.MSG_SVC_AUTH_DETAIL_REQ);
      }
      CCON19SI ccon19si = populateCCON19SI_AU(context);

      CCON19SO ccon19so = financials.saveServiceAuthorization(ccon19si);

      if (ArchitectureConstants.Y.equals(ccon19so.getBIndOverSpendingLimitPad())) {
        setErrorMessage(
                        MessageLookup
                                     .addMessageParameter(
                                                          MessageLookup
                                                                       .getMessageByNumber(Messages.MSG_NRE_AMT_WILL_EXCEED_NR_LIMIT),
                                                          FormattingHelper.formatDouble(ccon19so.getDAmtNonRecLimit(),
                                                                                        2)), request);
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        return;
      }
      
      GlobalData.setUlIdEvent(ccon19so.getROWCCMN01UIG00().getUlIdEvent(), request);

      // Put Information from the save service into the request
      request.setAttribute("CCON19SO", ccon19so);

     
      // If the user clicked 'Save and Submit', forward the response to the
      // To-Do Detail page so the user can create an approval to-do for their
      // supervisor.
      if (bSaveSubmit) {
        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                                     GlobalData.getUlIdStage(request), APPROVAL_TASK);
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
        setPresentationBranch("submit", context);
      }
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (DataFormatException de) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + de.getMessage());
      processSevereException(context, de);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    } finally {

    }
    performanceTrace.exitScope();
  }

  /**
   * Delete Auth Header <p/> This method is used to Delete entire Service Authorizations. It calls ccon19s, passing in
   * the reqFuncCd of Delete in order to delete the Header and all associated information.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void deleteAuthHeader_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteAuthHeader_xa()");
    performanceTrace.enterScope();
    try {
      CCON19SI ccon19si = populateCCON19SI_D(context);
      CCON19SO ccon19so = financials.saveServiceAuthorization(ccon19si);

      // Put Information from the save service into the request
      request.setAttribute("CCON19SO", ccon19so);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_MULT_INST:
        setPresentationBranch(ERROR, context);
        setErrorMessage(errorCode, DISPLAY_AUTH_HEADER, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Save Service Auth Detail <p/> This method saves the Service Auth Detail information. It calls ccon23s.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveServiceAuthDetail_xa(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveServiceAuthDetail_xa()");
    performanceTrace.enterScope();
    try {
      // Begin SIR 23662. Before calling save service, check legal status and placement.
      String errorMessageLegalStatus = "";
      String errorMessageLivingArrangement = "";
      if ("".equals(errorMessageLegalStatus + errorMessageLivingArrangement)) { /* End SIR 23662 */
        CCON23SI ccon23si = populateCCON23SI_AU(context);
        CCON23SO ccon23so = financials.saveServiceAuthorizationDetail(ccon23si);
        
        String nonRecErrorMessage = StringHelper.EMPTY_STRING;
        if(ArchitectureConstants.Y.equals(ccon23so.getBIndActiveNonRecurrAdopLegalFeesExists())){
          String nonRecurringMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_AGMT_NON_RECURR_EXISTS),
                                                                         Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, CodesTables.CSUBTYPE_22));
          nonRecErrorMessage = MessageLookup.addMessageParameter(nonRecurringMessage, FormattingHelper.formatMoney(ccon23so.getDAmtActiveNonRecurrAdopLegalFees()));
        }else if(ArchitectureConstants.Y.equals(ccon23so.getBIndActiveNonRecurrPhyAdopParentExists())){
          String nonRecurringMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_AGMT_NON_RECURR_EXISTS),
                                                                         Lookup.simpleDecodeSafe(CodesTables.CSUBTYPE, CodesTables.CSUBTYPE_25));
          nonRecErrorMessage = MessageLookup.addMessageParameter(nonRecurringMessage, FormattingHelper.formatMoney(ccon23so.getDAmtActiveNonRecurrPhyAdopParent()));
        }else if(ArchitectureConstants.Y.equals(ccon23so.getBIndActiveNonRecurrTravelExists())){
          String nonRecurringMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_AGMT_NON_RECURR_EXISTS),
                                                                         Lookup.simpleDecodeSafe(CodesTables.CSVCCODE, CodesTables.CSVCCODE_51033C));
          nonRecErrorMessage = MessageLookup.addMessageParameter(nonRecurringMessage, FormattingHelper.formatMoney(ccon23so.getDAmtActiveNonRecurrTravel()));
        }else if(ArchitectureConstants.Y.equals(ccon23so.getBIndActiveNonRecurrLogMealsExists())){
          String nonRecurringMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_AGMT_NON_RECURR_EXISTS),
                                                                         Lookup.simpleDecodeSafe(CodesTables.CSVCCODE, CodesTables.CSVCCODE_51033C));
          nonRecErrorMessage = MessageLookup.addMessageParameter(nonRecurringMessage, FormattingHelper.formatMoney(ccon23so.getDAmtActiveNonRecurrLogMeals()));
        }
        
        if(StringHelper.isNotEmptyOrNull(nonRecErrorMessage)){
          setInformationalMessage(nonRecErrorMessage, DISPLAY_AUTH_DETAIL ,request);
         }
        
        if (ArchitectureConstants.Y.equals(ccon23so.getBIndOverSpendingLimitPad())) {
          setErrorMessage(
                          MessageLookup
                                       .addMessageParameter(
                                                            MessageLookup
                                                                         .getMessageByNumber(Messages.MSG_NRE_AMT_WILL_EXCEED_NR_LIMIT),
                                                            FormattingHelper.formatDouble(ccon23so.getDAmtNonRecLimit(),
                                                                                          2)), request);
          setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          return;
        }
        // Put Information from the save service into the request
        request.setAttribute("CCON23SO", ccon23so);
      }
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_SP_SVC_SA_DATES: //MR-52
      case Messages.MSG_SA_AMT_WILL_EXCEED_AAA: //MR-52     
      case Messages.MSG_SA_AMT_EXCEEDS_AAA: //MR-52  
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.SQL_NOT_FOUND:
      case Messages.ARC_ERR_BAD_FUNC_CD:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_NO_EQUIV_MATCH:
      case Messages.MSG_CON_NEG_SVC_BALANCE:
      case Messages.MSG_CON_NO_ACTIVE_SERVICE:
        setPresentationBranch(ERROR, context);
        setErrorMessage(errorCode, DISPLAY_AUTH_DETAIL, context.getRequest());
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Select Resource <p/> This method calls the Resource Search conversation using the parameters entered in the Service
   * Auth Header page. It sets three variables into state so they can be used when the resource information is pulled
   * back to this conversation.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void selectResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getResource_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    resetHeaderInformation(context);

    request.setAttribute("grnds.request.qname", null);

    ResourceSearchPullBackInfo resourceSearchData = new ResourceSearchPullBackInfo();

    // Set these items into state so that when we return from resource pullback, we can use
    // them to validate the resource information
    state.setAttribute("szCdSvcAuthService", ContextHelper.getStringSafe(request, "selSzCdSvcAuthService"), request);
    state.setAttribute("szCdSvcAuthCounty", ContextHelper.getStringSafe(request, "selSzCdSvcAuthCounty"), request);
    state.setAttribute("dtDtSvcAuthEff", ContextHelper.getStringSafe(request, "txtDtDtSvcAuthEff"), request);
    resourceSearchData.setDestinationUrl("/financials/ServiceAuth/setResource");
    String category = ContextHelper.getStringSafe(request, "selSzCdSvcAuthCategory");
    String cdService = ContextHelper.getStringSafe(request, "selSzCdSvcAuthService");
    // Default Resource type for 510,512s excluding 55 and 77 service should be home/other facility and for all other categories 
    // the default resource type should be provider
    if ("510".equals(category) || ("512".equals(category) && (!("57".equals(cdService) || "77".equals(cdService))))) {
      resourceSearchData.setResourceType(RESOURCE_TYPE_HOME);
    } else {
      resourceSearchData.setResourceType(RESOURCE_TYPE_PROVIDER);
    }
    resourceSearchData.setNameCounty(ContextHelper.getStringSafe(request, "selSzCdSvcAuthCounty"));
    String region = FormattingHelper
                                    .formatString(Lookup
                                                        .simpleDecodeSafe(
                                                                          CodesTables.CCNTYREG,
                                                                          ContextHelper
                                                                                       .getStringSafe(request,
                                                                                                      "selSzCdSvcAuthCounty")));
    resourceSearchData.setRsrcRegion(region);
    
    resourceSearchData.setCategory(category);
    String entCode = ContextHelper.getStringSafe(request, "selSzCdSvcAuthService");
    String service = category + entCode;
    
    if ("510".equals(category) || ("512".equals(category) && (!("57".equals(cdService) || "77".equals(cdService))))  ) {
      //set resource to home other
      //STGAP00013203 For Service Code of 512 , resources of type Provider (01) and 
      //Type Home/Other (06) with Facility type of CPA (CP) should be available.
      resourceSearchData.setFullSearch(true);
      resourceSearchData.setResourceStatus(CodesTables.CRSCSTAT_01);
    } else {
      resourceSearchData.setFullSearch(false);
      resourceSearchData.setResourceStatus(RESOURCE_STATUS);
    }
    
    resourceSearchData.setService(service);
    resourceSearchData.setLocationArea(RESOURCE_LOCATION);
    resourceSearchData.setEffectiveDate(ContextHelper.getStringSafe(request, "txtDtDtSvcAuthEff"));

    request.setAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, resourceSearchData);
    state.setAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, resourceSearchData, request);
    state.setAttribute("szCdSvcAuthCategory", category, request);

    performanceTrace.exitScope();
  }
  
  /**
   * Select Resource <p/> This method calls the Resource Search conversation using the parameters entered in the Service
   * Auth Header page. It sets three variables into state so they can be used when the resource information is pulled
   * back to this conversation.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void selectAdoResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getResource_xa()");
    performanceTrace.enterScope();

    selectResource_xa(context);
   
    performanceTrace.exitScope();
  }

  public void selectWaiver_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".selectWaiver_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    resetHeaderInformation(context);
    request.setAttribute("grnds.request.qname", null);
    performanceTrace.exitScope();

  }

  /**
   * Set Resource <p/> This method is used to first validate that the resource pulled back has an active contract. It
   * calls ccon20s in order to validate this information. It also sets the information returned from the resource search
   * into state for the jsp's use.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void setResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setResource_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    CRES03SO cres03so = (CRES03SO) request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);
    performanceTrace.msg(TRACE_TAG, 7, "cres03so: " + cres03so);

    try {

      CCON20SI ccon20si = new CCON20SI();
      ccon20si.setUlIdResource(cres03so.getUlIdResource());

      String county = (String) state.getAttribute("szCdSvcAuthCounty", request);
      String category = (String) state.getAttribute("szCdSvcAuthCategory", request);
      String entCode = (String) state.getAttribute("szCdSvcAuthService", request);
      String service = category + entCode;
      String effectiveDate = (String) state.getAttribute("dtDtSvcAuthEff", request);
      ccon20si.setSzCdSvcAuthCounty(county);
      ccon20si.setSzCdSvcAuthService(service);
      ccon20si.setDtDtSvcAuthEff(DateHelper.toCastorDateSafe(effectiveDate));
      CCON20SO ccon20so = financials.contractValidation(ccon20si);

      // If the Contract Region does not equal the user region, set an indicator for the jsp
      // so that a message can be displayed on save.
      if (!ccon20so.getSzCdCntrctRegion().equals(FormattingHelper.convertRegionCode(user.getUserRegion()))) {
        state.setAttribute("indDifRegion", ArchitectureConstants.Y, request);
      } else {
        state.setAttribute("indDifRegion", ArchitectureConstants.N, request);
      }
      state.setAttribute("CCON20SO", ccon20so, request);

      // Set an indicator so that the custom validation will know if the resource search
      // has been peformed
      state.setAttribute("indRsrcSelected", ArchitectureConstants.Y, request);
      state.setAttribute("CRES03SO", cres03so, request);

      // SIR 18571 - Remind the user of invalidation if pending closure.
      CCON18SO ccon18so = (CCON18SO) state.getAttribute(CCON18SO_S, request);
      if (!GlobalData.isApprovalMode(request) && ccon18so.getUlIdEvent() > 0) {
        setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, DISPLAY_AUTH_HEADER, request);

        setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
      }
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      // Because this message is returned in the process of a pullback,
      // we only need to add the error message to the hashmap, we do not
      // need to perform the functionality that setErrorMessage does
      case Messages.MSG_CON_NO_ACTIVE_CONTRACT:
        String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CON_NO_ACTIVE_CONTRACT);
        addErrorMessage(errorMessage, request);
       
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Set Service Auth Detail Page Set <p/> This method sets the page set based on if the Service Auth is complete.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  protected void setServiceAuthDetailPageSet(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CCON18SO ccon18so = (CCON18SO) state.getAttribute(CCON18SO_S, request);

    if (EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {
      Sets.setPageSet(Sets.A, request);
    }

  }

  /**
   * populate CCON18S Retrieve <p/> This method populates the information for CCON18SI.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return ccon18si
   */
  private CCON18SI populateCCON18S_Retrieve(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    CCON18SI ccon18si = new CCON18SI();
    ArchInputStruct input = new ArchInputStruct();

    UserProfile user = UserProfileHelper.getUserProfile(context);

    input.setSzUserId(user.getUserLogonID());
    input.setCReqFuncCd(PageMode.getPageMode(request));

    // Set the values for the ArchInputStruct
    ccon18si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    ccon18si.setUlIdStage(GlobalData.getUlIdStage(request));
    ccon18si.setSzCdStage(GlobalData.getSzCdStage(request));
    ccon18si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccon18si.setSzCdTask(GlobalData.getSzCdTask(request));
    ccon18si.setSzCdUnitProgram(GlobalData.getSzCdStageProgram(request));

    ccon18si.setArchInputStruct(input);
    return ccon18si;
  }

  /**
   * populate CCON21S Retrieve <p/> This method populates the information for ccon21si
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param ulIdSvcAuth
   *          Passed in so that it can be used as an input
   * @return ccon21si
   */
  private CCON21SI populateCCON21S_Retrieve(GrndsExchangeContext context, int ulIdSvcAuth) {
    UserProfile user = UserProfileHelper.getUserProfile(context);

    CCON21SI ccon21si = new CCON21SI();
    ArchInputStruct input = new ArchInputStruct();

    input.setUlPageSizeNbr(75);
    input.setUsPageNbr(1);
    input.setSzUserId(user.getUserLogonID());

    ccon21si.setUlIdSvcAuth(ulIdSvcAuth);
    ccon21si.setArchInputStruct(input);

    return ccon21si;
  }

  /**
   * populate CCON22S Retrieve <p/> This Method is used to populate the ccon22si
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param pageMode
   *          Passed into the si object
   * @return ccon22si
   */
  private CCON22SI populateCCON22S_Retrieve(GrndsExchangeContext context, String pageMode) {

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    int ulIdSvcAuthDtl = ContextHelper.getIntSafe(request, "ulIdSvcAuthDtl");

    // SIR 22573 if we are new using, set the reqFuncCd to Add, and set ulidserviceauthdtl
    // to be retrieved as the id from the selected row.
    if (StringHelper.isValid(ContextHelper.getStringSafe(context, "btnNewUsing.x"))) {
      request.setAttribute(REQ_FUNC_CD, ServiceConstants.REQ_FUNC_CD_ADD);
      int index = ContextHelper.getIntSafe(request, "rbRowsIndex_CLEAN");
      CCON21SO ccon21so = (CCON21SO) state.getAttribute("CCON21SO", request);
      ulIdSvcAuthDtl = ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(index).getUlIdSvcAuthDtl();
    }

    // Retrieve ccon18so from state to populate fields needed for this retrieve
    CCON18SO ccon18so = (CCON18SO) state.getAttribute(CCON18SO_S, request);
    
    if(ulIdSvcAuthDtl == 0){
      ulIdSvcAuthDtl = ccon18so.getUlIdSvcAuth();
    }
    
    String selSzCdSvcAuthCounty = ContextHelper.getStringSafe(request, "selSzCdSvcAuthCounty");
    if(selSzCdSvcAuthCounty == null || selSzCdSvcAuthCounty.length() == 0){
      selSzCdSvcAuthCounty = ccon18so.getSzCdSvcAuthCounty();
    }
    
    CCON22SI ccon22si = new CCON22SI();
    ArchInputStruct input = new ArchInputStruct();

    input.setUlPageSizeNbr(50);
    input.setSzUserId(user.getUserLogonID());

    ccon22si.setSzCdSvcAuthCounty(selSzCdSvcAuthCounty);
    ccon22si.setUlIdContract(ccon18so.getUlIdContract());
    ccon22si.setUlIdStage(GlobalData.getUlIdStage(request));
    // Only populate the ulIdSvcAuth if the page mode is not new
    if (!PageModeConstants.NEW.equals(pageMode)) {
      ccon22si.setUlIdSvcAuthDtl(ulIdSvcAuthDtl);
    }
    ccon22si.setUlNbrCnperPeriod(ccon18so.getUlNbrCncntyPeriod());
    ccon22si.setUlNbrCnverVersion(ccon18so.getUlNbrCncntyVersion());
    ccon22si.setSzCdStagePersType(PRINCIPAL);
    ccon22si.setUlPageSizeNbr(120);
    ccon22si.setSzSysCdWinMode(pageMode);

    ccon22si.setArchInputStruct(input);

    return ccon22si;
  }

  /**
   * populate CCON19SI Add Update <p/> This method is used to populate the save for ccon19s.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return ccon19si
   * @throws gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException
   *           Thrown by the conversion of Region Code
   */
  @SuppressWarnings("unchecked")
  private CCON19SI populateCCON19SI_AU(GrndsExchangeContext context) throws DataFormatException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    boolean btnSaveSubmit = ContextHelper.getIntSafe(request, "btnSaveSubmit.x") != 0;
    // Allocate the structures

    // Retrieve ccon18so from state so that event items can be re-saved
    CCON18SO ccon18so = (CCON18SO) state.getAttribute(CCON18SO_S, request);
    CCON20SO ccon20so = (CCON20SO) state.getAttribute("CCON20SO", request);
    CCON21SO ccon21so = (CCON21SO) state.getAttribute("CCON21SO", request);

    gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 outputUIG00 = ccon18so.getROWCCMN01UIG00();
    org.exolab.castor.types.Date newDate = new org.exolab.castor.types.Date();

    CCON19SI ccon19si = new CCON19SI();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 inputUIG00 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00();
    ArchInputStruct input = new ArchInputStruct();
    String resourceName = ContextHelper.getStringSafe(request, "dspSzNmResource");
    String reqFuncCd = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(reqFuncCd);
    input.setSzUserId(user.getUserLogonID());

    //
    // SIR 17233 - set the flag indicating approver mode
    //
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    // Only one row is ever saved or deleted, so statically set the page size number to 1

    if (outputUIG00 != null) {
      inputUIG00.setTsLastUpdate(outputUIG00.getTsLastUpdate());
    } else {
      inputUIG00.setTsLastUpdate(new Date());
    }

    ccon19si.setTsLastUpdate(ccon18so.getTsLastUpdate());

    if (btnSaveSubmit) {
      inputUIG00.setSzCdEventStatus(EVENT_STATUS_PENDING);
    }
    // 19770
    else if ((ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request)))
             || (outputUIG00 != null && EVENT_STATUS_APPROVE.equals(outputUIG00.getSzCdEventStatus()))) {
      // leave event status unchanged
      inputUIG00.setSzCdEventStatus(outputUIG00.getSzCdEventStatus());
    } else {
      inputUIG00.setSzCdEventStatus(EVENT_STATUS_PROCESS);
    }

    // SIR 19691 - Service needs to know if Service Auth event was pending.
    if (outputUIG00 != null) {
      ccon19si.setSzCdEventStatus(outputUIG00.getSzCdEventStatus());
    }
    // End SIR 19691

    inputUIG00.setSzCdTask(GlobalData.getSzCdTask(request));
    inputUIG00.setSzCdEventType("AUT");
    
    //STGAP00009780: Event Description: [UAS Code]  [Entitlement Code/Decode]; Resource: [name of resource]; 
    //for [name of person selected from detail page] or Multiple Persons [if more than one person is selected on Detail page].
    String nmPrimaryClient = StringHelper.EMPTY_STRING;
    boolean multiplePersons = false;
    if(ccon21so != null){
      if ((ccon21so.getROWCCON21SOG00_ARRAY() != null && ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00Count() != 0)) {
        if(ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00Count() == 1){
          nmPrimaryClient = ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(0).getSzNmPersonFull();
        }else{
          for(int i=0; i < ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00Count(); i++){
            String personName = ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(i).getSzNmPersonFull();
            for(int j=0; j < ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00Count(); j++){
              if(!personName.equals(ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(j).getSzNmPersonFull())){
                multiplePersons = true;
                break;
              }
            }
            if(multiplePersons == true){
              break;
            }
          }
          if(multiplePersons == true){
            nmPrimaryClient = "Multiple Persons";
          }else{
            nmPrimaryClient = ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(0).getSzNmPersonFull();
          }
        }
      }
    }

    String eventDescription = StringHelper.EMPTY_STRING;

    inputUIG00.setUlIdEvent(GlobalData.getUlIdEvent(request));
    inputUIG00.setUlIdStage(GlobalData.getUlIdStage(request));
    inputUIG00.setDtDtEventOccurred(newDate);
    inputUIG00.setUlIdPerson(user.getUserID());

    // If ccon20so is not null then populate the fields with data from ccon20so
    if (ccon20so != null) {
      ccon19si.setUlIdCntrctManager(ccon20so.getUlIdCntrctManager());
      ccon19si.setUlIdContract(ccon20so.getUlIdContract());
    } else {
      ccon19si.setUlIdCntrctManager(ccon18so.getUlIdCntrctManager());
      ccon19si.setUlIdContract(ccon18so.getUlIdContract());
    }

    // if the page mode is not new, pupulate the Service Auth ID with the one
    // from ccon18so
    if (!PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
      ccon19si.setUlIdSvcAuth(ccon18so.getUlIdSvcAuth());
    }
    String uasCode = ContextHelper.getStringSafe(request, "selSzCdSvcAuthCategory");
    String entCode = ContextHelper.getStringSafe(request, "selSzCdSvcAuthService");
    
    //STGAP00009780:Event Description: [UAS Code]  [Entitlement Code/Decode]; Resource: [name of resource]; 
    //for [name of person selected from detail page] or Multiple Persons [if more than one person is selected on Detail page].
    eventDescription =  (uasCode != null ? uasCode : "");
    eventDescription += (entCode != null ? " " + Lookup.simpleDecodeSafe("CENTCODE", entCode) : "");
    eventDescription += "; Resource: " + resourceName;
    if(!StringHelper.EMPTY_STRING.equals(nmPrimaryClient)){
      eventDescription += "; for " + nmPrimaryClient;
    }
 
    int eventDecLn =  eventDescription.length();
    eventDescription = eventDescription.substring(0, eventDecLn > 100 ? 100 : eventDecLn);
    inputUIG00.setSzTxtEventDescr(eventDescription);
    
    if (!"".equals(ContextHelper.getStringSafe(request, "dspTxtAmtAuthd"))) {
      String test = (ContextHelper.getStringSafe(request, "dspTxtAmtAuthd"));
      test = test.substring(1);
      double totalAmount = (double) Double.valueOf(test);
      String svcCode = uasCode + entCode;

      Double svcDecode = null;
      if (!"".equals(Lookup.simpleDecodeSafe("CSBGTLMT", svcCode))) {
        svcDecode = Double.valueOf(Lookup.simpleDecodeSafe("CSBGTLMT", svcCode));
      }
      if (svcDecode != null) {
        ccon19si.setSzTxtSvcAmtAuthd(totalAmount);
      } else {
        ccon19si.setSzTxtSvcAmtAuthd(0.00);
      }

    }
    ccon19si.setUlIdResource(ContextHelper.getIntSafe(request, "dspUlIdResource"));
    ccon19si.setSzCdUnitProgram(user.getUserRegion());
    ccon19si.setDtDtSvcAuthEff(ContextHelper.getCastorDateSafe(request, "txtDtDtSvcAuthEff"));
    ccon19si.setSzCdSvcAuthCategory(ContextHelper.getStringSafe(request, "selSzCdSvcAuthCategory"));
    ccon19si.setSzCdSvcAuthService(ContextHelper.getStringSafe(request, "selSzCdSvcAuthService"));
    ccon19si.setSzCdSvcAuthCounty(ContextHelper.getStringSafe(request, "selSzCdSvcAuthCounty"));
    ccon19si.setSzTxtSvcAuthComments(ContextHelper.getStringSafe(request, "txtSzTxtSvcAuthComments"));
    ccon19si.setSzTxtSvcAuthSecProvdr(ContextHelper.getStringSafe(request, "txtSzTxtSvcAuthSecProvdr"));
    ccon19si.setCIndWaiverReqd(ContextHelper.getStringSafe(request, "cbxIndWaiverReqd"));
    ccon19si.setSzCdPupTyp(ContextHelper.getStringSafe(request, "rbCIndPupOutCmTyp"));
    ccon19si.setUlIdWaiver(ContextHelper.getIntSafe(request, "dspUlIdWaiver"));
    ccon19si.setSzCdPupOtcme(ContextHelper.getStringSafe(request, "selSzCdPupOtcme"));
    ccon19si.setDtDtRefSent(ContextHelper.getCastorDateSafe(request, "txtDtRefSent"));
    ccon19si.setSzCdPayCnty(ContextHelper.getStringSafe(request, "selSzCdSvcAuthPayCounty"));
    ccon19si.setSzCdErlyCaseTyp(ContextHelper.getStringSafe(request, "selSzCdSvcAuthEICaseType"));

    String region = FormattingHelper
                                    .initCapsName(Lookup
                                                        .simpleDecodeSafe(
                                                                          CodesTables.CCNTYREG,
                                                                          ContextHelper
                                                                                       .getStringSafe(request,
                                                                                                      "selSzCdSvcAuthCounty")));
    ccon19si.setSzCdSvcAuthRegion(region);
    // This ulIdEvent needs to be populated from the output structure of ccon18so. It is a separate
    // ulIdEvent that was retrieved in the ccon18s service than the main ulIdEvent for the
    // service auth
    ccon19si.setUlIdEvent(ccon18so.getUlIdEvent());
    ccon19si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccon19si.setLdIdTodo(GlobalData.getUlIdTodo(request));
    ccon19si.setUlIdPrimaryClient(ContextHelper.getIntSafe(request, "selUlIdPrimaryClient"));
    ccon19si.setROWCCMN01UIG00(inputUIG00);
    ccon19si.setArchInputStruct(input);

    return ccon19si;

  }

  /**
   * populate CCON19SI Delete <p/> This method is used to populate ccon19si for deletion purposes. It sets the reqFuncCd
   * to delete
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return ccon19si
   */
  private CCON19SI populateCCON19SI_D(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    // Allocate the structures
    BaseSessionStateManager state = getSessionStateManager(context);

    CCON19SI ccon19si = new CCON19SI();
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 inputUIG00 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();

    // Retrieve ccon18so from state so that event items can be re-saved
    CCON18SO ccon18so = (CCON18SO) state.getAttribute(CCON18SO_S, request);

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    input.setSzUserId(user.getUserLogonID());

    // Only one row is ever saved or deleted, so statically set the page size number to 1

    inputUIG00.setSzCdTask(GlobalData.getSzCdTask(request));
    inputUIG00.setUlIdStage(GlobalData.getUlIdStage(request));
    ccon19si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccon19si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    ccon19si.setUlIdSvcAuth(ccon18so.getUlIdSvcAuth());
    ccon19si.setROWCCMN01UIG00(inputUIG00);
    ccon19si.setArchInputStruct(input);

    return ccon19si;

  }

  // The method populateCCON25SI_AU is removed as it is for APS and APS is not applicable for Georgia

  /**
   * populate CCON23SI Add Update <p/> This method is used to populate the ccon23si object for saving. It first checks
   * to see if the person array has items. If it does, it loops through all of the persons selected on the page and adds
   * a row for each person. Thus for each person selected an identical row will be added. Otherwise it saves the
   * information entered on the page directly and only saves one row.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return ccon23si
   */
  private CCON23SI populateCCON23SI_AU(GrndsExchangeContext context) throws SQLException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    String reqFuncCd = ContextHelper.getStringSafe(request, "hdnCReqFuncCd");
    //STGAP00013508: retrieve the "Authorization Type" on page load
    String cdAuthTypeOnLoad = ContextHelper.getStringSafe(request, "hdnSzCdSvcAuthDtlAuthType");
    Date date = new Date();
    ArchInputStruct input = new ArchInputStruct();
    // Allocate the structures

    // Retrieve ccon18so so that the ulIdSvcAuth
    CCON18SO ccon18so = (CCON18SO) state.getAttribute(CCON18SO_S, request);
    // Retrieve the Person Array so that a row can be saved for each person selected.
    ROWCCON22SOG00_ARRAY personArray = (ROWCCON22SOG00_ARRAY) state.getAttribute("ROWCCON22SOG00_ARRAY", request);
    
    CCON23SI ccon23si = new CCON23SI();
    ROWCCON23SIG00_ARRAY rowccon23sig00_array = new ROWCCON23SIG00_ARRAY();
    CCON22SO ccon22so = (CCON22SO) state.getAttribute("CCON22SO", request);
    int ulIdAdopAssistAppl = (ccon22so != null) ? ccon22so.getROWCCON22SOG01().getUlIdAdopAssistAppl() : 0;

    String szCdSvcAuthDtlAuthType = ContextHelper.getStringSafe(request, "selSzCdSvcAuthDtlAuthType");
    String szCdSvcAuthDtlPeriod = ContextHelper.getStringSafe(request, "selSzCdSvcAuthDtlPeriod");
    String szCdSvcAuthDtlSvc = ContextHelper.getStringSafe(request, "selSzCdSvcAuthDtlSvc");
    String szCdSvcAuthDtlUnitType = ContextHelper.getStringSafe(request, "hdnSzCdSvcAuthDtlUnitType");
    String isApproval = ContextHelper.getStringSafe(request, "isApprovalMode");
    org.exolab.castor.types.Date dtDtSvcAuthDtl = ContextHelper.getCastorDateSafe(request, "hdnDtDtSvcAuthDtl");
    org.exolab.castor.types.Date dtDtSvcAuthDtlBegin = ContextHelper.getCastorDateSafe(request,
                                                                                       "txtDtDtSvcAuthDtlBegin");
    org.exolab.castor.types.Date dtDtSvcAuthDtlEnd = ContextHelper.getCastorDateSafe(request, "txtDtDtSvcAuthDtlEnd");
    org.exolab.castor.types.Date dtDtSvcAuthDtlTerm = ContextHelper.getCastorDateSafe(request, "txtDtDtSvcAuthDtlTerm");
    Date tsLastUpdate = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnTsLastUpdate"));
    int ulIdSvcAuth = ccon18so.getUlIdSvcAuth();
    int ulIdSvcAuthDtl = ContextHelper.getIntSafe(request, "hdnUlIdSvcAuth");
    int uNbrSvcAuthDtlFreq = ContextHelper.getIntSafe(request, "txtUNbrSvcAuthDtlFreq");
    int ulNbrSvcAuthDtlLineItm = ContextHelper.getIntSafe(request, "hdnUlNbrSvcAuthDtlLineItm");
    int lNbrSvcAuthDtlSugUnit = ContextHelper.getIntSafe(request, "hdnLNbrSvcAuthDtlSugUnit");
    double lNbrSvcAuthDtlUnitRate = ContextHelper.getDoubleSafe(request, "hdnLNbrSvcAuthDtlUnitRate");
    double enteredUnitRate = ContextHelper.getDoubleSafe(request, "ulNbrCnsvcUnitRate");
    String rbIndServAcpt = ContextHelper.getStringSafe(request, "rbIndServAcpt");
    String rbIndCasePlnSvc = ContextHelper.getStringSafe(request, "rbIndCasePlnSvc");
    String szCdSvcQlty = ContextHelper.getStringSafe(request, "szCdSvcQlty");
    String szTxtRefQltyCmnts = ContextHelper.getStringSafe(request, "szTxtRefQltyCmnts");
    String szCdCnsvcPaymentType = ContextHelper.getStringSafe(request, "hdnSzCdCnsvcPaymentType");
    double lNbrSvcAuthDtlUnitUsed = ContextHelper.getDoubleSafe(request, "dspLNbrSvcAuthDtlUnitUsed");
    String szTxtCommentsAdditional = ContextHelper.getStringSafe(request, "szTxtCommentsAdditional");
    org.exolab.castor.types.Date fifteenFromTerm = null;
    if (dtDtSvcAuthDtlTerm != null) {
      fifteenFromTerm = DateHelper.addToDate(dtDtSvcAuthDtlTerm, 0, 0, -15);
    }
    // If these two variables are null from the request, we need to get the hidden field version
    double lNbrSvcAuthDtlUnitReq;
    double lAmtSvcAuthDtlAmtReq;
    if (request.getParameter("txtLNbrSvcAuthDtlUnitReq") != null) {
      lNbrSvcAuthDtlUnitReq = ContextHelper.getDoubleSafe(request, "txtLNbrSvcAuthDtlUnitReq");
    } else {
      lNbrSvcAuthDtlUnitReq = ContextHelper.getDoubleSafe(request, "hdnLNbrSvcAuthDtlUnitReq");
    }
    if (request.getParameter("txtLAmtSvcAuthDtlAmtReq") != null) {
      lAmtSvcAuthDtlAmtReq = ContextHelper.getMoneyAsDoubleSafe(request, "txtLAmtSvcAuthDtlAmtReq");
    } else {
      lAmtSvcAuthDtlAmtReq = ContextHelper.getMoneyAsDoubleSafe(request, "hdnLAmtSvcAuthDtlAmtReq");
    }

    // If Person Array has items in it (count is greater than 0) loop through all of the checkboxes
    // checked on the page and save a row for each person checked. Otherwise, there is only
    // there are no items in the person array, so only one row needs to be saved.

    if (personArray.getROWCCON22SOG00Count() > 0) {
      // Each checkbox that is checked indicates a row for a person that needs to be saved.
      // Loop through all of the checked checkboxes, and add a row for that person.

      String[] cbxValues = CheckboxHelper.getCheckedValues(request, "cbx_");

      for (int i = 0; i < cbxValues.length; i++) {
        ROWCCON23SIG00 rowccon23sig00 = new ROWCCON23SIG00();

        // SIR 16988 GRIMSHAN changed the retrieval of the person row so that it is getting
        // the cbxValues of i instead of just i, this is so the correct person will
        // be saved to the database
        ROWCCON22SOG00 personRow = personArray.getROWCCON22SOG00(Integer.parseInt(cbxValues[i]));

        rowccon23sig00.setSzCdSvcAuthDtlAuthType(szCdSvcAuthDtlAuthType);
        rowccon23sig00.setSzCdSvcAuthDtlPeriod(szCdSvcAuthDtlPeriod);
        rowccon23sig00.setSzCdSvcAuthDtlSvc(szCdSvcAuthDtlSvc);
        rowccon23sig00.setSzCdSvcAuthDtlUnitType(szCdSvcAuthDtlUnitType);

        // SIR 22573 - If the reqFuncCd is add, set the service auth detail
        // date to today, and do not set ulIdSvcAuth, else, set the date to
        // what it was previously saved as, and set ulIdSvcAuth to the one we
        // currently want to save
        if (reqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
          rowccon23sig00.setDtDtSvcAuthDtl(DateHelper.toCastorDate(date));
        } else {
          rowccon23sig00.setDtDtSvcAuthDtl(dtDtSvcAuthDtl);
          rowccon23sig00.setUlIdSvcAuthDtl(ulIdSvcAuthDtl);
        }
        rowccon23sig00.setDtDtSvcAuthDtlBegin(dtDtSvcAuthDtlBegin);
        rowccon23sig00.setDtDtSvcAuthDtlEnd(dtDtSvcAuthDtlEnd);

        // If the Auth Type is Terminate, save Terminate from the date entered in the field,
        // otherwise save it as the End Date
        if (TERMINATE.equals(szCdSvcAuthDtlAuthType)) {
          rowccon23sig00.setDtDtSvcAuthDtlTerm(dtDtSvcAuthDtlTerm);
        } else {
          rowccon23sig00.setDtDtSvcAuthDtlTerm(dtDtSvcAuthDtlEnd);
        }

        // If the current date is more than 15 days from the term date, set the show date to 15 days before
        // the term date. Other wise set the show date to the current date.
        double dayDifference = 0.0;
        if (dtDtSvcAuthDtlTerm != null) {
          dayDifference = DateHelper.minutesDifference(date, DateHelper.toJavaDate(dtDtSvcAuthDtlTerm));
        }
        if (dayDifference > 21600) {
          rowccon23sig00.setDtSvcAuthDtlShow(fifteenFromTerm);
        } else {
          rowccon23sig00.setDtSvcAuthDtlShow(DateHelper.toCastorDate(date));
        }

        rowccon23sig00.setTsLastUpdate(tsLastUpdate);
        rowccon23sig00.setUlIdSvcAuth(ulIdSvcAuth);
        rowccon23sig00.setUlIdPerson(personRow.getUlIdPerson());
        rowccon23sig00.setLAmtSvcAuthDtlAmtReq(lAmtSvcAuthDtlAmtReq);
        rowccon23sig00.setUNbrSvcAuthDtlFreq(uNbrSvcAuthDtlFreq);
        rowccon23sig00.setUlNbrSvcAuthDtlLineItm(ulNbrSvcAuthDtlLineItm);
        rowccon23sig00.setLNbrSvcAuthDtlSugUnit(lNbrSvcAuthDtlSugUnit);
        if (CodesTables.CCONPAY_VUR.equals(szCdCnsvcPaymentType)) {
          rowccon23sig00.setLNbrSvcAuthDtlUnitRate(enteredUnitRate);
        } else {
          rowccon23sig00.setLNbrSvcAuthDtlUnitRate(lNbrSvcAuthDtlUnitRate);
        }
        rowccon23sig00.setLNbrSvcAuthDtlUnitReq(lNbrSvcAuthDtlUnitReq);
        rowccon23sig00.setSzCdScrDataAction(reqFuncCd);
        rowccon23sig00.setIndServAcpt(rbIndServAcpt);
        rowccon23sig00.setIndCasePlanSvc(rbIndCasePlnSvc);
        rowccon23sig00.setSzCdSvcQlty(szCdSvcQlty);
        rowccon23sig00.setSzTxtRefQltyCmnts(szTxtRefQltyCmnts);
        rowccon23sig00.setLNbrSvcAuthDtlUnitUsed(lNbrSvcAuthDtlUnitUsed);
        rowccon23sig00.setSzTxtCommentsAdditional(szTxtCommentsAdditional);
        
        
        if(ulIdAdopAssistAppl > 0) {
          rowccon23sig00.setUlIdAdopAssistAppl(ulIdAdopAssistAppl);
        }
        
        rowccon23sig00_array.addROWCCON23SIG00(rowccon23sig00);
      }
      input.setUlPageSizeNbr(cbxValues.length);
    } else {
      ROWCCON23SIG00 rowccon23sig00 = new ROWCCON23SIG00();
      rowccon23sig00.setSzCdSvcAuthDtlAuthType(szCdSvcAuthDtlAuthType);
      rowccon23sig00.setSzCdSvcAuthDtlPeriod(szCdSvcAuthDtlPeriod);
      rowccon23sig00.setSzCdSvcAuthDtlSvc(szCdSvcAuthDtlSvc);
      rowccon23sig00.setSzCdSvcAuthDtlUnitType(szCdSvcAuthDtlUnitType);

      // SIR 22573 - If the reqFuncCd is add, set the service auth detail
      // date to today, and do not set ulIdSvcAuth, else, set the date to
      // what it was previously saved as, and set ulIdSvcAuth to the one we
      // currently want to save
      if (reqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {
        rowccon23sig00.setDtDtSvcAuthDtl(DateHelper.toCastorDate(date));
      } else {
        rowccon23sig00.setDtDtSvcAuthDtl(dtDtSvcAuthDtl);
        rowccon23sig00.setUlIdSvcAuthDtl(ulIdSvcAuthDtl);
      }
      rowccon23sig00.setDtDtSvcAuthDtlBegin(dtDtSvcAuthDtlBegin);
      rowccon23sig00.setDtDtSvcAuthDtlEnd(dtDtSvcAuthDtlEnd);

      // If the Auth Type is Terminate, save Terminate from the date entered in the field,
      // otherwise save it as the End Date
      if (TERMINATE.equals(szCdSvcAuthDtlAuthType)) {
        rowccon23sig00.setDtDtSvcAuthDtlTerm(dtDtSvcAuthDtlTerm);
      } else {
        rowccon23sig00.setDtDtSvcAuthDtlTerm(dtDtSvcAuthDtlEnd);
      }

      // If the current date is more than 15 days from the term date, set the show date to 15 days before
      // the term date. Other wise set the show date to the current date.
      double dayDifference = 0.0;
      if (dtDtSvcAuthDtlTerm != null) {
        dayDifference = DateHelper.minutesDifference(date, DateHelper.toJavaDate(dtDtSvcAuthDtlTerm));
      }
      if (dayDifference > 21600) {
        rowccon23sig00.setDtSvcAuthDtlShow(fifteenFromTerm);
      } else {
        rowccon23sig00.setDtSvcAuthDtlShow(DateHelper.toCastorDate(date));
      }

      rowccon23sig00.setTsLastUpdate(tsLastUpdate);
      rowccon23sig00.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnUlIdPerson"));
      rowccon23sig00.setUlIdSvcAuth(ulIdSvcAuth);
      rowccon23sig00.setLAmtSvcAuthDtlAmtReq(lAmtSvcAuthDtlAmtReq);
      rowccon23sig00.setUNbrSvcAuthDtlFreq(uNbrSvcAuthDtlFreq);
      rowccon23sig00.setUlNbrSvcAuthDtlLineItm(ulNbrSvcAuthDtlLineItm);
      rowccon23sig00.setLNbrSvcAuthDtlSugUnit(lNbrSvcAuthDtlSugUnit);
      if (CodesTables.CCONPAY_VUR.equals(szCdCnsvcPaymentType)) {
        rowccon23sig00.setLNbrSvcAuthDtlUnitRate(enteredUnitRate);
      } else {
        rowccon23sig00.setLNbrSvcAuthDtlUnitRate(lNbrSvcAuthDtlUnitRate);
      }
      rowccon23sig00.setLNbrSvcAuthDtlUnitReq(lNbrSvcAuthDtlUnitReq);
      rowccon23sig00.setSzCdScrDataAction(reqFuncCd);
      rowccon23sig00.setIndServAcpt(rbIndServAcpt);
      rowccon23sig00.setIndCasePlanSvc(rbIndCasePlnSvc);
      rowccon23sig00.setSzCdSvcQlty(szCdSvcQlty);
      rowccon23sig00.setSzTxtRefQltyCmnts(szTxtRefQltyCmnts);
      rowccon23sig00.setLNbrSvcAuthDtlUnitUsed(lNbrSvcAuthDtlUnitUsed);
      rowccon23sig00.setSzTxtCommentsAdditional(szTxtCommentsAdditional);
      
      if(ulIdAdopAssistAppl > 0) {
        rowccon23sig00.setUlIdAdopAssistAppl(ulIdAdopAssistAppl);
      }
      
      rowccon23sig00_array.addROWCCON23SIG00(rowccon23sig00);

      input.setUlPageSizeNbr(1);
    }

    ccon23si.setUlIdContract(ccon18so.getUlIdContract());
    ccon23si.setDtDtStageStart(ContextHelper.getCastorDateSafe(request, "hdnDtDtStageStart"));
    ccon23si.setUlIdPerson(user.getUserID());
    ccon23si.setUlIdCntrctManager(ccon18so.getUlIdCntrctManager());
    ccon23si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    ccon23si.setUlIdStage(GlobalData.getUlIdStage(request));
    ccon23si.setUlIdResource(ccon18so.getUlIdResource());
    ccon23si.setUlNbrCnperPeriod(ccon18so.getUlNbrCncntyPeriod());
    ccon23si.setUlNbrCnverVersion(ccon18so.getUlNbrCncntyVersion());
    ccon23si.setSzSysCdTodoCf("CON004");
    ccon23si.setCIndCntrctBudgLimit(ccon18so.getCIndCntrctBudgLimit());
    ccon23si.setSzCdStage(GlobalData.getSzCdStage(request));
    input.setSzUserId(user.getUserLogonID());
    ccon23si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccon23si.setArchInputStruct(input);
    ccon23si.setROWCCON23SIG00_ARRAY(rowccon23sig00_array);
    ccon23si.setIsApprovalMode(GlobalData.isApprovalMode(request));
    //STGAP00013508: populate the hidden attribute to the ccon23si object to pass it onto the service
    ccon23si.setHdnSzCdSvcAuthDtlAuthType(cdAuthTypeOnLoad);

    return ccon23si;

  }

  /**
   * reset Header Information <p/> This method is used to set header information into state so that it will be available
   * after Resource pullback has been completed.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void resetHeaderInformation(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".resetHeaderInformation_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CCON18SO ccon18so = (CCON18SO) state.getAttribute(CCON18SO_S, request);

    ccon18so.setSzCdSvcAuthRegion(ContextHelper.getStringSafe(request, "selSzCdSvcAuthRegion"));
    ccon18so.setSzCdSvcAuthCategory(ContextHelper.getStringSafe(request, "selSzCdSvcAuthCategory"));
    ccon18so.setDtDtSvcAuthEff(ContextHelper.getCastorDateSafe(request, "txtDtDtSvcAuthEff"));
    ccon18so.setSzCdSvcAuthCounty(ContextHelper.getStringSafe(request, "selSzCdSvcAuthCounty"));
    ccon18so.setSzCdSvcAuthCategory(ContextHelper.getStringSafe(request, "selSzCdSvcAuthCategory"));
    ccon18so.setSzCdPayCnty(ContextHelper.getStringSafe(request, "selSzCdSvcAuthPayCounty"));
    ccon18so.setCIndWaiverReqd(ContextHelper.getStringSafe(request, "cbxIndWaiverReqd"));
    ccon18so.setDtDtRefSent(ContextHelper.getCastorDateSafe(request, "txtDtRefSent"));
    ccon18so.setSzCdErlyCaseTyp(ContextHelper.getStringSafe(request, "selSzCdSvcAuthEICaseType"));
    ccon18so.setSzCdPupOtcme(ContextHelper.getStringSafe(request, "rbCIndPupOutCmTyp"));
    ccon18so.setSzCdPupOtcme(ContextHelper.getStringSafe(request, "selSzCdPupOtcme"));
    ccon18so.setSzCdSvcAuthService(ContextHelper.getStringSafe(request, "selSzCdSvcAuthService"));
    ccon18so.setSzTxtSvcAuthComments(ContextHelper.getStringSafe(request, "txtSzTxtSvcAuthComments"));
    ccon18so.setSzTxtSvcAuthSecProvdr(ContextHelper.getStringSafe(request, "txtSzTxtSvcAuthSecProvdr"));
    state.setAttribute(CCON18SO_S, ccon18so, request);
    state.setAttribute("primaryClient", ContextHelper.getStringSafe(request, "selUlIdPrimaryClient"), request);

    performanceTrace.exitScope();
  }

  /**
   * To ensure that all children on case have Child Detail conpleted, also if there is any child over 14 years of age a
   * WTLP needs to be created and approved for that child
   * 
   * @param context
   * @return
   */

  private void handleError(ServiceException we, GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();

    // HttpServletRequest request = context.getRequest();
    int errorCode = we.getErrorCode();
    switch (errorCode) {
    case Messages.MSG_APRV_ADOPT_PLCMT_REQD: //MR-52
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_DUPLICATE_RECORD:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SVC_AUTH_NO_PLCMT:
    case Messages.SQL_NOT_FOUND:
    case Messages.ARC_ERR_BAD_FUNC_CD:
    case Messages.MSG_SYS_MULT_INST:
    case Messages.MSG_SVC_AUTH_DETAIL_REQ:
    case Messages.MSG_BUDGET_EXCEEDED:
    case Messages.MSG_SPEC_SVC_ADO_PAD:
      setPresentationBranch(ERROR, context);
      setErrorMessage(errorCode, DISPLAY_AUTH_HEADER, context.getRequest());
      break;
    default:
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
      break;
    }
    performanceTrace.exitScope();
  }
 
  private void displayInformationalMessage(GrndsExchangeContext context, CCON22SO ccon22so) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayInformationalMessage");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    String servTypeAmtMessage = StringHelper.EMPTY_STRING;
    servTypeAmtMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_SS_APRV),
                                                           Lookup.simpleDecodeSafe(CodesTables.CSPLSERV,
                                                                                   ccon22so.getSzCdSplServType()));
    servTypeAmtMessage = MessageLookup.addMessageParameter(servTypeAmtMessage,
                                                           FormattingHelper.formatMoney(ccon22so.getSzSpcSvcAprvAmt()));

    if (StringHelper.isNotEmptyOrNull(servTypeAmtMessage)) {
      setInformationalMessage(servTypeAmtMessage, DISPLAY_AUTH_DETAIL, request);
    }
    performanceTrace.exitScope();
  }
}
