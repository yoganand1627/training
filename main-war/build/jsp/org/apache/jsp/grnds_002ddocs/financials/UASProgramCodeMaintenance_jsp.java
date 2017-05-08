package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASEntitlementCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeMtntRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeListRow;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.financials.UASProgramCodeMaintenanceConversation;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class UASProgramCodeMaintenance_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  UASProgramCodeMtntRetrieveSO uasPrgCodeMtntRetrieveSO = (UASProgramCodeMtntRetrieveSO) state
                                                                                   .getAttribute(
                                                                                                 "UASPrgCodeMtntRetrieveSO",
                                                                                                 request);
  // Retrieve the curent page state, if already set from previous action
  String pageState = (String) state.getAttribute("PAGE_STATE", request);
  // Page initially in Add new program code state
  if (!StringHelper.isValid(pageState)) {
    pageState = UASProgramCodeMaintenanceConversation.ADD_UAS;
  }
  // Page init variables 
  String pageMode = PageMode.getPageMode(request); 
  int editableModes = EditableMode.EDIT + EditableMode.NEW;
  int tabIndex = 1;
  String formName = "frmUASProgramCodeMaintenance";
  // In Add mode, user can enter up to 10 entitlement codes at a time
  // Default the number of ENT codes to display to 10
  int nbrDisplayEntCodeRows = 10;
  int hdnRowIndex = -1;
  // Page field variables
  // Program Code List section
  List<UASProgramCodeListRow> prgCodeList = new ArrayList<UASProgramCodeListRow>();
  // Program Code detail section 
  Date dtProgEff = null;  
  Date dtUpdatedBy = null;
  int idPersonUpdatedBy; 
  int idUasPrgCodeMtnt = 0;
  String txtProgCode = StringHelper.EMPTY_STRING;
  String txtProgDesc = StringHelper.EMPTY_STRING;
  String cdProgType = StringHelper.EMPTY_STRING;
  String nmPersonUpdatedBy = StringHelper.EMPTY_STRING;  
  String indCCI = StringHelper.EMPTY_STRING;
  String indCPA = StringHelper.EMPTY_STRING;
  String indServAuth = StringHelper.EMPTY_STRING;
  String indPSSF = StringHelper.EMPTY_STRING;
  String indInvAddOn = StringHelper.EMPTY_STRING;
  List<UASEntitlementCodeDetail> entCodeList = null;
  // Entitlement code detail section
  String amtEntRate = StringHelper.EMPTY_STRING;
  String amtEntCBLimit = StringHelper.EMPTY_STRING; // Case Budget limit
  String amtEntLILimit = StringHelper.EMPTY_STRING; // Line Item limit
  Date dtEntEff = null;
  Date dtEntLastUpdate = null;
  int idEntCodeMtnt = 0;
  String indEntHeader = StringHelper.EMPTY_STRING;
  String txtEntCode = StringHelper.EMPTY_STRING;
  String txtEntAlpha = StringHelper.EMPTY_STRING;
  String txtEntDesc = StringHelper.EMPTY_STRING;
  String cdEntPymtType = StringHelper.EMPTY_STRING;
  String cdEntUnitType = StringHelper.EMPTY_STRING;
  String indEntMileague = StringHelper.EMPTY_STRING;

  // Page control/behavior variables
  int listColspan = 4;
  int detailColspan = 6;
  boolean isUpdateMode = UASProgramCodeMaintenanceConversation.UPDATE.equals(pageState);
  String szBDisableUas = UASProgramCodeMaintenanceConversation.ADD_ENT.equals(pageState) ? "true" : "false";
  String szBAddUas = UASProgramCodeMaintenanceConversation.ADD_UAS.equals(pageState) ? "true" : "false";
  
  // Populate page fields with existing values, if any 
  if (uasPrgCodeMtntRetrieveSO != null) { 
    prgCodeList = uasPrgCodeMtntRetrieveSO.getPrgCodeList();
    // Set values for program code maintenance if exists
    UASProgramCodeDetail uasProgramCodeDetail = uasPrgCodeMtntRetrieveSO.getPrgCodeDetail();
    if (uasProgramCodeDetail != null ) {
      hdnRowIndex = uasProgramCodeDetail.getRecordIndex();
      idUasPrgCodeMtnt = uasProgramCodeDetail.getIdUasPrgCode();
      cdProgType = uasProgramCodeDetail.getCdProgramType();
      txtProgCode = uasProgramCodeDetail.getCdProgramCode();
      txtProgDesc = uasProgramCodeDetail.getTxtProgramDesc();
      dtProgEff = uasProgramCodeDetail.getDtProgramEffective();
      dtUpdatedBy = uasProgramCodeDetail.getDtLastUpdatedBy();
      idPersonUpdatedBy = uasProgramCodeDetail.getIdPersonLastUpdate();
      nmPersonUpdatedBy = uasProgramCodeDetail.getNmPersonLastUpdate();
      indCCI = uasProgramCodeDetail.getIndCCI();
      indCPA = uasProgramCodeDetail.getIndCPA();
      indServAuth = uasProgramCodeDetail.getIndServiceAuth();
      indPSSF = uasProgramCodeDetail.getIndPSSF();
      indInvAddOn = uasProgramCodeDetail.getIndInvAddOn();
      // populate ENT list to display with ENT data
      if (isUpdateMode) {
        entCodeList= uasProgramCodeDetail.getEntCodeList();
      }
      
      if (entCodeList != null && entCodeList.size() > 0) {
        nbrDisplayEntCodeRows = entCodeList.size();
      }
    }
  }

  List<String> excludeProgramTypes = new ArrayList<String>();
  excludeProgramTypes.add(CodesTables.CINVSRTP_ADM);
  excludeProgramTypes.add(CodesTables.CINVSRTP_ALL);
  

      out.write("  \r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n  /*\r\n   This function is called before the page unloads. It creates the\r\n   \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n   window.onbeforeunload = function ()\r\n  {\r\n           IsDirty();\r\n  };\r\n\r\n  // Custom function to handle submitting the form via links in a list\r\n  function displayCodeDetail(rowIndex, codeId)\r\n  { disableValidation( \"frmUASProgramCodeMaintenance\" );\r\n    document.frmUASProgramCodeMaintenance.hdnUlIdUasProgramCodeMtnt.value = codeId;\r\n    document.frmUASProgramCodeMaintenance.hdnRowIndex.value = rowIndex;\r\n    document.frmUASProgramCodeMaintenance.hdnHyperlinkClicked.value = 'true';\r\n    submitValidateForm( \"frmUASProgramCodeMaintenance\" , \"/financials/UASProgramCodeMaintenance/displayUASProgramCodeMaintenance\" );\r\n  }\r\n  \r\n  function valdiateAddNewProgramCode() {\r\n    document.frmUASProgramCodeMaintenance.hdnAddProgramCodeMode.value = 'true';\r\n");
      out.write("    disableValidation( \"frmUASProgramCodeMaintenance\" );\r\n  }\r\n\r\n  function valdiateAddNewEntitlementCodes() {\r\n    document.frmUASProgramCodeMaintenance.hdnAddEntitlementCodeMode.value = 'true';\r\n    disableValidation( \"frmUASProgramCodeMaintenance\" );\r\n  }\r\n  \r\n  function sortProgramCodeList(orderBy) {\r\n    disableValidation( \"frmUASProgramCodeMaintenance\" );\r\n    document.frmUASProgramCodeMaintenance.hdnSortOrderBy.value = orderBy;\r\n    submitValidateForm( \"frmUASProgramCodeMaintenance\" , \"/financials/UASProgramCodeMaintenance/sortUasProgramCodeList\" );\r\n  }\r\n  \r\n  function confirmSave() {\r\n    // whether program data changed, for the data fields that affect the service code at the ENT level\r\n    // Currently: program code, subprogram selections: Service Auth, Invoice Add-on, CCI/CPA, PSSF.\r\n    var x = document.frmUASProgramCodeMaintenance;\r\n    for (var i=0; i<x.elements.length; i++) {\r\n      sElementName = new String(x.elements[i].name);\r\n      // The only radios on the page are subprograms\r\n      if(\"radio\" == x.elements[i].type)\r\n");
      out.write("      { \r\n        if (x.elements[i].checked != x.elements[i].defaultChecked) {\r\n          document.frmUASProgramCodeMaintenance.hdnProgramChanged.value = \"Y\";\r\n        }\r\n      } else if (\"txtSzCdProgCode\" == sElementName) {\r\n        if (x.elements[i].value != x.elements[i].defaultValue) {\r\n          document.frmUASProgramCodeMaintenance.hdnProgramChanged.value = \"Y\";\r\n        }\r\n      }\r\n    }\r\n    return confirm('");
      out.print( MessageLookup.getMessageByName( "MSG_CONF_VALUES"));
      out.write("');\r\n  }\r\n  \r\n  function setRowIsChanged(field, index) {\r\n    var hdnIndRowChanged = eval(\"document.frmUASProgramCodeMaintenance.hdnIndRowChanged\" + index);\r\n    var cbxIndEntHeader = eval(\"document.frmUASProgramCodeMaintenance.cbxIndEntHeader\" + index);\r\n    if (CheckWidget(field)) {\r\n      hdnIndRowChanged.value = \"Y\";\r\n      if (field.title == \"Description\" && field.defaultValue != \"\" && cbxIndEntHeader.checked) {\r\n        alert(\"Header descriptions cannot be updated online. Please contact your system administrator to complete this request. Your header description has not been changed.\");\r\n        field.value = field.defaultValue;\r\n      }\r\n    } else {\r\n      hdnIndRowChanged.value = \"N\";\r\n    }\r\n  }\r\n    \r\n</script>\r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmUASProgramCodeMaintenance");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/UASProgramCodeMaintenance/displayUASProgramCodeMaintenance");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.UASProgramCodeMaintenanceCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write(' ');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnDtLastUpdateUasProgCodeDetail");
          _jspx_th_impact_validateInput_0.setValue( DateHelper.toISOString(dtUpdatedBy) );
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
          _jspx_th_impact_validateInput_1.setName("hdnRowIndex");
          _jspx_th_impact_validateInput_1.setValue(String.valueOf(hdnRowIndex) );
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
          _jspx_th_impact_validateInput_2.setName("hdnNbrDisplayEntCodeRows");
          _jspx_th_impact_validateInput_2.setValue(String.valueOf(nbrDisplayEntCodeRows) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<!-- Indicate page is in the process of adding new program code; not exclusive. -->\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnAddProgramCodeMode");
          _jspx_th_impact_validateInput_3.setValue(szBAddUas );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<!-- Indicate page is in the process of adding Entitlement codes; not exclusive -->\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnAddEntitlementCodeMode");
          _jspx_th_impact_validateInput_4.setValue(szBDisableUas );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n                      \r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnProgramChanged");
          _jspx_th_impact_validateInput_7.setValue(ArchitectureConstants.N );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                      <!-- Begin List section -->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"");
          out.print( listColspan );
          out.write("\">UAS Program Code List</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"");
          out.print( listColspan );
          out.write("\">\r\n          <div id=\"verticalScrollResults\" style=\"height:136px; width:100%; overflow:auto\" class=\"tableBorderList\">\r\n            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n              <tr>\r\n                <th class=\"thList\" width=\"5%\">Program Code&nbsp;\r\n                <a href=\"javascript:sortProgramCodeList('C')\"><img src=\"/grnds-docs/images/shared/sortDescending.gif\" border=\"0\"></a>\r\n\t\t\t    </th>\r\n                <th class=\"thList\">Program Description</th>\r\n                <th class=\"thList\">Effective Date&nbsp;\r\n                <a href=\"javascript:sortProgramCodeList('D')\"><img src=\"/grnds-docs/images/shared/sortDescending.gif\" border=\"0\"></a>\r\n\t\t\t    </th>\r\n                <th class=\"thList\">Updated By</th>\r\n            </tr>\r\n\t\t\t");
  // Populate list with retrieved data
			int rIndex = 0;
			for (UASProgramCodeListRow row : prgCodeList) { 
			
          out.write("\r\n\t\t\t  <tr>\r\n\t\t\t    <td><a href=\"javascript:displayCodeDetail('");
          out.print(rIndex );
          out.write("', '");
          out.print(FormattingHelper.formatInt(row.getIdUasPrgCode()) );
          out.write("')\">\r\n\t\t\t      ");
          out.print(FormattingHelper.formatString(row.getCdProgramCode()) );
          out.write("</a>\r\n\t\t\t    </td>\r\n\t\t\t    <td>\r\n\t\t\t      ");
          out.print(FormattingHelper.formatString(row.getTxtProgramDesc()) );
          out.write("\r\n\t\t\t    </td>\r\n\t\t\t    <td>\r\n\t\t\t      ");
          out.print(FormattingHelper.formatDate(row.getDtProgramEffective()) );
          out.write("\r\n\t\t\t    </td>\r\n\t\t\t    <td>\r\n\t\t\t      ");
          out.print(FormattingHelper.formatString(row.getNmPersonLastUpdate()) );
          out.write("\r\n\t\t\t    </td>\r\n\t\t\t  </tr>\r\n\t\t\t");

			  rIndex++; } 
			
          out.write("\r\n          </table>\r\n        </div>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n       ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnAddPrgCode");
          _jspx_th_impact_ButtonTag_0.setEditableMode( editableModes );
          _jspx_th_impact_ButtonTag_0.setImg("btnAddNewProgCode");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmUASProgramCodeMaintenance");
          _jspx_th_impact_ButtonTag_0.setFunction("valdiateAddNewProgramCode()");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/UASProgramCodeMaintenance/addUASProgramCode");
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br/>\r\n<hr/>\r\n<!-- Begin Program Code Detail section -->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"");
          out.print( detailColspan+1 );
          out.write("\">UAS Program Code Maintenance</th>\r\n</tr>\r\n<tr>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setName("txtSzCdProgCode");
          _jspx_th_impact_validateInput_8.setLabel("Program Code");
          _jspx_th_impact_validateInput_8.setRequired("true");
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setConstraint("Digit3");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setValue( FormattingHelper.formatString(txtProgCode) );
          _jspx_th_impact_validateInput_8.setDisabled(szBDisableUas );
          _jspx_th_impact_validateInput_8.setSize("2");
          _jspx_th_impact_validateInput_8.setMaxLength("3");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setWidth("25%");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnUlIdUasProgramCodeMtnt");
          _jspx_th_impact_validateInput_9.setValue(FormattingHelper.formatInt(idUasPrgCodeMtnt) );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setName("txtSzTxtProgDesc");
          _jspx_th_impact_validateInput_10.setLabel("Program Description");
          _jspx_th_impact_validateInput_10.setRequired("true");
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setDisabled(szBDisableUas );
          _jspx_th_impact_validateInput_10.setValue( FormattingHelper.formatString(txtProgDesc) );
          _jspx_th_impact_validateInput_10.setSize("50");
          _jspx_th_impact_validateInput_10.setMaxLength("50");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtDtProgEff");
          _jspx_th_impact_validateDate_0.setLabel("Effective Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate(dtProgEff) );
          _jspx_th_impact_validateDate_0.setDisabled(szBDisableUas );
          _jspx_th_impact_validateDate_0.setCalendar("true");
          _jspx_th_impact_validateDate_0.setConstraint("DateAllowNoSlash");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selSzCdProgType");
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable("CINVSRTP");
          _jspx_th_impact_validateSelect_0.setExcludeOptions( excludeProgramTypes );
          _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString(cdProgType) );
          _jspx_th_impact_validateSelect_0.setDisabled(szBDisableUas );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td> \r\n</tr>\r\n<tr> <!-- Radio section as a borderless inner table -->\r\n<td colspan=\"");
          out.print( detailColspan );
          out.write("\">\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\r\n<tr>\r\n  <td  width=\"19%\"><span class=\"formCondRequiredText\">&#8225;</span>Service Authorization:</td>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setName("rbServAuth");
          _jspx_th_impact_validateInput_11.setLabel("Yes");
          _jspx_th_impact_validateInput_11.setId("rbServAuth_Yes");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_11.setChecked(StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indServAuth)) );
          _jspx_th_impact_validateInput_11.setDisabled(szBDisableUas );
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setName("rbServAuth");
          _jspx_th_impact_validateInput_12.setLabel("No");
          _jspx_th_impact_validateInput_12.setId("rbServAuth_No");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_12.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_12.setChecked(StringHelper.toBooleanString(ArchitectureConstants.N.equals(indServAuth)) );
          _jspx_th_impact_validateInput_12.setDisabled(szBDisableUas );
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>&nbsp;</td>\r\n  <td width=\"5%\"><span class=\"formCondRequiredText\">&#8225;</span>CCI:</td>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setName("rbCCI");
          _jspx_th_impact_validateInput_13.setLabel("Yes");
          _jspx_th_impact_validateInput_13.setId("rbCCI_Yes");
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_13.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_13.setChecked(StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indCCI)) );
          _jspx_th_impact_validateInput_13.setDisabled(szBDisableUas );
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setName("rbCCI");
          _jspx_th_impact_validateInput_14.setLabel("No");
          _jspx_th_impact_validateInput_14.setId("rbCCI_No");
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_14.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_14.setChecked(StringHelper.toBooleanString(ArchitectureConstants.N.equals(indCCI)) );
          _jspx_th_impact_validateInput_14.setDisabled(szBDisableUas );
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>&nbsp;</td>\r\n  <td width=\"5%\"><span class=\"formCondRequiredText\">&#8225;</span>PSSF:</td>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setName("rbPSSF");
          _jspx_th_impact_validateInput_15.setLabel("Yes");
          _jspx_th_impact_validateInput_15.setId("rbPSSF_Yes");
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_15.setChecked(StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indPSSF)) );
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setName("rbPSSF");
          _jspx_th_impact_validateInput_16.setLabel("No");
          _jspx_th_impact_validateInput_16.setId("rbPSSF_No");
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_16.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_16.setChecked(StringHelper.toBooleanString(ArchitectureConstants.N.equals(indPSSF)) );
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>                                                                     \r\n<tr>\r\n  <td><span class=\"formCondRequiredText\">&#8225;</span>Invoice Add-On:</td>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setName("rbInvAddOn");
          _jspx_th_impact_validateInput_17.setLabel("Yes");
          _jspx_th_impact_validateInput_17.setId("rbInvAddOn_Yes");
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_17.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_17.setChecked(StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indInvAddOn)) );
          _jspx_th_impact_validateInput_17.setDisabled(szBDisableUas );
          _jspx_th_impact_validateInput_17.setType("radio");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setName("rbInvAddOn");
          _jspx_th_impact_validateInput_18.setLabel("No");
          _jspx_th_impact_validateInput_18.setId("rbInvAddOn_No");
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_18.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_18.setChecked(StringHelper.toBooleanString(ArchitectureConstants.N.equals(indInvAddOn)) );
          _jspx_th_impact_validateInput_18.setDisabled(szBDisableUas );
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>&nbsp;</td>\r\n  <td><span class=\"formCondRequiredText\">&#8225;</span>CPA:</td>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setName("rbCPA");
          _jspx_th_impact_validateInput_19.setLabel("Yes");
          _jspx_th_impact_validateInput_19.setId("rbCPA_Yes");
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_19.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_19.setChecked(StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indCPA)) );
          _jspx_th_impact_validateInput_19.setDisabled(szBDisableUas );
          _jspx_th_impact_validateInput_19.setType("radio");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setName("rbCPA");
          _jspx_th_impact_validateInput_20.setLabel("No");
          _jspx_th_impact_validateInput_20.setId("rbCPA_No");
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_20.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_20.setChecked(StringHelper.toBooleanString(ArchitectureConstants.N.equals(indCPA)) );
          _jspx_th_impact_validateInput_20.setDisabled(szBDisableUas );
          _jspx_th_impact_validateInput_20.setType("radio");
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n</table>\r\n</td>\r\n</tr> <!-- End Radio section as a borderless inner table -->\r\n<tr>\r\n  <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspTxtSzUpdatedBy");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("&nbsp;Updated By");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(nmPersonUpdatedBy));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <td>&nbsp;&nbsp;&nbsp;&nbsp;");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspTxtSzUpdatedDate");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Updated Date");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatDate(dtUpdatedBy));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>                          \r\n  <td>&nbsp;&nbsp;</td></tr>\r\n</tr>\r\n<tr><td>&nbsp;&nbsp;</td></tr>\r\n</table>\r\n<!-- End Program Code Detail section -->\r\n<!-- Begin Entitlement Code Detail section -->\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\"> \r\n  <tr>\r\n    <th colSpan=\"");
          out.print( detailColspan );
          out.write("\">Entitlement Codes</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"");
          out.print( detailColspan );
          out.write("\"><table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"> <!-- table E2 -->\r\n      <tr>\r\n        <td class=\"tableBG\">\r\n          <div class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information --></div></div>\r\n          <div id=\"horizontalScrollResults\" style=\"height:370px; width:752px; overflow:auto\" class=\"tableBorder\">\r\n            <table width=\"900\" cellspacing=\"0\" cellpadding=\"3\">\r\n              <tr>\r\n                <th class=\"thList\">&nbsp;Header</th>\r\n                <th class=\"thList\">Code</th>\r\n                <th class=\"thList\">Alpha</th>\r\n                <th class=\"thList\">Description</th>\r\n                <th class=\"thList\">Effective Date</th>\r\n                <th class=\"thList\">Unit Rate ($)</th>\r\n                <th class=\"thList\">Payment Type</th>\r\n                <th class=\"thList\">Unit Type</th>\r\n                <th class=\"thList\">Mileage</th>\r\n                <th class=\"thList\" width=\"3%\">&nbsp;&nbsp;Case &nbsp;&nbsp;Budget &nbsp;&nbsp;Limit ($)</th>\r\n                <th class=\"thList\" width=\"2%\">&nbsp;&nbsp;Line &nbsp;&nbsp;Item &nbsp;&nbsp;Limit ($)</th>\r\n");
          out.write("              </tr>\r\n              ");
 
              if (entCodeList == null) {
                  entCodeList = new ArrayList<UASEntitlementCodeDetail>();
              }
              Iterator<UASEntitlementCodeDetail> itrEntSO = entCodeList.iterator();
              
              for (int i=0; i<nbrDisplayEntCodeRows; i++) {
                //String amtEntRate = StringHelper.EMPTY_STRING;
                 if (itrEntSO.hasNext()) {
                    UASEntitlementCodeDetail entSO = (UASEntitlementCodeDetail)itrEntSO.next();
                    idEntCodeMtnt = entSO.getIdEntRow();
                    if (entSO.getAmtRate() > 0.00) {
                      amtEntRate = FormattingHelper.formatMoney(entSO.getAmtRate());
                    } else {
                      amtEntRate = StringHelper.EMPTY_STRING;
                    }
                    if (entSO.getAmtCBL() > 0.00) {
                      amtEntCBLimit = FormattingHelper.formatMoney(entSO.getAmtCBL()); 
                    } else {
                      amtEntCBLimit = StringHelper.EMPTY_STRING;
                    }
                    if (entSO.getAmtLIL() > 0.00) {
                      amtEntLILimit = FormattingHelper.formatMoney(entSO.getAmtLIL());
                    } else {
                      amtEntLILimit = StringHelper.EMPTY_STRING;
                    }
			        dtEntEff = entSO.getDtEntEff();
			        dtEntLastUpdate = entSO.getDtLastUpdate();
			        indEntHeader = entSO.getIndHeader();
			        txtEntCode = entSO.getCdEntCode();
			        txtEntAlpha = entSO.getTxtEntAlpha();
			        txtEntDesc = entSO.getTxtEntDesc();
			        cdEntPymtType = entSO.getCdPymtType();
			        cdEntUnitType = entSO.getCdUnitType();
			        indEntMileague = entSO.getIndMileage();
                  } 
                  String hdnIdEntRow = "hdnUlIdEntProgramCodeMtnt"+i;
                  String hdnDtLastUpdateEntRow = "hdnDtLastUpdateEntProgramCodeMtnt"+i;
                  String hdnIndRowChanged = "hdnIndRowChanged"+i;
                  
	              String nmCbxIndHeader = "cbxIndEntHeader"+i;
	              String nmTxtEntCode = "txtSzEntCode"+i;
	              String nmTxtEntAlpha = "txtSzTxtEntAlpha"+i; 
	              String nmTxtEntDesc = "txtSzTxtEntDesc"+i;
	              String nmDtEntEff = "txtDtDtEntEff"+i; 
	              String nmAmtEntRate = "txtAmtEntRate"+i; 
	              String nmCdEntPymtType = "selSzCdEntPymtType"+i;
	              String nmCdEntUnitType = "selSzCdEntUnitType"+i;
	              String nmCbxIndEntMileage = "cbxIndEntMileage"+i;
	              String nmEntCBL = "txtDAmtEntCBL"+i; // Case Budget Limit - Double
	              String nmEntLIL = "txtDAmtEntLIL"+i; // Line Item Limit - Double
	              
		          String onChangeActionString = "setRowIsChanged(this, " + i + ")";
      
              
          out.write("\r\n              <tr>\r\n                <td>\r\n                \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setName(nmCbxIndHeader );
          _jspx_th_impact_validateInput_21.setType("checkbox");
          _jspx_th_impact_validateInput_21.setValue( ArchitectureConstants.Y );
          _jspx_th_impact_validateInput_21.setChecked( StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indEntHeader)) );
          _jspx_th_impact_validateInput_21.setOnChange(onChangeActionString );
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>                    \r\n                <td>\r\n                \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setTitle("Code");
          _jspx_th_impact_validateInput_22.setName(nmTxtEntCode );
          _jspx_th_impact_validateInput_22.setType("text");
          _jspx_th_impact_validateInput_22.setConstraint("AlphaNumeric2");
          _jspx_th_impact_validateInput_22.setValue( FormattingHelper.formatString(txtEntCode) );
          _jspx_th_impact_validateInput_22.setOnChange(onChangeActionString );
          _jspx_th_impact_validateInput_22.setSize("2");
          _jspx_th_impact_validateInput_22.setMaxLength("2");
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setName(hdnIdEntRow );
          _jspx_th_impact_validateInput_23.setType("hidden");
          _jspx_th_impact_validateInput_23.setValue(FormattingHelper.formatInt(idEntCodeMtnt) );
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                <td>\r\n                \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setTitle("Alpha");
          _jspx_th_impact_validateInput_24.setName(nmTxtEntAlpha );
          _jspx_th_impact_validateInput_24.setType("text");
          _jspx_th_impact_validateInput_24.setConstraint("Letter");
          _jspx_th_impact_validateInput_24.setValue( FormattingHelper.formatString(txtEntAlpha) );
          _jspx_th_impact_validateInput_24.setOnChange(onChangeActionString );
          _jspx_th_impact_validateInput_24.setSize("1");
          _jspx_th_impact_validateInput_24.setMaxLength("1");
          _jspx_th_impact_validateInput_24.setCssClass("formInput");
          _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n                <td>\r\n                \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setTitle("Description");
          _jspx_th_impact_validateInput_25.setName(nmTxtEntDesc );
          _jspx_th_impact_validateInput_25.setType("text");
          _jspx_th_impact_validateInput_25.setValue( FormattingHelper.formatString(txtEntDesc) );
          _jspx_th_impact_validateInput_25.setOnChange(onChangeActionString );
          _jspx_th_impact_validateInput_25.setSize("15");
          _jspx_th_impact_validateInput_25.setMaxLength("30");
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n                <td>\r\n                \t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName(nmDtEntEff );
          _jspx_th_impact_validateDate_1.setCalendar("false");
          _jspx_th_impact_validateDate_1.setConstraint("DateAllowNoSlash");
          _jspx_th_impact_validateDate_1.setTitle("Effective Date");
          _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate(dtEntEff) );
          _jspx_th_impact_validateDate_1.setOnChange(onChangeActionString );
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>                      \r\n                <td>\r\n                \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setTitle("Unit Rate");
          _jspx_th_impact_validateInput_26.setName(nmAmtEntRate );
          _jspx_th_impact_validateInput_26.setType("text");
          _jspx_th_impact_validateInput_26.setConstraint("Money");
          _jspx_th_impact_validateInput_26.setValue( amtEntRate );
          _jspx_th_impact_validateInput_26.setOnChange(onChangeActionString );
          _jspx_th_impact_validateInput_26.setSize("8");
          _jspx_th_impact_validateInput_26.setMaxLength("10");
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n                <td>\r\n                \t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName(nmCdEntPymtType );
          _jspx_th_impact_validateSelect_1.setCodesTable("CCONPAY");
          _jspx_th_impact_validateSelect_1.setValue( FormattingHelper.formatString(cdEntPymtType) );
          _jspx_th_impact_validateSelect_1.setOnChange(onChangeActionString );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n                <td>\r\n                \t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName(nmCdEntUnitType );
          _jspx_th_impact_validateSelect_2.setCodesTable("CCONUNIT");
          _jspx_th_impact_validateSelect_2.setValue( FormattingHelper.formatString(cdEntUnitType) );
          _jspx_th_impact_validateSelect_2.setOnChange(onChangeActionString );
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("                           \r\n                </td>\r\n                <td>\r\n                \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setName(nmCbxIndEntMileage );
          _jspx_th_impact_validateInput_27.setType("checkbox");
          _jspx_th_impact_validateInput_27.setValue( ArchitectureConstants.Y );
          _jspx_th_impact_validateInput_27.setChecked( StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indEntMileague)) );
          _jspx_th_impact_validateInput_27.setOnChange(onChangeActionString );
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>                    \r\n                <td>\r\n                \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setTitle("Case Budget Limit");
          _jspx_th_impact_validateInput_28.setName(nmEntCBL );
          _jspx_th_impact_validateInput_28.setType("text");
          _jspx_th_impact_validateInput_28.setConstraint("Money");
          _jspx_th_impact_validateInput_28.setValue( amtEntCBLimit );
          _jspx_th_impact_validateInput_28.setOnChange(onChangeActionString );
          _jspx_th_impact_validateInput_28.setSize("6");
          _jspx_th_impact_validateInput_28.setMaxLength("10");
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n                <td>\r\n                \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setTitle("Line Item Limit");
          _jspx_th_impact_validateInput_29.setName(nmEntLIL );
          _jspx_th_impact_validateInput_29.setType("text");
          _jspx_th_impact_validateInput_29.setConstraint("Money");
          _jspx_th_impact_validateInput_29.setValue( amtEntLILimit );
          _jspx_th_impact_validateInput_29.setOnChange(onChangeActionString );
          _jspx_th_impact_validateInput_29.setSize("6");
          _jspx_th_impact_validateInput_29.setMaxLength("10");
          _jspx_th_impact_validateInput_29.setCssClass("formInput");
          _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("hidden");
          _jspx_th_impact_validateInput_30.setName(hdnIdEntRow );
          _jspx_th_impact_validateInput_30.setValue(FormattingHelper.formatInt(idEntCodeMtnt) );
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("hidden");
          _jspx_th_impact_validateInput_31.setName(hdnDtLastUpdateEntRow );
          _jspx_th_impact_validateInput_31.setValue( DateHelper.toISOString(dtEntLastUpdate) );
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("hidden");
          _jspx_th_impact_validateInput_32.setName(hdnIndRowChanged );
          _jspx_th_impact_validateInput_32.setValue(ArchitectureConstants.N );
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                \r\n              </tr>\r\n              ");
 } 
          out.write("\r\n            </table>\r\n          </div>\r\n        </td> <!-- Close td class=\"tableBG\">  -->\r\n      </tr>\r\n    </table></td> <!-- Close table E2 -->\r\n  </tr>\r\n  ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest( isUpdateMode );
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <tr>\r\n    <td class=\"alignLeft\">\r\n       ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_ButtonTag_1.setName("btnAddEntCodes");
              _jspx_th_impact_ButtonTag_1.setEditableMode( editableModes );
              _jspx_th_impact_ButtonTag_1.setImg("btnAddEntitlementCodes");
              _jspx_th_impact_ButtonTag_1.setAlign("left");
              _jspx_th_impact_ButtonTag_1.setForm("frmUASProgramCodeMaintenance");
              _jspx_th_impact_ButtonTag_1.setFunction("valdiateAddNewEntitlementCodes()");
              _jspx_th_impact_ButtonTag_1.setAction("/financials/UASProgramCodeMaintenance/addEntitlementCode");
              _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</table>  \r\n<!-- End Entitlement Code Detail section -->\r\n<hr>\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n       ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveAll");
          _jspx_th_impact_ButtonTag_2.setEditableMode( editableModes );
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmUASProgramCodeMaintenance");
          _jspx_th_impact_ButtonTag_2.setFunction("return confirmSave();");
          _jspx_th_impact_ButtonTag_2.setAction("/financials/UASProgramCodeMaintenance/saveUASProgramCodeMaintenance");
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
      out.write("\r\n<br/>\r\n<hr/>     \r\n                  ");
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

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnHyperlinkClicked");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnSortOrderBy");
    _jspx_th_impact_validateInput_6.setValue("C");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
