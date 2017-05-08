package org.apache.jsp.grnds_002ddocs.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressValidationConversation;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import java.util.List;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;

public final class AddressValidation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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

      out.write("\r\n\r\n<script language=\"JavaScript1.2\">\r\n");
 if ( bRtnCounties ) {
      out.write("\r\n  ");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setOptions(rtnCounties);
      _jspx_th_impact_codeArray_0.setArrayName("rtnCounties");
      _jspx_th_impact_codeArray_0.setBlankValue("true");
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
} else { 
      out.write("\r\n  ");
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
}
      out.write("\r\n\r\nvar sugAddress1 = new Array();\r\nvar sugAddress2 = new Array();\r\nvar sugCity = new Array();\r\nvar sugCounty = new Array();\r\nvar sugZip = new Array();\r\nvar sugZip4 = new Array();\r\nvar sugState = new Array();\r\nvar sugAddrLat = new Array();\r\nvar sugAddLong = new Array();\r\n");

	 if (addressesList != null && addressesList.size() > 0) {
	 	int numberOfAddresses = addressesList.size();
        for (int rowCount = 0; rowCount < numberOfAddresses; rowCount++) {
            	AddressValidatorSO address = addressesList.get(rowCount);

      out.write("\r\n          \t\tsugAddress1[");
      out.print(rowCount);
      out.write("] = \"");
      out.print( FormattingHelper.formatString(address.getFormattedStreetAddress()).toUpperCase());
      out.write("\";\r\n          \t\tsugAddress2[");
      out.print(rowCount);
      out.write("] = \"");
      out.print( FormattingHelper.formatString(address.getStreet2()).toUpperCase());
      out.write("\";\r\n          \t\tsugCity[");
      out.print(rowCount);
      out.write("] = \"");
      out.print( FormattingHelper.formatString(address.getCity()).toUpperCase());
      out.write("\";\r\n          \t\tsugCounty[");
      out.print(rowCount);
      out.write("] = \"");
      out.print( FormattingHelper.formatString(address.getCountyCode()));
      out.write("\";\r\n          \t\tsugZip[");
      out.print(rowCount);
      out.write("] = \"");
      out.print( FormattingHelper.formatString(address.getZipCode()));
      out.write("\";\r\n          \t\tsugZip4[");
      out.print(rowCount);
      out.write("] = \"");
      out.print( FormattingHelper.formatString(address.getZip4()));
      out.write("\";\r\n          \t\tsugState[");
      out.print(rowCount);
      out.write("] = \"");
      out.print( FormattingHelper.formatString(address.getState()));
      out.write("\";\r\n          \t\tsugAddrLat[");
      out.print(rowCount);
      out.write("] = \"");
      out.print( FormattingHelper.formatDouble(address.getX()));
      out.write("\";\r\n          \t\tsugAddLong[");
      out.print(rowCount);
      out.write("] = \"");
      out.print( FormattingHelper.formatDouble(address.getY()));
      out.write("\";\r\n");

        }  	
	 }

      out.write("\r\n\r\n\r\nfunction useValidated( frmName )\r\n{\r\n  parentForm = getParent( frmName );\r\n  try {\r\n    cleanParent( parentForm );\r\n  } catch(e1) {}\r\n  \r\n  try {\r\n    updateParent( parentForm );\r\n  } catch(e2) {}\r\n  //opener.populateSchoolDistrict();\r\n  window.close();\r\n}\r\n\r\nfunction validateSelection( frmName )\r\n{\r\n  parentForm = getParent( frmName );\r\n  var found = -1;\r\n  for (var i = 0; i < document.frmAddressValidation.rbContinue.length; i++) {\r\n   if (document.frmAddressValidation.rbContinue[i].checked) {\r\n      found = i;\r\n      break;\r\n   }\r\n  } \r\n  \r\n  if (found < 0) {\r\n  \talert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ADDRESS_SELECTION_REQ));
      out.write("\");\r\n  \treturn;\r\n  }\r\n  try {\r\n    cleanParent( parentForm );\r\n  } catch(e1) {}\r\n  \r\n  try {\r\n\tparentForm.");
      out.print( addressSubmoduleName + AddressBean.ADDRESS1 );
      out.write(".value = sugAddress1[found];\r\n\tparentForm.");
      out.print( addressSubmoduleName + AddressBean.ADDRESS2 );
      out.write(".value = sugAddress2[found];\r\n\tparentForm.");
      out.print( addressSubmoduleName + AddressBean.CITY );
      out.write(".value = sugCity[found];\r\n\tparentForm.");
      out.print( addressSubmoduleName + AddressBean.ZIP );
      out.write(".value = sugZip[found];\r\n\tparentForm.");
      out.print( addressSubmoduleName + AddressBean.ZIP_SUFF );
      out.write(".value = sugZip4[found];\r\n\tparentForm.");
      out.print( addressSubmoduleName + AddressBean.STATE );
      out.write(".value = sugState[found];\r\n\tparentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".value = sugCounty[found];\r\n\tparentForm.hdnNbrRsrcAddrLat.value = sugAddrLat[found];\r\n\tparentForm.hdnNbrRsrcAddrLong.value = sugAddrLong[found];\r\n\t\r\n\tif ( parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".value == '' ) {\r\n\t\tindex = parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".options.length;\r\n   \t\tparentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".options.length = index + 1;\r\n   \t\tparentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".value = sugCounty[found];\r\n \t}\r\n  } catch(e2) {}\r\n  window.close();\r\n}\r\n\r\nfunction useUnvalidated( frmName )\r\n{\r\n  parentForm = getParent( frmName );\r\n  try {\r\n    cleanParent( parentForm );\r\n  } catch(e) {}\r\n");

  String existingCounty = FormattingHelper.formatString( (String) request.getAttribute("existingCounty") );
  if ( bRtnCounties )
  { 
      out.write("\r\n    populateDropdown( parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(" , '' , rtnCounties );\r\n    parentForm.");
      out.print( addressSubmoduleName + AddressBean.MULT_COUNTY );
      out.write(".value = true;\r\n    parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".value = '");
      out.print( existingCounty );
      out.write("';\r\n");
} else { 
      out.write("\r\n  if ( parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".length != CCOUNT.length )\r\n  {\r\n    populateDropdown( parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(" , '' , CCOUNT );\r\n    parentForm.");
      out.print( addressSubmoduleName + AddressBean.MULT_COUNTY );
      out.write(".value = false;\r\n  }\r\n  \r\n");
}

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
  
      out.write("\r\n  window.close();\r\n}\r\n\r\nfunction saveValidated(frmName)\r\n{\r\n  parentForm = getParent( frmName );\r\n  cleanParent( parentForm );\r\n  updateParent( parentForm );\r\n  saveParent( frmName );\r\n  window.close();\r\n}\r\n\r\nfunction saveUnvalidated( frmName )\r\n{\r\n  parentForm = getParent( frmName );\r\n  cleanParent( parentForm );\r\n  saveParent( frmName );\r\n  window.close();\r\n}\r\n\r\nfunction closeWithNoAction( frmName )\r\n{\r\n  window.close();\r\n}\r\n\r\nfunction getParent( frmName )\r\n{\r\n  eval(\"var parentForm = opener.document.\" + frmName);\r\n  return parentForm;\r\n}\r\n\r\nfunction saveParent( frmName )\r\n{\r\n  opener.saveWithValidateAndButton( frmName, '");
      out.print( addressSubmoduleName );
      out.write("', '");
      out.print( buttonName );
      out.write("' );\r\n}\r\n\r\nfunction cleanParent( parentForm )\r\n{\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.IS_VALID );
      out.write(".value = \"true\";\r\n}\r\nfunction updateParent( parentForm )\r\n{\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.ADDRESS1 );
      out.write(".value = \"");
      out.print(addressLn1);
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.ADDRESS2 );
      out.write(".value = \"");
      out.print(addressLn2);
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.CITY );
      out.write(".value = \"");
      out.print(city);
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.ZIP );
      out.write(".value = \"");
      out.print(zip5);
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.ZIP_SUFF );
      out.write(".value = \"");
      out.print(zip4);
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.STATE );
      out.write(".value = \"");
      out.print(state);
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".value = \"");
      out.print(validatedCountyCode);
      out.write("\";\r\n  parentForm.hdnNbrRsrcAddrLat.value = \"");
      out.print(nbrRsrcAddrLat);
      out.write("\";\r\n  parentForm.hdnNbrRsrcAddrLong.value = \"");
      out.print(nbrRsrcAddrLong);
      out.write("\";\r\n\r\n  // SIR 23043 Start\r\n  if ( parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".value == '' )\r\n  {\r\n    index = parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".options.length;\r\n    parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".options.length = index + 1;\r\n    parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".value = \"");
      out.print(validatedCountyCode);
      out.write("\";\r\n  }\r\n  // SIR 23043 End\r\n\r\n}\r\n\r\n");

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


      out.write("\r\nfunction updateParsedParent( parentForm )\r\n{\r\n  ");

     String numAddress = parsedAddressRow.getAddressNumber() != null ? parsedAddressRow.getAddressNumber().toUpperCase()+" " : "";
     String strAddress = parsedAddressRow.getStreet1() != null ? parsedAddressRow.getStreet1().toUpperCase()+" " : "";
     String thoroughfare = parsedAddressRow.getThoroughFare() != null ? parsedAddressRow.getThoroughFare().toUpperCase() : "";
     String parsedState = parsedAddressRow.getState() != null ? parsedAddressRow.getState() : CodesTables.CSTATE_GA;
  
      out.write("\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.ADDRESS1 );
      out.write(".value = \"");
      out.print( FormattingHelper.formatString(parsedAddressRow.getFormattedStreetAddress()));
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.ADDRESS2 );
      out.write(".value = \"");
      out.print( FormattingHelper.formatString( parsedAddressRow.getStreet2() ));
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.CITY );
      out.write(".value = \"");
      out.print( FormattingHelper.formatString( parsedAddressRow.getCity() ));
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.ZIP );
      out.write(".value = \"");
      out.print(parsedZip5);
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.ZIP_SUFF );
      out.write(".value = \"");
      out.print(parsedZip4);
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.STATE );
      out.write(".value = \"");
      out.print( FormattingHelper.formatString( parsedState ));
      out.write("\";\r\n  parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".value = \"");
      out.print( parsedAddressRow.getCountyCode() );
      out.write("\";\r\n  parentForm.hdnNbrRsrcAddrLat.value = \"");
      out.print(nbrRsrcAddrLat);
      out.write("\";\r\n  parentForm.hdnNbrRsrcAddrLong.value = \"");
      out.print(nbrRsrcAddrLong);
      out.write("\";  \r\n}\r\n</script>\r\n<span class=\"formErrorText\">");
      out.print( validMessage );
      out.write("</span>\r\n\r\n<form name=\"frmAddressValidation\">\r\n<input type=\"hidden\" name=\"frmWindowName\"/>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"400\" class=\"topLevel\">\r\n<tr>\r\n<td>\r\n");

  if ( addressValidated )
  {

      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"3\">\r\n      Valid Address\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n\r\n    <tr align=left valign=top>\r\n        <td>Address Ln 1: ");
      out.print(addressLn1);
      out.write("</td>\r\n        <td>&nbsp;</td>\r\n        <td>&nbsp;</td>\r\n    </tr>\r\n    <tr>\r\n        <td>Address Ln 2: ");
      out.print(addressLn2);
      out.write("</td>\r\n        <td>&nbsp;</td>\r\n        <td>&nbsp;</td>\r\n    </tr>\r\n    <tr>\r\n      <td>City: ");
      out.print(city);
      out.write("</td>\r\n      <td>State: ");
      out.print(state);
      out.write("</td>\r\n    </tr>\r\n    <tr>\r\n      <td>Zip: ");
      out.print(zip);
      out.write("</td>\r\n      <td>County: ");
      out.print(county);
      out.write("\r\n      </td>\r\n    </tr>\r\n   </table>\r\n");

  }//End If Address Valid

      out.write("\r\n   <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"left\">\r\n        <span class=\"formErrorText\">");
      out.print( continueMessage );
      out.write("</span>\r\n      </td>\r\n      <td align=\"right\">\r\n      ");

      //If a valid address
      if ( addressValidated )
      {
        //If Save was clicked
        if ( isSave )
        {
        
      out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"saveValidated('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnYes.gif\" name=\"Yes\" tabIndex=\"1\"></a>\r\n          </td></tr>\r\n          <tr><td>\r\n            <a href=\"#\" onClick=\"saveUnvalidated('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnNo.gif\" name=\"No\" tabIndex=\"2\"></a>\r\n          </td></tr>\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"closeWithNoAction('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnCancel.gif\" name=\"Cancel\" tabIndex=\"3\"></a>\r\n          </td></tr>\r\n        </table>\r\n        ");

        }
        //If Validate was clicked
        else
        {
        
      out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"useValidated('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n              border=\"0\" src=\"/grnds-docs/images/shared/btnYes.gif\" name=\"Yes\" tabIndex=\"1\"></a>\r\n          </td></tr>\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"useUnvalidated('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n              border=\"0\" src=\"/grnds-docs/images/shared/btnNo.gif\" name=\"No\" tabIndex=\"2\"></a>\r\n          </td></tr>\r\n        </table>\r\n        ");

        }
      }
      //If not a valid address
      else
      {
        //If Save was clicked
        if ( isSave )
        {
        
      out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"saveUnvalidated('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnYes.gif\" name=\"Yes\" tabIndex=\"1\"></a>\r\n          </td></tr>\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"closeWithNoAction('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnCancel.gif\" name=\"Cancel\" tabIndex=\"3\"></a>\r\n          </td></tr>\r\n        </table>\r\n        ");

        }
        //If Validate was clicked
        else {
         if (addressesList != null && addressesList.size() > 0) {
         
      out.write("\r\n         \t<div id=\"addressSearchResults\" style=\"height:160px; width:600px; overflow:auto\" class=\"tableborderList\">\r\n         \t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" id=\"TABLEVALD\">\r\n         \t<tr class=\"thList\">\r\n\t          <th class=\"thList\">&nbsp;</th>\r\n\t          <th class=\"thList\">Suggested Address</th>\r\n\t          <th class=\"thList\">Status</th>\r\n\t        </tr>\r\n         ");

            boolean checked = false;
         	int numberOfAddresses = addressesList.size();
        	for (int rowCount = 0; rowCount < numberOfAddresses; rowCount++) {
            	AddressValidatorSO address = addressesList.get(rowCount);
            	String streetAddress = address.getFormattedStreetAddress() + ", " + address.getCity() + " " + address.getState() + " " + address.getZipCode();
            	String status = ArchitectureConstants.Y.equals(address.getDpvStatus()) ? MessageLookup.getMessageByNumber(Messages.MSG_ADDRESS_COMPLETE) : MessageLookup.getMessageByNumber(Messages.MSG_ADDRESS_NOT_COMPLETE);
         
      out.write("\r\n         \t\t<tr class=\"");
      out.print( FormattingHelper.getRowCss(rowCount + 1));
      out.write("\">\r\n\t         \t\t<td>\r\n\t         \t\t\t<input type=\"radio\" name=\"rbContinue\" value=\"");
      out.print( "" + rowCount);
      out.write("\">\r\n\t         \t\t</td>\r\n\t         \t\t<td>");
      out.print(FormattingHelper.formatString(streetAddress));
      out.write("</td>\r\n\t\t            <td> ");
      out.print(FormattingHelper.formatString(status));
      out.write("</td>\r\n\t            </tr>\r\n         ");

           }
          
      out.write("\r\n          </table>\r\n          </div>\r\n           <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t          <tr>\r\n\t          <td>Select one of the suggested addresses and press Yes</td>\r\n\t          <td>\r\n\t          <a href=\"#\" onClick=\"validateSelection('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n\t              border=\"0\" src=\"/grnds-docs/images/shared/btnYes.gif\" name=\"Yes\" tabIndex=\"1\"></a>\r\n\t          </td></tr>\r\n\t          <tr>\r\n\t          <td>Press No to use  the address as entered</td>\r\n\t          <td>\r\n\t          <a href=\"#\" onClick=\"useUnvalidated('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n\t              border=\"0\" src=\"/grnds-docs/images/shared/btnNo.gif\" name=\"No\" tabIndex=\"2\"></a>\r\n\t         </td></tr>\r\n\t       </table>\r\n          ");

          instructions = MessageLookup.getMessageByNumber(Messages.MSG_ADDRESS_FOOTNOTE);
         } else {
         
      out.write("\r\n       </table>\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"useUnvalidated('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnClose.gif\" name=\"Ok\" tabIndex=\"3\"></a>\r\n          </td></tr>\r\n        </table>\r\n      ");

      		}
        }
      }
      
      out.write("\r\n      </td>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        ");
      out.print( instructions );
      out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n</td>\r\n</tr>\r\n</table>\r\n</form>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CCOUNT");
    _jspx_th_impact_codeArray_1.setArrayName("CCOUNT");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
