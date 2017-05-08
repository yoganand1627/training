package gov.georgia.dhr.dfcs.sacwis.web.resource;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ValidationPatternMatcher;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate parameters entered on the Add Resource page.
 *
 * @author Carina Gerry, June 16, 2004 SIR 16091 - added custom validation to the vendor id field
 *         <p/>
 *         Change History: Date      User         Description --------  -----------
 *         ---------------------------------------------- 9/27/2004 gerryc       SIR 23166 - added vendor id edits back
 *         in.  now use a dummy vendor id - 99999999999999 - so that if the user enters that, the validation will
 *         automatically pass.  this is because the users hadn't received the vendor ids when they were saving this
 *         page.
 */
public class AddResourceCustomValidation extends FormValidation {
  /**
   * This method performs custom validation on the data submitted on the Add Resource Page
   *
   * @return <code>true</code> if the form data is valid; <code>false</code> otherwise.
   */
  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validateForm()");
    // start the method trace
    performanceTrace.enterScope();

    HttpServletRequest request = this.getRequest();

    boolean isValid = true;
    String vendorID = ContextHelper.getStringSafe(request, "txtNbrRsrcAddrVid");

    //only perform edits on Vendor ID if it is not empty
    if (StringHelper.EMPTY_STRING.equals(vendorID) == false &&
        !vendorID.equals(AddressDetailCustomValidation.dummyVendorID)) {
      /*
        Vendor ID must meet the following characteristics in the Invoice
        Validation batch process, and therefore also in this file.
        1) Vendor ID is 14 digits. (taken care of by VendorID constraint)
        2) The type (digit 1) must be equal to "1", "2" or "3".
        3) The check-digit (digit 11) is valid.
        4) The mail code (digits 12, 13 and 14) must be one of the following:
          a) All numeric, or
          b) First digit is upper-case A - Z and digits two and three are numeric, or
          c) Value is either "PR1" or "PR2".
        5) Digits one through eleven must be numeric. (taken care of by
           VendorID constraint)
      */

      /*ValidationPatternMatcher matcher = ValidationPatternMatcher.getInstance(
              "AddResource");*/

      //The Vendor ID type (first character) must be 1, 2, or 3.
      /*if (AddressDetailCustomValidation.checkType(vendorID, matcher) == false) {
        setErrorMessage("txtNbrRsrcAddrVid", Messages.MSG_FIN_VID_TYPE);
        isValid = false;
      }*/

      //The Vendor ID mail code is invalid. The last three characters should be
      //all numeric, uppercase letter followed by two numbers, PR1, or PR2.
      /*if (AddressDetailCustomValidation.checkMailCode(vendorID, matcher) == false) {
        setErrorMessage("txtNbrRsrcAddrVid", Messages.MSG_FIN_VID_MAIL_CODE);
        isValid = false;
      }*/

      //The Vendor ID check-digit is invalid. Please double check the Vendor ID.
      /*if (AddressDetailCustomValidation.checkCheckDigit(vendorID) == false) {
        setErrorMessage("txtNbrRsrcAddrVid", Messages.MSG_FIN_VID_CHK_DIGIT);
        isValid = false;
      }*/
    }//ending the check to see if vendorID wasn't blank

    performanceTrace.getTotalTime();
    performanceTrace.exitScope("result is " + isValid);
    return isValid;
  }

  // static constants
  public static final String TRACE_TAG = "AddResourceCustomValidation";

}





