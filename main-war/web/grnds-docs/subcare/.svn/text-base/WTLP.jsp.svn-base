
<%
      //*--------------------------------------------------------------------------------
      //*  JSP Name:     WTLP
      //*  Created by:   Steven Thrasher
      //*  Date Created: 12/15/06
      //*
      //*  Description:
      //*  This JSP displays the WTLP details.
      //*
      //*  Change History:
      //*  Date      User                    Description
      //*  --------  -------------------     --------------------------------------------------
      //*  12/23/2008 Ashwini Rege           STGAP00010758 Modified code so that the Save and Submit button is 
      //*                                    not displayed for the Supervisor in approval mode.   
      //*  07/29/08  Vishala Devarakonda     STGAP00004470: Added Form Launch section
      //*  12/15/06  Steven Thrasher         Initial page development
      //*  
      //*--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.WTLPRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.WTLPConversation"%>
<%@ page import="java.util.Iterator"%>
<%
      //*******************************
      //*** DECLARE LOCAL VARIABLES ***
      //*******************************
      int tabIndex = 1;
      boolean FCParticipant = false;
      int ulIdEvent = 0;
      String txtCoordinatorName = "";
      String txtWTLPDate = "";
      String txtDurationFrom = "";
      String txtDurationTo = "";
      String fieldsToBeSpellChecked = "txtYdpCoordInfo, descrVolW, txtStrengths, txtNeeds";
      String indPlanType = FormattingHelper.formatString("");
      String indPlacAuth = FormattingHelper.formatString("");
      String descrVolW = FormattingHelper.formatString("");
      String txtStrengths = FormattingHelper.formatString("");
      String txtNeeds = FormattingHelper.formatString("");
      int idYdpCoord = 0;
      boolean approvalStatus = false;
      boolean SaveAndSubmit = true;
      if(GlobalData.isApprovalMode(request)){
      SaveAndSubmit = false;      
      }
      Collection typesOfGoals = Lookup.getCategoryCollection(CodesTables.CGOALTYP);
      List typesOfGoalsList = new ArrayList(typesOfGoals);

      List checkedTypesOfGoals = new ArrayList();
      String[] goalsStringArray = null;
      String planType30Day = ArchitectureConstants.FALSE;
      String planTypeCaseRev = ArchitectureConstants.FALSE;
      String authPlacTemp = ArchitectureConstants.FALSE;
      String authPlacPerm = ArchitectureConstants.FALSE;
      String authPlacVol = ArchitectureConstants.FALSE;
      String txtYdpCoordInfo = FormattingHelper.formatString("");
      String radioDisable = ArchitectureConstants.FALSE;
      int ulIdStage = 0;
      String cdTask = "";

      //**************************
      //*** RETRIEVE PAGE DATA ***
      //**************************
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      WTLPRetrieveSO wtlpRetrieve = null;

      wtlpRetrieve = (WTLPRetrieveSO) state.getAttribute(WTLPConversation.RETRIEVESO, request);

      if (wtlpRetrieve != null) {
        FCParticipant = true;
        indPlanType = wtlpRetrieve.getSzPlanType();
        indPlacAuth = wtlpRetrieve.getSzPlcmtAuth();
        if (indPlanType != null) {
          if (WTLPConversation.CASE_PLAN.equals(indPlanType)) {
            planTypeCaseRev = ArchitectureConstants.FALSE;
            planType30Day = ArchitectureConstants.TRUE;
          } else if (WTLPConversation.CASE_REVIEW.equals(indPlanType)) {
            planTypeCaseRev = ArchitectureConstants.TRUE;
            planType30Day = ArchitectureConstants.FALSE;
          }
        }
        if (indPlacAuth != null) {
          if (WTLPConversation.TEMPORARY.equals(indPlacAuth)) {
            authPlacTemp = ArchitectureConstants.TRUE;
            authPlacPerm = ArchitectureConstants.FALSE;
            authPlacVol = ArchitectureConstants.FALSE;
          } else if (WTLPConversation.PERMANENT.equals(indPlacAuth)) {
            authPlacTemp = ArchitectureConstants.FALSE;
            authPlacPerm = ArchitectureConstants.TRUE;
            authPlacVol = ArchitectureConstants.FALSE;
          } else if (WTLPConversation.VOLUNTARY.equals(indPlacAuth)) {
            authPlacTemp = ArchitectureConstants.FALSE;
            authPlacPerm = ArchitectureConstants.FALSE;
            authPlacVol = ArchitectureConstants.TRUE;
          }
        }
        goalsStringArray = wtlpRetrieve.getTypesOfGoals();

        if (wtlpRetrieve.getTypesOfGoals() != null) {
          for (int i = 0; i < goalsStringArray.length; i++) {
            checkedTypesOfGoals.add(goalsStringArray[i]);
          }
        }
        if (wtlpRetrieve.isApprovalStatus() && (wtlpRetrieve.getIdEvent() != 0)) {
          approvalStatus = true;
        }
        idYdpCoord = wtlpRetrieve.getIdYdpCoord();
        txtWTLPDate = FormattingHelper.formatDate(wtlpRetrieve.getWTLPDate());
        txtDurationFrom = FormattingHelper.formatDate(wtlpRetrieve.getWTLPDateFrom());
        txtDurationTo = FormattingHelper.formatDate(wtlpRetrieve.getWTLPDateTo());
        descrVolW = wtlpRetrieve.getSzVoluntary();
        txtStrengths = wtlpRetrieve.getSzStrengths();
        txtNeeds = wtlpRetrieve.getSzNeeds();
        txtYdpCoordInfo = wtlpRetrieve.getYdpCoordInfo();
        ulIdEvent = wtlpRetrieve.getIdEvent();
        cdTask = wtlpRetrieve.getSzCdTask();
        ulIdStage = wtlpRetrieve.getIdStage();
        txtCoordinatorName = wtlpRetrieve.getNmYdpCoord();
      }//end wtlpRetrieve!= null

      if (wtlpRetrieve == null || wtlpRetrieve.getIdEvent() == 0) {
        FCParticipant = false;
        ulIdStage = GlobalData.getUlIdStage(request);
        cdTask = GlobalData.getSzCdTask(request);
      }

      String pageMode = PageMode.getPageMode(request);

      if (PageModeConstants.NEW.equals(pageMode) || PageModeConstants.EDIT.equals(pageMode)) {
        radioDisable = ArchitectureConstants.FALSE;
      } else if (PageModeConstants.VIEW.equals(pageMode)) {
        radioDisable = ArchitectureConstants.TRUE;
      }

      //******************
      //*** JAVASCRIPT ***
      //******************
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

window.onbeforeunload = function ()
{
  IsDirty();
};

</script>

<%
      //*************************
      //*** VALIDATION ERRORS ***
      //*************************
%>
<impact:validateErrors />
<%
      //********************************************
      //**** FORM (WTLP) STARTS HERE ****
      //********************************************
%>
<impact:validateForm name="frmWTLP" method="post"
  action="/subcare/WTLP/displayWTLP"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.WTLPCustomValidation"
  pageMode="<%=pageMode%>" schema="/WEB-INF/Constraints.xsd">

  <%
  if (approvalStatus) {
  %>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td>
        <impact:ButtonTag 
          name="btnApprovalStatus"
          tabIndex="<%=tabIndex++%>" 
          img="btnApprovalStatus"
          editableMode="<%=EditableMode.ALL%>" 
          form="frmWTLP"
          action="/workload/ApprovalStatus/displayStatus" />
      </td>
    </tr>
  </table>
  <%
  }
  %>


  <input type="hidden" name="ulIdEvent" value="<%=ulIdEvent%>">
  <input type="hidden" name="ulIdStage" value="<%=ulIdStage%>">
  <input type="hidden" name="szCdTask" value="<%=cdTask%>">
  <input type="hidden" name="idYdpCoord" value="<%=idYdpCoord%>">

  <table border="0" cellpadding="3" cellspacing="0" width="100%"
    class="tableBorder">
    <tr>
      <th colspan="4">
        WTLP Detail
      </th>
    </tr>
    <tr>
      <td>
        <span class="formCondRequiredText">&#135;</span> Plan Type:
      </td>
      <td>
        <impact:validateInput 
          type="radio" 
          disabled="<%=radioDisable%>"
          label="30-Day Case Plan" 
          id="Plan_Type_30_Day"
          name="scrIndPlanType" 
          value="I" 
          cssClass="formInput"
          checked="<%=planType30Day%>" 
          editableMode="<%=EditableMode.ALL%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateInput 
          type="radio" 
          disabled="<%=radioDisable%>"
          label="Case Review" 
          id="Plan_Type_Case_Rev" 
          name="scrIndPlanType"
          value="R" 
          cssClass="formInput" 
          checked="<%=planTypeCaseRev%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput 
          type="text" 
          label="YDP Coordinator"
          name="txtCoordinatorName" 
          value="<%=txtCoordinatorName%>"
          tabIndex="<%=tabIndex++%>" 
          conditionallyRequired="true"
          readOnly="true" 
          constraint="Name25" />
      </td>
      <td>
        <impact:ButtonTag 
          name="btnStaff" 
          img="btnSelectStaff" 
          align="left"
          form="frmWTLP" 
          action="/subcare/WTLP/performStaffSearch"
          function="disableValidation('frmWTLP')"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateTextArea 
          label="Additional YDP Coord. Info"
          name="txtYdpCoordInfo" 
          cols="90" rows="4" 
          colspan="3"
          tabIndex="<%=tabIndex++%>" 
          maxLength="300">
          <%=FormattingHelper.formatString(txtYdpCoordInfo)%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDate 
          label="WTLP Date" 
          name="txtWTLPDate"
          type="text" 
          value="<%=txtWTLPDate%>" 
          size="10"
          conditionallyRequired="true" 
          tabIndex="<%=tabIndex++%>"
          constraint="Date" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDate 
          label="WTLP Duration From"
          name="txtDurationFrom" 
          type="text" 
          value="<%=txtDurationFrom%>"
          size="10" 
          conditionallyRequired="true" 
          tabIndex="<%=tabIndex++%>"
          constraint="Date" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDate 
          label="WTLP Duration To" 
          name="txtDurationTo"
          type="text" 
          value="<%=txtDurationTo%>" 
          size="10"
          conditionallyRequired="true" 
          tabIndex="<%=tabIndex++%>"
          constraint="Date" />
      </td>
    </tr>
    <tr>
      <td>
        <span class="formCondRequiredText">&#135;</span> Authority For
        Placement:
      </td>
      <td>
        <impact:validateInput 
          type="radio" 
          disabled="<%=radioDisable%>"
          label="Temporary" 
          id="Auth_Plac_Temp" 
          name="scrIndAuthPlac"
          value="TEM" 
          cssClass="formInput" 
          checked="<%=authPlacTemp%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
      <td align="left">
        <impact:validateInput 
          type="radio" 
          disabled="<%=radioDisable%>"
          label="Permanent" 
          id="Auth_Plac_Perm" 
          name="scrIndAuthPlac"
          value="PER" 
          cssClass="formInput" 
          checked="<%=authPlacPerm%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
      <td align="left">
        <impact:validateInput 
          type="radio" 
          disabled="<%=radioDisable%>"
          label="Voluntary W/" 
          id="Auth_Plac_Vol" 
          name="scrIndAuthPlac"
          value="VOL" 
          cssClass="formInput" 
          checked="<%=authPlacVol%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateTextArea 
          label="If Voluntary W/, describe"
          conditionallyRequired="true" 
          name="descrVolW" 
          cols="90" 
          rows="4"
          colspan="3" 
          tabIndex="<%=tabIndex++%>" 
          maxLength="300">
          <%=FormattingHelper.formatString(descrVolW)%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td>
        <span class="formCondRequiredText">&#135;</span> Types of Goals:
      </td>
      <td colspan="3">
        <impact:castorCheckbox
          castorEnum="<%=Collections.enumeration(typesOfGoalsList)%>"
          name="chkbxTypesOfGoals" 
          labelPropertyName="Code"
          valuePropertyName="Decode"
          checkedValues="<%=checkedTypesOfGoals%>" 
          columns="3"
          isRuled="false" 
          isHorizontal="false" 
          tabIndex="<%=tabIndex++%>"
          onClick="" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateTextArea 
          label="Strengths"
          conditionallyRequired="true" 
          name="txtStrengths" 
          cols="90" 
          rows="4"
          colspan="3" 
          tabIndex="<%=tabIndex++%>" 
          maxLength="300">
          <%=FormattingHelper.formatString(txtStrengths)%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateTextArea 
          label="Needs" 
          conditionallyRequired="true"
          name="txtNeeds" 
          cols="90" 
          rows="4" 
          colspan="3"
          tabIndex="<%=tabIndex++%>" 
          maxLength="300">
          <%=FormattingHelper.formatString(txtNeeds)%>
        </impact:validateTextArea>
      </td>
    </tr>
  </table>

  <br>
  <table border="0" cellpadding="3" cellspacing="0" width="100%"
    class="tableBorder">
    <tr>
      <td>
        <impact:include
          page="/submodule/FCGSSubmoduleConversation/displayGoals"
          callingPage="/subcare/WTLP/displayWTLP"
          tabIndex="<%=tabIndex++%>" includingForm="frmWTLP">
          <impact:attribute name="FCGSSubmoduleConversation.PAGE_MODE_KEY"
            value="<%=pageMode%>" />
        </impact:include>
      </td>
    </tr>
  </table>
  <br>

  <table border="0" cellpadding="3" cellspacing="0" width="100%"
    class="tableBorder">
    <tr>
      <td>
        <impact:include
          page="/submodule/FosterCarePartSubConversation/displayFCPart"
          callingPage="/subcare/WTLP/displayWTLP"
          tabIndex="<%=tabIndex++%>" includingForm="frmWTLP">
          <impact:attribute
            name="FosterCarePartSubConversation.PAGE_MODE_KEY"
            value="<%=pageMode%>" />
        </impact:include>
      </td>
    </tr>
  </table>
  <br>
  <%
        //*****************
        //**** BUTTONS ****
        //*****************
  %>
  <hr>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td class="alignLeft" width="85%">
        &nbsp;
      </td>
      <td>
        <impact:spellCheck 
          formToSpellCheck="frmWTLP"
          fieldsToSpellCheck="<%=fieldsToBeSpellChecked%>"
          tabIndex="<%=tabIndex++%>" />
      </td>
      <%if(SaveAndSubmit){ %>
      <td class="alignRight">
        <impact:ButtonTag 
          name="btnSaveAndSubmit" 
          img="btnSaveAndSubmit"
          form="frmWTLP" 
          restrictRepost="true"
          action="/subcare/WTLP/saveAndSubmitWTLP" 
          align="right"
          tabIndex="<%=tabIndex++%>" />
      </td>
      <%} %>
      <td class="alignRight">
        <impact:ButtonTag 
          name="btnSave" 
          img="btnSave" 
          align="right"
          restrictRepost="true" 
          form="frmWTLP"
          action="/subcare/WTLP/saveWTLP" 
          preventDoubleClick="true"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>

  </table>

  <input type="hidden"
    name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<% if(wtlpRetrieve!=null && wtlpRetrieve.getIdEvent() != 0){ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
	<tr>
		<th colspan="4">
			Form and Report Launch
		</th>
	</tr>
	<tr>
		<td>
			<impact:documentList pageMode="<%=pageMode%>" tabIndex="<%=tabIndex++%>">
				<%
					if (wtlpRetrieve != null) {
								String documentFormName = "FCM07O00"
										+ String.valueOf(wtlpRetrieve.getIdPerson());
				%>
				<impact:document displayName="<%=wtlpRetrieve.getSzNmStage()%>" protectDocument="true" checkForNewMode="false" docType="fcm07O00" docExists="true">
					<impact:documentParameter name="pCase" value="<%=String.valueOf(wtlpRetrieve.getCaseId())%>" />
					<impact:documentParameter name="pStage" value="<%=String.valueOf(wtlpRetrieve.getIdStage())%>" />
					<impact:documentParameter name="pEvent" value="<%=String.valueOf(wtlpRetrieve.getIdEvent())%>" />
					<impact:documentParameter name="pPerson" value="<%=String.valueOf(wtlpRetrieve.getIdChild())%>" />
				</impact:document>
				<%
					}
				%>
			</impact:documentList>
		</td>
	</tr>
</table>
<% } %>





