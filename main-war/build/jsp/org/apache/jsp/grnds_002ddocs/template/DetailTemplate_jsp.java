package org.apache.jsp.grnds_002ddocs.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicitySubDB;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
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
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;

public final class DetailTemplate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/person/RaceEthnicitySub.jsp");
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Set the page mode (hardcoded -- use PageMode.getPageMode(request) in real JSPs).
  String pageMode = PageModeConstants.EDIT;

  // Create a 1-based tab index variable that can be used to set tab indices down the page.
  int tabIndex = 1;

  // Get the CRES03SO output object out of the request
  CRES03SO cres03so = (CRES03SO) request.getAttribute("CRES03SO");
  // Null catch for cres03so, if null set to blank (initialize)
  if (cres03so == null) {
    cres03so = new CRES03SO();
  }
  // Null catch for ROW objects, if not null get rows
  ROWCRES03SOG00_ARRAY rowcres03sog00_array;
  if (cres03so.getROWCRES03SOG00_ARRAY() != null) {
    rowcres03sog00_array = cres03so.getROWCRES03SOG00_ARRAY();
  } else {
    rowcres03sog00_array = new ROWCRES03SOG00_ARRAY();
  }

  //Initialize the variables that will specify the display rules for individual fields
  //EXAMPLE
//  boolean bChecked = false;
//  boolean bRequired = true;
//  boolean bPhoneTypeDisabled = true;
//  boolean bSaveButtonHide = false;
//  boolean bDeleteButtonHide = false;

  //Using variables passed in on the request, set the display for the page
  //EXAMPLE
  String szCReqFuncCd = ServiceConstants.REQ_FUNC_CD_LIST; // Default value, for if the request parameter isn't set.
  if (request.getParameter("cReqFuncCd") != null) {
    szCReqFuncCd = request.getParameter("cReqFuncCd");
  }

  // Get the user profile, if needed.
  UserProfile user = UserProfileHelper.getUserProfile(request);

  // Some variables to display data types for which resources do not contain examples; ususally, these values would
  //   be populated from GlobalData, request attributes, or request parameters.
  String blank = "";
  String nonBlank = "something";
  String dateOfBirth = "07/01/1970";
  String dateOfReBirth = "04/01/1998";

  // Some fake pre-computed values; ususally these would be determined from values in GlobalData, request attributes
  //   or request parameters.
  boolean bDeleteButtonHide = request.getAttribute("doesNotExist") == null;
  boolean bSaveButtonHide = "FakeValue".equals(GlobalData.getSzCdStage(request));

      out.write('\r');
      out.write('\n');
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/document/document.js\"></script>\r\n\r\n");
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n  /*\r\n   This function is called before the page unloads. It creates the\r\n   \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  };\r\n\r\n  // Custom function to handle submitting the form via links in a list\r\n  function submitFormDetailTemplate(counter, updateIndicator, rbValue)\r\n  {\r\n    // Add logic here to do something with parameters passed\r\n    // then call submitValidateForm()\r\n  }\r\n\r\n  //Submit the form with the correct cReqFuncCd for deleting.\r\n  function deletePhoneRow()\r\n  {\r\n    bRetValue = confirm('");
      out.print( MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") );
      out.write("')\r\n    if (bRetValue)\r\n    {\r\n      disableValidation(\"frmDetailTemplate\");\r\n    }\r\n    else\r\n    {\r\n      enableValidation(\"frmDetailTemplate\");\r\n    }\r\n    return bRetValue;\r\n  }\r\n\r\n  //Assign the corrective action codes table CCORACTN to the static variable correctiveActionCodesTable\r\n  ");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n  function populateCorrectiveAction()\r\n  {\r\n    //Check to see if the Recommended Action is Corrective Action\r\n    if (frmDetailTemplate.selSzCdStageReasonClosed.options.value == '20')\r\n    {\r\n      //Call the populateDropdown method (from impact.js) to attach the codes table.\r\n      populateDropdown(frmDetailTemplate.selSzCdLicngInvstCoractn, \"\", correctiveActionCodesTable);\r\n    }\r\n    //if anything other than Corrective Action was selected for Recommended Action the codes table should be removed.\r\n    else\r\n    {\r\n      //Call the clearDropdown method (from impact.js) to remove the codes table.\r\n      clearDropdown(frmDetailTemplate.selSzCdLicngInvstCoractn);\r\n    }\r\n  }\r\n</script>\r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmDetailTemplate");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/template/DetailTemplate/save");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("ulIdResource");
          _jspx_th_impact_validateInput_0.setValue( String.valueOf( cres03so.getUlIdResource() ) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("cReqFuncCd");
          _jspx_th_impact_validateInput_1.setValue( szCReqFuncCd );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("tsLastUpdate");
          _jspx_th_impact_validateInput_2.setValue( SerializationHelper.serializeObject( cres03so.getTsLastUpdate() ) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n        ");
          out.write("\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp;\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"4\">Table Title (copy from \"Begin Detail\" to \"End Detail\")</th>\r\n</tr>\r\n<tr>\r\n    ");
          out.write("\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setLabel("Name");
          _jspx_th_impact_validateInput_3.setConstraint("Name50");
          _jspx_th_impact_validateInput_3.setName("txtSzNmResource");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setValue( String.valueOf( cres03so.getSzNmResource() ) );
          _jspx_th_impact_validateInput_3.setSize("30");
          _jspx_th_impact_validateInput_3.setMaxLength("50");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_4.setLabel("Label 3 (EditableMode.NONE)");
          _jspx_th_impact_validateInput_4.setConstraint("Digit16Less");
          _jspx_th_impact_validateInput_4.setName("txtLNbrRsrcFacilAcclaim");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue( String.valueOf( cres03so.getLNbrRsrcFacilAcclaim() ) );
          _jspx_th_impact_validateInput_4.setSize("10");
          _jspx_th_impact_validateInput_4.setMaxLength("10");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Label 3 (disabled=true)");
          _jspx_th_impact_validateSelect_0.setColspan("3");
          _jspx_th_impact_validateSelect_0.setName("selSzCdRsrcFacilType");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable("CRSCPHON");
          _jspx_th_impact_validateSelect_0.setDisabled("true");
          _jspx_th_impact_validateSelect_0.setValue( cres03so.getSzCdRsrcFacilType() );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <th colspan=\"4\">Subsection Title</th>\r\n</tr>\r\n<tr>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Label 4");
          _jspx_th_impact_validateSelect_1.setName("selSzCdFacilPhoneType");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable("CRSCPHON");
          _jspx_th_impact_validateSelect_1.setValue( cres03so.getSzCdRsrcFacilType() );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Label 5");
          _jspx_th_impact_validateSelect_2.setName("selSzCdFacilPhoneType");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable("CRSCPHON");
          _jspx_th_impact_validateSelect_2.setValue( cres03so.getSzCdRsrcFacilType() );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td valign=\"top\"><!--- Text Area Custom Tag --->\r\n    ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtTxtRsrcComments");
          _jspx_th_impact_validateTextArea_0.setColspan("3");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("50");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
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
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <th colspan=\"4\">Checkbox and radiobutton Examples</th>\r\n</tr>\r\n  ");
          out.write("\r\n<tr>\r\n  <th colspan=\"4\">Calendar Date Field and Time Field Example</th>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_0.setLabel("Time of Birth");
          _jspx_th_impact_validateTime_0.setColspan("3");
          _jspx_th_impact_validateTime_0.setName("txtTimeBirth");
          _jspx_th_impact_validateTime_0.setValue( "12:22 PM" );
          _jspx_th_impact_validateTime_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateTime_0 = _jspx_th_impact_validateTime_0.doStartTag();
          if (_jspx_th_impact_validateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDateBirth");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setLabel("Date of Birth");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue( dateOfBirth );
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td><!--- Need the closing and opening TDs here, since the custom tag only creates the inner TDs --->\r\n  <td>\r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("txtDateReBirth");
          _jspx_th_impact_validateDate_1.setLabel("Date of Re-birth");
          _jspx_th_impact_validateDate_1.setValue( dateOfReBirth );
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <th colspan=\"4\">Select Box Populating another Select box when \"Corrective Action\" is chosen</th>\r\n</tr>\r\n");

  /*  Example of one select box populating another -- Instructions: See tips and FAQs document under Adding a select box which populates another  */

          out.write('\r');
          out.write('\n');

  String corActCodesTable = "";
  String selSzCdStageReasonClosed = "";
  String selSzCdLicngInvstCoractn = "";
  //Check to see onload of the page if there is a Corrective Action and if so, attach the correct codes table
  if (StringHelper.isValid(selSzCdLicngInvstCoractn)) {
    corActCodesTable = "CCORACTN";
  }

          out.write("\r\n<tr>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setColspan("3");
          _jspx_th_impact_validateSelect_3.setLabel("Recommended Action");
          _jspx_th_impact_validateSelect_3.setName("selSzCdStageReasonClosed");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setCodesTable("CLCRECAT");
          _jspx_th_impact_validateSelect_3.setOnChange("populateCorrectiveAction()");
          _jspx_th_impact_validateSelect_3.setValue( selSzCdStageReasonClosed );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setColspan("3");
          _jspx_th_impact_validateSelect_4.setLabel("Corrective Action");
          _jspx_th_impact_validateSelect_4.setName("selSzCdLicngInvstCoractn");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setCodesTable( corActCodesTable );
          _jspx_th_impact_validateSelect_4.setValue( selSzCdLicngInvstCoractn );
          _jspx_th_impact_validateSelect_4.setStyle("WIDTH: 200px");
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <th colspan=\"4\">Display only fields</th>\r\n</tr>\r\n<tr>\r\n  <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("displayOnlyInput");
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Display-only Label");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( dateOfBirth );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n</table>\r\n");
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n      ");
if (!bDeleteButtonHide) {
          out.write("\r\n        ");
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete1");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setFunction("return deletePhoneRow(); alert('next function is called before submit');");
          _jspx_th_impact_ButtonTag_0.setForm("frmDetailTemplate");
          _jspx_th_impact_ButtonTag_0.setAction("/template/DetailTemplate/save");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
} else {
          out.write("\r\n      &nbsp;\r\n      ");
}
          out.write("\r\n    </td>");
          out.write("\r\n    <td>\r\n      ");
 if (!bSaveButtonHide) {
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveFirst");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmDetailTemplate");
          _jspx_th_impact_ButtonTag_1.setAction("/template/DetailTemplate/delete");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
} else {
          out.write("\r\n      &nbsp;\r\n      ");
}
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write("\r\n</br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setIsComplete(true);
          _jspx_th_impact_ExpandableSectionTag_0.setName("DetailTable");
          _jspx_th_impact_ExpandableSectionTag_0.setId("Resource_Status1");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Expandable Section with Detail");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colSpan=\"4\">Table Title 1\r\n      </th>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_5.setLabel("Active");
              _jspx_th_impact_validateInput_5.setType("radio");
              _jspx_th_impact_validateInput_5.setId("Resource_Status1");
              _jspx_th_impact_validateInput_5.setName("rbResourceStatus");
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              _jspx_th_impact_validateInput_5.setChecked("true");
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_6.setLabel("Inactive");
              _jspx_th_impact_validateInput_6.setType("radio");
              _jspx_th_impact_validateInput_6.setId("Resource_Status2");
              _jspx_th_impact_validateInput_6.setName("rbResourceStatus");
              _jspx_th_impact_validateInput_6.setValue( nonBlank );
              _jspx_th_impact_validateInput_6.setCssClass("formInput");
              _jspx_th_impact_validateInput_6.setChecked("false");
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td colspan=\"2\">&nbsp;</td>\r\n    </tr>\r\n    <tr>\r\n      <th colSpan=\"4\">Table Title 2</th>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_5.setValue( blank );
              _jspx_th_impact_validateSelect_5.setName("selResourceFacilityType");
              _jspx_th_impact_validateSelect_5.setBlankValue("true");
              _jspx_th_impact_validateSelect_5.setLabel("Facility Type");
              _jspx_th_impact_validateSelect_5.setOnChange("populateLOC()");
              _jspx_th_impact_validateSelect_5.setStyle("WIDTH: 200px");
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_6.setValue( blank );
              _jspx_th_impact_validateSelect_6.setName("selResourceLoc");
              _jspx_th_impact_validateSelect_6.setLabel("Level of Care");
              _jspx_th_impact_validateSelect_6.setBlankValue("true");
              _jspx_th_impact_validateSelect_6.setStyle("WIDTH: 50px");
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <th colSpan=\"4\">Table Title 3\r\n      </th>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>");
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_7.setType("text");
              _jspx_th_impact_validateInput_7.setName("txtResourceAge");
              _jspx_th_impact_validateInput_7.setLabel("Age");
              _jspx_th_impact_validateInput_7.setCssClass("formInput");
              _jspx_th_impact_validateInput_7.setMaxLength("4");
              _jspx_th_impact_validateInput_7.setSize("4");
              _jspx_th_impact_validateInput_7.setConstraint("Numeric");
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td colspan=\"2\" class=\"subDetail\">&nbsp;</td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_7.setValue( blank  );
              _jspx_th_impact_validateSelect_7.setName("selResourceGender");
              _jspx_th_impact_validateSelect_7.setLabel("Gender");
              _jspx_th_impact_validateSelect_7.setCodesTable("CRSRCSEX");
              _jspx_th_impact_validateSelect_7.setBlankValue("true");
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td colspan=\"2\" class=\"subDetail\">&nbsp;</td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_8.setValue( blank );
              _jspx_th_impact_validateSelect_8.setName("selResourceCharacteristics");
              _jspx_th_impact_validateSelect_8.setLabel("Characteristics");
              _jspx_th_impact_validateSelect_8.setCodesTable("CLNCHAR2");
              _jspx_th_impact_validateSelect_8.setBlankValue("true");
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td colspan=\"2\" class=\"subDetail\">&nbsp;</td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setAnchor("test");
          _jspx_th_impact_ExpandableSectionTag_1.setName("ListTable");
          _jspx_th_impact_ExpandableSectionTag_1.setId("rbAddressIndex1_0");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Expandable Section with List Table");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n\r\n  <div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n      <tr>\r\n        <th class=\"thList\">&nbsp;</th>\r\n        <th class=\"thList\">Type</th>\r\n        <th class=\"thList\">Vendor ID</th>\r\n        <th class=\"thList\">Attention</th>\r\n        <th class=\"thList\">Address</th>\r\n        <th class=\"thList\">County</th>\r\n        <th class=\"thList\" width=\"80\">Comments</th>\r\n      </tr>\r\n      ");

        // We need a loop counter to alternate highlighting properly.
        int loopCount = 0;
        Enumeration addressEnumeration1 = rowcres03sog00_array.enumerateROWCRES03SOG00();
        if (!addressEnumeration1.hasMoreElements()) {
      
              out.write("\r\n      <tr class=\"odd\">\r\n        <td colspan=\"7\">\r\n          ");
              out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
              out.write("\r\n        </td>\r\n      </tr>\r\n      ");

      } else {
        while (addressEnumeration1.hasMoreElements()) {
          ROWCRES03SOG00 rowcres03sog00 = (ROWCRES03SOG00) addressEnumeration1.nextElement();
      
              out.write("\r\n      <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n        ");
 String radioId = "rbAddressIndex1_" + loopCount; 
              out.write("\r\n        <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_8.setType("radio");
              _jspx_th_impact_validateInput_8.setId( radioId );
              _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_8.setName("rbAddressIndex1");
              _jspx_th_impact_validateInput_8.setValue( String.valueOf( loopCount ) );
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n        <td>\r\n            ");
              out.write("\r\n          <a href=\"javascript: submitFormDetailTemplate( '");
              out.print( loopCount );
              out.write("','U', '");
              out.print( rowcres03sog00.getCScrIndRsrcContracted());
              out.write("')\"\r\n             tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onclick=\"window.onBeforeUnload=null;\"\r\n                  >");
              out.print(Lookup.simpleDecodeSafe("CRSCADDR", rowcres03sog00.getSzCdRsrcAddrType()) );
              out.write("</a>\r\n        </td>\r\n        <td>");
              out.print( rowcres03sog00.getSzNbrRsrcAddrVid() );
              out.write("</td>\r\n        <td>");
              out.print( rowcres03sog00.getSzAddrRsrcAddrAttn() );
              out.write("</td>\r\n        <td>");
              out.print( rowcres03sog00.getSzAddrRsrcAddrStLn1() );
              out.write("\r\n          ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrStLn2() );
              out.write("\r\n          ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrCity() );
              out.write(",\r\n          ");
              out.print( rowcres03sog00.getSzCdFacilityState() );
              out.write("\r\n          ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrZip() );
              out.write("</td>\r\n        <td>");
              out.print( Lookup.simpleDecodeSafe("CCOUNT", rowcres03sog00.getSzCdFacilityCounty()) );
              out.write("</td>\r\n        <td align=\"center\">\r\n          ");

            if (StringHelper.isValid(rowcres03sog00.getSzTxtRsrcAddrComments())) {
          
              out.write("\r\n          <IMG src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n          ");

            }
          
              out.write("\r\n        </td>\r\n      </tr>\r\n      ");

            loopCount++;
          }
        }
      
              out.write("\r\n    </table>\r\n  </div>");
              out.write("\r\n  <table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td colspan=\"4\" class=\"tableBG\">\r\n          ");
              out.write("\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_2.setName("btnAdd1");
              _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_2.setForm("frmDetailTemplate");
              _jspx_th_impact_ButtonTag_2.setAction("/template/DetailTemplate/add");
              _jspx_th_impact_ButtonTag_2.setAlign("right");
              _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n<br/>");
 // Begin Expandable Section with Scrolling List Table  
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("Scroll");
          _jspx_th_impact_ExpandableSectionTag_2.setId("rbAddressIndex2_0");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Expandable Section with Scrolling List Table");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information --></div></div>\r\n\r\n  <div id=\"scrollBar2\" style=\"height:165px;width:752px;overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"900\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n      <tr>\r\n        <th class=\"thList\">&nbsp;</th>\r\n        <th class=\"thList\">Type</th>\r\n        <th class=\"thList\">Vendor ID</th>\r\n        <th class=\"thList\">Attention</th>\r\n        <th class=\"thList\">Address</th>\r\n        <th class=\"thList\">County</th>\r\n        <th class=\"thList\" width=\"80\">Comments</th>\r\n      </tr>\r\n      ");

        // We need a loop counter to alternate highlighting properly.
        int loopCount = 0;
        Enumeration addressEnumeration2 = rowcres03sog00_array.enumerateROWCRES03SOG00();
        if (!addressEnumeration2.hasMoreElements()) {
      
              out.write("\r\n      <tr class=\"odd\">\r\n        <td colspan=\"7\">\r\n          ");
              out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
              out.write("\r\n        </td>\r\n      </tr>\r\n      ");

      } else {
        while (addressEnumeration2.hasMoreElements()) {
          ROWCRES03SOG00 rowcres03sog00 = (ROWCRES03SOG00) addressEnumeration2.nextElement();
      
              out.write("\r\n      <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n        ");
 String radioId2 = "rbAddressIndex2_" + loopCount; 
              out.write("\r\n        <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_9.setType("radio");
              _jspx_th_impact_validateInput_9.setId( radioId2 );
              _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_9.setName("rbAddressIndex2");
              _jspx_th_impact_validateInput_9.setValue( String.valueOf( loopCount ) );
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n        <td>\r\n            ");
              out.write("\r\n          <a href=\"javascript:submitFormDetailTemplate( '");
              out.print( loopCount );
              out.write("','U', '");
              out.print( rowcres03sog00.getCScrIndRsrcContracted());
              out.write("')\"\r\n             tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onclick=\"window.onBeforeUnload=null;\"\r\n                  >");
              out.print(Lookup.simpleDecodeSafe("CRSCADDR", rowcres03sog00.getSzCdRsrcAddrType()) );
              out.write("</a>\r\n        </td>\r\n        <td>");
              out.print( rowcres03sog00.getSzNbrRsrcAddrVid() );
              out.write("</td>\r\n        <td>");
              out.print( rowcres03sog00.getSzAddrRsrcAddrAttn() );
              out.write("</td>\r\n        <td>");
              out.print( rowcres03sog00.getSzAddrRsrcAddrStLn1() );
              out.write("\r\n          ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrStLn2() );
              out.write("\r\n          ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrCity() );
              out.write(",\r\n          ");
              out.print( rowcres03sog00.getSzCdFacilityState() );
              out.write("\r\n          ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrZip() );
              out.write("</td>\r\n        <td>");
              out.print( Lookup.simpleDecodeSafe("CCOUNT", rowcres03sog00.getSzCdFacilityCounty()) );
              out.write("</td>\r\n        <td align=\"center\">\r\n          ");

            if (StringHelper.isValid(rowcres03sog00.getSzTxtRsrcAddrComments())) {
          
              out.write("\r\n          <IMG src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n          ");

            }
          
              out.write("\r\n        </td>\r\n      </tr>\r\n      ");

            loopCount++;
          }
        }
      
              out.write("\r\n    </table>\r\n  </div>");
              out.write("\r\n  <table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td colspan=\"4\" class=\"tableBG\">\r\n          ");
              out.write("\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_3.setName("btnAdd2");
              _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_3.setForm("frmDetailTemplate");
              _jspx_th_impact_ButtonTag_3.setAction("/template/DetailTemplate/add");
              _jspx_th_impact_ButtonTag_3.setAlign("right");
              _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n<br/>\r\n<HR>\r\n<br/>\r\n\r\n<div class=\"pageTitle\">List Page Examples (Pagination occurs when enough results are returned):</div>\r\n");
          out.write("\r\n<br/>\r\n");
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/template/DetailTemplate/detail?ulIdResource=18007205");
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  ");
              out.write("\r\n  <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information --></div></div>\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\">\r\n    <tr>\r\n      <td class=\"tableBG\">\r\n        <div id=\"horizontalScrollResults\" style=\"height:335px; width:752px; overflow:auto\" class=\"tableborderList\">\r\n          <table width=\"900\" cellspacing=\"0\" cellpadding=\"3\">\r\n            <tr>\r\n              <th class=\"thList\">&nbsp;</th>\r\n              <th class=\"thList\">Type</th>\r\n              <th class=\"thList\">Vendor ID</th>\r\n              <th class=\"thList\">Attention</th>\r\n              <th class=\"thList\">Address</th>\r\n              <th class=\"thList\">County</th>\r\n              <th class=\"thList\" width=\"80\">Comments</th>\r\n            </tr>\r\n            ");

              // We need a loop counter to alternate highlighting properly.
              int loopCount = 0;
              Enumeration addressEnumeration3 = rowcres03sog00_array.enumerateROWCRES03SOG00();
              if (!addressEnumeration3.hasMoreElements()) {
            
              out.write("\r\n            <tr class=\"odd\">\r\n              <td colspan=\"7\">\r\n                ");
              out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
              out.write("\r\n              </td>\r\n            </tr>\r\n            ");

            } else {
              while (addressEnumeration3.hasMoreElements()) {
                ROWCRES03SOG00 rowcres03sog00 = (ROWCRES03SOG00) addressEnumeration3.nextElement();
            
              out.write("\r\n            <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n              ");
 String radioId3 = "rbAddressIndex3_" + loopCount; 
              out.write("\r\n              <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_10.setType("radio");
              _jspx_th_impact_validateInput_10.setId( radioId3 );
              _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_10.setName("rbAddressIndex3");
              _jspx_th_impact_validateInput_10.setValue( String.valueOf( loopCount ) );
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n              <td>\r\n                  ");
              out.write("\r\n                <a href=\"javascript:submitFormDetailTemplate( '");
              out.print( loopCount );
              out.write("','U', '");
              out.print( rowcres03sog00.getCScrIndRsrcContracted());
              out.write("')\"\r\n                   tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onclick=\"window.onBeforeUnload=null;\"\r\n                        >");
              out.print(Lookup.simpleDecodeSafe("CRSCADDR", rowcres03sog00.getSzCdRsrcAddrType()) );
              out.write("</a></td>\r\n              <td>");
              out.print( rowcres03sog00.getSzNbrRsrcAddrVid() );
              out.write("</td>\r\n              <td>");
              out.print( rowcres03sog00.getSzAddrRsrcAddrAttn() );
              out.write("</td>\r\n              <td>");
              out.print( rowcres03sog00.getSzAddrRsrcAddrStLn1() );
              out.write("<br>\r\n                ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrStLn2() );
              out.write("<br>\r\n                ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrCity() );
              out.write(",\r\n                ");
              out.print( rowcres03sog00.getSzCdFacilityState() );
              out.write("\r\n                ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrZip() );
              out.write("</td>\r\n              <td>");
              out.print( Lookup.simpleDecodeSafe("CCOUNT", rowcres03sog00.getSzCdFacilityCounty()) );
              out.write("</td>\r\n              <td align=\"center\">\r\n                ");

                  if (StringHelper.isValid(rowcres03sog00.getSzTxtRsrcAddrComments())) {
                
              out.write("\r\n                <IMG src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n                ");

                  }
                
              out.write("\r\n              </td>\r\n            </tr>\r\n            ");

                  loopCount++;
                }
              }
            
              out.write("\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
              out.write("\r\n  ");
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 // END HSLD --
          out.write("\r\n\r\n<HR width=\"50%\">\r\n\r\n");
          out.write("\r\n<br/>");
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_1.setSubmitUrl("/template/DetailTemplate/detail?ulIdResource=18007205");
          _jspx_th_impact_pagination_1.setSaveState("false");
          int _jspx_eval_impact_pagination_1 = _jspx_th_impact_pagination_1.doStartTag();
          if (_jspx_eval_impact_pagination_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\">\r\n    <tr>\r\n      <td class=\"tableBG\">\r\n        <div id=\"noScrollResults\" style=\"height:100%; width:100%; overflow:auto\" class=\"tableborderList\">\r\n          <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n            <tr>\r\n              <th class=\"thList\">&nbsp;</th>\r\n              <th class=\"thList\">Type</th>\r\n              <th class=\"thList\">Vendor ID</th>\r\n              <th class=\"thList\">Attention</th>\r\n              <th class=\"thList\">Address</th>\r\n              <th class=\"thList\">County</th>\r\n              <th class=\"thList\" width=\"80\">Comments</th>\r\n            </tr>\r\n            ");

              int loopCount = 0;
              Enumeration addressEnumeration5 = rowcres03sog00_array.enumerateROWCRES03SOG00();
              if (!addressEnumeration5.hasMoreElements()) {
            
              out.write("\r\n            <tr class=\"odd\">\r\n              <td colspan=\"7\">\r\n                ");
              out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
              out.write("\r\n              </td>\r\n            </tr>\r\n            ");

            } else {
              while (addressEnumeration5.hasMoreElements()) {
                ROWCRES03SOG00 rowcres03sog00 = (ROWCRES03SOG00) addressEnumeration5.nextElement();
            
              out.write("\r\n            <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n              ");
 int tabIndexLoop4 = tabIndex++;
                String radioId4 = "rbAddressIndex4_" + loopCount; 
              out.write("\r\n              <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_1);
              _jspx_th_impact_validateInput_11.setType("radio");
              _jspx_th_impact_validateInput_11.setName("rbAddressIndex4");
              _jspx_th_impact_validateInput_11.setId( radioId4 );
              _jspx_th_impact_validateInput_11.setTabIndex( tabIndexLoop4 );
              _jspx_th_impact_validateInput_11.setValue( String.valueOf( loopCount ) );
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n              <td>\r\n                  ");
              out.write("\r\n                <a href=\"javascript:submitFormDetailTemplate( '");
              out.print( loopCount );
              out.write("','U', '");
              out.print( rowcres03sog00.getCScrIndRsrcContracted());
              out.write("')\"\r\n                   tabIndex=\"");
              out.print( tabIndexLoop4 );
              out.write("\" onclick=\"window.onBeforeUnload=null;\">");
              out.print(Lookup.simpleDecodeSafe(
                        "CRSCADDR", rowcres03sog00.getSzCdRsrcAddrType()) );
              out.write("</a></td>\r\n              <td>");
              out.print( rowcres03sog00.getSzNbrRsrcAddrVid() );
              out.write("</td>\r\n              <td>");
              out.print( rowcres03sog00.getSzAddrRsrcAddrAttn() );
              out.write("</td>\r\n              <td>");
              out.print( rowcres03sog00.getSzAddrRsrcAddrStLn1() );
              out.write("\r\n                ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrStLn2() );
              out.write("\r\n                ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrCity() );
              out.write(",\r\n                ");
              out.print( rowcres03sog00.getSzCdFacilityState() );
              out.write("\r\n                ");
              out.print( rowcres03sog00.getSzAddrRsrcAddrZip() );
              out.write("</td>\r\n              <td>");
              out.print( Lookup.simpleDecodeSafe("CCOUNT", rowcres03sog00.getSzCdFacilityCounty()) );
              out.write("</td>\r\n              <td align=\"center\">\r\n                ");

                  if (StringHelper.isValid(rowcres03sog00.getSzTxtRsrcAddrComments())) {
                
              out.write("\r\n                <IMG src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n                ");

                  }
                
              out.write("\r\n              </td>\r\n            </tr>\r\n            ");

                  loopCount++;
                }
              }
            
              out.write("\r\n          </table>\r\n        </div>");
              out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
              out.write("\r\n  ");
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_pagination_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n<br/>\r\n");
/* BEGIN Race Ethnicity Submodule */
          out.write('\r');
          out.write('\n');

  RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
  raceEthnicitySubDB.setTabIndex(tabIndex);
  RaceEthnicitySubDB.setIntoRequest(raceEthnicitySubDB, request);

          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  {
    boolean isExpanded = false;
    RaceEthnicitySubDB raceEthnicitySubRaceEthnicitySubDB = RaceEthnicitySubDB.getFromRequest( request );
    int raceEthnicitySubDBTabIndex = raceEthnicitySubRaceEthnicitySubDB.getTabIndex();
    isExpanded = raceEthnicitySubRaceEthnicitySubDB.getIsExpanded();

    RaceEthnicityBean reBean = null;
    if ( RaceEthnicityHelper.isInRequest( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else if ( RaceEthnicityHelper.isInState( request ) )
    {
      reBean = RaceEthnicityHelper.getFromRequest( request );
    }
    else
    {
      reBean = new RaceEthnicityBean();
    }

    RaceEthnicityBean.Races races = reBean.getRaces();
    List raceValues = null;
    if ( races != null )
    {
      raceValues = races.getStringVector();
    }
    else
    {
      raceValues = new ArrayList();
    }
    String personEthnicity = reBean.getEthnicity();

    Collection ethnicities = Lookup.getCategoryCollection( CodesTables.CINDETHN );

          out.write("\r\n\r\n<script language=\"javascript\">\r\n// make sure at least one race checkbox is checked\r\nfunction isRaceChecked()\r\n{\r\n  var raceLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
          out.write(";\r\n  var cbxGroupName = \"");
          out.print(RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\";\r\n  var bRace = areAnyChecked( cbxGroupName, raceLen );\r\n  return bRace;\r\n}\r\n\r\n// make sure that a radiobutton from the ethnicity radio button group is checked\r\nfunction isEthnicityChecked()\r\n{\r\n  var ethLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CINDETHN ).size() );
          out.write(";\r\n  var bEth = false;\r\n  var ethnicityRb = document.getElementsByName(\"");
          out.print( RaceEthnicityHelper.ETHNICITY_RB_NAME );
          out.write("\");\r\n  for ( i = 0; i < ethLen ; i++ )\r\n  {\r\n    bEth = ethnicityRb[i].checked;\r\n    if ( bEth )\r\n    {\r\n      break;\r\n    }\r\n  }\r\n  return bEth;\r\n}\r\n\r\n// make sure at least one race checkbox is checked or\r\n// a radiobutton from the ethnicity radio button group is checked\r\nfunction isRaceOrEthnicityChecked()\r\n{\r\n  var bRaceOrEth = false;\r\n  bRaceOrEth = ( isEthnicityChecked() || isRaceChecked() );\r\n  return bRaceOrEth;\r\n}\r\n// make sure that the race checkboxes are cleared if the undecided checkbox is checked\r\nfunction clearRaces( paramCbx )\r\n{\r\n  var raceLen = ");
          out.print( Lookup.getCategoryCollection( CodesTables.CRACE ).size() );
          out.write(";\r\n\r\n  if ( paramCbx.checked == true )\r\n  {\r\n    // if you checked the Unable to Determine checkbox, make sure that all the others\r\n    // are unchecked\r\n    if ( paramCbx.value == \"");
          out.print( CodesTables.CRACE_UD  );
          out.write("\" )\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = \"");
          out.print( RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\" + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value != \"");
          out.print( CodesTables.CRACE_UD );
          out.write("\" )\r\n        {\r\n          currentCbx.checked = false;\r\n          // DWW 05/05/2003\r\n          // SIRs 16675, 16868\r\n          // added the fire onclick to have the checkboxes correctly update when\r\n          // the \"unable to determine\" cbx is checked\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n    // else, if you checked any others, make sure Unable to Determine is unchecked\r\n    else\r\n    {\r\n      for ( var i = 1; i <= raceLen; i++ )\r\n      {\r\n        var cbxId = \"");
          out.print( RaceEthnicityHelper.RACE_CB_NAME );
          out.write("\" + i + \"_id\";\r\n        var currentCbx = document.getElementById( cbxId );\r\n        if ( currentCbx.value == \"");
          out.print( CodesTables.CRACE_UD );
          out.write("\" )\r\n        {\r\n          // DWW 05/05/2003\r\n          // SIRs 16675, 16868\r\n          // added the fire onclick to have the checkboxes correctly update when\r\n          // the \"unable to determine\" cbx is checked\r\n          currentCbx.checked = false;\r\n          currentCbx.fireEvent(\"onClick\");\r\n        }\r\n      }\r\n    }\r\n  }\r\n}\r\n</script>\r\n\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("RaceEthnicity");
          _jspx_th_impact_ExpandableSectionTag_3.setId( RaceEthnicityHelper.RACE_CB_NAME + "1_Id");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Race/Ethnicity Detail");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex( raceEthnicitySubDBTabIndex );
          _jspx_th_impact_ExpandableSectionTag_3.setIsExpanded(Boolean.valueOf(isExpanded).booleanValue());
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n   <span class=\"formInstruct\">Race/Ethnicity should never be determined by DFCS staff. Whenever possible, this information must come from the person, if a child, from a parent.</span>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n   <th>Race</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes(raceValues);
              _jspx_th_impact_codesCheckbox_0.setName( RaceEthnicityHelper.RACE_CB_NAME );
              _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CRACE );
              _jspx_th_impact_codesCheckbox_0.setOnClick("clearRaces(this)");
              _jspx_th_impact_codesCheckbox_0.setColumns(3);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_0.setTabIndex( raceEthnicitySubDBTabIndex );
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n   <th>Ethnicity</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      <table width=\"100%\">\r\n        <tr>\r\n");

    for ( Iterator ethIterator = ethnicities.iterator(); ethIterator.hasNext(); )
    {
      Mapping ethnicity = (Mapping) ethIterator.next();

              out.write("\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_12.setValue( ethnicity.getKey() );
              _jspx_th_impact_validateInput_12.setTabIndex( raceEthnicitySubDBTabIndex );
              _jspx_th_impact_validateInput_12.setName( RaceEthnicityHelper.ETHNICITY_RB_NAME );
              _jspx_th_impact_validateInput_12.setType("radio");
              _jspx_th_impact_validateInput_12.setChecked( String.valueOf( ethnicity.getKey().equals( personEthnicity ) ) );
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n              ");
              out.print( ethnicity.getValue() );
              out.write("\r\n          </td>\r\n");

    }

              out.write("\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_13.setType("hidden");
              _jspx_th_impact_validateInput_13.setName( RaceEthnicityHelper.OLD_ETHNICITY_NAME );
              _jspx_th_impact_validateInput_13.setValue( personEthnicity );
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    raceEthnicitySubRaceEthnicitySubDB.setTabIndex( raceEthnicitySubDBTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');

  tabIndex = raceEthnicitySubDB.getTabIndex();
  RaceEthnicitySubDB.removeFromRequest(request);

          out.write('\r');
          out.write('\n');
/* END Race Ethnicity Submodule */
          out.write("\r\n<br>\r\n");
/* BEGIN Admin Address Phone Submodule */
          out.write('\r');
          out.write('\n');

  AdminAddressPhoneSubDB adminAddressPhoneSubDB = new AdminAddressPhoneSubDB();
  adminAddressPhoneSubDB.setFormName("frmDetailTemplate");
  adminAddressPhoneSubDB.setPageMode(pageMode);
  adminAddressPhoneSubDB.setAddressPhoneSectionHeader("Admin Address Phone Submodule");
  adminAddressPhoneSubDB.setAddressRequired(false);
  adminAddressPhoneSubDB.setAddressDisabled(false);
  adminAddressPhoneSubDB.setCommentsVisible(true);
  adminAddressPhoneSubDB.setCommentsRequired(false);
  adminAddressPhoneSubDB.setCommentsDisabled(false);
  adminAddressPhoneSubDB.setPhoneRequired(false);
  adminAddressPhoneSubDB.setPhoneDisabled(false);
  adminAddressPhoneSubDB.setAddressSubmoduleName("first");
  adminAddressPhoneSubDB.setTabIndex(tabIndex);
  AdminAddressPhoneSubDB.setIntoRequest(adminAddressPhoneSubDB, request);

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
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_4.setName( expandableSectionName );
          _jspx_th_impact_ExpandableSectionTag_4.setId(AdminAddressPhoneBean.PHONE + "_Id" );
          _jspx_th_impact_ExpandableSectionTag_4.setLabel( adminAddressPhoneSubAddressPhoneSectionHeader );
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex( adminAddressPhoneSubTabIndex );
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\" class=\"tableBorder\">\r\n   <tr class=\"subDetail\">\r\n     <td>\r\n      <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n        <tr>\r\n          <td width=\"10%\">\r\n              ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_14.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE ) );
              _jspx_th_impact_validateInput_14.setValue( FormattingHelper.formatPhone( aapBean.getPhone() ) );
              _jspx_th_impact_validateInput_14.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_14.setType("text");
              _jspx_th_impact_validateInput_14.setRequired( String.valueOf( adminAddressPhoneSubPhoneRequired ));
              _jspx_th_impact_validateInput_14.setLabel("Phone");
              _jspx_th_impact_validateInput_14.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_14.setCssClass("formInput");
              _jspx_th_impact_validateInput_14.setConstraint("Phone");
              _jspx_th_impact_validateInput_14.setWidth("45%");
              _jspx_th_impact_validateInput_14.setSize("14");
              _jspx_th_impact_validateInput_14.setMaxLength("14");
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          <td width=\"15%\">\r\n             ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_15.setName( aapBean.getAttributeName( AdminAddressPhoneBean.PHONE_EXT ) );
              _jspx_th_impact_validateInput_15.setValue( aapBean.getPhoneExt() );
              _jspx_th_impact_validateInput_15.setDisabled( String.valueOf( adminAddressPhoneSubPhoneDisabled ) );
              _jspx_th_impact_validateInput_15.setType("text");
              _jspx_th_impact_validateInput_15.setLabel("Extension");
              _jspx_th_impact_validateInput_15.setTabIndex( adminAddressPhoneSubTabIndex );
              _jspx_th_impact_validateInput_15.setCssClass("formInput");
              _jspx_th_impact_validateInput_15.setConstraint("PhoneExtension");
              _jspx_th_impact_validateInput_15.setWidth("30%");
              _jspx_th_impact_validateInput_15.setSize("8");
              _jspx_th_impact_validateInput_15.setMaxLength("8");
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_16.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
              _jspx_th_impact_validateInput_16.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
              _jspx_th_impact_validateInput_16.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_16.setType("text");
              _jspx_th_impact_validateInput_16.setRequired( String.valueOf( addressSubStreetRequired ));
              _jspx_th_impact_validateInput_16.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_16.setLabel("Street");
              _jspx_th_impact_validateInput_16.setWidth("45%");
              _jspx_th_impact_validateInput_16.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setConstraint("Address");
              _jspx_th_impact_validateInput_16.setSize("50");
              _jspx_th_impact_validateInput_16.setMaxLength("30");
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_17.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
              _jspx_th_impact_validateInput_17.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
              _jspx_th_impact_validateInput_17.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_17.setType("text");
              _jspx_th_impact_validateInput_17.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_17.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setConstraint("Address");
              _jspx_th_impact_validateInput_17.setSize("50");
              _jspx_th_impact_validateInput_17.setMaxLength("30");
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_18.setName( addressBean.getAttributeName( AddressBean.CITY ) );
              _jspx_th_impact_validateInput_18.setValue(FormattingHelper.formatString( addressBean.getCity() ));
              _jspx_th_impact_validateInput_18.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_18.setType("text");
              _jspx_th_impact_validateInput_18.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateInput_18.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_18.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_18.setLabel("City");
              _jspx_th_impact_validateInput_18.setCssClass("formInput");
              _jspx_th_impact_validateInput_18.setConstraint("City");
              _jspx_th_impact_validateInput_18.setMaxLength("20");
              int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
              if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_9.setName( addressBean.getAttributeName( AddressBean.STATE ));
              _jspx_th_impact_validateSelect_9.setValue( FormattingHelper.formatString( stateDefault ) );
              _jspx_th_impact_validateSelect_9.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_9.setRequired( String.valueOf( addressSubAddressRequired ));
              _jspx_th_impact_validateSelect_9.setCodesTable( CodesTables.CSTATE );
              _jspx_th_impact_validateSelect_9.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_9.setOnChange( onChange );
              _jspx_th_impact_validateSelect_9.setLabel("State");
              int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
              if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_19.setName( addressBean.getAttributeName( AddressBean.ZIP ));
              _jspx_th_impact_validateInput_19.setValue(FormattingHelper.formatString( addressBean.getZip() ));
              _jspx_th_impact_validateInput_19.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_19.setRequired( String.valueOf( addressSubZipRequired  ));
              _jspx_th_impact_validateInput_19.setType("text");
              _jspx_th_impact_validateInput_19.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_19.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_19.setLabel("Zip");
              _jspx_th_impact_validateInput_19.setCssClass("formInput");
              _jspx_th_impact_validateInput_19.setConstraint("Zip");
              _jspx_th_impact_validateInput_19.setMaxLength("5");
              _jspx_th_impact_validateInput_19.setSize("5");
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      -\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_20.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
              _jspx_th_impact_validateInput_20.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
              _jspx_th_impact_validateInput_20.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateInput_20.setType("text");
              _jspx_th_impact_validateInput_20.setOnChange( changeAddress );
              _jspx_th_impact_validateInput_20.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateInput_20.setCssClass("formInput");
              _jspx_th_impact_validateInput_20.setConstraint("ZipSuff");
              _jspx_th_impact_validateInput_20.setMaxLength("4");
              _jspx_th_impact_validateInput_20.setSize("4");
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>\r\n            ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateSelect_10.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
              _jspx_th_impact_validateSelect_10.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
              _jspx_th_impact_validateSelect_10.setDisabled( String.valueOf( addressSubAddressDisabled ) );
              _jspx_th_impact_validateSelect_10.setRequired( String.valueOf( addressSubAddressRequired ) );
              _jspx_th_impact_validateSelect_10.setTabIndex( addressSubTabIndex );
              _jspx_th_impact_validateSelect_10.setBlankValue("true");
              _jspx_th_impact_validateSelect_10.setLabel("County");
              _jspx_th_impact_validateSelect_10.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_10.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_10.setExcludeOptions(addressSubExcludeCounty);
              _jspx_th_impact_validateSelect_10.setOnChange( changeAddress );
              int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
              if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

              out.write("\r\n  <tr>\r\n   <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
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
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_ButtonTag_4.setName("btnvalidate");
              _jspx_th_impact_ButtonTag_4.setImg("btnValidate");
              _jspx_th_impact_ButtonTag_4.setAction("#");
              _jspx_th_impact_ButtonTag_4.setFunction(onclick);
              _jspx_th_impact_ButtonTag_4.setForm(addressSubFormName);
              _jspx_th_impact_ButtonTag_4.setTabIndex(addressSubTabIndex);
              _jspx_th_impact_ButtonTag_4.setOnBlur("setIsDirtyCalled(false);");
              int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
              if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_21(_jspx_th_impact_ExpandableSectionTag_4, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_22(_jspx_th_impact_ExpandableSectionTag_4, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_23.setType("hidden");
              _jspx_th_impact_validateInput_23.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
              _jspx_th_impact_validateInput_23.setValue("true");
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_24.setType("hidden");
              _jspx_th_impact_validateInput_24.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
              _jspx_th_impact_validateInput_24.setValue("true");
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_25.setType("hidden");
              _jspx_th_impact_validateInput_25.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
              _jspx_th_impact_validateInput_25.setValue("");
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_26.setType("hidden");
              _jspx_th_impact_validateInput_26.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
              _jspx_th_impact_validateInput_26.setValue("");
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
  AdminAddressPhoneSubDB.removeFromRequest(request);

          out.write('\r');
          out.write('\n');
/* END Admin Address Phone Submodule */
          out.write("\r\n\r\n");
/* BEGIN Address Submodule */
          out.write('\r');
          out.write('\n');

  AddressSubDB addressSubDB = new AddressSubDB();
  addressSubDB.setFormName("frmDetailTemplate");
  addressSubDB.setPageMode(pageMode);
  addressSubDB.setAddressSubmoduleName("second");
  addressSubDB.setCommentsVisible(true);
  addressSubDB.setCommentsRequired(false);
  addressSubDB.setCommentsDisabled(false);
  addressSubDB.setAddressRequired(false);
  addressSubDB.setAddressDisabled(false);
  addressSubDB.setTabIndex(tabIndex);
  AddressSubDB.setIntoRequest(addressSubDB, request);

          out.write('\r');
          out.write('\n');
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
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
          _jspx_th_impact_validateInput_27.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
          _jspx_th_impact_validateInput_27.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_27.setType("text");
          _jspx_th_impact_validateInput_27.setRequired( String.valueOf( addressSubStreetRequired ));
          _jspx_th_impact_validateInput_27.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_27.setLabel("Street");
          _jspx_th_impact_validateInput_27.setWidth("45%");
          _jspx_th_impact_validateInput_27.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          _jspx_th_impact_validateInput_27.setConstraint("Address");
          _jspx_th_impact_validateInput_27.setSize("50");
          _jspx_th_impact_validateInput_27.setMaxLength("30");
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
          _jspx_th_impact_validateInput_28.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
          _jspx_th_impact_validateInput_28.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_28.setType("text");
          _jspx_th_impact_validateInput_28.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_28.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setConstraint("Address");
          _jspx_th_impact_validateInput_28.setSize("50");
          _jspx_th_impact_validateInput_28.setMaxLength("30");
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setName( addressBean.getAttributeName( AddressBean.CITY ) );
          _jspx_th_impact_validateInput_29.setValue(FormattingHelper.formatString( addressBean.getCity() ));
          _jspx_th_impact_validateInput_29.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_29.setType("text");
          _jspx_th_impact_validateInput_29.setRequired( String.valueOf( addressSubAddressRequired ));
          _jspx_th_impact_validateInput_29.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_29.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_29.setLabel("City");
          _jspx_th_impact_validateInput_29.setCssClass("formInput");
          _jspx_th_impact_validateInput_29.setConstraint("City");
          _jspx_th_impact_validateInput_29.setMaxLength("20");
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_11.setName( addressBean.getAttributeName( AddressBean.STATE ));
          _jspx_th_impact_validateSelect_11.setValue( FormattingHelper.formatString( stateDefault ) );
          _jspx_th_impact_validateSelect_11.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateSelect_11.setRequired( String.valueOf( addressSubAddressRequired ));
          _jspx_th_impact_validateSelect_11.setCodesTable( CodesTables.CSTATE );
          _jspx_th_impact_validateSelect_11.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateSelect_11.setOnChange( onChange );
          _jspx_th_impact_validateSelect_11.setLabel("State");
          int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
          if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setName( addressBean.getAttributeName( AddressBean.ZIP ));
          _jspx_th_impact_validateInput_30.setValue(FormattingHelper.formatString( addressBean.getZip() ));
          _jspx_th_impact_validateInput_30.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_30.setRequired( String.valueOf( addressSubZipRequired  ));
          _jspx_th_impact_validateInput_30.setType("text");
          _jspx_th_impact_validateInput_30.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_30.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_30.setLabel("Zip");
          _jspx_th_impact_validateInput_30.setCssClass("formInput");
          _jspx_th_impact_validateInput_30.setConstraint("Zip");
          _jspx_th_impact_validateInput_30.setMaxLength("5");
          _jspx_th_impact_validateInput_30.setSize("5");
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      -\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
          _jspx_th_impact_validateInput_31.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
          _jspx_th_impact_validateInput_31.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_31.setType("text");
          _jspx_th_impact_validateInput_31.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_31.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_31.setCssClass("formInput");
          _jspx_th_impact_validateInput_31.setConstraint("ZipSuff");
          _jspx_th_impact_validateInput_31.setMaxLength("4");
          _jspx_th_impact_validateInput_31.setSize("4");
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n            ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_12.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
          _jspx_th_impact_validateSelect_12.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
          _jspx_th_impact_validateSelect_12.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateSelect_12.setRequired( String.valueOf( addressSubAddressRequired ) );
          _jspx_th_impact_validateSelect_12.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateSelect_12.setBlankValue("true");
          _jspx_th_impact_validateSelect_12.setLabel("County");
          _jspx_th_impact_validateSelect_12.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_12.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_12.setExcludeOptions(addressSubExcludeCounty);
          _jspx_th_impact_validateSelect_12.setOnChange( changeAddress );
          int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
          if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

          out.write("\r\n  <tr>\r\n   <td>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setLabel("Comments");
          _jspx_th_impact_validateTextArea_2.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
          _jspx_th_impact_validateTextArea_2.setRequired( String.valueOf( addressSubCommentsRequired ) );
          _jspx_th_impact_validateTextArea_2.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
          _jspx_th_impact_validateTextArea_2.setCols("125");
          _jspx_th_impact_validateTextArea_2.setRows("4");
          _jspx_th_impact_validateTextArea_2.setColspan("3");
          _jspx_th_impact_validateTextArea_2.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_2.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.print( FormattingHelper.formatString(addressBean.getComments() ));
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnvalidate");
          _jspx_th_impact_ButtonTag_5.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_5.setAction("#");
          _jspx_th_impact_ButtonTag_5.setFunction(onclick);
          _jspx_th_impact_ButtonTag_5.setForm(addressSubFormName);
          _jspx_th_impact_ButtonTag_5.setTabIndex(addressSubTabIndex);
          _jspx_th_impact_ButtonTag_5.setOnBlur("setIsDirtyCalled(false);");
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_32(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_33(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("hidden");
          _jspx_th_impact_validateInput_34.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
          _jspx_th_impact_validateInput_34.setValue("true");
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("hidden");
          _jspx_th_impact_validateInput_35.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
          _jspx_th_impact_validateInput_35.setValue("true");
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setType("hidden");
          _jspx_th_impact_validateInput_36.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
          _jspx_th_impact_validateInput_36.setValue("");
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setType("hidden");
          _jspx_th_impact_validateInput_37.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
          _jspx_th_impact_validateInput_37.setValue("");
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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

  tabIndex = addressSubDB.getTabIndex();
  AddressSubDB.removeFromRequest(request);

          out.write('\r');
          out.write('\n');
/* END Address Submodule */
          out.write("\r\n\r\n<hr>\r\n<table cellspacing=\"0\" cellPadding=\"3\" width=\"100%\" border=\"0\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n        ");
          out.write("\r\n      ");

        String validate2AddressesOnSave = "return validate2AddressesOnSave( " +
                                          "'frmDetailTemplate', " +
                                          "'/template/DetailTemplate/save', " +
                                          "'first', " +
                                          "'second' );";
      
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_6.setName("btnSaveFinal");
          _jspx_th_impact_ButtonTag_6.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_6.setFunction( validate2AddressesOnSave );
          _jspx_th_impact_ButtonTag_6.setImg("btnSave");
          _jspx_th_impact_ButtonTag_6.setAlign("right");
          _jspx_th_impact_ButtonTag_6.setForm("frmDetailTemplate");
          _jspx_th_impact_ButtonTag_6.setAction("/template/DetailTemplate/save");
          _jspx_th_impact_ButtonTag_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
          if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<br/>\r\n<hr/>\r\n");
      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Forms and Reports (Copy from \"begin Forms and Reports\" to \"end Forms and Reports\")</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
      out.write("\r\n      ");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode("2");
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n        ");
          if (_jspx_meth_impact_document_0(_jspx_th_impact_documentList_0, _jspx_page_context))
            return;
          out.write("\r\n        ");
          if (_jspx_meth_impact_document_1(_jspx_th_impact_documentList_0, _jspx_page_context))
            return;
          out.write("\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n    </td>\r\n    <td>\r\n      ");
      //  impact:reportList
      gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag _jspx_th_impact_reportList_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag();
      _jspx_th_impact_reportList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_reportList_0.setParent(null);
      _jspx_th_impact_reportList_0.setPersonId( user.getUserID() );
      _jspx_th_impact_reportList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_reportList_0 = _jspx_th_impact_reportList_0.doStartTag();
      if (_jspx_eval_impact_reportList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n        ");
          if (_jspx_meth_impact_report_0(_jspx_th_impact_reportList_0, _jspx_page_context))
            return;
          out.write("\r\n        ");
          if (_jspx_meth_impact_report_1(_jspx_th_impact_reportList_0, _jspx_page_context))
            return;
          out.write("\r\n        ");
          if (_jspx_meth_impact_report_2(_jspx_th_impact_reportList_0, _jspx_page_context))
            return;
          out.write("\r\n        ");
          if (_jspx_meth_impact_report_3(_jspx_th_impact_reportList_0, _jspx_page_context))
            return;
          out.write("\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_reportList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_reportList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CCORACTN");
    _jspx_th_impact_codeArray_0.setArrayName("correctiveActionCodesTable");
    _jspx_th_impact_codeArray_0.setBlankValue("false");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_21(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
    _jspx_th_impact_validateInput_21.setType("hidden");
    _jspx_th_impact_validateInput_21.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_21.setValue("0");
    int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
    if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_22(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_ExpandableSectionTag_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
    _jspx_th_impact_validateInput_22.setType("hidden");
    _jspx_th_impact_validateInput_22.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_22.setValue("0");
    int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
    if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_32(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_32.setType("hidden");
    _jspx_th_impact_validateInput_32.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_32.setValue("0");
    int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
    if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_33(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_33.setType("hidden");
    _jspx_th_impact_validateInput_33.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_33.setValue("0");
    int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
    if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_document_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_documentList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:document
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
    _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
    _jspx_th_impact_document_0.setDisplayName("Call Narrative");
    _jspx_th_impact_document_0.setProtectDocument(false);
    _jspx_th_impact_document_0.setCheckStage(12132);
    _jspx_th_impact_document_0.setDocType("CALLNARR");
    _jspx_th_impact_document_0.setDocExists(true);
    int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
    if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n          ");
        if (_jspx_meth_impact_documentParameter_0(_jspx_th_impact_document_0, _jspx_page_context))
          return true;
        out.write("\r\n        ");
        int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_documentParameter_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_document_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:documentParameter
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
    _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
    _jspx_th_impact_documentParameter_0.setName("pStage");
    _jspx_th_impact_documentParameter_0.setValue("12121");
    int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
    if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_document_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_documentList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:document
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
    _jspx_th_impact_document_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_document_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
    _jspx_th_impact_document_1.setDisplayName("Intake Report");
    _jspx_th_impact_document_1.setProtectDocument(true);
    _jspx_th_impact_document_1.setCheckStage(12132);
    _jspx_th_impact_document_1.setDocType("CSC34o00");
    _jspx_th_impact_document_1.setDocExists(false);
    int _jspx_eval_impact_document_1 = _jspx_th_impact_document_1.doStartTag();
    if (_jspx_eval_impact_document_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n          ");
        if (_jspx_meth_impact_documentParameter_1(_jspx_th_impact_document_1, _jspx_page_context))
          return true;
        out.write("\r\n        ");
        int evalDoAfterBody = _jspx_th_impact_document_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_document_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_documentParameter_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_document_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:documentParameter
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
    _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
    _jspx_th_impact_documentParameter_1.setName("pStage");
    _jspx_th_impact_documentParameter_1.setValue("23232");
    int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
    if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_report_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_reportList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:report
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
    _jspx_th_impact_report_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_report_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
    _jspx_th_impact_report_0.setUseHiddenParameters(true);
    _jspx_th_impact_report_0.setReportName("ccf02o00");
    int _jspx_eval_impact_report_0 = _jspx_th_impact_report_0.doStartTag();
    if (_jspx_th_impact_report_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_report_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_reportList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:report
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_1 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
    _jspx_th_impact_report_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_report_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
    _jspx_th_impact_report_1.setUseHiddenParameters(true);
    _jspx_th_impact_report_1.setReportName("ccf03o00");
    int _jspx_eval_impact_report_1 = _jspx_th_impact_report_1.doStartTag();
    if (_jspx_th_impact_report_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_report_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_reportList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:report
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_2 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
    _jspx_th_impact_report_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_report_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
    _jspx_th_impact_report_2.setUseHiddenParameters(false);
    _jspx_th_impact_report_2.setReportName("cfn51o01");
    int _jspx_eval_impact_report_2 = _jspx_th_impact_report_2.doStartTag();
    if (_jspx_eval_impact_report_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n          ");
        if (_jspx_meth_impact_reportParameter_0(_jspx_th_impact_report_2, _jspx_page_context))
          return true;
        out.write("\r\n        ");
        int evalDoAfterBody = _jspx_th_impact_report_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_report_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_reportParameter_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_report_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:reportParameter
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag _jspx_th_impact_reportParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag();
    _jspx_th_impact_reportParameter_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_reportParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_report_2);
    _jspx_th_impact_reportParameter_0.setValue("5600240");
    int _jspx_eval_impact_reportParameter_0 = _jspx_th_impact_reportParameter_0.doStartTag();
    if (_jspx_th_impact_reportParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_report_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_reportList_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:report
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_3 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
    _jspx_th_impact_report_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_report_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
    _jspx_th_impact_report_3.setUseHiddenParameters(false);
    _jspx_th_impact_report_3.setReportName("cfn05o01");
    int _jspx_eval_impact_report_3 = _jspx_th_impact_report_3.doStartTag();
    if (_jspx_eval_impact_report_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n          ");
        if (_jspx_meth_impact_reportParameter_1(_jspx_th_impact_report_3, _jspx_page_context))
          return true;
        out.write("\r\n          ");
        if (_jspx_meth_impact_reportParameter_2(_jspx_th_impact_report_3, _jspx_page_context))
          return true;
        out.write("\r\n        ");
        int evalDoAfterBody = _jspx_th_impact_report_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_report_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_reportParameter_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_report_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:reportParameter
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag _jspx_th_impact_reportParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag();
    _jspx_th_impact_reportParameter_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_reportParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_report_3);
    _jspx_th_impact_reportParameter_1.setValue("03");
    int _jspx_eval_impact_reportParameter_1 = _jspx_th_impact_reportParameter_1.doStartTag();
    if (_jspx_th_impact_reportParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_reportParameter_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_report_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:reportParameter
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag _jspx_th_impact_reportParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag();
    _jspx_th_impact_reportParameter_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_reportParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_report_3);
    _jspx_th_impact_reportParameter_2.setValue("/opt/impact/config/devl/applications/impact/xmlTest/reports");
    int _jspx_eval_impact_reportParameter_2 = _jspx_th_impact_reportParameter_2.doStartTag();
    if (_jspx_th_impact_reportParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
