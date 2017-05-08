package gov.georgia.dhr.dfcs.sacwis.web.fad;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ValidationPatternMatcher;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.resource.AddressDetailCustomValidation;

/**
 * NewHomeInfrmtn.jsp Custom validation class <p>Description:  Custom Validation for NewHomeInfrmtn.jsp </p>
 * <p>Copyright: Copyright (c) 2003</p> <p>Company: TDPRS</p>
 *
 * @author J. Heather Dean
 * @version 1.0
 *          <p/>
 *          * Change History: Date      User         Description --------  -----------
 *          ---------------------------------------------- ochumd       sir#18824 - no age range validation required
 *          10/13/03  dickmaec     SIR 19857 -- ContextHelper.get... replaces getInputValue(); 10/14/03  dickmaec     As
 *          part of SIR 19857, all messages where shorted form MessageLookup.getMessageByNumber(
 *          Messages.SSM_FAD_MIN_LESS_MAX) to Messages.SSM_FAD_MIN_LESS_MAX. 5/26/2004 gerryc       SIR 16502 - removed
 *          custom validation relating to non-fps adoptive homes.  This checkbox was taken off of the new home page, so
 *          it is not needed here anymore. 6/16/2004 gerryc       SIR 16091 - added validation for the vendor ID fields.
 *          9/3/2004  gerryc       SIR 23137 - back out vendor id validation from SIR 16091 9/27/2004 gerryc       SIR
 *          23166 - added vendor id edits back in.  now use a dummy vendor id - 99999999999999 - so that if the user
 *          enters that, the validation will automatically pass.  this is because the users hadn't received the vendor
 *          ids when they were saving this page.
 *          03/31/11 hnguyen       SMS#97850: MR-075 Corrected error message for home interest female age range.
 *          11/10/11 cwells STGAP00017640 : ECEM 5.0 updating logic to evaluate newly added child characteristics
 */

public class NewHomeCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "NewHomeCustomValidation";

  public static final int MAX_CAPACITY = 9999;

  protected boolean validateForm() {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    boolean result = true;

    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());
    org.exolab.castor.types.Date marriageDate = ContextHelper.getCastorDateSafe(request, "marriageDate");
    String maritalStatus = ContextHelper.getStringSafe(request, "selMaritalStatus");

    if (marriageDate != null && DateHelper.isAfter(marriageDate, today)) {
      setErrorMessage(MessageLookup.getMessageByNumber(Messages.SSM_FAD_MARRIAGE_DATE));
      result = false;
    }

    if ("01".equals(maritalStatus) && marriageDate == null) {
      setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_FAD_NO_MARRIAGE));
      result = false;
    }

    int femaleMinMonth = ContextHelper.getIntSafe(request, "selFemaleMinMonthInt");
    int femaleMinYear = ContextHelper.getIntSafe(request, "selFemaleMinYearInt");
    int femaleMinAgeInMonths = (femaleMinYear * 12) + femaleMinMonth;
    int femaleMaxMonth = ContextHelper.getIntSafe(request, "selFemaleMaxMonthInt");
    int femaleMaxYear = ContextHelper.getIntSafe(request, "selFemaleMaxYearInt");
    int femaleMaxAgeInMonths = (femaleMaxYear * 12) + femaleMaxMonth;
    int maleMinMonth = ContextHelper.getIntSafe(request, "selMaleMinMonthInt");
    int maleMinYear = ContextHelper.getIntSafe(request, "selMaleMinYearInt");
    int maleMinAgeInMonths = (maleMinYear * 12) + maleMinMonth;
    int maleMaxMonth = ContextHelper.getIntSafe(request, "selMaleMaxMonthInt");
    int maleMaxYear = ContextHelper.getIntSafe(request, "selMaleMaxYearInt");
    int maleMaxAgeInMonths = (maleMaxYear * 12) + maleMaxMonth;
    String primaryVendorID = ContextHelper.getStringSafe(request, "txtNbrRsrcAddrVid");
    String busVendorID = ContextHelper.getStringSafe(request, "txtNbrRsrcAddrVidB");

    this.getState().setAttribute("isReload", "true", request);

    if (maleMinAgeInMonths != 0 && maleMaxAgeInMonths == 0) {
      setErrorMessage("selMaleMaxYearInt", Messages.MSG_MIN_MALE_RANGE_INTEREST);
      result = false;
    } else if (maleMinAgeInMonths == 0 && maleMaxAgeInMonths != 0) {
      setErrorMessage("selMaleMinYearInt", Messages.MSG_MAX_MALE_RANGE_INTEREST);
      result = false;
    } else if (maleMinAgeInMonths > maleMaxAgeInMonths) {
      setErrorMessage("selMaleMinYearInt", Messages.SSM_FAD_MIN_LESS_MAX);
      result = false;
    }

    if (femaleMinAgeInMonths != 0 && femaleMaxAgeInMonths == 0) {
      setErrorMessage("selFemaleMaxYearInt", Messages.MSG_MIN_FEMALE_RANGE_INTEREST);
      result = false;
    } else if (femaleMinAgeInMonths == 0 && femaleMaxAgeInMonths != 0) {
      setErrorMessage("selFemaleMinYearInt", Messages.MSG_MAX_FEMALE_RANGE_INTEREST);
      result = false;
    } else if (femaleMinAgeInMonths > femaleMaxAgeInMonths) {
      setErrorMessage("selFemaleMinYearInt", Messages.SSM_FAD_MIN_LESS_MAX);
      result = false;
    }

    if (femaleMinAgeInMonths > femaleMaxAgeInMonths) {
      setErrorMessage("selFemaleMinYearInt", Messages.SSM_FAD_MIN_LESS_MAX);
      result = false;
    }

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

    ValidationPatternMatcher matcher = ValidationPatternMatcher.getInstance("NewHomeInfrmtn");

    //primary address check
    //only perform edits on Vendor ID if it is not empty
   /* if (StringHelper.EMPTY_STRING.equals(primaryVendorID) == false
        && !primaryVendorID.equals(AddressDetailCustomValidation.dummyVendorID)) {
      //The Vendor ID type (first character) must be 1, 2, or 3.
      if (!(AddressDetailCustomValidation.checkType(primaryVendorID, matcher))) {
        setErrorMessage("txtNbrRsrcAddrVid", Messages.MSG_FIN_VID_TYPE);
        result = false;
      }

      //The Vendor ID mail code is invalid. The last three characters should be
      //all numeric, uppercase letter followed by two numbers, PR1, or PR2.
      if (!(AddressDetailCustomValidation.checkMailCode(primaryVendorID, matcher))) {
        setErrorMessage("txtNbrRsrcAddrVid", Messages.MSG_FIN_VID_MAIL_CODE);
        result = false;
      }

      //The Vendor ID check-digit is invalid. Please double check the Vendor ID.
      if (!(AddressDetailCustomValidation.checkCheckDigit(primaryVendorID))) {
        setErrorMessage("txtNbrRsrcAddrVid", Messages.MSG_FIN_VID_CHK_DIGIT);
        result = false;
      }
    }//ending the check to see if vendorID wasn't blank

    //business address vendor ID
    //only perform edits on Vendor ID if it is not empty
    if (!(StringHelper.EMPTY_STRING.equals(busVendorID))
        && !busVendorID.equals(AddressDetailCustomValidation.dummyVendorID)) {

      //The Vendor ID type (first character) must be 1, 2, or 3.
      if (!(AddressDetailCustomValidation.checkType(busVendorID, matcher))) {
        setErrorMessage("txtNbrRsrcAddrVidB", Messages.MSG_FIN_VID_TYPE);
        result = false;
      }

      //The Vendor ID mail code is invalid. The last three characters should be
      //all numeric, uppercase letter followed by two numbers, PR1, or PR2.
      if (!(AddressDetailCustomValidation.checkMailCode(busVendorID, matcher))) {
        setErrorMessage("txtNbrRsrcAddrVidB", Messages.MSG_FIN_VID_MAIL_CODE);
        result = false;
      }

      //The Vendor ID check-digit is invalid. Please double check the Vendor ID.
      if (!(AddressDetailCustomValidation.checkCheckDigit(busVendorID))) {
        setErrorMessage("txtNbrRsrcAddrVidB", Messages.MSG_FIN_VID_CHK_DIGIT);
        result = false;
      }
    } *///ending the check to see if vendorID wasn't blank

    performanceTrace.exitScope();
    return result;
  }

  public static boolean hasEthnicity(HttpServletRequest request) {
    try {
      int iCount = 1;
      // Get all child char from the codestable.
      Collection childCharCollection = Lookup.getCategoryCollection(CodesTables.CETHNIC);
      Iterator childCharIterator = childCharCollection.iterator();
      while (childCharIterator.hasNext()) {
        childCharIterator.next();
        String cbName = "EthCbx";
        cbName = cbName + iCount;
        iCount++;
        cbName = ContextHelper.getStringSafe(request, cbName);
        if (cbName != null && cbName != "") {
          return true;
        }
      }
      return false;
    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }
  }

  
  //  STGAP00017640 : ECEM 5.0 updating logic to evaluate newly added child characteristics
  public static boolean hasChildChar(HttpServletRequest request) {
    try {
      int iCount = 1;
      // Get all child char from the codestable.
      List<CodeAttributes> characteristicsCategories = Lookup.getCategoryCollection(CodesTables.CCHRTCA2);
	 Iterator characteristicsCategoryIterator = characteristicsCategories.iterator();
	 
     while(characteristicsCategoryIterator.hasNext()){
    	 CodeAttributes charCatCodeAtt = (CodeAttributes)characteristicsCategoryIterator.next();
    	 
         String catCode = charCatCodeAtt.getCode();
         
         int loopCount = 1;
         List<CodeAttributes> characteristics = Lookup.getCategoryCollection(catCode);
         Iterator characteristicsIterator = characteristics.iterator();
         while(characteristicsIterator.hasNext()){
              CodeAttributes charCodeAtt = (CodeAttributes)characteristicsIterator.next();
              String charCode = charCodeAtt.getCode();         
              String cbName = "CharCbx" + catCode + loopCount; 
              loopCount ++;
              cbName = ContextHelper.getStringSafe(request, cbName);
              if (cbName != null && cbName != "") {
                  return true;
                }
         }

     }
      
      return false;
    } catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }
  }

}
