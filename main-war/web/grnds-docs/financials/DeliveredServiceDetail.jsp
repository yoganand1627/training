<%
//*  JSP Name:     Foster Care Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 01/16/2002
//*
//*  Description:
//*  This JSP is used to maintain Delivered Service Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/08/03  GRIMSHAN          SIR 17286 Changed the get for the information from
//**                              request, after validate to not include unit rate,
//**                              it was overwriting the unit rate returned from the service.
//**  05/13/03  GRIMSHAN          SIR 17293 Changed the get for the information from
//**                              request, after validate to not include Service Auth ID,
//**                              it was overwriting the unit rate returned from the service.
//**  06/18/03  GRIMSHAN          SIR 18369 Unit Type will now be enabled for Modify, but
//**                              the user can only change the value from what it currently is
//**                              to No Show, or leave it the same.
//**  06/23/03  GRIMSHAN          SIR 18463 set overall page mode into hdn page mode.
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

<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN06SOG" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%// Import needed for Form Launch

BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

//Get the output object from the request
     ROWCFIN06SOG rowcfin06sog = (ROWCFIN06SOG) request.getAttribute("ROWCFIN06SOG");
     //STGAP00007737: Getting the person id from the request.
     int idPerson = (Integer)request.getAttribute("idPerson")== null? 0:(Integer)request.getAttribute("idPerson");
     CFIN06SO cfin06so = (CFIN06SO) request.getAttribute("CFIN06SO");
     CFIN29SO cfin29so = (CFIN29SO) request.getAttribute("CFIN29SO");
     String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
     CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);
     //Set excludeViews = (Set) state.getAttribute("excludeViews", request);
     //Set serviceCodeOptions = (Set) state.getAttribute(InvoiceConversation.SERVICE_CODE_OPTIONS, request);
     Set countyOptions = (Set) state.getAttribute(InvoiceConversation.COUNTY_OPTIONS, request);
     String indError = (String) request.getAttribute("indError");
     String indValidate = (String) request.getAttribute("indValidate");


     int ulIdPerson = 0;
     int uMoSvcDtlSvcMonth = 0;
     int uYrSvcDtlServiceYear = 0;
     java.util.Date tsLastUpdate = new java.util.Date();
     int ulIdSvcDtl = 0;
     int ulIdSvcAuthDtl = 0;
     String cIndSvcDtlRejItem = "";
     String szCdSvcDtlService = "";
     String szCdSvcDtlCounty = "";
     String szScrNmGenericFullName = "";
     int usNbrSvcDtlCsli = 0;
     String szCdSvcDtlUnitType = "";
     double dAmtSvcDtlUnitRate = 0.0;
     double sNbrSvcDtlUnitQty = 0.0;
     double dAmtSvcDtlFeePaid = 0.0;
     String szCdCnsvcPaymentType = "";

     if (cfin06so == null) {
       cfin06so = new CFIN06SO();
     }


     if (rowcfin06sog == null)
     {
       rowcfin06sog = new ROWCFIN06SOG();
       if (cfin29so != null)
       {
         ulIdSvcAuthDtl = cfin29so.getUlIdSvcAuthDtl();
         szScrNmGenericFullName = cfin29so.getSzNmPersonFull();
         usNbrSvcDtlCsli = cfin29so.getUsNbrSvcDtlCsli();
         szCdSvcDtlUnitType = cfin29so.getSzCdSvcDtlUnitType();
         dAmtSvcDtlUnitRate = cfin29so.getDAmtSvcDtlUnitRate();
         szCdCnsvcPaymentType = cfin29so.getSzCdCnsvcPaymentType();

       }
       else
       {
         ulIdSvcAuthDtl = ContextHelper.getIntSafe( request, "hdnUlIdSvcAuthDtl");
         szScrNmGenericFullName = ContextHelper.getStringSafe( request, "dspSzScrNmGenericFullName");
         usNbrSvcDtlCsli = ContextHelper.getIntSafe( request, "dspUsNbrSvcDtlCsli");
         szCdSvcDtlUnitType = ContextHelper.getStringSafe( request, "dspSzCdSvcDtlUnitType");
         dAmtSvcDtlUnitRate = ContextHelper.getDoubleSafe( request, "txtDAmtSvcDtlUnitRate");
         szCdCnsvcPaymentType = ContextHelper.getStringSafe( request, "hdnSzCdCnsvcPaymentType");
       }

       ulIdPerson = ContextHelper.getIntSafe( request, "txtUlIdPerson");
       uMoSvcDtlSvcMonth = ContextHelper.getIntSafe( request, "txtUMoSvcDtlSvcMonth");
       uYrSvcDtlServiceYear = ContextHelper.getIntSafe( request, "txtUYrSvcDtlServiceYear");
       tsLastUpdate = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe( request, "hdnTsLastUpdate"));
       ulIdSvcDtl = ContextHelper.getIntSafe( request, "hdnUlIdSvcDtl");
       cIndSvcDtlRejItem = ContextHelper.getStringSafe( request, "hdnCIndSvcDtlRejItem");
       szCdSvcDtlService = ContextHelper.getStringSafe(request, "selSzCdSvcDtlService");
       szCdSvcDtlCounty = ContextHelper.getStringSafe( request, "selSzCdSvcDtlCounty");
       sNbrSvcDtlUnitQty = ContextHelper.getDoubleSafe( request, "txtSNbrSvcDtlUnitQty");
       dAmtSvcDtlFeePaid = ContextHelper.getMoneyAsDoubleSafe( request, "txtDAmtSvcDtlFeePaid");
     }
     else
     {
       ulIdPerson = rowcfin06sog.getUlIdPerson();
       uMoSvcDtlSvcMonth = rowcfin06sog.getUMoSvcDtlSvcMonth();
       uYrSvcDtlServiceYear = rowcfin06sog.getUYrSvcDtlServiceYear();
       tsLastUpdate = rowcfin06sog.getTsLastUpdate();
       ulIdSvcDtl = rowcfin06sog.getUlIdSvcDtl();
       ulIdSvcAuthDtl = rowcfin06sog.getUlIdSvcAuthDtl();
       cIndSvcDtlRejItem = rowcfin06sog.getCIndSvcDtlRejItem();
       szCdSvcDtlService = rowcfin06sog.getSzCdSvcDtlService();
       szCdSvcDtlCounty = rowcfin06sog.getSzCdSvcDtlCounty();
       szScrNmGenericFullName = rowcfin06sog.getSzScrNmGenericFullName();
       usNbrSvcDtlCsli = rowcfin06sog.getUsNbrSvcDtlCsli();
       szCdSvcDtlUnitType = rowcfin06sog.getSzCdSvcDtlUnitType();
       dAmtSvcDtlUnitRate =rowcfin06sog.getDAmtSvcDtlUnitRate();
       sNbrSvcDtlUnitQty = rowcfin06sog.getSNbrSvcDtlUnitQty();
       dAmtSvcDtlFeePaid = rowcfin06sog.getDAmtSvcDtlFeePaid();
       szCdCnsvcPaymentType = rowcfin06sog.getSzCdCnsvcPaymentType();

     }
     //STGAP00007737: If the person Id is 0 then set it with the person Id extracted 
     //that has been extracted from one of the existing line items if any.
     if(ulIdPerson == 0){
          ulIdPerson = idPerson;
        }
     double itemTotal = InvoiceConversation.calculateDelSvcAdoAsstLineItemTotal(rowcfin06sog);
     
     //if(!InvoiceConversation.optionsContainsCode(serviceCodeOptions, szCdSvcDtlService)) {
     //  szCdSvcDtlService = null;
     //}
     
     if(!InvoiceConversation.optionsContainsCode(countyOptions, szCdSvcDtlCounty)) {
       szCdSvcDtlCounty = "";
     }
     
     //if (StringHelper.isValid(request.getParameter("dspItemTotal")))
     //{
     ///  itemTotal = ContextHelper.getMoneyAsDoubleSafe( request, "dspItemTotal");
     //}
     //else
     //{
     //  double unitRate = rowcfin06sog.getDAmtSvcDtlUnitRate();
     //  double roundRate = Math.round(unitRate*100)/100.0;
     //  double subTotal = (rowcfin06sog.getSNbrSvcDtlUnitQty() * roundRate);
     //  itemTotal = subTotal - rowcfin06sog.getDAmtSvcDtlFeePaid();
     //}

     // SIR 18369 when the page is in modify mode we only want to show the value
     // previously saved, and the value of "No Show" for Unit type.  First, loop
     // through the codes tables and add all of the values in the codes table to
     // a list that will be used to exclude the options from the dropdown.  Then,
     // remove the value returned from the database, and the "No Show" value from the
     // exclude list.


%>
<% // Start Javascript Section
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
     <% InvoiceConversation.writeJavascriptArrays(out, request, InvoiceConversation.COUNTY_SERVICE_MAP, CodesTables.CSVCCODE, "c"); %>
     
     function setServiceOptions(serviceCode) {
       var countyValue = document.frmDeliveredDetail.selSzCdSvcDtlCounty.value;
       var serviceDropdown = document.frmDeliveredDetail.selSzCdSvcDtlService;
       if(countyValue != null && countyValue != "") {
         var optionsArray = eval("c"+countyValue);
         try {
           populateDropdown(serviceDropdown, serviceCode, optionsArray);
         } catch(e) {
           populateDropdown(document.frmDeliveredDetail.selSzCdSvcDtlService_Disabled, serviceCode, optionsArray);
         }
       } else {
         try {
           clearDropdown(serviceDropdown);
         } catch(e) {
           clearDropdown(document.frmDeliveredDetail.selSzCdSvcDtlService_Disabled);
         }
       }
     }

    //  Called onUnload of page to remind user unsaved data will be lost
     window.onbeforeunload = function ()
     {
       IsDirty();
     }

     function fieldsBlank()
     {
       if (frmDeliveredDetail.txtUlIdPerson.value == ""  || frmDeliveredDetail.txtUMoSvcDtlSvcMonth.value == "" ||
           frmDeliveredDetail.txtUYrSvcDtlServiceYear.value == "" || frmDeliveredDetail.selSzCdSvcDtlService.value == "" ||
           frmDeliveredDetail.selSzCdSvcDtlCounty.value == "")
       {
        alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_DEL_NOT_VALIDATED) %>');
        return false;
       }
       else
       {
         return true;
       }
     }

     function cancelValidation ()
       {
         disableValidation('frmDeliveredDetail');
       }


</script>
<% //End Javascript Section
%>

<%
  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;

   String overallPageMode = PageModeConstants.EDIT;

   if (request.getAttribute("pageMode") != null )
   {
     overallPageMode = (String) request.getAttribute("pageMode");
   }

   // SIR 18369 when the page is in modify mode we only want to show the value
   // previously saved, and the value of "No Show" for Unit type.  First, loop
   // through the codes tables and add all of the values in the codes table to
   // a list that will be used to exclude the options from the dropdown.  Then,
   // remove the value returned from the database, and the "No Show" value from the
   // exclude list.

   Set<String> excludeOptions = null;
   if ( overallPageMode.equals( PageModeConstants.MODIFY ))
   {
    excludeOptions = new HashSet<String>( Lookup.getCategoryCodesCollection( CodesTables.CINVUTYP ) );
    excludeOptions.remove( CodesTables.CINVUTYP_NOS );
    excludeOptions.remove( rowcfin06sog.getSzCdSvcDtlUnitType() );

   }
   else
   {
     excludeOptions = new HashSet<String>();
   }

%>
<impact:validateErrors/>
<impact:validateForm name="frmDeliveredDetail"
  method="post"
  action="/financials/Invoice/saveDelivered"
validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.DeliveredCustomValidation"
  pageMode="<%= overallPageMode %>"
  schema="/WEB-INF/Constraints.xsd">
<%--  Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page
  --%>

  <impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>"/>
  <impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= DateHelper.toISOString(tsLastUpdate) %>"/>
  <impact:validateInput type="hidden" name="hdnUlIdSvcDtl" value="<%= FormattingHelper.formatInt(ulIdSvcDtl)  %>"/>
  <impact:validateInput type="hidden" name="hdnUlIdSvcAuthDtl" value="<%= FormattingHelper.formatInt(ulIdSvcAuthDtl)  %>"/>
  <impact:validateInput type="hidden" name="hdnCIndSvcDtlRejItem" value="<%= FormattingHelper.formatString(cIndSvcDtlRejItem) %>"/>
  <impact:validateInput type="hidden" name="hdnSzCdCnsvcPaymentType" value="<%= FormattingHelper.formatString(szCdCnsvcPaymentType) %>"/>
  <impact:validateInput type="hidden" name="hdnDtDtInvoReceivedDate" value="<%= FormattingHelper.formatDate(cfin02so.getDtDtInvoReceivedDate()) %>"/>
  <impact:validateInput type="hidden" name="hdnUMoInvoMonth" value="<%= FormattingHelper.formatInt(cfin02so.getUMoInvoMonth()) %>"/>
  <impact:validateInput type="hidden" name="hdnUYrInvoYear" value="<%= FormattingHelper.formatInt(cfin02so.getUYrInvoYear()) %>"/>
  <impact:validateInput type="hidden" name="hdnSzCdInvoType" value="<%= FormattingHelper.formatString(cfin02so.getSzCdInvoType()) %>"/>
  <impact:validateInput type="hidden" name="hdnIndInvoiceReversal" value="<%= FormattingHelper.formatString(cfin02so.getSzCdInvoAdjustmentRb()) %>"/>
  <impact:validateInput type="hidden" name="hdnPageMode" value="<%= FormattingHelper.formatString(overallPageMode) %>"/>
  <impact:validateInput type="hidden" name="hdnIndValidate" value="<%=FormattingHelper.formatString(indValidate)%>"/>


<% /* Begin Detail */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="9">Delivered Service</th>
  </tr>
  <tr>
    <td><impact:validateInput type="text" name="txtUlIdPerson" label="Person ID" onChange="frmDeliveredDetail.hdnIndValidate.value = 'N'" constraint="ID" required="true" value="<%= FormattingHelper.formatInt(ulIdPerson) %>" editableMode="<%= EditableMode.NEW %>" size="10" maxLength="10" tabIndex="<%= tabIndex++ %>"/>
    </td>
        <td><impact:validateInput type="text" name="txtUMoSvcDtlSvcMonth" label="Month" onChange="frmDeliveredDetail.hdnIndValidate.value = 'N'" constraint="MonthNumber" required="true" value="<%= FormattingHelper.formatInt(uMoSvcDtlSvcMonth) %>"  editableMode="<%= EditableMode.NEW %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput type="text" name="txtUYrSvcDtlServiceYear" label="Year" onChange="frmDeliveredDetail.hdnIndValidate.value = 'N'" constraint="Year" required="true" value="<%= FormattingHelper.formatInt(uYrSvcDtlServiceYear) %>"  editableMode="<%= EditableMode.NEW %>" size="4" maxLength="4" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td>
      <impact:validateSelect
        colspan="5"
        label="Service"
        onChange="frmDeliveredDetail.hdnIndValidate.value = 'N'"
        name="selSzCdSvcDtlService"
        value="<%= FormattingHelper.formatString(szCdSvcDtlService) %>"
        editableMode="<%= EditableMode.NEW %>"
        required="true"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
  <tr>  
    <td>
      <impact:validateSelect
        label="County"
        contentType="<%= SelectTag.DECODES %>"
        name="selSzCdSvcDtlCounty"
        required="true"
        onChange="setServiceOptions('')"
        options="<%= countyOptions %>"
        editableMode="<%= EditableMode.NEW %>"
        value="<%= FormattingHelper.formatString(szCdSvcDtlCounty) %>"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
    <impact:ButtonTag name="btnValidate" img="btnValidate" function="cancelValidation(); return fieldsBlank()"  editableMode="<%= EditableMode.NEW %>" form="frmDeliveredDetail" action="/financials/Invoice/validateDelivered" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField name="dspSzScrNmGenericFullName" label="Name"  value="<%=FormattingHelper.formatString(szScrNmGenericFullName)%>" />
    </td>
    <td><impact:validateDisplayOnlyField name="dspUsNbrSvcDtlCsli" label="CSLI"  value="<%=FormattingHelper.formatInt(usNbrSvcDtlCsli)%>" />
    </td>
  </tr>
  <tr>
    <td><impact:validateSelect name="selSzCdSvcDtlUnitType" label="UT" excludeOptions="<%=excludeOptions%>" contentType="<%=SelectTag.CODES_DECODES%>"  value="<%=FormattingHelper.formatString(szCdSvcDtlUnitType)%>" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" required="true"  tabIndex="<%= tabIndex++ %>" codesTable="CINVUTYP" />
    </td>
  </tr>
  <tr>
    <td><% // If the payment type is Cost Reimbursement, this field will be a display only field
         if (szCdCnsvcPaymentType!= null && "CRM".equals(szCdCnsvcPaymentType))
         { %>
         <impact:validateDisplayOnlyField name="txtDAmtSvcDtlUnitRate" label="Rate"  value="<%=FormattingHelper.formatDouble(dAmtSvcDtlUnitRate, 2)%>" />
         <% } else { %>
         <impact:validateInput type="text" name="txtDAmtSvcDtlUnitRate" label="Rate" constraint="Double" conditionallyRequired="true" value="<%= FormattingHelper.formatDouble(dAmtSvcDtlUnitRate, 2) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="8" maxLength="8" tabIndex="<%= tabIndex++ %>"/></td>
        <% } %>
    <td><impact:validateInput type="text" name="txtSNbrSvcDtlUnitQty" label="Quantity" constraint="Double" value="<%= FormattingHelper.formatDouble(sNbrSvcDtlUnitQty, 2 )%>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="8" maxLength="8" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td><impact:validateInput type="text" name="txtDAmtSvcDtlFeePaid" label="Fee Paid" constraint="Money" value="<%= FormattingHelper.formatMoney(dAmtSvcDtlFeePaid )%>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateDisplayOnlyField name="dspItemTotal" label="Item Total"  value="<%=FormattingHelper.formatMoney(itemTotal)%>" />
    </td>
  </tr>
  </table>
<% // Only display the save pushbutton if an error has not been returned from the validate service
   // and the validate service has been run
if (indError != null && "N".equals(indError))
{
%>
<table width="100%" cellpadding="3" cellspacing="0" border="0">
  <tr>
    <td class="alignRight">
         <impact:ButtonTag name="btnSave" img="btnSave" form="frmDeliveredDetail" action="/financials/Invoice/saveDelivered" restrictRepost="true" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>"/>
    </td>
   </tr>
</table>
<% } %>


<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>

<script type="text/javascript">
<!--
  setServiceOptions('<%= FormattingHelper.formatString(szCdSvcDtlService) %>');
//-->
</script>
