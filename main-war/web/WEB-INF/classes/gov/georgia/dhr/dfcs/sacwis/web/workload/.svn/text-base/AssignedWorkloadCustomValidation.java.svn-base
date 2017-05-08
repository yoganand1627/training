package gov.georgia.dhr.dfcs.sacwis.web.workload;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

/**
 * This class is used to perform the custom validation on Assigned Workload when the user attempts to Assign or Stage
 * Progress.
 * 
 * @author Jenn M Casdorph 11/25/2002 Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 09/25/03 Merle Demo Sir19809 Change Messages on stage
 *         progression. Added new if for INV stages in APS and CPS with message MSG_NOT_PAGE_PROG and changed message
 *         for APS, AFC and PRS to MSG_CAN_NOT_PROG <p/> 10/14/03 dickmaec SIR 19857 -- Verified that getInputValue()
 *         value was not being used. <p/> 11/25/03 dickmaec Sir19809 -- Updated the Logic to handle the Stage
 *         Progression. See comments below. 06/01/05 ochumd SIR 23019 - CFH,CCL and CCR are new CRSR types and are not
 *         to be stage progressed. They are therefore, added to the Message MSG_CAN_NOT_PROG edit. 08/09/05 gerryc SIR
 *         22556 - don't allow primary and secondary stages to be done at the same time. Only supervisors (or above)
 *         viewing a workload can view the assign page for secondary assignments.
 */
public class AssignedWorkloadCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "AssignedWorkloadCustomValidation";

  /**
   * <p>
   * This method contains custom validation that is checked when the user tries to Assign or Stage Progress a stage from
   * Assigned Workload.
   * </p>
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = super.getRequest();

    CCMN14SO ccmn14so = (CCMN14SO) state.getAttribute("CCMN14SO", request);
    ROWCCMN37DO_ARRAY row37doArray;
    if (ccmn14so != null) {
      row37doArray = ccmn14so.getROWCCMN37DO_ARRAY();
    } else {
      row37doArray = new ROWCCMN37DO_ARRAY();
    }

    String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbx_");

    // If the user did not select a row, display a message
    if (checkedValues.length == 0) {
      setErrorMessage(Messages.MSG_SELECT_ROW_ACTION);
    }
    // If the user selected Stage Progression
    else if (super.isButtonPressed("btnStageProgression")) {
      // If the user selected more than one row, display a message
      if (checkedValues.length > 1) {
        setErrorMessage(Messages.MSG_SELECT_ONE_STGPROG);
      }
      // Else get the record group the user selected and pass it to the stage progression custom validation helper
      // method
      else {
        ROWCCMN37DO row37do;
        int index = 0;
        if (checkedValues.length == 1) {
          index = Integer.parseInt(checkedValues[0]);
        }
        if (row37doArray.getROWCCMN37DOCount() >= index) {
          row37do = row37doArray.getROWCCMN37DO(index);
        } else {
          row37do = new ROWCCMN37DO();
        }
        stageProgressionCustomValidation(row37do);
      }
    }
    // If the user selected Assign
    else if (super.isButtonPressed("btnAssign")) {
      // If the user selected more than 20 rows, display a message
      if (checkedValues.length > 20) {
        setErrorMessage(Messages.MSG_ASSIGN_LT_20);
      }
      // Else perform the assign custom validation
      else {
        assignCustomValidation(row37doArray, checkedValues);
      }
    }

    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }

  /**
   * <p>
   * This custom validation submethod is only run if the user has selected Stage Progression
   * </p>
   * 
   * @param row37do
   * @param indSupervisor
   * @return
   */
  private void stageProgressionCustomValidation(ROWCCMN37DO row37do) {
    /*
     * * The Stage Progression menu item should only be enabled in the * following cases - * 1) the stage has a name
     * associated with it * 2) the stage is a CPS Intake stage that has a closure code of * ACA, DIV or SNM * 3) the
     * stage is a Foster Care Child, Foster Care Family, Adoption * or CPS Ongoing stage and the user is the unit
     * approver for the * primary worker assigned to the stage ***Note- this no longer applies*** * To properly catch 
     * all of the cases, we have to perform these checks - * 1) if the stage doesn't have a name * 2) if the stage 
     * program is not CPS, display an error message. * 3) else if the stage is not Intake, Foster Care Child, 
     * Foster Care Family, * CPS Ongoing or Adoption, display an error message. * 4) else if the stage is Intake and 
     * the closure code is neither ACA, * DIV, or SNM, display an error message. * NOTE - Per STGAP00007705, this no
     * longer applies and the user only need to have the Assign Workload attribute -> 5) else if the stage is Foster Care 
     * Child, Foster Care Family, * Adoption or CPS Ongoing and the user is not the unit approver, * display an error 
     * message. * 6) else if the stage is not associated with a case at all, display an error message. * --Updated SIR 19809-- * Message: MSG_NOT_PAGE_PROG *
     * APS-INV -- 23266689 * APS-AOC -- 7113 * CPS-INV -- 24662063 * CPS-ADO -- 26560794 * Message: MSG_CAN_NOT_PROG *
     * APS-SVC -- 23266689 * AFC-INV -- 27985327 * LIC-INV -- 24078256 * CPS-FAD -- 26560794 * CPS-PAL -- 9192 * CPS-PAD --
     * 26560794 * Message: MSG_NO_STAGE_PROG * CPS-INT -- 2271 * CPS-SUB -- 24662063 * CPS-FSU -- 24662063 * CPS-FRE --
     * 24662063 * CPS-FPR -- 24662063 * * Listed above are the cases and program types that should display for each
     * message. * I added some Person Ids that will these type cases. * --Updated SIR 19809-- *
     */

    HttpServletRequest request = getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    // Message MSG_NOT_PAGE_PROG
    if (row37do.getSzNmStage() == null || "".equals(row37do.getSzNmStage())) {
      setErrorMessage(Messages.MSG_NO_STAGE_PROG);
    }
    // Message MSG_NOT_PAGE_PROG
    else if ("CPS".equals(row37do.getSzCdStageProgram()) && "INV".equals(row37do.getSzCdStage())) {
      setErrorMessage(Messages.MSG_NOT_PAGE_PROG);
    }
    // Message MSG_CAN_NOT_PROG
    else if ((AssignedWorkloadConversation.FOSTER_ADOPTIVE.equals(row37do.getSzCdStage()))) {
      setErrorMessage(Messages.MSG_CAN_NOT_PROG);
    }
    // Message MSG_NO_STAGE_PROG
    else if (!AssignedWorkloadConversation.INTAKE_STAGE.equals(row37do.getSzCdStage())
             && !AssignedWorkloadConversation.SUBCARE.equals(row37do.getSzCdStage())
             && !AssignedWorkloadConversation.FAMILY_SUBCARE.equals(row37do.getSzCdStage())
             && !AssignedWorkloadConversation.FAMILY_PRES.equals(row37do.getSzCdStage())
             && !AssignedWorkloadConversation.ADOPTION.equals(row37do.getSzCdStage())) {
      setErrorMessage(Messages.MSG_NO_STAGE_PROG);
    }
    // Message MSG_CAN_NOT_PROG
    else if (!AssignedWorkloadConversation.CPS_PROGRAM.equals(row37do.getSzCdStageProgram())) {
      setErrorMessage(Messages.MSG_CAN_NOT_PROG);
    }
    // Message MSG_NO_STAGE_PROG
    // flip these statements so not to get an NPE, Have the constants equal the variable
    else if (AssignedWorkloadConversation.INTAKE_STAGE.equals(row37do.getSzCdStage())
             && !(AssignedWorkloadConversation.DISPOSITION_CODE_ACA.equals(row37do.getSzCdStageReasonClosed())
                  || AssignedWorkloadConversation.DISPOSITION_CODE_DIV.equals(row37do.getSzCdStageReasonClosed())
                  || AssignedWorkloadConversation.DISPOSITION_CODE_IC.equals(row37do.getSzCdStageReasonClosed())
                  || AssignedWorkloadConversation.DISPOSITION_CODE_PA.equals(row37do.getSzCdStageReasonClosed())
                  || AssignedWorkloadConversation.DISPOSITION_CODE_PF.equals(row37do.getSzCdStageReasonClosed())
                  || AssignedWorkloadConversation.DISPOSITION_CODE_NI.equals(row37do.getSzCdStageReasonClosed()) || AssignedWorkloadConversation.SCREEN_OUT_NO_MALTREATMENT_CODE
                                                                                                                                                                                .equals(row37do
                                                                                                                                                                                               .getSzCdStageReasonClosed()))) {
      setErrorMessage(Messages.MSG_NO_STAGE_PROG);
    }
    //STGAP00010820: When the stage closure event for an Adoption stage is submitted with a reason Adoption Finalized, 
    //the system should not allow stage progression from ADO. As per the ADAM implementation when the adoption stage closure
    //event is approved a new case with the PAD stage will be automatically created by the system
    else if(AssignedWorkloadConversation.ADOPTION.equals(row37do.getSzCdStage()) && AssignedWorkloadConversation.RESAON_CLOSED_ADO_FINAL.equals(row37do.getSzCdStageReasonClosed())){
      setErrorMessage(Messages.MSG_NO_STAGE_PROG);
    }
    // STGAP00007705 - If user has the Assign Workload security attribute checked for their profile, user should be able to 
    // stage progress from FCC to ADO. This code requires that the supervisor be the unit approver
    // but you can have staff members that are not the actual unit approver but do have the 
    // SUPERVISOR profile. This would allow them to see the 'Stage Progression' button on the 
    // Assigned Workload page else they would not. Commenting this out and leaving it here in case
    // later we want to restrict it to only the Unit Approver.   
    // Message MSG_NO_STAGE_PROG
    //else if ((AssignedWorkloadConversation.SUBCARE.equals(row37do.getSzCdStage())
    //          || AssignedWorkloadConversation.FAMILY_SUBCARE.equals(row37do.getSzCdStage())
    //          || AssignedWorkloadConversation.FAMILY_PRES.equals(row37do.getSzCdStage()) 
    //          || AssignedWorkloadConversation.ADOPTION.equals(row37do.getSzCdStage()))
    //          && (!userProfile.getSysSupervisorAccess())){
    //  setErrorMessage(Messages.MSG_NO_STAGE_PROG);
    //}
    
    // Message MSG_NO_STAGE_PROG
    else if (row37do.getUlIdCase() == 0) {
      setErrorMessage(Messages.MSG_NO_STAGE_PROG);
    }
  }

  /**
   * @param row37Array
   * @param checkedValues
   * @return
   */
  private void assignCustomValidation(ROWCCMN37DO_ARRAY row37Array, String[] checkedValues) {
    // flags indicating whether an error message has already been set
    boolean cannotAssignErrorSet = false;
    boolean noCaseIdErrorSet = false;
    boolean assignSensitiveErrorSet = false;

    // SIR 22556 - set these booleans to see if a worker is trying to do
    // primary and secondary at the same time
    boolean secondAssign = false;
    boolean primAssign = false;

    HttpServletRequest request = getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    //Added this flag to check if the user is the MES Program Assistant(Eligibility Module)
    boolean isMesProgramAssistant = user.hasRight(UserProfile.SEC_MES_PROGRAM_ASSIST);

    for (int i = 0; i < checkedValues.length; i++) {
      ROWCCMN37DO row37TEST = row37Array.getROWCCMN37DO(Integer.parseInt(checkedValues[i]));
      //  A user cannot assign a stage in which they are a secondary worker, but if they are MES 
      // Program Assistant then they can assign a stage in which they are a secondary worker to other
      // MES workers.
      if ("SE".equals(row37TEST.getSzCdStagePersRole()) && !cannotAssignErrorSet && !user.getSysSupervisorAccess() 
                      && !isMesProgramAssistant) {
        setErrorMessage(Messages.MSG_CANNOT_ASSIGN);
        cannotAssignErrorSet = true;
      }
      // Dejuanr - 6/3/03 - no sir, error i found.
      // If the row selected is a stage from the temp_stage_pers_link table
      // (used for crash recovery in Intake). Stage is unassignable.
      if (("NO ASSIGN".equals(row37TEST.getSzNmCase()) || row37TEST.getSzNmCase() == null) && !noCaseIdErrorSet) {
        setErrorMessage(Messages.MSG_ASSIGN_NO_CASEID);
        noCaseIdErrorSet = true;
      }
      // A user cannot multiple assign any case that is marked as sensitive
      if ((checkedValues.length > 1) && ("Y".equals(row37TEST.getBIndCaseSensitive())) && !assignSensitiveErrorSet) {
        setErrorMessage(Messages.MSG_ASSIGN_SENSITIVE);
        assignSensitiveErrorSet = true;
      }

      // SIR 22556 - check to make sure they aren't doing both primary and
      // secondary at the same time.
      if ("SE".equals(row37TEST.getSzCdStagePersRole())) {
        secondAssign = true;
      }
      if ("PR".equals(row37TEST.getSzCdStagePersRole())) {
        primAssign = true;
      }
    }// end looping through checked stages

    // SIR 22556 - message says "Cannot access assign for primary and secondary
    // assignments at the same time"
    if (secondAssign && primAssign) {
      setErrorMessage(Messages.MSG_BOTH_ASSIGN);
    }

  }
}
