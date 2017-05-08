package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AAFundingSummarySO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * AAFundingSummary.jsp Custom validation class
 * 
 * @author Herve Jean-Baptiste August 31, 2011
 * @version 1.0
 * 
 * <pre>
 * Change History:
 * Date           User                Description
 * ----------     ---------------     --------------------------------------------------------------------
 * 10/17/2011     hjbaptiste          STGAP00017227:MR-092 Fixed password not being required when Validate button
 *                                    is pressed
 * </pre>
 */

public class AAFundingSummaryCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "AAFundingSummaryCustomValidation";
  
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();
    BaseSessionStateManager state = getState();
    boolean result = true;
    
    // User clicks the Validate button, doesn't enter or password or enters invalid password
    if (super.isButtonPressed("btnValidate")) {
      String password = ContextHelper.getStringSafe(request, "txtPassword");
      if (password == null || password.trim().length() < 1) {
        setErrorMessage("txtPassword", Messages.MSG_CMN_PASSWORD_VALIDATE);
        result = false;
      } else {
        try {
          UserProfile userProfile = BasePrsConversation.getUserProfile(request);

          UserProfileHelper.validateLogin(userProfile.getUserLogonID(), password);
        }
        catch (SecurityException e) {
          e.printStackTrace();
          setErrorMessage("txtPassword", Messages.MSG_AA_FUND_INVLD_PWD);
          result = false;
        }
      }
    }
    AAFundingSummarySO aAFundingSummarySO = (AAFundingSummarySO) state.getAttribute("aAFundingSummarySO", request);
    List<String> cdEligibilityReasonsNotEligible = aAFundingSummarySO.getCdEligibilityReasonsNotEligible();
    boolean nonRecurringReqUnchecked = (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnIndNonRecurringReq")))
                                       && (ArchitectureConstants.N.equals(CheckboxHelper.getCheckboxValue(request, "cbxBIndNonRecurringReq")));
    if (super.isButtonPressed("btnSave")) {
      // if user did not indicate Non-Recurring Request Only AA Funding or using is not 'Unchecking' the Non-Recurring Request Only
      // checkbox, do the checks
      if (!ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxBIndNonRecurringReq"))
                      && !nonRecurringReqUnchecked) {
        // If FCC actual Eligibility is not Title IV-E or it's Title IV-B and the only reason is Best Interest
        // Language, we need to check each section
        if (!CodesTables.CELIGIBI_010.equals(aAFundingSummarySO.getCdEligActual()) 
                        || (!CodesTables.CELIGIBI_010.equals(aAFundingSummarySO.getCdEligActual())
                             && !((cdEligibilityReasonsNotEligible != null && cdEligibilityReasonsNotEligible.size() == 1)
                             && CodesTables.CFCERNE_A09.equals(cdEligibilityReasonsNotEligible.get(0))))) {
          
        // In the Applicable Child Criteria section, all results are not indicated as 'Not Met' and 
        // at least one has not been indicated as being 'Met'
        String rbIndAcAgeMet = ContextHelper.getStringSafe(request, "rbIndAcAgeMet");
        String rbIndAcTimeInFosterMet = ContextHelper.getStringSafe(request, "rbIndAcTimeInFosterMet");
        String rbIndAcSiblingMet = ContextHelper.getStringSafe(request, "rbIndAcSiblingMet");
        String rbIndAcTprCtwVsMet = ContextHelper.getStringSafe(request, "rbIndAcTprCtwVsMet");
        String rbIndAcSsiEligMet = ContextHelper.getStringSafe(request, "rbIndAcSsiEligMet");
        String rbIndAcChildOfMinorMet = ContextHelper.getStringSafe(request, "rbIndAcChildOfMinorMet");
        String rbIndAcIvePriorAdoptMet = ContextHelper.getStringSafe(request, "rbIndAcIvePriorAdoptMet");
        String rbIndNacAfdcMet = ContextHelper.getStringSafe(request, "rbIndNacAfdcMet");
        String rbIndNacSsiEligMet = ContextHelper.getStringSafe(request, "rbIndNacSsiEligMet");
        String rbIndNacChildOfMinorMet = ContextHelper.getStringSafe(request, "rbIndNacChildOfMinorMet");
        String rbIndNacIvePriorAdoptMet = ContextHelper.getStringSafe(request, "rbIndNacIvePriorAdoptMet");
        
        if (!(ArchitectureConstants.Y.equals(rbIndAcAgeMet)
            || ArchitectureConstants.Y.equals(rbIndAcTimeInFosterMet)
            || ArchitectureConstants.Y.equals(rbIndAcSiblingMet))
            && (StringHelper.EMPTY_STRING.equals(rbIndAcAgeMet)
                            || StringHelper.EMPTY_STRING.equals(rbIndAcTimeInFosterMet)
                            || StringHelper.EMPTY_STRING.equals(rbIndAcSiblingMet))){
          setErrorMessage(Messages.MSG_APPL_CHILD_REQ);
          result = false;
        }
        
        // If child is Applicable and in the Applicable Child IV-E Criteria section, all results are 
        // not indicated as 'Not Met' and at least one has not been indicated as being 'Met'
        if ((ArchitectureConstants.Y.equals(rbIndAcAgeMet)
             || ArchitectureConstants.Y.equals(rbIndAcTimeInFosterMet) 
             || ArchitectureConstants.Y.equals(rbIndAcSiblingMet))
            && !(ArchitectureConstants.Y.equals(rbIndAcTprCtwVsMet)
            || ArchitectureConstants.Y.equals(rbIndAcSsiEligMet)
            || ArchitectureConstants.Y.equals(rbIndAcChildOfMinorMet)
            || ArchitectureConstants.Y.equals(rbIndAcIvePriorAdoptMet)) &&
            (StringHelper.EMPTY_STRING.equals(rbIndAcTprCtwVsMet)
            || StringHelper.EMPTY_STRING.equals(rbIndAcSsiEligMet)
            || StringHelper.EMPTY_STRING.equals(rbIndAcChildOfMinorMet)
            || StringHelper.EMPTY_STRING.equals(rbIndAcIvePriorAdoptMet))) {
          setErrorMessage(Messages.MSG_APPL_IVE_REQ);
          result = false;
        }

        // If child is Not Applicable and in the Non-Applicable Child IV-E Criteria section, all results 
        // are not indicated as 'Not Met' and  at least one has not been indicated as being 'Met'
        if ((ArchitectureConstants.N.equals(rbIndAcAgeMet)
             && ArchitectureConstants.N.equals(rbIndAcTimeInFosterMet) 
             && ArchitectureConstants.N.equals(rbIndAcSiblingMet))
            && !(ArchitectureConstants.Y.equals(rbIndNacAfdcMet)
            || ArchitectureConstants.Y.equals(rbIndNacSsiEligMet)
            || ArchitectureConstants.Y.equals(rbIndNacChildOfMinorMet)
            || ArchitectureConstants.Y.equals(rbIndNacIvePriorAdoptMet)) &&
            (StringHelper.EMPTY_STRING.equals(rbIndNacAfdcMet)
                            || StringHelper.EMPTY_STRING.equals(rbIndNacSsiEligMet)
                            || StringHelper.EMPTY_STRING.equals(rbIndNacChildOfMinorMet)
                            || StringHelper.EMPTY_STRING.equals(rbIndNacIvePriorAdoptMet))){
          setErrorMessage(Messages.MSG_NON_APPL_IVE_REQ);
          result = false;
        }
      }
      }
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }
}
