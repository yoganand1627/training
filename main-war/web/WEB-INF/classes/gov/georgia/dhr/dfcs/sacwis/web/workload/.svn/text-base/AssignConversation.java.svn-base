package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryRtrvIn;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdStage_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
 * <p>
 * AssignConversation.java
 * </p>
 * 
 * @author Bryon Jacob
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AssignConversation extends BaseHiddenFieldStateConversation {
  // Tag this converation to the tracing module
  public static final String TRACE_TAG = "AssignConversation";

  // how many records at a time from the Tuxedo service?
  public static final int RESULTS_PER_PAGE = 90;

  public static final String INTAKE_PAGE = "INTAKE";

  public static final String HOME_INFO_PAGE = "/fad/HomeInfrmtn/displayInitHomeInformation";

  public static final String HOME_INFO_NEW_PAGE = "/fad/HomeInfrmtn/displayNewHomeInformation";

  // HD 6/17/2003 -- SIR 17948 Adding another URL to check for
  public static final String ADD_HOME_OTHER = "/fad/HomeInfrmtn/refreshSchoolNew";

  public static final String WORKLOAD_PAGE = "/workload/AssignedWorkload/displayAssignedWorkload";

  public static final String OTHER_WORKLOAD_PAGE = "/workload/AssignedWorkload/displayOtherAssignedWorkload";

  public static final String APPROVAL_STATUS_PAGE = "/workload/ApprovalStatus/approveStatus";

  public static final String UNDETERMINED = "A";

  public static final String INTAKE_APS = "B";

  public static final String INTAKE_NON_APS = "C";

  public static final String INTAKE_NON_INT = "D";

  public static final String INTAKE_FULL_SVC = "E";

  public static final String NON_INT_FUL_SVC = "F";

  public static final String NON_INT_FAD = "G";

  public static final String STAGE_ID_ARRAY = "stageID";

  public static final String ASSIGNMENTS_LIST = "ASSIGNMENTS";

  public static final String ON_CALL = "ON_CALL";

  public static final String COUNTY_ATTR = "COUNTY_ATTR";

  public static final String COUNTY = "selSzCdOnCallCounty";

  public static final String COUNTY_INFO = "countyInfo";

  public static final String ORIGINAL_PRIMARY = "ORIGINAL_PRIMARY";

  public static final String UNIT_ID = "UNIT_ID";

  public static final String UNIT_ID_NEW_PRIMARY = "UNIT_ID_NEW_PRIMARY";

  public static final String RB_VIEW_MODE = "rbFullUnitOrOnCall";

  public static final String ASSIGN_DIRTY = "assignDirty";

  public static final String PREVIOUS_URL = TRACE_TAG + "PREVIOUS_URL";

  public static final String ZERO_STRING = "0";

  public static final String ULIDPERSON = "ulIdPerson";

  public static final String CCMN80SO_STRING = "CCMN80SO";

  public static final String INTAKE_RETURN_URI = "intakeReturnURI";

  public static final String ERROR_MESSAGE = "ErrorMessage";

  // start sir23695 - static vars
  public static final String NON_CRSR = "01";

  public static final String CRSR = "02";
  // end sir23695
 
  private Admin admin;

  private Intake intake;

  /**
   * Setter Method for Admin
   * 
   * @param admin
   */
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  /**
   * Setter Method for Intake
   * 
   * @param intake
   */
  public void setIntake(Intake intake) {
    this.intake = intake;
  }

  /**
   * execute the "displayAssign" action -- redisplay the Assign page
   * <p>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CCMN08S - Lookup the Unit ID</li>
   * <li>CCMN80S - Lookup the available staff and current saved assignments</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * <pre>
   *  Change History:
   *  Date        User           Description
   *  ----------  ---------      -------------------------------------------------------------------------------------------
   *  09/10/2003  CASDORJM       JMC - SIR XXX - The assign conversation should stage progress APS and AFC Intakes no matter
   *                             what. Previously they were only stage progressing when the user was coming from Intake.
   *                             I basically just added logic to trick the conversation into populating the ccmn25s input
   *                             object the same for APS Intakes no matter where the user was coming from.
   *  06/02/2004  gerryc         SIR 22938 - added temporary variable to use for the rowQty so that the
   *                             ccmn80si.setUlRowQty(stageIdArray.length) wouldn't result in a null pointer if the array
   *                             was null.
   *  06/21/2005  wadesa         SIR 23695 - Added functionality to pass into the CCMN25S a code that will determine whether
   *                             the assign is normal or CRSR.  This is important because normal assigns go to INT and CRSR
   *                             assigns bypass the INT stage and go to the SVC stage.
   *  06/30/2005  cooganpj       SIR 23726 - Added functionality to assignPrimary_xa to prevent new primary workers being
   *                             assigned for stages checked out to MPS.
   *  08/02/2005  wadesa         SIR 23802 - set the stage type to the AssignSaveGroup object.  This will be used in the
   *                             ccmn25s service to progress to correct stage.
   *  08/09/2005  wadesa         SIR 23879 - add parameter to 'createAssignment'.  This is added to fix defect when
   *                             selecting a new primary worker to the case.
   *  08/11/2005  gerryc         SIR 22556 - changed it so that the assignments section can display and save 100 rows
   *                             instead of 20.  Also added the ability to do block assignments of secondary workers.
   *  07/01/2009  hjbaptiste     STGAP00010276 - Modified constructCommandsForBlockAssign() and constructCommandsForSingleAssign()
   *                             by reordering the logic to process the Unassignments prior to processing the Primary assignments   
   *  11/05/2009  arege          SMS#39375 Modified code so that the user does not get constraint violation when 
   *                             assigning a person as SE who was previously assigned as PR.              
   * </pre>
   * 
   * @param context
   *          the GRNDS exchange context
   */

  public void displayAssign_xa(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAssign_xa()");
    performanceTrace.enterScope();

    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    UserProfile user = UserProfileHelper.getUserProfile(context);
    // Added this flag to check if the user is the MES Program Assistant(Eligibility Module)
    boolean isMesProgramAssistant = user.hasRight(UserProfile.SEC_MES_PROGRAM_ASSIST);
    String userCounty = user.getUserCounty();
    String userRegion = user.getUserRegion();

    // if we haven't already set the calling URL (i.e., if this is the first time the page has been
    // accessed), then clear the state, and store the previous URL there
    if (state.getAttribute(PREVIOUS_URL, request) == null) {
      String intakeURI = (String) state.getAttribute(INTAKE_RETURN_URI, request);
      String county = (String) request.getAttribute(IntakeConstants.COUNTY);
      state.removeAllAttributes(request);
      state.setAttribute(INTAKE_RETURN_URI, intakeURI, request);
      state.setAttribute(IntakeConstants.COUNTY, county, request);
      String callingPage = (request.getAttribute(IntakeConstants.ASSIGN_INTAKE) != null) ? INTAKE_PAGE
                                                                                        : ContextHelper
                                                                                                       .getPreviousUrl(request);
      state.setAttribute(PREVIOUS_URL, callingPage, request);
      if (INTAKE_PAGE.equals(callingPage)) {
        state.setAttribute(ON_CALL, Boolean.TRUE, request);
      }
    }

    // copy the stageID array from the request into the state
    if (state.getAttribute(STAGE_ID_ARRAY, request) == null) {
      state.setAttribute(STAGE_ID_ARRAY, request.getAttribute(STAGE_ID_ARRAY), request);
    }

    state.setAttribute("secExists", request.getAttribute("secRole"), request);
    
    CCMN80SO ccmn80soFromState = (CCMN80SO) state.getAttribute("CCMN80SO", request);
    HashMap<String, Integer> availStaffGroupMap = new HashMap<String, Integer>();
    
    if(ccmn80soFromState != null){
    AvailStaffGroup_ARRAY availStaffGroups = ccmn80soFromState.getAvailStaffGroup_ARRAY();
    if(availStaffGroups != null ){ 
      Enumeration enumeration = availStaffGroups.enumerateAvailStaffGroup();
      while (enumeration.hasMoreElements()){
        AvailStaffGroup availStaffGroup = (AvailStaffGroup) enumeration.nextElement();
        int idStaffMember = availStaffGroup.getUlIdPerson();
        Integer idStaffMemeberInt = new Integer(idStaffMember);
        availStaffGroupMap.put(Integer.toString(idStaffMember), idStaffMemeberInt);
        
      }
     }
    }
    // copy the staff search array into state, if present
    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);
    if (ccmn50do_array != null) {
      state.setAttribute(StaffSearchInput.STAFF_PULL_BACK, ccmn50do_array, request);
      Enumeration enumeration = ccmn50do_array.enumerateROWCCMN50DO();
      while (enumeration.hasMoreElements()) {
        ROWCCMN50DO rowccmn50do = (ROWCCMN50DO) enumeration.nextElement();
        if(!availStaffGroupMap.containsKey(Integer.toString(rowccmn50do.getUlIdPerson()))){
        CCMN80SI ccmn80si = new CCMN80SI();
        ccmn80si.setBIndStaffSearch(true);
        ccmn80si.setUlIdPerson(rowccmn50do.getUlIdPerson());
        ccmn80si.setSzCdOnCallCounty((String) state.getAttribute(COUNTY_ATTR, request));
        ccmn80si.setIndMesProgramAssistant(isMesProgramAssistant);
        ccmn80si.setSzCdUserCounty(userCounty);
        ccmn80si.setSzCdUserRegion(userRegion);
        CCMN80SO ccmn80so = admin.retrieveEmployeeAssignInfo(ccmn80si);
        rowccmn50do.setBIndOverPolicyLimit(ccmn80so.getBIndOverPolicyLimit());
        }
        else{
          setErrorMessage(Messages.MSG_ASGN_LSTED_TWICE, context.getRequest());
          ccmn50do_array.removeAllROWCCMN50DO();
          break;
        }
      }
    }
    // populate the global data structures
    populateGlobalData(context);

    request.setAttribute("rbAvailableStaff", ContextHelper.getString(request, "rbAvailableStaff"));
    /* SIR 22556 --When primary button is clicked Set primary indicator */
    String primInd = ContextHelper.getString(request, "hdnPrimaryInd");
    state.setAttribute("primaryIndicator", primInd, request);
    
    CCMN08SO ccmn08so;
    try {
      // populate the ccmn08si object
      CCMN08SI ccmn08si = populateCCMN08SI_Retrieve(context);

      // call out to the CCMN08 service to retrieve data
      // Replacing the wtcHelper.callService with the method
      ccmn08so = admin.findUnitSupervisorName(ccmn08si);
    } catch(ServiceException se) {
      int errorCode = se.getErrorCode();
      switch(errorCode) {
      case Messages.MSG_CMN_INVALID_UNIT:
        //-- instantiate output object to continue processing
        ccmn08so = new CCMN08SO();
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + se.getMessage());
        processSevereException(context, se);
        return;
      }
    } catch(Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
      return;
    }
    
    try {
      // populate the ccmn80si object
      CCMN80SI ccmn80si = populateCCMN80SI_Retrieve(context, ccmn08so.getUlIdUnit());

      // call out to the CCMN80 service to retrieve data
      CCMN80SO ccmn80so = admin.retrieveEmployeeAssignInfo(ccmn80si);

      int explan_code = ccmn80so.getExplan_code();
      switch(explan_code) {
      case Messages.MSG_CMN_ASSIGN_ON_CALL:
      case Messages.MSG_CMN_NO_STAFF_IN_UNIT:
        // To be displayed inside Available Staff table, so don't use setErrorMessage
        request.setAttribute(ERROR_MESSAGE, MessageLookup.getMessageByNumber(explan_code));
        break;
      default:
        //-- no error message to display; continue processing
        break;
      }
      
      // populate the Assignments box on the first display of the page
      populateInitialAssignments(state, request, ccmn80so);

      // push the returned data into the state object
      state.setAttribute(CCMN80SO_STRING, ccmn80so, request);
      state.setAttribute(UNIT_ID, ccmn08so.getUlIdUnit(), request);
    } catch (Exception e) {
      // log the message to the GRNDS tracer
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    // record total time in tracer and exit scope.
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * execute the "search" action -- re-load the page with either the full unit or on-call view <p/> this changes the
   * command parameters that are passed into the service calls that redisplay the page.
   * 
   * @param context
   *          the GRNDS exchange context
   */
  public void search_xa(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".search_xa()");
    performanceTrace.enterScope();

    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // put the view mode (on-call or full-unit) into the page's state
    boolean onCallMode = ON_CALL.equals(ContextHelper.getStringSafe(context, RB_VIEW_MODE));
    state.setAttribute(ON_CALL, onCallMode ? Boolean.TRUE : Boolean.FALSE, request);

    if (onCallMode == true) {
      String selectedCounty = ContextHelper.getStringSafe(context, COUNTY);
      state.setAttribute(COUNTY_ATTR, selectedCounty, request);
    }

    // redisplay the page
    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * execute the "assignPrimary" action -- replace the current Primary Assignee with the selected staff member <p/> this
   * method does not call out to any services; rather, the changes are persisted to a java.util.List object that is
   * stored in page state. changes are persisted to the DB only when the "Save" button is pressed.
   * 
   * @param context
   *          the GRNDS exchange context
   */
@SuppressWarnings({"unchecked"})
  public void assignPrimary_xa(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".assignPrimary_xa()");
    performanceTrace.enterScope();

    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // set the "assignDirty" bit, so we remind the user to save before navigating away from the page
    state.setAttribute(ASSIGN_DIRTY, Boolean.TRUE, request);

    // get the list of current assignments from the page's context
    List<AssignmentGroup> assignments = (List<AssignmentGroup>) state.getAttribute(ASSIGNMENTS_LIST, request);

    // SIR 23726 - If any of the stages are checked out to MPS, to not allow reassignment

    List<Integer> assignedStages = new ArrayList<Integer>();
    List checkedOutStages;

    for (Iterator iterator = assignments.iterator(); iterator.hasNext();) {
      AssignmentGroup assignmentGroup = (AssignmentGroup) iterator.next();
      assignedStages.add(assignmentGroup.getUlIdStage());
    }

    checkedOutStages = CaseUtility.getCheckedOutStages(assignedStages);

    if (!checkedOutStages.isEmpty()) {

      String checkoutErrorMsg;
      CaseUtility.Stage stage;

      for (Iterator iterator = checkedOutStages.iterator(); iterator.hasNext();) {
        stage = CaseUtility.getStage((Integer) iterator.next());

        checkoutErrorMsg = MessageLookup.getMessageByNumber(Messages.MSG_REASSIGN_PRIMARY_MOBILE);
        checkoutErrorMsg =
                MessageLookup.addMessageParameter(checkoutErrorMsg,
                                                  FormattingHelper.formatStringSpecialChars(stage.getNmStage(),
                                                                                            "\\\""));
        checkoutErrorMsg = MessageLookup.addMessageParameter(checkoutErrorMsg, stage.getCdStage());
        setErrorMessage(checkoutErrorMsg, request);
      }
    }

    // SIR 23726 - If no stage is checked out to MPS, execute method as before
    else {
      // get the selected staff member from the page
      AvailStaffGroup availStaffGroup = getSelectedStaff(context);

      // if we find the AvailStaffGroup... (we SHOULD, if the page passed
      // validation)
      if (availStaffGroup != null) {
        ArchInputStruct input = new ArchInputStruct();
        CCMN04SI ccmn04si = new CCMN04SI();

        // Set the values for the ArchInputStruct
        input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
        input.setUsPageNbr(1);
        input.setUlPageSizeNbr(50);
        // int personID;
        input.setSzUserId("" + availStaffGroup.getUlIdPerson());
        ccmn04si.setArchInputStruct(input);

        UlIdPerson_ARRAY_CCMN04SI a = new UlIdPerson_ARRAY_CCMN04SI();

        a.addUlIdPerson(availStaffGroup.getUlIdPerson());
        ccmn04si.setUlIdPerson_ARRAY_CCMN04SI(a);

        CCMN04SO ccmn04so = admin.retrieveEmployeeDetail(ccmn04si);
        
        ROWCCMN04SOG02 jobDescription = ccmn04so.getROWCCMN04SOG02();
        String isJobAssignable = jobDescription.getBIndJobAssignable();
        if (isJobAssignable == null | "N".equals(isJobAssignable)){
          setErrorMessage(Messages.MSG_EMP_NOT_ASSIGNABLE, context.getRequest());
        } else {
        
        if (availStaffGroup.getBIndOverPolicyLimit() == true) {
          setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_STAFF_OVER_POL_LIMIT), request);
        }
        // Displaying the message if the user selects a staff who does not have phone number
        if (availStaffGroup.getLNbrPhone() == null) {
          setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_NO_PHONE_NUMBERS), request);
        }
        // SIR 19194
        // If we're dealing with a valid primary, set the Unit ID used in save
        int newUnitId = availStaffGroup.getUlIdUnit();
        state.setAttribute(UNIT_ID_NEW_PRIMARY, newUnitId, request);

        // get the stageIdArray from the context -- this is to see if we are
        // doing block assign...
        int[] stageIdArray = (int[]) state.getAttribute(STAGE_ID_ARRAY, request);

        // if we are doing block assign...
        if (stageIdArray.length > 1) {
          // create a new list to hold the new assignments
          // todo: determine max size for this array and initialize it to that size
          List<AssignmentGroup> newAssignments = new ArrayList<AssignmentGroup>(20);

          // for each of the old assignments...
          for (Iterator iterator = assignments.iterator(); iterator.hasNext();) {
            // copy the assignment to a new one with the selected staff member
            AssignmentGroup assignmentGroup = (AssignmentGroup) iterator.next();
            if (("PR").equals(assignmentGroup.getSzCdStagePersRole())) {
              assignmentGroup = createAssignment(availStaffGroup, true, assignmentGroup);
            }
            // put it in the list of new assignments
            newAssignments.add(assignmentGroup);
          }

          // clear the old assignments list, and put in the new assignments
          assignments.clear();
          assignments.addAll(newAssignments);

        }
        // otherwise, we are assigning to a single stage...
        else {
          // grab the previous Primary Asignee, and remove it from the list
          AssignmentGroup oldPrimary = assignments.get(0);
          assignments.remove(0);

          // construct an AssignmentGroup to represent the new assignment, and
          // add it to the list
          AssignmentGroup assignmentGroup = createAssignment(availStaffGroup, true, oldPrimary);
          assignments.add(0, assignmentGroup);
        }
      }
      }

      // SIR 22556 - sorts grouped by stage
      populateSortedAssignments(state, request, assignments);

      // redisplay the page
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);

      // record time in tracer and exit scope
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
  }
  /**
   * execute the "assignSecondary" action -- set the currently selected staff member as a Secondary Assignee <p/> this
   * method does not call out to any services; rather, the changes are persisted to a java.util.List object that is
   * stored in page state. changes are persisted to the DB only when the "Save" button is pressed.
   * 
   * @param context
   *          the GRNDS exchange context
   */
  @SuppressWarnings( { "unchecked" })
  public void assignSecondary_xa(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".assignSecondary_xa()");
    performanceTrace.enterScope();

    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // set the "assignDirty" bit, so we remind the user to save before navigating away from the page
    state.setAttribute(ASSIGN_DIRTY, Boolean.TRUE, request);

    // get the list of current assignments from the page's context
    List<AssignmentGroup> assignments = (List<AssignmentGroup>) state.getAttribute(ASSIGNMENTS_LIST, request);

    // get the selected staff member from the page
    AvailStaffGroup availStaffGroup = getSelectedStaff(context);

    List<AssignmentGroup> newAssignments = new ArrayList<AssignmentGroup>(10);
    // if we find the AvailStaffGroup... (we SHOULD, if the page passed validation)
    if (availStaffGroup != null) {
      ArchInputStruct input = new ArchInputStruct();
      CCMN04SI ccmn04si = new CCMN04SI();

      // Set the values for the ArchInputStruct
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
      input.setUsPageNbr(1);
      input.setUlPageSizeNbr(50);
      // int personID;
      input.setSzUserId("" + availStaffGroup.getUlIdPerson());
      ccmn04si.setArchInputStruct(input);

      UlIdPerson_ARRAY_CCMN04SI a = new UlIdPerson_ARRAY_CCMN04SI();

      a.addUlIdPerson(availStaffGroup.getUlIdPerson());
      ccmn04si.setUlIdPerson_ARRAY_CCMN04SI(a);

      CCMN04SO ccmn04so = admin.retrieveEmployeeDetail(ccmn04si);

      ROWCCMN04SOG02 jobDescription = ccmn04so.getROWCCMN04SOG02();
      String isJobAssignable = jobDescription.getBIndJobAssignable();
      if (isJobAssignable == null | "N".equals(isJobAssignable)) {
        setErrorMessage(Messages.MSG_EMP_NOT_ASSIGNABLE, context.getRequest());
      } else {

      if (availStaffGroup.getBIndOverPolicyLimit() == true) {
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_STAFF_OVER_POL_LIMIT), request);
      }
      // Displaying the message if the user selects a staff who does not have phone number
      if (availStaffGroup.getLNbrPhone() == null) {
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_NO_PHONE_NUMBERS), request);
      }
      // construct an AssignmentGroup to represent the new assignment, and add it to the list

      for (Iterator iterator = assignments.iterator(); iterator.hasNext();) {
        AssignmentGroup x = (AssignmentGroup) iterator.next();
        if ("PR".equals(x.getSzCdStagePersRole())) {
          AssignmentGroup assignmentGroup = createAssignment(availStaffGroup, false, x);
          newAssignments.add(assignmentGroup);
        }
      }
      // assignments.clear();
      assignments.addAll(newAssignments);
    }
    }

    // SIR 22556 - sorts grouped by stage
    populateSortedAssignments(state, request, assignments);

    // redisplay the page
    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * execute the "staff" action -- search for Available staff by search criteria <p/> this calls out to the Staff Search
   * dialog. any staff members returned from that page are prepended to the list of Available Staff returned from the
   * CCMN80S service.
   * 
   * @param context
   *          the GRNDS exchange context
   */
  public void staff_xa(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".staff_xa()");
    performanceTrace.enterScope();

    // get the request from the GRNDS exchange context
    HttpServletRequest request = context.getRequest();

    // create a new StaffSearchInput object to pass to the search page, and populate it with the
    // information needed to return it to us when complete -- set this object onto the request.
    StaffSearchInput io = new StaffSearchInput();
    io.setSourcePage(StaffSearchInput.ASSIGN);
    io.setDestinationUrl("/workload/Assign/displayAssign");
    request.setAttribute("StaffSearchInput", io);

    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * execute the "unAssign" action -- remove the currently selected Secondary Asignee <p/> this method does not call out
   * to any services; rather, the changes are persisted to a java.util.List object that is stored in page state. changes
   * are persisted to the DB only when the "Save" button is pressed.
   * 
   * @param context
   *          the GRNDS exchange context
   */
  @SuppressWarnings( { "unchecked" })
  public void unAssign_xa(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".unAssign_xa()");
    performanceTrace.enterScope();

    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // set the "assignDirty" bit, so we remind the user to save before navigating away from the page
    state.setAttribute(ASSIGN_DIRTY, Boolean.TRUE, request);

    // get the index of the secondary assignment to remove - if the page passed validation, this
    // will be a valid index into the assignments list
    int indexToUnAssign = ContextHelper.getIntSafe(context.getRequest(), "rbAssignments");

    // get the list of current assignments from the page's context
    List<AssignmentGroup> assignments = (List<AssignmentGroup>) state.getAttribute(ASSIGNMENTS_LIST, request);

    // remove the secondary assignment at the given index
    assignments.remove(indexToUnAssign);

    // SIR 22556 - sorts grouped by stage
    populateSortedAssignments(state, request, assignments);

    // redisplay the page
    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * execute the "save" action -- save assignments to the DB with the CCMN25S service <p/>
   * <p>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CCMN25S - Save the Assignment changes made on this page</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          the GRNDS exchange context
   */
  public void save_xa(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".save_xa()");
    performanceTrace.enterScope();

    try {
      // populate the service input object to make the call to the CCMN25S service
      CCMN25SI ccmn25si = populateCCMN25SI_Update(context);
      // make the call out to the CCMN25S service
      admin.saveAssign(ccmn25si);
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      // lookup the string for any of the following errors and display it
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CMN_DUP_SP_LINK:
        setErrorMessage(MessageLookup.getMessageByNumber(we.getErrorCode()), context.getRequest());
        break;

      default:

        // log the message to the GRNDS tracer
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + we.getMessage());
        processSevereException(context, we);
      }
    } catch (Exception e) {
      // log the message to the GRNDS tracer
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    // clear state before returning to the AssignedWorkload page
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    state.removeAttribute(ASSIGNMENTS_LIST, request);
    state.removeAttribute(UNIT_ID, request);
    state.removeAttribute(UNIT_ID_NEW_PRIMARY, request);
    state.removeAttribute(CCMN80SO_STRING, request);
    state.removeAttribute(ON_CALL, request);
    state.removeAttribute(STAGE_ID_ARRAY, request);
    state.removeAttribute(ORIGINAL_PRIMARY, request);
    state.removeAttribute(StaffSearchInput.STAFF_PULL_BACK, request);
    state.removeAttribute(ASSIGN_DIRTY, request);

    request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);

    // return control to the calling page
    try {
      String previousURL = (String) state.getAttribute(PREVIOUS_URL, request);

      if (previousURL.equals(INTAKE_PAGE)) {
        previousURL = (String) state.getAttribute(INTAKE_RETURN_URI, request);
      }
      if (previousURL.equals(HOME_INFO_NEW_PAGE) || previousURL.equals(ADD_HOME_OTHER)) {
        previousURL = HOME_INFO_PAGE;
      }
      if (APPROVAL_STATUS_PAGE.equals(previousURL)) {
        previousURL = WORKLOAD_PAGE;
      }
      forward(previousURL, request, context.getResponse());
    } catch (ServletException e) {
      processSevereException(context, e);
    }

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * get the selected person from the Available Staff table
   * 
   * @param context
   *          the GRNDS exchange context
   * @return the AvailStaffGroup object representing the selected staff member
   */
  private AvailStaffGroup getSelectedStaff(GrndsExchangeContext context) {
    // get the state and request from the page context
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    UserProfile user = UserProfileHelper.getUserProfile(context);
    // Added this flag to check if the user is the MES Program Assistant(Eligibility Module)
    boolean isMesProgramAssistant = user.hasRight(UserProfile.SEC_MES_PROGRAM_ASSIST);
    String userCounty = user.getUserCounty();
    String userRegion = user.getUserRegion();

    // get the id of the selected staff member from the "Available Staff" table - we can
    // assume that this is a valid index and that the person is not currently assigned,
    // because the page passed validation
    String selection = ContextHelper.getStringSafe(context, "rbAvailableStaff");

    // retrieve the AvailableStaffGroup_ARRAY from the CCMN80SO service output object
    CCMN80SO ccmn80so = (CCMN80SO) state.getAttribute(CCMN80SO_STRING, request);
    AvailStaffGroup_ARRAY availStaffGroup_array = ccmn80so.getAvailStaffGroup_ARRAY();
    AvailStaffGroup[] staffArray = availStaffGroup_array.getAvailStaffGroup();
    // search the array for the selection (linear search is okay, since we will be scanning
    // at most RESULTS_PER_PAGE values, and the array is unsorted, so we would need to copy
    // and sort it to do a binary search, which is overkill... if RESULTS_PER_PAGE becomes
    // large, then it may be worth it to sort and binary search)
    AvailStaffGroup availStaffGroup = null;
    for (int i = 0; i < staffArray.length; i++) {
      if (selection.equals(String.valueOf(staffArray[i].getUlIdPerson()))) {
        availStaffGroup = staffArray[i];
        break;
      }
    }

    // if we didn't find the staff member in the AvailStaffGroup_ARRAY...
    if (availStaffGroup == null) {
      // get the array of objects from the Staff Search page
      ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) state.getAttribute(StaffSearchInput.STAFF_PULL_BACK,
                                                                                request);

      // if it is not null...
      if (ccmn50do_array != null) {
        // do the same linear search on this data
        Enumeration enumeration = ccmn50do_array.enumerateROWCCMN50DO();
        while (enumeration.hasMoreElements()) {
          ROWCCMN50DO rowccmn50do = (ROWCCMN50DO) enumeration.nextElement();
          if (selection.equals(String.valueOf(rowccmn50do.getUlIdPerson()))) {
            CCMN80SI ccmn80si = new CCMN80SI();
            ccmn80si.setBIndStaffSearch(true);
            ccmn80si.setUlIdPerson(rowccmn50do.getUlIdPerson());
            ccmn80si.setIndMesProgramAssistant(isMesProgramAssistant);
            ccmn80si.setSzCdUserCounty(userCounty);
            ccmn80si.setSzCdUserRegion(userRegion);
            ccmn80so = admin.retrieveEmployeeAssignInfo(ccmn80si);
            rowccmn50do.setBIndOverPolicyLimit(ccmn80so.getBIndOverPolicyLimit());
            // the elements of this array are of a different type than AvailStaffGroup,
            // so we need to copy all of the relevant data into an object of that type.
            availStaffGroup = copyStaffSearchToAvailStaff(rowccmn50do);
            break;
          }
        }
      }
    }

    // return the AvailStaffGroup object of the selected staff member
    return availStaffGroup;
  }

  /**
   * copy a staff record as returned from the Staff Search page into an AvailStaffGroup object
   * 
   * @param rowccmn50do
   *          the staff record from the Staff Search page
   * @return the copied AvailStaffGroup object
   */
  public static AvailStaffGroup copyStaffSearchToAvailStaff(ROWCCMN50DO rowccmn50do) {
    // construct the new object
    AvailStaffGroup availStaffGroup = new AvailStaffGroup();

    // copy the field values
    availStaffGroup.setDtDtEmpLastAssigned(rowccmn50do.getDtDtEmpLastAssigned());
    availStaffGroup.setLNbrPhone(rowccmn50do.getLSysNbrPersPhoneWork());
    availStaffGroup.setLNbrPhoneExtension(rowccmn50do.getLNbrPhoneExtension());
    availStaffGroup.setSzBjnJob(rowccmn50do.getSzBjnJob());
    availStaffGroup.setSzNbrUnit(rowccmn50do.getSzNbrUnit());
    availStaffGroup.setSzNmOfficeName(rowccmn50do.getSzNmOfficeName());
    availStaffGroup.setSzNmPersonFull(rowccmn50do.getSzNmPersonFull());
    availStaffGroup.setTmScrTmEmpLastAssigned(rowccmn50do.getTmScrTmEmpLastAssigned());
    availStaffGroup.setUlIdPerson(rowccmn50do.getUlIdPerson());
    availStaffGroup.setUlIdUnit(rowccmn50do.getUlIdUnit());
    availStaffGroup.setBIndOverPolicyLimit(rowccmn50do.getBIndOverPolicyLimit());

    // return the copied object
    return availStaffGroup;
  }

  /**
   * populate the global data structures used by this page
   * 
   * @param context
   *          the GRNDS exchange context
   */
  private void populateGlobalData(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateGlobalData()");
    performanceTrace.enterScope();

    // get the page request and the user information
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // if a ulIdPerson was passed in as a request parameter, set it into global data
    if ((request.getParameter(ULIDPERSON) != null)
        && !(request.getParameter(ULIDPERSON).equals(StringHelper.EMPTY_STRING))) {
      GlobalData.setUlIdPerson(ContextHelper.getIntSafe(context, ULIDPERSON), request);
    }
    // if a txtSzNmPersonFull was passed in as a request parameter, set it into global data
    if ((request.getParameter("txtSzNmPersonFull") != null)
        && !(request.getParameter("txtSzNmPersonFull").equals(StringHelper.EMPTY_STRING))) {
      GlobalData.setSzNmPersonFull(ContextHelper.getStringSafe(context, "txtSzNmPersonFull"), request);
    }
    // if a ulIdPerson of "SELF" was passed in as a request parameter, set current user info into global data
    if ((request.getParameter(ULIDPERSON) != null) && "SELF".equals(request.getParameter(ULIDPERSON))) {
      GlobalData.setUlIdPerson(user.getUserID(), request);
      GlobalData.setSzNmPersonFull(user.getUserFullName(), request);
    }

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * construct a new CCMN25SI service input object to call out to the CCMN25S service
   * 
   * @param context
   *          the GRNDS exchange context
   * @return the newly created CCMN25SI service input object
   */
  private CCMN25SI populateCCMN25SI_Update(GrndsExchangeContext context) throws ServiceException {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCMN25SI_Update()");
    performanceTrace.enterScope();

    // get the state and request from the page context
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // retrieve user data
    UserProfile user = UserProfileHelper.getUserProfile(request);

    // get the display list of assignments from the context.
    List assignments = (List) state.getAttribute(ASSIGNMENTS_LIST, request);

    // create the input object and its ArchInputStruct
    CCMN25SI ccmn25si = new CCMN25SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn25si.setArchInputStruct(archInputStruct);

    ccmn25si.setUlIdEmployee(UserProfileHelper.getUserProfile(request).getUserID());

    // begin sir#23695 - Add ulIdStageProgRsnClose to input object
    String tempDisposition = ContextHelper.getStringSafe(request, "hdnSzCdIncomingDisposition");
    if ("CDD".equals(tempDisposition) || "CAC".equals(tempDisposition) || "CLE".equals(tempDisposition)
        || "CST".equals(tempDisposition)) {
      ccmn25si.setSzCdStageReasonClosed(CRSR);
    } else {
      ccmn25si.setSzCdStageReasonClosed(NON_CRSR);
    }
    // end sir#23695

    // set the fixed values on the ArchInputStruct
    /** @todo Do not set unused archInputStruct values - none of these should be set except maybe usPageNbr */
    archInputStruct.setUsPageNbr(0);

    // set the user information on the ArchInputStruct
    archInputStruct.setSzUserId(user.getUserLogonID());

    // set the fixed values on the CCMN80SI
    ccmn25si.setSzCdStageRegion(StringHelper.EMPTY_STRING);

    // set the user information on the CCMN80SI
    ccmn25si.setUlIdPerson(user.getUserID());

    // get the AssignmentGroup_ARRAY from the CCMN80SO object
    CCMN80SO ccmn80so = (CCMN80SO) state.getAttribute(CCMN80SO_STRING, request);
    AssignmentGroup_ARRAY assignmentGroup_array = ccmn80so.getAssignmentGroup_ARRAY();

    // create a new AssignSaveGroup_ARRAY
    AssignSaveGroup_ARRAY assignSaveGroup_array = new AssignSaveGroup_ARRAY();

    // count the number of "commands" we are sending to the CCMN25S service
    int ulRowQty;

    // get the stageIdArray from the context
    int[] stageIdArray = (int[]) state.getAttribute(STAGE_ID_ARRAY, request);

    // JMC - 10/03/2003 - The stageProgAPS_INT indicator is used by the
    // constructCommandsForSingleAssign helper method and the
    // determineCRecFunc help method. For APS/AFC Intakes that have
    // an incoming status of closed that are being single assigned,
    // we always want to stage progress - regardless of whether the user
    // accessed the Assign page via the Intake or Workload.
    boolean stageProgAPS_INT = false;

    // if we are doing block assign...
    // SIR 22556 - this can be block assign secondary or primary
    if (stageIdArray.length > 1) {
      ulRowQty = constructCommandsForBlockAssign(context, assignments, assignmentGroup_array, assignSaveGroup_array);
    }
    // otherwise, we are doing single assign...
    else {
      AssignmentGroup primary = assignmentGroup_array.getAssignmentGroup(0);

      if ((CodesTables.CSTAGES_INT).equals(primary.getSzCdStage())
          && ((CodesTables.CCLASS_AFC).equals(primary.getSzCdStageProgram()) || (CodesTables.CCLASS_APS)
                                                                                                        .equals(primary
                                                                                                                       .getSzCdStageProgram()))
          && incomingStatusIsClosed(primary.getUlIdStage())) {
        stageProgAPS_INT = true;
      }

      ulRowQty = constructCommandsForSingleAssign(context, stageProgAPS_INT, assignments, assignmentGroup_array,
                                                  assignSaveGroup_array);
    }

    // set the number of commands onto the ArchInputStruct
    archInputStruct.setUlPageSizeNbr(ulRowQty);

    // set the size of the array, and set it onto the service input object
    assignSaveGroup_array.setUlRowQty(ulRowQty);
    ccmn25si.setAssignSaveGroup_ARRAY(assignSaveGroup_array);
    archInputStruct
                   .setCReqFuncCd(determineCRecFunc(context, stageProgAPS_INT,
                                                    assignmentGroup_array.getAssignmentGroup(0), assignSaveGroup_array));
    // Added this flag to check if the user is the MES Program Assistant(Eligibility Module)
    boolean isMesProgramAssistant = user.hasRight(UserProfile.SEC_MES_PROGRAM_ASSIST);
    ccmn25si.setIndMesProgramAssistant(isMesProgramAssistant);

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the newly created CCMN25SI service input object
    return ccmn25si;
  }

  /**
   * setup the array of AssignSaveGroup objects for doing a single-stage assign.
   * 
   * @param context
   *          the GRNDS exchange context
   * @param assignments
   *          the list of currently Displayed Assignments
   * @param assignmentGroup_array
   *          the AssignmentGroup array from the CCMN80S service call
   * @param assignSaveGroup_array
   *          the AssignSaveGroup array to fill with commands
   * @return the number of commands
   */
  private int constructCommandsForSingleAssign(GrndsExchangeContext context, boolean stageProgAPS_INT,
                                               List assignments, AssignmentGroup_ARRAY assignmentGroup_array,
                                               AssignSaveGroup_ARRAY assignSaveGroup_array) {
    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // count the number of "commands" we are sending to the CCMN25S service
    int ulRowQty = 0;

    // construct a set of the secondary assignments that were present before we made changes on this page
    /** @todo determine max size for this hashmap and initialize it to that size */
    Map<Integer, AssignmentGroup> originalSecondaries = new HashMap<Integer, AssignmentGroup>(100);
    Enumeration enumeration = assignmentGroup_array.enumerateAssignmentGroup();
    while (enumeration.hasMoreElements()) {
      AssignmentGroup assignmentGroup = (AssignmentGroup) enumeration.nextElement();
      if ("SE".equals(assignmentGroup.getSzCdStagePersRole())) {
        originalSecondaries.put(assignmentGroup.getUlIdPerson(), assignmentGroup);
      }
    }

    // construct a set of the secondary assignments after our changes on this page
    /** @todo determine max size for this hashmap and initialize it to that size */
    Map<Integer, AssignmentGroup> modifiedSecondaries = new HashMap<Integer, AssignmentGroup>(100);
    Iterator iterator = assignments.iterator();
    while (iterator.hasNext()) {
      AssignmentGroup assignmentGroup = (AssignmentGroup) iterator.next();
      if ("SE".equals(assignmentGroup.getSzCdStagePersRole())) {
        modifiedSecondaries.put(assignmentGroup.getUlIdPerson(), assignmentGroup);
      }
    }

    // for every assignment that is in the "original" set, but not in the "current" set, we will create
    // a (D)elete action to remove that secondary assignment
    Iterator it = originalSecondaries.keySet().iterator();
    while (it.hasNext()) {
      Integer ulIdPerson = (Integer) it.next();
      if (!modifiedSecondaries.keySet().contains(ulIdPerson)) {
        AssignmentGroup assignmentGroup = originalSecondaries.get(ulIdPerson);
        AssignSaveGroup asg = constructAssignSaveGroup("D", assignmentGroup, assignments, context);
        assignSaveGroup_array.addAssignSaveGroup(asg);
        ulRowQty++;
      }
    }

    // if the "ORIGINAL_PRIMARY" is different from the current primary assignment, we will create an
    // (U)pdate action to change the primary assignment
    int origPrimary = (Integer) state.getAttribute(ORIGINAL_PRIMARY, request);
    int newPrimary = ((AssignmentGroup) assignments.get(0)).getUlIdPerson();
    if (origPrimary != newPrimary) {
      AssignmentGroup assignmentGroup = ((AssignmentGroup) assignments.get(0));
      AssignSaveGroup asg = constructAssignSaveGroup("U", assignmentGroup, assignments, context);
      assignSaveGroup_array.addAssignSaveGroup(asg);
      ulRowQty++;
    } else if ((state.getAttribute(PREVIOUS_URL, request).equals(INTAKE_PAGE)) || stageProgAPS_INT) // JMC - SIR XXX -
                                                                                                    // Added this
                                                                                                    // condition
    {
      AssignmentGroup assignmentGroup = ((AssignmentGroup) assignments.get(0));
      AssignSaveGroup asg = constructAssignSaveGroup("", assignmentGroup, assignments, context);
      // asg.setUlIdPerson( assignmentGroup.getUlIdPerson() );
      // asg.setUlIdStage( assignmentGroup.getUlIdStage() );
      // asg.setSzNmPersonFull( assignmentGroup.getSzNmPersonFull() );
      // asg.setSzCdStageProgram( assignmentGroup.getSzCdStageProgram() );
      asg.setUlIdUnit(0);
      asg.setUlSysIdPriorPerson(0);
      asg.setUlIdStagePerson(0);
      asg.setUlIdCase(0);
      asg.setSzCdStagePersRole(null);
      asg.setTsLastUpdate(null);
      assignSaveGroup_array.addAssignSaveGroup(asg);
      ulRowQty++;
    }
    
    //SMS#39375 Moved this block of code here so that the user does not get constraint violation when 
    // assigning a person as SE who was previously assigned as PR. 
    // for every assignment that is in the "current" set, but not in the "modified" set, we will create
    // an (A)dd action to create that secondary assignment
    it = modifiedSecondaries.keySet().iterator();
    while (it.hasNext()) {
      Integer ulIdPerson = (Integer) it.next();
      if (!originalSecondaries.keySet().contains(ulIdPerson)) {
        AssignmentGroup assignmentGroup = modifiedSecondaries.get(ulIdPerson);
        AssignSaveGroup asg = constructAssignSaveGroup("A", assignmentGroup, assignments, context);
        assignSaveGroup_array.addAssignSaveGroup(asg);
        ulRowQty++;
      }
    }

    // return the number of commands
    return ulRowQty;
  }

  /**
   * setup the array of AssignSaveGroup objects for doing a block assign.
   * 
   * @param context
   *          the GRNDS exchange context
   * @param assignments
   *          the list of currently Displayed Assignments
   * @param assignSaveGroup_array
   *          the AssignSaveGroup array to fill with commands
   * @return the number of commands
   */
  private int constructCommandsForBlockAssign(GrndsExchangeContext context, List assignments,
                                              AssignmentGroup_ARRAY assignmentGroup_array,
                                              AssignSaveGroup_ARRAY assignSaveGroup_array) {
    // count the number of "commands" we are sending to the CCMN25S service
    int ulRowQty = 0;
    AssignmentGroup_ARRAY originalSecondaries = new AssignmentGroup_ARRAY();
    AssignmentGroup_ARRAY modifiedSecondaries = new AssignmentGroup_ARRAY();

    // retrieve the state and request objects from the Session Manager
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    /* SIR 22556 start - allow block assign for secondary workers */
    // construct a set of the secondary assignments that were present before we made changes on this page
    Enumeration enumeration = assignmentGroup_array.enumerateAssignmentGroup();
    while (enumeration.hasMoreElements()) {
      AssignmentGroup assignmentGroup = (AssignmentGroup) enumeration.nextElement();
      if ("SE".equals(assignmentGroup.getSzCdStagePersRole())) {
        originalSecondaries.addAssignmentGroup(assignmentGroup);
      }
    }

    // construct a set of the secondary assignments after our changes on this page
    Iterator iterator = assignments.iterator();
    while (iterator.hasNext()) {
      AssignmentGroup assignmentGroup = (AssignmentGroup) iterator.next();
      if ("SE".equals(assignmentGroup.getSzCdStagePersRole())) {
        modifiedSecondaries.addAssignmentGroup(assignmentGroup);
      }
    }

    Enumeration enumOrigSec = originalSecondaries.enumerateAssignmentGroup();
    Enumeration enumModSec;

    // for every assignment that is in the "original" set, but not in the "current" set, we will create
    // a (D)elete action to remove that secondary assignment
    while (enumOrigSec.hasMoreElements()) {
      AssignmentGroup assignmentGroupOrig = (AssignmentGroup) enumOrigSec.nextElement();
      boolean keepWorker = false;
      enumModSec = modifiedSecondaries.enumerateAssignmentGroup();
      while (enumModSec.hasMoreElements() && !keepWorker) {
        AssignmentGroup assignmentGroupMod = (AssignmentGroup) enumModSec.nextElement();
        // if the original person isn't in the list anymore, need to delete
        if (assignmentGroupOrig.getUlIdPerson() == assignmentGroupMod.getUlIdPerson()
            && assignmentGroupOrig.getSzNmStage().equals(assignmentGroupMod.getSzNmStage())) {
          keepWorker = true;
          break;
        }
      }
      if (!keepWorker) {
        AssignSaveGroup asg = constructAssignSaveGroup("D", assignmentGroupOrig, assignments, context);
        assignSaveGroup_array.addAssignSaveGroup(asg);
        ulRowQty++;
      }

    }
    
    // for every assignment that is in the "current" set, but not in the "modified" set, we will create
    // an (A)dd action to create that secondary assignment
    // SIR 22556 -- Redeclared and redefined original and modified secondaries
    Enumeration enumOrigSec1;
    Enumeration enumModSec1 = modifiedSecondaries.enumerateAssignmentGroup();
    while (enumModSec1.hasMoreElements()) {
      AssignmentGroup assignmentGroupMod = (AssignmentGroup) enumModSec1.nextElement();
      enumOrigSec1 = originalSecondaries.enumerateAssignmentGroup();
      boolean needToAdd = true;
      while (enumOrigSec1.hasMoreElements() && needToAdd) {
        AssignmentGroup assignmentGroupOrig = (AssignmentGroup) enumOrigSec1.nextElement();
        // if the modified person wasn't in the original list, need to add
        if (assignmentGroupOrig.getUlIdPerson() == assignmentGroupMod.getUlIdPerson()) {
          needToAdd = false;
          break;
        }
      }
      if (needToAdd) {
        AssignSaveGroup asg = constructAssignSaveGroup("A", assignmentGroupMod, assignments, context);
        assignSaveGroup_array.addAssignSaveGroup(asg);
        ulRowQty++;
      }
    }
    /* end SIR 22556 */
    
    // if the "ORIGINAL_PRIMARY" is different from the current primary assignments, we will create an
    // (U)pdate action to change the primary assignments
    int origPrimary = (Integer) state.getAttribute(ORIGINAL_PRIMARY, request);
    int newPrimary = ((AssignmentGroup) assignments.get(0)).getUlIdPerson();
    String primaryInd = (String) state.getAttribute("primaryIndicator", request);
    if ("Y".equals(primaryInd)) {
      if (origPrimary != newPrimary) {
        // since all of the assignments are PRIMARY, loop over them, and create an update for each one.
        for (Iterator iterator_assignments = assignments.iterator(); iterator_assignments.hasNext();) {
          AssignmentGroup assignmentGroup = (AssignmentGroup) iterator_assignments.next();
          AssignSaveGroup asg = constructAssignSaveGroup("U", assignmentGroup, assignments, context);
          assignSaveGroup_array.addAssignSaveGroup(asg);
          ulRowQty++;
        }
      }
    }
    
    // return the number of commands
    return ulRowQty;
  }

  /**
   * construct an AssignSaveGroup object to save a row of information to the CCMN25S service
   * 
   * @param actionCode
   *          the action to perform: (D)elete, (U)pdate, or (A)dd
   * @param ag
   *          the AssignmentGroup from which to copy the assignment data
   * @param assignments
   *          the current list of displayed assignments
   * @param context
   *          the GRNDS exchange context
   * @return the new AssignSaveGroup object
   */
  private AssignSaveGroup constructAssignSaveGroup(String actionCode, AssignmentGroup ag, List assignments,
                                                   GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".constructAssignSaveGroup()");
    performanceTrace.enterScope();

    // retrieve the page state and request
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // create the new AssignSaveGroup object
    AssignSaveGroup asg = new AssignSaveGroup();

    // set the action code: (D)elete, (U)pdate, or (A)dd
    asg.setSzCdScrDataAction(actionCode);

    // SIR 19194 - Use new primary's unit id, if it exists.
    Integer newPrimaryUnitId = (Integer) state.getAttribute(UNIT_ID_NEW_PRIMARY, request);
    int unitId;
    if (newPrimaryUnitId != null) {
      unitId = newPrimaryUnitId;
    } else {
      // get the unit from the CCMN80SO object
      unitId = (Integer) state.getAttribute(UNIT_ID, request);
    }
    asg.setUlIdUnit(unitId);

    // set the ID and name of the person on whom we are performing the action
    asg.setUlIdPerson(ag.getUlIdPerson());
    asg.setSzNmPersonFull(ag.getSzNmPersonFull());

    // if we are setting the primary, then the prior ID is the id of the primary we initially retrieved
    // from the DB. otherwise, it should be the ID of whatever the "current" primary is.
    int prior = "PR".equals(ag.getSzCdStagePersRole()) ? (Integer) state.getAttribute(ORIGINAL_PRIMARY, request)
                                                      : ((AssignmentGroup) assignments.get(0)).getUlIdPerson();
    asg.setUlSysIdPriorPerson(prior);

    // set information about the Stage and Case
    asg.setUlIdStage(ag.getUlIdStage());
    asg.setUlIdStagePerson(ag.getUlIdStagePerson());
    asg.setSzCdStageProgram(ag.getSzCdStageProgram());
    asg.setSzCdStageType(ag.getSzCdStageType()); // SIR 23802 set Stage Type for ccmn25S
    asg.setUlIdCase(ag.getUlIdCase());

    // set the timestamp
    asg.setTsLastUpdate(ag.getTsLastUpdate());

    // is this person the primary or secondary asignee?
    asg.setSzCdStagePersRole(ag.getSzCdStagePersRole());

    asg.setBIndOverPolicyLimit(ag.getBIndOverPolicyLimit());

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the AssignSaveGroup object
    return asg;
  }

  /**
   * populate the CCMN08SI input object for calling out to the CCMN08S service
   * 
   * @param context
   *          the GRNDS exchange context
   * @return the newly constructed CCMN08SI object
   */
  private CCMN08SI populateCCMN08SI_Retrieve(GrndsExchangeContext context) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCMN08SI_Retrieve()");
    performanceTrace.enterScope();

    // retrieve the request object from the Session Manager
    HttpServletRequest request = context.getRequest();

    // retrieve user data
    UserProfile user = UserProfileHelper.getUserProfile(request);

    // construct a new CCMN08SI object and its ArchInputStruct
    CCMN08SI ccmn08si = new CCMN08SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn08si.setArchInputStruct(archInputStruct);

    // Set the constant values for the ArchInputStruct
    archInputStruct.setCReqFuncCd("S");
    /** @todo remove unused archinput settings - everything except possibly usPageNbr */
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setUlPageSizeNbr(0);

    // set user information on the ArchInputStruct
    archInputStruct.setSzUserId(user.getUserLogonID());

    // set user information on the CCMN08SI object
    ccmn08si.setSzCdUnitProgram(user.getUserProgram());
    ccmn08si.setSzCdUnitRegion(user.getUserRegion());
    ccmn08si.setSzNbrUnit(user.getUserUnit());
    ccmn08si.setSzCdCounty(user.getUserCounty());

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the newly created service input object
    return ccmn08si;
  }

  /**
   * populate the CCMN80SI input object for calling out to the CCMN80S service
   * 
   * @param context
   *          the GRNDS exchange context
   * @param ulIdUnit
   *          the unit ID from the CCMN08S service
   * @return the newly constructed CCMN80SI object
   */
  private CCMN80SI populateCCMN80SI_Retrieve(GrndsExchangeContext context, int ulIdUnit) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCMN80SI_Retrieve()");
    performanceTrace.enterScope();

    // retrieve the page state and request
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // retrieve user data
    UserProfile user = UserProfileHelper.getUserProfile(request);
    // Added this flag to check if the user is the MES Program Assistant(Eligibility Module)
    boolean isMesProgramAssistant = user.hasRight(UserProfile.SEC_MES_PROGRAM_ASSIST);
    String userCounty = user.getUserCounty();
    String userRegion = user.getUserRegion();

    // determine if we are in on-call mode
    Boolean onCallModeAttrib = (Boolean) state.getAttribute(ON_CALL, request);
    boolean onCallMode = onCallModeAttrib != null && onCallModeAttrib;

    // construct a new CCMN80SI service input object and its ArchInputStruct
    CCMN80SI ccmn80si = new CCMN80SI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn80si.setArchInputStruct(archInputStruct);

    // set the fixed values on the ArchInputStruct
    archInputStruct.setCReqFuncCd(onCallMode ? "O" : "F");
    // archInputStruct.setBPerfInd( ZERO_STRING );
    // archInputStruct.setBDataAcsInd( ZERO_STRING );
    // archInputStruct.setUlSysNbrReserved1( 0 );
    // archInputStruct.setUlSysNbrReserved2( 0 );
    // archInputStruct.setSzDstribStrtTs( StringHelper.EMPTY_STRING );
    // archInputStruct.setSzSysTxtGenericIP( StringHelper.EMPTY_STRING );
    // archInputStruct.setSzSysTxtGenericSSN( StringHelper.EMPTY_STRING );

    // set the page information on the ArchInputStruct
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setUlPageSizeNbr(RESULTS_PER_PAGE);

    // set user information
    archInputStruct.setSzUserId(user.getUserLogonID());

    // set the ulIDPerson from global data
    ccmn80si.setUlIdPerson(onCallMode ? 0 : GlobalData.getUlIdPerson(request));

    // set the ulIdUnit from the CCMN08S service call
    ccmn80si.setUlIdUnit(onCallMode ? 0 : ulIdUnit);

    // if we are in on-call viewing mode...
    if (onCallMode) {
      // get the stage from the first assignment in the assignments table
      if (state.getAttribute(ASSIGNMENTS_LIST, request) != null) {
        List assignments = (List) state.getAttribute(ASSIGNMENTS_LIST, request);
        AssignmentGroup ag = (AssignmentGroup) assignments.get(0);
        ccmn80si.setSzCdOnCallProgram(ag.getSzCdStageProgram());
      } else {
        ccmn80si.setSzCdOnCallProgram(GlobalData.getSzCdStageProgram(request));
      }

      // retrieve the county information from the county select box, and set it on the input object
      String county = "";
      if (ContextHelper.getString(context, COUNTY) != null) {
        county = ContextHelper.getString(context, COUNTY);
      } else if (state.getAttribute(IntakeConstants.COUNTY, request) != null) {
        county = (String) state.getAttribute(IntakeConstants.COUNTY, request);
      }
      request.setAttribute("selSzCdOnCallCounty", county);
      ccmn80si.setSzCdOnCallCounty(county);
    } else if (state.getAttribute(IntakeConstants.COUNTY, request) != null) {
      String county = (String) state.getAttribute(IntakeConstants.COUNTY, request);
      ccmn80si.setSzCdOnCallProgram(StringHelper.EMPTY_STRING);
      ccmn80si.setSzCdOnCallCounty(county);
      request.setAttribute("selSzCdOnCallCounty", county);
    } else {
      // set these fields to the empty string
      ccmn80si.setSzCdOnCallProgram(StringHelper.EMPTY_STRING);
      ccmn80si.setSzCdOnCallCounty(StringHelper.EMPTY_STRING);
    }

    // set the fixed values on the CCMN80SI object
    ccmn80si.setSzCdRegion(StringHelper.EMPTY_STRING);
    ccmn80si.setUlPageSizeNbr(100);

    // copy the stage ID information from page state into a UlIdStage_ARRAY structure, and
    // set it onto the CCMN80SI object
    int[] stageIdArray = (int[]) state.getAttribute(STAGE_ID_ARRAY, request);
    UlIdStage_ARRAY a = new UlIdStage_ARRAY();
    int tempRowQty = 1; // SIR 22938
    if (stageIdArray != null) {
      a.setUlIdStage(stageIdArray);
      //for (int i = 0; i < stageIdArray.length; i++) {
      //  a.addUlIdStage(i, stageIdArray[i]);
      //}
      a.setUlRowQty(stageIdArray.length);
      // 22938 - gets the length to use for the ccmn80si object
      tempRowQty = stageIdArray.length;
    } else {
      a.addUlIdStage(GlobalData.getUlIdStage(request));
      // 22938 sets the row qty as 1 if there is no array of stages
      a.setUlRowQty(tempRowQty);
    }
    ccmn80si.setUlIdStage_ARRAY(a);
    // 22938 uses tempRowQty instead of stageIdArray.length to avoid null pointer
    ccmn80si.setUlRowQty(tempRowQty);

    ccmn80si.setIndMesProgramAssistant(isMesProgramAssistant);
    ccmn80si.setSzCdUserCounty(userCounty);
    ccmn80si.setSzCdUserRegion(userRegion);

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the CCMN80SI service input object
    return ccmn80si;
  }

  /**
   * create a new AssignmentGroup to use as a placeholder on the page until data is committed to the DB
   * 
   * @param availStaffGroup
   *          the staff member to be assigned
   * @param primary
   *          is this a primary assignment?
   * @param agCopy
   *          the AssignmentGroup object from which to copy case and staff data
   * @return the newly created AssignmentGroup
   */
  private AssignmentGroup createAssignment(AvailStaffGroup availStaffGroup, boolean primary, AssignmentGroup agCopy) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".createAssignment()");
    performanceTrace.enterScope();

    // create a new AssignmentGroup object
    AssignmentGroup assignmentGroup = new AssignmentGroup();

    // set the information from the newly assigned staff member
    assignmentGroup.setSzNmPersonFull(availStaffGroup.getSzNmPersonFull());
    assignmentGroup.setUlIdPerson(availStaffGroup.getUlIdPerson());

    // set the role -- PRIMARY or SECONDARY
    assignmentGroup.setSzCdStagePersRole(primary ? "PR" : "SE");

    // copy case and stage fields from the source AssignmentGroup
    assignmentGroup.setSzNmStage(agCopy.getSzNmStage());
    assignmentGroup.setUlIdStage(agCopy.getUlIdStage());
    assignmentGroup.setUlIdStagePerson(agCopy.getUlIdStagePerson());
    assignmentGroup.setSzCdStageProgram(agCopy.getSzCdStageProgram());
    assignmentGroup.setSzCdStageType(agCopy.getSzCdStageType()); // SIR 23879
    assignmentGroup.setUlIdCase(agCopy.getUlIdCase());
    assignmentGroup.setTsLastUpdate(agCopy.getTsLastUpdate());

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    // return the newly created AssignmentGroup
    return assignmentGroup;
  }

  /**
   * populates the Assignments list with the initial information returned from the CCMN80S service. <p/> This method
   * parses the return structure from the CCMN80S service, and puts the initial assignment information into a
   * java.util.List, which is persisted to the State for the lifespan of the Assign conversation. <p/> After executing
   * this method, the state will contain a java.util.List containing the initial assignments, as an attribute named
   * "ASSIGMENTS". For single assignments, this method will guarantee that the first element in the list is the primary
   * assignment.
   * 
   * @param state
   *          the BaseSessionStateManager for the page
   * @param request
   *          the HttpServletRequest for the page
   * @param ccmn80SO
   *          the service object returned from the call to the CCMN80S service
   */
  private void populateInitialAssignments(BaseSessionStateManager state, HttpServletRequest request, CCMN80SO ccmn80SO) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateInitialAssignments()");
    performanceTrace.enterScope();

    // only do this once, afterwards the list will remain in page state
    if (state.getAttribute(ASSIGNMENTS_LIST, request) == null) {
      // construct a new ArrayList
      List<AssignmentGroup> assignments = new ArrayList<AssignmentGroup>();

      // get the list of assignments returned from the CCMN80S service, and step over each of its elements
      if(ccmn80SO != null && ccmn80SO.getAssignmentGroup_ARRAY() != null) {
        AssignmentGroup[] assignmentArray = ccmn80SO.getAssignmentGroup_ARRAY().getAssignmentGroup();
        for (int i = 0; i < assignmentArray.length; i++) {
          // for each assignment,
          AssignmentGroup assignment = assignmentArray[i];
          // if it is a primary assignment...
          if ("PR".equals(assignment.getSzCdStagePersRole())) {
            // add it to the front of the list, and store the ID of the user as ORIGINAL_PRIMARY,
            assignments.add(0, assignment);
            state.setAttribute(ORIGINAL_PRIMARY, assignment.getUlIdPerson(), request);
          } else {
            // otherwise add it to the end of the list.
            assignments.add(assignment);
          }
        }
      }

      // SIR 22556 - sorts grouped by stage - populates state with new list
      populateSortedAssignments(state, request, assignments);
      // store the list in page state
      // state.setAttribute( ASSIGNMENTS_LIST, assignments, request );
    }

    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /*
   * * SIR 10261 - The save service is always called, but performs different * actions depending on from where the
   * Assign window was called and the * type of stage to be assigned. So, we need to provide the service with * a
   * meaningful indicator telling it what funtionality to provide. * Based on the indicator, the following is performed - *
   * UNDETERMINED no telling - this should never be passed in * INTAKE_APS call full service + stage prog *
   * INTAKE_NON_APS only post event * INTAKE_NON_INT only post event * INTAKE_FULL_SVC call full service *
   * NON_INT_FUL_SV call full service * NON_INT_FAD only post event * * Full service functionality is the updating of
   * the STAGE_PERSON_LINK * table, posting a "Primary Assignment Issued" event, sending and * transferring ToDos,
   * updating stage information, etc. * * The following set of if-else-if statements classifies the stage and * sets the
   * indicator to the appropriate value and begins by checking * the calling window. The Assign window can be called
   * from three * "places" - * Intake dialogue (Call Entry and Call Summary) * Assigned Workload * F/A Home dialogue
   * (Home Demographics, Close/Reopen Home) * Once the window has been determined, it then determines how much * service
   * processing is necessary by looking at the stage and whether * or not anything has changed in the Assignments
   * listbox.
   */
  private String determineCRecFunc(GrndsExchangeContext context, boolean stageProgAPS_INT, AssignmentGroup primary,
                                   AssignSaveGroup_ARRAY assignSaveGroup_array) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".determineCRecFunc()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String callingPage = (String) state.getAttribute(PREVIOUS_URL, request);

    String cReqFunc = UNDETERMINED;

    if (callingPage.equals(INTAKE_PAGE) || stageProgAPS_INT) {
      if (primary.getSzCdStage().equals(CodesTables.CSTAGES_INT)) {
        if (primary.getSzCdStageProgram().equals(CodesTables.CCLASS_AFC)
            || primary.getSzCdStageProgram().equals(CodesTables.CCLASS_APS)) {
          cReqFunc = INTAKE_APS;
        } else {
          cReqFunc = INTAKE_NON_APS;
        }
      } else if (primary.getSzCdStage().equals(CodesTables.CCLASS_IR)
                 || primary.getSzCdStage().equals(CodesTables.CCLASS_SPC)) {
        cReqFunc = INTAKE_NON_INT;
      }
    } else if (callingPage.equals(WORKLOAD_PAGE) || callingPage.equals(OTHER_WORKLOAD_PAGE)
               || callingPage.equals(APPROVAL_STATUS_PAGE)) {
      cReqFunc = NON_INT_FUL_SVC;
    }
    // I'm not sure we are comgni from fad any more, i cant find any other pages
    else if (callingPage.equals(HOME_INFO_NEW_PAGE) || callingPage.equals(HOME_INFO_PAGE)
             || callingPage.equals(ADD_HOME_OTHER)) {
      cReqFunc = NON_INT_FUL_SVC;
    }

    if (cReqFunc.equals(INTAKE_NON_APS) || cReqFunc.equals(INTAKE_NON_INT)) {
      Enumeration assignSaveGroup_enum = assignSaveGroup_array.enumerateAssignSaveGroup();
      while (assignSaveGroup_enum.hasMoreElements()) {
        AssignSaveGroup assignSaveGroup_detail = (AssignSaveGroup) assignSaveGroup_enum.nextElement();
        if ("A".equals(assignSaveGroup_detail.getSzCdScrDataAction())
            || "U".equals(assignSaveGroup_detail.getSzCdScrDataAction())
            || "D".equals(assignSaveGroup_detail.getSzCdScrDataAction())) {
          cReqFunc = INTAKE_FULL_SVC;
        }
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return cReqFunc;
  }

  private boolean incomingStatusIsClosed(int ulIdStage) throws ServiceException {
    boolean incStatusCLD = false;

    CallEntryRtrvIn callentryrtrvin = new CallEntryRtrvIn();
    callentryrtrvin.setUlIdStage(ulIdStage);
    callentryrtrvin.setUlIdPerson(0);

    CallEntryRtrvOut callEntryRtrvOut = intake.retrieveCallEntryCallDecision(callentryrtrvin);
    // (CallEntryRtrvOut) WtcHelper.callService("CINT25S", callentryrtrvin, CallEntryRtrvOut.class);
    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }
    CallEntrySvcStruct callEntryData = callEntryRtrvOut.getCallEntrySvcStruct();
    if (callEntryData == null) {
      callEntryData = new CallEntrySvcStruct();
    }
    if (CodesTables.CINCMGST_CLD.equals(callEntryData.getCdIncmgStatus())) {
      incStatusCLD = true;
    }
    return incStatusCLD;
  }

  /** this is called to sort the assignments section by id_stage, so primary and secondary workers are sorted together */
  private void populateSortedAssignments(BaseSessionStateManager state, HttpServletRequest request,
                                         List<AssignmentGroup> sortedAssignments) {
    // setup tracer and enter trace scope
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateSortedAssignments()");
    performanceTrace.enterScope();

    // construct a new ArrayList
    // List sortedAssignments = new ArrayList();

    // get the list of assignments returned from the CCMN80S service, and step over each of its elements
    // AssignmentGroup[] assignmentArray = ccmn80SO.getAssignmentGroup_ARRAY().getAssignmentGroup();
    // for (int i = 0; i < assignmentArray.length; i++)
    // {
    // for each assignment,
    // AssignmentGroup assignment = assignmentArray[i];
    // sortedAssignments.add(assignment);
    // }

    Collections.sort(sortedAssignments, new AssignmentComparator());

    // store the list in page state
    state.setAttribute(ASSIGNMENTS_LIST, sortedAssignments, request);
    // record time in tracer and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  private static class AssignmentComparator implements Comparator<AssignmentGroup> {
    public int compare(AssignmentGroup ag1, AssignmentGroup ag2) {
      return ag1.getUlIdStage() - ag2.getUlIdStage();
    }
  }
}
