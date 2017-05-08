package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CollegeEntranceExamRetrieveSO;

public final class CollegeEntranceExamDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
//*******************************
  //*** DECLARE LOCAL VARIABLES ***
  //*******************************
boolean approvalStatus = false;
BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
UserProfile user = UserProfileHelper.getUserProfile(request);
String cdExamType = FormattingHelper.formatString("");
String hdnPersonId = FormattingHelper.formatString("");
int tabIndex = 1;
String dtActTestTaken= "";
String nbrActEnglishScore= "";
String nbrActMathScore= "";
String nbrActReadingScore = "";
String nbrActScienceScore = "";
String nbrActWritingScore = "";
String nbrActTotalScore = "";
String dtSatTestTaken = "";
String nbrSatMathScore= "";
String nbrSatVerbalScore= "";
String nbrSatWritingScore= "";
String nbrSatTotalScore= "";
String hdnIdCollegeExam = "";


//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
CollegeEntranceExamRetrieveSO collegeExam = null;
collegeExam = (CollegeEntranceExamRetrieveSO) state.getAttribute("RETRIEVESO", request);

String pageMode = PageMode.getPageMode(request);

if (collegeExam != null) {
  cdExamType = collegeExam.getCdExamType();
  hdnPersonId = FormattingHelper.formatInt(collegeExam.getIdPerson());
  hdnIdCollegeExam = FormattingHelper.formatInt(collegeExam.getIdCollegeExam());
  
  if("ACT".equals(cdExamType)){  
    dtActTestTaken = FormattingHelper.formatDate(collegeExam.getDtTestTaken());
	nbrActEnglishScore = FormattingHelper.formatInt(collegeExam.getNbrEnglishScore());
	nbrActMathScore = FormattingHelper.formatInt(collegeExam.getNbrMathScore());
	nbrActReadingScore = FormattingHelper.formatInt(collegeExam.getNbrReadingScore());
	nbrActScienceScore = FormattingHelper.formatInt(collegeExam.getNbrScienceScore());
	nbrActWritingScore = FormattingHelper.formatInt(collegeExam.getNbrWritingScore());
	nbrActTotalScore = FormattingHelper.formatInt(collegeExam.getNbrTotalScore());
  } else if ("SAT".equals(cdExamType)){
    dtSatTestTaken = FormattingHelper.formatDate(collegeExam.getDtTestTaken());
	nbrSatMathScore = FormattingHelper.formatInt(collegeExam.getNbrMathScore());
	nbrSatVerbalScore = FormattingHelper.formatInt(collegeExam.getNbrVerbalScore());
	nbrSatWritingScore = FormattingHelper.formatInt(collegeExam.getNbrWritingScore());
	nbrSatTotalScore = FormattingHelper.formatInt(collegeExam.getNbrTotalScore());
  }
} 

hdnPersonId = FormattingHelper.formatInt(GlobalData.getUlIdPerson(request));

    
    
    
//****************** 
//*** JAVASCRIPT ***
//******************


      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\n</script>\r\n");
//*************************
  //*** VALIDATION ERRORS ***
  //*************************

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

      //********************************************
      //**** FORM (Payment of Care) STARTS HERE ****
      //********************************************

      
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCollegeEntranceExam");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("person/CollegeEntranceExam/displayCollegeExam");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.CollegeEntranceExamCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\r\n\t\r\n<input type=\"hidden\" name=\"hdnPersonId\" value=\"");
          out.print(hdnPersonId);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnIdCollegeExam\" value=\"");
          out.print(hdnIdCollegeExam);
          out.write("\">\r\n\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n<tr><th colspan=\"4\">ACT Test</th></tr>\r\n\r\n    <tr>\r\n         <td>\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Test Taken");
          _jspx_th_impact_validateDate_0.setName("dtActTestTaken");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue( dtActTestTaken );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setLabel("English Score");
          _jspx_th_impact_validateInput_0.setName("nbrActEnglishScore");
          _jspx_th_impact_validateInput_0.setValue( nbrActEnglishScore );
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setMaxLength("6");
          _jspx_th_impact_validateInput_0.setSize("10");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n\t<tr>\r\n        <td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setLabel("Math Score");
          _jspx_th_impact_validateInput_1.setName("nbrActMathScore");
          _jspx_th_impact_validateInput_1.setValue( nbrActMathScore );
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setMaxLength("6");
          _jspx_th_impact_validateInput_1.setSize("10");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n\t<tr>\r\n        <td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setLabel("Reading Score");
          _jspx_th_impact_validateInput_2.setName("nbrActReadingScore");
          _jspx_th_impact_validateInput_2.setValue( nbrActReadingScore );
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setMaxLength("6");
          _jspx_th_impact_validateInput_2.setSize("10");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n\t<tr>\r\n        <td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setLabel("Science Score");
          _jspx_th_impact_validateInput_3.setName("nbrActScienceScore");
          _jspx_th_impact_validateInput_3.setValue( nbrActScienceScore );
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setMaxLength("6");
          _jspx_th_impact_validateInput_3.setSize("10");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n\t<tr>\r\n        <td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Writing Score");
          _jspx_th_impact_validateInput_4.setName("nbrActWritingScore");
          _jspx_th_impact_validateInput_4.setValue( nbrActWritingScore );
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setMaxLength("6");
          _jspx_th_impact_validateInput_4.setSize("10");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n\t<tr>\r\n        <td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setLabel("Total Score");
          _jspx_th_impact_validateInput_5.setName("nbrActTotalScore");
          _jspx_th_impact_validateInput_5.setValue( nbrActTotalScore );
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setMaxLength("6");
          _jspx_th_impact_validateInput_5.setSize("10");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n<tr><th colspan=\"4\" class=\"tableBorder\">SAT Test</th></tr>\r\n\t<tr>\r\n         <td>\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Test Taken");
          _jspx_th_impact_validateDate_1.setName("dtSatTestTaken");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setValue( dtSatTestTaken );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n    </tr>\r\n    <tr>\r\n        <td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setLabel("Math Score");
          _jspx_th_impact_validateInput_6.setName("nbrSatMathScore");
          _jspx_th_impact_validateInput_6.setValue( nbrSatMathScore );
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setMaxLength("6");
          _jspx_th_impact_validateInput_6.setSize("10");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n\t<tr>\r\n        <td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("Verbal Score");
          _jspx_th_impact_validateInput_7.setName("nbrSatVerbalScore");
          _jspx_th_impact_validateInput_7.setValue( nbrSatVerbalScore );
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setMaxLength("6");
          _jspx_th_impact_validateInput_7.setSize("10");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n\t<tr>\r\n        <td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setLabel("Writing Score");
          _jspx_th_impact_validateInput_8.setName("nbrSatWritingScore");
          _jspx_th_impact_validateInput_8.setValue( nbrSatWritingScore );
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setMaxLength("6");
          _jspx_th_impact_validateInput_8.setSize("10");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n\t<tr>\r\n        <td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setLabel("Total Score");
          _jspx_th_impact_validateInput_9.setName("nbrSatTotalScore");
          _jspx_th_impact_validateInput_9.setValue( nbrSatTotalScore );
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setMaxLength("6");
          _jspx_th_impact_validateInput_9.setSize("10");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</td>\r\n\t</tr>\r\n</table>\t\r\n");

//*****************
//**** BUTTONS ****
//*****************

          out.write("\r\n<hr>\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t<tr>\r\n\t  <td class=\"alignRight\">\r\n\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setForm("frmCollegeEntranceExam");
          _jspx_th_impact_ButtonTag_0.setAction("/person/CollegeEntranceExam/saveCollegeEntranceExam");
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\t</tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
