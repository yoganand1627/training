
<%--
JSP Name:     ExchangeHomeDetail.jsp
Date Created: 03/27/08

Change History:
Date      User              Description
--------  ----------------  ----------------------------------------------
07/01/08  mchillman         JSP creation
02/19/08  mxpatel           STGAP00012481: Changed the code to show Match, Link and Unlink button at all times.
03/02/09  mxpatel           STGAP00012533: changed the code to display date instead of string.
05/21/09  mchillman 		STGAP00012047 added delete buttons for deletion of linked records
10/30/09  arege             SMS#37421: Changed the constraint on widget txtCommentsHA to allow character limit of 500. 
10/30/09  arege             SMS#37386: Changed the constraint on widget txtFamilyIsLinkedHA to allow character limit of 500. 
11/06/09  arege             Changed the constraint on fields Children Placed with , Explanation and  comments under Home Preferences
                            to allow character limit of 500.
10/30/09  chillman          SMS#37421: Changed the constraint on widget txtCommentsHA to allow character limit of 1000. 
10/30/09  chillman          SMS#37386: Changed the constraint on widget txtFamilyIsLinkedHA to allow character limit of 1000.  
12/10/09  arege             SMS#37333: Removed <bobr> so that the page formatting is not disturbed when the Non-Selection Reason code column 
                            value has length longer than column width.    
12/15/09   mxpatel          SMS# 40849: added code to make NAC and Date_Out columns sortable.                                

--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeDetailSO"%> 
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeHomeChildrenSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fad.ExchangeHomeDetailConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>


<%@ page import="java.util.Collection" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>



<%
  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );  
  ExchangeHomeDetailSO exchangeHomeDetailSO = (ExchangeHomeDetailSO) state.getAttribute(ExchangeHomeDetailConversation.EXCHANGE_HOME_DETAIL_ATTRIBUTE_NAME, request);
  
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  int idEvent = 0;
  String isDisabled = "false";
  String linkedCount = null;
  if(exchangeHomeDetailSO != null) {
  	linkedCount = (exchangeHomeDetailSO.getChildrenConsideringList() != null && exchangeHomeDetailSO.getChildrenConsideringList().size() > 0) ? ("" + exchangeHomeDetailSO.getChildrenConsideringList().size()) : "";
  }
  
  Collection ethnicities = Lookup.getCategoryCollection(CodesTables.CINDETHN);
    
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script language="JavaScript">

window.attachEvent('onload', myOnLoadFunction );

function myOnLoadFunction() {
  
}

function checkSave() {
 if(isPageChanged()) {
 	alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_SAVE_BEFORE_MATCH)%>");
 	return false;
 }
 
 return true;
}

function confirmDelete() {
 return confirm('<%= MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE") %>');
}

function navigateToPersonDetail(idExcChild, idChild, nmChild) {
  document.frmExchangeHomeDetail.<%=ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_EVENT%>.value = "";
  document.frmExchangeHomeDetail.<%=ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_EVENT%>.value = idExcChild;
  
  document.frmExchangeHomeDetail.<%=ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_ID%>.value = "";
  document.frmExchangeHomeDetail.<%=ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_ID%>.value = idChild;
  
  document.frmExchangeHomeDetail.<%=ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_NAME%>.value = "";
  document.frmExchangeHomeDetail.<%=ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_NAME%>.value = nmChild;
  
  disableValidation("frmExchangeHomeDetail");
  submitValidateForm("frmExchangeHomeDetail", "/fad/ExchangeHomeDetail/displayChildDetail");
}
</script>

<impact:validateErrors formName="frmExchangeHomeDetail" />
<impact:validateForm name="frmExchangeHomeDetail" 
	action="/fad/ExchangeHomeDetail/saveExchangeHomeDetail"
	pageMode="<%=pageMode%>"
	schema="/WEB-INF/Constraints.xsd"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.fad.ExchangeHomeDetailCustomValidation" >

<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
<td align="right">
        <a tabIndex="<%= tabIndex++ %>" href="#" onClick="javascript:expandAll();">Expand All</a>&nbsp;
        <a tabIndex="<%= tabIndex++ %>" href="#" onClick="javascript:collapseAll();">Collapse All</a>&nbsp;
</td>
 </tr>
</table>	
	
<%-- Begin Home Registration Information --%>

	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE1">
		
	  <tr>
	        <th colspan="4">Home Registration Information</th>
	  </tr>
	  <tr>
         <td><impact:validateDisplayOnlyField name="txtHomeName" label="Home Name" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getHomeName())%>"/></td>
      </tr>
      <tr>
         <td><impact:validateDisplayOnlyField name="txtCaseWorkerName" label="Case Worker" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getCaseWorkerName()) + " " + FormattingHelper.formatString(exchangeHomeDetailSO.getCaseWorkerPhoneNumber())%>"/></td>
      </tr>
      <tr>
        <td><impact:validateDisplayOnlyField name="txtAgencyName" label="Agency Name" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getAgencyName())%>"/></td>
      </tr>
      <tr>
      	<td><impact:validateInput type="text" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getAgencyContractNumber())%>" disabled="<%=isDisabled%>" name="txtAgencyContractCode" label="AgencyContractCode"  tabIndex="<%=tabIndex++%>" maxLength="3" size="3" /></td>
      </tr>
      <tr>
      	<td><impact:validateInput type="text" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getAgencyCaseWorkerName())%>" disabled="<%=isDisabled%>" name="txtAgencyCaseWorkerName" label="Private Agency Caseworker"  tabIndex="<%=tabIndex++%>" maxLength="25" size="25" constraint="Name25"/></td>
      </tr>
      <tr>
        <td><impact:validateInput type="text" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getPhoneNumber())%>" disabled="<%=isDisabled%>" name="txtPhoneNumber" label="Phone Number"  tabIndex="<%=tabIndex++%>" maxLength="10" size="10" constraint="Phone"/></td>
        <td><impact:validateInput type="text" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getPhoneNumberExt())%>" disabled="<%=isDisabled%>" name="txtPhoneNumberExt" label="Extension"  tabIndex="<%=tabIndex++%>" maxLength="8" size="8" constraint="PhoneExtension"/></td>
      </tr>
      <tr>
      	<td><impact:validateDisplayOnlyField name="txtDateInquired" label="Date Inquired" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtInquired())%>"/></td>
      	<td><impact:validateDisplayOnlyField name="txtDateApplied" label="Date Applied" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtApplied())%>"/></td>
      </tr>
      <tr>
      	<td><impact:validateDisplayOnlyField name="txtDateImpactBegin" label="Date IMPACT Begin" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtImpactBegin())%>"/></td>
      	<td><impact:validateDisplayOnlyField name="txtDateOrientation" label="Date Orientation" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtOrientation())%>"/></td>
      </tr>
      <tr>
      	<td><impact:validateDisplayOnlyField name="txtDateApproved" label="Date Approved" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtApproved())%>"/></td>
      	<td></td>
      </tr>
      <tr>
      	<td><impact:validateDate label="Date Registered" name="dateRegistered" type="text" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtRegistered())%>" size="10" conditionallyRequired="false" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" constraint="Date" /></td>
      	<td><impact:validateDate label="Date Re-Registered" name="dateReRegistered" type="text" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtReRegistered())%>" size="10" conditionallyRequired="false" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" constraint="Date" /></td>
      </tr>
      <tr>
      	<td><impact:validateDisplayOnlyField name="txtDateLastUpdate" label="Date Last Update" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtLastUpdateDisplay())%>"/></td>
      </tr>
      <tr>
        <td><impact:validateDisplayOnlyField name="txtCountyName" label="County Name" value="<%=Lookup.simpleDecodeSafe(CodesTables.CCOUNT, exchangeHomeDetailSO.getCdCounty())%>"/></td>
        <td><impact:validateDisplayOnlyField name="txtRegion" label="Region" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getCdRegion())%>"/></td>
      </tr>
    </table>
    
<%-- End Home Registration Information --%>
	<br>
<%-- Begin Family Demographic Information  --%>

	<impact:ExpandableSectionTag
		name="familyDemographicInformation"
		label="Family Demographic Information"
		tabIndex="<%=tabIndex++%>">
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE2">
	  <tr>
	  	<td>
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE2">
	  		<tr>
	        	<th>Father</th>
	  		</tr>
	  		<tr class="subDetail">
         		<td><impact:validateDisplayOnlyField name="txtFatherDOB" label="DOB" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtFatherDOB())%>"/></td>
         		<td><impact:validateDisplayOnlyField name="txtFatherRace" label="Race" value="<%=Lookup.simpleDecodeSafe(CodesTables.CRACE, exchangeHomeDetailSO.getFatherRace())%>" /></td>
         		<td><impact:validateDisplayOnlyField name="txtEthnicity" label="Ethnicity" value="<%=Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeHomeDetailSO.getFatherEthnicity())%>"/></td>
         		<td></td>
      		</tr>
         	<tr class="subDetail">
         		<td><impact:validateDisplayOnlyField name="txtFatherOccupation" label="Occupation" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getFatherOccupation())%>"/></td>
         		<td><impact:validateDisplayOnlyField name="txtFatherReligion" label="Religion" value="<%=Lookup.simpleDecodeSafe(CodesTables.CRELIGNS, exchangeHomeDetailSO.getFatherReligion())%>"/></td>
         		<td></td>
         		<td></td>
         		<td></td>
      		</tr>
		</table>
		</td>
	  </tr>
	  <tr>
		<td>
		 <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE3">
	  		<tr>
	        	<th>Mother</th>
	  		</tr>
	  		<tr class="subDetail">
         		<td><impact:validateDisplayOnlyField name="txtMotherDOB" label="DOB" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtMotherDOB())%>"/></td>
         		<td><impact:validateDisplayOnlyField name="txtMotherRace" label="Race" value="<%=Lookup.simpleDecodeSafe(CodesTables.CRACE, exchangeHomeDetailSO.getMotherRace())%>"/></td>
         		<td><impact:validateDisplayOnlyField name="txtMotherEthnicity" label="Ethnicity" value="<%=Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeHomeDetailSO.getMotherEthnicity())%>"/></td>
         		<td></td>
      		</tr>
         	<tr class="subDetail">
         		<td><impact:validateDisplayOnlyField name="txtMotherOccupation" label="Occupation" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getMotherOccupation())%>"/></td>
         		<td><impact:validateDisplayOnlyField name="txtMotherReligion" label="Religion" value="<%=Lookup.simpleDecodeSafe(CodesTables.CRELIGNS, exchangeHomeDetailSO.getMotherReligion())%>"/></td>
         		<td></td>
         		<td></td>
         		<td></td>
      		</tr>
		 </table>
		</td>
	  </tr>
	</table>
	</impact:ExpandableSectionTag>
	
<%-- End Family Demographic Information  --%>

	<br>
<%-- Begin Home Preferences --%>

	<impact:ExpandableSectionTag
		name="homePreferences"
		label="Home Preferences"
		tabIndex="<%=tabIndex++%>">
		
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE4">
	  		<tr>
	        	<th colspan="4">Special Needs Preferences</th>
	  		</tr>
	  		<tr class="subDetail">
		  		<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_01)%>" tabIndex="<%= tabIndex++ %>" checked="<%= (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndMentalRetardation())) ? "true" : "false" %>" value="Y"
						name="cbxMentalRetardation" disabled="<%=isDisabled%>" cssClass="formInput" />
				</td>
				<td>
					<impact:validateSelect name="selSzCdMentalRetardation" colspan="1" value="<%= FormattingHelper.formatString(exchangeHomeDetailSO.getCdLevelMentalRetardation()) %>" required="false" codesTable="<%=CodesTables.CADSEVER%>" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					<b> Background Factors</b>
				</td>
			</tr>
			<tr class="subDetail">
		  		<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_02)%>" tabIndex="<%= tabIndex++ %>" checked="<%= (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndVisualHearingImpairments())) ? "true" : "false" %>" value="Y"
						name="cbxVisualHearingImpairments" disabled="<%=isDisabled%>" cssClass="formInput" />
				</td>
				<td>
					<impact:validateSelect name="selSzCdVisualHearingImpairments" colspan="1" value="<%= FormattingHelper.formatString(exchangeHomeDetailSO.getCdLevelVisualHearingImpairments()) %>" required="false" codesTable="<%=CodesTables.CADSEVER%>" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_06)%>" tabIndex="<%= tabIndex++ %>" checked="<%= (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndFamilyHxofDrugsAlcohol())) ? "true" : "false" %>" value="Y"
						name="cbxFamilyHxofDrugsAlcohol" disabled="<%=isDisabled%>" cssClass="formInput" />
				</td>
			</tr>
			<tr class="subDetail">
		  		<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_03)%>" tabIndex="<%= tabIndex++ %>" checked="<%= (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndPhysicallyDisabled())) ? "true" : "false" %>" value="Y"
						name="cbxPhysicallyDisabled" disabled="<%=isDisabled%>" cssClass="formInput" />
				</td>
				<td>
					<impact:validateSelect name="selSzCdPhysicallyDisabled" colspan="1" value="<%= FormattingHelper.formatString(exchangeHomeDetailSO.getCdLevelPhysicallyDisabled()) %>" required="false" codesTable="<%=CodesTables.CADSEVER%>" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_07)%>" tabIndex="<%= tabIndex++ %>" checked="<%= (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndFamilyHxofMentalIllness())) ? "true" : "false" %>" value="Y"
						name="cbxFamilyHxofMentalIllness" disabled="<%=isDisabled%>" cssClass="formInput" />
				</td>
			</tr>
			<tr class="subDetail">
		  		<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_04)%>" tabIndex="<%= tabIndex++ %>" checked="<%= (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndEmotionallyDisturbed())) ? "true" : "false" %>" value="Y"
						name="cbxEmotionallyDisturbed" disabled="<%=isDisabled%>" cssClass="formInput" />
				</td>
				<td>
					<impact:validateSelect name="selSzCdEmotionallyDisturbed" colspan="1" value="<%= FormattingHelper.formatString(exchangeHomeDetailSO.getCdLevelEmotionallyDisturbed()) %>" required="false" codesTable="<%=CodesTables.CADSEVER%>" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_08)%>" tabIndex="<%= tabIndex++ %>" checked="<%= (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndFamilyHxofMR())) ? "true" : "false" %>" value="Y"
						name="cbxFamilyHxofMR" disabled="<%=isDisabled%>" cssClass="formInput" />
				</td>
			</tr>
			<tr class="subDetail">
		  		<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_05)%>" tabIndex="<%= tabIndex++ %>" checked="<%= (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndOtherMedicalDiagnoses())) ? "true" : "false" %>" value="Y"
						name="cbxOtherMedicalDiagnoses" disabled="<%=isDisabled%>" cssClass="formInput" />
				</td>
				<td>
					<impact:validateSelect name="selSzCdOtherMedicalDiagnoses" colspan="1" value="<%= FormattingHelper.formatString(exchangeHomeDetailSO.getCdlevelOtherMedicalDiagnoses()) %>" required="false" codesTable="<%=CodesTables.CADSEVER%>" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_09)%>" tabIndex="<%= tabIndex++ %>" checked="<%= (ArchitectureConstants.Y.equals(exchangeHomeDetailSO.getIndChilsHxofSexualAbuse())) ? "true" : "false" %>" value="Y"
						name="cbxChilsHxofSexualAbuse" disabled="<%=isDisabled%>" cssClass="formInput" />
				</td>
			</tr>
		</table>
		
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE5">
	  		<tr>
	        	<th colspan="4">Child Race Preferences</th>
	  		</tr>
		  	<tr class="subDetail">
		  		 <td>
			      <impact:codesCheckbox
			      defaultCodes="<%=exchangeHomeDetailSO.getChildRacePref()%>"
			      name="cbxRace"
			      codesTableName="<%=CodesTables.CADRACE%>"
			      columns="2"
			      isHorizontal="true"
			      disabled="true"/>
			   	</td>
	  		</tr>
		</table>
		
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE6">
	  		<tr>
	        	<th colspan="4">Child Ethnicity Preferences</th>
	  		</tr>
	  		<tr class="subDetail">
		  		 <td>
			      <impact:codesCheckbox
			      defaultCodes="<%=exchangeHomeDetailSO.getChildEthnicityPerf()%>"
			      name="cbxEth"
			      codesTableName="<%=CodesTables.CINDETHN%>"
			      columns="3"
			      isHorizontal="true"
			      disabled="true"/>
			   	</td>
	  		</tr>
		</table>
		
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE7">
	  		<tr>
	        	<th colspan="4">Child Age/Gender Preferences</th>
	  		</tr>
	  		<tr class="subDetail">
	  			<td>
	  				<impact:validateInput type="text" label="Number Of children" name="txtNbrOfChldrn"
            		disabled="<%=isDisabled%>" cssClass="formInput" value="<%= FormattingHelper.formatInt((exchangeHomeDetailSO.getNumOfChildren() != null) ? exchangeHomeDetailSO.getNumOfChildren() : 0) %>" constraint="Numeric" size="3" maxLength ="3" tabIndex="<%=tabIndex++%>"/>
    			</td>
    		</tr>
    		<tr>
    		 <td colspan="4">
    		 	<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" id="TABLE8">
		 			<tr>
				    	<th colspan="4">Male Age Range</th>
				  	</tr>
				  	<tr class="subDetail">
				  		<td><impact:validateDisplayOnlyField name="txtMaleMinYear" label="Min Year" 
				  		    value="<%=FormattingHelper.formatString((exchangeHomeDetailSO.getMaleMinRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getMaleMinRangeInMonths()/12) : null)%>"/> 
				  		</td>
				  	    <td><impact:validateDisplayOnlyField name="txtMaleMinMonth" label="Min Month" 
				  	        value="<%=FormattingHelper.formatString((exchangeHomeDetailSO.getMaleMinRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getMaleMinRangeInMonths()%12) : null)%>"/>
				  	    </td>
				  	    <td><impact:validateDisplayOnlyField name="txtMaleMaxYear" label="Max Year" 
				  	    	value="<%=FormattingHelper.formatString((exchangeHomeDetailSO.getMaleMaxRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getMaleMaxRangeInMonths()/12) : null)%>"/>
				  	    </td>
				  	    <td><impact:validateDisplayOnlyField name="txtMaleMaxMonth" label="Max Month"
				  	    	value="<%=FormattingHelper.formatString((exchangeHomeDetailSO.getMaleMaxRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getMaleMaxRangeInMonths()%12) : null)%>"/>
				  	    </td>
				  	 </tr>
				</table>
    		 </td>
    		</tr>
    		<tr>
    		 <td colspan="4">
    		 	<table cellspacing="0" cellpadding="3" width="100%" class="tableBorder" id="TABLE9">
		 			<tr>
				    	<th colspan="4">Female Age Range</th>
				  	</tr>
				  	<tr class="subDetail">
				  		<td><impact:validateDisplayOnlyField name="txtFemaleMinYear" label="Min Year" 
				  		    value="<%=FormattingHelper.formatString((exchangeHomeDetailSO.getFemaleMinRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getFemaleMinRangeInMonths()/12) : null)%>"/> 
				  		</td>
				  	    <td><impact:validateDisplayOnlyField name="txtFemaleMinMonth" label="Min Month" 
				  	        value="<%=FormattingHelper.formatString((exchangeHomeDetailSO.getFemaleMinRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getFemaleMinRangeInMonths()%12) : null)%>"/>
				  	    </td>
				  	    <td><impact:validateDisplayOnlyField name="txtFemaleMaxYear" label="Max Year" 
				  	    	value="<%=FormattingHelper.formatString((exchangeHomeDetailSO.getFemaleMaxRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getFemaleMaxRangeInMonths()/12) : null)%>"/>
				  	    </td>
				  	    <td><impact:validateDisplayOnlyField name="txtFemaleMaxMonth" label="Max Month"
				  	    	value="<%=FormattingHelper.formatString((exchangeHomeDetailSO.getFemaleMaxRangeInMonths() != null) ? String.valueOf(exchangeHomeDetailSO.getFemaleMaxRangeInMonths()%12) : null)%>"/>
				  	    </td>
				  	 </tr>
				</table>
    		 </td>
    		</tr>
    	 </table>	
    	 
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE10">
			<tr class="subDetail">
	        	<td>
			       <impact:validateTextArea 
			               name="txtHomePrefComments"
			               colspan="4"
			               label="Comments"
			               rows="4"
			               cols="110"
			               tabIndex="<%=tabIndex++%>"
			               disabled="<%=isDisabled%>"
			               maxLength="500"
			               constraint="Paragraph500">
			           <%=FormattingHelper.formatString(exchangeHomeDetailSO.getHomePrefComments())%>
			       </impact:validateTextArea>
			     </td>
	  		</tr>
		</table>
	</impact:ExpandableSectionTag>
<%-- End Home Preferences --%>
	<br>
<%-- Begin Home Availability --%>
	<impact:ExpandableSectionTag
		name="homeAvailability"
		label="Home Availability"
		tabIndex="<%=tabIndex++%>">
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE11">
			<tr class="subDetail">
			   	<td><impact:validateSelect name="selSzCdNonAvReasonHA" colspan="1" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getCdNonAvReasonHA())%>" required="false" codesTable="<%=CodesTables.CANONAV%>" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" label="Non-Availability Reason Code"/></td>
			   	<td><impact:validateDisplayOnlyField name="txtDateOut" label="Date Out" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDateOutHA())%>"/></td>
			   	<td><impact:validateDisplayOnlyField name="txtDaysOut" label="Days Out" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getNumDaysOutHA())%>"/></td>
			</tr>
	  		<tr class="subDetail">
	        	<td>
			       <impact:validateTextArea 
			               name="txtCommentsHA"
			               colspan="6"
			               label="Comments"
			               rows="3"
			               cols="110"
			               tabIndex="<%=tabIndex++%>"
			               disabled="<%=isDisabled%>"
			               maxLength="1000"
			               constraint="Paragraph1000">
			           <%=FormattingHelper.formatString(exchangeHomeDetailSO.getCommentsHA())%>
			       </impact:validateTextArea>
			     </td>
	  		</tr>
	  		<tr class="subDetail">
	        	<td>
			       <impact:validateTextArea 
			               name="txtFamilyIsLinkedHA"
			               colspan="6"
			               label="Family is Linked"
			               rows="3"
			               cols="110"
			               tabIndex="<%=tabIndex++%>"
			               disabled="<%=isDisabled%>"
			               maxLength="1000"
			               constraint="Paragraph1000">
			           <%=FormattingHelper.formatString(exchangeHomeDetailSO.getFamilyIsLinkedHA())%>
			       </impact:validateTextArea>
			     </td>
	  		</tr>
		</table>
		<impact:pagination
			submitUrl="/fad/ExchangeHomeDetail/displayExchangeHomeDetail">
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE12">
			<tr>
				<td>
					 <impact:ButtonTag
				       name="btnMatch"
				       img="btnMatch"
				       form="frmExchangeHomeDetail"
				       navAwayCk="true"
				       action="/fad/ExchangeHomeDetail/matchExchangeChildren"
				       restrictRepost="true" 
           			   preventDoubleClick="true" 
           			   function ="return checkSave();"
				       tabIndex="<%= tabIndex++ %>"/>
				</td>
			</tr>
			<tr>
	        	<th colspan="4">Family is Now Considering</th>
	  		</tr>
	  		<tr>
	  			<td>
	  				<div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
					  <table width="100%" cellspacing="0" cellpadding="3" border="0">
					    <tr>
					      <th class="thList">Unlink</th>
					      <th class="thList">Last Name</th>
					      <th class="thList">First Name</th>
					      <th class="thList">Non-Availability Reason Code<impact:sortableColumnHeader
								orderBy="<%=ExchangeHomeDetailConversation.SORT_BY_NON_AVAIL_RSN_CODE%>"
								isDefault="false" /></th>
					      <th class="thList">DOB</th>
					      <th class="thList">Gender</th>
					      <th class="thList">County</th>
					      <th class="thList">Date Out<impact:sortableColumnHeader
								orderBy="<%=ExchangeHomeDetailConversation.SORT_BY_DT_OUT%>"
								isDefault="true" /></th>
					    </tr>
						    <%
						    List childrenConsideringList = exchangeHomeDetailSO.getChildrenConsideringList();
						    if((childrenConsideringList != null) && (childrenConsideringList.size() > 0)) {
							  	Iterator itr = childrenConsideringList.iterator();
							  	int loopCount = 0;
							 	while (itr.hasNext()) {
							   		ExchangeHomeChildrenSO childConsidering = (ExchangeHomeChildrenSO) itr.next();
							   		String cbName = "cbLinked_" + loopCount;
							   		String childName = childConsidering.getLastName() + ", " + childConsidering.getFirstName();
							%>
							<tr class="<%= FormattingHelper.getRowCss(++loopCount) %>">
								<%
									if ("Y".equals(childConsidering.getLinkCurrent())) {
								%>
						    	<td>
		        					<impact:validateInput type="checkbox"
		                              name="<%=cbName%>"
		                              tabIndex="<%=tabIndex++%>"
		                              checked="<%=ArchitectureConstants.N%>"
		                              disabled="<%=isDisabled%>"
		                              value="<%= ArchitectureConstants.TRUE %>"/>
	     						 </td>
	     						 <%
									} else {
								 %>
								 	<td><nobr></nobr></td>
								 <%
									}
								 %>
	     						 <td>
							        <a href="javascript:navigateToPersonDetail('<%=childConsidering.getIdExchangeChildEvent()%>' , '<%=childConsidering.getIdChild()%>', '<%=childName%>')" 
							           onclick="setIsDirtyCalled(true)" 
							           tabIndex="<%=tabIndex++ %>">
							          <%=childConsidering.getLastName()%>
							        </a>
							     </td>
							     <td><nobr><%=FormattingHelper.formatString(childConsidering.getFirstName())%></nobr></td>
							     <td><nobr><%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CANONAV, childConsidering.getCdNonAviReasonCode()))%></nobr></td>
							     <td><nobr><%=FormattingHelper.formatDate(childConsidering.getDtDOB())%></nobr></td>
							     <td><nobr><%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CSEX, childConsidering.getCdGender()))%></nobr></td>
							     <td><nobr><%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, childConsidering.getCdCounty()))%></nobr></td>
							     <td><nobr><%=FormattingHelper.formatDate(childConsidering.getDtDateOut())%></nobr></td>
						    </tr>
						    <%
						  } //end while (itr.hasNext()
					  	} else {
					  		%>
					  			<tr class="odd"><td colspan="8">No Results Found</td></tr>
						    <%
					  	}
						%>
					   </table>
					 </div>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE11">
	  					<tr>
	  						<td><impact:validateSelect name="selSzCdNonAvReasonChild" colspan="1" value="<%=CodesTables.CANONAV_03%>" required="false" codesTable="<%=CodesTables.CANONAV%>" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" conditionallyRequired="true" label="Non-Availability Reason Code"/></td>
	  						<td><impact:validateDate label="Date Out" name="dateOutHA" type="text" value="<%=FormattingHelper.formatDate(new Date())%>" size="10" conditionallyRequired="false" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" constraint="Date" /></td>
	  						<td>
								 <impact:ButtonTag
							       name="btnLink"
							       img="btnLink"
							       form="frmExchangeHomeDetail"
							       restrictRepost="true" 
							       preventDoubleClick="true"
							       action="/fad/ExchangeHomeDetail/linkExchangeHomeDetail"
							       tabIndex="<%= tabIndex++ %>"/>
							</td>
	  						
	  					</tr>
	  					<tr>
	  						<td><impact:validateSelect name="selSzCdNonSelectionReasonChild" colspan="1" value="" required="false" codesTable="<%=CodesTables.CADNSLCT%>" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" conditionallyRequired="true" label="Non-Selection Reason Code"/></td>
							<td></td>
							<td></td>
							<td>
								 <impact:ButtonTag
							       name="btnUnlink"
							       img="btnUnlink"
							       form="frmExchangeHomeDetail"
							       restrictRepost="true" 
							       preventDoubleClick="true"
							       action="/fad/ExchangeHomeDetail/unLinkExchangeHomeDetail"
							       tabIndex="<%= tabIndex++ %>"/>
							</td>
	  					</tr>
	  					<tr>
	  						<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>
								 <impact:ButtonTag
							       name="btnDeleteNowConsidering"
							       img="btnDelete"
							       form="frmExchangeHomeDetail"
							       restrictRepost="true" 
							       preventDoubleClick="true"
							       action="/fad/ExchangeHomeDetail/deleteNowConsidering"
							       function ="return confirmDelete();"
							       tabIndex="<%= tabIndex++ %>"/>
							</td>
	  					</tr>
	  				</table>
	  			</td>
	  		</tr>
	  		<tr>
	        	<th colspan="4">Family Has Seen the Following Children</th>
	  		</tr>
	  		<tr>
	  			<td>
	  				<div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
					  <table width="100%" cellspacing="0" cellpadding="3" border="0">
					    <tr>
					      <th class="thList">&nbsp;</th>
					      <th class="thList">Last Name</th>
					      <th class="thList">First Name</th>
					      <th class="thList">Non-Availability Reason Code<impact:sortableColumnHeader
								orderBy="<%=ExchangeHomeDetailConversation.SORT_BY_NON_AVAIL_RSN_CODE%>"
								isDefault="false" /></th>
					      <th class="thList">Non-Selection Reason Code</th>
					      <th class="thList">DOB</th>
					      <th class="thList">Gender</th>
					      <th class="thList">County</th>
					      <th class="thList">Date Out<impact:sortableColumnHeader
								orderBy="<%=ExchangeHomeDetailConversation.SORT_BY_DT_OUT%>"
								isDefault="true" /></th>
					    </tr>
						    <%
						    List childrenNonSelectedList = exchangeHomeDetailSO.getChildrenNonSelectedList();
						    if((childrenNonSelectedList != null) && (childrenNonSelectedList.size() > 0)) {
							  	Iterator itr = childrenNonSelectedList.iterator();
							  	int loopCount = 0;
							 	while (itr.hasNext()) {
							   		ExchangeHomeChildrenSO childNonSelected = (ExchangeHomeChildrenSO) itr.next();
							   		String cbName = "cbUnlinkedLinked_" + loopCount;
							   		String childName = childNonSelected.getLastName() + ", " + childNonSelected.getFirstName();
							%>
						<tr class="<%= FormattingHelper.getRowCss(++loopCount) %>">
							
								<td>
		        					<impact:validateInput type="checkbox"
		                              name="<%=cbName%>"
		                              tabIndex="<%=tabIndex++%>"
		                              checked="<%=ArchitectureConstants.N%>"
		                              disabled="<%=isDisabled%>"
		                              value="<%= ArchitectureConstants.TRUE %>"/>
	     						 </td>
							
								 <td>
							        <a href="javascript:navigateToPersonDetail('<%=childNonSelected.getIdExchangeChildEvent()%>', '<%=childNonSelected.getIdChild()%>', '<%=childName%>')" 
							           onclick="setIsDirtyCalled(true)" 
							           tabIndex="<%=tabIndex++ %>">
							          <%=childNonSelected.getLastName()%>
							        </a>
							     </td>
							     <td><%=FormattingHelper.formatString(childNonSelected.getFirstName())%></td>
							     <td><%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CANONAV, childNonSelected.getCdNonAviReasonCode()))%></td>
							     <td><%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CADNSLCT, childNonSelected.getCdNonSelReasonCode()))%></td>
							     <td><nobr><%=FormattingHelper.formatDate(childNonSelected.getDtDOB())%></nobr></td>
							     <td><nobr><%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CSEX, childNonSelected.getCdGender()))%></nobr></td>
							     <td><%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, childNonSelected.getCdCounty()))%></td>
							     <td><nobr><%=FormattingHelper.formatDate(childNonSelected.getDtDateOut())%></nobr></td>
						    </tr>
						    <%
						  } //end while (itr.hasNext()
					  	} else {
					  		%>
					  			<tr class="subDetail"><td colspan="9">No Results Found</td></tr>
						    <%
					  	}
						%>
					   </table>
					 </div>
	  			</td>
	  		</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE16">
			<tr>
				<td class="alignRight">
					<impact:ButtonTag 
						name="btnDeleteHasConsidered" 
						align="right" 
						img="btnDelete"
						form="frmExchangeHomeDetail"
						action="/fad/ExchangeHomeDetail/deleteHasBeenConsidered"
						restrictRepost="true" 
						preventDoubleClick="true"
						function ="return confirmDelete();"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
		</table>
		 </impact:pagination>
    </impact:ExpandableSectionTag>
<%-- End Home Availability--%>
	<br>	
<%-- Begin Close Record --%>
	<impact:ExpandableSectionTag
		name="closeRecords"
		label="Close Records"
		tabIndex="<%=tabIndex++%>">
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE13">
	  		<tr>
	        	<th colspan="4">Closed No Placement</th>
	  		</tr>
		  	<tr class="subDetail">
		  		<td><impact:validateDate label="Date" name="dateClosedNP" type="text" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtClosedNP())%>" size="10" conditionallyRequired="false" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" constraint="Date" /></td>
	  			<td><impact:validateSelect name="selSzCdResaonClosed" colspan="1" value="<%= FormattingHelper.formatString(exchangeHomeDetailSO.getCdReasonClosed()) %>"  required="false" codesTable="<%=CodesTables.CADEXCLD%>" disabled="<%=isDisabled%>" tabIndex="<%=tabIndex++%>" conditionallyRequired="true" label="Reason Closed"/></td>
         		<td></td>
	  		</tr>
	  		<tr class="subDetail">
	        	<td>
			       <impact:validateTextArea 
			               name="txtExplanationNPComments"
			               colspan="4"
			               label="Explanation"
			               rows="4"
			               cols="110"
			               tabIndex="<%=tabIndex++%>"
			               disabled="<%=isDisabled%>"
			               maxLength="500"
			               constraint="Paragraph500">
			           <%=FormattingHelper.formatString(exchangeHomeDetailSO.getExplanationNPComments())%>
			       </impact:validateTextArea>
			     </td>
	  		</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE14">
	  		<tr>
	        	<th colspan="4">Closed With Placement</th>
	  		</tr>
	  		<tr class="subDetail">
		       	<td><impact:validateDisplayOnlyField name="txtChildrenPlacedCWP" label="Child(ren) Placed" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getChildrenPlacedCWP())%>"/></td>
		       	<td></td>
         		<td></td>
		    </tr>
	  		<tr class="subDetail">
		      	<td><impact:validateDisplayOnlyField name="txtDatePlacedCWP" label="Date Placed" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtPlacedCWP())%>"/></td>
		      	<td></td>
         		<td></td>
		    </tr>
	    <tr class="subDetail">
		       	<td><impact:validateDisplayOnlyField name="txtPermissionToFileCWP" label="Permission To File" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtPermFile())%>"/></td>
		    	<td></td>
         		<td></td>
		    </tr>
		    <tr class="subDetail">
		      	<td><impact:validateDisplayOnlyField name="txtDocSendDateCWP" label="Documents Sent Date" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtDocSendDateCWP())%>"/></td>
		    	<td></td>
         		<td></td>
		    </tr>
		    <tr class="subDetail">
		       	<td><impact:validateDisplayOnlyField name="txtCountyCWP" label="County" value="<%=Lookup.simpleDecodeSafe(CodesTables.CCOUNT, exchangeHomeDetailSO.getCdCountyCWP())%>"/></td>
		       	<td><impact:validateInput type="text" value="<%=FormattingHelper.formatString(exchangeHomeDetailSO.getAFileNumCWP())%>" disabled="<%=isDisabled%>" name="txtAFileNumCWP" label="Afile#"  tabIndex="<%=tabIndex++%>" maxLength="16" size="16"/></td>
		    </tr>
		    <tr class="subDetail">
		      	<td><impact:validateDisplayOnlyField name="txtDateFinalCWP" label="Date Final" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtFinalCWP())%>"/></td>
		    	<td></td>
         		<td></td>
		    </tr>
		    <tr class="subDetail">
		      	<td><impact:validateDisplayOnlyField name="txtDateFinalEnteredCWP" label="Date Final Entered" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtFinalEnteredCWP())%>"/></td>
		    	<td></td>
         		<td></td>
		    </tr>
		    <tr class="subDetail">
		       	<td><impact:validateDisplayOnlyField name="txtDisruptionCWP" label="Disruption" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtDisruptionCWP())%>"/></td>
		    	<td></td>
         		<td></td>
		    </tr>
		    <tr class="subDetail">
		       	<td><impact:validateDisplayOnlyField name="txtDissolutionCWP" label="Dissolution" value="<%=FormattingHelper.formatDate(exchangeHomeDetailSO.getDtDissolutionCWP())%>"/></td>
		    	<td></td>
         		<td></td>
		    </tr>
		    <tr class="subDetail">
	        	<td>
			       <impact:validateTextArea 
			               name="txtChildrenPlacedWithCommentCW"
			               colspan="4"
			               label="Children Placed with"
			               rows="4"
			               cols="110"
			               tabIndex="<%=tabIndex++%>"
			               disabled="<%=isDisabled%>"
			               maxLength="500"
			               constraint="Paragraph500">
			           <%=FormattingHelper.formatString(exchangeHomeDetailSO.getChildrenPlacedWithCommentCWP())%>
			       </impact:validateTextArea>
			     </td>
	  		</tr>
	  	</table>
	</impact:ExpandableSectionTag>
<%-- End Close Record --%>
	
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td colspan="4">
        <br>
        <hr>
      </td>
    </tr>
    <tr>
    <% if (!PageModeConstants.VIEW.equals(pageMode)) {%>
      <td class="alignRight">
        <impact:ButtonTag 
           name="btnSave" 
           align="right" 
           img="btnSave" 
           form="frmExchangeHomeDetail" 
           action="/fad/ExchangeHomeDetail/saveExchangeHomeDetail" 
           restrictRepost="true" 
           preventDoubleClick="true" 
           tabIndex="<%= tabIndex++ %>" />
      </td>
    <%}%>
    </tr>
  </table>
  <br>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />  
  <input type="hidden" name="<%=ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_EVENT%>"/>
  <input type="hidden" name="<%=ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_ID%>"/>
  <input type="hidden" name="<%=ExchangeHomeDetailConversation.SELECTED_EXCHANGE_CHILD_NAME%>"/>
  <input type="hidden" name="<%=ExchangeHomeDetailConversation.LINK_COUNT%>" value="<%=linkedCount%>" />
</impact:validateForm>