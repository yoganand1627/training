package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExamDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.ExamDetailConversation;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public final class ExamDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*********************
//*** SET PAGE MODE ***
//*********************

  String pageMode = PageMode.getPageMode(request);

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
  int tabIndex = 1;
  String examDate = "";
  String examType = "";
  String score ="";
  String passed = "";
  String firstAttempt = "";
  String examTypeCat = "";
  String codesTable = "";
    
  
//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
                                                                       
                                                     
  
//**************************
//*** RETRIEVE PAGE DATA ***
//**************************   
  ExamDetailRetrieveSO examDetail = (ExamDetailRetrieveSO) state.getAttribute("ExamDetailRetrieveSO", request);
  String hdnExamType = (String) request.getParameter("hdnExamCat");
  String hdnExamId = (String) request.getParameter("hdnExamId");
  if(examDetail!=null) {
    if (ArchitectureConstants.Y.equals(examDetail.getIndGed())) {
      examTypeCat = ExamDetailConversation.GED_EXAM;
    } else if (ArchitectureConstants.N.equals(examDetail.getIndGed())) {
      examTypeCat = ExamDetailConversation.HS_EXAM;
    }
    if(examDetail.getCdExamType()!=null) {
      examType = examDetail.getCdExamType();
    }
    if(examDetail.getDtExam()!=null) {  
      examDate = FormattingHelper.formatDate(examDetail.getDtExam());
    }
    if(examDetail.getNbrScore()!= 0) {
      score = FormattingHelper.formatInt(examDetail.getNbrScore());
    }
    if(examDetail.getIndPassed()!= null) {
      passed = examDetail.getIndPassed();
    }
    if(examDetail.getIndFirstAtmpt()!= null) {
      firstAttempt = examDetail.getIndFirstAtmpt();
    }
  } else {
    examTypeCat = hdnExamType;
  }
  
                 

      out.write("\r\n\r\n\r\n");


//**************************
//**** FORM STARTS HERE ****
//**************************
 
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmExamDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/ExamDetail/displayExamDetail");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.ExamDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  ");
 /*  Always include this hidden field in your form */ 
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n\r\n  ");
// Begin Detail

      
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"8\" align=\"left\">\r\n        Examination\r\n      </th>\r\n    </tr>\r\n    <tr></tr>\r\n    <tr>\r\n    ");
 if(ExamDetailConversation.GED_EXAM.equals(examTypeCat)) { 
         codesTable = CodesTables.CGED;
       } else {
         codesTable = CodesTables.CGRAD;
       }
    
          out.write("\r\n      <td colspan=\"1\">\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setLabel("Exam Type");
          _jspx_th_impact_validateSelect_0.setId("cdExamType");
          _jspx_th_impact_validateSelect_0.setName("cdExamType");
          _jspx_th_impact_validateSelect_0.setWidth("20%");
          _jspx_th_impact_validateSelect_0.setValue(examType );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable(codesTable );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n        \r\n      <td colspan=\"1\">\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Date Of Exam");
          _jspx_th_impact_validateDate_0.setName("dtExam");
          _jspx_th_impact_validateDate_0.setValue(examDate);
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setWidth("20%");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td> \r\n      <td colspan=\"1\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setLabel(" Score");
          _jspx_th_impact_validateInput_0.setName("txtScore");
          _jspx_th_impact_validateInput_0.setConstraint("Digit3Less");
          _jspx_th_impact_validateInput_0.setMaxLength("3");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setValue(score );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>  \r\n     </tr>   \r\n     <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setLabel("First Attempt");
          _jspx_th_impact_validateInput_1.setChecked( (("".equals(firstAttempt)) || (ArchitectureConstants.N.equals(firstAttempt))) ? "false" : "true" );
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setValue("Y");
          _jspx_th_impact_validateInput_1.setName("cbxFirstAtmpt");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td></td>\r\n     <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setLabel("Passed");
          _jspx_th_impact_validateInput_2.setChecked( (("".equals(passed)) || (ArchitectureConstants.N.equals(passed))) ? "false" : "true" );
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setValue("Y");
          _jspx_th_impact_validateInput_2.setName("cbxPassed");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td> \r\n       </tr>\r\n  </table>\r\n\r\n  ");
//*****************
    //**** BUTTONS ****
    //*****************
    // Display the Save and delete buttons unless the page mode is VIEW.  
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td colspan=\"4\">\r\n        <br>\r\n        <hr>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n    ");
 if (!PageModeConstants.VIEW.equals(pageMode)) {
          out.write("\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmExamDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/person/ExamDetail/saveExamDetail");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    ");
}
          out.write("\r\n    </tr>\r\n  </table>\r\n  <br>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n\r\n");
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
