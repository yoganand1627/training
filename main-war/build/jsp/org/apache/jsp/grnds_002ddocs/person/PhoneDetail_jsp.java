package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB;
import gov.georgia.dhr.dfcs.sacwis.web.person.PhoneConversation;
import org.exolab.castor.types.Date;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class PhoneDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


  //*-----------------------------------------------------------------------------
//*  JSP Name:     Phone Detail
//*  Created by:   Matthew McClain
//*  Date Created: 03/01/2003
//*
//*  Description:
//*  The Phone Detail page, accessed only through the sub-module, will provide a
//*  facility for users to add and maintain a phone number for a person in
//*  IMPACT.  The Phone Detail page will add or contain information on whether
//*  a number is the primary phone number for the person, whether it is valid,
//*  the type of phone number, the actual phone number, extension, the Start
//*  Date, and the End Date.
//*
//*  Change History:
//*  Date      User              Description
//*  --------  ----------------  -----------------------------------------------
//*  06/18/03  GRIMSHAN          SIR 18308 -- Invalid should be enabled for
//*                              primary phones
//*  08/06/03  Todd Reser        Added Description to Flowerbox.
//*  09/02/03  A.Corley          Changed hidden field session state manager to
//*                              increase performance.
//*  09/18/08  alwilliams        STGAP00006793 - Validation should be allowed if user has
//*                              SEC_MNTN_PERSON rights. Set disableValidation to false. 
//*-----------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int tabIndex = 1;
  String formName = "PhoneDetail";
  String returnUrl = request.getParameter(PhoneConversation.RETURN_URL);

  UserProfile userProfile = PhoneConversation.getUserProfile(request);

  int stageId = GlobalData.getUlIdStage(request);
  String pageMode = (String) request.getAttribute(PhoneConversation.PAGE_MODE);

  PhoneDB phoneDB = (PhoneDB)
          request.getAttribute(PhoneConversation.PHONE_DETAIL_PHONE);

  boolean inEditMode = PageModeConstants.EDIT.equals(pageMode);
  boolean isNewNumber = (phoneDB.getPhoneId() == 0);
  boolean isActive = (phoneDB.getInvalid() == false);
  boolean isEndDate = true;

//view mode
  boolean disableType = true;
  boolean disablePrimary = true;
  boolean disableInvalid = true;
  boolean disableNumber = true;
  boolean disableExtension = true;
  boolean disableComments = true;
  boolean disableSetEndDateButton = true;
  boolean disableSaveButton = true;
  boolean disableNewUsingButton = true;
  boolean disableValidation = false;
  Date endDate =DateHelper.toCastorDate(phoneDB.getEndDate());
  String endDateString = phoneDB.getEndDateString();
  if(endDate == null || endDate.equals( DateHelper.MAX_CASTOR_DATE))
  {
    endDateString = "";
    isEndDate = false;
  }

//state 1 and 1a (modify): new number
  if ((inEditMode) &&
      (isNewNumber)) {
    disableType = false;
    disablePrimary = false;
    disableInvalid = false;
    disableNumber = false;
    disableExtension = false;
    disableComments = false;
    disableSetEndDateButton = true;
    disableSaveButton = false;
    disableNewUsingButton = (stageId == 0);
  }
//state 2 (modify): modify active number
  else if ((inEditMode) && (!isEndDate) && (isActive) &&
           (phoneDB.getPrimary() == false)) {
    disableType = true;
    disablePrimary = false;
    disableInvalid = false;
    disableNumber = true;
    disableExtension = true;
    disableComments = false;
    disableSetEndDateButton = false;
    disableSaveButton = false;
    disableNewUsingButton = true;
  }
//state 3 (modify): modify end-dated number
  else if ((inEditMode) &&
           (phoneDB.getInvalid() == false) && (isEndDate)) {
    disableType = true;
    disablePrimary = true;
    disableInvalid = false;
    disableNumber = true;
    disableExtension = true;
    disableComments = false;
    disableSetEndDateButton = true;
    disableSaveButton = false;
    disableNewUsingButton = true;
  }
//state 4 (modify) : modify invalid number
  else if ((inEditMode) && (phoneDB.getInvalid())) {
    disableType = true;
    disablePrimary = true;
    disableInvalid = true;
    disableNumber = true;
    disableExtension = true;
    disableComments = false;
    disableSetEndDateButton = true;
    disableSaveButton = false;
    disableNewUsingButton = true;
  }
//HD 5/13/2003 -- SIR 17346 Should be able to set end date for primary number
  else if ((inEditMode) &&
           ( !isEndDate && (isActive) && (phoneDB.getPrimary()))) {
    disableType = true;
    disablePrimary = true;
    disableInvalid = false;
    disableNumber = true;
    disableExtension = true;
    disableComments = false;
    disableSetEndDateButton = false;
    disableSaveButton = false;
    disableNewUsingButton = true;
  }
//SIR 18659 - Users with MNTN_PERSON should have
//edit access to data widgets, after setting button
//access above.
//STGAP00006793 - Validation should be allowed if user has
//SEC_MNTN_PERSON rights. Set disableValidation to false. 
  if (userProfile.hasRight(UserProfile.SEC_MNTN_PERSON)) {
    disableType = false;
    disablePrimary = false;
    disableInvalid = false;
    disableNumber = false;
    disableExtension = false;
    disableComments = false;
    disableSaveButton = false;
    disableValidation = false;
  }

      out.write("\r\n<script src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script language=\"javascript\">\r\n  window.onbeforeunload = function()\r\n  {  \r\n    return IsDirty();\r\n  }\r\n\r\n\r\n  function setEndDate()\r\n  {\r\n    var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n    \r\n    form.phoneEndDate.value = \"");
      out.print( DateHelper.toString(new java.util.Date(), DateHelper.SLASH_FORMAT) );
      out.write("\";\r\n    \r\n    disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n    setIsDirtyCalled(true);\r\n    return true;\r\n  }\r\n\r\n\r\n  function newUsing()\r\n  {\r\n    var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n    disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n    return true;\r\n  }\r\n\r\n  function save()\r\n  {\r\n    var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n  ");
 if ( disableValidation ) { 
      out.write("\r\n    disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n  ");
 } else { 
      out.write("\r\n    enableValidation(\"");
      out.print( formName );
      out.write("\");\r\n  ");
 } 
      out.write("\r\n    return true;\r\n  }\r\n\r\n\r\n\r\n  //  function invalidSave()\r\n  // {\r\n  //    ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( userProfile.hasRight(UserProfile.SEC_MNTN_PERSON) );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  //    var form = document.all[\"");
          out.print( formName );
          out.write("\"];\r\n  //    if(form.phoneInvalid.checked)\r\n  //    {\r\n  //      form.phoneType.value = enabled;\r\n  //      form.phoneType.value = enabled;\r\n  //    }\r\n  //    ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  // }\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName( formName );
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setAction( PhoneConversation.PHONE_SAVE );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<!--Start Main Content-->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<tr><th colspan=\"5\">Phone Information</th></tr>\r\n<tr>\r\n  <td width=\"15%\">\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setDisabled( "" + disableType );
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setId("phoneType");
          _jspx_th_impact_validateSelect_0.setName("phoneType");
          _jspx_th_impact_validateSelect_0.setWidth("20%");
          _jspx_th_impact_validateSelect_0.setValue( phoneDB.getPhoneType() );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable("CPHNTYP");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n    ");
          out.write("\r\n  <td width=\"15%\" class=\"formBoldedText\">\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setDisabled( "" + disablePrimary );
          _jspx_th_impact_validateInput_0.setType("checkbox");
          _jspx_th_impact_validateInput_0.setName("phonePrimary");
          _jspx_th_impact_validateInput_0.setValue( "" + ((disablePrimary == false) || (phoneDB.getPrimary())) );
          _jspx_th_impact_validateInput_0.setChecked( "" + phoneDB.getPrimary() );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Primary\r\n  </td>\r\n  <td colspan=\"2\" width=\"50%\" class=\"formBoldedText\">\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setDisabled( "" + disableInvalid );
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setName("phoneInvalid");
          _jspx_th_impact_validateInput_1.setValue( "" + ((disableInvalid == false) || (phoneDB.getInvalid())) );
          _jspx_th_impact_validateInput_1.setChecked( "" + phoneDB.getInvalid()  );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Invalid\r\n  </td>\r\n</tr>\r\n<tr>\r\n  ");

    String number = phoneDB.getNumber();
    if ("".equals(number) == false) {
      number = FormattingHelper.formatPhone(number);
    }
  
          out.write("\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setDisabled( "" + disableNumber );
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setLabel("Number");
          _jspx_th_impact_validateInput_2.setId("phoneNumber");
          _jspx_th_impact_validateInput_2.setName("phoneNumber");
          _jspx_th_impact_validateInput_2.setSize("14");
          _jspx_th_impact_validateInput_2.setMaxLength("14");
          _jspx_th_impact_validateInput_2.setConstraint("Phone");
          _jspx_th_impact_validateInput_2.setRequired("true");
          _jspx_th_impact_validateInput_2.setValue( number );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setDisabled( "" + disableExtension );
          _jspx_th_impact_validateInput_3.setType("extension");
          _jspx_th_impact_validateInput_3.setName("phoneExtension");
          _jspx_th_impact_validateInput_3.setLabel("Extension");
          _jspx_th_impact_validateInput_3.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_3.setSize("8");
          _jspx_th_impact_validateInput_3.setMaxLength("8");
          _jspx_th_impact_validateInput_3.setColspan("2");
          _jspx_th_impact_validateInput_3.setValue( phoneDB.getExtension() );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td class=\"FormLabel\" valign=\"top\">Comments:</td>\r\n  <td colspan=\"4\">\r\n    ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setDisabled( "" + disableComments );
          _jspx_th_impact_validateTextArea_0.setCols("120");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_0.setName("phoneComments");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n      ");
              out.print( phoneDB.getComments() );
              out.write("\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td class=\"FormLabel\">Start Date:</td>\r\n  <td>\r\n    ");
          out.print( phoneDB.getStartDateString() );
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("phoneStartDate");
          _jspx_th_impact_validateInput_4.setValue( phoneDB.getStartDateString() );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td class=\"FormLabel\">\r\n    End Date:\r\n  </td>\r\n  <td width=\"7%\">");
          out.print( endDateString );
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("phoneEndDate");
          _jspx_th_impact_validateInput_5.setValue( endDateString );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("SetEndDate");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setDisabled( "" + disableSetEndDateButton );
          _jspx_th_impact_ButtonTag_0.setAction( PhoneConversation.PHONE_DETAIL );
          _jspx_th_impact_ButtonTag_0.setForm( formName );
          _jspx_th_impact_ButtonTag_0.setFunction( "return setEndDate();" );
          _jspx_th_impact_ButtonTag_0.setImg("btnSetEndDate");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n</table>\r\n\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("NewUsing");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setDisabled( "" + disableNewUsingButton );
          _jspx_th_impact_ButtonTag_1.setAction( PhoneConversation.PHONE_PULLBACK );
          _jspx_th_impact_ButtonTag_1.setForm( formName );
          _jspx_th_impact_ButtonTag_1.setFunction( "return newUsing();" );
          _jspx_th_impact_ButtonTag_1.setImg("btnNewUsing");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("Save");
          _jspx_th_impact_ButtonTag_2.setAccessKey("S");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setDisabled( "" + disableSaveButton );
          _jspx_th_impact_ButtonTag_2.setAction( PhoneConversation.PHONE_SAVE );
          _jspx_th_impact_ButtonTag_2.setForm( formName );
          _jspx_th_impact_ButtonTag_2.setFunction( "return save();" );
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<!--End <Main Content-->\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName( PhoneConversation.RETURN_URL );
          _jspx_th_impact_validateInput_6.setValue( returnUrl );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("phoneId");
          _jspx_th_impact_validateInput_7.setValue( "" + phoneDB.getPhoneId() );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("phoneLastUpdate");
          _jspx_th_impact_validateInput_8.setValue( "" + phoneDB.getLastUpdateTime() );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
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
 // If the user pressed the End Date button on the previous page, page is dirty
  if (request.getParameter("SetEndDate.x") != null) { 
      out.write("\r\n<script language=\"javascript\">\r\n  setPageDirtyFlag(true);\r\n</script>\r\n");
 } 
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
}
