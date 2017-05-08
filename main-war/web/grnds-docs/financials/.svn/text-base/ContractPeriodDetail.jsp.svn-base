<%
//*  JSP Name:     Contract Period Detail
//*  Created by:   Paul Lang
//*  Date Created: 01/03/03
//*
//*  Description:
//*  This JSP is is the detail page for the contract period. The user can make changes and save
//*  them on this page.
//*  This page is accessed through The Contract Header JSP.
//*
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  01/03/03  Paul Lang         Pasted the template into this JSP.
  06/10/03  Todd Reser        SIR 18060 -- Hide the Signed Box if the user
                              doesn't have SEC_SIGN_CNTRCT.
  06/17/03  Eric Dickman      SIR 17947 -- Removed szCDCnperStatus equal to CLS.
                              The only time the Renewal Checkbox can be protected
                              is when the Status is equal to CLT.
  07/01/03  GRIMSHAN          SIR 18510 -- When the status has been previoulsy saved
                              as closed, it needs to be disabled.
  07/08/03  GRIMSHAN          SIR 18733 -- Use a variable to determine if the previously
                              saved status is closed, and disable the field using the
                              disabled attribute so that it can save properly.
  08/07/03  Dickmaec          SIR 19329 - When the Contract Period Detail page would
                              load, the Status was getting set to PND. Removed the line of
                              code that caused the Status to get over written from the
                              database.
  08/18/03  Dickmaec          Added back a line of code.  Defaults the Status Drop Down menu
                              to Pending when a user clicks on the add push button from the
                              Contract Header page.
 06/13/05  Ochumd             Sir#23430 - Added legal identifier field for contracts.
                              NbrLegalIdentifier is now part of the display and save processes.
 01/06/09  charden            STGAP00009689: saving hidden variable hdnStrPeriod into request
 09/12/11   charden           STGAP00017058 - making date fields editable for fiscal ops
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ %>

<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="org.exolab.castor.types.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%

  /* Set the page mode initialized to view mode.
  */
     String pageMode = PageModeConstants.EDIT;

     if ( PageMode.getPageMode( request ) != null)
     {
       pageMode = PageMode.getPageMode( request );
     }
     else
     {
       pageMode = PageModeConstants.VIEW;
     }

// Get the output object out of the request
ROWCCON05SOG00 periodDetail = (ROWCCON05SOG00) request.getAttribute("periodDetail");
if (periodDetail == null){
periodDetail = new ROWCCON05SOG00();
}

// Get the Period number out of the request
Integer periodNumber = periodDetail.getUlNbrCnperPeriod() != 0 ? periodDetail.getUlNbrCnperPeriod() : 1;
String strPeriod = periodNumber.toString();
String contractPeriodNumber = request.getParameter("hdnContractPeriod");
// ochumd Sir#23430 request.getAttribute("selSzCdCntrctFuncType ") was returning null.
// we are geetting it from request.getParameter("selSzCdCntrctFuncType")
//String cntrctFuncType = (String) request.getAttribute("selSzCdCntrctFuncType ");
String cntrctFuncType = request.getParameter("selSzCdCntrctFuncType");

// Ochumd  Sir#23430 - Whenever there is a validation error on the page we must
// get legal identifier from the hdnLegalIdent.
if (cntrctFuncType == null)
 {
   cntrctFuncType = request.getParameter("hdnLegalIdent");
 }



int tabIndex = 1;

boolean fieldDisabled = false;
boolean disableIdentifier = false;
String dtLastUpdate = "";
String lastUpdatedBy = "";
String dtDtCnperClosure = "";
String dtDtCnperStart = "";
String dtDtCnperTerm = "";
String szCdCnperStatus = "";
String cIndCnperRenewal = "0";
String cIndCnperSigned = "0";
String txtEarlyTermCmt = "";
// ochu Sir#23430 - Added a legal identifier field for contracts.
String   ulNbrlegalIdentifier = "";
boolean signed = false;
String initialArrayName = "NotSigned";
//STGAP00017058
Boolean editPlusMode = request.getAttribute("editPlus") != null ? true : false;
List<String> excludedWhenSigned = new ArrayList<String>();
excludedWhenSigned.add(CodesTables.CCONSTAT_PND);
excludedWhenSigned.add(CodesTables.CCONSTAT_CLS);
excludedWhenSigned.add(CodesTables.CCONSTAT_CLT);

//only allowed option when unsigned is PEND
List<String> excludedWhenNotSigned = new ArrayList<String>();
excludedWhenNotSigned.add(CodesTables.CCONSTAT_ACT);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_CLS);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_CLT);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_PSH);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_PNT);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_PYH);
excludedWhenNotSigned.add(CodesTables.CCONSTAT_SVH);
boolean disableStatus = false;

//STGAP00017058
if(editPlusMode){
  pageMode = PageModeConstants.EDIT;
}

//If the output object is not null (modify or view mode), use it to set the display variables
if (PageModeConstants.NEW.equals( pageMode ))
{
  lastUpdatedBy = "";
  dtLastUpdate = "";
  dtDtCnperClosure = "";
  dtDtCnperStart = "";
  dtDtCnperTerm = "";
  szCdCnperStatus = CodesTables.CCONSTAT_PND;
  cIndCnperRenewal = "";
  cIndCnperSigned = "";
  ulNbrlegalIdentifier = "";
  txtEarlyTermCmt = "";
  fieldDisabled = true;
}
else
{
  lastUpdatedBy = FormattingHelper.formatString(periodDetail.getTxtLastUpdatedBy());
  dtLastUpdate = FormattingHelper.formatDate(periodDetail.getTsLastUpdate()) ;
  dtDtCnperClosure = FormattingHelper.formatDate(periodDetail.getDtDtCnperClosure() ) ;
  dtDtCnperStart = FormattingHelper.formatDate(periodDetail.getDtDtCnperStart() );
  dtDtCnperTerm = FormattingHelper.formatDate(periodDetail.getDtDtCnperTerm() );
  szCdCnperStatus = FormattingHelper.formatString(periodDetail.getSzCdCnperStatus() );
  cIndCnperRenewal = FormattingHelper.formatString(periodDetail.getCIndCnperRenewal() );
  cIndCnperSigned = FormattingHelper.formatString(periodDetail.getCIndCnperSigned() );
  txtEarlyTermCmt = FormattingHelper.formatString(periodDetail.getSzTxtCnperClosureCmt());
 // Sir#23430 - Added a legal identifier field for contracts.
  ulNbrlegalIdentifier = FormattingHelper.formatInt(periodDetail.getUlNbrLegalIdentifier() );
  signed = "Y".equalsIgnoreCase(cIndCnperSigned);

  if (signed)
  {
    initialArrayName = "Signed";

    // if the contract is signed, make sure that the excludedWhenSigned array
    // does not include the current value of szCdCnperStatus. If it does include
    // that value, remove the value, so that the value can show up in the dropdown
    excludedWhenSigned.remove( szCdCnperStatus );
  }
  else
  {
    // if the contract is not signed, make sure that the excludedWhenNotSigned array
    // does not include the current value of szCdCnperStatus. If it does include
    // that value, remove the value, so that the value can show up in the dropdown
    excludedWhenNotSigned.remove( szCdCnperStatus );
  }

  if (CodesTables.CCONSTAT_CLS.equals(szCdCnperStatus) )
  {
    disableStatus = true;
  }
  fieldDisabled = false;
}

//SIR 17947 -- Removed szCDCnperStatus equal to CLS  The only time the Renewal Checkbox
// can be protected is when the Status is equal to CLT.
if (CodesTables.CCONSTAT_CLT.equals(szCdCnperStatus) )
{
  pageMode = PageModeConstants.VIEW;
}

int startEditableMode = EditableMode.NEW;
//if (PageModeConstants.EDIT.equals(PageMode.getPageMode(request)) && "FAD".equals(cntrctFuncType))
if (PageModeConstants.EDIT.equals(PageMode.getPageMode(request)) && "FAD".equals(cntrctFuncType))
{
  startEditableMode = EditableMode.CREATE_AND_EDIT;
}
if (!"".equals(ulNbrlegalIdentifier) ||
    "FAD".equals(cntrctFuncType))
{
    disableIdentifier = true;
}
/* SIR 18060 -- Hide the Signed Box if the user doesn't have SEC_SIGN_CNTRCT */
UserProfile user = UserProfileHelper.getUserProfile( request );
String disableSigned = String.valueOf( !CodesTables.CCONSTAT_PND.equals( szCdCnperStatus ) ||
                                       !user.hasRight(UserProfile.SEC_SIGN_CNTRCT) );

%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript"  language="JavaScript1.2">

 /*
  *This function is called before the page unloads. It creates the
  *"Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  }
  
  //STGAP00017058
  var editPlus = "<%= editPlusMode %>";

  function setPendingTermState()
  {
    var value = document.frmContractPeriod.cboStatus.value;
    // STGAP00017058 - if in editplus mode, enable the early termination date field
    if (editPlus == "true" || value == "<%= CodesTables.CCONSTAT_PNT %>")
    {
      enableDateField( document.frmContractPeriod, document.frmContractPeriod.txtEarlyDate );
    }
    else
    {
      // only disable the date if it is actually a date. if the date field is disabled
      // then there is hidden field that holds the value
      if ( document.frmContractPeriod.txtEarlyDate.type != "hidden" )
      {
        disableDateField( document.frmContractPeriod, document.frmContractPeriod.txtEarlyDate );
      }
      document.frmContractPeriod.txtEarlyDate.value = "<%= dtDtCnperClosure %>";
      document.frmContractPeriod.txtEarly.value = "<%= dtDtCnperClosure %>";
      
     }
     
  }
  
  function updateHiddenEarly()
  {
    if ( !document.frmContractPeriod.txtEarly.disabled )
    {
      document.frmContractPeriod.txtEarly.value = document.frmContractPeriod.txtEarlyDate.value;
    }
  }
  
  //STGAP00017058
  var hdnPageMode = <%= pageMode %>;
  function confirmPeriod(){
    if(hdnPageMode == '1'){
      if(!confirm('You are creating a new contract period. Continue? Press OK to continue, or Cancel to stay on the current page.')){
      	return false;
      }
    }
    if(editPlus == "true"){
      var startDate = document.frmContractPeriod.hdnTxtStart.value;
      var endDate = document.frmContractPeriod.hdnTxtTerm.value;
      var newStartDate = document.frmContractPeriod.txtStart.value;
      var newEndDate = document.frmContractPeriod.txtTerm.value;
      var earlyEndDate = document.frmContractPeriod.txtEarlyDate.value;
      var newEarlyEndDate = document.frmContractPeriod.hdnTxtEarly.value;
      
      alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_UPDT_VERIF) %>');
      
      if(startDate != newStartDate || endDate != newEndDate || earlyEndDate != newEarlyEndDate){    
        return confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_VERS_START_DT_CHG) %>');
      }else{
      	return true;
      }
    }
    return true;
  }
  

<impact:codeArray arrayName="Signed" codeName="CCONSTAT" excludeOptions="<%=excludedWhenSigned%>"/>
<impact:codeArray arrayName="NotSigned" codeName="CCONSTAT" excludeOptions="<%=excludedWhenNotSigned%>"/>

  function populateStatus()
  {
   var signed = document.frmContractPeriod.cbxSigned.checked;
   if (<%= disableSigned %>)
     {
       signed = <%= String.valueOf( "Y".equals(cIndCnperSigned) ) %>;
     }

    if (signed)
    {
      populateDropdown(frmContractPeriod.cboStatus, frmContractPeriod.cboStatus.value, Signed);
    }
    else
    {
      populateDropdown(frmContractPeriod.cboStatus, frmContractPeriod.cboStatus.value, NotSigned);
    }
  }

  var currentStartDate = new Date(Date.parse('<%=dtDtCnperStart%>'));

  function signedStartChange()
  {
    if (<%= (startEditableMode == EditableMode.CREATE_AND_EDIT) %>)
    {
      startDateParsed = validateDateString(document.frmContractPeriod.txtStart.value);
      if (startDateParsed == "INVALID")
      {
        document.frmContractPeriod.txtStart.value = '<%=dtDtCnperStart%>';
        alert("Start Date information is not a valid date.");
      }
      else if (isAfter(new Date( Date.parse(startDateParsed)), currentStartDate))
      {
        document.frmContractPeriod.txtStart.value = '<%=dtDtCnperStart%>';
        alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_CON_DATE_START_BEFORE) %>");
      }
      else
      {
        document.frmContractPeriod.txtStart.value = startDateParsed;
      }
    }
    else if (<%=signed%> && editPlus != "true")
    {
      document.frmContractPeriod.txtStart.value = '<%=dtDtCnperStart%>';
      alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_CON_DATE_MODIFY)%>");
    }
  }

  function signedTermChange()
  {
    if (<%=signed%> && editPlus != "true")
    {
      document.frmContractPeriod.txtTerm.value = '<%=dtDtCnperTerm%>';
      alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_CON_DATE_MODIFY)%>");
    }
  }

  function confirmSaveSigned()
  {
    if (<%=!signed%> && document.frmContractPeriod.cbxSigned.checked == true && editPlus != "true")
    {
      return confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_CON_MODIFY_SIGNED)%>");
    }
    return true;
  }

  function copyIntoEarlyTerm()
  {
    if (!<%=signed%>)
    {
      document.frmContractPeriod.txtEarly.value = document.frmContractPeriod.txtTerm.value;
    }
  }

  function isAfter( date1, date2 )
  {
    if ( (date1.getTime() - date2.getTime()) > 0 )
    {
      return true;
    }
    return false;
  }
</script>

<impact:validateForm
name="frmContractPeriod"
method="post"
defaultButton="true"
action="/financials/Contracts/displayContractPeriod"
validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractPeriodCustomValidation"
pageMode="<%=pageMode%>"
schema="/WEB-INF/Constraints.xsd">

<impact:validateErrors/>

<impact:validateInput type="hidden" name="hdnContractPeriod" value="<%= contractPeriodNumber %>"/>
<impact:validateInput type="hidden" name="hdnCSysIndCnperStartMod" value="N"/>
<impact:validateInput type="hidden" name="hdnCSysIndCnperTermMod" value="N"/>
<impact:validateInput type="hidden" name="hdnTxtStart" value="<%= dtDtCnperStart %>"/>
<impact:validateInput type="hidden" name="hdnTxtTerm" value="<%= dtDtCnperTerm %>"/>
<impact:validateInput type="hidden" name="hdnTxtEarly" value="<%= dtDtCnperClosure %>"/>
<impact:validateInput type="hidden" name="hdnLegalIdent" value="<%= cntrctFuncType %>"/>
<impact:validateInput type="hidden" name="hdnStrPeriod" value="<%= strPeriod %>"/>
<impact:validateInput type="hidden" name="hdnPageMode" value="<%= pageMode %>"/>
<impact:validateInput type="hidden" name="hdnCboStatus" value="<%= szCdCnperStatus %>"/>

<% /* Begin Main Table */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">Contract Period Detail
    </th>
  </tr>
  <tr>
  <!-- STGAP00017058 make date fields and status modifiable for fiscal ops -->
    <td width="15%"><impact:validateDate name="txtStart"
                             disabled="false"
                             onChange="javascript:signedStartChange();"
                             label="Start"
                             required="true"
                             value="<%= dtDtCnperStart %>"
                             size="10"
                             constraint="Date"
                             tabIndex="<%= tabIndex++ %>"
                             editableMode="<%= editPlusMode ? EditableMode.EDIT : startEditableMode %>"
                             width="30%"/>
    </td>
   
    <td width="15%"><impact:validateSelect onChange="setPendingTermState();"
                               blankValue="false"
                               required="true"
                               label="Status"
                               name="cboStatus"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%=CodesTables.CCONSTAT%>"
                               disabled="<%= String.valueOf( disableStatus ) %>"
                               value="<%=szCdCnperStatus%>"/>
    </td>
  </tr>
  <tr>
     <impact:validateInput name="isEditPlusMode" type="hidden" value="<%= editPlusMode ? "Y" : "N" %>" />
     <td><impact:validateDate name="txtTerm"
                              disabled="false"
                              onChange="javascript:copyIntoEarlyTerm();signedTermChange();"
                              label="End"
                              required="true"
                              value="<%= dtDtCnperTerm %>"
                              size="8" constraint="Date"
                              tabIndex="<%= tabIndex++ %>"
                              editableMode="<%= editPlusMode ? EditableMode.EDIT : EditableMode.NEW %>"/>
    </td>
    <td colspan="2"><impact:validateInput type="checkbox"
                              checked="<%=cIndCnperRenewal %>"
                              name="cbxRenewal"
                              value="1"
                              cssClass="formInput"
                              tabIndex="<%= tabIndex++ %>"
                              />Renewal </td>
    </tr>
    <tr>
    <td>
       <impact:validateDate name="txtEarlyDate"
                            disabled="<%= String.valueOf(editPlusMode == true ? false : fieldDisabled) %>"
                            onChange="updateHiddenEarly();"
                            label="Early Termination"
                            value="<%= dtDtCnperClosure %>"
                            size="10"
                            constraint="Date"
                            tabIndex="<%= tabIndex++ %>"/>
       <impact:validateInput name="txtEarly" type="hidden" value="<%= dtDtCnperClosure %>" />
    </td>
    <td colspan="2"><impact:validateInput name="cbxSigned"
                               type="checkbox"
                               disabled="<%= disableSigned %>"
                               editableMode="<%=EditableMode.ALL-EditableMode.NEW-EditableMode.VIEW%>"
                               onClick="javascript:populateStatus();"
                               checked='<%= String.valueOf( "Y".equals(cIndCnperSigned) ) %>'
                               value="Y"
                               cssClass="formInput"
                               tabIndex="<%= tabIndex++ %>" />Signed</td>
    </tr>
    <tr>
  <td valign="top" colspan="2"><impact:validateTextArea name="txtEarlyTermCmt"
              colspan="2"
              label="Early Termination Comment"
              conditionallyRequired = "true"
              maxLength="300"
              rows="2"
              cols="50"
              tabIndex="<%= tabIndex++ %>"
              constraint="Comments">
              <%=txtEarlyTermCmt%>
        </impact:validateTextArea>
  </td>
  <td>&nbsp;</td>
  </tr>
  <tr>
  <td valign="top" colspan="2">Last Updated By:&nbsp; <%= lastUpdatedBy %></td>
  <td valign="top" colspan="2">Last Updated Date:&nbsp; <%= dtLastUpdate %></td>
  </tr>
</table>

<table width="100%" cellspacing="0" cellpadding="3" border="0">
 <tr>
  <td>
    <impact:ButtonTag  name="btnSave"
                       img="btnSave"
                       function="return confirmPeriod(); confirmSaveSigned()"
                       form="frmContractPeriod"
                       action="/financials/Contracts/saveContractPeriodDetail"
                       align="right"
                       restrictRepost="true"
                       tabIndex="<%= tabIndex++ %>"
                       />
  </td>
 </tr>
</table>

<% /* End Detail */ %>
<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>

<script language="javascript">
<impact:ifThen test="<%= ((PageModeConstants.VIEW.equals(pageMode) == false) && (disableStatus == false)) %>">
  populateStatus();
  CleanSelect( frmContractPeriod.cboStatus );
</impact:ifThen>
  setPendingTermState();
</script>


