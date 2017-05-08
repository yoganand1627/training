/*
*  Function Name:  submitDocumentListForm
*  Parameters:  form
*  Returns:  Boolean
*
*  Description:  This function is the 'main' function for launching a document from
*  the dropdown list.  It performs the following functions:
*   1.  Verify the user selected an item from the dropdown list
*   2.  Check the application page state.  If it's NEW prompt the user to save first.
*   3.  Check the application form for "dirtyness".  If the page is dirty then display a prompt
*       to the user to save.
*/
function submitDocumentListForm(frmDisplay)
{

   // Verify the user selected an item from the list
   var docForm = frmDisplay.cboDocument_CLEAN.options[frmDisplay.cboDocument_CLEAN.selectedIndex].value;
   if (docForm == null || docForm == "")
   {
     alert('A document must be selected before the Launch button is clicked.');
     return false;
   }

   // Run document delete check
   promptDeleteDocument(docForm);

   // Verify the page is not in new mode
   if (!checkForNewMode(docForm))
   {
     // The web page is in NEW mode and should be saved
     alert ('Please save page before producing document.');
     return false;
   }

   // Verify the page is not in new mode
   if (!promptNoDocument(docForm))
   {
     // The web page is in NEW mode and should be saved
     alert ('There is not a document to display.');
     return false;
   }

   // Find the HTML form to check if it should be saved
   // before producing the document
   var formToCheck = findApplicationHtmlForm(docForm);

   if (formToCheck != null)
   {
     if(dirtyHtmlForm (formToCheck))
     {
       // The web page is dirty and should be saved
       alert('Page data has changed.  Please save before producing document.');
       return false;
     }
   }

   var booReturn = executeCustomScript(docForm);
   if (booReturn == false)
     return false;

   submitDocumentForm(docForm);
   return false;
}

function submitDocumentButtonForm(frmDisplay)
{
   var docForm = frmDisplay.hidDocType.value;

   // Run document delete check
   promptDeleteDocument(docForm);

   // Verify the page is not in new mode
   if (!checkForNewMode(docForm))
   {
     // The web page is in NEW mode and should be saved
     alert ('Please save page before producing document.');
     return false;
   }

   // Verify the page is not in new mode
   if (!promptNoDocument(docForm))
   {
     // The web page is in NEW mode and should be saved
     alert ('There is not a document to display.');
     return false;
   }


   // Find the HTML form to check if it should be saved
   // before producing the document
   var formToCheck = findApplicationHtmlForm(docForm);

   if (formToCheck != null)
   {
     if(dirtyHtmlForm (formToCheck))
     {
       // The web page is dirty and should be saved
       alert('Page data has changed.  Please save before producing document.');
       return false;
     }
   }

   var booReturn = executeCustomScript(docForm);
   if (booReturn == false)
     return false;


   submitDocumentForm(docForm);
   return false;
}


/*
*  Function Name:  findApplicationHtmlForm
*  Parameters:  String - Name of document Html form
*  Returns:  String - Name of Html form to check
*
*  Description:  This function finds the name of the application Html form to check before
*  launching the document.  This will be used later in the dirtyHtmlForm function.
*/
function  findApplicationHtmlForm(id)
{
  var formToCheck = null;
  var frmDocument = document.getElementById(id);

  if (frmDocument != null)
  {
    formToCheck = frmDocument.promptSavePage.value;
  }

  if (formToCheck == 'null')
    formToCheck = null;

  return formToCheck;
}

/*
*  Function Name:  checkForNewMode
*  Parameters:  form
*  Returns:  Boolean
*
*  Description:  Checks if the page is in a NEW mode. If document is configured to check for
*  a new mode and the page is in a new mode the user will be prompted to save the page before producing
*  the document.
*/
function checkForNewMode(id)
{
  var frmDocument = document.getElementById(id);

  // If the document form was found
  if (frmDocument != null)
  {
    // Verify the document should check for a new mode
    if (frmDocument.checkForNewMode.value == 'true')
    {
      // If the page mode is new
      if (frmDocument.modeOfPage.value == '1' || frmDocument.modeOfPage.value == '2' )
      {
        return false;
      }
    }
  }

  return true;

}


/*
*  Function Name:  promptNoDocument
*  Parameters:  form
*  Returns:  Boolean
*
*  Description:  Checks if the user should be prompted by the error message indicating there isn't a document.
*  PromptNoDocument will be set to true when it's a savable document & the document doesn't exist & protectDocument
*  is true.
*/
function promptNoDocument(id)
{
  var frmDocument = document.getElementById(id);

  // If the document form was found
  if (frmDocument != null)
  {
    // Verify the document should check for a new mode
    if (frmDocument.promptNoDocument.value == 'true')
    {
       return false;
    }
  }

  return true;

}


/*
*  Function Name:  executeCustomScript
*  Parameters:  form
*  Returns:  Boolean
*
*  Description:  This function calls the onClick script the developer has specified.
*/
function executeCustomScript(id)
{
  var frmDocument = document.getElementById(id);
  var booReturn = true;
  // If the document form was found
  if (frmDocument != null)
  {
    // Verify the document should check for a new mode
    if (frmDocument.onClick.value != 'null')
    {
     booReturn = eval (frmDocument.onClick.value);
    }
  }

  return booReturn;

}





/*
*  Function Name:  submitDocumentForm
*  Parameters:  String - ID of the form to be submitted
*  Returns:  Boolean
*
*  Description:  Launches the document form and sets the BaseHiddenFieldState
*/
function submitDocumentForm(id)
{
   var frmDocument = document.getElementById(id);
   var action = frmDocument.action;

   // Set the BaseHiddenFieldState
   setState(id);
   
   // Added for MR-024 Contact changes.  Should be ignored by architecture if the document does not 
   // exist, but needed to force message if narrative type was changed on Contact Detail.
   frmDocument.docExists.value = 'true'; 

   // If the form is not configured to post in the application
   // window then open a new window and post the form into the new window
   if (frmDocument.postInSameWindow.value =='false')
   {

     if (frmDocument.windowName.value == 'null')
     {
       var randomWinName = Math.random();
       var strRandomName = randomWinName.toString();
       strRandomName=strRandomName.substr(2);
       openDocumentConversationWindow(strRandomName);
       frmDocument.target = strRandomName;

     }
     else
     {
       var strWindowName = frmDocument.windowName.value;
       frmDocument.target = strWindowName;
     }
   }
   frmDocument.submit();
}

/*
*  Function Name:  openDocumentConversationWindow
*  Parameters:  none
*  Returns:  String - The window name which is the date/time.  This is done to make sure each
*  time a document is launched that it posts into it's own window.
*
*  Description:  This function works with the ShowDocumentTag.  When the ShowDocumentTag
*  is used this function is runs when the page is loaded. It opens a new window and posts
*  the document form.
*
*/

function openDocumentConversationWindow(strRandomName)
{

  //var now = new Date();
  //var format = "MMddyyyyhhmmss";
  //var dateString =  formatDate(now,format);

  //formDate=dateString;
  window.open('/grnds-docs/document/blank.htm',
              strRandomName,
              'toolbar=yes,location=yes,directories=no,status=yes,menubar=yes,scrollbars=yes,resizable=yes,width=600,height=400,left=100,top=20');
  return strRandomName;


}

/*
*  Function Name:  showDocument
*  Parameters:  none
*  Returns:  Void
*
*  Description:  This function works with the ShowDocumentTag.  When the ShowDocumentTag
*  is used this function is runs when the page is loaded. It opens a new window and posts
*  the document form.
*
*/

function showDocument()
{
  var id = document.frmShowDocument.hidDocument.value;
  var frmDocument = document.getElementById(id);
  var defaultAction = frmDocument.action;
  setState(id);

  // Set the action and the target to launch the document into a new window

  if (frmDocument.windowName.value == 'null')
  {
    var randomWinName = Math.random();
    var strRandomName = randomWinName.toString();
    strRandomName=strRandomName.substr(2);
    openDocumentConversationWindow(strRandomName);
    frmDocument.target = strRandomName;

  }
  else
  {
    var strWindowName = frmDocument.windowName.value;
    frmDocument.target = strWindowName;
  }
  frmDocument.action = "/document/DocumentConversation/showDocument";
  frmDocument.submit();
  /*
  frmDocument.action = "/document/DocumentConversation/showDocument";
  var randomWinName = Math.random();
  var strRandomName = randomWinName.toString();
  strRandomName=strRandomName.substr(2);
  openDocumentConversationWindow(strRandomName);
  frmDocument.target = strRandomName;
  frmDocument.submit();
  */
  // Reset the action and target so button will go to the correct url when
  // the user clicks the launch button.
  frmDocument.action = defaultAction;
  frmDocument.target = "";
}

/*
*  Function Name:  dirtyHtmlForm
*  Parameters:  String - ID of the form to check "dirtyness"
*  Returns:  Boolean
*
*  Description:  Evaluates all the forms on a web page.  If the form's elements have
*  changed from their default state the user is prompted to save before showing the form.
*/

function dirtyHtmlForm(id)
{
  var booDirtyForm = false;
  var frmApplicationPage = document.getElementById(id);
  var iNumElements = frmApplicationPage.elements.length;
  //  Loop through the form elements
  for (x=0; x<iNumElements; x++)
  {
     if ( !frmApplicationPage.elements[x].disabled && checkWidget(frmApplicationPage.elements[x]))
     {
       booDirtyForm = true;
     }
  }

  return booDirtyForm;

}


/*
*  Function Name:  CheckWidget
*  Parameters:  eElem - HTML Widget
*  Returns:  Boolean - True if widget changed, False if widget is the same
*
*  Description:  Evaluates present value of widget against default value to determine
*  if there has been a change.
*/

function checkWidget(eElem)
{

  // Variable which is returned
  var booChange = false;
  if ("text" == eElem.type || "TEXTAREA" == eElem.tagName)
  {
    if (eElem.value != eElem.defaultValue)
    {
          booChange = true;
        }
  }
  else if ("checkbox" == eElem.type || "radio" == eElem.type)
  {
    if (eElem.checked != eElem.defaultChecked)
    {
          booChange = true;
        }
  }
  else if ("SELECT" == eElem.tagName)
  {
        var cOpts = eElem.options;
        var iNumOpts = cOpts.length;
        for (var j=0; j<iNumOpts; j++)
          {
            var eOpt = cOpts[j];
        if (eOpt.selected != eOpt.defaultSelected)
                {
                  booChange = true;
                }
          }
   }

  return booChange;
}

function promptDeleteDocument(id)
{
  var frmDocument = document.getElementById(id);

  // If the document form was found
  if (frmDocument != null)
  {
    // Verify the document should check for a new mode
    if (frmDocument.deleteDocument.value == 'true')
    {
      if ( confirm("Click OK to retrieve the current document or CANCEL to create a new document.") )
      {
        frmDocument.deleteDocument.value = 'false';
      }
      else
      {
        if ( !confirm("All modifications to the document will be deleted.  Are you sure you want to continue?  Click OK to delete document." ) )
        {
          frmDocument.deleteDocument.value = 'false';
        }
      }
    }
  }
}


/*
var MONTH_NAMES=new Array('January','February','March','April','May','June','July','August','September','October','November','December','Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec');
function LZ(x) {return(x<0||x>9?"":"0")+x}

// ------------------------------------------------------------------
// formatDate (date_object, format)
// Returns a date in the output format specified.
// The format string uses the same abbreviations as in getDateFromFormat()
// ------------------------------------------------------------------
function formatDate(date,format) {
        format=format+"";
        var result="";
        var i_format=0;
        var c="";
        var token="";
        var y=date.getYear()+"";
        var M=date.getMonth()+1;
        var d=date.getDate();
        var H=date.getHours();
        var m=date.getMinutes();
        var s=date.getSeconds();
        var yyyy,yy,MMM,MM,dd,hh,h,mm,ss,ampm,HH,H,KK,K,kk,k;
        // Convert real date parts into formatted versions
        var value=new Object();
        if (y.length < 4) {y=""+(y-0+1900);}
        value["y"]=""+y;
        value["yyyy"]=y;
        value["yy"]=y.substring(2,4);
        value["M"]=M;
        value["MM"]=LZ(M);
        value["MMM"]=MONTH_NAMES[M-1];
        value["d"]=d;
        value["dd"]=LZ(d);
        value["H"]=H;
        value["HH"]=LZ(H);
        if (H==0){value["h"]=12;}
        else if (H>12){value["h"]=H-12;}
        else {value["h"]=H;}
        value["hh"]=LZ(value["h"]);
        if (H>11){value["K"]=H-12;} else {value["K"]=H;}
        value["k"]=H+1;
        value["KK"]=LZ(value["K"]);
        value["kk"]=LZ(value["k"]);
        if (H > 11) { value["a"]="PM"; }
        else { value["a"]="AM"; }
        value["m"]=m;
        value["mm"]=LZ(m);
        value["s"]=s;
        value["ss"]=LZ(s);
        while (i_format < format.length) {
                c=format.charAt(i_format);
                token="";
                while ((format.charAt(i_format)==c) && (i_format < format.length)) {
                        token += format.charAt(i_format++);
                        }
                if (value[token] != null) { result=result + value[token]; }
                else { result=result + token; }
                }
        return result;
  }
*/
