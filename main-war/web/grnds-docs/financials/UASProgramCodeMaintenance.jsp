<%--
JSP Name:     Program Code Maintenance

Description:
This JSP allows FIOM to add or update UAS program codes and maintain service codes for each program. The service codes maintained 
on this page are non-placement and non-policy related. New service inserted at user's discretion.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
10/20/11  htvo              STGAP00017292: added confirm message on Save
11/14/11  htvo              STGAP00017672: added hdnHyperlinkClicked to set the original display in update page state  
                            apart from other update states as the result of caught validation.
                            Added alert when user changes a header description and reset it back to its original value
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.UASEntitlementCodeDetail"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeMtntRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeDetail"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.UASProgramCodeListRow"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.UASProgramCodeMaintenanceConversation"%>


<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%
  //
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  UASProgramCodeMtntRetrieveSO uasPrgCodeMtntRetrieveSO = (UASProgramCodeMtntRetrieveSO) state
                                                                                   .getAttribute(
                                                                                                 "UASPrgCodeMtntRetrieveSO",
                                                                                                 request);
  // Retrieve the curent page state, if already set from previous action
  String pageState = (String) state.getAttribute("PAGE_STATE", request);
  // Page initially in Add new program code state
  if (!StringHelper.isValid(pageState)) {
    pageState = UASProgramCodeMaintenanceConversation.ADD_UAS;
  }
  // Page init variables 
  String pageMode = PageMode.getPageMode(request); 
  int editableModes = EditableMode.EDIT + EditableMode.NEW;
  int tabIndex = 1;
  String formName = "frmUASProgramCodeMaintenance";
  // In Add mode, user can enter up to 10 entitlement codes at a time
  // Default the number of ENT codes to display to 10
  int nbrDisplayEntCodeRows = 10;
  int hdnRowIndex = -1;
  // Page field variables
  // Program Code List section
  List<UASProgramCodeListRow> prgCodeList = new ArrayList<UASProgramCodeListRow>();
  // Program Code detail section 
  Date dtProgEff = null;  
  Date dtUpdatedBy = null;
  int idPersonUpdatedBy; 
  int idUasPrgCodeMtnt = 0;
  String txtProgCode = StringHelper.EMPTY_STRING;
  String txtProgDesc = StringHelper.EMPTY_STRING;
  String cdProgType = StringHelper.EMPTY_STRING;
  String nmPersonUpdatedBy = StringHelper.EMPTY_STRING;  
  String indCCI = StringHelper.EMPTY_STRING;
  String indCPA = StringHelper.EMPTY_STRING;
  String indServAuth = StringHelper.EMPTY_STRING;
  String indPSSF = StringHelper.EMPTY_STRING;
  String indInvAddOn = StringHelper.EMPTY_STRING;
  List<UASEntitlementCodeDetail> entCodeList = null;
  // Entitlement code detail section
  String amtEntRate = StringHelper.EMPTY_STRING;
  String amtEntCBLimit = StringHelper.EMPTY_STRING; // Case Budget limit
  String amtEntLILimit = StringHelper.EMPTY_STRING; // Line Item limit
  Date dtEntEff = null;
  Date dtEntLastUpdate = null;
  int idEntCodeMtnt = 0;
  String indEntHeader = StringHelper.EMPTY_STRING;
  String txtEntCode = StringHelper.EMPTY_STRING;
  String txtEntAlpha = StringHelper.EMPTY_STRING;
  String txtEntDesc = StringHelper.EMPTY_STRING;
  String cdEntPymtType = StringHelper.EMPTY_STRING;
  String cdEntUnitType = StringHelper.EMPTY_STRING;
  String indEntMileague = StringHelper.EMPTY_STRING;

  // Page control/behavior variables
  int listColspan = 4;
  int detailColspan = 6;
  boolean isUpdateMode = UASProgramCodeMaintenanceConversation.UPDATE.equals(pageState);
  String szBDisableUas = UASProgramCodeMaintenanceConversation.ADD_ENT.equals(pageState) ? "true" : "false";
  String szBAddUas = UASProgramCodeMaintenanceConversation.ADD_UAS.equals(pageState) ? "true" : "false";
  
  // Populate page fields with existing values, if any 
  if (uasPrgCodeMtntRetrieveSO != null) { 
    prgCodeList = uasPrgCodeMtntRetrieveSO.getPrgCodeList();
    // Set values for program code maintenance if exists
    UASProgramCodeDetail uasProgramCodeDetail = uasPrgCodeMtntRetrieveSO.getPrgCodeDetail();
    if (uasProgramCodeDetail != null ) {
      hdnRowIndex = uasProgramCodeDetail.getRecordIndex();
      idUasPrgCodeMtnt = uasProgramCodeDetail.getIdUasPrgCode();
      cdProgType = uasProgramCodeDetail.getCdProgramType();
      txtProgCode = uasProgramCodeDetail.getCdProgramCode();
      txtProgDesc = uasProgramCodeDetail.getTxtProgramDesc();
      dtProgEff = uasProgramCodeDetail.getDtProgramEffective();
      dtUpdatedBy = uasProgramCodeDetail.getDtLastUpdatedBy();
      idPersonUpdatedBy = uasProgramCodeDetail.getIdPersonLastUpdate();
      nmPersonUpdatedBy = uasProgramCodeDetail.getNmPersonLastUpdate();
      indCCI = uasProgramCodeDetail.getIndCCI();
      indCPA = uasProgramCodeDetail.getIndCPA();
      indServAuth = uasProgramCodeDetail.getIndServiceAuth();
      indPSSF = uasProgramCodeDetail.getIndPSSF();
      indInvAddOn = uasProgramCodeDetail.getIndInvAddOn();
      // populate ENT list to display with ENT data
      if (isUpdateMode) {
        entCodeList= uasProgramCodeDetail.getEntCodeList();
      }
      
      if (entCodeList != null && entCodeList.size() > 0) {
        nbrDisplayEntCodeRows = entCodeList.size();
      }
    }
  }

  List<String> excludeProgramTypes = new ArrayList<String>();
  excludeProgramTypes.add(CodesTables.CINVSRTP_ADM);
  excludeProgramTypes.add(CodesTables.CINVSRTP_ALL);
  
%>  
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

  /*
   This function is called before the page unloads. It creates the
   "Are you sure you want to navigate away from this page..." pop-up message.
  */
   window.onbeforeunload = function ()
  {
           IsDirty();
  };

  // Custom function to handle submitting the form via links in a list
  function displayCodeDetail(rowIndex, codeId)
  { disableValidation( "frmUASProgramCodeMaintenance" );
    document.frmUASProgramCodeMaintenance.hdnUlIdUasProgramCodeMtnt.value = codeId;
    document.frmUASProgramCodeMaintenance.hdnRowIndex.value = rowIndex;
    document.frmUASProgramCodeMaintenance.hdnHyperlinkClicked.value = 'true';
    submitValidateForm( "frmUASProgramCodeMaintenance" , "/financials/UASProgramCodeMaintenance/displayUASProgramCodeMaintenance" );
  }
  
  function valdiateAddNewProgramCode() {
    document.frmUASProgramCodeMaintenance.hdnAddProgramCodeMode.value = 'true';
    disableValidation( "frmUASProgramCodeMaintenance" );
  }

  function valdiateAddNewEntitlementCodes() {
    document.frmUASProgramCodeMaintenance.hdnAddEntitlementCodeMode.value = 'true';
    disableValidation( "frmUASProgramCodeMaintenance" );
  }
  
  function sortProgramCodeList(orderBy) {
    disableValidation( "frmUASProgramCodeMaintenance" );
    document.frmUASProgramCodeMaintenance.hdnSortOrderBy.value = orderBy;
    submitValidateForm( "frmUASProgramCodeMaintenance" , "/financials/UASProgramCodeMaintenance/sortUasProgramCodeList" );
  }
  
  function confirmSave() {
    // whether program data changed, for the data fields that affect the service code at the ENT level
    // Currently: program code, subprogram selections: Service Auth, Invoice Add-on, CCI/CPA, PSSF.
    var x = document.frmUASProgramCodeMaintenance;
    for (var i=0; i<x.elements.length; i++) {
      sElementName = new String(x.elements[i].name);
      // The only radios on the page are subprograms
      if("radio" == x.elements[i].type)
      { 
        if (x.elements[i].checked != x.elements[i].defaultChecked) {
          document.frmUASProgramCodeMaintenance.hdnProgramChanged.value = "Y";
        }
      } else if ("txtSzCdProgCode" == sElementName) {
        if (x.elements[i].value != x.elements[i].defaultValue) {
          document.frmUASProgramCodeMaintenance.hdnProgramChanged.value = "Y";
        }
      }
    }
    return confirm('<%= MessageLookup.getMessageByName( "MSG_CONF_VALUES")%>');
  }
  
  function setRowIsChanged(field, index) {
    var hdnIndRowChanged = eval("document.frmUASProgramCodeMaintenance.hdnIndRowChanged" + index);
    var cbxIndEntHeader = eval("document.frmUASProgramCodeMaintenance.cbxIndEntHeader" + index);
    if (CheckWidget(field)) {
      hdnIndRowChanged.value = "Y";
      if (field.title == "Description" && field.defaultValue != "" && cbxIndEntHeader.checked) {
        alert("Header descriptions cannot be updated online. Please contact your system administrator to complete this request. Your header description has not been changed.");
        field.value = field.defaultValue;
      }
    } else {
      hdnIndRowChanged.value = "N";
    }
  }
    
</script>
<%-- Include custom tag for displaying errors on the page --%>
<impact:validateErrors/>

<impact:validateForm name="frmUASProgramCodeMaintenance" 
                     method="post" 
                     action="/financials/UASProgramCodeMaintenance/displayUASProgramCodeMaintenance"
  					 validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.UASProgramCodeMaintenanceCustomValidation"
                     pageMode="<%= pageMode %>" 
                     schema="/WEB-INF/Constraints.xsd">
<%-- Do not use FormattingHelper here --%> 
<impact:validateInput type="hidden" name="hdnDtLastUpdateUasProgCodeDetail" 
                      value="<%= DateHelper.toISOString(dtUpdatedBy) %>"/>
<impact:validateInput type="hidden"
                      name="hdnRowIndex"
                      value="<%=String.valueOf(hdnRowIndex) %>" />
<impact:validateInput type="hidden"
                      name="hdnNbrDisplayEntCodeRows"
                      value="<%=String.valueOf(nbrDisplayEntCodeRows) %>" />
<!-- Indicate page is in the process of adding new program code; not exclusive. -->
<impact:validateInput type="hidden"
                      name="hdnAddProgramCodeMode"
                      value="<%=szBAddUas %>" />
<!-- Indicate page is in the process of adding Entitlement codes; not exclusive -->
<impact:validateInput type="hidden"
                      name="hdnAddEntitlementCodeMode"
                      value="<%=szBDisableUas %>" />
<impact:validateInput type="hidden"
                      name="hdnHyperlinkClicked"
                      value="" />
<impact:validateInput type="hidden"
                      name="hdnSortOrderBy"
                      value="C" />
                      
<impact:validateInput type="hidden"
                            name="hdnProgramChanged"
                            value="<%=ArchitectureConstants.N %>" />
                      <!-- Begin List section -->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="<%= listColspan %>">UAS Program Code List</th>
  </tr>
  <tr>
    <td colspan="<%= listColspan %>">
          <div id="verticalScrollResults" style="height:136px; width:100%; overflow:auto" class="tableBorderList">
            <table width="100%" cellspacing="0" cellpadding="3">
              <tr>
                <th class="thList" width="5%">Program Code&nbsp;
                <a href="javascript:sortProgramCodeList('C')"><img src="/grnds-docs/images/shared/sortDescending.gif" border="0"></a>
			    </th>
                <th class="thList">Program Description</th>
                <th class="thList">Effective Date&nbsp;
                <a href="javascript:sortProgramCodeList('D')"><img src="/grnds-docs/images/shared/sortDescending.gif" border="0"></a>
			    </th>
                <th class="thList">Updated By</th>
            </tr>
			<%  // Populate list with retrieved data
			int rIndex = 0;
			for (UASProgramCodeListRow row : prgCodeList) { 
			%>
			  <tr>
			    <td><a href="javascript:displayCodeDetail('<%=rIndex %>', '<%=FormattingHelper.formatInt(row.getIdUasPrgCode()) %>')">
			      <%=FormattingHelper.formatString(row.getCdProgramCode()) %></a>
			    </td>
			    <td>
			      <%=FormattingHelper.formatString(row.getTxtProgramDesc()) %>
			    </td>
			    <td>
			      <%=FormattingHelper.formatDate(row.getDtProgramEffective()) %>
			    </td>
			    <td>
			      <%=FormattingHelper.formatString(row.getNmPersonLastUpdate()) %>
			    </td>
			  </tr>
			<%
			  rIndex++; } 
			%>
          </table>
        </div>
    </td>
  </tr>
  <tr>
    <td class="alignRight">
       <impact:ButtonTag name="btnAddPrgCode" 
                         editableMode="<%= editableModes %>"
                         img="btnAddNewProgCode" 
                         align="right" 
                         form="frmUASProgramCodeMaintenance" 
                         function="valdiateAddNewProgramCode()"
                         action="/financials/UASProgramCodeMaintenance/addUASProgramCode"
                         navAwayCk="true"
                         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<br/>
<hr/>
<!-- Begin Program Code Detail section -->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr>
  <th colspan="<%= detailColspan+1 %>">UAS Program Code Maintenance</th>
</tr>
<tr>
  <td><impact:validateInput name="txtSzCdProgCode" label="Program Code" required="true" type="text" constraint="Digit3" 
                            cssClass="formInput" value="<%= FormattingHelper.formatString(txtProgCode) %>"
                            disabled="<%=szBDisableUas %>"
                            size="2" maxLength="3" tabIndex="<%= tabIndex++ %>"  width="25%"/></td>
      <impact:validateInput type="hidden"
                            name="hdnUlIdUasProgramCodeMtnt"
                            value="<%=FormattingHelper.formatInt(idUasPrgCodeMtnt) %>" />
  <td><impact:validateInput name="txtSzTxtProgDesc" label="Program Description" required="true" type="text"  
                            cssClass="formInput"
                            disabled="<%=szBDisableUas %>"
                            value="<%= FormattingHelper.formatString(txtProgDesc) %>" 
                            size="50" maxLength="50" 
                            tabIndex="<%= tabIndex++ %>"/></td>
</tr>
<tr>
  <td><impact:validateDate name="txtDtDtProgEff" label="Effective Date" required="true" 
                            value="<%= FormattingHelper.formatDate(dtProgEff) %>" 
                            disabled="<%=szBDisableUas %>" calendar="true"
                            constraint="DateAllowNoSlash" tabIndex="<%= tabIndex++ %>"/></td>
  <td><impact:validateSelect name="selSzCdProgType" label="Type" required="true" codesTable="CINVSRTP" 
							excludeOptions="<%= excludeProgramTypes %>" 
                            value="<%= FormattingHelper.formatString(cdProgType) %>"  
                            disabled="<%=szBDisableUas %>" 
                            tabIndex="<%= tabIndex++ %>"/></td> 
</tr>
<tr> <!-- Radio section as a borderless inner table -->
<td colspan="<%= detailColspan %>">
<table width="100%" cellpadding="3" cellspacing="0" border="0">
<tr>
  <td  width="19%"><span class="formCondRequiredText">&#8225;</span>Service Authorization:</td>
  <td><impact:validateInput name="rbServAuth" label="Yes" id="rbServAuth_Yes" tabIndex="<%=tabIndex++%>" 
                            value="<%=ArchitectureConstants.Y%>" 
                            checked="<%=StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indServAuth)) %>" 
							disabled="<%=szBDisableUas %>"
							type="radio" cssClass="formInput" />
  <impact:validateInput name="rbServAuth" label="No" id="rbServAuth_No" tabIndex="<%=tabIndex++%>" 
                            value="<%=ArchitectureConstants.N%>" 
                            checked="<%=StringHelper.toBooleanString(ArchitectureConstants.N.equals(indServAuth)) %>" 
							disabled="<%=szBDisableUas %>"
							type="radio" cssClass="formInput" /></td>
  <td>&nbsp;</td>
  <td width="5%"><span class="formCondRequiredText">&#8225;</span>CCI:</td>
  <td><impact:validateInput name="rbCCI" label="Yes" id="rbCCI_Yes" tabIndex="<%=tabIndex++%>" 
                            value="<%=ArchitectureConstants.Y%>" 
                            checked="<%=StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indCCI)) %>" 
							disabled="<%=szBDisableUas %>"
							type="radio" cssClass="formInput" />
  <impact:validateInput name="rbCCI" label="No" id="rbCCI_No" tabIndex="<%=tabIndex++%>" 
                            value="<%=ArchitectureConstants.N%>" 
                            checked="<%=StringHelper.toBooleanString(ArchitectureConstants.N.equals(indCCI)) %>" 
							disabled="<%=szBDisableUas %>"
							type="radio" cssClass="formInput" /></td>
  <td>&nbsp;</td>
  <td width="5%"><span class="formCondRequiredText">&#8225;</span>PSSF:</td>
  <td><impact:validateInput name="rbPSSF" label="Yes" id="rbPSSF_Yes" tabIndex="<%=tabIndex++%>" 
                            value="<%=ArchitectureConstants.Y%>" 
                            checked="<%=StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indPSSF)) %>" 
							type="radio" cssClass="formInput" />
  <impact:validateInput name="rbPSSF" label="No" id="rbPSSF_No" tabIndex="<%=tabIndex++%>" 
                            value="<%=ArchitectureConstants.N%>"
                            checked="<%=StringHelper.toBooleanString(ArchitectureConstants.N.equals(indPSSF)) %>"  
							type="radio" cssClass="formInput" /></td>
</tr>                                                                     
<tr>
  <td><span class="formCondRequiredText">&#8225;</span>Invoice Add-On:</td>
  <td><impact:validateInput name="rbInvAddOn" label="Yes" id="rbInvAddOn_Yes" tabIndex="<%=tabIndex++%>" 
                            value="<%=ArchitectureConstants.Y%>" 
                            checked="<%=StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indInvAddOn)) %>" 
							disabled="<%=szBDisableUas %>"
							type="radio" cssClass="formInput" />
  <impact:validateInput name="rbInvAddOn" label="No" id="rbInvAddOn_No" tabIndex="<%=tabIndex++%>" 
                            value="<%=ArchitectureConstants.N%>" 
                            checked="<%=StringHelper.toBooleanString(ArchitectureConstants.N.equals(indInvAddOn)) %>" 
							disabled="<%=szBDisableUas %>"
							type="radio" cssClass="formInput" /></td>
  <td>&nbsp;</td>
  <td><span class="formCondRequiredText">&#8225;</span>CPA:</td>
  <td><impact:validateInput name="rbCPA" label="Yes" id="rbCPA_Yes" tabIndex="<%=tabIndex++%>" 
                            value="<%=ArchitectureConstants.Y%>" 
                            checked="<%=StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indCPA)) %>" 
							disabled="<%=szBDisableUas %>"
							type="radio" cssClass="formInput" />
  <impact:validateInput name="rbCPA" label="No" id="rbCPA_No" tabIndex="<%=tabIndex++%>" 
                            value="<%=ArchitectureConstants.N%>" 
                            checked="<%=StringHelper.toBooleanString(ArchitectureConstants.N.equals(indCPA)) %>" 
							disabled="<%=szBDisableUas %>"
							type="radio" cssClass="formInput" /></td>
</tr>
</table>
</td>
</tr> <!-- End Radio section as a borderless inner table -->
<tr>
  <td><impact:validateDisplayOnlyField name="dspTxtSzUpdatedBy" label="&nbsp;Updated By"  
                            value="<%=FormattingHelper.formatString(nmPersonUpdatedBy)%>" /></td>
  <td>&nbsp;&nbsp;&nbsp;&nbsp;<impact:validateDisplayOnlyField name="dspTxtSzUpdatedDate" label="Updated Date"  
                            value="<%=FormattingHelper.formatDate(dtUpdatedBy)%>" /></td>                          
  <td>&nbsp;&nbsp;</td></tr>
</tr>
<tr><td>&nbsp;&nbsp;</td></tr>
</table>
<!-- End Program Code Detail section -->
<!-- Begin Entitlement Code Detail section -->
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder"> 
  <tr>
    <th colSpan="<%= detailColspan %>">Entitlement Codes</th>
  </tr>
  <tr>
    <td colspan="<%= detailColspan %>"><table width="100%" cellspacing="0" cellpadding="3" class="tableBorder"> <!-- table E2 -->
      <tr>
        <td class="tableBG">
          <div class="alignRight"><div class="formInstruct">Scroll for more information --></div></div>
          <div id="horizontalScrollResults" style="height:370px; width:752px; overflow:auto" class="tableBorder">
            <table width="900" cellspacing="0" cellpadding="3">
              <tr>
                <th class="thList">&nbsp;Header</th>
                <th class="thList">Code</th>
                <th class="thList">Alpha</th>
                <th class="thList">Description</th>
                <th class="thList">Effective Date</th>
                <th class="thList">Unit Rate ($)</th>
                <th class="thList">Payment Type</th>
                <th class="thList">Unit Type</th>
                <th class="thList">Mileage</th>
                <th class="thList" width="3%">&nbsp;&nbsp;Case &nbsp;&nbsp;Budget &nbsp;&nbsp;Limit ($)</th>
                <th class="thList" width="2%">&nbsp;&nbsp;Line &nbsp;&nbsp;Item &nbsp;&nbsp;Limit ($)</th>
              </tr>
              <% 
              if (entCodeList == null) {
                  entCodeList = new ArrayList<UASEntitlementCodeDetail>();
              }
              Iterator<UASEntitlementCodeDetail> itrEntSO = entCodeList.iterator();
              
              for (int i=0; i<nbrDisplayEntCodeRows; i++) {
                //String amtEntRate = StringHelper.EMPTY_STRING;
                 if (itrEntSO.hasNext()) {
                    UASEntitlementCodeDetail entSO = (UASEntitlementCodeDetail)itrEntSO.next();
                    idEntCodeMtnt = entSO.getIdEntRow();
                    if (entSO.getAmtRate() > 0.00) {
                      amtEntRate = FormattingHelper.formatMoney(entSO.getAmtRate());
                    } else {
                      amtEntRate = StringHelper.EMPTY_STRING;
                    }
                    if (entSO.getAmtCBL() > 0.00) {
                      amtEntCBLimit = FormattingHelper.formatMoney(entSO.getAmtCBL()); 
                    } else {
                      amtEntCBLimit = StringHelper.EMPTY_STRING;
                    }
                    if (entSO.getAmtLIL() > 0.00) {
                      amtEntLILimit = FormattingHelper.formatMoney(entSO.getAmtLIL());
                    } else {
                      amtEntLILimit = StringHelper.EMPTY_STRING;
                    }
			        dtEntEff = entSO.getDtEntEff();
			        dtEntLastUpdate = entSO.getDtLastUpdate();
			        indEntHeader = entSO.getIndHeader();
			        txtEntCode = entSO.getCdEntCode();
			        txtEntAlpha = entSO.getTxtEntAlpha();
			        txtEntDesc = entSO.getTxtEntDesc();
			        cdEntPymtType = entSO.getCdPymtType();
			        cdEntUnitType = entSO.getCdUnitType();
			        indEntMileague = entSO.getIndMileage();
                  } 
                  String hdnIdEntRow = "hdnUlIdEntProgramCodeMtnt"+i;
                  String hdnDtLastUpdateEntRow = "hdnDtLastUpdateEntProgramCodeMtnt"+i;
                  String hdnIndRowChanged = "hdnIndRowChanged"+i;
                  
	              String nmCbxIndHeader = "cbxIndEntHeader"+i;
	              String nmTxtEntCode = "txtSzEntCode"+i;
	              String nmTxtEntAlpha = "txtSzTxtEntAlpha"+i; 
	              String nmTxtEntDesc = "txtSzTxtEntDesc"+i;
	              String nmDtEntEff = "txtDtDtEntEff"+i; 
	              String nmAmtEntRate = "txtAmtEntRate"+i; 
	              String nmCdEntPymtType = "selSzCdEntPymtType"+i;
	              String nmCdEntUnitType = "selSzCdEntUnitType"+i;
	              String nmCbxIndEntMileage = "cbxIndEntMileage"+i;
	              String nmEntCBL = "txtDAmtEntCBL"+i; // Case Budget Limit - Double
	              String nmEntLIL = "txtDAmtEntLIL"+i; // Line Item Limit - Double
	              
		          String onChangeActionString = "setRowIsChanged(this, " + i + ")";
      
              %>
              <tr>
                <td>
                	<impact:validateInput 
               			name="<%=nmCbxIndHeader %>"  
                        type="checkbox" 
                        value="<%= ArchitectureConstants.Y %>"
                        checked="<%= StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indEntHeader)) %>"
                        onChange="<%=onChangeActionString %>"
                        cssClass="formInput"
                        tabIndex="<%= tabIndex++ %>" 
                    />
                </td>                    
                <td>
                	<impact:validateInput 
                        title="Code"
               			name="<%=nmTxtEntCode %>" 
               			type="text" 
               			constraint="AlphaNumeric2"
                        value="<%= FormattingHelper.formatString(txtEntCode) %>" 
                        onChange="<%=onChangeActionString %>"
                        size="2" 
                        maxLength="2" 
                        cssClass="formInput" 
                        tabIndex="<%= tabIndex++ %>"
                    />
                </td>
                <impact:validateInput 
                    name="<%=hdnIdEntRow %>"
                	type="hidden"
                    value="<%=FormattingHelper.formatInt(idEntCodeMtnt) %>" 
                />
                <td>
                	<impact:validateInput 
                        title="Alpha"
            			name="<%=nmTxtEntAlpha %>" 
            			type="text" 
            			constraint="Letter" 
                        value="<%= FormattingHelper.formatString(txtEntAlpha) %>" 
                        onChange="<%=onChangeActionString %>"
                        size="1" 
                        maxLength="1" 
                        cssClass="formInput" 
                        tabIndex="<%= tabIndex++ %>"
                    />
                </td>
                <td>
                	<impact:validateInput 
            			title="Description"
            			name="<%=nmTxtEntDesc %>" 
            			type="text"  
                        value="<%= FormattingHelper.formatString(txtEntDesc) %>" 
                        onChange="<%=onChangeActionString %>"
                        size="15" 
                        maxLength="30" 
                        cssClass="formInput" 
                        tabIndex="<%= tabIndex++ %>"
                    />
                </td>
                <td>
                	<impact:validateDate 
            			name="<%=nmDtEntEff %>" 
            			calendar="false"
                        constraint="DateAllowNoSlash" 
                        title="Effective Date"
                        value="<%= FormattingHelper.formatDate(dtEntEff) %>" 
                        onChange="<%=onChangeActionString %>"
                        tabIndex="<%= tabIndex++ %>"
                    />
                </td>                      
                <td>
                	<impact:validateInput 
                        title="Unit Rate"
            			name="<%=nmAmtEntRate %>" 
            			type="text" 
            			constraint="Money" 
                        value="<%= amtEntRate %>" 
                        onChange="<%=onChangeActionString %>"
                        size="8" 
                        maxLength="10" 
                        cssClass="formInput" 
                        tabIndex="<%= tabIndex++ %>"
                    />
                </td>
                <td>
                	<impact:validateSelect 
            			name="<%=nmCdEntPymtType %>"
            			codesTable="CCONPAY" 
                        value="<%= FormattingHelper.formatString(cdEntPymtType) %>"
                        onChange="<%=onChangeActionString %>"
                        tabIndex="<%= tabIndex++ %>"
                    />
                </td>
                <td>
                	<impact:validateSelect
            			name="<%=nmCdEntUnitType %>"
                        codesTable="CCONUNIT"
                        value="<%= FormattingHelper.formatString(cdEntUnitType) %>"
                        onChange="<%=onChangeActionString %>"
                        tabIndex="<%= tabIndex++ %>" 
                    />                           
                </td>
                <td>
                	<impact:validateInput 
            			name="<%=nmCbxIndEntMileage %>"
                        type="checkbox"
                        value="<%= ArchitectureConstants.Y %>"
                        checked="<%= StringHelper.toBooleanString(ArchitectureConstants.Y.equals(indEntMileague)) %>"
                        onChange="<%=onChangeActionString %>"
                        cssClass="formInput"
                        tabIndex="<%= tabIndex++ %>"
                    />
                </td>                    
                <td>
                	<impact:validateInput 
                        title="Case Budget Limit"
            			name="<%=nmEntCBL %>" 
            			type="text" 
            			constraint="Money" 
                        value="<%= amtEntCBLimit %>" 
                        onChange="<%=onChangeActionString %>"
                        size="6" 
                        maxLength="10" 
                        cssClass="formInput" 
                        tabIndex="<%= tabIndex++ %>"
                    />
                </td>
                <td>
                	<impact:validateInput 
                        title="Line Item Limit"
                		name="<%=nmEntLIL %>" 
            			type="text" 
            			constraint="Money" 
                        value="<%= amtEntLILimit %>" 
                        onChange="<%=onChangeActionString %>"
                        size="6" 
                        maxLength="10" 
                        cssClass="formInput" 
                        tabIndex="<%= tabIndex++ %>"
                    />
                </td>
                <impact:validateInput type="hidden"
                   name="<%=hdnIdEntRow %>"
                   value="<%=FormattingHelper.formatInt(idEntCodeMtnt) %>" 
                />
                <impact:validateInput type="hidden"
                   name="<%=hdnDtLastUpdateEntRow %>"
                   value="<%= DateHelper.toISOString(dtEntLastUpdate) %>" 
                />
                <impact:validateInput type="hidden"
                   name="<%=hdnIndRowChanged %>"
                   value="<%=ArchitectureConstants.N %>" 
                />
                
              </tr>
              <% } %>
            </table>
          </div>
        </td> <!-- Close td class="tableBG">  -->
      </tr>
    </table></td> <!-- Close table E2 -->
  </tr>
  <impact:ifThen test='<%= isUpdateMode %>'>
  <tr>
    <td class="alignLeft">
       <impact:ButtonTag name="btnAddEntCodes" editableMode="<%= editableModes %>"
                         img="btnAddEntitlementCodes" align="left" form="frmUASProgramCodeMaintenance" 
                         function = "valdiateAddNewEntitlementCodes()"
                         action="/financials/UASProgramCodeMaintenance/addEntitlementCode"
                         navAwayCk="true"
                         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  </impact:ifThen>
</table>  
<!-- End Entitlement Code Detail section -->
<hr>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td class="alignRight">
       <impact:ButtonTag name="btnSaveAll" editableMode="<%= editableModes %>"
                         img="btnSave" align="right" form="frmUASProgramCodeMaintenance"
                         function="return confirmSave();"
                         action="/financials/UASProgramCodeMaintenance/saveUASProgramCodeMaintenance"
                         preventDoubleClick="true"
                         tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<%--  Always include this hidden field in your form --%>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<%-- Close Validate Form Custom Tag --%>
</impact:validateForm>
<br/>
<hr/>     
                  