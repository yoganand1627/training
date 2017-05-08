<%/**
       * ContractServiceDetailAdd.jsp
       * Author: Corey Harden
       * Date: 10/11/2011
       * 
       * 					Change History
       *
       *   Date          User				              Description
       * ----------    ------------      -----------------------------------------------------------
       * 11/12/2011    htvo              STGAP00017671: displayed service desc with service code
       * 11/20/2011    htvo              STGAP00017678: changed display order for service code to top - bottom
       *
       *
       */%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Croleall"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Crelvict"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cchktype"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckPersonBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RecordsCheckSummarySO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveProgramCodeServicesSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON13SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Enumeration"%>

<%
	BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
	RetrieveProgramCodeServicesSO retrieveProgramCodeServicesSO = (RetrieveProgramCodeServicesSO) state.getAttribute("retrieveProgramCodeServicesSO", request);
	boolean displayProgCodeDropDown = retrieveProgramCodeServicesSO != null && retrieveProgramCodeServicesSO.getProgramCodesOptions()!= null && !retrieveProgramCodeServicesSO.getProgramCodesOptions().isEmpty() ? true : false;
	String programCode = (String) request.getAttribute("programCode");
	boolean isProgCodeAvail = programCode != null ? true : false;
	Object[] checkedValues = (Object[]) request.getAttribute("checkedValues");
	boolean isBatchTime = checkedValues != null ? true : false;
	boolean isPaginated = "Y".equals(request.getAttribute("isPaginated"));
	CCON13SO ccon13so = (CCON13SO) state.getAttribute("CCON13SO", request);
	String contractFunctionType = ContextHelper.getStringSafe(request, "hdnContractFunctionType");
	org.exolab.castor.types.Date countyEffective = DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEffective"));
    org.exolab.castor.types.Date countyEnd = DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(request, "hdndtDtCncntyEnd"));
	ROWCCON13SOG_ARRAY countyRows = null;
	int resourceId = ContextHelper.getIntSafe(request, "hdnUlIdResource");
	if(ccon13so != null){
		countyRows = ccon13so.getROWCCON13SOG_ARRAY();
	}
	int tabIndex= 1;
	
	// setup messages
 	String MSG_UPDT_VERIF = MessageLookup.getMessageByNumber(Messages.MSG_UPDT_VERIF);
 	String MSF_INFO_UPDT_SAVE = "Only counties chosen on Services By Area will be applied to the contract for the service(s) selected.";
%>



<!-- JAVASCRIPT SECTION -->
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/javascript" language="JavaScript1.2">
	var MSG_UPDT_VERIF = '<%= MSG_UPDT_VERIF %>';
	var MSF_INFO_UPDT_SAVE = '<%= MSF_INFO_UPDT_SAVE %>';

	window.attachEvent('onbeforeunload', setDirty );
  	function setDirty() {
    	IsDirty();
  	};
	
	function displayServices(elem){
		var val = elem.value;
		if(val != ''){
			document.getElementById('validateProgCode').value = 'Y';
  			submitValidateForm( 'frmContractServiceDetail', '/financials/Contracts/getBackgroundData');
		}	
	}
	

	function validateServiceSelection(){
		alert('alert');
	   submitValidateForm( 'frmContractServiceDetail', '/financials/Contracts/setServices');
	}
	
	function displaySaveMessage(){
		alert(MSF_INFO_UPDT_SAVE);
		return confirm(MSG_UPDT_VERIF);
	}
	
	
	/**
	* This function checks or unchecks all service code checkboxes
	* @param action - boolean which denotes whether to check or uncheck the checkboxes 
	*/
	function selectAllServices(action){
	   // get all inputs from page
	   var inputs = document.getElementsByTagName('input');
	   for(var i = 0; i < inputs.length; i++){
	   		// get the input and input  
	   		var input = inputs[i];
	   		var type = input.getAttribute('type');
	   		// check/uncheck all checkboxes
	   		if(type == 'checkbox'){
	   			if(input.checked != action){
	       			input.checked = action;
	       			input.fireEvent("onclick");
	        	}
	   		}
	   }
	}
		
</script>
<!-- END JAVASCRIPT SECTION -->



<!-- ERROR DISPLAY AREA -->
<impact:validateErrors />
<!-- END ERROR DISPLAY AREA -->




<!-- Begin Form -->
<impact:validateForm name="frmContractServiceDetail" method="post" action="/financials/Contracts/displayContractServiceDetail" validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractServiceDetailAddCustomValidation" pageMode="<%= "4" %>" schema="/WEB-INF/Constraints.xsd">
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
  <impact:validateInput type="hidden" name="hdnContractFunctionType" value="<%= FormattingHelper.formatString(contractFunctionType) %>"/>
  <impact:validateInput type="hidden" name="hdndtDtCncntyEffective" value="<%= FormattingHelper.formatDate(countyEffective) %>" />
  <impact:validateInput type="hidden" name="hdndtDtCncntyEnd" value="<%= FormattingHelper.formatDate(countyEnd) %>" />
  <impact:validateInput type="hidden" name="hdnUlIdResource" value="<%= "" + resourceId %>" />
	<% 
	if((displayProgCodeDropDown || isProgCodeAvail) && !isBatchTime){
	%>
	<!-- Begin Program Code Section -->
	<input type="hidden" name="validateProgCode" value="N" />
	<div id="programCode">
		<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
			<tr>
				<th colspan="4">
					Program Code
				</th>
			</tr>
			<tr height="50px">
				<td>
					<impact:validateSelect 
						tabIndex="<%= 1 %>" 
						label="Program Code" 
						options="<%= retrieveProgramCodeServicesSO.getProgramCodesOptions() %>"
						name="szProgCode"
						value="<%= FormattingHelper.formatString(programCode) %>"
						required="true"
						blankValue="true"
						onChange="displayServices(this)"
						disabled="<%= "false" %>" />
				</td>
			</tr>
		</table>
	</div>
	<%
	}
	
	if(isBatchTime){
	%>	
	<input type="hidden" name="hdnProgCode" value="<%= programCode %>" />
	<div id="programCodeDisabled">
		<table border="0" cellspacing="0" cellpadding="3" width="100%"
			class="tableborder">
			<tr>
				<th colspan="4">
					Program Code
				</th>
			</tr>
			<tr height="50px">
				<td>
					<span id="progCodeDisabled">
						Program Code: <%= Lookup.simpleDecodeSafe("CPRGCODE", programCode) %>
					</span>
				</td>
			</tr>
		</table>
	</div>
	<br>
	<!-- End Program Code Section -->
	<%
	}
	%>

	<%
	if(isProgCodeAvail && !isBatchTime) {
	  // STGAP00017671: display service desc with service code
	  String codeArray = "CSVCCODE"+programCode+programCode;	
	  Collection<String> codes =  Lookup.getCategoryCodesCollection(codeArray);
	  List defaultCodes = new ArrayList(codes.size());
	  defaultCodes.addAll(codes);
	%>
	<input type="hidden" name="validateServiceSelection" value="Y" />
	<!-- Begin Service Codes Section -->
	<table id="serviceCodes" border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
		<tr>
			<th colspan="4">
				Service Codes
			</th>
		</tr>
		<tr>
			<td>
				<div id="programCodeServices">
					<impact:codesCheckbox name="cbxProgCdServices" defaultCodes="<%= defaultCodes %>" codesTableName="<%= codeArray %>" columns="3"  />
				</div>
			</td>
		</tr>
	</table>
	<br>
	<!-- End Service Codes Section -->
	
	<!-- Begin Select/Deselect All Buttons -->
	<div id="selectAll">
		<table>
			<tr>
				<td width="600">&nbsp;</td>
				<td>
					<a onclick="JavaScript:selectAllServices(true);" >
        				<img src="/grnds-docs/images/shared/btnSelectAll.gif" style="cursor: pointer" />
      				</a>
      			</td>
				<td>
					<a onclick="JavaScript:selectAllServices(false);" >
        				<img src="/grnds-docs/images/shared/btnDeselectAll.gif" style="cursor: pointer" />
      				</a>
      			</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>
					<impact:ButtonTag name="btnSelect" img="btnSelect" align="right"
					form="frmContractServiceDetail"
					editableMode="<%= EditableMode.EDIT %>"
					action="/financials/Contracts/setServices"
					restrictRepost="true" tabIndex="<%=tabIndex++%>"  />
      			</td>
			</tr>
		</table>
	</div>
	<!-- End Select/Deselect All Buttons -->
	<% 
	}
	%>
	
	<% 
	if(isBatchTime){
	%>
	<!-- Begin Batch Services Section -->
	<div id="batchServices" style="width: 100%">
		<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
			<tr align="center"><th colspan="6">Service Codes</th></tr>
			<tr>
				<td><span class="formRequiredText">*</span><b>Service Code</b></td>
				<td><span class="formRequiredText">*</span><b>Unit Type</b></td>
				<td><span class="formRequiredText">*</span><b>Payment Type</b></td>
				<td><span class="formRequiredText">*</span><b>Unit Rate</b></td>
				<td><b>Federal Match</b></td>
				<td><b>State Match</b></td>
			</tr>
	<% 
		int i = 0;
		for(Object serviceCodeObj : checkedValues){
			String serviceCode = String.valueOf(serviceCodeObj);
			// STGAP00017671: display service desc with service code
			String codeArray = "CSVCCODE"+programCode+programCode;
			String codeDecode = Lookup.simpleDecodeSafe(codeArray, serviceCode);
	%>
		<tr>
			<td width="30%"><impact:validateInput value="<%= serviceCode %>" 
                            type="checkbox" 
                            checked="<%= "true" %>"  
                            name="<%= "cbxBatchProgCodeService" + i %>" 
                            cssClass="formInput"
                            tabIndex="<%= tabIndex++ %>"/><%= codeDecode %></td>
			<td><impact:validateSelect 
						tabIndex="<%= tabIndex++ %>" 
						name="<%= "szNbrCnsvcUnitType" + i %>" 
						value=""
						blankValue="true"
						codesTable="CCONUNIT" /></td>
			<td><impact:validateSelect 
						tabIndex="<%= tabIndex++ %>" 
						name="<%= "szNbrCnsvcPaymentType" + i %>" 
						value=""
						blankValue="true"
						codesTable="CCONPAY" /></td>
			<td><impact:validateInput value="" 
                            type="text"   
                            name="<%= "ulNbrCnsvcUnitRate"  + i %>" 
                            constraint="Money"
                            maxLength="10"
                            size="10"
                            tabIndex="<%= tabIndex++ %>"/></td>
			<td align="center"><impact:validateInput value="" 
                            type="text"   
                            name="<%= "ulNbrCnsvcFedMatch" + i %>" 
                            constraint="Digit3Less"
                            maxLength="3"
                            size="3"
                            tabIndex="<%= tabIndex++ %>"/></td>
			<td align="center"><impact:validateInput value="" 
                            type="text"   
                            name="<%= "ulNbrCnsvcLocalMatch" + i %>" 
                            constraint="Digit3Less"
                            maxLength="3"
                            size="3"
                            tabIndex="<%= tabIndex++ %>"/></td>
		</tr>
	<% 
			i++;
		}
	%>
		<input type="hidden" name="numRows" value="<%= i %>" />
		</table>
	</div>
	<!-- End Batch Services Section -->

	<!-- Begin County Section -->
	<div id="countySection">
		<br>
		<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
			<tr align="left">
				<td><b><u>County</u></b></td>
				<td><b><u>Code</u></b></td>
				</td><td width="150px"></td><td width="150px"></td><td width="150px"></td><td width="150px"></td>
			</tr>
	<% 
		if(countyRows != null){
			Enumeration e = countyRows.enumerateROWCCON13SOG();
			while(e.hasMoreElements()){
				ROWCCON13SOG county = (ROWCCON13SOG) e.nextElement();
				String countyCode = county.getSzCdCncntyCounty();
				if(countyCode != null){
	%>
			<tr>
			<td><%= Lookup.simpleDecodeSafe("CCOUNT", countyCode) %></td>
			<td><%= countyCode %></td>
			</td><td width="150px"></td><td width="150px"></td><td width="150px"></td><td width="150px"></td></tr>
	<% 
				}
			}
		}
	%>
			
		</table>
	</div>
	<!-- End County Section -->
	
	<% 
		if(!isPaginated){
	%>
	<!-- Begin Save Button -->
	<div id="saveBtn"">
		<table>
			<tr height="15px"><td>&nbsp;</td><td>&nbsp;</td></tr>
			<tr>
				<td width="700">&nbsp;</td>
				<td>
					<impact:ButtonTag name="btnSave" img="btnSave" align="right"
					form="frmContractServiceDetail"
					editableMode="<%= EditableMode.EDIT %>"
					function="return displaySaveMessage()"
					action="/financials/Contracts/saveContractServiceBatch"
					restrictRepost="true" tabIndex="<%=tabIndex++%>"  />
      			</td>
			</tr>
		</table>
	</div>
	<!-- End Save Button -->
	
	<% 
		}else{
	%>
	<!-- Begin Save Buttons -->
	<div id="saveAndSaveContinueBtns">
		<table>
			<tr height="15px"><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
			<tr>
				<td width="600">&nbsp;</td>
				<td>
					<impact:ButtonTag name="btnSaveAndContinue" img="btnSaveAndContinue" align="right"
					form="frmContractServiceDetail"
					editableMode="<%= EditableMode.EDIT %>"
					function="return displaySaveMessage()"
					action="/financials/Contracts/saveContractServiceBatch?continue=Y"
					restrictRepost="true" tabIndex="<%=tabIndex++%>"  />
      			</td>
				<td>
					<impact:ButtonTag name="btnSave" img="btnSave" align="right"
					form="frmContractServiceDetail"
					editableMode="<%= EditableMode.EDIT %>"
					function="return displaySaveMessage()"
					action="/financials/Contracts/saveContractServiceBatch"
					restrictRepost="true" tabIndex="<%=tabIndex++%>"  />
      			</td>
			</tr>
		</table>
	</div>
	<!-- End Save Buttons -->
	<% 
		}
	}
	%>

</impact:validateForm>




