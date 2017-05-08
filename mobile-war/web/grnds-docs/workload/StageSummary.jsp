<%--
JSP Name:     Stage Summary
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.workload.CFMgmntValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSummaryConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseErrorsSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWarningsSO" %>

<%
String pageMode = PageModeConstants.MODIFY;
 BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
 String incomingDetail = FormattingHelper.formatLong((Integer) state.getAttribute("INCOMING_DETAIL_ID", request));
 String pageNotAva = (String) state.getAttribute("pageNotAva", request);
  
%>

<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.OrderedMap"%>
<%@page import="java.util.Set"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.workload.StageSummaryConversation"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.contacts.ContactSearchListDetailConversation"%>
<script type="text/javascript" language="JavaScript1.2">
function caseSummaryHyperlink(stageId)
{
    disableValidation("frmStageSummary");
    submitValidateForm("frmStageSummary", "/workload/CaseSummary/displayCaseSummary");
}

function contactHyperlink(taskCD)
{
    disableValidation("frmStageSummary");
    submitValidateForm("frmStageSummary", "/contacts/ContactSearchListDetail/displayContactSearchList?taskCD=" + taskCD);
}

function SubmitCallNarrForm()
{
        document.callnarrform.submit();
}

function stageSummaryHyperlink()
{
	document.frmStageSummary.hdnPageNotAva.value = "true";
    disableValidation("frmStageSummary");
    submitValidateForm("frmStageSummary", "/workload/StageSummary/displayStage");
}

function stageSummaryHyperlinkTwo()
{
	document.frmStageSummary.hdnPageNotAva.value = "false";
    disableValidation("frmStageSummary");
    submitValidateForm("frmStageSummary", "/workload/StageSummary/displayStage");
}

function placementHyperlink(taskCD) 
{
    disableValidation("frmStageSummary");
    submitValidateForm("frmStageSummary", "/workload/EventSearch/displayEventList?taskCD=" + taskCD);
}
</script>

<impact:validateErrors/>
<impact:validateForm name="frmStageSummary"
                     method="post"
                     action="/workload/StageSummary/displayStageSummary"
                     pageMode="<%=pageMode%>"
                     schema="/WEB-INF/Constraints.xsd">
					 

<div id="caseStageHeaderInfo">
  <span id="caseNameInfo">
   <%if(FormattingHelper.formatString(GlobalData.getSzNmCase( request )).length() > 0) { %>
	   Case: <a href='<%="javascript:caseSummaryHyperlink( \"" + GlobalData.getUlIdStage( request ) + "\" );"%>'
			  onClick="window.onBeforeUnload=null;" tabIndex="0"
     ><%=GlobalData.getSzNmCase( request )%>
   </a>
  </span>
  <span id="stageNameInfo">
	 <%} 
	 if("true".equals(pageNotAva) == true) { %>
		  Stage: <a href='<%="javascript:stageSummaryHyperlinkTwo();"%>'
			onClick="window.onBeforeUnload=null;" tabIndex="0"
   >
	  <%=GlobalData.getSzNmStage( request )%>, <%=Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, GlobalData.getSzCdStage( request ))%>
	 
	 <%} else {%>
	  Stage: <%=GlobalData.getSzNmStage( request )%>, <%=Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, GlobalData.getSzCdStage( request ))%>
	 <%} %>
 </span>
</div>
<div id="pageNav">
<ul>
	<li class="lvl2NavSelect tab">Stage Options</li>
</ul>
</div>
<div id="appMenu">
<ul id="stageMenu">
<% if("INV".equals(GlobalData.getSzCdStage( request )) && ("true".equals(pageNotAva) == false)) {%>
  <li>
    <a href='<%="javascript:SubmitCallNarrForm();"%>' tabIndex="0">Intake Report</a>
  </li>
  <li>
	<a href='<%="javascript:contactHyperlink( " + ContactSearchListDetailConversation.CONTACTS_INV + " );"%>'
                            onClick="window.onBeforeUnload=null;" tabIndex="1"
       >Contacts
     </a>
  </li>
<%} else if ("DIV".equals(GlobalData.getSzCdStage( request )) && ("true".equals(pageNotAva) == false)) {%>
  <li>
    <a href='<%="javascript:SubmitCallNarrForm();"%>' tabIndex="0">Intake Report</a>
  </li>
  <li>
	<a href='<%="javascript:contactHyperlink( " + ContactSearchListDetailConversation.CONTACTS_DIV + " );"%>'
                            onClick="window.onBeforeUnload=null;" tabIndex="1"
       >Contacts
     </a>
  </li>
<%} else if ("FSU".equals(GlobalData.getSzCdStage( request )) && ("true".equals(pageNotAva) == false)) { %>
  <li>
	<a href='<%="javascript:contactHyperlink( " + ContactSearchListDetailConversation.CONTACTS_FSU + " );"%>'
                            onClick="window.onBeforeUnload=null;" tabIndex="1"
       >Contacts
     </a>
  </li>
<%} else if ("FPR".equals(GlobalData.getSzCdStage( request )) && ("true".equals(pageNotAva) == false)) {%>
  <li>
	<a href='<%="javascript:contactHyperlink( " + ContactSearchListDetailConversation.CONTACTS_FPR + " );"%>'
                            onClick="window.onBeforeUnload=null;" tabIndex="1"
       >Contacts
     </a>
  </li>
<%} else if ("SUB".equals(GlobalData.getSzCdStage( request ))) { %>
  <li>
	<a href='<%="javascript:contactHyperlink( " + ContactSearchListDetailConversation.CONTACTS_SUB + " );"%>'
                            onClick="window.onBeforeUnload=null;" tabIndex="1"
       >Contacts
     </a>
  </li>
  <li>
	<a href='<%="javascript:placementHyperlink(" + StageSummaryConversation.SUB_PLC_TASK_CODE + ");"%>'
                              onClick="window.onBeforeUnload=null;" tabIndex="1"
         >Placement List
    </a>
  </li>
<%} else if ("ADO".equals(GlobalData.getSzCdStage( request ))) { %>
  <li>
	<a href='<%="javascript:contactHyperlink( " + ContactSearchListDetailConversation.CONTACTS_ADO + " );"%>'
                            onClick="window.onBeforeUnload=null;" tabIndex="1"
       >Contacts
     </a>
  </li>
  <li>
	<a href='<%="javascript:placementHyperlink(" + StageSummaryConversation.ADO_PLC_TASK_CODE + ");"%>'
                              onClick="window.onBeforeUnload=null;" tabIndex="1"
         >Placement List
    </a>
  </li>
<%} else if ("PAD".equals(GlobalData.getSzCdStage( request ))) { %>
  <li>
	<a href='<%="javascript:contactHyperlink( " + ContactSearchListDetailConversation.CONTACTS_PAD + " );"%>'
                            onClick="window.onBeforeUnload=null;" tabIndex="1"
       >Contacts
     </a>
  </li>
  <li>
	<a href='<%="javascript:placementHyperlink(" + StageSummaryConversation.PAD_PLC_TASK_CODE + ");"%>'
                              onClick="window.onBeforeUnload=null;" tabIndex="1"
         >Placement List
    </a>
  </li>
<%} else if ("PFC".equals(GlobalData.getSzCdStage( request ))) { %>
  <li>
	<a href='<%="javascript:contactHyperlink( " + ContactSearchListDetailConversation.CONTACTS_PFC + " );"%>'
                            onClick="window.onBeforeUnload=null;" tabIndex="1"
       >Contacts
     </a>
  </li>
  <li>
	<a href='<%="javascript:placementHyperlink(" + StageSummaryConversation.PFC_PLC_TASK_CODE + ");"%>'
                              onClick="window.onBeforeUnload=null;" tabIndex="1"
         >Placement List
    </a>
  </li>
<%} else {%>
	<li>
		<p>No Links Currently Available for Stage Type: <%=GlobalData.getSzCdStage(request)%></p>
	</li>

<%}%>
</ul>
</div>
<impact:validateInput type="hidden" name="pageMode" value=""/>
<impact:validateInput type="hidden" name="hdnPageNotAva" value=""/>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
<form name='callnarrform' action="/document/DocumentConversation/showDocument" method="post" style="display:none" id="callnarr" name="callnarr">
	<input type="hidden" name="docType" value="mobilecfin01o00">
	<input type="hidden" name="docExists" value="false">
	<input type="hidden" name="checkStage" value="0">
	<input type="hidden" name="promptSavePage" value="null">
	<input type="hidden" name="postInSameWindow" value="false">
	<input type="hidden" name="deleteDocument" value="false">
	<input type="hidden" name="renderFormat" value="HTML_WITHOUT_SHELL">
	<input type="hidden" name="modeOfPage" value="4">
	<input type="hidden" name="hiddenField">
	<input type="hidden" name="level1Tab" value="INTAKE_INTAKE" >
	<input type="hidden" name="level2Tab" value="INTAKE_ACTIONS_INTAKEACTIONS" >
	<input type="hidden" name="level3Tab" value="null" >
	<input type="hidden" name="checkForNewMode" value="false">
	<input type="hidden" name="preFillAlways" value="false">
	<input type="hidden" name="onClick" value="null">
	<input type="hidden" name="windowName" value="16919198">
	<input type="hidden" name="promptNoDocument" value="false">
	<input type="hidden" name="pStage" value="<%=incomingDetail%>"></form>




