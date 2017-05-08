/*
*  Function Name:  SerializeDIVs
*  Parameters:  None
*  Returns:  True
*
*  Description:  Searches through all the HTML widgets on a form.  If a form widget has
*  changed from its default value the DIV tag which contains the widget is added to hidden
*  field which the Java Developer can use to determine which Save/Update services to call.
*/

function SerializeDIVs(eForm) {
  //Holds total number of elements on form
  var iNumElems = eForm.elements.length;
  //String to hold list of service calls.  Based
  var strServices = "";
  var strCurrentDiv = "";

  /*
  * For each of the widgets in the form check the widget's
  * current value against the default value.
  */
  for (var i = 0; i < iNumElems; i++) {
    var eElem = eForm.elements[i];

    // Get the Working HTML DIV tag
    strWorkingDiv = GetDivTag(eElem);

    if (strWorkingDiv == null) {
      alert("Page cannot determine DIV tag.  Save may not work correctly.");
    }

    /* If current equals working Div then
    *  those elements should not be processed because a change
    *  has already been detected.
    */
    if (strCurrentDiv != strWorkingDiv) {
      if (CheckWidget(eElem)) {
        strServices = strServices + strWorkingDiv + " ";
        strCurrentDiv = strWorkingDiv;
      }
    }
  }

  /* Set value of hidden field to the DIV tags
  *  that have changed.  These DIV tags can be used
  *  by the Java conversation class to determine which
  *  service calls should be made.
  */
  eForm.hidServiceCall.value = strServices
  return false;

}

/*
*  Function Name:  GetDivTag
*  Parameters:  formField - HTML Widget
*  Returns:  String - DIV Name
*
*  Description:  Climbs the HTML Tree searching for the DIV tag which contains the widget.
*/

function GetDivTag(formField) {
  //  Local working variables
  var strDiv = "";
  var booFoundDiv = false;
  var fieldIterator = formField;

  while (fieldIterator.parentElement.tagName != "FORM" && booFoundDiv == false) {
    if (fieldIterator.parentElement.tagName == "DIV") {
      booFoundDiv = true;
      strDiv = fieldIterator.parentElement.name;
    }
    fieldIterator = fieldIterator.parentElement;
  }
  //Return the name of the found DIV tag
  return strDiv;
}

function nameContains(eElem, str) {
  var bContains = false;
  bContains = (-1 != (eElem.name.indexOf(str)));
  return bContains;
}

/*
*  Function Name:  CheckWidget
*  Parameters:  eElem - HTML Widget
*  Returns:  Boolean - True if widget changed, False if widget is the same
*
*  Description:  Evaluates present value of widget against default value to determine
*  if there has been a change. Exludes any widget that end in the _CLEAN Suffix
*  so that certain fields will not dirty the page.
*/
function CheckWidget(eElem) {

  // Variable which is returned
  var booChange = false;
  // if this variable has a _CLEAN in the name, do nothing
  if (!nameContains(eElem, "CLEAN")) {
    if ("text" == eElem.type || "TEXTAREA" == eElem.tagName) {
      if (eElem.value != eElem.defaultValue) {
        booChange = true;
      }
    } else if ("checkbox" == eElem.type || "radio" == eElem.type) {
      if (eElem.checked != eElem.defaultChecked) {
        booChange = true;
      }
    } else if ("SELECT" == eElem.tagName) {
      var cOpts = eElem.options;
      var iNumOpts = cOpts.length;
      for (var j = 0; j < iNumOpts; j++) {
        var eOpt = cOpts[j];
        if (eOpt.selected != eOpt.defaultSelected) {
          booChange = true;

        }
      }
    }
  }

  return booChange;
}

/*
*  Function Name:  isFormChanged
*  Parameters:  None
*  Returns:  Boolean
*
*  Description:  Evaluates a form to see if anything in the form has changed.
*  Returns true if something has changed.
*/
function isFormChanged(form) {
  var booDirtyForm = false;
  var iNumElements = form.elements.length;

  //  Loop through the form elements
  for (x = 0; x < iNumElements; x++) {
    if (!form.elements[x].disabled && CheckWidget(form.elements[x])) {
      booDirtyForm = true;
      break;
    }
  }
  return booDirtyForm;
}

/*
*  Function Name:  isFormChanged
*  Parameters:  None
*  Returns:  Boolean
*
*  Description:  Evaluates a form to page has changed by looping through all
*  the forms to see if they have changed.
*  Returns true if something has changed.
*/
function isPageChanged() {
  var iNumForms = document.forms.length;
  var booDirtyForm = false;
  //  For each form loop through its elements
  for (i = 0; i < iNumForms; i++) {
    if (isFormChanged(document.forms[i])) {
      booDirtyForm = true;
      break;
    }
  }
  return booDirtyForm;
}

/*
*  User can set page to present IsDirty popup message by calling
*  setPageDirtyFlag( true );  Useful for pullbacks where page
*  loads clean but data has actually changed prior to pullback, 
*  or for display-only field changes.
*/
var pageDirtyFlag = false;

function setPageDirtyFlag(dirty) {
  pageDirtyFlag = dirty;
}

/*
*  Function Name:  IsDirty
*  Parameters:  None
*  Returns:  None
*
*  Description:  Evaluates all the forms on a web page.  If the form's elements have
*  changed from their default state the user is prompted to save before leaving the page.
*  The isDirtyCalled var is available from impact.js.  It was moved there to ensure its
*  availability on every page, since dirtyForm.js isn't used on each page.  The button
*  tag now references this var instead of nulling the onbeforeunload method.
*/
function IsDirty() {
  if (!hrefDirtyBypass) {
    // Variable to hold all the forms on a page
    var booDirtyForm = false;
    booDirtyForm = isPageChanged();
    /*
    * If the form is dirty prompt the user before leaving the page.
    */
    if (( pageDirtyFlag || booDirtyForm ) && !isDirtyCalled) {
      event.returnValue = "Your unsaved data will be lost.";
      //MessageBox.show("Version: Visual J++ 6.0", "MyNotepad");
    }
    isDirtyCalled = false;
  }
  hrefDirtyBypass = false;
}

/*
*  Function Name:  CleanSelect
*  Parameters:  eElem - HTML Widget
*
*  Description:  Changes a select box to a state where isDirty() will pass.
*  Specifically, it sets defaultSelected = selected for each option.
*/
function CleanSelect(eElem) {
  if ("SELECT" == eElem.tagName) {
    var cOpts = eElem.options;
    var iNumOpts = cOpts.length;
    for (var j = 0; j < iNumOpts; j++) {
      var eOpt = cOpts[j];
      eOpt.defaultSelected = eOpt.selected;
    }
  }
  return;
}
