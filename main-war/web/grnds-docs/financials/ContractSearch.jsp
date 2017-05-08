<%
//*   JSP Name:     ContractSearch.jsp
//*   Created by:   Eric Dickman
//*   Date Created: 01/10/02
//*
//*
//*   The contract search window is used to enter search criteria
//*   to derive a list of contracts to populate the search results section of the page
//*   The criteria includes Contract ID, Resouce ID, Functional Type, Program Type,
//*   Region, Budget, Limit, and the From and To date ranges.
//*
//**  Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  01/10/02  Eric Dickman      Created initial docuement.
//**  06/01/02  Eric Dickman      SIR 17846 -- Added the SSM_CON_NO_VID_EXISTS
//**                              message.
//**  06/16/03  Eric Dickman      SIR 18205 -- The page will now submit when the user
//**                              clicks enter to perform a search.
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */ %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON01SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON01SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractSearchConversation" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
    CCON01SO ccon01so = (CCON01SO) request.getAttribute("CCON01SO");

    boolean showResults = true;
    // Initialize the row and array objects
    ROWCCON01SOG00_ARRAY contractSearchResultsArray = null;

    // Null catch for contractSearchResultsArray, if null set to blank (initialize)
    if ( ccon01so == null )
    {
      ccon01so = new CCON01SO();
      showResults = false;
    }

    // Null catch for ROW objects, if not null get rows
    if ( ccon01so.getROWCCON01SOG00_ARRAY() != null )
    {
      contractSearchResultsArray = ccon01so.getROWCCON01SOG00_ARRAY();
    }
    else
    {
      contractSearchResultsArray = new ROWCCON01SOG00_ARRAY();
    }

    UserProfile userProfile = UserProfileHelper.getUserProfile( request );

    //Sets page mode to Edit
    String pageMode = PageModeConstants.EDIT;

    //Sets disabledAddButton to null
    String disabledAddButton = null;

   //Sets the security on the page, when the user enters the page.
   if(((userProfile.hasRight(UserProfile.SEC_CPS_POS_CONTRACT)) ||
      (userProfile.hasRight(UserProfile.SEC_FAC_CONTRACT)) ||
      (userProfile.hasRight(UserProfile.SEC_FAD_CONTRACT))) &&
      (!userProfile.getUserMaintainedRegions().isEmpty()))
    {
      disabledAddButton =  "false";
    }
    else
    {
      disabledAddButton = "true";
    }
%>
<%
    //Remove Checkbox Default Defect 4462.
    //Setting variables to hold the values in the textbox, drop down menu and checkboxes after the Search_xa is performed.
    String budgetLimitChecked = "false";
    //String programType = "";
    String resourceId = "";
    String contractId = "";
    String fromDate = "";
    String toDate = "";
    String functionType = "";
    String region = "";
    String county = "";

  // Exclude APS POS from the selection
  List<String> excludeOptions = new ArrayList<String>();
  if ( !PageModeConstants.VIEW.equals( pageMode ) )
  {
    excludeOptions.add( CodesTables.CCONFUNC_APS );
  }




// Check the hidden field to detrmine where to assign the variables from
if ( request.getParameter("hdnPageLoad") != null )
{
    // budget limit checkbox
    if ( request.getParameter("cbxIndCntrctBudgLimit") != null )
    {
      budgetLimitChecked = "true";
    }
    else
    {
      budgetLimitChecked = "false";
    }

    //resource id
    if (StringHelper.isValid(request.getParameter("txtIdResource")))
    {
    resourceId = request.getParameter("txtIdResource");
    }

    //program type
    //if (StringHelper.isValid(request.getParameter("selCdCntrctProgramType")))
    //{
    //  programType = request.getParameter("selCdCntrctProgramType");
    //}

    //contract id
    if (StringHelper.isValid(request.getParameter("txtIdContract")))
    {
      contractId = request.getParameter("txtIdContract");
    }

    //region
    if (StringHelper.isValid(request.getParameter("selCdCntrct")))
    {
      region = request.getParameter("selCdCntrct");
    }

    //county
    if (StringHelper.isValid(request.getParameter("selCdCounty")))
    {
      county = request.getParameter("selCdCounty");
      
    }

    //function type
    if (StringHelper.isValid(request.getParameter("selCdCntrctRegion")))
    {
      functionType = request.getParameter("selCdCntrctRegion");
    }

    //from date
    if (StringHelper.isValid(request.getParameter("txtDtCnperStart")))
    {
      fromDate = request.getParameter("txtDtCnperStart");
    }

    //to date
    if (StringHelper.isValid(request.getParameter("txtDtCnperTerm")))
    {
      toDate = request.getParameter("txtDtCnperTerm");
    }
}


    int tabIndex = 1;
    int loopCount = 0;
    //String radioId = "";
%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript"  language="JavaScript1.2">

  //Forwards the user to the Contract Header page via the add push button or
  // the hyperlink in the pagination section.
  function submitContractID(contractID) {
    document.frmContractSearch.hdnContractID.value = contractID;
    submitValidateForm('frmContractSearch', '/financials/ContractSearch/forwardContractHeader');
  }
</script>
<%
//  SIR 18205 -- The page will now submit when the user clicks enter (on the keyboard) to perform a search.
%>
<impact:validateForm name="frmContractSearch"
  method="post"
  defaultButton="<%= String.valueOf(!showResults) %>"
  action="/financials/ContractSearch/displayContractSearch"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.ContractSearchCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">
<impact:validateErrors formName="frmContractSearch"/>

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
<input type="hidden" name="hdnPageLoad" value="Y">
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborder">
  <tr>
    <th colspan="6">
      Contract Search
    </th>
  </tr>
  <tr>
    <td>
      <impact:validateInput type="text" label="Contract ID" constraint="ID" conditionallyRequired = "true" name="txtIdContract" value="<%= contractId %>" size="10" maxLength="10" tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td>
      <impact:validateSelect label="Region" name="selCdCntrct" tabIndex="<%= tabIndex++ %>" codesTable="CREGIONS" value="<%= region %>"/>
    </td>
    <td>
    <impact:validateSelect label="County" name="selCdCounty" tabIndex="<%= tabIndex++ %>" codesTable="CCOUNT" value="<%= county %>"/>
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput type="text" label="Resource ID" constraint="ID" conditionallyRequired = "true" name="txtIdResource" value="<%= resourceId %>" size="10" maxLength="10" tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td>
      <impact:validateSelect label="Function Type" name="selCdCntrctRegion" tabIndex="<%= tabIndex++ %>" codesTable="CCONFUNC" excludeOptions="<%= excludeOptions %>" value="<%= functionType %>"/>
    </td>
    <td>
      <impact:validateInput colspan ="2" label="Budget Limit" value="" type="checkbox" tabIndex="<%= tabIndex++ %>" name="cbxIndCntrctBudgLimit" cssClass="formInput" checked="<%=budgetLimitChecked%>" />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateDate size="10" value="<%= fromDate %>" label="From" name="txtDtCnperStart" tabIndex="<%= tabIndex++%>" constraint="Date" />
    </td>
    <td>
      <impact:validateDate size="10" value="<%= toDate %>" label="To" name="txtDtCnperTerm" tabIndex="<%= tabIndex++%>" constraint="Date" />
    </td>
  </tr>
 </table>
<table border="0" cellspacing="0" cellpadding="3" width="100%" >
  <tr>
    <td>
      <impact:ButtonTag name="btnSearch" img="btnSearch" align="right"  form="frmContractSearch" action="/financials/ContractSearch/searchContractSearch" tabIndex="<%= tabIndex++ %>" />
    </td>
  </tr>
</table>
  <%-- Hidden Fields --%>
  <impact:validateInput type="hidden" name="hdnContractID"/>
  <impact:validateInput type="hidden" name="hdnViewMode" value="<%= disabledAddButton %>"/>
</impact:validateForm>
<%
   Enumeration contractSearchResultsEnumeration = contractSearchResultsArray.enumerateROWCCON01SOG00();
   //Display the results if the array is not empty

   if (showResults)
    {
%>
<impact:validateForm name="frmContractSearchResults"
  method="post"
  defaultButton="<%= String.valueOf(!showResults) %>"
  action="/financials/ContractSearch/displayContractSearch"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">
<impact:validateErrors formName="frmContractSearchResults"/>

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
<input type="hidden" name="hdnPageLoad" value="Y">
<impact:validateInput type="hidden" name="hdnContractID"/>
<impact:validateInput type="hidden" name="hdnViewMode" value="<%= disabledAddButton %>"/>

<br>
<impact:pagination saveState="true" submitUrl="/financials/ContractSearch/searchContractSearch">
<div class="alignRight"><div class="formInstruct">Scroll for more information  --></div></div>
   <table width="100%" cellspacing="0" cellpadding="3" class="tableborder">
      <tr>
         <td class="tableBG">
     <div id="scrollBar2" style="height:300px;width:764px;overflow:auto" class="tableborderList">
         <table width="1400" cellspacing="0" cellpadding="3" border="0">
           <tr>
             <th class="thList">&nbsp;</th>
             <th class="thList">Resource Name</th>
             <th class="thList">Contract ID</th>
             <th class="thList">Vendor ID</th>
             <th class="thList">Contract Manager</th>
             <th class="thList">Region</th>
             <th class="thList">County</th>
             <th class="thList">Function Type</th>
             <th class="thList">Budget Limit</th>
             <th class="thList">Resource ID</th>
           </tr>
  <%
    //Enumerations contractSearchRow Array and prints out the search results
    loopCount = 0;
    ROWCCON01SOG00 contractSearchRow = null;

    if ( !contractSearchResultsEnumeration.hasMoreElements() )
{
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
      while( contractSearchResultsEnumeration.hasMoreElements() )
      {   
      contractSearchRow = (ROWCCON01SOG00) contractSearchResultsEnumeration.nextElement();

        
  %>
             <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
               <% //int tabindexLoop = tabIndex++;
                  //radioId = "rbAddressIndex_" + loopCount;
                  String cCode = contractSearchRow.getSzCdCntrctCounty();
                  String counties = Lookup.simpleDecodeSafe(ContractSearchConversation.COUNTY_CODES_TABLES, cCode);
                  if(counties == null || "".equals(counties)) {
                    counties = cCode;
                  }
                  String fCode = contractSearchRow.getSzCdCntrctFuncType();
               %>
               <td>
                 &nbsp;
               </td>
               <td>
                 <a href="javascript:submitContractID('<%=FormattingHelper.formatInt(contractSearchRow.getUlIdContract())%>');">
                   <%= FormattingHelper.formatString(contractSearchRow.getSzNmResource()) %></a>
               </td>
               <td>
                 <%= FormattingHelper.formatInt(contractSearchRow.getUlIdContract()) %>
               </td>
               <td>
                 <%= FormattingHelper.formatString(contractSearchRow.getSzNbrRsrcAddrVid()) %>
               </td>
               <td>
                 <%= FormattingHelper.formatString(contractSearchRow.getSzNmPersonFull()) %>
               </td>
               <td>
                 <%= FormattingHelper.formatString(contractSearchRow.getSzCdCntrctRegion()) %>
               </td>
               <td>
                 <%= counties %>
               </td>
               <td>
                 <%= Lookup.simpleDecodeSafe(ContractSearchConversation.CCONFUNC_CODES_TABLES, fCode) %>
               </td>
               <td>
                 <%= FormattingHelper.formatString(contractSearchRow.getCIndCntrctBudgLimit()) %>
               </td>
               <td>
                 <%= FormattingHelper.formatInt(contractSearchRow.getUlIdResource()) %>
               </td>
             </tr>
               <%
                    loopCount++;
       } // end while
              }
               %>
             </table>
          </div>
        </td>
      </tr>
   </table>
<% /* close pagination custom tag */ %>
</impact:pagination>



<table border="0" cellspacing="0" cellpadding="3" width="100%" >
  <tr>
    <td>
      <impact:ButtonTag name="btnAdd" img="btnAdd" align="right"  form="frmContractSearchResults" action="/financials/ContractSearch/forwardContractHeader" function="document.frmContractSearchResults.hdnContractID.value = '0'" tabIndex="<%= tabIndex++ %>" disabled="<%= disabledAddButton %>" />
    </td>
  </tr>
</table>
</impact:validateForm>
<% }  // close
%>

