<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO"%>



<%

String pageMode = PageModeConstants.NEW;
int editableMode = EditableMode.ALL;
int tabIndex = 0;
String fieldsToBeSpellChecked = "txtRsnDischg";


//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
UserProfile user = UserProfileHelper.getUserProfile( request );

FCCPFamilyDetailSO fccpFamilyDetailSO = (FCCPFamilyDetailSO) state.getAttribute("CASE_PLAN_FAMILY", request);
//casePlanMode = (String)state.getAttribute("CASE_PLAN_MODE", request);
String casePlanMode = request.getParameter("hdnCasePlanMode");
//cdStage = GlobalData.getSzCdStage( request );
String lNbrDurationAfc = (String) request.getAttribute("lNbrDurationAfc");
// Initialize



%>

<impact:validateErrors/>

<impact:validateForm name="frmFCCPFamilyDetail_AFC"
  method="post"
  action="/serviceDelivery/FCCPFamilyDetail/saveFCCPFamilyDetail"
  pageMode="<%=pageMode%>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FCCPFamilyCustomValidation"
  schema="/WEB-INF/Constraints.xsd">
  
  <%
  // Display the 'Approval Status' button if the event has ever been
  // submitted for approval.
  
  String disableApprovalStatus = "true";
  if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request)))
  {
    disableApprovalStatus = "false";
  }
  %>
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
      <td>
        <impact:ButtonTag
          name="btnApprovalStatusFinal"
          img="btnApprovalStatus"
          form="frmFCCPFamilyDetail_AFC"
          action="<%= ApprovalStatusConversation.DISPLAY_URI %>"
          disabled="<%= disableApprovalStatus %>"
          editableMode="<%= EditableMode.ALL %>"
          navAwayCk="true"
          tabIndex="<%= tabIndex %>"/>
      </td>
    </tr>
    
  
  
  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr><th colspan="4">Aftercare</th></tr>
  <tr><td>
  <impact:validateDate
      label="Begin Date of Aftercare"
      name="dtBeginAft"
      type="text"
      value=""
      size="10"
      conditionallyRequired="true"
      editableMode="<%= editableMode %>"
      tabIndex="<%= tabIndex++ %>"
      constraint="Date"/>
  </td>
    <td>
    <impact:validateDate
      label="End Date of Aftercare"
      name="dtEndAft"
      type="text"
      value=""
      size="10"
      conditionallyRequired="true"
      editableMode="<%= editableMode %>"
      tabIndex="<%= tabIndex++ %>"
      constraint="Date"/>
    </td>
  </tr> 
  <tr><td>
    <impact:validateDisplayOnlyField name="dspLAmtIncRsrcMonth" label="Duration of Aftercare" value="<%=lNbrDurationAfc%>" />
  </td></tr>
  <tr>
    <td><span class="formCondRequiredText">&#135;</span>Reason for discharge from foster care:</td>
  </tr>
  <tr>
    <td>
      <impact:validateTextArea
        name="txtRsnDischg"
        title="Reason for discharge from foster care"
        colspan="1"
        rows="3"
        cols="145"
        maxLength="300"
        editableMode="<%= editableMode %>"
        tabIndex="<%= tabIndex++ %>"
        constraint="Comments">
      </impact:validateTextArea>
    </td>
  </tr>
</table>
<%
String bDisableSaveAndSubmit = "false";
if (!PageModeConstants.VIEW.equals(pageMode)) {

%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td width="100%" align="right">
        <impact:spellCheck
          formToSpellCheck="frmFCCPFamilyDetail_AFC"
          fieldsToSpellCheck="<%= fieldsToBeSpellChecked %>"
          tabIndex="<%=tabIndex++%>"/>
      </td>
      <td align="right">
        <impact:ButtonTag
          name="SaveSubmitFCCPFamilyDetail"
          img="btnSaveAndSubmit"
          align="right"
          form="frmFCCPFamilyDetail_AFC"
          disabled="<%= bDisableSaveAndSubmit %>"
          action="/serviceDelivery/FCCPFamilyDetail/saveAndSubmitFCCPFamilyDetail"
          restrictRepost="true"
          preventDoubleClick="true"
          function="return confirmSaveAndSubmit()"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    <% } %>
      <td align="right">
        <impact:ButtonTag
          name="SaveFCCPFamilyDetail"
          img="btnSave"
          align="right"
          form="frmFCCPFamilyDetail_AFC"
          action="/serviceDelivery/FCCPFamilyDetail/saveFCCPFamilyDetail"
          restrictRepost="true"
          preventDoubleClick="true"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
  
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>

