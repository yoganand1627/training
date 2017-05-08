package org.apache.jsp.grnds_002ddocs.fad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD12SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public final class FAHomeHistoryList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

                                                                       BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      CFAD12SO cfad12so = (CFAD12SO) state.getAttribute("CFAD12SO", request);

      ROWCFAD12SOG00_ARRAY rowArray = cfad12so.getROWCFAD12SOG00_ARRAY();

      //Iterator historyListIterator= rowArray.iterateROWCFAD12SOG00();

      Enumeration historyEnumeration1 = rowArray.enumerateROWCFAD12SOG00();

      String pageMode = PageModeConstants.VIEW;

      UserProfile user = UserProfileHelper.getUserProfile(request);
      int userID = 0;
      if (user != null) {
        userID = user.getUserID();
      }
      boolean hasAdminRights = false;
      if (user.hasRight(UserProfile.SEC_ADMIN_REVIEW)) {
        hasAdminRights = true;
      } else {
        hasAdminRights = false;
      }

      int loopCount = 0;
      int tabIndex = 1;

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction launchDetail( index, id )\r\n{\r\n  frmHomeHistoryList.arrayIndex.value = index;\r\n  document.frmHomeHistoryList.selected.value = '';\r\n  document.frmHomeHistoryList.ulIdResourceHistory.value = id;\r\n  disableValidation( 'frmHomeHistoryList' );\r\n  submitValidateForm('frmHomeHistoryList', '/fad/FAHomeHistory/displayHomeHistoryDetail');\r\n}\r\n\r\nfunction setDeleteParms( resourceHistoryID )\r\n{\r\n  document.frmHomeHistoryList.selected.value = 'true';\r\n  document.frmHomeHistoryList.ulIdResourceHistory.value = resourceHistoryID;\r\n}\r\n\r\nfunction checkSelectedStatus()\r\n{\r\n  if (!(document.frmHomeHistoryList.selected.value == 'true'))\r\n  {\r\n    alert ('");
      out.print(MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION"));
      out.write("');\r\n    return false;\r\n  } else {\r\n    document.frmHomeHistoryList.FormValidateCancel = 'true';\r\n    return true;\r\n  }\r\n}\r\n\r\nfunction deleteRow()\r\n{\r\n  if ( checkSelectedStatus() )\r\n  {\r\n  bRetValue = confirm('");
      out.print(MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE"));
      out.write("')\r\n  return bRetValue;\r\n  } else\r\n    return false;\r\n}\r\n\r\n</script>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmHomeHistoryList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fad/FAHomeHistory/displayHomeHistoryDetail");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\r\n\t");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/fad/FAHomeHistory/displayHomeHistoryList");
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<div class=\"alignRight\">\r\n\t\t\t<div class=\"formInstruct\">\r\n\t\t\t\tScroll for more information -->\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\t\tclass=\"tableborder\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"tableBG\">\r\n\t\t\t\t\t<div id=\"horizontalScrollResults\"\r\n\t\t\t\t\t\tstyle=\"height:335px; width:765px; overflow:auto\"\r\n\t\t\t\t\t\tclass=\"tableborderList\">\r\n\t\t\t\t\t\t<table width=\"3000\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tEffective Date\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tEnd Date\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tCategory\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tStatus\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<!-- <th class=\"thList\">Foster Type</th> -->\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tApproval Begin Date\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tApproval End Date\r\n\t\t\t\t\t\t\t\t</th>\r\n                                <th class=\"thList\">\r\n                                    IV-E<br/>Reimbursable\r\n");
              out.write("                                </th>\r\n                                <th class=\"thList\">\r\n                                    Reimbursable<br/>Effective Date\r\n                                </th>\r\n                                <th class=\"thList\">\r\n                                    Reimbursable<br/>End Date\r\n                                </th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tAD Exchg\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tHome Type\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tCapacity\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tM Min Year\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tM Max Year\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tF Min Year\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tF Max Year\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<!-- <th class=\"thList\">Closure Reason</th>  -->\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tStatus Reason\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tRecommend Reopening\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n");
              out.write("\t\t\t\t\t\t\t\t\tVol/Invol Closure\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tRace and Ethnicity\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tLanguage\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tReligion\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<!-- <th class=\"thList\">Annual Income</th> -->\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tMarital Status\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tMarriage Date\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<!-- Removed from R2 release due to complexity. The values of this field are stored in HOME_APPLICANT_CBX table. -->\r\n\t\t\t\t\t\t\t\t<!-- <th class=\"thList\">Inquiry Source</th> -->\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tRespite\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<!-- <th class=\"thList\">Non-FPS Home</th> ");
 /* SIR 22492 PRS --> FPS */ 
              out.write(" -->\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tNon-DFCS Home\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<!-- <th class=\"thList\">Certify Entity</th> ");
 /* SIR 23327 */ 
              out.write(" -->\r\n\t\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\t\tNon-DFCS Certify Entity\r\n\t\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t\t<!-- <th class=\"thList\">Ind Study</th> -->\r\n\t\t\t\t\t\t\t\t<!-- <th class=\"thList\">Inhome Care</th> -->\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t");

							      ROWCFAD12SOG00 homeHistoryRow = null;
							      if (!historyEnumeration1.hasMoreElements()) {
							
              out.write("\r\n\t\t\t\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t\t\t\t<td colspan=\"7\">\r\n\t\t\t\t\t\t\t\t\t<a href=\"#\" id=\"nameHistoryItem_0\">");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n\t\t\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t");

							        } else {
							        while (historyEnumeration1.hasMoreElements()) {
							          homeHistoryRow = (ROWCFAD12SOG00) historyEnumeration1.nextElement();
							          double d1 = homeHistoryRow.getUlIdResourceHistory();
							          Double d = d1;
							          int intResourceHistoryID = d.intValue();
							          String onClickString = "setDeleteParms( '" + intResourceHistoryID + "' )";
							
              out.write("\r\n\t\t\t\t\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount + 1));
              out.write("\">\r\n\t\t\t\t\t\t\t\t");

								if (loopCount == 0) {
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								} else {
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");

									if (pageMode.equals(PageModeConstants.MODIFY) && homeHistoryRow.getDtDtRshsEnd() != null) {
									
              out.write("\r\n\t\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_3.setValue("");
              _jspx_th_impact_validateInput_3.setOnClick(onClickString);
              _jspx_th_impact_validateInput_3.setType("radio");
              _jspx_th_impact_validateInput_3.setName("rbItemSelect");
              _jspx_th_impact_validateInput_3.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
              if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t\t");

									}
									
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								}
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t<!-- hyperlink for effective date is removed in R2 release -->\r\n\t\t\t\t\t\t\t\t\t<!-- ");
 //if ( pageMode.equals( PageModeConstants.MODIFY ) ) {
              out.write("\r\n <a href=\"javascript:launchDetail(");
              out.print(loopCount);
              out.write(' ');
              out.write(',');
              out.write(' ');
              out.print(intResourceHistoryID);
              out.write(')');
              out.write('"');
              out.write('>');
              out.print(FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsEffective()));
              out.write("</a>\r\n  ");
//} else {
              out.write("\r\n  -->\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsEffective()));
              out.write("\r\n\t\t\t\t\t\t\t\t\t<!-- ");
//}
              out.write(" -->\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsEnd()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CFACATEG, homeHistoryRow.getSzCdRshsCategory()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, homeHistoryRow.getSzCdRshsFaHomeStatus()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t\t<!--  Added for R2 release, Start-->\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsLicBegin()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsLicEnd()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n                                <td>\r\n                                    ");
              out.print( homeHistoryRow.getBIndHomeIveReimbursable() != null ? homeHistoryRow.getBIndHomeIveReimbursable() : "&nbsp;" );
              out.write("\r\n                                </td>\r\n                                <td>\r\n                                    ");
              out.print(FormattingHelper.formatDate(homeHistoryRow.getDtDtReimbursableEffective()));
              out.write("\r\n                                </td>\r\n                                <td>\r\n                                    ");
              out.print(FormattingHelper.formatDate(homeHistoryRow.getDtDtReimbursableEnd()));
              out.write("\r\n                                </td>\r\n\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CADEXCHG, homeHistoryRow.getCCdRshsExchnageStat()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<!--  Added for R2 release, End -->\r\n\r\n\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");

									          String fosterTypeDecode = "";
									          String tempString = "";

									          if (homeHistoryRow.getCCdRshsFaHomeType1() != null && !"".equals(homeHistoryRow.getCCdRshsFaHomeType1())) {
									            tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType1());
									            fosterTypeDecode = fosterTypeDecode + "  " + tempString;

									            if (homeHistoryRow.getCCdRshsFaHomeType2() != null && !"".equals(homeHistoryRow.getCCdRshsFaHomeType2())) {
									              tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType2());
									              fosterTypeDecode = fosterTypeDecode + ",  " + tempString;

									              if (homeHistoryRow.getCCdRshsFaHomeType3() != null && !"".equals(homeHistoryRow.getCCdRshsFaHomeType3())) {
									                tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType3());
									                fosterTypeDecode = fosterTypeDecode + ",  " + tempString;
									              }
									              if (homeHistoryRow.getCCdRshsFaHomeType4() != null && !"".equals(homeHistoryRow.getCCdRshsFaHomeType4())) {
									                tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType4());
									                fosterTypeDecode = fosterTypeDecode + ",  " + tempString;

									                if (homeHistoryRow.getCCdRshsFaHomeType5() != null
									                    && !"".equals(homeHistoryRow.getCCdRshsFaHomeType5())) {
									                  tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType5());
									                  fosterTypeDecode = fosterTypeDecode + ",  " + tempString;

									                  if (homeHistoryRow.getCCdRshsFaHomeType6() != null
									                      && !"".equals(homeHistoryRow.getCCdRshsFaHomeType6())) {
									                    tempString = Lookup.simpleDecodeSafe(CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType6());
									                    fosterTypeDecode = fosterTypeDecode + ",  " + tempString;

									                    //FaHomeType7 is not used in R2 Release.

									                    // if ( homeHistoryRow.getCCdRshsFaHomeType7() != null && !"".equals(homeHistoryRow.getCCdRshsFaHomeType7()) )
									                    // {
									                    //   tempString = Lookup.simpleDecodeSafe( CodesTables.CFAHMTYP, homeHistoryRow.getCCdRshsFaHomeType7() );
									                    //   fosterTypeDecode = fosterTypeDecode + ",  " + tempString;
									                    // }
									                  }
									                }
									              }
									            }
									          }
									
              out.write("\r\n\t\t\t\t\t\t\t\t\t");
              out.print(fosterTypeDecode);
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(homeHistoryRow.getUNbrRshsFacilCapacity());
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(homeHistoryRow.getUNbrRshsAMaAgeMin() / 12);
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(homeHistoryRow.getUNbrRshsAMaAgeMax() / 12);
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(homeHistoryRow.getUNbrRshsAFeAgeMin() / 12);
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(homeHistoryRow.getUNbrRshsAFeAgeMax() / 12);
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CFACLOSE, homeHistoryRow.getSzCdRshsClosureRsn()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CFARCMND, homeHistoryRow.getSzCdRshsRecmndReopen()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CFACLSTP, homeHistoryRow.getSzCdRshsInvolClosure()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CETHNIC, homeHistoryRow.getSzCdRshsEthnicity()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CLANG, homeHistoryRow.getSzCdRshsLanguage()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CRELIGNS, homeHistoryRow.getSzCdRshsReligion()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<!-- Removed in R2 -->\r\n\t\t\t\t\t\t\t\t<!-- <td>");
              out.print(FormattingHelper.formatMoney(homeHistoryRow.getDNbrRshsAnnualIncome()));
              out.write("\r\n </td> -->\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CFAMSTRC, homeHistoryRow.getSzCdRshsMaritalStatus()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDate(homeHistoryRow.getDtDtRshsMarriage()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<!-- Removed from R2 release. The HOME_APPLICANT_CBX table is used to store the values of Source Inquiry. -->\r\n\t\t\t\t\t\t\t\t<!-- <td>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CFASRCIN, homeHistoryRow.getSzCdRshsSourceInquiry()));
              out.write("\r\n </td> -->\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CFARSPIT, homeHistoryRow.getSzCdRshsRespite()));
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								          String nonDFCSHome = "";
								          if (ArchitectureConstants.Y.equals(homeHistoryRow.getCIndRshsNonDFCSHome())) {
								            nonDFCSHome = ArchitectureConstants.YES;
								          } else if (ArchitectureConstants.N.equals(homeHistoryRow.getCIndRshsNonDFCSHome())) {
								            nonDFCSHome = ArchitectureConstants.NO;

								          }
								
              out.write("\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(nonDFCSHome);
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t");

								// SIR#23327. added CertifyEntity
								
              out.write("\r\n\t\t\t\t\t\t\t\t<!-- removing the codes value as this field is textbox now -->\r\n\t\t\t\t\t\t\t\t<!-- <td>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CERTENT, homeHistoryRow.getSzTxtNdfcsCertEntity()));
              out.write("  </td>-->\r\n\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t");
              out.print(homeHistoryRow.getSzTxtNdfcsCertEntity() != null ? homeHistoryRow.getSzTxtNdfcsCertEntity()
                                                                         : "");
              out.write("\r\n\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t<!-- <td>");
              out.print(homeHistoryRow.getCIndCurrHomeStudyExists());
              out.write("\r\n </td> -->\r\n\t\t\t\t\t\t\t\t<!-- <td>");
              out.print(homeHistoryRow.getCIndRshsCareProv());
              out.write("\r\n </td> -->\r\n\r\n\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t");

							        loopCount++;
							        } //end while
							      } //end else
							
              out.write("\r\n\r\n\t\t\t\t\t\t</table>\r\n\t\t\t\t\t</div>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("arrayIndex");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("selected");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("ulIdResourceHistory");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
