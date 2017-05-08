<%
//*  JSP Name:     AddressDetail.jsp
//*  Created by:   Heather Dean
//*  Date Created: 2/21/03
//*
//*
//*  Description:
//*              This page allows a user to edit and delete the Address Detail
//*              information.
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Modified/Added Flowerbox and Changelog.
  06/16/04  gerryc            SIR 16091 - Added VendorID constraint to Vendor
                              ID fields.  Vendor ID must be 14 characters,
                              starting with 11 numbers.  Using the resource
                              AddressDetailCustomValidation class for the form
                              validation.
  02/01/07  aodutayo          Making SHINES changes. Changed default State to GA
                              from GA.Removed School District from page
  09/12/11  charden           STGAP00017058 - Modified code so that Vendor ID is 
                              editable for Fiscal Ops users
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES16SOG_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fad.HomeInfrmtnConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
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

  String TRACE_TAG = "AddressDetail.jsp";
  int txtUlIdResourceAddress = 0;
  int iIndex = 0;
  int iUlIdRsrcAddress = 0;
  Date dateTsLastUpdate = null;
  String txtSzAddrRsrcAddrAttn = "";
  String txtSzAddrRsrcAddrStLn1 = "";
  String txtSzAddrRsrcAddrStLn2 = "";
  String txtSzAddrRsrcAddrZip = "";
  String txtSzAddrRsrcAddrZipSuff = "";
  String txtSzAddrRsrcAddrCity = "";
  String txtSzCdFacilityState = "GA";
  String txtSzCdFacilityCounty = "";
  String txtSzCdRsrcAddrRegion = "";
  String onPageLoadVid = "";
  String txtSzNbrRsrcAddrVid = "";
  String txtszTxtRsrcAddrComments = "";
  String txtSzCdRsrcAddrType = "";
  String szCReqFuncCd = "";
  String classResource = "false";
  String fadResource = "false";
  String schoolResource = "false";
  String vendorId = "";
  String cbxCIndRsrcTransport = "0";
  String endDateMod = "N";
  String pageMode = PageModeConstants.VIEW;
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
  String commentsDisabled = "false";
  String validated = "";
  String onlyButton = "false";
  boolean validateButtonHide = false;
  boolean saveButtonHide = false;
  boolean deleteButtonHide = false;
  boolean displayRegionField = true;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  boolean editPlusVendorId = false;

  if( PageMode.getPageMode( request ) != null ){
    pageMode = PageMode.getPageMode( request );
  }

  // STGAP00017058 - set pagemode to edit for fiscal ops users
  if(request.getAttribute("editPlus") != null){
    editPlusVendorId = true;
    pageMode = PageModeConstants.EDIT;
  }
  

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
    szCReqFuncCd = ContextHelper.getStringSafe( request, "szCReqFuncCd");

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
    txtUlIdResourceAddress = ContextHelper.getIntSafe( request, "txtUlIdResourceAddress" );
    iUlIdRsrcAddress = ContextHelper.getIntSafe( request, "iUlIdRsrcAddress" );
    dateTsLastUpdate = ContextHelper.getJavaDateSafe( request, "txtTsLastUpdate" );

    vendorId = ContextHelper.getStringSafe( request, "vendorId" );
    onPageLoadVid = ContextHelper.getStringSafe( request, "onPageLoadVendorId" );
    iIndex = ContextHelper.getIntSafe( request, "rbAddressRadioIndex" );

    cbxCIndRsrcTransport = ContextHelper.getStringSafe( request, "cbxCIndRsrcTransport" );


  CFAD07SO cfad07so = (CFAD07SO) state.getAttribute( "CFAD07SO" , request );

  if ( cfad07so != null )
  {
    endDateMod = cfad07so.getBIndEndDateMod();
  }

  if ("A".equalsIgnoreCase(szCReqFuncCd))
  {
    txtSzCdFacilityState = "GA";
  }

  ROWCFAD07SOG01 addressRow = (ROWCFAD07SOG01) state.getAttribute("currentAddress", request );

  // If address row has been returned from conversation
  if( addressRow != null )
  {
      txtUlIdResourceAddress = addressRow.getUlIdRsrcAddress();
      iIndex = ContextHelper.getIntSafe( request, "addressArrayIndex" );
      txtSzCdRsrcAddrType = addressRow.getSzCdRsrcAddrType();
      iUlIdRsrcAddress = addressRow.getUlIdRsrcAddress();
      dateTsLastUpdate = addressRow.getTsLastUpdate();
      txtSzAddrRsrcAddrAttn = addressRow.getSzAddrRsrcAddrAttn();
      txtSzAddrRsrcAddrStLn1 = addressRow.getSzAddrRsrcAddrStLn1();
      txtSzAddrRsrcAddrStLn2 = addressRow.getSzAddrRsrcAddrStLn2();
      txtSzAddrRsrcAddrZip = addressRow.getSzAddrRsrcAddrZip();
      if( txtSzAddrRsrcAddrZip.length() > 5 )
      {
        int dashIndex = 5;
        if( txtSzAddrRsrcAddrZip.indexOf("-") > 0)
        {
          dashIndex = txtSzAddrRsrcAddrZip.indexOf("-") + 1;
        }
        txtSzAddrRsrcAddrZipSuff = txtSzAddrRsrcAddrZip.substring( dashIndex, txtSzAddrRsrcAddrZip.length() );
        txtSzAddrRsrcAddrZip = txtSzAddrRsrcAddrZip.substring( 0, 5 );
      }
      txtSzAddrRsrcAddrCity = addressRow.getSzAddrRsrcAddrCity();
      txtSzCdFacilityState = addressRow.getSzCdFacilityState();
      if ("".equals(txtSzCdFacilityCounty) )
      {
       txtSzCdFacilityCounty = addressRow.getSzCdFacilityCounty();
      }
      //get the region given the county
      txtSzCdRsrcAddrRegion = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, addressRow.getSzCdFacilityCounty()); 
      if(txtSzCdRsrcAddrRegion.startsWith("0")){
         txtSzCdRsrcAddrRegion = txtSzCdRsrcAddrRegion.substring(1);
      }
      
      txtSzNbrRsrcAddrVid = addressRow.getSzNbrRsrcAddrVid();

      txtszTxtRsrcAddrComments = addressRow.getSzTxtRsrcAddrComments();
      //Capture the Vid on page load
      onPageLoadVid = txtSzNbrRsrcAddrVid;
  }
  else
  {
    deleteButtonHide = true;
  }
    //If address type is primary make address type field disabled.
    if( txtSzCdRsrcAddrType.equals( HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY ) && "U".equals(szCReqFuncCd) )
    {
      addressTypeDisabled = "true";
      deleteButtonHide = true;
    }

    if( ("A".equals(szCReqFuncCd) ) || ("U".equals(szCReqFuncCd) &&
                                        !txtSzCdRsrcAddrType.equals( HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY )) )
    {
      excludePrimaryOption.add( HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY );
      deleteButtonHide = true;
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

function checkState()
{
  if (document.frmAddressDetail.selCdFacilityState.value != 'GA')
  {
    document.frmAddressDetail.selCdFacilityCounty.value = 999;
  }
  else
  {
    document.frmAddressDetail.selCdFacilityCounty.value = '';
  }
}




 /*
  *This function is called before the page unloads.
  */
window.onbeforeunload = function ()
{
    IsDirty();
};

// STGAP00017058 - creating confirmation message
var editPlus = <%= editPlusVendorId %>;
function confirmVendorIdEdit(){
  if(editPlus){
	if(confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_UPDT_VERIF) %>')){
		return validateAddressOnSave('frmAddressDetail', '/fad/HomeInfrmtn/saveAddressDetail', '<%= addressBean.getAddressSubmoduleName() %>', 'btnSaveAddressRow');
	}else{
		return false;
	}
  }else{
  		return validateAddressOnSave('frmAddressDetail', '/fad/HomeInfrmtn/saveAddressDetail', '<%= addressBean.getAddressSubmoduleName() %>', 'btnSaveAddressRow');
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

  if( (x.vendorId.value != "") && (x.txtNbrRsrcAddrVid.value != "") && (x.vendorId.value != x.txtNbrRsrcAddrVid.value) )
  {
    //MSG - This Vendor ID already exists for the resource and cannot be repeated.
    setInformationalMessage("<%=MessageLookup.getMessageByNumber( Messages.MSG_RES_UNIQUE_VID )%>");
  }

  else
  {
    if ( x.countyChanged.value == 'true' && x.endDateMod == 'Y' )
    {
      alert("<%= MessageLookup.getMessageByNumber( Messages.MSG_FAD_OVERWRITE_CONTRACT ) %>");
    }
    x.action = "/fad/HomeInfrmtn/displayAddressDetail";
    submitValidateForm( "frmAddressDetail", "/fad/HomeInfrmtn/saveAddressDetail" );
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
    setInformationalMessage("<%=MessageLookup.getMessageByNumber(Messages.MSG_RES_VID_ADDR)%>");
  }
  else if( x.selCdRsrcAddrType.value ==  HomeInfrmtnConversation.CODE_ADDR_TYPE_PRIMARY  )
  {
    //MSG - You may not delete the primary address of a resource.
    setInformationalMessage("<%=MessageLookup.getMessageByNumber(Messages.MSG_CMN_PRIMARY_ADDRESS_NO_DELETE)%>");
  }
  else
  {
      var confirm = window.confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>")
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

<%
  if ( deleteButtonHide )
  {
    onlyButton = "true";
  }
%>

<impact:validateErrors/>
<%--SIR 16091 - uses validation class from resource package, only is validating
    the vendor ID --%>
<impact:validateForm
        name="frmAddressDetail"
        method="post"
        action="/fad/HomeInfrmtn/saveAddressDetail"
        validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.AddressDetailCustomValidation"
        pageMode="<%=pageMode%>"
        schema="/WEB-INF/Constraints.xsd">
     <impact:validateInput type="hidden" name="validated" value="<%= validated %>" />
     <impact:validateInput type="hidden" name="hdnSaveOrValidate" value="" />
     <impact:validateInput type="hidden" name="iUlIdRsrcAddress" value="<%=String.valueOf(iUlIdRsrcAddress)%>"/>
     <impact:validateInput type="hidden" name="txtUlIdResourceAddress" value="<%=String.valueOf(txtUlIdResourceAddress)%>"/>
     <impact:validateInput type="hidden" name="rbAddressRadioIndex" value="<%=String.valueOf(iIndex)%>"/>
     <impact:validateInput type="hidden" name="WindowName" value="frmAddressDetail"/>
     <impact:validateInput type="hidden" name="szCReqFuncCd" value="<%=szCReqFuncCd%>"/>
     <impact:validateInput type="hidden" name="txtTsLastUpdate" value="<%=String.valueOf(dateTsLastUpdate)%>"/>
     <impact:validateInput type="hidden" name="frmWindowName" value="frmAddressDetail"/>
     <impact:validateInput type="hidden" name="validationOverride" />
     <impact:validateInput type="hidden" name="isFirstLoad" value="true"/>
     <impact:validateInput type="hidden" name="vendorId" value="<%=vendorId%>"/>
     <impact:validateInput type="hidden" name="hdnCdFacilityCounty" value="<%=StringHelper.getNonNullString(txtSzCdFacilityCounty)%>"/>
     <impact:validateInput type="hidden" name="endDateMod" value="<%= endDateMod %>"/>
     <impact:validateInput type="hidden" name="countyChanged" value=""/>
     <impact:validateInput type="hidden" name="onPageLoadVendorId" value="<%=onPageLoadVid%>"/>
     <impact:validateInput type="hidden" name="fadResource" value="<%=fadResource%>"/>
     <impact:validateInput type="hidden" name="cbxCIndRsrcTransport" value="<%=cbxCIndRsrcTransport%>"/>
     

<impact:validateInput type="hidden" name="addressMultCounty" value=""/>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
   <tr>
     <th colspan = "6">
       Address Information
     </th>
   </tr>
   <tr>
     <td><impact:validateSelect
          name="selCdRsrcAddrType"
          label="Type" required="true"
          tabIndex="<%=tabIndex++%>"
          disabled="<%=addressTypeDisabled %>"
          excludeOptions="<%=excludePrimaryOption%>"
          codesTable="CRSCADDR"
          value="<%=txtSzCdRsrcAddrType%>"/></td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
   </tr>
   <%
   //STGAP00017058 - make vendor id modifiable for fiscal ops
   if(!editPlusVendorId){
   %>
   <impact:validateInput type="hidden" name="txtNbrRsrcAddrVid" value="<%=txtSzNbrRsrcAddrVid%>" />
   <tr>
    <td><impact:validateInput
          type="text"
          name="txtNbrRsrcAddrVidDisplay"
          label="Vendor ID"
          tabIndex="<%=tabIndex++%>"
          cssClass="formInput"
          value="<%=txtSzNbrRsrcAddrVid%>"
          constraint="VendorID"
          disabled="true"
          maxLength="8" size="8"/>
          <%-- SIR 16091 - added constraint for VendorID --%>
    </td>
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
    <td><impact:validateInput
          type="text"
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
    <td><impact:validateInput
          type="text"
          required="true"
          name="<%= address1Name %>"
          onChange="<%= addressOnChange %>"
          label="Address Ln 1"
          tabIndex="<%=tabIndex++%>"
          cssClass="formInput"
          disabled="<%=streetLn1Disabled%>"
          constraint="Address"
          value="<%=StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn1)%>"
          size="30"
          maxLength ="30"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
   </tr>
   <tr>
    <td><impact:validateInput
          type="text"
          tabIndex="<%=tabIndex++%>"
          name="<%= address2Name %>"
          onChange="<%= addressOnChange %>"
          label="Address Ln 2"
          cssClass="formInput"
          disabled="<%=streetLn2Disabled%>"
          value="<%=StringHelper.getNonNullString(txtSzAddrRsrcAddrStLn2)%>"
          size="30"
          constraint="Address"
          maxLength ="30"/></td>
    <td><impact:validateInput
          type="text"
          tabIndex="<%=tabIndex++%>"
          required="true"
          name="<%= cityName %>"
          onChange="<%= addressOnChange %>"
          label="City"
          cssClass="formInput"
          disabled="<%=cityDisabled%>"
          value="<%=StringHelper.getNonNullString(txtSzAddrRsrcAddrCity)%>"
          constraint="City"
          size="20"
          maxLength ="20"/></td>
   </tr>
   <tr>
    <td><impact:validateSelect
          name="<%= stateName %>"
          tabIndex="<%=tabIndex++%>"
          onChange="<%= addressOnChange +"; checkState();"%>"
          label="State"
          codesTable="CSTATE"
          disabled="<%=stateDisabled%>"
          value="<%=StringHelper.getNonNullString(txtSzCdFacilityState)%>"/></td>
    <td><impact:validateInput
          type="text"
          name="<%= zipName %>"
          tabIndex="<%=tabIndex++%>"
          onChange="<%= addressOnChange %>"
          label="Zip"
          cssClass="formInput"
          required="true"
          disabled="<%=zipDisabled%>"
          value="<%=StringHelper.getNonNullString(txtSzAddrRsrcAddrZip)%>"
    constraint="Digit5"
    maxLength ="5" size="5"/>
        -
        <impact:validateInput
          type="text"
          name="<%= zipSuffName %>"
          onChange="<%= addressOnChange %>"
          tabIndex="<%=tabIndex++%>"
          cssClass="formInput"
          disabled="<%=zipDisabled%>"
          value="<%=StringHelper.getNonNullString(txtSzAddrRsrcAddrZipSuff)%>"
    constraint="Digit4"
    maxLength ="4" size="4"/>

  <%if( !validateButtonHide ){
      String function = "javascript:setIsDirtyCalled(true);" +
                        "launchAddressValidate('frmAddressDetail', 'validate', '" +
                        addressBean.getAddressSubmoduleName() + "');return false;";
  %>  
    &nbsp;<impact:ButtonTag
          name="btnValidateAddressRow"
          img="btnValidate"
          editableMode="<%= EditableMode.EDIT %>"
          function="<%=function%>"
          form="frmAddressDetail"
          action="/fad/HomeInfrmtn/displayAddressDetail"
          tabIndex="<%=tabIndex++%>"/>
  <%}%>
    </td>
   </tr>
   <tr>
     <td><impact:validateSelect
          name="<%= countyName %>"
          tabIndex="<%=tabIndex++%>"
          label="County"
          required="true"
          disabled="<%=countyDisabled%>"
          codesTable="CCOUNT"
          onChange="<%= addressOnChange %>"
          value="<%=StringHelper.getNonNullString(txtSzCdFacilityCounty)%>"/>
     </td>
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
     <td colspan=3><impact:validateTextArea
          name="txtszTxtRsrcAddrComments"
          cols="120"
          rows="3"
          tabIndex="<%=tabIndex++%>"
          disabled="<%=commentsDisabled%>"
          constraint="Paragraph80">
          <%=StringHelper.getNonNullString(txtszTxtRsrcAddrComments)%>
          </impact:validateTextArea></td>
   </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
 <tr>
  <td align="left">
    <%if( !deleteButtonHide ){%>
      <impact:ButtonTag
          name="btnDeleteAddressRow"
          img="btnDelete"
          function="return deleteAddressRow();"
          form="frmAddressDetail"
          restrictRepost="true"
    action="/fad/HomeInfrmtn/deleteAddressRow"
    editableMode="<%= EditableMode.EDIT %>"
          tabIndex="<%=tabIndex++%>"/>
    <%} else{%>
       &nbsp;
    <%}%>
  </td>
  <td align="right">
    <%if( !saveButtonHide ){
    String saveFunction = "return confirmVendorIdEdit();";
    %>
      <impact:ButtonTag
          name="btnSaveAddressRow"
          img="btnSave"
          align="right"
          function="<%= saveFunction %>"
          form="frmAddressDetail"
    restrictRepost="true"
    action="/fad/HomeInfrmtn/saveAddressDetail"
    editableMode="<%= EditableMode.EDIT %>"
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


