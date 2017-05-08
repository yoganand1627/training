package org.apache.jsp.grnds_002ddocs.serviceDelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanTaskValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.FamilyPlanBean;

public final class FamilyPlanItemDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//--------------------------------------------------------------------------------
      //  JSP Name:     Family Plan Item Detail
      //  Created by:   Jason Rios
      //  Date Created: 02/05/03
      //
      //  Description:
      //  This JSP displays the Family Plan Item Details.
      //
      //  Change History:
      //  Date      User         Description
      //  --------  ------------ -------------------------------------------------------
      //  02/27/04  RIOSJA       SIR 22574 - Added validateDateCreated() JavaScript to
      //                         warn the user if the Date Created is invalid. User must
      //                         fix the date before continuing. This validation is needed
      //                         because all validation is disabled if the Current Level
      //                         of Concern is 'None' or 'Very Little' (see
      //                         disableValidationIfNotNeeded() JavaScript function), and
      //                         invalid dates were causing problems.
      //
      //  11/04/04  thompswa     SIR 22813 - Change maxLength txtGoals, txtTask,
      //                         txtEval to "1000".
      //  02/09/07  vdevarak     Georgia Shines changes: 
      //                         1.Changed the Initial Level Of Concern and Current Level 
      //                         Of Concern fields which were drop down boxes previously to 
      //                         display only fields. 
      //                         2. Replaced Task Completed Checkbox by date field to capture
      //                         the actual date completed for GA SACWIS.
      //                         3. Add Progress Text box, Date of Court Action and Court 
      //                         Mandated Step fields are added.  
      //  10/20/08  charden      wrote code to determine new tasks created on updated family plan item detail 
      //                         so that delete button will displayed for these new tasks
      //--------------------------------------------------------------------------------
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //*******************************
  //*** DECLARE LOCAL VARIABLES ***
  //*******************************
  int loopCounter = 0;
  int tabIndex = 1;
  FamilyPlanValueBean familyPlanBean = null;
  FamilyPlanItemValueBean familyPlanItemBean = null;
  Collection familyPlanEvaluations = null;
  Collection evaluationItems = null;
  FamilyPlanEvalValueBean mostRecentEval = null;
  FamilyPlanEvalItemValueBean mostRecentEvalItem = null;
  Iterator iter = null;
  String fieldName = null;
  String fieldValue = null;
  String isChecked = null;
  String dateAsString = null;
  String compDate = null;
  String editableMode = ArchitectureConstants.FALSE;
  String taskEditableMode = ArchitectureConstants.FALSE;
  String btnVisible = ArchitectureConstants.FALSE;
  String disableProgress = ArchitectureConstants.FALSE;
  String dateCompVisible = ArchitectureConstants.TRUE;
  String provideBlankValue = null;
  String currentLOCFieldIsRequired = "";
  String fieldIsDisabled = null;
  String fieldsToBeSpellChecked = "txtGoals";
  int taskCompletedEditableMode = 0;
  String initialConcernLevel = "";
  String currentConcernLevel = "";
  String set = "";
  String pageMode = "";

  //**************************
  //*** RETRIEVE PAGE DATA ***
  //**************************
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  familyPlanBean = (FamilyPlanValueBean) state.getAttribute("familyPlanBean", request);
  familyPlanItemBean = (FamilyPlanItemValueBean) state.getAttribute("familyPlanItemBean", request);
  iter = familyPlanBean.getFamilyPlanItemList().iterator();
  //Get the Initial and Current level of concern values from the family plan bean for the selected area of concern
  while (iter.hasNext()) {
    FamilyPlanItemValueBean itemBean = (FamilyPlanItemValueBean) iter.next();
    if (familyPlanBean.getFamilyPlanId() != 0) {
      if (itemBean.getAreaOfConcernCode().equals(familyPlanItemBean.getAreaOfConcernCode())) {
        initialConcernLevel = Lookup.simpleDecodeSafe("CRISKSOC", itemBean.getInitialLevelOfConcernScale());
        currentConcernLevel = Lookup.simpleDecodeSafe("CRISKSOC", itemBean.getCurrentLevelOfConcernScale());
        break;
      }
    }
  }
  Date mostRecentApprovalDate = null;
  if (CodesTables.CEVTSTAT_APRV.equals(familyPlanBean.getFamilyPlanEvent().getEventStatusCode())) {
    mostRecentApprovalDate = familyPlanBean.getFamilyPlanEvent().getDateLastUpdate();
  }
  //*********************
  //*** SET PAGE MODE ***
  //*********************
  set = Sets.getPageSet(request);
  if (familyPlanItemBean.getGoals() == null || "".equals(familyPlanItemBean.getGoals())) {
    set = "A";
  }
  if (familyPlanBean.isCopiedPlan()) {
    set = "N";
  }
  if (familyPlanBean.isUpdatedPlan()) {
    set = "E";
  }

  if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }

  if (CodesTables.CEVTSTAT_APRV.equals(familyPlanBean.getFamilyPlanEvent().getEventStatusCode())) {
    if (!"N".equals(set) && !"E".equals(set)) {

      pageMode = PageModeConstants.VIEW;
    }
  }
  if ("E".equals(set) || "A".equals(set)) {
    btnVisible = ArchitectureConstants.TRUE;
  }
  if ("E".equals(set)) {
    dateCompVisible = ArchitectureConstants.FALSE;
  }
  if (PageModeConstants.VIEW.equals(pageMode)) {
    editableMode = ArchitectureConstants.TRUE;
    dateCompVisible = ArchitectureConstants.TRUE;
    disableProgress = ArchitectureConstants.TRUE;

  }

      out.write("\r\n\r\n");

  //******************
  //*** JAVASCRIPT ***
  //******************

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction confirmDeleteThisSection()\r\n{\r\n  var bUserResponse = confirm( \"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
      out.write("\" );\r\n  if ( bUserResponse == true )\r\n  {\r\n    disableValidation(\"frmFamilyPlanItem\");\r\n  }\r\n  return bUserResponse;\r\n}\r\n\r\nfunction confirmDeleteThisTask( indexOfTask )\r\n{\r\n  var bUserResponse = confirm( \"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
      out.write("\" );\r\n  if ( bUserResponse == true )\r\n  {\r\n    document.frmFamilyPlanItem.indexOfTaskToDelete.value = indexOfTask;\r\n  }\r\n  return bUserResponse;\r\n}\r\n\r\nfunction disableValidationIfNotNeeded()\r\n{\r\n  ");

    // If 'Current Level of Concern' is 'None' or 'Very Little',
    // user should not be forced to enter Goals or Tasks.
    if(currentConcernLevel.equals("None") || currentConcernLevel.equals("Very Little") )
    {
      out.write("\r\n      disableValidation(\"frmFamilyPlanItem\");\r\n      \r\n  ");
}
  
      out.write("\r\n  \r\n}\r\n\r\n// SIR 22574 - Warns the user if the Date Created is invalid. User\r\n// must fix the date before continuing. This validation is needed\r\n// because all validation is disabled if the Current Level of Concern\r\n// is 'None' or 'Very Little' (see disableValidationIfNotNeeded()\r\n// JavaScript function above), and invalid dates were causing problems.\r\nfunction validateDateCreated( oDate )\r\n{\r\n  if( oDate.value != \"\" )\r\n  {\r\n    if( validateDateString( oDate.value ) == \"INVALID\" )\r\n    {\r\n      alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ARC_CONSTR_DATE));
      out.write("');\r\n      oDate.focus();\r\n    }\r\n  }\r\n}\r\n</script>\r\n\r\n");

  //*************************
  //*** VALIDATION ERRORS ***
  //*************************

      out.write('\r');
      out.write('\n');

  /* Include custom tag for displaying errors on the page */

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");

  //****************************************************
  //**** FORM (FAMILY PLAN ITEM DETAIL) STARTS HERE ****
  //****************************************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmFamilyPlanItem");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/serviceDelivery/FamilyPlan/displayFamilyPlanItem");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnFamilyPlanEventId");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatInt(familyPlanItemBean.getFamilyPlanEventId()));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnFamilyPlanItemId");
          _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatInt(familyPlanItemBean.getFamilyPlanItemId()));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnFamilyPlanItemDateLastUpdate");
          _jspx_th_impact_validateInput_2.setValue(DateHelper.toISOString(familyPlanItemBean.getFamilyPlanItemDateLastUpdate()));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");

  // Date Initially Addressed should default to today's date.
    dateAsString = DateHelper.toISOString(new Date());
    if (familyPlanItemBean.getDateInitiallyAddressed() != null) {
      dateAsString = DateHelper.toISOString(familyPlanItemBean.getDateInitiallyAddressed());
    }
    if (familyPlanItemBean.getDateGoalsCompleted() != null) {
      compDate = DateHelper.toISOString(familyPlanItemBean.getDateGoalsCompleted());
    } else {
      compDate = "";
    }

          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnDateInitiallyAddressed");
          _jspx_th_impact_validateInput_3.setValue(dateAsString);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnCaseId");
          _jspx_th_impact_validateInput_4.setValue(String.valueOf(familyPlanBean.getCaseId()));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  \r\n");

    //************************************
      //**** DELETE THIS SECTION BUTTON ****
      //************************************
      // The 'Delete this Section' button should be displayed only if: 1) this
      // item has been addressed, and 2) this item was not imported from the risk
      // assessment, and 3) this item has not been approved (meaning the 'Date
      // Initially Addressed' is after the most recent approval date, if it exists).
      if (familyPlanItemBean.getDateInitiallyAddressed() != null
          && !familyPlanItemBean.isIdentifiedInRiskAssessment()
          && (mostRecentApprovalDate == null || familyPlanItemBean.getDateInitiallyAddressed()
                                                                  .after(mostRecentApprovalDate))) {
  
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName(FamilyPlanConversation.DELETE_THIS_SECTION_BUTTON);
          _jspx_th_impact_ButtonTag_0.setImg("btnDeletethisSection");
          _jspx_th_impact_ButtonTag_0.setForm("frmFamilyPlanItem");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setDisabled(btnVisible);
          _jspx_th_impact_ButtonTag_0.setAction("/serviceDelivery/FamilyPlan/deleteFamilyPlanItem");
          _jspx_th_impact_ButtonTag_0.setFunction("return confirmDeleteThisSection()");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

  }

          out.write("\r\n\r\n");

  //*********************************
    //**** FAMILY PLAN ITEM DETAIL ****
    //*********************************

          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr><th colspan=\"3\">Family Plan Item Detail</th></tr>\r\n  <tr>\r\n    <td width=\"30%\">Area of Concern:</td>\r\n    <td width=\"40%\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtAreaOfConcern");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(familyPlanItemBean.getAreaOfConcernText());
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnAreaOfConcernText");
          _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatString(familyPlanItemBean.getAreaOfConcernText()));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnAreaOfConcernCode");
          _jspx_th_impact_validateInput_7.setValue(FormattingHelper.formatString(familyPlanItemBean.getAreaOfConcernCode()));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");

        //-------------
          //--- Goals ---
          //-------------
      
          out.write("\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setLabel("Goals");
          _jspx_th_impact_validateTextArea_0.setName("txtGoals");
          _jspx_th_impact_validateTextArea_0.setRequired("true");
          _jspx_th_impact_validateTextArea_0.setColspan("1");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("103");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setDisabled(editableMode);
          _jspx_th_impact_validateTextArea_0.setOnBlur("if(this.value.length>1000){alert('Please enter no more than 1000 characters of text in the Goals textbox.');}");
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n      ");
              out.print(FormattingHelper.formatString(familyPlanItemBean.getGoals()));
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
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n  <td>\r\n  ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Date Goals Completed");
          _jspx_th_impact_validateDate_0.setName("txtDtGoalComp");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue(compDate);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setWidth("40%");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setDisabled(dateCompVisible);
          _jspx_th_impact_validateDate_0.setOnBlur("javascript:validateDateCreated(this);");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n     <td width = \"20%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnGoals");
          _jspx_th_impact_ButtonTag_1.setImg("btnGoals");
          _jspx_th_impact_ButtonTag_1.setForm("frmFamilyPlanItem");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setDisabled(editableMode);
          _jspx_th_impact_ButtonTag_1.setAction("/serviceDelivery/FamilyPlan/displayFamilyPlanGoals");
          _jspx_th_impact_ButtonTag_1.setFunction("disableValidation('frmFamilyPlanItem')");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n      <table width=100% cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n        <tr>\r\n         <td width=\"30%\">\r\n            ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtInitialLevelOfConcern");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Initial Level of Concern");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(initialConcernLevel);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n             </td>\r\n          <td width=\"40%\">\r\n            ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtCurrentLevelOfConcern");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Current Level of Concern");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(currentConcernLevel);
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n           </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n\r\n");

  //************************
    //**** TASKS/SERVICES ****
    //************************

          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorderList\">\r\n  <tr><td class=\"thList\" colspan=\"2\">Steps</td></tr>\r\n  ");

    // Display the task/services.

      //STGAP00010574 - retrieve maps and area of concern code from state in order to get already saved tasks.
      //Will iterate through the "old" tasks and compare them against the "current" tasks to determine if the delete
      //button should be displayed for the tasks
      String selectedAreaOfConcernCode = (String) state.getAttribute("selectedAreaOfConcernCode", request);
      String beanName = selectedAreaOfConcernCode + "Bean";
      Boolean doDelete = (Boolean) state.getAttribute("doDelete", request) == null ? false : true; 
      Map<String, String> areasOfConcernMap = (Map<String, String>) state.getAttribute("areasOfConcernMap", request);
      Map<String, FamilyPlanItemValueBean> familyPlanItemBeanMap = (Map<String, FamilyPlanItemValueBean>) state.getAttribute("familyPlanItemBeanMap",request);
      FamilyPlanItemValueBean oldFamilyPlanBean = (FamilyPlanItemValueBean) familyPlanItemBeanMap.get(beanName);
      List<FamilyPlanTaskValueBean> tasksList = (List<FamilyPlanTaskValueBean>) oldFamilyPlanBean.getTasks();
      iter = familyPlanItemBean.getTasks().iterator();
      while (iter.hasNext()) {
        FamilyPlanTaskValueBean taskBean = (FamilyPlanTaskValueBean) iter.next();
        Iterator iter1 = tasksList.iterator();
        taskEditableMode = ArchitectureConstants.FALSE;
        int idTask = taskBean.getFamilyPlanTaskId();

        // Determine whether or not the task/service is editable. A task/service
        // is editable until it has been approved by the supervisor; therefore,
        // compare the most recent approval date (of either the plan or an evaluation)
        // to the Task Created date. If the most recent approval date is before or the
        // same as the Task Created date, then the task/service has been approved and
        // is no longer editable. If the task is editable, however, it should be added
        // to the list of fields to be spell-checked.
        if ("E".equals(set) && (taskBean.getTask() != null && !"".equals(taskBean.getTask()))) {
        //id update an approved family plan, iterate through the tasks each time the page is displayed to compare the tasks
        //to be displayed with the tasks that were originally pulled from the database
          if (doDelete) {
            while (iter1.hasNext()) {
              FamilyPlanTaskValueBean task1 = (FamilyPlanTaskValueBean) iter1.next();
              int idTask1 = task1.getFamilyPlanTaskId();
              if (idTask == idTask1) {
                taskEditableMode = ArchitectureConstants.TRUE;
                break;
              }
            }
          }
        }
        if (taskBean.getTask() == null || "".equals(taskBean.getTask()) || "M".equals(set)) {
          disableProgress = ArchitectureConstants.TRUE;
        }
  
          out.write("\r\n    <tr ");
 if ( loopCounter%2 == 1 ) { 
          out.write("class=\"even\"");
 } 
          out.write(">\r\n      <td valign=\"top\" >\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n          <tr>\r\n            <td>\r\n              Step/Service:<br>\r\n              Include Beginning and Ending Dates (and/or Frequency).&nbsp;&nbsp;&nbsp;&nbsp;\r\n              Add Separate Step/Service/Dates for CPS or Other Service.\r\n            </td>\r\n          </tr>\r\n          <br>\r\n          <tr>\r\n            <td>\r\n              ");

                // Task Id hidden field.
                    fieldName = "hdnTaskId" + loopCounter;
              
          out.write("\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName(fieldName);
          _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatInt(taskBean.getFamilyPlanTaskId()));
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              ");

                // Task Date Last Update hidden field.
                    dateAsString = "";
                    if (taskBean.getFamilyPlanTaskDateLastUpdate() != null) {
                      dateAsString = DateHelper.toISOString(taskBean.getFamilyPlanTaskDateLastUpdate());
                    }
                    fieldName = "hdnTaskDateLastUpdate" + loopCounter;
              
          out.write("\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName(fieldName);
          _jspx_th_impact_validateInput_9.setValue(dateAsString);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              ");

                //--------------------
                    //--- Task/Service ---
                    //--------------------
                    fieldName = "txtTask" + loopCounter;
                    // SPB - SIR 19789 - Added onBlur
              
          out.write("\r\n              ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName(fieldName);
          _jspx_th_impact_validateTextArea_1.setRequired("false");
          _jspx_th_impact_validateTextArea_1.setColspan("1");
          _jspx_th_impact_validateTextArea_1.setRows("3");
          _jspx_th_impact_validateTextArea_1.setCols("125");
          _jspx_th_impact_validateTextArea_1.setOnBlur("if(this.value.length>1000){alert('Please enter no more than 1000 characters of text in the Task/Service textbox.');}");
          _jspx_th_impact_validateTextArea_1.setDisabled(taskEditableMode);
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n              ");
              out.print(FormattingHelper.formatString(taskBean.getTask()));
              out.write("\r\n              ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              <br> Progress:<br>\r\n            </td>\r\n          </tr>\r\n         <tr>\r\n          <td >\r\n          ");

            fieldName = "txtProgress" + loopCounter;
          
          out.write("\r\n          ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName(fieldName);
          _jspx_th_impact_validateTextArea_2.setRequired("false");
          _jspx_th_impact_validateTextArea_2.setColspan("1");
          _jspx_th_impact_validateTextArea_2.setRows("3");
          _jspx_th_impact_validateTextArea_2.setCols("125");
          _jspx_th_impact_validateTextArea_2.setOnBlur("if(this.value.length>500){alert('Please enter no more than 500 characters of text in the Task/Service textbox.');}");
          _jspx_th_impact_validateTextArea_2.setDisabled(disableProgress);
          _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_2.setMaxLength(500);
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n              ");
              out.print(FormattingHelper.formatString(taskBean.getProgress()));
              out.write("\r\n              ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          \r\n        </table>\r\n      </td>\r\n    </tr>\r\n    <tr ");
 if ( loopCounter%2 == 1 ) { 
          out.write("class=\"even\"");
 } 
          out.write(">\r\n      <td colspan=\"2\" valign=\"top\">\r\n        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n          <tr>\r\n           <td >\r\n              ");

                //-------------------------
                    //--- Date Task Created ---
                    //-------------------------
                    dateAsString = "";
                    if (taskBean.getDateTaskCreated() != null) {
                      dateAsString = FormattingHelper.formatDate(taskBean.getDateTaskCreated());
                    }
                    fieldName = "txtDateCreated" + loopCounter;
              
          out.write("\r\n              ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Date Created");
          _jspx_th_impact_validateDate_1.setName(fieldName);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setValue(dateAsString);
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setWidth("18%");
          _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_1.setDisabled(taskEditableMode);
          _jspx_th_impact_validateDate_1.setOnBlur("javascript:validateDateCreated(this);");
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n            ");

              //-------------------------
                  //--- Date Task Completed ---
                  //-------------------------
                  dateAsString = "";
                  if (taskBean.getDateTaskCompleted() != null) {
                    dateAsString = FormattingHelper.formatDate(taskBean.getDateTaskCompleted());
                  }
                  fieldName = "txtDateCompleted" + loopCounter;
            
          out.write("\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setLabel("Date Completed");
          _jspx_th_impact_validateDate_2.setName(fieldName);
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setValue(dateAsString);
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setWidth("18%");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setDisabled(editableMode);
          _jspx_th_impact_validateDate_2.setOnBlur("javascript:validateDateCreated(this);");
          _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n           \r\n            <td>\r\n              ");

                //---------------------
                    //--- Court Ordered ---
                    //---------------------
                    isChecked = "false";
                    if (taskBean.isCourtOrderedTask()) {
                      isChecked = "true";
                    }
                    fieldName = "cbxCourtOrdered" + loopCounter;
              
          out.write("\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setLabel("Court Mandated Step");
          _jspx_th_impact_validateInput_10.setName(fieldName);
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setValue("Y");
          _jspx_th_impact_validateInput_10.setChecked(isChecked);
          _jspx_th_impact_validateInput_10.setDisabled(taskEditableMode);
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n          <td >\r\n              ");

                //---------------------
                    //--- Delete Button ---
                    //---------------------
                    // The delete button should be displayed only if this
                    // task/service is editable.
                    String deleteFunctionString = "disableValidation('frmFamilyPlanItem');return confirmDeleteThisTask("
                                                  + loopCounter + ")";
              
          out.write("\r\n                ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnDelete");
          _jspx_th_impact_ButtonTag_2.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_2.setForm("frmFamilyPlanItem");
          _jspx_th_impact_ButtonTag_2.setDisabled(taskEditableMode);
          _jspx_th_impact_ButtonTag_2.setAction("/serviceDelivery/FamilyPlan/deleteFamilyPlanTask");
          _jspx_th_impact_ButtonTag_2.setFunction(deleteFunctionString);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              \r\n            </td>\r\n            <td></td>\r\n          <td>\r\n          ");

            //-------------------------
                //--- Date of Court Action ---
                //-------------------------
                dateAsString = "";
                if (taskBean.getDateCourtAction() != null) {
                  dateAsString = FormattingHelper.formatDate(taskBean.getDateCourtAction());
                }
                fieldName = "txtDateCourtAction" + loopCounter;
          
          out.write("\r\n          ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setLabel("Date of Court Action");
          _jspx_th_impact_validateDate_3.setName(fieldName);
          _jspx_th_impact_validateDate_3.setType("text");
          _jspx_th_impact_validateDate_3.setValue(dateAsString);
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setWidth("15%");
          _jspx_th_impact_validateDate_3.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_3.setDisabled(editableMode);
          _jspx_th_impact_validateDate_3.setOnBlur("javascript:validateDateCreated(this);");
          _jspx_th_impact_validateDate_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td width=\"23%\">\r\n            ");

              //---------------------
                  //--- Court Mandated Closure ---
                  //---------------------
                  isChecked = "false";
                  if (taskBean.isCourtMandatedClosure()) {
                    isChecked = "true";
                  }
                  fieldName = "cbxCourtMandatedClosure" + loopCounter;
            
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setLabel("Court Mandated Closure");
          _jspx_th_impact_validateInput_11.setName(fieldName);
          _jspx_th_impact_validateInput_11.setType("checkbox");
          _jspx_th_impact_validateInput_11.setValue("Y");
          _jspx_th_impact_validateInput_11.setChecked(isChecked);
          _jspx_th_impact_validateInput_11.setDisabled(editableMode);
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          </tr>\r\n          </table>\r\n      </td>\r\n    </tr>\r\n    ");

      loopCounter++;
        } // end while ( iter.hasNext() )
    
          out.write("\r\n</table>\r\n\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnAdd");
          _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_3.setAlign("right");
          _jspx_th_impact_ButtonTag_3.setForm("frmFamilyPlanItem");
          _jspx_th_impact_ButtonTag_3.setDisabled(editableMode);
          _jspx_th_impact_ButtonTag_3.setAction("/serviceDelivery/FamilyPlan/addFamilyPlanTask");
          _jspx_th_impact_ButtonTag_3.setFunction("disableValidation('frmFamilyPlanItem')");
          _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n\r\n");

  // The tasks counter should be the number of tasks in the
    // Collection plus 1 since the Collection is zero-based.

          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("numOfTasks");
          _jspx_th_impact_validateInput_12.setValue(String.valueOf(loopCounter));
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n");

  //*****************
    //**** BUTTONS ****
    //*****************

          out.write("\r\n<br>\r\n<hr>\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"90%\" align=\"right\">\r\n      ");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmFamilyPlanItem");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck(fieldsToBeSpellChecked);
          _jspx_th_impact_spellCheck_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName(FamilyPlanConversation.SAVE_BUTTON_ON_ITEM_PAGE);
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setAlign("right");
          _jspx_th_impact_ButtonTag_4.setForm("frmFamilyPlanItem");
          _jspx_th_impact_ButtonTag_4.setDisabled(editableMode);
          _jspx_th_impact_ButtonTag_4.setFunction("disableValidationIfNotNeeded()");
          _jspx_th_impact_ButtonTag_4.setAction("/serviceDelivery/FamilyPlan/saveFamilyPlanItem");
          _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  //**************************************************
  //**** FORM (FAMILY PLAN ITEM DETAIL) ENDS HERE ****
  //**************************************************

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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("indexOfTaskToDelete");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
