
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%><%
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  ----------------------------------------------
//**  02/22/04  DEJUANR           SIR 23043 - If a user selected an address that was
//**                              in mulitple counties, the county list truncates.
//**                              But if they then change the city, and the new
//**                              city is not in those counties, the county list does not
//**                              refresh.  I had just add the county the new address
//**                              is in.
//** 03/01/05  Ochumd             SIR 23042 - SWI does not want the county to drop
//**                              off after a failed validation, because they then have
//**                              to re-enter the county which takes an extra step
//**                              for the user. Code added to the noOnValidate (useUnvalidated) function.
//** 10/13/06 aodutayo            SIR 600 - Street number is removed when user indicates
//**                              that he/she wants to continue to use the address even if
//**                              it is invalid. Also cleaned up the message displayed when
//**                              an address is invalid.
//** 10/26/06 abgoode             SIR 729 - Added thoroughfare to the first street input when
//**                              a validated address is found.  Also changed the Javascript
//**                              method names to make them more descriptive and took out the
//**                              call to updateParsedParent in useUnvalidated since the parsed
//**                              address is supposed to be the address originally entered.  And
//**                              if we want to use the address entered, why reset form values?
//**                              Just leave them untouched unless we are actually doing some
//**                              formatting in the conversation (which we are currently not).
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressValidationConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorListSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>

<%
  String sOriginatedWindow = ContextHelper.getStringSafe(request, AddressValidationConversation.ORIGINATING_FORM );
  String saveOrValidate = ContextHelper.getStringSafe(request, AddressBean.SAVE_OR_VALIDATE);
  String buttonName = ContextHelper.getStringSafe(request, "buttonClicked");
  
  AddressValidatorListSO addressListSO = (AddressValidatorListSO) request.getAttribute(AddressValidationConversation.ADDRESS_LIST);
  List<AddressValidatorSO> addressesList = (addressListSO != null && addressListSO.getVaildAddresses() != null) ? addressListSO.getVaildAddresses() : null;
  boolean addressValidated = (addressListSO != null) ? addressListSO.isInitialAddreessValid() : false;
  AddressValidatorSO validateAddress = (addressValidated == true) ? addressesList.get(0) : null;
  
  AddressValidatorSO addressRow = null;
  AddressValidatorSO parsedAddressRow = null;
  String itemselected = "";
 
  if(validateAddress != null) {
  	addressRow = validateAddress;
  } else {
  	addressRow = new AddressValidatorSO();
  }

  if ( request.getAttribute(AddressValidationConversation.PARSED_ADDRESS_ROW) != null )
  {
    parsedAddressRow =(AddressValidatorSO) request.getAttribute(AddressValidationConversation.PARSED_ADDRESS_ROW);
  }
  else
  {
    parsedAddressRow = new AddressValidatorSO();
  }


  boolean isSave = false;
  if ( ( saveOrValidate != null ) && "save".equals(saveOrValidate) )
  {
    isSave = true;
  }
  else
  {
    isSave = false;
  }


  String addressValidatedString = FormattingHelper.formatString( (String) request.getAttribute( AddressValidationConversation.ADDRESS_VALIDATED ) );
  //added latitude and longitued coordinates
  double nbrRsrcAddrLat = addressRow.getX();
  double nbrRsrcAddrLong = addressRow.getY();
  //-- SIR STGAP00000729
  //-- Added the thoroughfare to the first address string
  String addressLn1 = "";
  if(addressRow.getFormattedStreetAddress() != null && !"".equals(addressRow.getFormattedStreetAddress()))
  {
    addressLn1 = FormattingHelper.formatString(addressRow.getFormattedStreetAddress());
    addressLn1 = addressLn1.trim();
  }
  String addressLn2 = FormattingHelper.formatString(addressRow.getStreet2());
  String city = FormattingHelper.formatString(addressRow.getCity());
  String state = FormattingHelper.formatString(addressRow.getState());
  String validatedCountyCode = addressRow.getCountyCode();
  String county = Lookup.simpleDecodeSafe( CodesTables.CCOUNT, validatedCountyCode );
  String zip5 = FormattingHelper.formatString(addressRow.getZipCode());
  String zip = zip5;
  String zip4 = FormattingHelper.formatString(addressRow.getZip4());
  String addressSubmoduleName = (String) request.getAttribute( AddressBean.ADDRESS_SUBMODULE_NAME );
  
  //String code1error = FormattingHelper.formatString( ( String ) request.getAttribute( "code1error" ) );
  int code1ErrorCode = 0;
  if ( request.getAttribute( "code1ErrorCode" ) != null )
  {
    code1ErrorCode = (Integer) request.getAttribute("code1ErrorCode");
  }
  
  String validMessage = "";
  String continueMessage = "";
  String instructions = "";
  //If a valid address
  if ( addressValidated )
  {
    validMessage = "";//"This address has been validated.";
    if (isSave)
    {
      continueMessage = "Do you wish to save using this validated address?";
      instructions += "Press 'Yes' to save using this address.<br>";
      instructions += "Press 'No' to save using the unvalidated address.<br>";
      instructions += "Press 'Cancel' if you do not wish to save.<br>";
    }
    else
    {
      continueMessage = "Do you wish to use this validated address?";
      instructions += "Press 'Yes' to use this address.<br>";
      instructions += "Press 'No' to use the unvalidated address.<br>";
    }
  }
  else
  {
    //validMessage += "<li>" + code1error + "</li>";
    if ( isSave )
    {
      validMessage = "This address cannot be validated.&nbsp;&nbsp;Do you still wish to save using this address?";
      //continueMessage = "Do you still wish to save using this address?";
      //instructions += "Press 'Yes' to save using this address.<br>";
      instructions += "Press 'Yes' to save using the unvalidated address.<br>";
      instructions += "Press 'Cancel' if you do not wish to save.<br>";
    }
    else
    {
      if((addressesList != null && addressesList.size() > 0)) {
      	validMessage = "The address provided cannot be validated.&nbsp;<br>Do you wish to use one of the suggested address?<br>";
      } else {
      	 validMessage = "This address cannot be validated.<br>";
      }
      //continueMessage = "Do you still wish to use this address?";
      //instructions += "Press 'Yes' to use this address.<br>";
      //instructions += "Press 'No' to use the unvalidated address.<br>";
      //instructions += "Press 'Close' to close this window and make corrections to Address Detail and save, or save the address as entered.<br>";
      instructions += "Press 'Close' to close this window.&nbsp;&nbsp;You can then make corrections to the entered ";
      instructions += "address and attempt validation again, or you can just use the address as entered.<br>";
    }
  }

  List rtnCounties = new ArrayList();
  boolean bRtnCounties = false;
  if ( request.getAttribute( "returnedCounties" ) != null )
  {
    rtnCounties = (ArrayList) request.getAttribute( "returnedCounties" );
    bRtnCounties = true;
  }
%>

<script language="JavaScript1.2">
<% if ( bRtnCounties ) {%>
  <impact:codeArray options="<%=rtnCounties%>" arrayName="rtnCounties" blankValue="true"/>
<%} else { %>
  <impact:codeArray codeName="CCOUNT" arrayName="CCOUNT" blankValue="true"/>
<%}%>

var sugAddress1 = new Array();
var sugAddress2 = new Array();
var sugCity = new Array();
var sugCounty = new Array();
var sugZip = new Array();
var sugZip4 = new Array();
var sugState = new Array();
var sugAddrLat = new Array();
var sugAddLong = new Array();
<%
	 if (addressesList != null && addressesList.size() > 0) {
	 	int numberOfAddresses = addressesList.size();
        for (int rowCount = 0; rowCount < numberOfAddresses; rowCount++) {
            	AddressValidatorSO address = addressesList.get(rowCount);
%>
          		sugAddress1[<%=rowCount%>] = "<%= FormattingHelper.formatString(address.getFormattedStreetAddress()).toUpperCase()%>";
          		sugAddress2[<%=rowCount%>] = "<%= FormattingHelper.formatString(address.getStreet2()).toUpperCase()%>";
          		sugCity[<%=rowCount%>] = "<%= FormattingHelper.formatString(address.getCity()).toUpperCase()%>";
          		sugCounty[<%=rowCount%>] = "<%= FormattingHelper.formatString(address.getCountyCode())%>";
          		sugZip[<%=rowCount%>] = "<%= FormattingHelper.formatString(address.getZipCode())%>";
          		sugZip4[<%=rowCount%>] = "<%= FormattingHelper.formatString(address.getZip4())%>";
          		sugState[<%=rowCount%>] = "<%= FormattingHelper.formatString(address.getState())%>";
          		sugAddrLat[<%=rowCount%>] = "<%= FormattingHelper.formatDouble(address.getX())%>";
          		sugAddLong[<%=rowCount%>] = "<%= FormattingHelper.formatDouble(address.getY())%>";
<%
        }  	
	 }
%>


function useValidated( frmName )
{
  parentForm = getParent( frmName );
  try {
    cleanParent( parentForm );
  } catch(e1) {}
  
  try {
    updateParent( parentForm );
  } catch(e2) {}
  //opener.populateSchoolDistrict();
  window.close();
}

function validateSelection( frmName )
{
  parentForm = getParent( frmName );
  var found = -1;
  for (var i = 0; i < document.frmAddressValidation.rbContinue.length; i++) {
   if (document.frmAddressValidation.rbContinue[i].checked) {
      found = i;
      break;
   }
  } 
  
  if (found < 0) {
  	alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_ADDRESS_SELECTION_REQ)%>");
  	return;
  }
  try {
    cleanParent( parentForm );
  } catch(e1) {}
  
  try {
	parentForm.<%= addressSubmoduleName + AddressBean.ADDRESS1 %>.value = sugAddress1[found];
	parentForm.<%= addressSubmoduleName + AddressBean.ADDRESS2 %>.value = sugAddress2[found];
	parentForm.<%= addressSubmoduleName + AddressBean.CITY %>.value = sugCity[found];
	parentForm.<%= addressSubmoduleName + AddressBean.ZIP %>.value = sugZip[found];
	parentForm.<%= addressSubmoduleName + AddressBean.ZIP_SUFF %>.value = sugZip4[found];
	parentForm.<%= addressSubmoduleName + AddressBean.STATE %>.value = sugState[found];
	parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.value = sugCounty[found];
	parentForm.hdnNbrRsrcAddrLat.value = sugAddrLat[found];
	parentForm.hdnNbrRsrcAddrLong.value = sugAddrLong[found];
	
	if ( parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.value == '' ) {
		index = parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.options.length;
   		parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.options.length = index + 1;
   		parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.value = sugCounty[found];
 	}
  } catch(e2) {}
  window.close();
}

function useUnvalidated( frmName )
{
  parentForm = getParent( frmName );
  try {
    cleanParent( parentForm );
  } catch(e) {}
<%
  String existingCounty = FormattingHelper.formatString( (String) request.getAttribute("existingCounty") );
  if ( bRtnCounties )
  { %>
    populateDropdown( parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %> , '' , rtnCounties );
    parentForm.<%= addressSubmoduleName + AddressBean.MULT_COUNTY %>.value = true;
    parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.value = '<%= existingCounty %>';
<%} else { %>
  if ( parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.length != CCOUNT.length )
  {
    populateDropdown( parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %> , '' , CCOUNT );
    parentForm.<%= addressSubmoduleName + AddressBean.MULT_COUNTY %>.value = false;
  }
  
<%}

  if ( !addressValidated && !isSave )
  {
    switch(code1ErrorCode)
    {
      case AddressValidationConversation.CODE1_ADDRESS_MULTIPLE:
      case AddressValidationConversation.CODE1_STREET_MISSING:
      case AddressValidationConversation.CODE1_ADDRESS_DOUBTFUL:
      case AddressValidationConversation.CODE1_INVALID_STREET:
      case AddressValidationConversation.CODE1_APARTMENT_MISSING:
      case AddressValidationConversation.CODE1_INVALID_HOUSE_NBR:
        out.print( "parentForm." + addressSubmoduleName + AddressBean.ADDRESS1 +".focus();" );
        break;
      case AddressValidationConversation.CODE1_CITY_MISSING:
        out.print( "parentForm." + addressSubmoduleName + AddressBean.CITY +".focus();" );
        break;
      case AddressValidationConversation.CODE1_STATE_MISSING:
        out.print( "parentForm." + addressSubmoduleName + AddressBean.STATE +".focus();" );
        break;
      case AddressValidationConversation.CODE1_ZIP_MISSING:
      case AddressValidationConversation.CODE1_INVALID_ZIP:
        out.print( "parentForm." + addressSubmoduleName + AddressBean.ZIP +".focus();" );
        break;
    }
  }
  %>
  window.close();
}

function saveValidated(frmName)
{
  parentForm = getParent( frmName );
  cleanParent( parentForm );
  updateParent( parentForm );
  saveParent( frmName );
  window.close();
}

function saveUnvalidated( frmName )
{
  parentForm = getParent( frmName );
  cleanParent( parentForm );
  saveParent( frmName );
  window.close();
}

function closeWithNoAction( frmName )
{
  window.close();
}

function getParent( frmName )
{
  eval("var parentForm = opener.document." + frmName);
  return parentForm;
}

function saveParent( frmName )
{
  opener.saveWithValidateAndButton( frmName, '<%= addressSubmoduleName %>', '<%= buttonName %>' );
}

function cleanParent( parentForm )
{
  parentForm.<%= addressSubmoduleName + AddressBean.IS_VALID %>.value = "true";
}
function updateParent( parentForm )
{
  parentForm.<%= addressSubmoduleName + AddressBean.ADDRESS1 %>.value = "<%=addressLn1%>";
  parentForm.<%= addressSubmoduleName + AddressBean.ADDRESS2 %>.value = "<%=addressLn2%>";
  parentForm.<%= addressSubmoduleName + AddressBean.CITY %>.value = "<%=city%>";
  parentForm.<%= addressSubmoduleName + AddressBean.ZIP %>.value = "<%=zip5%>";
  parentForm.<%= addressSubmoduleName + AddressBean.ZIP_SUFF %>.value = "<%=zip4%>";
  parentForm.<%= addressSubmoduleName + AddressBean.STATE %>.value = "<%=state%>";
  parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.value = "<%=validatedCountyCode%>";
  parentForm.hdnNbrRsrcAddrLat.value = "<%=nbrRsrcAddrLat%>";
  parentForm.hdnNbrRsrcAddrLong.value = "<%=nbrRsrcAddrLong%>";

  // SIR 23043 Start
  if ( parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.value == '' )
  {
    index = parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.options.length;
    parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.options.length = index + 1;
    parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.value = "<%=validatedCountyCode%>";
  }
  // SIR 23043 End

}

<%
String parsedZip = ( parsedAddressRow.getZipCode() != null ) ? parsedAddressRow.getZipCode() : "" ;
String parsedZip5 = "";
String parsedZip4 = "";
if ( parsedZip.length() >= 5 )
{
  parsedZip5 = parsedZip.substring(0, 5);
}
if ( parsedZip.length() >= 10 )
{
  parsedZip4 = parsedZip.substring(6, 10);
}

%>
function updateParsedParent( parentForm )
{
  <%
     String numAddress = parsedAddressRow.getAddressNumber() != null ? parsedAddressRow.getAddressNumber().toUpperCase()+" " : "";
     String strAddress = parsedAddressRow.getStreet1() != null ? parsedAddressRow.getStreet1().toUpperCase()+" " : "";
     String thoroughfare = parsedAddressRow.getThoroughFare() != null ? parsedAddressRow.getThoroughFare().toUpperCase() : "";
     String parsedState = parsedAddressRow.getState() != null ? parsedAddressRow.getState() : CodesTables.CSTATE_GA;
  %>
  parentForm.<%= addressSubmoduleName + AddressBean.ADDRESS1 %>.value = "<%= FormattingHelper.formatString(parsedAddressRow.getFormattedStreetAddress())%>";
  parentForm.<%= addressSubmoduleName + AddressBean.ADDRESS2 %>.value = "<%= FormattingHelper.formatString( parsedAddressRow.getStreet2() )%>";
  parentForm.<%= addressSubmoduleName + AddressBean.CITY %>.value = "<%= FormattingHelper.formatString( parsedAddressRow.getCity() )%>";
  parentForm.<%= addressSubmoduleName + AddressBean.ZIP %>.value = "<%=parsedZip5%>";
  parentForm.<%= addressSubmoduleName + AddressBean.ZIP_SUFF %>.value = "<%=parsedZip4%>";
  parentForm.<%= addressSubmoduleName + AddressBean.STATE %>.value = "<%= FormattingHelper.formatString( parsedState )%>";
  parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.value = "<%= parsedAddressRow.getCountyCode() %>";
  parentForm.hdnNbrRsrcAddrLat.value = "<%=nbrRsrcAddrLat%>";
  parentForm.hdnNbrRsrcAddrLong.value = "<%=nbrRsrcAddrLong%>";  
}
</script>
<span class="formErrorText"><%= validMessage %></span>

<form name="frmAddressValidation">
<input type="hidden" name="frmWindowName"/>
<table border="0" cellspacing="0" cellpadding="3" width="400" class="topLevel">
<tr>
<td>
<%
  if ( addressValidated )
  {
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="3">
      Valid Address
    </th>
  </tr>
  <tr>
    <td>

    <tr align=left valign=top>
        <td>Address Ln 1: <%=addressLn1%></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>Address Ln 2: <%=addressLn2%></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
      <td>City: <%=city%></td>
      <td>State: <%=state%></td>
    </tr>
    <tr>
      <td>Zip: <%=zip%></td>
      <td>County: <%=county%>
      </td>
    </tr>
   </table>
<%
  }//End If Address Valid
%>
   <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td align="left">
        <span class="formErrorText"><%= continueMessage %></span>
      </td>
      <td align="right">
      <%
      //If a valid address
      if ( addressValidated )
      {
        //If Save was clicked
        if ( isSave )
        {
        %>
        <table border="0" cellspacing="0" cellpadding="3" width="100%">
          <tr><td>
          <a href="#" onClick="saveValidated('<%=sOriginatedWindow%>');"><img class="md"
            border="0" src="/grnds-docs/images/shared/btnYes.gif" name="Yes" tabIndex="1"></a>
          </td></tr>
          <tr><td>
            <a href="#" onClick="saveUnvalidated('<%=sOriginatedWindow%>');"><img class="md"
            border="0" src="/grnds-docs/images/shared/btnNo.gif" name="No" tabIndex="2"></a>
          </td></tr>
          <tr><td>
          <a href="#" onClick="closeWithNoAction('<%=sOriginatedWindow%>');"><img class="md"
            border="0" src="/grnds-docs/images/shared/btnCancel.gif" name="Cancel" tabIndex="3"></a>
          </td></tr>
        </table>
        <%
        }
        //If Validate was clicked
        else
        {
        %>
        <table border="0" cellspacing="0" cellpadding="3" width="100%">
          <tr><td>
          <a href="#" onClick="useValidated('<%=sOriginatedWindow%>');"><img class="md"
              border="0" src="/grnds-docs/images/shared/btnYes.gif" name="Yes" tabIndex="1"></a>
          </td></tr>
          <tr><td>
          <a href="#" onClick="useUnvalidated('<%=sOriginatedWindow%>');"><img class="md"
              border="0" src="/grnds-docs/images/shared/btnNo.gif" name="No" tabIndex="2"></a>
          </td></tr>
        </table>
        <%
        }
      }
      //If not a valid address
      else
      {
        //If Save was clicked
        if ( isSave )
        {
        %>
        <table border="0" cellspacing="0" cellpadding="3" width="100%">
          <tr><td>
          <a href="#" onClick="saveUnvalidated('<%=sOriginatedWindow%>');"><img class="md"
            border="0" src="/grnds-docs/images/shared/btnYes.gif" name="Yes" tabIndex="1"></a>
          </td></tr>
          <tr><td>
          <a href="#" onClick="closeWithNoAction('<%=sOriginatedWindow%>');"><img class="md"
            border="0" src="/grnds-docs/images/shared/btnCancel.gif" name="Cancel" tabIndex="3"></a>
          </td></tr>
        </table>
        <%
        }
        //If Validate was clicked
        else {
         if (addressesList != null && addressesList.size() > 0) {
         %>
         	<div id="addressSearchResults" style="height:160px; width:600px; overflow:auto" class="tableborderList">
         	<table border="0" cellpadding="3" cellspacing="0" width="100%" id="TABLEVALD">
         	<tr class="thList">
	          <th class="thList">&nbsp;</th>
	          <th class="thList">Suggested Address</th>
	          <th class="thList">Status</th>
	        </tr>
         <%
            boolean checked = false;
         	int numberOfAddresses = addressesList.size();
        	for (int rowCount = 0; rowCount < numberOfAddresses; rowCount++) {
            	AddressValidatorSO address = addressesList.get(rowCount);
            	String streetAddress = address.getFormattedStreetAddress() + ", " + address.getCity() + " " + address.getState() + " " + address.getZipCode();
            	String status = ArchitectureConstants.Y.equals(address.getDpvStatus()) ? MessageLookup.getMessageByNumber(Messages.MSG_ADDRESS_COMPLETE) : MessageLookup.getMessageByNumber(Messages.MSG_ADDRESS_NOT_COMPLETE);
         %>
         		<tr class="<%= FormattingHelper.getRowCss(rowCount + 1)%>">
	         		<td>
	         			<input type="radio" name="rbContinue" value="<%= "" + rowCount%>">
	         		</td>
	         		<td><%=FormattingHelper.formatString(streetAddress)%></td>
		            <td> <%=FormattingHelper.formatString(status)%></td>
	            </tr>
         <%
           }
          %>
          </table>
          </div>
           <table border="0" cellspacing="0" cellpadding="3" width="100%">
	          <tr>
	          <td>Select one of the suggested addresses and press Yes</td>
	          <td>
	          <a href="#" onClick="validateSelection('<%=sOriginatedWindow%>');"><img class="md"
	              border="0" src="/grnds-docs/images/shared/btnYes.gif" name="Yes" tabIndex="1"></a>
	          </td></tr>
	          <tr>
	          <td>Press No to use  the address as entered</td>
	          <td>
	          <a href="#" onClick="useUnvalidated('<%=sOriginatedWindow%>');"><img class="md"
	              border="0" src="/grnds-docs/images/shared/btnNo.gif" name="No" tabIndex="2"></a>
	         </td></tr>
	       </table>
          <%
          instructions = MessageLookup.getMessageByNumber(Messages.MSG_ADDRESS_FOOTNOTE);
         } else {
         %>
       </table>
        <table border="0" cellspacing="0" cellpadding="3" width="100%">
          <tr><td>
          <a href="#" onClick="useUnvalidated('<%=sOriginatedWindow%>');"><img class="md"
            border="0" src="/grnds-docs/images/shared/btnClose.gif" name="Ok" tabIndex="3"></a>
          </td></tr>
        </table>
      <%
      		}
        }
      }
      %>
      </td>
    <tr>
      <td colspan="2">
        <%= instructions %>
      </td>
    </tr>
  </table>
</td>
</tr>
</table>
</form>
