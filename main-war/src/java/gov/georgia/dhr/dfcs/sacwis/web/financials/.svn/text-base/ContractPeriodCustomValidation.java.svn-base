package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cconstat;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

/* Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
01/06/09  charden           STGAP00009689: added condition to prevent user from saving start date greater than
                            the current date for the contract period
09/12/11  charden           STGAP00017058: added new validations                           


*/

@SuppressWarnings("serial")
public class ContractPeriodCustomValidation extends FormValidation {

  /**
   * This method is used to validate items entered on the Contract Period JSP form.
   * 
   * @return isValid
   */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ContractPeriodCustomValidation", "validateForm");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".validateForm");
    HttpServletRequest request = this.getRequest();
    BaseSessionStateManager state = super.getState();

    boolean isValid = true;

    String cboStatus = getInputValue("cboStatus");

    Date termDate = null;
    Date startDate = null;
    Date earlyTermDate = null;
    String nbrPeriod = (String) ContextHelper.getStringSafe(request, "hdnStrPeriod");
    Date hdnTermDate = getNonNullDate(ContextHelper.getJavaDateSafe(request, "hdnTxtTerm"));
    Date hdnStartDate = getNonNullDate(ContextHelper.getJavaDateSafe(request, "hdnTxtStart"));
    Date hdnEarlyTermination = getNonNullDate(ContextHelper.getJavaDateSafe(request, "hdnTxtEarly"));
    String isEditPlusMode = (String) ContextHelper.getStringSafe(request, "isEditPlusMode");
    String hdnCboStatus = (String) ContextHelper.getStringSafe(request, "hdnCboStatus");

    if (getInputValue("txtStart") == null) {
      startDate = getNonNullDate(ContextHelper.getJavaDateSafe(request, "hdnTxtStart"));
    } else {
      startDate = getNonNullDate(ContextHelper.getJavaDateSafe(request, "txtStart"));
    }

    if (getInputValue("txtTerm") == null) {
      termDate = getNonNullDate(ContextHelper.getJavaDateSafe(request, "hdnTxtTerm"));
    } else {
      termDate = getNonNullDate(ContextHelper.getJavaDateSafe(request, "txtTerm"));
    }

    if (getInputValue("txtEarly") == null) {
      earlyTermDate = getNonNullDate(ContextHelper.getJavaDateSafe(request, "hdnTxtEarly"));
    } else {
      earlyTermDate = getNonNullDate(ContextHelper.getJavaDateSafe(request, "txtEarly"));
    }

    // If this is an Add (dataAction == "A"), then periodIndex will always be 0.
    // Otherwise, periodIndex will be the CCON05SO array index of the period
    // being edited.
    int periodIndex = ContextHelper.getIntSafe(request, "hdnContractPeriod");

    CCON05SO ccon05so = (CCON05SO) state.getAttribute("CCON05SO", request);
    ROWCCON05SOG00 previousRow = null;

    // If this is the first period (CCON05SO is null or rowcount == 0), no need
    // to attempt date comparison.
    if (ccon05so != null && ccon05so.getROWCCON05SOG00_ARRAY() != null
        && ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00Count() > periodIndex) {
      // Otherwise, if it's an Add, compare new start date with term date of
      // preceding period, which will be the 0th element in the array.
      if (PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {
        previousRow = ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(0);
      }
      // If it's not an add, the previous row will be the next highest array
      // element in the array, unless this is the first period, in which case
      // we also won't do the date comparison.
      else if ((periodIndex + 1) < ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00Count()) {
        previousRow = ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(periodIndex + 1);
      }
    }
    // If that logic produced a non-null previousRow, then compare the start date
    // being saved to the term date of the previous row.
    if (previousRow != null) {
      org.exolab.castor.types.Date cTermDate = previousRow.getDtDtCnperTerm();
      Date dayAfterPreviousTermDate = DateHelper.addToDate(getNonNullDate(DateHelper.toJavaDate(cTermDate)), 0, 0, 1);

      if ((isEditPlusMode == null || "N".equals(isEditPlusMode)) && !startDate.equals(dayAfterPreviousTermDate)) {
        setErrorMessage(Messages.MSG_CON_START_LAST_TERM);
        isValid = false;
      }
    }
    //STGAP00009689 - added condition so that contract period start date cannot be greater than the current date
    if("1".equals(nbrPeriod) && DateHelper.isAfterToday(startDate)){
      setErrorMessage(Messages.MSG_STRT_NO_FUTR);
      isValid = false;
    }

    if (("PNT".equals(cboStatus)) && !DateHelper.isAfterToday(earlyTermDate)) {
      setErrorMessage(Messages.SSM_CON_CLOSE_AFTER_CUR);
      isValid = false;
    }

    if (("PNT".equals(cboStatus)) && (DateHelper.minutesDifference(earlyTermDate, termDate) > 0)) {
      setErrorMessage(Messages.SSM_CON_CLOSE_BEF_SAM_TER);
      isValid = false;
    }
    if (("PNT".equals(cboStatus)) && (DateHelper.minutesDifference(startDate, earlyTermDate) >= 0)) {
      setErrorMessage(Messages.SSM_CON_START_BEFORE_TERM);
      isValid = false;
    }
    if ((DateHelper.minutesDifference(startDate, termDate) >= 0)) {
      setErrorMessage(Messages.SSM_CON_START_BEFORE_TERM);
      isValid = false;
    }

    if ("PNT".equals(cboStatus) && ((getInputValue("txtEarly") != null))
        && ("".equalsIgnoreCase(getInputValue("txtEarlyTermCmt")))) {
      // setErrorMessage(Messages.SSM_CON_START_BEFORE_TERM);
      setErrorMessage(TERM_COMMENT);
      isValid = false;
    }
    
    //Start STGAP00017058
    if(isEditPlusMode != null && "Y".equals(isEditPlusMode)){
      // validate dates
      boolean isValidStartDate = DateHelper.isValidDate(startDate);
      boolean isValidHdnEarlyTermination = DateHelper.isValidDate(hdnEarlyTermination);
      boolean isValidEarlyTermDate = DateHelper.isValidDate(earlyTermDate);
      boolean isValidTermDate = DateHelper.isValidDate(termDate);
      boolean isValidHdnTermDate = DateHelper.isValidDate(hdnTermDate);   
      Date today = new Date();
      
      //MSG_FUTR_EFF_DATE
      if(isValidStartDate && startDate.compareTo(today) > 0){
        setErrorMessage(Messages.MSG_FUTR_EFF_DATE);
        isValid = false;
      }
      //MSG_EARLY_TERM_END_DT
      if(isValidHdnEarlyTermination && isValidEarlyTermDate && isValidTermDate && 
                      hdnEarlyTermination.compareTo(earlyTermDate) != 0 && earlyTermDate.compareTo(termDate) != 0){
        setErrorMessage(Messages.MSG_EARLY_TERM_END_DT);
        isValid = false;
      }
      //MSG_END_DT_NOT_ACTIVE
      if(isValidTermDate && termDate.compareTo(today) > 0 && Cconstat.CCONSTAT_CLS.equals(cboStatus)){
        setErrorMessage("When the end date is in the future the status of the Period cannot be Closed.");
        isValid = false;
      }
      //MSG_ACTIVE_NO_END_DT
      if(isValidTermDate && isValidHdnTermDate && !hdnCboStatus.equals(cboStatus) && Cconstat.CCONSTAT_ACT.equals(cboStatus) && termDate.compareTo(today) <= 0){
        setErrorMessage(Messages.MSG_ACTIVE_NO_END_DT);
        isValid = false;
      }
    }
    // End STGAP00017058

    GrndsTrace.exitScope(TRACE_TAG + ".validateForm");
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }
  
  private Date getNonNullDate(Date jDate) {
    if(jDate == null) {
      jDate = DateHelper.MAX_JAVA_DATE;
    }
    return jDate;
  }

  // static constants
  public static final String TRACE_TAG = "ContractPeriodCustomValidation";

  public static final String TERM_COMMENT = "Enter Early Term Comment";
  
  public static final String MSG_END_DT_NOT_ACTIVE = "When the end date is in the future the status of the Period must be active.";

}