package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSVC09DO;
import java.util.HashSet;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class APSOutcomeMatrixDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*--------------------------------------------------------------------------------
//*  JSP Name:     APS Outcome Matrix Detail
//*  Created by:   Jenn Casdorph
//*  Date Created: 12/18/2002
//*
//*  Description:
//*  This JSP displays the details for a given APS Outcome Matrix Row. Depending upon
//*  the user's privileges, the user can use this page to view, update, or add
//*  factors to the APS Outcome Matrix on the APS Service Plan Page.
//*  PageModes are as follows:  NEW, EDIT, and VIEW
//*
//*   Change History:
//*   Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*  05/23/2002  CAWTHOCW        SIR 17629 - Added Spell check button for the two
//*                              comment fields on the detail page.
//*
//*  05/14/2003  CASDORJM        SIR 17323 - Change the page so that the date would
//*                              not prefill.  Also added restrictRepost="true" to the
//*                              button tags.
//*
//*  05/04/2005  CORLEYAN        SIR 23530 - Added Information about the new care
//*                              codes tables.
//*
//*  06/28/05    dejuanr         changes related to SIR 23723
//*
//*  07/21/05    brauchs         Fixed colspan issues 
//*
//*  07/21/05    yeehp           took the spellcheck button out.
//*
//*  07/24/05    brauchs         Aligned label TDs 
//*
//*  08/12/05    pisharrk        SIR 23899 - The 'Spell Check' button to be hidden in MPS
//*
//*  08/16/05    marallh         SIR 23816 - Change the name of the date field for the
//*                              problem on the Outcome Matrix page.  Change the name to
//*                              "Date Problem Entered"
//*
//*  09/19/05    Todd Reser      SIR 23937 - Removed If Statement that hid spell check button
//*                              in MPS
//*  09/22/05    Todd Reser      Re-added an "if !care" statement that was erroneously deleted
//*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 /* Import State Management classes */ 
      out.write("\r\n\r\n\r\n");
 /* Import PageMode and other utilities used on the page */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");
/* Import needed for Messages */ 
      out.write('\r');
      out.write('\n');
/* Import needed for Form Launch */ 
      out.write('\r');
      out.write('\n');
/* impact classes */
      out.write("\r\n\r\n");

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int tabIndex = 1;
//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
//*********************
//*** SET PAGE MODE ***
//*********************

//  Check to see if APS Service Plan passed us a page mode through the request
//  We will either pass PageMode.EDIT or PageMode.NEW depending on how the page was accessed.
String pageMode = (String)request.getAttribute("pageMode");
pageMode = pageMode != null ? pageMode : PageModeConstants.VIEW;

//  If APS Service Plan was in VIEW mode this page should ALWAYS be in VIEW mode too!
if ( PageMode.getPageMode(request).equals(PageModeConstants.VIEW) )
{
  pageMode = PageModeConstants.VIEW;
}

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
ROWCSVC09DO problemRow = (ROWCSVC09DO) state.getAttribute("rowcsvc09do", request);
problemRow = problemRow != null ? problemRow : new ROWCSVC09DO();

// SIR 23530 - Determine if the domain is a part of the
// Care codes tables, this indicator will be used to
// set other information on the page.
 Set domainCodes = new HashSet(Lookup.getCategoryCodesCollection(
          CodesTables.CCAREDOM));

  boolean care = domainCodes.contains(problemRow.getSzCdDomain());

      out.write("\r\n\r\n");

//******************
//*** JAVASCRIPT ***
//******************

      out.write("\r\n\r\n");
/* Needed for Form Launch Custom tag */
      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n\r\n");
/* Needed for IsDirty() functionality */
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n\r\n");
/* BEGIN: JavaScript function definitions */
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n");
 if ( !pageMode.equals(PageModeConstants.VIEW))
{


      out.write("\r\n  window.onload = function ()\r\n{\r\n   filterDropDownByCategory( frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeActnCateg,\r\n                             frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeAction, 1, true );\r\n");

  //  We filter the Action Sub-Category drop down box every time we load the page.
  //  If the user enters the page and Action Sub-Category is blank, and then the user
  //  enters an Action Sub-Category and attempts to save the page but the page FAILS
  //  validation, we need to use the value for Action Sub-Category that was submitted
  //  to the request when the form was submitted.
  String action = "";
  if ( request.getParameter("selSzCdApsOutcomeAction") != null )
  {
    action = request.getParameter("selSzCdApsOutcomeAction");
  }
  else
  {
    action = problemRow.getSzCdApsOutcomeAction();
  }

      out.write("\r\n  frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeAction.options.value = '");
      out.print( action );
      out.write("';\r\n  CleanSelect(frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeAction);\r\n\r\n};\r\n");
}
      out.write("\r\n\r\n// This function is called before the page unloads. It creates the\r\n// \"Are you sure you want to navigate away from this page...\" pop-up\r\n// message.\r\nwindow.onbeforeunload = function ()\r\n{\r\n        IsDirty();\r\n};\r\n\r\n// Clears the Outcome Sub-Category when Action Category or Sub-Category is changed\r\nfunction clearOutcomeSub()\r\n{\r\n  document.frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeResult.value = \"\";\r\n  document.frmAPSOutcomeMatrixDetail.dtDtApsOutcomeRecord.value = \"\";\r\n  ");
 // SIR 23530, this field will not exist for care, so only run this
     // javascript if this is not a CARE item.
     if (!care) { 
      out.write("\r\n      document.frmAPSOutcomeMatrixDetail.txtSzTxtApsOutcomeResult.value = \"\";\r\n  ");
 } 
      out.write("\r\n}\r\n\r\n// Clears the Action Sub-Category when the Action Category is changed\r\nfunction clearActionSub()\r\n{\r\n  document.frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeAction.value = null;\r\n}\r\n\r\n//  Filters the Action Sub-Category Select Drop Down box based on what is\r\n//  selected in the Action Category box.\r\n\r\n//  Create a codeArray for every dropdown box that needs to be filtered on the page\r\n//  SIR 23530 - use the CARE codes table for the dropdown for care items\r\n");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write(';');
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write(";\r\nfunction filterDropDownByCategory(selectBoxChanged, selectBoxToFilter, keyLength, blankValue )\r\n{\r\n  ");
 if (care) {
      out.write("\r\n  codeArray = CACTITP2;\r\n  ");
 } else { 
      out.write("\r\n  codeArray = CACTITYP;\r\n  ");
 } 
      out.write("\r\n  //  Get the filter key from what has been selected in the 'parent' select box\r\n  var filterOn = selectBoxChanged.options.value;\r\n  var key = filterOn.substring( 0, keyLength );\r\n  populateFilteredDropdown(key, selectBoxToFilter, codeArray, blankValue );\r\n}\r\n\r\n</script>\r\n\r\n");

//*************************
//*** VALIDATION ERRORS ***
//*************************

      out.write('\r');
      out.write('\n');
/* Include custom tag for displaying errors on the page */
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n\r\n");

//**************************
//**** FORM STARTS HERE ****
//**************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAPSOutcomeMatrixDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/APSServicePlan/displayAPSOutcomeMatrixDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.APSOutcomeMatrixDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');

//*****************
//**** PROBLEM  ***
//*****************

          out.write("\r\n<input type=\"hidden\" name=\"hdnNewDuplicateFactor\" value='");
          out.print( (String)request.getAttribute("hdnNewDuplicateFactor") );
          out.write("'>\r\n\r\n");

//*****************
//**** PROBLEM  ***
//*****************

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n     <th colspan=\"2\">Problem</th>\r\n  </tr>\r\n");
 // SIR 23530 - Domain is only displayed for CARE.
    if (care)
    { 
          out.write("\r\n  <tr>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtSzCdDomain");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Domain");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( Lookup.simpleDecodeSafe( CodesTables.CCAREDOM , problemRow.getSzCdDomain() ));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n");
 } 
          out.write("\r\n  <tr>\r\n    <td width=\"150\">");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtCCdApsClientFactor");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Category");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( Lookup.simpleDecodeSafe( care ? CodesTables.CCARECAT : CodesTables.CPROCATG , problemRow.getCCdApsClientFactor() ));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtSzCdApsClientFactor");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Sub-Category");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( Lookup.simpleDecodeSafe( care ? CodesTables.CCAREFAC : CodesTables.CPROBTYP, problemRow.getSzCdApsClientFactor() ) );
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dtDtApsOutcomeProblem");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Date Problem Entered");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatDate( problemRow.getDtDtApsOutcomeProblem() ));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n");
 // SIR 23530 - Comments boxes will only be available for non care items.
   if (!care)
   {

          out.write("\r\n  <tr>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("txtSzTxtApsCltFactorCmnts");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Comments");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(FormattingHelper.formatString(problemRow.getSzTxtApsCltFactorCmnts()));
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n");
 } 
          out.write("\r\n</table>\r\n");

//*****************
//**** ACTION ****
//*****************

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n     <th colspan=\"4\">Action</th>\r\n  </tr>\r\n  <tr>\r\n    <td  width=\"150\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Category");
          _jspx_th_impact_validateSelect_0.setName("selSzCdApsOutcomeActnCateg");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable( care ? CodesTables.CACTCTG2 : CodesTables.CACTCATG );
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setOnChange("clearOutcomeSub(); clearActionSub(); filterDropDownByCategory( frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeActnCateg, frmAPSOutcomeMatrixDetail.selSzCdApsOutcomeAction, 1, true )");
          _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_0.setValue( problemRow.getSzCdApsOutcomeActnCateg() );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Sub-Category");
          _jspx_th_impact_validateSelect_1.setName("selSzCdApsOutcomeAction");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable( care ? CodesTables.CACTITP2 : CodesTables.CACTITYP );
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setOnChange("clearOutcomeSub()");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setValue( problemRow.getSzCdApsOutcomeAction() );
          _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 275");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setName("dtDtApsOutcomeAction");
          _jspx_th_impact_validateDate_0.setLabel("Date");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate( problemRow.getDtDtApsOutcomeAction() ) );
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n");
 // SIR 23530 - Comments boxes will only be available for non care items.
   if (!care)
   {

          out.write("\r\n  <tr>\r\n    <td>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtSzTxtApsOutcomeAction");
          _jspx_th_impact_validateTextArea_0.setColspan("3");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("75");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
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
              out.print( FormattingHelper.formatString( problemRow.getSzTxtApsOutcomeAction() ) );
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n");
 } 
          out.write("\r\n</table>\r\n");

//*****************
//**** OUTCOME ****
//*****************

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n     <th colspan=\"4\">Outcome</th>\r\n  </tr>\r\n\r\n  <tr>\r\n    <td width=\"150\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Sub-Category");
          _jspx_th_impact_validateSelect_2.setName("selSzCdApsOutcomeResult");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.COUTCTYP );
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString( problemRow.getSzCdApsOutcomeResult() ) );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setName("dtDtApsOutcomeRecord");
          _jspx_th_impact_validateDate_1.setLabel("Date");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate( problemRow.getDtDtApsOutcomeRecord()) );
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n");
 // SIR 23530 - Comments boxes will only be available for non care items.
   if (!care)
   {

          out.write("\r\n  <tr>\r\n    <td>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtSzTxtApsOutcomeResult");
          _jspx_th_impact_validateTextArea_1.setColspan("3");
          _jspx_th_impact_validateTextArea_1.setLabel("Comments");
          _jspx_th_impact_validateTextArea_1.setRows("3");
          _jspx_th_impact_validateTextArea_1.setCols("75");
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.print(FormattingHelper.formatString( problemRow.getSzTxtApsOutcomeResult() ));
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
          out.write("\r\n</table>\r\n\r\n\r\n<br>\r\n");
 /* BEGIN: Outcome Matrix Detail Buttons */ 
          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n        <tr>\r\n           <td width=\"90%\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setForm("frmAPSOutcomeMatrixDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/investigation/OutcomeMatrix/deleteOutcomeMatrixDetail");
          _jspx_th_impact_ButtonTag_0.setDisabled( "Y".equals(problemRow.getCIndApsOutcomeOrigFctr()) ? "true" : "false" );
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n           <td width=\"10%\">\r\n             ");
 if (!care) { 
          out.write('\r');
          out.write('\n');
 /* SIR 23937 - Removed If Statement that hid spell check button in MPS */ 
          out.write("\r\n              ");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmAPSOutcomeMatrixDetail");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck("txtSzTxtApsOutcomeAction, txtSzTxtApsOutcomeResult");
          _jspx_th_impact_spellCheck_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n             ");
 } 
          out.write("\r\n           </td>\r\n           <td width=\"10%\">");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmAPSOutcomeMatrixDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/investigation/OutcomeMatrix/saveOutcomeMatrixDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n</table>\r\n");
/* END: Buttons */
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
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

//************************
//**** FORM ENDS HERE ****
//************************

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
    _jspx_th_impact_codeArray_0.setCodeName("CACTITYP");
    _jspx_th_impact_codeArray_0.setArrayName("CACTITYP");
    _jspx_th_impact_codeArray_0.setBlankValue("true");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CACTITP2");
    _jspx_th_impact_codeArray_1.setArrayName("CACTITP2");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
}
