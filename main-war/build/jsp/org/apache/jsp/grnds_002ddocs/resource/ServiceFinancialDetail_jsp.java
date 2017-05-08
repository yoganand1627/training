package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ServicesByAreaConversation;

public final class ServiceFinancialDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**
 * JSP Name:     ServiceFinancialDetail.jsp
 * Created by:   Hong-Van Vo
 * Date Created: 09/19/11
 *
 * Description:
 * This page allows a user to add multiple financial services by area.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  09/19/11  htvo              STGAP00017019:ECEM 5.0: initial file creation
  
  
  
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 
  UserProfile userProfile = UserProfileHelper.getUserProfile(request);
  // to see the All Regions option
  boolean isFiscalOpsStateMtnt = userProfile.hasRight(UserProfile.SEC_UPDATE_CONTRACT_PERIOD);

  String szCdRsrcSvcRegion = "";
  String checkedCIndRsrcSvcIncomeBsed = "false";
  String szFinSvcCodeArray = "";
  String szFinCountyCodeArray = "";
  List<String> excludeOutOfStateOption = new ArrayList<String>();
  int tabIndex = 1;

  List<String> defaultCodeService = null;
  List<String> defaultCodeCounty = null;
  String szSelectAllServices = "";
  String szDeSelectAllServices = "";

  // Retains user selection from request on page reload     
  String szCdRsrcSvcCategRsrc = ContextHelper.getStringSafe(request, "selSzCdRsrcSvcCategRsrc");      
  szFinSvcCodeArray = "CSVCCODE" + szCdRsrcSvcCategRsrc;
    
  szCdRsrcSvcRegion = ContextHelper.getStringSafe(request, "selSzCdRsrcSvcRegion");
  szFinCountyCodeArray = "CCOUNT" + szCdRsrcSvcRegion;

  if (StringHelper.isTrue(ContextHelper.getStringSafe(request, "cbxCIndRsrcSvcIncomeBsed")))
    checkedCIndRsrcSvcIncomeBsed = "true";

  // If Region selection changed, retain Service section settings 
  if (StringHelper.isTrue(ContextHelper.getStringSafe(request, "hdnRegionChanged")))
  {
    szSelectAllServices = ContextHelper.getStringSafe(request, "cbxSelectAllServices");
    szDeSelectAllServices = ContextHelper.getStringSafe(request, "cbxDeSelectAllServices");
    defaultCodeService = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxService"));
  }
  
  // Exclude All Regions option
  if (!isFiscalOpsStateMtnt)
  	excludeOutOfStateOption.add(ServicesByAreaConversation.ALL_REGIONS);
  
  if (StringHelper.isTrue(ContextHelper.getStringSafe(request, "bSaveAttempted")) ) {
 
    boolean bStandardValidationInProgress = "".equals(szCdRsrcSvcCategRsrc) || "".equals(szCdRsrcSvcRegion);

	String[] countyChecks = CheckboxHelper.getCheckedValues(request, "cbxCounty");
	String[] serviceChecks = CheckboxHelper.getCheckedValues(request, "cbxService");

	boolean noServiceSelected = serviceChecks == null || serviceChecks.length == 0;
	boolean noCountySelected = countyChecks == null || countyChecks.length == 0;
    
    // Custom validation
    if (!bStandardValidationInProgress && (noCountySelected || noServiceSelected)) { 
    
      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t<tr>\r\n\t\t<td colspan=\"2\">\r\n\t\t\t<hr>\r\n\t\t</td>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td colspan=\"2\">\r\n\t\t\t<span class=\"formErrorText\">");
      out.print( MessageLookup.getMessageByName( "MSG_RA_NOT_COMPLETE") );
      out.write("</span>\r\n\t\t\t<br>\r\n\t\t</td>\r\n\t</tr>\r\n\t");

		    
		    if (noServiceSelected) {
		    
      out.write("\r\n\t<tr>\r\n\t\t<td width=\"7%\">\r\n\t\t\t&nbsp;\r\n\t\t</td>\r\n\t\t<td>\r\n\t\t\t<li>\r\n\t\t\t\t<a href=\"#Service\">Service</a><span class=\"formErrorText\">");
      out.print( " - " + MessageLookup.getMessageByName( "MSG_REQ_SRVC") );
      out.write("</span>\r\n\t\t\t</li>\r\n\t\t</td>\r\n\t</tr>\r\n\t");

		    }
		    
		    if (noCountySelected) {
		    
      out.write("\r\n\t<tr>\r\n\t\t<td width=\"7%\">\r\n\t\t\t&nbsp;\r\n\t\t</td>\r\n\t\t<td>\r\n\t\t\t<li>\r\n\t\t\t\t<a href=\"#ServiceArea\">Service Area</a><span class=\"formErrorText\">");
      out.print( " - " + MessageLookup.getMessageByName( "MSG_REQ_CNTY_MIN")  );
      out.write("</span>\r\n\t\t\t</li>\r\n\t\t</td>\r\n\t</tr>\r\n\t");

		    }
			
      out.write("\r\n\t<tr>\r\n\t\t<td colspan=\"2\">\r\n\t\t\t<hr>\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n");

    }
  }
  
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n  window.attachEvent('onbeforeunload', setDirty );\r\n  function setDirty() {\r\n    IsDirty();\r\n  }\r\n\r\n  /* \r\n    1. Set focus at Service Area if page reloads for region selection\r\n    2. Default all services selected if page reloads with UAS Program changed/selected\r\n  */\r\n  window.onload = function() {\r\n  \tif (document.frmServiceDetail.hdnLocation.value != '') {\r\n      location.href= document.frmServiceDetail.hdnLocation.value;\r\n  \t  document.frmServiceDetail.hdnLocation.value = '';\r\n  \t}\r\n\r\n  \tif (document.frmServiceDetail.hdnUASProgramChanged.value == 'true') {\r\n  \t  if (document.frmServiceDetail.selSzCdRsrcSvcCategRsrc.value != '') {\r\n  \t    selectAllServices(true);\r\n  \t    document.frmServiceDetail.cbxSelectAllServices.checked = true;\r\n  \t  }\r\n\r\n  \t  document.frmServiceDetail.hdnUASProgramChanged.value = 'false';\r\n  \t}\r\n  };\r\n\r\n\r\n/* Test element exists\r\n*/ \r\n\r\nfunction isValidObj(obj){\r\n");
      out.write("  if (obj == null || obj == undefined)\r\n    return false;\r\n\r\n  return true;\r\n}\r\n\r\n/* This function is called by onClick of Service Type General to go to the General screen\r\n*/\r\nfunction goToGenServiceDetail( item ) {\r\n  document.frmServiceDetail.selSzCdRsrcSvcCategRsrc.value= '';\r\n  if (isValidObj(document.frmServiceDetail.selSzCdRsrcSvcRegion))\r\n    document.frmServiceDetail.selSzCdRsrcSvcRegion.value = '';\r\n  \r\n  document.frmServiceDetail.SzCdServiceType.value= item;\r\n  disableValidation('frmServiceDetail');\r\n  submitValidateForm( 'frmServiceDetail', '/resource/ServicesByArea/addGenServiceDetail');\r\n}\r\n\r\n/* This function is called by onClick of UAS Program to reload the page and display the service\r\n   belong to the selected program\r\n*/\r\nfunction onChangeUASProgram() {\r\n  document.frmServiceDetail.hdnUASProgramChanged.value = 'true';\t\r\n  disableValidation('frmServiceDetail');\r\n  submitValidateForm( 'frmServiceDetail', '/resource/ServicesByArea/addFinServiceDetail');\r\n}\r\n\r\n/* This function is called by onClick of Region to reload the page and display the counties\r\n");
      out.write("   in the selected region\r\n*/\r\nfunction onChangeRegion(region) {\r\n  document.frmServiceDetail.hdnRegionChanged.value = 'true';\t\r\n  document.frmServiceDetail.hdnLocation.value = '#ServiceArea';\r\n  disableValidation('frmServiceDetail');\r\n  submitValidateForm( 'frmServiceDetail', '/resource/ServicesByArea/addFinServiceDetail');\r\n}\r\n\r\n/* This function is called by onClick of Select All or Deselect All cbx. \r\n   Select All will check all services and clear the Deselect All cbx.\r\n   Deselect All will clear all services and the Select All cbx\r\n*/\r\nfunction selectAllServices(checked) {\r\n  var numOfCheckboxes = ");
      out.print( Lookup.getCategoryCollection(szFinSvcCodeArray).size() );
      out.write(";\r\n  var checkboxField;\r\n  for ( i = 1; i <= numOfCheckboxes; i++ ) {\r\n    checkboxField = eval(\"document.frmServiceDetail.cbxService\" + i);\r\n    if(checkboxField.checked != checked)\r\n      checkboxField.checked = checked;\r\n  }\r\n  \r\n  if (checked)\r\n  \tdocument.frmServiceDetail.cbxDeSelectAllServices.checked = false;\r\n  else\r\n  \tdocument.frmServiceDetail.cbxSelectAllServices.checked = false;\r\n}\r\n\r\n/* This function is called by onClick of any of the service checkboxes to clear the Select All\r\n   and De-Select All cbx\r\n*/\r\nfunction clearDeSelectService() {\r\n  document.frmServiceDetail.cbxSelectAllServices.checked = false;\r\n  document.frmServiceDetail.cbxDeSelectAllServices.checked = false;\r\n}\r\n\r\n/* This function is called by onClick of the Select All to set all service cbx\r\n*/\r\nfunction selectAllCounties(regionNum, numOfCheckboxes, checked) {\r\n  var checkboxField;\r\n\r\n  for ( i = 1; i <= numOfCheckboxes; i++ )\r\n  {\r\n    checkboxField = eval(\"document.frmServiceDetail.cbxCounty\" + regionNum + i);\r\n    if (checkboxField.checked != checked) {\r\n");
      out.write("      checkboxField.checked = checked;\r\n    }\r\n  }\r\n  \r\n  if (checked) {\r\n    checkboxField = eval(\"document.frmServiceDetail.cbxDeselectAllCounties\" + regionNum);\r\n    checkboxField.checked = false;\r\n  }\r\n  else {\r\n    checkboxField = eval(\"document.frmServiceDetail.cbxSelectAllCounties\" + regionNum);\r\n    checkboxField.checked = false;\r\n  }\r\n\r\n}\r\n\r\n/* This function is called by onClick of any of the county checkboxes to clear the Select All\r\n   and De-Select All cbx in the appropriate region\r\n*/\r\nfunction clearDeSelectCounty(regionNum) {\r\n  var checkboxField;\r\n\r\n  checkboxField = eval(\"document.frmServiceDetail.cbxSelectAllCounties\" + regionNum);\r\n  checkboxField.checked = false;\r\n\r\n  checkboxField = eval(\"document.frmServiceDetail.cbxDeselectAllCounties\" + regionNum);\r\n  checkboxField.checked = false;\r\n\r\n}\r\n/* This function is called by onClick of the Save btn to confirm user selection and action\r\n*/\r\nfunction saveFinService() {\r\n\r\n  var confirmMessage = \"\";\r\n  var abandon = false;\r\n  var bRegionWide = false;\r\n");
      out.write("  var checkboxField;\r\n  var regionNum ;\r\n  var numOfCheckboxes;\r\n  var numCountiesSelected;\r\n  var region = document.frmServiceDetail.selSzCdRsrcSvcRegion;  \r\n  // To determine if user has selected all counties in the region or all regions, to set the bRegionWide \r\n  // and to display the warning message\r\n  if (isValidObj(region) && (region.value != '')) {\r\n  if (document.frmServiceDetail.selSzCdRsrcSvcRegion.value == '95') { // all regions selected\r\n\tfor ( j = 1; j <= 17; j++) {\r\n\t  numCountiesSelected = 0;\r\n      regionNum = (j < 10) ? \"0\" + j : \"\" + j;\r\n\t  numOfCheckboxes = eval(\"document.frmServiceDetail.hdnCbxCounty\" + regionNum + \".value\");\r\n\t  for ( i = 1; i <= numOfCheckboxes; i++ ) {\r\n\t    checkboxField = eval(\"document.frmServiceDetail.cbxCounty\" + regionNum + i);\r\n\t    if (checkboxField.checked == true) {\r\n\t      numCountiesSelected++;\r\n\t    }\r\n\t  }\r\n\t  if (numCountiesSelected == numOfCheckboxes) {\r\n\t    bRegionWide = true;\r\n\t    break;\r\n\t  }\r\n\t}\r\n  }\r\n  else {  // single region\r\n\t  regionNum = document.frmServiceDetail.selSzCdRsrcSvcRegion.value;\r\n");
      out.write("\t  numOfCheckboxes = eval(\"document.frmServiceDetail.hdnCbxCounty\" + regionNum + \".value\");\r\n\t  numCountiesSelected = 0;\r\n\r\n\t  for ( i = 1; i <= numOfCheckboxes; i++ ) {\r\n\t    checkboxField = eval(\"document.frmServiceDetail.cbxCounty\" + regionNum + i);\r\n\t    if (checkboxField.checked == true) {\r\n\t      numCountiesSelected++;\r\n\t    }\r\n\t  }\r\n\t  if (numCountiesSelected == numOfCheckboxes)\r\n\t    bRegionWide = true;\r\n  }\r\n  }\r\n\r\n  // we need to make sure the user know what they're getting into...\r\n  if (bRegionWide) {\r\n\t  confirmMessage = \"You are about to add a region row. This will delete \";\r\n\t  confirmMessage = confirmMessage + \"any already existing similar county \";\r\n\t  confirmMessage = confirmMessage + \"rows. This will also \";\r\n\t  confirmMessage = confirmMessage + \"delete the client characterisitics for \";\r\n\t  confirmMessage = confirmMessage + \"those pre-existing rows. Are you sure you \";\r\n\t  confirmMessage = confirmMessage + \"want to do this?\";\r\n\t\r\n\t  if (!confirm(confirmMessage))\r\n\t  {\r\n\t    abandon = true;\r\n");
      out.write("\t  }\r\n  }\r\n    \r\n  if (!abandon)  // proceed with saving and additional confirmation\r\n  {\r\n\t  confirm('");
      out.print( MessageLookup.getMessageByName( "MSG_UPDT_VERIF"));
      out.write("');\r\n\t  document.frmServiceDetail.bSaveAttempted.value = \"true\";\r\n  }\r\n   \r\n  return !abandon;\r\n}\r\n\r\n\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmServiceDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ServicesByArea/default");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.ServiceFinancialCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n\t<!-- retain this value for General Service screen  -->\r\n\t<input type=\"hidden\" name=\"txtUlIdResourceService\" value=\"0\" />\r\n\r\n\t<!-- retain this value for General Service screen  -->\r\n\t<input type=\"hidden\" name=\"SzCdScrDataAction\"\r\n\t\tvalue='");
          out.print( ContextHelper.getStringSafe(request, "SzCdScrDataAction") );
          out.write("' />\r\n\r\n\t<!-- retain this value for General Service screen  -->\r\n\t<input type=\"hidden\" name=\"SzCdServiceType\" value='' />\r\n\r\n\t<!-- new values for this screen -->\r\n\t<input type=\"hidden\" name=\"hdnLocation\"\r\n\t\tvalue='");
          out.print( ContextHelper.getStringSafe(request, "hdnLocation") );
          out.write("' />\r\n\r\n\t<input type=\"hidden\" name=\"hdnRegionChanged\" value='false' />\r\n\r\n\t<input type=\"hidden\" name=\"hdnUASProgramChanged\"\r\n\t\tvalue=");
          out.print( ContextHelper.getStringSafe(request, "hdnUASProgramChanged") );
          out.write(" />\r\n\r\n\t<input type=\"hidden\" name=\"bSaveAttempted\" value=\"false\" />\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tServices by Area Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr colspan=\"4\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          if (_jspx_meth_impact_validateDisplayOnlyField_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setName("rbServiceType");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setType("radio");
          _jspx_th_impact_validateInput_0.setValue("G");
          _jspx_th_impact_validateInput_0.setChecked("false");
          _jspx_th_impact_validateInput_0.setOnClick("goToGenServiceDetail('G');");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\tGeneral\r\n\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setName("rbServiceType");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setValue("F");
          _jspx_th_impact_validateInput_1.setChecked("true");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\tFinancial\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tFinancial Services by Area\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("UAS Program");
          _jspx_th_impact_validateSelect_0.setName("selSzCdRsrcSvcCategRsrc");
          _jspx_th_impact_validateSelect_0.setCodesTable("CPRGCODE");
          _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString(szCdRsrcSvcCategRsrc) );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setOnChange("onChangeUASProgram()");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t\t");

		// UAS Program Code selected
		if (StringHelper.isValid(szCdRsrcSvcCategRsrc))	{
		
          out.write("\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\t<a name=\"Service\"> Service \r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t<div id=\"serviceDiv\"\r\n\t\t\t\t\tstyle=\"height: 250px; width: 762px; overflow-y: auto; overflow-x: hidden\"\r\n\t\t\t\t\tclass=\"tableBorder\">\r\n\t\t\t\t\t<table width=\"750\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<span class=\"formRequiredText\">*</span> Service:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td width=\"20%\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setLabel("Select All");
          _jspx_th_impact_validateInput_2.setName("cbxSelectAllServices");
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setValue(ArchitectureConstants.Y );
          _jspx_th_impact_validateInput_2.setChecked( szSelectAllServices );
          _jspx_th_impact_validateInput_2.setOnClick("JavaScript:selectAllServices(true);");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td width=\"20%\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setLabel("De-Select All");
          _jspx_th_impact_validateInput_3.setName("cbxDeSelectAllServices");
          _jspx_th_impact_validateInput_3.setType("checkbox");
          _jspx_th_impact_validateInput_3.setValue(ArchitectureConstants.Y );
          _jspx_th_impact_validateInput_3.setChecked( szDeSelectAllServices );
          _jspx_th_impact_validateInput_3.setOnClick("JavaScript:selectAllServices(false);");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("cbxService");
          _jspx_th_impact_codesCheckbox_0.setColumns(2);
          _jspx_th_impact_codesCheckbox_0.setCodesTableName( szFinSvcCodeArray );
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes( defaultCodeService );
          _jspx_th_impact_codesCheckbox_0.setOnClick("clearDeSelectService()");
          _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\t<a name=\"ServiceArea\"> Service Area </a>\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t<div id=\"serviceAreaDiv\"\r\n\t\t\t\t\tstyle=\"height: 300px; width: 762px; overflow-y: auto; overflow-x: hidden\"\r\n\t\t\t\t\tclass=\"tableBorder\">\r\n\t\t\t\t\t<table width=\"750\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("State");
          _jspx_th_impact_validateSelect_1.setName("selSzCdRsrcSvcState");
          _jspx_th_impact_validateSelect_1.setValue("GA");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setDisabled("true");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Program");
          _jspx_th_impact_validateSelect_2.setName("selSzCdRsrcSvcProgram");
          _jspx_th_impact_validateSelect_2.setCodesTable("CRSCPROG");
          _jspx_th_impact_validateSelect_2.setRequired("false");
          _jspx_th_impact_validateSelect_2.setDisabled("true");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Region");
          _jspx_th_impact_validateSelect_3.setName("selSzCdRsrcSvcRegion");
          _jspx_th_impact_validateSelect_3.setCodesTable("CSVCRGNS");
          _jspx_th_impact_validateSelect_3.setExcludeOptions( excludeOutOfStateOption );
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setValue( FormattingHelper.formatString(szCdRsrcSvcRegion) );
          _jspx_th_impact_validateSelect_3.setRequired("true");
          _jspx_th_impact_validateSelect_3.setOnChange("onChangeRegion(this.value)");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setLabel("Income Based");
          _jspx_th_impact_validateInput_4.setName("cbxCIndRsrcSvcIncomeBsed");
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setChecked( checkedCIndRsrcSvcIncomeBsed );
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t\t");

						// Region Code selected
						if (StringHelper.isValid(szCdRsrcSvcRegion)) {
							int numRegions = 1;
							String regionHeader = "";
							int numOfCheckboxes = 0;
							boolean allRegions = false;
							String cdRegion = "";
							
							if (ServicesByAreaConversation.ALL_REGIONS.equals(szCdRsrcSvcRegion)) {
							    //STGAP00017735: Modified to set numRegions as REGION_INDEX map size.
								numRegions = ServicesByAreaConversation.REGION_INDEX.size();
								allRegions = true;
							}
						
          out.write("\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<span class=\"formRequiredText\">*</span> County:\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");

							for (int regionNum = 1; regionNum <= numRegions; regionNum++) { 
								if (allRegions)	{  // all Regions selected
									//STGAP00017735: Modified to get the region code from REGION_INDEX map instead of using regionNum value
								    cdRegion = ServicesByAreaConversation.REGION_INDEX.get(regionNum);
								    szFinCountyCodeArray = (String)ServicesByAreaConversation.REGION_COUNTY_MAP.get(cdRegion);
								    numOfCheckboxes = Lookup.getCategoryCollection(szFinCountyCodeArray).size();
								    //STGAP00017735: Modified to get the region name from REGION_MAP map
								    regionHeader = (String)ServicesByAreaConversation.REGION_MAP.get(cdRegion);
								}
								else {
								    //STGAP00017735: Modified to get the region name from REGION_MAP map
									regionHeader = (String)ServicesByAreaConversation.REGION_MAP.get(szCdRsrcSvcRegion);
									numOfCheckboxes = Lookup.getCategoryCollection(szFinCountyCodeArray).size();
									cdRegion = szCdRsrcSvcRegion;
								}

							    String sCbxSelectAllCounties = "cbxSelectAllCounties" + cdRegion;
							    String sCbxDeselectAllCounties = "cbxDeselectAllCounties" + cdRegion;
							    String sCbxCounty = "cbxCounty" + cdRegion;
							    String sHdnCbxCounty = "hdnCbxCounty" + cdRegion;

							    String onClickSelecAll = "Javascript:selectAllCounties(" + "'" + cdRegion + "'" 
							    														 + "," 
							    						 								 + numOfCheckboxes 
							    						 								 + "," 
							    						 								 + "true" 
							    						 								 + ");";
	
							    String onClickDeSelectAll = "Javascript:selectAllCounties(" + "'" + cdRegion + "'" 
							    															+ "," 
							    															+ numOfCheckboxes 
							    															+ "," 
							    															+ "false" 
							    															+ ");";
	
							    String onClickClearDeSelectCounty = "Javascript:clearDeSelectCounty(" + "'" + cdRegion + "'"  
							    															+ ");";
							
          out.write("\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<th colspan=\"4\" style=\"border-top: solid #c8c699 1px;\">\r\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;");
          out.print( regionHeader );
          out.write("</th>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td width=\"20%\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setLabel("Select All Counties");
          _jspx_th_impact_validateInput_5.setName( sCbxSelectAllCounties );
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setValue(ArchitectureConstants.Y );
          _jspx_th_impact_validateInput_5.setChecked("false");
          _jspx_th_impact_validateInput_5.setOnClick( onClickSelecAll );
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td width=\"20%\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setLabel("De-Select All Counties");
          _jspx_th_impact_validateInput_6.setName( sCbxDeselectAllCounties );
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setValue(ArchitectureConstants.Y );
          _jspx_th_impact_validateInput_6.setChecked("false");
          _jspx_th_impact_validateInput_6.setOnClick( onClickDeSelectAll );
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t\t\t\t");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_1.setName( sCbxCounty );
          _jspx_th_impact_codesCheckbox_1.setColumns(4);
          _jspx_th_impact_codesCheckbox_1.setIsHorizontal(true);
          _jspx_th_impact_codesCheckbox_1.setCodesTableName( szFinCountyCodeArray );
          _jspx_th_impact_codesCheckbox_1.setDefaultCodes( defaultCodeCounty );
          _jspx_th_impact_codesCheckbox_1.setOnClick( onClickClearDeSelectCounty );
          _jspx_th_impact_codesCheckbox_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_codesCheckbox_1 = _jspx_th_impact_codesCheckbox_1.doStartTag();
          if (_jspx_th_impact_codesCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"");
          out.print( sHdnCbxCounty );
          out.write("\"\r\n\t\t\t\t\t\t\t\tvalue=\"");
          out.print( numOfCheckboxes );
          out.write("\" />\r\n\r\n\t\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t\t");

							}
						} // END StringHelper.isValid(szCdRsrcSvcRegion))
						
          out.write("\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

		}
		
          out.write("\r\n\t</table>\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmServiceDetail");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction("setIsDirtyCalled(true);return saveFinService();");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ServicesByArea/saveFinServiceDetail");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\" />\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmServiceDetail");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_0.setName("servicType");
    _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Service Type");
    int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
