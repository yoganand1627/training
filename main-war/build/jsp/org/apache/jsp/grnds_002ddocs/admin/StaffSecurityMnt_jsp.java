package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC14SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSecurityMntConversation;
import java.util.Enumeration;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class StaffSecurityMnt_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*   JSP Name:     Staff Security Maintenance
//*   Created by:   Eric Dickman
//*   Date Created: 10/10/02
//*
//*   Description:  The Staff Security Maintenance will allow
//*   the Security Administrator or PAC's to create, modify, or delete an
//*   employee's security profile composite, Logon ID, and Assignees.
//*   PACs will have the ability to remove profiles that are restricted to IT
//*   Security but will not be able to assign them.  A user can view this information
//*   if they have Browse Security access.
//*
//**  Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  10/09/02  Eric Dickman      Created initial docuement.
//**  03/27/03  Eric Dickman      QA Sweep
//**  05/29/03  Eric Dickman      SIR 17857 -- The validation class was not included
//**                              for the Staff Security Mnt Temp Form.
//**  06/12/03  Eric Dickman      SIR 18210 -- Moved the TEMP FORM with in the pullback
//**                              if statement.
//**  06/17/03  Eric Dickman      SIR 18299 --  The user most have
//**                              SEC_MNTN_LOGIN profile to modify the LOG-ON Textbox.
//**  07/24/05 Mike Werle    SIR 23728 - Moved constants for code reuse in MPS
//**
//**
//**

      out.write("\r\n\r\n\r\n");
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int tabIndex = 1;

  BaseSessionStateManager state = (BaseSessionStateManager)
                                  request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  //The bSecMntFlag is used to determine if a user is entering a page for the first time or is returning
  //from the pullback
  Boolean bSecMntFlag = (Boolean) state.getAttribute(StaffSecurityMntConversation.SEC_MNT_FLAG, request);
  //bSecMntFlag is true when editing a user; false when looking at a Designee
  boolean bPullbackMode = Boolean.FALSE.equals(bSecMntFlag);

  //A boolean used to enable/disbale the HRow, just before the save button
  boolean hr = false;

  UserProfile userProfile = StaffSecurityMntConversation.getUserProfile(request);
  String pageMode = PageModeConstants.EDIT;
  if( ( userProfile.hasRight( userProfile.SEC_CHG_USER_CLASS ) == false ) &&
      ( userProfile.hasRight( userProfile.SEC_RESTRICT_SEC ) == false ) &&
      ( userProfile.hasRight( userProfile.SEC_MNTN_LOGIN ) == false ) )
  {
    pageMode = PageModeConstants.VIEW;
  }
  PageMode.setPageMode( pageMode, request );

  CARC14SO carc14so = (CARC14SO)state.getAttribute("CARC14SO", request);
  int numRows = carc14so.getUlRowQty();


  //Checks to ensure that ROWCARC14SOG02_ARRAY is not null and creates a new object.
  ROWCARC14SOG02_ARRAY rowcarc14sog02Array = null;
  if ( carc14so.getROWCARC14SOG02_ARRAY() == null )
  {
    rowcarc14sog02Array = new ROWCARC14SOG02_ARRAY();
  }
  else
  {
    rowcarc14sog02Array = carc14so.getROWCARC14SOG02_ARRAY();
  }

  //Checks to ensure that ROWCARC14SOG01_ARRAY is not null and creates a new object.
  ROWCARC14SOG01_ARRAY rowcarc14sog01Array = null;
  if ( carc14so.getROWCARC14SOG01_ARRAY() == null )
  {
    rowcarc14sog01Array = new ROWCARC14SOG01_ARRAY();
  }
  else
  {
    rowcarc14sog01Array = carc14so.getROWCARC14SOG01_ARRAY();
  }

  //Checks to ensure that ROWCARC14SOG00_ARRAY is not null and creates a new object.
  ROWCARC14SOG00_ARRAY rowcarc14sog00Array = null;
  if ( carc14so.getROWCARC14SOG00_ARRAY() == null )
  {
    rowcarc14sog00Array = new ROWCARC14SOG00_ARRAY();
  }
  else
  {
    rowcarc14sog00Array = carc14so.getROWCARC14SOG00_ARRAY();
  }

  List checkedValueVector = CastorArrayHelper.getStringVector( rowcarc14sog02Array, "szNmSecurityClass" );

  //The selectedStaffID is used to print the Staff Name to the top of the Staff Security Mnt page
  Integer selectedStaffID = (Integer) state.getAttribute( StaffSecurityMntConversation.SELECTED_STAFF_ID, request );

  //Allows the ROWCARC14SOG01_ARRAY to be displayed in two different sections.
  //The IT Restricted Section Yes Array and the Security Profile section is the noArray.

  ROWCARC14SOG01_ARRAY yesArray = new ROWCARC14SOG01_ARRAY();
  ROWCARC14SOG01_ARRAY noArray = new ROWCARC14SOG01_ARRAY();

  //Enumerate's over ROWCARC14SOG01 splitting into two new arrays.  Which are yesArray and noArray.  noArray is
  //the Non-Restricted It Security Profiles.  yesArray is the Restricted Secutiy Profiles.
  for ( Enumeration sog01enum = rowcarc14sog01Array.enumerateROWCARC14SOG01(); sog01enum.hasMoreElements(); )
  {
    ROWCARC14SOG01 sog01 = ( ROWCARC14SOG01 ) sog01enum.nextElement();
    if ("Y".equals(sog01.getCIndRestrict()) )
    {
      yesArray.addROWCARC14SOG01( sog01 );
    }
    else
    {
      noArray.addROWCARC14SOG01( sog01 );
    }
  }

  // Enables and Disables Widgets on the page for SEC_CHG_USER_CLASS or Staff Search pullback
  // bPullback is a boolean that is passed from the Staff Search Detail to the user if they are in pullback
  // or entering the Staff Sec Mnt page for the first time.  If bPullback is false the page is returning from
  // Staff Search in pullback mode.  If the bPullback is null or Staff Sec Mnt is entered from Staff Search,
  // then bPullback is true.

  String chgUserClass = null;
  if(!userProfile.hasRight(userProfile.SEC_CHG_USER_CLASS) ||
     bPullbackMode)
  {
    chgUserClass = "true";
  }
  else
  {
    chgUserClass = "false";
    hr = true;
  }

  // Enables and disables widgets on the page for SEC_MNTN_LOGIN or Staff Search pullback


  String secLogin = null;
  //SIR 18299 -- The user most SEC_MNTN_LOGIN profile
  //to modify the LOG-ON Textbox.

  if(userProfile.hasRight(userProfile.SEC_MNTN_LOGIN) && !bPullbackMode)
  {
    secLogin  =  "false";
  }
  else
  {
    secLogin  =  "true";
  }

  //Disables only widgets that need to be hidden or disabled until the user saves the Designee Pullback section
  String pullBack = "false";
  String expDateDisable = "false";

  if(!userProfile.hasRight(userProfile.SEC_CHG_USER_CLASS))
  {
    pullBack = "true";
    expDateDisable = "true";
  }

   String protectThisIT = null;

   int DISABLED = 0;
   int ENABLED = 1;
   int CHECKED_OR_DISABLED = 2;
   int checkboxState = DISABLED;
   if ( bPullbackMode == false )
   {
     if (userProfile.hasRight(userProfile.SEC_RESTRICT_SEC) && userProfile.hasRight(userProfile.SEC_CHG_USER_CLASS))
     {
       checkboxState = ENABLED;
     }
     else if ( userProfile.hasRight(userProfile.SEC_CHG_USER_CLASS) )
     {
       checkboxState = CHECKED_OR_DISABLED;
       protectThisIT="Javascript:protectCheckbox(this)";
     }
   }

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n\r\n//Checks the Security Profile of the user entering the page.  Is user for the IT\r\n//Restricted Security Profiles\r\nwindow.onload = function ()\r\n{\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( (pageMode.equals(PageModeConstants.EDIT)) );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
          _jspx_th_impact_ifThen_1.setTest( ("true".equals(chgUserClass)) );
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    for (i = 1; i <= ");
              out.print( noArray.getROWCARC14SOG01Count() );
              out.write("; i++)\r\n    {\r\n      var cbx = \"document.frmStaffSecurityMaint.cbSecurityProfiles\" +i;\r\n      eval(cbx + \".disabled = true\");\r\n    }\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\nfor (i = 1; i <= ");
          out.print( yesArray.getROWCARC14SOG01Count() );
          out.write("; i++)\r\n{\r\n  var cbx = \"document.frmStaffSecurityMaint.cbITSecurityProfiles\" +i;\r\n  var cbxValue = eval(cbx + \".checked\");\r\n\r\n  var disabled = true;\r\n  if ( ( ");
          out.print( (checkboxState == ENABLED) );
          out.write(" ) ||\r\n       ( ( ");
          out.print( (checkboxState == CHECKED_OR_DISABLED) );
          out.write(" ) &&\r\n         ( ( cbxValue == true ) ) ) )\r\n  {\r\n    disabled = false;\r\n  }\r\n  eval(cbx + \".disabled = \" + disabled);\r\n}\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n}// end function\r\n\r\n  //Saves with zero security profiles checked or zero It Restricted Security profiles checked\r\n  function confirmOnZeroProfiles()\r\n  {\r\n       var confirmed = true;\r\n       var profBoxCount = ");
      out.print( noArray.getROWCARC14SOG01Count() );
      out.write(";\r\n       var itProfBoxCount = ");
      out.print( yesArray.getROWCARC14SOG01Count() );
      out.write(";\r\n       var secChgUserClass = ");
      out.print( userProfile.hasRight(userProfile.SEC_CHG_USER_CLASS) );
      out.write(";\r\n\r\n       if( !areAnyChecked(\"cbSecurityProfiles\", profBoxCount) &&\r\n           !areAnyChecked(\"cbITSecurityProfiles\", itProfBoxCount) &&\r\n           secChgUserClass)\r\n       {\r\n          var message = \"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SEC_CONFIRM_NO_PROF));
      out.write("\";\r\n          confirmed  = confirm (message);\r\n       }\r\n       return confirmed;\r\n  }\r\n\r\n  //Cancels Validation if the Designee totals more than five\r\n  function cancelValidation ()\r\n  {\r\n  ");
      //  impact:if
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
      _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_if_0.setParent(null);
      _jspx_th_impact_if_0.setTest( (numRows > 4) );
      int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
      if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    ");
          //  impact:then
          gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
          _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
          int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
          if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      this.setInformationalMessage('");
              out.print(MessageLookup.getMessageByNumber(Messages.MSG_SEC_TOO_MANY_DESIGNEES));
              out.write("');\r\n      return false;\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_else_0(_jspx_th_impact_if_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  }\r\n\r\n  //Confirm on Exit Message\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  };\r\n\r\n  //Sets variables to hidden fields\r\n  function setHiddenFields(DtAssignExpiration, UlIdEmpTempAssign , UlIdPerson2, UlIdPersonDesignee, TsLastUpdate)\r\n  {\r\n       document.frmStaffSecurityMaint.hdnDtAssignExpiration.value = DtAssignExpiration;\r\n       document.frmStaffSecurityMaint.hdnUlIdEmpTempAssign.value = UlIdEmpTempAssign;\r\n       document.frmStaffSecurityMaint.hdnUlIdPerson2.value = UlIdPerson2;\r\n       document.frmStaffSecurityMaint.hdnUlIdPersonDesignee.value = UlIdPersonDesignee;\r\n       document.frmStaffSecurityMaint.hdnTsLastUpdate.value = TsLastUpdate;\r\n  }\r\n\r\n  //Message for when a user wants to delete a Designee Of and give the user a alert if a\r\n  //radio button was not selected by the user.\r\n  function Delete()\r\n  {\r\n    var cont;\r\n    if( checkForSelection('document.frmStaffSecurityMaint.employeeName'))\r\n    {\r\n         cont = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) );
      out.write("');\r\n    }\r\n    else\r\n    {\r\n         alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) );
      out.write("');\r\n         cont = false;\r\n    }\r\n         return cont;\r\n  }\r\n\r\n  //Message will ask the user to com\r\n  function deleteTemp()\r\n  {\r\n    if ( confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) );
      out.write("') )\r\n    {\r\n      document.frmStaffSecurityMaintTmp.FormValidationCancel.value='true';\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      return false;\r\n    }\r\n  }\r\n\r\n    //Allows for the employeeName to be selected\r\n  function checkForSelection( objName )\r\n  {\r\n    var buttonChecked = false;\r\n    var obj = eval(objName);\r\n\r\n    if (obj != null)\r\n    {\r\n      if (obj.length == null)\r\n      {\r\n        if (obj.checked != false)\r\n        {\r\n          buttonChecked = true;\r\n        }\r\n      }\r\n      else\r\n      {\r\n        for (var i = 0; i < obj.length; ++i)\r\n        {\r\n          buttonChecked = buttonChecked || obj[i].checked;\r\n        }\r\n      }\r\n    }\r\n    return (buttonChecked);\r\n    }\r\n\r\n      //Allows It Restricted Checkboxs to be unchecked and not rechecked.\r\n      function protectCheckbox(cb)\r\n      {\r\n           cb.check = \"false\";\r\n           cb.disabled = \"true\";\r\n      }\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n  ");

    if (request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null &&
        selectedStaffID != null )
    {
      int selectedIdInt = selectedStaffID;

      ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY)
          request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);

      Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
      while ( e.hasMoreElements() )
      {
        ROWCCMN50DO staff = (ROWCCMN50DO)e.nextElement();
//SIR 17857 -- The validation class was not included for the Staff Security Mnt Temp Form

      out.write('\r');
      out.write('\n');

    // SIR 18210 -- Moved the if statement below, to above the frmStaffSecurityMaintTmp form.
    //  Locates the Logon Id above the Temporary Pullback page when adding a Designee Of.
    if ( bPullbackMode )
    {
      pullBack = "true";

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmStaffSecurityMaintTmp");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/StaffSecurityMnt/displayStaffSecurityMaint");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSecurityMntCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\r\n  <tr>\r\n    <td>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n        <tr>\r\n          <td width=\"100px\">\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setLabel("Logon ID");
          _jspx_th_impact_validateInput_0.setConstraint("NovellUsername");
          _jspx_th_impact_validateInput_0.setName("szIdEmployeeLogonTemp");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setValue( FormattingHelper.formatString(carc14so.getSzIdEmployeeLogon()) );
          _jspx_th_impact_validateInput_0.setSize("20");
          _jspx_th_impact_validateInput_0.setMaxLength("20");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++);
          _jspx_th_impact_validateInput_0.setDisabled( secLogin );
          _jspx_th_impact_validateInput_0.setRequired("true");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnLastUpdate");
          _jspx_th_impact_validateInput_1.setValue(gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper.toISOString(carc14so.getTsLastUpdate()));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnIdStaffMember");
          _jspx_th_impact_validateInput_2.setValue( String.valueOf( GlobalData.getUlIdStaff( request ) ));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <tr>\r\n    <td>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n        <tr>\r\n          <th width=\"3%\">&nbsp;</th>\r\n          <th width=\"37%\">Employee Name</th>\r\n          <th width=\"60%\">Expiration</th>\r\n        </tr>\r\n        <tr>\r\n           <td>\r\n             ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setName("rdnTempDesignee_CLEAN");
          _jspx_th_impact_validateInput_3.setChecked("true");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n           <td>\r\n             ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("StaffSzNmPersonFull");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatString(staff.getSzNmPersonFull()) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n             ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnIdPersonDesignee");
          _jspx_th_impact_validateInput_4.setValue( FormattingHelper.formatInt(staff.getUlIdPerson()));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           <td>\r\n             ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setValue("");
          _jspx_th_impact_validateDate_0.setName("tempDate");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++);
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTitle("Pullback Expiration");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n   </tr>\r\n   <tr>\r\n     <td>\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n         <tr>\r\n           <td>\r\n             ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDeleteTemp");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setFunction("return deleteTemp()");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setForm("frmStaffSecurityMaintTmp");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/StaffSecurityMnt/deleteTempDesigneeOf");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++);
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n           <td>\r\n             ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveTemp");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmStaffSecurityMaintTmp");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/StaffSecurityMnt/saveTempDesigneeOf");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n         </tr>\r\n       </table>\r\n     </td>\r\n  </tr>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n</table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

} //Closing of the LogId if statement

      out.write('\r');
      out.write('\n');

       } //end of for finding the number of designee of
    }

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmStaffSecurityMaint");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/admin/StaffSecurityMnt/displayStaffSecurityMaint");
      _jspx_th_impact_validateForm_1.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSecurityMntCustomValidation");
      _jspx_th_impact_validateForm_1.setPageMode( pageMode );
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ifThen_2.setTest( !bPullbackMode );
          int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
          if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n        <tr>\r\n          <td width=\"100\" >\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_validateInput_5.setType("text");
              _jspx_th_impact_validateInput_5.setLabel("Logon ID");
              _jspx_th_impact_validateInput_5.setConstraint("NovellUsername");
              _jspx_th_impact_validateInput_5.setName("szIdEmployeeLogon");
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              _jspx_th_impact_validateInput_5.setValue( FormattingHelper.formatString(carc14so.getSzIdEmployeeLogon()) );
              _jspx_th_impact_validateInput_5.setSize("20");
              _jspx_th_impact_validateInput_5.setMaxLength("20");
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++);
              _jspx_th_impact_validateInput_5.setDisabled( secLogin );
              _jspx_th_impact_validateInput_5.setRequired("true");
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnLastUpdate");
          _jspx_th_impact_validateInput_6.setValue(gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper.toISOString(carc14so.getTsLastUpdate()));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnIdStaffMember");
          _jspx_th_impact_validateInput_7.setValue( String.valueOf( GlobalData.getUlIdStaff( request ) ));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n        <tr>\r\n          <th width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">Designee Of</th>\r\n        </tr>\r\n          <tr>\r\n            <td>\r\n              <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorderList\" width=\"100%\">\r\n          <tr>\r\n                  <td class=\"thList\" width=\"3%\">&nbsp;</td>\r\n                  <td class=\"thList\" width=\"37%\">Employee Name</td>\r\n                  <td class=\"thList\" width=\"60%\">Expiration</td>\r\n                </tr>\r\n");

          int loopCount = 0;
          String UlIdEmpTempAssign = "";
          String UlIdPerson2 = "";
          String UlIdPersonDesignee = "";
          String SzNmPersonFull = "";
          String DtAssignExpiration = "";
          String TsLastUpdate2 = "";
          int messageCounter = rowcarc14sog00Array.getROWCARC14SOG00Count();

          //If the message counter is equal to zero, then return No Rows Returned Message
          if(messageCounter == 0)
          {

          out.write("\r\n               <tr class=\"odd\">\r\n                  <td colspan=\"4\">\r\n                    ");
          out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
          out.write("\r\n                  </td>\r\n               </tr>\r\n");

         }
          //Enumerations rowcarc14sog00Array and passed to Javascript function setHiddenFields
          Enumeration sog00enum = rowcarc14sog00Array.enumerateROWCARC14SOG00();
          while ( sog00enum.hasMoreElements() )
          {
            String DesigneeOfValue = Integer.toString(loopCount);
            ROWCARC14SOG00 sog00 = ( ROWCARC14SOG00 ) sog00enum.nextElement();

            UlIdEmpTempAssign = FormattingHelper.formatInt(sog00.getUlIdEmpTempAssign());
            UlIdPerson2 = FormattingHelper.formatInt(sog00.getUlIdPerson());
            UlIdPersonDesignee = FormattingHelper.formatInt(sog00.getUlIdPersonDesignee());
            SzNmPersonFull = sog00.getSzNmPersonFull();
            DtAssignExpiration = FormattingHelper.formatDate(sog00.getDtDtAssignExpiration());
            TsLastUpdate2 = DateHelper.toISOString(sog00.getTsLastUpdate());

          out.write("\r\n              <tr class = \"");
          out.print(FormattingHelper.getRowCss( loopCount + 1));
          out.write("\">\r\n                <td>\r\n");

                  String textName = "txtExpiration" + loopCount;
                  String IncOnClick =
                      "setHiddenFields( '" + DtAssignExpiration + "', '" +
                      UlIdEmpTempAssign  + "', '" +
                      UlIdPerson2 + "', '" +
                      UlIdPersonDesignee  + "', '" +
                      TsLastUpdate2  + "');";

          out.write("\r\n                  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setId("rdnemployeeName_CLEAN");
          _jspx_th_impact_validateInput_8.setName("employeeName");
          _jspx_th_impact_validateInput_8.setOnClick(IncOnClick);
          _jspx_th_impact_validateInput_8.setValue( DesigneeOfValue );
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setChecked("false");
          _jspx_th_impact_validateInput_8.setDisabled(pullBack);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n                <td>\r\n                  ");
          out.print( SzNmPersonFull );
          out.write("\r\n                </td>\r\n                <td>\r\n                  ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setValue( DtAssignExpiration );
          _jspx_th_impact_validateDate_1.setTitle("Expiration");
          _jspx_th_impact_validateDate_1.setName( textName );
          _jspx_th_impact_validateDate_1.setCssClass("formInput");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setRequired("true");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setDisabled(pullBack);
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                 </td>\r\n              </tr>\r\n");

           loopCount++;
         }


          out.write("\r\n    </table>\r\n   </td>\r\n  </tr>\r\n      </table>\r\n         ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnNbrExpDate");
          _jspx_th_impact_validateInput_9.setValue( FormattingHelper.formatInt(loopCount));
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         ");
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n         ");
          if (_jspx_meth_impact_validateInput_11(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n         ");
          if (_jspx_meth_impact_validateInput_12(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n         ");
          if (_jspx_meth_impact_validateInput_13(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n         ");
          if (_jspx_meth_impact_validateInput_14(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n         ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("hdnExpDateDisable");
          _jspx_th_impact_validateInput_15.setValue(expDateDisable);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n        <tr>\r\n           <td>\r\n");

  //if no Designee Exist the delete push button will be hidden
  if(messageCounter != 0)
  {

          out.write("\r\n             ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_2.setName("btnDelete");
          _jspx_th_impact_ButtonTag_2.setDisabled(pullBack);
          _jspx_th_impact_ButtonTag_2.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_2.setAlign("left");
          _jspx_th_impact_ButtonTag_2.setForm("frmStaffSecurityMaint");
          _jspx_th_impact_ButtonTag_2.setAction("/admin/StaffSecurityMnt/deleteDesigneeOf");
          _jspx_th_impact_ButtonTag_2.setFunction("return Delete()");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n");

  }

          out.write("\r\n           <td>\r\n             ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_3.setName("btnAdd");
          _jspx_th_impact_ButtonTag_3.setDisabled(pullBack);
          _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setFunction("return cancelValidation()");
          _jspx_th_impact_ButtonTag_3.setForm("frmStaffSecurityMaint");
          _jspx_th_impact_ButtonTag_3.setAction("/admin/StaffSecurityMnt/addDesigneeOf");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setNavAwayCk(true);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n        <tr>\r\n          <th>Security Profiles\r\n          </th>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_castorCheckbox_0.setCastorEnum( noArray.enumerateROWCARC14SOG01() );
          _jspx_th_impact_castorCheckbox_0.setName("cbSecurityProfiles");
          _jspx_th_impact_castorCheckbox_0.setCheckedValues( checkedValueVector );
          _jspx_th_impact_castorCheckbox_0.setLabelPropertyName("szNmSecurityClass");
          _jspx_th_impact_castorCheckbox_0.setValuePropertyName("szNmSecurityClass");
          _jspx_th_impact_castorCheckbox_0.setColumns(3);
          _jspx_th_impact_castorCheckbox_0.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_0.setIsHorizontal(true);
          _jspx_th_impact_castorCheckbox_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_castorCheckbox_0 = _jspx_th_impact_castorCheckbox_0.doStartTag();
          if (_jspx_th_impact_castorCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n      <br>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n        <tr>\r\n          <th>IT Restricted Security Profiles</th>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n");

            //Popluates the IT-Restricted Checkboxes (YesArray);

          out.write("\r\n            ");
          //  impact:castorCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
          _jspx_th_impact_castorCheckbox_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_castorCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_castorCheckbox_1.setCastorEnum( yesArray.enumerateROWCARC14SOG01() );
          _jspx_th_impact_castorCheckbox_1.setName("cbITSecurityProfiles");
          _jspx_th_impact_castorCheckbox_1.setCheckedValues( checkedValueVector );
          _jspx_th_impact_castorCheckbox_1.setLabelPropertyName("szNmSecurityClass");
          _jspx_th_impact_castorCheckbox_1.setValuePropertyName("szNmSecurityClass");
          _jspx_th_impact_castorCheckbox_1.setColumns(3);
          _jspx_th_impact_castorCheckbox_1.setIsRuled(false);
          _jspx_th_impact_castorCheckbox_1.setIsHorizontal(true);
          _jspx_th_impact_castorCheckbox_1.setOnClick( protectThisIT );
          _jspx_th_impact_castorCheckbox_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_castorCheckbox_1 = _jspx_th_impact_castorCheckbox_1.doStartTag();
          if (_jspx_th_impact_castorCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n");

  //Hide the HR if the save button is disabled
  if(hr == true)
  {

          out.write("\r\n  <tr>\r\n    <td>\r\n      <hr width=\"100%\">\r\n    </td>\r\n  </tr>\r\n");

  }

          out.write("\r\n  <tr>\r\n\r\n");

  if( !bPullbackMode )
  {

          out.write("\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_4.setName("btnSave");
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setFunction("return confirmOnZeroProfiles()");
          _jspx_th_impact_ButtonTag_4.setForm("frmStaffSecurityMaint");
          _jspx_th_impact_ButtonTag_4.setAction("/admin/StaffSecurityMnt/saveStaffSecurityMaint");
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

  }

          out.write("\r\n  </tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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

  private boolean _jspx_meth_impact_else_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:else
    gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
    _jspx_th_impact_else_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_else_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
    int _jspx_eval_impact_else_0 = _jspx_th_impact_else_0.doStartTag();
    if (_jspx_eval_impact_else_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n      document.frmStaffSecurityMaint.FormValidationCancel.value=\"true\";\r\n      return true;\r\n    ");
        int evalDoAfterBody = _jspx_th_impact_else_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_else_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    _jspx_th_impact_validateErrors_0.setFormName("frmStaffSecurityMaint");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("hdnUlIdEmpTempAssign");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_11.setType("hidden");
    _jspx_th_impact_validateInput_11.setName("hdnUlIdPerson2");
    _jspx_th_impact_validateInput_11.setValue("");
    int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
    if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_12.setType("hidden");
    _jspx_th_impact_validateInput_12.setName("hdnUlIdPersonDesignee");
    _jspx_th_impact_validateInput_12.setValue("");
    int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
    if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_13(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_13.setType("hidden");
    _jspx_th_impact_validateInput_13.setName("hdnDtAssignExpiration");
    _jspx_th_impact_validateInput_13.setValue("");
    int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
    if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_14(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_14.setType("hidden");
    _jspx_th_impact_validateInput_14.setName("hdnTsLastUpdate");
    _jspx_th_impact_validateInput_14.setValue("");
    int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
    if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
