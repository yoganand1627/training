<%--
JSP Name:     EventList.jsp
Created by:   Matthew McClain
Date Created: 12/17/02

Description:
The Event List page allows a user to view and navigate to the events
associated with stages, cases, people, and other criteria. The page lists
events in chronological order beginning with most recent event

Change History:
Date      User              Description
--------  ----------------  -----------------------------------------------
08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
09/30/04  Eric Dickman      SIR 15547 - Added the ccmn02o1 report to the event
                            list page.
01/05/05  CORLEYAN          TPR Enhancement - Disable the Hyperlinks for
                            users with the Service Level Review Security attribute
09/30/06  AODUTAYO          Verified that person associated with an event on the
                            Person column displays the person or an empty string
02/02/09   hjbaptiste       STGAP00012303: Only users with the SAU Staff attribute 
                            are allowed access to Exchange Child Detail page  
02/20/09   hjbaptiste       STGAP00012303: Added Delete button functionality              
06/04/2010 arege            SMS#52235: Revaluations created before sealing cannot be copied by assigned person and their hierarchy
                            if they don't have SAU sealed attribute.
08/19/2010 wjcochran        SMS#48475: Check for EXCHANGE_HOME_DETAIL events and only display the link for SAU_SEALED users.                           
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.EventDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.EventListWindowStateDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.FOSTERCAREAPPSI" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FOSTERCAREAPPSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationHelper" %>



<%
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



%>

<script type="text/javascript" language="javascript">
function caseSummaryHyperlink(stageId)
{
    disableValidation("<%= formName %>");
    submitValidateForm("<%= formName %>", "/workload/CaseSummary/displayCaseSummary");
}

function stageSummaryHyperlink()
{
    disableValidation("<%= formName %>");
    submitValidateForm("<%= formName %>", "/workload/StageSummary/displayStage");
}

<!--
var newUsingEnabled = false;
var delteEnabled = false;
var eventArray = new Array(<%= events.length %>);
<%
  for (int i = 0; i < events.length; i++)
  {
%>
eventArray[<%= i %>] = new Object();
eventArray[<%= i %>].stageCode = "<%= events[i].getStageCode() %>";

eventArray[<%= i %>].stageName = "<%= FormattingHelper.formatStringSpecialChars(events[i].getStageName(), "\\\"") %>"
eventArray[<%= i %>].taskCode = "<%= events[i].getTaskCode() %>";
eventArray[<%= i %>].caseId = "<%= events[i].getCaseId() %>";
eventArray[<%= i %>].stageId = "<%= events[i].getStageId() %>";
eventArray[<%= i %>].eventId = "<%= events[i].getEventId() %>";
eventArray[<%= i %>].eventStatusCode = "<%= events[i].getEventStatusCode() %>";
<%
if("APRV".equals(events[i].getEventStatusCode())){
hasApproved = true;
}
rowArray.append(events[i].getEventId());
rowArray.append("|");
%>
eventArray[<%= i %>].eventStatusCode = "<%= events[i].getEventStatusCode() %>";
<%-- Eric Dickman (7/14/2003) needed personName in the request for Medical/Mental --%>
eventArray[<%= i %>].personName = "<%= FormattingHelper.formatStringSpecialChars(events[i].getPersonName(), "\\\"") %>";
eventArray[<%= i %>].newUsingEnabled = <%= events[i].getNewUsingEnabled() %>;
eventArray[<%= i %>].deleteEnabled = <%= events[i].getDeleteEnabled() %>;
//for new using
<%
  }
%>

function selectEvent(index)
{
  var form = document.all["<%= formName %>"];
  form.actionStageCode.value = eventArray[index].stageCode;
  form.actionStageName.value = eventArray[index].stageName;
  form.actionTaskCode.value = eventArray[index].taskCode;
  form.actionCaseId.value = eventArray[index].caseId;
  form.actionStageId.value = eventArray[index].stageId;
  form.actionEventId.value = eventArray[index].eventId;
  form.actionEventStatusCode.value = eventArray[index].eventStatusCode;
  form.actionPersonName.value = eventArray[index].personName;
  form.actionItemIndex.value = index;
  newUsingEnabled = eventArray[index].newUsingEnabled;
  deleteEnabled = eventArray[index].deleteEnabled;
  if (form.event)
  {
    if (form.event[0])
    {
      form.event[index].checked = true;
    }
    else
    {
      form.event.checked = true;
    }
  }
}

function restoreIndexVariable()
{
  var form = document.all["<%= formName %>"];
  var oldIndex = form.actionItemIndex.value;
  if (oldIndex >= 0)
  {
    newUsingEnabled = eventArray[oldIndex].newUsingEnabled;
  }
}

window.attachEvent('onload', restoreIndexVariable);

function newUsing()
{
  var MSG_NO_ROW_SELECTED_CONTINUE =
          "<%= MessageLookup.getMessageByNumber(Messages.MSG_NO_ROW_SELECTED_CONTINUE) %>";
  var MSG_NEW_USING_NOT_AVAIL =
          "<%= MessageLookup.getMessageByNumber(Messages.MSG_NEW_USING_NOT_AVAIL) %>";

  var form = document.all["<%= formName %>"];
  //check if radio was selected
  if (form.actionEventId.value == "")
  {
    alert(MSG_NO_ROW_SELECTED_CONTINUE);
    return false;
  }
  //check if you are supposed to call newUsing for this event
  if (!newUsingEnabled)
  {
    alert(MSG_NEW_USING_NOT_AVAIL);
    return false;
  }
  disableValidation("<%= formName %>");
  return true;
}

function deleteEvent()
{
  var MSG_NO_ROW_SELECTED_CONTINUE =
          "<%= MessageLookup.getMessageByNumber(Messages.MSG_NO_ROW_SELECTED_CONTINUE) %>";
  var MSG_DELETE_NOT_AVAIL =
          "<%= MessageLookup.getMessageByNumber(Messages.MSG_DELTE_NOT_AVAIL) %>";
  
  var form = document.all["<%= formName %>"];
  //check if radio was selected
  if (form.actionEventId.value == "")
  {
    alert(MSG_NO_ROW_SELECTED_CONTINUE);
    return false;
  }
  //check if you are supposed to call delete for this event
  if (!deleteEnabled)
  {
    alert(MSG_DELETE_NOT_AVAIL);
    return false;
  }
  
  if (isContactStandards ()) {
    return true;
  }
  
  disableValidation("<%= formName %>");
  return true;
}

function add()
{
<%
  if ( closureEvent > 0 )
  {
%>
  var MSG_CMN_INVLD_APRVL =
          "There is an outstanding stage closure approval request.\n" +
          "Adding a new event will invalidate the closure.  Continue?";
  if (!confirm(MSG_CMN_INVLD_APRVL))
  {
    return false;
  }
<%
  }
%>
  var form = document.all["<%= formName %>"];
  //Don't disable validation here.  restrictRepost depends on validation.
  //disableValidation("<%= formName %>
  return true;
}

function detail(index, eventId)
{
  //I pass in eventId, so url is unique for different pages
  // so you know you viewed this event via the color of your link
  var form = document.all["<%= formName %>"];
  selectEvent(index);
  disableValidation("<%= formName %>");
  submitValidateForm('<%= formName %>', '<%= EventSearchConversation.VIEW_EVENT %>');
  return false;
}
//-->

function edit()
{
  var MSG_NO_ROW_SELECTED_CONTINUE =
          "<%= MessageLookup.getMessageByNumber(Messages.MSG_NO_ROW_SELECTED_CONTINUE) %>";

  var form = document.all["<%= formName %>"];
  //check if radio was selected
  if (form.actionEventId.value == "")
  {
    alert(MSG_NO_ROW_SELECTED_CONTINUE);
    return false;
  }
  disableValidation("<%= formName %>");
  var valuehdnAdoPullBack = (form.hdnAdoPullBack != null) ? form.hdnAdoPullBack.value : null;
  var valuehdnServAuthAdoAssistReqPullBack = (form.hdnServAuthAdoAssistReqPullBack != null) ? form.hdnServAuthAdoAssistReqPullBack.value : null;
  if(valuehdnAdoPullBack == "true" && valuehdnServAuthAdoAssistReqPullBack != "true") {
    form.hdnAdoPullBack.value = "false";
  }
  
  return true;
}

function isContactStandards (){
var form = document.all["<%= formName %>"];
 if (form.actionTaskCode.value == "6540" || form.actionTaskCode.value == "7025")
  {
    alert ('<%= MessageLookup.getMessageByNumber(Messages.MSG_CS_DELETE) %>');
  }
  return true;
}
</script>


<impact:validateForm name="<%= formName %>"
                     method="post"
                     pageMode="<%= PageModeConstants.EDIT %>"
                     action='/not/a/real/path'
                     schema="/WEB-INF/Constraints.xsd">

<%

  String stageCode0 = null;
  if (events.length > 0) {
    stageCode0 = events[0].getStageCode();
    statusCode0 = events[0].getEventTypeCode();
  }

%>
<%-- for Add --%>
<impact:validateInput type="hidden" name="actionStageCode0" value='<%= stageCode0 %>'/>
<%-- for All --%>
<impact:validateInput type="hidden" name="actionCaseId" value=''/>
<impact:validateInput type="hidden" name="actionEventId" value=''/>
<impact:validateInput type="hidden" name="actionProgram" value=''/>
<impact:validateInput type="hidden" name="actionStageCode" value=''/>
<impact:validateInput type="hidden" name="actionStageId" value=''/>
<impact:validateInput type="hidden" name="actionStageName" value=''/>
<impact:validateInput type="hidden" name="actionStageType" value=''/>
<impact:validateInput type="hidden" name="actionTaskCode" value=''/>
<impact:validateInput type="hidden" name="actionEventStatusCode" value=''/>
<impact:validateInput type="hidden" name="actionPersonName" value=''/>
<impact:validateInput type="hidden" name="actionStageClosureEvent" value='<%= String.valueOf(closureEvent) %>'/>
<impact:validateInput type="hidden" name="actionItemIndex" value='-1'/>
<% // SIR 18642 GRIMSHAN -- set a hidden field so that if the event list has an
// in process event for output launch, the new using pushbutton will not
// be displayed even when pagination occurs.
%>
<impact:validateInput type="hidden" name="hdnOutProc"
                      value='<%= String.valueOf(eventListWindowState.getOutProc())  %>'/>

<%-- preserve the initial request parameters from EventSearch so pagination works correctly --%>
<impact:validateInput type="hidden" name="startDate" value='<%= ContextHelper.getStringSafe(request, "startDate") %>'/>
<impact:validateInput type="hidden" name="endDate" value='<%= ContextHelper.getStringSafe(request, "endDate") %>'/>

<impact:validateInput type="hidden"
                      name="searchEntireCase"
                      value='<%= ContextHelper.getStringSafe(request, "searchEntireCase") %>'/>
<%
  String[] stageCodes = CheckboxHelper.getCheckedValues(request, "stageCode");
  for (int i = 0; i < stageCodes.length; i++) {
%>
<impact:validateInput type="hidden"
                      name='<%= "stageCode" + i %>'
                      value='<%= stageCodes[i] %>'/>
<%
  }
%>
<%
  String[] eventTypeCodes = CheckboxHelper.getCheckedValues(request, "eventTypeCode");
//SIR 15547 - Create a string buffer with with different event types and then
// passed to the SQR report and then used in the SQR sql.
  StringBuffer rptCodedEventTypes = new StringBuffer("");
  for (int i = 0; i < eventTypeCodes.length; i++) {
%>
<impact:validateInput type="hidden"
                      name='<%= "eventTypeCode" + i %>'
                      value='<%= eventTypeCodes[i] %>'/>
<%
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
%>

<impact:validateInput type="hidden" name="hdnIdCase" value=""/>
<impact:validateInput type="hidden" name="hdnEventTypes" value=""/>
<impact:validateInput type="hidden" name="hdnbEventTypeFlag" value=""/>
<% // The following if block is to pass the hidden field back when the caller
//page is Service Auth Header and the request is for Policy Waiver. %>
<impact:ifThen test="<%= "true".equals(reqPullBack)%>">
  <impact:validateInput type="hidden" name="hdnReqPullBack" value='<%= reqPullBack %>'/>
</impact:ifThen>

<impact:ifThen test="<%= "true".equals(reqAdoPullBack)%>">
  <impact:validateInput type="hidden" name="hdnAdoPullBack" value='<%= reqAdoPullBack %>'/>
</impact:ifThen>

<impact:ifThen test="<%= "true".equals(reqSerAuthAdoPullBack)%>">
  <impact:validateInput type="hidden" name="hdnServAuthAdoAssistReqPullBack" value='<%= reqSerAuthAdoPullBack %>'/>
</impact:ifThen>

<div id="caseStageHeaderInfo">
  <span id="caseNameInfo">
		Case: <a href='<%="javascript:caseSummaryHyperlink();"%>'
                               onClick="window.onBeforeUnload=null;" tabIndex="0"
          ><%=GlobalData.getSzNmCase( request )%>
   </a>
  </span>
  <span id="stageNameInfo">
		 Stage: <a href='<%="javascript:stageSummaryHyperlink();"%>'
                               onClick="window.onBeforeUnload=null;" tabIndex="0"
          >
		 <%=GlobalData.getSzNmStage( request )%>, <%=Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, GlobalData.getSzCdStage( request ))%>
		 </a>
  </span>
</div>

<div id="pageNav">
<ul>
	<li class="lvl2NavSelect tab">Placement List</li>
</ul>
</div>

<impact:validateErrors/>


<%-- This is so Previous/Next align correctly with the table --%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
<tr>
<td>
<impact:pagination submitUrl="<%= EventSearchConversation.EVENT_LIST %>" saveState="false">
  </td>
  </tr>
  </table>

  <div id="eventListTbl">
    <impact:if test='<%= events.length <= 0 %>'>
		<impact:then>
			<span id="noAvail">No events available</span>
		</impact:then>
     <impact:else>
	    <table width="100%" border="0" cellspacing="0" cellpadding="3">
	      <tr class="thList">
	        <impact:ifThen test="<%= eventListWindowState.getNewUsingEnabled()|| eventListWindowState.getDeleteEnabled() || "true".equals(reqPullBack) || "true".equals(reqAdoPullBack)%>">
	          <td></td>
	        </impact:ifThen>
	        <td nowrap>Date Entered</td>
	        <td nowrap>Status</td>
	        <td nowrap>Description</td>
	        <td nowrap>Entered By</td>
	        <td nowrap>Event ID</td>
	      </tr>
	      <%
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
	      %>
	      <tr>
	      <%	
	      	  if ((!events[i].getHasEventNavigation() && CodesTables.CEVNTTYP_RVF.equals(events[i].getEventTypeCode()))
						            && (eventListWindowState.getNewUsingEnabled() || eventListWindowState.getDeleteEnabled()
						                || "true".equals(reqPullBack) || "true".equals(reqAdoPullBack))) { //REeval and haswindownavigation to false
						%>
						<td tabIndex="<%=tabIndex++%>" <%=tdClass%>>
							<impact:validateInput type="radio" name="event" disabled="true"
								value='<%="" + i%>' onClick='<%=onClick%>' />
						</td>
			<%
			 } else {
			%>
	        <impact:ifThen test="<%= eventListWindowState.getNewUsingEnabled() || eventListWindowState.getDeleteEnabled()|| "true".equals(reqPullBack)|| "true".equals(reqAdoPullBack)%>">
	          <td tabIndex="<%= tabIndex++ %>" <%= tdClass %>>
	            <impact:validateInput type="radio"
	                                  name="event"
	                                  value='<%= "" + i %>'
	                                  onClick='<%= onClick %>'/>
	          </td>
	        </impact:ifThen>
	        <%} %>
	        <td <%= tdClass %>><%= events[i].getDateEventOccurredString() %>
	        </td>
	        <td <%= tdClass %>><%= events[i].getEventStatusCode() %>
	        </td>
	        <td <%= tdClass %>><%= events[i].getEventDescription() %>
	        </td>
	        <td <%= tdClass %>>
	          <nobr><%= enteredBy %>
	          </nobr>
	        </td>
	        <td <%= tdClass %>><%= events[i].getEventId() %>
	        </td>
	      </tr>
	      <%
	        }
	      %>
	    </table>
     </impact:else>
    </impact:if>
  </div>

  <%-- This is so Previous/Next align correctly with the table --%>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
  <td>
</impact:pagination>
</td>
</tr>
</table>


<%
  //  For some reason there's adequate whitespace between event list box and
//  report list as long as there are no buttons.  As soon as one of the
//  3 buttons are enabled, there's no vertical space at all.
%>
<impact:ifThen test="<%= (eventListWindowState.getNewUsingEnabled() ||
                          eventListWindowState.getDeleteEnabled()||
                          eventListWindowState.getNewEnabled()) %>">
  <br>
</impact:ifThen>

<script type="text/javascript" language="JavaScript1.2">
  window.attachEvent('onload', setHiddenReportParameters);

  //SIR 15547 - The setHiddenReportParameters and createReportsParameterList functions are used
  // to create the parameters need for the ccmn02o1.
  function setHiddenReportParameters() {
    document.EventList.hdnIdCase.value = "<%= rptCaseID %>";
    document.EventList.hdnEventTypes.value = "<%= rptCodedEventTypes %>";
    document.EventList.hdnbEventTypeFlag.value = "<%= bEventTypeFlag %>";
  }

  function createReportsParameterList() {
    setReportParameters("rptCaseID", document.EventList.hdnIdCase.value);
    addReportParameter("rptCodedEventTypes", document.EventList.hdnEventTypes.value);
    addReportParameter("bEventTypeFlag", document.EventList.hdnbEventTypeFlag.value);
  }

</script>

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>

<br>
<% /* end Forms and Reports */ %>

</script>
