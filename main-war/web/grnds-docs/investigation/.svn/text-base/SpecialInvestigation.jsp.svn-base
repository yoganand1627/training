<%--
JSP Name:     Special Investigation
Created by:   Herve Jean-Baptiste
Date Created: 05/16/2011

Description:
This JSP is used to display the Special Investigation page.

Change History:
Date        User                    Description
----------  ----------------------  -----------------------------------------------------------
06/20/2011  hjbaptiste              SMS#112430: Setting the page mode to Modify when INV stage is closed and user
                                    has access or user is approver. Showing the buttons
06/22/2011  hjbaptiste              SMS#112430: Changed the constraints for textArea from 'Comments' to Paragraph4000
                                    to accomodate 4000 characters 
06/22/2011  hjbaptiste              SMS#112951: Disabled the narrative  
06/23/2011  hjbaptiste              SMS#113092: Fixed condition to correctly set the concurrence yes/no questions 
06/27/2011  hjbaptiste              SMS#112897: Fixed Approval Status button incorrectly displaying approval for 
                                    non-special investigation event
06/29/2011  hjbaptiste              SMS#113417: Allow 4000 characters for state concurrence comments. 
                                    SMS#113413: Removed call to isDirty() 
06/30/2011  hjbaptiste              SMS#112897: Fixed condition to show Approval Status button  
06/30/2011  hjbaptiste              SMS#109631: If resource id is 0, then not displaying the Providcer Allegation hyperlink
                                    SMS#109631: Disabling the widgets when the event is in APRV status 

--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Enumeration" %>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.investigation.SpecialInvestigationConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationRetrieveSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvAllegationBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvHmeWaiverChildHistBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.lang.String"%>
<%@ page import="java.util.*"%>
<%
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  

  //Set Page Mode and related variables for display
  String pageMode = PageMode.getPageMode(request);

  String szDisabled = "false";
  String yIsCheckedConcurAssmntDisp = "false";
  String nIsCheckedConcurAssmntDisp = "false";
  String yIsCheckedConcurActionRecmnd = "false";
  String nIsCheckedConcurActionRecmnd = "false";
  String isCheckedRcmndPlcmntRsrcClosed = "false"; 
  String isCheckedRcmndChldrnRemoved = "false";
  String isCheckedRcmndActionPlanDvlpd = "false";
  String isCheckedRcmndNoChangeStatus = "false";
  String isCheckedRcmndWaiverAttached = "false";
  String isCheckedRcmndCpaCpiNotUsed = "false";
  String yIsCheckedRecChkReviewed = "false";
  String nIsCheckedRecChkReviewed = "false";
  String xIsCheckedRecChkReviewed = "false";
  String isCheckedRcmndOther = "false";
  String isCheckedMaltreatment = "";
  String isCheckedPolicyViolation = "";
  boolean docExists = false;
  
  SpclInvestigationRetrieveSO spclInvestigationRetrieveSO = (SpclInvestigationRetrieveSO) state
                                                                                               .getAttribute(
                                                                                                             "spclInvestigationRetrieveSO",
                                                                                                             request);
                                                                                                              
  if (spclInvestigationRetrieveSO == null) {
    spclInvestigationRetrieveSO = new SpclInvestigationRetrieveSO();
  } else {
    docExists = spclInvestigationRetrieveSO.getIsBLOBExistsInDatabase();
  }
  
  // Create a 1-based tab index variable that can be used to set tab indices down the page.
  int tabIndex = 1;
  String cdEventStatus = spclInvestigationRetrieveSO.getCdEventStatus();
  if (CodesTables.CEVTSTAT_APRV.equals(cdEventStatus) || PageModeConstants.VIEW.equals(pageMode)) {
    szDisabled = "true";
  }

  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndConcurAssmntDisp())) {
    yIsCheckedConcurAssmntDisp = "true";
  } else if (ArchitectureConstants.N.equals(spclInvestigationRetrieveSO.getIndConcurAssmntDisp())) {
    nIsCheckedConcurAssmntDisp = "true";
  }

  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndConcurActionRecmnd())) {
    yIsCheckedConcurActionRecmnd = "true";
  } else if (ArchitectureConstants.N.equals(spclInvestigationRetrieveSO.getIndConcurActionRecmnd())) {
    nIsCheckedConcurActionRecmnd = "true";
  }

  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndInvMaltreatInCare())) {
    isCheckedMaltreatment = ArchitectureConstants.YES;

  } else if (ArchitectureConstants.N.equals(spclInvestigationRetrieveSO.getIndInvMaltreatInCare())) {
    isCheckedMaltreatment = ArchitectureConstants.NO;
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndPolicyViolation())) {
    isCheckedPolicyViolation = ArchitectureConstants.YES;
  } else if (ArchitectureConstants.N.equals(spclInvestigationRetrieveSO.getIndPolicyViolation())) {
    isCheckedPolicyViolation = ArchitectureConstants.NO;
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRecordChkViewed())) {
    yIsCheckedRecChkReviewed = "true";
  } else if (ArchitectureConstants.N.equals(spclInvestigationRetrieveSO.getIndRecordChkViewed())) {
    nIsCheckedRecChkReviewed = "true";
  } else if (ArchitectureConstants.X.equals(spclInvestigationRetrieveSO.getIndRecordChkViewed())) {
    xIsCheckedRecChkReviewed = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndPlcmntRsrcClosed())) {
    isCheckedRcmndPlcmntRsrcClosed = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndChldrnRemoved())) {
    isCheckedRcmndChldrnRemoved = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndActionPlanDvlpd())) {
    isCheckedRcmndActionPlanDvlpd = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndCpaCciNotUsed())) {
    isCheckedRcmndCpaCpiNotUsed = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndNoChangeStatus())) {
    isCheckedRcmndNoChangeStatus = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndWaiverAttached())) {
    isCheckedRcmndWaiverAttached = "true";
  }
  
  if (ArchitectureConstants.Y.equals(spclInvestigationRetrieveSO.getIndRcmndOther())) {
    isCheckedRcmndOther = "true";
  }
  

  List<String> concurrences = spclInvestigationRetrieveSO.getConcurrenceCodes();
  if (concurrences == null) {
    concurrences = new ArrayList<String>();
  }
  
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<%
  /* Start Javascript Section */
%>
<script type="text/javascript" language="JavaScript1.2">
  <%--
//  This function is called when the user clicks a hyperlink in the Allegation list of the Investigation Summary section.
--%>
  function displayAllgtnDetail(idAllgtn, idVictim)
  {
    document.frmSpclInvestigation.hdnUlIdAllgtn.value = idAllgtn;
    document.frmSpclInvestigation.hdnIdSpclInvAllgtnVictim.value = idVictim;
    submitValidateForm( "frmSpclInvestigation", "/investigation/SpecialInvestigation/displayAllgtnDetail" );
  }

  function submitResourceID(idResource)
  {
    document.frmSpclInvestigation.idResource.value = idResource;
    submitValidateForm( "frmSpclInvestigation", "/investigation/SpecialInvestigation/displayResourceDetail" );
  }  
  
  function displayProviderAllgtnHistory(idResource)
  {
    document.frmSpclInvestigation.idResource.value = idResource;
    submitValidateForm( "frmSpclInvestigation", "/investigation/SpecialInvestigation/displayProviderAllgtnHistory" );
  }  
  </script>
  
<impact:validateErrors/>
<impact:validateForm name="frmSpclInvestigation"
                     method="post"
                     action="/investigation/SpecialInvestigation/displaySpclInvestigation"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.SpecialInvestigationCustomValidation"
                     pageMode="<%=pageMode%>"
                     schema="/WEB-INF/Constraints.xsd">

<impact:validateInput type="hidden" name="idResource" value="<%=FormattingHelper.formatInt(spclInvestigationRetrieveSO.getIdResource())%>"/>
<impact:validateInput type="hidden" name="hdnUlIdAllgtn" value="0"/>
<impact:validateInput type="hidden" name="hdnIdSpclInvAllgtnVictim" value="0"/>

<%-- Start the HTML for the page --%>
<%
  if (!pageMode.equals(PageModeConstants.NEW) && (EventHelper.PENDING_EVENT.equals(cdEventStatus) || EventHelper.APPROVED_EVENT.equals(cdEventStatus))) {
      String action = ApprovalStatusConversation.DISPLAY_URI;
      int editableMode = EditableMode.NEW + EditableMode.MODIFY;
      if (PageModeConstants.VIEW.equals(pageMode)) {
        editableMode = EditableMode.NONE;
      }

      if (GlobalData.isApprovalMode(request)) {
        action = "/investigation/SpecialInvestigation/submitApproval";
      }
%>
    <table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td>
				<impact:ButtonTag name="btnApprovalStatusFinal" img="btnApprovalStatus" form="frmSpclInvestigation" action="<%=action%>"
				    navAwayCk="true" editableMode="<%=EditableMode.ALL%>" 
					tabIndex="<%=tabIndex%>" />
			</td>
		</tr>
    </table>
<%
  }
%>
	<br>

	<%
	  UserProfile user = UserProfileHelper.getUserProfile(request);
	    if ((pageMode.equals(PageModeConstants.VIEW) || pageMode.equals(PageModeConstants.EDIT))
	        && ((EventHelper.APPROVED_EVENT.equals(cdEventStatus)) 
	             || ((SpecialInvestigationConversation.POLICY_UNIT.equals(spclInvestigationRetrieveSO.getWhichApprover())
	                  || SpecialInvestigationConversation.DEPUTY_DIRECTOR.equals(spclInvestigationRetrieveSO.getWhichApprover())) 
	             && (EventHelper.PENDING_EVENT.equals(cdEventStatus))))) {
	%>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
	<td width="40%">
	  <impact:validateDisplayOnlyField 
	    name="dtSpclInvSent"
	    label="Date Special Investigation sent to Policy Unit"
	    value="<%=FormattingHelper.formatDate(spclInvestigationRetrieveSO.getDtSpclInvSent())%>"/>
	</td>
  </tr>
  <tr>
	<td>
	  <impact:validateDisplayOnlyField 
	    name="dtSpclInvApproved"
	    label="Date Special Investigation approved by Policy Unit"
	    value="<%=FormattingHelper.formatDate(spclInvestigationRetrieveSO.getDtSpclInvApproved())%>"/>
	</td>
  </tr>
</table>	
<br>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
    <th colspan="2">State Office Concurrence</th>
  </tr>
  <tr>
    <td colspan="2">
      <span class="formRequiredText">*</span>The Program planning and Policy Development Unit has reviewed 
      the CPS investigation/placement resource violation and recommended plan for the placement resource identified below:
    </td>
  </tr>
  <tr>
    <td width="2%">&nbsp;</td>
    <td>
	  <table border="0" width="100%" cellSpacing="0" cellPadding="0">
	    <tr>
	      <td colspan="4">
	        Does the State Office concur with the assessment disposition?
            <impact:validateInput type="radio" label="Yes" checked="<%=yIsCheckedConcurAssmntDisp%>" tabIndex="<%= tabIndex++ %>" disabled="<%=szDisabled %>" value="Y" name="rbStateOfficeConcurDisp" cssClass="formInput"  />
            <impact:validateInput type="radio" label="No" checked="<%=nIsCheckedConcurAssmntDisp%>" tabIndex="<%= tabIndex++ %>" disabled="<%=szDisabled %>" value="N" name="rbStateOfficeConcurDisp" cssClass="formInput"  />
          </td>
	    </tr>
	    <tr>
	      <td colspan="4">
	        Does the State Office concur with the action that the county has recommended?	      
            <impact:validateInput type="radio" label="Yes" checked="<%=yIsCheckedConcurActionRecmnd%>" tabIndex="<%= tabIndex++ %>" disabled="<%=szDisabled %>" value="Y" name="rbStateOfficeConcurCountyRecAction" cssClass="formInput"  />
            <impact:validateInput type="radio" label="No" checked="<%=nIsCheckedConcurActionRecmnd%>" tabIndex="<%= tabIndex++ %>" disabled="<%=szDisabled %>" value="N" name="rbStateOfficeConcurCountyRecAction" cssClass="formInput"  />
          </td>
	    </tr>
	    <tr>
	      <td colspan="4">&nbsp;</td>
	    </tr>
	    <tr>
          <td colspan="4">
            <b>Policy/Practice Review Results:</b>
          </td>
        </tr>
	    <tr>
          <td colspan="4">
            <impact:codesCheckbox
              name="cbxStateOfficeConcur_"
              tabIndex="<%= tabIndex++ %>"
              codesTableName="<%= CodesTables.CPUNOCR %>"
              columns="1"
              disabled="<%=szDisabled %>" 
              defaultCodes="<%=concurrences%>"/>
          </td>
        </tr>
        <tr>
          <td>
            <impact:validateTextArea name="txtStateOfficeConcurComments"
          label="Comments" rows="3" cols="100" tabIndex="<%=tabIndex++%>"
          maxLength="4000" disabled="false"
          constraint="Paragraph4000" conditionallyRequired="false">
          <%=FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtConcurComments())%>
        </impact:validateTextArea>
          </td>
          <td colspan="2">&nbsp;</td>
        </tr>
	  </table>    
    </td>		  
  </tr>
</table>
    <br>
	<%
	  }
	%>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
    <th colspan="3">Placement Provider Information</th>
  </tr>
  <tr>
    <td width="25%">
	  <impact:validateDisplayOnlyField 
	    name="nmPlcmntResrc"
	    label="Placement Resource"
	    value="<%=FormattingHelper.formatString(spclInvestigationRetrieveSO.getNmResource())%>"/>
	</td>
<%
if (spclInvestigationRetrieveSO.getIdResource() > 0) {
 %>	
	<td><a onclick="setIsDirtyCalled(true);" href="javascript:displayProviderAllgtnHistory('<%=spclInvestigationRetrieveSO.getIdResource()%>')" tabIndex='<%=tabIndex++%>'>
	    Provider Allegation History</a></td>
<%
} else { %>	    
    <td>&nbsp;</td>
<%
} %>    

  </tr>
  <tr>
    <td width="25%">
	  <impact:validateDisplayOnlyField 
	    name="cdRsrcFacilType"
	    label="Provider Type"
	    value="<%=Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, FormattingHelper.formatString(spclInvestigationRetrieveSO.getCdRsrcFacilType()))%>"/>
	</td>
	<td>&nbsp;</td>
  </tr>
  <tr>
    <td width="25%">
	  <impact:validateDisplayOnlyField 
	    name="nbrIdRsrc"
	    label="Resource ID"
	    value=""/>
	    <a onclick="setIsDirtyCalled(true);" href="javascript:submitResourceID('<%=spclInvestigationRetrieveSO.getIdResource()%>')" tabIndex='<%=tabIndex++%>'>
	    <%=FormattingHelper.formatInt(spclInvestigationRetrieveSO.getIdResource())%>
                </a>
	</td>
	<td>&nbsp;</td>
  </tr>
</table> 
<br/>
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
    <th colspan="2">Investigation Summary</th>
  </tr>
  <tr>
    <td width="25%">
	  <impact:validateDisplayOnlyField 
	    name="dtIntakeRecvd"
	    label="Intake Received"
	    value="<%=FormattingHelper.formatDate(spclInvestigationRetrieveSO.getDtIntakeRcvd())%>"/>
	</td>
  </tr>
  <tr>
    <td width="25%">
	  <impact:validateDisplayOnlyField 
	    name="cdMaltreatmentFinding"
	    label="Maltreatment Finding"
	    value="<%=Lookup.simpleDecodeSafe(CodesTables.CDISPSTN, spclInvestigationRetrieveSO.getCdCpsOverallDisptn())%>"/>
	</td>
  </tr>
  <tr>
    <td width="25%">
	  <impact:validateDisplayOnlyField 
	    name="cdStageRiskFinding"
	    label="Overall Risk Finding"
	    value="<%=Lookup.simpleDecodeSafe(CodesTables.CCRSKFND, spclInvestigationRetrieveSO.getCdCnclsnRiskFnd())%>"/>
	</td>
  </tr>
  <tr>
    <td width="25%">
	  <impact:validateDisplayOnlyField 
	    name="indInvMaltreatInCare"
	    label="Is this Maltreatment in Care?"
	    value="<%=isCheckedMaltreatment%>"/>
	</td>
  </tr>
  <tr>
    <td width="25%">
	  <impact:validateDisplayOnlyField 
	    name="indPolicyViolation"
	    label="Is this a Policy Violation?"
	    value="<%=isCheckedPolicyViolation%>"/>
	</td>
  </tr>
  <tr>
    <td colspan="2">
	  <table border="0" width="100%" cellSpacing="0" cellPadding="0">
	    <tr class="subDetail">
	      <th class="thList">Maltreatment Code</th>
	      <th class="thList">Alleged Maltreated Child</th>
	      <th class="thList">Disposition</th>
	      <th class="thList">Evidence Code</th>
	      <th class="thList">Stage</th>
	    </tr>
<%
List<SpclInvAllegationBean> allegationBeans = spclInvestigationRetrieveSO.getAllegationBeans();
if (allegationBeans != null && !allegationBeans.isEmpty()) {
  Iterator<SpclInvAllegationBean> iterAllegations = allegationBeans.iterator();
  int i = 0;
  while (iterAllegations.hasNext()) {
    SpclInvAllegationBean allegation = iterAllegations.next();
 %>
        <tr class="<%=FormattingHelper.getRowCss(i)%>">
          <td><a href="javascript:disableValidation('frmSpclInvestigation');displayAllgtnDetail(<%= allegation.getIdAllegation()%>, <%= allegation.getIdVictim()%>);" onClick="setIsDirtyCalled(true); window.onBeforeUnload=null;" tabIndex="<%=tabIndex++%>"> <%=FormattingHelper.formatString(allegation.getCdAllegType())%></a></td>
          <td><%=FormattingHelper.formatString(allegation.getNmVictimFull())%></td>
          <td><%=FormattingHelper.formatString(allegation.getCdAllegDisposition())%></td>
          <td><%=FormattingHelper.formatString(allegation.getEvidenceCodes())%></td>
          <td><%=FormattingHelper.formatString(allegation.getCdAllegIncidentStage())%></td>
        </tr>
<%
    i++;
  }
}
 %>        
	  </table>
    </td>
  </tr>	  
</table>   	
<br/>	
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="2">County Recommendation</th>
  </tr>
  <tr>
    <td colspan="4"><span class="formRequiredText">*</span>The recommended plan for the placement resource/adoptive home is:</td>
  </tr>
  <tr>
    <td width="4%"><impact:validateInput type="checkbox" name="cbxPlcmntRsrcClosed" disabled="false" disabled="<%=szDisabled %>" checked="<%=isCheckedRcmndPlcmntRsrcClosed%>" value="Y"/></td>
    <td>The placement resource will be closed.</td>
  </tr>
  <tr>
    <td width="4%"><impact:validateInput type="checkbox" name="cbxChildrenRemoved" disabled="false" disabled="<%=szDisabled %>" checked="<%=isCheckedRcmndChldrnRemoved%>" value="Y"/></td>
    <td>Children in the legal custody of DHR/DFCS have been removed from the placement resource in order to assure safety/well being needs are met.</td>
  </tr> 
  <tr>
    <td width="4%"><impact:validateInput type="checkbox" name="cbxActionPlanDvlpd" disabled="false" disabled="<%=szDisabled %>" checked="<%=isCheckedRcmndActionPlanDvlpd%>" value="Y"/></td>
    <td>A corrective action plan has been developed and is attached to this memorandum.</td>
  </tr>
  <tr>
    <td width="4%"><impact:validateInput type="checkbox" name="cbxNoChangeStatus" disabled="false" disabled="<%=szDisabled %>" checked="<%=isCheckedRcmndNoChangeStatus%>" value="Y"/></td>
    <td>No change in the status of the resource is recommended.</td>
  </tr>
  <tr>
    <td width="4%"><impact:validateInput type="checkbox" name="cbxWaiverAttached" disabled="false" disabled="<%=szDisabled %>" checked="<%=isCheckedRcmndWaiverAttached%>" value="Y"/></td>
    <td>A policy waiver or other request on behalf of a child in DHR/DFCS custody is attached to this memorandum.</td>
  </tr>
  <tr>
    <td width="4%"><impact:validateInput type="checkbox" name="cbxCpaCpiNotUsed" disabled="false" disabled="<%=szDisabled %>" checked="<%=isCheckedRcmndCpaCpiNotUsed%>" value="Y"/></td>
    <td>CPA or CPI will not be used for DFCS children.</td>
  </tr>
  <tr valign="top">
    <td width="4%"><impact:validateInput type="checkbox" name="cbxRcmndOther" disabled="false" disabled="<%=szDisabled %>" checked="<%=isCheckedRcmndOther%>" value="Y"/></td>
    <td>Other:&nbsp;&nbsp;&nbsp; 
          <impact:validateTextArea name="txtCountyRecOtherComments"
          label="" rows="5" cols="70" tabIndex="<%=tabIndex++%>"
          maxLength="4000" disabled="false"
          constraint="Paragraph4000" conditionallyRequired="false">
          <%=FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtRcmndOtherComments())%>
        </impact:validateTextArea></td>
  </tr>
  
  <tr>
  <td colspan="2">
	  <span class="formRequiredText">*</span>Have Records Checks been reviewed?
      <impact:validateInput type="radio" label="Yes" checked="<%=yIsCheckedRecChkReviewed%>" disabled="<%=szDisabled %>" tabIndex="<%= tabIndex++ %>" value="Y" name="rbRecChkReviewed" cssClass="formInput"  />
      <impact:validateInput type="radio" label="No" checked="<%=nIsCheckedRecChkReviewed%>" disabled="<%=szDisabled %>" tabIndex="<%= tabIndex++ %>" value="N" name="rbRecChkReviewed" cssClass="formInput"  />
      <impact:validateInput type="radio" label="N/A" checked="<%=xIsCheckedRecChkReviewed%>" disabled="<%=szDisabled %>" tabIndex="<%= tabIndex++ %>" value="X" name="rbRecChkReviewed" cssClass="formInput"  />
    </td>
  </tr>
  <tr>
    <td colspan="2"><span class="formCondRequiredText">&#135;</span>Synopsis of records reviewed and how it impacts allegations:</td>
  </tr>
  <tr>
    <td colspan="2"><impact:validateTextArea name="txtSynopsisRecReviewed"
          label="" rows="5" cols="85" tabIndex="<%=tabIndex++%>"
          maxLength="4000" disabled="false"
          constraint="Paragraph4000" conditionallyRequired="false">
          <%=FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtSynopsisRecReviewed())%>
        </impact:validateTextArea></td>
  </tr>
  <tr>
    <td colspan="2"><span class="formRequiredText">*</span>Results of the 48 Hour Case Staffing:</td>
  </tr>
  <tr>
    <td colspan="2"><impact:validateTextArea name="txtResultsCaseStaffing"
          label="" rows="5" cols="85" tabIndex="<%=tabIndex++%>"
          maxLength="4000" disabled="false"
          constraint="Paragraph4000" conditionallyRequired="false">
          <%=FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtResults48hrStaffing())%>
        </impact:validateTextArea></td>
  </tr>
  <tr>
    <td colspan="2"><span class="formRequiredText">*</span>Names and Agencies Represented at Case Staffing:</td>
  </tr>
  <tr>
    <td colspan="2"><impact:validateTextArea name="txtNamesAgenciesRepCaseStaffing"
          label="" rows="5" cols="85" tabIndex="<%=tabIndex++%>"
          maxLength="4000" disabled="false"
          constraint="Paragraph4000" conditionallyRequired="false">
          <%=FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtNamesAgncyRepStaffing())%>
        </impact:validateTextArea></td>
  </tr>
</table>
<br/>
<impact:ExpandableSectionTag name="HomeWaiver" id="homeWaiver_id"
                             label="Home Waiver" tabIndex="<%= tabIndex++ %>">                            
<table border="0" width="100%" cellSpacing="0" cellPadding="0"> 
  <tr class="odd">
    <td>&nbsp;</td>
  </tr>
  <tr class="odd">
    <td><span class="formCondRequiredText">&#135;</span>Justification for the DFCS home to remain open:</td>
  </tr> 
  <tr class="odd">
    <td><impact:validateTextArea name="txtJustHmeRemainOpen"
          label="" rows="5" cols="120" tabIndex="<%=tabIndex++%>"
          maxLength="4000" disabled="false"
          constraint="Paragraph4000" conditionallyRequired="false">
          <%=FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtJustHmeRemainOpen())%>
        </impact:validateTextArea></td>
  </tr>
  <tr class="odd">
    <td>&nbsp;</td>
  </tr>
  <tr class="odd">
    <td><span class="formCondRequiredText">&#135;</span>What steps will be taken to assure the safety of the foster children placed in the home:</td>
  </tr>
  <tr class="odd">
    <td><impact:validateTextArea name="txtStepsToAssureSafetyOfChildren"
          label="" rows="5" cols="120" tabIndex="<%=tabIndex++%>"
          maxLength="4000" disabled="false"
          constraint="Paragraph4000" conditionallyRequired="false">
          <%=FormattingHelper.formatString(spclInvestigationRetrieveSO.getTxtStepsAssureSafety())%>
        </impact:validateTextArea></td>
  </tr>
  <tr class="odd">
    <td>&nbsp;</td>
  </tr>
  <tr class="odd">
    <td><span class="formCondRequiredText">&#135;</span>Specify the name, legal status, permanency plan and length of time placed in the </br>
        &nbsp;&nbsp;&nbsp;&nbsp;foster home for each foster child remaining in the home and subject to this waiver:</td>
  </tr>
  <tr class="odd">
    <td>
      <table border="0" width="100%" cellSpacing="0" cellPadding="0">
	    <tr class="odd">
	      <th class="thList">&nbsp;</th>
	      <th class="thList">Name</th>
	      <th class="thList">Legal County</th>
	      <th class="thList">Legal Status</th>
	      <th class="thList">Permanency Plan(s)</th>
	      <th class="thList">Placement Type</th>
	      <th class="thList">Time in<br/>Placement</th>
	    </tr>
<%
List<SpclInvHmeWaiverChildHistBean> waiverChildHistBeans = spclInvestigationRetrieveSO.getSpclInvHmeWaiverChildHistBeans();
if (waiverChildHistBeans != null && !waiverChildHistBeans.isEmpty()) {
  Iterator<SpclInvHmeWaiverChildHistBean> iterWaiverChildHistBeans = waiverChildHistBeans.iterator();
  int i = 0;
  while (iterWaiverChildHistBeans.hasNext()) {
    SpclInvHmeWaiverChildHistBean waiverChildHist = iterWaiverChildHistBeans.next();
    String cbxWaiverChildHist = "cbxWaiverChildHist_" + i;
    String indChildRemainInHome = "false";
    if (ArchitectureConstants.Y.equals(waiverChildHist.getIndRemainInHome())) {
      indChildRemainInHome = "true";
    }
    String years = "";
    if (waiverChildHist.getNumYearInPlcmnt() > 0) {
       years = waiverChildHist.getNumYearInPlcmnt() + " Year(s) ";
    }
    // Seperate the Permanency Plan and the Concurrency Plan with a '-' if a Concurrency Plan exists
    String cdChildConcurPlan = "".equals(waiverChildHist.getCdChildConcurPlan()) ? "" : " - " + Lookup.simpleDecodeSafe(CodesTables.CPERMPLN, waiverChildHist.getCdChildConcurPlan());
    
 %>
        <tr class="<%=FormattingHelper.getRowCss(i)%>">
          <td><impact:validateInput type="checkbox" name="<%=cbxWaiverChildHist%>" disabled="<%=szDisabled %>"  checked="<%=indChildRemainInHome%>" value="Y"/></td>
          <td><%=waiverChildHist.getNmPersonFull()%></td>
          <td><%=Lookup.simpleDecodeSafe(CodesTables.CCOUNT, waiverChildHist.getCdChildLegalCounty())%></td>
          <td width="20%"><%=Lookup.simpleDecodeSafe(CodesTables.CLEGSTAT, waiverChildHist.getCdChildLegalStatus())%></td>
          <td><%=Lookup.simpleDecodeSafe(CodesTables.CPERMPLN, waiverChildHist.getCdChildPermncyPlan()) + cdChildConcurPlan%></td>
          <td><%=Lookup.simpleDecodeSafe(CodesTables.CPLMNTYP, waiverChildHist.getCdChildPlcmntType())%></td>
          <td><%=FormattingHelper.formatString(years + waiverChildHist.getNumMonthsInPlcmnt() + " Months")%></td>
        </tr>
<%
    i++;
  }
}
 %>   	    
	  </table>
    </td>
  </tr>                               
  </table>
</impact:ExpandableSectionTag>
<%
int showButtonOnClosed = EditableMode.MODIFY;
if(ArchitectureConstants.Y.equals(request.getAttribute( "modifyIfStageClosed"))) {
  showButtonOnClosed = EditableMode.ALL;
}

 %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
	<td width="75%">&nbsp;</td>
<%
  if (!CodesTables.CEVTSTAT_PEND.equals(cdEventStatus)) {
%>  
	<td align="right">
		<impact:ButtonTag name="btnSaveAndSubmit" img="btnSaveAndSubmit" form="frmSpclInvestigation" align="right" action="/investigation/SpecialInvestigation/saveSubmitSpecialInvestigation"
		restrictRepost="true" preventDoubleClick="true" disabled="<%=szDisabled %>" editableMode="<%= showButtonOnClosed %>" function="" tabIndex="<%=tabIndex++%>"/>
	</td>
<%
  }
%>	
	<td align="right">
		<impact:ButtonTag name="btnSave" img="btnSave" form="frmSpclInvestigation" align="right" action="/investigation/SpecialInvestigation/saveSpecialInvestigation"
		restrictRepost="true" preventDoubleClick="true" disabled="<%=szDisabled %>" editableMode="<%= showButtonOnClosed %>" tabIndex="<%=tabIndex++%>"/>
	</td>
	
  </tr>
</table>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<%-- Close Validate Form Custom Tag --%>
</impact:validateForm>

<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td>
      <impact:documentButton pageMode="<%= pageMode %>" buttonUrl="/grnds-docs/images/shared/btnNarrative.gif" tabIndex="<%= tabIndex++ %>" accessKey="W">

        <impact:document
          displayName="CpsConclusion"
          checkForNewMode="true"
          name="CpsConclusion"
          docType="cpscnlsn"
          docExists="<%= docExists%>"
          protectDocument="true">
          <impact:documentParameter name="sEvent" value="<%= String.valueOf(spclInvestigationRetrieveSO.getIdCpsInvEvent()) %>" />
          <impact:documentParameter name="sCase" value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>" />
        </impact:document>
      </impact:documentButton>
    </td>
  </tr>
</table>