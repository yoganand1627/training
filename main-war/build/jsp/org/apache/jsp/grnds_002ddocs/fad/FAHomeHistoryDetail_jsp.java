package org.apache.jsp.grnds_002ddocs.fad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import java.util.Collection;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class FAHomeHistoryDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Home History Detail
//*  Created by:   Heather Dean
//*  Date Created: 1/3/03
//*
//*  Description:
//*   Displays and saves detail information for Home History rows.
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  01/03/03  Heather Dean      Initial jsp creation
  04/22/03  Heather Dean      Post Code Review cleanup
  07/09/03  Todd Reser        SIR 18710 - Added call to CategoryChange() on load
                              so the appropriate widgets will be enabled or
                              disabled.  Added logic to CategoryChange to
                              Disable widgets in the Foster Home Type Section if
                              the category is "A" - Adoptive.  Added call to
                              onChange to selCategory widget.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<!--Start Main Content-->\r\n");
 BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script language=\"Javascript1.2\">\r\n  // Check for changes before navigating off\r\n  window.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction deleteRow()\r\n{\r\n disableValidation( \"frmHomeHistoryDetail\" );\r\n bRetValue = confirm('");
      out.print( MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") );
      out.write("')\r\n return bRetValue;\r\n}\r\n\r\n");

// SIR 18710 - We have to disable and clear the widgets in the Foster Home
// Type Section if the category is "A" - Adoptive

      out.write("\r\nfunction categoryChange()\r\n{\r\n  var numOfTypes = ");
      out.print( Lookup.getCategoryListingArray(CodesTables.CFAHMTYP ).length );
      out.write(";\r\n  var loopCount = 1;\r\n\r\n  var isCategoryA = false;\r\n  if (document.frmHomeHistoryDetail.selCategory != undefined)\r\n  {\r\n    isCategoryA = document.frmHomeHistoryDetail.selCategory.value == \"");
      out.print( CodesTables.CFACATEG_A );
      out.write("\";\r\n  }\r\n  else if (document.frmHomeHistoryDetail.selCategory_Disabled != undefined)\r\n  {\r\n    isCategoryA = document.frmHomeHistoryDetail.selCategory_Disabled.value == \"");
      out.print( CodesTables.CFACATEG_A );
      out.write("\";\r\n  }\r\n\r\n  while ( loopCount <= numOfTypes )\r\n  {\r\n    var cbxName = getCheckbox(loopCount);\r\n    if ( cbxName != undefined )\r\n    {\r\n      if ( isCategoryA )\r\n      {\r\n        cbxName.disabled = true;\r\n        cbxName.checked = false;\r\n      }\r\n      else\r\n      {\r\n        cbxName.disabled = false;\r\n      }\r\n    }\r\n    loopCount++;\r\n  }\r\n}\r\n\r\n\r\nfunction getCheckbox(loopCount)\r\n{\r\n  if (document.frmHomeHistoryDetail.famTypes1 != undefined)\r\n  {\r\n    return eval( 'document.frmHomeHistoryDetail.famTypes' + loopCount );\r\n  }\r\n  else if (document.frmHomeHistoryDetail.famTypes1_Disabled != undefined)\r\n  {\r\n    return eval( 'document.frmHomeHistoryDetail.famTypes' + loopCount + '_Disabled');\r\n  }\r\n  //if this happens, you'll get a javascript error\r\n  return null;\r\n}\r\n</script>\r\n\r\n");

int tabIndex = 1;
boolean bHideSaveButton = false;
boolean bHideDeleteButton = false;
boolean bDisableAllFields = false;
org.exolab.castor.types.Date today = DateHelper.toCastorDate( new java.util.Date() );
String tsLastUpdate = null;
String pageMode = PageModeConstants.VIEW;
String isAdd = "";
ROWCFAD12SOG00 currentRow = new ROWCFAD12SOG00();
int intArrayIndex = ContextHelper.getIntSafe( request, "arrayIndex" );
int intResourceHistoryID = 0;
org.exolab.castor.types.Date nextStartDate = null;
org.exolab.castor.types.Date previousEndDate = null;
String reloadValue = (String) request.getAttribute( "isReload" );
boolean bIsReload = false;

// SPB SIR 19610: Do not set page mode to App Mode ( GlobalData.getAppMode( request ) )
// as this overwrites the logic in the conversation. Instead, get it from Page Mode:
  pageMode = PageMode.getPageMode( request );

      out.write("\r\n<script language=\"Javascript1.2\">\r\n  var pMode = ");
      out.print( pageMode );
      out.write(";\r\n</script>\r\n");

if ( reloadValue != null )
{
  if ("true".equals(reloadValue) )
  {
    bIsReload = true;
  }
}


if ( request.getAttribute( "nextStartDate" ) != null )
{
  nextStartDate = (org.exolab.castor.types.Date) request.getAttribute( "nextStartDate" );
}
if ( request.getAttribute( "previousEndDate" ) != null )
{
  previousEndDate = (org.exolab.castor.types.Date) request.getAttribute( "previousEndDate" );
}

SortedMap years = (SortedMap) request.getAttribute( "years"  );
SortedMap months = (SortedMap) request.getAttribute( "months"  );
Collection yearOptions = new ArrayList();
Collection monthOptions = new ArrayList();

if ( years != null )
{
  yearOptions = years.values();
}

if ( months != null )
{
  monthOptions = months.values();
}

if ( request.getAttribute( "currentRow"  ) != null )
  {
   currentRow = (ROWCFAD12SOG00) request.getAttribute( "currentRow" );
   double d1 = currentRow.getUlIdResourceHistory();
   Double d = d1;
   intResourceHistoryID = d.intValue();
   if ( currentRow.getDtDtRshsEnd() == null )
   {
     bDisableAllFields = true;
     bHideDeleteButton = true;
     if ( !bIsReload )
     {
      out.write("\r\n      <script language=\"Javascript1.2\">\r\n        alert( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_FAD_CURRENT_RECORD ));
      out.write("' );\r\n      </script>\r\n   ");
}
   }
  }

List checkedHomeTypes = new ArrayList(8);
if ( currentRow != null )
{
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType1() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType2() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType3() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType4() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType5() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType6() );
  checkedHomeTypes.add( currentRow.getCCdRshsFaHomeType7() );
}

CFAD13SO cfad13so = new CFAD13SO();
if ( state.getAttribute( "cfad13so", request ) != null )
{
  cfad13so = (CFAD13SO) state.getAttribute( "cfad13so", request );
}


      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmHomeHistoryDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fad/FAHomeHistory/saveHomeHistory");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fad.FAHomeHistoryCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("ulIdResourceHistory");
          _jspx_th_impact_validateInput_0.setValue( String.valueOf( intResourceHistoryID ) );
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
          _jspx_th_impact_validateInput_1.setName("arrayIndex");
          _jspx_th_impact_validateInput_1.setValue( String.valueOf( intArrayIndex ) );
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
          _jspx_th_impact_validateInput_2.setName("nextStartDate");
          _jspx_th_impact_validateInput_2.setValue( String.valueOf( nextStartDate ) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("previousEndDate");
          _jspx_th_impact_validateInput_3.setValue( String.valueOf( previousEndDate ) );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("timestamp");
          _jspx_th_impact_validateInput_4.setValue( String.valueOf( cfad13so.getTsLastUpdate() ) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n\r\n<table width=\"100%\" class=\"tableborder\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n<th colspan=\"8\">Home Information</th>\r\n<tr>\r\n          <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate( currentRow.getDtDtRshsEffective() ) );
          _jspx_th_impact_validateDate_0.setName("startDate");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++);
          _jspx_th_impact_validateDate_0.setLabel("Start Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setColspan("2");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate( currentRow.getDtDtRshsEnd() ) );
          _jspx_th_impact_validateDate_1.setName("endDate");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++);
          _jspx_th_impact_validateDate_1.setLabel("End Date");
          _jspx_th_impact_validateDate_1.setRequired( String.valueOf( !bDisableAllFields ) );
          _jspx_th_impact_validateDate_1.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateDate_1.setColspan("2");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setValue( String.valueOf( currentRow.getUNbrRshsFacilCapacity() ) );
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setName("txtCapacity");
          _jspx_th_impact_validateInput_5.setLabel("Capacity");
          _jspx_th_impact_validateInput_5.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
          _jspx_th_impact_validateInput_5.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setSize("4");
          _jspx_th_impact_validateInput_5.setMaxLength("4");
          _jspx_th_impact_validateInput_5.setConstraint("Numeric");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n             </td>\r\n          </tr>\r\n          <tr>\r\n");
 /* SIR 18710 - Added call to onChange to selCategory widget. */ 
          out.write("\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setValue( currentRow.getSzCdRshsCategory() );
          _jspx_th_impact_validateSelect_0.setName("selCategory");
          _jspx_th_impact_validateSelect_0.setLabel("Category");
          _jspx_th_impact_validateSelect_0.setOnChange("categoryChange()");
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CFACATEG );
          _jspx_th_impact_validateSelect_0.setRequired( String.valueOf( !bDisableAllFields ) );
          _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf( bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td>&nbsp;</td>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setValue( currentRow.getSzCdRshsFaHomeStatus() );
          _jspx_th_impact_validateSelect_1.setName("selStatus");
          _jspx_th_impact_validateSelect_1.setLabel("Status");
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CFAHMSTA );
          _jspx_th_impact_validateSelect_1.setRequired( String.valueOf( !bDisableAllFields ) );
          _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf( bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr> </tr>\r\n        </table>\r\n\r\n      <BR>\r\n\r\n        <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n          <th colspan=\"8\">Male Age Range Approved</th>\r\n          <tr>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setValue( String.valueOf( currentRow.getUNbrRshsAMaAgeMin()/12 ) );
          _jspx_th_impact_validateSelect_2.setName("selMaleMinYear");
          _jspx_th_impact_validateSelect_2.setLabel("Min Year");
          _jspx_th_impact_validateSelect_2.setOptions( yearOptions );
          _jspx_th_impact_validateSelect_2.setBlankValue("false");
          _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_2.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setValue( String.valueOf( currentRow.getUNbrRshsAMaAgeMin()%12 ) );
          _jspx_th_impact_validateSelect_3.setName("selMaleMinMonth");
          _jspx_th_impact_validateSelect_3.setLabel("Min Month");
          _jspx_th_impact_validateSelect_3.setOptions( monthOptions );
          _jspx_th_impact_validateSelect_3.setBlankValue("false");
          _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_3.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setValue( String.valueOf( currentRow.getUNbrRshsAMaAgeMax()/12 ) );
          _jspx_th_impact_validateSelect_4.setName("selMaleMaxYear");
          _jspx_th_impact_validateSelect_4.setLabel("Max Year");
          _jspx_th_impact_validateSelect_4.setOptions( yearOptions );
          _jspx_th_impact_validateSelect_4.setBlankValue("false");
          _jspx_th_impact_validateSelect_4.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_4.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_5.setValue( String.valueOf( currentRow.getUNbrRshsAMaAgeMax()%12 ) );
          _jspx_th_impact_validateSelect_5.setName("selMaleMaxMonth");
          _jspx_th_impact_validateSelect_5.setLabel("Max Month");
          _jspx_th_impact_validateSelect_5.setOptions( monthOptions );
          _jspx_th_impact_validateSelect_5.setBlankValue("false");
          _jspx_th_impact_validateSelect_5.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_5.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </Table>\r\n\r\n      <BR>\r\n        <table width=\"100%\" class =\"tableborder\" cellspacing=\"0\" cellpadding=\"3\">\r\n          <th colspan=\"8\">Female Age Range Approved</th>\r\n          <tr>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_6.setValue( String.valueOf( currentRow.getUNbrRshsAFeAgeMin()/12 ) );
          _jspx_th_impact_validateSelect_6.setName("selFemaleMinYear");
          _jspx_th_impact_validateSelect_6.setLabel("Min Year");
          _jspx_th_impact_validateSelect_6.setOptions( yearOptions );
          _jspx_th_impact_validateSelect_6.setBlankValue("false");
          _jspx_th_impact_validateSelect_6.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_6.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_7.setValue( String.valueOf( currentRow.getUNbrRshsAFeAgeMin()%12 ) );
          _jspx_th_impact_validateSelect_7.setName("selFemaleMinMonth");
          _jspx_th_impact_validateSelect_7.setLabel("Min Month");
          _jspx_th_impact_validateSelect_7.setOptions( monthOptions );
          _jspx_th_impact_validateSelect_7.setBlankValue("false");
          _jspx_th_impact_validateSelect_7.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_7.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
          if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_8.setValue( String.valueOf( currentRow.getUNbrRshsAFeAgeMax()/12 ) );
          _jspx_th_impact_validateSelect_8.setName("selFemaleMaxYear");
          _jspx_th_impact_validateSelect_8.setLabel("Max Year");
          _jspx_th_impact_validateSelect_8.setOptions( yearOptions );
          _jspx_th_impact_validateSelect_8.setBlankValue("false");
          _jspx_th_impact_validateSelect_8.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_8.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
          if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_9.setValue( String.valueOf( currentRow.getUNbrRshsAFeAgeMax()%12 ) );
          _jspx_th_impact_validateSelect_9.setName("selFemaleMaxMonth");
          _jspx_th_impact_validateSelect_9.setLabel("Max Month");
          _jspx_th_impact_validateSelect_9.setOptions( monthOptions );
          _jspx_th_impact_validateSelect_9.setBlankValue("false");
          _jspx_th_impact_validateSelect_9.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_9.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
          if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          </table>\r\n   <br>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n    <tr><th colspan = \"8\"> Foster Home Type </th></tr>\r\n     <tr>\r\n     <td>\r\n    ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("famTypes");
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes(checkedHomeTypes);
          _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CFAHMTYP );
          _jspx_th_impact_codesCheckbox_0.setColumns(2);
          _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
          _jspx_th_impact_codesCheckbox_0.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n     </td>\r\n     </tr>\r\n  </table>\r\n\r\n<br>\r\n\r\n <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n    <th colspan=\"6\">Closure Information</th>\r\n   <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_10.setValue( currentRow.getSzCdRshsClosureRsn() );
          _jspx_th_impact_validateSelect_10.setName("selClosureReason");
          _jspx_th_impact_validateSelect_10.setLabel("Closure Reason");
          _jspx_th_impact_validateSelect_10.setCodesTable( CodesTables.CFACLOSE );
          _jspx_th_impact_validateSelect_10.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_10.setConditionallyRequired( String.valueOf( !bDisableAllFields ) );
          int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
          if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_11.setValue( currentRow.getSzCdRshsRecmndReopen() );
          _jspx_th_impact_validateSelect_11.setName("selRecReopen");
          _jspx_th_impact_validateSelect_11.setLabel("Recommend Re-opening");
          _jspx_th_impact_validateSelect_11.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_11.setCodesTable( CodesTables.CFARCMND );
          int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
          if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   </tr>\r\n   <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_12.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_12.setValue( currentRow.getSzCdRshsInvolClosure() );
          _jspx_th_impact_validateSelect_12.setName("selInvolClosure");
          _jspx_th_impact_validateSelect_12.setLabel("Involuntary Closure");
          _jspx_th_impact_validateSelect_12.setDisabled( String.valueOf( bDisableAllFields ) );
          _jspx_th_impact_validateSelect_12.setCodesTable( CodesTables.CFACLSTP );
          int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
          if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n<hr>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n<tr>\r\n    ");
 if ( !bHideDeleteButton )
    {
          out.write("\r\n        <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete1");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setForm("frmHomeHistoryDetail");
          _jspx_th_impact_ButtonTag_0.setFunction("return deleteRow();");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setAction("/fad/FAHomeHistory/deleteHomeHistoryDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n    ");
}
      if ( !bHideSaveButton )
    {
          out.write("\r\n\r\n        <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave1");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setForm("frmHomeHistoryDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAction("/fad/FAHomeHistory/saveHomeHistory");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      ");
}
          out.write("\r\n    </table>\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

 // SIR 18710 - We have to Call CategoryChange() so the appropriate widgets will
 // be enabled or disabled in the Foster Home Type Section upon page load.

      out.write("\r\n<script language=\"Javascript1.2\">\r\n  categoryChange();\r\n</script>\r\n\r\n");
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
