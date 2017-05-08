package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.person.YouthDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExamDetailList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CollegeEntranceExamSummary;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportSummary;
import java.util.Iterator;

public final class YouthDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // Conversation handles page mode logic
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  int loopCount = 0;
  boolean yesIsChecked = false;
  boolean noIsChecked = false;
  boolean isChecked = false;
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  YouthDetailRetrieveSO youthDetailRetrieveSO = (YouthDetailRetrieveSO) state.getAttribute("YOUTH_DETAIL", request);
  if (youthDetailRetrieveSO == null) { // case retrieve service returns null when no youth detail exists for this person
    youthDetailRetrieveSO = new YouthDetailRetrieveSO();
  } 
  
  // SMS #66384: MR-067 Set a flag for NYTD User
  boolean isNytdUser = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndNytdUser()); 
  
  String zip = youthDetailRetrieveSO.getTxtGEDProgZipCode();
  String zipSuff = "";
  if (StringHelper.isValid(zip) && zip.indexOf('-') > 0) {
    zipSuff = zip.substring(zip.indexOf('-')+1);
  }
 
  // Get the user profile, if needed.
  //UserProfile user = UserProfileHelper.getUserProfile(request);

  // Non YDP coordinator can't add new report if the latest report is current
  // YDP Coordinator has SEC_REGIONAL_SS_STF attribute
  boolean bAddReportButtonHide = false;
  if (!DateHelper.isNull(youthDetailRetrieveSO.getDtCurrRptPeriod())) {
    bAddReportButtonHide = DateHelper.isAfterToday(youthDetailRetrieveSO.getDtCurrRptPeriod()) && !YouthDetailConversation.isUserYDPCoordinator(request);
  }
  // = DateHelper.isAfterToday(youthDetailRetrieveSO.getDtCurrRptPeriod()) && !user.hasRight(UserProfile.SEC_ADO_VIEW);

  // SMS #66384: MR-067 
  // All users including ILP Coordinator(YDP Coordinator) cannot add new Youth Report if the latest Report is in the current reporting period
  // per NYTD survey. Previously, ILP Coordinator(YDP Coordinator) had ability to add multiple Youth Report per reporing period.
  boolean bAddYouthReportButtonHide = false;
  if (!DateHelper.isNull(youthDetailRetrieveSO.getDtCurrRptPeriod())) {
    bAddYouthReportButtonHide = DateHelper.isAfterToday(youthDetailRetrieveSO.getDtCurrRptPeriod());
  }

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n  /*\r\n   This function is called before the page unloads. It creates the\r\n   \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty(); \r\n  };\r\n\r\n  // Custom function to handle submitting the form via links in exam list, for both Highschool and GED exams\r\n  function displayExamDetailPage(counter, linkValue, examType)\r\n  {\r\n    //var dtNextReviewField = eval(document.getElementById(\"dtNextReview_Id\"));\r\n    document.frmYouthDetail.hdnExamCat.value = examType;\r\n    document.frmYouthDetail.hdnExamId.value = linkValue;\r\n    disableValidation( 'frmYouthDetail' );\r\n    submitValidateForm('frmYouthDetail', '/person/ExamDetail/displayExamDetail');\r\n  }\r\n  \r\n  // Custom function to handle submitting the form via links in College Entrance Exam list\r\n  function displayCeExamDetailPage(counter, linkValue)\r\n");
      out.write("  {\r\n    document.frmYouthDetail.hdnCeExamId.value = linkValue;\r\n    disableValidation( 'frmYouthDetail' );\r\n    submitValidateForm('frmYouthDetail', '/person/CollegeEntranceExam/displayCollegeEntranceExam'); \r\n  }\r\n  \r\n  // Custom function to handle submitting the form via links in Youth Report list\r\n  function displayYouthReportDetailPage(counter, linkValue)\r\n  {\r\n    document.frmYouthDetail.hdnReportId.value = linkValue;\r\n    disableValidation( 'frmYouthDetail' );\r\n    submitValidateForm('frmYouthDetail', '/person/YouthReportDetail/displayReportDetail');\r\n  }\r\n  \r\n  // functions to set the value for exam type: Highschool or GED so Exam Detail page can load appropriate codes table \r\n  function setHsExamCat() {\r\n    document.frmYouthDetail.hdnExamCat.value='HS';\r\n    disableValidation( 'frmYouthDetail' );\r\n    return true;\r\n  }\r\n  function setGedExamCat() {\r\n    document.frmYouthDetail.hdnExamCat.value='GED';\r\n    disableValidation( 'frmYouthDetail' );\r\n    return true;\r\n  }\r\n\r\n</script>\r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmYouthDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/YouthDetail/saveYouthDetail");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.YouthDetailCustomValidation");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write(' ');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnDtLastUpdateYouthDetail");
          _jspx_th_impact_validateInput_4.setValue( DateHelper.toISOString(youthDetailRetrieveSO.getDtLastUpdate()) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n        ");
          out.write("\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp;\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"8\">General Information</th>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"2\">\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Parental Status");
          _jspx_th_impact_validateSelect_0.setName("selSzCdParentStat");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable("CPARSTAT");
          _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getCdParentalStatus() ));
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"2\">\r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("dtEmanDisc");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setLabel("Emancipation Discussion Date");
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate(youthDetailRetrieveSO.getDtEmancipationDiscussionDate()) );
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>&nbsp;</td>\r\n  <td valign=\"middle\"><!--- Text Area Custom Tag --->\r\n    ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtEmanDiscCmnt");
          _jspx_th_impact_validateTextArea_0.setColspan("3");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("50");
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
              out.write("\r\n    ");
              out.print( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtEmancipationDiscussionCmnt()) );
              out.write("\r\n\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n  <span></span>Life Skill Training Received\r\n  </td>\r\n  <td>&nbsp;</td>\r\n  <td>\r\n    ");

    yesIsChecked = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndLifeSkillsTrainingRecvd());
    noIsChecked = ArchitectureConstants.N.equals(youthDetailRetrieveSO.getIndLifeSkillsTrainingRecvd());
    
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setChecked(String.valueOf(yesIsChecked));
          _jspx_th_impact_validateInput_5.setValue( ArchitectureConstants.Y );
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setName("rbLST_Recvd");
          _jspx_th_impact_validateInput_5.setLabel("Yes");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setChecked(String.valueOf(noIsChecked));
          _jspx_th_impact_validateInput_6.setValue( ArchitectureConstants.N );
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setName("rbLST_Recvd");
          _jspx_th_impact_validateInput_6.setLabel("No");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>&nbsp;</td>\r\n  <td valign=\"middle\"><!--- Text Area Custom Tag --->\r\n    ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtLSTCmnt");
          _jspx_th_impact_validateTextArea_1.setColspan("3");
          _jspx_th_impact_validateTextArea_1.setLabel("Comments");
          _jspx_th_impact_validateTextArea_1.setRows("4");
          _jspx_th_impact_validateTextArea_1.setCols("50");
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
              out.write("\r\n      ");
              out.print( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtIndLifeSkillsTrainingRecvd() ));
              out.write("\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n  <span></span>Employment Services Received\r\n  </td>\r\n  <td>&nbsp;</td>\r\n  <td>\r\n    ");

    yesIsChecked = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndEmploymentServiceRecvd());
    noIsChecked = ArchitectureConstants.N.equals(youthDetailRetrieveSO.getIndEmploymentServiceRecvd());
    
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setChecked(String.valueOf(yesIsChecked));
          _jspx_th_impact_validateInput_7.setValue( ArchitectureConstants.Y );
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setName("rbES_Recvd");
          _jspx_th_impact_validateInput_7.setLabel("Yes");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setChecked(String.valueOf(noIsChecked));
          _jspx_th_impact_validateInput_8.setValue( ArchitectureConstants.N );
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setName("rbES_Recvd");
          _jspx_th_impact_validateInput_8.setLabel("No");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>&nbsp;</td>\r\n  <td valign=\"middle\"><!--- Text Area Custom Tag --->\r\n    ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("txtESCmnt");
          _jspx_th_impact_validateTextArea_2.setColspan("3");
          _jspx_th_impact_validateTextArea_2.setLabel("Comments");
          _jspx_th_impact_validateTextArea_2.setRows("4");
          _jspx_th_impact_validateTextArea_2.setCols("50");
          _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n      ");
              out.print( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtIndEmploymntServiceRecvd() ));
              out.write("\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n  <span></span>Health Services Received\r\n  </td>\r\n  <td>&nbsp;</td>\r\n  <td>\r\n    ");

    yesIsChecked = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndHealthServiceRecvd());
    noIsChecked = ArchitectureConstants.N.equals(youthDetailRetrieveSO.getIndHealthServiceRecvd());
    
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setChecked(String.valueOf(yesIsChecked));
          _jspx_th_impact_validateInput_9.setValue( ArchitectureConstants.Y );
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setName("rbHS_Recvd");
          _jspx_th_impact_validateInput_9.setLabel("Yes");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_10.setChecked(String.valueOf(noIsChecked));
          _jspx_th_impact_validateInput_10.setValue( ArchitectureConstants.N );
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setName("rbHS_Recvd");
          _jspx_th_impact_validateInput_10.setLabel("No");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>&nbsp;</td>\r\n  <td valign=\"middle\"><!--- Text Area Custom Tag --->\r\n    ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName("txtHSCmnt");
          _jspx_th_impact_validateTextArea_3.setColspan("3");
          _jspx_th_impact_validateTextArea_3.setLabel("Comments");
          _jspx_th_impact_validateTextArea_3.setRows("4");
          _jspx_th_impact_validateTextArea_3.setCols("50");
          _jspx_th_impact_validateTextArea_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_3.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.write("\r\n      ");
              out.print( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtIndHealthServiceRecvd() ));
              out.write("\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n</table>\r\n");
          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("SchoolAndGedDetailTable");
          _jspx_th_impact_ExpandableSectionTag_0.setId("SchGedInfo_Id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("School and GED Information");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n   <tr class=\"subDetail\"><td><table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"1\">\r\n    <tr class=\"subDetail\">\r\n      <td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_0.setName("txtHsName");
              _jspx_th_impact_validateDisplayOnlyField_0.setColspan("3");
              _jspx_th_impact_validateDisplayOnlyField_0.setLabel("School Name");
              _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtHiSchoolName() ));
              int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td width=\"17%\">\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_1.setName("dtExpectedHsGrad");
              _jspx_th_impact_validateDate_1.setDisabled("false");
              _jspx_th_impact_validateDate_1.setLabel("Expected Highschool Graduation");
              _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate( youthDetailRetrieveSO.getDtExpectdHiSchoolGradtn() ));
              _jspx_th_impact_validateDate_1.setSize("8");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_1.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getCdAcademicTrack() ));
              _jspx_th_impact_validateSelect_1.setName("selAcademicTrack");
              _jspx_th_impact_validateSelect_1.setLabel("Academic Track");
              _jspx_th_impact_validateSelect_1.setCodesTable("CATRACK");
              _jspx_th_impact_validateSelect_1.setBlankValue("true");
              int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
              if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>  \r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_11.setType("text");
              _jspx_th_impact_validateInput_11.setLabel("Credits Required");
              _jspx_th_impact_validateInput_11.setName("txtHsCreditsReq");
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              _jspx_th_impact_validateInput_11.setConstraint("Numeric");
              _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtCreditsRequired() ) );
              _jspx_th_impact_validateInput_11.setSize("8");
              _jspx_th_impact_validateInput_11.setMaxLength("5");
              _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_12.setType("text");
              _jspx_th_impact_validateInput_12.setLabel("Credits Earned");
              _jspx_th_impact_validateInput_12.setName("txtHsCreditsEarned");
              _jspx_th_impact_validateInput_12.setCssClass("formInput");
              _jspx_th_impact_validateInput_12.setConstraint("Numeric");
              _jspx_th_impact_validateInput_12.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtCreditsEarned() ));
              _jspx_th_impact_validateInput_12.setSize("8");
              _jspx_th_impact_validateInput_12.setMaxLength("5");
              _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_13.setType("text");
              _jspx_th_impact_validateInput_13.setLabel("Current GPA");
              _jspx_th_impact_validateInput_13.setName("txtHsCurrentGPA");
              _jspx_th_impact_validateInput_13.setCssClass("formInput");
              _jspx_th_impact_validateInput_13.setConstraint("GPA");
              _jspx_th_impact_validateInput_13.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtHsCurrentGPA() ));
              _jspx_th_impact_validateInput_13.setSize("8");
              _jspx_th_impact_validateInput_13.setMaxLength("5");
              _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_14.setType("text");
              _jspx_th_impact_validateInput_14.setLabel("Cumulative GPA");
              _jspx_th_impact_validateInput_14.setName("txtHsCumulativeGPA");
              _jspx_th_impact_validateInput_14.setCssClass("formInput");
              _jspx_th_impact_validateInput_14.setConstraint("GPA");
              _jspx_th_impact_validateInput_14.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtHsCumulativeGPA() ));
              _jspx_th_impact_validateInput_14.setSize("8");
              _jspx_th_impact_validateInput_14.setMaxLength("5");
              _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td colspan=\"2\">\r\n    ");

    isChecked = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndHsGraduate());
    
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_15.setValue(ArchitectureConstants.Y);
              _jspx_th_impact_validateInput_15.setType("checkbox");
              _jspx_th_impact_validateInput_15.setChecked(String.valueOf(isChecked));
              _jspx_th_impact_validateInput_15.setName("cbxIndHsGrad");
              _jspx_th_impact_validateInput_15.setLabel("High School Graduate");
              _jspx_th_impact_validateInput_15.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td valign=\"middle\"><!--- Text Area Custom Tag --->\r\n        ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_4.setName("txtHsGradCmnt");
              _jspx_th_impact_validateTextArea_4.setColspan("3");
              _jspx_th_impact_validateTextArea_4.setLabel("Comments");
              _jspx_th_impact_validateTextArea_4.setRows("4");
              _jspx_th_impact_validateTextArea_4.setCols("50");
              _jspx_th_impact_validateTextArea_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_4.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
              if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_4.doInitBody();
                }
                do {
                  out.write("\r\n                             ");
                  out.print( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtIndHsGradteCmnt() ));
                  out.write("\r\n        ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n   </table></td></tr>\r\n    <tr><th>Georgia Graduation Test Dates</th></tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        <div id=\"scrollBar\" style=\"height:165;width:100%;overflow:auto\" class=\"tableborderList\">\r\n          <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n            <tr><th class=\"thList\">Examination Type</th>\r\n                <th class=\"thList\">Date</th>\r\n                <th class=\"thList\">First Taken?</th>\r\n                <th class=\"thList\">Passed?</th>\r\n                <th class=\"thList\">Score</th>\r\n            </tr>\r\n            ");

            loopCount = 0;
            Iterator itrHsExamList = youthDetailRetrieveSO.getHsExamList().iterator();
            while (itrHsExamList.hasNext()) {
              ExamDetailList hsExam = (ExamDetailList) itrHsExamList.next(); 
            
              out.write("\r\n            <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n              <td>\r\n                ");
              out.write("\r\n                <a href=\"javascript: displayExamDetailPage( '");
              out.print( loopCount );
              out.write("', '");
              out.print( hsExam.getIdExamDetail());
              out.write("', 'HS' )\" \r\n                   tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onclick=\"window.onBeforeUnload=null;\" id=\"HS\" \r\n                  >");
              out.print(Lookup.simpleDecodeSafe("CGRAD", hsExam.getCdExamType()) );
              out.write("</a>\r\n              </td>\r\n              <td>");
              out.print( FormattingHelper.formatDate(hsExam.getDtExam()) );
              out.write("</td>\r\n              <td>");
              out.print( FormattingHelper.formatString(hsExam.getIndFirstAtmpt()) );
              out.write("</td>\r\n              <td>");
              out.print( FormattingHelper.formatString(hsExam.getIndPassed()) );
              out.write("</td>\r\n              <td>");
              out.print( FormattingHelper.formatInt(hsExam.getNbrScore()) );
              out.write("</td>\r\n            </tr>\r\n            ");

              loopCount++;
            }
            
              out.write("\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td align=\"right\">\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_0.setName("btnAddHsExams");
              _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_0.setForm("frmYouthDetail");
              _jspx_th_impact_ButtonTag_0.setFunction("return setHsExamCat();");
              _jspx_th_impact_ButtonTag_0.setAction("/person/ExamDetail/addExamDetail");
              _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.EDIT);
              _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_0.setAlign("right");
              _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <!-- GED Section -->\r\n   <tr><td><table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n    <tr><th colspan=\"4\">GED Information</th></tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_16.setType("text");
              _jspx_th_impact_validateInput_16.setLabel("GED Program Name");
              _jspx_th_impact_validateInput_16.setConstraint("Name20");
              _jspx_th_impact_validateInput_16.setName("txtGEDProgName");
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtGEDProgramName() ));
              _jspx_th_impact_validateInput_16.setSize("30");
              _jspx_th_impact_validateInput_16.setMaxLength("20");
              _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td colspan=\"2\">\r\n    ");

    isChecked = ArchitectureConstants.Y.equals(youthDetailRetrieveSO.getIndInGEDProgram());
    
              out.write("\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_17.setValue(ArchitectureConstants.Y);
              _jspx_th_impact_validateInput_17.setType("checkbox");
              _jspx_th_impact_validateInput_17.setChecked(String.valueOf(isChecked));
              _jspx_th_impact_validateInput_17.setName("cbxIndGEDProg");
              _jspx_th_impact_validateInput_17.setLabel("In GED Program");
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_18.setType("text");
              _jspx_th_impact_validateInput_18.setLabel("Address Line 1");
              _jspx_th_impact_validateInput_18.setConstraint("Address");
              _jspx_th_impact_validateInput_18.setName("txtGEDProgAddressLine1");
              _jspx_th_impact_validateInput_18.setCssClass("formInput");
              _jspx_th_impact_validateInput_18.setColspan("3");
              _jspx_th_impact_validateInput_18.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtGEDProgAddressLine1() ));
              _jspx_th_impact_validateInput_18.setSize("30");
              _jspx_th_impact_validateInput_18.setMaxLength("30");
              _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
              if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_19.setType("text");
              _jspx_th_impact_validateInput_19.setLabel("Address Line 2");
              _jspx_th_impact_validateInput_19.setConstraint("Address2");
              _jspx_th_impact_validateInput_19.setName("txtGEDProgAddressLine2");
              _jspx_th_impact_validateInput_19.setCssClass("formInput");
              _jspx_th_impact_validateInput_19.setColspan("3");
              _jspx_th_impact_validateInput_19.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtGEDProgAddressLine2() ));
              _jspx_th_impact_validateInput_19.setSize("30");
              _jspx_th_impact_validateInput_19.setMaxLength("30");
              _jspx_th_impact_validateInput_19.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <!-- td colspan=\"5\">&nbsp;</td -->\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_20.setType("text");
              _jspx_th_impact_validateInput_20.setLabel("City");
              _jspx_th_impact_validateInput_20.setConstraint("City");
              _jspx_th_impact_validateInput_20.setName("txtGEDProgCity");
              _jspx_th_impact_validateInput_20.setCssClass("formInput");
              _jspx_th_impact_validateInput_20.setColspan("3");
              _jspx_th_impact_validateInput_20.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtGEDProgCity() ));
              _jspx_th_impact_validateInput_20.setSize("20");
              _jspx_th_impact_validateInput_20.setMaxLength("30");
              _jspx_th_impact_validateInput_20.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_2.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getCdGEDProgState() ));
              _jspx_th_impact_validateSelect_2.setName("selGEDProgCdState");
              _jspx_th_impact_validateSelect_2.setLabel("State");
              _jspx_th_impact_validateSelect_2.setCodesTable("CSTATE");
              _jspx_th_impact_validateSelect_2.setBlankValue("true");
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td colspan=\"2\">\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td width=\"30px\">\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_21.setType("text");
              _jspx_th_impact_validateInput_21.setLabel("Zip");
              _jspx_th_impact_validateInput_21.setConstraint("Zip");
              _jspx_th_impact_validateInput_21.setName("txtGEDProgZip");
              _jspx_th_impact_validateInput_21.setCssClass("formInput");
              _jspx_th_impact_validateInput_21.setValue( zip );
              _jspx_th_impact_validateInput_21.setSize("5");
              _jspx_th_impact_validateInput_21.setMaxLength("5");
              _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
              if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        -\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_22.setType("text");
              _jspx_th_impact_validateInput_22.setConstraint("ZipSuff");
              _jspx_th_impact_validateInput_22.setName("txtGEDProgZipSuff");
              _jspx_th_impact_validateInput_22.setCssClass("formInput");
              _jspx_th_impact_validateInput_22.setValue( zipSuff );
              _jspx_th_impact_validateInput_22.setSize("4");
              _jspx_th_impact_validateInput_22.setMaxLength("4");
              _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td></tr></table>\r\n      </td>\r\n      <!-- td colspan=\"3\">&nbsp;</td -->\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n    ");

    String phoneNumber = FormattingHelper.formatString(youthDetailRetrieveSO.getTxtGEDProgPhoneNum());
    if (!"".equals(phoneNumber)) {
      phoneNumber = FormattingHelper.formatPhone(phoneNumber);
    }
    
              out.write("\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_23.setType("text");
              _jspx_th_impact_validateInput_23.setLabel("Phone");
              _jspx_th_impact_validateInput_23.setConstraint("Phone");
              _jspx_th_impact_validateInput_23.setName("txtGEDProgPhoneNumber");
              _jspx_th_impact_validateInput_23.setCssClass("formInput");
              _jspx_th_impact_validateInput_23.setValue( phoneNumber);
              _jspx_th_impact_validateInput_23.setSize("15");
              _jspx_th_impact_validateInput_23.setMaxLength("14");
              _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      ");

    String faxNumber = FormattingHelper.formatString(youthDetailRetrieveSO.getTxtGEDProgFaxNum());
    if (!"".equals(faxNumber)) {
      faxNumber = FormattingHelper.formatPhone(faxNumber);
    }
    
              out.write("\r\n      <td colspan=\"2\">\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td width=\"30px\">\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_24.setType("text");
              _jspx_th_impact_validateInput_24.setLabel("Fax");
              _jspx_th_impact_validateInput_24.setConstraint("Phone");
              _jspx_th_impact_validateInput_24.setName("txtGEDProgFaxNumber");
              _jspx_th_impact_validateInput_24.setCssClass("formInput");
              _jspx_th_impact_validateInput_24.setValue( faxNumber );
              _jspx_th_impact_validateInput_24.setSize("15");
              _jspx_th_impact_validateInput_24.setMaxLength("14");
              _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td></tr></table>\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_2.setName("dtExpectedGEDComp");
              _jspx_th_impact_validateDate_2.setDisabled("false");
              _jspx_th_impact_validateDate_2.setLabel("Expected GED Program Completion");
              _jspx_th_impact_validateDate_2.setValue( FormattingHelper.formatDate( youthDetailRetrieveSO.getDtExpectdGEDProgramComp() ));
              _jspx_th_impact_validateDate_2.setSize("8");
              _jspx_th_impact_validateDate_2.setConstraint("Date");
              _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
              if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td colspan=\"2\">\r\n       <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td width=\"40%\">\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_3.setName("dtActualGEDComp");
              _jspx_th_impact_validateDate_3.setDisabled("false");
              _jspx_th_impact_validateDate_3.setLabel("Actual GED Program Completion");
              _jspx_th_impact_validateDate_3.setValue( FormattingHelper.formatDate( youthDetailRetrieveSO.getDtActualGEDProgramComp() ));
              _jspx_th_impact_validateDate_3.setSize("8");
              _jspx_th_impact_validateDate_3.setConstraint("Date");
              _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
              if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       </td></tr></table>\r\n      </td>\r\n    </tr>\r\n   </table></td></tr>\r\n    <tr><th nowrap=\"nowrap\">GED Test Dates</th></tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        <div id=\"scrollBar\" style=\"height:165;width:100%;overflow:auto\" class=\"tableborderList\">\r\n          <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n            <tr><th class=\"thList\">Examination Type</th>\r\n                <th class=\"thList\">Date</th>\r\n                <th class=\"thList\">First Taken?</th>\r\n                <th class=\"thList\">Passed?</th>\r\n                <th class=\"thList\">Score</th>\r\n            </tr>\r\n            ");

            loopCount = 0;
            Iterator itrGedExamList = youthDetailRetrieveSO.getGedExamList().iterator();
            while (itrGedExamList.hasNext()) {
              ExamDetailList gedExam = (ExamDetailList) itrGedExamList.next(); 
            
              out.write("\r\n            <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n              <td>\r\n                ");
              out.write("\r\n                <a href=\"javascript: displayExamDetailPage( '");
              out.print( loopCount );
              out.write("', '");
              out.print( gedExam.getIdExamDetail());
              out.write("', 'GED' )\" \r\n                   tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onclick=\"window.onBeforeUnload=null;\" id=\"GED\" \r\n                  >");
              out.print(Lookup.simpleDecodeSafe("CGED", gedExam.getCdExamType()) );
              out.write("</a>\r\n              </td>\r\n              <td>");
              out.print( FormattingHelper.formatDate(gedExam.getDtExam()) );
              out.write("</td>\r\n              <td>");
              out.print( FormattingHelper.formatString(gedExam.getIndFirstAtmpt()) );
              out.write("</td>\r\n              <td>");
              out.print( FormattingHelper.formatString(gedExam.getIndPassed()) );
              out.write("</td>\r\n              <td>");
              out.print( FormattingHelper.formatInt(gedExam.getNbrScore()) );
              out.write("</td>\r\n            </tr>\r\n            ");

              loopCount++;
            }
            
              out.write("\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td align=\"right\">\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ButtonTag_1.setName("btnAddGEDExams");
              _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_1.setForm("frmYouthDetail");
              _jspx_th_impact_ButtonTag_1.setFunction("return setGedExamCat();");
              _jspx_th_impact_ButtonTag_1.setAction("/person/ExamDetail/addExamDetail");
              _jspx_th_impact_ButtonTag_1.setEditableMode(EditableMode.EDIT);
              _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_1.setAlign("right");
              _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
              if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("PostSecondaryEducationTable");
          _jspx_th_impact_ExpandableSectionTag_1.setId("PostSecEdu_Id");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Post Secondary Education");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_25.setType("text");
              _jspx_th_impact_validateInput_25.setLabel("Institution Name");
              _jspx_th_impact_validateInput_25.setConstraint("Name50");
              _jspx_th_impact_validateInput_25.setName("txtPostInstitutionName");
              _jspx_th_impact_validateInput_25.setCssClass("formInput");
              _jspx_th_impact_validateInput_25.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostInstitutionName() ) );
              _jspx_th_impact_validateInput_25.setColspan("2");
              _jspx_th_impact_validateInput_25.setSize("20");
              _jspx_th_impact_validateInput_25.setMaxLength("50");
              _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_3.setName("selPostCdEduGoal");
              _jspx_th_impact_validateSelect_3.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getCdPostEduGoal() ) );
              _jspx_th_impact_validateSelect_3.setLabel("Education Goal");
              _jspx_th_impact_validateSelect_3.setCodesTable("CEDUGOAL");
              _jspx_th_impact_validateSelect_3.setBlankValue("true");
              _jspx_th_impact_validateSelect_3.setColspan("2");
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_4.setName("selPostCdClassif");
              _jspx_th_impact_validateSelect_4.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getCdPostClassification() ) );
              _jspx_th_impact_validateSelect_4.setLabel("Classification");
              _jspx_th_impact_validateSelect_4.setCodesTable("CCLSSFCT");
              _jspx_th_impact_validateSelect_4.setBlankValue("true");
              _jspx_th_impact_validateSelect_4.setColspan("2");
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_26.setType("text");
              _jspx_th_impact_validateInput_26.setLabel("Area Study");
              _jspx_th_impact_validateInput_26.setConstraint("Name50");
              _jspx_th_impact_validateInput_26.setName("txtPostAreaStudy");
              _jspx_th_impact_validateInput_26.setCssClass("formInput");
              _jspx_th_impact_validateInput_26.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostAreaofStudy() ) );
              _jspx_th_impact_validateInput_26.setColspan("2");
              _jspx_th_impact_validateInput_26.setSize("20");
              _jspx_th_impact_validateInput_26.setMaxLength("50");
              _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_27.setType("text");
              _jspx_th_impact_validateInput_27.setLabel("Current GPA");
              _jspx_th_impact_validateInput_27.setName("txtPostCurrentGPA");
              _jspx_th_impact_validateInput_27.setCssClass("formInput");
              _jspx_th_impact_validateInput_27.setConstraint("GPA");
              _jspx_th_impact_validateInput_27.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostCurrentGPA() ) );
              _jspx_th_impact_validateInput_27.setColspan("2");
              _jspx_th_impact_validateInput_27.setSize("8");
              _jspx_th_impact_validateInput_27.setMaxLength("5");
              _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_28.setType("text");
              _jspx_th_impact_validateInput_28.setLabel("Cumulative GPA");
              _jspx_th_impact_validateInput_28.setName("txtPostCumulativeGPA");
              _jspx_th_impact_validateInput_28.setCssClass("formInput");
              _jspx_th_impact_validateInput_28.setConstraint("GPA");
              _jspx_th_impact_validateInput_28.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostCumulativeGPA() ) );
              _jspx_th_impact_validateInput_28.setColspan("2");
              _jspx_th_impact_validateInput_28.setSize("8");
              _jspx_th_impact_validateInput_28.setMaxLength("5");
              _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_29.setType("text");
              _jspx_th_impact_validateInput_29.setLabel("Credits Required for Graduation");
              _jspx_th_impact_validateInput_29.setName("txtPostCreditsReqGrad");
              _jspx_th_impact_validateInput_29.setCssClass("formInput");
              _jspx_th_impact_validateInput_29.setConstraint("Numeric");
              _jspx_th_impact_validateInput_29.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostReqdCreditsforGradtn() ) );
              _jspx_th_impact_validateInput_29.setColspan("2");
              _jspx_th_impact_validateInput_29.setSize("8");
              _jspx_th_impact_validateInput_29.setMaxLength("5");
              _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_30.setType("text");
              _jspx_th_impact_validateInput_30.setLabel("Earned Credits for Graduation");
              _jspx_th_impact_validateInput_30.setName("txtPostCreditsEarnedGrad");
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setConstraint("Numeric");
              _jspx_th_impact_validateInput_30.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtPostEarndCreditsforGradtn() ) );
              _jspx_th_impact_validateInput_30.setColspan("2");
              _jspx_th_impact_validateInput_30.setSize("8");
              _jspx_th_impact_validateInput_30.setMaxLength("5");
              _jspx_th_impact_validateInput_30.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDate_4.setName("dtExpectedPostGrad");
              _jspx_th_impact_validateDate_4.setDisabled("false");
              _jspx_th_impact_validateDate_4.setLabel("Expected Graduation");
              _jspx_th_impact_validateDate_4.setValue( FormattingHelper.formatDate( youthDetailRetrieveSO.getDtPostExpectdGradtn() ) );
              _jspx_th_impact_validateDate_4.setSize("8");
              _jspx_th_impact_validateDate_4.setConstraint("Date");
              _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_4.setColspan("2");
              int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
              if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDate_5.setName("dtActualPostGrad");
              _jspx_th_impact_validateDate_5.setDisabled("false");
              _jspx_th_impact_validateDate_5.setLabel("Actual Graduation");
              _jspx_th_impact_validateDate_5.setValue( FormattingHelper.formatDate( youthDetailRetrieveSO.getDtPostActualGradtn() ) );
              _jspx_th_impact_validateDate_5.setSize("8");
              _jspx_th_impact_validateDate_5.setConstraint("Date");
              _jspx_th_impact_validateDate_5.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
              if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr><th><span></span>College Entrance Exams</th></tr>\r\n    <tr class=\"subDetail\">\r\n      <td colspan=\"6\">\r\n        <div id=\"scrollBar\" style=\"height:165;width:100%;overflow:auto\" class=\"tableborderList\">\r\n          <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n            <tr><th class=\"thList\">Date Taken</th>\r\n                <th class=\"thList\">Examination Type</th>\r\n                <th class=\"thList\">&nbsp;</th>\r\n                <th class=\"thList\">&nbsp;</th>\r\n                <th class=\"thList\">&nbsp;</th>\r\n            </tr>\r\n            ");

            loopCount = 0;
            Iterator itrCeExamList = youthDetailRetrieveSO.getCeExamList().iterator();
            while (itrCeExamList.hasNext()) {
              CollegeEntranceExamSummary ceExam = (CollegeEntranceExamSummary) itrCeExamList.next(); 
            
              out.write("\r\n            <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n              <td>\r\n                ");
              out.write("\r\n                <a href=\"javascript: displayCeExamDetailPage( '");
              out.print( loopCount );
              out.write("', '");
              out.print( ceExam.getIdExam());
              out.write("' )\" \r\n                   tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onclick=\"window.onBeforeUnload=null;\"  \r\n                  >");
              out.print( FormattingHelper.formatDate(ceExam.getDtExamTaken()) );
              out.write("</a>\r\n              </td>\r\n              <td>");
              out.print(FormattingHelper.formatString(ceExam.getCdExamType()) );
              out.write("</td>\r\n              <td></td>\r\n              <td></td>\r\n              <td></td>\r\n            </tr>\r\n            ");

              loopCount++;
            }
            
              out.write("\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td align=\"right\" colspan=\"6\">\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_2.setName("btnAddCExams");
              _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_2.setForm("frmYouthDetail");
              _jspx_th_impact_ButtonTag_2.setAction("/person/CollegeEntranceExam/addCollegeEntranceExam");
              _jspx_th_impact_ButtonTag_2.setFunction("disableValidation('frmYouthDetail');");
              _jspx_th_impact_ButtonTag_2.setAlign("right");
              _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_ButtonTag_2.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_2.setDisabled( String.valueOf(bAddReportButtonHide) );
              _jspx_th_impact_ButtonTag_2.setEditableMode(EditableMode.EDIT);
              int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
              if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("YouthReportTable");
          _jspx_th_impact_ExpandableSectionTag_2.setId("YouthReport_Id");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Youth Report List");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <td colspan=\"6\">\r\n        <div id=\"scrollBar\" style=\"height:165;width:100%;overflow:auto\" class=\"tableborderList\">\r\n          <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n            <tr><th class=\"thList\">Reporting Period</th>\r\n                <th class=\"thList\">Age Class</th>\r\n                <th class=\"thList\">Current Outcome Status</th>\r\n                <th class=\"thList\">Outcome Date</th>\r\n                <th class=\"thList\">&nbsp;</th>\r\n            </tr>\r\n            ");

            loopCount = 0;
            Iterator itrYouthReportList = youthDetailRetrieveSO.getYouthReportList().iterator();
            while (itrYouthReportList.hasNext()) {
              YouthReportSummary report = (YouthReportSummary) itrYouthReportList.next(); 
            
              out.write("\r\n            <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n              <td>\r\n                ");
              out.write("\r\n                <a href=\"javascript: displayYouthReportDetailPage( '");
              out.print( loopCount );
              out.write("', '");
              out.print( report.getIdYouthReport());
              out.write("' )\" \r\n                   tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" onclick=\"window.onBeforeUnload=null;\"  \r\n                  >");
              out.print( FormattingHelper.formatDate(report.getDtReportingPeriod()) );
              out.write("</a>\r\n              </td>\r\n              <td>");
              out.print(Lookup.simpleDecodeSafe("CAGECLSS", report.getCdAgeClass()) );
              out.write("</td>\r\n              <td>");
              out.print( Lookup.simpleDecodeSafe("COUTSTAT", report.getCdOutcomeStatus()) );
              out.write("</td>\r\n              <td>");
              out.print( FormattingHelper.formatDate(report.getDtOutcomeDate()) );
              out.write("</td>\r\n              <td></td>\r\n            </tr>\r\n            ");

              loopCount++;
            }
            
              out.write("\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td align=\"right\" colspan=\"6\">\r\n        ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_3.setName("btnAddReport");
              _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_3.setForm("frmYouthDetail");
              _jspx_th_impact_ButtonTag_3.setAction("/person/YouthReportDetail/addReportDetail");
              _jspx_th_impact_ButtonTag_3.setAlign("right");
              _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_ButtonTag_3.setFunction("disableValidation('frmYouthDetail');");
              _jspx_th_impact_ButtonTag_3.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_3.setDisabled(String.valueOf(bAddYouthReportButtonHide));
              _jspx_th_impact_ButtonTag_3.setEditableMode(EditableMode.EDIT);
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<!-- SMS #66384: MR-067 Added NYTD User Information as the last expandable section  --> \r\n<br> \r\n\r\n\r\n    ");
 // If the person is a NYTD User, display NYTD User Information section
    if (isNytdUser) {
      // Get the zip code format
      String zipPortalUser = youthDetailRetrieveSO.getTxtAddrUsrZip();
      String zipSuffPortalUser = "";
      if (StringHelper.isValid(zipPortalUser)) {           
	      if (zipPortalUser.length() > 5) {
	        zipSuffPortalUser = zipPortalUser.substring(5);
	        zipPortalUser = zipPortalUser.substring(0,5);
	        }
      }  
    
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("NYTDUserInformationTable");
          _jspx_th_impact_ExpandableSectionTag_3.setId("NYTDUser_Id");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("NYTD User Information");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  \r\n  <tr class=\"subDetail\">\r\n        <td>         \r\n            <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableborder\">\r\n  \t\t     <tr class=\"subDetail\">\r\n\t\t       <td width=\"25%\">");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_1.setName("txtFirstName");
              _jspx_th_impact_validateDisplayOnlyField_1.setLabel("First Name");
              _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserFirstName() ));
              int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n     \t\t\t <td width=\"10%\">\r\n    \t\t\t\t\t&nbsp;\r\n\t\t\t\t </td>                           \r\n\t\t       <td width=\"20%\">");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_2.setName("txtMiddleInitial");
              _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Middle Initial");
              _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserMiddleInitial() ));
              int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n               <td width=\"10%\">\r\n    \t\t\t\t\t&nbsp;\r\n\t\t\t\t </td> \r\n\t\t       <td width=\"25%\">");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_3.setName("txtLastName");
              _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Last Name");
              _jspx_th_impact_validateDisplayOnlyField_3.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserLastName() ));
              int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>                                                                                                                              \r\n\t\t       <td width=\"10%\">\r\n    \t\t\t\t\t&nbsp;\r\n\t\t\t   </td>\r\n\t\t     </tr>   \t\t\t    \t\t\t    \t\t\t\r\n    \t  </table>\r\n       </td>\r\n    </tr>\r\n\t     \r\n     <tr class=\"subDetail\">\r\n        <td>         \r\n            <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableborder\">\r\n              <tr>\r\n              <th  colspan=\"8\">Online Contact Information</th></tr>                 \r\n    \t\t\t<tr class=\"subDetail\">\r\n      \t\t\t<td>\r\n      \t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_4.setName("txtUserEmail");
              _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Email");
              _jspx_th_impact_validateDisplayOnlyField_4.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserEml() ));
              int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     \t\t\t </td>\r\n    \t\t\t</tr>\r\n    \t\t\t<tr class=\"subDetail\">\r\n      \t\t\t<td>\r\n      \t\t\t<img align=\"bottom\" alt=\"Facebook User Name\" src=\"/grnds-docs/images/shared/facebookicon.jpg\"/>\r\n     \t\t\t </td>\r\n     \t\t\t<td>");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_5.setName("txtFacebookUserName");
              _jspx_th_impact_validateDisplayOnlyField_5.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserFB() ));
              int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>                           \r\n    \t\t\t</tr>    \t\t\t\r\n    \t\t\t<tr class=\"subDetail\">\r\n      \t\t\t<td>\r\n      \t\t\t<img align=\"bottom\" alt=\"MySpace User Name\" src=\"/grnds-docs/images/shared/myspaceicon.gif\"/>\r\n      \t\t\t</td>\r\n      \t\t\t<td>\r\n      \t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_6.setName("txtMyspaceUserName");
              _jspx_th_impact_validateDisplayOnlyField_6.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserMS() ));
              int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     \t\t\t </td>\r\n    \t\t\t</tr>\r\n    \t\t\t<tr class=\"subDetail\">\r\n      \t\t\t<td>\r\n      \t\t\t<img align=\"bottom\" alt=\"Twitter User Name\" src=\"/grnds-docs/images/shared/twittericon.jpg\"/>\r\n      \t\t\t</td>\r\n      \t\t\t<td>\r\n      \t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_7.setName("txtTwitterUserName");
              _jspx_th_impact_validateDisplayOnlyField_7.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserTW() ));
              int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    \t\t\t</tr>\r\n   \t\t\t\t <tr class=\"subDetail\">\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_8.setName("txtOtherSite");
              _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Other Site");
              _jspx_th_impact_validateDisplayOnlyField_8.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserOthSite() ));
              int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_9.setName("txtOtherSiteUserName");
              _jspx_th_impact_validateDisplayOnlyField_9.setLabel("User Name");
              _jspx_th_impact_validateDisplayOnlyField_9.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserNameOthSite() ));
              int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\r\n\t\t\t    </tr>    \t\t\t    \t\t\t    \t\t\t\r\n    \t  </table>\r\n       </td>\r\n    </tr> \r\n     <tr class=\"subDetail\">\r\n        <td>         \r\n            <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableborder\">\r\n              <tr>\r\n              <th colspan=\"8\">Phone Contact Information</th>\r\n              </tr>   \t\t\t\r\n   \t\t\t\t <tr class=\"subDetail\">\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_10.setName("txtUserPhoneBest");
              _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Best Contact Phone Number");
              _jspx_th_impact_validateDisplayOnlyField_10.setValue( FormattingHelper.formatPhone( youthDetailRetrieveSO.getTxtUserPhnBest() ));
              int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_11.setName("txtUserPhoneBestExt");
              _jspx_th_impact_validateDisplayOnlyField_11.setLabel("Ext.");
              _jspx_th_impact_validateDisplayOnlyField_11.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserPhnBestExt() ));
              int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_12.setName("txtUserPhoneBestType");
              _jspx_th_impact_validateDisplayOnlyField_12.setValue( Lookup.simpleDecodeSafe("CUSRPHN", youthDetailRetrieveSO.getTxtUserPhnBestType() ));
              int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\t\t\t      \r\n\t\t\t     </tr>\t\r\n   \t\t\t\t <tr class=\"subDetail\">\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_13.setName("txtUserPhoneAlt1");
              _jspx_th_impact_validateDisplayOnlyField_13.setLabel("Alternate Phone Number 1");
              _jspx_th_impact_validateDisplayOnlyField_13.setValue( FormattingHelper.formatPhone( youthDetailRetrieveSO.getTxtUserPhnAlt1() ));
              int _jspx_eval_impact_validateDisplayOnlyField_13 = _jspx_th_impact_validateDisplayOnlyField_13.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_14.setName("txtUserPhoneAlt1Ext");
              _jspx_th_impact_validateDisplayOnlyField_14.setLabel("Ext.");
              _jspx_th_impact_validateDisplayOnlyField_14.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserPhnAlt1Ext() ));
              int _jspx_eval_impact_validateDisplayOnlyField_14 = _jspx_th_impact_validateDisplayOnlyField_14.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_15.setName("txtUserPhoneAlt1Type");
              _jspx_th_impact_validateDisplayOnlyField_15.setValue( Lookup.simpleDecodeSafe("CUSRPHN", youthDetailRetrieveSO.getTxtUserPhnAlt1Type() ));
              int _jspx_eval_impact_validateDisplayOnlyField_15 = _jspx_th_impact_validateDisplayOnlyField_15.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\t\t\t      \r\n\t\t\t     </tr>\t\r\n   \t\t\t\t <tr class=\"subDetail\">\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_16.setName("txtUserPhoneAlt2");
              _jspx_th_impact_validateDisplayOnlyField_16.setLabel("Alternate Phone Number 2");
              _jspx_th_impact_validateDisplayOnlyField_16.setValue( FormattingHelper.formatPhone( youthDetailRetrieveSO.getTxtUserPhnAlt2() ));
              int _jspx_eval_impact_validateDisplayOnlyField_16 = _jspx_th_impact_validateDisplayOnlyField_16.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_17.setName("txtUserPhoneAlt2Ext");
              _jspx_th_impact_validateDisplayOnlyField_17.setLabel("Ext.");
              _jspx_th_impact_validateDisplayOnlyField_17.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtUserPhnAlt2Ext() ));
              int _jspx_eval_impact_validateDisplayOnlyField_17 = _jspx_th_impact_validateDisplayOnlyField_17.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_18.setName("txtUserPhoneAlt2Type");
              _jspx_th_impact_validateDisplayOnlyField_18.setValue( Lookup.simpleDecodeSafe("CUSRPHN", youthDetailRetrieveSO.getTxtUserPhnAlt2Type() ));
              int _jspx_eval_impact_validateDisplayOnlyField_18 = _jspx_th_impact_validateDisplayOnlyField_18.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\t\t\t      \r\n\t\t\t     </tr>\t\r\n   \t\t\t\t <tr class=\"subDetail\">\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_19.setName("txtContactByText");
              _jspx_th_impact_validateDisplayOnlyField_19.setLabel("Can DFCS contact you by text?");
              _jspx_th_impact_validateDisplayOnlyField_19.setValue( Lookup.simpleDecodeSafe("CRISKYN", youthDetailRetrieveSO.getTxtCntctByText() ));
              int _jspx_eval_impact_validateDisplayOnlyField_19 = _jspx_th_impact_validateDisplayOnlyField_19.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\t\t      \r\n\t\t\t     </tr>\t\t\t\t     \t\t\t\t     \t\t\t     \t\t    \t\t\t    \t\t\t\r\n    \t  </table>\r\n     </tr>\r\n     <tr class=\"subDetail\">\r\n        <td>         \r\n            <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableborder\">\r\n              <tr class=\"subDetail\">\r\n              <th colspan=\"8\">Address Information</th>\r\n              </tr>   \t\t\t\r\n   \t\t\t\t <tr class=\"subDetail\">\r\n\t\t\t      <td>\r\n                    <span>Address: </span>\t      \r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_20.setName("txtAddrUserStLn1");
              _jspx_th_impact_validateDisplayOnlyField_20.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtAddrUsrStLn1() ));
              int _jspx_eval_impact_validateDisplayOnlyField_20 = _jspx_th_impact_validateDisplayOnlyField_20.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\t\t\t      \t      \r\n\t\t\t     </tr>\t\r\n   \t\t\t\t <tr class=\"subDetail\">\r\n\t\t\t      <td>\r\n                    <span></span>\t      \r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_21.setName("txtAddrUserStLn2");
              _jspx_th_impact_validateDisplayOnlyField_21.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtAddrUsrStLn2() ));
              int _jspx_eval_impact_validateDisplayOnlyField_21 = _jspx_th_impact_validateDisplayOnlyField_21.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\t\t\t      \t\t      \r\n\t\t\t     </tr>\t\r\n   \t\t\t\t <tr class=\"subDetail\">\r\n\t\t\t      <td>\r\n                    <span>City: </span>\t      \r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_22.setName("txtAddrUserCity");
              _jspx_th_impact_validateDisplayOnlyField_22.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtAddrUsrCity() ));
              int _jspx_eval_impact_validateDisplayOnlyField_22 = _jspx_th_impact_validateDisplayOnlyField_22.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\r\n\t\t\t      <td>\r\n                    <span>State: </span>\t      \r\n\t\t\t      </td>\t\t\t      \r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_23.setName("txtAddrUserState");
              _jspx_th_impact_validateDisplayOnlyField_23.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtAddrUsrSt() ));
              int _jspx_eval_impact_validateDisplayOnlyField_23 = _jspx_th_impact_validateDisplayOnlyField_23.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\t\t      \r\n\t\t\t     </tr>\t\r\n   \t\t\t\t <tr class=\"subDetail\">\r\n\t\t\t      <td>\r\n                    <span>Zip: </span>\t      \r\n\t\t\t      </td>\t\t\t\t      \r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_24.setName("txtAddrUserZip");
              _jspx_th_impact_validateDisplayOnlyField_24.setValue( FormattingHelper.formatString(zipPortalUser) );
              int _jspx_eval_impact_validateDisplayOnlyField_24 = _jspx_th_impact_validateDisplayOnlyField_24.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      ");
 // If the zip code has extended ZIP+4 code, display extended code with a Hyphen
                  if (!"".equals(zipSuffPortalUser)) {
                  
              out.write("-\r\n                  ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_25.setName("txtAddrUserZipSuff");
              _jspx_th_impact_validateDisplayOnlyField_25.setValue( FormattingHelper.formatString(zipSuffPortalUser) );
              int _jspx_eval_impact_validateDisplayOnlyField_25 = _jspx_th_impact_validateDisplayOnlyField_25.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n\t\t\t      ");
 
			      }
                  
              out.write("    \t\t\t      \r\n\t\t\t      <td>\r\n                    <span>County: </span>\t      \r\n\t\t\t      </td>\t\r\n\t\t\t      <td>\r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_26.setName("txtAddrUserCounty");
              _jspx_th_impact_validateDisplayOnlyField_26.setValue( Lookup.simpleDecodeSafe("CCOUNT", youthDetailRetrieveSO.getTxtAddrUsrCnty() ));
              int _jspx_eval_impact_validateDisplayOnlyField_26 = _jspx_th_impact_validateDisplayOnlyField_26.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t      </td>\t\r\n\t\t\t     </tr> \r\n   \t\t\t\t <tr class=\"subDetail\">\t\r\n                   <td colspan=\"4\">\r\n                    <span style=\"align:left\"> If we cannot locate you, who is a reliable adult who knows where you are? (Name and Contact Information) </span>\t      \r\n\t\t\t       </td>\r\n\t\t\t     </tr>\t\r\n\t\t\t     <tr>\r\n\t\t\t       <td colspan=\"4\">\t      \r\n\t\t\t        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_27.setName("txtEmergencyContact");
              _jspx_th_impact_validateDisplayOnlyField_27.setValue( FormattingHelper.formatString( youthDetailRetrieveSO.getTxtEmerContact() ));
              int _jspx_eval_impact_validateDisplayOnlyField_27 = _jspx_th_impact_validateDisplayOnlyField_27.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t       </td>                       \r\n\t\t\t     </tr>\t\t\t     \t\t\t     \t\t\t\t     \t\t\t     \t\t    \t\t\t    \t\t\t\r\n    \t  </table>\r\n     </td>\r\n    </tr>    \r\n  </table>\r\n \r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
}

      
          out.write("\r\n      \r\n</br>\r\n<!-- End SMS #66384: MR-067 -->\r\n<hr>\r\n<table cellspacing=\"0\" cellPadding=\"3\" width=\"100%\" border=\"0\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n        ");
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSaveFinal");
          _jspx_th_impact_ButtonTag_4.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmYouthDetail");
          _jspx_th_impact_ButtonTag_4.setAction("/person/YouthDetail/saveYouthDetail");
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setEditableMode( EditableMode.EDIT+EditableMode.NEW );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          out.write('\r');
          out.write('\n');
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnExamCat");
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
    _jspx_th_impact_validateInput_1.setName("hdnExamId");
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
    _jspx_th_impact_validateInput_2.setName("hdnCeExamId");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnReportId");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
