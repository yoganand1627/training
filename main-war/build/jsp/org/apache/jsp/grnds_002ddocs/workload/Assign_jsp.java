package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AvailStaffGroup_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.AssignConversation;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class Assign_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
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


//*  JSP Name:     Assign JSP
//*  Created by:   Bryon Jacob
//*  Date Created: 1/8/2003
//*
//*  Description:
//*  This page is used to assign a stage or unit of work from a user's workload
//*  to someone else in IMPACT.
//*
//** Change History:
//**  Date        User              Description
//**  --------    ----------------  ----------------------------------------------
//**  07/10/2003  DOUGLACS          SIR 18728 - hyperlink doesn't work if name
//**                                includes apostrophe
//**  08/07/2003  Todd Reser        Added Description.
//**  06/21/2004  wadesa            SIR 23695 - Added hidden field to JSP for CRSR
//**                                enhancement.
//**  07/24/05     Mike Werle        SIR 23728 - Moved constants for code reuse in MPS
//**  08/08/05    gerryc            SIR 22556 - increased size of Assignments section
//**                                from 20 rows to 100, since we will now always be
//**                                showing primary and secondary.



      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 /* Import State Management classes - Should be on every page */ 
      out.write("\r\n\r\n\r\n");
 /* Import PageMode and other utilities used on the page - Should be on every page */ 
      out.write("\r\n\r\n\r\n");
/* Import needed for Messages */ 
      out.write("\r\n\r\n\r\n");
/* Import needed for Form Launch */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<!-- Line 1 This is to see where this line is when opened from the browser -->\r\n");

// grab the page state and the lookup service output object
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
CCMN80SO ccmn80so = (CCMN80SO)state.getAttribute("CCMN80SO", request);
if ( ccmn80so == null )
{
  // Service can fail on MSG_CMN_ASSIGN_ON_CALL exception.
  ccmn80so = new CCMN80SO();
}

// get the arrays of available staff and current assignments to display
AvailStaffGroup_ARRAY availStaffGroup_array = ccmn80so.getAvailStaffGroup_ARRAY();
if ( availStaffGroup_array == null )
{
  // Service can fail on MSG_CMN_ASSIGN_ON_CALL exception.
  availStaffGroup_array = new AvailStaffGroup_ARRAY();
}
List assignments = (List)state.getAttribute(AssignConversation.ASSIGNMENTS_LIST, request);
if ( assignments == null )
{
  // Service can fail on MSG_CMN_ASSIGN_ON_CALL exception.
  assignments = new ArrayList();
}

// initialize the tabIndex to 0
int tabIndex = 1;

// get the on-call mode from the page state
Boolean onCallMode = ((Boolean)state.getAttribute(AssignConversation.ON_CALL, request));

// if it is null, set it to false
onCallMode = (onCallMode == null) ? Boolean.FALSE : onCallMode;

// get the selected county from the request
String selectedCounty = (String) state.getAttribute(AssignConversation.COUNTY_ATTR, request);
selectedCounty = "".equals(selectedCounty) ? "" : selectedCounty;

// get the name of the person whose phone information we are displaying
String phoneName = request.getParameter("txtPhonePerson");
if (phoneName == null)
{
  phoneName = GlobalData.getSzNmPersonFull(request);
}

String rbAvailableStaff = "";
if ( request.getAttribute( "rbAvailableStaff" ) != null )
{
  rbAvailableStaff = (String) request.getAttribute( "rbAvailableStaff" );
}


// get the dirty bit for assignments on this page
boolean assignDirty = state.getAttribute("assignDirty", request) != null;

// SIR 23695 - setup the hidden filed value used at bottom of page.  This filed is used to notify service
// if the intake is a CRSR APS case or a normal APS case. (if APS)
String tempDisposition = ContextHelper.getStringSafe(request, "hdnSzCdIncomingDisposition");

      out.write("\r\n\r\n<!-- Line 2 This is to see where this line is when opened from the browser -->\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction phoneDetail(ulIdPerson, txtPhonePerson)\r\n{\r\n  disableValidation( \"frmAssign\" );\r\n  submitValidateForm( \"frmAssign\" , \"/workload/Assign/displayAssign?ulIdPerson=\" + ulIdPerson + \"&txtPhonePerson=\" + txtPhonePerson);\r\n}\r\n\r\nfunction updatePrimary()\r\n{\r\n  ");
/*SIR 22556 */
      out.write("\r\n document.frmAssign.hdnPrimaryInd.value = \"Y\";\r\n}\r\n\r\nfunction Primary()\r\n{\r\n     return confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CMN_CONFIRM_PRIMARY) );
      out.write("');\r\n}      \r\n      \r\n\r\n\r\nfunction setSaveFlag()\r\n{\r\n  document.frmAssign.bSave.value = 'true';\r\n}\r\n\r\n\r\n");

// if we have made any assignments on this page...
  if (assignDirty)
  {

      out.write("\r\nwindow.onbeforeunload = function ()\r\n{\r\n  // Since the page doesnt its own dirty checks, we dont call is dirty. But this\r\n  // is essentially what isDirty returns.\r\n  if (document.frmAssign.bSave.value != 'true')\r\n  {\r\n    event.returnValue = \"Your unsaved data will be lost.\";\r\n    document.frmAssign.bSave.value = 'true';\r\n  }\r\n}\r\n");

  }

      out.write("\r\n</script>\r\n\r\n<!-------------------------------------------------------------------------------------------------\r\n !- Form - frmAssign\r\n !-\r\n !- the main form for the page, containing all controls except for the phone expandable section\r\n!------------------------------------------------------------------------------------------------>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAssign");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.AssignCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode(PageModeConstants.EDIT);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<!-------------------------------------------------------------------------------------------------\r\n !- Top Button Panel\r\n !-\r\n !- contains radio for selecting \"full unit\" or \"on-call\", drop-down for county, and \"search\"\r\n !- button for reloading the Available Staff table based on these selections.\r\n!------------------------------------------------------------------------------------------------>\r\n<table width=\"100%\" class=\"tableBorder\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <th colspan=\"4\">Search Parameters</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"4\">\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("radio");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setLabel("Full Unit (User's County Only)");
          _jspx_th_impact_validateInput_0.setName("rbFullUnitOrOnCall");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setValue("FULL_UNIT");
          _jspx_th_impact_validateInput_0.setChecked(String.valueOf(!onCallMode));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setLabel("On-call");
          _jspx_th_impact_validateInput_1.setName("rbFullUnitOrOnCall");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setValue("ON_CALL");
          _jspx_th_impact_validateInput_1.setChecked(String.valueOf(onCallMode.booleanValue()));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td align=\"right\">\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setLabel("County");
          _jspx_th_impact_validateSelect_0.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_0.setName("selSzCdOnCallCounty");
          _jspx_th_impact_validateSelect_0.setValue(selectedCounty);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <td colspan=\"4\" align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setAction("/workload/Assign/search");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setForm("frmAssign");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setFunction("document.frmAssign.bSave.value = 'true';");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n<!-------------------------------------------------------------------------------------------------\r\n !- Available Staff Table\r\n !-\r\n !- Displays the Available Staff for the view mode selected.  Clicking on a staff member's name\r\n !- populates the phone expandable section at the bottom of the page with the selected user's phone\r\n !- info.  Staff are selectable with the radio buttons on the left for assignment to stages.\r\n    !------------------------------------------------------------------------------------------------>\r\n<table width=\"100%\" class=\"tableBorder\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <th>Available Staff</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n\r\n<div id=\"scrollBar2\" style=\"height:152px;overflow:auto\" class=\"tableBorderList\">\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <th class=\"thList\"></th>\r\n");

  if (onCallMode)
  {

          out.write("\r\n    <th class=\"thList\">Staff Name</th>\r\n    <th class=\"thList\">Phone</th>\r\n    <th class=\"thList\">Ext</th>\r\n    <th class=\"thList\">On-Call Phone</th>\r\n    <th class=\"thList\">Ext</th>\r\n    <th class=\"thList\">Position</th>\r\n    <th class=\"thList\">Office Name</th>\r\n");

  }
  else
  {

          out.write("\r\n    <th class=\"thList\">Unit</th>\r\n    <th class=\"thList\">Staff Name</th>\r\n    <th class=\"thList\">Last Assigned</th>\r\n    <th class=\"thList\">Time</th>\r\n    <th class=\"thList\">Office Name</th>\r\n  </tr>\r\n");

  }
  int loopCount = 0;

  Boolean bIntakeAssign = ((String) state.getAttribute(AssignConversation.PREVIOUS_URL, request)).equals(
          AssignConversation.INTAKE_PAGE);
//  if ( bAssignmentList )
//  {
  Enumeration enumeration = null;

  ROWCCMN50DO_ARRAY ccmn50do_array =
      (ROWCCMN50DO_ARRAY)state.getAttribute(StaffSearchInput.STAFF_PULL_BACK, request);

  if ((ccmn50do_array == null || ccmn50do_array.getROWCCMN50DO().length == 0) &&
      (availStaffGroup_array == null || availStaffGroup_array.getAvailStaffGroup().length == 0))
  {
    if ( request.getAttribute( AssignConversation.ERROR_MESSAGE ) == null )
    {

          out.write("\r\n  <tr class=\"odd\">\r\n    <td colspan=\"7\">\r\n         ");
          out.print( MessageLookup.getMessageByNumber( Messages.MSG_CMN_NO_STAFF_IN_UNIT ) );
          out.write("\r\n    </td>\r\n  </tr>\r\n");

    }
    else
    {

          out.write("\r\n  <tr class=\"odd\">\r\n    <td colspan=\"7\">\r\n         ");
          out.print( (String) request.getAttribute( AssignConversation.ERROR_MESSAGE ) );
          out.write("\r\n    </td>\r\n  </tr>\r\n");

    }
  }

  if (ccmn50do_array != null)
  {
    enumeration = ccmn50do_array.enumerateROWCCMN50DO();
    while (enumeration.hasMoreElements())
    {
      ROWCCMN50DO rowccmn50do = (ROWCCMN50DO)enumeration.nextElement();

          out.write("\r\n  <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\">\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setName("rbAvailableStaff");
          _jspx_th_impact_validateInput_2.setValue(String.valueOf(rowccmn50do.getUlIdPerson()));
          _jspx_th_impact_validateInput_2.setChecked( ( rbAvailableStaff.equals( String.valueOf(rowccmn50do.getUlIdPerson()) ) ) ? "true" : "false" );
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

  //SIR 18728 - hyperlink doesn't work with names that include apostrophe
  StringBuffer strTemp = new StringBuffer();
  StringTokenizer split = new StringTokenizer(rowccmn50do.getSzNmPersonFull(), "'");
  strTemp.append(split.nextToken());
  while( split.hasMoreTokens() )
  {
    strTemp.append("\\'");
    strTemp.append(split.nextToken());
  }

  if (onCallMode)
  {

          out.write("\r\n    <td>\r\n      <table>\r\n        <tr>\r\n          <td>\r\n          <a href=\"javascript:phoneDetail( '");
          out.print(rowccmn50do.getUlIdPerson());
          out.write("', '");
          out.print(strTemp);
          out.write("' );\"\r\n               onClick=\"window.onbeforeunload=null; expandCollapsedWithFlag( 'expandedphoneArray', 'collapsedphoneArray', 'xpandphoneArray_Id' );\" tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\">\r\n               ");
          out.print(rowccmn50do.getSzNmPersonFull());
          out.write("\r\n          </a>\r\n        </td>\r\n          ");
 if( rowccmn50do.getBIndOverPolicyLimit() == true ){
          out.write("\r\n          <td>*</td>\r\n          ");
 } 
          out.write("\r\n         </tr>\r\n      </table>\r\n    </td>\r\n    <td>");
          out.print(FormattingHelper.formatPhone(rowccmn50do.getLSysNbrPersPhoneWork()));
          out.write("</td>\r\n    <td>");
          out.print(rowccmn50do.getLNbrPhoneExtension());
          out.write("</td>\r\n    <td><!--no on-call phone available for staff searched people...--></td>\r\n    <td><!--no on-call ext available for staff searched people...--></td>\r\n    <td><!--no on-call designation available for staff searched people...--></td>\r\n    <td>");
          out.print(rowccmn50do.getSzNmOfficeName());
          out.write("</td>\r\n");

  }
  else
  {

          out.write("\r\n    <td>");
          out.print(rowccmn50do.getSzNbrUnit());
          out.write("</td>\r\n    <td>\r\n      <table>\r\n        <tr>\r\n          <td>\r\n          <a href=\"javascript:phoneDetail( '");
          out.print(rowccmn50do.getUlIdPerson());
          out.write("', '");
          out.print(strTemp);
          out.write("' );\"\r\n                onClick=\"window.onbeforeunload=null; expandCollapsedWithFlag( 'expandedphoneArray', 'collapsedphoneArray', 'xpandphoneArray_Id' );\" tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\">\r\n                ");
          out.print(rowccmn50do.getSzNmPersonFull());
          out.write("\r\n          </a>\r\n        </td>\r\n          ");
 if( rowccmn50do.getBIndOverPolicyLimit() == true ){
          out.write("\r\n          <td>*</td>\r\n          ");
 } 
          out.write("\r\n         </tr>\r\n      </table>\r\n    </td>\r\n    <td>");
          out.print(FormattingHelper.formatDate(rowccmn50do.getDtDtEmpLastAssigned()));
          out.write("</td>\r\n    <td>");
          out.print(rowccmn50do.getTmScrTmEmpLastAssigned());
          out.write("</td>\r\n    <td>");
          out.print(rowccmn50do.getSzNmOfficeName());
          out.write("</td>\r\n  </tr>\r\n");

  }
  loopCount++;
    }
  }
  enumeration = availStaffGroup_array.enumerateAvailStaffGroup();
  while (enumeration.hasMoreElements())
  {
    AvailStaffGroup availStaffGroup = (AvailStaffGroup)enumeration.nextElement();

          out.write("\r\n  <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setName("rbAvailableStaff");
          _jspx_th_impact_validateInput_3.setValue(String.valueOf(availStaffGroup.getUlIdPerson()));
          _jspx_th_impact_validateInput_3.setChecked( ( rbAvailableStaff.equals( String.valueOf(availStaffGroup.getUlIdPerson()) ) ) ? "true" : "false" );
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

    //SIR 18728 - hyperlink doesn't work with names that include apostrophe
    StringBuffer strTemp = new StringBuffer();
    StringTokenizer split = new StringTokenizer(availStaffGroup.getSzNmPersonFull(), "'");
    strTemp.append(split.nextToken());
    while( split.hasMoreTokens() )
    {
      strTemp.append("\\'");
      strTemp.append(split.nextToken());
    }

  if (onCallMode)
  {

          out.write("\r\n    <td>\r\n      <table>\r\n        <tr>\r\n          <td>\r\n          <a href=\"javascript:phoneDetail( '");
          out.print(availStaffGroup.getUlIdPerson());
          out.write("', '");
          out.print(strTemp);
          out.write("' );\"\r\n              onClick=\"window.onbeforeunload=null; expandCollapsedWithFlag( 'expandedphoneArray', 'collapsedphoneArray', 'xpandphoneArray_Id' );\" tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\">\r\n              ");
          out.print(availStaffGroup.getSzNmPersonFull() != null ? availStaffGroup.getSzNmPersonFull() : "&nbsp;");
          out.write("\r\n          </a>\r\n        </td>\r\n          ");
 if( availStaffGroup.getBIndOverPolicyLimit() == true ){
          out.write("\r\n          <td>*</td>\r\n          ");
 } 
          out.write("\r\n         </tr>\r\n      </table>\r\n    </td>\r\n    \r\n    <td>");
          out.print(availStaffGroup.getLNbrPhone() != null ? FormattingHelper.formatPhone(availStaffGroup.getLNbrPhone()) : "&nbsp;");
          out.write("</td>\r\n    <td>");
          out.print(availStaffGroup.getLNbrPhoneExtension() != null ? availStaffGroup.getLNbrPhoneExtension() : "&nbsp;");
          out.write("</td>\r\n    <td>");
          out.print(availStaffGroup.getSzNbrEmpOnCallPhone1() != null ?
                FormattingHelper.formatPhone(availStaffGroup.getSzNbrEmpOnCallPhone1()) : "&nbsp;");
          out.write("</td>\r\n    <td>");
          out.print(availStaffGroup.getLNbrEmpOnCallExt1() != null ? availStaffGroup.getLNbrEmpOnCallExt1() : "&nbsp;");
          out.write("</td>\r\n    <td>");
          out.print(availStaffGroup.getSzCdEmpOnCallDesig() != null ? availStaffGroup.getSzCdEmpOnCallDesig() : "&nbsp;");
          out.write("</td>\r\n    <td>");
          out.print(availStaffGroup.getSzNmOfficeName() != null ? availStaffGroup.getSzNmOfficeName() : "&nbsp;");
          out.write("</td>\r\n");

  }
  else
  {

          out.write("\r\n    <td>");
          out.print(availStaffGroup.getSzNbrUnit());
          out.write("</td>\r\n    <td>\r\n      <table>\r\n          <tr>\r\n            <td>\r\n            <a href=\"javascript:phoneDetail( '");
          out.print(availStaffGroup.getUlIdPerson());
          out.write("', '");
          out.print(strTemp);
          out.write("' );\"\r\n                onClick=\"window.onbeforeunload=null; expandCollapsedWithFlag( 'expandedphoneArray', 'collapsedphoneArray', 'xpandphoneArray_Id' );\" tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\">\r\n                ");
          out.print(availStaffGroup.getSzNmPersonFull());
          out.write("\r\n              </a>\r\n          </td>\r\n            ");
 if( availStaffGroup.getBIndOverPolicyLimit() == true ){
          out.write("\r\n            <td>*</td>\r\n            ");
 } 
          out.write("\r\n           </tr>\r\n        </table>\r\n      \r\n    </td>\r\n    <td>");
          out.print(FormattingHelper.formatDate(availStaffGroup.getDtDtEmpLastAssigned()));
          out.write("</td>\r\n    <td>");
          out.print(availStaffGroup.getTmScrTmEmpLastAssigned());
          out.write("</td>\r\n    <td>");
          out.print(availStaffGroup.getSzNmOfficeName());
          out.write("</td>\r\n  </tr>\r\n");

  }
  loopCount++;
  }
//  }

          out.write("\r\n</table>\r\n</div>\r\n\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<!-------------------------------------------------------------------------------------------------\r\n !- Center Button Panel\r\n !-\r\n !- Contains buttons for assigning the currently selected Staff member as the Primary or Secondary\r\n !- asignee to the current stage(s), and a \"Staff\" button for searching for staff members by search\r\n !- criteria.\r\n    !------------------------------------------------------------------------------------------------>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setAction("/workload/Assign/assignPrimary");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_1.setForm("frmAssign");
          _jspx_th_impact_ButtonTag_1.setImg("btnPrimary");
          _jspx_th_impact_ButtonTag_1.setName("btnPrimary");
          _jspx_th_impact_ButtonTag_1.setFunction("updatePrimary(); return Primary(); document.frmAssign.bSave.value = 'true'; ");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setAction("/workload/Assign/assignSecondary");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_2.setForm("frmAssign");
          _jspx_th_impact_ButtonTag_2.setImg("btnSecondary");
          _jspx_th_impact_ButtonTag_2.setDisabled( bIntakeAssign.toString() );
          _jspx_th_impact_ButtonTag_2.setFunction("document.frmAssign.bSave.value = 'true';");
          _jspx_th_impact_ButtonTag_2.setName("btnSecondary");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setAction("/workload/Assign/staff");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_3.setForm("frmAssign");
          _jspx_th_impact_ButtonTag_3.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_3.setName("btnStaff");
          _jspx_th_impact_ButtonTag_3.setFunction("document.frmAssign.bSave.value = 'true';");
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n<!-------------------------------------------------------------------------------------------------\r\n !- Assignments Table\r\n !-\r\n !- Shows the assignments for the current stage(s).  This view represents the current local state,\r\n !- including any unsaved changes the user has made to the assignments.\r\n!------------------------------------------------------------------------------------------------>\r\n<table width=\"100%\" class=\"tableBorder\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <th>\r\n    Assignments\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n");
          out.write("\r\n<div id=\"scrollBar2\" style=\"height:152px;overflow:auto\" class=\"tableBorder\">\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <th class=\"thList\"></th>\r\n    <th class=\"thList\">Stage Name</th>\r\n    <th class=\"thList\">Name</th>\r\n    <th class=\"thList\">Primary/Secondary</th>\r\n  </tr>\r\n");

  Iterator it = assignments.iterator();

    loopCount = 0;
    while (it.hasNext())
    {
      AssignmentGroup assignmentGroup = (AssignmentGroup)it.next();
      //SIR 18728 - hyperlink doesn't work with names that include apostrophe
      StringBuffer strTemp = new StringBuffer();
      StringTokenizer split = new StringTokenizer( assignmentGroup.getSzNmPersonFull(), "'");
      strTemp.append(split.nextToken());
      while( split.hasMoreTokens() )
      {
        strTemp.append("\\'");
        strTemp.append(split.nextToken());
      }

          out.write("\r\n  <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\">\r\n    <td>\r\n");

  if (!"PR".equals(assignmentGroup.getSzCdStagePersRole()))
  {

          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setName("rbAssignments");
          _jspx_th_impact_validateInput_4.setValue(String.valueOf(loopCount));
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  }

          out.write("\r\n    </td>\r\n    <td>");
          out.print(assignmentGroup.getSzNmStage());
          out.write("</td>\r\n    <td>\r\n      <a href=\"javascript:phoneDetail( '");
          out.print(assignmentGroup.getUlIdPerson());
          out.write("', '");
          out.print(strTemp);
          out.write("' );\"\r\n         onClick=\"window.onbeforeunload=null; expandCollapsedWithFlag( 'expandedphoneArray', 'collapsedphoneArray', 'xpandphoneArray_Id' );\" tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\">\r\n         ");
          out.print(assignmentGroup.getSzNmPersonFull());
          out.write("\r\n      </a>\r\n    </td>\r\n    <td>");
          out.print("PR".equals(assignmentGroup.getSzCdStagePersRole()) ? "Primary" : "Secondary");
          out.write("</td>\r\n  </tr>\r\n");

  loopCount++;
    }

          out.write("\r\n</table>\r\n</div>\r\n\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<!-------------------------------------------------------------------------------------------------\r\n !- Bottom Button Panel\r\n !-\r\n !- Contains a button to Un-Assign the selected Secondary assignee, and a \"Save\" button to commit\r\n !- the current set of changes to the DB.\r\n !------------------------------------------------------------------------------------------------>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setAction("/workload/Assign/unAssign");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_4.setForm("frmAssign");
          _jspx_th_impact_ButtonTag_4.setImg("btnUnAssign");
          _jspx_th_impact_ButtonTag_4.setDisabled( bIntakeAssign.toString() );
          _jspx_th_impact_ButtonTag_4.setName("btnUnassign");
          _jspx_th_impact_ButtonTag_4.setFunction("document.frmAssign.bSave.value = 'true';");
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setAction("/workload/Assign/save");
          _jspx_th_impact_ButtonTag_5.setFunction("setSaveFlag()");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_5.setForm("frmAssign");
          _jspx_th_impact_ButtonTag_5.setImg("btnSave");
          _jspx_th_impact_ButtonTag_5.setName("btnSave");
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n<!-------------------------------------------------------------------------------------------------\r\n !- Phone Expandable Section\r\n !-\r\n !- Display the Phone Sub-Module with the currently selected staff member's phone details.\r\n !------------------------------------------------------------------------------------------------>\r\n\r\n  ");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_0.setPage( PhoneSubmoduleConversation.getUrl("PhoneSub", null) );
          _jspx_th_impact_include_0.setCallingPage("/workload/Assign/displayAssign");
          _jspx_th_impact_include_0.setTabIndex(tabIndex++);
          _jspx_th_impact_include_0.setIncludingForm("frmAssign");
          int _jspx_eval_impact_include_0 = _jspx_th_impact_include_0.doStartTag();
          if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_0.doInitBody();
            }
            do {
              out.write("\r\n    ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_0.setName( PhoneSubmoduleConversation.PHONE_EXPANDABLE_SECTION_LABEL );
              _jspx_th_impact_attribute_0.setValue( "".equals(phoneName.trim()) ? "Phone" : "Phone for " + phoneName);
              int _jspx_eval_impact_attribute_0 = _jspx_th_impact_attribute_0.doStartTag();
              if (_jspx_th_impact_attribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_1.setName( PhoneSubmoduleConversation.PAGE_MODE );
              _jspx_th_impact_attribute_1.setValue( PageModeConstants.VIEW );
              int _jspx_eval_impact_attribute_1 = _jspx_th_impact_attribute_1.doStartTag();
              if (_jspx_th_impact_attribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("  \r\n    \r\n");
              int evalDoAfterBody = _jspx_th_impact_include_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n<!-------------------------------------------------------------------------------------------------\r\n !- Hidden fields to persist state\r\n !- hdnSzCdIncomingDisposition:  SIR 23695 - used for flag to distinguish a APS CRSR intake\r\n !------------------------------------------------------------------------------------------------>\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("txtPhonePerson");
          _jspx_th_impact_validateInput_5.setValue( phoneName );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnSzCdIncomingDisposition");
          _jspx_th_impact_validateInput_6.setValue( tempDisposition );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n<input type=\"hidden\"  name=\"hdnPrimaryInd\">\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("bSave");
    _jspx_th_impact_validateInput_7.setValue("false");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
