package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.resource.ResourceSearchValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ORSResourceDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSComplaintSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAllegationSO;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;

public final class ORSCompliantDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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


  /*
   * JSP Name:     ORSComplaintDetail.jsp
   *
   */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Initialize all display variables for the page
  String rsrcLegalName = "";
  String rsrcFacilityID = "";
  String destinationUrl = "";
  
  int tabIndex = 1;
  int loopCount = 0;
  String rowCss = "altColor";
  
  String ResourceID = GlobalData.getUlIdResourceAsString( request );
  String ResourceName = GlobalData.getSzNmResource(request);
  
  
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  ORSComplaintSO complaint = (ORSComplaintSO) state.getAttribute(ORSResourceDetailConversation.ORS_COMPLIANT_ATTRIBUTE_NAME, request);
  List<ORSAllegationSO> allegationList = (List<ORSAllegationSO>) state.getAttribute(ORSResourceDetailConversation.ORS_ALLEGATION_LIST_ATTRIBUTE_NAME, request);
  
  String pageMode = PageMode.getPageMode(request);

      out.write("\r\n\r\n<script language=\"JavaScript\">\r\n\r\nwindow.attachEvent('onload', myOnLoadFunction );\r\n\r\nfunction myOnLoadFunction() {\r\n  \r\n}\r\n\r\n\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmORSComplaintDetail");
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceORSDetail/displayORSResourceDetail");
      _jspx_th_impact_validateForm_0.setPageMode(PageModeConstants.VIEW);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n\t\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE1\">\r\n\t\r\n\t\t\r\n\t  <tr>\r\n\t        <th colspan=\"4\">ORS Complaint Detail</th>\r\n\t </tr>\r\n        <tr>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtResourceName");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("ORS Resource Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(complaint.getSzResourceName());
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtFacilityID");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("ORS Facility ID");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(complaint.getSzORSFacilityID());
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtIntakeNumber");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Intake Number");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(complaint.getSzNmItake());
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("txtIntakeDate");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Intake Date");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatDate(complaint.getDtIntake()));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t\r\n\t\t<tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("txtType");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Type");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(complaint.getSzType());
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("txtStatus");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Status");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(complaint.getSzStatus());
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\t\t\r\n        <tr>\r\n\t\t\t<td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("txtPriority");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Priority");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(complaint.getSzPriority());
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("txtInvestigatorName");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Investigator Name");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(complaint.getSzInvestigatorName());
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n        \r\n        <tr>\r\n         <td class=\"formLabel\">Narrative:</td>\r\n            <td colspan=\"3\">\r\n              ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtORSCompliantNarrative");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("120");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setMaxLength(4000);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n                 ");
              out.print(complaint.getSzNarrative()!= null?FormattingHelper.formatString(complaint.getSzNarrative()):StringHelper.EMPTY_STRING);
              out.write("\r\n              ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n         </td>\r\n        </tr>\r\n        \r\n\t\t<tr> \r\n\t\t\t<td >");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("txtDateLastUpdated");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Date Last Updated");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(FormattingHelper.formatDate(complaint.getDtLastUpdate()));
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n        </tr>\r\n\r\n\t</table>\r\n\t\r\n\t<br>\r\n\t\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderList\">\r\n\t\t<tr>\r\n  \t\t\t<td class=\"thList\" colspan=\"2\">ORS Complaint Allegations</td>\r\n\t\t<tr>\r\n\t\t");

			if(allegationList != null && allegationList.size() > 0) {
				int loopCounter = 0;
				Iterator<ORSAllegationSO> itrAll = allegationList.iterator();
				while(itrAll.hasNext()){
					ORSAllegationSO allegation = itrAll.next();
					
          out.write("\r\n\t\t\t\t\t\t<tr ");
          out.print( loopCounter++ % 2 == 1 ? "class='even'" : "" );
          out.write(">\r\n\t\t\t\t\t\t\t<td valign=\"top\">\r\n\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t  \t\t\t\t\t\t\t\t<tr>\r\n\t\t    \t\t\t\t\t\t\t<td>\r\n\t\t\t   \t\t\t\t\t\t\t \t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("txtPrimaryType");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Primary Type");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue( allegation.getSzPrimaryType());
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t  \t\t\t\t\t\t\t</td>\r\n\t\t\t  \t\t\t\t\t\t\t<td>\r\n\t\t\t   \t\t\t\t\t\t\t \t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("txtSecondaryType");
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Secondary Type");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue( allegation.getSzSecondaryType());
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t  \t\t\t\t\t\t\t</td>\r\n\t\t  \t\t\t\t\t\t\t</tr>\r\n\t\t  \t\t\t\t\t\t\t<tr>\r\n\t\t    \t\t\t\t\t\t\t<td>\r\n\t\t\t   \t\t\t\t\t\t\t \t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_11.setName("txtFinding");
          _jspx_th_impact_validateDisplayOnlyField_11.setLabel("Finding");
          _jspx_th_impact_validateDisplayOnlyField_11.setValue( allegation.getSzFinding());
          int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t  \t\t\t\t\t\t\t</td>\r\n\t\t  \t\t\t\t\t\t\t</tr>\r\n\t\t  \t\t\t\t\t\t\t<tr>\r\n\t\t\t  \t\t\t\t\t\t\t<td class=\"formLabel\">Restatement of the Complaint:</td>\r\n\t\t\t\t\t\t\t\t        <td colspan=\"3\">\r\n\t\t\t\t\t\t\t\t              ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtRestatement");
          _jspx_th_impact_validateTextArea_1.setRows("4");
          _jspx_th_impact_validateTextArea_1.setCols("120");
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_1.setMaxLength(4000);
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t                 ");
              out.print(allegation.getSzRestatement() != null ? FormattingHelper.formatString(allegation.getSzRestatement()):StringHelper.EMPTY_STRING);
              out.write("\r\n\t\t\t\t\t\t\t\t              ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t         </td>\r\n\t\t  \t\t\t\t\t\t\t</tr>\r\n\t\t  \t\t\t\t\t\t\t<tr>\r\n\t\t\t  \t\t\t\t\t\t\t<td class=\"formLabel\">Narrative:</td>\r\n\t\t\t\t\t\t\t\t        <td colspan=\"3\">\r\n\t\t\t\t\t\t\t\t              ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("txtNarrative");
          _jspx_th_impact_validateTextArea_2.setRows("4");
          _jspx_th_impact_validateTextArea_2.setCols("120");
          _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_2.setMaxLength(4000);
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t                 ");
              out.print(allegation.getSzNarrative()!= null?FormattingHelper.formatString(allegation.getSzNarrative()):StringHelper.EMPTY_STRING);
              out.write("\r\n\t\t\t\t\t\t\t\t              ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t\t         </td>\r\n\t\t  \t\t\t\t\t\t\t</tr>\r\n\t\t  \t\t\t\t\t\t\t<tr>\r\n\t\t    \t\t\t\t\t\t\t<td>\r\n\t\t\t   \t\t\t\t\t\t\t \t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_12.setName("txtDateLastUpdated");
          _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Date Last Updated");
          _jspx_th_impact_validateDisplayOnlyField_12.setValue(FormattingHelper.formatDate(allegation.getDtLastUpdate()));
          int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t  \t\t\t\t\t\t\t</td>\r\n\t\t  \t\t\t\t\t\t\t</tr>\r\n\t\t  \t\t\t\t\t\t</table>\r\n\t\t  \t\t\t\t   </td>\r\n\t\t  \t\t\t\t</tr>\r\n      \t\t\t\t");

				}
			}
		
          out.write("\r\n\t</table>\r\n\t\t\r\n\t<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"destinationUrl\" value=\"");
          out.print(destinationUrl);
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"");
          out.print(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
          out.write("\" value=\"");
          out.print(complaint.getSzORSFacilityID());
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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
    _jspx_th_impact_validateErrors_0.setFormName("frmORSComplaintDetail");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
