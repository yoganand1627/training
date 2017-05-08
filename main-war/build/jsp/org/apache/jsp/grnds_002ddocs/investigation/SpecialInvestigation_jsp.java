package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.web.investigation.SpecialInvestigationConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvAllegationBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvHmeWaiverChildHistBean;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import java.util.*;

public final class SpecialInvestigation_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  

  //Set Page Mode and related variables for display
  String pageMode = PageMode.getPageMode(request);

  String szDisabled = "false";
  String yIsCheckedConcurAssmntDisp = "false";
  String nIsCheckedConcurAssmntDisp = "false";
  String yIsCheckedConcurActionRecmnd = "false";
  String nIsCheckedConcurActionRecmnd = "false";
  String isCheckedRcmndPlcmntRsrcClosed = "false"; 
  String isCheckedRcmndChldrnRemoved = "false";
  String isCheckedRcmndActionPlanDvlpd = "false";
  String isCheckedRcmndNoChangeStatus = "false";
  String isCheckedRcmndWaiverAttached = "false";
  String isCheckedRcmndCpaCpiNotUsed = "false";
  String yIsCheckedRecChkReviewed = "false";
  String nIsCheckedRecChkReviewed = "false";
  String xIsCheckedRecChkReviewed = "false";
  String isCheckedRcmndOther = "false";
  String isCheckedMaltreatment = "";
  String isCheckedPolicyViolation = "";
  boolean docExists = false;
  
  SpclInvestigationRetrieveSO spclInvestigationRetrieveSO = (SpclInvestigationRetrieveSO) state
                                                                                               .getAttribute(
                                                                                                             "spclInvestigationRetrieveSO",
                                                                                                             request);
                                                                                                              
  if (spclInvestigationRetrieveSO == null) {
    spclInvestigationRetrieveSO = new SpclInvestigationRetrieveSO();
  } else {
    docExists = spclInvestigationRetrieveSO.getIsBLOBExistsInDatabase();
  }
  
  // Create a 1-based tab index variable that can be used to set tab indices down the page.
  int tabIndex = 1;
  String cdEventStatus = spclInvestigationRetrieveSO.getCdEventStatus();
  if (CodesTables.CEVTSTAT_APRV.equals(cdEventStatus) || PageModeConstants.VIEW.equals(pageMode)) {
    szDisabled = "true";
  }

  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndConcurAssmntDisp())) {
    yIsCheckedConcurAssmntDisp = "true";
  } else if (ArchitectureConstants.N.equals(spclInvestigationRetrieveSO.getIndConcurAssmntDisp())) {
    nIsCheckedConcurAssmntDisp = "true";
  }

  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndConcurActionRecmnd())) {
    yIsCheckedConcurActionRecmnd = "true";
  } else if (ArchitectureConstants.N.equals(spclInvestigationRetrieveSO.getIndConcurActionRecmnd())) {
    nIsCheckedConcurActionRecmnd = "true";
  }

  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndInvMaltreatInCare())) {
    isCheckedMaltreatment = ArchitectureConstants.YES;

  } else if (ArchitectureConstants.N.equals(spclInvestigationRetrieveSO.getIndInvMaltreatInCare())) {
    isCheckedMaltreatment = ArchitectureConstants.NO;
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndPolicyViolation())) {
    isCheckedPolicyViolation = ArchitectureConstants.YES;
  } else if (ArchitectureConstants.N.equals(spclInvestigationRetrieveSO.getIndPolicyViolation())) {
    isCheckedPolicyViolation = ArchitectureConstants.NO;
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRecordChkViewed())) {
    yIsCheckedRecChkReviewed = "true";
  } else if (ArchitectureConstants.N.equals(spclInvestigationRetrieveSO.getIndRecordChkViewed())) {
    nIsCheckedRecChkReviewed = "true";
  } else if (ArchitectureConstants.X.equals(spclInvestigationRetrieveSO.getIndRecordChkViewed())) {
    xIsCheckedRecChkReviewed = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndPlcmntRsrcClosed())) {
    isCheckedRcmndPlcmntRsrcClosed = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndChldrnRemoved())) {
    isCheckedRcmndChldrnRemoved = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndActionPlanDvlpd())) {
    isCheckedRcmndActionPlanDvlpd = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndCpaCciNotUsed())) {
    isCheckedRcmndCpaCpiNotUsed = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndNoChangeStatus())) {
    isCheckedRcmndNoChangeStatus = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndWaiverAttached())) {
    isCheckedRcmndWaiverAttached = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndOther())) {
    isCheckedRcmndOther = "true";
  }
  

  List<String> concurrences = spclInvestigationRetrieveSO.getConcurrenceCodes();
  if (concurrences == null) {
    concurrences = new ArrayList<String>();
  }
  

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n");

  /* Start Javascript Section */

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  ");
      out.write("\r\n  function displayAllgtnDetail(idAllgtn, idVictim)\r\n  {\r\n    document.frmSpclInvestigation.hdnUlIdAllgtn.value = idAllgtn;\r\n    document.frmSpclInvestigation.hdnIdSpclInvAllgtnVictim.value = idVictim;\r\n    submitValidateForm( \"frmSpclInvestigation\", \"/investigation/SpecialInvestigation/displayAllgtnDetail\" );\r\n  }\r\n\r\n  function submitResourceID(idResource)\r\n  {\r\n    document.frmSpclInvestigation.idResource.value = idResource;\r\n    submitValidateForm( \"frmSpclInvestigation\", \"/investigation/SpecialInvestigation/displayResourceDetail\" );\r\n  }  \r\n  \r\n  function displayProviderAllgtnHistory(idResource)\r\n  {\r\n    document.frmSpclInvestigation.idResource.value = idResource;\r\n    submitValidateForm( \"frmSpclInvestigation\", \"/investigation/SpecialInvestigation/displayProviderAllgtnHistory\" );\r\n  }  \r\n  </script>\r\n  \r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmSpclInvestigation");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/SpecialInvestigation/displaySpclInvestigation");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.SpecialInvestigationCustomValidation");
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
          _jspx_th_impact_validateInput_0.setName("idResource");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatInt(spclInvestigationRetrieveSO.getIdResource()));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          out.write('\r');
          out.write('\n');

  if (!pageMode.equals(PageModeConstants.NEW) && (EventHelper.PENDING_EVENT.equals(cdEventStatus) || EventHelper.APPROVED_EVENT.equals(cdEventStatus))) {
      String action = ApprovalStatusConversation.DISPLAY_URI;
      int editableMode = EditableMode.NEW + EditableMode.MODIFY;
      if (PageModeConstants.VIEW.equals(pageMode)) {
        editableMode = EditableMode.NONE;
      }

      if (GlobalData.isApprovalMode(request)) {
        action = "/investigation/SpecialInvestigation/submitApproval";
      }

          out.write("\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmSpclInvestigation");
          _jspx_th_impact_ButtonTag_0.setAction(action);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n    </table>\r\n");

  }

          out.write("\r\n\t<br>\r\n\r\n\t");

	  UserProfile user = UserProfileHelper.getUserProfile(request);
	    if ((pageMode.equals(PageModeConstants.VIEW) || pageMode.equals(PageModeConstants.EDIT))
	        && ((EventHelper.APPROVED_EVENT.equals(cdEventStatus)) 
	             || ((SpecialInvestigationConversation.POLICY_UNIT.equals(spclInvestigationRetrieveSO.getWhichApprover())
	                  || SpecialInvestigationConversation.DEPUTY_DIRECTOR.equals(spclInvestigationRetrieveSO.getWhichApprover())) 
	             && (EventHelper.PENDING_EVENT.equals(cdEventStatus))))) {
	
          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n\t<td width=\"40%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dtSpclInvSent");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Date Special Investigation sent to Policy Unit");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatDate(spclInvestigationRetrieveSO.getDtSpclInvSent()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n\t<td>\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dtSpclInvApproved");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Date Special Investigation approved by Policy Unit");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatDate(spclInvestigationRetrieveSO.getDtSpclInvApproved()));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n</table>\t\r\n<br>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"2\">State Office Concurrence</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n      <span class=\"formRequiredText\">*</span>The Program planning and Policy Development Unit has reviewed \r\n      the CPS investigation/placement resource violation and recommended plan for the placement resource identified below:\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"2%\">&nbsp;</td>\r\n    <td>\r\n\t  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t    <tr>\r\n\t      <td colspan=\"4\">\r\n\t        Does the State Office concur with the assessment disposition?\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setLabel("Yes");
          _jspx_th_impact_validateInput_3.setChecked(yIsCheckedConcurAssmntDisp);
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_3.setValue("Y");
          _jspx_th_impact_validateInput_3.setName("rbStateOfficeConcurDisp");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setLabel("No");
          _jspx_th_impact_validateInput_4.setChecked(nIsCheckedConcurAssmntDisp);
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_4.setValue("N");
          _jspx_th_impact_validateInput_4.setName("rbStateOfficeConcurDisp");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n\t    </tr>\r\n\t    <tr>\r\n\t      <td colspan=\"4\">\r\n\t        Does the State Office concur with the action that the county has recommended?\t      \r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setLabel("Yes");
          _jspx_th_impact_validateInput_5.setChecked(yIsCheckedConcurActionRecmnd);
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_5.setValue("Y");
          _jspx_th_impact_validateInput_5.setName("rbStateOfficeConcurCountyRecAction");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setLabel("No");
          _jspx_th_impact_validateInput_6.setChecked(nIsCheckedConcurActionRecmnd);
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_6.setValue("N");
          _jspx_th_impact_validateInput_6.setName("rbStateOfficeConcurCountyRecAction");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n\t    </tr>\r\n\t    <tr>\r\n\t      <td colspan=\"4\">&nbsp;</td>\r\n\t    </tr>\r\n\t    <tr>\r\n          <td colspan=\"4\">\r\n            <b>Policy/Practice Review Results:</b>\r\n          </td>\r\n        </tr>\r\n\t    <tr>\r\n          <td colspan=\"4\">\r\n            ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("cbxStateOfficeConcur_");
          _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CPUNOCR );
          _jspx_th_impact_codesCheckbox_0.setColumns(1);
          _jspx_th_impact_codesCheckbox_0.setDisabled(szDisabled );
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes(concurrences);
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtStateOfficeConcurComments");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("100");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setMaxLength(4000);
          _jspx_th_impact_validateTextArea_0.setDisabled("false");
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph4000");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtConcurComments()));
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td colspan=\"2\">&nbsp;</td>\r\n        </tr>\r\n\t  </table>    \r\n    </td>\t\t  \r\n  </tr>\r\n</table>\r\n    <br>\r\n\t");

	  }
	
          out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"3\">Placement Provider Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("nmPlcmntResrc");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Placement Resource");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatString(spclInvestigationRetrieveSO.getNmResource()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n");

if (spclInvestigationRetrieveSO.getIdResource() > 0) {
 
          out.write("\t\r\n\t<td><a onclick=\"setIsDirtyCalled(true);\" href=\"javascript:displayProviderAllgtnHistory('");
          out.print(spclInvestigationRetrieveSO.getIdResource());
          out.write("')\" tabIndex='");
          out.print(tabIndex++);
          out.write("'>\r\n\t    Provider Allegation History</a></td>\r\n");

} else { 
          out.write("\t    \r\n    <td>&nbsp;</td>\r\n");

} 
          out.write("    \r\n\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("cdRsrcFacilType");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Provider Type");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, FormattingHelper.formatString(spclInvestigationRetrieveSO.getCdRsrcFacilType())));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t<td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">\r\n\t  ");
          if (_jspx_meth_impact_validateDisplayOnlyField_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t    <a onclick=\"setIsDirtyCalled(true);\" href=\"javascript:submitResourceID('");
          out.print(spclInvestigationRetrieveSO.getIdResource());
          out.write("')\" tabIndex='");
          out.print(tabIndex++);
          out.write("'>\r\n\t    ");
          out.print(FormattingHelper.formatInt(spclInvestigationRetrieveSO.getIdResource()));
          out.write("\r\n                </a>\r\n\t</td>\r\n\t<td>&nbsp;</td>\r\n  </tr>\r\n</table> \r\n<br/>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"2\">Investigation Summary</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("dtIntakeRecvd");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Intake Received");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(FormattingHelper.formatDate(spclInvestigationRetrieveSO.getDtIntakeRcvd()));
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("cdMaltreatmentFinding");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Maltreatment Finding");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(Lookup.simpleDecodeSafe(CodesTables.CDISPSTN, spclInvestigationRetrieveSO.getCdCpsOverallDisptn()));
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("cdStageRiskFinding");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Overall Risk Finding");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(Lookup.simpleDecodeSafe(CodesTables.CCRSKFND, spclInvestigationRetrieveSO.getCdCnclsnRiskFnd()));
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("indInvMaltreatInCare");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Is this Maltreatment in Care?");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(isCheckedMaltreatment);
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">\r\n\t  ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("indPolicyViolation");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Is this a Policy Violation?");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue(isCheckedPolicyViolation);
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n\t  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t    <tr class=\"subDetail\">\r\n\t      <th class=\"thList\">Maltreatment Code</th>\r\n\t      <th class=\"thList\">Alleged Maltreated Child</th>\r\n\t      <th class=\"thList\">Disposition</th>\r\n\t      <th class=\"thList\">Evidence Code</th>\r\n\t      <th class=\"thList\">Stage</th>\r\n\t    </tr>\r\n");

List<SpclInvAllegationBean> allegationBeans = spclInvestigationRetrieveSO.getAllegationBeans();
if (allegationBeans != null && !allegationBeans.isEmpty()) {
  Iterator<SpclInvAllegationBean> iterAllegations = allegationBeans.iterator();
  int i = 0;
  while (iterAllegations.hasNext()) {
    SpclInvAllegationBean allegation = iterAllegations.next();
 
          out.write("\r\n        <tr class=\"");
          out.print(FormattingHelper.getRowCss(i));
          out.write("\">\r\n          <td><a href=\"javascript:disableValidation('frmSpclInvestigation');displayAllgtnDetail(");
          out.print( allegation.getIdAllegation());
          out.write(',');
          out.write(' ');
          out.print( allegation.getIdVictim());
          out.write(");\" onClick=\"setIsDirtyCalled(true); window.onBeforeUnload=null;\" tabIndex=\"");
          out.print(tabIndex++);
          out.write('"');
          out.write('>');
          out.write(' ');
          out.print(FormattingHelper.formatString(allegation.getCdAllegType()));
          out.write("</a></td>\r\n          <td>");
          out.print(FormattingHelper.formatString(allegation.getNmVictimFull()));
          out.write("</td>\r\n          <td>");
          out.print(FormattingHelper.formatString(allegation.getCdAllegDisposition()));
          out.write("</td>\r\n          <td>");
          out.print(FormattingHelper.formatString(allegation.getEvidenceCodes()));
          out.write("</td>\r\n          <td>");
          out.print(FormattingHelper.formatString(allegation.getCdAllegIncidentStage()));
          out.write("</td>\r\n        </tr>\r\n");

    i++;
  }
}
 
          out.write("        \r\n\t  </table>\r\n    </td>\r\n  </tr>\t  \r\n</table>   \t\r\n<br/>\t\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"2\">County Recommendation</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"4\"><span class=\"formRequiredText\">*</span>The recommended plan for the placement resource/adoptive home is:</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"4%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("checkbox");
          _jspx_th_impact_validateInput_7.setName("cbxPlcmntRsrcClosed");
          _jspx_th_impact_validateInput_7.setDisabled("false");
          _jspx_th_impact_validateInput_7.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_7.setChecked(isCheckedRcmndPlcmntRsrcClosed);
          _jspx_th_impact_validateInput_7.setValue("Y");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>The placement resource will be closed.</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"4%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setName("cbxChildrenRemoved");
          _jspx_th_impact_validateInput_8.setDisabled("false");
          _jspx_th_impact_validateInput_8.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_8.setChecked(isCheckedRcmndChldrnRemoved);
          _jspx_th_impact_validateInput_8.setValue("Y");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>Children in the legal custody of DHR/DFCS have been removed from the placement resource in order to assure safety/well being needs are met.</td>\r\n  </tr> \r\n  <tr>\r\n    <td width=\"4%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setName("cbxActionPlanDvlpd");
          _jspx_th_impact_validateInput_9.setDisabled("false");
          _jspx_th_impact_validateInput_9.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_9.setChecked(isCheckedRcmndActionPlanDvlpd);
          _jspx_th_impact_validateInput_9.setValue("Y");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>A corrective action plan has been developed and is attached to this memorandum.</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"4%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setName("cbxNoChangeStatus");
          _jspx_th_impact_validateInput_10.setDisabled("false");
          _jspx_th_impact_validateInput_10.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_10.setChecked(isCheckedRcmndNoChangeStatus);
          _jspx_th_impact_validateInput_10.setValue("Y");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>No change in the status of the resource is recommended.</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"4%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("checkbox");
          _jspx_th_impact_validateInput_11.setName("cbxWaiverAttached");
          _jspx_th_impact_validateInput_11.setDisabled("false");
          _jspx_th_impact_validateInput_11.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_11.setChecked(isCheckedRcmndWaiverAttached);
          _jspx_th_impact_validateInput_11.setValue("Y");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>A policy waiver or other request on behalf of a child in DHR/DFCS custody is attached to this memorandum.</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"4%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("checkbox");
          _jspx_th_impact_validateInput_12.setName("cbxCpaCpiNotUsed");
          _jspx_th_impact_validateInput_12.setDisabled("false");
          _jspx_th_impact_validateInput_12.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_12.setChecked(isCheckedRcmndCpaCpiNotUsed);
          _jspx_th_impact_validateInput_12.setValue("Y");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>CPA or CPI will not be used for DFCS children.</td>\r\n  </tr>\r\n  <tr valign=\"top\">\r\n    <td width=\"4%\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setName("cbxRcmndOther");
          _jspx_th_impact_validateInput_13.setDisabled("false");
          _jspx_th_impact_validateInput_13.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_13.setChecked(isCheckedRcmndOther);
          _jspx_th_impact_validateInput_13.setValue("Y");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>Other:&nbsp;&nbsp;&nbsp; \r\n          ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtCountyRecOtherComments");
          _jspx_th_impact_validateTextArea_1.setLabel("");
          _jspx_th_impact_validateTextArea_1.setRows("5");
          _jspx_th_impact_validateTextArea_1.setCols("70");
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setMaxLength(4000);
          _jspx_th_impact_validateTextArea_1.setDisabled("false");
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph4000");
          _jspx_th_impact_validateTextArea_1.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtRcmndOtherComments()));
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  \r\n  <tr>\r\n  <td colspan=\"2\">\r\n\t  <span class=\"formRequiredText\">*</span>Have Records Checks been reviewed?\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setLabel("Yes");
          _jspx_th_impact_validateInput_14.setChecked(yIsCheckedRecChkReviewed);
          _jspx_th_impact_validateInput_14.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_14.setValue("Y");
          _jspx_th_impact_validateInput_14.setName("rbRecChkReviewed");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setLabel("No");
          _jspx_th_impact_validateInput_15.setChecked(nIsCheckedRecChkReviewed);
          _jspx_th_impact_validateInput_15.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_15.setValue("N");
          _jspx_th_impact_validateInput_15.setName("rbRecChkReviewed");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setLabel("N/A");
          _jspx_th_impact_validateInput_16.setChecked(xIsCheckedRecChkReviewed);
          _jspx_th_impact_validateInput_16.setDisabled(szDisabled );
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_16.setValue("X");
          _jspx_th_impact_validateInput_16.setName("rbRecChkReviewed");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\"><span class=\"formCondRequiredText\">&#135;</span>Synopsis of records reviewed and how it impacts allegations:</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("txtSynopsisRecReviewed");
          _jspx_th_impact_validateTextArea_2.setLabel("");
          _jspx_th_impact_validateTextArea_2.setRows("5");
          _jspx_th_impact_validateTextArea_2.setCols("85");
          _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_2.setMaxLength(4000);
          _jspx_th_impact_validateTextArea_2.setDisabled("false");
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph4000");
          _jspx_th_impact_validateTextArea_2.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtSynopsisRecReviewed()));
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\"><span class=\"formRequiredText\">*</span>Results of the 48 Hour Case Staffing:</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName("txtResultsCaseStaffing");
          _jspx_th_impact_validateTextArea_3.setLabel("");
          _jspx_th_impact_validateTextArea_3.setRows("5");
          _jspx_th_impact_validateTextArea_3.setCols("85");
          _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_3.setMaxLength(4000);
          _jspx_th_impact_validateTextArea_3.setDisabled("false");
          _jspx_th_impact_validateTextArea_3.setConstraint("Paragraph4000");
          _jspx_th_impact_validateTextArea_3.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtResults48hrStaffing()));
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\"><span class=\"formRequiredText\">*</span>Names and Agencies Represented at Case Staffing:</td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_4.setName("txtNamesAgenciesRepCaseStaffing");
          _jspx_th_impact_validateTextArea_4.setLabel("");
          _jspx_th_impact_validateTextArea_4.setRows("5");
          _jspx_th_impact_validateTextArea_4.setCols("85");
          _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_4.setMaxLength(4000);
          _jspx_th_impact_validateTextArea_4.setDisabled("false");
          _jspx_th_impact_validateTextArea_4.setConstraint("Paragraph4000");
          _jspx_th_impact_validateTextArea_4.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
          if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_4.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtNamesAgncyRepStaffing()));
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
          out.write("</td>\r\n  </tr>\r\n</table>\r\n<br/>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("HomeWaiver");
          _jspx_th_impact_ExpandableSectionTag_0.setId("homeWaiver_id");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Home Waiver");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("                            \r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\"> \r\n  <tr class=\"odd\">\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td><span class=\"formCondRequiredText\">&#135;</span>Justification for the DFCS home to remain open:</td>\r\n  </tr> \r\n  <tr class=\"odd\">\r\n    <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_5.setName("txtJustHmeRemainOpen");
              _jspx_th_impact_validateTextArea_5.setLabel("");
              _jspx_th_impact_validateTextArea_5.setRows("5");
              _jspx_th_impact_validateTextArea_5.setCols("120");
              _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_5.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_5.setDisabled("false");
              _jspx_th_impact_validateTextArea_5.setConstraint("Paragraph4000");
              _jspx_th_impact_validateTextArea_5.setConditionallyRequired("false");
              int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
              if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_5.doInitBody();
                }
                do {
                  out.write("\r\n          ");
                  out.print(FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtJustHmeRemainOpen()));
                  out.write("\r\n        ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td><span class=\"formCondRequiredText\">&#135;</span>What steps will be taken to assure the safety of the foster children placed in the home:</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_6.setName("txtStepsToAssureSafetyOfChildren");
              _jspx_th_impact_validateTextArea_6.setLabel("");
              _jspx_th_impact_validateTextArea_6.setRows("5");
              _jspx_th_impact_validateTextArea_6.setCols("120");
              _jspx_th_impact_validateTextArea_6.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_6.setMaxLength(4000);
              _jspx_th_impact_validateTextArea_6.setDisabled("false");
              _jspx_th_impact_validateTextArea_6.setConstraint("Paragraph4000");
              _jspx_th_impact_validateTextArea_6.setConditionallyRequired("false");
              int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
              if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_6.doInitBody();
                }
                do {
                  out.write("\r\n          ");
                  out.print(FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtStepsAssureSafety()));
                  out.write("\r\n        ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td><span class=\"formCondRequiredText\">&#135;</span>Specify the name, legal status, permanency plan and length of time placed in the </br>\r\n        &nbsp;&nbsp;&nbsp;&nbsp;foster home for each foster child remaining in the home and subject to this waiver:</td>\r\n  </tr>\r\n  <tr class=\"odd\">\r\n    <td>\r\n      <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"0\">\r\n\t    <tr class=\"odd\">\r\n\t      <th class=\"thList\">&nbsp;</th>\r\n\t      <th class=\"thList\">Name</th>\r\n\t      <th class=\"thList\">Legal County</th>\r\n\t      <th class=\"thList\">Legal Status</th>\r\n\t      <th class=\"thList\">Permanency Plan(s)</th>\r\n\t      <th class=\"thList\">Placement Type</th>\r\n\t      <th class=\"thList\">Time in<br/>Placement</th>\r\n\t    </tr>\r\n");

List<SpclInvHmeWaiverChildHistBean> waiverChildHistBeans = spclInvestigationRetrieveSO.getSpclInvHmeWaiverChildHistBeans();
if (waiverChildHistBeans != null && !waiverChildHistBeans.isEmpty()) {
  Iterator<SpclInvHmeWaiverChildHistBean> iterWaiverChildHistBeans = waiverChildHistBeans.iterator();
  int i = 0;
  while (iterWaiverChildHistBeans.hasNext()) {
    SpclInvHmeWaiverChildHistBean waiverChildHist = iterWaiverChildHistBeans.next();
    String cbxWaiverChildHist = "cbxWaiverChildHist_" + i;
    String indChildRemainInHome = "false";
    if (ArchitectureConstants.Y.equals(waiverChildHist.getIndRemainInHome())) {
      indChildRemainInHome = "true";
    }
    String years = "";
    if (waiverChildHist.getNumYearInPlcmnt() > 0) {
       years = waiverChildHist.getNumYearInPlcmnt() + " Year(s) ";
    }
    // Seperate the Permanency Plan and the Concurrency Plan with a '-' if a Concurrency Plan exists
    String cdChildConcurPlan = "".equals(waiverChildHist.getCdChildConcurPlan()) ? "" : " - " + Lookup.simpleDecodeSafe(CodesTables.CPERMPLN, waiverChildHist.getCdChildConcurPlan());
    
 
              out.write("\r\n        <tr class=\"");
              out.print(FormattingHelper.getRowCss(i));
              out.write("\">\r\n          <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_17.setType("checkbox");
              _jspx_th_impact_validateInput_17.setName(cbxWaiverChildHist);
              _jspx_th_impact_validateInput_17.setDisabled(szDisabled );
              _jspx_th_impact_validateInput_17.setChecked(indChildRemainInHome);
              _jspx_th_impact_validateInput_17.setValue("Y");
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n          <td>");
              out.print(waiverChildHist.getNmPersonFull());
              out.write("</td>\r\n          <td>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, waiverChildHist.getCdChildLegalCounty()));
              out.write("</td>\r\n          <td width=\"20%\">");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CLEGSTAT, waiverChildHist.getCdChildLegalStatus()));
              out.write("</td>\r\n          <td>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CPERMPLN, waiverChildHist.getCdChildPermncyPlan()) + cdChildConcurPlan);
              out.write("</td>\r\n          <td>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CPLMNTYP, waiverChildHist.getCdChildPlcmntType()));
              out.write("</td>\r\n          <td>");
              out.print(FormattingHelper.formatString(years + waiverChildHist.getNumMonthsInPlcmnt() + " Months"));
              out.write("</td>\r\n        </tr>\r\n");

    i++;
  }
}
 
              out.write("   \t    \r\n\t  </table>\r\n    </td>\r\n  </tr>                               \r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

int showButtonOnClosed = EditableMode.MODIFY;
if(ArchitectureConstants.Y.equals(request.getAttribute( "modifyIfStageClosed"))) {
  showButtonOnClosed = EditableMode.ALL;
}

 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n\t<td width=\"75%\">&nbsp;</td>\r\n");

  if (!CodesTables.CEVTSTAT_PEND.equals(cdEventStatus)) {

          out.write("  \r\n\t<td align=\"right\">\r\n\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setForm("frmSpclInvestigation");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setAction("/investigation/SpecialInvestigation/saveSubmitSpecialInvestigation");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setDisabled(szDisabled );
          _jspx_th_impact_ButtonTag_1.setEditableMode( showButtonOnClosed );
          _jspx_th_impact_ButtonTag_1.setFunction("");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n");

  }

          out.write("\t\r\n\t<td align=\"right\">\r\n\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setForm("frmSpclInvestigation");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setAction("/investigation/SpecialInvestigation/saveSpecialInvestigation");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setDisabled(szDisabled );
          _jspx_th_impact_ButtonTag_2.setEditableMode( showButtonOnClosed );
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t\r\n  </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
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
      out.write("\r\n\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n      ");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode( pageMode );
      _jspx_th_impact_documentButton_0.setButtonUrl("/grnds-docs/images/shared/btnNarrative.gif");
      _jspx_th_impact_documentButton_0.setTabIndex( tabIndex++ );
      _jspx_th_impact_documentButton_0.setAccessKey("W");
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n        ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("CpsConclusion");
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setName("CpsConclusion");
          _jspx_th_impact_document_0.setDocType("cpscnlsn");
          _jspx_th_impact_document_0.setDocExists( docExists);
          _jspx_th_impact_document_0.setProtectDocument(true);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sEvent");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf(spclInvestigationRetrieveSO.getIdCpsInvEvent()) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("sCase");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>");
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

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnUlIdAllgtn");
    _jspx_th_impact_validateInput_1.setValue("0");
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
    _jspx_th_impact_validateInput_2.setName("hdnIdSpclInvAllgtnVictim");
    _jspx_th_impact_validateInput_2.setValue("0");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_4.setName("nbrIdRsrc");
    _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Resource ID");
    _jspx_th_impact_validateDisplayOnlyField_4.setValue("");
    int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
