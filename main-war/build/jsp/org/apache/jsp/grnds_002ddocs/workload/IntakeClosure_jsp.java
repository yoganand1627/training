package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT99SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageRow;
import gov.georgia.dhr.dfcs.sacwis.web.workload.IntakeClosureConversation;
import java.util.List;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

public final class IntakeClosure_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Intake Priority Closure
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 1/10/03
//*
//*  Description:
//*  The Priority/Closure page is used to change the priority of an existing 
//*  Intake that has not been progressed to Investigation.
//*  It can also be used to close CPS Intakes that are non-incident intakes.
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  06/09/03  GRIMSHAN          SIR 16979 get pagemode from page mode instead of
                              from page mode attribute name
  06/11/03  Todd Reser        SIR 18235 - Removed <br> between tables and <hr>
                              before save button.
  06/30/03  CASDORJM          SIR 18590 - The user was getting confused and
                              forgetting what the original current priority was
                               - we added code that will set the Current
                              Priority back to what was originally retrieved
                              after the user recieves the "Invalid Priority for
                              Stage Type." error message.
  07/15/03  CASDORJM          SIR 18855 - Changed logic so that the Forms
                              section would display for all programs that
                              started with a "C" and not just CPS.
  08/07/03  Todd Reser        Added Description.
  05/09/05  ochumd            Sir 23019 - Added 3 new reason closed codes for the
                              new Special Request types to the Special Request Type
                              List:CCL Standards Violation RCL Standards Violation
                              and CPS Foster Home Standards Violation.
  04/17/08  JRAMSPOT          Update to work for Georgia SHINES. STGAP00008086
  
  07/15/08  arege             STGAP00009014 Changed the Comments box under Response Time 
                              validate Text Area name to szTxtStageResponseTimeCmnts in order to
                              separate from the comments box on IntakeActions Page.
                            
                      
  
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String pageMode = PageMode.getPageMode( request );

  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  int tabIndex = 1;

      out.write("\r\n\r\n");


CINT99SO cint99so = (CINT99SO) state.getAttribute( "CINT99SO", request );
StageRow stageRow = new StageRow();
if ( cint99so == null )
{
  cint99so = new CINT99SO();
}
if ( cint99so.getStageRow() != null )
{
  stageRow = cint99so.getStageRow();
}
//setup correct codestables for dropdowns
String currPriCT = IntakeClosureConversation.CT_CURRENT_PRIORITY;
String disableApprovalStatus = "true";

// If the user is entering this page as an approver, there are certain fields that should be disabled.
boolean approvalMode = false;
String approvalAction = ApprovalStatusConversation.DISPLAY_URI;
if (GlobalData.isApprovalMode(request)) {
    approvalMode = true;
    approvalAction = "/workload/IntakePriorityClosure/validateApprv";
}

if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request)) && approvalMode) {
        disableApprovalStatus = "false";
}

String initial     = "";
String initialDecoded = "";
String current     = "";
String dtChanged   = "";
String rsnChanged  = "";
String priComments = "";
String clsComments = "";
String disposition = "";
String screenOutReason = "";
String actionSave = "/workload/IntakePriorityClosure/saveAndSubmitIntakeClosure";

char mymode = (char)Sets.getPageSet( request ).toCharArray()[0];

switch ( mymode )
{
  case 'A':
  case 'B':
    initial = stageRow.getSzCdStageInitialPriority();
    if (StringHelper.isValid(initial)) {
    	initialDecoded = Lookup.simpleDecode(CodesTables.CPRIORTY, initial);
    	if (StringHelper.isValid(initialDecoded) == false) {
    		initialDecoded=initial;
    	}
    }
    current = StringHelper.getNonNullString(stageRow.getSzCdStageCurrPriority());
    dtChanged = FormattingHelper.formatDate( cint99so.getDtSysDtGenericSysdate() );
    rsnChanged = StringHelper.getNonNullString(stageRow.getSzCdStageRsnPriorityChgd());
    //priComments = StringHelper.getNonNullString(stageRow.getSzTxtStagePriorityCmnts());
    priComments = StringHelper.getNonNullString(stageRow.getSzTxtStageResponseTimeCmnts());
  case 'C':
    disposition = StringHelper.getNonNullString(cint99so.getSzCdIncomingDisposition());
    clsComments = StringHelper.getNonNullString(stageRow.getSzTxtStageClosureCmnts());
    screenOutReason = StringHelper.getNonNullString(stageRow.getSzCdStageScroutReason());
    break;
}
List dispOptions = new ArrayList();
Option dispOption = null;
if (mymode == 'C') {
   dispOption = new Option(disposition, Lookup.simpleDecodeSafe(CodesTables.CDISP, disposition));
   dispOptions.add(dispOption);
   dispOption = new Option (CodesTables.CDISP_OIE, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_OIE));
   dispOptions.add(dispOption);
   actionSave = "/workload/IntakePriorityClosure/saveAndCloseIntakeClosure";
}
else {
   // dispOptions = Lookup.getCategoryCollection(CodesTables.CDISP);
   dispOption = new Option (CodesTables.CDISP_ACA, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_ACA));
   dispOptions.add(dispOption);
   dispOption = new Option (CodesTables.CDISP_DIV, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_DIV));
   dispOptions.add(dispOption);
   dispOption = new Option (CodesTables.CDISP_SCO, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_SCO));
   dispOptions.add(dispOption);
   dispOption = new Option (CodesTables.CDISP_SCR, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_SCR));
   dispOptions.add(dispOption);
   dispOption = new Option (CodesTables.CDISP_OIE, Lookup.simpleDecode(CodesTables.CDISP, CodesTables.CDISP_OIE));
   dispOptions.add(dispOption);
}



      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction processChange(value)\r\n{\r\n     priChange();\r\n}\r\n\r\nfunction priChange()\r\n{\r\n  document.frmPriorityClosure.selSzCdStageRsnPriorityChgd.value = \"\";\r\n  document.frmPriorityClosure.szTxtStageResponseTimeCmnts.value = \"\";\r\n}\r\n\r\n");
      out.write("\r\nfunction promptDispositionChange()\r\n{\r\n\r\n  ");
      out.write("\r\n  var retVal = true;\r\n  var value = document.frmPriorityClosure.selSzCdDisp.value;\r\n  if (value == \"OIE\" || value == \"SCO\" || value == \"SCR\" )\r\n  {\r\n    var save = confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_INT_SAVE_DISP)  );
      out.write("');\r\n    if (save == true)\r\n    {\r\n      retVal = true;\r\n    }\r\n    else\r\n    {\r\n      retVal = false;\r\n    }\r\n  }\r\n");
      out.write("\r\n  else\r\n  {\r\n    retVal = true;\r\n  }\r\n  return retVal;\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPriorityClosure");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction(actionSave);
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.IntakeClosureCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n<!-- Hidden Fields -->\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnSzCdStageCurrPriority");
          _jspx_th_impact_validateInput_0.setValue( current );
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
          _jspx_th_impact_validateInput_1.setName("hdnDtDtStageStart");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatDate( stageRow.getDtDtStageStart() ) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnDtSysDtGenericSysdate");
          _jspx_th_impact_validateInput_2.setValue( dtChanged );
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
          _jspx_th_impact_validateInput_3.setName("hdnSzCdIncomingDisposition");
          _jspx_th_impact_validateInput_3.setValue( disposition );
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
          _jspx_th_impact_validateInput_4.setName("mode");
          _jspx_th_impact_validateInput_4.setValue( Sets.getPageSet( request ) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmPriorityClosure");
          _jspx_th_impact_ButtonTag_0.setAction(approvalAction);
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setDisabled(disableApprovalStatus);
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 
 // If the mode is 'C' for modifying a Non-Incident Intake, we do not show the Response Time Section
 if (mymode != 'C') {

          out.write("\t\t\r\n<!--- Begin Detail Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">Response Time</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"20%\">");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzCdStageInitialPriority");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Initial");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( initialDecoded );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selSzCdStageCurrPriority");
          _jspx_th_impact_validateSelect_0.setLabel("Current");
          _jspx_th_impact_validateSelect_0.setValue( current );
          _jspx_th_impact_validateSelect_0.setCodesTable( currPriCT );
          _jspx_th_impact_validateSelect_0.setDisabled( Sets.isNotInSetStr( Sets.B , request ));
          _jspx_th_impact_validateSelect_0.setOnChange("processChange(this.value);");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtSysDtGenericSysdate");
          _jspx_th_impact_validateDate_0.setLabel("Date Changed");
          _jspx_th_impact_validateDate_0.setValue( dtChanged );
          _jspx_th_impact_validateDate_0.setDisabled( Sets.isNotInSetStr( Sets.B , request ));
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selSzCdStageRsnPriorityChgd");
          _jspx_th_impact_validateSelect_1.setLabel("Reason Changed");
          _jspx_th_impact_validateSelect_1.setValue( rsnChanged );
          _jspx_th_impact_validateSelect_1.setDisabled(Sets.isNotInSetStr( Sets.B , request ));
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setCodesTable("CRSNPRIO");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n  \r\n    <td>\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("szTxtStageResponseTimeCmnts");
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setDisabled( Sets.isNotInSetStr( Sets.B , request ));
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph80");
          _jspx_th_impact_validateTextArea_0.setMaxLength(80);
          _jspx_th_impact_validateTextArea_0.setColspan("4");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("40");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.print( priComments );
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
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

}  //end if we need to show Response time section

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Disposition</th>\r\n  </tr>\r\n  <tr>\r\n       <td>\r\n          ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("Disposition");
          _jspx_th_impact_validateSelect_2.setName("selSzCdDisp");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setOptions( dispOptions );
          _jspx_th_impact_validateSelect_2.setDisabled( Sets.isNotInSetStr( Sets.C + Sets.B , request ) );
          _jspx_th_impact_validateSelect_2.setValue( disposition);
          _jspx_th_impact_validateSelect_2.setBlankValue( Sets.isNotInSetStr( Sets.C, request ) );
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n          ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setLabel("Screen Out Reason");
          _jspx_th_impact_validateSelect_3.setName("selSzCdScreenOutReason");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setCodesTable( CodesTables.CSCNOTRN );
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_3.setDisabled( Sets.isNotInSetStr(Sets.B , request ) );
          _jspx_th_impact_validateSelect_3.setValue( screenOutReason );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtaSzTxtStageClosureCmnts");
          _jspx_th_impact_validateTextArea_1.setLabel("Comments");
          _jspx_th_impact_validateTextArea_1.setDisabled( Sets.isNotInSetStr( Sets.C + Sets.B , request ));
          _jspx_th_impact_validateTextArea_1.setColspan("3");
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setRows("4");
          _jspx_th_impact_validateTextArea_1.setCols("70");
          _jspx_th_impact_validateTextArea_1.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.print( clsComments );
              out.write("\r\n                    ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\" width=\"95%\">\r\n");
if ("true".equals(Sets.isInSetStr(Sets.C, request)) && !(approvalMode)) { 
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveAndClose");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndClose");
          _jspx_th_impact_ButtonTag_1.setForm("frmPriorityClosure");
          _jspx_th_impact_ButtonTag_1.setAction("/workload/IntakePriorityClosure/saveAndCloseIntakeClosure");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td class=\"alignRight\" width=\"5%\">\r\n");
} else { out.print("&nbsp;"); }
  if ("true".equals(Sets.isInSetStr(Sets.B, request)) && !(approvalMode)) { 
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setFunction("return promptDispositionChange();");
          _jspx_th_impact_ButtonTag_2.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_2.setForm("frmPriorityClosure");
          _jspx_th_impact_ButtonTag_2.setAction("/workload/IntakePriorityClosure/saveAndSubmitIntakeClosure");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
}
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<!--- End Detail Table --->\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<script language=\"JavaScript\">\r\n   CleanSelect( frmPriorityClosure.selSzCdDisp );\r\n</script>\r\n");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CSTGTYPE");
    _jspx_th_impact_codeArray_0.setArrayName("stageTypes");
    _jspx_th_impact_codeArray_0.setBlankValue("false");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
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
