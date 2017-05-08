package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Calendar;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilitySummaryDB;
import gov.georgia.dhr.dfcs.sacwis.web.fce.EligibilitySummaryConversation;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility;

public final class EligibilitySummary_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  public static final String MEDICAID_ELIGIBILITY_CODE_TABLE = CodesTables.CELIGMED;
  public static final String ELIGIBILITY_CODE_TABLE = CodesTables.CELIGIBI;
  public static final String REASON_ELIGIBILITY_CODE_TABLE = CodesTables.CELIGCHG;

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');


  String hdnCSupRefOutboundErrors = (String)request.getAttribute("cSupRefOutboundErrors");
  boolean showCSupRefOutboundErrors = (hdnCSupRefOutboundErrors!=null);
  EligibilitySummaryDB eligibilitySummaryDB =
          (EligibilitySummaryDB) request.getAttribute("EligibilitySummaryDB");
  boolean isPrevEligCSupSend = eligibilitySummaryDB.getIndEligCsupSend();
  boolean isEligibilitySpecialist = FceUtility.isEligibilitySpecialist(request);
  boolean isBillingSpecialist = FceUtility.isBillingSpecialist(request);
  String eventStatus = eligibilitySummaryDB.getCdEventStatus();
  String pageMode = PageMode.getPageMode(request);
  boolean endDated = (!(eligibilitySummaryDB.getDtEligEnd() == null) && !DateHelper.MAX_JAVA_DATE.equals(eligibilitySummaryDB.getDtEligEnd()));

  boolean actualEligibilityDisabled = true;
  boolean medicaidEligibilityDisabled = true;
  boolean selectedEligibilityDisabled = true;
  boolean startDateDisabled = true;
  boolean endDateDisabled = true;
  boolean redeterminationDateDisabled = true;
  boolean eligibilityReasonDisabled = true;
  boolean childSupportQuestionDisabled = true;
  boolean childSupportReferralDateDisabled = true;
  boolean commentsDisabled = true;
  boolean passwordDisabled = true;
  boolean saveDisabled = true;
  boolean deleteDisabled = true;
  //STGAP00006420:Added the if check to see if the user has special access to modify
  // an approved Eligibility Summary.
  boolean modifyEndDateAccess = false;
  UserProfile user = UserProfileHelper.getUserProfile(request);
      if(user.hasRight(UserProfile.SEC_MODIFY_END_DATED_ELLIG)){
           modifyEndDateAccess = true;
      }
  
  //SIR23345 - Added ability to edit page if event status is in progress.
  if (PageModeConstants.EDIT.equals(pageMode)) {
    if (((isBillingSpecialist) ||
        (isEligibilitySpecialist)) &&
         ((eventStatus.equals(EventHelper.NEW_EVENT)) || (eventStatus.equals(EventHelper.APPROVED_EVENT) && !endDated))) {
      actualEligibilityDisabled = false;
      medicaidEligibilityDisabled = false;
      selectedEligibilityDisabled = false;
      startDateDisabled = false;
      endDateDisabled = false;
      redeterminationDateDisabled = false;
      eligibilityReasonDisabled = false;      
      childSupportQuestionDisabled = false;
      childSupportReferralDateDisabled = false;
      commentsDisabled = false;
      passwordDisabled = false;
      saveDisabled = false;
    }
    if ((isBillingSpecialist == false) &&
        (isEligibilitySpecialist) &&
        (eventStatus.equals(EventHelper.APPROVED_EVENT) && !endDated)) {
      endDateDisabled = false;
      commentsDisabled = false;
      passwordDisabled = false;
      saveDisabled = false;
    }
    if (eligibilitySummaryDB.getIndEligCsupSend()){
      childSupportQuestionDisabled = true;
      childSupportReferralDateDisabled = true;
    }
    if (!saveDisabled && eventStatus.equals(EventHelper.NEW_EVENT)) {
      int age = DateHelper.getAge(eligibilitySummaryDB.getDtChildBirth());
      // SIR 23012 - If the child is over 16
      if (age > 16) {

      out.write("\r\n<script type=\"text/javascript\" language=\"javascript\">\r\n  var over17 = true;\r\n</script>\r\n");

    //SIR 23719 - Changed age to 22
  }
  if (age >= 22) {

    //SIR 23719 - Changed over20 to overMaxAge

      out.write("\r\n<script type=\"text/javascript\" language=\"javascript\">\r\n  var overMaxAge = true;\r\n</script>\r\n");

      }
    }
    if (((isEligibilitySpecialist) || (isBillingSpecialist)) &&
        (eventStatus.equals(EventHelper.NEW_EVENT))) {
      deleteDisabled = false;
    }
  }

  //Keep comments section editable always, for scrollbars
  commentsDisabled = false;
  //STGAP00006420:Added the if check to see if the user has special access to modify
  // an approved Eligibility Summary and enable the appropriate set of fields.
  boolean commentsDisabled1 = commentsDisabled;
  if(modifyEndDateAccess){
      if (!endDated && GlobalData.hasStageAccess(request)) {
          //STGAP00008339 : Added this check so that a user who is a secondary worker to the stage and has the special
          //modify attribute can edit all the fields (including the comments field)when the record is not end dated.
          //All the fields are enabled in this mode already
        } else {
          medicaidEligibilityDisabled = false;
          selectedEligibilityDisabled = false;
          redeterminationDateDisabled = false;
          eligibilityReasonDisabled = false;
          actualEligibilityDisabled = false;
          passwordDisabled = false;
          commentsDisabled1 = true;
          startDateDisabled = false;
          endDateDisabled = false;
          saveDisabled = false;
        }
  }
  
  int tabIndex = 1;
  String formName = "EligibilitySummary";

      out.write("\r\n<script type=\"text/javascript\" language=\"javascript\">\r\n  function toDate(string) {\r\n    if ((string == null) ||\r\n        (string == \"\")) {\r\n      return null;\r\n    }\r\n    return new Date(string);\r\n  }\r\n\r\n  function compareDate(date1, date2) {\r\n    var difference = (date1.getYear() - date2.getYear());\r\n    if (difference != 0) {\r\n      return difference;\r\n    }\r\n    difference = (date1.getMonth() - date2.getMonth());\r\n    if (difference != 0) {\r\n      return difference;\r\n    }\r\n    difference = (date1.getDate() - date2.getDate());\r\n    return difference;\r\n  }\r\n\r\n  function deleteSummary() {\r\n    disableValidation('");
      out.print( formName );
      out.write("');\r\n  }\r\n\r\n  function saveEligibilitySummary() {\r\n    var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n\r\n  ");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest( (eventStatus.equals(EventHelper.NEW_EVENT) == false) );
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    //?From csub23w.win\r\n    //  If the Billing Specialist\r\n    //      changes the selectedEligibility\r\n    //      or changes the medicaidEligibility\r\n    //      or makes the startDate > previousStartDate\r\n    //      or (makes the endDate < currentDate && endDate < previousEndDate)\r\n    //  Billing Specialist is prompted with the MSG_SUB_AFFECT_PYMT confirmation\r\n\r\n    //don't trust the client's system date\r\n    var currentDate = new Date(\"");
          out.print( FormattingHelper.formatDate(new Date()) );
          out.write("\");\r\n\r\n    var onLoadSelectedEligibility = form.onLoadSelectedEligibility.value;\r\n    var onLoadMedicaid = form.onLoadMedicaid.value;\r\n    var onLoadStartDate = toDate(form.onLoadStartDate.value);\r\n    var onLoadEndDate = toDate(form.onLoadEndDate.value);\r\n\r\n    var selectedEligibility = form.cdEligSelected.value;\r\n    var medicaidEligibility = form.cdEligMedEligGroup.value;\r\n    var startDate = toDate(form.dtEligStartString.value);\r\n    var endDate = toDate(form.dtEligEndString.value);\r\n\r\n    var selectedEligibilityChanged =\r\n            ((onLoadSelectedEligibility != null) &&\r\n             (onLoadSelectedEligibility != \"\") &&\r\n             (onLoadSelectedEligibility != selectedEligibility));\r\n\r\n    var medicaidEligibilityChanged =\r\n            ((onLoadMedicaid != null) &&\r\n             (onLoadMedicaid != \"\") &&\r\n             (onLoadMedicaid != medicaidEligibility));\r\n\r\n    //      or makes the startDate > previousStartDate\r\n    var startDateCheck =\r\n            ((onLoadStartDate != null) &&\r\n             (compareDate(startDate, onLoadStartDate) > 0));\r\n");
          out.write("\r\n    //      or (makes the endDate < currentDate && endDate < previousEndDate)\r\n    var endDateCheck =\r\n            ((endDate != null) &&\r\n             (compareDate(endDate, currentDate) < 0) &&\r\n             ((onLoadEndDate == null) || (compareDate(endDate, onLoadEndDate) < 0)))\r\n\r\n    if ((selectedEligibilityChanged) ||\r\n        (medicaidEligibilityChanged) ||\r\n        (startDateCheck) ||\r\n        (endDateCheck)) {\r\n      var message =\r\n              \"");
          out.print( MessageLookup.getMessageByNumber(Messages.MSG_SUB_AFFECT_PYMT) );
          out.write("\";\r\n\r\n      if (window.confirm(message) == false) {\r\n        return false;\r\n      }\r\n      form.indEligWriteHistory.value = \"true\";\r\n    }\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    enableValidation('");
      out.print( formName );
      out.write("');\r\n    return true;\r\n  }\r\n  \r\n  function populateCsupRefDate (){\r\n    if( document.EligibilitySummary.indEligCsupSend[0].checked){\r\n");
 
  Date currentDate = new Date();
  String reffDate = FormattingHelper.formatDate(currentDate);

      out.write("      \r\n      document.EligibilitySummary.dtEligCsupReferralString.value = \"");
      out.print( reffDate );
      out.write("\";\r\n    } else {\r\n      document.EligibilitySummary.dtEligCsupReferralString.value = \"\";\r\n    }\r\n  }\r\n</script>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName( formName );
      _jspx_th_impact_validateForm_0.setDefaultButton( String.valueOf(deleteDisabled) );
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fce.EligibilitySummaryCustomValidation");
      _jspx_th_impact_validateForm_0.setAction("/not/a/real/path");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName( EligibilitySummaryDB.CD_APPLICATION );
          _jspx_th_impact_validateInput_0.setValue( eligibilitySummaryDB.getCdApplication() );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest( (eligibilitySummaryDB.getIndEligibleObject() != null) );
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_validateInput_1.setType("hidden");
              _jspx_th_impact_validateInput_1.setName( EligibilitySummaryDB.IND_ELIGIBLE );
              _jspx_th_impact_validateInput_1.setValue( eligibilitySummaryDB.getIndEligibleString() );
              int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
              if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("onLoadSelectedEligibility");
          _jspx_th_impact_validateInput_2.setValue( eligibilitySummaryDB.getCdEligSelected() );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("onLoadMedicaid");
          _jspx_th_impact_validateInput_3.setValue( eligibilitySummaryDB.getCdEligMedEligGroup() );
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
          _jspx_th_impact_validateInput_4.setName("onLoadStartDate");
          _jspx_th_impact_validateInput_4.setValue( eligibilitySummaryDB.getDtEligStartString() );
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
          _jspx_th_impact_validateInput_5.setName("onLoadEndDate");
          _jspx_th_impact_validateInput_5.setValue( eligibilitySummaryDB.getDtEligEndString() );
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
          _jspx_th_impact_validateInput_6.setName( EligibilitySummaryDB.IND_ELIG_WRITE_HISTORY );
          _jspx_th_impact_validateInput_6.setValue( eligibilitySummaryDB.getIndEligWriteHistoryString() );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName( EligibilitySummaryDB.IND_REVIEW_CREATED );
          _jspx_th_impact_validateInput_7.setValue( eligibilitySummaryDB.getIndReviewCreatedString() );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName( EligibilitySummaryDB.ID_CASE );
          _jspx_th_impact_validateInput_8.setValue( eligibilitySummaryDB.getIdCaseString() );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName( EligibilitySummaryDB.ID_STAGE );
          _jspx_th_impact_validateInput_9.setValue( eligibilitySummaryDB.getIdStageString() );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName( EligibilitySummaryDB.ID_ELIGIBILITY_EVENT );
          _jspx_th_impact_validateInput_10.setValue( eligibilitySummaryDB.getIdEligibilityEventString() );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName( EligibilitySummaryDB.ID_FCE_APPLICATION );
          _jspx_th_impact_validateInput_11.setValue( eligibilitySummaryDB.getIdFceApplicationString() );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName( EligibilitySummaryDB.ID_FCE_ELIGIBILITY );
          _jspx_th_impact_validateInput_12.setValue( eligibilitySummaryDB.getIdFceEligibilityString() );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName( EligibilitySummaryDB.ID_FCE_REVIEW );
          _jspx_th_impact_validateInput_13.setValue( eligibilitySummaryDB.getIdFceReviewString() );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName( EligibilitySummaryDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME );
          _jspx_th_impact_validateInput_14.setValue( "" + eligibilitySummaryDB.getFceEligibilityDtLastUpdateTime() );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("BirthDate");
          _jspx_th_impact_validateInput_15.setValue( "" + eligibilitySummaryDB.getDtChildBirth() );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName(EligibilitySummaryDB.DT_CHILD_BIRTH_STRING);
          _jspx_th_impact_validateInput_16.setValue( "" + DateHelper.toCastorDate(eligibilitySummaryDB.getDtChildBirth()) );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n<table border=\"0\" width=\"100%\" class=\"tableBorder\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <th>System Derived Eligibility</th>\r\n  </tr>\r\n  ");

    boolean isCaps = FceConstants.CAPS.equals(eligibilitySummaryDB.getCdApplication());
    boolean isNtsc = FceConstants.NEW_TO_SUBCARE.equals(eligibilitySummaryDB.getCdApplication());
  
          out.write("\r\n\r\n  ");
          //  impact:if
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
          _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_if_0.setTest( (isCaps || isNtsc) );
          int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
          if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");
              //  impact:then
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
              _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
              int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
              if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n      <tr>\r\n        <td>A System Derived Eligibility is not available at this time.</td>\r\n      </tr>\r\n      <tr>\r\n        <td>");
                  out.print( (isNtsc) ? "Child is new to subcare." : "Child has a Redetermination." );
                  out.write("\r\n        </td>\r\n      </tr>\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n    ");
              //  impact:else
              gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
              _jspx_th_impact_else_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_else_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
              int _jspx_eval_impact_else_0 = _jspx_th_impact_else_0.doStartTag();
              if (_jspx_eval_impact_else_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n    ");
 if (eligibilitySummaryDB.getIndEligibleObject() != null) { 
                  out.write("\r\n      <tr>\r\n        <td>At initial Determination, this child is <b>");
                  out.print( eligibilitySummaryDB.getIndEligible() ? "" : "not " );
                  out.write("eligible</b> for Title IV-E\r\n          Assistance.\r\n        </td>\r\n      </tr>\r\n      ");
                  //  impact:ifThen
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
                  _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_else_0);
                  _jspx_th_impact_ifThen_2.setTest( (eligibilitySummaryDB.getIndEligible() == false) );
                  int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
                  if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n        <tr>\r\n          <td>\r\n            <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorderList\">\r\n              <tr>\r\n                <th class=\"thList\">Reasons Not Eligible</th>\r\n              </tr>\r\n              ");

                int i = 0;
                List reasonsNotEligible = eligibilitySummaryDB.getReasonsNotEligible();
                //for Conversion, there will not be a list of reasons not eligible
                if (reasonsNotEligible != null && reasonsNotEligible.size() > 0){
                  reasonsNotEligible = FceUtility.getPastTenseReasonsNotEligible(reasonsNotEligible, eligibilitySummaryDB.getCdApplication());
                  Iterator iterator = reasonsNotEligible.iterator();
                  while (iterator.hasNext()) {
                    String reason = (String) iterator.next();

                    i++;

                    String trClass = "odd";
                    if (i % 2 == 0) {
                      trClass = "even";
                    }
              
                      out.write("\r\n              <tr class=\"");
                      out.print( trClass );
                      out.write("\">\r\n                <td>");
                      out.print( reason );
                      out.write("\r\n                </td>\r\n              </tr>\r\n              ");

                  }
                }
              
                      out.write("\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      ");
                      int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n      ");
 }else{ 
                  out.write("\r\n      <tr>\r\n        <td>N/A</td>\r\n      </tr>\r\n      ");
}
                  out.write("\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_else_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_else_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</table>\r\n<!--SIR 23890 renamed BLOC to BSL -->\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"4\">Actual</th>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Actual Eligibility");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setDisabled( "" + actualEligibilityDisabled );
          _jspx_th_impact_validateSelect_0.setCodesTable( ELIGIBILITY_CODE_TABLE );
          _jspx_th_impact_validateSelect_0.setName( EligibilitySummaryDB.CD_ELIG_ACTUAL );
          _jspx_th_impact_validateSelect_0.setWidth("20%");
          _jspx_th_impact_validateSelect_0.setValue( eligibilitySummaryDB.getCdEligActual() );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <th colspan=\"4\">Reimbursability</th>\r\n</tr>\r\n<tr>\r\n  <td class=\"formlabel\">SSI:</td>\r\n  <td>");
          out.print( FormattingHelper.formatMoney(eligibilitySummaryDB.getAmtSsi()) );
          out.write("\r\n  </td>\r\n    <td colspan=\"2\">&nbsp;</td>\r\n <tr>\r\n  <td class=\"formlabel\">SUCCESS Class of Assistance Date:</td>\r\n  <td>");
          out.print( eligibilitySummaryDB.getDtSuccClassAssistanceString() );
          out.write("\r\n  </td>\r\n  <td class=\"formlabel\">SUCCESS Class of Assistance:</td>\r\n  <td>");
          out.print( StringHelper.isValid(eligibilitySummaryDB.getCdSuccessClassAssistance()) ? eligibilitySummaryDB.getCdSuccessClassAssistance() : "" );
          out.write("\r\n  </td>\r\n  <tr>\r\n    <td width=\"20%\">\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Selected Eligibility");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setDisabled( "" + selectedEligibilityDisabled );
          _jspx_th_impact_validateSelect_1.setCodesTable( ELIGIBILITY_CODE_TABLE );
          _jspx_th_impact_validateSelect_1.setName( EligibilitySummaryDB.CD_ELIG_SELECTED );
          _jspx_th_impact_validateSelect_1.setValue( eligibilitySummaryDB.getCdEligSelected() );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"20%\">\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Medicaid Class of Assistance");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setDisabled( "" + medicaidEligibilityDisabled );
          _jspx_th_impact_validateSelect_2.setCodesTable( MEDICAID_ELIGIBILITY_CODE_TABLE );
          _jspx_th_impact_validateSelect_2.setName( EligibilitySummaryDB.CD_ELIG_MED_ELIG_GROUP );
          _jspx_th_impact_validateSelect_2.setValue( eligibilitySummaryDB.getCdEligMedEligGroup() );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <th colspan=\"4\"> Eligibility Dates</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setLabel("Start Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setDisabled( "" + startDateDisabled );
          _jspx_th_impact_validateDate_0.setName( EligibilitySummaryDB.DT_ELIG_START_STRING );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setValue( eligibilitySummaryDB.getDtEligStartString() );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setLabel("End Date");
          _jspx_th_impact_validateDate_1.setName( EligibilitySummaryDB.DT_ELIG_END_STRING );
          _jspx_th_impact_validateDate_1.setDisabled( "" + endDateDisabled );
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setValue( eligibilitySummaryDB.getDtEligEndString() );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setLabel("Re-determination Date");
          _jspx_th_impact_validateDate_2.setName( EligibilitySummaryDB.DT_ELIG_REVIEW_STRING );
          _jspx_th_impact_validateDate_2.setDisabled( "" + redeterminationDateDisabled );
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setValue( eligibilitySummaryDB.getDtEligReviewString() );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Reason");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_3.setDisabled( "" + eligibilityReasonDisabled );
          _jspx_th_impact_validateSelect_3.setCodesTable( REASON_ELIGIBILITY_CODE_TABLE );
          _jspx_th_impact_validateSelect_3.setName( EligibilitySummaryDB.CD_FCE_ELIG_REASON );
          _jspx_th_impact_validateSelect_3.setValue( eligibilitySummaryDB.getCdFceEligReason() );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"4\">\r\n      <table cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n        <tr>\r\n          <th colspan=\"2\">Child Support Referral</th>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"16%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setName( EligibilitySummaryDB.IND_ELIG_CSUP_SEND );
          _jspx_th_impact_validateInput_17.setLabel("Yes");
          _jspx_th_impact_validateInput_17.setChecked( eligibilitySummaryDB.getIndEligCsupSendString() );
          _jspx_th_impact_validateInput_17.setValue("true");
          _jspx_th_impact_validateInput_17.setDisabled( "" + childSupportQuestionDisabled );
          _jspx_th_impact_validateInput_17.setType("radio");
          _jspx_th_impact_validateInput_17.setId("1");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setOnClick("populateCsupRefDate();");
          _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n               ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setName( EligibilitySummaryDB.IND_ELIG_CSUP_SEND );
          _jspx_th_impact_validateInput_18.setLabel("No");
          _jspx_th_impact_validateInput_18.setChecked(  "" + ArchitectureConstants.FALSE.equals(eligibilitySummaryDB.getIndEligCsupSendString()) );
          _jspx_th_impact_validateInput_18.setValue("false");
          _jspx_th_impact_validateInput_18.setDisabled( "" + childSupportQuestionDisabled );
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setId("2");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          _jspx_th_impact_validateInput_18.setOnClick("populateCsupRefDate();");
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          <td><span class=\"formCondRequiredText\">&#135;</span>&nbsp;Is this child being referred to child support</td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setName( EligibilitySummaryDB.DT_ELIG_CSUP_REFERRAL_STRING );
          _jspx_th_impact_validateInput_19.setLabel("Date of Referral");
          _jspx_th_impact_validateInput_19.setValue( eligibilitySummaryDB.getDtEligCsupReferralString() );
          _jspx_th_impact_validateInput_19.setRequired("false");
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          _jspx_th_impact_validateInput_19.setConstraint("Date");
          _jspx_th_impact_validateInput_19.setSize("10");
          _jspx_th_impact_validateInput_19.setMaxLength("10");
          _jspx_th_impact_validateInput_19.setDisabled( "" + childSupportReferralDateDisabled );
          _jspx_th_impact_validateInput_19.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n       </tr>\r\n       <tr>\r\n         <td valign=\"top\">\r\n           ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setName( EligibilitySummaryDB.TXT_CHILD_SUPP_REF_COMMENT );
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setDisabled( "" + commentsDisabled1 );
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setRows("2");
          _jspx_th_impact_validateTextArea_0.setCols("110");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.print( eligibilitySummaryDB.getTxtChildSuppRefComment() );
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n<table cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n  <tr>\r\n    <th colspan=\"2\">Foster Care Eligibility Approval</th>\r\n  </tr>\r\n  <tr>\r\n    <td valign=\"top\" width=\"20%\">\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setLabel("Comments");
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setName( EligibilitySummaryDB.TXT_ELIG_COMMENT );
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_1.setDisabled( "" + commentsDisabled );
          _jspx_th_impact_validateTextArea_1.setRows("2");
          _jspx_th_impact_validateTextArea_1.setCols("110");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.print( eligibilitySummaryDB.getTxtEligComment() );
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setLabel("Password");
          _jspx_th_impact_validateInput_20.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_20.setType("password");
          _jspx_th_impact_validateInput_20.setName("password");
          _jspx_th_impact_validateInput_20.setConstraint("Password");
          _jspx_th_impact_validateInput_20.setRequired("true");
          _jspx_th_impact_validateInput_20.setDisabled( "" + passwordDisabled );
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n<hr>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n   <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("Save");
          _jspx_th_impact_ButtonTag_0.setAccessKey("S");
          _jspx_th_impact_ButtonTag_0.setBackSafe("true");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setDisabled( "" + saveDisabled );
          _jspx_th_impact_ButtonTag_0.setAction( EligibilitySummaryConversation.FCE_SUMMARY_SAVE );
          _jspx_th_impact_ButtonTag_0.setFunction( "return saveEligibilitySummary();" );
          _jspx_th_impact_ButtonTag_0.setForm( formName );
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnPrevEligCSupSend\" value=\"");
          out.print(isPrevEligCSupSend );
          out.write("\">\r\n\r\n\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<script type=\"text/javascript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  ");
  // SIR 19326 - Do not call isDirty() for modifiable textarea when saveDisabled is true
    if ( !saveDisabled ) {
  
      out.write("\r\n  window.onbeforeunload = function() {\r\n    return IsDirty();\r\n  }\r\n  ");
 } 
      out.write("\r\n\r\n  function promptToIgnoreErrorMessages() {\r\n  ");

  //MDM: I could figure out which one of these my error message was supposed to go in
  // and then have the architecture change and none of this work:
  //   FormValidation form = (FormValidation) request.getAttribute(formName);
  //   Map errorMessages = form.getErrorMessages();
  //   Map nonValidationErrorMessages = (Map) request.getAttribute(BasePrsConversation.ERROR_MESSAGES);
  //   Map informationalMessages = (Map) request.getAttribute(BasePrsConversation.INFO_MESSAGES);
  //MDM: OR I can rely on variables explicitly set in the conversation (I choose to do this):

   Set ignoreMessages = EligibilitySummaryConversation.getIgnoreMessages(request);
   Set errorCodes = EligibilitySummaryConversation.getErrorCodes(request);
   Set checkConfirmationErrorCodes = new HashSet();
   checkConfirmationErrorCodes.add(new Integer(Messages.MSG_SUB_AFFECT_PYMT));
   checkConfirmationErrorCodes.add(new Integer(Messages.MSG_SUB_GAP_EXISTS_1));
   checkConfirmationErrorCodes.add(new Integer(Messages.MSG_SUB_GAP_EXISTS_2));
   checkConfirmationErrorCodes.add(new Integer(Messages.MSG_SUB_GAP_EXISTS_3));

   //performs intersection of errorCodes and checkConfirmationErrorCodes
   errorCodes.retainAll(checkConfirmationErrorCodes);

   if (errorCodes.isEmpty()) {
     out.println("return;");
   }

   Iterator it = errorCodes.iterator();
   while (it.hasNext()) {
     Integer integer = (Integer) it.next();
     int errorCode = integer;
     String errorMessage = MessageLookup.getMessageByNumber(errorCode);

     out.println(" if (confirm(\"" + errorMessage + "\") == false)");
     out.println(" {");
     out.println("   return;");
     out.println(" }");
   }

   String ignoreAllUrl = EligibilitySummaryConversation.FCE_SUMMARY_SAVE + "?";
   errorCodes.addAll(ignoreMessages);

   it = errorCodes.iterator();
   while (it.hasNext()) {
     Integer integer = (Integer) it.next();
     int errorCode = integer;

     ignoreAllUrl += "ignoreMessage=" + errorCode + "&";
   }
  
      out.write("\r\n    enableValidation(\"");
      out.print( formName );
      out.write("\");\r\n    submitValidateForm('");
      out.print( formName );
      out.write("', '");
      out.print( ignoreAllUrl );
      out.write("');\r\n\r\n  }\r\n\r\n  window.onload = function ()\r\n  {\r\n    if (");
      out.print(showCSupRefOutboundErrors);
      out.write(") {\r\n      alert('");
      out.print(hdnCSupRefOutboundErrors);
      out.write("');\r\n    }\r\n    promptToIgnoreErrorMessages();\r\n  };\r\n  \r\n</script>\r\n");

  //SIR 23283 - Added && age > 16 to if statement to avoid a javascript error.
  //Sir 23012 Show informational Message about setting the review date if event
  //is in New Status
  int age = DateHelper.getAge(eligibilitySummaryDB.getDtChildBirth());
  if (eventStatus.equals(EventHelper.NEW_EVENT) && age > 16) {

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript\">\r\n  if (over17 == true) {\r\n    var sTotalMsgInfo = \"");
      out.print( MessageLookup.getMessageByNumber (Messages.MSG_FCE_SPECIAL_REVIEW));
      out.write("\";\r\n    displayInfoMsgs(sTotalMsgInfo, EligibilitySummary);\r\n  }\r\n  ");

    //SIR 23719 - Changed over20 to overMaxAge and changed Error message Name
  
      out.write("\r\n  if (overMaxAge == true) {\r\n    var sTotalMsgInfo = \"");
      out.print( MessageLookup.getMessageByNumber (Messages.MSG_FCE_DENIED_MAX_AGE));
      out.write("\";\r\n    displayInfoMsgs(sTotalMsgInfo, EligibilitySummary);\r\n  }\r\n</script>\r\n");

  }

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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
