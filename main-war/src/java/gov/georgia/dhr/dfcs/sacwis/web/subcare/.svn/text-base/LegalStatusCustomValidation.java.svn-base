package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is used to perform the custom validation on Legal Status when the user attempts Save.
 *
 * @author Carolyn Douglass 2/20/03 <p/> Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 10/14/03 dejuanr SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue();
 */

/**
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/21/2009  bgehlot         STGAP00014336 : MR-51 changes Added validations   
 * 09/24/2009  bgehlot         STGAP00015351: Removing message MSG_MISSING_PARENT_TPR message from here and putting is in JSP as
 *                             confirmational pop up message
 * 06/29/2010  wjcochran       SMS 60156: When a Legal Status of Temporary Court, Joint Commitment with DJJ - Temporary Court, or 
 *                             Not in DFCS Custody  - Custody to Relative is selected, the Court Order Expiration Date is required.
 * 11/09/2010  htvo            SMS#81140 - MR-074 AFCARS: include the Not In DFCS custody – Out of State Child Adopted by Georgia Family in 
 *                             the error checking for legal county to be Out of State.                            

 * </pre>
 */
@SuppressWarnings("serial")
public class LegalStatusCustomValidation extends FormValidation {
  // static constants
  public static final String TRACE_TAG = "LegalStatusCustomValidation";

  public static final String SAVE_BUTTON = "btnSave";

  /**
   * <p/>
   * This method contains custom validation that is checked when the user tries to Search or Continue. </p>
   *
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG,
                                                             ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    boolean result = true;
    org.exolab.castor.types.Date CrtOrdExpDate = ContextHelper.getCastorDateSafe(request, "txtDtCtOrExp");
    org.exolab.castor.types.Date EffDate = ContextHelper.getCastorDateSafe(request, "txtDtEffLegalStat");
    //STGAP00014336
    String selLegalStat = ContextHelper.getStringSafe(request, "selLegalStat");
    String selCdLegalStatCnty = ContextHelper.getStringSafe(request, "selCdLegalStatCnty");
    

    if (super.isButtonPressed(SAVE_BUTTON)) {
      // Legal Status effective date cannot be after today
      if (DateHelper.isAfterToday(EffDate)) {
        setErrorMessage("txtDtEffLegalStat", Messages.SSM_STATUS_EFFECTIVE);
        result = false;

      }

      // // Court Order Expiration date cannot be before the Status
      // Effective date
      if (DateHelper.isBefore(CrtOrdExpDate, EffDate)) {
        setErrorMessage("txtDtCtOrExp", Messages.MSG_LEG_COURT_ORDER_EXP_BEFORE_EFFECTIV);
        result = false;
      }
      
      //STGAP00014336: User attempts to select "Out of State" from the Legal County drop down when the Legal Status 
      // is any of the "in Georgia custody" legal statuses 
      if((CodesTables.CLEGSTAT_PCT.equals(selLegalStat) || CodesTables.CLEGSTAT_PVL.equals(selLegalStat) ||
          CodesTables.CLEGSTAT_TCT.equals(selLegalStat) || CodesTables.CLEGSTAT_TVL.equals(selLegalStat) ||
          CodesTables.CLEGSTAT_JCP.equals(selLegalStat) || CodesTables.CLEGSTAT_JCT.equals(selLegalStat)) 
          && CodesTables.CCOUNT_999.equals(selCdLegalStatCnty)){
        setErrorMessage("selCdLegalStatCnty", Messages.MSG_OUT_OF_STATE_LEG_CNTY);
        result = false;
      }
      
      //STGAP00014336: User attempts to select Not In DFCS Custody - Custody With Other State as the legal status 
      // without changing the Legal County to Out of State.
      // MR-074 AFCARS: include the Not In DFCS custody – Out of State Child Adopted by Georgia Family in this error check
      if((CodesTables.CLEGSTAT_NCS.equals(selLegalStat) || CodesTables.CLEGSTAT_NOT.equals(selLegalStat)) && !CodesTables.CCOUNT_999.equals(selCdLegalStatCnty)){
        setErrorMessage("selCdLegalStatCnty", Messages.MSG_CUSTODY_WITH_OTHER_STATE);
        result = false;
      }
      
      //SMS 60156: For Legal Status of Temporary Court, Joint Commitment with DJJ - Temporary Court, or 
      // Not in DFCS Custody  - Custody to Relative and if the Court Order Expiration Date is blank,
      // set an error message.
      if ((CodesTables.CLEGSTAT_TCT.equals(selLegalStat) || CodesTables.CLEGSTAT_JCT.equals(selLegalStat) ||
          CodesTables.CLEGSTAT_NPR.equals(selLegalStat)) && DateHelper.isNull(CrtOrdExpDate)) {
        setErrorMessage("txtDtCtOrExp", "This Legal Status requires a Court Order Expiration Date.");
        result=false;
      }

    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }
}