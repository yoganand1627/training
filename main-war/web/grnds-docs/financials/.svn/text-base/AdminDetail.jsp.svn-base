<%
//*  JSP Name:     Administrative Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 01/16/2002
//*
//*  Description:
//*  This JSP is used to maintain a Administrative Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/08/03  GRIMSHNAN         SIR 17354 Fixed opening and closing java brackets
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="java.util.Set" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN15SOG00"%>
<%

BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
//Get the output object from the request
ROWCFIN15SOG00 rowcfin15sog00 = (ROWCFIN15SOG00) request.getAttribute("ROWCFIN15SOG00");
//Set excludeViews = (Set) state.getAttribute("excludeViews", request);
//Set serviceCodeOptions = (Set) state.getAttribute(InvoiceConversation.SERVICE_CODE_OPTIONS, request);
Set countyOptions = (Set) state.getAttribute(InvoiceConversation.COUNTY_OPTIONS, request);
CFIN15SO cfin15so = (CFIN15SO) request.getAttribute("CFIN15SO");
String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);

//String selSzCdCounty = "";
//String comments = "";

if (cfin15so == null) {
 cfin15so = new CFIN15SO();
}

String cdService = ContextHelper.getStringSafe(request, "selSzCdAdminDtlService");
String county = ContextHelper.getStringSafe(request, "selSzCdCounty");

if (rowcfin15sog00 == null) {
  rowcfin15sog00 = new ROWCFIN15SOG00();
} else {
  cdService = rowcfin15sog00.getSzCdAdminDtlService();
  county = rowcfin15sog00.getSzCdCounty();
}

//if(!InvoiceConversation.optionsContainsCode(serviceCodeOptions, cdService)) {
//  cdService = null;
//}
if(!InvoiceConversation.optionsContainsCode(countyOptions, county)) {
  county = "";
}

%>
<% // Start Javascript Section
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
     <% InvoiceConversation.writeJavascriptArrays(out, request, InvoiceConversation.COUNTY_SERVICE_MAP, CodesTables.CSVCCODE, "c"); %>
     
     function setServiceOptions(serviceCode) {
       var countyValue = document.frmAdminDetail.selSzCdCounty.value;
       var serviceDropdown = document.frmAdminDetail.selSzCdAdminDtlService;
       if(countyValue != null && countyValue != "") {
         var optionsArray = eval("c"+countyValue);
         try {
           populateDropdown(serviceDropdown, serviceCode, optionsArray);
         } catch(e) {
           populateDropdown(document.frmAdminDetail.selSzCdAdminDtlService_Disabled, serviceCode, optionsArray);
         }
       } else {
         try {
           clearDropdown(serviceDropdown);
         } catch(e) {
           clearDropdown(document.frmAdminDetail.selSzCdAdminDtlService_Disabled);
         }
       }
     }

    //  Called onUnload of page to remind user unsaved data will be lost
     window.onbeforeunload = function ()
     {
       IsDirty();
     }

</script>
<% //End Javascript Section
%>

<%
  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;


  //Initialize the variables that will specify the display rules for individual fields

  //String pageModePassed = "";
  String overallPageMode = PageMode.getPageMode(request);

   //if (request.getAttribute("pageMode") != null )
   //{
   //  pageModePassed = (String) request.getAttribute("pageMode");
   //  if (pageModePassed.equals(PageModeConstants.MODIFY))
   //  {
   //    overallPageMode = PageModeConstants.EDIT;
   //  }
   //  else if (pageModePassed.equals(PageModeConstants.NEW))
   //  {
   //    overallPageMode = PageModeConstants.NEW;
   //  }
   //  else if (pageModePassed.equals(PageModeConstants.VIEW))
   //  {
   //    overallPageMode = PageModeConstants.VIEW;
   //  }
   //}

%>
<impact:validateErrors/>
<impact:validateForm name="frmAdminDetail"
  method="post"
  action="/financials/Invoice/saveAdmin"
  pageMode="<%= overallPageMode %>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.AdminCustomValidation"
  schema="/WEB-INF/Constraints.xsd">
<%--  Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page.
  --%>

  <impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>"/>
  <impact:validateInput type="hidden" name="hdnSzCdAdminDtlInvoDisptn" value="<%= FormattingHelper.formatString(rowcfin15sog00.getSzCdAdminDtlInvoDisptn())  %>"/>
  <impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= DateHelper.toISOString(rowcfin15sog00.getTsLastUpdate()) %>"/>
  <impact:validateInput type="hidden" name="hdnUlIdAdminDtl" value="<%= FormattingHelper.formatInt(rowcfin15sog00.getUlIdAdminDtl())  %>"/>
  <impact:validateInput type="hidden" name="hdnCIndAdminDtlRejItm" value="<%= FormattingHelper.formatString(rowcfin15sog00.getCIndAdminDtlRejItm()) %>"/>
  <impact:validateInput type="hidden" name="hdnIndInvoiceReversal" value="<%= FormattingHelper.formatString(cfin02so.getSzCdInvoAdjustmentRb()) %>"/>
  <impact:validateInput type="hidden" name="hdnDtDtInvoReceivedDate" value="<%= FormattingHelper.formatDate(cfin02so.getDtDtInvoReceivedDate()) %>"/>
<% /* Begin Detail */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="9">Administrative</th>
  </tr>
  <tr>
    <td>
      <impact:validateSelect
        label="Service"
        name="selSzCdAdminDtlService"
        required="true"
        value="<%= FormattingHelper.formatString(cdService) %>"
        tabIndex="<%= tabIndex++ %>"
        colspan="3"
      />
    </td>
  </tr>
  <tr>
    <td><impact:validateSelect
        label="County"
        name="selSzCdCounty"
        onChange="setServiceOptions('')"
        tabIndex="<%= tabIndex++ %>"
        options="<%= countyOptions %>"
        required="true"
        editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
        value="<%= FormattingHelper.formatString(county) %>"/>
    </td>
    <td><impact:validateInput type="text" name="txtUsNbrAdminDtlCsli" label="CSLI" constraint="Digit2Less" required="true" value="<%= FormattingHelper.formatInt(rowcfin15sog00.getUsNbrAdminDtlCsli()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td><impact:validateInput type="text" name="txtUMoAdminDtlSvcMonth" label="Month" constraint="MonthNumber" required="true" value="<%= FormattingHelper.formatInt(rowcfin15sog00.getUMoAdminDtlSvcMonth()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="2" maxLength="2" tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput type="text" name="txtUYrAdminDtlSvcYear" label="Year" constraint="Year" required="true" value="<%= FormattingHelper.formatInt(rowcfin15sog00.getUYrAdminDtlSvcYear()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="4" maxLength="4" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td><impact:validateInput type="text" name="txtDAmtAdminDtlAdminAlloc" label="Administrative" constraint="Money" value="<%= FormattingHelper.formatMoney(rowcfin15sog00.getDAmtAdminDtlAdminAlloc()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput type="text" name="txtDAmtAdminDtlOther" label="Other" constraint="Money" value="<%= FormattingHelper.formatMoney(rowcfin15sog00.getDAmtAdminDtlOther()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td><impact:validateInput type="text" name="txtDAmtAdminPromotional" label="Promotional" constraint="Money" value="<%= FormattingHelper.formatMoney(rowcfin15sog00.getDAmtAdminDtlPromotional()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
    <td></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>
      <impact:validateInput name="txtComments"
            label="Comments"
            type="text"
            maxLength="80"
            width="80"
            value="<%=FormattingHelper.formatString(rowcfin15sog00.getSzTxtAdminDtlComments())%>"
            conditionallyRequired="true"
            tabIndex="<%= tabIndex++ %>" constraint="Comments" />
    </td>
    <td></td>
  </tr>
  </table>
<table width="100%" cellpadding="3" cellspacing="0" border="0">
  <tr>
    <td class="alignRight">
         <impact:ButtonTag name="btnSave" restrictRepost="true" img="btnSave" form="frmAdminDetail" action="/financials/Invoice/saveAdmin" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>"/>
    </td>
   </tr>
</table>


<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>

<script type="text/javascript">
<!--
  setServiceOptions('<%= FormattingHelper.formatString(cdService) %>');
//-->
</script>