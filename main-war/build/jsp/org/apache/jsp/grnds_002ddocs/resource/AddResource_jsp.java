package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.ArrayList;
import java.util.Hashtable;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ORSResourceDetailConversation;

public final class AddResource_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**
 * JSP Name:     AddResource.jsp
 * Created by:   Habib
 * Date Created: 08/08/02
 *
 * Description:
 * This page allows a user to Add a Resource and it's Detail, Primary Address
 * and Primary Phone Information.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  04/07/04  Linda Reed        SIR 22639 - added Resource LEGAL NAME field.
  06/16/04  gerryc            SIR 16091 - Added VendorID constraint to Vendor
                              ID fields.  Vendor ID must be 14 characters,
                              starting with 11 numbers.
  12/05/08  charden			  STGAP00010540 - modified 'email address' field to accept 100 characters
  12/05/08  charden			  STGAP00010539 - modified 'legal name' field to accept 60 characters
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String pageMode = PageModeConstants.EDIT;

  /** - Resource Detail - */
  String txtNmResource = "";
  String selCdRsrcType = "";
  String selCdRsrcMaintainer = "";
  String selCdRsrcStatus = "01";
  String txtNmRsrcContact = "";
  String selCdRsrcOwnership = "";
  String selCdRsrcCampusType = "";
  String selCdRsrcFacilType = "";
  String selCdRsrcHubType = "";
  String selCdMhmrCompCode = "";
  String cbxCIndRsrcTransport = "false";
  String txtTxtRsrcComments = "";
  //String facilityDropDownCodeTable = "";
  String txtNmRsrcContactTitle = "";
  String txtNationalProviderNumber = "";
  String txtEmailAddress= "";
  String txtWebAddress= "" ;
  String schoolType= "";
  String schoolDistrict= "";
  String paymentDelivery= "";
  String transport = "false";
  String szCReqFuncCd = "";
  String szIdORSFacility = "";
  
  //SIR 22639 - add data element LEGAL NAME
  String txtNmLegal = "";

  /**-HIDDEN FIELDS-*/
    szCReqFuncCd = ContextHelper.getStringSafe( request, "szCReqFuncCd");

  // Get fields from request in case of error being returned to page or page reloading to populate school district
  if( request.getParameter("txtNmResource") != null )
  {
    txtNmResource = request.getParameter("txtNmResource");
  }
  if( request.getParameter("selCdRsrcType") != null )
  {
    selCdRsrcType = request.getParameter("selCdRsrcType");
  }
  if( request.getParameter("selCdRsrcMaintainer") != null )
  {
    selCdRsrcMaintainer = request.getParameter("selCdRsrcMaintainer");
  }
  if( request.getParameter("selCdRsrcStatus") != null )
  {
    selCdRsrcStatus = request.getParameter("selCdRsrcStatus");
  }
  if( request.getParameter("txtNmRsrcContact") != null )
  {
    txtNmRsrcContact = request.getParameter("txtNmRsrcContact");
  }
  if( request.getParameter("selCdRsrcOwnership") != null )
  {
    selCdRsrcOwnership = request.getParameter("selCdRsrcOwnership");
  }
  if( request.getParameter("selCdRsrcCampusType") != null )
  {
    selCdRsrcCampusType = request.getParameter("selCdRsrcCampusType");
  }
  if( request.getParameter("selCdRsrcHubType") != null )
  {
    selCdRsrcHubType = request.getParameter("selCdRsrcHubType");
  }
  if( request.getParameter("selCdMhmrCompCode") != null )
  {
    selCdMhmrCompCode = request.getParameter("selCdMhmrCompCode");
  }
  if( request.getParameter("cbxCIndRsrcTransport") != null && "1".equals(request.getParameter("cbxCIndRsrcTransport")) )
  {
    cbxCIndRsrcTransport = "true";
  }
  if( request.getParameter("txtTxtRsrcComments") != null )
  {
    txtTxtRsrcComments = request.getParameter("txtTxtRsrcComments");
  }
  if( request.getParameter("selCdRsrcFacilType") != null )
  {
    selCdRsrcFacilType = request.getParameter("selCdRsrcFacilType");
  }
  //SIR 22639 - add data element LEGAL NAME
  if( request.getParameter("txtNmLegal") != null )
  {
    txtNmLegal = request.getParameter("txtNmLegal");
  }
  
  if ( request.getParameter("txtNmRsrcContactTitle") != null)
  {
    txtNmRsrcContactTitle=request.getParameter("txtNmRsrcContactTitle");
  }
  
   if ( request.getParameter("txtNationalProviderNumber") != null)
  {
    txtNationalProviderNumber=request.getParameter("txtNationalProviderNumber");
  }
  
   if ( request.getParameter("txtEmailAddress") != null)
  {
    txtEmailAddress=request.getParameter("txtEmailAddress");
  }
  
   if ( request.getParameter("txtWebAddress") != null)
  {
    txtWebAddress=request.getParameter("txtWebAddress");
  }
  
   if ( request.getParameter("schoolType") != null)
  {
    schoolType=request.getParameter("schoolType");
  }
  
   if ( request.getParameter("schoolDistrict") != null)
  {
    schoolDistrict=request.getParameter("schoolDistrict");
  }
  
   if ( request.getParameter("paymentDelivery") != null)
  {
    paymentDelivery=request.getParameter("paymentDelivery");
  }
  
  
   if ( request.getParameter("transport") != null)
  {
    paymentDelivery=request.getParameter("transport");
  }
  
  if(request.getParameter(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME) != null) 
  {
  	szIdORSFacility = request.getParameter(ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME);
  }

  
  String addressSubmoduleName = "";
  AddressBean addressBean = new AddressBean(addressSubmoduleName);
  addressBean.setAddressSubmoduleName(addressSubmoduleName);
  String address1Name = addressBean.getAttributeName( AddressBean.ADDRESS1 );
  String address2Name = addressBean.getAttributeName( AddressBean.ADDRESS2 );
  String cityName = addressBean.getAttributeName( AddressBean.CITY );
  String stateName = addressBean.getAttributeName( AddressBean.STATE );
  String zipName = addressBean.getAttributeName( AddressBean.ZIP );
  String zipSuffName = addressBean.getAttributeName( AddressBean.ZIP_SUFF );
  String countyName = addressBean.getAttributeName( AddressBean.COUNTY );  
     
  /** - Address Detail - */
  String txtSzAddrRsrcAddrAttn = "";
  String txtSzAddrRsrcAddrStLn1 = "";
  String txtSzAddrRsrcAddrStLn2 = "";
  String txtSzAddrRsrcAddrZip = "";
  String txtSzAddrRsrcAddrZipSuff = "";
  String txtSzAddrRsrcAddrCity = "";
  String selCdFacilityState = "GA";
  String selCdFacilityCounty = "";
  String selCdRsrcAddrSchDist = "";
  String txtSzNbrRsrcAddrVid = "";
  String txtSzTxtRsrcAddrComments = "";
  String validatedValue = "false";
  // Get fields from request in case of error being returned to page or page reloading to populate school district
  if( request.getParameter("txtSzAddrRsrcAddrAttn") != null )
  {
    txtSzAddrRsrcAddrAttn = request.getParameter("txtSzAddrRsrcAddrAttn");
  }
  if( request.getParameter(address1Name) != null )
  {
    txtSzAddrRsrcAddrStLn1 = request.getParameter(address1Name);
  }
  if( request.getParameter(address2Name) != null )
  {
    txtSzAddrRsrcAddrStLn2 = request.getParameter(address2Name);
  }
  if( request.getParameter(zipName) != null )
  {
    txtSzAddrRsrcAddrZip = request.getParameter(zipName);
  }
  if( request.getParameter(zipSuffName) != null )
  {
    txtSzAddrRsrcAddrZipSuff = request.getParameter(zipSuffName);
  }
  if( request.getParameter(cityName) != null )
  {
    txtSzAddrRsrcAddrCity = request.getParameter(cityName);
  }
  if( request.getParameter(stateName) != null )
  {
    selCdFacilityState = request.getParameter(stateName);
  }
  // If other than Georgia show only out of state in county drop down.
 
    if( request.getParameter(countyName) != null )
  {
    selCdFacilityCounty = request.getParameter(countyName);
  }
  if( request.getParameter("txtNbrRsrcAddrVid") != null )
  {
    txtSzNbrRsrcAddrVid = request.getParameter("txtNbrRsrcAddrVid");
  }
  if( request.getParameter("txtSzTxtRsrcAddrComments") != null )
  {
    txtSzTxtRsrcAddrComments = request.getParameter("txtSzTxtRsrcAddrComments");
  }
  if( request.getParameter("validated") != null )
  {
    validatedValue = request.getParameter("validated");
  }
  
  /** - Phone Detail - */
  String szLNbrFacilPhoneNumber = "";
  String szLNbrFacilPhoneExtension = "";
  String szSzTxtRsrcPhoneComments = "";
  String selSzCdFacilPhoneType = "";
  // Get fields from request in case of error being returned to page or page reloading to populate school district
  if( request.getParameter("selSzCdFacilPhoneType")!=null )
  {
    selSzCdFacilPhoneType = request.getParameter("selSzCdFacilPhoneType");
  }
  if( request.getParameter("txtLNbrFacilPhoneNumber")!=null )
  {
    szLNbrFacilPhoneNumber =  FormattingHelper.formatPhone(request.getParameter("txtLNbrFacilPhoneNumber"));
  }
  if( request.getParameter("txtLNbrFacilPhoneExtension")!=null )
  {
    szLNbrFacilPhoneExtension = request.getParameter("txtLNbrFacilPhoneExtension");
  }
  if( request.getParameter("txtszTxtRsrcPhoneComments")!=null )
  {
    szSzTxtRsrcPhoneComments = request.getParameter("txtszTxtRsrcPhoneComments");
  }

 
  
  ArrayList excludeCodeArrayCfactyp4 = new ArrayList();
  excludeCodeArrayCfactyp4.add(CodesTables.CFACTYP4_70);
  excludeCodeArrayCfactyp4.add(CodesTables.CFACTYP4_71);
  
  ArrayList excludeOutOfStateOption = new ArrayList();
  excludeOutOfStateOption.add(CodesTables.CREGIONS_97);

 String addressOnChange = "javascript:changeValidAddress('frmAddResource', '"+ addressBean.getAddressSubmoduleName() +"')";
 //String saveFunction = "return validateAddressOnSave('frmAddResource', '/resource/ResourceDetail/addResource', '"+ addressBean.getAddressSubmoduleName() +"', 'btnSaveResource');";
 String saveFunction ="return saveWithValidate();";
 //String addressOnChange = "return unValidate();";

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n");

  int tabIndex = 1;

      out.write("\r\n\r\n\r\n\r\n /*\r\n  *This function is called when the page loads.\r\n  */\r\nwindow.onload = function ()\r\n{\r\n\r\n   ");
if( request.getParameter( "cbxCIndRsrcTransport" ) != null && "1".equals(request.getParameter( "cbxCIndRsrcTransport" )) ){
      out.write("\r\n     document.frmAddResource.cbxCIndRsrcTransport.checked = true;\r\n     document.frmAddResource.cbxCIndRsrcTransport.defaultChecked = true;\r\n   ");
}
      out.write("\r\n     \r\n    ");
 if ( StringHelper .isValid( selCdRsrcFacilType ) )
     {
      out.write("  \r\n  \t\t document.frmAddResource.selCdRsrcFacilType.value = '");
      out.print( selCdRsrcFacilType );
      out.write("';\r\n   ");
}
      out.write("\r\n};\r\n\r\n /*\r\n  *This function is called before the page unloads.\r\n  */\r\nwindow.onbeforeunload = function ()\r\n{\r\n    IsDirty();\r\n};\r\n\r\n\r\n//function openValidateWindowSave()\r\n//{\r\n//  var x = document.frmAddResource;\r\n//  x.hdnSaveOrValidate.value = 'save';\r\n//  openValidateWindow();\r\n//}\r\n\r\n//function openValidateWindowValidate()\r\n//{\r\n//  var x = document.frmAddResource;\r\n//  x.hdnSaveOrValidate.value = 'validate';\r\n//  openValidateWindow();\r\n//}\r\n\r\nfunction saveWithValidate()\r\n{\r\n  var x = document.frmAddResource;\r\n \r\n  if (x.validated.value == 'false')\r\n  {// newResource\r\n    x.hdnSaveOrValidate.value = 'save';\r\n    return validateAddressOnSave('frmAddResource', '/resource/ResourceDetail/addResource', '");
      out.print(addressBean.getAddressSubmoduleName());
      out.write("', 'btnSaveResource');\r\n  }  \r\n  return saveNewResource();  \r\n}\r\n\r\n /*\r\n  *This function populates drop down boxes with options.\r\n  */\r\nfunction saveNewResource(){\r\n    window.onbeforeunload = null;\r\n    var x = document.frmAddResource;\r\n    document.frmAddResource.cReqFuncCd.value = 'A';\r\n\r\n    if( x.cbxCIndRsrcTransport.checked )\r\n    {\r\n       x.cbxCIndRsrcTransport.value = \"1\";\r\n    }\r\n    x.action = \"/resource/ResourceDetail/newResource\";\r\n        \r\n      return true;\r\n}\r\n\r\n\r\n /*\r\n  * This function sets the value of cbxCIndRsrcTransport to 1 if it is checked\r\n  */\r\n  function setCbxCIndRsrcTransport( pageItem ){\r\n     if( pageItem.checked )\r\n       pageItem.value = \"1\";\r\n     else\r\n       pageItem.value = \"0\"; \r\n  }\r\n  \r\n  \r\n /*\r\n  *This function opens the address validation window.\r\n  */\r\nfunction openValidateWindow()\r\n{\r\n  var x = document.frmAddResource;\r\n  var streetLn1 = escape( x.txtSzAddrRsrcAddrStLn1.value.replace('#', ' '));\r\n  var streetLn2 = escape( x.txtSzAddrRsrcAddrStLn2.value.replace('#', ' '));\r\n");
      out.write("  var city = escape( x.txtSzAddrRsrcAddrCity.value.replace('#', ' '));\r\n  var zip = escape( x.txtSzAddrRsrcAddrZip.value.replace('#', ' '));\r\n  var zipSuff = escape( x.txtSzAddrRsrcAddrZipSuff.value.replace('#', ' '));\r\n  window.open('/common/AddressValidation/validate?txtSzAddrRsrcAddrStLn1='+streetLn1+'&txtSzAddrRsrcAddrStLn2='+streetLn2+'&txtSzAddrRsrcAddrCity='+city+'&selCdFacilityState='+x.selCdFacilityState.value+'&txtSzAddrRsrcAddrZip='+zip+'&selCdFacilityCounty='+x.selCdFacilityCounty.value+'&frmWindowName='+x.frmWindowName.value+'&addressMultCounty='+x.addressMultCounty.value+'&");
      out.print( AddressBean.SAVE_OR_VALIDATE );
      out.write("='+x.hdnSaveOrValidate.value,\r\n              'newWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=400,height=250');\r\n}\r\n\r\n  /*\r\n  *This function populates drop down boxes with options.\r\n  * param field: Name of drop down box to be populated\r\n  * param val: Value of last selected option on dropdown box\r\n  * param cat: Array containing the values to populate drop down options\r\n  */\r\n  function populateDropdown(field, val, cat)\r\n  {\r\n    //sets the drop-down box to the length of the array +1\r\n    eval(\"document.frmAddResource.\"+field+\".options.length =cat.length\");\r\n    for (var q=0; q < cat.length; q++)\r\n    {\r\n      //populates the drop-down box with the values from the CodeDecodeCache\r\n             eval(\"document.frmAddResource.\"+field+\".options[q].value = cat[q].substring(0,cat[q].indexOf(\\\"|\\\"))\");\r\n             eval(\"document.frmAddResource.\"+field+\".options[q].text = cat[q].substring(cat[q].indexOf(\\\"|\\\")+1,cat[q].length)\");\r\n        }\r\n        eval(\"document.frmAddResource.\"+field+\".value =\\\"\"+val+\"\\\"\");\r\n");
      out.write("  }\r\n\r\n /*\r\n  *This function clears drop down boxes of all options.\r\n  *@ param field: Name of drop down box to be cleard of all options\r\n  */\r\n  function clearDropdown(field)\r\n  {\r\n     //sets the values of all options to blank, and changes the number of options to 1\r\n     var fieldLength = eval(\"document.frmAddResource.\"+field+\".options.length\");\r\n     for (var b=0; b < fieldLength; b++)\r\n     {\r\n       //empties the facility type drop-down box\r\n       eval(\"document.frmAddResource.\"+field+\".options[b].value = \\\"\\\";\");\r\n       eval(\"document.frmAddResource.\"+field+\".options[b].text = \\\"\\\";\");\r\n     }\r\n\r\n     eval(\"document.frmAddResource.\"+field+\".options.length = 1\");\r\n  }\r\n\r\nfunction unValidate()\r\n{\r\n  document.frmAddResource.validated.value=\"false\";\r\n}\r\n// This function sets the value of County Dropdown to 999 if State is otherthan GA.\r\n  function checkCountyForOutOfState()\r\n{\r\n  if(window.document.frmAddResource.");
      out.print( stateName );
      out.write("[window.document.frmAddResource.");
      out.print( stateName );
      out.write(".selectedIndex].value != \"GA\")\r\n  {\r\n      for (var i=0, l=window.document.frmAddResource.");
      out.print( countyName );
      out.write(".options.length;i<l;i++)\r\n      {\r\n          if(window.document.frmAddResource.");
      out.print( countyName );
      out.write(".options[i].value != \"999\")\r\n          {\r\n              var optionName = new Option(window.document.frmAddResource.");
      out.print( countyName );
      out.write(".options[i].text, window.document.frmAddResource.");
      out.print( countyName );
      out.write(".options[i].value, false, false);\r\n              window.document.frmAddResource.hiddenAddressCounty.options[window.document.frmAddResource.hiddenAddressCounty.length] = optionName;\r\n          }\r\n      }\r\n\t  window.document.frmAddResource.");
      out.print( countyName );
      out.write(".length = 0;\r\n\t  var optionName = new Option(\"Out of State\", \"999\", true, true);\r\n\t  window.document.frmAddResource.");
      out.print( countyName );
      out.write(".options[window.document.frmAddResource.");
      out.print( countyName );
      out.write(".length] = optionName;\r\n  }\r\n  else\r\n  {\r\n      window.document.frmAddResource.");
      out.print( countyName );
      out.write(".length = 0;\r\n     for (var i=0, l=window.document.frmAddResource.hiddenAddressCounty.options.length;i<l;i++)\r\n\t        {\r\n\t            var optionName = new Option(window.document.frmAddResource.hiddenAddressCounty.options[i].text, window.document.frmAddResource.hiddenAddressCounty.options[i].value, false, false);\r\n\t            window.document.frmAddResource.");
      out.print( countyName );
      out.write(".options[window.document.frmAddResource.");
      out.print( countyName );
      out.write(".length] = optionName;\r\n\t        }\r\n\t  \t  window.document.frmAddResource.hiddenAddressCounty.length = 0;\r\n  }\r\n}\r\n\r\n\r\n\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAddResource");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceDetail/addResource");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.AddResourceCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode(PageModeConstants.EDIT);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("validated");
          _jspx_th_impact_validateInput_0.setValue(validatedValue);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n    <th colspan=\"7\">\r\n      <label id=\"label_Resource_Detail\" for=\"Resource Detail\">\r\n        Resource Detail\r\n      </label>\r\n    </th>\r\n    <tr>\r\n      <td width=\"15%\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setValue(txtNmResource);
          _jspx_th_impact_validateInput_6.setName("txtNmResource");
          _jspx_th_impact_validateInput_6.setLabel("Resource Name");
          _jspx_th_impact_validateInput_6.setRequired("true");
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setMaxLength("30");
          _jspx_th_impact_validateInput_6.setSize("30");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n      </td>\r\n\r\n    </tr>\r\n    <!-- SIR 22639 - add data element CAPS_RESOURCE.LEGAL_NAME -->\r\n    <tr>\r\n      <td width=\"15%\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setColspan("3");
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setRequired("true");
          _jspx_th_impact_validateInput_7.setValue(txtNmLegal);
          _jspx_th_impact_validateInput_7.setName("txtNmLegal");
          _jspx_th_impact_validateInput_7.setLabel("Legal Name");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_7.setMaxLength("45");
          _jspx_th_impact_validateInput_7.setSize("45");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selCdRsrcType");
          _jspx_th_impact_validateSelect_0.setCodesTable("CRSCTYPE");
          _jspx_th_impact_validateSelect_0.setValue(selCdRsrcType);
          _jspx_th_impact_validateSelect_0.setLabel("Resource Type");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        <!-- Per defect STGAP00002641, removed exclusion of Statewide option -->\r\n        ");
          out.write("\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selCdRsrcMaintainer");
          _jspx_th_impact_validateSelect_1.setCodesTable("CREGIONS");
          _jspx_th_impact_validateSelect_1.setExcludeOptions(excludeOutOfStateOption);
          _jspx_th_impact_validateSelect_1.setValue(selCdRsrcMaintainer);
          _jspx_th_impact_validateSelect_1.setLabel("Maintainer");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("selCdRsrcStatus");
          _jspx_th_impact_validateSelect_2.setValue(selCdRsrcStatus);
          _jspx_th_impact_validateSelect_2.setCodesTable("CRSCSTAT");
          _jspx_th_impact_validateSelect_2.setLabel("Status");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setName("txtNmRsrcContact");
          _jspx_th_impact_validateInput_8.setValue(txtNmRsrcContact);
          _jspx_th_impact_validateInput_8.setLabel("Contact Name");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_8.setMaxLength("25");
          _jspx_th_impact_validateInput_8.setSize("25");
          _jspx_th_impact_validateInput_8.setConstraint("Name");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName("selCdRsrcOwnership");
          _jspx_th_impact_validateSelect_3.setCodesTable("COWNSHIP");
          _jspx_th_impact_validateSelect_3.setLabel("Ownership");
          _jspx_th_impact_validateSelect_3.setValue(selCdRsrcOwnership);
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setValue(txtNmRsrcContactTitle);
          _jspx_th_impact_validateInput_9.setName("txtNmRsrcContactTitle");
          _jspx_th_impact_validateInput_9.setLabel("Contact Title");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setMaxLength("30");
          _jspx_th_impact_validateInput_9.setSize("30");
          _jspx_th_impact_validateInput_9.setConstraint("Name30");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setName("selCdRsrcFacilType");
          _jspx_th_impact_validateSelect_4.setValue(selCdRsrcFacilType);
          _jspx_th_impact_validateSelect_4.setCodesTable("CFACTYP4");
          _jspx_th_impact_validateSelect_4.setBlankValue("true");
          _jspx_th_impact_validateSelect_4.setLabel("Facility Type");
          _jspx_th_impact_validateSelect_4.setExcludeOptions(excludeCodeArrayCfactyp4);
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setStyle("WIDTH: 180px");
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n      </td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setValue(txtNationalProviderNumber);
          _jspx_th_impact_validateInput_10.setName("txtNationalProviderNumber");
          _jspx_th_impact_validateInput_10.setLabel("National Provider Number");
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_10.setMaxLength("20");
          _jspx_th_impact_validateInput_10.setSize("20");
          _jspx_th_impact_validateInput_10.setConstraint("AlphaNumeric");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setValue(txtEmailAddress);
          _jspx_th_impact_validateInput_11.setName("txtEmailAddress");
          _jspx_th_impact_validateInput_11.setLabel("Email Address");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setMaxLength("100");
          _jspx_th_impact_validateInput_11.setSize("50");
          _jspx_th_impact_validateInput_11.setConstraint("Email");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setColspan("3");
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setValue(txtWebAddress);
          _jspx_th_impact_validateInput_12.setName("txtWebAddress");
          _jspx_th_impact_validateInput_12.setLabel("Web Address");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_12.setMaxLength("100");
          _jspx_th_impact_validateInput_12.setSize("100");
          _jspx_th_impact_validateInput_12.setConstraint("URL");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setName("selCdSchoolType");
          _jspx_th_impact_validateSelect_5.setCodesTable("CSCHTYPE");
          _jspx_th_impact_validateSelect_5.setValue(schoolType);
          _jspx_th_impact_validateSelect_5.setLabel("School Type");
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_5.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setName("selCdSchoolDist");
          _jspx_th_impact_validateSelect_6.setCodesTable("CSCHDSTR");
          _jspx_th_impact_validateSelect_6.setValue(schoolDistrict);
          _jspx_th_impact_validateSelect_6.setLabel("School District");
          _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_6.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_7.setName("selPaymentDelivery");
          _jspx_th_impact_validateSelect_7.setCodesTable("CPAYDELI");
          _jspx_th_impact_validateSelect_7.setValue(paymentDelivery);
          _jspx_th_impact_validateSelect_7.setLabel("Payment Method");
          _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_7.setBlankValue("true");
          int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
          if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td class=\"formLabel\" colspan=\"2\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setName("cbxCIndRsrcTransport");
          _jspx_th_impact_validateInput_13.setChecked(transport);
          _jspx_th_impact_validateInput_13.setValue("0");
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_13.setOnClick("setCbxCIndRsrcTransport(this);");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        Transportation Provided\r\n      </td>\r\n\r\n    </tr>\r\n\r\n\r\n    <tr>\r\n      <td class=\"formLabel\" colspan=1 valign=\"top\">\r\n        Comments:\r\n      </td>\r\n      <td colspan=\"5\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtTxtRsrcComments");
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setCols("100");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(txtTxtRsrcComments);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <!-- End Resource Detail -->\r\n  <!-- BEGIN THE ADDRESS/PHONE DETAIL NOW -->\r\n  <br />\r\n  \r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n    <th colspan=\"7\">\r\n      <label id=\"label_Primary_Address_Detail\" for=\"Primary Address Detail\">\r\n        Primary Address Detail\r\n      </label>\r\n    </th>\r\n\r\n    <a name=\"countyPop\"></a>\r\n    <!--<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" height=\"200\">-->\r\n    <tr align=left valign=top>\r\n      <td width=\"15%\">\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_8.setName("selCdRsrcAddrType");
          _jspx_th_impact_validateSelect_8.setLabel("Type");
          _jspx_th_impact_validateSelect_8.setRequired("true");
          _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_8.setDisabled("true");
          _jspx_th_impact_validateSelect_8.setCodesTable("CRSCADDR");
          _jspx_th_impact_validateSelect_8.setValue("01");
          int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
          if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n    </tr>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("txtNbrRsrcAddrVid");
          _jspx_th_impact_validateInput_14.setValue(txtSzNbrRsrcAddrVid);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("text");
          _jspx_th_impact_validateInput_15.setName("txtNbrRsrcAddrVidDisplay");
          _jspx_th_impact_validateInput_15.setLabel("Vendor ID");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setDisabled("true");
          _jspx_th_impact_validateInput_15.setValue(txtSzNbrRsrcAddrVid);
          _jspx_th_impact_validateInput_15.setConstraint("VendorID");
          _jspx_th_impact_validateInput_15.setMaxLength("8");
          _jspx_th_impact_validateInput_15.setSize("8");
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("text");
          _jspx_th_impact_validateInput_16.setName("txtSzAddrRsrcAddrAttn");
          _jspx_th_impact_validateInput_16.setLabel("Attention");
          _jspx_th_impact_validateInput_16.setCssClass("formInput");
          _jspx_th_impact_validateInput_16.setValue(txtSzAddrRsrcAddrAttn);
          _jspx_th_impact_validateInput_16.setConstraint("Name");
          _jspx_th_impact_validateInput_16.setSize("16");
          _jspx_th_impact_validateInput_16.setMaxLength("30");
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("text");
          _jspx_th_impact_validateInput_17.setRequired("true");
          _jspx_th_impact_validateInput_17.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_17.setName( address1Name );
          _jspx_th_impact_validateInput_17.setLabel("Address Ln 1");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setValue(txtSzAddrRsrcAddrStLn1);
          _jspx_th_impact_validateInput_17.setConstraint("Address");
          _jspx_th_impact_validateInput_17.setSize("21");
          _jspx_th_impact_validateInput_17.setMaxLength("30");
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setName( address2Name );
          _jspx_th_impact_validateInput_18.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_18.setLabel("Address Ln 2");
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          _jspx_th_impact_validateInput_18.setValue(txtSzAddrRsrcAddrStLn2);
          _jspx_th_impact_validateInput_18.setConstraint("Address");
          _jspx_th_impact_validateInput_18.setSize("21");
          _jspx_th_impact_validateInput_18.setMaxLength("30");
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setRequired("true");
          _jspx_th_impact_validateInput_19.setName( cityName );
          _jspx_th_impact_validateInput_19.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_19.setLabel("City");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          _jspx_th_impact_validateInput_19.setValue(txtSzAddrRsrcAddrCity);
          _jspx_th_impact_validateInput_19.setConstraint("City");
          _jspx_th_impact_validateInput_19.setSize("21");
          _jspx_th_impact_validateInput_19.setMaxLength("20");
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr align=left valign=top>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_9.setName( stateName );
          _jspx_th_impact_validateSelect_9.setOnChange("javascript:checkCountyForOutOfState();");
          _jspx_th_impact_validateSelect_9.setLabel("State");
          _jspx_th_impact_validateSelect_9.setCodesTable("CSTATE");
          _jspx_th_impact_validateSelect_9.setValue(selCdFacilityState);
          _jspx_th_impact_validateSelect_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
          if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("text");
          _jspx_th_impact_validateInput_20.setName( zipName );
          _jspx_th_impact_validateInput_20.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_20.setLabel("Zip");
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          _jspx_th_impact_validateInput_20.setValue(txtSzAddrRsrcAddrZip);
          _jspx_th_impact_validateInput_20.setRequired("true");
          _jspx_th_impact_validateInput_20.setMaxLength("5");
          _jspx_th_impact_validateInput_20.setSize("5");
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_20.setConstraint("Digit5");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        -\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("text");
          _jspx_th_impact_validateInput_21.setName( zipSuffName );
          _jspx_th_impact_validateInput_21.setOnChange( addressOnChange );
          _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          _jspx_th_impact_validateInput_21.setValue(txtSzAddrRsrcAddrZipSuff);
          _jspx_th_impact_validateInput_21.setConstraint("Digit4");
          _jspx_th_impact_validateInput_21.setMaxLength("4");
          _jspx_th_impact_validateInput_21.setSize("4");
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        &nbsp;\r\n        \r\n      ");

      String function = "javascript:setIsDirtyCalled(true);" +
                        "launchAddressValidate('frmAddResource', 'validate', '" +
                        addressBean.getAddressSubmoduleName() + "');return false;";
  
          out.write("  \r\n    &nbsp;");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnValidateAddress");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction(function);
          _jspx_th_impact_ButtonTag_0.setForm("frmAddResource");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ResourceDetail/addResource");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \r\n    </td>\r\n    </tr>\r\n    ");

    List excludeList = new ArrayList();
    if(selCdFacilityState != null && selCdFacilityState.equals("GA"))
    {
        excludeList.add("999");
    }
    
          out.write("\r\n    \r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_10.setName( countyName );
          _jspx_th_impact_validateSelect_10.setLabel("County");
          _jspx_th_impact_validateSelect_10.setRequired("true");
          _jspx_th_impact_validateSelect_10.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_10.setExcludeOptions( excludeList );
          _jspx_th_impact_validateSelect_10.setValue(selCdFacilityCounty);
          _jspx_th_impact_validateSelect_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_10.setOnChange( addressOnChange );
          int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
          if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <select name=\"hiddenAddressCounty\" style=\"display:none;\">\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td class=\"formLabel\" colspan=\"1\" valign=\"top\">\r\n        Comments:\r\n      </td>\r\n      <td colspan=\"5\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setCols("100");
          _jspx_th_impact_validateTextArea_1.setRows("4");
          _jspx_th_impact_validateTextArea_1.setName("txtszTxtRsrcAddrComments");
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(txtSzTxtRsrcAddrComments);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n\r\n  <br />\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\">\r\n    <th colspan=\"7\">\r\n      <label id=\"label_Primary_Phone_Detail\" for=\"Primary Phone Detail\">\r\n        Primary Phone Detail\r\n      </label>\r\n    </th>\r\n\r\n    <!--<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" style=\"WIDTH: 760 px; HEIGHT: 100px\">-->\r\n    <tr align=left valign=top>\r\n      <td width=\"15%\">\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_11.setLabel("Type");
          _jspx_th_impact_validateSelect_11.setRequired("true");
          _jspx_th_impact_validateSelect_11.setName("selSzCdFacilPhoneType");
          _jspx_th_impact_validateSelect_11.setValue("01");
          _jspx_th_impact_validateSelect_11.setDisabled("true");
          _jspx_th_impact_validateSelect_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_11.setCodesTable("CRSCPHON");
          int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
          if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("text");
          _jspx_th_impact_validateInput_22.setLabel("Phone");
          _jspx_th_impact_validateInput_22.setRequired("true");
          _jspx_th_impact_validateInput_22.setName("txtLNbrFacilPhoneNumber");
          _jspx_th_impact_validateInput_22.setValue(szLNbrFacilPhoneNumber);
          _jspx_th_impact_validateInput_22.setConstraint("Phone");
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          _jspx_th_impact_validateInput_22.setSize("14");
          _jspx_th_impact_validateInput_22.setMaxLength("14");
          _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n    </tr>\r\n    <tr align=left valign=top>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("text");
          _jspx_th_impact_validateInput_23.setLabel("Ext");
          _jspx_th_impact_validateInput_23.setName("txtLNbrFacilPhoneExtension");
          _jspx_th_impact_validateInput_23.setValue(szLNbrFacilPhoneExtension);
          _jspx_th_impact_validateInput_23.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          _jspx_th_impact_validateInput_23.setSize("8");
          _jspx_th_impact_validateInput_23.setMaxLength("8");
          _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td class=\"formLabel\" colspan=1 valign=\"top\">\r\n        Comments:\r\n      </td>\r\n      <td colspan=\"5\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setCols("100");
          _jspx_th_impact_validateTextArea_2.setRows("4");
          _jspx_th_impact_validateTextArea_2.setName("txtszTxtRsrcPhoneComments");
          _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_2.setMaxLength(300);
          _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(szSzTxtRsrcPhoneComments);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br>\r\n  <hr>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n       <td align=\"right\" colspan=\"2\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveResource");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setFunction( saveFunction );
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setForm("frmAddResource");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/ResourceDetail/addResource");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
          if (_jspx_meth_impact_validateInput_24(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          if (_jspx_meth_impact_validateInput_25(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("hidden");
          _jspx_th_impact_validateInput_26.setName( AddressBean.ADDRESS_SUBMODULE_NAME );
          _jspx_th_impact_validateInput_26.setValue( addressBean.getAddressSubmoduleName() );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("hidden");
          _jspx_th_impact_validateInput_27.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
          _jspx_th_impact_validateInput_27.setValue("true");
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("hidden");
          _jspx_th_impact_validateInput_28.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
          _jspx_th_impact_validateInput_28.setValue("true");
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("hidden");
          _jspx_th_impact_validateInput_29.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
          _jspx_th_impact_validateInput_29.setValue("");
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("hidden");
          _jspx_th_impact_validateInput_30.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
          _jspx_th_impact_validateInput_30.setValue("");
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("hidden");
          _jspx_th_impact_validateInput_31.setName( ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME );
          _jspx_th_impact_validateInput_31.setValue(szIdORSFacility);
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <!--EndMain Content-->\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnSaveOrValidate");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("cReqFuncCd");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("frmWindowName");
    _jspx_th_impact_validateInput_3.setValue("frmAddResource");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("validationOverride");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("addressMultCounty");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_24(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_24.setType("hidden");
    _jspx_th_impact_validateInput_24.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_24.setValue("0");
    int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
    if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_25(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_25.setType("hidden");
    _jspx_th_impact_validateInput_25.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_25.setValue("0");
    int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
    if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
