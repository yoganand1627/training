  var validForms = new Array();
  validForms[0] = "frmCaseSearch";
  validForms[1] = "frmPersonSearch";
  validForms[2] = "frmResourceSearch";
  validForms[3] = "frmFaHomeSearch";
  validForms[4] = "frmStaffSearch";
  validForms[5] = "frmContractSearch";
  validForms[6] = "frmInvoiceSearch";
  validForms[7] = "frmPaymentHistory";
  validForms[8] = "frmCountyBudgetLimitSearch";
  validForms[9] = "frmTCMClaimsSearch";
  validForms[10] = "frmCaseSummary";
  validForms[11] = "frmLogin";
  validForms[12] = "frmOnCallSearch";
  validForms[13] = "frmContractHeader";
  validForms[14] = "EventSearch";
  validForms[15] = "frmReportParameters";
  validForms[16] = "frmUnitSummary";
  validForms[17] = "frmUnitSearch";
  validForms[18] = "frmStaffToDo";
  validForms[19] = "frmCallLog";
  validForms[20] = "frmContactSearchList";  
  
function isValidForm(formName) {
  
  var returncode = false;
  for (x in validForms)
  {
    if (validForms[x] == formName)
    {
      returncode = true;
      break;
    }  
  }
  return returncode;
}

function disableWidgets() {
  
  for (j=0; j < document.forms.length; j++)
  {
    var formName = document.forms[j].name;
    var index = formName.indexOf("frm");
    if (index == 0 && !isValidForm(formName)) 
    {
       var form = document.forms[j];
       for (i=0; i < form.elements.length; i++)
       {
         var formElement = form.elements[i];
         var indexForm = formElement.name.indexOf("Form");
         //Do not disable widgets named with Form* convention, hiddenField or View Option
         if (formElement.name != "hiddenField" && indexForm == -1 && formElement.name != "selOption_CLEAN" && formElement.type != "hidden")
         {
           formElement.disabled = "true";           
         }   
       }
    }
  }
}





//method that allows you to add an
//item into the request object
function setItemIntoRequest(formName, formElementName, itemElementName) {
  thisForm = eval("document." + formName);

  var newField = document.createElement("input");
  newField.type = "hidden";
  newField.name = itemElementName;
  newField.value = formElementName.value;
  thisForm.appendChild(newField);
}

/*
 * populates the drop down with the appropriate code/decode value pair by calling
 * the populateDropdownByLoopingThroughArray method
 * @param formElement element on form to be populated
 * @param codeArrayName name of the code array used on the calling form
 * @param parentCode code selected  on the mapped element used in
 *                   determining what codes shoule be displayed
 * @param strLen length of the parent code that maps to the first few characters of the codes
 *               that will be used.
 */
function populateDropdownByLoopingThroughArray(formName, fieldName, codeArrayName, parentCode, strLen) {
  populateDropdownByLoopingThroughArray(formName, fieldName, codeArrayName, parentCode, strLen, '');
}

/*
 * populates the drop down with the appropriate code/decode value pair
 * @param formElement element on form to be populated
 * @param codeArrayName name of the code array used on the calling form
 * @param parentCode code selected  on the mapped element used in
 *                   determining what codes shoule be displayed
 * @param strLen length of the parent code that maps to the first few characters of the codes
 *               that will be used.
 * @param val value of last selected option on dropdown box
 */
function populateDropdownByLoopingThroughArray(formName, fieldName, codeArrayName, parentCode, strLen, val) {
  var elementName = eval("document." + formName + "." + fieldName);
  populateDropdownDecode(elementName, val, codeArrayName, false);

  var codeArray = codeArrayName;
  var count = 1;

  for (var q = 0; q < codeArray.length; q++) {
    //  Get the code from the codeArray we are filtering
    var code = codeArray[q].substring(0, codeArray[q].indexOf("|"));
    //  Get the decode from the codeArray we are filtering
    var decode = codeArray[q].substring(codeArray[q].indexOf("|") + 1, codeArray[q].length);
    //  If the code contains the filter key and the key is not empty string
    //  add the code to the filtered list
    if (parentCode == code.substring(0, strLen)) {
      //  Add the code and decode to the filtered list
        elementName.options[count].value = code;
      
      //if a value previously existed in drop down we will maintain that value	
      if(code == elementName.value){
        elementName.options[count].selected = true;
        elementName.options[count].defaultSelected = true;
      }
      elementName.options[count].text = decode;
      count++;
    }
  }
  elementName.options.length = count;
}

// This function populates drop down boxes with options.
// param field: Name of drop down box to be populated
// param val: Value of last selected option on dropdown box
// param cat: Array containing the values to populate drop down options
// SIR 23041 param decode: true or false depending on if the decode should be
// displayed in the dropdown.
function populateDropdownDecode(field, val, cat, decode) {
  //sets the drop-down box to the length of the array
  field.options.length = cat.length;
  for (var q = 0; q < cat.length; q++) {
    //populates the drop-down box with the values from the CodeDecodeCache
    field.options[q].value = cat[q].substring(0, cat[q].indexOf("|"));
    if (decode == true) {
      //populates the drop-down with codes and decodes
      field.options[q].text = cat[q].replace("|", " ");
    } else {
      //populates the drop-down with decodes only
      field.options[q].text = cat[q].substring(cat[q].indexOf("|") + 1, cat[q].length);
    }
  }
  field.value = val;
}

function populateDropdown(field, val, cat) {
  populateDropdownDecode(field, val, cat, false);
}

// this function expands collapsible sections and sets the focus on the first element
function expandWithFocus(elementId, expandedName, collapsedName) {
  if (window.event && window.event.keyCode == 13) {
    //alert("Inside expandWithFocus Enter clicked");
    expandCollapsed(expandedName, collapsedName);
    if (elementId != "") {
      document.getElementById(elementId).focus();
    }
    //alert("Inside expandWithFocus Enter clicked b4 ENTER disable");
    return false;
  }
  return true;
}

//this function calls selectPage for pagination if enter key is pressed
function paginateOnEnter(pageNumber) {
  if (window.event && window.event.keyCode == 13) {
    if (validatePagination(pageNumber)) {
      selectPage(pageNumber);
      return false;
    }

  }
  return true;
}

// validate digits were entered for pagination text field
function validatePagination(str) {
  //thisForm = eval("document."+formName);
  //str = thisForm.testValue.value;
  numTest = /^([1-9][0-9]?[0-9]?)$/;
  if (numTest.test(str)) {
    return true;
  } else {
    alert("Please enter a digit between 1 and 999.");
    return false;
  }
}

//this function collapses expandable sections and sets the focus on the collapsed arrow
function collapseWithFocus(elementId, expandedName, collapsedName) {
  if (window.event && window.event.keyCode == 13) {
    //alert("Inside collapseWithFocus Enter clicked");
    collapseExpanded(expandedName, collapsedName);
    if (elementId != "") {
      document.getElementById(elementId).focus();
    }
    //alert("Inside collapseWithFocus Enter clicked b4 ENTER disable");
    return false;
  }
  return true;
}

function expandCollapsed(expandedName, collapsedName) {
  //alert("Inside expandCollapsed");
  toggleVisibility(expandedName, 'block');
  toggleVisibility(collapsedName, 'none');
}

function collapseExpanded(expandedName, collapsedName) {
  //alert("Inside collapseExpanded");
  toggleVisibility(collapsedName, 'block');
  toggleVisibility(expandedName, 'none');
}

function expandCollapsedWithFlag(expandedName, collapsedName, hiddenExpandFlag) {
  //alert("Inside expandCollapsed");
  toggleVisibility(expandedName, 'block');
  toggleVisibility(collapsedName, 'none');
  if (hiddenExpandFlag != '') {
    var hiddenExpandElem = eval("document.getElementById('" + hiddenExpandFlag + "')");
    hiddenExpandElem.value = true;
  }
}

function collapseExpandedWithFlag(expandedName, collapsedName, hiddenExpandFlag) {
  //alert("Inside collapseExpanded");
  toggleVisibility(collapsedName, 'block');
  toggleVisibility(expandedName, 'none');
  if (hiddenExpandFlag != '') {
    var hiddenExpandElem = eval("document.getElementById('" + hiddenExpandFlag + "')");
    hiddenExpandElem.value = false;
  }
}

//This function clears drop down boxes of all options.
//param field: Name of drop down box to be cleard of all options
function clearDropdown(field) {
  field.options.length = 1;
  field.options[0] = new Option('',
          '',
          true,
          true);

  field.options.value = "";
}

function hide_div_txtDateBirth() {
  div_txtDateBirth.style.visibility = "hidden";
}

//Used to toggle visibility of the expandable sections
//DEPRECATED.  ...use TextTurndown
function flip(id) {
  if (document.getElementById(id).style.display == 'none') {
    document.getElementById(id).style.display = 'block';
  } else if (document.getElementById(id).style.display == 'block') {
    document.getElementById(id).style.display = 'none';
  }
}

//Used to toggle visibility of the expandable sections
function TextTurndown(TextBlockID, ImageID) {
  if (TextBlockID.style.display == "none") {
    TextBlockID.style.display = "block";
    document.all.item(ImageID).src = "/grnds-docs/images/shared/arrowOpen.gif";
  } else {
    TextBlockID.style.display = "none";
    document.all.item(ImageID).src = "/grnds-docs/images/shared/arrowClosed.gif";
  }
}

function mouseOverTurndown(element) {
  element.style.cursor = "hand";
}

function expand(id) {
  document.getElementById(id).style.display = 'block';
}

function hide(id) {
  document.getElementById(id).style.display = 'none';
}

function toggleVisibility(id, NNtype) {
  if (document.getElementById(id)) {
    eval("document.getElementById(id).style.display=\"" + NNtype + "\"");
  } else {
    if (document.layers) {
      document.layers[id].display = NNtype;
    } else {
      if (document.all) {
        eval("document.all." + id + ".style.display=\"" + NNtype + "\"");
      }
    }
  }
}

function setState(formName) {
  thisForm = eval("document." + formName);
  setXpandedStateFields(thisForm);
  thisForm.target = "_self";
  thisForm.hiddenField.value = hiddenFieldStateForm.hiddenField.value;
  //Add performance tracking info into submitted form
  setPerfData(formName);
}

//Add performance tracking info into submitted form
function setPerfData(formName) {
  thisForm = eval("document." + formName);

  var newField = document.createElement("input");
  newField.type = "hidden";
  newField.name = "requestTotalTime";
  newField.value = hiddenFieldStateForm.requestTotalTime.value;
  thisForm.appendChild(newField);
  //alert('requestTotalTime:' + hiddenFieldStateForm.requestTotalTime.value);
  var newField2 = document.createElement("input");
  newField2.type = "hidden";
  newField2.name = "requestStartTime";
  newField2.value = (new Date()).getTime();
  thisForm.appendChild(newField2);
  //  alert( "requestTotalTime:" + newField.value );
  //  alert( "requestStartTime:" + newField2.value );
}

//Submit the form with a specified action setting target back to self.
//This must be used for all pages that have Form Launcher section.
function submitForm(formName, formAction) {
  hrefDirtyBypass = true;
  setActionUrl(formName, formAction);
  setState(formName);
  thisForm = eval("document." + formName);
  thisForm.submit();
}

//Submit the validateForm with a specified action setting target back to self.
//This must be used for all pages that have Form Launcher section.
function submitValidateForm(formName, formAction) {
  hrefDirtyBypass = true;
  setValidationUrl(formName, formAction);
  setState(formName);
  thisForm = eval("document." + formName);
  thisForm.submit();
}

//Submit the validateForm with a specified action setting target back to self.
//This is used instead of submitValidateForm for non-button widgets that need
//to call IsDirty.  submitValidateForm is for hyperlinks that submit the form.
function submitValidateFormNoBypass(formName, formAction) {
  setValidationUrl(formName, formAction);
  setState(formName);
  thisForm = eval("document." + formName);
  try {
    thisForm.submit();
  }
  catch(e) {
    // When the user cancels navigation, an unspecified error is thrown
    // In this situation, no action is expected, so ignore the error.
  }
}

//Set the action for Buttons not requiring validation
function setActionUrl(formName, formAction) {
  thisForm = eval("document." + formName);
  thisForm.action = formAction;
}

//Set the validation URL for Buttons requiring validation
function setValidationUrl(formName, formAction) {
  thisForm = eval("document." + formName);
  thisForm.FormValidationUrl.value = formAction;
}

//Function for setting an informational message on the jsp.
function setInformationalMessage(sMsg) {
  var sTotalMsg = "";
  sTotalMsg = getMsg(sMsg);
  displayErrors(sTotalMsg);
  document.all.errorMsg.focus();
}

//Deprecated; used as a wrapper for backward compatibility
function setErrorMsg(sTotalMsg, sMsg) {
  return setMsg(sTotalMsg, sMsg);
}

//Used by validation framework to set an individual error message onto the list of error messages
function setMsg(sTotalMsg, sMsg) {
  if (sMsg != true) {
    return( sMsg + sTotalMsg );
  }
  return sTotalMsg;
}

//Deprecated: used as a backwards compatibility wrapper
function getFieldErrorMsg(sMsg, frm, field) {
  return getFieldMsg(sMsg, frm, field);
}

//Get an individual error message based on the field
//Set the field label to red
function getFieldMsg(sMsg, frm, field) {
  label = eval('document.all.label_' + field.id);
  if (label) {
    label.className = 'formLabelError';
  }
  return "<li><a onClick=\"hrefDirtyBypass=true;\" " +
         "href=\"javascript:SetFocus(document." + frm.name + "." + field.name + ")\">" +
         field.title + "</a>" + " - " + sMsg + "<br>";
}

//Deprecated: used as a backwards compatibility wrapper
function getErrorMsg(sMsg) {
  return getMsg(sMsg);
}

//Get an individual error message based on the field
function getMsg(sMsg) {
  var sMsgLine = "<li>" + sMsg + "<br>";
  return sMsgLine;
}

//Set focus to an object
function SetFocus(obj) {
  if (obj) {
    // SIR 19132 - if field is invisible call expand all first then focus
    try {
      obj.focus();
    } catch(e) {
      expandAll();
      obj.focus();
    }
  }
}
//Display the info messages in the infoMsgs section of the page
function displayInfoMsgs(sInfoMsg) {
  var sMsg = new String;
  oMsg = document.all.infoMsg;
  if (sInfoMsg == "") {
    return true;
  }
  sMsg += "<table width=\"100%\" cellpadding=\"1\"><tr><td class=\"formInfoText\">";
  sMsg += "<hr noshade size=\"1\">";
  sMsg += "<span class=\"formLabelInfo\">Attention:</span>";
  sMsg += sInfoMsg;
  sMsg += "<hr noshade size=\"1\">";
  sMsg += "</td></tr></table>";
  oMsg.innerHTML = sMsg;
  return false;
}

//Deprecated wrapper for displayErrorMsgs
function displayErrors(sErrMsg) {
  displayErrorMsgs(sErrMsg);
}

//Display the error messages in the errorMsg section of the page
function displayErrorMsgs(sErrMsg) {
  var sMsg = new String;
  oMsg = document.all.errorMsg;
  if (sErrMsg == "") {
    return true;
  }
  sMsg += "<table width=\"100%\" cellpadding=\"1\"><tr><td class=\"formErrorText\">";
  sMsg += "<hr noshade size=\"1\">";
  sMsg += "<span class=\"formLabelError\">Please correct the following error(s):</span>";
  sMsg += sErrMsg;
  sMsg += "<hr noshade size=\"1\">";
  sMsg += "</td></tr></table>";
  oMsg.innerHTML = sMsg;
  return false;
}

//Get the current date in the format mm/dd/yyyy
function getCurrentDate() {
  var time = new Date();
  month = time.getMonth();
  month = ( month < 10 ) ? '0' + month : month;
  day = time.getDate();
  day = ( day < 10 ) ? '0' + day : day;
  return( month + '/' + day + '/' + time.getYear() );
}

function resetErrors(frm) {
  var frm2;
  frm2 = eval("document." + frm.name);
  for (var i = 0; i < frm2.elements.length; ++i) {
    frm2[i].className = null;
    var oLabel = eval("document.all.label_" + frm2[i].id);
    if (oLabel) oLabel.className = 'formLabel';
  }
}

// Used to EXPAND all the collapsible sections in a JSP.
// Requires that all the expanded versions of collapsible
// sections start with the text "expanded", and all the
// collapsed versions begin with "collapsed".
function expandAll() {
  var divArray = document.getElementsByTagName("div");
  for (i = 0; i < divArray.length; i++) {
    if (divArray[i].id.substr(0, 8) == "expanded") {
      divArray[i].style.display = "block";
      var hiddenFieldName = "xpand" + divArray[i].id.substr(8) + "_Id";
      document.getElementById(hiddenFieldName).value = 'true';
    } else if (divArray[i].id.substr(0, 9) == "collapsed") {
      divArray[i].style.display = "none";
    }
  }
}

// Used to Cancel validation of the form passed

function disableValidation(frmName) {
  var frm = eval("document." + frmName);
  frm.FormValidationCancel.value = "true";
}

// Used to Enable validation of the form passed
function enableValidation(frmName) {
  var frm = eval("document." + frmName);
  frm.FormValidationCancel.value = "";
}

// Used to COLLAPSE all the collapsible sections in a JSP.
// Requires that all the expanded versions of collapsible
// sections start with the text "expanded", and all the
// collapsed versions begin with "collapsed".
function collapseAll() {
  var divArray = document.getElementsByTagName("div");
  for (i = 0; i < divArray.length; i++) {
    if (divArray[i].id.substr(0, 8) == "expanded") {
      divArray[i].style.display = "none";
      var hiddenFieldName = "xpand" + divArray[i].id.substr(8) + "_Id";
      document.getElementById(hiddenFieldName).value = 'false';
    } else if (divArray[i].id.substr(0, 9) == "collapsed") {
      divArray[i].style.display = "block";
    }
  }
}

function setXpandedStateFields(formObj) {
  var divArray = document.getElementsByTagName("div");
  var state = null;
  var id = null;
  for (var i = 0; i < divArray.length; i++) {
    id = divArray[i].id;
    if (id.substr(0, 8) == "expanded") {
      if (divArray[i].style.display == "block") {
        state = "true";
      } else {
        state = "false";
      }
      id = id.substr(8, id.length);
    }
    if (state != null) {
      var newField = document.createElement("input");
      newField.type = "hidden";
      newField.name = "xpand" + id;
      newField.value = state;
      formObj.appendChild(newField);
    }
    state = null;
  }
}

// returns the array number of the selected radio button or -1 if no button is selected
function getSelectedRadio(buttonGroup) {
  if (buttonGroup[0]) { // if the button group is an array (one button is not an array)
    for (var i = 0; i < buttonGroup.length; i++) {
      if (buttonGroup[i].checked) {
        return i;
      }
    }
  } else {
    if (buttonGroup.checked) {
      return 0;
    } // if the one button is checked, return zero
  }
  // if we get to this point, no radio button is selected
  return -1;
}
// Ends the "getSelectedRadio" function

// returns the value of the selected radio button or "" if no button is selected
function getSelectedRadioValue(buttonGroup) {
  var i = getSelectedRadio(buttonGroup);
  if (i == -1) {
    return "";
  } else {
    if (buttonGroup[i]) { // Make sure the button group is an array (not just one button)
      return buttonGroup[i].value;
    } else { // The button group is just the one button, and it is checked
      return buttonGroup.value;
    }
  }
}
// Ends the "getSelectedRadioValue" function

// launches a standard sized popup subwindow: used by functions like:
// >address validation
// >reports confirmation
function launchSubWindowWxH(location, width, height) {
  var descriptor = "";
  descriptor += "width=" + width + ",";
  descriptor += "height=" + height + ",";
  descriptor += "channelmode=0,";
  descriptor += "dependent=0,";
  descriptor += "directories=0,";
  descriptor += "fullscreen=0,";
  descriptor += "location=0,";
  descriptor += "menubar=0,";
  descriptor += "resizable=0,";
  descriptor += "scrollbars=0,";
  descriptor += "status=0,";
  descriptor += "toolbar=0";
  return window.open(location, "_blank", descriptor);
}

function launchSubWindow(location) {
  return launchSubWindowWxH(location, 700, 400);
}

//For the given checkbox set the changed indicator field
// 1. to A if the field was default not checked and now is checked
// 2. to D if the field was default checked and now is not checked
function setCbxChange(formName, field) {
  changeIndFieldValue = eval('document.' + formName + '.' + field.name + '_changed' + '.value');
  newValue = '';
  defaultChecked = changeIndFieldValue.substring(1, 2);
  value = changeIndFieldValue.substring(2);
  changedInd = ' ';
  if (field.checked && (defaultChecked == 'N')) {
    changedInd = 'A';
  } else if (!field.checked && (defaultChecked == 'Y')) {
    changedInd = 'D';
  }
  changeIndFieldValue = changedInd + defaultChecked + value;
  eval('document.' + formName + '.' + field.name + '_changed.value=\"' + changeIndFieldValue + '\"');
}

// counts the number of checkboxes with a given name that are checked
function countChecked(cbxGroupName, numCbx) {
  var count = 0;
  for (i = 1; i <= numCbx; i++) {
    var cbx = document.getElementsByName(cbxGroupName + i);
    var isChecked = cbx[0].checked;
    if (isChecked) {
      count++;
    }
  }
  return count;
}

// returns true if any checkboxes in a checkbox group with a given name
// are checked, false otherwise
function areAnyChecked(cbxGroupName, numCbx) {
  for (i = 1; i <= numCbx; i++) {
    var cbx = document.getElementsByName(cbxGroupName + i);
    var isChecked = cbx[0].checked;
    if (isChecked) {
      return true;
    }
  }
  return false;
}

//replaces spaces with plus signs for URL encoding
function encodeQueryString(queryString) {
  var encodedQueryString = "";
  for (i = 0; i < queryString.length; ++i) {
    if (queryString.charAt(i) == ' ') {
      encodedQueryString += "+";
    } else {
      encodedQueryString += queryString.charAt(i);
    }
  }
  return encodedQueryString;
}

// used to change both the display value and the hidden field for display only fields
function updateDisplayOnlyField(formName, fieldName, value) {
  document.getElementById(fieldName + "_id").innerHTML = value;
  eval(formName + "." + fieldName).value = value;
}

//  used to filter a drop down box based on a key.  the user must pass in
//  the key to filter on, the drop down box they want to filter, the name of a code array
//  they created for the codes table associated with the drop down box, and true or false
//  depending on if they the drop down options to contain a blank value or not.

//  example of the code array:
//  <impact:codeArray codeName="CACTITYP" arrayName="CACTITYP" blankValue="true"/>;
function populateFilteredDropdown(key, selectBoxToFilter, codeArray, blankValue) {
  var count = 1;
  if (!blankValue) {
    count = 0;
  }
  //  Set the length of the select box we are filtering to the length of the unfilter codeArray
  selectBoxToFilter.options.length = codeArray.length;

  for (var q = 0; q < codeArray.length; q++) {
    //  Get the code from the codeArray we are filtering
    var code = codeArray[q].substring(0, codeArray[q].indexOf("|"));
    //  Get the decode from the codeArray we are filtering
    var decode = codeArray[q].substring(codeArray[q].indexOf("|") + 1, codeArray[q].length);

    //  Check to see if the code contains the filter key we obtained above
    if (( code.substring(0, key.length) == key ) && ( key != "")) {
      //  If the code contains the filter key add the code to the filtered list
      selectBoxToFilter.options[count].value = code;
      selectBoxToFilter.options[count].text = decode;
      count++;
    }
  }
  //  Once we have cycled through the codes table, set the length of the select box we are filtering
  //  to the length of the filtered codes table.
  selectBoxToFilter.options.length = count;
}

// uses the same regexp as in Constraints.xsd to validate a date -- returns true if the string passed in is a
// valid date between 1/1/1600 and 12/31/9999 in MM/dd/yyyy format with or without slashes, false otherwise.
function validateDate(d) {
  var re = /^(?:(0?[13578]|1[02])(\/?)(31)\2|(0?[13-9]|1[0-2])(\/?)(29|30)\5|(0?[1-9]|1[0-2])(\/?)(0?[1-9]|1\d|2[0-8])\8)((?:1[6-9]|[2-9]\d)\d{2})$|^(0?2)(\/?)(29)\12((?:1[6-9]|[2-9]\d)(?:0[48]|[2468][048]|[13579][26])|(?:16|[2468][048]|[3579][26])00)$/;
  var m = d.match(re);
  return m != null && m[0] == d;
}

// uses the same regexp as in Constraints.xsd to validate an ID -- returns true if the string passed in is a
// valid ID between 1 and 2147483647, false otherwise.
function validateId(id) {
  var re = /^\d?\d?\d?\d?\d?\d?\d?\d?\d?\d$/;
  var m = id.match(re);
  var isValid = m != null && m[0] == id;
  if (isValid) {
    if (!isNaN(id)) {
      isValid &= id < 2147483648 && id > 0;
    } else {
      isValid = false;
    }
  }
  return isValid;
}

/*
*  The isDirtyCalled var has been moved here to ensure its availability on every page,
*  since dirtyForm.js isn't used on each page.  The button tag now references this var
*  instead of nulling the onbeforeunload method, so it must be available to avoid a
*  javascript error.
*/

var isDirtyCalled = false;

var hrefDirtyBypass = false;

function setIsDirtyCalled(booleanValue) {
  isDirtyCalled = booleanValue;
}

function disableDateField(form, dateField) {
  dateField.disabled = true;
  calImgSpanName = "cal_img_div_calendar_" + dateField.name;
  toggleVisibility(calImgSpanName, "none");
}

function enableDateField(form, dateField) {
  dateField.disabled = false;
  calImgSpanName = "cal_img_div_calendar_" + dateField.name;
  toggleVisibility(calImgSpanName, "inline");
}

//This function is used in conjunction with the spellcheck custom tag.

function spellCheckPage(formName) {

  var formToCheck = thisForm = eval("document." + formName);
  var formAction = formToCheck.action;
  var formOnSubmit = formToCheck.onsubmit;
  var formTarget = formToCheck.target;
  var validationUrl = formToCheck.FormValidationUrl.value;
  var encodingType = formToCheck.encoding;

  disableValidation(formName);

  //Set the form properties so it goes to the spellchecker.
  // reset encoding for spell checker on external documentation
  formToCheck.encoding = "application/x-www-form-urlencoded";
  formToCheck.target = "spellWindow";
  formToCheck.action = "/document/DocumentConversation/checkSpellingAppPage";
  formToCheck.onsubmit = "";
  formToCheck.FormValidationUrl.value = "/document/DocumentConversation/checkSpellingAppPage";
  window.open("", "spellWindow", 'toolbar=0,location=0,directories=0,status=1,scrollbars=1,resizable=1,width=450,height=400');

  formToCheck.submit();

  //Reset the form properties so it behaves normally
  formToCheck.action = formAction;
  formToCheck.onsubmit = formOnSubmit;
  formToCheck.target = formTarget;
  formToCheck.encoding = encodingType;
  formToCheck.FormValidationUrl.value = validationUrl;
  enableValidation(formName);

  return true;

}

function validateDateString(dateString) {
  var returnDateString = "INVALID";
  var dashIndex = dateString.indexOf("-");
  var slashIndex = dateString.indexOf("/");
  if (dashIndex > 0) {
    var secondDashIndex = dateString.lastIndexOf("-");
    returnDateString = dateString.substring(0, dashIndex);
    returnDateString += "/";
    returnDateString += dateString.substring(dashIndex + 1, secondDashIndex);
    returnDateString += "/";
    returnDateString += dateString.substring(secondDashIndex + 1, dateString.length);
  }
  //Try to get a date with format mm/dd/yyyy
  else if (slashIndex > 0) {
    returnDateString = dateString;
  }
  //If date has neither - or / try mmddyyyy.
  else if (dateString.length == 8) {
    //Add slashes to date and try to parse
    returnDateString = dateString.substring(0, 2);
    returnDateString += "/";
    returnDateString += dateString.substring(2, 4);
    returnDateString += "/";
    returnDateString += dateString.substring(4, 8);
  }
  if (!validateDate(returnDateString)) {
    returnDateString = "INVALID";
  }
  return returnDateString;
}

// This function is called onBlue of the Date of Birth
// and will calculate and fill the Age field.
function calculateAge(dobFieldName, ageField) {
  dobAsString = validateDateString(dobFieldName.value);

  if (validateDate(dobAsString)) {
    dob = new Date(Date.parse(dobAsString));
    today = new Date();

    dobDay = dob.getDate();
    dobMonth = dob.getMonth();
    dobYear = dob.getFullYear();

    todayDay = today.getDate();
    todayMonth = today.getMonth();
    todayYear = today.getFullYear();

    age = todayYear - dobYear;
    // If the child is not yet 1 year old
    // or the user has entered an invalid (future) date
    // return without setting the age.
    if (age == 0 || age < 0) {
      ageField.value = "";
      return;
    }
    // If the person has not had their bday yet, subtract a year.
    else if (( todayMonth < dobMonth ) ||
             ( ( dobMonth == todayMonth ) && ( todayDay < dobDay ) )) {
      age = age - 1;
    }
    ageField.value = age;
  }
}

/*
** This file retrieved from the JS-Examples archives
** http://www.js-examples.com
** 1000s of free ready to use scripts, tutorials, forums.
** Author: Brock Weaver - 0
*/

// create the prototype on the String object

String.prototype.trim = function() {
  // skip leading and trailing whitespace
  // and return everything in between
  var x = this;
  x = x.replace(/^\s*(.*)/, "$1");
  x = x.replace(/(.*?)\s*$/, "$1");
  return x;
};

// Sets cookie values. Expiration date is optional
function setCookie(name, value, expire) {
  document.cookie = name + "=" + escape(value)
          + "; path=/"
          + ((expire == null) ? "" : ("; expires=" + expire.toGMTString()));
}

//copied from http://tech.irt.org/articles/js064/index.htm#3 (said public domain)
function getCookie(name) {
  var start = document.cookie.indexOf(name + "=");
  var len = start + name.length + 1;
  if ((!start) && (name != document.cookie.substring(0, name.length))) return null;
  if (start == -1) return null;
  var end = document.cookie.indexOf(";", len);
  if (end == -1) end = document.cookie.length;
  return unescape(document.cookie.substring(len, end));
}

/*
  SPB - 04/10/03
  This function is called by the ErrorList pop-up window
  It submits the navigation form with the URL and concatenated
  task code passed by the callParent( url ) function triggered
  by clicking on a link in the ErrorList window.
*/

function processErrorListSubmit(url) {
  submitForm('navigationForm', url);
}
function setPerformanceStop() {
  var time;
  if (document.hiddenFieldStateForm.requestStartTime.value != 'null') {
    time = (new Date()).getTime() - document.hiddenFieldStateForm.requestStartTime.value;
  } else {
    time = 0;
  }
  document.hiddenFieldStateForm.requestTotalTime.value = time;
}

function MM_findObj(n, d) { //v4.0
  var p,i,x;
  if (!d) {
    d = document;
  }
  if (( p = n.indexOf("?") ) > 0 && parent.frames.length) {
    d = parent.frames[n.substring(p + 1)].document;
    n = n.substring(0, p);
  }
  if (!( x = d[n] ) && d.all) {
    x = d.all[n];
  }
  for (i = 0; !x && i < d.forms.length; i++) {
    x = d.forms[i][n];
  }
  for (i = 0; !x && d.layers && i < d.layers.length; i++) {
    x = MM_findObj(n, d.layers[i].document);
  }
  if (!x && document.getElementById) {
    x = document.getElementById(n);
  }
  return x;
}

function MM_showHideLayers() { //v3.0
  var i, p, v, obj, args = MM_showHideLayers.arguments;
  for (i = 0; i < ( args.length - 2 ); i += 3) {
    if (( obj = MM_findObj(args[i]) ) != null) {
      v = args[i + 2];
      if (obj.style) {
        obj = obj.style;
        v = ( v == 'show' ) ? 'visible' : ( v = 'hide' ) ? 'hidden' : v;
      }
      obj.visibility = v;
    }
  }
}

function showFormsOnLine() {
  myleft = screen.availWidth * 0.40;
  mywidth = screen.availWidth - myleft - 20;
  mytop = 1;
  myheight = screen.availHeight - 100;

  window.open(FORMS_ONLINE_URL, "_blank",
          "dependent=yes,directories=yes,height=" + myheight + ",left=" + myleft +
          ",width=" + mywidth + ",top=" + mytop +
          ",location=no,menubar=no,personalbar=no,resizable=yes,scrollbars=yes,status=yes,toolbar=yes");
}

function setLevel1Tab(strLevel1Constant, destination) {
  eval('navigationForm.' + METAPHOR_LEVEL_1 + '.value=' + '\'' + strLevel1Constant + '\'');
  clearLevel3Tab();
  setLevel2Default();
  // Clear GlobalData for L1 tabs
  var blank = "";
  eval('navigationForm.' + HIDDEN_FIELD_KEY + '.value=\"\"');
  setActionUrl('navigationForm', destination);
  //Set Perf Tracking data onto form
  setPerfData('navigationForm');
  hrefDirtyBypass = true;
  navigationForm.submit();
}

function setLevel2Tab(strLevel2Constant, destination) {
  eval('navigationForm.' + METAPHOR_LEVEL_2 + '.value=' + '\'' + strLevel2Constant + '\'');
  clearLevel3Tab();
  setLevel3Default();
  submitForm('navigationForm', destination);
}
function setIntakeLevel2Tab(strLevel2Constant, formName, destination) {
  thisForm = eval("document." + formName);
  eval('thisForm.' + METAPHOR_LEVEL_2 + '.value=' + '\'' + strLevel2Constant + '\'');
  clearLevel3Tab();
  setLevel3Default();
  thisForm.fireEvent("onSubmit");
  submitValidateForm(formName, destination);
}
function setLevel3Tab(strLevel3Constant, destination) {
  eval('navigationForm.' + METAPHOR_LEVEL_3 + '.value=' + '\'' + strLevel3Constant + '\'');
  submitForm('navigationForm', destination);
}

function setLevel2Default() {
  var strLevel1Constant = eval('navigationForm.' + METAPHOR_LEVEL_1 + '.value');

  if (strLevel1Constant == "MY_TASKS_ASSIGNEDWORKLOAD") {
    eval('navigationForm.' + METAPHOR_LEVEL_2 + '.value=\"WORKLOAD_ASSIGNEDWORKLOAD\"');
  } else if (strLevel1Constant == "CASE_CASESEARCH") {
    eval('navigationForm.' + METAPHOR_LEVEL_2 + '.value=\"CASE_CASESEARCH_CASESEARCH\"');
  } else if (strLevel1Constant == "SEARCH_PERSONSEARCH") {
    eval('navigationForm.' + METAPHOR_LEVEL_2 + '.value=\"PERSON_PERSONSEARCH\"');
  } else if (strLevel1Constant == "INTAKE_INTAKE") {
    eval('navigationForm.' + METAPHOR_LEVEL_2 + '.value=\"CALL_INFORMATION_CALLINFRMTN\"');
  } else if (strLevel1Constant == "FINANCIAL_CONTRACTSEARCH") {
    eval('navigationForm.' + METAPHOR_LEVEL_2 + '.value=\"INVOICE_SEARCH_INVOICESEARCH\"');
  } else if (strLevel1Constant == "REPORTS_REPORTLIST") {
    eval('navigationForm.' + METAPHOR_LEVEL_2 + '.value=\"REPORT_LIST_REPORTLIST\"');
  } else if (strLevel1Constant == "RESOURCE_RESOURCESEARCH") {
    eval('navigationForm.' + METAPHOR_LEVEL_2 + '.value=\"RESOURCE_SEARCH_RESOURCESEARCH\"');
  }
}

function setLevel3Default() {
}

function clearLevel3Tab() {
  eval('navigationForm.' + METAPHOR_LEVEL_3 + '.value = null');
}












