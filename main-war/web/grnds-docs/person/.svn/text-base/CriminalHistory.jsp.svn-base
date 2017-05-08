<%
//*  JSP Name:     Criminal History
//*  Created by:   Katy Laura
//*  Date Created: 12/03/02
//*
//*  Description:
//*  This JSP called from the Records Check List page and the Records Check Detail
//*  using the Results hyperlink on the List page or the Results button on the Detail page
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//** 06/28/04  LAURAMC           When the status code of a DPS Criminal history is
//**                             paper only, it did not appear on the Records Check
//**                             or Criminal History pages.  SIR 22956 extends the
//**                             check on the status code to include paper only , I,
//**                             K and Q and to present a message on this JSP if found.
//**  10/13/04  CORLEYAN         SIR 23211 - If we are in set A, disable the Accept/Reject
//**                             Radio Button, comments box, and save button
//**  2/11/05   gerryc           SIR 23404 - changed the form action and pagination
//**                             to go to displayCriminalHistory instead of
//**                             resultsRecordsCheck.
//**  8/29/05  berkime           SIR 23636: added an if statment if front of the narrative tag
//**                             so that if no hit is returned then do not display the narrative
//**                             button
//**
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<% /* Import xmlstructs used on the page.  */%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails " %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC31SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC31SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>


<%    // define state
  BaseSessionStateManager state = ( BaseSessionStateManager ) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
      // initialize page mode;
  String pageMode = PageModeConstants.VIEW;
  //get mode from state;  You can come to this page only in edit/modify mode
  pageMode = ( String ) state.getAttribute( "pageMode", request );
      // recreate the output object constructed in the resultsRecordsCheck method
   //QA CCFC31SO ccfc31so = ( CCFC31SO ) request.getAttribute( "CCFC31SO" );
  CCFC31SO ccfc31so = ( CCFC31SO ) state.getAttribute( "CCFC31SO", request );
      //initialize the array
  ROWCCFC31SOG00_ARRAY resultsArray = null;
      //null catch for the aray of rows
  if ( ccfc31so == null )
      {
       ccfc31so = new CCFC31SO() ;
       }
  int count = 0;
      //null catch for row objects, if not null, get rows
  if ( ccfc31so.getROWCCFC31SOG00_ARRAY() != null )
     {
       resultsArray = ccfc31so.getROWCCFC31SOG00_ARRAY();
       count = resultsArray.getUlRowQty();
     }  else
     {
       resultsArray = new ROWCCFC31SOG00_ARRAY();
      }
    // define a row within the array
  //ROWCCFC26SOG00 recordsCheckRow = ( ROWCCFC26SOG00 ) request.getAttribute( "recordsCheckRow" );
  int index = ContextHelper.getIntSafe( request, "hdnIndex" );
    // recreate object, array and row for records_check from the request
  CCFC26SO ccfc26so = ( CCFC26SO ) state.getAttribute( "CCFC26SO", request );
  if( ccfc26so == null )
  {
    ccfc26so = new CCFC26SO();
  }
  ROWCCFC26SOG00_ARRAY listArray = new ROWCCFC26SOG00_ARRAY();
  if( ccfc26so.getROWCCFC26SOG00_ARRAY() != null )
  {
    listArray = ccfc26so.getROWCCFC26SOG00_ARRAY();
  }
  ROWCCFC26SOG00 recordsCheckRow = listArray.getROWCCFC26SOG00( index );
  if ( recordsCheckRow == null )
  {
    recordsCheckRow = new ROWCCFC26SOG00();
  }
     // define string variables for ulIdRecCheck, status of the records check, and dates requested and completed
        // for use in displaying the page and passing in hidden fields

   String txtStatus = StringHelper.getNonNullString( recordsCheckRow.getSzCdRecCheckStatus() );
   String dtRequest = FormattingHelper.formatDate( recordsCheckRow.getDtDtRecCheckRequest() );

   String dtCompleted = FormattingHelper.formatDate( recordsCheckRow.getDtDtRecCheckCompleted() );
  //Declare and initialize display variables
  // Assign table index and loop Counter
   int tabIndex = 1;
   int loopCount = 0;

  try
  {

%>
<% /*java script with window.onbefore used to confirm data will be lost if user exits before saving */%>

    <script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
    <script type="text/javascript" language="JavaScript1.2">

//  Called onUnload of page to remind user unsaved data will be lost
window.onbeforeunload = function ()
{
  IsDirty();
}

// called by onClick of Save button - verify that the user knows there a rows which have not been accepted or rejected
function checkForUnalteredRows( lpCount )
{
  var bUnchecked = "false";
  var continueWithSave = "true";
  var myForm = document.frmCriminalHistory;
  for ( var i = 0; i < lpCount; i++ )
  {
    var rb = eval("myForm.rbAcpRej" + i );

    // checking for type = radio because disabled radio button values are
    // stored in hidden fields
    if  ( (rb.type == "radio") && (!rb[0].checked ) && ( !rb[1].checked ) )
    {
      bUnchecked = "true";
      break;
    }
  }
  if ( bUnchecked == "true" )
  {
    continueWithSave = confirm( "<%= MessageLookup.getMessageByNumber( Messages.MSG_SUB_CRIMHIS_DECISION )%>" );
  }
  return continueWithSave;
} // end checkForUnalteredRows

// prior to leaving the main form, by clicking the document button, the user selected radio button ( the ulIdCrimnal History row )is set in the document button
function setNarrativeParams()
{
  if ( document.frmCriminalHistory.rbCHRow_CLEAN[0] )
  {
    for (var i = 0; i < document.frmCriminalHistory.rbCHRow_CLEAN.length; i++)
    {
      if ( document.frmCriminalHistory.rbCHRow_CLEAN[i].checked )
      {
      document.frmCriminalHistoryNarrative.pCrimHist.value = document.frmCriminalHistory.rbCHRow_CLEAN[i].value;
      //alert( document.frmCriminalHistoryNarrative.pCrimHist.value );
      break;
    }
    }
  }
  else
  {
    document.frmCriminalHistoryNarrative.pCrimHist.value = document.frmCriminalHistory.rbCHRow_CLEAN.value;
  }
} //end setNarrativeParams

// The user wants to view the documents from dps.  Verify that a row has been selected via the CH radio button
   // NOTE: When a radio button is selected, the setNarrativeParams () is called to set a ulIdCrimHist value in pCrimHist.
         // So if it is still bland, no row was identified by rb.
  function verifyPCrimHistValue()
  {
  if ( document.all.frmCriminalHistoryNarrative.pCrimHist.value == "" )
   {
    alert ( '<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_RADIO_BUTTON )%>' );
    return false;
   }
   return true;
  }
 </script>

  <impact:validateErrors/>
  <impact:validateForm
          name="frmCriminalHistory"
          method="post"
          action="/person/RecordsCheck/displayCriminalHistory"
          validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.CriminalHistoryCustomValidation"
          pageMode="<%=pageMode%>"
          schema="/WEB-INF/Constraints.xsd">
<%
  TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean)request.getAttribute( PaginationResultBean.REQUEST_ATTRIBUTE_NAME );
  if( tuxPagination != null )
  {
    DatabaseResultDetails db = tuxPagination.getResultDetails();
  }
  else
  {
    tuxPagination = new TuxedoPaginationValueBean();
    DatabaseResultDetails db = new DatabaseResultDetails();
    db.setNumberOfResults(0);
    db.setResultsPerPage(RecordsCheckConversation.PAGE_SIZE);
    db.setRequestedPage(1);
    tuxPagination.setResultDetails(db);
    request.setAttribute( PaginationResultBean.REQUEST_ATTRIBUTE_NAME, tuxPagination );
  }
%>
   <impact:pagination submitUrl="/person/RecordsCheck/displayCriminalHistory">

<%-- establish the table used to display the data returned from the service  --%>
   <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%" >
     <tr>
      <th class="thList">&nbsp;</th>
      <th class="thList">Search Name</th>
      <th class="thList">Date of Request</th>
      <th class="thList">Date Completed</th>
      <th class="thList">Status</th>
      <th class="thList">Acp/Rej</th>
      <th class="thList"><font class="formCondRequiredText">&#135;</font>Comments</th>
     </tr>
     <tr>
         <% // within the table, display the data
            //Enumerate the records check rows
          Enumeration resultsEnum = resultsArray.enumerateROWCCFC31SOG00();
          String lineCount = String.valueOf( resultsArray.getROWCCFC31SOG00Count() );
          %>
              <impact:validateInput type="hidden" name="hdnLineCount"  value="<%= String.valueOf(lineCount) %>"/>
              <impact:validateInput type="hidden" name="hdnCHArrayLength"  value="<%= String.valueOf(count) %>"/>
          <%
            //If the enumeration is empty return NO Rows returned message
      if ( !resultsEnum.hasMoreElements() )
             { %>
      <tr class="odd">
        <td>&nbsp;</td>
        <td>
        <% /* SPB SIR 22349 - Need to propagate szCdRecCheckStatus from List through Criminal History
              LAURAMC SIR 22956 - extend "O".equals (Overdue from DPS) to test for paper only, "I",
              "K" and "Q"  */ %>
          <% if ( "O".equals( request.getParameter ("hdnType") ) )
             {
           %>
            <%= MessageLookup.getMessageByNumber( Messages.MSG_DPS_CHECK_OVERDUE ) %>
          <% }
             else if ( "I".equals( request.getParameter ("hdnType") )
                         ||
                       "K".equals( request.getParameter ("hdnType") )
                         ||
                       "Q".equals( request.getParameter ("hdnType") )    )
             {
           %>
            <%= MessageLookup.getMessageByNumber( Messages.MSG_PAPER_ONLY ) %>
             <% }
             else if ( "E".equals( request.getParameter ("hdnType") ) )
             {
           %>
            <%= MessageLookup.getMessageByNumber( Messages.MSG_DPS_RESPONSE_ERROR ) %>
             <% }   else {%>
            <%= MessageLookup.getMessageByNumber( Messages.MSG_NO_HIT_RETURNED ) %>
          <% } %>
          <%  String dtReq2 = ContextHelper.getStringSafe( request, "hdnDtReq" );
              String dtComp2 = ContextHelper.getStringSafe( request, "hdnDtComp" );
              String dtReq = request.getParameter( "hdnDtReq" );
              String dtComp = request.getParameter( "hdnDtComp" ); %>
        </td>
        <td><%= dtReq %></td>
        <td colspan="4"><%= dtComp %></td>
      </tr>
     <%
             }  // else there is a least one row.  While there are more rows, create a new rows and display the data
          else
             {
               while( resultsEnum.hasMoreElements() )
                  {     // get the next element
                     ROWCCFC31SOG00 resultsRow = ( ROWCCFC31SOG00 ) resultsEnum.nextElement();
                        // create the cells and place the elements in them

     %>
     <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="center">
         <td> <%/* show a radio button*/
         boolean bCHDisabled = false;
           if ("REJ".equals(resultsRow.getSzCdCrimHistAction()) )
               {
                 bCHDisabled = true;
               }%>
               <impact:validateInput
                 tabIndex="<%= tabIndex ++ %>"
                 value="<%= String.valueOf( resultsRow.getUlIdCrimHist() )%>"
                 checked="false"
                 disabled="<%= String.valueOf( bCHDisabled )%>"
                 type="radio"
                 name="rbCHRow_CLEAN"
                 onClick="setNarrativeParams()"
                 cssClass="formInput"/>
         </td>

         <td><%= FormattingHelper.formatString( resultsRow.getSzNmCrimHistReturned() )%>
         </td>
         <td> <%= String.valueOf( dtRequest )%>
         </td>
         <td> <%= String.valueOf( dtCompleted )%>
         </td>
         <td>  <%=Lookup.simpleDecodeSafe( "CCRIMSTA", txtStatus ) %>
         </td>
<%
    boolean bAcp = false;
    boolean bRej = false;
    boolean bDis = false; // 23211

    String rbName = "rbAcpRej" + loopCount;
    String rowCommentsName = "rowComments" + String.valueOf( loopCount );

          if ("ACP".equals(resultsRow.getSzCdCrimHistAction()) )
          {
           bAcp = true;
          }
          if ("REJ".equals(resultsRow.getSzCdCrimHistAction()))
          {
            bRej = true;
          }
          // If the row has been rejected, or we are in page set A,
          // disable the Accept/Reject radio button, and the comments box.
          if (bRej || Sets.isInSet( Sets.A, request ))
          {
            bDis = true;
          }

%>
        <td>
          <table order="0" cellspacing="0" cellpadding="3"  width="100%" >
               <tr>  <impact:validateInput tabIndex="<%= tabIndex ++ %>"
                     checked="<%= String.valueOf( bAcp )%>"
                     value="ACP"
                     label="Accept" type="radio"
                     disabled="<%= String.valueOf( bDis )%>"
                     name="<%= rbName%>"
                     cssClass="formInput"/>
               </tr>

               <tr>  <impact:validateInput tabIndex="<%= tabIndex ++ %>"
                     checked="<%= String.valueOf( bRej )%>"
                     value="REJ"
                     label="Reject" type="radio"
                     disabled="<%= String.valueOf( bDis )%>"
                     name="<%= rbName %>"  cssClass="formInput"/>
               </tr>
           </table>
        </td>

       <td valign="top"><!--- Text Area Custom Tag --->
            <impact:validateTextArea name="<%= rowCommentsName%>"
                                     disabled="<%= String.valueOf( bDis )%>"
                                     colspan="2"
                                     rows="2"
                                     cols="20"
                                     tabIndex="<%= tabIndex++ %>"
                                     maxLength="300"
                                     constraint="Comments"><%= FormattingHelper.formatString( resultsRow.getSzTxtCrimHistCmnts() ) %>
            </impact:validateTextArea>
       </td>
   </tr>
         <%  loopCount++;
             } // end while
           } //end else
          %>
  </table>
     </impact:pagination>

<%  // place the save button within a table to control alignment
 %>
   <table class="alignRight" border="0" cellspacing="0" cellpadding="3"  width="100%" >
     <tr>
        <td class="alignRight">
        <impact:ButtonTag
          name="btnSave"
          img="btnSave"
          align="right"
          restrictRepost="true"
          function='<%="return checkForUnalteredRows(" + loopCount + ")"%>'
          form="frmCriminalHistory"
          action="/person/RecordsCheck/saveCriminalHistory"
          disabled="<%= Sets.isInSetStr( Sets.A , request ) %>"
          tabIndex="<%= tabIndex++ %>"/>
       </td>
     </tr>
   </table>

     <impact:validateInput type="hidden" name="ulIdRecCheck"  value="recCheckId"/>
     <impact:validateInput type="hidden" name="szTxtStatus"  value="txtStatus"/>
     <impact:validateInput type="hidden" name="dtDtRecCheckRequest"  value="dtRequest"/>
     <impact:validateInput type="hidden" name="dtDtRecCheckCompleted"  value="dtCompleted"/>
     <impact:validateInput type="hidden" name="hdnIndex"  value='<%= request.getParameter ("hdnIndex")%>'/>
     <impact:validateInput type="hidden" name="hdnCrimHistArrayLength"  value='<%= String.valueOf( loopCount )%>'/>
     <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

<% // set up to display narrative
  String displayDoc = "";
if ( state.getAttribute( "docType", request ) != null )
{
   displayDoc = ( String ) state.getAttribute( "docType", request );
} %>
<table class="alignRight" width="100%">
 <tr>
    <td>
    <%//SIR 23636 added the ifThen logic %>
    <impact:ifThen test='<%= !("N".equals(request.getParameter("hdnType"))) %>'>
    <impact:documentButton
        pageMode="<%= pageMode %>" tabIndex="<%= tabIndex++ %>">
          <impact:document
            name="frmCriminalHistoryNarrative"
            onClick="verifyPCrimHistValue();"
            displayName="DPS"
            protectDocument="false"
            checkStage="<%= GlobalData.getUlIdStage( request ) %>"
            docType="ccf12o00"
            postInSameWindow="false"
            checkForNewMode="false"
            action="/person/RecordsCheck/displayDocument"
            docExists="false">
             <impact:documentParameter name="pCrimHist" value=""/>
             <impact:documentParameter name="pPerson" value="<%= String.valueOf( GlobalData.getUlIdPerson( request ) ) %>"/>
             <impact:documentParameter name="pCase" value="<%= String.valueOf( GlobalData.getUlIdCase( request ) ) %>"/>
       </impact:document>
    </impact:documentButton>
    </impact:ifThen>
    </td>
 </tr>
</table>
<impact:showDocument document="<%= displayDoc %>"/>

<%
}  //end try
catch ( Exception e )
{
  e.printStackTrace();
  out.println( e.getMessage() );
}
%>
