package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UnitStaffIdentifier;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class ApprovalRejection_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 * JSP Name:     ApprovalStatus.jsp
 * Created by:   Jenn Casdorph
 * Date Created: 07/14/05
 *
 * Description:
 * The Approval Rejection page will display the details of why the
 * approval was rejected by the supervisor.
**/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String pageMode = PageModeConstants.VIEW;

  // get the user id
  UserProfile user = UserProfileHelper.getUserProfile( request );
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  ROWCCMNI3DO rowccmni3do = (ROWCCMNI3DO)request.getAttribute("rowccmni3do");


      out.write('\r');
      out.write('\n');

//This form is actually just a shortcut.  We want to resuse the code from APproval Status.


      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmApprovalStatus");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/ApprovalStatus/displayApprovalStatus");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"4\">Reasons for Rejection</th>\r\n    </tr>\r\n    <tr>\r\n    <tr>\r\n     <td colspan=\"2\"><b>Rejector:</b>&nbsp;&nbsp;");
          out.print( String.valueOf( rowccmni3do.getSzNMRejector()) );
          out.write("</td>\r\n     <td colspan=\"2\"><b>Date:</b>&nbsp;&nbsp;");
          out.print( FormattingHelper.formatDate( rowccmni3do.getDtDtRejection()) );
          out.write("</td>\r\n    </tr>\r\n\r\n   <!--     ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Rejector");
          _jspx_th_impact_validateDisplayOnlyField_0.setName("rejector");
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( String.valueOf( rowccmni3do.getSzNMRejector()) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Date");
          _jspx_th_impact_validateDisplayOnlyField_1.setName("date");
          _jspx_th_impact_validateDisplayOnlyField_1.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatDate( rowccmni3do.getDtDtRejection()) );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    </tr>\r\n   -->\r\n\r\n    ");

    String apsEffortLabel="Case cannot be closed, the Client Continues to be in a state of abuse, neglect, or exploitation because of a lack of APS effort.";
    
          out.write("\r\n    <tr>\r\n     <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setLabel(apsEffortLabel);
          _jspx_th_impact_validateInput_0.setType("checkbox");
          _jspx_th_impact_validateInput_0.setValue("Y");
          _jspx_th_impact_validateInput_0.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndApsEffort()));
          _jspx_th_impact_validateInput_0.setName("bIndApsEffort");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n\r\n");
if (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))) {
          out.write("\r\n\r\n\r\n    ");

    String careEnteredLabel="CARE does not include all client problems including root causes.";
    
          out.write("\r\n    <tr>\r\n     <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setLabel(careEnteredLabel);
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setValue("Y");
          _jspx_th_impact_validateInput_1.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndCareEntered()));
          _jspx_th_impact_validateInput_1.setName("bIndCareEntered");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n\r\n\r\n    ");

    String evidenceLabel="Additional evidence collection needed for determining the truth of an allegation, for understanding the client's situation, or for resolving discrepancies.";
    
          out.write("\r\n    <tr>\r\n     <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setLabel(evidenceLabel);
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setValue("Y");
          _jspx_th_impact_validateInput_2.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndEvidence()));
          _jspx_th_impact_validateInput_2.setName("bIndEvidence");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n  <tr>\r\n    <td colspan=\"4\">\r\n\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr>\r\n      <td width=\"15%\">&nbsp;</td>\r\n      <td colspan=\"4\">Missing Evidence</td>\r\n    </tr>\r\n  <tr>\r\n   <td>&nbsp;</td>\r\n     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setLabel("Reporter");
          _jspx_th_impact_validateInput_3.setType("checkbox");
          _jspx_th_impact_validateInput_3.setValue("Y");
          _jspx_th_impact_validateInput_3.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidRptr()));
          _jspx_th_impact_validateInput_3.setName("bIndMissingEvidRptr");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setLabel("AP");
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setValue("Y");
          _jspx_th_impact_validateInput_4.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidAp()));
          _jspx_th_impact_validateInput_4.setName("bIndMissingEvidAp");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setLabel("Medical professional");
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setValue("Y");
          _jspx_th_impact_validateInput_5.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidMp()));
          _jspx_th_impact_validateInput_5.setName("bIndMissingEvidMp");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n   <tr>\r\n      <td>&nbsp;</td>\r\n     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setLabel("Collateral");
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setValue("Y");
          _jspx_th_impact_validateInput_6.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidCl()));
          _jspx_th_impact_validateInput_6.setName("bIndMissingEvidCl");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setLabel("Photographs");
          _jspx_th_impact_validateInput_7.setType("checkbox");
          _jspx_th_impact_validateInput_7.setValue("Y");
          _jspx_th_impact_validateInput_7.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidPhoto()));
          _jspx_th_impact_validateInput_7.setName("bIndMissingEvidPhoto");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setLabel("Documentary Evidence");
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setValue("Y");
          _jspx_th_impact_validateInput_8.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidDe()));
          _jspx_th_impact_validateInput_8.setName("bIndMissingEvidDe");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setLabel("Other");
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setValue("Y");
          _jspx_th_impact_validateInput_9.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndMissingEvidOther()));
          _jspx_th_impact_validateInput_9.setName("bIndMissingEvidOther");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n     </tr>\r\n  </table>\r\n  </td>\r\n</tr>\r\n\r\n");
}
          out.write("\r\n    ");

    String discretionaryLabel="Discretionary rejection for other reason (See comments).";
    
          out.write("\r\n    <tr>\r\n     <td colspan=\"4\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setLabel(discretionaryLabel);
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setValue("Y");
          _jspx_th_impact_validateInput_10.setChecked(FormattingHelper.formatString(rowccmni3do.getBIndDiscretionaryReason()));
          _jspx_th_impact_validateInput_10.setName("bIndDiscretionaryReason");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n   </tr>\r\n    <tr>\r\n      <td colspan=\"4\" align=\"left\">Comments:&nbsp;&nbsp;\r\n      ");
          out.print(FormattingHelper.formatString(rowccmni3do.getSzTxtApproversComments()));
          out.write("</td>\r\n    </tr>\r\n\r\n</table>\r\n");
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
}
