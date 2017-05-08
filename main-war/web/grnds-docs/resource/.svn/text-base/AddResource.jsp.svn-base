<%
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
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.ORSResourceDetailConversation"%>

<%
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
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/addressValidation.js"></script>
<script type="text/javascript" language="JavaScript1.2">

<%
  int tabIndex = 1;
%>



 /*
  *This function is called when the page loads.
  */
window.onload = function ()
{

   <%if( request.getParameter( "cbxCIndRsrcTransport" ) != null && "1".equals(request.getParameter( "cbxCIndRsrcTransport" )) ){%>
     document.frmAddResource.cbxCIndRsrcTransport.checked = true;
     document.frmAddResource.cbxCIndRsrcTransport.defaultChecked = true;
   <%}%>
     
    <% if ( StringHelper .isValid( selCdRsrcFacilType ) )
     {%>  
  		 document.frmAddResource.selCdRsrcFacilType.value = '<%= selCdRsrcFacilType %>';
   <%}%>
};

 /*
  *This function is called before the page unloads.
  */
window.onbeforeunload = function ()
{
    IsDirty();
};


//function openValidateWindowSave()
//{
//  var x = document.frmAddResource;
//  x.hdnSaveOrValidate.value = 'save';
//  openValidateWindow();
//}

//function openValidateWindowValidate()
//{
//  var x = document.frmAddResource;
//  x.hdnSaveOrValidate.value = 'validate';
//  openValidateWindow();
//}

function saveWithValidate()
{
  var x = document.frmAddResource;
 
  if (x.validated.value == 'false')
  {// newResource
    x.hdnSaveOrValidate.value = 'save';
    return validateAddressOnSave('frmAddResource', '/resource/ResourceDetail/addResource', '<%=addressBean.getAddressSubmoduleName()%>', 'btnSaveResource');
  }  
  return saveNewResource();  
}

 /*
  *This function populates drop down boxes with options.
  */
function saveNewResource(){
    window.onbeforeunload = null;
    var x = document.frmAddResource;
    document.frmAddResource.cReqFuncCd.value = 'A';

    if( x.cbxCIndRsrcTransport.checked )
    {
       x.cbxCIndRsrcTransport.value = "1";
    }
    x.action = "/resource/ResourceDetail/newResource";
        
      return true;
}


 /*
  * This function sets the value of cbxCIndRsrcTransport to 1 if it is checked
  */
  function setCbxCIndRsrcTransport( pageItem ){
     if( pageItem.checked )
       pageItem.value = "1";
     else
       pageItem.value = "0"; 
  }
  
  
 /*
  *This function opens the address validation window.
  */
function openValidateWindow()
{
  var x = document.frmAddResource;
  var streetLn1 = escape( x.txtSzAddrRsrcAddrStLn1.value.replace('#', ' '));
  var streetLn2 = escape( x.txtSzAddrRsrcAddrStLn2.value.replace('#', ' '));
  var city = escape( x.txtSzAddrRsrcAddrCity.value.replace('#', ' '));
  var zip = escape( x.txtSzAddrRsrcAddrZip.value.replace('#', ' '));
  var zipSuff = escape( x.txtSzAddrRsrcAddrZipSuff.value.replace('#', ' '));
  window.open('/common/AddressValidation/validate?txtSzAddrRsrcAddrStLn1='+streetLn1+'&txtSzAddrRsrcAddrStLn2='+streetLn2+'&txtSzAddrRsrcAddrCity='+city+'&selCdFacilityState='+x.selCdFacilityState.value+'&txtSzAddrRsrcAddrZip='+zip+'&selCdFacilityCounty='+x.selCdFacilityCounty.value+'&frmWindowName='+x.frmWindowName.value+'&addressMultCounty='+x.addressMultCounty.value+'&<%= AddressBean.SAVE_OR_VALIDATE %>='+x.hdnSaveOrValidate.value,
              'newWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=400,height=250');
}

  /*
  *This function populates drop down boxes with options.
  * param field: Name of drop down box to be populated
  * param val: Value of last selected option on dropdown box
  * param cat: Array containing the values to populate drop down options
  */
  function populateDropdown(field, val, cat)
  {
    //sets the drop-down box to the length of the array +1
    eval("document.frmAddResource."+field+".options.length =cat.length");
    for (var q=0; q < cat.length; q++)
    {
      //populates the drop-down box with the values from the CodeDecodeCache
             eval("document.frmAddResource."+field+".options[q].value = cat[q].substring(0,cat[q].indexOf(\"|\"))");
             eval("document.frmAddResource."+field+".options[q].text = cat[q].substring(cat[q].indexOf(\"|\")+1,cat[q].length)");
        }
        eval("document.frmAddResource."+field+".value =\""+val+"\"");
  }

 /*
  *This function clears drop down boxes of all options.
  *@ param field: Name of drop down box to be cleard of all options
  */
  function clearDropdown(field)
  {
     //sets the values of all options to blank, and changes the number of options to 1
     var fieldLength = eval("document.frmAddResource."+field+".options.length");
     for (var b=0; b < fieldLength; b++)
     {
       //empties the facility type drop-down box
       eval("document.frmAddResource."+field+".options[b].value = \"\";");
       eval("document.frmAddResource."+field+".options[b].text = \"\";");
     }

     eval("document.frmAddResource."+field+".options.length = 1");
  }

function unValidate()
{
  document.frmAddResource.validated.value="false";
}
// This function sets the value of County Dropdown to 999 if State is otherthan GA.
  function checkCountyForOutOfState()
{
  if(window.document.frmAddResource.<%= stateName %>[window.document.frmAddResource.<%= stateName %>.selectedIndex].value != "GA")
  {
      for (var i=0, l=window.document.frmAddResource.<%= countyName %>.options.length;i<l;i++)
      {
          if(window.document.frmAddResource.<%= countyName %>.options[i].value != "999")
          {
              var optionName = new Option(window.document.frmAddResource.<%= countyName %>.options[i].text, window.document.frmAddResource.<%= countyName %>.options[i].value, false, false);
              window.document.frmAddResource.hiddenAddressCounty.options[window.document.frmAddResource.hiddenAddressCounty.length] = optionName;
          }
      }
	  window.document.frmAddResource.<%= countyName %>.length = 0;
	  var optionName = new Option("Out of State", "999", true, true);
	  window.document.frmAddResource.<%= countyName %>.options[window.document.frmAddResource.<%= countyName %>.length] = optionName;
  }
  else
  {
      window.document.frmAddResource.<%= countyName %>.length = 0;
     for (var i=0, l=window.document.frmAddResource.hiddenAddressCounty.options.length;i<l;i++)
	        {
	            var optionName = new Option(window.document.frmAddResource.hiddenAddressCounty.options[i].text, window.document.frmAddResource.hiddenAddressCounty.options[i].value, false, false);
	            window.document.frmAddResource.<%= countyName %>.options[window.document.frmAddResource.<%= countyName %>.length] = optionName;
	        }
	  	  window.document.frmAddResource.hiddenAddressCounty.length = 0;
  }
}



</script>
<impact:validateErrors />
<impact:validateForm name="frmAddResource" method="post" action="/resource/ResourceDetail/addResource" validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.AddResourceCustomValidation" schema="/WEB-INF/Constraints.xsd"
  pageMode="<%=PageModeConstants.EDIT%>">
  <impact:validateInput type="hidden" name="validated" value="<%=validatedValue%>" />
  <impact:validateInput type="hidden" name="hdnSaveOrValidate" value="" />
  <impact:validateInput type="hidden" name="cReqFuncCd" />
  <impact:validateInput type="hidden" name="frmWindowName" value="frmAddResource" />
  <impact:validateInput type="hidden" name="validationOverride" />
  <impact:validateInput type="hidden" name="addressMultCounty" value="" />

  <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
    <th colspan="7">
      <label id="label_Resource_Detail" for="Resource Detail">
        Resource Detail
      </label>
    </th>
    <tr>
      <td width="15%">
        <impact:validateInput type="text" value="<%=txtNmResource%>" name="txtNmResource" label="Resource Name" required="true" tabIndex="<%=tabIndex++%>" maxLength="30" size="30" />
      </td>
      <td>
      </td>

    </tr>
    <!-- SIR 22639 - add data element CAPS_RESOURCE.LEGAL_NAME -->
    <tr>
      <td width="15%">
        <impact:validateInput colspan="3" type="text" required="true" value="<%=txtNmLegal%>" name="txtNmLegal" label="Legal Name" tabIndex="<%=tabIndex++%>" maxLength="45" size="45" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selCdRsrcType" codesTable="CRSCTYPE" value="<%=selCdRsrcType%>" label="Resource Type" required="true" tabIndex="<%=tabIndex++%>"  />
      </td>
      <td>
        <!-- Per defect STGAP00002641, removed exclusion of Statewide option -->
        <%--Defect STGAP00006948 - exclude out of state --%>
        <impact:validateSelect name="selCdRsrcMaintainer" codesTable="CREGIONS" excludeOptions="<%=excludeOutOfStateOption%>" value="<%=selCdRsrcMaintainer%>" label="Maintainer" required="true" tabIndex="<%=tabIndex++%>" />
      </td>

    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selCdRsrcStatus" value="<%=selCdRsrcStatus%>" codesTable="CRSCSTAT" label="Status" tabIndex="<%=tabIndex++%>" />
      </td>

      <td>
        <impact:validateInput type="text" name="txtNmRsrcContact" value="<%=txtNmRsrcContact%>" label="Contact Name" tabIndex="<%=tabIndex++%>" maxLength="25" size="25" constraint="Name" />
      </td>

    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selCdRsrcOwnership" codesTable="COWNSHIP" label="Ownership" value="<%=selCdRsrcOwnership%>" blankValue="true" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateInput type="text" value="<%=txtNmRsrcContactTitle%>" name="txtNmRsrcContactTitle" label="Contact Title" tabIndex="<%=tabIndex++%>" maxLength="30" size="30" constraint="Name30" />
      </td>

    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selCdRsrcFacilType" value="<%=selCdRsrcFacilType%>" codesTable="CFACTYP4"  blankValue="true" label="Facility Type"  excludeOptions="<%=excludeCodeArrayCfactyp4%>" tabIndex="<%=tabIndex++%>"
          style="WIDTH: 180px" />
      </td>
      <td>
      </td>
    </tr>

    <tr>
      <td>
        <impact:validateInput type="text" value="<%=txtNationalProviderNumber%>" name="txtNationalProviderNumber" label="National Provider Number" tabIndex="<%=tabIndex++%>" maxLength="20" size="20" constraint="AlphaNumeric" />
      </td>
      <td>
        <impact:validateInput type="text" value="<%=txtEmailAddress%>" name="txtEmailAddress" label="Email Address" tabIndex="<%=tabIndex++%>" maxLength="100" size="50" constraint="Email" />
      </td>
    </tr>

    <tr>
      <td>
        <impact:validateInput colspan="3" type="text" value="<%=txtWebAddress%>" name="txtWebAddress" label="Web Address" tabIndex="<%=tabIndex++%>" maxLength="100" size="100" constraint="URL" />
      </td>

    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selCdSchoolType" codesTable="CSCHTYPE" value="<%=schoolType%>" label="School Type" tabIndex="<%=tabIndex++%>" blankValue="true" />
      </td>
      <td>
        <impact:validateSelect name="selCdSchoolDist" codesTable="CSCHDSTR" value="<%=schoolDistrict%>" label="School District" tabIndex="<%=tabIndex++%>" blankValue="true" />
      </td>

    </tr>
    <tr>
      <td>
        <impact:validateSelect name="selPaymentDelivery" codesTable="CPAYDELI" value="<%=paymentDelivery%>" label="Payment Method" tabIndex="<%=tabIndex++%>" blankValue="true" />
      </td>
      <td class="formLabel" colspan="2">
        <impact:validateInput type="checkbox" name="cbxCIndRsrcTransport" checked="<%=transport%>" value="0" tabIndex="<%=tabIndex++%>" onClick="setCbxCIndRsrcTransport(this);"/>
        Transportation Provided
      </td>

    </tr>


    <tr>
      <td class="formLabel" colspan=1 valign="top">
        Comments:
      </td>
      <td colspan="5">
        <impact:validateTextArea name="txtTxtRsrcComments" constraint="Comments" rows="4" cols="100" maxLength="300" tabIndex="<%=tabIndex++%>">
          <%=txtTxtRsrcComments%>
        </impact:validateTextArea>
      </td>
    </tr>
  </table>

  <!-- End Resource Detail -->
  <!-- BEGIN THE ADDRESS/PHONE DETAIL NOW -->
  <br />
  
  <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
    <th colspan="7">
      <label id="label_Primary_Address_Detail" for="Primary Address Detail">
        Primary Address Detail
      </label>
    </th>

    <a name="countyPop"></a>
    <!--<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" height="200">-->
    <tr align=left valign=top>
      <td width="15%">
        <impact:validateSelect name="selCdRsrcAddrType" label="Type" required="true" tabIndex="<%=tabIndex++%>" disabled="true" codesTable="CRSCADDR" value="01" />
      </td>
      <td>
        &nbsp;
      </td>
      <td>
        &nbsp;
      </td>
    </tr>
    <impact:validateInput type="hidden" name="txtNbrRsrcAddrVid" value="<%=txtSzNbrRsrcAddrVid%>" />
    <tr>
      <td>
        <impact:validateInput type="text" name="txtNbrRsrcAddrVidDisplay" label="Vendor ID" cssClass="formInput" disabled="true" value="<%=txtSzNbrRsrcAddrVid%>" constraint="VendorID" maxLength="8" size="8" tabIndex="<%=tabIndex++%>" />
        <%-- SIR 16091 - added constraint for VendorID --%>
      </td>
      <td>
        <impact:validateInput type="text" name="txtSzAddrRsrcAddrAttn" label="Attention" cssClass="formInput" value="<%=txtSzAddrRsrcAddrAttn%>" constraint="Name" size="16" maxLength="30" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" required="true" onChange="<%= addressOnChange %>"
           name="<%= address1Name %>" label="Address Ln 1" cssClass="formInput"
           value="<%=txtSzAddrRsrcAddrStLn1%>" constraint="Address" size="21"
           maxLength="30" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        &nbsp;
      </td>
      <td>
        &nbsp;
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" name="<%= address2Name %>"
          onChange="<%= addressOnChange %>" label="Address Ln 2" cssClass="formInput"
          value="<%=txtSzAddrRsrcAddrStLn2%>" constraint="Address" size="21"
          maxLength="30" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateInput type="text" required="true" name="<%= cityName %>"
          onChange="<%= addressOnChange %>" label="City" cssClass="formInput"
          value="<%=txtSzAddrRsrcAddrCity%>" constraint="City" size="21"
          maxLength="20" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
    <tr align=left valign=top>
      <td>
        <impact:validateSelect name="<%= stateName %>" onChange="javascript:checkCountyForOutOfState();" label="State" codesTable="CSTATE" value="<%=selCdFacilityState%>" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        <impact:validateInput type="text" name="<%= zipName %>" onChange="<%= addressOnChange %>" label="Zip" cssClass="formInput" value="<%=txtSzAddrRsrcAddrZip%>" required="true" maxLength="5" size="5" tabIndex="<%=tabIndex++%>" constraint="Digit5" />
        -
        <impact:validateInput type="text" name="<%= zipSuffName %>" onChange="<%= addressOnChange %>" tabIndex="<%=tabIndex++%>" cssClass="formInput" value="<%=txtSzAddrRsrcAddrZipSuff%>" constraint="Digit4" maxLength="4" size="4" />
        &nbsp;
        
      <%
      String function = "javascript:setIsDirtyCalled(true);" +
                        "launchAddressValidate('frmAddResource', 'validate', '" +
                        addressBean.getAddressSubmoduleName() + "');return false;";
  %>  
    &nbsp;<impact:ButtonTag
          name="btnValidateAddress"
          img="btnValidate"
          editableMode="<%= EditableMode.EDIT %>"
          function="<%=function%>"
          form="frmAddResource"
          action="/resource/ResourceDetail/addResource"
          tabIndex="<%=tabIndex++%>"/>
  
    </td>
    </tr>
    <%
    List excludeList = new ArrayList();
    if(selCdFacilityState != null && selCdFacilityState.equals("GA"))
    {
        excludeList.add("999");
    }
    %>
    
    <tr>
      <td>
        <impact:validateSelect name="<%= countyName %>" label="County" required="true" codesTable="CCOUNT" excludeOptions="<%= excludeList %>" value="<%=selCdFacilityCounty%>"
        tabIndex="<%=tabIndex++%>" onChange="<%= addressOnChange %>" />
        <select name="hiddenAddressCounty" style="display:none;">
      </td>
      <td>
        &nbsp;
      </td>
    </tr>
    <tr>
      <td class="formLabel" colspan="1" valign="top">
        Comments:
      </td>
      <td colspan="5">
        <impact:validateTextArea cols="100" rows="4" name="txtszTxtRsrcAddrComments" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
          <%=txtSzTxtRsrcAddrComments%>
        </impact:validateTextArea>
      </td>
    </tr>
  </table>

  <br />
  <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
    <th colspan="7">
      <label id="label_Primary_Phone_Detail" for="Primary Phone Detail">
        Primary Phone Detail
      </label>
    </th>

    <!--<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" style="WIDTH: 760 px; HEIGHT: 100px">-->
    <tr align=left valign=top>
      <td width="15%">
        <impact:validateSelect label="Type" required="true" name="selSzCdFacilPhoneType" value="01" disabled="true" tabIndex="<%=tabIndex++%>" codesTable="CRSCPHON" />
      </td>
      <td>
        &nbsp;
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" label="Phone" required="true" name="txtLNbrFacilPhoneNumber" value="<%=szLNbrFacilPhoneNumber%>" constraint="Phone" cssClass="formInput" size="14" maxLength="14" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        &nbsp;
      </td>
    </tr>
    <tr align=left valign=top>
      <td>
        <impact:validateInput type="text" label="Ext" name="txtLNbrFacilPhoneExtension" value="<%=szLNbrFacilPhoneExtension%>" constraint="PhoneExtension" cssClass="formInput" size="8" maxLength="8" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        &nbsp;
      </td>
    </tr>
    <tr>
      <td class="formLabel" colspan=1 valign="top">
        Comments:
      </td>
      <td colspan="5">
        <impact:validateTextArea cols="100" rows="4" name="txtszTxtRsrcPhoneComments" tabIndex="<%=tabIndex++%>" maxLength="300" constraint="Comments">
          <%=szSzTxtRsrcPhoneComments%>
        </impact:validateTextArea>
      </td>
      <td>
        &nbsp;
      </td>
    </tr>
  </table>
  <br>
  <hr>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
       <td align="right" colspan="2">
      <impact:ButtonTag name="btnSaveResource" img="btnSave" align="right" editableMode="<%= EditableMode.EDIT %>"
        function="<%= saveFunction %>" restrictRepost="true" preventDoubleClick="true" form="frmAddResource"
        action="/resource/ResourceDetail/addResource" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
  </table>
  <impact:validateInput type="hidden" name="hdnNbrRsrcAddrLat" value="0"/>
  <impact:validateInput type="hidden" name="hdnNbrRsrcAddrLong" value="0"/>
  <impact:validateInput type="hidden" name="<%= AddressBean.ADDRESS_SUBMODULE_NAME %>" value="<%= addressBean.getAddressSubmoduleName() %>"/>
  <impact:validateInput type="hidden" name="<%= addressBean.getAttributeName( AddressBean.IN_REQUEST )%>" value="true"/>
  <impact:validateInput type="hidden" name="<%= addressBean.getAttributeName( AddressBean.IS_VALID )%>" value="true"/>
  <impact:validateInput type="hidden" name="<%= addressBean.getAttributeName( AddressBean.FORM_ACTION )%>" value=""/>
  <impact:validateInput type="hidden" name="<%= addressBean.getAttributeName( AddressBean.MULT_COUNTY )%>" value=""/>
  <impact:validateInput type="hidden" name="<%= ORSResourceDetailConversation.ORS_RESOURCE_ID_FIELD_NAME %>" value="<%=szIdORSFacility%>" />
  <!--EndMain Content-->
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

