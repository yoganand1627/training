/**
 * Validation class Name:    Adoption Assistance Custom Validation
 * This is the Validation class used to validate subsidy details on the
 * Adoption Assistance page.  This code is shamelessly stolen by:
 * @author
 * Wes Thompson, January 28, 2003
 *
 * Change History:
 * Date        User              Description
 * --------    ----------------  ----------------------------------------------
 *
 * 06/24/2003  Eric Dickman       SIR 18471-- Removed the SSM_COMPLETE_REQUIRED
 *                                message.  The MSG_NO_AMOUNT_IN_ADOPT_SUB preforms
 *                                same the same functionality.
 * 09/08/2003  thompswa           SIR 19742 The adoption must be consummated for
 *                                a non-recurring subsidy to be approved.  When
 *                                "szCdLegalStatStatus".equals( "" ), message is
 *                                MSG_FAD_ADPT_NOT_CONSUM. Reversed message change
 *                                referenced above in SIR 18471.
 * 10/14/03     CORLEYAN          SIR 19857 -- ContextHelper.get... replaces
 *                                getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD
 *                                removed message lookup.
 * 01/15/2009   wjcochran         STGAP00011598: Added validation to check for non-recurring
 *                                adoption assistance agreement in the ADO stage
 * 01/18/2009   wjcochran         STGAP00011586: Added validation to check for current service authorization
 *                                when the user clicks the Approval Status button
 * 05/14/2009   bgehlot           STGAP00013779: MR-050: Added and Modified code for Different Validations
 * 06/02/2009   bgehlot           STGAP00014031: Please Specify a Payment Method when saving a Special Service or Non-Recurring Agreement.
 * 06/07/2009   bgehlot           STGAP00014114 : Added check for 01.03,07,09 also
 * 12/03/2009   mxpatel           SMS #37374: To terminate Agreement both Term Date and Reason are needed
 *
 */
package gov.georgia.dhr.dfcs.sacwis.web.financials;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

/**
 * 
 * <pre>
 *   Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *  02/16/2010    mxpatel               SMS #45630: removed the code written for validations of message "MSG_SVC_AUTH_REQ", as this validations 
 *                                      are carried out in the SaveAdoptionSubsidyImpl.java as well
 *                                                                        
 * </pre>
 * 
 */

public class AdoptionAsstncCustomValidation extends FormValidation {
  /**
   * <p>This method contains custom validation that is checked when the user adds or modifies adoption assistance
   * details.</p>
   *
   * @return result - Returns false if the data fails validation.  Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = super.getRequest();
    String szCdEventStatus = ContextHelper.getStringSafe(request, "szCdEventStatus");

    if (super.isButtonPressed(SAVE_BUTTON) || super.isButtonPressed(COMPLETE_BUTTON)) {
      if(szCdEventStatus == null || StringHelper.EMPTY_STRING.equals(szCdEventStatus) || EVENT_STATUS_PROC.equals(szCdEventStatus)){
        validateFormForSave();
      }else if(EVENT_STATUS_COMP.equals(szCdEventStatus)){
        validateFormForComplete();        
      }
    }
    
    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }

  /**
   * <p>This method contains custom validation that is checked when the user saves a new adoption assistance and the event
   *  status is not COMP.</p>
   *
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  protected void validateFormForSave() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateFormForSave()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    
    String adoptType = ContextHelper.getStringSafe(request, "selSzCdAdptSubDeterm");
    String selSzCdAdptSubDeterm = ContextHelper.getStringSafe(request, "selSzCdAdptSubDeterm");
    String txtSzCdAdptSubCloseRsn = ContextHelper.getStringSafe(request, "txtSzCdAdptSubCloseRsn");
    org.exolab.castor.types.Date txtDtDtAdptSubEffective = ContextHelper.getCastorDateSafe(request,
                                                                                           "txtDtDtAdptSubEffective");
    org.exolab.castor.types.Date birthDate = ContextHelper.getCastorDateSafe(request, "hdnDtDtPersonBirth");
    org.exolab.castor.types.Date txtDtDtAdptSubEnd = ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubEnd");
    org.exolab.castor.types.Date txtDtDtAdptSubTerm = ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubTerminated");
    org.exolab.castor.types.Date txtDtDtAdptSubApprvd = ContextHelper.getCastorDateSafe(request,
                                                                                        "txtDtDtAdptSubApprvd");

    String szCdLegalStatStatus = ContextHelper.getStringSafe(request, "szCdLegalStatStatus");
    String txtSzCdPaymentMethod = ContextHelper.getStringSafe(request, "txtSzCdPaymentMethod");
    // STGAP00014599: Since payment method for basic and specialized rates  are disabled, 
    // the payment method is set to PAR
    if((adoptType.equals(CodesTables.CSUBTYPE_01) || adoptType.equals(CodesTables.CSUBTYPE_03) ||
        adoptType.equals(CodesTables.CSUBTYPE_07) || adoptType.equals(CodesTables.CSUBTYPE_09))){
      txtSzCdPaymentMethod = CodesTables.CPAYMTHD_PAR;
    }
    String cSysIndServiceAuthCurrent = ContextHelper.getStringSafe(request, "cSysIndServiceAuthCurrent");
    
    //STGAP00013779: Other Special Service Please Specify comments are required when Type/Class of Assistance Spec Svc Asst - Other is selected.
    org.exolab.castor.types.Date hdnDtDtCnperTerm = ContextHelper.getCastorDateSafe(request, "hdnDtDtCnperTerm");
    org.exolab.castor.types.Date txtDtDtRenwlEffBegin = ContextHelper.getCastorDateSafe(request,"txtDtDtRenwlEffBegin");
    org.exolab.castor.types.Date txtDtDtRenwlEffEnd = ContextHelper.getCastorDateSafe(request,"txtDtDtRenwlEffEnd");
    String hdnBIndStageOpen = ContextHelper.getStringSafe(request, "hdnBIndStageOpen");
    
    org.exolab.castor.types.Date birthDatePlus18 = getEndDate(birthDate, 18);
    org.exolab.castor.types.Date birthDatePlus21 = getEndDate(birthDate, 21);

    
    //STGAP00011598 - Non-recurring adoption assistance agreement 
    // cannot be created in open ADO stage. 
    //STGAP00011598 - When a non-recurring adoption assistance agreement is
    // saved in the ADO stage, the adoption must be finalized, otherwise
    // show the user an error message
    if ((CodesTables.CSUBTYPE_22.equals(selSzCdAdptSubDeterm) 
                    || CodesTables.CSUBTYPE_23.equals(selSzCdAdptSubDeterm) 
                    || CodesTables.CSUBTYPE_24.equals(selSzCdAdptSubDeterm) 
                    || CodesTables.CSUBTYPE_25.equals(selSzCdAdptSubDeterm)) &&
                    "ADO".equals(GlobalData.getSzCdStage(request)) && ArchitectureConstants.Y.equals(hdnBIndStageOpen)) {
      setErrorMessage("selSzCdAdptSubDeterm", Messages.MSG_FAD_ADPT_NOT_CONSUM);
    }else if ("ADO".equals(GlobalData.getSzCdStage(request)) && 
        !CodesTables.CLEGSTAT_NAF.equals(szCdLegalStatStatus) && 
          (CodesTables.CSUBTYPE_22.equals(selSzCdAdptSubDeterm) 
          || CodesTables.CSUBTYPE_23.equals(selSzCdAdptSubDeterm) 
          || CodesTables.CSUBTYPE_24.equals(selSzCdAdptSubDeterm) 
          || CodesTables.CSUBTYPE_25.equals(selSzCdAdptSubDeterm))) {
      setErrorMessage("selSzCdAdptSubDeterm", Messages.MSG_FAD_ADPT_NOT_CONSUM);     
    }

    //****************************************
    //*** VARIOUS MULTI-FIELD VALIDATIONS  ***
    //****************************************
    
    // 'Start Date' must be before 'End Date'.
    if (txtDtDtAdptSubEnd != null &&
        txtDtDtAdptSubEffective != null &&
        DateHelper.isBefore(txtDtDtAdptSubEnd, txtDtDtAdptSubEffective)) {
      setErrorMessage("txtDtDtAdptSubEffective", Messages.MSG_AGMT_START_BEFORE_SAME_END);
    }
    
    //User attempts to Save Adoption Assistance Agreement with an approval date when no start and end dates have been entered
    if(txtDtDtAdptSubApprvd != null) {
      if(txtDtDtAdptSubEffective == null) {
        setErrorMessage("txtDtDtAdptSubEffective", Messages.MSG_AGMT_START_END_REQD);
      }
      
      if(txtDtDtAdptSubEnd == null) {
        setErrorMessage("txtDtDtAdptSubEnd", Messages.MSG_AGMT_START_END_REQD);
      }
    }
    
    //User tries to save an adoption assistance where the end date is after the 18 year old birthday 
    //but before the 21st and School Enrollment Verification is not checked
    if(txtDtDtAdptSubEnd != null) {
      boolean schoolEnrollVerNotCheck = ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "cbxCIndAdptSchoolVerified"));
      if (DateHelper.isAfter(txtDtDtAdptSubEnd, birthDatePlus18) && DateHelper.isBefore(txtDtDtAdptSubEnd, birthDatePlus21) && schoolEnrollVerNotCheck == false) {
        setErrorMessage("cbxCIndAdptSchoolVerified", Messages.MSG_ADO_SCHOOL_VER_REQ);
      }   
    }
    
   
    // STGAP00013779: The end date cannot be after the end of the month in which the child turns 21.
    if (selSzCdAdptSubDeterm.equals(CodesTables.CSUBTYPE_07) ||
        selSzCdAdptSubDeterm.equals(CodesTables.CSUBTYPE_09)) {
      if(txtDtDtAdptSubEnd != null){
        if (DateHelper.isAfter(txtDtDtAdptSubEnd, birthDatePlus21)) {
          setErrorMessage("txtDtDtAdptSubEnd", Messages.SSM_END_AFTER_21);
        }
      }
    } 
    
    //STGAP00013779: If adoption assistance type is Title IV-E Fin Asst and Medicaid OR 
    // Title IV-E Fin Asst Only AND the end date is past the month the child turns 18.
    if (selSzCdAdptSubDeterm.equals(CodesTables.CSUBTYPE_01) || selSzCdAdptSubDeterm.equals(CodesTables.CSUBTYPE_03)) {
      if(txtDtDtAdptSubEnd != null){
        if (DateHelper.isAfter(txtDtDtAdptSubEnd, birthDatePlus18)) {
          setErrorMessage("txtDtDtAdptSubEnd", Messages.SSM_END_AFTER_18);
        }
      }
    }
    
    //STGAP00013779:  If Date Approved is not entered 
    if (txtDtDtAdptSubApprvd == null && !"".equals(adoptType))
     {
        setErrorMessage("txtDtDtAdptSubApprvd", Messages.MSG_ADPT_SUB_DETAIL_INCOMPLETE);
     }
    
    // STGAP00013779: Agreement 'End' date cannot be after contract term date

    if (hdnDtDtCnperTerm != null &&
        txtDtDtAdptSubEnd != null  &&
        DateHelper.isAfter(txtDtDtAdptSubEnd, hdnDtDtCnperTerm)) {
      setErrorMessage("txtDtDtAdptSubEnd", Messages.SSM_END_AFTER_CONTRACT);
    }
    
  // 37374: To terminate Agreement both Term Date and Reason are needed
    if (txtDtDtAdptSubTerm != null) {
      if (txtSzCdAdptSubCloseRsn == null || StringHelper.EMPTY_STRING.equals(txtSzCdAdptSubCloseRsn)) {
        setErrorMessage(Messages.MSG_TERM_DATE_PAY_RSN_REQ);
      }
    }
    
    if ((!StringHelper.EMPTY_STRING.equals(txtSzCdAdptSubCloseRsn)) && (txtSzCdAdptSubCloseRsn != null)) {
      txtSzCdAdptSubCloseRsn = txtSzCdAdptSubCloseRsn.trim();
      if (txtSzCdAdptSubCloseRsn.length() >= 0) {
        if (txtDtDtAdptSubTerm == null) {
          setErrorMessage(Messages.MSG_TERM_DATE_PAY_RSN_REQ);
        }
      }
    }
    
    //STGAP00013779: Special Services Adoption Assistance Agreements Start and End dates must fall within 
    //the Approval period of the associated Special Services Adoption Assistance Application.
    if((adoptType.equals(CodesTables.CSUBTYPE_10) || adoptType.equals(CodesTables.CSUBTYPE_18) ||
       adoptType.equals(CodesTables.CSUBTYPE_21) || adoptType.equals(CodesTables.CSUBTYPE_28) ||
       adoptType.equals(CodesTables.CSUBTYPE_29) || adoptType.equals(CodesTables.CSUBTYPE_30)) &&
       (DateHelper.isBefore(txtDtDtAdptSubEffective, txtDtDtRenwlEffBegin))){
       setErrorMessage("txtDtDtAdptSubEffective", Messages.MSG_AGMT_DATES_WITHIN_APPR_DATES);    
    }
    
    //STGAP00013779: Special Services Adoption Assistance Agreements Start and End dates must fall within 
    //the Approval period of the associated Special Services Adoption Assistance Application.
    if((adoptType.equals(CodesTables.CSUBTYPE_10) || adoptType.equals(CodesTables.CSUBTYPE_18) ||
       adoptType.equals(CodesTables.CSUBTYPE_21) || adoptType.equals(CodesTables.CSUBTYPE_28) ||
       adoptType.equals(CodesTables.CSUBTYPE_29) || adoptType.equals(CodesTables.CSUBTYPE_30)) &&
       (DateHelper.isAfter(txtDtDtAdptSubEnd, txtDtDtRenwlEffEnd))){
       setErrorMessage("txtDtDtAdptSubEnd", Messages.MSG_AGMT_DATES_WITHIN_APPR_DATES);    
    }
    
    //STGAP00014031: Please Specify a Payment Method when saving a Special Service or Non-Recurring Agreement. 
    //STGAP00014114 : Added check for 01.03,07,09 also
    if((adoptType.equals(CodesTables.CSUBTYPE_10) || adoptType.equals(CodesTables.CSUBTYPE_18) ||
       adoptType.equals(CodesTables.CSUBTYPE_21) || adoptType.equals(CodesTables.CSUBTYPE_28) ||
       adoptType.equals(CodesTables.CSUBTYPE_29) || adoptType.equals(CodesTables.CSUBTYPE_30) ||
       adoptType.equals(CodesTables.CSUBTYPE_22) || adoptType.equals(CodesTables.CSUBTYPE_23) ||
       adoptType.equals(CodesTables.CSUBTYPE_24) || adoptType.equals(CodesTables.CSUBTYPE_25)||
       adoptType.equals(CodesTables.CSUBTYPE_01) || adoptType.equals(CodesTables.CSUBTYPE_03) ||
       adoptType.equals(CodesTables.CSUBTYPE_07) || adoptType.equals(CodesTables.CSUBTYPE_09)) &&
       (StringHelper.EMPTY_STRING.equals(txtSzCdPaymentMethod))){
       setErrorMessage("txtSzCdPaymentMethod", Messages.MSG_AGMT_PAYMENT_MTHD_REQD);    
    }
    
    performanceTrace.exitScope();
  }
  
  /**
   * <p>This method contains custom validation that is checked when the user saves a new adoption assistance and
   * the event status is COMP.</p>
   *
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  protected void validateFormForComplete() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateFormForComplete()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = super.getRequest();
    String txtSzCdAdptSubCloseRsn = ContextHelper.getStringSafe(request, "txtSzCdAdptSubCloseRsn");
    org.exolab.castor.types.Date txtDtDtAdptSubTerm = ContextHelper.getCastorDateSafe(request, "txtDtDtAdptSubTerminated");
    
  // 37374: To terminate Agreement both Term Date and Reason are needed
    if (txtDtDtAdptSubTerm != null) {
      if (txtSzCdAdptSubCloseRsn == null || StringHelper.EMPTY_STRING.equals(txtSzCdAdptSubCloseRsn)) {
        setErrorMessage(Messages.MSG_TERM_DATE_PAY_RSN_REQ);
      }
    }
    
    if ((!StringHelper.EMPTY_STRING.equals(txtSzCdAdptSubCloseRsn)) && (txtSzCdAdptSubCloseRsn != null)) {
      txtSzCdAdptSubCloseRsn = txtSzCdAdptSubCloseRsn.trim();
      if (txtSzCdAdptSubCloseRsn.length() >= 0) {
        if (txtDtDtAdptSubTerm == null) {
          setErrorMessage(Messages.MSG_TERM_DATE_PAY_RSN_REQ);
        }
      }
    }
    
    performanceTrace.exitScope();
  }
  
  /**
   * Calculates the date of the last day of the month of "yearsLater" years after the "startDate".
   *
   * @param startDate  date to calculate from (usually Date of Birth)
   * @param yearsLater number of years later
   * @return date years after the start date, but the day of month is the last day of the month
   */
  public static org.exolab.castor.types.Date getEndDate(org.exolab.castor.types.Date startDate, int yearsLater) {
    // the algorithm:
    // 1) make a copy of the date
    // 2) set the day to the first day of the month
    // 3) add the yearsLater to the years
    // 4) add 1 to the month, to make it the first day of the next month
    // 5) subtract one from the day to make it the LAST day of the startDate's month
    if (startDate == null) {
      throw new NullPointerException("you need to pass a valid start date to getEndDate");
    }
    org.exolab.castor.types.Date endDate = new org.exolab.castor.types.Date();
    endDate.setValues(startDate.getValues());

    endDate.setDay((short) 1);

    // do not combine these calls... order of operations is important
    endDate = DateHelper.addToDate(endDate, yearsLater, 1, 0); // add to the year and one to the month
    endDate = DateHelper.addToDate(endDate, 0, 0, -1); // subtract one from the day

    return endDate;
  }

  public static final String EVENT_STATUS_COMP = "COMP";
  public static final String EVENT_STATUS_PROC = "PROC";

  public static final String SAVE_BUTTON = "btnSave";
  public static final String COMPLETE_BUTTON = "btnCompletionCheck";
  public static final String TRACE_TAG = "AdoptionAsstncCustomValidation";
}
