<%
//*  JSP Name:     Invoice Search
//*  Created by:   Jeff Chambers
//*  Date Created: 11/13/2002
//*
//*  Description:
//*  This JSP is used to Search for Invoice Information
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  05/01/03  GRIMSHAN          SIR 17097 Moved the closing bracket around the
//**                              display list so that the add pushbutton can still
//**                              be displayed even if there are no rows returned.
//**                              Also added a condition around new using so that it
//**                              will only be displayed if there are rows returned.
//**  05/12/03  GRIMSHAN          SIR 17446 The year calculation had 1900 added to
//**                              it which is not needed.  Year should just be set
//**                              to the current calendar.getyear.
//**  08/20/03  GRIMSHAN          SIR  Chance name of selSzCdInvoType to selSzCdInvoTypeSearch
//**  02/09/04  CORLEYAN          SIR 22554 If we are in january, add 12 to the month value so that
//**                              12 of last year will display on the page.
//**  11/02/07  IMOMIO            STGAP00006231 enhancement to invoice search results including the client name
//**  04/08/2009 bgehlot          STGAP00013273 : Added new input field Client Person ID on the page, Removed conditionally
//**                              required from Month field, Added UAS Codes. Added function setDefaultMonthYearADSRCS
//**  05/26/2009 bgehlot          STGAP00013906: Month field can have empty string 
//**  05/28/2009 bgehlot          STGAP00013940: Region and year field can have empty string when Cliend Id is enetered
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN01SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN01SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN01SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>

<%
  UserProfile user = UserProfileHelper.getUserProfile( request );

  Calendar cal = new GregorianCalendar();
  cal.setTime( new java.util.Date() );

  //  Declare variables
  int tabIndex = 1;
  int loopCount = 0;
  boolean disableInvoice = true;
  String invoiceId = ContextHelper.getStringSafe(request, "txtUlIdInvoInvoice");
  String contractId = ContextHelper.getStringSafe(request, "txtUlIdContract");
  String resourceId = ContextHelper.getStringSafe(request, "txtUlIdResource");
  
  //STGAP00013273 : Added this new input field on the page
  String idClientPerson = ContextHelper.getStringSafe(request, "txtUlIdClientPerson");
  
  //STGAP00013906: Month field can have empty string
  String indSearch = "false";
  indSearch = (String) request.getAttribute( "indSearch" );
  
  String type = ContextHelper.getStringSafe(request, "selSzCdInvoTypeSearch");
  if("".equals(type)){
    type = "ALL";
  }
  String phase = ContextHelper.getStringSafe(request, "selSzCdInvoPhase");
  if("".equals(phase)){
    phase = "ALL";
  }
  String region = ContextHelper.getStringSafe(request, "selSzCdCntrctRegion");
  if("".equals(region)){
    region = FormattingHelper.convertRegionCode(user.getUserRegion());
  }
  
  //STGAP00013940 : Region field can have empty string when Cliend Id is enetered
  if("".equals(ContextHelper.getStringSafe(request, "selSzCdCntrctRegion")) && "true".equals(indSearch)){
    region = ContextHelper.getStringSafe(request, "selSzCdCntrctRegion");
  }
  
  String invoiceMonth = "";
  String invoiceYear = "";
  String county = ContextHelper.getStringSafe(request, "selCounty");
  //if("".equals(county)){
  //  county = user.getUserCounty();
  //}
  String defaultButton = "false";

  // Set to current year unless month is January, then set to Year - 1
  int month = cal.get( Calendar.MONTH );
  int year = cal.get( Calendar.YEAR );
  //STGAP00013273 : If invoice type is selected as either Adoption Assistance or Relative Care Subsidy 
  //                then the month and year defaults to current month and year. For all other invoice type 
  //                selections the month defaults to prior month and the year defaults to the year the prior 
  //                month falls under
  
   if(CodesTables.CINVSRTP_ADS.equals(type) || CodesTables.CINVSRTP_RCS.equals(type)){
    invoiceMonth = String.valueOf( month + 1 );
    invoiceYear = String.valueOf( year );
   }else{
      // We need to display the previous month from the month we are in
      // If Month is 0, then it is january.  We want to print out
      // December of last year.  Else print out the value of month.
      // Even though we want to display the previous month, the value of
      // month will be one less than the month we are in since the Calendar
      // class calculates based on January being the 0th month.
      if ( month == 0 )
      {
        invoiceMonth = String.valueOf( month + 12 );
        //SIR 17446 Remove year + 1900
        invoiceYear = String.valueOf( year - 1 );
      }
      else
      {
        invoiceMonth = String.valueOf( month );
        //SIR 17446 Remove year + 1900
        invoiceYear = String.valueOf( year );
      }
   }

   //STGAP00013906: Month field can have empty string
  if("".equals(ContextHelper.getStringSafe(request, "txtUMoInvoMonth")) && "true".equals(indSearch)){
    invoiceMonth = ContextHelper.getStringSafe(request, "txtUMoInvoMonth");
  }
  if(!"".equals(ContextHelper.getStringSafe(request, "txtUMoInvoMonth"))){
    invoiceMonth = ContextHelper.getStringSafe(request, "txtUMoInvoMonth");
  }
  
    
  //STGAP00013940 : Year field can have empty string when Cliend Id is enetered
  if("".equals(ContextHelper.getStringSafe(request, "txtUYrInvoYear")) && "true".equals(indSearch)){
    invoiceYear = ContextHelper.getStringSafe(request, "txtUYrInvoYear");
  }
  
  if(!"".equals(ContextHelper.getStringSafe(request, "txtUYrInvoYear"))){
    invoiceYear = ContextHelper.getStringSafe(request, "txtUYrInvoYear");
  }

  // Determine user access
  if ( user.hasRight( UserProfile.SEC_FIN_BROWSE_INVOICE ) || ( user.hasRight( UserProfile.SEC_FIN_MODIFY_INVOICE) )) {
    disableInvoice = false;
  }

  // If search performed is still null, set the default button to true
  if ( request.getAttribute( "SearchPerformed" ) == null)
  {
    defaultButton = "true";
  }
  else
  {
    defaultButton = "false";
  }

%>

<%
  // Get the CFIN01SO output object out of the request
  CFIN01SO cfin01so = (CFIN01SO) request.getAttribute("CFIN01SO");

  // Initialize the row and array objects
  ROWCFIN01SOG00_ARRAY invoiceArray = null;
  // Null catch for cres03so, if null set to blank (initialize)
  if ( cfin01so == null )
  {
    cfin01so = new CFIN01SO();
  }
  // Null catch for ROW objects, if not null get rows
  if ( cfin01so.getROWCFIN01SOG00_ARRAY() != null )
  {
    invoiceArray = cfin01so.getROWCFIN01SOG00_ARRAY();
  } else {
    invoiceArray = new ROWCFIN01SOG00_ARRAY();
  }
%>

<script language="JavaScript">

  function submitInvoiceSearch(invoiceId)
  {
    document.frmInvoiceSearch.hdnTxtUlIdInvoInvoice.value = invoiceId;
    submitValidateForm( "frmInvoiceSearch", "/financials/InvoiceSearch/displayInvoiceDetail" );
  }

  function addInvoice()
  {
    frmInvoiceSearchResults.hdnCReqFuncCd.value = "<%= ServiceConstants.REQ_FUNC_CD_ADD %>";
  }

  function newUsing()
  {
    var bChecked = false;
    var rs = <%= invoiceArray.getROWCFIN01SOG00Count() %>;

      if ( rs <= 1 )
      {
        if ( frmInvoiceSearchResults.rbRowsIndex.checked == false )
        {
          alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
        }
        else
        {
          bChecked = true;
        }

      } else {

        for ( var i = 0; i < rs; i++ )
        {
          if (frmInvoiceSearchResults.rbRowsIndex[i].checked)
          {
             bChecked = true;
          }
        }

        if ( bChecked == false )
        {
          alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
        }
      }
      return bChecked;
  }

  function setArrayIndex(contractId)
  {
    frmInvoiceSearch.hdnUlIdContract.value = contractId;
  }
  
  
  //STGAP00013273 : If invoice type is selected as either Adoption Assistance or Relative Care Subsidy 
  //                then the month and year defaults to current month and year. For all other invoice type 
  //                selections the month defaults to prior month and the year defaults to the year the prior 
  //                month falls under
  function setDefaultMonthYearADSRCS()
  {
    if(frmInvoiceSearch.selSzCdInvoTypeSearch.value == 'ADS' || frmInvoiceSearch.selSzCdInvoTypeSearch.value == 'RCS'){
           frmInvoiceSearch.txtUMoInvoMonth.value = <%=String.valueOf( month + 1 )%>; 
           frmInvoiceSearch.txtUYrInvoYear.value = <%=String.valueOf( year )%>;
    }else{
        <%if ( month == 0 )
        {%>
          frmInvoiceSearch.txtUMoInvoMonth.value = <%=String.valueOf( month + 12 )%>; 
          frmInvoiceSearch.txtUYrInvoYear.value = <%=String.valueOf( year - 1 )%>;
       <% }
        else
        {%>
           frmInvoiceSearch.txtUMoInvoMonth.value = <%=String.valueOf( month )%>; 
           frmInvoiceSearch.txtUYrInvoYear.value = <%=String.valueOf( year )%>;
        <%}%>
    }
  }
</script>


<impact:validateForm name="frmInvoiceSearch"
   defaultButton = "<%=defaultButton%>"
   method="post"
   action="/financials/InvoiceSearch/searchInvoiceSearch"
   pageMode="<%= PageMode.getPageMode( request ) %>"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceSearchCustomValidation"
   schema="/WEB-INF/Constraints.xsd"
   redisplayParameters="true">
<impact:validateErrors formName="frmInvoiceSearch"/>

<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="hdnTxtUlIdInvoInvoice" value=""/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value=""/>
<impact:validateInput type="hidden" name="hdnUlIdContract" value=""/>

<!--- Begin Detail Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">Invoice Search</th>
  </tr>
  <tr>
    <td>
      <impact:validateInput
        type="text"
        label="Invoice ID"
        constraint="ID"
        name="txtUlIdInvoInvoice"
        cssClass="formInput"
        value="<%= invoiceId %>"
        disabled="<%= String.valueOf(disableInvoice) %>"
        size="10"
        maxLength="10"
        conditionallyRequired="true"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateInput
        type="text"
        label="Contract ID"
        constraint="ID"
        required="false"
        name="txtUlIdContract"
        cssClass="formInput"
        value="<%= contractId %>"
        disabled="<%= String.valueOf(disableInvoice) %>"
        size="10"
        maxLength="10"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateInput
        type="text"
        label="Resource ID"
        constraint="ID"
        required="false"
        conditionallyRequired="false"
        name="txtUlIdResource"
        cssClass="formInput"
        value="<%= resourceId %>"
        disabled="<%= String.valueOf(disableInvoice) %>"
        size="10"
        maxLength="10"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>

  <tr>
    <td>
      <impact:validateSelect
        label="Type"
        required="false"
        name="selSzCdInvoTypeSearch"
        blankValue="false"
        codesTable="CINVSRTP"
        contentType="<%= SelectTag.DECODES %>"
        value="<%= type %>"
        disabled="<%= String.valueOf(disableInvoice) %>"
        blankValue="true"
        tabIndex="<%= tabIndex++ %>"
        onChange="setDefaultMonthYearADSRCS();"
      />
    </td>
    <td>
      <impact:validateSelect
        label="Phase"
        required="false"
        name="selSzCdInvoPhase"
        codesTable="CINVSRCH"
        contentType="<%= SelectTag.DECODES %>"
        value="<%= phase %>"
        disabled="<%= String.valueOf(disableInvoice) %>"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <%-- ******** options needs to be a collection of CodeAttributes (code and decode values) ******** --%>
    <td>
      <impact:validateSelect
        label="Region"
        conditionallyRequired="true"
        name="selSzCdCntrctRegion"
        codesTable="CREGIONS"
        contentType="<%= SelectTag.DECODES %>"
        value="<%= region %>"
        disabled="<%= String.valueOf(disableInvoice) %>"
        blankValue="true"
        tabIndex="<%= tabIndex++ %>"
        options="<%= user.getUserMaintainedRegionsAsOptions(true) %>"
      />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput
        type="text"
        label="Invoice Month"
        constraint="MonthNumber"
        name="txtUMoInvoMonth"
        cssClass="formInput"
        value="<%= invoiceMonth %>"
        disabled="<%= String.valueOf(disableInvoice) %>"
        size="3"
        maxLength="2"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateInput
        type="text"
        label="Invoice Year"
        constraint="Year"
        conditionallyRequired="true"
        name="txtUYrInvoYear"
        cssClass="formInput"
        value="<%= invoiceYear %>"
        disabled="<%= String.valueOf(disableInvoice) %>"
        size="5"
        maxLength="4"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateSelect
        label="County"
        name="selCounty"
        codesTable="CCOUNT"
        value="<%= county %>"
        disabled="<%= String.valueOf(disableInvoice) %>"
        blankValue="true"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
  <tr>
    <td>
      <impact:validateInput
        type="text"
        label="Client Person ID"
        constraint="ID"
        name="txtUlIdClientPerson"
        cssClass="formInput"
        value="<%= idClientPerson %>"
        disabled="<%= String.valueOf(disableInvoice) %>"
        size="10"
        maxLength="10"
        conditionallyRequired="true"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
</table>

<%--Search Button--%>
<% if (!disableInvoice) { %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight">
      <impact:ButtonTag name="btnSearch" img="btnSearch" align="right" form="frmInvoiceSearch" action="/financials/InvoiceSearch/searchInvoiceSearch" tabIndex="<%= tabIndex++ %>" backSafe="false"/>
    </td>
  </tr>
</table>
<% } // Close the if to hide search button %>

<%-- Result Set for Invoice Search --%>
<br/>
</impact:validateForm>

<%
  // Check the request to see if a search has been performed, if it has display this section
  if ( request.getAttribute( "SearchPerformed" ) != null )
  {
%>

<impact:validateForm name="frmInvoiceSearchResults"
   defaultButton = "<%=defaultButton%>"
   method="post"
   action="/financials/InvoiceSearch/searchInvoiceSearch"
   pageMode="<%= PageMode.getPageMode( request ) %>"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.InvoiceSearchCustomValidation"
   schema="/WEB-INF/Constraints.xsd"
   redisplayParameters="true">
<impact:validateErrors formName="frmInvoiceSearchResults"/>

<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="hdnTxtUlIdInvoInvoice" value=""/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value=""/>
<impact:validateInput type="hidden" name="hdnUlIdContract" value=""/>

<impact:pagination saveState="true" submitUrl="/financials/InvoiceSearch/searchInvoiceSearch">


<!--- This is a way to use to styles.  The first one aligns right and the second formatts the text... in most cases you should only have to use one style.  If you have to do this often see Stephan and I'll create a new style for you --->
<div class="alignRight"><div class="formInstruct">Scroll for more information --></div></div>
  <div id="horizontalScrollResults" style="width:764px; height:300px; overflow:auto" class="tableborderList">
   <table width="100%" cellspacing="0" cellpadding="3" border="0">
      <tr>
         <td class="tableBG">
        <!-- div id="horizontalScrollResults" style="height:300px; width:764px; overflow:auto" class="tableborderList" -->
           <table width="1200" cellspacing="0" cellpadding="3">
             <tr>
               <th class="thList">&nbsp;</th>
               <th class="thList">Invoice ID</th>
               <th class="thList">Type</th>
               <th class="thList">Client Name</th>
               <th class="thList">Submitted Date</th>
               <th class="thList">UAS Codes</th>
               <th class="thList">Contract ID</th>
               <th class="thList">Phase</th>
               <th class="thList">Validated Amount</th>
               <th class="thList">Resource Name</th>
               <th class="thList">Resource ID</th>
               <th class="thList">Region</th>
              </tr>
<%
  Enumeration e = invoiceArray.enumerateROWCFIN01SOG00();
  boolean hasRows = false;
  //Display the results if the array is not empty
  if (!e.hasMoreElements())
  {
    //hasRows = false;
    %>
              <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                <td colspan="10"><%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED )%></td>
              </tr>
  <%
  } else {
  boolean checked = false;
  while (e.hasMoreElements()) {
  ROWCFIN01SOG00 invoiceDetail = (ROWCFIN01SOG00)e.nextElement();
  String onClick = "setArrayIndex( '" + invoiceDetail.getUlIdContract() + "')";
  hasRows = true;
  String idInvoice = FormattingHelper.formatInt(invoiceDetail.getUlIdInvoInvoice());
%>

                 <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
                    <td width="2%">
                        <impact:validateInput type="radio" name="rbRowsIndex" checked="<%= String.valueOf(checked) %>" value="<%= String.valueOf( loopCount )%>" onClick="<%= onClick %>" tabIndex="<%= tabIndex++ %>" cssClass="formInput"/>
                    </td>
                    <!-- td -->
                    <% //-- Consider this redundant security since a user should not even be able to
                       //-- access this page unless the user has the proper financial security attributes;
                       //-- even if they access the page improperly, the Search button will not display
                       //-- without proper security and thus this section would not exist on the page.
                       if (!disableInvoice) { %>
                    <td><a href="javascript:submitInvoiceSearch( '<%= idInvoice %>' )"><%= idInvoice %></a></td>
                    <% } else { %>
                    <td><%= idInvoice %></td>
                    <% } %>
                    <td><%= Lookup.simpleDecodeSafe("CINVTYPE", invoiceDetail.getSzCdInvoType()) %></td>
                    <td><%= FormattingHelper.formatString(invoiceDetail.getSzNmPersonFull()) %></td>
                    <td><%= FormattingHelper.formatDate(invoiceDetail.getDtDtInvoSubmitDate()) %></td>
                    <td><%= FormattingHelper.formatString(invoiceDetail.getSzTxtUASCodes()) %></td>
                    <td><%= FormattingHelper.formatInt(invoiceDetail.getUlIdContract()) %></td>
                    <td><%= Lookup.simpleDecodeSafe("CINVPHSE", invoiceDetail.getSzCdInvoPhase()) %></td>
                    <td><%= FormattingHelper.formatMoney(invoiceDetail.getDAmtInvoValidAmount()) %></td>
                    <td><%= FormattingHelper.formatString(invoiceDetail.getSzNmResource()) %></td>
                    <td><%= FormattingHelper.formatInt(invoiceDetail.getUlIdResource()) %></td>
                    <td><%= FormattingHelper.formatString(invoiceDetail.getSzCdCntrctRegion()) %></td>
                  </tr>
<% loopCount++; %>
<% } /* Close the while */ %>

<% /* GRIMSHAN SIR 6375 moved the close of display results section above the buttons, so that
      even when no rows are returned the add pushbutton will be displayed
   */
  } /* Close the else to display result section */%>
               </table>
       </td>
      </tr>
   </table>
   </div>
<% if ( user.hasRight( UserProfile.SEC_FIN_MODIFY_INVOICE) ) { %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>

  <% /* GRIMSHAN SIR 17097 only display new using if rows were returned from the search */
     if (hasRows)
    {%>
    <td width="90%">
      <impact:ButtonTag name="btnNewUsing" img="btnNewUsing" align="right" function="disableValidation('frmInvoiceSearchResults'); return newUsing();" form="frmInvoiceSearchResults" action="/financials/InvoiceSearch/newUsing" tabIndex="<%= tabIndex++ %>"/>
    </td>
  <% } %>
    <td width="10%">
      <impact:ButtonTag name="btnAdd" img="btnAdd" align="right" function="disableValidation('frmInvoiceSearchResults'); addInvoice()" form="frmInvoiceSearchResults" action="/financials/InvoiceSearch/addInvoice" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<% } /* Close the if to display the add button */ %>
</impact:pagination>

</impact:validateForm>
<% } /* Close the if to display results section */ %>


<!--- End Detail Table --->

