<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>


<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressValidationConversation"%>
<%
  String sOriginatedWindow = ContextHelper.getStringSafe(request, AddressValidationConversation.ORIGINATING_FORM );
  String saveOrValidate = ContextHelper.getStringSafe(request, AddressBean.SAVE_OR_VALIDATE);
  String buttonName = ContextHelper.getStringSafe(request, "buttonClicked");

  
  AddressValidatorSO addressRow = null;
  AddressValidatorSO parsedAddressRow = null;
  CityCountyStruct correctCounty = null;
  

  if ( request.getAttribute(AddressValidationConversation.ADDRESS_ROW) != null )
  {
    addressRow =(AddressValidatorSO) request.getAttribute(AddressValidationConversation.ADDRESS_ROW);
  }
  else
  {
    addressRow = new   AddressValidatorSO();
  }

  if ( request.getAttribute(AddressValidationConversation.PARSED_ADDRESS_ROW) != null )
  {
    parsedAddressRow =(AddressValidatorSO) request.getAttribute(AddressValidationConversation.PARSED_ADDRESS_ROW);
  }
  else
  {
     parsedAddressRow = new AddressValidatorSO();
  }

  if ( request.getAttribute(AddressValidationConversation.CORRECT_COUNTY) != null )
  {
    correctCounty = (CityCountyStruct) request.getAttribute(AddressValidationConversation.CORRECT_COUNTY);
  }
  else
  {
    correctCounty = new CityCountyStruct();
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
  boolean addressValidated = Boolean.valueOf(addressValidatedString);

   String addressLn1 = "";
  if(addressRow.getAddressNumber() != null && !"".equals(addressRow.getAddressNumber()))
  {
    addressLn1 = FormattingHelper.formatString(addressRow.getAddressNumber() + 
                                               " " + addressRow.getStreet1() +
                                               " " + addressRow.getThoroughFare());
  }
  String addressLn2 = FormattingHelper.formatString(addressRow.getStreet2());
  String city = FormattingHelper.formatString(addressRow.getCity());
  String state = FormattingHelper.formatString(addressRow.getState());
  String zip = FormattingHelper.formatString(addressRow.getZipCode());
  String validatedCountyCode = addressRow.getCountyCode();
  String county = Lookup.simpleDecodeSafe( CodesTables.CCOUNT, validatedCountyCode );
  String zip5 = "";
  String zip4 = "";
  if ( zip.length() >= 5 )
  {
    zip5 = zip.substring(0, 5);
  }
  if ( zip.length() >= 10 )
  {
    zip4 = zip.substring(6, 10);
  }
  double nbrRsrcAddrLat = addressRow.getX();
  double nbrRsrcAddrLong = addressRow.getY();
  String addressSubmoduleName = (String) request.getAttribute( AddressBean.ADDRESS_SUBMODULE_NAME );
  String countyName = correctCounty.getSzNmCityCnty();
  String countyCode = correctCounty.getSzCdCityTexCnty();

  String code1error = FormattingHelper.formatString( ( String ) request.getAttribute( "code1error" ) );
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
    if ("save".equals(saveOrValidate) )
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
    validMessage = "This address has not been validated for the following reason:";
    validMessage += "<li>" + code1error + "</li>";
    if ( isSave )
    {
        continueMessage = "Do you still wish to save using this address?";
      //instructions += "Press 'Yes' to save using this address.<br>";
        instructions += "Press 'Yes' to save using the unvalidated address.<br>";
        instructions += "Press 'Cancel' if you do not wish to save.<br>";
    }
    else
    {
      /**continueMessage = "Do you still wish to use this address?";
      instructions += "Press 'Yes' to use this address.<br>";
      instructions += "Press 'No' to use the unvalidated address.<br>";*/
        instructions += "Press 'Close' to close this window and make corrections to Address Detail and save, or save the address as entered.<br>";
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

<%
  if ( bRtnCounties )
  {
%>
  <impact:codeArray options="<%= rtnCounties %>" arrayName="rtnCounties" blankValue="true"/>
<%
  }
  else
  {
%>
  <impact:codeArray codeName="CCOUNT" arrayName="CCOUNT" blankValue="true"/>
<%
  }
%>

function yesOnValidate( frmName )
{
  parentForm = getParent( frmName )
  cleanParent( parentForm );
  updateParent( parentForm );
  //opener.populateSchoolDistrict();
  window.close();
}

function noOnValidate( frmName )
{
  parentForm = getParent( frmName )
  cleanParent( parentForm );
  //updateParsedParent( parentForm )
<%
  if ( bRtnCounties )
  { %>
    populateDropdown( parentForm.selCdFacilityCounty<%=addressSubmoduleName%> , '' , rtnCounties );
    parentForm.addressMultCounty.value = true;
    parentForm.selCdFacilityCounty.value = '<%= FormattingHelper.formatString( (String) request.getAttribute("existingCounty") ) %>';
<%} else { %>
  if ( parentForm.selCdFacilityCounty.length != CCOUNT.length )
  {
    populateDropdown( parentForm.selCdFacilityCounty<%=addressSubmoduleName%> , '' , CCOUNT );
    parentForm.addressMultCounty.value = false;
    parentForm.selCdFacilityCounty.value = '<%= FormattingHelper.formatString( (String) request.getAttribute("existingCounty") ) %>';
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
        out.print( "parentForm.txtSzAddrRsrcAddrStLn1"+addressSubmoduleName+".focus();" );
        break;
      case AddressValidationConversation.CODE1_CITY_MISSING:
        out.print( "parentForm.txtSzAddrRsrcAddrCity"+addressSubmoduleName+".focus();" );
        break;
      case AddressValidationConversation.CODE1_STATE_MISSING:
        out.print( "parentForm.selCdFacilityState"+addressSubmoduleName+".focus();" );
        break;
      case AddressValidationConversation.CODE1_ZIP_MISSING:
      case AddressValidationConversation.CODE1_INVALID_ZIP:
        out.print( "parentForm.txtSzAddrRsrcAddrZip"+addressSubmoduleName+".focus();" );
        break;
    }
  }
  %>
  window.close();
}

function yesOnSave(frmName)
{
  parentForm = getParent( frmName )
  cleanParent( parentForm );
  updateParent( parentForm );
  saveParent( frmName );
  window.close();
}

function noOnSave( frmName )
{
  
  parentForm = getParent( frmName )
  cleanParent( parentForm );
  saveParent( frmName );
  window.close();
}

function cancelOnSave( frmName )
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
  frmName.validated.value = 'true';
  opener.saveWithValidate( frmName, '<%= addressSubmoduleName %>' );
   // opener.saveWithValidate( '<%= addressSubmoduleName %>' );
   //parentForm.saveWithValidate( '<%= addressSubmoduleName %>' );
}

function cleanParent( parentForm )
{
  parentForm.validated.value = "true"
}

function updateParent( parentForm )
{

  parentForm.txtSzAddrRsrcAddrStLn1<%=addressSubmoduleName%>.value = "<%=addressLn1%>";
  parentForm.txtSzAddrRsrcAddrStLn2<%=addressSubmoduleName%>.value = "<%=addressLn2%>";
  parentForm.txtSzAddrRsrcAddrCity<%=addressSubmoduleName%>.value = "<%=city%>";
  parentForm.txtSzAddrRsrcAddrZip<%=addressSubmoduleName%>.value = "<%=zip5%>";
  parentForm.txtSzAddrRsrcAddrZipSuff<%=addressSubmoduleName%>.value = "<%=zip4%>";
  parentForm.selCdFacilityState<%=addressSubmoduleName%>.value = "<%=state%>";
  parentForm.selCdFacilityCounty<%=addressSubmoduleName%>.value = "<%=validatedCountyCode%>";
  parentForm.hdnNbrRsrcAddrLat<%=addressSubmoduleName%>.value = "<%=nbrRsrcAddrLat%>";
  parentForm.hdnNbrRsrcAddrLong<%=addressSubmoduleName%>.value = "<%=nbrRsrcAddrLong%>";  
}
<%
String parsedZip = ( parsedAddressRow.getZipCode()  != null ) ? parsedAddressRow.getZipCode()  : "" ;
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
  parentForm.txtSzAddrRsrcAddrStLn1<%=addressSubmoduleName%>.value = "<%= FormattingHelper.formatString( numAddress + strAddress + thoroughfare )%>";
  parentForm.txtSzAddrRsrcAddrStLn2<%=addressSubmoduleName%>.value = "<%= FormattingHelper.formatString( parsedAddressRow.getStreet2() )%>";
  parentForm.txtSzAddrRsrcAddrCity<%=addressSubmoduleName%>.value = "<%= FormattingHelper.formatString( parsedAddressRow.getCity() )%>";
  parentForm.txtSzAddrRsrcAddrZip<%=addressSubmoduleName%>.value = "<%=parsedZip5%>";
  parentForm.txtSzAddrRsrcAddrZipSuff<%= addressSubmoduleName %>.value = "<%=parsedZip4%>";
  parentForm.selCdFacilityState<%=addressSubmoduleName%>.value = "<%= FormattingHelper.formatString( parsedState )%>";
  parentForm.selCdFacilityCounty<%=addressSubmoduleName%>.value = "<%= FormattingHelper.formatString( parsedAddressRow.getCountyCode() )%>";
  parentForm.hdnNbrRsrcAddrLat<%=addressSubmoduleName%>.value = "<%=nbrRsrcAddrLat%>";
  parentForm.hdnNbrRsrcAddrLong<%=addressSubmoduleName%>.value = "<%=nbrRsrcAddrLong%>";  

  //parentForm.<%= addressSubmoduleName + AddressBean.COUNTY %>.value = "<%= parsedAddressRow.getCountyCode() %>";
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
          <a href="#" onClick="yesOnSave('<%=sOriginatedWindow%>');"><img class="md"
            border="0" src="/grnds-docs/images/shared/btnYes.gif" name="Yes" tabIndex="1"></a>
          </td></tr>
          <tr><td>
            <a href="#" onClick="noOnSave('<%=sOriginatedWindow%>');"><img class="md"
            border="0" src="/grnds-docs/images/shared/btnNo.gif" name="No" tabIndex="2"></a>
          </td></tr>
          <tr><td>
          <a href="#" onClick="cancelOnSave('<%=sOriginatedWindow%>');"><img class="md"
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
          <a href="#" onClick="yesOnValidate('<%=sOriginatedWindow%>');"><img class="md"
              border="0" src="/grnds-docs/images/shared/btnYes.gif" name="Yes" tabIndex="1"></a>
          </td></tr>
          <tr><td>
          <a href="#" onClick="noOnValidate('<%=sOriginatedWindow%>');"><img class="md"
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
          <a href="#" onClick="noOnSave('<%=sOriginatedWindow%>');"><img class="md"
            border="0" src="/grnds-docs/images/shared/btnYes.gif" name="Yes" tabIndex="1"></a>
          </td></tr>
          <tr><td>
          <a href="#" onClick="cancelOnSave('<%=sOriginatedWindow%>');"><img class="md"
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
          <a href="#" onClick="noOnValidate('<%=sOriginatedWindow%>');"><img class="md"
            border="0" src="/grnds-docs/images/shared/btnClose.gif" name="Ok" tabIndex="3"></a>
          </td></tr>
        </table>
      <%
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
