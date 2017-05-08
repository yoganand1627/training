package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN95SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB48SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB49SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB80SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfRemovalPriorToAllegIncidentSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB15SIG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB49SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB49SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB80SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB80SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN95SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB48SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB49SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB80SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN95SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB14SOG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB48SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB48SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB80SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB80SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;
/*End SIR#22912 */

/**
 * CnsrvtrshpRemovalConversation - The Conservatorship Removal Conversation.
 *
 * @author Bryon Jacob
 * @version 1.0
 */

/**
 * Change History: 
 * Date         User                  Description 
 * ---------------------------------------------------------------------------------------------------- 
 * 05/05/02     DEMOMA (mad)          Sir 16938 removed personListPullBackInfo replace with 
 *                                    PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME 
 * 05/05/02     DEMOMA (mad)          In CSUB49SI populateCSUB49SI_Save() change hard coded CD_TASK to GlobalData.getSzCdTask(request) 
 *                                    toGlobalData.getSzCdTask(request) 
 * 05/10/2003   KRD                   SIR 17233 - Code changes applied to support "Approver Mode" providing supervisors the ability 
 *                                    to modify data without invalidating the pending approval.  Required changes to populateCSUB15SI_Save(), 
 *                                    createCSUB15SIArchInputStruct() and createROWCCMN01UIG00(). 
 * 06/06/03     GRIMSHAN              SIR 16979 - Retrieve page mode from event search conversation if the page mode does not need to be 
 *                                    changed, it will not be
 * 07/13/03     GRIMSHAN              SIR 18905 - Updating the page wasn't working, a separate timestamp is needed for ROWCSUB15SIG00 
 * 01/15/04     Hadjimh               SIR#22580 AFCARS Review exception item:  Need to ensure that the "date entered" for CVS removal events 
 *                                    is the date entered into the system, not the "effective date" that is entered in the window. 
 * 06/14/04     Hadjimh               SIR# 22912. When you complete a Conservatorship Removal for a child whose only selection for Race is 
 *                                    Am Indian/AK Native, there is an Attention message to notify the appropriate Indian Tribal Counsel of 
 *                                    the Removal.  Since the threshold for involvement of an Indian Tribal Counsel is 1/8 Indian, the Attention 
 *                                    message should present if ANY Race selection is Am Indian/AK Native. 
 * 8/20/2004    gerryc                SIR 22988 - pass the case id to ROWCSUB15SIG00 so that if the removal date is changed to a date in the past, 
 *                                    the SUB and FSU start dates can be updated to the new removal date.
 * 06/11/08     SWR                   STGAP00008568 - Added message for safety resource.
 * 05/26/2010   hjbaptiste            SMS#51977-MR66-Maltreatment In Care: Added method to check if the the removal date is prior any of the 
 *                                    child's allegation incident date
 * 08/12/2010   hjbaptiste            SMS#65423: MR-71 Changes
 * 08/18/2010   hjbaptiste            SMS#65423: Set Task Code of Custody from which ever stage that it is created from GlobalData. This is done
 *                                    in order to forward user to the correct Custody List page when Saving a Legal Status from Custody
 * 12/03/2010   htvo                  SMS#81140 MR-074 AFCARS: add child-related removal reasons data retrieval    
 * 12/28/2010   htvo                  SMS#89031: fixed NPE in Copy mode; used getCheckedIndicators for all page modes to get value in a disabled cbx                                                  
 * 04/25/2011   hnguyen               SMS#106721: Added logic to save previously selected removal reasons. Current logic only save newly selected reasons only.                                                  
 * 09/20/2011   schoi                 STGAP00017013: MR-095 Added retrieve logic for the new section Foster Care Principals List for FCC Stage
 * 10/02/2011   schoi                 STGAP00017013: MR-095 Added save logic for the new section Foster Care Principals List for FCC Stage
 * 10/08/2011   schoi                 STGAP00017013: MR-095 Added validation for any update made via Custody after
 *                                    comparing with Caregiver/Parental Relationship for Child section on the Person Detail page
 * 
 */
//***************************************************************************************

public class CnsrvtrshpRemovalConversation
        extends BaseHiddenFieldStateConversation {

  private static final String WARN_STRING = "warn";
  
  private CaseMgmt casemgmt = null;
  private Intake intake = null;
  private Common common = null;

  public void setCaseMgmt(CaseMgmt casemgmt) {
    this.casemgmt = casemgmt;
  }

  public void setIntake(Intake intake) {
    this.intake = intake;
  }

  public void setCommon(Common common) {
    this.common = common;
  }

  /**
   * execute the "displayCnsrvtrshpRemoval" action -- redisplay the Conservatorship Removal page.
   * <p/>
   * <p>The following services are used: <blockquote><ul> <li>CSUB14S - Lookup the Conservatorship Removal data</li>
   * <li>CSUB48S - Lookup the "Persons at home at removal" data</li> </ul></blockquote></p>
   *
   * @param context the GRNDS exchange context
   */
  public void displayCnsrvtrshpRemoval_xa(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCnsrvtrshpRemoval_xa()");
    performanceTrace.enterScope();

    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    // Save the pageMode because New Using is a combination of 'Adding' a new record and 'Updating' an
    // existing record (getting info from an old record)

    // SIR 16979 get pagemode from event search conversation, if it does not need
    // to be re-set it will not be
    String pageMode = EventSearchConversation.getEventDetailPageMode(request);

    if ("P".equals(pageMode)) {
      pageMode = state.getAttribute("startingPageState", request).toString();
    } else {
      // Clear the state.
      state.removeAllAttributes(request);
    }
    // save pageMode in state so that I can retrieve it when I come back from person list

    state.setAttribute("startingPageState", pageMode, request);

    //Get app mode so we know if we are in 'new using' or 'add' or updating an exiting event

//    int ulIdEvent = GlobalData.getUlIdEvent(request);
    // check to see if we have already called out to the PersonList to get the PullBack object
    PersonListPullBackInfo info = verifyPersonListInfo(context);
    // Restore page mode to the value it was before you cleared state
    PageMode.setPageMode(pageMode, request);
    // if not, then we need to call out to the PersonList to populate the object unless it is an
    // existing event
    if ((PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)
         || PageMode.getPageMode(request).equals(PageModeConstants.NEW))
        && info == null) {
      forwardToPersonlist(context);
    }
    // otherwise, we can go ahead and display the page
    else {
      displayPage(context, info);
    }

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * execute the "save" action - saves Conservatorship Removal data to the DB.
   * <p/>
   * <p>The following services are used: <blockquote><ul> <li>CSUB15S - Save the Conservatorship Removal data</li>
   * <li>CSUB49S - Save the "Persons at home at removal" data</li> </ul></blockquote></p>
   *
   * @param context the GRNDS exchange context
   */
  public void save_xa(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".save_xa()");
    performanceTrace.enterScope();
    CSUB15SO csub15so = new CSUB15SO();
    CSUB49SO csub49so = new CSUB49SO();
    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // get the personListPullBackInfo and the CSUB14SO from the page state
    PersonListPullBackInfo info = (PersonListPullBackInfo) state.getAttribute(
            PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, request);
    CSUB14SO csub14so = (CSUB14SO) state.getAttribute("csub14so", request);
    // determine whether there has been any change to the "Persons in Home" section of the page
    boolean changedPersonsInHome = changedPersonsInHome(state, request);
    //PageMode.setPageMode(pageMode, request);
    // get the ulIdEvent from the state, or from the DB if it has not been retrieved yet
    //int ulIdEvent = getUlIdEvent( state, request, info );
    int ulIdEvent = GlobalData.getUlIdEvent(request);

    try {
      String pageMode = PageMode.getPageMode(request);
      // call the CSUB15S service to save the information for this page
      CSUB15SI csub15si = populateCSUB15SI_Save(context, info, csub14so, ulIdEvent);
      try {
        
        // MR-66: Warn the user about entering the Removal Date earlier than the Date of Alleged Incident on the Allegations
        boolean removalPriorToAllegIncident = false;
        if (!ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnRemovalConfirmed"))) {
          Date dtRemoval = DateHelper.toJavaDate(ContextHelper.getCastorDateSafe(request, "dtDtRemoval"));
          //CSUB14SO csub14so = (CSUB14SO) state.getAttribute("csub14so", request);
          if (csub14so != null) {
            state.removeAttribute("warnRemovalPriorAllegIncident", request);
            ROWCSUB14SOG00 row = csub14so.getROWCSUB14SOG00();
            removalPriorToAllegIncident = checkIfRemovalPriorToAllegIncident(row.getUlIdVictim(), dtRemoval);
            if (removalPriorToAllegIncident) {
              state.setAttribute("warnRemovalPriorAllegIncident", ArchitectureConstants.Y, request);
              ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
              setPresentationBranch(WARN_STRING, context);
              return;
            }
          }
        }
        // STGAP00017013: MR-095
        CSUB80SI csub80si = populateCSUB80SI_Save(context);
        
        // begin a transaction
        csub15so = casemgmt.saveConservatorshipRemoval(csub15si, csub80si);
        // put the csub15so into state
        state.setAttribute("csub15so", csub15so, request);

        // only try to save the "Persons in Home" info if changes have been made
        // or if NEW_USING then always save "Persons in Home"
        if (changedPersonsInHome || PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
          // call the CSUB49S service to save "Persons in Home" info from this page
          CSUB49SI csub49si = populateCSUB49SI_Save(context);
          csub49so = casemgmt.savePersonsInHomeRemoval(csub49si);
        }
        // MR-071 When creating a new Custody, forward user to the Legal Status Detail page
        if (PageModeConstants.NEW.equals(pageMode) || PageModeConstants.NEW_USING.equals(pageMode)) {
          state.setAttribute("custodyDate", ContextHelper.getCastorDateSafe(request, "dtDtRemoval"), request);
          int idSUBStage = csub15so.getUlIdSUBStage();
          state.setAttribute("idSUBStage", idSUBStage, request);
          String cdTask = GlobalData.getSzCdTask(request);
          state.setAttribute("custodyCdTask", cdTask, request);
          String forwardUrl = "/subcare/LegalStatus/displayLegalStatus";
          forward(forwardUrl, request, context.getResponse());
        }
      }

      finally {
        // end the transaction
        //  WtcHelper.endTuxedoTransaction(wth);
      }
    }
    catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
        case Messages.MSG_SUB_CHILD_OVER_18:
        case Messages.MSG_SUB_PLCMT_CHAR_NEEDED:
        case Messages.MSG_SUB_SUBC_STAGE_EXISTS:
        
        case Messages.MSG_LB_TOO_MANY_ROWS:

          //setErrorMessage( MessageLookup.getMessageByNumber( errorCode ), request );
          displayMessagePage(errorCode, context);
          break;

          // for the following error codes, lookup the string and display it
        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        case Messages.MSG_SYS_STAGE_CLOSED:
        case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        case Messages.MSG_SYS_MULT_INST:
          this.setPresentationBranch("error", context);
          setErrorMessage(MessageLookup.getMessageByNumber(errorCode), request);
          break;
        // STGAP00017013: MR-095
        case Messages.MSG_CONFIRM_CP_SECTION_MISMATCH:
          this.setPresentationBranch("error", context);
          request.setAttribute("errorCode", Messages.MSG_CONFIRM_CP_SECTION_MISMATCH);
          ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
          break;
        default:
          // otherwise, we don't know what to do -- it's a severe exception
          processSevereException(context, we);
          break;
      }
    }
    catch (Exception e) {
      // we don't know what to do -- it's a severe exception
      processSevereException(context, e);
    }

    // display the page again
    //displayCnsrvtrshpRemoval_xa( context );

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * determine whether there have been any changes made on the "Persons in Home" section of the page
   *
   * @param state   the page state
   * @param request the page request
   * @return true if changes have been made on the "Persons in Home" section, false otherwise
   */
  private boolean changedPersonsInHome(BaseSessionStateManager state, HttpServletRequest request) {
    // initialize to false
    boolean changedPersonsInHome = false;

    // get the output of the CSUB48S service
    CSUB48SO csub48so = (CSUB48SO) state.getAttribute("csub48so", request);

    // step through the rows returned from the CSUB48S service
    Enumeration enumeration = csub48so.getROWCSUB48SOG00_ARRAY().enumerateROWCSUB48SOG00();
    while (enumeration.hasMoreElements()) {
      // for each row...
      ROWCSUB48SOG00 row = (ROWCSUB48SOG00) enumeration.nextElement();
      String cbxName = "cbxPersonsAtHome_" + row.getUlIdPerson();
      // determine if the corresponding checkbox is checked on the page
      boolean currentlyChecked = IND_YES.equals(CheckboxHelper.getCheckboxValue(request, cbxName));
      if ((currentlyChecked) && (!IND_YES.equals(row.getCScrIndRefChildMatch()))) {
        row.setCScrIndRefChildMatch("N");
      }
      // if the box is checked, but it wasn't initially, or if it is unchecked, but it was initially checked -
      // that's a change, so set the return value to true, and break
      if ((currentlyChecked) && IND_NO.equals(row.getCScrIndRefChildMatch()) ||
          (!currentlyChecked) && IND_YES.equals(row.getCScrIndRefChildMatch())) {
        changedPersonsInHome = true;
        break;
      }
    }
    // return the flag
    return changedPersonsInHome;
  }

  /**
   * forward to the Person List to allow the user to select the person to be removed.
   *
   * @param context the GRNDS exchange context
   */
  private void forwardToPersonlist(GrndsExchangeContext context) {
    // retrieve the state and request objects from the Session Manager
    HttpServletRequest request = context.getRequest();

    // construct a new object and set this command as the return URL, then put the object on the request
    PersonListPullBackInfo info = new PersonListPullBackInfo();
    info.setDestinationUrl("/subcare/CnsrvtrshpRemoval/displayCnsrvtrshpRemoval");
    request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, info);
    // set the page mode to SELECT for the call to PersonList
    PageMode.setPageMode(PersonListConversation.PAGE_MODE_PRINC_ONLY, request);

    try {
      // forward to the PersonList
      forward("/person/PersonList/displayPersonList", request, context.getResponse());
    }
    catch (ServletException e) {
      // we don't know what else to do if this happens
      processSevereException(context, e);
    }
  }

  /**
   * once we have called PersonList, this method serves to display the page.
   *
   * @param context the GRNDS exchange context
   * @param info    the PullBack info from the PersonList
   */
  private void displayPage(GrndsExchangeContext context,
                           PersonListPullBackInfo info) {
    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    CSUB14SO csub14so = new CSUB14SO();
    CSUB48SO csub48so = new CSUB48SO();
    // STGAP00017013: MR-095
    CSUB80SO csub80so = new CSUB80SO();
    
    // get the ulIdEvent from the state, or from the DB if it has not been retrieved yet
    //int ulIdEvent = getUlIdEvent( state, request, info );
    int ulIdEvent = GlobalData.getUlIdEvent(request);

    // set the page mode to NEW,NEW_Using or MODIFY, depending on whether we have already removed this child
    // NEW causes SUB and FSU stages to be created after first removal New and New Using create a 'SUB' stage
    PageMode.setPageMode(state.getAttribute("startingPageState", request).toString(), request);

    try {
      // call the CSUB14S service to retrieve the information for this page
      CSUB14SI csub14si = populateCSUB14SI_Retrieve(context, info, ulIdEvent);

      csub14so = casemgmt.findConservatorShipRemovalInformation(csub14si);

      // set the service return object from the service call into state
      state.setAttribute("csub14so", csub14so, request);

      // set the child's full name into GlobalData so it can be seen in the header Info1
      GlobalData.setSzNmPersonFull(csub14so.getSzNmPersonFull(), request);

      // set the initial state of the checkboxes from the returned service object
      request.setAttribute(CHECKED_CHILD_CHARS, getCheckedChildChars(context, csub14so));
      // MR-074
      //request.setAttribute(CHECKED_CARE_TAKER_CHARS, getCheckedCareTakerChars(context, csub14so)); 
      List checkedRemovalReasons = getCheckedRemovalReasons(context, csub14so);
      request.setAttribute(CHECKED_REMOVAL_REASONS, checkedRemovalReasons);
      //request.setAttribute(CHECKED_REMOVAL_REASONS_CHILD, checkedRemovalReasons); 

      // if the ulIDEvent fiels is not 0, then we should warn the user about the pending approval
      if (csub14so.getUlIdEvent() != 0 && !GlobalData.isApprovalMode(request)) {
        setInformationalMessage(
                MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL),
                "/subcare/CnsrvtrshpRemoval/displayCnsrvtrshpRemoval", request);
        setPopUpMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL_POPUP),
                        "/subcare/CnsrvtrshpRemoval/displayCnsrvtrshpRemoval",
                        request);
      }
      /* SIR#22912. added a boolean bRace to check if the race list includes any
       * American Indian race.
       */
      boolean bRace = false;
      if (info != null) {
        CCMN95SO ccmn95so = getRace(context, info);
        if (ccmn95so != null) {
          Enumeration enumeration = ccmn95so.getROWCCMN95SOG00_ARRAY().enumerateROWCCMN95SOG00();
          while (enumeration.hasMoreElements()) {
            ROWCCMN95SOG00 row = (ROWCCMN95SOG00) enumeration.nextElement();
            String sRace = row.getSzCdPersonRace();
            if (sRace.compareToIgnoreCase(CodesTables.CRACE_AA) == 0) {
              bRace = true;
              break;
            }
          }
        }
      }
      // sir#  22912. added the bRace boolean to the if statement
      // if the child is American Indian, remind the user to notify the Tribe
      if (CodesTables.CETHNIC_AI.equals(csub14so.getSzCdPersonEthnicGroup()) || bRace) {
        setInformationalMessage(
                MessageLookup.getMessageByNumber(Messages.MSG_SUB_NOTIFY_IND_TRIBE),
                "/subcare/CnsrvtrshpRemoval/displayCnsrvtrshpRemoval", request);
      }

      // call the CSUB48S service to retrieve the information for this page
      CSUB48SI csub48si = populateCSUB48SI_Retrieve(context, ulIdEvent);
      csub48so = casemgmt.retrievePersonsInHomeRemoval(csub48si);
      
      // STGAP00017013: MR-095
      // call the CSUB80S service to retrieve the information for this page
      CSUB80SI csub80si = populateCSUB80SI_Retrieve(context, info, ulIdEvent);
      csub80so = casemgmt.retrieveFosterCarePrincipalList(csub80si); 
      // End STGAP00017013: MR-095
      
      //if the is NEW_USING the date of removal is not know yet may not be the same as the date of the
      //record used
      if (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))) {
        csub14so.getROWCSUB14SOG00().setDtDtRemoval(null);
        csub14so.getROWCSUB14SOG00().setLNbrRemovalAgeMo(0);
        csub14so.getROWCSUB14SOG00().setLNbrRemovalAgeYr(0);
        csub14so.getROWCSUB14SOG00().setTsLastUpdate(null);
        for (int numberRows = 0; numberRows < csub14so.getROWCSUB14SOG01_ARRAY().getUlRowQty(); numberRows++) {
          csub14so.getROWCSUB14SOG01_ARRAY().getROWCSUB14SOG01(numberRows).setTsLastUpdate(null);
        }
        
        // SMS#89031: this array can now be null due to AFCARS phase 1 changes: char is retrieved instead of save to seperate table
        // added null check to prevent NPE
        if (csub14so.getROWCSUB14SOG02_ARRAY() != null) {
	        for (int numberRows = 0; numberRows < csub14so.getROWCSUB14SOG02_ARRAY().getUlRowQty(); numberRows++) {
	          csub14so.getROWCSUB14SOG02_ARRAY().getROWCSUB14SOG02(numberRows).setTsLastUpdate(null);
	        }
        }
        csub14so.getROWCSUB14SOG04().setSzCdEventStatus("NEW");
      }

      // set the service return object from the service call into state
      state.setAttribute("csub48so", csub48so, request);
      // STGAP00017013: MR-095
      state.setAttribute("csub80so", csub80so, request);
    }
    catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
        // for each of the following messages, lookup the display string, and display it.
        case Messages.MSG_SUB_CHILD_OVER_18:
        case Messages.MSG_SUB_PLCMT_CHAR_NEEDED:
        case Messages.MSG_SUB_SUBC_STAGE_EXISTS:
        case Messages.MSG_LB_TOO_MANY_ROWS:
        case Messages.MSG_SUB_CHILD_AGE_REQ:
        // STGAP00017013: MR-095
        case Messages.MSG_UNKNOWN_GENDER_WARN:
        // SWR 06/11/08 STGAP00008568 - Added Error Message for Safety Resource Placements
        case Messages.MSG_SRP_CUSTODY_REM:
          //setErrorMessage( MessageLookup.getMessageByNumber( errorCode ), request );
          displayMessagePage(errorCode, context);
          break;
          // otherwise, we don't know what to do -- handle it as a severe exception
        default:
          processSevereException(context, we);
      }
    }
    catch (Exception e) {
      // we don't know what to do -- handle it as a severe exception
      processSevereException(context, e);
    }
  }

  /**
   * This helper method ensures that we have called out to the PersonList page, and puts the PullBackInfo into state.
   *
   * @param context the GRNDS Exchange Context
   * @return the PersonListPullBackInfo object, or null if we have not called PersonList yet
   */
  private PersonListPullBackInfo verifyPersonListInfo(GrndsExchangeContext context) {
    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // see if we have already called the PersonList and put a PersonListPullBackInfo into the state
    PersonListPullBackInfo info = (PersonListPullBackInfo) state.getAttribute(
            PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, request);

    // if not, see if we are just returning from the PersonList now...
    if (info == null) {
      // get the PullBack object from the request on return from the PersonList
      info = (PersonListPullBackInfo) request.getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);

      // if we got one...
      if (info != null) {
        // set the info object from the request into state
        state.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, info, request);
      }
    }

    // return the info object
    return info;
  }

  /**
   * returns the set of checked Removal Reasons -- initially populated from the service, populated on subsequent calls
   * from the page itself.
   *
   * @param context  the GRNDS exchange context
   * @param csub14so the output from the CSUB14S service
   * @return a List of all of the checked values.
   */
  private List getCheckedRemovalReasons(GrndsExchangeContext context,
                                        CSUB14SO csub14so) {
    List checkedRemovalReasons = null;
    List checkedRemovalReasonsChild = null;

    // if we are on the first display of the page
    if (!"true".equals(context.getRequest().getParameter("hdnReloadingCnsrvtrshpRemoval"))) {
      // create a new vector, and copy values from the CSUB14SO object into it
      checkedRemovalReasons = new ArrayList();
      if (csub14so.getROWCSUB14SOG01_ARRAY() != null) {
        Enumeration enumeration = csub14so.getROWCSUB14SOG01_ARRAY().enumerateROWCSUB14SOG01();
        while (enumeration.hasMoreElements()) {
          ROWCSUB14SOG01 rowcsub14SOG01 = (ROWCSUB14SOG01) enumeration.nextElement();
          checkedRemovalReasons.add(rowcsub14SOG01.getSzCdRemovalReason());
        }
      }
    }
    // otherwise...
    else {
      // get the checked values from the page, and return a list containing those values
      String[] checkedValues = CheckboxHelper.getCheckedValues(context.getRequest(), "cbxRemovalReasonsAdult");
      checkedRemovalReasons = copyStringArrayToList(checkedValues);
      // MR-074 AFCARS: populate the removal reason list with child-related removal reason
      String[] checkedValuesChild = CheckboxHelper.getCheckedValues(context.getRequest(), "cbxRemovalReasonsChild");
      checkedRemovalReasonsChild = copyStringArrayToList(checkedValuesChild);
      if (checkedRemovalReasonsChild != null && checkedRemovalReasonsChild.size() > 0) {
    	  checkedRemovalReasons.addAll(checkedRemovalReasonsChild);
      }
    }

    // return the list of checked values
    return checkedRemovalReasons;
  }

  /**
   * returns the set of checked Child Chars -- initially populated from the service, populated on subsequent calls from
   * the page itself.
   *
   * @param context  the GRNDS exchange context
   * @param csub14so the output from the CSUB14S service
   * @return a Vector of all of the checked values.
   */
  private List getCheckedChildChars(GrndsExchangeContext context,
                                    CSUB14SO csub14so) {
    List checkedChildChars = null;
    // if we are on the first display of the page
    if (!"true".equals(context.getRequest().getParameter("hdnReloadingCnsrvtrshpRemoval"))) {
      // create a new vector, and copy values from the CSUB14SO object into it
      checkedChildChars = new ArrayList();

      // if the "NA" indicator was present, that's the only checked value
      if (IND_YES.equals(csub14so.getROWCSUB14SOG00().getCIndRemovalNaChild())) {
        checkedChildChars.add(IND_NA);
      } else {
        // otherwise, copy the checked values
        if (csub14so.getROWCSUB14SOG02_ARRAY() != null) {
          Enumeration enumeration = csub14so.getROWCSUB14SOG02_ARRAY().enumerateROWCSUB14SOG02();
          while (enumeration.hasMoreElements()) {
            ROWCSUB14SOG02 rowcsub14SOG02 = (ROWCSUB14SOG02) enumeration.nextElement();
            checkedChildChars.add(rowcsub14SOG02.getSzCdRemovChildChar());
          }
        }
      }
    }
    // otherwise...
    else {
      // get the checked values from the page, and return a vector containing those values
      String[] checkedValues = CheckboxHelper.getCheckedValues(context.getRequest(), "cbxChildChars");
      checkedChildChars = copyStringArrayToList(checkedValues);
    }

    // return the vector of checked values
    return checkedChildChars;
  }

  /**
   * returns the set of checked Care Taker Chars -- initially populated from the service, populated on subsequent calls
   * from the page itself.
   *
   * @param context  the GRNDS exchange context
   * @param csub14so the output from the CSUB14S service
   * @return a Vector of all of the checked values.
   */
  private List getCheckedCareTakerChars(GrndsExchangeContext context,
                                        CSUB14SO csub14so) {
    List checkedCareTakerChars = null;

    // if we are on the first display of the page
    if (!"true".equals(context.getRequest().getParameter("hdnReloadingCnsrvtrshpRemoval"))) {
      // create a new vector
      checkedCareTakerChars = new ArrayList();

      // if the "NA" indicator was present, that's the only checked value
      if (IND_YES.equals(csub14so.getROWCSUB14SOG00().getCIndRemovalNACare())) {
        checkedCareTakerChars.add(IND_NA);
      } else {
        // otherwise, copy the checked values
        if (csub14so.getROWCSUB14SOG03_ARRAY() != null) {
          Enumeration enumeration = csub14so.getROWCSUB14SOG03_ARRAY().enumerateROWCSUB14SOG03();
          while (enumeration.hasMoreElements()) {
            ROWCSUB14SOG03 rowcsub14SOG03 = (ROWCSUB14SOG03) enumeration.nextElement();
            checkedCareTakerChars.add(rowcsub14SOG03.getSzCdRemovAdultChar());
          }
        }
      }
    }
    // otherwise...
    else {
      // get the checked values from the page, and return a vector containing those values
      String[] checkedValues = CheckboxHelper.getCheckedValues(context.getRequest(), "cbxCareTakerChars");
      checkedCareTakerChars = copyStringArrayToList(checkedValues);
    }

    // return the vector of checked values
    return checkedCareTakerChars;
  }

  /**
   * utility method to copy the values in a string array into a Vector object.
   *
   * @param array the String array to copy
   * @return the new Vector, whose values mirror the values from the array
   */
  private static List copyStringArrayToList(String[] array) {
    // allocate a new Vector
    List list = new ArrayList();

    // add each element of the array to the list
    for (int i = 0; i < array.length; i++) {
      list.add(array[i]);
    }

    // return the list
    return list;
  }

// -------------------------------------------------------------------------------------------------------

  /**
   * allocate and populate a CSUB14SI service input object.
   *
   * @param context   the GRNDS exchange context
   * @param info      the PullBack info from the PersonList
   * @param ulIdEvent the event ID of this person's removal, or 0 if this is a new removal
   * @return the new CSUB14SI object
   */
  private CSUB14SI populateCSUB14SI_Retrieve(GrndsExchangeContext context,
                                             PersonListPullBackInfo info,
                                             int ulIdEvent) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSUB14SI_Retrieve()");
    performanceTrace.enterScope();

    // get the request and user info from the context
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);

    // construct the service input object and its ArchInputStruct
    CSUB14SI csub14si = new CSUB14SI();
    csub14si.setArchInputStruct(createCSUB14SIArchInputStruct(user));

    // set the stage information from Global Data, and the ID of the person returned from the PersonList
    csub14si.setUlIdStage(GlobalData.getUlIdStage(request));
    csub14si.setUlIdEvent(ulIdEvent);
    csub14si.setSzSysCdWinMode(state.getAttribute("startingPageState", request).toString());
    //New and New Using have the person id in info, all the existing event needs is its event id
    if (info != null) {
      csub14si.setUlIdPerson(info.getPersonListRow().getUlIdPerson());
    }
    // and the person id is zero
    else {
      csub14si.setUlIdPerson(0);
    }

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the service input object
    return csub14si;
  }

  /**
   * populate the CSUB15SI service input object.
   *
   * @param context   the GRNDS exchange context
   * @param info      the PullBack info from the PersonList
   * @param csub14so  the output from the CSUB14S service
   * @param ulIdEvent the event ID of this person's removal, or 0 if this is a new removal
   * @return the new CSUB15SI object
   */
  private CSUB15SI populateCSUB15SI_Save(GrndsExchangeContext context,
                                         PersonListPullBackInfo info,
                                         CSUB14SO csub14so,
                                         int ulIdEvent) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSUB15SI_Save()");
    performanceTrace.enterScope();

    // get the request and user info from the context
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    //Create new input structure to put user info into
    ArchInputStruct input = new ArchInputStruct();
    Date tsLastUpdate = null;
    Date tsLastUpdate2 = null;
    // get the previous time stamp or set to null if 'NEW_USING'
    // SIR 18905 There is a separate timestamp for ROWCSUB15SIG00
    if (PageModeConstants.MODIFY.equals(PageMode.getPageMode(request))) {
      tsLastUpdate = csub14so.getROWCSUB14SOG04().getTsLastUpdate();
      tsLastUpdate2 = csub14so.getROWCSUB14SOG00().getTsLastUpdate();
    } else {
      ulIdEvent = 0;
    }
    boolean noTimeStamp = ((tsLastUpdate == null) || (tsLastUpdate2 == null));
    // determine if the care taker "NA" button was checked
    String[] checkedCareTakerChars = CheckboxHelper.getCheckedValues(request, "cbxCareTakerChars");
    Arrays.sort(checkedCareTakerChars);
    boolean careTakerNA = Arrays.binarySearch(checkedCareTakerChars, IND_NA) >= 0;

    // determine if the child "NA" button was checked
    String[] checkedChildChars = CheckboxHelper.getCheckedValues(request, "cbxChildChars");
    Arrays.sort(checkedChildChars);
    boolean childNA = Arrays.binarySearch(checkedChildChars, IND_NA) >= 0;

    // get the removal date from the page
    org.exolab.castor.types.Date dtDtRemoval = ContextHelper.getCastorDateSafe(request, "dtDtRemoval");
    if (dtDtRemoval == null) {
      dtDtRemoval = csub14so.getROWCSUB14SOG00().getDtDtRemoval();
    }

    // construct the service input object
    CSUB15SI csub15si = new CSUB15SI();

    // set fields directly on the csub15si object
    input.setSzUserId(user.getUserLogonID());
    //
    // SIR 17233 - set the flag indicating approver mode
    //
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    csub15si.setArchInputStruct(input);
    /*  7/8/2003 - SPB SIR 18722
    *   See comment from CAPS window code CSUB34W.win:
    *        ** Added during string test 11/29/95
             ** Need to know if the user went into PersonHomeRemoval
             ** window in New Using mode.  If the person did go into
             ** Person Home Removal, we assume that they made selections
             ** and we DO NOT need to copy the rows from PersonHomeRemoval
             ** table that the new event is using as a prototype. If the
             ** user does not go into Person Home Removal window, we DO need
             ** to copy the rows from PersonHomeRemoval table.
             ** We are using bWCDIndSearchChange since it is not being
             ** used anywhere else in the program.
    *
    *  The indicator is no longer needed as the changedPersonsInHome() is taking care
    *  of it.  Setting it to yes will ensure that it will save correctly.
    */
    csub15si.setBWCDIndSearchChange(IND_YES); // changed from IND_NO -
    if (PageModeConstants.MODIFY.equals(PageMode.getPageMode(request))) {
      csub15si.setSzCdEventStatus("COMP");
    }

    if (info != null) {
      csub15si.setSzNmPersonFull(info.getPersonListRow().getSzNmPersonFull());
    } else {
      csub15si.setSzNmPersonFull(csub14so.getSzNmPersonFull());
    }

//    csub15si.setUlIdEvent( noTimeStamp ? 0: ulIdEvent );
    // SIR 18571 - This event id is the stage closure id, if it exists, and is
    //  only set from the csub14so ulIdEvent in the window code.
    csub15si.setUlIdEvent(csub14so.getUlIdEvent());
    csub15si.setSzSysCdWinMode(PageMode.getPageMode(request));

    // set up the ROWCCMN01UIG00
    csub15si.setROWCCMN01UIG00(createROWCCMN01UIG00(tsLastUpdate, request, dtDtRemoval, ulIdEvent));

    // set up the ROWCSUB15SIG00
    csub15si.setROWCSUB15SIG00(createROWCSUB15SIG00(context, tsLastUpdate2, dtDtRemoval, info, ulIdEvent, childNA,
                                                    careTakerNA, csub14so));

    // set up the ROWCSUB15SIG01_ARRAY array
    ROWCSUB15SIG01_ARRAY removalReasonsArray = createRemovalReasonsArray(request, ulIdEvent, csub14so);
    csub15si.setROWCSUB15SIG01_ARRAY(removalReasonsArray);

    // set up the ROWCSUB15SIG01_ARRAY array
    ROWCSUB15SIG02_ARRAY childCharsArray = createChildCharsArray(request, ulIdEvent, csub14so, childNA);
    csub15si.setROWCSUB15SIG02_ARRAY(childCharsArray);

    // set up the ROWCSUB15SIG03_ARRAY array
    ROWCSUB15SIG03_ARRAY careTakerCharsArray = createCareTakerCharsArray(request, ulIdEvent, csub14so, careTakerNA);
    csub15si.setROWCSUB15SIG03_ARRAY(careTakerCharsArray);

    // set up the UlPageSizeNbr array
    csub15si.setUlPageSizeNbr_ARRAY(createUlPageSizeNbrArray(
            removalReasonsArray.getUlRowQty(), childCharsArray.getUlRowQty()));

    // create the ArchInputStruct
    csub15si.setArchInputStruct(
            createCSUB15SIArchInputStruct(noTimeStamp, user, careTakerCharsArray.getUlRowQty(), request));
    
    // set security attribute value to recognize State Office Management and 
    csub15si.setSzCdAttrRegSsStf(UserProfile.SEC_REGIONAL_SS_STF);
    csub15si.setSzCdAttrStateOfficeMgmt(UserProfile.SEC_STATE_OFFICE_MGMNT);

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the service input object
    return csub15si;
  }

  /**
   * populates the CSUB48SI service input object for the call to the CSUB48S service.
   *
   * @param context   the GRNDS exchange context
   * @param ulIdEvent the event ID of this person's removal, or 0 if this is a new removal
   * @return the new CSUB48SI object
   */
  private CSUB48SI populateCSUB48SI_Retrieve(GrndsExchangeContext context,
                                             int ulIdEvent) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSUB48SI_Retrieve()");
    performanceTrace.enterScope();

    // construct the service input object and its ArchInputStruct
    CSUB48SI csub48si = new CSUB48SI();
    csub48si.setArchInputStruct(createCSUB48SIArchInputStruct(context));

    // set properties directly on the CSUB48SI
    csub48si.setUlIdStage(GlobalData.getUlIdStage(context.getRequest()));
    csub48si.setUlIdEvent(ulIdEvent);

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the service input object
    return csub48si;
  }

  // STGAP00017013: MR-095
  /**
   * populates the CSUB80SI service input object for the call to the CSUB80S service.
   *
   * @param context   the GRNDS exchange context
   * @param info      the PullBack info from the PersonList
   * @param ulIdEvent the event ID of this person's removal, or 0 if this is a new removal
   * @return the new CSUB80SI object
   */
  private CSUB80SI populateCSUB80SI_Retrieve(GrndsExchangeContext context,
                                             PersonListPullBackInfo info,
                                             int ulIdEvent) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSUB80SI_Retrieve()");
    performanceTrace.enterScope();
   
    // get the request and user info from the context
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    
    // construct the service input object and its ArchInputStruct
    CSUB80SI csub80si = new CSUB80SI();
    csub80si.setArchInputStruct(createCSUB80SIArchInputStruct(context));

    // set properties directly on the CSUB80SI
    csub80si.setUlIdStage(GlobalData.getUlIdStage(context.getRequest()));
    csub80si.setUlIdEvent(ulIdEvent);
    csub80si.setSzSysCdWinMode(state.getAttribute("startingPageState", request).toString());
    // New and New Using have the person id in info, all the existing event needs is its event id
    if (info != null) {
      csub80si.setUlIdPerson(info.getPersonListRow().getUlIdPerson());
    }
    // and the person id is zero
    else {
      csub80si.setUlIdPerson(0);
    }

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the service input object
    return csub80si;
  }
  
  /**
   * populate the CSUB49SI service input object.
   *
   * @param context the GRNDS exchange context
   * @return the new CSUB49SI object
   */
  private CSUB49SI populateCSUB49SI_Save(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSUB49SI_Save()");
    performanceTrace.enterScope();

    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // retreive the user data
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // construct the service input object
    CSUB49SI csub49si = new CSUB49SI();

    // set the fields directly onto the CSUB49SI

    csub49si.setSzCdTask(GlobalData.getSzCdTask(request));
    csub49si.setUlIdStage(GlobalData.getUlIdStage(request));

    // get the previous service output objects from state
    CSUB15SO csub15so = (CSUB15SO) state.getAttribute("csub15so", request);
    CSUB48SO csub48so = (CSUB48SO) state.getAttribute("csub48so", request);

    // setup the ROWCSUB49SIG00_ARRAY object
    ROWCSUB49SIG00_ARRAY rowcsub49SIG00_array = createROWCSUB49SIG00_ARRAY(csub48so, request, csub15so);
    csub49si.setROWCSUB49SIG00_ARRAY(rowcsub49SIG00_array);

    // create and set up the ArchInputStruct
    csub49si.setArchInputStruct(createCSUB49SIArchInputStruct(user, rowcsub49SIG00_array.getUlRowQty()));

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the service input object
    return csub49si;
  }

  /**
   * create the ArchInputStruct for the CSUB14S service input object.
   *
   * @param user user profile
   * @return the new ArchInputStruct object
   */
  private ArchInputStruct createCSUB14SIArchInputStruct(UserProfile user) {
    // allocate the new ArchInputStruct
    ArchInputStruct input = new ArchInputStruct();

    // set constants
    input.setBPerfInd("0");
    input.setBDataAcsInd("0");
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(35);

    // set the user's logon ID
    input.setSzUserId(user.getUserLogonID());
    return input;
  }

  // STGAP00017013: MR-095
  /**
   * populate the CSUB80SI service input object.
   *
   * @param context the GRNDS exchange context
   * @return the new CSUB80SI object
   */
  private CSUB80SI populateCSUB80SI_Save(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCSUB80SI_Save()");
    performanceTrace.enterScope();

    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // construct the service input object
    CSUB80SI csub80si = new CSUB80SI();
    
    // Declare variable to be used in this method
    boolean bIndCpValueCheck = "Y".equals(ContextHelper.getStringSafe(context, "hdnBIndCpValueCheck"));

    // set the fields directly onto the CSUB80SI
    csub80si.setUlIdStage(GlobalData.getUlIdStage(request));

    // get the previous service output objects from state
    // CSUB15SO csub15so = (CSUB15SO) state.getAttribute("csub15so", request);
    CSUB80SO csub80so = (CSUB80SO) state.getAttribute("csub80so", request);

    // setup the ROWCSUB49SIG00_ARRAY object
    ROWCSUB80SIG00_ARRAY rowcsub80SIG00_array = createROWCSUB80SIG00_ARRAY(request, csub80so);
    csub80si.setROWCSUB80SIG00_ARRAY(rowcsub80SIG00_array);

    // create and set up the ArchInputStruct
    csub80si.setArchInputStruct(createCSUB80SIArchInputStruct(context));

    // Items coming out of GlobalData
    csub80si.setBIndCpValueCheck(bIndCpValueCheck);
    
    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the service input object
    return csub80si;
  }

  /**
   * setup the ArchInputStruct for the CSUB15SI object.
   *
   * @param noTimeStamp             true iff there was a previous time stamp
   * @param user                    user profile
   * @param numCareTakerCharActions the number of actions to perform on the care taker chars table
   * @return the new ArchInputStruct
   */
  private ArchInputStruct createCSUB15SIArchInputStruct(boolean noTimeStamp,
                                                        UserProfile user,
                                                        int numCareTakerCharActions,
                                                        HttpServletRequest request) {
    // allocate the new ArchInputStruct
    ArchInputStruct input = new ArchInputStruct();

    // set the fixed values on the ArchInputStruct
    input.setBPerfInd("0");
    input.setBDataAcsInd("0");
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(numCareTakerCharActions);

    // set the function to "A" or "U", depending on whether there was a previous save
    input.setCReqFuncCd(noTimeStamp ? ACTION_ADD : ACTION_UPDATE);

    // set user logon info
    input.setSzUserId(user.getUserLogonID());

    //
    // SIR 17233 - set the flag indicating approver mode
    //
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    // return the new ArchInputObject
    return input;
  }

  /**
   * allocate and populate the ArchInputStruct for the CSUB48SI service input object.
   *
   * @param context the GRNDS exchange context
   * @return the new ArchInputStruct
   */
  private ArchInputStruct createCSUB48SIArchInputStruct(GrndsExchangeContext context) {
    // allocate a new ArchInputStruct
    ArchInputStruct input = new ArchInputStruct();

    // retrieve the user profile
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // set the required fields
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(125);
    input.setSzUserId(user.getUserLogonID());

    // return the new ArchInputStruct
    return input;
  }

  // STGAP00017013: MR-095
  /**
   * allocate and populate the ArchInputStruct for the CSUB80SI service input object.
   *
   * @param context the GRNDS exchange context
   * @return the new ArchInputStruct
   */
  private ArchInputStruct createCSUB80SIArchInputStruct(GrndsExchangeContext context) {
    // allocate a new ArchInputStruct
    ArchInputStruct input = new ArchInputStruct();

    // retrieve the user profile
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // set the required fields
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(125);
    input.setSzUserId(user.getUserLogonID());

    // return the new ArchInputStruct
    return input;
  }
  
  /**
   * setup the ArchInputStruct for the CSUB49SI object.
   *
   * @param user             user profile
   * @param numPersonActions the number of actions executed on the Persons at Home service
   * @return the new ArchInputStruct
   */
  private ArchInputStruct createCSUB49SIArchInputStruct(UserProfile user,
                                                        int numPersonActions) {
    // allocate the new ArchInputStruct
    ArchInputStruct input = new ArchInputStruct();

    // set the fixed values on the ArchInputStruct
    input.setBPerfInd("0");
    input.setBDataAcsInd("0");
    input.setUsPageNbr(0);
    input.setUlPageSizeNbr(numPersonActions);

    // set user logon info
    input.setSzUserId(user.getUserLogonID());

    // return the new ArchInputStruct
    return input;
  }

  /**
   * setup the ROWCSUB49SIG00_ARRAY object for the CSUB49SI input object.
   *
   * @param csub48so the output from the CSUB48S service
   * @param request  the page request
   * @param csub15so the output from the CSUB15S service
   * @return the newly constructed array object
   */
  private ROWCSUB49SIG00_ARRAY createROWCSUB49SIG00_ARRAY(CSUB48SO csub48so,
                                                          HttpServletRequest request,
                                                          CSUB15SO csub15so) {
    // allocate the new array
    ROWCSUB49SIG00_ARRAY rowcsub49SIG00_array = new ROWCSUB49SIG00_ARRAY();

    // get the ROWCSUB48SOG00_ARRAY returned from CSUB48S
    ROWCSUB48SOG00_ARRAY rowcsub48SOG00_array = csub48so.getROWCSUB48SOG00_ARRAY();
    int rowCount = 0;

    // if the ROWCSUB48SOG00_ARRAY is not null...
    if (rowcsub48SOG00_array != null) {
      // for each row in the ROWCSUB48SOG00_ARRAY...
      Enumeration enumeration = rowcsub48SOG00_array.enumerateROWCSUB48SOG00();
      while (enumeration.hasMoreElements()) {
        ROWCSUB48SOG00 row = (ROWCSUB48SOG00) enumeration.nextElement();
        boolean currentlyChecked = IND_YES.equals(
                CheckboxHelper.getCheckboxValue(request, "cbxPersonsAtHome_" + row.getUlIdPerson()));
        if ((currentlyChecked) && (!IND_YES.equals(row.getCScrIndRefChildMatch()))) {
          row.setCScrIndRefChildMatch("N");
        }

        String indicator =
                currentlyChecked && IND_NO.equals(row.getCScrIndRefChildMatch()) ? ACTION_ADD :
                ((!currentlyChecked) && IND_YES.equals(row.getCScrIndRefChildMatch()) ? ACTION_DELETE : null);

        if (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING) && currentlyChecked) {
          indicator = ACTION_ADD;
        }

        // if we have selected the checkbox for that person, create a save action in the ROWCSUB49SOG00_ARRAY
        if (indicator != null) {
          rowCount++;
          ROWCSUB49SIG00 rowcsub49SIG00 = new ROWCSUB49SIG00();
          rowcsub49SIG00_array.addROWCSUB49SIG00(rowcsub49SIG00);

          rowcsub49SIG00.setSzCdScrDataAction(indicator);
          rowcsub49SIG00.setTsLastUpdate(row.getTsLastUpdate());
          rowcsub49SIG00.setUlIdEvent(csub15so.getUlIdEvent());
          rowcsub49SIG00.setUlIdPerson(row.getUlIdPerson());
        }
      }
    }

    // set the size of the array to the row count
    rowcsub49SIG00_array.setUlRowQty(rowCount);

    // return the new array object
    return rowcsub49SIG00_array;
  }

  /**
   * setup the UlPageSizeNbr_ARRAY for CSUB15S service call.
   *
   * @param numRemovalActions   the number of Removal Actions to perform
   * @param numChildCharActions the number of Child Char Actions to perform
   * @return the new UlPageSizeNbr_ARRAY
   */
  private UlPageSizeNbr_ARRAY createUlPageSizeNbrArray(int numRemovalActions,
                                                       int numChildCharActions) {
    // allocate the UlPageSizeNbr_ARRAY
    UlPageSizeNbr_ARRAY ulPageSizeNbr_array = new UlPageSizeNbr_ARRAY();

    // setup the fields
    ulPageSizeNbr_array.addUlPageSizeNbr(numRemovalActions);
    ulPageSizeNbr_array.addUlPageSizeNbr(numChildCharActions);
    ulPageSizeNbr_array.setUlRowQty(2);

    // return the UlPageSizeNbr_ARRAY
    return ulPageSizeNbr_array;
  }

  /**
   * create the ROWCCMN01UIG00 object for the CSUB15S call.
   *
   * @param tsLastUpdate the timestamp
   * @param request      the page request
   * @param removalDate  the date of the removal
   * @param ulIdEvent    the event ID of this person's removal, or 0 if this is a new removal
   * @return the new ROWCCMN01UIG00 object
   */
  private ROWCCMN01UIG00 createROWCCMN01UIG00(Date tsLastUpdate,
                                              HttpServletRequest request,
                                              org.exolab.castor.types.Date removalDate,
                                              int ulIdEvent) {
    ROWCCMN01UIG00 rowccmn01UIG00 = new ROWCCMN01UIG00();

    UserProfile user = UserProfileHelper.getUserProfile(request);

    rowccmn01UIG00.setTsLastUpdate(tsLastUpdate);
    rowccmn01UIG00.setSzCdTask(GlobalData.getSzCdTask(request));
    //
    // SIR 17233 - event status should remain PEND, if we're in Approver Mode
    //
    if (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
      rowccmn01UIG00.setSzCdEventStatus(EVENT_STATUS_PENDING);
    } // end if
    else {
      rowccmn01UIG00.setSzCdEventStatus(EVENT_STATUS_COMPLETE);
    } // end else

    rowccmn01UIG00.setSzCdEventType(REMOVAL_EVENT_TYPE);
    /* SIR # 22580. commented out the next line and added the if statement.
    ** ulIdEvent = 0 means it's a new record */
    //rowccmn01UIG00.setDtDtEventOccurred( removalDate );
    if (ulIdEvent == 0) {
      rowccmn01UIG00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    }
    rowccmn01UIG00.setUlIdEvent(ulIdEvent);
    rowccmn01UIG00.setUlIdStage(GlobalData.getUlIdStage(request));
    rowccmn01UIG00.setUlIdPerson(user.getUserID());
    rowccmn01UIG00.setSzTxtEventDescr(" Removal From Home  " + FormattingHelper.formatDate(removalDate));

    ROWCCMN01UIG01_ARRAY rowccmn01UIG01_array = new ROWCCMN01UIG01_ARRAY();
    rowccmn01UIG00.setROWCCMN01UIG01_ARRAY(rowccmn01UIG01_array);
    rowccmn01UIG01_array.setUlRowQty(0);
    return rowccmn01UIG00;
  }

  /**
   * create the ROWCSUB15SIG00 object for the CSUB15S call.
   *
   * @param context      the GRNDS exchange context
   * @param tsLastUpdate the timestamp
   * @param dtDtRemoval  the date of the removal
   * @param info         the PullBack info from the PersonList
   * @param ulIdEvent    the event ID of this person's removal, or 0 if this is a new removal
   * @param childNA      true if the child NA button is clicked, false otherwise
   * @param careTakerNA  true if the careTaker NA button is clicked, false otherwise
   * @param csub14so     get the victim's id
   * @return the new ROWCSUB15SIG00 object
   */
  private ROWCSUB15SIG00 createROWCSUB15SIG00(GrndsExchangeContext context,
                                              Date tsLastUpdate,
                                              org.exolab.castor.types.Date dtDtRemoval,
                                              PersonListPullBackInfo info,
                                              int ulIdEvent,
                                              boolean childNA,
                                              boolean careTakerNA,
                                              CSUB14SO csub14so) {
    ROWCSUB15SIG00 rowcsub15SIG00 = new ROWCSUB15SIG00();

    HttpServletRequest request = context.getRequest();

    String cIndRemovalNACare = careTakerNA ? IND_YES : IND_NO;

    String cIndRemovalNAChild = childNA ? IND_YES : IND_NO;

    int removalAgeYears = Integer.parseInt(ContextHelper.getStringSafe(request, "labelRemovalAgeYears"));
    int removalAgeMonths = Integer.parseInt(ContextHelper.getStringSafe(request, "labelRemovalAgeMonths"));
    String removalType = ContextHelper.getStringSafe(request, "rbRemovalType");
    String parentNotified = ContextHelper.getStringSafe(request, "cbxParentNotified");
    String factualDesc = ContextHelper.getStringSafe(request, "txtFactualDesc");
    rowcsub15SIG00.setTsLastUpdate(tsLastUpdate);
    rowcsub15SIG00.setDtDtRemoval(dtDtRemoval);
    rowcsub15SIG00.setUlIdEvent(ulIdEvent);
    if (info != null) {
      rowcsub15SIG00.setUlIdVictim(info.getPersonListRow().getUlIdPerson());
    } else {
      rowcsub15SIG00.setUlIdVictim(csub14so.getROWCSUB14SOG00().getUlIdVictim());
    }
    rowcsub15SIG00.setCIndRemovalNACare(cIndRemovalNACare);
    rowcsub15SIG00.setCIndRemovalNaChild(cIndRemovalNAChild);
    rowcsub15SIG00.setLNbrRemovalAgeMo(removalAgeMonths);
    rowcsub15SIG00.setLNbrRemovalAgeYr(removalAgeYears);
    rowcsub15SIG00.setRbRemovalType(removalType);
    rowcsub15SIG00.setCbParentNotified(parentNotified);
    rowcsub15SIG00.setTxtFactualDesc(factualDesc);
    //SIR 22988 added case id - it's used later to get the SUB and FSU stages
    //for the date stage start update
    rowcsub15SIG00.setUlIdCase(GlobalData.getUlIdCase(request));
    return rowcsub15SIG00;
  }

  /**
   * create the array to save Removal Reasons.
   *
   * @param request   the page request
   * @param ulIdEvent the event ID of this person's removal, or 0 if this is a new removal
   * @param csub14so  the output from the CSUB14S service
   * @return the new array
   */
  private ROWCSUB15SIG01_ARRAY createRemovalReasonsArray(HttpServletRequest request,
                                                         int ulIdEvent,
                                                         CSUB14SO csub14so) {
    ROWCSUB15SIG01_ARRAY rowcsub15SIG01_array = new ROWCSUB15SIG01_ARRAY();

    Map previousRemovalReasons = indexPreviousRemovalReasons(csub14so);
    int count = 0;
    // MR-074 AFCARS: used getCheckedIndicators for all page mode since a removal reason can now be disabled based on removal type

      Map changes = CheckboxHelper.getCheckedIndicators(request, "cbxRemovalReasonsAdult");
      Map changesChildReason = CheckboxHelper.getCheckedIndicators(request, "cbxRemovalReasonsChild");
      changes.putAll(changesChildReason);
      Iterator it = changes.entrySet().iterator();

      // SMS#106721 add copied reasons if not deselected
      // If removal event is copied, then add copied reasons.
      if( PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))){
        Iterator itCopied = previousRemovalReasons.entrySet().iterator();
        
        while(itCopied.hasNext()){
          Map.Entry entry = (Map.Entry) itCopied.next();
          String reason = (String) entry.getKey();
          String indicator = ACTION_ADD;
          String changeToPrevRsnAction = (String) changes.get(reason);

          // Check make sure no changes were made to previously copied checkboxes
          if( changeToPrevRsnAction == null){
            ROWCSUB15SIG01 rowcsub15SIG01 = new ROWCSUB15SIG01();
            rowcsub15SIG01.setSzCdRemovalReason(reason);
            rowcsub15SIG01.setUlIdEvent(ulIdEvent);
            rowcsub15SIG01.setSzCdSysDataActionOutcome(indicator);
            rowcsub15SIG01.setUlIdPersHmRemoval(0);
            rowcsub15SIG01_array.addROWCSUB15SIG01(rowcsub15SIG01);
            count++;
          }
        }
      }

      while (it.hasNext()) {
        Map.Entry entry = (Map.Entry) it.next();
        String reason = (String) entry.getKey();
        String indicator = (String) entry.getValue();
        ROWCSUB14SOG01 rowcsub14SOG01 = (ROWCSUB14SOG01) previousRemovalReasons.get(reason);

        ROWCSUB15SIG01 rowcsub15SIG01 = new ROWCSUB15SIG01();
        rowcsub15SIG01.setSzCdRemovalReason(reason);
        rowcsub15SIG01.setUlIdEvent(ulIdEvent);
        rowcsub15SIG01.setSzCdSysDataActionOutcome(indicator);
        rowcsub15SIG01.setUlIdPersHmRemoval(0);
        if (rowcsub14SOG01 != null) {
          rowcsub15SIG01.setTsLastUpdate(rowcsub14SOG01.getTsLastUpdate());
        }
        rowcsub15SIG01_array.addROWCSUB15SIG01(rowcsub15SIG01);
        count++;
      }
    
    rowcsub15SIG01_array.setUlRowQty(count);

    return rowcsub15SIG01_array;
  }

  /**
   * create the array to save Child Chars.
   *
   * @param request   the page request
   * @param ulIdEvent the event ID of this person's removal, or 0 if this is a new removal
   * @param csub14so  the output from the CSUB14S service
   * @param childNA   true if the child NA button checked, false otherwise
   * @return the new array
   */
  private ROWCSUB15SIG02_ARRAY createChildCharsArray(HttpServletRequest request,
                                                     int ulIdEvent,
                                                     CSUB14SO csub14so,
                                                     boolean childNA) {
    // allocate the new array
    ROWCSUB15SIG02_ARRAY rowcsub15SIG02_array = new ROWCSUB15SIG02_ARRAY();

    Map previousChildChars = indexPreviousChildChars(csub14so);

    Map changes = null;

    boolean modifyMode = PageModeConstants.MODIFY.equals(PageMode.getPageMode(request));

    if (modifyMode) {
      changes = CheckboxHelper.getCheckedIndicators(request, "cbxChildChars");

      if (childNA) {
        Iterator it = previousChildChars.keySet().iterator();
        while (it.hasNext()) {
          String ch = (String) it.next();
          changes.put(ch, ACTION_DELETE);
        }
      }
    } else {
      changes = new HashMap();
      String[] checked = CheckboxHelper.getCheckedValues(request, "cbxChildChars");

      for (int i = 0; i < checked.length; i++) {
        String ch = checked[i];
        if (!IND_NA.equals(ch)) {
          changes.put(ch, ACTION_ADD);
        }
      }
    }

    Iterator it = changes.entrySet().iterator();
    int count = 0;
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry) it.next();
      String ch = (String) entry.getKey();
      // STGAP00004320
/*      if (ch.length() == 1) {
        ch = "0".concat(ch);
      }*/
      ROWCSUB14SOG02 rowcsub14SOG02 = (ROWCSUB14SOG02) previousChildChars.get(ch);

      if (!IND_NA.equals(ch)) {
        String indicator = (String) entry.getValue();

        ROWCSUB15SIG02 rowcsub15SIG02 = new ROWCSUB15SIG02();
        rowcsub15SIG02.setSzCdRemovChildChar(ch);
        rowcsub15SIG02.setUlIdEvent(ulIdEvent);
        // rowcsub15SIG02.setTsLastUpdate(tsLastUpdate);
        rowcsub15SIG02.setSzCdSysDataActionOutcome(modifyMode ? ACTION_UPDATE : indicator);
        if (rowcsub14SOG02 != null) {
          rowcsub15SIG02.setTsLastUpdate(rowcsub14SOG02.getTsLastUpdate());
        }
        rowcsub15SIG02.setCIndCharChildCurrent(ACTION_ADD.equals(indicator) ? IND_YES : IND_NO);
        rowcsub15SIG02_array.addROWCSUB15SIG02(rowcsub15SIG02);
        count++;
      }
    }
    rowcsub15SIG02_array.setUlRowQty(count);

    // return the new array
    return rowcsub15SIG02_array;
  }

  /**
   * create the array to save Care Taker Chars.
   *
   * @param request     the page request
   * @param ulIdEvent   the event ID of this person's removal, or 0 if this is a new removal
   * @param csub14so    the output from the CSUB14S service
   * @param careTakerNA true if the careTaker NA button checked, false otherwise
   * @return the new array
   */
  private ROWCSUB15SIG03_ARRAY createCareTakerCharsArray(HttpServletRequest request,
                                                         int ulIdEvent,
                                                         CSUB14SO csub14so,
                                                         boolean careTakerNA) {
    ROWCSUB15SIG03_ARRAY rowcsub15SIG03_array = new ROWCSUB15SIG03_ARRAY();

    Map previousCareTakerChars = indexPreviousCareTakerChars(csub14so);

    Map changes = CheckboxHelper.getCheckedIndicators(request, "cbxCareTakerChars");

    if (careTakerNA) {
      Iterator it = previousCareTakerChars.keySet().iterator();
      while (it.hasNext()) {
        String ch = (String) it.next();
        changes.put(ch, ACTION_DELETE);
      }
    }

    //Iterator it = changes.entrySet().iterator();
    int count = 0;
    if (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
      //Map changes = new HashMap();
      String[] checked = CheckboxHelper.getCheckedValues(request, "cbxCareTakerChars");

      for (int i = 0; i < checked.length; i++) {
        String removal_reason = checked[i];

        ROWCSUB15SIG03 rowcsub15SIG03 = new ROWCSUB15SIG03();
        rowcsub15SIG03.setSzCdRemovAdultChar(removal_reason);
        rowcsub15SIG03.setUlIdEvent(ulIdEvent);
        rowcsub15SIG03.setSzCdSysDataActionOutcome(ACTION_ADD);

        rowcsub15SIG03_array.addROWCSUB15SIG03(rowcsub15SIG03);
      }
      count = checked.length;
    } else {
      Iterator it = changes.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry entry = (Map.Entry) it.next();
        String ch = (String) entry.getKey();

        ROWCSUB14SOG03 rowcsub14SOG03 = (ROWCSUB14SOG03) previousCareTakerChars.get(ch);

        if (!IND_NA.equals(ch)) {
          String indicator = (String) entry.getValue();

          ROWCSUB15SIG03 rowcsub15SIG03 = new ROWCSUB15SIG03();
          rowcsub15SIG03.setSzCdRemovAdultChar(ch);
          rowcsub15SIG03.setUlIdEvent(ulIdEvent);
          rowcsub15SIG03.setSzCdSysDataActionOutcome(
                  rowcsub14SOG03 == null ? indicator : (ACTION_ADD.equals(indicator) ? ACTION_UPDATE : ACTION_DELETE));
          if (rowcsub14SOG03 != null) {
            rowcsub15SIG03.setTsLastUpdate(rowcsub14SOG03.getTsLastUpdate());
          }
          rowcsub15SIG03.setSzCdSysDataActionOutcome(indicator);
          rowcsub15SIG03_array.addROWCSUB15SIG03(rowcsub15SIG03);
          count++;
        }
      }
    }
    rowcsub15SIG03_array.setUlRowQty(count);

    return rowcsub15SIG03_array;
  }

  /**
   * construct a map from the Char Taker Char code to the row of data.
   *
   * @param csub14so the output from the CSUB14S service
   * @return the index map from code to row
   */
  private Map indexPreviousCareTakerChars(CSUB14SO csub14so) {
    // allocate the new Map
    Map previousCareTakerChars = new HashMap();

    // get the row array from the CSUB14S object
    ROWCSUB14SOG03_ARRAY rowcsub14SOG03_array = csub14so.getROWCSUB14SOG03_ARRAY();

    // if the row isn't null...
    if (rowcsub14SOG03_array != null) {
      // for each row in the array...
      Enumeration enumeration = rowcsub14SOG03_array.enumerateROWCSUB14SOG03();
      while (enumeration.hasMoreElements()) {
        ROWCSUB14SOG03 rowcsub14SOG03 = (ROWCSUB14SOG03) enumeration.nextElement();

        // add a mapping from the code to the row itself to the map
        previousCareTakerChars.put(rowcsub14SOG03.getSzCdRemovAdultChar(), rowcsub14SOG03);
      }
    }

    // return the index map
    return previousCareTakerChars;
  }

  /**
   * construct a map from the Child Char code to the row of data.
   *
   * @param csub14so the output from the CSUB14S service
   * @return the index map from code to row
   */
  private Map indexPreviousChildChars(CSUB14SO csub14so) {
    // allocate the new Map
    Map previousChildChars = new HashMap();

    // get the row array from the CSUB14S object
    ROWCSUB14SOG02_ARRAY rowcsub14SOG02_array = csub14so.getROWCSUB14SOG02_ARRAY();

    // if the row isn't null...
    if (rowcsub14SOG02_array != null) {
      // for each row in the array...
      Enumeration enumeration = rowcsub14SOG02_array.enumerateROWCSUB14SOG02();
      while (enumeration.hasMoreElements()) {
        ROWCSUB14SOG02 rowcsub14SOG02 = (ROWCSUB14SOG02) enumeration.nextElement();

        // add a mapping from the code to the row itself to the map
        previousChildChars.put(rowcsub14SOG02.getSzCdRemovChildChar(), rowcsub14SOG02);
      }
    }

    // return the index map
    return previousChildChars;
  }

  /**
   * construct a map from the Removal Reason code to the row of data.
   *
   * @param csub14so the output from the CSUB14S service
   * @return the index map from code to row
   */
  private Map indexPreviousRemovalReasons(CSUB14SO csub14so) {
    // allocate the new Map
    Map previousRemovalReasons = new HashMap();

    // get the row array from the CSUB14S object
    ROWCSUB14SOG01_ARRAY rowcsub14SOG01_array = csub14so.getROWCSUB14SOG01_ARRAY();

    // if the row isn't null...
    if (rowcsub14SOG01_array != null) {
      // for each row in the array...
      Enumeration enumeration = rowcsub14SOG01_array.enumerateROWCSUB14SOG01();
      while (enumeration.hasMoreElements()) {
        ROWCSUB14SOG01 rowcsub14SOG01 = (ROWCSUB14SOG01) enumeration.nextElement();

        // add a mapping from the code to the row itself to the map
        previousRemovalReasons.put(rowcsub14SOG01.getSzCdRemovalReason(), rowcsub14SOG01);
      }
    }

    // return the index map
    return previousRemovalReasons;
  }

  /**
   * sir#22912. added the getRace method
   *
   * @param context the GRNDS exchange context
   * @param info    the PullBack info from the PersonList
   * @return CCMN95SO object
   */
  private CCMN95SO getRace(GrndsExchangeContext context,
                           PersonListPullBackInfo info) {

    CCMN95SI ccmn95si = new CCMN95SI();
    CCMN95SO ccmn95so = new CCMN95SO();

    // call the CCMN95S service to retrieve the race information
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(10);
    input.setSzUserId(user.getUserLogonID());
    ccmn95si.setArchInputStruct(input);

    if (info != null) {
      ccmn95si.setUlIdPerson(info.getPersonListRow().getUlIdPerson());
    } else {
      ccmn95si.setUlIdPerson(0);
    }

    try {
      //ccmn95so = CCMN95SO.unmarshal(new StringReader(WtcHelper.callService("CCMN95S", ccmn95si)));
      ccmn95so = intake.findPersonRaceAndPersonEthnicity(ccmn95si);
    }
    catch (ServiceException we) {
      switch (we.getErrorCode()) {
        case Messages.SSM_NO_ROWS_RETURNED:
          break;

        default:
          GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
          processSevereException(context, we);
          break;
      }
    }
    return ccmn95so;
  }

  public boolean checkIfRemovalPriorToAllegIncident (int idChild, Date dtRemoval) {
    boolean removalPriorToAllegIncident = false;
    CheckIfRemovalPriorToAllegIncidentSI checkIfRemovalPriorToAllegIncidentSI = new CheckIfRemovalPriorToAllegIncidentSI();
    checkIfRemovalPriorToAllegIncidentSI.setIdVictim(idChild);
    checkIfRemovalPriorToAllegIncidentSI.setDtRemoval(dtRemoval);
    removalPriorToAllegIncident = common.checkIfRemovalPriorToAllegIncident(checkIfRemovalPriorToAllegIncidentSI);
    return removalPriorToAllegIncident;
  }
  
  // STGAP00017013: MR-095
  /**
   * Setup the ROWCSUB80SIG00_ARRAY object for the CSUB80SI input object
   * 
   * @param request: the page request
   * @param csub80so: the output from the CSUB80SI service
   * @return the newly constructed array object
   */
  private ROWCSUB80SIG00_ARRAY createROWCSUB80SIG00_ARRAY(HttpServletRequest request, CSUB80SO csub80so) {
    // Allocate the new array
    ROWCSUB80SIG00_ARRAY rowcsub80sig00_array = new ROWCSUB80SIG00_ARRAY();

    // Get the ROWCSUB80SIG00_ARRAY returned from CINV80SO
    ROWCSUB80SOG00_ARRAY rowcsub80sog00_array = csub80so.getROWCSUB80SOG00_ARRAY();
    int rowCount = 0;
    int i = 0;

    if (rowcsub80sog00_array != null) {
      Enumeration rowcsub80sog00Enumeration = rowcsub80sog00_array.enumerateROWCSUB80SOG00();
      while (rowcsub80sog00Enumeration.hasMoreElements()) {
        ROWCSUB80SOG00 rowcsub80sog00;
        rowcsub80sog00 = (ROWCSUB80SOG00) rowcsub80sog00Enumeration.nextElement();

        String selSzCdStagePersRelInt = ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt_" + (i + 1));

        Boolean indicator = (selSzCdStagePersRelInt != null && !"".equals(selSzCdStagePersRelInt)) ? true : false;

        // if non-null value is entered for the Relationship dropdown, create a save action in the ROWCSUB80SOG00_ARRAY
        if (indicator) {
          rowCount++;
          ROWCSUB80SIG00 rowcsub80sig00 = new ROWCSUB80SIG00();
          rowcsub80sig00.setUlIdPersonPrincipal(rowcsub80sog00.getUlIdPersonPrincipal());
          rowcsub80sig00.setSzNmPersonFull(rowcsub80sog00.getSzNmPersonFull());
          rowcsub80sig00.setSzCdStagePersRelInt(selSzCdStagePersRelInt);
          rowcsub80sig00_array.addROWCSUB80SIG00(rowcsub80sig00);
        }
        i++;
      }
    }

    // set the size of the array to the row count
    rowcsub80sig00_array.setUlRowQty(rowCount);

    // return the new array object
    return rowcsub80sig00_array;
  }

  // End STGAP00017013: MR-095
  
  // action codes
  public static final String ACTION_ADD = "A";
  public static final String ACTION_DELETE = "D";
  public static final String ACTION_UPDATE = "U";

  // keys for objects to put into state
  public static final String CHECKED_CARE_TAKER_CHARS = "checkedCareTakerChars";
  public static final String CHECKED_CHILD_CHARS = "checkedChildChars";
  public static final String CHECKED_REMOVAL_REASONS = "checkedRemovalReasons";
  //public static final String CHECKED_REMOVAL_REASONS_CHILD = "checkedRemovalReasonsChild"; // MR-074
  public static final String PAGE_MODE = "pageMode";
  public static final String REMOVAL_EVENT = "removalEvent";

  // yes, no, and N/A indicator codes
  public static final String IND_NA = "NA";
  public static final String IND_NO = "N";
  public static final String IND_YES = "Y";

  // the removal event type code for service calls and CaseHelper calls
  public static final String REMOVAL_EVENT_TYPE = "REM";

  //
  // SIR 17233 - added constants
  //
  public static final String EVENT_STATUS_COMPLETE = "COMP";
  public static final String EVENT_STATUS_PENDING = "PEND";

}