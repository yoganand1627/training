package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * <p>AssignCustomValidation.java</p>
 *
 * @author Bryon Jacob
 * @version 1.0 * Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 6/29/05   cooganpj     SIR 23726 - Removed code added in SIR
 *          23572.  For MPS Phase II, the validation will take place in the assignPrimary_xa method of
 *          AssignConversation.java 5/18/05   cooganpj     SIR 23572 - Removed unused call to GlobalData 05/11/05
 *          cooganpj     SIR 23572 - Imported CaseUtility and added call to getCaseCheckoutStatus to present error
 *          message when the user attempts to assign a new primary worker for a checked out case. 10/14/03  dickmaec
 *          SIR 19857 -- Verified that getInputValue() value was not being used. 08/11/2005 gerryc       SIR 22556 -
 *          block assigning secondary is now ok.
 */
@SuppressWarnings("serial")
public class AssignCustomValidation extends FormValidation {
  // inherit javadoc
  protected boolean validateForm() {
    // get page context, state, and request
    GrndsExchangeContext context = super.getGrndsExchangeContext();
    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = context.getRequest();

    // get the list of assignments and the array of stage IDs from the page state
    List assignments = (List) state.getAttribute(AssignConversation.ASSIGNMENTS_LIST, request);
    int[] stageIdArray = (int[]) state.getAttribute(AssignConversation.STAGE_ID_ARRAY, request);
    
    //-- these should not be null, but null checks will ensure no NPEs
    if(assignments == null) {
      assignments = new ArrayList();
    }
    int stageIdArrayLength = stageIdArray != null ? stageIdArray.length : 0;

    // call the individual validation methods, keeping track of whether any errors have occurred
    validateAssign(context, assignments, stageIdArrayLength);
    validateUnAssign(context, assignments);
    validateSearch(context, stageIdArrayLength);

    // return true if no errors occurred, false otherwise
    return getErrorMessages().isEmpty();
  }

  /**
   * performs validation of page state when the search button has been pressed
   *
   * @param context             the GRNDS exchange context
   * @param hasValidationErrors true if there were previous errors, false otherwise
   * @return true if no errors occurred, false otherwise
   */
  private void validateSearch(GrndsExchangeContext context, int stageIdArrayLength) {
    // if the Search button has been pressed...
    if (super.isButtonPressed("btnSearch")) {
      // determine if we are in onCallMode, and what county has been selected
      boolean onCallMode = AssignConversation.ON_CALL.equals(
              ContextHelper.getStringSafe(context, "rbFullUnitOrOnCall"));
      String county = ContextHelper.getStringSafe(context, AssignConversation.COUNTY);

      // if we are in onCallMode...
      if (onCallMode) {
        // and we are doing a block assignment...
        if (stageIdArrayLength > 1) {
          // set the  message, and flag the error
          setErrorMessage(Messages.MSG_ONCALL_MULT_STAGES);
        }

        // and the county is blank...
        if ("".equals(county)) {
          // set the MSG_CMN_COUNTY_BLANK message, and flag the error
          setErrorMessage(Messages.MSG_CMN_COUNTY_BLANK);
        }
      }
      // otherwise...
      else {
        // in full-unit search, we may not specify the county!
        if (!"".equals(county)) {
          // set the MSG_NO_FULL_UNIT_COUNTY message, and flag the error
          setErrorMessage(Messages.MSG_NO_FULL_UNIT_COUNTY);
        }
      }
    }
  }

  /**
   * performs validation of the page state when one of the Assign buttons has been pressed
   *
   * @param context             the GRNDS exchange context
   * @param assignments         the list of current Assignments
   * @param stageIdArray        an array of the Stage IDs being assigned
   * @param hasValidationErrors true if there were previous errors, false otherwise
   * @return true if no errors occurred, false otherwise
   */
  private void validateAssign(GrndsExchangeContext context,
                              List assignments,
                              int stageIdArrayLength) {
    // if one of the Assign buttons has been pressed...
    if (super.isButtonPressed("btnPrimary") || super.isButtonPressed("btnSecondary")) {
      // get the ID of the selected staff member
      String selection = ContextHelper.getStringSafe(context, "rbAvailableStaff");
      // if none has been selected...
      if ("".equals(selection)) {
        // set the MSG_SELECT_PRIM_OR_SEC message, and flag the error
        setErrorMessage(Messages.MSG_SELECT_PRIM_OR_SEC);
      }
      //SIR 23572
      //String checkoutErrorMsg;
      // loop over the current assignments...
      for (Iterator iterator = assignments.iterator(); iterator.hasNext();) {
        // for each of the assignments...
        AssignmentGroup assignmentGroup = (AssignmentGroup) iterator.next();

        // if the selected staff member matches that assignment...
        int selectedID = 0;
        try {
          selectedID = Integer.parseInt(selection);
        }
        catch (NumberFormatException e) {
          selectedID = 0;
        }
        if (selectedID == (assignmentGroup.getUlIdPerson())) {
          // then set the MSG_CMN_DUP_SP_LINK message and flag the error -- if any of these
          // match, then we are trying to assign someone who has already been assigned to this
          // stage!
          //
          // there is a different message for block and single assign...
          //SIR#17948:  MSG_CMN_DUP_SP_LINK was replaced with MSG_CMN_ASSGN_EXIST
          setErrorMessage(MessageLookup.getMessageByNumber(
                  (stageIdArrayLength > 1) ? Messages.MSG_CMN_DUP_BL_ASSGN : Messages.MSG_CMN_ASSGN_EXIST));

          // we can stop after the first success
          break;
        }
      }

      // if we are attempting secondary assignment
      if (super.isButtonPressed("btnSecondary")) {
        /* SIR 22556 - we now allow multiple secondary assignments*/
        // if there were multiple stages passed in, we cannot do secondary assignments
        if (stageIdArrayLength > 1) {
          // set the MSG_ASSIGN_SECONARY message and flag the error
          setErrorMessage(Messages.MSG_ASSIGN_SECONARY);
        }

        List<Integer> stageList = new ArrayList<Integer>(20);
        for (Iterator iterator = assignments.iterator(); iterator.hasNext();) {
          // add each stage to a arraylist
          AssignmentGroup assignmentGroup = (AssignmentGroup) iterator.next();
          if (!stageList.contains(assignmentGroup.getUlIdStage())) {
            stageList.add(assignmentGroup.getUlIdStage());
          }
        }

        //then loop through array, getting counts of stages in the assignments list
        Iterator<Integer> itStages = stageList.iterator();

        while (itStages.hasNext()) {
          int secCount = 0;
          int ulIdStage = itStages.next();
          for (Iterator itAssngmnts = assignments.iterator(); itAssngmnts.hasNext();) {
            AssignmentGroup assignmentGroup = (AssignmentGroup) itAssngmnts.next();
            //for each row that we find that has a certain stage, increase the count
            if (assignmentGroup.getUlIdStage() == ulIdStage) {
              secCount++;
            }
          }
          if (secCount > 4) {
            setErrorMessage(Messages.MSG_ASSIGN_TOO_MANY_SECONDARY);
            break;
          }
        }//end looping through hashmap of stages
        // SIR 22556 end
      }
    }
  }

  /**
   * performs validation of the page state when the unAssign button has been pressed
   *
   * @param context             the GRNDS exchange context
   * @param assignments         the list of current Assignments
   * @param hasValidationErrors true if there were previous errors, false otherwise
   * @return true if no errors occurred, false otherwise
   */
  private void validateUnAssign(GrndsExchangeContext context,
                                List assignments) {
    // if the UnAssign button has been pressed...
    if (super.isButtonPressed("btnUnassign")) {
      // get the selected index from the Assignments table.  the indices are 1-based, which maps
      // correctly to the Assignments list, because we can only unAssign secondary asignees, which
      // are stored in indices 1 and higher
      int indexToUnAssign = ContextHelper.getIntSafe(context.getRequest(), "rbAssignments");

      // techincally, we probably only need to check for ZERO here, but this will protect against a user
      // doctoring a request to create an unsupported situation.
      if (indexToUnAssign < 1 || indexToUnAssign >= assignments.size()) {
        // set the MSG_SELECT_UNASSIGN message, and flag the error
        setErrorMessage(Messages.MSG_SELECT_UNASSIGN);
      }
    }

  }
}