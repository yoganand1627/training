package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB;
import gov.georgia.dhr.dfcs.sacwis.web.person.PhoneConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation;
import org.exolab.castor.types.Date;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class PhoneSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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
//*      JSP Name: Phone Sub
//*  Created by:   Matthew McClain
//*  Date Created: 03/01/2003
//*
//*   General:
//*   ANY MODIFICATIONS MADE TO THIS FILE MUST BE REVIEWED IN FILE
//*  PhoneSub.jsp--Mobile FOR NECESSARY MOBILE CHANGES
//*
//*  Description:
//*  The Phone List/Detail sub-module will provide an application-wide facility
//*  for users to store multiple phone numbers for persons (e.g., principals,
//*  collaterals, employees).  The information will be an expandable section on
//*  the including page and will display a list of the phone numbers for a given
//*  person.
//*
//*  Change History:
//*  Date      User           Description
//*  --------  -------------  --------------------------------------------------
//*  07/01/03  GRIMSHAN       SIR 18659 if there is no phone avaliable, put in
//*                           spaces so that a hyperlink will still appear.
//*  08/06/03  Todd Reser     Added Description.
//*  08/15/04  RIOSJA         SIR 19126 - If a string from the database is used
//*                           to create a JavaScript object and the string contains
//*                           a newline character (\n), the newline character must
//*                           be replaced with its string equivalent ("\\n") before
//*                           assigning it to the JavaScript object; otherwise an
//*                           Unterminated String Contstant error will occur since
//*                           the newline character causes the string to split onto
//*                           separate lines.
//*  12/31/03 RIOSJA          SIR 22456 - Updated "addPhone()" JavaScript function
//*                           to use the constant defined in PhoneConversation
//*                           (PhoneConversation.PAGE_MODE) when accessing the
//*                           hidden field that contains the page mode to be used
//*                           for the submodule.
//*  08/26/05  floresrj        SIR 23936 Modified to reconcile both IMPACT and Mobile versions.
//*                            Implemented Mobile Phase II changes in IMPACT.  The Mobile
//*                           version of PhoneSub.jsp  is scheduled to no longer be used
//*                           in the future, since the problem with submodules has been
//*                           resolved. ****** But until such notice, any changes to either
//*                           version must be duplicated in the other PhoneSub.jsp file *****.
//* 08/29/05   anandv          Added MOBILE-IMPACT comments at the General section.
//*
//*-----------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // Because this is a submodule, tabIndexes are relative.
  String tabIndexString = (String) request.getAttribute("tabIndex");

  int tabIndex = PhoneConversation.stringToInt(tabIndexString);

  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  String parentPage = (String)
    state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY,
                       request);

  String formName = (String)
    request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);

  String phoneExpandableSectionLabel = (String)
    request.getAttribute(PhoneSubmoduleConversation.PHONE_EXPANDABLE_SECTION_LABEL);

  if ((phoneExpandableSectionLabel == null) ||
      ("".equals(phoneExpandableSectionLabel.trim())))
  {
    phoneExpandableSectionLabel = "Phone";
  }

  List list = (List) request.getAttribute(PhoneSubmoduleConversation.PHONE_SUB_PHONES);

  String pageMode = (String) request.getAttribute(PhoneSubmoduleConversation.PAGE_MODE);

  boolean navAwayCk =
    StringHelper.isTrue((String) request.getAttribute(ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME));

  String phoneArrayName = (String)
    request.getAttribute(PhoneSubmoduleConversation.PHONE_SUB_NAME);

  if (phoneArrayName == null)
  {
    phoneArrayName = "phoneArray";
  }

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  var ");
      out.print( phoneArrayName );
      out.write(" = new Array(");
      out.print( list.size() );
      out.write(");\r\n");

  int i = -1;
  Iterator iterator = list.iterator();
  while (iterator.hasNext())
  {
    i++;
    PhoneDB phoneDB = (PhoneDB) iterator.next();

      out.write("\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("] = new Object();\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("].comments = \"");
      out.print(
        FormattingHelper.formatStringConvertTabNewLineToString
        (FormattingHelper.formatStringSpecialChars(phoneDB.getComments(), "\\\"")) );
      out.write("\";\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("].endDate = \"");
      out.print( phoneDB.getEndDateString() );
      out.write("\";\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("].extension = \"");
      out.print( phoneDB.getExtension() );
      out.write("\";\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("].invalid = \"");
      out.print( phoneDB.getInvalid() );
      out.write("\";\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("].lastUpdate = \"");
      out.print( phoneDB.getLastUpdateTime() );
      out.write("\";\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("].number = \"");
      out.print( phoneDB.getNumber() );
      out.write("\";\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("].phoneId = \"");
      out.print( phoneDB.getPhoneId() );
      out.write("\";\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("].phoneType = \"");
      out.print( phoneDB.getPhoneType() );
      out.write("\";\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("].primary = \"");
      out.print( phoneDB.getPrimary() );
      out.write("\";\r\n    ");
      out.print( phoneArrayName );
      out.write('[');
      out.print( i );
      out.write("].startDate = \"");
      out.print( phoneDB.getStartDateString() );
      out.write("\";\r\n");

  }

      out.write("\r\n</script>\r\n\r\n\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( (request.getAttribute(PhoneSubmoduleConversation.PHONE_SUB_CREATED_FORM_FIELDS) == null) );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  function submitPhoneDetail(phoneArrayName, phoneIndex)\r\n  {\r\n    var form = document.all[\"");
          out.print( formName );
          out.write("\"];\r\n    form.phonePersonId.value = eval(\"form.\" + phoneArrayName + \"_phonePersonId.value\");\r\n    form.phonePersonName.value = eval(\"form.\" + phoneArrayName + \"_phonePersonName.value\");\r\n    form.phoneComments.value = eval(phoneArrayName + \"[\" + phoneIndex + \"].comments\");\r\n    form.phoneEndDate.value = eval(phoneArrayName + \"[\" + phoneIndex + \"].endDate\");\r\n    form.phoneExtension.value = eval(phoneArrayName + \"[\" + phoneIndex + \"].extension\");\r\n    form.phoneInvalid.value = eval(phoneArrayName + \"[\" + phoneIndex + \"].invalid\");\r\n    form.phoneLastUpdate.value = eval(phoneArrayName + \"[\" + phoneIndex + \"].lastUpdate\");\r\n    form.phoneNumber.value = eval(phoneArrayName + \"[\" + phoneIndex + \"].number\");\r\n    form.phoneId.value = eval(phoneArrayName + \"[\" + phoneIndex + \"].phoneId\");\r\n    form.phoneType.value = eval(phoneArrayName + \"[\" + phoneIndex + \"].phoneType\");\r\n    form.phonePrimary.value = eval(phoneArrayName + \"[\" + phoneIndex + \"].primary\");\r\n    form.phoneStartDate.value = eval(phoneArrayName + \"[\" + phoneIndex + \"].startDate\");\r\n");
          out.write("    disableValidation(\"");
          out.print( formName );
          out.write("\");\r\n    submitValidateForm('");
          out.print( formName );
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.print( PhoneConversation.PHONE_DETAIL );
          out.write("');\r\n  }\r\n\r\n\r\n  function addPhone(phoneArrayName)\r\n  {\r\n    var form = document.all[\"");
          out.print( formName );
          out.write("\"];\r\n    form.phonePersonId.value = eval(\"form.\" + phoneArrayName + \"_phonePersonId.value\");\r\n    form.phonePersonName.value = eval(\"form.\" + phoneArrayName + \"_phonePersonName.value\");\r\n    form.");
          out.print( PhoneConversation.PAGE_MODE );
          out.write(".value = \"");
          out.print( PageModeConstants.EDIT );
          out.write("\";\r\n    form.phoneComments.value = \"\";\r\n    form.phoneEndDate.value = \"\";\r\n    form.phoneExtension.value = \"\";\r\n    form.phoneInvalid.value = \"\";\r\n    form.phoneLastUpdate.value = \"\";\r\n    form.phoneNumber.value = \"\";\r\n    form.phoneId.value = \"0\";\r\n    form.phoneType.value = \"\";\r\n    form.phonePrimary.value = \"\";\r\n    form.phoneStartDate.value = \"\";\r\n    disableValidation(\"");
          out.print( formName );
          out.write("\");\r\n    return true;\r\n  }\r\n  </script>\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName(PhoneConversation.PAGE_MODE);
          _jspx_th_impact_validateInput_0.setValue( pageMode );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_11(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_12(_jspx_th_impact_ifThen_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName( PhoneConversation.RETURN_URL );
          _jspx_th_impact_validateInput_13.setValue( parentPage );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_14.setParent(null);
      _jspx_th_impact_validateInput_14.setType("hidden");
      _jspx_th_impact_validateInput_14.setName( phoneArrayName + "_phonePersonId" );
      _jspx_th_impact_validateInput_14.setValue( (String) request.getAttribute(PhoneSubmoduleConversation.PHONE_SUB_PERSON_ID) );
      int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
      if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_15.setParent(null);
      _jspx_th_impact_validateInput_15.setType("hidden");
      _jspx_th_impact_validateInput_15.setName( phoneArrayName + "_phonePersonName" );
      _jspx_th_impact_validateInput_15.setValue( (String) request.getAttribute(PhoneSubmoduleConversation.PHONE_SUB_PERSON_NAME) );
      int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
      if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n  ");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setId( phoneArrayName + 0 );
      _jspx_th_impact_ExpandableSectionTag_0.setName( phoneArrayName );
      _jspx_th_impact_ExpandableSectionTag_0.setLabel( phoneExpandableSectionLabel );
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex );
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n    <div id=\"phoneSubScrollBar\" style=\"height:165;width:100%;overflow:auto\" class=\"tableBorderList\">\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n        <tr>\r\n          <th class=\"thList\">Primary</th>\r\n          <th class=\"thList\">Invalid</th>\r\n          <th class=\"thList\">Type</th>\r\n          <th class=\"thList\">Number</th>\r\n          <th class=\"thList\">Extension</th>\r\n          <th class=\"thList\">Start Date</th>\r\n          <th class=\"thList\">End Date</th>\r\n          <th class=\"thList\">Comments</th>\r\n        </tr>\r\n");

        i = -1;
        if (list.isEmpty())
        {

          out.write("\r\n          <tr>\r\n            <td colspan=\"8\" class=\"odd\">\r\n              ");
          out.print( MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) );
          out.write("\r\n            </td>\r\n          </tr>\r\n");

        }
        else
        {
          iterator = list.iterator();
          while (iterator.hasNext())
          {
            i++;
            PhoneDB phoneDB = (PhoneDB) iterator.next();
            String trClass = "class=\"odd\"";
            if (i % 2 == 1)
            {
              trClass = "class=\"even\"";
            }
            String CHECKED = "<nobr>&nbsp;&nbsp;&nbsp;&nbsp;<img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark_short.gif\"></nobr>";
            String UNCHECKED = "&nbsp;";

          out.write("\r\n            <tr ");
          out.print( trClass );
          out.write(">\r\n              <td>");
          out.print( phoneDB.getPrimary() ? CHECKED : UNCHECKED );
          out.write("</td>\r\n              <td>");
          out.print( phoneDB.getInvalid() ? CHECKED : UNCHECKED );
          out.write("</td>\r\n               <td><a id=\"");
          out.print( phoneArrayName + i );
          out.write("\"\r\n                tabIndex=\"");
          out.print( tabIndex );
          out.write("\"\r\n                href='javascript:submitPhoneDetail(\"");
          out.print( phoneArrayName );
          out.write("\", \"");
          out.print( i );
          out.write("\");'");
 if (!navAwayCk) { 
          out.write(" onClick=\"setIsDirtyCalled(true);\"");
 } 
          out.write("\r\n                 >");
          out.print( Lookup.simpleDecodeSafe("CPHNTYP", phoneDB.getPhoneType()) );
          out.write("</td>\r\n              <!-- SIR 23936  -->\r\n            ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n                <td>\r\n        ");
 // SIR 18659 If there is no phone number available, put in spaces so
                // the link will still appear.
                if (phoneDB.getNumber() == null || "".equals( phoneDB.getNumber())) { 
            out.write("\r\n                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n                ");
 } else { 
            out.write("\r\n                ");
            out.print( FormattingHelper.formatPhone(phoneDB.getNumber()) );
            out.write("\r\n                ");
 } 
            out.write("</td>\r\n             ");
          }
          if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           ");
          //  impact:ifMobileImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
          _jspx_th_impact_ifMobileImpact_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifMobileImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          int _jspx_eval_impact_ifMobileImpact_0 = _jspx_th_impact_ifMobileImpact_0.doStartTag();
          if (_jspx_eval_impact_ifMobileImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n               <td>\r\n                   ");
 if (phoneDB.getNumber() == null || "".equals( phoneDB.getNumber() ) )
                      { 
            out.write("\r\n                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n                    ");
} else
                       { 
            out.write("\r\n                         ");
            out.print( FormattingHelper.formatPhone(phoneDB.getNumber()) );
            out.write("\r\n                    ");
 }
                    
            out.write("\r\n               </td>\r\n            ");
          }
          if (_jspx_th_impact_ifMobileImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              <td>");
          out.print( phoneDB.getExtension()!= null ? phoneDB.getExtension():StringHelper.EMPTY_STRING  );
          out.write("</td>\r\n              <td>");
          out.print( phoneDB.getStartDateString() );
          out.write("</td>\r\n                  ");

                  Date endDate = DateHelper.toCastorDate( phoneDB.getEndDateString() );
                  if (endDate==null || DateHelper.MAX_CASTOR_DATE.equals(endDate) )
                  {
                
          out.write("\r\n                  <td>&nbsp;</td>\r\n                ");
 } else
                     { 
          out.write("\r\n                      <td>");
          out.print( phoneDB.getEndDateString() );
          out.write("</td>\r\n                   ");
}
          out.write("\r\n                  \r\n        <td>");
          out.print( phoneDB.getComments()!= null ? phoneDB.getComments():StringHelper.EMPTY_STRING  );
          out.write("</td>\r\n");

          } // end while (iterator.hasNext())
        }

          out.write("\r\n      </table>\r\n    </div>\r\n\r\n");

    if (PageModeConstants.EDIT.equals(pageMode))
    {
      String functionToCall = "return addPhone('" + phoneArrayName + "');";

          out.write("\r\n      <table width=\"100%\">\r\n        <tr>\r\n          <td align=\"right\">\r\n         ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          int _jspx_eval_impact_ifServerImpact_1 = _jspx_th_impact_ifServerImpact_1.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n            ");
            //  impact:ButtonTag
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
            _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
            _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_1);
            _jspx_th_impact_ButtonTag_0.setName("AddPhone");
            _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex );
            _jspx_th_impact_ButtonTag_0.setAction( PhoneConversation.PHONE_DETAIL );
            _jspx_th_impact_ButtonTag_0.setForm( formName );
            _jspx_th_impact_ButtonTag_0.setFunction( functionToCall );
            _jspx_th_impact_ButtonTag_0.setNavAwayCk(navAwayCk);
            _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
            _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
            int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
            if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n         ");
          }
          if (_jspx_th_impact_ifServerImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n");

    }

          out.write("\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("phonePersonId");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("phonePersonName");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("phoneComments");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("phoneEndDate");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("phoneExtension");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("phoneInvalid");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("phoneLastUpdate");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("phoneNumber");
    _jspx_th_impact_validateInput_8.setValue("");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("phoneId");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("phoneType");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_11.setType("hidden");
    _jspx_th_impact_validateInput_11.setName("phonePrimary");
    _jspx_th_impact_validateInput_11.setValue("");
    int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
    if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ifThen_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
    _jspx_th_impact_validateInput_12.setType("hidden");
    _jspx_th_impact_validateInput_12.setName("phoneStartDate");
    _jspx_th_impact_validateInput_12.setValue("");
    int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
    if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
