package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildrenFirstReferralRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV29SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.Date;

public final class ChildrenFirstReferral_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//
      //----------------------------------------------------------------------------
      //*  JSP Name:     ChildrenFirstReferral - Children 1st Referral in SHINES
      //*  Created by:   Ashwini Rege
      //*  Date Created: 1/18/2010
      //*
      //*  Description:
      //*  This JSP is used to maintain a Children 1st Referral information
      //*   Change History:
      //*   Date         User      Description
      //*   --------   --------  --------------------------------------------------
      //*   02/01/2010  arege    Delete button should not display when the Page Mode is NEW
      //*   02/08/2010  arege    STGAP00015749:Added new field Release on File
      //*   02/25/2010  cwells   SMS 46063: Locking down form when the referral comp checkbox is checked 
      //*   02/26/2010  arege    SMS46400: Marking Referral Complete should display confirmation message
      //**
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int tabIndex = 1;

  UserProfile userProfile = UserProfileHelper.getUserProfile(request);
  int userId = userProfile.getUserID();

  String pageMode = PageModeConstants.MODIFY;
  if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }

  //-- one boolean for each button to represent if the button should be displayed
  boolean narrative = true;
  boolean save = true;
  boolean delete = true;
  boolean docExists = false;
  //-- one String to represent if fields should be disabled
  String disableFields = "false";
  String disableGenSentRelComp = "false";

  //Initialize the variables for the page

  String szDtReferGene = StringHelper.EMPTY_STRING;
  String szDtReferSent = StringHelper.EMPTY_STRING;
  String indRelSigned = StringHelper.EMPTY_STRING;
  String cbxReferComp = StringHelper.EMPTY_STRING;
  String szDtAckRefRecd = StringHelper.EMPTY_STRING;
  String szDtPhyHelSumRecd = StringHelper.EMPTY_STRING;
  String indPhyFollowUp = StringHelper.EMPTY_STRING;
  String szDtFamSrvTrtPlan = StringHelper.EMPTY_STRING;
  String relOnFile = StringHelper.EMPTY_STRING;
  boolean protectDoc = false;

  String szCdEventType = StringHelper.EMPTY_STRING;
  String dtDtEventOccurred = "";
  int ulIdEvent = 0;
  int ulIdStage = 0;
  int ulIdPerson = 0;
  String szTxtEventDescr = StringHelper.EMPTY_STRING;
  String szCdTask = StringHelper.EMPTY_STRING;
  String szCdEventStatus = StringHelper.EMPTY_STRING;
  String evtsLastUpdate = StringHelper.EMPTY_STRING;
  String childName = StringHelper.EMPTY_STRING;

  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  ChildrenFirstReferralRetrieveSO childrenFirstReferralRetrieveSO = (ChildrenFirstReferralRetrieveSO) state
                                                                                                           .getAttribute(
                                                                                                                         "ChildrenFirstReferralRetrieveSO",
                                                                                                                         request);

  if (childrenFirstReferralRetrieveSO != null) {
    szDtReferGene = FormattingHelper.formatDate(childrenFirstReferralRetrieveSO.getDtDtGeneration());
    szDtReferSent = FormattingHelper.formatDate(childrenFirstReferralRetrieveSO.getDtDtReferralSent());
    indRelSigned = childrenFirstReferralRetrieveSO.getIndParentalRelease();
    cbxReferComp = childrenFirstReferralRetrieveSO.getIndComplete();
    szDtAckRefRecd = FormattingHelper.formatDate(childrenFirstReferralRetrieveSO.getDtDtAcknowledge());
    szDtPhyHelSumRecd = FormattingHelper.formatDate(childrenFirstReferralRetrieveSO.getDtPhySummary());
    indPhyFollowUp = childrenFirstReferralRetrieveSO.getIndFurtherAssmt();
    relOnFile = childrenFirstReferralRetrieveSO.getRelOnFile();
    szDtFamSrvTrtPlan = FormattingHelper.formatDate(childrenFirstReferralRetrieveSO.getDtIFSP());
    docExists = (ArchitectureConstants.TRUE).equals(childrenFirstReferralRetrieveSO.getBIndBLOBExistsInDatabase());
    protectDoc = ArchitectureConstants.Y.equals(cbxReferComp) ? true : false;
    childName = childrenFirstReferralRetrieveSO.getChildName();
  } else {
    childrenFirstReferralRetrieveSO = new ChildrenFirstReferralRetrieveSO();
  }

  ROWCCMN45DO eventDetails = null;

  if (childrenFirstReferralRetrieveSO.getRowccmn45do() == null) {
    eventDetails = new ROWCCMN45DO();
  } else {
    eventDetails = childrenFirstReferralRetrieveSO.getRowccmn45do();
  }

  // Retrieved data from the event table.
  if (eventDetails != null && eventDetails.getUlIdEvent() != 0) {
    szCdEventType = eventDetails.getSzCdEventType();
    dtDtEventOccurred = FormattingHelper.formatDate(eventDetails.getDtDtEventOccurred());
    ulIdEvent = eventDetails.getUlIdEvent();
    ulIdStage = eventDetails.getUlIdStage();
    ulIdPerson = eventDetails.getUlIdPerson();
    szTxtEventDescr = eventDetails.getSzTxtEventDescr();
    szCdTask = eventDetails.getSzCdTask();
    szCdEventStatus = eventDetails.getSzCdEventStatus();
    evtsLastUpdate = DateHelper.toISOStringSafe(eventDetails.getTsLastUpdate());
  }

  if (GlobalData.getUlIdEvent(request) == 0) {
    ulIdPerson = GlobalData.getUlIdPerson(request);
    ulIdStage = GlobalData.getUlIdStage(request);
    szCdTask = GlobalData.getSzCdTask(request);
  }

  if (PageModeConstants.VIEW.equals(pageMode)) {
    save = false;
    disableFields = "true";
    protectDoc = true;
  }

  if (CodesTables.CEVTSTAT_COMP.equals(szCdEventStatus) || PageModeConstants.VIEW.equals(pageMode)) {
    disableGenSentRelComp = "true";
  }

  if (PageModeConstants.NEW.equals(pageMode) || PageModeConstants.VIEW.equals(pageMode)
      || CodesTables.CEVTSTAT_COMP.equals(szCdEventStatus)) {
    delete = false;
  }

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n// This function is called before the page unloads. It creates the\r\n// \"Are you sure you want to navigate away from this page...\" pop-up\r\n// message.\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\nwindow.onload = function ()\r\n{\r\n}\r\n\r\nfunction confirmDelete()\r\n{\r\n  return confirm( \"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
      out.write("\" );\r\n}\r\n\r\nfunction confirmSave()\r\n{\r\n  if(document.frmChildrenFirstReferral.cbxReferComp.checked) {\r\n  return confirm( \"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_REF_COMP));
      out.write("\" );\r\n  } else {\r\n  return true ;\r\n  }\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmChildrenFirstReferral");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/ChildrenFirstReferral/saveChildrenFirstReferral");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.investigation.ChildrenFirstReferralCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\twidth=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tChildren 1st Referral Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<td width=\"30%\">\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("szDtReferGene");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Date Generated");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(szDtReferGene);
          _jspx_th_impact_validateDisplayOnlyField_0.setConditionallyRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setName("szDtReferSent");
          _jspx_th_impact_validateDate_0.setLabel("Date Referral Sent");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_0.setValue(szDtReferSent);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setDisabled(disableGenSentRelComp);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<td>\r\n\t\t\t\tRelease of Information Form Signed by Parents:\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setChecked(ArchitectureConstants.Y.equals(indRelSigned) ? "true" : "false");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setValue("Y");
          _jspx_th_impact_validateInput_0.setType("radio");
          _jspx_th_impact_validateInput_0.setName("rbRelSigned");
          _jspx_th_impact_validateInput_0.setDisabled(disableGenSentRelComp);
          _jspx_th_impact_validateInput_0.setId("indRelSigned");
          _jspx_th_impact_validateInput_0.setLabel("Yes");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setChecked(ArchitectureConstants.N.equals(indRelSigned) ? "true" : "false");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setValue("N");
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setName("rbRelSigned");
          _jspx_th_impact_validateInput_1.setDisabled(disableGenSentRelComp);
          _jspx_th_impact_validateInput_1.setId("indRelSigned");
          _jspx_th_impact_validateInput_1.setLabel("No");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setLabel("Referral Complete");
          _jspx_th_impact_validateInput_2.setName("cbxReferComp");
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setEditableMode(EditableMode.ALL);
          _jspx_th_impact_validateInput_2.setChecked(ArchitectureConstants.Y.equals(cbxReferComp) ? "true" : "false");
          _jspx_th_impact_validateInput_2.setValue("true");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setDisabled(disableGenSentRelComp);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t<table>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t<b>Note:When launching the referral from the Investigation or\r\n\t\t\t\t\t\t\t\tOngoing stages, ensure that correct biological parent\r\n\t\t\t\t\t\t\t\tinformation has been entered on the Caregiver/Parental\r\n\t\t\t\t\t\t\t\tRelationship Information for Child section of the child's Person\r\n\t\t\t\t\t\t\t\tDetail page to correctly pre-fill information for the mother and\r\n\t\t\t\t\t\t\t\tfather. When launching from the FCC or ADO stage, ensure that\r\n\t\t\t\t\t\t\t\tthe stage person relationships have been updated for the child.</b>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\t\t\t\tclass=\"tableBorder\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\t\t\tReturn Information\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t<td width=\"30%\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setName("szDtAckRefRecd");
          _jspx_th_impact_validateDate_1.setLabel("Acknowledgement of Referral Received");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setValue(szDtAckRefRecd);
          _jspx_th_impact_validateDate_1.setSize(" 10");
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_1.setDisabled(disableFields);
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t<td width=\"30%\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setName("szDtPhyHelSumRecd");
          _jspx_th_impact_validateDate_2.setLabel("BCW Physician's Health Summary Received");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setValue(szDtPhyHelSumRecd);
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setOnChange("clearIndFurAssmt()");
          _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_2.setDisabled(disableFields);
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\tPhysician Indicated Need for Further Developmental Assmt:\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setChecked(ArchitectureConstants.Y.equals(indPhyFollowUp) ? "true" : "false");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setValue("Y");
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setName("rbPhyFollowUp");
          _jspx_th_impact_validateInput_3.setDisabled("false");
          _jspx_th_impact_validateInput_3.setId("indPhyFollowUp");
          _jspx_th_impact_validateInput_3.setLabel("Yes");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setDisabled(disableFields);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setChecked(ArchitectureConstants.N.equals(indPhyFollowUp) ? "true" : "false");
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setValue("N");
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setName("rbPhyFollowUp");
          _jspx_th_impact_validateInput_4.setDisabled("false");
          _jspx_th_impact_validateInput_4.setId("indPhyFollowUp");
          _jspx_th_impact_validateInput_4.setLabel("No");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setDisabled(disableFields);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td width=\"30%\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setType("text");
          _jspx_th_impact_validateDate_3.setName("szDtFamSrvTrtPlan");
          _jspx_th_impact_validateDate_3.setLabel("BCW Child Individual Family Service Plan Summary/Treatment Plan Received");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          _jspx_th_impact_validateDate_3.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_3.setValue(szDtFamSrvTrtPlan);
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_3.setDisabled(disableFields);
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\tRelease on File:\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setChecked(ArchitectureConstants.Y.equals(relOnFile) ? "true" : "false");
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setValue("Y");
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setName("rbRelOnFile");
          _jspx_th_impact_validateInput_5.setId("indRelOnFile");
          _jspx_th_impact_validateInput_5.setLabel("Yes");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setDisabled(disableFields);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setChecked(ArchitectureConstants.N.equals(relOnFile) ? "true" : "false");
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setValue("N");
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setName("rbRelOnFile");
          _jspx_th_impact_validateInput_6.setId("indRelOnFile");
          _jspx_th_impact_validateInput_6.setLabel("No");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setDisabled(disableFields);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setChecked("R".equals(relOnFile) ? "true" : "false");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_7.setValue("R");
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setName("rbRelOnFile");
          _jspx_th_impact_validateInput_7.setId("indRelOnFile");
          _jspx_th_impact_validateInput_7.setLabel("Rescinded");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setDisabled(disableFields);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t\t\t<table>\r\n\t\t\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t<b>Note:Please update the child's Health Log with the Developmental Screen on receipt of the Physician's Health Summary \r\n\t\t\t\t\t\t\t\t\t\tand/or the Developmental Assessment on receipt of the Child Individual Family Service Plan Summary. \r\n\t\t\t\t\t\t\t\t\t\tUpload the documents as appropriate to External Documentation.</b>\r\n\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t</table>\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\t\t\t\tclass=\"tableBorder\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\t\t\tAdditional Information\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t<td width=\"30%\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("szCommts");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("100");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setDisabled(disableFields);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(childrenFirstReferralRetrieveSO.getTxtComments()));
              out.write("\r\n\t\t\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t");

			  if (delete) {
			
          out.write("\r\n\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setForm("frmChildrenFirstReferral");
          _jspx_th_impact_ButtonTag_0.setAction("/investigation/ChildrenFirstReferral/deleteChildrenFirstReferral");
          _jspx_th_impact_ButtonTag_0.setFunction("return confirmDelete()");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			    if (save) {
			
          out.write("\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSave");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setForm("frmChildrenFirstReferral");
          _jspx_th_impact_ButtonTag_1.setAction("/investigation/ChildrenFirstReferral/saveChildrenFirstReferral");
          _jspx_th_impact_ButtonTag_1.setFunction("return confirmSave()");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			
          out.write("\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<input type=\"hidden\" name=\"szCdEventType\" value=\"");
          out.print(szCdEventType);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"dtDtEventOccurred\"\r\n\t\tvalue=\"");
          out.print(dtDtEventOccurred);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"ulIdEvent\" value=\"");
          out.print(ulIdEvent);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"ulIdStage\" value=\"");
          out.print(ulIdStage);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"ulIdPerson\" value=\"");
          out.print(ulIdPerson);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"szTxtEventDescr\"\r\n\t\tvalue=\"");
          out.print(szTxtEventDescr);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"szCdTask\" value=\"");
          out.print(szCdTask);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"szCdEventStatus\"\r\n\t\tvalue=\"");
          out.print(szCdEventStatus);
          out.write("\">\r\n\t<input type=\"hidden\" name=\"evtsLastUpdate\" value=\"");
          out.print(evtsLastUpdate);
          out.write("\">\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<br />\r\n");

  /* begin Forms and Reports  */

      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th>Forms</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n\r\n");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode(pageMode);
      _jspx_th_impact_documentList_0.setTabIndex(tabIndex++);
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  \r\n    ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("Children 1st Referral");
          _jspx_th_impact_document_0.setProtectDocument(protectDoc);
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setDocType("scrnref");
          _jspx_th_impact_document_0.setDocExists(docExists);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write('\r');
              out.write('\n');
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("userId");
              _jspx_th_impact_documentParameter_0.setValue(String.valueOf(userId));
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("                     \r\n");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("stageId");
              _jspx_th_impact_documentParameter_1.setValue(String.valueOf(GlobalData.getUlIdStage(request)));
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pEvent");
              _jspx_th_impact_documentParameter_2.setValue(String.valueOf(GlobalData.getUlIdEvent(request)));
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_3.setName("pCase");
              _jspx_th_impact_documentParameter_3.setValue(String.valueOf(GlobalData.getUlIdCase(request)));
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_4.setName("pStage");
              _jspx_th_impact_documentParameter_4.setValue(String.valueOf(GlobalData.getUlIdStage(request)));
              int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
              if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_5.setName("pPerson");
              _jspx_th_impact_documentParameter_5.setValue(String.valueOf(childrenFirstReferralRetrieveSO.getIdChildReferred()));
              int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
              if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_6 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_6.setName("pUser");
              _jspx_th_impact_documentParameter_6.setValue(String.valueOf(userId));
              int _jspx_eval_impact_documentParameter_6 = _jspx_th_impact_documentParameter_6.doStartTag();
              if (_jspx_th_impact_documentParameter_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_7 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_7.setName("userName");
              _jspx_th_impact_documentParameter_7.setValue(childName);
              int _jspx_eval_impact_documentParameter_7 = _jspx_th_impact_documentParameter_7.doStartTag();
              if (_jspx_th_impact_documentParameter_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n\r\n");

  /* end Forms and Reports */

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");
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
