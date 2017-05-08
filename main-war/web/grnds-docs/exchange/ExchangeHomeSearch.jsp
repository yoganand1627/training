<%--
JSP Name:     ExchangeHomeSearch.jsp
Date Created: 03/27/08

Change History:
Date      User              Description
--------  ----------------  ----------------------------------------------
07/01/08  mchillman         JSP creation
04/15/09  hjbaptiste        STGAP00012912 - Added the form attribute defaultButton='true' to execute the search 
                            when the enter button is pressed
09/23/09  cwells            STGAP00013114 - Added correct form name to Search button widget to remove jsp error
							which was causing inconsistent results when searching                              
04/11/12  kpressl           STGAP00018067 - Removed tag references to regions 16 and 17 for regional drop-downs                 
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeHomeSearchConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeHomeValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeHomeSearchDao"%>


<%@ page import="java.util.Collection"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.SortedMap"%>
<%@ page import="java.util.TreeMap" %> 


<%
  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );  
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  Object results = null;
  
  String formName = "frmExchangeHomeSearch";
  
  SortedMap years = new TreeMap();
  if (state.getAttribute("yearsrange", request) != null) {
  	years = (SortedMap) state.getAttribute("yearsrange", request);
  }
  SortedMap months = new TreeMap();
  if (state.getAttribute("monthsrange", request) != null) {
   months = (SortedMap) state.getAttribute("monthsrange", request);
  }
 
  Collection yearOptions = years.values();
  Collection monthOptions = months.values();
  
  ExchangeHomeValueBean homeSearchValueBean = (ExchangeHomeValueBean)request.getAttribute(ExchangeHomeSearchConversation.EXCHANGE_HOME_SEARCH_BEAN);
  
  int numberOfResources = 0;
  List<ExchangeHomeValueBean> exchangeHomeList = null;
  
  if (request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME) != null) {
  	results = request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);
  }
  
  if (request.getAttribute(ExchangeHomeSearchConversation.EXCHANGE_HOME_LIST) != null) {
    exchangeHomeList = ((PaginationResultBean) results).getResults();
  }
  
  boolean pullBackMode = false;
  String sPullBackMode = (String) state.getAttribute("pullBackMode", request);
  if (ArchitectureConstants.TRUE.equals(sPullBackMode)) {
    pullBackMode = true;
  }  
  
  String resultsPerPageName = DatabaseResultDetails.RESULTS_PER_PAGE_NAME;
  String resultsPerPage = new Integer(ExchangeHomeSearchConversation.SEARCH_RESULTS_PER_PAGE).toString();
  // STGAP00012764: Exclude these two types of statuses when performing a search
  List excludeStatus = new ArrayList();
  excludeStatus.add(CodesTables.CFAHMSTA_PTA); // Hide Pending Temporary Approval
  excludeStatus.add(CodesTables.CFAHMSTA_ATA); // Hide Approved (Temp) - Active
%>

<script language="JavaScript">

window.attachEvent('onload', myOnLoadFunction );

function myOnLoadFunction() {
  if (document.getElementById("exchangeHomSearchResults")) {
  	document.getElementById("exchangeHomSearchResults").focus();
  }
}


function navigateToExchangeHomeDetail( indexNum ) {
  <%= formName %>.indexNum.value = indexNum;
  submitValidateForm( "<%= formName %>", "/exchange/ExchangeHomeSearch/displayExchangeHomeDetail" );
}

function navigateToHomeInformation( indexNum ) {
  <%= formName %>.indexNum.value = indexNum;
  submitValidateForm( "<%= formName %>", "/exchange/ExchangeHomeSearch/displayHomeInformationDetail" );
}

function checkIfSelected(numberOfRows) {
  var bCB= false;
  for ( i = 0; i < numberOfRows ; i++ ) {
  	var listCb = document.getElementById("cbContinue_" + i);
    bCB = listCb.checked;
    if ( bCB ) {
     break;
    }
  }
  if ( !bCB )  {
    alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION)%>');
  }
  return bCB
}

  //STGAP00018067 - Removed references to regions 16 and 17
  //Get county code/decode array with all data
  <impact:codeArray codeName="CCOUNT" arrayName="CCOUNT" blankValue="true"/>
  //Get county code/decode array filtered for region 01
  <impact:codeArray codeName="CCOUNT01" arrayName="CCOUNT01" blankValue="true"/>
  //Get county code/decode array filtered for region 02
  <impact:codeArray codeName="CCOUNT02" arrayName="CCOUNT02" blankValue="true"/>
  //Get county code/decode array filtered for region 03
  <impact:codeArray codeName="CCOUNT03" arrayName="CCOUNT03" blankValue="true"/>  
  //Get county code/decode array filtered for region 04
  <impact:codeArray codeName="CCOUNT04" arrayName="CCOUNT04" blankValue="true"/>
  //Get county code/decode array filtered for region 05
  <impact:codeArray codeName="CCOUNT05" arrayName="CCOUNT05" blankValue="true"/>
  //Get county code/decode array filtered for region 06
  <impact:codeArray codeName="CCOUNT06" arrayName="CCOUNT06" blankValue="true"/>
  //Get county code/decode array filtered for region 07
  <impact:codeArray codeName="CCOUNT07" arrayName="CCOUNT07" blankValue="true"/>
  //Get county code/decode array filtered for region 08
  <impact:codeArray codeName="CCOUNT08" arrayName="CCOUNT08" blankValue="true"/>
  //Get county code/decode array filtered for region 09
  <impact:codeArray codeName="CCOUNT09" arrayName="CCOUNT09" blankValue="true"/>
  //Get county code/decode array filtered for region 10
  <impact:codeArray codeName="CCOUNT10" arrayName="CCOUNT10" blankValue="true"/>
  //Get county code/decode array filtered for region 11
  <impact:codeArray codeName="CCOUNT11" arrayName="CCOUNT11" blankValue="true"/>
  //Get county code/decode array filtered for region 12
  <impact:codeArray codeName="CCOUNT12" arrayName="CCOUNT12" blankValue="true"/>
  //Get county code/decode array filtered for region 13
  <impact:codeArray codeName="CCOUNT13" arrayName="CCOUNT13" blankValue="true"/>
  //Get county code/decode array filtered for region 14
  <impact:codeArray codeName="CCOUNT14" arrayName="CCOUNT14" blankValue="true"/>
  //Get county code/decode array filtered for region 15
  <impact:codeArray codeName="CCOUNT15" arrayName="CCOUNT15" blankValue="true"/>
  //Get county code/decode array filtered for region 98
  <impact:codeArray codeName="CCOUNT" arrayName="CCOUNT98" blankValue="true"/>

function populateCounty(onPageLoad) {
  if ( <%=formName%>.selSzCdRsrcRegion.value == <%= CodesTables.CCOUNT_099 %> ||
       <%=formName%>.selSzCdRsrcRegion.value == "") {
    clearDropdown ( <%=formName%>.selSzCdRsrcCnty );
  } else {
    var dropdownValue = "";
    populateDropdown(<%=formName%>.selSzCdRsrcCnty, dropdownValue, eval("CCOUNT"+<%=formName%>.selSzCdRsrcRegion.value) );
  }
}

</script>

<impact:validateErrors formName="frmExchangeHomeSearch" />
<impact:validateForm name="frmExchangeHomeSearch" 
    defaultButton="true"
	action="/exchange/ExchangeHomeSearch/searchExchangeHome"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeHomeSearchCustomValidation"
	pageMode="<%=pageMode%>"
	schema="/WEB-INF/Constraints.xsd">
	
	<impact:validateInput type="hidden" name="indexNum" editableMode="<%=EditableMode.EDIT%>" />
	
	<%-- Begin Home Locate --%>
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE1">
	  <tr>
	        <th colspan="4">Home Locate</th>
	  </tr>
	  <tr>
	  	<td class="formInstruct" colspan="4">
	  		Enter Search Criteria to find an Exchange Home if a Resource ID is entered the search will use only the identification number to find a match
	  	</td>
	  </tr>
	  <tr>
      	<td><impact:validateInput type="text" disabled="false" name="txtHomeName" label="Home Name" value="<%=FormattingHelper.formatString(homeSearchValueBean.getHomeName())%>" tabIndex="<%=tabIndex++%>" maxLength="30" size="20" conditionallyRequired="true"/></td>
      	<td><impact:validateInput type="text" disabled="false" name="txtResourceId" label="Resource Id" value="<%=FormattingHelper.formatInt((homeSearchValueBean.getIdResource() != null) ? homeSearchValueBean.getIdResource() : 0)%>" tabIndex="<%=tabIndex++%>" maxLength="16" size="16" constraint="Digit16Less" conditionallyRequired="true"/></td>
      </tr>
      <tr>
      	<td>
        	<impact:validateSelect name="selSzCdRsrcFaHomeStatus" label="Status" required="false" excludeOptions="<%=excludeStatus%>" codesTable="<%=CodesTables.CFAHMSTA%>" value="<%=FormattingHelper.formatString(homeSearchValueBean.getCdStatus())%>" tabIndex="<%=tabIndex++%>" disabled="false"/>
      	</td>
      	<td>
        	<impact:validateSelect name="selSzCdRsrcCategory" label="Category" conditionallyRequired="true" codesTable="<%=CodesTables.CFACATEG%>" value="<%=FormattingHelper.formatString(homeSearchValueBean.getCdCategory())%>" tabIndex="<%=tabIndex++%>" disabled="false"/>
      	</td>
      </tr>
      <tr>
      	<td>
        	<impact:validateSelect name="selSzCdRsrcRegion" label="Region" conditionallyRequired="true" codesTable="<%=CodesTables.CREGIONS%>" value="<%=FormattingHelper.formatString(homeSearchValueBean.getCdRegion())%>" onChange="populateCounty(false)" tabIndex="<%=tabIndex++%>" />
      	</td>
      	<td>
        	<impact:validateSelect name="selSzCdRsrcCnty" label="County" required="false" codesTable="<%=CodesTables.CCOUNT%>" value="<%=FormattingHelper.formatString(homeSearchValueBean.getCdCounty())%>" style="width: 150px" tabIndex="<%=tabIndex++%>" />
      	</td>
      </tr>
      <tr>
      	<td>
        	<impact:validateInput type="text" value="<%=homeSearchValueBean.getAgencyCode()%>" disabled="false" name="txtAgencyCode" label="Agency Code"  tabIndex="<%=tabIndex++%>" maxLength="30" size="20" />
      	</td>
      	<td>
        	<impact:validateSelect name="selSzAgecy" label="Agency" codesTable="" value="<%=FormattingHelper.formatString(homeSearchValueBean.getAgency())%>" codesTable="<%=CodesTables.CADOAGEN%>" tabIndex="<%=tabIndex++%>" disabled="false"/>
      	</td>
      </tr>
      <tr>
      	<td>
      		<impact:validateDate label="Inquiry Date" name="dtInquiry" type="text" value="<%=FormattingHelper.formatDate(homeSearchValueBean.getDtInquired())%>" size="10" conditionallyRequired="false" disabled="false" tabIndex="<%=tabIndex++%>" constraint="Date" />
      	</td>
      	<td>
      		<impact:validateInput type="text" label="Number of Children Approved For" name="txtNbrOfChldrn" disabled="false" cssClass="formInput" value="<%=FormattingHelper.formatInt((homeSearchValueBean.getNumOfChildren() != null) ? homeSearchValueBean.getNumOfChildren() : 0)%>" constraint="Numeric" size="3" maxLength ="3" tabIndex="<%=tabIndex++%>"/>
        </td>
      </tr>
   	</table>
<%-- End Home Locate  --%>
	<br>
<%-- Begin Non-Avail Codes  --%>
	<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE2">
	  <tr>
	        <th colspan="4">Non-Avail Codes</th>
	  </tr>
	  <tr class="subDetail">
		  		 <td>
			      <impact:codesCheckbox
			      name="cbNonAvailCodes"
			      defaultCodes="<%=homeSearchValueBean.getLstCdNonAvaCodes()%>"
			      codesTableName="<%=CodesTables.CANONAV%>"
			      columns="4"
			      isHorizontal="true"
			      disabled="flase"/>
			   	</td>
	  	</tr>
	</table>
<%-- Non-Avail Codes --%>
	<br>
<%-- Begin Search Child Needs --%>
	<impact:ExpandableSectionTag
		name="searchChildNeeds"
		label="Search Child Needs"
		tabIndex="<%=tabIndex++%>">
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE4">
	  		<tr>
	        	<th colspan="4">Special Needs Characteristics </th>
	  		</tr>
	  		<tr class="subDetail">
		  		<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_01)%>" tabIndex="<%= tabIndex++ %>" 
						checked="<%= (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndMentalRetardation())) ? "true" : "false" %>" value="Y"
						name="cbxMentalRetardation" disabled="false" cssClass="formInput" />
				</td>
				<td>
					<impact:validateSelect name="selSzCdMentalRetardation" colspan="1" value="<%= FormattingHelper.formatString(homeSearchValueBean.getCdLevelMentalRetardation()) %>" required="false" codesTable="<%=CodesTables.CADSEVER%>" disabled="false" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					<b> Background Factors</b>
				</td>
			</tr>
			<tr class="subDetail">
		  		<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_02)%>" tabIndex="<%= tabIndex++ %>" 
						checked="<%= (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndVisualHearingImpairments())) ? "true" : "false" %>" value="Y"
						name="cbxVisualHearingImpairments" disabled="false" cssClass="formInput" />
				</td>
				<td>
					<impact:validateSelect name="selSzCdVisualHearingImpairments" colspan="1" value="<%= FormattingHelper.formatString(homeSearchValueBean.getCdLevelVisualHearingImpairments()) %>" required="false" codesTable="<%=CodesTables.CADSEVER%>" disabled="false" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_06)%>" tabIndex="<%= tabIndex++ %>" 
						checked="<%= (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndFamilyHxofDrugsAlcohol())) ? "true" : "false" %>" value="Y"
						name="cbxFamilyHxofDrugsAlcohol" disabled="false" cssClass="formInput" />
				</td>
			</tr>
			<tr class="subDetail">
		  		<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_03)%>" tabIndex="<%= tabIndex++ %>" 
						checked="<%= (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndPhysicallyDisabled())) ? "true" : "false" %>" value="Y"
						name="cbxPhysicallyDisabled" disabled="false" cssClass="formInput" />
				</td>
				<td>
					<impact:validateSelect name="selSzCdPhysicallyDisabled" colspan="1" value="<%= FormattingHelper.formatString(homeSearchValueBean.getCdLevelPhysicallyDisabled()) %>" required="false" codesTable="<%=CodesTables.CADSEVER%>" disabled="false" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_07)%>" tabIndex="<%= tabIndex++ %>" 
						checked="<%= (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndFamilyHxofMentalIllness())) ? "true" : "false" %>" value="Y"
						name="cbxFamilyHxofMentalIllness" disabled="false" cssClass="formInput" />
				</td>
			</tr>
			<tr class="subDetail">
		  		<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_04)%>" tabIndex="<%= tabIndex++ %>" 
						checked="<%= (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndEmotionallyDisturbed())) ? "true" : "false" %>" value="Y"
						name="cbxEmotionallyDisturbed" disabled="false" cssClass="formInput" />
				</td>
				<td>
					<impact:validateSelect name="selSzCdEmotionallyDisturbed" colspan="1" value="<%= FormattingHelper.formatString(homeSearchValueBean.getCdLevelEmotionallyDisturbed()) %>" required="false" codesTable="<%=CodesTables.CADSEVER%>" disabled="false" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_08)%>" tabIndex="<%= tabIndex++ %>" 
						checked="<%= (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndFamilyHxofMR())) ? "true" : "false" %>" value="Y"
						name="cbxFamilyHxofMR" disabled="false" cssClass="formInput" />
				</td>
			</tr>
			<tr class="subDetail">
		  		<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_05)%>" tabIndex="<%= tabIndex++ %>" 
						checked="<%= (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndOtherMedicalDiagnoses())) ? "true" : "false" %>" value="Y"
						name="cbxOtherMedicalDiagnoses" disabled="false" cssClass="formInput" />
				</td>
				<td>
					<impact:validateSelect name="selSzCdOtherMedicalDiagnoses" colspan="1" value="<%= FormattingHelper.formatString(homeSearchValueBean.getCdlevelOtherMedicalDiagnoses()) %>" required="false" codesTable="<%=CodesTables.CADSEVER%>" disabled="false" tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					<impact:validateInput type="checkbox" label="<%=Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_09)%>" tabIndex="<%= tabIndex++ %>" 
						checked="<%= (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndChilsHxofSexualAbuse())) ? "true" : "false" %>" value="Y"
						name="cbxChilsHxofSexualAbuse" disabled="false" cssClass="formInput" />
				</td>
			</tr>
		</table>
		
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE5">
	  		<tr>
	        	<th colspan="4">Child Race</th>
	  		</tr>
		  	<tr class="subDetail">
		  		 <td>
			      <impact:codesCheckbox
			      name="cbxRace"
			      defaultCodes="<%=homeSearchValueBean.getChildRacePref()%>"
			      codesTableName="<%=CodesTables.CADRACE%>"
			      columns="2"
			      isHorizontal="true"
			      disabled="false"
			      />
			   	</td>
	  		</tr>
		</table>
		
		<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" id="TABLE6">
	  		<tr>
	        	<th colspan="4">Child Ethnicity</th>
	  		</tr>
	  		<tr class="subDetail">
		  		 <td>
			      <impact:codesCheckbox
			      name="cbxEth"
			      defaultCodes="<%=homeSearchValueBean.getChildEthnicityPerf()%>"
			      codesTableName="<%=CodesTables.CINDETHN%>"
			      columns="3"
			      isHorizontal="true"
			      disabled="false"/>
			   	</td>
	  		</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
  			<tr>
    			<th colspan="8">Child Demographics</th>
  			</tr>
  			<tr class="subDetail">
  				<td>
					<impact:validateSelect name="selSzCdGender" label="Gender" colspan="1" value="<%= FormattingHelper.formatString(homeSearchValueBean.getCdGender()) %>" required="false" codesTable="<%=CodesTables.CRSRCSEX%>" disabled="false" tabIndex="<%=tabIndex++%>" />
				</td>
				<td colspan="6"/>
  			</tr>
  			<tr class="subDetail">
	            <td><impact:validateSelect
	               tabIndex="<%=tabIndex++%>"
				   value=""
	               name="selMinYear"
	               label="Min Year"
	               options="<%=yearOptions%>"
	               disabled="false"
	               value="<%=FormattingHelper.formatString((homeSearchValueBean.getMinRangeInMonths() != null) ? String.valueOf(homeSearchValueBean.getMinRangeInMonths()/12) : null)%>"
	               />
	            </td>
	            <td><impact:validateSelect
	               tabIndex="<%=tabIndex++%>"
	               value=""
	               name="selMinMonth"
	               label="Min Month"
	               options="<%=monthOptions%>"
	               disabled="false"
	               value="<%=FormattingHelper.formatString((homeSearchValueBean.getMinRangeInMonths() != null) ? String.valueOf(homeSearchValueBean.getMinRangeInMonths()%12) : null)%>"
	               />
	            </td>
	            <td><impact:validateSelect
	               tabIndex="<%=tabIndex++%>"
	               value=""
	               name="selMaxYear"
	               label="Max Year"
	               options="<%= yearOptions %>"
	               disabled="false"
	               value="<%=FormattingHelper.formatString((homeSearchValueBean.getMaxRangeInMonths() != null) ? String.valueOf(homeSearchValueBean.getMaxRangeInMonths()/12) : null)%>"
	               />
	            </td>
	            <td><impact:validateSelect
	               tabIndex="<%=tabIndex++%>"
	               value=""
	               name="selMaxMonth"
	               label="Max Month"
	               options="<%=monthOptions%>"
	               disabled="false"
	               value="<%=FormattingHelper.formatString((homeSearchValueBean.getMaxRangeInMonths() != null) ? String.valueOf(homeSearchValueBean.getMaxRangeInMonths()%12) : null)%>"
	               />
	            </td>
          	</tr>
  		</table>
	</impact:ExpandableSectionTag>
<%-- End Search Child Needs --%>

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td colspan="4">
        <br>
        <hr>
      </td>
    </tr>
	
    <tr>
      <td class="alignRight">
        <impact:ButtonTag name="btnSearch"
	                        img="btnSearch"
	                        align="right"
	                        form="frmExchangeHomeSearch"
	                        action="/exchange/ExchangeHomeSearch/searchExchangeHome"
	                        tabIndex="<%= tabIndex++ %>"
	                        backSafe="true"/>
      </td>
    </tr>
   </table>
  <br>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />  
</impact:validateForm>

<%--
**********************************************
**** FORM (Home Result) STARTS HERE ****
**********************************************
--%>

<impact:validateForm name="frmExchangeHomeResult" method="post" action="/exchange/ExchangeHomeSearch/searchExchangeHome" pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd">
  <impact:validateInput type="hidden" name="indexNum" editableMode="<%=EditableMode.EDIT%>" />
  <%--
************************
**** SEARCH RESULTS ****
************************
--%>
  <%PaginationResultBean pPaginationResultBean = (PaginationResultBean) request
                                                                                 .getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);
      if (pPaginationResultBean != null) {
        DatabaseResultDetails db = pPaginationResultBean.getResultDetails();
      }
      if (!FormValidation.pageHasErrorMessages(request)
          && !FormValidation.pageHasValidationMessages("frmExchangeHomeResult", request)) {
        if (ExchangeHomeSearchConversation.SEARCH_PAGE.equals(ContextHelper.getPreviousUrl(request))
            || ExchangeHomeSearchConversation.DISPLAY_SEARCH_PAGE.equals(ContextHelper.getPreviousUrl(request))
            || pullBackMode == true) {
            
          %>

  <impact:pagination submitUrl="<%=ExchangeHomeSearchConversation.SEARCH_PAGE%>">
	<input type="hidden"  name="requestFromListPage" value="ExchangeHomeSearch"/>
    <table width="100%" cellpading="0" cellspacing="0" border="0">
 		<tr>
 		 <td class="alignRight"><div class="formInstruct">Scroll for more information  --></div></td>
		</tr>
	</table>
	  <div id="exchangeHomSearchResults" style="height:200px; width:765px; overflow:auto" class="tableborderList">
      <table border="0" cellpadding="3" cellspacing="0" width="100%" id="TABLEEXHR">
        <%
           ExchangeHomeValueBean homeRow = null;
           int iLoopCounter = 0;
           if (exchangeHomeList == null || exchangeHomeList.isEmpty()) {
        %>
        <tr class="thList">
          <th class="thList">&nbsp;</th>
          <th class="thList">Resource Name</th>
          <th class="thList">Category</th>
          <th class="thList">Availability Code</th>
          <th class="thList">County</th>
          <th class="thList">Agency</th>
          <th class="thList">FA Home Status</th>
          <th class="thList">Date Out</th>
        </tr>
        <tr class="tableBG">
          <td colspan="9" class="subDetail">
            <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
          </td>
        </tr>
        <%} else {
        %>
        <tr class="thList">
          <th class="thList">&nbsp;</th>
          <th class="thList">Resource Name<impact:sortableColumnHeader orderBy="cr.NM_RESOURCE"/></th>
          <th class="thList">Category<impact:sortableColumnHeader orderBy="cr.CD_RSRC_CATEGORY"/></th>
          <th class="thList">Availability Code<impact:sortableColumnHeader orderBy="exh.CD_NON_AVAIL_STATUS"/></th>
          <th class="thList">County<impact:sortableColumnHeader orderBy="cr.CD_RSRC_CNTY"/></th>
          <th class="thList">Agency<impact:sortableColumnHeader orderBy="cr.NDFCS_CERT_ENTITY"/></th>
          <th class="thList">FA Home Status<impact:sortableColumnHeader orderBy="cr.CD_RSRC_FA_HOME_STATUS"/></th>
          <th class="thList">Date Out<impact:sortableColumnHeader orderBy="exh.DT_OUT"/></th>
        </tr>
        <%
        		numberOfResources = exchangeHomeList.size();
        		int rowCount = 0;
        		for (rowCount = 0; rowCount < numberOfResources; rowCount++) {
            		ExchangeHomeValueBean exchangeHome = exchangeHomeList.get(rowCount);
            		String cbName = "cbContinue_" + rowCount;
         %>
        	<tr class="<%= FormattingHelper.getRowCss(rowCount + 1)%>">
         <%
         			if(pullBackMode) { 
         			%>
         			<td><impact:validateInput type="checkbox"
         			    id="homeCheckBox" 
         			    name="<%=cbName%>" 
         			    value="<%= "" + rowCount%>" 
         			    cssClass="rowCount" 
         			    tabIndex="<%= tabIndex++ %>"/>
         			</td>
         			<%
         			} else {
         			%>
         				<td><nobr></nobr></td>
         			<%
         			}
         %>
         
	          <td>
	          	<% if(pullBackMode) { %>
	          	  <%=FormattingHelper.formatString(exchangeHome.getHomeName())%>
	          	<% }else { %>
		        <a href="javascript:navigateToExchangeHomeDetail('<%=rowCount%>')" tabIndex="<%=tabIndex++ %>">
		          <%=FormattingHelper.formatString(exchangeHome.getHomeName())%>
		        </a>
		        <% } %>
		      </td>
								     
	          <td>
	            <%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CFACATEG, exchangeHome.getCdCategory()))%>
	          </td>
	          <td>
	            <%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CANONAV, exchangeHome.getCdNonAvaCode()))%>
	          </td>
	          <td>
	            <%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, exchangeHome.getCdCounty()))%>
	          </td>
	          <td>
	            <%=FormattingHelper.formatString(exchangeHome.getAgency())%>
	          </td>
	          <td>
	            <% if(pullBackMode) { %>
	            	<%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, exchangeHome.getCdFAHomeStatus()))%>
	            <% }else { %>
			        <a href="javascript:navigateToHomeInformation('<%=rowCount%>')" tabIndex="<%=tabIndex++ %>">
			          <%=FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, exchangeHome.getCdFAHomeStatus()))%>
			        </a>
		       <% } %>
		      </td>
		      <td>
	            <%=FormattingHelper.formatDate(exchangeHome.getDateOut())%>
	          </td>
	        </tr>
	        <%}
          }

          %>
          
      </table>
    </div>
  </impact:pagination>
  <% String functionContinue = "disableValidation('frmExchangeHomeResult'); return checkIfSelected( "
	                                      + numberOfResources + ");"; %>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
  <input type="hidden" name="<%=resultsPerPageName%>" value="<%=resultsPerPage%>"/>

  <%  if( pullBackMode && numberOfResources != 0  ){%> 
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td class="alignRight">
        <impact:ButtonTag name="btnContinue" img="btnContinue" function="<%=functionContinue%>" form="frmExchangeHomeResult" action="/exchange/ExchangeHomeSearch/pullBackExchangeHomeDetail" editableMode="<%= EditableMode.EDIT %>" tabIndex="<%=tabIndex++%>"/>
      </td>
    </tr>
  </table>
  <%  }
    }
   }
  %>
</impact:validateForm>

<script type="text/javascript" language="JavaScript1.2">
  populateCounty(true);
</script>