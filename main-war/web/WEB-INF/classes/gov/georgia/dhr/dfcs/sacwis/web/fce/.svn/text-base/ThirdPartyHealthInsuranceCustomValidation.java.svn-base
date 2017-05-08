package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gautami Rout, Dec 21, 2006 <p/>
 * 
 * <pre>
 *                   Change History:
 *                   Date      User              Description
 *                   --------  ----------------  -------------------------
 */

@SuppressWarnings("serial")
public class ThirdPartyHealthInsuranceCustomValidation extends FormValidation {
  protected static final String TRACE_TAG = "ThirdPartyHealthInsuranceCustomValidation";

  /** all the validation logic */
  @SuppressWarnings("unchecked")
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "validateForm");

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    boolean isValid = true;
    String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbThirdPartyHealthIns_");
    ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB = ThirdPartyHealthInsuranceConversation.readFromRequest(request);

    List<FcePersonDB> principles = (List<FcePersonDB>) state.getAttribute("ListOfPrinciples", request);

    boolean indAuthAssign = thirdPartyHealthInsuranceDB.getIndAuthAssign();

    // Health Insurance begin date is after Health Insurance end date

    if (DateHelper.isValidDate(thirdPartyHealthInsuranceDB.getDtBeginString())
        && DateHelper.isValidDate(thirdPartyHealthInsuranceDB.getDtEndString())
        && DateHelper.isAfter(thirdPartyHealthInsuranceDB.getDtBegin(), thirdPartyHealthInsuranceDB.getDtEnd())) {
      setErrorMessage(Messages.SSM_CON_BEG_BEFORE_END);
      isValid = false;
    }

    // You indicated the child is covered by health insurance other than Medicaid.
    // Please select the child in the 'Principals Covered by Health Insurance Policy' list.
    if (Boolean.TRUE.equals(thirdPartyHealthInsuranceDB.getIndChildCoverageObject())) {
      boolean childChecked = false;
      for (int i = 0; checkedValues.length > 0 && i < checkedValues.length; i++) {
        FcePersonDB fcePeronDB = principles.get(Integer.parseInt(checkedValues[i]));
        if ("SL".equals(fcePeronDB.getCdRelInt())) {
          childChecked = true;
        }
      }
      if (!childChecked) {
        setErrorMessage(Messages.MSG_FCE_HLTH_INS_COV_PRNPL_CHILD);
        isValid = false;
      }
    }
    // You indicated the child is covered by health insurance other than Medicaid.
    // Please acknowledge the Authorization statements in the 'Authorization' section.
    if ((Boolean.TRUE.equals(thirdPartyHealthInsuranceDB.getIndChildCoverageObject())) && (!indAuthAssign)) {
      setErrorMessage(Messages.MSG_FCE_HLTH_INS_COV_AUTH_REQ);
      isValid = false;
    }
    // Date of Authorization must be on or before current date.
    if (thirdPartyHealthInsuranceDB.getDtAuthAssignDate() != null) {
      Date today = new Date();
      if ((thirdPartyHealthInsuranceDB.getDtAuthAssignDate().after(today))) {
        setErrorMessage(Messages.MSG_FCE_HLTH_INS_AUTH_DATE_CURR);
        isValid = false;
      }
    }

    //A Date of Authorization has been entered, 
    //but the corresponding Authorization statement has not been acknowledged.
    if ((thirdPartyHealthInsuranceDB.getDtAuthAssignDate() != null) && (!indAuthAssign)) {
      setErrorMessage(Messages.MSG_FCE_HLTH_INS_NO_AUTH_STMT_DATE);
      isValid = false;
    }
    //The Health Insurance Coverage question must be answered.
    if (thirdPartyHealthInsuranceDB.getIndChildCoverageObject() == null) {
      setErrorMessage(Messages.MSG_FCE_HLTH_INS_COV_REQ);
      isValid = false;
    }
    
    if(isValid == false){
      request.setAttribute("Error", "true");
    }

    performanceTrace.exitScope();
    return isValid;
  }
}
