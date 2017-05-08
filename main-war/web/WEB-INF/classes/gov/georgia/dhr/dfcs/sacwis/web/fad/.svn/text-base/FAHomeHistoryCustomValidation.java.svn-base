package gov.georgia.dhr.dfcs.sacwis.web.fad;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * FAHomeHistoryDetail.jsp Custom validation class <p>Description:  Custom Validation for FAHomeHistoryDetail.jsp </p>
 * <p>Copyright: Copyright (c) 2003</p> <p>Company: TDPRS</p>
 *
 * @author J. Heather Dean
 * @version 1.0
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get...
 *          replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */

public class FAHomeHistoryCustomValidation extends FormValidation {
  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "FAHomeHistoryCustomValidation";
  public static final int MAX_CAPACITY = 9999;
  public static final String BASIC = "famTypes1";
  public static final String HABILITATIVE = "famTypes2";
  public static final String THERAPEUTIC = "famTypes3";
  public static final String PRIMARY_MEDICAL_NEED = "famTypes4";
  public static final String GROUP = "famTypes5";
  public static final String KIN_GRANDPARENT = "famTypes6";
  public static final String KIN_AUNT_UNCLE = "famTypes7";
  public static final String KIN_OTHER_FAMILY = "famTypes8";
  public static final String CAPACITY_FIELD = "txtCapacity";
  public static final String F_MIN_YEAR_FIELD = "selFemaleMinYear";
  public static final String M_MIN_YEAR_FIELD = "selMaleMinYear";
  public static final String CLSR_REASON_FIELD = "selClosureReason";
  public static final String START_DATE_FIELD = "startDate";

  /** @todo add javadoc for method */
  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    boolean result = true;
    HttpServletRequest request = super.getRequest();

    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());
    int capacity = ContextHelper.getIntSafe(request, CAPACITY_FIELD);
    int femaleMinMonth = ContextHelper.getIntSafe(request, "selFemaleMinMonth");
    int femaleMinYear = ContextHelper.getIntSafe(request, F_MIN_YEAR_FIELD);
    int femaleMinAgeInMonths = (femaleMinYear * 12) + femaleMinMonth;
    int femaleMaxMonth = femaleMaxMonth = ContextHelper.getIntSafe(request, "selFemaleMaxMonth");
    int femaleMaxYear = femaleMaxYear = ContextHelper.getIntSafe(request, "selFemaleMaxYear");
    int femaleMaxAgeInMonths = (femaleMaxYear * 12) + femaleMaxMonth;
    int maleMinMonth = maleMinMonth = ContextHelper.getIntSafe(request, "selMaleMinMonth");
    int maleMinYear = maleMinYear = ContextHelper.getIntSafe(request, M_MIN_YEAR_FIELD);
    int maleMinAgeInMonths = (maleMinYear * 12) + maleMinMonth;
    int maleMaxMonth = maleMaxMonth = ContextHelper.getIntSafe(request, "selMaleMaxMonth");
    int maleMaxYear = maleMaxYear = ContextHelper.getIntSafe(request, "selMaleMaxYear");
    int maleMaxAgeInMonths = (maleMaxYear * 12) + maleMaxMonth;

    String status = ContextHelper.getStringSafe(request, "selStatus");
    String category = ContextHelper.getStringSafe(request, "selCategory");
    String closureReason = ContextHelper.getStringSafe(request, CLSR_REASON_FIELD);
    String[] checkBoxes = CheckboxHelper.getCheckedValues(this.getRequest(), "famTypes");
    java.util.List famTypes = java.util.Arrays.asList(checkBoxes);
    boolean indBasic = famTypes.contains(FAHomeHistoryConversation.CODE_BASIC);
    boolean indHabilitative = famTypes.contains(FAHomeHistoryConversation.CODE_HABILITATIVE);
    boolean indTherapeutic = famTypes.contains(FAHomeHistoryConversation.CODE_THERAPEUTIC);
    boolean indPMN = famTypes.contains(FAHomeHistoryConversation.CODE_PMN);
    boolean indGroup = famTypes.contains(FAHomeHistoryConversation.CODE_GROUP);
    boolean indKGrandparent = famTypes.contains(FAHomeHistoryConversation.CODE_KIN_GP);
    boolean indKAuntUncle = famTypes.contains(FAHomeHistoryConversation.CODE_KIN_AU);
    boolean indKOtherFamily = famTypes.contains(FAHomeHistoryConversation.CODE_KIN_OF);

    String endDate = ContextHelper.getStringSafe(request, "endDate");
    org.exolab.castor.types.Date dtEndDate = DateHelper.toCastorDateSafe(endDate);
    String startDate = ContextHelper.getStringSafe(request, START_DATE_FIELD);
    org.exolab.castor.types.Date dtStartDate = DateHelper.toCastorDateSafe(startDate);

    String nextStartDate = ContextHelper.getStringSafe(request, "nextStartDate");
    org.exolab.castor.types.Date dtNextStartDate = DateHelper.toCastorDateSafe(nextStartDate);
    String previousEndDate = ContextHelper.getStringSafe(request, "previousEndDate");
    org.exolab.castor.types.Date dtPreviousEndDate = DateHelper.toCastorDateSafe(previousEndDate);
    this.getRequest().setAttribute("isReload", "true");

    if (DateHelper.isBefore(dtStartDate, dtPreviousEndDate) &&
        previousEndDate != null &&
        previousEndDate != "") {
      setErrorMessage(START_DATE_FIELD, Messages.MSG_SUB_PERIOD_OVERLAP_1);
      result = false;
    } else if (DateHelper.isAfter(dtStartDate, today)) {
      setErrorMessage(START_DATE_FIELD, Messages.SSM_DATE_BEFORE_SAME_CURR);
      result = false;
    }

    //if end date is null, this is current row so don't validate anything else...
    if (!"".equals(endDate)) {
      if (DateHelper.isAfter(dtEndDate, dtNextStartDate)) {
        setErrorMessage("endDate", Messages.MSG_SUB_PERIOD_OVERLAP_2);
        result = false;
      } else if (DateHelper.isBefore(dtEndDate, dtStartDate)) {
        setErrorMessage(START_DATE_FIELD, Messages.SSM_START_BEFORE_SAME_END);
        result = false;
      } else if (DateHelper.isAfter(dtEndDate, today)) {
        setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }

      if (!category.equals(FAHomeHistoryConversation.CODE_ADOPTIVE) &&
          !indPMN && !indHabilitative && !indTherapeutic && !indGroup && !indKGrandparent &&
          !indKAuntUncle && !indKOtherFamily && !indBasic) {
        setErrorMessage(Messages.MSG_FAD_FOST_TYPE);
        result = false;
      }

      if (category.equals(FAHomeHistoryConversation.CODE_KINSHIP)) {
        //if no kinship foster type is checked
        if (!indKGrandparent && !indKAuntUncle && !indKOtherFamily) {
          setErrorMessage(Messages.MSG_FAD_KIN_FOST_TYPE);
          result = false;
        }
        //if all kinship foster types are checked
        else if (indKGrandparent && indKAuntUncle && indKOtherFamily) {
          setErrorMessage(Messages.MSG_FAD_KIN_FOST_TYPE);
          result = false;
        }
        //if more than one kinship foster type is checked
        else if (indKGrandparent && indKAuntUncle) {
          setErrorMessage(Messages.MSG_FAD_KIN_FOST_TYPE);
          result = false;
        } else if (indKGrandparent && indKOtherFamily) {
          setErrorMessage(Messages.MSG_FAD_KIN_FOST_TYPE);
          result = false;
        } else if (indKAuntUncle && indKOtherFamily) {
          setErrorMessage(Messages.MSG_FAD_KIN_FOST_TYPE);
          result = false;
        } else if (!indBasic && !indHabilitative &&
                   !indTherapeutic && !indPMN && !indGroup) {
          setErrorMessage(Messages.MSG_FAD_KIN_FOST_TYPE);
          result = false;
        }
      } else {
        //category is not kinship, so no kinship types should be checked.
        if (indKGrandparent || indKAuntUncle || indKOtherFamily) {
          setErrorMessage(Messages.MSG_FAD_NO_KIN_FOST_TYPE);
          result = false;
        }
      }

      if (capacity == 0) {
        if (status.equals(FAHomeHistoryConversation.CODE_STATUS_APPROVED_ACTIVE)) {
          //setErrorMessage(CAPACITY_FIELD, Messages.MSG_ACTIVE_NO_HOME_CAPACITY);
          result = false;
        } else if (status.equals(FAHomeHistoryConversation.CODE_STATUS_APPROVED_INACTIVE)) {
          setErrorMessage(CAPACITY_FIELD, Messages.MSG_INACTIVE_NO_HOME_CAPACITY);
          result = false;
        } else if (status.equals(FAHomeHistoryConversation.CODE_STATUS_PENDING_APPROVAL)) {
          //setErrorMessage(CAPACITY_FIELD, Messages.MSG_PEND_NO_HOME_CAPACITY);
          result = false;
        }
      }

      if ("".equals(closureReason)) {
        if (status.equals(FAHomeHistoryConversation.CODE_STATUS_PENDING_CLOSURE)) {
          setErrorMessage(CLSR_REASON_FIELD, Messages.MSG_PENDCLS__NO_CLO_REASON);
          result = false;
        }

        if (status.equals(FAHomeHistoryConversation.CODE_STATUS_CLOSED)) {
          setErrorMessage(CLSR_REASON_FIELD, Messages.MSG_CLS_NO_CLO_REASON);
          result = false;
        }
      } else {
        if (!status.equals(FAHomeHistoryConversation.CODE_STATUS_PENDING_CLOSURE) &&
            !status.equals(FAHomeHistoryConversation.CODE_STATUS_CLOSED)) {
          setErrorMessage(CLSR_REASON_FIELD, Messages.MSG_NO_CLOSURE);
          result = false;
        }
      }

      // if status is Approved Active, Approved Inactive, or Pending Approval,
      // age range becomes required
      if (status.equals(FAHomeHistoryConversation.CODE_STATUS_APPROVED_ACTIVE) ||
          status.equals(FAHomeHistoryConversation.CODE_STATUS_APPROVED_INACTIVE) ||
          status.equals(FAHomeHistoryConversation.CODE_STATUS_PENDING_APPROVAL)) {
        if (maleMinAgeInMonths == 0 && maleMaxAgeInMonths == 0 &&
            femaleMinAgeInMonths == 0 && femaleMaxAgeInMonths == 0) {
          setErrorMessage(Messages.MSG_FAD_AGE_REQ);
          result = false;
        }
      }

      if (maleMinAgeInMonths != 0 && maleMaxAgeInMonths == 0) {
        setErrorMessage("selMaleMaxYear", Messages.MSG_MIN_MALE_RANGE);
        result = false;
      } else if (maleMinAgeInMonths == 0 && maleMaxAgeInMonths != 0) {
        setErrorMessage(M_MIN_YEAR_FIELD, Messages.MSG_MAX_MALE_RANGE);
        result = false;
      } else if (maleMinAgeInMonths > maleMaxAgeInMonths) {
        setErrorMessage(M_MIN_YEAR_FIELD, Messages.SSM_FAD_MIN_LESS_MAX);
        result = false;
      }

      if (femaleMinAgeInMonths != 0 && femaleMaxAgeInMonths == 0) {
        setErrorMessage("selFemaleMaxYear", Messages.MSG_MIN_FEMALE_RANGE);
        result = false;
      } else if (femaleMinAgeInMonths == 0 && femaleMaxAgeInMonths != 0) {
        setErrorMessage(F_MIN_YEAR_FIELD, Messages.MSG_MAX_FEMALE_RANGE);
        result = false;
      } else if (femaleMinAgeInMonths > femaleMaxAgeInMonths) {
        setErrorMessage(F_MIN_YEAR_FIELD, Messages.SSM_FAD_MIN_LESS_MAX);
        result = false;
      }

    } //end if end date is null

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return result;
  }

}