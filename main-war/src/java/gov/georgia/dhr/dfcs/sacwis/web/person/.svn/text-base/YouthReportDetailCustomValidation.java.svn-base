package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NytdHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   08/20/10  hnguyen   MR-067 Added validation for new fields and additional
 *                       messages
 *   09/09/10  hnguyen   MR-067 Moved error label map
 *   09/09/10  hnguyen   MR-067 Added validation check for outcome date within current survey period
 *   09/22/10  hnguyen   SMS#71814 MR-067 Added validation for dob, ethnicity, and last grade complete
 *   09/28/10  hnguyen   SMS#73793 MR-067 Corrected condition for check follow-up not in care questions checks
 * 
 */

@SuppressWarnings("serial")
public class YouthReportDetailCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "YouthReportDetailCustomValidation";

  public static final String REQUIRED_MSG = InputValidation.REQUIRED_ERROR_MESSAGE;

  public static final String MSG_CMN_YDP_OUTCOME_DATE = MessageLookup
                                                                     .getMessageByNumber(Messages.MSG_CMN_YDP_OUTCOME_DATE);

  public static final String MSG_CMN_YDP_OUTCOME_STAT = MessageLookup
                                                                     .getMessageByNumber(Messages.MSG_CMN_YDP_OUTCOME_STAT);

  public static final String MSG_CMN_YDP_REQ_FIELD = MessageLookup.getMessageByNumber(Messages.MSG_CMN_YDP_REQ_FIELD);

  public static final String MSG_CMN_YDP_SEX = MessageLookup.getMessageByNumber(Messages.MSG_CMN_YDP_SEX);

  public static final String MSG_CMN_YDP_NO_OHIT = MessageLookup.getMessageByNumber(Messages.MSG_CMN_YDP_NO_OHIT);

  public static final String MSG_CMN_YDP_NO_OHIT_MED = MessageLookup
                                                                    .getMessageByNumber(Messages.MSG_CMN_YDP_NO_OHIT_MED);

  public static final String MSG_CMN_YDP_NO_CHLD = MessageLookup.getMessageByNumber(Messages.MSG_CMN_YDP_NO_CHLD);

  public static final String SSM_DATE_LESS_THAN_CURR = MessageLookup
                                                                    .getMessageByNumber(Messages.SSM_DATE_LESS_THAN_CURR);
  
  public static final String MSG_CMN_YDP_OUTCOME_DT_INVALID = MessageLookup.getMessageByNumber(Messages.MSG_CMN_YDP_OUTCOME_DT_INVALID);

  private List<ErrorMessage> errorMessages = null;

  private List<String> errorInputs = null;
  
  private Map<String, String> errorLabelMap = new HashMap<String, String>() {
    {
      // -- required fields
      put(YouthReportDetailConversation.DT_DOB_NAME, YouthReportDetailConversation.LABEL_DOB);
      put(YouthReportDetailConversation.SEL_SEX_NAME, YouthReportDetailConversation.LABEL_SEX);
      put(YouthReportDetailConversation.CBG_RACE_NAME, YouthReportDetailConversation.LABEL_RACE);
      put(YouthReportDetailConversation.SEL_ETHNICITY_NAME, YouthReportDetailConversation.LABEL_ETHNICITY);
      put(YouthReportDetailConversation.RADIO_TRIBAL_NAME, YouthReportDetailConversation.LABEL_TRIBAL_MBR);
      put(YouthReportDetailConversation.RADIO_ADJ_DEL_NAME, YouthReportDetailConversation.LABEL_ADJ_DEL);
      put(YouthReportDetailConversation.SEL_LAST_GRD_COMP_NAME, YouthReportDetailConversation.LABEL_LAST_GRD_COMP);
      put(YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME, YouthReportDetailConversation.LABEL_SPC_ED_STAT);
      put(YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME, YouthReportDetailConversation.LABEL_IL_NEEDS_ASM);
      put(YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME, YouthReportDetailConversation.LABEL_ACAD_SUPP);
      put(YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME, YouthReportDetailConversation.LABEL_PS_EDU_SUPP);
      put(YouthReportDetailConversation.RADIO_CAREER_PREP_NAME, YouthReportDetailConversation.LABEL_CAREER_PREP);
      put(YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME, YouthReportDetailConversation.LABEL_EMP_PROG_VOC);
      put(YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME, YouthReportDetailConversation.LABEL_BGT_FIN_MGT);
      put(YouthReportDetailConversation.RADIO_HOME_MGT_NAME, YouthReportDetailConversation.LABEL_HOME_MGT);
      put(YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME, YouthReportDetailConversation.LABEL_HLTH_ED_RP);
      put(YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME, YouthReportDetailConversation.LABEL_FAM_MARR_ED);
      put(YouthReportDetailConversation.RADIO_MENTORING_NAME, YouthReportDetailConversation.LABEL_MENTORING);
      put(YouthReportDetailConversation.RADIO_SUPER_IL_NAME, YouthReportDetailConversation.LABEL_SUPER_IL);
      put(YouthReportDetailConversation.RADIO_ROOM_BRD_NAME, YouthReportDetailConversation.LABEL_ROOM_BRD);
      put(YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME, YouthReportDetailConversation.LABEL_ED_FIN_ASST);
      put(YouthReportDetailConversation.RADIO_OTHER_FIN_NAME, YouthReportDetailConversation.LABEL_OTHER_FIN);
      put(YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME, YouthReportDetailConversation.LABEL_FC_ST_SVCS);

      // -- condRequired fields
      put(YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME, YouthReportDetailConversation.LABEL_OUTCOME_STAT);
      put(YouthReportDetailConversation.DT_OUTCOME_NAME, YouthReportDetailConversation.LABEL_DT_OUTCOME);
      put(YouthReportDetailConversation.RADIO_FC_STATUS_NAME, YouthReportDetailConversation.LABEL_FC_STATUS);
      put(YouthReportDetailConversation.RADIO_CURR_FTE_NAME, YouthReportDetailConversation.LABEL_CURR_FTE_ERROR);
      put(YouthReportDetailConversation.RADIO_CURR_PTE_NAME, YouthReportDetailConversation.LABEL_CURR_PTE_ERROR);
      put(YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME, YouthReportDetailConversation.LABEL_EMP_SKILLS_ERROR);
      put(YouthReportDetailConversation.RADIO_SS_NAME, YouthReportDetailConversation.LABEL_SS_ERROR);
      put(YouthReportDetailConversation.RADIO_EDU_AID_NAME, YouthReportDetailConversation.LABEL_EDU_AID_ERROR);
      put(YouthReportDetailConversation.RADIO_TANF_NAME, YouthReportDetailConversation.LABEL_TANF_ERROR);
      put(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME, YouthReportDetailConversation.LABEL_FOOD_STMP_ERROR);
      put(YouthReportDetailConversation.RADIO_PUB_HSG_NAME, YouthReportDetailConversation.LABEL_PUB_HSG_ERROR);
      put(YouthReportDetailConversation.RADIO_OTH_INC_NAME, YouthReportDetailConversation.LABEL_OTH_INC_ERROR);
      put(YouthReportDetailConversation.RADIO_HECR_NAME, YouthReportDetailConversation.LABEL_HECR_ERROR);
      put(YouthReportDetailConversation.RADIO_CAE_NAME, YouthReportDetailConversation.LABEL_CAE_ERROR);
      put(YouthReportDetailConversation.RADIO_C2A_NAME, YouthReportDetailConversation.LABEL_C2A_ERROR);
      put(YouthReportDetailConversation.RADIO_MED_NAME, YouthReportDetailConversation.LABEL_MEDICAID_ERROR);
      put(YouthReportDetailConversation.RADIO_OHIT_NAME, YouthReportDetailConversation.LABEL_OHIT_ERROR);
      put(YouthReportDetailConversation.RADIO_MEDICAL_NAME, YouthReportDetailConversation.LABEL_MEDICAL_ERROR);
      put(YouthReportDetailConversation.RADIO_MENTAL_NAME, YouthReportDetailConversation.LABEL_MENTAL_ERROR);
      put(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME, YouthReportDetailConversation.LABEL_PRESCRIPTION_ERROR);
      put(YouthReportDetailConversation.RADIO_HOME_NAME, YouthReportDetailConversation.LABEL_HOME_ERROR);
      put(YouthReportDetailConversation.RADIO_SAR_NAME, YouthReportDetailConversation.LABEL_SAR_ERROR);
      put(YouthReportDetailConversation.RADIO_INC_NAME, YouthReportDetailConversation.LABEL_INC_ERROR);
      put(YouthReportDetailConversation.RADIO_CHL_NAME, YouthReportDetailConversation.LABEL_CHL_ERROR);
      put(YouthReportDetailConversation.RADIO_MAB_NAME, YouthReportDetailConversation.LABEL_MAB_ERROR);
    }
  };  


  @Override
  protected boolean validateForm() {
    PerformanceTrace pt = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    pt.enterScope();

    HttpServletRequest request = getRequest();
    BaseSessionStateManager state = getState();
    state.removeAttribute(YouthReportDetailConversation.VALIDATION_CUSTOM_HTML, request);
    state.removeAttribute(YouthReportDetailConversation.VALIDATION_CUSTOM_INPUTS, request);
    errorMessages = new ArrayList<ErrorMessage>();
    errorInputs = new ArrayList<String>();
    
    // -- mimick required fields
    // -- do Race separately
    String raceInputName = YouthReportDetailConversation.CBG_RACE_NAME;
    String[] raceCodes = CheckboxHelper.getCheckedValues(request, raceInputName);
    if (raceCodes == null || raceCodes.length < 1) {
      addCustomErrorMessage(raceInputName, REQUIRED_MSG);
    }

    // -- required radio buttons
    checkField(YouthReportDetailConversation.DT_DOB_NAME, true);
    checkField(YouthReportDetailConversation.SEL_SEX_NAME, true);
    checkField(YouthReportDetailConversation.SEL_ETHNICITY_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_TRIBAL_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_ADJ_DEL_NAME, true);
    checkField(YouthReportDetailConversation.SEL_LAST_GRD_COMP_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_CAREER_PREP_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_HOME_MGT_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_MENTORING_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_SUPER_IL_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_ROOM_BRD_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME, true);
    checkField(YouthReportDetailConversation.RADIO_OTHER_FIN_NAME, true);

    // -- conditionally required fields
    String outcomeStatus = ContextHelper.getStringSafe(request, YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME);
    Date dtOutcomeDate = ContextHelper.getJavaDateSafe(request, YouthReportDetailConversation.DT_OUTCOME_NAME);
    boolean statusEntered = !"".equals(outcomeStatus);
    boolean dateEntered = !DateHelper
                                     .isNull(ContextHelper
                                                          .getJavaDateSafe(
                                                                           request,
                                                                           YouthReportDetailConversation.DT_OUTCOME_NAME));
    if (statusEntered && !dateEntered) {
      // outcome date required
      addCustomErrorMessage(YouthReportDetailConversation.DT_OUTCOME_NAME, MSG_CMN_YDP_OUTCOME_DATE);
    } else if (!statusEntered && dateEntered) {
      // outcome date should not be a future date
      if (DateHelper.isAfterToday(dtOutcomeDate)) {
        addCustomErrorMessage(YouthReportDetailConversation.DT_OUTCOME_NAME, SSM_DATE_LESS_THAN_CURR);
      }
      // outcome status required
      addCustomErrorMessage(YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME, MSG_CMN_YDP_OUTCOME_STAT);
    } else if( statusEntered && dateEntered ){
      if (DateHelper.isAfterToday(dtOutcomeDate)) {
          // outcome date should not be a future date
          addCustomErrorMessage(YouthReportDetailConversation.DT_OUTCOME_NAME, SSM_DATE_LESS_THAN_CURR);
      }
      
      // Outcome Date should be within current survey period
      Date dob = ContextHelper.getJavaDateSafe(request, YouthReportDetailConversation.DT_DOB_NAME);
      Date dtSurveyPeriodEnd = NytdHelper.getCurrentSurveyPeriodEnd(dob);
      
      if( dtSurveyPeriodEnd != null ){
        // Had to subtract 45 days from current survey period end date,
        // just in case birthday is toward the end of the year
        Calendar calCurrYearBirthday = Calendar.getInstance();
        calCurrYearBirthday.setTime(dtSurveyPeriodEnd);
        calCurrYearBirthday.add(Calendar.DAY_OF_MONTH, -NytdHelper.SURVEY_PERIOD);
        
        // set dob to current year birthday
        dob = calCurrYearBirthday.getTime();
        
        if ( dtOutcomeDate.compareTo(dob) < 0 || dtOutcomeDate.compareTo(dtSurveyPeriodEnd) > 0) {
            addCustomErrorMessage(YouthReportDetailConversation.DT_OUTCOME_NAME, MSG_CMN_YDP_OUTCOME_DT_INVALID );
        }
      }else{
        // should never get here, since if not in survey period they should not be able to enter status and date
        addCustomErrorMessage(YouthReportDetailConversation.DT_OUTCOME_NAME, MSG_CMN_YDP_OUTCOME_DT_INVALID );
      }
    }

    // -- all other conditionally required (when outcome status is Youth Participated and outcome date entered)
    // except if survey was completed by youth, then no validation since outcome reporting section is disabled
    String indEnteredByYth = ContextHelper.getStringSafe(request, YouthReportDetailConversation.IND_ENTERED_BY_YTH);

    if (dateEntered && CodesTables.COUTSTAT_YP.equals(outcomeStatus)
        && !ArchitectureConstants.Y.equals(indEnteredByYth)) {
      checkField(YouthReportDetailConversation.RADIO_FC_STATUS_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_CURR_FTE_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_CURR_PTE_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_SS_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_EDU_AID_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_OTH_INC_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_HECR_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_CAE_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_C2A_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_HOME_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_SAR_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_INC_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_CHL_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_MAB_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_MED_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_OHIT_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_MEDICAL_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_MENTAL_NAME, false);
      checkField(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME, false);

      // -- if no child then married at child birth should be N/A
      String indWithChild = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_CHL_NAME);
      if (StringHelper.isNotEmptyOrNull(indWithChild) && !ArchitectureConstants.Y.equals(indWithChild)) {
        String indMarAtBirth = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_MAB_NAME);
        if (!CodesTables.CINVACAN_A.equals(indMarAtBirth)) {
          addCustomErrorMessage(YouthReportDetailConversation.RADIO_MAB_NAME, MSG_CMN_YDP_NO_CHLD);
        }
      }

      // -- if no health insurance then health insurance related question should be n/a
      String indHasHlthIns = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_OHIT_NAME);
      if (StringHelper.isNotEmptyOrNull(indHasHlthIns) && !ArchitectureConstants.Y.equals(indHasHlthIns)) {
        String indHasMedical = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_MEDICAL_NAME);
        String indHasMental = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_MENTAL_NAME);
        String indHasRx = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME);
        if (!CodesTables.CINVACAN_A.equals(indHasMedical)) {
          addCustomErrorMessage(YouthReportDetailConversation.RADIO_MEDICAL_NAME, MSG_CMN_YDP_NO_OHIT);
        }
        if (!CodesTables.CINVACAN_A.equals(indHasMental)) {
          addCustomErrorMessage(YouthReportDetailConversation.RADIO_MENTAL_NAME, MSG_CMN_YDP_NO_OHIT);
        }
        if (!CodesTables.CINVACAN_A.equals(indHasRx)) {
          addCustomErrorMessage(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME, MSG_CMN_YDP_NO_OHIT);
        }
      } else {
        // if no medical coverage then mental and prescription coverage should be n/a
        String indHasMedical = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_MEDICAL_NAME);
        if (StringHelper.isNotEmptyOrNull(indHasMedical) && !ArchitectureConstants.Y.equals(indHasMedical)) {
          String indHasMental = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_MENTAL_NAME);
          String indHasRx = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME);
          if (!CodesTables.CINVACAN_A.equals(indHasMental)) {
            addCustomErrorMessage(YouthReportDetailConversation.RADIO_MENTAL_NAME, MSG_CMN_YDP_NO_OHIT_MED);
          }
          if (!CodesTables.CINVACAN_A.equals(indHasRx)) {
            addCustomErrorMessage(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME, MSG_CMN_YDP_NO_OHIT_MED);
          }
        }

      }

      // validate only if followup and not in care
      if (ArchitectureConstants.N.equals(ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_FC_STATUS_NAME))
          && YouthReportDetailConversation.POPULATION_TYPE_FOLLOW_UP
                                                                   .equals(ContextHelper
                                                                                        .getStringSafe(
                                                                                                       request,
                                                                                                       YouthReportDetailConversation.HDN_CD_POPULATION_TYPE))) {
        checkField(YouthReportDetailConversation.RADIO_TANF_NAME, false);
        checkField(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME, false);
        checkField(YouthReportDetailConversation.RADIO_PUB_HSG_NAME, false);
      }
    }

    // -- make sure sex is not "unknown"
    if (CodesTables.CSEX_U.equals(ContextHelper.getStringSafe(request, YouthReportDetailConversation.SEL_SEX_NAME))) {
      // setErrorMessage(YouthReportDetailConversation.SEL_SEX_NAME, MSG_CMN_YDP_SEX);
      addCustomErrorMessage(YouthReportDetailConversation.SEL_SEX_NAME, MSG_CMN_YDP_SEX);
    }

    applyCustomErrorMessages(state, request);
    pt.getTotalTime();
    pt.exitScope();
    return errorMessages.isEmpty() && getErrorMessages().isEmpty();
  }

  private void checkField(String inputName, boolean required) {
    if ("".equals(ContextHelper.getStringSafe(getRequest(), inputName))) {
      if (required) {
        addCustomErrorMessage(inputName, REQUIRED_MSG);
      } else {
        // -- add cond req fields to label map and JSP
        addCustomErrorMessage(inputName, MSG_CMN_YDP_REQ_FIELD);
      }
    }
  }

  private void addCustomErrorMessage(String inputName, String msg) {
    this.errorInputs.add(inputName);
    this.errorMessages.add(new ErrorMessage(inputName, errorLabelMap.get(inputName),
                                            msg));
  }

  private void applyCustomErrorMessages(BaseSessionStateManager state, HttpServletRequest request) {
    if (!errorInputs.isEmpty()) {
      StringBuilder sb = new StringBuilder();
      sb.append("<table width=\"100%\" cellpadding=\"1\"><tr><td class=\"formErrorText\">");
      sb.append("<hr noshade size=\"1\">");
      sb.append("<span class=\"formLabelError\">Please correct the following error(s):</span>");
      for (ErrorMessage e : errorMessages) {
        sb.append("<li><a onClick=\"hrefDirtyBypass=true;\" href=\"javascript:focusOn('");
        sb.append(e.inputName);
        sb.append("')\">");
        sb.append(e.anchorLabel);
        sb.append("</a> - ");
        sb.append(e.message);
        sb.append("<br>");
      }
      sb.append("<hr noshade size=\"1\">");
      sb.append("</td></tr></table>");
      state.setAttribute(YouthReportDetailConversation.VALIDATION_CUSTOM_HTML, sb.toString(), request);
    }
    state.setAttribute(YouthReportDetailConversation.VALIDATION_CUSTOM_INPUTS, this.errorInputs, request);
  }

  class ErrorMessage implements Serializable {
    private String inputName;

    private String anchorLabel;

    private String message;

    ErrorMessage(String inputName, String anchorLabel, String message) {
      this.inputName = inputName;
      this.anchorLabel = anchorLabel;
      this.message = message;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("<li><a onClick=\"hrefDirtyBypass=true;\" href=\"javascript:focusOn('");
      sb.append(this.inputName);
      sb.append("')\">");
      sb.append(this.anchorLabel);
      sb.append(" - ");
      sb.append(this.message);
      sb.append("<br>");
      return super.toString();
    }
  }
}
