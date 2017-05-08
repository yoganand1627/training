package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

/*
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *
 * 
 */

/**
 * <p/> This class validates data submitted from the Risk Assessment page. </p> <p/> <p/> Error Message Summaries are as
 * follows: </p> <blockquote> <ol> <li> MSG_RA_SUM_FINDINGS A summary of findings is required if date of prior history
 * report is entered. <li> MSG_RA_DT_PRNTS_GUIDE If a parents guide given, the date the guide was given is required <li>
 * MSG_RA_DT_NTF_INTRVW If parents were notified of the interview with the child, the date of the notification is
 * required <li> MSG_RA_DT_HIPPA If caretaker signed and acknowledged HIPPA agreement, the date of signature is
 * required. <li> MSG_RA_FAM_STRNGTH_SUB If a concept is selected as a family strength, at least one sub-concept must be
 * checked. <li> MSG_RA_FAM_STRNGTH_SUM The summarization of family strengths is required. <li>
 * MSG_RA_FAM_STRNGTH_ONE_REQ At least one area needs to be selected as a family strength. </ol> </blockquote>
 *
 * @author Carina Gerry 9/23/2006
 */
public class RiskAssessmentCustomValidation extends FormValidation {
  /** @return result - Returns false if the data fails validation. Returns true if the data passes validation. */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,
                                                             ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();

    boolean result = true;
    String numOfReportsField = "numOfReports";

    // Response time Ind
    String responseTimeInd = ContextHelper.getStringSafe(request,
                                                         "rbResponseTime");

    // concepts
    String childVulnerability = ContextHelper.getStringSafe(request,
                                                            "rbChildVulnerability");
    String caregiverCapability = ContextHelper.getStringSafe(request,
                                                             "rbCaregiverCapability");
    String qualityOfCare = ContextHelper.getStringSafe(request,
                                                       "rbQualityOfCare");
    String maltreatmentPattern = ContextHelper.getStringSafe(request,
                                                             "rbMaltreatmentPattern");
    String homeEnv = ContextHelper.getStringSafe(request, "rbHomeEnv");
    String socialEnv = ContextHelper.getStringSafe(request, "rbSocialEnv");
    String responseToIntervention = ContextHelper.getStringSafe(request,
                                                                "rbResponseToIntervention");

    // subconcepts
    String childFragilityProtect = ContextHelper.getStringSafe(request,
                                                               "cbxChildFragilityProtect");
    String childBehaviour = ContextHelper.getStringSafe(request,
                                                        "cbxChildBehaviour");

    String knowledgeSkills = ContextHelper.getStringSafe(request,
                                                         "cbxKnowledgeSkills");
    String control = ContextHelper.getStringSafe(request, "cbxControl");
    String functioning = ContextHelper.getStringSafe(request,
                                                     "cbxFunctioning");

    String emotionalCare = ContextHelper.getStringSafe(request,
                                                       "cbxEmotionalCare");
    String physicalCare = ContextHelper.getStringSafe(request,
                                                      "cbxPhysicalCare");

    String chronicity = ContextHelper.getStringSafe(request,
                                                    "cbxChronicity");
    String currentSeverity = ContextHelper.getStringSafe(request,
                                                         "cbxCurrentSeverity");
    String trend = ContextHelper.getStringSafe(request, "cbxTrend");

    String dangerousExposure = ContextHelper.getStringSafe(request,
                                                           "cbxDangerousExposure");
    String stressors = ContextHelper.getStringSafe(request, "cbxStressors");

    String socialClimate = ContextHelper.getStringSafe(request,
                                                       "cbxSocialClimate");
    String socialViolence = ContextHelper.getStringSafe(request,
                                                        "cbxSocialViolence");

    String attitude = ContextHelper.getStringSafe(request, "cbxAttitude");
    String deception = ContextHelper.getStringSafe(request, "cbxDeception");
    
    String currLvlRisk = ContextHelper.getStringSafe(request, "selCurrLvlRisk");
    

    if (super.isButtonPressed("btnCompletionCheck")) {

      // List reportsVector = new ArrayList();
      String fieldName1 = null;
      String fieldName2 = null;
      String fieldName3 = null;
      int numOfReports = ContextHelper.getIntSafe(request,
                                                  numOfReportsField);
      for (int i = 0; i < numOfReports; i++) {
        fieldName1 = "txtDateOfReport" + i;
        fieldName2 = "txtRiskAssmtPriorHistory" + i;
        fieldName3 = "txtDtOfClosure" + i;
        /*
             * A summary of findings is required if date of prior history
             * report is entered.
             */
        if (!""
                .equals(ContextHelper
                        .getStringSafe(request, fieldName1))
            && "".equals(ContextHelper.getStringSafe(request,
                                                     fieldName2))) {
          setErrorMessage(Messages.MSG_RA_SUM_FINDINGS);
          result = false;
        }
      }

      /*
          * If a parents guide given, the date the guide was given is
          * required
          */
      if ("Y".equals(ContextHelper.getStringSafe(request,
                                                 "rbParentsGuide"))
          && "".equals(ContextHelper.getStringSafe(request,
                                                   "txtDtParentsGuide"))) {
        setErrorMessage(Messages.MSG_RA_DT_PRNTS_GUIDE);
        result = false;
      }

      /*
          * If parents were notified of the interview with the child, the
          * date of the notification is required
          */
      if ("Y".equals(ContextHelper.getStringSafe(request,
                                                 "rbParentNotified"))
          && "".equals(ContextHelper.getStringSafe(request,
                                                   "txtDtParentNotified"))) {
        setErrorMessage(Messages.MSG_RA_DT_NTF_INTRVW);
        result = false;
      }

      /*
          * If caretaker signed and acknowledged HIPPA agreement, the date of
          * signature is required.
          */
      if ("Y".equals(ContextHelper
              .getStringSafe(request, "rbHIPPASigned"))
          && "".equals(ContextHelper.getStringSafe(request,
                                                   "txtDtHIPPASignedAndAck"))) {
        setErrorMessage(Messages.MSG_RA_DT_HIPPA);
        result = false;
      }

      /*
          * If a concept is selected as a family strength, at least one
          * sub-concept must be checked.
          */
      if (("Y".equals(childVulnerability)
           && "".equals(childFragilityProtect) && ""
              .equals(childBehaviour))
          || ("Y".equals(caregiverCapability)
              && "".equals(knowledgeSkills) && "".equals(control) && ""
              .equals(functioning))
          || ("Y".equals(qualityOfCare) && "".equals(emotionalCare) && ""
              .equals(physicalCare))
          || ("Y".equals(maltreatmentPattern)
              && "".equals(chronicity)
              && "".equals(currentSeverity) && "".equals(trend))
          || ("Y".equals(homeEnv) && "".equals(dangerousExposure) && ""
              .equals(stressors))
          || ("Y".equals(socialEnv) && "".equals(socialClimate) && ""
              .equals(socialViolence))
          || ("Y".equals(responseToIntervention)
              && "".equals(attitude) && "".equals(deception))) {
        setErrorMessage(Messages.MSG_RA_FAM_STRNGTH_SUB);
        result = false;
      }

      /* The summarization of family strengths is required. */
      if ("".equals(ContextHelper.getStringSafe(request,
                                                "txtSummarizeJustificationOfFindings"))) {
        setErrorMessage(Messages.MSG_RA_FAM_STRNGTH_SUM);
        result = false;
      }

      /* At least one area needs to be selected as a family strength. */
      if (("N".equals(childVulnerability) || ""
              .equals(childVulnerability))
          && ("N".equals(caregiverCapability) || ""
              .equals(caregiverCapability))
          && ("N".equals(qualityOfCare) || "".equals(qualityOfCare))
          && ("N".equals(maltreatmentPattern) || ""
              .equals(maltreatmentPattern))
          && ("N".equals(homeEnv) || "".equals(homeEnv))
          && ("N".equals(socialEnv) || "".equals(socialEnv))
          && ("N".equals(responseToIntervention) || ""
              .equals(responseToIntervention))) {
        setErrorMessage(Messages.MSG_RA_FAM_STRNGTH_ONE_REQ);
        result = false;
      }

    }

    if (super.isButtonPressed("btnSave")) {
      if (responseTimeInd.equals(null) || (responseTimeInd.equals(""))) {
        setErrorMessage(Messages.MSG_RESPONSE_TIME_IND_REQ);
        result = false;
      }
    }
    if(CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) { 
      if (currLvlRisk.equals(null) || (currLvlRisk.equals(""))) {
        setErrorMessage("selCurrLvlRisk", Messages.MSG_RA_CURR_LVL_RSK_REQ);
        result = false;
      }
    }
    
    performanceTrace.exitScope();
    return result;
  }

  public static final String TRACE_TAG = "RiskAssessmentCustomValidation";
}
