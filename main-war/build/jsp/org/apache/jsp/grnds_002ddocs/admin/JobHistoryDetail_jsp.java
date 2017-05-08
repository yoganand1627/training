package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class JobHistoryDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 * JSP Name:     JobHistoryDetail.jsp
 * Created by:   Jeff Chambers
 * Date Created: 10/23/02
 *
 * Description:
 * Allows the user to enter Job information and use the Save button to save the
 * job history row and return to the Staff Detail page.
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/01/03  Todd Reser        Added Change Log and Flowerbox comments.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String pageMode = PageMode.getPageMode( request );

  int tabIndex = 1;
  int personId = GlobalData.getUlIdPerson( request );

//if pagemode is ADD, all fields should be enabled
//if pagemode is Modify and index = 0, can only modify case assignable
//and end date
//otherwise pagemode is browse
  String jobHistoryDisabled = "false";

  if (  ContextHelper.getIntSafe( request, "jobHistoryIndex" ) != 0 )
  {
    pageMode = PageModeConstants.INQUIRE;
  }
  else
  {
    if ( !pageMode.equals(PageModeConstants.NEW) )
    {
    jobHistoryDisabled = "true";
    }
  }

  ROWCCMN04SOG02 jobHistory = null;

  if ( request.getAttribute( "ROWCCMN04SOG02" ) != null &&
      !pageMode.equals(PageModeConstants.NEW) )
  {
    jobHistory = (ROWCCMN04SOG02)request.getAttribute("ROWCCMN04SOG02");
  }
  else
  {
    jobHistory = new ROWCCMN04SOG02();
  }

  String pcn = jobHistory.getSzBjnJob();
  String jobClass = jobHistory.getSzCdJobClass();
  String endDate = FormattingHelper.formatDate(jobHistory.getDtDtJobEnd());
  String supervisor = "";
  String jobFunction = "";
  int jobHistoryId = 0;
  int supervisorId = 0;
  // ***** int JobId = jobHistory.getUlIdEmpJobHistory();
  java.util.Date lastUpdate = null;
  String jobAssignable = "";

  org.exolab.castor.types.Date startDate = null;
  if (pageMode.equals(PageModeConstants.NEW))
  {
    supervisor = (String) request.getAttribute("supervisorName");
    supervisorId = Integer.parseInt((String) request.getAttribute("supervisorId"));
    jobFunction = "";
    lastUpdate = null;
    startDate = DateHelper.toCastorDate(new java.util.Date());
  }
  else
  {
    supervisor = jobHistory.getSzNmPersonFull();
    supervisorId = jobHistory.getUlIdJobPersSupv();
    jobFunction = jobHistory.getSzCdJobFunction();
    lastUpdate = jobHistory.getTsLastUpdate();
    startDate = jobHistory.getDtDtJobStart();
    jobHistoryId = jobHistory.getUlIdEmpJobHistory();
  }

  if (jobHistory.getBIndJobAssignable() == null)
  {
    jobAssignable = "N";
  }
  else
  {
    jobAssignable = jobHistory.getBIndJobAssignable();
  }

  String lastUpdateString = "";

  if ( lastUpdate == null )
  {
    lastUpdateString = "";
  }
  else
  {
    lastUpdateString = String.valueOf( lastUpdate );
  }

String pcn_prev = "";
String jobClass_prev = "";
String supervisor_prev = "";
org.exolab.castor.types.Date startDate_prev = null;
org.exolab.castor.types.Date endDate_prev = null;
String endDatePrevDisabled = "true";
String jobAssignable_prev = "";
if( pageMode.equals(PageModeConstants.NEW))
{
  CCMN04SO ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);
  pcn_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getSzBjnJob();
  jobClass_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getSzCdJobClass();
  supervisor_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getSzNmPersonFull();
  startDate_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getDtDtJobStart();
  if(ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getDtDtJobEnd() == null)
  {
    endDate_prev = null;
  }
  else
  {
    endDate_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getDtDtJobEnd();
  }
  //use end date from service if not null and pagemode is new
  //if end date is already filled, should not be editable????
  if (endDate_prev == null )
  {
    endDatePrevDisabled = "false";
  }
  if(endDate_prev == null && pageMode.equals(PageModeConstants.NEW) )
  {
    endDate_prev = startDate;
  }


  if ( ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getBIndJobAssignable() == null)
  {
    jobAssignable_prev = "N";
  }
  else
  {
    jobAssignable_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getBIndJobAssignable();
  }
}

      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmJobHistory");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/StaffSearch/saveJobHistoryDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.JobHistoryCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnTsLastUpdate");
          _jspx_th_impact_validateInput_1.setValue( lastUpdateString );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnUlIdPerson");
          _jspx_th_impact_validateInput_3.setValue( String.valueOf( personId ));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnUlIdJobPersSupv");
          _jspx_th_impact_validateInput_4.setValue( String.valueOf( supervisorId ) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnSzCdJobFunction");
          _jspx_th_impact_validateInput_5.setValue( String.valueOf( jobFunction ) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnUlIdEmpJobHistory");
          _jspx_th_impact_validateInput_6.setValue( String.valueOf( jobHistoryId ) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n  ");
 if (pageMode.equals(PageModeConstants.NEW))
    { 
          out.write("\r\n  <th colspan=\"6\">New Job History</th>\r\n   ");
 }
   else
   { 
          out.write("\r\n  <th colspan=\"6\">Job History</th>\r\n   ");
 } 
          out.write("\r\n  </tr>\r\n  <tr>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("PCN");
          _jspx_th_impact_validateInput_7.setConstraint("AlphaNumeric8");
          _jspx_th_impact_validateInput_7.setRequired("true");
          _jspx_th_impact_validateInput_7.setName("txtSzBjnJob");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setDisabled( jobHistoryDisabled );
          _jspx_th_impact_validateInput_7.setValue( pcn );
          _jspx_th_impact_validateInput_7.setSize("15");
          _jspx_th_impact_validateInput_7.setMaxLength("8");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Class");
          _jspx_th_impact_validateSelect_0.setOrderBy("decode");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setName("cboSzCdJobClass");
          _jspx_th_impact_validateSelect_0.setCodesTable("CEMPJBCL");
          _jspx_th_impact_validateSelect_0.setDisabled( jobHistoryDisabled );
          _jspx_th_impact_validateSelect_0.setValue( jobClass );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n     <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtJobStart");
          _jspx_th_impact_validateDate_0.setLabel("Start Date");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setDisabled( jobHistoryDisabled );
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate( startDate ) );
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("txtDtJobEnd");
          _jspx_th_impact_validateDate_1.setLabel("End Date");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setRequired("false");
          _jspx_th_impact_validateDate_1.setValue( endDate );
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setColspan("2");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtSzNmPersonFull");
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Supervisor");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( supervisor );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setValue( jobAssignable );
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setChecked( jobAssignable );
          _jspx_th_impact_validateInput_8.setName("cbxbIndJobAssignable");
          _jspx_th_impact_validateInput_8.setLabel("Case Assignable");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  ");
 if (pageMode.equals(PageModeConstants.NEW))
    { 
          out.write("\r\n    <tr>\r\n  <th colspan=\"6\">Existing Job History</th>\r\n  </tr>\r\n  <tr>\r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setLabel("PCN");
          _jspx_th_impact_validateInput_9.setConstraint("AlphaNumeric8");
          _jspx_th_impact_validateInput_9.setName("txtSzBjnJob_prev");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setDisabled("true");
          _jspx_th_impact_validateInput_9.setValue( pcn_prev );
          _jspx_th_impact_validateInput_9.setSize("15");
          _jspx_th_impact_validateInput_9.setMaxLength("8");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n  <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Class");
          _jspx_th_impact_validateSelect_1.setOrderBy("decode");
          _jspx_th_impact_validateSelect_1.setName("cboSzCdJobClass_prev");
          _jspx_th_impact_validateSelect_1.setCodesTable("CEMPJBCL");
          _jspx_th_impact_validateSelect_1.setDisabled("true");
          _jspx_th_impact_validateSelect_1.setValue( jobClass_prev );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n     <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setName("txtDtJobStart_prev");
          _jspx_th_impact_validateDate_2.setLabel("Start Date");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setDisabled("true");
          _jspx_th_impact_validateDate_2.setValue( FormattingHelper.formatDate( startDate_prev ) );
          _jspx_th_impact_validateDate_2.setSize("8");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n     <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setName("txtDtJobEnd_prev");
          _jspx_th_impact_validateDate_3.setLabel("End Date");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          _jspx_th_impact_validateDate_3.setRequired("false");
          _jspx_th_impact_validateDate_3.setValue( FormattingHelper.formatDate( endDate_prev ) );
          _jspx_th_impact_validateDate_3.setDisabled( endDatePrevDisabled );
          _jspx_th_impact_validateDate_3.setSize("8");
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_3.setColspan("2");
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtSzNmPersonFull_prev");
          _jspx_th_impact_validateDisplayOnlyField_1.setColspan("3");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Supervisor");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( supervisor_prev );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setValue( jobAssignable );
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setDisabled("true");
          _jspx_th_impact_validateInput_10.setChecked( jobAssignable_prev );
          _jspx_th_impact_validateInput_10.setName("cbxbIndJobAssignable_prev");
          _jspx_th_impact_validateInput_10.setLabel("Case Assignable");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n");
 } 
          out.write("\r\n</table>\r\n");
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmJobHistory");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/StaffSearch/saveJobHistoryDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateErrors_0.setFormName("frmJobHistory");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_2.setName("hdnDisplayType");
    _jspx_th_impact_validateInput_2.setValue("Modify");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
