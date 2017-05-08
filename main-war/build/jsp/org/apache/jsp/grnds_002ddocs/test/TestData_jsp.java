package org.apache.jsp.grnds_002ddocs.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserRight;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.test.TestConversation;
import gov.georgia.dhr.dfcs.sacwis.web.test.TestHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class TestData_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<script type=\"text/javascript\" language=\"javascript\">\r\nfunction addRow( tableId, inputType )\r\n{\r\n  var table = document.getElementById(tableId);\r\n  var rowCount = table.rows.length;\r\n  var row = table.insertRow(rowCount - 1);\r\n\r\n  var nameCell = row.insertCell();\r\n  var nameInput = document.createElement(\"input\");\r\n  var nameName = \"txtUser\" + inputType + \"Name_\" + rowCount;\r\n  nameInput.type = \"text\";\r\n  nameInput.name = nameName;\r\n  nameInput.size = \"25\";\r\n  nameInput.className = \"formInput\";\r\n  nameInput.id = \"txtUser\" + inputType + rowCount + \"_Id\";\r\n  nameCell.appendChild(nameInput);\r\n\r\n  var valueCell = row.insertCell();\r\n  var valueInput = document.createElement(\"input\");\r\n  var valueName = \"txtUser\" + inputType + \"Value_\" + rowCount;\r\n  valueInput.type = \"text\";\r\n  valueInput.name = valueName;\r\n  valueInput.size = \"25\";\r\n  valueInput.className = \"formInput\";\r\n  valueInput.id = \"txtUser\" + inputType + rowCount + \"_Id\";\r\n  valueCell.appendChild(valueInput);\r\n");
      out.write("}\r\n\r\nfunction encodeParameters( command, targetFieldId )\r\n{\r\n  var formElementArray = document.frmTestData.elements;\r\n  var url = command + \"?\";\r\n  for( var i = 0; i < formElementArray.length; i++ )\r\n  {\r\n    var formElement = formElementArray[i];\r\n    var name = formElement.name;\r\n    // exclude values with \"_changed\" in their name to shorted the effect of checkboxes on the URLs\r\n    if( name != \"selGlobalDataAppMode\" && name != \"selPageMode\" && name.search(\"_changed\") < 0\r\n            && ( name.search(\"GlobalData\") >= 0 || name.search(\"txtUser\") >= 0\r\n            || name == \"");
      out.print(UserProfileHelper.LOGIN_NAME_KEY);
      out.write("\"\r\n            || name == \"");
      out.print(UserProfileHelper.PASSWORD_KEY);
      out.write("\"\r\n            ");
      //  impact:ifServerImpact
      gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
      _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifServerImpact_0.setParent(null);
      int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
      if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n            || name == \"");
        out.print(UserProfileHelper.CLAIM_USER_ID_KEY);
        out.write("\"\r\n            ");
      }
      if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n            || name == \"txtURI\"\r\n            ");
      out.write("\r\n            || ( ( name == \"txtPageModeOther\" ) && document.frmTestData.txtPageModeOther.disabled == false ) ) )\r\n    {\r\n      var value = formElement.value;\r\n      if( value != null && value != \"\" )\r\n      {\r\n        url = url + name + \"=\" + value + \"&\";\r\n      }\r\n    }\r\n    if( name.search(\"cbx\") == 0 && name.search(\"_changed\") < 0 )\r\n    {\r\n      if( formElement.checked )\r\n      {\r\n        url = url + name + \"=\" + formElement.value + \"&\";\r\n      }\r\n    }\r\n  }\r\n  // add selAppMode\r\n  var selGlobalDataAppModeValue = document.frmTestData.selGlobalDataAppMode.value;\r\n  if( selGlobalDataAppModeValue != null )\r\n  {\r\n    url = url + \"selGlobalDataAppMode\" + \"=\" + selGlobalDataAppModeValue + \"&\";\r\n  }\r\n\r\n  // add PageMode.PageMode\r\n  var selPageModeValue = document.frmTestData.selPageMode.value;\r\n  if( selPageModeValue != null )\r\n  {\r\n    url = url + \"selPageMode\" + \"=\" + selPageModeValue + \"&\";\r\n  }\r\n\r\n  // add rbSecurityAction\r\n  rbSecurityActionArray = document.frmTestData.rbSecurityAction;\r\n  var rbSecurityActionValue = null;\r\n");
      out.write("  for( var i = 0; i < rbSecurityActionArray.length; i++ )\r\n  {\r\n    if( rbSecurityActionArray[i].checked == true )\r\n    {\r\n      rbSecurityActionValue = rbSecurityActionArray[i].value;\r\n      break;\r\n    }\r\n  }\r\n  if( rbSecurityActionValue != null )\r\n  {\r\n    url = url + \"rbSecurityAction\" + \"=\" + rbSecurityActionValue + \"&\";\r\n  }\r\n\r\n  // need to chop the last \"&\" character off if we have no page mode selected\r\n  url = url.substring(0, url.length - 1);\r\n\r\n  // need to encode the URL to make spaces and such chacters \"safe\"\r\n  url = URLEncode(url);\r\n\r\n  if( url.length >= 4095 )\r\n  {\r\n    alert(\"The URL that was created is longer than 4096 characters; this may result in unpredictable behavior.\");\r\n  }\r\n\r\n  document.getElementById(targetFieldId).value = url;\r\n}\r\n\r\nfunction enableIfSelectOther( selControl, txtControl )\r\n{\r\n  if( selControl.options.value == \"O\" )\r\n  {\r\n    txtControl.disabled = false;\r\n    txtControl.focus();\r\n  }\r\n  else\r\n  {\r\n    txtControl.disabled = true;\r\n  }\r\n}\r\n\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\nfunction enableIfSelectOtherPageMode()\r\n{\r\n  enableIfSelectOther(document.frmTestData.selPageMode, document.frmTestData.txtPageModeOther);\r\n}\r\n\r\nfunction requestClassRefresh()\r\n{\r\n  disableValidation(\"frmTestData\");\r\n  submitValidateForm(\"frmTestData\", \"/test/Test/requestClassRefresh\");\r\n}\r\n\r\nfunction validateXConf()\r\n{\r\n  disableValidation(\"frmTestData\");\r\n  submitValidateForm(\"frmTestData\", \"/test/Test/validateXConf\");\r\n}\r\n\r\nfunction populateUserSecurity()\r\n{\r\n  if( document.frmTestData.");
      out.print(UserProfileHelper.LOGIN_NAME_KEY);
      out.write(".value == \"\" )\r\n  {\r\n    alert(\"Login Name required!\");\r\n  }\r\n  else\r\n  {\r\n    disableValidation(\"frmTestData\");\r\n    submitValidateForm(\"frmTestData\", \"/test/Test/populateUserSecurity\");\r\n  }\r\n}\r\n\r\nvar hexVals = new Array(\"0\", \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"A\", \"B\", \"C\", \"D\", \"E\", \"F\");\r\nvar unsafeString = \"\\\"<>%\\\\^[]`\";\r\n\r\nfunction URLEncode( val )\r\n{\r\n  var state = 'urlenc';\r\n  var len = val.length;\r\n  var backlen = len;\r\n  var i = 0;\r\n\r\n  var newStr = \"\";\r\n  var frag = \"\";\r\n  var encval = \"\";\r\n\r\n  for( i = 0; i < len; i++ )\r\n  {\r\n    if( isURLok(val.substring(i, i + 1)) )\r\n    {\r\n      newStr = newStr + val.substring(i, i + 1);\r\n    }\r\n    else\r\n    {\r\n      tval1 = val.substring(i, i + 1);\r\n      newStr = newStr + \"%\" + decToHex(tval1.charCodeAt(0), 16);\r\n    }\r\n  }\r\n  return newStr;\r\n}\r\n\r\n// part of URL Encode\r\nfunction decToHex( num, radix )\r\n{\r\n  var hexString = \"\";\r\n  while( num >= radix )\r\n  {\r\n    temp = num % radix;\r\n    num = Math.floor(num / radix);\r\n    hexString += hexVals[temp];\r\n");
      out.write("  }\r\n  hexString += hexVals[num];\r\n  return reversal(hexString);\r\n}\r\n\r\n// part of URL Encode\r\nfunction reversal( s )\r\n{\r\n  var len = s.length;\r\n  var trans = \"\";\r\n  for( i = 0; i < len; i++ )\r\n  {\r\n    trans = trans + s.substring(len - i - 1, len - i);\r\n  }\r\n  s = trans;\r\n  return s;\r\n}\r\n\r\n// part of URL Encode\r\nfunction isURLok( compareChar )\r\n{\r\n  if( unsafeString.indexOf(compareChar) == -1 && compareChar.charCodeAt(0) > 32 && compareChar.charCodeAt(0) < 123 )\r\n  {\r\n    return true;\r\n  }\r\n  else\r\n  {\r\n    return false;\r\n  }\r\n}\r\n\r\nfunction resetFrmTestData()\r\n{\r\n  document.frmTestData.reset();\r\n  var parameterTable = document.getElementById(\"ParametersTable_Id\");\r\n  while( parameterTable.rows.length > 2 )\r\n  {\r\n    parameterTable.deleteRow(parameterTable.rows.length - 2);\r\n  }\r\n  var attributeTable = document.getElementById(\"AttributesTable_Id\");\r\n  while( attributeTable.rows.length > 2 )\r\n  {\r\n    attributeTable.deleteRow(attributeTable.rows.length - 2);\r\n  }\r\n}\r\n\r\nfunction parseParamsAndSubmit()\r\n{\r\n");
      //  impact:ifServerImpact
      gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
      _jspx_th_impact_ifServerImpact_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifServerImpact_1.setParent(null);
      int _jspx_eval_impact_ifServerImpact_1 = _jspx_th_impact_ifServerImpact_1.doStartTag();
      if (_jspx_eval_impact_ifServerImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n  if( frmTestData.");
        out.print(UserProfileHelper.LOGIN_NAME_KEY);
        out.write(".value == 'eilersbe'\r\n          && frmTestData.");
        out.print(UserProfileHelper.CLAIM_USER_ID_KEY);
        out.write(".value != '' )\r\n  {\r\n    alert(\"Please do not change Brad's logon ID\");\r\n    return;\r\n  }\r\n");
      }
      if (_jspx_th_impact_ifServerImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n  var parameterTable = document.getElementById(\"ParametersTable_Id\");\r\n  for( var i = 1; i < parameterTable.rows.length - 1; i++ )\r\n  {\r\n    var row = parameterTable.rows[i];\r\n    var userInputParamName = row.cells[0].childNodes.item(0).value;\r\n    var userInputParamVal = row.cells[1].childNodes.item(0).value;\r\n    if( userInputParamName != \"\" && userInputParamVal != \"\" )\r\n    {\r\n      var newField = document.createElement(\"input\");\r\n      newField.type = \"hidden\";\r\n      newField.name = userInputParamName;\r\n      newField.value = userInputParamVal;\r\n      document.frmTestData.appendChild(newField);\r\n    }\r\n  }\r\n  submitValidateForm(\"frmTestData\", \"/test/Test/executeTest\");\r\n}\r\n\r\nwindow.onload = function()\r\n{\r\n");

Map parameterMap = request.getParameterMap();
Iterator parameterIt = parameterMap.keySet().iterator();
while( parameterIt.hasNext() )
{
String name = ( String )parameterIt.next();
//noinspection ConstantConditions
if( name.equals( UserProfileHelper.LOGIN_NAME_KEY )
      || name.equals( UserProfileHelper.PASSWORD_KEY )
      || ( PlatformConstants.SERVER_IMPACT && name.equals( UserProfileHelper.CLAIM_USER_ID_KEY ) )
      || name.startsWith( "txt" ) || "txtURI".equals( name ) )
 {
String value = request.getParameter( name );

      out.write("\r\n  if( document.frmTestData.");
      out.print(name);
      out.write(" != null )\r\n  {\r\n    document.frmTestData.");
      out.print(name);
      out.write(".value = \"");
      out.print(value);
      out.write("\";\r\n  }\r\n");

}
else if( name.startsWith( "cbx" ) && !name.endsWith( "_changed" ) )
{

      out.write("\r\n  if( document.frmTestData.");
      out.print(name);
      out.write(" != null )\r\n  {\r\n    document.frmTestData.");
      out.print(name);
      out.write(".checked = true;\r\n    setCbxChange('frmTestData', document.frmTestData.");
      out.print(name);
      out.write(");\r\n  }\r\n");

}
else if( name.startsWith( "rb" ) )
{
String value = request.getParameter( name );

      out.write("\r\n  var rbs = document.frmTestData.");
      out.print(name);
      out.write(";\r\n  if( rbs != null )\r\n  {\r\n    for( var i = 0; i < rbs.length; i++ )\r\n    {\r\n      if( rbs[i].value == \"");
      out.print(value);
      out.write("\" )\r\n      {\r\n        rbs[i].checked = true;\r\n      }\r\n    }\r\n  }\r\n");

}
else if( name.startsWith( "sel" ) )
{
String value = request.getParameter( name );

      out.write("\r\n  var sels = document.frmTestData.");
      out.print(name);
      out.write(";\r\n  if( sels != null )\r\n  {\r\n    for( var i = 0; i < sels.length; i++ )\r\n    {\r\n      if( sels[i].value == \"");
      out.print(value);
      out.write("\" )\r\n      {\r\n        sels[i].selected = true;\r\n      }\r\n    }\r\n  }\r\n");

      }
    }

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n  if( document.frmTestData.selPageMode.options.value != \"O\" )\r\n  {\r\n    document.frmTestData.txtPageModeOther.disabled = true;\r\n  }\r\n}\r\n</script>\r\n");

  int tabIndex = 1;

  URL url = new URL( request.getRequestURL().toString() );
  String baseURL = url.getPort() >= 0 ?
                   url.getProtocol() + "://" + url.getHost() + ":" + url.getPort() :
                   url.getProtocol() + "://" + url.getHost();

  // These are used for both app mode and page mode
  List<Option> appModeList = new ArrayList<Option>();
  appModeList.add( new Option( String.valueOf( PageModeConstants.EDIT ), "Edit" ) );
  appModeList.add( new Option( String.valueOf( PageModeConstants.VIEW ), "View" ) );

  List<Option> pageModeList = new ArrayList<Option>();
  pageModeList.add( new Option( String.valueOf( PageModeConstants.APPROVE ), "Approve" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.CREATE ), "Create" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.EDIT ), "Edit" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.INQUIRE ), "Inquire" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.MODIFY ), "Modify" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.NEW ), "New" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.NEW_USING ), "New Using" ) );
  pageModeList.add( new Option( String.valueOf( PageModeConstants.VIEW ), "View" ) );
  pageModeList.add( new Option( "O", "Other" ) );

      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmTestData");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/test/Test/displayTestData");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n<table width=\"100%\">\r\n  <tr>\r\n    <td align=\"left\" valign=\"top\">\r\n      <a href=\"javascript:resetFrmTestData();\">\r\n        <img src=\"/grnds-docs/images/shared/btnCancel.gif\" class=\"md\" border=\"0\">\r\n      </a>\r\n    </td>\r\n    <td align=\"center\">\r\n      <a href=\"javascript:requestClassRefresh();\">Request Class Refresh</a>\r\n    </td>\r\n    <td align=\"center\">\r\n      <a href=\"javascript:validateXConf();\">Validate grnds-web-app.xconf</a>\r\n    </td>\r\n    <td align=\"right\" valign=\"top\">\r\n      <a href=\"javascript:parseParamsAndSubmit( 'ParametersTable_Id', 'Parameter' );\">\r\n        <img src=\"/grnds-docs/images/shared/btnSubmit.gif\" class=\"md\" border=\"0\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\">\r\n      </a>\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n<tr>\r\n  <td>\r\n    <a href=\"javascript:encodeParameters( '");
          out.print(baseURL);
          out.write("/test/Test/displayTestData', 'displayURL_id' )\"\r\n       tabIndex=\"");
          out.print(tabIndex++);
          out.write("\">\r\n      Get display URL\r\n    </a>\r\n  </td>\r\n  <td colspan=\"5\">\r\n    <input name=\"displayURL\" id=\"displayURL_id\" value=\"\" size=\"95\" maxLength=\"8192\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\">\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    <a href=\"javascript:encodeParameters( '");
          out.print(baseURL);
          out.write("/test/Test/executeTest', 'executeURL_id' )\"\r\n       tabIndex=\"");
          out.print(tabIndex++);
          out.write("\">\r\n      Get execute URL\r\n    </a>\r\n  </td>\r\n  <td colspan=\"5\">\r\n    <input name=\"executeURL\" id=\"executeURL_id\" value=\"\" size=\"95\" maxLength=\"8192\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\">\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setName(UserProfileHelper.LOGIN_NAME_KEY);
          _jspx_th_impact_validateInput_0.setLabel("Login Name");
          _jspx_th_impact_validateInput_0.setSize("15");
          _jspx_th_impact_validateInput_0.setRequired("true");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("password");
          _jspx_th_impact_validateInput_1.setName(UserProfileHelper.PASSWORD_KEY);
          _jspx_th_impact_validateInput_1.setLabel("Password");
          _jspx_th_impact_validateInput_1.setSize("15");
          _jspx_th_impact_validateInput_1.setValue("123456");
          _jspx_th_impact_validateInput_1.setRequired("true");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_2 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          int _jspx_eval_impact_ifServerImpact_2 = _jspx_th_impact_ifServerImpact_2.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n      ");
            //  impact:validateInput
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
            _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
            _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_2);
            _jspx_th_impact_validateInput_2.setType("text");
            _jspx_th_impact_validateInput_2.setName(UserProfileHelper.CLAIM_USER_ID_KEY);
            _jspx_th_impact_validateInput_2.setLabel("UserID");
            _jspx_th_impact_validateInput_2.setSize("15");
            _jspx_th_impact_validateInput_2.setConstraint("Digit16Less");
            _jspx_th_impact_validateInput_2.setRequired("false");
            _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
            int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
            if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n    ");
          }
          if (_jspx_th_impact_ifServerImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_ifMobileImpact_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"6\">\r\n    ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("expSecurityAttributes");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("User Security Attributes");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n      ");

        SortedSet userRightSet = TestHelper.getUserRightSet();
      
              out.write("\r\n      <table width=\"100%\">\r\n        <tr>\r\n          <td colspan=\"3\">\r\n            <a href=\"javascript:populateUserSecurity();\">Populate Security Attributes From User</a>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td colspan=\"3\">\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_3.setType("radio");
              _jspx_th_impact_validateInput_3.setName("rbSecurityAction");
              _jspx_th_impact_validateInput_3.setRequired("true");
              _jspx_th_impact_validateInput_3.setLabel("No Changes");
              _jspx_th_impact_validateInput_3.setChecked("true");
              _jspx_th_impact_validateInput_3.setValue(TestConversation.SEC_ACTION_NO_CHANGE);
              _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_4.setType("radio");
              _jspx_th_impact_validateInput_4.setName("rbSecurityAction");
              _jspx_th_impact_validateInput_4.setRequired("true");
              _jspx_th_impact_validateInput_4.setLabel("Exactly As Checked");
              _jspx_th_impact_validateInput_4.setValue(TestConversation.SEC_ACTION_EXACT);
              _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setType("radio");
              _jspx_th_impact_validateInput_5.setName("rbSecurityAction");
              _jspx_th_impact_validateInput_5.setRequired("true");
              _jspx_th_impact_validateInput_5.setLabel("Include Checked In Set");
              _jspx_th_impact_validateInput_5.setValue(TestConversation.SEC_ACTION_INCLUSIVE);
              _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_6.setType("radio");
              _jspx_th_impact_validateInput_6.setName("rbSecurityAction");
              _jspx_th_impact_validateInput_6.setRequired("true");
              _jspx_th_impact_validateInput_6.setLabel("Exclude Unchecked From Set");
              _jspx_th_impact_validateInput_6.setValue(TestConversation.SEC_ACTION_EXCLUSIVE);
              _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");

          int colIndex = 0;
          Iterator userRightIterator = userRightSet.iterator();
          UserProfile popUser = (UserProfile)request.getAttribute( TestConversation.SEC_ATTR_KEY );
          if( popUser == null )
          {
            popUser = new UserProfile();
            popUser.setRights( "" );
          }
          while( userRightIterator.hasNext() )
          {
            UserRight userRight = (UserRight)userRightIterator.next();
            String rightName = userRight.getRightName();
            int rightIndex = userRight.getRightIndex();
            String hasRight = String.valueOf( popUser.hasRight( rightIndex ) );
            if( colIndex % 3 == 0 )
            {
        
              out.write("\r\n        <tr>\r\n          ");

            }
          
              out.write("\r\n          <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_7.setType("checkbox");
              _jspx_th_impact_validateInput_7.setName("cbxUserSecurityAttribute_" + rightIndex);
              _jspx_th_impact_validateInput_7.setChecked(hasRight);
              _jspx_th_impact_validateInput_7.setValue(String.valueOf( rightIndex ));
              _jspx_th_impact_validateInput_7.setLabel(rightName);
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n          ");

            if( colIndex % 3 == 2 )
            {
          
              out.write("\r\n        </tr>\r\n        ");

            }
            colIndex++;
          }
          // Clean up the end of the table, in case the number of security attributes is not divisible by 3;
          //   this is done with println instead of scriptlets in order to not screw up the HTML for indention.
          if( colIndex % 3 != 0 )
          {
            while( colIndex % 3 != 2 )
            {
              out.println( "<td>&nbsp;</td>" );
              colIndex++;
            }
            out.println( "</tr>" );
          }
        
              out.write("\r\n      </table>\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setSize("70");
          _jspx_th_impact_validateInput_8.setName("txtURI");
          _jspx_th_impact_validateInput_8.setLabel("URI");
          _jspx_th_impact_validateInput_8.setColspan("4");
          _jspx_th_impact_validateInput_8.setRequired("true");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setName("cbxIsSubmodule");
          _jspx_th_impact_validateInput_9.setLabel("Is Submodule?");
          _jspx_th_impact_validateInput_9.setValue("true");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setValue(String.valueOf( PageModeConstants.VIEW ));
          _jspx_th_impact_validateSelect_0.setColspan("2");
          _jspx_th_impact_validateSelect_0.setName("selGlobalDataAppMode");
          _jspx_th_impact_validateSelect_0.setLabel("AppMode");
          _jspx_th_impact_validateSelect_0.setOptions(appModeList);
          _jspx_th_impact_validateSelect_0.setBlankValue("false");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          out.write("\r\n      ");
          out.write("\r\n  </td>\r\n  <td>&nbsp;</td>\r\n  <td colspan=\"2\">\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setName("cbxHasStageAccess");
          _jspx_th_impact_validateInput_10.setLabel("Has Stage Access?");
          _jspx_th_impact_validateInput_10.setValue("true");
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n");

  boolean newRow = true;
  Set exceptionNameSet = TestHelper.getExcptionNames();
  Iterator nameIt = TestHelper.getGlobalDataSetters().keySet().iterator();
  while( nameIt.hasNext() )
  {
    String name = (String)nameIt.next();
    if( !exceptionNameSet.contains( name ) )
    {
      if( newRow )
      {

          out.write("\r\n<tr>\r\n  ");

    }
    if( name.startsWith( "Ul" ) )
    {
  
          out.write("\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setName("txtGlobalData" + name);
          _jspx_th_impact_validateInput_11.setLabel(name);
          _jspx_th_impact_validateInput_11.setSize("30");
          _jspx_th_impact_validateInput_11.setConstraint("Digit16Less");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setColspan("2");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  ");

  }
  else
  {
  
          out.write("\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setName("txtGlobalData" + name);
          _jspx_th_impact_validateInput_12.setLabel(name);
          _jspx_th_impact_validateInput_12.setSize("30");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_12.setColspan("2");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  ");

    }
    if( newRow )
    {
      newRow = false;
    }
    else
    {
      newRow = true;
  
          out.write("\r\n</tr>\r\n");

      }
    }
  }
  if( newRow )
  {
    // This id done with println in order to not break the apparent HTML.
    out.println( "</tr>" );
  }

  Set parameterNameValueSet = new TreeSet( new Comparator()
  {
    public int compare( Object o1, Object o2 )
    {
      String s1 = ( (String[])o1 )[0];
      String s2 = ( (String[])o2 )[0];
      Integer i1 = Integer.valueOf( s1.substring( s1.lastIndexOf( "_" ) + 1, s1.length() ) );
      Integer i2 = Integer.valueOf( s2.substring( s2.lastIndexOf( "_" ) + 1, s2.length() ) );
      return i1.compareTo( i2 );
    }

  } );
  Set attributeNameValueSet = new TreeSet( new Comparator()
  {
    public int compare( Object o1, Object o2 )
    {
      String s1 = ( (String[])o1 )[0];
      String s2 = ( (String[])o2 )[0];
      Integer i1 = Integer.valueOf( s1.substring( s1.lastIndexOf( "_" ) + 1, s1.length() ) );
      Integer i2 = Integer.valueOf( s2.substring( s2.lastIndexOf( "_" ) + 1, s2.length() ) );
      return i1.compareTo( i2 );
    }

  } );
  parameterMap = request.getParameterMap();
  Set parameterMapKeySet = parameterMap.keySet();
  parameterIt = parameterMapKeySet.iterator();
  while( parameterIt.hasNext() )
  {
    String parameterNameName = (String)parameterIt.next();
    if( parameterNameName.startsWith( "txtUserParameterName" ) )
    {
      String parameterValueName = "txtUserParameterValue" +
                                  parameterNameName.substring( 20, parameterNameName.length() );
      parameterNameValueSet.add( new String[]{parameterNameName, parameterValueName} );
    }
    else if( parameterNameName.startsWith( "txtUserAttributeName" ) )
    {
      String parameterValueName = "txtUserAttributeValue" +
                                  parameterNameName.substring( 20, parameterNameName.length() );
      attributeNameValueSet.add( new String[]{parameterNameName, parameterValueName} );
    }
  }

          out.write("\r\n<tr>\r\n  <td colspan=\"3\" valign=\"top\" width=\"50%\">\r\n    <table width=\"100%\" id=\"ParametersTable_Id\">\r\n      <tr>\r\n        <th width=\"50%\">Parameter Name</th>\r\n        <th width=\"50%\">Parameter Value</th>\r\n      </tr>\r\n      ");

        parameterIt = parameterNameValueSet.iterator();
        while( parameterIt.hasNext() )
        {
          String[] nameValueArray = (String[])parameterIt.next();
      
          out.write("\r\n      <tr>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setName(nameValueArray[0]);
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setSize("25");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setName(nameValueArray[1]);
          _jspx_th_impact_validateInput_14.setType("text");
          _jspx_th_impact_validateInput_14.setSize("25");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n      ");

        }
      
          out.write("\r\n      <tr>\r\n        <td colspan=\"2\" align=\"center\">\r\n          <a href=\"javascript:addRow( 'ParametersTable_Id', 'Parameter' );\">\r\n            <img src=\"/grnds-docs/images/shared/btnAdd.gif\" class=\"md\" border=\"0\">\r\n          </a>\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  </td>\r\n  <td colspan=\"3\" valign=\"top\" width=\"50%\">\r\n    <table width=\"100%\" id=\"AttributesTable_Id\">\r\n      <tr>\r\n        <th width=\"50%\">Attribute Name</th>\r\n        <th width=\"50%\">Attribute Value</th>\r\n      </tr>\r\n      ");

        parameterIt = attributeNameValueSet.iterator();
        while( parameterIt.hasNext() )
        {
          String[] nameValueArray = (String[])parameterIt.next();
      
          out.write("\r\n      <tr>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setName(nameValueArray[0]);
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setSize("25");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setName(nameValueArray[1]);
          _jspx_th_impact_validateInput_16.setType("text");
          _jspx_th_impact_validateInput_16.setSize("25");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n      ");

        }
      
          out.write("\r\n      <tr>\r\n        <td colspan=\"2\" align=\"center\">\r\n          <a href=\"javascript:addRow( 'AttributesTable_Id', 'Attribute' );\">\r\n            <img src=\"/grnds-docs/images/shared/btnAdd.gif\" class=\"md\" border=\"0\">\r\n          </a>\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"6\" align=\"center\">\r\n    &nbsp;Page Mode:&nbsp;\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setName("selPageMode");
          _jspx_th_impact_validateSelect_1.setOptions(pageModeList);
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setOnChange("enableIfSelectOtherPageMode();");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    &nbsp;Other:&nbsp;\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setName("txtPageModeOther");
          _jspx_th_impact_validateInput_17.setSize("1");
          _jspx_th_impact_validateInput_17.setMaxLength("1");
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
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

  private boolean _jspx_meth_impact_ifMobileImpact_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_ifMobileImpact_0 = _jspx_th_impact_ifMobileImpact_0.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("&nbsp;");
    }
    if (_jspx_th_impact_ifMobileImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
