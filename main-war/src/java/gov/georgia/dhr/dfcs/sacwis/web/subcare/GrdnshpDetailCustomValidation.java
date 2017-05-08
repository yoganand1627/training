//GrdnshpDetailCustonValidation
package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import org.exolab.castor.types.Date;

/**
 * Performs custom validation for Guardianship Detail.
 *
 * @author Merle A. Demo
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 10/14/03  dejuanr      SIR 19857 -- No changes needed 10/14/03
 *          CORLEYAN     SIR 19857 -- ContextHelper.get... replaces getInputValue(), removed
 *         InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup.
 */
public class GrdnshpDetailCustomValidation extends FormValidation {

  /**
   * Validate for GrdnshpDetail.
   *
   * @return Returns true if there are no validation errors
   */
  protected boolean validateForm() {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    //BaseSessionStateManager state = super.getState();

    boolean result = true;

    // Date fields
    Date dtOrded = ContextHelper.getCastorDateSafe(request, "dtDtGuardOrdered");
    Date dtLetters = ContextHelper.getCastorDateSafe(request, "dtDtGuardLettersIssued");
    Date dtClose = ContextHelper.getCastorDateSafe(request, "dtDtGuardCloseDate");

    String cdGuardType = ContextHelper.getStringSafe(request, "selCdGuardGuardianType");
    String cdGuardianType = ContextHelper.getStringSafe(request, "selCdGuardType");
    String sdsGuardName = ContextHelper.getStringSafe(request, "txtSdsGuardName");
    String cdCloseReason = ContextHelper.getStringSafe(request, "selCdGuardCloseReason");

    //Try to make a date object out of the input and set error if its not valid

    // check to see if date ordered is valid
    if (DateHelper.isValidDate(dtOrded.toString())) {
      setErrorMessage("dtDtGuardOrdered", Messages.MSG_ARC_CONSTR_DATE);
      result = false;
    }

    // Check to see if date is not valid or can be be null
    if (DateHelper.isValidDate(dtLetters.toString())) {
      setErrorMessage("dtDtGuardLettersIssued", Messages.MSG_ARC_CONSTR_DATE);
      result = false;
    }

    if (DateHelper.isValidDate(dtClose.toString())) {
      setErrorMessage("dtDtGuardCloseDate", Messages.MSG_ARC_CONSTR_DATE);
      result = false;
    }

    if (!(cdCloseReason.equals(CodesTables.CGARCLOS_REC) || "".equals(cdCloseReason))) {
      if (dtLetters == null) {
        setErrorMessage("dtDtGuardLettersIssued", Messages.MSG_LTRS_ISSUED_DATE);
        result = false;
      }
    }
    //Future date for guard orded, letters issued and guard closed
    if (dtLetters != null && DateHelper.isAfterToday(dtOrded)) {
      setErrorMessage("dtDtGuardOrdered", Messages.SSM_DATE_BEFORE_SAME_CURR);
      result = false;
    }
    if (dtLetters != null && DateHelper.isAfterToday(dtLetters)) {
      setErrorMessage("dtDtGuardLettersIssued", Messages.SSM_DATE_BEFORE_SAME_CURR);
      result = false;
    }
    if (dtClose != null && DateHelper.isAfterToday(dtClose)) {
      setErrorMessage("dtDtGuardCloseDate", Messages.SSM_DATE_BEFORE_SAME_CURR);
      result = false;
    }
    //validate the first four fields
    if ("".equals(sdsGuardName)) {
      setErrorMessage("txtSdsGuardName", Messages.SSM_COMPLETE_REQUIRED);
      result = false;
    }
    if ("".equals(cdGuardType)) {
      setErrorMessage("selCdGuardGuardianType", Messages.SSM_COMPLETE_REQUIRED);
      result = false;
    }
    if (dtOrded == null) {
      setErrorMessage("dtDtGuardOrdered", Messages.SSM_COMPLETE_REQUIRED);
      result = false;
    }
    if ("".equals(cdGuardianType)) {
      setErrorMessage("selCdGuardType", Messages.SSM_COMPLETE_REQUIRED);
      result = false;
    }

    if ("".equals(cdCloseReason) && dtClose != null) {
      setErrorMessage("selCdGuardCloseReason", Messages.MSG_CLO_REASON);
      result = false;
    }

    if (!"".equals(cdCloseReason) && dtClose == null) {
      setErrorMessage("dtDtGuardCloseDate", Messages.MSG_CLO_DTE);
      result = false;
    }

    if (dtLetters.toDate().before(dtOrded.toDate())) {
      if (!CodesTables.CGARCLOS_REC.equals(cdCloseReason)) {
        setErrorMessage("dtDtGuardLettersIssued", Messages.SSM_SUB_ISSUED_LESS_ORD);
        result = false;
      }
    }

    if (dtClose.toDate().before(dtOrded.toDate())) {
      setErrorMessage("dtDtGuardCloseDate", Messages.SSM_SUB_CLOSE_LESS_ISSUED);
      result = false;
    }

    if (!cdCloseReason.equals(CodesTables.CGARCLOS_REC)) {
      if (dtClose.toDate().before(dtLetters.toDate())) {
        setErrorMessage("dtDtGuardCloseDate", Messages.SSM_SUB_CLOSE_LESS_ISSUED);
        result = false;
      }
    }

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! " + result);
    performanceTrace.exitScope();

    return result;
  }

  /**
   * ***************************************************************************** *  Declare any static constants.
   * ******************************************************************************
   */
// static constants
  public static final String TRACE_TAG = "GrdnshpDetailCustomValidation";
  public static final String PERSON_TYPE = "OT1";
  public static final String DESTURL_PERSON = "/subcare/GrdnshpDetail/setPerson_GrdnshpDetail";
  public static final String DESTURL_RESOURCE = "/subcare/GrdnshpDetail/setResource_GrdnshpDetail";
  public static final String GRDNSHP_DETAIL_PAGE = "/subcare/GrdnshpDetail/displayGrdnshpDetail";
}
