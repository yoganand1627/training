package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RelativeCareAssmtDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentPersonInfo;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * 
 * <pre>
 *                        Change History:
 *                        Date      User              Description
 *                        --------  ----------------  --------------------------------------------------
 * </pre>                 07/21/2008 mchillman        STGAP00009647 Added formatting to display caretakers
 *                                                    from person list in event description
 *                        11/11/2008 arege            STGAP00010758 Deleting an event should delete the ToDo.
 *                                                    An error message MSG_CMN_INVLD_APRVL_POPUP  and MSG_CMN_INVLD_APRVL
 *                                                    displayed when the user accesses the page while the event Status is 
 *                                                    in PEND status.
 *                                                    
 *
 */

@SuppressWarnings("serial")
public class RelativeCareAssessmentConversation extends BaseHiddenFieldStateConversation {

  protected static final String PERSON_LIST_PULLBACK_INFO = PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME;

  public static final String URL_PERSON_LIST = "/person/PersonList/displayPersonList";

  public static final String PERSON_INFO_LIST = "personInfoList";

  public static final String PERSON_INFO_RB = "rbPersonInfo";

  public static final String RETRIEVESO = "RCARetrieveSO";

  public static final String RCA_EVENT_TYPE = "ASM";

  public static final String EVENT_STATUS_PEND = "PEND";

  public static final String EVENT_STATUS_NEW = "NEW";

  public static final String EVENT_STATUS_PROC = "PROC";

  public static final String EVENT_STATUS_COMP = "COMP";

  public static final String EVENT_STATUS_APRV = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_DESC_SA = "Relative Care/Non-Relative Guardianship Assessment for ";

  public static final String APPROVE_RCA = "9466";

  public static final String PREV_PAGE_MODE = "PREVIOUS_PAGE_MODE";

  private CaseMgmt caseMgmt = null;

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }

  public void displayRelativeCareAssessment_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayRelativeCareAssessment_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    int idEvent = GlobalData.getUlIdEvent(request);
    BaseSessionStateManager state = getSessionStateManager(request);
    RelativeCareAssessmentBean rcaSO = null;
    String eventStatus = StringHelper.EMPTY_STRING;
    if (idEvent != 0) {
      rcaSO = caseMgmt.retrieveRelativeCareAssmt(idEvent);
     eventStatus =  rcaSO.getRowccmn45do().getSzCdEventStatus();
    } else {
      rcaSO = new RelativeCareAssessmentBean();
    }
    state.setAttribute(RelativeCareAssessmentConversation.RETRIEVESO, rcaSO, request);

    boolean globalEvtStatusIsApproval = GlobalData.isApprovalMode(request);
    if (EVENT_STATUS_PEND.equals(eventStatus) && !globalEvtStatusIsApproval
        && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
      setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
      setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  public void setResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setResource_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);

    try {
      CRES03SO cres03so = (CRES03SO) request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);
      String resourceName = cres03so.getSzNmResource();
      Integer idResource = cres03so.getUlIdResource();
      RelativeCareAssessmentBean rcaRetrieveSO = (RelativeCareAssessmentBean) state.getAttribute(RETRIEVESO, request);
      rcaRetrieveSO.setNmResource(resourceName);
      rcaRetrieveSO.setIdResource(idResource);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  public void getResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getResource_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    BaseSessionStateManager state = getSessionStateManager(context);
    RelativeCareAssessmentBean rcaRetrieveSO = (RelativeCareAssessmentBean) state.getAttribute(RETRIEVESO, request);
    getRetrieveSOFromRequest(rcaRetrieveSO, request);
    try {
      forward("/financials/Contracts/searchResource", request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  public void getPerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "retrievePerson_xa");

    HttpServletRequest request = context.getRequest();

    try {
      BaseSessionStateManager state = getSessionStateManager(context);

      RelativeCareAssessmentBean rcaRetrieveSO = (RelativeCareAssessmentBean) state.getAttribute(RETRIEVESO, request);
      getRetrieveSOFromRequest(rcaRetrieveSO, request);
      // populate PersonInfoList
      List<RelativeCareAssessmentPersonInfo> personInfoList = rcaRetrieveSO.getPersonInfoList();
      if (personInfoList != null) {
        getPersonInfoFromRequest(personInfoList, request);
      }
      PersonListPullBackInfo personListPullBackInfo = new PersonListPullBackInfo();
      personListPullBackInfo.setDestinationUrl("/subcare/RelativeCareAssessment/setPerson");
      request.setAttribute(PERSON_LIST_PULLBACK_INFO, personListPullBackInfo);
      String pageMode = PageMode.getPageMode(request);
      state.setAttribute("pageMode", PageMode.getPageMode(request), request);
      state.setAttribute(PREV_PAGE_MODE, pageMode, request);
      PageMode.setPageMode(PersonListConversation.PAGE_MODE_SELECT, request);
      forward(PersonListConversation.DISPLAY_PAGE, request, context.getResponse());
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  public void setPerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setResource_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);
    try {
      PageMode.setPageMode((String) state.getAttribute("pageMode", request), request);
      PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) request
                                                                                      .getAttribute(PERSON_LIST_PULLBACK_INFO);
      ROWCINV01SOG00 row = personListPullBackInfo.getPersonListRow();
      request.removeAttribute(PERSON_LIST_PULLBACK_INFO);
      String personName = row.getSzNmPersonFull();
      int idPerson = row.getUlIdPerson();
      RelativeCareAssessmentBean rcaRetrieveSO = (RelativeCareAssessmentBean) state.getAttribute(RETRIEVESO, request);
      List<RelativeCareAssessmentPersonInfo> personInfoList = (List<RelativeCareAssessmentPersonInfo>) rcaRetrieveSO
                                                                                                                    .getPersonInfoList();
      if (personInfoList == null) {
        personInfoList = new ArrayList<RelativeCareAssessmentPersonInfo>();
        rcaRetrieveSO.setPersonInfoList(personInfoList);
      }
      RelativeCareAssessmentPersonInfo personInfo = new RelativeCareAssessmentPersonInfo();
      personInfo.setNmPersonName(personName);
      personInfo.setUlIdPerson(idPerson);
      personInfoList.add(personInfo);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  public void saveAndSubmitRelativeCareAssessment_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveRelativeCareAssessment_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);
    RelativeCareAssessmentBean saveSI = (RelativeCareAssessmentBean) state.getAttribute(RETRIEVESO, request);
    getRetrieveSOFromRequest(saveSI, request);
    getPersonInfoFromRequest(saveSI.getPersonInfoList(), request);
    getRelativeCareAssessmentSaveSIFromRequest(saveSI, request);
    ROWCCMN45DO asEvent = saveSI.getRowccmn45do();
    asEvent.setSzCdEventStatus(EVENT_STATUS_COMP);
    
    // Capta 4.3 Adding error message to force users to launch the Relative 
    // Care Assessment Form if not done before Saving and Submitting. 
    if (ArchitectureConstants.N.equals(saveSI.getIndBLOBExistsInDatabase())) {
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
     setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_REL_CARE_ASSESS_FORM_REQ), request);
    }
    

    int eventId = caseMgmt.saveRelativeCareAssmt(saveSI);
    GlobalData.setUlIdEvent(eventId, request);

    int ulIdEvent = GlobalData.getUlIdEvent(request);
    int ulIdCase = GlobalData.getUlIdCase(request);
    int ulIdStage = GlobalData.getUlIdStage(request);
    String szCdTask = APPROVE_RCA;
    ToDoDetailDB toDoDetailDB = new ToDoDetailDB(ulIdEvent, ulIdCase, ulIdStage, szCdTask);
    ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

    performanceTrace.exitScope();
  }

  public void callPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callPersonDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    int loopCounter = ContextHelper.getIntSafe(request, "hdnPersonLoopCount");
    int idPersonSelected = ContextHelper.getIntSafe(request, "ulIdPerson" + loopCounter);
    GlobalData.setUlIdPerson(idPersonSelected, request);
    PersonHelper.setPersonDetailPageMode(request, GlobalData.getAppMode(request));
    performanceTrace.exitScope();
  }

  public void saveRelativeCareAssessment_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveRelativeCareAssessment_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);
    RelativeCareAssessmentBean saveSI = (RelativeCareAssessmentBean) state.getAttribute(RETRIEVESO, request);
    getRetrieveSOFromRequest(saveSI, request);
    getPersonInfoFromRequest(saveSI.getPersonInfoList(), request);
    getRelativeCareAssessmentSaveSIFromRequest(saveSI, request);
    ROWCCMN45DO asEvent = saveSI.getRowccmn45do();
    asEvent.setSzCdEventStatus(EVENT_STATUS_PROC);

    int eventId = caseMgmt.saveRelativeCareAssmt(saveSI);
    GlobalData.setUlIdEvent(eventId, request);

    performanceTrace.exitScope();
  }

  public void deleteRelativeCareAssessment_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteRelativeCareAssessment_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    RelativeCareAssmtDeleteSI deleteSI = populateDeleteSIFromRequest(request);
    caseMgmt.deleteRelativeCareAssmt(deleteSI);
    performanceTrace.exitScope();
  }

  private RelativeCareAssmtDeleteSI populateDeleteSIFromRequest(HttpServletRequest request) {
    RelativeCareAssmtDeleteSI deleteSI = new RelativeCareAssmtDeleteSI();
    deleteSI.setEventReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
    deleteSI.setIdStage(GlobalData.getUlIdStage(request));
    deleteSI.setCdStage(GlobalData.getSzCdStage(request));
    deleteSI.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "dtLastUpdate"));
    deleteSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
    ROWCCMN01UIG00 relativeCareAssessmentEvent = new ROWCCMN01UIG00();
    relativeCareAssessmentEvent.setUlIdEvent(GlobalData.getUlIdEvent(request));
    relativeCareAssessmentEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "dtLastUpdateForEvent"));
    deleteSI.setRowccmn01uigoo(relativeCareAssessmentEvent);

    return deleteSI;
  }

  public static void getRetrieveSOFromRequest(RelativeCareAssessmentBean so, HttpServletRequest request) {
    so.setCdPersonPerformingAssessment(ContextHelper.getStringSafe(request, "rbPersonPerformingAssessment"));
    so.setCdAssessmentType(ContextHelper.getStringSafe(request, "rbAssessmentType"));
    so.setCdCaregiverType(ContextHelper.getStringSafe(request, "rbCaregiverType"));
    so.setCdCounty(ContextHelper.getStringSafe(request, "selSzCdCounty"));
    so.setCdState(ContextHelper.getStringSafe(request, "selSzCdState"));
    so.setDtInitiated(ContextHelper.getJavaDateSafe(request, "txtDtDtInitiatedReferred"));
    so.setDueDate(ContextHelper.getJavaDateSafe(request, "txtDtDtDue"));
    so.setScheduleAssessmentDate(ContextHelper.getJavaDateSafe(request, "txtDtDtScheduledAssessment"));
    so.setActualHomeVisitDate(ContextHelper.getJavaDateSafe(request, "txtDtDtActualHomeVisit"));
    so.setDtAssessmentComplete(ContextHelper.getJavaDateSafe(request, "txtDtDtAssessmentComplete"));
    so.setDtAssessmentReceived(ContextHelper.getJavaDateSafe(request, "txtDtDtAssessmentReceived"));
    so.setCdAssessmentResults(ContextHelper.getStringSafe(request, "selSzCdAsmtResults"));
    so.setDtDecisionDate(ContextHelper.getJavaDateSafe(request, "txtDtDtDecision"));
    // defect fix STGAP00003915 : Support check box status not saved correctly
    so.setIndSupportOptions(ContextHelper.getStringSafe(request, "cbxBIndSupportOptions"));
    so.setDtDiscussionDate(ContextHelper.getJavaDateSafe(request, "txtDtDtDiscussion"));
    so.setCdWillingToAcceptChild(ContextHelper.getStringSafe(request, "cbxBIndWillingToAcceptChild"));
    so.setCdInitialChoiceOfSupport(ContextHelper.getStringSafe(request, "selSzCdInitSup"));
    so.setDtReferredToRD(ContextHelper.getJavaDateSafe(request, "txtDtDtReferredToRD"));
    so.setDtPlacementAgreementSigned(ContextHelper.getJavaDateSafe(request, "txtDtPlacementAgreementSigned"));
    so.setTxtNonRelatives(ContextHelper.getStringSafe(request, "txtSzNonRelatives"));
    so.setTxtComments(ContextHelper.getStringSafe(request, "txtSzComments"));
    so.setDtLastUpdate(ContextHelper.getJavaDateSafe(request, "dtLastUpdate"));
    so.setIdEvent(ContextHelper.getIntSafe(request, "ulIdRcaEvent"));
    so.setIdStage(GlobalData.getUlIdStage(request));
    so.setCdStage(GlobalData.getSzCdStage(request));
    so.setIdCase(GlobalData.getUlIdCase(request));
  }

  public static void getPersonInfoFromRequest(List<RelativeCareAssessmentPersonInfo> personInfoList,
                                              HttpServletRequest request) {
    if (personInfoList != null) {
      int i = 0;
      for (RelativeCareAssessmentPersonInfo personInfo : personInfoList) {
        int rbSelected = ContextHelper.getIntSafe(request, PERSON_INFO_RB + i);
        personInfo.setIsSelected(rbSelected);
        Date dtLastUpdate = ContextHelper.getJavaDateSafe(request, "dtLastUpdate" + i);
        personInfo.setDtLastUpdate(dtLastUpdate);
        personInfo.setUlIdRcaPerson(ContextHelper.getIntSafe(request, "ulIdRcaPerson" + i));
        personInfo.setUlIdPerson(ContextHelper.getIntSafe(request, "ulIdPerson" + i++));
        personInfo.setUlIdRcaEvent(ContextHelper.getIntSafe(request, "ulIdRcaEvent"));
      }
    }
  }

  private void getRelativeCareAssessmentSaveSIFromRequest(RelativeCareAssessmentBean si, HttpServletRequest request) {

    UserProfile user = UserProfileHelper.getUserProfile(request);
    BaseSessionStateManager state = getSessionStateManager(request);
    int idEvent = GlobalData.getUlIdEvent(request);
    String newEventDescr = null;
    String szCdStageName = GlobalData.getSzNmStage(request);
    
    String caretakerList = null;
    List<RelativeCareAssessmentPersonInfo> personInfoList = si.getPersonInfoList();
    if(personInfoList != null && personInfoList.size() > 0) {
      StringBuffer nameList = new StringBuffer();
      Iterator<RelativeCareAssessmentPersonInfo> itr = personInfoList.iterator();
      while(itr.hasNext()) {
        RelativeCareAssessmentPersonInfo personInfo = itr.next();
        if (personInfo.getIsSelected(0) == true) {
          nameList.append("; "  + personInfo.getNmPersonName());
        }
      } 
      caretakerList = nameList.toString(); 
    }
    
    newEventDescr = EVENT_DESC_SA + szCdStageName + caretakerList;
    newEventDescr = (newEventDescr.length() > 100) ? newEventDescr.substring(0, 100) : newEventDescr;
    
    
    si = (RelativeCareAssessmentBean) state.getAttribute(RETRIEVESO, request);
    
    ROWCCMN45DO relativeCareAssessmentEvent = new ROWCCMN45DO();
    if(si.getRowccmn45do() != null){
    relativeCareAssessmentEvent.setSzCdEventStatus(si.getRowccmn45do().getSzCdEventStatus());
    }
    relativeCareAssessmentEvent.setSzCdEventType(RCA_EVENT_TYPE);
    relativeCareAssessmentEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    relativeCareAssessmentEvent.setUlIdStage(GlobalData.getUlIdStage(request));
    relativeCareAssessmentEvent.setUlIdPerson(user.getUserID());
    //relativeCareAssessmentEvent.setSzTxtEventDescr(EVENT_DESC_SA);
    relativeCareAssessmentEvent.setSzTxtEventDescr(newEventDescr);
    relativeCareAssessmentEvent.setSzCdTask(GlobalData.getSzCdTask(request));
    relativeCareAssessmentEvent.setUlIdEvent(idEvent);
    relativeCareAssessmentEvent.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "dtLastUpdateForEvent"));
    si.setRowccmn45do(relativeCareAssessmentEvent);
  }
 
 }
