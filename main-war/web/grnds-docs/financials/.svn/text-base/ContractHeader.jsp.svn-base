<%
//*  JSP Name:     Contract Header
//*  Created by:   Paul Lang
//*  Date Created: 01/03/03
//*
//*  Description:
//*  This JSP is is the primary informational and access point for the contract conversation.
//*  This page is accessed through The Contract Search JSP. This page provided access to the
//*  remaining 6 jsp's in the Contract Conversation.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  01/03/03  Paul Lang         Pasted the template into this JSP.
//**
//**  05/28/03  Eric Dickman      SIR 17733 -- The Transfer Hyperlink will only
//**                              display if a user is in edit mode and the
//**                              Budget Limit checkbox is checked.  The user
//**                              must select a Period number that populates some
//**                              information needed for the Budget Transfer hyperlink.
//**                              Since the page must re-display to populate the
//**                              Version, the Budget Transfer hyperlink will
//**                              only dispaly after the page reloads and if
//**                              user is in edit mode and the Budget Limit
//**                              checkbox is checked.
//**  06/10/03  Eric Dickman      SIR 18210 -- The Contract Service Hyperlink will not display
//**                              if no versions are present or selected.
//**  06/25/03  GRIMSHAN          SIR 18509 -- Get the value of indValidate from state
//**                              and set it into a hidden field, it will be used on custom
//**                              validation to determine if the Resource ID has been validated
//**                              if the resource id is changed, set the hidden field to N
//**                              so the user is required to re-validate.
//**  06/25/03  GRIMSHAN          SIR 18509 -- Do not display expandable sections when the
//**                              page mode is new.
//**  06/27/03  GRIMSHAN          SIR 18494 -- Do not display the add pushbutton when any
//**                              row is in CLT status
//**  07/12/03  Eric Dickman      SIR 18739 -- When a user clicks on the 3rd level tab of
//**                              Contracts, the Contract header page will now load with
//**                              the period selected.  I removed the Period attribute from
//**                              the request to state.
//** 06/13/05  Ochumd             Sir#23430 - Added legal identifier field for contracts.
//**                              NbrLegalIdentifier is now part of the search and display processes.



%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON02SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON07SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON05SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON07SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractsConversation" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Collection"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  UserProfile user = UserProfileHelper.getUserProfile( request );
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  /* Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
     to see how the page functions, but it should always be initialized to view mode.
  */
     String pageMode = PageModeConstants.EDIT;

     if ( PageMode.getPageMode( request ) != null)
     {
       pageMode = PageMode.getPageMode( request );
     }

%>
<impact:validateErrors/>
<impact:validateForm
  name="frmContractHeader"
  method="post"
  action="/financials/Contracts/saveContractHeader"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractHeaderCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">
<%
//  String hdnContractPeriodParam = request.getParameter("hdnContractPeriod");
  String hdnContractPeriodParam = (String) state.getAttribute("contractPeriod", request);
  //String hdnContractVersionParam = request.getParameter("hdnContractVersion");
  String signedOrUnsigned = ContextHelper.getStringSafe(request, "hdnSignedOrUnsigned" );
  String indValidate = (String) state.getAttribute( "indValidate", request );
  boolean buttonSelected = false;
  
  String showServicesButton = "false";
  String szCdCntrctFuncType = "";
  String szCdCntrctProcureType = "";
  //String szCdCntrctProgramType = "";
  String szCdCntrctRegion = FormattingHelper.convertRegionCode(user.getUserRegion());
  String cIndCntrctBudgLimit = "false";
  String cIndCntrctedResource = "false";
  int ulIdCntrctManager = 0;
  String ulIdResource = "";

  String szNmResource = "";
  int ulIdRsrcAddress =0;
  String szNmPersonFull= "";

  int tabIndex = 1;
  
  // Get the output object out of the request
  CCON02SO ccon02so = (CCON02SO) state.getAttribute("CCON02SO", request);
  CCON05SO ccon05so = (CCON05SO) state.getAttribute("CCON05SO", request);
  CCON07SO ccon07so = (CCON07SO) state.getAttribute("CCON07SO", request);
  //boolean showTransferHLink = true;

  // Initialize the row and array objects
  ROWCCON02SOG00_ARRAY rowccon02sog00_array = null;
  ROWCCON02SOG00 vendorRow = null;
  ROWCCON05SOG00_ARRAY contractPeriodArray = null;
  ROWCCON05SOG00 contractPeriodRow = null;
  ROWCCON07SOG00_ARRAY contractVersionArray = null;
  ROWCCON07SOG00 contractVersionRow = null;
    

  // Null catch for personSerarchOutRec, if null set to blank (initialize)
  if ( ccon02so == null )
  {
    ccon02so = new CCON02SO();
  } else {
    szCdCntrctFuncType = FormattingHelper.formatString(ccon02so.getSzCdCntrctFuncType() );
    szCdCntrctProcureType = FormattingHelper.formatString(ccon02so.getSzCdCntrctProcureType() );
    //szCdCntrctProgramType = FormattingHelper.formatString(ccon02so.getSzCdCntrctProgramType() );
    szCdCntrctRegion = FormattingHelper.formatString(ccon02so.getSzCdCntrctRegion() );
    ulIdCntrctManager = ccon02so.getUlIdCntrctManager();
    ulIdResource = FormattingHelper.formatInt(ccon02so.getUlIdResource());
    szNmResource = FormattingHelper.formatString(ccon02so.getSzNmResource() );
    ulIdRsrcAddress = ccon02so.getUlIdRsrcAddress();
    szNmPersonFull = FormattingHelper.formatString(ccon02so.getSzNmPersonFull() );
    cIndCntrctBudgLimit = ("Y".equals(FormattingHelper.formatString(ccon02so.getCIndCntrctBudgLimit())) ) ? "true" : "false";
    cIndCntrctedResource = ("Y".equals(FormattingHelper.formatString(ccon02so.getCIndCntrctedResource())) ) ? "true" : "false";
  }

  if ( ccon05so == null )
  {
    ccon05so = new CCON05SO();
  }

  if ( ccon07so == null )
  {
    ccon07so = new CCON07SO();
    //showTransferHLink = false;
  }

  // Null catch for ROW objects, if not null get rows
  // Null catch ccon02so
  if ( ccon02so.getROWCCON02SOG00_ARRAY() != null )
  {
    rowccon02sog00_array = ccon02so.getROWCCON02SOG00_ARRAY();
  }


  if (rowccon02sog00_array == null)
  {
    rowccon02sog00_array = new ROWCCON02SOG00_ARRAY();
  }

  // Null catch for ccon05so
  if ( ccon05so.getROWCCON05SOG00_ARRAY() != null )
  {
    contractPeriodArray = ccon05so.getROWCCON05SOG00_ARRAY();
  }
  else
  {
    contractPeriodArray = new ROWCCON05SOG00_ARRAY();
  }

  // Null catch for ccon07so
  if ( ccon07so.getROWCCON07SOG00_ARRAY() != null )
  {
    contractVersionArray = ccon07so.getROWCCON07SOG00_ARRAY();
  }
  else
  {
    contractVersionArray = new ROWCCON07SOG00_ARRAY();
  }

  //Local Variables
  //int periodTotal = contractPeriodArray.getROWCCON05SOG00Count();
  //int versionTotal = contractVersionArray.getROWCCON07SOG00Count();

  

  //Declare and initialize display variables for Contract Period List and Veriosn List sections
  //int ulNbrCnperPeriod = 0;
  //int ulNbrlegalIdentifier = 0;
  //String dtDtCnperClosure = "";
  //String dtDtCnperStart = "";
  //String dtDtCnperTerm = "";
  //String szCdCnperStatus = "";
  //String cIndCnperRenewal = "0";
  //String cIndCnperSigned = "0";
  //int ulNbrCnverVersion = 0;
  //int ulIdCnver = 0;
  //String dtDtCnverEffective = "";
  //String dtDtCnverEnd = "";
  //String dtDtCnverCreate = "";
  //int ulNbrCnverNoShowPct = 0;
  //String cIndCnverVerLock = "";
  //String szTxtCnverComment = "";


  //If the output object is not null (modify or view mode), use it to set the display variables
  //if ( contractPeriodRow != null)
  //{
    //dtDtCnperClosure = FormattingHelper.formatDate(contractPeriodRow.getDtDtCnperClosure() ) ;
    //dtDtCnperStart = FormattingHelper.formatDate(contractPeriodRow.getDtDtCnperStart() );
    //dtDtCnperTerm = FormattingHelper.formatDate(contractPeriodRow.getDtDtCnperTerm() );
    //szCdCnperStatus = FormattingHelper.formatString(contractPeriodRow.getSzCdCnperStatus() );
    //cIndCnperRenewal = FormattingHelper.formatString(contractPeriodRow.getCIndCnperRenewal() );
    //cIndCnperSigned = FormattingHelper.formatString(contractPeriodRow.getCIndCnperSigned() );
    //ulNbrCnperPeriod = contractPeriodRow.getUlNbrCnperPeriod() ;
    // Sir#23430 - Added a legal identifier field for contracts.
    //ulNbrlegalIdentifier = contractPeriodRow.getUlNbrLegalIdentifier() ;

  //}

  //if (ccon02so != null)
  //{
        
  //}

  //if (contractVersionRow != null)
  //{
    //ulNbrCnverVersion = contractVersionRow.getUlNbrCnverVersion();
    //ulIdCnver = contractVersionRow.getUlIdCnver();
    //dtDtCnverEffective = FormattingHelper.formatDate(contractVersionRow.getDtDtCnverEffective() );
    //dtDtCnverEnd = FormattingHelper.formatDate(contractVersionRow.getDtDtCnverEnd() );
    //dtDtCnverCreate = FormattingHelper.formatDate(contractVersionRow.getDtDtCnverCreate() );
    //ulNbrCnverNoShowPct = contractVersionRow.getUlNbrCnverNoShowPct();
    //cIndCnverVerLock = FormattingHelper.formatString(contractVersionRow.getCIndCnverVerLock() );
    //szTxtCnverComment = FormattingHelper.formatString(contractVersionRow.getSzTxtCnverComment() );
  //}

  if ( request.getAttribute("txtUlIdResource") != null )
  {
    ulIdResource =  (String)request.getAttribute("txtUlIdResource");
  }

  if ( request.getAttribute("txtNmResource")!= null )
  {
    szNmResource = (String)request.getAttribute("txtNmResource");
  }

  //  Null check the object in the request
  if (request.getAttribute( StaffSearchInput.STAFF_PULL_BACK ) != null)
  {
    //  Create an instance of the array to use on your page
    ROWCCMN50DO_ARRAY ccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute( StaffSearchInput.STAFF_PULL_BACK );
    Enumeration e = ccmn50do_array.enumerateROWCCMN50DO();
    while ( e.hasMoreElements() )
    {
      ROWCCMN50DO staff = (ROWCCMN50DO)e.nextElement();
      ulIdCntrctManager = staff.getUlIdPerson();  // Not used but may need to be if a service is called to get the manager name
      szNmPersonFull = staff.getSzNmPersonFull();
    }
  }
%>
  <%-- Hidden Fields --%>
  <%-- Holds Period number to be sent to Period Detail Page for field population --%>
  <impact:validateInput type="hidden" name="hdnContractPeriod" value="<%= hdnContractPeriodParam %>"/>
  <impact:validateInput type="hidden" name="hdnContractVersion" value=""/>
  <impact:validateInput type="hidden" name="hdnLoopCount" value=""/>
  <impact:validateInput type="hidden" name="hdnBudgetTransferPressed"/>
  <impact:validateInput type="hidden" name="destinationUrl" value="/financials/Contracts/setResource"/>
  <impact:validateInput type="hidden" name="hdnPeriodForVersion"/>
  <impact:validateInput type="hidden" name="hdnDeleteAction" value="D"/>
  <impact:validateInput type="hidden" name="hdnIndValidate" value="<%= indValidate %>"/>
  <%-- Javascript function that is called in the display method and puts period number into a hidden field--%>
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

  function isPreviousVersionLocked()
  {
    if (<%= (request.getAttribute(ContractsConversation.VERSION_NOT_LOCKED) == null) %>)
    {
      return true;
    }
    else
    {
    alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_CON_VERSION_UNLOCK)%>");
    return false;
    }
  }

  function submitPeriodNumber(periodNumber)
  {
    document.frmContractHeader.hdnContractPeriod.value = periodNumber;
    disableValidation('frmContractHeader');
    submitValidateForm( "frmContractHeader", "/financials/Contracts/displayContractPeriod" );
  }

  function submitVersionNumber(loopCount)
  {
    document.frmContractHeader.hdnLoopCount.value = loopCount;
    disableValidation('frmContractHeader');
    submitValidateForm( "frmContractHeader", "/financials/Contracts/displayContractVersion" );
  }

  function periodForVersion(PeriodNumberVersion, signedOrUnsigned)
  {
    document.frmContractHeader.hdnPeriodForVersion.value = PeriodNumberVersion;
    document.frmContractHeader.hdnContractPeriod.value = PeriodNumberVersion;
    document.frmContractHeader.hdnSignedOrUnsigned.value = signedOrUnsigned;
  }
  /* Use this fonction to reload the page only if page is in view Mode */
  function periodForVersionView()
  {
   submitValidateFormNoBypass( "frmContractHeader", "/financials/Contracts/displayContractHeader" );
  }

  function cancelValidation()
  {
    disableValidation('frmContractHeader');
  }

  function confirmBudgetLimitSave()
  {
    if (<%=PageModeConstants.NEW.equals(PageMode.getPageMode(request))%>)
  {
    return confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_CHK_BUDGET_LIMIT)%>");
  }
  else
  {
    return true;
  }
  }
  //SIR 17733 -- The Transfer Hyperlink will only display if a user is in edit mode
  //and the Budget Limit checkbox is checked.  The user must select a Period
  //number that populates some information needed for the Budget Transfer hyperlink.
  //Since the page must re-display to populate the Version, the Budget Transfer
  //hyperlink will only dispaly after the page reloads and if user is in edit mode
  //and the Budget Limit checkbox is checked.
  function determineTranferAccess()
  {
    if (((<%=PageModeConstants.NEW.equals(PageMode.getPageMode(request))%>) &&
          document.frmContractHeader.cbxCIndCntrctBudgLimit.checked != true) ||
         (<%=!"Y".equals( ccon02so.getCIndCntrctBudgLimit() )%>) )
    {
      alert ("<%=MessageLookup.getMessageByNumber(Messages.MSG_CANNOT_OPEN_TRANSFER)%>");
    }
    else
    {
      document.frmContractHeader.hdnBudgetTransferPressed.value="true";
      submitValidateForm( "frmContractHeader", "/financials/Contracts/displayBudgetTransfer" );
    }
  }

  function displayContractServiceList()
  {
    if(setLineItemNumbers())
    {
      submitValidateForm( "frmContractHeader", "/financials/Contracts/displayContractServiceList" );
    }

  }

  function submitDates( loopCount, effDate, endDate, cbkLockedorUnlocked, versionNumber )
  {
    document.frmContractHeader.hdndtDtCncntyEffective.value = effDate;
    document.frmContractHeader.hdndtDtCncntyEnd.value = endDate;
    document.frmContractHeader.hdnLockedorUnLocked.value = cbkLockedorUnlocked;
    document.frmContractHeader.hdnLoopCount.value = loopCount;
    document.frmContractHeader.hdnContractVersion.value = versionNumber;
  }
  
  function verifyVersionSelected() {
    var version = document.frmContractHeader.hdnContractVersion.value;
    if(version == null || version == "") {
      alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
      return false;
    }
    return true;
  }

  function budgetLimit( budgetLimitCbx )
  {
    document.frmContractHeader.hdnContractBudgetLimit.value = budgetLimitCbx;

  }

  function confirmDelete()
  {
    if (confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  //Fix messages
  function validateResourceId()
  {
    var cont = true;
    var resourceId = frmContractHeader.txtUlIdResource.value;
    if ( resourceId == "" )
    {
      alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_ARC_CONSTR_ID)%>");
      cont = false;
    }
    else if ( isNaN( resourceId ) )
    {
      alert("<%=MessageLookup.getMessageByNumber(Messages.SSM_CON_RESOURCE_INVALID)%>");
      cont = false;
    }
    else if ( resourceId > <%= Integer.MAX_VALUE %> )
    {
      alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_ARC_CONSTR_ID)%>");
      cont = true;
    }
    return cont;
  }

  function submitContractList()
  {
    document.frmContractHeader.hdndtDtCncntyEffective.value = "";
  }

  function setLineItemNumbers()
  {

    if (document.frmContractHeader.hdnContractPeriod.value == "" ||
        document.frmContractHeader.hdnContractVersion.value == "" )
    {
      alert("<%=MessageLookup.getMessageByNumber(Messages.MSG_CON_VER_NOT_SEL)%>");
      return false;
    }
      return true;
  }
</script>

<%-- hidden field --%>
<impact:validateInput type="hidden" name="hdnTxtUlIdCntrctManager" value="<%= String.valueOf( ulIdCntrctManager )  %>"/>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
     <td align="right">
         <% /* Use descriptive IDs for your Table and Tag identifiers :
         Javascript code would be better inside a function that is called from here,
         but for ease of use I have put the code here */ %>
            <a href="#" onClick="expandAll();">Expand All</a>&nbsp;
            <a href="#" onClick="collapseAll();">Collapse All</a>&nbsp;
     </td>
  </tr>
</table>
<% /* Begin Main Table */ %>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="5">Resource Information</th>
  </tr>
  <tr>
    <td>
      <impact:validateInput required="true"
                            type="text"
                            label="Resource ID"
                            constraint="ID"
                            name="txtUlIdResource"
                            cssClass="formInput"
                            value="<%= ulIdResource %>"
                            size="30"
                            maxLength="50"
                            tabIndex="<%= tabIndex++ %>"
                            editableMode="<%= EditableMode.NEW %>"
                            onChange="frmContractHeader.hdnIndValidate.value = 'N'" />
    </td>
    <td colspan="2">
      <impact:ButtonTag  name="btnResource"
                         img="btnSelectResource"
                         form="frmContractHeader"
                         function="disableValidation('frmContractHeader');"
                         action="/financials/Contracts/searchResource"
                         tabIndex="<%= tabIndex++ %>"
                         editableMode="<%= EditableMode.NEW %>"/>

      <impact:ButtonTag  function="disableValidation('frmContractHeader');return validateResourceId();"
                         name="btnValidate"
                         img="btnValidate"
                         form="frmContractHeader"
                         action="/financials/Contracts/validateHeader"
                         tabIndex="<%= tabIndex++ %>"
                         editableMode="<%= EditableMode.NEW %>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateDisplayOnlyField name="txtSzNmResource"
                                       label="Resource Name"
                                       value="<%=szNmResource%>" />
    </td>
  </tr>
  <tr>
    <td colspan="5">
      <table width="100%" cellspacing="0" cellpadding="3" border="0" class="tableBorder">
        <tr>
          <th class="thList">&nbsp;</th>
          <th class="thList">Vendor ID</th>
          <th class="thList">Address Line 1</th>
        </tr>
<%
  int loopCount = 0;
  int loopCountVendor = 0;
  Enumeration vendorEnumeration = rowccon02sog00_array.enumerateROWCCON02SOG00();
  if ( !vendorEnumeration.hasMoreElements() )
  {
%>
        <tr class="odd">
          <td colspan="7">
          <%= MessageLookup.getMessageByNumber( Messages.MSG_NO_ROWS_RETURNED ) %>
          </td>
        </tr>
<%
  }
  else
  {
    boolean checked = false;

    while( vendorEnumeration.hasMoreElements() )
    {
      vendorRow = (ROWCCON02SOG00) vendorEnumeration.nextElement();
      checked = ( vendorRow.getUlIdRsrcAddress() == ulIdRsrcAddress );
    if ( checked )
    {
      buttonSelected = true;
    }
%>
    <tr class="<%=FormattingHelper.getRowCss( loopCountVendor + 1 )%>" valign="top">
    <td>
      <impact:validateInput type="radio"
                            checked="<%=String.valueOf(checked)%>"
                            tabIndex="<%= tabIndex++ %>"
                            name="rbVendor"
                            value="<%= String.valueOf( loopCountVendor ) %>"/>
    </td>
    <td>
      <%= FormattingHelper.formatString(vendorRow.getSzNbrRsrcAddrVid()) %>
    </td>
    <td>
      <%= FormattingHelper.formatString(vendorRow.getSzAddrRsrcAddrStLn1()) %>
    </td>
  </tr>
<%
  loopCountVendor++;
    } // end while
  }
%>
  </table>
</td>
</tr>
<tr>
  <th colspan="5">Contract Information</th>
</tr>
<tr>
   <td>
     <impact:validateDisplayOnlyField
                                      name="txtUlIdCntrctManager"
                                      label="Contract Manager"
                                      value="<%= szNmPersonFull %>" />
   </td>
   <td>
     <impact:ButtonTag  function="disableValidation('frmContractHeader'); "
                        name="btnStaff"
                        img="btnSelectStaff"
                        form="frmContractHeader"
                        action="/financials/Contracts/searchStaff"
                        tabIndex="<%= tabIndex++ %>"/>
   </td>
<%
  // assemble the dropdown list of exclude options for the function types
  // based on the user's security attributes
  Collection<String> excludedFunctions = new ArrayList<String>();
  //always exclude APS
  excludedFunctions.add("APS");

  if ( !user.hasRight( UserProfile.SEC_CPS_POS_CONTRACT ) )
  {
    excludedFunctions.add("CPS");
  }

  if ( !user.hasRight( UserProfile.SEC_FAD_CONTRACT ) )
  {
    excludedFunctions.add("FAD");
  }

  if ( !user.hasRight( UserProfile.SEC_FAC_CONTRACT ) )
  {
    excludedFunctions.add("FAC");
  }

  if (PageModeConstants.VIEW.equals(PageMode.getPageMode(request)))
  {
%>
   <td>
     <impact:validateSelect required="true"
                            label="Function Type"
                            name="selSzCdCntrctFuncType"
                            value="<%= szCdCntrctFuncType %>"
                            tabIndex="<%= tabIndex++ %>"
                            codesTable="<%= CodesTables.CCONFUNC %>" />
   </td>
<%
  }
  else
  {
%>
  <td>
     <impact:validateSelect excludeOptions="<%= excludedFunctions %>"
                            blankValue="true"
                            required="true"
                            label="Function Type"
                            name="selSzCdCntrctFuncType"
                            value="<%= szCdCntrctFuncType %>"
                            tabIndex="<%= tabIndex++ %>"
                            codesTable="<%= CodesTables.CCONFUNC %>"
                            editableMode="<%= EditableMode.NEW %>"/>
  </td>
<%
  }
%>
 </tr>
 
 <%
// assemble for the dropdown list of regions from the regions this user
// is able to maintain according to their security priviledges.
// we do this instead of using an exclude list, because the region codes
// from the user are 3 digit, and the region codes in the drop down table
// need to be 2 digit. The conversion between them is one way, so we cannot
// ask the user if its 3 digit codes match the 2 digit codes from the table,
// but we can use the user object's 3 digit codes to create 2 digit codes for
// the dropdown box.
  //Collection accessRegions = user.getAllAccessRegions();
  //Iterator regionIterator = accessRegions.iterator();
  //Collection regionMappings = user.getUserMaintainedRegionsAsOptions(true);
  //boolean currentValAvailToUser = false;

  // cycle through the regions the user has access to...
  //while ( regionIterator.hasNext() )
  //{
  //  String region = FormattingHelper.convertRegionCode( (String) regionIterator.next() );
  //  String regionCode = Lookup.simpleDecodeSafe( CodesTables.CREGIONS, region );
    // ...and if the region code is in the decode table...
  //  if ( StringHelper.isValid( region ) && StringHelper.isValid( regionCode ) )
  //  {
      // ...create a mapping and add it to the list of mappings
  //    Mapping m = new CodeAttributes( CodesTables.CREGIONS, region, regionCode );
  //    regionMappings.add( m );
  //  }
  //  if (region.equals(szCdCntrctRegion))
  //  {
  //    currentValAvailToUser = true;
  //  }
  //}
%> 
 <tr>
   <td>
      <impact:validateSelect required="true"
                             label="Procurement Type"
                             name="selSzCdCntrctProcureType"
                             value="<%= szCdCntrctProcureType %>"
                             tabIndex="<%= tabIndex++ %>"
                             codesTable="CCONPROC"/>
   </td>
   <td>&nbsp;
   </td>
<%
   if (pageMode.equals(PageModeConstants.VIEW))
   {
%>
   <td>
     <impact:validateSelect blankValue="false"
                            required="true"
                            label="Region"
                            name="selSzCdCntrctRegion"
                            value="<%= szCdCntrctRegion %>"
                            tabIndex="<%= tabIndex++ %>"
                            codesTable="CREGIONS"/>
   </td>
<%
   }
   else
   {
     Collection<CodeAttributes> regionOptions = user.getUserMaintainedRegionsAsOptions(false);
     if(!ContractsConversation.optionsContainsCode(regionOptions, szCdCntrctRegion)) {
       szCdCntrctRegion = "";
     }
%>
   <td>
     <impact:validateSelect blankValue="true"
                            required="true"
                            label="Region"
                            name="selSzCdCntrctRegion"
                            value="<%= szCdCntrctRegion %>"
                            tabIndex="<%= tabIndex++ %>"
                            options="<%= regionOptions %>"
                            editableMode="<%= EditableMode.NEW %>"/>
   </td>
   </tr>
<%
   }
%>
 <tr>
    <td>
     <impact:validateInput type="checkbox"
                           checked="<%=cIndCntrctBudgLimit %>"
                           name="cbxCIndCntrctBudgLimit"
                           value="Y"
                           tabIndex="<%= tabIndex++ %>"
                           cssClass="formInput"
                           editableMode="<%= EditableMode.NEW %>"/>&nbsp;
     Budget Limit
    </td>
    <td>&nbsp;</td>
    <td>
     <impact:validateInput type="checkbox"
                           checked="<%=cIndCntrctedResource %>"
                           name="cbxCIndCntrctedResource"
                           tabIndex="<%= tabIndex++ %>"
                           cssClass="formInput"
                           editableMode="<%= EditableMode.NEW %>"/>&nbsp;
     Contracted Resource
   </td>

<%

  String contractBudgetLimit = "";

  if("true".equals(cIndCntrctBudgLimit))
  {
    contractBudgetLimit = "Y";
  }
  else
  {
    contractBudgetLimit = "N";
  }

%>
</tr>
</table>
<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <td>
      <impact:ButtonTag name="btnSave"
                        img="btnSave"
                        form="frmContractHeader"
                        function="return confirmBudgetLimitSave()"
                        action="/financials/Contracts/saveContractHeader"
                        align="right"
                        restrictRepost="true"
                        tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<br>
<% /* End Detail */ %>

<% // SIR 18509 -- Do not display expandable sections if we are in new mode.
if (!pageMode.equals( PageModeConstants.NEW ))
{
      String isClosed = "false";%>
<% /*  Begin Expandable Section with List Table Contract Period List */ %>
<impact:ExpandableSectionTag anchor="test"
                             name="ListTable"
                             id="rbAddressIndex1_0"
                             label="Contract Period List"
                             tabIndex="<%= tabIndex++ %>">
  <div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
    <table width="100%" cellspacing="0" cellpadding="3" border="0">
      <tr>
        <th class="thList">&nbsp;</th>
        <th class="thList">Period</th>
        <th class="thList">Start</th>
        <th class="thList">End</th>
        <th class="thList">Early Termination</th>
        <th class="thList">Status</th>
        <th class="thList">Renew</th>
        <th class="thList">Signed</th>
      </tr>
<%
  Enumeration contractPeriodEnumeration = contractPeriodArray.enumerateROWCCON05SOG00();
  String hasRows = "Y";
  if ( !contractPeriodEnumeration.hasMoreElements() )
  {
    hasRows = "N";
%>
  <tr class="odd">
    <td colspan="10">
    <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
    </td>
  </tr>
<%
  }
  else
  {
    loopCount = 0;
    while( contractPeriodEnumeration.hasMoreElements() )
    {
      contractPeriodRow = (ROWCCON05SOG00) contractPeriodEnumeration.nextElement();
      boolean checked = (hdnContractPeriodParam == null || "".equals(hdnContractPeriodParam)) ? false :
                        (loopCount == Integer.parseInt(hdnContractPeriodParam));
%>
  <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
  <% String radioId = "rbcontractPeriod_CLEAN" + loopCount; %>
<%
  String onClickSignedorUnsigned = "javascript:periodForVersion( '" + loopCount + "', '" + contractPeriodRow.getCIndCnperSigned() + "')";
%>
    <td>
      <impact:validateInput type="radio"
                            onClick="<%= onClickSignedorUnsigned %>"
                            id="<%= radioId %>"
                            tabIndex="<%= tabIndex++ %>"
                            name="rbcontractPeriod_CLEAN"
                            value="<%= String.valueOf( loopCount ) %>"
                            checked="<%=String.valueOf(checked)%>"
                            editableMode="<%= EditableMode.ALL %>"
                            />
    </td>

    <td>
      <a href= "javascript:submitPeriodNumber ( '<%= loopCount %>')"
                              tabIndex="<%= tabIndex++ %>"
                              onclick="window.onBeforeUnload=null;">
                              <%=String.valueOf(contractPeriodRow.getUlNbrCnperPeriod() ) %>
      </a>
    </td>
    <td>
      <%= FormattingHelper.formatDate( contractPeriodRow.getDtDtCnperStart() ) %>
    </td>

    <td>
      <%= FormattingHelper.formatDate( contractPeriodRow.getDtDtCnperTerm() ) %>
    </td>
    <td>
      <%= FormattingHelper.formatDate( contractPeriodRow.getDtDtCnperClosure() ) %>
    </td>
    <td>
      <%= contractPeriodRow.getSzCdCnperStatus() %>
      <% // SIR 18494 if any of these rows have the CLT status, do not display the
         // add pushbutton, setting a flag here.
      if ( "CLT".equals( contractPeriodRow.getSzCdCnperStatus() ))
      {
        isClosed = "true";
      }
      %>

    </td>
    <td align="center">
<%

    if( "Y".equalsIgnoreCase( contractPeriodRow.getCIndCnperRenewal() ) )
      {

%>
        <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" >
<%
      }
%>
    </td>
    <td align="center">
<%
    if( "Y".equalsIgnoreCase( contractPeriodRow.getCIndCnperSigned() ) )
      {

%>
        <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" >
<%
      }
%>
   </td>
   </tr>
<%
  loopCount++;
    } // end while
  }
%>
  </table>
</div><% /* this is where the "scrollBar" div tag ends */ %>
<table cellpadding="3" cellspacing="0" width="100%" border="0">
  <tr>
    <td>
    <%
      boolean bHasRows = "Y".equals(hasRows);
      if (bHasRows) {
    %>
      <impact:ButtonTag function="return confirmDelete()"
                        name="btnDelete"
                        img="btnDelete"
                        form="frmContractHeader"
                        action="/financials/Contracts/deleteContractPeriod"
                        navAwayCk="true"
                        align="left"
                        restrictRepost="true"
                        tabIndex="<%= tabIndex++ %>"/>
    <% } %>
    </td>
    <td width="85%">
    <%
      if (bHasRows) {
    %>
    <impact:ButtonTag   name="btnSelectPeriod"
                        img="btnSelectPeriod"
                        form="frmContractHeader"
                        action="/financials/Contracts/displayContractHeader"
                        navAwayCk="true"
                        align="right"
                        editableMode="<%=EditableMode.ALL%>"
                        tabIndex="<%= tabIndex++ %>"/>
    <% } %>
    </td>
      
    <td>
  <% if ("false".equals( isClosed ) )
    { %>
   <impact:ButtonTag name="btnAddPeriod"
                     img="btnAdd"
                     function="return isPreviousVersionLocked();"
                     form="frmContractHeader"
                     navAwayCk="true"
                     action="/financials/Contracts/displayNewContractPeriod"
                     align="right"
                     tabIndex="<%= tabIndex++ %>"/>
      <% } %>
    </td>
  </tr>
</table>
</impact:ExpandableSectionTag>
<br>
<% /* this is where the "xpandListTable" div tag ends end ESLT */ %>
<% /*  Begin Expandable Section with List Table Contract Version List */ %>
<impact:ExpandableSectionTag anchor="test1"
                             name="ListTable2"
                             id="rbAddressIndex1_2"
                             label="Contract Version List"
                             tabIndex="<%= tabIndex++ %>">
<div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <th class="thList">&nbsp;</th>
    <th class="thList">Version</th>
    <th class="thList">Effective</th>
    <th class="thList">End</th>
    <th class="thList">Create</th>
   <%-- <th class="thList">No Show %</th> --%>
    <th class="thList">Locked</th>
    <th class="thList">Comments</th>
  </tr>
<%

  Enumeration contractVersionEnumeration = contractVersionArray.enumerateROWCCON07SOG00();
  if ( !contractVersionEnumeration.hasMoreElements() )
  {
    showServicesButton = "false";
%>
  <tr class="odd">
    <td colspan="8">
       <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
    </td>
  </tr>
<%
  }
  else
  {
    showServicesButton = "true";
    loopCount = 0;
    String version = request.getParameter("txtVersion");
    while( contractVersionEnumeration.hasMoreElements() )
    {
      contractVersionRow = (ROWCCON07SOG00) contractVersionEnumeration.nextElement();
      boolean checked = (version == null || "".equals(version)) ? false :
                        (loopCount == Integer.parseInt(version));
%>
   <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
   <% String radioId = "rbcontractVersion_CLEAN" + loopCount; %>
     <td>
<%
String onClick = "javascript:submitDates( '" + loopCount + "', '" + FormattingHelper.formatDate( contractVersionRow.getDtDtCnverEffective() ) + "', '" + FormattingHelper.formatDate( contractVersionRow.getDtDtCnverEnd() ) + "', '" + contractVersionRow.getCIndCnverVerLock() + "', '" + contractVersionRow.getUlNbrCnverVersion() + "')";
%>
       <impact:validateInput type="radio"
                             id="<%= radioId %>"
                             tabIndex="<%= tabIndex++ %>"
                             name="rbcontractVersion_CLEAN"
                             value="<%= String.valueOf( loopCount )  %>"
                             checked="<%=String.valueOf(checked)%>"
                             editableMode="<%= EditableMode.ALL %>"
                             onClick="<%= onClick %>" />
     </td>
     <td>
       <a href="javascript:submitVersionNumber( '<%= loopCount %>')"
                                                 tabIndex="<%= tabIndex++ %>"
                                                 onclick="window.onBeforeUnload=null;">
                                                 <%=String.valueOf(contractVersionRow.getUlNbrCnverVersion() ) %>
       </a>
     </td>
     <td>
       <%= FormattingHelper.formatDate( contractVersionRow.getDtDtCnverEffective() ) %>
     </td>
     <td>
       <%= FormattingHelper.formatDate( contractVersionRow.getDtDtCnverEnd() ) %>
     </td>
     <td>
       <%= FormattingHelper.formatDate( contractVersionRow.getDtDtCnverCreate() ) %>
     </td>
   <td align="center">
<%
  if( "Y".equalsIgnoreCase( contractVersionRow.getCIndCnverVerLock() ) )
  {

%>
     <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" >
   </td>
<%
  }
%>
    <td>
      <%= FormattingHelper.formatString(contractVersionRow.getSzTxtCnverComment()) %>
    </td>
  </tr>
<%
  loopCount++;
    } // end while
  }
%>
</table>
</div>
  <% /* this is where the "scrollBar" div tag ends */ %>
  <table cellpadding="3" cellspacing="0" width="100%" border="0">
  <tr>
  
  
  <td>
<%
      //SIR 18210 -- If the version is equal to null, then the Service button will be hidden
      if(showServicesButton == "true")
      {
%>
  <td width="90%" class="alignRight">
    <impact:ButtonTag   name="btnServices"
                        img="btnServices"
                        form="frmContractHeader"
                        action="/financials/Contracts/displayContractServiceList"
                        navAwayCk="true"
                        editableMode="<%= EditableMode.ALL %>"
                        align="right"
                        function="return verifyVersionSelected()"
                        tabIndex="<%= tabIndex++ %>"/>
    </td>  

<%
      }
%>
  
    <td colspan="4" class="tableBG">
<%
         if ( !(hdnContractPeriodParam == null || "".equals(hdnContractPeriodParam)))
         {
%>
         <impact:ButtonTag name="btnAddVersion"
                           img="btnAdd"
                           form="frmContractHeader"
                           navAwayCk="true"
                           action="/financials/Contracts/displayNewContractVersion"
                           align="right"
                           tabIndex="<%= tabIndex++ %>"/>
<%
         }
%>
    </td>
  </tr>
</table>
</impact:ExpandableSectionTag>
<% /* this is where the "xpandListTable" div tag ends end ESLT */ %>

<%
/* SPB SIR 18313 - If none of the vendor radio buttons were selected,
   select the 1st one.  This ensures that the page does not trigger
   isDirty when the Period radio buttons and links are clicked
*/
if ( !buttonSelected && loopCountVendor > 0 )
    {
%>
  <script type="text/javascript"  language="JavaScript1.2">
  window.attachEvent('onload', check1stRadioBtn );
  function check1stRadioBtn()
  {
    var firstRbVendor = document.getElementById( "rbVendor_Id1" );
    if ( firstRbVendor != null )
    {
      firstRbVendor.checked = true;
    firstRbVendor.defaultChecked = true;
    }
  }
  </script>
<%
  }
} // END do not display if page mode is new
%>


<%--Hidden Fields that will passed to the Contract Service List jsp --%>
<impact:validateInput type="hidden" name="hdndtDtCncntyEffective" value=""/>
<impact:validateInput type="hidden" name="hdndtDtCncntyEnd" value=""/>
<impact:validateInput type="hidden" name="hdnContractBudgetLimit" value="<%= contractBudgetLimit %>"/>
<impact:validateInput type="hidden" name="hdnSignedOrUnsigned" value="<%= signedOrUnsigned %>"/>
<impact:validateInput type="hidden" name="hdnLockedorUnLocked" value=""/>

<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm> <% /* Close Validate Form Custom Tag */ %>
<script type="text/javascript"  language="JavaScript1.2">
  document.frmContractHeader.hdnBudgetTransferPressed.value="";
</script>





