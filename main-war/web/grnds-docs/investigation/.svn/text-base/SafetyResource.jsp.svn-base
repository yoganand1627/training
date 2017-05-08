<%--
JSP Name:     Safety Resource
Created by:   Josh Dorsey
Date Created: 10/01/02

Description:
This JSP is the parent page for Safety Resource and Safety Resource Child Detail,
which are used to record placements for children who are moved from their homes
but do not enter DFCS custody.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
06172008  Patrick Coogan    Updated and checked in for Georgia SHINES release 
                            2.5
06242008  Patrick Coogan    Updated formtag docExists = "true" for page mode in
                            view only mode  
06/21/2009  bgehlot         STGAP00014329: MR-20 updates        
07/09/2009  cwells          STGAP00014333: MR-20 Form updates
07/13/2009  bgehlot         STGAP00014669: Used CROLEALL for roles            
09/02/2009  bgehlot         STGAP00015302:  Update the section label 'Children Considered For Placement'  to 'Children Considered for Safety Resource Placement'
                            and  Update the text in the section label that reads ' Primary Caretaker Household Member check box' to 'Member of Primary Caretaker's Household checkbox'
09/30/2009  bgehlot         STGAP00015485: Updated the text to say dropdwon instead of checkbox     
03/01/2011  cwells          SMS 77962: Not allowing user the ability to create new safety resources 
                            When current stage is closed.  
06/20/2011  hjbaptiste      SMS#112385: CAPTA 4.3: Safety Resource - fixed logic to add another approver  
7/5/2011    cwells          SMS#113884: CAPTA 4.3: Removing save and submit button while in approval mode   
09/28/2011  arege           STGAP00017055: Date of Home Visit and Date Request Received fields are required only on Save and Submit.                                             

--%>

<%-- Imports --%>

<%@taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceRetrieveSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceHshldMemberBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="java.util.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>

<%

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
  
  BaseSessionStateManager state = (BaseSessionStateManager)
          request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  
  SafetyResourceRetrieveSO safetyResourceRetrieveSO = 
              (SafetyResourceRetrieveSO) state.getAttribute("safetyResourceRetrieveSO", request); 
              
              
              
  boolean isStageClosed = (Boolean) state.getAttribute("isStageClosed", request);
              
              
  
  //Set Page Mode and related variables for display
  String pageMode = PageMode.getPageMode(request);
  boolean bIsEditable = !pageMode.equals(PageModeConstants.VIEW);
  boolean bIsNew = (safetyResourceRetrieveSO.getUlIdEvent()==0);
  String cdEventStatus = safetyResourceRetrieveSO.getCdEventStatus();
  String tsLastUpdate ="";
  boolean bDocumentExists = false;
  
  String szDisabled = "false";
  String szDeleteIsNotVisible = "false";
  String szAddIsNotVisible = "false";
  String saveAndSubmit = "false";
    
  if (!bIsEditable){  
     szDisabled = "true";
  }
 
  if ((!bIsEditable) || bIsNew) {
     szAddIsNotVisible = "true";
     szDeleteIsNotVisible = "true";
     saveAndSubmit = "true";
  }
  
  // SMS 77962 removing the add placement button if the stage is closed. 
  if(isStageClosed){
  szAddIsNotVisible = "true";
  }
  if(CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)){
     szDisabled = "true";
     szDeleteIsNotVisible = "true";
     saveAndSubmit = "true";
  }
  
  if(CodesTables.CEVTSTAT_PEND.equals(cdEventStatus)){
     szDeleteIsNotVisible = "true";
 //SMS 113884 4.3 Capta Removing the save and submitt button while the page is in approval mode. 
     if (GlobalData.isApprovalMode(request)){
     saveAndSubmit = "true";
     }
  }
  
  if (safetyResourceRetrieveSO.getUlIdEvent() != 0) {
      tsLastUpdate = DateHelper.toISOString(safetyResourceRetrieveSO.getDtLastUpdate());
  }
  
  if (ArchitectureConstants.Y.equals(safetyResourceRetrieveSO.getIndBLOBExistsInDatabase()))
  {
    bDocumentExists = true;
  }

  //Initialize the display variables for the page
  int tabIndex = 1;
  
  //Populate key return objects for the display
  List<SafetyResourcePersonBean> personSafetyResourceList =  safetyResourceRetrieveSO.getPersonSafetyResource();
  List<Integer> householdMemberList = safetyResourceRetrieveSO.getHshldMembers();
  List<SafetyResourceHshldMemberBean> principalsCollateralList = safetyResourceRetrieveSO.getPrincipalsCollaterals();
  List<SafetyResourceChildRetrieveSO> savedPlacementsList = safetyResourceRetrieveSO.getSrChildren();
  
  //STGAP00014329: Added new section " Children Considered For Placement"
  List<Integer> childrenConsideredList = safetyResourceRetrieveSO.getChildrenConsideredList();
  List<SafetyResourceHshldMemberBean> memeberPKHouseHoldUnder18List = safetyResourceRetrieveSO.getMemeberPKHouseHoldUnder18List();
  state.setAttribute("childrenConsideredList", childrenConsideredList, request);
  state.setAttribute("memeberPKHouseHoldUnder18List", memeberPKHouseHoldUnder18List, request);
  
  //Set attributes back into state that will be needed to process updates and perform validation
  state.setAttribute("savedHouseholdMemberList", householdMemberList, request);
  state.setAttribute("principalsCollateralList", principalsCollateralList, request);
  state.setAttribute("savedPlacementsList", savedPlacementsList, request);

  //Declare specific option list to show the names of persons over 18 for safety resources
  List<Option> resourceList = new ArrayList<Option>();
  
  //Populate list of potential safety resources
  if (!personSafetyResourceList.isEmpty()){
  
      for (Iterator<SafetyResourcePersonBean> it = personSafetyResourceList.iterator(); it.hasNext();) {
          SafetyResourcePersonBean safetyResourcePersonBean = it.next();
          String idPerson = "";
          idPerson = String.valueOf(safetyResourcePersonBean.getUlIdChild());
          String nmPerson = "";
          nmPerson = safetyResourcePersonBean.getNmChildFull();
          resourceList.add(new Option(idPerson, nmPerson));
       }
  
  }
  
  //If safety resource have already been selected, set the value to default the option and
  //disable the dropdown
  String szIdPrimaryRsrc = "";
  String szIdSecondaryRsrc = ""; 
  String primaryDisable = szDisabled;
  String secondaryDisable = szDisabled;

  if ((((Integer) safetyResourceRetrieveSO.getUlIdPrimary()) != null) && 
                                          (safetyResourceRetrieveSO.getUlIdPrimary() != 0)) 
  {
  
    szIdPrimaryRsrc = String.valueOf(safetyResourceRetrieveSO.getUlIdPrimary());
    primaryDisable = "true";
  }
  
  if (((Integer)(safetyResourceRetrieveSO.getUlIdSecondary()) != null) && 
                                         (safetyResourceRetrieveSO.getUlIdSecondary() != 0)) 
  {
  
    szIdSecondaryRsrc  = String.valueOf(safetyResourceRetrieveSO.getUlIdSecondary());
    secondaryDisable = "true";
  }
  
  //STGAP00014329: Added new dates to the page as per MR-20
  String dtRequestReceived = "";
  String dtHomeVisit = "";
  String txtComments = "";
  String indRecommend = "";
  String cdDenialReason= "";
  String indRecommend_yes = "false";
  String indRecommend_no = "false";
      
      String rb_indRecommend = safetyResourceRetrieveSO.getIndRecommendation();
      if("Y".equals(rb_indRecommend)){
        indRecommend_yes = "true";
      }
      else if("N".equals(rb_indRecommend)){
        indRecommend_no = "true";
      }
      
      
    if (safetyResourceRetrieveSO.getCdDenialReason() != null){  
    cdDenialReason =   safetyResourceRetrieveSO.getCdDenialReason();
  } 
  
   if (safetyResourceRetrieveSO.getTxtComments() != null){  
    txtComments =   safetyResourceRetrieveSO.getTxtComments();
  }  
      
  
  if (safetyResourceRetrieveSO.getDtRequestReceived() != null) 
  {  
    dtRequestReceived =   FormattingHelper.formatDate(safetyResourceRetrieveSO.getDtRequestReceived());
  }
  if (safetyResourceRetrieveSO.getDtHomeVisit() != null) 
  {  
    dtHomeVisit =   FormattingHelper.formatDate(safetyResourceRetrieveSO.getDtHomeVisit());
  }

   
%>

<%--Define javascript functions --%>

<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

<%-- Standard dirty form message --%> 

window.onbeforeunload = function ()
{
  IsDirty();
}

window.onload = function ()
{
  frmSafetyResource.hdnUlIdSrChild.value = 0;
}

<%--This function is used to set the id of the specific child detail row when cliking the hyperlink --%>

function safetyResourceChild(ulIdSrChild)
{
  cancelValidation();
  frmSafetyResource.hdnUlIdSrChild.value = ulIdSrChild;
  submitValidateForm( 'frmSafetyResource', '/investigation/SafetyResource/displaySafetyResourceChild' );
}

function cancelValidation ()
{
  disableValidation('frmSafetyResource');
}

</script>

<%-- End Javascript --%>

<%-- Start Form --%>

<impact:validateErrors />
<impact:validateForm 
 name="frmSafetyResource" method="post" 
 action="/investigation/SafetyResource/displaySafetyChild" 
 pageMode="<%= pageMode %>"  
 schema="/WEB-INF/Constraints.xsd"
 validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.SafetyResourceCustomValidation">
 
 <impact:validateInput type="hidden" name="tsLastUpdate" value="<%=tsLastUpdate%>" />
 
 <%//STGAP00014329: Added Approval Status
  if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request)) && 
       (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus) || CodesTables.CEVTSTAT_APRV.equals(cdEventStatus) ||
        CodesTables.CEVTSTAT_COMP.equals(cdEventStatus))) {
      String action = ApprovalStatusConversation.DISPLAY_URI;
      if (GlobalData.isApprovalMode(request)) {
        action = "/investigation/SafetyResource/submitApproval";
      }

%>
    <impact:ButtonTag name="btnApprovalStatusFinal" img="btnApprovalStatus" form="frmSafetyResource" action="<%=action%>" disabled="false" tabIndex="<%=tabIndex%>" />
<%
  }
%>
 <br>
 <br>
 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
    <tr>
      <th colspan="4">
        Safety Resources <i style="color:red">Dropdowns populated from Person Detail by selecting the Safety Resource checkbox.</i>
      </th>
    </tr>
    <tr> 
     <td>
      <impact:validateSelect
        label="Primary Safety Resource"
        name="selPrimaryResource"
        id="selPrimaryResource"
        options="<%=resourceList%>"
        disabled="<%= primaryDisable  %>"
        value = "<%= szIdPrimaryRsrc %>"
        required="true"
        tabIndex="<%= tabIndex++ %>"/>
     </td>
      <td>		  <span class="formRequiredText">*</span>
      
				<impact:validateDate name="dtRequestReceived" disabled="false"
					label="Date Request Received" 
					value="<%=dtRequestReceived%>" size="10"
					constraint="Date" tabIndex="<%=tabIndex++%>" disabled = "<%=szDisabled %>" />
					</td>
     
   </tr> 
   
   <tr> 	
     <td>
      <impact:validateSelect
        label="Secondary Safety Resource"
        name="selSecondaryResource"
        id="selSecondaryResource"
        options="<%=resourceList%>"
        disabled="<%= secondaryDisable  %>"
        value = "<%= szIdSecondaryRsrc %>"
        required="false"
        tabIndex="<%= tabIndex++ %>"/>
     </td>
		  <td><span class="formRequiredText">*</span>
				<impact:validateDate name="dtHomeVisit" disabled="false"
					label="Date of Home Visit" 
					value="<%=dtHomeVisit%>" 
					size="10"
					constraint="Date" tabIndex="<%=tabIndex++%>" disabled = "<%=szDisabled %>" />
		  </td>
		  </tr>
		  <tr>
		  <td><span class="formRequiredText">*</span>
							<impact:validateDisplayOnlyField name="dspRepType"
								label="Are you recommending the Primary Safety Resource for Placement?" />
						</td>
	        <td colspan="3">
			 
      				<impact:validateInput type="radio" label="Yes" name="indRecommendation"  value="Y" cssClass="formInput" checked="<%=indRecommend_yes%>" tabIndex="<%= tabIndex++ %>"/>
     				 <impact:validateInput type="radio"  label="No" name="indRecommendation"  value="N" cssClass="formInput" checked="<%=indRecommend_no%>" tabIndex="<%= tabIndex++ %>"/>
    </td>
    </tr>
    <tr>
    <td colspan="3">
      <impact:validateSelect
        label="Reason for denial?"
        name="selDenialReason"
        id="selDenialReason"
        codesTable="<%= CodesTables.CSRPLDEN %>"
        value = "<%=cdDenialReason%>"
        conditionallyRequired="true"
        tabIndex="<%= tabIndex++ %>"/>
     </td>
           <td>
	             &nbsp;
	   	</td>
     </tr>
     <tr>
     <td>
     <span class="formCondRequiredText">&#135;</span>
     <label for="txtComments"> Comments:</label>
     </td>
     <td colspan="3">
      <impact:validateTextArea name="txtComments"
            maxLength="300"
            rows="3" cols="100" tabIndex="<%= tabIndex++ %>" constraint="Comments" > <%=txtComments%>
	 </impact:validateTextArea>
    </td>
     </tr>

  </table>  
  <br>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
    <tr>
      <th colspan="4">
        Children Considered for Safety Resource Placement<i style="color:red"> Section populated from Person Detail by selecting Yes in the Member of Primary Caretaker's Household dropdown.</i>
      </th>
    </tr>
    <tr>
    <td colspan="4">
    <div id="scrollBar" style="height:100;width:762px;overflow:auto" class="tableborderList">
		<table width="100%" cellspacing="0" cellpadding="2" border="0" class="tableborder">
		  <tr class="subDetail">
		    <th class="thList"></th>
		    <th>Name</th>
		    <th>Role</th>
		    <th>Relation/Interest</th>
		   </tr> 
		              
		          <% 
		            if(memeberPKHouseHoldUnder18List.isEmpty())
		            {
		          %>
		          <tr class="odd">
		            <td colspan="5">
		              <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
		            </td>
		          </tr>
		          <%
		          }
		          else
		          {
		            // The following code displays all members of PK household and prefills the checkbox if selected
		            int loopCount = 0;
		            for (Iterator <SafetyResourceHshldMemberBean> it = memeberPKHouseHoldUnder18List.iterator(); it.hasNext();) {
		            
		                SafetyResourceHshldMemberBean memeberPKHouseHoldUnder18 = it.next();
		                Integer ulIntIdPerson = (Integer) memeberPKHouseHoldUnder18.getUlIdPerson();
		                String szChecked = "true";
		                
		                if (!childrenConsideredList.contains(ulIntIdPerson)){
		                     szChecked = "false";
		                 }
		                 
		                 String checkId = "cbxChildren_"+loopCount;
		              
		          %>
		          <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
		            <td>
		            <impact:validateInput type="checkbox" value="<%= String.valueOf(loopCount) %>" 
		             name="<%= checkId %>" disabled = "<%=szDisabled %>" checked="<%= szChecked %>" 
		             tabIndex="<%= tabIndex++ %>" />              
		            </td>
		            <td><%= memeberPKHouseHoldUnder18.getNmPersonFull() %></td>
		            <td><%= Lookup.simpleDecodeSafe( CodesTables.CROLEALL, memeberPKHouseHoldUnder18.getSzRole() ) %></td>
		            <td><%= Lookup.simpleDecodeSafe( CodesTables.CRPTRINT, memeberPKHouseHoldUnder18.getSzRelationship() ) %></td>
		          </tr>
		          <%
		                loopCount++;
		              } // end iterator of member of PK household
		            } // end else
		          %>
		</table>
	</div>
	</td>
	</tr>
</table>
<br>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
   <tr>
      <th colspan="4">
        Safety Resource Household Members
      </th>
   </tr>
   <tr>
   <td colspan="4">
   <div id="scrollBar" style="height:200;width:762px;overflow:auto" class="tableborderList"> 
	<table width="100%" cellspacing="0" cellpadding="2" border="0" class="tableborder">
	      <tr>
	        <th class="thList"></th>
	        <th class="thList">Name</th>
	        <th class="thList">Type</th>
	        <th class="thList">Role</th>
	        <th class="thList">Relation/Interest</th>
	      </tr>
	     
	          <% //handle cleanly if no principals or collaterals exist
	            if(principalsCollateralList.isEmpty())
	            {
	          %>
	          <tr class="odd">
	            <td colspan="5">
	              <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
	            </td>
	          </tr>
	          <%
	          }
	          else
	          {
	            // The following code displays all principals or collaterals and prefills the checkbox if selected
	            int loopCount = 0;
	            for (Iterator <SafetyResourceHshldMemberBean> it = principalsCollateralList.iterator(); it.hasNext();) {
	            
	                SafetyResourceHshldMemberBean principalCollateral = it.next();
	                Integer ulIntIdPerson = (Integer) principalCollateral.getUlIdPerson();
	                String szChecked = "true";
	                
	                if (!householdMemberList.contains(ulIntIdPerson)){
	                     szChecked = "false";
	                 }
	                 
	                 String checkId = "cbx_"+loopCount;
	              
	          %>
	          <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
	            <td>
	            <impact:validateInput type="checkbox" value="<%= String.valueOf(loopCount) %>" 
	             name="<%= checkId %>" disabled = "<%=szDisabled %>" checked="<%= szChecked %>" 
	             tabIndex="<%= tabIndex++ %>" />              
	            </td>
	            <td><%= principalCollateral.getNmPersonFull() %></td>
	            <td><%= Lookup.simpleDecodeSafe( CodesTables.CPRSNTYP, principalCollateral.getSzType() ) %></td>
	            <td><%= Lookup.simpleDecodeSafe( CodesTables.CROLEALL, principalCollateral.getSzRole() ) %></td>
	            <td><%= Lookup.simpleDecodeSafe( CodesTables.CRPTRINT, principalCollateral.getSzRelationship() ) %></td>
	          </tr>
	          <%
	                loopCount++;
	              } // end iterator of principals and collaterals
	            } // end else
	          %>
	    </table>
    </div>
    </td>
    </tr>
</table>
<br>
 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
    <tr>
      <th colspan="4">
        Children Placed With Safety Resource
      </th>
    </tr>
    <tr>
    <td colspan="4">
    <div id="scrollBar" style="height:100;width:762px;overflow:auto" class="tableborderList">
		<table width="100%" cellspacing="0" cellpadding="2" border="0" class="tableborder">
		  <tr class="subDetail">
		    <th>Child Name</th>
		    <th>Start Date</th>
		    <th>End Date</th>
		    <th>Primary SR Relationship</th>
		   </tr> 
		          <%// If no children have been placed with the current safety resource
		            if( savedPlacementsList.isEmpty())
		            {
		          %>
		          <tr class="odd">
		            <td colspan="4">
		              <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
		            </td>
		          </tr>
		          <%
		          }
		          else
		          { // Code iterates through the list of returned placements and displays to page
		            int loopCount = 0;
		            for (Iterator <SafetyResourceChildRetrieveSO> it = savedPlacementsList.iterator(); it.hasNext();) {
		            
		                SafetyResourceChildRetrieveSO safetyResourceChildRetrieveSO = it.next();
		                List<SafetyResourcePersonBean> safetyResourceChildList = 
		                                               safetyResourceChildRetrieveSO.getSafetyResourceChildList();
		                SafetyResourcePersonBean safetyResourcePersonBean = safetyResourceChildList.get(0);
		              
		          %>
		          <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
		            <td><a href="javascript:safetyResourceChild(' <%=String.valueOf(safetyResourceChildRetrieveSO.getUlIdSrChild()) %>')" 
		                   tabIndex="<%= tabIndex++ %>"><%= safetyResourcePersonBean.getNmChildFull() %></a></td>
		            <td><%= FormattingHelper.formatDate( safetyResourceChildRetrieveSO.getDtStart() ) %></td>
		            <td><%= FormattingHelper.formatDate( safetyResourceChildRetrieveSO.getDtEnd() ) %></td>
		            <td><%= Lookup.simpleDecodeSafe( CodesTables.CRPTRINT, safetyResourceChildRetrieveSO.getCdRelationshipPrimary() ) %></td>
		          </tr>
		          <%
		                loopCount++;
		              } // end iterator of safety resource child records
		            } // end else 
		          %>
		</table>
	</div>
	</td>
	</tr>
</table>

  <table border="0" cellspacing="0" cellpadding="3" width="100%">
     <tr> <td width="80%">
                  <impact:ButtonTag
                  name="btnAdd"
                  img="btnAddPlacement"
                  align="right"
                  navAwayCk="true"
                  disabled = "<%=szAddIsNotVisible %>"             
                  form="frmSafetyResource"
                  action="/investigation/SafetyResource/displaySafetyResourceChild"
                  backSafe="false"
                  tabIndex="<%= tabIndex++ %>"/>
   </td>
   </tr>
  </table>
  <br>
  
<table border="0" cellspacing="0" cellpadding="3" width="100%">
<tr> 
		<td width="85%" class="alignLeft">
		<impact:ButtonTag 
		 name="btnDelete" 
		 img="btnDelete" 
		 align="left" 
		 form="frmSafetyResource" 
		 action="/investigation/SafetyResource/deleteSafetyResource" 
		 restrictRepost="true" 
		 disabled = "<%=szDeleteIsNotVisible %>" 
		 preventDoubleClick="true" 
		 tabIndex="<%= tabIndex++ %>" />
		</td>
		
        <%//STGAP00014329: Added save and submit%>
        <td class="alignRight">
            <impact:ButtonTag name="btnSaveSubmit" 
              img="btnSaveAndSubmit" 
              form="frmSafetyResource" 
              action="/investigation/SafetyResource/saveSubmitSafetyResourceAssessment" 
              restrictRepost="true" 
              preventDoubleClick="true" 
              disabled = "<%=saveAndSubmit%>" 
              tabIndex="<%= tabIndex++ %>" />
        </td> 
          
		<td width="5%">
		<impact:ButtonTag 
		 name="btnSave" 
		 img="btnSave" 
		 align="right" 
		 form="frmSafetyResource" 
		 action="/investigation/SafetyResource/saveSafetyResource" 
		 restrictRepost="true" 
		 preventDoubleClick="true"
		 disabled = "<%=szDisabled %>" 
		 tabIndex="<%= tabIndex++ %>" />
		</td>
   </tr>
  </table>
<br> 
<%-- Hidden field section --%>
 
<impact:validateInput type="hidden" name="hdnUlIdSrChild" value="0" />
<impact:validateInput type="hidden" name="hdnUlIdEvent" 
 value="<%= String.valueOf(safetyResourceRetrieveSO.getUlIdEvent()) %>" />
<impact:validateInput type="hidden" name="hdnPreviousDenialReason" 
 value="<%= String.valueOf(safetyResourceRetrieveSO.getCdDenialReason()) %>" /> 	  
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>
  
<% /* start Forms and Reports */ %>
<%
boolean protectDoc = false;
boolean preFillAlways = true;

//STGAP00014329: After the page is saved for the first time, 
//the user is able to launch the Safety Resource Assessment form using the Document button 
if(pageMode.equals(PageModeConstants.VIEW) || (cdEventStatus != null && cdEventStatus != "")){ 
 
 //STGAP00014333 Document should be display only and should not prefill if the form is approved or user doesnt have stage access
  if(pageMode.equals(PageModeConstants.VIEW) || "APRV".equals(cdEventStatus))
  {
  protectDoc = true;
  preFillAlways = false;
  
  }  
%>
 <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="4">
        Safety Resource Assessment
      </th>
    </tr>
    <tr>
      <td>
        <impact:documentButton pageMode="<%= pageMode %>"
                             tabIndex="<%= tabIndex++ %>"
                             buttonUrl="/grnds-docs/images/shared/btnDocument.gif">
           <impact:document displayName="Safety Resource Assessment" 
	                           name = "frmDocumentTag"
	                           protectDocument="<%= protectDoc %>"
	                           postInSameWindow="false"
	                           preFillAlways="false" 
	                           docType="FAS05O00" 
	                           docExists="<%= bDocumentExists %>">
	            <impact:documentParameter name="sCase" value="<%=String.valueOf(GlobalData.getUlIdCase(request) ) %>" />
	            <impact:documentParameter name="pStage" value="<%=String.valueOf(safetyResourceRetrieveSO.getUlIdStage())%>" />
	            <impact:documentParameter name="sEvent" value="<%=String.valueOf(safetyResourceRetrieveSO.getUlIdEvent())%>" />
	        </impact:document>
	   </impact:documentButton>
      </td>
    </tr>
  </table>
<%} %>


<% /* end Forms and Reports */ %>
