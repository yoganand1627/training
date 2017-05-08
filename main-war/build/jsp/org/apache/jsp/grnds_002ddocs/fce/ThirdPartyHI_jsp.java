package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;

public final class ThirdPartyHI_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//*  JSP Name:     ThirdPartyHI.jsp 
      //*  Created by:   Guatami Rout
      //*  Date Created: 12/18/06
      //*
      //*  Description:
      //*  This page allows a user to enter a Child's Health Insurance Information
      //*  which includes Child Information, Address of the Home of Removal, List of
      //*  Principals, Responsibility for Child Care, Health Insurance, and Most
      //*  Recent Placements.
      //*
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       
       */

      
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
String pageMode = PageMode.getPageMode(request);
      int tabIndex = 1;
      String TRUE = "true";
      ThirdPartyHealthInsuranceDB populateBean = (ThirdPartyHealthInsuranceDB) request
                                                                                      .getAttribute("ThirdPartyHealthInsuranceDB");
      if (populateBean == null) {
        populateBean = new ThirdPartyHealthInsuranceDB();
      }
     
      String healthZip = populateBean.getAddrZip();
      String healthZipSuff = "";
      if (healthZip.length() > 5) {
        healthZipSuff = healthZip.substring(5);
        healthZip = healthZip.substring(0, 5);
      }
      
      String errorMsg = (String)request.getAttribute("Error");
      

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\n\r\nfunction disablePage()\r\n{\r\n  var x = document.frmThirdPartyHealthInsurance;\r\n  \r\n  x.cdType.disabled = true;\r\n  x.nmCompany.disabled = true;\r\n  x.nbrPolicy.disabled = true;\r\n  x.nbrGroup.disabled = true;\r\n  x.addrStLn1.disabled = true;\r\n  x.addrStLn2.disabled = true;\r\n  x.addrCity.disabled = true;\r\n  x.addrState.disabled = true;\r\n  x.addrZip.disabled = true;\r\n  x.addrZipSuff.disabled = true;\r\n  x.nbrPhone.disabled = true;\r\n  x.cdPolicyHldr.disabled = true;\r\n  x.dtBegin.disabled = true;\r\n  x.dtEnd.disabled = true;\r\n  x.nmEmployer.disabled = true;\r\n  x.nmEmployeeNm.disabled = true;\r\n  x.indAuthRelease.disabled = true;\r\n  x.dtAuthReleaseDate.disabled = true;\r\n  x.indAuthAssign.disabled = true;\r\n  x.dtAuthAssignDate.disabled = true;\r\n  x.indChangeCancel[0].disabled = true;\r\n  x.indChangeCancel[1].disabled = true;\r\n  x.dtChangeCancel.disabled = true;\r\n");
      out.write("  for (i = 0; i < x.numberOfPrinciples.value; i++){\r\n    var check = 'cbThirdPartyHealthIns_'; \r\n    var box = eval('document.frmThirdPartyHealthInsurance.'+ check + i);\r\n    box.disabled = true; \r\n  }\r\n}\r\nfunction enablePage()\r\n{\r\n  var x = document.frmThirdPartyHealthInsurance;\r\n  x.cdType.disabled = false;\r\n  x.nmCompany.disabled = false;\r\n  x.nbrPolicy.disabled = false;\r\n  x.nbrGroup.disabled = false;\r\n  x.addrStLn1.disabled = false;\r\n  x.addrStLn2.disabled = false;\r\n  x.addrCity.disabled = false;\r\n  x.addrState.disabled = false;\r\n  x.addrZip.disabled = false;\r\n  x.addrZipSuff.disabled = false;\r\n  x.nbrPhone.disabled = false;\r\n  x.cdPolicyHldr.disabled = false;\r\n  x.dtBegin.disabled = false;\r\n  x.dtEnd.disabled = false;\r\n  x.nmEmployer.disabled = false;\r\n  x.nmEmployeeNm.disabled = false;\r\n  x.indAuthRelease.disabled = false;\r\n  x.dtAuthReleaseDate.disabled = false;\r\n  x.indAuthAssign.disabled = false;\r\n  x.dtAuthAssignDate.disabled = false;\r\n  x.indChangeCancel[0].disabled = false;\r\n  x.indChangeCancel[1].disabled = false;\r\n");
      out.write("  x.dtChangeCancel.disabled = false;\r\n  for (i = 0; i < x.numberOfPrinciples.value; i++){\r\n    var check = 'cbThirdPartyHealthIns_'; \r\n    var box = eval('document.frmThirdPartyHealthInsurance.' + check + i);\r\n    box.disabled = false;\r\n  }\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmThirdPartyHealthInsurance");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fce.ThirdPartyHealthInsuranceCustomValidation");
      _jspx_th_impact_validateForm_0.setAction("/fce/ThirdPartyHealthInsurance/displayThirdPartyHealthInsurance");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("idLastUpdatePerson");
          _jspx_th_impact_validateInput_0.setValue(populateBean.getIdLastUpdatePersonString());
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("idEvent");
          _jspx_th_impact_validateInput_1.setValue(populateBean.getIdEventString());
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("idFceApplication");
          _jspx_th_impact_validateInput_2.setValue(populateBean.getIdFceApplicationString());
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("idFceEligibility");
          _jspx_th_impact_validateInput_3.setValue(populateBean.getIdFceEligibilityString());
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("idPerson");
          _jspx_th_impact_validateInput_4.setValue(populateBean.getIdPersonString());
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("idStage");
          _jspx_th_impact_validateInput_5.setValue(populateBean.getIdStageString());
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("idLastUpdatePerson");
          _jspx_th_impact_validateInput_6.setValue( "" + BasePrsConversation.getUserID(request) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("cdApplication");
          _jspx_th_impact_validateInput_7.setValue(populateBean.getCdApplication());
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=6>\r\n        Child's Health Insurance Coverage\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"6\">\r\n        <table width=\"100%\">\r\n          <tr>\r\n            <td width=\"15%\">\r\n              ");
Boolean indChildCoverage = populateBean.getIndChildCoverageObject();
      boolean yesChecked = false;
      boolean noChecked = false;

      if (indChildCoverage == null) {
        yesChecked = false;
        noChecked = true;
      } else {
        yesChecked = populateBean.getIndChildCoverage();
        noChecked = !populateBean.getIndChildCoverage();
      }
      
      if(TRUE.equals(errorMsg)){
        noChecked = false;
      }
     
          out.write("\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setId("rbHealthInsuranceYes");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setName("indChildCoverage");
          _jspx_th_impact_validateInput_8.setValue("true");
          _jspx_th_impact_validateInput_8.setLabel("Yes");
          _jspx_th_impact_validateInput_8.setChecked(String.valueOf(yesChecked));
          _jspx_th_impact_validateInput_8.setOnClick("enablePage()");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setId("rbHealthInsuranceNo");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setName("indChildCoverage");
          _jspx_th_impact_validateInput_9.setValue("false");
          _jspx_th_impact_validateInput_9.setLabel("No");
          _jspx_th_impact_validateInput_9.setChecked(String.valueOf(noChecked));
          _jspx_th_impact_validateInput_9.setOnClick("disablePage()");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n              Is the child covered by any health insurance other than Medicaid?\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=6>\r\n        If yes, please complete the following section:\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setName("cdType");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable("CINSTYPE");
          _jspx_th_impact_validateSelect_0.setValue( populateBean.getCdType() );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setLabel("Company Name");
          _jspx_th_impact_validateInput_10.setName("nmCompany");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setValue( populateBean.getNmCompany() );
          _jspx_th_impact_validateInput_10.setSize("30");
          _jspx_th_impact_validateInput_10.setMaxLength("50");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setLabel("Policy No.");
          _jspx_th_impact_validateInput_11.setName("nbrPolicy");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setValue( String.valueOf(populateBean.getNbrPolicy()) );
          _jspx_th_impact_validateInput_11.setSize("20");
          _jspx_th_impact_validateInput_11.setMaxLength("20");
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setLabel("Group No.");
          _jspx_th_impact_validateInput_12.setName("nbrGroup");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setValue( String.valueOf(populateBean.getNbrGroup()) );
          _jspx_th_impact_validateInput_12.setSize("20");
          _jspx_th_impact_validateInput_12.setMaxLength("20");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setLabel("Street");
          _jspx_th_impact_validateInput_13.setConstraint("Address");
          _jspx_th_impact_validateInput_13.setName("addrStLn1");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setValue( populateBean.getAddrStLn1() );
          _jspx_th_impact_validateInput_13.setSize("30");
          _jspx_th_impact_validateInput_13.setMaxLength("");
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("text");
          _jspx_th_impact_validateInput_14.setLabel("");
          _jspx_th_impact_validateInput_14.setConstraint("Address");
          _jspx_th_impact_validateInput_14.setName("addrStLn2");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setValue( populateBean.getAddrStLn2() );
          _jspx_th_impact_validateInput_14.setSize("30");
          _jspx_th_impact_validateInput_14.setMaxLength("");
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setLabel("City");
          _jspx_th_impact_validateInput_15.setConstraint("City");
          _jspx_th_impact_validateInput_15.setName("addrCity");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setValue( populateBean.getAddrCity() );
          _jspx_th_impact_validateInput_15.setSize("20");
          _jspx_th_impact_validateInput_15.setMaxLength("");
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("State");
          _jspx_th_impact_validateSelect_1.setName("addrState");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_1.setValue( populateBean.getAddrState() );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("text");
          _jspx_th_impact_validateInput_16.setLabel("Zip");
          _jspx_th_impact_validateInput_16.setConstraint("Zip");
          _jspx_th_impact_validateInput_16.setName("addrZip");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          _jspx_th_impact_validateInput_16.setValue( healthZip );
          _jspx_th_impact_validateInput_16.setSize("5");
          _jspx_th_impact_validateInput_16.setMaxLength("5");
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        -\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setConstraint("ZipSuff");
          _jspx_th_impact_validateInput_17.setName("addrZipSuff");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setValue( healthZipSuff );
          _jspx_th_impact_validateInput_17.setSize("4");
          _jspx_th_impact_validateInput_17.setMaxLength("4");
          _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setLabel("Phone");
          _jspx_th_impact_validateInput_18.setConstraint("Phone");
          _jspx_th_impact_validateInput_18.setName("nbrPhone");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          _jspx_th_impact_validateInput_18.setValue(FormattingHelper.formatPhone(populateBean.getNbrPhone()));
          _jspx_th_impact_validateInput_18.setSize("10");
          _jspx_th_impact_validateInput_18.setMaxLength("");
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");
List principals = populateBean.getPrinciples();
      String numPrinciples = principals.size() + "";
      List personNameList = new ArrayList();
      for (int i = 0; i < principals.size(); i++) {
        FcePersonDB principal = (FcePersonDB) principals.get(i);
        personNameList.add(new Option(String.valueOf(principal.getNmPersonFull()), principal.getNmPersonFull()));
      }
          out.write("\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Policy Holder");
          _jspx_th_impact_validateSelect_2.setName("cdPolicyHldr");
          _jspx_th_impact_validateSelect_2.setOptions(personNameList);
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setValue(populateBean.getCdPolicyHldr());
          _jspx_th_impact_validateSelect_2.setStyle("WIDTH: 180px");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("dtBegin");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setLabel("Begin Date");
          _jspx_th_impact_validateDate_0.setRequired("false");
          _jspx_th_impact_validateDate_0.setValue( populateBean.getDtBeginString() );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("dtEnd");
          _jspx_th_impact_validateDate_1.setDisabled("false");
          _jspx_th_impact_validateDate_1.setLabel("End Date");
          _jspx_th_impact_validateDate_1.setRequired("false");
          _jspx_th_impact_validateDate_1.setValue( populateBean.getDtEndString() );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setColspan("2");
          _jspx_th_impact_validateInput_19.setLabel("Employer's Name");
          _jspx_th_impact_validateInput_19.setName("nmEmployer");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          _jspx_th_impact_validateInput_19.setValue( populateBean.getNmEmployer() );
          _jspx_th_impact_validateInput_19.setSize("30");
          _jspx_th_impact_validateInput_19.setMaxLength("50");
          _jspx_th_impact_validateInput_19.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setColspan("2");
          _jspx_th_impact_validateInput_20.setType("text");
          _jspx_th_impact_validateInput_20.setLabel("Employee's Name");
          _jspx_th_impact_validateInput_20.setName("nmEmployeeNm");
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          _jspx_th_impact_validateInput_20.setValue( populateBean.getNmEmployeeNm() );
          _jspx_th_impact_validateInput_20.setSize("30");
          _jspx_th_impact_validateInput_20.setMaxLength("50");
          _jspx_th_impact_validateInput_20.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"6\">\r\n        Principals Covered by Health Insurance Policy\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"6\">\r\n        <div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n          <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n            <tr>\r\n              <th class=\"thList\">\r\n                Name\r\n              </th>\r\n              <th class=\"thList\">\r\n                Relationship\r\n              </th>\r\n              <th class=\"thList\">\r\n                Date of Birth\r\n              </th>\r\n            </tr>\r\n            ");
principals = populateBean.getPrinciples();
      if (principals == null || principals.size() == 0) {

          out.write("\r\n            <tr class=\"odd\">\r\n              <td colspan=\"3\">\r\n                ");
          out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
          out.write("\r\n              </td>\r\n            </tr>\r\n            ");
} else {

        for (int i = 0; i < principals.size(); i++) {
          String thirdPartyHealthCbxName = "cbThirdPartyHealthIns_" + i;
          String hiddenPersonIdName = "principalPersonId_" + i;
          String hiddenFcePersonIdName = "principalFcePersonId_" + i;
          String hiddenTsLastUpdateName = "principalLastUpdate_" + i;
          String relationName = "cdRelInt_" + i;
          String hiddenRelationName = "hdnRelInt_" + i;
          FcePersonDB principal = (FcePersonDB) principals.get(i);
          String relationDecode = Lookup.simpleDecodeSafe("CRELVICT", principal.getCdRelInt());
          if ("".equals(relationDecode)) {
            relationDecode = Lookup.simpleDecodeSafe("CRELPRN2", principal.getCdRelInt());
          }

          
          out.write("\r\n            <tr class=\"");
          out.print(FormattingHelper.getRowCss( i + 1 ));
          out.write("\" valign=\"top\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName(hiddenPersonIdName);
          _jspx_th_impact_validateInput_21.setValue(principal.getIdPersonString());
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName(hiddenFcePersonIdName);
          _jspx_th_impact_validateInput_22.setValue(principal.getIdFcePersonString());
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("hidden");
          _jspx_th_impact_validateInput_23.setName(hiddenTsLastUpdateName);
          _jspx_th_impact_validateInput_23.setValue(String.valueOf(principal.getDtLastUpdateTime()));
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName(hiddenRelationName);
          _jspx_th_impact_validateInput_24.setValue(principal.getCdRelInt());
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("checkbox");
          _jspx_th_impact_validateInput_25.setChecked( principal.getIndThirdPartyInsuranceString());
          _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_25.setId( thirdPartyHealthCbxName );
          _jspx_th_impact_validateInput_25.setName( thirdPartyHealthCbxName );
          _jspx_th_impact_validateInput_25.setValue( String.valueOf( i ) );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                &nbsp;\r\n                ");
          out.print(principal.getNmPersonFull());
          out.write("\r\n              </td>\r\n              <td>\r\n                ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName(relationName);
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( relationDecode );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n              <td>\r\n                ");
          out.print(principal.getDtBirthString());
          out.write("\r\n              </td>\r\n            </tr>\r\n            ");
} // end while
      }

          out.write("\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"6\">\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n          <tr>\r\n            <th colspan=\"6\">\r\n              Authorization\r\n            </th>\r\n          </tr>\r\n\r\n          <tr>\r\n            <td colspan=\"2\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("checkbox");
          _jspx_th_impact_validateInput_26.setId("indAuthRelease");
          _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_26.setName("indAuthRelease");
          _jspx_th_impact_validateInput_26.setValue("true");
          _jspx_th_impact_validateInput_26.setLabel("I authorize the release of information necessary to recover health insurance benefits to the Department of Community Health. I also certify that the above information is correct.");
          _jspx_th_impact_validateInput_26.setChecked( "" + ArchitectureConstants.TRUE.equals(populateBean.getIndAuthReleaseString()) );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td width=20%>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setName("dtAuthReleaseDate");
          _jspx_th_impact_validateDate_2.setDisabled("false");
          _jspx_th_impact_validateDate_2.setLabel("Date of Authorization");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setValue(populateBean.getDtAuthReleaseDateString());
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n\r\n          <tr>\r\n\r\n            <td colspan=\"2\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("checkbox");
          _jspx_th_impact_validateInput_27.setId("indAuthAssign");
          _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_27.setName("indAuthAssign");
          _jspx_th_impact_validateInput_27.setValue("true");
          _jspx_th_impact_validateInput_27.setLabel("I authorize and assign payment of medical benefits to the Department of Community Health.");
          _jspx_th_impact_validateInput_27.setChecked( "" + ArchitectureConstants.TRUE.equals(populateBean.getIndAuthAssignString()) );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td width=20%>\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setName("dtAuthAssignDate");
          _jspx_th_impact_validateDate_3.setDisabled("false");
          _jspx_th_impact_validateDate_3.setLabel("Date of Authorization");
          _jspx_th_impact_validateDate_3.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_3.setValue(populateBean.getDtAuthAssignDateString());
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      ");
String displayStyle = "";
      if ("A".equals(populateBean.getCdApplication())) {
        displayStyle = "display:none";
      } else {
        displayStyle = "display:block";
      }

      
          out.write("\r\n      <td colspan=\"6\">\r\n        <div id=\"showDateOfChangeSource\" style=\"");
          out.print(displayStyle);
          out.write("\">\r\n          <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n            <tr>\r\n              <th colspan=\"4\">\r\n                Date of Health Insurance Change/Cancellation\r\n              </th>\r\n            </tr>\r\n            <tr>\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setId("indChange");
          _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_28.setName("indChangeCancel");
          _jspx_th_impact_validateInput_28.setValue("true");
          _jspx_th_impact_validateInput_28.setLabel("Change");
          _jspx_th_impact_validateInput_28.setChecked( "" + ArchitectureConstants.TRUE.equals(populateBean.getIndChangeCancelString()) );
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("radio");
          _jspx_th_impact_validateInput_29.setId("indCancel");
          _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_29.setName("indChangeCancel");
          _jspx_th_impact_validateInput_29.setValue("false");
          _jspx_th_impact_validateInput_29.setLabel("Cancellation");
          _jspx_th_impact_validateInput_29.setChecked( "" + ArchitectureConstants.TRUE.equals(populateBean.getIndChangeCancelString()) );
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            </tr>\r\n            <tr>\r\n              <td width=30%>\r\n                ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_4.setName("dtChangeCancel");
          _jspx_th_impact_validateDate_4.setDisabled("false");
          _jspx_th_impact_validateDate_4.setLabel("Effective Date of Change/Cancellation");
          _jspx_th_impact_validateDate_4.setValue(populateBean.getDtChangeCancelString());
          _jspx_th_impact_validateDate_4.setSize("10");
          _jspx_th_impact_validateDate_4.setConstraint("Date");
          _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
          if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n              <td colspan=\"2\">\r\n                &nbsp;\r\n              </td>\r\n            </tr>\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n          <tr>\r\n            <th colspan=\"4\">\r\n              Case Manager Information\r\n            </th>\r\n          </tr>\r\n          <tr>\r\n            <td width=\"20%\">\r\n              ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("nmEmployeePersonFull");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Case Manager's Name");
          _jspx_th_impact_validateDisplayOnlyField_1.setWidth("30%");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(populateBean.getNmEmployeePersonFull());
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td width=\"20%\">\r\n              ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("nbrEmployeePersonPhone");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Case Manager's Phone");
          _jspx_th_impact_validateDisplayOnlyField_2.setWidth("30%");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatPhone(populateBean.getNbrEmployeePersonPhone()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"6\">\r\n        <table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmThirdPartyHealthInsurance");
          _jspx_th_impact_ButtonTag_0.setAction("/fce/ThirdPartyHealthInsurance/saveThirdPartyHealthInsurance");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("hidden");
          _jspx_th_impact_validateInput_30.setName("numberOfPrinciples");
          _jspx_th_impact_validateInput_30.setValue( numPrinciples );
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n  ");
 if (noChecked == true) {
          out.write("\r\n     <script language=\"javascript\">\r\n       disablePage();\r\n     </script>\r\n  ");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmThirdPartyHealthInsurance");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
