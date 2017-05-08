package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.person.NameHistoryConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class NameHistoryDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Name History Detail
//*  Created by:   Heather Dean
//*  Date Created: 12/11/02
//*
//*  Description:
//*  This JSP allows the user to maintain a person's name/alias (or A.K.A) list
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/11/02  Heather Dean      Initial jsp creation
//**

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<!--Start Main Content-->\r\n");
 BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script language=\"Javascript1.2\">\r\n// Check for changes before navigating off\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n</script>\r\n\r\n");

int tabIndex = 1;
boolean bIsPrimary = false;
boolean bDisablePrimary = false;
boolean bIsInvalid = false;
boolean bDisableInvalid = false;
boolean bHideEndDateButton = false;
boolean bDisableNameFields = false;
boolean bHideSaveButton = false;
boolean bHideEndDateField = false;
String firstName = "";
String middleName = "";
String lastName = "";
String suffix = "";
org.exolab.castor.types.Date today = DateHelper.toCastorDate( new java.util.Date() );
org.exolab.castor.types.Date startDate = today;
org.exolab.castor.types.Date endDate = null;
String tsLastUpdate = null;
String pageMode = null;
ROWCINV25SOG00_ARRAY rowArray = null;
String isAdd = "";
int arrayIndex = ContextHelper.getIntSafe( request, "arrayIndex" );

// Get the page mode that was passed to the Name History
// submodule by the including JSP.
pageMode = (String)state.getAttribute( NameHistorySubmoduleConversation.PAGE_MODE_KEY, request );

CINV25SO cinv25so = (CINV25SO) state.getAttribute( "CINV25SO", request );
if ( cinv25so != null)
{
  rowArray = cinv25so.getROWCINV25SOG00_ARRAY();

/**  if ( request.getAttribute("isAdd") != null )
  {
    isAdd = (String) request.getAttribute( "isAdd" ) ;
  }
*/

/**
 * Added by SR
 */
////////////////////////////////////////////////////////////////////////////////////////////////////
  if ( request.getParameter("isAdd") != null )
  {
    isAdd = request.getParameter( "isAdd" ) ;
  }

  if( ! "true".equals(isAdd) )
  {
     bDisableNameFields = true;
     ROWCINV25SOG00 selectedName = rowArray.getROWCINV25SOG00( arrayIndex );
     firstName = selectedName.getSzNmNameFirst();
     middleName = selectedName.getSzNmNameMiddle();
     lastName = selectedName.getSzNmNameLast();
     suffix = selectedName.getSzCdNameSuffix();
     startDate = selectedName.getDtDtNameStartDate();
     endDate = selectedName.getDtDtNameEndDate();
     if ( endDate != null )
     {
       bHideEndDateButton = true;
       bDisablePrimary = true;
     }
     if ("Y".equals(selectedName.getBIndNamePrimary()) ){
       bIsPrimary = true;
       bDisablePrimary = true;
       bDisableInvalid = true;
     }
     if ("Y".equals(selectedName.getBIndNameInvalid()) ){
       bIsInvalid = true;
     }
     if ( bIsPrimary && !bIsInvalid && ( endDate == null || DateHelper.MAX_CASTOR_DATE.equals(endDate)))
     {
       bDisableInvalid = true;
       bHideSaveButton = true;
       bHideEndDateButton = true;
       bHideEndDateField = true;
     }
     // STGAP00004856
     bIsPrimary = "Y".equals(selectedName.getBIndNamePrimary()) ? true : false;
     Boolean bIsEndDated = !DateHelper.isNull(endDate);
     // Enable Invalid check box and show Save button at all time if it has not been marked invalid
     if (bIsEndDated && bIsInvalid) {
       bDisableInvalid = true;
       bHideSaveButton = true;
     } else {
       bDisableInvalid = false;
       bHideSaveButton = false;
     }
     if (bIsPrimary || bIsEndDated) {
       bHideEndDateButton = true;
     } else {
       bHideEndDateButton = false;
     }
     if (!bIsPrimary && !bIsEndDated && !bIsInvalid) {
       bDisablePrimary = false;
     } else {
       bDisablePrimary = true;
     }
     // end STGAP00004856
  }
///////////////////////////////////////////////////////////////////////////////////////////////////////
} //end if cinv25so not null

      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmNameHistoryDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/NameHistory/saveNameHistory");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.NameHistoryCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("cinv25so_array");
          _jspx_th_impact_validateInput_0.setValue( SerializationHelper.serializeObject( rowArray ) );
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
          _jspx_th_impact_validateInput_1.setName("isAdd");
          _jspx_th_impact_validateInput_1.setValue( isAdd );
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
          _jspx_th_impact_validateInput_2.setName("arrayIndex");
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatInt(arrayIndex) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnIsInvalid");
          _jspx_th_impact_validateInput_3.setValue( String.valueOf( bIsInvalid ));
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
          _jspx_th_impact_validateInput_4.setName("hdnIsPrimary");
          _jspx_th_impact_validateInput_4.setValue( String.valueOf( bIsPrimary ));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n   <table width=\"100%\" class=\"tableborder\" cellpadding=\"3\" cellspacing=\"0\">\r\n        <tr>\r\n          <th colspan=\"8\">Name History Detail\r\n        </th>\r\n         <TR>\r\n            <TD>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setValue( firstName  );
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setName("txtNameHistFirst");
          _jspx_th_impact_validateInput_5.setLabel("First");
          _jspx_th_impact_validateInput_5.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_5.setDisabled( String.valueOf( bDisableNameFields ) );
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setSize("12");
          _jspx_th_impact_validateInput_5.setMaxLength("12");
          _jspx_th_impact_validateInput_5.setConstraint("Name12");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</TD>\r\n            <TD>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setValue( middleName  );
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setName("txtNameHistMiddle");
          _jspx_th_impact_validateInput_6.setLabel("Middle");
          _jspx_th_impact_validateInput_6.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_6.setDisabled( String.valueOf( bDisableNameFields ) );
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setSize("12");
          _jspx_th_impact_validateInput_6.setMaxLength("12");
          _jspx_th_impact_validateInput_6.setConstraint("Name12");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</TD>\r\n            <TD>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setValue( lastName  );
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setName("txtNameHistLast");
          _jspx_th_impact_validateInput_7.setLabel("Last");
          _jspx_th_impact_validateInput_7.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_7.setDisabled( String.valueOf( bDisableNameFields ) );
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setSize("22");
          _jspx_th_impact_validateInput_7.setMaxLength("22");
          _jspx_th_impact_validateInput_7.setConstraint("Name22");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</TD>\r\n            <TD>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setValue( suffix );
          _jspx_th_impact_validateSelect_0.setName("selNameHistSuffix");
          _jspx_th_impact_validateSelect_0.setLabel("Suffix");
          _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf( bDisableNameFields ) );
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CSUFFIX );
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</TD>\r\n        </TR>\r\n\r\n        <tr>\r\n            <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setColspan("4");
          _jspx_th_impact_validateInput_8.setChecked( String.valueOf( bIsPrimary ) );
          _jspx_th_impact_validateInput_8.setDisabled( String.valueOf( bDisablePrimary ) );
          _jspx_th_impact_validateInput_8.setName("cbxPrimary");
          _jspx_th_impact_validateInput_8.setLabel("Primary");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td>\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setColspan("4");
          _jspx_th_impact_validateInput_9.setChecked( String.valueOf( bIsInvalid ) );
          _jspx_th_impact_validateInput_9.setDisabled( String.valueOf( bDisableInvalid ) );
          _jspx_th_impact_validateInput_9.setName("cbxInvalid");
          _jspx_th_impact_validateInput_9.setLabel("Invalid");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\r\n        <TR>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspStartDate");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Start Date");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatDate( startDate ) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            ");
if (!bHideEndDateField) {
          out.write("\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspEndDate");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("End Date");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatDate( endDate ) );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            ");
}
          out.write("\r\n            <td colspan=\"2\">\r\n            ");
 if ( !bHideEndDateButton && !PageMode.getPageMode( request ).equals( PageModeConstants.VIEW ) )
            {
          out.write("\r\n            <a onClick=\"javascript:updateDisplayOnlyField( 'frmNameHistoryDetail', 'dspEndDate', '");
          out.print( FormattingHelper.formatDate( new java.util.Date() ) );
          out.write("' )\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" >\r\n              <img src=\"/grnds-docs/images/shared/btnSetEndDate.gif\" class=\"md\" border=\"0\" >\r\n            </a>\r\n            ");
}
          out.write("\r\n            </td>\r\n        </TR>\r\n    </table>\r\n    ");

    if ( !bHideSaveButton )
    {
          out.write("\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n        <tr>\r\n          <td align=\"right\">\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave1");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmNameHistoryDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/person/NameHistory/saveNameHistory");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    ");

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
