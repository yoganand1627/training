package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.admin.AdminAddressPhoneBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;

public final class MdclMentalAssmt_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/admin/AdminAddressPhoneSub.jsp");
    _jspx_dependants.add("/grnds-docs/common/AddressSub.jsp");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n// This function is called before the page unloads. It creates the\r\n// \"Are you sure you want to navigate away from this page...\" pop-up\r\n// message.\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nvar namesCodeArray = new Array();\r\n");

if (namesList != null )
{
  namesList = StringHelper.removeDuplicates( namesList );
  for(int j=0; j < namesList.size(); j++)
  {
    if( namesList.get(j) != null )
    {
      out.write("\r\n    namesCodeArray[");
      out.print(j);
      out.write("] = '");
      out.print(namesList.get(j));
      out.write("';\r\n    ");

    }
  }
}

      out.write("\r\n\r\n\r\nwindow.onload = function ()\r\n{\r\n  populateNameDropDown();\r\n  ");

  if( !FormValidation.pageHasErrorMessages(request) &&
      ("".equals(NmszAddrProfAssmtStLn1) ||
       "".equals(NmszAddrProfAssmtCity) ||
       "".equals(NmszAddrProfAssmtState) ||
       "".equals(NmszAddrProfAssmtZip)) &&
      !"".equals(ulIdPersonProfessional))
  {
    if(!professionalInformationInd)
    {
  
      out.write("\r\n    alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_INV_ADDR_NOT_FOUND ) );
      out.write("\" );\r\n  ");

    }
  }
  
      out.write("\r\n}\r\n\r\n// This function is used to populate the name drop down.\r\nfunction populateNameDropDown()\r\n{\r\n  var fieldName = \"selSzNmProfAssmtName\";\r\n\r\n  // Check if field is disabled\r\n  if( document.frmMdclMentalAssmt.selSzNmProfAssmtName.type != \"select-one\" )\r\n  {\r\n    fieldName = \"selSzNmProfAssmtName_Disabled\";\r\n  }\r\n\r\n  //sets the drop-down box to the length of the array +1\r\n  eval(\"document.frmMdclMentalAssmt.\"+fieldName+\".options.length =namesCodeArray.length + 1;\");\r\n\r\n  for (var q=0; q < namesCodeArray.length; q++)\r\n  {\r\n    //populates the drop-down box with the values from the CodeDecodeCache\r\n    eval(\"document.frmMdclMentalAssmt.\"+fieldName+\".options[q].value = namesCodeArray[q];\");\r\n    eval(\"document.frmMdclMentalAssmt.\"+fieldName+\".options[q].text = namesCodeArray[q].substring(namesCodeArray[q].indexOf(\\\"|\\\")+1,namesCodeArray[q].length);\");\r\n    eval(\"document.frmMdclMentalAssmt.\"+fieldName+\".options[q].defaultSelected = false;\");\r\n  }\r\n\r\n  eval(\"document.frmMdclMentalAssmt.\"+fieldName+\".value = \\\"");
      out.print(ulIdPersonProfessional);
      out.write("\\\"\");\r\n  if(  eval(\"document.frmMdclMentalAssmt.\"+fieldName+\".selectedIndex != -1\"))\r\n  {\r\n    eval(\"document.frmMdclMentalAssmt.\"+fieldName+\".options[document.frmMdclMentalAssmt.\"+fieldName+\".selectedIndex].defaultSelected = true\");\r\n  }\r\n}\r\n\r\n\r\nfunction submitProfID()\r\n{\r\n  disableValidation( \"frmMdclMentalAssmt\" );\r\n  window.onbeforeunload = null;\r\n  submitValidateForm( \"frmMdclMentalAssmt\", \"/investigation/MdclMentalAssmt/retrieveAddressPhoneInfo\" );\r\n}\r\n\r\nfunction checkIdevent()\r\n{\r\n   if ( document.frmMdclMentalAssmt.ulIdEvent.value == 0 )\r\n  {\r\n    alert( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEFORE_CONTINUE ) );
      out.write("\" );\r\n    return false;\r\n  }\r\n  return true;\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmMdclMentalAssmt");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/MdclMentalAssmt/displayMdclMentalAssmt");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.MdclMentalAssmtValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n     <td align=\"right\">\r\n        <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp;\r\n        <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n     </td>\r\n  </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"namesArray\" value=\"");
          out.print(SerializationHelper.serializeObject(namesList));
          out.write("\"/>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n  <tr><th colspan=\"6\">Professional Information</th></tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selSzNmProfAssmtName");
          _jspx_th_impact_validateSelect_0.setLabel("Name");
          _jspx_th_impact_validateSelect_0.setOnChange("submitProfID()");
          _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_0.setId("selSzNmProfAssmtName");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 150px");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setName("txtOther");
          _jspx_th_impact_validateInput_0.setLabel("Other");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setValue(szTxtProfAssmtOther);
          _jspx_th_impact_validateInput_0.setSize("40");
          _jspx_th_impact_validateInput_0.setMaxLength("40");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr><th colspan=\"6\">Visit information</th></tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selReason");
          _jspx_th_impact_validateSelect_1.setLabel("Reason");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setOptions( reasonsOptions );
          _jspx_th_impact_validateSelect_1.setValue(cdProfAssmtApptRsn);
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setName("txtDate");
          _jspx_th_impact_validateDate_0.setLabel("Visit Date");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue(dtProfAssmtAppt);
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setColspan("2");
          _jspx_th_impact_validateInput_1.setName("cbxOutOfNetworkAuth");
          _jspx_th_impact_validateInput_1.setLabel("Out of Network Authorization");
          _jspx_th_impact_validateInput_1.setValue("");
          _jspx_th_impact_validateInput_1.setChecked( outNwkAuthChecked );
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td valign=\"top\">\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtcomments");
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph80");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setMaxLength(80);
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("50");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.print(szTxtProfAssmtFindings);
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
 /*begin Address Phone Name Expandable section */ 
          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("MedMental");
          _jspx_th_impact_ExpandableSectionTag_0.setId("MedMental_id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Address/Phone Detail Name");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<table border=\"0\" cellSpacing=\"0\" cellPadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <td>\r\n            ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_0.setName("txtPhone");
              _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatPhone(NmlNbrProfAssmtPhone) );
              _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Phone");
              int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_1.setName("txtPhoneExt");
              _jspx_th_impact_validateDisplayOnlyField_1.setValue( NmlNbrPhoneExtension );
              _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Extension");
              int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_2.setName("addressStLn1");
              _jspx_th_impact_validateDisplayOnlyField_2.setValue(NmszAddrProfAssmtStLn1);
              _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Street");
              int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>&nbsp;</td>\r\n          <td>&nbsp;</td>\r\n        </tr>\r\n        <tr>\r\n          <td>&nbsp;</td>\r\n          <td>\r\n           ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_3.setName("addressStLn2");
              _jspx_th_impact_validateDisplayOnlyField_3.setValue(NmszAddrProfAssmtStLn2);
              int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n          <td>&nbsp;</td>\r\n          <td>&nbsp;</td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_4.setName("city");
              _jspx_th_impact_validateDisplayOnlyField_4.setValue(NmszAddrProfAssmtCity);
              _jspx_th_impact_validateDisplayOnlyField_4.setLabel("City");
              int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>\r\n            ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_5.setName("state");
              _jspx_th_impact_validateDisplayOnlyField_5.setValue(NmszAddrProfAssmtState);
              _jspx_th_impact_validateDisplayOnlyField_5.setLabel("State");
              int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_6.setName("zip");
              _jspx_th_impact_validateDisplayOnlyField_6.setValue(NmszAddrProfAssmtZip);
              _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Zip");
              int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td>\r\n          ");
 String EMPTY_STRING = "";
              out.write("\r\n            ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_7.setName("county");
              _jspx_th_impact_validateDisplayOnlyField_7.setValue(Lookup.simpleDecodeSafe( "CCOUNT" ,(cinv30so==null)? EMPTY_STRING: cinv30so.getSzCdProfAssmtCounty() ));
              _jspx_th_impact_validateDisplayOnlyField_7.setLabel("County");
              int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<br>\r\n\r\n");
/* BEGIN Admin Address Phone Submodule */
          out.write('\r');
          out.write('\n');

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

          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    AdminAddressPhoneSubDB adminAddressPhoneSubAdminAddressPhoneSubDB = AdminAddressPhoneSubDB.getFromRequest( request );
    String adminAddressPhoneSubFormName = adminAddressPhoneSubAdminAddressPhoneSubDB.getFormName();
    String adminAddressPhoneSubPageMode = adminAddressPhoneSubAdminAddressPhoneSubDB.getPageMode();
    String adminAddressPhoneSubAddressPhoneSectionHeader = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressPhoneSectionHeader();
    boolean adminAddressPhoneSubAddressRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressRequired();
    boolean adminAddressPhoneSubAddressDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isAddressDisabled();
    boolean adminAddressPhoneSubCommentsVisible = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsVisible();
    boolean adminAddressPhoneSubCommentsRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsRequired();
    boolean adminAddressPhoneSubCommentsDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isCommentsDisabled();
    boolean adminAddressPhoneSubPhoneRequired = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneRequired();
    boolean adminAddressPhoneSubPhoneDisabled = adminAddressPhoneSubAdminAddressPhoneSubDB.isPhoneDisabled();
    String adminAddressPhoneSubAddressSubmoduleName = adminAddressPhoneSubAdminAddressPhoneSubDB.getAddressSubmoduleName();
    String expandableSectionName = adminAddressPhoneSubAddressSubmoduleName + "addPhone";
    int adminAddressPhoneSubTabIndex = adminAddressPhoneSubAdminAddressPhoneSubDB.getTabIndex();

//  boolean commentsVisible = true;

    AdminAddressPhoneBean aapBean = null;
    if ( AdminAddressPhoneBean.isInRequest( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromRequest( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else if ( AdminAddressPhoneBean.isInState( adminAddressPhoneSubAddressSubmoduleName, request ) )
    {
      aapBean = (AdminAddressPhoneBean) aapBean.getFromState( adminAddressPhoneSubAddressSubmoduleName, request );
    }
    else
    {
      aapBean = new AdminAddressPhoneBean();
    }

          out.write("\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName( expandableSectionName );
          _jspx_th_impact_ExpandableSectionTag_1.setId(AdminAddressPhoneBean.PHONE + "_Id" );
          _jspx_th_impact_ExpandableSectionTag_1.setLabel( adminAddressPhoneSubAddressPhoneSectionHeader );
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( adminAddressPhoneSubTabIndex );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" class=\"tableBorder\">\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n      <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n        <tr>\r\n          <td width=\"10%\">\r\n              ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_2.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE ) );
              _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatPhone( aapBean.getPhone() ) );
              _jspx_th_impact_validateInput_2.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_2.setType("text");
              _jspx_th_impact_validateInput_2.setRequired( String.valueOf( adminAddressPhoneSubPhoneRequired ));
              _jspx_th_impact_validateInput_2.setLabel("Phone");
              _jspx_th_impact_validateInput_2.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_2.setCssClass("formInput");
              _jspx_th_impact_validateInput_2.setConstraint("Phone");
              _jspx_th_impact_validateInput_2.setWidth("45%");
              _jspx_th_impact_validateInput_2.setSize("14");
              _jspx_th_impact_validateInput_2.setMaxLength("14");
              int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
              if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td width=\"15%\">\r\n             ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_3.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE_EXT ) );
              _jspx_th_impact_validateInput_3.setValue( aapBean.getPhoneExt() );
              _jspx_th_impact_validateInput_3.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_3.setType("text");
              _jspx_th_impact_validateInput_3.setLabel("Extension");
              _jspx_th_impact_validateInput_3.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_3.setCssClass("formInput");
              _jspx_th_impact_validateInput_3.setConstraint("PhoneExtension");
              _jspx_th_impact_validateInput_3.setWidth("30%");
              _jspx_th_impact_validateInput_3.setSize("8");
              _jspx_th_impact_validateInput_3.setMaxLength("8");
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           </td>\r\n        </tr>\r\n      </table>\r\n     </td>\r\n   </tr>\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n");
/* BEGIN Address Submodule */
              out.write('\r');
              out.write('\n');

    AddressSubDB adminAddressPhoneAddressSubDB = new AddressSubDB();
    adminAddressPhoneAddressSubDB.setFormName( adminAddressPhoneSubFormName );
    adminAddressPhoneAddressSubDB.setPageMode( adminAddressPhoneSubPageMode );
    adminAddressPhoneAddressSubDB.setAddressSubmoduleName( adminAddressPhoneSubAddressSubmoduleName );
    adminAddressPhoneAddressSubDB.setCommentsVisible( adminAddressPhoneSubCommentsVisible );
    adminAddressPhoneAddressSubDB.setCommentsRequired( adminAddressPhoneSubCommentsRequired );
    adminAddressPhoneAddressSubDB.setCommentsDisabled( adminAddressPhoneSubCommentsDisabled );
    adminAddressPhoneAddressSubDB.setAddressRequired( adminAddressPhoneSubAddressRequired );
    adminAddressPhoneAddressSubDB.setAddressDisabled( adminAddressPhoneSubAddressDisabled );
    adminAddressPhoneAddressSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
    AddressSubDB.setIntoRequest( adminAddressPhoneAddressSubDB, request );

              out.write("\r\n        ");
              out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n");

  {
    AddressSubDB addressSubAddressSubDB = AddressSubDB.getFromRequest( request );
    String addressSubFormName = addressSubAddressSubDB.getFormName();
    String addressSubPageMode = addressSubAddressSubDB.getPageMode();
    String addressSubAddressSubmoduleName = addressSubAddressSubDB.getAddressSubmoduleName();
    boolean addressSubCommentsVisible = addressSubAddressSubDB.isCommentsVisible();
    boolean addressSubCommentsRequired = addressSubAddressSubDB.isCommentsRequired();
    boolean addressSubCommentsDisabled = addressSubAddressSubDB.isCommentsDisabled();
    boolean addressSubStreetRequired = addressSubAddressSubDB.isStreetRequired();
    boolean addressSubZipRequired = addressSubAddressSubDB.isZipRequired();
    boolean addressSubAddressRequired = addressSubAddressSubDB.isAddressRequired();
    boolean addressSubAddressDisabled = addressSubAddressSubDB.isAddressDisabled();
    int addressSubTabIndex = addressSubAddressSubDB.getTabIndex();
    ArrayList<String> addressSubExcludeCounty = addressSubAddressSubDB.getExcludeCounty();

    AddressBean addressBean = null;
    addressSubAddressSubmoduleName = FormattingHelper.formatString( addressSubAddressSubmoduleName );
    if ( AddressBean.isInRequest( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromRequest( addressSubAddressSubmoduleName, request );
    }
    else if ( AddressBean.isInState( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromState( addressSubAddressSubmoduleName, request );
    }
    else
    {
      addressBean = new AddressBean();
      addressBean.setAddressSubmoduleName( addressSubAddressSubmoduleName );
    }

    String changeAddress= "javascript:changeValidAddress( '" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n <tr>\r\n  <td width=\"10%\">\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_4.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
              _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
              _jspx_th_impact_validateInput_4.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_4.setType("text");
              _jspx_th_impact_validateInput_4.setRequired( String.valueOf( addressSubStreetRequired ));
              _jspx_th_impact_validateInput_4.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_4.setLabel("Street");
              _jspx_th_impact_validateInput_4.setWidth("45%");
              _jspx_th_impact_validateInput_4.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_4.setCssClass("formInput");
              _jspx_th_impact_validateInput_4.setConstraint("Address");
              _jspx_th_impact_validateInput_4.setSize("50");
              _jspx_th_impact_validateInput_4.setMaxLength("30");
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_5.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
              _jspx_th_impact_validateInput_5.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
              _jspx_th_impact_validateInput_5.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_5.setType("text");
              _jspx_th_impact_validateInput_5.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_5.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              _jspx_th_impact_validateInput_5.setConstraint("Address");
              _jspx_th_impact_validateInput_5.setSize("50");
              _jspx_th_impact_validateInput_5.setMaxLength("30");
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_6.setName( addressBean.getAttributeName( AddressBean.CITY ) );
              _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatString( addressBean.getCity() ));
              _jspx_th_impact_validateInput_6.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_6.setType("text");
              _jspx_th_impact_validateInput_6.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateInput_6.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_6.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_6.setLabel("City");
              _jspx_th_impact_validateInput_6.setCssClass("formInput");
              _jspx_th_impact_validateInput_6.setConstraint("City");
              _jspx_th_impact_validateInput_6.setMaxLength("20");
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n");

    // default the state to Georgia, override default if the state is set
    String stateDefault = CodesTables.CSTATE_GA;
    if ( StringHelper.isValid( addressBean.getState() ) )
    {
     stateDefault = addressBean.getState();
    }
    else if ( StringHelper.isValid( addressBean.getCounty() ) )
    {
     stateDefault = "";
    }

    String onChange= changeAddress + "toggleCounty('" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

              out.write("\r\n    <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_2.setName( addressBean.getAttributeName( AddressBean.STATE ));
              _jspx_th_impact_validateSelect_2.setValue( FormattingHelper.formatString( stateDefault ) );
              _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_2.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CSTATE );
              _jspx_th_impact_validateSelect_2.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_2.setOnChange( onChange );
              _jspx_th_impact_validateSelect_2.setLabel("State");
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_7.setName( addressBean.getAttributeName( AddressBean.ZIP ));
              _jspx_th_impact_validateInput_7.setValue(FormattingHelper.formatString( addressBean.getZip() ));
              _jspx_th_impact_validateInput_7.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_7.setRequired( String.valueOf( addressSubZipRequired  ));
              _jspx_th_impact_validateInput_7.setType("text");
              _jspx_th_impact_validateInput_7.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_7.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_7.setLabel("Zip");
              _jspx_th_impact_validateInput_7.setCssClass("formInput");
              _jspx_th_impact_validateInput_7.setConstraint("Zip");
              _jspx_th_impact_validateInput_7.setMaxLength("5");
              _jspx_th_impact_validateInput_7.setSize("5");
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      -\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_8.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
              _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
              _jspx_th_impact_validateInput_8.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_8.setType("text");
              _jspx_th_impact_validateInput_8.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_8.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_8.setCssClass("formInput");
              _jspx_th_impact_validateInput_8.setConstraint("ZipSuff");
              _jspx_th_impact_validateInput_8.setMaxLength("4");
              _jspx_th_impact_validateInput_8.setSize("4");
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n            ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_3.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
              _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
              _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_3.setRequired( String.valueOf( addressSubAddressRequired ) );
              _jspx_th_impact_validateSelect_3.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_3.setBlankValue("true");
              _jspx_th_impact_validateSelect_3.setLabel("County");
              _jspx_th_impact_validateSelect_3.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_3.setExcludeOptions(addressSubExcludeCounty);
              _jspx_th_impact_validateSelect_3.setOnChange( changeAddress );
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

              out.write("\r\n  <tr>\r\n   <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateTextArea_1.setLabel("Comments");
              _jspx_th_impact_validateTextArea_1.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
              _jspx_th_impact_validateTextArea_1.setRequired( String.valueOf( addressSubCommentsRequired ) );
              _jspx_th_impact_validateTextArea_1.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
              _jspx_th_impact_validateTextArea_1.setCols("125");
              _jspx_th_impact_validateTextArea_1.setRows("4");
              _jspx_th_impact_validateTextArea_1.setColspan("3");
              _jspx_th_impact_validateTextArea_1.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_1.setMaxLength(300);
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(addressBean.getComments() ));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n");

    }

              out.write("\r\n</table>\r\n");

    if ( !addressSubAddressDisabled && !EditableMode.isCompatibleWith( addressSubPageMode, EditableMode.VIEW ) )
    {

              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

    String onclick = "javascript:setIsDirtyCalled(true);" +
                     "launchAddressValidate('" + addressSubFormName + "', 'validate', '" +
                     addressBean.getAddressSubmoduleName() + "');return false;";

              out.write("\r\n    <td class=\"alignRight\">\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_0.setName("btnvalidate");
              _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_0.setAction("#");
              _jspx_th_impact_ButtonTag_0.setFunction(onclick);
              _jspx_th_impact_ButtonTag_0.setForm(addressSubFormName);
              _jspx_th_impact_ButtonTag_0.setTabIndex(addressSubTabIndex);
              _jspx_th_impact_ButtonTag_0.setOnBlur("setIsDirtyCalled(false);");
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_ExpandableSectionTag_1, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_ExpandableSectionTag_1, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_11.setType("hidden");
              _jspx_th_impact_validateInput_11.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
              _jspx_th_impact_validateInput_11.setValue("true");
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_12.setType("hidden");
              _jspx_th_impact_validateInput_12.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
              _jspx_th_impact_validateInput_12.setValue("true");
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_13.setType("hidden");
              _jspx_th_impact_validateInput_13.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
              _jspx_th_impact_validateInput_13.setValue("");
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_14.setType("hidden");
              _jspx_th_impact_validateInput_14.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
              _jspx_th_impact_validateInput_14.setValue("");
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n<script language=\"javascript\">\r\n//Run this script to protect the county on start up.\r\ntoggleCounty('");
              out.print( addressSubFormName );
              out.write("', '");
              out.print( addressSubAddressSubmoduleName );
              out.write("');\r\n</script>\r\n");

    addressSubAddressSubDB.setTabIndex( addressSubTabIndex );
  }

              out.write('\r');
              out.write('\n');
              out.write('\r');
              out.write('\n');

    adminAddressPhoneSubTabIndex = adminAddressPhoneAddressSubDB.getTabIndex();
    AddressSubDB.removeFromRequest( request );

              out.write('\r');
              out.write('\n');
/* END Address Submodule */
              out.write("\r\n     </td>\r\n   </tr>\r\n </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    adminAddressPhoneSubAdminAddressPhoneSubDB.setTabIndex( adminAddressPhoneSubTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');

  tabIndex = adminAddressPhoneSubDB.getTabIndex();
  AdminAddressPhoneSubDB.removeFromRequest( request );

          out.write('\r');
          out.write('\n');
/* END Admin Address Phone Submodule */
          out.write("\r\n<br>\r\n<hr>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td width=\"5%\">\r\n      ");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmMdclMentalAssmt");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck( fieldsToBeSpellChecked );
          _jspx_th_impact_spellCheck_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"5%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveFinal");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setForm("frmMdclMentalAssmt");
          _jspx_th_impact_ButtonTag_1.setAction("/investigation/MdclMentalAssmt/saveMdclMentalAssmt");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"szCdEventType\" value=\"");
          out.print( szCdEventType );
          out.write("\">\r\n<input type=\"hidden\" name=\"dtDtEventOccurred\" value=\"");
          out.print( dtDtEventOccurred );
          out.write("\">\r\n<input type=\"hidden\" name=\"ulIdEvent\" value=\"");
          out.print( ulIdEvent );
          out.write("\">\r\n<input type=\"hidden\" name=\"ulIdStage\" value=\"");
          out.print( ulIdStage );
          out.write("\">\r\n<input type=\"hidden\" name=\"ulIdPerson\" value=\"");
          out.print( ulIdPerson );
          out.write("\">\r\n<input type=\"hidden\" name=\"szTxtEventDescr\" value=\"");
          out.print( szTxtEventDescr );
          out.write("\">\r\n<input type=\"hidden\" name=\"szCdTask\" value=\"");
          out.print( szCdTask );
          out.write("\">\r\n<input type=\"hidden\" name=\"szCdEventStatus\" value=\"");
          out.print( szCdEventStatus );
          out.write("\">\r\n<input type=\"hidden\" name=\"evtsLastUpdate\" value=\"");
          out.print(evtsLastUpdate);
          out.write("\">\r\n<input type=\"hidden\" name=\"ulIdPersonProfessional\" value=\"");
          out.print(ulIdPersonProfessional);
          out.write("\">\r\n<input type=\"hidden\" name=\"szNmProfAssmtName \" value=\"");
          out.print( szNmProfAssmtName  );
          out.write("\">\r\n<input type=\"hidden\" name=\"szNmProfAssmtPrincipal\" value=\"");
          out.print( szNmProfAssmtPrincipal );
          out.write("\">\r\n<input type=\"hidden\" name=\"dtWCDDtSystemDate\" value=\"");
          out.print( dtWCDDtSystemDate);
          out.write("\">\r\n<input type=\"hidden\" name=\"NmszTxtProfAssmtCmnts\" value=\"");
          out.print( NmszTxtProfAssmtCmnts);
          out.write("\">\r\n<input type=\"hidden\" name=\"tsLastUpdate\" value=\"");
          out.print( tsLastUpdate);
          out.write("\">\r\n<input type=\"hidden\" name=\"ulIdPersonPrincipal\" value=\"");
          out.print( ulIdPersonPrincipal );
          out.write("\">\r\n\r\n<input type=\"hidden\" name=\"approverUlIdEvent\" value=\"");
          out.print( approverUlIdEvent);
          out.write("\">\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(' ');
 /* Close Validate Form Custom Tag */ 
      out.write("\r\n\r\n");

 // Scriplet to protect document
 pageMode = PageModeConstants.MODIFY;
 boolean protectDoc = false;
 if (pageMode == PageModeConstants.VIEW)
 {
   protectDoc = true;
 }
 // SIR STGAP00002094 Displays the blank narrative  

      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n      ");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode( pageMode );
      _jspx_th_impact_documentButton_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n        ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("Health Narrative");
          _jspx_th_impact_document_0.setName("frmDocumentTag");
          _jspx_th_impact_document_0.setProtectDocument( protectDoc );
          _jspx_th_impact_document_0.setCheckStage( GlobalData.getUlIdStage(request) );
          _jspx_th_impact_document_0.setPostInSameWindow(false);
          _jspx_th_impact_document_0.setDocType("PRFASSMT");
          _jspx_th_impact_document_0.setDocExists( bIndBLOBExistsInDatabase );
          _jspx_th_impact_document_0.setOnClick("checkIdevent()");
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sEvent");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf( GlobalData.getUlIdEvent(request) ) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("sCase");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf( GlobalData.getUlIdCase(request) ) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n\r\n");

//****************************
//**** REPORTS START HERE ****
//****************************

      out.write('\r');
      out.write('\n');
/* BEGIN: Forms and Reports */
      out.write("\r\n\r\n");
/* END: Forms and Reports */
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    _jspx_th_impact_validateErrors_0.setFormName("frmMdclMentalAssmt");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_9.setValue("0");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_10.setValue("0");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
