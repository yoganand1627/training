package gov.georgia.dhr.dfcs.sacwis.web.common;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.external.External;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AddressValidatorSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

public class AddressValidationConversation extends BaseHiddenFieldStateConversation {
  //
  // static constants
  //
  private External external;

  public void setExternal(External external) {
    this.external = external;
  }

  private static final String TRACE_TAG = "AddressValidationConversation";
  public static final String ORIGINATING_FORM = "frmWindowName";

  public static final String CORRECT_COUNTY = "correctCounty";
  public static final String ADDRESS_ROW = "addressRow";
  public static final String PARSED_ADDRESS_ROW = "parsedAddressRow";
  public static final String ADDRESS_VALIDATED = "addressValidated";
  public static final String ADDRESS_LIST = "addressList";

  public static final int ARC_CD1_ERR_BASE = 12500;
  public static final int CODE1_ADDRESS_MATCHED = 0;
  public static final int CODE1_ADDRESS_CORRECTED = (ARC_CD1_ERR_BASE + 1);
  public static final int CODE1_ADDRESS_PARSED = (ARC_CD1_ERR_BASE + 2);
  public static final int CODE1_STREET_MISSING = (ARC_CD1_ERR_BASE + 3);
  public static final int CODE1_CITY_MISSING = (ARC_CD1_ERR_BASE + 4);
  public static final int CODE1_STATE_MISSING = (ARC_CD1_ERR_BASE + 5);
  public static final int CODE1_ZIP_MISSING = (ARC_CD1_ERR_BASE + 6);
  public static final int CODE1_ADDRESS_DOUBTFUL = (ARC_CD1_ERR_BASE + 7);
  public static final int CODE1_ADDRESS_MULTIPLE = (ARC_CD1_ERR_BASE + 8);
  public static final int CODE1_INVALID_ZIP = (ARC_CD1_ERR_BASE + 9);
  public static final int CODE1_INVALID_STREET = (ARC_CD1_ERR_BASE + 10);
  public static final int CODE1_APARTMENT_MISSING = (ARC_CD1_ERR_BASE + 11);
  public static final int CODE1_DATABASE_EXPIRED = (ARC_CD1_ERR_BASE + 12);
  public static final int CODE1_INVALID_HOUSE_NBR = (ARC_CD1_ERR_BASE + 13);
  public static final int CODE1_INTERNAL_ERROR = (ARC_CD1_ERR_BASE + 14);

  /**
   * This method is called by the GRNDS controller when the user requests the validation of an address
   *
   * @param context The GrndsExchangeContext object.
   */
  public void validateResourceAddress_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validateResourceAddress_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      String addressSubmoduleName = ContextHelper.getStringSafe(request, AddressBean.ADDRESS_SUBMODULE_NAME);
      request.setAttribute(AddressBean.ADDRESS_SUBMODULE_NAME, addressSubmoduleName);

      AddressValidatorSI addressValidatorSI = populateAddressValidatorSI_Resource(context);
      
      AddressValidatorListSO addressList = external.validateAndOrFind(addressValidatorSI);
      
      request.setAttribute(ADDRESS_LIST, addressList);
      
      AddressValidatorSO addressValidatorSO = external.validate(addressValidatorSI);

      populateRequestFromOutput(context, addressValidatorSO, addressValidatorSI);
    }
    catch (AddressValidationException e) {
      Integer errorCode = e.getMessageNumber();
      String errorMessage = MessageLookup.getMessageByNumber(e.getMessageNumber());
      request.setAttribute("code1error", errorMessage);
      request.setAttribute("code1ErrorCode", errorCode);
    }
    catch (ServiceException e) {
      Integer errorCode = e.getErrorCode();
      String errorMessage = MessageLookup.getMessageByNumber(e.getErrorCode());
      request.setAttribute("code1error", errorMessage);
      request.setAttribute("code1ErrorCode", errorCode);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      e.printStackTrace();
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * This method is called by the GRNDS controller when the user requests the validation of an address from the Address
   * submodule
   *
   * @param context The GrndsExchangeContext object.
   */
  public void validateAddress_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validate_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    try {
      // make sure the address submodule name is populated into the request
      String addressSubmoduleName = ContextHelper.getStringSafe(request, AddressBean.ADDRESS_SUBMODULE_NAME);
      request.setAttribute(AddressBean.ADDRESS_SUBMODULE_NAME, addressSubmoduleName);

      AddressValidatorSI addressValidatorSI = populateAddressValidatorSI(context);
      
      AddressValidatorSO addressValidatorSO = null;
      AddressValidatorListSO addressList = external.validateAndOrFind(addressValidatorSI);
      if(addressList != null && addressList.getVaildAddresses() != null && addressList.getVaildAddresses().size() > 0) {
        request.setAttribute(ADDRESS_LIST, addressList);
        addressValidatorSO = addressList.getVaildAddresses().get(0);
      }

      populateRequestFromOutput(context, addressValidatorSO, addressValidatorSI);

    }
    catch (AddressValidationException e) {
      Integer errorCode = e.getMessageNumber();
      String errorMessage = MessageLookup.getMessageByNumber(e.getMessageNumber());
      request.setAttribute("code1error", errorMessage);
      request.setAttribute("code1ErrorCode", errorCode);
    }
    catch (ServiceException e) {
      Integer errorCode = e.getErrorCode();
      String errorMessage = MessageLookup.getMessageByNumber(e.getErrorCode());
      request.setAttribute("code1error", errorMessage);
      request.setAttribute("code1ErrorCode", errorCode);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      e.printStackTrace();
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private AddressValidatorSI populateAddressValidatorSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateAddressValidatorSI");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    AddressValidatorSI addressValidatorSI = new AddressValidatorSI();
    AddressBean addressBean = null;


    //-- Note that this submodule name should be blank since this code is meant to be called
    //-- via the launchAddressValidate() method of addressValidation.js which adds the
    //-- address values to the URL (request parameters) without using a submodule name.
    String addressSubmoduleName = "";
    if (AddressBean.isInRequest(addressSubmoduleName, request)) {
      addressBean = AddressBean.getFromRequest(request);
    } else {
      addressBean = new AddressBean();
    }


    addressValidatorSI.setAddress1(addressBean.getAddress1());
    addressValidatorSI.setAddress2(addressBean.getAddress2());
    addressValidatorSI.setCity(addressBean.getCity());
    addressValidatorSI.setState(addressBean.getState());
    addressValidatorSI.setZipCode(addressBean.getZip());

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return addressValidatorSI;
  }

  private AddressValidatorSI populateAddressValidatorSI_Resource(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINT15SI_Resource");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    AddressValidatorSI addressValidatorSI = new AddressValidatorSI();

    addressValidatorSI.setAddress1(ContextHelper.getStringSafe(request, "txtSzAddrRsrcAddrStLn1"));
    addressValidatorSI.setAddress2(ContextHelper.getStringSafe(request, "txtSzAddrRsrcAddrStLn2"));
    addressValidatorSI.setCity(ContextHelper.getStringSafe(request, "txtSzAddrRsrcAddrCity"));
    addressValidatorSI.setState(ContextHelper.getStringSafe(request, "selCdFacilityState"));
    addressValidatorSI.setZipCode(ContextHelper.getStringSafe(request, "txtSzAddrRsrcAddrZip"));

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return addressValidatorSI;
  }

  private void populateRequestFromOutput(GrndsExchangeContext context, AddressValidatorSO addressValidatorSO,
                                         AddressValidatorSI addressValidatorSI)
          throws AddressValidationException, Exception {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateRequestFromOutput");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    String errorMessage = "";
    boolean addressValidated = false;
    CityCountyStruct county = null;
    
    AddressValidatorSO parsedAddress = new AddressValidatorSO();
    AddressValidatorSO validatedAddress = new AddressValidatorSO();

    //check if addressValidatorSI has any value for street2
    //if it does add it to addressValidatorSO
    //if address is an out of state address replace 
    //the county code with out of state
    //fixes SIRS 787 and 1110
    if (addressValidatorSO != null) {
      if (addressValidatorSI.getAddress2() != null || addressValidatorSI.getAddress2() != "") {
        addressValidatorSO.setStreet2(addressValidatorSI.getAddress2().toUpperCase());
      }

      if (!(addressValidatorSO.getState().equalsIgnoreCase("GA") || addressValidatorSO.getState().equalsIgnoreCase(
              "Georgia"))) {
        addressValidatorSO.setCountyCode("999");
      }

      if (addressValidatorSO.isValidated()) {
        addressValidated = true;
      }

      parsedAddress = addressValidatorSO;
      validatedAddress = addressValidatorSO;
    }

    boolean bMultCounty = ContextHelper.getBooleanSafe(request, AddressBean.MULT_COUNTY);
    String existingCounty = ContextHelper.getStringSafe(request, AddressBean.COUNTY);
    existingCounty = "".equals(existingCounty) ?
                     ContextHelper.getStringSafe(request, "selCdFacilityCounty") :
                     existingCounty;
    request.setAttribute("existingCounty", existingCounty);
    bMultCounty = !"".equals(existingCounty) && bMultCounty;

    // We will alwasy need the parsed data, so place into the request now.
    request.setAttribute(PARSED_ADDRESS_ROW, parsedAddress);
    request.setAttribute(CORRECT_COUNTY, county);

    if (validatedAddress.getStreet1() == null ||
        "".equals(validatedAddress.getStreet1())) {
      errorMessage = "No Match Found";
      setErrorMessage(errorMessage, "/common/AddressValidation/validate", request);
      request.setAttribute("code1error", errorMessage);
    }
    request.setAttribute(ADDRESS_ROW, validatedAddress);
    request.setAttribute(ADDRESS_VALIDATED, String.valueOf(addressValidated));
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

}

/** This is an exception class for the exception i throw in the the populateREquestFromOutput method. */
class AddressValidationException extends Exception {
  public AddressValidationException() {
    super();
  }

  public void setMessageNumber(int messageNumber) {
    this.messageNumber = messageNumber;
  }

  public int getMessageNumber() {
    return this.messageNumber;
  }

  private int messageNumber = 0;
}