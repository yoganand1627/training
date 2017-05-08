package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class CostReimbursementDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Cost Reimbursement Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 01/16/2002
//*
//*  Description:
//*  This JSP is used to maintain a Cost Reimbursement Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/07/03  GRIMSHAN          SIR 7034 -- Fixed opening and closing java brackets


      out.write('\n');
      out.write('\n');
      out.write('\n');

/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */

      out.write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

//Get the output object from the request
BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
ROWCFIN13SOG rowcfin13sog = (ROWCFIN13SOG) request.getAttribute("ROWCFIN13SOG");
String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);


if (rowcfin13sog == null) {
  rowcfin13sog = new ROWCFIN13SOG();
}



      out.write('\n');
 // Start Javascript Section

      out.write("\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\n\n    //  Called onUnload of page to remind user unsaved data will be lost\n     window.onbeforeunload = function ()\n     {\n       IsDirty();\n     }\n\n</script>\n");
 //End Javascript Section

      out.write('\n');
      out.write('\n');

  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;


  //Initialize the variables that will specify the display rules for individual fields


  String pageModePassed = "";
  String overallPageMode = PageModeConstants.EDIT;

   if (request.getAttribute("pageMode") != null )
   {
     pageModePassed = (String) request.getAttribute("pageMode");
     if (pageModePassed.equals(PageModeConstants.MODIFY))
     {
       overallPageMode = PageModeConstants.EDIT;
     }
     else if (pageModePassed.equals(PageModeConstants.NEW))
     {
       overallPageMode = PageModeConstants.NEW;
     }
     else if (pageModePassed.equals(PageModeConstants.VIEW))
     {
       overallPageMode = PageModeConstants.VIEW;
     }
   }


      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCostDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/Invoice/saveCost");
      _jspx_th_impact_validateForm_0.setPageMode( overallPageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.CostCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\n');
          out.write("\n\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnCReqFuncCd");
          _jspx_th_impact_validateInput_0.setValue( cReqFuncCd );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\n');
          out.write(' ');
          out.write(' ');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnUlIdCostReim");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt(rowcfin13sog.getUlIdCostReim()) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\n');
          out.write(' ');
          out.write(' ');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnSzCdCostReimLiType");
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatString(rowcfin13sog.getSzCdCostReimLiType()) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\n');
          out.write(' ');
          out.write(' ');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnCIndCostReimRejItm");
          _jspx_th_impact_validateInput_3.setValue( FormattingHelper.formatString(rowcfin13sog.getCIndCostReimRejItm()) );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\n');
          out.write(' ');
          out.write(' ');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_4.setValue( DateHelper.toISOString(rowcfin13sog.getTsLastUpdate()) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\n');
          out.write(' ');
          out.write(' ');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnIndInvoiceReversal");
          _jspx_th_impact_validateInput_5.setValue( FormattingHelper.formatString(cfin02so.getSzCdInvoAdjustmentRb()) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\n');
 /* Begin Detail */ 
          out.write("\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\n  <tr>\n  <th colspan=\"9\">Sevice Information</th>\n  </tr>\n  <tr>\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Service");
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzCdCostReimService");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(rowcfin13sog.getSzCdCostReimService()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspUsNbrCostReimCsli");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("CSLI");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatInt(rowcfin13sog.getUsNbrCostReimCsli()) );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspUNbrCostReimUnitQty");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Quantity");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatDouble(rowcfin13sog.getUNbrCostReimUnitQty(), 2) );
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n  </tr>\n</table>\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\n  <tr>\n  <th colspan=\"9\">Expenditure Information</th>\n  </tr>\n  <tr>\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setName("txtDAmtCostReimSalary");
          _jspx_th_impact_validateInput_6.setLabel("Salaries");
          _jspx_th_impact_validateInput_6.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_6.setConstraint("Money");
          _jspx_th_impact_validateInput_6.setValue( FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimSalary()) );
          _jspx_th_impact_validateInput_6.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_6.setSize("11");
          _jspx_th_impact_validateInput_6.setMaxLength("11");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setName("txtDAmtCostReimFrgBenft");
          _jspx_th_impact_validateInput_7.setLabel("Benefits");
          _jspx_th_impact_validateInput_7.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_7.setConstraint("Money");
          _jspx_th_impact_validateInput_7.setValue( FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimFrgBenft()) );
          _jspx_th_impact_validateInput_7.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_7.setSize("11");
          _jspx_th_impact_validateInput_7.setMaxLength("11");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n  </tr>\n  <tr>\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setName("txtDAmtCostReimTravel");
          _jspx_th_impact_validateInput_8.setLabel("Travel");
          _jspx_th_impact_validateInput_8.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_8.setConstraint("Money");
          _jspx_th_impact_validateInput_8.setValue( FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimTravel()) );
          _jspx_th_impact_validateInput_8.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_8.setSize("11");
          _jspx_th_impact_validateInput_8.setMaxLength("11");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setName("txtDAmtCostReimSupply");
          _jspx_th_impact_validateInput_9.setLabel("Supplies");
          _jspx_th_impact_validateInput_9.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_9.setConstraint("Money");
          _jspx_th_impact_validateInput_9.setValue( FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimSupply()) );
          _jspx_th_impact_validateInput_9.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_9.setSize("11");
          _jspx_th_impact_validateInput_9.setMaxLength("11");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n  </tr>\n  <tr>\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setName("txtDAmtCostReimEquip");
          _jspx_th_impact_validateInput_10.setLabel("Equipment");
          _jspx_th_impact_validateInput_10.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_10.setConstraint("Money");
          _jspx_th_impact_validateInput_10.setValue( FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimEquip()) );
          _jspx_th_impact_validateInput_10.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_10.setSize("11");
          _jspx_th_impact_validateInput_10.setMaxLength("11");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setName("txtDAmtCostReimDtlOther");
          _jspx_th_impact_validateInput_11.setLabel("Other");
          _jspx_th_impact_validateInput_11.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_11.setConstraint("Money");
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimDtlOther()) );
          _jspx_th_impact_validateInput_11.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_11.setSize("11");
          _jspx_th_impact_validateInput_11.setMaxLength("11");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n  </tr>\n  <tr>\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setName("txtDAmtCostReimAdminAll");
          _jspx_th_impact_validateInput_12.setLabel("Administrative");
          _jspx_th_impact_validateInput_12.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_12.setConstraint("Money");
          _jspx_th_impact_validateInput_12.setValue( FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimAdminAll()) );
          _jspx_th_impact_validateInput_12.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_12.setSize("11");
          _jspx_th_impact_validateInput_12.setMaxLength("11");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("txtDAmtCostReimOffItem");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Offset");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue( FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimOffItem()) );
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\n  </tr>\n  </table>\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\n  <tr>\n    <td class=\"alignRight\">\n         ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmCostDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/Invoice/saveCost");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\n    </td>\n   </tr>\n</table>\n\n\n");
 /*  Always include this hidden field in your form */ 
          out.write("\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write('"');
          out.write('>');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write(' ');
 /* Close Validate Form Custom Tag */ 
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
