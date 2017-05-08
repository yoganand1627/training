<%
   /**
       * Provider Allegation History
       * Author: Corey Harden
       * Date: 06/06/2011
       * 
       * 					Change History
       *
       *   Date          User				              Description
       * --------  ----------------  --------------------------------------------------
       *
       *
       *
       *
   */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cdisp"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cscnotrn"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cdispstn"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Ccrskfnd"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.resource.ProviderAllegation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckPersonBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ProviderAllegationHistorySO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>

<%
  // get the state map
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  // retrieve the Service Out (SO) object from the request
  ProviderAllegationHistorySO providerAllegationHistorySO = (ProviderAllegationHistorySO) request.getAttribute("providerAllegationHistorySO");
  
  // get list of allegations on provider
  @SuppressWarnings("unchecked")
  List<ProviderAllegation> providerAllegationList = providerAllegationHistorySO.getProviderAllegList();

  // get the user profile for display rule logic
  UserProfile user = UserProfileHelper.getUserProfile(request);

  // create date for auto population of date of request fields
  String today = DateHelper.toString(new Date(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING));

  // get the primary key of the stage
  int ulIdStage = GlobalData.getUlIdStage(request);

  // use stage id to determine whether the current user has access to the stage
  boolean hasStageAccess = CaseUtility.hasStageAccess(user.getUserID(), ulIdStage);

  // create page mode variable based on stage access
  String pageMode = hasStageAccess ? PageModeConstants.MODIFY : PageModeConstants.INQUIRE;
%>



<!-- JAVASCRIPT SECTION -->
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/javascript" language="JavaScript1.2">

	
	/**
	* This function adds data to hidden variables and submits the summary list form
	* @param personId - the id of the person
	* @param name - the name of the person
	*/
	function displayIntakeActions(idStage){
		document.getElementById('stageId').value = idStage;
		submitValidateForm('frmProviderAllgtnHistory', '/intake/IntakeActions/displayIntakeActions');
	}
	
	
	function displayCpsInvCnclsn(idStage, nmCase, idCase){
		document.getElementById('invStageId').value = idStage;
		document.getElementById('nmCase').value = nmCase;
		document.getElementById('idCase').value = idCase;
		submitValidateForm('frmProviderAllgtnHistory', '/resource/ProviderAllgtnHistory/displayCpsInvCnclsn');
	}
		
	
</script>
<!-- END JAVASCRIPT SECTION -->



<!-- ERROR DISPLAY AREA -->
<impact:validateErrors />
<!-- END ERROR DISPLAY AREA -->




<!-- ------------------------------------------------------BEGIN RECORDS CHECK SUMMARY VIEW---------------------------------------------- -->

<!-- RECORDS CHECK LIST AREA -->
<impact:validateForm name="frmProviderAllgtnHistory" method="post" action="/resource/ProviderAllgtnHistory/displayProviderAllgtnHistory" validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.ProviderAllgnHistoryCustomValidation" pageMode="" schema="/WEB-INF/Constraints.xsd">
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
  <impact:validateInput type="hidden" id="stageId" name="stageId" value="" />
  <impact:validateInput type="hidden" id="invStageId" name="invStageId" value="" />
  <impact:validateInput type="hidden" id="nmCase" name="nmCase" value="" />
  <impact:validateInput type="hidden" id="idCase" name="idCase" value="" />
  <impact:validateInput type="hidden" id="displayIntakeActionsFAHomeSearch" name="displayIntakeActionsFAHomeSearch" value="Y" />
  
  

    <div style="width: 100%; border-top: solid black 1px">
    	<table border="0" cellspacing="0" cellpadding="3" style="width: 100%; height: 40px; position: relative; top: 20px">
    		<tr>
    			<th class="thList">
					Intake ID
				</th>
				<th class="thList">
					Intake Date
				</th>
				<th class="thList">
					Intake Disposition
				</th>
				<th class="thList">
					Screen Out Reason
				</th>
				<th class="thList">
					Alleged Maltreatment in Care?
				</th>
				<th class="thList">
					Inv Maltreatment Finding
				</th>
				<th class="thList">
					Overall Risk Finding
				</th>
				<th class="thList">
					Inv Maltreatment in Care?
				</th>
    		</tr>
    	<%
    	if(!providerAllegationHistorySO.isAllegationAvail()) {
    	%>
    	<tr>
    		<td colspan="8"align="left" ><%= MessageLookup.getMessageByNumber(Messages.MSG_INT_STAGE_NOT_FOUND) %></td>
    	</tr>
    	<%
    	}else{
    	    //create counter to alternate row coloring
    	    int rowCount = 1;
    	    
    	    //loop thru list to write out allegation info
    	  	for (ProviderAllegation alleg : providerAllegationList) {
    	  		String strIntStage = alleg.getIdStage() == 0 ? "" : String.valueOf(alleg.getIdStage()); 
    	%>
    	<!-- DISPLAY ALL PROVIDER ALLEGATIONS -->
    		<tr class=<%=rowCount % 2 == 0 ? "even" : "odd"%>>
    			<td><a href="javascript: displayIntakeActions('<%= alleg.getIdStage() %>')"><%= strIntStage %></a></td>
    			<td><%= DateHelper.toString(alleg.getDateOfCall(), new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING)) %></td>
    			<td><%= alleg.getDisposition() != null ? Lookup.simpleDecode(Cdisp.CDISP, alleg.getDisposition()) : "" %></td>
    			<td><%= alleg.getScreenOut() != null ? Lookup.simpleDecode(Cscnotrn.CSCNOTRN, alleg.getScreenOut()) : "" %></td>
    			<td><%= alleg.getIsMic() != null ? alleg.getIsMic() : "" %></td>
    			<td><a href="javascript: displayCpsInvCnclsn('<%= alleg.getInvIdStage() %>', '<%= alleg.getNmCase() %>', '<%= alleg.getIdCase() %>')"><%= alleg.getOverallInvDisposition() != null ? Lookup.simpleDecode(Cdispstn.CDISPSTN, alleg.getOverallInvDisposition()) : "" %></a></td>
    			<td><%= alleg.getConclusionRiskFnd() != null ? Lookup.simpleDecode(Ccrskfnd.CCRSKFND, alleg.getConclusionRiskFnd()) : "" %></td>
    			<td><%= alleg.getInvMaltreatment() != null ? alleg.getInvMaltreatment() : "" %></td>
    		</tr>
    	<!-- END DISPLAY ALL PROVIDER ALLEGATIONS -->
    	<%
    			rowCount++;
    	      } 
    	 }
    	%>
    	</table>
    </div>
</impact:validateForm>

