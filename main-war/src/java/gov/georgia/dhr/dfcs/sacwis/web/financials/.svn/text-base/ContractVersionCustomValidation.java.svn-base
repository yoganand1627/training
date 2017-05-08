package gov.georgia.dhr.dfcs.sacwis.web.financials;

// -- java classes --

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.types.Date;
import org.grnds.facility.log.GrndsTrace;

/**
 * This class is used to validate Case Search information.
 *
 * @author Paul Lang, February 21, 2003
 * 
 * 
 *Change History: 
 *Date      User         Description 
 *---------------------------------------------------------------------------------------------------------- 
 *10/14/03  CORLEYAN     SIR 19857 -- ContextHelper.get... replaces getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 *09/12/11  charden      STGAP00017058 - adding new validations               
 */
public class ContractVersionCustomValidation extends FormValidation {
  // static constants
  public static final String TRACE_TAG = "ContractVersionCustomValidation";
  
  /**
   * This method is used to validate item submitted on the form in the contractVersion JSp.
   *
   * @return isValid
   */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("ContractVersionCustomValidation", "validateForm");
    // start the method trace
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".validateForm");
    BaseSessionStateManager state = super.getState();
    HttpServletRequest request = this.getRequest();

    boolean isValid = true;

    int versionNbr = ContextHelper.getIntSafe(request, "txtVersion");
    int previousVersionNbr = versionNbr - 1;
    

    Date effectiveDate = ContextHelper.getCastorDateSafe(request, "txtEffective");
    Date endDate = ContextHelper.getCastorDateSafe(request, "txtEnd");
    boolean isEditPlusMode = ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "isEditPlusMode")) ? true : false;
    Date oldEffectiveDate = ContextHelper.getCastorDateSafe(request, "hdnTxtEffective");
    // Added to test previous date effective
    //Date previousEffectiveDate = ContextHelper.getCastorDateSafe(request, "hdnTxtEffective");

    // Get the Previous Version Effective Date and compare it against the current Version Effective date. If the
    // New Date isn't 1 day (1440 minutes) greater than the previous Version's effective Date it throws the error message.
    CCON07SO ccon07so = (CCON07SO) state.getAttribute("CCON07SO", request);
    int arraySize = ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00Count();

    if (previousVersionNbr > 0) {

      ROWCCON07SOG00 previousRow = ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(arraySize - previousVersionNbr);
      Date previousEffectiveDate = previousRow.getDtDtCnverEffective();
      Date previousEndDate = previousRow.getDtDtCnverEnd();
      
      // SIR 19852 -- One day is equal to 1440, but the problem is the message is worded as follows:
      // ' The Eff. date must be two days after the previous version's Eff. date.'.  So, the condition should
      // be < (60 * 24 * 2) not < (60 * 24 * 1).

//      if ((DateHelper.minutesDifference(effectiveDate, previousEffectiveDate) < (60 * 24 * 2))) {
//        super.setErrorMessage(Messages.MSG_CON_EFF_GT_PREV_EFF);
//        isValid = false;
//      }
      
      // perform checks
      if(DateHelper.isValidDate(effectiveDate) && DateHelper.isValidDate(previousEffectiveDate) && DateHelper.toJavaDate(effectiveDate).compareTo(DateHelper.toJavaDate(previousEffectiveDate)) <= 0){
        //MSG_EFF_DT_SAME_PREV_EFF_DT
        super.setErrorMessage(Messages.MSG_EFF_DT_SAME_PREV_EFF_DT);
        isValid = false;
      }
      if(DateHelper.isValidDate(effectiveDate) && DateHelper.isValidDate(previousEffectiveDate) && DateHelper.toJavaDate(effectiveDate).compareTo(DateHelper.toJavaDate(previousEffectiveDate)) == 0){
        //MSG_SAME_EFF_AND_END_DT
        super.setErrorMessage(Messages.MSG_SAME_EFF_AND_END_DT);
        isValid = false;
      }
      if(DateHelper.isValidDate(effectiveDate) && DateHelper.isValidDate(previousEffectiveDate) && DateHelper.addToDate(effectiveDate, 0, 0, -2).compareTo(previousEffectiveDate) <= 0){
        //MSG_TWO_DAY_MIN
        super.setErrorMessage(Messages.MSG_TWO_DAY_MIN);
        isValid = false;
      }
    }

    // Get the Period Closure date for the Version. The Version Effective date must be at least one day
    //before the Period closure or earlier.  Subtract the Effective Date minutes from the Period Closure
    //date minutes and make sure it's less than -1440.

    CCON05SO ccon05so = (CCON05SO) state.getAttribute("CCON05SO", request);
    int periodIndex = ContextHelper.getIntSafe(request, "hdnContractPeriod");

    ROWCCON05SOG00 periodRow = ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(periodIndex);
    Date periodClosureDate = periodRow.getDtDtCnperClosure();
    if ((DateHelper.minutesDifference(effectiveDate, periodClosureDate) > (-1440))) {
      super.setErrorMessage(Messages.MSG_VERS_BEFORE_CLOSURE);
      isValid = false;
    }

    // The Effective Date must be before or the same as the End date. Subtract the difference and
    //make sure equal to or less than zero.

    if ((DateHelper.minutesDifference(effectiveDate, endDate) > 0)) {
      super.setErrorMessage(Messages.SSM_CON_EFF_BEF_SAME_END);
      isValid = false;
    }
    
    //STGAP00017058
    java.util.Date today = new java.util.Date();
    if(DateHelper.isValidDate(effectiveDate) && DateHelper.toJavaDate(effectiveDate).compareTo(today) > 0){
      //MSG_FUTR_EFF_DATE
      super.setErrorMessage(Messages.MSG_FUTR_EFF_DATE);
      isValid = false;
    }

    GrndsTrace.exitScope(TRACE_TAG + ".validateForm");
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }
}