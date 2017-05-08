package gov.georgia.dhr.dfcs.sacwis.web.investigation;

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
import gov.georgia.dhr.dfcs.sacwis.core.utility.Date;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveTaskList;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.Investigation;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV10DOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14DOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV15SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV15SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to display, save and save and submit the CPS Investigation Conclusion page.
 * 
 * @author Narasimha Rao, October 05, 2002 <p/> <p/> <p/>
 * 
 * <pre>
 *                          Change History:
 *                           Date      User      Description
 *                           --------  --------  --------------------------------------------------
 *                           05/10/2003  KRD     SIR 17233 - Code changes applied to support
 *                                               &quot;Approver Mode&quot; providing supervisors the ability to
 *                                               modify data without invalidating the pending
 *                                               approval.  Required changes to
 *                                               populateCINV12S_Update() and populateCINV16S_Update().
 *                           06/06/03  GRIMSHAN  SIR 17825 - Retrieve page mode from event search conversation
 *                                               if the page mode does not need to be changed, it iwll not be
 *                           06/09/03  EILERSBE  SIR 17825 - After a save in a save and submit, call  validation
 *                                               service outside of the transaction used in the save.
 *                           07/12/03   Demoma   Sir 18795 included dt_event_occured in cinv16s use today's date
 *                                               for when the event occured see cinv06w.win line 4403
 *                           07/25/03  DOUGLACS  SIR 19140 - if in approver mode, the user changes EA elig, they
 *                                               should get validation error messages like Save&amp;Submit -before only
 *                                               validated on click of approval status button.
 *                           08/06/03  RIOSJA    SIR 19188 - REMOVE SIR 19140 - If the Investigation
 *                                               Conclusion is pending approval and the supervisor changes
 *                                               the EA Eligibility responses or the Safety Plan Completed
 *                                               checkbox, the pending closure will be invalidated. This
 *                                               is necessary because the Risk Finding and EA Eligibility
 *                                               responses and Safety Plan are all interdependent. If the
 *                                               EA Eligibility responses or Safety Plan Completed checkbox
 *                                               have changed, they might be inconsistent with the Risk
 *                                               Finding. The fix implemented for SIR 19140 is not
 *                                               sufficient because the supervisor could still navigate to
 *                                               the Approval Status page via the approval event on the
 *                                               Event List, and could still approve the pending closure.
 *                           09/11/2003 DEMOMA   Sir 19688 Added static String that are used in the JSP
 *                                               See JSP for imformation.
 *                           11/10/2002 DEJUANR  SIR 19971 - Dont show the appl pend message if the page is in inquire mode.
 *                           04/15/04  dickmaec  SIR 22729 and SIR 22726 Added the MSG_RISK_FINDING_SUB if the user
 *                                               clicks the save and submit push button, there is event removing the
 *                                               child from the home, and if risk finding is equal to risk indicated and
 *                                               recommend action is not a -close field.  The recommend action
 *                                               checkbox will be hidden when the incidator is N and in browse
 *                                                mode displayed if the incidator is Y.
 *                           06/18/04  dejuanr   SIR 22936 - Added code to handle selBIndCpsInvstCpsLeJointContact,
 *                                               selSzCdCpsInvstCpsLeJointContact, and txtSzTxtCpsInvstCpsLeJointContact.
 *                           01/13/2004 dejuanr  SIR 22986 - Add victim taped fields
 *                           03/04/05  dejuanr   SIR 23459 - fix isNotEAEmpty.  The context helper for the drop down
 *                                               was returning an empty string, not a null.  Replace null check
 *                                               with Stringhelper isvalid.
 *                           05/09/05  NALLAVS   SIR 23547 - Removed System.out.println statements.
 *                           06/04/08  SWR       STGAP00009080 - Modified code so not to check for assessments if the closure
 *                                               reason is 'Opened in Error'. 
 *                           11/20/08  CHARDEN   STGAP00009916 - added code to perform check on Principal children in case to make sure
 *                                               all children have been removed if the overall risk finding chosen is 'RISK INDICATED/OPEN FOR SERVICES'
 *                           10/06/09  arege     STGAP00015417 - Allegation List should display correctly when clicking Allegations tab in ARI
 *                                               stage after clicking on Investigation Conclusion tab first. 
 *                           05/24/10  bgehlot   SMS#51977 MR-066 Changes
 *                           06/23/10  bgehlot   SMS 59296 MR-066 New requirement to add other information under Placement/Non-Placement Provider section
 *                           06/25/10  bgehlot   SMS 59303 Save before search
 *                           06/22/11  charden   Capta 4.3 - adding logic to allow policu unit members and deputy director to access page, and modifying page
 *                                                           display mode so that page remains modifiable during a Special Investigation
 *                           07/11/11  charden   SMS #114498 modifying code to prevent resource search section from pre-populating except for after resource pullback
 *                           01/26/12  habraham  STGAP00017829 - Modified the code to add the indicator for Unsubstantiated Disposition from the allegation 
 *                                               Change to rowcinv10doG00 object
 *                           03/09/12  vcollooru STGAP00017941: Added a new comment field for foster parent notification.
 * </pre>
 */
@SuppressWarnings("serial")
public class CPSInvCnclsnConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "CPSInvCnclsnConversation";

  public static final int PAGE_SIZE = 50;

  public static final int NUM_EA_RESULTS = 3;
  
  public static final String SAVE_SUBMIT = ServiceConstants.REQ_FUNC_CD_UPDATE;
  
  public static final String CPS_INV_CNCLSN_URL = "/investigation/CPSInvCnclsn/displayCPSInvCnclsn";

  public static final String EVENT_STATUS_PENDING = CodesTables.CEVTSTAT_PEND;

  public static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  public static final String EVENT_STATUS_IN_PROCESS = CodesTables.CEVTSTAT_PROC;

  // public static final String CASE_TODO_PAGE = "caseToDo";
  public static final String CASE_TODO_PAGE = "/workload/ToDo/displayCaseToDo";

  // public static final String STAFF_TODO_PAGE = "staffToDo";
  public static final String STAFF_TODO_PAGE = "/workload/ToDo/displayStaffToDo";

  public static final String INVST_CNCLN_TAB = "";

  public static final String EVENT_LIST_PAGE = "event";

  public static final String WINDOW_MODE_NEW_APPRV = "X";

  public static final String CPS_APPROVAL_TASK_CODE = "2340";

  public static final String EVENT_ARRAY = "eventArray";

  public static final String DISPLAY_CPS_CNCLSN = "/investigation/CPSInvCnclsn/displayCPSInvCnclsn";

  // These constants are used on CPSInvCnclsn.jsp
  public static final String RISK_ASSESSMENT_TEMPLATE = "RISK_ASSESSMENT_TEMPLATE";

  public static final String RECLASSIFICATION = "99";

  public static final String RISK_INDICATED = "01";

  public static final String FACTOR_CONTROLLED = "02";

  public static final String NO_SIGNIF_FACTORS = "03";

  public static final String RA_NA = "04";

  public static final String ADMIN_CLOSURE =CodesTables.CLIVALDS_ADM;

  public static final String FAMILY_MOVED =CodesTables.COUTCTYP_MOV;

  public static final String UNABLE_TO_COMPLETE =CodesTables.CCIVALDS_UTC;

  public static final String UNABLE_TO_DETERMINE = CodesTables.CLIVALDS_UTD;

  public static final String RULED_OUT = "R/O";

  public static final String EA_ELIG_TASK_CODE = "2325";

  public static final String CPS_INV_CONCL_TASK_CODE = "2330";

  public static final String CONCLUSION_SECTION = "conclusionSection";

  public static final String OVERRIDE_SECTION = "overrideSection";
  
  public static final String SAVE = "save";
  
  public static final String SAVEANDSUBMIT = "saveandsubmit";

  private static final int METHOD_SAVE = 0;

  private static final int METHOD_SAVE_SUBMIT = 1;
  //MR-066
  private static final String ERROR_STRING = "error";
  public static String RESOURCE_DETAIL_CALLED = "/resource/ResourceDetail/displayResourceDetail";
  public static String HOME_INFORMATION_CALLED = "/fad/HomeInfrmtn/displayHomeInformation";
  private static String PROVIDER_ALLGTN_CALL = "/resource/ProviderAllgtnHistory/displayCpsInvCnclsn";
  public static final String PREVIOUS_URL = TRACE_TAG + "PREVIOUS_URL";  

  private Investigation investigation;

  private RetrieveTaskList retrieveTaskList;

  private Common common;

  private Admin admin;
  
  private Person person = null;

  // private Assessment assessment;

  public void setInvestigation(Investigation investigation) {
    this.investigation = investigation;
  }

  public void setRetrieveTaskList(RetrieveTaskList retrieveTaskList) {
    this.retrieveTaskList = retrieveTaskList;
  }

  public void setCommon(Common common) {
    this.common = common;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }
  
  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * This method is called by the GRNDS controller when the user requests to display the CPS Investigation Conclusion
   * and EA Eligibility page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayCPSInvCnclsn_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCPSInvCnclsn_xa" + new Date());
    performanceTrace.enterScope();    
    displayCPSInvCnclsn(context);
    performanceTrace.exitScope();
  }
  
  /**
   * MR-066 SMS 59303 This method displays the CPS Investigation page.
   * @param context
   */
  private void displayCPSInvCnclsn(GrndsExchangeContext context){
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCPSInvCnclsn" + new Date());
    performanceTrace.enterScope();
    
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    // --boolean globalEvtStatusIsApproval = false;

    try {      
      int stageId = GlobalData.getUlIdStage(request);
      CINV14SI cinv14si = populateCINV14SI_Retrieve(context);      
      state.removeAllAttributes(request);
      int conclusionEventId = cinv14si.getUlIdEvent();
      GlobalData.setUlIdEvent(conclusionEventId, request);
      // if coming from a non-INV stage, we are in VIEW mode
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_INV)) {
        // so EventSearchConversation can correctly identify Todo overrides
        GlobalData.setSzCdTask(CPS_INV_CONCL_TASK_CODE, request);

        // SIR 17825 get the page mode from event search conversation

        String pageMode = EventSearchConversation.getEventDetailPageMode(request, conclusionEventId, stageId,
                                                                         CPS_INV_CONCL_TASK_CODE);

        PageMode.setPageMode(pageMode, request);
      }

      CINV14SO cinv14so = investigation.retrieveCPSInvestigationConclusion(cinv14si);
      
      //MR-066 SMS 59296
      gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01 rowcinv10dog01 = cinv14so.getROWCINV10DOG01();

      if (rowcinv10dog01 == null) {
        rowcinv10dog01 = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01();
      }

      AddressBean aapBean2 = new AddressBean();
      aapBean2.setAddressSubmoduleName("facilityAddress");
      aapBean2.setAddress1(rowcinv10dog01.getSzAddrIncmgFacilStLn1());
      aapBean2.setAddress2(rowcinv10dog01.getSzAddrIncmgFacilStLn2());
      aapBean2.setCity(rowcinv10dog01.getSzAddrIncmgFacilCity());
      aapBean2.setState(rowcinv10dog01.getSzCdIncmgFacilState());
      aapBean2.setZipAndSuff(rowcinv10dog01.getSzAddrIncmgFacilZip());
      aapBean2.setCounty(rowcinv10dog01.getSzCdIncmgFacilCnty());
      aapBean2.addToRequest(request);

      state.setAttribute("CINV14SO", cinv14so, request);
      //STGAP00015417 Set investigation stage id and this will ensure that that Allegation List is displayed
      //              correctly in ARI stage when coming from Investigation Conclusion tab.
      state.setAttribute("relatedStage", cinv14si.getUlIdStage() , request);

      request.setAttribute(RISK_ASSESSMENT_TEMPLATE, getRiskAssessmentNarrativeTemplate(cinv14so));

      // Get ROWCCMN45DO and do a null check so we can use Event Status in the Page Mode Logic.
      gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO row45 = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO();
      if (cinv14so.getROWCCMN45DO() != null) {
        row45 = cinv14so.getROWCCMN45DO();
      }
      String eventStatus = row45.getSzCdEventStatus();

      // use this block after eventStatus = EVENT_STATUS_APPROVED
      if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_ARI)) {
        PageMode.setPageMode(PageModeConstants.EDIT, request);
      } else if (eventStatus.equals(EVENT_STATUS_APPROVED)) {
        PageMode.setPageMode(PageModeConstants.INQUIRE, request);
      }
      
      // if coming from provider allgtn history page, set page to view mode
      if(CPSInvCnclsnConversation.PROVIDER_ALLGTN_CALL.equals(request.getAttribute("forwarded"))){
        PageMode.setPageMode(PageModeConstants.VIEW, request);
      }
      
      // get current stage
      Stage stage = CaseUtility.getStage(cinv14si.getUlIdStage());
      // get current user
      UserProfile user = UserProfileHelper.getUserProfile(context);
      // is user deputy director or policy unit member
      boolean isSpecialModify = common.isUserDeputyDirector(user.getUserID()) || common.isUserPolicyUnit(user.getUserID());
      // if the current stage is closed and there is an active special investigation, set page mode to modify
      if (ArchitectureConstants.Y.equals(stage.getIndStageClose()) && ArchitectureConstants.Y.equals(cinv14so.getBIndActiveEvent())) {
        // allow policy unit members and deputy director to modify page along with the usual page modifiers
        if (CaseUtility.hasStageAccess(user.getUserID(), cinv14si.getUlIdStage()) || isSpecialModify) {
          PageMode.setPageMode(PageModeConstants.MODIFY, request);
          request.setAttribute("spiModify", ArchitectureConstants.Y);
        }
      }

      if (PageModeConstants.NEW.equals(PageMode.getPageMode(request)) || PageModeConstants.EDIT.equals(PageMode.getPageMode(request)) 
                      || "Y".equals(GlobalData.getApprovalFlag(request))) {
        List<Map> unKnownIfMemberOfPKHshld = null;
        unKnownIfMemberOfPKHshld = retrievePRNUnknownIfMmbrOfPKHsehold(stageId);
        if (unKnownIfMemberOfPKHshld == null || unKnownIfMemberOfPKHshld.isEmpty()) {
          // Do nothing since there aren't any Principals with 'Unknown'
        } else {
          StringBuffer sb = new StringBuffer();
          for (Iterator<Map> it = unKnownIfMemberOfPKHshld.iterator(); it.hasNext();) {
            Map prnUnknownIfMmbr = it.next();
            sb.append(prnUnknownIfMmbr.get("nmPersonFull"));
            if (it.hasNext()) {
              sb.append("- ");
            } else {
              sb.append(".");
            }
          }
          String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INV_MBR_HH_UNKNOWN);
          errorMessage = MessageLookup.addMessageParameter(errorMessage, sb.toString());
          request.setAttribute("unknownIfMmberHshldErrorMessage", errorMessage);
        }
      }
      // Set whether the conclusion and/or the Override blocks will be enabled or disabled
       HashMap secMap = setPageSubSectionMode(context, GlobalData.getSzCdStage(request), eventStatus);
       state.setAttribute(CONCLUSION_SECTION, (String) secMap.get(CONCLUSION_SECTION), request);
      state.setAttribute(OVERRIDE_SECTION, (String) secMap.get(OVERRIDE_SECTION), request);
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_INV_NO_EXISTS:
      case Messages.MSG_NO_ROWS_RETURNED:
      case Messages.MSG_INV_NOT_BEGUN:
        String errorMessage = MessageLookup.getMessageByNumber(we.getErrorCode());
        displayMessagePage(errorMessage, context);
        break;
      default:
        handleError(we, context);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user requests to Save CPS Investigation Conclusion and EA
   * Eligibility page.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveCPSInvCnclsn_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveCPSInvCnclsn_xa()");
    performanceTrace.enterScope();

    try {
      save(context, METHOD_SAVE);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user requests to Save and Submit the CPS Investigation
   * Conclusion and EA Eligibility page. Passes SAVE_SUBMIT ("U") for the setCReqFuncCd to the populateCINV15SI_Validate
   * submethod
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveSubmitCPSInvCnclsn_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveSubmitCPSInvCnclsn()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      save(context, METHOD_SAVE_SUBMIT);

      // VALIDATE
      CINV15SI cinv15si = populateCINV15SI_Validate(context, SAVE_SUBMIT);
      // SIR 17825 - Call this service outside of the transaction used in the save.
      CINV15SO cinv15so = investigation.saveCPSInvestigationConclusionValidation(cinv15si);

      // If the validation service returns an error list, put the errors in the request and set the error d
      if ((cinv15so.getCINV15SOG01() != null)
          && (cinv15so.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().getUsSysNbrMessageCodeCount() != 0)) {
        int[] errorArray = cinv15so.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().getUsSysNbrMessageCode();
        ErrorList.setErrors(errorArray, request);
        this.setPresentationBranch("error", context);
        request.setAttribute("CINV15SO", cinv15so);
      } else {
        CINV14SO cinv14so = (CINV14SO) state.getAttribute("CINV14SO", request);
        ROWCINV15SOG00_ARRAY rowcinv15soG00_array = cinv15so.getROWCINV15SOG00_ARRAY();
        int[] events = new int[rowcinv15soG00_array.getROWCINV15SOG00Count()];
        Enumeration rowcinv15soG00Enumeration = rowcinv15soG00_array.enumerateROWCINV15SOG00();
        int i = 0;
        while (rowcinv15soG00Enumeration.hasMoreElements()) {
          events[i++] = ((ROWCINV15SOG00) rowcinv15soG00Enumeration.nextElement()).getUlIdEvent();
        }
        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(events, cinv14so.getROWCINV14SOG00().getUlIdCase(),
                                                     cinv14so.getROWCINV14SOG00().getUlIdStage(),
                                                     CPS_APPROVAL_TASK_CODE);
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
        state.removeAttribute(CONCLUSION_SECTION, request);
        state.removeAttribute(OVERRIDE_SECTION, request);
      }
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_RISK_FINDING_SUB:
        //errorCode = Messages.MSG_RISK_FINDING_SUB;
        setErrorMessage(Messages.MSG_RISK_FINDING_SUB, request);
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        break;

      default:
        handleError(we, context);
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user requests to Save and Submit the CPS Investigation
   * Conclusion and EA Eligibility page. Passes SAVE_SUBMIT ("U") for the setCReqFuncCd to the populateCINV15SI_Validate
   * submethod
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void validateApprv_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateApprv_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      // VALIDATE
      CINV15SI cinv15si = populateCINV15SI_Validate(context, SAVE_SUBMIT);
      CINV15SO cinv15so = investigation.saveCPSInvestigationConclusionValidation(cinv15si);
      if (cinv15so.getCINV15SOG01() != null
          && cinv15so.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().getUsSysNbrMessageCodeCount() > 0) {
        int[] errorArray = cinv15so.getCINV15SOG01().getUsSysNbrMessageCode_ARRAY().getUsSysNbrMessageCode();

        if ((errorArray.length > 0)) {
          if (errorArray.length == 1 && errorArray[0] == Messages.MSG_SVC_EVENT_PENDING
              && ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {

          } else {
            ErrorList.setErrors(errorArray, request);
            this.setPresentationBranch("error", context);
            request.setAttribute("CINV15SO", cinv15so);
          }
        }
      } else {
        CINV14SO cinv14so = (CINV14SO) state.getAttribute("CINV14SO", request);
        ROWCINV15SOG00_ARRAY rowcinv15soG00_array = cinv15so.getROWCINV15SOG00_ARRAY();
        int[] events = new int[rowcinv15soG00_array.getROWCINV15SOG00Count()];
        Enumeration rowcinv15soG00Enumeration = rowcinv15soG00_array.enumerateROWCINV15SOG00();
        int i = 0;
        while (rowcinv15soG00Enumeration.hasMoreElements()) {
          events[i++] = ((ROWCINV15SOG00) rowcinv15soG00Enumeration.nextElement()).getUlIdEvent();
        }
        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(events, cinv14so.getROWCINV14SOG00().getUlIdCase(),
                                                     cinv14so.getROWCINV14SOG00().getUlIdStage(),
                                                     CPS_APPROVAL_TASK_CODE);
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);

        state.removeAttribute(CONCLUSION_SECTION, request);
        state.removeAttribute(OVERRIDE_SECTION, request);
      }
    } catch (ServiceException we) {
      handleError(we, context);
      setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
  
  /**
   * This method is called when the user selects the Search button in the Placement/Non-Placement Provider section of CPS Investigation
   * It will copy all the current data into an object and kick off a Resource Search.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void getFacilityResource_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".getFacilityResource_xa()");

    HttpServletRequest request = context.getRequest();
    
    BaseSessionStateManager state = getSessionStateManager(context);
    try{
    //SMS 59303 Save before search
      save(context, METHOD_SAVE);

      ResourceSearchPullBackInfo resourceSearchData = new ResourceSearchPullBackInfo();
      resourceSearchData.setDestinationUrl("/investigation/CPSInvCnclsn/setFacilityResource");
      resourceSearchData.setFacilityType(ContextHelper.getStringSafe(request, "selResourceFacilityTypeSearch"));
      resourceSearchData.setResourceName(ContextHelper.getStringSafe(request, "txtNmResourceSearch"));
      //SMS#51977 MR-066Search by Resource ID 
      resourceSearchData.setIdentificationNum(ContextHelper.getStringSafe(request, "txtResourceId"));
      if(resourceSearchData.getIdentificationNum() != null){
        resourceSearchData.setIdentificationType("RSC");
      }

      resourceSearchData.setResourceStatus(CodesTables.CRSCSTAT_01);


      state.setAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST, resourceSearchData, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * SMS#51977 MR-066 This method is called by the Resource Search after a search has been completed. We will get the object returned
   * from the Resource Search, unpack it, and set the new data (Facility Name, Phone Number, etc) into the rowcinv10dog01
   * object that is displayed onLoad of the Call Information page.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void setFacilityResource_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".setResource_xa()");

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CRES03SO cres03so = (CRES03SO) request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);

    performanceTrace.msg(TRACE_TAG, 7, "cres03so: " + cres03so);

    try {
    //SMS 59303 display  after  search
      displayCPSInvCnclsn(context);
    } catch (ServiceException we) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(we.getErrorCode(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    // FACILITY DETAIL
    gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01 rowcinv10dog01 = 
        (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01) state.getAttribute("rowcinv10dog01", request);
    if (rowcinv10dog01 == null) {
      rowcinv10dog01 = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01();
    }

    rowcinv10dog01.setUlIdStage(GlobalData.getUlIdStage(request));
    rowcinv10dog01.setUlIdResource(cres03so.getUlIdResource());
    rowcinv10dog01.setSzNmResource(cres03so.getSzNmResource());
    rowcinv10dog01.setSzCdRsrcType(cres03so.getSzCdRsrcFacilType());
    rowcinv10dog01.setUlIdHomeStage(cres03so.getUlIdHomeStage());
    
    rowcinv10dog01.setNmIncmgFacilName(cres03so.getSzNmResource());
    rowcinv10dog01.setSzCdIncmgFacilType(cres03so.getSzCdRsrcFacilType());
    rowcinv10dog01.setBIndIncmgFacilSearch(ArchitectureConstants.Y);
    rowcinv10dog01.setSzCdIncFacilOperBy(cres03so.getSzCdIncFacilOperBy());
    rowcinv10dog01.setSzCdRsrcType(cres03so.getSzCdRsrcType());
    
 // This will be set using the address submodule
    Enumeration addressEnum = cres03so.getROWCRES03SOG00_ARRAY().enumerateROWCRES03SOG00();
    ROWCRES03SOG00 addressDetail = new ROWCRES03SOG00();
    while (addressEnum.hasMoreElements()) {
      addressDetail = (ROWCRES03SOG00) addressEnum.nextElement();
      if (CodesTables.CRSCADDR_01.equals(addressDetail.getSzCdRsrcAddrType())) {
        break;
      }
    }

    AddressBean facilityAddress = new AddressBean();
    facilityAddress.setAddressSubmoduleName("facilityAddress");
    facilityAddress.setAddress1(addressDetail.getSzAddrRsrcAddrStLn1());
    facilityAddress.setAddress2(addressDetail.getSzAddrRsrcAddrStLn2());
    facilityAddress.setCity(addressDetail.getSzAddrRsrcAddrCity());
    facilityAddress.setState(addressDetail.getSzCdFacilityState());
    facilityAddress.setZipAndSuff(addressDetail.getSzAddrRsrcAddrZip());
    facilityAddress.setCounty(addressDetail.getSzCdFacilityCounty());
    facilityAddress.addToRequest(request);

    Enumeration phoneEnum = cres03so.getROWCRES03SOG01_ARRAY().enumerateROWCRES03SOG01();
    ROWCRES03SOG01 phoneDetail = new ROWCRES03SOG01();
    while (phoneEnum.hasMoreElements()) {
      phoneDetail = (ROWCRES03SOG01) phoneEnum.nextElement();
      if (CodesTables.CRSCPHON_01.equals(phoneDetail.getSzCdFacilPhoneType())) {
        break;
      }
    }

    rowcinv10dog01.setSzNbrIncmgFacilPhone(phoneDetail.getLNbrFacilPhoneNumber());
    rowcinv10dog01.setSzNbrIncmgFacilPhoneExt(phoneDetail.getLNbrFacilPhoneExtension());
    rowcinv10dog01.setSzNmIncmgFacilSuprtdant(cres03so.getSzNmRsrcContact());
    
    rowcinv10dog01.setSzNmIncmgFacilAffiliated(StringHelper.EMPTY_STRING);
    rowcinv10dog01.setBIndIncmgFacilAbSupvd(StringHelper.EMPTY_STRING);
    rowcinv10dog01.setBIndIncmgOnGrnds(StringHelper.EMPTY_STRING);
    rowcinv10dog01.setSzNmUnitWard(StringHelper.EMPTY_STRING);
    rowcinv10dog01.setSzTxtFacilCmnts(StringHelper.EMPTY_STRING);


    state.setAttribute("rowcinv10dog01", rowcinv10dog01, request);
    
    state.setAttribute("rowcinv10dog01IsSet", true, request);

    request.setAttribute("resourceSearch", ArchitectureConstants.TRUE);

    CINV14SO cinv14so = (CINV14SO) state.getAttribute("CINV14SO", request);
    
    if (rowcinv10dog01 != null) {
      cinv14so.setROWCINV10DOG01(rowcinv10dog01);
      // charden SMS #114498
      request.setAttribute("rsrcSearchRow", rowcinv10dog01);
    }
    
    performanceTrace.exitScope();
  }
  
  /**
   *  SMS#51977 MR-066 This method displays displays the F/A Home Information page if a resource is associated with Home 
   *  else displays Resource Detail when Rsource ID hyperlink is clicked.
   * @param context
   */
  
  public void displayResourceDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayResourceDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    
    int ulIdResource = ContextHelper.getIntSafe(context, "idResource");
    int ulIdHomeStage = ContextHelper.getIntSafe(context, "hdnUlIdHomeStage");
    int idCase = 0;
    String nmStage = "";
    String cdStage = "";
    String stageType = "";
    org.exolab.castor.types.Date dtStageStart = null;
    
    // get stage object
    CaseUtility.Stage stage = CaseUtility.getStage(ulIdHomeStage);
    
    // get stage properties to set into Global Data
    if(stage != null){
      nmStage = stage.getNmStage();
      cdStage = stage.getCdStage();
      stageType = stage.getCdStageType();
      dtStageStart = stage.getDtStart();
      idCase = stage.getIdCase();
    }

    // If ulIdCase has been received correctly, send to case summary page
    if (ulIdResource != 0) {
      GlobalData.setUlIdResource(ulIdResource, request);
      try {
        if(stage != null){
          GlobalData.setSzCdTask("8210", request);
          GlobalData.setUlIdCase(idCase, request);
          GlobalData.setUlIdStage(ulIdHomeStage, request);
          GlobalData.setSzNmStage(nmStage, request);
          GlobalData.setSzCdStage(cdStage, request);
          GlobalData.setSzCdStageType(stageType, request);
          GlobalData.setDtDtStageStart(dtStageStart, request);
          forward(HOME_INFORMATION_CALLED, request, context.getResponse());
        }else{
          forward(RESOURCE_DETAIL_CALLED, request, context.getResponse());
        }
      } catch (ServletException se) {
        processSevereException(context, se);
      } catch (Exception e) {
        processSevereException(context, e);
      }
    }
    // If not, some sort of error
    else {
      processSevereException(
              context,
              new Exception("DEBUG:CPSInvCnclsnConversation -- Can't send to Resource Deatil without Resource ID"));
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  // protected static String getRiskAssessmentNarrativeTemplate(CINV14SO cinv14so)
  protected String getRiskAssessmentNarrativeTemplate(CINV14SO cinv14so) throws Exception {
    gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00 rowcinv14dog00 = cinv14so.getROWCINV14DOG00();
    String intranetIndicator = "";
    if(rowcinv14dog00 != null){
      intranetIndicator = rowcinv14dog00.getCIndRiskAssmtIntranet();
    }

    final String IMPACT_INDICATOR = "M";
    if ((ArchitectureConstants.Y.equals(intranetIndicator)) || (IMPACT_INDICATOR.equals(intranetIndicator))) {
      return "civ33o00";
    }

    return "";
  }

  /**
   * This helper method is called by the displayCPSInvCnclsn_xa to populate the input object for the cinv14s retrieve
   * service.
   * 
   * @param context
   *          The GrndeExchangeContext object.
   */
  private CINV14SI populateCINV14SI_Retrieve(GrndsExchangeContext context) throws ServiceException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINV14SI_Retrieve()" + new Date());
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CINV14SI cinv14si = new CINV14SI();
    ArchInputStruct input14 = new ArchInputStruct();
    input14.setUsPageNbr(1);
    input14.setBPerfInd(ArchitectureConstants.Y);
    input14.setBDataAcsInd(ArchitectureConstants.Y);
    input14.setUlPageSizeNbr(PAGE_SIZE);
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    input14.setSzUserId(String.valueOf(userID));
    cinv14si.setArchInputStruct(input14);

    int stageId = getInvestigationStageId(context);
    cinv14si.setUlIdStage(stageId);

    int eventId = CaseUtility.getEvent(stageId, CPS_INV_CONCL_TASK_CODE).getIdEvent();
    cinv14si.setUlIdEvent(eventId);
    
    Boolean rowcinv10dog01IsSet = (Boolean)state.getAttribute("rowcinv10dog01IsSet", request);
    if(rowcinv10dog01IsSet != null){
      cinv14si.setBIndRowcinv10dog01IsSet(rowcinv10dog01IsSet);
    }else{
      cinv14si.setBIndRowcinv10dog01IsSet(false);
    }
    
    performanceTrace.exitScope();
    return cinv14si;
  }

 
  /**
   * This helper method is called by the saveCPSInvCnclsn_xa and saveSubmitCPSInvCnclsn_xa to populate the input object
   * for the cinv16s service.
   */
  private CINV16SI populateCINV16S_Update(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCINV16S_Update()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // start of CINV16S save Service
    CINV14SO cinv14so = (CINV14SO) state.getAttribute("CINV14SO", request);
    if (cinv14so == null) {
      GrndsTrace.msg(TRACE_TAG, 10, "cinv14so is null - it doesn't exist in state");
    }
    ROWCINV10DOG00 rowcinv10dogoo = copyROWCINV10DOG00OutToIn(cinv14so.getROWCINV10DOG00());
    ROWCINV14SOG00 rowcinv14sogoo = copyROWCINV14SOG00OutToIn(cinv14so.getROWCINV14SOG00());
    ROWCINV14DOG00 rowcinv14dogoo = copyROWCINV14DOG00OutToIn(cinv14so.getROWCINV14DOG00());
    ROWCCMN45DO rowccmn45docinv14s = copyROWCCMN45DOOutToIn(cinv14so.getROWCCMN45DO());
    //SMS#51977 MR-066 
    ROWCINV10DOG01 rowcinv10dog01 = copyROWCINV10DOG01OutToIn(cinv14so.getROWCINV10DOG01());
    
    gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01 rowcinv10dog01Out = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01)state.getAttribute("rowcinv10dog01", request);
    
    if(rowcinv10dog01Out == null){
      rowcinv10dog01Out = new gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01();
    }

    String txtNmIncmgFacilName = ContextHelper.getStringSafe(request, "txtNmResource");
    rowcinv10dog01.setNmIncmgFacilName(txtNmIncmgFacilName);
    
    String previousFacilName = StringHelper.EMPTY_STRING;
    if(cinv14so.getROWCINV10DOG01() != null){
      if(cinv14so.getROWCINV10DOG01().getNmIncmgFacilName() != null){
        previousFacilName = cinv14so.getROWCINV10DOG01().getNmIncmgFacilName();
      }
    }
    
    //Check to see if the provider name is same as the one from the retrieved from the Search
    if(!previousFacilName.equals(txtNmIncmgFacilName)){
      //Use the resource Id from the request if the names are not same
      rowcinv10dog01.setUlIdResource(ContextHelper.getIntSafe(request, "txtResourceId"));
    }else{
      //Else use the one retrieved from the Search 
      rowcinv10dog01.setUlIdResource(cinv14so.getROWCINV10DOG01() != null ? cinv14so.getROWCINV10DOG01().getUlIdResource() : 0);
    }

    
    //SMS 59296 MR-066 New requirement to add other information under Placement/Non-Placement Provider section
    rowcinv10dog01.setUlIdStage(GlobalData.getUlIdStage(request));
    rowcinv10dog01.setSzCdIncFacilOperBy(ContextHelper.getStringSafe(request, "selSzCdIncFacilOperBy"));
    String unsupervised = ContextHelper.getStringSafe(request, "cbxBIndIncmgFacilAbSupv");
    if (unsupervised.equals(ArchitectureConstants.Y)) {
      rowcinv10dog01.setBIndIncmgFacilAbSupvd(ArchitectureConstants.Y);
    } else {
      rowcinv10dog01.setBIndIncmgFacilAbSupvd(ArchitectureConstants.N);
    }

    String offGrounds = ContextHelper.getStringSafe(request, "cbxBIndIncmgOnGrnds");
    if (offGrounds.equals(ArchitectureConstants.Y)) {
      rowcinv10dog01.setBIndIncmgOnGrnds(ArchitectureConstants.Y);
    } else {
      rowcinv10dog01.setBIndIncmgOnGrnds(ArchitectureConstants.N);
    }

    AddressBean facilityAddress = AddressBean.getFromRequest("facilityAddress", request);
    if (facilityAddress == null) {
      facilityAddress = new AddressBean();
    }
    rowcinv10dog01.setSzAddrIncmgFacilStLn1(facilityAddress.getAddress1());
    rowcinv10dog01.setSzAddrIncmgFacilStLn2(facilityAddress.getAddress2());
    rowcinv10dog01.setSzAddrIncmgFacilZip(facilityAddress.getZipAndSuff());
    rowcinv10dog01.setSzCdIncmgFacilCnty(facilityAddress.getCounty());
    rowcinv10dog01.setSzAddrIncmgFacilCity(facilityAddress.getCity());
    rowcinv10dog01.setSzCdIncmgFacilState(facilityAddress.getState()); 
    String selSzCdIncmgFacilType = ContextHelper.getStringSafe(request, "selSzCdIncmgFacilType");
    rowcinv10dog01.setSzCdIncmgFacilType(selSzCdIncmgFacilType);

    String txtSzNbrIncmgFacilPhone = ContextHelper.getPhoneSafe(request, "txtSzNbrIncmgFacilPhone");
    rowcinv10dog01.setSzNbrIncmgFacilPhone(txtSzNbrIncmgFacilPhone);

    String txtSzNbrIncmgFacilPhoneExt = ContextHelper.getStringSafe(request, "txtSzNbrIncmgFacilPhoneExt");
    rowcinv10dog01.setSzNbrIncmgFacilPhoneExt(txtSzNbrIncmgFacilPhoneExt);

    String txtSzNmUnitWard = ContextHelper.getStringSafe(request, "txtSzNmUnitWard");
    rowcinv10dog01.setSzNmUnitWard(txtSzNmUnitWard);

    String txtSzNmIncmgFacilAffiliated = ContextHelper.getStringSafe(request, "txtSzNmIncmgFacilAffiliated");
    rowcinv10dog01.setSzNmIncmgFacilAffiliated(txtSzNmIncmgFacilAffiliated);

    String txtSzTxtFacilCmnts = ContextHelper.getStringSafe(request, "txtSzTxtFacilCmnts");
    rowcinv10dog01.setSzTxtFacilCmnts(txtSzTxtFacilCmnts);

    String txtSzNmIncmgFacilSuprtdant = ContextHelper.getStringSafe(request, "txtSzNmIncmgFacilSuprtdant");
    rowcinv10dog01.setSzNmIncmgFacilSuprtdant(txtSzNmIncmgFacilSuprtdant);

    CINV16SI cinv16si = new CINV16SI();
    ArchInputStruct input16s = new ArchInputStruct();

    // Set the values for the ArchInputStruct
    input16s.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input16s.setBPerfInd(ArchitectureConstants.Y);
    //input16s.setBDataAcsInd(ArchitectureConstants.Y);
    input16s.setUsPageNbr(1);
    input16s.setSzUserId(UserProfileHelper.getUserProfile(context).getUserLogonID());
    // removed in release 2

    rowcinv10dogoo.setDtDtCPSInvstDtlAssigned(ContextHelper.getCastorDateSafe(request, "IntAssigned"));
    rowcinv10dogoo.setTsLastUpdate(cinv14so.getROWCINV10DOG00().getTsLastUpdate());
    // Conclusion section
    String overallRiskFinding = ContextHelper.getStringSafe(request, "selSzCdStageRiskFinding");
    rowcinv10dogoo.setSzCdStageRiskFinding(overallRiskFinding);
    rowcinv10dogoo.setSzCdStageLvlOfRisk(ContextHelper.getStringSafe(request, "selSzCdStageLvlOfRisk"));
    rowcinv10dogoo.setDtDtOverride(ContextHelper.getCastorDateSafe(request, "txtDtOverride"));
    String supervisorOverallFinding = ContextHelper.getStringSafe(request, "selSzCdOverrideOverllFind");
    rowcinv10dogoo.setSzCdOverrideOverllFind(supervisorOverallFinding);
    rowcinv10dogoo.setSzCdOverrideRiskLvl(ContextHelper.getStringSafe(request, "selSzCdOverrideRiskLvl"));
    rowcinv10dogoo.setSzTxtOverrideComments(ContextHelper.getStringSafe(request, "txtSzTxtOverrideComments"));
    // SIR 22986 End

    rowcinv10dogoo.setCdFamviol01(CheckboxHelper.getCheckboxValue(request, "cbxFamviol_01"));
    rowcinv10dogoo.setCdFamviol02(CheckboxHelper.getCheckboxValue(request, "cbxFamviol_02"));
    rowcinv10dogoo.setCdFamviol03(CheckboxHelper.getCheckboxValue(request, "cbxFamviol_03"));
    rowcinv10dogoo.setCdFamviol04(CheckboxHelper.getCheckboxValue(request, "cbxFamviol_04"));
    rowcinv10dogoo.setCdFamviol05(CheckboxHelper.getCheckboxValue(request, "cbxFamviol_05"));

    rowcinv10dogoo.setCIndSpeInvstPlaceProv(ContextHelper.getStringSafe(request, "rbSpeInv"));
    //SMS 51977: MR-066 Maltreatment in care
    rowcinv10dogoo.setCIndInvMaltreatInCare(ContextHelper.getStringSafe(request, "rbInvMaltreatInCare"));
    rowcinv10dogoo.setCIndPolicyViolation(ContextHelper.getStringSafe(request, "rbIndPolicyViolation"));
    
    rowcinv10dogoo.setCIndFostPrntNotified(ContextHelper.getStringSafe(request, "rbFostPrnt"));
    // STGAP00017941: Added a new comment field for foster parent notification
    rowcinv10dogoo.setSzTxtFostPrntNotifyCmnts(ContextHelper.getStringSafe(request, "txtSzTxtFostPrntNotifyCmnts"));
    rowcinv10dogoo.setCIndStOffNotifyRmvChild(ContextHelper.getStringSafe(request, "rbStOffNotified"));
    rowcinv10dogoo.setDtDtFostPrntNotified(ContextHelper.getCastorDateSafe(request, "dtDtFostPrntNotified"));
    rowcinv10dogoo.setDtDtStOffNotifyRmvChild(ContextHelper.getCastorDateSafe(request, "dtDtStOffNotified"));
    rowcinv10dogoo.setDtDtStOffAdviceRmvChild(ContextHelper.getCastorDateSafe(request, "dtDtStOffAdvised"));
    rowcinv10dogoo.setDtDtCpsInvstDtlComplt(ContextHelper.getCastorDateSafe(request, "dtDtCpsInvstDtlComplt"));
    rowcinv10dogoo.setDtDetermLetterSent(ContextHelper.getCastorDateSafe(request, "dtDetermLetterSent"));
    String abuseStatus = ContextHelper.getStringSafe(request, "rbAbuseStatus");

    if (abuseStatus != null && !(abuseStatus.equals(""))) {
      rowcinv10dogoo.setCdAbuseStatus(abuseStatus);
    }

    rowcinv10dogoo.setCdAbuseType01(CheckboxHelper.getCheckboxValue(request, "cbxAbuseType_01"));
    rowcinv10dogoo.setCdAbuseType02(CheckboxHelper.getCheckboxValue(request, "cbxAbuseType_02"));
    rowcinv10dogoo.setCdAbuseType03(CheckboxHelper.getCheckboxValue(request, "cbxAbuseType_03"));
    rowcinv10dogoo.setCdAbuseType04(CheckboxHelper.getCheckboxValue(request, "cbxAbuseType_04"));
    rowcinv10dogoo.setCdAbuseType05(CheckboxHelper.getCheckboxValue(request, "cbxAbuseType_05"));
    rowcinv10dogoo.setCdAbuseType06(CheckboxHelper.getCheckboxValue(request, "cbxAbuseType_06"));
    rowcinv10dogoo.setCdAbuseType07(CheckboxHelper.getCheckboxValue(request, "cbxAbuseType_07"));

    rowcinv10dogoo.setCdMaltreatLoc(ContextHelper.getStringSafe(request, "selSzMaltreamentOccure"));

    rowcinv14dogoo.setTsLastUpdate(cinv14so.getROWCINV14DOG00().getTsLastUpdate());
    if (!"".equals(supervisorOverallFinding)) {
      rowcinv14sogoo.setSzCdStageReasonClosed(supervisorOverallFinding);
    } else {
      rowcinv14sogoo.setSzCdStageReasonClosed(overallRiskFinding);
    }
    //rowcinv14sogoo.setTsLastUpdate(cinv14so.getROWCINV14SOG00().getTsLastUpdate());
    rowcinv14sogoo.setUlIdCase(GlobalData.getUlIdCase(request));
    
    //rowcinv14sogoo.setUlIdStage(GlobalData.getUlIdStage(request));
    String indStageIsINV = ArchitectureConstants.Y;
    int idStage = GlobalData.getUlIdStage(request);
    String cdStage = GlobalData.getSzCdStage(request);
    // Corey - do not check to see if stage is closed if a special investigation is open
    String spiModify = StringHelper.getNonNullString(request.getParameter("spiModify"));
    boolean isSpecialInv = false;
    if(CodesTables.CSTAGES_ARI.equals(cdStage)) {
      idStage = getPriorInvestigationStageId(context);
      indStageIsINV = ArchitectureConstants.N;
    }else if(ArchitectureConstants.Y.equals(spiModify)){
      isSpecialInv = true;
    }
    rowcinv14sogoo.setUlIdStage(idStage);
    input16s.setBDataAcsInd(isSpecialInv ? ArchitectureConstants.N : indStageIsINV);
    
    //rowccmn45docinv14s.setUlIdStage(GlobalData.getUlIdStage(request));
    rowccmn45docinv14s.setUlIdStage(idStage);
    
    rowccmn45docinv14s.setTsLastUpdate(cinv14so.getROWCCMN45DO().getTsLastUpdate());
    // Sir 18795 use today's date for when the event occured
    rowccmn45docinv14s.setDtDtEventOccurred(DateHelper.toCastorDate(new java.util.Date()));
    
    //-- do a quick check for idPerson which ends up in EVENT.ID_EVENT_PERSON when postEvent is called
    if(rowccmn45docinv14s.getUlIdPerson() < 1) {
      UserProfile user = UserProfileHelper.getUserProfile(request);
      rowccmn45docinv14s.setUlIdPerson(user.getUserID());
    }
    
    cinv16si.setArchInputStruct(input16s);
    // HD SIR 17847
    String bIndChckd = ContextHelper.getStringSafe(request, "bIndChkd");
    cinv16si.setBIndChkd(bIndChckd);
    cinv16si.setROWCINV10DOG00(rowcinv10dogoo);
    cinv16si.setROWCINV14SOG00(rowcinv14sogoo);
    cinv16si.setROWCINV14DOG00(rowcinv14dogoo);
    cinv16si.setROWCCMN45DO(rowccmn45docinv14s);
    //SMS#51977 MR-066
    cinv16si.setROWCINV10DOG01(rowcinv10dog01);

    performanceTrace.exitScope();
    return cinv16si;
  }

  /**
   * This helper method is called by the saveSubmitCPSInvCnclsn_xa to populate the input object for the cinv15s validate
   * service.
   */
  private CINV15SI populateCINV15SI_Validate(GrndsExchangeContext context, String reqFuncCd) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINV15SI_Validate()" + new Date());
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CINV14SO cinv14so = (CINV14SO) state.getAttribute("CINV14SO", request);
    gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO rowccmn45do = cinv14so.getROWCCMN45DO();
    // gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00 rowcinv14dogoo = cinv14so.getROWCINV14DOG00();
    gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00 rowcinv10dogoo = cinv14so.getROWCINV10DOG00();

    ArchInputStruct input = new ArchInputStruct();
    CINV15SI cinv15si = new CINV15SI();
    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(reqFuncCd);
    input.setBPerfInd(ArchitectureConstants.Y);
    input.setBDataAcsInd(ArchitectureConstants.Y);
    input.setUsPageNbr(1);
    // MDM added 6/2/2003
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    input.setSzUserId(UserProfileHelper.getUserProfile(context).getUserLogonID());

    cinv15si.setArchInputStruct(input);
    cinv15si.setDtDtCPSInvstDtlBegun(ContextHelper.getCastorDateSafe(request, "InvInitiated"));
    cinv15si.setSzCdTask(rowccmn45do.getSzCdTask());
    cinv15si.setSzCdRiskAssmtRiskFind(ContextHelper.getStringSafe(request, "txtSzCdRiskAssmtRiskFind"));
    cinv15si.setUlIdStage(GlobalData.getUlIdStage(request));
    cinv15si.setUlIdEvent(rowccmn45do.getUlIdEvent());
    cinv15si.setBIndCpsInvstEaConcl(rowcinv10dogoo.getBIndCpsInvstEaConcl());
    String overallRiskFinding = ContextHelper.getStringSafe(request, "selSzCdStageRiskFinding");
    cinv15si.setSzDcdEditProcess(Lookup.simpleDecodeSafe("CCPSCLED", overallRiskFinding));
    cinv15si.setUlIdCase(GlobalData.getUlIdCase(request));
    String supervisorOverallFinding = ContextHelper.getStringSafe(request, "selSzCdOverrideOverllFind");
    if (!StringHelper.EMPTY_STRING.equals(supervisorOverallFinding)) {
      cinv15si.setSzCdStageReasonClosed(supervisorOverallFinding);
    } else {
      cinv15si.setSzCdStageReasonClosed(overallRiskFinding);
    }
    cinv15si.setSzCdPersonDeath(StringHelper.EMPTY_STRING);
    //CAPTA Changes Added. Adding Overall Disposition to the SI object
    cinv15si.setCdCpsOverallDisptn(rowcinv10dogoo.getCdCpsOverallDisptn());
    
    // SWR 06/04/2006 STGAP00009080 - Never run check if disposition is 'Opened In Error'
    if (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request)) || CodesTables.CCRSKFND_06.equals(cinv15si.getSzCdStageReasonClosed())) {
      cinv15si.setBIndValidateAssessments(ArchitectureConstants.N);
    } else {
      cinv15si.setBIndValidateAssessments(ArchitectureConstants.Y);
    }

    performanceTrace.exitScope();
    return cinv15si;
  }

  /**
   * This helper method handles all the WTC Exceptions thrown by the Save and Validate services. Called by the following
   * methods: saveCPSInvCnclsn_xa & saveSubmitCPSInvCnclsn_xa
   * 
   * @param we
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SYS_MULT_INST:
      setErrorMessage(we.getErrorCode(), request);
      break;
    default:
      processSevereException(context, we);
      break;
    }
  }

  /**
   * This helper method copies the ROWCINV10DOG00 output object of the retrieve service to the ROWCINV10DOG00 input
   * object for the save. Since the two objects have the same name, we are able to unmarshall the data from the output
   * object INTO the input object.
   * 
   * @param rowcinv10doG00
   *          ROWCINV10DOG00 inputstruct
   */
  private ROWCINV10DOG00 copyROWCINV10DOG00OutToIn(
                                                   gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG00 rowcinv10doG00) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "copyROWCINV10DOG00OutToIn()" + new Date());
    performanceTrace.enterScope();

    ROWCINV10DOG00 newRow = new ROWCINV10DOG00();
    if (rowcinv10doG00 == null) {
      return newRow;
    }

    if (rowcinv10doG00.hasUlIdEvent()) {
      newRow.setUlIdEvent(rowcinv10doG00.getUlIdEvent());
    }
    if (rowcinv10doG00.hasUlIdPriorStage()) {
      newRow.setUlIdPriorStage(rowcinv10doG00.getUlIdPriorStage());
    }
    if (rowcinv10doG00.hasUlIdStage()) {
      newRow.setUlIdStage(rowcinv10doG00.getUlIdStage());
    }
    newRow.setBIndCpsInvstCpsLeJointContact(rowcinv10doG00.getBIndCpsInvstCpsLeJointContact());
    newRow.setBIndCpsInvstEaConcl(rowcinv10doG00.getBIndCpsInvstEaConcl());
    newRow.setBIndCpsInvstSafetyPln(rowcinv10doG00.getBIndCpsInvstSafetyPln());
    newRow.setBIndVictimTaped(rowcinv10doG00.getBIndVictimTaped());
    newRow.setCdCpsOverallDisptn(rowcinv10doG00.getCdCpsOverallDisptn());
    newRow.setCIndCpsInvstAbbrv(rowcinv10doG00.getCIndCpsInvstAbbrv());
    newRow.setCIndCpsInvstDtlRaNa(rowcinv10doG00.getCIndCpsInvstDtlRaNa());
    newRow.setDtDtCPSInvstDtlAssigned(rowcinv10doG00.getDtDtCPSInvstDtlAssigned());
    newRow.setDtDtCPSInvstDtlBegun(rowcinv10doG00.getDtDtCPSInvstDtlBegun());
    newRow.setDtDtCpsInvstDtlComplt(rowcinv10doG00.getDtDtCpsInvstDtlComplt());
    newRow.setDtDtCPSInvstDtlIntake(rowcinv10doG00.getDtDtCPSInvstDtlIntake());
    newRow.setDtDtOverride(rowcinv10doG00.getDtDtOverride());
    String bModeDataInd = rowcinv10doG00.getBMoreDataInd();
    if (bModeDataInd != null && !StringHelper.EMPTY_STRING.equals(bModeDataInd)) {
      newRow.setMoreDataAvailable(Boolean.parseBoolean(bModeDataInd));
    }
    newRow.setSzCdCpsInvstCpsLeJointContact(rowcinv10doG00.getSzCdCpsInvstCpsLeJointContact());
    newRow.setSzCdCpsInvstDtlFamIncm(rowcinv10doG00.getSzCdCpsInvstDtlFamIncm());
    newRow.setSzCdOverrideOverllFind(rowcinv10doG00.getSzCdOverrideOverllFind());
    newRow.setSzCdOverrideRiskLvl(rowcinv10doG00.getSzCdOverrideRiskLvl());
    newRow.setSzCdStageLvlOfRisk(rowcinv10doG00.getSzCdStageLvlOfRisk());
    newRow.setSzCdStageRiskFinding(rowcinv10doG00.getSzCdStageRiskFinding());
    newRow.setSzCdVictimTaped(rowcinv10doG00.getSzCdVictimTaped());
    newRow.setSzTxtCpsInvstCpsLeJointContact(rowcinv10doG00.getSzTxtCpsInvstCpsLeJointContact());
    newRow.setSzTxtOverrideComments(rowcinv10doG00.getSzTxtOverrideComments());
    newRow.setSzTxtOvrllCaseDisptn(rowcinv10doG00.getSzTxtOvrllCaseDisptn());
    newRow.setSzTxtVictimTaped(rowcinv10doG00.getSzTxtVictimTaped());
    newRow.setTsLastUpdate(rowcinv10doG00.getTsLastUpdate());
    newRow.setCIndUnsubMIC(rowcinv10doG00.getCIndUnsubMIC());

    performanceTrace.exitScope();
    return newRow;
  }

  /**
   * This helper method copies the ROWCINV14SOG00 output object of the retrieve service to the ROWCINV14SOG00 input
   * object for the save. Since the two objects have the same name, we are able to unmarshall the data from the output
   * object INTO the input object.
   * 
   * @param rowcinv14soG00
   *          ROWCINV14SOG00 inputstruct
   */
  private ROWCINV14SOG00 copyROWCINV14SOG00OutToIn(
                                                   gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14SOG00 rowcinv14soG00) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "copyROWCINV14SOG00OutToIn()" + new Date());
    performanceTrace.enterScope();

    ROWCINV14SOG00 newRow = new ROWCINV14SOG00();
    if (rowcinv14soG00 == null) {
      return newRow;
    }

    if (rowcinv14soG00.hasUlIdCase()) {
      newRow.setUlIdCase(rowcinv14soG00.getUlIdCase());
    }
    if (rowcinv14soG00.hasUlIdSituation()) {
      newRow.setUlIdSituation(rowcinv14soG00.getUlIdSituation());
    }
    if (rowcinv14soG00.hasUlIdStage()) {
      newRow.setUlIdStage(rowcinv14soG00.getUlIdStage());
    }
    if (rowcinv14soG00.hasUlIdUnit()) {
      newRow.setUlIdUnit(rowcinv14soG00.getUlIdUnit());
    }
    newRow.setBIndStageClose(rowcinv14soG00.getBIndStageClose());
    newRow.setDtDtStageClose(rowcinv14soG00.getDtDtStageClose());
    newRow.setDtDtStageStart(rowcinv14soG00.getDtDtStageStart());
    String bMoreDataInd = rowcinv14soG00.getBMoreDataInd();
    if (bMoreDataInd != null && !StringHelper.EMPTY_STRING.equals(bMoreDataInd)) {
      newRow.setMoreDataAvailable(Boolean.parseBoolean(bMoreDataInd));
    }
    newRow.setSzCdStage(rowcinv14soG00.getSzCdStage());
    newRow.setSzCdStageClassification(rowcinv14soG00.getSzCdStageClassification());
    newRow.setSzCdStageCnty(rowcinv14soG00.getSzCdStageCnty());
    newRow.setSzCdStageCurrPriority(rowcinv14soG00.getSzCdStageCurrPriority());
    newRow.setSzCdStageInitialPriority(rowcinv14soG00.getSzCdStageInitialPriority());
    newRow.setSzCdStageProgram(rowcinv14soG00.getSzCdStageProgram());
    newRow.setSzCdStageReasonClosed(rowcinv14soG00.getSzCdStageReasonClosed());
    newRow.setSzCdStageRegion(rowcinv14soG00.getSzCdStageRegion());
    newRow.setSzCdStageRsnPriorityChgd(rowcinv14soG00.getSzCdStageRsnPriorityChgd());
    newRow.setSzCdStageType(rowcinv14soG00.getSzCdStageType());
    newRow.setSzNmStage(rowcinv14soG00.getSzNmStage());
    newRow.setSzTxtStageClosureCmnts(rowcinv14soG00.getSzTxtStageClosureCmnts());
    newRow.setSzTxtStagePriorityCmnts(rowcinv14soG00.getSzTxtStagePriorityCmnts());
    newRow.setTmSysTmStageClose(rowcinv14soG00.getTmSysTmStageClose());
    newRow.setTmSysTmStageStart(rowcinv14soG00.getTmSysTmStageStart());
    newRow.setTsLastUpdate(rowcinv14soG00.getTsLastUpdate());

    performanceTrace.exitScope();
    return newRow;
  }

  /**
   * This helper method copies the ROWCINV14DOG00 output object of the retrieve service to the ROWCINV14DOG00 input
   * object for the save. Since the two objects have the same name, we are able to unmarshall the data from the output
   * object INTO the input object.
   * 
   * @param rowcinv14doG00
   *          ROWCINV14DOG00 inputstruct
   */
  private ROWCINV14DOG00 copyROWCINV14DOG00OutToIn(
                                                   gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV14DOG00 rowcinv14doG00) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "copyROWCINV14DOG00OutToIn()" + new Date());
    performanceTrace.enterScope();

    ROWCINV14DOG00 newRow = new ROWCINV14DOG00();
    if (rowcinv14doG00 == null) {
      return newRow;
    }

    if (rowcinv14doG00.hasUlIdEvent()) {
      newRow.setUlIdEvent(rowcinv14doG00.getUlIdEvent());
    }
    if (rowcinv14doG00.hasUlIdStage()) {
      newRow.setUlIdStage(rowcinv14doG00.getUlIdStage());
    }
    newRow.setCdRiskAssmtPurpose(rowcinv14doG00.getCdRiskAssmtPurpose());
    newRow.setCIndRiskAssmtIntranet(rowcinv14doG00.getCIndRiskAssmtIntranet());
    String bMoreDataInd = rowcinv14doG00.getBMoreDataInd();
    if (bMoreDataInd != null && !"".equals(bMoreDataInd)) {
      newRow.setMoreDataAvailable(Boolean.parseBoolean(bMoreDataInd));
    }
    newRow.setSzCdRiskAssmtApAccess(rowcinv14doG00.getSzCdRiskAssmtApAccess());
    newRow.setSzCdRiskAssmtRiskFind(rowcinv14doG00.getSzCdRiskAssmtRiskFind());
    newRow.setSzCdRiskFactorCateg(rowcinv14doG00.getSzCdRiskFactorCateg());
    newRow.setTsLastUpdate(rowcinv14doG00.getTsLastUpdate());

    performanceTrace.exitScope();
    return newRow;
  }

  /**
   * This helper method copies the ROWCCMN45DO output object of the retrieve service to the ROWCCMN45DO input object for
   * the save. Since the two objects have the same name, we are able to unmarshall the data from the output object INTO
   * the input object.
   * 
   * @param rowccmn45do
   *          ROWCCMN45DO inputstruct
   */
  private ROWCCMN45DO copyROWCCMN45DOOutToIn(gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO rowccmn45do) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "copyROWCCMN45DOOutToIn()" + new Date());
    performanceTrace.enterScope();

    ROWCCMN45DO newRow = new ROWCCMN45DO();
    if (rowccmn45do == null) {
      return newRow;
    }

    if (rowccmn45do.hasUlIdEvent()) {
      newRow.setUlIdEvent(rowccmn45do.getUlIdEvent());
    }
    if (rowccmn45do.hasUlIdPerson()) {
      newRow.setUlIdPerson(rowccmn45do.getUlIdPerson());
    }
    if (rowccmn45do.hasUlIdStage()) {
      newRow.setUlIdStage(rowccmn45do.getUlIdStage());
    }
    newRow.setDtDtEventOccurred(rowccmn45do.getDtDtEventOccurred());
    String bMoreDataInd = rowccmn45do.getBMoreDataInd();
    if (bMoreDataInd != null && !"".equals(bMoreDataInd)) {
      newRow.setMoreDataAvailable(Boolean.parseBoolean(bMoreDataInd));
    }
    newRow.setSzCdEventStatus(rowccmn45do.getSzCdEventStatus());
    newRow.setSzCdEventType(rowccmn45do.getSzCdEventType());
    newRow.setSzCdTask(rowccmn45do.getSzCdTask());
    newRow.setSzTxtEventDescr(rowccmn45do.getSzTxtEventDescr());
    newRow.setTsLastUpdate(rowccmn45do.getTsLastUpdate());

    performanceTrace.exitScope();
    return newRow;
  }
  
  /**
   * SMS#51977 MR-066 This helper method copies the ROWCINV10DOG01 output object of the retrieve service to the ROWCINV10DOG01 input
   * object for the save. Since the two objects have the same name, we are able to unmarshall the data from the output
   * object INTO the input object.
   * 
   * @param rowcinv10doG01
   *          ROWCINV10DOG01 inputstruct
   */
  private ROWCINV10DOG01 copyROWCINV10DOG01OutToIn(
                                                   gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01 rowcinv10doG01) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "copyROWCINV10DOG01OutToIn()" + new Date());
    performanceTrace.enterScope();

    ROWCINV10DOG01 newRow = new ROWCINV10DOG01();
    if (rowcinv10doG01 == null) {
      return newRow;
    }

    newRow.setUlIdResource(rowcinv10doG01.getUlIdResource());
    //SMS 59296 MR-066 Add other information to the Provider section
    newRow.setBIndIncmgFacilAbSupvd(rowcinv10doG01.getBIndIncmgFacilAbSupvd());
    newRow.setBIndIncmgFacilSearch(rowcinv10doG01.getBIndIncmgFacilSearch());
    newRow.setBIndIncmgOnGrnds(rowcinv10doG01.getBIndIncmgOnGrnds());
    newRow.setNmIncmgFacilName(rowcinv10doG01.getNmIncmgFacilName());
    newRow.setSzAddrIncmgFacilCity(rowcinv10doG01.getSzAddrIncmgFacilCity());
    newRow.setSzAddrIncmgFacilStLn1(rowcinv10doG01.getSzAddrIncmgFacilStLn1());
    newRow.setSzAddrIncmgFacilStLn2(rowcinv10doG01.getSzAddrIncmgFacilStLn2());
    newRow.setSzAddrIncmgFacilZip(rowcinv10doG01.getSzAddrIncmgFacilZip());
    newRow.setSzCdIncFacilOperBy(rowcinv10doG01.getSzCdIncFacilOperBy());
    newRow.setSzCdIncmgFacilCnty(rowcinv10doG01.getSzCdIncmgFacilCnty());
    newRow.setSzCdIncmgFacilState(rowcinv10doG01.getSzCdIncmgFacilState());
    newRow.setSzCdIncmgFacilState(rowcinv10doG01.getSzCdIncmgFacilState());
    newRow.setSzNbrIncmgFacilPhone(rowcinv10doG01.getSzNbrIncmgFacilPhone());
    newRow.setSzNbrIncmgFacilPhoneExt(rowcinv10doG01.getSzNbrIncmgFacilPhoneExt());
    newRow.setSzNmIncmgFacilAffiliated(rowcinv10doG01.getSzNmIncmgFacilAffiliated());
    newRow.setSzNmIncmgFacilSuprtdant(rowcinv10doG01.getSzNmIncmgFacilSuprtdant());
    newRow.setSzNmUnitWard(rowcinv10doG01.getSzNmUnitWard());
    newRow.setSzTxtFacilCmnts(rowcinv10doG01.getSzTxtFacilCmnts());
    newRow.setUlIdStage(rowcinv10doG01.getUlIdStage());
    
    performanceTrace.exitScope();
    return newRow;
  }


  private void save(GrndsExchangeContext context, int method) throws Exception {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "save()" + new Date());
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // SIR 19188 - Get the original value of the Safety Plan Completed checkbox
      // from state and put it into the request for use by populateCINV16S_Update()
      // below. We can't use the value from the retrieve that happens below because
      // the value could be different.
      CINV14SO cinv14so = (CINV14SO) state.getAttribute("CINV14SO", request);

      CINV14SI cinv14si = populateCINV14SI_Retrieve(context);
      cinv14so = investigation.retrieveCPSInvestigationConclusion(cinv14si);
      
      //MR-066 If the search button is clicked to get the Provider Information then set that information in the SO object to be saved.
      if(cinv14si.getBIndRowcinv10dog01IsSet()){
        gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01 rowcinv10dog01 = (gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV10DOG01)state.getAttribute("rowcinv10dog01", request);
        cinv14so.setROWCINV10DOG01(rowcinv10dog01);
      }
      
      state.setAttribute("CINV14SO", cinv14so, request);

      CINV16SI cinv16si = populateCINV16S_Update(context);
      cinv16si.getROWCINV10DOG00().setTsLastUpdate(cinv14so.getROWCINV10DOG00().getTsLastUpdate());

      // -- eventStatus represents the current status retrieved from the db
      String eventStatus = cinv16si.getROWCCMN45DO().getSzCdEventStatus();
      
      //STGAP00009916 - added code to perform check on Principal children in case to make sure
      //all children have been removed if the overall risk finding chosen is 'RISK INDICATED/OPEN FOR SERVICES'
      String saveTask = method == 0 ? SAVE : SAVEANDSUBMIT;
      String overallRiskFinding = ContextHelper.getStringSafe(request, "selSzCdStageRiskFinding");
      if (SAVE.equals(saveTask) && "05".equals(overallRiskFinding)) {
        CINV15SI cinv15si = new CINV15SI();
        cinv15si.setUlIdStage(GlobalData.getUlIdStage(request));
        cinv15si.setSzCdTask(saveTask);
        try {
          CINV15SO cinv15so = investigation.saveCPSInvestigationConclusionValidation(cinv15si);
        } catch (ServiceException we) {
          int errorCode = we.getErrorCode();
          if (errorCode == Messages.MSG_RISK_FINDING_SUB) {
            setErrorMessage(Messages.MSG_RISK_FINDING_SUB, request);
            this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
          } else {
            handleError(we, context);
          }
        }
      }

      // -- Now reset the event status
      switch (method) {
      case METHOD_SAVE:
        CaseUtility.Stage stage = CaseUtility.getStage(GlobalData.getUlIdStage(request));
        if(stage != null && ArchitectureConstants.Y.equals(stage.getIndStageClose())){
          cinv16si.getROWCCMN45DO().setSzCdEventStatus(EVENT_STATUS_APPROVED);
        }else{
          cinv16si.getROWCCMN45DO().setSzCdEventStatus(EVENT_STATUS_IN_PROCESS);
        }
        break;
      case METHOD_SAVE_SUBMIT:
        // -- Actually, if the Save and Submit button was clicked, all related events will
        // -- be set to COMP when the SaveCPSInvestigationConclusionValidation service is called.
        // -- But this serves as kind of a backup.
        cinv16si.getROWCCMN45DO().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
        break;
      }

      if (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request)) && EVENT_STATUS_PENDING.equals(eventStatus)) {
        // -- Okay, we're in the investigation stage and the conclusion event is PEND.
        // -- If not the supervisor, invalidate the current open approval event.
        if (!isCurrentActiveApprover(context)) {
          CCMN05UI ccmn05ui = new CCMN05UI();
          ccmn05ui.setUlIdEvent(GlobalData.getUlIdEvent(request));
          ArchInputStruct ais = new ArchInputStruct();
          ais.setUlSysNbrReserved1(ArchitectureConstants.N);
          ccmn05ui.setArchInputStruct(ais);
          try {
            admin.invalidateApproval(ccmn05ui);
          } catch (ServiceException se) {
            handleError(se, context);
          }
        }
        // -- Else, user is the supervisor, so keep the event status as PEND and do not
        // -- invalidate the current approval event.
        else {
          cinv16si.getROWCCMN45DO().setSzCdEventStatus(EVENT_STATUS_PENDING);
        }
      } // else if()

      investigation.saveCPSInvestigationConclusion(cinv16si);

    } finally {
      // end the transaction
      // WtcHelper.endTuxedoTransaction(wth);
    }
    performanceTrace.exitScope();
  }

  private int getInvestigationStageId(GrndsExchangeContext context) throws ServiceException {
    HttpServletRequest request = context.getRequest();
    if (GlobalData.getSzCdStage(request).equals(CodesTables.CSTAGES_INV)) {
      return GlobalData.getUlIdStage(request);
    }
    return getPriorInvestigationStageId(context);
  }

  /** Gets the id of the prior stage for a given stage (and ensures it's an INVESTIGATION stage) */
  // public int getPriorInvestigationStageId(GrndsExchangeContext context)
  public int getPriorInvestigationStageId(GrndsExchangeContext context) {
    CCMN50SO ccmn50so = callCCMN50S(context);
    int priorStageId = ccmn50so.getUlIdPriorStage();

    CaseUtility.Stage stage = CaseUtility.getStage(priorStageId);
    if (stage.getCdStage().equals(CodesTables.CSTAGES_INV)) {
      return priorStageId;
    }else if (stage.getCdStage().equals(CodesTables.CSTAGES_FSU)) {
      CCMN50SO invPriorToFcfStage = getInvPriorToFCF(context, priorStageId);
      priorStageId = invPriorToFcfStage.getUlIdPriorStage();
      return priorStageId;
    }
    throw new ServiceException(Messages.MSG_INV_NO_EXISTS);
  }

  /** Find prior Stage Id */
  // protected CCMN50SO callCCMN50S(GrndsExchangeContext context)
  private CCMN50SO callCCMN50S(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setSzUserId((UserProfileHelper.getUserProfile(request).getUserLogonID()));
    CCMN50SI ccmn50si = new CCMN50SI();
    int stageId = (GlobalData.getUlIdStage(request));
    ccmn50si.setUlIdStage(stageId);
    ccmn50si.setCIndTaskRtrvPriorStage("1");

    try {

      CCMN50SO ccmn50so = retrieveTaskList.findTaskListEvents(ccmn50si);

      return ccmn50so;
    } catch (ServiceException e) {
      int errorCode = e.getErrorCode();
      if ((errorCode == Messages.SQL_NOT_FOUND) || ((errorCode == 0) && (e.getErrorCode() == Messages.SQL_NOT_FOUND))) {
        throw new ServiceException(Messages.MSG_INV_NO_EXISTS);
      }
      throw e;
    }
  }

  private CCMN50SO getInvPriorToFCF(GrndsExchangeContext context, int priorStageId) {
    HttpServletRequest request = context.getRequest();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setSzUserId((UserProfileHelper.getUserProfile(request).getUserLogonID()));
    CCMN50SI ccmn50si = new CCMN50SI();
    int stageId = priorStageId;
    ccmn50si.setUlIdStage(stageId);
    ccmn50si.setCIndTaskRtrvPriorStage("1");

    try {

      CCMN50SO ccmn50so = retrieveTaskList.findTaskListEvents(ccmn50si);

      return ccmn50so;
    } catch (ServiceException e) {
      int errorCode = e.getErrorCode();
      if ((errorCode == Messages.SQL_NOT_FOUND) || ((errorCode == 0) && (e.getErrorCode() == Messages.SQL_NOT_FOUND))) {
        throw new ServiceException(Messages.MSG_INV_NO_EXISTS);
      }
      throw e;
    }
  }
  /*
   * determines whether the user is the case manager assigned to this case / private boolean
   * isCaseMngrAssignedToCase(int userID, GrndsExchangeContext context) { int ulIdStage =
   * GlobalData.getUlIdStage(context.getRequest()); return CaseUtility.hasStageAccess(userID, ulIdStage); } /*
   * determines whether the user is the case manager assigned to this case / private boolean
   * isCaseMngrAssignedToCase(GrndsExchangeContext context) { int ulIdStage =
   * GlobalData.getUlIdStage(context.getRequest()); int userID = UserProfileHelper.getUserProfile(context).getUserID();
   * return CaseUtility.hasStageAccess(userID, ulIdStage); } /* determines whether the user has access rights to modify
   * the stage / private boolean hasStageAccessRights(int userID, GrndsExchangeContext context) { int ulIdStage =
   * GlobalData.getUlIdStage(context.getRequest()); return CaseUtility.hasStageAccess(userID, ulIdStage); }
   */

  /*
   * determines whether the user has access rights to modify the stage
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

  /*
   * Determines whether user login in is a supervisor
   */
  private boolean isCurrentActiveApprover(GrndsExchangeContext context) {
    boolean result = false;

    HttpServletRequest request = context.getRequest();
    int eventId = GlobalData.getUlIdEvent(request);
    if (eventId != 0) {
      UserProfile userProfile = UserProfileHelper.getUserProfile(request);
      int loggedInUserId = userProfile.getUserID();
      int approverId = -1;

      ApproversRetrieveSI si = new ApproversRetrieveSI(ApproversRetrieveSI.SUBMITTED_EVENT, eventId);
      ApproversRetrieveSO so = common.retrieveApprovers(si);
      if (so.hasCurrentActiveApprover()) {
        approverId = so.getCurrentActiveApprover().getIdPerson();
      }

      // -- return true if user is approver
      if (loggedInUserId == approverId) {
        result = true;
      }
    }

    return result;
  }

  /*
   * Determines whether user login in is the supervisor of the case manager assigned to the case / private boolean
   * isCaseMngrSupervisor(CINV14SO cinv14so, int ulIdUserLoginID) { boolean success = false; if
   * (cinv14so.getUlIdPersonSupervisor() == ulIdUserLoginID) { success = true; } return success; } /* Determines whether
   * user login in is the supervisor of the case manager assigned to the case / private boolean
   * isCaseMngrSupervisor(GrndsExchangeContext context) { boolean success = false; if (isSupervisor(context) &&
   * hasStageAccessRights(context)) { success = true; } return success; }
   */

  /*
   * Determines whether user login in is an admin reviewer
   */
  private boolean isAdminReviewer(GrndsExchangeContext context) {
    boolean success = false;
    success = UserProfileHelper.getUserProfile(context).hasRight(UserProfile.SEC_ADMIN_REVIEW);
    return success;
  }
  
  @SuppressWarnings({"unchecked"})
  private List<Map> retrievePRNUnknownIfMmbrOfPKHsehold (int idStage) {
    List<Map> unKnownIfMemberOfPKHshld = null;
    unKnownIfMemberOfPKHshld = person.retrievePRNUnknownIfMmbrOfPKHsehold (idStage, CodesTables.CPRSNALL_PRN);
    return unKnownIfMemberOfPKHshld;
  }
  
  private HashMap<String, String> setPageSubSectionMode(GrndsExchangeContext context, String currentStage,
                                                        String eventStatus) {
    HashMap<String, String> subMap = new HashMap<String, String>();

    // -- if status is PEND and user is supervisor, set both to N
    if (EVENT_STATUS_PENDING.equals(eventStatus) && isCurrentActiveApprover(context)) {
      subMap.put(CONCLUSION_SECTION, "N");
      subMap.put(OVERRIDE_SECTION, "N");
    }

    // -- else if user is assigned case manager or Supervisor or above (40 below) unit role, set conclusion to N
    else if (hasStageAccessRights(context)) {
      subMap.put(CONCLUSION_SECTION, "N");
      subMap.put(OVERRIDE_SECTION, "Y");
    }

    // -- else, default to DISABLED
    else {
      subMap.put(CONCLUSION_SECTION, "Y");
      subMap.put(OVERRIDE_SECTION, "Y");
    }

    if (CodesTables.CSTAGES_INV.equals(currentStage) && EVENT_STATUS_PENDING.equals(eventStatus)
        && !isCurrentActiveApprover(context) && hasStageAccessRights(context)) {
      setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, context.getRequest());
      setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, context.getRequest());
    }

    // if stage is ARI and user is admin reviewer, set override to N
    if (CodesTables.CSTAGES_ARI.equals(currentStage) && isAdminReviewer(context)) {
      subMap.put(CONCLUSION_SECTION, "Y");
      subMap.put(OVERRIDE_SECTION, "N");
    }

    return subMap;
  }
}
