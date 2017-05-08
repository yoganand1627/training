package org.apache.jsp.grnds_002ddocs.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CityCountyStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressValidationConversation;

public final class ResourceAddressValidation_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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

      out.write("\r\n<script language=\"JavaScript1.2\">\r\n\r\n");

  if ( bRtnCounties )
  {

      out.write("\r\n  ");
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setOptions( rtnCounties );
      _jspx_th_impact_codeArray_0.setArrayName("rtnCounties");
      _jspx_th_impact_codeArray_0.setBlankValue("true");
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  }
  else
  {

      out.write("\r\n  ");
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

  }

      out.write("\r\n\r\nfunction yesOnValidate( frmName )\r\n{\r\n  parentForm = getParent( frmName )\r\n  cleanParent( parentForm );\r\n  updateParent( parentForm );\r\n  //opener.populateSchoolDistrict();\r\n  window.close();\r\n}\r\n\r\nfunction noOnValidate( frmName )\r\n{\r\n  parentForm = getParent( frmName )\r\n  cleanParent( parentForm );\r\n  //updateParsedParent( parentForm )\r\n");

  if ( bRtnCounties )
  { 
      out.write("\r\n    populateDropdown( parentForm.selCdFacilityCounty");
      out.print(addressSubmoduleName);
      out.write(" , '' , rtnCounties );\r\n    parentForm.addressMultCounty.value = true;\r\n    parentForm.selCdFacilityCounty.value = '");
      out.print( FormattingHelper.formatString( (String) request.getAttribute("existingCounty") ) );
      out.write("';\r\n");
} else { 
      out.write("\r\n  if ( parentForm.selCdFacilityCounty.length != CCOUNT.length )\r\n  {\r\n    populateDropdown( parentForm.selCdFacilityCounty");
      out.print(addressSubmoduleName);
      out.write(" , '' , CCOUNT );\r\n    parentForm.addressMultCounty.value = false;\r\n    parentForm.selCdFacilityCounty.value = '");
      out.print( FormattingHelper.formatString( (String) request.getAttribute("existingCounty") ) );
      out.write("';\r\n  }\r\n");
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
  
      out.write("\r\n  window.close();\r\n}\r\n\r\nfunction yesOnSave(frmName)\r\n{\r\n  parentForm = getParent( frmName )\r\n  cleanParent( parentForm );\r\n  updateParent( parentForm );\r\n  saveParent( frmName );\r\n  window.close();\r\n}\r\n\r\nfunction noOnSave( frmName )\r\n{\r\n  \r\n  parentForm = getParent( frmName )\r\n  cleanParent( parentForm );\r\n  saveParent( frmName );\r\n  window.close();\r\n}\r\n\r\nfunction cancelOnSave( frmName )\r\n{\r\n\r\n  window.close();\r\n}\r\n\r\nfunction getParent( frmName )\r\n{\r\n  eval(\"var parentForm = opener.document.\" + frmName);\r\n  return parentForm;\r\n}\r\n\r\nfunction saveParent( frmName )\r\n{\r\n  frmName.validated.value = 'true';\r\n  opener.saveWithValidate( frmName, '");
      out.print( addressSubmoduleName );
      out.write("' );\r\n   // opener.saveWithValidate( '");
      out.print( addressSubmoduleName );
      out.write("' );\r\n   //parentForm.saveWithValidate( '");
      out.print( addressSubmoduleName );
      out.write("' );\r\n}\r\n\r\nfunction cleanParent( parentForm )\r\n{\r\n  parentForm.validated.value = \"true\"\r\n}\r\n\r\nfunction updateParent( parentForm )\r\n{\r\n\r\n  parentForm.txtSzAddrRsrcAddrStLn1");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(addressLn1);
      out.write("\";\r\n  parentForm.txtSzAddrRsrcAddrStLn2");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(addressLn2);
      out.write("\";\r\n  parentForm.txtSzAddrRsrcAddrCity");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(city);
      out.write("\";\r\n  parentForm.txtSzAddrRsrcAddrZip");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(zip5);
      out.write("\";\r\n  parentForm.txtSzAddrRsrcAddrZipSuff");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(zip4);
      out.write("\";\r\n  parentForm.selCdFacilityState");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(state);
      out.write("\";\r\n  parentForm.selCdFacilityCounty");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(validatedCountyCode);
      out.write("\";\r\n  parentForm.hdnNbrRsrcAddrLat");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(nbrRsrcAddrLat);
      out.write("\";\r\n  parentForm.hdnNbrRsrcAddrLong");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(nbrRsrcAddrLong);
      out.write("\";  \r\n}\r\n");

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

      out.write("\r\nfunction updateParsedParent( parentForm )\r\n{\r\n  ");

     String numAddress = parsedAddressRow.getAddressNumber() != null ? parsedAddressRow.getAddressNumber().toUpperCase()+" " : "";
     String strAddress = parsedAddressRow.getStreet1() != null ? parsedAddressRow.getStreet1().toUpperCase()+" " : "";
     String thoroughfare = parsedAddressRow.getThoroughFare() != null ? parsedAddressRow.getThoroughFare().toUpperCase() : "";
     String parsedState = parsedAddressRow.getState() != null ? parsedAddressRow.getState() : CodesTables.CSTATE_GA;
  
      out.write("\r\n  parentForm.txtSzAddrRsrcAddrStLn1");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print( FormattingHelper.formatString( numAddress + strAddress + thoroughfare ));
      out.write("\";\r\n  parentForm.txtSzAddrRsrcAddrStLn2");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print( FormattingHelper.formatString( parsedAddressRow.getStreet2() ));
      out.write("\";\r\n  parentForm.txtSzAddrRsrcAddrCity");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print( FormattingHelper.formatString( parsedAddressRow.getCity() ));
      out.write("\";\r\n  parentForm.txtSzAddrRsrcAddrZip");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(parsedZip5);
      out.write("\";\r\n  parentForm.txtSzAddrRsrcAddrZipSuff");
      out.print( addressSubmoduleName );
      out.write(".value = \"");
      out.print(parsedZip4);
      out.write("\";\r\n  parentForm.selCdFacilityState");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print( FormattingHelper.formatString( parsedState ));
      out.write("\";\r\n  parentForm.selCdFacilityCounty");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print( FormattingHelper.formatString( parsedAddressRow.getCountyCode() ));
      out.write("\";\r\n  parentForm.hdnNbrRsrcAddrLat");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(nbrRsrcAddrLat);
      out.write("\";\r\n  parentForm.hdnNbrRsrcAddrLong");
      out.print(addressSubmoduleName);
      out.write(".value = \"");
      out.print(nbrRsrcAddrLong);
      out.write("\";  \r\n\r\n  //parentForm.");
      out.print( addressSubmoduleName + AddressBean.COUNTY );
      out.write(".value = \"");
      out.print( parsedAddressRow.getCountyCode() );
      out.write("\";\r\n}\r\n</script>\r\n<span class=\"formErrorText\">");
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
        
      out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"yesOnSave('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnYes.gif\" name=\"Yes\" tabIndex=\"1\"></a>\r\n          </td></tr>\r\n          <tr><td>\r\n            <a href=\"#\" onClick=\"noOnSave('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnNo.gif\" name=\"No\" tabIndex=\"2\"></a>\r\n          </td></tr>\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"cancelOnSave('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnCancel.gif\" name=\"Cancel\" tabIndex=\"3\"></a>\r\n          </td></tr>\r\n        </table>\r\n        ");

        }
        //If Validate was clicked
        else
        {
        
      out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"yesOnValidate('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n              border=\"0\" src=\"/grnds-docs/images/shared/btnYes.gif\" name=\"Yes\" tabIndex=\"1\"></a>\r\n          </td></tr>\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"noOnValidate('");
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
        
      out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"noOnSave('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnYes.gif\" name=\"Yes\" tabIndex=\"1\"></a>\r\n          </td></tr>\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"cancelOnSave('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnCancel.gif\" name=\"Cancel\" tabIndex=\"3\"></a>\r\n          </td></tr>\r\n        </table>\r\n        ");

        }
        //If Validate was clicked
        else
        {
        
      out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n          <tr><td>\r\n          <a href=\"#\" onClick=\"noOnValidate('");
      out.print(sOriginatedWindow);
      out.write("');\"><img class=\"md\"\r\n            border=\"0\" src=\"/grnds-docs/images/shared/btnClose.gif\" name=\"Ok\" tabIndex=\"3\"></a>\r\n          </td></tr>\r\n        </table>\r\n      ");

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
