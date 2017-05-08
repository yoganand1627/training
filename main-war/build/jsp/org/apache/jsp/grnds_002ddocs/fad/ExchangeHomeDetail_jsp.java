package org.apache.jsp.grnds_002ddocs.fad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeChildrenSO;
import gov.georgia.dhr.dfcs.sacwis.web.fad.ExchangeHomeDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

public final class ExchangeHomeDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );  
  ExchangeHomeDetailSO exchangeHomeDetailSO = (ExchangeHomeDetailSO) state.getAttribute(ExchangeHomeDetailConversation.EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME, request);
  
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  int idEvent = 0;
  String isDisabled = "false";
  String linkedCount = null;
  if(exchangeHomeDetailSO != null) {
  	linkedCount = (exchangeHomeDetailSO.getChildrenConsideringList() != null && exchangeHomeDetailSO.getChildrenConsideringList().size() > 0) ? ("" + exchangeHomeDetailSO.getChildrenConsideringList().size()) : "";
  }
  
  Collection ethnicities = Lookup.getCategoryCollection(CodesTables.CINDETHN);
    

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script language=\"JavaScript\">\r\n\r\nwindow.attachEvent('onload', myOnLoadFunction );\r\n\r\nfunction myOnLoadFunction() {\r\n  \r\n}\r\n\r\nfunction checkSave() {\r\n if(isPageChanged()) {\r\n \talert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SAVE_BEFORE_MATCH));
      out.write("\");\r\n \treturn false;\r\n }\r\n \r\n return true;\r\n}\r\n\r\nfunction confirmDelete() {\r\n return confirm('");
      out.print( MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE") );
      out.write("');\r\n}\r\n\r\nfunction navigateToPersonDetail(idExcChild, idChild, nmChild) {\r\n  document.frmExchangeHomeDetail.");
      out.print(ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_EVENT);
      out.write(".value = \"\";\r\n  document.frmExchangeHomeDetail.");
      out.print(ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_EVENT);
      out.write(".value = idExcChild;\r\n  \r\n  document.frmExchangeHomeDetail.");
      out.print(ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_ID);
      out.write(".value = \"\";\r\n  document.frmExchangeHomeDetail.");
      out.print(ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_ID);
      out.write(".value = idChild;\r\n  \r\n  document.frmExchangeHomeDetail.");
      out.print(ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_NAME);
      out.write(".value = \"\";\r\n  document.frmExchangeHomeDetail.");
      out.print(ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_NAME);
      out.write(".value = nmChild;\r\n  \r\n  disableValidation(\"frmExchangeHomeDetail\");\r\n  submitValidateForm(\"frmExchangeHomeDetail\", \"/fad/ExchangeHomeDetail/displayChildDetail\");\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmExchangeHomeDetail");
      _jspx_th_impact_validateForm_0.setAction("/fad/ExchangeHomeDetail/saveExchangeHomeDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fad.ExchangeHomeDetailCustomValidation");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n<tr>\r\n<td align=\"right\">\r\n        <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"javascript:expandAll();\">Expand All</a>&nbsp;\r\n        <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"javascript:collapseAll();\">Collapse All</a>&nbsp;\r\n</td>\r\n </tr>\r\n</table>\t\r\n\t\r\n");
          out.write("\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE1\">\r\n\t\t\r\n\t  <tr>\r\n\t        <th colspan=\"4\">Home Registration Information</th>\r\n\t  </tr>\r\n\t  <tr>\r\n         <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtHomeName");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Home Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getHomeName()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n         <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtCaseWorkerName");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Case Worker");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getCaseWorkerName()) + " " + FormattingHelper.formatString(exchangeHomeDetailSO.getCaseWorkerPhoneNumber()));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n        <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtAgencyName");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Agency Name");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getAgencyName()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getAgencyContractNumber()));
          _jspx_th_impact_validateInput_0.setDisabled(isDisabled);
          _jspx_th_impact_validateInput_0.setName("txtAgencyContractCode");
          _jspx_th_impact_validateInput_0.setLabel("AgencyContractCode");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setMaxLength("3");
          _jspx_th_impact_validateInput_0.setSize("3");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getAgencyCaseWorkerName()));
          _jspx_th_impact_validateInput_1.setDisabled(isDisabled);
          _jspx_th_impact_validateInput_1.setName("txtAgencyCaseWorkerName");
          _jspx_th_impact_validateInput_1.setLabel("Private Agency Caseworker");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setMaxLength("25");
          _jspx_th_impact_validateInput_1.setSize("25");
          _jspx_th_impact_validateInput_1.setConstraint("Name25");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getPhoneNumber()));
          _jspx_th_impact_validateInput_2.setDisabled(isDisabled);
          _jspx_th_impact_validateInput_2.setName("txtPhoneNumber");
          _jspx_th_impact_validateInput_2.setLabel("Phone Number");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setMaxLength("10");
          _jspx_th_impact_validateInput_2.setSize("10");
          _jspx_th_impact_validateInput_2.setConstraint("Phone");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getPhoneNumberExt()));
          _jspx_th_impact_validateInput_3.setDisabled(isDisabled);
          _jspx_th_impact_validateInput_3.setName("txtPhoneNumberExt");
          _jspx_th_impact_validateInput_3.setLabel("Extension");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setMaxLength("8");
          _jspx_th_impact_validateInput_3.setSize("8");
          _jspx_th_impact_validateInput_3.setConstraint("PhoneExtension");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("txtDateInquired");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Date Inquired");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtInquired()));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      \t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("txtDateApplied");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Date Applied");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtApplied()));
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("txtDateImpactBegin");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Date IMPACT Begin");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtImpactBegin()));
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      \t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("txtDateOrientation");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Date Orientation");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtOrientation()));
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("txtDateApproved");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Date Approved");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtApproved()));
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      \t<td></td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Date Registered");
          _jspx_th_impact_validateDate_0.setName("dateRegistered");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtRegistered()));
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("false");
          _jspx_th_impact_validateDate_0.setDisabled(isDisabled);
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      \t<td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Date Re-Registered");
          _jspx_th_impact_validateDate_1.setName("dateReRegistered");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtReRegistered()));
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("false");
          _jspx_th_impact_validateDate_1.setDisabled(isDisabled);
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("txtDateLastUpdate");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Date Last Update");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtLastUpdateDisplay()));
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n        <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("txtCountyName");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("County Name");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, exchangeHomeDetailSO.getCdCounty()));
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("txtRegion");
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Region");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getCdRegion()));
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n    </table>\r\n    \r\n");
          out.write("\r\n\t<br>\r\n");
          out.write("\r\n\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("familyDemographicInformation");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Family Demographic Information");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE2\">\r\n\t  <tr>\r\n\t  \t<td>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE2\">\r\n\t  \t\t<tr>\r\n\t        \t<th>Father</th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n         \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_11.setName("txtFatherDOB");
              _jspx_th_impact_validateDisplayOnlyField_11.setLabel("DOB");
              _jspx_th_impact_validateDisplayOnlyField_11.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtFatherDOB()));
              int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_12.setName("txtFatherRace");
              _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Race");
              _jspx_th_impact_validateDisplayOnlyField_12.setValue(Lookup.simpleDecodeSafe(CodesTables.CRACE, exchangeHomeDetailSO.getFatherRace()));
              int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_13.setName("txtEthnicity");
              _jspx_th_impact_validateDisplayOnlyField_13.setLabel("Ethnicity");
              _jspx_th_impact_validateDisplayOnlyField_13.setValue(Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeHomeDetailSO.getFatherEthnicity()));
              int _jspx_eval_impact_validateDisplayOnlyField_13 = _jspx_th_impact_validateDisplayOnlyField_13.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td></td>\r\n      \t\t</tr>\r\n         \t<tr class=\"subDetail\">\r\n         \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_14.setName("txtFatherOccupation");
              _jspx_th_impact_validateDisplayOnlyField_14.setLabel("Occupation");
              _jspx_th_impact_validateDisplayOnlyField_14.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getFatherOccupation()));
              int _jspx_eval_impact_validateDisplayOnlyField_14 = _jspx_th_impact_validateDisplayOnlyField_14.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_15.setName("txtFatherReligion");
              _jspx_th_impact_validateDisplayOnlyField_15.setLabel("Religion");
              _jspx_th_impact_validateDisplayOnlyField_15.setValue(Lookup.simpleDecodeSafe(CodesTables.CRELIGNS, exchangeHomeDetailSO.getFatherReligion()));
              int _jspx_eval_impact_validateDisplayOnlyField_15 = _jspx_th_impact_validateDisplayOnlyField_15.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td></td>\r\n         \t\t<td></td>\r\n         \t\t<td></td>\r\n      \t\t</tr>\r\n\t\t</table>\r\n\t\t</td>\r\n\t  </tr>\r\n\t  <tr>\r\n\t\t<td>\r\n\t\t <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE3\">\r\n\t  \t\t<tr>\r\n\t        \t<th>Mother</th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n         \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_16.setName("txtMotherDOB");
              _jspx_th_impact_validateDisplayOnlyField_16.setLabel("DOB");
              _jspx_th_impact_validateDisplayOnlyField_16.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtMotherDOB()));
              int _jspx_eval_impact_validateDisplayOnlyField_16 = _jspx_th_impact_validateDisplayOnlyField_16.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_17.setName("txtMotherRace");
              _jspx_th_impact_validateDisplayOnlyField_17.setLabel("Race");
              _jspx_th_impact_validateDisplayOnlyField_17.setValue(Lookup.simpleDecodeSafe(CodesTables.CRACE, exchangeHomeDetailSO.getMotherRace()));
              int _jspx_eval_impact_validateDisplayOnlyField_17 = _jspx_th_impact_validateDisplayOnlyField_17.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_18.setName("txtMotherEthnicity");
              _jspx_th_impact_validateDisplayOnlyField_18.setLabel("Ethnicity");
              _jspx_th_impact_validateDisplayOnlyField_18.setValue(Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeHomeDetailSO.getMotherEthnicity()));
              int _jspx_eval_impact_validateDisplayOnlyField_18 = _jspx_th_impact_validateDisplayOnlyField_18.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td></td>\r\n      \t\t</tr>\r\n         \t<tr class=\"subDetail\">\r\n         \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_19.setName("txtMotherOccupation");
              _jspx_th_impact_validateDisplayOnlyField_19.setLabel("Occupation");
              _jspx_th_impact_validateDisplayOnlyField_19.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getMotherOccupation()));
              int _jspx_eval_impact_validateDisplayOnlyField_19 = _jspx_th_impact_validateDisplayOnlyField_19.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_20.setName("txtMotherReligion");
              _jspx_th_impact_validateDisplayOnlyField_20.setLabel("Religion");
              _jspx_th_impact_validateDisplayOnlyField_20.setValue(Lookup.simpleDecodeSafe(CodesTables.CRELIGNS, exchangeHomeDetailSO.getMotherReligion()));
              int _jspx_eval_impact_validateDisplayOnlyField_20 = _jspx_th_impact_validateDisplayOnlyField_20.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td></td>\r\n         \t\t<td></td>\r\n         \t\t<td></td>\r\n      \t\t</tr>\r\n\t\t </table>\r\n\t\t</td>\r\n\t  </tr>\r\n\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\r\n");
          out.write("\r\n\r\n\t<br>\r\n");
          out.write("\r\n\r\n\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("homePreferences");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Home Preferences");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE4\">\r\n\t  \t\t<tr>\r\n\t        \t<th colspan=\"4\">Special Needs Preferences</th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_4.setType("checkbox");
              _jspx_th_impact_validateInput_4.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_01));
              _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_4.setChecked( (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndMentalRetardation())) ? "true" : "false" );
              _jspx_th_impact_validateInput_4.setValue("Y");
              _jspx_th_impact_validateInput_4.setName("cbxMentalRetardation");
              _jspx_th_impact_validateInput_4.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_4.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_0.setName("selSzCdMentalRetardation");
              _jspx_th_impact_validateSelect_0.setColspan("1");
              _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString(exchangeHomeDetailSO.getCdLevelMentalRetardation()) );
              _jspx_th_impact_validateSelect_0.setRequired("false");
              _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CADSEVER);
              _jspx_th_impact_validateSelect_0.setDisabled(isDisabled);
              _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
              if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<b> Background Factors</b>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_5.setType("checkbox");
              _jspx_th_impact_validateInput_5.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_02));
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_5.setChecked( (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndVisualHearingImpairments())) ? "true" : "false" );
              _jspx_th_impact_validateInput_5.setValue("Y");
              _jspx_th_impact_validateInput_5.setName("cbxVisualHearingImpairments");
              _jspx_th_impact_validateInput_5.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_1.setName("selSzCdVisualHearingImpairments");
              _jspx_th_impact_validateSelect_1.setColspan("1");
              _jspx_th_impact_validateSelect_1.setValue( FormattingHelper.formatString(exchangeHomeDetailSO.getCdLevelVisualHearingImpairments()) );
              _jspx_th_impact_validateSelect_1.setRequired("false");
              _jspx_th_impact_validateSelect_1.setCodesTable(CodesTables.CADSEVER);
              _jspx_th_impact_validateSelect_1.setDisabled(isDisabled);
              _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
              if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_6.setType("checkbox");
              _jspx_th_impact_validateInput_6.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_06));
              _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_6.setChecked( (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndFamilyHxofDrugsAlcohol())) ? "true" : "false" );
              _jspx_th_impact_validateInput_6.setValue("Y");
              _jspx_th_impact_validateInput_6.setName("cbxFamilyHxofDrugsAlcohol");
              _jspx_th_impact_validateInput_6.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_6.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_7.setType("checkbox");
              _jspx_th_impact_validateInput_7.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_03));
              _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_7.setChecked( (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndPhysicallyDisabled())) ? "true" : "false" );
              _jspx_th_impact_validateInput_7.setValue("Y");
              _jspx_th_impact_validateInput_7.setName("cbxPhysicallyDisabled");
              _jspx_th_impact_validateInput_7.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_7.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_2.setName("selSzCdPhysicallyDisabled");
              _jspx_th_impact_validateSelect_2.setColspan("1");
              _jspx_th_impact_validateSelect_2.setValue( FormattingHelper.formatString(exchangeHomeDetailSO.getCdLevelPhysicallyDisabled()) );
              _jspx_th_impact_validateSelect_2.setRequired("false");
              _jspx_th_impact_validateSelect_2.setCodesTable(CodesTables.CADSEVER);
              _jspx_th_impact_validateSelect_2.setDisabled(isDisabled);
              _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_8.setType("checkbox");
              _jspx_th_impact_validateInput_8.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_07));
              _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_8.setChecked( (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndFamilyHxofMentalIllness())) ? "true" : "false" );
              _jspx_th_impact_validateInput_8.setValue("Y");
              _jspx_th_impact_validateInput_8.setName("cbxFamilyHxofMentalIllness");
              _jspx_th_impact_validateInput_8.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_8.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_9.setType("checkbox");
              _jspx_th_impact_validateInput_9.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_04));
              _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_9.setChecked( (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndEmotionallyDisturbed())) ? "true" : "false" );
              _jspx_th_impact_validateInput_9.setValue("Y");
              _jspx_th_impact_validateInput_9.setName("cbxEmotionallyDisturbed");
              _jspx_th_impact_validateInput_9.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_9.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_3.setName("selSzCdEmotionallyDisturbed");
              _jspx_th_impact_validateSelect_3.setColspan("1");
              _jspx_th_impact_validateSelect_3.setValue( FormattingHelper.formatString(exchangeHomeDetailSO.getCdLevelEmotionallyDisturbed()) );
              _jspx_th_impact_validateSelect_3.setRequired("false");
              _jspx_th_impact_validateSelect_3.setCodesTable(CodesTables.CADSEVER);
              _jspx_th_impact_validateSelect_3.setDisabled(isDisabled);
              _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_10.setType("checkbox");
              _jspx_th_impact_validateInput_10.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_08));
              _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_10.setChecked( (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndFamilyHxofMR())) ? "true" : "false" );
              _jspx_th_impact_validateInput_10.setValue("Y");
              _jspx_th_impact_validateInput_10.setName("cbxFamilyHxofMR");
              _jspx_th_impact_validateInput_10.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_11.setType("checkbox");
              _jspx_th_impact_validateInput_11.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_05));
              _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_11.setChecked( (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndOtherMedicalDiagnoses())) ? "true" : "false" );
              _jspx_th_impact_validateInput_11.setValue("Y");
              _jspx_th_impact_validateInput_11.setName("cbxOtherMedicalDiagnoses");
              _jspx_th_impact_validateInput_11.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_4.setName("selSzCdOtherMedicalDiagnoses");
              _jspx_th_impact_validateSelect_4.setColspan("1");
              _jspx_th_impact_validateSelect_4.setValue( FormattingHelper.formatString(exchangeHomeDetailSO.getCdlevelOtherMedicalDiagnoses()) );
              _jspx_th_impact_validateSelect_4.setRequired("false");
              _jspx_th_impact_validateSelect_4.setCodesTable(CodesTables.CADSEVER);
              _jspx_th_impact_validateSelect_4.setDisabled(isDisabled);
              _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_12.setType("checkbox");
              _jspx_th_impact_validateInput_12.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_09));
              _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_12.setChecked( (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndChilsHxofSexualAbuse())) ? "true" : "false" );
              _jspx_th_impact_validateInput_12.setValue("Y");
              _jspx_th_impact_validateInput_12.setName("cbxChilsHxofSexualAbuse");
              _jspx_th_impact_validateInput_12.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_12.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE5\">\r\n\t  \t\t<tr>\r\n\t        \t<th colspan=\"4\">Child Race Preferences</th>\r\n\t  \t\t</tr>\r\n\t\t  \t<tr class=\"subDetail\">\r\n\t\t  \t\t <td>\r\n\t\t\t      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes(exchangeHomeDetailSO.getChildRacePref());
              _jspx_th_impact_codesCheckbox_0.setName("cbxRace");
              _jspx_th_impact_codesCheckbox_0.setCodesTableName(CodesTables.CADRACE);
              _jspx_th_impact_codesCheckbox_0.setColumns(2);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_0.setDisabled("true");
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t   \t</td>\r\n\t  \t\t</tr>\r\n\t\t</table>\r\n\t\t\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE6\">\r\n\t  \t\t<tr>\r\n\t        \t<th colspan=\"4\">Child Ethnicity Preferences</th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t\t  \t\t <td>\r\n\t\t\t      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_codesCheckbox_1.setDefaultCodes(exchangeHomeDetailSO.getChildEthnicityPerf());
              _jspx_th_impact_codesCheckbox_1.setName("cbxEth");
              _jspx_th_impact_codesCheckbox_1.setCodesTableName(CodesTables.CINDETHN);
              _jspx_th_impact_codesCheckbox_1.setColumns(3);
              _jspx_th_impact_codesCheckbox_1.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_1.setDisabled("true");
              int _jspx_eval_impact_codesCheckbox_1 = _jspx_th_impact_codesCheckbox_1.doStartTag();
              if (_jspx_th_impact_codesCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t   \t</td>\r\n\t  \t\t</tr>\r\n\t\t</table>\r\n\t\t\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE7\">\r\n\t  \t\t<tr>\r\n\t        \t<th colspan=\"4\">Child Age/Gender Preferences</th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t  \t\t\t<td>\r\n\t  \t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_13.setType("text");
              _jspx_th_impact_validateInput_13.setLabel("Number Of children");
              _jspx_th_impact_validateInput_13.setName("txtNbrOfChldrn");
              _jspx_th_impact_validateInput_13.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_13.setCssClass("formInput");
              _jspx_th_impact_validateInput_13.setValue( FormattingHelper.formatInt((exchangeHomeDetailSO.getNumOfChildren() != null) ? exchangeHomeDetailSO.getNumOfChildren() : 0) );
              _jspx_th_impact_validateInput_13.setConstraint("Numeric");
              _jspx_th_impact_validateInput_13.setSize("3");
              _jspx_th_impact_validateInput_13.setMaxLength("3");
              _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    \t\t\t</td>\r\n    \t\t</tr>\r\n    \t\t<tr>\r\n    \t\t <td colspan=\"4\">\r\n    \t\t \t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" id=\"TABLE8\">\r\n\t\t \t\t\t<tr>\r\n\t\t\t\t    \t<th colspan=\"4\">Male Age Range</th>\r\n\t\t\t\t  \t</tr>\r\n\t\t\t\t  \t<tr class=\"subDetail\">\r\n\t\t\t\t  \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDisplayOnlyField_21.setName("txtMaleMinYear");
              _jspx_th_impact_validateDisplayOnlyField_21.setLabel("Min Year");
              _jspx_th_impact_validateDisplayOnlyField_21.setValue(FormattingHelper.formatString((exchangeHomeDetailSO.getMaleMinRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getMaleMinRangeInMonths()/12) : null));
              int _jspx_eval_impact_validateDisplayOnlyField_21 = _jspx_th_impact_validateDisplayOnlyField_21.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n\t\t\t\t  \t\t</td>\r\n\t\t\t\t  \t    <td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDisplayOnlyField_22.setName("txtMaleMinMonth");
              _jspx_th_impact_validateDisplayOnlyField_22.setLabel("Min Month");
              _jspx_th_impact_validateDisplayOnlyField_22.setValue(FormattingHelper.formatString((exchangeHomeDetailSO.getMaleMinRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getMaleMinRangeInMonths()%12) : null));
              int _jspx_eval_impact_validateDisplayOnlyField_22 = _jspx_th_impact_validateDisplayOnlyField_22.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t  \t    </td>\r\n\t\t\t\t  \t    <td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDisplayOnlyField_23.setName("txtMaleMaxYear");
              _jspx_th_impact_validateDisplayOnlyField_23.setLabel("Max Year");
              _jspx_th_impact_validateDisplayOnlyField_23.setValue(FormattingHelper.formatString((exchangeHomeDetailSO.getMaleMaxRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getMaleMaxRangeInMonths()/12) : null));
              int _jspx_eval_impact_validateDisplayOnlyField_23 = _jspx_th_impact_validateDisplayOnlyField_23.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t  \t    </td>\r\n\t\t\t\t  \t    <td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDisplayOnlyField_24.setName("txtMaleMaxMonth");
              _jspx_th_impact_validateDisplayOnlyField_24.setLabel("Max Month");
              _jspx_th_impact_validateDisplayOnlyField_24.setValue(FormattingHelper.formatString((exchangeHomeDetailSO.getMaleMaxRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getMaleMaxRangeInMonths()%12) : null));
              int _jspx_eval_impact_validateDisplayOnlyField_24 = _jspx_th_impact_validateDisplayOnlyField_24.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t  \t    </td>\r\n\t\t\t\t  \t </tr>\r\n\t\t\t\t</table>\r\n    \t\t </td>\r\n    \t\t</tr>\r\n    \t\t<tr>\r\n    \t\t <td colspan=\"4\">\r\n    \t\t \t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" id=\"TABLE9\">\r\n\t\t \t\t\t<tr>\r\n\t\t\t\t    \t<th colspan=\"4\">Female Age Range</th>\r\n\t\t\t\t  \t</tr>\r\n\t\t\t\t  \t<tr class=\"subDetail\">\r\n\t\t\t\t  \t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDisplayOnlyField_25.setName("txtFemaleMinYear");
              _jspx_th_impact_validateDisplayOnlyField_25.setLabel("Min Year");
              _jspx_th_impact_validateDisplayOnlyField_25.setValue(FormattingHelper.formatString((exchangeHomeDetailSO.getFemaleMinRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getFemaleMinRangeInMonths()/12) : null));
              int _jspx_eval_impact_validateDisplayOnlyField_25 = _jspx_th_impact_validateDisplayOnlyField_25.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n\t\t\t\t  \t\t</td>\r\n\t\t\t\t  \t    <td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDisplayOnlyField_26.setName("txtFemaleMinMonth");
              _jspx_th_impact_validateDisplayOnlyField_26.setLabel("Min Month");
              _jspx_th_impact_validateDisplayOnlyField_26.setValue(FormattingHelper.formatString((exchangeHomeDetailSO.getFemaleMinRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getFemaleMinRangeInMonths()%12) : null));
              int _jspx_eval_impact_validateDisplayOnlyField_26 = _jspx_th_impact_validateDisplayOnlyField_26.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t  \t    </td>\r\n\t\t\t\t  \t    <td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDisplayOnlyField_27.setName("txtFemaleMaxYear");
              _jspx_th_impact_validateDisplayOnlyField_27.setLabel("Max Year");
              _jspx_th_impact_validateDisplayOnlyField_27.setValue(FormattingHelper.formatString((exchangeHomeDetailSO.getFemaleMaxRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getFemaleMaxRangeInMonths()/12) : null));
              int _jspx_eval_impact_validateDisplayOnlyField_27 = _jspx_th_impact_validateDisplayOnlyField_27.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t  \t    </td>\r\n\t\t\t\t  \t    <td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDisplayOnlyField_28.setName("txtFemaleMaxMonth");
              _jspx_th_impact_validateDisplayOnlyField_28.setLabel("Max Month");
              _jspx_th_impact_validateDisplayOnlyField_28.setValue(FormattingHelper.formatString((exchangeHomeDetailSO.getFemaleMaxRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getFemaleMaxRangeInMonths()%12) : null));
              int _jspx_eval_impact_validateDisplayOnlyField_28 = _jspx_th_impact_validateDisplayOnlyField_28.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t  \t    </td>\r\n\t\t\t\t  \t </tr>\r\n\t\t\t\t</table>\r\n    \t\t </td>\r\n    \t\t</tr>\r\n    \t </table>\t\r\n    \t \r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE10\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t        \t<td>\r\n\t\t\t       ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateTextArea_0.setName("txtHomePrefComments");
              _jspx_th_impact_validateTextArea_0.setColspan("4");
              _jspx_th_impact_validateTextArea_0.setLabel("Comments");
              _jspx_th_impact_validateTextArea_0.setRows("4");
              _jspx_th_impact_validateTextArea_0.setCols("110");
              _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_0.setDisabled(isDisabled);
              _jspx_th_impact_validateTextArea_0.setMaxLength(500);
              _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph500");
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t           ");
                  out.print(FormattingHelper.formatString(exchangeHomeDetailSO.getHomePrefComments()));
                  out.write("\r\n\t\t\t       ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t     </td>\r\n\t  \t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n\t<br>\r\n");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("homeAvailability");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Home Availability");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE11\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t   \t<td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_5.setName("selSzCdNonAvReasonHA");
              _jspx_th_impact_validateSelect_5.setColspan("1");
              _jspx_th_impact_validateSelect_5.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getCdNonAvReasonHA()));
              _jspx_th_impact_validateSelect_5.setRequired("false");
              _jspx_th_impact_validateSelect_5.setCodesTable(CodesTables.CANONAV);
              _jspx_th_impact_validateSelect_5.setDisabled(isDisabled);
              _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_5.setLabel("Non-Availability Reason Code");
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t   \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDisplayOnlyField_29.setName("txtDateOut");
              _jspx_th_impact_validateDisplayOnlyField_29.setLabel("Date Out");
              _jspx_th_impact_validateDisplayOnlyField_29.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDateOutHA()));
              int _jspx_eval_impact_validateDisplayOnlyField_29 = _jspx_th_impact_validateDisplayOnlyField_29.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t   \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDisplayOnlyField_30.setName("txtDaysOut");
              _jspx_th_impact_validateDisplayOnlyField_30.setLabel("Days Out");
              _jspx_th_impact_validateDisplayOnlyField_30.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getNumDaysOutHA()));
              int _jspx_eval_impact_validateDisplayOnlyField_30 = _jspx_th_impact_validateDisplayOnlyField_30.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t        \t<td>\r\n\t\t\t       ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_1.setName("txtCommentsHA");
              _jspx_th_impact_validateTextArea_1.setColspan("6");
              _jspx_th_impact_validateTextArea_1.setLabel("Comments");
              _jspx_th_impact_validateTextArea_1.setRows("3");
              _jspx_th_impact_validateTextArea_1.setCols("110");
              _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_1.setDisabled(isDisabled);
              _jspx_th_impact_validateTextArea_1.setMaxLength(1000);
              _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph1000");
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t           ");
                  out.print(FormattingHelper.formatString(exchangeHomeDetailSO.getCommentsHA()));
                  out.write("\r\n\t\t\t       ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t     </td>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t        \t<td>\r\n\t\t\t       ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_2.setName("txtFamilyIsLinkedHA");
              _jspx_th_impact_validateTextArea_2.setColspan("6");
              _jspx_th_impact_validateTextArea_2.setLabel("Family is Linked");
              _jspx_th_impact_validateTextArea_2.setRows("3");
              _jspx_th_impact_validateTextArea_2.setCols("110");
              _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_2.setDisabled(isDisabled);
              _jspx_th_impact_validateTextArea_2.setMaxLength(1000);
              _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph1000");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t           ");
                  out.print(FormattingHelper.formatString(exchangeHomeDetailSO.getFamilyIsLinkedHA()));
                  out.write("\r\n\t\t\t       ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t     </td>\r\n\t  \t\t</tr>\r\n\t\t</table>\r\n\t\t");
              //  impact:pagination
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
              _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_pagination_0.setSubmitUrl("/fad/ExchangeHomeDetail/displayExchangeHomeDetail");
              int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
              if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE12\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t ");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_ButtonTag_0.setName("btnMatch");
                  _jspx_th_impact_ButtonTag_0.setImg("btnMatch");
                  _jspx_th_impact_ButtonTag_0.setForm("frmExchangeHomeDetail");
                  _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
                  _jspx_th_impact_ButtonTag_0.setAction("/fad/ExchangeHomeDetail/matchExchangeChildren");
                  _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
                  _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
                  _jspx_th_impact_ButtonTag_0.setFunction("return checkSave();");
                  _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
                  int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
                  if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t        \t<th colspan=\"4\">Family is Now Considering</th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr>\r\n\t  \t\t\t<td>\r\n\t  \t\t\t\t<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n\t\t\t\t\t  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\t\t\t\t\t    <tr>\r\n\t\t\t\t\t      <th class=\"thList\">Unlink</th>\r\n\t\t\t\t\t      <th class=\"thList\">Last Name</th>\r\n\t\t\t\t\t      <th class=\"thList\">First Name</th>\r\n\t\t\t\t\t      <th class=\"thList\">Non-Availability Reason Code");
                  //  impact:sortableColumnHeader
                  gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
                  _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_sortableColumnHeader_0.setOrderBy(ExchangeHomeDetailConversation.SORT_BY_NON_AVAIL_RSN_CODE);
                  _jspx_th_impact_sortableColumnHeader_0.setIsDefault("false");
                  int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
                  if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</th>\r\n\t\t\t\t\t      <th class=\"thList\">DOB</th>\r\n\t\t\t\t\t      <th class=\"thList\">Gender</th>\r\n\t\t\t\t\t      <th class=\"thList\">County</th>\r\n\t\t\t\t\t      <th class=\"thList\">Date Out");
                  //  impact:sortableColumnHeader
                  gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
                  _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_sortableColumnHeader_1.setOrderBy(ExchangeHomeDetailConversation.SORT_BY_DT_OUT);
                  _jspx_th_impact_sortableColumnHeader_1.setIsDefault("true");
                  int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
                  if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</th>\r\n\t\t\t\t\t    </tr>\r\n\t\t\t\t\t\t    ");

						    List childrenConsideringList = exchangeHomeDetailSO.getChildrenConsideringList();
						    if((childrenConsideringList != null) && (childrenConsideringList.size() > 0)) {
							  	Iterator itr = childrenConsideringList.iterator();
							  	int loopCount = 0;
							 	while (itr.hasNext()) {
							   		ExchangeHomeChildrenSO childConsidering = (ExchangeHomeChildrenSO) itr.next();
							   		String cbName = "cbLinked_" + loopCount;
							   		String childName = childConsidering.getLastName() + ", " + childConsidering.getFirstName();
							
                  out.write("\r\n\t\t\t\t\t\t\t<tr class=\"");
                  out.print( FormattingHelper.getRowCss(++loopCount) );
                  out.write("\">\r\n\t\t\t\t\t\t\t\t");

									if ("Y".equals(childConsidering.getLinkCurrent())) {
								
                  out.write("\r\n\t\t\t\t\t\t    \t<td>\r\n\t\t        \t\t\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateInput_14.setType("checkbox");
                  _jspx_th_impact_validateInput_14.setName(cbName);
                  _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateInput_14.setChecked(ArchitectureConstants.N);
                  _jspx_th_impact_validateInput_14.setDisabled(isDisabled);
                  _jspx_th_impact_validateInput_14.setValue( ArchitectureConstants.TRUE );
                  int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
                  if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t     \t\t\t\t\t\t </td>\r\n\t     \t\t\t\t\t\t ");

									} else {
								 
                  out.write("\r\n\t\t\t\t\t\t\t\t \t<td><nobr></nobr></td>\r\n\t\t\t\t\t\t\t\t ");

									}
								 
                  out.write("\r\n\t     \t\t\t\t\t\t <td>\r\n\t\t\t\t\t\t\t        <a href=\"javascript:navigateToPersonDetail('");
                  out.print(childConsidering.getIdExchangeChildEvent());
                  out.write("' , '");
                  out.print(childConsidering.getIdChild());
                  out.write("', '");
                  out.print(childName);
                  out.write("')\" \r\n\t\t\t\t\t\t\t           onclick=\"setIsDirtyCalled(true)\" \r\n\t\t\t\t\t\t\t           tabIndex=\"");
                  out.print(tabIndex++ );
                  out.write("\">\r\n\t\t\t\t\t\t\t          ");
                  out.print(childConsidering.getLastName());
                  out.write("\r\n\t\t\t\t\t\t\t        </a>\r\n\t\t\t\t\t\t\t     </td>\r\n\t\t\t\t\t\t\t     <td><nobr>");
                  out.print(FormattingHelper.formatString(childConsidering.getFirstName()));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t\t     <td><nobr>");
                  out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CANONAV, childConsidering.getCdNonAviReasonCode())));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t\t     <td><nobr>");
                  out.print(FormattingHelper.formatDate(childConsidering.getDtDOB()));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t\t     <td><nobr>");
                  out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CSEX, childConsidering.getCdGender())));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t\t     <td><nobr>");
                  out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, childConsidering.getCdCounty())));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t\t     <td><nobr>");
                  out.print(FormattingHelper.formatDate(childConsidering.getDtDateOut()));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t    </tr>\r\n\t\t\t\t\t\t    ");

						  } //end while (itr.hasNext()
					  	} else {
					  		
                  out.write("\r\n\t\t\t\t\t  \t\t\t<tr class=\"odd\"><td colspan=\"8\">No Results Found</td></tr>\r\n\t\t\t\t\t\t    ");

					  	}
						
                  out.write("\r\n\t\t\t\t\t   </table>\r\n\t\t\t\t\t </div>\r\n\t  \t\t\t</td>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr>\r\n\t  \t\t\t<td>\r\n\t  \t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE11\">\r\n\t  \t\t\t\t\t<tr>\r\n\t  \t\t\t\t\t\t<td>");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateSelect_6.setName("selSzCdNonAvReasonChild");
                  _jspx_th_impact_validateSelect_6.setColspan("1");
                  _jspx_th_impact_validateSelect_6.setValue(CodesTables.CANONAV_03);
                  _jspx_th_impact_validateSelect_6.setRequired("false");
                  _jspx_th_impact_validateSelect_6.setCodesTable(CodesTables.CANONAV);
                  _jspx_th_impact_validateSelect_6.setDisabled(isDisabled);
                  _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateSelect_6.setConditionallyRequired("true");
                  _jspx_th_impact_validateSelect_6.setLabel("Non-Availability Reason Code");
                  int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
                  if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</td>\r\n\t  \t\t\t\t\t\t<td>");
                  //  impact:validateDate
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
                  _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateDate_2.setLabel("Date Out");
                  _jspx_th_impact_validateDate_2.setName("dateOutHA");
                  _jspx_th_impact_validateDate_2.setType("text");
                  _jspx_th_impact_validateDate_2.setValue(FormattingHelper.formatDate(new Date()));
                  _jspx_th_impact_validateDate_2.setSize("10");
                  _jspx_th_impact_validateDate_2.setConditionallyRequired("false");
                  _jspx_th_impact_validateDate_2.setDisabled(isDisabled);
                  _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateDate_2.setConstraint("Date");
                  int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
                  if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</td>\r\n\t  \t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t ");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_ButtonTag_1.setName("btnLink");
                  _jspx_th_impact_ButtonTag_1.setImg("btnLink");
                  _jspx_th_impact_ButtonTag_1.setForm("frmExchangeHomeDetail");
                  _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
                  _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
                  _jspx_th_impact_ButtonTag_1.setAction("/fad/ExchangeHomeDetail/linkExchangeHomeDetail");
                  _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
                  int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
                  if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t  \t\t\t\t\t\t\r\n\t  \t\t\t\t\t</tr>\r\n\t  \t\t\t\t\t<tr>\r\n\t  \t\t\t\t\t\t<td>");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateSelect_7.setName("selSzCdNonSelectionReasonChild");
                  _jspx_th_impact_validateSelect_7.setColspan("1");
                  _jspx_th_impact_validateSelect_7.setValue("");
                  _jspx_th_impact_validateSelect_7.setRequired("false");
                  _jspx_th_impact_validateSelect_7.setCodesTable(CodesTables.CADNSLCT);
                  _jspx_th_impact_validateSelect_7.setDisabled(isDisabled);
                  _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateSelect_7.setConditionallyRequired("true");
                  _jspx_th_impact_validateSelect_7.setLabel("Non-Selection Reason Code");
                  int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
                  if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</td>\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t ");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_ButtonTag_2.setName("btnUnlink");
                  _jspx_th_impact_ButtonTag_2.setImg("btnUnlink");
                  _jspx_th_impact_ButtonTag_2.setForm("frmExchangeHomeDetail");
                  _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
                  _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
                  _jspx_th_impact_ButtonTag_2.setAction("/fad/ExchangeHomeDetail/unLinkExchangeHomeDetail");
                  _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
                  int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
                  if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t  \t\t\t\t\t</tr>\r\n\t  \t\t\t\t\t<tr>\r\n\t  \t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t ");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_ButtonTag_3.setName("btnDeleteNowConsidering");
                  _jspx_th_impact_ButtonTag_3.setImg("btnDelete");
                  _jspx_th_impact_ButtonTag_3.setForm("frmExchangeHomeDetail");
                  _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
                  _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
                  _jspx_th_impact_ButtonTag_3.setAction("/fad/ExchangeHomeDetail/deleteNowConsidering");
                  _jspx_th_impact_ButtonTag_3.setFunction("return confirmDelete();");
                  _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
                  int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
                  if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t  \t\t\t\t\t</tr>\r\n\t  \t\t\t\t</table>\r\n\t  \t\t\t</td>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr>\r\n\t        \t<th colspan=\"4\">Family Has Seen the Following Children</th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr>\r\n\t  \t\t\t<td>\r\n\t  \t\t\t\t<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n\t\t\t\t\t  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\t\t\t\t\t    <tr>\r\n\t\t\t\t\t      <th class=\"thList\">&nbsp;</th>\r\n\t\t\t\t\t      <th class=\"thList\">Last Name</th>\r\n\t\t\t\t\t      <th class=\"thList\">First Name</th>\r\n\t\t\t\t\t      <th class=\"thList\">Non-Availability Reason Code");
                  //  impact:sortableColumnHeader
                  gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
                  _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_sortableColumnHeader_2.setOrderBy(ExchangeHomeDetailConversation.SORT_BY_NON_AVAIL_RSN_CODE);
                  _jspx_th_impact_sortableColumnHeader_2.setIsDefault("false");
                  int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
                  if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</th>\r\n\t\t\t\t\t      <th class=\"thList\">Non-Selection Reason Code</th>\r\n\t\t\t\t\t      <th class=\"thList\">DOB</th>\r\n\t\t\t\t\t      <th class=\"thList\">Gender</th>\r\n\t\t\t\t\t      <th class=\"thList\">County</th>\r\n\t\t\t\t\t      <th class=\"thList\">Date Out");
                  //  impact:sortableColumnHeader
                  gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
                  _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
                  _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_sortableColumnHeader_3.setOrderBy(ExchangeHomeDetailConversation.SORT_BY_DT_OUT);
                  _jspx_th_impact_sortableColumnHeader_3.setIsDefault("true");
                  int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
                  if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</th>\r\n\t\t\t\t\t    </tr>\r\n\t\t\t\t\t\t    ");

						    List childrenNonSelectedList = exchangeHomeDetailSO.getChildrenNonSelectedList();
						    if((childrenNonSelectedList != null) && (childrenNonSelectedList.size() > 0)) {
							  	Iterator itr = childrenNonSelectedList.iterator();
							  	int loopCount = 0;
							 	while (itr.hasNext()) {
							   		ExchangeHomeChildrenSO childNonSelected = (ExchangeHomeChildrenSO) itr.next();
							   		String cbName = "cbUnlinkedLinked_" + loopCount;
							   		String childName = childNonSelected.getLastName() + ", " + childNonSelected.getFirstName();
							
                  out.write("\r\n\t\t\t\t\t\t<tr class=\"");
                  out.print( FormattingHelper.getRowCss(++loopCount) );
                  out.write("\">\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t        \t\t\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateInput_15.setType("checkbox");
                  _jspx_th_impact_validateInput_15.setName(cbName);
                  _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateInput_15.setChecked(ArchitectureConstants.N);
                  _jspx_th_impact_validateInput_15.setDisabled(isDisabled);
                  _jspx_th_impact_validateInput_15.setValue( ArchitectureConstants.TRUE );
                  int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
                  if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t     \t\t\t\t\t\t </td>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t <td>\r\n\t\t\t\t\t\t\t        <a href=\"javascript:navigateToPersonDetail('");
                  out.print(childNonSelected.getIdExchangeChildEvent());
                  out.write("', '");
                  out.print(childNonSelected.getIdChild());
                  out.write("', '");
                  out.print(childName);
                  out.write("')\" \r\n\t\t\t\t\t\t\t           onclick=\"setIsDirtyCalled(true)\" \r\n\t\t\t\t\t\t\t           tabIndex=\"");
                  out.print(tabIndex++ );
                  out.write("\">\r\n\t\t\t\t\t\t\t          ");
                  out.print(childNonSelected.getLastName());
                  out.write("\r\n\t\t\t\t\t\t\t        </a>\r\n\t\t\t\t\t\t\t     </td>\r\n\t\t\t\t\t\t\t     <td>");
                  out.print(FormattingHelper.formatString(childNonSelected.getFirstName()));
                  out.write("</td>\r\n\t\t\t\t\t\t\t     <td>");
                  out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CANONAV, childNonSelected.getCdNonAviReasonCode())));
                  out.write("</td>\r\n\t\t\t\t\t\t\t     <td>");
                  out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CADNSLCT, childNonSelected.getCdNonSelReasonCode())));
                  out.write("</td>\r\n\t\t\t\t\t\t\t     <td><nobr>");
                  out.print(FormattingHelper.formatDate(childNonSelected.getDtDOB()));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t\t     <td><nobr>");
                  out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CSEX, childNonSelected.getCdGender())));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t\t     <td>");
                  out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, childNonSelected.getCdCounty())));
                  out.write("</td>\r\n\t\t\t\t\t\t\t     <td><nobr>");
                  out.print(FormattingHelper.formatDate(childNonSelected.getDtDateOut()));
                  out.write("</nobr></td>\r\n\t\t\t\t\t\t    </tr>\r\n\t\t\t\t\t\t    ");

						  } //end while (itr.hasNext()
					  	} else {
					  		
                  out.write("\r\n\t\t\t\t\t  \t\t\t<tr class=\"subDetail\"><td colspan=\"9\">No Results Found</td></tr>\r\n\t\t\t\t\t\t    ");

					  	}
						
                  out.write("\r\n\t\t\t\t\t   </table>\r\n\t\t\t\t\t </div>\r\n\t  \t\t\t</td>\r\n\t  \t\t</tr>\r\n\t\t</table>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE16\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t\t");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_ButtonTag_4.setName("btnDeleteHasConsidered");
                  _jspx_th_impact_ButtonTag_4.setAlign("right");
                  _jspx_th_impact_ButtonTag_4.setImg("btnDelete");
                  _jspx_th_impact_ButtonTag_4.setForm("frmExchangeHomeDetail");
                  _jspx_th_impact_ButtonTag_4.setAction("/fad/ExchangeHomeDetail/deleteHasBeenConsidered");
                  _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
                  _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
                  _jspx_th_impact_ButtonTag_4.setFunction("return confirmDelete();");
                  _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
                  if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t ");
                  int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n\t<br>\t\r\n");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("closeRecords");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Close Records");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE13\">\r\n\t  \t\t<tr>\r\n\t        \t<th colspan=\"4\">Closed No Placement</th>\r\n\t  \t\t</tr>\r\n\t\t  \t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDate_3.setLabel("Date");
              _jspx_th_impact_validateDate_3.setName("dateClosedNP");
              _jspx_th_impact_validateDate_3.setType("text");
              _jspx_th_impact_validateDate_3.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtClosedNP()));
              _jspx_th_impact_validateDate_3.setSize("10");
              _jspx_th_impact_validateDate_3.setConditionallyRequired("false");
              _jspx_th_impact_validateDate_3.setDisabled(isDisabled);
              _jspx_th_impact_validateDate_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_3.setConstraint("Date");
              int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
              if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t  \t\t\t<td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateSelect_8.setName("selSzCdResaonClosed");
              _jspx_th_impact_validateSelect_8.setColspan("1");
              _jspx_th_impact_validateSelect_8.setValue( FormattingHelper.formatString(exchangeHomeDetailSO.getCdReasonClosed()) );
              _jspx_th_impact_validateSelect_8.setRequired("false");
              _jspx_th_impact_validateSelect_8.setCodesTable(CodesTables.CADEXCLD);
              _jspx_th_impact_validateSelect_8.setDisabled(isDisabled);
              _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_8.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_8.setLabel("Reason Closed");
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n         \t\t<td></td>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t        \t<td>\r\n\t\t\t       ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTextArea_3.setName("txtExplanationNPComments");
              _jspx_th_impact_validateTextArea_3.setColspan("4");
              _jspx_th_impact_validateTextArea_3.setLabel("Explanation");
              _jspx_th_impact_validateTextArea_3.setRows("4");
              _jspx_th_impact_validateTextArea_3.setCols("110");
              _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_3.setDisabled(isDisabled);
              _jspx_th_impact_validateTextArea_3.setMaxLength(500);
              _jspx_th_impact_validateTextArea_3.setConstraint("Paragraph500");
              int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
              if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_3.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t           ");
                  out.print(FormattingHelper.formatString(exchangeHomeDetailSO.getExplanationNPComments()));
                  out.write("\r\n\t\t\t       ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t     </td>\r\n\t  \t\t</tr>\r\n\t\t</table>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE14\">\r\n\t  \t\t<tr>\r\n\t        \t<th colspan=\"4\">Closed With Placement</th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t\t       \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_31.setName("txtChildrenPlacedCWP");
              _jspx_th_impact_validateDisplayOnlyField_31.setLabel("Child(ren) Placed");
              _jspx_th_impact_validateDisplayOnlyField_31.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getChildrenPlacedCWP()));
              int _jspx_eval_impact_validateDisplayOnlyField_31 = _jspx_th_impact_validateDisplayOnlyField_31.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t       \t<td></td>\r\n         \t\t<td></td>\r\n\t\t    </tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t\t      \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_32.setName("txtDatePlacedCWP");
              _jspx_th_impact_validateDisplayOnlyField_32.setLabel("Date Placed");
              _jspx_th_impact_validateDisplayOnlyField_32.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtPlacedCWP()));
              int _jspx_eval_impact_validateDisplayOnlyField_32 = _jspx_th_impact_validateDisplayOnlyField_32.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t      \t<td></td>\r\n         \t\t<td></td>\r\n\t\t    </tr>\r\n\t    <tr class=\"subDetail\">\r\n\t\t       \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_33.setName("txtPermissionToFileCWP");
              _jspx_th_impact_validateDisplayOnlyField_33.setLabel("Permission To File");
              _jspx_th_impact_validateDisplayOnlyField_33.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtPermFile()));
              int _jspx_eval_impact_validateDisplayOnlyField_33 = _jspx_th_impact_validateDisplayOnlyField_33.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t    \t<td></td>\r\n         \t\t<td></td>\r\n\t\t    </tr>\r\n\t\t    <tr class=\"subDetail\">\r\n\t\t      \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_34.setName("txtDocSendDateCWP");
              _jspx_th_impact_validateDisplayOnlyField_34.setLabel("Documents Sent Date");
              _jspx_th_impact_validateDisplayOnlyField_34.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtDocSendDateCWP()));
              int _jspx_eval_impact_validateDisplayOnlyField_34 = _jspx_th_impact_validateDisplayOnlyField_34.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t    \t<td></td>\r\n         \t\t<td></td>\r\n\t\t    </tr>\r\n\t\t    <tr class=\"subDetail\">\r\n\t\t       \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_35.setName("txtCountyCWP");
              _jspx_th_impact_validateDisplayOnlyField_35.setLabel("County");
              _jspx_th_impact_validateDisplayOnlyField_35.setValue(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, exchangeHomeDetailSO.getCdCountyCWP()));
              int _jspx_eval_impact_validateDisplayOnlyField_35 = _jspx_th_impact_validateDisplayOnlyField_35.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t       \t<td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_16.setType("text");
              _jspx_th_impact_validateInput_16.setValue(FormattingHelper.formatString(exchangeHomeDetailSO.getAFileNumCWP()));
              _jspx_th_impact_validateInput_16.setDisabled(isDisabled);
              _jspx_th_impact_validateInput_16.setName("txtAFileNumCWP");
              _jspx_th_impact_validateInput_16.setLabel("Afile#");
              _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_16.setMaxLength("16");
              _jspx_th_impact_validateInput_16.setSize("16");
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t    </tr>\r\n\t\t    <tr class=\"subDetail\">\r\n\t\t      \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_36.setName("txtDateFinalCWP");
              _jspx_th_impact_validateDisplayOnlyField_36.setLabel("Date Final");
              _jspx_th_impact_validateDisplayOnlyField_36.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtFinalCWP()));
              int _jspx_eval_impact_validateDisplayOnlyField_36 = _jspx_th_impact_validateDisplayOnlyField_36.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t    \t<td></td>\r\n         \t\t<td></td>\r\n\t\t    </tr>\r\n\t\t    <tr class=\"subDetail\">\r\n\t\t      \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_37.setName("txtDateFinalEnteredCWP");
              _jspx_th_impact_validateDisplayOnlyField_37.setLabel("Date Final Entered");
              _jspx_th_impact_validateDisplayOnlyField_37.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtFinalEnteredCWP()));
              int _jspx_eval_impact_validateDisplayOnlyField_37 = _jspx_th_impact_validateDisplayOnlyField_37.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t    \t<td></td>\r\n         \t\t<td></td>\r\n\t\t    </tr>\r\n\t\t    <tr class=\"subDetail\">\r\n\t\t       \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_38.setName("txtDisruptionCWP");
              _jspx_th_impact_validateDisplayOnlyField_38.setLabel("Disruption");
              _jspx_th_impact_validateDisplayOnlyField_38.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtDisruptionCWP()));
              int _jspx_eval_impact_validateDisplayOnlyField_38 = _jspx_th_impact_validateDisplayOnlyField_38.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t    \t<td></td>\r\n         \t\t<td></td>\r\n\t\t    </tr>\r\n\t\t    <tr class=\"subDetail\">\r\n\t\t       \t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_39.setName("txtDissolutionCWP");
              _jspx_th_impact_validateDisplayOnlyField_39.setLabel("Dissolution");
              _jspx_th_impact_validateDisplayOnlyField_39.setValue(FormattingHelper.formatDate(exchangeHomeDetailSO.getDtDissolutionCWP()));
              int _jspx_eval_impact_validateDisplayOnlyField_39 = _jspx_th_impact_validateDisplayOnlyField_39.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t    \t<td></td>\r\n         \t\t<td></td>\r\n\t\t    </tr>\r\n\t\t    <tr class=\"subDetail\">\r\n\t        \t<td>\r\n\t\t\t       ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTextArea_4.setName("txtChildrenPlacedWithCommentCW");
              _jspx_th_impact_validateTextArea_4.setColspan("4");
              _jspx_th_impact_validateTextArea_4.setLabel("Children Placed with");
              _jspx_th_impact_validateTextArea_4.setRows("4");
              _jspx_th_impact_validateTextArea_4.setCols("110");
              _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_4.setDisabled(isDisabled);
              _jspx_th_impact_validateTextArea_4.setMaxLength(500);
              _jspx_th_impact_validateTextArea_4.setConstraint("Paragraph500");
              int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
              if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_4.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t           ");
                  out.print(FormattingHelper.formatString(exchangeHomeDetailSO.getChildrenPlacedWithCommentCWP()));
                  out.write("\r\n\t\t\t       ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t     </td>\r\n\t  \t\t</tr>\r\n\t  \t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n\t\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td colspan=\"4\">\r\n        <br>\r\n        <hr>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n    ");
 if (!PageModeConstants.VIEW.equals(pageMode)) {
          out.write("\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnSave");
          _jspx_th_impact_ButtonTag_5.setAlign("right");
          _jspx_th_impact_ButtonTag_5.setImg("btnSave");
          _jspx_th_impact_ButtonTag_5.setForm("frmExchangeHomeDetail");
          _jspx_th_impact_ButtonTag_5.setAction("/fad/ExchangeHomeDetail/saveExchangeHomeDetail");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    ");
}
          out.write("\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />  \r\n  <input type=\"hidden\" name=\"");
          out.print(ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_EVENT);
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
          out.print(ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_ID);
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
          out.print(ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_NAME);
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
          out.print(ExchangeHomeDetailConversation.LINK_COUNT);
          out.write("\" value=\"");
          out.print(linkedCount);
          out.write("\" />\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmExchangeHomeDetail");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
