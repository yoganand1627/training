//*  Validation Class  Name:     ChildPlanCustomValidation
//*  Created by:   Jacob Vaidyan
//*  Date Created: 1/8/2007
//*
//*  Description:Custom Validation Class for FCC Child Plan.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  

package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import javax.servlet.http.HttpServletRequest;
import org.grnds.structural.web.GrndsExchangeContext;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public class ChildPlanCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "ChildPlanCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    GrndsExchangeContext context = getGrndsExchangeContext();
    boolean isValid = true;

    String TxtSvcOffProvidedDesc = ContextHelper.getStringSafe(request, "szTxtSvcOffProvidedDesc");
    String DtCompDate = ContextHelper.getStringSafe(request, "szDtCompDate");
    String InddilSearchComp = ContextHelper.getStringSafe(request, "rbInddilSearchComp");
    String IndChildAdjInCare = ContextHelper.getStringSafe(request, "rbIndChildAdjInCare");
    String TxtExpChildAdjInCare = ContextHelper.getStringSafe(context, "szTxtExpChildAdjInCare");
    String[] checkedASFAExstConds = CheckboxHelper.getCheckedValues(request, "chkAsfaExistingConditions");
    String[] checkedParentalRtsTerms = CheckboxHelper.getCheckedValues(request, "chkParentalRtsTerms");
    String TxtparentalRightsCmnts = ContextHelper.getStringSafe(request, "szTxtParentalRightsCmnts");
    String[] checkedNonReunificConditions = CheckboxHelper.getCheckedValues(request, "chknonReunificConditions");
    String IndFilePetition = ContextHelper.getStringSafe(context, "rbIndFilePetition");
    String DtfilePetitionDate = ContextHelper.getStringSafe(request, "szDtfilePetitionDate");
    String TxtfilePetitionCmnts = ContextHelper.getStringSafe(context, "szTxtfilePetitionCmnts");
    String IndImmunization = ContextHelper.getStringSafe(context, "rbIndImmunization");
    String TxtImmunizationCmnts = ContextHelper.getStringSafe(context, "szTxtImmunizationCmnts");
    String IndImmunizationOnFile = ContextHelper.getStringSafe(context, "rbIndImmunizationOnFile");
    String TxtImmunizationFileComments = ContextHelper.getStringSafe(context, "szTxtImmunizationFileComments");
    String IndMedPsychProblems = ContextHelper.getStringSafe(context, "rbIndMedPsychProblems");
    String TxtMedPsychProblemsCmnts = ContextHelper.getStringSafe(context, "szTxtMedPsychProblemsCmnts");
    String IndMedRecFile = ContextHelper.getStringSafe(context, "rbIndMedRecFile");
    String TxtMedRecFileCmnts = ContextHelper.getStringSafe(context, "szTxtMedRecFileCmnts");
    String IndPsychRecFile = ContextHelper.getStringSafe(context, "rbIndPsychRecFile");
    String TxtPsychRecFileCmnts = ContextHelper.getStringSafe(context, "szTxtPsychRecFileCmnts");
    String IndMedPsychTrmnt = ContextHelper.getStringSafe(context, "rbIndMedPsychTrmnt");
    String IndMedPsychDocRecord = ContextHelper.getStringSafe(context, "rbIndMedPsychDocRecord");

    // Validations if Complete is activated on Child Plan Page.
    if (super.isButtonPressed(ChildPlanConversation.COMPLETE_CHILDPLAN_BUTTON)) {

      if ("".equals(TxtSvcOffProvidedDesc)) {
        setErrorMessage(Messages.MSG_REA_EFF_COMP);
        isValid = false;
      }

      if ("".equals(IndChildAdjInCare)) {
        setErrorMessage(Messages.MSG_CHILD_ADJ_COMP);
        isValid = false;
      }
      if ("".equals(IndImmunization)) {
        setErrorMessage(Messages.MSG_IMMU_DATE_COMP);
        isValid = false;
      }
      if ("".equals(IndImmunizationOnFile)) {
        setErrorMessage(Messages.MSG_IMMU_REC_COMP);
        isValid = false;
      }
      if ("".equals(IndMedPsychProblems)) {
        setErrorMessage(Messages.MSG_ONG_MED_PROB_COMP);
        isValid = false;
      }
      if ("".equals(IndMedRecFile)) {
        setErrorMessage(Messages.MSG_MED_REC_COMP);
        isValid = false;
      }
      if ("".equals(IndPsychRecFile)) {
        setErrorMessage(Messages.MSG_PSY_REC_COMP);
        isValid = false;
      }
      if ("".equals(IndMedPsychTrmnt)) {
        setErrorMessage(Messages.MSG_ONG_TREAT_COMP);
        isValid = false;
      }

    }
    // Validations if either Save or Complete is activated on Child Plan Page.
    if (super.isButtonPressed(ChildPlanConversation.SAVE_CHILDPLAN_BUTTON)
        || super.isButtonPressed(ChildPlanConversation.COMPLETE_CHILDPLAN_BUTTON)) {
      if ("Y".equals(InddilSearchComp) && "".equals(DtCompDate)) {
        setErrorMessage(Messages.MSG_DIL_COMP_REQ);
        isValid = false;
      }
      if ("N".equals(IndChildAdjInCare) && "".equals(TxtExpChildAdjInCare)) {
        setErrorMessage(Messages.MSG_NOT_ADJ_REASON);
        isValid = false;
      }
      if ((!(checkedASFAExstConds.length == 0) || !(checkedParentalRtsTerms.length == 0))
          && ("".equals(TxtparentalRightsCmnts))) {
        setErrorMessage(Messages.MSG_ASFA_DETAILS);
        isValid = false;

      }
      if ((!(checkedNonReunificConditions.length == 0) && ("".equals(IndFilePetition)))) {
        setErrorMessage(Messages.MSG_TPR_DEC_REQ);
        isValid = false;

      }

      if ("Y".equals(IndFilePetition) && "".equals(DtfilePetitionDate)) {
        setErrorMessage(Messages.MSG_TPR_DATE_REQ);
        isValid = false;

      }
      if ((!(checkedNonReunificConditions.length == 0) && ("N".equals(IndFilePetition)) && (""
                                                                                              .equals(TxtfilePetitionCmnts)))) {
        setErrorMessage(Messages.MSG_TPR_NO_EXPL_REQ);
        isValid = false;

      }
      if ("N".equals(IndImmunization) && "".equals(TxtImmunizationCmnts)) {
        setErrorMessage(Messages.MSG_IMMU_DATE_EXP_REQ);
        isValid = false;

      }
      if ("N".equals(IndImmunizationOnFile) && "".equals(TxtImmunizationFileComments)) {
        setErrorMessage(Messages.MSG_IMMU_REC_EXP_REQ);
        isValid = false;

      }
      if ("Y".equals(IndMedPsychProblems) && "".equals(TxtMedPsychProblemsCmnts)) {
        setErrorMessage(Messages.MSG_ONG_MED_PROB_EXP_REQ);
        isValid = false;

      }
      if ("N".equals(IndMedRecFile) && "".equals(TxtMedRecFileCmnts)) {
        setErrorMessage(Messages.MSG_MED_REC_EXP_REQ);
        isValid = false;

      }
      if ("N".equals(IndPsychRecFile) && "".equals(TxtPsychRecFileCmnts)) {
        setErrorMessage(Messages.MSG_PSY_REC_EXP_REQ);
        isValid = false;

      }
      if ("Y".equals(IndMedPsychTrmnt) && "".equals(IndMedPsychDocRecord)) {
        setErrorMessage(Messages.MSG_ONG_TREAT_FILE);
        isValid = false;

      }
    }
    return isValid;
  }
}
