<%//*  JSP Name:     Contract Version Detail
      //*  Created by:   Paul Lang
      //*  Date Created: 01/03/03
      //*
      //*  Description:
      //*  This JSP is is the detail page for the contract period. The user can make changes and save
      //*  them on this page.
      //*  This page is accessed through The Contract Header JSP.
      //*
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  05/13/03  GRIMSHAN          SIR #17245 -- Created a javascript function
      //**                              and hidden field so that the Locked checkbox will
      //**                              be disabled if the version has already been marked
      //**                              as locked and saved.
      //**  05/16/03  GRIMSHAN          SIR 17253 -- Added a condition to the javascript to
      //**                              show the message about effective date only if the user
      //**                              is adding a row.
      //**
      //**  05/27/03  Eric Dickman      SIR 17764 -- Removed the Required equal to true.
      //**                              No Show % is not a required field.
      //**
      //**  05/28/03  Eric Dickman      SIR 17838 -- Added MaxLength equal to 80 characters.
      //**  04/20/04  CORLEYAN          SIR 22577 -- Add hdnContractBudgetLimit as a value gotten
      //**                              out of context so that the save populate will know if this
      //**                              contract is of budget limit type.
      //**  09/12/11  charden           STGAP00017058 - added new fields to page and code to allow update by Fiscal Ops
      //**
      //**
      //**
      //**
      //**
      //**

      %>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON07SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="org.exolab.castor.types.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>


<%/* Set the page mode initialized to view mode.
       */
      String pageMode = PageModeConstants.EDIT;

      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);

      } else {
        pageMode = PageModeConstants.VIEW;
      }

      %>
<%// Include custom tag for displaying errors on the page

      %>
<impact:validateErrors />
<%/* Start the form */
%>
<impact:validateForm name="frmContractVersion" method="post" defaultButton="true" action="/financials/Contracts/displayContractVersion" validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractVersionCustomValidation" pageMode="<%=pageMode%>"
  schema="/WEB-INF/Constraints.xsd">


  <script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
  <script type="text/javascript" language="JavaScript1.2">

 /*
  *This function is called before the page unloads. It creates the
  *"Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  }
  function compareEffDate()
  {
    // SIR 17253 only display this message if the user is adding a row.
    if (frmContractVersion.hdnDataAction.value == "A")
    {
      if (frmContractVersion.txtEffective.value != "")
      {
        var effDate = (new Date(Date.parse(frmContractVersion.txtEffective.value)));
        if (effDate < closureDate && ((closureDate - effDate) < twentyDaysInMillis))
        {
        return confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_CON_SHORT_VERSION)%>');
        }
      }
    }
    return true;
  }
  var closureDate = (new Date(Date.parse('<%=request.getAttribute("closureDateString")%>')));
  var twentyDaysInMillis = 20*24*60*60*1000;

  function setLocked()
  {
         if (frmContractVersion.hdnLocked.value == "Y")
         {
           frmContractVersion.cbxLocked.disabled = true;
         }
         else
         {
           frmContractVersion.cbxLocked.disabled = false;
         }
}

  var hdnPageMode = <%= pageMode %>;
  function lockConfirm(){
    //MSG_LOCK_CNFRMTN 
    var val = document.getElementById('hdnContractLocked').value;
    if('Y' == val){
    	return confirm('Locking contract will make the contract version unmodifiable, unless you have special security.  Are you sure you are ready to lock the contract?');
    }else{
    	return true;
    }
	
  }
  
  function lockVersion(){
  	var val = document.getElementById('hdnContractLocked').value;
  	if('Y' == val){
  		document.getElementById('hdnContractLocked').value = 'N';
  	}else{
  		document.getElementById('hdnContractLocked').value = 'Y';
  	}
  }
  
  //MSG_UPDT_VERIF MSG_NEW_VERSION
  function confirmSave(){
  	if(hdnPageMode == '1'){
      if(!confirm('You are creating a new contract version. Continue?')){
      	return false;
      }
    }
    if(lockConfirm()){
      return confirm('Have you checked your updates before saving?');
    }else{
    	return false;
    }
  }
</script>

  <%// Get the output object out of the request.  If it's null, we're adding, so
      //  create a new row object and set the number of versions, incremented by one.
      boolean dateDisabled = true;
      ROWCCON07SOG00 versionDetail = (ROWCCON07SOG00) request.getAttribute("versionDetail");
      if (versionDetail == null) {
        dateDisabled = false;
        versionDetail = new ROWCCON07SOG00();
        Integer rowNumAttr = (Integer) request.getAttribute("addVersionNumber");
        int rowNum = rowNumAttr + 1;
        Date periodDate = (Date) request.getAttribute("periodEndDate");
        versionDetail.setUlNbrCnverVersion(rowNum);
        versionDetail.setDtDtCnverEnd(periodDate);
        versionDetail.setDtDtCnverCreate(DateHelper.getTodayCastorDate());
      }

      //Get Contract Period Number out of request
      String contractPeriodNumber = request.getParameter("hdnContractPeriod");
      String dataAction = (String) request.getAttribute("dataAction");
      String contractBudgetLimit = ContextHelper.getStringSafe(request, "hdnContractBudgetLimit");
      //STGAP00017058
      Boolean editPlusMode = request.getAttribute("editPlus") != null ? true : false;
%>
  <%//Declare and initialize display variables for Contract Period List and Veriosn List sections

      %>

  <%int ulNbrCnverVersion = 0;
      int ulIdCnver = 0;
      String dtDtCnverEffective = "";
      String dtDtCnverEnd = "";
      String dtDtCnverCreate = "";
      String cIndCnverVerLock = "";
      String szTxtCnverComment = "";
      String dtLastUpdate = "";
	  String lastUpdatedBy = "";

      %>

  <%//If the output object is not null (modify or view mode), use it to set the display variables

      if (versionDetail != null) {
        ulNbrCnverVersion = versionDetail.getUlNbrCnverVersion();
        ulIdCnver = versionDetail.getUlIdCnver();
        dtDtCnverEffective = FormattingHelper.formatDate(versionDetail.getDtDtCnverEffective());
        dtDtCnverEnd = FormattingHelper.formatDate(versionDetail.getDtDtCnverEnd());
        dtDtCnverCreate = FormattingHelper.formatDate(versionDetail.getDtDtCnverCreate());
        cIndCnverVerLock = FormattingHelper.formatString(versionDetail.getCIndCnverVerLock());
        szTxtCnverComment = FormattingHelper.formatString(versionDetail.getSzTxtCnverComment());
        lastUpdatedBy = FormattingHelper.formatString(versionDetail.getTxtLastUpdatedBy());
  	    dtLastUpdate = FormattingHelper.formatDate(versionDetail.getTsLastUpdate()) ;
      }
%>
  <impact:validateInput type="hidden" id="hdnContractLocked" name="hdnContractLocked" value="N" />
  <impact:validateInput type="hidden" name="hdnContractPeriod" value="<%= contractPeriodNumber %>" />
  <impact:validateInput type="hidden" name="hdnBudgetLimit" />
  <impact:validateInput type="hidden" name="hdnTxtEffective" value="<%= dtDtCnverEffective %>" />
  <impact:validateInput type="hidden" name="hdnBIndEndDateMod" />
  <impact:validateInput type="hidden" name="hdnBSysIndVersionLockMod" />
  <impact:validateInput type="hidden" name="hdnDataAction" value="<%= dataAction %>" />
  <impact:validateInput type="hidden" name="hdnContractBudgetLimit" value="<%= FormattingHelper.formatString(contractBudgetLimit) %>" />
  <%// SIR 17245 GRIMSHAN -- create hidden field so that the value of locked will be stored for save
      // if the checkbox is disabled

      %>
  <impact:validateInput type="hidden" name="hdnLocked" value="<%= cIndCnverVerLock %>" />

  <%int tabIndex = 1;

      int lockedEditableMode = EditableMode.NONE;
      if (request.getAttribute("periodSigned") != null) {
        lockedEditableMode = EditableMode.EDIT;
      }

      %>
  <%/* Begin Main Table */

      %>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="5">
        Contract Version Detail
      </th>
    </tr>
    <tr>
      <td>
      <% 
      //STGAP00017058 - make effective date editable for fiscal ops
      if(editPlusMode){
      %>
        <impact:validateDate name="txtEffective" label="Effective" value="<%= dtDtCnverEffective %>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
      <% 
      }else{
      %>
        <impact:validateDate name="txtEffective" disabled="<%=String.valueOf(dateDisabled)%>" label="Effective" required="<%=String.valueOf(!dateDisabled)%>" value="<%= dtDtCnverEffective %>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
      <% 
      }
      %>
      </td>
      <td>
        <impact:validateDisplayOnlyField name="txtVersion" label="Version" value="<%= String.valueOf(ulNbrCnverVersion) %>" />
      </td>
      <td width=50%>
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="txtEnd" label="End" value="<%= dtDtCnverEnd %>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="txtCreated" label="Created" value="<%= dtDtCnverCreate %>" />
      </td>
      <td>
        <impact:validateInput type="checkbox" checked="<%=cIndCnverVerLock %>" onClick="lockVersion()" name="cbxLocked" value="1" editableMode="<%=lockedEditableMode%>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
        Locked
      </td>
    </tr>
    <tr>
      <%-- SIR 17838 -- Added MaxLength equal to 80 characters.  Eric Dickman --%>
      <td valign="top" colspan="2">
        <!--- Text Area Custom Tag --->
        <impact:validateTextArea name="txtComment" colspan="3" label="Comment" maxLength="80" rows="2" cols="50" tabIndex="<%= tabIndex++ %>" constraint="Comments">
          <%=szTxtCnverComment%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
  		<td valign="top" colspan="2">Last Updated By:&nbsp; <%= lastUpdatedBy %></td>
  		<td valign="top" colspan="2">Last Updated Date:&nbsp; <%= dtLastUpdate %></td>
  </tr>
  </table>

  <table width="100%" cellspacing="0" cellpadding="3" border="0">
    <tr>
      <td>
        <impact:ButtonTag name="btnSave" img="btnSave" form="frmContractVersion" function="return confirmSave(); compareEffDate()" action="/financials/Contracts/saveContractVersionDetail" align="right" restrictRepost="true" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>

  <%/* End Detail */

      %>
  <%/*  Always include this hidden field in your form */

      %>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
  <impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= DateHelper.toISOString(versionDetail.getTsLastUpdate()) %>" />
  <impact:validateInput type="hidden" name="hdnUlIdCnver" value="<%= FormattingHelper.formatInt( versionDetail.getUlIdCnver() ) %>" />
  <impact:validateInput name="isEditPlusMode" type="hidden" value="<%= editPlusMode ? "Y" : "N" %>" />
</impact:validateForm>
<%/* Close Validate Form Custom Tag */

      %>

<script type="text/javascript" language="JavaScript1.2">

<% // SIR 17245 GRIMSHAN -- call a javascript function to disable the locked checkbox based on the
   // value in the hidden field
  if (!(PageMode.getPageMode( request ).equals(PageModeConstants.NEW) || PageMode.getPageMode( request ).equals(PageModeConstants.VIEW) ))
   { %>
    setLocked();
  <% } %>
</script>
