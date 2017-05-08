<%
//*
//*  JSP Name:     Payment Approval
//*  Created by:   Katy Laura
//*  Date Created: 02/28/03
//*
//*  Description:
//*  This JSP displays invoice information depending on the user's security attributes
//*  and region access
//*
//*  Change History:
//*  Date      User         SIR        Description
//*  --------  ----------    -------   -------------------------------------------
//*  5/4/2004   gerryc        15533      added sort capabilites to the approval status
//*                                    resource name, and contract id columns.
//*                                    Also used a new style - thListNoWrap to
//*                                   prevent wrapping of the sort arrow.
//*  5/22/2008  vdevarak  STGAP00004617  Added the Search criteria section to the page as per MR-012.

//*  04/08/2009 bgehlot   STGAP00013273 : Added new input field Client Person ID on the page, Removed conditionally
//*                                       required from Month field, Added UAS Codes, Added function setDefaultMonthYearADSRCS
//*  05/26/2009 bgehlot          STGAP00013906: Month field can have empty string    
//** 05/28/2009 bgehlot          STGAP00013940: Region and year field can have empty string when Cliend Id is enetered                              
//*
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN19SOG_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.PaymentApprovalConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%
  // define state
  BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //Set the page mode
  String pageMode = PageModeConstants.MODIFY;
  //STGAP00004617: Added code to enable Search functionality
  //Begin
  UserProfile user = UserProfileHelper.getUserProfile(request);
  Calendar cal = new GregorianCalendar();
  cal.setTime( new java.util.Date() );
  String contractId = ContextHelper.getStringSafe(request, "txtUlIdContract");
  String resourceId = ContextHelper.getStringSafe(request, "txtUlIdResource");
  String type = ContextHelper.getStringSafe(request, "selSzCdInvoTypeSearch");
  
  //STGAP00013273 : Added this new input field on the page
  String idClientPerson = ContextHelper.getStringSafe(request, "txtUlIdClientPerson");
  
  //STGAP00013906: Month field can have empty string
  String indSearch = "false";
  indSearch = (String) request.getAttribute( "indSearch" );
   
  if("".equals(type)){
    type = "ALL";
  }																	
  String approvalStatus = ContextHelper.getStringSafe(request, "selSzCdInvoAprvStatus");
  String region = ContextHelper.getStringSafe(request, "selSzCdCntrctRegion");
  if("".equals(region)){
    region = FormattingHelper.convertRegionCode(user.getUserRegion());
  }
  
  //STGAP00013940 : Region field can have empty string when Cliend Id is enetered
  if("".equals(ContextHelper.getStringSafe(request, "selSzCdCntrctRegion")) && "true".equals(indSearch)){
    region = ContextHelper.getStringSafe(request, "selSzCdCntrctRegion");
  }
  
  String county = ContextHelper.getStringSafe(request, "selSzCdInvoCounty");
  String invoiceMonth = "";
  String invoiceYear = "";
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
  
  // STGAP00013906: Empty string should also display
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
  //end STGAP00004617
  boolean securityClearance = user.hasRight(UserProfile.SEC_FIN_MODIFY_CPS_PAY_APPVL) &&
                              request.getAttribute(PaymentApprovalConversation.REGION_SECURITY_VIOLATION) == null;
  
     // create the output object
   CFIN19SO cfin19so = ( CFIN19SO ) state.getAttribute( "CFIN19SO", request );
    //initialize the array
   ROWCFIN19SOG_ARRAY paymentApprovalArray = null;
    //null catch
   if ( cfin19so == null )
   {
     cfin19so = new CFIN19SO() ;
   }
    //null catch for row objects, if not null, get rows
   if ( cfin19so.getROWCFIN19SOG_ARRAY() != null )
   {
     paymentApprovalArray = cfin19so.getROWCFIN19SOG_ARRAY();
   }
   else
   {
     paymentApprovalArray = new ROWCFIN19SOG_ARRAY();
   }

  // Assign tabIndex
  int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;
  // QA sweep   int idInvc = 0;
%>


<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

     // tell the Invoice page the pageMode is view for approved or disapproved invoices
 function passPageModeIdInvoice( cdInvoApproved, idInvoice )
      {
       frmPaymentApproval.hdnCdInvoApproved.value = cdInvoApproved;
       frmPaymentApproval.hdnIdInvoice.value = idInvoice;
        submitValidateForm('frmPaymentApproval', '/financials/PaymentApproval/setValuesForInvoice');
     }  
     
  //STGAP00013273 : If invoice type is selected as either Adoption Assistance or Relative Care Subsidy 
  //                then the month and year defaults to current month and year. For all other invoice type 
  //                selections the month defaults to prior month and the year defaults to the year the prior 
  //                month falls under
  function setDefaultMonthYearADSRCS()
  {
    if(frmPaymentApproval.selSzCdInvoTypeSearch.value == 'ADS' || frmPaymentApproval.selSzCdInvoTypeSearch.value == 'RCS'){
           frmPaymentApproval.txtUMoInvoMonth.value = <%=String.valueOf( month + 1 )%>; 
           frmPaymentApproval.txtUYrInvoYear.value = <%=String.valueOf( year )%>;
    }else{
        <%if ( month == 0 )
        {%>
          frmPaymentApproval.txtUMoInvoMonth.value = <%=String.valueOf( month + 12 )%>; 
          frmPaymentApproval.txtUYrInvoYear.value = <%=String.valueOf( year - 1 )%>;
       <% }
        else
        {%>
           frmPaymentApproval.txtUMoInvoMonth.value = <%=String.valueOf( month )%>; 
           frmPaymentApproval.txtUYrInvoYear.value = <%=String.valueOf( year )%>;
        <%}%>
    }
  }

//End Java Script-->
</script> 

<impact:validateErrors/>
<impact:validateForm
       name="frmPaymentApproval"
       method="post"
       action="/financials/PaymentApproval/searchPaymentApprovals"
       validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.PaymentApprovalCustomValidation"
       pageMode="<%= securityClearance ? PageModeConstants.MODIFY : PageModeConstants.VIEW %>"
       schema="/WEB-INF/Constraints.xsd">
<!--- STGAP00004617  Added the Search criteria section - Begin --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">Payment Approval</th>
  </tr>
  <tr>
    <td>
      <impact:validateInput
        type="text"
        label="Contract ID"
        constraint="ID"
        required="false"
        name="txtUlIdContract"
        cssClass="formInput"
        value="<%= contractId %>" 
        disabled="<%= String.valueOf(!securityClearance) %>"
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
        disabled="<%= String.valueOf(!securityClearance) %>"
        size="10"
        maxLength="10"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateInput
        type="text"
        label="Client Person ID"
        constraint="ID"
        name="txtUlIdClientPerson"
        cssClass="formInput"
        value="<%= idClientPerson %>"
        disabled="<%= String.valueOf(!securityClearance) %>"
        size="10"
        maxLength="10"
        conditionallyRequired="true"
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
        disabled="<%= String.valueOf(!securityClearance) %>"
        blankValue="true"
        onChange="setDefaultMonthYearADSRCS();"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateSelect
        label="Approval Status"
        required="false"
        name="selSzCdInvoAprvStatus"
        codesTable="CINVOAPV"
        contentType="<%= SelectTag.DECODES %>"
        value="<%= approvalStatus %>"
        disabled="<%= String.valueOf(!securityClearance) %>"
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
        disabled="<%= String.valueOf(!securityClearance) %>"
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
        disabled="<%= String.valueOf(!securityClearance) %>"
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
        disabled="<%= String.valueOf(!securityClearance) %>"
        size="5"
        maxLength="4"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
    <td>
      <impact:validateSelect
        label="County"
        name="selSzCdInvoCounty"
        codesTable="CCOUNT"
        value="<%= county %>"
        disabled="<%= String.valueOf(!securityClearance) %>"
        blankValue="true"
        tabIndex="<%= tabIndex++ %>"
      />
    </td>
  </tr>
</table>

<%--Search Button--%>
<% if (securityClearance) { %>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight">
      <impact:ButtonTag name="btnSearch" img="btnSearch" align="right" form="frmPaymentApproval" action="/financials/PaymentApproval/searchPaymentApprovals" tabIndex="<%= tabIndex++ %>" backSafe="false"/>
    </td>
  </tr>
</table>
<% } // Close the if to hide search button %>
<!--- STGAP00004617  Added the Search criteria section - End--->
<%-- Result Set for Invoice Search --%>
<br/>

<%
  // Check the request to see if a search has been performed, if it has display this section
  if ( request.getAttribute( "SearchPerformed" ) != null )
  {
%>
<% if(securityClearance) { %>
<impact:pagination submitUrl="/financials/PaymentApproval/searchPaymentApprovals">
<div class="alignRight"><div class="formInstruct">Scroll for more information --></div></div>
<div id="scrollBar" style="height:275;width:762px;overflow:auto" class="tableborderList">
       <table border="0" cellspacing="0" cellpadding="3" width="1000" >
         <tr>
             <th class="thList"></th>
             <th class="thList">A</th>
             <th class="thList">Invoice ID</th>
             <th class="thList">Client Name</th>
             <th class="thList">Resource Name</th>
             <th class="thList">UAS Codes</th>
             <th class="thList">Validated Amount </th>
             <th class="thList">Phase </th>
             <th class="thList">Resource ID </th>
             <th class="thList">Received Date </th>
             <th class="thList">Approval Date </th>
             <th class="thList">Contract ID</th>
             <th class="thList">Person ID</th>
         </tr>
                  <% // within the table, display the data
                    //Enumerate the payment approval rows
              Enumeration paymentApprovalEnum = paymentApprovalArray.enumerateROWCFIN19SOG();//ROWCFIN19SOG_ARRAY(); //ROWCFIN19SOG;  //ROWCFIN19SOG_ARRAY

            //If the enumeration is empty return NO Rows returned message
          if ( !paymentApprovalEnum.hasMoreElements() )
             { %>
              <tr class="odd">
                 <td colspan="10"><%= MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED) %></td>
              </tr>
               <%
             }  // else there is a least one row.  While there are more rows, create a new rows and display the data
          else
             {
               while( paymentApprovalEnum.hasMoreElements() )
                  {     // get the next element
                     ROWCFIN19SOG paymentApprovalRow = ( ROWCFIN19SOG ) paymentApprovalEnum.nextElement();
                        // create the cells and place the elements in them
                 %>
         <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="middle">
           <td>
<%
         // write an if to display the check box if the type of row is other than RJA
         // define a boolean to protect RJA rows from approval, disapproval and reset functions
           boolean bTheRowCanBeDeleted = true;
         // set theRowCanBeDeleted to false if the row type is RJA
           if ("RJA".equals(paymentApprovalRow.getSzCdInvoApproved()) )
                { bTheRowCanBeDeleted = false; }
           if ( bTheRowCanBeDeleted )
              {   // if the row can be deleted place a checkbox on the screen
            String chckBoxName = "ckName_CLEAN" + loopCount ;
%>
            <impact:validateInput value="<%= String.valueOf( loopCount )%>"
              type="checkbox" checked="false"
              name="<%= chckBoxName %>"
              tabIndex="<%= tabIndex++ %>"
              cssClass="formInput" />
<%
              }  // end if
%>
           </td>
           <td><%= FormattingHelper.formatString(paymentApprovalRow.getSzCdInvoApproved())%></td>
           <td>
             <a href="#" onClick="passPageModeIdInvoice('<%= paymentApprovalRow.getSzCdInvoApproved()%>', '<%= FormattingHelper.formatInt(paymentApprovalRow.getUlIdInvoInvoice())%>')">
               <%= FormattingHelper.formatInt( paymentApprovalRow.getUlIdInvoInvoice() )%>
             </a>
           </td>
           <td><%= FormattingHelper.formatString(paymentApprovalRow.getSzNmPersonFull()) %></td>
           <td><%= FormattingHelper.formatString( paymentApprovalRow.getSzNmResource() )%></td>
           <td><%= FormattingHelper.formatString( paymentApprovalRow.getSzTxtUASCodes())%></td>
           <td><%= FormattingHelper.formatMoney( paymentApprovalRow.getDAmtInvoValidAmount() )%></td>
           <td><%= FormattingHelper.formatString( paymentApprovalRow.getSzCdInvoPhase() )%></td>
           <td><%= FormattingHelper.formatInt(paymentApprovalRow.getUlIdResource()) %></td>
           <td><%= FormattingHelper.formatDate( paymentApprovalRow.getDtDtInvoReceivedDate() )%></td>
           <td><%= FormattingHelper.formatDate( paymentApprovalRow.getDtDtInvoApprovalDate() )%></td>
           <td><%= FormattingHelper.formatInt( paymentApprovalRow.getUlIdContract() )%></td>
           <td><%= FormattingHelper.formatInt( paymentApprovalRow.getUlIdPerson() )%></td>
         </tr>
         <%// increment the loop counter
               loopCount++;
             } // end while
           } //end else, end if
          %>
     </table>  <% /* end the table used to display the data returned from the service */ %>
  </div><% /* this is where the "scrollBar" div tag ends */ %>
</impact:pagination>


<br/>
<%  // place the add and delete buttons within a table to control alignment
 %>
 <table border="0" cellpadding="3" class="tableNoBorder" width="100%" >
    <tr>
       <td class="alignRight">
        <impact:ButtonTag
                name="btnApprove"
                img="btnApprove"
                form="frmPaymentApproval"
                action="/financials/PaymentApproval/approve"
                tabIndex="<%= tabIndex++ %>"/>

        <impact:ButtonTag
                name="btnDisapprove"
                img="btnDisapprove"
                form="frmPaymentApproval"
                action="/financials/PaymentApproval/disapprove"
                tabIndex="<%= tabIndex++ %>"/>

        <impact:ButtonTag
                name="btnReset"
                img="btnReset"
                form="frmPaymentApproval"
                action="/financials/PaymentApproval/reset"
                tabIndex="<%= tabIndex++ %>"/>
        </td>
    </tr>
   </table>
<% } 
}%>

     <%-- hidden fields used to pass invoice id and page mode to xa method --%>
   <impact:validateInput type="hidden" name="hdnCdInvoApproved" value="" />
   <impact:validateInput type="hidden" name="hdnIdInvoice" value="" />
     <%-- hidden fields used to pass to populate method for approve, disapprov and reset --%>
    <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
