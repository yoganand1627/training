package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventListWindowStateDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FOSTERCAREAPPSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AfcarsLegStatHistSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FOSTERCAREAPPSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationHelper;
import java.util.List;
import java.util.Map;

public final class EventList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  FOSTERCAREAPPSI fosterCareAppSI = (FOSTERCAREAPPSI) request.getAttribute("INPUT");
  FOSTERCAREAPPSO fosterCareAppSO = (FOSTERCAREAPPSO) request.getAttribute("OUTPUT");
  String formName = "EventList";
  //SIR 15547 - Variables used for launching the ccmn02o1 report.
  String rptCaseID = String.valueOf(GlobalData.getUlIdCaseAsString(request));
  String eventTypeReportFlag = "false";
  String bEventTypeFlag = "false";
  boolean hasApproved = false;

  int tabIndex = 1;
  int caseId = GlobalData.getUlIdCase(request);
  String caseName = GlobalData.getSzNmCase(request);
  //reqPullBack indicates if the caller page is Service Authorization Header
  //and the request is for the Policy Waiver list pullback
  String reqPullBack = ContextHelper.getStringSafe(request,"hdnReqPullBack");
  String reqAdoPullBack = (String) request.getAttribute("hdnAdoPullBack");
  String reqSerAuthAdoPullBack = (String) request.getAttribute("hdnServAuthAdoAssistReqPullBack");
  
  Integer closureEvent = (Integer) request.getAttribute(EventSearchConversation.ID_CLOSURE_EVENT);
  if (closureEvent == null) {
    closureEvent = 0;
  }

  EventDB[] events = EventSearchConversation.getEvents(request);
  

  EventListWindowStateDB eventListWindowState =
          EventSearchConversation.getEventListWindowState(request);

  UserProfile user = UserProfileHelper.getUserProfile(request);

 StringBuffer rowArray = new StringBuffer();

 String statusCode0 = null;
 // MR-074 AFCARS: to prevent delete button display on the empty list on one stage when the person has events in other stage.. 
 // events[] is stage specific but delete enable logic (eventListWindowState.getDeleteEnabled) is case specific. 
 boolean eventListEmpty = events.length <= 0 ? true : false;
 AfcarsLegStatHistSO afcarsLegStat = (AfcarsLegStatHistSO) request.getAttribute("AfcarsLegalStatus");
 List<Map> legStatList = null;
 int legStatSize = 0;
 boolean prevAfcarsReported = false;
 if (afcarsLegStat != null) {
   prevAfcarsReported = afcarsLegStat.isPrevAfcarsReported();
   legStatList = afcarsLegStat.getLegalStatusMapList();
   if (legStatList != null ) {
     legStatSize = legStatList.size();
   }
 }


      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"javascript\">\r\n<!--\r\nvar newUsingEnabled = false;\r\nvar delteEnabled = false;\r\nvar eventArray = new Array(");
      out.print( events.length );
      out.write(");\r\n\r\n");

  for (int i = 0; i < events.length; i++)
  {

      out.write("\r\neventArray[");
      out.print( i );
      out.write("] = new Object();\r\neventArray[");
      out.print( i );
      out.write("].stageCode = \"");
      out.print( events[i].getStageCode() );
      out.write("\";\r\n\r\neventArray[");
      out.print( i );
      out.write("].stageName = \"");
      out.print( FormattingHelper.formatStringSpecialChars(events[i].getStageName(), "\\\"") );
      out.write("\"\r\neventArray[");
      out.print( i );
      out.write("].taskCode = \"");
      out.print( events[i].getTaskCode() );
      out.write("\";\r\neventArray[");
      out.print( i );
      out.write("].caseId = \"");
      out.print( events[i].getCaseId() );
      out.write("\";\r\neventArray[");
      out.print( i );
      out.write("].stageId = \"");
      out.print( events[i].getStageId() );
      out.write("\";\r\neventArray[");
      out.print( i );
      out.write("].eventId = \"");
      out.print( events[i].getEventId() );
      out.write("\";\r\neventArray[");
      out.print( i );
      out.write("].eventStatusCode = \"");
      out.print( events[i].getEventStatusCode() );
      out.write("\";\r\neventArray[");
      out.print( i );
      out.write("].indCurrent = \"");
      out.print( events[i].getIndCurrent() );
      out.write("\";\r\n\r\n\r\n");

if("APRV".equals(events[i].getEventStatusCode())){
hasApproved = true;
}
rowArray.append(events[i].getEventId());
rowArray.append("|");

      out.write("\r\neventArray[");
      out.print( i );
      out.write("].eventStatusCode = \"");
      out.print( events[i].getEventStatusCode() );
      out.write("\";\r\n");
      out.write("\r\neventArray[");
      out.print( i );
      out.write("].personName = \"");
      out.print( FormattingHelper.formatStringSpecialChars(events[i].getPersonName(), "\\\"") );
      out.write("\";\r\neventArray[");
      out.print( i );
      out.write("].newUsingEnabled = ");
      out.print( events[i].getNewUsingEnabled() );
      out.write(";\r\neventArray[");
      out.print( i );
      out.write("].deleteEnabled = ");
      out.print( events[i].getDeleteEnabled() );
      out.write(";\r\n//for new using\r\n");

  }

      out.write('\r');
      out.write('\n');
      out.write("\r\nvar lsArray = new Array(");
      out.print( legStatSize );
      out.write(");\r\nvar prevAfcars = ");
      out.print( prevAfcarsReported );
      out.write(";\r\n\r\n");

for (int j = 0; j < legStatSize; j++)
{

      out.write("\r\n  lsArray[");
      out.print( j );
      out.write("] = new Object();\r\n  lsArray[");
      out.print( j );
      out.write("].eventId = \"");
      out.print( legStatList.get(j).get("ID_LS_EVENT") );
      out.write("\";\r\n  lsArray[");
      out.print( j );
      out.write("].legalStatusCode = \"");
      out.print( legStatList.get(j).get("CD_LS_STATUS") );
      out.write("\";\r\n");

}

      out.write("\r\n\r\nfunction selectEvent(index)\r\n{\r\n  var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n  form.actionStageCode.value = eventArray[index].stageCode;\r\n  form.actionStageName.value = eventArray[index].stageName;\r\n  form.actionTaskCode.value = eventArray[index].taskCode;\r\n  form.actionCaseId.value = eventArray[index].caseId;\r\n  form.actionStageId.value = eventArray[index].stageId;\r\n  form.actionEventId.value = eventArray[index].eventId;\r\n  form.actionEventStatusCode.value = eventArray[index].eventStatusCode;\r\n  form.actionPersonName.value = eventArray[index].personName;\r\n  form.actionItemIndex.value = index;\r\n  newUsingEnabled = eventArray[index].newUsingEnabled;\r\n  deleteEnabled = eventArray[index].deleteEnabled;\r\n  if (form.event)\r\n  {\r\n    if (form.event[0])\r\n    {\r\n      form.event[index].checked = true;\r\n    }\r\n    else\r\n    {\r\n      form.event.checked = true;\r\n    }\r\n  }\r\n}\r\n\r\nfunction restoreIndexVariable()\r\n{\r\n  var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n  var oldIndex = form.actionItemIndex.value;\r\n  if (oldIndex >= 0)\r\n  {\r\n    newUsingEnabled = eventArray[oldIndex].newUsingEnabled;\r\n  }\r\n}\r\n\r\nwindow.attachEvent('onload', restoreIndexVariable);\r\n\r\nfunction newUsing()\r\n{\r\n  var MSG_NO_ROW_SELECTED_CONTINUE =\r\n          \"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_NO_ROW_SELECTED_CONTINUE) );
      out.write("\";\r\n  var MSG_NEW_USING_NOT_AVAIL =\r\n          \"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_NEW_USING_NOT_AVAIL) );
      out.write("\";\r\n\r\n  var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n  //check if radio was selected\r\n  if (form.actionEventId.value == \"\")\r\n  {\r\n    alert(MSG_NO_ROW_SELECTED_CONTINUE);\r\n    return false;\r\n  }\r\n  //check if you are supposed to call newUsing for this event\r\n  if (!newUsingEnabled)\r\n  {\r\n    alert(MSG_NEW_USING_NOT_AVAIL);\r\n    return false;\r\n  }\r\n  disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n  return true;\r\n}\r\n\r\nfunction deleteEvent()\r\n{ \r\n  var MSG_NO_ROW_SELECTED_CONTINUE =\r\n          \"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_NO_ROW_SELECTED_CONTINUE) );
      out.write("\";\r\n  var MSG_DELETE_NOT_AVAIL =\r\n          \"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_DELTE_NOT_AVAIL) );
      out.write("\";\r\n  var MSG_LEGAL_STATUS_DELETE_WARN = \"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_LEGAL_STATUS_DELETE_WARN));
      out.write(" \";\r\n  var MSG_LEG_STAT_AFCARS_DELETE_WARN = \"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_LEG_STAT_AFCARS_DELETE_WARN));
      out.write(" \";\r\n  \r\n  var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n  //check if radio was selected\r\n  if (form.actionEventId.value == \"\")\r\n  {\r\n    alert(MSG_NO_ROW_SELECTED_CONTINUE);\r\n    return false;\r\n  }\r\n  //check if you are supposed to call delete for this event\r\n  if (!deleteEnabled)\r\n  {\r\n    alert(MSG_DELETE_NOT_AVAIL);\r\n    return false;\r\n  }\r\n  // MR-074 AFCARS: this method always executed and returns true b/c it was the only event with Delete function\r\n  // fix return based on event type so it is only executed if CS event, did not change the core logic (note, CS bypass disableValidation)\r\n  if (isContactStandards ()) {\r\n    alert ('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CS_DELETE) );
      out.write("');\r\n    return true;\r\n  }\r\n  // add confirmational message for delete legal status\r\n  if (isDeleteLegalStatusEnable()) {\r\n    if (!confirm(MSG_LEGAL_STATUS_DELETE_WARN)) {\r\n      return false;\r\n    } else { ");
      out.write("\r\n      if (prevAfcars == true) {\r\n      for (var i=0; i < lsArray.length; i++) {\r\n        if (lsArray[i].eventId == form.actionEventId.value && \"NAF\" == lsArray[i].legalStatusCode) {\r\n          if (!confirm(MSG_LEG_STAT_AFCARS_DELETE_WARN)) \r\n            return false;\r\n          else\r\n            return true;\r\n        }\r\n      }\r\n      }\r\n    }\r\n  } else return true;\r\n  \r\n  disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n  return true;\r\n}\r\n\r\nfunction add()\r\n{\r\n");

  if ( closureEvent > 0 )
  {

      out.write("\r\n  var MSG_CMN_INVLD_APRVL =\r\n          \"There is an outstanding stage closure approval request.\\n\" +\r\n          \"Adding a new event will invalidate the closure.  Continue?\";\r\n  if (!confirm(MSG_CMN_INVLD_APRVL))\r\n  {\r\n    return false;\r\n  }\r\n");

  }

      out.write("\r\n  var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n  //Don't disable validation here.  restrictRepost depends on validation.\r\n  //disableValidation(\"");
      out.print( formName );
      out.write("\r\n  return true;\r\n}\r\n\r\nfunction detail(index, eventId)\r\n{\r\n  //I pass in eventId, so url is unique for different pages\r\n  // so you know you viewed this event via the color of your link\r\n  var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n  selectEvent(index);\r\n  disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n  submitValidateForm('");
      out.print( formName );
      out.write("', '");
      out.print( EventSearchConversation.VIEW_EVENT );
      out.write("');\r\n  return false;\r\n}\r\n//-->\r\n\r\nfunction edit()\r\n{\r\n  var MSG_NO_ROW_SELECTED_CONTINUE =\r\n          \"");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_NO_ROW_SELECTED_CONTINUE) );
      out.write("\";\r\n\r\n  var form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n  //check if radio was selected\r\n  if (form.actionEventId.value == \"\")\r\n  {\r\n    alert(MSG_NO_ROW_SELECTED_CONTINUE);\r\n    return false;\r\n  }\r\n  disableValidation(\"");
      out.print( formName );
      out.write("\");\r\n  var valuehdnAdoPullBack = (form.hdnAdoPullBack != null) ? form.hdnAdoPullBack.value : null;\r\n  var valuehdnServAuthAdoAssistReqPullBack = (form.hdnServAuthAdoAssistReqPullBack != null) ? form.hdnServAuthAdoAssistReqPullBack.value : null;\r\n  if(valuehdnAdoPullBack == \"true\" && valuehdnServAuthAdoAssistReqPullBack != \"true\") {\r\n    form.hdnAdoPullBack.value = \"false\";\r\n  }\r\n  \r\n  return true;\r\n}\r\n\r\nfunction isContactStandards (){\r\nvar form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n if (form.actionTaskCode.value == \"6540\" || form.actionTaskCode.value == \"7025\")\r\n  {\r\n    return true;\r\n  }\r\n  return false;\r\n}\r\n");
      out.write("\r\nfunction isDeleteLegalStatusEnable() {\r\nvar form = document.all[\"");
      out.print( formName );
      out.write("\"];\r\n if (form.actionTaskCode.value == \"7230\" || form.actionTaskCode.value == \"4370\" || \r\n     form.actionTaskCode.value == \"8560\" || form.actionTaskCode.value == \"3050\" || \r\n     form.actionTaskCode.value == \"2375\" || form.actionTaskCode.value == \"9050\" || \r\n     form.actionTaskCode.value == \"2040\" )\r\n  {\r\n    return true;\r\n  }\r\n  return false;\r\n}\r\n</script>\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName( formName );
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_validateForm_0.setAction("/not/a/real/path");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");


  String stageCode0 = null;
  if (events.length > 0) {
    stageCode0 = events[0].getStageCode();
    statusCode0 = events[0].getEventTypeCode();
  }


          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("actionStageCode0");
          _jspx_th_impact_validateInput_0.setValue( stageCode0 );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("actionStageClosureEvent");
          _jspx_th_impact_validateInput_11.setValue( String.valueOf(closureEvent) );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_12(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
 // SIR 18642 GRIMSHAN -- set a hidden field so that if the event list has an
// in process event for output launch, the new using pushbutton will not
// be displayed even when pagination occurs.

          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("hdnOutProc");
          _jspx_th_impact_validateInput_13.setValue( String.valueOf(eventListWindowState.getOutProc())  );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("startDate");
          _jspx_th_impact_validateInput_14.setValue( ContextHelper.getStringSafe(request, "startDate") );
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
          _jspx_th_impact_validateInput_15.setName("endDate");
          _jspx_th_impact_validateInput_15.setValue( ContextHelper.getStringSafe(request, "endDate") );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("searchEntireCase");
          _jspx_th_impact_validateInput_16.setValue( ContextHelper.getStringSafe(request, "searchEntireCase") );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  String[] stageCodes = CheckboxHelper.getCheckedValues(request, "stageCode");
  for (int i = 0; i < stageCodes.length; i++) {

          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName( "stageCode" + i );
          _jspx_th_impact_validateInput_17.setValue( stageCodes[i] );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  }

          out.write('\r');
          out.write('\n');

  String[] eventTypeCodes = CheckboxHelper.getCheckedValues(request, "eventTypeCode");
//SIR 15547 - Create a string buffer with with different event types and then
// passed to the SQR report and then used in the SQR sql.
  StringBuffer rptCodedEventTypes = new StringBuffer("");
  for (int i = 0; i < eventTypeCodes.length; i++) {

          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName( "eventTypeCode" + i );
          _jspx_th_impact_validateInput_18.setValue( eventTypeCodes[i] );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

    //SIR 15547 - The format of the String buffer is ~CON@|!ASG@|.  This format is
    // used and then translated in the SQR file.
    rptCodedEventTypes.append("~").append(eventTypeCodes[i]).append("@|");
    bEventTypeFlag = "true";
    if (rptCodedEventTypes.length() > 3) {
      eventTypeReportFlag = "true";
    }
  }
//SIR 15547 - Trim the last character of the string buffer.
  if (rptCodedEventTypes.length() > 2) {
    rptCodedEventTypes.delete(rptCodedEventTypes.length() - 1, rptCodedEventTypes.length());
  }

          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateInput_19(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_20(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_21(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
 // The following if block is to pass the hidden field back when the caller
//page is Service Auth Header and the request is for Policy Waiver. 
          out.write('\r');
          out.write('\n');
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest( "true".equals(reqPullBack));
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_0);
              _jspx_th_impact_validateInput_22.setType("hidden");
              _jspx_th_impact_validateInput_22.setName("hdnReqPullBack");
              _jspx_th_impact_validateInput_22.setValue( reqPullBack );
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest( "true".equals(reqAdoPullBack));
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_1);
              _jspx_th_impact_validateInput_23.setType("hidden");
              _jspx_th_impact_validateInput_23.setName("hdnAdoPullBack");
              _jspx_th_impact_validateInput_23.setValue( reqAdoPullBack );
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_2.setTest( "true".equals(reqSerAuthAdoPullBack));
          int _jspx_eval_impact_ifThen_2 = _jspx_th_impact_ifThen_2.doStartTag();
          if (_jspx_eval_impact_ifThen_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_2);
              _jspx_th_impact_validateInput_24.setType("hidden");
              _jspx_th_impact_validateInput_24.setName("hdnServAuthAdoAssistReqPullBack");
              _jspx_th_impact_validateInput_24.setValue( reqSerAuthAdoPullBack );
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ifThen_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n\r\n");
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n<tr>\r\n<td>\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl( EventSearchConversation.EVENT_LIST );
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <div class=\"alignRight\">\r\n    <div class=\"formInstruct\">Scroll for more information --></div>\r\n  </div>\r\n  </td>\r\n  </tr>\r\n  </table>\r\n\r\n  <div id=\"scroll\" style=\"width:767px; height:250px; overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"1200\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n      <tr class=\"thList\">\r\n        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_3.setTest( eventListWindowState.getNewUsingEnabled()|| eventListWindowState.getDeleteEnabled() || "true".equals(reqPullBack) || "true".equals(reqAdoPullBack));
              int _jspx_eval_impact_ifThen_3 = _jspx_th_impact_ifThen_3.doStartTag();
              if (_jspx_eval_impact_ifThen_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n          <td></td>\r\n        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        <td nowrap width=\"8%\">Date Entered</td>\r\n        <td nowrap width=\"5%\">Status</td>\r\n        <td nowrap width=\"9%\">Type</td>\r\n        ");

        if(EventSearchConversation.isVisitationPlan(ContextHelper.getStringSafe(request, "taskCD"))){
        
              out.write("\r\n        <td nowrap width=\"5%\">Current</td>\r\n        ");

        }
        
              out.write("\r\n        <td nowrap width=\"23%\">Description</td>\r\n        <td nowrap width=\"5%\">Stage</td>\r\n        <td nowrap width=\"13%\">Stage Name</td>\r\n        <td nowrap width=\"8%\">Case ID</td>\r\n        <td nowrap width=\"13%\">Person</td>\r\n        <td nowrap width=\"13%\">Entered By</td>\r\n        <td nowrap width=\"5%\">Event ID</td>\r\n      </tr>\r\n      ");

        for (int i = 0; i < events.length; i++) {
          String tdClass = "";
          if (i % 2 == 1) {
            tdClass = "class=\"altColor\"";
          }
          String enteredBy = events[i].getCaseWorkerName();
          if ("".equals(enteredBy.trim())) {
            //SIR 218 as documented in ccmn51w.win
            enteredBy = EventSearchConversation.SYSTEM_CREATED;
          }
          String onClick = "javascript:selectEvent(" + i + ")";
          String submitted = (events[i].getSubmitted() ? "#" : "");
      
              out.write("\r\n      <tr>\r\n      ");
	
      	  if ((!events[i].getHasEventNavigation() && CodesTables.CEVNTTYP_RVF.equals(events[i].getEventTypeCode()))
					            && (eventListWindowState.getNewUsingEnabled() || eventListWindowState.getDeleteEnabled()
					                || "true".equals(reqPullBack) || "true".equals(reqAdoPullBack))) { //REeval and haswindownavigation to false
					
              out.write("\r\n\t\t\t\t\t<td tabIndex=\"");
              out.print(tabIndex++);
              out.write('"');
              out.write(' ');
              out.print(tdClass);
              out.write(">\r\n\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_25.setType("radio");
              _jspx_th_impact_validateInput_25.setName("event");
              _jspx_th_impact_validateInput_25.setDisabled("true");
              _jspx_th_impact_validateInput_25.setValue("" + i);
              _jspx_th_impact_validateInput_25.setOnClick(onClick);
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t");

		 } else {
		
              out.write("\r\n        ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_4.setTest( eventListWindowState.getNewUsingEnabled() || eventListWindowState.getDeleteEnabled()|| "true".equals(reqPullBack)|| "true".equals(reqAdoPullBack));
              int _jspx_eval_impact_ifThen_4 = _jspx_th_impact_ifThen_4.doStartTag();
              if (_jspx_eval_impact_ifThen_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n          <td tabIndex=\"");
                  out.print( tabIndex++ );
                  out.write('"');
                  out.write(' ');
                  out.print( tdClass );
                  out.write(">\r\n            ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifThen_4);
                  _jspx_th_impact_validateInput_26.setType("radio");
                  _jspx_th_impact_validateInput_26.setName("event");
                  _jspx_th_impact_validateInput_26.setValue( "" + i );
                  _jspx_th_impact_validateInput_26.setOnClick( onClick );
                  int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
                  if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n          </td>\r\n        ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
} 
              out.write("\r\n        <td ");
              out.print( tdClass );
              out.write('>');
              out.print( events[i].getDateEventOccurredString() );
              out.write("\r\n        </td>\r\n        <td ");
              out.print( tdClass );
              out.write('>');
              out.print( events[i].getEventStatusCode() );
              out.write("\r\n        </td>\r\n\r\n        ");
              //  impact:if
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
              _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_if_0.setTest( eventListWindowState.getDetailEnabled() &&
                     events[i].getHasEventNavigation() );
              int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
              if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n          ");
                  //  impact:then
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
                  _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
                  int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
                  if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n          ");
 if (EventSearchConversation.EXCHANGE_CHILD_REG.equals(events[i].getTaskCode()) ||
                 EventSearchConversation.EXCHANGE_HOME_DETAIL.equals(events[i].getTaskCode())){
               if (user.hasRight(UserProfile.SEC_SAU_EXCHANGE)) {
                      out.write("\r\n            \r\n            <td ");
                      out.print( tdClass );
                      out.write('>');
                      out.print( submitted );
                      out.write("<a tabIndex=\"");
                      out.print( tabIndex++ );
                      out.write("\"\r\n                                                  href='javascript:detail(");
                      out.print( "" + i + ", " + events[i].getEventId() );
                      out.write(")'>\r\n              <nobr>");
                      out.print( events[i].getEventTypeDecode() );
                      out.write("\r\n              </nobr>\r\n            </a></td>\r\n            \r\n         ");
    } else { 
                      out.write("\r\n           <td ");
                      out.print( tdClass );
                      out.write('>');
                      out.print( submitted );
                      out.write("\r\n              <nobr>");
                      out.print( events[i].getEventTypeDecode() );
                      out.write("\r\n              </nobr>\r\n            </td>\r\n         ");
    }
             } else { 
                      out.write(" \r\n           <td ");
                      out.print( tdClass );
                      out.write('>');
                      out.print( submitted );
                      out.write("<a tabIndex=\"");
                      out.print( tabIndex++ );
                      out.write("\"\r\n                                                  href='javascript:detail(");
                      out.print( "" + i + ", " + events[i].getEventId() );
                      out.write(")'>\r\n              <nobr>");
                      out.print( events[i].getEventTypeDecode() );
                      out.write("\r\n              </nobr>\r\n            </a></td>\r\n         ");
  } 
                      out.write("\r\n          ");
                      int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n          ");
                  //  impact:else
                  gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
                  _jspx_th_impact_else_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_else_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
                  int _jspx_eval_impact_else_0 = _jspx_th_impact_else_0.doStartTag();
                  if (_jspx_eval_impact_else_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\r\n            <td ");
                      out.print( tdClass );
                      out.write('>');
                      out.print( submitted );
                      out.write("\r\n              <nobr>");
                      out.print( events[i].getEventTypeDecode() );
                      out.write("\r\n              </nobr>\r\n            </td>\r\n          ");
                      int evalDoAfterBody = _jspx_th_impact_else_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_impact_else_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");

        if(EventSearchConversation.isVisitationPlan(ContextHelper.getStringSafe(request, "taskCD"))){
	         if("Y".equalsIgnoreCase(events[i].getIndCurrent())){
	        
              out.write("\r\n\t        <td ");
              out.print( tdClass );
              out.write("><center><input type=\"image\" class=\"md\" border=\"0\" src=\"/grnds-docs/images/shared/checkMark.gif\" alt=\"Current\"></center></td>\r\n\t        ");

	        }
	     
	        else 
	        
	        {
	        
              out.write("\r\n\t        <td ");
              out.print( tdClass );
              out.write("> </td>\r\n\t          \r\n\t         ");

	         
	         
	        }
        }        
        
              out.write("\r\n         \r\n        <td ");
              out.print( tdClass );
              out.write('>');
              out.print( events[i].getEventDescription() );
              out.write("\r\n        </td>\r\n        <td ");
              out.print( tdClass );
              out.write('>');
              out.print( Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, events[i].getStageCode()) );
              out.write("\r\n        </td>\r\n        <td ");
              out.print( tdClass );
              out.write(">\r\n          <nobr>");
              out.print( events[i].getStageName() );
              out.write("\r\n          </nobr>\r\n        </td>\r\n        <td ");
              out.print( tdClass );
              out.write('>');
              out.print( events[i].getCaseId() );
              out.write("\r\n        </td>\r\n        <td ");
              out.print( tdClass );
              out.write(">\r\n          <nobr>");
              out.print( events[i].getPersonName() != null ? events[i].getPersonName() : ""  );
              out.write("\r\n          </nobr>\r\n        </td>\r\n        <td ");
              out.print( tdClass );
              out.write(">\r\n          <nobr>");
              out.print( enteredBy );
              out.write("\r\n          </nobr>\r\n        </td>\r\n        <td ");
              out.print( tdClass );
              out.write('>');
              out.print( events[i].getEventId() );
              out.write("\r\n        </td>\r\n      </tr>\r\n      ");

        }
      
              out.write("\r\n    </table>\r\n  </div>\r\n\r\n  ");
              out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n  <td>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n</td>\r\n</tr>\r\n</table>\r\n\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\" width=\"94%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("delete");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setAction( EventSearchConversation.DELETE_EVENT );
          _jspx_th_impact_ButtonTag_0.setDisabled( "" + ((eventListWindowState.getDeleteEnabled() == false) || eventListEmpty) );
          _jspx_th_impact_ButtonTag_0.setForm( formName );
          _jspx_th_impact_ButtonTag_0.setFunction("return deleteEvent();");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td class=\"alignRight\" width=\"94%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("NewUsing");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setAction( EventSearchConversation.NEW_USING_EVENT );
          _jspx_th_impact_ButtonTag_1.setDisabled( "" + (eventListWindowState.getNewUsingEnabled() == false) );
          _jspx_th_impact_ButtonTag_1.setForm( formName );
          _jspx_th_impact_ButtonTag_1.setFunction("return newUsing();");
          _jspx_th_impact_ButtonTag_1.setImg("btnNewUsing");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

     //Added the "|| "true".equals(reqPullBack)" condition to the disabled attribute value to hide the
     //Add button when the Policy Waiver List is accessed as a pullback.

          out.write("\r\n    <td class=\"alignRight\" width=\"6%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("Add");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setAction( EventSearchConversation.ADD_EVENT );
          _jspx_th_impact_ButtonTag_2.setDisabled( "" + (eventListWindowState.getNewEnabled() == false || "true".equals(reqPullBack) || "true".equals(reqAdoPullBack)) );
          _jspx_th_impact_ButtonTag_2.setForm( formName );
          _jspx_th_impact_ButtonTag_2.setFunction("return add();");
          _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td class=\"alignRight\" width=\"6%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("Edit");
          _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_3.setAction( EventSearchConversation.EDIT_EVENT );
          _jspx_th_impact_ButtonTag_3.setDisabled( "" + (eventListWindowState.getEditEnabled() == false) );
          _jspx_th_impact_ButtonTag_3.setForm( formName );
          _jspx_th_impact_ButtonTag_3.setFunction("return edit();");
          _jspx_th_impact_ButtonTag_3.setImg("btnUpdate");
          _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

     //This is to accomodate the Service Authorization Header page's requirement
      //to access the Policy Waiver List page as a pull back.
      //Begin

          out.write("\r\n    <td class=\"alignRight\" width=\"6%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("Continue");
          _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_4.setAction( EventSearchConversation.CONTINUE_EVENT );
          _jspx_th_impact_ButtonTag_4.setDisabled( "" + (!"true".equals(reqPullBack) && !"true".equals(reqAdoPullBack)) );
          _jspx_th_impact_ButtonTag_4.setForm( formName );
          _jspx_th_impact_ButtonTag_4.setFunction("return edit();");
          _jspx_th_impact_ButtonTag_4.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_4.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n ");
 //end 
          out.write("\r\n  </tr>\r\n</table>\r\n\r\n");

  //  For some reason there's adequate whitespace between event list box and
//  report list as long as there are no buttons.  As soon as one of the
//  3 buttons are enabled, there's no vertical space at all.

          out.write('\r');
          out.write('\n');
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_5.setTest( (eventListWindowState.getNewUsingEnabled() ||
                          eventListWindowState.getDeleteEnabled()||
                          eventListWindowState.getNewEnabled()) );
          int _jspx_eval_impact_ifThen_5 = _jspx_th_impact_ifThen_5.doStartTag();
          if (_jspx_eval_impact_ifThen_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <br>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  window.attachEvent('onload', setHiddenReportParameters);\r\n\r\n  //SIR 15547 - The setHiddenReportParameters and createReportsParameterList functions are used\r\n  // to create the parameters need for the ccmn02o1.\r\n  function setHiddenReportParameters() {\r\n    document.EventList.hdnIdCase.value = \"");
          out.print( rptCaseID );
          out.write("\";\r\n    document.EventList.hdnEventTypes.value = \"");
          out.print( rptCodedEventTypes );
          out.write("\";\r\n    document.EventList.hdnbEventTypeFlag.value = \"");
          out.print( bEventTypeFlag );
          out.write("\";\r\n  }\r\n\r\n  function createReportsParameterList() {\r\n    setReportParameters(\"rptCaseID\", document.EventList.hdnIdCase.value);\r\n    addReportParameter(\"rptCodedEventTypes\", document.EventList.hdnEventTypes.value);\r\n    addReportParameter(\"bEventTypeFlag\", document.EventList.hdnbEventTypeFlag.value);\r\n  }\r\n\r\n</script>\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("hidden");
          _jspx_th_impact_validateInput_27.setName( EventSearchConversation.CALLER );
          _jspx_th_impact_validateInput_27.setValue( EventSearchConversation.getCaller(request) );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
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
      out.write("      \r\n");
if (GlobalData.getSzCdTask(request).equals(EventSearchConversation.PLACEMENT1_SUB)) {
      out.write("\r\n<br>      \r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">      \r\n  <tr>      \r\n     <th colspan=\"4\">Reports</th>      \r\n   </tr>      \r\n   <tr>      \r\n     <td>      \r\n       ");
      //  impact:reportList
      gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag _jspx_th_impact_reportList_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag();
      _jspx_th_impact_reportList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_reportList_0.setParent(null);
      _jspx_th_impact_reportList_0.setPersonId( user.getUserID() );
      _jspx_th_impact_reportList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_reportList_0 = _jspx_th_impact_reportList_0.doStartTag();
      if (_jspx_eval_impact_reportList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("      \r\n         ");
          //  impact:report
          gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
          _jspx_th_impact_report_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_report_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
          _jspx_th_impact_report_0.setUseHiddenParameters(false);
          _jspx_th_impact_report_0.setReportName("PlacementLog00");
          int _jspx_eval_impact_report_0 = _jspx_th_impact_report_0.doStartTag();
          if (_jspx_eval_impact_report_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("      \r\n           ");
              //  impact:reportParameter
              gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag _jspx_th_impact_reportParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag();
              _jspx_th_impact_reportParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_reportParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_report_0);
              _jspx_th_impact_reportParameter_0.setValue( GlobalData.getUlIdStageAsString(request));
              int _jspx_eval_impact_reportParameter_0 = _jspx_th_impact_reportParameter_0.doStartTag();
              if (_jspx_th_impact_reportParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("      \r\n         ");
              int evalDoAfterBody = _jspx_th_impact_report_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_report_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("      \r\n       ");
          int evalDoAfterBody = _jspx_th_impact_reportList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_reportList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("      \r\n     </td>      \r\n   </tr>      \r\n   </table>      \r\n");
      out.write("  \r\n");
}
      out.write('\r');
      out.write('\n');

if( "FCA".equals(statusCode0)){


      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\r\n  <tr>\r\n    <th colspan=\"4\">Form and Report Launch</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    <td>\r\n      ");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode("2");
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n        ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName( hasApproved ? "Eligibility Initial Application":"" );
          _jspx_th_impact_document_0.setProtectDocument(true);
          _jspx_th_impact_document_0.setCheckForNewMode(false);
          _jspx_th_impact_document_0.setDocType("FEL01O00");
          _jspx_th_impact_document_0.setDocExists(false);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pszFacList");
              _jspx_th_impact_documentParameter_0.setValue( rowArray.toString() );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n           ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pCase");
              _jspx_th_impact_documentParameter_2.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n      </td>\r\n  </tr>\r\n</table>\r\n ");

 }
      out.write("\r\n<br>\r\n");
 /* end Forms and Reports */ 
      out.write("\r\n\r\n</script>\r\n");
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

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("actionCaseId");
    _jspx_th_impact_validateInput_1.setValue("");
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
    _jspx_th_impact_validateInput_2.setName("actionEventId");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("actionProgram");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("actionStageCode");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_5.setName("actionStageId");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("actionStageName");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("actionStageType");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("actionTaskCode");
    _jspx_th_impact_validateInput_8.setValue("");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("actionEventStatusCode");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("actionPersonName");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_12.setType("hidden");
    _jspx_th_impact_validateInput_12.setName("actionItemIndex");
    _jspx_th_impact_validateInput_12.setValue("-1");
    int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
    if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_19(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_19.setType("hidden");
    _jspx_th_impact_validateInput_19.setName("hdnIdCase");
    _jspx_th_impact_validateInput_19.setValue("");
    int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
    if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_20(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_20.setType("hidden");
    _jspx_th_impact_validateInput_20.setName("hdnEventTypes");
    _jspx_th_impact_validateInput_20.setValue("");
    int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
    if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_21(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_21.setType("hidden");
    _jspx_th_impact_validateInput_21.setName("hdnbEventTypeFlag");
    _jspx_th_impact_validateInput_21.setValue("");
    int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
    if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
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
