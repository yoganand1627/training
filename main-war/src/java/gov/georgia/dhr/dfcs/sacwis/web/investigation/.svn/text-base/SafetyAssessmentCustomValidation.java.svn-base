package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyAssessmentRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

/**
 * This class validates data submitted from the SafetyAssessment Assessment page.
 * </p>
 * 
 * @author svchakravarthy
 * 
 */
public class SafetyAssessmentCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "SafetyAssessmentCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    boolean isValid = true;

    String overallSafetyDecision = ContextHelper.getStringSafe(request, "selOverallSafetyDecision");
    if (isButtonPressed("btnSaveSubmit") && "".equals(overallSafetyDecision)) {
      setErrorMessage("selOverallSafetyDecision", Messages.MSG_ASSMT_SA_SFTY_DECISION_REQ);
      isValid = false;
    }

    SafetyAssessmentRetrieveSO safetyAssessmentRetrieveSO = (SafetyAssessmentRetrieveSO) state
                                                                                              .getAttribute(
                                                                                                            "SafetyAssessmentRetrieveSO",
                                                                                                            request);

    if (safetyAssessmentRetrieveSO != null) {
      if (isButtonPressed("btnSaveSubmit") || isButtonPressed("btnSave")) {
        Collection<SaPerson> childrenList = safetyAssessmentRetrieveSO.getPrincipalChildren();
        // String overallSafetyDecision = ContextHelper.getStringSafe(request, "selOverallSafetyDecision");
        // Messages.MSG_ASSMT_SA_REQ_RECHKLIST
        if (CodesTables.COVSFDSN_US.equals(overallSafetyDecision)
            || CodesTables.COVSFDSN_CS.equals(overallSafetyDecision)) {
          Collection<String> codesRE = null;
          try {
            codesRE = Lookup.getCategoryCodesCollection(SafetyAssessmentConversation.REASONABLE_EFFORTS);
          } catch (Exception e) {
            setErrorMessage(e.getMessage());
            isValid = false;
            return isValid;
          }
          Iterator<String> iteratorCodesRE = codesRE.iterator();
          while (iteratorCodesRE.hasNext()) {
            String code = iteratorCodesRE.next();
            Iterator<SaPerson> iteratorChildren = childrenList.iterator();
            while (iteratorChildren.hasNext()) {
              int idChild = iteratorChildren.next().getIdPerson();
              String rbFieldName = "rb" + code + "_" + idChild;
              String rbFieldNameValue = ContextHelper.getStringSafe(request, rbFieldName);
              // String txtFieldNameRE = "txt" + code + "_" + idChild;
              // String txtFieldNameValue = ContextHelper.getStringSafe(request, txtFieldNameRE);
              if ("".equals(rbFieldNameValue)) {
                if (isValid) {
                  setErrorMessage(Messages.MSG_ASSMT_SA_REQ_RECHKLIST);
                }
                isValid = false;
              }
            }
          }
        } // end Messages.MSG_ASSMT_SA_REQ_RECHKLIST

        // Messages.MSG_ASSMT_SA_REQ_RE_NOT_SAFE
        String whyResponses = ContextHelper.getStringSafe(request, "txtResponse");
        if (whyResponses == null || "".equals(whyResponses)) {
          Iterator<SaPerson> iteratorChildren = childrenList.iterator();
          boolean isValidREFF6 = true;
          String code = "REFF6";
          while (iteratorChildren.hasNext()) {
            int idChild = iteratorChildren.next().getIdPerson();
            String rbFieldName = "rb" + code + "_" + idChild;
            String rbFieldNameValue = ContextHelper.getStringSafe(request, rbFieldName);
            if (ArchitectureConstants.Y.equals(rbFieldNameValue)) {
              if (isValidREFF6) {
                setErrorMessage(Messages.MSG_ASSMT_SA_REQ_RE_NOT_SAFE);
                isValidREFF6 = false;
                isValid = false;
              }
            }
          }
        } // end of Messages.MSG_ASSMT_SA_REQ_RE_NOT_SAFE

        // Messages.MSG_ASSMT_SA_DEN_REQ
        if (safetyAssessmentRetrieveSO.getIsDrugExposedNewBorn()) {
          boolean isValidDrugExposedNewBorn = true;
          Collection<String> codesDE = null;
          try {
            codesDE = Lookup.getCategoryCodesCollection(SafetyAssessmentConversation.DRUG_EXPOSED_NEW_BORNS);
          } catch (Exception e) {
            setErrorMessage(e.getMessage());
            isValid = false;
            return isValid;
          }
          Iterator iteratorCodesDE = codesDE.iterator();
          while (iteratorCodesDE.hasNext()) {
            String code = (String) iteratorCodesDE.next();
            String rbFieldName = "rb" + code;
            String rbFieldNameValue = ContextHelper.getStringSafe(request, rbFieldName);
            if ("".equals(rbFieldNameValue)) {
              if (isValidDrugExposedNewBorn) {
                setErrorMessage(Messages.MSG_ASSMT_SA_DEN_REQ);
                isValidDrugExposedNewBorn = false;
                isValid = false;
              }
            }
          }
        }

      } // end button is Save or Save&Submit
    } // end of SafetyAssessmentRetrieveSO

    performanceTrace.exitScope();
    return isValid;
  }

}