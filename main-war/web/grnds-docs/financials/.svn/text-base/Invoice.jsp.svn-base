<%
//*  JSP Name:     Invoice
//*  Created by:   Anna Grimshaw
//*  Date Created: 11/13/2002
//*
//*  Description:
//*  This JSP is used to maintain Invoice Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/01/03  GRIMSHAN          SIR #17099 -- Added Return True statements to
//**                              contractBlank() and setReadyForValid() so that
//**                              the page would continue processing
//**  05/15/03  GRIMSHAN          SIR 17422 -- Split out From and To date fields in
//**                              foster care list so that it is displayed as month
//**                              year, from and to days.
//**  05/21/03  GRIMSHAN          SIR 17580 -- Added a radio button and New Using
//**                              button to delivered service list.
//**  05/29/03  GRIMSHAN          SIR 17867 -- Added javascript function to ensure
//**                              that a radio button is selected if the user has
//**                              clicked new using
//**  09/02/03  A.Corley          SIR 19684 If we are in sets.a (new using) disable
//**                              the contract ID and validate pushbutton.
//**  09/02/03  A.Corley          SIR 19684 Call the validate id javascript when validating
//**                              to make sure the ID entered is valid
//**  09/04/03  A.Corley          Removing SIR 19568
//**  02/04/04  CORLEYAN    SIR 18697 disable checkbox if it previously has been checked and
//**                              saved
//**  05/15/08  vdevarak          STGAP00007737: Modified this file as part of MR-012
//**
//**  04/09/2009 bgehlot          STGAP00013273: Added a new field Provider Invoice Number
//**  05/28/2009 bgehlot          STGAP00013947: The Provider Invoice Number field remain modifiable until the invoice status changes to Submitted


%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.DynamicDelvrdSvcDtlDAO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.InvoicePaginationDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN10SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN13SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%!
public static final String ROW = "row";
public static final String FOSTER_CARE = "F";
public static final String DELIVERED_SERVICE = "D";
%>
<%
BaseSessionStateManager state = (BaseSessionStateManager)
  request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
String cIndCopiedInv =(String) state.getAttribute("cIndCopiedInv",request);
//Get the output object from the request
CFIN02SO cfin02so = (CFIN02SO) state.getAttribute( "CFIN02SO", request );
CFIN10SO cfin10so = (CFIN10SO) state.getAttribute( "CFIN10SO", request );
CFIN15SO cfin15so = (CFIN15SO) state.getAttribute( "CFIN15SO", request );
CFIN06SO cfin06so = (CFIN06SO) state.getAttribute( "CFIN06SO", request );
CFIN13SO cfin13so = (CFIN13SO) state.getAttribute( "CFIN13SO", request );

ROWCFIN10SOG00_ARRAY fosterArray = null;
ROWCFIN15SOG00_ARRAY adminArray = null;
ROWCFIN06SOG_ARRAY delArray = null;
ROWCFIN13SOG_ARRAY costArray = null;

String cIndInvoReadyForValid = "false";
if(ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, "hdnReadyForValidation"))){
  cIndInvoReadyForValid = "true";
}

String szCdInvoType = ContextHelper.getStringSafe(request, "selSzCdInvoType");
org.exolab.castor.types.Date dtDtInvoReceivedDate = new org.exolab.castor.types.Date();
int uMoInvoMonth = 0;
int uYrInvoYear = 0;
int ulIdContract = 0;
double dAmtInvoClaimedAmount = 0.0;
String cReqFuncCd = (String) request.getAttribute(InvoiceConversation.REQ_FUNC_CD);
String indValidate = (String) request.getAttribute(InvoiceConversation.IND_VALIDATE);
String indError = (String) request.getAttribute(InvoiceConversation.IND_ERROR);
String noService = (String) request.getAttribute(InvoiceConversation.NO_SERVICE);
String indCostSaved = (String) request.getAttribute("indCostSaved");
//String invoiceType = "";
String szCdInvoAdjustmentRb = ContextHelper.getStringSafe( request, "cbxSzCdInvoAdjustmentRb");
String hasRow = "F";
int loopCount = 0;
String region = ContextHelper.getStringSafe(request, "dspSzCdCntrctRegion");
String county = ContextHelper.getStringSafe(request, "selCounty");
boolean showList = false;
boolean showType = ArchitectureConstants.Y.equals(cIndCopiedInv)? false:true;

// Added a new field Provider Invoice Number
String szNbrInvProvider = StringHelper.EMPTY_STRING;

//Get the following variables out of request if they are null from cfin02.
//This is done so that the information can be re-populated after validate.
if (cfin02so != null)
{  
  String s = cfin02so.getCIndInvoReadyForValid();
  if (ArchitectureConstants.Y.equals(s))
  {
    cIndInvoReadyForValid = "true";
  }
  s = cfin02so.getSzCdInvoType();
  if (StringHelper.isValid(s))
  {
    szCdInvoType = s;
    showList = true;
  }
  if (cfin02so.getDtDtInvoReceivedDate() == null)
  {
    dtDtInvoReceivedDate = DateHelper.toCastorDateSafe( ContextHelper.getStringSafe( request, "txtDtDtInvoReceivedDate"));
  }
  else
  {
    dtDtInvoReceivedDate = cfin02so.getDtDtInvoReceivedDate();
  }
  if (cfin02so.getUMoInvoMonth() == 0)
  {
    uMoInvoMonth = ContextHelper.getIntSafe(request, "txtUMoInvoMonth");
  }
  else
  {
    uMoInvoMonth = cfin02so.getUMoInvoMonth();
  }
  if (cfin02so.getUYrInvoYear() == 0)
  {
    uYrInvoYear = ContextHelper.getIntSafe(request, "txtUYrInvoYear");
  }
  else
  {
    uYrInvoYear = cfin02so.getUYrInvoYear();
  }
  if (cfin02so.getDAmtInvoClaimedAmount() == 0.0)
  {
    dAmtInvoClaimedAmount = ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtInvoClaimedAmount");
  }
  else
  {
    dAmtInvoClaimedAmount = cfin02so.getDAmtInvoClaimedAmount();
  }
  if (cfin02so.getUlIdContract() == 0)
  {
    ulIdContract = ContextHelper.getIntSafe( request, "txtUlIdContract");
  }
  else
  {
    ulIdContract = cfin02so.getUlIdContract();
  }
  
  // Added a new field Provider Invoice Number
  if (cfin02so.getSzNbrInvProvider() == null)
  {
    szNbrInvProvider = ContextHelper.getStringSafe(request, "szNbrInvProvider");
  }
  else
  {
    szNbrInvProvider = cfin02so.getSzNbrInvProvider();
  }
}


if (cfin02so == null) {
  cfin02so = new CFIN02SO();
}
else
{
  String s = cfin02so.getSzCdCntrctRegion();
  if(s != null && !"".equals(s)){
    region = s;
  }
  
  s = cfin02so.getSzCdCounty();
  if(s != null && !"".equals(s)){
    county = s;
  }
  
  s = cfin02so.getSzCdInvoAdjustmentRb();
  if(StringHelper.isValid(s)) {
    szCdInvoAdjustmentRb = s;
  }
}
if (cfin10so == null)
{
  cfin10so = new CFIN10SO();
}
if (cfin15so == null)
{
  cfin15so = new CFIN15SO();
}
if (cfin06so == null)
{
  cfin06so = new CFIN06SO();
}
if (cfin13so == null)
{
  cfin13so = new CFIN13SO();
}

if (cfin10so.getROWCFIN10SOG00_ARRAY() == null) {
  fosterArray = new ROWCFIN10SOG00_ARRAY();
} else {
  fosterArray = cfin10so.getROWCFIN10SOG00_ARRAY();
}
if (cfin15so.getROWCFIN15SOG00_ARRAY() == null) {
  adminArray = new ROWCFIN15SOG00_ARRAY();
} else {
  adminArray = cfin15so.getROWCFIN15SOG00_ARRAY();
}
if (cfin06so.getROWCFIN06SOG_ARRAY() == null) {
  delArray = new ROWCFIN06SOG_ARRAY();
} else {
  delArray = cfin06so.getROWCFIN06SOG_ARRAY();
}
if (cfin13so.getROWCFIN13SOG_ARRAY() == null) {
  costArray = new ROWCFIN13SOG_ARRAY();
} else {
  costArray = cfin13so.getROWCFIN13SOG_ARRAY();
}

//-- convert county array to selectable options
//boolean displayAllCounties = ArchitectureConstants.Y.equals(indValidate);
//Collection<CodeAttributes> options = InvoiceConversation.getCountyOptions(displayAllCounties);
//if(options.isEmpty()){
//  county = "";
//}
Set regionOptions = null;
if(ArchitectureConstants.Y.equals(indValidate)) {
  regionOptions = (Set) state.getAttribute(InvoiceConversation.REGION_OPTIONS, request);
}
if(!InvoiceConversation.optionsContainsCode(regionOptions, region)) {
  region = "";
}

//-- use this value to determine if display fields are now inputs for Emergency Payments
boolean isEmergencyType = showList && InvoiceConversation.isEmergencyType(szCdInvoType);
double validAmount = cfin02so.getDAmtInvoValidAmount();
List<Option> approvalStatusOptions = null;
if(isEmergencyType) {
  Double calcTotal = (Double) request.getAttribute("calculatedTotalAmount");
  if(calcTotal != null) {
    validAmount = calcTotal;
  }
  approvalStatusOptions = new ArrayList<Option>();
  approvalStatusOptions.add(new Option(CodesTables.CINVOAPV_APV, Lookup.simpleDecodeSafe(CodesTables.CINVOAPV, CodesTables.CINVOAPV_APV)));
}
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  <% InvoiceConversation.writeJavascriptArrays(out, request, InvoiceConversation.REGION_COUNTY_MAP, CodesTables.CCOUNT, "r"); %>
  
  function setCountyOptions(county) {
    var regionValue = document.frmInvoiceDetail.dspSzCdCntrctRegion.value;
    var countyDropdown = document.frmInvoiceDetail.selCounty;
    if(regionValue != null && regionValue != "") {
      var optionsArray = eval("r"+regionValue);
      try {
        populateDropdown(countyDropdown, county, optionsArray);
      } catch(e) {
        populateDropdown(document.frmInvoiceDetail.selCounty_Disabled, county, optionsArray);
      }
    } else {
      try {
        clearDropdown(countyDropdown);
      } catch(e) {
        clearDropdown(document.frmInvoiceDetail.selCounty_Disabled);
      }
    }
  }
  
  //function setRegion() {
  //  var county = document.frmInvoiceDetail.selCounty.value;
  //  var regionInput = document.frmInvoiceDetail.dspSzCdCntrctRegion;
  //  var regionDisplay = document.getElementById("dspSzCdCntrctRegion_id");
  //  
  //  var newRegion;
  //  if(county == null || county == "" || county == "<%= CodesTables.CCOUNT_999 %>") {
  //    newRegion = "";
  //  } else {
  //    newRegion = eval("countyRegions[k"+county+"]");
  //  }
  //  
  //  regionInput.value = newRegion;
  //  try {
  //    regionDisplay.childNodes[0].nodeValue = newRegion;
  //  } catch(e) {
  //    var textNode = document.createTextNode(newRegion);
  //    regionDisplay.appendChild(textNode);
  //  }
  //}

  function toggleReadyForValidation()
  {
    var ready = frmInvoiceDetail.hdnReadyForValidation.value;
    if(ready == 'N'){
      frmInvoiceDetail.hdnReadyForValidation.value = 'Y';
    } else {
      frmInvoiceDetail.hdnReadyForValidation.value = 'N';
    }
  }

  function cancelValidation ()
  {
    disableValidation('frmInvoiceDetail');
  }

  function contractBlank()
    {
      if (validateId(frmInvoiceDetail.txtUlIdContract.value.trim()))
      {
        disableValidation('frmInvoiceDetail');
        return true;
      }
      else
      {
        alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_INV_NOT_VALIDATED) %>');
        return false;
      }
    }

function setParms( loopCount )
      {
      frmInvoiceDetail.hdnLoopCount.value = loopCount;
      }

function setRejParms( loopCount, rejectionID, szCdRejRsnRejItemId )
      {
       frmInvoiceDetail.hdnLoopCount.value = loopCount;
       frmInvoiceDetail.hdnRejectionID.value = rejectionID;
       frmInvoiceDetail.hdnSzCdRejRsnRejItemId.value = szCdRejRsnRejItemId;
      }

function setReadyForValid()
     {
      if (frmInvoiceDetail.hdnCIndInvoReadyForValid.value == "Y")
       {
         frmInvoiceDetail.cbxCIndInvoReadyForValid.disabled = true;
       }
      else
       {
         if (frmInvoiceDetail.hdnHasRow.value == "T")
         {
           frmInvoiceDetail.cbxCIndInvoReadyForValid.disabled = false;
         }
         else
         {
         frmInvoiceDetail.cbxCIndInvoReadyForValid.disabled = true;
         }
       }
     }

//This will display a message asking the user if this invoice is ready for validation
//If they click ok, it will check the invoice ready for validation checkbox, if they
//click cancel the invoice will still save, but the invoice ready for validation checkbox
//will not be checked.
function invoReadyForValid()
{
  if (frmInvoiceDetail.cbxCIndInvoReadyForValid.disabled == false &&
      frmInvoiceDetail.cbxCIndInvoReadyForValid.checked == false)
  {
     var bInvoValid = confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_FIN_READY_VALID ) %>');
       if (bInvoValid)
       {
         frmInvoiceDetail.cbxCIndInvoReadyForValid.checked = true;
         frmInvoiceDetail.hdnReadyForValidation.value = 'Y';
       }
       return true;
  }
  // SIR 17099 GRIMSHAN -- Added an else statement to return true so the page would continue
  else
  {
    return true;
  }
}

// SIR 17867 GRIMSHAN is radiochecked added to
// make sure that a radiobutton from button group is checked before new using.
function isRadioChecked(arrayLength, buttonGroupName)
{
  var bRadio = false;
  var listRb = document.getElementsByName(buttonGroupName);
  for ( i = 0; i < arrayLength ; i++ )
  {
    bRadio = listRb[i].checked;
    if ( bRadio )
    {
      break;
    }
  }
  if ( !bRadio )
  {
    alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
  }
  return bRadio;
}
//STGAP00007737: Added this javascript function to accomodate the deletion of line items
function deleteLineItemConfirm(lineItemType,arrayLength, buttonGroupName,invoType)
  {
    var bRadio = isRadioChecked(arrayLength, buttonGroupName);
    if(bRadio){
    frmInvoiceDetail.hdnInvoType.value = invoType;
    frmInvoiceDetail.hdnDeleteType.value = lineItemType;
    return confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>');
    }else{
    return false;
    }
  }
    
 //  Called onUnload of page to remind user unsaved data will be lost
window.onbeforeunload = function ()
{
  IsDirty();
}
</script>
<%
  int tabIndex = 1;
  String overallPageMode = PageMode.getPageMode( request );
  boolean viewMode = overallPageMode.equals(PageModeConstants.VIEW);
  String disableCounty = String.valueOf(overallPageMode.equals(PageModeConstants.MODIFY) || viewMode);
  
%>
<impact:validateErrors/>
<impact:validateForm name="frmInvoiceDetail"
  method="post"
  action="/financials/Invoice/saveInvoice"
  pageMode="<%= overallPageMode %>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceCustomValidation"
  schema="/WEB-INF/Constraints.xsd">

<% /* Begin Detail */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th>Contract Information</th>
  </tr>
  <tr>
    <td>
    <TABLE border="0" cellspacing="0" cellpadding="0" width="100%"><TR><TD>
      <impact:validateInput
        type="text"
        name="txtUlIdContract"
        label="Contract ID"
        onChange="frmInvoiceDetail.hdnIndValidate.value = 'N'"
        constraint="ID"
        required="true"
        value="<%= FormattingHelper.formatInt(ulIdContract) %>"
        editableMode="<%= EditableMode.NEW %>"
        size="10"
        maxLength="10"
        tabIndex="<%= tabIndex++ %>"
        disabled="<%= Sets.isInSetStr( Sets.A , request ) %>"
      />
    </td>
    <td>
      <impact:ButtonTag
        name="btnValidate"
        img="btnValidate"
        function="return contractBlank()"
        editableMode="<%= EditableMode.NEW %>"
        form="frmInvoiceDetail"
        action="/financials/Invoice/validateContract"
        tabIndex="<%= tabIndex++ %>"
        disabled="<%= Sets.isInSetStr( Sets.A , request ) %>"
      />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateDisplayOnlyField
        name="dspSzNmResource"
        label="Resource Name"
        value="<%=FormattingHelper.formatString(cfin02so.getSzNmResource())%>"
      />
    </td>
    <td>
      <impact:validateDisplayOnlyField
        name="dspUlIdResource"
        label="Resource ID"
        value="<%=FormattingHelper.formatInt(cfin02so.getUlIdResource())%>"
      />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateDisplayOnlyField
        name="dspSzNbrInvoVid"
        label="Vendor ID"
        value="<%=FormattingHelper.formatString(cfin02so.getSzNbrInvoVid())%>"
      />
    </td>
    <td colspan="2" width="50%"/>
  </tr>
  <tr>
    <td>
      <impact:validateSelect
        name="dspSzCdCntrctRegion"
        label="Region"
        required="true"
        onChange="setCountyOptions('')"
        style="width: 150px"
        options="<%= regionOptions %>"
        tabIndex="<%= tabIndex++ %>"
        value="<%= region %>"
        disabled="<%= disableCounty %>"
      />
    </td>
    <td>
      <impact:validateSelect
        name="selCounty"
        label="County"
        required="true"
        width="30%"
        style="width: 180px"
        tabIndex="<%= tabIndex++ %>"
        value="<%= county %>"
        disabled="<%= disableCounty %>"
      />
    </TD></TR></TABLE>
    </td>
  </tr>
<%-- /table>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" --%>
  <tr>
    <th>Invoice Information</th>
  </tr>
  <tr>
    <TD><TABLE border="0" cellspacing="0" cellpadding="0" width="100%"><TR>
    <%-- td colspan="4">
      <impact:validateInput
        colspan="3"
        checked="<%=szCdInvoAdjustmentRb%>"
        value="I"
        tabIndex="<%= tabIndex++ %>"
        editableMode="<%=EditableMode.NEW %>"
        type="checkbox"
        name="cbxSzCdInvoAdjustmentRb"
        label="Invoice Specific Adjustment"
        cssClass="formInput"
        disabled="<%= String.valueOf(isEmergencyType) %>"
      />
    </td --%>
    <td colspan="2">
      <impact:validateSelect
        label="Invoice Specific Adjustment"
        name="cbxSzCdInvoAdjustmentRb"
        value="<%= "I".equals(szCdInvoAdjustmentRb) ? CodesTables.CINVADJT_Y : szCdInvoAdjustmentRb %>"
        codesTable="<%= CodesTables.CINVADJT %>"
        required="true"
        colspan="2"
        tabIndex="<%= tabIndex++ %>"
        editableMode="<%= EditableMode.NEW %>"
        disabled="<%= String.valueOf(isEmergencyType) %>"
      />
    </td>
    <td colspan="2">
      <impact:validateInput
        colspan="2"
        checked="<%= cIndInvoReadyForValid %>"
        tabIndex="<%= tabIndex++ %>"
        editableMode="<%= EditableMode.EDIT %>"
        type="checkbox"
        name="cbxCIndInvoReadyForValid"
        label="Invoice Ready for Validation"
        onClick="toggleReadyForValidation()"
        disabled="<%= String.valueOf(isEmergencyType) %>"
      />
    </td>
  </tr>
  <tr>
    <td colspan="1">
      <impact:validateSelect
        colspan="3"
        label="Type"
        value="<%=FormattingHelper.formatString(szCdInvoType)%>"
        name="selSzCdInvoType"
        required="true"
        tabIndex="<%= tabIndex++ %>"
        codesTable="CINVTYPE"
        editableMode="<%= showType? EditableMode.NEW:EditableMode.NONE %>"
      />
    </td>
    <td>
      <impact:validateDate
        name="txtDtDtInvoReceivedDate"
        label="Received Date"
        constraint="Date"
        required="true"
        value="<%=FormattingHelper.formatDate(dtDtInvoReceivedDate)%>"
        editableMode="<%= EditableMode.NEW + EditableMode.EDIT %>"
        size="10"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput
        type="text"
        name="txtUMoInvoMonth"
        label="Month"
        constraint="MonthNumber"
        required="true"
        value="<%= FormattingHelper.formatInt(uMoInvoMonth) %>"
        editableMode="<%= EditableMode.NEW %>"
        size="2"
        maxLength="2"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateInput
        type="text"
        name="txtUYrInvoYear"
        label="Year"
        constraint="Year"
        required="true"
        value="<%= FormattingHelper.formatInt(uYrInvoYear) %>"
        editableMode="<%= EditableMode.NEW %>"
        size="4"
        maxLength="4"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateInput
        type="text"
        name="txtDAmtInvoClaimedAmount"
        label="Claimed Amount"
        constraint="Money"
        value="<%= FormattingHelper.formatMoney(dAmtInvoClaimedAmount) %>"
        editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
        size="11"
        maxLength="11"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
  <tr>
    <td colspan="4">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="45%">
            <impact:if test="<%= isEmergencyType %>">
              <impact:then>
                <impact:validateDate
                  name="dspDtDtInvoSubmitDate"
                  label="Submit Date"
                  conditionallyRequired="true"
                  constraint="Date"
                  tabIndex="<%= tabIndex++ %>"
                  value="<%=FormattingHelper.formatDate(cfin02so.getDtDtInvoSubmitDate())%>"
                />
              </impact:then>
              <impact:else>
                <impact:validateDisplayOnlyField
                  name="dspDtDtInvoSubmitDate"
                  label="Submit Date"
                  value="<%=FormattingHelper.formatDate(cfin02so.getDtDtInvoSubmitDate())%>"
                />
              </impact:else>
            </impact:if>
          </td>
        </tr>
        <tr>
          <td>
            <impact:if test="<%= isEmergencyType %>">
              <impact:then>
                <impact:validateDate
                  name="dspDtDtInvoWarrantDate"
                  label="Check Date"
                  conditionallyRequired="true"
                  constraint="Date"
                  tabIndex="<%= tabIndex++ %>"
                  value="<%=FormattingHelper.formatDate(cfin02so.getDtDtInvoWarrantDate())%>"
                />
              </impact:then>
              <impact:else>
                <impact:validateDisplayOnlyField
                  name="dspDtDtInvoWarrantDate"
                  label="Check Date"
                  value="<%=FormattingHelper.formatDate(cfin02so.getDtDtInvoWarrantDate())%>"
                />
              </impact:else>
            </impact:if>
          </td>
        </tr>
        <tr>
          <td>
            <impact:if test="<%= isEmergencyType %>">
              <impact:then>
                <impact:validateInput
                  name="dspSzNbrInvoWarrant"
                  label="Check Number"
                  type="text"
                  constraint="Digit10Less"
                  maxLength="10"
                  conditionallyRequired="true"
                  tabIndex="<%= tabIndex++ %>"
                  value="<%=FormattingHelper.formatString(cfin02so.getSzNbrInvoWarrant())%>"
                />
              </impact:then>
              <impact:else>
                <impact:validateDisplayOnlyField
                  name="dspSzNbrInvoWarrant"
                  label="Check Number"
                  value="<%=FormattingHelper.formatString(cfin02so.getSzNbrInvoWarrant())%>"
                />
              </impact:else>
            </impact:if>
          </td>
        </tr>
        <tr>
          <td>
            <impact:if test="<%= isEmergencyType %>">
              <impact:then>
                <impact:validateInput
                  name="dspContact"
                  label="Invoice Contact"
                  type="text"
                  constraint="Name25"
                  maxLength="25"
                  conditionallyRequired="true"
                  tabIndex="<%= tabIndex++ %>"
                  value="<%=FormattingHelper.formatString(cfin02so.getSzTxtInvoContact())%>"
                />
              </impact:then>
              <impact:else>
                <impact:validateDisplayOnlyField
                  name="dspContact"
                  label="Invoice Contact"
                  value="<%=FormattingHelper.formatString(cfin02so.getSzTxtInvoContact())%>"
                />
              </impact:else>
            </impact:if>
          </td>
        </tr>
      </table>
     </td>
     <td colspan="2">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
           <td width="50%">
             <impact:validateDisplayOnlyField
               name="dspDAmtInvoValidAmount"
               label="Valid Amount"
               value="<%=FormattingHelper.formatMoney(validAmount)%>"
             />
           </td>
         </tr>
         <tr>
           <td>
             <impact:if test="<%= isEmergencyType %>">
               <impact:then>
                 <impact:validateInput
                   name="dspDAmtInvoWarrant"
                   label="Check Amount"
                   type="text"
                   constraint="Money"
                   conditionallyRequired="true"
                   tabIndex="<%= tabIndex++ %>"
                   value="<%=FormattingHelper.formatMoney(cfin02so.getDAmtInvoWarrant())%>"
                 />
               </impact:then>
               <impact:else>
                 <impact:validateDisplayOnlyField
                   name="dspDAmtInvoWarrant"
                   label="Check Amount"
                   value="<%=FormattingHelper.formatMoney(cfin02so.getDAmtInvoWarrant())%>"
                 />
               </impact:else>
             </impact:if>
           </td>
         </tr>
         <tr>
           <td>
             <impact:if test="<%= isEmergencyType %>">
               <impact:then>
                 <impact:validateSelect
                   name="dspSzCdInvoApproved"
                   label="Approval Status"
                   options="<%= approvalStatusOptions %>"
                   tabIndex="<%= tabIndex++ %>"
                   value="<%=FormattingHelper.formatString(cfin02so.getSzCdInvoApproved())%>"
                 />
               </impact:then>
               <impact:else>
                 <impact:validateDisplayOnlyField
                   name="dspSzCdInvoApproved"
                   label="Approval Status"
                   value="<%=FormattingHelper.formatString(cfin02so.getSzCdInvoApproved())%>"
                 />
               </impact:else>
             </impact:if>
           </td>
         </tr>
       </table>
     </td>
     </TR>
     <tr>
       <td>
         <impact:validateInput
           type="text"
           name="szNbrInvProvider"
           label="Provider Invoice Number"
           constraint="Paragraph30"
           value="<%= FormattingHelper.formatString(szNbrInvProvider) %>"
           editableMode="<%= EditableMode.NEW  + EditableMode.EDIT%>"
           size="12"
           maxLength="12"
           tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
 </TABLE></TD>
 </table>
<% // Only display the save pushbutton if an error has not been returned from the validate service
if (indError != null && ArchitectureConstants.N.equals(indError))
{
  %>

<table width="100%" cellpadding="3" cellspacing="0">
  <tr>
    <td>
<% if (PageMode.getPageMode( request ).equals(PageModeConstants.NEW) || isEmergencyType)
  {
%>
      <impact:ButtonTag
        name="btnSave"
        img="btnSave"
        restrictRepost="true"
        align="right"
        form="frmInvoiceDetail"
        action="/financials/Invoice/saveInvoice"
        editableMode="<%= EditableMode.NEW + EditableMode.EDIT %>"
        tabIndex="<%= tabIndex++ %>"
      />
<% } else { %>
      <impact:ButtonTag
        name="btnSave"
        img="btnSave"
        restrictRepost="true"
        function="return invoReadyForValid()"
        align="right"
        form="frmInvoiceDetail"
        action="/financials/Invoice/saveInvoice"
        editableMode="<%= EditableMode.NEW + EditableMode.EDIT %>"
        tabIndex="<%= tabIndex++ %>"
      />
<% } %>
    </td>
  </tr>
</table>
<% } %>
<br>
<% // Foster Care
   // Only display this list if the Invoice Type is Foster Care
if (showList && InvoiceConversation.isFosterCareType(szCdInvoType)) //invoiceType != null && "Foster".equals(invoiceType))
{
   loopCount = 0;
   ROWCFIN10SOG00 fosterRow = null;
   Enumeration fosterEnumeration = fosterArray.enumerateROWCFIN10SOG00();

%>
<impact:pagination submitUrl="/financials/Invoice/displayInvoice">
<table class="tableBorder" width="100%" cellspacing="0" cellpadding="3">
  <tr>
    <th>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="thExpand">Foster Care List</td>
          <td>
            <div class="alignRight"><div class="formInstruct">Scroll for more information  --></div></div>
          </td>
        </tr>
      </table>
    </th>
  </tr>
  <tr>
    <td>
      <div id="scrollBar" style="height:165px;width:763px;overflow:auto" class="tableborderList">
        <table width="1350" cellspacing="0" cellpadding="3">
          <tr>
            <th class="thList"></th>
            <th class="thList">Rejection</th>
            <th class="thList">Person ID</th>
            <th class="thList">Name&nbsp;<impact:sortableColumnHeader orderBy="<%= DynamicDelvrdSvcDtlDAO.SORT_NAME %>" isDefault="true"/></th>
            <th class="thList">Resource ID&nbsp;<impact:sortableColumnHeader orderBy="<%= DynamicDelvrdSvcDtlDAO.SORT_RESOURCE_ID %>"/></th>
            <th class="thList">Month</th>
            <th class="thList">Year</th>
            <th class="thList">From</th>
            <th class="thList">To</th>
            <th class="thList">Svc</th>
            <th class="thListRight">Rate</th>
            <th class="thListRight">Item Total</th>
            <th class="thList">Facility Number</th>
            <th class="thListRight">Qty</th>
          </tr>
<%
  if (!fosterEnumeration.hasMoreElements()) {
%>
          <tr class="odd">
            <td colspan="13"><%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %></td>
          </tr>
<%
  } else {
    while (fosterEnumeration.hasMoreElements()) {
      hasRow = "T";
      fosterRow = (ROWCFIN10SOG00) fosterEnumeration.nextElement();
      //double unitRate = fosterRow.getDAmtSvcDtlUnitRate();
      double itemTot = InvoiceConversation.calculateFosterCareLineItemTotal(fosterRow);
%>
          <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
          <td>
            <impact:validateInput
              type="radio"
              name="rbRowsIndex_CLEAN"
              id='<%="incRadio" + loopCount%>'
              editableMode="<%= EditableMode.EDIT %>"
              value="<%=String.valueOf(loopCount)%>"
              tabIndex="0"
              cssClass="formInput"
            />
          </td>
<%                  
      String RejFosterOnClick = "setRejParms( '" + loopCount + "', '" + fosterRow.getUlIdSvcDtl() + "', '" + CodesTables.CRJIDTYP_DS + "' )";
      if (fosterRow.getCIndSvcDtlRejItem() != null && ArchitectureConstants.Y.equals(fosterRow.getCIndSvcDtlRejItem())) {
%>
            <td>
              <a tabIndex="<%= tabIndex++ %>"
                 id='<%= ROW + loopCount %>'
                 href="javascript:<%=RejFosterOnClick%>; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayRejection' )">R
              </a>
            </td>
<%
      } else {
%>
            <td/>
<%
      }
%>
            <td><%= FormattingHelper.formatInt(fosterRow.getUlIdPerson())%></td>
<%
      String FosterOnClick = "setParms( '" + loopCount + "' )";
%>
            <td>
              <a tabIndex="<%= tabIndex++ %>"
                 id='<%= ROW + loopCount %>'
                 href="javascript:<%=FosterOnClick%>; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayFosterDetail' )">
                <%= FormattingHelper.formatString(fosterRow.getSzNmPersonFull())%>
              </a>
            </td>
            <td><%= FormattingHelper.formatInt(fosterRow.getUlIdResource())%></td>
            <td><%= FormattingHelper.formatInt(fosterRow.getUMoSvcDtlSvcMonth())%></td>
            <td><%= FormattingHelper.formatInt(fosterRow.getUYrSvcDtlServiceYear())%></td>
            <td><%= FormattingHelper.formatInt(fosterRow.getSNbrSvcDtlFromDay())%></td>
            <td><%= FormattingHelper.formatInt(fosterRow.getSNbrSvcDtlToDay())%></td>
            <td><%= FormattingHelper.formatString(fosterRow.getSzCdSvcDtlService())%></td>
            <td class="alignRight"><%= FormattingHelper.formatDouble(fosterRow.getDAmtSvcDtlUnitRate(), 2)%></td>
            <td class="alignRight"><%= FormattingHelper.formatMoney(itemTot)%></td>
            <td><%= FormattingHelper.formatInt(fosterRow.getLNbrRsrcFacilAcclaim())%></td>
            <td class="alignRight"><%= FormattingHelper.formatDouble(fosterRow.getSNbrSvcDtlUnitQty(), 2) %></td>
          </tr>
<%
      loopCount++;
    } // end for
  }
%>
        </table>
      </div>
      </impact:pagination>
    </td>
  </tr>
<%
  // Don't display add pushbutton if no services are maintained for this contract
  // Or if the contract ID has not been validated.
  if(!viewMode){
    if ((noService != null && !ArchitectureConstants.Y.equals(noService)) || (indValidate != null && ArchitectureConstants.Y.equals(indValidate))) {
      if ("T".equals(hasRow)) {
    String lineItemType = FOSTER_CARE;
String fosterFunctionString = "cancelValidation(); return deleteLineItemConfirm( '" + lineItemType + "', '" + loopCount + "', 'rbRowsIndex_CLEAN', '"  + szCdInvoType + "' )";
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
<tr>
      <td width="95%">
      <div class="alignRight">
      <impact:ButtonTag name="btnDelete" 
              img="btnDelete" 
              form="frmInvoiceDetail" 
              align="left"
              function="<%=fosterFunctionString%>"
              action="/financials/Invoice/deleteLineItem"
              editableMode="<%= EditableMode.ALL %>"
              tabIndex="<%= tabIndex++ %>"
              restrictRepost="true"/>
              </div>
    </td>
    <% } %>
    <td width="5%">
    <div class="alignRight">
        <impact:ButtonTag
          name="btnAddFoster"
          img="btnAdd"
          form="frmInvoiceDetail"
          navAwayCk="true"
          function="cancelValidation()"
          action="/financials/Invoice/addFosterDetail"
          editableMode="<%= EditableMode.ALL %>"
          tabIndex="<%= tabIndex++ %>"
          restrictRepost="true"/>
          </div>
    </td>
  </tr>
  </table>
<%
    }
  }
%>
</table>
<br/>
<%
  // end Foster Care
}
// Administrative
// Only display this list if the Invoice Type is Administrative
if (showList && InvoiceConversation.isAdminType(szCdInvoType)) //invoiceType != null && "Admin".equals(invoiceType))
{
  loopCount = 0;
  ROWCFIN15SOG00 adminRow = null;
  Enumeration adminEnumeration = adminArray.enumerateROWCFIN15SOG00();
%>
<impact:pagination submitUrl="/financials/Invoice/displayInvoice">
<table class="tableBorder" width="100%" cellspacing="0" cellpadding="3">
  <tr>
    <th>
      <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <tr>
          <td class="thExpand">Administrative List</td>
          <%-- If the list box needs to enlarge, uncomment the following line
          <td><div class="alignRight"><div class="formInstruct">Scroll for more information  --></div></div></td> 
          --%>
        </tr>
      </table>
    </th>
  </tr>
  <tr>
    <td>
      <div id="scrollBar" style="height:165px;width:763px;overflow:auto" class="tableborderList">
      <%-- Enlarge list box by using the table width below --%>
      <table width="100%" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList"></th>
          <th class="thList">Rejection</th>
          <th class="thList">Service</th>
          <th class="thList">CSLI</th>
          <th class="thList">Month</th>
          <th class="thList">Year</th>
          <th class="thListRight">Administrative</th>
          <th class="thListRight">Promotional</th>
          <th class="thListRight">Other</th>
        </tr>
<%
  if (!adminEnumeration.hasMoreElements()) {
%>
        <tr class="odd">
          <td colspan="8"><%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %></td>
        </tr>
<%
  } else {
    while (adminEnumeration.hasMoreElements()) {
      hasRow = "T";
      adminRow = (ROWCFIN15SOG00) adminEnumeration.nextElement();
%>
        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
                  <td>
            <impact:validateInput
              type="radio"
              name="rbRowsIndex_CLEAN"
              id='<%="incRadio" + loopCount%>'
              editableMode="<%= EditableMode.EDIT %>"
              value="<%=String.valueOf(loopCount)%>"
              tabIndex="0"
              cssClass="formInput"
            />
          </td>
<%
      String RejAdminOnClick = "setRejParms( '" + loopCount + "', " + "'" + adminRow.getUlIdAdminDtl() + "', '" + CodesTables.CRJIDTYP_AD + "' )";
      String AdminOnClick = "setParms( '" + loopCount + "' )";
      if (adminRow.getCIndAdminDtlRejItm() != null && ArchitectureConstants.Y.equals(adminRow.getCIndAdminDtlRejItm())) {
%>
          <td>
            <a tabIndex="<%= tabIndex++ %>"
               id='<%= ROW + loopCount %>'
               href="javascript:<%=RejAdminOnClick%>; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayRejection' )">R
            </a>
          </td>
<%
      } else {
%>
          <td/>
<%
      }
%>
          <td>
            <a tabIndex="<%= tabIndex++ %>"
               id='<%= ROW + loopCount %>'
               href="javascript:<%=AdminOnClick%>; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayAdminDetail' )">
              <%= FormattingHelper.formatString(adminRow.getSzCdAdminDtlService())%>
            </a>
          </td>
          <td><%= FormattingHelper.formatInt(adminRow.getUsNbrAdminDtlCsli())%></td>
          <td><%= FormattingHelper.formatInt(adminRow.getUMoAdminDtlSvcMonth())%></td>
          <td><%= FormattingHelper.formatInt(adminRow.getUYrAdminDtlSvcYear())%></td>
          <td class="alignRight"><%= FormattingHelper.formatMoney(adminRow.getDAmtAdminDtlAdminAlloc()) %></td>
          <td class="alignRight"><%= FormattingHelper.formatMoney(adminRow.getDAmtAdminDtlPromotional()) %></td>
          <td class="alignRight"><%= FormattingHelper.formatMoney(adminRow.getDAmtAdminDtlOther()) %></td>
        </tr>
<%
      loopCount++;
    } // end for
  }
%>
      </table>
      </div>
      </impact:pagination>
    </td>
  </tr>
  <tr>
    <td>
<%
  // Don't display add pushbutton if no services are maintained for this contract
  if(!viewMode){
    if (noService != null && !ArchitectureConstants.Y.equals(noService)) {
%>
            <div class="alignRight">
              <impact:ButtonTag
                name="btnAddAdmin"
                img="btnAdd"
                navAwayCk="true"
                form="frmInvoiceDetail"
                function="cancelValidation()"
                action="/financials/Invoice/addAdminDetail"
                editableMode="<%= EditableMode.ALL %>"
                tabIndex="<%= tabIndex++ %>"
              />
            </div>
<%
    }
  }
%>
    </td>
  </tr>
</table>
<br/>
<%
} // end Administrative
// Delivered Service
// Only display this list if the Invoice Type is Delivered Service (of some type) or Adoption Subsidy
if (showList && InvoiceConversation.isDeliveredServiceOrAdoptionAssistanceType(szCdInvoType))
{
  loopCount = 0;
  ROWCFIN06SOG delRow = null;
  Enumeration delEnumeration = delArray.enumerateROWCFIN06SOG();
%>
<impact:pagination submitUrl="/financials/Invoice/displayInvoice">
<table class="tableBorder" border="0" width="100%" cellspacing="0" cellpadding="3">
  <tr>
    <th>
      <table border="0" cellspacing="0" cellpadding="0" width="100%">
        <tr>
          <td class="thExpand">Delivered Service List</td>
          <td>
            <div class="alignRight"><div class="formInstruct">Scroll for more information  --></div></div>
          </td>
        </tr>
      </table>
    </th>
  </tr>
  <tr>
    <td>
      <div id="scrollBar" style="height:165px;width:763px;overflow:auto" class="tableborderList">
      <table width="1400" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList"></th>
          <th class="thList">Rejection</th>
          <th class="thList">Person ID</th>
          <th class="thList">Name&nbsp;<impact:sortableColumnHeader orderBy="<%= InvoiceConversation.FIN_SORT_TYPE_NM %>" isDefault="true"/></th>
          <th class="thList">CSLI</th>
          <th class="thList">Svc&nbsp;<impact:sortableColumnHeader orderBy="<%= InvoiceConversation.FIN_SORT_TYPESVCCD %>"/></th>
          <th class="thList">UT</th>
          <th class="thList">Cnty</th>
          <th class="thList">Mo&nbsp;<impact:sortableColumnHeader orderBy="<%= InvoiceConversation.FIN_SORT_TYPE_MY %>"/></th>
          <th class="thList">Yr</th>
          <th class="thListRight">Rate</th>
          <th class="thListRight">Qty</th>
          <th class="thListRight">Fee Paid</th>
          <th class="thListRight">Item Tot</th>
          <th class="thList"><div align="center">LI Type</div></th>
          <th class="thList">Svc Auth Dtl ID</th>
          <th class="thList">Payment Type</th>
        </tr>
<%
  if (!delEnumeration.hasMoreElements()) {
%>
        <tr class="odd">
          <td colspan="10"><%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %></td>
        </tr>
<%
  } else {
    while (delEnumeration.hasMoreElements()) {
      hasRow = "T";
      delRow = (ROWCFIN06SOG) delEnumeration.nextElement();
      //double unitRate = delRow.getDAmtSvcDtlUnitRate();
      //double roundRate = Math.round(unitRate*100)/100.0;
      double itemTot = InvoiceConversation.calculateDelSvcAdoAsstLineItemTotal(delRow);
%>
        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
          <td>
            <impact:validateInput
              type="radio"
              name="rbRowsIndex_CLEAN"
              id='<%="incRadio" + loopCount%>'
              editableMode="<%= EditableMode.EDIT %>"
              value="<%=String.valueOf(loopCount)%>"
              tabIndex="0"
              cssClass="formInput"
            />
          </td>
<%
      String RejDelOnClick = "setRejParms( '" + loopCount + "', " + "'" + delRow.getUlIdSvcDtl() + "', '" + CodesTables.CRJIDTYP_DS + "' )";
      if (delRow.getCIndSvcDtlRejItem() != null && ArchitectureConstants.Y.equals(delRow.getCIndSvcDtlRejItem())) {
%>
          <td>
            <a tabIndex="<%= tabIndex++ %>"
               id='<%= ROW + loopCount %>'
               href="javascript:<%=RejDelOnClick%>; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayRejection' )">R
            </a>
          </td>
<%
      } else { 
%>
          <td/>
<%
      }
%>
          <td><%= FormattingHelper.formatInt(delRow.getUlIdPerson())%></td>
<%
      String DelOnClick = "setParms( '" + loopCount + "' )";
%>
          <td>
            <a tabIndex="<%= tabIndex++ %>"
               id='<%= ROW + loopCount %>'
               href="javascript:<%=DelOnClick%>; cancelValidation(); submitValidateForm( 'frmInvoiceDetail', '/financials/Invoice/displayDeliveredDetail' )">
              <%= FormattingHelper.formatString(delRow.getSzScrNmGenericFullName())%>
            </a>
          </td>
          <td><%= FormattingHelper.formatInt(delRow.getUsNbrSvcDtlCsli())%></td>
          <td><%= FormattingHelper.formatString(delRow.getSzCdSvcDtlService())%></td>
          <td><%= FormattingHelper.formatString(delRow.getSzCdSvcDtlUnitType())%></td>
          <td><%= FormattingHelper.formatString(delRow.getSzCdSvcDtlCounty())%></td>
          <td><%= FormattingHelper.formatInt(delRow.getUMoSvcDtlSvcMonth())%></td>
          <td><%= FormattingHelper.formatInt(delRow.getUYrSvcDtlServiceYear())%></td>
          <td class="alignRight"><%= FormattingHelper.formatDouble(delRow.getDAmtSvcDtlUnitRate(), 2)%></td>
          <td class="alignRight"><%= FormattingHelper.formatDouble(delRow.getSNbrSvcDtlUnitQty(), 2)%></td>
          <td class="alignRight"><%= FormattingHelper.formatMoney(delRow.getDAmtSvcDtlFeePaid())%></td>
          <td class="alignRight"><%= FormattingHelper.formatMoney(itemTot) %></td>
          <td align="center"><%= FormattingHelper.formatString(delRow.getSzCdSvcDtlLiType())  %></td>
          <td><%= FormattingHelper.formatInt(delRow.getUlIdSvcAuthDtl())%></td>
          <td><%= FormattingHelper.formatString(delRow.getSzCdCnsvcPaymentType() ) %></td>
        </tr>
<%
      loopCount++;
    } // end for
  }
%>
      </table>
      </div>
      </impact:pagination>
    </td>
  </tr>
  <tr>
    <td>
<%
  // Don't display add pushbutton if no services are maintained for this contract
  if(!viewMode){
    if (noService != null && !ArchitectureConstants.Y.equals(noService)) {
%>
      <table width="100%" cellpadding="3" cellspacing="0" border="0">
        <tr>
<%
    if ("T".equals(hasRow)) {
      // SIR 17867 GRIMSHAN, call isRadioChecked to make sure the user has selected a radio button to "new use" on
      String functionString = "cancelValidation(); return isRadioChecked( " + loopCount + ", 'rbRowsIndex_CLEAN' );";
      String lineItemType = DELIVERED_SERVICE;
String delFunctionString = "cancelValidation(); return deleteLineItemConfirm( '" + lineItemType + "', '" + loopCount + "', 'rbRowsIndex_CLEAN', '"  + szCdInvoType + "' )";
%>
      <td width="10%">
      <div class="alignRight">
      <impact:ButtonTag name="btnDelete" 
              img="btnDelete" 
              form="frmInvoiceDetail" 
              align="left"
              function="<%=delFunctionString%>"
              action="/financials/Invoice/deleteLineItem"
              editableMode="<%= EditableMode.ALL %>"
              tabIndex="<%= tabIndex++ %>"
              restrictRepost="true"/>
    </td>
          <td width="80%">
            <div class="alignRight">
              <impact:ButtonTag
                name="btnNewUsing"
                img="btnNewUsing"
                navAwayCk="true"
                form="frmInvoiceDetail"
                function="<%=functionString%>"
                action="/financials/Invoice/displayDeliveredDetail"
                editableMode="<%= EditableMode.EDIT %>"
                tabIndex="<%= tabIndex++ %>"
              />
            </div>
          </td>
<%
    }
%>
          <td width="10%">
            <div class="alignRight">
              <impact:ButtonTag
                name="btnAddDelivered"
                img="btnAdd"
                navAwayCk="true"
                form="frmInvoiceDetail"
                function="cancelValidation()"
                action="/financials/Invoice/addDeliveredDetail"
                editableMode="<%= EditableMode.EDIT %>"
                tabIndex="<%= tabIndex++ %>"
              />
            </div>
          </td>
        </tr>
      </table>
<%
    }
  }
%>
    </td>
  </tr>
</table>
<br/>
<%
} // end Delivered Service
%>
<br>
<%--
  Include any hidden fields needed on the page
  Hidden fields are used for variables passed into the page as request parameters
  AND for hidden fields that need to be used for saving or deleting the detail on this page.
--%>
<impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= DateHelper.toISOString(cfin02so.getTsLastUpdate()) %>"/>
<impact:validateInput type="hidden" name="hdnUlIdIndivTraining" value="<%= FormattingHelper.formatInt(cfin02so.getUlIdInvoInvoice())%>"/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>"/>
<impact:validateInput type="hidden" name="hdnLoopCount" value=""/>
<impact:validateInput type="hidden" name="hdnSzCdRejRsnRejItemId" value=""/>
<impact:validateInput type="hidden" name="hdnRejectionID" value=""/>
<impact:validateInput type="hidden" name="hdnDeleteType" value=""/>
<impact:validateInput type="hidden" name="hdnInvoType" value=""/>
<impact:validateInput type="hidden" name="hdnDtDtInvoEntryCompleted" value="<%= FormattingHelper.formatDate(cfin02so.getDtDtInvoEntryCompleted())%>"/>
<impact:validateInput type="hidden" name="hdnDtDtInvoEntryStarted" value="<%= FormattingHelper.formatDate(cfin02so.getDtDtInvoEntryStarted())%>"/>
<impact:validateInput type="hidden" name="hdnSzCdInvoPhase" value="<%= FormattingHelper.formatString(cfin02so.getSzCdInvoPhase())%>"/>
<impact:validateInput type="hidden" name="hdnHasRow" value="<%=FormattingHelper.formatString(hasRow)%>"/>
<impact:validateInput type="hidden" name="hdnIndValidate" value="<%=FormattingHelper.formatString(indValidate)%>"/>
<impact:validateInput type="hidden" name="hdnIndCostSaved" value="<%=FormattingHelper.formatString(indCostSaved)%>"/>
<impact:validateInput type="hidden" name="hdnCIndInvoReadyForValid" value="<%=FormattingHelper.formatString(cfin02so.getCIndInvoReadyForValid())%>"/>
<impact:validateInput type="hidden" name="hdnReadyForValidation" value="<%= "true".equals(cIndInvoReadyForValid) ? ArchitectureConstants.Y : ArchitectureConstants.N %>"/>

<%
//  Always include this hidden field in your form
%>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>




<script type="text/javascript" language="JavaScript1.2">
<%
if (!(PageMode.getPageMode( request ).equals(PageModeConstants.NEW) || PageMode.getPageMode( request ).equals(PageModeConstants.VIEW) ))
{
%>
    setReadyForValid();
<%
}

InvoicePaginationDB invoicePaginationDB = (InvoicePaginationDB)
  state.getAttribute(InvoiceConversation.INVOICE_PAGINATION_DB,
                     request);

if ((invoicePaginationDB != null) &&
    (invoicePaginationDB.getUlIdInvoice() == GlobalData.getUlIdInvoice(request)))
{
  String hyperlinkName = null;
  if (invoicePaginationDB.getRowIndex() != 0)
  {
    hyperlinkName = ROW + invoicePaginationDB.getRowIndex();
%>
    function myOnLoad()
    {
      var hyperlink = document.getElementsByName("<%= hyperlinkName %>");
      hyperlink[0].focus();
    }
    window.attachEvent("onload", myOnLoad);
<%
  }
}
%>
  setCountyOptions('<%= county %>');
</script>
