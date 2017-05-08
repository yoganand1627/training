package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Croleall;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Crelvict;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cchktype;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckPersonBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RecordsCheckSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveProgramCodeServicesSO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Enumeration;

public final class ContractServiceDetailAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
       * ContractServiceDetailAdd.jsp
       * Author: Corey Harden
       * Date: 10/11/2011
       * 
       * 					Change History
       *
       *   Date          User				              Description
       * ----------    ------------      -----------------------------------------------------------
       * 11/12/2011    htvo              STGAP00017671: displayed service desc with service code
       * 11/20/2011    htvo              STGAP00017678: changed display order for service code to top - bottom
       *
       *
       */
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

	BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
	RetrieveProgramCodeServicesSO retrieveProgramCodeServicesSO = (RetrieveProgramCodeServicesSO) state.getAttribute("retrieveProgramCodeServicesSO", request);
	boolean displayProgCodeDropDown = retrieveProgramCodeServicesSO != null && retrieveProgramCodeServicesSO.getProgramCodesOptions()!= null && !retrieveProgramCodeServicesSO.getProgramCodesOptions().isEmpty() ? true : false;
	String programCode = (String) request.getAttribute("programCode");
	boolean isProgCodeAvail = programCode != null ? true : false;
	Object[] checkedValues = (Object[]) request.getAttribute("checkedValues");
	boolean isBatchTime = checkedValues != null ? true : false;
	boolean isPaginated = "Y".equals(request.getAttribute("isPaginated"));
	CCON13SO ccon13so = (CCON13SO) state.getAttribute("CCON13SO", request);
	String contractFunctionType = ContextHelper.getStringSafe(request, "hdnContractFunctionType");
	org.exolab.castor.types.Date countyEffective = DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEffective"));
    org.exolab.castor.types.Date countyEnd = DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEnd"));
	ROWCCON13SOG_ARRAY countyRows = null;
	int resourceId = ContextHelper.getIntSafe(request, "hdnUlIdResource");
	if(ccon13so != null){
		countyRows = ccon13so.getROWCCON13SOG_ARRAY();
	}
	int tabIndex= 1;
	
	// setup messages
 	String MSG_UPDT_VERIF = MessageLookup.getMessageByNumber(Messages.MSG_UPDT_VERIF);
 	String MSF_INFO_UPDT_SAVE = "Only counties chosen on Services By Area will be applied to the contract for the service(s) selected.";

      out.write("\r\n\r\n\r\n\r\n<!-- JAVASCRIPT SECTION -->\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\tvar MSG_UPDT_VERIF = '");
      out.print( MSG_UPDT_VERIF );
      out.write("';\r\n\tvar MSF_INFO_UPDT_SAVE = '");
      out.print( MSF_INFO_UPDT_SAVE );
      out.write("';\r\n\r\n\twindow.attachEvent('onbeforeunload', setDirty );\r\n  \tfunction setDirty() {\r\n    \tIsDirty();\r\n  \t};\r\n\t\r\n\tfunction displayServices(elem){\r\n\t\tvar val = elem.value;\r\n\t\tif(val != ''){\r\n\t\t\tdocument.getElementById('validateProgCode').value = 'Y';\r\n  \t\t\tsubmitValidateForm( 'frmContractServiceDetail', '/financials/Contracts/getBackgroundData');\r\n\t\t}\t\r\n\t}\r\n\t\r\n\r\n\tfunction validateServiceSelection(){\r\n\t\talert('alert');\r\n\t   submitValidateForm( 'frmContractServiceDetail', '/financials/Contracts/setServices');\r\n\t}\r\n\t\r\n\tfunction displaySaveMessage(){\r\n\t\talert(MSF_INFO_UPDT_SAVE);\r\n\t\treturn confirm(MSG_UPDT_VERIF);\r\n\t}\r\n\t\r\n\t\r\n\t/**\r\n\t* This function checks or unchecks all service code checkboxes\r\n\t* @param action - boolean which denotes whether to check or uncheck the checkboxes \r\n\t*/\r\n\tfunction selectAllServices(action){\r\n\t   // get all inputs from page\r\n\t   var inputs = document.getElementsByTagName('input');\r\n\t   for(var i = 0; i < inputs.length; i++){\r\n\t   \t\t// get the input and input  \r\n\t   \t\tvar input = inputs[i];\r\n");
      out.write("\t   \t\tvar type = input.getAttribute('type');\r\n\t   \t\t// check/uncheck all checkboxes\r\n\t   \t\tif(type == 'checkbox'){\r\n\t   \t\t\tif(input.checked != action){\r\n\t       \t\t\tinput.checked = action;\r\n\t       \t\t\tinput.fireEvent(\"onclick\");\r\n\t        \t}\r\n\t   \t\t}\r\n\t   }\r\n\t}\r\n\t\t\r\n</script>\r\n<!-- END JAVASCRIPT SECTION -->\r\n\r\n\r\n\r\n<!-- ERROR DISPLAY AREA -->\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n<!-- END ERROR DISPLAY AREA -->\r\n\r\n\r\n\r\n\r\n<!-- Begin Form -->\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmContractServiceDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/Contracts/displayContractServiceDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.ContractServiceDetailAddCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( "4" );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnContractFunctionType");
          _jspx_th_impact_validateInput_0.setValue( FormattingHelper.formatString(contractFunctionType) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdndtDtCncntyEffective");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatDate(countyEffective) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdndtDtCncntyEnd");
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatDate(countyEnd) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnUlIdResource");
          _jspx_th_impact_validateInput_3.setValue( "" + resourceId );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
 
	if((displayProgCodeDropDown || isProgCodeAvail) && !isBatchTime){
	
          out.write("\r\n\t<!-- Begin Program Code Section -->\r\n\t<input type=\"hidden\" name=\"validateProgCode\" value=\"N\" />\r\n\t<div id=\"programCode\">\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\tProgram Code\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr height=\"50px\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( 1 );
          _jspx_th_impact_validateSelect_0.setLabel("Program Code");
          _jspx_th_impact_validateSelect_0.setOptions( retrieveProgramCodeServicesSO.getProgramCodesOptions() );
          _jspx_th_impact_validateSelect_0.setName("szProgCode");
          _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString(programCode) );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setOnChange("displayServices(this)");
          _jspx_th_impact_validateSelect_0.setDisabled( "false" );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\t");

	}
	
	if(isBatchTime){
	
          out.write("\t\r\n\t<input type=\"hidden\" name=\"hdnProgCode\" value=\"");
          out.print( programCode );
          out.write("\" />\r\n\t<div id=\"programCodeDisabled\">\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\t\tclass=\"tableborder\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\tProgram Code\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr height=\"50px\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<span id=\"progCodeDisabled\">\r\n\t\t\t\t\t\tProgram Code: ");
          out.print( Lookup.simpleDecodeSafe("CPRGCODE", programCode) );
          out.write("\r\n\t\t\t\t\t</span>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\t<br>\r\n\t<!-- End Program Code Section -->\r\n\t");

	}
	
          out.write("\r\n\r\n\t");

	if(isProgCodeAvail && !isBatchTime) {
	  // STGAP00017671: display service desc with service code
	  String codeArray = "CSVCCODE"+programCode+programCode;	
	  Collection<String> codes =  Lookup.getCategoryCodesCollection(codeArray);
	  List defaultCodes = new ArrayList(codes.size());
	  defaultCodes.addAll(codes);
	
          out.write("\r\n\t<input type=\"hidden\" name=\"validateServiceSelection\" value=\"Y\" />\r\n\t<!-- Begin Service Codes Section -->\r\n\t<table id=\"serviceCodes\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tService Codes\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<div id=\"programCodeServices\">\r\n\t\t\t\t\t");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("cbxProgCdServices");
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes( defaultCodes );
          _jspx_th_impact_codesCheckbox_0.setCodesTableName( codeArray );
          _jspx_th_impact_codesCheckbox_0.setColumns(3);
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\t<!-- End Service Codes Section -->\r\n\t\r\n\t<!-- Begin Select/Deselect All Buttons -->\r\n\t<div id=\"selectAll\">\r\n\t\t<table>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"600\">&nbsp;</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<a onclick=\"JavaScript:selectAllServices(true);\" >\r\n        \t\t\t\t<img src=\"/grnds-docs/images/shared/btnSelectAll.gif\" style=\"cursor: pointer\" />\r\n      \t\t\t\t</a>\r\n      \t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<a onclick=\"JavaScript:selectAllServices(false);\" >\r\n        \t\t\t\t<img src=\"/grnds-docs/images/shared/btnDeselectAll.gif\" style=\"cursor: pointer\" />\r\n      \t\t\t\t</a>\r\n      \t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSelect");
          _jspx_th_impact_ButtonTag_0.setImg("btnSelect");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmContractServiceDetail");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Contracts/setServices");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\t<!-- End Select/Deselect All Buttons -->\r\n\t");
 
	}
	
          out.write("\r\n\t\r\n\t");
 
	if(isBatchTime){
	
          out.write("\r\n\t<!-- Begin Batch Services Section -->\r\n\t<div id=\"batchServices\" style=\"width: 100%\">\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n\t\t\t<tr align=\"center\"><th colspan=\"6\">Service Codes</th></tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td><span class=\"formRequiredText\">*</span><b>Service Code</b></td>\r\n\t\t\t\t<td><span class=\"formRequiredText\">*</span><b>Unit Type</b></td>\r\n\t\t\t\t<td><span class=\"formRequiredText\">*</span><b>Payment Type</b></td>\r\n\t\t\t\t<td><span class=\"formRequiredText\">*</span><b>Unit Rate</b></td>\r\n\t\t\t\t<td><b>Federal Match</b></td>\r\n\t\t\t\t<td><b>State Match</b></td>\r\n\t\t\t</tr>\r\n\t");
 
		int i = 0;
		for(Object serviceCodeObj : checkedValues){
			String serviceCode = String.valueOf(serviceCodeObj);
			// STGAP00017671: display service desc with service code
			String codeArray = "CSVCCODE"+programCode+programCode;
			String codeDecode = Lookup.simpleDecodeSafe(codeArray, serviceCode);
	
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td width=\"30%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setValue( serviceCode );
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setChecked( "true" );
          _jspx_th_impact_validateInput_4.setName( "cbxBatchProgCodeService" + i );
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.print( codeDecode );
          out.write("</td>\r\n\t\t\t<td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setName( "szNbrCnsvcUnitType" + i );
          _jspx_th_impact_validateSelect_1.setValue("");
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setCodesTable("CCONUNIT");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t<td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setName( "szNbrCnsvcPaymentType" + i );
          _jspx_th_impact_validateSelect_2.setValue("");
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setCodesTable("CCONPAY");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setValue("");
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setName( "ulNbrCnsvcUnitRate"  + i );
          _jspx_th_impact_validateInput_5.setConstraint("Money");
          _jspx_th_impact_validateInput_5.setMaxLength("10");
          _jspx_th_impact_validateInput_5.setSize("10");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t<td align=\"center\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setValue("");
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setName( "ulNbrCnsvcFedMatch" + i );
          _jspx_th_impact_validateInput_6.setConstraint("Digit3Less");
          _jspx_th_impact_validateInput_6.setMaxLength("3");
          _jspx_th_impact_validateInput_6.setSize("3");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t\t<td align=\"center\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setValue("");
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setName( "ulNbrCnsvcLocalMatch" + i );
          _jspx_th_impact_validateInput_7.setConstraint("Digit3Less");
          _jspx_th_impact_validateInput_7.setMaxLength("3");
          _jspx_th_impact_validateInput_7.setSize("3");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t</tr>\r\n\t");
 
			i++;
		}
	
          out.write("\r\n\t\t<input type=\"hidden\" name=\"numRows\" value=\"");
          out.print( i );
          out.write("\" />\r\n\t\t</table>\r\n\t</div>\r\n\t<!-- End Batch Services Section -->\r\n\r\n\t<!-- Begin County Section -->\r\n\t<div id=\"countySection\">\r\n\t\t<br>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n\t\t\t<tr align=\"left\">\r\n\t\t\t\t<td><b><u>County</u></b></td>\r\n\t\t\t\t<td><b><u>Code</u></b></td>\r\n\t\t\t\t</td><td width=\"150px\"></td><td width=\"150px\"></td><td width=\"150px\"></td><td width=\"150px\"></td>\r\n\t\t\t</tr>\r\n\t");
 
		if(countyRows != null){
			Enumeration e = countyRows.enumerateROWCCON13SOG();
			while(e.hasMoreElements()){
				ROWCCON13SOG county = (ROWCCON13SOG) e.nextElement();
				String countyCode = county.getSzCdCncntyCounty();
				if(countyCode != null){
	
          out.write("\r\n\t\t\t<tr>\r\n\t\t\t<td>");
          out.print( Lookup.simpleDecodeSafe("CCOUNT", countyCode) );
          out.write("</td>\r\n\t\t\t<td>");
          out.print( countyCode );
          out.write("</td>\r\n\t\t\t</td><td width=\"150px\"></td><td width=\"150px\"></td><td width=\"150px\"></td><td width=\"150px\"></td></tr>\r\n\t");
 
				}
			}
		}
	
          out.write("\r\n\t\t\t\r\n\t\t</table>\r\n\t</div>\r\n\t<!-- End County Section -->\r\n\t\r\n\t");
 
		if(!isPaginated){
	
          out.write("\r\n\t<!-- Begin Save Button -->\r\n\t<div id=\"saveBtn\"\">\r\n\t\t<table>\r\n\t\t\t<tr height=\"15px\"><td>&nbsp;</td><td>&nbsp;</td></tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"700\">&nbsp;</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmContractServiceDetail");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setFunction("return displaySaveMessage()");
          _jspx_th_impact_ButtonTag_1.setAction("/financials/Contracts/saveContractServiceBatch");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\t<!-- End Save Button -->\r\n\t\r\n\t");
 
		}else{
	
          out.write("\r\n\t<!-- Begin Save Buttons -->\r\n\t<div id=\"saveAndSaveContinueBtns\">\r\n\t\t<table>\r\n\t\t\t<tr height=\"15px\"><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"600\">&nbsp;</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveAndContinue");
          _jspx_th_impact_ButtonTag_2.setImg("btnSaveAndContinue");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmContractServiceDetail");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_2.setFunction("return displaySaveMessage()");
          _jspx_th_impact_ButtonTag_2.setAction("/financials/Contracts/saveContractServiceBatch?continue=Y");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSave");
          _jspx_th_impact_ButtonTag_3.setImg("btnSave");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setForm("frmContractServiceDetail");
          _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_3.setFunction("return displaySaveMessage()");
          _jspx_th_impact_ButtonTag_3.setAction("/financials/Contracts/saveContractServiceBatch");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\t<!-- End Save Buttons -->\r\n\t");
 
		}
	}
	
          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n\r\n\r\n");
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
