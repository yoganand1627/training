package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.LegacyApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.web.fce.LegacyApplicationConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class LegacyApplication_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Legacy Application Information
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 03/20/03
//*
//*  Description:
//*  This page will display for children who are currently in Foster Care and
//*  are not currently eligible for Title IV-E when IMPACT rolls out.  The
//*  purpose of this page is to capture the reasons the child is not eligible
//*  from the most recent application when the child comes up for Foster Care
//*  Review.
/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Added description to Flowerbox comments.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int tabIndex = 1;
  String pageMode = PageMode.getPageMode(request);

  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  LegacyApplicationDB legacyDB = (LegacyApplicationDB)
    request.getAttribute(LegacyApplicationConversation.LEGACYDB);

      out.write("\r\n<script type=\"text/javascript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmLegacyApplication");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fce/LegacyApplication/saveLegacyApplication");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fce.LegacyApplicationCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n<!-- Hidden Fields -->\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("idFceApplication");
          _jspx_th_impact_validateInput_0.setValue( legacyDB.getIdFceApplicationString() );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("idFceEligibility");
          _jspx_th_impact_validateInput_1.setValue( legacyDB.getIdFceEligibilityString() );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("idStage");
          _jspx_th_impact_validateInput_2.setValue( legacyDB.getIdStageString() );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("idEvent");
          _jspx_th_impact_validateInput_3.setValue( legacyDB.getIdEventString() );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("idLastUpdatePerson");
          _jspx_th_impact_validateInput_4.setValue( "" + LegacyApplicationConversation.getUserID(request) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("fceEligibilityDtLastUpdateTime");
          _jspx_th_impact_validateInput_5.setValue( ""+ legacyDB.getFceEligibilityDtLastUpdateTime() );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<!--- Begin Detail Table --->\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"2\">From the most recent application:</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\" class=\"formInstruct\" >This child is currently NOT Title\r\nIV-E eligible and there is no IMPACT Foster Care Assistance Application\r\ninformation available for this child.  Please select the reason(s) why the\r\nchild was NOT IV-E eligible on his or her most recent Foster Care Assistance\r\napplication.\r\n      <br><br>\r\n    </td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setName("indChildUnder18");
          _jspx_th_impact_validateInput_6.setChecked( "" + Boolean.FALSE.equals(legacyDB.getIndChildUnder18Object()) );
          _jspx_th_impact_validateInput_6.setValue("false");
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>The child was 18 years or older.</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setName("indChildQualifiedCitizen");
          _jspx_th_impact_validateInput_7.setChecked( "" + Boolean.FALSE.equals(legacyDB.getIndChildQualifiedCitizenObject()) );
          _jspx_th_impact_validateInput_7.setValue("false");
          _jspx_th_impact_validateInput_7.setType("checkbox");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>The child's citizenship/alien status was Undetermined Status.</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setName("indParentalDeprivation");
          _jspx_th_impact_validateInput_8.setChecked( "" + Boolean.FALSE.equals(legacyDB.getIndParentalDeprivationObject()) );
          _jspx_th_impact_validateInput_8.setValue("false");
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>Parental Deprivation did NOT exist in the Home of Removal.</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setName("indChildLivingPrnt6Mnths");
          _jspx_th_impact_validateInput_9.setChecked( "" + Boolean.FALSE.equals(legacyDB.getIndChildLivingPrnt6MnthsObject()) );
          _jspx_th_impact_validateInput_9.setValue("false");
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>The child did not live with a Parent(s) or a Specified Relative(s) at any time during the 6\r\n        months prior to the month the court proceedings to remove the child were initiated.</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setName("indHomeIncomeAfdcElgblty");
          _jspx_th_impact_validateInput_10.setChecked( "" + Boolean.FALSE.equals(legacyDB.getIndHomeIncomeAfdcElgbltyObject()) );
          _jspx_th_impact_validateInput_10.setValue("false");
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>The certified group's income exceeded the allowable AFDC income limit.</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n<!-- see ApplicationReasonsNotEligible -->\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setName("indEquity");
          _jspx_th_impact_validateInput_11.setChecked( "" + Boolean.TRUE.equals(legacyDB.getIndEquityObject()) );
          _jspx_th_impact_validateInput_11.setValue("true");
          _jspx_th_impact_validateInput_11.setType("checkbox");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>The certified group's resources exceeded $10,000.</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setName("indRemovalChildOrdered");
          _jspx_th_impact_validateInput_12.setChecked( "" + Boolean.FALSE.equals(legacyDB.getIndRemovalChildOrderedObject()) );
          _jspx_th_impact_validateInput_12.setValue("false");
          _jspx_th_impact_validateInput_12.setType("checkbox");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>The first order ordering the child's removal from the home did NOT contain the judicial\r\n        determination that removal was \"In the Child's Best Interest\" or that \"Remaining in the Home\r\n        was Contrary to the Welfare of the Child\".</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setName("indRsnblEffortPrvtRemoval");
          _jspx_th_impact_validateInput_13.setChecked( "" + Boolean.FALSE.equals(legacyDB.getIndRsnblEffortPrvtRemovalObject()) );
          _jspx_th_impact_validateInput_13.setValue("false");
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>There was not a judicial determination that \"Reasonable Efforts were made to Prevent Removal\".</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setName("indPrsManagingCvs");
          _jspx_th_impact_validateInput_14.setChecked( "" + Boolean.FALSE.equals(legacyDB.getIndPrsManagingCvsObject()) );
          _jspx_th_impact_validateInput_14.setValue("false");
          _jspx_th_impact_validateInput_14.setType("checkbox");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>There was NOT a court order giving FPS responsibility for the child's placement and care,\r\n        or managing conservatorship of the child.</td> \r\n  </tr>\r\n</table>\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnContinue");
          _jspx_th_impact_ButtonTag_0.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_0.setForm("frmLegacyApplication");
          _jspx_th_impact_ButtonTag_0.setDisabled( "" + (PageModeConstants.VIEW.equals(pageMode) == false) );
          _jspx_th_impact_ButtonTag_0.setEditableMode( (EditableMode.EDIT | EditableMode.VIEW) );
          _jspx_th_impact_ButtonTag_0.setAction("/fce/LegacyApplication/continueLegacyApplication");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setForm("frmLegacyApplication");
          _jspx_th_impact_ButtonTag_1.setDisabled( "" + PageModeConstants.VIEW.equals(pageMode) );
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setAction("/fce/LegacyApplication/saveLegacyApplication");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
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
