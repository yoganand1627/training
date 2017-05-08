package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ServicesByAreaConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import java.util.List;

public final class ClientCharacteristicDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


/**
 * GetFormattedAge  using the string parameters in order to get
 * age converted from months to years and months
 * @return String
 * @param months The number of months for the age
 */
  public String getMonths(int months)
  {
    if (months < 12)
    {
      return ("" + months);
    }
    else
    {
      months = months % 12;
      return ("" + months);
    }
  }

  public String getYears(int months)
  {
    int years = 0;
    if (months < 12)
    {
      return ("" + years);
    }
    else
    {
      years = months / 12;
      return ("" + years);
    }
  }

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


/**
 * JSP Name:     ClientCharacteristicDetail.jsp
 * Created by:   Donald Wilson
 * Date Created: 09/27/02
 *
 * Description:
 * This page allows a user to view, edit or delete the Client Charareristics
 * Detail information.
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/11/03  Todd Reser        Added/modified flowerbox comments and Changelog.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  String selectedServiceIndex = ContextHelper.getStringSafe(request, ServicesByAreaConversation.SELECTED_SERVICE_INDEX_ATTRIBUTE_NAME);
  String pageMode = GlobalData.getAppMode(request);

  String idResource = GlobalData.getUlIdResourceAsString( request );

  //mcclaim, 600 is a value which is guaranteed not to be valid (I guess)
  final int MAGIC_ROW_NUMBER = 600;
  int rownumber = MAGIC_ROW_NUMBER;
  String maleMaxYear = "";
  String maleMaxMonth = "";
  String maleMinYear = "";
  String maleMinMonth = "";
  String femaleMaxYear = "";
  String femaleMaxMonth = "";
  String femaleMinYear = "";
  String femaleMinMonth = "";
  String servicesList = ContextHelper.getStringSafe(request, "servicesList");
  String characteristicName = "";
  List<CodeAttributes> characteristicsOptions = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CLNCHAR2);


  if (StringHelper.isValid(ContextHelper.getStringSafe(request, ServicesByAreaConversation.SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME)))
  {
    rownumber = ContextHelper.getIntSafe(request, ServicesByAreaConversation.SELECTED_CHARACTERISTIC_INDEX_ATTRIBUTE_NAME);
  }
  String dataAction = ContextHelper.getStringSafe(request, "SzCdScrDataAction");

  CRES07SO cres07so = (CRES07SO)state.getAttribute(ServicesByAreaConversation.CRES07SO_ATTRIBUTE_NAME, request);
  ROWCRES07SOG_ARRAY characteristicArray = null;
  ROWCRES07SOG characteristicDetail = null;

  if (StringHelper.checkForEquality(dataAction, "U"))
  {
    if (cres07so != null)
    {
      characteristicArray = cres07so.getROWCRES07SOG_ARRAY();
    }
    if (characteristicArray != null)
    {
      characteristicDetail = characteristicArray.getROWCRES07SOG(rownumber);
      maleMaxYear = getYears(characteristicDetail.getUNbrRsrcCharMaxMAge());
      maleMaxMonth = getMonths(characteristicDetail.getUNbrRsrcCharMaxMAge());
      maleMinYear = getYears(characteristicDetail.getUNbrRsrcCharMinMAge());
      maleMinMonth = getMonths(characteristicDetail.getUNbrRsrcCharMinMAge());
      femaleMaxYear = getYears(characteristicDetail.getUNbrRsrcCharMaxFAge());
      femaleMaxMonth = getMonths(characteristicDetail.getUNbrRsrcCharMaxFAge());
      femaleMinYear = getYears(characteristicDetail.getUNbrRsrcCharMinFAge());
      femaleMinMonth = getMonths(characteristicDetail.getUNbrRsrcCharMinFAge());
      characteristicName = characteristicDetail.getSzCdRsrcCharChrctr();
    }
  }

  boolean hideDeleteButton = false;
  if ("A".equalsIgnoreCase(ContextHelper.getStringSafe(request, "SzCdScrDataAction")))
  {
    hideDeleteButton = true;
  }

  int currPage = 1;
  if (StringHelper.isValid(ContextHelper.getStringSafe(request, "page")))
  {
    currPage = ContextHelper.getIntSafe(request, "page");
  }

  int tabIndex = 1;

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  window.onload = function ()\r\n  {\r\n    document.clientChar.clientCharacteristics.Value = '");
      out.print( characteristicName );
      out.write("';\r\n    document.clientChar.clientCharacteristics.defaultValue = '");
      out.print( characteristicName );
      out.write("';\r\n  };\r\n\r\n  window.onbeforeunload = function ()\r\n  {\r\n      IsDirty();\r\n  };\r\n\r\n  function deleteClientCharacteristicsDetail()\r\n  {\r\n    if (confirm(\"Are you sure you want to delete this record?\"))\r\n    {\r\n\r\n      var rowNumber = ");
      out.print( rownumber );
      out.write(";\r\n      if (rowNumber != ");
      out.print( MAGIC_ROW_NUMBER );
      out.write(")\r\n      {\r\n        document.clientChar.selectedCharacteristicIndex.value = \"");
      out.print( rownumber );
      out.write("\";\r\n      }\r\n      window.onbeforeunload = null;\r\n      document.clientChar.SzCdScrDataAction.value='D';\r\n      disableValidation('clientChar');\r\n      return true;\r\n    }\r\n\r\n    return false;\r\n  }\r\n\r\n function saveClientCharacteristicsDetail()\r\n {\r\n   window.onbeforeunload = null;\r\n   var rowNumber = ");
      out.print( rownumber );
      out.write(";\r\n   if (rowNumber != ");
      out.print( MAGIC_ROW_NUMBER );
      out.write(")\r\n   {\r\n     document.clientChar.selectedCharacteristicIndex.value = \"");
      out.print( rownumber );
      out.write("\";\r\n   }\r\n\r\n   return true;\r\n }\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("clientChar");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ServicesByArea/default");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.ClientCharacteristicDetailValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
          out.write("\" value=\"");
          out.print( pageMode );
          out.write("\"/>\r\n<input type=\"hidden\" name=\"txtUlIdResourceService\" value='");
          out.print( ContextHelper.getStringSafe(request, "txtUlIdResourceService") );
          out.write("'/>\r\n<input type=\"hidden\" name=\"SzCdScrDataAction\" value=\"");
          out.print( dataAction );
          out.write("\"/>\r\n<input type=\"hidden\" name=\"selectedServiceIndex\" value=\"");
          out.print( selectedServiceIndex );
          out.write("\"/>\r\n<input type=\"hidden\" name=\"selectedCharacteristicIndex\" value=\"\"/>\r\n<input type=\"hidden\" name=\"servicesList\" value=\"");
          out.print( servicesList );
          out.write("\"/>\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("page");
          _jspx_th_impact_validateInput_0.setValue( Integer.toString(currPage) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" style=\"HEIGHT: 100px\">\r\n   <tr>\r\n    <th colspan=\"6\">Client Characteristics</th>\r\n   </tr>\r\n   <tr>\r\n     <td colspan=\"2\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Characteristics");
          _jspx_th_impact_validateSelect_0.setValue( characteristicName );
          _jspx_th_impact_validateSelect_0.setName("clientCharacteristics");
          _jspx_th_impact_validateSelect_0.setOptions( characteristicsOptions );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 250px");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n   </tr>\r\n   <tr>\r\n    <th colspan=\"6\"> Male Age Range</th>\r\n   </tr>\r\n   <tr>\r\n     <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setName("malMinYr");
          _jspx_th_impact_validateInput_4.setLabel("Male Min");
          _jspx_th_impact_validateInput_4.setSize("3");
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setConstraint("AgeYear");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue( maleMinYear );
          _jspx_th_impact_validateInput_4.setMaxLength("3");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" Yr\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setName("malMinMo");
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setSize("2");
          _jspx_th_impact_validateInput_5.setConstraint("AgeMonth");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setValue( maleMinMonth );
          _jspx_th_impact_validateInput_5.setMaxLength("2");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" Mo</td>\r\n\r\n     <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setName("malMaxYr");
          _jspx_th_impact_validateInput_6.setLabel("Male Max");
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setSize("3");
          _jspx_th_impact_validateInput_6.setConstraint("AgeYear");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setValue( maleMaxYear );
          _jspx_th_impact_validateInput_6.setMaxLength("3");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" Yr\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setName("malMaxMo");
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setSize("2");
          _jspx_th_impact_validateInput_7.setConstraint("AgeMonth");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setValue( maleMaxMonth );
          _jspx_th_impact_validateInput_7.setMaxLength("2");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" Mo</td>\r\n   </tr>\r\n   <tr>\r\n    <th colspan=\"6\">Female Age Range</th>\r\n   </tr>\r\n   <tr>\r\n     <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setName("femMinYr");
          _jspx_th_impact_validateInput_8.setLabel("Female Min");
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setSize("3");
          _jspx_th_impact_validateInput_8.setConstraint("AgeYear");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setValue( femaleMinYear );
          _jspx_th_impact_validateInput_8.setMaxLength("3");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" Yr\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setName("femMinMo");
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setSize("2");
          _jspx_th_impact_validateInput_9.setConstraint("AgeMonth");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setValue( femaleMinMonth );
          _jspx_th_impact_validateInput_9.setMaxLength("2");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" Mo</td>\r\n\r\n     <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setName("femMaxYr");
          _jspx_th_impact_validateInput_10.setLabel("Female Max");
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setSize("3");
          _jspx_th_impact_validateInput_10.setConstraint("AgeYear");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setValue( femaleMaxYear );
          _jspx_th_impact_validateInput_10.setMaxLength("3");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" Yr\r\n     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setName("femMaxMo");
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setSize("2");
          _jspx_th_impact_validateInput_11.setConstraint("AgeMonth");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setValue( femaleMaxMonth );
          _jspx_th_impact_validateInput_11.setMaxLength("2");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" Mo</td>\r\n   </tr>\r\n</table>\r\n  <input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n\r\n\r\n");
 if (StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT)) {
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"  >\r\n  <tr>\r\n    ");
if (!hideDeleteButton) {
          out.write("\r\n    <td>\r\n     ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction("return deleteClientCharacteristicsDetail();");
          _jspx_th_impact_ButtonTag_0.setForm("clientChar");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ServicesByArea/deleteClientCharacteristicDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
}
          out.write("\r\n    <td align=\"right\" >\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setFunction("return saveClientCharacteristicsDetail();");
          _jspx_th_impact_ButtonTag_1.setForm("clientChar");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/ServicesByArea/saveClientCharacteristicDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
}
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateErrors_0.setFormName("clientChar");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("orderBy");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("orderByDirection");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("validationOverride");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
