package org.apache.jsp.grnds_002ddocs.intake;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallListSrchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallListStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.intake.CallLogConversation;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

public final class CallLog_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/*  JSP Name:     Call Log
//*  Created by:   Michael Ochu
//*  Date Created: 01/05/2003
//*
//*  Description:
//*  The Call Log page allows a user to search for a particular caller,
//*  collateral, principal, inregard to, or calls taken by an employee.  From
//*  this page, the user can navigate to intake call log (Call Summary) in modify mode via the
//*  New Using menu item or to Call Summary in browse mode via the caller hyperlink.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  08/04/03  CASDORJM          Added in a "return false;" to the generateReportParamList()
//**                              when the user got the alert warning them to complete
//**                              a search first.
//**  4/9/2004  gerryc            SIR 22589 - added tab index for hyperlink of caller name, this
//**                              goes in between the radio button and the New Using button
//**
//** 09/16/2004 Ochumd            Sir 22964 - Added new field I&R Type such that the user can
//**                              now search for an I&R by I&R Type.
//** 01/07/2005 Ochumd            Sir 22965 - Added Hyperlink of Classification. It is enabled
//**                              only When Classification is I&R.
//** 08/24/2005 ochumd            Sir 23788 - Currently, a call log search will return the name
//**                              of the reporter of a case, even if the case is marked sensitive.
//**                              Reporter name now blocked in sensitive cases.
*/


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  
  request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  if (FormValidation.pageHasValidationMessages("frmCallLog", request))
  {
    request.removeAttribute("CallListSrchOutRec");
    request.removeAttribute(CallLogConversation.NO_RESULTS_FOUND);
  }

  String pageMode = PageMode.getPageMode(request);

  String txtFirstName               = "";
  String txtMiddleInt               = "";
  String txtLastName                = "";
  String selszCdStagePersType       = "";
  String selszCdStageClassification = "";
  String txtidStage                 = "";
  String txtNbrUnit                 = "";
  String selszCdIncomingCounty      = "";
  String txtIncomingCallerCity      = "";
  String selszCdStageRegion         = "";
  String selszCdIncomingDisposition = "";
  String selCdStageCurrPriority     = "";
  String dtrangeFrom                = "";
  String dtrangeTo                  = "";
  String szScrTimeFrom              = "";
  String szScrTmTimeTo              = "";
  String selszCdStageNonIncType     = "";
  String onlyButton                 = "true";

  int tabIndex = 1;
  int loopCount = 0;
  Enumeration enumeration = null;

  UserProfile user = UserProfileHelper.getUserProfile(request);
  CallListSrchOutRec cint07so = null;
  cint07so = (CallListSrchOutRec) request.getAttribute("CallListSrchOutRec");

  CallListStruct_ARRAY callListArray = new CallListStruct_ARRAY();

  if (cint07so != null)
  {
    callListArray = cint07so.getCallListStruct_ARRAY();
  }


//get data from the state to populate the search criteria after a search has
// been performed.
  if (request.getParameter("txtFirstName") != null)
  {
    txtFirstName = request.getParameter("txtFirstName");
  }

  if (request.getParameter("txtMiddleInt") != null)
  {
    txtMiddleInt = request.getParameter("txtMiddleInt");
  }

  if (request.getParameter("txtLastName") != null)
  {
    txtLastName = request.getParameter("txtLastName");
  }

  selszCdStagePersType = ContextHelper.getStringSafe(request, "selszCdStagePersType");

  if (request.getAttribute("selszCdStagePersType") != null)
  {
    selszCdStagePersType = (String) request.getAttribute("selszCdStagePersType");
  }

  if (request.getParameter("selszCdStageClassification") != null)
 {
    selszCdStageClassification = request.getParameter("selszCdStageClassification");
    // 5/23/03
 }

  if (request.getParameter("txtIncomingCallerCity") != null)
  {
   txtIncomingCallerCity = request.getParameter("txtIncomingCallerCity");
  }

  if (request.getParameter("txtUlidStage") != null)
  {
    txtidStage = request.getParameter("txtUlidStage");
  }

  if (request.getParameter("txtNbrUnit") != null)
  {
    txtNbrUnit = request.getParameter("txtNbrUnit");
  }

  if (request.getParameter("selszCdIncomingCounty") != null)
  {
    selszCdIncomingCounty = request.getParameter("selszCdIncomingCounty");
  }

  if (request.getParameter("selszCdStageRegion") != null)
  {
    selszCdStageRegion = request.getParameter("selszCdStageRegion");
  }

  if (request.getParameter("selszCdIncomingDisposition") != null)
  {
    selszCdIncomingDisposition = request.getParameter("selszCdIncomingDisposition");
  }

  if (request.getParameter("selCdStageCurrPriority") != null)
  {
    selCdStageCurrPriority = request.getParameter("selCdStageCurrPriority");
  }

  if (request.getParameter("dtrangeFrom") != null)
  {
    dtrangeFrom = request.getParameter("dtrangeFrom");
  }

  if (request.getParameter("dtrangeTo") != null)
  {
    dtrangeTo = request.getParameter("dtrangeTo");
  }

  if (request.getParameter("szScrTimeFrom") != null)
  {
    szScrTimeFrom = request.getParameter("szScrTimeFrom");
  }

  if (request.getParameter("szScrTmTimeTo") != null)
  {
    szScrTmTimeTo = request.getParameter("szScrTmTimeTo");
  }

  if (request.getParameter("selszCdStageNonIncType") != null)
  {
    selszCdStageNonIncType = request.getParameter("selszCdStageNonIncType");
  }



      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n\r\n\r\nfunction submitStage_ID(stageId,personId)\r\n{\r\n  document.frmCallLog.stageId.value = stageId;\r\n  document.frmCallLog.personId.value = personId;\r\n  document.frmCallLog.displayIntakeActionsFromIntakeReportLog.value = \"");
      out.print(ArchitectureConstants.Y);
      out.write("\";\r\n  document.frmCallLog.intakeActionsPageMode.value = \"");
      out.print(PageModeConstants.VIEW);
      out.write("\";\r\n  submitValidateForm(\"frmCallLog\", \"/intake/IntakeActions/displayIntakeActions\");\r\n}\r\n\r\n// This function passes the report parameters to the report architecture. First\r\n// it verifies that a search was performed and rows were returned and the Start\r\n// Date and End Date are not empty.\r\nfunction generateReportParamList()\r\n{\r\n  ");

  enumeration = callListArray.enumerateCallListStruct();
  if ( enumeration.hasMoreElements())
  {
      out.write("\r\n    document.frmCallLog.hdnReportParamRangeFrom.value = document.frmCallLog.dtrangeFrom.value;\r\n    document.frmCallLog.hdnReportParamRangeTo.value = document.frmCallLog.dtrangeTo.value;\r\n    document.frmCallLog.hdnReportParamTimeFrom.value = document.frmCallLog.szScrTimeFrom.value;\r\n    document.frmCallLog.hdnReportParamTimeTo.value = document.frmCallLog.szScrTmTimeTo.value;\r\n\r\n    if (document.frmCallLog.hdnReportParamRangeFrom.value == \"\" ||\r\n         document.frmCallLog.hdnReportParamRangeTo.value == \"\")\r\n    {\r\n      alert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_RANGE_TOO_LONG));
      out.write("\");\r\n      return  false;\r\n    }\r\n\r\n    // Pass stage classification value.\r\n    if (document.frmCallLog.hdnReportParamStageClassification.value != \"\")\r\n    {\r\n      setReportParameters(\"StageClassification\", document.frmCallLog.hdnReportParamStageClassification.value);\r\n    }\r\n    else\r\n    {\r\n      setReportParameters(\"StageClassification\", \"\");\r\n    }\r\n    // Pass stage id value.\r\n    if (document.frmCallLog.hdnReportParamIdStage.value != \"\")\r\n    {\r\n      addReportParameter(\"IdStage\", document.frmCallLog.hdnReportParamIdStage.value);\r\n    }\r\n    else\r\n    {\r\n      addReportParameter(\"IdStage\", \"\");\r\n    }\r\n    // Pass caller city value.\r\n    if (document.frmCallLog.hdnReportParamIncomingCallerCity.value != \"\")\r\n    {\r\n      addReportParameter(\"IncomingCallerCity\", document.frmCallLog.hdnReportParamIncomingCallerCity.value);\r\n    }\r\n    else\r\n    {\r\n      addReportParameter(\"IncomingCallerCity\", \"\");\r\n    }\r\n    // Pass incoming county value.\r\n    if (document.frmCallLog.hdnReportParamIncomingCounty.value != \"\")\r\n");
      out.write("    {\r\n      addReportParameter(\"IncomingCounty\", document.frmCallLog.hdnReportParamIncomingCounty.value);\r\n    }\r\n    else\r\n    {\r\n      addReportParameter(\"IncomingCounty\", \"\");\r\n    }\r\n    // Pass current priority value.\r\n    if (document.frmCallLog.hdnReportParamStageCurrPriority.value != \"\")\r\n    {\r\n      addReportParameter(\"CurrPriority\", document.frmCallLog.hdnReportParamStageCurrPriority.value);\r\n    }\r\n    else\r\n    {\r\n      addReportParameter(\"CurrPriority\", \"\");\r\n    }\r\n    // Pass region value.\r\n    if (document.frmCallLog.hdnReportParamStageRegion.value != \"\")\r\n    {\r\n      addReportParameter(\"Region\", document.frmCallLog.hdnReportParamStageRegion.value);\r\n    }\r\n    else\r\n    {\r\n      addReportParameter(\"Region\", \"\");\r\n    }\r\n    // Pass unit value.\r\n    if (document.frmCallLog.hdnReportParamNbrUnit.value != \"\")\r\n    {\r\n      addReportParameter(\"Unit\", document.frmCallLog.hdnReportParamNbrUnit.value);\r\n    }\r\n    else\r\n    {\r\n      addReportParameter(\"Unit\", \"\");\r\n    }\r\n\r\n    // Pass date from value.\r\n");
      out.write("    addReportParameter(\"DateFrom\", document.frmCallLog.hdnReportParamRangeFrom.value);\r\n\r\n    // Pass time from value.\r\n    if (document.frmCallLog.hdnReportParamTimeFrom.value != \"\")\r\n    {\r\n      addReportParameter(\"TimeFrom\", document.frmCallLog.hdnReportParamTimeFrom.value);\r\n    }\r\n    else\r\n    {\r\n      addReportParameter(\"TimeFrom\", \"\");\r\n    }\r\n\r\n    // Pass date to value.\r\n    addReportParameter(\"DateTo\", document.frmCallLog.hdnReportParamRangeTo.value);\r\n\r\n    // Pass time to value.\r\n    if (document.frmCallLog.hdnReportParamTimeTo.value != \"\")\r\n    {\r\n      addReportParameter(\"TimeTo\", document.frmCallLog.hdnReportParamTimeTo.value);\r\n    }\r\n    else\r\n    {\r\n      addReportParameter(\"TimeTo\", \"\");\r\n    }\r\n\r\n    return true;\r\n  ");

  }
  else
  {
      out.write("\r\n    alert(\"You must perform a search.\");\r\n    return false;\r\n  ");

  }
  
      out.write("\r\n}\r\n\r\n\r\n// This function confirms that the user has selected a row in\r\n// the list box before continuing with the  'New Using'\r\n// procedure.\r\nfunction confirmRowSelected()\r\n{\r\n  var rowSelected = false;\r\n\r\n  //If there is only one radio button, there isn't an array so length is undefined\r\n  if ((document.frmCallLog.rbAddressIndex4.length == undefined) &&\r\n      (document.frmCallLog.rbAddressIndex4.checked))\r\n  {\r\n    rowSelected = true;\r\n  }\r\n  //This handles an array of radio buttons\r\n  for (var i = 0; i < document.frmCallLog.rbAddressIndex4.length; i++)\r\n  {\r\n    if (document.frmCallLog.rbAddressIndex4[i].checked)\r\n    {\r\n      rowSelected = true;\r\n      break;\r\n    }\r\n  }\r\n\r\n  if (rowSelected == false)\r\n  {\r\n    alert(\"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) );
      out.write("\");\r\n    return false;\r\n  }\r\n  return true;\r\n}\r\nfunction setFields(stageId, personId, indicatorSensitive, stageClassification, incomingPriority)\r\n\r\n{\r\n  document.frmCallLog.stageId.value = stageId;\r\n  document.frmCallLog.personId.value = personId;\r\n  document.frmCallLog.indicatorSensitive.value = indicatorSensitive;\r\n  document.frmCallLog.stageClassification.value = stageClassification;\r\n  document.frmCallLog.incomingPriority.value = incomingPriority;\r\n}\r\n</script>\r\n");

// SPB - SIR 19753
boolean noResultsFound = ArchitectureConstants.TRUE.equals(request.getAttribute(CallLogConversation.NO_RESULTS_FOUND));
boolean noPhoneticResultsReturned = ArchitectureConstants.TRUE.equals(request.getAttribute(CallLogConversation.NO_PHONETIC_RESULTS_RETURNED));
if ( request.getAttribute(CallLogConversation.NO_RESULTS_FOUND) != null )
{
  onlyButton = String.valueOf( noResultsFound );
}
else
{
  onlyButton = ArchitectureConstants.TRUE;
}

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCallLog");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/intake/CallLog/displayCallLog");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.intake.CallLogCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setDefaultButton( onlyButton );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n ");
 /* Begin Detail */ 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n     <th colspan=\"8\">Intake Report Query Search Criteria</th>\r\n  </tr>\r\n  <tr>\r\n     <td width=\"220px\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_0.setLabel("Last");
          _jspx_th_impact_validateInput_0.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_0.setConstraint("Name30");
          _jspx_th_impact_validateInput_0.setName("txtLastName");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          _jspx_th_impact_validateInput_0.setValue( txtLastName );
          _jspx_th_impact_validateInput_0.setSize("22");
          _jspx_th_impact_validateInput_0.setMaxLength("22");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n                               \r\n     <td width=\"120px\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setLabel("First");
          _jspx_th_impact_validateInput_1.setConstraint("Name30");
          _jspx_th_impact_validateInput_1.setName("txtFirstName");
          _jspx_th_impact_validateInput_1.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setValue( txtFirstName );
          _jspx_th_impact_validateInput_1.setSize("12");
          _jspx_th_impact_validateInput_1.setMaxLength("12");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n     <td width=\"300px\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_2.setLabel("Middle");
          _jspx_th_impact_validateInput_2.setConstraint("Name30");
          _jspx_th_impact_validateInput_2.setName("txtMiddleInt");
          _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setValue( txtMiddleInt );
          _jspx_th_impact_validateInput_2.setSize("12");
          _jspx_th_impact_validateInput_2.setMaxLength("12");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>    \r\n  </tr>\r\n <tr>\r\n   <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Person Type");
          _jspx_th_impact_validateSelect_0.setName("selszCdStagePersType");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setCodesTable("CCALLLOG");
          _jspx_th_impact_validateSelect_0.setValue(selszCdStagePersType);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  <td width=\"300px\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_validateInput_3.setLabel("Intake Report ID");
          _jspx_th_impact_validateInput_3.setConstraint("Digit16Less");
          _jspx_th_impact_validateInput_3.setName("txtUlidStage");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setValue( txtidStage );
          _jspx_th_impact_validateInput_3.setSize("10");
          _jspx_th_impact_validateInput_3.setMaxLength("10");
          _jspx_th_impact_validateInput_3.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                               \r\n     <td> ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Program Area");
          _jspx_th_impact_validateSelect_1.setName("selszCdStageClassification");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable("CCLASS");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("false");
          _jspx_th_impact_validateSelect_1.setValue( selszCdStageClassification );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("City");
          _jspx_th_impact_validateInput_4.setConstraint("Name20");
          _jspx_th_impact_validateInput_4.setName("txtIncomingCallerCity");
          _jspx_th_impact_validateInput_4.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue( txtIncomingCallerCity );
          _jspx_th_impact_validateInput_4.setSize("20");
          _jspx_th_impact_validateInput_4.setMaxLength("20");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>                               \r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("County");
          _jspx_th_impact_validateSelect_2.setName("selszCdIncomingCounty");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setValue( selszCdIncomingCounty );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n   <td> ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Region");
          _jspx_th_impact_validateSelect_3.setName("selszCdStageRegion");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setCodesTable("CREGIONS");
          _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_3.setValue( selszCdStageRegion );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  <tr>\r\n  <td> ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Disposition");
          _jspx_th_impact_validateSelect_4.setName("selszCdIncomingDisposition");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setCodesTable("CDISP");
          _jspx_th_impact_validateSelect_4.setConditionallyRequired("false");
          _jspx_th_impact_validateSelect_4.setValue( selszCdIncomingDisposition );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n   <td> ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setLabel("Response Time");
          _jspx_th_impact_validateSelect_5.setName("selCdStageCurrPriority");
          _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_5.setCodesTable("CPRIORTY");
          _jspx_th_impact_validateSelect_5.setConditionallyRequired("false");
          _jspx_th_impact_validateSelect_5.setValue( selCdStageCurrPriority );
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                    \r\n  <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setLabel("Unit #");
          _jspx_th_impact_validateInput_5.setName("txtNbrUnit");
          _jspx_th_impact_validateInput_5.setConditionallyRequired("false");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setValue( txtNbrUnit );
          _jspx_th_impact_validateInput_5.setSize("2");
          _jspx_th_impact_validateInput_5.setMaxLength("2");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n                        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Date From");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setValue( dtrangeFrom );
          _jspx_th_impact_validateDate_0.setName("dtrangeFrom");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setConditionallyRequired("false");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n                        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Date To");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setValue( dtrangeTo );
          _jspx_th_impact_validateDate_1.setName("dtrangeTo");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setConditionallyRequired("false");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   <td>\r\n                        ");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_0.setLabel("Time From");
          _jspx_th_impact_validateTime_0.setName("szScrTimeFrom");
          _jspx_th_impact_validateTime_0.setValue( szScrTimeFrom );
          _jspx_th_impact_validateTime_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTime_0.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTime_0 = _jspx_th_impact_validateTime_0.doStartTag();
          if (_jspx_th_impact_validateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n                        ");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_1.setLabel("Time To");
          _jspx_th_impact_validateTime_1.setName("szScrTmTimeTo");
          _jspx_th_impact_validateTime_1.setValue( szScrTmTimeTo );
          _jspx_th_impact_validateTime_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTime_1.setConditionallyRequired("false");
          int _jspx_eval_impact_validateTime_1 = _jspx_th_impact_validateTime_1.doStartTag();
          if (_jspx_th_impact_validateTime_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n <tr>\r\n    <td> ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setLabel("Non Incident Type");
          _jspx_th_impact_validateSelect_6.setName("selszCdStageNonIncType");
          _jspx_th_impact_validateSelect_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_6.setCodesTable("CNIRTYPE");
          _jspx_th_impact_validateSelect_6.setConditionallyRequired("false");
          _jspx_th_impact_validateSelect_6.setValue( selszCdStageNonIncType );
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\"  width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n     ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearchFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setBackSafe("true");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmCallLog");
          _jspx_th_impact_ButtonTag_0.setAction("/intake/CallLog/searchCallLog");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n </tr>\r\n</table>\r\n<br>\r\n");



  if ((noResultsFound || noPhoneticResultsReturned) ||
       ((cint07so != null) &&
         (cint07so.getCallListStruct_ARRAY() != null)))
{
          out.write("\r\n\r\n<br/>\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/intake/CallLog/searchCallLog");
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\" class=\"tableBorder\">\r\n      <tr>\r\n        <th colspan=\"6\">Intake Report Query Search List</th>\r\n      </tr>\r\n      <tr>\r\n         <td class=\"tableBG\">\r\n            <div id=\"scrollBar2\" style=\"height:250px;width:765px;overflow:auto\" class=\"tableborderList\">\r\n                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n                       <tr>\r\n                           <th class=\"thList\">SC</th>\r\n                           <th class=\"thList\">Reporter</th>\r\n                           <th class=\"thList\">Disposition</th>\r\n                           <th class=\"thList\">Intake Date</th>\r\n                           <th class=\"thList\">Intake Time</th>\r\n                           <th class=\"thList\">County</th>\r\n                           <th class=\"thList\">City</th>\r\n                           <th class=\"thList\">Staff Name</th>\r\n                        </tr>\r\n");

                  if (noResultsFound)
                  {

              out.write("\r\n                     <tr class=\"odd\">\r\n                        <td colspan=\"8\">\r\n                           ");
              out.print( MessageLookup.getMessageByNumber(Messages.MSG_INT_NO_MATCHES_FND));
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");

                  } else if (noPhoneticResultsReturned)
                  {

              out.write("\r\n                     <tr class=\"odd\">\r\n                        <td colspan=\"8\">\r\n                           ");
              out.print( MessageLookup.getMessageByNumber(Messages.MSG_PHONETIC_SEARCH_PROCESS_FAILED));
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");

                  }
                    else
                  {
                      loopCount = 0;
                      Enumeration callListEnumeration = callListArray.enumerateCallListStruct();
                      CallListStruct callSearchRow = null;

                    while (callListEnumeration.hasMoreElements())
                    {
                      callSearchRow = (CallListStruct) callListEnumeration.nextElement();
                      
                      

              out.write('\r');
              out.write('\n');

     String checkmarkSpace = "&nbsp;";
    

              out.write("\r\n                        <tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount + 1));
              out.write("\" valign=\"top\">\r\n                                        \r\n                                     \r\n                            <td>");
if (ArchitectureConstants.Y.equals(callSearchRow.getBIndIncmgSensitive())) {
              out.write("\r\n                                     <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" >\r\n                                ");
}else{
              out.write("\r\n                                ");
              out.print( checkmarkSpace );
              out.write("\r\n                                ");
}
              out.write("                           \r\n                            </td>              \r\n                            \r\n");

    
// ochumd Sir 23788 - sensitive cases should not display caller name.

     String callerName = callSearchRow.getSzScrNmIncmgCaller();
     if ((callerName == null)    ||
         (StringHelper.EMPTY_STRING.equals(callerName)) ||
         (ArchitectureConstants.Y.equals(callSearchRow.getBIndIncmgSensitive())))
     {
       callerName = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                  + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
     }

              out.write("\r\n\r\n");



              out.write("\r\n                            <td>\r\n                            ");
if (!ArchitectureConstants.Y.equals(callSearchRow.getBIndIncmgSensitive())) {
              out.write("\r\n                               <a href=\"javascript:submitStage_ID('");
              out.print(callSearchRow.getUlIdStage());
              out.write("', '");
              out.print(callSearchRow.getUlIdIncomingWorker());
              out.write("')\" tabIndex=\"");
              out.print(tabIndex++);
              out.write('"');
              out.write(' ');
              out.write('>');
              out.print( callerName );
              out.write("</a>\r\n                            ");
}else{
              out.write("\r\n                               ");
              out.print( callSearchRow.getSzScrNmIncmgCaller() );
              out.write("\r\n                            ");
}
              out.write("\r\n                            </td>\r\n                            <td>");
              out.print( callSearchRow.getSzCdIncomingDisposition() );
              out.write("</td>\r\n                            <td>");
              out.print( callSearchRow.getDtDtIncomingCall() );
              out.write("</td>\r\n                            <td>\r\n                            ");
if (callSearchRow.getTmTmIncmgCall().length() == 7) {
              out.write("\r\n                                                        \r\n                                &nbsp;&nbsp;");
              out.print( callSearchRow.getTmTmIncmgCall() );
              out.write("\r\n                            ");
}else{
              out.write("\r\n                               ");
              out.print( callSearchRow.getTmTmIncmgCall() );
              out.write("\r\n                            ");
}
              out.write("\r\n                            </td>\r\n                            <td>");
              out.print( Lookup.simpleDecodeSafe("CCOUNT", callSearchRow.getSzCdAddrCounty()) );
              out.write("</td>                            \r\n                            <td>");
              out.print( callSearchRow.getSzAddrCity() );
              out.write("</td>\r\n                            <td>");
              out.print( callSearchRow.getSzScrPersonName() );
              out.write("</td>\r\n                          </tr>\r\n");

                     loopCount++;
                    } // end while
                  }

              out.write("\r\n           </table>\r\n           </div>\r\n        </td>\r\n      </tr>\r\n   </table>");
 /* CLOSE thE ROW thAT HOLDS thE SCROLL BOX */ 
              out.write("\r\n\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<br>\r\n");
}
          out.write("\r\n\r\n<input type=\"hidden\" name=\"hdnReportParamStageClassification\" value=\"");
          out.print(selszCdStageClassification);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamIdStage\" value=\"");
          out.print(txtidStage);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamIncomingCallerCity\" value=\"");
          out.print(txtIncomingCallerCity);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamIncomingCounty\" value=\"");
          out.print(selszCdIncomingCounty);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamIncomingDisposition\" value=\"");
          out.print(selszCdIncomingDisposition);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamStageCurrPriority\" value=\"");
          out.print(selCdStageCurrPriority);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamStageRegion\" value=\"");
          out.print(selszCdStageRegion);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamNbrUnit\" value=\"");
          out.print(txtNbrUnit);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamRangeFrom\" value=\"");
          out.print(dtrangeFrom);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamRangeTo\" value=\"");
          out.print(dtrangeTo);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamTimeFrom\" value=\"");
          out.print(szScrTimeFrom);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamTimeTo\" value=\"");
          out.print(szScrTmTimeTo);
          out.write("\">\r\n<input type=\"hidden\" name=\"hdnReportParamStageNonIncType\" value=\"");
          out.print(selszCdStageNonIncType);
          out.write("\">\r\n\r\n<input type=\"hidden\" name=\"stageId\" value=\"\">\r\n<input type=\"hidden\" name=\"intakePageMode\" value=\"\">\r\n<input type=\"hidden\" name=\"personId\" value=\"\">\r\n<input type=\"hidden\" name=\"indicatorSensitive\" value=\"\">\r\n<input type=\"hidden\" name=\"stageClassification\" value=\"\">\r\n<input type=\"hidden\" name=\"incomingPriority\" value=\"\">\r\n<input type=\"hidden\" name=\"intakeActionsPageMode\" value=\"\">\r\n<input type=\"hidden\" name=\"displayIntakeActionsFromIntakeReportLog\" value=\"\">\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  \r\n");
      out.write("\r\n</table>\r\n<br>");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmCallLog");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
