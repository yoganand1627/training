package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- architecture classes --

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.types.Date;

/**
 * Merge Split Custom validation class
 * <p>
 * Description: This Class verifies all of the information for the ServiceAuthHeader page
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Accenture
 * </p>
 * 
 * @author Anna Grimshaw
 * @version 1.0
 * 
 * <pre>
 *                           Change History:
 *                            Date      User              Description
 *                            --------  ----------------  --------------------------------------------------
 *                            05/08/03  GRIMSHAN          SIR #17301 Added a condition to display a message
 *                                                        if the Service Auth is complete, and Update or
 *                                                        Terminate has not been selected
 *                            05/12/03  GRIMSHAN          SIR #17391 Changed the condition for
 *                                                        SSM_CON_NO_RENEWAL so that if the contract is
 *                                                        not a renewal, make sure that the end date is
 *                                                        not after the contract closure date
 *                            05/12/03  GRIMSHAN          SIR #17400 Changed Unit Type check so that the
 *                                                        value is being retrieved from the hidden field
 *                                                        instead of the display only field.
 *                            05/13/03  GRIMSHAN          SIR #17418 Changed SSM_SVC_AUTH_AFTER_STG_CLS to
 *                                                        new message SSM_SVC_AUTH_AFTER_END so that if the
 *                                                        End Date was after the stage closure date the
 *                                                        message would say that, instead of effective date
 *                            08/27/03  A.Corley          SIR 19518 - If frequency is less than or equal to 0,
 *                                                        display a message.
 *                            09/04/03  A.Corley          SIR 19675 - only run begin and end date checks if
 *                                                        we are not in set a, if we are in set a the begin and
 *                                                        end date fields are disabled.
 *                            10/14/03  CORLEYAN          SIR 19857 -- ContextHelper.get... replaces
 *                                                        getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD
 *                                                        removed message lookup.
 *                            06/11/08  arege             STGAP00006593  Invalid Requested Units Error Message on Save
 *                                                        Added an if clause          
 *                                                        
 *                            07/21/08  Cwells            STGAP00008253 Changed 3 Month calculation to be done by adding months
 *                                                        instead of 90 days.z                                        
 *                                                        
 *                  &lt;p/&gt;
 * </pre>
 */

public class ServiceAuthDetailCustomValidation extends FormValidation {
  
  
  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = this.getRequest();
    String szTxtRefQltyCmnts = ContextHelper.getStringSafe(request, "szTxtRefQltyCmnts");
    String szCdSvcQlty = ContextHelper.getStringSafe(request, "szCdSvcQlty");
    String rbIndServAcpt = ContextHelper.getStringSafe(request, "rbIndServAcpt");
    String rbIndCasePlnSvc = ContextHelper.getStringSafe(request, "rbIndCasePlnSvc");
    String szCdSvcAuthDtlAuthType = ContextHelper.getStringSafe(request, "selSzCdSvcAuthDtlAuthType");
    String szCdCnsvcPaymentType = ContextHelper.getStringSafe(request, "hdnSzCdCnsvcPaymentType");
    String cIndCnperRenewal = ContextHelper.getStringSafe(request, "hdnCIndCnperRenewal");
    String pageModePassed = ContextHelper.getStringSafe(request, "hdnPageModePassed");
    String szCdSvcAuthDtlUnitType = ContextHelper.getStringSafe(request, "hdnSzCdSvcAuthDtlUnitType");
    String selSzCdSvcAuthDtlSvc = ContextHelper.getStringSafe(request, "selSzCdSvcAuthDtlSvc");
    int uNbrSvcAuthDtlFreq = ContextHelper.getIntSafe(request, "txtUNbrSvcAuthDtlFreq");
    String[] cbxValues = CheckboxHelper.getCheckedValues(request, "cbx_");
    org.exolab.castor.types.Date dtDtSvcAuthDtlBegin = ContextHelper.getCastorDateSafe(request,
                                                                                       "txtDtDtSvcAuthDtlBegin");
    org.exolab.castor.types.Date dtDtSvcAuthDtlEnd = ContextHelper.getCastorDateSafe(request, "txtDtDtSvcAuthDtlEnd");
    org.exolab.castor.types.Date dtDtSvcAuthDtlTerm = ContextHelper.getCastorDateSafe(request, "txtDtDtSvcAuthDtlTerm");
    org.exolab.castor.types.Date dtDtCnperStart = ContextHelper.getCastorDateSafe(request, "hdnDtDtCnperStart");
    org.exolab.castor.types.Date dtDtCnperClosure = ContextHelper.getCastorDateSafe(request, "hdnDtDtCnperClosure");
    org.exolab.castor.types.Date dtDtSvcAuthEff = ContextHelper.getCastorDateSafe(request, "hdnDtDtSvcAuthEff");
    org.exolab.castor.types.Date dtDtStageClose = ContextHelper.getCastorDateSafe(request, "hdnDtDtStageClose");
    org.exolab.castor.types.Date dtDtSituationOpened = ContextHelper.getCastorDateSafe(request,
                                                                                       "hdnDtDtSituationOpened");
    // These two items will be gotten as floats so that the comparisons will be accurate
    double lAmtSvcAuthDtlAmtReq = 0.0;
    double lNbrSvcAuthDtlUnitReq = 0.0;
    double ulNbrCnsvcUnitRate = 0.0;
    String isApproved = ContextHelper.getStringSafe(request, "hdnFlag");
    if (uNbrSvcAuthDtlFreq <= 0) {
      setErrorMessage("txtUNbrSvcAuthDtlFreq", Messages.MSG_FREQ_GRTR_ZERO);
      result = false;
    }

    if (request.getParameter("txtLNbrSvcAuthDtlUnitReq") != null) {
      lNbrSvcAuthDtlUnitReq = ContextHelper.getDoubleSafe(request, "txtLNbrSvcAuthDtlUnitReq");
    } else {
      lNbrSvcAuthDtlUnitReq = ContextHelper.getDoubleSafe(request, "hdnLNbrSvcAuthDtlUnitReq");
    }
    if (request.getParameter("txtLAmtSvcAuthDtlAmtReq") != null) {
      lAmtSvcAuthDtlAmtReq = ContextHelper.getMoneyAsDoubleSafe(request, "txtLAmtSvcAuthDtlAmtReq");
    } else {
      lAmtSvcAuthDtlAmtReq = ContextHelper.getMoneyAsDoubleSafe(request, "hdnLAmtSvcAuthDtlAmtReq");
    }
    double lNbrSvcAuthDtlUnitRate = ContextHelper.getDoubleSafe(request, "hdnLNbrSvcAuthDtlUnitRate");
    ulNbrCnsvcUnitRate = ContextHelper.getMoneyAsDoubleSafe(request, "ulNbrCnsvcUnitRate");
    // Create float versions of amount and unit requested for comparison
    float floatLAmtSvcAuthDtlAmtReq = (float) lAmtSvcAuthDtlAmtReq;
    float floatLNbrSvcAuthDtlUnitRate = (float) lNbrSvcAuthDtlUnitRate;
    float floatUlNbrCnsvcUnitRate = (float) ulNbrCnsvcUnitRate;
    if (CodesTables.CCONPAY_VUR.equals(szCdCnsvcPaymentType) && floatUlNbrCnsvcUnitRate > floatLNbrSvcAuthDtlUnitRate) {
      setErrorMessage("ulNbrCnsvcUnitRate", Messages.MSG_CON_RATE_EXCEEDED);
      result = false;
    }
    // check if the line items exceed the line item limits.
    try {
      Set codesAvailable = new HashSet<String>(Lookup.getCategoryCodesCollection(CodesTables.CSAMTLMT));
      if (codesAvailable.contains(selSzCdSvcAuthDtlSvc)) {
        Double amtLimit = 0.0;
        amtLimit = Double.valueOf((Lookup.simpleDecodeSafe(CodesTables.CSAMTLMT, selSzCdSvcAuthDtlSvc)));
        double doubleAmtLimit = (double) amtLimit;
        float floatAmtLimit = (float) doubleAmtLimit;
        if (floatLAmtSvcAuthDtlAmtReq > floatAmtLimit) {
          setErrorMessage("txtLAmtSvcAuthDtlAmtReq", Messages.MSG_BUDGET_EXCEEDED);
          result = false;
        }
      }

    } catch (LookupException e) {
      setErrorMessage("Failure:" + e.getMessage());
      result = false;
    }

    double lNbrSvcAuthDtlUnitUsed = ContextHelper.getDoubleSafe(request, "dspLNbrSvcAuthDtlUnitUsed");
    double minutesDifference = 0.0;
    boolean bValid = true;
    if (CodesTables.CSVATYPE_TRM.equals(szCdSvcAuthDtlAuthType)) {
      // Verify that Term Date is not blank
      if (dtDtSvcAuthDtlTerm == null) {
        setErrorMessage("txtDtDtSvcAuthDtlTerm", Messages.MSG_TYPE_TERM);
        result = false;
      }
      // Verify that Begin Date is Before or equal to Term Date
      if (DateHelper.isAfter(dtDtSvcAuthDtlBegin, dtDtSvcAuthDtlTerm)) {
        setErrorMessage(Messages.SSM_CON_TERM_BEFORE_BEG);
        result = false;
      }
      // Verify that Term Date is Before or equal to End Date
      if (DateHelper.isBefore(dtDtSvcAuthDtlEnd , dtDtSvcAuthDtlTerm)) {
        setErrorMessage(Messages.SSM_CON_TERM_AFTER_END);
        result = false;
      }
      // STGAP00010535 Verify that comments are entered under referal and quality of service
      if("".equals(szTxtRefQltyCmnts)){
        setErrorMessage(Messages.MSG_SVC_AUTH_DTL_COMM_REQ);
        result = false;
      }
    }
    // If the Auth is complete, verity that units requested are less than units used
    // Also verify that only update or terminate have been selected
    if (!ArchitectureConstants.TRUE.equals(isApproved)) {
      if (lNbrSvcAuthDtlUnitReq < lNbrSvcAuthDtlUnitUsed) {
        setErrorMessage("txtLNbrSvcAuthDtlUnitReq", Messages.SSM_CON_REQ_LESS_THAN_USED);
        result = false;
      }
    }
    // SIR STGAP00004140
    // Removed the validation code which determines if The Period entered is greater than or equal
    // to the span of days entered from begin date to either the end date or the term date.
    // SIR 19675 Only run these date checks if we are NOT in Set A (if we are in set a the
    // begin and end date are disabled
    if (!Sets.isInSet(Sets.A, request)) {
      // Verify that Begin date is after Contract Start Date
      if (DateHelper.isBefore(dtDtSvcAuthDtlBegin, dtDtCnperStart)) {
        setErrorMessage("txtDtDtSvcAuthDtlBegin", Messages.SSM_CON_BEF_FIRST_PERIOD);
        result = false;
      }
      // Verify that Begin Date is before Authorization Effective Date
      if (DateHelper.isBefore(dtDtSvcAuthDtlBegin, dtDtSvcAuthEff)) {
        setErrorMessage("txtDtDtSvcAuthDtlBegin", Messages.SSM_BEGIN_BEFORE_EFF);
        result = false;
      }
      // Verify that Begin Date is not more than 30 days after effective date
      minutesDifference = DateHelper.minutesDifference(dtDtSvcAuthDtlBegin, dtDtSvcAuthEff);
      if (minutesDifference > MINUTES_MONTH) {
        setErrorMessage("txtDtDtSvcAuthDtlBegin", Messages.SSM_BEGIN_AFTER_EFF);
        result = false;
      }
      // Verify that End Date is before Stage Closure date
      if (DateHelper.isAfter(dtDtSvcAuthDtlEnd, dtDtStageClose)) {
        // SIR 17418 Added a new message for this error
        setErrorMessage("txtDtDtSvcAuthDtlEnd", Messages.SSM_SVC_AUTH_AFTER_END);
        result = false;
      }
      if (DateHelper.isAfter(dtDtSvcAuthDtlBegin, dtDtSvcAuthDtlEnd)) {
        setErrorMessage(Messages.SSM_CON_BEG_BEFORE_END);
        result = false;
      }

      // The following block of code determines these things:
      // A. If the Program is CPS
      // 1. If the Stage is Investigation, validate that
      // the begin and end dates are less than 3 months apart
      // 2. If the Stage is any other stage, validate that the two dates
      // are 6 months or less apart. However, if the begin date is on
      // the last day of the month, the serivice auth can go through the
      // the last day of the 6 month. I.E if the begin date is Feb 28th
      // the end date can be August 31st.
      // B. If the Program is APS
      // 1. If the the Stage is Service Delivery and the Stage Type is
      // Guardianship, validate that the begin and end dates are less than
      // 1 year (365 days) apart.
      // 2. If the stage is any other stage, validate that the two dates are
      // less than two months (sixty days) apart.

      if (CodesTables.CTXGASTG_INV.equals(GlobalData.getSzCdStage(request))) {
        // Validate that End date is not 90 days greater than begin date

        // STGAP00008101 Check for 3 months instead of 90 days.
        Date threeMonthsFutureDate = null;
        threeMonthsFutureDate = DateHelper.addToDate(dtDtSvcAuthDtlBegin, 0, 3, 0);

        if (DateHelper.isBefore(threeMonthsFutureDate, dtDtSvcAuthDtlEnd)) {
          setErrorMessage(Messages.SSM_CON_AUTH_PER_TOO_LONG);
          result = false;
        }
      } else {

        int code = compare(dtDtSvcAuthDtlBegin, dtDtSvcAuthDtlEnd);

        // end date is after 12 months from the begin date
        if (code == AFTER) {
          bValid = false;
        }
        // end date is equal to 12 months from the begin date
        else if (code == EQUALS) {
          bValid = true;
        }
        // end date is before 12 months from the begin date
        else if (code == BEFORE) {
          bValid = true;
        }

        if (bValid == false) {
          setErrorMessage(Messages.SSM_CON_AUTH_PER_TOO_LONG);
          result = false;
        }

      }

      // Validate that the begin date is after the Situation Opened Date
      if (DateHelper.isBefore(dtDtSvcAuthDtlBegin, dtDtSituationOpened)) {
        setErrorMessage("txtDtDtSvcAuthDtlBegin", Messages.SSM_CON_BEG_BEFORE_SIT);
        result = false;
      }

      // If the Contract is not a period renewal, Validate that the that the cannot be after the Closure date
      if (ArchitectureConstants.N.equals(cIndCnperRenewal)) {
        if (DateHelper.isAfter(dtDtSvcAuthDtlEnd, dtDtCnperClosure)) {
          setErrorMessage("txtDtDtSvcAuthDtlEnd", Messages.SSM_CON_NO_RENEWAL);
          result = false;
        }
      }

    } // end not in set a

    // If the payment type is VUR, validate that the unit rate field has been filled
    if (CodesTables.CCONPAY_VUR.equals(szCdCnsvcPaymentType)) {
      if (ulNbrCnsvcUnitRate == 0.0) {
        setErrorMessage("ulNbrCnsvcUnitRate", Messages.MSG_AMT_REQD);
        result = false;
      }
    }

    // If the payment type is not VUR, validate that teh Requested Units Field has been filled
    if (!CodesTables.CCONPAY_VUR.equals(szCdCnsvcPaymentType)
        || (CodesTables.CCONPAY_VUR.equals(szCdCnsvcPaymentType) && !CodesTables.CCONUNIT_ONE
                                                                                             .equals(szCdSvcAuthDtlUnitType))) {
      if (lNbrSvcAuthDtlUnitReq == 0.0) {
        setErrorMessage("txtLNbrSvcAuthDtlUnitReq", Messages.MSG_REQ_UNIT_REQD);
        result = false;
      }
    }

    // If the page mode is new, validate that at least one person has been selected
    if (PageModeConstants.NEW.equals(pageModePassed)) {
      if (cbxValues.length == 0) {
        setErrorMessage(Messages.SSM_CON_PERSON_REQ);
        result = false;
      }
    }
    // STGAP00010535 if the radio button Service Provider Accepted is No then the 
    // comments section should be filled out.  Also see if it has already been displayed
    // by the Authorization Type being set to Terminate. 
    if("N".equals(rbIndServAcpt) && "".equals(szTxtRefQltyCmnts) && !CodesTables.CSVATYPE_TRM.equals(szCdSvcAuthDtlAuthType)) {
      setErrorMessage(Messages.MSG_SVC_AUTH_DTL_COMM_REQ);
      result = false;
    }

    // Validate that if the Unit Type is not One-Time, the auth type cannot be one time
    if (!CodesTables.CCONUNIT_ONE.equals(szCdSvcAuthDtlUnitType)
        && CodesTables.CSVATYPE_ONT.equals(szCdSvcAuthDtlAuthType)) {
      setErrorMessage("selSzCdSvcAuthDtlAuthType", Messages.SSM_CON_AUTH_TYPE_ONE_TIME);
      result = false;

    }

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! ");
    performanceTrace.exitScope();
    return result;
  }

  private static int compare(org.exolab.castor.types.Date begin, org.exolab.castor.types.Date end) {
    int rc = 0;
    // create a date for the end date object
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date endDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();

    // create a date that is the last day of the month 6 months from the
    // begin date, to compare with the end date
    gov.georgia.dhr.dfcs.sacwis.core.utility.Date endCompareDate = new gov.georgia.dhr.dfcs.sacwis.core.utility.Date();
    endCompareDate.setTime(begin.toDate());

    // STGAP00008101 Dates changed to check for after 12 months
    if (endCompareDate.numberOfDaysInMonth() == endCompareDate.getDayOfMonth()) {
      endCompareDate.addMonths(12);
      endCompareDate.setDayOfMonth(endCompareDate.numberOfDaysInMonth());
    } else {
      endCompareDate.addMonths(12);
    }

    endDate.setTime(end.toDate());

    if (endDate.after(endCompareDate)) {
      rc = AFTER;
    }
    // end date is equal to 12 months from the begin date
    else if (endDate.equals(endCompareDate)) {
      rc = EQUALS;
    }
    // end date is before 12 months from the begin date
    if (endDate.before(endCompareDate)) {
      rc = BEFORE;
    }
    return rc;
  }

  /**
   * ***************************************************************************** * Declare any static constants.
   * ******************************************************************************
   */
  // static constants
  public static final String TRACE_TAG = "ServiceAuthHeaderCustomValidation";

  public static final int MINUTES_DAY = 1440;

  public static final int MINUTES_WEEK = 10080;

  public static final int MINUTES_BI_MONTH = 21600;

  public static final int MINUTES_MONTH = 43200;

  public static final int MINUTES_TWO_MONTH = 86400;

  public static final int MINUTES_SIX_MONTH = 259200;

  public static final int MINUTES_THREE_MONTH = 129600;

  public static final int MINUTES_YEAR = 525600;

  public static final String DAY = "DAY";

  public static final String WEEK = "CWK";

  public static final String BI_MONTH = "MBI";

  public static final String MONTH = "MMO";

  public static final String SIX_MONTH = "MSI";

  public static final String THREE_MONTH = "MTH";

  public static final String YEAR = "YEA";

  public static final int BEFORE = -1;

  public static final int EQUALS = 0;

  public static final int AFTER = 1;

}