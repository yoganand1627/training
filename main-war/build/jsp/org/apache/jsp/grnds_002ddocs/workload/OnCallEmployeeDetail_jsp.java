package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO;
import gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallConversation;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class OnCallEmployeeDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//--------------------------------------------------------------------------------
//  JSP Name:     On-Call Employee Detail
//  Created by:   Jason Rios
//  Date Created: 01/08/02
//
//  Description:
//  This JSP displays on-call employee data for the selected employee.
//
//  Change History:
//  Date      User              Description
//  --------  ----------------  --------------------------------------------------
//  10/23/03  Merle A Demo      SIR19889 OnCall schedule caused IndexArrayOutOfBounds
//                              exception. Changed the size of the array from 9 to 18
//                              in the .xds  9 delete rows and 9 add rows. The changes
//                              there are to stop the user from adding more than 9
//                              rows by adding a group that put the array over 9.
//  03/04/04  RIOSJA            SIR 22742 - Added hdnUlIdEmpOnCallLink hidden field
//                              so that the value can be used by validation routines
//                              in OnCallConversation.
//--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
//SIR19889
int numOfEmpsOnList = 0;
int numOfStaffToAdd = 0;

String fieldName = null;
String fieldValue = null;
boolean hasPerformedStaffSearch = false;

CCMN09SO ccmn09so_detail = null;
CCMN09SO ccmn09so_list = null;

BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

String pageMode = PageModeConstants.VIEW;
if( PageMode.getPageMode( request ) != null )
{
  pageMode = PageMode.getPageMode( request );
}
if ("/admin/StaffSearch/staffSearch".equals(ContextHelper.getPreviousUrl(request)) )
{
  pageMode = PageModeConstants.EDIT;
}

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
//SIR19889 Get the number of staff on the list already
ccmn09so_list = ( CCMN09SO )state.getAttribute( OnCallConversation.CCMN09SO_LIST, request );
if (ccmn09so_list != null)
{
  numOfEmpsOnList = ccmn09so_list.getROWCCMN21DO_ARRAY().getUlRowQty();
}

ccmn09so_detail = ( CCMN09SO )state.getAttribute( OnCallConversation.CCMN09SO_DETAIL, request );
//SIR19889 Get the number of staff to add to the list
numOfStaffToAdd = ccmn09so_detail.getROWCCMN21DO_ARRAY().getROWCCMN21DOCount();

if( state.getAttribute( OnCallConversation.PERFORMED_STAFF_SEARCH, request ) != null )
{
  hasPerformedStaffSearch = true;
}

      out.write("\r\n\r\n");

//******************
//*** JAVASCRIPT ***
//******************

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onload = function ()\r\n{\r\n  enableValidation(\"frmOnCallEmployeeDetail\");\r\n  enableValidation(\"frmOnCallEmployeeDetail\");\r\n  //SIR19889 tell users how many employee to delete\r\n  var numTotalLeft =  ");
      out.print( OnCallConversation.INT_MAX_ON_CALL_EMPLOYEES - numOfEmpsOnList   );
      out.write(";\r\n  var numToBeRemoved = ");
      out.print( numOfStaffToAdd );
      out.write(" - numTotalLeft;\r\n\r\n  if ( numToBeRemoved > 0 && !(numTotalLeft == 0))\r\n  {\r\n     alert(\"Rows left for Staff Members = \" + numTotalLeft + \"  Employees to be removed = \" + numToBeRemoved);\r\n  }\r\n};\r\n\r\n// Called before the page unloads to display the \"Are you sure\r\n// you want to navigate away from this page...\" message if the\r\n// user hasn't saved their changes.\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction setIndexOfEmployeeToRemove( index )\r\n{\r\n  if( confirm('Are you sure you want to remove this employee from the list?') )\r\n  {\r\n    document.frmOnCallEmployeeDetail.indexOfEmployeeToRemove.value = index;\r\n    disableValidation( 'frmOnCallEmployeeDetail' );\r\n    return true;\r\n  }\r\n  return false;\r\n}\r\n\r\n// Takes the user to the Staff Search page.\r\nfunction goToStaffSearch()\r\n{\r\n  var goToStaffSearch = true;\r\n  ");

  // If the user performed a Staff Search, but has not saved the
  // employees to the list, warn them that if they perform another
  // staff search, the employee data will not be saved. Also, disable
  // the isDirty() message since they will already have been warned
  // about losing their data.
  if( hasPerformedStaffSearch )
  {
      out.write("\r\n    goToStaffSearch = confirm(\"If you perform another Staff Search, the On-Call Employees on this page will not be saved.\\n\\nPress 'OK' to continue.\\n\\nPress 'Cancel' to remain on this page.\");\r\n    setIsDirtyCalled(true);\r\n  ");

  }
  
      out.write("\r\n  if( goToStaffSearch == true )\r\n  {\r\n    setState('frmOnCallEmployeeDetail');\r\n    setValidationUrl('frmOnCallEmployeeDetail', '/workload/OnCall/performStaffSearch');\r\n    disableValidation( 'frmOnCallEmployeeDetail' );\r\n    document.frmOnCallEmployeeDetail.submit();\r\n  }\r\n  else\r\n  {\r\n    // Since the user chose to stay on the page, enable isDirty()\r\n    // again so that if they attempt to navigate away from the page,\r\n    // they will be warned about losing their data.\r\n    setIsDirtyCalled(false);\r\n    return false;\r\n  }\r\n}\r\n</script>\r\n\r\n");

//*************************
//*** VALIDATION ERRORS ***
//*************************

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");

//********************************************
//**** FORM (EMPLOYEE DETAIL) STARTS HERE ****
//********************************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmOnCallEmployeeDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/OnCall/displayOnCallEmployee");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.OnCallCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");

Enumeration enumeration = ccmn09so_detail.getROWCCMN21DO_ARRAY().enumerateROWCCMN21DO();
while( enumeration.hasMoreElements() )
{
  ROWCCMN21DO employee = (ROWCCMN21DO)enumeration.nextElement();

  //RIOSJA, SIR 22742
  //--------------------------
  //---hdnUlIdEmpOnCallLink---
  //--------------------------
  fieldName = OnCallConversation.HDN_ID_EMP_ON_CALL_LINK + loopCounter;
  fieldValue = FormattingHelper.formatInt( employee.getUlIdEmpOnCallLink() );
  
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName( fieldName );
          _jspx_th_impact_validateInput_1.setValue( fieldValue );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");

  //-------------------
  //---hdnUlIdPerson---
  //-------------------
  fieldName = OnCallConversation.HDN_ID_PERSON + loopCounter;
  fieldValue = FormattingHelper.formatInt( employee.getUlIdPerson() );
  
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName( fieldName );
          _jspx_th_impact_validateInput_2.setValue( fieldValue );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");

  //--------------------------
  //---hdnSzNbrEmpHomePhone---
  //--------------------------
  fieldName = OnCallConversation.HDN_EMP_HOME_PHONE + loopCounter;
  fieldValue = employee.getLNbrPhone();
  
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName( fieldName );
          _jspx_th_impact_validateInput_3.setValue( fieldValue );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n    <tr><th colspan=\"7\">On-Call Employee Detail</th></tr>\r\n    <tr>\r\n      <td>\r\n        ");

        //--------------------
        //---szNmPersonFull---
        //--------------------
        fieldName = OnCallConversation.TXT_NM_PERSON_FULL + loopCounter;
        fieldValue = FormattingHelper.formatString( employee.getSzNmPersonFull() );
        
          out.write("\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setName( fieldName );
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( fieldValue );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      <td>\r\n        ");

        //---------------------------
        //---selSzCdEmpOnCallDesig---
        //---------------------------
        //fieldName = OnCallConversation.SEL_ONCALL_DESIG + loopCounter;
        //fieldValue = employee.getSzCdEmpOnCallDesig();
        //---------------------------
        //---selSzCdEmpOnCallProgram---
        //---------------------------
        fieldName = OnCallConversation.SEL_ONCALL_PROGRAM + loopCounter;
        //fieldValue = "BTH"; // need to get this from employee object
        fieldValue = employee.getSzCdOnCallProgram();
        
          out.write("\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Program Coverage");
          _jspx_th_impact_validateSelect_0.setName( fieldName );
          _jspx_th_impact_validateSelect_0.setValue( fieldValue );
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CCFB );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");

        //-------------------------------
        //---txtUsNbrEmpOnCallCntctOrd---
        //-------------------------------
        fieldName = OnCallConversation.TXT_EMP_ONCALL_CONTACT_ORD + loopCounter;
        fieldValue = FormattingHelper.formatInt( employee.getUsNbrEmpOnCallCntctOrd() );
        
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setLabel("Contact Order");
          _jspx_th_impact_validateInput_4.setName( fieldName );
          _jspx_th_impact_validateInput_4.setValue( fieldValue );
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setSize("1");
          _jspx_th_impact_validateInput_4.setMaxLength("1");
          _jspx_th_impact_validateInput_4.setRequired("true");
          _jspx_th_impact_validateInput_4.setConstraint("Digit1");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n        ");

        //--------------------
        //---txtSzTitle---
        //--------------------
        fieldName = OnCallConversation.TXT_TITLE + loopCounter;
        //fieldValue = FormattingHelper.formatString( employee.getSzNmPersonFull() );
        //fieldValue ="SSCM";
        fieldValue = FormattingHelper.formatString( employee.getSzCdTitle());
        
          out.write("\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Title");
          _jspx_th_impact_validateDisplayOnlyField_1.setName( fieldName );
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( fieldValue );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");

        //-----------------------------
        //---txtSzNbrEmpOnCallPhone1---
        //-----------------------------
        fieldName = OnCallConversation.TXT_EMP_ONCALL_PHONE1 + loopCounter;
        fieldValue = "";
        if ( employee.getSzNbrEmpOnCallPhone1() != null &&
            !"".equals(employee.getSzNbrEmpOnCallPhone1()) )
        {
          fieldValue = FormattingHelper.formatPhone( employee.getSzNbrEmpOnCallPhone1() );
        }
        
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setLabel("On-Call Phone");
          _jspx_th_impact_validateInput_5.setName( fieldName );
          _jspx_th_impact_validateInput_5.setValue( fieldValue );
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setSize("15");
          _jspx_th_impact_validateInput_5.setMaxLength("25");
          _jspx_th_impact_validateInput_5.setRequired("true");
          _jspx_th_impact_validateInput_5.setConstraint("Phone");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");

        //--------------------------
        //---txtLNbrEmpOnCallExt1---
        //--------------------------
        fieldName = OnCallConversation.TXT_EMP_ONCALL_EXT1 + loopCounter;
        fieldValue = employee.getLNbrEmpOnCallExt1();
        
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setLabel("Ext");
          _jspx_th_impact_validateInput_6.setName( fieldName );
          _jspx_th_impact_validateInput_6.setValue( fieldValue );
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setSize("15");
          _jspx_th_impact_validateInput_6.setMaxLength("25");
          _jspx_th_impact_validateInput_6.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");

        //-----------------------------
        //---txtSzNbrEmpOnCallPhone2---
        //-----------------------------
        fieldName = OnCallConversation.TXT_EMP_ONCALL_PHONE2 + loopCounter;
        fieldValue = "";
        if ( employee.getSzNbrEmpOnCallPhone2() != null &&
            !"".equals(employee.getSzNbrEmpOnCallPhone2()) )
        {
          fieldValue = FormattingHelper.formatPhone( employee.getSzNbrEmpOnCallPhone2() );
        }
        
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setLabel("Other Phone");
          _jspx_th_impact_validateInput_7.setName( fieldName );
          _jspx_th_impact_validateInput_7.setValue( fieldValue );
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setSize("15");
          _jspx_th_impact_validateInput_7.setMaxLength("25");
          _jspx_th_impact_validateInput_7.setConstraint("Phone");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");

        //--------------------------
        //---txtLNbrEmpOnCallExt2---
        //--------------------------
        fieldName = OnCallConversation.TXT_EMP_ONCALL_EXT2 + loopCounter;
        fieldValue = employee.getLNbrEmpOnCallExt2();
        
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setLabel("Ext");
          _jspx_th_impact_validateInput_8.setName( fieldName );
          _jspx_th_impact_validateInput_8.setValue( fieldValue );
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setSize("15");
          _jspx_th_impact_validateInput_8.setMaxLength("25");
          _jspx_th_impact_validateInput_8.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>&nbsp;</td>\r\n      ");

      // Allow the user to remove the employee from the list only if
      // they are adding new employees to the On-Call schedule after
      // performing a Staff Search.
      if( hasPerformedStaffSearch &&
         !employee.hasUlIdOnCall() )
      {
        String functionAsString = "return setIndexOfEmployeeToRemove(" + loopCounter + ")";
        
          out.write("\r\n        <td>\r\n          ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnRemove");
          _jspx_th_impact_ButtonTag_0.setImg("btnRemove");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmOnCallEmployeeDetail");
          _jspx_th_impact_ButtonTag_0.setFunction( functionAsString );
          _jspx_th_impact_ButtonTag_0.setAction("/workload/OnCall/removeEmployeeFromStaffSearchList");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      ");

      }
      
          out.write("\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"7\">\r\n        ");

        //*********************************
        //**** PHONE DETAIL SUB-MODULE ****
        //*********************************
        if ( employee.getUlIdPerson() > 0 )
        {
          out.write("\r\n          ");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_0.setPage( "/submodule/PhoneSubmoduleConversation/PhoneSub" );
          _jspx_th_impact_include_0.setCallingPage("/workload/OnCall/displayOnCallEmployee");
          _jspx_th_impact_include_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_include_0.setIncludingForm("frmOnCallEmployeeDetail");
          int _jspx_eval_impact_include_0 = _jspx_th_impact_include_0.doStartTag();
          if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_0.setName( PhoneSubmoduleConversation.PHONE_SUB_CREATED_FORM_FIELDS );
              _jspx_th_impact_attribute_0.setValue( (loopCounter > 0) ? "DONE" : null );
              int _jspx_eval_impact_attribute_0 = _jspx_th_impact_attribute_0.doStartTag();
              if (_jspx_th_impact_attribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_1.setName( PhoneSubmoduleConversation.PAGE_MODE );
              _jspx_th_impact_attribute_1.setValue( PageModeConstants.VIEW );
              int _jspx_eval_impact_attribute_1 = _jspx_th_impact_attribute_1.doStartTag();
              if (_jspx_th_impact_attribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_2.setName( PhoneSubmoduleConversation.PHONE_EXPANDABLE_SECTION_LABEL );
              _jspx_th_impact_attribute_2.setValue( "Phone" );
              int _jspx_eval_impact_attribute_2 = _jspx_th_impact_attribute_2.doStartTag();
              if (_jspx_th_impact_attribute_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_3.setName( PhoneSubmoduleConversation.PHONE_SUB_PERSON_ID );
              _jspx_th_impact_attribute_3.setValue( FormattingHelper.formatInt( employee.getUlIdPerson() ) );
              int _jspx_eval_impact_attribute_3 = _jspx_th_impact_attribute_3.doStartTag();
              if (_jspx_th_impact_attribute_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_4.setName( PhoneSubmoduleConversation.PHONE_SUB_PERSON_NAME );
              _jspx_th_impact_attribute_4.setValue( FormattingHelper.formatString( employee.getSzNmPersonFull() ) );
              int _jspx_eval_impact_attribute_4 = _jspx_th_impact_attribute_4.doStartTag();
              if (_jspx_th_impact_attribute_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");

          fieldValue = "OnCallEmployeePhoneSub" + loopCounter;
          
              out.write("\r\n          ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_5.setName( PhoneSubmoduleConversation.PHONE_SUB_NAME );
              _jspx_th_impact_attribute_5.setValue( "OnCallEmployeePhoneSub" + loopCounter );
              int _jspx_eval_impact_attribute_5 = _jspx_th_impact_attribute_5.doStartTag();
              if (_jspx_th_impact_attribute_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              int evalDoAfterBody = _jspx_th_impact_include_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");

        }
        
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  ");

  loopCounter++;
} // end while( enumeration.hasMoreElements() )

          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("numOfEmployees");
          _jspx_th_impact_validateInput_9.setValue( String.valueOf( loopCounter ) );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<hr>\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"90%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnStaff");
          _jspx_th_impact_ButtonTag_1.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmOnCallEmployeeDetail");
          _jspx_th_impact_ButtonTag_1.setFunction("return goToStaffSearch();");
          _jspx_th_impact_ButtonTag_1.setAction("/workload/OnCall/performStaffSearch");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnContinue");
          _jspx_th_impact_ButtonTag_2.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmOnCallEmployeeDetail");
          _jspx_th_impact_ButtonTag_2.setFunction("enableValidation( 'frmOnCallEmployeeDetail' )");
          _jspx_th_impact_ButtonTag_2.setAction("/workload/OnCall/saveOnCallEmployee");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

//******************************************
//**** FORM (EMPLOYEE DETAIL) ENDS HERE ****
//******************************************

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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("indexOfEmployeeToRemove");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
