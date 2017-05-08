package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.service.ServiceHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FosterCareReviewDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FosterCareReviewConversation;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;

public final class FosterCareReview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/fce/IncomeListSub.jsp");
    _jspx_dependants.add("/grnds-docs/fce/ResourceListSub.jsp");
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

      out.write('\r');
      out.write('\n');

  //*  JSP Name:     Foster Care Review
  //*  Created by:   J Heather Dean
  //*  Date Created: 03/11/03
  //*
  //*  Description:
  //*  The FC Review Application is required when a child is scheduled for a
  //*  review of his or her eligibility status.  Most of the sections on this page
  //*  are pre-filled based on the information entered on the Foster Care
  //*  Application pages or in other parts of IMPACT.
  /*
   Change History:
   Date      User              Description
   --------  ---------------- --------------------------------------------------
   08/06/03  Todd Reser       Added Description to Flowerbox.
   08/09/04  Todd Reser       SIR 23012 - Supress the display of two Extended
   Education Questions if the person is under 18.
   10/25/04  Todd Reser       Sir 23012 - Had to add JavaScript calls to the Show
   Functions to display the questions when loading the
   page if the appropriate radio buttons were selected
   10/27/04  Todd Reser       Rewrote Javascript show/hide function and removed a
   conflicting segement of code from setupPage
   11/09/04  Todd Reser       Recoded if Statements upon page load for displaying
   or hiding complete and enrolled questions.
   09/19/05  berkime          SIR 23890 renamed BLOC to BSL
   12/07/10  Hai Nguyen       SMS#81144: MR-053 Removed Deprivation, Citizenship
                              ES Confirmation sections. Added Child Care section.
                              Added IV-E Budget Worksheet section. Remove button 
                              and logic for Determine Eligibility and 
                              confirmation Yes and No button.
   12/14/10  Hai Nguyen       SMS#81144: MR-053 Updated IV-E Budget Worksheet section
   12/29/10  hnguyen          SMS#89026: MR-053 Corrected IV-E Budget Resource Test 
                              and Judicial Requirement comment to not display if not applies. 
   01/19/10  hjbaptiste       SMS#81144: MR-053 Added the word Reimbursability to determination statement
                              at top of page
   01/24/10  hnguyen          SMS#81144: MR-053 Updated section title to display Reimbursability Determination                                                        
   02/09/11  Hai Nguyen       SMS#95590: Updated Judicial Requirement section to display extension order only
                              as required.
   02/11/11  Hai Nguyen       SMS#95590: Further updated logic to appropriately display judicial review
                              when necessary.
   02/12/11  Hai Nguyen       SMS#96233: Updated jsp to enable and disable buttons for COMP status. Continue button
                              to display only after Save have been clicked when in PEND status.
   */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String pageMode = PageMode.getPageMode(request);

  BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);

  int tabIndex = 1;
  String formName = "frmReview";
  String bgColor = "#F0FFFF";

  FosterCareReviewDB fosterCareReviewDB = (FosterCareReviewDB) state.getAttribute("FosterCareReviewDB", request);

  UserProfile userProfile = BasePrsConversation.getUserProfile(request);
  boolean userIsEligibilitySpecialist = userProfile.hasRight(UserProfile.SEC_ELIGIBILITY);

  String eventStatus = fosterCareReviewDB.getCdEventStatus();

  Integer pendingStageClosureEventId = (Integer) request
                                                        .getAttribute(FosterCareReviewConversation.STAGE_CLOSURE_EVENT_ID);


  if (pendingStageClosureEventId == null) {
    pendingStageClosureEventId = 0;
  }

  boolean disableIncomeCheckboxes = true;
  boolean disableInappropriateReview = true;
  boolean disableIncomeResourcesFields = true;

  //Determine continue button
  boolean showContinueButton = false;

  //submit application button
  boolean showSubmitButton = false;

  //show system-derived eligibility
  boolean showEligibility = false;

  boolean showSaveButton = false;

  //Determine page mode based on user rights and event status
  if (FosterCareReviewConversation.EVENT_STATUS_APRV.equals(eventStatus) 
        || FosterCareReviewConversation.EVENT_STATUS_COMP.equals(eventStatus)) {
    showEligibility = true;
  }

  if (FosterCareReviewConversation.EVENT_STATUS_PEND.equals(eventStatus)) {
    showEligibility = true;
    if (PageModeConstants.EDIT.equals(pageMode)) {
      disableIncomeResourcesFields = false;
      disableIncomeCheckboxes = false;
      disableInappropriateReview = false;
      showSaveButton = true;
      showContinueButton = false;
    }
  }
  
  if (FosterCareReviewConversation.EVENT_STATUS_NEW.equals(eventStatus) || FosterCareReviewConversation.EVENT_STATUS_PROC.equals(eventStatus)){
    if (PageModeConstants.EDIT.equals(pageMode)) {
      disableIncomeResourcesFields = false;
      disableIncomeCheckboxes = false;
      disableInappropriateReview = false;
      showSaveButton = true;
      showSubmitButton = true;
      showContinueButton = false;
    }
  }

  if (FosterCareReviewConversation.EVENT_STATUS_COMP.equals(eventStatus)){
    if (PageModeConstants.EDIT.equals(pageMode)) {
      disableIncomeResourcesFields = false;
      disableIncomeCheckboxes = false;
      disableInappropriateReview = false;
      showSaveButton = true;
      showContinueButton = true;
    }
  }

  String radioWidth = "7%";

      out.write("\r\n\r\n\r\n<script type=\"text/javascript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction alertEligibilitySpecialist()\r\n{\r\n");
      //  impact:ifThen
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
      _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ifThen_0.setParent(null);
      _jspx_th_impact_ifThen_0.setTest(((userIsEligibilitySpecialist == false) && (disableInappropriateReview == false)));
      int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
      if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  var x = document.");
          out.print(formName);
          out.write(";\r\n  if (x.indReviewInappropriate.checked == true)\r\n  {\r\n    alert(\"");
          out.print(MessageLookup.getMessageByNumber(Messages.MSG_NOTIFY_ELIGIBILITY_SPECIALIST));
          out.write("\");\r\n  }\r\n");
          int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n}\r\n\r\nfunction navigateToPersonDetail()\r\n{\r\n  setIsDirtyCalled(true);\r\n  disableValidation('");
      out.print(formName);
      out.write("');\r\n  submitValidateForm('");
      out.print(formName);
      out.write("',\r\n          '");
      out.print(FosterCareReviewConversation.DISPLAY_PERSON_DETAIL_COMMAND);
      out.write("');\r\n  return false;\r\n}\r\n\r\n\r\nfunction yes()\r\n{\r\n");

  if (pendingStageClosureEventId > 0)
  {

      out.write("\r\n  var MSG_CMN_INVLD_APRVL =\r\n          \"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL));
      out.write("\";\r\n  if (!confirm(MSG_CMN_INVLD_APRVL))\r\n  {\r\n    return false;\r\n  }\r\n");

  }

      out.write("\r\n//  disableValidation('");
      out.print(formName);
      out.write("');\r\n  return true;\r\n}\r\n\r\n</script>\r\n\r\n\r\n");
      //  impact:validateErrors
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
      _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateErrors_0.setParent(null);
      _jspx_th_impact_validateErrors_0.setFormName(formName);
      int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
      if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName(formName);
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fce/FosterCareReview/displayFosterCareReview2");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fce.FosterCareReviewCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnPendingStageClosureEventId");
          _jspx_th_impact_validateInput_0.setValue(String.valueOf(pendingStageClosureEventId));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("idFceApplication");
          _jspx_th_impact_validateInput_1.setValue(fosterCareReviewDB.getIdFceApplicationString());
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("idFceEligibility");
          _jspx_th_impact_validateInput_2.setValue(fosterCareReviewDB.getIdFceEligibilityString());
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("idFceReview");
          _jspx_th_impact_validateInput_3.setValue(fosterCareReviewDB.getIdFceReviewString());
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("idEvent");
          _jspx_th_impact_validateInput_4.setValue(fosterCareReviewDB.getIdEventString());
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("showEligibility");
          _jspx_th_impact_validateInput_5.setValue(String.valueOf(showEligibility));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("fceReviewDtLastUpdateTime");
          _jspx_th_impact_validateInput_6.setValue("" + fosterCareReviewDB.getFceReviewDtLastUpdateTime());
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("fceEligibilityDtLastUpdateTime");
          _jspx_th_impact_validateInput_7.setValue("" + fosterCareReviewDB.getFceEligibilityDtLastUpdateTime());
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("disableIncomeResourcesFields");
          _jspx_th_impact_validateInput_8.setValue(String.valueOf(disableIncomeResourcesFields));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("indRightsTerminated");
          _jspx_th_impact_validateInput_9.setValue("" + fosterCareReviewDB.getIndRightsTerminated());
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("indNoActivePlacement");
          _jspx_th_impact_validateInput_10.setValue("" + fosterCareReviewDB.getIndNoActivePlacement());
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("indNonPrsPaidPlacement");
          _jspx_th_impact_validateInput_11.setValue("" + fosterCareReviewDB.getIndNonPrsPaidPlacement());
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("indNoActiveBloc");
          _jspx_th_impact_validateInput_12.setValue("" + fosterCareReviewDB.getIndNoActiveBloc());
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("indNoOpenPaidEligibility");
          _jspx_th_impact_validateInput_13.setValue("" + fosterCareReviewDB.getIndNoOpenPaidEligibility());
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\t<!--- ELIGIBILITY DETERMINATION --->\r\n\t");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest(showEligibility && userIsEligibilitySpecialist
                    && fosterCareReviewDB.getIndEligibleObject() != null);
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"ReasonsNotEligibileTitle\">\r\n\t\t\t\t\tChild is");
              out.print(fosterCareReviewDB.getIndEligible() ? "" : " NOT");
              out.write("\r\n\t\t\t\t\tEligible for Title IV-E Reimbursability\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t");

			  if (fosterCareReviewDB.getIndEligible() == false) {
			        List reasonsNotEligible = fosterCareReviewDB.getReasonsNotEligible();
			        Iterator iterator = reasonsNotEligible.iterator();
			
              out.write("\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"ReasonsNotEligibileReason\">\r\n\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t");

						  while (iterator.hasNext()) {
						          FceReasonNotEligibleDB reason = (FceReasonNotEligibleDB) iterator.next();
						          out.print("<li>");
						          out.print(Lookup.simpleDecodeSafe(CodesTables.CFCERNE, reason.getCdReasonNotEligible()));
						          out.print("</li>");
						        }
						
              out.write("\r\n\t\t\t\t\t</ul>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t");

			  }
			
              out.write("\r\n\t\t</table>\r\n\t\t<br>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<!-- END ELIGIBILITY DETERMINATION -->\r\n\r\n\r\n\t<!-- BEGIN DISPLAY ONLY table -->\r\n\t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tClose Foster Care Reimbursability Determination\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setName("indReviewInappropriate");
          _jspx_th_impact_validateInput_14.setLabel("Foster Care Reimbursability Determination is no longer appropriate for this child");
          _jspx_th_impact_validateInput_14.setChecked(fosterCareReviewDB.getIndReviewInappropriateString());
          _jspx_th_impact_validateInput_14.setDisabled("" + disableInappropriateReview);
          _jspx_th_impact_validateInput_14.setValue("true");
          _jspx_th_impact_validateInput_14.setType("checkbox");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setName("txtInappropriateComments");
          _jspx_th_impact_validateInput_15.setValue(fosterCareReviewDB.getTxtInappropriateComments());
          _jspx_th_impact_validateInput_15.setLabel("Comments");
          _jspx_th_impact_validateInput_15.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setColspan("3");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setDisabled("" + disableInappropriateReview);
          _jspx_th_impact_validateInput_15.setSize("80");
          _jspx_th_impact_validateInput_15.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_15.setMaxLength("80");
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<br>\r\n\t<!--SIR 23890 renamed BLOC to BSL    -->\r\n\t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tChild Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("nmChild");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Child's Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(fosterCareReviewDB.getNmPersonFull());
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dtBirthString");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Date of Birth");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(fosterCareReviewDB.getDtBirthString());
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("nbrSocialSec");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Social Security Number");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(fosterCareReviewDB.getNbrSocialSecurity());
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("nbrCrsId");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("CRS Id");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(fosterCareReviewDB.getNbrCrsId());
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("idPerson");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Person ID");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(fosterCareReviewDB.getIdPersonString());
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("nbrMhn");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("MHN Number");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(fosterCareReviewDB.getNbrMhn());
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\t<!-- END DISPLAY ONLY table -->\r\n\r\n\r\n\r\n\r\n\t<!---- INCOME FOR CHILD SECTION ---->\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th>\r\n\t\t\t\tIncome for Child\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");

				  request.setAttribute("tabIndex", tabIndex);
				    request.setAttribute("disableRadios", "" + disableIncomeResourcesFields);
				    request.setAttribute("disableNoIncome", "" + disableIncomeCheckboxes);
				    request.setAttribute("incomeList", fosterCareReviewDB.getIncomeForChild());
				    request.setAttribute("baseNameSuffix", FosterCareReviewConversation.CHILD_INCOME_CONTROL_NAME_SUFFIX_BASE);
				
          out.write("\r\n\t\t\t\t");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableRadios = (String) request.getAttribute("disableRadios");

  boolean _disableNoIncome =
          Boolean.valueOf((String) request.getAttribute("disableNoIncome"));

  List _incomeList = (List) request.getAttribute("incomeList");
  String _baseNameSuffix = (String) request.getAttribute("baseNameSuffix");

          out.write("\r\n<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n    <tr>\r\n      <th class=\"thList\">Name</th>\r\n      <th class=\"thList\">Type</th>\r\n      <th class=\"thList\">Amount</th>\r\n      <th class=\"thList\">Source</th>\r\n      <th class=\"thList\">No&nbsp;Income</th>\r\n      <th class=\"thList\">Earned/Unearned</th>\r\n      <th class=\"thList\">Countable/Exempt</th>\r\n    </tr>\r\n");

  Iterator _iterator = _incomeList.iterator();
  int _loopCount = 0;
  while (_iterator.hasNext())
  {
    FceIncomeDB _fceIncomeDB = (FceIncomeDB) _iterator.next();
    boolean incomeZero = (_fceIncomeDB.getAmtIncome() == 0.0);
    boolean disableIncome = _disableNoIncome || (incomeZero == false);

    String nameSuffix = _baseNameSuffix + _loopCount;

          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss(_loopCount + 1) );
          out.write("\">\r\n      <td>\r\n        <a href=\"javascript:navigateToPersonDetail(");
          out.print( _fceIncomeDB.getIdPerson() );
          out.write(")\" \r\n           onclick=\"setIsDirtyCalled(true)\" \r\n           tabIndex=\"");
          out.print( _tabIndex++ );
          out.write("\">\r\n          ");
          out.print(_fceIncomeDB.getNmPersonFull());
          out.write("\r\n        </a>\r\n      </td>\r\n      <td>\r\n        ");
          out.print( Lookup.simpleDecodeSafe(CodesTables.CINC, _fceIncomeDB.getCdType()) );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( FormattingHelper.formatMoney(_fceIncomeDB.getAmtIncome()) );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( _fceIncomeDB.getTxtSource() );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("checkbox");
          _jspx_th_impact_validateInput_16.setName( FceIncomeDB.IND_NONE + nameSuffix );
          _jspx_th_impact_validateInput_16.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_16.setChecked( _fceIncomeDB.getIndNoneString() );
          _jspx_th_impact_validateInput_16.setDisabled( String.valueOf(disableIncome) );
          _jspx_th_impact_validateInput_16.setValue( ArchitectureConstants.TRUE );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("radio");
          _jspx_th_impact_validateInput_17.setLabel("Earned");
          _jspx_th_impact_validateInput_17.setName( FceIncomeDB.IND_EARNED + nameSuffix );
          _jspx_th_impact_validateInput_17.setValue( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateInput_17.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_17.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_17.setChecked( "" + _fceIncomeDB.getIndEarned() );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br/>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setLabel("Unearned");
          _jspx_th_impact_validateInput_18.setName( FceIncomeDB.IND_EARNED + nameSuffix );
          _jspx_th_impact_validateInput_18.setValue( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_18.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_18.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_18.setChecked( "" + Boolean.FALSE.equals(_fceIncomeDB.getIndEarnedObject()) );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("radio");
          _jspx_th_impact_validateInput_19.setLabel("Countable");
          _jspx_th_impact_validateInput_19.setName( FceIncomeDB.IND_COUNTABLE + nameSuffix );
          _jspx_th_impact_validateInput_19.setValue( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateInput_19.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_19.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_19.setChecked( "" + Boolean.TRUE.equals(_fceIncomeDB.getIndCountableObject()) );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br/>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("radio");
          _jspx_th_impact_validateInput_20.setLabel("Exempt");
          _jspx_th_impact_validateInput_20.setName( FceIncomeDB.IND_COUNTABLE + nameSuffix );
          _jspx_th_impact_validateInput_20.setValue( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_20.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_20.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_20.setChecked( "" + Boolean.FALSE.equals(_fceIncomeDB.getIndCountableObject()) );
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n");

    _loopCount++;
  }

          out.write("\r\n  </table>\r\n</div>\r\n");

 request.setAttribute("tabIndex", _tabIndex);
}

          out.write('\r');
          out.write('\n');
          out.write("\r\n\t\t\t\t");

				  tabIndex = (Integer) request.getAttribute("tabIndex");
				
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\t<!-- END INCOME FOR CHILD SECTION -->\r\n\r\n\r\n\t<!-- RESOURCES FOR CHILD SECTION -->\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"5\">\r\n\t\t\t\tResources for Child\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"5\">\r\n\t\t\t\t");

				  request.setAttribute("tabIndex", tabIndex);
				    request.setAttribute("disableRadios", "" + disableIncomeResourcesFields);

				    request.setAttribute("resourcesList", fosterCareReviewDB.getResourcesForChild());
				    request.setAttribute("baseNameSuffix", FosterCareReviewConversation.CHILD_RESOURCE_CONTROL_NAME_SUFFIX_BASE);
				
          out.write("\r\n\t\t\t\t");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableRadios = (String) request.getAttribute("disableRadios");

  List _resourcesList = (List) request.getAttribute("resourcesList");
  String _baseNameSuffix = (String) request.getAttribute("baseNameSuffix");

          out.write("\r\n<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n    <tr>\r\n      <th class=\"thList\">Name</th>\r\n      <th class=\"thList\">Type</th>\r\n      <th class=\"thList\">Amount</th>\r\n      <th class=\"thList\">Source</th>\r\n      <th class=\"thList\">Verification Method</th>\r\n      <th class=\"thList\">Accessible?</th>\r\n      <th class=\"thList\">Countable/Exempt</th>\r\n    </tr>\r\n");
  
  if (_resourcesList == null)
  {

          out.write("\r\n    <tr class=\"odd\">\r\n      <td colspan=\"7\">\r\n        ");
          out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
          out.write("\r\n      </td>\r\n    </tr>\r\n");

  }
  else
  {
    int _loopCount = 0;
    Iterator _iterator = _resourcesList.iterator();
    while(_iterator.hasNext())
    {
      FceIncomeDB fceIncomeDB = (FceIncomeDB)_iterator.next();
      String nameSuffix = _baseNameSuffix + _loopCount;

          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss(_loopCount + 1) );
          out.write("\">\r\n      <td>\r\n        <a tabIndex=\"");
          out.print(_tabIndex++);
          out.write("\" \r\n           href=\"javascript:navigateToPersonDetail(");
          out.print(fceIncomeDB.getIdPerson() );
          out.write(")\"\r\n           onclick=\"setIsDirtyCalled(true)\">\r\n          ");
          out.print( fceIncomeDB.getNmPersonFull() );
          out.write("\r\n        </a>\r\n      </td>\r\n      <td>\r\n        ");
          out.print( Lookup.simpleDecodeSafe(CodesTables.CRSRC, fceIncomeDB.getCdType()) );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( FormattingHelper.formatMoney(fceIncomeDB.getAmtIncome()) );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( fceIncomeDB.getTxtSource() );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( fceIncomeDB.getTxtVerificationMethod() );
          out.write("\r\n      </td>\r\n      ");
 // STGAP00004122 - change col label from Inaccessible (above) to Accessible and modify display logic accordingly 
          out.write("\r\n      <td>\r\n        ");
          out.print( fceIncomeDB.getIndNotAccessible() ? "No" : "Yes" );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("radio");
          _jspx_th_impact_validateInput_21.setLabel("Countable");
          _jspx_th_impact_validateInput_21.setName(FceIncomeDB.IND_COUNTABLE + nameSuffix );
          _jspx_th_impact_validateInput_21.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_21.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_21.setTabIndex(_tabIndex++);
          _jspx_th_impact_validateInput_21.setChecked( "" + ArchitectureConstants.TRUE.equals(fceIncomeDB.getIndCountableString()) );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br/>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("radio");
          _jspx_th_impact_validateInput_22.setLabel("Exempt");
          _jspx_th_impact_validateInput_22.setName(FceIncomeDB.IND_COUNTABLE + nameSuffix );
          _jspx_th_impact_validateInput_22.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_22.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_22.setTabIndex(_tabIndex++);
          _jspx_th_impact_validateInput_22.setChecked( "" + ArchitectureConstants.FALSE.equals(fceIncomeDB.getIndCountableString()) );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n");

      _loopCount++;
    }
  }

          out.write("\r\n  </table>\r\n</div>\r\n");

 request.setAttribute("tabIndex", _tabIndex);
}

          out.write('\r');
          out.write('\n');
          out.write("\r\n\t\t\t\t");

				  tabIndex = (Integer) request.getAttribute("tabIndex");
				
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<!-- END RESOURCES FOR CHILD -->\r\n\t<br>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th>\r\n\t\t\t\tChild Care Section\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("expendituresInformation");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Expenditures Information");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t<table cellPadding=\"3\" cellSpacing=\"0\" width=\"100%\"\r\n\t\t\t\t\t\tclass=\"tableBorder\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tPerson Receiving Care\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tService Provider Name\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tMonthly Amount Paid\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");

						  List principals = fosterCareReviewDB.getPrinciples();
						      Map<Long, String> personCareReceiveNameList = new HashMap<Long, String>();
						      for (int i = 0; i < principals.size(); i++) {
						        FcePersonDB principal = (FcePersonDB) principals.get(i);
						        personCareReceiveNameList.put(principal.getIdPerson(), principal.getNmPersonFull());
						      }

						      List expendituresList = fosterCareReviewDB.getExpenditures();
						      if (!expendituresList.isEmpty() && expendituresList != null) {
						        int i = 0;
						        Iterator expendituresIterator = expendituresList.iterator();
						        while (expendituresIterator.hasNext()) {
						          FceExpendituresDB expendituresDB = (FceExpendituresDB) expendituresIterator.next();
						          String personCareReceiveId = FceExpendituresDB.ID_PERSON_CARE_RECEIVE + i;
						          String nmServiceProviderId = FceExpendituresDB.NM_SERVICE_PROVIDER + i;
						          String amtPdMonthlyId = FceExpendituresDB.AMT_PD_MONTHLY + i;
						
              out.write("\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_6.setName(personCareReceiveId);
              _jspx_th_impact_validateDisplayOnlyField_6.setValue(personCareReceiveNameList.get(expendituresDB.getIdPerson()));
              int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_7.setName(nmServiceProviderId);
              _jspx_th_impact_validateDisplayOnlyField_7.setValue(expendituresDB.getNmServiceProvider());
              int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_8.setName(amtPdMonthlyId);
              _jspx_th_impact_validateDisplayOnlyField_8.setValue(FormattingHelper.formatMoney(expendituresDB.getAmtPdMonthly()));
              int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");

						  i++;
						        }
						      }
						
              out.write("\r\n\t\t\t\t\t</table>\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\r\n\t<!-- BEGIN IV-E Budget Worksheet-->\r\n\t");

	  FcePersonDB child = fosterCareReviewDB.getFcePerson();
	
          out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">IV-E Reimbursability Worksheet</th>\r\n  </tr>\r\n  <tr>\r\n    <td>Number of People in Assistance Unit</td>\r\n    <td>1</td>\r\n  </tr>\r\n      <tr>\r\n      <th colspan=\"3\" width=\"42%\">Resource Test</th>\r\n      <th colspan=\"3\" width=\"58%\">Gross Income Ceiling Test</th>\r\n    </tr>\r\n    <tr>\r\n      <td>Total Countable Resources for Child</td>\r\n      <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtCtnblResourceChild()) );
          out.write("</td>\r\n      <td></td>\r\n      <td>Gross Income for Child</td>\r\n      <td>&nbsp;</td>\r\n      <td width=\"5%\">");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtTotalGrossIncomeChild()) );
          out.write("</td>\r\n    </tr>\r\n    <tr>\r\n      <td>Resource Limit</td>\r\n      <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtResourceLimitChild()) );
          out.write("</td>\r\n      <td></td>\r\n      <td>Gross Income Ceiling</td>\r\n      <td>&nbsp;</td>\r\n      <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtGrossIncomeCeilingChild()) );
          out.write("</td>\r\n    </tr>\r\n    <tr>\r\n      <td><b>Eligible Based on Resources?</b></td>\r\n      <td><b>");
          out.print( fosterCareReviewDB.getIndCtnblResChildElgblty() ? ArchitectureConstants.YES : ArchitectureConstants.NO );
          out.write("</b></td>\r\n      <td></td>\r\n      <td><b>");
          out.print( Lookup.simpleDecodeSafe("CSPLSDEF", fosterCareReviewDB.getCdGicSurpDefctChild()) );
          out.write("</b></td>\r\n      <td>&nbsp;</td>\r\n      <td width=\"10%\"><b>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtGicSurpDefctChild()) );
          out.write("</b></td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"3\"></td>\r\n      <td><b>Eligible Based on GIC Test?</b></td>\r\n      <td>&nbsp;</td>\r\n      <td><b>");
          out.print( fosterCareReviewDB.getIndGrossIncChildElgblty() ? ArchitectureConstants.YES : ArchitectureConstants.NO );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n    <th colspan=\"6\">Reimbursability/Payment Budget</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"6\"><table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\">\r\n  <tr>\r\n    <td></td>\r\n    <td></td>\r\n    <td><b>Sub Total</b></td>\r\n  </tr>\r\n  <tr>\r\n    <td>1. Total Monthly Earned Income for Child</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtGrossEarnedChild()) );
          out.write("</td>\r\n    <td></td>\r\n  </tr>\r\n  <tr>\r\n    <td>2. Less Standard Deduction $90</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtStdEarnedIncomeDeduct()) );
          out.write("</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtEarnedLessStdDeduct()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>3. Less $30</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(child.getAmtCntblIncome30()) );
          out.write("</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(child.getAmtCntblIncomeLess30()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>4. Less 1/3</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(child.getAmtCntblIncomeThird()) );
          out.write("</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(child.getAmtCntblIncomeLessThird()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n      <td>5. Less Dependent Care Deduction for Child</td>\r\n      <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtDepCareDeducChild()) );
          out.write("</td>\r\n      <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtLessDepCareElig()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>6. Net Earned Income</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtNetEarnedIncomeChild()) );
          out.write("\r\n    <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtNetEarnedIncomeChild()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>7. Plus Unearned Income</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtGrossUnEarnedChild()) );
          out.write("</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtPlusUnearnedElig()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>8. Plus Child Support(Less $50)</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtChsupChild()) );
          out.write("</td>\r\n    <td>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtPlusChsupChild()) );
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td><b>9. Total Countable Income</b></td>\r\n    <td><b>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtCountableIncome()) );
          out.write("</b></td>\r\n    <td><b>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtCountableIncome()) );
          out.write("</b></td>\r\n  </tr>\r\n  <tr>\r\n      <td><b>10. SON</b></td>\r\n      <td><b>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtStdOfNeedChild()) );
          out.write("</b></td>\r\n      <td></td>\r\n  </tr>\r\n  <tr>\r\n    <td><b>11. ");
          out.print( Lookup.simpleDecodeSafe("CSPLSDEF", fosterCareReviewDB.getCdEligSurpDefctChild()) );
          out.write("</b>(line 9 less SON)</td>\r\n    <td><b>");
          out.print( FormattingHelper.formatMoney(fosterCareReviewDB.getAmtSurpDefctEligChild()) );
          out.write("</b></td>\r\n    <td></td>\r\n  </tr>\r\n  </table></td>\r\n  </tr>\r\n</table>\r\n\r\n\r\n\t<!-- END IV-E Budget -->\r\n\t<br>\r\n\t<!-- BEGIN JUDICIAL DETERMINATIONS table -->\r\n\t<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tJudicial Requirements\r\n\t\t\t</th>\r\n\t\t</tr>\r\n");

    if( StringHelper.isEmptyOrNull(fosterCareReviewDB.getIndPrmncyHearingsDueString()) ){
        // this scenario occurs when child is not in DFCS custody
        // display nothing
    } else if( fosterCareReviewDB.getIndPrmncyHearingsDue() && !fosterCareReviewDB.getIndPrmncyHrngs12Month() ){    

          out.write("\r\n \t\t<tr>\r\n\t\t    <td>Judicial determination regarding &#34;Reasonable efforts to Finalize the child&#39;s Permanency Plan&#34; is overdue.</td>\r\n\t\t    <td></td>\r\n\t\t</tr>\r\n");

    } else if ( !fosterCareReviewDB.getIndPrmncyHearingsDue() && !fosterCareReviewDB.getIndPrmncyHrngs12Month() ){

          out.write("\r\n\t\t<tr>\r\n            <td>Judicial determination regarding &#34;Reasonable efforts to Finalize the child&#39;s Permanency Plan&#34; is not overdue.</td>\r\n            <td></td>\r\n\t\t</tr>\r\n");

    } else if ((fosterCareReviewDB.getIndPrmncyHearingsDue() && fosterCareReviewDB.getIndPrmncyHrngs12Month())
                || (!fosterCareReviewDB.getIndPrmncyHearingsDue() && fosterCareReviewDB.getIndPrmncyHrngs12Month())){

          out.write("\r\n        <tr>\r\n            <td>Date of Judicial Determination regarding &#34;Reasonable efforts to Finalize the child&#39;s Permanency Plan&#34;:</td>\r\n            <td>");
          out.print( fosterCareReviewDB.getDtPrmncyHrngs12MonthString() );
          out.write("</td>\r\n        </tr>\r\n");

    }

          out.write('\r');
          out.write('\n');

    if( StringHelper.isEmptyOrNull(fosterCareReviewDB.getIndPrmncyHearingsDueString())
        ||  StringHelper.isEmptyOrNull(fosterCareReviewDB.getIndExtnsionProvided12MnthsString()) ){
        // do not display any message if child is not in dfcs custody status
        // or child is in permanent custody
    } else if( fosterCareReviewDB.getIndPrmncyHearingsDue() && fosterCareReviewDB.getIndExtnsionProvided12Mnths() ){    

          out.write("\r\n        <tr>\r\n            <td>Custody Expiration Date of the current legal status within the past 12 months:</td>\r\n            <td>");
          out.print( fosterCareReviewDB.getDtExtnsionProvided12MnthsString() );
          out.write("</td>\r\n        </tr>\r\n");

    } else if ( fosterCareReviewDB.getIndPrmncyHearingsDue() && !fosterCareReviewDB.getIndExtnsionProvided12Mnths() ){

          out.write("\r\n        <tr>\r\n            <td>There is no legal status that gave DFCS an extension of custody within the past 12 months.</td>\r\n            <td></td>\r\n        </tr>\r\n");

    }

          out.write("\r\n\t</table>\r\n\t<br>\r\n\t<!-- END JUDICIAL DETERMINATIONS table -->\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableborder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tWorker Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("nmWorker");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Case Manager's Name");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue(fosterCareReviewDB.getNmEmployeePersonFull());
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("nbrWorkerPhone");
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Phone");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue(FormattingHelper.formatPhone(fosterCareReviewDB.getNbrEmployeePersonPhone()));
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"60%\" class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSubmitApplication1");
          _jspx_th_impact_ButtonTag_0.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_0.setForm(formName);
          _jspx_th_impact_ButtonTag_0.setAccessKey("U");
          _jspx_th_impact_ButtonTag_0.setFunction("alertEligibilitySpecialist();");
          _jspx_th_impact_ButtonTag_0.setDisabled("" + (showSubmitButton == false));
          _jspx_th_impact_ButtonTag_0.setAction("/fce/FosterCareReview/submitReview");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAccessKey("S");
          _jspx_th_impact_ButtonTag_1.setFunction("alertEligibilitySpecialist();");
          _jspx_th_impact_ButtonTag_1.setDisabled("" + (showSaveButton == false));
          _jspx_th_impact_ButtonTag_1.setForm(formName);
          _jspx_th_impact_ButtonTag_1.setAction("/fce/FosterCareReview/saveReview");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnContinue");
          _jspx_th_impact_ButtonTag_2.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_2.setForm(formName);
          _jspx_th_impact_ButtonTag_2.setAccessKey("M");
          _jspx_th_impact_ButtonTag_2.setFunction("yes();");
          _jspx_th_impact_ButtonTag_2.setDisabled("" + (showContinueButton == false));
          _jspx_th_impact_ButtonTag_2.setAction("/fce/FosterCareReview/confirmYes");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");

  // Sir 23012 - Had to add JavaScript calls to the Show Functions to display
  // the questions when loading the page if the appropriate radio buttons were
  // selected.

      out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\tclass=\"tableBorder\">\r\n\t<tr>\r\n\t\t<th colspan=\"4\">\r\n\t\t\tForm Launch\r\n\t\t</th>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td>\r\n\t\t\t");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode("2");
      _jspx_th_impact_documentList_0.setTabIndex(tabIndex++);
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("Reimbursability Determination");
          _jspx_th_impact_document_0.setProtectDocument(true);
          _jspx_th_impact_document_0.setCheckForNewMode(false);
          _jspx_th_impact_document_0.setDocType("FEL02O00");
          _jspx_th_impact_document_0.setDocExists(false);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pEvent");
              _jspx_th_impact_documentParameter_0.setValue(String.valueOf(GlobalData.getUlIdEvent(request)));
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue(String.valueOf(GlobalData.getUlIdStage(request)));
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pCase");
              _jspx_th_impact_documentParameter_2.setValue(String.valueOf(GlobalData.getUlIdCase(request)));
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n");
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
