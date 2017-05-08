package gov.georgia.dhr.dfcs.sacwis.web.admin;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN23SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is used to perform the custom validation on Unit Detail when the user chooses to Save the information on
 * the page.
 * 
 * @author Paul J Lang (Jeff and Dann too) 11/15/2002 <p/> Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 07/16/03 CASDORJM SIR 18790 - Added clause to make sure the
 *         user is not attempting to delete the LEAD. 10/13/03 Dickmaec SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue();
 */
@SuppressWarnings("serial")
public class UnitCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "UnitCustomValidation";

  public static final int MAX_ROWS = 50;

  public static final int MSG_UNIT_INPUT_REQ = 60046;

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = super.getRequest();

    CCMN23SO ccmn23so = (CCMN23SO) state.getAttribute("CCMN23SO", request);
    ROWCCMN23SOG01_ARRAY personListArrayOut = ccmn23so.getROWCCMN23SOG01_ARRAY();

    if (!this.isButtonPressed("btnDelete")) {
      if (personListArrayOut != null) {
        if (personListArrayOut.getROWCCMN23SOG01Count() > MAX_ROWS) {
          setErrorMessage(Messages.MSG_TOO_MANY_LB_ROWS);
        }
      }
    }
    // JMC - SIR 18790 - The user should not be able to delete the LEAD from the Unit. We
    // need to check to make sure that the persons being deleted are not currently marked as
    // Lead or were marked as Lead the last time the page was loaded. By checking the latter
    // we can ensure that the user does not delete a person that is saved as the lead in the database
    // but no longer marked as lead on the page due to unsaved changes.
    else {
      String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbxPersonIndex_CLEAN");
      Set<String> checkedHash = new HashSet<String>(Arrays.asList(checkedValues));
      int leadID = ContextHelper.getIntSafe(request, "hdnLeadId");
      int rowCount = 0;

      int personCount = personListArrayOut.getROWCCMN23SOG01Count();
      for (int i = 0; i < personCount; i++) {
        ROWCCMN23SOG01 outRowPerson = personListArrayOut.getROWCCMN23SOG01(i);

        if (checkedHash.contains("" + i)) {
          String role = ContextHelper.getStringSafe(request, "szCdUnitMemberRole" + i);
          if (CodesTables.CUNMBRRL_40.equals(role)) {
            setErrorMessage(Messages.MSG_NO_DELETE_LEAD);
            break;
          } else if (leadID == outRowPerson.getUlIdPerson()) {
            setErrorMessage(Messages.MSG_SAVE_UNIT_MNT_FIRST);
            break;
          }
          rowCount++;
        }
      }
    }

    if (personListArrayOut != null) {
      int leadCount = 0;
      for (int i = 0; i < MAX_ROWS; i++) {
        String roleType = ContextHelper.getStringSafe(request, "szCdUnitMemberRole" + i);

        if (roleType.equals(UnitMaintConversation.SUPERVISOR_TYPE)) {
          leadCount++;

          if (leadCount > 1) {
            setErrorMessage(Messages.MSG_ONE_LEAD_ONLY);
            break;
          }
        }
      }
      if (leadCount == 0) {
        setErrorMessage(Messages.MSG_ONE_LEAD_ONLY);
      }
    }

    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }
}
