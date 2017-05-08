package gov.georgia.dhr.dfcs.sacwis.web.resource;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ValidationPatternMatcher;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to validate parameters entered on the Address Detail page. this is used in BOTH RESOURCE AND FAD.
 *
 * @author Carina Gerry
 * @version 1.0 May 11, 2004 SIR 16091 - added custom validation to the vendor id field
 *          <p/>
 *          Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- 9/27/2004 gerryc       SIR 23166 - added vendor id edits back
 *          in.  now use a dummy vendor id - 99999999999999 - so that if the user enters that, the validation will
 *          automatically pass.  this is because the users hadn't received the vendor ids when they were saving this
 *          page.
 */
public class AddressDetailCustomValidation extends FormValidation {
  /**
   * This method performs custom validation on the data submitted on the Address Detail Page
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
        !vendorID.equals(dummyVendorID)) {
      /* Following validations are removed as its not applicable to SHINES*/
      
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
              "AddressDetail");*/

      //The Vendor ID type (first character) must be 1, 2, or 3.
      /*if (checkType(vendorID, matcher) == false) {
        setErrorMessage("txtNbrRsrcAddrVid", Messages.MSG_FIN_VID_TYPE);
        isValid = false;
      }*/

      //The Vendor ID mail code is invalid. The last three characters should be
      //all numeric, uppercase letter followed by two numbers, PR1, or PR2.
      /*if (checkMailCode(vendorID, matcher) == false) {
        setErrorMessage("txtNbrRsrcAddrVid", Messages.MSG_FIN_VID_MAIL_CODE);
        isValid = false;
      }*/

      //The Vendor ID check-digit is invalid. Please double check the Vendor ID.
      /*if (checkCheckDigit(vendorID) == false) {
        setErrorMessage("txtNbrRsrcAddrVid", Messages.MSG_FIN_VID_CHK_DIGIT);
        isValid = false;
      }*/
    }//ending the check to see if vendorID wasn't blank

    performanceTrace.getTotalTime();
    performanceTrace.exitScope("result is " + isValid);
    return isValid;
  }

  /**
   * public method used in Add Resource, Add F/A Home, F/A Home Address Detail, and Resource Address Detail pages.
   * Checks to see if the first digit is a 1, 2, or 3
   *
   * @param vendorID vendor ID
   * @param matcher  regular expression tool
   * @return boolean
   */
  public static boolean checkType(String vendorID, ValidationPatternMatcher matcher) {
    boolean typeValid = true;
    //The type (digit 1) must be 1, 2, or 3.
    String typeDigit = vendorID.substring(0, 1);
    if (matcher.match("/[123]/", typeDigit) == false) {
      typeValid = false;
    }
    return typeValid;
  }

  /**
   * public method used in Add Resource, Add F/A Home, F/A Home Address Detail, and Resource Address Detail pages.
   * checks to see if the mail code (last three digits) are in a valid format
   *
   * @param vendorID vendor ID
   * @param matcher  regular expression tool
   * @return boolean
   */
  public static boolean checkMailCode(String vendorID, ValidationPatternMatcher matcher) {
    boolean mailCodeValid = true;
    //check the mail code (digits 12, 13 and 14)
    String mailCode = vendorID.substring(11, 14);

    // check to see if it's all numeric
    // check to see if it's capital A-Z, number, number
    // check if it's PR1 or PR2
    if (matcher.match("/(\\d{3}|([A-Z]{1}\\d{2})|PR1|PR2)/", mailCode) == false) {
      mailCodeValid = false;
    }
    return mailCodeValid;
  }

  /**
   * public method used in Add Resource, Add F/A Home, F/A Home Address Detail, and Resource Address Detail pages. uses
   * calculation function to check the 11th digit to prevent user entry errors.
   *
   * @param vendorID vendor ID
   * @return boolean
   */
  public static boolean checkCheckDigit(String vendorID) {
    boolean checkDigitValid = true;
    //make sure that the check digit (digit 11) matches the calculated digit
    Integer checkDigit = new Integer(vendorID.substring(10, 11));
    Integer calculatedCheckDigit = pinCheck(vendorID);
    if (checkDigit.equals(calculatedCheckDigit) == false) {
      checkDigitValid = false;
    }
    return checkDigitValid;
  }

  /**
   * private method that takes the vendor id, and calculates the check digit, which is then compared to the 11th digit
   * of the vendor id.  This is to avoid transposition errors in the vendor ID.  This logic was taken from the batch
   * process for vendor id validation.
   *
   * @param String vendorID
   * @return Integer calculated check digit
   */
  private static Integer pinCheck(String vendorID) {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "pinCheck()");
    // start the method trace
    performanceTrace.enterScope();

    //declare variables
    int intDigitSum = 0;
    int intEvenProduct = 0;
    int pinCheck = 0;
    int leftDigit = 0;
    int rightDigit = 0;
    String strEvenProduct = "";
    String strDigitSum = "";

    //loops through odd digits of vendor id
    for (int odd = 1; odd < 10; odd = 2 + odd) {
      //add the odd digit to the previously calculated sum
      intDigitSum = intDigitSum + Integer.parseInt(vendorID.substring(odd - 1, odd));
    }

    //loops through even digits of vendor id
    for (int even = 2; even < 11; even = 2 + even) {
      //calculate the even digit * 2
      intEvenProduct = Integer.parseInt(vendorID.substring(even - 1, even)) * 2;
      if (intEvenProduct > 9) {
        //if the even digit is greater than 9, split it up into 2 numbers
        strEvenProduct = new Integer(intEvenProduct).toString();
        leftDigit = Integer.parseInt(strEvenProduct.substring(0, 1));
        rightDigit = Integer.parseInt(strEvenProduct.substring(1, 2));
        //add the new numbers to the previously calculted sum
        intDigitSum = intDigitSum + leftDigit + rightDigit;
      } else {
        //add the even product to the previously calculated sum
        intDigitSum = intDigitSum + intEvenProduct;
      }
    }

    //find the right most digit (strDigitSum will only be 2 digits)
    strDigitSum = new Integer(intDigitSum).toString();
    if ("0".equals(strDigitSum.substring(1, 2))) {
      pinCheck = 0;
    } else {
      pinCheck = 10 - Integer.parseInt(strDigitSum.substring(1, 2));
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope("pinCheck is " + pinCheck);
    return (pinCheck);
  }

  // static constants
  public static final String TRACE_TAG = "AddressDetailCustomValidation";
  public static final String dummyVendorID = "99999999";

}





