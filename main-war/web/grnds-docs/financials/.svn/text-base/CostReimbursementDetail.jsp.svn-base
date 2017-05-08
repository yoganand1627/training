<%
//*  JSP Name:     Cost Reimbursement Detail
//*  Created by:   Anna Grimshaw
//*  Date Created: 01/16/2002
//*
//*  Description:
//*  This JSP is used to maintain a Cost Reimbursement Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/07/03  GRIMSHAN          SIR 7034 -- Fixed opening and closing java brackets

%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN13SOG" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
//Get the output object from the request
BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
ROWCFIN13SOG rowcfin13sog = (ROWCFIN13SOG) request.getAttribute("ROWCFIN13SOG");
String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
CFIN02SO cfin02so = (CFIN02SO) state.getAttribute("CFIN02SO", request);


if (rowcfin13sog == null) {
  rowcfin13sog = new ROWCFIN13SOG();
}


%>
<% // Start Javascript Section
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

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


  String pageModePassed = "";
  String overallPageMode = PageModeConstants.EDIT;

   if (request.getAttribute("pageMode") != null )
   {
     pageModePassed = (String) request.getAttribute("pageMode");
     if (pageModePassed.equals(PageModeConstants.MODIFY))
     {
       overallPageMode = PageModeConstants.EDIT;
     }
     else if (pageModePassed.equals(PageModeConstants.NEW))
     {
       overallPageMode = PageModeConstants.NEW;
     }
     else if (pageModePassed.equals(PageModeConstants.VIEW))
     {
       overallPageMode = PageModeConstants.VIEW;
     }
   }

%>
<impact:validateErrors/>
<impact:validateForm name="frmCostDetail"
  method="post"
  action="/financials/Invoice/saveCost"
  pageMode="<%= overallPageMode %>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.CostCustomValidation"
  schema="/WEB-INF/Constraints.xsd">
<%--  Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page.
  --%>

  <impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>"/>
  <impact:validateInput type="hidden" name="hdnUlIdCostReim" value="<%= FormattingHelper.formatInt(rowcfin13sog.getUlIdCostReim()) %>"/>
  <impact:validateInput type="hidden" name="hdnSzCdCostReimLiType" value="<%= FormattingHelper.formatString(rowcfin13sog.getSzCdCostReimLiType()) %>"/>
  <impact:validateInput type="hidden" name="hdnCIndCostReimRejItm" value="<%= FormattingHelper.formatString(rowcfin13sog.getCIndCostReimRejItm()) %>"/>
  <impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= DateHelper.toISOString(rowcfin13sog.getTsLastUpdate()) %>"/>
  <impact:validateInput type="hidden" name="hdnIndInvoiceReversal" value="<%= FormattingHelper.formatString(cfin02so.getSzCdInvoAdjustmentRb()) %>"/>
<% /* Begin Detail */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="9">Sevice Information</th>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField label="Service" name="dspSzCdCostReimService" value="<%=FormattingHelper.formatString(rowcfin13sog.getSzCdCostReimService())%>" /></td>
    <td><impact:validateDisplayOnlyField  name="dspUsNbrCostReimCsli" label="CSLI" value="<%= FormattingHelper.formatInt(rowcfin13sog.getUsNbrCostReimCsli()) %>"/></td>
    <td><impact:validateDisplayOnlyField  name="dspUNbrCostReimUnitQty" label="Quantity" value="<%= FormattingHelper.formatDouble(rowcfin13sog.getUNbrCostReimUnitQty(), 2) %>"/></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="9">Expenditure Information</th>
  </tr>
  <tr>
    <td><impact:validateInput type="text" name="txtDAmtCostReimSalary" label="Salaries" conditionallyRequired="true" constraint="Money" value="<%= FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimSalary()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput type="text" name="txtDAmtCostReimFrgBenft" label="Benefits" conditionallyRequired="true" constraint="Money" value="<%= FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimFrgBenft()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td><impact:validateInput type="text" name="txtDAmtCostReimTravel" label="Travel" conditionallyRequired="true" constraint="Money" value="<%= FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimTravel()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput type="text" name="txtDAmtCostReimSupply" label="Supplies" conditionallyRequired="true" constraint="Money" value="<%= FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimSupply()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td><impact:validateInput type="text" name="txtDAmtCostReimEquip" label="Equipment" conditionallyRequired="true" constraint="Money" value="<%= FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimEquip()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateInput type="text" name="txtDAmtCostReimDtlOther" label="Other" conditionallyRequired="true" constraint="Money" value="<%= FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimDtlOther()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td><impact:validateInput type="text" name="txtDAmtCostReimAdminAll" label="Administrative" conditionallyRequired="true" constraint="Money" value="<%= FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimAdminAll()) %>"  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" size="11" maxLength="11" tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateDisplayOnlyField name="txtDAmtCostReimOffItem" label="Offset" value="<%= FormattingHelper.formatMoney(rowcfin13sog.getDAmtCostReimOffItem()) %>"/></td>
  </tr>
  </table>
<table width="100%" cellpadding="3" cellspacing="0" border="0">
  <tr>
    <td class="alignRight">
         <impact:ButtonTag name="btnSave" restrictRepost="true" img="btnSave" form="frmCostDetail" action="/financials/Invoice/saveCost" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>"/>
    </td>
   </tr>
</table>


<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>
