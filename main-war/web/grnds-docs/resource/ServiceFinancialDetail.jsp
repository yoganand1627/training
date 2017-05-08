<%
/**
 * JSP Name:     ServiceFinancialDetail.jsp
 * Created by:   Hong-Van Vo
 * Date Created: 09/19/11
 *
 * Description:
 * This page allows a user to add multiple financial services by area.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  09/19/11  htvo              STGAP00017019:ECEM 5.0: initial file creation
  
  
  
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ServicesByAreaConversation"%>

<% 
  UserProfile userProfile = UserProfileHelper.getUserProfile(request);
  // to see the All Regions option
  boolean isFiscalOpsStateMtnt = userProfile.hasRight(UserProfile.SEC_UPDATE_CONTRACT_PERIOD);

  String szCdRsrcSvcRegion = "";
  String checkedCIndRsrcSvcIncomeBsed = "false";
  String szFinSvcCodeArray = "";
  String szFinCountyCodeArray = "";
  List<String> excludeOutOfStateOption = new ArrayList<String>();
  int tabIndex = 1;

  List<String> defaultCodeService = null;
  List<String> defaultCodeCounty = null;
  String szSelectAllServices = "";
  String szDeSelectAllServices = "";

  // Retains user selection from request on page reload     
  String szCdRsrcSvcCategRsrc = ContextHelper.getStringSafe(request, "selSzCdRsrcSvcCategRsrc");      
  szFinSvcCodeArray = "CSVCCODE" + szCdRsrcSvcCategRsrc;
    
  szCdRsrcSvcRegion = ContextHelper.getStringSafe(request, "selSzCdRsrcSvcRegion");
  szFinCountyCodeArray = "CCOUNT" + szCdRsrcSvcRegion;

  if (StringHelper.isTrue(ContextHelper.getStringSafe(request, "cbxCIndRsrcSvcIncomeBsed")))
    checkedCIndRsrcSvcIncomeBsed = "true";

  // If Region selection changed, retain Service section settings 
  if (StringHelper.isTrue(ContextHelper.getStringSafe(request, "hdnRegionChanged")))
  {
    szSelectAllServices = ContextHelper.getStringSafe(request, "cbxSelectAllServices");
    szDeSelectAllServices = ContextHelper.getStringSafe(request, "cbxDeSelectAllServices");
    defaultCodeService = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxService"));
  }
  
  // Exclude All Regions option
  if (!isFiscalOpsStateMtnt)
  	excludeOutOfStateOption.add(ServicesByAreaConversation.ALL_REGIONS);
  
  if (StringHelper.isTrue(ContextHelper.getStringSafe(request, "bSaveAttempted")) ) {
 
    boolean bStandardValidationInProgress = "".equals(szCdRsrcSvcCategRsrc) || "".equals(szCdRsrcSvcRegion);

	String[] countyChecks = CheckboxHelper.getCheckedValues(request, "cbxCounty");
	String[] serviceChecks = CheckboxHelper.getCheckedValues(request, "cbxService");

	boolean noServiceSelected = serviceChecks == null || serviceChecks.length == 0;
	boolean noCountySelected = countyChecks == null || countyChecks.length == 0;
    
    // Custom validation
    if (!bStandardValidationInProgress && (noCountySelected || noServiceSelected)) { 
    %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
	<tr>
		<td colspan="2">
			<hr>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<span class="formErrorText"><%= MessageLookup.getMessageByName( "MSG_RA_NOT_COMPLETE") %></span>
			<br>
		</td>
	</tr>
	<%
		    
		    if (noServiceSelected) {
		    %>
	<tr>
		<td width="7%">
			&nbsp;
		</td>
		<td>
			<li>
				<a href="#Service">Service</a><span class="formErrorText"><%= " - " + MessageLookup.getMessageByName( "MSG_REQ_SRVC") %></span>
			</li>
		</td>
	</tr>
	<%
		    }
		    
		    if (noCountySelected) {
		    %>
	<tr>
		<td width="7%">
			&nbsp;
		</td>
		<td>
			<li>
				<a href="#ServiceArea">Service Area</a><span class="formErrorText"><%= " - " + MessageLookup.getMessageByName( "MSG_REQ_CNTY_MIN")  %></span>
			</li>
		</td>
	</tr>
	<%
		    }
			%>
	<tr>
		<td colspan="2">
			<hr>
		</td>
	</tr>
</table>
<%
    }
  }
  %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

  window.attachEvent('onbeforeunload', setDirty );
  function setDirty() {
    IsDirty();
  }

  /* 
    1. Set focus at Service Area if page reloads for region selection
    2. Default all services selected if page reloads with UAS Program changed/selected
  */
  window.onload = function() {
  	if (document.frmServiceDetail.hdnLocation.value != '') {
      location.href= document.frmServiceDetail.hdnLocation.value;
  	  document.frmServiceDetail.hdnLocation.value = '';
  	}

  	if (document.frmServiceDetail.hdnUASProgramChanged.value == 'true') {
  	  if (document.frmServiceDetail.selSzCdRsrcSvcCategRsrc.value != '') {
  	    selectAllServices(true);
  	    document.frmServiceDetail.cbxSelectAllServices.checked = true;
  	  }

  	  document.frmServiceDetail.hdnUASProgramChanged.value = 'false';
  	}
  };


/* Test element exists
*/ 

function isValidObj(obj){
  if (obj == null || obj == undefined)
    return false;

  return true;
}

/* This function is called by onClick of Service Type General to go to the General screen
*/
function goToGenServiceDetail( item ) {
  document.frmServiceDetail.selSzCdRsrcSvcCategRsrc.value= '';
  if (isValidObj(document.frmServiceDetail.selSzCdRsrcSvcRegion))
    document.frmServiceDetail.selSzCdRsrcSvcRegion.value = '';
  
  document.frmServiceDetail.SzCdServiceType.value= item;
  disableValidation('frmServiceDetail');
  submitValidateForm( 'frmServiceDetail', '/resource/ServicesByArea/addGenServiceDetail');
}

/* This function is called by onClick of UAS Program to reload the page and display the service
   belong to the selected program
*/
function onChangeUASProgram() {
  document.frmServiceDetail.hdnUASProgramChanged.value = 'true';	
  disableValidation('frmServiceDetail');
  submitValidateForm( 'frmServiceDetail', '/resource/ServicesByArea/addFinServiceDetail');
}

/* This function is called by onClick of Region to reload the page and display the counties
   in the selected region
*/
function onChangeRegion(region) {
  document.frmServiceDetail.hdnRegionChanged.value = 'true';	
  document.frmServiceDetail.hdnLocation.value = '#ServiceArea';
  disableValidation('frmServiceDetail');
  submitValidateForm( 'frmServiceDetail', '/resource/ServicesByArea/addFinServiceDetail');
}

/* This function is called by onClick of Select All or Deselect All cbx. 
   Select All will check all services and clear the Deselect All cbx.
   Deselect All will clear all services and the Select All cbx
*/
function selectAllServices(checked) {
  var numOfCheckboxes = <%= Lookup.getCategoryCollection(szFinSvcCodeArray).size() %>;
  var checkboxField;
  for ( i = 1; i <= numOfCheckboxes; i++ ) {
    checkboxField = eval("document.frmServiceDetail.cbxService" + i);
    if(checkboxField.checked != checked)
      checkboxField.checked = checked;
  }
  
  if (checked)
  	document.frmServiceDetail.cbxDeSelectAllServices.checked = false;
  else
  	document.frmServiceDetail.cbxSelectAllServices.checked = false;
}

/* This function is called by onClick of any of the service checkboxes to clear the Select All
   and De-Select All cbx
*/
function clearDeSelectService() {
  document.frmServiceDetail.cbxSelectAllServices.checked = false;
  document.frmServiceDetail.cbxDeSelectAllServices.checked = false;
}

/* This function is called by onClick of the Select All to set all service cbx
*/
function selectAllCounties(regionNum, numOfCheckboxes, checked) {
  var checkboxField;

  for ( i = 1; i <= numOfCheckboxes; i++ )
  {
    checkboxField = eval("document.frmServiceDetail.cbxCounty" + regionNum + i);
    if (checkboxField.checked != checked) {
      checkboxField.checked = checked;
    }
  }
  
  if (checked) {
    checkboxField = eval("document.frmServiceDetail.cbxDeselectAllCounties" + regionNum);
    checkboxField.checked = false;
  }
  else {
    checkboxField = eval("document.frmServiceDetail.cbxSelectAllCounties" + regionNum);
    checkboxField.checked = false;
  }

}

/* This function is called by onClick of any of the county checkboxes to clear the Select All
   and De-Select All cbx in the appropriate region
*/
function clearDeSelectCounty(regionNum) {
  var checkboxField;

  checkboxField = eval("document.frmServiceDetail.cbxSelectAllCounties" + regionNum);
  checkboxField.checked = false;

  checkboxField = eval("document.frmServiceDetail.cbxDeselectAllCounties" + regionNum);
  checkboxField.checked = false;

}
/* This function is called by onClick of the Save btn to confirm user selection and action
*/
function saveFinService() {

  var confirmMessage = "";
  var abandon = false;
  var bRegionWide = false;
  var checkboxField;
  var regionNum ;
  var numOfCheckboxes;
  var numCountiesSelected;
  var region = document.frmServiceDetail.selSzCdRsrcSvcRegion;  
  // To determine if user has selected all counties in the region or all regions, to set the bRegionWide 
  // and to display the warning message
  if (isValidObj(region) && (region.value != '')) {
  if (document.frmServiceDetail.selSzCdRsrcSvcRegion.value == '95') { // all regions selected
	for ( j = 1; j <= 17; j++) {
	  numCountiesSelected = 0;
      regionNum = (j < 10) ? "0" + j : "" + j;
	  numOfCheckboxes = eval("document.frmServiceDetail.hdnCbxCounty" + regionNum + ".value");
	  for ( i = 1; i <= numOfCheckboxes; i++ ) {
	    checkboxField = eval("document.frmServiceDetail.cbxCounty" + regionNum + i);
	    if (checkboxField.checked == true) {
	      numCountiesSelected++;
	    }
	  }
	  if (numCountiesSelected == numOfCheckboxes) {
	    bRegionWide = true;
	    break;
	  }
	}
  }
  else {  // single region
	  regionNum = document.frmServiceDetail.selSzCdRsrcSvcRegion.value;
	  numOfCheckboxes = eval("document.frmServiceDetail.hdnCbxCounty" + regionNum + ".value");
	  numCountiesSelected = 0;

	  for ( i = 1; i <= numOfCheckboxes; i++ ) {
	    checkboxField = eval("document.frmServiceDetail.cbxCounty" + regionNum + i);
	    if (checkboxField.checked == true) {
	      numCountiesSelected++;
	    }
	  }
	  if (numCountiesSelected == numOfCheckboxes)
	    bRegionWide = true;
  }
  }

  // we need to make sure the user know what they're getting into...
  if (bRegionWide) {
	  confirmMessage = "You are about to add a region row. This will delete ";
	  confirmMessage = confirmMessage + "any already existing similar county ";
	  confirmMessage = confirmMessage + "rows. This will also ";
	  confirmMessage = confirmMessage + "delete the client characterisitics for ";
	  confirmMessage = confirmMessage + "those pre-existing rows. Are you sure you ";
	  confirmMessage = confirmMessage + "want to do this?";
	
	  if (!confirm(confirmMessage))
	  {
	    abandon = true;
	  }
  }
    
  if (!abandon)  // proceed with saving and additional confirmation
  {
	  confirm('<%= MessageLookup.getMessageByName( "MSG_UPDT_VERIF")%>');
	  document.frmServiceDetail.bSaveAttempted.value = "true";
  }
   
  return !abandon;
}


</script>

<impact:validateForm name="frmServiceDetail" method="post"
	action="/resource/ServicesByArea/default"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.ServiceFinancialCustomValidation"
	schema="/WEB-INF/Constraints.xsd"
	pageMode="<%= PageModeConstants.EDIT %>">

	<impact:validateErrors formName="frmServiceDetail" />

	<!-- retain this value for General Service screen  -->
	<input type="hidden" name="txtUlIdResourceService" value="0" />

	<!-- retain this value for General Service screen  -->
	<input type="hidden" name="SzCdScrDataAction"
		value='<%= ContextHelper.getStringSafe(request, "SzCdScrDataAction") %>' />

	<!-- retain this value for General Service screen  -->
	<input type="hidden" name="SzCdServiceType" value='' />

	<!-- new values for this screen -->
	<input type="hidden" name="hdnLocation"
		value='<%= ContextHelper.getStringSafe(request, "hdnLocation") %>' />

	<input type="hidden" name="hdnRegionChanged" value='false' />

	<input type="hidden" name="hdnUASProgramChanged"
		value=<%= ContextHelper.getStringSafe(request, "hdnUASProgramChanged") %> />

	<input type="hidden" name="bSaveAttempted" value="false" />

	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="4">
				Services by Area Information
			</th>
		</tr>
		<tr colspan="4">
			<td>
				<impact:validateDisplayOnlyField name="servicType"
					label="Service Type" />
				<impact:validateInput name="rbServiceType" cssClass="formInput"
					type="radio" value="G" checked="false"
					onClick="goToGenServiceDetail('G');" tabIndex="<%= tabIndex++ %>" />
				General

				<impact:validateInput name="rbServiceType" cssClass="formInput"
					type="radio" value="F" checked="true" tabIndex="<%= tabIndex++ %>" />
				Financial
			</td>
		</tr>

		<tr>
			<th colspan="4">
				Financial Services by Area
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateSelect label="UAS Program"
					name="selSzCdRsrcSvcCategRsrc" codesTable="CPRGCODE"
					value="<%= FormattingHelper.formatString(szCdRsrcSvcCategRsrc) %>"
					required="true" onChange="onChangeUASProgram()"
					tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>

		<%
		// UAS Program Code selected
		if (StringHelper.isValid(szCdRsrcSvcCategRsrc))	{
		%>
		<tr>
			<th colspan="4">
				<a name="Service"> Service 
			</th>
		</tr>
		<tr>
			<td colspan="4">
				<div id="serviceDiv"
					style="height: 250px; width: 762px; overflow-y: auto; overflow-x: hidden"
					class="tableBorder">
					<table width="750" cellspacing="0" cellpadding="3">
						<tr>
							<td>
								<span class="formRequiredText">*</span> Service:
							</td>
						</tr>
						<tr>
							<td width="20%">
								<impact:validateInput label="Select All"
									name="cbxSelectAllServices" type="checkbox"
									value="<%=ArchitectureConstants.Y %>"
									checked="<%= szSelectAllServices %>"
									onClick="JavaScript:selectAllServices(true);"
									tabIndex="<%= tabIndex++ %>" />
							</td>
							<td width="20%">
								<impact:validateInput label="De-Select All"
									name="cbxDeSelectAllServices" type="checkbox"
									value="<%=ArchitectureConstants.Y %>"
									checked="<%= szDeSelectAllServices %>"
									onClick="JavaScript:selectAllServices(false);"
									tabIndex="<%= tabIndex++ %>" />
							</td>
							<td colspan="2">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<impact:codesCheckbox name="cbxService" columns="2"
									codesTableName="<%= szFinSvcCodeArray %>"
									defaultCodes="<%= defaultCodeService %>"
									onClick="clearDeSelectService()" tabIndex="<%= tabIndex++ %>" />
							</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
		<tr>
			<th colspan="4">
				<a name="ServiceArea"> Service Area </a>
			</th>
		</tr>
		<tr>
			<td colspan="4">
				<div id="serviceAreaDiv"
					style="height: 300px; width: 762px; overflow-y: auto; overflow-x: hidden"
					class="tableBorder">
					<table width="750" cellspacing="0" cellpadding="3">
						<tr>
							<td>
								<impact:validateSelect label="State" name="selSzCdRsrcSvcState"
									value="GA" required="true" disabled="true"
									tabIndex="<%= tabIndex++ %>" />
							</td>
							<td>
								<impact:validateSelect label="Program"
									name="selSzCdRsrcSvcProgram" codesTable="CRSCPROG"
									required="false" disabled="true" tabIndex="<%= tabIndex++ %>" />
							</td>
						</tr>
						<tr>
							<td>
								<impact:validateSelect label="Region"
									name="selSzCdRsrcSvcRegion" codesTable="CSVCRGNS"
									excludeOptions="<%= excludeOutOfStateOption %>"
									blankValue="true"
									value="<%= FormattingHelper.formatString(szCdRsrcSvcRegion) %>"
									required="true" onChange="onChangeRegion(this.value)"
									tabIndex="<%= tabIndex++ %>" />
							</td>
							<td>
								<impact:validateInput label="Income Based"
									name="cbxCIndRsrcSvcIncomeBsed" type="checkbox"
									checked="<%= checkedCIndRsrcSvcIncomeBsed %>"
									tabIndex="<%= tabIndex++ %>" />
							</td>
						</tr>

						<%
						// Region Code selected
						if (StringHelper.isValid(szCdRsrcSvcRegion)) {
							int numRegions = 1;
							String regionHeader = "";
							int numOfCheckboxes = 0;
							boolean allRegions = false;
							String cdRegion = "";
							
							if (ServicesByAreaConversation.ALL_REGIONS.equals(szCdRsrcSvcRegion)) {
							    //STGAP00017735: Modified to set numRegions as REGION_INDEX map size.
								numRegions = ServicesByAreaConversation.REGION_INDEX.size();
								allRegions = true;
							}
						%>
						<tr>
							<td>
								<span class="formRequiredText">*</span> County:
							</td>
						</tr>
						<%
							for (int regionNum = 1; regionNum <= numRegions; regionNum++) { 
								if (allRegions)	{  // all Regions selected
									//STGAP00017735: Modified to get the region code from REGION_INDEX map instead of using regionNum value
								    cdRegion = ServicesByAreaConversation.REGION_INDEX.get(regionNum);
								    szFinCountyCodeArray = (String)ServicesByAreaConversation.REGION_COUNTY_MAP.get(cdRegion);
								    numOfCheckboxes = Lookup.getCategoryCollection(szFinCountyCodeArray).size();
								    //STGAP00017735: Modified to get the region name from REGION_MAP map
								    regionHeader = (String)ServicesByAreaConversation.REGION_MAP.get(cdRegion);
								}
								else {
								    //STGAP00017735: Modified to get the region name from REGION_MAP map
									regionHeader = (String)ServicesByAreaConversation.REGION_MAP.get(szCdRsrcSvcRegion);
									numOfCheckboxes = Lookup.getCategoryCollection(szFinCountyCodeArray).size();
									cdRegion = szCdRsrcSvcRegion;
								}

							    String sCbxSelectAllCounties = "cbxSelectAllCounties" + cdRegion;
							    String sCbxDeselectAllCounties = "cbxDeselectAllCounties" + cdRegion;
							    String sCbxCounty = "cbxCounty" + cdRegion;
							    String sHdnCbxCounty = "hdnCbxCounty" + cdRegion;

							    String onClickSelecAll = "Javascript:selectAllCounties(" + "'" + cdRegion + "'" 
							    														 + "," 
							    						 								 + numOfCheckboxes 
							    						 								 + "," 
							    						 								 + "true" 
							    						 								 + ");";
	
							    String onClickDeSelectAll = "Javascript:selectAllCounties(" + "'" + cdRegion + "'" 
							    															+ "," 
							    															+ numOfCheckboxes 
							    															+ "," 
							    															+ "false" 
							    															+ ");";
	
							    String onClickClearDeSelectCounty = "Javascript:clearDeSelectCounty(" + "'" + cdRegion + "'"  
							    															+ ");";
							%>
						<tr>
							<th colspan="4" style="border-top: solid #c8c699 1px;">
								&nbsp;&nbsp;&nbsp;<%= regionHeader %></th>
						</tr>
						<tr>
							<td width="20%">
								<impact:validateInput label="Select All Counties"
									name="<%= sCbxSelectAllCounties %>" type="checkbox"
									value="<%=ArchitectureConstants.Y %>" checked="false"
									onClick="<%= onClickSelecAll %>" tabIndex="<%= tabIndex++ %>" />
							</td>
							<td width="20%">
								<impact:validateInput label="De-Select All Counties"
									name="<%= sCbxDeselectAllCounties %>" type="checkbox"
									value="<%=ArchitectureConstants.Y %>" checked="false"
									onClick="<%= onClickDeSelectAll %>"
									tabIndex="<%= tabIndex++ %>" />
							</td>
							<td colspan="2">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<impact:codesCheckbox name="<%= sCbxCounty %>" columns="4"
									isHorizontal="true"
									codesTableName="<%= szFinCountyCodeArray %>"
									defaultCodes="<%= defaultCodeCounty %>"
									onClick="<%= onClickClearDeSelectCounty %>"
									tabIndex="<%= tabIndex++ %>" />
							</td>
							<input type="hidden" name="<%= sHdnCbxCounty %>"
								value="<%= numOfCheckboxes %>" />

						</tr>

						<%
							}
						} // END StringHelper.isValid(szCdRsrcSvcRegion))
						%>
					</table>
				</div>
			</td>
		</tr>
		<%
		}
		%>
	</table>

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td align="right">
				<impact:ButtonTag name="btnSave" img="btnSave" align="right"
					form="frmServiceDetail" editableMode="<%= EditableMode.EDIT %>"
					function="setIsDirtyCalled(true);return saveFinService();"
					action="/resource/ServicesByArea/saveFinServiceDetail"
					restrictRepost="true" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>

	<input type="hidden"
		name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>" />

</impact:validateForm>

