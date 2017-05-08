package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimsSearchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimsSearchSO;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.financials.TCMClaimsSearchConversation;

public final class TCMClaimsSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  03/26/09  Van Vo            MR-026 STGAP00013024: add Non Re-billable checkbox and enable it for denied and rejected
//**                              claim and to user in Medicaid Billing unit. 
//**                              


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

      BaseSessionStateManager state = TCMClaimsSearchConversation.getSessionStateManager(request);
      String pageMode = PageModeConstants.EDIT;
      int tabIndex = 1;
      String idStaff = ContextHelper.getStringSafe(request, "txtIdStaff");
      String idClient = ContextHelper.getStringSafe(request, "txtIdClient");
      String county = ContextHelper.getStringSafe(request, "selCdCounty");
      String unit = ContextHelper.getStringSafe(request, "txtUnit");
      String month = ContextHelper.getStringSafe(request, "txtMonth");
      String year = ContextHelper.getStringSafe(request, "txtYear");
      String status = ContextHelper.getStringSafe(request, "selStatus");
      
      List countyOptions = (List) state.getAttribute(TCMClaimsSearchConversation.COUNTY_OPTIONS_NAME, request);
      if(countyOptions == null) {
        //-- this should never happen
        countyOptions = new ArrayList();
      }

      TCMClaimsSearchSI searchCriteria = (TCMClaimsSearchSI) state.getAttribute(TCMClaimsSearchConversation.SEARCH_CRITERIA_NAME, request);
      if(searchCriteria != null) {
        idStaff = FormattingHelper.formatInt(searchCriteria.getUlIdStaff());
        idClient = FormattingHelper.formatInt(searchCriteria.getIdClient());
        county = FormattingHelper.formatString(searchCriteria.getSzCdCounty());
        unit = FormattingHelper.formatString(searchCriteria.getSzUnit());
        month = FormattingHelper.formatInt(searchCriteria.getMonth());
        year = FormattingHelper.formatInt(searchCriteria.getUlYear());
        status = FormattingHelper.formatString(searchCriteria.getSzCdStatus());
      }


      out.write("\r\n    ");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n    ");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmTCMClaimsSearch");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/TCMClaimsSearch/displayTCMClaims");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.TCMClaimsSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n      <br>\r\n      <input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\" />\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n        <tr>\r\n          <th colspan=\"8\">TCM Claim Search</th>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setLabel("Staff ID");
          _jspx_th_impact_validateInput_0.setConstraint("ID");
          _jspx_th_impact_validateInput_0.setName("txtIdStaff");
          _jspx_th_impact_validateInput_0.setValue( idStaff );
          _jspx_th_impact_validateInput_0.setSize("10");
          _jspx_th_impact_validateInput_0.setMaxLength("10");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td>\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setLabel("Client ID");
          _jspx_th_impact_validateInput_1.setName("txtIdClient");
          _jspx_th_impact_validateInput_1.setValue( idClient );
          _jspx_th_impact_validateInput_1.setConstraint("ID");
          _jspx_th_impact_validateInput_1.setSize("10");
          _jspx_th_impact_validateInput_1.setMaxLength("10");
          _jspx_th_impact_validateInput_1.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td>\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setLabel("Month");
          _jspx_th_impact_validateInput_2.setConstraint("MonthNumber");
          _jspx_th_impact_validateInput_2.setName("txtMonth");
          _jspx_th_impact_validateInput_2.setValue( month );
          _jspx_th_impact_validateInput_2.setSize("2");
          _jspx_th_impact_validateInput_2.setMaxLength("2");
          _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td>\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setLabel("Year");
          _jspx_th_impact_validateInput_3.setConstraint("Year");
          _jspx_th_impact_validateInput_3.setName("txtYear");
          _jspx_th_impact_validateInput_3.setValue( year );
          _jspx_th_impact_validateInput_3.setSize("4");
          _jspx_th_impact_validateInput_3.setMaxLength("4");
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("County");
          _jspx_th_impact_validateSelect_0.setName("selCdCounty");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_0.setOptions( countyOptions );
          _jspx_th_impact_validateSelect_0.setValue( county );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td>\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Unit");
          _jspx_th_impact_validateInput_4.setConstraint("AlphaNumeric2Unit");
          _jspx_th_impact_validateInput_4.setName("txtUnit");
          _jspx_th_impact_validateInput_4.setValue( unit );
          _jspx_th_impact_validateInput_4.setSize("2");
          _jspx_th_impact_validateInput_4.setMaxLength("2");
          _jspx_th_impact_validateInput_4.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td>\r\n            ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Status");
          _jspx_th_impact_validateSelect_1.setName("selStatus");
          _jspx_th_impact_validateSelect_1.setColspan("3");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable("CTCMSTAT");
          _jspx_th_impact_validateSelect_1.setValue( status );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n      <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n        <tr>\r\n          <td>\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmTCMClaimsSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/TCMClaimsSearch/searchTCMClaims");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    ");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n    <br>\r\n    ");

      List<TCMClaimsSearchSO> list1 = (List<TCMClaimsSearchSO>) state.getAttribute(TCMClaimsSearchConversation.SEARCH_RESULTS_NAME, request);
      if (list1 != null) {
        boolean resubmitEnabled = UserProfileHelper.getUserProfile(request).hasRight(UserProfile.SEC_RESUBMIT_TCM_CLAIMS);
        boolean atLeastOneCheckbox = false;
    
      out.write("\r\n\r\n    ");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmTCMClaimsSearchResults");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/financials/TCMClaimsSearch/searchTCMClaims");
      _jspx_th_impact_validateForm_1.setPageMode( pageMode );
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n      ");
          if (_jspx_meth_impact_validateErrors_1(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      <div class=\"alignRight\">\r\n        <div class=\"formInstruct\">\r\n          Scroll for more information -->\r\n        </div>\r\n      </div>\r\n      <div id=\"horizontalScrollResults\" style=\"width:764px; height:250px; overflow:auto\" class=\"tableBorderList\">\r\n      <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <td class=\"tableBG\">\r\n            <table width=\"1000\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n              <tr>\r\n                <th class=\"thList\">Staff ID</th>\r\n                <th class=\"thList\">Stage ID</th>\r\n                <th class=\"thList\">Client Name</th>\r\n                <th class=\"thList\">Medicaid #</th>\r\n                <th class=\"thList\">Status</th>\r\n                <th class=\"thList\">Denial Reason</th>\r\n                <th class=\"thList\"><div align=\"center\">Resubmit</div></th>\r\n                <th class=\"thList\"><div align=\"center\">Non Re-billable</div></th>\r\n                <th class=\"thListRight\">Status Date</th>\r\n                <th class=\"thListRight\">Service Date</th>\r\n");
          out.write("                <th class=\"thListRight\">TCN Number</th>\r\n              </tr>\r\n              ");
int loopCount = 0;
        TCMClaimsSearchSO tCMClaimsSearchRow = null;
        Iterator<TCMClaimsSearchSO> iterator = list1.iterator();

        if (list1.size() == 0) {

          
          out.write("\r\n              <tr class=\"odd\">\r\n                <td colspan=\"10\">\r\n                  ");
          out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
          out.write("\r\n                </td>\r\n              </tr>\r\n              ");
} else {
          while (iterator.hasNext()) {
            tCMClaimsSearchRow = (TCMClaimsSearchSO) iterator.next();
                  String statusCode = tCMClaimsSearchRow.getSzCdStatus();
                  String dReasonCode = tCMClaimsSearchRow.getSzCdDenialReason();
                  String resubmitName = "cbxResubmit_"+loopCount;
                  String noRebillName = "cbxNoRebill_"+loopCount;
            
          out.write("\r\n              <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\" valign=\"top\">\r\n                <td>\r\n                  ");
          out.print(FormattingHelper.formatInt(tCMClaimsSearchRow.getUlIdStaff()));
          out.write("\r\n                </td>\r\n                <td>\r\n                  ");
          out.print(FormattingHelper.formatInt(tCMClaimsSearchRow.getUlIdStage()));
          out.write("\r\n                </td>\r\n                <td>\r\n                  ");
          out.print(FormattingHelper.formatString(tCMClaimsSearchRow.getSzNmClient()));
          out.write("\r\n                </td>\r\n                <td>\r\n                  ");
          out.print(FormattingHelper.formatString(tCMClaimsSearchRow.getSzNbrMedicaid()));
          out.write("\r\n                </td>\r\n                <td>\r\n                  ");
          out.print(Lookup.simpleDecodeSafe(TCMClaimsSearchConversation.STATUS_CODES_TABLES, statusCode));
          out.write("\r\n                </td>\r\n                <td>\r\n                  ");
          out.write("\r\n                  ");
          out.print( FormattingHelper.formatString(dReasonCode) );
          out.write("\r\n                </td>\r\n                <td align=\"center\">\r\n                  ");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_if_0.setTest( TCMClaimsSearchConversation.RESUBMIT_STATUS_LIST.contains(statusCode) );
          int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
          if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n                    ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
              int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
              if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                      ");
 atLeastOneCheckbox = true; 
                  out.write("\r\n                      ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_0);
                  _jspx_th_impact_validateInput_6.setType("checkbox");
                  _jspx_th_impact_validateInput_6.setDisabled( String.valueOf(!resubmitEnabled) );
                  _jspx_th_impact_validateInput_6.setValue( String.valueOf(loopCount) );
                  _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_6.setName( resubmitName );
                  int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
                  if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                    ");
                  int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              if (_jspx_meth_impact_else_0(_jspx_th_impact_if_0, _jspx_page_context))
                return;
              out.write("\r\n                  ");
              int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n                <td align=\"center\">\r\n                  ");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_if_1.setTest( TCMClaimsSearchConversation.NO_REBILL_STATUS_LIST.contains(statusCode) );
          int _jspx_eval_impact_if_1 = _jspx_th_impact_if_1.doStartTag();
          if (_jspx_eval_impact_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n                    ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_1);
              int _jspx_eval_impact_then_1 = _jspx_th_impact_then_1.doStartTag();
              if (_jspx_eval_impact_then_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n                      ");
 atLeastOneCheckbox = true; 
                  out.write("\r\n                      ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_then_1);
                  _jspx_th_impact_validateInput_7.setType("checkbox");
                  _jspx_th_impact_validateInput_7.setDisabled( String.valueOf(!resubmitEnabled) );
                  _jspx_th_impact_validateInput_7.setValue( String.valueOf(loopCount) );
                  _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
                  _jspx_th_impact_validateInput_7.setName( noRebillName );
                  int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
                  if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                    ");
                  int evalDoAfterBody = _jspx_th_impact_then_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              if (_jspx_meth_impact_else_1(_jspx_th_impact_if_1, _jspx_page_context))
                return;
              out.write("\r\n                  ");
              int evalDoAfterBody = _jspx_th_impact_if_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n                <td class=\"alignRight\">\r\n                  ");
          out.print(FormattingHelper.formatDate(tCMClaimsSearchRow.getDtStatusDate()));
          out.write("\r\n                </td>\r\n                <td class=\"alignRight\">\r\n                  ");
          out.print(FormattingHelper.formatDate(tCMClaimsSearchRow.getDtServiceDate()));
          out.write("\r\n                </td>\r\n                <td class=\"alignRight\">\r\n                  ");
          out.print(FormattingHelper.formatString(tCMClaimsSearchRow.getUlTCNNumber()));
          out.write("\r\n                </td>\r\n              </tr>\r\n              ");
loopCount++;
          } // end while
        }

      
          out.write("\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n      </div>\r\n      \r\n      ");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ifThen_0.setTest( resubmitEnabled && atLeastOneCheckbox );
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"><tr><td>\r\n        <div class=\"alignRight\">\r\n          ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_ButtonTag_1.setName("btnSubmit");
              _jspx_th_impact_ButtonTag_1.setForm("frmTCMClaimsSearchResults");
              _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_ButtonTag_1.setAction("/financials/TCMClaimsSearch/resubmitTCMClaims");
              _jspx_th_impact_ButtonTag_1.setImg("btnSubmit");
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("&nbsp;\r\n        </div>\r\n        </td></tr></table>\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n    ");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n    ");

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

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    _jspx_th_impact_validateErrors_0.setFormName("frmTCMClaimsSearch");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateErrors_1.setFormName("frmTCMClaimsSearchResults");
    int _jspx_eval_impact_validateErrors_1 = _jspx_th_impact_validateErrors_1.doStartTag();
    if (_jspx_th_impact_validateErrors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_else_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:else
    gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
    _jspx_th_impact_else_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_else_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
    int _jspx_eval_impact_else_0 = _jspx_th_impact_else_0.doStartTag();
    if (_jspx_eval_impact_else_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("&nbsp;");
        int evalDoAfterBody = _jspx_th_impact_else_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_else_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_else_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:else
    gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
    _jspx_th_impact_else_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_else_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_1);
    int _jspx_eval_impact_else_1 = _jspx_th_impact_else_1.doStartTag();
    if (_jspx_eval_impact_else_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("&nbsp;");
        int evalDoAfterBody = _jspx_th_impact_else_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_else_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
