<%//*  JSP Name:     RecordsCheckList
      //*  Created by:   Katy Laura
      //*  Date Created: 11/18/02
      //*
      //*  Description:
      //*  This JSP is the initial page of the RecordsCheck Conversation
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       08/06/03  Todd Reser        Added Changelog.
       10/14/04  CORLEYAN          SIR 23210 - Two new Records Check Types,
       DPS Direct Check, and FBI Exigent Check cannot be deleted.
       1/14/2005 gerryc            SIR 23242 - pass the records check id to the records
       check detail page and the criminal history detail
       page.  This records check id is used instead of the
       index to get the details out of state.
       11/08/2010                  SMS#79230: Removed Delete button  and the check boxes 
       */

      %>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC26SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>

<%BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      // The mode was set in state in the display activity method
      String pageMode = (String) state.getAttribute("pageMode", request);
      if (pageMode == null) {
        pageMode = PageModeConstants.VIEW;
      }
      // display the Results hyperlink if pageMode is Modify
      boolean bResultsDisabled = true;
      if (pageMode.equals(PageModeConstants.MODIFY)) {
        bResultsDisabled = false;
      } else {
        bResultsDisabled = true;
      }
      // display the delete button if there are rows to delete - (loopCount - count of rows which can not be deleted > 0)
      boolean bDisplayDelete = false;
      CCFC26SO ccfc26so = (CCFC26SO) state.getAttribute("CCFC26SO", request);
      ROWCCFC26SOG00_ARRAY recordsCheckListArray = null;

      if (ccfc26so == null) {
        ccfc26so = new CCFC26SO();
      }
      //null catch for row objects, if not null, get rows
      if (ccfc26so.getROWCCFC26SOG00_ARRAY() != null) {
        recordsCheckListArray = ccfc26so.getROWCCFC26SOG00_ARRAY();
      } else {
        recordsCheckListArray = new ROWCCFC26SOG00_ARRAY();
      }

      int tabIndex = 1;

      // prepare for creating a new RC row, from the central registry launch
      String showDocumentParameter = null;

      if (request.getParameter("docType") != null) {
        showDocumentParameter = "frmDocumentTag";
      }

      UserProfile user = UserProfileHelper.getUserProfile(request);
%>

<script type="text/javascript" language="JavaScript1.2">
    // begin javascript portion of central registry new row and launch
    // get the date in mm/dd/yyyy format for the new RC row from the central registry launch
  function setDates()
  {
   var today2 = new Date();
   yy = today2.getYear();
   year = (yy < 1000) ? yy + 1900 : yy;
   var dt = today2.getMonth()+1 + "/" + today2.getDate() + "/" + year;
   // set the hidden fields for pass to saveRCdetail_xa
   document.all.frmDocumentTag.selDtCompleted.value = dt;
   document.all.frmDocumentTag.selDtRequest.value = dt;
   return true;
  }  //end javascript portion of central registry new row and launch


// tell the Criminal History jsp which index of the records check rows is the dps value the user wants to see
// SIR 23242 - added the record check id to the parameters
function passFieldsToCrmnlHstry( index, dtReq, dtComp, type, id )
{
  frmRecordsCheckList.hdnIndex.value = index;
  frmRecordsCheckList.hdnType.value = type;
  frmRecordsCheckList.hdnDtReq.value = dtReq;
  frmRecordsCheckList.hdnDtComp.value = dtComp;
  frmRecordsCheckList.hdnUlIdRecCheck.value = id;
  submitValidateForm('frmRecordsCheckList', '/person/RecordsCheck/displayCriminalHistory');
}

// tell the Records Check Detail page which index of the records check rows is the dps row the user wants to see
// SIR 23242 - added the record check id to the parameters
  function passFieldsToRcrdChckDtl( index, type, dtReq, dtComp, id )
{
  frmRecordsCheckList.hdnIndex.value = index;
  frmRecordsCheckList.hdnType.value = type;
  frmRecordsCheckList.hdnDtReq.value = dtReq;
  frmRecordsCheckList.hdnDtComp.value = dtComp;
  frmRecordsCheckList.hdnUlIdRecCheck.value = id;
  submitValidateForm('frmRecordsCheckList', '/person/RecordsCheck/displayRecordsCheckDetail');
}


function addRecordsCheckList()
{
  frmRecordsCheckList.hdnPageMode.value = <%=PageModeConstants.NEW%>;
  return true;
}


function cnfrmDelete()
{
 return confirm( "<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>" );
}

</script>


<%/* Start the RecordsCheckList form*/

      try {// java script with window.onbefore used to confirm data will be lost if user exits before saving

%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

window.onload = function ()
{
  frmRecordsCheckList.hdnPageMode.value = "";
}

// set data to be used by the saveRCdetail_xa to write a new PRS History row to the records check table, part of launch report
function addPRSRecordsCheck()
{
  // if the report launched is the PRS History Check (the first option)
  // then add a PRS History Check row to the RecordsCheck List
   if ( Reports.report_CLEAN.options[1].value == Reports.report_CLEAN.value )
   {
    thisForm = document.frmRecordsCheckList;

    // get the date in mm/dd/yyyy format
    var today = new Date();
    yy = today.getYear();
    year = (yy < 1000) ? yy + 1900 : yy;
    var dt = today.getMonth()+1 + "/" + today.getDate() + "/" + year;

    // set the hidden fields
    thisForm.selCdSearchType.value= "<%= CodesTables.CCHKTYPE_20 %>";
    thisForm.selDtCompleted.value = dt;
    thisForm.selDtRequest.value = dt;
    thisForm.hdnCalledFromJavascript.value = "true";

    // submit the forms
    window.onbeforeunload=null;
    submitValidateForm( "frmRecordsCheckList", "/person/RecordsCheck/saveRecordsCheckDetail");
  }
}

</script>

<impact:validateErrors />
<impact:validateForm name="frmRecordsCheckList" method="post" action="/person/RecordsCheck/displayRecordsCheckList" validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.RecordsCheckListCustomValidation" pageMode="<%=pageMode%>"
  schema="/WEB-INF/Constraints.xsd">

  <impact:validateInput type="hidden" name="hdnIndex" value="" />
  <%/* SPB SIR 22349 - Need to propagate szCdRecCheckStatus from List through Criminal History */

        %>
  <impact:validateInput type="hidden" name="hdnType" value="" />
  <impact:validateInput type="hidden" name="hdnDtReq" value="" />
  <impact:validateInput type="hidden" name="hdnDtComp" value="" />
  <impact:validateInput type="hidden" name="hdnUlIdRecCheck" value="" />
  <%--SIR 23242 added --%>
  <impact:validateInput type="hidden" name="hdnMaxLoopCount" value="" />

  <%-- these fields are used by the addPRSRecordsCheck() javascript function --%>
  <impact:validateInput type="hidden" name="selCdSearchType" value="" />
  <impact:validateInput type="hidden" name="selDtCompleted" value="" />
  <impact:validateInput type="hidden" name="selDtRequest" value="" />
  <impact:validateInput type="hidden" name="hdnCalledFromJavascript" value="" />
  <impact:validateInput type="hidden" name="hdnPageMode" value="" />

  <%// begin pagination
    TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean) request
            .getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

    if (tuxPagination != null) {
      DatabaseResultDetails db = tuxPagination.getResultDetails();
    } else {
      tuxPagination = new TuxedoPaginationValueBean();
      DatabaseResultDetails db = new DatabaseResultDetails();
      db.setNumberOfResults(0);
      db.setResultsPerPage(10);
      db.setRequestedPage(1);
      tuxPagination.setResultDetails(db);
      request.setAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
    }

  %>
  <impact:pagination submitUrl="/person/RecordsCheck/displayRecordsCheckList">
    <%--  pagination --%>
    <%-- scroll bar --%>
    <div id="scroll" style="height:210px;width:100%;overflow:auto" class="tableBorderList">
      <%-- establish the table used to display the data returned from the service --%>
      <table border="0" cellspacing="0" cellpadding="3" width="100%">
        <tr>
          <th class="thList">
          </th>
          <th class="thList">
            Search Type
          </th>
          <th class="thList">
            Date of Request
          </th>
          <th class="thList">
            Date Completed
          </th>
          <th class="thList">
            Requested By
          </th>
          <th class="thList">
            History
          </th>
        </tr>

        <%// within the table, display the data
        //declare and initialize loop counter
        int loopCount = 0;
        int canNotDeleteCount = 0;
        //Enumerate the records check rows
        Enumeration recordsCheckListEnum = recordsCheckListArray.enumerateROWCCFC26SOG00();
        //If the enumeration is empty return NO Rows returned message
        if (!recordsCheckListEnum.hasMoreElements()) {

          %>
        <tr class="odd">
          <td colspan="7">
            <%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
          </td>
        </tr>
        <%} // else there is a least one row.  While there are more rows,
        // create a new rows and display the data

        else {
          while (recordsCheckListEnum.hasMoreElements()) { // get the next element
            ROWCCFC26SOG00 recordsCheckListRow = (ROWCCFC26SOG00) recordsCheckListEnum.nextElement();

            // create the cells and place the elements in them

            %>
        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">

          <td>
            <%// write an if to show the check box or radio button only if the type of row is other than DPS, Central Registry or PRS History
            // define a boolean to protect DPS, Central Registry and PRS History rows from deletion
            boolean bTheRowCanBeDeleted = true;
            bTheRowCanBeDeleted = false; //SMS79230 Do not need to display the check boxes at all as the delete button has been removed
            // set theRowCanBeDeleted to false if the row type is DPS/10 or Central Registry/85 or PRS HISTORY CHECK/20
            // SIR 23210 Two new records check types, FBI Exigent Check/15 and DPS Direct Check/25 cannot be deleted.
             if ( "10".equals(recordsCheckListRow.getSzCdRecCheckCheckType())
                || "20".equals(recordsCheckListRow.getSzCdRecCheckCheckType())
                || "85".equals(recordsCheckListRow.getSzCdRecCheckCheckType())
                || "15".equals(recordsCheckListRow.getSzCdRecCheckCheckType())
                || "25".equals(recordsCheckListRow.getSzCdRecCheckCheckType())) {
              bTheRowCanBeDeleted = false;
              canNotDeleteCount = canNotDeleteCount + 1;
            }

            if (bTheRowCanBeDeleted)

            { // if the row can be deleted place a checkbox on the screen- ktl ckbox name _CLEAN prevents previous and next message when a check box has been selected
              String chckBoxName = "ckName_CLEAN" + loopCount;
%>
            <impact:validateInput value="<%= String.valueOf(loopCount)%>" type="checkbox" checked="false" name="<%= chckBoxName %>" label="" cssClass="formInput" />
            <%;
            }

            %>
          </td>
          <td>
            <%/* SPB SIR 22349 - Need to propagate szCdRecCheckStatus from List through Criminal History */

            %>
            <a
              href="javascript: passFieldsToRcrdChckDtl('<%= loopCount %>','<%= FormattingHelper.formatString( recordsCheckListRow.getSzCdRecCheckStatus() ) %>', '<%= FormattingHelper.formatDate(recordsCheckListRow.getDtDtRecCheckRequest())  %>', '<%= FormattingHelper.formatDate(recordsCheckListRow.getDtDtRecCheckCompleted()) %>','<%=FormattingHelper.formatInt(recordsCheckListRow.getUlIdRecCheck())%>' )">
              <%=Lookup.simpleDecodeSafe("CCHKTYPE", recordsCheckListRow.getSzCdRecCheckCheckType())%> </a>
          </td>
          <td>
            <%=FormattingHelper.formatDate(recordsCheckListRow.getDtDtRecCheckRequest())%>
          </td>
          <td>
            <%=FormattingHelper.formatDate(recordsCheckListRow.getDtDtRecCheckCompleted())%>
          </td>
          <td>
            <%=FormattingHelper.formatString(recordsCheckListRow.getSzScrNmRequestedBy())%>
          </td>

          <td align="center">
            <%=recordsCheckListRow.getCIndRecCheckHistory().equals(ArchitectureConstants.Y) ? "<image alt=\"checkmark\" src='/grnds-docs/images/shared/checkMark_short.gif'>"
                                                                                                       : "&nbsp;"%>
          </td>
        </tr>
        <%// increment the loop counter
            loopCount++;
          } // end while
        }
        // If the loopCount is 0 or all of the rows can not be deleted, do not display the delete button
        if (loopCount - canNotDeleteCount > 0) {
          bDisplayDelete = true;
        }
        bDisplayDelete = false; //SMS#79230
        %>
      </table>
    </div>
    <%/* this is where the "scrollBar" div tag ends */

        %>
  </impact:pagination>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td class="alignLeft">
        <%if (bDisplayDelete) {

          %>
        <impact:ButtonTag name="btnDelete" img="btnDelete" restrictRepost="true" form="frmRecordsCheckList" function="return cnfrmDelete( )" action="/person/RecordsCheck/deleteRecordsCheckList" tabIndex="<%= tabIndex++ %>" />
        <%}

        %>
      </td>


      <td class="alignRight">
        <impact:ButtonTag name="btnAdd" img="btnAdd" align="right" form="frmRecordsCheckList" function="return addRecordsCheckList()" action="/person/RecordsCheck/addRecordsCheckList" tabIndex="<%= tabIndex++ %>" />

      </td>

    </tr>
  </table>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

<br />

<%
      } catch (Exception e) {
        e.printStackTrace();
        out.println(e.getMessage());
      }

    %>
