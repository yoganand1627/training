
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="java.util.List" %>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%
  // Initialize tabIndex
  int tabIndex = 1;
  String disableTxtOther = "false";
  // Get the serialized request
  String serializedRequestString = (String) request.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  //Get the SO object
  RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = (RetrieveVendorStaffDetailSO)request.getAttribute("retrieveVendorStaffDetailSO");
  String idVendor = StringHelper.EMPTY_STRING;
  List resourceIDList = retrieveVendorStaffDetailSO.getResourceList();
%>
<script type="text/javascript" language="JavaScript1.2">
  window.onload = function ()
  {
   	enableDisableTxtOther();
  };
  function enableDisableTxtOther()
  {
    var cdReqTyp = document.frmVndrStaffDtl.selReqType.value;
    if ( cdReqTyp == "<%=CodesTables.CUSRTYP_PUS%>" ) {
      document.frmVndrStaffDtl.txtOther.value='';
      document.frmVndrStaffDtl.txtOther.disabled=true;
    }else if (cdReqTyp == "<%=CodesTables.CUSRTYP_PAD%>") {
      document.frmVndrStaffDtl.txtOther.disabled=false;    
    }
  }
  function getResource(){
    var selRsrc = document.frmVndrStaffDtl.selVendor.value;
    var selNewRsrcNm = "<%= StringHelper.EMPTY_STRING %>";
    var selNewRsrcId = "<%= StringHelper.EMPTY_STRING %>";
    if (selRsrc.length > 0){
    	var commaLocation = selRsrc.search(",");
    	if (commaLocation > 0){
    		selNewRsrcNm = selRsrc.substring(commaLocation+1);
    		selNewRsrcId = selRsrc.substring(0,commaLocation);
    	}
    }
	document.frmVndrStaffDtl.hdnDisplayRsrcId.value = selNewRsrcId;
  }  
</script>
<impact:validateErrors formName="vndrStaffDtl"/>
<impact:validateForm name="frmVndrStaffDtl" method="post" defaultButton="true" action="/login/Login/saveVendorStaffDetail"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.common.RegistrationCustomValidation"
                     schema="/WEB-INF/Constraints.xsd" pageMode="<%= PageModeConstants.CREATE %>"
                     redisplayParameters="true">
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
  <input type="hidden" name="hdnFormInformation" value="<%= request.getParameter( "hdnFormInformation" ) %>"/>
  <input type="hidden" name="<%= AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY %>"
         value="<%= FormattingHelper.formatString( serializedRequestString )%>">                     
<table border="0"  cellpadding="3" cellspacing="0" align="center">
	<tr>
	  <td>                   
		  <table border="0" cellpadding="3" cellspacing="0" class="tableBorder" align="center">
		  	<tr>
		    	<th colspan="6">Basic Data</th>
		  	</tr>
		     <tr>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
		                                            name="txtFirstName"
		                                            label="First Name" size="12" maxLength="12" required="true" 
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
		                                            name="txtMiddleInitial"
		                                            label="Middle Initial" size="2" maxLength="1"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
		                                            name="txtLastName"
		                                            label="Last Name" size="22" maxLength="22"  required="true"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
		                                            name="txtTitle"
		                                            label="Title" size="20" maxLength="20"  required="true"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Email"
		                                            name="txtEmail"
		                                            label="Email" size="50" maxLength="320"  required="true"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Phone"
		                                            name="txtPhoneNumber"
		                                            label="Phone Number" size="15" maxLength="15" required="true" 
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="PhoneExtension"
		                                            name="txtPhoneExtension"
		                                            label="Ext" size="8" maxLength="8"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Address"
		                                            name="txtAddress1"
		                                            label="Office Address" size="30" maxLength="30" required="true" 
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>
		       <td></td>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Address2"
		                                            name="txtAddress2"
		                                            size="30" maxLength="30"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>                                            
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="City"
		                                            name="txtCity"
		                                            label="City" size="20" maxLength="20"  required="true"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		       <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
		                                            name="selState"
		                                            label="State"
		                                            codesTable="CSTATE"
		                                            required="true"
		                                            value="GA"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
		     </tr>
		     <tr>                                            
		       <td>
		       	<impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Zip"
		                                            name="txtZip"
		                                            label="Zip" size="5" maxLength="5"  required="true"
		                                            editableMode="<%=EditableMode.ALL %>"/>
		       	&nbsp;&nbsp; - &nbsp;&nbsp;
		       	<impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="ZipSuff"
		                                            name="txtZipSuff"
		                                            size="4" maxLength="4"
		                                            editableMode="<%=EditableMode.ALL %>"/>
		       </td>
		       <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
		                                            name="selCounty"
		                                            label="County"
		                                            codesTable="CCOUNT"
		                                            required="true"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>       
		     </tr> 
		  </table>
	  </td>
	</tr>
	<tr>
	  <td>
		  <table border="0" cellpadding="3" cellspacing="0" class="tableBorder" align="center">
		    <tr>
		    	<th colspan="2">Access Request</th>
		  	</tr>
		    <tr>
		     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
		                                            name="selReqType"
		                                            label="Request Type"
		                                            codesTable="CUSRTYP"
		                                            required="true"
		                                            editableMode="<%=EditableMode.ALL %>"
		                                            onChange="enableDisableTxtOther();"/></td>
		    </tr>
			  <tr>    
			    <td><impact:validateSelect
			                               style="WIDTH: 160px"
			                               label="Vendor"
			                               name="selVendor"
			                               style="WIDTH: 240px"
			                               overrideDisplayBadCodes="true"
			                               conditionallyRequired="true"
			                               value="<%=FormattingHelper.formatString(idVendor)%>"
			                               tabIndex="<%= tabIndex++ %>"
			                               editableMode="<%= EditableMode.ALL %>"
				                           onChange="getResource();"			                               
			                               disabled="false"
			                               options="<%=resourceIDList%>"/>
			    </td>    
			  </tr>		
		    <tr>
		     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Address"
		                                            name="txtOther"
		                                            label="Other" size="30" maxLength="30"
		                                            conditionallyRequired="true"
		                                            editableMode="<%=EditableMode.ALL %>"
		                                            disabled="<%=disableTxtOther %>"/></td>
		    </tr>
		    <tr>
		     <td colspan=2>
		     	If you work for multiple resources under an umbrella organization, please submit a registration for access to one resource first. Your administrator will then be able to link you to multiple resources.
		     </td>
		     </tr>     
		  </table>
	  </td>
	</tr>
	<tr>
	  <td>  
		  <table border="0" cellpadding="3" width="100%" cellspacing="0" class="tableBorder" align="center">
		    <tr>
		    	<th colspan="2">User Agreement</th>
		  	</tr>
		    <tr>
		     <td align="left">
		        By clicking on the checkbox below, the user agrees to abide by all state and federal laws, rules, and regulations, and the Department of Human Services policy on respecting the confidentiality of an individual's records.  These citations include, but are not limited to, O.C.G.A Sections 49-4-14, 49-5-40, 49-5-41, 50-18-72, and 45 CFR 205.5.  The user understands that all records concerning children placed in the custody of the Department of Human Services or all individuals who are the subject of or are included in a child protective services investigation are made confidential by O.C.G.A  Section 49-5-40 and may not be released to anyone except in compliance with O.C.G.A Section 49-5-41.  The user also understands that information concerning recipients of TANF, Food Stamps, and Medicaid may only be disclosed pursuant to O.C.G.A Section 49-4-14.
		     </td>
		    </tr>
		    <tr>
		     <td>
		        <impact:validateInput
		              tabIndex="<%= tabIndex++ %>"
		              label="I accept the agreement"
		              type="checkbox"
		              id="idUsrAgrmnt"
		              name="cbxUsrAgrmnt"
		              required="true"
		              editableMode="<%=EditableMode.ALL %>"/>
		     </td>
		    </tr>             
		  </table>
	  </td>
	</tr>
	
	<tr>
	  <td>  
		  <table border="0" cellpadding="3" width="100%" cellspacing="0" class="tableBorder" align="center">
		    <tr>
		    	<th colspan="3">Password</th>
		  	</tr>	
	        <tr>
            	<td width="120"><impact:validateInput 	type="password" 
            											tabIndex="<%=tabIndex++%>"
                                                 		colspan="2" 
                                                 		name="txtNewPassword" 
                                                 		label="New Password" 
                                                 		required="true" 
                                                 		maxLength="20"/></td>
          	</tr>
          	<tr>
            	<td width="120"><impact:validateInput 	type="password" 
            											tabIndex="<%=tabIndex++%>"
                                                 		colspan="2" 
                                                 		name="txtNewPasswordConfirm" 
                                                 		label="Re-Enter New Password" 
                                                 		required="true" 
                                                 		maxLength="20"/></td>
          	</tr>
		  </table>
	  </td>
	</tr>
	
	
	<tr>
	  <td>  
		  <table border="0" cellpadding="3" width="100%" cellspacing="0" class="tableBorder" align="left">
		    <tr>
		    	<th colspan="6">Security Questions</th>
		  	</tr>
		    <tr>
		     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
		                                            name="selSecQues1"
		                                            codesTable="CSECQUES"
		                                            required="true"
		                                            label ="Question 1"
		                                            editableMode="<%=EditableMode.ALL %>"/>
		     </td>
		     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>"
		                                            name="txtSecAns1"
		                                            size="30" maxLength="30"
		                                            required="true"
		                                            label ="Answer 1"
		                                            editableMode="<%=EditableMode.ALL %>"/>
		     </td>
		    </tr>
		    <tr>
		     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
		                                            name="selSecQues2"
		                                            codesTable="CSECQUES"
		                                            required="true"
		                                            label ="Question 2"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>"
		                                            name="txtSecAns2"
		                                            size="30" maxLength="30"
		                                            required="true"
		                                            label ="Answer 2"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
		    </tr>
		    <tr>
		     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
		                                            name="selSecQues3"
		                                            codesTable="CSECQUES"
		                                            required="true"
		                                            label ="Question 3"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>"
		                                            name="txtSecAns3"
		                                            size="30" maxLength="30"
		                                            required="true"
		                                            label ="Answer 3"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
		    </tr>                     
		  </table>
	  </td>
	</tr>
	<tr>      
	  <td>
		  <table border="0" cellpadding="3" cellspacing="0" align="left">
		  	<tr>
		  		<td></td>
		  		<td width="100%">
		  			<impact:ButtonTag name="Submit" img="btnSubmit" align="right" form="frmVndrStaffDtl" 
		  							action="/login/Login/saveVendorStaffDetail"
		                            tabIndex="<%=tabIndex++%>"/>
		  		</td>
		  	</tr>
		  </table>
	  </td>
	</tr>
</table>
  <impact:validateInput type="hidden" name="hdnDisplayRsrcId" value="<%= StringHelper.EMPTY_STRING %>" />
</impact:validateForm>

<script type="text/javascript" language="JavaScript1.2">
  document.frmVndrStaffDtl.txtFirstName.focus();
</script>