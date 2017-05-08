

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.DiversionCnclsnRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.investigation.DiversionCnclsnConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%
 int tabIndex = 1;
 BaseSessionStateManager state = 
        (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

//Set the page mode to the mode that is passed in
String pageMode = PageModeConstants.EDIT;
if (PageMode.getPageMode(request) != null) {
   pageMode = PageMode.getPageMode(request);
}        
 boolean docExists = false;
 boolean protectNarrative = false;
 boolean sDisableDispstnDropDwn = false;
 String eventStatus = "";
 String aprvEventStatus = "";
 String txtUlIdEvent = "";
 String txtUlIdStage = "";
 String txtUlIdCase = "";
 String IntakeReceived = "";
 String IntakeProgressed = "";
 String ResponseDate = "";
 String szCdDisposition = "";
 Date dtDiversionComplt = null;
 boolean approvalStatus = false;
 DiversionCnclsnRetrieveSO diversionCnclsnRetrieveSO  = (DiversionCnclsnRetrieveSO)state.getAttribute("DiversionCnclsnRetrieveSO", request);
 if(diversionCnclsnRetrieveSO != null){
 docExists = (ArchitectureConstants.TRUE).equals(diversionCnclsnRetrieveSO.getBIndBLOBExistsInDatabase());
   txtUlIdEvent = Integer.toString(diversionCnclsnRetrieveSO.getIdDiversionCnclsn());
   txtUlIdStage = Integer.toString(diversionCnclsnRetrieveSO.getIdStage());
   txtUlIdCase = Integer.toString(diversionCnclsnRetrieveSO.getIdCase());
   IntakeReceived = FormattingHelper.formatDate(diversionCnclsnRetrieveSO.getDtIntakeRecvd());
   IntakeProgressed = FormattingHelper.formatDate(diversionCnclsnRetrieveSO.getDtIntakeProgressed());
   dtDiversionComplt = diversionCnclsnRetrieveSO.getDtDiversionTaskCompleted();
   if(diversionCnclsnRetrieveSO.getDtResponse() != null)
     ResponseDate = FormattingHelper.formatDate(diversionCnclsnRetrieveSO.getDtResponse());
   if(StringHelper.isValid(diversionCnclsnRetrieveSO.getSzCdDisposition()))
     szCdDisposition = diversionCnclsnRetrieveSO.getSzCdDisposition();
   approvalStatus = diversionCnclsnRetrieveSO.isApprovalStatus();
 }

boolean saveAndSubmit= false;
boolean save = false;

//MR-072
String warnRecordsCheckNotCompleted = (String) request.getAttribute("warnRecordsCheckNotCompleted");
 
if (pageMode.equals(PageModeConstants.VIEW))
{
     sDisableDispstnDropDwn = true;     
     save = false;
     saveAndSubmit = false;
}
else if (pageMode.equals(PageModeConstants.NEW))
{
     sDisableDispstnDropDwn = false;     
     saveAndSubmit = true;
     save = true;
}
else 
{
     sDisableDispstnDropDwn = false;
     save = true;
     saveAndSubmit = false;     
          
     String isCurrApprover = (String)state.getAttribute("ISCURRENTAPPROVER", request);
     if(isCurrApprover != null && ArchitectureConstants.Y.equals(isCurrApprover))
     {
      sDisableDispstnDropDwn = false;
     }
          
     if(ArchitectureConstants.N.equals(isCurrApprover))
     {
     	sDisableDispstnDropDwn = false;
     	save = true;
     	saveAndSubmit = true;
     }
     
}
 
eventStatus = CaseUtility.getEvent(GlobalData.getUlIdStage(request), 
				   GlobalData.getSzCdTask(request)).getCdEventStatus();
				   

%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
}

//MR-072 
function showRecordsCheckConfirmation ()
{
  <%if ("Y".equals(warnRecordsCheckNotCompleted)) {%>
    saveAndSubmitClicked = '<%=StringHelper.isValid(request.getParameter("btnSaveAndSubmit" + ".x"))%>';
    warnRecordsCheckCompleted();
  <%}%>
}

function warnRecordsCheckCompleted()    
{
  if ('true' == saveAndSubmitClicked) 
  {
    if(confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_RECORDS_CHECK_WARN)%>" ))
    {
      document.frmDiversionCnclsn.hdnRecordsCheckCompletedConfirmed.value = 'Y';
      submitValidateForm('frmDiversionCnclsn', '/investigation/DiversionCnclsn/saveSubmitDiversionCnclsn');
    }
  } 
}

function setRecordsCheckCompletedConfirmed()
{
  document.frmDiversionCnclsn.hdnRecordsCheckCompletedConfirmed.value = 'N';
}

</script>

<impact:validateErrors />
<impact:validateForm
  name="frmDiversionCnclsn"
  method="post"
  action="/investigation/DiversionCnclsn/displayDiversionCnclsn"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.DiversionCnclsnValidation"
  schema="/WEB-INF/Constraints.xsd"
  pageMode="<%=pageMode%>">

<%
  String strFunction = "disableValidation('frmDiversionCnclsn');";
  String strAction = "/workload/ApprovalStatus/displayStatus";
  if(approvalStatus){
%>
  <table width="100%" border="0" cellspacing="0" cellpadding="3">
    <tr>
    <td align='left'>
        <impact:ButtonTag
        name="btnApprovalStatus"
        img="btnApprovalStatus"
        form="frmDiversionCnclsn"
        action="<%=strAction%>"
        navAwayCk="true"
        editableMode="<%= EditableMode.ALL %>"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <%// If there is a case id in global data, we want to give the user the option to navigate back
        // back to the Case Summary page.  This becomes important when the user is reviewing a Diversion
        // from an Investigation stage and would like to return to Case Summary page.
        if (GlobalData.getUlIdCase(request) != 0) {%>

        <td align="right">
          <a href="javascript:submitValidateForm('frmDiversionCnclsn', '/workload/CaseSummary/displayCaseSummary')">Return to Case Summary</a>
          <br>
        </td>
        <%}%>
  </tr>
  </table>
<%
  }
%>
<impact:validateInput type="hidden" name="hdnUlIdStage"  value="<%=txtUlIdStage%>" />
<impact:validateInput type="hidden" name="hdnUlIdEvent"  value="<%=txtUlIdEvent%>" />
<impact:validateInput type="hidden" name="hdnUlIdCase"  value="<%=txtUlIdCase%>" />
<impact:validateInput type="hidden" name="hdnDtResponseDate" value="<%=ResponseDate%>" />
<impact:validateInput type="hidden" name="hdnRecordsCheckCompletedConfirmed" value="" />
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
  <tr>
    <th colspan="2">Dates</th>
  </tr>
  <tr>
    <td width="35%"><impact:validateDisplayOnlyField
        name="dtIntakeReceived"
        label="Intake Received"
        value="<%=IntakeReceived%>"/>
    </td>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField
        name="dtIntakeProgressed"
        label="Intake Progressed to Diversion"
        value="<%=IntakeProgressed%>"
        />
    </td>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField
        name="dtResponseDate"
        label="Response Date"
        value="<%=ResponseDate%>"
        />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateDate
        type="text"
        name="dtDiversionTasks"
        label="Diversion Tasks Completed"
        tabIndex="<%= tabIndex++ %>"
        constraint="Date"
        size="10"
        conditionallyRequired="true"
        disabled="<%= String.valueOf(sDisableDispstnDropDwn) %>"
        value="<%= FormattingHelper.formatDate( dtDiversionComplt ) %>"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>  
</table>
<br>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
  <tr>
    <th colspan="2">Conclusion</th>
  </tr>
  <tr>
    <td>
       <impact:validateSelect
        name="selSzCdDisposition"
        label="Disposition"
        codesTable="<%= CodesTables.CDIVDSPN %>"
        value="<%= szCdDisposition%>"
        tabIndex="<%= tabIndex++ %>"
        disabled="<%= String.valueOf(sDisableDispstnDropDwn) %>"
        conditionallyRequired="true"
        blankValue="true" />
    </td>
  </tr>  
</table>
<br>  
<table width="100%" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td align="right">
<%
  if(saveAndSubmit){
%>
      <impact:ButtonTag
        name="btnSaveAndSubmit"
        img="btnSaveAndSubmit"
        function="setRecordsCheckCompletedConfirmed();"
        form="frmDiversionCnclsn"
        action="/investigation/DiversionCnclsn/saveSubmitDiversionCnclsn"
        restrictRepost="true"
        tabIndex="<%= tabIndex++ %>"
      />
<%
  }
  if(save){
%>
      <impact:ButtonTag
        name="btnSave"
        img="btnSave"
        form="frmDiversionCnclsn"
        action="/investigation/DiversionCnclsn/saveDiversionCnclsn"
        restrictRepost="true"
        tabIndex="<%= tabIndex++ %>"
      />
<%
  }
%>
    </td>
  </tr>
</table>  
<script type="text/javascript" language="JavaScript1.2">
window.attachEvent('onload', showRecordsCheckConfirmation);
</script>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">  
</impact:validateForm> 
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td>
      <impact:documentButton pageMode="<%= pageMode %>" buttonUrl="/grnds-docs/images/shared/btnNarrative.gif" tabIndex="<%= tabIndex++ %>" accessKey="W">

        <impact:document
          displayName="Diversion Conclusion"
          checkForNewMode="true"
          name="DiversionConclusion"
          docType="divcncl"
          docExists="<%= docExists%>"
          protectDocument="<%= protectNarrative%>">
          <impact:documentParameter name="sEvent" value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>" />
          <impact:documentParameter name="sCase" value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>" />
        </impact:document>
      </impact:documentButton>
    </td>
  </tr>
</table> 