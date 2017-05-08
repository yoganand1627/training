package gov.georgia.dhr.dfcs.sacwis.web.admin;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.document.NewUsingDocumentValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.document.DocumentSave;
import gov.georgia.dhr.dfcs.sacwis.service.reports.Reports;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDNFRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDNFSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB59SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB60SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDNFRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDNFSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB59SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB60SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB59SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenMapping;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.DocumentRecordHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord_Array;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to launch narratives and forms that are not associated with any particular page
 * in the IMPACT application. <p/>
 * 
 * <pre>
 *   Change History:
 *   Date        User      Description
 *   ----------  --------  --------------------------------------------------
 *   05/10/2003    KRD     SIR 17233 - Code changes applied to support
 *                         &quot;Approver Mode&quot; providing supervisors the ability to
 *                         modify data without invalidating the pending
 *                         approval.  Required changes to
 *                         populateCSUB60SI_Add() and populateCSUB60SI_Update().
 *   06/06/03    GRIMSHAN  SIR 16979 get page mode from event search conversation
 *   11/21/03    dejuanr   SIR 22455 - csub06-&gt;eventStatus should be the current event status.
 *                         This was causing the approval not gettgin invalidated.
 *   07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 *   10/26/2006 aodutayo   Begining of release 2 for SHINES. Adding set method to inject dependency.
 *   07/24/2008  ssubram   STGAP00009509: Child life History check list code has been added
 *   02/20/2010  arege     STGAP00015749: CAPTA changes CD/NF/SI Report launch
 *   03/05/2010  cwells    CAPTA: Fixing Copy functionality for CD/NF/SI 
 *   03/15/2010  arege     SMS#47654 CAPTA - CDNFSI Form - User Navigated to Person List Page when copying CNS events in INT, INV or ONG stages
 *   03/15/2010  cwells    SMS#47654 CAPTA - CDNFSI Form - Fixed logic for coping the form. 
 *   03/23/2010  arege     SMS#48528 Added code to allow users to delete CD/NF/SI events when in PROC or COMP status
 *   03/25/2/010 arege     SMS#48851 Save should allow the user to stay on the page and launch the form.
 *   05/24/2010  arege     SMS#54782 Added radio buttons to capture report type.
 *   09/09/2011  cwells    STGAP00017068: ECEM 5.0 Permanency Rourndtable inital development
 *   10/05/2011  pnguyen   MR-094: Visitation Type
 *   11/15/2011  hnguyen   STGAP00017580: Only allow edit for permanency roundtable that user has stage access to, 
 *                         however, if this is a copy then leave page mode as is.
 * </pre>
 * 
 * @author J Heather Dean, October 11, 2002
 */
public class OutputLaunchConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "OutputLaunchConversation";

  public static final String ENGLISH = "english";

  public static final String SPANISH = "spanish";

  public static final String DOCEXISTS = "docExists";

  // Risk Assessment
  public static final String RISK_ASMT_EVENT_DESC = "Risk Assessment Narrative";

  // Safety Roundtable

  public static final String CREATED_SAFETY_EVENT_DESCRIPTION = "Safety Roundtable has been created.";

  public static final String COPIED_ROUNDTABLE_EVENT = "COPIED_ROUNDTABLE_EVENT";

  // Permanency Roundtable
  public static final String CREATED_PERM_EVENT_DESCRIPTION = "Permanency Roundtable has been created.";

  public static final String RISK_ASMT_HEADER = "Risk Assessment";

  public static final String RISK_ASMT_EVENT_TYPE = "ASM";

  public static final String PERM_ROUNDTABLE_EVENT_TYPE = CodesTables.CEVNTTYP_PER;

  public static final String SAFETY_ROUNDTABLE_EVENT_TYPE = CodesTables.CEVNTTYP_SRT;

  public static final String MED_DEV_EVENT_TYPE = "MDH";

  public static final String RISK_ASMT_DOC_TYPE = "SUMREC";

  public static final String PERM_ROUNDTABLE_DOC_TYPE = CodesTables.CEVNTDOC_PER;

  public static final String SAFETY_ROUNDTABLE_DOC_TYPE = CodesTables.CEVNTDOC_SRT;

  // Visitation Plan
  public static final String VISIT_PLAN_HEADER = "Visitation Plan";

  public static final String SPAN_VISIT_EVENT_TYPE = "VIP";

  public static final String ENG_VISIT_EVENT_TYPE = "VIS";

  // Codes table lookups
  public static final String CODE_TABLE_EVENT_DOC = CodesTables.CEVNTDOC;

  public static final String CODE_TABLE_EVENT_TYPE = CodesTables.CEVNTTYP;

  public static final String CODE_TABLE_EVENT_APPROVE = CodesTables.CEVNTAPV;

  public static final String CODE_TABLE_VISIT = CodesTables.CVSTNTYP;

  // Event Status
  public static final String EVENT_STATUS_PROC = CodesTables.CEVTSTAT_PROC;

  public static final String EVENT_STATUS_COMP = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_STATUS_APRV = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;

  public static final String EVENT_STATUS_REJT = "REJT";

  public static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;

  private static final String DISPLAY_OUPUT_LAUNCH_URL = "/admin/OutputLaunch/displayInitOutputLaunch";

  private DocumentSave documentSave;

  private Reports reports;

  private static final List<String> CD_NF_SI_TASK_CODES = new ArrayList<String>() {
    {
      add("6110"); // -- Child Death/Near Fatality / Serious Injury task code in INT
      add("6220"); // -- Child Death/Near Fatality / Serious Injury task code in INV
      add("6330"); // -- Child Death/Near Fatality / Serious Injury task code in FPR
      add("6440"); // -- Child Death/Near Fatality / Serious Injury task code in SUB
      add("6550"); // -- Child Death/Near Fatality / Serious Injury task code in ADO
      add("6660"); // -- Child Death/Near Fatality / Serious Injury task code in PFC
    }
  };

  public static final String CD_NF_SI_EVENT_TYPE = "CNS";

  public void setDocumentSave(DocumentSave documentSave) {
    this.documentSave = documentSave;
  }

  /**
   * sets the value of the parent object
   * 
   * @param reports
   */
  public void setReports(Reports reports) {
    this.reports = reports;
  }

  /**
   * This method is called by outside conversations when INITIALLY displaying the Output Launch page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayInitOutputLaunch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayInitOutputLaunch_xa");

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      // SIR 16979 get the page mode from event search conversation
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      state.removeAllAttributes(request);
      PageMode.setPageMode(pageMode, request);

      // no call to display output launch was in initial document.
      // as a result a blank page was loaded.
      // displayOutputLaunch(context);
    } catch (Exception e) {
      handleException(e, context, "displayInitOutputLaunch_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when displaying the Output Launch page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayOutputLaunch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayOutputLaunch_xa");

    try {
      displayOutputLaunch(context);
    } catch (Exception e) {
      handleException(e, context, "displayOutputLaunch_xa");
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is called by the activity methods when displaying the Output Launch page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void displayOutputLaunch(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayOutputLaunch");

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      String pageMode = PageMode.getPageMode(request);
      String nEvent = null;
      String taskCD = GlobalData.getSzCdTask(request);
      if (!CD_NF_SI_TASK_CODES.contains(taskCD)) { // if event type not CNS
        request = context.getRequest();
        // STGAP00017068: Setting variable to the request for the new using event(Copied from).
        if (PageModeConstants.NEW_USING.equals(pageMode)) {
          nEvent = GlobalData.getUlIdEventAsString(request);
        }
        if (nEvent != null) {
          request.setAttribute("nEvent", nEvent);
        }
        CSUB59SI csub59si = populateCSUB59SI_Retrieve(context);
        CSUB59SO csub59so = reports.retrieveOutputLaunch(csub59si);
        pageMode = PageMode.getPageMode(request);
        // 19831, if document exists and pageMode is NEW;
        // treat pageMode as EDIT
        if ((pageMode.equals(PageModeConstants.NEW)) && (csub59so.getTsLastUpdate() != null)) {
          PageMode.setPageMode(PageModeConstants.EDIT, request);
        }

        request.setAttribute("CSUB59SO", csub59so);

        ROWCSUB59SOG00 outputRow = csub59so.getROWCSUB59SOG00();

        String eventType = outputRow.getSzCdEventType();
        if (ENG_VISIT_EVENT_TYPE.equals(eventType) || SPAN_VISIT_EVENT_TYPE.equals(eventType)) {
          Screen screen = ScreenMapping.getScreenData(context);
          screen.setParameter("HtmlTitle", "Visitation Plan", true);
        } else if (CodesTables.CEVNTTYP_CCK.equals(eventType)) {
          Screen screen = ScreenMapping.getScreenData(context);
          screen.setParameter("HtmlTitle", "Child Life History Checklist", true);
        } else if (PERM_ROUNDTABLE_EVENT_TYPE.equals(eventType)) {
          Screen screen = ScreenMapping.getScreenData(context);
          screen.setParameter("HtmlTitle", "Permanency Roundtable", true);
        } else if (SAFETY_ROUNDTABLE_EVENT_TYPE.equals(eventType)) {
          Screen screen = ScreenMapping.getScreenData(context);
          screen.setParameter("HtmlTitle", "Safety Roundtable", true);
        } else {
          Screen screen = ScreenMapping.getScreenData(context);
          screen.setParameter("HtmlTitle", "Output Launch", true);
        }
        String docType;
        if (eventType.equals(RISK_ASMT_EVENT_TYPE)) {
          // set doc type to 'SUMREC'
          docType = RISK_ASMT_DOC_TYPE;
        } else if (eventType.equals(PERM_ROUNDTABLE_EVENT_TYPE)) {
          docType = PERM_ROUNDTABLE_DOC_TYPE;
          /* STGAP00017580: Only allow edit for permanency roundtable that user has stage access to, however,
           * if this is a copy then leave page mode as is.
          */ 
          if(!CaseUtility.hasStageAccess(getUserProfile(request).getUserID(), GlobalData.getUlIdStage(request))
                          && !PageModeConstants.NEW_USING.equals(pageMode)){
            PageMode.setPageMode(PageModeConstants.VIEW, request);
          }
        } else if (eventType.equals(SAFETY_ROUNDTABLE_EVENT_TYPE)) {
          docType = SAFETY_ROUNDTABLE_DOC_TYPE;
        }

        docType = Lookup.simpleDecodeSafe(CODE_TABLE_EVENT_DOC, eventType);
        // STGAP00017068: Checking to see if the form exists. csub59so.getTsLastUpdate() is
        // also the variable for the Date last updated field on the page.
        if (csub59so.getTsLastUpdate() != null) {
          request.setAttribute(DOCEXISTS, ArchitectureConstants.TRUE);
        } else {
          request.setAttribute(DOCEXISTS, ArchitectureConstants.FALSE);
        }

        request.setAttribute("docType", docType);

        // SIR 19239 - After looking up info for event selected on list, if
        // New Using, clear info and redo csub59 call to populate with new
        // row info. Must be done after initial call to make sure docType
        // gets set correctly.
        if (pageMode.equals(PageModeConstants.NEW_USING)) {
          // get the 'newUse' eventID and caseID
          int newUseEventID = GlobalData.getUlIdEvent(request);
          request.setAttribute("newUseEventID", String.valueOf(newUseEventID));

          int newUseCaseID = GlobalData.getUlIdCase(request);
          request.setAttribute("newUseCaseID", String.valueOf(newUseCaseID));

          // Clear out event ID from global data
          GlobalData.setUlIdEvent(0, request);

          csub59so.getROWCSUB59SOG00().setSzCdEventType(eventType);

          // STGAP00017068: When coping the event and form the
          // Date of the last updated field on the should be set to todays date
          // which will also set the RT Date on the form
          if (PERM_ROUNDTABLE_EVENT_TYPE.equals(eventType) || (SAFETY_ROUNDTABLE_EVENT_TYPE.equals(eventType))) {
            Date currentDate = new Date();
            csub59so.setTsLastUpdate(currentDate);
          }

          if (ENG_VISIT_EVENT_TYPE.equals(eventType)) {
            csub59so.getROWCSUB59SOG00().setCIndCurrent("N");
            csub59so.setTsLastUpdate(null);
            csub59so.getROWCSUB59SOG00().setSzCdEventStatus(EVENT_STATUS_PROC);
            request.setAttribute(DOCEXISTS, ArchitectureConstants.TRUE);

          }
          request.setAttribute("CSUB59SO", csub59so);
        }
        
        String eventStatus = csub59so.getROWCSUB59SOG00().getSzCdEventStatus();
        if (ENG_VISIT_EVENT_TYPE.equals(eventType)&& (!pageMode.equals(PageModeConstants.NEW_USING))) {
          if (EVENT_STATUS_PROC.equals(eventStatus) && (!checkDocExists(context, reports))) {
            csub59so.setTsLastUpdate(null);
          }
          if (EVENT_STATUS_PROC.equals(eventStatus) && (checkDocExists(context, reports))) {
            csub59so.setTsLastUpdate(csub59so.getTsLastUpdate());
          }
          if (!EVENT_STATUS_PROC.equals(eventStatus)) {
            csub59so.setTsLastUpdate(outputRow.getTsLastUpdate());
          }
          if (EVENT_STATUS_PROC.equals(eventStatus) && (checkDocExists(context, reports))
              && (DateHelper.isBeforeToday(csub59so.getTsLastUpdate()))) {
            csub59so.setTsLastUpdate(outputRow.getTsLastUpdate());
          }
        }
        
        
        int caseID = csub59so.getUlIdCase();
        GlobalData.setUlIdCase(caseID, request);

        // encapsulating the block of code in an if statement.
        // when trying to add a new <Event-Output Launch> Type
        // no status would be associated with the type
        if (outputRow.getSzCdEventStatus() != null) {
          // SIR 17676 Only dispaly the invalidate approval messages if the page is not in approval mode
          if (outputRow.getSzCdEventStatus().equals(EVENT_STATUS_PEND) && !GlobalData.isApprovalMode(request)) {
            setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);

            setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
          }
        }
      } else {
        displayCDNFSIOutputLaunch(context);
      }
    }
    catch (Exception e) {
      handleException(e, context, "displayOutputLaunch");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when displaying an Output Launch document.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayDocument_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayDocument_xa");
    HttpServletRequest request = context.getRequest();
    String pageMode = PageMode.getPageMode(request);
    String launchType = ContextHelper.getStringSafe(context, "docType");
    // String taskCD = GlobalData.getSzCdTask(request);
    String eventType = ContextHelper.getStringSafe(context, "eventType");
    // Check if language switch has occurred, and overwrite appropriate variables
    String switchLanguage = ContextHelper.getStringSafe(context, "switchLanguage");
    if (switchLanguage.equals(SPANISH)) {
      launchType = Lookup.simpleDecodeSafe(CODE_TABLE_EVENT_DOC, SPAN_VISIT_EVENT_TYPE);
      eventType = SPAN_VISIT_EVENT_TYPE;
      // taskCD = EventSearchConversation.getSpanishVisitationTaskCode(taskCD);
    } else if (switchLanguage.equals(ENGLISH)) {
      launchType = Lookup.simpleDecodeSafe(CODE_TABLE_EVENT_DOC, ENG_VISIT_EVENT_TYPE);
      eventType = ENG_VISIT_EVENT_TYPE;
      // taskCD = EventSearchConversation.getEnglishVisitationTaskCode(taskCD);
    }

    String eventDescription = eventType.equals(RISK_ASMT_EVENT_TYPE) ? RISK_ASMT_EVENT_DESC
            : Lookup
                    .simpleDecodeSafe(
                                      CODE_TABLE_EVENT_TYPE,
                                                                                              eventType);

    // Set the launch type to show the document upon reload
    request.setAttribute("launchType", launchType);
    try {
      if ((pageMode.equals(PageModeConstants.NEW_USING))
          || ((pageMode.equals(PageModeConstants.NEW)) && (GlobalData.getUlIdEvent(request) == 0))) {
        // first, get text for event description - simply the document name

        CSUB60SI csub60si = populateCSUB60SI_Add(context, eventType, eventDescription);

        // CSUB60SO csub60so = (CSUB60SO) WtcHelper.callService("CSUB60S", csub60si, CSUB60SO.class);
        // CAPTA change
        BaseSessionStateManager state = getSessionStateManager(context);
        PersonListPullBackInfo info = (PersonListPullBackInfo) state.getAttribute(
                                                                                  PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, request);
        if (info != null) {
          csub60si.setUlIdVictim(info.getPersonListRow().getUlIdPerson());
        }
        // and the person id is zero
        else {
          csub60si.setUlIdVictim(0);
        }

        CSUB60SO csub60so = saveOutputLaunch(context, reports);

        int eventID = csub60so.getUlIdEvent();
        GlobalData.setUlIdEvent(eventID, request);
        // STGAP00017068: Setting Variables for the newly created event
        request.setAttribute("sEvent", String.valueOf(eventID));
        request.setAttribute("pCase", GlobalData.getUlIdCaseAsString(request));
        request.setAttribute("pEvent", String.valueOf(eventID));
      }
      // moved down here because above if had another condition on eventId
      if ((pageMode.equals(PageModeConstants.NEW_USING)) || (pageMode.equals(PageModeConstants.NEW))) {
        PageMode.setPageMode(PageModeConstants.EDIT, request);
      }
    } catch (Exception e) {
      handleException(e, context, "displayDocument_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when saving an Output Launch document.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  // CAPTA: Modified method to process CDNFSI events
  public void saveOutputLaunch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "saveOutputLaunch_xa");
    try {
      HttpServletRequest request = context.getRequest();
      if (CD_NF_SI_TASK_CODES.contains(GlobalData.getSzCdTask(request))) {
        saveCDNFOutputLaunch(context, reports);
      } else {
        saveOutputLaunch(context, reports);
      }
    } catch (Exception e) {
      handleException(e, context, "saveOutputLaunch_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when submitting an OutputLaunch event for approval.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  // CAPTA: Modified method to process CDNFSI events
  public void saveSubmitOutputLaunch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "saveSubmitOutputLaunch_xa");
    try {
      // first, save the page
      HttpServletRequest request = context.getRequest();
      CSUB60SO csub60so = new CSUB60SO();
      if (CD_NF_SI_TASK_CODES.contains(GlobalData.getSzCdTask(request))) {
        CDNFSaveSO cdnfSaveSO = saveSubmitCDNFOutputLaunch(context, reports);
        csub60so = cdnfSaveSO.getCsub60so();
      } else {
        csub60so = saveSubmitOutputLaunch(context, reports);
      }
      // look up approval event task code
      String eventType = ContextHelper.getStringSafe(request, "eventType");
      String approvalTaskCD = Lookup.simpleDecodeSafe(CODE_TABLE_EVENT_APPROVE, eventType);
      // Set data for ToDo Detail page
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(csub60so.getUlIdEvent(), GlobalData.getUlIdCase(request),
                                                   GlobalData.getUlIdStage(request), approvalTaskCD);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, getSessionStateManager(context));
    } catch (Exception e) {
      handleException(e, context, "saveSubmitOutputLaunch_xa");
    }
    performanceTrace.exitScope();
  }

  protected CSUB60SO saveOutputLaunch(GrndsExchangeContext context, Reports reports) {
    String outputComplete = ContextHelper.getStringSafe(context, "cbOutputComp");
    if (StringHelper.isTrue(outputComplete)) {
      if (!checkDocExists(context, reports)) {
        throw new ServiceException(Messages.MSG_COMP_NOT_SAVED);
      }
    }
    CSUB60SI csub60si = populateCSUB60SI_Update(context, reports);
    CSUB60SO csub60so = reports.saveOutputLaunch(csub60si);
    GlobalData.setUlIdEvent(csub60so.getUlIdEvent(), context.getRequest());

    // STGAP00017068: ECEM 5.0 Fixing Form copy logic
    int eventId = csub60so.getUlIdEvent();
    String cdEventType = csub60si.getROWCCMN01UIG00().getSzCdEventType();
    HttpServletRequest request = context.getRequest();
    boolean newUsing = PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING);
    // if new using, create a new document record, save it and get the timestamp
    if (newUsing) {
      try {
        request.setAttribute("pEvent", String.valueOf(eventId));
        request.setAttribute("sEvent", String.valueOf(eventId));
        request.setAttribute("sCase", GlobalData.getUlIdCaseAsString(request));
        request.setAttribute("pCase", GlobalData.getUlIdCaseAsString(request));
        request.setAttribute(DOCEXISTS, ArchitectureConstants.FALSE);
        String eventType = csub60si.getROWCCMN01UIG00().getSzCdEventType();

        GrndsTrace.msg(TRACE_TAG, 7, "Value of nEvent:" + request.getParameter("nEvent"));
        GrndsTrace.msg(TRACE_TAG, 7, "Value of nCase:" + request.getParameter("nCase"));
        GrndsTrace.msg(TRACE_TAG, 7, "Value of sEvent:" + request.getAttribute("sEvent"));
        GrndsTrace.msg(TRACE_TAG, 7, "Value of pEvent:" + request.getAttribute("pEvent"));
        GrndsTrace.msg(TRACE_TAG, 7, "Value of sCase:" + request.getAttribute("sCase"));
        GrndsTrace.msg(TRACE_TAG, 7, "Value of pCase:" + request.getAttribute("pCase"));

        String docType = Lookup.simpleDecodeSafe(CODE_TABLE_EVENT_DOC, eventType);
        request.setAttribute("docType", docType);

        NewUsingDocumentValueBean newUsingDocumentValueBean = DocumentRecordHelper.newUseDocumentRecord(documentSave,
                                                                                                        request);
        DocumentRecordHelper.saveNewUseDocumentRecord(documentSave, request, newUsingDocumentValueBean);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, ">>>> Error copying narrative for idEvent " + request.getParameter("nEvent")
                                     + ": " + e.getMessage());
        // processSevereException(context, e);
      }
    }
    String eventStatus = ContextHelper.getStringSafe(context, "eventStatus");
    String pageMode = PageModeConstants.VIEW;
    if (!CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
      pageMode = PageModeConstants.EDIT;
      PageMode.setPageMode(pageMode, request);
    }

    return csub60so;
  }

  // STGAP00015749 CAPTA: Added method to Save CDNFSI events
  protected CDNFSaveSO saveCDNFOutputLaunch(GrndsExchangeContext context, Reports reports) {
    String outputComplete = ContextHelper.getStringSafe(context, "cbOutputComp");
    if (StringHelper.isTrue(outputComplete)) {
      if (!checkDocExists(context, reports)) {
        throw new ServiceException(Messages.MSG_COMP_NOT_SAVED);
      }
    }
    CDNFSaveSO cdnfSaveSO = new CDNFSaveSO();
    CDNFSaveSI cdnfSaveSI = new CDNFSaveSI();
    CSUB60SI csub60si = populateCSUB60SI_Update(context, reports);
    cdnfSaveSI = populateCDNFSaveSI(context, csub60si);
    cdnfSaveSI.setCsub60si(csub60si);
    cdnfSaveSO = reports.saveOutputLaunch(cdnfSaveSI);
    int eventId = cdnfSaveSO.getIdEvent();

    HttpServletRequest request = context.getRequest();
    GlobalData.setUlIdEvent(cdnfSaveSO.getIdEvent(), request);
    String cdEventStatus = cdnfSaveSO.getCdEventStatus();
    boolean newUsing = PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING);
    String pageMode = PageModeConstants.VIEW;

    // if new using, create a new document record, save it and get the timestamp
    if (newUsing) {
      GrndsTrace.msg(TRACE_TAG, 7, "Value of nEvent:" + request.getParameter("nEvent"));
      GrndsTrace.msg(TRACE_TAG, 7, "Value of nCase:" + request.getParameter("nCase"));
      GrndsTrace.msg(TRACE_TAG, 7, "Value of pEvent:" + request.getAttribute("pEvent"));
      GrndsTrace.msg(TRACE_TAG, 7, "Value of pCase:" + request.getAttribute("pCase"));
      try {
        request.setAttribute("pEvent", String.valueOf(eventId));
        request.setAttribute("pCase", GlobalData.getUlIdCaseAsString(request));
        String eventType = csub60si.getROWCCMN01UIG00().getSzCdEventType();

        String docType = Lookup.simpleDecodeSafe(CODE_TABLE_EVENT_DOC, eventType);
        request.setAttribute("docType", docType);

        NewUsingDocumentValueBean newUsingDocumentValueBean = DocumentRecordHelper.newUseDocumentRecord(documentSave,
                                                                                                        request);
        DocumentRecordHelper.saveNewUseDocumentRecord(documentSave, request, newUsingDocumentValueBean);
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 7, ">>>> Error copying narrative for idEvent " + request.getParameter("nEvent")
                                     + ": " + e.getMessage());
        // processSevereException(context, e);
      }
    }
    if (!CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)) {
      pageMode = PageModeConstants.EDIT;
      PageMode.setPageMode(pageMode, request);
    }
    return cdnfSaveSO;
  }

  protected static CSUB60SO saveSubmitOutputLaunch(GrndsExchangeContext context, Reports reports) {
    String outputComplete = ContextHelper.getStringSafe(context, "cbOutputComp");
    if (StringHelper.isTrue(outputComplete)) {
      if (!checkDocExists(context, reports)) {
        throw new ServiceException(Messages.MSG_COMP_NOT_SAVED);
      }
    } else if (!checkDocExists(context, reports)) {
      throw new ServiceException(Messages.MSG_SUB_OUTPUT_NOT_COMP);
    }
    CSUB60SI csub60si = populateCSUB60SI_Update(context, reports);
    return reports.saveOutputLaunch(csub60si);
  }

  /**
   * 
   * 
   * @param context
   * @param reports
   * @return
   */
  // STGAP00015749 CAPTA: Added method to Save CDNFSI events
  protected static CDNFSaveSO saveSubmitCDNFOutputLaunch(GrndsExchangeContext context, Reports reports) {
    String outputComplete = ContextHelper.getStringSafe(context, "cbOutputComp");
    if (StringHelper.isTrue(outputComplete)) {
      if (!checkDocExists(context, reports)) {
        throw new ServiceException(Messages.MSG_COMP_NOT_SAVED);
      }
    } else if (!checkDocExists(context, reports)) {
      throw new ServiceException(Messages.MSG_SUB_OUTPUT_NOT_COMP);
    }
    CSUB60SI csub60si = populateCSUB60SI_Update(context, reports);
    CDNFSaveSI cdnfSaveSI = populateCDNFSaveSI(context, csub60si);
    cdnfSaveSI.setCsub60si(csub60si);
    return reports.saveOutputLaunch(cdnfSaveSI);
  }

  /**
   * This method is called by the Save and Save&Submit methods when output has been marked complete.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private static boolean checkDocExists(GrndsExchangeContext context, Reports reports) {
    CSUB59SI csub59si = populateCSUB59SI_Retrieve(context);
    // CSUB59SO csub59so = (CSUB59SO) WtcHelper.callService("CSUB59S", csub59si, CSUB59SO.class);
    CSUB59SO csub59so = reports.retrieveOutputLaunch(csub59si);

    return (csub59so.getTsLastUpdate() != null);
  }

  /**
   * This helper method is called by the displayOutputLaunch_xa to populate the input object for the csub59s retrieve
   * service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private static CSUB59SI populateCSUB59SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "populateCSUB59SI_Retrieve()");

    HttpServletRequest request = context.getRequest();

    CSUB59SI csub59si = new CSUB59SI();

    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);

    csub59si.setArchInputStruct(input);

    int eventID = GlobalData.getUlIdEvent(request);
    csub59si.setUlIdEvent(eventID);

    int stageID = GlobalData.getUlIdStage(request);
    csub59si.setUlIdStage(stageID);

    String taskCD = GlobalData.getSzCdTask(request);
    csub59si.setSzCdTask(taskCD);

    performanceTrace.exitScope();
    return csub59si;
  }

  /**
   * This helper method is called by the displayDocument_xa to populate the input object for the csub60s save service.
   * 
   * @param context
   *          The GrndeExchangeContext
   * @param eventType
   *          String, event type
   * @param eventDescription
   *          a string, event description
   */
  private static CSUB60SI populateCSUB60SI_Add(GrndsExchangeContext context, String eventType, String eventDescription) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "populateCSUB60SI_Add()");

    HttpServletRequest request = context.getRequest();

    // Get today's date for date event updated
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());

    ArchInputStruct input = new ArchInputStruct();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    CSUB60SI csub60si = new CSUB60SI();

    // call csub60 -- creates the event
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    input.setSzUserId(getUserLogonID(request));

    //
    // SIR 17233 - set the flag indicating approver mode
    //
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    rowccmn01uig00.setSzCdEventType(eventType);

    int stageID = GlobalData.getUlIdStage(request);
    rowccmn01uig00.setUlIdStage(stageID);

    rowccmn01uig00.setDtDtEventOccurred(today);

    String taskCD = GlobalData.getSzCdTask(request);
    rowccmn01uig00.setSzCdTask(taskCD);

    rowccmn01uig00.setUlIdPerson(getUserID(request));
    //
    // SIR 17233 - event status should remain PEND, if we're in Approver Mode
    //
    if (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
      rowccmn01uig00.setSzCdEventStatus(EVENT_STATUS_PEND);
    } else {
      rowccmn01uig00.setSzCdEventStatus(EVENT_STATUS_PROC);// !!!
    }

    rowccmn01uig00.setSzTxtEventDescr(eventDescription);

    csub60si.setArchInputStruct(input);
    csub60si.setSzCdStage(GlobalData.getSzCdStage(request));
    csub60si.setSzCdEventStatus(EVENT_STATUS_NEW);
    csub60si.setROWCCMN01UIG00(rowccmn01uig00);

    performanceTrace.exitScope();

    return csub60si;
  }

  /**
   * This helper method is called by the saveOutputLaunch_xa to populate the input object for the csub60s save service.
   * 
   * @param context
   *          The GrndeExchangeContext
   */
  private static CSUB60SI populateCSUB60SI_Update(GrndsExchangeContext context, Reports reports) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "populateCSUB60SI_Update()");

    HttpServletRequest request = context.getRequest();

    String eventType = ContextHelper.getStringSafe(context, "eventType");
    String eventDescription = StringHelper.EMPTY_STRING;
    if (!CodesTables.CEVNTTYP_CNS.equals(eventType)) {
      eventDescription = eventType.equals(RISK_ASMT_EVENT_TYPE) ? RISK_ASMT_EVENT_DESC
                                                             : Lookup
                                                                     .simpleDecodeSafe(CODE_TABLE_EVENT_TYPE, eventType);
    }

    // Permanency Roundtable events
    if (PERM_ROUNDTABLE_EVENT_TYPE.equals(eventType)) {
      eventDescription = CREATED_PERM_EVENT_DESCRIPTION;
    } else if (SAFETY_ROUNDTABLE_EVENT_TYPE.equals(eventType)) {
      eventDescription = CREATED_SAFETY_EVENT_DESCRIPTION;
    }

    // 18906
    String eventStatus = ContextHelper.getStringSafe(context, "eventStatus");
    if (("".equals(eventStatus)) || (EVENT_STATUS_NEW.equals(eventStatus))) {
      eventStatus = OutputLaunchConversation.EVENT_STATUS_PROC;
    }
    String outputComplete = ContextHelper.getStringSafe(context, "cbOutputComp");
    boolean btnCompleteIsPressed = ContextHelper.getString(request, "btnComplete.x") != null;
    if (btnCompleteIsPressed) {
      if (!checkDocExists(context, reports)) {
        throw new ServiceException(Messages.MSG_COMP_NOT_SAVED);
      }
    }
    if ((StringHelper.isTrue(outputComplete) || btnCompleteIsPressed) && !(EVENT_STATUS_APRV.equals(eventStatus))) {
      eventStatus = EVENT_STATUS_COMP;
    } else if (EVENT_STATUS_APRV.equals(eventStatus)) {
      eventStatus = EVENT_STATUS_APRV;
    }

    //
    // SIR 17233 - event status should remain PEND, if we're in Approver Mode
    //
    if (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
      eventStatus = EVENT_STATUS_PEND;
    }

    String funcCd = null;
    String pageMode = PageMode.getPageMode(request);
    if (pageMode.equals(PageModeConstants.CREATE)) {
      funcCd = ServiceConstants.REQ_FUNC_CD_ADD;
    } else if (pageMode.equals(PageModeConstants.EDIT)) {
      funcCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }

    ArchInputStruct input = new ArchInputStruct();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    CSUB60SI csub60si = new CSUB60SI();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(funcCd);
    input.setSzUserId(getUserLogonID(request));

    //
    // SIR 17233 - set the flag indicating approver mode
    //
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    String taskCD = GlobalData.getSzCdTask(request);
    rowccmn01uig00.setSzCdTask(taskCD);

    Date timestamp = ContextHelper.getJavaDateSafe(context, "timestamp");
    rowccmn01uig00.setTsLastUpdate(timestamp);
    rowccmn01uig00.setSzCdEventStatus(eventStatus);

    rowccmn01uig00.setSzCdEventType(eventType);
    org.exolab.castor.types.Date dtDtEventOccurred = ContextHelper.getCastorDateSafe(context, "dtDtEventOccurred");
    if (DateHelper.isNull(dtDtEventOccurred)) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(dtDtEventOccurred);
    }
    
    
    if (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)&&(CodesTables.CEVNTTYP_VIS.equals(eventType)) ) 
     {
    	 rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
      }
    
    

    int eventID = GlobalData.getUlIdEvent(request);
    rowccmn01uig00.setUlIdEvent(eventID);

    int stageID = GlobalData.getUlIdStage(request);
    rowccmn01uig00.setUlIdStage(stageID);
    rowccmn01uig00.setUlIdPerson(getUserID(request));
    if (!CodesTables.CEVNTTYP_CNS.equals(eventType)) {
      rowccmn01uig00.setSzTxtEventDescr(eventDescription);
    }
    // STGAP00017068: ECEM 5.0 Appending event description for copied
    if (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
      rowccmn01uig00.setSzTxtEventDescr("Updated " + eventDescription);
    }

    csub60si.setTsSysTsLastUpdate2(ContextHelper.getJavaDateSafe(context, "dateLastUpdated2"));
    String indCurrent = ContextHelper.getStringSafe(context, "cbCurrent");
    if (StringHelper.isTrue(indCurrent)) {
      csub60si.setCIndCurrent(ArchitectureConstants.Y);
    }else
    {
      csub60si.setCIndCurrent(ArchitectureConstants.N);
    }

    // MR-094 Visitation Type
    if (CodesTables.CEVNTTYP_VIS.equals(eventType)) {
      eventDescription = eventType.equals(ENG_VISIT_EVENT_TYPE) ? VISIT_PLAN_HEADER
                                                               : Lookup.simpleDecodeSafe(CODE_TABLE_EVENT_TYPE,
                                                                                         eventType);

      String[] visitTypeChecks = CheckboxHelper.getCheckedValues(request, "cbxVisitationTypes");
      VisitTypeCbxRecord_Array cbxArray = new VisitTypeCbxRecord_Array();
      for (String visitType : visitTypeChecks) {
        VisitTypeCbxRecord cbx = new VisitTypeCbxRecord();
        cbx.setSzCdVisitTypeCbx(visitType);
        cbxArray.addVisitTypeCbxRecord(cbx);
        csub60si.setSzCdVisitTypeCbx(visitType);
        eventDescription = eventDescription + " - " + (Lookup.simpleDecodeSafe(CODE_TABLE_VISIT, visitType));
        rowccmn01uig00.setSzTxtEventDescr(eventDescription);
      }
      csub60si.setVisitTypeCbxRecord_Array(cbxArray);
    }

    csub60si.setArchInputStruct(input);
    csub60si.setROWCCMN01UIG00(rowccmn01uig00);
    // SIR 22455 - This should be the current event status
    csub60si.setSzCdEventStatus(ContextHelper.getStringSafe(context, "eventStatus"));

    performanceTrace.exitScope();

    return csub60si;
  }

  /**
   * This method is called by the other methods when an exception is caught.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param e
   *          The Exception
   * @param methodName
   *          A String containing the method which threw the exception
   */
  private void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "handleError");
    String stackTrace = BasePrsException.getStackTrace(e);
    HttpServletRequest request = context.getRequest();
    // First, make sure that document does not get launched
    request.removeAttribute("launchType");
    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;

      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "WtcException " + we.getClass() + " " + we.getMessage());

      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_COMP_NOT_SAVED:
      case Messages.MSG_SUB_OUTPUT_NOT_COMP:
      case Messages.MSG_SYS_STAGE_CLOSED:
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, DISPLAY_OUPUT_LAUNCH_URL, request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } else {
      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "General Exception " + e.getClass() + " " + e.getMessage()
                                                      + stackTrace);
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  // Added for CAPTA changes
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
    PersonListPullBackInfo info = (PersonListPullBackInfo) state
                                                                .getAttribute(
                                                                              PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME,
                                                                              request);

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

  // Added for CAPTA changes
  /**
   * forward to the Person List to allow the user to select the person.
   * 
   * @param context the GRNDS exchange context
   */
  private void forwardToPersonlist(GrndsExchangeContext context) {
    // retrieve the state and request objects from the Session Manager
    HttpServletRequest request = context.getRequest();

    // construct a new object and set this command as the return URL, then put the object on the request
    PersonListPullBackInfo info = new PersonListPullBackInfo();
    info.setDestinationUrl("/admin/OutputLaunch/displayOutputLaunch");
    request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, info);
    // set the page mode to SELECT for the call to PersonList
    PageMode.setPageMode(PersonListConversation.PAGE_MODE_PRINC_ONLY, request);

    try {
      // forward to the PersonList
      forward("/person/PersonList/displayPersonList", request, context.getResponse());
    } catch (ServletException e) {
      // we don't know what else to do if this happens
      processSevereException(context, e);
    }
  }

  /**
   * This method is called by the activity methods when displaying the Output Launch page when the event type is CNS.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void displayCDNFSIOutputLaunch(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayOutputLaunch");
    HttpServletRequest request = context.getRequest();
    try {
      String nEvent = null;
      BaseSessionStateManager state = getSessionStateManager(context);
      String cdStage = GlobalData.getSzCdStage(request);
      int idEvent = GlobalData.getUlIdEvent(request);
      String pageMode = PageMode.getPageMode(request);
      if (PageModeConstants.NEW_USING.equals(pageMode)) {
        nEvent = GlobalData.getUlIdEventAsString(request);
      }
      if ("P".equals(pageMode)) {
        pageMode = state.getAttribute("startingPageState", request).toString();
      } else {
        // Clear the state.
        state.removeAllAttributes(request);
      }
      // save pageMode in state so that I can retrieve it when I come back from person list

      state.setAttribute("startingPageState", pageMode, request);
      if (nEvent != null) {
        request.setAttribute("nEvent", nEvent);
      }

      // Get app mode so we know if we are in 'new using' or 'add' or updating an exiting event
      // check to see if we have already called out to the PersonList to get the PullBack object
      PersonListPullBackInfo info = verifyPersonListInfo(context);
      // Restore page mode to the value it was before you cleared state
      PageMode.setPageMode(pageMode, request);
      // if not, then we need to call out to the PersonList to populate the object unless it is an
      // existing event
      if (PageMode.getPageMode(request).equals(PageModeConstants.NEW)
          && info == null && idEvent == 0
          && (CodesTables.CSTAGES_INT.equals(cdStage) || CodesTables.CSTAGES_INV.equals(cdStage) || CodesTables.CSTAGES_FPR
                                                                                                                           .equals(cdStage))) {
        forwardToPersonlist(context);
      }
      // otherwise, we can go ahead and display the page
      else {

        // set the page mode to NEW,NEW_Using or MODIFY, depending on whether we have already
        PageMode.setPageMode(state.getAttribute("startingPageState", request).toString(), request);

        CSUB59SI csub59si = populateCSUB59SI_Retrieve(context);
        CDNFRetrieveSI cdnfRetrieveSI = new CDNFRetrieveSI();
        cdnfRetrieveSI.setCsub59si(csub59si);
        // set the stage information from Global Data, and the ID of the person returned from the PersonList
        csub59si.setSzSysCdWinMode(state.getAttribute("startingPageState", request).toString());
        // New and New Using have the person id in info, all the existing event needs is its event id
        if (info != null) {
          csub59si.setUlIdPerson(info.getPersonListRow().getUlIdPerson());
        }

        CDNFRetrieveSO cdnfRetrieveSO = reports.retrieveOutputLaunch(cdnfRetrieveSI);
        CSUB59SO csub59so = cdnfRetrieveSO.getCsub59SO();
        // 19831, if document exists and pageMode is NEW;
        // treat pageMode as EDIT
        if ((pageMode.equals(PageModeConstants.NEW)) && (csub59so.getTsLastUpdate() != null)) {
          PageMode.setPageMode(PageModeConstants.EDIT, request);
        }

        request.setAttribute("CSUB59SO", csub59so);
        request.setAttribute("CDNFRetrieveSO", cdnfRetrieveSO);
        ROWCSUB59SOG00 outputRow = csub59so.getROWCSUB59SOG00();

        String eventType = outputRow.getSzCdEventType();
        Screen screen = ScreenMapping.getScreenData(context);
        screen.setParameter("HtmlTitle", "Child Death/Near Fatality/Serious Injury Report", true);
        String docType = Lookup.simpleDecodeSafe(CODE_TABLE_EVENT_DOC, eventType);

        request.setAttribute("docType", docType);

        // SIR 19239 - After looking up info for event selected on list, if
        // New Using, clear info and redo csub59 call to populate with new
        // row info. Must be done after initial call to make sure docType
        // gets set correctly.
        if (pageMode.equals(PageModeConstants.NEW_USING)) {
          // get the 'newUse' eventID and caseID
          int newUseEventID = GlobalData.getUlIdEvent(request);
          request.setAttribute("newUseEventID", String.valueOf(newUseEventID));

          int newUseCaseID = GlobalData.getUlIdCase(request);
          request.setAttribute("newUseCaseID", String.valueOf(newUseCaseID));

          // Clear out event ID from global data
          GlobalData.setUlIdEvent(0, request);

        }

        int caseID = csub59so.getUlIdCase();
        GlobalData.setUlIdCase(caseID, request);

        // encapsulating the block of code in an if statement.
        // when trying to add a new <Event-Output Launch> Type
        // no status would be associated with the type
        if (outputRow.getSzCdEventStatus() != null) {
          // SIR 17676 Only dispaly the invalidate approval messages if the page is not in approval mode
          if (outputRow.getSzCdEventStatus().equals(EVENT_STATUS_PEND) && !GlobalData.isApprovalMode(request)) {
            setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);

            setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
          }
        }
      }
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      // SIR 23001 start
      switch (errorCode) {
      case Messages.MSG_CDNFSI_OVER_18:
        displayMessagePage(errorCode, context);
        break;
      // otherwise, we don't know what to do -- handle it as a severe exception
      default:
        processSevereException(context, we);
      }
      // SIR 23001 end
    } catch (Exception e) {
      handleException(e, context, "displayCDNFSIOutputLaunch");
    }
    performanceTrace.exitScope();
  }

  @SuppressWarnings({ "unchecked" })
  // Added for CAPTA changes
  private static CDNFSaveSI populateCDNFSaveSI(GrndsExchangeContext context, CSUB60SI csub60si) {

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CDNFSaveSI cdnfSaveSI = new CDNFSaveSI();
    ROWCCMN01UIG00 event = new ROWCCMN01UIG00();
    PersonListPullBackInfo info = (PersonListPullBackInfo) state.getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, request);
    if (info != null) {
      csub60si.setUlIdVictim(info.getPersonListRow().getUlIdPerson());
      cdnfSaveSI.setIdChild(csub60si.getUlIdVictim());
    }

    UserProfile user = UserProfileHelper.getUserProfile(request);
    int idCase = GlobalData.getUlIdCase(request);
    String cdStage = GlobalData.getSzCdStage(request);
    csub60si.setSzCdStage(cdStage);

    List<String> causesToDelete = new ArrayList<String>();
    causesToDelete = (List<String>) state.getAttribute("savedCauses", request);
    List<String> causesToAdd = new ArrayList<String>();

    List<String> checkedCauses = new ArrayList<String>();

    String[] cbxValues = CheckboxHelper.getCheckedValues(request, "cbxCauseOfDeath");

    for (int i = 0; i < cbxValues.length; i++) {
      String cdCause = cbxValues[i];
      checkedCauses.add(cdCause);
      if (causesToDelete != null && causesToDelete.contains(cdCause)) {
        causesToDelete.remove(cdCause);
      } else {
        causesToAdd.add(cdCause);
      }
    }

    state.removeAttribute("savedCausesOfDeath", request);
    cdnfSaveSI.setCausesToAdd(causesToAdd);
    cdnfSaveSI.setCausesToDelete(causesToDelete);
    cdnfSaveSI.setCheckedCauses(checkedCauses);

    if (ContextHelper.getIntSafe(request, "idVictim") > 0) {
      int idVictim = ContextHelper.getIntSafe(request, "idVictim");
      cdnfSaveSI.setIdChild(idVictim);
      csub60si.setUlIdVictim(idVictim);
    }
    cdnfSaveSI.setIdCase(idCase);
    cdnfSaveSI.setTxtCommentsCauseDeath(ContextHelper.getStringSafe(request, "szCommts"));
    cdnfSaveSI.setCountyOfDeath(ContextHelper.getStringSafe(request, "txtSzCounty"));
    cdnfSaveSI.setAutopsyCompleted(ContextHelper.getStringSafe(request, "rbAutopsyComp"));
    cdnfSaveSI.setTxtCommentsAutopsy(ContextHelper.getStringSafe(request, "szCommts2"));
    cdnfSaveSI.setDeathPrev(ContextHelper.getStringSafe(request, "rbDeathPrev"));
    cdnfSaveSI.setTxtCommentsDeathPrev(ContextHelper.getStringSafe(request, "szCommts3"));
    cdnfSaveSI.setReportSubmittedWith24Hrs(ContextHelper.getStringSafe(request, "rbRepSub"));
    cdnfSaveSI.setTxtCommentsRepSub(ContextHelper.getStringSafe(request, "szCommts4"));

    // SMS#54782
    String reportTypSelected = ContextHelper.getStringSafe(request, "rbReportType");
    if (StringHelper.isNotEmptyOrNull(reportTypSelected)) {
      cdnfSaveSI.setReportType(reportTypSelected);
    }
    if (PageModeConstants.NEW_USING.equals(PageMode.getPageMode(request))) {
      csub60si.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_PROC);
      cdnfSaveSI.setIsCopied(ArchitectureConstants.TRUE);
      cdnfSaveSI.setOldIdEvent(ContextHelper.getIntSafe(request, "oldIdEvent"));
    }

    return cdnfSaveSI;
  }

  /**
   * Delete OutputLaunch for CNS events
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void deleteOutputLaunch_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteOutputLaunch_xa()");
    performanceTrace.enterScope();

    try {
      CDNFSaveSI cdnfDeleteSI = new CDNFSaveSI();
      CSUB60SI csub60si = populateCSUB60SI_Update(context, reports);
      cdnfDeleteSI = populateCDNFSaveSI(context, csub60si);
      cdnfDeleteSI.setCsub60si(csub60si);
      cdnfDeleteSI.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
      CDNFSaveSO cdnfSaveSO = reports.saveOutputLaunch(cdnfDeleteSI);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "deleteOutputLaunch_xa()");
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when marking an Output Launch document complete.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */

  public void completionCheck_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "completionCheck_xa");
    try {
      completionCheck(context);
    } catch (Exception e) {
      handleException(e, context, "completionCheck_xa");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called when the user clicks the Complete button on the OutputLaunch page. 
   * This method calls the save function to do edits and then , we are forwarded to the Event list page.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  protected CSUB60SO completionCheck(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "completionCheck()");

    HttpServletRequest request = context.getRequest();

    String eventType = ContextHelper.getStringSafe(context, "eventType");
    String eventDescription = StringHelper.EMPTY_STRING;

    eventDescription = Lookup.simpleDecodeSafe(CODE_TABLE_EVENT_TYPE, eventType);

    // 18906
    String eventStatus = ContextHelper.getStringSafe(context, "eventStatus");
    eventStatus = OutputLaunchConversation.EVENT_STATUS_COMP;

    String funcCd = null;

    // Once the completion Button is pushed the pagemode will be View.
    String pageMode = PageModeConstants.VIEW;
    funcCd = ServiceConstants.REQ_FUNC_CD_UPDATE;

    if (!checkDocExists(context, reports)) {
      throw new ServiceException(Messages.MSG_COMP_NOT_SAVED);
    }

    ArchInputStruct input = new ArchInputStruct();
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    CSUB60SI csub60si = new CSUB60SI();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(funcCd);
    input.setSzUserId(getUserLogonID(request));

    String taskCD = GlobalData.getSzCdTask(request);
    rowccmn01uig00.setSzCdTask(taskCD);

    Date timestamp = ContextHelper.getJavaDateSafe(context, "timestamp");
    rowccmn01uig00.setTsLastUpdate(timestamp);
    rowccmn01uig00.setSzCdEventStatus(eventStatus);

    rowccmn01uig00.setSzCdEventType(eventType);
    org.exolab.castor.types.Date dtDtEventOccurred = ContextHelper.getCastorDateSafe(context, "dtDtEventOccurred");
    if (DateHelper.isNull(dtDtEventOccurred)) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(dtDtEventOccurred);
    }

    int eventID = GlobalData.getUlIdEvent(request);
    rowccmn01uig00.setUlIdEvent(eventID);

    if (PERM_ROUNDTABLE_EVENT_TYPE.equals(eventType) || (SAFETY_ROUNDTABLE_EVENT_TYPE.equals(eventType))) {
      csub60si.setCIndCopied(ArchitectureConstants.TRUE);
    }
    int stageID = GlobalData.getUlIdStage(request);
    rowccmn01uig00.setUlIdStage(stageID);
    rowccmn01uig00.setUlIdPerson(getUserID(request));
    rowccmn01uig00.setSzTxtEventDescr(eventDescription);

    // Setting the completion date to the current date
    csub60si.setTsSysTsLastUpdate2(new Date());

    csub60si.setArchInputStruct(input);
    csub60si.setROWCCMN01UIG00(rowccmn01uig00);
    // SIR 22455 - This should be the current event status
    csub60si.setSzCdEventStatus(ContextHelper.getStringSafe(context, "eventStatus"));

    performanceTrace.exitScope();
    return reports.saveOutputLaunch(csub60si);
  }

  /**
   * This method is called when the user clicks the Approval Status button on the OutputLaunch page in
   * approval mode. This method calls the save function to do edits and then , we are forwarded to the Approval Status page.
   * 
   * @param context -
   *                the GrndsExchangeContext object
   * @return void
   */
  public void submitApproval_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".submitApproval_xa()");
    try {
      saveOutputLaunch_xa(context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();

  }

}
