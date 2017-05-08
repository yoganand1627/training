package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePPT;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrievePPTParticipant;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePPTDetail;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePPTParticipant;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB28SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCSUB28SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB27SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * Used to handle PPT functions and procedures.
 *
 * @author Jason Rios, March 10, 2003
 *         <p/>
 *         <pre>
 *         <p/>
 *                  Change History:
 *                   Date        User        Description
 *                   --------  ------------  ---------------------------------------------------
 *                   06/06/03  GRIMSHAN      SIR 16979 - Retrieve page mode from event search
 *                                           conversation if the page mode does not need to be
 *                                           changed, it will not be
 *                   06/27/03  Eric Dickman  SIR 18447 and SIR 18448.  The if statement, will
 *                                           allow a user with PPT security to modify the PPT and PPT
 *                                           Detail page.
 *                   07/09/03  Todd Reser    SIR 18297 - Changed to use user Logon ID instead of
 *                                           User ID.
 *                   11/06/03  Todd Reser    SIR 19794 - Switched to io.PPTParticipant so when
 *                                           going to Staff Search from PPTParticipant Radio
 *                                           Buttons are used instead of Checkboxes.
 *                   04/16/04  Donald Wilson SIR 16299 - If the event status is NEW or PROC,
 *                                           display an informational message at the top of the
 *                                           page reminding the worker to update the child's
 *                                           Person Characteristics, if necessary.
 *                   07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 *                   05/20/2008  arege       Added if clause reloadPPTParticipant_xa and populateCSUB28SI_Save
 *                                           to resolve the System Error caused when SzSdsPptPartRelationship is 
 *                                           less than 20 characters.
 *                   12/10/2008  arege       STGAP00009725 Added Task Code for Team Meetings/Reviews approval
 *                                           event in the ADO stage.
 *                   03/01/2010  wjcochran   MR-062: Added logic for adding a Contact Standard to a Family
 *                                           Team Meeting. Added addContactStandards_xa and
 *                                           displayContactStandards_xa methods.                             
 *                   
 */
@SuppressWarnings({"serial"})
public class PPTConversation extends BaseHiddenFieldStateConversation {
  // Declare static constants
  //public static final String PPT_TASK_CODE = "3180";
  public static final String PPT_EVENT_DESC = "Team Meetings/Reviews";
  public static final int PARTICIPANTS_PER_PAGE = 30;
  public static final int INITIAL_PAGE = 1;
  public static final int CURRENT = 0;
  public static final int NEXT = 1;
  private InvalidateApproval invalidateApproval = null;
  public static final String PRS_STAFF = "DFCS Staff";
  public static final String SAVE_BUTTON_ON_PPT_PAGE = "btnSaveOnPPT";
  public static final String SAVE_BUTTON_ON_PARTICIPANT_PAGE = "btnSaveOnParticipant";
  public static final String DELETE_BUTTON_ON_PPT_PAGE = "btnDeleteOnPPT";
  public static final String DELETE_BUTTON_ON_PARTICIPANT_PAGE = "btnDeleteOnParticipant";
  public static final String PPT_INFORMATION_PAGE = "/subcare/PPT/displayPPT";
  public static final String PPT_PARTICIPANT_PAGE = "/subcare/PPT/displayPPTParticipant";
  public static final String PARTICIPANT_DETAIL_PAGE_MODE = "participantDetailPageMode";
  public static final String TRACE_TAG = "OnCallConversation";

  public static final String DOCEXISTS = "docExists";
  public static final String SEL_PARTICIPANT_TYPE = "selParticipantType";
  public static final String TXT_PARTICIPATION_DATE = "txtParticipationDate";
  public static final String TXT_NOTIFIED_DATE = "txtNotifiedDate";
  public static final String SEL_NOTIFICATION_TYPE = "selNotificationType";
  public static final String TXT_PARTICIPANT_NAME = "txtParticipantName";
  public static final String TXT_RELATIONSHIP_INTEREST = "txtRelationshipInterest";
  public static final String HDN_PERSON_ID = "hdnPersonId";
  public static final String HDN_PARTICIPANT_ID = "hdnParticipantId";
  public static final String TXT_MEETING_DATE = "txtMeetingDate";
  public static final String TXT_MEETING_TYPE = "txtMeetingType";
  public static final String IND_ASSIST_NEEDED = "cbxIndAssistNeeded";
  public static final String DATE_HEARING_REQ = "txtDateHearingReq";
  public static final String DATE_OUTCOME_DISCUSSED = "txtOutcomeDiscussed";
  public static final String TXT_DOCUMENT_COMPLETED_DATE = "txtDocumentCompletedDate";
  public static final String TXT_MEETING_TIME = "txtMeetingTime";
  public static final String DATE_UTIL_BEGIN = "txtBeginDate";
  public static final String DATE_UTIL_END = "txtEndDate";
  public static final String DATE_PREP_INTVW = "txtDatePrepIntvw";
  public static final String DATE_PERM_REP_COM = "txtPermRepComp";
  public static final String IND_PERMANENCY = "cbxPermanency";
  public static final String IND_PRE_REQ_MET ="cbxPrevReqMet";
  public static final String IND_WELLBEING = "cbxWellbeing";
  public static final String IND_TRAN_PLAN_COMP = "cbxTranPlanComp";
  public static final String IND_SAFETY = "cbxSafety";
  public static final String TXT_TITLE = "txtTitle";
  public static final String TXT_AGENCY = "txtAgency";
  public static final String IND_ACCPTD_CHANGES = "cbxAccptdChnges";
  public static final String IND_SIGNED_WVR_AH = "signedWvrAh";
  public static final String IND_REQ_AH = "reqAh";
  public static final String IND_TRAN_PLAN = "cbxTranPlanComp";
  public static final String PPT_TASK_PULLBACK = "hdnPptTaskBack";
  public static final String PPT_CONTACT_STDS_TASK_PULLBACK = "hdnContactStdsReqTaskBack";
  public static final String PPT_ID_PPT_EVENT = "hdnIdPptEvent";
  public static final String PPT_ID_CNTCT_STDS_EVENT = "hdnIdContactStdsEvent";
  
  private RetrievePPT retrievePPT;
  private RetrievePPTParticipant retrievePPTParticipant;
  private SavePPTDetail savePPT;
  private SavePPTParticipant savePPTParticipant;
  private static final Map<String, String> APPROVAL_TASK_MAP = new HashMap<String, String>() {
    {
      //SUB
      put("3180", "9410");
      put("5930", "9420");
      put("5940", "9450");
      put("5950", "9430");
      put("5960", "9440");
      put("8680", "9480"); //Added Per STGAP00009725 TaskCode for Approval Event in ADO stage.
    }
  };
  
  private static final Map<String, String> CNTCT_STDS_STAGES = new HashMap<String, String>() {
    {
      put("FPR", "7025");
      put("FSU", "6540");
    }
  };
  
  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }
  
  public void setSavePPT (SavePPTDetail savePPT){
    this.savePPT = savePPT;
  }
  
  
  public void setRetrievePPT (RetrievePPT retrievePPT){
    this.retrievePPT = retrievePPT;
  }
  
  public void setsavePPTParticipant (SavePPTParticipant savePPTParticipant){
    this.savePPTParticipant = savePPTParticipant;
  } 
  
  public void setRetrievePPTPart(RetrievePPTParticipant retrievePPTParticipant){
    this.retrievePPTParticipant = retrievePPTParticipant;
  }
  /**
   * Displays the PPT Search page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void displayPPT_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPPT_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    boolean invalidateMessageIsAlreadyInRequest = false;
    
    try {
      /*
       * the Contact Standards CdTask will be in state if
       * we are coming from the addContactStandards method.
       * The PPT idEvent should also be in state when coming
       * back from ContactStandards.
       */
      String cdTaskCntctStds = (String) state.getAttribute(PPT_CONTACT_STDS_TASK_PULLBACK, request);
      String cdTaskPpt = (String) state.getAttribute(PPT_TASK_PULLBACK, request);
      Integer idPptEvent = (Integer) state.getAttribute(PPT_ID_PPT_EVENT, request);
      
      // Preserve the value of PageMode because Event List will send PageMode
      // NEW when the user clicks 'Add' on the Event List to create a new PPT.
      //event list sets page mode
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      state.removeAllAttributes(request);
      PageMode.setPageMode(pageMode, request);
      
      CSUB29SO csub29so = null;
      if (CNTCT_STDS_STAGES.containsValue(cdTaskCntctStds)) {
        GlobalData.setUlIdEvent(idPptEvent, request);
        GlobalData.setSzCdTask(cdTaskPpt, request);
      }

      if (GlobalData.getUlIdEvent(request) > 0) {
        CSUB29SI csub29si = this.populateCSUB29SI_Retrieve(context);
        csub29so = retrievePPT.retrievePPT(csub29si);
      }

      //--------------------------
      //--- Query the PPT data ---
      //--------------------------
      // NOTE: Three different situations to consider when querying PPT data:
      // 1) If the stage has no PPT events, the user will create one by clicking
      //    the 'Add' button on the Event List. AppMode will be NEW in this case.
      //    No PPT event will exist. No PPT row will exist in the PPT table.
      // 2) When the user enters a 'Document Completed' date for an existing
      //    PPT, a new PPT event will be created, but a PPT row will not be
      //    written to the PPT table. When the user accesses the new PPT event,
      //    AppMode will be MODIFY, but the PPT event status will be NEW.
      // 3) Otherwise, if the user accesses an existing PPT, AppMode will be
      //    MODIFY, the PPT event status will be PROC or COMP, and a PPT row
      //    will exist in the PPT table.
      if (csub29so != null) {
        
        if (CodesTables.CEVTSTAT_PEND.equals(csub29so.getROWCSUB29SOG01().getSzCdEventStatus())
                        && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
                      setInformationalMessage(Messages.MSG_FP_INVLD_APRVL, request);
                      setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
                      invalidateMessageIsAlreadyInRequest = true;
        }
        
        CSUB29SOG00 csub29sog00 = csub29so.getCSUB29SOG00();
        int idContactStdsEvent = csub29sog00.getUlIdContactStdsEvent();
        state.setAttribute(PPT_ID_CNTCT_STDS_EVENT, idContactStdsEvent, request);
        state.setAttribute("CSUB29SO", csub29so, request);

        String name = GlobalData.getSzNmStage(request);
        GlobalData.setSzNmPersonFull(name,request);
        

        // Set the "Location" data into the AdminAddressPhoneBean so that it
        // can populate the sub-module.
        AdminAddressPhoneBean aapBean = new AdminAddressPhoneBean();
        
        if (csub29so.getCSUB29SOG00()!=null){
          aapBean.setAddress1(csub29so.getCSUB29SOG00().getSzAddrPptStLn1());
          aapBean.setAddress2(csub29so.getCSUB29SOG00().getSzAddrPptStLn2());
          aapBean.setCity(csub29so.getCSUB29SOG00().getSzAddrPptCity());
          aapBean.setComments(csub29so.getCSUB29SOG00().getSzTxtPptAddrCmnt());
          aapBean.setCounty(csub29so.getCSUB29SOG00().getSzAddrPptCnty());
          aapBean.setPhone(csub29so.getCSUB29SOG00().getSzNbrPptPhone());
          aapBean.setPhoneExt(csub29so.getCSUB29SOG00().getLNbrPptPhoneExt());
          aapBean.setState(csub29so.getCSUB29SOG00().getSzAddrPptState());
          aapBean.setZipAndSuff(csub29so.getCSUB29SOG00().getSzAddrPptZip());
          aapBean.addToRequest(request);
        }
        // Set the pagination objects to the appropriate values for the call to
        // the PPT Participation Retrieve service (CSUB27S).
        TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
        ValueBeanHelper.populateDefaultValues(context, tuxPagination);
        tuxPagination.getResultDetails().setResultsPerPage(PARTICIPANTS_PER_PAGE);
        ArchInputStruct input = new ArchInputStruct();
        input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
        input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());

        // Query the PPT Participant details.
        CSUB27SI csub27si = populateCSUB27SI_Retrieve(GlobalData.getUlIdEvent(request));
        csub27si.setArchInputStruct(input);
        CSUB27SO csub27so = retrievePPTParticipant.retrievePPTParticipant(csub27si);
            
        state.setAttribute("CSUB27SO", csub27so, request);
        
        // If rows were returned by the service, put the pagination
        // information into the request.
        if (csub27so.getROWCSUB27SOG00_ARRAY().getUlRowQty() > 0) {
          tuxPagination.setPaginationInformation(csub27so.getArchOutputStruct(),
                                                 csub27so.getROWCSUB27SOG00_ARRAY().getUlRowQty());
          storePaginationBeanToRequest(context, tuxPagination);
        }
        
        // This may be used when the Narrative is implemented. If not it needs to be removed.
        if (csub29so.getCSUB29SOG00().getTsLastUpdate() != null) {
          request.setAttribute(DOCEXISTS, ArchitectureConstants.TRUE);
        } else {
          request.setAttribute(DOCEXISTS, ArchitectureConstants.FALSE);
        }
        
      } // end if (!GlobalData.getAppMode(request).equals(PageMode.NEW) &&...     
    }
    catch (ServiceException we) {
      handleError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Saves the data from the PPT Information page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void savePPT_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePPT_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CSUB29SO retrieveSO = (CSUB29SO) state.getAttribute("CSUB29SO", request);

    try {
      if (retrieveSO != null && retrieveSO.getROWCSUB29SOG01() != null &&
                      CodesTables.CEVTSTAT_PEND.equals(retrieveSO.getROWCSUB29SOG01().getSzCdEventStatus())
                      && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
                    CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(GlobalData.getUlIdEvent(request));
                    invalidateApproval.invalidateApproval(ccmn05ui);
                  }
      CSUB50SI csub50si = this.populateCSUB50SI_Save(context);
      CSUB50SO csub50so = savePPT.savePPTDetail(csub50si);

      // Put the PPT event id into GlobalData in case the PPT was newly saved
      // to the database.
      GlobalData.setUlIdEvent(csub50so.getUlIdEvent(), request);

      // Set the PageMode to MODIFY in case in was ADD before the save.
      PageMode.setPageMode(PageModeConstants.MODIFY, request);

      // If the original 'Meeting Date' has changed, remind the user that they
      // should consider notifying the participants of the change.
      String bMeetingDateHasChanged = ContextHelper.getStringSafe(request, "bMeetingDateHasChanged");
      if ((ArchitectureConstants.Y).equals(bMeetingDateHasChanged)) {
        setInformationalMessage(
                MessageLookup.getMessageByNumber(Messages.MSG_SUB_RENOTIFY_DATE),
                PPT_INFORMATION_PAGE,
                request);
      }
    }
    catch (ServiceException wtc) {
      handleError(wtc, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Saves the data fields on the page, activates the to-dos, and submits the pages to a
   * supervisor for approval 
   * 
   * @param context GrndsExchangeContext
   */
  public void saveAndSubmitPPT_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAndSubmitPPT_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CSUB29SO retrieveSO = (CSUB29SO) state.getAttribute("CSUB29SO", request);

    try {
      if (retrieveSO.getROWCSUB29SOG01() != null &&
                      CodesTables.CEVTSTAT_PEND.equals(retrieveSO.getROWCSUB29SOG01().getSzCdEventStatus())
                      && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
                    CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(GlobalData.getUlIdEvent(request));
                    invalidateApproval.invalidateApproval(ccmn05ui);
                  }
      CSUB50SI csub50si = this.populateCSUB50SI_Save(context);
      csub50si.getROWCCMN01UIG00().setSzCdEventStatus("PEND");
      CSUB50SO csub50so = savePPT.savePPTDetail(csub50si);

      // Put the PPT event id into GlobalData in case the PPT was newly saved
      // to the database.
      GlobalData.setUlIdEvent(csub50so.getUlIdEvent(), request);

      /* The saveAndSubmitPPT_xa was modified from the above savePPT_xa method
       * Some of the save code was removed from the saveAndSubmit. It may need to be added
       * back in at some point
       */
      
      int ulIdEvent = csub50si.getROWCCMN01UIG00().getUlIdEvent();
      int ulIdCase = GlobalData.getUlIdCase(request);
      int ulIdStage = csub50si.getROWCCMN01UIG00().getUlIdStage();
      String szCdTask = APPROVAL_TASK_MAP.get(csub50si.getROWCCMN01UIG00().getSzCdTask());
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ulIdEvent, ulIdCase, ulIdStage, szCdTask);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
    }
    catch (ServiceException wtc) {
      handleError(wtc, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  /**
   * Displays the PPT Participant Detail page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void displayPPTParticipant_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPPTParticipant_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // If the user performed a Person List pullback or a Staff Search pullback,
      // the original PageMode value will have been set into state to preserve
      // it. Get that PageMode, if it exists, and restore it. Otherwise, PageMode
      // will be the value to which it was set in the displayPPT_xa activity method.
      if (state.getAttribute(PARTICIPANT_DETAIL_PAGE_MODE, request) != null) {
        PageMode.setPageMode((String) state.getAttribute(PARTICIPANT_DETAIL_PAGE_MODE, request), request);
        state.removeAttribute(PARTICIPANT_DETAIL_PAGE_MODE, request);
      }

      int selectedParticipantId = ContextHelper.getIntSafe(request, "selectedParticipantId");

      // If 'selectedParticipantId' exists, the user selected a participant
      // from the PPT Participation list. Otherwise, they selected a person
      // from the Person List or Staff Search Results list.
      ROWCSUB27SOG00 participant = new ROWCSUB27SOG00();
      if (selectedParticipantId > 0) {
        CSUB27SO csub27so = (CSUB27SO) state.getAttribute("CSUB27SO", request);

        Enumeration enumeration = csub27so.getROWCSUB27SOG00_ARRAY().enumerateROWCSUB27SOG00();
        while (enumeration.hasMoreElements()) {
          ROWCSUB27SOG00 thisParticipant = (ROWCSUB27SOG00) enumeration.nextElement();
          if (thisParticipant.getUlIdPptPart() == selectedParticipantId) {
            participant = thisParticipant;
            break;
          }
        }
      } else {
        // Update the participant object in state with the new values received
        // from the pullback. (This will ensure that 'Participant Type' and the
        // date field values will be preserved.)
        ROWCSUB27SOG00 participantFromState = (ROWCSUB27SOG00) state.getAttribute("participant", request);
        participant = participantFromState;

        // If the user performed a Staff Search, get the object returned by
        // Staff Search containing the selected staff person's info.
        if (request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null) {
          ROWCCMN50DO_ARRAY staffSearch_array = (ROWCCMN50DO_ARRAY) request.getAttribute(
                  StaffSearchInput.STAFF_PULL_BACK);
          ROWCCMN50DO staffSearchEmployee = staffSearch_array.getROWCCMN50DO(0);
          staffSearchEmployee.getSzNmPersonFull();
          participant.setSzNmPptPartFull(staffSearchEmployee.getSzNmPersonFull());
          participant.setUlIdPerson(staffSearchEmployee.getUlIdPerson());
          participant.setSzSdsPptPartRelationship(PRS_STAFF);
          String title = Lookup.simpleDecodeSafe(CodesTables.CTITLEA, staffSearchEmployee.getSzCdJobTitle());
          participant.setTxtTitle(title);
        } else if (request.getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME) != null) {
          PersonListPullBackInfo person = (PersonListPullBackInfo) request.getAttribute(
                  PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);
          participant.setSzNmPptPartFull(person.getPersonListRow().getSzNmPersonFull());
          participant.setUlIdPerson(person.getPersonListRow().getUlIdPerson());

          String relationshipInterest = Lookup.simpleDecodeSafe(
                  CodesTables.CRPTRINT,
                  person.getPersonListRow().getSzCdStagePersRelInt());
          String personTitle = person.getPersonListRow().getSzCdIncmgPersTitle();
          participant.setTxtTitle(Lookup.simpleDecodeSafe(CodesTables.CTITLE,personTitle));
          participant.setSzSdsPptPartRelationship(relationshipInterest);
        }
      } // end if (selectedParticipantId > 0)

      state.setAttribute("participant", participant, request);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Displays the PPT Participant Detail page in NEW mode so the user can add a PPT Participant.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void addPPTParticipant_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addPPTParticipant_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      PageMode.setPageMode(PageModeConstants.NEW, request);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Reloads the PPT Participant Detail page after the user has selected a Participant Type.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void reloadPPTParticipant_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".reloadPPTParticipant_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      ROWCSUB27SOG00 participant = new ROWCSUB27SOG00();
      String selParticipantType = ContextHelper.getStringSafe(request, SEL_PARTICIPANT_TYPE);
      participant.setSzCdPptPartType(selParticipantType);

      if (request.getParameter(TXT_PARTICIPATION_DATE) != null &&
          !"".equals(request.getParameter(TXT_PARTICIPATION_DATE))) {
        participant.setDtDtPptDate(ContextHelper.getCastorDateSafe(request, TXT_PARTICIPATION_DATE));
      }
      if (request.getParameter(TXT_NOTIFIED_DATE) != null &&
          !"".equals(request.getParameter(TXT_NOTIFIED_DATE))) {
        participant.setDtDtPptPartDateNotif(ContextHelper.getCastorDateSafe(request, TXT_NOTIFIED_DATE));
      }
      if (request.getParameter(SEL_NOTIFICATION_TYPE) != null &&
          !"".equals(request.getParameter(SEL_NOTIFICATION_TYPE))) {
        participant.setSzCdPptNotifType(ContextHelper.getStringSafe(request, SEL_NOTIFICATION_TYPE));
      }

      // If the user selected "Other" as the Participant Type, preserve the
      // values in the Name and Relationship/Interest fields.
      if (selParticipantType.equals(CodesTables.CPARTYPE_OTH)) {
        if (request.getParameter(TXT_PARTICIPANT_NAME) != null &&
            !"".equals(request.getParameter(TXT_PARTICIPANT_NAME))) {
          participant.setSzNmPptPartFull(ContextHelper.getStringSafe(request, TXT_PARTICIPANT_NAME));
        }
        if (request.getParameter(TXT_RELATIONSHIP_INTEREST) != null &&
            !"".equals(request.getParameter(TXT_RELATIONSHIP_INTEREST))) {
          int txtRelationshipInterestLength = request.getParameter(TXT_RELATIONSHIP_INTEREST).length();
          if (txtRelationshipInterestLength > 20){
          String newTxtRelationshipInterest = request.getParameter(TXT_RELATIONSHIP_INTEREST).substring(0,20);
          participant.setSzSdsPptPartRelationship(newTxtRelationshipInterest);}
          else  
          {
          participant.setSzSdsPptPartRelationship(ContextHelper.getStringSafe(request, TXT_RELATIONSHIP_INTEREST));
          }
        }
      }
      state.setAttribute("participant", participant, request);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Saves the data from the PPT Participant Detail page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void savePPTParticipant_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".savePPTParticipant_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      CSUB28SI csub28si = this.populateCSUB28SI_Save(context);
      savePPTParticipant.savePPTParticipant(csub28si);
      PageMode.setPageMode(PageModeConstants.MODIFY, request);
    }
    catch (ServiceException we) {
      handleError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Deletes a PPT Participant record from the database.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void deletePPTParticipant_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deletePPTParticipant_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String deleteOnPPT = DELETE_BUTTON_ON_PPT_PAGE + ".x";
    boolean bDeleteOnPPT = ContextHelper.getString(request, deleteOnPPT) != null;
    String deleteOnParticipation = DELETE_BUTTON_ON_PARTICIPANT_PAGE + ".x";
    boolean bDeleteOnParticipation = ContextHelper.getString(request, deleteOnParticipation) != null;

    try {
      UserProfile user = UserProfileHelper.getUserProfile(request);
      ArchInputStruct input = new ArchInputStruct();
      CSUB28SI csub28si = new CSUB28SI();
      ROWCSUB28SIG00 rowcsub28sig00 = new ROWCSUB28SIG00();
      ROWCSUB28SIG00_ARRAY rowcsub28sig00_array = new ROWCSUB28SIG00_ARRAY();

      //SIR 18297 - Changed to use user Logon ID instead of User ID.
      input.setSzUserId(user.getUserLogonID());
      input.setUlPageSizeNbr(PARTICIPANTS_PER_PAGE);

      csub28si.setUlIdStage(GlobalData.getUlIdStage(request));
      csub28si.setSWCDNbrListRowsQty(new Integer(1).shortValue());
      // SIR 3913 : if stage is SUB GD will have 3180 else if its ADO it will have 8680
      String PPT_TASK_CODE = GlobalData.getSzCdTask(request);
      csub28si.setSzCdTask(PPT_TASK_CODE);

      rowcsub28sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
      rowcsub28sig00.setCScrIndSendAlert(ArchitectureConstants.N);

      if (bDeleteOnPPT) {
        int selectedParticipantId = ContextHelper.getIntSafe(request, "rbParticipantId_CLEAN");
        rowcsub28sig00.setUlIdPptPart(selectedParticipantId);
        CSUB27SO csub27so = (CSUB27SO) state.getAttribute("CSUB27SO", request);

        Enumeration enumeration = csub27so.getROWCSUB27SOG00_ARRAY().enumerateROWCSUB27SOG00();
        while (enumeration.hasMoreElements()) {
          ROWCSUB27SOG00 participant = (ROWCSUB27SOG00) enumeration.nextElement();
          if (participant.getUlIdPptPart() == selectedParticipantId) {
            rowcsub28sig00.setTsLastUpdate(participant.getTsLastUpdate());
            break;
          }
        } // end while (enumeration.hasMoreElements())
      } // end if (bDeleteOnPPT)
      else if (bDeleteOnParticipation) {
        int selectedParticipantId = ContextHelper.getIntSafe(request, HDN_PARTICIPANT_ID);
        rowcsub28sig00.setUlIdPptPart(selectedParticipantId);
        ROWCSUB27SOG00 participant = (ROWCSUB27SOG00) state.getAttribute("participant", request);
        rowcsub28sig00.setTsLastUpdate(participant.getTsLastUpdate());
      } // end else if (bDeleteOnParticipation)

      rowcsub28sig00_array.addROWCSUB28SIG00(rowcsub28sig00);
      csub28si.setROWCSUB28SIG00_ARRAY(rowcsub28sig00_array);
      csub28si.setArchInputStruct(input);

      savePPTParticipant.savePPTParticipant(csub28si);
    }
    catch (ServiceException we) {
      handleError(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Calls the Person List page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void performPersonListPullback_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performPersonListPullback_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // Preserve the value of PageMode so that it can be restored upon
      // returning from the Person List.
      state.setAttribute(PARTICIPANT_DETAIL_PAGE_MODE, PageMode.getPageMode(request), request);
      PersonListPullBackInfo io = new PersonListPullBackInfo();
      io.setDestinationUrl("/subcare/PPT/displayPPTParticipant");
      PageMode.setPageMode(PersonListConversation.PAGE_MODE_SELECT, request);
      request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, io);
      forward(PersonListConversation.DISPLAY_PAGE, request, context.getResponse());
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Calls the Staff Search page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void performStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performStaffSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      StaffSearchInput staffSearch = new StaffSearchInput();
      // SIR 19794 - Switched to io.PPTParticipant
      staffSearch.setSourcePage(staffSearch.PPTParticipant);
      staffSearch.setDestinationUrl("/subcare/PPT/displayPPTParticipant");
      request.setAttribute("StaffSearchInput", staffSearch);
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Allows the user to add a Contact Standards and attach
   * it to a Family Team Meeting.
   * @param context
   */
  public void addContactStandards_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addContactStandards_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      CSUB29SO csub29so = (CSUB29SO) state.getAttribute("CSUB29SO", request);
      Integer idPptEvent = csub29so.getCSUB29SOG00().getUlIdPptEvent();
      String cdTask = GlobalData.getSzCdTask(request);
      String cdTaskCntctStds = determineContactStandardsCdTask(context);
      
      state.setAttribute(PPT_CONTACT_STDS_TASK_PULLBACK, cdTaskCntctStds, request); 
      state.setAttribute(PPT_TASK_PULLBACK, cdTask, request);
      state.setAttribute(PPT_ID_PPT_EVENT, idPptEvent, request);
      GlobalData.setUlIdEvent(0, request);
      GlobalData.setSzCdTask(cdTaskCntctStds, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }
  
  /**
   * Allows the user to see a Contact Standard that is related
   * to a particular Family Team Meeting.
   * @param context
   */
  public void displayContactStandards_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayContactStandards_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
     Integer idContactStdsEvent = (Integer) state.getAttribute(PPT_ID_CNTCT_STDS_EVENT, request);
     String cdTaskCntctStds = determineContactStandardsCdTask(context);
//     state.setAttribute(PPT_CONTACT_STDS_TASK_PULLBACK, cdTaskCntctStds, request); 
     GlobalData.setUlIdEvent(idContactStdsEvent, request);
     GlobalData.setSzCdTask(cdTaskCntctStds, request);
     forward("/contacts/ContactStandards/displayContactStandards", request, context.getResponse());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  /**
   * Populates the input object for the PPT Participation retrieve service (CSUB27S).
   *
   * @param eventId The id of the PPT event.
   */
  private CSUB27SI populateCSUB27SI_Retrieve(int eventId) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB27SI_Retrieve()");
    performanceTrace.enterScope();

    CSUB27SI csub27si = new CSUB27SI();
    csub27si.setUlIdPptEvent(eventId);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return csub27si;
  }

  /**
   * Populates the input object for the PPT Participant save service (CSUB28S).
   *
   * @param context The GrndsExchangeContext object.
   */
  private CSUB28SI populateCSUB28SI_Save(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB28SI_Save()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    ArchInputStruct input = new ArchInputStruct();
    CSUB28SI csub28si = new CSUB28SI();

    //SIR 18297 - Changed to use user Logon ID instead of User ID.
    input.setSzUserId(user.getUserLogonID());
    input.setUlPageSizeNbr(PARTICIPANTS_PER_PAGE);

    ROWCSUB28SIG00 rowcsub28sig00 = new ROWCSUB28SIG00();
    if (request.getParameter(TXT_PARTICIPATION_DATE) != null &&
        !"".equals(request.getParameter(TXT_PARTICIPATION_DATE))) {
      rowcsub28sig00.setDtDtPptPart(ContextHelper.getCastorDateSafe(request, TXT_PARTICIPATION_DATE));
    }
    if (request.getParameter(TXT_NOTIFIED_DATE) != null &&
        !"".equals(request.getParameter(TXT_NOTIFIED_DATE))) {
      rowcsub28sig00.setDtDtPptPartDateNotif(ContextHelper.getCastorDateSafe(request, TXT_NOTIFIED_DATE));
    }
    if (request.getParameter(SEL_NOTIFICATION_TYPE) != null &&
        !"".equals(request.getParameter(SEL_NOTIFICATION_TYPE))) {
      rowcsub28sig00.setSzCdPptNotifType(ContextHelper.getStringSafe(request, SEL_NOTIFICATION_TYPE));
    }
    if (request.getParameter(SEL_PARTICIPANT_TYPE) != null &&
        !"".equals(request.getParameter(SEL_PARTICIPANT_TYPE))) {
      rowcsub28sig00.setSzCdPptPartType(ContextHelper.getStringSafe(request, SEL_PARTICIPANT_TYPE));
    }
    if (request.getParameter(TXT_PARTICIPANT_NAME) != null &&
        !"".equals(request.getParameter(TXT_PARTICIPANT_NAME))) {
      rowcsub28sig00.setSzNmPptPartFull(ContextHelper.getStringSafe(request, TXT_PARTICIPANT_NAME));
    }
    if (request.getParameter(TXT_RELATIONSHIP_INTEREST) != null
        && !"".equals(request.getParameter(TXT_RELATIONSHIP_INTEREST))) {

      int txtRelationshipInterestLength = request.getParameter(TXT_RELATIONSHIP_INTEREST).length();

      if (txtRelationshipInterestLength > 20) {
        String newTxtRelationshipInterest = request.getParameter(TXT_RELATIONSHIP_INTEREST).substring(0, 20);
        rowcsub28sig00.setSzSdsPptPartRelationship(newTxtRelationshipInterest);
      } else {
        rowcsub28sig00.setSzSdsPptPartRelationship(ContextHelper.getStringSafe(request, TXT_RELATIONSHIP_INTEREST));
      }

    }
    if (request.getParameter(HDN_PERSON_ID) != null &&
        !"".equals(request.getParameter(HDN_PERSON_ID))) {
      rowcsub28sig00.setUlIdPerson(ContextHelper.getIntSafe(request, HDN_PERSON_ID));
    }

    if (request.getParameter(TXT_TITLE) != null &&
        !"".equals(request.getParameter(TXT_TITLE))) {
      rowcsub28sig00.setTxtTitle(ContextHelper.getStringSafe(request, TXT_TITLE));
    }
    if (request.getParameter(TXT_AGENCY) != null &&
        !"".equals(request.getParameter(TXT_AGENCY))) {
      rowcsub28sig00.setTxtAgency(ContextHelper.getStringSafe(request, TXT_AGENCY));
    }
    if (request.getParameter(IND_ACCPTD_CHANGES) != null &&
        !"".equals(request.getParameter(IND_ACCPTD_CHANGES))) {
      rowcsub28sig00.setIndAccptdChnges(CheckboxHelper.getCheckboxValue(request, IND_ACCPTD_CHANGES));
    }
    if (request.getParameter(IND_SIGNED_WVR_AH) != null &&
        !"".equals(request.getParameter(IND_SIGNED_WVR_AH))) {
      rowcsub28sig00.setIndSignedWvrAh(CheckboxHelper.getCheckboxValue(request, IND_SIGNED_WVR_AH));
    }
    if (request.getParameter(IND_TRAN_PLAN_COMP) != null &&
        !"".equals(request.getParameter(IND_TRAN_PLAN_COMP))) {
      rowcsub28sig00.setIndTranPlanComp(CheckboxHelper.getCheckboxValue(request, IND_TRAN_PLAN_COMP));
    }
    if (request.getParameter(IND_REQ_AH) != null &&
        !"".equals(request.getParameter(IND_REQ_AH))) {
      rowcsub28sig00.setIndReqAh(CheckboxHelper.getCheckboxValue(request, IND_REQ_AH));
    }
    if (request.getParameter(TXT_MEETING_DATE) != null &&
        !"".equals(request.getParameter(TXT_MEETING_DATE))) {
      csub28si.setDtDtPptDate(ContextHelper.getCastorDateSafe(request, TXT_MEETING_DATE));
    }
    if (request.getParameter(TXT_MEETING_TIME) != null &&
        !"".equals(request.getParameter(TXT_MEETING_TIME))) {
      csub28si.setTmScrTmPptTime(ContextHelper.getTimeSafe(request, TXT_MEETING_TIME));
    }
    if (request.getParameter(HDN_PARTICIPANT_ID) != null &&
        !"".equals(request.getParameter(HDN_PARTICIPANT_ID))) {
      rowcsub28sig00.setUlIdPptPart(ContextHelper.getIntSafe(request, HDN_PARTICIPANT_ID));
      rowcsub28sig00.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnParticipantDateLastUpdate"));
      rowcsub28sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else {
      rowcsub28sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    }
    rowcsub28sig00.setUlIdPptEvent(GlobalData.getUlIdEvent(request));

    // Determine whether or not the "Send Alert" checkbox is checked. If it is,
    // pass the info needed to create the To-Do.
    rowcsub28sig00.setCScrIndSendAlert(ArchitectureConstants.N);

    if (CodesTables.CPARTYPE_STA.equals(rowcsub28sig00.getSzCdPptPartType()) && 
                    CodesTables.CPPTNOST_ONL.equals(rowcsub28sig00.getSzCdPptNotifType())) {
      CSUB29SO csub29so = (CSUB29SO) state.getAttribute("CSUB29SO", request);
      rowcsub28sig00.setCScrIndSendAlert(ArchitectureConstants.Y);
      csub28si.setUlSysIdTodoCfPersCrea(user.getUserID());
      csub28si.setDtDtPptDate(csub29so.getCSUB29SOG00().getDtDtPptDate());
      csub28si.setTmScrTmPptTime(csub29so.getCSUB29SOG00().getTmScrTmPptTime());
    }

    ROWCSUB28SIG00_ARRAY rowcsub28sig00_array = new ROWCSUB28SIG00_ARRAY();
    rowcsub28sig00_array.addROWCSUB28SIG00(rowcsub28sig00);

    csub28si.setROWCSUB28SIG00_ARRAY(rowcsub28sig00_array);
    csub28si.setSWCDNbrListRowsQty(new Integer(1).shortValue());
    csub28si.setUlIdStage(GlobalData.getUlIdStage(request));
    // SIR 3913 : if stage is SUB GD will have 3180 else if its ADO it will have 8680
    String PPT_TASK_CODE = GlobalData.getSzCdTask(request);
    csub28si.setSzCdTask(PPT_TASK_CODE);
    csub28si.setArchInputStruct(input);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return csub28si;
  }

  /**
   * Populates the input object for the PPT Information retrieve service (CSUB29S).
   *
   * @param eventId The id of the PPT event.
   */
  private CSUB29SI populateCSUB29SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB29SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);
    String strTaskPullBack = (String) state.getAttribute(PPT_CONTACT_STDS_TASK_PULLBACK, request);

    Integer eventId = GlobalData.getUlIdEvent(request);
    CSUB29SI csub29si = new CSUB29SI();
    csub29si.setUlIdEvent(eventId);

    if (ArchitectureConstants.TRUE.equals(strTaskPullBack)) {
      int actionEventId = ContextHelper.getIntSafe(request, "actionEventId");
      csub29si.setUlIdContactStdsEvent(actionEventId);
    }
    
    state.removeAttribute(PPT_CONTACT_STDS_TASK_PULLBACK, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return csub29si;
  }

  /**
   * Populates the input object for the PPT Information save service (CSUB50S).
   *
   * @param context The GrndsExchangeContext object.
   */
  private CSUB50SI populateCSUB50SI_Save(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB50SI_Save()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    ArchInputStruct input = new ArchInputStruct();

    CSUB29SO pptFromState = (CSUB29SO) state.getAttribute("CSUB29SO", request);
    
    //SIR 18297 - Changed to use user Logon ID instead of User ID.
    input.setSzUserId(user.getUserLogonID());

    CSUB50SI csub50si = new CSUB50SI();
    AdminAddressPhoneBean aapBean =
            (AdminAddressPhoneBean) AdminAddressPhoneBean.getFromRequest(request);

    csub50si.setUlIdStage(GlobalData.getUlIdStage(request));

    CSUB50SIG00 csub50sig00 = new CSUB50SIG00();
    csub50sig00.setLNbrPptPhoneExt(aapBean.getPhoneExt());
    csub50sig00.setSzAddrPptCity(aapBean.getCity());
    csub50sig00.setSzAddrPptCnty(aapBean.getCounty());
    csub50sig00.setSzAddrPptState(aapBean.getState());
    csub50sig00.setSzAddrPptStLn1(aapBean.getAddress1());
    csub50sig00.setSzAddrPptStLn2(aapBean.getAddress2());
    csub50sig00.setSzAddrPptZip(aapBean.getZipAndSuff());
    csub50sig00.setSzNbrPptPhone(aapBean.getPhone());
    csub50sig00.setSzTxtPptAddrCmnt(aapBean.getComments());

    if (request.getParameter(TXT_MEETING_DATE) != null &&
        !"".equals(request.getParameter(TXT_MEETING_DATE))) {
      csub50sig00.setDtDtPptDate(ContextHelper.getCastorDateSafe(request, TXT_MEETING_DATE));
    }
    if (request.getParameter(TXT_DOCUMENT_COMPLETED_DATE) != null &&
        !"".equals(request.getParameter(TXT_DOCUMENT_COMPLETED_DATE))) {
      csub50sig00.setDtDtPptDocComp(ContextHelper.getCastorDateSafe(request, TXT_DOCUMENT_COMPLETED_DATE));
    }
    if (request.getParameter(TXT_MEETING_TIME) != null &&
        !"".equals(request.getParameter(TXT_MEETING_TIME))) {
      csub50sig00.setTmScrTmPptTime(ContextHelper.getTimeSafe(request, TXT_MEETING_TIME));
    }
    if (request.getParameter(TXT_MEETING_TYPE) != null &&
        !"".equals(request.getParameter(TXT_MEETING_TYPE))) {
      csub50sig00.setSzMeetingType(ContextHelper.getString(request, TXT_MEETING_TYPE));
    }    
    if (request.getParameter(IND_ASSIST_NEEDED) != null &&
        !"".equals(request.getParameter(IND_ASSIST_NEEDED))) {
      csub50sig00.setBIndAssistNeeded(CheckboxHelper.getCheckboxValue(request, IND_ASSIST_NEEDED));
    } 
    if (request.getParameter(DATE_HEARING_REQ) != null &&
        !"".equals(request.getParameter(DATE_HEARING_REQ))) {
      csub50sig00.setDtDateHearingReq(ContextHelper.getCastorDateSafe(request, DATE_HEARING_REQ));
    } 
    if (request.getParameter(DATE_OUTCOME_DISCUSSED) != null &&
        !"".equals(request.getParameter(DATE_OUTCOME_DISCUSSED))) {
      csub50sig00.setDtOutcomeDiscussed(ContextHelper.getCastorDateSafe(request, DATE_OUTCOME_DISCUSSED));
    } 
    if (request.getParameter(DATE_UTIL_BEGIN) != null &&
       !"".equals(request.getParameter(DATE_UTIL_BEGIN))) {
      csub50sig00.setDtUtilBeginDate(ContextHelper.getCastorDateSafe(request, DATE_UTIL_BEGIN));
    } 
    if (request.getParameter(DATE_UTIL_END) != null &&
       !"".equals(request.getParameter(DATE_UTIL_END))) {
      csub50sig00.setDtUtilEndDate(ContextHelper.getCastorDateSafe(request, DATE_UTIL_END));
    } 
    if (request.getParameter(DATE_PREP_INTVW) != null &&
       !"".equals(request.getParameter(DATE_PREP_INTVW))) {
      csub50sig00.setDtDatePrepIntvw(ContextHelper.getCastorDateSafe(request, DATE_PREP_INTVW));
    } 
    if (request.getParameter(DATE_PERM_REP_COM) != null &&
       !"".equals(request.getParameter(DATE_PERM_REP_COM))) {
      csub50sig00.setDtPermRepComp(ContextHelper.getCastorDateSafe(request, DATE_PERM_REP_COM));
    } 
    
    if (request.getParameter(IND_PERMANENCY) != null &&
       !"".equals(request.getParameter(IND_PERMANENCY))) {
      csub50sig00.setBIndPermanency(CheckboxHelper.getCheckboxValue(request, IND_PERMANENCY));
    }
    if (request.getParameter(IND_PRE_REQ_MET) != null &&
        !"".equals(request.getParameter(IND_PRE_REQ_MET))) {
      csub50sig00.setBIndPrevReqMet(CheckboxHelper.getCheckboxValue(request, IND_PRE_REQ_MET));
    }  
    if (request.getParameter(IND_WELLBEING) != null &&
       !"".equals(request.getParameter(IND_WELLBEING))) {
      csub50sig00.setBIndWellbeing(CheckboxHelper.getCheckboxValue(request, IND_WELLBEING));
    } 
    if (request.getParameter(IND_SAFETY) != null &&
       !"".equals(request.getParameter(IND_SAFETY))) {
      csub50sig00.setBIndSafety(CheckboxHelper.getCheckboxValue(request, IND_SAFETY));
    } 
    csub50sig00.setIndTranPlanComp(CheckboxHelper.getCheckboxValue(request, IND_TRAN_PLAN));
    
    ROWCCMN01UIG00 rowccmn01uigoo = new ROWCCMN01UIG00();
    rowccmn01uigoo.setSzCdEventType(CodesTables.CEVNTTYP_PPT);
    // SIR 3913 : if stage is SUB GD will have 3180 else if its ADO it will have 8680
    String PPT_TASK_CODE = GlobalData.getSzCdTask(request);
    rowccmn01uigoo.setSzCdTask(PPT_TASK_CODE);
    rowccmn01uigoo.setUlIdPerson(user.getUserID());
    rowccmn01uigoo.setUlIdStage(GlobalData.getUlIdStage(request));
    csub50si.setUlIdCase(GlobalData.getUlIdCase(request));
    // SIR 19702 - Description should be PPT_EVENT_DESC + DtDtPpt, same as CAPS.
    //rowccmn01uigoo.setSzTxtEventDescr(PPT_EVENT_DESC + " " + FormattingHelper.formatDate(csub50sig00.getDtDtPptDate()));
    
    // GA SHINES - Description should be based off Team Meeting Type
    String desc = Lookup.simpleDecodeSafe(CodesTables.CMEETTYP, csub50sig00.getSzMeetingType());
    rowccmn01uigoo.setSzTxtEventDescr(desc);

    // 1) User clicked the 'Add' button on the Event List to create a new PPT
    //    event and is saving new PPT data to the database, or
    // 2) User accessed an existing PPT event (created automatically by the
    //    system), and is saving new PPT data to the database, or
    // 3) User is modifying an existing PPT event and PPT data.
    CSUB29SO csub29so = (CSUB29SO) state.getAttribute("CSUB29SO", request);
    
    int ulIdPptEvent = 0;
    int ulIdContactStdsEvent = 0;
    if (csub29so != null){
      CSUB29SOG00 csub29sog00 = null;
      if(csub29so.getCSUB29SOG00() != null){
        csub29sog00 = csub29so.getCSUB29SOG00();
        ulIdPptEvent = csub29sog00.getUlIdPptEvent();
        // MR-62 Added contact standards ID
        ulIdContactStdsEvent = csub29sog00.getUlIdContactStdsEvent();
        csub50sig00.setUlIdContactStdsEvent(ulIdContactStdsEvent);
      }
    }
    
    // SPB SIR 18487 - Since this should only happen when the Add button is clicked,
    // changed if condition below to do just that as opposed to check for new mode
    if ((request.getParameter("btnAdd.x") != null) ||
        (csub29so == null)) {
      ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
      ROWCCMN01UIG01 rowccmn01uig01_0 = new ROWCCMN01UIG01();
      rowccmn01uig01_0.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01_0);
      rowccmn01uigoo.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else if (csub29so != null && ulIdPptEvent == 0) {
      rowccmn01uigoo.setUlIdEvent(GlobalData.getUlIdEvent(request));
      rowccmn01uigoo.setTsLastUpdate(csub29so.getROWCSUB29SOG01().getTsLastUpdate());
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      csub50sig00.setTsLastUpdate(csub29so.getCSUB29SOG00().getTsLastUpdate());
      csub50sig00.setUlIdPptEvent(csub29so.getCSUB29SOG00().getUlIdPptEvent());
      rowccmn01uigoo.setUlIdEvent(GlobalData.getUlIdEvent(request));
      rowccmn01uigoo.setTsLastUpdate(csub29so.getROWCSUB29SOG01().getTsLastUpdate());
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }

    csub50si.setCSysIndDtPptCompFlld(ArchitectureConstants.N);
    
    if (!GlobalData.isApprovalMode(request)) {
      rowccmn01uigoo.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
    } else {
      rowccmn01uigoo.setSzCdEventStatus(pptFromState.getROWCSUB29SOG01().getSzCdEventStatus());
    }

    SzCdEventStatus_ARRAY eventArray = new SzCdEventStatus_ARRAY();
    if (csub29so != null) {
      eventArray.addSzCdEventStatus(CURRENT, csub29so.getROWCSUB29SOG01().getSzCdEventStatus());
    } else {
      eventArray.addSzCdEventStatus(CURRENT, "");
    }
    eventArray.addSzCdEventStatus(NEXT, rowccmn01uigoo.getSzCdEventStatus());
    csub50si.setSzCdEventStatus_ARRAY(eventArray);

    csub50si.setUlIdPerson(0);

    csub50si.setROWCCMN01UIG00(rowccmn01uigoo);
    csub50si.setCSUB50SIG00(csub50sig00);
    csub50si.setArchInputStruct(input);
    csub50si.getCSUB50SIG00().setSzCdStage(GlobalData.getSzCdStage(request));
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return csub50si;
  }
  
  private CCMN05UI populateCCMN05UI_InvalidateApproval(int idEvent) {

    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct input = new ArchInputStruct();

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setUlSysNbrReserved1(ArchitectureConstants.N);

    ccmn05ui.setUlIdEvent(idEvent);
    ccmn05ui.setArchInputStruct(input);

    return ccmn05ui;
  }
  
  private String determineContactStandardsCdTask(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    String cdStage = GlobalData.getSzCdStage(request);
    return (String) CNTCT_STDS_STAGES.get(cdStage);
  }
  
  /**
   * Helper method that handles all the WTC Exceptions.
   *
   * @param we      The WtcException that occurred.
   * @param context The GrndeExchangeContext object.
   */
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    String errorMessage = null;
    switch (we.getErrorCode()) {
      case Messages.MSG_CMN_OVERLAP_ADD:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_OVERLAP_ADD);
        setErrorMessage(errorMessage, PPT_INFORMATION_PAGE, request);
        break;
      case Messages.MSG_CMN_ON_CALL_TOO_MANY:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_ON_CALL_TOO_MANY);
        setErrorMessage(errorMessage, PPT_INFORMATION_PAGE, request);
        break;
      case Messages.MSG_SYS_STAGE_CLOSED:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
        setErrorMessage(errorMessage, PPT_INFORMATION_PAGE, request);
        break;
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
        setErrorMessage(errorMessage, PPT_INFORMATION_PAGE, request);
        break;
      case Messages.MSG_DATABASE_SAVE_FAIL:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_SAVE_FAIL);
        setErrorMessage(errorMessage, PPT_INFORMATION_PAGE, request);
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        setErrorMessage(errorMessage, PPT_INFORMATION_PAGE, request);
        break;
      case Messages.MSG_SYS_MULT_INST:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
        setErrorMessage(errorMessage, PPT_INFORMATION_PAGE, request);
        break;
      case Messages.MSG_DATABASE_RETRIEVE_FAIL:
        errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
        setErrorMessage(errorMessage, PPT_INFORMATION_PAGE, request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }
}