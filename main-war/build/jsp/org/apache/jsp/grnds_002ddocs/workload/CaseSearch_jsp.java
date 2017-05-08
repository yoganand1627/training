package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class CaseSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     CaseSearch
//*  Created by:   Jonathan Hardy
//*  Date Created: 01/06/03
//*
//*  Description:
//*  This JSP serves as the input form for the search parameters of a case search.  Once
//*  parameters are entered and the 'Search' button is pressed, the searchCase action is
//*  performed in the workload/CaseSearch conversation.  If city and county constraints
//*  are included, the city/county agreement is validated first.  If this validation fails,
//*  the user is returned to this page to correct the issue.  If validation succeeds, the
//*  user is sent to CaseList to find the results of the search, if any.
//*
//** Change History:
//**  Date        User              Description
//**  --------    ----------------  --------------------------------------------------
//**  03/20/2003  Eric Dickman      QA Sweep
//**  06/05/2003  thompswa          SIR 17926 Added contentType attribute to
//**                                Program dropdown to display codes instead of
//**                                decodes. Required import of SelectTag.
//**  07/26/2006  Bhavna Gehlot     Made Modifications for GA.
//**  03/20/2008  Corey Harden      deleted onChange attribute of the city field
//**								 

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Set the page mode
  String pageMode = PageModeConstants.EDIT;
  //Initialize all the input fields such that search parameters are held on to - SIR 19115
  String txtCaseId = ContextHelper.getStringSafe( request, "txtUlIdCase" );
  String txtNmFirst = ContextHelper.getStringSafe( request, "txtSzNmCaseFirst" );
  String txtNmMiddle = ContextHelper.getStringSafe( request, "txtSzNmCaseMiddle" );
  String txtNmLast = ContextHelper.getStringSafe( request, "txtSzNmCaseLast" );
  String txtNmFacility = ContextHelper.getStringSafe( request, "txtSzNmCase" );
  //String selProgram = ContextHelper.getStringSafe( request, "selSzCdCaseProgram" );
  String selRegion = ContextHelper.getStringSafe( request, "selSzCdCaseRegion" );
  String selCounty = ContextHelper.getStringSafe( request, "selSzCdCaseCounty" );
  String txtCity = ContextHelper.getStringSafe( request, "txtSzAddrCity" );
  //Adding new fields as per GA Modifications
  String txtCaseManagerId = ContextHelper.getStringSafe( request, "txtUlIdCaseManager");
  String txtNmCaseManagerFirst = ContextHelper.getStringSafe( request, "txtSzNmCaseManagerFirst");
  String txtNmCaseManagerLast = ContextHelper.getStringSafe( request, "txtSzNmCaseManagerLast");
  String txtDtLastUpdate = ContextHelper.getStringSafe( request, "txtDtDtLastUpdate");
  String selCdCpsInvstDtlOvrllDisptn = ContextHelper.getStringSafe( request, "selSzCdCpsInvstDtlOvrllDisptn");
  String selCdStage = ContextHelper.getStringSafe( request, "selSzCdStage");
  String txtNbrUnit = ContextHelper.getStringSafe( request, "txtSzNbrUnit");
  String selRbOpenClose = ContextHelper.getStringSafe( request, "selRbOpenClose");
  String orderBy = "decode";



  boolean bSearchButtonHide = false;

  // Assign tabIndex
  int tabIndex = 1;
  String informationalMessage = null;

  UserProfile user = UserProfileHelper.getUserProfile( request );
  if ( user.hasRight( UserProfile.SEC_RESTRICT_CASE_SEARCH ) )
  {
    pageMode = PageModeConstants.VIEW;
    informationalMessage = new StringBuffer().append("<li>").append( MessageLookup.getMessageByNumber( Messages.MSG_NO_SEARCH_RIGHT ) ).append("</li>").toString();
  }

      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaseSearch");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/CaseSearch/searchCase");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
 /* Begin Detail */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <td>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n        <tr>\r\n            <th colspan=6>Case ID Search</th>\r\n         </tr>\r\n       </table>\r\n     </td>\r\n  </tr>\r\n  <tr>\r\n  <td>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n\r\n           <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_0.setLabel("Case ID");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setConstraint("ID");
          _jspx_th_impact_validateInput_0.setName("txtUlIdCase");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setValue( txtCaseId );
          _jspx_th_impact_validateInput_0.setSize("10");
          _jspx_th_impact_validateInput_0.setMaxLength("10");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n             </td>\r\n\r\n  </tr>\r\n\r\n ");
 /* Adding the Case Manager Search */ 
          out.write("\r\n <tr>\r\n    <th colspan=6>Case Manager Search</th>\r\n  </tr>\r\n\r\n            <tr>\r\n                <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_1.setLabel("Case Manager ID");
          _jspx_th_impact_validateInput_1.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_1.setConstraint("ID");
          _jspx_th_impact_validateInput_1.setName("txtUlIdCaseManager");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setValue( txtCaseManagerId );
          _jspx_th_impact_validateInput_1.setSize("10");
          _jspx_th_impact_validateInput_1.setMaxLength("10");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        </tr>\r\n\r\n\r\n<tr>\r\n            <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_2.setLabel("First Name");
          _jspx_th_impact_validateInput_2.setConstraint("Name12");
          _jspx_th_impact_validateInput_2.setName("txtSzNmCaseManagerFirst");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setValue( txtNmCaseManagerFirst );
          _jspx_th_impact_validateInput_2.setSize("12");
          _jspx_th_impact_validateInput_2.setMaxLength("12");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n           <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_3.setLabel("Last Name");
          _jspx_th_impact_validateInput_3.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_3.setConstraint("Name22");
          _jspx_th_impact_validateInput_3.setName("txtSzNmCaseManagerLast");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setValue( txtNmCaseManagerLast );
          _jspx_th_impact_validateInput_3.setSize("22");
          _jspx_th_impact_validateInput_3.setMaxLength("22");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n         </tr>\r\n\r\n  <tr>\r\n    <th colspan=6>Case Name Search</th>\r\n  </tr>\r\n\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_4.setLabel("First");
          _jspx_th_impact_validateInput_4.setConstraint("Name12");
          _jspx_th_impact_validateInput_4.setName("txtSzNmCaseFirst");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue( txtNmFirst );
          _jspx_th_impact_validateInput_4.setSize("12");
          _jspx_th_impact_validateInput_4.setMaxLength("12");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_5.setLabel("Middle");
          _jspx_th_impact_validateInput_5.setConstraint("Name12");
          _jspx_th_impact_validateInput_5.setName("txtSzNmCaseMiddle");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setValue( txtNmMiddle );
          _jspx_th_impact_validateInput_5.setSize("12");
          _jspx_th_impact_validateInput_5.setMaxLength("12");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_6.setLabel("Last");
          _jspx_th_impact_validateInput_6.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_6.setConstraint("Name22");
          _jspx_th_impact_validateInput_6.setName("txtSzNmCaseLast");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setValue( txtNmLast );
          _jspx_th_impact_validateInput_6.setSize("22");
          _jspx_th_impact_validateInput_6.setMaxLength("22");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n\r\n  <tr>\r\n    <th colspan=6>Facility Case Name Search</th>\r\n  </tr>\r\n\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_7.setLabel("Name");
          _jspx_th_impact_validateInput_7.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_7.setConstraint("Name25");
          _jspx_th_impact_validateInput_7.setName("txtSzNmCase");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setValue( txtNmFacility );
          _jspx_th_impact_validateInput_7.setSize("25");
          _jspx_th_impact_validateInput_7.setMaxLength("25");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n\r\n  <tr>\r\n    <th colspan=6>Additional Criteria</th>\r\n  </tr>\r\n\r\n   <tr>\r\n\r\n                  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Stage");
          _jspx_th_impact_validateSelect_0.setName("selSzCdStage");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setOrderBy( SelectTag.DECODE_ORDERBY );
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CTXTOGA );
          _jspx_th_impact_validateSelect_0.setContentType( SelectTag.DECODES );
          _jspx_th_impact_validateSelect_0.setValue( selCdStage );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                                      \r\n               </td>\r\n\r\n              <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Region");
          _jspx_th_impact_validateSelect_1.setName("selSzCdCaseRegion");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CREGIONS );
          _jspx_th_impact_validateSelect_1.setValue( selRegion );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n              <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_8.setLabel("Unit");
          _jspx_th_impact_validateInput_8.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_8.setConstraint("Units");
          _jspx_th_impact_validateInput_8.setName("txtSzNbrUnit");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setValue( txtNbrUnit );
          _jspx_th_impact_validateInput_8.setSize("11");
          _jspx_th_impact_validateInput_8.setMaxLength("11");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n          </tr>\r\n\r\n    <tr>\r\n\r\n              <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("County");
          _jspx_th_impact_validateSelect_2.setName("selSzCdCaseCounty");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CCOUNT );
          _jspx_th_impact_validateSelect_2.setValue( selCounty );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n              \r\n      ");
 /* 6-6-08 Corey Harden  Changed onChange attribute to lowerCase all letters in the city entered */ 
          out.write("\r\n      \r\n              <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_9.setLabel("City");
          _jspx_th_impact_validateInput_9.setConstraint("City");
          _jspx_th_impact_validateInput_9.setName("txtSzAddrCity");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setValue( txtCity );
          _jspx_th_impact_validateInput_9.setSize("20");
          _jspx_th_impact_validateInput_9.setMaxLength("20");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                                        \r\n              </td>\r\n          </tr>\r\n  </table>\r\n  </td>\r\n  </tr>\r\n  <tr>\r\n  <td>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n            <tr>\r\n              <td width = \"16%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_10.setLabel("Assigned Date");
          _jspx_th_impact_validateInput_10.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_10.setConstraint("Date");
          _jspx_th_impact_validateInput_10.setName("txtDtDtLastUpdate");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setValue( txtDtLastUpdate );
          _jspx_th_impact_validateInput_10.setSize("14");
          _jspx_th_impact_validateInput_10.setMaxLength("14");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n              <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Maltreatment Finding");
          _jspx_th_impact_validateSelect_3.setName("selSzCdCpsInvstDtlOvrllDisptn");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setCodesTable( CodesTables.CDISPSTN );
          _jspx_th_impact_validateSelect_3.setValue( selCdCpsInvstDtlOvrllDisptn );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n         </tr>\r\n   </table>\r\n   </td>\r\n   </tr>\r\n   <tr>\r\n   <td>\r\n   <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n              <tr>\r\n            <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setLabel("Open Cases");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setName("selRbOpenClose");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setValue("Open");
          _jspx_th_impact_validateInput_11.setChecked( "Open".equals(selRbOpenClose) ? "true" : "false" );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n               ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setLabel("Closed Cases");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_12.setName("selRbOpenClose");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setValue("Closed");
          _jspx_th_impact_validateInput_12.setChecked( "Closed".equals(selRbOpenClose) ? "true" : "false" );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n      </tr>\r\n  </table>\r\n  </td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n");
 if( !bSearchButtonHide ){
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmCaseSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/CaseSearch/searchCase");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
} else{
          out.write("\r\n      &nbsp;\r\n    ");
}
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
 /*  Always include this hidden field in your form */ 
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
 if ( informationalMessage != null ) { 
      out.write("\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n  displayInfoMsgs( '");
      out.print( informationalMessage );
      out.write("' );\r\n</script>\r\n");
 } 
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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
