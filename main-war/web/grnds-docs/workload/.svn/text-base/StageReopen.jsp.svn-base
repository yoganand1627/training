
<%-- 
JSP Name:     Stage Reopen
Created by:   Bhavna Gehlot
Date Created: 7/17/2009

Description:
This JSP Displays the Stage Reopen page.

 Change History:
 *
 *  Date        User              Description
 *  --------    ----------------  ----------------------------------------------

 * 07/30/2009   bgehlot           STGAP00014941: Checkboxes are displayed depending on the stage type
 * 09/17/2009   bgehlot           Added Previous Stage Closure Information section

--%>


<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.StageReopenRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.StageClosureConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Arrays" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.text.SimpleDateFormat" %>

<%
  int ulIdEvent = 0;
  int ulIdStage = 0;
  String cdTask = "";
  String tsLastUpdate ="";
  int tabIndex = 1;
  boolean sDisableField = false;

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  
  // Get the whole output object here from the request and get the individual pieces later.
  StageReopenRetrieveSO stageReopenRetrieveSO = (StageReopenRetrieveSO) state.getAttribute("stageReopenRetrieveSO", request); 
  //Set the page mode
  String pageMode = PageMode.getPageMode(request);
  
  if (pageMode.equals(PageModeConstants.VIEW)) {
    sDisableField = true;
  }
  
  if(CodesTables.CEVTSTAT_COMP.equals(stageReopenRetrieveSO.getCdEventStatus())){
    sDisableField = true;
  }
  
  if(ArchitectureConstants.N.equals(stageReopenRetrieveSO.getBIndStageReopen())){
    sDisableField = true;
  }
  
  if (stageReopenRetrieveSO.getUlIdEvent() != 0) {
      tsLastUpdate = DateHelper.toISOString(stageReopenRetrieveSO.getDtLastUpdate());
  }
  
  SimpleDateFormat SLASH_FORMAT = new SimpleDateFormat("MM/dd/yyyy");


 %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.attachEvent('onbeforeunload', checkIsDirty);

function checkIsDirty()
{
  IsDirty();
}

function savePageAdd()
{
    if (confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFRM_SAVE)%>') == true){
       return true;
    } 
}
</script>

<impact:validateErrors/>
<impact:validateForm name="frmStageReopen"
  method="post"
  action="/workload/StageReopen/saveStageReopen"
  pageMode="<%=pageMode%>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.StageReopenCustomValidation"
  schema="/WEB-INF/Constraints.xsd">

  <input type="hidden" name="ulIdEvent" value="<%=ulIdEvent%>">
  <input type="hidden" name="ulIdStage" value="<%=ulIdStage%>">
  <input type="hidden" name="szCdTask" value="<%=cdTask%>">
  <input type="hidden" name="idRequestedBy" value="<%=stageReopenRetrieveSO.getIdRequestedBy() %>">
  <input type="hidden" name="idPerformedBy" value="<%=stageReopenRetrieveSO.getIdPerformedBy()%>">
  <input type="hidden" name="hdnSzClosureReason" value="<%=stageReopenRetrieveSO.getSzClosureReason()%>">
  <input type="hidden" name="hdnDtStageClosure" value="<%=DateHelper.toJavaDate(FormattingHelper.formatDate(stageReopenRetrieveSO.getDtStageClosure()), SLASH_FORMAT)%>">
  <input type="hidden" name="hdnTxtClosureComments" value="<%=stageReopenRetrieveSO.getTxtClosureComments()%>">
  <input type="hidden" name="hdnNmApprover" value="<%=stageReopenRetrieveSO.getNmApprover()%>">
  <input type="hidden" name="hdnDtApproval" value="<%=stageReopenRetrieveSO.getDtApproval()%>">
  <input type="hidden" name="hdnTxtApproversComments" value="<%=stageReopenRetrieveSO.getTxtApproversComments()%>">
  <impact:validateInput type="hidden" name="tsLastUpdate" value="<%=tsLastUpdate%>" />
  
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Previous Stage Closure Information</th>
  </tr>
  <tr>
    <td width="35%">
      <impact:validateDisplayOnlyField
        name="szClosureReason"
        label="Closure Reason"
        value="<%=FormattingHelper.formatString(stageReopenRetrieveSO.getSzClosureReason()) %>"
      />
    </td>
  </tr>
  <tr>
    <td width="35%">
      <impact:validateDisplayOnlyField
        name="dtStageClosure"
        label="Closure Date"
        value="<%=FormattingHelper.formatDate(stageReopenRetrieveSO.getDtStageClosure()) %>"
      />
    </td>
  </tr>
  <tr>
    <td width="35%">
	  <impact:validateDisplayOnlyField 
	    name="txtClosureComments" 
		label="Closure Comments" 
		value="<%=FormattingHelper.formatString(stageReopenRetrieveSO.getTxtClosureComments()) %>" />
	</td>
  </tr>
  <tr>
    <td width="35%">
	  <impact:validateDisplayOnlyField 
	    name="nmApprovedBy" 
		label="Closure Approved By" 
		value="<%=FormattingHelper.formatString(stageReopenRetrieveSO.getNmApprover()) %>" />
	</td>
  </tr>
  <tr>
    <td width="35%">
	  <impact:validateDisplayOnlyField 
	    name="dtApproval" 
		label="Closure Approval Date" 
		value="<%=FormattingHelper.formatDate(stageReopenRetrieveSO.getDtApproval()) %>" />
	</td>
  </tr>
  <tr>
    <td width="35%">
	  <impact:validateDisplayOnlyField 
	    name="txtApproversComments" 
		label="Closure Approver's Comments" 
		value="<%=FormattingHelper.formatString(stageReopenRetrieveSO.getTxtApproversComments()) %>" />
	</td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Stage Reopen Information</th>
  </tr>
  <tr>
    <td width="35%">
      <impact:validateDisplayOnlyField
        name="txtDtDtStageReopen"
        label="Date"
        value="<%=FormattingHelper.formatDate(stageReopenRetrieveSO.getDtStageReopened()) %>"
      />
    </td>
  </tr>
  <tr>
    <td width="35%">
	  <impact:validateDisplayOnlyField 
	    name="szNmPerformedBy" 
		label="Performed By" 
		value="<%=FormattingHelper.formatString(stageReopenRetrieveSO.getSzNmPerformedBy()) %>" />
	</td>
  </tr>
  <tr>
    <td width="35%">
      <b style="color: red; font-size: 15pt;">*</b>
      <impact:validateDisplayOnlyField 
	    name="szNmRequestedBy" 
		label="Requested By" 
		value="<%=FormattingHelper.formatString(stageReopenRetrieveSO.getSzNmRequestedBy()) %>" />
	</td>
	<td>
	          <impact:ButtonTag name="btnSelectStaff"
                            img="btnSelectStaff"
                            form="frmStageReopen"
                            action="/workload/StageReopen/performStaffSearch"
                            disabled="<%=String.valueOf(sDisableField)%>"
                            align="left"
                            function="disableValidation('frmStageReopen');"
                            tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<%
 Collection<CodeAttributes> reopenReasons = Lookup.getCategoryCollection(CodesTables.CRREOPEN);
 List reopenReasonListTemp = new ArrayList(reopenReasons);
 List reopenReasonList = new ArrayList();
 //STGAP00014941: Checkboxes are displayed depending on the stage type
 if(reopenReasonListTemp != null){
   for(Iterator<CodeAttributes> it = reopenReasonListTemp.iterator(); it.hasNext();){
     CodeAttributes ca = it.next();
     reopenReasonList.add(ca);
     if(CodesTables.CRREOPEN_APE.equals(ca.getCode()) && 
       !(CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request)))){
         reopenReasonList.remove(ca);
     }
     if(CodesTables.CRREOPEN_APC.equals(ca.getCode()) && 
       !(CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_PFC.equals(GlobalData.getSzCdStage(request)))){
         reopenReasonList.remove(ca);
     }
     if(CodesTables.CRREOPEN_DPC.equals(ca.getCode()) && 
       !(CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_PFC.equals(GlobalData.getSzCdStage(request)))){
         reopenReasonList.remove(ca);
     }
     if(CodesTables.CRREOPEN_UPL.equals(ca.getCode()) && 
       !(CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_PFC.equals(GlobalData.getSzCdStage(request)) ||
        CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request)))){
         reopenReasonList.remove(ca);
     }
     if(CodesTables.CRREOPEN_AFC.equals(ca.getCode()) && 
       !(CodesTables.CSTAGES_ADO.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_SUB.equals(GlobalData.getSzCdStage(request)) || 
        CodesTables.CSTAGES_FSU.equals(GlobalData.getSzCdStage(request)) ||
        CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request)))){
         reopenReasonList.remove(ca);
     }
   }
 }
 List<String> checkedCheckboxesList = new ArrayList<String>(); 
 if(stageReopenRetrieveSO.getCheckedCheckboxes() != null){
     checkedCheckboxesList = Arrays.asList(stageReopenRetrieveSO.getCheckedCheckboxes());
  }%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">
      <b style="color: red; font-size: 15pt;">*</b>
         Reopen Reasons
    </th>
  </tr>
   <tr>
       <td>
          <impact:castorCheckbox
               castorEnum="<%= Collections.enumeration(reopenReasonList) %>"
               name="chkReopenReasons"
               labelPropertyName="Code"
               valuePropertyName="Decode"
               checkedValues="<%= checkedCheckboxesList %>"
               columns="3"
               isRuled="false"
               isHorizontal="false"                
               tabIndex="<%= tabIndex++ %>"
               disabled="<%=String.valueOf(sDisableField)%>"/>
       </td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <td>
      <impact:validateTextArea
        name="selSzTxtStageReopenCmnts"
        label="Justification"
        required="true"
        rows="4"
        cols="80"
        tabIndex="<%= tabIndex++ %>"
        maxLength="300"
        constraint="Comments"
        disabled="<%=String.valueOf(sDisableField)%>">
        <%=stageReopenRetrieveSO.getSzTxtStageReopenCmnts() != null ? stageReopenRetrieveSO.getSzTxtStageReopenCmnts() : ""%>
      </impact:validateTextArea>
    </td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td width="80%">&nbsp;</td>
    <%if(!sDisableField){ %>
	    <td width="10%" class="alignRight">
	      <impact:spellCheck
	        formToSpellCheck="frmStageReopen"
	        fieldsToSpellCheck="selSzTxtStageReopenCmnts"
	        tabIndex="<%= tabIndex++ %>"
	      />
	    </td>
  <%} %>
  <td width="10%" class="alignRight">
      <impact:ButtonTag
        name="btnSave"
        img="btnSave" align="right"
        form="frmStageReopen"
        restrictRepost="true"
        action="/workload/StageReopen/saveStageReopen"
        function="return savePageAdd();"
        tabIndex="<%= tabIndex++ %>"
        disabled="<%=String.valueOf(sDisableField)%>"
      />
    </td>
  </tr>
</table>

<!-------------------------------------------------------------------------------------------------
 !- Hidden fields to persist state
 !------------------------------------------------------------------------------------------------>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm>
