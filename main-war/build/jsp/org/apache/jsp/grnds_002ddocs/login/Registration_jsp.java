package org.apache.jsp.grnds_002ddocs.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

public final class Registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // Initialize tabIndex
  int tabIndex = 1;
  String disableTxtOther = "false";
  // Get the serialized request
  String serializedRequestString = (String) request.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  //Get the SO object
  RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = (RetrieveVendorStaffDetailSO)request.getAttribute("retrieveVendorStaffDetailSO");
  String idVendor = StringHelper.EMPTY_STRING;
  List resourceIDList = retrieveVendorStaffDetailSO.getResourceList();

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  window.onload = function ()\r\n  {\r\n   \tenableDisableTxtOther();\r\n  };\r\n  function enableDisableTxtOther()\r\n  {\r\n    var cdReqTyp = document.frmVndrStaffDtl.selReqType.value;\r\n    if ( cdReqTyp == \"");
      out.print(CodesTables.CUSRTYP_PUS);
      out.write("\" ) {\r\n      document.frmVndrStaffDtl.txtOther.value='';\r\n      document.frmVndrStaffDtl.txtOther.disabled=true;\r\n    }else if (cdReqTyp == \"");
      out.print(CodesTables.CUSRTYP_PAD);
      out.write("\") {\r\n      document.frmVndrStaffDtl.txtOther.disabled=false;    \r\n    }\r\n  }\r\n  function getResource(){\r\n    var selRsrc = document.frmVndrStaffDtl.selVendor.value;\r\n    var selNewRsrcNm = \"");
      out.print( StringHelper.EMPTY_STRING );
      out.write("\";\r\n    var selNewRsrcId = \"");
      out.print( StringHelper.EMPTY_STRING );
      out.write("\";\r\n    if (selRsrc.length > 0){\r\n    \tvar commaLocation = selRsrc.search(\",\");\r\n    \tif (commaLocation > 0){\r\n    \t\tselNewRsrcNm = selRsrc.substring(commaLocation+1);\r\n    \t\tselNewRsrcId = selRsrc.substring(0,commaLocation);\r\n    \t}\r\n    }\r\n\tdocument.frmVndrStaffDtl.hdnDisplayRsrcId.value = selNewRsrcId;\r\n  }  \r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmVndrStaffDtl");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setAction("/login/Login/saveVendorStaffDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.common.RegistrationCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.CREATE );
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"hdnFormInformation\" value=\"");
          out.print( request.getParameter( "hdnFormInformation" ) );
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
          out.print( AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY );
          out.write("\"\r\n         value=\"");
          out.print( FormattingHelper.formatString( serializedRequestString ));
          out.write("\">                     \r\n<table border=\"0\"  cellpadding=\"3\" cellspacing=\"0\" align=\"center\">\r\n\t<tr>\r\n\t  <td>                   \r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t  \t<tr>\r\n\t\t    \t<th colspan=\"6\">Basic Data</th>\r\n\t\t  \t</tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setConstraint("Name");
          _jspx_th_impact_validateInput_0.setName("txtFirstName");
          _jspx_th_impact_validateInput_0.setLabel("First Name");
          _jspx_th_impact_validateInput_0.setSize("12");
          _jspx_th_impact_validateInput_0.setMaxLength("12");
          _jspx_th_impact_validateInput_0.setRequired("true");
          _jspx_th_impact_validateInput_0.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setConstraint("Name");
          _jspx_th_impact_validateInput_1.setName("txtMiddleInitial");
          _jspx_th_impact_validateInput_1.setLabel("Middle Initial");
          _jspx_th_impact_validateInput_1.setSize("2");
          _jspx_th_impact_validateInput_1.setMaxLength("1");
          _jspx_th_impact_validateInput_1.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setConstraint("Name");
          _jspx_th_impact_validateInput_2.setName("txtLastName");
          _jspx_th_impact_validateInput_2.setLabel("Last Name");
          _jspx_th_impact_validateInput_2.setSize("22");
          _jspx_th_impact_validateInput_2.setMaxLength("22");
          _jspx_th_impact_validateInput_2.setRequired("true");
          _jspx_th_impact_validateInput_2.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setConstraint("Name");
          _jspx_th_impact_validateInput_3.setName("txtTitle");
          _jspx_th_impact_validateInput_3.setLabel("Title");
          _jspx_th_impact_validateInput_3.setSize("20");
          _jspx_th_impact_validateInput_3.setMaxLength("20");
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setConstraint("Email");
          _jspx_th_impact_validateInput_4.setName("txtEmail");
          _jspx_th_impact_validateInput_4.setLabel("Email");
          _jspx_th_impact_validateInput_4.setSize("50");
          _jspx_th_impact_validateInput_4.setMaxLength("320");
          _jspx_th_impact_validateInput_4.setRequired("true");
          _jspx_th_impact_validateInput_4.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setConstraint("Phone");
          _jspx_th_impact_validateInput_5.setName("txtPhoneNumber");
          _jspx_th_impact_validateInput_5.setLabel("Phone Number");
          _jspx_th_impact_validateInput_5.setSize("15");
          _jspx_th_impact_validateInput_5.setMaxLength("15");
          _jspx_th_impact_validateInput_5.setRequired("true");
          _jspx_th_impact_validateInput_5.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_6.setName("txtPhoneExtension");
          _jspx_th_impact_validateInput_6.setLabel("Ext");
          _jspx_th_impact_validateInput_6.setSize("8");
          _jspx_th_impact_validateInput_6.setMaxLength("8");
          _jspx_th_impact_validateInput_6.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_7.setConstraint("Address");
          _jspx_th_impact_validateInput_7.setName("txtAddress1");
          _jspx_th_impact_validateInput_7.setLabel("Office Address");
          _jspx_th_impact_validateInput_7.setSize("30");
          _jspx_th_impact_validateInput_7.setMaxLength("30");
          _jspx_th_impact_validateInput_7.setRequired("true");
          _jspx_th_impact_validateInput_7.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>\r\n\t\t       <td></td>\r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_8.setConstraint("Address2");
          _jspx_th_impact_validateInput_8.setName("txtAddress2");
          _jspx_th_impact_validateInput_8.setSize("30");
          _jspx_th_impact_validateInput_8.setMaxLength("30");
          _jspx_th_impact_validateInput_8.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     </tr>\r\n\t\t     <tr>                                            \r\n\t\t       <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setConstraint("City");
          _jspx_th_impact_validateInput_9.setName("txtCity");
          _jspx_th_impact_validateInput_9.setLabel("City");
          _jspx_th_impact_validateInput_9.setSize("20");
          _jspx_th_impact_validateInput_9.setMaxLength("20");
          _jspx_th_impact_validateInput_9.setRequired("true");
          _jspx_th_impact_validateInput_9.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t       <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setName("selState");
          _jspx_th_impact_validateSelect_0.setLabel("State");
          _jspx_th_impact_validateSelect_0.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setValue("GA");
          _jspx_th_impact_validateSelect_0.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                                            \r\n\t\t     </tr>\r\n\t\t     <tr>                                            \r\n\t\t       <td>\r\n\t\t       \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_10.setConstraint("Zip");
          _jspx_th_impact_validateInput_10.setName("txtZip");
          _jspx_th_impact_validateInput_10.setLabel("Zip");
          _jspx_th_impact_validateInput_10.setSize("5");
          _jspx_th_impact_validateInput_10.setMaxLength("5");
          _jspx_th_impact_validateInput_10.setRequired("true");
          _jspx_th_impact_validateInput_10.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t       \t&nbsp;&nbsp; - &nbsp;&nbsp;\r\n\t\t       \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setConstraint("ZipSuff");
          _jspx_th_impact_validateInput_11.setName("txtZipSuff");
          _jspx_th_impact_validateInput_11.setSize("4");
          _jspx_th_impact_validateInput_11.setMaxLength("4");
          _jspx_th_impact_validateInput_11.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t       </td>\r\n\t\t       <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setName("selCounty");
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>       \r\n\t\t     </tr> \r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>\r\n\t<tr>\r\n\t  <td>\r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t    <tr>\r\n\t\t    \t<th colspan=\"2\">Access Request</th>\r\n\t\t  \t</tr>\r\n\t\t    <tr>\r\n\t\t     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setName("selReqType");
          _jspx_th_impact_validateSelect_2.setLabel("Request Type");
          _jspx_th_impact_validateSelect_2.setCodesTable("CUSRTYP");
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setEditableMode(EditableMode.ALL );
          _jspx_th_impact_validateSelect_2.setOnChange("enableDisableTxtOther();");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t    </tr>\r\n\t\t\t  <tr>    \r\n\t\t\t    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 160px");
          _jspx_th_impact_validateSelect_3.setLabel("Vendor");
          _jspx_th_impact_validateSelect_3.setName("selVendor");
          _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 240px");
          _jspx_th_impact_validateSelect_3.setOverrideDisplayBadCodes(true);
          _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(idVendor));
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_validateSelect_3.setOnChange("getResource();");
          _jspx_th_impact_validateSelect_3.setDisabled("false");
          _jspx_th_impact_validateSelect_3.setOptions(resourceIDList);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t    </td>    \r\n\t\t\t  </tr>\t\t\r\n\t\t    <tr>\r\n\t\t     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_12.setConstraint("Address");
          _jspx_th_impact_validateInput_12.setName("txtOther");
          _jspx_th_impact_validateInput_12.setLabel("Other");
          _jspx_th_impact_validateInput_12.setSize("30");
          _jspx_th_impact_validateInput_12.setMaxLength("30");
          _jspx_th_impact_validateInput_12.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_12.setEditableMode(EditableMode.ALL );
          _jspx_th_impact_validateInput_12.setDisabled(disableTxtOther );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t    </tr>\r\n\t\t    <tr>\r\n\t\t     <td colspan=2>\r\n\t\t     \tIf you work for multiple resources under an umbrella organization, please submit a registration for access to one resource first. Your administrator will then be able to link you to multiple resources.\r\n\t\t     </td>\r\n\t\t     </tr>     \r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>\r\n\t<tr>\r\n\t  <td>  \r\n\t\t  <table border=\"0\" cellpadding=\"3\" width=\"100%\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t    <tr>\r\n\t\t    \t<th colspan=\"2\">User Agreement</th>\r\n\t\t  \t</tr>\r\n\t\t    <tr>\r\n\t\t     <td align=\"left\">\r\n\t\t        By clicking on the checkbox below, the user agrees to abide by all state and federal laws, rules, and regulations, and the Department of Human Services policy on respecting the confidentiality of an individual's records.  These citations include, but are not limited to, O.C.G.A Sections 49-4-14, 49-5-40, 49-5-41, 50-18-72, and 45 CFR 205.5.  The user understands that all records concerning children placed in the custody of the Department of Human Services or all individuals who are the subject of or are included in a child protective services investigation are made confidential by O.C.G.A  Section 49-5-40 and may not be released to anyone except in compliance with O.C.G.A Section 49-5-41.  The user also understands that information concerning recipients of TANF, Food Stamps, and Medicaid may only be disclosed pursuant to O.C.G.A Section 49-4-14.\r\n");
          out.write("\t\t     </td>\r\n\t\t    </tr>\r\n\t\t    <tr>\r\n\t\t     <td>\r\n\t\t        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_13.setLabel("I accept the agreement");
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setId("idUsrAgrmnt");
          _jspx_th_impact_validateInput_13.setName("cbxUsrAgrmnt");
          _jspx_th_impact_validateInput_13.setRequired("true");
          _jspx_th_impact_validateInput_13.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t     </td>\r\n\t\t    </tr>             \r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>\r\n\t\r\n\t<tr>\r\n\t  <td>  \r\n\t\t  <table border=\"0\" cellpadding=\"3\" width=\"100%\" cellspacing=\"0\" class=\"tableBorder\" align=\"center\">\r\n\t\t    <tr>\r\n\t\t    \t<th colspan=\"3\">Password</th>\r\n\t\t  \t</tr>\t\r\n\t        <tr>\r\n            \t<td width=\"120\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("password");
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_14.setColspan("2");
          _jspx_th_impact_validateInput_14.setName("txtNewPassword");
          _jspx_th_impact_validateInput_14.setLabel("New Password");
          _jspx_th_impact_validateInput_14.setRequired("true");
          _jspx_th_impact_validateInput_14.setMaxLength("20");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          \t</tr>\r\n          \t<tr>\r\n            \t<td width=\"120\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("password");
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setColspan("2");
          _jspx_th_impact_validateInput_15.setName("txtNewPasswordConfirm");
          _jspx_th_impact_validateInput_15.setLabel("Re-Enter New Password");
          _jspx_th_impact_validateInput_15.setRequired("true");
          _jspx_th_impact_validateInput_15.setMaxLength("20");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          \t</tr>\r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>\r\n\t\r\n\t\r\n\t<tr>\r\n\t  <td>  \r\n\t\t  <table border=\"0\" cellpadding=\"3\" width=\"100%\" cellspacing=\"0\" class=\"tableBorder\" align=\"left\">\r\n\t\t    <tr>\r\n\t\t    \t<th colspan=\"6\">Security Questions</th>\r\n\t\t  \t</tr>\r\n\t\t    <tr>\r\n\t\t     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setName("selSecQues1");
          _jspx_th_impact_validateSelect_4.setCodesTable("CSECQUES");
          _jspx_th_impact_validateSelect_4.setRequired("true");
          _jspx_th_impact_validateSelect_4.setLabel("Question 1");
          _jspx_th_impact_validateSelect_4.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t     </td>\r\n\t\t     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("text");
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_16.setName("txtSecAns1");
          _jspx_th_impact_validateInput_16.setSize("30");
          _jspx_th_impact_validateInput_16.setMaxLength("30");
          _jspx_th_impact_validateInput_16.setRequired("true");
          _jspx_th_impact_validateInput_16.setLabel("Answer 1");
          _jspx_th_impact_validateInput_16.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t     </td>\r\n\t\t    </tr>\r\n\t\t    <tr>\r\n\t\t     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_5.setName("selSecQues2");
          _jspx_th_impact_validateSelect_5.setCodesTable("CSECQUES");
          _jspx_th_impact_validateSelect_5.setRequired("true");
          _jspx_th_impact_validateSelect_5.setLabel("Question 2");
          _jspx_th_impact_validateSelect_5.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_17.setName("txtSecAns2");
          _jspx_th_impact_validateInput_17.setSize("30");
          _jspx_th_impact_validateInput_17.setMaxLength("30");
          _jspx_th_impact_validateInput_17.setRequired("true");
          _jspx_th_impact_validateInput_17.setLabel("Answer 2");
          _jspx_th_impact_validateInput_17.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                                            \r\n\t\t    </tr>\r\n\t\t    <tr>\r\n\t\t     <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_6.setName("selSecQues3");
          _jspx_th_impact_validateSelect_6.setCodesTable("CSECQUES");
          _jspx_th_impact_validateSelect_6.setRequired("true");
          _jspx_th_impact_validateSelect_6.setLabel("Question 3");
          _jspx_th_impact_validateSelect_6.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_18.setName("txtSecAns3");
          _jspx_th_impact_validateInput_18.setSize("30");
          _jspx_th_impact_validateInput_18.setMaxLength("30");
          _jspx_th_impact_validateInput_18.setRequired("true");
          _jspx_th_impact_validateInput_18.setLabel("Answer 3");
          _jspx_th_impact_validateInput_18.setEditableMode(EditableMode.ALL );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                                            \r\n\t\t    </tr>                     \r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>\r\n\t<tr>      \r\n\t  <td>\r\n\t\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"left\">\r\n\t\t  \t<tr>\r\n\t\t  \t\t<td></td>\r\n\t\t  \t\t<td width=\"100%\">\r\n\t\t  \t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("Submit");
          _jspx_th_impact_ButtonTag_0.setImg("btnSubmit");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmVndrStaffDtl");
          _jspx_th_impact_ButtonTag_0.setAction("/login/Login/saveVendorStaffDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t  \t\t</td>\r\n\t\t  \t</tr>\r\n\t\t  </table>\r\n\t  </td>\r\n\t</tr>\r\n</table>\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName("hdnDisplayRsrcId");
          _jspx_th_impact_validateInput_19.setValue( StringHelper.EMPTY_STRING );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  document.frmVndrStaffDtl.txtFirstName.focus();\r\n</script>");
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
    _jspx_th_impact_validateErrors_0.setFormName("vndrStaffDtl");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
