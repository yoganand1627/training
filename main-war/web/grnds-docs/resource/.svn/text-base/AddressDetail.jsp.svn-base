<%
/**
 * JSP Name:     AddressDetail.jsp
 * Created by:   Habib
 * Date Created: 07/30/02
 *
 * Description:
 * The Address Detail page displays detailed address information for the
 * resource selected on the Resource Detail page.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  05/04/04  gerryc            SIR 16091 - Added VendorID constraint to Vendor ID
                              field.  Vendor ID must be 14 characters, starting
                              with 11 numbers.
  09/12/11  charden           STGAP00017058 - Modified code so that Vendor ID is 
                              editable for Fiscal Ops users
  *** abgoode ********************************************************************
  NOTE: CURRENT VERSION OF SAVING STILL EXECUTES CUSTOM VALIDATION AND CONSTRAINTS
  VALIDATION (AND DOES NOT SAVE IF INVALID), BUT BECAUSE OF A JAVASCRIPT ERROR ON
  THE PAGE, THE ERROR MESSAGES DO NOT DISPLAY.
  ********************************************************************************
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>

<%
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


  //String TRACE_TAG = "AddressDetail.jsp";
  ROWCRES03SOG00 addressRow = (ROWCRES03SOG00)request.getAttribute( "addressDetail" );
// SR- retain this in case of validaiton failure -->request.removeAttribute( "addressDetail" );
  int txtUlIdResource = 0;
  String iIndex = "";
  int iUlIdRsrcAddress = 0;
  Date dateTsLastUpdate = null;
  String txtSzAddrRsrcAddrAttn = "";
  String txtSzAddrRsrcAddrStLn1 = "";
  String txtSzAddrRsrcAddrStLn2 = "";
  String txtSzAddrRsrcAddrZip = "";
  String txtSzAddrRsrcAddrZipSuff = "";
  String txtSzAddrRsrcAddrCity = "";
  String txtSzCdFacilityState = "";
  String txtSzCdFacilityCounty = "";
  String txtSzCdRsrcAddrRegion = "";
  String onPageLoadVid = "";
  String txtSzNbrRsrcAddrVid = "";
  String txtszTxtRsrcAddrComments = "";
  String txtSzCdRsrcAddrType = "";
  String szCReqFuncCd = "";
  String classResource = "false";
  String fadResource = "false";
  String vendorId = "";
  String contracted = "";
  List excludePrimaryOption = new ArrayList();
  String limitedEdit = "false";
  String addressTypeDisabled = "false";
  String vendorIdDisabled = "false";
  String attentionDisabled = "false";
  String streetLn1Disabled = "false";
  String streetLn2Disabled = "false";
  String cityDisabled = "false";
  String stateDisabled = "false";
  String zipDisabled = "false";
  String countyDisabled = "false";
  String schoolDistrictDisabled = "false";
  String commentsDisabled = "false";
  String validated = "";
  boolean validateButtonHide = false;
  boolean saveButtonHide = false;
  boolean deleteButtonHide = false;
  boolean displayRegionField = true;
  boolean editPlusVendorId = false;

  String pageMode = PageMode.getPageMode(request);


  //STGAP00017058 - set page mode if user is in Fiscal Ops security class
  if(request.getAttribute("editPlus") != null){
    editPlusVendorId = true;
    pageMode = PageModeConstants.EDIT;
  }
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
    txtSzCdFacilityState = request.getParameter(stateName);
  }
  if( request.getParameter(countyName) != null )
  {
    txtSzCdFacilityCounty = request.getParameter(countyName);
  }
  if( request.getParameter("txtNbrRsrcAddrVid") != null )
  {
    txtSzNbrRsrcAddrVid = request.getParameter("txtNbrRsrcAddrVid");
  }
  if( request.getParameter("txtszTxtRsrcAddrComments") != null )
  {
    txtszTxtRsrcAddrComments = request.getParameter("txtszTxtRsrcAddrComments");
  }
  if( request.getParameter("selCdRsrcAddrType") != null )
  {
    txtSzCdRsrcAddrType = request.getParameter("selCdRsrcAddrType");
  }

  /**-HIDDEN FIELDS-*/
  if( request.getParameter("cReqFuncCd") != null )
  {
    szCReqFuncCd = request.getParameter("cReqFuncCd");
  }

  if( request.getParameter("validated") != null )
  {
    validated = request.getParameter("validated");
  }
  else
  {
    if ("U".equalsIgnoreCase(szCReqFuncCd) )
    {
      validated = "true";
    }
    else
    {
      validated = "false";
    }
  }

  txtUlIdResource = GlobalData.getUlIdResource( request );
  if( request.getParameter("iUlIdRsrcAddress") != null && !"".equals(request.getParameter("iUlIdRsrcAddress")) )
  {
    iUlIdRsrcAddress = new Integer(request.getParameter("iUlIdRsrcAddress"));
  }

  if( request.getParameter("txtTsLastUpdate") != null )
  {
    dateTsLastUpdate = (Date) SerializationHelper.deserializeObject(request.getParameter("txtTsLastUpdate"));
  }

  if( request.getParameter("vendorId") != null )
  {
    vendorId = request.getParameter("vendorId");
  }
  if( request.getParameter("onPageLoadVendorId") != null )
  {
    onPageLoadVid = request.getParameter("onPageLoadVendorId");
  }
  if( StringHelper.isValid(request.getParameter("rbAddressRadioIndex")) )
  {
    iIndex = request.getParameter("rbAddressRadioIndex");
  }
  if( request.getParameter("contracted") != null )
  {
    contracted = request.getParameter("contracted");
  }

  // If address row has been returned from conversation
  if( addressRow != null )
  {
    if ("A".equalsIgnoreCase(szCReqFuncCd))
    {
      txtSzCdFacilityState = "GA";
    } else
    {
      txtUlIdResource = addressRow.getUlIdResource();
      iIndex = request.getParameter("indexNum");
      txtSzCdRsrcAddrType = addressRow.getSzCdRsrcAddrType();
      iUlIdRsrcAddress = addressRow.getUlIdRsrcAddress();
      dateTsLastUpdate = addressRow.getTsLastUpdate();
      txtSzAddrRsrcAddrAttn = addressRow.getSzAddrRsrcAddrAttn();
      txtSzAddrRsrcAddrStLn1 = addressRow.getSzAddrRsrcAddrStLn1();
      txtSzAddrRsrcAddrStLn2 = addressRow.getSzAddrRsrcAddrStLn2();
      txtSzAddrRsrcAddrZip = addressRow.getSzAddrRsrcAddrZip();
      if( txtSzAddrRsrcAddrZip.length() > 5 )
      {
        int dashIndex = 6;
        if( txtSzAddrRsrcAddrZip.indexOf("-") > 0)
        {
          dashIndex = txtSzAddrRsrcAddrZip.indexOf("-") + 1;
        }
        txtSzAddrRsrcAddrZipSuff = txtSzAddrRsrcAddrZip.substring( dashIndex, txtSzAddrRsrcAddrZip.length() );
        txtSzAddrRsrcAddrZip = txtSzAddrRsrcAddrZip.substring( 0, 5 );
      }
      txtSzAddrRsrcAddrCity = addressRow.getSzAddrRsrcAddrCity();
      txtSzCdFacilityState = addressRow.getSzCdFacilityState();
      txtSzCdFacilityCounty = addressRow.getSzCdFacilityCounty();
      //get the region given the county
      txtSzCdRsrcAddrRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, addressRow.getSzCdFacilityCounty()); 
      if(txtSzCdRsrcAddrRegion.length() == 3 && txtSzCdRsrcAddrRegion.startsWith("0")){
         txtSzCdRsrcAddrRegion = txtSzCdRsrcAddrRegion.substring(1);
      }      
      txtSzNbrRsrcAddrVid = addressRow.getSzNbrRsrcAddrVid();

      txtszTxtRsrcAddrComments = addressRow.getSzTxtRsrcAddrComments();
      contracted = addressRow.getCScrIndRsrcContracted();
      //Capture the Vid on page load
      onPageLoadVid = txtSzNbrRsrcAddrVid;
    }
  }

    //If address type is primary make address type field disabled.
    if("01".equals(txtSzCdRsrcAddrType) )
    {
      addressTypeDisabled = "true";
      deleteButtonHide = true;
    }
    //If in Add mode for a CLASS resource
     if( "true".equalsIgnoreCase( request.getParameter("classResource") ) && "A".equalsIgnoreCase(szCReqFuncCd) )
    {
      classResource = "true";
      deleteButtonHide = true;
    }
    //If in update mode for a CLASS resource
    if(  "true".equalsIgnoreCase( request.getParameter("classResource") ) && "U".equalsIgnoreCase(szCReqFuncCd) )
    {
      classResource = "true";
      limitedEdit = "true";
      addressTypeDisabled = "true";
      streetLn1Disabled = "true";
      streetLn2Disabled = "true";
      cityDisabled = "true";
      stateDisabled = "true";
      zipDisabled = "true";
      countyDisabled = "true";
      validateButtonHide = true;
      deleteButtonHide = true;
    }
    if( ("A".equals(szCReqFuncCd) ) || ("U".equals(szCReqFuncCd) && !"01".equals(txtSzCdRsrcAddrType)) )
    {
      excludePrimaryOption.add("01");
      schoolDistrictDisabled = "true";
    }

    //If in update mode for a FAD resource
    if( request.getParameter("fadResource") != null && "true".equals(request.getParameter("fadResource"))  )
    {
      fadResource = "true";
      addressTypeDisabled = "true";
      vendorIdDisabled = "true";
      attentionDisabled = "true";
      streetLn1Disabled = "true";
      streetLn2Disabled = "true";
      cityDisabled = "true";
      stateDisabled = "true";
      zipDisabled = "true";
      countyDisabled = "true";
      commentsDisabled = "true";
      schoolDistrictDisabled = "true";
      validateButtonHide = true;
      saveButtonHide = true;
      deleteButtonHide = true;
      //limitedEdit = "true";
    }

  //Hide delete button in Add mode
  if("A".equals(szCReqFuncCd) )
  {
    deleteButtonHide = true;
    displayRegionField = false;
  }
  //Hide buttons if in view mode
  if( pageMode.equals(PageModeConstants.VIEW) )
  {
    deleteButtonHide = true;
    saveButtonHide = true;
    validateButtonHide = true;
  }

  int tabIndex = 1;
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/addressValidation.js"></script>
<script language="JavaScript">

function unValidate()
{
  document.frmAddressDetail.validated.value="false";
}


 /*
  *This function is called before the page unloads.
  */
window.onbeforeunload = function ()
{
    IsDirty();
};


//STGAP00017058 - created confirmation message
var editPlus = <%= editPlusVendorId %>
function confirmVendorIdEdit(){
  if(editPlus){
	return confirm('Have you checked your updates before saving?');
  }
}



function openValidateWindowValidate()
{
  var x = document.frmAddressDetail;
  x.hdnSaveOrValidate.value = 'validate';
  openValidateWindow();
}

function openValidateWindowSave()
{
  var x = document.frmAddressDetail;
  x.hdnSaveOrValidate.value = 'save';
  openValidateWindow();
}

/*
 *This function opens the address validation window.
 */
function openValidateWindow()
{
  var x = document.frmAddressDetail;
  var streetLn1 = escape( x.txtSzAddrRsrcAddrStLn1.value.replace('#', ' '));
  var streetLn2 = escape( x.txtSzAddrRsrcAddrStLn2.value.replace('#', ' '));
  var city = escape( x.txtSzAddrRsrcAddrCity.value.replace('#', ' '));
  var zip = escape( x.txtSzAddrRsrcAddrZip.value.replace('#', ' '));
  window.open('/common/AddressValidation/validate?txtSzAddrRsrcAddrStLn1='+streetLn1+'&txtSzAddrRsrcAddrStLn2='+streetLn2+'&txtSzAddrRsrcAddrCity='+city+'&selCdFacilityState='+x.selCdFacilityState.value+'&txtSzAddrRsrcAddrZip='+zip+'&selCdFacilityCounty='+x.selCdFacilityCounty.value+'&frmWindowName='+x.frmWindowName.value+'&addressMultCounty='+x.addressMultCounty.value+'&<%= AddressBean.SAVE_OR_VALIDATE %>='+x.hdnSaveOrValidate.value,
              'newWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=400,height=250');
}

function saveWithValidate()
{
  var x = document.frmAddressDetail;
  if ( x.validated.value == 'false')
  {
    openValidateWindowSave();
    return false;
  }
  else
  {
    return saveAddressDetailWindow();
  }
}

 /*
  *This function is called when address detail is saved.
  */
function saveAddressDetailWindow()
{
  window.onbeforeunload = null;
  var x = document.frmAddressDetail;
  //disableValidation("frmAddressDetail");

  if( (x.vendorId.value != "") && (x.txtNbrRsrcAddrVid.value != "") && (x.vendorId.value != x.txtNbrRsrcAddrVid.value) )
  {
    //MSG - This Vendor ID already exists for the resource and cannot be repeated.
    setInformationalMessage("<%=MessageLookup.getMessageByName("MSG_RES_UNIQUE_VID")%>");
  }

  else if( x.contracted.value == "Y" && x.onPageLoadVendorId.value != "" && x.txtNbrRsrcAddrVid.value == "" )
  {
    //MSG - Save Failed: Cannot remove VID from address record with an active contract.
    setInformationalMessage("<%=MessageLookup.getMessageByName("MSG_RSRC_CONTRACTED_NO_VID")%>");
    x.txtNbrRsrcAddrVid.value = x.onPageLoadVendorId.value;
  }
  else
  {
    x.action = "/resource/ResourceDetail/displayAddressDetail";
    submitValidateForm( "frmAddressDetail", "/resource/ResourceDetail/saveAddressDetail" );
    return false;
  }

  return false;
}

 /*
  *This function is called when an address is deleted.
  */
function deleteAddressRow()
{
  var doDelete = false;
  window.onbeforeunload = null;
  var x = document.frmAddressDetail;
  if( x.txtNbrRsrcAddrVid.value != "" )
  {
    //MSG - An address record with a Vendor ID may not be deleted.
    setInformationalMessage("<%=MessageLookup.getMessageByName("MSG_RES_VID_ADDR")%>");
  }
  else if( x.selCdRsrcAddrType.value == "01" )
  {
    //MSG - You may not delete the primary address of a resource.
    setInformationalMessage("<%=MessageLookup.getMessageByName("MSG_CMN_PRIMARY_ADDRESS_NO_DELETE")%>");
  }
  else
  {
      var confirm = window.confirm("<%=MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE")%>")
      if(confirm)
      {
        disableValidation("frmAddressDetail");
        x.cReqFuncCd.value ="D";
        doDelete = true;
      }
  }

  return doDelete;
}


</script>
<impact:validateErrors/>
<%--SIR 16091 - added custom validation class to check the vendor ID--%>
<impact:validateForm
        name="frmAddressDetail"
        method="post"
        action="/resource/ResourceDetail/saveAddressDetail"
        validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.AddressDetailCustomValidation"
        pageMode="<%=pageMode%>"
        schema="/WEB-INF/Constraints.xsd">
     <impact:validateInput type="hidden" name="validated" value="<%= validated %>" />
     <impact:validateInput type="hidden" name="hdnSaveOrValidate" value="" />
     <impact:validateInput type="hidden" name="addressMultCounty" value=""/>
     <impact:validateInput type="hidden" name="iUlIdRsrcAddress" value="<%=FormattingHelper.formatInt(iUlIdRsrcAddress)%>"/>
     <impact:validateInput type="hidden" name="rbAddressRadioIndex" value="<%=iIndex%>"/>
     <impact:validateInput type="hidden" name="WindowName" value="frmAddressDetail"/>
     <impact:validateInput type="hidden" name="cReqFuncCd" value="<%=szCReqFuncCd%>"/>
     <impact:validateInput type="hidden" name="txtTsLastUpdate" value="<%=SerializationHelper.serializeObject(dateTsLastUpdate)%>"/>
     <impact:validateInput type="hidden" name="frmWindowName" value="frmAddressDetail"/>
     <impact:validateInput type="hidden" name="validationOverride" />
     <impact:validateInput type="hidden" name="vendorId" value="<%=vendorId%>"/>
     <impact:validateInput type="hidden" name="onPageLoadVendorId" value="<%=onPageLoadVid%>"/>
     <impact:validateInput type="hidden" name="classResource" value="<%=classResource%>"/>
     <impact:validateInput type="hidden" name="fadResource" value="<%=fadResource%>"/>
     <impact:validateInput type="hidden" name="contracted" value="<%=contracted%>"/>          
	<impact:validateInput type="hidden" name="hdnAdd1Name" value="<%=StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn1)%>" />
	<impact:validateInput type="hidden" name="hdnAdd2Name" value="<%=StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn2)%>" />
	<impact:validateInput type="hidden" name="hdnZipName" value="<%=StringHelper.getNonNullString(txtSzAddrRsrcAddrZip)%>" />
	<impact:validateInput type="hidden" name="hdnZipSuffName" value="<%=StringHelper.getNonNullString(txtSzAddrRsrcAddrZipSuff)%>" />
	<impact:validateInput type="hidden" name="hdnCityName" value="<%=StringHelper.getNonNullString(txtSzAddrRsrcAddrCity)%>" />
	<impact:validateInput type="hidden" name="hdnStateName" value="<%=StringHelper.getNonNullString(txtSzCdFacilityState)%>" />
	<impact:validateInput type="hidden" name="hdnCntyName" value="<%=StringHelper.getNonNullString(txtSzCdFacilityCounty)%>" />
     

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
   <tr>
     <th colspan="4">Address Information</th>
   </tr>
   <tr>
     <td><impact:validateSelect name="selCdRsrcAddrType"
                                label="Type"
                                required="true"
                                tabIndex="<%=tabIndex++%>"
                                disabled="<%=addressTypeDisabled %>"
                                excludeOptions="<%=excludePrimaryOption%>"
                                codesTable="CRSCADDR"
                                value="<%=txtSzCdRsrcAddrType%>"/></td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
   </tr>
   <%
   //STGAP00017058 - making vendorID editable for Fiscal Ops users
   if(!editPlusVendorId){
   %>
   <impact:validateInput type="hidden" name="txtNbrRsrcAddrVid" value="<%=txtSzNbrRsrcAddrVid%>" />
   <tr>
    <td><impact:validateInput type="text"
                              name="txtNbrRsrcAddrVidDisplay"
                              label="Vendor ID"
                              tabIndex="<%=tabIndex++%>"
                              cssClass="formInput"
                              value="<%=txtSzNbrRsrcAddrVid%>"
                              disabled="true"
                              constraint="VendorID"
                              maxLength="8"
                              size="8"/></td>
    <% 
    }else{
    %>
    <impact:validateInput type="hidden" name="vidChanged" value="<%= editPlusVendorId == true ? "true" : "false" %>" />
    <tr>
    <td><impact:validateInput type="text"
                              name="txtNbrRsrcAddrVid"
                              label="Vendor ID"
                              tabIndex="<%=tabIndex++%>"
                              cssClass="formInput"
                              value="<%=txtSzNbrRsrcAddrVid%>"
                              disabled="false"
                              constraint="VendorID"
                              maxLength="8"
                              size="8"/></td>
    <% 
    }
    %>          
    <td><impact:validateInput type="text"
                              name="txtSzAddrRsrcAddrAttn"
                              label="Attention"
                              tabIndex="<%=tabIndex++%>"
                              cssClass="formInput"
                              value="<%=txtSzAddrRsrcAddrAttn%>"
                              constraint="Name"
                              disabled="<%=attentionDisabled%>"
                              size="30"
                              maxLength ="30"/></td>
   </tr>
<%
  String addressOnChange = "javascript:changeValidAddress('frmAddressDetail', '"+ addressBean.getAddressSubmoduleName() +"')";
%>
   <tr>
    <td><impact:validateInput type="text"
                              required="true"
                              name="<%= address1Name %>"
                              onChange="<%= addressOnChange %>"
                              label="Address Ln 1"
                              tabIndex="<%=tabIndex++%>"
                              cssClass="formInput"
                              disabled="<%=streetLn1Disabled%>"
                              constraint="Address"
                              value="<%=txtSzAddrRsrcAddrStLn1%>"
                              size="21"
                              maxLength ="30"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
   </tr>
   <tr>
    <td><impact:validateInput type="text"
                              tabIndex="<%=tabIndex++%>"
                              name="<%= address2Name %>"
                              onChange="<%= addressOnChange %>"
                              label="Address Ln 2"
                              cssClass="formInput"
                              disabled="<%=streetLn2Disabled%>"
                              value="<%=txtSzAddrRsrcAddrStLn2%>"
                              size="21"
                              constraint="Address"
                              maxLength ="60"/></td>
    <td><impact:validateInput type="text"
                              tabIndex="<%=tabIndex++%>"
                              required="true"
                              name="<%= cityName %>"
                              onChange="<%= addressOnChange %>"
                              label="City"
                              cssClass="formInput"
                              disabled="<%=cityDisabled%>"
                              value="<%=txtSzAddrRsrcAddrCity%>"
                              constraint="City"
                              size="21"
                              maxLength ="20"/></td>
   </tr>
   <tr>
    <td><impact:validateSelect name="<%= stateName %>"
                               tabIndex="<%=tabIndex++%>"
                               onChange="<%= addressOnChange %>"
                               label="State"
                               codesTable="CSTATE"
                               disabled="<%=stateDisabled%>"
                               value="<%=txtSzCdFacilityState%>"/></td>
    <td><impact:validateInput type="text" 
                              name="<%= zipName %>"
                              tabIndex="<%=tabIndex++%>"
                              onChange="<%= addressOnChange %>"
                              label="Zip"
                              cssClass="formInput"
                              required="true"
                              disabled="<%=zipDisabled%>"
                              value="<%=txtSzAddrRsrcAddrZip%>"
                              constraint="Digit5"
                              maxLength ="5"
                              size="5"/>
        -
        <impact:validateInput type="text"
                              name="<%= zipSuffName %>"
                              onChange="<%= addressOnChange %>"
                              tabIndex="<%=tabIndex++%>"
                              cssClass="formInput"
                              disabled="<%=zipDisabled%>"
                              value="<%=txtSzAddrRsrcAddrZipSuff%>"
                              constraint="Digit4"
                              maxLength ="4"
                              size="4"/>
  <%if( !validateButtonHide ){
      String function = "javascript:setIsDirtyCalled(true);" +
                        "launchAddressValidate('frmAddressDetail', 'validate', '" +
                        addressBean.getAddressSubmoduleName() + "');return false;";
  %>
    &nbsp;
          <impact:ButtonTag name="btnValidateAddressRow" img="btnValidate" action="#" function="<%=function%>" form="frmAddressDetail" tabIndex="<%=tabIndex++%>" onBlur="setIsDirtyCalled(false);"/>
  <%}%>
    </td>
   </tr>
   <tr>
     <td><impact:validateSelect name="<%= countyName %>"
                                tabIndex="<%=tabIndex++%>"
                                label="County"
                                required="true"
                                disabled="<%=countyDisabled%>"
                                codesTable="CCOUNT"
                                onChange="<%= addressOnChange %>"
                                value="<%=txtSzCdFacilityCounty%>"/></td>
     <td>
       <%if(displayRegionField){%>
        <impact:validateDisplayOnlyField
         name="txtRegion"
         label="Region"
         value="<%=txtSzCdRsrcAddrRegion%>" />
       <%} else{%>
        &nbsp;&nbsp;
       <%}%>
      </td>
   </tr>
   <tr>
     <td class="formLabel" colspan="1" valign="top">Comments:</td>
     <td colspan=3><impact:validateTextArea name="txtszTxtRsrcAddrComments"
                                            cols="75"
                                            rows="4"
                                            tabIndex="<%=tabIndex++%>"
                                            disabled="<%=commentsDisabled%>"
                                            constraint="Paragraph80"
                                            maxLength="80">
                     <%= FormattingHelper.formatString(txtszTxtRsrcAddrComments) %>
                   </impact:validateTextArea></td>
   </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
 <tr>
  <td align="left">
    <%if( !deleteButtonHide ){%>
      <impact:ButtonTag name="btnDeleteAddressRow" img="btnDelete" editableMode="<%= EditableMode.EDIT %>" function="return deleteAddressRow();" form="frmAddressDetail" action="/resource/ResourceDetail/deleteAddressDetail" tabIndex="<%=tabIndex++%>"/>
    <%} else{%>
       &nbsp;
    <%}%>
  </td>
  <td align="right">
    <%if( !saveButtonHide ){
      String saveFunction = "return confirmVendorIdEdit(); validateAddressOnSave('frmAddressDetail', '/resource/ResourceDetail/saveAddressDetail', '"+ addressBean.getAddressSubmoduleName() +"', 'btnSaveAddressRow');";
    %>
      <impact:ButtonTag name="btnSaveAddressRow"
                        img="btnSave"
                        align="right"
                        editableMode="<%= EditableMode.EDIT %>"
                        function="<%= saveFunction %>"
                        form="frmAddressDetail"
                        action="/resource/ResourceDetail/saveAddressDetail"
                        restrictRepost="true"
                        tabIndex="<%=tabIndex++%>"/>
    <%} else{%>
     &nbsp;
   <%}%>
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

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>


