package gov.georgia.dhr.dfcs.sacwis.web.fad;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.fad.NonCompliance;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NcCbx;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NcEvent;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonComplianceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NcPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;
/**
 * This Conversation class is used to display Event Search, and List <p/>
 * <p/>
 * <pre>
 *          Change History:
 *           Date          User              Description
 *           --------     ----------------  --------------------------------------------------
 *           05/19/2010   Ashwini Rege      SMS#52234 Modified code to implement Sealing rules. 
 *                                          Policy violations created before sealing should be View only 
 *                                          even for the Case Managers assigned to the stage. They should be modifiable only for the 
 *                                          SAU_SEALED users.
 *           
 */
@SuppressWarnings("serial")
public class PolicyViolationConversation extends BaseHiddenFieldStateConversation {
  public static final String NON_COMPLIANCE_SO = "nonComplianceSO";

  private NonCompliance nonCompliance;

  public static final String DOCEXISTS = "docExists";
  
  public static final String PROTECT_FORM = "protectForm";

  private static final String POLICY_VIOLATION_TASKCD = "8091";

  private static final String POLICY_VIOLATION_PLAN = "Policy Violation";

  private static final String DISPLAY_CORRECT_ACTION_PLAN_URL = "/fad/PolicyViolation/displayPolicyViolation";

  public void setNonCompliance(NonCompliance nonCompliance) {
    this.nonCompliance = nonCompliance;
  }

  /**
   * This method is called by GRNDS to clear state and initially display Policy Violation page.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void displayPolicyViolation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayPolicyViolation_xa");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      NonComplianceSO nonComplianceSO = null;
      NonComplianceSI nonComplianceSI = new NonComplianceSI();
      boolean modeEdit = ContextHelper.getIntSafe(request, "Edit.x") != 0;
      boolean modeNewUsing = ContextHelper.getIntSafe(request, "NewUsing.x") != 0;
      boolean modeAdd = ContextHelper.getIntSafe(request, "Add.x") != 0;
      boolean modeCopy = ContextHelper.getIntSafe(request, "Copy.x") != 0;
      boolean protectForm = false;
      
      String pageMode;
      if (modeEdit) {
        pageMode = PageModeConstants.EDIT;
      } else if (modeNewUsing) {
        pageMode = PageModeConstants.NEW_USING;
      } else if (modeAdd) {
        pageMode = PageModeConstants.NEW;
      } else if (modeCopy) {
        pageMode = PageModeConstants.NEW;
      } else {
        // pageMode = PageModeConstants.MODIFY;
        pageMode = EventSearchConversation.getEventDetailPageMode(request);
        // Doing an override because the page should be allowed to save for two fields Date Achieved
        // and Result Description if the person has stage access while working in Approved (APRV) Event.
        // By default for any Approved (APRV) event, the page mode will be set to INQUIRE. But in
        // this case as described above, resetting the page mode to EDIT.
        // keep the document protected in inquire mode
        if (PageModeConstants.INQUIRE.equals(pageMode)){
          protectForm = true;
        }
        if (PageModeConstants.INQUIRE.equals(pageMode) && GlobalData.hasStageAccess(request)) {
          pageMode = PageModeConstants.EDIT;
        }
      }
     //SMS#52234 if the user is not SAU_SEALED OR if SAU_SEALED and NoStageAccess, the Poicy Violation should be View only if it was 
     // created before the sealing date (dtSealed)
      int idStage = GlobalData.getUlIdStage(request);
      int idEvent = GlobalData.getUlIdEvent(request);
      if(idEvent > 0 && idStage > 0){
      CaseUtility.Stage stage = CaseUtility.getStage("" + idStage);
      Date dtSealed = DateHelper.toJavaDate(stage.getDtSealed());        
      CaseUtility.Event nonComplianceEvent = CaseUtility.getEvent(idEvent); 
      Date dtEvent = nonComplianceEvent.getDtEventOccurred();
      UserProfile userProfile = getUserProfile(request);
      if(!userProfile.hasRight(UserProfile.SEC_SAU_SEALED) || (userProfile.hasRight(UserProfile.SEC_SAU_SEALED) && !GlobalData.hasStageAccess(request))){
      if(DateHelper.isBefore(dtEvent, dtSealed) || DateHelper.isEqual(dtEvent, dtSealed)){
        pageMode = PageModeConstants.VIEW;
      }
      } 
    }
      state.removeAllAttributes(request);
      PageMode.setPageMode(pageMode, request);
      if (modeEdit) {
        Sets.setPageSet(Sets.E, request);
      } else if (PageModeConstants.NEW_USING.equals(pageMode)) {
        Sets.setPageSet(Sets.N, request);
      } else if (PageModeConstants.NEW.equals(pageMode)) {
        Sets.setPageSet(Sets.A, request);
      } else if (PageModeConstants.MODIFY.equals(pageMode)) {
        Sets.setPageSet(Sets.M, request);
      }
      // Do the logic for New, new using, edit and Modify.
      if (pageMode.equalsIgnoreCase(PageModeConstants.NEW) || 
                      pageMode.equalsIgnoreCase(PageModeConstants.NEW_USING)) {
        // Setting Flag as false so that the children list can be retrieved fresh from the database
        nonComplianceSI.setUpdateFlag(false);
      } else if (pageMode.equalsIgnoreCase(PageModeConstants.EDIT)
                 || pageMode.equalsIgnoreCase(PageModeConstants.MODIFY)) {
        // Setting Flag as Update so that Non Compliance Child list can be retrieved from NonComplianceChild table.
        nonComplianceSI.setUpdateFlag(true);
      }      
      // use the Stage ID to get the FAD Resource ID
      nonComplianceSI.setIdStage(GlobalData.getUlIdStage(request));
      nonComplianceSI.setIdCase(GlobalData.getUlIdCase(request));
      nonComplianceSI.setIdEvent(GlobalData.getUlIdEvent(request));
      state.setAttribute(PROTECT_FORM, new Boolean(protectForm), request);
      // Get the Task code to make sure it is indeed Corrective Action Plan Task Code
      String taskCode = GlobalData.getSzCdTask(request);
      if (taskCode.equals(POLICY_VIOLATION_TASKCD)) {
        // Check whether the Document Exists already
        nonComplianceSI.setCdNonCompliance(CodesTables.CEVNTTYP_VLT);
        nonComplianceSO = nonCompliance.checkDocExistsForNonCompliance(nonComplianceSI);
        if (nonComplianceSO.getDtFormLastDate() != null) {
          request.setAttribute(DOCEXISTS, ArchitectureConstants.TRUE);
        } else {
          request.setAttribute(DOCEXISTS, ArchitectureConstants.FALSE);
        }
        // Irrespective of whether if it is an insert or update, Children belong the home
        // needs to be pulled.
        nonComplianceSO = nonCompliance.retrieveChildrenInHome(nonComplianceSI);
        // set case ID and Event ID to the SO
        nonComplianceSO.setIdCase(GlobalData.getUlIdCase(request));
        nonComplianceSO.setIdEvent(GlobalData.getUlIdEvent(request));
        // set Resource ID to GlobalData
        GlobalData.setUlIdResource(nonComplianceSO.getIdResource(), request);
        // If there is an event id in GlobalData, then it's the event id of the
        // Corrective Action Plan.
        if (GlobalData.getUlIdEvent(request) > 0) {
          // Query the Corrective Action plan and Corrective Action plan event details.
          NonComplianceSO nonComplianceSOReturn = nonCompliance.retrieveNonCompliance(nonComplianceSI);
          // Load the Corrective Action Plan, event, cbx and child data to main nonComplianceSO object.
          nonComplianceSO = loadCorrectiveAction(nonComplianceSO, nonComplianceSOReturn);
          // If the Corrective Action is copied from an existing plan then Event Status and
          // Document Completed needs to be reset for full editing
          if (PageModeConstants.NEW_USING.equals(pageMode) && nonComplianceSO.getNcEvent() != null) {
            nonComplianceSO.getNcEvent().setEventStatusCode(CodesTables.CEVTSTAT_PROC);
            nonComplianceSO.setIndDocCompleted(ArchitectureConstants.FALSE);
            nonComplianceSO.setIndCpaCon(ArchitectureConstants.FALSE);
            nonComplianceSO.setIndStOffCon(ArchitectureConstants.FALSE);
          }          
          // If the Non Compliance event is pending approval and the user did
          // not access the page via a Non Compliance approval to do, notify them
          // that the pending approval will be invalidated if they save any
          // changes. If the supervisor accessed the pending Non Compliance via
          // a stage closure approval to do, the pending family plan will be
          // invalidated. This will enable the supervisor to close the stage
          // without leaving a pending non compliance plan behind.
          if (CodesTables.CEVTSTAT_PEND.equals(nonComplianceSOReturn.getNcEvent().getEventStatusCode())
              && (!GlobalData.isApprovalMode(request) || GlobalData.isStageClosureBeingApproved(request))) {
            setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
            setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
          }
        }
        //set the State and CPA Concurrence Attribute from the Security
        nonComplianceSO.setSecurityStCpaCon(getModifyStateCPAConAttribute(request));
        //set the ResourceHomeType
        String resourceHomeType = nonCompliance.retrieveResourceHomeType(GlobalData.getUlIdCase(request));
        nonComplianceSO.setHomeType(resourceHomeType);
      }
      state.setAttribute(NON_COMPLIANCE_SO, nonComplianceSO, request);
      displayPolicyViolation(context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "displayPolicyViolation_xa");
    }
  }

  /**
   * This method is called by GRNDS to save the Policy Violation page.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void savePolicyViolation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "savePolicyViolation_xa");
    performanceTrace.enterScope();

    try {
      NonComplianceSI nonComplianceSIfromRequest = createNonComplianceSIFromRequestForSave(context);
      String docComplete = ContextHelper.getStringSafe(context, "cbxDocumentCompleted");

      if (StringHelper.isTrue(docComplete)) {
        Date dtFormLastUpdate = nonCompliance.checkDocExistsForNonCompliance(nonComplianceSIfromRequest)
                                             .getDtFormLastDate();
        if (dtFormLastUpdate == null) {
          throw new ServiceException(Messages.MSG_COMP_NOT_SAVED);
        }
      }
      // Call SaveNonCompliance to save this to Non_Compliance Table
      nonCompliance.saveNonCompliance(nonComplianceSIfromRequest);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "savePolicyViolation_xa");
    }
  }

  /**
   * This method is called by GRNDS to save and Submit the Corrective Action Plan page.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  public void saveSubmitPolicyViolation_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveSubmitPolicyViolation_xa");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      NonComplianceSI nonComplianceSIfromRequest = createNonComplianceSIFromRequestForSave(context);
      String docComplete = ContextHelper.getStringSafe(context, "cbxDocumentCompleted");
      Date dtFormLastUpdate = nonCompliance.checkDocExistsForNonCompliance(nonComplianceSIfromRequest)
                                           .getDtFormLastDate();
      if (!StringHelper.isTrue(docComplete)) {
        throw new ServiceException(Messages.MSG_SUB_DOC_NOT_COMP);
      } else {
        if (dtFormLastUpdate == null) {
          throw new ServiceException(Messages.MSG_COMP_NOT_SAVED);
        }
      }
      // Call SaveNonCompliance to save this to Non_Compliance Table
      nonCompliance.saveNonCompliance(nonComplianceSIfromRequest);
      // look up approval event task code
      String eventType = nonComplianceSIfromRequest.getEventBean().getEventTypeCode();
      String approvalTaskCD = Lookup.simpleDecodeSafe(CodesTables.CEVNTAPV, eventType);
      // Set data for ToDo Detail page
      ToDoDetailDB toDoDetailDB = new ToDoDetailDB(nonComplianceSIfromRequest.getIdEvent(),
                                                   GlobalData.getUlIdCase(request), GlobalData.getUlIdStage(request),
                                                   approvalTaskCD);
      ToDoHelper.setToDoDetailDB(toDoDetailDB, request, getSessionStateManager(context));
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "saveSubmitPolicyViolation_xa");
    }
  }

  /**
   * This method is called by other methods to perform display logic and functionality
   * 
   * @param context
   *                The GrndsExchangeContext object.
   */
  private void displayPolicyViolation(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayPolicyViolation");
    performanceTrace.enterScope();

    try {

    } catch (Exception e) {
      handleException(e, context, "displayPolicyViolation");
    }
  }

  /**
   * This method is called by the other methods when an exception is caught.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   * @param e
   *                The Exception
   * @param methodName
   *                A String containing the method which threw the exception
   */
  private void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleException");
    performanceTrace.enterScope();

    String stackTrace = BasePrsException.getStackTrace(e);
    HttpServletRequest request = context.getRequest();
    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;

      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "WtcException " + we.getClass() + " " + we.getMessage());
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_COMP_NOT_SAVED:
      case Messages.MSG_SUB_DOC_NOT_COMP:
      case Messages.MSG_CAP_NO_VIOLATION:
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, DISPLAY_CORRECT_ACTION_PLAN_URL, request);
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
  /**
   * This method is called by the other methods to populate the NonComplianceSI for saving.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   * @return NonComplianceSI
   *                NonComplianceSI POJO object holds the information to persist in the DB.
   */
  private NonComplianceSI createNonComplianceSIFromRequestForSave(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "createNonComplianceSIFromRequestForSave");
    performanceTrace.enterScope();
    String txtDtAchievementField = "txtDtAchievement";
    String cbxDocumentCompletedField = "cbxDocumentCompleted";
    String txtResultsDescriptionField = "txtResultsDescription";
    String countyOfViolationField = "countyOfViolation";
    String txtDtViolationField = "txtDtViolation";
    String cbxHomeViolationField = "cbxHomeViolation_";
    String cbxAdoptiveProcessField = "cbxAdoptiveProcess_";
    String cbxPolViolationField = "cbxPolViolation_";
    String txtDtEffectFromField = "txtDtEffectFrom";
    String txtDtEffectToField = "txtDtEffectTo";
    String cbxIndStOffCon = "cbxIndStOffCon";
    String cbxIndCpaCon = "cbxIndCpaCon";

    NonComplianceSI nonComplianceSI = new NonComplianceSI();
    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      NonComplianceSO nonComplianceSOfromState = (NonComplianceSO) state.getAttribute("nonComplianceSO", request);
      nonComplianceSI.setIdCase(GlobalData.getUlIdCase(request));
      nonComplianceSI.setIdEvent(GlobalData.getUlIdEvent(request));
      // Set the Date of Achievement to tracking date since the Non_Compliance table is shared
      // between Corrective Action and Policy Violation
      // Get all the following date fields only if they are not empty.
      if (request.getParameter(txtDtAchievementField) != null
          && !"".equals(request.getParameter(txtDtAchievementField))) {
        nonComplianceSI.setDtTracking(ContextHelper.getJavaDateSafe(request, txtDtAchievementField));
      }
      if (request.getParameter(txtDtViolationField) != null && !"".equals(request.getParameter(txtDtViolationField))) {
        nonComplianceSI.setDtOfViolation(ContextHelper.getJavaDateSafe(request, txtDtViolationField));
      }
      if (request.getParameter(txtDtEffectFromField) != null && !"".equals(request.getParameter(txtDtEffectFromField))) {
        nonComplianceSI.setDtEffectFrom(ContextHelper.getJavaDateSafe(request, txtDtEffectFromField));
      }
      if (request.getParameter(txtDtEffectToField) != null && !"".equals(request.getParameter(txtDtEffectToField))) {
        nonComplianceSI.setDtEffectTo(ContextHelper.getJavaDateSafe(request, txtDtEffectToField));
      }
      // Set Non Compliance code as Corrective Action. In Policy Violation screen,
      // this has to be set as Policy Violation since both the page shares the same
      // table Non_Compliance
      nonComplianceSI.setCdNonCompliance(CodesTables.CEVNTTYP_VLT);
      String checkboxValue = ContextHelper.getStringSafe(context, cbxDocumentCompletedField);
      // String checkboxValue = CheckboxHelper.getCheckboxValue(request,cbxDocumentCompletedField);
      if (StringHelper.isTrue(checkboxValue)
          && !(nonComplianceSOfromState.getNcEvent() != null && CodesTables.CEVTSTAT_APRV
                                                                                         .equals(nonComplianceSOfromState
                                                                                                                         .getNcEvent()
                                                                                                                         .getEventStatusCode()))) {
        // if (ArchitectureConstants.Y.equals(checkboxValue)) {
        nonComplianceSI.setIndDocCompleted(ArchitectureConstants.Y);
      } else {
        nonComplianceSI.setIndDocCompleted(ArchitectureConstants.N);
      }
      // Set Date State Office Concurrence and Date Cap Concurrence to current date to system date
      // if the check box for Date State Office Concurrence and Date Cap Concurrence is checked.
      checkboxValue = CheckboxHelper.getCheckboxValue(request, cbxIndStOffCon);
      if (ArchitectureConstants.Y.equals(checkboxValue)) {
        nonComplianceSI.setIndStOffCon(ArchitectureConstants.Y);
        nonComplianceSI.setDtStOffCon(new Date(System.currentTimeMillis()));
      } else {
        nonComplianceSI.setIndStOffCon(ArchitectureConstants.N);
        nonComplianceSI.setDtStOffCon(null);
      }

      checkboxValue = CheckboxHelper.getCheckboxValue(request, cbxIndCpaCon);
      if (ArchitectureConstants.Y.equals(checkboxValue)) {
        nonComplianceSI.setIndCpaCon(ArchitectureConstants.Y);
        nonComplianceSI.setDtCpaCon(new Date(System.currentTimeMillis()));
      } else {
        nonComplianceSI.setIndCpaCon(ArchitectureConstants.N);
        nonComplianceSI.setDtCpaCon(null);
      }
      // Set Results Description value in to txt_comments of non_compliance table
      // since non_compliance table is being used by both policy violation and corrective action plan
      nonComplianceSI.setTxtComments(ContextHelper.getStringSafe(request, txtResultsDescriptionField));
      nonComplianceSI.setCdCounty(ContextHelper.getStringSafe(request, countyOfViolationField));

      // Create a NcPerson for each child that is selected in the
      // 'Children in Home' listbox, and add the bean to the 'childrenInHome'
      // collection.
      String[] checkedChildrenHV = CheckboxHelper.getCheckedValues(request, cbxHomeViolationField);
      String[] checkedChildrenAP = CheckboxHelper.getCheckedValues(request, cbxAdoptiveProcessField);
      List<NcPerson> childrenInHomeVector = new ArrayList<NcPerson>();
      for (int i = 0; i < checkedChildrenHV.length; i++) {
        NcPerson ncPerson = new NcPerson();
        ncPerson.setIdPerson(new Integer(checkedChildrenHV[i]));
        ncPerson.setIndHomeViolation(ArchitectureConstants.Y);
        ncPerson.setIndAdoptiveProcess(ArchitectureConstants.N);
        childrenInHomeVector.add(ncPerson);
      }

      for (int i = 0; i < checkedChildrenAP.length; i++) {
        boolean existFlag = false;
        for (int j = 0; j < childrenInHomeVector.size(); j++) {
          if (childrenInHomeVector.get(j).getIdPerson() == new Integer(checkedChildrenAP[i])) {
            childrenInHomeVector.get(j).setIndAdoptiveProcess(ArchitectureConstants.Y);
            existFlag = true;
          }
        }
        if (!existFlag) {
          NcPerson ncPerson = new NcPerson();
          ncPerson.setIdPerson(new Integer(checkedChildrenAP[i]));
          ncPerson.setIndHomeViolation(ArchitectureConstants.N);
          ncPerson.setIndAdoptiveProcess(ArchitectureConstants.Y);
          childrenInHomeVector.add(ncPerson);
        }
      }
      //Get all the children that are not checked either for HV or AP and set N for both
      List<NcPerson> allChildrenList = nonComplianceSOfromState.getChildrenInHome();
      for(int i = 0; i < allChildrenList.size(); i++) {
        boolean existFlag = false;
        for (int j = 0; j < childrenInHomeVector.size(); j++) {
          if (childrenInHomeVector.get(j).getIdPerson() == allChildrenList.get(i).getIdPerson()) {
            existFlag = true;
            break;
          }
        }
        if (!existFlag) {
          NcPerson ncPerson = new NcPerson();
          ncPerson.setIdPerson(new Integer(allChildrenList.get(i).getIdPerson()));
          ncPerson.setIndHomeViolation(ArchitectureConstants.N);
          ncPerson.setIndAdoptiveProcess(ArchitectureConstants.N);
          childrenInHomeVector.add(ncPerson);
        }        
      }
      nonComplianceSI.setChildrenInHome(childrenInHomeVector);
      // Get the Page Mode
      String pageMode = PageMode.getPageMode(request);

      NcEvent ncEvent = new NcEvent();
      // Set the Policy Violation
      List<NcCbx> policyViolationVector = new ArrayList<NcCbx>();
      String[] checkedPolViolation = CheckboxHelper.getCheckedValues(request, cbxPolViolationField);
      for (int i = 0; i < checkedPolViolation.length; i++) {
        NcCbx ncCbx = new NcCbx();
        ncCbx.setCdNonComplianceCbx(checkedPolViolation[i]);
        ncCbx.setCdNonComplianceCbxType(CodesTables.CPOLVIOL);
        if (pageMode.equalsIgnoreCase(PageModeConstants.NEW)) {
          ncCbx.setIdNonComplianceCbx(0);
        }
        policyViolationVector.add(ncCbx);
      }
      nonComplianceSI.setNcCbx(policyViolationVector);

      // Construct an event to save
      // Do the logic for New, new using, edit and Modify.
      if (pageMode.equalsIgnoreCase(PageModeConstants.NEW) || pageMode.equalsIgnoreCase(PageModeConstants.NEW_USING)) {
        nonComplianceSI.setIdNonCompliance(0);
        ncEvent.setEventId(0);
        ncEvent.setDateEventOccurred(new Date(System.currentTimeMillis()));
        //Setting Flag to do the alerts. Alerts will be send only when the Update Flag is false
        // (meaning: alerts will be send at the time of insert only)
        nonComplianceSI.setUpdateFlag(false);
      } else if (pageMode.equalsIgnoreCase(PageModeConstants.EDIT)
                 || pageMode.equalsIgnoreCase(PageModeConstants.MODIFY)) {
        // Setting Non Compliance Primary keys for update
        nonComplianceSI.setIdNonCompliance(nonComplianceSOfromState.getIdNonCompliance());
        nonComplianceSI.setDtLastUpdate(nonComplianceSOfromState.getDtLastUpdate());
        // Setting Event primary keys for update
        ncEvent.setEventId(nonComplianceSOfromState.getIdEvent());
        ncEvent.setDateLastUpdate(nonComplianceSOfromState.getNcEvent().getDateLastUpdate());
        ncEvent.setDateEventOccurred(nonComplianceSOfromState.getNcEvent().getDateEventOccurred());
        // Basically both Non Compliance CBX and Non Compliance Child will be deleted and inserted
        // at the time of update
        // Setting Flag as Update so that Non Compliance CBX and Non Compliance Child are marked for deletion.
        nonComplianceSI.setUpdateFlag(true);
      }
      // For previously approved (APRV) event, since two field needs to be saved (Dt of Achievement and
      // Result Desc). The event status should still remains in APRV. mode for those events.
      if (nonComplianceSOfromState.getNcEvent() != null
          && CodesTables.CEVTSTAT_APRV.equals(nonComplianceSOfromState.getNcEvent().getEventStatusCode())) {
        ncEvent.setEventStatusCode(CodesTables.CEVTSTAT_APRV);
      } else {
        if (ArchitectureConstants.Y.equals(GlobalData.getApprovalFlag(request))) {
          ncEvent.setEventStatusCode(CodesTables.CEVTSTAT_PEND);
        } else {
          if (nonComplianceSI.getIndDocCompleted().equalsIgnoreCase(ArchitectureConstants.Y)) {
            ncEvent.setEventStatusCode(CodesTables.CEVTSTAT_COMP);
          } else {
            ncEvent.setEventStatusCode(CodesTables.CEVTSTAT_PROC);
          }
        }
      }
      // && !(CodesTables.CEVTSTAT_APRV.equals(nonComplianceSOfromState.getNcEvent().getEventStatusCode()))
      ncEvent.setStageId(GlobalData.getUlIdStage(request));
      // Set Event Type as Corrective Action. In Policy Violation screen,
      // this has to be set as Policy Violation.
      ncEvent.setEventTypeCode(CodesTables.CEVNTTYP_VLT);
      ncEvent.setCaseId(GlobalData.getUlIdCase(request));
      UserProfile user = UserProfileHelper.getUserProfile(request);
      ncEvent.setPersonId(user.getUserID());
      ncEvent.setEventDescription(POLICY_VIOLATION_PLAN);
      ncEvent.setEventTaskCode(POLICY_VIOLATION_TASKCD);

      nonComplianceSI.setEventBean(ncEvent);
      //set Logged in User ID
      nonComplianceSI.setIdLoggedInPerson(GlobalData.getUlIdStaff(request));
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      // processSevereException(context, e);
    }
    performanceTrace.exitScope();
    return nonComplianceSI;
  }
  /**
   * This method is called by the other methods to merge two NonComplianceSO POJO object to one.
   * Since children in home requires a separate retrieval than the actual Non Compliance retrieval.
   * Both the objects are merged in this method.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   * @return NonComplianceSI
   *                NonComplianceSI POJO object holds the information to persist in the DB.
   */
  private NonComplianceSO loadCorrectiveAction(NonComplianceSO main, NonComplianceSO corrActData) {
    // Set Resource ID
    corrActData.setIdResource(main.getIdResource());
    // Set the Ind Home Violation and Ind Adoptive Process back to the returning object (corrActData)
    List<NcPerson> childrenInHomeWithIndAdded = new ArrayList<NcPerson>();
    Iterator<NcPerson> itrNonCompChildrenWithOutInd = main.getChildrenInHome().iterator();
    ArrayList<NcPerson> childrenInHomeWithInd = (ArrayList<NcPerson>) corrActData.getChildrenInHome();
    while (itrNonCompChildrenWithOutInd.hasNext()) {
      NcPerson ncPersonWithOutInd = itrNonCompChildrenWithOutInd.next();
      boolean existFlag = false;
      for (int i = 0; i < childrenInHomeWithInd.size(); i++) {
        NcPerson ncPersonWithIndLoadedAlready = childrenInHomeWithInd.get(i);
        if (ncPersonWithOutInd.getIdPerson() == ncPersonWithIndLoadedAlready.getIdPerson()) {
          NcPerson ncPersonWithInd = new NcPerson();
          ncPersonWithInd.setNmPersonFull(ncPersonWithOutInd.getNmPersonFull());
          ncPersonWithInd.setIdPerson(ncPersonWithIndLoadedAlready.getIdPerson());
          ncPersonWithInd.setIndAdoptiveProcess(ncPersonWithIndLoadedAlready.getIndAdoptiveProcess());
          ncPersonWithInd.setIndHomeViolation(ncPersonWithIndLoadedAlready.getIndHomeViolation());
          childrenInHomeWithIndAdded.add(ncPersonWithInd);
          existFlag = true;
        }
      }
      if (!existFlag) {
        // Following children are added to the list but without any Indicators loaded
        // since these children Indicators were not checked when it was saved.
        // So loading just the children names to show in the list.
        NcPerson ncPerson = new NcPerson();
        ncPerson.setNmPersonFull(ncPersonWithOutInd.getNmPersonFull());
        ncPerson.setIdPerson(ncPersonWithOutInd.getIdPerson());
        ncPerson.setIndHomeViolation(ncPersonWithOutInd.getIndHomeViolation());
        ncPerson.setIndAdoptiveProcess(ncPersonWithOutInd.getIndAdoptiveProcess());
        childrenInHomeWithIndAdded.add(ncPerson);
      }
    }
    // Set ChildrenInHome With Indicators as new instead of the old one by flushing and reloading
    corrActData.setChildrenInHome(null);
    corrActData.setChildrenInHome(childrenInHomeWithIndAdded);
    return corrActData;
  }
  /**
   * This method is called by the other methods to get whether the user has Rights to access
   * State and CPA Concurrence checkboxes.
   * 
   * @param request
   *                HTTP Servlet Request object.
   * @return String
   *                Return either N or Y.
   */
  private String getModifyStateCPAConAttribute(HttpServletRequest request) {
    String retValue = ArchitectureConstants.N;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile != null) {
      retValue = userProfile.hasRight(UserProfile.SEC_MODIFY_STATE_CPA_CONC) == true ? 
                                   ArchitectureConstants.Y : ArchitectureConstants.N ;
    }
    return retValue;
  }
}
