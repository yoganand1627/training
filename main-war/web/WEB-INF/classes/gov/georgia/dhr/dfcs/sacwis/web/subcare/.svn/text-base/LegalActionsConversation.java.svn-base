package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.courtprocess.CourtProcess;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee;
import gov.georgia.dhr.dfcs.sacwis.structs.input.Attendee_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CourtLanguage_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome;
import gov.georgia.dhr.dfcs.sacwis.structs.input.Outcome_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB39SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOutcome_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used for Legal Actions
 *
 * @author Carolyn Douglass, Feb. 24, 2002 <p/>
 *         <p/>
 *         <pre>
 *                     &lt;p/&gt;
 *                      Change History:
 *                       Date        User      Description
 *                       ----------  --------  --------------------------------------------------
 *                       06/06/03  GRIMSHAN    SIR 16979 - Retrieve page mode from event search conversation
 *                                             if the page mode does not need to be changed, it will not
 *                       06/17/04  C.Douglass  SIR 22873 - Date Filed and Outcome will no longer be
 *                                             entered for CPS Legal Actions.
 *                       08/26/04  C.Douglass  SIR 23109 - When entering Legal Action in CPS-INV,
 *                                             FSU, FRE, FPR, page reloads to handle end dated codes
 *                                             tables and person list redisplays in error, which
 *                                             keeps Legal Action from ever being entered for these stages.
 *                                             Defect from SIR 22873.
 *                       03/02/05  C.Douglass  SIR 22626 - When worker is in a SUB or ADO stage, but
 *                                             uses New Using from the Legal Actions for Case tab,
 *                                             the primary child(PC) for the selected event is used for
 *                                             the Legal Action.  It should pick the PC for the stage
 *                                             that the user is in.
 *                       09/17/2008  arege     STGAP00009550 Modified callInvalidateApprovalIfUserIsNotApprover() so that
 *                                             the invalidateApproval is called even for a scenario where a Supervisor is invalidating 
 *                                             a pending approval for an event submitted by himself.  
 *                       09/19/2008  arege     STGAP00009550 Modified an if condition so that the 
 *                                             Error message MSG_CMN_INVLD_APRVL_POPUP is displayed
 *                                             when not in approval mode and the event status is in PEND
 *                       09/25/2008  ssubram   STGAP00010231 - Adoption Enhancement: Create an Auto ADO stage 
 *                       02/08/2010  mxpatel   CAPTA: Added validations for CAPTA changes
 *                       09/07/2010  wjcochran SMS #47858 - For Legal Actions being submitted for approval, we do not want to
 *                                             set these events to COMP. The Legal Action should remain editable until Approval.
 *         </pre>
 */

@SuppressWarnings("serial")
public class LegalActionsConversation extends BaseHiddenFieldStateConversation {
  /**
   * ***************************************************************************** * Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "LegalActionsConversation";

  public static final String WINDOW_MODE_NEW = PageModeConstants.NEW;

  public static final String WINDOW_MODE_NEW_USING = PageModeConstants.NEW_USING;

  public static final String WINDOW_MODE_INQUIRE = PageModeConstants.INQUIRE;

  public static final String WINDOW_MODE_MODIFY = PageModeConstants.MODIFY;

  public static final String ADD = ServiceConstants.REQ_FUNC_CD_ADD;
  
  public static final String DOCEXISTS = "docExists";

  public static final String UPDATE = ServiceConstants.REQ_FUNC_CD_UPDATE;

  public static final String DELETE = ServiceConstants.REQ_FUNC_CD_DELETE;

  public static final String DISPLAY_PAGE = "/subcare/LegalActions/displayLegalActions";

  public static final String SUB_LEGAL_ACT_EVENT_TYPE = CodesTables.CEVNTTYP_LEG;

  public static final String INDICATOR_YES = ArchitectureConstants.Y;

  public static final String INDICATOR_NO = ArchitectureConstants.N;

  public static final String TODO_23_SUBTYPE = "020";

  public static final String TODO_25_1_SUBTYPE = "050";

  public static final String TODO_25_2_SUBTYPE = "060";

  public static final String TODO_12_SUBTYPE = "060";

  public static final String TODO_13_SUBTYPE = "070";

  public static final String APS_GUARDIANSHIP = "CAGU";

  public static final String AOC_GUARDIANSHIP = "030";

  public static final String TODO_HEARING = "CCHE";

  public static final String TODO_GUARDIAN = "CAGA";

  public static final String STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  public static final String STATUS_IN_PROC = CodesTables.CEVTSTAT_PROC;

  public static final String STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  public static final String STATUS_PENDING = CodesTables.CEVTSTAT_PEND;

  public static final String STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  public static final String CPS_SUB_CCHE_TABLE = "CCHE";

  public static final String CPS_PROGRAM = "CPS";

  public static final String APS_PROGRAM = "APS";

  private static final int METHOD_SAVE_REFRESH = 0;
  private static final int METHOD_SAVE_REDIRECT = 1;
  private static final int METHOD_SAVE_AND_SUBMIT = 2;
  private static final int METHOD_DELETE = 3;
  @SuppressWarnings("serial")
  private static final Map<String, String> APPROVAL_TASK_MAP = new HashMap<String, String>() {
    {
      //INV
      put("2355", "2366");
      put("2365", "2366");

      //SUB
      put("3030", "3041");
      put("3040", "3041");

      //FSU
      put("4350", "4361");
      put("4360", "4361");

      //FRE
      put("5850", "5861");
      put("5860", "5861");

      //FPR
      put("7210", "7221");
      put("7220", "7221");

      //ADO
      put("8540", "8551");
      put("8550", "8551");
      
      //PFC
      put("2020","2035");
      put("2030","2035");
      
      //PAD
      put("9070","9071");
      put("9075","9071");
    }
  };
  private Common common;
  private CourtProcess courtprocess;
  private Admin admin;
  
  public void setCommon(Common common){
    this.common = common;
  }
  
  public void setCourtProcess(CourtProcess cp) {
    this.courtprocess = cp;
  }
  
  public void setAdmin(Admin admin){
    this.admin = admin;
  }

  /**
   * This method will retrieve data from CSUB38S to use to display the page.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void displayLegalActions_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayLegalActions_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      String pageMode;
      int ulIdPerson = 0;
      String nmPersonFull = "";
      if ("true".equals(state.getAttribute("legalActionSaveRefresh", request))) {
        pageMode = PageMode.getPageMode(request);
        ulIdPerson = Integer.parseInt((String) state.getAttribute("ulIdPerson", request));
        nmPersonFull = (String) state.getAttribute("nmPersonFull", request);
      } else {
        //event list sets page mode
        pageMode = EventSearchConversation.getEventDetailPageMode(request);
      }

      // clear state
      if (state.getAttribute("CSUB38SO", request) == null) {
        state.removeAllAttributes(request);
      }

      // if coming back from person list, need to reset pagemode from P to pageMode from
      // event list
      if ("P".equals(pageMode)) {
        pageMode = (String) state.getAttribute("previouspagemode", request);
      }

      // reset pagemode into state
      PageMode.setPageMode(pageMode, request);

      //int ulIdPerson = 0;
      //String nmPersonFull = "";
      //CSUB38SO csub38so = new CSUB38SO();
      CSUB38SI csub38si = populateCSUB38SI_Retrieve(context);
      CSUB38SO csub38so = courtprocess.retrieveLegalAction(csub38si);
      state.setAttribute("CSUB38SO", csub38so, request);
      
      if (csub38so.getTsLastUpdate() != null) {
          request.setAttribute(DOCEXISTS, ArchitectureConstants.TRUE);
        } else {
          request.setAttribute(DOCEXISTS, ArchitectureConstants.FALSE);
        }
            
      if (GlobalData.getUlIdEvent(request) != 0) {
        // if a Legal Action ToDo has been created, need to reset mode to New
        String eventStatus = csub38so.getROWCSUB38SOG00().getSzCdEventStatus();
        int callRetrieveApprovers = 0;
        if (STATUS_NEW.equals(eventStatus)) {
          if (PageMode.getPageMode(request).equals(WINDOW_MODE_MODIFY)) {
            PageMode.setPageMode(WINDOW_MODE_NEW, request);
          }
        } else if (STATUS_PENDING.equals(eventStatus) &&
                  !pageMode.equals(WINDOW_MODE_NEW) && !pageMode.equals(WINDOW_MODE_NEW_USING)) {
          //-- if legal action has been submitted for approval (PEND), check to see if user is approver
          //-- if not approver, set pop-up box message
          callRetrieveApprovers = 1;
        } else if(STATUS_COMPLETE.equals(eventStatus) &&
                 !pageMode.equals(WINDOW_MODE_NEW) && !pageMode.equals(WINDOW_MODE_NEW_USING)){
          callRetrieveApprovers = 2;
        }
        
        ApproversRetrieveSO so = null;
        if(callRetrieveApprovers > 0){
          int eventId = csub38so.getROWCSUB38SOG00().getUlIdEvent();
          ApproversRetrieveSI si = new ApproversRetrieveSI(ApproversRetrieveSI.SUBMITTED_EVENT, eventId);
          so = common.retrieveApprovers(si);
        }
        
        switch(callRetrieveApprovers){
        case 1: //-- existing PEND event
          if(so.hasCurrentActiveApprover()){
            int userId = UserProfileHelper.getGlobalDataUserId(request);
            if(userId != so.getCurrentActiveApprover().getIdPerson() || !GlobalData.isApprovalMode(request)){
              //-- user is not approver 
              // arege Or if  the page is not accessed in approval mode.
              setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
            }
          }
          break;
        case 2: //-- existing COMP event
          if(so.hasHistoricalApprovers()){
            if("REJT".equals(so.getHistoricalApprovers().get(0).getCdStatus())){
              request.setAttribute("approvalRejected", "true");
            }
          }
          break;
        }
      }
      if ((("INV".equals(GlobalData.getSzCdStage(request)) && "CPS".equals(GlobalData.getSzCdStageProgram(request)))
           || "FSU".equals(GlobalData.getSzCdStage(request)) || "FRE".equals(GlobalData.getSzCdStage(request)) || "FPR"
              .equals(GlobalData
                      .getSzCdStage(request)))
          && (PageMode.getPageMode(request).equals(PageModeConstants.NEW) || PageMode
              .getPageMode(request)
              .equals(
                      PageModeConstants.NEW_USING))) {
        // SIR 23109 - since page reloads after legal action is selected, added
        // check to see if a person has already been selected
        if (request.getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME) == null
            && ulIdPerson == 0) {
          state.setAttribute("previouspagemode", PageMode.getPageMode(request), request);
          PersonListPullBackInfo personListPullBackInfo = new PersonListPullBackInfo();
          personListPullBackInfo.setDestinationUrl("/subcare/LegalActions/displayLegalActions");
          PageMode.setPageMode(PersonListConversation.PAGE_MODE_PRINC_ONLY, request);
          request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, personListPullBackInfo);
          request.setAttribute("grnds.request.qname", null);
          forward(PersonListConversation.DISPLAY_PAGE, request, context.getResponse());
        } else {
          // SIR 23109 - since page reloads after legal action is selected, added
          // check to see if a person has already been selected
          if (ulIdPerson == 0) {
            PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) request
                    .getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);
            ROWCINV01SOG00 rowcinv01sog00 = personListPullBackInfo.getPersonListRow();
            if (rowcinv01sog00 != null) {
              ulIdPerson = rowcinv01sog00.getUlIdPerson();
              nmPersonFull = rowcinv01sog00.getSzNmPersonFull();
            }
            state.setAttribute("ulIdPerson", String.valueOf(ulIdPerson), request);
            state.setAttribute("nmPersonFull", nmPersonFull, request);
          }
        }
      } else {
        state.setAttribute("ulIdPerson", String.valueOf(csub38so.getROWCSUB38SOG01().getUlIdPerson()), request);
        state.setAttribute("nmPersonFull", csub38so.getSzNmPersonFull(), request);
      }
    } catch (Exception e) {
      handleError(e, context, ArchitectureConstants.ERROR_BRANCH_NAME);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method will delete a Legal Action record.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void deleteLegalActions_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteLegalActions_xa()");
    performanceTrace.enterScope();
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      CSUB39SI csub39si = populateCSUB39SI_AUD(context, DELETE, METHOD_DELETE);
      courtprocess.saveLegalAction(csub39si);
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      state.removeAttribute("CSUB38SO", request);
      state.removeAttribute("previouspagemode", request);
      state.removeAttribute("ulIdPerson", request);
      state.removeAttribute("nmPersonFull", request);
    } catch (Exception e) {
      handleError(e, context, ArchitectureConstants.ERROR_BRANCH_NAME);
      try {
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (Exception me) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + me.getMessage());
        processSevereException(context, me);
      }
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  public void saveLegalActions_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveLegalActions_xa()");
    performanceTrace.enterScope();

    int method;
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    if ("on".equals(ContextHelper.getStringSafe(context, "cbxComplete"))) {
      this.setPresentationBranch("redirect", context);
      method = METHOD_SAVE_REDIRECT;
    } else {
      this.setPresentationBranch("refresh", context);
      method = METHOD_SAVE_REFRESH;
    }
    
    CSUB39SO csub39so = new CSUB39SO();
    try {
      CSUB39SI csub39si = populateCSUB39SI_AUD(context, UPDATE, method);
      csub39si.setBIndSavePressed(true);
      csub39so = courtprocess.saveLegalAction(csub39si);
      
      /*
       * STGAP00010231 - Adoption Enhancement: Create an ADO stage for certain legal actions for a child that has an
       * FCC Stage. If the legal action is either a voluntary surrender or parental rights (VS) or a 
       * termination of parental rights (TPR) then an ADO stage will be automatically created.
       * If the ADO stage has already been manually opened, then an ADO stage should not be automatically
       * created.
       * This ADO Stage creation process should be triggered on the following two occasions:
       * 1. If the Complete Check box is checked and click save button.
       * 2. If submitted for Approval, then it should be triggered in the Approval Process. Please
       *    see the code in SaveApprovalImpl.java for this second scenario. Note: search using the 
       *    defect # STGAP00010231 in that code
       */
      ROWCSUB39SIG00 csub39sig00 = csub39si.getROWCSUB39SIG00();
      ROWCCMN01UIG00 ccmn01uig00 = csub39si.getROWCCMN01UIG00();
      //The following checking ensures that it passed the validation of checking the Complete check box.
      if ( STATUS_COMPLETE.equals(ccmn01uig00.getSzCdEventStatus()) 
                      && INDICATOR_YES.equals(csub39sig00.getIndComplete())){
        if (CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request))||
                        CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) ||
                        CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request))){
          //This entire save process is triggered from SaveApprovalImpl.java as well during the
          //Legal Action approval process.
          //Call the Auto ADO Stage save process for either FCC/ADO/PAD stage
          //Based on either the FCC stage (i.e. SUB)/ADO/PAD stage, the logic is handled in the service
          CCMN35SI ccmn35si = populateCCMN35SI_AutoAdoStageProgress(context, csub39sig00.getUlIdPerson()
                                                                    ,csub39so.getUlIdLegalActEvent());
          //1. The date of the Legal action also becomes the Date Notified for the Exchange 
          //        child Detail Page.
          //2. Create the Exchange Child Detail event.
          //3. The system should check to see if all people marked as 'Adoptive Parents' have had
          //   legal actions on them with either VS or TPR. If they have, then the system should
          //   update the new child's person characteristics page to indicate there has been an
          //   adoption dissolution and the date of the dissolution.
          //TODO 4. Add alerts for SAU and allow access to the Exchange Child page
          admin.saveAutoAdoStage(ccmn35si);
        }
      }
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    } catch (Exception e) {
      handleError(e, context, ArchitectureConstants.ERROR_BRANCH_NAME);
      try {
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (Exception me) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + me.getMessage());
        processSevereException(context, me);
      }
    }
    
    //-- In this case, we're using the "error" presentation branch for successful saves
    //-- that should refresh the page.
    if ("refresh".equals(this.getPresentationBranch(context))) {
      setInformationalMessage(Messages.MSG_DATABASE_SAVE_SUCCESS, request);
      PageMode.setPageMode(WINDOW_MODE_MODIFY, request);
      state.setAttribute("legalActionSaveRefresh", "true", request);
      int idEvent = csub39so.getUlIdLegalActEvent();
      if(idEvent != 0){
        GlobalData.setUlIdEvent(idEvent, request);
      }

      state.removeAttribute("CSUB38SO", request);
      state.removeAttribute("previouspagemode", request);

      //displayLegalActions_xa(context);
    } else if(!"error".equals(this.getPresentationBranch(context))) {
      state.removeAttribute("CSUB38SO", request);
      state.removeAttribute("previouspagemode", request);
      state.removeAttribute("ulIdPerson", request);
      state.removeAttribute("nmPersonFull", request);
      state.removeAttribute("legalActionSaveRefresh", request);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  public void saveAndSubmitLegalActions_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAndSubmitLegalActions_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      CSUB39SI csub39si = populateCSUB39SI_AUD(context, UPDATE, METHOD_SAVE_AND_SUBMIT);
      //CSUB39SO csub39so = courtprocess.saveLegalAction(csub39si);
      courtprocess.saveLegalAction(csub39si);
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      state.removeAttribute("CSUB38SO", request);
      state.removeAttribute("previouspagemode", request);
      state.removeAttribute("ulIdPerson", request);
      state.removeAttribute("nmPersonFull", request);
      state.removeAttribute("legalActionSaveRefresh", request);

      //-- Create ToDoDetailDB and set into state
      int ulIdEvent = csub39si.getROWCCMN01UIG00().getUlIdEvent();
      //int ulIdEvent = csub39so.getUlIdLegalActEvent();
      int ulIdCase = GlobalData.getUlIdCase(request);
      int ulIdStage = csub39si.getROWCCMN01UIG00().getUlIdStage();
      String szCdTask = APPROVAL_TASK_MAP.get(csub39si.getROWCCMN01UIG00().getSzCdTask());
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ulIdEvent, ulIdCase, ulIdStage, szCdTask);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    } catch (Exception e) {
      handleError(e, context, ArchitectureConstants.ERROR_BRANCH_NAME);
      try {
        request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
      } catch (Exception me) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + me.getMessage());
        processSevereException(context, me);
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method will populate the input before the call to CSUB38S used to display the Legal Action page.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  private CSUB38SI populateCSUB38SI_Retrieve(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB38I_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    // BaseSessionStateManager state = getSessionStateManager( context );

    ArchInputStruct input = new ArchInputStruct();
    CSUB38SI csub38si = new CSUB38SI();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    input.setSzUserId(userProfile.getUserLogonID());

    csub38si.setArchInputStruct(input);
    // SIR 22626 - cSysIndDamCalled needs to be populated with page mode
    // so that service will pick the primary child associated with the stage
    // the user is in, instead of the PC for the selected event.
    csub38si.setCSysIndDamCalled(PageMode.getPageMode(request));
    csub38si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    csub38si.setUlIdStage(GlobalData.getUlIdStage(request));
    csub38si.setSzCdStage(GlobalData.getSzCdStage(request));
    csub38si.setUlIdCase(GlobalData.getUlIdCase(request));

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return csub38si;
  }

  /**
   * This method will populate the input into CSUB39S used to save Legal Actions.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  private CSUB39SI populateCSUB39SI_AUD(GrndsExchangeContext context, String action, int method) throws Exception {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB39SI_AUD()");
    performanceTrace.enterScope();
    // Allocate the structures
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    int loggedInUserId = userProfile.getUserID();
    CSUB38SO csub38so = (CSUB38SO) state.getAttribute("CSUB38SO", request);
    String pageMode = PageMode.getPageMode(request);

    // Allocate the structures
    ROWCSUB39SIG00 rowcsub39sig00 = new ROWCSUB39SIG00();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    CSUB39SI csub39si = new CSUB39SI();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    StringBuffer description = new StringBuffer();
    
    csub39si.setCSysIndDamCalled(pageMode);
    // if New Using, need to set id_event to 0
    if (pageMode.equals(WINDOW_MODE_NEW_USING)) {
      GlobalData.setUlIdEvent(0, request);
    }

    // Set the values for the ArchInputStruct
    // cReqFuncCd = D if Delete was pressed, M if window mode is modify, else is A
    if (action == DELETE) {
      input.setCReqFuncCd(DELETE);
    } else if (pageMode.equals(WINDOW_MODE_MODIFY)) {
      input.setCReqFuncCd(UPDATE);
    } else {
      input.setCReqFuncCd(ADD);
    }
    input.setSzUserId(userProfile.getUserLogonID());
    if (!pageMode.equals(WINDOW_MODE_NEW_USING)) {
      rowcsub39sig00.setUlIdLegalActEvent(csub38so.getROWCSUB38SOG01().getUlIdLegalActEvent());
    }
    rowcsub39sig00.setTsLastUpdate(csub38so.getROWCSUB38SOG01().getTsLastUpdate());
    rowcsub39sig00.setSzCdLegalActAction(ContextHelper.getStringSafe(context, "selLegalAction"));
    //rowcsub39sig00.setSzCdLegalActOutcome(ContextHelper.getStringSafe(context, "selOutcome"));
    rowcsub39sig00.setDtDtLegalActDateFiled(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "txtDtFiled")));
    
    // either from csub38 or from person list pullback
    int ulIdPerson = 0;
    if (Integer.parseInt((String) state.getAttribute("ulIdPerson", request)) == 0) {
      ulIdPerson = csub38so.getROWCSUB38SOG01().getUlIdPerson();
    } else {
      ulIdPerson = Integer.parseInt((String) state.getAttribute("ulIdPerson", request));
    }
    rowcsub39sig00.setUlIdPerson(ulIdPerson);

    rowcsub39sig00.setSzCdCounty(ContextHelper.getStringSafe(context, "selCounty"));
    rowcsub39sig00.setUlNbrCrtFile(ContextHelper.getIntSafe(context, "ulCtFileNum"));
    rowcsub39sig00.setSzCdCrtCaseNbr(ContextHelper.getStringSafe(context, "ulCtCaseNum"));
    rowcsub39sig00.setDtCrtActDate(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "dtCtActDate")));
    rowcsub39sig00.setSzCdCrtType(ContextHelper.getStringSafe(context, "selCtType"));
    rowcsub39sig00.setSzCdHrTypCrtOrd(ContextHelper.getStringSafe(context, "selHTypeCtOrder"));
    rowcsub39sig00.setDtNxtHearDate(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "dtNxtCtHDate")));
    rowcsub39sig00.setDtContinDate(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "dtContDate")));
    rowcsub39sig00.setDtCrtOrdDate(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "dtCtOrderDate")));
    rowcsub39sig00.setDtPubDate(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "dtPubDate")));
    rowcsub39sig00.setSzCdState(ContextHelper.getStringSafe(request, "selState"));
    Date dtShelterCareAuth = ContextHelper.getJavaDateSafe(request, "dtShelterCareAuth");
    String tmShelterCareAuth = ContextHelper.getTimeSafe(request, "tmShelterCareAuth");
    if(!DateHelper.isNull(dtShelterCareAuth) && !"".equals(tmShelterCareAuth)){
      dtShelterCareAuth = DateHelper.toJavaDateSafe(dtShelterCareAuth, tmShelterCareAuth);
      rowcsub39sig00.setTsDtShelterCareAuth(dtShelterCareAuth);
    }
    rowcsub39sig00.setNmCrtOrdPrepBy(ContextHelper.getStringSafe(request, "szCtOrderPrepBy"));
    
    //-- individual checkboxes (other than Complete, which has special conditions)
    if ("on".equals(ContextHelper.getStringSafe(context, "ckInCaseFile"))) {
      rowcsub39sig00.setCIndLegalActDocsNCase(INDICATOR_YES);
    } else {
      rowcsub39sig00.setCIndLegalActDocsNCase(INDICATOR_NO);
    }
    if ("on".equals(ContextHelper.getStringSafe(context, "cbxUpdate"))) {
      rowcsub39sig00.setIndUpPrevAct(INDICATOR_YES);
    } else {
      rowcsub39sig00.setIndUpPrevAct(INDICATOR_NO);
    }
    if ("on".equals(ContextHelper.getStringSafe(context, "cbxCtOrderSigned"))) {
      rowcsub39sig00.setIndCrtOrdSigned(INDICATOR_YES);
    } else {
      rowcsub39sig00.setIndCrtOrdSigned(INDICATOR_NO);
    }
    if ("on".equals(ContextHelper.getStringSafe(context, "cbxBIndNoRepAppointed"))) {
      rowcsub39sig00.setBIndNoRepAppointed(INDICATOR_YES);
    } else {
      rowcsub39sig00.setBIndNoRepAppointed(INDICATOR_NO);
    }
    if ("on".equals(ContextHelper.getStringSafe(context, "cbxAmendment"))) {
      rowcsub39sig00.setIndAmendment(INDICATOR_YES);
    } else {
      rowcsub39sig00.setIndAmendment(INDICATOR_NO);
    }
    
    //-- ATTENDEES/INVOLVED PARTIES LIST *****************************************************************
    //-- attendeePersons represents the ap's displayed on the page.
    //-- selectedAttendees represents the ap's selected from attendeePersons    
    AttendeePerson_Array attendeePersons = csub38so.getAttendeePerson_Array();
    if (attendeePersons != null) {
      int i = 1;
      int count = 0;
      Attendee_Array selectedAttendees = new Attendee_Array();
      for (Enumeration<AttendeePerson> e = attendeePersons.enumerateAttendeePerson(); e.hasMoreElements();) {
        AttendeePerson ap = e.nextElement();
        if ("on".equals(ContextHelper.getStringSafe(context, "cbxAttendee" + i))) {
          Attendee a = new Attendee();
          a.setUlIdPerson(ap.getUlIdPerson());
          a.setSzCdStagePersType(ap.getSzCdStagePersType());
          a.setSzCdStagePersRole(ap.getSzCdStagePersRole());
          a.setSzCdStagePersRelInt(ap.getSzCdStagePersRelInt());
          selectedAttendees.addAttendee(a);
          selectedAttendees.setUlRowQty(++count);
        }
        i++;
      }
      if (selectedAttendees.hasUlRowQty() && selectedAttendees.getUlRowQty() > 0) {
        rowcsub39sig00.setAttendee_Array(selectedAttendees);
      }
    }
    //-- *************************************************************************************************
    
    //-- OUTCOME LIST AND COURT LANGUAGE LIST ************************************************************
    //-- selected on page
    List<String> newOutcomes = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbgOutcome_"));
    if(newOutcomes == null){
      newOutcomes = new ArrayList<String>();
    }
    List<String> newCrtLangs = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbgCtOrdLang_"));
    if(newCrtLangs == null){
      newCrtLangs = new ArrayList<String>();
    }
    
    //-- previously saved values (from retrieve output object)
    List<String> oldOutcomes = new ArrayList<String>();
    if(!pageMode.equals(WINDOW_MODE_NEW_USING) && csub38so.getSzCdOutcome_Array() != null && csub38so.getSzCdOutcome_Array().getUlRowQty() > 0){
      //-- interestingly, using Arrays.asList binds the newly created list to the array it represents meaning
      //-- it is also a fixed size, so attempts to add to it throw an UnsupportedOperationException
      //oldOutcomes = Arrays.asList(csub38so.getSzCdOutcome_Array().getSzCdOutcome());
      
      //-- do this instead
      oldOutcomes = csub38so.getSzCdOutcome_Array().getSzCdOutcomeAsReference();
    }
    List<String> oldCrtLangs = new ArrayList<String>();
    if(!pageMode.equals(WINDOW_MODE_NEW_USING) && csub38so.getSzCdCrtLang_Array() != null && csub38so.getSzCdCrtLang_Array().getUlRowQty() > 0){
      //oldCrtLangs = Arrays.asList(csub38so.getSzCdCrtLang_Array().getSzCdCrtLang());
      oldCrtLangs = csub38so.getSzCdCrtLang_Array().getSzCdCrtLangAsReference();
    }
    
    Outcome_Array outcomeArray = new Outcome_Array();
    int outcomeRowQty = 0;
    Collection<String> allOutcomes = Lookup.getCategoryCodesCollection(CodesTables.CLEGLOUT);
    for(Iterator<String> it = allOutcomes.iterator(); it.hasNext();){
      String code = it.next();
      if(oldOutcomes.contains(code) && !newOutcomes.contains(code)){
        //-- add to array with function code of DELETE
        Outcome outcome = new Outcome();
        outcome.setSzCdOutcome(code);
        outcome.setCReqFuncCd(DELETE);
        outcomeArray.addOutcome(outcome);
        outcomeRowQty++;
        
        //-- remove from oldOutcomes
        oldOutcomes.remove(code);
      }
      
      if(newOutcomes.contains(code) && !oldOutcomes.contains(code)){
        //-- add to array with function code of ADD
        Outcome outcome = new Outcome();
        outcome.setSzCdOutcome(code);
        outcome.setCReqFuncCd(ADD);
        outcomeArray.addOutcome(outcome);
        outcomeRowQty++;
        
        //-- add to oldOutcomes
        oldOutcomes.add(code);
      }
    }
    outcomeArray.setUlRowQty(outcomeRowQty);
    rowcsub39sig00.setOutcome_Array(outcomeArray);
    
    //-- needed so the service can easily check which alerts/tasks to create
    SzCdOutcome_Array szCdOutcome_Array = new SzCdOutcome_Array();
    szCdOutcome_Array.setSzCdOutcome(oldOutcomes);
    rowcsub39sig00.setSzCdOutcome_Array(szCdOutcome_Array);
    
    CourtLanguage_Array crtLangArray = new CourtLanguage_Array();
    int crtLangRowQty = 0;
    Collection<String> allCrtLangs = Lookup.getCategoryCodesCollection(CodesTables.CCRTLANG);
    for(Iterator<String> it = allCrtLangs.iterator(); it.hasNext();){
      String code = it.next();
      if(oldCrtLangs.contains(code)){
        if(!newCrtLangs.contains(code)){
          //-- add to array with function code of DELETE
          CourtLanguage crtLang = new CourtLanguage();
          crtLang.setSzCdCrtLang(code);
          crtLang.setCReqFuncCd(DELETE);
          crtLangArray.addCourtLanguage(crtLang);
          crtLangRowQty++;
        }
      }
      
      if(newCrtLangs.contains(code)){
        if(!oldCrtLangs.contains(code)){
          //-- add to array with function code of ADD
          CourtLanguage crtLang = new CourtLanguage();
          crtLang.setSzCdCrtLang(code);
          crtLang.setCReqFuncCd(ADD);
          crtLangArray.addCourtLanguage(crtLang);
          crtLangRowQty++;
        }
      }
    }
    crtLangArray.setUlRowQty(crtLangRowQty);
    rowcsub39sig00.setCourtLanguage_Array(crtLangArray);

    // wjcochran -- REMOVED UNUSED CODE
    
    // When the date is filled for the first time, a ToDo should be created and
    // information populated.
    String indDtOutcomeFlld = "";
    if (csub38so.getROWCSUB38SOG01().getDtDtLegalActOutcomeDt() == null) {
      indDtOutcomeFlld = INDICATOR_NO;
    } else {
      indDtOutcomeFlld = INDICATOR_YES;
    }
    csub39si.setCSysIndDtOutcomeFlld(indDtOutcomeFlld);

    // was used for Save & Stay to re-retrieve legal info
    // will always be set to 'N' for IMPACT since Save & Stay was removed
    csub39si.setBSysIndGeneric(INDICATOR_NO);

    // wjcochran -- REMOVED UNUSED CODE

    csub39si.setSzCdStage(GlobalData.getSzCdStage(request));

    rowccmn01uig00.setSzCdTask(GlobalData.getSzCdTask(request));
    rowccmn01uig00.setTsLastUpdate(csub38so.getROWCSUB38SOG00().getTsLastUpdate());

    //-- LOGIC FOR SETTING EVENT STATUS *********************************************************
    String eventStatus = csub38so.getROWCSUB38SOG00().getSzCdEventStatus();
    switch (method) {
      case METHOD_SAVE_REFRESH:
        //-- if status is already PEND and user is approver, do not invalidate approval and keep PEND
        if(eventStatus != null && !PageModeConstants.NEW_USING.equals(pageMode) && 
           eventStatus.equals(STATUS_PENDING) && !callInvalidateApprovalIfUserIsNotApprover(context)){
          rowccmn01uig00.setSzCdEventStatus(STATUS_PENDING);
        } else{
          rowccmn01uig00.setSzCdEventStatus(STATUS_IN_PROC);
        }
        rowcsub39sig00.setIndComplete(INDICATOR_NO);
        break;
      case METHOD_SAVE_REDIRECT:
        //-- If this command was called and the form successfully validated,
        //-- that means the Save button was clicked and the Complete checkbox
        //-- has been checked.  Repeat logic from above but with different results.
        if(eventStatus != null && !PageModeConstants.NEW_USING.equals(pageMode) &&
           eventStatus.equals(STATUS_PENDING) && !callInvalidateApprovalIfUserIsNotApprover(context)){
          rowccmn01uig00.setSzCdEventStatus(STATUS_PENDING);
          rowcsub39sig00.setIndComplete(INDICATOR_NO);
        } else{
          rowccmn01uig00.setSzCdEventStatus(STATUS_COMPLETE);
          rowcsub39sig00.setIndComplete(INDICATOR_YES);
        }
        break;
      //-- It was agreed that all pages submitting an event for approval via the url /workload/ToDo/newApprovalToDo
      //-- (which is the newApprovalToDo_xa method of the ToDoConversation) should first save their related
      //-- event(s) with a status of COMP b/c this is what the logic for the To-Do Detail page expects in order
      //-- to properly update the status to PEND when saving a new approval todo and event.
      case METHOD_SAVE_AND_SUBMIT:
        if(eventStatus != null && !PageModeConstants.NEW_USING.equals(pageMode) &&
           eventStatus.equals(STATUS_PENDING)){
          callInvalidateApprovalIfUserIsNotApprover(context);
        }
        // SMS #47858 - set the status to PROC. We don't want to use COMP status
        // for legal actions that are submitted for approval.
        rowccmn01uig00.setSzCdEventStatus(STATUS_IN_PROC);
        if ("on".equals(ContextHelper.getStringSafe(context, "cbxComplete"))) {
          rowcsub39sig00.setIndComplete(INDICATOR_YES);
        } else {
          rowcsub39sig00.setIndComplete(INDICATOR_NO);
        }

        break;
    }
    //-- ****************************************************************************************
    rowccmn01uig00.setSzCdEventType(SUB_LEGAL_ACT_EVENT_TYPE);

    if(pageMode.equals(WINDOW_MODE_NEW) || pageMode.equals(WINDOW_MODE_NEW_USING)){
      //-- this field represents the date that the legal action was recorded,
      //-- not when it occurred
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    }
    rowccmn01uig00.setUlIdEvent(GlobalData.getUlIdEvent(request));
    rowccmn01uig00.setUlIdStage(GlobalData.getUlIdStage(request));
    rowccmn01uig00.setUlIdPerson(loggedInUserId);

    //-- LOGIC FOR SETTING EVENT DESCRIPTION ************************************************************
    if (INDICATOR_YES.equals(rowcsub39sig00.getIndUpPrevAct())) {
      description.append("Update: ");
    }
    String legalAction = Lookup.simpleDecodeSafe("CLEGCPS", rowcsub39sig00.getSzCdLegalActAction());
    description.append(legalAction);
    if (!"".equals(rowcsub39sig00.getSzCdHrTypCrtOrd())) {
      String htco = Lookup.simpleDecodeSafe("CLHECOT", rowcsub39sig00.getSzCdHrTypCrtOrd());
      description.append(" " + htco);
    }
    String actionDate = FormattingHelper.formatDate(rowcsub39sig00.getDtCrtActDate());
    description.append(" " + actionDate);

    rowccmn01uig00.setSzTxtEventDescr(description.toString());
    //-- ************************************************************************************************

    if (GlobalData.getUlIdEvent(request) == 0
        || (GlobalData.getUlIdEvent(request) != 0 && (pageMode.equals(WINDOW_MODE_NEW_USING) || pageMode.equals(
            WINDOW_MODE_NEW)))) {
      rowccmn01uig01.setUlIdPerson(ulIdPerson);
      rowccmn01uig01.setSzCdScrDataAction(ADD);
    } else {
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_NO_ACTION);
    }

    // Add the struct to the array
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    // Set the array into the parent struct
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    csub39si.setArchInputStruct(input);
    csub39si.setROWCSUB39SIG00(rowcsub39sig00);
    csub39si.setROWCCMN01UIG00(rowccmn01uig00);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return csub39si;
  }
  
  //-- Returns true if invalidateApproval called, otherwise false
  private boolean callInvalidateApprovalIfUserIsNotApprover(GrndsExchangeContext context){
    boolean result = false;
    
    HttpServletRequest request = context.getRequest();
    int eventId = GlobalData.getUlIdEvent(request);
    if(eventId != 0){
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      int loggedInUserId = userProfile.getUserID();
      int approverId = -1;
      
      ApproversRetrieveSI si = new ApproversRetrieveSI(ApproversRetrieveSI.SUBMITTED_EVENT, eventId);
      ApproversRetrieveSO so = common.retrieveApprovers(si);
      if(so.hasCurrentActiveApprover()){
        approverId = so.getCurrentActiveApprover().getIdPerson();
      }

      //-- if user is not approver, invalidate approval
      // Per STGAP00009550 Or if you are not in Approval mode.
      if (loggedInUserId != approverId ||!GlobalData.isApprovalMode(request)) {
        CCMN05UI ccmn05ui = new CCMN05UI();
        ccmn05ui.setUlIdEvent(eventId);
        ArchInputStruct ais = new ArchInputStruct();
        ais.setUlSysNbrReserved1(ArchitectureConstants.N);
        ccmn05ui.setArchInputStruct(ais);
        try{
          admin.invalidateApproval(ccmn05ui);
        } catch(ServiceException se){
          handleError(se, context, ArchitectureConstants.ERROR_BRANCH_NAME);
        }
        result = true;
      }
    }
    
    return result;
  }
  /**
   * This method will set the inputs into the CCMN35S service to stage progress.
   *
   * @param context data to pass to the save service
   */
  private CCMN35SI populateCCMN35SI_AutoAdoStageProgress(GrndsExchangeContext context, 
                                                         int ulIdPerson, int ulIdEvent) {
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    CCMN35SI ccmn35si = new CCMN35SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(userProfile.getUserLogonID());
    ccmn35si.setUlIdCntrctWkr(userProfile.getUserID());
    ccmn35si.setArchInputStruct(input);
    ccmn35si.setUlIdStage(GlobalData.getUlIdStage(request));
    ccmn35si.setUlIdCase(GlobalData.getUlIdCase(request));
    ccmn35si.setSzCdStage(GlobalData.getSzCdStage(request));
    ccmn35si.setUlIdEvent(ulIdEvent);
    ccmn35si.setUlIdPerson(ulIdPerson);
    return ccmn35si;
  }
  
  private void handleError(Exception e, GrndsExchangeContext context, String errorBranch){
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    state.setAttribute("legalActionSaveRefresh", "true", request);
    if(e instanceof ServiceException){
      ServiceException se = (ServiceException) e;
      if(errorBranch != null){
        setPresentationBranch(errorBranch, context);
      }
      int errorCode = se.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_DETAIL_DELETED:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_NO_CASA_GAL:
      case Messages.MSG_CASA_GAL_EXISTS:
        setErrorMessage(errorCode, DISPLAY_PAGE, request);
        break;
      default:
        processSevereException(context, se);
        break;
      }
    } else{
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
  }
}
