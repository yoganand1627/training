<%
//----------------------------------------------------------------------------
//*  JSP Name:     Medical Mental Assessment Detail - Health Detail in SHINES
//*  Created by:   Michael Ochu
//*  Date Created: 10/05/2002
//*
//*  Description:
//*  This JSP is used to maintain a Medical Assessment information
/*
  Change History:
  Date      User          Description
  --------  ------------  ----------------------------------------------------
  06/09/03  Todd Reser    Added numerous <br> tags, a <hr> tag, re-aligned
                          and moved buttons, set Name Field size = 150.
  07/14/03  GRIMSHAN      SIR 18860 -- Do not get the timestamps from request
                          the database value may have been changed.
  11/13/03  DOUGLACS      SIR 22328 - dropdown doesn't work with names that
                          include apostrophe.
  01/12/04  RIOSJA        SIR 22494 - Removes the fix that was implemented for
                          SIR 22328. retrieveAddressPhoneInfo_xa will put an
                          indicator into the request to let the JSP know that
                          it should retrieve the original form values from the
                          request because the data will not be re-retrieved in
                          the method.
  11/03/04  CORLEYAN      SIR 23174 - Do not add the person to the dropdown
                          if the name is null or blank
  02/23/11  Hai Nguyen    SMS#97850: MR-075 Updated Date field label to Visit Date.
                          Also updated Number field label to Phone.
*/
//----------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%
//Initialize the variables for the page
String szCdEventType            = "";
String dtDtEventOccurred        = "";
int    ulIdEvent                = 0;
int    ulIdStage                = 0;
int    ulIdPerson               = 0;
String szTxtEventDescr          = "";
String szCdTask                 = "";
String szCdEventStatus          = "";
String evtsLastUpdate           = "";
String szTxtProfAssmtOther      = "";
String cdProfAssmtApptRsn       = "";
String dtProfAssmtAppt          = "";
String szTxtProfAssmtFindings   = "";
String NmszAddrProfAssmtState   = "";
String NmszAddrProfAssmtCity    = "";
String NmszAddrProfAssmtStLn1   = "";
String NmszAddrProfAssmtStLn2   = "";
String NmszAddrProfAssmtZip     = "";
String NmlNbrProfAssmtPhone     = "";
String NmlNbrPhoneExtension     = "";
String szNmProfAssmtName        = "";
String szNmProfAssmtPrincipal   = "";
String NmszTxtProfAssmtCmnts    = "";
String dtWCDDtSystemDate        = "";
String tsLastUpdate             = "";
int    ulIdPersonPrincipal      = 0;
String ulIdPersonProfessional   = "";
int    approverUlIdEvent        = 0;
String outNwkAuthChecked = "false";
boolean professionalInformationInd = true;

String fieldsToBeSpellChecked = "txtcomments";
int tabIndex = 1;

UserProfile userProfile = UserProfileHelper.getUserProfile( request );

String pageMode = PageModeConstants.VIEW;
int editableMode = EditableMode.VIEW;

if (PageMode.getPageMode( request ) != null)
{
  pageMode = PageMode.getPageMode( request );
  
  if(PageModeConstants.MODIFY.equals(pageMode)){
    // editableMode = EditableMode.EDIT;
  }  
  
}
CINV29SO cinv29so = (CINV29SO) request.getAttribute("CINV29S_medassmtDetail");
ROWCINV29SOG01_ARRAY namesStruct = null;
ROWCCMN45DO eventDetails = null;

// null checks
if ( cinv29so != null )
{
  if ( cinv29so.getROWCINV29SOG01_ARRAY() == null )
  {
    namesStruct = new ROWCINV29SOG01_ARRAY();
  }
  else
  {
    namesStruct = cinv29so.getROWCINV29SOG01_ARRAY();
  }
  if ( cinv29so.getROWCCMN45DO() == null )
  {
    eventDetails = new ROWCCMN45DO();
  }
  else
  {
    eventDetails = cinv29so.getROWCCMN45DO();
  }
}

int nameSize  = 0;
if( namesStruct != null )
{
 nameSize = namesStruct.getUlRowQty();
}
List<String> namesList = new ArrayList<String>();

// Loop through and get person_id and Full_name
if( namesStruct != null )
{
  int i = 0;
  for ( Enumeration assmtEnumeration1 = namesStruct.enumerateROWCINV29SOG01();
       assmtEnumeration1.hasMoreElements(); )
  {
    ROWCINV29SOG01 name = (ROWCINV29SOG01)assmtEnumeration1.nextElement();
    // SIR 23174 - Only perform the tokenizer and name adding if the name is not blank or null
    // if the name is blank or null, take a row out of the String Array Size
    if ( name.getSzScrNmGenericFullName() != null && !("").equals(name.getSzScrNmGenericFullName()))
    {
    StringBuffer namesDropDownValue = new StringBuffer();
    namesDropDownValue.append(Integer.toString(name.getUlIdPerson()));
    namesDropDownValue.append("|");
    //SIR 22328 - dropdown doesn't work with names that include apostrophe
    StringBuffer strTemp = new StringBuffer();
    StringTokenizer split = new StringTokenizer(name.getSzScrNmGenericFullName(), "'");

    strTemp.append(split.nextToken());
    while( split.hasMoreTokens() )
    {
    strTemp.append("\\'");
    strTemp.append(split.nextToken());
    }

    namesDropDownValue.append(strTemp);
    namesList.add( namesDropDownValue.toString());
    i++;
    }
  } // End For
} // End if Namestruct != null

if( request.getParameter("namesArray") != null )
{
  namesList = (List) SerializationHelper.deserializeObject(request.getParameter("namesArray"));
}

// Retrieved data from the event table.
if  ( eventDetails != null &&  eventDetails.getUlIdEvent() != 0)
{
  szCdEventType          = eventDetails.getSzCdEventType();
  dtDtEventOccurred      = FormattingHelper.formatDate(eventDetails.getDtDtEventOccurred());
  ulIdEvent              = eventDetails.getUlIdEvent();
  ulIdStage              = eventDetails.getUlIdStage();
  ulIdPerson             = eventDetails.getUlIdPerson();
  szTxtEventDescr        = eventDetails.getSzTxtEventDescr();
  szCdTask               = eventDetails.getSzCdTask();
  szCdEventStatus        = eventDetails.getSzCdEventStatus();
  evtsLastUpdate         = DateHelper.toISOStringSafe(eventDetails.getTsLastUpdate());
}

// Retrieved data from the Professional Assessment table.
if ( (cinv29so != null) && (eventDetails.getUlIdEvent() != 0))
{
  szTxtProfAssmtOther       = cinv29so.getSzTxtProfAssmtOther();
  cdProfAssmtApptRsn        = cinv29so.getCdProfAssmtApptRsn();
  if( pageMode.equals(PageModeConstants.EDIT)  || (pageMode.equals(PageModeConstants.VIEW)))
  {
    dtProfAssmtAppt           = FormattingHelper.formatDate(cinv29so.getDtProfAssmtAppt());
  }
  else
  {
   dtProfAssmtAppt = "";
  }

  outNwkAuthChecked = cinv29so.getCIndOutNetworkAuth();
  
  if(cinv29so.getSzTxtProfAssmtFindings() != null){
  szTxtProfAssmtFindings    = cinv29so.getSzTxtProfAssmtFindings();
  }else{
  szTxtProfAssmtFindings = "";
  }
  szNmProfAssmtName         = cinv29so.getSzNmProfAssmtName();
  szNmProfAssmtPrincipal    = cinv29so.getSzNmProfAssmtPrincipal();
  dtWCDDtSystemDate         = FormattingHelper.formatDate(cinv29so.getDtWCDDtSystemDate());
  tsLastUpdate              = DateHelper.toISOStringSafe(cinv29so.getTsLastUpdate());
  ulIdPersonPrincipal       = cinv29so.getUlIdPersonPrincipal();

  if ((cinv29so.getUlIdPersonProfessional()) != 0)
  {
    StringBuffer temp = new StringBuffer();
    temp.append(Integer.toString(cinv29so.getUlIdPersonProfessional()));
    temp.append("|");
    temp.append(cinv29so.getSzNmProfAssmtName());
     ulIdPersonProfessional = temp.toString();
  }
}

// Always put this event ID in, regardless of eventDetails event ID.
if ( cinv29so != null )
{
  approverUlIdEvent         = cinv29so.getUlIdEvent();
}

if (GlobalData.getUlIdEvent( request ) == 0)
{
  szNmProfAssmtPrincipal = GlobalData.getSzNmPersonFull(request);
  ulIdPersonPrincipal    = GlobalData.getUlIdPerson(request);
  ulIdPerson             = GlobalData.getUlIdPerson(request);
  ulIdStage              = GlobalData.getUlIdStage( request );
  szCdTask               = GlobalData.getSzCdTask( request );
}

Comparator<CodeAttributes> sortDecode = new Comparator<CodeAttributes>(){
  public int compare(CodeAttributes c1, CodeAttributes c2) {
    return c1.getDecode().compareTo(c2.getDecode());
  }
};
List<CodeAttributes> reasonsOptions = Lookup.getCategoryCollection(CodesTables.CARSAPPT);
Collections.sort(reasonsOptions, sortDecode);



boolean bIndBLOBExistsInDatabase = false;
if (cinv29so != null &&
    "NARRATIVE".equals(cinv29so.getSzScrTxtNarrStatus()) )
{
  bIndBLOBExistsInDatabase = true;
}

CINV30SO cinv30so = (CINV30SO) request.getAttribute("CINV30S_medassmtDetail");
if (cinv30so != null )
{
  if(cinv30so.getSzAddrProfAssmtState()!=null)
  {
     NmszAddrProfAssmtState = cinv30so.getSzAddrProfAssmtState();
  }
  if(cinv30so.getSzAddrProfAssmtCity()!=null)
  {
     NmszAddrProfAssmtCity = cinv30so.getSzAddrProfAssmtCity();
  }
  if(cinv30so.getSzAddrProfAssmtStLn1()!=null)
  {
     NmszAddrProfAssmtStLn1 = cinv30so.getSzAddrProfAssmtStLn1();
  }
  if(cinv30so.getSzAddrProfAssmtStLn2()!=null)
  {
    NmszAddrProfAssmtStLn2 = cinv30so.getSzAddrProfAssmtStLn2();
  }
  if(cinv30so.getSzAddrProfAssmtZip()!=null)
  {
    NmszAddrProfAssmtZip = cinv30so.getSzAddrProfAssmtZip();
  }
  if(cinv30so.getLNbrPhone()!=null)
  {
    NmlNbrProfAssmtPhone = cinv30so.getLNbrPhone();
  }
  if(cinv30so.getLNbrPhoneExtension()!=null)
  {
    NmlNbrPhoneExtension = cinv30so.getLNbrPhoneExtension();
  }
}


// SIR 22494 - If retrieveAddressPhoneInfo_xa just finished executing,
// it will have put an indicator into the request to let the JSP know
// that it should retrieve the original form values from the request
// because the method did no re-retrieved the data.
boolean bGetDataFromRequest = false;
if(request.getAttribute("bGetDataFromRequest") != null)
{
  bGetDataFromRequest = (Boolean) request.getAttribute("bGetDataFromRequest");
}

// If the user selected a different Person in the Professional
// Information section, get the data from the request to repopulate
// the fields and the hidden fields after the page reloads.
if(bGetDataFromRequest)
{
  if (request.getParameter("selSzNmProfAssmtName") != null &&
     !"".equals(request.getParameter("selSzNmProfAssmtName")))
  {
     ulIdPersonProfessional =  request.getParameter("selSzNmProfAssmtName");
  }

  if (request.getParameter("selSzNmProfAssmtName") == null ||
     "".equals(request.getParameter("selSzNmProfAssmtName")))
  {
     if (request.getParameter("txtOther") == null ||
          "".equals(request.getParameter("txtOther")))
     {
         professionalInformationInd = false;
     }
  }

  if (request.getParameter("ulIdPersonPrincipal") != null)
  {
     ulIdPersonPrincipal =  Integer.parseInt(request.getParameter("ulIdPersonPrincipal"));
  }

  if (request.getParameter("ulIdPerson") != null)
  {
     ulIdPerson =  Integer.parseInt(request.getParameter("ulIdPerson"));
  }

  if (request.getParameter("txtOther") != null)
  {
     szTxtProfAssmtOther =  (request.getParameter("txtOther"));
  }

  if (request.getParameter("szTxtEventDescr") != null)
  {
     szTxtEventDescr =  (request.getParameter("szTxtEventDescr"));
  }

  if (request.getParameter("szNmProfAssmtPrincipal") != null)
  {
     szNmProfAssmtPrincipal =  (request.getParameter("szNmProfAssmtPrincipal"));
  }

  if (request.getParameter("selReason") != null)
  {
     cdProfAssmtApptRsn =  (request.getParameter("selReason"));
  }

  if (request.getParameter("txtDate") != null)
  {
     dtProfAssmtAppt =  (request.getParameter("txtDate"));
  }
  if (request.getParameter("dtDtEventOccurred") != null)
  {
     dtDtEventOccurred =  (request.getParameter("dtDtEventOccurred"));
  }
  
  if ( request.getParameter("cbxOutOfNetworkAuth") != null )
  {
     outNwkAuthChecked = "true";
  }
  else
  {
     outNwkAuthChecked = "false";
  }

  if (request.getParameter("evtsLastUpdate") != null)
  {
     evtsLastUpdate =  (request.getParameter("evtsLastUpdate"));
  }

  if (request.getParameter("tsLastUpdate") != null)
  {
     tsLastUpdate =  (request.getParameter("tsLastUpdate"));
  }

  if (request.getParameter("txtcomments") != null)
  {
     szTxtProfAssmtFindings =  (request.getParameter("txtcomments"));
  }

  if (request.getParameter("ulIdEvent") != null)
  {
     ulIdEvent =  Integer.parseInt(request.getParameter("ulIdEvent"));
  }

  if (request.getParameter("ulIdStage") != null)
  {
     ulIdStage =  Integer.parseInt(request.getParameter("ulIdStage"));
  }
  if (request.getParameter("approverUlIdEvent") != null)
  {
     approverUlIdEvent =  Integer.parseInt(request.getParameter("approverUlIdEvent"));
  }

  if (request.getParameter("szCdTask") != null)
  {
     szCdTask =  (request.getParameter("szCdTask"));
  }
  if (request.getParameter("szCdEventStatus") != null)
  {
     szCdEventStatus =  (request.getParameter("szCdEventStatus"));
  }

  if (request.getParameter("szCdEventType") != null)
  {
     szCdEventType =  (request.getParameter("szCdEventType"));
  }

  if (request.getParameter("NmszAddrProfAssmtStLn1") != null)
  {
     NmszAddrProfAssmtStLn1 =  (request.getParameter("NmszAddrProfAssmtStLn1"));
  }
  if (request.getParameter("NmlNbrProfAssmtPhone") != null)
  {
     NmlNbrProfAssmtPhone =  (request.getParameter("NmlNbrProfAssmtPhone"));
  }
} // end if(bGetDataFromRequest)
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
// This function is called before the page unloads. It creates the
// "Are you sure you want to navigate away from this page..." pop-up
// message.
window.onbeforeunload = function ()
{
  IsDirty();
};

var namesCodeArray = new Array();
<%
if (namesList != null )
{
  namesList = StringHelper.removeDuplicates( namesList );
  for(int j=0; j < namesList.size(); j++)
  {
    if( namesList.get(j) != null )
    {%>
    namesCodeArray[<%=j%>] = '<%=namesList.get(j)%>';
    <%
    }
  }
}
%>


window.onload = function ()
{
  populateNameDropDown();
  <%
  if( !FormValidation.pageHasErrorMessages(request) &&
      ("".equals(NmszAddrProfAssmtStLn1) ||
       "".equals(NmszAddrProfAssmtCity) ||
       "".equals(NmszAddrProfAssmtState) ||
       "".equals(NmszAddrProfAssmtZip)) &&
      !"".equals(ulIdPersonProfessional))
  {
    if(!professionalInformationInd)
    {
  %>
    alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_INV_ADDR_NOT_FOUND ) %>" );
  <%
    }
  }
  %>
}

// This function is used to populate the name drop down.
function populateNameDropDown()
{
  var fieldName = "selSzNmProfAssmtName";

  // Check if field is disabled
  if( document.frmMdclMentalAssmt.selSzNmProfAssmtName.type != "select-one" )
  {
    fieldName = "selSzNmProfAssmtName_Disabled";
  }

  //sets the drop-down box to the length of the array +1
  eval("document.frmMdclMentalAssmt."+fieldName+".options.length =namesCodeArray.length + 1;");

  for (var q=0; q < namesCodeArray.length; q++)
  {
    //populates the drop-down box with the values from the CodeDecodeCache
    eval("document.frmMdclMentalAssmt."+fieldName+".options[q].value = namesCodeArray[q];");
    eval("document.frmMdclMentalAssmt."+fieldName+".options[q].text = namesCodeArray[q].substring(namesCodeArray[q].indexOf(\"|\")+1,namesCodeArray[q].length);");
    eval("document.frmMdclMentalAssmt."+fieldName+".options[q].defaultSelected = false;");
  }

  eval("document.frmMdclMentalAssmt."+fieldName+".value = \"<%=ulIdPersonProfessional%>\"");
  if(  eval("document.frmMdclMentalAssmt."+fieldName+".selectedIndex != -1"))
  {
    eval("document.frmMdclMentalAssmt."+fieldName+".options[document.frmMdclMentalAssmt."+fieldName+".selectedIndex].defaultSelected = true");
  }
}


function submitProfID()
{
  disableValidation( "frmMdclMentalAssmt" );
  window.onbeforeunload = null;
  submitValidateForm( "frmMdclMentalAssmt", "/investigation/MdclMentalAssmt/retrieveAddressPhoneInfo" );
}

function checkIdevent()
{
   if ( document.frmMdclMentalAssmt.ulIdEvent.value == 0 )
  {
    alert( "<%= MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEFORE_CONTINUE ) %>" );
    return false;
  }
  return true;
}
</script>

<impact:validateErrors formName="frmMdclMentalAssmt"/>

<impact:validateForm
        name="frmMdclMentalAssmt"
        method="post"
        action="/investigation/MdclMentalAssmt/displayMdclMentalAssmt"
        validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.MdclMentalAssmtValidation"
        schema="/WEB-INF/Constraints.xsd"
        redisplayParameters="true"
        pageMode="<%=pageMode%>">

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
     <td align="right">
        <a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll()">Expand All</a>&nbsp;
        <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
     </td>
  </tr>
</table>

<input type="hidden" name="namesArray" value="<%=SerializationHelper.serializeObject(namesList)%>"/>

<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
  <tr><th colspan="6">Professional Information</th></tr>
  <tr>
    <td>
      <impact:validateSelect
              name="selSzNmProfAssmtName"
              label="Name"
              onChange="submitProfID()"
              conditionallyRequired="true"
              id="selSzNmProfAssmtName"
              tabIndex="<%= tabIndex++ %>"
              style="WIDTH: 150px"
              blankValue="true"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput
              type="text"
              name="txtOther"
              label="Other"
              conditionallyRequired="true"
              value="<%=szTxtProfAssmtOther%>"
              size="40"
              maxLength="40"
              tabIndex="<%= tabIndex++ %>" />
    </td>
  </tr>
  <tr><th colspan="6">Visit information</th></tr>
  <tr>
    <td>
      <impact:validateSelect
              name="selReason"
              label="Reason"
              required="true"
              options="<%= reasonsOptions %>"
              value="<%=cdProfAssmtApptRsn%>"
              tabIndex="<%= tabIndex++ %>"
              blankValue="true" />
    </td>
    <td>
      <impact:validateDate
              type="text"
              name="txtDate"
              label="Visit Date"
              constraint="Date"
              required="true"
              value="<%=dtProfAssmtAppt%>"
              size="8"
              tabIndex="<%= tabIndex++ %>" />
    </td>
    <td>
      <impact:validateInput
              type="checkbox"
              colspan ="2"
              name="cbxOutOfNetworkAuth"
              label="Out of Network Authorization"
              value=""
              checked="<%= outNwkAuthChecked %>"
              tabIndex="<%= tabIndex++ %>" />
    </td>
  </tr>
  <tr>
    <td valign="top">
      <impact:validateTextArea
              name="txtcomments"
              constraint="Paragraph80"
              label="Comments"
              maxLength="80"
              conditionallyRequired="true"
              rows="4"
              cols="50"
              tabIndex="<%= tabIndex++ %>"><%=szTxtProfAssmtFindings%>
      </impact:validateTextArea>
    </td>
  </tr>
</table>

<% /*begin Address Phone Name Expandable section */ %>
<br>
<impact:ExpandableSectionTag
        name="MedMental"
        id="MedMental_id"
        label="Address/Phone Detail Name"
        tabIndex="<%= tabIndex++ %>">

<table border="0" cellSpacing="0" cellPadding="3" width="100%" class="tableBorder">
  <tr class="subDetail">
    <td>
      <table border="0" cellspacing="0" cellpadding="3">
        <tr>
          <td>
            <impact:validateDisplayOnlyField
                    name="txtPhone"
                    value="<%= FormattingHelper.formatPhone(NmlNbrProfAssmtPhone) %>"
                    label="Phone"/>
          </td>
          <td>
            <impact:validateDisplayOnlyField
                    name="txtPhoneExt"
                    value="<%= NmlNbrPhoneExtension %>"
                    label="Extension"/>
          </td>
        </tr>
        <tr>
          <td>
            <impact:validateDisplayOnlyField
                    name="addressStLn1"
                    value="<%=NmszAddrProfAssmtStLn1%>"
                    label="Street"/>
          </td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>
           <impact:validateDisplayOnlyField
                   name="addressStLn2"
                   value="<%=NmszAddrProfAssmtStLn2%>"/></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>
            <impact:validateDisplayOnlyField
                    name="city"
                    value="<%=NmszAddrProfAssmtCity%>"
                    label="City"/>
          </td>
          <td>
            <impact:validateDisplayOnlyField
                    name="state"
                    value="<%=NmszAddrProfAssmtState%>"
                    label="State"/>
          </td>
        </tr>
        <tr>
          <td>
            <impact:validateDisplayOnlyField
                    name="zip"
                    value="<%=NmszAddrProfAssmtZip%>"
                    label="Zip"/>
          </td>
          <td>
          <% String EMPTY_STRING = "";%>
            <impact:validateDisplayOnlyField
                    name="county"
                    value='<%=Lookup.simpleDecodeSafe( "CCOUNT" ,(cinv30so==null)? EMPTY_STRING: cinv30so.getSzCdProfAssmtCounty() )%>'
                    label="County"/>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</impact:ExpandableSectionTag>

<br>

<%/* BEGIN Admin Address Phone Submodule */%>
<%
  AdminAddressPhoneSubDB adminAddressPhoneSubDB = new AdminAddressPhoneSubDB();
  adminAddressPhoneSubDB.setFormName( "frmMdclMentalAssmt" );
  adminAddressPhoneSubDB.setPageMode( pageMode );
  adminAddressPhoneSubDB.setAddressPhoneSectionHeader( "Address/Phone Detail Other" );
  adminAddressPhoneSubDB.setAddressRequired( false );
  adminAddressPhoneSubDB.setAddressDisabled( false );
  adminAddressPhoneSubDB.setCommentsVisible( true );
  adminAddressPhoneSubDB.setCommentsRequired( false );
  adminAddressPhoneSubDB.setCommentsDisabled( false );
  adminAddressPhoneSubDB.setPhoneRequired( false );
  adminAddressPhoneSubDB.setPhoneDisabled( false );
  adminAddressPhoneSubDB.setAddressSubmoduleName( "" );
  adminAddressPhoneSubDB.setTabIndex( tabIndex );
  AdminAddressPhoneSubDB.setIntoRequest( adminAddressPhoneSubDB, request );
%>
<%@ include file="/grnds-docs/admin/AdminAddressPhoneSub.jsp" %>
<%
  tabIndex = adminAddressPhoneSubDB.getTabIndex();
  AdminAddressPhoneSubDB.removeFromRequest( request );
%>
<%/* END Admin Address Phone Submodule */%>
<br>
<hr>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td>&nbsp;</td>
    <td width="5%">
      <impact:spellCheck formToSpellCheck="frmMdclMentalAssmt"
                         fieldsToSpellCheck="<%= fieldsToBeSpellChecked %>"
                         tabIndex="<%=tabIndex++%>"/>
    </td>
    <td width="5%">
      <impact:ButtonTag name="btnSaveFinal"
                        img="btnSave"
                        align="right"
                        restrictRepost="true"
                        preventDoubleClick="true"
                        form="frmMdclMentalAssmt"
                        action="/investigation/MdclMentalAssmt/saveMdclMentalAssmt"
                        tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>

</table>

<input type="hidden" name="szCdEventType" value="<%= szCdEventType %>">
<input type="hidden" name="dtDtEventOccurred" value="<%= dtDtEventOccurred %>">
<input type="hidden" name="ulIdEvent" value="<%= ulIdEvent %>">
<input type="hidden" name="ulIdStage" value="<%= ulIdStage %>">
<input type="hidden" name="ulIdPerson" value="<%= ulIdPerson %>">
<input type="hidden" name="szTxtEventDescr" value="<%= szTxtEventDescr %>">
<input type="hidden" name="szCdTask" value="<%= szCdTask %>">
<input type="hidden" name="szCdEventStatus" value="<%= szCdEventStatus %>">
<input type="hidden" name="evtsLastUpdate" value="<%=evtsLastUpdate%>">
<input type="hidden" name="ulIdPersonProfessional" value="<%=ulIdPersonProfessional%>">
<input type="hidden" name="szNmProfAssmtName " value="<%= szNmProfAssmtName  %>">
<input type="hidden" name="szNmProfAssmtPrincipal" value="<%= szNmProfAssmtPrincipal %>">
<input type="hidden" name="dtWCDDtSystemDate" value="<%= dtWCDDtSystemDate%>">
<input type="hidden" name="NmszTxtProfAssmtCmnts" value="<%= NmszTxtProfAssmtCmnts%>">
<input type="hidden" name="tsLastUpdate" value="<%= tsLastUpdate%>">
<input type="hidden" name="ulIdPersonPrincipal" value="<%= ulIdPersonPrincipal %>">

<input type="hidden" name="approverUlIdEvent" value="<%= approverUlIdEvent%>">

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>

<%
 // Scriplet to protect document
 pageMode = PageModeConstants.MODIFY;
 boolean protectDoc = false;
 if (pageMode == PageModeConstants.VIEW)
 {
   protectDoc = true;
 }
 // SIR STGAP00002094 Displays the blank narrative  
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td>
      <impact:documentButton
              pageMode="<%= pageMode %>"
              tabIndex="<%= tabIndex++ %>">
        <impact:document
                displayName="Health Narrative"
                name="frmDocumentTag"
                protectDocument="<%= protectDoc %>"
                checkStage="<%= GlobalData.getUlIdStage(request) %>"
                postInSameWindow="false"
                docType="PRFASSMT"
                docExists="<%= bIndBLOBExistsInDatabase %>"
                onClick="checkIdevent()">
          <impact:documentParameter
                  name="sEvent"
                  value="<%= String.valueOf( GlobalData.getUlIdEvent(request) ) %>"/>
          <impact:documentParameter
                  name="sCase"
                  value="<%= String.valueOf( GlobalData.getUlIdCase(request) ) %>"/>
        </impact:document>
      </impact:documentButton>
    </td>
  </tr>
</table>
<br>

<%
//****************************
//**** REPORTS START HERE ****
//****************************
%>
<%/* BEGIN: Forms and Reports */%>

<%--<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr><th>Reports</th></tr>
  <tr>
    <td>
      <impact:reportList
              tabIndex="<%= tabIndex++ %>"
              personId="<%= userProfile.getUserID() %>">
              <impact:report
                      useHiddenParameters="true"
                      reportName="civ08o00"
                      emailMessage='<%= "Stage Name:  " + GlobalData.getSzNmStage( request ) %>'>
                      <impact:reportParameter value="<%= String.valueOf(GlobalData.getUlIdEvent( request )) %>"/>
                      <impact:reportParameter value="<%= String.valueOf(GlobalData.getUlIdPerson( request )) %>"/>
              </impact:report>
      </impact:reportList>
    </td>
  </tr>
</table>
--%><%/* END: Forms and Reports */%>
