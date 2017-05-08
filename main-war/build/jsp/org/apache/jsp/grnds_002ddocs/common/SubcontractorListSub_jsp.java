package org.apache.jsp.grnds_002ddocs.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import java.util.Enumeration;

public final class SubcontractorListSub_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 * JSP Name:     Subcontractor List Submodule
 * Code shamelessly stolen by:   Wes Thompson
 * Date Created: 11/05/02
 *
 * Description:
 * This JSP serves to display the subcontractor list and to access the
 * Subcontractor Detail page to maintain subcontractor details.
**/
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/01/03  Todd Reser        Moved Flowerbox and Changelog to top of file.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<script type=\"text/JavaScript\" language=\"JavaScript1.2\">\r\n");

  String SubcontractorSubvfacilityNumber = (String)request.getAttribute( "SubcontractorSubvfacilityNumber" );
  String SubcontractorSubvfacilityType = (String) request.getAttribute("SubcontractorSubvfacilityType");
  String SubcontractorSubvresourceId = (String)request.getAttribute( "SubcontractorSubvidResource" );
  String SubcontractorSubvviewOnly = (String)request.getAttribute( "SubcontractorSubvviewOnly" );

  Date tmpTsLastUpdate = null;
  String SubcontractorSubvtxtSzNmResource = "";
  String SubcontractorSubvindexNum = "";
  String SubcontractorSubvcReqFuncCd = "";
  String SubcontractorSubvtxtUIdRsrcLink = (String)request.getAttribute( "SubcontractorSubvtxtUIdRsrcLink" );
  String SubcontractorSubvtxtUIdRsrcLinkParent = (String)request.getAttribute( "SubcontractorSubvtxtUIdRsrcLinkParent" );
  String SubcontractorSubvchildPlacingAgency = "";
  String SubcontractorSubvaddSubContractorButtonHide = "false";
  String SubcontractorSubvdeleteSubContractorButtonHide = "false";
  String SubcontractorSubvclassResource = "false";

  String SubcontractorSubvpageMode = PageModeConstants.VIEW;
  String SubcontractorSubvrowCss;

// Get tabIndex out of the request
  String tabindexString = (String)request.getAttribute( "tabIndex" );
  int tabIndex = tabindexString == null ? 1 : Integer.valueOf( tabindexString );

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );//SR-
  CCON15SO ccon15so_SubcontractorSub = (CCON15SO) state.getAttribute("CCON15S", request);

  ROWCCON15SOG00_ARRAY SubcontractorSubvsubcontractorArray = null;
  ROWCCON15SOG01_ARRAY SubcontractorSubvsubcontractorServiceArray = null;

  boolean SubcontractorSubvbViewOnly = StringHelper.isTrue(SubcontractorSubvviewOnly);

  if ( ccon15so_SubcontractorSub == null )
  {
    ccon15so_SubcontractorSub = new CCON15SO();
  }
  if ( ccon15so_SubcontractorSub.getROWCCON15SOG00_ARRAY() != null )
  {
    SubcontractorSubvsubcontractorArray = ccon15so_SubcontractorSub.getROWCCON15SOG00_ARRAY();
  }
  else
  {
    SubcontractorSubvsubcontractorArray = new ROWCCON15SOG00_ARRAY();
  }

  if (!StringHelper.isValid(SubcontractorSubvtxtUIdRsrcLinkParent))
  {
    SubcontractorSubvtxtUIdRsrcLinkParent = SubcontractorSubvresourceId;
  }

  if (!StringHelper.isValid(SubcontractorSubvfacilityType))
  {
    SubcontractorSubvpageMode = PageModeConstants.VIEW;
  }

  if (!StringHelper.isValid(SubcontractorSubvfacilityNumber))
  {
    SubcontractorSubvpageMode = PageModeConstants.VIEW;
  }

  // Get the form name out of the request
  String SubcontractorSubvincludingFormName = (String)request.getAttribute( IncludeTag.INCLUDING_FORM_NAME_KEY );
// **********************************************************************
// -- SECURITY CHECK --

// Get the page mode from the session state manager
if( state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request) != null )
{
  SubcontractorSubvpageMode = (String)state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request);
}
//Set the Default page mode if none was passed in
if( (!StringHelper.isValid( SubcontractorSubvpageMode )) || SubcontractorSubvbViewOnly)
{
  SubcontractorSubvpageMode = PageModeConstants.VIEW;
  SubcontractorSubvaddSubContractorButtonHide = "true";
  SubcontractorSubvdeleteSubContractorButtonHide = "true";
}
else
{
  SubcontractorSubvaddSubContractorButtonHide = "false";
  SubcontractorSubvdeleteSubContractorButtonHide = "false";
}


if (StringHelper.isValid(SubcontractorSubvfacilityType))
{
  //If facility type is PRS F/A Homes or Private Agency Adoptive
  if( "70".equals(SubcontractorSubvfacilityType) || "71".equals(SubcontractorSubvfacilityType) )
  {
    SubcontractorSubvaddSubContractorButtonHide = "true";
    SubcontractorSubvdeleteSubContractorButtonHide = "true";
  }

  //If facility is a child placement agency
  if( "60".equals(SubcontractorSubvfacilityType) )
  {
    SubcontractorSubvchildPlacingAgency = "true";
    SubcontractorSubvaddSubContractorButtonHide = "true";
    SubcontractorSubvdeleteSubContractorButtonHide = "true";
  }
}
//If it's a CLASS resource
if( StringHelper.isValid(SubcontractorSubvfacilityNumber) )
{
  SubcontractorSubvclassResource = "true";
  SubcontractorSubvdeleteSubContractorButtonHide = "true";
}

// *******************************************************************


      out.write("\r\n\r\n\r\nfunction SubcontractorSubvsubmitFormToSubDetailWindow(SubcontractorSubvindexNum, SubcontractorSubvcReqFuncCd)\r\n{\r\n  ");
      out.print(SubcontractorSubvincludingFormName);
      out.write(".SubcontractorSubvcReqFuncCd.value = SubcontractorSubvcReqFuncCd;\r\n  disableValidation( \"");
      out.print(SubcontractorSubvincludingFormName);
      out.write("\" );\r\n\r\n  if( SubcontractorSubvcReqFuncCd == 'A' )\r\n  {\r\n    return true;\r\n  }\r\n  if( SubcontractorSubvcReqFuncCd == 'U' )\r\n  {\r\n    ");
      out.print(SubcontractorSubvincludingFormName);
      out.write(".SubcontractorSubvindexNum.value = SubcontractorSubvindexNum;\r\n    submitValidateForm( \"");
      out.print(SubcontractorSubvincludingFormName);
      out.write("\", \"/resource/SubcontractorSub/displaySubcontractorDetail\" );\r\n  }\r\n}\r\n\r\n\r\nfunction SubcontractorSubvsubmitFormToSubDelete()\r\n{\r\n  var numCheckBoxes = ");
      out.print( SubcontractorSubvsubcontractorArray.getROWCCON15SOG00Count() );
      out.write(";\r\n  var x = document.");
      out.print(SubcontractorSubvincludingFormName);
      out.write(";\r\n  var affirmDelete;\r\n\r\n  //Message to confirm a user wants to delete a subcontractor,\r\n  //gives the user an alert if a row was not selected by the user.\r\n  if ( !areAnyChecked( \"SubcontractorSub_cbxSubcontractorCheckboxIndex_CLEAN\", numCheckBoxes ) )\r\n  {\r\n    alert(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) );
      out.write("\");\r\n    return false;\r\n  }\r\n  else\r\n  {\r\n    affirmDelete = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) );
      out.write("');\r\n    if (affirmDelete)\r\n    {\r\n      ");
      out.print(SubcontractorSubvincludingFormName);
      out.write(".SubcontractorSubvcReqFuncCd.value = 'D';\r\n      return true;\r\n    }\r\n   else\r\n   {\r\n     return false;\r\n   }\r\n  }\r\n}\r\n</script>\r\n\r\n");
 /*  Start ESD */ 
      out.write("\r\n\r\n");
      out.write("\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_0.setParent(null);
      _jspx_th_impact_validateInput_0.setType("hidden");
      _jspx_th_impact_validateInput_0.setName("SubcontractorSubvsubcontractorArray");
      _jspx_th_impact_validateInput_0.setValue(SerializationHelper.serializeObject( SubcontractorSubvsubcontractorArray ) );
      int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
      if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_1.setParent(null);
      _jspx_th_impact_validateInput_1.setType("hidden");
      _jspx_th_impact_validateInput_1.setName("SubcontractorSubvsubcontractorServiceArray");
      _jspx_th_impact_validateInput_1.setValue(SerializationHelper.serializeObject( SubcontractorSubvsubcontractorServiceArray ));
      int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
      if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      if (_jspx_meth_impact_validateInput_2(_jspx_page_context))
        return;
      out.write("\r\n  ");
      if (_jspx_meth_impact_validateInput_3(_jspx_page_context))
        return;
      out.write("\r\n  ");
      if (_jspx_meth_impact_validateInput_4(_jspx_page_context))
        return;
      out.write("\r\n  ");
      if (_jspx_meth_impact_validateInput_5(_jspx_page_context))
        return;
      out.write("\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_6.setParent(null);
      _jspx_th_impact_validateInput_6.setType("hidden");
      _jspx_th_impact_validateInput_6.setName("SubcontractorSubvtxtUlIdResource");
      _jspx_th_impact_validateInput_6.setValue(SubcontractorSubvresourceId);
      int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
      if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_7.setParent(null);
      _jspx_th_impact_validateInput_7.setType("hidden");
      _jspx_th_impact_validateInput_7.setName("SubcontractorSubvtxtUIdRsrcLinkParent");
      _jspx_th_impact_validateInput_7.setValue(SubcontractorSubvresourceId);
      int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
      if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_8.setParent(null);
      _jspx_th_impact_validateInput_8.setType("hidden");
      _jspx_th_impact_validateInput_8.setName("SubcontractorSubvtxtUIdRsrcLink");
      _jspx_th_impact_validateInput_8.setValue(SubcontractorSubvtxtUIdRsrcLink);
      int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
      if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_9.setParent(null);
      _jspx_th_impact_validateInput_9.setType("hidden");
      _jspx_th_impact_validateInput_9.setName("txtSzNmResource");
      _jspx_th_impact_validateInput_9.setValue(SubcontractorSubvtxtSzNmResource);
      int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
      if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_10.setParent(null);
      _jspx_th_impact_validateInput_10.setType("hidden");
      _jspx_th_impact_validateInput_10.setName("SubcontractorSubvclassResource");
      _jspx_th_impact_validateInput_10.setValue(SubcontractorSubvclassResource);
      int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
      if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_11.setParent(null);
      _jspx_th_impact_validateInput_11.setType("hidden");
      _jspx_th_impact_validateInput_11.setName("SubcontractorSubvchildPlacingAgency");
      _jspx_th_impact_validateInput_11.setValue(SubcontractorSubvchildPlacingAgency);
      int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
      if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_12.setParent(null);
      _jspx_th_impact_validateInput_12.setType("hidden");
      _jspx_th_impact_validateInput_12.setName(PageMode.PAGE_MODE_ATTRIBUTE_NAME);
      _jspx_th_impact_validateInput_12.setValue(SubcontractorSubvpageMode);
      int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
      if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n  ");
      //  impact:validateInput
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
      _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateInput_13.setParent(null);
      _jspx_th_impact_validateInput_13.setType("hidden");
      _jspx_th_impact_validateInput_13.setEditableMode(EditableMode.EDIT);
      _jspx_th_impact_validateInput_13.setName("validationOverride");
      int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
      if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
 /* Begin Expandable Section with Detail */ 
      out.write("\r\n\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName("subcontractorListSubmodule");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel("Service Site/Subcontractor List");
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex );
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/resource/ResourceDetail/displayResourceDetail");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<div id=\"scroll3_sub\" style=\"OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px\" class=\"tableborderList\">\r\n\r\n\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n            <tr>\r\n                <th class=\"thList\">&nbsp;</th>\r\n                <th class=\"thList\">Resource Name</th>\r\n                <th class=\"thList\">Resource ID</th>\r\n                <th class=\"thList\">Service      </th>\r\n            </tr>\r\n\r\n\r\n");
 //Variable to hold the css class for the each row in the lists
//String rowCss = "odd";
//int SubcontractorSubvloopCount = 0;
//int SubcontractorSubvsubcontractorCount = 0;
// end definitions

 Enumeration eSubcontractorSubvsubcontractorArray= SubcontractorSubvsubcontractorArray.enumerateROWCCON15SOG00();

 if (eSubcontractorSubvsubcontractorArray.hasMoreElements())
    {
    ROWCCON15SOG00 SubcontractorSubvsubcontractorRow = null;
   // int SubcontractorSubvsubcontractorArraySize = SubcontractorSubvsubcontractorArray.getUlRowQty( );
     int loopCount = 0;
     while (eSubcontractorSubvsubcontractorArray.hasMoreElements())
       {
     
        SubcontractorSubvsubcontractorRow =   (ROWCCON15SOG00) eSubcontractorSubvsubcontractorArray.nextElement();
        SubcontractorSubvrowCss = FormattingHelper.getRowCss( loopCount + 1 );
        String serviceCodeCategory = CodesTables.CGLSVCCD;
        if(Lookup.isValidCode(CodesTables.CSVCCODE, SubcontractorSubvsubcontractorRow.getSzCdRsrcLinkService())){
        	serviceCodeCategory = CodesTables.CSVCCODE;
        }

              out.write("\r\n\r\n");
if ( SubcontractorSubvbViewOnly )
  { 
              out.write("\r\n    <tr class=\"");
              out.print(SubcontractorSubvrowCss);
              out.write("\">\r\n        <td><nobr></td>\r\n        <td><nobr>");
              out.print(SubcontractorSubvsubcontractorRow.getSzNmResource());
              out.write("</td>\r\n        <td><nobr>");
              out.print(SubcontractorSubvsubcontractorRow.getUIdRsrcLinkChild());
              out.write("</td>\r\n        <td><nobr>");
              out.print(Lookup.simpleDecodeSafe(serviceCodeCategory, SubcontractorSubvsubcontractorRow.getSzCdRsrcLinkService() ));
              out.write("</td>\r\n    </tr>\r\n");
 }
   else
   {

              out.write("\r\n    <tr class=\"");
              out.print(SubcontractorSubvrowCss);
              out.write("\">\r\n        <td><nobr>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_14.setType("checkbox");
              _jspx_th_impact_validateInput_14.setName( "SubcontractorSub_cbxSubcontractorCheckboxIndex_CLEAN" + (loopCount+1) );
              _jspx_th_impact_validateInput_14.setValue(Integer.toString(loopCount));
              _jspx_th_impact_validateInput_14.setTabIndex( tabIndex );
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n        <td><nobr><a tabIndex=\"");
              out.print( tabIndex );
              out.write("\" href=\"javascript:SubcontractorSubvsubmitFormToSubDetailWindow( '");
              out.print(loopCount);
              out.write("','U')\">");
              out.print(SubcontractorSubvsubcontractorRow.getSzNmResource());
              out.write("</a></td>\r\n        <td><nobr>");
              out.print(SubcontractorSubvsubcontractorRow.getUIdRsrcLinkChild());
              out.write("</td>\r\n        <td><nobr>");
              out.print(Lookup.simpleDecodeSafe(serviceCodeCategory, SubcontractorSubvsubcontractorRow.getSzCdRsrcLinkService() ));
              out.write("</td>\r\n    </tr>\r\n");
}
              out.write("\r\n\r\n");

    loopCount=loopCount+1;
      }//end for
  }
  else
  {
    SubcontractorSubvdeleteSubContractorButtonHide ="true";

              out.write("\r\n  <tr class=\"odd\">\r\n    <td colspan=\"4\">");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("</td>\r\n  </tr>\r\n");
  } 
              out.write("\r\n </table>\r\n</div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    <td  align=\"left\" colspan=\"2\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDeleteSubcontractorDetail");
          _jspx_th_impact_ButtonTag_0.setBackSafe("true");
          _jspx_th_impact_ButtonTag_0.setDisabled(SubcontractorSubvdeleteSubContractorButtonHide);
          _jspx_th_impact_ButtonTag_0.setFunction("return SubcontractorSubvsubmitFormToSubDelete();");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setForm(SubcontractorSubvincludingFormName);
          _jspx_th_impact_ButtonTag_0.setAction("/resource/SubcontractorSub/deleteSubcontractorDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td align=\"right\" colspan=\"3\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ButtonTag_1.setName("btnAddSubcontractorDetail");
          _jspx_th_impact_ButtonTag_1.setDisabled(SubcontractorSubvaddSubContractorButtonHide);
          _jspx_th_impact_ButtonTag_1.setFunction("return SubcontractorSubvsubmitFormToSubDetailWindow( '','A');");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm(SubcontractorSubvincludingFormName);
          _jspx_th_impact_ButtonTag_1.setAction("/resource/SubcontractorSub/displaySubcontractorDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
 /*  End xpandDetailTable div */ 
      out.write('\r');
      out.write('\n');
      out.write(' ');
 /* End ESD */ 
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

  private boolean _jspx_meth_impact_validateInput_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent(null);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("SubcontractorSubvindexNum");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent(null);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("tmpTsLastUpdate");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent(null);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("SubcontractorSubvcReqFuncCd");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent(null);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("WindowName");
    _jspx_th_impact_validateInput_5.setValue("SubcontractorListSub");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
