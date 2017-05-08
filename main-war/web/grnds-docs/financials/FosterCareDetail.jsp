<%
//*  JSP Name:     Foster Care Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 01/16/2002
//*
//*  Description:
//*  This JSP is used to maintain a Foster Care Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/08/03  GRIMSHAN         SIR 17350 Fixed opening and closing java brackets
//**  05/12/03  GRIMSHAN         SIR 17422 Changed the From and To fields from
//**                             required to conditionally required
//**  04/05/04  CORLEYAN          SIR 22424 Reversal checkbox will now be keyed off of
//**                             if there is an "R" in the database, if it is an "A" or
//**                             an "O" the checkbox will remain unchecked.
//**  05/15/08  vdevarak          STGAP00007737: Modified this file as part of MR-012
//**  12/18/09  vdevarak          SMS#39513: Increased the length of the rate field from 7 to 8

%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN08SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN10SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN10SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceConversation" %>

<%
BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
//Get the output object from the request
ROWCFIN10SOG00 rowcfin10sog00 = (ROWCFIN10SOG00) request.getAttribute("ROWCFIN10SOG00");
//STGAP00007737: Getting the person id and resource id from the request.
int idPerson = (Integer)request.getAttribute("idPerson")==null ? 0: (Integer)request.getAttribute("idPerson");
int idResource = (Integer)request.getAttribute("idResource")==null ? 0: (Integer)request.getAttribute("idResource");
List serviceCodeOptions = (List) state.getAttribute(InvoiceConversation.SERVICE_CODE_OPTIONS, request);
Map serviceUnitTypes = (Map) state.getAttribute(InvoiceConversation.SERVICE_UNIT_TYPES, request);
CFIN10SO cfin10so = (CFIN10SO) request.getAttribute("CFIN10SO");
CFIN08SO cfin08so = (CFIN08SO) request.getAttribute("CFIN08SO");
CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);
String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
String indError = (String) request.getAttribute("indError");
String indValidate = (String) request.getAttribute("indValidate");
String indDayMismatch = (String) request.getAttribute("indDayMismatch");
String indInvoiceReversal = cfin02so.getSzCdInvoAdjustmentRb();
int ulIdPerson = 0;
int ulIdResource = 0;
String szNmPersonFull = "";
int lNbrRsrcFacilAcclaim = 0;
int uMoSvcDtlSvcMonth = 0;
int uYrSvcDtlServiceYear = 0;
int sNbrSvcDtlToDay = 0;
int sNbrSvcDtlFromDay = 0;
String szCdSvcDtlService = "";
double dAmtSvcDtlUnitRate = 0.0;
double dNbrSvcDtlUnitQty = 0.0;
double dAmtSvcDtlIncome= 0.0;
double itemTot = 0.0;
java.util.Date tsLastUpdate = new java.util.Date();
int ulIdSvcDtl = 0;
String cIndSvcDtlRejItem = "";
String szCdSvcDtlLiType = "";

// If cfin10 is  null, get from cfin08 and request, otherwise, get them from cfin02
if (cfin10so == null) {
  cfin10so = new CFIN10SO();
}

if (rowcfin10sog00 == null) {
  rowcfin10sog00 = new ROWCFIN10SOG00();
  if (cfin08so != null) {
    lNbrRsrcFacilAcclaim = cfin08so.getLNbrRsrcFacilAcclaim();
    szNmPersonFull = cfin08so.getSzNmPersonFull() ;
  } else {
    lNbrRsrcFacilAcclaim = ContextHelper.getIntSafe( request, "dspLNbrRsrcFacilAcclaim");
    szNmPersonFull = ContextHelper.getStringSafe(request, "dspSzNmPersonFull");
  }
  ulIdPerson = ContextHelper.getIntSafe( request, "txtUlIdPerson");
  ulIdResource = ContextHelper.getIntSafe( request, "txtUlIdResource");
  uMoSvcDtlSvcMonth = ContextHelper.getIntSafe( request, "txtUMoSvcDtlSvcMonth");
  uYrSvcDtlServiceYear = ContextHelper.getIntSafe( request, "txtUYrSvcDtlServiceYear");
  sNbrSvcDtlToDay = ContextHelper.getIntSafe( request, "txtSNbrSvcDtlToDay");
  sNbrSvcDtlFromDay = ContextHelper.getIntSafe( request, "txtSNbrSvcDtlFromDay");
  szCdSvcDtlService = ContextHelper.getStringSafe(request, "selSzCdSvcDtlService");
  dAmtSvcDtlUnitRate = ContextHelper.getDoubleSafe(request, "txtDAmtSvcDtlUnitRate");
  dNbrSvcDtlUnitQty = ContextHelper.getDoubleSafe(request, "txtDNbrSvcDtlUnitQty");
  dAmtSvcDtlIncome= ContextHelper.getMoneyAsDoubleSafe(request, "txtDAmtSvcDtlIncome");
  tsLastUpdate = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe( request, "hdnTsLastUpdate"));
  ulIdSvcDtl = ContextHelper.getIntSafe( request, "hdnUlIdSvcDtl");
  cIndSvcDtlRejItem = ContextHelper.getStringSafe( request, "hdnCIndSvcDtlRejItem");
  szCdSvcDtlLiType = ContextHelper.getStringSafe( request, "cbxReversal");
} else {
  ulIdPerson = rowcfin10sog00.getUlIdPerson();
  ulIdResource = rowcfin10sog00.getUlIdResource();
  if (cfin08so != null) {
    lNbrRsrcFacilAcclaim = cfin08so.getLNbrRsrcFacilAcclaim();
    szNmPersonFull = cfin08so.getSzNmPersonFull() ;
  } else {
    szNmPersonFull = rowcfin10sog00.getSzNmPersonFull();
    lNbrRsrcFacilAcclaim = rowcfin10sog00.getLNbrRsrcFacilAcclaim();
  }
  uMoSvcDtlSvcMonth = rowcfin10sog00.getUMoSvcDtlSvcMonth();
  uYrSvcDtlServiceYear = rowcfin10sog00.getUYrSvcDtlServiceYear();
  sNbrSvcDtlToDay = rowcfin10sog00.getSNbrSvcDtlToDay();
  sNbrSvcDtlFromDay = rowcfin10sog00.getSNbrSvcDtlFromDay();
  szCdSvcDtlService = rowcfin10sog00.getSzCdSvcDtlService();
  dAmtSvcDtlUnitRate = rowcfin10sog00.getDAmtSvcDtlUnitRate();
  dNbrSvcDtlUnitQty = rowcfin10sog00.getSNbrSvcDtlUnitQty();
  dAmtSvcDtlIncome = rowcfin10sog00.getDAmtSvcDtlIncome();
  tsLastUpdate = rowcfin10sog00.getTsLastUpdate();
  ulIdSvcDtl = rowcfin10sog00.getUlIdSvcDtl();
  cIndSvcDtlRejItem = rowcfin10sog00.getCIndSvcDtlRejItem();
  if ("R".equals(rowcfin10sog00.getSzCdSvcDtlLiType()) ) {
    szCdSvcDtlLiType = "Y";
  } else {
    szCdSvcDtlLiType = "N";
  }
}

//STGAP00007737: If the person Id or resource id is 0 then set it with the person Id or resource Id extracted 
//that has been extracted from one of the existing line items if any.
if(ulIdPerson == 0){
   ulIdPerson = idPerson;
}
if(ulIdResource == 0){
   ulIdResource = idResource;
}
itemTot = InvoiceConversation.calculateFosterCareLineItemTotal(rowcfin10sog00);


%>
<% // Start Javascript Section
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

<% InvoiceConversation.writeJavascriptVars(out, serviceUnitTypes, "serviceArray"); %>

  function setUnitQty() {
    frmFosterDetail.hdnSNbrSvcDtlUnitQty.value = frmFosterDetail.txtDNbrSvcDtlUnitQty.value;
    
    var svc = frmFosterDetail.selSzCdSvcDtlService.value;
    if(svc != null && svc != "") {
      frmFosterDetail.hdnCdUnitType.value = eval("serviceArray[k"+svc+"]");
    }
  }

  function checkUnitType(noSetValues) {
    var setValues = !noSetValues;
    var from = frmFosterDetail.txtSNbrSvcDtlFromDay;
    var to = frmFosterDetail.txtSNbrSvcDtlToDay;
    var units = frmFosterDetail.txtDNbrSvcDtlUnitQty;
    
    var svc = frmFosterDetail.selSzCdSvcDtlService.value;
    if(svc == null || svc == "") {
      from.value = "";
      to.value = "";
      units.value = "";
      from.disabled = true;
      to.disabled = true;
      units.disabled = true;
      calculateTotal(false);
      return;
    }
    
    var ut = eval("serviceArray[k"+svc+"]");    
    if(ut == "DAY" || ut == "DA2") {
      //-- enable From and To; disable Units
      from.disabled = false;
      to.disabled = false;
      units.disabled = true;
      if(setValues) {
        from.value = "1";
        to.value = "1";
        from.focus();
      }
      calculateTotal(true);
    } else {
      //-- enable Units; disable From and To
      from.disabled = true;
      to.disabled = true;
      units.disabled = false;
      if(setValues) {
        from.value = "";
        to.value = "";
        units.value = "1.00";
        units.focus();
      }
      calculateTotal(false);
    }
  }

  function calculateTotal(setUnits) {
    var r = refValue("txtDAmtSvcDtlUnitRate");
    var f = refValue("txtSNbrSvcDtlFromDay");
    var t = refValue("txtSNbrSvcDtlToDay");
    var u = refValue("txtDNbrSvcDtlUnitQty");
    
    if(!frmFosterDetail.txtSNbrSvcDtlFromDay.disabled) {
      u = t - f + 1;
    }
    
    var total = r * u;
    if(total < 0) {
      total = 0;
    }
    
    if(setUnits) {
      if(u < 0) {
        u = 0;
      }
      if(u == 0) {
        frmFosterDetail.txtDNbrSvcDtlUnitQty.value = "0.00";
      } else {
        try {
          frmFosterDetail.txtDNbrSvcDtlUnitQty.value = u.toFixed(2);
        } catch(e) {} //-- this catch needed to avoid browser displaying javascript error
      }
    }
    
    total = total.toFixed(2); //-- automatically rounds
    var sTotal = "$ "+total;
    try {
      var spanTag = document.getElementById("dspItemTot_id");
      spanTag.childNodes[0].nodeValue = sTotal;
    } catch(e) {}
  }
  
  function refValue(inputName) {
    var val = "";
    try {
      val = eval("frmFosterDetail."+inputName+".value");
    } catch(e) {}
    
    if(val == "" || isNaN(val)) {
      val = 0;
    }
    return val;
  }
  
  function fieldsBlank()
  {
    if (frmFosterDetail.txtUlIdPerson.value == ""  || frmFosterDetail.txtUlIdResource.value == "")
    {
        alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_FOSTER_NOT_VALIDATED) %>');
        return false;
    }
    else
    {
      return true;
    }
  }

  function cancelValidation () {
    disableValidation('frmFosterDetail');
  }

  //  Called onUnload of page to remind user unsaved data will be lost
  window.onbeforeunload = function () {
    IsDirty();
  }

  function disableReversal() {
    var indInvoiceReversal = frmFosterDetail.hdnIndInvoiceReversal.value;
    if (indInvoiceReversal == "I" ||
        indInvoiceReversal == "<%= CodesTables.CINVADJT_Y %>" ||
        indInvoiceReversal == "<%= CodesTables.CINVADJT_C %>") {
      frmFosterDetail.cbxReversal.disabled = false;
    } else {
      frmFosterDetail.cbxReversal.disabled = true;
    }
  }

</script>
<% //End Javascript Section
%>

<%
  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;

  //Initialize the variables that will specify the display rules for individual fields
  String overallPageMode = PageMode.getPageMode(request);
   
  if(!InvoiceConversation.optionsContainsCode(serviceCodeOptions, szCdSvcDtlService)) {
    szCdSvcDtlService = null;
  }
%>

<impact:validateErrors/>
<impact:validateForm name="frmFosterDetail"
  method="post"
  action="/financials/Invoice/saveFoster"
  pageMode="<%= overallPageMode %>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.FosterCareCustomValidation"
  schema="/WEB-INF/Constraints.xsd">
  
  <%-- Include any hidden fields needed on the page
       Hidden fields are used for variables passed into the page as request parameters
       AND for hidden fields that need to be used for saving or deleting the detail on this page. --%>
  <impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>"/>
  <impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= DateHelper.toISOString(tsLastUpdate) %>"/>
  <impact:validateInput type="hidden" name="hdnUlIdSvcDtl" value="<%= FormattingHelper.formatInt(ulIdSvcDtl) %>"/>
  <impact:validateInput type="hidden" name="hdnCIndSvcDtlRejItem" value="<%= FormattingHelper.formatString(cIndSvcDtlRejItem) %>"/>
  <impact:validateInput type="hidden" name="hdnIndInvoiceReversal" value="<%= FormattingHelper.formatString(indInvoiceReversal) %>"/>
  <impact:validateInput type="hidden" name="hdnSNbrSvcDtlUnitQty" value=""/>
  <impact:validateInput type="hidden" name="hdnCdUnitType" value=""/>
  <impact:validateInput type="hidden" name="hdnDtDtInvoReceivedDate" value="<%= FormattingHelper.formatDate(cfin02so.getDtDtInvoReceivedDate()) %>"/>
  <impact:validateInput type="hidden" name="hdnIndValidate" value="<%=FormattingHelper.formatString(indValidate)%>"/>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />

<% /* Begin Detail */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="9">Foster Care</th>
  </tr>
  <tr>
    <td colspan="2"><impact:validateInput
                colspan="2"
                type="text"
                name="txtUlIdPerson"
                onChange="frmFosterDetail.hdnIndValidate.value = 'N'"
                label="Person ID"
                constraint="ID"
                required="true"
                value="<%= FormattingHelper.formatInt(ulIdPerson) %>"
                editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                size="10"
                maxLength="10"
                tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td colspan="2"><impact:validateInput
                colspan="2"
                type="text"
                name="txtUlIdResource"
                onChange="frmFosterDetail.hdnIndValidate.value = 'N'"
                label="Resource ID"
                constraint="ID"
                required="true"
                value="<%= FormattingHelper.formatInt(ulIdResource) %>"
                editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                size="10"
                maxLength="10"
                tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td><impact:ButtonTag
          name="btnValidate"
          img="btnValidate"
          function="cancelValidation(); return fieldsBlank()"
          editableMode="<%= EditableMode.NEW + EditableMode.EDIT %>"
          form="frmFosterDetail"
          action="/financials/Invoice/validateFoster"
          tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td colspan="2"><impact:validateDisplayOnlyField
                colspan="2"
                name="dspSzNmPersonFull"
                label="Name"
                value="<%=FormattingHelper.formatString(szNmPersonFull)%>" />
    </td>
    <td colspan="2"><impact:validateDisplayOnlyField
                colspan="2"
                name="dspLNbrRsrcFacilAcclaim"
                label="Facility Number"
                value="<%=FormattingHelper.formatInt(lNbrRsrcFacilAcclaim)%>" />
    </td>
  </tr>
  <tr onkeyup="javascript:calculateTotal(true);">
    <td><impact:validateInput
          type="text"
          name="txtUMoSvcDtlSvcMonth"
          label="Month"
          constraint="MonthNumber"
          required="true"
          value="<%= FormattingHelper.formatInt(uMoSvcDtlSvcMonth) %>"
          editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
          size="2"
          maxLength="2"
          tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput
          type="text"
          name="txtUYrSvcDtlServiceYear"
          label="Year"
          constraint="Year"
          required="true"
          value="<%= FormattingHelper.formatInt(uYrSvcDtlServiceYear) %>"
          editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
          size="4"
          maxLength="4"
          tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput
          type="text"
          name="txtSNbrSvcDtlFromDay"
          label="From"
          conditionallyRequired="true"
          constraint="Day"
          value="<%= FormattingHelper.formatInt(sNbrSvcDtlFromDay) %>"
          editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
          size="2"
          maxLength="2"
          tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput
          type="text"
          name="txtSNbrSvcDtlToDay"
          label="To"
          conditionallyRequired="true"
          constraint="Day"
          value="<%= FormattingHelper.formatInt(sNbrSvcDtlToDay) %>"
          editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
          size="2"
          maxLength="2"
          tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td colspan="2"><impact:validateSelect
                colspan="7"
                label="Service"
                name="selSzCdSvcDtlService"
                options="<%= serviceCodeOptions %>"
                required="true"
                onChange="javascript:checkUnitType(false);"
                value="<%=FormattingHelper.formatString(szCdSvcDtlService)%>"
                tabIndex="<%= tabIndex++ %>" /></td>
  </tr>
  <tr onkeyup="javascript:calculateTotal(false);">
    <td colspan="2"><impact:validateInput
                colspan="2"
                type="text"
                name="txtDAmtSvcDtlUnitRate"
                label="Rate"
                constraint="DoubleToHundredths"
                required="true"
                value="<%= FormattingHelper.formatDouble(dAmtSvcDtlUnitRate, 2) %>"
                editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                size="8"
                maxLength="8"
                tabIndex="<%= tabIndex++ %>"/></td>
    <td colspan="2">
      <impact:validateInput
        name="txtDNbrSvcDtlUnitQty"
        label="Units"
        type="text"
        conditionallyRequired="true"
        colspan="2"
        constraint="DoubleToHundredths"
        value="<%= FormattingHelper.formatDouble(dNbrSvcDtlUnitQty, 2) %>"
        editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
        size="7"
        maxLength="7"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
  <tr>
    <td colspan="2"><impact:validateInput
                colspan="2"
                type="text"
                name="txtDAmtSvcDtlIncome"
                label="Income"
                constraint="Money"
                value="<%= FormattingHelper.formatMoney(dAmtSvcDtlIncome) %>"
                editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                size="11"
                maxLength="11"
                tabIndex="<%= tabIndex++ %>"/></td>
    <td colspan="2"><impact:validateDisplayOnlyField
                colspan="2"
                name="dspItemTot"
                label="Item Total"
                value="<%=FormattingHelper.formatMoney(itemTot)%>" /></td>
  </tr>
  <tr>
     <td colspan="2"><impact:validateInput
                  colspan="2"
                  checked="<%=FormattingHelper.formatString(szCdSvcDtlLiType)%>"
                  tabIndex="<%= tabIndex++ %>"
                  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
                  value="R"
                  type="checkbox"
                  name="cbxReversal"
                  label="Reversal"
                  cssClass="formInput" />
    </td>
  </tr>
  </table>
<% // Only display the save pushbutton if an error has not been returned from the validate service,
   // and the validate service has been run
   //STGAP00007737: Added the check on indDayMismatch to make the save button available if the 
   //error is From or To day mismatch.
if (indError != null && ("N".equals(indError) || ArchitectureConstants.Y.equals(indDayMismatch))) {
%>
<table width="100%" cellpadding="3" cellspacing="0" border="0">
  <tr>
    <td class="alignRight">
         <impact:ButtonTag
               name="btnSave"
               img="btnSave"
               form="frmFosterDetail"
               restrictRepost="true"
               function="javascript:setUnitQty();"
               action="/financials/Invoice/saveFoster"
               editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
               tabIndex="<%= tabIndex++ %>"/>
    </td>
   </tr>
</table>
<% } %>
</impact:validateForm> <%-- /* Close Validate Form Custom Tag */ --%>

<script type="text/javascript" language="JavaScript1.2">
<%
  if (!PageMode.getPageMode( request ).equals(PageModeConstants.VIEW) ) {
%>
  disableReversal();
<% } %>
  checkUnitType(<%= String.valueOf( PageModeConstants.MODIFY.equals(overallPageMode) || PageModeConstants.VIEW.equals(overallPageMode) ) %>);
</script>
