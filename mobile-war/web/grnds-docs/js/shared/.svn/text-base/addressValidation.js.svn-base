// Name: addressValidation.js
// Author: Dann Webster
// Date: 05/07/2003
//
// Change Log
// Author   Date        Change
// _______  __________  ___________________________________________________________
// CASDORJM  05/14/2003 SIR 17484 - Added a check on changeValidAddress that would
//                      set the value of the hidden IS_VALID field to true
//                      is the user cleared all the address information.  This
//                      way the validateAddressOnSave will not be called for
//                      cleared/blank addresses.
// ________ ___________ ___________________________________________________________
// AODUTAYO 09/27/2006  SIR???? -  Changed all references to TEXAS which was the 
//                      default for IMPACT to GEORGIA which is default for SHINES

// The following javascript variables are derived from constants in
// AddressBean.java. The names of each are equivalent to the names of
// the constants in AddressBean, for example, IS_VALID should have the
// same value as AddressBean.IS_VALID in the AddressBean.java file.
var IS_VALID = "addressIsValid";
var FORM_ACTION = "addressAction";
var ADDRESS1 = "addressAddress1";
var ADDRESS2 = "addressAddress2";
var CITY = "addressCity";
var STATE = "addressState";
var COUNTY = "addressCounty";
var ZIP = "addressZip";
var ZIP_SUFF = "addressZipSuff";
var IN_REQUEST = "addressInRequest";
var MULT_COUNTY = "addressMultCounty";
var SAVE_OR_VALIDATE = "addressSaveOrValidate";
var ADDRESS_SUBMODULE_NAME = "addressSubmoduleName";
//var TEXAS = "TX";
var GEORGIA = "GA";

// The following javascript variables are derived from constants in
// AdminAddressPhoneBean.java. The names of each are equivalent to the names of
// the constants in AdminAddressPhoneBean, for example, IS_VALID should have the
// same value as AdminAddressPhoneBean.IS_VALID in the AdminAddressPhoneBean.java file.
var PHONE = "adminPhonePhone";
var PHONE_EXT = "adminPhonePhoneExt";

// This variable is from the AddressValidationConversation
// The following javascript variables are derived from constants in
// AddressValidationConversation.java. The names of each are equivalent to the names of
// the constants in AddressValidationConversation, for example, ORIGINATING_FORM should have the
// same value as AddressValidationConversation.IS_VALID in the
// AddressValidationConversation.java file.
var ORIGINATING_FORM = "frmWindowName";

// These javascript functions are used by the AddressSub.jsp to help in address validation
function validateAddressOnSave(formName, formAction, addressSubmoduleName) {
  return validateAddressOnSave(formName, formAction, addressSubmoduleName, '');
}

// Buttons that save valid addresses but launch Code 1 for invalid/changed addresses
// should include their own names in the js call if their page's custom validation
// class needs to know if that button was pressed by isButtonPressed( buttonName );
function validateAddressOnSave(formName, formAction, addressSubmoduleName, buttonName) {
  var thisForm = eval("document." + formName);
  var isAddressValid = eval("thisForm." + addressSubmoduleName + IS_VALID + ".value");
  var hdnFormAction = eval("thisForm." + addressSubmoduleName + FORM_ACTION);
  hdnFormAction.value = formAction;
  if (isAddressValid == "true") {
    return true;
  } else {
    launchAddressValidate(formName, 'save', addressSubmoduleName, buttonName);
    return false;
  }
}

function changeValidAddress(formName, addressSubmoduleName) {
  var thisForm = eval("document." + formName);
  var hdnIsValid = eval("thisForm." + addressSubmoduleName + IS_VALID);
  hdnIsValid.value = "false";

  // JMC - SIR 17484 - START
  // The address should be considered valid is it is blank.
  var address1 = eval("thisForm." + addressSubmoduleName + ADDRESS1 + ".value");
  var address2 = eval("thisForm." + addressSubmoduleName + ADDRESS2 + ".value");
  var city = eval("thisForm." + addressSubmoduleName + CITY + ".value");
  var state = eval("thisForm." + addressSubmoduleName + STATE + ".options.value");
  var zip = eval("thisForm." + addressSubmoduleName + ZIP + ".value");
  var zipSuff = eval("thisForm." + addressSubmoduleName + ZIP_SUFF + ".value");
  var county = eval("thisForm." + addressSubmoduleName + COUNTY + ".options.value");

  if (( address1 == null || address1 == "" ) &&
      ( address2 == null || address2 == "" ) &&
      ( city == null || city == "" ) &&
      ( state == null || state == "" || state == GEORGIA ) &&
      ( zip == null || zip == "" ) &&
      ( zipSuff == null || zipSuff == "" ) &&
      ( county == null || county == "" )) {
    hdnIsValid.value = "true";
  }
  // JMC - SIR 17484 - END
}

function toggleCounty(formName, addressSubmoduleName) {
  var thisForm = eval("document." + formName);
  // check if state and county exist; if not, just quit
  if (( document.getElementsByName(addressSubmoduleName + STATE)[0] == null ) ||
      ( document.getElementsByName(addressSubmoduleName + COUNTY)[0] == null )) {
    return;
  }

  var state = eval("thisForm." + addressSubmoduleName + STATE);
  var county = eval("thisForm." + addressSubmoduleName + COUNTY);

  if (county.type != "select" || state.type != "select") {
    return;
  }
  if (state != null && county != null) {
    if (state.value != "GA") {
      county.disabled = true;
    } else {
      county.disabled = false;
    }
  }
}

function saveWithValidate(formName, addressSubmoduleName) {
  var thisForm = eval("document." + formName);
  var hdnFormAction = eval("thisForm." + addressSubmoduleName + FORM_ACTION);
  submitValidateForm(formName, hdnFormAction.value);
}

function saveWithValidateAndButton(formName, addressSubmoduleName, buttonName) {
  var thisForm = eval("document." + formName);
  var hdnFormAction = eval("thisForm." + addressSubmoduleName + FORM_ACTION);

  // If a button name is included, create an input in the form of this name + ".x"
  // to simulate the clicking of that button
  if (buttonName != '') {
    var buttonInput = document.createElement("input");
    var buttonName = buttonName + ".x";
    buttonInput.type = "hidden";
    buttonInput.name = buttonName;
    buttonInput.value = "20";
    buttonInput.className = "formInput";
    thisForm.appendChild(buttonInput);
  }

  submitValidateForm(formName, hdnFormAction.value);
}

function launchAddressValidate(formName, saveOrValidate, addressSubmoduleName) {
  launchAddressValidate(formName, saveOrValidate, addressSubmoduleName, '');
}

function launchAddressValidate(formName, saveOrValidate, addressSubmoduleName, buttonName) {
  var thisForm = eval("document." + formName);
  var address1 = escape(eval("thisForm." + addressSubmoduleName + ADDRESS1 + ".value"));
  var address2 = escape(eval("thisForm." + addressSubmoduleName + ADDRESS2 + ".value"));
  var city = escape(eval("thisForm." + addressSubmoduleName + CITY + ".value"));
  var state = escape(eval("thisForm." + addressSubmoduleName + STATE + ".value"));
  var zip = escape(eval("thisForm." + addressSubmoduleName + ZIP + ".value"));
  var zipSuff = escape(eval("thisForm." + addressSubmoduleName + ZIP_SUFF + ".value"));
  var county = eval("thisForm." + addressSubmoduleName + COUNTY + ".value");
  var inRequest = eval("thisForm." + addressSubmoduleName + IN_REQUEST + ".value");
  var multCounty = eval("thisForm." + addressSubmoduleName + MULT_COUNTY + ".value");

  var queryString = "?"
  queryString += ADDRESS1 + "=" + address1;
  queryString += "&"
  queryString += ADDRESS2 + "=" + address2;
  queryString += "&"
  queryString += CITY + "=" + city;
  queryString += "&"
  queryString += STATE + "=" + state;
  queryString += "&"
  queryString += ZIP + "=" + zip;
  queryString += "&"
  queryString += ZIP_SUFF + "=" + zipSuff;
  queryString += "&"
  queryString += COUNTY + "=" + county;
  queryString += "&"
  queryString += MULT_COUNTY + "=" + multCounty;
  queryString += "&"
  queryString += IN_REQUEST + "=" + inRequest;
  queryString += "&"
  queryString += SAVE_OR_VALIDATE + "=" + saveOrValidate;
  queryString += "&"
  queryString += ORIGINATING_FORM + "=" + formName;
  queryString += "&"
  queryString += ADDRESS_SUBMODULE_NAME + "=" + addressSubmoduleName;
  queryString += "&"
  queryString += "buttonClicked=" + buttonName;
  queryString = encodeQueryString(queryString);

  launchSubWindow('/common/AddressValidation/validateAddress' + queryString);
}

// This function will be called everytime the form is submitted since the page is saved everytime the form
// is submitted.
function validate2AddressesOnSave(formName, action, submoduleName1, submoduleName2) {
  var isFirstAddressValidString = eval(formName + "." + submoduleName1 + IS_VALID + ".value");
  var isSecondAddressValidString = eval(formName + "." + submoduleName2 + IS_VALID + ".value");

  var isFirstAddressValid = ( isFirstAddressValidString == "true" );
  var isSecondAddressValid = ( isSecondAddressValidString == "true" );

  if (isFirstAddressValid && isSecondAddressValid) {
    return true;
  } else if (!isFirstAddressValid && isSecondAddressValid) {
    validateAddressOnSave(formName, action, submoduleName1);
    return false;
  } else if (isFirstAddressValid && !isSecondAddressValid) {
    validateAddressOnSave(formName, action, submoduleName2);
    return false;
  } else {
    //neither valid
    validateAddressOnSave(formName, action, submoduleName2);
    launchAddressValidate(formName, 'validate', submoduleName1);
    return false;
  }
}
